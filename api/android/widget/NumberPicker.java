package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.488 -0400", hash_original_field = "CDC94A8C72E149B8F56A2ECCE0F5829B", hash_generated_field = "6A00AC4B6A23FAEFDE0FF2E4DC66556D")

    private ImageButton mIncrementButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.488 -0400", hash_original_field = "16ED093CD569F2787F1C23E44FCD4425", hash_generated_field = "8919797DB93735517DC56DAC3932D3BA")

    private ImageButton mDecrementButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.489 -0400", hash_original_field = "C14F48486B85453A43488AE5193CF8F7", hash_generated_field = "9C0D266F19288A98A42D37200EC40143")

    private EditText mInputText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.489 -0400", hash_original_field = "7B1C5936E045E46CDC7DE29B76B9E7F4", hash_generated_field = "71F573E1A874063ABEFF604D7F39473B")

    private int mMinHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.489 -0400", hash_original_field = "C16CF8950AAD7E5F5E8D168AA605278E", hash_generated_field = "125D219AC8DBC9C1B67A62219F770498")

    private int mMaxHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.489 -0400", hash_original_field = "2FB832D2671571BF4EC0C84F8DA6AA79", hash_generated_field = "ED0C6BF081117F2A257C521DB4125AB9")

    private int mMinWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.489 -0400", hash_original_field = "C4C548A58212673838506E3498DE25A0", hash_generated_field = "538F7241A30BB30063B42E9CD336B31C")

    private int mMaxWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.489 -0400", hash_original_field = "97478DC5D8C7149868CCC53807A72C5F", hash_generated_field = "FAE2C92297C3C78F4EB9A80B09EABDB5")

    private boolean mComputeMaxWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.489 -0400", hash_original_field = "327DC1284D23313571A41B232E2678D5", hash_generated_field = "9990B8B20909CFDC9898F67C6FDD18EC")

    private int mTextSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.489 -0400", hash_original_field = "1A4708300277223FA34224C4BA423B21", hash_generated_field = "B4AB01F5C45EBC46EA14C63C779599C3")

    private int mSelectorTextGapHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.489 -0400", hash_original_field = "65C069E70C0AD49CFCFAA9D4950DC9E1", hash_generated_field = "9D634B524F57A9A167A822148025FAEE")

    private String[] mDisplayedValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.489 -0400", hash_original_field = "C996577FD89E2D9ACA600D3AF5442EB3", hash_generated_field = "F344B4C9A6EF700D43109B54646DFF70")

    private int mMinValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.489 -0400", hash_original_field = "EB798AAFC3D0D018951E684107D8CF72", hash_generated_field = "33227317DFADBDED006865404A880DAA")

    private int mMaxValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.489 -0400", hash_original_field = "CBAFE11E7BAE23358D70D54D132C3064", hash_generated_field = "1FE26AAF0F7068BF50C3FDD7D6BD850D")

    private int mValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.489 -0400", hash_original_field = "869F864F8952CB01B525214E795A5A7D", hash_generated_field = "0F0F61C7FD20796365412FDD7923438B")

    private OnValueChangeListener mOnValueChangeListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.489 -0400", hash_original_field = "0970AE3033B8F8E13936EF3E29D48B2E", hash_generated_field = "0E000F63F4EDDECD3CA33DA7CA7FEA0C")

    private OnScrollListener mOnScrollListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.489 -0400", hash_original_field = "9F70B7A1463B032732E51B2DC5F8D2E4", hash_generated_field = "C7348EA20A64E5E4153D9A81AAD67C67")

    private Formatter mFormatter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.489 -0400", hash_original_field = "413EEF7D99DC07B5EC9C5145AC0F5C28", hash_generated_field = "5475390B43BC34D0C8A978C8F9A847C2")

    private long mLongPressUpdateInterval = DEFAULT_LONG_PRESS_UPDATE_INTERVAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.490 -0400", hash_original_field = "BAA0DD0823784099A251EB0F9CA9A9EA", hash_generated_field = "9847ACB6B4DACF158F3D2FEBEA01CEE3")

    private final SparseArray<String> mSelectorIndexToStringCache = new SparseArray<String>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.490 -0400", hash_original_field = "8A339F6407BFD78104B48F0ECAD28E3C", hash_generated_field = "E21DFCC6B3D6A21319845AE11E11A50E")

    private final int[] mSelectorIndices = new int[] {
            Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE,
            Integer.MIN_VALUE
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.490 -0400", hash_original_field = "BA3EB1EEAD65457935945244BC382B5A", hash_generated_field = "20F4B411AF6CE39A519EBD45F26526F1")

    private Paint mSelectorWheelPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.490 -0400", hash_original_field = "A730982C8A0FA562D108C0B45C2118FA", hash_generated_field = "5CD8B3A0694C4DAD9DE6B5F7D563825B")

    private int mSelectorElementHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.490 -0400", hash_original_field = "06BC10383CC2F50633765057D3F32342", hash_generated_field = "1C64752769ECDFF4D4DADF48DFC62B2A")

    private int mInitialScrollOffset = Integer.MIN_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.490 -0400", hash_original_field = "64895DDC056DBE762EF71E643639863B", hash_generated_field = "867616A04972E32F759A945F5C8C6DE5")

    private int mCurrentScrollOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.490 -0400", hash_original_field = "69C03418900930ACA1575AFEDF095540", hash_generated_field = "A7FE0D43A8992E5853B470E81D7DC5CD")

    private Scroller mFlingScroller;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.490 -0400", hash_original_field = "B0E365F437A601CA01427FE0DB4F2E6C", hash_generated_field = "63E636A5CF531649A485C370342AD357")

    private Scroller mAdjustScroller;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.490 -0400", hash_original_field = "DB932D3A8194DC8018ABA5AC36C8D1F6", hash_generated_field = "235D804B1C18B69F2999347603A3A1E8")

    private int mPreviousScrollerY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.490 -0400", hash_original_field = "99BACC9AFE2B88FC46530BF5B507DD16", hash_generated_field = "A6929C7A4CC6DB84E0B021A11596A9A5")

    private SetSelectionCommand mSetSelectionCommand;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.490 -0400", hash_original_field = "3DEE03AFA2F5CBC86A752456233FF511", hash_generated_field = "2CCBB805FEDFC92E21EF25E3ACD258AE")

    private AdjustScrollerCommand mAdjustScrollerCommand;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.490 -0400", hash_original_field = "7EC379609ABEAA4196ADE870A50F340C", hash_generated_field = "7D45776D84FA49FF3DE5AD7BB6B6D7B3")

    private ChangeCurrentByOneFromLongPressCommand mChangeCurrentByOneFromLongPressCommand;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.490 -0400", hash_original_field = "586883B75FCB9090CFEDDD242D2E4A36", hash_generated_field = "FADCC7819944EB29C99CDA856F21DF00")

    private AnimatorSet mShowInputControlsAnimator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.490 -0400", hash_original_field = "49D2DEDB7BFF955105ECE3AE26F330CB", hash_generated_field = "32D55D7A2E6874CDD998EF34A3CF8BCE")

    private Animator mDimSelectorWheelAnimator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.490 -0400", hash_original_field = "2BB1A3C2BC0A6F74C19EF9789BDBFF6D", hash_generated_field = "05FA59074D08C75E813C9AC8A436526B")

    private float mLastDownEventY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.490 -0400", hash_original_field = "C629D869AF7F109D65ACFA526A36D0CC", hash_generated_field = "54CBBDE9743B0ECBCF94B59C2ADF715D")

    private float mLastMotionEventY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.490 -0400", hash_original_field = "F93D3947854BC4CBB41E75EE1ED0E587", hash_generated_field = "B26DD00B53AFA2DFD31DAB39D66D679A")

    private boolean mBeginEditOnUpEvent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.491 -0400", hash_original_field = "A4F05B85CDA6632955DF0B45972ABC84", hash_generated_field = "088B2EE9C72C787499D1C9756D7C9AE2")

    private boolean mAdjustScrollerOnUpEvent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.491 -0400", hash_original_field = "09CD264B06F94F0887A32BEDDD1E6DFD", hash_generated_field = "C2D0E72CEAF9BB67D06EF8A48CD873BF")

    private int mSelectorWheelState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.491 -0400", hash_original_field = "217FE873D59646EE0AC51688724FF274", hash_generated_field = "5BEE30D4541C1ECA385873E799FC4104")

    private VelocityTracker mVelocityTracker;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.491 -0400", hash_original_field = "3DFFFAD10926598D18EEC50D61DE79CA", hash_generated_field = "3B323323DD6A6BF972666D993592C670")

    private int mTouchSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.491 -0400", hash_original_field = "950A8222B535BF5159B013E5329A56C7", hash_generated_field = "19DF3CA9C4A086C5604F6C8FC7721322")

    private int mMinimumFlingVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.491 -0400", hash_original_field = "8ED13B950D5803064219CE68BB8F2695", hash_generated_field = "7F5E59D933F0155E107640D32355B310")

    private int mMaximumFlingVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.491 -0400", hash_original_field = "FC769FBB094551A074259CD0A7B6736A", hash_generated_field = "5C5871BE5B096A9BD740EB5329BEAAF1")

    private boolean mWrapSelectorWheel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.491 -0400", hash_original_field = "F761CF39D7B955BCB3910DD42D5B01E4", hash_generated_field = "0ACF9128B8830FF701248CF7C11543ED")

    private int mSolidColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.491 -0400", hash_original_field = "74EDC7A2D9E9DD81AA798FA12CD6F2A2", hash_generated_field = "DDEBF599D1C277FAE44436DE5F4925D9")

    private boolean mFlingable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.491 -0400", hash_original_field = "8FE4EFD51BBB41AB331239B6AFD59E58", hash_generated_field = "05188C781C0BE6F065277E3B64526E24")

    private Drawable mSelectionDivider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.491 -0400", hash_original_field = "86F82F4DE5B91E41E99B4154A931CF58", hash_generated_field = "8270882201C05EAC24EEFCE46B4DEF7E")

    private int mSelectionDividerHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.491 -0400", hash_original_field = "DF43B278CEE8933271AB3D9F9E312F86", hash_generated_field = "A498F2A4744F31D22F9C4ABEBB254F2F")

    private final Rect mTempRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.491 -0400", hash_original_field = "AB5FDA655F30463AF2CEB79B3A8271FF", hash_generated_field = "67AD5A07D54DA7533142AFF00645E1A8")

    private int mScrollState = OnScrollListener.SCROLL_STATE_IDLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.491 -0400", hash_original_field = "590E5386BF1A4104FE44A4AADB914C3D", hash_generated_field = "D42B9F4CA6EACF3E5515F0113524B53F")

    private long mShowInputControlsAnimimationDuration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.491 -0400", hash_original_field = "09B867FAA61E17B3A8CAE7E882019B98", hash_generated_field = "3AF141780F761DF920901C84521B4FAF")

    private boolean mScrollWheelAndFadingEdgesInitialized;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.492 -0400", hash_original_method = "F79ABC70152851F522A29F89B10B477D", hash_generated_method = "6B5394045724521C5C0FD0FF974D61E6")
    public  NumberPicker(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.492 -0400", hash_original_method = "C1116E13D5D84737E9D8F11A400A580C", hash_generated_method = "97B34CE9BE87B0C7FEA7AA7D3A178484")
    public  NumberPicker(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.numberPickerStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.497 -0400", hash_original_method = "8AC7B7259BDDBD9FCC66E09C35F9B950", hash_generated_method = "FB48F1A6BA001AF6429D76F764F934AB")
    public  NumberPicker(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray attributesArray = context.obtainStyledAttributes(attrs,
                R.styleable.NumberPicker, defStyle, 0);
        mSolidColor = attributesArray.getColor(R.styleable.NumberPicker_solidColor, 0);
        mFlingable = attributesArray.getBoolean(R.styleable.NumberPicker_flingable, true);
        mSelectionDivider = attributesArray.getDrawable(R.styleable.NumberPicker_selectionDivider);
        int defSelectionDividerHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                UNSCALED_DEFAULT_SELECTION_DIVIDER_HEIGHT,
                getResources().getDisplayMetrics());
        mSelectionDividerHeight = attributesArray.getDimensionPixelSize(
                R.styleable.NumberPicker_selectionDividerHeight, defSelectionDividerHeight);
        mMinHeight = attributesArray.getDimensionPixelSize(R.styleable.NumberPicker_minHeight,
                SIZE_UNSPECIFIED);
        mMaxHeight = attributesArray.getDimensionPixelSize(R.styleable.NumberPicker_maxHeight,
                SIZE_UNSPECIFIED);
    if(mMinHeight != SIZE_UNSPECIFIED && mMaxHeight != SIZE_UNSPECIFIED
                && mMinHeight > mMaxHeight)        
        {
            IllegalArgumentException var8D069734A7E6EA90F4BB4FD1AA37DB2A_565713982 = new IllegalArgumentException("minHeight > maxHeight");
            var8D069734A7E6EA90F4BB4FD1AA37DB2A_565713982.addTaint(taint);
            throw var8D069734A7E6EA90F4BB4FD1AA37DB2A_565713982;
        } //End block
        mMinWidth = attributesArray.getDimensionPixelSize(R.styleable.NumberPicker_minWidth,
                SIZE_UNSPECIFIED);
        mMaxWidth = attributesArray.getDimensionPixelSize(R.styleable.NumberPicker_maxWidth,
                SIZE_UNSPECIFIED);
    if(mMinWidth != SIZE_UNSPECIFIED && mMaxWidth != SIZE_UNSPECIFIED
                && mMinWidth > mMaxWidth)        
        {
            IllegalArgumentException var7EA0E56EADCF46DFCE2D3CD52DA32DA9_841372294 = new IllegalArgumentException("minWidth > maxWidth");
            var7EA0E56EADCF46DFCE2D3CD52DA32DA9_841372294.addTaint(taint);
            throw var7EA0E56EADCF46DFCE2D3CD52DA32DA9_841372294;
        } //End block
        mComputeMaxWidth = (mMaxWidth == Integer.MAX_VALUE);
        attributesArray.recycle();
        mShowInputControlsAnimimationDuration = getResources().getInteger(
                R.integer.config_longAnimTime);
        setWillNotDraw(false);
        setSelectorWheelState(SELECTOR_WHEEL_STATE_NONE);
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.number_picker, this, true);
        OnClickListener onClickListener = new OnClickListener() {
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
        OnLongClickListener onLongClickListener = new OnLongClickListener() {
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.495 -0400", hash_original_method = "78C9C9D108DFA9B840217E0D621D6794", hash_generated_method = "0EE6A1A3AF05D8608A0B206F9BCB4110")
        public void onFocusChange(View v, boolean hasFocus) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(hasFocus);
            addTaint(v.getTaint());
    if(hasFocus)            
            {
                mInputText.selectAll();
                InputMethodManager inputMethodManager = InputMethodManager.peekInstance();
    if(inputMethodManager != null)                
                {
                    inputMethodManager.showSoftInput(mInputText, 0);
                } //End block
            } //End block
            else
            {
                mInputText.setSelection(0, 0);
                validateInputTextView(v);
            } //End block
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
        ViewConfiguration configuration = ViewConfiguration.get(context);
        mTouchSlop = configuration.getScaledTouchSlop();
        mMinimumFlingVelocity = configuration.getScaledMinimumFlingVelocity();
        mMaximumFlingVelocity = configuration.getScaledMaximumFlingVelocity()
                / SELECTOR_MAX_FLING_VELOCITY_ADJUSTMENT;
        mTextSize = (int) mInputText.getTextSize();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextAlign(Align.CENTER);
        paint.setTextSize(mTextSize);
        paint.setTypeface(mInputText.getTypeface());
        ColorStateList colors = mInputText.getTextColors();
        int color = colors.getColorForState(ENABLED_STATE_SET, Color.WHITE);
        paint.setColor(color);
        mSelectorWheelPaint = paint;
        mDimSelectorWheelAnimator = ObjectAnimator.ofInt(this, PROPERTY_SELECTOR_PAINT_ALPHA,
                SELECTOR_WHEEL_BRIGHT_ALPHA, SELECTOR_WHEEL_DIM_ALPHA);
        final ObjectAnimator showIncrementButton = ObjectAnimator.ofFloat(mIncrementButton,
                PROPERTY_BUTTON_ALPHA, BUTTON_ALPHA_TRANSPARENT, BUTTON_ALPHA_OPAQUE);
        final ObjectAnimator showDecrementButton = ObjectAnimator.ofFloat(mDecrementButton,
                PROPERTY_BUTTON_ALPHA, BUTTON_ALPHA_TRANSPARENT, BUTTON_ALPHA_OPAQUE);
        mShowInputControlsAnimator = new AnimatorSet();
        mShowInputControlsAnimator.playTogether(mDimSelectorWheelAnimator, showIncrementButton,
                showDecrementButton);
        mShowInputControlsAnimator.addListener(new AnimatorListenerAdapter() {        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.496 -0400", hash_original_field = "D91530AF3D6C660AC2C0C8D4CBB2367B", hash_generated_field = "67D6DA73468F2D6E84B945FD38F1CC1D")
        private boolean mCanceled = false;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.496 -0400", hash_original_method = "189FC240B4143654008EFD2A47B5C1DA", hash_generated_method = "A63EBD097891F02E29C296F865FE75AF")
        @Override
        public void onAnimationEnd(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
    if(!mCanceled)            
            {
                setSelectorWheelState(SELECTOR_WHEEL_STATE_SMALL);
            } //End block
            mCanceled = false;
            // ---------- Original Method ----------
            //if (!mCanceled) {
                    //setSelectorWheelState(SELECTOR_WHEEL_STATE_SMALL);
                //}
            //mCanceled = false;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.497 -0400", hash_original_method = "9FA63CB44D9C62117F441F772E67C603", hash_generated_method = "083E86FD16B2DE17A7324E8279BAEA56")
        @Override
        public void onAnimationCancel(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
    if(mShowInputControlsAnimator.isRunning())            
            {
                mCanceled = true;
            } //End block
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
    if(mFlingable)        
        {
    if(isInEditMode())            
            {
                setSelectorWheelState(SELECTOR_WHEEL_STATE_SMALL);
            } //End block
            else
            {
                setSelectorWheelState(SELECTOR_WHEEL_STATE_LARGE);
                hideInputControls();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.499 -0400", hash_original_method = "E727E2B4CEB86D0A1B38AD8650A5C905", hash_generated_method = "3DA0B43E060AB9E2683DA25877F55EAE")
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        addTaint(changed);
        final int msrdWdth = getMeasuredWidth();
        final int msrdHght = getMeasuredHeight();
        final int inctBtnMsrdWdth = mIncrementButton.getMeasuredWidth();
        final int incrBtnLeft = (msrdWdth - inctBtnMsrdWdth) / 2;
        final int incrBtnTop = 0;
        final int incrBtnRight = incrBtnLeft + inctBtnMsrdWdth;
        final int incrBtnBottom = incrBtnTop + mIncrementButton.getMeasuredHeight();
        mIncrementButton.layout(incrBtnLeft, incrBtnTop, incrBtnRight, incrBtnBottom);
        final int inptTxtMsrdWdth = mInputText.getMeasuredWidth();
        final int inptTxtMsrdHght = mInputText.getMeasuredHeight();
        final int inptTxtLeft = (msrdWdth - inptTxtMsrdWdth) / 2;
        final int inptTxtTop = (msrdHght - inptTxtMsrdHght) / 2;
        final int inptTxtRight = inptTxtLeft + inptTxtMsrdWdth;
        final int inptTxtBottom = inptTxtTop + inptTxtMsrdHght;
        mInputText.layout(inptTxtLeft, inptTxtTop, inptTxtRight, inptTxtBottom);
        final int decrBtnMsrdWdth = mIncrementButton.getMeasuredWidth();
        final int decrBtnLeft = (msrdWdth - decrBtnMsrdWdth) / 2;
        final int decrBtnTop = msrdHght - mDecrementButton.getMeasuredHeight();
        final int decrBtnRight = decrBtnLeft + decrBtnMsrdWdth;
        final int decrBtnBottom = msrdHght;
        mDecrementButton.layout(decrBtnLeft, decrBtnTop, decrBtnRight, decrBtnBottom);
    if(!mScrollWheelAndFadingEdgesInitialized)        
        {
            mScrollWheelAndFadingEdgesInitialized = true;
            initializeSelectorWheel();
            initializeFadingEdges();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.499 -0400", hash_original_method = "048719DA53F07F7F498A46C4561541BF", hash_generated_method = "155EE1E1C6CF7F39817CD818170C9501")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        final int newWidthMeasureSpec = makeMeasureSpec(widthMeasureSpec, mMaxWidth);
        final int newHeightMeasureSpec = makeMeasureSpec(heightMeasureSpec, mMaxHeight);
        super.onMeasure(newWidthMeasureSpec, newHeightMeasureSpec);
        final int widthSize = resolveSizeAndStateRespectingMinSize(mMinWidth, getMeasuredWidth(),
                widthMeasureSpec);
        final int heightSize = resolveSizeAndStateRespectingMinSize(mMinHeight, getMeasuredHeight(),
                heightMeasureSpec);
        setMeasuredDimension(widthSize, heightSize);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.502 -0400", hash_original_method = "10C35B0DAD7657DB14B7F950A0414363", hash_generated_method = "43EF54CDC2A425C4D5E0674B579D9E1B")
    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
    if(!isEnabled() || !mFlingable)        
        {
            boolean var68934A3E9455FA72420237EB05902327_603613559 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1027675833 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1027675833;
        } //End block
switch(event.getActionMasked()){
        case MotionEvent.ACTION_DOWN:
        mLastMotionEventY = mLastDownEventY = event.getY();
        removeAllCallbacks();
        mShowInputControlsAnimator.cancel();
        mDimSelectorWheelAnimator.cancel();
        mBeginEditOnUpEvent = false;
        mAdjustScrollerOnUpEvent = true;
    if(mSelectorWheelState == SELECTOR_WHEEL_STATE_LARGE)        
        {
            mSelectorWheelPaint.setAlpha(SELECTOR_WHEEL_BRIGHT_ALPHA);
            boolean scrollersFinished = mFlingScroller.isFinished()
                            && mAdjustScroller.isFinished();
    if(!scrollersFinished)            
            {
                mFlingScroller.forceFinished(true);
                mAdjustScroller.forceFinished(true);
                onScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
            } //End block
            mBeginEditOnUpEvent = scrollersFinished;
            mAdjustScrollerOnUpEvent = true;
            hideInputControls();
            boolean varB326B5062B2F0E69046810717534CB09_1323549033 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1611686551 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1611686551;
        } //End block
    if(isEventInVisibleViewHitRect(event, mIncrementButton)
                        || isEventInVisibleViewHitRect(event, mDecrementButton))        
        {
            boolean var68934A3E9455FA72420237EB05902327_717693584 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1283147827 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1283147827;
        } //End block
        mAdjustScrollerOnUpEvent = false;
        setSelectorWheelState(SELECTOR_WHEEL_STATE_LARGE);
        hideInputControls();
        boolean varB326B5062B2F0E69046810717534CB09_1814104812 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1687451492 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1687451492;
        case MotionEvent.ACTION_MOVE:
        float currentMoveY = event.getY();
        int deltaDownY = (int) Math.abs(currentMoveY - mLastDownEventY);
    if(deltaDownY > mTouchSlop)        
        {
            mBeginEditOnUpEvent = false;
            onScrollStateChange(OnScrollListener.SCROLL_STATE_TOUCH_SCROLL);
            setSelectorWheelState(SELECTOR_WHEEL_STATE_LARGE);
            hideInputControls();
            boolean varB326B5062B2F0E69046810717534CB09_777524087 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_773305306 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_773305306;
        } //End block
        break;
}        boolean var68934A3E9455FA72420237EB05902327_715618187 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2060406464 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2060406464;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.503 -0400", hash_original_method = "235D8E8A92689E68622E8E516F140226", hash_generated_method = "8120FC589E869C53FC86CF60B265A3A8")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(ev.getTaint());
    if(!isEnabled())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1735625279 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2079968471 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2079968471;
        } //End block
    if(mVelocityTracker == null)        
        {
            mVelocityTracker = VelocityTracker.obtain();
        } //End block
        mVelocityTracker.addMovement(ev);
        int action = ev.getActionMasked();
switch(action){
        case MotionEvent.ACTION_MOVE:
        float currentMoveY = ev.getY();
    if(mBeginEditOnUpEvent
                        || mScrollState != OnScrollListener.SCROLL_STATE_TOUCH_SCROLL)        
        {
            int deltaDownY = (int) Math.abs(currentMoveY - mLastDownEventY);
    if(deltaDownY > mTouchSlop)            
            {
                mBeginEditOnUpEvent = false;
                onScrollStateChange(OnScrollListener.SCROLL_STATE_TOUCH_SCROLL);
            } //End block
        } //End block
        int deltaMoveY = (int) (currentMoveY - mLastMotionEventY);
        scrollBy(0, deltaMoveY);
        invalidate();
        mLastMotionEventY = currentMoveY;
        break;
        case MotionEvent.ACTION_UP:
    if(mBeginEditOnUpEvent)        
        {
            setSelectorWheelState(SELECTOR_WHEEL_STATE_SMALL);
            showInputControls(mShowInputControlsAnimimationDuration);
            mInputText.requestFocus();
            boolean varB326B5062B2F0E69046810717534CB09_299704275 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2143471866 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2143471866;
        } //End block
        VelocityTracker velocityTracker = mVelocityTracker;
        velocityTracker.computeCurrentVelocity(1000, mMaximumFlingVelocity);
        int initialVelocity = (int) velocityTracker.getYVelocity();
    if(Math.abs(initialVelocity) > mMinimumFlingVelocity)        
        {
            fling(initialVelocity);
            onScrollStateChange(OnScrollListener.SCROLL_STATE_FLING);
        } //End block
        else
        {
    if(mAdjustScrollerOnUpEvent)            
            {
    if(mFlingScroller.isFinished() && mAdjustScroller.isFinished())                
                {
                    postAdjustScrollerCommand(0);
                } //End block
            } //End block
            else
            {
                postAdjustScrollerCommand(SHOW_INPUT_CONTROLS_DELAY_MILLIS);
            } //End block
        } //End block
        mVelocityTracker.recycle();
        mVelocityTracker = null;
        break;
}        boolean varB326B5062B2F0E69046810717534CB09_1273899223 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1103333977 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1103333977;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.504 -0400", hash_original_method = "BF176E11CE8244676F550C2A8C029DBC", hash_generated_method = "77992750F3AA508B5B6469D4F644BBF7")
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        addTaint(event.getTaint());
        final int action = event.getActionMasked();
switch(action){
        case MotionEvent.ACTION_MOVE:
    if(mSelectorWheelState == SELECTOR_WHEEL_STATE_LARGE)        
        {
            removeAllCallbacks();
            forceCompleteChangeCurrentByOneViaScroll();
        } //End block
        break;
        case MotionEvent.ACTION_CANCEL:
        case MotionEvent.ACTION_UP:
        removeAllCallbacks();
        break;
}        boolean var041E6F53DFDAFFD9826FB441AB720FF1_1940756808 = (super.dispatchTouchEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1345832599 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1345832599;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.504 -0400", hash_original_method = "5F2124C88DD28BBD925F58E6B4833CD1", hash_generated_method = "31155A151F70EB5EFB48861A92A6D8E7")
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        addTaint(event.getTaint());
        int keyCode = event.getKeyCode();
    if(keyCode == KeyEvent.KEYCODE_DPAD_CENTER || keyCode == KeyEvent.KEYCODE_ENTER)        
        {
            removeAllCallbacks();
        } //End block
        boolean var639DD27D10E8FF69097B1398D445D1B9_156034645 = (super.dispatchKeyEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_80027102 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_80027102;
        // ---------- Original Method ----------
        //int keyCode = event.getKeyCode();
        //if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER || keyCode == KeyEvent.KEYCODE_ENTER) {
            //removeAllCallbacks();
        //}
        //return super.dispatchKeyEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.505 -0400", hash_original_method = "7AF2AFA03903803DBB932D40A216CA15", hash_generated_method = "D97B60F51335B4C49CF6105FF4421C7C")
    @Override
    public boolean dispatchTrackballEvent(MotionEvent event) {
        addTaint(event.getTaint());
        int action = event.getActionMasked();
    if(action == MotionEvent.ACTION_CANCEL || action == MotionEvent.ACTION_UP)        
        {
            removeAllCallbacks();
        } //End block
        boolean varBB41FA8540C179CC2F1F874F79E6CC5C_839363392 = (super.dispatchTrackballEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1233012605 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1233012605;
        // ---------- Original Method ----------
        //int action = event.getActionMasked();
        //if (action == MotionEvent.ACTION_CANCEL || action == MotionEvent.ACTION_UP) {
            //removeAllCallbacks();
        //}
        //return super.dispatchTrackballEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.505 -0400", hash_original_method = "A8C44E23055FC2DF1A30CAFE867BE321", hash_generated_method = "2CA1495EFC39511BAEC49EF1017F6241")
    @Override
    public void computeScroll() {
    if(mSelectorWheelState == SELECTOR_WHEEL_STATE_NONE)        
        {
            return;
        } //End block
        Scroller scroller = mFlingScroller;
    if(scroller.isFinished())        
        {
            scroller = mAdjustScroller;
    if(scroller.isFinished())            
            {
                return;
            } //End block
        } //End block
        scroller.computeScrollOffset();
        int currentScrollerY = scroller.getCurrY();
    if(mPreviousScrollerY == 0)        
        {
            mPreviousScrollerY = scroller.getStartY();
        } //End block
        scrollBy(0, currentScrollerY - mPreviousScrollerY);
        mPreviousScrollerY = currentScrollerY;
    if(scroller.isFinished())        
        {
            onScrollerFinished(scroller);
        } //End block
        else
        {
            invalidate();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.506 -0400", hash_original_method = "B6D6495EF8D39EBA8CC69BAAD1076261", hash_generated_method = "53B1C0C1CBA4303B83E53F3C96A74E52")
    @Override
    public void setEnabled(boolean enabled) {
        addTaint(enabled);
        super.setEnabled(enabled);
        mIncrementButton.setEnabled(enabled);
        mDecrementButton.setEnabled(enabled);
        mInputText.setEnabled(enabled);
        // ---------- Original Method ----------
        //super.setEnabled(enabled);
        //mIncrementButton.setEnabled(enabled);
        //mDecrementButton.setEnabled(enabled);
        //mInputText.setEnabled(enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.507 -0400", hash_original_method = "4E7C0796471D51CC4FDC613C54076EA5", hash_generated_method = "24699BEB3615ABBAD6C0FFEC067A6119")
    @Override
    public void scrollBy(int x, int y) {
        addTaint(x);
    if(mSelectorWheelState == SELECTOR_WHEEL_STATE_NONE)        
        {
            return;
        } //End block
        int[] selectorIndices = mSelectorIndices;
    if(!mWrapSelectorWheel && y > 0
                && selectorIndices[SELECTOR_MIDDLE_ITEM_INDEX] <= mMinValue)        
        {
            mCurrentScrollOffset = mInitialScrollOffset;
            return;
        } //End block
    if(!mWrapSelectorWheel && y < 0
                && selectorIndices[SELECTOR_MIDDLE_ITEM_INDEX] >= mMaxValue)        
        {
            mCurrentScrollOffset = mInitialScrollOffset;
            return;
        } //End block
        mCurrentScrollOffset += y;
        while
(mCurrentScrollOffset - mInitialScrollOffset > mSelectorTextGapHeight)        
        {
            mCurrentScrollOffset -= mSelectorElementHeight;
            decrementSelectorIndices(selectorIndices);
            changeCurrent(selectorIndices[SELECTOR_MIDDLE_ITEM_INDEX]);
    if(!mWrapSelectorWheel && selectorIndices[SELECTOR_MIDDLE_ITEM_INDEX] <= mMinValue)            
            {
                mCurrentScrollOffset = mInitialScrollOffset;
            } //End block
        } //End block
        while
(mCurrentScrollOffset - mInitialScrollOffset < -mSelectorTextGapHeight)        
        {
            mCurrentScrollOffset += mSelectorElementHeight;
            incrementSelectorIndices(selectorIndices);
            changeCurrent(selectorIndices[SELECTOR_MIDDLE_ITEM_INDEX]);
    if(!mWrapSelectorWheel && selectorIndices[SELECTOR_MIDDLE_ITEM_INDEX] >= mMaxValue)            
            {
                mCurrentScrollOffset = mInitialScrollOffset;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.508 -0400", hash_original_method = "A5D52728D322EA76B9FE19A001AC2619", hash_generated_method = "6947FA1AD406D8D6FAD675CA4842198A")
    @Override
    public int getSolidColor() {
        int varF761CF39D7B955BCB3910DD42D5B01E4_2075502078 = (mSolidColor);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_707705818 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_707705818;
        // ---------- Original Method ----------
        //return mSolidColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.508 -0400", hash_original_method = "B8FD740B950D37D2ACEC32CDC9BBCB3E", hash_generated_method = "D55BA1C0A2CC4BCD0E3EE7C50853AF06")
    public void setOnValueChangedListener(OnValueChangeListener onValueChangedListener) {
        mOnValueChangeListener = onValueChangedListener;
        // ---------- Original Method ----------
        //mOnValueChangeListener = onValueChangedListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.508 -0400", hash_original_method = "E07C1A1F4DD9D0D02072D75B16D4DB8B", hash_generated_method = "8D444529148A09F38F528175C920BB2D")
    public void setOnScrollListener(OnScrollListener onScrollListener) {
        mOnScrollListener = onScrollListener;
        // ---------- Original Method ----------
        //mOnScrollListener = onScrollListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.509 -0400", hash_original_method = "3C88654A4CCA22ED513CF659C7EAC98C", hash_generated_method = "C80671CC5E0A540330CB80B48709DB07")
    public void setFormatter(Formatter formatter) {
    if(formatter == mFormatter)        
        {
            return;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.509 -0400", hash_original_method = "27A138A3602AD1BB9BCFA8883739C2F3", hash_generated_method = "EDFD445F6D7D692DE65CB54D5E867A6F")
    public void setValue(int value) {
    if(mValue == value)        
        {
            return;
        } //End block
    if(value < mMinValue)        
        {
            value = mWrapSelectorWheel ? mMaxValue : mMinValue;
        } //End block
    if(value > mMaxValue)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.511 -0400", hash_original_method = "EC05395A137121E418B1180AC02A20B0", hash_generated_method = "68DBF9B4A4A3C2D9E01C8AD6A3FE8A13")
    private void tryComputeMaxWidth() {
    if(!mComputeMaxWidth)        
        {
            return;
        } //End block
        int maxTextWidth = 0;
    if(mDisplayedValues == null)        
        {
            float maxDigitWidth = 0;
for(int i = 0;i <= 9;i++)
            {
                final float digitWidth = mSelectorWheelPaint.measureText(String.valueOf(i));
    if(digitWidth > maxDigitWidth)                
                {
                    maxDigitWidth = digitWidth;
                } //End block
            } //End block
            int numberOfDigits = 0;
            int current = mMaxValue;
            while
(current > 0)            
            {
                numberOfDigits++;
                current = current / 10;
            } //End block
            maxTextWidth = (int) (numberOfDigits * maxDigitWidth);
        } //End block
        else
        {
            final int valueCount = mDisplayedValues.length;
for(int i = 0;i < valueCount;i++)
            {
                final float textWidth = mSelectorWheelPaint.measureText(mDisplayedValues[i]);
    if(textWidth > maxTextWidth)                
                {
                    maxTextWidth = (int) textWidth;
                } //End block
            } //End block
        } //End block
        maxTextWidth += mInputText.getPaddingLeft() + mInputText.getPaddingRight();
    if(mMaxWidth != maxTextWidth)        
        {
    if(maxTextWidth > mMinWidth)            
            {
                mMaxWidth = maxTextWidth;
            } //End block
            else
            {
                mMaxWidth = mMinWidth;
            } //End block
            invalidate();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.512 -0400", hash_original_method = "0DE9A61E4C9F0206942BD1BD5DBB2993", hash_generated_method = "95F815AE7A4023C9C0075C0D51F4855F")
    public boolean getWrapSelectorWheel() {
        boolean varFC769FBB094551A074259CD0A7B6736A_93220430 = (mWrapSelectorWheel);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1340941500 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1340941500;
        // ---------- Original Method ----------
        //return mWrapSelectorWheel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.512 -0400", hash_original_method = "4802BADC2E2D3D03E25B827D3F65AC09", hash_generated_method = "7D071C20262C241637D00E3407A75378")
    public void setWrapSelectorWheel(boolean wrapSelectorWheel) {
    if(wrapSelectorWheel && (mMaxValue - mMinValue) < mSelectorIndices.length)        
        {
            IllegalStateException var551E8E82A92632D17220099947F2F2E9_609898093 = new IllegalStateException("Range less than selector items count.");
            var551E8E82A92632D17220099947F2F2E9_609898093.addTaint(taint);
            throw var551E8E82A92632D17220099947F2F2E9_609898093;
        } //End block
    if(wrapSelectorWheel != mWrapSelectorWheel)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.513 -0400", hash_original_method = "8C354EDC01FB7FE8E35D5D03601EF310", hash_generated_method = "A112829F0E2370B87C41F6E6B0002254")
    public void setOnLongPressUpdateInterval(long intervalMillis) {
        mLongPressUpdateInterval = intervalMillis;
        // ---------- Original Method ----------
        //mLongPressUpdateInterval = intervalMillis;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.513 -0400", hash_original_method = "873C7D38131A035B7F6055170D432634", hash_generated_method = "B78618EAE5F8C8C940FF7269531391B7")
    public int getValue() {
        int varCBAFE11E7BAE23358D70D54D132C3064_1810829450 = (mValue);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1364597756 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1364597756;
        // ---------- Original Method ----------
        //return mValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.513 -0400", hash_original_method = "734B6103B2E180B236F243E5AD573634", hash_generated_method = "0EE8F761E31069AF1B54A898CD436327")
    public int getMinValue() {
        int varC996577FD89E2D9ACA600D3AF5442EB3_1876177702 = (mMinValue);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2065976695 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2065976695;
        // ---------- Original Method ----------
        //return mMinValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.514 -0400", hash_original_method = "661BFF8A6967E0A91919CA7BDDDCFF35", hash_generated_method = "8770045306ED921029D6E8D2B3AC7F13")
    public void setMinValue(int minValue) {
    if(mMinValue == minValue)        
        {
            return;
        } //End block
    if(minValue < 0)        
        {
            IllegalArgumentException var4CF4FB73F5BFCB0B30A98D2B19DFD802_212301957 = new IllegalArgumentException("minValue must be >= 0");
            var4CF4FB73F5BFCB0B30A98D2B19DFD802_212301957.addTaint(taint);
            throw var4CF4FB73F5BFCB0B30A98D2B19DFD802_212301957;
        } //End block
        mMinValue = minValue;
    if(mMinValue > mValue)        
        {
            mValue = mMinValue;
        } //End block
        boolean wrapSelectorWheel = mMaxValue - mMinValue > mSelectorIndices.length;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.514 -0400", hash_original_method = "D9333690652DA8538B4523261E9BBD48", hash_generated_method = "911A49AF8EA66A2AFDE7B5A62E52F15F")
    public int getMaxValue() {
        int varEB798AAFC3D0D018951E684107D8CF72_1412004956 = (mMaxValue);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_553840219 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_553840219;
        // ---------- Original Method ----------
        //return mMaxValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.514 -0400", hash_original_method = "1C3BC534ADC5B8B2FC50C2F4D93BA1C9", hash_generated_method = "76060F0495AC8D48C68E1C24CCF7486C")
    public void setMaxValue(int maxValue) {
    if(mMaxValue == maxValue)        
        {
            return;
        } //End block
    if(maxValue < 0)        
        {
            IllegalArgumentException var41F7D13EEC67DDDF39DA35379C0D39FB_287900224 = new IllegalArgumentException("maxValue must be >= 0");
            var41F7D13EEC67DDDF39DA35379C0D39FB_287900224.addTaint(taint);
            throw var41F7D13EEC67DDDF39DA35379C0D39FB_287900224;
        } //End block
        mMaxValue = maxValue;
    if(mMaxValue < mValue)        
        {
            mValue = mMaxValue;
        } //End block
        boolean wrapSelectorWheel = mMaxValue - mMinValue > mSelectorIndices.length;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.514 -0400", hash_original_method = "7D8D8A804F018648196BF68A974CA568", hash_generated_method = "9EA0999E235397F20EEC9FB1994C852B")
    public String[] getDisplayedValues() {
String[] var0B87CE87A92799FAB05539CDBFD795AD_1941108022 =         mDisplayedValues;
        var0B87CE87A92799FAB05539CDBFD795AD_1941108022.addTaint(taint);
        return var0B87CE87A92799FAB05539CDBFD795AD_1941108022;
        // ---------- Original Method ----------
        //return mDisplayedValues;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.514 -0400", hash_original_method = "0435EA5A97E8A7F818A581EB86B2390D", hash_generated_method = "4650F532020121C8020AECFAC4C1092C")
    public void setDisplayedValues(String[] displayedValues) {
    if(mDisplayedValues == displayedValues)        
        {
            return;
        } //End block
        mDisplayedValues = displayedValues;
    if(mDisplayedValues != null)        
        {
            mInputText.setRawInputType(InputType.TYPE_CLASS_TEXT
                    | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.515 -0400", hash_original_method = "26009EEE98735F9AF4C2D76E4A1AFAB0", hash_generated_method = "F49802677772A291C24879F392816D31")
    @Override
    protected float getTopFadingEdgeStrength() {
        float var63885AA7D968E63F4CC5ED35BC4CF22A_1495116555 = (TOP_AND_BOTTOM_FADING_EDGE_STRENGTH);
                float var546ADE640B6EDFBC8A086EF31347E768_1785610478 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1785610478;
        // ---------- Original Method ----------
        //return TOP_AND_BOTTOM_FADING_EDGE_STRENGTH;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.515 -0400", hash_original_method = "A0CE61C0CAF5846D2D470684E7070854", hash_generated_method = "9CFB7075078012475CA300514A59425C")
    @Override
    protected float getBottomFadingEdgeStrength() {
        float var63885AA7D968E63F4CC5ED35BC4CF22A_1512224230 = (TOP_AND_BOTTOM_FADING_EDGE_STRENGTH);
                float var546ADE640B6EDFBC8A086EF31347E768_154280950 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_154280950;
        // ---------- Original Method ----------
        //return TOP_AND_BOTTOM_FADING_EDGE_STRENGTH;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.515 -0400", hash_original_method = "D8635D04A384ABA875A77249BA87A3E4", hash_generated_method = "3B187CB8951B91098C93297C2CB23108")
    @Override
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAttachedToWindow();
    if(mFlingable && !isInEditMode())        
        {
            showInputControls(mShowInputControlsAnimimationDuration * 2);
        } //End block
        // ---------- Original Method ----------
        //super.onAttachedToWindow();
        //if (mFlingable && !isInEditMode()) {
            //showInputControls(mShowInputControlsAnimimationDuration * 2);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.515 -0400", hash_original_method = "1AF381BAEFDBA706A0AAFFFCBFBE7386", hash_generated_method = "B6B24701F125BC28DDEDFD787141F4D6")
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        removeAllCallbacks();
        // ---------- Original Method ----------
        //removeAllCallbacks();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.515 -0400", hash_original_method = "0296ECFD4FBB578ABFB3DEE9D2F54084", hash_generated_method = "8827C1FA31E6998965C439129AE20899")
    @Override
    protected void dispatchDraw(Canvas canvas) {
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.516 -0400", hash_original_method = "592CCD8540DAA22101D858B8673CA0A4", hash_generated_method = "9ADE90FF97BC79539528E687BB56DE03")
    @Override
    public void draw(Canvas canvas) {
        addTaint(canvas.getTaint());
        super.draw(canvas);
    if(mShowInputControlsAnimator.isRunning()
                || mSelectorWheelState != SELECTOR_WHEEL_STATE_LARGE)        
        {
            long drawTime = getDrawingTime();
for(int i = 0, count = getChildCount();i < count;i++)
            {
                View child = getChildAt(i);
    if(!child.isShown())                
                {
                    continue;
                } //End block
                drawChild(canvas, getChildAt(i), drawTime);
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.517 -0400", hash_original_method = "73B10A324A4034D5CD70F03023B591F2", hash_generated_method = "8DD86029BF829DE2DDFB5685A0C845D9")
    @Override
    protected void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(canvas.getTaint());
    if(mSelectorWheelState == SELECTOR_WHEEL_STATE_NONE)        
        {
            return;
        } //End block
        float x = (mRight - mLeft) / 2;
        float y = mCurrentScrollOffset;
        final int restoreCount = canvas.save();
    if(mSelectorWheelState == SELECTOR_WHEEL_STATE_SMALL)        
        {
            Rect clipBounds = canvas.getClipBounds();
            clipBounds.inset(0, mSelectorElementHeight);
            canvas.clipRect(clipBounds);
        } //End block
        int[] selectorIndices = mSelectorIndices;
for(int i = 0;i < selectorIndices.length;i++)
        {
            int selectorIndex = selectorIndices[i];
            String scrollSelectorValue = mSelectorIndexToStringCache.get(selectorIndex);
    if(i != SELECTOR_MIDDLE_ITEM_INDEX || mInputText.getVisibility() != VISIBLE)            
            {
                canvas.drawText(scrollSelectorValue, x, y, mSelectorWheelPaint);
            } //End block
            y += mSelectorElementHeight;
        } //End block
    if(mSelectionDivider != null)        
        {
            int topOfTopDivider = (getHeight() - mSelectorElementHeight - mSelectionDividerHeight) / 2;
            int bottomOfTopDivider = topOfTopDivider + mSelectionDividerHeight;
            mSelectionDivider.setBounds(0, topOfTopDivider, mRight, bottomOfTopDivider);
            mSelectionDivider.draw(canvas);
            int topOfBottomDivider = topOfTopDivider + mSelectorElementHeight;
            int bottomOfBottomDivider = bottomOfTopDivider + mSelectorElementHeight;
            mSelectionDivider.setBounds(0, topOfBottomDivider, mRight, bottomOfBottomDivider);
            mSelectionDivider.draw(canvas);
        } //End block
        canvas.restoreToCount(restoreCount);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.517 -0400", hash_original_method = "F557CD251A66C23831BE55ECFE0FD6EB", hash_generated_method = "6A09BD8EA53A915AB5F822E12CBC5F98")
    @Override
    public void sendAccessibilityEvent(int eventType) {
        addTaint(eventType);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.518 -0400", hash_original_method = "568475CB75488DB4FFB4140594C385EC", hash_generated_method = "553DAD5E0586BD5FB63B0305F947E175")
    private int makeMeasureSpec(int measureSpec, int maxSize) {
        addTaint(maxSize);
        addTaint(measureSpec);
    if(maxSize == SIZE_UNSPECIFIED)        
        {
            int var4DBE2C778E19A82616066A0A1C1DBEC9_959729687 = (measureSpec);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_224193578 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_224193578;
        } //End block
        final int size = MeasureSpec.getSize(measureSpec);
        final int mode = MeasureSpec.getMode(measureSpec);
switch(mode){
        case MeasureSpec.EXACTLY:
        int var4DBE2C778E19A82616066A0A1C1DBEC9_1935714977 = (measureSpec);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2070329126 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2070329126;
        case MeasureSpec.AT_MOST:
        int varBBA868C089193FF732DE06B674DBFE85_639723413 = (MeasureSpec.makeMeasureSpec(Math.min(size, maxSize), MeasureSpec.EXACTLY));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1502544141 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1502544141;
        case MeasureSpec.UNSPECIFIED:
        int varBD0C737059B6B051DF716FB21DB726B3_713906071 = (MeasureSpec.makeMeasureSpec(maxSize, MeasureSpec.EXACTLY));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_809086059 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_809086059;
        default:
        IllegalArgumentException var23681CC8989F68BBA8881AEB1152B33D_1244203094 = new IllegalArgumentException("Unknown measure mode: " + mode);
        var23681CC8989F68BBA8881AEB1152B33D_1244203094.addTaint(taint);
        throw var23681CC8989F68BBA8881AEB1152B33D_1244203094;
}
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.518 -0400", hash_original_method = "AB452915EDDF000AB380F75E12970FED", hash_generated_method = "678A61D1285D2AEF1A6561E1801C6BA0")
    private int resolveSizeAndStateRespectingMinSize(int minSize, int measuredSize,
            int measureSpec) {
        addTaint(measureSpec);
        addTaint(measuredSize);
        addTaint(minSize);
    if(minSize != SIZE_UNSPECIFIED)        
        {
            final int desiredWidth = Math.max(minSize, measuredSize);
            int var33B0EA3388819D1D185791DA131994CD_64830867 = (resolveSizeAndState(desiredWidth, measureSpec, 0));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1992904191 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1992904191;
        } //End block
        else
        {
            int varDADAD521D636870C2365C428BAC0A5C6_216855336 = (measuredSize);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1448228164 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1448228164;
        } //End block
        // ---------- Original Method ----------
        //if (minSize != SIZE_UNSPECIFIED) {
            //final int desiredWidth = Math.max(minSize, measuredSize);
            //return resolveSizeAndState(desiredWidth, measureSpec, 0);
        //} else {
            //return measuredSize;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.519 -0400", hash_original_method = "73F5524AAE1282E1B063C4C90806C754", hash_generated_method = "079A66CB2B3034496B45BDAAB8626842")
    private void initializeSelectorWheelIndices() {
        mSelectorIndexToStringCache.clear();
        int[] selectorIdices = mSelectorIndices;
        int current = getValue();
for(int i = 0;i < mSelectorIndices.length;i++)
        {
            int selectorIndex = current + (i - SELECTOR_MIDDLE_ITEM_INDEX);
    if(mWrapSelectorWheel)            
            {
                selectorIndex = getWrappedSelectorIndex(selectorIndex);
            } //End block
            mSelectorIndices[i] = selectorIndex;
            ensureCachedScrollSelectorValue(mSelectorIndices[i]);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.520 -0400", hash_original_method = "555F719FBCCD8AB4B94C9C107DB6A73F", hash_generated_method = "9F7FD41843832E066A8DDFFD1480131C")
    private void changeCurrent(int current) {
        addTaint(current);
    if(mValue == current)        
        {
            return;
        } //End block
    if(mWrapSelectorWheel)        
        {
            current = getWrappedSelectorIndex(current);
        } //End block
        int previous = mValue;
        setValue(current);
        notifyChange(previous, current);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.521 -0400", hash_original_method = "E6026B71E66A86671A33BB22E5856635", hash_generated_method = "EB3AC79FAB05E1B58759EB1CFF00D4F5")
    private void changeCurrentByOne(boolean increment) {
        addTaint(increment);
    if(mFlingable)        
        {
            mDimSelectorWheelAnimator.cancel();
            mInputText.setVisibility(View.INVISIBLE);
            mSelectorWheelPaint.setAlpha(SELECTOR_WHEEL_BRIGHT_ALPHA);
            mPreviousScrollerY = 0;
            forceCompleteChangeCurrentByOneViaScroll();
    if(increment)            
            {
                mFlingScroller.startScroll(0, 0, 0, -mSelectorElementHeight,
                        CHANGE_CURRENT_BY_ONE_SCROLL_DURATION);
            } //End block
            else
            {
                mFlingScroller.startScroll(0, 0, 0, mSelectorElementHeight,
                        CHANGE_CURRENT_BY_ONE_SCROLL_DURATION);
            } //End block
            invalidate();
        } //End block
        else
        {
    if(increment)            
            {
                changeCurrent(mValue + 1);
            } //End block
            else
            {
                changeCurrent(mValue - 1);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.521 -0400", hash_original_method = "175AF73F53EDEE092962AA03BDCBD819", hash_generated_method = "3457DBB4F0F85B2336DEBD0F07489DD0")
    private void forceCompleteChangeCurrentByOneViaScroll() {
        Scroller scroller = mFlingScroller;
    if(!scroller.isFinished())        
        {
            final int yBeforeAbort = scroller.getCurrY();
            scroller.abortAnimation();
            final int yDelta = scroller.getCurrY() - yBeforeAbort;
            scrollBy(0, yDelta);
        } //End block
        // ---------- Original Method ----------
        //Scroller scroller = mFlingScroller;
        //if (!scroller.isFinished()) {
            //final int yBeforeAbort = scroller.getCurrY();
            //scroller.abortAnimation();
            //final int yDelta = scroller.getCurrY() - yBeforeAbort;
            //scrollBy(0, yDelta);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.522 -0400", hash_original_method = "E601C50DC508DF2554B27F10B4080C00", hash_generated_method = "91B5C533ECE9F4FAD1B944E3D816EC81")
    @SuppressWarnings("unused")
    private void setSelectorPaintAlpha(int alpha) {
        addTaint(alpha);
        mSelectorWheelPaint.setAlpha(alpha);
        invalidate();
        // ---------- Original Method ----------
        //mSelectorWheelPaint.setAlpha(alpha);
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.522 -0400", hash_original_method = "400782BE1118D85D04FD2365A968D2CF", hash_generated_method = "4C7F79DED9E89D96FFBE45E0FFE22963")
    private boolean isEventInVisibleViewHitRect(MotionEvent event, View view) {
        addTaint(view.getTaint());
        addTaint(event.getTaint());
    if(view.getVisibility() == VISIBLE)        
        {
            view.getHitRect(mTempRect);
            boolean var991FC5B8EEB72A36FE527B79D633649A_2140468630 = (mTempRect.contains((int) event.getX(), (int) event.getY()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_253656580 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_253656580;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_375246976 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_812765201 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_812765201;
        // ---------- Original Method ----------
        //if (view.getVisibility() == VISIBLE) {
            //view.getHitRect(mTempRect);
            //return mTempRect.contains((int) event.getX(), (int) event.getY());
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.523 -0400", hash_original_method = "BF95E4EC078F38B02D5C875137382733", hash_generated_method = "91BF073E7C3BA19626411FA5AAD86037")
    private void setSelectorWheelState(int selectorWheelState) {
        mSelectorWheelState = selectorWheelState;
    if(selectorWheelState == SELECTOR_WHEEL_STATE_LARGE)        
        {
            mSelectorWheelPaint.setAlpha(SELECTOR_WHEEL_BRIGHT_ALPHA);
        } //End block
    if(mFlingable && selectorWheelState == SELECTOR_WHEEL_STATE_LARGE
                && AccessibilityManager.getInstance(mContext).isEnabled())        
        {
            AccessibilityManager.getInstance(mContext).interrupt();
            String text = mContext.getString(R.string.number_picker_increment_scroll_action);
            mInputText.setContentDescription(text);
            mInputText.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
            mInputText.setContentDescription(null);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.524 -0400", hash_original_method = "77AB1B93BD5012BE4D83745B76853590", hash_generated_method = "D1B8858FCCBA9FF4F876FB86FD357384")
    private void initializeSelectorWheel() {
        initializeSelectorWheelIndices();
        int[] selectorIndices = mSelectorIndices;
        int totalTextHeight = selectorIndices.length * mTextSize;
        float totalTextGapHeight = (mBottom - mTop) - totalTextHeight;
        float textGapCount = selectorIndices.length - 1;
        mSelectorTextGapHeight = (int) (totalTextGapHeight / textGapCount + 0.5f);
        mSelectorElementHeight = mTextSize + mSelectorTextGapHeight;
        int editTextTextPosition = mInputText.getBaseline() + mInputText.getTop();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.524 -0400", hash_original_method = "C54C7499288517561E53B381ADACF410", hash_generated_method = "E90A0086BF2AA91401C69932ABBDF6CA")
    private void initializeFadingEdges() {
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength((mBottom - mTop - mTextSize) / 2);
        // ---------- Original Method ----------
        //setVerticalFadingEdgeEnabled(true);
        //setFadingEdgeLength((mBottom - mTop - mTextSize) / 2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.524 -0400", hash_original_method = "424BD543DA2123CE0E799CAFA377A1E0", hash_generated_method = "8FC32AE079D5FD18F09BD41FA07A5179")
    private void onScrollerFinished(Scroller scroller) {
        addTaint(scroller.getTaint());
    if(scroller == mFlingScroller)        
        {
    if(mSelectorWheelState == SELECTOR_WHEEL_STATE_LARGE)            
            {
                postAdjustScrollerCommand(0);
                onScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
            } //End block
            else
            {
                updateInputTextView();
                fadeSelectorWheel(mShowInputControlsAnimimationDuration);
            } //End block
        } //End block
        else
        {
            updateInputTextView();
            showInputControls(mShowInputControlsAnimimationDuration);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.525 -0400", hash_original_method = "76A35782DE0E02AA234AC6648796EFD6", hash_generated_method = "BC58A10D670BF40B7D1597BAB530E17B")
    private void onScrollStateChange(int scrollState) {
    if(mScrollState == scrollState)        
        {
            return;
        } //End block
        mScrollState = scrollState;
    if(mOnScrollListener != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.525 -0400", hash_original_method = "089FFF3145B83D850B8641EBACA81A89", hash_generated_method = "AD9306C13C97AAADF17D6640858DBA1B")
    private void fling(int velocityY) {
        addTaint(velocityY);
        mPreviousScrollerY = 0;
    if(velocityY > 0)        
        {
            mFlingScroller.fling(0, 0, 0, velocityY, 0, 0, 0, Integer.MAX_VALUE);
        } //End block
        else
        {
            mFlingScroller.fling(0, Integer.MAX_VALUE, 0, velocityY, 0, 0, 0, Integer.MAX_VALUE);
        } //End block
        invalidate();
        // ---------- Original Method ----------
        //mPreviousScrollerY = 0;
        //if (velocityY > 0) {
            //mFlingScroller.fling(0, 0, 0, velocityY, 0, 0, 0, Integer.MAX_VALUE);
        //} else {
            //mFlingScroller.fling(0, Integer.MAX_VALUE, 0, velocityY, 0, 0, 0, Integer.MAX_VALUE);
        //}
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.526 -0400", hash_original_method = "84887968F9B86CB6F225BC4761B2C961", hash_generated_method = "1D21AF4908382088EF5471059FF2483B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.526 -0400", hash_original_method = "568B02CE0458B050F29128E328730206", hash_generated_method = "0AA25A3E8C951EAE4B6DA18A84963868")
    private void showInputControls(long animationDuration) {
        addTaint(animationDuration);
        updateIncrementAndDecrementButtonsVisibilityState();
        mInputText.setVisibility(VISIBLE);
        mShowInputControlsAnimator.setDuration(animationDuration);
        mShowInputControlsAnimator.start();
        // ---------- Original Method ----------
        //updateIncrementAndDecrementButtonsVisibilityState();
        //mInputText.setVisibility(VISIBLE);
        //mShowInputControlsAnimator.setDuration(animationDuration);
        //mShowInputControlsAnimator.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.526 -0400", hash_original_method = "04EF8175CF934E94876E7611B3BFDBC2", hash_generated_method = "7337A986445344C11881B9C8FC07F355")
    private void fadeSelectorWheel(long animationDuration) {
        addTaint(animationDuration);
        mInputText.setVisibility(VISIBLE);
        mDimSelectorWheelAnimator.setDuration(animationDuration);
        mDimSelectorWheelAnimator.start();
        // ---------- Original Method ----------
        //mInputText.setVisibility(VISIBLE);
        //mDimSelectorWheelAnimator.setDuration(animationDuration);
        //mDimSelectorWheelAnimator.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.527 -0400", hash_original_method = "F06555D042A3011B2943A92CA9FE7B6C", hash_generated_method = "F38A6CAD83327B1102FDB03DB599475A")
    private void updateIncrementAndDecrementButtonsVisibilityState() {
    if(mWrapSelectorWheel || mValue < mMaxValue)        
        {
            mIncrementButton.setVisibility(VISIBLE);
        } //End block
        else
        {
            mIncrementButton.setVisibility(INVISIBLE);
        } //End block
    if(mWrapSelectorWheel || mValue > mMinValue)        
        {
            mDecrementButton.setVisibility(VISIBLE);
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.527 -0400", hash_original_method = "98EC96D2E9172670F87F406C69617E1C", hash_generated_method = "E6CAB49E9703B6E82AF288E97750F591")
    private int getWrappedSelectorIndex(int selectorIndex) {
        addTaint(selectorIndex);
    if(selectorIndex > mMaxValue)        
        {
            int var0F23B062BF9BEC85B9C6CD15072F1B8C_288139660 = (mMinValue + (selectorIndex - mMaxValue) % (mMaxValue - mMinValue) - 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1198892312 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1198892312;
        } //End block
        else
    if(selectorIndex < mMinValue)        
        {
            int var268B90C58DD38AEE3C5A7246D37C6A63_509962366 = (mMaxValue - (mMinValue - selectorIndex) % (mMaxValue - mMinValue) + 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1459258592 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1459258592;
        } //End block
        int varE225E95950C9A50590D115CCDD11D3F7_1060646431 = (selectorIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1396288204 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1396288204;
        // ---------- Original Method ----------
        //if (selectorIndex > mMaxValue) {
            //return mMinValue + (selectorIndex - mMaxValue) % (mMaxValue - mMinValue) - 1;
        //} else if (selectorIndex < mMinValue) {
            //return mMaxValue - (mMinValue - selectorIndex) % (mMaxValue - mMinValue) + 1;
        //}
        //return selectorIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.528 -0400", hash_original_method = "76B5F467E3A3E0B55117DFD0AE112AD7", hash_generated_method = "A82183800E9E5A44919590212D1FD0B7")
    private void incrementSelectorIndices(int[] selectorIndices) {
        addTaint(selectorIndices[0]);
for(int i = 0;i < selectorIndices.length - 1;i++)
        {
            selectorIndices[i] = selectorIndices[i + 1];
        } //End block
        int nextScrollSelectorIndex = selectorIndices[selectorIndices.length - 2] + 1;
    if(mWrapSelectorWheel && nextScrollSelectorIndex > mMaxValue)        
        {
            nextScrollSelectorIndex = mMinValue;
        } //End block
        selectorIndices[selectorIndices.length - 1] = nextScrollSelectorIndex;
        ensureCachedScrollSelectorValue(nextScrollSelectorIndex);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.529 -0400", hash_original_method = "3BAE7243B627F51EC3CF3C9DBFE60CD6", hash_generated_method = "9F54BEE41814237517484FCE68BB0B87")
    private void decrementSelectorIndices(int[] selectorIndices) {
        addTaint(selectorIndices[0]);
for(int i = selectorIndices.length - 1;i > 0;i--)
        {
            selectorIndices[i] = selectorIndices[i - 1];
        } //End block
        int nextScrollSelectorIndex = selectorIndices[1] - 1;
    if(mWrapSelectorWheel && nextScrollSelectorIndex < mMinValue)        
        {
            nextScrollSelectorIndex = mMaxValue;
        } //End block
        selectorIndices[0] = nextScrollSelectorIndex;
        ensureCachedScrollSelectorValue(nextScrollSelectorIndex);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.529 -0400", hash_original_method = "5C7213EC7C24F2EA6A4CE0C3E4F76F00", hash_generated_method = "8D5E91720D8E35B53220FB192B3944DA")
    private void ensureCachedScrollSelectorValue(int selectorIndex) {
        addTaint(selectorIndex);
        SparseArray<String> cache = mSelectorIndexToStringCache;
        String scrollSelectorValue = cache.get(selectorIndex);
    if(scrollSelectorValue != null)        
        {
            return;
        } //End block
    if(selectorIndex < mMinValue || selectorIndex > mMaxValue)        
        {
            scrollSelectorValue = "";
        } //End block
        else
        {
    if(mDisplayedValues != null)            
            {
                int displayedValueIndex = selectorIndex - mMinValue;
                scrollSelectorValue = mDisplayedValues[displayedValueIndex];
            } //End block
            else
            {
                scrollSelectorValue = formatNumber(selectorIndex);
            } //End block
        } //End block
        cache.put(selectorIndex, scrollSelectorValue);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.530 -0400", hash_original_method = "CED5CD69155B2474785611FEBB1C2BE4", hash_generated_method = "5FC9CBDFF427BC448F375C17EA02D9F8")
    private String formatNumber(int value) {
        addTaint(value);
String varE2CFEEEC89DAA2D60C6B2B3DF505F6D2_1542723190 =         (mFormatter != null) ? mFormatter.format(value) : String.valueOf(value);
        varE2CFEEEC89DAA2D60C6B2B3DF505F6D2_1542723190.addTaint(taint);
        return varE2CFEEEC89DAA2D60C6B2B3DF505F6D2_1542723190;
        // ---------- Original Method ----------
        //return (mFormatter != null) ? mFormatter.format(value) : String.valueOf(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.530 -0400", hash_original_method = "9B2E73D457CEF5FA8F9D91E45C672313", hash_generated_method = "206A5AD0A8CE502F71582A5F0031EB97")
    private void validateInputTextView(View v) {
        addTaint(v.getTaint());
        String str = String.valueOf(((TextView) v).getText());
    if(TextUtils.isEmpty(str))        
        {
            updateInputTextView();
        } //End block
        else
        {
            int current = getSelectedPos(str.toString());
            changeCurrent(current);
        } //End block
        // ---------- Original Method ----------
        //String str = String.valueOf(((TextView) v).getText());
        //if (TextUtils.isEmpty(str)) {
            //updateInputTextView();
        //} else {
            //int current = getSelectedPos(str.toString());
            //changeCurrent(current);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.531 -0400", hash_original_method = "B42CFCB10E8E291BCAC25CBB8DE3CDCA", hash_generated_method = "85A98DD349110023FD8C3B18DDD9CF83")
    private void updateInputTextView() {
    if(mDisplayedValues == null)        
        {
            mInputText.setText(formatNumber(mValue));
        } //End block
        else
        {
            mInputText.setText(mDisplayedValues[mValue - mMinValue]);
        } //End block
        mInputText.setSelection(mInputText.getText().length());
    if(mFlingable && AccessibilityManager.getInstance(mContext).isEnabled())        
        {
            String text = mContext.getString(R.string.number_picker_increment_scroll_mode,
                    mInputText.getText());
            mInputText.setContentDescription(text);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.531 -0400", hash_original_method = "EE3C020B4BB89830916EAF8B846EA64D", hash_generated_method = "1C17214311BC4D7298071C66AD7C2DE0")
    private void notifyChange(int previous, int current) {
        addTaint(current);
        addTaint(previous);
    if(mOnValueChangeListener != null)        
        {
            mOnValueChangeListener.onValueChange(this, previous, mValue);
        } //End block
        // ---------- Original Method ----------
        //if (mOnValueChangeListener != null) {
            //mOnValueChangeListener.onValueChange(this, previous, mValue);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.531 -0400", hash_original_method = "89117A76C28F4F0E670F85E62CCFCD15", hash_generated_method = "64B03D5468A5C31D74C5C2330E47464B")
    private void postChangeCurrentByOneFromLongPress(boolean increment) {
        addTaint(increment);
        mInputText.clearFocus();
        removeAllCallbacks();
    if(mChangeCurrentByOneFromLongPressCommand == null)        
        {
            mChangeCurrentByOneFromLongPressCommand = new ChangeCurrentByOneFromLongPressCommand();
        } //End block
        mChangeCurrentByOneFromLongPressCommand.setIncrement(increment);
        post(mChangeCurrentByOneFromLongPressCommand);
        // ---------- Original Method ----------
        //mInputText.clearFocus();
        //removeAllCallbacks();
        //if (mChangeCurrentByOneFromLongPressCommand == null) {
            //mChangeCurrentByOneFromLongPressCommand = new ChangeCurrentByOneFromLongPressCommand();
        //}
        //mChangeCurrentByOneFromLongPressCommand.setIncrement(increment);
        //post(mChangeCurrentByOneFromLongPressCommand);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.532 -0400", hash_original_method = "2F67DA682EF8D26EE412EBB702FD21A7", hash_generated_method = "8E1015D9B17B50EF16B97AACD52ECD65")
    private void removeAllCallbacks() {
    if(mChangeCurrentByOneFromLongPressCommand != null)        
        {
            removeCallbacks(mChangeCurrentByOneFromLongPressCommand);
        } //End block
    if(mAdjustScrollerCommand != null)        
        {
            removeCallbacks(mAdjustScrollerCommand);
        } //End block
    if(mSetSelectionCommand != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.532 -0400", hash_original_method = "C9822A8BF3CD293D75693533B44BD287", hash_generated_method = "A7431E599CEFE798D8FBD162F531B342")
    private int getSelectedPos(String value) {
        addTaint(value.getTaint());
    if(mDisplayedValues == null)        
        {
            try 
            {
                int var20FFFD77EFBC3C0974E059C438208616_692895435 = (Integer.parseInt(value));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1481597978 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1481597978;
            } //End block
            catch (NumberFormatException e)
            {
            } //End block
        } //End block
        else
        {
for(int i = 0;i < mDisplayedValues.length;i++)
            {
                value = value.toLowerCase();
    if(mDisplayedValues[i].toLowerCase().startsWith(value))                
                {
                    int var7775755DB3663430902A48AF70F57DD3_1452762627 = (mMinValue + i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1646790009 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1646790009;
                } //End block
            } //End block
            try 
            {
                int var20FFFD77EFBC3C0974E059C438208616_1185742757 = (Integer.parseInt(value));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_738134523 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_738134523;
            } //End block
            catch (NumberFormatException e)
            {
            } //End block
        } //End block
        int varC996577FD89E2D9ACA600D3AF5442EB3_175276924 = (mMinValue);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1454066252 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1454066252;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.534 -0400", hash_original_method = "B20C23507728532B22E954D2186CEEA6", hash_generated_method = "B6DCB16088778941AF462EFD5EDC29FB")
    private void postSetSelectionCommand(int selectionStart, int selectionEnd) {
    if(mSetSelectionCommand == null)        
        {
            mSetSelectionCommand = new SetSelectionCommand();
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.534 -0400", hash_original_method = "54DD268EE848B5EAB62BAC6791547633", hash_generated_method = "868958C2BA780E14DAB57142EAAB882E")
    private void postAdjustScrollerCommand(int delayMillis) {
        addTaint(delayMillis);
    if(mAdjustScrollerCommand == null)        
        {
            mAdjustScrollerCommand = new AdjustScrollerCommand();
        } //End block
        else
        {
            removeCallbacks(mAdjustScrollerCommand);
        } //End block
        postDelayed(mAdjustScrollerCommand, delayMillis);
        // ---------- Original Method ----------
        //if (mAdjustScrollerCommand == null) {
            //mAdjustScrollerCommand = new AdjustScrollerCommand();
        //} else {
            //removeCallbacks(mAdjustScrollerCommand);
        //}
        //postDelayed(mAdjustScrollerCommand, delayMillis);
    }

    
    class InputTextFilter extends NumberKeyListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.535 -0400", hash_original_method = "10D9049FFA6F11A4560862F2A7A49039", hash_generated_method = "10D9049FFA6F11A4560862F2A7A49039")
        public InputTextFilter ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.535 -0400", hash_original_method = "5619839AC48FF521F5D3DA01ED2E4A22", hash_generated_method = "50CCD7BD12886D8D49BCFD64550E83B1")
        public int getInputType() {
            int var86C66DE81A691CAFE3C9CD60100D1BD9_1028374079 = (InputType.TYPE_CLASS_TEXT);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_59851590 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_59851590;
            // ---------- Original Method ----------
            //return InputType.TYPE_CLASS_TEXT;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.535 -0400", hash_original_method = "42F7B3A0BEAF29BB6B3A7A3A6D3C7695", hash_generated_method = "D11499AB122094F3601ADC0721B8E0E8")
        @Override
        protected char[] getAcceptedChars() {
            char[] var1EC7A40DC2F9CC1A4F4A61E1340D2FE7_923680019 = (DIGIT_CHARACTERS);
                        char[] var50607924ABD4C17119BAF3A1CE41C0EC_533453464 = {getTaintChar()};
            return var50607924ABD4C17119BAF3A1CE41C0EC_533453464;
            // ---------- Original Method ----------
            //return DIGIT_CHARACTERS;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.537 -0400", hash_original_method = "74A3271C967FA5A66FEC87FCC33CF2BB", hash_generated_method = "C5D4D8DC7861223794291CF1261320DD")
        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest,
                int dstart, int dend) {
            addTaint(dend);
            addTaint(dstart);
            addTaint(dest.getTaint());
            addTaint(end);
            addTaint(start);
            addTaint(source.getTaint());
    if(mDisplayedValues == null)            
            {
                CharSequence filtered = super.filter(source, start, end, dest, dstart, dend);
    if(filtered == null)                
                {
                    filtered = source.subSequence(start, end);
                } //End block
                String result = String.valueOf(dest.subSequence(0, dstart)) + filtered
                        + dest.subSequence(dend, dest.length());
    if("".equals(result))                
                {
CharSequence varDC838461EE2FA0CA4C9BBB70A15456B0_1238197892 =                     result;
                    varDC838461EE2FA0CA4C9BBB70A15456B0_1238197892.addTaint(taint);
                    return varDC838461EE2FA0CA4C9BBB70A15456B0_1238197892;
                } //End block
                int val = getSelectedPos(result);
    if(val > mMaxValue)                
                {
CharSequence var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_471624448 =                     "";
                    var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_471624448.addTaint(taint);
                    return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_471624448;
                } //End block
                else
                {
CharSequence var59AFDF48DAC2B65C0DC9F976A34BEAF9_760730127 =                     filtered;
                    var59AFDF48DAC2B65C0DC9F976A34BEAF9_760730127.addTaint(taint);
                    return var59AFDF48DAC2B65C0DC9F976A34BEAF9_760730127;
                } //End block
            } //End block
            else
            {
                CharSequence filtered = String.valueOf(source.subSequence(start, end));
    if(TextUtils.isEmpty(filtered))                
                {
CharSequence var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_485385131 =                     "";
                    var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_485385131.addTaint(taint);
                    return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_485385131;
                } //End block
                String result = String.valueOf(dest.subSequence(0, dstart)) + filtered
                        + dest.subSequence(dend, dest.length());
                String str = String.valueOf(result).toLowerCase();
for(String val : mDisplayedValues)
                {
                    String valLowerCase = val.toLowerCase();
    if(valLowerCase.startsWith(str))                    
                    {
                        postSetSelectionCommand(result.length(), val.length());
CharSequence varECD1DA29E5B77EC283004BD9A32C44C9_1834903277 =                         val.subSequence(dstart, val.length());
                        varECD1DA29E5B77EC283004BD9A32C44C9_1834903277.addTaint(taint);
                        return varECD1DA29E5B77EC283004BD9A32C44C9_1834903277;
                    } //End block
                } //End block
CharSequence var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_8904043 =                 "";
                var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_8904043.addTaint(taint);
                return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_8904043;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    class SetSelectionCommand implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.538 -0400", hash_original_field = "61BC4CC0CEBB67582239843EAC8C216E", hash_generated_field = "F02C1BE48395D503EBA5C8443CFA9BF4")

        private int mSelectionStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.538 -0400", hash_original_field = "33EA9C8C559E59D359CC561F05D6AA8C", hash_generated_field = "C8C5CBC35C679AC5A64E276363F892A9")

        private int mSelectionEnd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.538 -0400", hash_original_method = "8A1B763782C13D7A531CCCB7905DBC5E", hash_generated_method = "8A1B763782C13D7A531CCCB7905DBC5E")
        public SetSelectionCommand ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.538 -0400", hash_original_method = "5A9CF76A42C671BAE659DDDD324A19D9", hash_generated_method = "D5DE829BC4A9BD93C1BA19F296BB6266")
        public void run() {
            mInputText.setSelection(mSelectionStart, mSelectionEnd);
            // ---------- Original Method ----------
            //mInputText.setSelection(mSelectionStart, mSelectionEnd);
        }

        
    }


    
    class AdjustScrollerCommand implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.538 -0400", hash_original_method = "04A50735AF7565EFEB09DB8389B3EF59", hash_generated_method = "04A50735AF7565EFEB09DB8389B3EF59")
        public AdjustScrollerCommand ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.539 -0400", hash_original_method = "1728A296542E5FB10F5D2F850E617FE1", hash_generated_method = "0F2B57A4C6658E30B0BC074C439FDCB8")
        public void run() {
            mPreviousScrollerY = 0;
    if(mInitialScrollOffset == mCurrentScrollOffset)            
            {
                updateInputTextView();
                showInputControls(mShowInputControlsAnimimationDuration);
                return;
            } //End block
            int deltaY = mInitialScrollOffset - mCurrentScrollOffset;
    if(Math.abs(deltaY) > mSelectorElementHeight / 2)            
            {
                deltaY += (deltaY > 0) ? -mSelectorElementHeight : mSelectorElementHeight;
            } //End block
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.539 -0400", hash_original_field = "B954C9EDAC21852B96AD8DA47FB0BB4A", hash_generated_field = "729B17CE9B5C6450F7852DCD6B7829FA")

        private boolean mIncrement;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.539 -0400", hash_original_method = "A263DA149B2C322986CF6F1865703F44", hash_generated_method = "A263DA149B2C322986CF6F1865703F44")
        public ChangeCurrentByOneFromLongPressCommand ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.540 -0400", hash_original_method = "ED1739B7A0ACAE655C07ED8C0ABABF1C", hash_generated_method = "3E122DEB3F2DDEA67EBDA1CC64C07EBB")
        private void setIncrement(boolean increment) {
            mIncrement = increment;
            // ---------- Original Method ----------
            //mIncrement = increment;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.540 -0400", hash_original_method = "1F108533BE53D637572F8F49778F205C", hash_generated_method = "CA83D2C22E3899643BFF96D7CD8EDDDC")
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.540 -0400", hash_original_field = "C5A9E787ABA4BAACCB788D1F0885106B", hash_generated_field = "1DD6DB2DBAAEAD209FC944EF9017AB32")

    private static final long DEFAULT_LONG_PRESS_UPDATE_INTERVAL = 300;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.540 -0400", hash_original_field = "E04B091B1D565E6042C78271EA6ED98C", hash_generated_field = "9500E56E6454819E2AE81D01349CCAD1")

    private static final int SELECTOR_MIDDLE_ITEM_INDEX = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.540 -0400", hash_original_field = "E11D9C628CD4DF30ACE541A56D2F5151", hash_generated_field = "D4EF8F7375B8200953E206EEE0A05F6B")

    private static final int SELECTOR_MAX_FLING_VELOCITY_ADJUSTMENT = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.540 -0400", hash_original_field = "1C65740AF5F3CC66B57E41FF6FA3A795", hash_generated_field = "BA70A446419865BF598782861C034BC8")

    private static final int SELECTOR_ADJUSTMENT_DURATION_MILLIS = 800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.540 -0400", hash_original_field = "CD7BC2810D52AF97EE7BC2806CA83C35", hash_generated_field = "938202BE77B5C450F698F4EE6DE60C2E")

    private static final int CHANGE_CURRENT_BY_ONE_SCROLL_DURATION = 300;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.540 -0400", hash_original_field = "54B40FBA44C9E21468F0297E7DF3C1BD", hash_generated_field = "E44BA99C221811C14FB7348364448070")

    private static final int SHOW_INPUT_CONTROLS_DELAY_MILLIS = ViewConfiguration
            .getDoubleTapTimeout();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.540 -0400", hash_original_field = "4120131B75A717DDA48DB2F0A5F8DD95", hash_generated_field = "054D95E51A8C564003A9200BE1B948E0")

    private static final float TOP_AND_BOTTOM_FADING_EDGE_STRENGTH = 0.9f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.540 -0400", hash_original_field = "FC6F009C65B0C75C0C5DF23CF67AE36C", hash_generated_field = "C085F1D947E124AF18C5BF8963191C8D")

    private static final int UNSCALED_DEFAULT_SELECTION_DIVIDER_HEIGHT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.540 -0400", hash_original_field = "FC5BE2F5ADC68A2D3A95F2001E2D54E1", hash_generated_field = "A30F9273F5F6D8DEBA446E2A1FCD77F6")

    private static final int SELECTOR_WHEEL_STATE_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.541 -0400", hash_original_field = "DDDD525DD61FF5B6D63FF73A59F6E938", hash_generated_field = "AB7C2892D0748CCE827BEFFB0E1A6C0B")

    private static final int SELECTOR_WHEEL_STATE_SMALL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.541 -0400", hash_original_field = "B8978561F307D330D1D9035B84EF0F45", hash_generated_field = "8296CB735858C4C48A4906A87264A89C")

    private static final int SELECTOR_WHEEL_STATE_LARGE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.541 -0400", hash_original_field = "E034023518BDAF710C586D5E1AEAE57E", hash_generated_field = "F128F7F0A64A24C56ED16A29F4C6ABC7")

    private static final int SELECTOR_WHEEL_BRIGHT_ALPHA = 255;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.541 -0400", hash_original_field = "3E24940F61253D0CC5795578AD7DBB57", hash_generated_field = "EEBA3D2E396FE3C27895034E16E3DF49")

    private static final int SELECTOR_WHEEL_DIM_ALPHA = 60;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.541 -0400", hash_original_field = "42CDB19B884EBCE2A752E09B0FCE673B", hash_generated_field = "B16E6C7D993414A16D5A60A2BE5CF10F")

    private static final int BUTTON_ALPHA_TRANSPARENT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.541 -0400", hash_original_field = "13514DC76E0487E55F151EDEDFD73281", hash_generated_field = "6CF594D491D7773C5103689146F74E09")

    private static final int BUTTON_ALPHA_OPAQUE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.541 -0400", hash_original_field = "9EE2BDD5DCE03B10066659DD3628FBCD", hash_generated_field = "7A42779B677D07C0E7AA3B31BAD2559F")

    private static final String PROPERTY_SELECTOR_PAINT_ALPHA = "selectorPaintAlpha";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.541 -0400", hash_original_field = "37BEDAFF57045F20FFDBAD562A073CFD", hash_generated_field = "9BC3F08459AACD7560DADFC6F538F3D1")

    private static final String PROPERTY_BUTTON_ALPHA = "alpha";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.541 -0400", hash_original_field = "26112D95E764086336908D74184B550D", hash_generated_field = "F76CFF63C766C4455B13D11909DFC9C1")

    private static final char[] DIGIT_CHARACTERS = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.541 -0400", hash_original_field = "BADC6B9F8BD433ADA3F646E536B203CC", hash_generated_field = "9528E259E036D3BD6D8CF2D435C72E8C")

    private static final int SIZE_UNSPECIFIED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.541 -0400", hash_original_field = "A3D46BBAE1067437FBC6059261EF8DED", hash_generated_field = "9223D0CD28261C67BCD92327016FAD40")

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

