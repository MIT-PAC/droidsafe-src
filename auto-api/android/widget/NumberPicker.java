package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.Widget;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Filter;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import com.android.internal.R;

public class NumberPicker extends LinearLayout {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.330 -0400", hash_original_field = "CDC94A8C72E149B8F56A2ECCE0F5829B", hash_generated_field = "6A00AC4B6A23FAEFDE0FF2E4DC66556D")

    private ImageButton mIncrementButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.330 -0400", hash_original_field = "16ED093CD569F2787F1C23E44FCD4425", hash_generated_field = "8919797DB93735517DC56DAC3932D3BA")

    private ImageButton mDecrementButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.330 -0400", hash_original_field = "C14F48486B85453A43488AE5193CF8F7", hash_generated_field = "9C0D266F19288A98A42D37200EC40143")

    private EditText mInputText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.330 -0400", hash_original_field = "7B1C5936E045E46CDC7DE29B76B9E7F4", hash_generated_field = "71F573E1A874063ABEFF604D7F39473B")

    private int mMinHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.330 -0400", hash_original_field = "C16CF8950AAD7E5F5E8D168AA605278E", hash_generated_field = "125D219AC8DBC9C1B67A62219F770498")

    private int mMaxHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.330 -0400", hash_original_field = "2FB832D2671571BF4EC0C84F8DA6AA79", hash_generated_field = "ED0C6BF081117F2A257C521DB4125AB9")

    private int mMinWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.330 -0400", hash_original_field = "C4C548A58212673838506E3498DE25A0", hash_generated_field = "538F7241A30BB30063B42E9CD336B31C")

    private int mMaxWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.330 -0400", hash_original_field = "97478DC5D8C7149868CCC53807A72C5F", hash_generated_field = "FAE2C92297C3C78F4EB9A80B09EABDB5")

    private boolean mComputeMaxWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.330 -0400", hash_original_field = "327DC1284D23313571A41B232E2678D5", hash_generated_field = "9990B8B20909CFDC9898F67C6FDD18EC")

    private int mTextSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.330 -0400", hash_original_field = "1A4708300277223FA34224C4BA423B21", hash_generated_field = "B4AB01F5C45EBC46EA14C63C779599C3")

    private int mSelectorTextGapHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.330 -0400", hash_original_field = "65C069E70C0AD49CFCFAA9D4950DC9E1", hash_generated_field = "9D634B524F57A9A167A822148025FAEE")

    private String[] mDisplayedValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.330 -0400", hash_original_field = "C996577FD89E2D9ACA600D3AF5442EB3", hash_generated_field = "F344B4C9A6EF700D43109B54646DFF70")

    private int mMinValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.330 -0400", hash_original_field = "EB798AAFC3D0D018951E684107D8CF72", hash_generated_field = "33227317DFADBDED006865404A880DAA")

    private int mMaxValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.330 -0400", hash_original_field = "CBAFE11E7BAE23358D70D54D132C3064", hash_generated_field = "1FE26AAF0F7068BF50C3FDD7D6BD850D")

    private int mValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.330 -0400", hash_original_field = "869F864F8952CB01B525214E795A5A7D", hash_generated_field = "0F0F61C7FD20796365412FDD7923438B")

    private OnValueChangeListener mOnValueChangeListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.330 -0400", hash_original_field = "0970AE3033B8F8E13936EF3E29D48B2E", hash_generated_field = "0E000F63F4EDDECD3CA33DA7CA7FEA0C")

    private OnScrollListener mOnScrollListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.330 -0400", hash_original_field = "9F70B7A1463B032732E51B2DC5F8D2E4", hash_generated_field = "C7348EA20A64E5E4153D9A81AAD67C67")

    private Formatter mFormatter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.331 -0400", hash_original_field = "413EEF7D99DC07B5EC9C5145AC0F5C28", hash_generated_field = "5475390B43BC34D0C8A978C8F9A847C2")

    private long mLongPressUpdateInterval = DEFAULT_LONG_PRESS_UPDATE_INTERVAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.331 -0400", hash_original_field = "BAA0DD0823784099A251EB0F9CA9A9EA", hash_generated_field = "274F5B87E1B8856AC1474A59D1B54533")

    private SparseArray<String> mSelectorIndexToStringCache = new SparseArray<String>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.331 -0400", hash_original_field = "8A339F6407BFD78104B48F0ECAD28E3C", hash_generated_field = "F332375D822739DC5329A72DA5BE18C9")

