package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:34.928 -0500", hash_original_field = "C99F9313F0CFB71F24AA867E6BD38BE4", hash_generated_field = "1DD6DB2DBAAEAD209FC944EF9017AB32")

    private static final long DEFAULT_LONG_PRESS_UPDATE_INTERVAL = 300;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:34.931 -0500", hash_original_field = "155966C8870B4A59FA36FAB62AFE09A5", hash_generated_field = "9500E56E6454819E2AE81D01349CCAD1")

    private static final int SELECTOR_MIDDLE_ITEM_INDEX = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:34.933 -0500", hash_original_field = "1DBE55BFB713F1472A91C05C6D38C306", hash_generated_field = "D4EF8F7375B8200953E206EEE0A05F6B")

    private static final int SELECTOR_MAX_FLING_VELOCITY_ADJUSTMENT = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:34.936 -0500", hash_original_field = "6B9CB8BA61C50C425371F6114C1AE961", hash_generated_field = "BA70A446419865BF598782861C034BC8")

    private static final int SELECTOR_ADJUSTMENT_DURATION_MILLIS = 800;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:34.938 -0500", hash_original_field = "BFEF056EFD52473EE637E44C2FFEC325", hash_generated_field = "938202BE77B5C450F698F4EE6DE60C2E")

    private static final int CHANGE_CURRENT_BY_ONE_SCROLL_DURATION = 300;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:34.940 -0500", hash_original_field = "004A9F623B13766F46534B441452E0D3", hash_generated_field = "E44BA99C221811C14FB7348364448070")

    private static final int SHOW_INPUT_CONTROLS_DELAY_MILLIS = ViewConfiguration
            .getDoubleTapTimeout();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:34.942 -0500", hash_original_field = "2B29915E0415345422E09D9971658D63", hash_generated_field = "054D95E51A8C564003A9200BE1B948E0")

    private static final float TOP_AND_BOTTOM_FADING_EDGE_STRENGTH = 0.9f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:34.945 -0500", hash_original_field = "C7B8D44161F3974F9127DB46C21A7D66", hash_generated_field = "C085F1D947E124AF18C5BF8963191C8D")

    private static final int UNSCALED_DEFAULT_SELECTION_DIVIDER_HEIGHT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:34.947 -0500", hash_original_field = "354ADCBC6792F90C580BDB71068A4D6E", hash_generated_field = "A30F9273F5F6D8DEBA446E2A1FCD77F6")

    private static final int SELECTOR_WHEEL_STATE_NONE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:34.949 -0500", hash_original_field = "F4898C0EA5904F5EC8EA093758F3AA15", hash_generated_field = "AB7C2892D0748CCE827BEFFB0E1A6C0B")

    private static final int SELECTOR_WHEEL_STATE_SMALL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:34.952 -0500", hash_original_field = "40FB1321829204220728C40FBF7029B1", hash_generated_field = "8296CB735858C4C48A4906A87264A89C")

    private static final int SELECTOR_WHEEL_STATE_LARGE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:34.955 -0500", hash_original_field = "D31B54F3FD748B9286A604E9D752950F", hash_generated_field = "F128F7F0A64A24C56ED16A29F4C6ABC7")

    private static final int SELECTOR_WHEEL_BRIGHT_ALPHA = 255;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:34.957 -0500", hash_original_field = "495691FB06DDB3BDB3918A02FC1BF57D", hash_generated_field = "EEBA3D2E396FE3C27895034E16E3DF49")

    private static final int SELECTOR_WHEEL_DIM_ALPHA = 60;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:34.960 -0500", hash_original_field = "C10C2B311D60414FB7037BCF9C7A5B49", hash_generated_field = "B16E6C7D993414A16D5A60A2BE5CF10F")

    private static final int BUTTON_ALPHA_TRANSPARENT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:34.962 -0500", hash_original_field = "97669B5EBA81D1AA86FF6AC1F5C3C5D3", hash_generated_field = "6CF594D491D7773C5103689146F74E09")

    private static final int BUTTON_ALPHA_OPAQUE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:34.964 -0500", hash_original_field = "2E1C6A97991CC09FD04DA11063EAA4C4", hash_generated_field = "7A42779B677D07C0E7AA3B31BAD2559F")

    private static final String PROPERTY_SELECTOR_PAINT_ALPHA = "selectorPaintAlpha";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:34.966 -0500", hash_original_field = "AB64B8A5023D2979C95A9F03921A70AD", hash_generated_field = "9BC3F08459AACD7560DADFC6F538F3D1")

    private static final String PROPERTY_BUTTON_ALPHA = "alpha";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:34.968 -0500", hash_original_field = "7B9EBE25D173EFC7F91782588E6DA675", hash_generated_field = "F76CFF63C766C4455B13D11909DFC9C1")

    private static final char[] DIGIT_CHARACTERS = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:34.971 -0500", hash_original_field = "9744EE350DF932689594CE65FC18FCCB", hash_generated_field = "9528E259E036D3BD6D8CF2D435C72E8C")

    private static final int SIZE_UNSPECIFIED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.566 -0400", hash_original_field = "A3D46BBAE1067437FBC6059261EF8DED", hash_generated_field = "9223D0CD28261C67BCD92327016FAD40")

    public static final NumberPicker.Formatter TWO_DIGIT_FORMATTER = new NumberPicker.Formatter() {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:34.974 -0500", hash_original_field = "128476B88E78A1761DD1201459C9F3EF", hash_generated_field = "66D585A6030422D44B0367C3CDA2875C")

        final StringBuilder mBuilder = new StringBuilder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:34.977 -0500", hash_original_field = "3494047018E224F0F75D04075CB9A448", hash_generated_field = "395AFDC9AC7C0E0287626B6E7F5FF0D6")

        final java.util.Formatter mFmt = new java.util.Formatter(mBuilder, java.util.Locale.US);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:34.979 -0500", hash_original_field = "4B395FF7B30F2D92E6BE8B1A0CE35518", hash_generated_field = "301E27E37994F137A8ACC75A8DFB4033")

        final Object[] mArgs = new Object[1];

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:34.983 -0500", hash_original_method = "EA386FDB56E7D2338BE5DE7A75572130", hash_generated_method = "3567942EFC3AE15A2DEC47CA2283D81F")
        
public String format(int value) {
            mArgs[0] = value;
            mBuilder.delete(0, mBuilder.length());
            mFmt.format("%02d", mArgs);
            return mFmt.toString();
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:34.987 -0500", hash_original_field = "FF32DCA972BB465CCAFAEA4465E62944", hash_generated_field = "6A00AC4B6A23FAEFDE0FF2E4DC66556D")

    private  ImageButton mIncrementButton;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:34.989 -0500", hash_original_field = "9E73420D9D50DDCD28AE1A69FFE6C169", hash_generated_field = "8919797DB93735517DC56DAC3932D3BA")

    private  ImageButton mDecrementButton;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:34.992 -0500", hash_original_field = "D58071C649ACB9E6DB8633CB20B78E4D", hash_generated_field = "9C0D266F19288A98A42D37200EC40143")

    private  EditText mInputText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:34.994 -0500", hash_original_field = "0DD4F81D09F8349C333039CCE34B2CF7", hash_generated_field = "71F573E1A874063ABEFF604D7F39473B")

    private  int mMinHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:34.996 -0500", hash_original_field = "2B42F0B48BA5A796B2697835D2F18090", hash_generated_field = "125D219AC8DBC9C1B67A62219F770498")

    private  int mMaxHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:34.998 -0500", hash_original_field = "B5D566AA92521F570066E8773A24B0C0", hash_generated_field = "ED0C6BF081117F2A257C521DB4125AB9")

    private  int mMinWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.001 -0500", hash_original_field = "DE6F7D0025A7518849324A9E1601224A", hash_generated_field = "538F7241A30BB30063B42E9CD336B31C")

    private int mMaxWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.003 -0500", hash_original_field = "392F0709869FF2954E680999B5A0546F", hash_generated_field = "FAE2C92297C3C78F4EB9A80B09EABDB5")

    private  boolean mComputeMaxWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.005 -0500", hash_original_field = "5CFDEC1CAF5A4AED7672FC72DA5F5CD1", hash_generated_field = "9990B8B20909CFDC9898F67C6FDD18EC")

    private  int mTextSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.007 -0500", hash_original_field = "508E9ED4AC7301D541E4F2A6E5D67827", hash_generated_field = "B4AB01F5C45EBC46EA14C63C779599C3")

    private int mSelectorTextGapHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.009 -0500", hash_original_field = "9A7C725654D0FA0A367B3AB4C84DF6D2", hash_generated_field = "9D634B524F57A9A167A822148025FAEE")

    private String[] mDisplayedValues;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.011 -0500", hash_original_field = "E38EAB54F5D735EAA7F469D05FA370F5", hash_generated_field = "F344B4C9A6EF700D43109B54646DFF70")

    private int mMinValue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.012 -0500", hash_original_field = "FC70CEA69DB5CEEE0562C34907CF9841", hash_generated_field = "33227317DFADBDED006865404A880DAA")

    private int mMaxValue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.015 -0500", hash_original_field = "177FAFFA7A38FCF6D55DEE4AFF0E6CEC", hash_generated_field = "1FE26AAF0F7068BF50C3FDD7D6BD850D")

    private int mValue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.017 -0500", hash_original_field = "7AF608C21D79344AACA1185472489A9D", hash_generated_field = "0F0F61C7FD20796365412FDD7923438B")

    private OnValueChangeListener mOnValueChangeListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.019 -0500", hash_original_field = "DEE4ABF5D3BA14C8164960F187FBF71B", hash_generated_field = "0E000F63F4EDDECD3CA33DA7CA7FEA0C")

    private OnScrollListener mOnScrollListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.021 -0500", hash_original_field = "180E02EA47264C617605A9175AD35DD3", hash_generated_field = "C7348EA20A64E5E4153D9A81AAD67C67")

    private Formatter mFormatter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.024 -0500", hash_original_field = "EF290741D8DEF50E876A0381A15F77C8", hash_generated_field = "5475390B43BC34D0C8A978C8F9A847C2")

    private long mLongPressUpdateInterval = DEFAULT_LONG_PRESS_UPDATE_INTERVAL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.026 -0500", hash_original_field = "0F2E15A60DD5F669CE69091322EC5998", hash_generated_field = "9847ACB6B4DACF158F3D2FEBEA01CEE3")

    private final SparseArray<String> mSelectorIndexToStringCache = new SparseArray<String>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.029 -0500", hash_original_field = "B64598B71F5675E012759F9F49478E5C", hash_generated_field = "E21DFCC6B3D6A21319845AE11E11A50E")

    private final int[] mSelectorIndices = new int[] {
            Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE,
            Integer.MIN_VALUE
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.031 -0500", hash_original_field = "2B46E91CAB19D77BDE708CA6CFD241E3", hash_generated_field = "20F4B411AF6CE39A519EBD45F26526F1")

    private  Paint mSelectorWheelPaint;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.033 -0500", hash_original_field = "DE4F9F14827F57A59CAC3112D6A949AD", hash_generated_field = "5CD8B3A0694C4DAD9DE6B5F7D563825B")

    private int mSelectorElementHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.035 -0500", hash_original_field = "F2EC3CE1BF96C3FD1C8886D899A3B5FA", hash_generated_field = "1C64752769ECDFF4D4DADF48DFC62B2A")

    private int mInitialScrollOffset = Integer.MIN_VALUE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.037 -0500", hash_original_field = "2679AA82BD88C25F32154539AB4D68E7", hash_generated_field = "867616A04972E32F759A945F5C8C6DE5")

    private int mCurrentScrollOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.039 -0500", hash_original_field = "3455A40170297F746947FD13F44FD85E", hash_generated_field = "A7FE0D43A8992E5853B470E81D7DC5CD")

    private  Scroller mFlingScroller;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.041 -0500", hash_original_field = "49A57B83379DF5D41A7CAE46A30CED98", hash_generated_field = "63E636A5CF531649A485C370342AD357")

    private  Scroller mAdjustScroller;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.044 -0500", hash_original_field = "C3DEB4080699ED1BE42D97E69CC735A5", hash_generated_field = "235D804B1C18B69F2999347603A3A1E8")

    private int mPreviousScrollerY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.046 -0500", hash_original_field = "18E8928D43983E9FFC624F7F2716A0ED", hash_generated_field = "A6929C7A4CC6DB84E0B021A11596A9A5")

    private SetSelectionCommand mSetSelectionCommand;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.048 -0500", hash_original_field = "27D329E30B05A3784310FDEE1ABE149E", hash_generated_field = "2CCBB805FEDFC92E21EF25E3ACD258AE")

    private AdjustScrollerCommand mAdjustScrollerCommand;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.050 -0500", hash_original_field = "2BEE6DB886B9F5F507BE7569B3CF6CA9", hash_generated_field = "7D45776D84FA49FF3DE5AD7BB6B6D7B3")

    private ChangeCurrentByOneFromLongPressCommand mChangeCurrentByOneFromLongPressCommand;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.052 -0500", hash_original_field = "213BC8C32E45BD8C93772A4DCE04D500", hash_generated_field = "FADCC7819944EB29C99CDA856F21DF00")

    private  AnimatorSet mShowInputControlsAnimator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.054 -0500", hash_original_field = "E16828C9FA31DA65082F12996BF04C29", hash_generated_field = "32D55D7A2E6874CDD998EF34A3CF8BCE")

    private  Animator mDimSelectorWheelAnimator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.056 -0500", hash_original_field = "DECD487D447B6BB71B3892AAA4AA93F4", hash_generated_field = "05FA59074D08C75E813C9AC8A436526B")

    private float mLastDownEventY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.058 -0500", hash_original_field = "EF06B1ECD632A3262468ED1BA4E2DBAC", hash_generated_field = "54CBBDE9743B0ECBCF94B59C2ADF715D")

    private float mLastMotionEventY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.061 -0500", hash_original_field = "1CD85BBAE76523DF05730198A6432E01", hash_generated_field = "B26DD00B53AFA2DFD31DAB39D66D679A")

    private boolean mBeginEditOnUpEvent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.063 -0500", hash_original_field = "1F2537037A17C0B86851AB7770AE662A", hash_generated_field = "088B2EE9C72C787499D1C9756D7C9AE2")

    private boolean mAdjustScrollerOnUpEvent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.065 -0500", hash_original_field = "CB009BBD72354574BD149A6A62A9592A", hash_generated_field = "C2D0E72CEAF9BB67D06EF8A48CD873BF")

    private int mSelectorWheelState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.067 -0500", hash_original_field = "507D8F8387EDC230B54D84A5AD8E5830", hash_generated_field = "5BEE30D4541C1ECA385873E799FC4104")

    private VelocityTracker mVelocityTracker;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.069 -0500", hash_original_field = "D11C33EFD56B37B918E01A200C446C59", hash_generated_field = "3B323323DD6A6BF972666D993592C670")

    private int mTouchSlop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.071 -0500", hash_original_field = "5030B66C4E6C852287D391072C8046A5", hash_generated_field = "19DF3CA9C4A086C5604F6C8FC7721322")

    private int mMinimumFlingVelocity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.073 -0500", hash_original_field = "3B70336BAB0F826E0E6552B2A74F553D", hash_generated_field = "7F5E59D933F0155E107640D32355B310")

    private int mMaximumFlingVelocity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.075 -0500", hash_original_field = "D1F5C8EABECFDD091EEF983301CE345C", hash_generated_field = "5C5871BE5B096A9BD740EB5329BEAAF1")

    private boolean mWrapSelectorWheel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.077 -0500", hash_original_field = "E26765170D65F5A03459947C85ABE151", hash_generated_field = "0ACF9128B8830FF701248CF7C11543ED")

    private  int mSolidColor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.079 -0500", hash_original_field = "CF1E1943436E701C28C672F2A5B3323B", hash_generated_field = "DDEBF599D1C277FAE44436DE5F4925D9")

    private  boolean mFlingable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.081 -0500", hash_original_field = "73346BF3FA4D550EB3F34A091C3A051B", hash_generated_field = "05188C781C0BE6F065277E3B64526E24")

    private  Drawable mSelectionDivider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.084 -0500", hash_original_field = "74EB167AE8B0C56BD0220DD1D47ABD0A", hash_generated_field = "8270882201C05EAC24EEFCE46B4DEF7E")

    private  int mSelectionDividerHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.087 -0500", hash_original_field = "1732EB32F2D77CCA26590AEEA670A175", hash_generated_field = "A498F2A4744F31D22F9C4ABEBB254F2F")

    private final Rect mTempRect = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.089 -0500", hash_original_field = "C8881BE3ED970569A936A2EDA38A3A60", hash_generated_field = "67AD5A07D54DA7533142AFF00645E1A8")

    private int mScrollState = OnScrollListener.SCROLL_STATE_IDLE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.091 -0500", hash_original_field = "69A70E4931735C56CC8C40C2D21BA6A0", hash_generated_field = "D42B9F4CA6EACF3E5515F0113524B53F")

    private  long mShowInputControlsAnimimationDuration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.093 -0500", hash_original_field = "AADE40222493C372E5542B460C787436", hash_generated_field = "3AF141780F761DF920901C84521B4FAF")

    private boolean mScrollWheelAndFadingEdgesInitialized;

    /**
     * Create a new number picker.
     *
     * @param context The application environment.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.102 -0500", hash_original_method = "F79ABC70152851F522A29F89B10B477D", hash_generated_method = "DD86D98F065C04AD05C029FCCF3292E5")
    
public NumberPicker(Context context) {
        this(context, null);
    }

    /**
     * Create a new number picker.
     *
     * @param context The application environment.
     * @param attrs A collection of attributes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.105 -0500", hash_original_method = "C1116E13D5D84737E9D8F11A400A580C", hash_generated_method = "07F802BBB2558FEFA105C5B815465D9D")
    
public NumberPicker(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.numberPickerStyle);
    }

    /**
     * Create a new number picker
     *
     * @param context the application environment.
     * @param attrs a collection of attributes.
     * @param defStyle The default style to apply to this view.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.129 -0500", hash_original_method = "8AC7B7259BDDBD9FCC66E09C35F9B950", hash_generated_method = "D67E8F3103C43FA353F778229973A259")
    
public NumberPicker(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        // process style attributes
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
        if (mMinHeight != SIZE_UNSPECIFIED && mMaxHeight != SIZE_UNSPECIFIED
                && mMinHeight > mMaxHeight) {
            throw new IllegalArgumentException("minHeight > maxHeight");
        }
        mMinWidth = attributesArray.getDimensionPixelSize(R.styleable.NumberPicker_minWidth,
                SIZE_UNSPECIFIED);
        mMaxWidth = attributesArray.getDimensionPixelSize(R.styleable.NumberPicker_maxWidth,
                SIZE_UNSPECIFIED);
        if (mMinWidth != SIZE_UNSPECIFIED && mMaxWidth != SIZE_UNSPECIFIED
                && mMinWidth > mMaxWidth) {
            throw new IllegalArgumentException("minWidth > maxWidth");
        }
        mComputeMaxWidth = (mMaxWidth == Integer.MAX_VALUE);
        attributesArray.recycle();

        mShowInputControlsAnimimationDuration = getResources().getInteger(
                R.integer.config_longAnimTime);

        // By default Linearlayout that we extend is not drawn. This is
        // its draw() method is not called but dispatchDraw() is called
        // directly (see ViewGroup.drawChild()). However, this class uses
        // the fading edge effect implemented by View and we need our
        // draw() method to be called. Therefore, we declare we will draw.
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

        // increment button
        mIncrementButton = (ImageButton) findViewById(R.id.increment);
        mIncrementButton.setOnClickListener(onClickListener);
        mIncrementButton.setOnLongClickListener(onLongClickListener);

        // decrement button
        mDecrementButton = (ImageButton) findViewById(R.id.decrement);
        mDecrementButton.setOnClickListener(onClickListener);
        mDecrementButton.setOnLongClickListener(onLongClickListener);

        // input text
        mInputText = (EditText) findViewById(R.id.numberpicker_input);
        mInputText.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    mInputText.selectAll();
                    InputMethodManager inputMethodManager = InputMethodManager.peekInstance();
                    if (inputMethodManager != null) {
                        inputMethodManager.showSoftInput(mInputText, 0);
                    }
                } else {
                    mInputText.setSelection(0, 0);
                    validateInputTextView(v);
                }
            }
        });
        mInputText.setFilters(new InputFilter[] {
            new InputTextFilter()
        });

        mInputText.setRawInputType(InputType.TYPE_CLASS_NUMBER);

        // initialize constants
        mTouchSlop = ViewConfiguration.getTapTimeout();
        ViewConfiguration configuration = ViewConfiguration.get(context);
        mTouchSlop = configuration.getScaledTouchSlop();
        mMinimumFlingVelocity = configuration.getScaledMinimumFlingVelocity();
        mMaximumFlingVelocity = configuration.getScaledMaximumFlingVelocity()
                / SELECTOR_MAX_FLING_VELOCITY_ADJUSTMENT;
        mTextSize = (int) mInputText.getTextSize();

        // create the selector wheel paint
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextAlign(Align.CENTER);
        paint.setTextSize(mTextSize);
        paint.setTypeface(mInputText.getTypeface());
        ColorStateList colors = mInputText.getTextColors();
        int color = colors.getColorForState(ENABLED_STATE_SET, Color.WHITE);
        paint.setColor(color);
        mSelectorWheelPaint = paint;

        // create the animator for showing the input controls
        mDimSelectorWheelAnimator = ObjectAnimator.ofInt(this, PROPERTY_SELECTOR_PAINT_ALPHA,
                SELECTOR_WHEEL_BRIGHT_ALPHA, SELECTOR_WHEEL_DIM_ALPHA);
        final ObjectAnimator showIncrementButton = ObjectAnimator.ofFloat(mIncrementButton,
                PROPERTY_BUTTON_ALPHA, BUTTON_ALPHA_TRANSPARENT, BUTTON_ALPHA_OPAQUE);
        final ObjectAnimator showDecrementButton = ObjectAnimator.ofFloat(mDecrementButton,
                PROPERTY_BUTTON_ALPHA, BUTTON_ALPHA_TRANSPARENT, BUTTON_ALPHA_OPAQUE);
        mShowInputControlsAnimator = new AnimatorSet();
        mShowInputControlsAnimator.playTogether(mDimSelectorWheelAnimator, showIncrementButton,
                showDecrementButton);
        mShowInputControlsAnimator.addListener(new AnimatorListenerAdapter() {
            private boolean mCanceled = false;

            @Override
            public void onAnimationEnd(Animator animation) {
                if (!mCanceled) {
                    // if canceled => we still want the wheel drawn
                    setSelectorWheelState(SELECTOR_WHEEL_STATE_SMALL);
                }
                mCanceled = false;
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                if (mShowInputControlsAnimator.isRunning()) {
                    mCanceled = true;
                }
            }
        });

        // create the fling and adjust scrollers
        mFlingScroller = new Scroller(getContext(), null, true);
        mAdjustScroller = new Scroller(getContext(), new DecelerateInterpolator(2.5f));

        updateInputTextView();
        updateIncrementAndDecrementButtonsVisibilityState();

        if (mFlingable) {
           if (isInEditMode()) {
               setSelectorWheelState(SELECTOR_WHEEL_STATE_SMALL);
           } else {
                // Start with shown selector wheel and hidden controls. When made
                // visible hide the selector and fade-in the controls to suggest
                // fling interaction.
                setSelectorWheelState(SELECTOR_WHEEL_STATE_LARGE);
                hideInputControls();
           }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.133 -0500", hash_original_method = "E727E2B4CEB86D0A1B38AD8650A5C905", hash_generated_method = "AB96A61CE6933EA1081B275820BF1C23")
    
@Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        final int msrdWdth = getMeasuredWidth();
        final int msrdHght = getMeasuredHeight();

        // Increment button at the top.
        final int inctBtnMsrdWdth = mIncrementButton.getMeasuredWidth();
        final int incrBtnLeft = (msrdWdth - inctBtnMsrdWdth) / 2;
        final int incrBtnTop = 0;
        final int incrBtnRight = incrBtnLeft + inctBtnMsrdWdth;
        final int incrBtnBottom = incrBtnTop + mIncrementButton.getMeasuredHeight();
        mIncrementButton.layout(incrBtnLeft, incrBtnTop, incrBtnRight, incrBtnBottom);

        // Input text centered horizontally.
        final int inptTxtMsrdWdth = mInputText.getMeasuredWidth();
        final int inptTxtMsrdHght = mInputText.getMeasuredHeight();
        final int inptTxtLeft = (msrdWdth - inptTxtMsrdWdth) / 2;
        final int inptTxtTop = (msrdHght - inptTxtMsrdHght) / 2;
        final int inptTxtRight = inptTxtLeft + inptTxtMsrdWdth;
        final int inptTxtBottom = inptTxtTop + inptTxtMsrdHght;
        mInputText.layout(inptTxtLeft, inptTxtTop, inptTxtRight, inptTxtBottom);

        // Decrement button at the top.
        final int decrBtnMsrdWdth = mIncrementButton.getMeasuredWidth();
        final int decrBtnLeft = (msrdWdth - decrBtnMsrdWdth) / 2;
        final int decrBtnTop = msrdHght - mDecrementButton.getMeasuredHeight();
        final int decrBtnRight = decrBtnLeft + decrBtnMsrdWdth;
        final int decrBtnBottom = msrdHght;
        mDecrementButton.layout(decrBtnLeft, decrBtnTop, decrBtnRight, decrBtnBottom);

        if (!mScrollWheelAndFadingEdgesInitialized) {
            mScrollWheelAndFadingEdgesInitialized = true;
            // need to do all this when we know our size
            initializeSelectorWheel();
            initializeFadingEdges();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.135 -0500", hash_original_method = "048719DA53F07F7F498A46C4561541BF", hash_generated_method = "7AAA45A8190866768CAEA3A7F88E5BC9")
    
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // Try greedily to fit the max width and height.
        final int newWidthMeasureSpec = makeMeasureSpec(widthMeasureSpec, mMaxWidth);
        final int newHeightMeasureSpec = makeMeasureSpec(heightMeasureSpec, mMaxHeight);
        super.onMeasure(newWidthMeasureSpec, newHeightMeasureSpec);
        // Flag if we are measured with width or height less than the respective min.
        final int widthSize = resolveSizeAndStateRespectingMinSize(mMinWidth, getMeasuredWidth(),
                widthMeasureSpec);
        final int heightSize = resolveSizeAndStateRespectingMinSize(mMinHeight, getMeasuredHeight(),
                heightMeasureSpec);
        setMeasuredDimension(widthSize, heightSize);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.139 -0500", hash_original_method = "10C35B0DAD7657DB14B7F950A0414363", hash_generated_method = "CA6D5BF4349F597E394C11DE300C40FA")
    
@Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (!isEnabled() || !mFlingable) {
            return false;
        }
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                mLastMotionEventY = mLastDownEventY = event.getY();
                removeAllCallbacks();
                mShowInputControlsAnimator.cancel();
                mDimSelectorWheelAnimator.cancel();
                mBeginEditOnUpEvent = false;
                mAdjustScrollerOnUpEvent = true;
                if (mSelectorWheelState == SELECTOR_WHEEL_STATE_LARGE) {
                    mSelectorWheelPaint.setAlpha(SELECTOR_WHEEL_BRIGHT_ALPHA);
                    boolean scrollersFinished = mFlingScroller.isFinished()
                            && mAdjustScroller.isFinished();
                    if (!scrollersFinished) {
                        mFlingScroller.forceFinished(true);
                        mAdjustScroller.forceFinished(true);
                        onScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
                    }
                    mBeginEditOnUpEvent = scrollersFinished;
                    mAdjustScrollerOnUpEvent = true;
                    hideInputControls();
                    return true;
                }
                if (isEventInVisibleViewHitRect(event, mIncrementButton)
                        || isEventInVisibleViewHitRect(event, mDecrementButton)) {
                    return false;
                }
                mAdjustScrollerOnUpEvent = false;
                setSelectorWheelState(SELECTOR_WHEEL_STATE_LARGE);
                hideInputControls();
                return true;
            case MotionEvent.ACTION_MOVE:
                float currentMoveY = event.getY();
                int deltaDownY = (int) Math.abs(currentMoveY - mLastDownEventY);
                if (deltaDownY > mTouchSlop) {
                    mBeginEditOnUpEvent = false;
                    onScrollStateChange(OnScrollListener.SCROLL_STATE_TOUCH_SCROLL);
                    setSelectorWheelState(SELECTOR_WHEEL_STATE_LARGE);
                    hideInputControls();
                    return true;
                }
                break;
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.142 -0500", hash_original_method = "235D8E8A92689E68622E8E516F140226", hash_generated_method = "9EFEEFA1427AEB4178A438F4BEFBF68D")
    
@Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (!isEnabled()) {
            return false;
        }
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(ev);
        int action = ev.getActionMasked();
        switch (action) {
            case MotionEvent.ACTION_MOVE:
                float currentMoveY = ev.getY();
                if (mBeginEditOnUpEvent
                        || mScrollState != OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    int deltaDownY = (int) Math.abs(currentMoveY - mLastDownEventY);
                    if (deltaDownY > mTouchSlop) {
                        mBeginEditOnUpEvent = false;
                        onScrollStateChange(OnScrollListener.SCROLL_STATE_TOUCH_SCROLL);
                    }
                }
                int deltaMoveY = (int) (currentMoveY - mLastMotionEventY);
                scrollBy(0, deltaMoveY);
                invalidate();
                mLastMotionEventY = currentMoveY;
                break;
            case MotionEvent.ACTION_UP:
                if (mBeginEditOnUpEvent) {
                    setSelectorWheelState(SELECTOR_WHEEL_STATE_SMALL);
                    showInputControls(mShowInputControlsAnimimationDuration);
                    mInputText.requestFocus();
                    return true;
                }
                VelocityTracker velocityTracker = mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, mMaximumFlingVelocity);
                int initialVelocity = (int) velocityTracker.getYVelocity();
                if (Math.abs(initialVelocity) > mMinimumFlingVelocity) {
                    fling(initialVelocity);
                    onScrollStateChange(OnScrollListener.SCROLL_STATE_FLING);
                } else {
                    if (mAdjustScrollerOnUpEvent) {
                        if (mFlingScroller.isFinished() && mAdjustScroller.isFinished()) {
                            postAdjustScrollerCommand(0);
                        }
                    } else {
                        postAdjustScrollerCommand(SHOW_INPUT_CONTROLS_DELAY_MILLIS);
                    }
                }
                mVelocityTracker.recycle();
                mVelocityTracker = null;
                break;
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.144 -0500", hash_original_method = "BF176E11CE8244676F550C2A8C029DBC", hash_generated_method = "E2641455B67DC2C4BB8C9B3F453BB057")
    
@Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        final int action = event.getActionMasked();
        switch (action) {
            case MotionEvent.ACTION_MOVE:
                if (mSelectorWheelState == SELECTOR_WHEEL_STATE_LARGE) {
                    removeAllCallbacks();
                    forceCompleteChangeCurrentByOneViaScroll();
                }
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                removeAllCallbacks();
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.146 -0500", hash_original_method = "5F2124C88DD28BBD925F58E6B4833CD1", hash_generated_method = "3CA5546A195DEAE6B090F013ADF3BC37")
    
@Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int keyCode = event.getKeyCode();
        if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER || keyCode == KeyEvent.KEYCODE_ENTER) {
            removeAllCallbacks();
        }
        return super.dispatchKeyEvent(event);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.148 -0500", hash_original_method = "7AF2AFA03903803DBB932D40A216CA15", hash_generated_method = "3D85DE1D0ED4377C2B7B38A5DC883992")
    
@Override
    public boolean dispatchTrackballEvent(MotionEvent event) {
        int action = event.getActionMasked();
        if (action == MotionEvent.ACTION_CANCEL || action == MotionEvent.ACTION_UP) {
            removeAllCallbacks();
        }
        return super.dispatchTrackballEvent(event);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.151 -0500", hash_original_method = "A8C44E23055FC2DF1A30CAFE867BE321", hash_generated_method = "76CA54367C121E45AA8E37C7F637D84E")
    
@Override
    public void computeScroll() {
        if (mSelectorWheelState == SELECTOR_WHEEL_STATE_NONE) {
            return;
        }
        Scroller scroller = mFlingScroller;
        if (scroller.isFinished()) {
            scroller = mAdjustScroller;
            if (scroller.isFinished()) {
                return;
            }
        }
        scroller.computeScrollOffset();
        int currentScrollerY = scroller.getCurrY();
        if (mPreviousScrollerY == 0) {
            mPreviousScrollerY = scroller.getStartY();
        }
        scrollBy(0, currentScrollerY - mPreviousScrollerY);
        mPreviousScrollerY = currentScrollerY;
        if (scroller.isFinished()) {
            onScrollerFinished(scroller);
        } else {
            invalidate();
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.154 -0500", hash_original_method = "B6D6495EF8D39EBA8CC69BAAD1076261", hash_generated_method = "779A92564B3688AA0B13025B127F20C5")
    
@Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        mIncrementButton.setEnabled(enabled);
        mDecrementButton.setEnabled(enabled);
        mInputText.setEnabled(enabled);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.157 -0500", hash_original_method = "4E7C0796471D51CC4FDC613C54076EA5", hash_generated_method = "AE7D62788CC32521CA854F7350DEA5F5")
    
@Override
    public void scrollBy(int x, int y) {
        if (mSelectorWheelState == SELECTOR_WHEEL_STATE_NONE) {
            return;
        }
        int[] selectorIndices = mSelectorIndices;
        if (!mWrapSelectorWheel && y > 0
                && selectorIndices[SELECTOR_MIDDLE_ITEM_INDEX] <= mMinValue) {
            mCurrentScrollOffset = mInitialScrollOffset;
            return;
        }
        if (!mWrapSelectorWheel && y < 0
                && selectorIndices[SELECTOR_MIDDLE_ITEM_INDEX] >= mMaxValue) {
            mCurrentScrollOffset = mInitialScrollOffset;
            return;
        }
        mCurrentScrollOffset += y;
        while (mCurrentScrollOffset - mInitialScrollOffset > mSelectorTextGapHeight) {
            mCurrentScrollOffset -= mSelectorElementHeight;
            decrementSelectorIndices(selectorIndices);
            changeCurrent(selectorIndices[SELECTOR_MIDDLE_ITEM_INDEX]);
            if (!mWrapSelectorWheel && selectorIndices[SELECTOR_MIDDLE_ITEM_INDEX] <= mMinValue) {
                mCurrentScrollOffset = mInitialScrollOffset;
            }
        }
        while (mCurrentScrollOffset - mInitialScrollOffset < -mSelectorTextGapHeight) {
            mCurrentScrollOffset += mSelectorElementHeight;
            incrementSelectorIndices(selectorIndices);
            changeCurrent(selectorIndices[SELECTOR_MIDDLE_ITEM_INDEX]);
            if (!mWrapSelectorWheel && selectorIndices[SELECTOR_MIDDLE_ITEM_INDEX] >= mMaxValue) {
                mCurrentScrollOffset = mInitialScrollOffset;
            }
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.159 -0500", hash_original_method = "A5D52728D322EA76B9FE19A001AC2619", hash_generated_method = "C018A36B3FBB8F24D1A26C1A669111FA")
    
@Override
    public int getSolidColor() {
        return mSolidColor;
    }

    /**
     * Sets the listener to be notified on change of the current value.
     *
     * @param onValueChangedListener The listener.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.161 -0500", hash_original_method = "B8FD740B950D37D2ACEC32CDC9BBCB3E", hash_generated_method = "4E83B632DDA0759287BED9C3BB74F152")
    
public void setOnValueChangedListener(OnValueChangeListener onValueChangedListener) {
        mOnValueChangeListener = onValueChangedListener;
    }

    /**
     * Set listener to be notified for scroll state changes.
     *
     * @param onScrollListener The listener.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.163 -0500", hash_original_method = "E07C1A1F4DD9D0D02072D75B16D4DB8B", hash_generated_method = "4882BD00D8CB073C01DFD2DB0330CBD7")
    
public void setOnScrollListener(OnScrollListener onScrollListener) {
        mOnScrollListener = onScrollListener;
    }

    /**
     * Set the formatter to be used for formatting the current value.
     * <p>
     * Note: If you have provided alternative values for the values this
     * formatter is never invoked.
     * </p>
     *
     * @param formatter The formatter object. If formatter is <code>null</code>,
     *            {@link String#valueOf(int)} will be used.
     *
     * @see #setDisplayedValues(String[])
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.165 -0500", hash_original_method = "3C88654A4CCA22ED513CF659C7EAC98C", hash_generated_method = "174C041134FDB006913C369A0872E7C6")
    
public void setFormatter(Formatter formatter) {
        if (formatter == mFormatter) {
            return;
        }
        mFormatter = formatter;
        initializeSelectorWheelIndices();
        updateInputTextView();
    }

    /**
     * Set the current value for the number picker.
     * <p>
     * If the argument is less than the {@link NumberPicker#getMinValue()} and
     * {@link NumberPicker#getWrapSelectorWheel()} is <code>false</code> the
     * current value is set to the {@link NumberPicker#getMinValue()} value.
     * </p>
     * <p>
     * If the argument is less than the {@link NumberPicker#getMinValue()} and
     * {@link NumberPicker#getWrapSelectorWheel()} is <code>true</code> the
     * current value is set to the {@link NumberPicker#getMaxValue()} value.
     * </p>
     * <p>
     * If the argument is less than the {@link NumberPicker#getMaxValue()} and
     * {@link NumberPicker#getWrapSelectorWheel()} is <code>false</code> the
     * current value is set to the {@link NumberPicker#getMaxValue()} value.
     * </p>
     * <p>
     * If the argument is less than the {@link NumberPicker#getMaxValue()} and
     * {@link NumberPicker#getWrapSelectorWheel()} is <code>true</code> the
     * current value is set to the {@link NumberPicker#getMinValue()} value.
     * </p>
     *
     * @param value The current value.
     * @see #setWrapSelectorWheel(boolean)
     * @see #setMinValue(int)
     * @see #setMaxValue(int)
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.168 -0500", hash_original_method = "27A138A3602AD1BB9BCFA8883739C2F3", hash_generated_method = "893E9699FA71383E5011E5628D2A71A2")
    
public void setValue(int value) {
        if (mValue == value) {
            return;
        }
        if (value < mMinValue) {
            value = mWrapSelectorWheel ? mMaxValue : mMinValue;
        }
        if (value > mMaxValue) {
            value = mWrapSelectorWheel ? mMinValue : mMaxValue;
        }
        mValue = value;
        initializeSelectorWheelIndices();
        updateInputTextView();
        updateIncrementAndDecrementButtonsVisibilityState();
        invalidate();
    }

    /**
     * Computes the max width if no such specified as an attribute.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.170 -0500", hash_original_method = "EC05395A137121E418B1180AC02A20B0", hash_generated_method = "FA48A23A81492EA6733C2803BABCEEEF")
    
private void tryComputeMaxWidth() {
        if (!mComputeMaxWidth) {
            return;
        }
        int maxTextWidth = 0;
        if (mDisplayedValues == null) {
            float maxDigitWidth = 0;
            for (int i = 0; i <= 9; i++) {
                final float digitWidth = mSelectorWheelPaint.measureText(String.valueOf(i));
                if (digitWidth > maxDigitWidth) {
                    maxDigitWidth = digitWidth;
                }
            }
            int numberOfDigits = 0;
            int current = mMaxValue;
            while (current > 0) {
                numberOfDigits++;
                current = current / 10;
            }
            maxTextWidth = (int) (numberOfDigits * maxDigitWidth);
        } else {
            final int valueCount = mDisplayedValues.length;
            for (int i = 0; i < valueCount; i++) {
                final float textWidth = mSelectorWheelPaint.measureText(mDisplayedValues[i]);
                if (textWidth > maxTextWidth) {
                    maxTextWidth = (int) textWidth;
                }
            }
        }
        maxTextWidth += mInputText.getPaddingLeft() + mInputText.getPaddingRight();
        if (mMaxWidth != maxTextWidth) {
            if (maxTextWidth > mMinWidth) {
                mMaxWidth = maxTextWidth;
            } else {
                mMaxWidth = mMinWidth;
            }
            invalidate();
        }
    }

    /**
     * Gets whether the selector wheel wraps when reaching the min/max value.
     *
     * @return True if the selector wheel wraps.
     *
     * @see #getMinValue()
     * @see #getMaxValue()
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.173 -0500", hash_original_method = "0DE9A61E4C9F0206942BD1BD5DBB2993", hash_generated_method = "0221C9177B13D161F2561604D228B1D0")
    
public boolean getWrapSelectorWheel() {
        return mWrapSelectorWheel;
    }

    /**
     * Sets whether the selector wheel shown during flinging/scrolling should
     * wrap around the {@link NumberPicker#getMinValue()} and
     * {@link NumberPicker#getMaxValue()} values.
     * <p>
     * By default if the range (max - min) is more than five (the number of
     * items shown on the selector wheel) the selector wheel wrapping is
     * enabled.
     * </p>
     *
     * @param wrapSelectorWheel Whether to wrap.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.175 -0500", hash_original_method = "4802BADC2E2D3D03E25B827D3F65AC09", hash_generated_method = "CBF2C335E9DE8C2FB2266D01786B42B8")
    
public void setWrapSelectorWheel(boolean wrapSelectorWheel) {
        if (wrapSelectorWheel && (mMaxValue - mMinValue) < mSelectorIndices.length) {
            throw new IllegalStateException("Range less than selector items count.");
        }
        if (wrapSelectorWheel != mWrapSelectorWheel) {
            mWrapSelectorWheel = wrapSelectorWheel;
            updateIncrementAndDecrementButtonsVisibilityState();
        }
    }

    /**
     * Sets the speed at which the numbers be incremented and decremented when
     * the up and down buttons are long pressed respectively.
     * <p>
     * The default value is 300 ms.
     * </p>
     *
     * @param intervalMillis The speed (in milliseconds) at which the numbers
     *            will be incremented and decremented.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.177 -0500", hash_original_method = "8C354EDC01FB7FE8E35D5D03601EF310", hash_generated_method = "A9CAFB7DF755623ECED789209D032291")
    
public void setOnLongPressUpdateInterval(long intervalMillis) {
        mLongPressUpdateInterval = intervalMillis;
    }

    /**
     * Returns the value of the picker.
     *
     * @return The value.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.179 -0500", hash_original_method = "873C7D38131A035B7F6055170D432634", hash_generated_method = "612E588787E3A1FC08CE2E1A6D34D03A")
    
public int getValue() {
        return mValue;
    }

    /**
     * Returns the min value of the picker.
     *
     * @return The min value
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.181 -0500", hash_original_method = "734B6103B2E180B236F243E5AD573634", hash_generated_method = "E14ACFAD17E885847B2037E16680637A")
    
public int getMinValue() {
        return mMinValue;
    }

    /**
     * Sets the min value of the picker.
     *
     * @param minValue The min value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.184 -0500", hash_original_method = "661BFF8A6967E0A91919CA7BDDDCFF35", hash_generated_method = "0338F44D18DDB51B5FD43C86081D4560")
    
public void setMinValue(int minValue) {
        if (mMinValue == minValue) {
            return;
        }
        if (minValue < 0) {
            throw new IllegalArgumentException("minValue must be >= 0");
        }
        mMinValue = minValue;
        if (mMinValue > mValue) {
            mValue = mMinValue;
        }
        boolean wrapSelectorWheel = mMaxValue - mMinValue > mSelectorIndices.length;
        setWrapSelectorWheel(wrapSelectorWheel);
        initializeSelectorWheelIndices();
        updateInputTextView();
        tryComputeMaxWidth();
    }

    /**
     * Returns the max value of the picker.
     *
     * @return The max value.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.186 -0500", hash_original_method = "D9333690652DA8538B4523261E9BBD48", hash_generated_method = "DD027431AD01220BDC2FE04331979B71")
    
public int getMaxValue() {
        return mMaxValue;
    }

    /**
     * Sets the max value of the picker.
     *
     * @param maxValue The max value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.188 -0500", hash_original_method = "1C3BC534ADC5B8B2FC50C2F4D93BA1C9", hash_generated_method = "C6D513856698137C57403435D5F031D3")
    
public void setMaxValue(int maxValue) {
        if (mMaxValue == maxValue) {
            return;
        }
        if (maxValue < 0) {
            throw new IllegalArgumentException("maxValue must be >= 0");
        }
        mMaxValue = maxValue;
        if (mMaxValue < mValue) {
            mValue = mMaxValue;
        }
        boolean wrapSelectorWheel = mMaxValue - mMinValue > mSelectorIndices.length;
        setWrapSelectorWheel(wrapSelectorWheel);
        initializeSelectorWheelIndices();
        updateInputTextView();
        tryComputeMaxWidth();
    }

    /**
     * Gets the values to be displayed instead of string values.
     *
     * @return The displayed values.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.190 -0500", hash_original_method = "7D8D8A804F018648196BF68A974CA568", hash_generated_method = "B96951674B1895E71860C1345553F46F")
    
public String[] getDisplayedValues() {
        return mDisplayedValues;
    }

    /**
     * Sets the values to be displayed.
     *
     * @param displayedValues The displayed values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.193 -0500", hash_original_method = "0435EA5A97E8A7F818A581EB86B2390D", hash_generated_method = "94AEBEA8E7AEAF521D2FBBE7422FC808")
    
public void setDisplayedValues(String[] displayedValues) {
        if (mDisplayedValues == displayedValues) {
            return;
        }
        mDisplayedValues = displayedValues;
        if (mDisplayedValues != null) {
            // Allow text entry rather than strictly numeric entry.
            mInputText.setRawInputType(InputType.TYPE_CLASS_TEXT
                    | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
        } else {
            mInputText.setRawInputType(InputType.TYPE_CLASS_NUMBER);
        }
        updateInputTextView();
        initializeSelectorWheelIndices();
        tryComputeMaxWidth();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.195 -0500", hash_original_method = "26009EEE98735F9AF4C2D76E4A1AFAB0", hash_generated_method = "A03901498805A97FB2D760D2745E3B9F")
    
@Override
    protected float getTopFadingEdgeStrength() {
        return TOP_AND_BOTTOM_FADING_EDGE_STRENGTH;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.197 -0500", hash_original_method = "A0CE61C0CAF5846D2D470684E7070854", hash_generated_method = "AEA22FDB25FBE08D00CEC16A202992CC")
    
@Override
    protected float getBottomFadingEdgeStrength() {
        return TOP_AND_BOTTOM_FADING_EDGE_STRENGTH;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.200 -0500", hash_original_method = "D8635D04A384ABA875A77249BA87A3E4", hash_generated_method = "C61528B0F4AAE616365FEFA487C8F7E2")
    
@Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        // make sure we show the controls only the very
        // first time the user sees this widget
        if (mFlingable && !isInEditMode()) {
            // animate a bit slower the very first time
            showInputControls(mShowInputControlsAnimimationDuration * 2);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.202 -0500", hash_original_method = "1AF381BAEFDBA706A0AAFFFCBFBE7386", hash_generated_method = "AA4E0DA545A5B13C11282CBBD898C43A")
    
@Override
    protected void onDetachedFromWindow() {
        removeAllCallbacks();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.204 -0500", hash_original_method = "0296ECFD4FBB578ABFB3DEE9D2F54084", hash_generated_method = "C5140F4F7F46A13ACBF6C5E2F71E1EFD")
    
@Override
    protected void dispatchDraw(Canvas canvas) {
        // There is a good reason for doing this. See comments in draw().
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.207 -0500", hash_original_method = "592CCD8540DAA22101D858B8673CA0A4", hash_generated_method = "705B68FCFD935CE7E333E2E13FFA2F85")
    
@Override
    public void draw(Canvas canvas) {
        // Dispatch draw to our children only if we are not currently running
        // the animation for simultaneously dimming the scroll wheel and
        // showing in the buttons. This class takes advantage of the View
        // implementation of fading edges effect to draw the selector wheel.
        // However, in View.draw(), the fading is applied after all the children
        // have been drawn and we do not want this fading to be applied to the
        // buttons. Therefore, we draw our children after we have completed
        // drawing ourselves.
        super.draw(canvas);

        // Draw our children if we are not showing the selector wheel of fading
        // it out
        if (mShowInputControlsAnimator.isRunning()
                || mSelectorWheelState != SELECTOR_WHEEL_STATE_LARGE) {
            long drawTime = getDrawingTime();
            for (int i = 0, count = getChildCount(); i < count; i++) {
                View child = getChildAt(i);
                if (!child.isShown()) {
                    continue;
                }
                drawChild(canvas, getChildAt(i), drawTime);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.210 -0500", hash_original_method = "73B10A324A4034D5CD70F03023B591F2", hash_generated_method = "2D131641DAB9F940D830B6D4414F155A")
    
@Override
    protected void onDraw(Canvas canvas) {
        if (mSelectorWheelState == SELECTOR_WHEEL_STATE_NONE) {
            return;
        }

        float x = (mRight - mLeft) / 2;
        float y = mCurrentScrollOffset;

        final int restoreCount = canvas.save();

        if (mSelectorWheelState == SELECTOR_WHEEL_STATE_SMALL) {
            Rect clipBounds = canvas.getClipBounds();
            clipBounds.inset(0, mSelectorElementHeight);
            canvas.clipRect(clipBounds);
        }

        // draw the selector wheel
        int[] selectorIndices = mSelectorIndices;
        for (int i = 0; i < selectorIndices.length; i++) {
            int selectorIndex = selectorIndices[i];
            String scrollSelectorValue = mSelectorIndexToStringCache.get(selectorIndex);
            // Do not draw the middle item if input is visible since the input is shown only
            // if the wheel is static and it covers the middle item. Otherwise, if the user
            // starts editing the text via the IME he may see a dimmed version of the old
            // value intermixed with the new one.
            if (i != SELECTOR_MIDDLE_ITEM_INDEX || mInputText.getVisibility() != VISIBLE) {
                canvas.drawText(scrollSelectorValue, x, y, mSelectorWheelPaint);
            }
            y += mSelectorElementHeight;
        }

        // draw the selection dividers (only if scrolling and drawable specified)
        if (mSelectionDivider != null) {
            // draw the top divider
            int topOfTopDivider =
                (getHeight() - mSelectorElementHeight - mSelectionDividerHeight) / 2;
            int bottomOfTopDivider = topOfTopDivider + mSelectionDividerHeight;
            mSelectionDivider.setBounds(0, topOfTopDivider, mRight, bottomOfTopDivider);
            mSelectionDivider.draw(canvas);

            // draw the bottom divider
            int topOfBottomDivider =  topOfTopDivider + mSelectorElementHeight;
            int bottomOfBottomDivider = bottomOfTopDivider + mSelectorElementHeight;
            mSelectionDivider.setBounds(0, topOfBottomDivider, mRight, bottomOfBottomDivider);
            mSelectionDivider.draw(canvas);
        }

        canvas.restoreToCount(restoreCount);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.212 -0500", hash_original_method = "F557CD251A66C23831BE55ECFE0FD6EB", hash_generated_method = "86AF7DE9D8AA4CE0BCD92B937FAAB36A")
    
@Override
    public void sendAccessibilityEvent(int eventType) {
        // Do not send accessibility events - we want the user to
        // perceive this widget as several controls rather as a whole.
    }

    /**
     * Makes a measure spec that tries greedily to use the max value.
     *
     * @param measureSpec The measure spec.
     * @param maxSize The max value for the size.
     * @return A measure spec greedily imposing the max size.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.215 -0500", hash_original_method = "568475CB75488DB4FFB4140594C385EC", hash_generated_method = "216DAD61FEE52E3B355028375A2F946B")
    
private int makeMeasureSpec(int measureSpec, int maxSize) {
        if (maxSize == SIZE_UNSPECIFIED) {
            return measureSpec;
        }
        final int size = MeasureSpec.getSize(measureSpec);
        final int mode = MeasureSpec.getMode(measureSpec);
        switch (mode) {
            case MeasureSpec.EXACTLY:
                return measureSpec;
            case MeasureSpec.AT_MOST:
                return MeasureSpec.makeMeasureSpec(Math.min(size, maxSize), MeasureSpec.EXACTLY);
            case MeasureSpec.UNSPECIFIED:
                return MeasureSpec.makeMeasureSpec(maxSize, MeasureSpec.EXACTLY);
            default:
                throw new IllegalArgumentException("Unknown measure mode: " + mode);
        }
    }

    /**
     * Utility to reconcile a desired size and state, with constraints imposed by
     * a MeasureSpec. Tries to respect the min size, unless a different size is
     * imposed by the constraints.
     *
     * @param minSize The minimal desired size.
     * @param measuredSize The currently measured size.
     * @param measureSpec The current measure spec.
     * @return The resolved size and state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.217 -0500", hash_original_method = "AB452915EDDF000AB380F75E12970FED", hash_generated_method = "8DF8A58681F962B5FE74ABD8C90CB727")
    
private int resolveSizeAndStateRespectingMinSize(int minSize, int measuredSize,
            int measureSpec) {
        if (minSize != SIZE_UNSPECIFIED) {
            final int desiredWidth = Math.max(minSize, measuredSize);
            return resolveSizeAndState(desiredWidth, measureSpec, 0);
        } else {
            return measuredSize;
        }
    }

    /**
     * Resets the selector indices and clear the cached
     * string representation of these indices.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.219 -0500", hash_original_method = "73F5524AAE1282E1B063C4C90806C754", hash_generated_method = "2D6824F7627E95305851D5D07F5F3A62")
    
private void initializeSelectorWheelIndices() {
        mSelectorIndexToStringCache.clear();
        int[] selectorIdices = mSelectorIndices;
        int current = getValue();
        for (int i = 0; i < mSelectorIndices.length; i++) {
            int selectorIndex = current + (i - SELECTOR_MIDDLE_ITEM_INDEX);
            if (mWrapSelectorWheel) {
                selectorIndex = getWrappedSelectorIndex(selectorIndex);
            }
            mSelectorIndices[i] = selectorIndex;
            ensureCachedScrollSelectorValue(mSelectorIndices[i]);
        }
    }

    /**
     * Sets the current value of this NumberPicker, and sets mPrevious to the
     * previous value. If current is greater than mEnd less than mStart, the
     * value of mCurrent is wrapped around. Subclasses can override this to
     * change the wrapping behavior
     *
     * @param current the new value of the NumberPicker
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.221 -0500", hash_original_method = "555F719FBCCD8AB4B94C9C107DB6A73F", hash_generated_method = "D1CF531B8F05A233FE437AD3ECF40DC4")
    
private void changeCurrent(int current) {
        if (mValue == current) {
            return;
        }
        // Wrap around the values if we go past the start or end
        if (mWrapSelectorWheel) {
            current = getWrappedSelectorIndex(current);
        }
        int previous = mValue;
        setValue(current);
        notifyChange(previous, current);
    }

    /**
     * Changes the current value by one which is increment or
     * decrement based on the passes argument.
     *
     * @param increment True to increment, false to decrement.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.225 -0500", hash_original_method = "E6026B71E66A86671A33BB22E5856635", hash_generated_method = "C3F83C681407CFAC4C990F7EB818E9DF")
    
private void changeCurrentByOne(boolean increment) {
        if (mFlingable) {
            mDimSelectorWheelAnimator.cancel();
            mInputText.setVisibility(View.INVISIBLE);
            mSelectorWheelPaint.setAlpha(SELECTOR_WHEEL_BRIGHT_ALPHA);
            mPreviousScrollerY = 0;
            forceCompleteChangeCurrentByOneViaScroll();
            if (increment) {
                mFlingScroller.startScroll(0, 0, 0, -mSelectorElementHeight,
                        CHANGE_CURRENT_BY_ONE_SCROLL_DURATION);
            } else {
                mFlingScroller.startScroll(0, 0, 0, mSelectorElementHeight,
                        CHANGE_CURRENT_BY_ONE_SCROLL_DURATION);
            }
            invalidate();
        } else {
            if (increment) {
                changeCurrent(mValue + 1);
            } else {
                changeCurrent(mValue - 1);
            }
        }
    }

    /**
     * Ensures that if we are in the process of changing the current value
     * by one via scrolling the scroller gets to its final state and the
     * value is updated.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.227 -0500", hash_original_method = "175AF73F53EDEE092962AA03BDCBD819", hash_generated_method = "E651BDCEC06D2A45AD6F8FCC0A3C3D28")
    
private void forceCompleteChangeCurrentByOneViaScroll() {
        Scroller scroller = mFlingScroller;
        if (!scroller.isFinished()) {
            final int yBeforeAbort = scroller.getCurrY();
            scroller.abortAnimation();
            final int yDelta = scroller.getCurrY() - yBeforeAbort;
            scrollBy(0, yDelta);
        }
    }

    /**
     * Sets the <code>alpha</code> of the {@link Paint} for drawing the selector
     * wheel.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.229 -0500", hash_original_method = "E601C50DC508DF2554B27F10B4080C00", hash_generated_method = "717507DB22BB1B0783342D218FA56C38")
    
@SuppressWarnings("unused")
    // Called via reflection
    private void setSelectorPaintAlpha(int alpha) {
        mSelectorWheelPaint.setAlpha(alpha);
        invalidate();
    }

    /**
     * @return If the <code>event</code> is in the visible <code>view</code>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.231 -0500", hash_original_method = "400782BE1118D85D04FD2365A968D2CF", hash_generated_method = "9C080FEBF439B1BB0C31C38FAAE88249")
    
private boolean isEventInVisibleViewHitRect(MotionEvent event, View view) {
        if (view.getVisibility() == VISIBLE) {
            view.getHitRect(mTempRect);
            return mTempRect.contains((int) event.getX(), (int) event.getY());
        }
        return false;
    }

    /**
     * Sets the <code>selectorWheelState</code>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.233 -0500", hash_original_method = "BF95E4EC078F38B02D5C875137382733", hash_generated_method = "6C596304D937E56671D0C911C8AC893F")
    
private void setSelectorWheelState(int selectorWheelState) {
        mSelectorWheelState = selectorWheelState;
        if (selectorWheelState == SELECTOR_WHEEL_STATE_LARGE) {
            mSelectorWheelPaint.setAlpha(SELECTOR_WHEEL_BRIGHT_ALPHA);
        }

        if (mFlingable && selectorWheelState == SELECTOR_WHEEL_STATE_LARGE
                && AccessibilityManager.getInstance(mContext).isEnabled()) {
            AccessibilityManager.getInstance(mContext).interrupt();
            String text = mContext.getString(R.string.number_picker_increment_scroll_action);
            mInputText.setContentDescription(text);
            mInputText.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
            mInputText.setContentDescription(null);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.236 -0500", hash_original_method = "77AB1B93BD5012BE4D83745B76853590", hash_generated_method = "88B516A42B4434E9C688448C15FE6C31")
    
private void initializeSelectorWheel() {
        initializeSelectorWheelIndices();
        int[] selectorIndices = mSelectorIndices;
        int totalTextHeight = selectorIndices.length * mTextSize;
        float totalTextGapHeight = (mBottom - mTop) - totalTextHeight;
        float textGapCount = selectorIndices.length - 1;
        mSelectorTextGapHeight = (int) (totalTextGapHeight / textGapCount + 0.5f);
        mSelectorElementHeight = mTextSize + mSelectorTextGapHeight;
        // Ensure that the middle item is positioned the same as the text in mInputText
        int editTextTextPosition = mInputText.getBaseline() + mInputText.getTop();
        mInitialScrollOffset = editTextTextPosition -
                (mSelectorElementHeight * SELECTOR_MIDDLE_ITEM_INDEX);
        mCurrentScrollOffset = mInitialScrollOffset;
        updateInputTextView();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.238 -0500", hash_original_method = "C54C7499288517561E53B381ADACF410", hash_generated_method = "FCE25FB6013E43E5476F2C360899602A")
    
private void initializeFadingEdges() {
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength((mBottom - mTop - mTextSize) / 2);
    }
    
    class InputTextFilter extends NumberKeyListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.561 -0400", hash_original_method = "10D9049FFA6F11A4560862F2A7A49039", hash_generated_method = "10D9049FFA6F11A4560862F2A7A49039")
        public InputTextFilter ()
        {
            //Synthesized constructor
        }

        // XXX This doesn't allow for range limits when controlled by a
        // soft input method!
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.288 -0500", hash_original_method = "5619839AC48FF521F5D3DA01ED2E4A22", hash_generated_method = "940AAB34C11FCB7F502A92348EEE42B0")
        
public int getInputType() {
            return InputType.TYPE_CLASS_TEXT;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.290 -0500", hash_original_method = "42F7B3A0BEAF29BB6B3A7A3A6D3C7695", hash_generated_method = "E4A04209D0F261E6F67F991F41CD7354")
        
@Override
        protected char[] getAcceptedChars() {
            return DIGIT_CHARACTERS;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.293 -0500", hash_original_method = "74A3271C967FA5A66FEC87FCC33CF2BB", hash_generated_method = "011AC927278FCEF42E7A54570093A43D")
        
@Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest,
                int dstart, int dend) {
            if (mDisplayedValues == null) {
                CharSequence filtered = super.filter(source, start, end, dest, dstart, dend);
                if (filtered == null) {
                    filtered = source.subSequence(start, end);
                }

                String result = String.valueOf(dest.subSequence(0, dstart)) + filtered
                        + dest.subSequence(dend, dest.length());

                if ("".equals(result)) {
                    return result;
                }
                int val = getSelectedPos(result);

                /*
                 * Ensure the user can't type in a value greater than the max
                 * allowed. We have to allow less than min as the user might
                 * want to delete some numbers and then type a new number.
                 */
                if (val > mMaxValue) {
                    return "";
                } else {
                    return filtered;
                }
            } else {
                CharSequence filtered = String.valueOf(source.subSequence(start, end));
                if (TextUtils.isEmpty(filtered)) {
                    return "";
                }
                String result = String.valueOf(dest.subSequence(0, dstart)) + filtered
                        + dest.subSequence(dend, dest.length());
                String str = String.valueOf(result).toLowerCase();
                for (String val : mDisplayedValues) {
                    String valLowerCase = val.toLowerCase();
                    if (valLowerCase.startsWith(str)) {
                        postSetSelectionCommand(result.length(), val.length());
                        return val.subSequence(dstart, val.length());
                    }
                }
                return "";
            }
        }
        
    }
    
    class SetSelectionCommand implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.298 -0500", hash_original_field = "690988B4898F88F06C3BC5A9EDD0C189", hash_generated_field = "F02C1BE48395D503EBA5C8443CFA9BF4")

        private int mSelectionStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.301 -0500", hash_original_field = "8317BA26C0ECC48C376AB95A0520113E", hash_generated_field = "C8C5CBC35C679AC5A64E276363F892A9")

        private int mSelectionEnd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.564 -0400", hash_original_method = "8A1B763782C13D7A531CCCB7905DBC5E", hash_generated_method = "8A1B763782C13D7A531CCCB7905DBC5E")
        public SetSelectionCommand ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.303 -0500", hash_original_method = "5A9CF76A42C671BAE659DDDD324A19D9", hash_generated_method = "6374F0A5C12322A383EFB0D4502A4F6C")
        