    private int[] mSelectorIndices = new int[] {
            Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE,
            Integer.MIN_VALUE
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.331 -0400", hash_original_field = "BA3EB1EEAD65457935945244BC382B5A", hash_generated_field = "20F4B411AF6CE39A519EBD45F26526F1")

    private Paint mSelectorWheelPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.331 -0400", hash_original_field = "A730982C8A0FA562D108C0B45C2118FA", hash_generated_field = "5CD8B3A0694C4DAD9DE6B5F7D563825B")

    private int mSelectorElementHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.331 -0400", hash_original_field = "06BC10383CC2F50633765057D3F32342", hash_generated_field = "1C64752769ECDFF4D4DADF48DFC62B2A")

    private int mInitialScrollOffset = Integer.MIN_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.331 -0400", hash_original_field = "64895DDC056DBE762EF71E643639863B", hash_generated_field = "867616A04972E32F759A945F5C8C6DE5")

    private int mCurrentScrollOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.331 -0400", hash_original_field = "69C03418900930ACA1575AFEDF095540", hash_generated_field = "A7FE0D43A8992E5853B470E81D7DC5CD")

    private Scroller mFlingScroller;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.331 -0400", hash_original_field = "B0E365F437A601CA01427FE0DB4F2E6C", hash_generated_field = "63E636A5CF531649A485C370342AD357")

    private Scroller mAdjustScroller;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.331 -0400", hash_original_field = "DB932D3A8194DC8018ABA5AC36C8D1F6", hash_generated_field = "235D804B1C18B69F2999347603A3A1E8")

    private int mPreviousScrollerY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.331 -0400", hash_original_field = "99BACC9AFE2B88FC46530BF5B507DD16", hash_generated_field = "A6929C7A4CC6DB84E0B021A11596A9A5")

    private SetSelectionCommand mSetSelectionCommand;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.331 -0400", hash_original_field = "3DEE03AFA2F5CBC86A752456233FF511", hash_generated_field = "2CCBB805FEDFC92E21EF25E3ACD258AE")

    private AdjustScrollerCommand mAdjustScrollerCommand;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.331 -0400", hash_original_field = "7EC379609ABEAA4196ADE870A50F340C", hash_generated_field = "7D45776D84FA49FF3DE5AD7BB6B6D7B3")

    private ChangeCurrentByOneFromLongPressCommand mChangeCurrentByOneFromLongPressCommand;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.331 -0400", hash_original_field = "586883B75FCB9090CFEDDD242D2E4A36", hash_generated_field = "FADCC7819944EB29C99CDA856F21DF00")

    private AnimatorSet mShowInputControlsAnimator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.331 -0400", hash_original_field = "49D2DEDB7BFF955105ECE3AE26F330CB", hash_generated_field = "32D55D7A2E6874CDD998EF34A3CF8BCE")

    private Animator mDimSelectorWheelAnimator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.331 -0400", hash_original_field = "2BB1A3C2BC0A6F74C19EF9789BDBFF6D", hash_generated_field = "05FA59074D08C75E813C9AC8A436526B")

    private float mLastDownEventY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.331 -0400", hash_original_field = "C629D869AF7F109D65ACFA526A36D0CC", hash_generated_field = "54CBBDE9743B0ECBCF94B59C2ADF715D")

    private float mLastMotionEventY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.331 -0400", hash_original_field = "F93D3947854BC4CBB41E75EE1ED0E587", hash_generated_field = "B26DD00B53AFA2DFD31DAB39D66D679A")

    private boolean mBeginEditOnUpEvent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.331 -0400", hash_original_field = "A4F05B85CDA6632955DF0B45972ABC84", hash_generated_field = "088B2EE9C72C787499D1C9756D7C9AE2")

    private boolean mAdjustScrollerOnUpEvent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.331 -0400", hash_original_field = "09CD264B06F94F0887A32BEDDD1E6DFD", hash_generated_field = "C2D0E72CEAF9BB67D06EF8A48CD873BF")

    private int mSelectorWheelState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.331 -0400", hash_original_field = "217FE873D59646EE0AC51688724FF274", hash_generated_field = "5BEE30D4541C1ECA385873E799FC4104")

    private VelocityTracker mVelocityTracker;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.331 -0400", hash_original_field = "3DFFFAD10926598D18EEC50D61DE79CA", hash_generated_field = "3B323323DD6A6BF972666D993592C670")

    private int mTouchSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.331 -0400", hash_original_field = "950A8222B535BF5159B013E5329A56C7", hash_generated_field = "19DF3CA9C4A086C5604F6C8FC7721322")

    private int mMinimumFlingVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.331 -0400", hash_original_field = "8ED13B950D5803064219CE68BB8F2695", hash_generated_field = "7F5E59D933F0155E107640D32355B310")

    private int mMaximumFlingVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.331 -0400", hash_original_field = "FC769FBB094551A074259CD0A7B6736A", hash_generated_field = "5C5871BE5B096A9BD740EB5329BEAAF1")

    private boolean mWrapSelectorWheel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.331 -0400", hash_original_field = "F761CF39D7B955BCB3910DD42D5B01E4", hash_generated_field = "0ACF9128B8830FF701248CF7C11543ED")

    private int mSolidColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.332 -0400", hash_original_field = "74EDC7A2D9E9DD81AA798FA12CD6F2A2", hash_generated_field = "DDEBF599D1C277FAE44436DE5F4925D9")

    private boolean mFlingable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.332 -0400", hash_original_field = "8FE4EFD51BBB41AB331239B6AFD59E58", hash_generated_field = "05188C781C0BE6F065277E3B64526E24")

    private Drawable mSelectionDivider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.341 -0400", hash_original_field = "86F82F4DE5B91E41E99B4154A931CF58", hash_generated_field = "8270882201C05EAC24EEFCE46B4DEF7E")

    private int mSelectionDividerHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.341 -0400", hash_original_field = "DF43B278CEE8933271AB3D9F9E312F86", hash_generated_field = "AFFA54D19F07A10EE8847CF76FC95323")

    private Rect mTempRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.341 -0400", hash_original_field = "AB5FDA655F30463AF2CEB79B3A8271FF", hash_generated_field = "67AD5A07D54DA7533142AFF00645E1A8")

    private int mScrollState = OnScrollListener.SCROLL_STATE_IDLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.341 -0400", hash_original_field = "590E5386BF1A4104FE44A4AADB914C3D", hash_generated_field = "D42B9F4CA6EACF3E5515F0113524B53F")

    private long mShowInputControlsAnimimationDuration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.341 -0400", hash_original_field = "09B867FAA61E17B3A8CAE7E882019B98", hash_generated_field = "3AF141780F761DF920901C84521B4FAF")

    private boolean mScrollWheelAndFadingEdgesInitialized;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.341 -0400", hash_original_method = "F79ABC70152851F522A29F89B10B477D", hash_generated_method = "6B5394045724521C5C0FD0FF974D61E6")
    public  NumberPicker(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.341 -0400", hash_original_method = "C1116E13D5D84737E9D8F11A400A580C", hash_generated_method = "F8CFC9FA94627B8490C2F6720B928E8B")
    public  NumberPicker(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.numberPickerStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.367 -0400", hash_original_method = "8AC7B7259BDDBD9FCC66E09C35F9B950", hash_generated_method = "88A7799BAB6E8701B2255404771C1FA6")
    public  NumberPicker(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray attributesArray;
        attributesArray = context.obtainStyledAttributes(attrs,
                R.styleable.NumberPicker, defStyle, 0);
        mSolidColor = attributesArray.getColor(R.styleable.NumberPicker_solidColor, 0);
        mFlingable = attributesArray.getBoolean(R.styleable.NumberPicker_flingable, true);
        mSelectionDivider = attributesArray.getDrawable(R.styleable.NumberPicker_selectionDivider);
        int defSelectionDividerHeight;
        defSelectionDividerHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                UNSCALED_DEFAULT_SELECTION_DIVIDER_HEIGHT,
                getResources().getDisplayMetrics());
        mSelectionDividerHeight = attributesArray.getDimensionPixelSize(
                R.styleable.NumberPicker_selectionDividerHeight, defSelectionDividerHeight);
        mMinHeight = attributesArray.getDimensionPixelSize(R.styleable.NumberPicker_minHeight,
                SIZE_UNSPECIFIED);
        mMaxHeight = attributesArray.getDimensionPixelSize(R.styleable.NumberPicker_maxHeight,
                SIZE_UNSPECIFIED);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("minHeight > maxHeight");
        } //End block
        mMinWidth = attributesArray.getDimensionPixelSize(R.styleable.NumberPicker_minWidth,
                SIZE_UNSPECIFIED);
        mMaxWidth = attributesArray.getDimensionPixelSize(R.styleable.NumberPicker_maxWidth,
                SIZE_UNSPECIFIED);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("minWidth > maxWidth");
        } //End block
        mComputeMaxWidth = (mMaxWidth == Integer.MAX_VALUE);
        attributesArray.recycle();
        mShowInputControlsAnimimationDuration = getResources().getInteger(
                R.integer.config_longAnimTime);
        setWillNotDraw(false);
        setSelectorWheelState(SELECTOR_WHEEL_STATE_NONE);
        LayoutInflater inflater;
        inflater = (LayoutInflater) getContext().getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.number_picker, this, true);
        OnClickListener onClickListener;
        onClickListener = new OnClickListener() {
            public void onClick(View v) {
                InputMethodManager inputMethodManager = InputMethodManager.peekInstance();
                if (inputMethodManager != null && inputMethodManager.isActive(mInputText)) {
                    inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
                }
                mInputText.clearFocus();
                if (v.getId() == R.id.increment) {
                    changeCurrentByOne(true);
                } else {
                    changeCurrentByOne(false);
                }
            }
        };
        OnLongClickListener onLongClickListener;
        onLongClickListener = new OnLongClickListener() {
            public boolean onLongClick(View v) {
                mInputText.clearFocus();
                if (v.getId() == R.id.increment) {
                    postChangeCurrentByOneFromLongPress(true);
                } else {
                    postChangeCurrentByOneFromLongPress(false);
                }
                return true;
            }
        };
        mIncrementButton = (ImageButton) findViewById(R.id.increment);
        mIncrementButton.setOnClickListener(onClickListener);
        mIncrementButton.setOnLongClickListener(onLongClickListener);
        mDecrementButton = (ImageButton) findViewById(R.id.decrement);
        mDecrementButton.setOnClickListener(onClickListener);
        mDecrementButton.setOnLongClickListener(onLongClickListener);
        mInputText = (EditText) findViewById(R.id.numberpicker_input);
        mInputText.setOnFocusChangeListener(new OnFocusChangeListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.357 -0400", hash_original_method = "78C9C9D108DFA9B840217E0D621D6794", hash_generated_method = "5EDF7373B8147BF01D683AB7D75F95CC")
            public void onFocusChange(View v, boolean hasFocus) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                {
                    mInputText.selectAll();
                    InputMethodManager inputMethodManager;
                    inputMethodManager = InputMethodManager.peekInstance();
                    {
                        inputMethodManager.showSoftInput(mInputText, 0);
                    } //End block
                } //End block
                {
                    mInputText.setSelection(0, 0);
                    validateInputTextView(v);
                } //End block
                addTaint(v.getTaint());
                addTaint(hasFocus);
                // ---------- Original Method ----------
                //if (hasFocus) {
                    //mInputText.selectAll();
                    //InputMethodManager inputMethodManager = InputMethodManager.peekInstance();
                    //if (inputMethodManager != null) {
                        //inputMethodManager.showSoftInput(mInputText, 0);
                    //}
                //} else {
                    //mInputText.setSelection(0, 0);
                    //validateInputTextView(v);
                //}
            }
});
        mInputText.setFilters(new InputFilter[] {
            new InputTextFilter()
        });
        mInputText.setRawInputType(InputType.TYPE_CLASS_NUMBER);
        mTouchSlop = ViewConfiguration.getTapTimeout();
        ViewConfiguration configuration;
        configuration = ViewConfiguration.get(context);
        mTouchSlop = configuration.getScaledTouchSlop();
        mMinimumFlingVelocity = configuration.getScaledMinimumFlingVelocity();
        mMaximumFlingVelocity = configuration.getScaledMaximumFlingVelocity()
                / SELECTOR_MAX_FLING_VELOCITY_ADJUSTMENT;
        mTextSize = (int) mInputText.getTextSize();
        Paint paint;
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextAlign(Align.CENTER);
        paint.setTextSize(mTextSize);
        paint.setTypeface(mInputText.getTypeface());
        ColorStateList colors;
        colors = mInputText.getTextColors();
        int color;
        color = colors.getColorForState(ENABLED_STATE_SET, Color.WHITE);
        paint.setColor(color);
        mSelectorWheelPaint = paint;
        mDimSelectorWheelAnimator = ObjectAnimator.ofInt(this, PROPERTY_SELECTOR_PAINT_ALPHA,
                SELECTOR_WHEEL_BRIGHT_ALPHA, SELECTOR_WHEEL_DIM_ALPHA);
        ObjectAnimator showIncrementButton;
        showIncrementButton = ObjectAnimator.ofFloat(mIncrementButton,
                PROPERTY_BUTTON_ALPHA, BUTTON_ALPHA_TRANSPARENT, BUTTON_ALPHA_OPAQUE);
        ObjectAnimator showDecrementButton;
        showDecrementButton = ObjectAnimator.ofFloat(mDecrementButton,
                PROPERTY_BUTTON_ALPHA, BUTTON_ALPHA_TRANSPARENT, BUTTON_ALPHA_OPAQUE);
        mShowInputControlsAnimator = new AnimatorSet();
        mShowInputControlsAnimator.playTogether(mDimSelectorWheelAnimator, showIncrementButton,
                showDecrementButton);
        mShowInputControlsAnimator.addListener(new AnimatorListenerAdapter() {            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.359 -0400", hash_original_field = "D91530AF3D6C660AC2C0C8D4CBB2367B", hash_generated_field = "67D6DA73468F2D6E84B945FD38F1CC1D")
            private boolean mCanceled = false;
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.359 -0400", hash_original_method = "189FC240B4143654008EFD2A47B5C1DA", hash_generated_method = "91FFA6ED549336EB5DC072FFF70C5A1C")
            @Override
            public void onAnimationEnd(Animator animation) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                {
                    setSelectorWheelState(SELECTOR_WHEEL_STATE_SMALL);
                } //End block
                mCanceled = false;
                addTaint(animation.getTaint());
                // ---------- Original Method ----------
                //if (!mCanceled) {
                    //setSelectorWheelState(SELECTOR_WHEEL_STATE_SMALL);
                //}
                //mCanceled = false;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.367 -0400", hash_original_method = "9FA63CB44D9C62117F441F772E67C603", hash_generated_method = "03A979A97B0283B005CCB764CE3A34C2")
            @Override
            public void onAnimationCancel(Animator animation) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                {
                    boolean varB4912AC743221C357A119ADD97B4A7D5_1516189294 = (mShowInputControlsAnimator.isRunning());
                    {
                        mCanceled = true;
                    } //End block
                } //End collapsed parenthetic
                addTaint(animation.getTaint());
                // ---------- Original Method ----------
                //if (mShowInputControlsAnimator.isRunning()) {
                    //mCanceled = true;
                //}
            }
});
        mFlingScroller = new Scroller(getContext(), null, true);
        mAdjustScroller = new Scroller(getContext(), new DecelerateInterpolator(2.5f));
        updateInputTextView();
        updateIncrementAndDecrementButtonsVisibilityState();
        {
            {
                boolean varCFB3F7C345E12DBBCA9FF727129DE8BD_1516159779 = (isInEditMode());
                {
                    setSelectorWheelState(SELECTOR_WHEEL_STATE_SMALL);
                } //End block
                {
                    setSelectorWheelState(SELECTOR_WHEEL_STATE_LARGE);
                    hideInputControls();
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.368 -0400", hash_original_method = "E727E2B4CEB86D0A1B38AD8650A5C905", hash_generated_method = "B3A59D63F8D589B9653F8DF84951F156")
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int msrdWdth;
        msrdWdth = getMeasuredWidth();
        int msrdHght;
        msrdHght = getMeasuredHeight();
        int inctBtnMsrdWdth;
        inctBtnMsrdWdth = mIncrementButton.getMeasuredWidth();
        int incrBtnLeft;
        incrBtnLeft = (msrdWdth - inctBtnMsrdWdth) / 2;
        int incrBtnTop;
        incrBtnTop = 0;
        int incrBtnRight;
        incrBtnRight = incrBtnLeft + inctBtnMsrdWdth;
        int incrBtnBottom;
        incrBtnBottom = incrBtnTop + mIncrementButton.getMeasuredHeight();
        mIncrementButton.layout(incrBtnLeft, incrBtnTop, incrBtnRight, incrBtnBottom);
        int inptTxtMsrdWdth;
        inptTxtMsrdWdth = mInputText.getMeasuredWidth();
        int inptTxtMsrdHght;
        inptTxtMsrdHght = mInputText.getMeasuredHeight();
        int inptTxtLeft;
        inptTxtLeft = (msrdWdth - inptTxtMsrdWdth) / 2;
        int inptTxtTop;
        inptTxtTop = (msrdHght - inptTxtMsrdHght) / 2;
        int inptTxtRight;
        inptTxtRight = inptTxtLeft + inptTxtMsrdWdth;
        int inptTxtBottom;
        inptTxtBottom = inptTxtTop + inptTxtMsrdHght;
        mInputText.layout(inptTxtLeft, inptTxtTop, inptTxtRight, inptTxtBottom);
        int decrBtnMsrdWdth;
        decrBtnMsrdWdth = mIncrementButton.getMeasuredWidth();
        int decrBtnLeft;
        decrBtnLeft = (msrdWdth - decrBtnMsrdWdth) / 2;
        int decrBtnTop;
        decrBtnTop = msrdHght - mDecrementButton.getMeasuredHeight();
        int decrBtnRight;
        decrBtnRight = decrBtnLeft + decrBtnMsrdWdth;
        int decrBtnBottom;
        decrBtnBottom = msrdHght;
        mDecrementButton.layout(decrBtnLeft, decrBtnTop, decrBtnRight, decrBtnBottom);
        {
            mScrollWheelAndFadingEdgesInitialized = true;
            initializeSelectorWheel();
            initializeFadingEdges();
        } //End block
        addTaint(changed);
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.375 -0400", hash_original_method = "048719DA53F07F7F498A46C4561541BF", hash_generated_method = "1B572D5B5DEBF110D1CA7F6C6F3B1382")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int newWidthMeasureSpec;
        newWidthMeasureSpec = makeMeasureSpec(widthMeasureSpec, mMaxWidth);
        int newHeightMeasureSpec;
        newHeightMeasureSpec = makeMeasureSpec(heightMeasureSpec, mMaxHeight);
        super.onMeasure(newWidthMeasureSpec, newHeightMeasureSpec);
        int widthSize;
        widthSize = resolveSizeAndStateRespectingMinSize(mMinWidth, getMeasuredWidth(),
                widthMeasureSpec);
        int heightSize;
        heightSize = resolveSizeAndStateRespectingMinSize(mMinHeight, getMeasuredHeight(),
                heightMeasureSpec);
        setMeasuredDimension(widthSize, heightSize);
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        // ---------- Original Method ----------
        //final int newWidthMeasureSpec = makeMeasureSpec(widthMeasureSpec, mMaxWidth);
        //final int newHeightMeasureSpec = makeMeasureSpec(heightMeasureSpec, mMaxHeight);
        //super.onMeasure(newWidthMeasureSpec, newHeightMeasureSpec);
        //final int widthSize = resolveSizeAndStateRespectingMinSize(mMinWidth, getMeasuredWidth(),
                //widthMeasureSpec);
        //final int heightSize = resolveSizeAndStateRespectingMinSize(mMinHeight, getMeasuredHeight(),
                //heightMeasureSpec);
        //setMeasuredDimension(widthSize, heightSize);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.384 -0400", hash_original_method = "10C35B0DAD7657DB14B7F950A0414363", hash_generated_method = "3D28A52F4DAD49E6CC599E3DF8A0DC45")
    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var79EF553F2736040AD024A5084BB63B1D_796129864 = (!isEnabled() || !mFlingable);
        } //End collapsed parenthetic
        {
            Object var109A69337F68C2E78388A88D677709DA_1661611895 = (event.getActionMasked());
            //Begin case MotionEvent.ACTION_DOWN 
            mLastMotionEventY = mLastDownEventY = event.getY();
            //End case MotionEvent.ACTION_DOWN 
            //Begin case MotionEvent.ACTION_DOWN 
            removeAllCallbacks();
            //End case MotionEvent.ACTION_DOWN 
            //Begin case MotionEvent.ACTION_DOWN 
            mShowInputControlsAnimator.cancel();
            //End case MotionEvent.ACTION_DOWN 
            //Begin case MotionEvent.ACTION_DOWN 
            mDimSelectorWheelAnimator.cancel();
            //End case MotionEvent.ACTION_DOWN 
            //Begin case MotionEvent.ACTION_DOWN 
            mBeginEditOnUpEvent = false;
            //End case MotionEvent.ACTION_DOWN 
            //Begin case MotionEvent.ACTION_DOWN 
            mAdjustScrollerOnUpEvent = true;
            //End case MotionEvent.ACTION_DOWN 
            //Begin case MotionEvent.ACTION_DOWN 
            {
                mSelectorWheelPaint.setAlpha(SELECTOR_WHEEL_BRIGHT_ALPHA);
                boolean scrollersFinished;
                scrollersFinished = mFlingScroller.isFinished()
                            && mAdjustScroller.isFinished();
                {
                    mFlingScroller.forceFinished(true);
                    mAdjustScroller.forceFinished(true);
                    onScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
                } //End block
                mBeginEditOnUpEvent = scrollersFinished;
                mAdjustScrollerOnUpEvent = true;
                hideInputControls();
            } //End block
            //End case MotionEvent.ACTION_DOWN 
            //Begin case MotionEvent.ACTION_DOWN 
            {
                boolean varF0BD0521FE1EE49E79BFF9F8B8B6846D_2002040207 = (isEventInVisibleViewHitRect(event, mIncrementButton)
                        || isEventInVisibleViewHitRect(event, mDecrementButton));
            } //End collapsed parenthetic
            //End case MotionEvent.ACTION_DOWN 
            //Begin case MotionEvent.ACTION_DOWN 
            mAdjustScrollerOnUpEvent = false;
            //End case MotionEvent.ACTION_DOWN 
            //Begin case MotionEvent.ACTION_DOWN 
            setSelectorWheelState(SELECTOR_WHEEL_STATE_LARGE);
            //End case MotionEvent.ACTION_DOWN 
            //Begin case MotionEvent.ACTION_DOWN 
            hideInputControls();
            //End case MotionEvent.ACTION_DOWN 
            //Begin case MotionEvent.ACTION_MOVE 
            float currentMoveY;
            currentMoveY = event.getY();
            //End case MotionEvent.ACTION_MOVE 
            //Begin case MotionEvent.ACTION_MOVE 
            int deltaDownY;
            deltaDownY = (int) Math.abs(currentMoveY - mLastDownEventY);
            //End case MotionEvent.ACTION_MOVE 
            //Begin case MotionEvent.ACTION_MOVE 
            {
                mBeginEditOnUpEvent = false;
                onScrollStateChange(OnScrollListener.SCROLL_STATE_TOUCH_SCROLL);
                setSelectorWheelState(SELECTOR_WHEEL_STATE_LARGE);
                hideInputControls();
            } //End block
            //End case MotionEvent.ACTION_MOVE 
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1791633894 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1791633894;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.385 -0400", hash_original_method = "235D8E8A92689E68622E8E516F140226", hash_generated_method = "F2ABAB5ED3BC35A0BFD05535485AA193")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varC378F7D9F83769944CF2ACC662A4EAE3_1555986127 = (!isEnabled());
        } //End collapsed parenthetic
        {
            mVelocityTracker = VelocityTracker.obtain();
        } //End block
        mVelocityTracker.addMovement(ev);
        int action;
        action = ev.getActionMasked();
        //Begin case MotionEvent.ACTION_MOVE 
        float currentMoveY;
        currentMoveY = ev.getY();
        //End case MotionEvent.ACTION_MOVE 
        //Begin case MotionEvent.ACTION_MOVE 
        {
            int deltaDownY;
            deltaDownY = (int) Math.abs(currentMoveY - mLastDownEventY);
            {
                mBeginEditOnUpEvent = false;
                onScrollStateChange(OnScrollListener.SCROLL_STATE_TOUCH_SCROLL);
            } //End block
        } //End block
        //End case MotionEvent.ACTION_MOVE 
        //Begin case MotionEvent.ACTION_MOVE 
        int deltaMoveY;
        deltaMoveY = (int) (currentMoveY - mLastMotionEventY);
        //End case MotionEvent.ACTION_MOVE 
        //Begin case MotionEvent.ACTION_MOVE 
        scrollBy(0, deltaMoveY);
        //End case MotionEvent.ACTION_MOVE 
        //Begin case MotionEvent.ACTION_MOVE 
        invalidate();
        //End case MotionEvent.ACTION_MOVE 
        //Begin case MotionEvent.ACTION_MOVE 
        mLastMotionEventY = currentMoveY;
        //End case MotionEvent.ACTION_MOVE 
        //Begin case MotionEvent.ACTION_UP 
        {
            setSelectorWheelState(SELECTOR_WHEEL_STATE_SMALL);
            showInputControls(mShowInputControlsAnimimationDuration);
            mInputText.requestFocus();
        } //End block
        //End case MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_UP 
        VelocityTracker velocityTracker;
        velocityTracker = mVelocityTracker;
        //End case MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_UP 
        velocityTracker.computeCurrentVelocity(1000, mMaximumFlingVelocity);
        //End case MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_UP 
        int initialVelocity;
        initialVelocity = (int) velocityTracker.getYVelocity();
        //End case MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_UP 
        {
            boolean varC622ADAD4ADF3A4DF65ACA244434F6E6_938577556 = (Math.abs(initialVelocity) > mMinimumFlingVelocity);
            {
                fling(initialVelocity);
                onScrollStateChange(OnScrollListener.SCROLL_STATE_FLING);
            } //End block
            {
                {
                    {
                        boolean var8A0A19577571338E4B9827E2FA748B92_2034439757 = (mFlingScroller.isFinished() && mAdjustScroller.isFinished());
                        {
                            postAdjustScrollerCommand(0);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    postAdjustScrollerCommand(SHOW_INPUT_CONTROLS_DELAY_MILLIS);
                } //End block
            } //End block
        } //End collapsed parenthetic
        //End case MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_UP 
        mVelocityTracker.recycle();
        //End case MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_UP 
        mVelocityTracker = null;
        //End case MotionEvent.ACTION_UP 
        addTaint(ev.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_520968575 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_520968575;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.387 -0400", hash_original_method = "BF176E11CE8244676F550C2A8C029DBC", hash_generated_method = "DD443163A48A1C8DA833BE285F9CAE94")
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        int action;
        action = event.getActionMasked();
        //Begin case MotionEvent.ACTION_MOVE 
        {
            removeAllCallbacks();
            forceCompleteChangeCurrentByOneViaScroll();
        } //End block
        //End case MotionEvent.ACTION_MOVE 
        //Begin case MotionEvent.ACTION_CANCEL MotionEvent.ACTION_UP 
        removeAllCallbacks();
        //End case MotionEvent.ACTION_CANCEL MotionEvent.ACTION_UP 
        boolean var5595FF16C420D2682133A571FCECA386_2009661293 = (super.dispatchTouchEvent(event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_637715038 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_637715038;
        // ---------- Original Method ----------
        //final int action = event.getActionMasked();
        //switch (action) {
            //case MotionEvent.ACTION_MOVE:
                //if (mSelectorWheelState == SELECTOR_WHEEL_STATE_LARGE) {
                    //removeAllCallbacks();
                    //forceCompleteChangeCurrentByOneViaScroll();
                //}
                //break;
            //case MotionEvent.ACTION_CANCEL:
            //case MotionEvent.ACTION_UP:
                //removeAllCallbacks();
                //break;
        //}
        //return super.dispatchTouchEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.393 -0400", hash_original_method = "5F2124C88DD28BBD925F58E6B4833CD1", hash_generated_method = "5FB1B64F1E01997711C576D9A93C23D8")
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int keyCode;
        keyCode = event.getKeyCode();
        {
            removeAllCallbacks();
        } //End block
        boolean varD8A05597F0CCFB3ED5A50CCF86C0200D_1837469245 = (super.dispatchKeyEvent(event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_292399181 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_292399181;
        // ---------- Original Method ----------
        //int keyCode = event.getKeyCode();
        //if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER || keyCode == KeyEvent.KEYCODE_ENTER) {
            //removeAllCallbacks();
        //}
        //return super.dispatchKeyEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.398 -0400", hash_original_method = "7AF2AFA03903803DBB932D40A216CA15", hash_generated_method = "0838E419C069F580B3F380B8AD38658E")
    @Override
    public boolean dispatchTrackballEvent(MotionEvent event) {
        int action;
        action = event.getActionMasked();
        {
            removeAllCallbacks();
        } //End block
        boolean varCFB95AF931BBE8F5458525AB8E26F369_2127087987 = (super.dispatchTrackballEvent(event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1731193463 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1731193463;
        // ---------- Original Method ----------
        //int action = event.getActionMasked();
        //if (action == MotionEvent.ACTION_CANCEL || action == MotionEvent.ACTION_UP) {
            //removeAllCallbacks();
        //}
        //return super.dispatchTrackballEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.399 -0400", hash_original_method = "A8C44E23055FC2DF1A30CAFE867BE321", hash_generated_method = "5AC20C867EF346E8DA41D504B66E60E7")
    @Override
    public void computeScroll() {
        Scroller scroller;
        scroller = mFlingScroller;
        {
            boolean var260EE57A09B49E3ED75F979B0D60530F_692651225 = (scroller.isFinished());
            {
                scroller = mAdjustScroller;
                {
                    boolean var0D4876BAA5DB829A52158B403A2A8D88_160847318 = (scroller.isFinished());
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        scroller.computeScrollOffset();
        int currentScrollerY;
        currentScrollerY = scroller.getCurrY();
        {
            mPreviousScrollerY = scroller.getStartY();
        } //End block
        scrollBy(0, currentScrollerY - mPreviousScrollerY);
        mPreviousScrollerY = currentScrollerY;
        {
            boolean var260EE57A09B49E3ED75F979B0D60530F_1670777874 = (scroller.isFinished());
            {
                onScrollerFinished(scroller);
            } //End block
            {
                invalidate();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mSelectorWheelState == SELECTOR_WHEEL_STATE_NONE) {
            //return;
        //}
        //Scroller scroller = mFlingScroller;
        //if (scroller.isFinished()) {
            //scroller = mAdjustScroller;
            //if (scroller.isFinished()) {
                //return;
            //}
        //}
        //scroller.computeScrollOffset();
        //int currentScrollerY = scroller.getCurrY();
        //if (mPreviousScrollerY == 0) {
            //mPreviousScrollerY = scroller.getStartY();
        //}
        //scrollBy(0, currentScrollerY - mPreviousScrollerY);
        //mPreviousScrollerY = currentScrollerY;
        //if (scroller.isFinished()) {
            //onScrollerFinished(scroller);
        //} else {
            //invalidate();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.399 -0400", hash_original_method = "B6D6495EF8D39EBA8CC69BAAD1076261", hash_generated_method = "00548C9A6E2B4DB891E600F6833E70CE")
    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        mIncrementButton.setEnabled(enabled);
        mDecrementButton.setEnabled(enabled);
        mInputText.setEnabled(enabled);
        addTaint(enabled);
        // ---------- Original Method ----------
        //super.setEnabled(enabled);
        //mIncrementButton.setEnabled(enabled);
        //mDecrementButton.setEnabled(enabled);
        //mInputText.setEnabled(enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.406 -0400", hash_original_method = "4E7C0796471D51CC4FDC613C54076EA5", hash_generated_method = "2835CEDFB57CA1B6C0DEEE9639329DA0")
    @Override
    public void scrollBy(int x, int y) {
        int[] selectorIndices;
        selectorIndices = mSelectorIndices;
        {
            mCurrentScrollOffset = mInitialScrollOffset;
        } //End block
        {
            mCurrentScrollOffset = mInitialScrollOffset;
        } //End block
        mCurrentScrollOffset += y;
        {
            mCurrentScrollOffset -= mSelectorElementHeight;
            decrementSelectorIndices(selectorIndices);
            changeCurrent(selectorIndices[SELECTOR_MIDDLE_ITEM_INDEX]);
            {
                mCurrentScrollOffset = mInitialScrollOffset;
            } //End block
        } //End block
        {
            mCurrentScrollOffset += mSelectorElementHeight;
            incrementSelectorIndices(selectorIndices);
            changeCurrent(selectorIndices[SELECTOR_MIDDLE_ITEM_INDEX]);
            {
                mCurrentScrollOffset = mInitialScrollOffset;
            } //End block
        } //End block
        addTaint(x);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.411 -0400", hash_original_method = "A5D52728D322EA76B9FE19A001AC2619", hash_generated_method = "05F19FE9EDCB97B0903F5E3205F78873")
    @Override
    public int getSolidColor() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1292230109 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1292230109;
        // ---------- Original Method ----------
        //return mSolidColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.416 -0400", hash_original_method = "B8FD740B950D37D2ACEC32CDC9BBCB3E", hash_generated_method = "D55BA1C0A2CC4BCD0E3EE7C50853AF06")
    public void setOnValueChangedListener(OnValueChangeListener onValueChangedListener) {
        mOnValueChangeListener = onValueChangedListener;
        // ---------- Original Method ----------
        //mOnValueChangeListener = onValueChangedListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.416 -0400", hash_original_method = "E07C1A1F4DD9D0D02072D75B16D4DB8B", hash_generated_method = "8D444529148A09F38F528175C920BB2D")
    public void setOnScrollListener(OnScrollListener onScrollListener) {
        mOnScrollListener = onScrollListener;
        // ---------- Original Method ----------
        //mOnScrollListener = onScrollListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.417 -0400", hash_original_method = "3C88654A4CCA22ED513CF659C7EAC98C", hash_generated_method = "B7F967AAF330353456C0DA1112A31CC0")
    public void setFormatter(Formatter formatter) {
        mFormatter = formatter;
        initializeSelectorWheelIndices();
        updateInputTextView();
        // ---------- Original Method ----------
        //if (formatter == mFormatter) {
            //return;
        //}
        //mFormatter = formatter;
        //initializeSelectorWheelIndices();
        //updateInputTextView();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.417 -0400", hash_original_method = "27A138A3602AD1BB9BCFA8883739C2F3", hash_generated_method = "D216550AEA3602725BCABA4465F89467")
    public void setValue(int value) {
        {
            value = mWrapSelectorWheel ? mMaxValue : mMinValue;
        } //End block
        {
            value = mWrapSelectorWheel ? mMinValue : mMaxValue;
        } //End block
        mValue = value;
        initializeSelectorWheelIndices();
        updateInputTextView();
        updateIncrementAndDecrementButtonsVisibilityState();
        invalidate();
        // ---------- Original Method ----------
        //if (mValue == value) {
            //return;
        //}
        //if (value < mMinValue) {
            //value = mWrapSelectorWheel ? mMaxValue : mMinValue;
        //}
        //if (value > mMaxValue) {
            //value = mWrapSelectorWheel ? mMinValue : mMaxValue;
        //}
        //mValue = value;
        //initializeSelectorWheelIndices();
        //updateInputTextView();
        //updateIncrementAndDecrementButtonsVisibilityState();
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.428 -0400", hash_original_method = "EC05395A137121E418B1180AC02A20B0", hash_generated_method = "B4A7B86B6AD15E1791C2AAB6C5C49A03")
    private void tryComputeMaxWidth() {
        int maxTextWidth;
        maxTextWidth = 0;
        {
            float maxDigitWidth;
            maxDigitWidth = 0;
            {
                int i;
                i = 0;
                {
                    float digitWidth;
                    digitWidth = mSelectorWheelPaint.measureText(String.valueOf(i));
                    {
                        maxDigitWidth = digitWidth;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            int numberOfDigits;
            numberOfDigits = 0;
            int current;
            current = mMaxValue;
            {
                current = current / 10;
            } //End block
            maxTextWidth = (int) (numberOfDigits * maxDigitWidth);
        } //End block
        {
            int valueCount;
            valueCount = mDisplayedValues.length;
            {
                int i;
                i = 0;
                {
                    float textWidth;
                    textWidth = mSelectorWheelPaint.measureText(mDisplayedValues[i]);
                    {
                        maxTextWidth = (int) textWidth;
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        maxTextWidth += mInputText.getPaddingLeft() + mInputText.getPaddingRight();
        {
            {
                mMaxWidth = maxTextWidth;
            } //End block
            {
                mMaxWidth = mMinWidth;
            } //End block
            invalidate();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.484 -0400", hash_original_method = "0DE9A61E4C9F0206942BD1BD5DBB2993", hash_generated_method = "E1472E3088C83D8C655A0364D938DF0B")
    public boolean getWrapSelectorWheel() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1192407097 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1192407097;
        // ---------- Original Method ----------
        //return mWrapSelectorWheel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.485 -0400", hash_original_method = "4802BADC2E2D3D03E25B827D3F65AC09", hash_generated_method = "42505C60A6C433DE5702A866EE2AC50E")
    public void setWrapSelectorWheel(boolean wrapSelectorWheel) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Range less than selector items count.");
        } //End block
        {
            mWrapSelectorWheel = wrapSelectorWheel;
            updateIncrementAndDecrementButtonsVisibilityState();
        } //End block
        // ---------- Original Method ----------
        //if (wrapSelectorWheel && (mMaxValue - mMinValue) < mSelectorIndices.length) {
            //throw new IllegalStateException("Range less than selector items count.");
        //}
        //if (wrapSelectorWheel != mWrapSelectorWheel) {
            //mWrapSelectorWheel = wrapSelectorWheel;
            //updateIncrementAndDecrementButtonsVisibilityState();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.485 -0400", hash_original_method = "8C354EDC01FB7FE8E35D5D03601EF310", hash_generated_method = "A112829F0E2370B87C41F6E6B0002254")
    public void setOnLongPressUpdateInterval(long intervalMillis) {
        mLongPressUpdateInterval = intervalMillis;
        // ---------- Original Method ----------
        //mLongPressUpdateInterval = intervalMillis;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.485 -0400", hash_original_method = "873C7D38131A035B7F6055170D432634", hash_generated_method = "42CAB3FAB4D523700D7A626E256C181D")
    public int getValue() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_846918102 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_846918102;
        // ---------- Original Method ----------
        //return mValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.485 -0400", hash_original_method = "734B6103B2E180B236F243E5AD573634", hash_generated_method = "87FF13B10BD39643C5C860617B61C0C2")
    public int getMinValue() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_440513565 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_440513565;
        // ---------- Original Method ----------
        //return mMinValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.486 -0400", hash_original_method = "661BFF8A6967E0A91919CA7BDDDCFF35", hash_generated_method = "14248A6502BD57C7839473DEE2885443")
    public void setMinValue(int minValue) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("minValue must be >= 0");
        } //End block
        mMinValue = minValue;
        {
            mValue = mMinValue;
        } //End block
        boolean wrapSelectorWheel;
        wrapSelectorWheel = mMaxValue - mMinValue > mSelectorIndices.length;
        setWrapSelectorWheel(wrapSelectorWheel);
        initializeSelectorWheelIndices();
        updateInputTextView();
        tryComputeMaxWidth();
        // ---------- Original Method ----------
        //if (mMinValue == minValue) {
            //return;
        //}
        //if (minValue < 0) {
            //throw new IllegalArgumentException("minValue must be >= 0");
        //}
        //mMinValue = minValue;
        //if (mMinValue > mValue) {
            //mValue = mMinValue;
        //}
        //boolean wrapSelectorWheel = mMaxValue - mMinValue > mSelectorIndices.length;
        //setWrapSelectorWheel(wrapSelectorWheel);
        //initializeSelectorWheelIndices();
        //updateInputTextView();
        //tryComputeMaxWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.486 -0400", hash_original_method = "D9333690652DA8538B4523261E9BBD48", hash_generated_method = "405EBAEF7893D4FF655B76DCACE0553D")
    public int getMaxValue() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_185965876 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_185965876;
        // ---------- Original Method ----------
        //return mMaxValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.487 -0400", hash_original_method = "1C3BC534ADC5B8B2FC50C2F4D93BA1C9", hash_generated_method = "64548383123B2DEEB737C64532DE52CA")
    public void setMaxValue(int maxValue) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("maxValue must be >= 0");
        } //End block
        mMaxValue = maxValue;
        {
            mValue = mMaxValue;
        } //End block
        boolean wrapSelectorWheel;
        wrapSelectorWheel = mMaxValue - mMinValue > mSelectorIndices.length;
        setWrapSelectorWheel(wrapSelectorWheel);
        initializeSelectorWheelIndices();
        updateInputTextView();
        tryComputeMaxWidth();
        // ---------- Original Method ----------
        //if (mMaxValue == maxValue) {
            //return;
        //}
        //if (maxValue < 0) {
            //throw new IllegalArgumentException("maxValue must be >= 0");
        //}
        //mMaxValue = maxValue;
        //if (mMaxValue < mValue) {
            //mValue = mMaxValue;
        //}
        //boolean wrapSelectorWheel = mMaxValue - mMinValue > mSelectorIndices.length;
        //setWrapSelectorWheel(wrapSelectorWheel);
        //initializeSelectorWheelIndices();
        //updateInputTextView();
        //tryComputeMaxWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.487 -0400", hash_original_method = "7D8D8A804F018648196BF68A974CA568", hash_generated_method = "2074BF36F9114AAF203C6A3D55B912B9")
    public String[] getDisplayedValues() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_791536915 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_791536915 = mDisplayedValues;
        varB4EAC82CA7396A68D541C85D26508E83_791536915.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_791536915;
        // ---------- Original Method ----------
        //return mDisplayedValues;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.488 -0400", hash_original_method = "0435EA5A97E8A7F818A581EB86B2390D", hash_generated_method = "0588B5335F223CEF339B1B620DB98FA4")
    public void setDisplayedValues(String[] displayedValues) {
        mDisplayedValues = displayedValues;
        {
            mInputText.setRawInputType(InputType.TYPE_CLASS_TEXT
                    | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
        } //End block
        {
            mInputText.setRawInputType(InputType.TYPE_CLASS_NUMBER);
        } //End block
        updateInputTextView();
        initializeSelectorWheelIndices();
        tryComputeMaxWidth();
        // ---------- Original Method ----------
        //if (mDisplayedValues == displayedValues) {
            //return;
        //}
        //mDisplayedValues = displayedValues;
        //if (mDisplayedValues != null) {
            //mInputText.setRawInputType(InputType.TYPE_CLASS_TEXT
                    //| InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
        //} else {
            //mInputText.setRawInputType(InputType.TYPE_CLASS_NUMBER);
        //}
        //updateInputTextView();
        //initializeSelectorWheelIndices();
        //tryComputeMaxWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.488 -0400", hash_original_method = "26009EEE98735F9AF4C2D76E4A1AFAB0", hash_generated_method = "4BE6D81BAAA6BCC60430EC758A84D503")
    @Override
    protected float getTopFadingEdgeStrength() {
        float var546ADE640B6EDFBC8A086EF31347E768_1999750711 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1999750711;
        // ---------- Original Method ----------
        //return TOP_AND_BOTTOM_FADING_EDGE_STRENGTH;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.497 -0400", hash_original_method = "A0CE61C0CAF5846D2D470684E7070854", hash_generated_method = "B746E32326E51F7A743E28EB05FD457E")
    @Override
    protected float getBottomFadingEdgeStrength() {
        float var546ADE640B6EDFBC8A086EF31347E768_1505123574 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1505123574;
        // ---------- Original Method ----------
        //return TOP_AND_BOTTOM_FADING_EDGE_STRENGTH;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.498 -0400", hash_original_method = "D8635D04A384ABA875A77249BA87A3E4", hash_generated_method = "F2D799F993269DC47214A8505DE38BE2")
    @Override
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAttachedToWindow();
        {
            boolean var536C2D4C39407777E35D36D0A0039169_2118878323 = (mFlingable && !isInEditMode());
            {
                showInputControls(mShowInputControlsAnimimationDuration * 2);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.onAttachedToWindow();
        //if (mFlingable && !isInEditMode()) {
            //showInputControls(mShowInputControlsAnimimationDuration * 2);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.499 -0400", hash_original_method = "1AF381BAEFDBA706A0AAFFFCBFBE7386", hash_generated_method = "B6B24701F125BC28DDEDFD787141F4D6")
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        removeAllCallbacks();
        // ---------- Original Method ----------
        //removeAllCallbacks();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.499 -0400", hash_original_method = "0296ECFD4FBB578ABFB3DEE9D2F54084", hash_generated_method = "8827C1FA31E6998965C439129AE20899")
    @Override
    protected void dispatchDraw(Canvas canvas) {
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.500 -0400", hash_original_method = "592CCD8540DAA22101D858B8673CA0A4", hash_generated_method = "02DF314EE3BD7B89BE5D1532257EA2D4")
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        {
            boolean var84E258152AE9357479C93EE8ACC98D31_735623709 = (mShowInputControlsAnimator.isRunning()
                || mSelectorWheelState != SELECTOR_WHEEL_STATE_LARGE);
            {
                long drawTime;
                drawTime = getDrawingTime();
                {
                    int i, count;
                    i = 0;
                    count = getChildCount();
                    {
                        View child;
                        child = getChildAt(i);
                        {
                            boolean var2BE0D12052E9691CD7CCFEBC9EEBC99F_1575195634 = (!child.isShown());
                        } //End collapsed parenthetic
                        drawChild(canvas, getChildAt(i), drawTime);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        //super.draw(canvas);
        //if (mShowInputControlsAnimator.isRunning()
                //|| mSelectorWheelState != SELECTOR_WHEEL_STATE_LARGE) {
            //long drawTime = getDrawingTime();
            //for (int i = 0, count = getChildCount(); i < count; i++) {
                //View child = getChildAt(i);
                //if (!child.isShown()) {
                    //continue;
                //}
                //drawChild(canvas, getChildAt(i), drawTime);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.500 -0400", hash_original_method = "73B10A324A4034D5CD70F03023B591F2", hash_generated_method = "59FC99ADF37952DA180E1FBDA06791FC")
    @Override
    protected void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        float x;
        x = (mRight - mLeft) / 2;
        float y;
        y = mCurrentScrollOffset;
        int restoreCount;
        restoreCount = canvas.save();
        {
            Rect clipBounds;
            clipBounds = canvas.getClipBounds();
            clipBounds.inset(0, mSelectorElementHeight);
            canvas.clipRect(clipBounds);
        } //End block
        int[] selectorIndices;
        selectorIndices = mSelectorIndices;
        {
            int i;
            i = 0;
            {
                int selectorIndex;
                selectorIndex = selectorIndices[i];
                String scrollSelectorValue;
                scrollSelectorValue = mSelectorIndexToStringCache.get(selectorIndex);
                {
                    boolean varCA4EBD1F5AA1D0D604D7B5EFC4A15DD6_1545589337 = (i != SELECTOR_MIDDLE_ITEM_INDEX || mInputText.getVisibility() != VISIBLE);
                    {
                        canvas.drawText(scrollSelectorValue, x, y, mSelectorWheelPaint);
                    } //End block
                } //End collapsed parenthetic
                y += mSelectorElementHeight;
            } //End block
        } //End collapsed parenthetic
        {
            int topOfTopDivider;
            topOfTopDivider = (getHeight() - mSelectorElementHeight - mSelectionDividerHeight) / 2;
            int bottomOfTopDivider;
            bottomOfTopDivider = topOfTopDivider + mSelectionDividerHeight;
            mSelectionDivider.setBounds(0, topOfTopDivider, mRight, bottomOfTopDivider);
            mSelectionDivider.draw(canvas);
            int topOfBottomDivider;
            topOfBottomDivider = topOfTopDivider + mSelectorElementHeight;
            int bottomOfBottomDivider;
            bottomOfBottomDivider = bottomOfTopDivider + mSelectorElementHeight;
            mSelectionDivider.setBounds(0, topOfBottomDivider, mRight, bottomOfBottomDivider);
            mSelectionDivider.draw(canvas);
        } //End block
        canvas.restoreToCount(restoreCount);
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.501 -0400", hash_original_method = "F557CD251A66C23831BE55ECFE0FD6EB", hash_generated_method = "6A09BD8EA53A915AB5F822E12CBC5F98")
    @Override
    public void sendAccessibilityEvent(int eventType) {
        addTaint(eventType);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.501 -0400", hash_original_method = "568475CB75488DB4FFB4140594C385EC", hash_generated_method = "9A2579DF8BBFC4B5703562045F07F38D")
    private int makeMeasureSpec(int measureSpec, int maxSize) {
        int size;
        size = MeasureSpec.getSize(measureSpec);
        int mode;
        mode = MeasureSpec.getMode(measureSpec);
        //Begin case MeasureSpec.AT_MOST 
        int var95ED3B42CD87B207C96C3D67CCC2EFD1_438781319 = (MeasureSpec.makeMeasureSpec(Math.min(size, maxSize), MeasureSpec.EXACTLY));
        //End case MeasureSpec.AT_MOST 
        //Begin case MeasureSpec.UNSPECIFIED 
        int var71A9899F63F8963C4B37A295F44B660F_2016424839 = (MeasureSpec.makeMeasureSpec(maxSize, MeasureSpec.EXACTLY));
        //End case MeasureSpec.UNSPECIFIED 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown measure mode: " + mode);
        //End case default 
        addTaint(measureSpec);
        addTaint(maxSize);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2066307065 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2066307065;
        // ---------- Original Method ----------
        //if (maxSize == SIZE_UNSPECIFIED) {
            //return measureSpec;
        //}
        //final int size = MeasureSpec.getSize(measureSpec);
        //final int mode = MeasureSpec.getMode(measureSpec);
        //switch (mode) {
            //case MeasureSpec.EXACTLY:
                //return measureSpec;
            //case MeasureSpec.AT_MOST:
                //return MeasureSpec.makeMeasureSpec(Math.min(size, maxSize), MeasureSpec.EXACTLY);
            //case MeasureSpec.UNSPECIFIED:
                //return MeasureSpec.makeMeasureSpec(maxSize, MeasureSpec.EXACTLY);
            //default:
                //throw new IllegalArgumentException("Unknown measure mode: " + mode);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.502 -0400", hash_original_method = "AB452915EDDF000AB380F75E12970FED", hash_generated_method = "60C1554B81E5283FBB30C3D52C8926F5")
    private int resolveSizeAndStateRespectingMinSize(int minSize, int measuredSize,
            int measureSpec) {
        {
            int desiredWidth;
            desiredWidth = Math.max(minSize, measuredSize);
            int var1F64A1B71774E82218E2B73400CFDDB8_584574920 = (resolveSizeAndState(desiredWidth, measureSpec, 0));
        } //End block
        addTaint(minSize);
        addTaint(measuredSize);
        addTaint(measureSpec);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_440234577 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_440234577;
        // ---------- Original Method ----------
        //if (minSize != SIZE_UNSPECIFIED) {
            //final int desiredWidth = Math.max(minSize, measuredSize);
            //return resolveSizeAndState(desiredWidth, measureSpec, 0);
        //} else {
            //return measuredSize;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.502 -0400", hash_original_method = "73F5524AAE1282E1B063C4C90806C754", hash_generated_method = "C69A61DC7EBBD81B84DCE3B5B8E2E898")
    private void initializeSelectorWheelIndices() {
        mSelectorIndexToStringCache.clear();
        int[] selectorIdices;
        selectorIdices = mSelectorIndices;
        int current;
        current = getValue();
        {
            int i;
            i = 0;
            {
                int selectorIndex;
                selectorIndex = current + (i - SELECTOR_MIDDLE_ITEM_INDEX);
                {
                    selectorIndex = getWrappedSelectorIndex(selectorIndex);
                } //End block
                mSelectorIndices[i] = selectorIndex;
                ensureCachedScrollSelectorValue(mSelectorIndices[i]);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //mSelectorIndexToStringCache.clear();
        //int[] selectorIdices = mSelectorIndices;
        //int current = getValue();
        //for (int i = 0; i < mSelectorIndices.length; i++) {
            //int selectorIndex = current + (i - SELECTOR_MIDDLE_ITEM_INDEX);
            //if (mWrapSelectorWheel) {
                //selectorIndex = getWrappedSelectorIndex(selectorIndex);
            //}
            //mSelectorIndices[i] = selectorIndex;
            //ensureCachedScrollSelectorValue(mSelectorIndices[i]);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.505 -0400", hash_original_method = "555F719FBCCD8AB4B94C9C107DB6A73F", hash_generated_method = "79FE9D0E539376A125F4A59824611CEB")
    private void changeCurrent(int current) {
        {
            current = getWrappedSelectorIndex(current);
        } //End block
        int previous;
        previous = mValue;
        setValue(current);
        notifyChange(previous, current);
        addTaint(current);
        // ---------- Original Method ----------
        //if (mValue == current) {
            //return;
        //}
        //if (mWrapSelectorWheel) {
            //current = getWrappedSelectorIndex(current);
        //}
        //int previous = mValue;
        //setValue(current);
        //notifyChange(previous, current);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.506 -0400", hash_original_method = "E6026B71E66A86671A33BB22E5856635", hash_generated_method = "AC90776F4D8E0526EE9C611A8436488D")
    private void changeCurrentByOne(boolean increment) {
        {
            mDimSelectorWheelAnimator.cancel();
            mInputText.setVisibility(View.INVISIBLE);
            mSelectorWheelPaint.setAlpha(SELECTOR_WHEEL_BRIGHT_ALPHA);
            mPreviousScrollerY = 0;
            forceCompleteChangeCurrentByOneViaScroll();
            {
                mFlingScroller.startScroll(0, 0, 0, -mSelectorElementHeight,
                        CHANGE_CURRENT_BY_ONE_SCROLL_DURATION);
            } //End block
            {
                mFlingScroller.startScroll(0, 0, 0, mSelectorElementHeight,
                        CHANGE_CURRENT_BY_ONE_SCROLL_DURATION);
            } //End block
            invalidate();
        } //End block
        {
            {
                changeCurrent(mValue + 1);
            } //End block
            {
                changeCurrent(mValue - 1);
            } //End block
        } //End block
        addTaint(increment);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.522 -0400", hash_original_method = "175AF73F53EDEE092962AA03BDCBD819", hash_generated_method = "BA882BA7D27856AD12B1C976EEEBB952")
    private void forceCompleteChangeCurrentByOneViaScroll() {
        Scroller scroller;
        scroller = mFlingScroller;
        {
            boolean var79EC7B17A696456895CDE1769AF4D31C_1699643731 = (!scroller.isFinished());
            {
                int yBeforeAbort;
                yBeforeAbort = scroller.getCurrY();
                scroller.abortAnimation();
                int yDelta;
                yDelta = scroller.getCurrY() - yBeforeAbort;
                scrollBy(0, yDelta);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Scroller scroller = mFlingScroller;
        //if (!scroller.isFinished()) {
            //final int yBeforeAbort = scroller.getCurrY();
            //scroller.abortAnimation();
            //final int yDelta = scroller.getCurrY() - yBeforeAbort;
            //scrollBy(0, yDelta);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.523 -0400", hash_original_method = "E601C50DC508DF2554B27F10B4080C00", hash_generated_method = "854E13878E2A580F8B76F32D86F7B810")
    @SuppressWarnings("unused")
    private void setSelectorPaintAlpha(int alpha) {
        mSelectorWheelPaint.setAlpha(alpha);
        invalidate();
        addTaint(alpha);
        // ---------- Original Method ----------
        //mSelectorWheelPaint.setAlpha(alpha);
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.523 -0400", hash_original_method = "400782BE1118D85D04FD2365A968D2CF", hash_generated_method = "377BA2C70B7F4C29C503C75B6D65DFC1")
    private boolean isEventInVisibleViewHitRect(MotionEvent event, View view) {
        {
            boolean var4FA967B24D74723277F0BCAF2B4F93C7_681194993 = (view.getVisibility() == VISIBLE);
            {
                view.getHitRect(mTempRect);
                boolean var76CCAF4B062EA4DD2689484DA5C510AF_500628540 = (mTempRect.contains((int) event.getX(), (int) event.getY()));
            } //End block
        } //End collapsed parenthetic
        addTaint(event.getTaint());
        addTaint(view.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2110992901 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2110992901;
        // ---------- Original Method ----------
        //if (view.getVisibility() == VISIBLE) {
            //view.getHitRect(mTempRect);
            //return mTempRect.contains((int) event.getX(), (int) event.getY());
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.524 -0400", hash_original_method = "BF95E4EC078F38B02D5C875137382733", hash_generated_method = "151DEA813EB536A8CC7D1C63D9BF7473")
    private void setSelectorWheelState(int selectorWheelState) {
        mSelectorWheelState = selectorWheelState;
        {
            mSelectorWheelPaint.setAlpha(SELECTOR_WHEEL_BRIGHT_ALPHA);
        } //End block
        {
            boolean var9885E03B24F176BACE9F994872275A69_750028153 = (mFlingable && selectorWheelState == SELECTOR_WHEEL_STATE_LARGE
                && AccessibilityManager.getInstance(mContext).isEnabled());
            {
                AccessibilityManager.getInstance(mContext).interrupt();
                String text;
                text = mContext.getString(R.string.number_picker_increment_scroll_action);
                mInputText.setContentDescription(text);
                mInputText.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
                mInputText.setContentDescription(null);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //mSelectorWheelState = selectorWheelState;
        //if (selectorWheelState == SELECTOR_WHEEL_STATE_LARGE) {
            //mSelectorWheelPaint.setAlpha(SELECTOR_WHEEL_BRIGHT_ALPHA);
        //}
        //if (mFlingable && selectorWheelState == SELECTOR_WHEEL_STATE_LARGE
                //&& AccessibilityManager.getInstance(mContext).isEnabled()) {
            //AccessibilityManager.getInstance(mContext).interrupt();
            //String text = mContext.getString(R.string.number_picker_increment_scroll_action);
            //mInputText.setContentDescription(text);
            //mInputText.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
            //mInputText.setContentDescription(null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.528 -0400", hash_original_method = "77AB1B93BD5012BE4D83745B76853590", hash_generated_method = "B551AB4DD2A6B5C9E82124019487A375")
    private void initializeSelectorWheel() {
        initializeSelectorWheelIndices();
        int[] selectorIndices;
        selectorIndices = mSelectorIndices;
        int totalTextHeight;
        totalTextHeight = selectorIndices.length * mTextSize;
        float totalTextGapHeight;
        totalTextGapHeight = (mBottom - mTop) - totalTextHeight;
        float textGapCount;
        textGapCount = selectorIndices.length - 1;
        mSelectorTextGapHeight = (int) (totalTextGapHeight / textGapCount + 0.5f);
        mSelectorElementHeight = mTextSize + mSelectorTextGapHeight;
        int editTextTextPosition;
        editTextTextPosition = mInputText.getBaseline() + mInputText.getTop();
        mInitialScrollOffset = editTextTextPosition -
                (mSelectorElementHeight * SELECTOR_MIDDLE_ITEM_INDEX);
        mCurrentScrollOffset = mInitialScrollOffset;
        updateInputTextView();
        // ---------- Original Method ----------
        //initializeSelectorWheelIndices();
        //int[] selectorIndices = mSelectorIndices;
        //int totalTextHeight = selectorIndices.length * mTextSize;
        //float totalTextGapHeight = (mBottom - mTop) - totalTextHeight;
        //float textGapCount = selectorIndices.length - 1;
        //mSelectorTextGapHeight = (int) (totalTextGapHeight / textGapCount + 0.5f);
        //mSelectorElementHeight = mTextSize + mSelectorTextGapHeight;
        //int editTextTextPosition = mInputText.getBaseline() + mInputText.getTop();
        //mInitialScrollOffset = editTextTextPosition -
                //(mSelectorElementHeight * SELECTOR_MIDDLE_ITEM_INDEX);
        //mCurrentScrollOffset = mInitialScrollOffset;
        //updateInputTextView();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.536 -0400", hash_original_method = "C54C7499288517561E53B381ADACF410", hash_generated_method = "E90A0086BF2AA91401C69932ABBDF6CA")
    private void initializeFadingEdges() {
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength((mBottom - mTop - mTextSize) / 2);
        // ---------- Original Method ----------
        //setVerticalFadingEdgeEnabled(true);
        //setFadingEdgeLength((mBottom - mTop - mTextSize) / 2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.536 -0400", hash_original_method = "424BD543DA2123CE0E799CAFA377A1E0", hash_generated_method = "D7F231598AB07DDB2FFE6CD9D7EDD8C8")
    private void onScrollerFinished(Scroller scroller) {
        {
            {
                postAdjustScrollerCommand(0);
                onScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
            } //End block
            {
                updateInputTextView();
                fadeSelectorWheel(mShowInputControlsAnimimationDuration);
            } //End block
        } //End block
        {
            updateInputTextView();
            showInputControls(mShowInputControlsAnimimationDuration);
        } //End block
        addTaint(scroller.getTaint());
        // ---------- Original Method ----------
        //if (scroller == mFlingScroller) {
            //if (mSelectorWheelState == SELECTOR_WHEEL_STATE_LARGE) {
                //postAdjustScrollerCommand(0);
                //onScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
            //} else {
                //updateInputTextView();
                //fadeSelectorWheel(mShowInputControlsAnimimationDuration);
            //}
        //} else {
            //updateInputTextView();
            //showInputControls(mShowInputControlsAnimimationDuration);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.537 -0400", hash_original_method = "76A35782DE0E02AA234AC6648796EFD6", hash_generated_method = "47B78D7C5F7D84128ACFEB14476616E6")
    private void onScrollStateChange(int scrollState) {
        mScrollState = scrollState;
        {
            mOnScrollListener.onScrollStateChange(this, scrollState);
        } //End block
        // ---------- Original Method ----------
        //if (mScrollState == scrollState) {
            //return;
        //}
        //mScrollState = scrollState;
        //if (mOnScrollListener != null) {
            //mOnScrollListener.onScrollStateChange(this, scrollState);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.538 -0400", hash_original_method = "089FFF3145B83D850B8641EBACA81A89", hash_generated_method = "D66A4A23A60932B3EED3C5F61056B9A4")
    private void fling(int velocityY) {
        mPreviousScrollerY = 0;
        {
            mFlingScroller.fling(0, 0, 0, velocityY, 0, 0, 0, Integer.MAX_VALUE);
        } //End block
        {
            mFlingScroller.fling(0, Integer.MAX_VALUE, 0, velocityY, 0, 0, 0, Integer.MAX_VALUE);
        } //End block
        invalidate();
        addTaint(velocityY);
        // ---------- Original Method ----------
        //mPreviousScrollerY = 0;
        //if (velocityY > 0) {
            //mFlingScroller.fling(0, 0, 0, velocityY, 0, 0, 0, Integer.MAX_VALUE);
        //} else {
            //mFlingScroller.fling(0, Integer.MAX_VALUE, 0, velocityY, 0, 0, 0, Integer.MAX_VALUE);
        //}
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.538 -0400", hash_original_method = "84887968F9B86CB6F225BC4761B2C961", hash_generated_method = "1D21AF4908382088EF5471059FF2483B")
    private void hideInputControls() {
        mShowInputControlsAnimator.cancel();
        mIncrementButton.setVisibility(INVISIBLE);
        mDecrementButton.setVisibility(INVISIBLE);
        mInputText.setVisibility(INVISIBLE);
        // ---------- Original Method ----------
        //mShowInputControlsAnimator.cancel();
        //mIncrementButton.setVisibility(INVISIBLE);
        //mDecrementButton.setVisibility(INVISIBLE);
        //mInputText.setVisibility(INVISIBLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.554 -0400", hash_original_method = "568B02CE0458B050F29128E328730206", hash_generated_method = "4750B4675625D3922EB4A00379AB28EF")
    private void showInputControls(long animationDuration) {
        updateIncrementAndDecrementButtonsVisibilityState();
        mInputText.setVisibility(VISIBLE);
        mShowInputControlsAnimator.setDuration(animationDuration);
        mShowInputControlsAnimator.start();
        addTaint(animationDuration);
        // ---------- Original Method ----------
        //updateIncrementAndDecrementButtonsVisibilityState();
        //mInputText.setVisibility(VISIBLE);
        //mShowInputControlsAnimator.setDuration(animationDuration);
        //mShowInputControlsAnimator.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.555 -0400", hash_original_method = "04EF8175CF934E94876E7611B3BFDBC2", hash_generated_method = "F70005C97B33B112B539BDCFFC093859")
    private void fadeSelectorWheel(long animationDuration) {
        mInputText.setVisibility(VISIBLE);
        mDimSelectorWheelAnimator.setDuration(animationDuration);
        mDimSelectorWheelAnimator.start();
        addTaint(animationDuration);
        // ---------- Original Method ----------
        //mInputText.setVisibility(VISIBLE);
        //mDimSelectorWheelAnimator.setDuration(animationDuration);
        //mDimSelectorWheelAnimator.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.555 -0400", hash_original_method = "F06555D042A3011B2943A92CA9FE7B6C", hash_generated_method = "5D4FC3CDFD76D75AC911C1A1EDFC9211")
    private void updateIncrementAndDecrementButtonsVisibilityState() {
        {
            mIncrementButton.setVisibility(VISIBLE);
        } //End block
        {
            mIncrementButton.setVisibility(INVISIBLE);
        } //End block
        {
            mDecrementButton.setVisibility(VISIBLE);
        } //End block
        {
            mDecrementButton.setVisibility(INVISIBLE);
        } //End block
        // ---------- Original Method ----------
        //if (mWrapSelectorWheel || mValue < mMaxValue) {
            //mIncrementButton.setVisibility(VISIBLE);
        //} else {
            //mIncrementButton.setVisibility(INVISIBLE);
        //}
        //if (mWrapSelectorWheel || mValue > mMinValue) {
            //mDecrementButton.setVisibility(VISIBLE);
        //} else {
            //mDecrementButton.setVisibility(INVISIBLE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.556 -0400", hash_original_method = "98EC96D2E9172670F87F406C69617E1C", hash_generated_method = "D6291FF69A80C40E158CA89F0F8670CF")
    private int getWrappedSelectorIndex(int selectorIndex) {
        addTaint(selectorIndex);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2121536372 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2121536372;
        // ---------- Original Method ----------
        //if (selectorIndex > mMaxValue) {
            //return mMinValue + (selectorIndex - mMaxValue) % (mMaxValue - mMinValue) - 1;
        //} else if (selectorIndex < mMinValue) {
            //return mMaxValue - (mMinValue - selectorIndex) % (mMaxValue - mMinValue) + 1;
        //}
        //return selectorIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.558 -0400", hash_original_method = "76B5F467E3A3E0B55117DFD0AE112AD7", hash_generated_method = "24D5DE888ADD001E7DAA2ED33FC7633E")
    private void incrementSelectorIndices(int[] selectorIndices) {
        {
            int i;
            i = 0;
            {
                selectorIndices[i] = selectorIndices[i + 1];
            } //End block
        } //End collapsed parenthetic
        int nextScrollSelectorIndex;
        nextScrollSelectorIndex = selectorIndices[selectorIndices.length - 2] + 1;
        {
            nextScrollSelectorIndex = mMinValue;
        } //End block
        selectorIndices[selectorIndices.length - 1] = nextScrollSelectorIndex;
        ensureCachedScrollSelectorValue(nextScrollSelectorIndex);
        addTaint(selectorIndices[0]);
        // ---------- Original Method ----------
        //for (int i = 0; i < selectorIndices.length - 1; i++) {
            //selectorIndices[i] = selectorIndices[i + 1];
        //}
        //int nextScrollSelectorIndex = selectorIndices[selectorIndices.length - 2] + 1;
        //if (mWrapSelectorWheel && nextScrollSelectorIndex > mMaxValue) {
            //nextScrollSelectorIndex = mMinValue;
        //}
        //selectorIndices[selectorIndices.length - 1] = nextScrollSelectorIndex;
        //ensureCachedScrollSelectorValue(nextScrollSelectorIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.565 -0400", hash_original_method = "3BAE7243B627F51EC3CF3C9DBFE60CD6", hash_generated_method = "EF4C7435AB753E26805E9A566A30E0BE")
    private void decrementSelectorIndices(int[] selectorIndices) {
        {
            int i;
            i = selectorIndices.length - 1;
            {
                selectorIndices[i] = selectorIndices[i - 1];
            } //End block
        } //End collapsed parenthetic
        int nextScrollSelectorIndex;
        nextScrollSelectorIndex = selectorIndices[1] - 1;
        {
            nextScrollSelectorIndex = mMaxValue;
        } //End block
        selectorIndices[0] = nextScrollSelectorIndex;
        ensureCachedScrollSelectorValue(nextScrollSelectorIndex);
        addTaint(selectorIndices[0]);
        // ---------- Original Method ----------
        //for (int i = selectorIndices.length - 1; i > 0; i--) {
            //selectorIndices[i] = selectorIndices[i - 1];
        //}
        //int nextScrollSelectorIndex = selectorIndices[1] - 1;
        //if (mWrapSelectorWheel && nextScrollSelectorIndex < mMinValue) {
            //nextScrollSelectorIndex = mMaxValue;
        //}
        //selectorIndices[0] = nextScrollSelectorIndex;
        //ensureCachedScrollSelectorValue(nextScrollSelectorIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.571 -0400", hash_original_method = "5C7213EC7C24F2EA6A4CE0C3E4F76F00", hash_generated_method = "93F9609083A9A94BD8EBEF80FB7ABADC")
    private void ensureCachedScrollSelectorValue(int selectorIndex) {
        SparseArray<String> cache;
        cache = mSelectorIndexToStringCache;
        String scrollSelectorValue;
        scrollSelectorValue = cache.get(selectorIndex);
        {
            scrollSelectorValue = "";
        } //End block
        {
            {
                int displayedValueIndex;
                displayedValueIndex = selectorIndex - mMinValue;
                scrollSelectorValue = mDisplayedValues[displayedValueIndex];
            } //End block
            {
                scrollSelectorValue = formatNumber(selectorIndex);
            } //End block
        } //End block
        cache.put(selectorIndex, scrollSelectorValue);
        addTaint(selectorIndex);
        // ---------- Original Method ----------
        //SparseArray<String> cache = mSelectorIndexToStringCache;
        //String scrollSelectorValue = cache.get(selectorIndex);
        //if (scrollSelectorValue != null) {
            //return;
        //}
        //if (selectorIndex < mMinValue || selectorIndex > mMaxValue) {
            //scrollSelectorValue = "";
        //} else {
            //if (mDisplayedValues != null) {
                //int displayedValueIndex = selectorIndex - mMinValue;
                //scrollSelectorValue = mDisplayedValues[displayedValueIndex];
            //} else {
                //scrollSelectorValue = formatNumber(selectorIndex);
            //}
        //}
        //cache.put(selectorIndex, scrollSelectorValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.571 -0400", hash_original_method = "CED5CD69155B2474785611FEBB1C2BE4", hash_generated_method = "4BE807BE75080F15E54FDF3BD98DCC7B")
    private String formatNumber(int value) {
        String varB4EAC82CA7396A68D541C85D26508E83_1799558078 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1799558078 = (mFormatter != null) ? mFormatter.format(value) : String.valueOf(value);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1799558078.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1799558078;
        // ---------- Original Method ----------
        //return (mFormatter != null) ? mFormatter.format(value) : String.valueOf(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.574 -0400", hash_original_method = "9B2E73D457CEF5FA8F9D91E45C672313", hash_generated_method = "96CBA6E330B1092C42223A69A76BC2D5")
    private void validateInputTextView(View v) {
        String str;
        str = String.valueOf(((TextView) v).getText());
        {
            boolean var80F2FE8CCED42585D57F5737FEC1F237_1333706598 = (TextUtils.isEmpty(str));
            {
                updateInputTextView();
            } //End block
            {
                int current;
                current = getSelectedPos(str.toString());
                changeCurrent(current);
            } //End block
        } //End collapsed parenthetic
        addTaint(v.getTaint());
        // ---------- Original Method ----------
        //String str = String.valueOf(((TextView) v).getText());
        //if (TextUtils.isEmpty(str)) {
            //updateInputTextView();
        //} else {
            //int current = getSelectedPos(str.toString());
            //changeCurrent(current);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.592 -0400", hash_original_method = "B42CFCB10E8E291BCAC25CBB8DE3CDCA", hash_generated_method = "F3D986068C58ECCF5FC81A1C62C2407A")
    private void updateInputTextView() {
        {
            mInputText.setText(formatNumber(mValue));
        } //End block
        {
            mInputText.setText(mDisplayedValues[mValue - mMinValue]);
        } //End block
        mInputText.setSelection(mInputText.getText().length());
        {
            boolean var43F3BC8EA342F30A35D21A53A53AAA0F_1386695783 = (mFlingable && AccessibilityManager.getInstance(mContext).isEnabled());
            {
                String text;
                text = mContext.getString(R.string.number_picker_increment_scroll_mode,
                    mInputText.getText());
                mInputText.setContentDescription(text);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mDisplayedValues == null) {
            //mInputText.setText(formatNumber(mValue));
        //} else {
            //mInputText.setText(mDisplayedValues[mValue - mMinValue]);
        //}
        //mInputText.setSelection(mInputText.getText().length());
        //if (mFlingable && AccessibilityManager.getInstance(mContext).isEnabled()) {
            //String text = mContext.getString(R.string.number_picker_increment_scroll_mode,
                    //mInputText.getText());
            //mInputText.setContentDescription(text);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.597 -0400", hash_original_method = "EE3C020B4BB89830916EAF8B846EA64D", hash_generated_method = "2B38531F31BC6FEE22FB1B736150F4BC")
    private void notifyChange(int previous, int current) {
        {
            mOnValueChangeListener.onValueChange(this, previous, mValue);
        } //End block
        addTaint(previous);
        addTaint(current);
        // ---------- Original Method ----------
        //if (mOnValueChangeListener != null) {
            //mOnValueChangeListener.onValueChange(this, previous, mValue);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.598 -0400", hash_original_method = "89117A76C28F4F0E670F85E62CCFCD15", hash_generated_method = "3099D787EF45DB26BCB2981908C16A42")
    private void postChangeCurrentByOneFromLongPress(boolean increment) {
        mInputText.clearFocus();
        removeAllCallbacks();
        {
            mChangeCurrentByOneFromLongPressCommand = new ChangeCurrentByOneFromLongPressCommand();
        } //End block
        mChangeCurrentByOneFromLongPressCommand.setIncrement(increment);
        post(mChangeCurrentByOneFromLongPressCommand);
        addTaint(increment);
        // ---------- Original Method ----------
        //mInputText.clearFocus();
        //removeAllCallbacks();
        //if (mChangeCurrentByOneFromLongPressCommand == null) {
            //mChangeCurrentByOneFromLongPressCommand = new ChangeCurrentByOneFromLongPressCommand();
        //}
        //mChangeCurrentByOneFromLongPressCommand.setIncrement(increment);
        //post(mChangeCurrentByOneFromLongPressCommand);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.598 -0400", hash_original_method = "2F67DA682EF8D26EE412EBB702FD21A7", hash_generated_method = "08CB7DAF1B4C1F2BADA68CFC7F766A4C")
    private void removeAllCallbacks() {
        {
            removeCallbacks(mChangeCurrentByOneFromLongPressCommand);
        } //End block
        {
            removeCallbacks(mAdjustScrollerCommand);
        } //End block
        {
            removeCallbacks(mSetSelectionCommand);
        } //End block
        // ---------- Original Method ----------
        //if (mChangeCurrentByOneFromLongPressCommand != null) {
            //removeCallbacks(mChangeCurrentByOneFromLongPressCommand);
        //}
        //if (mAdjustScrollerCommand != null) {
            //removeCallbacks(mAdjustScrollerCommand);
        //}
        //if (mSetSelectionCommand != null) {
            //removeCallbacks(mSetSelectionCommand);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.600 -0400", hash_original_method = "C9822A8BF3CD293D75693533B44BD287", hash_generated_method = "A3C3A9474FD4185E2C986673479A5AB7")
    private int getSelectedPos(String value) {
        {
            try 
            {
                int varED3B125EC058774A40CC8032FA8A61DA_859543508 = (Integer.parseInt(value));
            } //End block
            catch (NumberFormatException e)
            { }
        } //End block
        {
            {
                int i;
                i = 0;
                {
                    value = value.toLowerCase();
                    {
                        boolean var3597831DC70C370CF274A604DC8D1FB5_2117675416 = (mDisplayedValues[i].toLowerCase().startsWith(value));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            try 
            {
                int varED3B125EC058774A40CC8032FA8A61DA_753025661 = (Integer.parseInt(value));
            } //End block
            catch (NumberFormatException e)
            { }
        } //End block
        addTaint(value.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_71589836 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_71589836;
        // ---------- Original Method ----------
        //if (mDisplayedValues == null) {
            //try {
                //return Integer.parseInt(value);
            //} catch (NumberFormatException e) {
            //}
        //} else {
            //for (int i = 0; i < mDisplayedValues.length; i++) {
                //value = value.toLowerCase();
                //if (mDisplayedValues[i].toLowerCase().startsWith(value)) {
                    //return mMinValue + i;
                //}
            //}
            //try {
                //return Integer.parseInt(value);
            //} catch (NumberFormatException e) {
            //}
        //}
        //return mMinValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.600 -0400", hash_original_method = "B20C23507728532B22E954D2186CEEA6", hash_generated_method = "03EB5208482034AC7730A22281AA7586")
    private void postSetSelectionCommand(int selectionStart, int selectionEnd) {
        {
            mSetSelectionCommand = new SetSelectionCommand();
        } //End block
        {
            removeCallbacks(mSetSelectionCommand);
        } //End block
        mSetSelectionCommand.mSelectionStart = selectionStart;
        mSetSelectionCommand.mSelectionEnd = selectionEnd;
        post(mSetSelectionCommand);
        // ---------- Original Method ----------
        //if (mSetSelectionCommand == null) {
            //mSetSelectionCommand = new SetSelectionCommand();
        //} else {
            //removeCallbacks(mSetSelectionCommand);
        //}
        //mSetSelectionCommand.mSelectionStart = selectionStart;
        //mSetSelectionCommand.mSelectionEnd = selectionEnd;
        //post(mSetSelectionCommand);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.601 -0400", hash_original_method = "54DD268EE848B5EAB62BAC6791547633", hash_generated_method = "4357904072846A1105D266FA986D568B")
    private void postAdjustScrollerCommand(int delayMillis) {
        {
            mAdjustScrollerCommand = new AdjustScrollerCommand();
        } //End block
        {
            removeCallbacks(mAdjustScrollerCommand);
        } //End block
        postDelayed(mAdjustScrollerCommand, delayMillis);
        addTaint(delayMillis);
        // ---------- Original Method ----------
        //if (mAdjustScrollerCommand == null) {
            //mAdjustScrollerCommand = new AdjustScrollerCommand();
        //} else {
            //removeCallbacks(mAdjustScrollerCommand);
        //}
        //postDelayed(mAdjustScrollerCommand, delayMillis);
    }

    
    class InputTextFilter extends NumberKeyListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.601 -0400", hash_original_method = "10D9049FFA6F11A4560862F2A7A49039", hash_generated_method = "10D9049FFA6F11A4560862F2A7A49039")
        public InputTextFilter ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.602 -0400", hash_original_method = "5619839AC48FF521F5D3DA01ED2E4A22", hash_generated_method = "37820E48B68768B951EB19449D2A0EA8")
        public int getInputType() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1045131110 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1045131110;
            // ---------- Original Method ----------
            //return InputType.TYPE_CLASS_TEXT;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.615 -0400", hash_original_method = "42F7B3A0BEAF29BB6B3A7A3A6D3C7695", hash_generated_method = "0D6662040565B834E9414575D950E191")
        @Override
        protected char[] getAcceptedChars() {
            char[] var50607924ABD4C17119BAF3A1CE41C0EC_1012507901 = {getTaintChar()};
            return var50607924ABD4C17119BAF3A1CE41C0EC_1012507901;
            // ---------- Original Method ----------
            //return DIGIT_CHARACTERS;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.701 -0400", hash_original_method = "74A3271C967FA5A66FEC87FCC33CF2BB", hash_generated_method = "CA224E2B930C53EC601D0ED11846178A")
        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest,
                int dstart, int dend) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1066793759 = null; //Variable for return #1
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_118747110 = null; //Variable for return #2
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_445707770 = null; //Variable for return #3
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_767364595 = null; //Variable for return #4
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_600882936 = null; //Variable for return #5
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1583292396 = null; //Variable for return #6
            {
                CharSequence filtered;
                filtered = super.filter(source, start, end, dest, dstart, dend);
                {
                    filtered = source.subSequence(start, end);
                } //End block
                String result;
                result = String.valueOf(dest.subSequence(0, dstart)) + filtered
                        + dest.subSequence(dend, dest.length());
                {
                    boolean varD7CE5EE75488B655CC1D56612F69FDCB_1731045177 = ("".equals(result));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1066793759 = result;
                    } //End block
                } //End collapsed parenthetic
                int val;
                val = getSelectedPos(result);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_118747110 = "";
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_445707770 = filtered;
                } //End block
            } //End block
            {
                CharSequence filtered;
                filtered = String.valueOf(source.subSequence(start, end));
                {
                    boolean var7969EAAC11BC0DD892602470F9CC777E_471737180 = (TextUtils.isEmpty(filtered));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_767364595 = "";
                    } //End block
                } //End collapsed parenthetic
                String result;
                result = String.valueOf(dest.subSequence(0, dstart)) + filtered
                        + dest.subSequence(dend, dest.length());
                String str;
                str = String.valueOf(result).toLowerCase();
                {
                    String val = mDisplayedValues[0];
                    {
                        String valLowerCase;
                        valLowerCase = val.toLowerCase();
                        {
                            boolean var316865265098CA9A9D5D06E2D063F80A_884759762 = (valLowerCase.startsWith(str));
                            {
                                postSetSelectionCommand(result.length(), val.length());
                                varB4EAC82CA7396A68D541C85D26508E83_600882936 = val.subSequence(dstart, val.length());
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_1583292396 = "";
            } //End block
            addTaint(source.getTaint());
            addTaint(start);
            addTaint(end);
            addTaint(dest.getTaint());
            addTaint(dstart);
            addTaint(dend);
            CharSequence varA7E53CE21691AB073D9660D615818899_668088830; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_668088830 = varB4EAC82CA7396A68D541C85D26508E83_1066793759;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_668088830 = varB4EAC82CA7396A68D541C85D26508E83_118747110;
                    break;
                case 3: //Assign result for return ordinal #3
                    varA7E53CE21691AB073D9660D615818899_668088830 = varB4EAC82CA7396A68D541C85D26508E83_445707770;
                    break;
                case 4: //Assign result for return ordinal #4
                    varA7E53CE21691AB073D9660D615818899_668088830 = varB4EAC82CA7396A68D541C85D26508E83_767364595;
                    break;
                case 5: //Assign result for return ordinal #5
                    varA7E53CE21691AB073D9660D615818899_668088830 = varB4EAC82CA7396A68D541C85D26508E83_600882936;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_668088830 = varB4EAC82CA7396A68D541C85D26508E83_1583292396;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_668088830.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_668088830;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    class SetSelectionCommand implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.702 -0400", hash_original_field = "61BC4CC0CEBB67582239843EAC8C216E", hash_generated_field = "F02C1BE48395D503EBA5C8443CFA9BF4")

        private int mSelectionStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.702 -0400", hash_original_field = "33EA9C8C559E59D359CC561F05D6AA8C", hash_generated_field = "C8C5CBC35C679AC5A64E276363F892A9")

        private int mSelectionEnd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.702 -0400", hash_original_method = "8A1B763782C13D7A531CCCB7905DBC5E", hash_generated_method = "8A1B763782C13D7A531CCCB7905DBC5E")
        public SetSelectionCommand ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.702 -0400", hash_original_method = "5A9CF76A42C671BAE659DDDD324A19D9", hash_generated_method = "D5DE829BC4A9BD93C1BA19F296BB6266")
        public void run() {
            mInputText.setSelection(mSelectionStart, mSelectionEnd);
            // ---------- Original Method ----------
            //mInputText.setSelection(mSelectionStart, mSelectionEnd);
        }

        
    }


    
    class AdjustScrollerCommand implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.703 -0400", hash_original_method = "04A50735AF7565EFEB09DB8389B3EF59", hash_generated_method = "04A50735AF7565EFEB09DB8389B3EF59")
        public AdjustScrollerCommand ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.703 -0400", hash_original_method = "1728A296542E5FB10F5D2F850E617FE1", hash_generated_method = "3B6D685286256E8E63CBEDA201AD968D")
        public void run() {
            mPreviousScrollerY = 0;
            {
                updateInputTextView();
                showInputControls(mShowInputControlsAnimimationDuration);
            } //End block
            int deltaY;
            deltaY = mInitialScrollOffset - mCurrentScrollOffset;
            {
                boolean var6323F228A85B2A4B104B3FC1C233D7DC_189905443 = (Math.abs(deltaY) > mSelectorElementHeight / 2);
                {
                    deltaY += (deltaY > 0) ? -mSelectorElementHeight : mSelectorElementHeight;
                } //End block
            } //End collapsed parenthetic
            mAdjustScroller.startScroll(0, 0, 0, deltaY, SELECTOR_ADJUSTMENT_DURATION_MILLIS);
            invalidate();
            // ---------- Original Method ----------
            //mPreviousScrollerY = 0;
            //if (mInitialScrollOffset == mCurrentScrollOffset) {
                //updateInputTextView();
                //showInputControls(mShowInputControlsAnimimationDuration);
                //return;
            //}
            //int deltaY = mInitialScrollOffset - mCurrentScrollOffset;
            //if (Math.abs(deltaY) > mSelectorElementHeight / 2) {
                //deltaY += (deltaY > 0) ? -mSelectorElementHeight : mSelectorElementHeight;
            //}
            //mAdjustScroller.startScroll(0, 0, 0, deltaY, SELECTOR_ADJUSTMENT_DURATION_MILLIS);
            //invalidate();
        }

        
    }


    
    class ChangeCurrentByOneFromLongPressCommand implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.711 -0400", hash_original_field = "B954C9EDAC21852B96AD8DA47FB0BB4A", hash_generated_field = "729B17CE9B5C6450F7852DCD6B7829FA")

        private boolean mIncrement;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.712 -0400", hash_original_method = "A263DA149B2C322986CF6F1865703F44", hash_generated_method = "A263DA149B2C322986CF6F1865703F44")
        public ChangeCurrentByOneFromLongPressCommand ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.712 -0400", hash_original_method = "ED1739B7A0ACAE655C07ED8C0ABABF1C", hash_generated_method = "3E122DEB3F2DDEA67EBDA1CC64C07EBB")
        private void setIncrement(boolean increment) {
            mIncrement = increment;
            // ---------- Original Method ----------
            //mIncrement = increment;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.712 -0400", hash_original_method = "1F108533BE53D637572F8F49778F205C", hash_generated_method = "CA83D2C22E3899643BFF96D7CD8EDDDC")
        public void run() {
            changeCurrentByOne(mIncrement);
            postDelayed(this, mLongPressUpdateInterval);
            // ---------- Original Method ----------
            //changeCurrentByOne(mIncrement);
            //postDelayed(this, mLongPressUpdateInterval);
        }

        
    }


    
    public interface OnValueChangeListener {

        
        void onValueChange(NumberPicker picker, int oldVal, int newVal);
    }
    
    public interface OnScrollListener {

        
        public static int SCROLL_STATE_IDLE = 0;

        
        public static int SCROLL_STATE_TOUCH_SCROLL = 1;

        
        public static int SCROLL_STATE_FLING = 2;

        
        public void onScrollStateChange(NumberPicker view, int scrollState);
    }
    
    public interface Formatter {

        
        public String format(int value);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.712 -0400", hash_original_field = "C5A9E787ABA4BAACCB788D1F0885106B", hash_generated_field = "3C7CF95C9DAA910FE41A7130A6345397")

    private static long DEFAULT_LONG_PRESS_UPDATE_INTERVAL = 300;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.712 -0400", hash_original_field = "E04B091B1D565E6042C78271EA6ED98C", hash_generated_field = "6E5EF122A2E6DCD3870085E32DB44037")

    private static int SELECTOR_MIDDLE_ITEM_INDEX = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.712 -0400", hash_original_field = "E11D9C628CD4DF30ACE541A56D2F5151", hash_generated_field = "92E787F40680A5FAF134BA8D718711BA")

    private static int SELECTOR_MAX_FLING_VELOCITY_ADJUSTMENT = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.712 -0400", hash_original_field = "1C65740AF5F3CC66B57E41FF6FA3A795", hash_generated_field = "B1DB32EB38C0C62002F4B066A274E54C")

    private static int SELECTOR_ADJUSTMENT_DURATION_MILLIS = 800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.713 -0400", hash_original_field = "CD7BC2810D52AF97EE7BC2806CA83C35", hash_generated_field = "CCF81EB75375EB21D3B1089DD8E19D04")

    private static int CHANGE_CURRENT_BY_ONE_SCROLL_DURATION = 300;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.713 -0400", hash_original_field = "54B40FBA44C9E21468F0297E7DF3C1BD", hash_generated_field = "496B559A6CF2C5921F8A4CA6A5A1871D")

    private static int SHOW_INPUT_CONTROLS_DELAY_MILLIS = ViewConfiguration
            .getDoubleTapTimeout();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.713 -0400", hash_original_field = "4120131B75A717DDA48DB2F0A5F8DD95", hash_generated_field = "EE8EC6D90FBA95B5F34CAFF23B36BC01")

    private static float TOP_AND_BOTTOM_FADING_EDGE_STRENGTH = 0.9f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.713 -0400", hash_original_field = "FC6F009C65B0C75C0C5DF23CF67AE36C", hash_generated_field = "4DF6ADBB1B6C45309A2DE28CCB0957AD")

    private static int UNSCALED_DEFAULT_SELECTION_DIVIDER_HEIGHT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.713 -0400", hash_original_field = "FC5BE2F5ADC68A2D3A95F2001E2D54E1", hash_generated_field = "12F5CD8667F483CA211C48519AAB1F90")

    private static int SELECTOR_WHEEL_STATE_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.713 -0400", hash_original_field = "DDDD525DD61FF5B6D63FF73A59F6E938", hash_generated_field = "F497F77F3FF78544FA6E193C7D4C6E69")

    private static int SELECTOR_WHEEL_STATE_SMALL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.713 -0400", hash_original_field = "B8978561F307D330D1D9035B84EF0F45", hash_generated_field = "8C471CE2F17C04647275141D9C6F6070")

    private static int SELECTOR_WHEEL_STATE_LARGE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.713 -0400", hash_original_field = "E034023518BDAF710C586D5E1AEAE57E", hash_generated_field = "0D841D6FE855639700B361FAED421DDF")

    private static int SELECTOR_WHEEL_BRIGHT_ALPHA = 255;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.713 -0400", hash_original_field = "3E24940F61253D0CC5795578AD7DBB57", hash_generated_field = "341599CF1A5A176C96A16519422E5F65")

    private static int SELECTOR_WHEEL_DIM_ALPHA = 60;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.713 -0400", hash_original_field = "42CDB19B884EBCE2A752E09B0FCE673B", hash_generated_field = "E863130AB8E94E89AEC99C5AB8E63A70")

    private static int BUTTON_ALPHA_TRANSPARENT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.713 -0400", hash_original_field = "13514DC76E0487E55F151EDEDFD73281", hash_generated_field = "69F181A290108F068CFEE24CCDFE641A")

    private static int BUTTON_ALPHA_OPAQUE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.713 -0400", hash_original_field = "9EE2BDD5DCE03B10066659DD3628FBCD", hash_generated_field = "A2E44956407C9BA6FA2478FE8032373F")

    private static String PROPERTY_SELECTOR_PAINT_ALPHA = "selectorPaintAlpha";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.713 -0400", hash_original_field = "37BEDAFF57045F20FFDBAD562A073CFD", hash_generated_field = "19E93F1AC4A2C75AB43B1A6482AF50B6")

    private static String PROPERTY_BUTTON_ALPHA = "alpha";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.713 -0400", hash_original_field = "26112D95E764086336908D74184B550D", hash_generated_field = "69D3D120F684C449B49A222348C124E6")

    private static char[] DIGIT_CHARACTERS = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.713 -0400", hash_original_field = "BADC6B9F8BD433ADA3F646E536B203CC", hash_generated_field = "E2C6CE4ED38B30D41FC42146DBE2950F")

    private static int SIZE_UNSPECIFIED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.713 -0400", hash_original_field = "A3D46BBAE1067437FBC6059261EF8DED", hash_generated_field = "9223D0CD28261C67BCD92327016FAD40")

    public static final NumberPicker.Formatter TWO_DIGIT_FORMATTER = new NumberPicker.Formatter() {
        final StringBuilder mBuilder = new StringBuilder();

        final java.util.Formatter mFmt = new java.util.Formatter(mBuilder, java.util.Locale.US);

        final Object[] mArgs = new Object[1];

        public String format(int value) {
            mArgs[0] = value;
            mBuilder.delete(0, mBuilder.length());
            mFmt.format("%02d", mArgs);
            return mFmt.toString();
        }
    };
}