public void run() {
            mInputText.setSelection(mSelectionStart, mSelectionEnd);
        }
        
    }
    
    class AdjustScrollerCommand implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.564 -0400", hash_original_method = "04A50735AF7565EFEB09DB8389B3EF59", hash_generated_method = "04A50735AF7565EFEB09DB8389B3EF59")
        public AdjustScrollerCommand ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.307 -0500", hash_original_method = "1728A296542E5FB10F5D2F850E617FE1", hash_generated_method = "E36429D890BD907AF232694419F86473")
        
public void run() {
            mPreviousScrollerY = 0;
            if (mInitialScrollOffset == mCurrentScrollOffset) {
                updateInputTextView();
                showInputControls(mShowInputControlsAnimimationDuration);
                return;
            }
            // adjust to the closest value
            int deltaY = mInitialScrollOffset - mCurrentScrollOffset;
            if (Math.abs(deltaY) > mSelectorElementHeight / 2) {
                deltaY += (deltaY > 0) ? -mSelectorElementHeight : mSelectorElementHeight;
            }
            mAdjustScroller.startScroll(0, 0, 0, deltaY, SELECTOR_ADJUSTMENT_DURATION_MILLIS);
            invalidate();
        }
        
    }
    
    class ChangeCurrentByOneFromLongPressCommand implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.311 -0500", hash_original_field = "FE89541634657061438129675F17A777", hash_generated_field = "729B17CE9B5C6450F7852DCD6B7829FA")

        private boolean mIncrement;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.565 -0400", hash_original_method = "A263DA149B2C322986CF6F1865703F44", hash_generated_method = "A263DA149B2C322986CF6F1865703F44")
        public ChangeCurrentByOneFromLongPressCommand ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.313 -0500", hash_original_method = "ED1739B7A0ACAE655C07ED8C0ABABF1C", hash_generated_method = "60226B96453F3EBB99279CE7A2393774")
        
private void setIncrement(boolean increment) {
            mIncrement = increment;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.316 -0500", hash_original_method = "1F108533BE53D637572F8F49778F205C", hash_generated_method = "3CD8638FBE78AC2FBC4F0F5EC587B4C0")
        
public void run() {
            changeCurrentByOne(mIncrement);
            postDelayed(this, mLongPressUpdateInterval);
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

    /**
     * Callback invoked upon completion of a given <code>scroller</code>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.241 -0500", hash_original_method = "424BD543DA2123CE0E799CAFA377A1E0", hash_generated_method = "D93C5FAB0743E26F818D269E540B4419")
    
private void onScrollerFinished(Scroller scroller) {
        if (scroller == mFlingScroller) {
            if (mSelectorWheelState == SELECTOR_WHEEL_STATE_LARGE) {
                postAdjustScrollerCommand(0);
                onScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
            } else {
                updateInputTextView();
                fadeSelectorWheel(mShowInputControlsAnimimationDuration);
            }
        } else {
            updateInputTextView();
            showInputControls(mShowInputControlsAnimimationDuration);
        }
    }

    /**
     * Handles transition to a given <code>scrollState</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.243 -0500", hash_original_method = "76A35782DE0E02AA234AC6648796EFD6", hash_generated_method = "44E51D9474FA55E9336060E5B8D24A85")
    
private void onScrollStateChange(int scrollState) {
        if (mScrollState == scrollState) {
            return;
        }
        mScrollState = scrollState;
        if (mOnScrollListener != null) {
            mOnScrollListener.onScrollStateChange(this, scrollState);
        }
    }

    /**
     * Flings the selector with the given <code>velocityY</code>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.245 -0500", hash_original_method = "089FFF3145B83D850B8641EBACA81A89", hash_generated_method = "73E70E76BE4DB0CCF2E8521E1FFFDB0D")
    
private void fling(int velocityY) {
        mPreviousScrollerY = 0;

        if (velocityY > 0) {
            mFlingScroller.fling(0, 0, 0, velocityY, 0, 0, 0, Integer.MAX_VALUE);
        } else {
            mFlingScroller.fling(0, Integer.MAX_VALUE, 0, velocityY, 0, 0, 0, Integer.MAX_VALUE);
        }

        invalidate();
    }

    /**
     * Hides the input controls which is the up/down arrows and the text field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.247 -0500", hash_original_method = "84887968F9B86CB6F225BC4761B2C961", hash_generated_method = "002434C5AE93ADC3AD7D450D7127F1D8")
    
private void hideInputControls() {
        mShowInputControlsAnimator.cancel();
        mIncrementButton.setVisibility(INVISIBLE);
        mDecrementButton.setVisibility(INVISIBLE);
        mInputText.setVisibility(INVISIBLE);
    }

    /**
     * Show the input controls by making them visible and animating the alpha
     * property up/down arrows.
     *
     * @param animationDuration The duration of the animation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.250 -0500", hash_original_method = "568B02CE0458B050F29128E328730206", hash_generated_method = "6ACB3979C684EA12B0D020A6DC2DED66")
    
private void showInputControls(long animationDuration) {
        updateIncrementAndDecrementButtonsVisibilityState();
        mInputText.setVisibility(VISIBLE);
        mShowInputControlsAnimator.setDuration(animationDuration);
        mShowInputControlsAnimator.start();
    }

    /**
     * Fade the selector wheel via an animation.
     *
     * @param animationDuration The duration of the animation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.252 -0500", hash_original_method = "04EF8175CF934E94876E7611B3BFDBC2", hash_generated_method = "FBC95C514DED32164CF0B1DE81798153")
    
private void fadeSelectorWheel(long animationDuration) {
        mInputText.setVisibility(VISIBLE);
        mDimSelectorWheelAnimator.setDuration(animationDuration);
        mDimSelectorWheelAnimator.start();
    }

    /**
     * Updates the visibility state of the increment and decrement buttons.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.254 -0500", hash_original_method = "F06555D042A3011B2943A92CA9FE7B6C", hash_generated_method = "9A29321407F4F80183901540F077242A")
    
private void updateIncrementAndDecrementButtonsVisibilityState() {
        if (mWrapSelectorWheel || mValue < mMaxValue) {
            mIncrementButton.setVisibility(VISIBLE);
        } else {
            mIncrementButton.setVisibility(INVISIBLE);
        }
        if (mWrapSelectorWheel || mValue > mMinValue) {
            mDecrementButton.setVisibility(VISIBLE);
        } else {
            mDecrementButton.setVisibility(INVISIBLE);
        }
    }

    /**
     * @return The wrapped index <code>selectorIndex</code> value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.256 -0500", hash_original_method = "98EC96D2E9172670F87F406C69617E1C", hash_generated_method = "666DA4DB2A89D0AD3EDFA390E02A136A")
    
private int getWrappedSelectorIndex(int selectorIndex) {
        if (selectorIndex > mMaxValue) {
            return mMinValue + (selectorIndex - mMaxValue) % (mMaxValue - mMinValue) - 1;
        } else if (selectorIndex < mMinValue) {
            return mMaxValue - (mMinValue - selectorIndex) % (mMaxValue - mMinValue) + 1;
        }
        return selectorIndex;
    }

    /**
     * Increments the <code>selectorIndices</code> whose string representations
     * will be displayed in the selector.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.259 -0500", hash_original_method = "76B5F467E3A3E0B55117DFD0AE112AD7", hash_generated_method = "7D0CA5F8084537AD3E051496F7FABECE")
    
private void incrementSelectorIndices(int[] selectorIndices) {
        for (int i = 0; i < selectorIndices.length - 1; i++) {
            selectorIndices[i] = selectorIndices[i + 1];
        }
        int nextScrollSelectorIndex = selectorIndices[selectorIndices.length - 2] + 1;
        if (mWrapSelectorWheel && nextScrollSelectorIndex > mMaxValue) {
            nextScrollSelectorIndex = mMinValue;
        }
        selectorIndices[selectorIndices.length - 1] = nextScrollSelectorIndex;
        ensureCachedScrollSelectorValue(nextScrollSelectorIndex);
    }

    /**
     * Decrements the <code>selectorIndices</code> whose string representations
     * will be displayed in the selector.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.261 -0500", hash_original_method = "3BAE7243B627F51EC3CF3C9DBFE60CD6", hash_generated_method = "78C6135CA4817AACEB7BD5908CC93CB3")
    
private void decrementSelectorIndices(int[] selectorIndices) {
        for (int i = selectorIndices.length - 1; i > 0; i--) {
            selectorIndices[i] = selectorIndices[i - 1];
        }
        int nextScrollSelectorIndex = selectorIndices[1] - 1;
        if (mWrapSelectorWheel && nextScrollSelectorIndex < mMinValue) {
            nextScrollSelectorIndex = mMaxValue;
        }
        selectorIndices[0] = nextScrollSelectorIndex;
        ensureCachedScrollSelectorValue(nextScrollSelectorIndex);
    }

    /**
     * Ensures we have a cached string representation of the given <code>
     * selectorIndex</code>
     * to avoid multiple instantiations of the same string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.264 -0500", hash_original_method = "5C7213EC7C24F2EA6A4CE0C3E4F76F00", hash_generated_method = "70060A54A4195C787C609FBC90086ECB")
    
private void ensureCachedScrollSelectorValue(int selectorIndex) {
        SparseArray<String> cache = mSelectorIndexToStringCache;
        String scrollSelectorValue = cache.get(selectorIndex);
        if (scrollSelectorValue != null) {
            return;
        }
        if (selectorIndex < mMinValue || selectorIndex > mMaxValue) {
            scrollSelectorValue = "";
        } else {
            if (mDisplayedValues != null) {
                int displayedValueIndex = selectorIndex - mMinValue;
                scrollSelectorValue = mDisplayedValues[displayedValueIndex];
            } else {
                scrollSelectorValue = formatNumber(selectorIndex);
            }
        }
        cache.put(selectorIndex, scrollSelectorValue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.266 -0500", hash_original_method = "CED5CD69155B2474785611FEBB1C2BE4", hash_generated_method = "84C8BFA55CA3ABEDD80A88E89DBFE714")
    
private String formatNumber(int value) {
        return (mFormatter != null) ? mFormatter.format(value) : String.valueOf(value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.269 -0500", hash_original_method = "9B2E73D457CEF5FA8F9D91E45C672313", hash_generated_method = "E35F10BA2127EF9CA0FE899B552773C6")
    
private void validateInputTextView(View v) {
        String str = String.valueOf(((TextView) v).getText());
        if (TextUtils.isEmpty(str)) {
            // Restore to the old value as we don't allow empty values
            updateInputTextView();
        } else {
            // Check the new value and ensure it's in range
            int current = getSelectedPos(str.toString());
            changeCurrent(current);
        }
    }

    /**
     * Updates the view of this NumberPicker. If displayValues were specified in
     * the string corresponding to the index specified by the current value will
     * be returned. Otherwise, the formatter specified in {@link #setFormatter}
     * will be used to format the number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.271 -0500", hash_original_method = "B42CFCB10E8E291BCAC25CBB8DE3CDCA", hash_generated_method = "2E6679590DD3C54FA7CF9AB9AE7C8399")
    
private void updateInputTextView() {
        /*
         * If we don't have displayed values then use the current number else
         * find the correct value in the displayed values for the current
         * number.
         */
        if (mDisplayedValues == null) {
            mInputText.setText(formatNumber(mValue));
        } else {
            mInputText.setText(mDisplayedValues[mValue - mMinValue]);
        }
        mInputText.setSelection(mInputText.getText().length());

        if (mFlingable && AccessibilityManager.getInstance(mContext).isEnabled()) {
            String text = mContext.getString(R.string.number_picker_increment_scroll_mode,
                    mInputText.getText());
            mInputText.setContentDescription(text);
        }
    }

    /**
     * Notifies the listener, if registered, of a change of the value of this
     * NumberPicker.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.273 -0500", hash_original_method = "EE3C020B4BB89830916EAF8B846EA64D", hash_generated_method = "8EA1CBD760E208F77E7736ADF7E43FE7")
    
private void notifyChange(int previous, int current) {
        if (mOnValueChangeListener != null) {
            mOnValueChangeListener.onValueChange(this, previous, mValue);
        }
    }

    /**
     * Posts a command for changing the current value by one.
     *
     * @param increment Whether to increment or decrement the value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.275 -0500", hash_original_method = "89117A76C28F4F0E670F85E62CCFCD15", hash_generated_method = "4E1C9E88E57F751C62014BE7BAE8CC6C")
    
private void postChangeCurrentByOneFromLongPress(boolean increment) {
        mInputText.clearFocus();
        removeAllCallbacks();
        if (mChangeCurrentByOneFromLongPressCommand == null) {
            mChangeCurrentByOneFromLongPressCommand = new ChangeCurrentByOneFromLongPressCommand();
        }
        mChangeCurrentByOneFromLongPressCommand.setIncrement(increment);
        post(mChangeCurrentByOneFromLongPressCommand);
    }

    /**
     * Removes all pending callback from the message queue.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.277 -0500", hash_original_method = "2F67DA682EF8D26EE412EBB702FD21A7", hash_generated_method = "421387073CC5F80F0C7B0E936EF851FA")
    
private void removeAllCallbacks() {
        if (mChangeCurrentByOneFromLongPressCommand != null) {
            removeCallbacks(mChangeCurrentByOneFromLongPressCommand);
        }
        if (mAdjustScrollerCommand != null) {
            removeCallbacks(mAdjustScrollerCommand);
        }
        if (mSetSelectionCommand != null) {
            removeCallbacks(mSetSelectionCommand);
        }
    }

    /**
     * @return The selected index given its displayed <code>value</code>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.280 -0500", hash_original_method = "C9822A8BF3CD293D75693533B44BD287", hash_generated_method = "18225D61C2D85C8D67D299A6C0C651F0")
    
private int getSelectedPos(String value) {
        if (mDisplayedValues == null) {
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                // Ignore as if it's not a number we don't care
            }
        } else {
            for (int i = 0; i < mDisplayedValues.length; i++) {
                // Don't force the user to type in jan when ja will do
                value = value.toLowerCase();
                if (mDisplayedValues[i].toLowerCase().startsWith(value)) {
                    return mMinValue + i;
                }
            }

            /*
             * The user might have typed in a number into the month field i.e.
             * 10 instead of OCT so support that too.
             */
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {

                // Ignore as if it's not a number we don't care
            }
        }
        return mMinValue;
    }

    /**
     * Posts an {@link SetSelectionCommand} from the given <code>selectionStart
     * </code> to
     * <code>selectionEnd</code>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.282 -0500", hash_original_method = "B20C23507728532B22E954D2186CEEA6", hash_generated_method = "9916F386BB9D56B7DAC30F8952F9CF60")
    
private void postSetSelectionCommand(int selectionStart, int selectionEnd) {
        if (mSetSelectionCommand == null) {
            mSetSelectionCommand = new SetSelectionCommand();
        } else {
            removeCallbacks(mSetSelectionCommand);
        }
        mSetSelectionCommand.mSelectionStart = selectionStart;
        mSetSelectionCommand.mSelectionEnd = selectionEnd;
        post(mSetSelectionCommand);
    }

    /**
     * Posts an {@link AdjustScrollerCommand} within the given <code>
     * delayMillis</code>
     * .
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:35.284 -0500", hash_original_method = "54DD268EE848B5EAB62BAC6791547633", hash_generated_method = "CAFA0BF4E05118E14BAEE921C9D4DBF6")
    
private void postAdjustScrollerCommand(int delayMillis) {
        if (mAdjustScrollerCommand == null) {
            mAdjustScrollerCommand = new AdjustScrollerCommand();
        } else {
            removeCallbacks(mAdjustScrollerCommand);
        }
        postDelayed(mAdjustScrollerCommand, delayMillis);
    }
}

