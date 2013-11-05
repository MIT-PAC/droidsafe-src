package android.widget;

// Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.helpers.*;
import droidsafe.runtime.*;
import com.android.internal.R;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.CompatibilityInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.ExtractEditText;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.BoringLayout;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.GetChars;
import android.text.GraphicsOperations;
import android.text.InputFilter;
import android.text.InputType;
import android.text.Layout;
import android.text.ParcelableSpan;
import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.text.method.AllCapsTransformationMethod;
import android.text.method.ArrowKeyMovementMethod;
import android.text.method.DateKeyListener;
import android.text.method.DateTimeKeyListener;
import android.text.method.DialerKeyListener;
import android.text.method.DigitsKeyListener;
import android.text.method.KeyListener;
import android.text.method.LinkMovementMethod;
import android.text.method.MetaKeyKeyListener;
import android.text.method.MovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TextKeyListener;
import android.text.method.TimeKeyListener;
import android.text.method.TransformationMethod;
import android.text.method.TransformationMethod2;
import android.text.method.WordIterator;
import android.text.style.ClickableSpan;
import android.text.style.EasyEditSpan;
import android.text.style.ParagraphStyle;
import android.text.style.SpellCheckSpan;
import android.text.style.SuggestionRangeSpan;
import android.text.style.SuggestionSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.URLSpan;
import android.text.style.UpdateAppearance;
import android.text.util.Linkify;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.HapticFeedbackConstants;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewRootImpl;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.SpellCheckerSubtype;
import android.view.textservice.TextServicesManager;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RemoteViews.RemoteView;

import com.android.internal.util.FastMath;
import com.android.internal.widget.EditableInputConnection;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;

public class TextView extends View implements ViewTreeObserver.OnPreDrawListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.440 -0400", hash_original_field = "5C9E3264119E57696644BE19B3FE1DAC", hash_generated_field = "695EE05B4D22A341938A08B09254F27D")

    private int mCurrentAlpha = 255;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.441 -0400", hash_original_field = "5F09FBDC9860691A5956F34FA173E62B", hash_generated_field = "BAE1383AB87BD7B338A209B29BBF86C2")

    final int[] mTempCoords = new int[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.441 -0400", hash_original_field = "B856E02779DE10EA84221FCD1182A1A3", hash_generated_field = "9F1BD97088B2257F3EF12D8B258FBB69")

    Rect mTempRect;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.441 -0400", hash_original_field = "D617392BE941E0902ECF95DB04F038E8", hash_generated_field = "F28951B95CC06B6EA971BC050BE7DE22")

    private ColorStateList mTextColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.441 -0400", hash_original_field = "284F9A87F549A6DC680E2D58A116EBA3", hash_generated_field = "DDC7D6F23AA3E68217EEBC390EBBF804")

    private int mCurTextColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.441 -0400", hash_original_field = "F97B29F3780CA1FC4E9BEA1ABC67D847", hash_generated_field = "9F10F4704A7B04F2C4871DD09D608BF0")

    private ColorStateList mHintTextColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.441 -0400", hash_original_field = "68148E7850655C81DB19FCC253D99F98", hash_generated_field = "AE6720DC2457713C725D4C56460C9DC2")

    private ColorStateList mLinkTextColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.441 -0400", hash_original_field = "CFE453DD74E7FC90BED21ABE94CDF43F", hash_generated_field = "5A275158889F26A8351A14A4F8F0D9DD")

    private int mCurHintTextColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.441 -0400", hash_original_field = "BAD96035AC86533B7D8C4EAA84835DC4", hash_generated_field = "8D828812FF76F4DB76DB63A2398AF5C6")

    private boolean mFreezesText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.441 -0400", hash_original_field = "201B24234F3C5EAB7B9E6C89937009ED", hash_generated_field = "DC2B1736EBA532012F131A593130D38C")

    private boolean mFrozenWithFocus;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.441 -0400", hash_original_field = "7A52CFFAF3A3D05848839CC4A3DCBF66", hash_generated_field = "C16E2255547619A01263AC9BE7B2E134")

    private boolean mTemporaryDetach;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.441 -0400", hash_original_field = "F42B4922CBBBAC0A00222DB39CFC509A", hash_generated_field = "5C6A9DB416A74CA58302EC973E49E0E3")

    private boolean mDispatchTemporaryDetach;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.441 -0400", hash_original_field = "4A82A355E70C4C4283892E1CED60A9AB", hash_generated_field = "9EDEB4E5741E85F20A0B3026682B4863")

    private boolean mDiscardNextActionUp = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.441 -0400", hash_original_field = "9074015FCBB83111EEFF764D36799E0A", hash_generated_field = "7878E8941BAE988F39F461EEC8B7CCDF")

    private boolean mIgnoreActionUpEvent = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.441 -0400", hash_original_field = "737580135BF67E97C636411ED2235180", hash_generated_field = "6D10B174FA8E858FA02AA86D85663AD4")

    private Editable.Factory mEditableFactory = Editable.Factory.getInstance();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.441 -0400", hash_original_field = "289A806C8E357E566D214939426916BE", hash_generated_field = "10200E22D9B91A38418945F375917DF5")

    private Spannable.Factory mSpannableFactory = Spannable.Factory.getInstance();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.441 -0400", hash_original_field = "0021C70065C1D0F5DA3DE4086470A1AC", hash_generated_field = "E95B50404D53A741F5CBE2BA4A3E9431")

    private float mShadowRadius;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.441 -0400", hash_original_field = "C882880E2E13EA27F677D50AEA4C2D30", hash_generated_field = "CC57606479233D9D93ED0B57219ED7CE")

    private float mShadowDx;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.441 -0400", hash_original_field = "F6C0DA7C4DD70FAC183A5D5D940CBEBF", hash_generated_field = "5A526AAA72A41CBD334BF1D9A433DD2D")

    private float mShadowDy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.441 -0400", hash_original_field = "7302E8BC04F6DCBBC91913A350368A28", hash_generated_field = "A64E4C65A01F6E2CFC767B574B9B2B25")

    private int mPreDrawState = PREDRAW_NOT_REGISTERED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.442 -0400", hash_original_field = "069F6473CFDC9651640842904E9A1296", hash_generated_field = "4984AF4C2DB23A63F16A5A1F70DBBE23")

    private TextUtils.TruncateAt mEllipsize = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.442 -0400", hash_original_field = "1891CBC78C734C6A7EBB0D921FFE84B0", hash_generated_field = "DA26917F8EABBE7FB6675DEEA4CDD42F")

    private Drawables mDrawables;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.442 -0400", hash_original_field = "6F8A455C94CBB7A00E920835C0C8964C", hash_generated_field = "8B5DD3B1B3DD08B759F16C26A18B23CA")

    private CharSequence mError;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.442 -0400", hash_original_field = "AF2B7FEC596D9156D61CB482234E01CC", hash_generated_field = "EA3CC19FBACB277B4E0CFF08BB94E8C5")

    private boolean mErrorWasChanged;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.442 -0400", hash_original_field = "E863CEB96C01242A6262A422DC21BA91", hash_generated_field = "3D80774243FE973442F872DD04152DA0")

    private ErrorPopup mPopup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.442 -0400", hash_original_field = "5194879693A231FFFC209BB8D83F7343", hash_generated_field = "6846AAA470F19DD23ADF6122A2BA28EB")

    private boolean mShowErrorAfterAttach;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.442 -0400", hash_original_field = "F404BF7CA0765A26006895B16ECAFD6F", hash_generated_field = "ED2A81D0AA757272F61284C94F8CB304")

    private CharWrapper mCharWrapper = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.442 -0400", hash_original_field = "CD0B182A36A51B8060A5E676C89B9336", hash_generated_field = "89CF3363829B7F18DD131036DE4F0A1D")

    private boolean mSelectionMoved = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.442 -0400", hash_original_field = "2E9AC3E359ECE072850F1292DFBBDAE1", hash_generated_field = "B3FE9FD9576C4C98F6C4A561DFC39377")

    private boolean mTouchFocusSelected = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.442 -0400", hash_original_field = "E87C3F5C2A7CB77C6DC56288528EBF20", hash_generated_field = "E6A1FEE90A4433FD8B74A8F47A5E0E13")

    private Marquee mMarquee;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.442 -0400", hash_original_field = "533339E6FBD11F3E45A14F8C0EF95135", hash_generated_field = "E1D72A00A2DFF52C1CB7FA697FBC9898")

    private boolean mRestartMarquee;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.442 -0400", hash_original_field = "AE8C8553F79BDDDB297AFF9496B70AF4", hash_generated_field = "A706E5A4CE970BDC6898B0827FF2B8CB")

    private int mMarqueeRepeatLimit = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.442 -0400", hash_original_field = "2E491392BA918DD2D8A686099734FFCA", hash_generated_field = "E1403D58E8CC04D062F12EDE2F93FC48")

    InputContentType mInputContentType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.442 -0400", hash_original_field = "CAE876BD1DF758FC0DA52C899F537A65", hash_generated_field = "23BEF75E7D0F22ED753350F2B8C53A97")

    InputMethodState mInputMethodState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.442 -0400", hash_original_field = "B36145192741179BFC019A94217ED239", hash_generated_field = "29065B52E0E09EECA006A7A5A8F78524")

    private int mTextSelectHandleLeftRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.442 -0400", hash_original_field = "14F0D0E28BFB85ADAF9CBB2462BD60AC", hash_generated_field = "9FC61DEFB614916CB19F9F18AE4BBCF8")

    private int mTextSelectHandleRightRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.442 -0400", hash_original_field = "AECC1EE6EF517B4633C961D68D0A0721", hash_generated_field = "3CAFBFF7DAB243B3E8841417BD521E3B")

    private int mTextSelectHandleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.442 -0400", hash_original_field = "F1F871F8469791F3048EECEE2DDAE51A", hash_generated_field = "899920185C4484CA31C0F443B855010D")

    private int mTextEditSuggestionItemLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.442 -0400", hash_original_field = "7B7F1DB21F46A09A666E491035DEE1ED", hash_generated_field = "EE9100393A7AA7FB8D758BBE48AF5F35")

    private SuggestionsPopupWindow mSuggestionsPopupWindow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.443 -0400", hash_original_field = "B2BAA47BFF891CBC7774865E53B1B27D", hash_generated_field = "84F489ACE61EF8AEAEC12B2F2593297C")

    private SuggestionRangeSpan mSuggestionRangeSpan;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.443 -0400", hash_original_field = "F1CB45A993CF82C01E8B9DD86DF31C59", hash_generated_field = "02A74559D19DD086E571BE2B3AA83A8F")

    private int mCursorDrawableRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.443 -0400", hash_original_field = "9D532FDC5F3401D628291677F396D047", hash_generated_field = "E667A519A6080C5A572800DEC412B8A1")

    private final Drawable[] mCursorDrawable = new Drawable[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.443 -0400", hash_original_field = "45877EB65372EE0549FF6482C357C77C", hash_generated_field = "8657E501533B875D60AA97A414831DBD")

    private int mCursorCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.443 -0400", hash_original_field = "C68967AB1B9693AAC052C4158F7203F8", hash_generated_field = "72952B5254D373336CA0A7F293822C5C")

    private Drawable mSelectHandleLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.443 -0400", hash_original_field = "8DC2F2BCAE53DF5B1B45FBFA787F7CC7", hash_generated_field = "BE0700D1B06984983D5C63B2FD49DB15")

    private Drawable mSelectHandleRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.443 -0400", hash_original_field = "B0A089E200495488AE5D10A63801B499", hash_generated_field = "08AFAF21E471F629DFA4D8F58C03B94B")

    private Drawable mSelectHandleCenter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.443 -0400", hash_original_field = "DC2833E523C718C37F76D9CECDB613DC", hash_generated_field = "FB42528DAE75699ED1B6CC0A5A674A55")

    private PositionListener mPositionListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.443 -0400", hash_original_field = "43041C61A1DA9DC67B7FC8F5C22C953B", hash_generated_field = "40ACD97E99B995A7FCA41633B5D7F459")

    private float mLastDownPositionX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.443 -0400", hash_original_field = "5211DB32F771F4FB6B254B7227DAF0E4", hash_generated_field = "25FA8F6701B3D1C16B56B376BE78487E")

    private float mLastDownPositionY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.443 -0400", hash_original_field = "7F39B50ADACE58DDF3868451FDACBFC3", hash_generated_field = "4A2FD1B1A3BA8B998F40B2C0D929E44F")

    private Callback mCustomSelectionActionModeCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.443 -0400", hash_original_field = "9154AC84CF6CB434E6C44058845F83A6", hash_generated_field = "FE1D03D7C65C5CEC56D15F835C8E0A4C")

    private int mSquaredTouchSlopDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.443 -0400", hash_original_field = "5D2B1AB08FC4BB71F1E4E3942287F4AC", hash_generated_field = "301C10EAD74C8CF352F89DA817F09EF5")

    private boolean mCreatedWithASelection = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.443 -0400", hash_original_field = "435FE0944C142BE50AF524B687A36B73", hash_generated_field = "B64007D723854AD8DD3C03BCCA9834A5")

    private WordIterator mWordIterator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.443 -0400", hash_original_field = "651FF4D8C7C964F5DF1C680A515E9458", hash_generated_field = "D936161C5FDE3DD296D182C31C4ED500")

    private SpellChecker mSpellChecker;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.443 -0400", hash_original_field = "A9B899D11C5154E2959E6CD08A569B50", hash_generated_field = "9735B231E6C5186126230C7191CC2027")

    private boolean mSoftInputShownOnFocus = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.443 -0400", hash_original_field = "AE353DD0C65715072A815AA3EFBB914A", hash_generated_field = "AE17667AF244FFA2D2100AF02F19092F")

    private Layout.Alignment mLayoutAlignment;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.443 -0400", hash_original_field = "C13638B20608314DC4A1841631D399DA", hash_generated_field = "B8FF70A86AC51485598DFBCFFB37720F")

    private TextAlign mTextAlign = TextAlign.INHERIT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.444 -0400", hash_original_field = "B5E0024E63436049FABCB39FDCDB387F", hash_generated_field = "88A15E3715BB62052F2448ED895C9BBA")

    private boolean mResolvedDrawables = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.444 -0400", hash_original_field = "8EDC8B08CA53BD0E51A567DB27353463", hash_generated_field = "601913B8190553DCCF7F60EF06AC5711")

    private int mMarqueeFadeMode = MARQUEE_FADE_NORMAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.444 -0400", hash_original_field = "A88463CF8707DFCA9D81D838EE11C191", hash_generated_field = "2AD0F97487EA7D5F86DCAFC3259ED37F")

    private Layout mSavedMarqueeModeLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.444 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "6CF16E724237A2841199FB30284CED38")

    
    @ViewDebug.ExportedProperty(category = "text") 
    private CharSequence mText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.444 -0400", hash_original_field = "116BEBA84C265E44D657283E75BE60A1", hash_generated_field = "30221785C9497266E9C8ABBDFDCBE7EC")

    private CharSequence mTransformed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.444 -0400", hash_original_field = "5E344D0215B7C42F8F0B334676E4F343", hash_generated_field = "D0147D76A56855726ED38FF51B24F6FD")

    private BufferType mBufferType = BufferType.NORMAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.444 -0400", hash_original_field = "F5F439B44EA2FC34C5A7743F482ED12E", hash_generated_field = "7CCB62B854814A590D259304E0729FB4")

    private int mInputType = EditorInfo.TYPE_NULL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.444 -0400", hash_original_field = "A6D986505B9BCC5256C3BA5D73171C37", hash_generated_field = "D5CD99D8D87E7592EC6B5781C6FFB2FA")

    private CharSequence mHint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.444 -0400", hash_original_field = "D2F4B35B64C2568AE9793BBC2586054D", hash_generated_field = "EFAB677B32664E9E21A5DE46AC4EC1D6")

    private Layout mHintLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.444 -0400", hash_original_field = "BF2A01F10E67DAFA01668D8D4043BDC6", hash_generated_field = "CE990DF015C00781E7408846E8AEC5CB")

    private KeyListener mInput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.444 -0400", hash_original_field = "4AC20A6658642819EC3222EDB1107622", hash_generated_field = "BFA3240A2EA25F7A99F6D250E98184A7")

    private MovementMethod mMovement;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.444 -0400", hash_original_field = "BBDAB2FB373D7DA19760B893D5429B4A", hash_generated_field = "5EB7FC8FAB0A2FCCA9E8BF646DA1559A")

    private TransformationMethod mTransformation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.444 -0400", hash_original_field = "53FA59A802AE59C1CF5E57E2D5BFA622", hash_generated_field = "487D1BC024AFF96C6A5C663DC3AA641C")

    private boolean mAllowTransformationLengthChange;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.444 -0400", hash_original_field = "9607A29B4CC612A05365947273897FCA", hash_generated_field = "0D3B538949663CFF4038D6D64784977E")

    private ChangeWatcher mChangeWatcher;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.444 -0400", hash_original_field = "76E8AF78EA383C38A6F80E45CCFEA268", hash_generated_field = "B7D02B86862FFD54C18C460CFF0B0C2C")

    private ArrayList<TextWatcher> mListeners = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.444 -0400", hash_original_field = "A623C6B7D6CD75F8A26EF2CAD7479AA5", hash_generated_field = "6AD5EFC1421B741B1A8F78A5B815BBFE")

    private TextPaint mTextPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.444 -0400", hash_original_field = "462CCCBD3E9AD62A8A3FAE775E09DC1E", hash_generated_field = "21DF46CCA8F8000ED3BFF8BCF4D828BF")

    private boolean mUserSetTextScaleX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.444 -0400", hash_original_field = "BA05C1134DA05E6CE3231B819D53C1D5", hash_generated_field = "8983462E53EAFA6E482F98025B0E9AB8")

    private Paint mHighlightPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.444 -0400", hash_original_field = "CA2322AF1A6B4A09C8EDBDA4A3F74C10", hash_generated_field = "D25F7D2FFD7EFCE07B644E099B3A56D3")

    private int mHighlightColor = 0x6633B5E5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.445 -0400", hash_original_field = "AF58F50E47532278404C3D8470630FC4", hash_generated_field = "C7DD20DF980F25C7241B09204173E163")

    protected Layout mLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.445 -0400", hash_original_field = "36BB94A531229DD21F420AABF0C748F8", hash_generated_field = "0FB0111930B8AF18F464AB4FA2C6200F")

    private long mShowCursor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.445 -0400", hash_original_field = "57ABA66DF5CCF392086380D760C5BF59", hash_generated_field = "AC59C081943B626844E369F1A5892415")

    private Blink mBlink;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.445 -0400", hash_original_field = "6D2634EB69BE4B718BBEA043740ED62B", hash_generated_field = "F225E507C7DF6D613F7CBC4F577CB716")

    private boolean mCursorVisible = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.445 -0400", hash_original_field = "A2FF5C87B9A9D291A2D83F0CF574DDB4", hash_generated_field = "FDFA161EB04278A13E9ECB602C9782F4")

    private InsertionPointCursorController mInsertionPointCursorController;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.445 -0400", hash_original_field = "270783E153A9BE598B5DECCCBEDA6C36", hash_generated_field = "2218505DE3146C01814D6E81956F9301")

    private SelectionModifierCursorController mSelectionModifierCursorController;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.445 -0400", hash_original_field = "40FBF5FA719BD485A92A81EE27C61592", hash_generated_field = "656A5581A4DED5B2323E4335C55017B9")

    private ActionMode mSelectionActionMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.445 -0400", hash_original_field = "BC332654D5E01CC0638CB4493BFC9F05", hash_generated_field = "D1C9F3209CB13DAFB4E161EED540694F")

    private boolean mInsertionControllerEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.445 -0400", hash_original_field = "23C753EE6F79BCE184A6A1DB0589DB51", hash_generated_field = "E71C12A23BD84DA882CBDDBA123ABB17")

    private boolean mSelectionControllerEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.445 -0400", hash_original_field = "6854FB31EDC4E2B522D358A7D58685A8", hash_generated_field = "60F18FE1AE8CDBA3A5368ABF9BB5958F")

    private boolean mInBatchEditControllers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.445 -0400", hash_original_field = "37E6CBBA2DC07898D114DB5377D9D2AA", hash_generated_field = "7E20F67A0496D1E1FE6F1DC6D3BACA5D")

    private boolean mSelectAllOnFocus = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.445 -0400", hash_original_field = "2EF4E086F9141FE348E8A559F50FA1E9", hash_generated_field = "3FFAAA27B6CA268237E3AFE24778DD3C")

    private int mGravity = Gravity.TOP | Gravity.START;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.454 -0400", hash_original_field = "F2C627B045ED0B6F456489886DDF0435", hash_generated_field = "74DB3F78A4C361569E560DA09766931D")

    private boolean mHorizontallyScrolling;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.454 -0400", hash_original_field = "6B1804E483F3EF95C329AD84689BA27C", hash_generated_field = "3127858001137B18AA1050FDA67563F8")

    private int mAutoLinkMask;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.454 -0400", hash_original_field = "B20D3633475D5DDA643309B6DF38BAA8", hash_generated_field = "66946D660FCFF22371342C2FCD7310DE")

    private boolean mLinksClickable = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.454 -0400", hash_original_field = "768D4A0E99F80D8745CC748FF177B182", hash_generated_field = "8F925916DEF4152F81E2C1B309E2CAD4")

    private float mSpacingMult = 1.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.455 -0400", hash_original_field = "76B6C9620B0FBD77BE307E9334B95A63", hash_generated_field = "1E02CC84BB1334BEF2DEA24E10A518A6")

    private float mSpacingAdd = 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.455 -0400", hash_original_field = "146ACA11699BD6614DDC7A0149037FB6", hash_generated_field = "68BD06BADA0355451B21E90ACC461FA5")

    private boolean mTextIsSelectable = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.455 -0400", hash_original_field = "28A817F8D44803BA03BFDAF899CA4612", hash_generated_field = "0EE8DD6435BEB8CBE9F46AA7496B8DA6")

    private int mMaximum = Integer.MAX_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.455 -0400", hash_original_field = "896320C9E2FB4CFC66E16D3BD356BAAF", hash_generated_field = "033C060EBF21916B1ECB824474BF4BDF")

    private int mMaxMode = LINES;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.455 -0400", hash_original_field = "CC209BC90D03447E85DF642E369F8A86", hash_generated_field = "0828D86E694A99841F66D5DB44492D82")

    private int mMinimum = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.455 -0400", hash_original_field = "B23BA1EA5F949F96C83C84709B7349D6", hash_generated_field = "01F00155DEDA2DDBFDB49BED19C8F96E")

    private int mMinMode = LINES;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.455 -0400", hash_original_field = "7ED33BD2DC36574D26E443EE1A189C0D", hash_generated_field = "A1A2411DB171DF204A9C43EDA39C69C7")

    private int mOldMaximum = mMaximum;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.455 -0400", hash_original_field = "0FBED20BC4056EDF1181A5F7F65A66B2", hash_generated_field = "DDDC3184AF678EE8EE38801D06FC99BF")

    private int mOldMaxMode = mMaxMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.455 -0400", hash_original_field = "9F06F72E481BAF7A136AD40FA3B01EB4", hash_generated_field = "63C7BFD9234113D05BBC54B620020077")

    private int mMaxWidth = Integer.MAX_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.455 -0400", hash_original_field = "C2CD798A4E6691243397E9A6620CFDEE", hash_generated_field = "C110306973FAB903E136E57733D142DD")

    private int mMaxWidthMode = PIXELS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.455 -0400", hash_original_field = "26016AEBC03D4DA0060B1446537D35AC", hash_generated_field = "5E59AE0126344902582396461E5FAA8C")

    private int mMinWidth = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.455 -0400", hash_original_field = "23CF04FD3F773E8AECAC4DF696589658", hash_generated_field = "0B24A55CAE86F87D6F35062C108A6502")

    private int mMinWidthMode = PIXELS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.455 -0400", hash_original_field = "409E161D7D14305BE6BBBE3E4AEFFCED", hash_generated_field = "6C530F900873AA9699052FBD8A88B031")

    private boolean mSingleLine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.455 -0400", hash_original_field = "06185890E372F5D51274CAD861AA5867", hash_generated_field = "3740A3452EC2B82472EDA36D3C6B8C87")

    private int mDesiredHeightAtMeasure = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.455 -0400", hash_original_field = "7B7C4D5694417E83CD90BE557F7B1057", hash_generated_field = "F60C6FE0825AD0E4922E523051656DE4")

    private boolean mIncludePad = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.455 -0400", hash_original_field = "31F14B9E9336FCF46F51826201DA493C", hash_generated_field = "F7ADD3635432B5C7B3A742E5E6D21FF7")

    private Path mHighlightPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.455 -0400", hash_original_field = "1FE02E01128CA6EA399797D30A51BBAD", hash_generated_field = "899F52BC2A6F9C0116B0475059B2BE9C")

    private boolean mHighlightPathBogus = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.455 -0400", hash_original_field = "380EFAD062415C5D611446C1B15B307D", hash_generated_field = "507FF60BF6AED501221786F4F9B1C4CE")

    private long mLastScroll;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.455 -0400", hash_original_field = "7E9E953961CD92A66FE0351C10474492", hash_generated_field = "9C30A415641DC69EAA3304A141095B90")

    private Scroller mScroller = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.455 -0400", hash_original_field = "EC0875A99E92BD0CEBED0D984C28195A", hash_generated_field = "FF6D60EE34326DC34FD3A8DE24FDF7C9")

    private BoringLayout.Metrics mBoring;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.455 -0400", hash_original_field = "DF537B8351AF7282A7B1E499D83D9433", hash_generated_field = "AAFF1CC477C8CC62A538A60FE46DC5D1")

    private BoringLayout.Metrics mHintBoring;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.455 -0400", hash_original_field = "0A793C83D74ADBD2F96615B43A58295A", hash_generated_field = "A58D53DD9C11A6C44CEF04B476DD83D8")

    private BoringLayout mSavedLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.455 -0400", hash_original_field = "3823EF2992779A9DCE6B5232294F71F7", hash_generated_field = "65F61BA5EAB2A99364AEC51C71BE0AD2")

    private BoringLayout mSavedHintLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.455 -0400", hash_original_field = "1ED12FB8583DE3005542EC3E5ADE9C69", hash_generated_field = "49191C3FC0794274CF62373EA69DAA6D")

    private TextDirectionHeuristic mTextDir = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.455 -0400", hash_original_field = "8EF1F84508C44788B91A5266E4C71739", hash_generated_field = "489605ABB55A73F593690CC2882D1D5E")

    private InputFilter[] mFilters = NO_FILTERS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.455 -0400", hash_original_field = "28E8D15C0BD03E974FEC7876975B1D1F", hash_generated_field = "946F5E9D92C681851A4147B34C44B028")

    private CorrectionHighlighter mCorrectionHighlighter;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.455 -0400", hash_original_method = "16A18A865F32B95685EAC04EF434D4B5", hash_generated_method = "E4C2F370BE90FD637853CF92939C9374")
    public  TextView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.455 -0400", hash_original_method = "2AA1B7AF4AA0321ED5A0A8E3910A65F3", hash_generated_method = "F4EB84A10C0BF24F3C7F2AF2127B3127")
    public  TextView(Context context,
                    AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.textViewStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.462 -0400", hash_original_method = "9090DB4BB502E7A1E7DDA866F2D92623", hash_generated_method = "23AD89CBA0BEBC0D035CBE13A9739020")
    @SuppressWarnings("deprecation")
    public  TextView(Context context,
                    AttributeSet attrs,
                    int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        mText = "";
        final Resources res = getResources();
        final CompatibilityInfo compat = res.getCompatibilityInfo();
        mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.density = res.getDisplayMetrics().density;
        mTextPaint.setCompatibilityScaling(compat.applicationScale);
        mHighlightPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mHighlightPaint.setCompatibilityScaling(compat.applicationScale);
        mMovement = getDefaultMovementMethod();
        mTransformation = null;
        int textColorHighlight = 0;
        ColorStateList textColor = null;
        ColorStateList textColorHint = null;
        ColorStateList textColorLink = null;
        int textSize = 15;
        int typefaceIndex = -1;
        int styleIndex = -1;
        boolean allCaps = false;
        final Resources.Theme theme = context.getTheme();
        TypedArray a = theme.obtainStyledAttributes(
                    attrs, com.android.internal.R.styleable.TextViewAppearance, defStyle, 0);
        TypedArray appearance = null;
        int ap = a.getResourceId(
                com.android.internal.R.styleable.TextViewAppearance_textAppearance, -1);
        a.recycle();
        if(ap != -1)        
        {
            appearance = theme.obtainStyledAttributes(
                    ap, com.android.internal.R.styleable.TextAppearance);
        } //End block
        if(appearance != null)        
        {
            int n = appearance.getIndexCount();
for(int i = 0;i < n;i++)
            {
                int attr = appearance.getIndex(i);
switch(attr){
                case com.android.internal.R.styleable.TextAppearance_textColorHighlight:
                textColorHighlight = appearance.getColor(attr, textColorHighlight);
                break;
                case com.android.internal.R.styleable.TextAppearance_textColor:
                textColor = appearance.getColorStateList(attr);
                break;
                case com.android.internal.R.styleable.TextAppearance_textColorHint:
                textColorHint = appearance.getColorStateList(attr);
                break;
                case com.android.internal.R.styleable.TextAppearance_textColorLink:
                textColorLink = appearance.getColorStateList(attr);
                break;
                case com.android.internal.R.styleable.TextAppearance_textSize:
                textSize = appearance.getDimensionPixelSize(attr, textSize);
                break;
                case com.android.internal.R.styleable.TextAppearance_typeface:
                typefaceIndex = appearance.getInt(attr, -1);
                break;
                case com.android.internal.R.styleable.TextAppearance_textStyle:
                styleIndex = appearance.getInt(attr, -1);
                break;
                case com.android.internal.R.styleable.TextAppearance_textAllCaps:
                allCaps = appearance.getBoolean(attr, false);
                break;
}
            } //End block
            appearance.recycle();
        } //End block
        boolean editable = getDefaultEditable();
        CharSequence inputMethod = null;
        int numeric = 0;
        CharSequence digits = null;
        boolean phone = false;
        boolean autotext = false;
        int autocap = -1;
        int buffertype = 0;
        boolean selectallonfocus = false;
        Drawable drawableLeft = null;
        Drawable drawableTop = null;
        Drawable drawableRight = null;
        Drawable drawableBottom = null;
        Drawable drawableStart = null;
        Drawable drawableEnd = null;
        int drawablePadding = 0;
        int ellipsize = -1;
        boolean singleLine = false;
        int maxlength = -1;
        CharSequence text = "";
        CharSequence hint = null;
        int shadowcolor = 0;
        float dx = 0;
        float dy = 0;
        float r = 0;
        boolean password = false;
        int inputType = EditorInfo.TYPE_NULL;
        a = theme.obtainStyledAttributes(
                    attrs, com.android.internal.R.styleable.TextView, defStyle, 0);
        int n = a.getIndexCount();
for(int i = 0;i < n;i++)
        {
            int attr = a.getIndex(i);
switch(attr){
            case com.android.internal.R.styleable.TextView_editable:
            editable = a.getBoolean(attr, editable);
            break;
            case com.android.internal.R.styleable.TextView_inputMethod:
            inputMethod = a.getText(attr);
            break;
            case com.android.internal.R.styleable.TextView_numeric:
            numeric = a.getInt(attr, numeric);
            break;
            case com.android.internal.R.styleable.TextView_digits:
            digits = a.getText(attr);
            break;
            case com.android.internal.R.styleable.TextView_phoneNumber:
            phone = a.getBoolean(attr, phone);
            break;
            case com.android.internal.R.styleable.TextView_autoText:
            autotext = a.getBoolean(attr, autotext);
            break;
            case com.android.internal.R.styleable.TextView_capitalize:
            autocap = a.getInt(attr, autocap);
            break;
            case com.android.internal.R.styleable.TextView_bufferType:
            buffertype = a.getInt(attr, buffertype);
            break;
            case com.android.internal.R.styleable.TextView_selectAllOnFocus:
            selectallonfocus = a.getBoolean(attr, selectallonfocus);
            break;
            case com.android.internal.R.styleable.TextView_autoLink:
            mAutoLinkMask = a.getInt(attr, 0);
            break;
            case com.android.internal.R.styleable.TextView_linksClickable:
            mLinksClickable = a.getBoolean(attr, true);
            break;
            case com.android.internal.R.styleable.TextView_drawableLeft:
            drawableLeft = a.getDrawable(attr);
            break;
            case com.android.internal.R.styleable.TextView_drawableTop:
            drawableTop = a.getDrawable(attr);
            break;
            case com.android.internal.R.styleable.TextView_drawableRight:
            drawableRight = a.getDrawable(attr);
            break;
            case com.android.internal.R.styleable.TextView_drawableBottom:
            drawableBottom = a.getDrawable(attr);
            break;
            case com.android.internal.R.styleable.TextView_drawableStart:
            drawableStart = a.getDrawable(attr);
            break;
            case com.android.internal.R.styleable.TextView_drawableEnd:
            drawableEnd = a.getDrawable(attr);
            break;
            case com.android.internal.R.styleable.TextView_drawablePadding:
            drawablePadding = a.getDimensionPixelSize(attr, drawablePadding);
            break;
            case com.android.internal.R.styleable.TextView_maxLines:
            setMaxLines(a.getInt(attr, -1));
            break;
            case com.android.internal.R.styleable.TextView_maxHeight:
            setMaxHeight(a.getDimensionPixelSize(attr, -1));
            break;
            case com.android.internal.R.styleable.TextView_lines:
            setLines(a.getInt(attr, -1));
            break;
            case com.android.internal.R.styleable.TextView_height:
            setHeight(a.getDimensionPixelSize(attr, -1));
            break;
            case com.android.internal.R.styleable.TextView_minLines:
            setMinLines(a.getInt(attr, -1));
            break;
            case com.android.internal.R.styleable.TextView_minHeight:
            setMinHeight(a.getDimensionPixelSize(attr, -1));
            break;
            case com.android.internal.R.styleable.TextView_maxEms:
            setMaxEms(a.getInt(attr, -1));
            break;
            case com.android.internal.R.styleable.TextView_maxWidth:
            setMaxWidth(a.getDimensionPixelSize(attr, -1));
            break;
            case com.android.internal.R.styleable.TextView_ems:
            setEms(a.getInt(attr, -1));
            break;
            case com.android.internal.R.styleable.TextView_width:
            setWidth(a.getDimensionPixelSize(attr, -1));
            break;
            case com.android.internal.R.styleable.TextView_minEms:
            setMinEms(a.getInt(attr, -1));
            break;
            case com.android.internal.R.styleable.TextView_minWidth:
            setMinWidth(a.getDimensionPixelSize(attr, -1));
            break;
            case com.android.internal.R.styleable.TextView_gravity:
            setGravity(a.getInt(attr, -1));
            break;
            case com.android.internal.R.styleable.TextView_hint:
            hint = a.getText(attr);
            break;
            case com.android.internal.R.styleable.TextView_text:
            text = a.getText(attr);
            break;
            case com.android.internal.R.styleable.TextView_scrollHorizontally:
            if(a.getBoolean(attr, false))            
            {
                setHorizontallyScrolling(true);
            } //End block
            break;
            case com.android.internal.R.styleable.TextView_singleLine:
            singleLine = a.getBoolean(attr, singleLine);
            break;
            case com.android.internal.R.styleable.TextView_ellipsize:
            ellipsize = a.getInt(attr, ellipsize);
            break;
            case com.android.internal.R.styleable.TextView_marqueeRepeatLimit:
            setMarqueeRepeatLimit(a.getInt(attr, mMarqueeRepeatLimit));
            break;
            case com.android.internal.R.styleable.TextView_includeFontPadding:
            if(!a.getBoolean(attr, true))            
            {
                setIncludeFontPadding(false);
            } //End block
            break;
            case com.android.internal.R.styleable.TextView_cursorVisible:
            if(!a.getBoolean(attr, true))            
            {
                setCursorVisible(false);
            } //End block
            break;
            case com.android.internal.R.styleable.TextView_maxLength:
            maxlength = a.getInt(attr, -1);
            break;
            case com.android.internal.R.styleable.TextView_textScaleX:
            setTextScaleX(a.getFloat(attr, 1.0f));
            break;
            case com.android.internal.R.styleable.TextView_freezesText:
            mFreezesText = a.getBoolean(attr, false);
            break;
            case com.android.internal.R.styleable.TextView_shadowColor:
            shadowcolor = a.getInt(attr, 0);
            break;
            case com.android.internal.R.styleable.TextView_shadowDx:
            dx = a.getFloat(attr, 0);
            break;
            case com.android.internal.R.styleable.TextView_shadowDy:
            dy = a.getFloat(attr, 0);
            break;
            case com.android.internal.R.styleable.TextView_shadowRadius:
            r = a.getFloat(attr, 0);
            break;
            case com.android.internal.R.styleable.TextView_enabled:
            setEnabled(a.getBoolean(attr, isEnabled()));
            break;
            case com.android.internal.R.styleable.TextView_textColorHighlight:
            textColorHighlight = a.getColor(attr, textColorHighlight);
            break;
            case com.android.internal.R.styleable.TextView_textColor:
            textColor = a.getColorStateList(attr);
            break;
            case com.android.internal.R.styleable.TextView_textColorHint:
            textColorHint = a.getColorStateList(attr);
            break;
            case com.android.internal.R.styleable.TextView_textColorLink:
            textColorLink = a.getColorStateList(attr);
            break;
            case com.android.internal.R.styleable.TextView_textSize:
            textSize = a.getDimensionPixelSize(attr, textSize);
            break;
            case com.android.internal.R.styleable.TextView_typeface:
            typefaceIndex = a.getInt(attr, typefaceIndex);
            break;
            case com.android.internal.R.styleable.TextView_textStyle:
            styleIndex = a.getInt(attr, styleIndex);
            break;
            case com.android.internal.R.styleable.TextView_password:
            password = a.getBoolean(attr, password);
            break;
            case com.android.internal.R.styleable.TextView_lineSpacingExtra:
            mSpacingAdd = a.getDimensionPixelSize(attr, (int) mSpacingAdd);
            break;
            case com.android.internal.R.styleable.TextView_lineSpacingMultiplier:
            mSpacingMult = a.getFloat(attr, mSpacingMult);
            break;
            case com.android.internal.R.styleable.TextView_inputType:
            inputType = a.getInt(attr, mInputType);
            break;
            case com.android.internal.R.styleable.TextView_imeOptions:
            if(mInputContentType == null)            
            {
                mInputContentType = new InputContentType();
            } //End block
            mInputContentType.imeOptions = a.getInt(attr,
                        mInputContentType.imeOptions);
            break;
            case com.android.internal.R.styleable.TextView_imeActionLabel:
            if(mInputContentType == null)            
            {
                mInputContentType = new InputContentType();
            } //End block
            mInputContentType.imeActionLabel = a.getText(attr);
            break;
            case com.android.internal.R.styleable.TextView_imeActionId:
            if(mInputContentType == null)            
            {
                mInputContentType = new InputContentType();
            } //End block
            mInputContentType.imeActionId = a.getInt(attr,
                        mInputContentType.imeActionId);
            break;
            case com.android.internal.R.styleable.TextView_privateImeOptions:
            setPrivateImeOptions(a.getString(attr));
            break;
            case com.android.internal.R.styleable.TextView_editorExtras:
            try 
            {
                setInputExtras(a.getResourceId(attr, 0));
            } //End block
            catch (XmlPullParserException e)
            {
            } //End block
            catch (IOException e)
            {
            } //End block
            break;
            case com.android.internal.R.styleable.TextView_textCursorDrawable:
            mCursorDrawableRes = a.getResourceId(attr, 0);
            break;
            case com.android.internal.R.styleable.TextView_textSelectHandleLeft:
            mTextSelectHandleLeftRes = a.getResourceId(attr, 0);
            break;
            case com.android.internal.R.styleable.TextView_textSelectHandleRight:
            mTextSelectHandleRightRes = a.getResourceId(attr, 0);
            break;
            case com.android.internal.R.styleable.TextView_textSelectHandle:
            mTextSelectHandleRes = a.getResourceId(attr, 0);
            break;
            case com.android.internal.R.styleable.TextView_textEditSuggestionItemLayout:
            mTextEditSuggestionItemLayout = a.getResourceId(attr, 0);
            break;
            case com.android.internal.R.styleable.TextView_textIsSelectable:
            mTextIsSelectable = a.getBoolean(attr, false);
            break;
            case com.android.internal.R.styleable.TextView_textAllCaps:
            allCaps = a.getBoolean(attr, false);
            break;
}
        } //End block
        a.recycle();
        BufferType bufferType = BufferType.EDITABLE;
        final int variation = inputType & (EditorInfo.TYPE_MASK_CLASS | EditorInfo.TYPE_MASK_VARIATION);
        final boolean passwordInputType = variation
                == (EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_VARIATION_PASSWORD);
        final boolean webPasswordInputType = variation
                == (EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_VARIATION_WEB_PASSWORD);
        final boolean numberPasswordInputType = variation
                == (EditorInfo.TYPE_CLASS_NUMBER | EditorInfo.TYPE_NUMBER_VARIATION_PASSWORD);
        if(inputMethod != null)        
        {
            Class<?> c;
            try 
            {
                c = Class.forName(inputMethod.toString());
            } //End block
            catch (ClassNotFoundException ex)
            {
                RuntimeException varF35D3C95F99DACEE8C542CF38D772C50_1465662716 = new RuntimeException(ex);
                varF35D3C95F99DACEE8C542CF38D772C50_1465662716.addTaint(taint);
                throw varF35D3C95F99DACEE8C542CF38D772C50_1465662716;
            } //End block
            try 
            {
                mInput = (KeyListener) c.newInstance();
            } //End block
            catch (InstantiationException ex)
            {
                RuntimeException varF35D3C95F99DACEE8C542CF38D772C50_783290925 = new RuntimeException(ex);
                varF35D3C95F99DACEE8C542CF38D772C50_783290925.addTaint(taint);
                throw varF35D3C95F99DACEE8C542CF38D772C50_783290925;
            } //End block
            catch (IllegalAccessException ex)
            {
                RuntimeException varF35D3C95F99DACEE8C542CF38D772C50_1419080337 = new RuntimeException(ex);
                varF35D3C95F99DACEE8C542CF38D772C50_1419080337.addTaint(taint);
                throw varF35D3C95F99DACEE8C542CF38D772C50_1419080337;
            } //End block
            try 
            {
                mInputType = inputType != EditorInfo.TYPE_NULL
                        ? inputType
                        : mInput.getInputType();
            } //End block
            catch (IncompatibleClassChangeError e)
            {
                mInputType = EditorInfo.TYPE_CLASS_TEXT;
            } //End block
        } //End block
        else
        if(digits != null)        
        {
            mInput = DigitsKeyListener.getInstance(digits.toString());
            mInputType = inputType != EditorInfo.TYPE_NULL
                    ? inputType : EditorInfo.TYPE_CLASS_TEXT;
        } //End block
        else
        if(inputType != EditorInfo.TYPE_NULL)        
        {
            setInputType(inputType, true);
            singleLine = !isMultilineInputType(inputType);
        } //End block
        else
        if(phone)        
        {
            mInput = DialerKeyListener.getInstance();
            mInputType = inputType = EditorInfo.TYPE_CLASS_PHONE;
        } //End block
        else
        if(numeric != 0)        
        {
            mInput = DigitsKeyListener.getInstance((numeric & SIGNED) != 0,
                                                   (numeric & DECIMAL) != 0);
            inputType = EditorInfo.TYPE_CLASS_NUMBER;
            if((numeric & SIGNED) != 0)            
            {
                inputType |= EditorInfo.TYPE_NUMBER_FLAG_SIGNED;
            } //End block
            if((numeric & DECIMAL) != 0)            
            {
                inputType |= EditorInfo.TYPE_NUMBER_FLAG_DECIMAL;
            } //End block
            mInputType = inputType;
        } //End block
        else
        if(autotext || autocap != -1)        
        {
            TextKeyListener.Capitalize cap;
            inputType = EditorInfo.TYPE_CLASS_TEXT;
switch(autocap){
            case 1:
            cap = TextKeyListener.Capitalize.SENTENCES;
            inputType |= EditorInfo.TYPE_TEXT_FLAG_CAP_SENTENCES;
            break;
            case 2:
            cap = TextKeyListener.Capitalize.WORDS;
            inputType |= EditorInfo.TYPE_TEXT_FLAG_CAP_WORDS;
            break;
            case 3:
            cap = TextKeyListener.Capitalize.CHARACTERS;
            inputType |= EditorInfo.TYPE_TEXT_FLAG_CAP_CHARACTERS;
            break;
            default:
            cap = TextKeyListener.Capitalize.NONE;
            break;
}            mInput = TextKeyListener.getInstance(autotext, cap);
            mInputType = inputType;
        } //End block
        else
        if(mTextIsSelectable)        
        {
            mInputType = EditorInfo.TYPE_NULL;
            mInput = null;
            bufferType = BufferType.SPANNABLE;
            setFocusableInTouchMode(true);
            setMovementMethod(ArrowKeyMovementMethod.getInstance());
        } //End block
        else
        if(editable)        
        {
            mInput = TextKeyListener.getInstance();
            mInputType = EditorInfo.TYPE_CLASS_TEXT;
        } //End block
        else
        {
            mInput = null;
switch(buffertype){
            case 0:
            bufferType = BufferType.NORMAL;
            break;
            case 1:
            bufferType = BufferType.SPANNABLE;
            break;
            case 2:
            bufferType = BufferType.EDITABLE;
            break;
}
        } //End block
        if((mInputType & EditorInfo.TYPE_MASK_CLASS) == EditorInfo.TYPE_CLASS_TEXT)        
        {
            if(password || passwordInputType)            
            {
                mInputType = (mInputType & ~(EditorInfo.TYPE_MASK_VARIATION))
                        | EditorInfo.TYPE_TEXT_VARIATION_PASSWORD;
            } //End block
            if(webPasswordInputType)            
            {
                mInputType = (mInputType & ~(EditorInfo.TYPE_MASK_VARIATION))
                        | EditorInfo.TYPE_TEXT_VARIATION_WEB_PASSWORD;
            } //End block
        } //End block
        else
        if((mInputType & EditorInfo.TYPE_MASK_CLASS) == EditorInfo.TYPE_CLASS_NUMBER)        
        {
            if(numberPasswordInputType)            
            {
                mInputType = (mInputType & ~(EditorInfo.TYPE_MASK_VARIATION))
                        | EditorInfo.TYPE_NUMBER_VARIATION_PASSWORD;
            } //End block
        } //End block
        if(selectallonfocus)        
        {
            mSelectAllOnFocus = true;
            if(bufferType == BufferType.NORMAL)            
            bufferType = BufferType.SPANNABLE;
        } //End block
        setCompoundDrawablesWithIntrinsicBounds(
            drawableLeft, drawableTop, drawableRight, drawableBottom);
        setRelativeDrawablesIfNeeded(drawableStart, drawableEnd);
        setCompoundDrawablePadding(drawablePadding);
        setInputTypeSingleLine(singleLine);
        applySingleLine(singleLine, singleLine, singleLine);
        if(singleLine && mInput == null && ellipsize < 0)        
        {
            ellipsize = 3;
        } //End block
switch(ellipsize){
        case 1:
        setEllipsize(TextUtils.TruncateAt.START);
        break;
        case 2:
        setEllipsize(TextUtils.TruncateAt.MIDDLE);
        break;
        case 3:
        setEllipsize(TextUtils.TruncateAt.END);
        break;
        case 4:
        if(ViewConfiguration.get(context).isFadingMarqueeEnabled())        
        {
            setHorizontalFadingEdgeEnabled(true);
            mMarqueeFadeMode = MARQUEE_FADE_NORMAL;
        } //End block
        else
        {
            setHorizontalFadingEdgeEnabled(false);
            mMarqueeFadeMode = MARQUEE_FADE_SWITCH_SHOW_ELLIPSIS;
        } //End block
        setEllipsize(TextUtils.TruncateAt.MARQUEE);
        break;
}        setTextColor(textColor != null ? textColor : ColorStateList.valueOf(0xFF000000));
        setHintTextColor(textColorHint);
        setLinkTextColor(textColorLink);
        if(textColorHighlight != 0)        
        {
            setHighlightColor(textColorHighlight);
        } //End block
        setRawTextSize(textSize);
        if(allCaps)        
        {
            setTransformationMethod(new AllCapsTransformationMethod(getContext()));
        } //End block
        if(password || passwordInputType || webPasswordInputType || numberPasswordInputType)        
        {
            setTransformationMethod(PasswordTransformationMethod.getInstance());
            typefaceIndex = MONOSPACE;
        } //End block
        else
        if((mInputType & (EditorInfo.TYPE_MASK_CLASS | EditorInfo.TYPE_MASK_VARIATION))
                == (EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_VARIATION_PASSWORD))        
        {
            typefaceIndex = MONOSPACE;
        } //End block
        setTypefaceByIndex(typefaceIndex, styleIndex);
        if(shadowcolor != 0)        
        {
            setShadowLayer(r, dx, dy, shadowcolor);
        } //End block
        if(maxlength >= 0)        
        {
            setFilters(new InputFilter[] { new InputFilter.LengthFilter(maxlength) });
        } //End block
        else
        {
            setFilters(NO_FILTERS);
        } //End block
        setText(text, bufferType);
        if(hint != null)        
        setHint(hint);
        a = context.obtainStyledAttributes(attrs,
                                           com.android.internal.R.styleable.View,
                                           defStyle, 0);
        boolean focusable = mMovement != null || mInput != null;
        boolean clickable = focusable;
        boolean longClickable = focusable;
        n = a.getIndexCount();
for(int i = 0;i < n;i++)
        {
            int attr = a.getIndex(i);
switch(attr){
            case com.android.internal.R.styleable.View_focusable:
            focusable = a.getBoolean(attr, focusable);
            break;
            case com.android.internal.R.styleable.View_clickable:
            clickable = a.getBoolean(attr, clickable);
            break;
            case com.android.internal.R.styleable.View_longClickable:
            longClickable = a.getBoolean(attr, longClickable);
            break;
}
        } //End block
        a.recycle();
        setFocusable(focusable);
        setClickable(clickable);
        setLongClickable(longClickable);
        prepareCursorControllers();
        final ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        final int touchSlop = viewConfiguration.getScaledTouchSlop();
        mSquaredTouchSlopDistance = touchSlop * touchSlop;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.464 -0400", hash_original_method = "C60E18AF77ADDBBD7F15C48D3326353D", hash_generated_method = "1392DA6608441D8746298C726EB5B18B")
    private void setTypefaceByIndex(int typefaceIndex, int styleIndex) {
        addTaint(styleIndex);
        addTaint(typefaceIndex);
        Typeface tf = null;
switch(typefaceIndex){
        case SANS:
        tf = Typeface.SANS_SERIF;
        break;
        case SERIF:
        tf = Typeface.SERIF;
        break;
        case MONOSPACE:
        tf = Typeface.MONOSPACE;
        break;
}        setTypeface(tf, styleIndex);
        // ---------- Original Method ----------
        //Typeface tf = null;
        //switch (typefaceIndex) {
            //case SANS:
                //tf = Typeface.SANS_SERIF;
                //break;
            //case SERIF:
                //tf = Typeface.SERIF;
                //break;
            //case MONOSPACE:
                //tf = Typeface.MONOSPACE;
                //break;
        //}
        //setTypeface(tf, styleIndex);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.464 -0400", hash_original_method = "81361F4824C6D1D7960776386313375B", hash_generated_method = "1E731655A8C7D81F7C9A8704B7DAF799")
    private void setRelativeDrawablesIfNeeded(Drawable start, Drawable end) {
        addTaint(end.getTaint());
        addTaint(start.getTaint());
        boolean hasRelativeDrawables = (start != null) || (end != null);
        if(hasRelativeDrawables)        
        {
            Drawables dr = mDrawables;
            if(dr == null)            
            {
                mDrawables = dr = new Drawables();
            } //End block
            final Rect compoundRect = dr.mCompoundRect;
            int[] state = getDrawableState();
            if(start != null)            
            {
                start.setBounds(0, 0, start.getIntrinsicWidth(), start.getIntrinsicHeight());
                start.setState(state);
                start.copyBounds(compoundRect);
                start.setCallback(this);
                dr.mDrawableStart = start;
                dr.mDrawableSizeStart = compoundRect.width();
                dr.mDrawableHeightStart = compoundRect.height();
            } //End block
            else
            {
                dr.mDrawableSizeStart = dr.mDrawableHeightStart = 0;
            } //End block
            if(end != null)            
            {
                end.setBounds(0, 0, end.getIntrinsicWidth(), end.getIntrinsicHeight());
                end.setState(state);
                end.copyBounds(compoundRect);
                end.setCallback(this);
                dr.mDrawableEnd = end;
                dr.mDrawableSizeEnd = compoundRect.width();
                dr.mDrawableHeightEnd = compoundRect.height();
            } //End block
            else
            {
                dr.mDrawableSizeEnd = dr.mDrawableHeightEnd = 0;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.465 -0400", hash_original_method = "224789FFA5DBD63B17185276A15DADF0", hash_generated_method = "F42DFDCC61E9920014D48E4FE8C21A34")
    @Override
    public void setEnabled(boolean enabled) {
        addTaint(enabled);
        if(enabled == isEnabled())        
        {
            return;
        } //End block
        if(!enabled)        
        {
            InputMethodManager imm = InputMethodManager.peekInstance();
            if(imm != null && imm.isActive(this))            
            {
                imm.hideSoftInputFromWindow(getWindowToken(), 0);
            } //End block
        } //End block
        super.setEnabled(enabled);
        prepareCursorControllers();
        if(enabled)        
        {
            InputMethodManager imm = InputMethodManager.peekInstance();
            if(imm != null)            
            imm.restartInput(this);
        } //End block
        makeBlink();
        // ---------- Original Method ----------
        //if (enabled == isEnabled()) {
            //return;
        //}
        //if (!enabled) {
            //InputMethodManager imm = InputMethodManager.peekInstance();
            //if (imm != null && imm.isActive(this)) {
                //imm.hideSoftInputFromWindow(getWindowToken(), 0);
            //}
        //}
        //super.setEnabled(enabled);
        //prepareCursorControllers();
        //if (enabled) {
            //InputMethodManager imm = InputMethodManager.peekInstance();
            //if (imm != null) imm.restartInput(this);
        //}
        //makeBlink();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.465 -0400", hash_original_method = "6CE73F981984CDCC5004358BB070DFC0", hash_generated_method = "CA8F9395E7DD1B063296F79B82546FAD")
    public void setTypeface(Typeface tf, int style) {
        addTaint(style);
        addTaint(tf.getTaint());
        if(style > 0)        
        {
            if(tf == null)            
            {
                tf = Typeface.defaultFromStyle(style);
            } //End block
            else
            {
                tf = Typeface.create(tf, style);
            } //End block
            setTypeface(tf);
            int typefaceStyle = tf != null ? tf.getStyle() : 0;
            int need = style & ~typefaceStyle;
            mTextPaint.setFakeBoldText((need & Typeface.BOLD) != 0);
            mTextPaint.setTextSkewX((need & Typeface.ITALIC) != 0 ? -0.25f : 0);
        } //End block
        else
        {
            mTextPaint.setFakeBoldText(false);
            mTextPaint.setTextSkewX(0);
            setTypeface(tf);
        } //End block
        // ---------- Original Method ----------
        //if (style > 0) {
            //if (tf == null) {
                //tf = Typeface.defaultFromStyle(style);
            //} else {
                //tf = Typeface.create(tf, style);
            //}
            //setTypeface(tf);
            //int typefaceStyle = tf != null ? tf.getStyle() : 0;
            //int need = style & ~typefaceStyle;
            //mTextPaint.setFakeBoldText((need & Typeface.BOLD) != 0);
            //mTextPaint.setTextSkewX((need & Typeface.ITALIC) != 0 ? -0.25f : 0);
        //} else {
            //mTextPaint.setFakeBoldText(false);
            //mTextPaint.setTextSkewX(0);
            //setTypeface(tf);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.465 -0400", hash_original_method = "BFDF598F6F7CD4AFD7EB65F700EA9607", hash_generated_method = "189527C4B1A3043042CEA7D44894A5AD")
    protected boolean getDefaultEditable() {
        boolean var68934A3E9455FA72420237EB05902327_1730489328 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_114643896 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_114643896;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.465 -0400", hash_original_method = "BBE0A92ADC5D9278A97962CE8941F1CB", hash_generated_method = "3D8ECF1ACEC5E0F291637CBE0322ABF7")
    protected MovementMethod getDefaultMovementMethod() {
MovementMethod var540C13E9E156B687226421B24F2DF178_553228822 =         null;
        var540C13E9E156B687226421B24F2DF178_553228822.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_553228822;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.465 -0400", hash_original_method = "D3D56665E0CC0B43413FBFB4C720E96C", hash_generated_method = "303A4EE2FE9FBC2D4995239F44DD66FC")
    @ViewDebug.CapturedViewProperty
    public CharSequence getText() {
CharSequence var7F7ECB4B14362FFBA020956966B29A66_1786945078 =         mText;
        var7F7ECB4B14362FFBA020956966B29A66_1786945078.addTaint(taint);
        return var7F7ECB4B14362FFBA020956966B29A66_1786945078;
        // ---------- Original Method ----------
        //return mText;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.465 -0400", hash_original_method = "9A68249D01A4FE1CBD4D535668FCEB6F", hash_generated_method = "BD6E5F0724DCE5C828476C9D36103DA5")
    public int length() {
        int varDC3F5DE2558DF3D25118F6362DE3EB1B_1016494306 = (mText.length());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_132523289 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_132523289;
        // ---------- Original Method ----------
        //return mText.length();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.465 -0400", hash_original_method = "7ED3A36B3A9686857AF495D746EF7144", hash_generated_method = "E390E6041FEE7D14ABE6E4F661D86BF2")
    public Editable getEditableText() {
Editable var90F693ADAAEDDC10688A5C781A91E181_1234979393 =         (mText instanceof Editable) ? (Editable)mText : null;
        var90F693ADAAEDDC10688A5C781A91E181_1234979393.addTaint(taint);
        return var90F693ADAAEDDC10688A5C781A91E181_1234979393;
        // ---------- Original Method ----------
        //return (mText instanceof Editable) ? (Editable)mText : null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.466 -0400", hash_original_method = "0FF7B2A5A4CF7321FA6B03810945EA51", hash_generated_method = "A608D6657BF8E70C6CCAD77EEA3F8664")
    public int getLineHeight() {
        int var5222DA5ADA5A2C20FA8911ECF5220EE9_2011186801 = (FastMath.round(mTextPaint.getFontMetricsInt(null) * mSpacingMult + mSpacingAdd));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_864365726 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_864365726;
        // ---------- Original Method ----------
        //return FastMath.round(mTextPaint.getFontMetricsInt(null) * mSpacingMult + mSpacingAdd);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.466 -0400", hash_original_method = "AA853122D8F66FE025B9AF375421C379", hash_generated_method = "2FCEFCB541CB97D78D53AA12D844164E")
    public final Layout getLayout() {
Layout varFA65A27877300FD69BC313061186E4EE_1149914840 =         mLayout;
        varFA65A27877300FD69BC313061186E4EE_1149914840.addTaint(taint);
        return varFA65A27877300FD69BC313061186E4EE_1149914840;
        // ---------- Original Method ----------
        //return mLayout;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.466 -0400", hash_original_method = "16C14256413AD7EC2C071FEF64E5C315", hash_generated_method = "7C37943959BE1FF10F9B7AF30CBF34F9")
    public final KeyListener getKeyListener() {
KeyListener var5EBB3E30E30E9FC3A51B2E7E91DCB5FE_2134579294 =         mInput;
        var5EBB3E30E30E9FC3A51B2E7E91DCB5FE_2134579294.addTaint(taint);
        return var5EBB3E30E30E9FC3A51B2E7E91DCB5FE_2134579294;
        // ---------- Original Method ----------
        //return mInput;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.466 -0400", hash_original_method = "C24E7464E624E00527FA94ACF2B78CDF", hash_generated_method = "4479F81C7AB4E3171DA0380EED051857")
    public void setKeyListener(KeyListener input) {
        addTaint(input.getTaint());
        setKeyListenerOnly(input);
        fixFocusableAndClickableSettings();
        if(input != null)        
        {
            try 
            {
                mInputType = mInput.getInputType();
            } //End block
            catch (IncompatibleClassChangeError e)
            {
                mInputType = EditorInfo.TYPE_CLASS_TEXT;
            } //End block
            setInputTypeSingleLine(mSingleLine);
        } //End block
        else
        {
            mInputType = EditorInfo.TYPE_NULL;
        } //End block
        InputMethodManager imm = InputMethodManager.peekInstance();
        if(imm != null)        
        imm.restartInput(this);
        // ---------- Original Method ----------
        //setKeyListenerOnly(input);
        //fixFocusableAndClickableSettings();
        //if (input != null) {
            //try {
                //mInputType = mInput.getInputType();
            //} catch (IncompatibleClassChangeError e) {
                //mInputType = EditorInfo.TYPE_CLASS_TEXT;
            //}
            //setInputTypeSingleLine(mSingleLine);
        //} else {
            //mInputType = EditorInfo.TYPE_NULL;
        //}
        //InputMethodManager imm = InputMethodManager.peekInstance();
        //if (imm != null) imm.restartInput(this);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.466 -0400", hash_original_method = "4C0922906A0644E54152EA479C6FB8D4", hash_generated_method = "D150019EF240ACF49C8766A33CC7D765")
    private void setKeyListenerOnly(KeyListener input) {
        mInput = input;
        if(mInput != null && !(mText instanceof Editable))        
        setText(mText);
        setFilters((Editable) mText, mFilters);
        // ---------- Original Method ----------
        //mInput = input;
        //if (mInput != null && !(mText instanceof Editable))
            //setText(mText);
        //setFilters((Editable) mText, mFilters);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.466 -0400", hash_original_method = "48923BC0AD13C4CAAF5FC92105497B11", hash_generated_method = "4234548579865CF79D03E4B5A3C235C3")
    public final MovementMethod getMovementMethod() {
MovementMethod varE81CB23918866C95C9F3F00493F4F896_315739951 =         mMovement;
        varE81CB23918866C95C9F3F00493F4F896_315739951.addTaint(taint);
        return varE81CB23918866C95C9F3F00493F4F896_315739951;
        // ---------- Original Method ----------
        //return mMovement;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.466 -0400", hash_original_method = "A60F83672BBDF336AF379460700DB19E", hash_generated_method = "9B27B40E42098005C48EF0F2D7F52E41")
    public final void setMovementMethod(MovementMethod movement) {
        mMovement = movement;
        if(mMovement != null && !(mText instanceof Spannable))        
        setText(mText);
        fixFocusableAndClickableSettings();
        prepareCursorControllers();
        // ---------- Original Method ----------
        //mMovement = movement;
        //if (mMovement != null && !(mText instanceof Spannable))
            //setText(mText);
        //fixFocusableAndClickableSettings();
        //prepareCursorControllers();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.467 -0400", hash_original_method = "20BA1DEB0A4AF2EE483D2287D9007BE7", hash_generated_method = "6BEA3A0D0F30D33F41D8F39388D8C1E6")
    private void fixFocusableAndClickableSettings() {
        if((mMovement != null) || mInput != null)        
        {
            setFocusable(true);
            setClickable(true);
            setLongClickable(true);
        } //End block
        else
        {
            setFocusable(false);
            setClickable(false);
            setLongClickable(false);
        } //End block
        // ---------- Original Method ----------
        //if ((mMovement != null) || mInput != null) {
            //setFocusable(true);
            //setClickable(true);
            //setLongClickable(true);
        //} else {
            //setFocusable(false);
            //setClickable(false);
            //setLongClickable(false);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.467 -0400", hash_original_method = "2CDC6DDF1029E76D6DBEC0602C28EC15", hash_generated_method = "35C4B107F9481D8B57E7E2647D6DDB86")
    public final TransformationMethod getTransformationMethod() {
TransformationMethod varF3FC77C6A6DBCA471A3EEB750ACB0844_1324207267 =         mTransformation;
        varF3FC77C6A6DBCA471A3EEB750ACB0844_1324207267.addTaint(taint);
        return varF3FC77C6A6DBCA471A3EEB750ACB0844_1324207267;
        // ---------- Original Method ----------
        //return mTransformation;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.467 -0400", hash_original_method = "93D394D84FFC0B02B9FD24841443EB6E", hash_generated_method = "73B025571B06364795372CD69839C012")
    public final void setTransformationMethod(TransformationMethod method) {
        if(method == mTransformation)        
        {
            return;
        } //End block
        if(mTransformation != null)        
        {
            if(mText instanceof Spannable)            
            {
                ((Spannable) mText).removeSpan(mTransformation);
            } //End block
        } //End block
        mTransformation = method;
        if(method instanceof TransformationMethod2)        
        {
            TransformationMethod2 method2 = (TransformationMethod2) method;
            mAllowTransformationLengthChange = !mTextIsSelectable && !(mText instanceof Editable);
            method2.setLengthChangesAllowed(mAllowTransformationLengthChange);
        } //End block
        else
        {
            mAllowTransformationLengthChange = false;
        } //End block
        setText(mText);
        // ---------- Original Method ----------
        //if (method == mTransformation) {
            //return;
        //}
        //if (mTransformation != null) {
            //if (mText instanceof Spannable) {
                //((Spannable) mText).removeSpan(mTransformation);
            //}
        //}
        //mTransformation = method;
        //if (method instanceof TransformationMethod2) {
            //TransformationMethod2 method2 = (TransformationMethod2) method;
            //mAllowTransformationLengthChange = !mTextIsSelectable && !(mText instanceof Editable);
            //method2.setLengthChangesAllowed(mAllowTransformationLengthChange);
        //} else {
            //mAllowTransformationLengthChange = false;
        //}
        //setText(mText);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.467 -0400", hash_original_method = "CD4E87E17C71F6F36E69A30DF125A2EC", hash_generated_method = "35821C315482BDCEC903D0C46B023C1C")
    public int getCompoundPaddingTop() {
        final Drawables dr = mDrawables;
        if(dr == null || dr.mDrawableTop == null)        
        {
            int var160C8C8F6F0F40401734402AE62419A9_743936904 = (mPaddingTop);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_623479252 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_623479252;
        } //End block
        else
        {
            int varF529F66C6F7697E1F2EFEB87875A1CFA_1195156768 = (mPaddingTop + dr.mDrawablePadding + dr.mDrawableSizeTop);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1816794684 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1816794684;
        } //End block
        // ---------- Original Method ----------
        //final Drawables dr = mDrawables;
        //if (dr == null || dr.mDrawableTop == null) {
            //return mPaddingTop;
        //} else {
            //return mPaddingTop + dr.mDrawablePadding + dr.mDrawableSizeTop;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.467 -0400", hash_original_method = "F8E73EA88ED50BD236713C6E1FD6275E", hash_generated_method = "ABD156FFDE958E86CE98F56E1DB553E6")
    public int getCompoundPaddingBottom() {
        final Drawables dr = mDrawables;
        if(dr == null || dr.mDrawableBottom == null)        
        {
            int varDC0A1BD9ED7E0615D8F16D5DA74E6D47_379926733 = (mPaddingBottom);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1503299249 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1503299249;
        } //End block
        else
        {
            int varABD1F8A9BB46EB537A517AAB3188C98C_1578205766 = (mPaddingBottom + dr.mDrawablePadding + dr.mDrawableSizeBottom);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1533050606 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1533050606;
        } //End block
        // ---------- Original Method ----------
        //final Drawables dr = mDrawables;
        //if (dr == null || dr.mDrawableBottom == null) {
            //return mPaddingBottom;
        //} else {
            //return mPaddingBottom + dr.mDrawablePadding + dr.mDrawableSizeBottom;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.468 -0400", hash_original_method = "E37CE1C2FEDB3DD18FEE34DF2470D692", hash_generated_method = "FB1EB2FDF071F9C90B2A2B03CC71BDDB")
    public int getCompoundPaddingLeft() {
        final Drawables dr = mDrawables;
        if(dr == null || dr.mDrawableLeft == null)        
        {
            int var252F7DBD6188FA4BC0CBCF5785506FD8_1705303551 = (mPaddingLeft);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1866017894 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1866017894;
        } //End block
        else
        {
            int varF71F855E99C9C14D150F728F7CDB03D3_456565319 = (mPaddingLeft + dr.mDrawablePadding + dr.mDrawableSizeLeft);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1175644991 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1175644991;
        } //End block
        // ---------- Original Method ----------
        //final Drawables dr = mDrawables;
        //if (dr == null || dr.mDrawableLeft == null) {
            //return mPaddingLeft;
        //} else {
            //return mPaddingLeft + dr.mDrawablePadding + dr.mDrawableSizeLeft;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.468 -0400", hash_original_method = "FA75E1802F0BBA6FD5DC7258A0FBEB3C", hash_generated_method = "5F83055EC7CA53A4B38251CC4976BBDE")
    public int getCompoundPaddingRight() {
        final Drawables dr = mDrawables;
        if(dr == null || dr.mDrawableRight == null)        
        {
            int var1CC5609E099825B7F5335F0151334D28_1241141980 = (mPaddingRight);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1427856733 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1427856733;
        } //End block
        else
        {
            int varA4EA4BC279930BE5F57E5C3A44669976_1407862159 = (mPaddingRight + dr.mDrawablePadding + dr.mDrawableSizeRight);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_950863848 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_950863848;
        } //End block
        // ---------- Original Method ----------
        //final Drawables dr = mDrawables;
        //if (dr == null || dr.mDrawableRight == null) {
            //return mPaddingRight;
        //} else {
            //return mPaddingRight + dr.mDrawablePadding + dr.mDrawableSizeRight;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.468 -0400", hash_original_method = "045E56B45A145CD7B99AFA777E63AEB3", hash_generated_method = "7F54E30C7FD8D9D479D700D1437BB78B")
    public int getCompoundPaddingStart() {
        resolveDrawables();
switch(getResolvedLayoutDirection()){
        default:
        case LAYOUT_DIRECTION_LTR:
        int var3353C6B36CC1DEA8FB09AC09D3CFAAD5_1420578323 = (getCompoundPaddingLeft());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1012628735 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1012628735;
        case LAYOUT_DIRECTION_RTL:
        int var3DB127539974D486BFF485106247FD59_431509455 = (getCompoundPaddingRight());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_815131847 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_815131847;
}
        // ---------- Original Method ----------
        //resolveDrawables();
        //switch(getResolvedLayoutDirection()) {
            //default:
            //case LAYOUT_DIRECTION_LTR:
                //return getCompoundPaddingLeft();
            //case LAYOUT_DIRECTION_RTL:
                //return getCompoundPaddingRight();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.469 -0400", hash_original_method = "0C4A0FB6513BA7C283389B0C3E09BE68", hash_generated_method = "3DCCE766031696FFE55372B8989403EA")
    public int getCompoundPaddingEnd() {
        resolveDrawables();
switch(getResolvedLayoutDirection()){
        default:
        case LAYOUT_DIRECTION_LTR:
        int var3DB127539974D486BFF485106247FD59_715647408 = (getCompoundPaddingRight());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_554787790 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_554787790;
        case LAYOUT_DIRECTION_RTL:
        int var3353C6B36CC1DEA8FB09AC09D3CFAAD5_427678227 = (getCompoundPaddingLeft());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1135759958 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1135759958;
}
        // ---------- Original Method ----------
        //resolveDrawables();
        //switch(getResolvedLayoutDirection()) {
            //default:
            //case LAYOUT_DIRECTION_LTR:
                //return getCompoundPaddingRight();
            //case LAYOUT_DIRECTION_RTL:
                //return getCompoundPaddingLeft();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.469 -0400", hash_original_method = "363FF0B4BA7F59F6CC6EB59AE673A7C9", hash_generated_method = "04B3E00224F6EE5ADA18157C0F350BDA")
    public int getExtendedPaddingTop() {
        if(mMaxMode != LINES)        
        {
            int var19C6D004CA55CD1B0CB7EC9467D018E7_515335065 = (getCompoundPaddingTop());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_972615658 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_972615658;
        } //End block
        if(mLayout.getLineCount() <= mMaximum)        
        {
            int var19C6D004CA55CD1B0CB7EC9467D018E7_1415524175 = (getCompoundPaddingTop());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1873273945 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1873273945;
        } //End block
        int top = getCompoundPaddingTop();
        int bottom = getCompoundPaddingBottom();
        int viewht = getHeight() - top - bottom;
        int layoutht = mLayout.getLineTop(mMaximum);
        if(layoutht >= viewht)        
        {
            int varB28354B543375BFA94DABAEDA722927F_1801081495 = (top);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_121090367 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_121090367;
        } //End block
        final int gravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
        if(gravity == Gravity.TOP)        
        {
            int varB28354B543375BFA94DABAEDA722927F_1563691874 = (top);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1619437538 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1619437538;
        } //End block
        else
        if(gravity == Gravity.BOTTOM)        
        {
            int varEA997FF540462958FE034CE90ED0EFDA_210298356 = (top + viewht - layoutht);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2011403363 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2011403363;
        } //End block
        else
        {
            int var55D71CD0094D97C6DCE0C08D27A7EF4B_1731324709 = (top + (viewht - layoutht) / 2);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1683536950 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1683536950;
        } //End block
        // ---------- Original Method ----------
        //if (mMaxMode != LINES) {
            //return getCompoundPaddingTop();
        //}
        //if (mLayout.getLineCount() <= mMaximum) {
            //return getCompoundPaddingTop();
        //}
        //int top = getCompoundPaddingTop();
        //int bottom = getCompoundPaddingBottom();
        //int viewht = getHeight() - top - bottom;
        //int layoutht = mLayout.getLineTop(mMaximum);
        //if (layoutht >= viewht) {
            //return top;
        //}
        //final int gravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
        //if (gravity == Gravity.TOP) {
            //return top;
        //} else if (gravity == Gravity.BOTTOM) {
            //return top + viewht - layoutht;
        //} else { 
            //return top + (viewht - layoutht) / 2;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.469 -0400", hash_original_method = "7A2DB8BFB057F07CEDE0D120BE6FFB10", hash_generated_method = "A362D5BE92510D28B5EDE47372AAA07D")
    public int getExtendedPaddingBottom() {
        if(mMaxMode != LINES)        
        {
            int var7CDBDC99E7268C79446A0920E085A286_510249244 = (getCompoundPaddingBottom());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1138899424 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1138899424;
        } //End block
        if(mLayout.getLineCount() <= mMaximum)        
        {
            int var7CDBDC99E7268C79446A0920E085A286_635080907 = (getCompoundPaddingBottom());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1846280898 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1846280898;
        } //End block
        int top = getCompoundPaddingTop();
        int bottom = getCompoundPaddingBottom();
        int viewht = getHeight() - top - bottom;
        int layoutht = mLayout.getLineTop(mMaximum);
        if(layoutht >= viewht)        
        {
            int var71F262D796BED1AB30E8A2D5A8DDEE6F_576459778 = (bottom);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1722908078 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1722908078;
        } //End block
        final int gravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
        if(gravity == Gravity.TOP)        
        {
            int varA97E2C7E5128E3816749BEB660A966D3_577204040 = (bottom + viewht - layoutht);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1178194511 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1178194511;
        } //End block
        else
        if(gravity == Gravity.BOTTOM)        
        {
            int var71F262D796BED1AB30E8A2D5A8DDEE6F_1648083132 = (bottom);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1953848013 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1953848013;
        } //End block
        else
        {
            int var760F82260E71D41B9C503381788BD531_1096433550 = (bottom + (viewht - layoutht) / 2);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_589682316 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_589682316;
        } //End block
        // ---------- Original Method ----------
        //if (mMaxMode != LINES) {
            //return getCompoundPaddingBottom();
        //}
        //if (mLayout.getLineCount() <= mMaximum) {
            //return getCompoundPaddingBottom();
        //}
        //int top = getCompoundPaddingTop();
        //int bottom = getCompoundPaddingBottom();
        //int viewht = getHeight() - top - bottom;
        //int layoutht = mLayout.getLineTop(mMaximum);
        //if (layoutht >= viewht) {
            //return bottom;
        //}
        //final int gravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
        //if (gravity == Gravity.TOP) {
            //return bottom + viewht - layoutht;
        //} else if (gravity == Gravity.BOTTOM) {
            //return bottom;
        //} else { 
            //return bottom + (viewht - layoutht) / 2;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.470 -0400", hash_original_method = "5245DB1A490E586E6093F4BFC26117D1", hash_generated_method = "FC4E966A4B1BAE3C3DDC8CC15D50E7EA")
    public int getTotalPaddingLeft() {
        int var3353C6B36CC1DEA8FB09AC09D3CFAAD5_1655103137 = (getCompoundPaddingLeft());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1112665259 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1112665259;
        // ---------- Original Method ----------
        //return getCompoundPaddingLeft();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.470 -0400", hash_original_method = "A1EB6CC80DC85EDA662D4DD9C10BBDEB", hash_generated_method = "2923D47CBACACFB665B2FB6360B92BB3")
    public int getTotalPaddingRight() {
        int var3DB127539974D486BFF485106247FD59_625876842 = (getCompoundPaddingRight());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_841804724 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_841804724;
        // ---------- Original Method ----------
        //return getCompoundPaddingRight();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.470 -0400", hash_original_method = "DD9B038504EC66CC7FCB75AE1CB753E5", hash_generated_method = "9903C3D597544C265BA3D23C6B6FE364")
    public int getTotalPaddingStart() {
        int varD96BF295E010A241810EE4E0434B2A7F_94621545 = (getCompoundPaddingStart());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1149023727 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1149023727;
        // ---------- Original Method ----------
        //return getCompoundPaddingStart();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.470 -0400", hash_original_method = "7924A3AF5CA0D716DAB0CFDF1EC0C456", hash_generated_method = "F50EB25FBB61B65F44C97AAA9E2DF8E7")
    public int getTotalPaddingEnd() {
        int var296FC86CE38DE573A3CA62062723DC53_513419161 = (getCompoundPaddingEnd());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1943258775 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1943258775;
        // ---------- Original Method ----------
        //return getCompoundPaddingEnd();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.470 -0400", hash_original_method = "3FBB92A2EE65C62C674BD5E5A5FB2713", hash_generated_method = "0794ABBA712C9A4D76D13FC80DF6429D")
    public int getTotalPaddingTop() {
        int var6A8A3068E418AB9E97B0B0D025E9068F_1800255808 = (getExtendedPaddingTop() + getVerticalOffset(true));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1778725174 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1778725174;
        // ---------- Original Method ----------
        //return getExtendedPaddingTop() + getVerticalOffset(true);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.470 -0400", hash_original_method = "DD0E7E66835F9F938ABD11A206F39F98", hash_generated_method = "768DA3F09C897985A66C31F2EEE02009")
    public int getTotalPaddingBottom() {
        int varE339910705A0D6E72A384003FEFC7FC6_629781478 = (getExtendedPaddingBottom() + getBottomVerticalOffset(true));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_129614344 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_129614344;
        // ---------- Original Method ----------
        //return getExtendedPaddingBottom() + getBottomVerticalOffset(true);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.476 -0400", hash_original_method = "FDA2BF05D2CC3125A844DA2F1CDB97F3", hash_generated_method = "93AF47EAA4EF604C84585BB7D95091A5")
    public void setCompoundDrawables(Drawable left, Drawable top,
                                     Drawable right, Drawable bottom) {
        addTaint(bottom.getTaint());
        addTaint(right.getTaint());
        addTaint(top.getTaint());
        addTaint(left.getTaint());
        Drawables dr = mDrawables;
        final boolean drawables = left != null || top != null
                || right != null || bottom != null;
        if(!drawables)        
        {
            if(dr != null)            
            {
                if(dr.mDrawablePadding == 0)                
                {
                    mDrawables = null;
                } //End block
                else
                {
                    if(dr.mDrawableLeft != null)                    
                    dr.mDrawableLeft.setCallback(null);
                    dr.mDrawableLeft = null;
                    if(dr.mDrawableTop != null)                    
                    dr.mDrawableTop.setCallback(null);
                    dr.mDrawableTop = null;
                    if(dr.mDrawableRight != null)                    
                    dr.mDrawableRight.setCallback(null);
                    dr.mDrawableRight = null;
                    if(dr.mDrawableBottom != null)                    
                    dr.mDrawableBottom.setCallback(null);
                    dr.mDrawableBottom = null;
                    dr.mDrawableSizeLeft = dr.mDrawableHeightLeft = 0;
                    dr.mDrawableSizeRight = dr.mDrawableHeightRight = 0;
                    dr.mDrawableSizeTop = dr.mDrawableWidthTop = 0;
                    dr.mDrawableSizeBottom = dr.mDrawableWidthBottom = 0;
                } //End block
            } //End block
        } //End block
        else
        {
            if(dr == null)            
            {
                mDrawables = dr = new Drawables();
            } //End block
            if(dr.mDrawableLeft != left && dr.mDrawableLeft != null)            
            {
                dr.mDrawableLeft.setCallback(null);
            } //End block
            dr.mDrawableLeft = left;
            if(dr.mDrawableTop != top && dr.mDrawableTop != null)            
            {
                dr.mDrawableTop.setCallback(null);
            } //End block
            dr.mDrawableTop = top;
            if(dr.mDrawableRight != right && dr.mDrawableRight != null)            
            {
                dr.mDrawableRight.setCallback(null);
            } //End block
            dr.mDrawableRight = right;
            if(dr.mDrawableBottom != bottom && dr.mDrawableBottom != null)            
            {
                dr.mDrawableBottom.setCallback(null);
            } //End block
            dr.mDrawableBottom = bottom;
            final Rect compoundRect = dr.mCompoundRect;
            int[] state;
            state = getDrawableState();
            if(left != null)            
            {
                left.setState(state);
                left.copyBounds(compoundRect);
                left.setCallback(this);
                dr.mDrawableSizeLeft = compoundRect.width();
                dr.mDrawableHeightLeft = compoundRect.height();
            } //End block
            else
            {
                dr.mDrawableSizeLeft = dr.mDrawableHeightLeft = 0;
            } //End block
            if(right != null)            
            {
                right.setState(state);
                right.copyBounds(compoundRect);
                right.setCallback(this);
                dr.mDrawableSizeRight = compoundRect.width();
                dr.mDrawableHeightRight = compoundRect.height();
            } //End block
            else
            {
                dr.mDrawableSizeRight = dr.mDrawableHeightRight = 0;
            } //End block
            if(top != null)            
            {
                top.setState(state);
                top.copyBounds(compoundRect);
                top.setCallback(this);
                dr.mDrawableSizeTop = compoundRect.height();
                dr.mDrawableWidthTop = compoundRect.width();
            } //End block
            else
            {
                dr.mDrawableSizeTop = dr.mDrawableWidthTop = 0;
            } //End block
            if(bottom != null)            
            {
                bottom.setState(state);
                bottom.copyBounds(compoundRect);
                bottom.setCallback(this);
                dr.mDrawableSizeBottom = compoundRect.height();
                dr.mDrawableWidthBottom = compoundRect.width();
            } //End block
            else
            {
                dr.mDrawableSizeBottom = dr.mDrawableWidthBottom = 0;
            } //End block
        } //End block
        invalidate();
        requestLayout();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.478 -0400", hash_original_method = "4DA9B29500DC46492C6684BECC05C749", hash_generated_method = "49A403F66EC4CB306773329CE2007D33")
    public void setCompoundDrawablesWithIntrinsicBounds(int left, int top, int right, int bottom) {
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        final Resources resources = getContext().getResources();
        setCompoundDrawablesWithIntrinsicBounds(left != 0 ? resources.getDrawable(left) : null,
                top != 0 ? resources.getDrawable(top) : null,
                right != 0 ? resources.getDrawable(right) : null,
                bottom != 0 ? resources.getDrawable(bottom) : null);
        // ---------- Original Method ----------
        //final Resources resources = getContext().getResources();
        //setCompoundDrawablesWithIntrinsicBounds(left != 0 ? resources.getDrawable(left) : null,
                //top != 0 ? resources.getDrawable(top) : null,
                //right != 0 ? resources.getDrawable(right) : null,
                //bottom != 0 ? resources.getDrawable(bottom) : null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.478 -0400", hash_original_method = "19E536EC7FD9E8E0EBEABA79F37A1C35", hash_generated_method = "99CD8018020D49626EA385937BE40781")
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable left, Drawable top,
            Drawable right, Drawable bottom) {
        addTaint(bottom.getTaint());
        addTaint(right.getTaint());
        addTaint(top.getTaint());
        addTaint(left.getTaint());
        if(left != null)        
        {
            left.setBounds(0, 0, left.getIntrinsicWidth(), left.getIntrinsicHeight());
        } //End block
        if(right != null)        
        {
            right.setBounds(0, 0, right.getIntrinsicWidth(), right.getIntrinsicHeight());
        } //End block
        if(top != null)        
        {
            top.setBounds(0, 0, top.getIntrinsicWidth(), top.getIntrinsicHeight());
        } //End block
        if(bottom != null)        
        {
            bottom.setBounds(0, 0, bottom.getIntrinsicWidth(), bottom.getIntrinsicHeight());
        } //End block
        setCompoundDrawables(left, top, right, bottom);
        // ---------- Original Method ----------
        //if (left != null) {
            //left.setBounds(0, 0, left.getIntrinsicWidth(), left.getIntrinsicHeight());
        //}
        //if (right != null) {
            //right.setBounds(0, 0, right.getIntrinsicWidth(), right.getIntrinsicHeight());
        //}
        //if (top != null) {
            //top.setBounds(0, 0, top.getIntrinsicWidth(), top.getIntrinsicHeight());
        //}
        //if (bottom != null) {
            //bottom.setBounds(0, 0, bottom.getIntrinsicWidth(), bottom.getIntrinsicHeight());
        //}
        //setCompoundDrawables(left, top, right, bottom);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.483 -0400", hash_original_method = "C527F166CA85E985387BA0B670132163", hash_generated_method = "C2ED55DCDE94060E62556ACF1848CB68")
    public void setCompoundDrawablesRelative(Drawable start, Drawable top,
                                     Drawable end, Drawable bottom) {
        addTaint(bottom.getTaint());
        addTaint(end.getTaint());
        addTaint(top.getTaint());
        addTaint(start.getTaint());
        Drawables dr = mDrawables;
        final boolean drawables = start != null || top != null
                || end != null || bottom != null;
        if(!drawables)        
        {
            if(dr != null)            
            {
                if(dr.mDrawablePadding == 0)                
                {
                    mDrawables = null;
                } //End block
                else
                {
                    if(dr.mDrawableStart != null)                    
                    dr.mDrawableStart.setCallback(null);
                    dr.mDrawableStart = null;
                    if(dr.mDrawableTop != null)                    
                    dr.mDrawableTop.setCallback(null);
                    dr.mDrawableTop = null;
                    if(dr.mDrawableEnd != null)                    
                    dr.mDrawableEnd.setCallback(null);
                    dr.mDrawableEnd = null;
                    if(dr.mDrawableBottom != null)                    
                    dr.mDrawableBottom.setCallback(null);
                    dr.mDrawableBottom = null;
                    dr.mDrawableSizeStart = dr.mDrawableHeightStart = 0;
                    dr.mDrawableSizeEnd = dr.mDrawableHeightEnd = 0;
                    dr.mDrawableSizeTop = dr.mDrawableWidthTop = 0;
                    dr.mDrawableSizeBottom = dr.mDrawableWidthBottom = 0;
                } //End block
            } //End block
        } //End block
        else
        {
            if(dr == null)            
            {
                mDrawables = dr = new Drawables();
            } //End block
            if(dr.mDrawableStart != start && dr.mDrawableStart != null)            
            {
                dr.mDrawableStart.setCallback(null);
            } //End block
            dr.mDrawableStart = start;
            if(dr.mDrawableTop != top && dr.mDrawableTop != null)            
            {
                dr.mDrawableTop.setCallback(null);
            } //End block
            dr.mDrawableTop = top;
            if(dr.mDrawableEnd != end && dr.mDrawableEnd != null)            
            {
                dr.mDrawableEnd.setCallback(null);
            } //End block
            dr.mDrawableEnd = end;
            if(dr.mDrawableBottom != bottom && dr.mDrawableBottom != null)            
            {
                dr.mDrawableBottom.setCallback(null);
            } //End block
            dr.mDrawableBottom = bottom;
            final Rect compoundRect = dr.mCompoundRect;
            int[] state;
            state = getDrawableState();
            if(start != null)            
            {
                start.setState(state);
                start.copyBounds(compoundRect);
                start.setCallback(this);
                dr.mDrawableSizeStart = compoundRect.width();
                dr.mDrawableHeightStart = compoundRect.height();
            } //End block
            else
            {
                dr.mDrawableSizeStart = dr.mDrawableHeightStart = 0;
            } //End block
            if(end != null)            
            {
                end.setState(state);
                end.copyBounds(compoundRect);
                end.setCallback(this);
                dr.mDrawableSizeEnd = compoundRect.width();
                dr.mDrawableHeightEnd = compoundRect.height();
            } //End block
            else
            {
                dr.mDrawableSizeEnd = dr.mDrawableHeightEnd = 0;
            } //End block
            if(top != null)            
            {
                top.setState(state);
                top.copyBounds(compoundRect);
                top.setCallback(this);
                dr.mDrawableSizeTop = compoundRect.height();
                dr.mDrawableWidthTop = compoundRect.width();
            } //End block
            else
            {
                dr.mDrawableSizeTop = dr.mDrawableWidthTop = 0;
            } //End block
            if(bottom != null)            
            {
                bottom.setState(state);
                bottom.copyBounds(compoundRect);
                bottom.setCallback(this);
                dr.mDrawableSizeBottom = compoundRect.height();
                dr.mDrawableWidthBottom = compoundRect.width();
            } //End block
            else
            {
                dr.mDrawableSizeBottom = dr.mDrawableWidthBottom = 0;
            } //End block
        } //End block
        resolveDrawables();
        invalidate();
        requestLayout();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.483 -0400", hash_original_method = "08DFFEC64B0A3553E53B210C6E8B4F5B", hash_generated_method = "E68E20D911B5F3E1A1CF38831F2BA878")
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int start, int top, int end,
            int bottom) {
        addTaint(bottom);
        addTaint(end);
        addTaint(top);
        addTaint(start);
        resetResolvedDrawables();
        final Resources resources = getContext().getResources();
        setCompoundDrawablesRelativeWithIntrinsicBounds(
                start != 0 ? resources.getDrawable(start) : null,
                top != 0 ? resources.getDrawable(top) : null,
                end != 0 ? resources.getDrawable(end) : null,
                bottom != 0 ? resources.getDrawable(bottom) : null);
        // ---------- Original Method ----------
        //resetResolvedDrawables();
        //final Resources resources = getContext().getResources();
        //setCompoundDrawablesRelativeWithIntrinsicBounds(
                //start != 0 ? resources.getDrawable(start) : null,
                //top != 0 ? resources.getDrawable(top) : null,
                //end != 0 ? resources.getDrawable(end) : null,
                //bottom != 0 ? resources.getDrawable(bottom) : null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.483 -0400", hash_original_method = "BA79780015035B80B72E7A4B08D0D299", hash_generated_method = "4763484DE245AD4B101D7D43B43B232E")
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable start, Drawable top,
            Drawable end, Drawable bottom) {
        addTaint(bottom.getTaint());
        addTaint(end.getTaint());
        addTaint(top.getTaint());
        addTaint(start.getTaint());
        resetResolvedDrawables();
        if(start != null)        
        {
            start.setBounds(0, 0, start.getIntrinsicWidth(), start.getIntrinsicHeight());
        } //End block
        if(end != null)        
        {
            end.setBounds(0, 0, end.getIntrinsicWidth(), end.getIntrinsicHeight());
        } //End block
        if(top != null)        
        {
            top.setBounds(0, 0, top.getIntrinsicWidth(), top.getIntrinsicHeight());
        } //End block
        if(bottom != null)        
        {
            bottom.setBounds(0, 0, bottom.getIntrinsicWidth(), bottom.getIntrinsicHeight());
        } //End block
        setCompoundDrawablesRelative(start, top, end, bottom);
        // ---------- Original Method ----------
        //resetResolvedDrawables();
        //if (start != null) {
            //start.setBounds(0, 0, start.getIntrinsicWidth(), start.getIntrinsicHeight());
        //}
        //if (end != null) {
            //end.setBounds(0, 0, end.getIntrinsicWidth(), end.getIntrinsicHeight());
        //}
        //if (top != null) {
            //top.setBounds(0, 0, top.getIntrinsicWidth(), top.getIntrinsicHeight());
        //}
        //if (bottom != null) {
            //bottom.setBounds(0, 0, bottom.getIntrinsicWidth(), bottom.getIntrinsicHeight());
        //}
        //setCompoundDrawablesRelative(start, top, end, bottom);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.484 -0400", hash_original_method = "06FDA6F654D58A3BC65C29C47124F71A", hash_generated_method = "0A9B5469E7F24FA39AB28FB8907044DC")
    public Drawable[] getCompoundDrawables() {
        final Drawables dr = mDrawables;
        if(dr != null)        
        {
Drawable[] var510123C8569E461FDC6D3F71964FC916_543884074 =             new Drawable[] {
                dr.mDrawableLeft, dr.mDrawableTop, dr.mDrawableRight, dr.mDrawableBottom
            };
            var510123C8569E461FDC6D3F71964FC916_543884074.addTaint(taint);
            return var510123C8569E461FDC6D3F71964FC916_543884074;
        } //End block
        else
        {
Drawable[] var8AF6B8D0C037740A6C904DF75997E231_197562459 =             new Drawable[] { null, null, null, null };
            var8AF6B8D0C037740A6C904DF75997E231_197562459.addTaint(taint);
            return var8AF6B8D0C037740A6C904DF75997E231_197562459;
        } //End block
        // ---------- Original Method ----------
        //final Drawables dr = mDrawables;
        //if (dr != null) {
            //return new Drawable[] {
                //dr.mDrawableLeft, dr.mDrawableTop, dr.mDrawableRight, dr.mDrawableBottom
            //};
        //} else {
            //return new Drawable[] { null, null, null, null };
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.484 -0400", hash_original_method = "7D536599368FF7E7773D59B2D0C7C092", hash_generated_method = "BE0A82F880DAA714F81972683C57DB1C")
    public Drawable[] getCompoundDrawablesRelative() {
        final Drawables dr = mDrawables;
        if(dr != null)        
        {
Drawable[] var862F8A46EC7BFEC321C93C54409DEADB_1400471337 =             new Drawable[] {
                dr.mDrawableStart, dr.mDrawableTop, dr.mDrawableEnd, dr.mDrawableBottom
            };
            var862F8A46EC7BFEC321C93C54409DEADB_1400471337.addTaint(taint);
            return var862F8A46EC7BFEC321C93C54409DEADB_1400471337;
        } //End block
        else
        {
Drawable[] var8AF6B8D0C037740A6C904DF75997E231_781259141 =             new Drawable[] { null, null, null, null };
            var8AF6B8D0C037740A6C904DF75997E231_781259141.addTaint(taint);
            return var8AF6B8D0C037740A6C904DF75997E231_781259141;
        } //End block
        // ---------- Original Method ----------
        //final Drawables dr = mDrawables;
        //if (dr != null) {
            //return new Drawable[] {
                //dr.mDrawableStart, dr.mDrawableTop, dr.mDrawableEnd, dr.mDrawableBottom
            //};
        //} else {
            //return new Drawable[] { null, null, null, null };
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.484 -0400", hash_original_method = "7E4DBC59802038B0E00C34B579D2DA37", hash_generated_method = "A8FFE9AB32192CF67BB3C85F4A5BE6DB")
    public void setCompoundDrawablePadding(int pad) {
        addTaint(pad);
        Drawables dr = mDrawables;
        if(pad == 0)        
        {
            if(dr != null)            
            {
                dr.mDrawablePadding = pad;
            } //End block
        } //End block
        else
        {
            if(dr == null)            
            {
                mDrawables = dr = new Drawables();
            } //End block
            dr.mDrawablePadding = pad;
        } //End block
        invalidate();
        requestLayout();
        // ---------- Original Method ----------
        //Drawables dr = mDrawables;
        //if (pad == 0) {
            //if (dr != null) {
                //dr.mDrawablePadding = pad;
            //}
        //} else {
            //if (dr == null) {
                //mDrawables = dr = new Drawables();
            //}
            //dr.mDrawablePadding = pad;
        //}
        //invalidate();
        //requestLayout();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.484 -0400", hash_original_method = "6B458DA6759E58857DA3CAF4E6D1B789", hash_generated_method = "AA37C8E32AD58A3EC6F5F4CA3959D95B")
    public int getCompoundDrawablePadding() {
        final Drawables dr = mDrawables;
        int varB00DBCDAF054B146D521710A72E82C31_1224823613 = (dr != null ? dr.mDrawablePadding : 0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_388106771 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_388106771;
        // ---------- Original Method ----------
        //final Drawables dr = mDrawables;
        //return dr != null ? dr.mDrawablePadding : 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.489 -0400", hash_original_method = "4C42E9479946D6D8F38619DA66232863", hash_generated_method = "EC3543F52D5862E0A63FA74310E42E47")
    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        if(left != mPaddingLeft ||
            right != mPaddingRight ||
            top != mPaddingTop ||
            bottom != mPaddingBottom)        
        {
            nullLayouts();
        } //End block
        super.setPadding(left, top, right, bottom);
        invalidate();
        // ---------- Original Method ----------
        //if (left != mPaddingLeft ||
            //right != mPaddingRight ||
            //top != mPaddingTop ||
            //bottom != mPaddingBottom) {
            //nullLayouts();
        //}
        //super.setPadding(left, top, right, bottom);
        //invalidate();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.489 -0400", hash_original_method = "D796BA921A3359840CCD26FF0DD1CFB0", hash_generated_method = "B01AFBFDD57023049DF49D6EB9A9C8D1")
    public final int getAutoLinkMask() {
        int var6B1804E483F3EF95C329AD84689BA27C_598199133 = (mAutoLinkMask);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1238171665 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1238171665;
        // ---------- Original Method ----------
        //return mAutoLinkMask;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.490 -0400", hash_original_method = "FFEF779179433D30901B486DA8C4C9D0", hash_generated_method = "5845ED60E8A9004903181D9309075D27")
    public void setTextAppearance(Context context, int resid) {
        addTaint(resid);
        addTaint(context.getTaint());
        TypedArray appearance = context.obtainStyledAttributes(resid,
                                           com.android.internal.R.styleable.TextAppearance);
        int color;
        ColorStateList colors;
        int ts;
        color = appearance.getColor(com.android.internal.R.styleable.TextAppearance_textColorHighlight, 0);
        if(color != 0)        
        {
            setHighlightColor(color);
        } //End block
        colors = appearance.getColorStateList(com.android.internal.R.styleable.
                                              TextAppearance_textColor);
        if(colors != null)        
        {
            setTextColor(colors);
        } //End block
        ts = appearance.getDimensionPixelSize(com.android.internal.R.styleable.
                                              TextAppearance_textSize, 0);
        if(ts != 0)        
        {
            setRawTextSize(ts);
        } //End block
        colors = appearance.getColorStateList(com.android.internal.R.styleable.
                                              TextAppearance_textColorHint);
        if(colors != null)        
        {
            setHintTextColor(colors);
        } //End block
        colors = appearance.getColorStateList(com.android.internal.R.styleable.
                                              TextAppearance_textColorLink);
        if(colors != null)        
        {
            setLinkTextColor(colors);
        } //End block
        int typefaceIndex;
        int styleIndex;
        typefaceIndex = appearance.getInt(com.android.internal.R.styleable.
                                          TextAppearance_typeface, -1);
        styleIndex = appearance.getInt(com.android.internal.R.styleable.
                                       TextAppearance_textStyle, -1);
        setTypefaceByIndex(typefaceIndex, styleIndex);
        if(appearance.getBoolean(com.android.internal.R.styleable.TextAppearance_textAllCaps,
                false))        
        {
            setTransformationMethod(new AllCapsTransformationMethod(getContext()));
        } //End block
        appearance.recycle();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.490 -0400", hash_original_method = "5E6FE671862457C6BB25EDC2CEDE399B", hash_generated_method = "99022B3E06B7FAED638878DF5AAD7687")
    public float getTextSize() {
        float varC4DE2306614577205145811A3E1AE15E_2066747137 = (mTextPaint.getTextSize());
                float var546ADE640B6EDFBC8A086EF31347E768_597468846 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_597468846;
        // ---------- Original Method ----------
        //return mTextPaint.getTextSize();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.491 -0400", hash_original_method = "7DB2A551583349AB1C418E0528006365", hash_generated_method = "4312A90EC9FD7DA5739C9C9CC8D90C9A")
    @android.view.RemotableViewMethod
    public void setTextSize(float size) {
        addTaint(size);
        setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        // ---------- Original Method ----------
        //setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.491 -0400", hash_original_method = "487975E6A0CF72E721F7BDECB44E1312", hash_generated_method = "FB68E31AED66656876B64C2C03E3AA63")
    public void setTextSize(int unit, float size) {
        addTaint(size);
        addTaint(unit);
        Context c = getContext();
        Resources r;
        if(c == null)        
        r = Resources.getSystem();
        else
        r = c.getResources();
        setRawTextSize(TypedValue.applyDimension(
            unit, size, r.getDisplayMetrics()));
        // ---------- Original Method ----------
        //Context c = getContext();
        //Resources r;
        //if (c == null)
            //r = Resources.getSystem();
        //else
            //r = c.getResources();
        //setRawTextSize(TypedValue.applyDimension(
            //unit, size, r.getDisplayMetrics()));
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.491 -0400", hash_original_method = "ADDFE88D6F3490AE157EE578011F4FFC", hash_generated_method = "A1840A52E810F8F0E2FA363DA0E98663")
    private void setRawTextSize(float size) {
        addTaint(size);
        if(size != mTextPaint.getTextSize())        
        {
            mTextPaint.setTextSize(size);
            if(mLayout != null)            
            {
                nullLayouts();
                requestLayout();
                invalidate();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (size != mTextPaint.getTextSize()) {
            //mTextPaint.setTextSize(size);
            //if (mLayout != null) {
                //nullLayouts();
                //requestLayout();
                //invalidate();
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.491 -0400", hash_original_method = "8F71F8091E79DE5D49BC786B53F6B56F", hash_generated_method = "8283F302CC45D510DCABB097A06C8A9C")
    public float getTextScaleX() {
        float varA16450B0EDA507056FDD9A484754B841_1565851661 = (mTextPaint.getTextScaleX());
                float var546ADE640B6EDFBC8A086EF31347E768_1152480095 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1152480095;
        // ---------- Original Method ----------
        //return mTextPaint.getTextScaleX();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.491 -0400", hash_original_method = "32FC23A8E8D24759E03CF98EE692BD3E", hash_generated_method = "8A13558A473C52107C21707835EA8E86")
    @android.view.RemotableViewMethod
    public void setTextScaleX(float size) {
        addTaint(size);
        if(size != mTextPaint.getTextScaleX())        
        {
            mUserSetTextScaleX = true;
            mTextPaint.setTextScaleX(size);
            if(mLayout != null)            
            {
                nullLayouts();
                requestLayout();
                invalidate();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (size != mTextPaint.getTextScaleX()) {
            //mUserSetTextScaleX = true;
            //mTextPaint.setTextScaleX(size);
            //if (mLayout != null) {
                //nullLayouts();
                //requestLayout();
                //invalidate();
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.492 -0400", hash_original_method = "780D15535FA403FCFD3F32D6E7303769", hash_generated_method = "09FB0D55756685A02221E0BE37029B88")
    public void setTypeface(Typeface tf) {
        addTaint(tf.getTaint());
        if(mTextPaint.getTypeface() != tf)        
        {
            mTextPaint.setTypeface(tf);
            if(mLayout != null)            
            {
                nullLayouts();
                requestLayout();
                invalidate();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mTextPaint.getTypeface() != tf) {
            //mTextPaint.setTypeface(tf);
            //if (mLayout != null) {
                //nullLayouts();
                //requestLayout();
                //invalidate();
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.493 -0400", hash_original_method = "6FFDE601A24D081BE5F9A52F7BB654E9", hash_generated_method = "A3053B28BBB168F8DCA58442E2D7446F")
    public Typeface getTypeface() {
Typeface varF24EEB54514982F272375F00DA72E131_2146003757 =         mTextPaint.getTypeface();
        varF24EEB54514982F272375F00DA72E131_2146003757.addTaint(taint);
        return varF24EEB54514982F272375F00DA72E131_2146003757;
        // ---------- Original Method ----------
        //return mTextPaint.getTypeface();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.493 -0400", hash_original_method = "7D6C422943C1CBA6B222D2B0CA531386", hash_generated_method = "2CAC8DF2A1AC7DE030CB2AA266620CF2")
    @android.view.RemotableViewMethod
    public void setTextColor(int color) {
        mTextColor = ColorStateList.valueOf(color);
        updateTextColors();
        // ---------- Original Method ----------
        //mTextColor = ColorStateList.valueOf(color);
        //updateTextColors();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.493 -0400", hash_original_method = "E5548FB85C1126384CE08AD8E1667A0C", hash_generated_method = "D4B9006FF411D4A21F7A933E3EA89D5E")
    public void setTextColor(ColorStateList colors) {
        if(colors == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_921502135 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_921502135.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_921502135;
        } //End block
        mTextColor = colors;
        updateTextColors();
        // ---------- Original Method ----------
        //if (colors == null) {
            //throw new NullPointerException();
        //}
        //mTextColor = colors;
        //updateTextColors();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.493 -0400", hash_original_method = "E9708E6780595497A0F38B1A3DFD4921", hash_generated_method = "F0C27B1EC5051D6FCABCAB59121206D4")
    public final ColorStateList getTextColors() {
ColorStateList varF2B26C798C9C7016812AC3DA166887CA_1617691485 =         mTextColor;
        varF2B26C798C9C7016812AC3DA166887CA_1617691485.addTaint(taint);
        return varF2B26C798C9C7016812AC3DA166887CA_1617691485;
        // ---------- Original Method ----------
        //return mTextColor;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.493 -0400", hash_original_method = "69BC167CA8CC0024E4446D6ED57F972B", hash_generated_method = "C263D4A1B6212B73FC210FC9F5F580E4")
    public final int getCurrentTextColor() {
        int var284F9A87F549A6DC680E2D58A116EBA3_461519401 = (mCurTextColor);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2146316427 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2146316427;
        // ---------- Original Method ----------
        //return mCurTextColor;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.493 -0400", hash_original_method = "969DDD835D55F329C6E2048E92EE3D41", hash_generated_method = "0FB619AD26748B647A9CAEBFCAD2CBC3")
    @android.view.RemotableViewMethod
    public void setHighlightColor(int color) {
        if(mHighlightColor != color)        
        {
            mHighlightColor = color;
            invalidate();
        } //End block
        // ---------- Original Method ----------
        //if (mHighlightColor != color) {
            //mHighlightColor = color;
            //invalidate();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.495 -0400", hash_original_method = "5ADAC484D4689A7795B408EA7D6B6AC8", hash_generated_method = "52552F602C8266D72210A8E6957E5356")
    public void setShadowLayer(float radius, float dx, float dy, int color) {
        addTaint(color);
        mTextPaint.setShadowLayer(radius, dx, dy, color);
        mShadowRadius = radius;
        mShadowDx = dx;
        mShadowDy = dy;
        invalidate();
        // ---------- Original Method ----------
        //mTextPaint.setShadowLayer(radius, dx, dy, color);
        //mShadowRadius = radius;
        //mShadowDx = dx;
        //mShadowDy = dy;
        //invalidate();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.495 -0400", hash_original_method = "5B4E8CD3DF4A8D21F89EBB7BF27B30F6", hash_generated_method = "F4A903E260F4705928AEB600308A62A0")
    public TextPaint getPaint() {
TextPaint varE880FA4A538A98A742549F39B8188016_1333281727 =         mTextPaint;
        varE880FA4A538A98A742549F39B8188016_1333281727.addTaint(taint);
        return varE880FA4A538A98A742549F39B8188016_1333281727;
        // ---------- Original Method ----------
        //return mTextPaint;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.495 -0400", hash_original_method = "9B238C42610AAE77586EFF469787CAA2", hash_generated_method = "C5BD2E157496886451F125CEBC428118")
    @android.view.RemotableViewMethod
    public final void setAutoLinkMask(int mask) {
        mAutoLinkMask = mask;
        // ---------- Original Method ----------
        //mAutoLinkMask = mask;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.495 -0400", hash_original_method = "E276016FD2FFF976FC669270E78164FC", hash_generated_method = "212E0D71E4818E9438373D71E959C472")
    @android.view.RemotableViewMethod
    public final void setLinksClickable(boolean whether) {
        mLinksClickable = whether;
        // ---------- Original Method ----------
        //mLinksClickable = whether;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.495 -0400", hash_original_method = "5582C38299F4F11EB9D233BD445CE8CA", hash_generated_method = "DB2EBD0A37EAE5915113CFD1E88DF9B2")
    public final boolean getLinksClickable() {
        boolean varFF33C163F249C6474E08FBBDFE0B6FC3_1858548177 = (mLinksClickable);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1576956919 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1576956919;
        // ---------- Original Method ----------
        //return mLinksClickable;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.495 -0400", hash_original_method = "4DF4A96EB5A0519062801E1FD0A991F4", hash_generated_method = "42E09EA41E686980C7CA000206A8DDAD")
    @android.view.RemotableViewMethod
    public final void setSoftInputShownOnFocus(boolean show) {
        mSoftInputShownOnFocus = show;
        // ---------- Original Method ----------
        //mSoftInputShownOnFocus = show;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.499 -0400", hash_original_method = "5A10A6630E4A15A93780A83DCE21BFA6", hash_generated_method = "8DBE61BF25EF0C94E352537A14D6ACF3")
    public final boolean getSoftInputShownOnFocus() {
        boolean var245B301582F9EB0E74511ADD316E8BC0_141799199 = (mSoftInputShownOnFocus);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_248573415 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_248573415;
        // ---------- Original Method ----------
        //return mSoftInputShownOnFocus;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.499 -0400", hash_original_method = "7722BA5204257A1CDED1550384208856", hash_generated_method = "B38499220F0E7BCC78C71DC28A91BA03")
    public URLSpan[] getUrls() {
        if(mText instanceof Spanned)        
        {
URLSpan[] var9621C20FEECFC55525483076D141A922_19497625 =             ((Spanned) mText).getSpans(0, mText.length(), URLSpan.class);
            var9621C20FEECFC55525483076D141A922_19497625.addTaint(taint);
            return var9621C20FEECFC55525483076D141A922_19497625;
        } //End block
        else
        {
URLSpan[] varBE572D67EA9D43E9D0DBF1E4DEA9C68F_1433097671 =             new URLSpan[0];
            varBE572D67EA9D43E9D0DBF1E4DEA9C68F_1433097671.addTaint(taint);
            return varBE572D67EA9D43E9D0DBF1E4DEA9C68F_1433097671;
        } //End block
        // ---------- Original Method ----------
        //if (mText instanceof Spanned) {
            //return ((Spanned) mText).getSpans(0, mText.length(), URLSpan.class);
        //} else {
            //return new URLSpan[0];
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.499 -0400", hash_original_method = "E9B4A1B921938A82A5322DAF3992AE5D", hash_generated_method = "43DB0F7D23C2BA38E919E41FE56D752D")
    @android.view.RemotableViewMethod
    public final void setHintTextColor(int color) {
        mHintTextColor = ColorStateList.valueOf(color);
        updateTextColors();
        // ---------- Original Method ----------
        //mHintTextColor = ColorStateList.valueOf(color);
        //updateTextColors();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.499 -0400", hash_original_method = "FDEA4F057DD6E07AD523C7053B227866", hash_generated_method = "579A043E994B5BCBDC50DABB884C27C2")
    public final void setHintTextColor(ColorStateList colors) {
        mHintTextColor = colors;
        updateTextColors();
        // ---------- Original Method ----------
        //mHintTextColor = colors;
        //updateTextColors();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.499 -0400", hash_original_method = "475EC0453C7F74E6A779EAD7F8319059", hash_generated_method = "F571EBF794633A1B182C58213B08E84E")
    public final ColorStateList getHintTextColors() {
ColorStateList varFA8F3ADA5312469EC207883E4BA3EC19_17313548 =         mHintTextColor;
        varFA8F3ADA5312469EC207883E4BA3EC19_17313548.addTaint(taint);
        return varFA8F3ADA5312469EC207883E4BA3EC19_17313548;
        // ---------- Original Method ----------
        //return mHintTextColor;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.499 -0400", hash_original_method = "1826756F3CA2F0D97D555C81DC90D9D1", hash_generated_method = "E6C375B187D43EB29BD2DB0C562B785C")
    public final int getCurrentHintTextColor() {
        int varE7E896DB0D1D5BDFED8CE12F380DEB60_1765511098 = (mHintTextColor != null ? mCurHintTextColor : mCurTextColor);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1287469294 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1287469294;
        // ---------- Original Method ----------
        //return mHintTextColor != null ? mCurHintTextColor : mCurTextColor;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.500 -0400", hash_original_method = "9463279339C3C6EB304729CC6A96FD58", hash_generated_method = "57F482ABFE2EE8E9CEF1E8E3D393E6FC")
    @android.view.RemotableViewMethod
    public final void setLinkTextColor(int color) {
        mLinkTextColor = ColorStateList.valueOf(color);
        updateTextColors();
        // ---------- Original Method ----------
        //mLinkTextColor = ColorStateList.valueOf(color);
        //updateTextColors();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.501 -0400", hash_original_method = "9B67E7CBCE87C562841DDA31DA1BE653", hash_generated_method = "037C9825FD527ACDA5C188EDE566FA86")
    public final void setLinkTextColor(ColorStateList colors) {
        mLinkTextColor = colors;
        updateTextColors();
        // ---------- Original Method ----------
        //mLinkTextColor = colors;
        //updateTextColors();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.501 -0400", hash_original_method = "3A49B90BEACC4CBB32A44A5B9C48739C", hash_generated_method = "E3A0578D2A3DB30BEB3B87F6DA99A023")
    public final ColorStateList getLinkTextColors() {
ColorStateList var4BA4E95152DD8A9DC8BCC5120D474C55_582692353 =         mLinkTextColor;
        var4BA4E95152DD8A9DC8BCC5120D474C55_582692353.addTaint(taint);
        return var4BA4E95152DD8A9DC8BCC5120D474C55_582692353;
        // ---------- Original Method ----------
        //return mLinkTextColor;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.501 -0400", hash_original_method = "AEAA45BF8B2B9C05CF6AA4E644080F44", hash_generated_method = "93AF289BCB83FC730CF08F08D7624179")
    public void setGravity(int gravity) {
        if((gravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 0)        
        {
            gravity |= Gravity.START;
        } //End block
        if((gravity & Gravity.VERTICAL_GRAVITY_MASK) == 0)        
        {
            gravity |= Gravity.TOP;
        } //End block
        boolean newLayout = false;
        if((gravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) !=
            (mGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK))        
        {
            newLayout = true;
        } //End block
        if(gravity != mGravity)        
        {
            invalidate();
            mLayoutAlignment = null;
        } //End block
        mGravity = gravity;
        if(mLayout != null && newLayout)        
        {
            int want = mLayout.getWidth();
            int hintWant = mHintLayout == null ? 0 : mHintLayout.getWidth();
            makeNewLayout(want, hintWant, UNKNOWN_BORING, UNKNOWN_BORING,
                          mRight - mLeft - getCompoundPaddingLeft() -
                          getCompoundPaddingRight(), true);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.501 -0400", hash_original_method = "80A4065F7A7EA77AF4C4ADD19E36F9A5", hash_generated_method = "0FD6608497004EB8D028F8399A6C87E8")
    public int getGravity() {
        int var1DE05384A4316AFED99BFDA3AA41DEF9_1407136597 = (mGravity);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1388152762 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1388152762;
        // ---------- Original Method ----------
        //return mGravity;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.504 -0400", hash_original_method = "7C7AF1B698E75A76793B55FAC07B7AAB", hash_generated_method = "65655A4FFDFCAF294C747340661753E8")
    public int getPaintFlags() {
        int varB45B9FBF90ABB4F8FEEC44E5EF181E96_976904152 = (mTextPaint.getFlags());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1465955479 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1465955479;
        // ---------- Original Method ----------
        //return mTextPaint.getFlags();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.505 -0400", hash_original_method = "8002046373E96371B4D25FE3E547C1A2", hash_generated_method = "74B0046E9CF2715C150998912D171164")
    @android.view.RemotableViewMethod
    public void setPaintFlags(int flags) {
        addTaint(flags);
        if(mTextPaint.getFlags() != flags)        
        {
            mTextPaint.setFlags(flags);
            if(mLayout != null)            
            {
                nullLayouts();
                requestLayout();
                invalidate();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mTextPaint.getFlags() != flags) {
            //mTextPaint.setFlags(flags);
            //if (mLayout != null) {
                //nullLayouts();
                //requestLayout();
                //invalidate();
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.512 -0400", hash_original_method = "EA5DCBED1A48E34EEA6259FD93E64EB0", hash_generated_method = "C9A53BFA05E2E0FAD1C145E17BCFEE67")
    public void setHorizontallyScrolling(boolean whether) {
        if(mHorizontallyScrolling != whether)        
        {
            mHorizontallyScrolling = whether;
            if(mLayout != null)            
            {
                nullLayouts();
                requestLayout();
                invalidate();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mHorizontallyScrolling != whether) {
            //mHorizontallyScrolling = whether;
            //if (mLayout != null) {
                //nullLayouts();
                //requestLayout();
                //invalidate();
            //}
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.513 -0400", hash_original_method = "7B94D421E91473A8A956329EBDF6A0E9", hash_generated_method = "B162B70BBD8EBA4C8AA5BA456461CFC3")
    public boolean getHorizontallyScrolling() {
        boolean varF2C627B045ED0B6F456489886DDF0435_1433037800 = (mHorizontallyScrolling);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_845118454 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_845118454;
        // ---------- Original Method ----------
        //return mHorizontallyScrolling;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.513 -0400", hash_original_method = "0EE7081F083B0DC579019805442C8765", hash_generated_method = "4C59F2ED9822C6DB05B6F45EB0296D69")
    @android.view.RemotableViewMethod
    public void setMinLines(int minlines) {
        mMinimum = minlines;
        mMinMode = LINES;
        requestLayout();
        invalidate();
        // ---------- Original Method ----------
        //mMinimum = minlines;
        //mMinMode = LINES;
        //requestLayout();
        //invalidate();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.513 -0400", hash_original_method = "68757877A1DD20E33F15DE32FA3B7F07", hash_generated_method = "0A56EF1698F37084B430195320861A57")
    @android.view.RemotableViewMethod
    public void setMinHeight(int minHeight) {
        mMinimum = minHeight;
        mMinMode = PIXELS;
        requestLayout();
        invalidate();
        // ---------- Original Method ----------
        //mMinimum = minHeight;
        //mMinMode = PIXELS;
        //requestLayout();
        //invalidate();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.516 -0400", hash_original_method = "8B36C1E1F9FD83BB5DA2A8A03A7A6664", hash_generated_method = "B2A20E5243DB69815414D52E2FE309B6")
    @android.view.RemotableViewMethod
    public void setMaxLines(int maxlines) {
        mMaximum = maxlines;
        mMaxMode = LINES;
        requestLayout();
        invalidate();
        // ---------- Original Method ----------
        //mMaximum = maxlines;
        //mMaxMode = LINES;
        //requestLayout();
        //invalidate();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.516 -0400", hash_original_method = "04C4C22BF9024D43E2A856D219B26DEF", hash_generated_method = "454D6005CAD9F205FEF255C979D08AF9")
    @android.view.RemotableViewMethod
    public void setMaxHeight(int maxHeight) {
        mMaximum = maxHeight;
        mMaxMode = PIXELS;
        requestLayout();
        invalidate();
        // ---------- Original Method ----------
        //mMaximum = maxHeight;
        //mMaxMode = PIXELS;
        //requestLayout();
        //invalidate();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.516 -0400", hash_original_method = "1ADF089518552DEF85C429E373D0543D", hash_generated_method = "BFBDB748B0E03D6DCEF68597A04C08C2")
    @android.view.RemotableViewMethod
    public void setLines(int lines) {
        mMaximum = mMinimum = lines;
        mMaxMode = mMinMode = LINES;
        requestLayout();
        invalidate();
        // ---------- Original Method ----------
        //mMaximum = mMinimum = lines;
        //mMaxMode = mMinMode = LINES;
        //requestLayout();
        //invalidate();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.517 -0400", hash_original_method = "6CD9B04ABBE9A4E392854E2FFBA64155", hash_generated_method = "605750DFFC911807C455EB8BF69BC06C")
    @android.view.RemotableViewMethod
    public void setHeight(int pixels) {
        mMaximum = mMinimum = pixels;
        mMaxMode = mMinMode = PIXELS;
        requestLayout();
        invalidate();
        // ---------- Original Method ----------
        //mMaximum = mMinimum = pixels;
        //mMaxMode = mMinMode = PIXELS;
        //requestLayout();
        //invalidate();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.517 -0400", hash_original_method = "6EF109AA0B8A98B265CEDBFE77B13F24", hash_generated_method = "D90D5130C6BDA102B7070F71A2C61C54")
    @android.view.RemotableViewMethod
    public void setMinEms(int minems) {
        mMinWidth = minems;
        mMinWidthMode = EMS;
        requestLayout();
        invalidate();
        // ---------- Original Method ----------
        //mMinWidth = minems;
        //mMinWidthMode = EMS;
        //requestLayout();
        //invalidate();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.517 -0400", hash_original_method = "CC5034BC1B28BBCD01B0947E11300CEA", hash_generated_method = "AAD5723F0423927F8F6C32B9A4BE6D81")
    @android.view.RemotableViewMethod
    public void setMinWidth(int minpixels) {
        mMinWidth = minpixels;
        mMinWidthMode = PIXELS;
        requestLayout();
        invalidate();
        // ---------- Original Method ----------
        //mMinWidth = minpixels;
        //mMinWidthMode = PIXELS;
        //requestLayout();
        //invalidate();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.517 -0400", hash_original_method = "024C424B12C855A76B8C4D4EF37E56E9", hash_generated_method = "DD52876446D0A1A3DAEC70BAED22C9E3")
    @android.view.RemotableViewMethod
    public void setMaxEms(int maxems) {
        mMaxWidth = maxems;
        mMaxWidthMode = EMS;
        requestLayout();
        invalidate();
        // ---------- Original Method ----------
        //mMaxWidth = maxems;
        //mMaxWidthMode = EMS;
        //requestLayout();
        //invalidate();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.517 -0400", hash_original_method = "66D27E295E9935EDB856E68754ECCF50", hash_generated_method = "11CEBBE63F35062DDE2A055E3857C0B3")
    @android.view.RemotableViewMethod
    public void setMaxWidth(int maxpixels) {
        mMaxWidth = maxpixels;
        mMaxWidthMode = PIXELS;
        requestLayout();
        invalidate();
        // ---------- Original Method ----------
        //mMaxWidth = maxpixels;
        //mMaxWidthMode = PIXELS;
        //requestLayout();
        //invalidate();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.519 -0400", hash_original_method = "29184B32707510663C7CC00A1776202A", hash_generated_method = "4DABCC8E368203558E4AE1484330F564")
    @android.view.RemotableViewMethod
    public void setEms(int ems) {
        mMaxWidth = mMinWidth = ems;
        mMaxWidthMode = mMinWidthMode = EMS;
        requestLayout();
        invalidate();
        // ---------- Original Method ----------
        //mMaxWidth = mMinWidth = ems;
        //mMaxWidthMode = mMinWidthMode = EMS;
        //requestLayout();
        //invalidate();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.519 -0400", hash_original_method = "A6A8746AE8743344ECC9244BF17B5285", hash_generated_method = "16D0F80014324D2EF8F22A1CB338C9F9")
    @android.view.RemotableViewMethod
    public void setWidth(int pixels) {
        mMaxWidth = mMinWidth = pixels;
        mMaxWidthMode = mMinWidthMode = PIXELS;
        requestLayout();
        invalidate();
        // ---------- Original Method ----------
        //mMaxWidth = mMinWidth = pixels;
        //mMaxWidthMode = mMinWidthMode = PIXELS;
        //requestLayout();
        //invalidate();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.520 -0400", hash_original_method = "9D5DCCC1076394887EA3B21F5DF8F706", hash_generated_method = "958BDD7B161D72A6D0E115C63CC4964C")
    public void setLineSpacing(float add, float mult) {
        if(mSpacingAdd != add || mSpacingMult != mult)        
        {
            mSpacingAdd = add;
            mSpacingMult = mult;
            if(mLayout != null)            
            {
                nullLayouts();
                requestLayout();
                invalidate();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mSpacingAdd != add || mSpacingMult != mult) {
            //mSpacingAdd = add;
            //mSpacingMult = mult;
            //if (mLayout != null) {
                //nullLayouts();
                //requestLayout();
                //invalidate();
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.520 -0400", hash_original_method = "699FFD9CCBE3B133871A47DAD4072321", hash_generated_method = "EDDE0E69D39ACF2CA5C1EDA3166E2581")
    public final void append(CharSequence text) {
        addTaint(text.getTaint());
        append(text, 0, text.length());
        // ---------- Original Method ----------
        //append(text, 0, text.length());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.520 -0400", hash_original_method = "B2621C1C8DC7A6B197F310747926C024", hash_generated_method = "2D8CCB202FABF6DFC18EDB9314F71358")
    public void append(CharSequence text, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(text.getTaint());
        if(!(mText instanceof Editable))        
        {
            setText(mText, BufferType.EDITABLE);
        } //End block
        ((Editable) mText).append(text, start, end);
        // ---------- Original Method ----------
        //if (!(mText instanceof Editable)) {
            //setText(mText, BufferType.EDITABLE);
        //}
        //((Editable) mText).append(text, start, end);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.527 -0400", hash_original_method = "ADC7043537742A0A0C5E53BD45A182BE", hash_generated_method = "4365839206786561B5442E01912153BE")
    private void updateTextColors() {
        boolean inval = false;
        int color = mTextColor.getColorForState(getDrawableState(), 0);
        if(color != mCurTextColor)        
        {
            mCurTextColor = color;
            inval = true;
        } //End block
        if(mLinkTextColor != null)        
        {
            color = mLinkTextColor.getColorForState(getDrawableState(), 0);
            if(color != mTextPaint.linkColor)            
            {
                mTextPaint.linkColor = color;
                inval = true;
            } //End block
        } //End block
        if(mHintTextColor != null)        
        {
            color = mHintTextColor.getColorForState(getDrawableState(), 0);
            if(color != mCurHintTextColor && mText.length() == 0)            
            {
                mCurHintTextColor = color;
                inval = true;
            } //End block
        } //End block
        if(inval)        
        {
            invalidate();
        } //End block
        // ---------- Original Method ----------
        //boolean inval = false;
        //int color = mTextColor.getColorForState(getDrawableState(), 0);
        //if (color != mCurTextColor) {
            //mCurTextColor = color;
            //inval = true;
        //}
        //if (mLinkTextColor != null) {
            //color = mLinkTextColor.getColorForState(getDrawableState(), 0);
            //if (color != mTextPaint.linkColor) {
                //mTextPaint.linkColor = color;
                //inval = true;
            //}
        //}
        //if (mHintTextColor != null) {
            //color = mHintTextColor.getColorForState(getDrawableState(), 0);
            //if (color != mCurHintTextColor && mText.length() == 0) {
                //mCurHintTextColor = color;
                //inval = true;
            //}
        //}
        //if (inval) {
            //invalidate();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.527 -0400", hash_original_method = "3E3CC8861E854C1E6B450E5CB8D8974F", hash_generated_method = "D0D33687E438DD7142FC81A03508D9CF")
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if(mTextColor != null && mTextColor.isStateful()
                || (mHintTextColor != null && mHintTextColor.isStateful())
                || (mLinkTextColor != null && mLinkTextColor.isStateful()))        
        {
            updateTextColors();
        } //End block
        final Drawables dr = mDrawables;
        if(dr != null)        
        {
            int[] state = getDrawableState();
            if(dr.mDrawableTop != null && dr.mDrawableTop.isStateful())            
            {
                dr.mDrawableTop.setState(state);
            } //End block
            if(dr.mDrawableBottom != null && dr.mDrawableBottom.isStateful())            
            {
                dr.mDrawableBottom.setState(state);
            } //End block
            if(dr.mDrawableLeft != null && dr.mDrawableLeft.isStateful())            
            {
                dr.mDrawableLeft.setState(state);
            } //End block
            if(dr.mDrawableRight != null && dr.mDrawableRight.isStateful())            
            {
                dr.mDrawableRight.setState(state);
            } //End block
            if(dr.mDrawableStart != null && dr.mDrawableStart.isStateful())            
            {
                dr.mDrawableStart.setState(state);
            } //End block
            if(dr.mDrawableEnd != null && dr.mDrawableEnd.isStateful())            
            {
                dr.mDrawableEnd.setState(state);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.528 -0400", hash_original_method = "AF2C3EA4891B79A54157B80D9A5CB454", hash_generated_method = "F526D0FA948B6D07B7F95ED08B00E8CB")
    @Override
    public Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Parcelable superState = super.onSaveInstanceState();
        boolean save = mFreezesText;
        int start = 0;
        int end = 0;
        if(mText != null)        
        {
            start = getSelectionStart();
            end = getSelectionEnd();
            if(start >= 0 || end >= 0)            
            {
                save = true;
            } //End block
        } //End block
        if(save)        
        {
            SavedState ss = new SavedState(superState);
            ss.selStart = start;
            ss.selEnd = end;
            if(mText instanceof Spanned)            
            {
                Spannable sp = new SpannableString(mText);
for(ChangeWatcher cw : sp.getSpans(0, sp.length(), ChangeWatcher.class))
                {
                    sp.removeSpan(cw);
                } //End block
                removeMisspelledSpans(sp);
                sp.removeSpan(mSuggestionRangeSpan);
                ss.text = sp;
            } //End block
            else
            {
                ss.text = mText.toString();
            } //End block
            if(isFocused() && start >= 0 && end >= 0)            
            {
                ss.frozenWithFocus = true;
            } //End block
            ss.error = mError;
Parcelable var182E37827114C3F455816E0E29D81D76_948948882 =             ss;
            var182E37827114C3F455816E0E29D81D76_948948882.addTaint(taint);
            return var182E37827114C3F455816E0E29D81D76_948948882;
        } //End block
Parcelable varBA7A3E641095ABD11C9DBE16D47F122C_275295286 =         superState;
        varBA7A3E641095ABD11C9DBE16D47F122C_275295286.addTaint(taint);
        return varBA7A3E641095ABD11C9DBE16D47F122C_275295286;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.528 -0400", hash_original_method = "F2FC1C379415C0983647E04C4964FB91", hash_generated_method = "DE9FA8FF335988167D83AECCD31C9E3F")
     void removeMisspelledSpans(Spannable spannable) {
        addTaint(spannable.getTaint());
        SuggestionSpan[] suggestionSpans = spannable.getSpans(0, spannable.length(),
                SuggestionSpan.class);
for(int i = 0;i < suggestionSpans.length;i++)
        {
            int flags = suggestionSpans[i].getFlags();
            if((flags & SuggestionSpan.FLAG_EASY_CORRECT) != 0
                    && (flags & SuggestionSpan.FLAG_MISSPELLED) != 0)            
            {
                spannable.removeSpan(suggestionSpans[i]);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //SuggestionSpan[] suggestionSpans = spannable.getSpans(0, spannable.length(),
                //SuggestionSpan.class);
        //for (int i = 0; i < suggestionSpans.length; i++) {
            //int flags = suggestionSpans[i].getFlags();
            //if ((flags & SuggestionSpan.FLAG_EASY_CORRECT) != 0
                    //&& (flags & SuggestionSpan.FLAG_MISSPELLED) != 0) {
                //spannable.removeSpan(suggestionSpans[i]);
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.529 -0400", hash_original_method = "F50E2D5CE86BF5E6A61BC8360971F12F", hash_generated_method = "A34771C5481C8B20DDC170D4768E54D2")
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state.getTaint());
        if(!(state instanceof SavedState))        
        {
            super.onRestoreInstanceState(state);
            return;
        } //End block
        SavedState ss = (SavedState)state;
        super.onRestoreInstanceState(ss.getSuperState());
        if(ss.text != null)        
        {
            setText(ss.text);
        } //End block
        if(ss.selStart >= 0 && ss.selEnd >= 0)        
        {
            if(mText instanceof Spannable)            
            {
                int len = mText.length();
                if(ss.selStart > len || ss.selEnd > len)                
                {
                    String restored = "";
                    if(ss.text != null)                    
                    {
                        restored = "(restored) ";
                    } //End block
                } //End block
                else
                {
                    Selection.setSelection((Spannable) mText, ss.selStart,
                                           ss.selEnd);
                    if(ss.frozenWithFocus)                    
                    {
                        mFrozenWithFocus = true;
                    } //End block
                } //End block
            } //End block
        } //End block
        if(ss.error != null)        
        {
            final CharSequence error = ss.error;
            post(new Runnable() {        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.529 -0400", hash_original_method = "6D4719BAECED3DD83F9692F93AFBC954", hash_generated_method = "28C54C47F8D5EF53BCA9BB85B0F3683C")
        public void run() {
            setError(error);
            // ---------- Original Method ----------
            //setError(error);
        }
});
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.529 -0400", hash_original_method = "73E23EE9831A5ABB45118C6D9D08B19B", hash_generated_method = "949FD70C22A0A1B1AABDE9D0E667A116")
    @android.view.RemotableViewMethod
    public void setFreezesText(boolean freezesText) {
        mFreezesText = freezesText;
        // ---------- Original Method ----------
        //mFreezesText = freezesText;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.529 -0400", hash_original_method = "8E3F839ECE8B91BC1C15216DAAE76890", hash_generated_method = "23D82D00CA6607BA9CE849B8F20859F0")
    public boolean getFreezesText() {
        boolean varBAD96035AC86533B7D8C4EAA84835DC4_1306991141 = (mFreezesText);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1082269221 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1082269221;
        // ---------- Original Method ----------
        //return mFreezesText;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.529 -0400", hash_original_method = "72071F64A960BCDF8628E8519218C076", hash_generated_method = "0D865B4C4C33F8BF881769588A4B7450")
    public final void setEditableFactory(Editable.Factory factory) {
        mEditableFactory = factory;
        setText(mText);
        // ---------- Original Method ----------
        //mEditableFactory = factory;
        //setText(mText);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.529 -0400", hash_original_method = "EE70434E54240A6008C9D2EA9B017339", hash_generated_method = "D377DBA7CFAFD2BF6D3E343C891A2FD6")
    public final void setSpannableFactory(Spannable.Factory factory) {
        mSpannableFactory = factory;
        setText(mText);
        // ---------- Original Method ----------
        //mSpannableFactory = factory;
        //setText(mText);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.530 -0400", hash_original_method = "F37C8918E495A353D909855BE6AEA0B3", hash_generated_method = "170DA8E8BD4336C0FB792281FDE81EAF")
    @android.view.RemotableViewMethod
    public final void setText(CharSequence text) {
        addTaint(text.getTaint());
        setText(text, mBufferType);
        // ---------- Original Method ----------
        //setText(text, mBufferType);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.530 -0400", hash_original_method = "8D1404A47F965A96F115CE2D4080AFCB", hash_generated_method = "484E1862238406D15C75CA010645AA6D")
    @android.view.RemotableViewMethod
    public final void setTextKeepState(CharSequence text) {
        addTaint(text.getTaint());
        setTextKeepState(text, mBufferType);
        // ---------- Original Method ----------
        //setTextKeepState(text, mBufferType);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.530 -0400", hash_original_method = "607651EBB019EF2524713C89A6A4FC8C", hash_generated_method = "DBB3DB504772F2AC3B265CE5B16F9197")
    public void setText(CharSequence text, BufferType type) {
        addTaint(type.getTaint());
        addTaint(text.getTaint());
        setText(text, type, true, 0);
        if(mCharWrapper != null)        
        {
            mCharWrapper.mChars = null;
        } //End block
        // ---------- Original Method ----------
        //setText(text, type, true, 0);
        //if (mCharWrapper != null) {
            //mCharWrapper.mChars = null;
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.534 -0400", hash_original_method = "EBAE4ED74D570AD4FF310073DD3BF4E5", hash_generated_method = "2BA93A7A63A103A1E7CA1F5FB9BB442F")
    private void setText(CharSequence text, BufferType type,
                         boolean notifyBefore, int oldlen) {
        addTaint(oldlen);
        addTaint(notifyBefore);
        if(text == null)        
        {
            text = "";
        } //End block
        if(!isSuggestionsEnabled())        
        {
            text = removeSuggestionSpans(text);
        } //End block
        if(!mUserSetTextScaleX)        
        mTextPaint.setTextScaleX(1.0f);
        if(text instanceof Spanned &&
            ((Spanned) text).getSpanStart(TextUtils.TruncateAt.MARQUEE) >= 0)        
        {
            if(ViewConfiguration.get(mContext).isFadingMarqueeEnabled())            
            {
                setHorizontalFadingEdgeEnabled(true);
                mMarqueeFadeMode = MARQUEE_FADE_NORMAL;
            } //End block
            else
            {
                setHorizontalFadingEdgeEnabled(false);
                mMarqueeFadeMode = MARQUEE_FADE_SWITCH_SHOW_ELLIPSIS;
            } //End block
            setEllipsize(TextUtils.TruncateAt.MARQUEE);
        } //End block
        int n = mFilters.length;
for(int i = 0;i < n;i++)
        {
            CharSequence out = mFilters[i].filter(text, 0, text.length(),
                                                  EMPTY_SPANNED, 0, 0);
            if(out != null)            
            {
                text = out;
            } //End block
        } //End block
        if(notifyBefore)        
        {
            if(mText != null)            
            {
                oldlen = mText.length();
                sendBeforeTextChanged(mText, 0, oldlen, text.length());
            } //End block
            else
            {
                sendBeforeTextChanged("", 0, 0, text.length());
            } //End block
        } //End block
        boolean needEditableForNotification = false;
        if(mListeners != null && mListeners.size() != 0)        
        {
            needEditableForNotification = true;
        } //End block
        if(type == BufferType.EDITABLE || mInput != null || needEditableForNotification)        
        {
            Editable t = mEditableFactory.newEditable(text);
            text = t;
            setFilters(t, mFilters);
            InputMethodManager imm = InputMethodManager.peekInstance();
            if(imm != null)            
            imm.restartInput(this);
        } //End block
        else
        if(type == BufferType.SPANNABLE || mMovement != null)        
        {
            text = mSpannableFactory.newSpannable(text);
        } //End block
        else
        if(!(text instanceof CharWrapper))        
        {
            text = TextUtils.stringOrSpannedString(text);
        } //End block
        if(mAutoLinkMask != 0)        
        {
            Spannable s2;
            if(type == BufferType.EDITABLE || text instanceof Spannable)            
            {
                s2 = (Spannable) text;
            } //End block
            else
            {
                s2 = mSpannableFactory.newSpannable(text);
            } //End block
            if(Linkify.addLinks(s2, mAutoLinkMask))            
            {
                text = s2;
                type = (type == BufferType.EDITABLE) ? BufferType.EDITABLE : BufferType.SPANNABLE;
                mText = text;
                if(mLinksClickable && !textCanBeSelected())                
                {
                    setMovementMethod(LinkMovementMethod.getInstance());
                } //End block
            } //End block
        } //End block
        mBufferType = type;
        mText = text;
        if(mTransformation == null)        
        {
            mTransformed = text;
        } //End block
        else
        {
            mTransformed = mTransformation.getTransformation(text, this);
        } //End block
        final int textLength = text.length();
        if(text instanceof Spannable && !mAllowTransformationLengthChange)        
        {
            Spannable sp = (Spannable) text;
            final ChangeWatcher[] watchers = sp.getSpans(0, sp.length(), ChangeWatcher.class);
            final int count = watchers.length;
for(int i = 0;i < count;i++)
            sp.removeSpan(watchers[i]);
            if(mChangeWatcher == null)            
            mChangeWatcher = new ChangeWatcher();
            sp.setSpan(mChangeWatcher, 0, textLength, Spanned.SPAN_INCLUSIVE_INCLUSIVE |
                       (PRIORITY << Spanned.SPAN_PRIORITY_SHIFT));
            if(mInput != null)            
            {
                sp.setSpan(mInput, 0, textLength, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
            } //End block
            if(mTransformation != null)            
            {
                sp.setSpan(mTransformation, 0, textLength, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
            } //End block
            if(mMovement != null)            
            {
                mMovement.initialize(this, (Spannable) text);
                mSelectionMoved = false;
            } //End block
        } //End block
        if(mLayout != null)        
        {
            checkForRelayout();
        } //End block
        sendOnTextChanged(text, 0, oldlen, textLength);
        onTextChanged(text, 0, oldlen, textLength);
        if(needEditableForNotification)        
        {
            sendAfterTextChanged((Editable) text);
        } //End block
        prepareCursorControllers();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.535 -0400", hash_original_method = "36BFF315CD4AAC9D68E14477979C2AB5", hash_generated_method = "4B046E9129B2EB1244827B12647C5C1B")
    public final void setText(char[] text, int start, int len) {
        int oldlen = 0;
        if(start < 0 || len < 0 || start + len > text.length)        
        {
            IndexOutOfBoundsException varF0875409A1D46FBF78545DEADA478C82_1473044691 = new IndexOutOfBoundsException(start + ", " + len);
            varF0875409A1D46FBF78545DEADA478C82_1473044691.addTaint(taint);
            throw varF0875409A1D46FBF78545DEADA478C82_1473044691;
        } //End block
        if(mText != null)        
        {
            oldlen = mText.length();
            sendBeforeTextChanged(mText, 0, oldlen, len);
        } //End block
        else
        {
            sendBeforeTextChanged("", 0, 0, len);
        } //End block
        if(mCharWrapper == null)        
        {
            mCharWrapper = new CharWrapper(text, start, len);
        } //End block
        else
        {
            mCharWrapper.set(text, start, len);
        } //End block
        setText(mCharWrapper, mBufferType, false, oldlen);
        // ---------- Original Method ----------
        //int oldlen = 0;
        //if (start < 0 || len < 0 || start + len > text.length) {
            //throw new IndexOutOfBoundsException(start + ", " + len);
        //}
        //if (mText != null) {
            //oldlen = mText.length();
            //sendBeforeTextChanged(mText, 0, oldlen, len);
        //} else {
            //sendBeforeTextChanged("", 0, 0, len);
        //}
        //if (mCharWrapper == null) {
            //mCharWrapper = new CharWrapper(text, start, len);
        //} else {
            //mCharWrapper.set(text, start, len);
        //}
        //setText(mCharWrapper, mBufferType, false, oldlen);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.535 -0400", hash_original_method = "9AF748BA799D545173D512FE98AE91A8", hash_generated_method = "FD3A5061D442E6C1553B41C334D5AB24")
    public final void setTextKeepState(CharSequence text, BufferType type) {
        addTaint(type.getTaint());
        addTaint(text.getTaint());
        int start = getSelectionStart();
        int end = getSelectionEnd();
        int len = text.length();
        setText(text, type);
        if(start >= 0 || end >= 0)        
        {
            if(mText instanceof Spannable)            
            {
                Selection.setSelection((Spannable) mText,
                                       Math.max(0, Math.min(start, len)),
                                       Math.max(0, Math.min(end, len)));
            } //End block
        } //End block
        // ---------- Original Method ----------
        //int start = getSelectionStart();
        //int end = getSelectionEnd();
        //int len = text.length();
        //setText(text, type);
        //if (start >= 0 || end >= 0) {
            //if (mText instanceof Spannable) {
                //Selection.setSelection((Spannable) mText,
                                       //Math.max(0, Math.min(start, len)),
                                       //Math.max(0, Math.min(end, len)));
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.538 -0400", hash_original_method = "F67FB9F700F5516CACC8B84E46FAB678", hash_generated_method = "A7FCD3A26A16D8A30CFE42DA777F8D50")
    @android.view.RemotableViewMethod
    public final void setText(int resid) {
        addTaint(resid);
        setText(getContext().getResources().getText(resid));
        // ---------- Original Method ----------
        //setText(getContext().getResources().getText(resid));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.538 -0400", hash_original_method = "A59BD645A347EA39C4147D9E24C2BE1F", hash_generated_method = "EF9BA553C2717A1C8446F0BA67718452")
    public final void setText(int resid, BufferType type) {
        addTaint(type.getTaint());
        addTaint(resid);
        setText(getContext().getResources().getText(resid), type);
        // ---------- Original Method ----------
        //setText(getContext().getResources().getText(resid), type);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.538 -0400", hash_original_method = "E428F8CA5E03E5225CDDDB51AA0FFAC9", hash_generated_method = "DF6D85A54536AD7F01671A0AC709C8CD")
    @android.view.RemotableViewMethod
    public final void setHint(CharSequence hint) {
        mHint = TextUtils.stringOrSpannedString(hint);
        if(mLayout != null)        
        {
            checkForRelayout();
        } //End block
        if(mText.length() == 0)        
        {
            invalidate();
        } //End block
        // ---------- Original Method ----------
        //mHint = TextUtils.stringOrSpannedString(hint);
        //if (mLayout != null) {
            //checkForRelayout();
        //}
        //if (mText.length() == 0) {
            //invalidate();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.538 -0400", hash_original_method = "38FC4DBAEFB265C97233FE4F28F668E7", hash_generated_method = "AEB4130F248AC7DEABA113C724D9F34E")
    @android.view.RemotableViewMethod
    public final void setHint(int resid) {
        addTaint(resid);
        setHint(getContext().getResources().getText(resid));
        // ---------- Original Method ----------
        //setHint(getContext().getResources().getText(resid));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.538 -0400", hash_original_method = "B545FCA8809064A694F5A37F99B0BBF1", hash_generated_method = "C75F3280B49851B36D9449394278831A")
    @ViewDebug.CapturedViewProperty
    public CharSequence getHint() {
CharSequence var10F7C6934D233F57C4316A767DA83DC8_134674698 =         mHint;
        var10F7C6934D233F57C4316A767DA83DC8_134674698.addTaint(taint);
        return var10F7C6934D233F57C4316A767DA83DC8_134674698;
        // ---------- Original Method ----------
        //return mHint;
    }

    
    @DSModeled(DSC.BAN)
    private static boolean isMultilineInputType(int type) {
        return (type & (EditorInfo.TYPE_MASK_CLASS | EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE)) ==
            (EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.538 -0400", hash_original_method = "49514C27E12484581D1021562BB6B56C", hash_generated_method = "C8DDA700EF1B5B72698E3A5034CA5810")
    public void setInputType(int type) {
        addTaint(type);
        final boolean wasPassword = isPasswordInputType(mInputType);
        final boolean wasVisiblePassword = isVisiblePasswordInputType(mInputType);
        setInputType(type, false);
        final boolean isPassword = isPasswordInputType(type);
        final boolean isVisiblePassword = isVisiblePasswordInputType(type);
        boolean forceUpdate = false;
        if(isPassword)        
        {
            setTransformationMethod(PasswordTransformationMethod.getInstance());
            setTypefaceByIndex(MONOSPACE, 0);
        } //End block
        else
        if(isVisiblePassword)        
        {
            if(mTransformation == PasswordTransformationMethod.getInstance())            
            {
                forceUpdate = true;
            } //End block
            setTypefaceByIndex(MONOSPACE, 0);
        } //End block
        else
        if(wasPassword || wasVisiblePassword)        
        {
            setTypefaceByIndex(-1, -1);
            if(mTransformation == PasswordTransformationMethod.getInstance())            
            {
                forceUpdate = true;
            } //End block
        } //End block
        boolean singleLine = !isMultilineInputType(type);
        if(mSingleLine != singleLine || forceUpdate)        
        {
            applySingleLine(singleLine, !isPassword, true);
        } //End block
        if(!isSuggestionsEnabled())        
        {
            mText = removeSuggestionSpans(mText);
        } //End block
        InputMethodManager imm = InputMethodManager.peekInstance();
        if(imm != null)        
        imm.restartInput(this);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.539 -0400", hash_original_method = "103CDD92E42BC521C8FE05F02491D14C", hash_generated_method = "73ABCD62A40CA8BFEEA40FAA608AB9ED")
    private boolean hasPasswordTransformationMethod() {
        boolean var45EB66355B4FB51739DB07984748C88B_61768491 = (mTransformation instanceof PasswordTransformationMethod);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_369551459 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_369551459;
        // ---------- Original Method ----------
        //return mTransformation instanceof PasswordTransformationMethod;
    }

    
    @DSModeled(DSC.BAN)
    private static boolean isPasswordInputType(int inputType) {
        final int variation =
                inputType & (EditorInfo.TYPE_MASK_CLASS | EditorInfo.TYPE_MASK_VARIATION);
        return variation
                == (EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_VARIATION_PASSWORD)
                || variation
                == (EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_VARIATION_WEB_PASSWORD)
                || variation
                == (EditorInfo.TYPE_CLASS_NUMBER | EditorInfo.TYPE_NUMBER_VARIATION_PASSWORD);
    }

    
    @DSModeled(DSC.BAN)
    private static boolean isVisiblePasswordInputType(int inputType) {
        final int variation =
                inputType & (EditorInfo.TYPE_MASK_CLASS | EditorInfo.TYPE_MASK_VARIATION);
        return variation
                == (EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.539 -0400", hash_original_method = "5561319FE52E5BCF6B9F27794140DEB3", hash_generated_method = "9597CC79B00C6F9A01B8A8F839246F14")
    public void setRawInputType(int type) {
        mInputType = type;
        // ---------- Original Method ----------
        //mInputType = type;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.541 -0400", hash_original_method = "95BF8AE0F4607DDA852256E0031089E3", hash_generated_method = "48F19AFD6794CF5D2E5C1D70488429AE")
    private void setInputType(int type, boolean direct) {
        addTaint(direct);
        addTaint(type);
        final int cls = type & EditorInfo.TYPE_MASK_CLASS;
        KeyListener input;
        if(cls == EditorInfo.TYPE_CLASS_TEXT)        
        {
            boolean autotext = (type & EditorInfo.TYPE_TEXT_FLAG_AUTO_CORRECT) != 0;
            TextKeyListener.Capitalize cap;
            if((type & EditorInfo.TYPE_TEXT_FLAG_CAP_CHARACTERS) != 0)            
            {
                cap = TextKeyListener.Capitalize.CHARACTERS;
            } //End block
            else
            if((type & EditorInfo.TYPE_TEXT_FLAG_CAP_WORDS) != 0)            
            {
                cap = TextKeyListener.Capitalize.WORDS;
            } //End block
            else
            if((type & EditorInfo.TYPE_TEXT_FLAG_CAP_SENTENCES) != 0)            
            {
                cap = TextKeyListener.Capitalize.SENTENCES;
            } //End block
            else
            {
                cap = TextKeyListener.Capitalize.NONE;
            } //End block
            input = TextKeyListener.getInstance(autotext, cap);
        } //End block
        else
        if(cls == EditorInfo.TYPE_CLASS_NUMBER)        
        {
            input = DigitsKeyListener.getInstance(
                    (type & EditorInfo.TYPE_NUMBER_FLAG_SIGNED) != 0,
                    (type & EditorInfo.TYPE_NUMBER_FLAG_DECIMAL) != 0);
        } //End block
        else
        if(cls == EditorInfo.TYPE_CLASS_DATETIME)        
        {
switch(type & EditorInfo.TYPE_MASK_VARIATION){
            case EditorInfo.TYPE_DATETIME_VARIATION_DATE:
            input = DateKeyListener.getInstance();
            break;
            case EditorInfo.TYPE_DATETIME_VARIATION_TIME:
            input = TimeKeyListener.getInstance();
            break;
            default:
            input = DateTimeKeyListener.getInstance();
            break;
}
        } //End block
        else
        if(cls == EditorInfo.TYPE_CLASS_PHONE)        
        {
            input = DialerKeyListener.getInstance();
        } //End block
        else
        {
            input = TextKeyListener.getInstance();
        } //End block
        setRawInputType(type);
        if(direct)        
        mInput = input;
        else
        {
            setKeyListenerOnly(input);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.541 -0400", hash_original_method = "CC20F62DEC3871662808940856B4AD97", hash_generated_method = "57F121F1767B5C341540CB4B6059E599")
    public int getInputType() {
        int varB5A4AD702D55C806F4DF081478AF4E76_659088876 = (mInputType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1819972009 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1819972009;
        // ---------- Original Method ----------
        //return mInputType;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.544 -0400", hash_original_method = "15D43244184C7971E001BEB05B105E77", hash_generated_method = "8DAB151E7AFD1AD2324F3675EC937C0D")
    public void setImeOptions(int imeOptions) {
        if(mInputContentType == null)        
        {
            mInputContentType = new InputContentType();
        } //End block
        mInputContentType.imeOptions = imeOptions;
        // ---------- Original Method ----------
        //if (mInputContentType == null) {
            //mInputContentType = new InputContentType();
        //}
        //mInputContentType.imeOptions = imeOptions;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.545 -0400", hash_original_method = "2B64657558FBAC5C9C7E6BDC8C1A3258", hash_generated_method = "31EA132383F64A7AF6EF224657050C07")
    public int getImeOptions() {
        int var3413042A729452ABE7321CD93C61169F_517129477 = (mInputContentType != null
                ? mInputContentType.imeOptions : EditorInfo.IME_NULL);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1343690209 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1343690209;
        // ---------- Original Method ----------
        //return mInputContentType != null
                //? mInputContentType.imeOptions : EditorInfo.IME_NULL;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.545 -0400", hash_original_method = "1A4477F3225C39150F0F3FBD7557F91B", hash_generated_method = "C7DA875A444FE847E07151802DFAA1A9")
    public void setImeActionLabel(CharSequence label, int actionId) {
        if(mInputContentType == null)        
        {
            mInputContentType = new InputContentType();
        } //End block
        mInputContentType.imeActionLabel = label;
        mInputContentType.imeActionId = actionId;
        // ---------- Original Method ----------
        //if (mInputContentType == null) {
            //mInputContentType = new InputContentType();
        //}
        //mInputContentType.imeActionLabel = label;
        //mInputContentType.imeActionId = actionId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.545 -0400", hash_original_method = "A4E3D8286D59E9D4715BBC467F3D8808", hash_generated_method = "FE327D23E911932CEEAAB16BDF5BCB36")
    public CharSequence getImeActionLabel() {
CharSequence varDD4D8C8C874361AA0A0C586A286EE41C_189318113 =         mInputContentType != null
                ? mInputContentType.imeActionLabel : null;
        varDD4D8C8C874361AA0A0C586A286EE41C_189318113.addTaint(taint);
        return varDD4D8C8C874361AA0A0C586A286EE41C_189318113;
        // ---------- Original Method ----------
        //return mInputContentType != null
                //? mInputContentType.imeActionLabel : null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.545 -0400", hash_original_method = "4B4E4CA7604BFFF08B66F520F2D9A667", hash_generated_method = "F00CBE4981247186336ABDA785D657F6")
    public int getImeActionId() {
        int varD575A80E822B93AD6627A06544E8F2E4_1153896841 = (mInputContentType != null
                ? mInputContentType.imeActionId : 0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1528660990 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1528660990;
        // ---------- Original Method ----------
        //return mInputContentType != null
                //? mInputContentType.imeActionId : 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.546 -0400", hash_original_method = "46DFB908E4A3870151F9CA120300C85B", hash_generated_method = "4264B6A3F3AFD9E83608750402B50E97")
    public void setOnEditorActionListener(OnEditorActionListener l) {
        if(mInputContentType == null)        
        {
            mInputContentType = new InputContentType();
        } //End block
        mInputContentType.onEditorActionListener = l;
        // ---------- Original Method ----------
        //if (mInputContentType == null) {
            //mInputContentType = new InputContentType();
        //}
        //mInputContentType.onEditorActionListener = l;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.547 -0400", hash_original_method = "0518018E7AD402CBF7FDAFFEA66C2B57", hash_generated_method = "ABF4F363EDD8EEE6C753407D9D9AF54C")
    public void onEditorAction(int actionCode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(actionCode);
        final InputContentType ict = mInputContentType;
        if(ict != null)        
        {
            if(ict.onEditorActionListener != null)            
            {
                if(ict.onEditorActionListener.onEditorAction(this,
                        actionCode, null))                
                {
                    return;
                } //End block
            } //End block
            if(actionCode == EditorInfo.IME_ACTION_NEXT)            
            {
                View v = focusSearch(FOCUS_FORWARD);
                if(v != null)                
                {
                    if(!v.requestFocus(FOCUS_FORWARD))                    
                    {
                        IllegalStateException varE2C34DAEAA4A71D29F97874D1AE91DB0_1164752112 = new IllegalStateException("focus search returned a view " +
                                "that wasn't able to take focus!");
                        varE2C34DAEAA4A71D29F97874D1AE91DB0_1164752112.addTaint(taint);
                        throw varE2C34DAEAA4A71D29F97874D1AE91DB0_1164752112;
                    } //End block
                } //End block
                return;
            } //End block
            else
            if(actionCode == EditorInfo.IME_ACTION_PREVIOUS)            
            {
                View v = focusSearch(FOCUS_BACKWARD);
                if(v != null)                
                {
                    if(!v.requestFocus(FOCUS_BACKWARD))                    
                    {
                        IllegalStateException varE2C34DAEAA4A71D29F97874D1AE91DB0_211372786 = new IllegalStateException("focus search returned a view " +
                                "that wasn't able to take focus!");
                        varE2C34DAEAA4A71D29F97874D1AE91DB0_211372786.addTaint(taint);
                        throw varE2C34DAEAA4A71D29F97874D1AE91DB0_211372786;
                    } //End block
                } //End block
                return;
            } //End block
            else
            if(actionCode == EditorInfo.IME_ACTION_DONE)            
            {
                InputMethodManager imm = InputMethodManager.peekInstance();
                if(imm != null && imm.isActive(this))                
                {
                    imm.hideSoftInputFromWindow(getWindowToken(), 0);
                } //End block
                return;
            } //End block
        } //End block
        Handler h = getHandler();
        if(h != null)        
        {
            long eventTime = SystemClock.uptimeMillis();
            h.sendMessage(h.obtainMessage(ViewRootImpl.DISPATCH_KEY_FROM_IME,
                    new KeyEvent(eventTime, eventTime,
                    KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER, 0, 0,
                    KeyCharacterMap.VIRTUAL_KEYBOARD, 0,
                    KeyEvent.FLAG_SOFT_KEYBOARD | KeyEvent.FLAG_KEEP_TOUCH_MODE
                    | KeyEvent.FLAG_EDITOR_ACTION)));
            h.sendMessage(h.obtainMessage(ViewRootImpl.DISPATCH_KEY_FROM_IME,
                    new KeyEvent(SystemClock.uptimeMillis(), eventTime,
                    KeyEvent.ACTION_UP, KeyEvent.KEYCODE_ENTER, 0, 0,
                    KeyCharacterMap.VIRTUAL_KEYBOARD, 0,
                    KeyEvent.FLAG_SOFT_KEYBOARD | KeyEvent.FLAG_KEEP_TOUCH_MODE
                    | KeyEvent.FLAG_EDITOR_ACTION)));
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.547 -0400", hash_original_method = "E93C7F3F4C0717B4FFE77CC972CA5ABA", hash_generated_method = "2A034521D24931C7DDD31B2C3154B554")
    public void setPrivateImeOptions(String type) {
        if(mInputContentType == null)        
        mInputContentType = new InputContentType();
        mInputContentType.privateImeOptions = type;
        // ---------- Original Method ----------
        //if (mInputContentType == null) mInputContentType = new InputContentType();
        //mInputContentType.privateImeOptions = type;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.547 -0400", hash_original_method = "92B56934BB38E74A857D4D87A23CFEBD", hash_generated_method = "79358DB4E79BEFDCA273745AF4B71CBE")
    public String getPrivateImeOptions() {
String varA47643DA1B488A9C9ED7A129BFBE3F47_1334657921 =         mInputContentType != null
                ? mInputContentType.privateImeOptions : null;
        varA47643DA1B488A9C9ED7A129BFBE3F47_1334657921.addTaint(taint);
        return varA47643DA1B488A9C9ED7A129BFBE3F47_1334657921;
        // ---------- Original Method ----------
        //return mInputContentType != null
                //? mInputContentType.privateImeOptions : null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.550 -0400", hash_original_method = "4D2957EAEB6AF33B1C49D1AAB860E441", hash_generated_method = "01B284658CFE7B061795066A03E4AF9F")
    public void setInputExtras(int xmlResId) throws XmlPullParserException, IOException {
        addTaint(xmlResId);
        XmlResourceParser parser = getResources().getXml(xmlResId);
        if(mInputContentType == null)        
        mInputContentType = new InputContentType();
        mInputContentType.extras = new Bundle();
        getResources().parseBundleExtras(parser, mInputContentType.extras);
        // ---------- Original Method ----------
        //XmlResourceParser parser = getResources().getXml(xmlResId);
        //if (mInputContentType == null) mInputContentType = new InputContentType();
        //mInputContentType.extras = new Bundle();
        //getResources().parseBundleExtras(parser, mInputContentType.extras);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.550 -0400", hash_original_method = "3CCBAE1ACA56EC727CC56362E5EC99DC", hash_generated_method = "2A85915A2D5AC39677FC546C403AF776")
    public Bundle getInputExtras(boolean create) {
        addTaint(create);
        if(mInputContentType == null)        
        {
            if(!create)            
            {
Bundle var540C13E9E156B687226421B24F2DF178_1530665989 =             null;
            var540C13E9E156B687226421B24F2DF178_1530665989.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1530665989;
            }
            mInputContentType = new InputContentType();
        } //End block
        if(mInputContentType.extras == null)        
        {
            if(!create)            
            {
Bundle var540C13E9E156B687226421B24F2DF178_1552828978 =             null;
            var540C13E9E156B687226421B24F2DF178_1552828978.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1552828978;
            }
            mInputContentType.extras = new Bundle();
        } //End block
Bundle varFD614387A769989931B55E5BA22DF297_98440854 =         mInputContentType.extras;
        varFD614387A769989931B55E5BA22DF297_98440854.addTaint(taint);
        return varFD614387A769989931B55E5BA22DF297_98440854;
        // ---------- Original Method ----------
        //if (mInputContentType == null) {
            //if (!create) return null;
            //mInputContentType = new InputContentType();
        //}
        //if (mInputContentType.extras == null) {
            //if (!create) return null;
            //mInputContentType.extras = new Bundle();
        //}
        //return mInputContentType.extras;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.551 -0400", hash_original_method = "9A980CBEBB946A11C624D95D8D1017B2", hash_generated_method = "C49291AA2115654952C92D32C3F0D850")
    public CharSequence getError() {
CharSequence var9BA8401034AF88AA9344FA223E012CAC_240881568 =         mError;
        var9BA8401034AF88AA9344FA223E012CAC_240881568.addTaint(taint);
        return var9BA8401034AF88AA9344FA223E012CAC_240881568;
        // ---------- Original Method ----------
        //return mError;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.551 -0400", hash_original_method = "D7457C91A83A908A8309ED29F602BDCA", hash_generated_method = "7A3BAAEDAE229370655F2CE1D68CAC07")
    @android.view.RemotableViewMethod
    public void setError(CharSequence error) {
        addTaint(error.getTaint());
        if(error == null)        
        {
            setError(null, null);
        } //End block
        else
        {
            Drawable dr = getContext().getResources().
                getDrawable(com.android.internal.R.drawable.indicator_input_error);
            dr.setBounds(0, 0, dr.getIntrinsicWidth(), dr.getIntrinsicHeight());
            setError(error, dr);
        } //End block
        // ---------- Original Method ----------
        //if (error == null) {
            //setError(null, null);
        //} else {
            //Drawable dr = getContext().getResources().
                //getDrawable(com.android.internal.R.drawable.indicator_input_error);
            //dr.setBounds(0, 0, dr.getIntrinsicWidth(), dr.getIntrinsicHeight());
            //setError(error, dr);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.551 -0400", hash_original_method = "A707A7C4B74C4D669C69114C0D73A7BA", hash_generated_method = "6AFDC932E2664110D4C7E80F174E4625")
    public void setError(CharSequence error, Drawable icon) {
        addTaint(icon.getTaint());
        error = TextUtils.stringOrSpannedString(error);
        mError = error;
        mErrorWasChanged = true;
        final Drawables dr = mDrawables;
        if(dr != null)        
        {
switch(getResolvedLayoutDirection()){
            default:
            case LAYOUT_DIRECTION_LTR:
            setCompoundDrawables(dr.mDrawableLeft, dr.mDrawableTop, icon,
                            dr.mDrawableBottom);
            break;
            case LAYOUT_DIRECTION_RTL:
            setCompoundDrawables(icon, dr.mDrawableTop, dr.mDrawableRight,
                            dr.mDrawableBottom);
            break;
}
        } //End block
        else
        {
            setCompoundDrawables(null, null, icon, null);
        } //End block
        if(error == null)        
        {
            if(mPopup != null)            
            {
                if(mPopup.isShowing())                
                {
                    mPopup.dismiss();
                } //End block
                mPopup = null;
            } //End block
        } //End block
        else
        {
            if(isFocused())            
            {
                showError();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.552 -0400", hash_original_method = "691606EEB666F38CF8433096C671CCBD", hash_generated_method = "A8577D6CD73F98AA76CCA746E9B6AB98")
    private void showError() {
        if(getWindowToken() == null)        
        {
            mShowErrorAfterAttach = true;
            return;
        } //End block
        if(mPopup == null)        
        {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            final TextView err = (TextView) inflater.inflate(
                    com.android.internal.R.layout.textview_hint, null);
            final float scale = getResources().getDisplayMetrics().density;
            mPopup = new ErrorPopup(err, (int) (200 * scale + 0.5f), (int) (50 * scale + 0.5f));
            mPopup.setFocusable(false);
            mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        } //End block
        TextView tv = (TextView) mPopup.getContentView();
        chooseSize(mPopup, mError, tv);
        tv.setText(mError);
        mPopup.showAsDropDown(this, getErrorX(), getErrorY());
        mPopup.fixDirection(mPopup.isAboveAnchor());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.552 -0400", hash_original_method = "193E855DAAE9F0495F7DD2501E8046B7", hash_generated_method = "CADF0450C6C7885CB346969DDADB295C")
    private int getErrorX() {
        final float scale = getResources().getDisplayMetrics().density;
        final Drawables dr = mDrawables;
        int var677673458507A2C2F558C97B3F0D7593_1507166528 = (getWidth() - mPopup.getWidth() - getPaddingRight() -
                (dr != null ? dr.mDrawableSizeRight : 0) / 2 + (int) (25 * scale + 0.5f));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1847079467 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1847079467;
        // ---------- Original Method ----------
        //final float scale = getResources().getDisplayMetrics().density;
        //final Drawables dr = mDrawables;
        //return getWidth() - mPopup.getWidth() - getPaddingRight() -
                //(dr != null ? dr.mDrawableSizeRight : 0) / 2 + (int) (25 * scale + 0.5f);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.553 -0400", hash_original_method = "AEF78C4F5C84BB7DCAE783FBA8691257", hash_generated_method = "D96CB4401DF261EA3B1C39F1C8A4E5CC")
    private int getErrorY() {
        final int compoundPaddingTop = getCompoundPaddingTop();
        int vspace = mBottom - mTop - getCompoundPaddingBottom() - compoundPaddingTop;
        final Drawables dr = mDrawables;
        int icontop = compoundPaddingTop +
                (vspace - (dr != null ? dr.mDrawableHeightRight : 0)) / 2;
        final float scale = getResources().getDisplayMetrics().density;
        int var129D48EDBF4D32FA5289302197DB6E49_1908608713 = (icontop + (dr != null ? dr.mDrawableHeightRight : 0) - getHeight() -
                (int) (2 * scale + 0.5f));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1517135295 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1517135295;
        // ---------- Original Method ----------
        //final int compoundPaddingTop = getCompoundPaddingTop();
        //int vspace = mBottom - mTop - getCompoundPaddingBottom() - compoundPaddingTop;
        //final Drawables dr = mDrawables;
        //int icontop = compoundPaddingTop +
                //(vspace - (dr != null ? dr.mDrawableHeightRight : 0)) / 2;
        //final float scale = getResources().getDisplayMetrics().density;
        //return icontop + (dr != null ? dr.mDrawableHeightRight : 0) - getHeight() -
                //(int) (2 * scale + 0.5f);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.553 -0400", hash_original_method = "F599686205634A1B40098A399108C287", hash_generated_method = "3E60437149AFDC7C5C93407C72A3672F")
    private void hideError() {
        if(mPopup != null)        
        {
            if(mPopup.isShowing())            
            {
                mPopup.dismiss();
            } //End block
        } //End block
        mShowErrorAfterAttach = false;
        // ---------- Original Method ----------
        //if (mPopup != null) {
            //if (mPopup.isShowing()) {
                //mPopup.dismiss();
            //}
        //}
        //mShowErrorAfterAttach = false;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.553 -0400", hash_original_method = "E776865F48A57A0CE6F068EC64FA9769", hash_generated_method = "E78D2A6FB781A40E46A59132BAA204CE")
    private void chooseSize(PopupWindow pop, CharSequence text, TextView tv) {
        addTaint(tv.getTaint());
        addTaint(text.getTaint());
        addTaint(pop.getTaint());
        int wid = tv.getPaddingLeft() + tv.getPaddingRight();
        int ht = tv.getPaddingTop() + tv.getPaddingBottom();
        int defaultWidthInPixels = getResources().getDimensionPixelSize(
                com.android.internal.R.dimen.textview_error_popup_default_width);
        Layout l = new StaticLayout(text, tv.getPaint(), defaultWidthInPixels,
                                    Layout.Alignment.ALIGN_NORMAL, 1, 0, true);
        float max = 0;
for(int i = 0;i < l.getLineCount();i++)
        {
            max = Math.max(max, l.getLineWidth(i));
        } //End block
        pop.setWidth(wid + (int) Math.ceil(max));
        pop.setHeight(ht + l.getHeight());
        // ---------- Original Method ----------
        //int wid = tv.getPaddingLeft() + tv.getPaddingRight();
        //int ht = tv.getPaddingTop() + tv.getPaddingBottom();
        //int defaultWidthInPixels = getResources().getDimensionPixelSize(
                //com.android.internal.R.dimen.textview_error_popup_default_width);
        //Layout l = new StaticLayout(text, tv.getPaint(), defaultWidthInPixels,
                                    //Layout.Alignment.ALIGN_NORMAL, 1, 0, true);
        //float max = 0;
        //for (int i = 0; i < l.getLineCount(); i++) {
            //max = Math.max(max, l.getLineWidth(i));
        //}
        //pop.setWidth(wid + (int) Math.ceil(max));
        //pop.setHeight(ht + l.getHeight());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.554 -0400", hash_original_method = "5914A6C90CD99156CDEB55240C7F0CC3", hash_generated_method = "0E161A490A97A0A103FDE3847FCDEAB9")
    @Override
    protected boolean setFrame(int l, int t, int r, int b) {
        addTaint(b);
        addTaint(r);
        addTaint(t);
        addTaint(l);
        boolean result = super.setFrame(l, t, r, b);
        if(mPopup != null)        
        {
            TextView tv = (TextView) mPopup.getContentView();
            chooseSize(mPopup, mError, tv);
            mPopup.update(this, getErrorX(), getErrorY(),
                          mPopup.getWidth(), mPopup.getHeight());
        } //End block
        restartMarqueeIfNeeded();
        boolean varB4A88417B3D0170D754C647C30B7216A_679953743 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1009773967 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1009773967;
        // ---------- Original Method ----------
        //boolean result = super.setFrame(l, t, r, b);
        //if (mPopup != null) {
            //TextView tv = (TextView) mPopup.getContentView();
            //chooseSize(mPopup, mError, tv);
            //mPopup.update(this, getErrorX(), getErrorY(),
                          //mPopup.getWidth(), mPopup.getHeight());
        //}
        //restartMarqueeIfNeeded();
        //return result;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.554 -0400", hash_original_method = "F008D6FB8FE5770ECA7C6E535BB409D7", hash_generated_method = "1C99F8A2013AA6096406A9A9CAAECDFC")
    private void restartMarqueeIfNeeded() {
        if(mRestartMarquee && mEllipsize == TextUtils.TruncateAt.MARQUEE)        
        {
            mRestartMarquee = false;
            startMarquee();
        } //End block
        // ---------- Original Method ----------
        //if (mRestartMarquee && mEllipsize == TextUtils.TruncateAt.MARQUEE) {
            //mRestartMarquee = false;
            //startMarquee();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.554 -0400", hash_original_method = "BC1716C27CAAB9B1A5BA926037A5041B", hash_generated_method = "382660D08852C672AEA2A7DA855B26E5")
    public void setFilters(InputFilter[] filters) {
        if(filters == null)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1324206160 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1324206160.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1324206160;
        } //End block
        mFilters = filters;
        if(mText instanceof Editable)        
        {
            setFilters((Editable) mText, filters);
        } //End block
        // ---------- Original Method ----------
        //if (filters == null) {
            //throw new IllegalArgumentException();
        //}
        //mFilters = filters;
        //if (mText instanceof Editable) {
            //setFilters((Editable) mText, filters);
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.554 -0400", hash_original_method = "48C3B4A6108D00EDE1CFE79059C5E0E2", hash_generated_method = "0D1857C4AF252A82523D2516A9AA2A3F")
    private void setFilters(Editable e, InputFilter[] filters) {
        addTaint(filters[0].getTaint());
        addTaint(e.getTaint());
        if(mInput instanceof InputFilter)        
        {
            InputFilter[] nf = new InputFilter[filters.length + 1];
            System.arraycopy(filters, 0, nf, 0, filters.length);
            nf[filters.length] = (InputFilter) mInput;
            e.setFilters(nf);
        } //End block
        else
        {
            e.setFilters(filters);
        } //End block
        // ---------- Original Method ----------
        //if (mInput instanceof InputFilter) {
            //InputFilter[] nf = new InputFilter[filters.length + 1];
            //System.arraycopy(filters, 0, nf, 0, filters.length);
            //nf[filters.length] = (InputFilter) mInput;
            //e.setFilters(nf);
        //} else {
            //e.setFilters(filters);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.554 -0400", hash_original_method = "E0010D0DD1DD8F03E408AEE972028B3D", hash_generated_method = "343608E896E38A7B822B97CDC493E57E")
    public InputFilter[] getFilters() {
InputFilter[] var316611332C0E9FDC07189D6D7F9B848B_1675872211 =         mFilters;
        var316611332C0E9FDC07189D6D7F9B848B_1675872211.addTaint(taint);
        return var316611332C0E9FDC07189D6D7F9B848B_1675872211;
        // ---------- Original Method ----------
        //return mFilters;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.555 -0400", hash_original_method = "DAA92D774C652EE383E55D96FD59260D", hash_generated_method = "30F4CEAB8F84B3FF7DBD36DA10BE160E")
    private int getVerticalOffset(boolean forceNormal) {
        addTaint(forceNormal);
        int voffset = 0;
        final int gravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
        Layout l = mLayout;
        if(!forceNormal && mText.length() == 0 && mHintLayout != null)        
        {
            l = mHintLayout;
        } //End block
        if(gravity != Gravity.TOP)        
        {
            int boxht;
            if(l == mHintLayout)            
            {
                boxht = getMeasuredHeight() - getCompoundPaddingTop() -
                        getCompoundPaddingBottom();
            } //End block
            else
            {
                boxht = getMeasuredHeight() - getExtendedPaddingTop() -
                        getExtendedPaddingBottom();
            } //End block
            int textht = l.getHeight();
            if(textht < boxht)            
            {
                if(gravity == Gravity.BOTTOM)                
                voffset = boxht - textht;
                else
                voffset = (boxht - textht) >> 1;
            } //End block
        } //End block
        int varEA21ED3A850C0D82BD7CF16C07D3BEE1_401843750 = (voffset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1530047844 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1530047844;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.556 -0400", hash_original_method = "FA4757416C7C28BA09CF9D290B4D7551", hash_generated_method = "DEE1DD6FFEAD1783D63112B322503547")
    private int getBottomVerticalOffset(boolean forceNormal) {
        addTaint(forceNormal);
        int voffset = 0;
        final int gravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
        Layout l = mLayout;
        if(!forceNormal && mText.length() == 0 && mHintLayout != null)        
        {
            l = mHintLayout;
        } //End block
        if(gravity != Gravity.BOTTOM)        
        {
            int boxht;
            if(l == mHintLayout)            
            {
                boxht = getMeasuredHeight() - getCompoundPaddingTop() -
                        getCompoundPaddingBottom();
            } //End block
            else
            {
                boxht = getMeasuredHeight() - getExtendedPaddingTop() -
                        getExtendedPaddingBottom();
            } //End block
            int textht = l.getHeight();
            if(textht < boxht)            
            {
                if(gravity == Gravity.TOP)                
                voffset = boxht - textht;
                else
                voffset = (boxht - textht) >> 1;
            } //End block
        } //End block
        int varEA21ED3A850C0D82BD7CF16C07D3BEE1_819562361 = (voffset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1501007515 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1501007515;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.557 -0400", hash_original_method = "53216DF5147B6AD3B10E93427C42A87D", hash_generated_method = "5C622D77502747A6FEC94066DD14A0FB")
    private void invalidateCursorPath() {
        if(mHighlightPathBogus)        
        {
            invalidateCursor();
        } //End block
        else
        {
            final int horizontalPadding = getCompoundPaddingLeft();
            final int verticalPadding = getExtendedPaddingTop() + getVerticalOffset(true);
            if(mCursorCount == 0)            
            {
                synchronized
(sTempRect)                {
                    float thick = FloatMath.ceil(mTextPaint.getStrokeWidth());
                    if(thick < 1.0f)                    
                    {
                        thick = 1.0f;
                    } //End block
                    thick /= 2.0f;
                    mHighlightPath.computeBounds(sTempRect, false);
                    invalidate((int) FloatMath.floor(horizontalPadding + sTempRect.left - thick),
                            (int) FloatMath.floor(verticalPadding + sTempRect.top - thick),
                            (int) FloatMath.ceil(horizontalPadding + sTempRect.right + thick),
                            (int) FloatMath.ceil(verticalPadding + sTempRect.bottom + thick));
                } //End block
            } //End block
            else
            {
for(int i = 0;i < mCursorCount;i++)
                {
                    Rect bounds = mCursorDrawable[i].getBounds();
                    invalidate(bounds.left + horizontalPadding, bounds.top + verticalPadding,
                            bounds.right + horizontalPadding, bounds.bottom + verticalPadding);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.557 -0400", hash_original_method = "18CF38FA770F258E57001CEB5008E4BD", hash_generated_method = "E1D6820191EB703EFE114B58505AECB6")
    private void invalidateCursor() {
        int where = getSelectionEnd();
        invalidateCursor(where, where, where);
        // ---------- Original Method ----------
        //int where = getSelectionEnd();
        //invalidateCursor(where, where, where);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.557 -0400", hash_original_method = "7C61928A88071E487AF3987FA1C70EFA", hash_generated_method = "29A665B5420CE23F38E435E49CB65B37")
    private void invalidateCursor(int a, int b, int c) {
        addTaint(c);
        addTaint(b);
        addTaint(a);
        if(a >= 0 || b >= 0 || c >= 0)        
        {
            int start = Math.min(Math.min(a, b), c);
            int end = Math.max(Math.max(a, b), c);
            invalidateRegion(start, end, true );
        } //End block
        // ---------- Original Method ----------
        //if (a >= 0 || b >= 0 || c >= 0) {
            //int start = Math.min(Math.min(a, b), c);
            //int end = Math.max(Math.max(a, b), c);
            //invalidateRegion(start, end, true );
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.559 -0400", hash_original_method = "D9CEA3E6F10B2E8340E14518563D9425", hash_generated_method = "46E50A1FF1DE1B01B274A73078690BC4")
     void invalidateRegion(int start, int end, boolean invalidateCursor) {
        addTaint(invalidateCursor);
        addTaint(end);
        addTaint(start);
        if(mLayout == null)        
        {
            invalidate();
        } //End block
        else
        {
            int lineStart = mLayout.getLineForOffset(start);
            int top = mLayout.getLineTop(lineStart);
            if(lineStart > 0)            
            {
                top -= mLayout.getLineDescent(lineStart - 1);
            } //End block
            int lineEnd;
            if(start == end)            
            lineEnd = lineStart;
            else
            lineEnd = mLayout.getLineForOffset(end);
            int bottom = mLayout.getLineBottom(lineEnd);
            if(invalidateCursor)            
            {
for(int i = 0;i < mCursorCount;i++)
                {
                    Rect bounds = mCursorDrawable[i].getBounds();
                    top = Math.min(top, bounds.top);
                    bottom = Math.max(bottom, bounds.bottom);
                } //End block
            } //End block
            final int compoundPaddingLeft = getCompoundPaddingLeft();
            final int verticalPadding = getExtendedPaddingTop() + getVerticalOffset(true);
            int left;
            int right;
            if(lineStart == lineEnd && !invalidateCursor)            
            {
                left = (int) mLayout.getPrimaryHorizontal(start);
                right = (int) (mLayout.getPrimaryHorizontal(end) + 1.0);
                left += compoundPaddingLeft;
                right += compoundPaddingLeft;
            } //End block
            else
            {
                left = compoundPaddingLeft;
                right = getWidth() - getCompoundPaddingRight();
            } //End block
            invalidate(mScrollX + left, verticalPadding + top,
                        mScrollX + right, verticalPadding + bottom);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.560 -0400", hash_original_method = "14444C10F141ED0D65415BFE9043EE15", hash_generated_method = "6725C7B603CE0027261B343108B7D9C2")
    private void registerForPreDraw() {
        final ViewTreeObserver observer = getViewTreeObserver();
        if(mPreDrawState == PREDRAW_NOT_REGISTERED)        
        {
            observer.addOnPreDrawListener(this);
            mPreDrawState = PREDRAW_PENDING;
        } //End block
        else
        if(mPreDrawState == PREDRAW_DONE)        
        {
            mPreDrawState = PREDRAW_PENDING;
        } //End block
        // ---------- Original Method ----------
        //final ViewTreeObserver observer = getViewTreeObserver();
        //if (mPreDrawState == PREDRAW_NOT_REGISTERED) {
            //observer.addOnPreDrawListener(this);
            //mPreDrawState = PREDRAW_PENDING;
        //} else if (mPreDrawState == PREDRAW_DONE) {
            //mPreDrawState = PREDRAW_PENDING;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.560 -0400", hash_original_method = "7ED99206FCCA4C828A375B5616572C0F", hash_generated_method = "8DBD291C1FBDC4EE283EE4319B69E6CF")
    public boolean onPreDraw() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(mPreDrawState != PREDRAW_PENDING)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1355402412 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_295064705 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_295064705;
        } //End block
        if(mLayout == null)        
        {
            assumeLayout();
        } //End block
        boolean changed = false;
        if(mMovement != null)        
        {
            int curs = getSelectionEnd();
            if(mSelectionModifierCursorController != null &&
                    mSelectionModifierCursorController.isSelectionStartDragged())            
            {
                curs = getSelectionStart();
            } //End block
            if(curs < 0 &&
                  (mGravity & Gravity.VERTICAL_GRAVITY_MASK) == Gravity.BOTTOM)            
            {
                curs = mText.length();
            } //End block
            if(curs >= 0)            
            {
                changed = bringPointIntoView(curs);
            } //End block
        } //End block
        else
        {
            changed = bringTextIntoView();
        } //End block
        if(mCreatedWithASelection)        
        {
            startSelectionActionMode();
            mCreatedWithASelection = false;
        } //End block
        if(this instanceof ExtractEditText && hasSelection())        
        {
            startSelectionActionMode();
        } //End block
        mPreDrawState = PREDRAW_DONE;
        boolean varBA49486E983012D21F3C79CB5A3E4802_1146795285 = (!changed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1412475404 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1412475404;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.561 -0400", hash_original_method = "37A00D47E5792B2A68D22343089CAC73", hash_generated_method = "2D433FD40BF58F5DCEB9DBFE8859B7D0")
    @Override
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAttachedToWindow();
        mTemporaryDetach = false;
        if(mShowErrorAfterAttach)        
        {
            showError();
            mShowErrorAfterAttach = false;
        } //End block
        final ViewTreeObserver observer = getViewTreeObserver();
        if(mInsertionPointCursorController != null)        
        {
            observer.addOnTouchModeChangeListener(mInsertionPointCursorController);
        } //End block
        if(mSelectionModifierCursorController != null)        
        {
            observer.addOnTouchModeChangeListener(mSelectionModifierCursorController);
        } //End block
        resolveDrawables();
        updateSpellCheckSpans(0, mText.length(), true );
        // ---------- Original Method ----------
        //super.onAttachedToWindow();
        //mTemporaryDetach = false;
        //if (mShowErrorAfterAttach) {
            //showError();
            //mShowErrorAfterAttach = false;
        //}
        //final ViewTreeObserver observer = getViewTreeObserver();
        //if (mInsertionPointCursorController != null) {
            //observer.addOnTouchModeChangeListener(mInsertionPointCursorController);
        //}
        //if (mSelectionModifierCursorController != null) {
            //observer.addOnTouchModeChangeListener(mSelectionModifierCursorController);
        //}
        //resolveDrawables();
        //updateSpellCheckSpans(0, mText.length(), true );
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.561 -0400", hash_original_method = "16099E9CBA4D38D7973AB46B58716911", hash_generated_method = "4B766ACA0C472AED8C5E1596B1AD321E")
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDetachedFromWindow();
        final ViewTreeObserver observer = getViewTreeObserver();
        if(mPreDrawState != PREDRAW_NOT_REGISTERED)        
        {
            observer.removeOnPreDrawListener(this);
            mPreDrawState = PREDRAW_NOT_REGISTERED;
        } //End block
        if(mError != null)        
        {
            hideError();
        } //End block
        if(mBlink != null)        
        {
            mBlink.removeCallbacks(mBlink);
        } //End block
        if(mInsertionPointCursorController != null)        
        {
            mInsertionPointCursorController.onDetached();
        } //End block
        if(mSelectionModifierCursorController != null)        
        {
            mSelectionModifierCursorController.onDetached();
        } //End block
        hideControllers();
        resetResolvedDrawables();
        if(mSpellChecker != null)        
        {
            mSpellChecker.closeSession();
            mSpellChecker = null;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.561 -0400", hash_original_method = "F9485E7598554FF005152B05BE66332E", hash_generated_method = "08B281BB863FBC9520CCF4912E26E06D")
    @Override
    protected boolean isPaddingOffsetRequired() {
        boolean varA06631451306A935FB3AB6BBCD81022A_1438579051 = (mShadowRadius != 0 || mDrawables != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2017209511 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2017209511;
        // ---------- Original Method ----------
        //return mShadowRadius != 0 || mDrawables != null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.562 -0400", hash_original_method = "7F5FAD56D372BFDBD8919382F1DF4F10", hash_generated_method = "5BF499B283076FC405CF44474FEC34FD")
    @Override
    protected int getLeftPaddingOffset() {
        int var80D6525FFA1FA0C36B1709D80FAE877D_1503205740 = (getCompoundPaddingLeft() - mPaddingLeft +
                (int) Math.min(0, mShadowDx - mShadowRadius));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_968354700 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_968354700;
        // ---------- Original Method ----------
        //return getCompoundPaddingLeft() - mPaddingLeft +
                //(int) Math.min(0, mShadowDx - mShadowRadius);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.562 -0400", hash_original_method = "BBBA34DDC8A574B01D58B3AC0235EEFE", hash_generated_method = "DC4C277C5D9CE69B7B021DD6D639FB9D")
    @Override
    protected int getTopPaddingOffset() {
        int var2DF75988CB611C2FDC3C9713E763552F_1700840705 = ((int) Math.min(0, mShadowDy - mShadowRadius));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1624412440 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1624412440;
        // ---------- Original Method ----------
        //return (int) Math.min(0, mShadowDy - mShadowRadius);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.562 -0400", hash_original_method = "2F5480661817CC97DFDD529692B7CB6A", hash_generated_method = "E75B97CD145D9E0B518D1AD91BBCA102")
    @Override
    protected int getBottomPaddingOffset() {
        int varC4B391EFB0E0067200D6C9C49C2B2E08_1034902652 = ((int) Math.max(0, mShadowDy + mShadowRadius));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_64275808 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_64275808;
        // ---------- Original Method ----------
        //return (int) Math.max(0, mShadowDy + mShadowRadius);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.562 -0400", hash_original_method = "03B94E40D261DCBBD1910980153D8E7A", hash_generated_method = "CEB914C0F353569E170A13A6D3CE09DE")
    @Override
    protected int getRightPaddingOffset() {
        int var1E00D86C6CEA7A969058B6C3BDC0F487_1501413199 = (-(getCompoundPaddingRight() - mPaddingRight) +
                (int) Math.max(0, mShadowDx + mShadowRadius));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1672153688 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1672153688;
        // ---------- Original Method ----------
        //return -(getCompoundPaddingRight() - mPaddingRight) +
                //(int) Math.max(0, mShadowDx + mShadowRadius);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.562 -0400", hash_original_method = "CE928B829998126087759CE89BCD7C50", hash_generated_method = "72AA6C84370EFB7241D7C05A68626AAF")
    @Override
    protected boolean verifyDrawable(Drawable who) {
        addTaint(who.getTaint());
        final boolean verified = super.verifyDrawable(who);
        if(!verified && mDrawables != null)        
        {
            boolean var7C72BA0D6BD14D8EA14B904BC5241A81_280723287 = (who == mDrawables.mDrawableLeft || who == mDrawables.mDrawableTop ||
                    who == mDrawables.mDrawableRight || who == mDrawables.mDrawableBottom ||
                    who == mDrawables.mDrawableStart || who == mDrawables.mDrawableEnd);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1315621758 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1315621758;
        } //End block
        boolean var723AA82A83C278D5E7E7BE9B109B406A_1960239671 = (verified);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1870782327 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1870782327;
        // ---------- Original Method ----------
        //final boolean verified = super.verifyDrawable(who);
        //if (!verified && mDrawables != null) {
            //return who == mDrawables.mDrawableLeft || who == mDrawables.mDrawableTop ||
                    //who == mDrawables.mDrawableRight || who == mDrawables.mDrawableBottom ||
                    //who == mDrawables.mDrawableStart || who == mDrawables.mDrawableEnd;
        //}
        //return verified;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.563 -0400", hash_original_method = "40478AC632904F83B590338EFFF77EC4", hash_generated_method = "04F1480AC0FC6A4EEF9C04774E2212B6")
    @Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if(mDrawables != null)        
        {
            if(mDrawables.mDrawableLeft != null)            
            {
                mDrawables.mDrawableLeft.jumpToCurrentState();
            } //End block
            if(mDrawables.mDrawableTop != null)            
            {
                mDrawables.mDrawableTop.jumpToCurrentState();
            } //End block
            if(mDrawables.mDrawableRight != null)            
            {
                mDrawables.mDrawableRight.jumpToCurrentState();
            } //End block
            if(mDrawables.mDrawableBottom != null)            
            {
                mDrawables.mDrawableBottom.jumpToCurrentState();
            } //End block
            if(mDrawables.mDrawableStart != null)            
            {
                mDrawables.mDrawableStart.jumpToCurrentState();
            } //End block
            if(mDrawables.mDrawableEnd != null)            
            {
                mDrawables.mDrawableEnd.jumpToCurrentState();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.563 -0400", hash_original_method = "BFAA7AB246AB7FE030F8E5E06E7C4938", hash_generated_method = "A6FBECCAEFE778163A581F961CDD4E96")
    @Override
    public void invalidateDrawable(Drawable drawable) {
        addTaint(drawable.getTaint());
        if(verifyDrawable(drawable))        
        {
            final Rect dirty = drawable.getBounds();
            int scrollX = mScrollX;
            int scrollY = mScrollY;
            final TextView.Drawables drawables = mDrawables;
            if(drawables != null)            
            {
                if(drawable == drawables.mDrawableLeft)                
                {
                    final int compoundPaddingTop = getCompoundPaddingTop();
                    final int compoundPaddingBottom = getCompoundPaddingBottom();
                    final int vspace = mBottom - mTop - compoundPaddingBottom - compoundPaddingTop;
                    scrollX += mPaddingLeft;
                    scrollY += compoundPaddingTop + (vspace - drawables.mDrawableHeightLeft) / 2;
                } //End block
                else
                if(drawable == drawables.mDrawableRight)                
                {
                    final int compoundPaddingTop = getCompoundPaddingTop();
                    final int compoundPaddingBottom = getCompoundPaddingBottom();
                    final int vspace = mBottom - mTop - compoundPaddingBottom - compoundPaddingTop;
                    scrollX += (mRight - mLeft - mPaddingRight - drawables.mDrawableSizeRight);
                    scrollY += compoundPaddingTop + (vspace - drawables.mDrawableHeightRight) / 2;
                } //End block
                else
                if(drawable == drawables.mDrawableTop)                
                {
                    final int compoundPaddingLeft = getCompoundPaddingLeft();
                    final int compoundPaddingRight = getCompoundPaddingRight();
                    final int hspace = mRight - mLeft - compoundPaddingRight - compoundPaddingLeft;
                    scrollX += compoundPaddingLeft + (hspace - drawables.mDrawableWidthTop) / 2;
                    scrollY += mPaddingTop;
                } //End block
                else
                if(drawable == drawables.mDrawableBottom)                
                {
                    final int compoundPaddingLeft = getCompoundPaddingLeft();
                    final int compoundPaddingRight = getCompoundPaddingRight();
                    final int hspace = mRight - mLeft - compoundPaddingRight - compoundPaddingLeft;
                    scrollX += compoundPaddingLeft + (hspace - drawables.mDrawableWidthBottom) / 2;
                    scrollY += (mBottom - mTop - mPaddingBottom - drawables.mDrawableSizeBottom);
                } //End block
            } //End block
            invalidate(dirty.left + scrollX, dirty.top + scrollY,
                    dirty.right + scrollX, dirty.bottom + scrollY);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.564 -0400", hash_original_method = "365B978F98464E672BAE2334EE130C56", hash_generated_method = "AD14FD6369D82B7B3EDD8C508039D78B")
    @Override
    public int getResolvedLayoutDirection(Drawable who) {
        addTaint(who.getTaint());
        if(who == null)        
        {
        int var0022DEAFD3E04A6D20D4B94D2FF4C05B_451835032 = (View.LAYOUT_DIRECTION_LTR);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_358951105 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_358951105;
        }
        if(mDrawables != null)        
        {
            final Drawables drawables = mDrawables;
            if(who == drawables.mDrawableLeft || who == drawables.mDrawableRight ||
                who == drawables.mDrawableTop || who == drawables.mDrawableBottom ||
                who == drawables.mDrawableStart || who == drawables.mDrawableEnd)            
            {
                int var95F073B7CB258363B0F5B8039FE51EFD_746509838 = (getResolvedLayoutDirection());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1407701466 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1407701466;
            } //End block
        } //End block
        int varE69D2B7CE6467A79217ADF9F75DAF3A9_474965312 = (super.getResolvedLayoutDirection(who));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1088015790 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1088015790;
        // ---------- Original Method ----------
        //if (who == null) return View.LAYOUT_DIRECTION_LTR;
        //if (mDrawables != null) {
            //final Drawables drawables = mDrawables;
            //if (who == drawables.mDrawableLeft || who == drawables.mDrawableRight ||
                //who == drawables.mDrawableTop || who == drawables.mDrawableBottom ||
                //who == drawables.mDrawableStart || who == drawables.mDrawableEnd) {
                //return getResolvedLayoutDirection();
            //}
        //}
        //return super.getResolvedLayoutDirection(who);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.565 -0400", hash_original_method = "361EEEB4229AF287B326C983EB9B20B0", hash_generated_method = "3DE45973B4A340C5415124A27E5AFA6A")
    @Override
    protected boolean onSetAlpha(int alpha) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(getBackground() == null)        
        {
            mCurrentAlpha = alpha;
            final Drawables dr = mDrawables;
            if(dr != null)            
            {
                if(dr.mDrawableLeft != null)                
                dr.mDrawableLeft.mutate().setAlpha(alpha);
                if(dr.mDrawableTop != null)                
                dr.mDrawableTop.mutate().setAlpha(alpha);
                if(dr.mDrawableRight != null)                
                dr.mDrawableRight.mutate().setAlpha(alpha);
                if(dr.mDrawableBottom != null)                
                dr.mDrawableBottom.mutate().setAlpha(alpha);
                if(dr.mDrawableStart != null)                
                dr.mDrawableStart.mutate().setAlpha(alpha);
                if(dr.mDrawableEnd != null)                
                dr.mDrawableEnd.mutate().setAlpha(alpha);
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_37256870 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_86591693 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_86591693;
        } //End block
        mCurrentAlpha = 255;
        boolean var68934A3E9455FA72420237EB05902327_2121505516 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1239743732 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1239743732;
        // ---------- Original Method ----------
        //if (getBackground() == null) {
            //mCurrentAlpha = alpha;
            //final Drawables dr = mDrawables;
            //if (dr != null) {
                //if (dr.mDrawableLeft != null) dr.mDrawableLeft.mutate().setAlpha(alpha);
                //if (dr.mDrawableTop != null) dr.mDrawableTop.mutate().setAlpha(alpha);
                //if (dr.mDrawableRight != null) dr.mDrawableRight.mutate().setAlpha(alpha);
                //if (dr.mDrawableBottom != null) dr.mDrawableBottom.mutate().setAlpha(alpha);
                //if (dr.mDrawableStart != null) dr.mDrawableStart.mutate().setAlpha(alpha);
                //if (dr.mDrawableEnd != null) dr.mDrawableEnd.mutate().setAlpha(alpha);
            //}
            //return true;
        //}
        //mCurrentAlpha = 255;
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.565 -0400", hash_original_method = "CB6193FD8EC60616857FED31421868C5", hash_generated_method = "12D1A038CFE0C9B1DC639FB8CA1D38A7")
    public boolean isTextSelectable() {
        boolean var88EB51C7D3E91FFEE9AABBAB8AB6B76F_1135100408 = (mTextIsSelectable);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1033583617 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1033583617;
        // ---------- Original Method ----------
        //return mTextIsSelectable;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.565 -0400", hash_original_method = "F5356B5CDB0C54713C7C3659E2E49BDB", hash_generated_method = "F69C6BB36C85D5DAEA70974E82C48D37")
    public void setTextIsSelectable(boolean selectable) {
        if(mTextIsSelectable == selectable)        
        return;
        mTextIsSelectable = selectable;
        setFocusableInTouchMode(selectable);
        setFocusable(selectable);
        setClickable(selectable);
        setLongClickable(selectable);
        setMovementMethod(selectable ? ArrowKeyMovementMethod.getInstance() : null);
        setText(getText(), selectable ? BufferType.SPANNABLE : BufferType.NORMAL);
        prepareCursorControllers();
        // ---------- Original Method ----------
        //if (mTextIsSelectable == selectable) return;
        //mTextIsSelectable = selectable;
        //setFocusableInTouchMode(selectable);
        //setFocusable(selectable);
        //setClickable(selectable);
        //setLongClickable(selectable);
        //setMovementMethod(selectable ? ArrowKeyMovementMethod.getInstance() : null);
        //setText(getText(), selectable ? BufferType.SPANNABLE : BufferType.NORMAL);
        //prepareCursorControllers();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.565 -0400", hash_original_method = "E327CCF4B590DA515951F33B48F8FD2D", hash_generated_method = "237B9A766B7B61E53EB819818D699F43")
    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(extraSpace);
        int[] drawableState;
        if(mSingleLine)        
        {
            drawableState = super.onCreateDrawableState(extraSpace);
        } //End block
        else
        {
            drawableState = super.onCreateDrawableState(extraSpace + 1);
            mergeDrawableStates(drawableState, MULTILINE_STATE_SET);
        } //End block
        if(mTextIsSelectable)        
        {
            final int length = drawableState.length;
for(int i = 0;i < length;i++)
            {
                if(drawableState[i] == R.attr.state_pressed)                
                {
                    final int[] nonPressedState = new int[length - 1];
                    System.arraycopy(drawableState, 0, nonPressedState, 0, i);
                    System.arraycopy(drawableState, i + 1, nonPressedState, i, length - i - 1);
                    int[] var3A6C49CB4E15C863B37F0BCBC6153DF6_1593356434 = (nonPressedState);
                                        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_444578979 = {getTaintInt()};
                    return varB4CCCA26F9DB9189C32F33E82D425CFB_444578979;
                } //End block
            } //End block
        } //End block
        int[] var7A12E87773589D809FD51F1A26B9BDA9_497104179 = (drawableState);
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_66182900 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_66182900;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.569 -0400", hash_original_method = "FA11BA597CA3990806012CD62CCA6F49", hash_generated_method = "1F9DE428958017EB5D070495B7EE4949")
    @Override
    protected void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(canvas.getTaint());
        if(mPreDrawState == PREDRAW_DONE)        
        {
            final ViewTreeObserver observer = getViewTreeObserver();
            observer.removeOnPreDrawListener(this);
            mPreDrawState = PREDRAW_NOT_REGISTERED;
        } //End block
        if(mCurrentAlpha <= ViewConfiguration.ALPHA_THRESHOLD_INT)        
        return;
        restartMarqueeIfNeeded();
        super.onDraw(canvas);
        final int compoundPaddingLeft = getCompoundPaddingLeft();
        final int compoundPaddingTop = getCompoundPaddingTop();
        final int compoundPaddingRight = getCompoundPaddingRight();
        final int compoundPaddingBottom = getCompoundPaddingBottom();
        final int scrollX = mScrollX;
        final int scrollY = mScrollY;
        final int right = mRight;
        final int left = mLeft;
        final int bottom = mBottom;
        final int top = mTop;
        final Drawables dr = mDrawables;
        if(dr != null)        
        {
            int vspace = bottom - top - compoundPaddingBottom - compoundPaddingTop;
            int hspace = right - left - compoundPaddingRight - compoundPaddingLeft;
            if(dr.mDrawableLeft != null)            
            {
                canvas.save();
                canvas.translate(scrollX + mPaddingLeft,
                                 scrollY + compoundPaddingTop +
                                 (vspace - dr.mDrawableHeightLeft) / 2);
                dr.mDrawableLeft.draw(canvas);
                canvas.restore();
            } //End block
            if(dr.mDrawableRight != null)            
            {
                canvas.save();
                canvas.translate(scrollX + right - left - mPaddingRight - dr.mDrawableSizeRight,
                         scrollY + compoundPaddingTop + (vspace - dr.mDrawableHeightRight) / 2);
                dr.mDrawableRight.draw(canvas);
                canvas.restore();
            } //End block
            if(dr.mDrawableTop != null)            
            {
                canvas.save();
                canvas.translate(scrollX + compoundPaddingLeft + (hspace - dr.mDrawableWidthTop) / 2,
                        scrollY + mPaddingTop);
                dr.mDrawableTop.draw(canvas);
                canvas.restore();
            } //End block
            if(dr.mDrawableBottom != null)            
            {
                canvas.save();
                canvas.translate(scrollX + compoundPaddingLeft +
                        (hspace - dr.mDrawableWidthBottom) / 2,
                         scrollY + bottom - top - mPaddingBottom - dr.mDrawableSizeBottom);
                dr.mDrawableBottom.draw(canvas);
                canvas.restore();
            } //End block
        } //End block
        int color = mCurTextColor;
        if(mLayout == null)        
        {
            assumeLayout();
        } //End block
        Layout layout = mLayout;
        int cursorcolor = color;
        if(mHint != null && mText.length() == 0)        
        {
            if(mHintTextColor != null)            
            {
                color = mCurHintTextColor;
            } //End block
            layout = mHintLayout;
        } //End block
        mTextPaint.setColor(color);
        if(mCurrentAlpha != 255)        
        {
            mTextPaint.setAlpha((mCurrentAlpha * Color.alpha(color)) / 255);
        } //End block
        mTextPaint.drawableState = getDrawableState();
        canvas.save();
        int extendedPaddingTop = getExtendedPaddingTop();
        int extendedPaddingBottom = getExtendedPaddingBottom();
        float clipLeft = compoundPaddingLeft + scrollX;
        float clipTop = extendedPaddingTop + scrollY;
        float clipRight = right - left - compoundPaddingRight + scrollX;
        float clipBottom = bottom - top - extendedPaddingBottom + scrollY;
        if(mShadowRadius != 0)        
        {
            clipLeft += Math.min(0, mShadowDx - mShadowRadius);
            clipRight += Math.max(0, mShadowDx + mShadowRadius);
            clipTop += Math.min(0, mShadowDy - mShadowRadius);
            clipBottom += Math.max(0, mShadowDy + mShadowRadius);
        } //End block
        canvas.clipRect(clipLeft, clipTop, clipRight, clipBottom);
        int voffsetText = 0;
        int voffsetCursor = 0;
        {
            if((mGravity & Gravity.VERTICAL_GRAVITY_MASK) != Gravity.TOP)            
            {
                voffsetText = getVerticalOffset(false);
                voffsetCursor = getVerticalOffset(true);
            } //End block
            canvas.translate(compoundPaddingLeft, extendedPaddingTop + voffsetText);
        } //End block
        final int layoutDirection = getResolvedLayoutDirection();
        final int absoluteGravity = Gravity.getAbsoluteGravity(mGravity, layoutDirection);
        if(mEllipsize == TextUtils.TruncateAt.MARQUEE &&
                mMarqueeFadeMode != MARQUEE_FADE_SWITCH_SHOW_ELLIPSIS)        
        {
            if(!mSingleLine && getLineCount() == 1 && canMarquee() &&
                    (absoluteGravity & Gravity.HORIZONTAL_GRAVITY_MASK) != Gravity.LEFT)            
            {
                canvas.translate(mLayout.getLineRight(0) - (mRight - mLeft -
                        getCompoundPaddingLeft() - getCompoundPaddingRight()), 0.0f);
            } //End block
            if(mMarquee != null && mMarquee.isRunning())            
            {
                canvas.translate(-mMarquee.mScroll, 0.0f);
            } //End block
        } //End block
        Path highlight = null;
        int selStart = -1;
        int selEnd = -1;
        boolean drawCursor = false;
        if(mMovement != null && (isFocused() || isPressed()))        
        {
            selStart = getSelectionStart();
            selEnd = getSelectionEnd();
            if(selStart >= 0)            
            {
                if(mHighlightPath == null)                
                mHighlightPath = new Path();
                if(selStart == selEnd)                
                {
                    if(isCursorVisible() &&
                            (SystemClock.uptimeMillis() - mShowCursor) % (2 * BLINK) < BLINK)                    
                    {
                        if(mHighlightPathBogus)                        
                        {
                            mHighlightPath.reset();
                            mLayout.getCursorPath(selStart, mHighlightPath, mText);
                            updateCursorsPositions();
                            mHighlightPathBogus = false;
                        } //End block
                        mHighlightPaint.setColor(cursorcolor);
                        if(mCurrentAlpha != 255)                        
                        {
                            mHighlightPaint.setAlpha(
                                    (mCurrentAlpha * Color.alpha(cursorcolor)) / 255);
                        } //End block
                        mHighlightPaint.setStyle(Paint.Style.STROKE);
                        highlight = mHighlightPath;
                        drawCursor = mCursorCount > 0;
                    } //End block
                } //End block
                else
                if(textCanBeSelected())                
                {
                    if(mHighlightPathBogus)                    
                    {
                        mHighlightPath.reset();
                        mLayout.getSelectionPath(selStart, selEnd, mHighlightPath);
                        mHighlightPathBogus = false;
                    } //End block
                    mHighlightPaint.setColor(mHighlightColor);
                    if(mCurrentAlpha != 255)                    
                    {
                        mHighlightPaint.setAlpha(
                                (mCurrentAlpha * Color.alpha(mHighlightColor)) / 255);
                    } //End block
                    mHighlightPaint.setStyle(Paint.Style.FILL);
                    highlight = mHighlightPath;
                } //End block
            } //End block
        } //End block
        final InputMethodState ims = mInputMethodState;
        final int cursorOffsetVertical = voffsetCursor - voffsetText;
        if(ims != null && ims.mBatchEditNesting == 0)        
        {
            InputMethodManager imm = InputMethodManager.peekInstance();
            if(imm != null)            
            {
                if(imm.isActive(this))                
                {
                    boolean reported = false;
                    if(ims.mContentChanged || ims.mSelectionModeChanged)                    
                    {
                        reported = reportExtractedText();
                    } //End block
                    if(!reported && highlight != null)                    
                    {
                        int candStart = -1;
                        int candEnd = -1;
                        if(mText instanceof Spannable)                        
                        {
                            Spannable sp = (Spannable)mText;
                            candStart = EditableInputConnection.getComposingSpanStart(sp);
                            candEnd = EditableInputConnection.getComposingSpanEnd(sp);
                        } //End block
                        imm.updateSelection(this, selStart, selEnd, candStart, candEnd);
                    } //End block
                } //End block
                if(imm.isWatchingCursor(this) && highlight != null)                
                {
                    highlight.computeBounds(ims.mTmpRectF, true);
                    ims.mTmpOffset[0] = ims.mTmpOffset[1] = 0;
                    canvas.getMatrix().mapPoints(ims.mTmpOffset);
                    ims.mTmpRectF.offset(ims.mTmpOffset[0], ims.mTmpOffset[1]);
                    ims.mTmpRectF.offset(0, cursorOffsetVertical);
                    ims.mCursorRectInWindow.set((int)(ims.mTmpRectF.left + 0.5),
                            (int)(ims.mTmpRectF.top + 0.5),
                            (int)(ims.mTmpRectF.right + 0.5),
                            (int)(ims.mTmpRectF.bottom + 0.5));
                    imm.updateCursor(this,
                            ims.mCursorRectInWindow.left, ims.mCursorRectInWindow.top,
                            ims.mCursorRectInWindow.right, ims.mCursorRectInWindow.bottom);
                } //End block
            } //End block
        } //End block
        if(mCorrectionHighlighter != null)        
        {
            mCorrectionHighlighter.draw(canvas, cursorOffsetVertical);
        } //End block
        if(drawCursor)        
        {
            drawCursor(canvas, cursorOffsetVertical);
            highlight = null;
        } //End block
        layout.draw(canvas, highlight, mHighlightPaint, cursorOffsetVertical);
        if(mMarquee != null && mMarquee.shouldDrawGhost())        
        {
            canvas.translate((int) mMarquee.getGhostOffset(), 0.0f);
            layout.draw(canvas, highlight, mHighlightPaint, cursorOffsetVertical);
        } //End block
        canvas.restore();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.573 -0400", hash_original_method = "78F759649DF9DADE7AC797D0043ECB32", hash_generated_method = "96EA1D3BA078EC87199428AB4F71DA64")
    private void updateCursorsPositions() {
        if(mCursorDrawableRes == 0)        
        {
            mCursorCount = 0;
            return;
        } //End block
        final int offset = getSelectionStart();
        final int line = mLayout.getLineForOffset(offset);
        final int top = mLayout.getLineTop(line);
        final int bottom = mLayout.getLineTop(line + 1);
        mCursorCount = mLayout.isLevelBoundary(offset) ? 2 : 1;
        int middle = bottom;
        if(mCursorCount == 2)        
        {
            middle = (top + bottom) >> 1;
        } //End block
        updateCursorPosition(0, top, middle, mLayout.getPrimaryHorizontal(offset));
        if(mCursorCount == 2)        
        {
            updateCursorPosition(1, middle, bottom, mLayout.getSecondaryHorizontal(offset));
        } //End block
        // ---------- Original Method ----------
        //if (mCursorDrawableRes == 0) {
            //mCursorCount = 0;
            //return; 
        //}
        //final int offset = getSelectionStart();
        //final int line = mLayout.getLineForOffset(offset);
        //final int top = mLayout.getLineTop(line);
        //final int bottom = mLayout.getLineTop(line + 1);
        //mCursorCount = mLayout.isLevelBoundary(offset) ? 2 : 1;
        //int middle = bottom;
        //if (mCursorCount == 2) {
            //middle = (top + bottom) >> 1;
        //}
        //updateCursorPosition(0, top, middle, mLayout.getPrimaryHorizontal(offset));
        //if (mCursorCount == 2) {
            //updateCursorPosition(1, middle, bottom, mLayout.getSecondaryHorizontal(offset));
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.574 -0400", hash_original_method = "E19C5E504E793D85568DEA288EC3BB71", hash_generated_method = "A8DB38769F6BB934F1B6CFA0A4EDC52A")
    private void updateCursorPosition(int cursorIndex, int top, int bottom, float horizontal) {
        addTaint(horizontal);
        addTaint(bottom);
        addTaint(top);
        if(mCursorDrawable[cursorIndex] == null)        
        mCursorDrawable[cursorIndex] = mContext.getResources().getDrawable(mCursorDrawableRes);
        if(mTempRect == null)        
        mTempRect = new Rect();
        mCursorDrawable[cursorIndex].getPadding(mTempRect);
        final int width = mCursorDrawable[cursorIndex].getIntrinsicWidth();
        horizontal = Math.max(0.5f, horizontal - 0.5f);
        final int left = (int) (horizontal) - mTempRect.left;
        mCursorDrawable[cursorIndex].setBounds(left, top - mTempRect.top, left + width,
                bottom + mTempRect.bottom);
        // ---------- Original Method ----------
        //if (mCursorDrawable[cursorIndex] == null)
            //mCursorDrawable[cursorIndex] = mContext.getResources().getDrawable(mCursorDrawableRes);
        //if (mTempRect == null) mTempRect = new Rect();
        //mCursorDrawable[cursorIndex].getPadding(mTempRect);
        //final int width = mCursorDrawable[cursorIndex].getIntrinsicWidth();
        //horizontal = Math.max(0.5f, horizontal - 0.5f);
        //final int left = (int) (horizontal) - mTempRect.left;
        //mCursorDrawable[cursorIndex].setBounds(left, top - mTempRect.top, left + width,
                //bottom + mTempRect.bottom);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.574 -0400", hash_original_method = "38A0E9FCBE0DF4E61FBA21D6958F939A", hash_generated_method = "4BF0B2F49BC2A9265CC85BAF987B9EF7")
    private void drawCursor(Canvas canvas, int cursorOffsetVertical) {
        addTaint(cursorOffsetVertical);
        addTaint(canvas.getTaint());
        final boolean translate = cursorOffsetVertical != 0;
        if(translate)        
        canvas.translate(0, cursorOffsetVertical);
for(int i = 0;i < mCursorCount;i++)
        {
            mCursorDrawable[i].draw(canvas);
        } //End block
        if(translate)        
        canvas.translate(0, -cursorOffsetVertical);
        // ---------- Original Method ----------
        //final boolean translate = cursorOffsetVertical != 0;
        //if (translate) canvas.translate(0, cursorOffsetVertical);
        //for (int i = 0; i < mCursorCount; i++) {
            //mCursorDrawable[i].draw(canvas);
        //}
        //if (translate) canvas.translate(0, -cursorOffsetVertical);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.576 -0400", hash_original_method = "9AB167D6C4B117BDFB6C2B72A1D862B5", hash_generated_method = "339B988C46AA7C5683DC8749A8D349FF")
    @Override
    public void getFocusedRect(Rect r) {
        addTaint(r.getTaint());
        if(mLayout == null)        
        {
            super.getFocusedRect(r);
            return;
        } //End block
        int selEnd = getSelectionEnd();
        if(selEnd < 0)        
        {
            super.getFocusedRect(r);
            return;
        } //End block
        int selStart = getSelectionStart();
        if(selStart < 0 || selStart >= selEnd)        
        {
            int line = mLayout.getLineForOffset(selEnd);
            r.top = mLayout.getLineTop(line);
            r.bottom = mLayout.getLineBottom(line);
            r.left = (int) mLayout.getPrimaryHorizontal(selEnd) - 2;
            r.right = r.left + 4;
        } //End block
        else
        {
            int lineStart = mLayout.getLineForOffset(selStart);
            int lineEnd = mLayout.getLineForOffset(selEnd);
            r.top = mLayout.getLineTop(lineStart);
            r.bottom = mLayout.getLineBottom(lineEnd);
            if(lineStart == lineEnd)            
            {
                r.left = (int) mLayout.getPrimaryHorizontal(selStart);
                r.right = (int) mLayout.getPrimaryHorizontal(selEnd);
            } //End block
            else
            {
                if(mHighlightPath == null)                
                mHighlightPath = new Path();
                if(mHighlightPathBogus)                
                {
                    mHighlightPath.reset();
                    mLayout.getSelectionPath(selStart, selEnd, mHighlightPath);
                    mHighlightPathBogus = false;
                } //End block
                synchronized
(sTempRect)                {
                    mHighlightPath.computeBounds(sTempRect, true);
                    r.left = (int)sTempRect.left-1;
                    r.right = (int)sTempRect.right+1;
                } //End block
            } //End block
        } //End block
        int paddingLeft = getCompoundPaddingLeft();
        int paddingTop = getExtendedPaddingTop();
        if((mGravity & Gravity.VERTICAL_GRAVITY_MASK) != Gravity.TOP)        
        {
            paddingTop += getVerticalOffset(false);
        } //End block
        r.offset(paddingLeft, paddingTop);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.576 -0400", hash_original_method = "97BE8C8E19AAF13DDBB7397BA8716CD7", hash_generated_method = "983F1F5DAAADB21823606BF83A6E9383")
    public int getLineCount() {
        int var6E2D3D9C1F089CF95523DF37620E494E_1117571620 = (mLayout != null ? mLayout.getLineCount() : 0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_347305597 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_347305597;
        // ---------- Original Method ----------
        //return mLayout != null ? mLayout.getLineCount() : 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.577 -0400", hash_original_method = "C119BED798B9C2A141229B29A4C86BDD", hash_generated_method = "390C56A7797A3213236806B0AA19D670")
    public int getLineBounds(int line, Rect bounds) {
        addTaint(bounds.getTaint());
        addTaint(line);
        if(mLayout == null)        
        {
            if(bounds != null)            
            {
                bounds.set(0, 0, 0, 0);
            } //End block
            int varCFCD208495D565EF66E7DFF9F98764DA_199066679 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1798248224 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1798248224;
        } //End block
        else
        {
            int baseline = mLayout.getLineBounds(line, bounds);
            int voffset = getExtendedPaddingTop();
            if((mGravity & Gravity.VERTICAL_GRAVITY_MASK) != Gravity.TOP)            
            {
                voffset += getVerticalOffset(true);
            } //End block
            if(bounds != null)            
            {
                bounds.offset(getCompoundPaddingLeft(), voffset);
            } //End block
            int varA757A3F5E9DA628BE2CF6CE54145E0C0_1425396436 = (baseline + voffset);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_945830888 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_945830888;
        } //End block
        // ---------- Original Method ----------
        //if (mLayout == null) {
            //if (bounds != null) {
                //bounds.set(0, 0, 0, 0);
            //}
            //return 0;
        //}
        //else {
            //int baseline = mLayout.getLineBounds(line, bounds);
            //int voffset = getExtendedPaddingTop();
            //if ((mGravity & Gravity.VERTICAL_GRAVITY_MASK) != Gravity.TOP) {
                //voffset += getVerticalOffset(true);
            //}
            //if (bounds != null) {
                //bounds.offset(getCompoundPaddingLeft(), voffset);
            //}
            //return baseline + voffset;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.578 -0400", hash_original_method = "3C56831CF91C4818C48A7DCC6043867F", hash_generated_method = "C9EB55D547F6A9A75453949DCFD50A22")
    @Override
    public int getBaseline() {
        if(mLayout == null)        
        {
            int var304F84E20A7DBE8F7236867526CDC85A_811870866 = (super.getBaseline());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1830639389 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1830639389;
        } //End block
        int voffset = 0;
        if((mGravity & Gravity.VERTICAL_GRAVITY_MASK) != Gravity.TOP)        
        {
            voffset = getVerticalOffset(true);
        } //End block
        int var1FAC45B8BE2541CF867973BEE1B0C694_1208603494 = (getExtendedPaddingTop() + voffset + mLayout.getLineBaseline(0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_721078541 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_721078541;
        // ---------- Original Method ----------
        //if (mLayout == null) {
            //return super.getBaseline();
        //}
        //int voffset = 0;
        //if ((mGravity & Gravity.VERTICAL_GRAVITY_MASK) != Gravity.TOP) {
            //voffset = getVerticalOffset(true);
        //}
        //return getExtendedPaddingTop() + voffset + mLayout.getLineBaseline(0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.578 -0400", hash_original_method = "9B40D92CA2D66C315619C6CA13460A4B", hash_generated_method = "DEDD03BC6904AA028CD3B0BB1EBC3FF9")
    @Override
    protected int getFadeTop(boolean offsetRequired) {
        addTaint(offsetRequired);
        if(mLayout == null)        
        {
        int varCFCD208495D565EF66E7DFF9F98764DA_1340948065 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_391592143 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_391592143;
        }
        int voffset = 0;
        if((mGravity & Gravity.VERTICAL_GRAVITY_MASK) != Gravity.TOP)        
        {
            voffset = getVerticalOffset(true);
        } //End block
        if(offsetRequired)        
        voffset += getTopPaddingOffset();
        int varEB3961B7F706D43261249920A5EBE003_540932946 = (getExtendedPaddingTop() + voffset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1585168978 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1585168978;
        // ---------- Original Method ----------
        //if (mLayout == null) return 0;
        //int voffset = 0;
        //if ((mGravity & Gravity.VERTICAL_GRAVITY_MASK) != Gravity.TOP) {
            //voffset = getVerticalOffset(true);
        //}
        //if (offsetRequired) voffset += getTopPaddingOffset();
        //return getExtendedPaddingTop() + voffset;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.578 -0400", hash_original_method = "4B4E36AF8D516BA2309E720A4535DE33", hash_generated_method = "4704BC682F6E82A0ADB7CEA9DAAE3079")
    @Override
    protected int getFadeHeight(boolean offsetRequired) {
        addTaint(offsetRequired);
        int var5EF913E58821BBCF7DBCE3F6695910D0_949925658 = (mLayout != null ? mLayout.getHeight() : 0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_510816763 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_510816763;
        // ---------- Original Method ----------
        //return mLayout != null ? mLayout.getHeight() : 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.578 -0400", hash_original_method = "D780B8C0D740C935BBFD0FE1FAA345B5", hash_generated_method = "D75FBF664186550800BB24B6615FD4BD")
    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        if(keyCode == KeyEvent.KEYCODE_BACK)        
        {
            boolean isInSelectionMode = mSelectionActionMode != null;
            if(isInSelectionMode)            
            {
                if(event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0)                
                {
                    KeyEvent.DispatcherState state = getKeyDispatcherState();
                    if(state != null)                    
                    {
                        state.startTracking(event, this);
                    } //End block
                    boolean varB326B5062B2F0E69046810717534CB09_637153750 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_72633972 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_72633972;
                } //End block
                else
                if(event.getAction() == KeyEvent.ACTION_UP)                
                {
                    KeyEvent.DispatcherState state = getKeyDispatcherState();
                    if(state != null)                    
                    {
                        state.handleUpEvent(event);
                    } //End block
                    if(event.isTracking() && !event.isCanceled())                    
                    {
                        if(isInSelectionMode)                        
                        {
                            stopSelectionActionMode();
                            boolean varB326B5062B2F0E69046810717534CB09_1178881667 = (true);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_823275682 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_823275682;
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End block
        boolean varD211DC142BF75E7E3C7CE1C752BD391A_650742682 = (super.onKeyPreIme(keyCode, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1627777377 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1627777377;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.579 -0400", hash_original_method = "34FB4F2A2A6D04958B0CB574357346B4", hash_generated_method = "430DC124359E5C8497A625FDCA3C2F20")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        int which = doKeyDown(keyCode, event, null);
        if(which == 0)        
        {
            boolean var947F0C250323B9F4475E02588E9A9740_394622253 = (super.onKeyDown(keyCode, event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_384078964 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_384078964;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1044499986 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_472455406 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_472455406;
        // ---------- Original Method ----------
        //int which = doKeyDown(keyCode, event, null);
        //if (which == 0) {
            //return super.onKeyDown(keyCode, event);
        //}
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.579 -0400", hash_original_method = "29E1D0F837CE3120BC9F0CF834D8CD7B", hash_generated_method = "32A418D19A335AF91137BB364C78B3B2")
    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(repeatCount);
        addTaint(keyCode);
        KeyEvent down = KeyEvent.changeAction(event, KeyEvent.ACTION_DOWN);
        int which = doKeyDown(keyCode, down, event);
        if(which == 0)        
        {
            boolean varA8E571832A8AD04D8142584FC22C6E16_1190613639 = (super.onKeyMultiple(keyCode, repeatCount, event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_394261637 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_394261637;
        } //End block
        if(which == -1)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_792421375 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1847080668 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1847080668;
        } //End block
        repeatCount--;
        KeyEvent up = KeyEvent.changeAction(event, KeyEvent.ACTION_UP);
        if(which == 1)        
        {
            mInput.onKeyUp(this, (Editable)mText, keyCode, up);
            while
(--repeatCount > 0)            
            {
                mInput.onKeyDown(this, (Editable)mText, keyCode, down);
                mInput.onKeyUp(this, (Editable)mText, keyCode, up);
            } //End block
            hideErrorIfUnchanged();
        } //End block
        else
        if(which == 2)        
        {
            mMovement.onKeyUp(this, (Spannable)mText, keyCode, up);
            while
(--repeatCount > 0)            
            {
                mMovement.onKeyDown(this, (Spannable)mText, keyCode, down);
                mMovement.onKeyUp(this, (Spannable)mText, keyCode, up);
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1896171774 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_925990479 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_925990479;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.579 -0400", hash_original_method = "F8A8C23B2901B68727EC4DCE05389523", hash_generated_method = "14AC5CB5FD2CED6F5E12125EEBF5667E")
    private boolean shouldAdvanceFocusOnEnter() {
        if(mInput == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_381858230 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1150725487 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1150725487;
        } //End block
        if(mSingleLine)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1884272716 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1527277176 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1527277176;
        } //End block
        if((mInputType & EditorInfo.TYPE_MASK_CLASS) == EditorInfo.TYPE_CLASS_TEXT)        
        {
            int variation = mInputType & EditorInfo.TYPE_MASK_VARIATION;
            if(variation == EditorInfo.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
                    || variation == EditorInfo.TYPE_TEXT_VARIATION_EMAIL_SUBJECT)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_333287452 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_101348590 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_101348590;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1958015689 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1503742955 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1503742955;
        // ---------- Original Method ----------
        //if (mInput == null) {
            //return false;
        //}
        //if (mSingleLine) {
            //return true;
        //}
        //if ((mInputType & EditorInfo.TYPE_MASK_CLASS) == EditorInfo.TYPE_CLASS_TEXT) {
            //int variation = mInputType & EditorInfo.TYPE_MASK_VARIATION;
            //if (variation == EditorInfo.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
                    //|| variation == EditorInfo.TYPE_TEXT_VARIATION_EMAIL_SUBJECT) {
                //return true;
            //}
        //}
        //return false;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.580 -0400", hash_original_method = "3820039215BEB2B783682B0606CB8390", hash_generated_method = "2350C528707860F511BF916C5481BFDA")
    private boolean shouldAdvanceFocusOnTab() {
        if(mInput != null && !mSingleLine)        
        {
            if((mInputType & EditorInfo.TYPE_MASK_CLASS) == EditorInfo.TYPE_CLASS_TEXT)            
            {
                int variation = mInputType & EditorInfo.TYPE_MASK_VARIATION;
                if(variation == EditorInfo.TYPE_TEXT_FLAG_IME_MULTI_LINE
                        || variation == EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_367416617 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_346568615 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_346568615;
                } //End block
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1461675477 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1933603633 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1933603633;
        // ---------- Original Method ----------
        //if (mInput != null && !mSingleLine) {
            //if ((mInputType & EditorInfo.TYPE_MASK_CLASS) == EditorInfo.TYPE_CLASS_TEXT) {
                //int variation = mInputType & EditorInfo.TYPE_MASK_VARIATION;
                //if (variation == EditorInfo.TYPE_TEXT_FLAG_IME_MULTI_LINE
                        //|| variation == EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE) {
                    //return false;
                //}
            //}
        //}
        //return true;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.581 -0400", hash_original_method = "06C558A5D7DCBFD0B9ED82B9C331F1F3", hash_generated_method = "7A8D8F346084008E43FEE71DAE4778BF")
    private int doKeyDown(int keyCode, KeyEvent event, KeyEvent otherEvent) {
        addTaint(otherEvent.getTaint());
        addTaint(event.getTaint());
        addTaint(keyCode);
        if(!isEnabled())        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_757185351 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_243338166 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_243338166;
        } //End block
switch(keyCode){
        case KeyEvent.KEYCODE_ENTER:
        if(event.hasNoModifiers())        
        {
            if(mInputContentType != null)            
            {
                if(mInputContentType.onEditorActionListener != null &&
                                mInputContentType.onEditorActionListener.onEditorAction(
                                this, EditorInfo.IME_NULL, event))                
                {
                    mInputContentType.enterDown = true;
                    int var6BB61E3B7BCE0931DA574D19D1D82C88_116994607 = (-1);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1778245746 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1778245746;
                } //End block
            } //End block
            if((event.getFlags() & KeyEvent.FLAG_EDITOR_ACTION) != 0
                            || shouldAdvanceFocusOnEnter())            
            {
                if(hasOnClickListeners())                
                {
                    int varCFCD208495D565EF66E7DFF9F98764DA_1460936822 = (0);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1512121746 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1512121746;
                } //End block
                int var6BB61E3B7BCE0931DA574D19D1D82C88_1180017770 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1432467280 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1432467280;
            } //End block
        } //End block
        break;
        case KeyEvent.KEYCODE_DPAD_CENTER:
        if(event.hasNoModifiers())        
        {
            if(shouldAdvanceFocusOnEnter())            
            {
                int varCFCD208495D565EF66E7DFF9F98764DA_417721055 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_20565871 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_20565871;
            } //End block
        } //End block
        break;
        case KeyEvent.KEYCODE_TAB:
        if(event.hasNoModifiers() || event.hasModifiers(KeyEvent.META_SHIFT_ON))        
        {
            if(shouldAdvanceFocusOnTab())            
            {
                int varCFCD208495D565EF66E7DFF9F98764DA_1373097651 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_822285283 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_822285283;
            } //End block
        } //End block
        break;
        case KeyEvent.KEYCODE_BACK:
        if(mSelectionActionMode != null)        
        {
            stopSelectionActionMode();
            int var6BB61E3B7BCE0931DA574D19D1D82C88_620974428 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1910181552 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1910181552;
        } //End block
        break;
}        if(mInput != null)        
        {
            resetErrorChangedFlag();
            boolean doDown = true;
            if(otherEvent != null)            
            {
                try 
                {
                    beginBatchEdit();
                    final boolean handled = mInput.onKeyOther(this, (Editable) mText, otherEvent);
                    hideErrorIfUnchanged();
                    doDown = false;
                    if(handled)                    
                    {
                        int var6BB61E3B7BCE0931DA574D19D1D82C88_1661837003 = (-1);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_749427864 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_749427864;
                    } //End block
                } //End block
                catch (AbstractMethodError e)
                {
                } //End block
                finally 
                {
                    endBatchEdit();
                } //End block
            } //End block
            if(doDown)            
            {
                beginBatchEdit();
                final boolean handled = mInput.onKeyDown(this, (Editable) mText, keyCode, event);
                endBatchEdit();
                hideErrorIfUnchanged();
                if(handled)                
                {
                int varC4CA4238A0B923820DCC509A6F75849B_236584462 = (1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_603951768 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_603951768;
                }
            } //End block
        } //End block
        if(mMovement != null && mLayout != null)        
        {
            boolean doDown = true;
            if(otherEvent != null)            
            {
                try 
                {
                    boolean handled = mMovement.onKeyOther(this, (Spannable) mText,
                            otherEvent);
                    doDown = false;
                    if(handled)                    
                    {
                        int var6BB61E3B7BCE0931DA574D19D1D82C88_1022570557 = (-1);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1869781928 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1869781928;
                    } //End block
                } //End block
                catch (AbstractMethodError e)
                {
                } //End block
            } //End block
            if(doDown)            
            {
                if(mMovement.onKeyDown(this, (Spannable)mText, keyCode, event))                
                {
                int varC81E728D9D4C2F636F067F89CC14862C_685223719 = (2);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_78595084 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_78595084;
                }
            } //End block
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_904593155 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1563508009 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1563508009;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.583 -0400", hash_original_method = "7246AB9167FB26EEC2DE7F4C0B385BF5", hash_generated_method = "942D510B431E2EA8FDD86A5C3DFCBA19")
    public void resetErrorChangedFlag() {
        mErrorWasChanged = false;
        // ---------- Original Method ----------
        //mErrorWasChanged = false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.583 -0400", hash_original_method = "0D0DD73869C4F453DDB81949A9BAE239", hash_generated_method = "F6AC8E629040302A0666261D35629F4F")
    public void hideErrorIfUnchanged() {
        if(mError != null && !mErrorWasChanged)        
        {
            setError(null, null);
        } //End block
        // ---------- Original Method ----------
        //if (mError != null && !mErrorWasChanged) {
            //setError(null, null);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.583 -0400", hash_original_method = "5424E0BE647EA73439DA25EAE2FC3B50", hash_generated_method = "721F126EDC7FB71D57C4C6A7CAA09F2D")
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        if(!isEnabled())        
        {
            boolean varAD33E8F21A74B923C1A24761EAF2F4A9_1089606580 = (super.onKeyUp(keyCode, event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1853225139 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1853225139;
        } //End block
switch(keyCode){
        case KeyEvent.KEYCODE_DPAD_CENTER:
        if(event.hasNoModifiers())        
        {
            if(!hasOnClickListeners())            
            {
                if(mMovement != null && mText instanceof Editable
                                && mLayout != null && onCheckIsTextEditor())                
                {
                    InputMethodManager imm = InputMethodManager.peekInstance();
                    viewClicked(imm);
                    if(imm != null && mSoftInputShownOnFocus)                    
                    {
                        imm.showSoftInput(this, 0);
                    } //End block
                } //End block
            } //End block
        } //End block
        boolean varAD33E8F21A74B923C1A24761EAF2F4A9_1288665189 = (super.onKeyUp(keyCode, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1745761257 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1745761257;
        case KeyEvent.KEYCODE_ENTER:
        if(event.hasNoModifiers())        
        {
            if(mInputContentType != null
                            && mInputContentType.onEditorActionListener != null
                            && mInputContentType.enterDown)            
            {
                mInputContentType.enterDown = false;
                if(mInputContentType.onEditorActionListener.onEditorAction(
                                this, EditorInfo.IME_NULL, event))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1603935993 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2023980205 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2023980205;
                } //End block
            } //End block
            if((event.getFlags() & KeyEvent.FLAG_EDITOR_ACTION) != 0
                            || shouldAdvanceFocusOnEnter())            
            {
                if(!hasOnClickListeners())                
                {
                    View v = focusSearch(FOCUS_DOWN);
                    if(v != null)                    
                    {
                        if(!v.requestFocus(FOCUS_DOWN))                        
                        {
                            IllegalStateException varE2C34DAEAA4A71D29F97874D1AE91DB0_1923368870 = new IllegalStateException(
                                            "focus search returned a view " +
                                            "that wasn't able to take focus!");
                            varE2C34DAEAA4A71D29F97874D1AE91DB0_1923368870.addTaint(taint);
                            throw varE2C34DAEAA4A71D29F97874D1AE91DB0_1923368870;
                        } //End block
                        super.onKeyUp(keyCode, event);
                        boolean varB326B5062B2F0E69046810717534CB09_1346982927 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_544806270 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_544806270;
                    } //End block
                    else
                    if((event.getFlags()
                                    & KeyEvent.FLAG_EDITOR_ACTION) != 0)                    
                    {
                        InputMethodManager imm = InputMethodManager.peekInstance();
                        if(imm != null && imm.isActive(this))                        
                        {
                            imm.hideSoftInputFromWindow(getWindowToken(), 0);
                        } //End block
                    } //End block
                } //End block
            } //End block
            boolean varAD33E8F21A74B923C1A24761EAF2F4A9_1175757375 = (super.onKeyUp(keyCode, event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_717915899 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_717915899;
        } //End block
        break;
}        if(mInput != null)        
        if(mInput.onKeyUp(this, (Editable) mText, keyCode, event))        
        {
        boolean varB326B5062B2F0E69046810717534CB09_145880588 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_254216938 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_254216938;
        }
        if(mMovement != null && mLayout != null)        
        if(mMovement.onKeyUp(this, (Spannable) mText, keyCode, event))        
        {
        boolean varB326B5062B2F0E69046810717534CB09_11476722 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_403589023 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_403589023;
        }
        boolean varAD33E8F21A74B923C1A24761EAF2F4A9_386579897 = (super.onKeyUp(keyCode, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_56829668 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_56829668;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.584 -0400", hash_original_method = "71F7C8422E0B6AB59261F7E112139F7A", hash_generated_method = "92E11EBB88346B268540D70DC97A7451")
    @Override
    public boolean onCheckIsTextEditor() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        boolean varA1EBFA69CED3A52E10207A8FED979FE3_598974067 = (mInputType != EditorInfo.TYPE_NULL);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_86857101 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_86857101;
        // ---------- Original Method ----------
        //return mInputType != EditorInfo.TYPE_NULL;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.586 -0400", hash_original_method = "B65AC544FAB392A4E417298C2021FD9E", hash_generated_method = "1C9F553C93D4B6D06B0214BA683FAB38")
    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(outAttrs.getTaint());
        if(onCheckIsTextEditor() && isEnabled())        
        {
            if(mInputMethodState == null)            
            {
                mInputMethodState = new InputMethodState();
            } //End block
            outAttrs.inputType = mInputType;
            if(mInputContentType != null)            
            {
                outAttrs.imeOptions = mInputContentType.imeOptions;
                outAttrs.privateImeOptions = mInputContentType.privateImeOptions;
                outAttrs.actionLabel = mInputContentType.imeActionLabel;
                outAttrs.actionId = mInputContentType.imeActionId;
                outAttrs.extras = mInputContentType.extras;
            } //End block
            else
            {
                outAttrs.imeOptions = EditorInfo.IME_NULL;
            } //End block
            if(focusSearch(FOCUS_DOWN) != null)            
            {
                outAttrs.imeOptions |= EditorInfo.IME_FLAG_NAVIGATE_NEXT;
            } //End block
            if(focusSearch(FOCUS_UP) != null)            
            {
                outAttrs.imeOptions |= EditorInfo.IME_FLAG_NAVIGATE_PREVIOUS;
            } //End block
            if((outAttrs.imeOptions&EditorInfo.IME_MASK_ACTION)
                    == EditorInfo.IME_ACTION_UNSPECIFIED)            
            {
                if((outAttrs.imeOptions&EditorInfo.IME_FLAG_NAVIGATE_NEXT) != 0)                
                {
                    outAttrs.imeOptions |= EditorInfo.IME_ACTION_NEXT;
                } //End block
                else
                {
                    outAttrs.imeOptions |= EditorInfo.IME_ACTION_DONE;
                } //End block
                if(!shouldAdvanceFocusOnEnter())                
                {
                    outAttrs.imeOptions |= EditorInfo.IME_FLAG_NO_ENTER_ACTION;
                } //End block
            } //End block
            if(isMultilineInputType(outAttrs.inputType))            
            {
                outAttrs.imeOptions |= EditorInfo.IME_FLAG_NO_ENTER_ACTION;
            } //End block
            outAttrs.hintText = mHint;
            if(mText instanceof Editable)            
            {
                InputConnection ic = new EditableInputConnection(this);
                outAttrs.initialSelStart = getSelectionStart();
                outAttrs.initialSelEnd = getSelectionEnd();
                outAttrs.initialCapsMode = ic.getCursorCapsMode(mInputType);
InputConnection varFD8C2BFAAD563C33D901EC24EE14B2AE_1330506731 =                 ic;
                varFD8C2BFAAD563C33D901EC24EE14B2AE_1330506731.addTaint(taint);
                return varFD8C2BFAAD563C33D901EC24EE14B2AE_1330506731;
            } //End block
        } //End block
InputConnection var540C13E9E156B687226421B24F2DF178_274407680 =         null;
        var540C13E9E156B687226421B24F2DF178_274407680.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_274407680;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.586 -0400", hash_original_method = "99984EBDDEABE6A84A830C32C2411508", hash_generated_method = "E15513F1A74A2FF8D16DE18A154D784E")
    public boolean extractText(ExtractedTextRequest request,
            ExtractedText outText) {
        addTaint(outText.getTaint());
        addTaint(request.getTaint());
        boolean varB5F4429AFAD82079F78C5F9870FC0C1A_324124662 = (extractTextInternal(request, EXTRACT_UNKNOWN, EXTRACT_UNKNOWN,
                EXTRACT_UNKNOWN, outText));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_761345605 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_761345605;
        // ---------- Original Method ----------
        //return extractTextInternal(request, EXTRACT_UNKNOWN, EXTRACT_UNKNOWN,
                //EXTRACT_UNKNOWN, outText);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.588 -0400", hash_original_method = "D5583180449515B28719DEEF8D226179", hash_generated_method = "4E2E49183E1F8B0040EC8724B97A0196")
     boolean extractTextInternal(ExtractedTextRequest request,
            int partialStartOffset, int partialEndOffset, int delta,
            ExtractedText outText) {
        addTaint(outText.getTaint());
        addTaint(delta);
        addTaint(partialEndOffset);
        addTaint(partialStartOffset);
        addTaint(request.getTaint());
        final CharSequence content = mText;
        if(content != null)        
        {
            if(partialStartOffset != EXTRACT_NOTHING)            
            {
                final int N = content.length();
                if(partialStartOffset < 0)                
                {
                    outText.partialStartOffset = outText.partialEndOffset = -1;
                    partialStartOffset = 0;
                    partialEndOffset = N;
                } //End block
                else
                {
                    partialEndOffset += delta;
                    if(content instanceof Spanned)                    
                    {
                        Spanned spanned = (Spanned)content;
                        Object[] spans = spanned.getSpans(partialStartOffset,
                                partialEndOffset, ParcelableSpan.class);
                        int i = spans.length;
                        while
(i > 0)                        
                        {
                            i--;
                            int j = spanned.getSpanStart(spans[i]);
                            if(j < partialStartOffset)                            
                            partialStartOffset = j;
                            j = spanned.getSpanEnd(spans[i]);
                            if(j > partialEndOffset)                            
                            partialEndOffset = j;
                        } //End block
                    } //End block
                    outText.partialStartOffset = partialStartOffset;
                    outText.partialEndOffset = partialEndOffset - delta;
                    if(partialStartOffset > N)                    
                    {
                        partialStartOffset = N;
                    } //End block
                    else
                    if(partialStartOffset < 0)                    
                    {
                        partialStartOffset = 0;
                    } //End block
                    if(partialEndOffset > N)                    
                    {
                        partialEndOffset = N;
                    } //End block
                    else
                    if(partialEndOffset < 0)                    
                    {
                        partialEndOffset = 0;
                    } //End block
                } //End block
                if((request.flags&InputConnection.GET_TEXT_WITH_STYLES) != 0)                
                {
                    outText.text = content.subSequence(partialStartOffset,
                            partialEndOffset);
                } //End block
                else
                {
                    outText.text = TextUtils.substring(content, partialStartOffset,
                            partialEndOffset);
                } //End block
            } //End block
            else
            {
                outText.partialStartOffset = 0;
                outText.partialEndOffset = 0;
                outText.text = "";
            } //End block
            outText.flags = 0;
            if(MetaKeyKeyListener.getMetaState(mText, MetaKeyKeyListener.META_SELECTING) != 0)            
            {
                outText.flags |= ExtractedText.FLAG_SELECTING;
            } //End block
            if(mSingleLine)            
            {
                outText.flags |= ExtractedText.FLAG_SINGLE_LINE;
            } //End block
            outText.startOffset = 0;
            outText.selectionStart = getSelectionStart();
            outText.selectionEnd = getSelectionEnd();
            boolean varB326B5062B2F0E69046810717534CB09_1382008992 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2115154175 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2115154175;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_474973793 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1486679942 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1486679942;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.590 -0400", hash_original_method = "E0B2F563BD380D089394FF3F6A004FAB", hash_generated_method = "5A4413EE110FF89FF61FFFCC0B6A32E0")
     boolean reportExtractedText() {
        final InputMethodState ims = mInputMethodState;
        if(ims != null)        
        {
            final boolean contentChanged = ims.mContentChanged;
            if(contentChanged || ims.mSelectionModeChanged)            
            {
                ims.mContentChanged = false;
                ims.mSelectionModeChanged = false;
                final ExtractedTextRequest req = mInputMethodState.mExtracting;
                if(req != null)                
                {
                    InputMethodManager imm = InputMethodManager.peekInstance();
                    if(imm != null)                    
                    {
                        if(DEBUG_EXTRACT){ }                        if(ims.mChangedStart < 0 && !contentChanged)                        
                        {
                            ims.mChangedStart = EXTRACT_NOTHING;
                        } //End block
                        if(extractTextInternal(req, ims.mChangedStart, ims.mChangedEnd,
                                ims.mChangedDelta, ims.mTmpExtracted))                        
                        {
                            if(DEBUG_EXTRACT){ }                            imm.updateExtractedText(this, req.token,
                                    mInputMethodState.mTmpExtracted);
                            ims.mChangedStart = EXTRACT_UNKNOWN;
                            ims.mChangedEnd = EXTRACT_UNKNOWN;
                            ims.mChangedDelta = 0;
                            ims.mContentChanged = false;
                            boolean varB326B5062B2F0E69046810717534CB09_116722712 = (true);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1936788795 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1936788795;
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_159114106 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1211780067 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1211780067;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    static void removeParcelableSpans(Spannable spannable, int start, int end) {
        Object[] spans = spannable.getSpans(start, end, ParcelableSpan.class);
        int i = spans.length;
        while (i > 0) {
            i--;
            spannable.removeSpan(spans[i]);
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.592 -0400", hash_original_method = "BCA6F941081EC35E5D75ECC5825A5773", hash_generated_method = "F09871F5076353A270646CD754A7FAB4")
    public void setExtractedText(ExtractedText text) {
        addTaint(text.getTaint());
        Editable content = getEditableText();
        if(text.text != null)        
        {
            if(content == null)            
            {
                setText(text.text, TextView.BufferType.EDITABLE);
            } //End block
            else
            if(text.partialStartOffset < 0)            
            {
                removeParcelableSpans(content, 0, content.length());
                content.replace(0, content.length(), text.text);
            } //End block
            else
            {
                final int N = content.length();
                int start = text.partialStartOffset;
                if(start > N)                
                start = N;
                int end = text.partialEndOffset;
                if(end > N)                
                end = N;
                removeParcelableSpans(content, start, end);
                content.replace(start, end, text.text);
            } //End block
        } //End block
        Spannable sp = (Spannable)getText();
        final int N = sp.length();
        int start = text.selectionStart;
        if(start < 0)        
        start = 0;
        else
        if(start > N)        
        start = N;
        int end = text.selectionEnd;
        if(end < 0)        
        end = 0;
        else
        if(end > N)        
        end = N;
        Selection.setSelection(sp, start, end);
        if((text.flags&ExtractedText.FLAG_SELECTING) != 0)        
        {
            MetaKeyKeyListener.startSelecting(this, sp);
        } //End block
        else
        {
            MetaKeyKeyListener.stopSelecting(this, sp);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.592 -0400", hash_original_method = "7277A5A8CCC47DEA1B4CD7EF17ABC767", hash_generated_method = "6E7CCFFF01EC0B4EE51D6AC9B94AB005")
    public void setExtracting(ExtractedTextRequest req) {
        if(mInputMethodState != null)        
        {
            mInputMethodState.mExtracting = req;
        } //End block
        hideControllers();
        // ---------- Original Method ----------
        //if (mInputMethodState != null) {
            //mInputMethodState.mExtracting = req;
        //}
        //hideControllers();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.593 -0400", hash_original_method = "00B2156ECAED706F16E8F8EE554C74A0", hash_generated_method = "3BEC66028E7D4A026DFA204DCCC868C4")
    public void onCommitCompletion(CompletionInfo text) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(text.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.594 -0400", hash_original_method = "F0F3377304175B47C81480C4E8ACCA98", hash_generated_method = "4C2A45CE63D8327D1999FDE652D19E33")
    public void onCommitCorrection(CorrectionInfo info) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(info.getTaint());
        if(mCorrectionHighlighter == null)        
        {
            mCorrectionHighlighter = new CorrectionHighlighter();
        } //End block
        else
        {
            mCorrectionHighlighter.invalidate(false);
        } //End block
        mCorrectionHighlighter.highlight(info);
        // ---------- Original Method ----------
        //if (mCorrectionHighlighter == null) {
            //mCorrectionHighlighter = new CorrectionHighlighter();
        //} else {
            //mCorrectionHighlighter.invalidate(false);
        //}
        //mCorrectionHighlighter.highlight(info);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.597 -0400", hash_original_method = "7E84F411EBAFCA8676D2B5471CC899F7", hash_generated_method = "71F33BF1C686868D66E991D803AE751E")
    public void beginBatchEdit() {
        mInBatchEditControllers = true;
        final InputMethodState ims = mInputMethodState;
        if(ims != null)        
        {
            int nesting = ++ims.mBatchEditNesting;
            if(nesting == 1)            
            {
                ims.mCursorChanged = false;
                ims.mChangedDelta = 0;
                if(ims.mContentChanged)                
                {
                    ims.mChangedStart = 0;
                    ims.mChangedEnd = mText.length();
                } //End block
                else
                {
                    ims.mChangedStart = EXTRACT_UNKNOWN;
                    ims.mChangedEnd = EXTRACT_UNKNOWN;
                    ims.mContentChanged = false;
                } //End block
                onBeginBatchEdit();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //mInBatchEditControllers = true;
        //final InputMethodState ims = mInputMethodState;
        //if (ims != null) {
            //int nesting = ++ims.mBatchEditNesting;
            //if (nesting == 1) {
                //ims.mCursorChanged = false;
                //ims.mChangedDelta = 0;
                //if (ims.mContentChanged) {
                    //ims.mChangedStart = 0;
                    //ims.mChangedEnd = mText.length();
                //} else {
                    //ims.mChangedStart = EXTRACT_UNKNOWN;
                    //ims.mChangedEnd = EXTRACT_UNKNOWN;
                    //ims.mContentChanged = false;
                //}
                //onBeginBatchEdit();
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.598 -0400", hash_original_method = "53E9CEBDC3778C58F6F63CD77BA92C78", hash_generated_method = "AC7D78480D5B046F282C1415E3F61932")
    public void endBatchEdit() {
        mInBatchEditControllers = false;
        final InputMethodState ims = mInputMethodState;
        if(ims != null)        
        {
            int nesting = --ims.mBatchEditNesting;
            if(nesting == 0)            
            {
                finishBatchEdit(ims);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //mInBatchEditControllers = false;
        //final InputMethodState ims = mInputMethodState;
        //if (ims != null) {
            //int nesting = --ims.mBatchEditNesting;
            //if (nesting == 0) {
                //finishBatchEdit(ims);
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.598 -0400", hash_original_method = "49FC9F53534FDBC4416EED2F953235D5", hash_generated_method = "241B061C01791B120D1668C4B4B2695B")
     void ensureEndedBatchEdit() {
        final InputMethodState ims = mInputMethodState;
        if(ims != null && ims.mBatchEditNesting != 0)        
        {
            ims.mBatchEditNesting = 0;
            finishBatchEdit(ims);
        } //End block
        // ---------- Original Method ----------
        //final InputMethodState ims = mInputMethodState;
        //if (ims != null && ims.mBatchEditNesting != 0) {
            //ims.mBatchEditNesting = 0;
            //finishBatchEdit(ims);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.599 -0400", hash_original_method = "5C56AEFFFAF99A5A2B83332AB2B67F77", hash_generated_method = "0F7022A73BC566B688D5FFB8EBEC51DA")
     void finishBatchEdit(final InputMethodState ims) {
        addTaint(ims.getTaint());
        onEndBatchEdit();
        if(ims.mContentChanged || ims.mSelectionModeChanged)        
        {
            updateAfterEdit();
            reportExtractedText();
        } //End block
        else
        if(ims.mCursorChanged)        
        {
            invalidateCursor();
        } //End block
        // ---------- Original Method ----------
        //onEndBatchEdit();
        //if (ims.mContentChanged || ims.mSelectionModeChanged) {
            //updateAfterEdit();
            //reportExtractedText();
        //} else if (ims.mCursorChanged) {
            //invalidateCursor();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.599 -0400", hash_original_method = "208D05A3FD324C57DA7FED31CDB936F2", hash_generated_method = "09313A3FD6C186080C667A06B61E03B2")
     void updateAfterEdit() {
        invalidate();
        int curs = getSelectionStart();
        if(curs >= 0 || (mGravity & Gravity.VERTICAL_GRAVITY_MASK) == Gravity.BOTTOM)        
        {
            registerForPreDraw();
        } //End block
        if(curs >= 0)        
        {
            mHighlightPathBogus = true;
            makeBlink();
            bringPointIntoView(curs);
        } //End block
        checkForResize();
        // ---------- Original Method ----------
        //invalidate();
        //int curs = getSelectionStart();
        //if (curs >= 0 || (mGravity & Gravity.VERTICAL_GRAVITY_MASK) == Gravity.BOTTOM) {
            //registerForPreDraw();
        //}
        //if (curs >= 0) {
            //mHighlightPathBogus = true;
            //makeBlink();
            //bringPointIntoView(curs);
        //}
        //checkForResize();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.599 -0400", hash_original_method = "77FDC1BC2641DD2E3C25361410AF5DB0", hash_generated_method = "BC5277DD7D56968D2F4723F142BD5C12")
    public void onBeginBatchEdit() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.599 -0400", hash_original_method = "52249F36F9A17EF1D72281B7699502C1", hash_generated_method = "47AA9BDFFBC119BCE27C341493B00781")
    public void onEndBatchEdit() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.599 -0400", hash_original_method = "4EBA5E538796A46420814B4C84FDA4F7", hash_generated_method = "F595E98AA53AB21129EC91774A74CA45")
    public boolean onPrivateIMECommand(String action, Bundle data) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(data.getTaint());
        addTaint(action.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_172822685 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1764518172 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1764518172;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.600 -0400", hash_original_method = "4BBE7444811911981578CD1FC44D7898", hash_generated_method = "E2562210798AC11D458DAA9A60BAA0C4")
    private void nullLayouts() {
        if(mLayout instanceof BoringLayout && mSavedLayout == null)        
        {
            mSavedLayout = (BoringLayout) mLayout;
        } //End block
        if(mHintLayout instanceof BoringLayout && mSavedHintLayout == null)        
        {
            mSavedHintLayout = (BoringLayout) mHintLayout;
        } //End block
        mSavedMarqueeModeLayout = mLayout = mHintLayout = null;
        prepareCursorControllers();
        // ---------- Original Method ----------
        //if (mLayout instanceof BoringLayout && mSavedLayout == null) {
            //mSavedLayout = (BoringLayout) mLayout;
        //}
        //if (mHintLayout instanceof BoringLayout && mSavedHintLayout == null) {
            //mSavedHintLayout = (BoringLayout) mHintLayout;
        //}
        //mSavedMarqueeModeLayout = mLayout = mHintLayout = null;
        //prepareCursorControllers();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.601 -0400", hash_original_method = "DE76D8533357DD76552FFACD362B9B5D", hash_generated_method = "214AB19F2CD8CF1BF9BCA1ABF6EFF48C")
    private void assumeLayout() {
        int width = mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight();
        if(width < 1)        
        {
            width = 0;
        } //End block
        int physicalWidth = width;
        if(mHorizontallyScrolling)        
        {
            width = VERY_WIDE;
        } //End block
        makeNewLayout(width, physicalWidth, UNKNOWN_BORING, UNKNOWN_BORING,
                      physicalWidth, false);
        // ---------- Original Method ----------
        //int width = mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight();
        //if (width < 1) {
            //width = 0;
        //}
        //int physicalWidth = width;
        //if (mHorizontallyScrolling) {
            //width = VERY_WIDE;
        //}
        //makeNewLayout(width, physicalWidth, UNKNOWN_BORING, UNKNOWN_BORING,
                      //physicalWidth, false);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.601 -0400", hash_original_method = "FF379A6CAE0485B60E59F45E1B8A7246", hash_generated_method = "4FC6F3D9BB11461AA77A03EB4A7948E5")
    @Override
    protected void resetResolvedLayoutDirection() {
        super.resetResolvedLayoutDirection();
        if(mLayoutAlignment != null &&
                (mTextAlign == TextAlign.VIEW_START ||
                mTextAlign == TextAlign.VIEW_END))        
        {
            mLayoutAlignment = null;
        } //End block
        // ---------- Original Method ----------
        //super.resetResolvedLayoutDirection();
        //if (mLayoutAlignment != null &&
                //(mTextAlign == TextAlign.VIEW_START ||
                //mTextAlign == TextAlign.VIEW_END)) {
            //mLayoutAlignment = null;
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.603 -0400", hash_original_method = "C784F6D37EB77044D77D743FABD50125", hash_generated_method = "D86BAD4E1D9AD8EDE7051B0C90BEB853")
    private Layout.Alignment getLayoutAlignment() {
        if(mLayoutAlignment == null)        
        {
            Layout.Alignment alignment;
            TextAlign textAlign = mTextAlign;
switch(textAlign){
            case INHERIT:
            case GRAVITY:
switch(mGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK){
            case Gravity.START:
            alignment = Layout.Alignment.ALIGN_NORMAL;
            break;
            case Gravity.END:
            alignment = Layout.Alignment.ALIGN_OPPOSITE;
            break;
            case Gravity.LEFT:
            alignment = Layout.Alignment.ALIGN_LEFT;
            break;
            case Gravity.RIGHT:
            alignment = Layout.Alignment.ALIGN_RIGHT;
            break;
            case Gravity.CENTER_HORIZONTAL:
            alignment = Layout.Alignment.ALIGN_CENTER;
            break;
            default:
            alignment = Layout.Alignment.ALIGN_NORMAL;
            break;
}            break;
            case TEXT_START:
            alignment = Layout.Alignment.ALIGN_NORMAL;
            break;
            case TEXT_END:
            alignment = Layout.Alignment.ALIGN_OPPOSITE;
            break;
            case CENTER:
            alignment = Layout.Alignment.ALIGN_CENTER;
            break;
            case VIEW_START:
            alignment = (getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL) ?
                            Layout.Alignment.ALIGN_RIGHT : Layout.Alignment.ALIGN_LEFT;
            break;
            case VIEW_END:
            alignment = (getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL) ?
                            Layout.Alignment.ALIGN_LEFT : Layout.Alignment.ALIGN_RIGHT;
            break;
            default:
            alignment = Layout.Alignment.ALIGN_NORMAL;
            break;
}            mLayoutAlignment = alignment;
        } //End block
Layout.Alignment var2528632BD051D59991952A31F0D99C25_1039177843 =         mLayoutAlignment;
        var2528632BD051D59991952A31F0D99C25_1039177843.addTaint(taint);
        return var2528632BD051D59991952A31F0D99C25_1039177843;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.605 -0400", hash_original_method = "A69555D5DBD727E4B4531FE7AB9727A4", hash_generated_method = "B6FDDFFDB79C716150CFD508FCAC3EC2")
    protected void makeNewLayout(int wantWidth, int hintWidth,
                                 BoringLayout.Metrics boring,
                                 BoringLayout.Metrics hintBoring,
                                 int ellipsisWidth, boolean bringIntoView) {
        addTaint(bringIntoView);
        stopMarquee();
        mOldMaximum = mMaximum;
        mOldMaxMode = mMaxMode;
        mHighlightPathBogus = true;
        if(wantWidth < 0)        
        {
            wantWidth = 0;
        } //End block
        if(hintWidth < 0)        
        {
            hintWidth = 0;
        } //End block
        Layout.Alignment alignment = getLayoutAlignment();
        boolean shouldEllipsize = mEllipsize != null && mInput == null;
        final boolean switchEllipsize = mEllipsize == TruncateAt.MARQUEE &&
                mMarqueeFadeMode != MARQUEE_FADE_NORMAL;
        TruncateAt effectiveEllipsize = mEllipsize;
        if(mEllipsize == TruncateAt.MARQUEE &&
                mMarqueeFadeMode == MARQUEE_FADE_SWITCH_SHOW_ELLIPSIS)        
        {
            effectiveEllipsize = TruncateAt.END_SMALL;
        } //End block
        if(mTextDir == null)        
        {
            resolveTextDirection();
        } //End block
        mLayout = makeSingleLayout(wantWidth, boring, ellipsisWidth, alignment, shouldEllipsize,
                effectiveEllipsize, effectiveEllipsize == mEllipsize);
        if(switchEllipsize)        
        {
            TruncateAt oppositeEllipsize = effectiveEllipsize == TruncateAt.MARQUEE ?
                    TruncateAt.END : TruncateAt.MARQUEE;
            mSavedMarqueeModeLayout = makeSingleLayout(wantWidth, boring, ellipsisWidth, alignment,
                    shouldEllipsize, oppositeEllipsize, effectiveEllipsize != mEllipsize);
        } //End block
        shouldEllipsize = mEllipsize != null;
        mHintLayout = null;
        if(mHint != null)        
        {
            if(shouldEllipsize)            
            hintWidth = wantWidth;
            if(hintBoring == UNKNOWN_BORING)            
            {
                hintBoring = BoringLayout.isBoring(mHint, mTextPaint, mTextDir,
                                                   mHintBoring);
                if(hintBoring != null)                
                {
                    mHintBoring = hintBoring;
                } //End block
            } //End block
            if(hintBoring != null)            
            {
                if(hintBoring.width <= hintWidth &&
                    (!shouldEllipsize || hintBoring.width <= ellipsisWidth))                
                {
                    if(mSavedHintLayout != null)                    
                    {
                        mHintLayout = mSavedHintLayout.
                                replaceOrMake(mHint, mTextPaint,
                                hintWidth, alignment, mSpacingMult, mSpacingAdd,
                                hintBoring, mIncludePad);
                    } //End block
                    else
                    {
                        mHintLayout = BoringLayout.make(mHint, mTextPaint,
                                hintWidth, alignment, mSpacingMult, mSpacingAdd,
                                hintBoring, mIncludePad);
                    } //End block
                    mSavedHintLayout = (BoringLayout) mHintLayout;
                } //End block
                else
                if(shouldEllipsize && hintBoring.width <= hintWidth)                
                {
                    if(mSavedHintLayout != null)                    
                    {
                        mHintLayout = mSavedHintLayout.
                                replaceOrMake(mHint, mTextPaint,
                                hintWidth, alignment, mSpacingMult, mSpacingAdd,
                                hintBoring, mIncludePad, mEllipsize,
                                ellipsisWidth);
                    } //End block
                    else
                    {
                        mHintLayout = BoringLayout.make(mHint, mTextPaint,
                                hintWidth, alignment, mSpacingMult, mSpacingAdd,
                                hintBoring, mIncludePad, mEllipsize,
                                ellipsisWidth);
                    } //End block
                } //End block
                else
                if(shouldEllipsize)                
                {
                    mHintLayout = new StaticLayout(mHint,
                                0, mHint.length(),
                                mTextPaint, hintWidth, alignment, mTextDir, mSpacingMult,
                                mSpacingAdd, mIncludePad, mEllipsize,
                                ellipsisWidth, mMaxMode == LINES ? mMaximum : Integer.MAX_VALUE);
                } //End block
                else
                {
                    mHintLayout = new StaticLayout(mHint, mTextPaint,
                            hintWidth, alignment, mTextDir, mSpacingMult, mSpacingAdd,
                            mIncludePad);
                } //End block
            } //End block
            else
            if(shouldEllipsize)            
            {
                mHintLayout = new StaticLayout(mHint,
                            0, mHint.length(),
                            mTextPaint, hintWidth, alignment, mTextDir, mSpacingMult,
                            mSpacingAdd, mIncludePad, mEllipsize,
                            ellipsisWidth, mMaxMode == LINES ? mMaximum : Integer.MAX_VALUE);
            } //End block
            else
            {
                mHintLayout = new StaticLayout(mHint, mTextPaint,
                        hintWidth, alignment, mTextDir, mSpacingMult, mSpacingAdd,
                        mIncludePad);
            } //End block
        } //End block
        if(bringIntoView)        
        {
            registerForPreDraw();
        } //End block
        if(mEllipsize == TextUtils.TruncateAt.MARQUEE)        
        {
            if(!compressText(ellipsisWidth))            
            {
                final int height = mLayoutParams.height;
                if(height != LayoutParams.WRAP_CONTENT && height != LayoutParams.MATCH_PARENT)                
                {
                    startMarquee();
                } //End block
                else
                {
                    mRestartMarquee = true;
                } //End block
            } //End block
        } //End block
        prepareCursorControllers();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.607 -0400", hash_original_method = "919E80CF27514D43AA0D66AD56F3C47B", hash_generated_method = "084D96E84090F099CAA11F5AE50624D7")
    private Layout makeSingleLayout(int wantWidth, BoringLayout.Metrics boring, int ellipsisWidth,
            Layout.Alignment alignment, boolean shouldEllipsize, TruncateAt effectiveEllipsize,
            boolean useSaved) {
        addTaint(useSaved);
        addTaint(effectiveEllipsize.getTaint());
        addTaint(shouldEllipsize);
        addTaint(alignment.getTaint());
        addTaint(ellipsisWidth);
        addTaint(wantWidth);
        Layout result = null;
        if(mText instanceof Spannable)        
        {
            result = new DynamicLayout(mText, mTransformed, mTextPaint, wantWidth,
                    alignment, mTextDir, mSpacingMult,
                    mSpacingAdd, mIncludePad, mInput == null ? effectiveEllipsize : null,
                            ellipsisWidth);
        } //End block
        else
        {
            if(boring == UNKNOWN_BORING)            
            {
                boring = BoringLayout.isBoring(mTransformed, mTextPaint, mTextDir, mBoring);
                if(boring != null)                
                {
                    mBoring = boring;
                } //End block
            } //End block
            if(boring != null)            
            {
                if(boring.width <= wantWidth &&
                        (effectiveEllipsize == null || boring.width <= ellipsisWidth))                
                {
                    if(useSaved && mSavedLayout != null)                    
                    {
                        result = mSavedLayout.replaceOrMake(mTransformed, mTextPaint,
                                wantWidth, alignment, mSpacingMult, mSpacingAdd,
                                boring, mIncludePad);
                    } //End block
                    else
                    {
                        result = BoringLayout.make(mTransformed, mTextPaint,
                                wantWidth, alignment, mSpacingMult, mSpacingAdd,
                                boring, mIncludePad);
                    } //End block
                    if(useSaved)                    
                    {
                        mSavedLayout = (BoringLayout) result;
                    } //End block
                } //End block
                else
                if(shouldEllipsize && boring.width <= wantWidth)                
                {
                    if(useSaved && mSavedLayout != null)                    
                    {
                        result = mSavedLayout.replaceOrMake(mTransformed, mTextPaint,
                                wantWidth, alignment, mSpacingMult, mSpacingAdd,
                                boring, mIncludePad, effectiveEllipsize,
                                ellipsisWidth);
                    } //End block
                    else
                    {
                        result = BoringLayout.make(mTransformed, mTextPaint,
                                wantWidth, alignment, mSpacingMult, mSpacingAdd,
                                boring, mIncludePad, effectiveEllipsize,
                                ellipsisWidth);
                    } //End block
                } //End block
                else
                if(shouldEllipsize)                
                {
                    result = new StaticLayout(mTransformed,
                            0, mTransformed.length(),
                            mTextPaint, wantWidth, alignment, mTextDir, mSpacingMult,
                            mSpacingAdd, mIncludePad, effectiveEllipsize,
                            ellipsisWidth, mMaxMode == LINES ? mMaximum : Integer.MAX_VALUE);
                } //End block
                else
                {
                    result = new StaticLayout(mTransformed, mTextPaint,
                            wantWidth, alignment, mTextDir, mSpacingMult, mSpacingAdd,
                            mIncludePad);
                } //End block
            } //End block
            else
            if(shouldEllipsize)            
            {
                result = new StaticLayout(mTransformed,
                        0, mTransformed.length(),
                        mTextPaint, wantWidth, alignment, mTextDir, mSpacingMult,
                        mSpacingAdd, mIncludePad, effectiveEllipsize,
                        ellipsisWidth, mMaxMode == LINES ? mMaximum : Integer.MAX_VALUE);
            } //End block
            else
            {
                result = new StaticLayout(mTransformed, mTextPaint,
                        wantWidth, alignment, mTextDir, mSpacingMult, mSpacingAdd,
                        mIncludePad);
            } //End block
        } //End block
Layout varDC838461EE2FA0CA4C9BBB70A15456B0_1946346092 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1946346092.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1946346092;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.609 -0400", hash_original_method = "F38DBB61FA92C8376A0BF0DADC8F1411", hash_generated_method = "B13012CAC0E1563228581F5DFB50ADC7")
    private boolean compressText(float width) {
        addTaint(width);
        if(isHardwareAccelerated())        
        {
        boolean var68934A3E9455FA72420237EB05902327_1239452033 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1084813358 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1084813358;
        }
        if(width > 0.0f && mLayout != null && getLineCount() == 1 && !mUserSetTextScaleX &&
                mTextPaint.getTextScaleX() == 1.0f)        
        {
            final float textWidth = mLayout.getLineWidth(0);
            final float overflow = (textWidth + 1.0f - width) / width;
            if(overflow > 0.0f && overflow <= Marquee.MARQUEE_DELTA_MAX)            
            {
                mTextPaint.setTextScaleX(1.0f - overflow - 0.005f);
                post(new Runnable() {        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.608 -0400", hash_original_method = "13996B392673F4526875359F0F526DB3", hash_generated_method = "221C03470D8DDA191DC873FAC4B9A060")
        public void run() {
            requestLayout();
            // ---------- Original Method ----------
            //requestLayout();
        }
});
                boolean varB326B5062B2F0E69046810717534CB09_1119661508 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_730163255 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_730163255;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1633240311 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1947786176 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1947786176;
        // ---------- Original Method ----------
        //if (isHardwareAccelerated()) return false;
        //if (width > 0.0f && mLayout != null && getLineCount() == 1 && !mUserSetTextScaleX &&
                //mTextPaint.getTextScaleX() == 1.0f) {
            //final float textWidth = mLayout.getLineWidth(0);
            //final float overflow = (textWidth + 1.0f - width) / width;
            //if (overflow > 0.0f && overflow <= Marquee.MARQUEE_DELTA_MAX) {
                //mTextPaint.setTextScaleX(1.0f - overflow - 0.005f);
                //post(new Runnable() {
                    //public void run() {
                        //requestLayout();
                    //}
                //});
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    private static int desired(Layout layout) {
        int n = layout.getLineCount();
        CharSequence text = layout.getText();
        float max = 0;
        for (int i = 0; i < n - 1; i++) {
            if (text.charAt(layout.getLineEnd(i) - 1) != '\n')
                return -1;
        }
        for (int i = 0; i < n; i++) {
            max = Math.max(max, layout.getLineWidth(i));
        }
        return (int) FloatMath.ceil(max);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.610 -0400", hash_original_method = "6C6FEB869E07EC14B89A3785CB4B2378", hash_generated_method = "83A52F11F8F92473B6A7DCFC84B13F52")
    public void setIncludeFontPadding(boolean includepad) {
        if(mIncludePad != includepad)        
        {
            mIncludePad = includepad;
            if(mLayout != null)            
            {
                nullLayouts();
                requestLayout();
                invalidate();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mIncludePad != includepad) {
            //mIncludePad = includepad;
            //if (mLayout != null) {
                //nullLayouts();
                //requestLayout();
                //invalidate();
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.615 -0400", hash_original_method = "CC856997CB919A81C5DE847B897CC56B", hash_generated_method = "D163D56BA587C96279FD5441B011E33B")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int width;
        int height;
        BoringLayout.Metrics boring = UNKNOWN_BORING;
        BoringLayout.Metrics hintBoring = UNKNOWN_BORING;
        if(mTextDir == null)        
        {
            resolveTextDirection();
        } //End block
        int des = -1;
        boolean fromexisting = false;
        if(widthMode == MeasureSpec.EXACTLY)        
        {
            width = widthSize;
        } //End block
        else
        {
            if(mLayout != null && mEllipsize == null)            
            {
                des = desired(mLayout);
            } //End block
            if(des < 0)            
            {
                boring = BoringLayout.isBoring(mTransformed, mTextPaint, mTextDir, mBoring);
                if(boring != null)                
                {
                    mBoring = boring;
                } //End block
            } //End block
            else
            {
                fromexisting = true;
            } //End block
            if(boring == null || boring == UNKNOWN_BORING)            
            {
                if(des < 0)                
                {
                    des = (int) FloatMath.ceil(Layout.getDesiredWidth(mTransformed, mTextPaint));
                } //End block
                width = des;
            } //End block
            else
            {
                width = boring.width;
            } //End block
            final Drawables dr = mDrawables;
            if(dr != null)            
            {
                width = Math.max(width, dr.mDrawableWidthTop);
                width = Math.max(width, dr.mDrawableWidthBottom);
            } //End block
            if(mHint != null)            
            {
                int hintDes = -1;
                int hintWidth;
                if(mHintLayout != null && mEllipsize == null)                
                {
                    hintDes = desired(mHintLayout);
                } //End block
                if(hintDes < 0)                
                {
                    hintBoring = BoringLayout.isBoring(mHint, mTextPaint, mHintBoring);
                    if(hintBoring != null)                    
                    {
                        mHintBoring = hintBoring;
                    } //End block
                } //End block
                if(hintBoring == null || hintBoring == UNKNOWN_BORING)                
                {
                    if(hintDes < 0)                    
                    {
                        hintDes = (int) FloatMath.ceil(
                                Layout.getDesiredWidth(mHint, mTextPaint));
                    } //End block
                    hintWidth = hintDes;
                } //End block
                else
                {
                    hintWidth = hintBoring.width;
                } //End block
                if(hintWidth > width)                
                {
                    width = hintWidth;
                } //End block
            } //End block
            width += getCompoundPaddingLeft() + getCompoundPaddingRight();
            if(mMaxWidthMode == EMS)            
            {
                width = Math.min(width, mMaxWidth * getLineHeight());
            } //End block
            else
            {
                width = Math.min(width, mMaxWidth);
            } //End block
            if(mMinWidthMode == EMS)            
            {
                width = Math.max(width, mMinWidth * getLineHeight());
            } //End block
            else
            {
                width = Math.max(width, mMinWidth);
            } //End block
            width = Math.max(width, getSuggestedMinimumWidth());
            if(widthMode == MeasureSpec.AT_MOST)            
            {
                width = Math.min(widthSize, width);
            } //End block
        } //End block
        int want = width - getCompoundPaddingLeft() - getCompoundPaddingRight();
        int unpaddedWidth = want;
        if(mHorizontallyScrolling)        
        want = VERY_WIDE;
        int hintWant = want;
        int hintWidth = (mHintLayout == null) ? hintWant : mHintLayout.getWidth();
        if(mLayout == null)        
        {
            makeNewLayout(want, hintWant, boring, hintBoring,
                          width - getCompoundPaddingLeft() - getCompoundPaddingRight(), false);
        } //End block
        else
        {
            final boolean layoutChanged = (mLayout.getWidth() != want) ||
                    (hintWidth != hintWant) ||
                    (mLayout.getEllipsizedWidth() !=
                            width - getCompoundPaddingLeft() - getCompoundPaddingRight());
            final boolean widthChanged = (mHint == null) &&
                    (mEllipsize == null) &&
                    (want > mLayout.getWidth()) &&
                    (mLayout instanceof BoringLayout || (fromexisting && des >= 0 && des <= want));
            final boolean maximumChanged = (mMaxMode != mOldMaxMode) || (mMaximum != mOldMaximum);
            if(layoutChanged || maximumChanged)            
            {
                if(!maximumChanged && widthChanged)                
                {
                    mLayout.increaseWidthTo(want);
                } //End block
                else
                {
                    makeNewLayout(want, hintWant, boring, hintBoring,
                            width - getCompoundPaddingLeft() - getCompoundPaddingRight(), false);
                } //End block
            } //End block
            else
            {
            } //End block
        } //End block
        if(heightMode == MeasureSpec.EXACTLY)        
        {
            height = heightSize;
            mDesiredHeightAtMeasure = -1;
        } //End block
        else
        {
            int desired = getDesiredHeight();
            height = desired;
            mDesiredHeightAtMeasure = desired;
            if(heightMode == MeasureSpec.AT_MOST)            
            {
                height = Math.min(desired, heightSize);
            } //End block
        } //End block
        int unpaddedHeight = height - getCompoundPaddingTop() - getCompoundPaddingBottom();
        if(mMaxMode == LINES && mLayout.getLineCount() > mMaximum)        
        {
            unpaddedHeight = Math.min(unpaddedHeight, mLayout.getLineTop(mMaximum));
        } //End block
        if(mMovement != null ||
            mLayout.getWidth() > unpaddedWidth ||
            mLayout.getHeight() > unpaddedHeight)        
        {
            registerForPreDraw();
        } //End block
        else
        {
            scrollTo(0, 0);
        } //End block
        setMeasuredDimension(width, height);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.616 -0400", hash_original_method = "94259D4548546EABDDB6F8414E37FA42", hash_generated_method = "27FD0ACCD7484DB7336ABAE3051A2EA3")
    private int getDesiredHeight() {
        int varCD65E435A49F0B595E46926D9C639424_2125324785 = (Math.max(
                getDesiredHeight(mLayout, true),
                getDesiredHeight(mHintLayout, mEllipsize != null)));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_973032713 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_973032713;
        // ---------- Original Method ----------
        //return Math.max(
                //getDesiredHeight(mLayout, true),
                //getDesiredHeight(mHintLayout, mEllipsize != null));
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.618 -0400", hash_original_method = "7AA300272C545049E0340D139CA1349D", hash_generated_method = "26CD760FCC34C23681021ECFE90698EB")
    private int getDesiredHeight(Layout layout, boolean cap) {
        addTaint(cap);
        addTaint(layout.getTaint());
        if(layout == null)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1088276072 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_699809072 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_699809072;
        } //End block
        int linecount = layout.getLineCount();
        int pad = getCompoundPaddingTop() + getCompoundPaddingBottom();
        int desired = layout.getLineTop(linecount);
        final Drawables dr = mDrawables;
        if(dr != null)        
        {
            desired = Math.max(desired, dr.mDrawableHeightLeft);
            desired = Math.max(desired, dr.mDrawableHeightRight);
        } //End block
        desired += pad;
        if(mMaxMode == LINES)        
        {
            if(cap)            
            {
                if(linecount > mMaximum)                
                {
                    desired = layout.getLineTop(mMaximum);
                    if(dr != null)                    
                    {
                        desired = Math.max(desired, dr.mDrawableHeightLeft);
                        desired = Math.max(desired, dr.mDrawableHeightRight);
                    } //End block
                    desired += pad;
                    linecount = mMaximum;
                } //End block
            } //End block
        } //End block
        else
        {
            desired = Math.min(desired, mMaximum);
        } //End block
        if(mMinMode == LINES)        
        {
            if(linecount < mMinimum)            
            {
                desired += getLineHeight() * (mMinimum - linecount);
            } //End block
        } //End block
        else
        {
            desired = Math.max(desired, mMinimum);
        } //End block
        desired = Math.max(desired, getSuggestedMinimumHeight());
        int var044C671387C06B1C42654A7004F08A26_2140997780 = (desired);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1222856677 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1222856677;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.618 -0400", hash_original_method = "112907D8B10F62764352610BA7B79108", hash_generated_method = "CEB1BBB3CDC156713555964EEFAA4527")
    private void checkForResize() {
        boolean sizeChanged = false;
        if(mLayout != null)        
        {
            if(mLayoutParams.width == LayoutParams.WRAP_CONTENT)            
            {
                sizeChanged = true;
                invalidate();
            } //End block
            if(mLayoutParams.height == LayoutParams.WRAP_CONTENT)            
            {
                int desiredHeight = getDesiredHeight();
                if(desiredHeight != this.getHeight())                
                {
                    sizeChanged = true;
                } //End block
            } //End block
            else
            if(mLayoutParams.height == LayoutParams.MATCH_PARENT)            
            {
                if(mDesiredHeightAtMeasure >= 0)                
                {
                    int desiredHeight = getDesiredHeight();
                    if(desiredHeight != mDesiredHeightAtMeasure)                    
                    {
                        sizeChanged = true;
                    } //End block
                } //End block
            } //End block
        } //End block
        if(sizeChanged)        
        {
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.619 -0400", hash_original_method = "5832A71588E0ABA41180B589D326BF70", hash_generated_method = "CD6A5A002A8952F992BDDD10D3ACEF9E")
    private void checkForRelayout() {
        if((mLayoutParams.width != LayoutParams.WRAP_CONTENT ||
                (mMaxWidthMode == mMinWidthMode && mMaxWidth == mMinWidth)) &&
                (mHint == null || mHintLayout != null) &&
                (mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight() > 0))        
        {
            int oldht = mLayout.getHeight();
            int want = mLayout.getWidth();
            int hintWant = mHintLayout == null ? 0 : mHintLayout.getWidth();
            makeNewLayout(want, hintWant, UNKNOWN_BORING, UNKNOWN_BORING,
                          mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight(),
                          false);
            if(mEllipsize != TextUtils.TruncateAt.MARQUEE)            
            {
                if(mLayoutParams.height != LayoutParams.WRAP_CONTENT &&
                    mLayoutParams.height != LayoutParams.MATCH_PARENT)                
                {
                    invalidate();
                    return;
                } //End block
                if(mLayout.getHeight() == oldht &&
                    (mHintLayout == null || mHintLayout.getHeight() == oldht))                
                {
                    invalidate();
                    return;
                } //End block
            } //End block
            requestLayout();
            invalidate();
        } //End block
        else
        {
            nullLayouts();
            requestLayout();
            invalidate();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.621 -0400", hash_original_method = "0DA3D6D28C1432B95D5D1B1B5DDB2BC8", hash_generated_method = "191410D4BCAC9B166E99CC72A24BA81B")
    private boolean bringTextIntoView() {
        int line = 0;
        if((mGravity & Gravity.VERTICAL_GRAVITY_MASK) == Gravity.BOTTOM)        
        {
            line = mLayout.getLineCount() - 1;
        } //End block
        Layout.Alignment a = mLayout.getParagraphAlignment(line);
        int dir = mLayout.getParagraphDirection(line);
        int hspace = mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight();
        int vspace = mBottom - mTop - getExtendedPaddingTop() - getExtendedPaddingBottom();
        int ht = mLayout.getHeight();
        int scrollx;
        int scrolly;
        if(a == Layout.Alignment.ALIGN_NORMAL)        
        {
            a = dir == Layout.DIR_LEFT_TO_RIGHT ? Layout.Alignment.ALIGN_LEFT :
                Layout.Alignment.ALIGN_RIGHT;
        } //End block
        else
        if(a == Layout.Alignment.ALIGN_OPPOSITE)        
        {
            a = dir == Layout.DIR_LEFT_TO_RIGHT ? Layout.Alignment.ALIGN_RIGHT :
                Layout.Alignment.ALIGN_LEFT;
        } //End block
        if(a == Layout.Alignment.ALIGN_CENTER)        
        {
            int left = (int) FloatMath.floor(mLayout.getLineLeft(line));
            int right = (int) FloatMath.ceil(mLayout.getLineRight(line));
            if(right - left < hspace)            
            {
                scrollx = (right + left) / 2 - hspace / 2;
            } //End block
            else
            {
                if(dir < 0)                
                {
                    scrollx = right - hspace;
                } //End block
                else
                {
                    scrollx = left;
                } //End block
            } //End block
        } //End block
        else
        if(a == Layout.Alignment.ALIGN_RIGHT)        
        {
            int right = (int) FloatMath.ceil(mLayout.getLineRight(line));
            scrollx = right - hspace;
        } //End block
        else
        {
            scrollx = (int) FloatMath.floor(mLayout.getLineLeft(line));
        } //End block
        if(ht < vspace)        
        {
            scrolly = 0;
        } //End block
        else
        {
            if((mGravity & Gravity.VERTICAL_GRAVITY_MASK) == Gravity.BOTTOM)            
            {
                scrolly = ht - vspace;
            } //End block
            else
            {
                scrolly = 0;
            } //End block
        } //End block
        if(scrollx != mScrollX || scrolly != mScrollY)        
        {
            scrollTo(scrollx, scrolly);
            boolean varB326B5062B2F0E69046810717534CB09_458904797 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_15535405 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_15535405;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_1414280708 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1229256458 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1229256458;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.624 -0400", hash_original_method = "3C0DD43A95E696C7A1592341A7B2F740", hash_generated_method = "1FA758C2D77E5C73D84E3122CED35900")
    public boolean bringPointIntoView(int offset) {
        addTaint(offset);
        boolean changed = false;
        if(mLayout == null)        
        {
        boolean var8977DFAC2F8E04CB96E66882235F5ABA_423589444 = (changed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_452375864 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_452375864;
        }
        int line = mLayout.getLineForOffset(offset);
        final int x = (int)mLayout.getPrimaryHorizontal(offset);
        final int top = mLayout.getLineTop(line);
        final int bottom = mLayout.getLineTop(line + 1);
        int left = (int) FloatMath.floor(mLayout.getLineLeft(line));
        int right = (int) FloatMath.ceil(mLayout.getLineRight(line));
        int ht = mLayout.getHeight();
        int grav;
switch(mLayout.getParagraphAlignment(line)){
        case ALIGN_LEFT:
        grav = 1;
        break;
        case ALIGN_RIGHT:
        grav = -1;
        break;
        case ALIGN_NORMAL:
        grav = mLayout.getParagraphDirection(line);
        break;
        case ALIGN_OPPOSITE:
        grav = -mLayout.getParagraphDirection(line);
        break;
        case ALIGN_CENTER:
        default:
        grav = 0;
        break;
}        int hspace = mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight();
        int vspace = mBottom - mTop - getExtendedPaddingTop() - getExtendedPaddingBottom();
        int hslack = (bottom - top) / 2;
        int vslack = hslack;
        if(vslack > vspace / 4)        
        vslack = vspace / 4;
        if(hslack > hspace / 4)        
        hslack = hspace / 4;
        int hs = mScrollX;
        int vs = mScrollY;
        if(top - vs < vslack)        
        vs = top - vslack;
        if(bottom - vs > vspace - vslack)        
        vs = bottom - (vspace - vslack);
        if(ht - vs < vspace)        
        vs = ht - vspace;
        if(0 - vs > 0)        
        vs = 0;
        if(grav != 0)        
        {
            if(x - hs < hslack)            
            {
                hs = x - hslack;
            } //End block
            if(x - hs > hspace - hslack)            
            {
                hs = x - (hspace - hslack);
            } //End block
        } //End block
        if(grav < 0)        
        {
            if(left - hs > 0)            
            hs = left;
            if(right - hs < hspace)            
            hs = right - hspace;
        } //End block
        else
        if(grav > 0)        
        {
            if(right - hs < hspace)            
            hs = right - hspace;
            if(left - hs > 0)            
            hs = left;
        } //End block
        else
        {
            if(right - left <= hspace)            
            {
                hs = left - (hspace - (right - left)) / 2;
            } //End block
            else
            if(x > right - hslack)            
            {
                hs = right - hspace;
            } //End block
            else
            if(x < left + hslack)            
            {
                hs = left;
            } //End block
            else
            if(left > hs)            
            {
                hs = left;
            } //End block
            else
            if(right < hs + hspace)            
            {
                hs = right - hspace;
            } //End block
            else
            {
                if(x - hs < hslack)                
                {
                    hs = x - hslack;
                } //End block
                if(x - hs > hspace - hslack)                
                {
                    hs = x - (hspace - hslack);
                } //End block
            } //End block
        } //End block
        if(hs != mScrollX || vs != mScrollY)        
        {
            if(mScroller == null)            
            {
                scrollTo(hs, vs);
            } //End block
            else
            {
                long duration = AnimationUtils.currentAnimationTimeMillis() - mLastScroll;
                int dx = hs - mScrollX;
                int dy = vs - mScrollY;
                if(duration > ANIMATED_SCROLL_GAP)                
                {
                    mScroller.startScroll(mScrollX, mScrollY, dx, dy);
                    awakenScrollBars(mScroller.getDuration());
                    invalidate();
                } //End block
                else
                {
                    if(!mScroller.isFinished())                    
                    {
                        mScroller.abortAnimation();
                    } //End block
                    scrollBy(dx, dy);
                } //End block
                mLastScroll = AnimationUtils.currentAnimationTimeMillis();
            } //End block
            changed = true;
        } //End block
        if(isFocused())        
        {
            if(mTempRect == null)            
            mTempRect = new Rect();
            mTempRect.set(x - 2, top, x + 2, bottom);
            getInterestingRect(mTempRect, line);
            mTempRect.offset(mScrollX, mScrollY);
            if(requestRectangleOnScreen(mTempRect))            
            {
                changed = true;
            } //End block
        } //End block
        boolean var8977DFAC2F8E04CB96E66882235F5ABA_784104204 = (changed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1031581105 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1031581105;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.628 -0400", hash_original_method = "02D4B7457672C459E287DBA1B16986EC", hash_generated_method = "BDA71F6ED313B7FA0ED1A4D4BF91C4FD")
    public boolean moveCursorToVisibleOffset() {
        if(!(mText instanceof Spannable))        
        {
            boolean var68934A3E9455FA72420237EB05902327_776185597 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1434241826 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1434241826;
        } //End block
        int start = getSelectionStart();
        int end = getSelectionEnd();
        if(start != end)        
        {
            boolean var68934A3E9455FA72420237EB05902327_153092314 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1144419130 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1144419130;
        } //End block
        int line = mLayout.getLineForOffset(start);
        final int top = mLayout.getLineTop(line);
        final int bottom = mLayout.getLineTop(line + 1);
        final int vspace = mBottom - mTop - getExtendedPaddingTop() - getExtendedPaddingBottom();
        int vslack = (bottom - top) / 2;
        if(vslack > vspace / 4)        
        vslack = vspace / 4;
        final int vs = mScrollY;
        if(top < (vs+vslack))        
        {
            line = mLayout.getLineForVertical(vs+vslack+(bottom-top));
        } //End block
        else
        if(bottom > (vspace+vs-vslack))        
        {
            line = mLayout.getLineForVertical(vspace+vs-vslack-(bottom-top));
        } //End block
        final int hspace = mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight();
        final int hs = mScrollX;
        final int leftChar = mLayout.getOffsetForHorizontal(line, hs);
        final int rightChar = mLayout.getOffsetForHorizontal(line, hspace+hs);
        final int lowChar = leftChar < rightChar ? leftChar : rightChar;
        final int highChar = leftChar > rightChar ? leftChar : rightChar;
        int newStart = start;
        if(newStart < lowChar)        
        {
            newStart = lowChar;
        } //End block
        else
        if(newStart > highChar)        
        {
            newStart = highChar;
        } //End block
        if(newStart != start)        
        {
            Selection.setSelection((Spannable)mText, newStart);
            boolean varB326B5062B2F0E69046810717534CB09_1413410634 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1927946574 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1927946574;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1443817698 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1243820807 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1243820807;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.629 -0400", hash_original_method = "D06313C44705A7887AB654B7CF5A74B3", hash_generated_method = "1267F8C57DC034FA79AACCD8496BA8AD")
    @Override
    public void computeScroll() {
        if(mScroller != null)        
        {
            if(mScroller.computeScrollOffset())            
            {
                mScrollX = mScroller.getCurrX();
                mScrollY = mScroller.getCurrY();
                invalidateParentCaches();
                postInvalidate();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mScroller != null) {
            //if (mScroller.computeScrollOffset()) {
                //mScrollX = mScroller.getCurrX();
                //mScrollY = mScroller.getCurrY();
                //invalidateParentCaches();
                //postInvalidate();  
            //}
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.629 -0400", hash_original_method = "ABFDC323272F3E6393D3C4F9B9F60889", hash_generated_method = "1D5315FF4D852DDAAE4AA9BEC3F7B892")
    private void getInterestingRect(Rect r, int line) {
        addTaint(line);
        addTaint(r.getTaint());
        convertFromViewportToContentCoordinates(r);
        if(line == 0)        
        r.top -= getExtendedPaddingTop();
        if(line == mLayout.getLineCount() - 1)        
        r.bottom += getExtendedPaddingBottom();
        // ---------- Original Method ----------
        //convertFromViewportToContentCoordinates(r);
        //if (line == 0) r.top -= getExtendedPaddingTop();
        //if (line == mLayout.getLineCount() - 1) r.bottom += getExtendedPaddingBottom();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.630 -0400", hash_original_method = "D2E7C9E2773084F5B5BC96B85475267E", hash_generated_method = "51D3DB31DEFE31FA69384F06AAF68217")
    private void convertFromViewportToContentCoordinates(Rect r) {
        addTaint(r.getTaint());
        final int horizontalOffset = viewportToContentHorizontalOffset();
        r.left += horizontalOffset;
        r.right += horizontalOffset;
        final int verticalOffset = viewportToContentVerticalOffset();
        r.top += verticalOffset;
        r.bottom += verticalOffset;
        // ---------- Original Method ----------
        //final int horizontalOffset = viewportToContentHorizontalOffset();
        //r.left += horizontalOffset;
        //r.right += horizontalOffset;
        //final int verticalOffset = viewportToContentVerticalOffset();
        //r.top += verticalOffset;
        //r.bottom += verticalOffset;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.631 -0400", hash_original_method = "3DB802CF5F82AE3562BB26F896D07DB6", hash_generated_method = "B6B6C2A88E03F3EE2B73E3E56779926F")
    private int viewportToContentHorizontalOffset() {
        int var73625E5BB8CA474A0537CB0405EE18B8_1558229382 = (getCompoundPaddingLeft() - mScrollX);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2086704884 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2086704884;
        // ---------- Original Method ----------
        //return getCompoundPaddingLeft() - mScrollX;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.631 -0400", hash_original_method = "1E5AEDFCDEE7B994A62FE1D426BA9AAE", hash_generated_method = "53E6E32C26B90E100B24A531407AB8EC")
    private int viewportToContentVerticalOffset() {
        int offset = getExtendedPaddingTop() - mScrollY;
        if((mGravity & Gravity.VERTICAL_GRAVITY_MASK) != Gravity.TOP)        
        {
            offset += getVerticalOffset(false);
        } //End block
        int var7A86C157EE9713C34FBD7A1EE40F0C5A_135229946 = (offset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_877802947 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_877802947;
        // ---------- Original Method ----------
        //int offset = getExtendedPaddingTop() - mScrollY;
        //if ((mGravity & Gravity.VERTICAL_GRAVITY_MASK) != Gravity.TOP) {
            //offset += getVerticalOffset(false);
        //}
        //return offset;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.631 -0400", hash_original_method = "7E6A70E8247BE9F0E1C3854BAECCAE99", hash_generated_method = "E2C1BBF1EE76C6FE867FD31480C7B44A")
    @Override
    public void debug(int depth) {
        addTaint(depth);
        super.debug(depth);
        String output = debugIndent(depth);
        output += "frame={" + mLeft + ", " + mTop + ", " + mRight
                + ", " + mBottom + "} scroll={" + mScrollX + ", " + mScrollY
                + "} ";
        if(mText != null)        
        {
            output += "mText=\"" + mText + "\" ";
            if(mLayout != null)            
            {
                output += "mLayout width=" + mLayout.getWidth()
                        + " height=" + mLayout.getHeight();
            } //End block
        } //End block
        else
        {
            output += "mText=NULL";
        } //End block
        Log.d(VIEW_LOG_TAG, output);
        // ---------- Original Method ----------
        //super.debug(depth);
        //String output = debugIndent(depth);
        //output += "frame={" + mLeft + ", " + mTop + ", " + mRight
                //+ ", " + mBottom + "} scroll={" + mScrollX + ", " + mScrollY
                //+ "} ";
        //if (mText != null) {
            //output += "mText=\"" + mText + "\" ";
            //if (mLayout != null) {
                //output += "mLayout width=" + mLayout.getWidth()
                        //+ " height=" + mLayout.getHeight();
            //}
        //} else {
            //output += "mText=NULL";
        //}
        //Log.d(VIEW_LOG_TAG, output);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.633 -0400", hash_original_method = "FC0380BF9D344F57087ADAA0F0C8C1E5", hash_generated_method = "CAD9D834AEDE9B84278D5BA3B0B3662E")
    @ViewDebug.ExportedProperty(category = "text")
    public int getSelectionStart() {
        int var30B93C4C85E1EBFD22395DE2731B4301_1331941439 = (Selection.getSelectionStart(getText()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1698614916 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1698614916;
        // ---------- Original Method ----------
        //return Selection.getSelectionStart(getText());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.633 -0400", hash_original_method = "59139061668C8515BDA5938230C2D233", hash_generated_method = "0F1AA8001C17D3263C742E7EF1DC3497")
    @ViewDebug.ExportedProperty(category = "text")
    public int getSelectionEnd() {
        int varFC7F2F11BB178DD53BC98D875140A770_765559159 = (Selection.getSelectionEnd(getText()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1790556044 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1790556044;
        // ---------- Original Method ----------
        //return Selection.getSelectionEnd(getText());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.634 -0400", hash_original_method = "BD52AC55F75FC20C70791ABE185D07B3", hash_generated_method = "DCBD34EB540D108B440D689E100CF8FD")
    public boolean hasSelection() {
        final int selectionStart = getSelectionStart();
        final int selectionEnd = getSelectionEnd();
        boolean var88FF6233D094A4FC50C57CDCA94BAFCB_1043818992 = (selectionStart >= 0 && selectionStart != selectionEnd);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1252932141 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1252932141;
        // ---------- Original Method ----------
        //final int selectionStart = getSelectionStart();
        //final int selectionEnd = getSelectionEnd();
        //return selectionStart >= 0 && selectionStart != selectionEnd;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.634 -0400", hash_original_method = "08C77724BEA7FD604DDC056EC8AC0A85", hash_generated_method = "3BCA6B79215B55736909B9CF7C5FC574")
    public void setSingleLine() {
        setSingleLine(true);
        // ---------- Original Method ----------
        //setSingleLine(true);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.634 -0400", hash_original_method = "02E25EABD0939EA349140FD704ABC4B2", hash_generated_method = "EDA0D7074BB38FC69A8E0310E55FFE90")
    public void setAllCaps(boolean allCaps) {
        addTaint(allCaps);
        if(allCaps)        
        {
            setTransformationMethod(new AllCapsTransformationMethod(getContext()));
        } //End block
        else
        {
            setTransformationMethod(null);
        } //End block
        // ---------- Original Method ----------
        //if (allCaps) {
            //setTransformationMethod(new AllCapsTransformationMethod(getContext()));
        //} else {
            //setTransformationMethod(null);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.634 -0400", hash_original_method = "F67AECEDD15B73EEA4C7246A27A881B1", hash_generated_method = "13FD96A66F2E65A90F5EEA22F0530E59")
    @android.view.RemotableViewMethod
    public void setSingleLine(boolean singleLine) {
        addTaint(singleLine);
        setInputTypeSingleLine(singleLine);
        applySingleLine(singleLine, true, true);
        // ---------- Original Method ----------
        //setInputTypeSingleLine(singleLine);
        //applySingleLine(singleLine, true, true);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.634 -0400", hash_original_method = "7606E2D7FCC52ECFF0946358CA46A596", hash_generated_method = "1A9BCBD370CE73FB7D387765C65DBFB2")
    private void setInputTypeSingleLine(boolean singleLine) {
        addTaint(singleLine);
        if((mInputType & EditorInfo.TYPE_MASK_CLASS) == EditorInfo.TYPE_CLASS_TEXT)        
        {
            if(singleLine)            
            {
                mInputType &= ~EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE;
            } //End block
            else
            {
                mInputType |= EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if ((mInputType & EditorInfo.TYPE_MASK_CLASS) == EditorInfo.TYPE_CLASS_TEXT) {
            //if (singleLine) {
                //mInputType &= ~EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE;
            //} else {
                //mInputType |= EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE;
            //}
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.636 -0400", hash_original_method = "939294E5BC9AAD2D1E9D05ACD8801E5C", hash_generated_method = "40AAE2280F3343A1DD91C48566050FA3")
    private void applySingleLine(boolean singleLine, boolean applyTransformation,
            boolean changeMaxLines) {
        addTaint(changeMaxLines);
        addTaint(applyTransformation);
        mSingleLine = singleLine;
        if(singleLine)        
        {
            setLines(1);
            setHorizontallyScrolling(true);
            if(applyTransformation)            
            {
                setTransformationMethod(SingleLineTransformationMethod.getInstance());
            } //End block
        } //End block
        else
        {
            if(changeMaxLines)            
            {
                setMaxLines(Integer.MAX_VALUE);
            } //End block
            setHorizontallyScrolling(false);
            if(applyTransformation)            
            {
                setTransformationMethod(null);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //mSingleLine = singleLine;
        //if (singleLine) {
            //setLines(1);
            //setHorizontallyScrolling(true);
            //if (applyTransformation) {
                //setTransformationMethod(SingleLineTransformationMethod.getInstance());
            //}
        //} else {
            //if (changeMaxLines) {
                //setMaxLines(Integer.MAX_VALUE);
            //}
            //setHorizontallyScrolling(false);
            //if (applyTransformation) {
                //setTransformationMethod(null);
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.636 -0400", hash_original_method = "8F48F7BF1B8DCE5D5519F1200A0ED853", hash_generated_method = "013F5B522239BCFED689BBC93A9546EA")
    public void setEllipsize(TextUtils.TruncateAt where) {
        if(mEllipsize != where)        
        {
            mEllipsize = where;
            if(mLayout != null)            
            {
                nullLayouts();
                requestLayout();
                invalidate();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mEllipsize != where) {
            //mEllipsize = where;
            //if (mLayout != null) {
                //nullLayouts();
                //requestLayout();
                //invalidate();
            //}
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.636 -0400", hash_original_method = "CD4BE90CF39D915FD988D1208E7FE9CE", hash_generated_method = "5F7F9C51B8B3A126669EEFC67E596872")
    public void setMarqueeRepeatLimit(int marqueeLimit) {
        mMarqueeRepeatLimit = marqueeLimit;
        // ---------- Original Method ----------
        //mMarqueeRepeatLimit = marqueeLimit;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.637 -0400", hash_original_method = "A6931739C39A011B325E0D6A04B5E1A4", hash_generated_method = "58130D574310FBE8AB2A34004D9FD5A3")
    @ViewDebug.ExportedProperty
    public TextUtils.TruncateAt getEllipsize() {
TextUtils.TruncateAt var6CB6395DE55911CDD92EE563ED3978B7_1530994548 =         mEllipsize;
        var6CB6395DE55911CDD92EE563ED3978B7_1530994548.addTaint(taint);
        return var6CB6395DE55911CDD92EE563ED3978B7_1530994548;
        // ---------- Original Method ----------
        //return mEllipsize;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.637 -0400", hash_original_method = "EF856664E3DB8B213F8E2D5A0092DC9C", hash_generated_method = "93D7697E67D97A654B5EB872F69B9428")
    @android.view.RemotableViewMethod
    public void setSelectAllOnFocus(boolean selectAllOnFocus) {
        mSelectAllOnFocus = selectAllOnFocus;
        if(selectAllOnFocus && !(mText instanceof Spannable))        
        {
            setText(mText, BufferType.SPANNABLE);
        } //End block
        // ---------- Original Method ----------
        //mSelectAllOnFocus = selectAllOnFocus;
        //if (selectAllOnFocus && !(mText instanceof Spannable)) {
            //setText(mText, BufferType.SPANNABLE);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.638 -0400", hash_original_method = "8363604A399432417CD34524C965D01B", hash_generated_method = "2068D1EEFD96A97F2D941815A5C699BC")
    @android.view.RemotableViewMethod
    public void setCursorVisible(boolean visible) {
        if(mCursorVisible != visible)        
        {
            mCursorVisible = visible;
            invalidate();
            makeBlink();
            prepareCursorControllers();
        } //End block
        // ---------- Original Method ----------
        //if (mCursorVisible != visible) {
            //mCursorVisible = visible;
            //invalidate();
            //makeBlink();
            //prepareCursorControllers();
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.638 -0400", hash_original_method = "D29F788B650242C9D9871158254DD48F", hash_generated_method = "88EDD1EB0E4C1097F6892A88C73429FA")
    private boolean isCursorVisible() {
        boolean var643619F465D21B426120407AFD36CCD0_712081441 = (mCursorVisible && isTextEditable());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2131417481 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2131417481;
        // ---------- Original Method ----------
        //return mCursorVisible && isTextEditable();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.638 -0400", hash_original_method = "20D9FD35375357DA34698727A7AEC969", hash_generated_method = "99A6688BB532EE408CCD434B21E725E8")
    private boolean canMarquee() {
        int width = (mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight());
        boolean var75B63B76A7FC1BD10CE1F538C0856997_1517878162 = (width > 0 && (mLayout.getLineWidth(0) > width ||
                (mMarqueeFadeMode != MARQUEE_FADE_NORMAL && mSavedMarqueeModeLayout != null &&
                        mSavedMarqueeModeLayout.getLineWidth(0) > width)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1229408296 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1229408296;
        // ---------- Original Method ----------
        //int width = (mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight());
        //return width > 0 && (mLayout.getLineWidth(0) > width ||
                //(mMarqueeFadeMode != MARQUEE_FADE_NORMAL && mSavedMarqueeModeLayout != null &&
                        //mSavedMarqueeModeLayout.getLineWidth(0) > width));
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.638 -0400", hash_original_method = "A5A9508FE00ED8FCDF4CF88DA2302AE0", hash_generated_method = "F47225DF6BEC0D573F40462297A68D9A")
    private void startMarquee() {
        if(mInput != null)        
        return;
        if(compressText(getWidth() - getCompoundPaddingLeft() - getCompoundPaddingRight()))        
        {
            return;
        } //End block
        if((mMarquee == null || mMarquee.isStopped()) && (isFocused() || isSelected()) &&
                getLineCount() == 1 && canMarquee())        
        {
            if(mMarqueeFadeMode == MARQUEE_FADE_SWITCH_SHOW_ELLIPSIS)            
            {
                mMarqueeFadeMode = MARQUEE_FADE_SWITCH_SHOW_FADE;
                final Layout tmp = mLayout;
                mLayout = mSavedMarqueeModeLayout;
                mSavedMarqueeModeLayout = tmp;
                setHorizontalFadingEdgeEnabled(true);
                requestLayout();
                invalidate();
            } //End block
            if(mMarquee == null)            
            mMarquee = new Marquee(this);
            mMarquee.start(mMarqueeRepeatLimit);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.639 -0400", hash_original_method = "20FFAC26BF2AB259CA62980CC6D60A71", hash_generated_method = "F253FF6DCFA570ED6FE8649F3ABA5A28")
    private void stopMarquee() {
        if(mMarquee != null && !mMarquee.isStopped())        
        {
            mMarquee.stop();
        } //End block
        if(mMarqueeFadeMode == MARQUEE_FADE_SWITCH_SHOW_FADE)        
        {
            mMarqueeFadeMode = MARQUEE_FADE_SWITCH_SHOW_ELLIPSIS;
            final Layout tmp = mSavedMarqueeModeLayout;
            mSavedMarqueeModeLayout = mLayout;
            mLayout = tmp;
            setHorizontalFadingEdgeEnabled(false);
            requestLayout();
            invalidate();
        } //End block
        // ---------- Original Method ----------
        //if (mMarquee != null && !mMarquee.isStopped()) {
            //mMarquee.stop();
        //}
        //if (mMarqueeFadeMode == MARQUEE_FADE_SWITCH_SHOW_FADE) {
            //mMarqueeFadeMode = MARQUEE_FADE_SWITCH_SHOW_ELLIPSIS;
            //final Layout tmp = mSavedMarqueeModeLayout;
            //mSavedMarqueeModeLayout = mLayout;
            //mLayout = tmp;
            //setHorizontalFadingEdgeEnabled(false);
            //requestLayout();
            //invalidate();
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.639 -0400", hash_original_method = "21D240E17A817FDDEDCDA696469AE631", hash_generated_method = "04BCB84AACACF4388AE0D76F31A977D0")
    private void startStopMarquee(boolean start) {
        addTaint(start);
        if(mEllipsize == TextUtils.TruncateAt.MARQUEE)        
        {
            if(start)            
            {
                startMarquee();
            } //End block
            else
            {
                stopMarquee();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mEllipsize == TextUtils.TruncateAt.MARQUEE) {
            //if (start) {
                //startMarquee();
            //} else {
                //stopMarquee();
            //}
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.640 -0400", hash_original_method = "CD3A5A17C18A7E4515BB5E10EEE133D7", hash_generated_method = "9B197384B6998F269B7A7ACF293C707B")
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(lengthAfter);
        addTaint(lengthBefore);
        addTaint(start);
        addTaint(text.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.640 -0400", hash_original_method = "50DC1B812435050055FA72016E5949C2", hash_generated_method = "C19C5028F44F7057628D77323AB13E14")
    protected void onSelectionChanged(int selStart, int selEnd) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(selEnd);
        addTaint(selStart);
        sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED);
        // ---------- Original Method ----------
        //sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.640 -0400", hash_original_method = "B64F50676D912718618203C6EADBF90A", hash_generated_method = "E5EFFF936381275657CBB3A6354B6BE9")
    public void addTextChangedListener(TextWatcher watcher) {
        addTaint(watcher.getTaint());
        if(mListeners == null)        
        {
            mListeners = new ArrayList<TextWatcher>();
        } //End block
        mListeners.add(watcher);
        // ---------- Original Method ----------
        //if (mListeners == null) {
            //mListeners = new ArrayList<TextWatcher>();
        //}
        //mListeners.add(watcher);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.641 -0400", hash_original_method = "8E2AAA118EDD6CA871B924E45DB79686", hash_generated_method = "AC76E54A337F1209E3A4CC2E7085718D")
    public void removeTextChangedListener(TextWatcher watcher) {
        addTaint(watcher.getTaint());
        if(mListeners != null)        
        {
            int i = mListeners.indexOf(watcher);
            if(i >= 0)            
            {
                mListeners.remove(i);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mListeners != null) {
            //int i = mListeners.indexOf(watcher);
            //if (i >= 0) {
                //mListeners.remove(i);
            //}
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.642 -0400", hash_original_method = "282476D07DF9C69037F7F82B56506B50", hash_generated_method = "1BB2639A9DEEA84EEC616007E5EBE276")
    private void sendBeforeTextChanged(CharSequence text, int start, int before, int after) {
        addTaint(after);
        addTaint(before);
        addTaint(start);
        addTaint(text.getTaint());
        if(mListeners != null)        
        {
            final ArrayList<TextWatcher> list = mListeners;
            final int count = list.size();
for(int i = 0;i < count;i++)
            {
                list.get(i).beforeTextChanged(text, start, before, after);
            } //End block
        } //End block
        removeIntersectingSpans(start, start + before, SpellCheckSpan.class);
        removeIntersectingSpans(start, start + before, SuggestionSpan.class);
        // ---------- Original Method ----------
        //if (mListeners != null) {
            //final ArrayList<TextWatcher> list = mListeners;
            //final int count = list.size();
            //for (int i = 0; i < count; i++) {
                //list.get(i).beforeTextChanged(text, start, before, after);
            //}
        //}
        //removeIntersectingSpans(start, start + before, SpellCheckSpan.class);
        //removeIntersectingSpans(start, start + before, SuggestionSpan.class);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.642 -0400", hash_original_method = "3C2834233455B82E3097E9750018AB89", hash_generated_method = "9746CE50A0BC4885ABD44D4FB3A5D0A5")
    private <T> void removeIntersectingSpans(int start, int end, Class<T> type) {
        addTaint(type.getTaint());
        addTaint(end);
        addTaint(start);
        if(!(mText instanceof Editable))        
        return;
        Editable text = (Editable) mText;
        T[] spans = text.getSpans(start, end, type);
        final int length = spans.length;
for(int i = 0;i < length;i++)
        {
            final int s = text.getSpanStart(spans[i]);
            final int e = text.getSpanEnd(spans[i]);
            if(e == start || s == end)            
            break;
            text.removeSpan(spans[i]);
        } //End block
        // ---------- Original Method ----------
        //if (!(mText instanceof Editable)) return;
        //Editable text = (Editable) mText;
        //T[] spans = text.getSpans(start, end, type);
        //final int length = spans.length;
        //for (int i = 0; i < length; i++) {
            //final int s = text.getSpanStart(spans[i]);
            //final int e = text.getSpanEnd(spans[i]);
            //if (e == start || s == end) break;
            //text.removeSpan(spans[i]);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.642 -0400", hash_original_method = "942AE7F3893B5D5A1A729CC9A3D3A214", hash_generated_method = "8A2B3151DA2B7AC8813B56F2599065B2")
     void sendOnTextChanged(CharSequence text, int start, int before, int after) {
        addTaint(after);
        addTaint(before);
        addTaint(start);
        addTaint(text.getTaint());
        if(mListeners != null)        
        {
            final ArrayList<TextWatcher> list = mListeners;
            final int count = list.size();
for(int i = 0;i < count;i++)
            {
                list.get(i).onTextChanged(text, start, before, after);
            } //End block
        } //End block
        updateSpellCheckSpans(start, start + after, false);
        hideCursorControllers();
        // ---------- Original Method ----------
        //if (mListeners != null) {
            //final ArrayList<TextWatcher> list = mListeners;
            //final int count = list.size();
            //for (int i = 0; i < count; i++) {
                //list.get(i).onTextChanged(text, start, before, after);
            //}
        //}
        //updateSpellCheckSpans(start, start + after, false);
        //hideCursorControllers();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.643 -0400", hash_original_method = "9B73ECD477F18D05FDDE640FFC672625", hash_generated_method = "31AE0FBE0D8025C22A2BE7D8325868B2")
     void sendAfterTextChanged(Editable text) {
        addTaint(text.getTaint());
        if(mListeners != null)        
        {
            final ArrayList<TextWatcher> list = mListeners;
            final int count = list.size();
for(int i = 0;i < count;i++)
            {
                list.get(i).afterTextChanged(text);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mListeners != null) {
            //final ArrayList<TextWatcher> list = mListeners;
            //final int count = list.size();
            //for (int i = 0; i < count; i++) {
                //list.get(i).afterTextChanged(text);
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.645 -0400", hash_original_method = "4CD104B06ADE0BFE958B91634E28368D", hash_generated_method = "0882BDF3E1791DAB5A230AFCC446A743")
     void handleTextChanged(CharSequence buffer, int start, int before, int after) {
        addTaint(after);
        addTaint(before);
        addTaint(start);
        addTaint(buffer.getTaint());
        final InputMethodState ims = mInputMethodState;
        if(ims == null || ims.mBatchEditNesting == 0)        
        {
            updateAfterEdit();
        } //End block
        if(ims != null)        
        {
            ims.mContentChanged = true;
            if(ims.mChangedStart < 0)            
            {
                ims.mChangedStart = start;
                ims.mChangedEnd = start+before;
            } //End block
            else
            {
                ims.mChangedStart = Math.min(ims.mChangedStart, start);
                ims.mChangedEnd = Math.max(ims.mChangedEnd, start + before - ims.mChangedDelta);
            } //End block
            ims.mChangedDelta += after-before;
        } //End block
        sendOnTextChanged(buffer, start, before, after);
        onTextChanged(buffer, start, before, after);
        // ---------- Original Method ----------
        //final InputMethodState ims = mInputMethodState;
        //if (ims == null || ims.mBatchEditNesting == 0) {
            //updateAfterEdit();
        //}
        //if (ims != null) {
            //ims.mContentChanged = true;
            //if (ims.mChangedStart < 0) {
                //ims.mChangedStart = start;
                //ims.mChangedEnd = start+before;
            //} else {
                //ims.mChangedStart = Math.min(ims.mChangedStart, start);
                //ims.mChangedEnd = Math.max(ims.mChangedEnd, start + before - ims.mChangedDelta);
            //}
            //ims.mChangedDelta += after-before;
        //}
        //sendOnTextChanged(buffer, start, before, after);
        //onTextChanged(buffer, start, before, after);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.650 -0400", hash_original_method = "69940040C167925CDE0DCFB6E34891AF", hash_generated_method = "92F605C6934390B5F7876654C187C006")
     void spanChange(Spanned buf, Object what, int oldStart, int newStart, int oldEnd, int newEnd) {
        addTaint(newEnd);
        addTaint(oldEnd);
        addTaint(newStart);
        addTaint(oldStart);
        addTaint(what.getTaint());
        addTaint(buf.getTaint());
        boolean selChanged = false;
        int newSelStart = -1;
        int newSelEnd = -1;
        final InputMethodState ims = mInputMethodState;
        if(what == Selection.SELECTION_END)        
        {
            mHighlightPathBogus = true;
            selChanged = true;
            newSelEnd = newStart;
            if(!isFocused())            
            {
                mSelectionMoved = true;
            } //End block
            if(oldStart >= 0 || newStart >= 0)            
            {
                invalidateCursor(Selection.getSelectionStart(buf), oldStart, newStart);
                registerForPreDraw();
                makeBlink();
            } //End block
        } //End block
        if(what == Selection.SELECTION_START)        
        {
            mHighlightPathBogus = true;
            selChanged = true;
            newSelStart = newStart;
            if(!isFocused())            
            {
                mSelectionMoved = true;
            } //End block
            if(oldStart >= 0 || newStart >= 0)            
            {
                int end = Selection.getSelectionEnd(buf);
                invalidateCursor(end, oldStart, newStart);
            } //End block
        } //End block
        if(selChanged)        
        {
            if((buf.getSpanFlags(what)&Spanned.SPAN_INTERMEDIATE) == 0)            
            {
                if(newSelStart < 0)                
                {
                    newSelStart = Selection.getSelectionStart(buf);
                } //End block
                if(newSelEnd < 0)                
                {
                    newSelEnd = Selection.getSelectionEnd(buf);
                } //End block
                onSelectionChanged(newSelStart, newSelEnd);
            } //End block
        } //End block
        if(what instanceof UpdateAppearance || what instanceof ParagraphStyle)        
        {
            if(ims == null || ims.mBatchEditNesting == 0)            
            {
                invalidate();
                mHighlightPathBogus = true;
                checkForResize();
            } //End block
            else
            {
                ims.mContentChanged = true;
            } //End block
        } //End block
        if(MetaKeyKeyListener.isMetaTracker(buf, what))        
        {
            mHighlightPathBogus = true;
            if(ims != null && MetaKeyKeyListener.isSelectingMetaTracker(buf, what))            
            {
                ims.mSelectionModeChanged = true;
            } //End block
            if(Selection.getSelectionStart(buf) >= 0)            
            {
                if(ims == null || ims.mBatchEditNesting == 0)                
                {
                    invalidateCursor();
                } //End block
                else
                {
                    ims.mCursorChanged = true;
                } //End block
            } //End block
        } //End block
        if(what instanceof ParcelableSpan)        
        {
            if(ims != null && ims.mExtracting != null)            
            {
                if(ims.mBatchEditNesting != 0)                
                {
                    if(oldStart >= 0)                    
                    {
                        if(ims.mChangedStart > oldStart)                        
                        {
                            ims.mChangedStart = oldStart;
                        } //End block
                        if(ims.mChangedStart > oldEnd)                        
                        {
                            ims.mChangedStart = oldEnd;
                        } //End block
                    } //End block
                    if(newStart >= 0)                    
                    {
                        if(ims.mChangedStart > newStart)                        
                        {
                            ims.mChangedStart = newStart;
                        } //End block
                        if(ims.mChangedStart > newEnd)                        
                        {
                            ims.mChangedStart = newEnd;
                        } //End block
                    } //End block
                } //End block
                else
                {
                    if(DEBUG_EXTRACT){ }                    ims.mContentChanged = true;
                } //End block
            } //End block
        } //End block
        if(mSpellChecker != null && newStart < 0 && what instanceof SpellCheckSpan)        
        {
            mSpellChecker.removeSpellCheckSpan((SpellCheckSpan) what);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.652 -0400", hash_original_method = "3584A2B9A599770217F39B9A82ACFE32", hash_generated_method = "4184BD272AF254DD6BDAAFEA06822E03")
    private void updateSpellCheckSpans(int start, int end, boolean createSpellChecker) {
        addTaint(createSpellChecker);
        addTaint(end);
        addTaint(start);
        if(isTextEditable() && isSuggestionsEnabled() && !(this instanceof ExtractEditText))        
        {
            if(mSpellChecker == null && createSpellChecker)            
            {
                mSpellChecker = new SpellChecker(this);
            } //End block
            if(mSpellChecker != null)            
            {
                mSpellChecker.spellCheck(start, end);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (isTextEditable() && isSuggestionsEnabled() && !(this instanceof ExtractEditText)) {
            //if (mSpellChecker == null && createSpellChecker) {
                //mSpellChecker = new SpellChecker(this);
            //}
            //if (mSpellChecker != null) {
                //mSpellChecker.spellCheck(start, end);
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.652 -0400", hash_original_method = "5B060B8ED8B2D254991A03FDABE416A2", hash_generated_method = "5442F0493B231BDA57B4F0511037B18F")
    @Override
    public void dispatchFinishTemporaryDetach() {
        mDispatchTemporaryDetach = true;
        super.dispatchFinishTemporaryDetach();
        mDispatchTemporaryDetach = false;
        // ---------- Original Method ----------
        //mDispatchTemporaryDetach = true;
        //super.dispatchFinishTemporaryDetach();
        //mDispatchTemporaryDetach = false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.652 -0400", hash_original_method = "F389EC0F4785B5FE5917104FC845071C", hash_generated_method = "BD41316F52B05C90345D7F6F37DA1540")
    @Override
    public void onStartTemporaryDetach() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onStartTemporaryDetach();
        if(!mDispatchTemporaryDetach)        
        mTemporaryDetach = true;
        hideControllers();
        // ---------- Original Method ----------
        //super.onStartTemporaryDetach();
        //if (!mDispatchTemporaryDetach) mTemporaryDetach = true;
        //hideControllers();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.653 -0400", hash_original_method = "FEAF0C4CB4DA72DBC669293A29968ABE", hash_generated_method = "CD265232532CEBE3152A34570DED6A5A")
    @Override
    public void onFinishTemporaryDetach() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onFinishTemporaryDetach();
        if(!mDispatchTemporaryDetach)        
        mTemporaryDetach = false;
        // ---------- Original Method ----------
        //super.onFinishTemporaryDetach();
        //if (!mDispatchTemporaryDetach) mTemporaryDetach = false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.654 -0400", hash_original_method = "B5EB741E17FA804FF18CB2D4805829B5", hash_generated_method = "B30D79FBBBE4B58E1AFE3464A8884563")
    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(previouslyFocusedRect.getTaint());
        addTaint(direction);
        addTaint(focused);
        if(mTemporaryDetach)        
        {
            super.onFocusChanged(focused, direction, previouslyFocusedRect);
            return;
        } //End block
        mShowCursor = SystemClock.uptimeMillis();
        ensureEndedBatchEdit();
        if(focused)        
        {
            int selStart = getSelectionStart();
            int selEnd = getSelectionEnd();
            final boolean isFocusHighlighted = mSelectAllOnFocus && selStart == 0 &&
                    selEnd == mText.length();
            mCreatedWithASelection = mFrozenWithFocus && hasSelection() && !isFocusHighlighted;
            if(!mFrozenWithFocus || (selStart < 0 || selEnd < 0))            
            {
                final int lastTapPosition = getLastTapPosition();
                if(lastTapPosition >= 0)                
                {
                    Selection.setSelection((Spannable) mText, lastTapPosition);
                } //End block
                if(mMovement != null)                
                {
                    mMovement.onTakeFocus(this, (Spannable) mText, direction);
                } //End block
                if(((this instanceof ExtractEditText) || mSelectionMoved) &&
                        selStart >= 0 && selEnd >= 0)                
                {
                    Selection.setSelection((Spannable) mText, selStart, selEnd);
                } //End block
                if(mSelectAllOnFocus)                
                {
                    selectAll();
                } //End block
                mTouchFocusSelected = true;
            } //End block
            mFrozenWithFocus = false;
            mSelectionMoved = false;
            if(mText instanceof Spannable)            
            {
                Spannable sp = (Spannable) mText;
                MetaKeyKeyListener.resetMetaState(sp);
            } //End block
            makeBlink();
            if(mError != null)            
            {
                showError();
            } //End block
        } //End block
        else
        {
            if(mError != null)            
            {
                hideError();
            } //End block
            onEndBatchEdit();
            if(this instanceof ExtractEditText)            
            {
                final int selStart = getSelectionStart();
                final int selEnd = getSelectionEnd();
                hideControllers();
                Selection.setSelection((Spannable) mText, selStart, selEnd);
            } //End block
            else
            {
                hideControllers();
                downgradeEasyCorrectionSpans();
            } //End block
            if(mSelectionModifierCursorController != null)            
            {
                mSelectionModifierCursorController.resetTouchOffsets();
            } //End block
        } //End block
        startStopMarquee(focused);
        if(mTransformation != null)        
        {
            mTransformation.onFocusChanged(this, mText, focused, direction, previouslyFocusedRect);
        } //End block
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.654 -0400", hash_original_method = "CD7EF11AEB2748DC958E6E43AA11AC3D", hash_generated_method = "E23F029EED46DC9F4909F8D04BD6C6DF")
    private int getLastTapPosition() {
        if(mSelectionModifierCursorController != null)        
        {
            int lastTapPosition = mSelectionModifierCursorController.getMinTouchOffset();
            if(lastTapPosition >= 0)            
            {
                if(lastTapPosition > mText.length())                
                {
                    lastTapPosition = mText.length();
                } //End block
                int var8CFB050F377F25E59362C327B0F8789E_1482863062 = (lastTapPosition);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_842465369 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_842465369;
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1902853746 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1017664635 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1017664635;
        // ---------- Original Method ----------
        //if (mSelectionModifierCursorController != null) {
            //int lastTapPosition = mSelectionModifierCursorController.getMinTouchOffset();
            //if (lastTapPosition >= 0) {
                //if (lastTapPosition > mText.length()) {
                    //Log.e(LOG_TAG, "Invalid tap focus position (" + lastTapPosition + " vs "
                            //+ mText.length() + ")");
                    //lastTapPosition = mText.length();
                //}
                //return lastTapPosition;
            //}
        //}
        //return -1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.656 -0400", hash_original_method = "52F09857D084B6A7FF7DED6ACD447E38", hash_generated_method = "69BF9525FDFF2CB82ADD23479AA70C6C")
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(hasWindowFocus);
        super.onWindowFocusChanged(hasWindowFocus);
        if(hasWindowFocus)        
        {
            if(mBlink != null)            
            {
                mBlink.uncancel();
                makeBlink();
            } //End block
        } //End block
        else
        {
            if(mBlink != null)            
            {
                mBlink.cancel();
            } //End block
            onEndBatchEdit();
            if(mInputContentType != null)            
            {
                mInputContentType.enterDown = false;
            } //End block
            hideControllers();
            if(mSuggestionsPopupWindow != null)            
            {
                mSuggestionsPopupWindow.onParentLostFocus();
            } //End block
        } //End block
        startStopMarquee(hasWindowFocus);
        // ---------- Original Method ----------
        //super.onWindowFocusChanged(hasWindowFocus);
        //if (hasWindowFocus) {
            //if (mBlink != null) {
                //mBlink.uncancel();
                //makeBlink();
            //}
        //} else {
            //if (mBlink != null) {
                //mBlink.cancel();
            //}
            //onEndBatchEdit();
            //if (mInputContentType != null) {
                //mInputContentType.enterDown = false;
            //}
            //hideControllers();
            //if (mSuggestionsPopupWindow != null) {
                //mSuggestionsPopupWindow.onParentLostFocus();
            //}
        //}
        //startStopMarquee(hasWindowFocus);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.656 -0400", hash_original_method = "CACE22E1BEC14AEE1A4D35946DA3AF11", hash_generated_method = "82535CC6D61B9FF3DA296F6147391303")
    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(visibility);
        addTaint(changedView.getTaint());
        super.onVisibilityChanged(changedView, visibility);
        if(visibility != VISIBLE)        
        {
            hideControllers();
        } //End block
        // ---------- Original Method ----------
        //super.onVisibilityChanged(changedView, visibility);
        //if (visibility != VISIBLE) {
            //hideControllers();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.656 -0400", hash_original_method = "B1100F7CC0894E179F002CED35623F94", hash_generated_method = "F9B800B4F22252C7CCF0BF4C042AF4EB")
    public void clearComposingText() {
        if(mText instanceof Spannable)        
        {
            BaseInputConnection.removeComposingSpans((Spannable)mText);
        } //End block
        // ---------- Original Method ----------
        //if (mText instanceof Spannable) {
            //BaseInputConnection.removeComposingSpans((Spannable)mText);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.656 -0400", hash_original_method = "D9A75FFCA0200824B6C25D7D7E778114", hash_generated_method = "1356165A5FF534D6C453160B24581F56")
    @Override
    public void setSelected(boolean selected) {
        addTaint(selected);
        boolean wasSelected = isSelected();
        super.setSelected(selected);
        if(selected != wasSelected && mEllipsize == TextUtils.TruncateAt.MARQUEE)        
        {
            if(selected)            
            {
                startMarquee();
            } //End block
            else
            {
                stopMarquee();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //boolean wasSelected = isSelected();
        //super.setSelected(selected);
        //if (selected != wasSelected && mEllipsize == TextUtils.TruncateAt.MARQUEE) {
            //if (selected) {
                //startMarquee();
            //} else {
                //stopMarquee();
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.658 -0400", hash_original_method = "66B01BC66F894D20F58119BE8C84CE2C", hash_generated_method = "F610DFCE7FAA2581BE919DDA71FE4DC4")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        final int action = event.getActionMasked();
        if(hasSelectionController())        
        {
            getSelectionController().onTouchEvent(event);
        } //End block
        if(action == MotionEvent.ACTION_DOWN)        
        {
            mLastDownPositionX = event.getX();
            mLastDownPositionY = event.getY();
            mTouchFocusSelected = false;
            mIgnoreActionUpEvent = false;
        } //End block
        final boolean superResult = super.onTouchEvent(event);
        if(mDiscardNextActionUp && action == MotionEvent.ACTION_UP)        
        {
            mDiscardNextActionUp = false;
            boolean var7038AC4E0748B0E8F74FABE6B3B3A49A_2118700739 = (superResult);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1012690797 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1012690797;
        } //End block
        final boolean touchIsFinished = (action == MotionEvent.ACTION_UP) &&
                !shouldIgnoreActionUpEvent() && isFocused();
        if((mMovement != null || onCheckIsTextEditor()) && isEnabled()
                && mText instanceof Spannable && mLayout != null)        
        {
            boolean handled = false;
            if(mMovement != null)            
            {
                handled |= mMovement.onTouchEvent(this, (Spannable) mText, event);
            } //End block
            if(touchIsFinished && mLinksClickable && mAutoLinkMask != 0 && mTextIsSelectable)            
            {
                ClickableSpan[] links = ((Spannable) mText).getSpans(getSelectionStart(),
                        getSelectionEnd(), ClickableSpan.class);
                if(links.length != 0)                
                {
                    links[0].onClick(this);
                    handled = true;
                } //End block
            } //End block
            if(touchIsFinished && (isTextEditable() || mTextIsSelectable))            
            {
                final InputMethodManager imm = InputMethodManager.peekInstance();
                viewClicked(imm);
                if(!mTextIsSelectable && mSoftInputShownOnFocus)                
                {
                    handled |= imm != null && imm.showSoftInput(this, 0);
                } //End block
                boolean selectAllGotFocus = mSelectAllOnFocus && didTouchFocusSelect();
                hideControllers();
                if(!selectAllGotFocus && mText.length() > 0)                
                {
                    if(mSpellChecker != null)                    
                    {
                        mSpellChecker.onSelectionChanged();
                    } //End block
                    if(!extractedTextModeWillBeStarted())                    
                    {
                        if(isCursorInsideEasyCorrectionSpan())                        
                        {
                            showSuggestions();
                        } //End block
                        else
                        if(hasInsertionController())                        
                        {
                            getInsertionController().show();
                        } //End block
                    } //End block
                } //End block
                handled = true;
            } //End block
            if(handled)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1082392006 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1100483559 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1100483559;
            } //End block
        } //End block
        boolean var7038AC4E0748B0E8F74FABE6B3B3A49A_245984384 = (superResult);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_37782059 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_37782059;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.658 -0400", hash_original_method = "03AC5F43014CB2A7B3EC5095819B8787", hash_generated_method = "918B64ABC30528493B0868E6A6C2C7D2")
    private boolean isCursorInsideSuggestionSpan() {
        if(!(mText instanceof Spannable))        
        {
        boolean var68934A3E9455FA72420237EB05902327_863866182 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1485032337 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1485032337;
        }
        SuggestionSpan[] suggestionSpans = ((Spannable) mText).getSpans(getSelectionStart(),
                getSelectionEnd(), SuggestionSpan.class);
        boolean varDA48BD6F5E4F41CADF03B9AE4FA72E74_642103800 = ((suggestionSpans.length > 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_397584740 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_397584740;
        // ---------- Original Method ----------
        //if (!(mText instanceof Spannable)) return false;
        //SuggestionSpan[] suggestionSpans = ((Spannable) mText).getSpans(getSelectionStart(),
                //getSelectionEnd(), SuggestionSpan.class);
        //return (suggestionSpans.length > 0);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.658 -0400", hash_original_method = "FDBB0D2E258BF757A8B32CAC4ADCAFC2", hash_generated_method = "4EF3E2833CE1D65B43B3A1EFF7E3FF5F")
    private boolean isCursorInsideEasyCorrectionSpan() {
        Spannable spannable = (Spannable) mText;
        SuggestionSpan[] suggestionSpans = spannable.getSpans(getSelectionStart(),
                getSelectionEnd(), SuggestionSpan.class);
for(int i = 0;i < suggestionSpans.length;i++)
        {
            if((suggestionSpans[i].getFlags() & SuggestionSpan.FLAG_EASY_CORRECT) != 0)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_823633960 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1275566741 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1275566741;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1838091152 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1273322841 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1273322841;
        // ---------- Original Method ----------
        //Spannable spannable = (Spannable) mText;
        //SuggestionSpan[] suggestionSpans = spannable.getSpans(getSelectionStart(),
                //getSelectionEnd(), SuggestionSpan.class);
        //for (int i = 0; i < suggestionSpans.length; i++) {
            //if ((suggestionSpans[i].getFlags() & SuggestionSpan.FLAG_EASY_CORRECT) != 0) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.660 -0400", hash_original_method = "B422CE655E2FA1B2DED230B806484199", hash_generated_method = "259B95489C176142DACBCACE267B5D89")
    private void downgradeEasyCorrectionSpans() {
        if(mText instanceof Spannable)        
        {
            Spannable spannable = (Spannable) mText;
            SuggestionSpan[] suggestionSpans = spannable.getSpans(0,
                    spannable.length(), SuggestionSpan.class);
for(int i = 0;i < suggestionSpans.length;i++)
            {
                int flags = suggestionSpans[i].getFlags();
                if((flags & SuggestionSpan.FLAG_EASY_CORRECT) != 0
                        && (flags & SuggestionSpan.FLAG_MISSPELLED) == 0)                
                {
                    flags &= ~SuggestionSpan.FLAG_EASY_CORRECT;
                    suggestionSpans[i].setFlags(flags);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mText instanceof Spannable) {
            //Spannable spannable = (Spannable) mText;
            //SuggestionSpan[] suggestionSpans = spannable.getSpans(0,
                    //spannable.length(), SuggestionSpan.class);
            //for (int i = 0; i < suggestionSpans.length; i++) {
                //int flags = suggestionSpans[i].getFlags();
                //if ((flags & SuggestionSpan.FLAG_EASY_CORRECT) != 0
                        //&& (flags & SuggestionSpan.FLAG_MISSPELLED) == 0) {
                    //flags &= ~SuggestionSpan.FLAG_EASY_CORRECT;
                    //suggestionSpans[i].setFlags(flags);
                //}
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.660 -0400", hash_original_method = "F41FEEC7411770322E4286C20722D03F", hash_generated_method = "16635B8BB7E084CD61D3D7505A7C2007")
    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        if(mMovement != null && mText instanceof Spannable && mLayout != null)        
        {
            try 
            {
                if(mMovement.onGenericMotionEvent(this, (Spannable) mText, event))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_181938900 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_815890672 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_815890672;
                } //End block
            } //End block
            catch (AbstractMethodError ex)
            {
            } //End block
        } //End block
        boolean var3B54C423A43BA14BBEA440506237FA4B_406362152 = (super.onGenericMotionEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_599906409 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_599906409;
        // ---------- Original Method ----------
        //if (mMovement != null && mText instanceof Spannable && mLayout != null) {
            //try {
                //if (mMovement.onGenericMotionEvent(this, (Spannable) mText, event)) {
                    //return true;
                //}
            //} catch (AbstractMethodError ex) {
            //}
        //}
        //return super.onGenericMotionEvent(event);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.660 -0400", hash_original_method = "1022846F3BD24E55F7B42FF144EBDE9C", hash_generated_method = "58D417F2B7862E313B978068611F4AF2")
    private void prepareCursorControllers() {
        boolean windowSupportsHandles = false;
        ViewGroup.LayoutParams params = getRootView().getLayoutParams();
        if(params instanceof WindowManager.LayoutParams)        
        {
            WindowManager.LayoutParams windowParams = (WindowManager.LayoutParams) params;
            windowSupportsHandles = windowParams.type < WindowManager.LayoutParams.FIRST_SUB_WINDOW
                    || windowParams.type > WindowManager.LayoutParams.LAST_SUB_WINDOW;
        } //End block
        mInsertionControllerEnabled = windowSupportsHandles && isCursorVisible() && mLayout != null;
        mSelectionControllerEnabled = windowSupportsHandles && textCanBeSelected() &&
                mLayout != null;
        if(!mInsertionControllerEnabled)        
        {
            hideInsertionPointCursorController();
            if(mInsertionPointCursorController != null)            
            {
                mInsertionPointCursorController.onDetached();
                mInsertionPointCursorController = null;
            } //End block
        } //End block
        if(!mSelectionControllerEnabled)        
        {
            stopSelectionActionMode();
            if(mSelectionModifierCursorController != null)            
            {
                mSelectionModifierCursorController.onDetached();
                mSelectionModifierCursorController = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.661 -0400", hash_original_method = "5768F33DD15C2D6A1E8DF566C117D02C", hash_generated_method = "7BFFC5981EF0B493FFD445D8BD16CF42")
    private boolean isTextEditable() {
        boolean var1DA39004BEBD31844052BBF28D344027_663940673 = (mText instanceof Editable && onCheckIsTextEditor() && isEnabled());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1884285343 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1884285343;
        // ---------- Original Method ----------
        //return mText instanceof Editable && onCheckIsTextEditor() && isEnabled();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.661 -0400", hash_original_method = "319EEEA24E78F0A8A97E7B3282410D43", hash_generated_method = "96C74EB3B0687A0C5691BFAB955DF4D1")
    public boolean didTouchFocusSelect() {
        boolean var787798533AEEA2731C814CD84D55595F_166309864 = (mTouchFocusSelected);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_599187103 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_599187103;
        // ---------- Original Method ----------
        //return mTouchFocusSelected;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.661 -0400", hash_original_method = "F8EF60C67754333637E515F4BC0EB2C7", hash_generated_method = "3F8E08FFCA833AB1C4B66C0BC80B43D3")
    @Override
    public void cancelLongPress() {
        super.cancelLongPress();
        mIgnoreActionUpEvent = true;
        // ---------- Original Method ----------
        //super.cancelLongPress();
        //mIgnoreActionUpEvent = true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.661 -0400", hash_original_method = "1EBA305C38503D593DE5ED34528F31AE", hash_generated_method = "52EA6A7467C93F4F5013BE5413E5D7F8")
    public boolean shouldIgnoreActionUpEvent() {
        boolean var0316722873C6AEF9554FE513EEA60308_1670618240 = (mIgnoreActionUpEvent);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_15588496 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_15588496;
        // ---------- Original Method ----------
        //return mIgnoreActionUpEvent;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.661 -0400", hash_original_method = "2ED59B8CED9712CD9EFEA3386ABFE955", hash_generated_method = "3874B54F3170350A5EBAABCFCA54161C")
    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        if(mMovement != null && mText instanceof Spannable &&
            mLayout != null)        
        {
            if(mMovement.onTrackballEvent(this, (Spannable) mText, event))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1837400315 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1054674008 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1054674008;
            } //End block
        } //End block
        boolean varBF585A2510916F6245CF607EE867BAC0_296630455 = (super.onTrackballEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1881557745 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1881557745;
        // ---------- Original Method ----------
        //if (mMovement != null && mText instanceof Spannable &&
            //mLayout != null) {
            //if (mMovement.onTrackballEvent(this, (Spannable) mText, event)) {
                //return true;
            //}
        //}
        //return super.onTrackballEvent(event);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.661 -0400", hash_original_method = "9E4C5FDADE7CEAD68CF365879A643A39", hash_generated_method = "6C45AED54B369950A87890A84980C656")
    public void setScroller(Scroller s) {
        mScroller = s;
        // ---------- Original Method ----------
        //mScroller = s;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.662 -0400", hash_original_method = "D90D14C34AE2DD19EDEA4AA99DD580AF", hash_generated_method = "73DBD68FEBC498DC1696AE3D58A99A4D")
    private boolean shouldBlink() {
        if(!isFocused())        
        {
        boolean var68934A3E9455FA72420237EB05902327_852720838 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_730169152 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_730169152;
        }
        final int start = getSelectionStart();
        if(start < 0)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1149495446 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_551369681 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_551369681;
        }
        final int end = getSelectionEnd();
        if(end < 0)        
        {
        boolean var68934A3E9455FA72420237EB05902327_437730205 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1807348969 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1807348969;
        }
        boolean var222DEADB8BDAC42EE4C3A09EDCE51232_175601727 = (start == end);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_974525254 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_974525254;
        // ---------- Original Method ----------
        //if (!isFocused()) return false;
        //final int start = getSelectionStart();
        //if (start < 0) return false;
        //final int end = getSelectionEnd();
        //if (end < 0) return false;
        //return start == end;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.663 -0400", hash_original_method = "D1BDF909CEA832525561C896748DB631", hash_generated_method = "C0FB72291D3BFFDF401251B21DF03CA5")
    private void makeBlink() {
        if(isCursorVisible())        
        {
            if(shouldBlink())            
            {
                mShowCursor = SystemClock.uptimeMillis();
                if(mBlink == null)                
                mBlink = new Blink(this);
                mBlink.removeCallbacks(mBlink);
                mBlink.postAtTime(mBlink, mShowCursor + BLINK);
            } //End block
        } //End block
        else
        {
            if(mBlink != null)            
            mBlink.removeCallbacks(mBlink);
        } //End block
        // ---------- Original Method ----------
        //if (isCursorVisible()) {
            //if (shouldBlink()) {
                //mShowCursor = SystemClock.uptimeMillis();
                //if (mBlink == null) mBlink = new Blink(this);
                //mBlink.removeCallbacks(mBlink);
                //mBlink.postAtTime(mBlink, mShowCursor + BLINK);
            //}
        //} else {
            //if (mBlink != null) mBlink.removeCallbacks(mBlink);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.663 -0400", hash_original_method = "2371CC9F994A54DD5E29CBD2552784AA", hash_generated_method = "77041E2EB03424F3F3FCF1255903BFF4")
    @Override
    protected float getLeftFadingEdgeStrength() {
        if(mCurrentAlpha <= ViewConfiguration.ALPHA_THRESHOLD_INT)        
        {
        float var2C64466C1DFC5FC617E8E7707C276CC3_1981072453 = (0.0f);
                float var546ADE640B6EDFBC8A086EF31347E768_997847937 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_997847937;
        }
        if(mEllipsize == TextUtils.TruncateAt.MARQUEE &&
                mMarqueeFadeMode != MARQUEE_FADE_SWITCH_SHOW_ELLIPSIS)        
        {
            if(mMarquee != null && !mMarquee.isStopped())            
            {
                final Marquee marquee = mMarquee;
                if(marquee.shouldDrawLeftFade())                
                {
                    float varB7CEC275E19042F45EB4CE3B5EBC2895_1570371057 = (marquee.mScroll / getHorizontalFadingEdgeLength());
                                        float var546ADE640B6EDFBC8A086EF31347E768_1457377720 = getTaintFloat();
                    return var546ADE640B6EDFBC8A086EF31347E768_1457377720;
                } //End block
                else
                {
                    float var2C64466C1DFC5FC617E8E7707C276CC3_1909925271 = (0.0f);
                                        float var546ADE640B6EDFBC8A086EF31347E768_148572448 = getTaintFloat();
                    return var546ADE640B6EDFBC8A086EF31347E768_148572448;
                } //End block
            } //End block
            else
            if(getLineCount() == 1)            
            {
                final int layoutDirection = getResolvedLayoutDirection();
                final int absoluteGravity = Gravity.getAbsoluteGravity(mGravity, layoutDirection);
switch(absoluteGravity & Gravity.HORIZONTAL_GRAVITY_MASK){
                case Gravity.LEFT:
                float var2C64466C1DFC5FC617E8E7707C276CC3_703307118 = (0.0f);
                                float var546ADE640B6EDFBC8A086EF31347E768_1747983935 = getTaintFloat();
                return var546ADE640B6EDFBC8A086EF31347E768_1747983935;
                case Gravity.RIGHT:
                float var4900188476884F6BD9F9281923AE03A5_1968934361 = ((mLayout.getLineRight(0) - (mRight - mLeft) -
                                getCompoundPaddingLeft() - getCompoundPaddingRight() -
                                mLayout.getLineLeft(0)) / getHorizontalFadingEdgeLength());
                                float var546ADE640B6EDFBC8A086EF31347E768_28586031 = getTaintFloat();
                return var546ADE640B6EDFBC8A086EF31347E768_28586031;
                case Gravity.CENTER_HORIZONTAL:
                float var2C64466C1DFC5FC617E8E7707C276CC3_1294313772 = (0.0f);
                                float var546ADE640B6EDFBC8A086EF31347E768_1188776707 = getTaintFloat();
                return var546ADE640B6EDFBC8A086EF31347E768_1188776707;
}
            } //End block
        } //End block
        float var656296804D1FEBE036FA85AE26EFF395_2038037467 = (super.getLeftFadingEdgeStrength());
                float var546ADE640B6EDFBC8A086EF31347E768_1073137177 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1073137177;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.664 -0400", hash_original_method = "7D05EA9E8579412E6DC4A8392EC7FDC2", hash_generated_method = "2111DA3608DA3C10013115ED7A933741")
    @Override
    protected float getRightFadingEdgeStrength() {
        if(mCurrentAlpha <= ViewConfiguration.ALPHA_THRESHOLD_INT)        
        {
        float var2C64466C1DFC5FC617E8E7707C276CC3_1450295907 = (0.0f);
                float var546ADE640B6EDFBC8A086EF31347E768_325344237 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_325344237;
        }
        if(mEllipsize == TextUtils.TruncateAt.MARQUEE &&
                mMarqueeFadeMode != MARQUEE_FADE_SWITCH_SHOW_ELLIPSIS)        
        {
            if(mMarquee != null && !mMarquee.isStopped())            
            {
                final Marquee marquee = mMarquee;
                float varC2A174B24685AA86D1F5B92AA3E624D9_1759667668 = ((marquee.mMaxFadeScroll - marquee.mScroll) / getHorizontalFadingEdgeLength());
                                float var546ADE640B6EDFBC8A086EF31347E768_1162550707 = getTaintFloat();
                return var546ADE640B6EDFBC8A086EF31347E768_1162550707;
            } //End block
            else
            if(getLineCount() == 1)            
            {
                final int layoutDirection = getResolvedLayoutDirection();
                final int absoluteGravity = Gravity.getAbsoluteGravity(mGravity, layoutDirection);
switch(absoluteGravity & Gravity.HORIZONTAL_GRAVITY_MASK){
                case Gravity.LEFT:
                final int textWidth = (mRight - mLeft) - getCompoundPaddingLeft() -
                                getCompoundPaddingRight();
                final float lineWidth = mLayout.getLineWidth(0);
                float varC76C65F332AD2403F208B807AFE7C315_332525936 = ((lineWidth - textWidth) / getHorizontalFadingEdgeLength());
                                float var546ADE640B6EDFBC8A086EF31347E768_830592372 = getTaintFloat();
                return var546ADE640B6EDFBC8A086EF31347E768_830592372;
                case Gravity.RIGHT:
                float var2C64466C1DFC5FC617E8E7707C276CC3_1948774907 = (0.0f);
                                float var546ADE640B6EDFBC8A086EF31347E768_770756539 = getTaintFloat();
                return var546ADE640B6EDFBC8A086EF31347E768_770756539;
                case Gravity.CENTER_HORIZONTAL:
                case Gravity.FILL_HORIZONTAL:
                float var5F6801A238728EC5B53A53F2B1BABCF0_643046797 = ((mLayout.getLineWidth(0) - ((mRight - mLeft) -
                                getCompoundPaddingLeft() - getCompoundPaddingRight())) /
                                getHorizontalFadingEdgeLength());
                                float var546ADE640B6EDFBC8A086EF31347E768_1127387111 = getTaintFloat();
                return var546ADE640B6EDFBC8A086EF31347E768_1127387111;
}
            } //End block
        } //End block
        float var5B034F60A655E2971E94266347AC03D1_257006822 = (super.getRightFadingEdgeStrength());
                float var546ADE640B6EDFBC8A086EF31347E768_1600535614 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1600535614;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.664 -0400", hash_original_method = "A3B3BBCD8F5911495212C23A0CDB87AF", hash_generated_method = "F5A98A1820FF62E92B6FA968EB8B679B")
    @Override
    protected int computeHorizontalScrollRange() {
        if(mLayout != null)        
        {
            int varD6D4C258B402719F9621942ECC7F3A6F_92098353 = (mSingleLine && (mGravity & Gravity.HORIZONTAL_GRAVITY_MASK) == Gravity.LEFT ?
                    (int) mLayout.getLineWidth(0) : mLayout.getWidth());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1187142520 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1187142520;
        } //End block
        int var588D87D8840B05AC8F37F1AFCF12E8E8_771659358 = (super.computeHorizontalScrollRange());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_106252590 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_106252590;
        // ---------- Original Method ----------
        //if (mLayout != null) {
            //return mSingleLine && (mGravity & Gravity.HORIZONTAL_GRAVITY_MASK) == Gravity.LEFT ?
                    //(int) mLayout.getLineWidth(0) : mLayout.getWidth();
        //}
        //return super.computeHorizontalScrollRange();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.664 -0400", hash_original_method = "FD0A725F27B0D409B10AFF4BD8232C49", hash_generated_method = "BABF2636F2567845068EA859118B32A5")
    @Override
    protected int computeVerticalScrollRange() {
        if(mLayout != null)        
        {
        int var96A8A47E5E396A87C0E4F2FC512D444E_1531577216 = (mLayout.getHeight());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1649937221 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1649937221;
        }
        int varB912B989DCF86BBB2F5B092C4603541E_767096726 = (super.computeVerticalScrollRange());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_503638936 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_503638936;
        // ---------- Original Method ----------
        //if (mLayout != null)
            //return mLayout.getHeight();
        //return super.computeVerticalScrollRange();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.664 -0400", hash_original_method = "9A16EAE7151454D3FA35454A6C3BB413", hash_generated_method = "58A4029A7875314C524B9C08A12F0172")
    @Override
    protected int computeVerticalScrollExtent() {
        int varE8CABC82DF6C575BCC9A0D48328FD674_395372181 = (getHeight() - getCompoundPaddingTop() - getCompoundPaddingBottom());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1694441996 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1694441996;
        // ---------- Original Method ----------
        //return getHeight() - getCompoundPaddingTop() - getCompoundPaddingBottom();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.664 -0400", hash_original_method = "AF6DED1CDDAE4FEC9AD8DCCD50DF8C26", hash_generated_method = "3D24090BE30EC1DFF40E94554DCB340E")
    @Override
    public void findViewsWithText(ArrayList<View> outViews, CharSequence searched, int flags) {
        addTaint(flags);
        addTaint(searched.getTaint());
        addTaint(outViews.getTaint());
        super.findViewsWithText(outViews, searched, flags);
        if(!outViews.contains(this) && (flags & FIND_VIEWS_WITH_TEXT) != 0
                && !TextUtils.isEmpty(searched) && !TextUtils.isEmpty(mText))        
        {
            String searchedLowerCase = searched.toString().toLowerCase();
            String textLowerCase = mText.toString().toLowerCase();
            if(textLowerCase.contains(searchedLowerCase))            
            {
                outViews.add(this);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //super.findViewsWithText(outViews, searched, flags);
        //if (!outViews.contains(this) && (flags & FIND_VIEWS_WITH_TEXT) != 0
                //&& !TextUtils.isEmpty(searched) && !TextUtils.isEmpty(mText)) {
            //String searchedLowerCase = searched.toString().toLowerCase();
            //String textLowerCase = mText.toString().toLowerCase();
            //if (textLowerCase.contains(searchedLowerCase)) {
                //outViews.add(this);
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    public static ColorStateList getTextColors(Context context, TypedArray attrs) {
        ColorStateList colors;
        colors = attrs.getColorStateList(com.android.internal.R.styleable.
                                         TextView_textColor);
        if (colors == null) {
            int ap = attrs.getResourceId(com.android.internal.R.styleable.
                                         TextView_textAppearance, -1);
            if (ap != -1) {
                TypedArray appearance;
                appearance = context.obtainStyledAttributes(ap,
                                            com.android.internal.R.styleable.TextAppearance);
                colors = appearance.getColorStateList(com.android.internal.R.styleable.
                                                  TextAppearance_textColor);
                appearance.recycle();
            }
        }
        return colors;
    }

    
    @DSModeled(DSC.SAFE)
    public static int getTextColor(Context context,
                                   TypedArray attrs,
                                   int def) {
        ColorStateList colors = getTextColors(context, attrs);
        if (colors == null) {
            return def;
        } else {
            return colors.getDefaultColor();
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.665 -0400", hash_original_method = "9DEDF12E7A1F2B52484CF7C1E98D635C", hash_generated_method = "16476A634FC8690F2CEACEDD3B8A6B67")
    @Override
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        final int filteredMetaState = event.getMetaState() & ~KeyEvent.META_CTRL_MASK;
        if(KeyEvent.metaStateHasNoModifiers(filteredMetaState))        
        {
switch(keyCode){
            case KeyEvent.KEYCODE_A:
            if(canSelectText())            
            {
                boolean varC424B4CC6B610A3480ECF1DA3A33D6E2_30677528 = (onTextContextMenuItem(ID_SELECT_ALL));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1636660890 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1636660890;
            } //End block
            break;
            case KeyEvent.KEYCODE_X:
            if(canCut())            
            {
                boolean varB777E2D5DC24BD466F46D803D2D7F723_141355694 = (onTextContextMenuItem(ID_CUT));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1526756220 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1526756220;
            } //End block
            break;
            case KeyEvent.KEYCODE_C:
            if(canCopy())            
            {
                boolean varA6CCFD8ADAAA28708EE64FD31B89A510_4181452 = (onTextContextMenuItem(ID_COPY));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1401658245 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1401658245;
            } //End block
            break;
            case KeyEvent.KEYCODE_V:
            if(canPaste())            
            {
                boolean var766F6757AF8D62CC932BCEE48C7DFCD7_943889099 = (onTextContextMenuItem(ID_PASTE));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1487932984 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1487932984;
            } //End block
            break;
}
        } //End block
        boolean var972F0D9AB75E5DBEC4E94C3528F5BBC3_847095745 = (super.onKeyShortcut(keyCode, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1474647707 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1474647707;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.665 -0400", hash_original_method = "CD8FD18ADF4940449D6A099035EC8FE9", hash_generated_method = "9BE1C527362EC9F02FBE8FC510D34C3D")
    private boolean canSelectText() {
        boolean var965AD182C8E2DFB09D3E2EC94E915F35_301652273 = (hasSelectionController() && mText.length() != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_704920235 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_704920235;
        // ---------- Original Method ----------
        //return hasSelectionController() && mText.length() != 0;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.665 -0400", hash_original_method = "09898B129565A0932D7F5D96EEC9BB39", hash_generated_method = "E2A917D90CB2633477BB8CC36643B4E3")
    private boolean textCanBeSelected() {
        if(mMovement == null || !mMovement.canSelectArbitrarily())        
        {
        boolean var68934A3E9455FA72420237EB05902327_837392969 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1502307660 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1502307660;
        }
        boolean var5765C7F25EE5D9614DB25705BD1EB5C4_33244745 = (isTextEditable() || (mTextIsSelectable && mText instanceof Spannable && isEnabled()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1556473202 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1556473202;
        // ---------- Original Method ----------
        //if (mMovement == null || !mMovement.canSelectArbitrarily()) return false;
        //return isTextEditable() || (mTextIsSelectable && mText instanceof Spannable && isEnabled());
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.666 -0400", hash_original_method = "5A8A75E52337470DA5834210CD94E844", hash_generated_method = "A093752EAB7C4D0304E2020F6902ABFC")
    private boolean canCut() {
        if(hasPasswordTransformationMethod())        
        {
            boolean var68934A3E9455FA72420237EB05902327_499536996 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1749735268 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1749735268;
        } //End block
        if(mText.length() > 0 && hasSelection() && mText instanceof Editable && mInput != null)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1878161303 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1828113094 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1828113094;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_529332779 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2074490054 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2074490054;
        // ---------- Original Method ----------
        //if (hasPasswordTransformationMethod()) {
            //return false;
        //}
        //if (mText.length() > 0 && hasSelection() && mText instanceof Editable && mInput != null) {
            //return true;
        //}
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.666 -0400", hash_original_method = "C5BA619EC7C225A5F87BCD822F6EF570", hash_generated_method = "4CF1879E00ABF1300C8B45F4AD88609F")
    private boolean canCopy() {
        if(hasPasswordTransformationMethod())        
        {
            boolean var68934A3E9455FA72420237EB05902327_877338792 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1781529774 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1781529774;
        } //End block
        if(mText.length() > 0 && hasSelection())        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1675176645 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_240731979 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_240731979;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_873925683 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_214427808 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_214427808;
        // ---------- Original Method ----------
        //if (hasPasswordTransformationMethod()) {
            //return false;
        //}
        //if (mText.length() > 0 && hasSelection()) {
            //return true;
        //}
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.666 -0400", hash_original_method = "4C1E94F781705995B290C548A8DF616E", hash_generated_method = "1A9404D7141C8EA1F738D9668A9389AD")
    private boolean canPaste() {
        boolean var7054747C87415379A02A90ED0D261990_1339759724 = ((mText instanceof Editable &&
                mInput != null &&
                getSelectionStart() >= 0 &&
                getSelectionEnd() >= 0 &&
                ((ClipboardManager)getContext().getSystemService(Context.CLIPBOARD_SERVICE)).
                hasPrimaryClip()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_778302899 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_778302899;
        // ---------- Original Method ----------
        //return (mText instanceof Editable &&
                //mInput != null &&
                //getSelectionStart() >= 0 &&
                //getSelectionEnd() >= 0 &&
                //((ClipboardManager)getContext().getSystemService(Context.CLIPBOARD_SERVICE)).
                //hasPrimaryClip());
    }

    
    @DSModeled(DSC.BAN)
    private static long packRangeInLong(int start, int end) {
        return (((long) start) << 32) | end;
    }

    
    @DSModeled(DSC.BAN)
    private static int extractRangeStartFromLong(long range) {
        return (int) (range >>> 32);
    }

    
    @DSModeled(DSC.BAN)
    private static int extractRangeEndFromLong(long range) {
        return (int) (range & 0x00000000FFFFFFFFL);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.667 -0400", hash_original_method = "493FC66F8A7ACF6A75CECBBBC666AB3C", hash_generated_method = "478C5F7DE3A40F620C84F51A589B72BD")
    private boolean selectAll() {
        final int length = mText.length();
        Selection.setSelection((Spannable) mText, 0, length);
        boolean varA78DB9499094537785DC0F6EC2D7D7D6_453579500 = (length > 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_521012540 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_521012540;
        // ---------- Original Method ----------
        //final int length = mText.length();
        //Selection.setSelection((Spannable) mText, 0, length);
        //return length > 0;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.668 -0400", hash_original_method = "B770D2F4FC63A979B3CD07A81B20384D", hash_generated_method = "3F72E413B915D0F7EF6A1476F56C6F40")
    private boolean selectCurrentWord() {
        if(!canSelectText())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1134657013 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_382941468 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_382941468;
        } //End block
        if(hasPasswordTransformationMethod())        
        {
            boolean var47229E5ED796FB9B2AB4B23D6BE85460_114259663 = (selectAll());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_954981731 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_954981731;
        } //End block
        int klass = mInputType & InputType.TYPE_MASK_CLASS;
        int variation = mInputType & InputType.TYPE_MASK_VARIATION;
        if(klass == InputType.TYPE_CLASS_NUMBER ||
                klass == InputType.TYPE_CLASS_PHONE ||
                klass == InputType.TYPE_CLASS_DATETIME ||
                variation == InputType.TYPE_TEXT_VARIATION_URI ||
                variation == InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS ||
                variation == InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS ||
                variation == InputType.TYPE_TEXT_VARIATION_FILTER)        
        {
            boolean var47229E5ED796FB9B2AB4B23D6BE85460_672506210 = (selectAll());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1593574895 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1593574895;
        } //End block
        long lastTouchOffsets = getLastTouchOffsets();
        final int minOffset = extractRangeStartFromLong(lastTouchOffsets);
        final int maxOffset = extractRangeEndFromLong(lastTouchOffsets);
        if(minOffset < 0 || minOffset >= mText.length())        
        {
        boolean var68934A3E9455FA72420237EB05902327_2048691605 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2023558906 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2023558906;
        }
        if(maxOffset < 0 || maxOffset >= mText.length())        
        {
        boolean var68934A3E9455FA72420237EB05902327_1353668353 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_600276581 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_600276581;
        }
        int selectionStart;
        int selectionEnd;
        URLSpan[] urlSpans = ((Spanned) mText).getSpans(minOffset, maxOffset, URLSpan.class);
        if(urlSpans.length >= 1)        
        {
            URLSpan urlSpan = urlSpans[0];
            selectionStart = ((Spanned) mText).getSpanStart(urlSpan);
            selectionEnd = ((Spanned) mText).getSpanEnd(urlSpan);
        } //End block
        else
        {
            final WordIterator wordIterator = getWordIterator();
            wordIterator.setCharSequence(mText, minOffset, maxOffset);
            selectionStart = wordIterator.getBeginning(minOffset);
            if(selectionStart == BreakIterator.DONE)            
            {
            boolean var68934A3E9455FA72420237EB05902327_2145021935 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1938490175 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1938490175;
            }
            selectionEnd = wordIterator.getEnd(maxOffset);
            if(selectionEnd == BreakIterator.DONE)            
            {
            boolean var68934A3E9455FA72420237EB05902327_86971841 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_925061782 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_925061782;
            }
            if(selectionStart == selectionEnd)            
            {
                long range = getCharRange(selectionStart);
                selectionStart = extractRangeStartFromLong(range);
                selectionEnd = extractRangeEndFromLong(range);
            } //End block
        } //End block
        Selection.setSelection((Spannable) mText, selectionStart, selectionEnd);
        boolean var22A3C57A75203A63822C0946217EBBE5_991940107 = (selectionEnd > selectionStart);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_114784456 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_114784456;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.669 -0400", hash_original_method = "9DCEB61D4BC0794F06560CB12151C0AA", hash_generated_method = "713CF7BF141B2406781241736D9304C7")
    public Locale getTextServicesLocale() {
        Locale locale = Locale.getDefault();
        final TextServicesManager textServicesManager = (TextServicesManager)
                mContext.getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE);
        final SpellCheckerSubtype subtype = textServicesManager.getCurrentSpellCheckerSubtype(true);
        if(subtype != null)        
        {
            locale = new Locale(subtype.getLocale());
        } //End block
Locale varB14E682FEAD06D8198D8ADBCBD62DEDB_1232788908 =         locale;
        varB14E682FEAD06D8198D8ADBCBD62DEDB_1232788908.addTaint(taint);
        return varB14E682FEAD06D8198D8ADBCBD62DEDB_1232788908;
        // ---------- Original Method ----------
        //Locale locale = Locale.getDefault();
        //final TextServicesManager textServicesManager = (TextServicesManager)
                //mContext.getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE);
        //final SpellCheckerSubtype subtype = textServicesManager.getCurrentSpellCheckerSubtype(true);
        //if (subtype != null) {
            //locale = new Locale(subtype.getLocale());
        //}
        //return locale;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.669 -0400", hash_original_method = "84E4450A5BCA42ECDB6E0E833B2BF3C6", hash_generated_method = "00A6EC577A937BD6BC25376AD1589672")
     void onLocaleChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mWordIterator = null;
        // ---------- Original Method ----------
        //mWordIterator = null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.669 -0400", hash_original_method = "D7DB0153FBA43371270FE2DB428D268F", hash_generated_method = "C679B1A99E03CDF1A9529D67A01953FC")
    public WordIterator getWordIterator() {
        if(mWordIterator == null)        
        {
            mWordIterator = new WordIterator(getTextServicesLocale());
        } //End block
WordIterator var37D1F93E48443AE4D55CF6AA761B0227_968511517 =         mWordIterator;
        var37D1F93E48443AE4D55CF6AA761B0227_968511517.addTaint(taint);
        return var37D1F93E48443AE4D55CF6AA761B0227_968511517;
        // ---------- Original Method ----------
        //if (mWordIterator == null) {
            //mWordIterator = new WordIterator(getTextServicesLocale());
        //}
        //return mWordIterator;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.670 -0400", hash_original_method = "B4D83E103073E3F8ED3897EF06B95E07", hash_generated_method = "3BDD394DB0B73B9808BAD610FF6E0A49")
    private long getCharRange(int offset) {
        addTaint(offset);
        final int textLength = mText.length();
        if(offset + 1 < textLength)        
        {
            final char currentChar = mText.charAt(offset);
            final char nextChar = mText.charAt(offset + 1);
            if(Character.isSurrogatePair(currentChar, nextChar))            
            {
                long var25DF1EC715CE278D3A235EB87E92BB61_1277971101 = (packRangeInLong(offset,  offset + 2));
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1894588961 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1894588961;
            } //End block
        } //End block
        if(offset < textLength)        
        {
            long varC061A605E7DCDA3DAD1CA6F4E692DFF6_1679763312 = (packRangeInLong(offset,  offset + 1));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1357704396 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1357704396;
        } //End block
        if(offset - 2 >= 0)        
        {
            final char previousChar = mText.charAt(offset - 1);
            final char previousPreviousChar = mText.charAt(offset - 2);
            if(Character.isSurrogatePair(previousPreviousChar, previousChar))            
            {
                long var4234D8260190FD81A09D297A64896614_1171704900 = (packRangeInLong(offset - 2,  offset));
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1045653974 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1045653974;
            } //End block
        } //End block
        if(offset - 1 >= 0)        
        {
            long varA676A7F5337103688B3E29B297964F17_1653017214 = (packRangeInLong(offset - 1,  offset));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1725218087 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1725218087;
        } //End block
        long varD3183C4F9A5DDC4956C94E6FBD5AB061_1733134703 = (packRangeInLong(offset,  offset));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1819053283 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1819053283;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.670 -0400", hash_original_method = "C07E078EE2A4D1805F6BF366C72ED78F", hash_generated_method = "B522FB882A8CCC907529096C200DCFCC")
    private long getLastTouchOffsets() {
        SelectionModifierCursorController selectionController = getSelectionController();
        final int minOffset = selectionController.getMinTouchOffset();
        final int maxOffset = selectionController.getMaxTouchOffset();
        long var2D5B396FB450C81EBB0546C2AD234935_1437729345 = (packRangeInLong(minOffset, maxOffset));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1638773398 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1638773398;
        // ---------- Original Method ----------
        //SelectionModifierCursorController selectionController = getSelectionController();
        //final int minOffset = selectionController.getMinTouchOffset();
        //final int maxOffset = selectionController.getMaxTouchOffset();
        //return packRangeInLong(minOffset, maxOffset);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.684 -0400", hash_original_method = "A81C1729DD6237516D7BACF34829C51D", hash_generated_method = "9E84B4435F20AE22BD03BEC1C5A501D4")
    @Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        super.onPopulateAccessibilityEvent(event);
        final boolean isPassword = hasPasswordTransformationMethod();
        if(!isPassword)        
        {
            CharSequence text = getTextForAccessibility();
            if(!TextUtils.isEmpty(text))            
            {
                event.getText().add(text);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //super.onPopulateAccessibilityEvent(event);
        //final boolean isPassword = hasPasswordTransformationMethod();
        //if (!isPassword) {
            //CharSequence text = getTextForAccessibility();
            //if (!TextUtils.isEmpty(text)) {
                //event.getText().add(text);
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.685 -0400", hash_original_method = "6FC069A7F29DA435C1F4CA8AC1DF9A7A", hash_generated_method = "D80272F2933A93A69BE85B6432F900C5")
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        super.onInitializeAccessibilityEvent(event);
        final boolean isPassword = hasPasswordTransformationMethod();
        event.setPassword(isPassword);
        if(event.getEventType() == AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED)        
        {
            event.setFromIndex(Selection.getSelectionStart(mText));
            event.setToIndex(Selection.getSelectionEnd(mText));
            event.setItemCount(mText.length());
        } //End block
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityEvent(event);
        //final boolean isPassword = hasPasswordTransformationMethod();
        //event.setPassword(isPassword);
        //if (event.getEventType() == AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED) {
            //event.setFromIndex(Selection.getSelectionStart(mText));
            //event.setToIndex(Selection.getSelectionEnd(mText));
            //event.setItemCount(mText.length());
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.685 -0400", hash_original_method = "305122B0EBB45F51524377B6AB6D9296", hash_generated_method = "659E8E9EA71DA1943F2DDE1DDA0BF795")
    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(info.getTaint());
        super.onInitializeAccessibilityNodeInfo(info);
        final boolean isPassword = hasPasswordTransformationMethod();
        if(!isPassword)        
        {
            info.setText(getTextForAccessibility());
        } //End block
        info.setPassword(isPassword);
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityNodeInfo(info);
        //final boolean isPassword = hasPasswordTransformationMethod();
        //if (!isPassword) {
            //info.setText(getTextForAccessibility());
        //}
        //info.setPassword(isPassword);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.685 -0400", hash_original_method = "69E83CE4CD48DE4ECD21620922EFCC1A", hash_generated_method = "986F1D5E82DC5CBB81B2CD05543C4A68")
    @Override
    public void sendAccessibilityEvent(int eventType) {
        addTaint(eventType);
        if(eventType == AccessibilityEvent.TYPE_VIEW_SCROLLED)        
        {
            return;
        } //End block
        super.sendAccessibilityEvent(eventType);
        // ---------- Original Method ----------
        //if (eventType == AccessibilityEvent.TYPE_VIEW_SCROLLED) {
            //return;
        //}
        //super.sendAccessibilityEvent(eventType);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.685 -0400", hash_original_method = "8463B72D535FD98D84B93D99DA9D2B3A", hash_generated_method = "483BD5BDEE89F30552A5BDB93B2E0F70")
    private CharSequence getTextForAccessibility() {
        CharSequence text = getText();
        if(TextUtils.isEmpty(text))        
        {
            text = getHint();
        } //End block
CharSequence var79CC641C1148018540A26F7ADC424893_1939510612 =         text;
        var79CC641C1148018540A26F7ADC424893_1939510612.addTaint(taint);
        return var79CC641C1148018540A26F7ADC424893_1939510612;
        // ---------- Original Method ----------
        //CharSequence text = getText();
        //if (TextUtils.isEmpty(text)) {
            //text = getHint();
        //}
        //return text;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.685 -0400", hash_original_method = "77215EF020F664C77A4E0174E763346B", hash_generated_method = "59546D35CF8E8C0CB8B076ADE823F186")
     void sendAccessibilityEventTypeViewTextChanged(CharSequence beforeText,
            int fromIndex, int removedCount, int addedCount) {
        addTaint(addedCount);
        addTaint(removedCount);
        addTaint(fromIndex);
        addTaint(beforeText.getTaint());
        AccessibilityEvent event = AccessibilityEvent.obtain(AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED);
        event.setFromIndex(fromIndex);
        event.setRemovedCount(removedCount);
        event.setAddedCount(addedCount);
        event.setBeforeText(beforeText);
        sendAccessibilityEventUnchecked(event);
        // ---------- Original Method ----------
        //AccessibilityEvent event =
            //AccessibilityEvent.obtain(AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED);
        //event.setFromIndex(fromIndex);
        //event.setRemovedCount(removedCount);
        //event.setAddedCount(addedCount);
        //event.setBeforeText(beforeText);
        //sendAccessibilityEventUnchecked(event);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.685 -0400", hash_original_method = "10EC795892359880AFC1661A7060F8D4", hash_generated_method = "E3504A75C5DAE219F875866EE390F003")
    public boolean isInputMethodTarget() {
        InputMethodManager imm = InputMethodManager.peekInstance();
        boolean var1254C12810CE71859A8F8E2A3B038D7C_1177174730 = (imm != null && imm.isActive(this));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1177605030 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1177605030;
        // ---------- Original Method ----------
        //InputMethodManager imm = InputMethodManager.peekInstance();
        //return imm != null && imm.isActive(this);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.686 -0400", hash_original_method = "395A8406E426F55316A0BF37153197E7", hash_generated_method = "C9C91AC696DDF21F14DCBDD603348E14")
    public boolean onTextContextMenuItem(int id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(id);
        int min = 0;
        int max = mText.length();
        if(isFocused())        
        {
            final int selStart = getSelectionStart();
            final int selEnd = getSelectionEnd();
            min = Math.max(0, Math.min(selStart, selEnd));
            max = Math.max(0, Math.max(selStart, selEnd));
        } //End block
switch(id){
        case ID_SELECT_ALL:
        selectAll();
        boolean varB326B5062B2F0E69046810717534CB09_1018119380 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_37385480 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_37385480;
        case ID_PASTE:
        paste(min, max);
        boolean varB326B5062B2F0E69046810717534CB09_90181116 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1091487085 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1091487085;
        case ID_CUT:
        setPrimaryClip(ClipData.newPlainText(null, getTransformedText(min, max)));
        deleteText_internal(min, max);
        stopSelectionActionMode();
        boolean varB326B5062B2F0E69046810717534CB09_838808892 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1195663043 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1195663043;
        case ID_COPY:
        setPrimaryClip(ClipData.newPlainText(null, getTransformedText(min, max)));
        stopSelectionActionMode();
        boolean varB326B5062B2F0E69046810717534CB09_584243259 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1081432335 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1081432335;
}        boolean var68934A3E9455FA72420237EB05902327_1585500877 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1776606105 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1776606105;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.686 -0400", hash_original_method = "FE79E6B9FD3BC9A3AB2F6DF9CAFCD48E", hash_generated_method = "7172915D07530CBA37C749332956AD80")
    private CharSequence getTransformedText(int start, int end) {
        addTaint(end);
        addTaint(start);
CharSequence var1015F229E64D9657D6430E7291B4C60C_1735843929 =         removeSuggestionSpans(mTransformed.subSequence(start, end));
        var1015F229E64D9657D6430E7291B4C60C_1735843929.addTaint(taint);
        return var1015F229E64D9657D6430E7291B4C60C_1735843929;
        // ---------- Original Method ----------
        //return removeSuggestionSpans(mTransformed.subSequence(start, end));
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.686 -0400", hash_original_method = "6ABCBA1E552641094DE1B3327AD7FDD1", hash_generated_method = "BFFB139C808C36C7AF7FF5EAC327A007")
    private long prepareSpacesAroundPaste(int min, int max, CharSequence paste) {
        addTaint(paste.getTaint());
        addTaint(max);
        addTaint(min);
        if(paste.length() > 0)        
        {
            if(min > 0)            
            {
                final char charBefore = mTransformed.charAt(min - 1);
                final char charAfter = paste.charAt(0);
                if(Character.isSpaceChar(charBefore) && Character.isSpaceChar(charAfter))                
                {
                    final int originalLength = mText.length();
                    deleteText_internal(min - 1, min);
                    final int delta = mText.length() - originalLength;
                    min += delta;
                    max += delta;
                } //End block
                else
                if(!Character.isSpaceChar(charBefore) && charBefore != '\n' &&
                        !Character.isSpaceChar(charAfter) && charAfter != '\n')                
                {
                    final int originalLength = mText.length();
                    replaceText_internal(min, min, " ");
                    final int delta = mText.length() - originalLength;
                    min += delta;
                    max += delta;
                } //End block
            } //End block
            if(max < mText.length())            
            {
                final char charBefore = paste.charAt(paste.length() - 1);
                final char charAfter = mTransformed.charAt(max);
                if(Character.isSpaceChar(charBefore) && Character.isSpaceChar(charAfter))                
                {
                    deleteText_internal(max, max + 1);
                } //End block
                else
                if(!Character.isSpaceChar(charBefore) && charBefore != '\n' &&
                        !Character.isSpaceChar(charAfter) && charAfter != '\n')                
                {
                    replaceText_internal(max, max, " ");
                } //End block
            } //End block
        } //End block
        long var6CE6B10DC32DB0BA7B03FEA35E03D9EF_1542205780 = (packRangeInLong(min, max));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_969829383 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_969829383;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.688 -0400", hash_original_method = "E0F0E7304052F47B24D850362D52309F", hash_generated_method = "DC1A3D0747BB2619A4C6F15A482A48E5")
    private DragShadowBuilder getTextThumbnailBuilder(CharSequence text) {
        addTaint(text.getTaint());
        TextView shadowView = (TextView) inflate(mContext,
                com.android.internal.R.layout.text_drag_thumbnail, null);
        if(shadowView == null)        
        {
            IllegalArgumentException varF4891D4CDAB539B518D6CDA3710521E2_1837202469 = new IllegalArgumentException("Unable to inflate text drag thumbnail");
            varF4891D4CDAB539B518D6CDA3710521E2_1837202469.addTaint(taint);
            throw varF4891D4CDAB539B518D6CDA3710521E2_1837202469;
        } //End block
        if(text.length() > DRAG_SHADOW_MAX_TEXT_LENGTH)        
        {
            text = text.subSequence(0, DRAG_SHADOW_MAX_TEXT_LENGTH);
        } //End block
        shadowView.setText(text);
        shadowView.setTextColor(getTextColors());
        shadowView.setTextAppearance(mContext, R.styleable.Theme_textAppearanceLarge);
        shadowView.setGravity(Gravity.CENTER);
        shadowView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        final int size = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        shadowView.measure(size, size);
        shadowView.layout(0, 0, shadowView.getMeasuredWidth(), shadowView.getMeasuredHeight());
        shadowView.invalidate();
DragShadowBuilder var4F7A6E68FD53405D7B8BB6E7D426510C_1156022985 =         new DragShadowBuilder(shadowView);
        var4F7A6E68FD53405D7B8BB6E7D426510C_1156022985.addTaint(taint);
        return var4F7A6E68FD53405D7B8BB6E7D426510C_1156022985;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.688 -0400", hash_original_method = "FE9E03D9F3FD52DB88C5DE28D1E8768B", hash_generated_method = "DCC350EDDF3FF6FAB9F12E7C219B9DAB")
    @Override
    public boolean performLongClick() {
        boolean handled = false;
        boolean vibrate = true;
        if(super.performLongClick())        
        {
            mDiscardNextActionUp = true;
            handled = true;
        } //End block
        if(!handled && !isPositionOnText(mLastDownPositionX, mLastDownPositionY) &&
                mInsertionControllerEnabled)        
        {
            final int offset = getOffsetForPosition(mLastDownPositionX, mLastDownPositionY);
            stopSelectionActionMode();
            Selection.setSelection((Spannable) mText, offset);
            getInsertionController().showWithActionPopup();
            handled = true;
            vibrate = false;
        } //End block
        if(!handled && mSelectionActionMode != null)        
        {
            if(touchPositionIsInSelection())            
            {
                final int start = getSelectionStart();
                final int end = getSelectionEnd();
                CharSequence selectedText = getTransformedText(start, end);
                ClipData data = ClipData.newPlainText(null, selectedText);
                DragLocalState localState = new DragLocalState(this, start, end);
                startDrag(data, getTextThumbnailBuilder(selectedText), localState, 0);
                stopSelectionActionMode();
            } //End block
            else
            {
                getSelectionController().hide();
                selectCurrentWord();
                getSelectionController().show();
            } //End block
            handled = true;
        } //End block
        if(!handled)        
        {
            vibrate = handled = startSelectionActionMode();
        } //End block
        if(vibrate)        
        {
            performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
        } //End block
        if(handled)        
        {
            mDiscardNextActionUp = true;
        } //End block
        boolean var98F0599AF776A1FE4101C199A40EEB8F_1111398757 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_666594698 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_666594698;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.689 -0400", hash_original_method = "227669F89CB3324004EC787BF93F591D", hash_generated_method = "8599A3DBDD9A18ADD0F7AE2C22AAD1F9")
    private boolean touchPositionIsInSelection() {
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        if(selectionStart == selectionEnd)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1706821592 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1510608558 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1510608558;
        } //End block
        if(selectionStart > selectionEnd)        
        {
            int tmp = selectionStart;
            selectionStart = selectionEnd;
            selectionEnd = tmp;
            Selection.setSelection((Spannable) mText, selectionStart, selectionEnd);
        } //End block
        SelectionModifierCursorController selectionController = getSelectionController();
        int minOffset = selectionController.getMinTouchOffset();
        int maxOffset = selectionController.getMaxTouchOffset();
        boolean var56656AEB134BFDAFA8DA3A78CE12C1C5_1473128438 = (((minOffset >= selectionStart) && (maxOffset < selectionEnd)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_36663925 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_36663925;
        // ---------- Original Method ----------
        //int selectionStart = getSelectionStart();
        //int selectionEnd = getSelectionEnd();
        //if (selectionStart == selectionEnd) {
            //return false;
        //}
        //if (selectionStart > selectionEnd) {
            //int tmp = selectionStart;
            //selectionStart = selectionEnd;
            //selectionEnd = tmp;
            //Selection.setSelection((Spannable) mText, selectionStart, selectionEnd);
        //}
        //SelectionModifierCursorController selectionController = getSelectionController();
        //int minOffset = selectionController.getMinTouchOffset();
        //int maxOffset = selectionController.getMaxTouchOffset();
        //return ((minOffset >= selectionStart) && (maxOffset < selectionEnd));
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.689 -0400", hash_original_method = "A2BF41305999CD5C7E75DA3423749804", hash_generated_method = "F2556D5087D28C86D9DF155771DDCF86")
    private PositionListener getPositionListener() {
        if(mPositionListener == null)        
        {
            mPositionListener = new PositionListener();
        } //End block
PositionListener varDB0BCC9DD2631F356B89FED854D22F27_907740491 =         mPositionListener;
        varDB0BCC9DD2631F356B89FED854D22F27_907740491.addTaint(taint);
        return varDB0BCC9DD2631F356B89FED854D22F27_907740491;
        // ---------- Original Method ----------
        //if (mPositionListener == null) {
            //mPositionListener = new PositionListener();
        //}
        //return mPositionListener;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.690 -0400", hash_original_method = "23179C09AF51D00D4FCF53E6D8173595", hash_generated_method = "570F2383FD59FC373046E0F856F801D0")
    private boolean isPositionVisible(int positionX, int positionY) {
        addTaint(positionY);
        addTaint(positionX);
        synchronized
(sTmpPosition)        {
            final float[] position = sTmpPosition;
            position[0] = positionX;
            position[1] = positionY;
            View view = this;
            while
(view != null)            
            {
                if(view != this)                
                {
                    position[0] -= view.getScrollX();
                    position[1] -= view.getScrollY();
                } //End block
                if(position[0] < 0 || position[1] < 0 ||
                        position[0] > view.getWidth() || position[1] > view.getHeight())                
                {
                    boolean var68934A3E9455FA72420237EB05902327_268902978 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_835276732 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_835276732;
                } //End block
                if(!view.getMatrix().isIdentity())                
                {
                    view.getMatrix().mapPoints(position);
                } //End block
                position[0] += view.getLeft();
                position[1] += view.getTop();
                final ViewParent parent = view.getParent();
                if(parent instanceof View)                
                {
                    view = (View) parent;
                } //End block
                else
                {
                    view = null;
                } //End block
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1377537194 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2089722578 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2089722578;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.692 -0400", hash_original_method = "51F76D7934106C8713E6D720A3BD9BE7", hash_generated_method = "EA79336B9C698D08DB43B7EA1BB004D9")
    private boolean isOffsetVisible(int offset) {
        addTaint(offset);
        final int line = mLayout.getLineForOffset(offset);
        final int lineBottom = mLayout.getLineBottom(line);
        final int primaryHorizontal = (int) mLayout.getPrimaryHorizontal(offset);
        boolean var82AE3258F86E317BB1FD2C7F11B8E128_2075833255 = (isPositionVisible(primaryHorizontal + viewportToContentHorizontalOffset(),
                lineBottom + viewportToContentVerticalOffset()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_62734982 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_62734982;
        // ---------- Original Method ----------
        //final int line = mLayout.getLineForOffset(offset);
        //final int lineBottom = mLayout.getLineBottom(line);
        //final int primaryHorizontal = (int) mLayout.getPrimaryHorizontal(offset);
        //return isPositionVisible(primaryHorizontal + viewportToContentHorizontalOffset(),
                //lineBottom + viewportToContentVerticalOffset());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.693 -0400", hash_original_method = "8567BA4CA284138DD0CB4B48B9C8C278", hash_generated_method = "8008DCA5B61F2A874107858114C1019A")
    @Override
    protected void onScrollChanged(int horiz, int vert, int oldHoriz, int oldVert) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(oldVert);
        addTaint(oldHoriz);
        addTaint(vert);
        addTaint(horiz);
        super.onScrollChanged(horiz, vert, oldHoriz, oldVert);
        if(mPositionListener != null)        
        {
            mPositionListener.onScrollChanged();
        } //End block
        // ---------- Original Method ----------
        //super.onScrollChanged(horiz, vert, oldHoriz, oldVert);
        //if (mPositionListener != null) {
            //mPositionListener.onScrollChanged();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.693 -0400", hash_original_method = "9FAF02695A10AC660CF2B5DD3EDB7DD4", hash_generated_method = "682BE4902C1E0FAC923A60036E846B99")
     CharSequence removeSuggestionSpans(CharSequence text) {
        addTaint(text.getTaint());
        if(text instanceof Spanned)        
        {
            Spannable spannable;
            if(text instanceof Spannable)            
            {
                spannable = (Spannable) text;
            } //End block
            else
            {
                spannable = new SpannableString(text);
                text = spannable;
            } //End block
            SuggestionSpan[] spans = spannable.getSpans(0, text.length(), SuggestionSpan.class);
for(int i = 0;i < spans.length;i++)
            {
                spannable.removeSpan(spans[i]);
            } //End block
        } //End block
CharSequence var79CC641C1148018540A26F7ADC424893_965270101 =         text;
        var79CC641C1148018540A26F7ADC424893_965270101.addTaint(taint);
        return var79CC641C1148018540A26F7ADC424893_965270101;
        // ---------- Original Method ----------
        //if (text instanceof Spanned) {
           //Spannable spannable;
           //if (text instanceof Spannable) {
               //spannable = (Spannable) text;
           //} else {
               //spannable = new SpannableString(text);
               //text = spannable;
           //}
           //SuggestionSpan[] spans = spannable.getSpans(0, text.length(), SuggestionSpan.class);
           //for (int i = 0; i < spans.length; i++) {
               //spannable.removeSpan(spans[i]);
           //}
       //}
        //return text;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.693 -0400", hash_original_method = "97397C66433481C877E194A1E7813AF3", hash_generated_method = "21C5438CDE86065259A0341E46D6CB2D")
     void showSuggestions() {
        if(mSuggestionsPopupWindow == null)        
        {
            mSuggestionsPopupWindow = new SuggestionsPopupWindow();
        } //End block
        hideControllers();
        mSuggestionsPopupWindow.show();
        // ---------- Original Method ----------
        //if (mSuggestionsPopupWindow == null) {
            //mSuggestionsPopupWindow = new SuggestionsPopupWindow();
        //}
        //hideControllers();
        //mSuggestionsPopupWindow.show();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.694 -0400", hash_original_method = "E5A6F19BA20AF228602A3EAA320E6192", hash_generated_method = "D954984760E83CD5FCFAFD9C356FCF50")
     boolean areSuggestionsShown() {
        boolean var07ECD3F8BC3172AB1CC094253D70C216_1718412914 = (mSuggestionsPopupWindow != null && mSuggestionsPopupWindow.isShowing());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1888310972 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1888310972;
        // ---------- Original Method ----------
        //return mSuggestionsPopupWindow != null && mSuggestionsPopupWindow.isShowing();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.694 -0400", hash_original_method = "25A5AF708197CD0F2143471E812F624E", hash_generated_method = "F892CC1E40F982A691314E9410C04149")
    public boolean isSuggestionsEnabled() {
        if((mInputType & InputType.TYPE_MASK_CLASS) != InputType.TYPE_CLASS_TEXT)        
        {
        boolean var68934A3E9455FA72420237EB05902327_394380894 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_143804030 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_143804030;
        }
        if((mInputType & InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS) > 0)        
        {
        boolean var68934A3E9455FA72420237EB05902327_373757075 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1909874575 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1909874575;
        }
        final int variation = mInputType & EditorInfo.TYPE_MASK_VARIATION;
        boolean var1D335218EE3C0D5FA93FA1978B88F674_662644565 = ((variation == EditorInfo.TYPE_TEXT_VARIATION_NORMAL ||
                variation == EditorInfo.TYPE_TEXT_VARIATION_EMAIL_SUBJECT ||
                variation == EditorInfo.TYPE_TEXT_VARIATION_LONG_MESSAGE ||
                variation == EditorInfo.TYPE_TEXT_VARIATION_SHORT_MESSAGE ||
                variation == EditorInfo.TYPE_TEXT_VARIATION_WEB_EDIT_TEXT));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_181930604 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_181930604;
        // ---------- Original Method ----------
        //if ((mInputType & InputType.TYPE_MASK_CLASS) != InputType.TYPE_CLASS_TEXT) return false;
        //if ((mInputType & InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS) > 0) return false;
        //final int variation = mInputType & EditorInfo.TYPE_MASK_VARIATION;
        //return (variation == EditorInfo.TYPE_TEXT_VARIATION_NORMAL ||
                //variation == EditorInfo.TYPE_TEXT_VARIATION_EMAIL_SUBJECT ||
                //variation == EditorInfo.TYPE_TEXT_VARIATION_LONG_MESSAGE ||
                //variation == EditorInfo.TYPE_TEXT_VARIATION_SHORT_MESSAGE ||
                //variation == EditorInfo.TYPE_TEXT_VARIATION_WEB_EDIT_TEXT);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.695 -0400", hash_original_method = "9876FACCD4EAE43EA4CB6FD414FD5E5A", hash_generated_method = "99F50FF2FBA3328523C1FCF161298BA2")
    public void setCustomSelectionActionModeCallback(ActionMode.Callback actionModeCallback) {
        mCustomSelectionActionModeCallback = actionModeCallback;
        // ---------- Original Method ----------
        //mCustomSelectionActionModeCallback = actionModeCallback;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.695 -0400", hash_original_method = "6671930C0B8994CBEF8AFBE835B485C8", hash_generated_method = "242C322E978B37741B64DCC9BE4E0639")
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
ActionMode.Callback varF80B468851F6CE10F0DF08039A1C154E_1337412234 =         mCustomSelectionActionModeCallback;
        varF80B468851F6CE10F0DF08039A1C154E_1337412234.addTaint(taint);
        return varF80B468851F6CE10F0DF08039A1C154E_1337412234;
        // ---------- Original Method ----------
        //return mCustomSelectionActionModeCallback;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.695 -0400", hash_original_method = "B9B1CE7E81D0AD0E9224682576CA1ABE", hash_generated_method = "DCDB1865B434F1B57DDEA17139D8200F")
    private boolean startSelectionActionMode() {
        if(mSelectionActionMode != null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_563023155 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_716189033 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_716189033;
        } //End block
        if(!canSelectText() || !requestFocus())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1158777317 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_110237791 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_110237791;
        } //End block
        if(!hasSelection())        
        {
            if(!selectCurrentWord())            
            {
                boolean var68934A3E9455FA72420237EB05902327_796557892 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1628070774 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1628070774;
            } //End block
        } //End block
        boolean willExtract = extractedTextModeWillBeStarted();
        if(!willExtract)        
        {
            ActionMode.Callback actionModeCallback = new SelectionActionModeCallback();
            mSelectionActionMode = startActionMode(actionModeCallback);
        } //End block
        final boolean selectionStarted = mSelectionActionMode != null || willExtract;
        if(selectionStarted && !mTextIsSelectable && mSoftInputShownOnFocus)        
        {
            final InputMethodManager imm = InputMethodManager.peekInstance();
            if(imm != null)            
            {
                imm.showSoftInput(this, 0, null);
            } //End block
        } //End block
        boolean var0F1ADEB268AC9CD2C178AA2C2450144D_367776805 = (selectionStarted);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_400994882 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_400994882;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.696 -0400", hash_original_method = "F292596F6DB6F0A1BCB4946717902139", hash_generated_method = "59A9A1E892602D587D0B51A7C549B365")
    private boolean extractedTextModeWillBeStarted() {
        if(!(this instanceof ExtractEditText))        
        {
            final InputMethodManager imm = InputMethodManager.peekInstance();
            boolean varF9492330538B3514E04780F3BA09ADDA_1848639334 = (imm != null && imm.isFullscreenMode());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1552884969 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1552884969;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1951100609 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1447369856 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1447369856;
        // ---------- Original Method ----------
        //if (!(this instanceof ExtractEditText)) {
            //final InputMethodManager imm = InputMethodManager.peekInstance();
            //return  imm != null && imm.isFullscreenMode();
        //}
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.702 -0400", hash_original_method = "9843C3F333617B8C113B72E2C38319BA", hash_generated_method = "14470412519846BFD0D8192D8E8FF091")
    private void stopSelectionActionMode() {
        if(mSelectionActionMode != null)        
        {
            mSelectionActionMode.finish();
        } //End block
        // ---------- Original Method ----------
        //if (mSelectionActionMode != null) {
            //mSelectionActionMode.finish();
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.703 -0400", hash_original_method = "FD893A1B640E2E356DBE924FBE58EA4D", hash_generated_method = "359E3E6954B1CED10CF79B1546763DF5")
    private void paste(int min, int max) {
        addTaint(max);
        addTaint(min);
        ClipboardManager clipboard = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = clipboard.getPrimaryClip();
        if(clip != null)        
        {
            boolean didFirst = false;
for(int i=0;i<clip.getItemCount();i++)
            {
                CharSequence paste = clip.getItemAt(i).coerceToText(getContext());
                if(paste != null)                
                {
                    if(!didFirst)                    
                    {
                        long minMax = prepareSpacesAroundPaste(min, max, paste);
                        min = extractRangeStartFromLong(minMax);
                        max = extractRangeEndFromLong(minMax);
                        Selection.setSelection((Spannable) mText, max);
                        ((Editable) mText).replace(min, max, paste);
                        didFirst = true;
                    } //End block
                    else
                    {
                        ((Editable) mText).insert(getSelectionEnd(), "\n");
                        ((Editable) mText).insert(getSelectionEnd(), paste);
                    } //End block
                } //End block
            } //End block
            stopSelectionActionMode();
            sLastCutOrCopyTime = 0;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.703 -0400", hash_original_method = "8BE6A63416328BC319B0B5D0DB32AF7B", hash_generated_method = "0113AD02132039E71CD824525C82F00E")
    private void setPrimaryClip(ClipData clip) {
        addTaint(clip.getTaint());
        ClipboardManager clipboard = (ClipboardManager) getContext().
                getSystemService(Context.CLIPBOARD_SERVICE);
        clipboard.setPrimaryClip(clip);
        sLastCutOrCopyTime = SystemClock.uptimeMillis();
        // ---------- Original Method ----------
        //ClipboardManager clipboard = (ClipboardManager) getContext().
                //getSystemService(Context.CLIPBOARD_SERVICE);
        //clipboard.setPrimaryClip(clip);
        //sLastCutOrCopyTime = SystemClock.uptimeMillis();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.703 -0400", hash_original_method = "EC32E229F62759229A3F9E53D2729660", hash_generated_method = "02ED6835B56B4DAA84114492A22601D5")
    private void hideInsertionPointCursorController() {
        if(mInsertionPointCursorController != null)        
        {
            mInsertionPointCursorController.hide();
        } //End block
        // ---------- Original Method ----------
        //if (mInsertionPointCursorController != null) {
            //mInsertionPointCursorController.hide();
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.703 -0400", hash_original_method = "24BE7797312EE966374B6FFCFBB4586E", hash_generated_method = "957DAB26CB1B7753D50A6C44463DD0BC")
    private void hideControllers() {
        hideCursorControllers();
        hideSpanControllers();
        // ---------- Original Method ----------
        //hideCursorControllers();
        //hideSpanControllers();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.704 -0400", hash_original_method = "49CA1E2702021EF560B250FA375633C6", hash_generated_method = "E9086DF95951C7DC83AD2BF1D6B80554")
    private void hideSpanControllers() {
        if(mChangeWatcher != null)        
        {
            mChangeWatcher.hideControllers();
        } //End block
        // ---------- Original Method ----------
        //if (mChangeWatcher != null) {
            //mChangeWatcher.hideControllers();
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.704 -0400", hash_original_method = "1E18C93748F74C8EE354333AE329FDA3", hash_generated_method = "F6A426A5B2C1BEBE2443E479EFF60CAA")
    private void hideCursorControllers() {
        if(mSuggestionsPopupWindow != null && !mSuggestionsPopupWindow.isShowingUp())        
        {
            mSuggestionsPopupWindow.hide();
        } //End block
        hideInsertionPointCursorController();
        stopSelectionActionMode();
        // ---------- Original Method ----------
        //if (mSuggestionsPopupWindow != null && !mSuggestionsPopupWindow.isShowingUp()) {
            //mSuggestionsPopupWindow.hide();
        //}
        //hideInsertionPointCursorController();
        //stopSelectionActionMode();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.704 -0400", hash_original_method = "3AC7FDA43CAD0B3033F953FC5E229096", hash_generated_method = "0CBB5FD53D4CC28A8A73CA994D108F02")
    public int getOffsetForPosition(float x, float y) {
        addTaint(y);
        addTaint(x);
        if(getLayout() == null)        
        {
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1917098112 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_3410797 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_3410797;
        }
        final int line = getLineAtCoordinate(y);
        final int offset = getOffsetAtCoordinate(line, x);
        int var7A86C157EE9713C34FBD7A1EE40F0C5A_413153776 = (offset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1578484486 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1578484486;
        // ---------- Original Method ----------
        //if (getLayout() == null) return -1;
        //final int line = getLineAtCoordinate(y);
        //final int offset = getOffsetAtCoordinate(line, x);
        //return offset;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.704 -0400", hash_original_method = "C0F2EACF537DEE598E512FB7710303B4", hash_generated_method = "BED6D230E06526E7A17BBFBEC6C8322D")
    private float convertToLocalHorizontalCoordinate(float x) {
        addTaint(x);
        x -= getTotalPaddingLeft();
        x = Math.max(0.0f, x);
        x = Math.min(getWidth() - getTotalPaddingRight() - 1, x);
        x += getScrollX();
        float var9DD4E461268C8034F5C8564E155C67A6_560814256 = (x);
                float var546ADE640B6EDFBC8A086EF31347E768_535502961 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_535502961;
        // ---------- Original Method ----------
        //x -= getTotalPaddingLeft();
        //x = Math.max(0.0f, x);
        //x = Math.min(getWidth() - getTotalPaddingRight() - 1, x);
        //x += getScrollX();
        //return x;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.705 -0400", hash_original_method = "69F0EDA2749521F4A39C0BEAC846F1E5", hash_generated_method = "D14B4F33802E64A290CB948086A911FD")
    private int getLineAtCoordinate(float y) {
        addTaint(y);
        y -= getTotalPaddingTop();
        y = Math.max(0.0f, y);
        y = Math.min(getHeight() - getTotalPaddingBottom() - 1, y);
        y += getScrollY();
        int var1063109764995EC88D5B3E286CBA044D_35607619 = (getLayout().getLineForVertical((int) y));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1079349970 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1079349970;
        // ---------- Original Method ----------
        //y -= getTotalPaddingTop();
        //y = Math.max(0.0f, y);
        //y = Math.min(getHeight() - getTotalPaddingBottom() - 1, y);
        //y += getScrollY();
        //return getLayout().getLineForVertical((int) y);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.705 -0400", hash_original_method = "78600135096D77C91825CF9049D3F243", hash_generated_method = "2FB66CB72229434A52A83438E9E6B6C4")
    private int getOffsetAtCoordinate(int line, float x) {
        addTaint(x);
        addTaint(line);
        x = convertToLocalHorizontalCoordinate(x);
        int var9A1653917878240197D8C2CAEC8FB991_237019010 = (getLayout().getOffsetForHorizontal(line, x));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_625700281 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_625700281;
        // ---------- Original Method ----------
        //x = convertToLocalHorizontalCoordinate(x);
        //return getLayout().getOffsetForHorizontal(line, x);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.705 -0400", hash_original_method = "B77333C8EDA86B5BA4A004A4B129217A", hash_generated_method = "476C746F5C2FE43F104D0CC356141896")
    private boolean isPositionOnText(float x, float y) {
        addTaint(y);
        addTaint(x);
        if(getLayout() == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1912877067 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1747482805 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1747482805;
        }
        final int line = getLineAtCoordinate(y);
        x = convertToLocalHorizontalCoordinate(x);
        if(x < getLayout().getLineLeft(line))        
        {
        boolean var68934A3E9455FA72420237EB05902327_596295507 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_521038433 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_521038433;
        }
        if(x > getLayout().getLineRight(line))        
        {
        boolean var68934A3E9455FA72420237EB05902327_1813207560 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_162431142 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_162431142;
        }
        boolean varB326B5062B2F0E69046810717534CB09_1027829547 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1268624989 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1268624989;
        // ---------- Original Method ----------
        //if (getLayout() == null) return false;
        //final int line = getLineAtCoordinate(y);
        //x = convertToLocalHorizontalCoordinate(x);
        //if (x < getLayout().getLineLeft(line)) return false;
        //if (x > getLayout().getLineRight(line)) return false;
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.706 -0400", hash_original_method = "282C8F5427700D40A542E64F343C6674", hash_generated_method = "2FF6C91586225A4AA257E43E758F8842")
    @Override
    public boolean onDragEvent(DragEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
switch(event.getAction()){
        case DragEvent.ACTION_DRAG_STARTED:
        boolean var78D7B8267AAF86EE157EC5126B45F764_581170421 = (hasInsertionController());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_30286726 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_30286726;
        case DragEvent.ACTION_DRAG_ENTERED:
        TextView.this.requestFocus();
        boolean varB326B5062B2F0E69046810717534CB09_282091913 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_565856380 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_565856380;
        case DragEvent.ACTION_DRAG_LOCATION:
        final int offset = getOffsetForPosition(event.getX(), event.getY());
        Selection.setSelection((Spannable)mText, offset);
        boolean varB326B5062B2F0E69046810717534CB09_1593682796 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_712044961 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_712044961;
        case DragEvent.ACTION_DROP:
        onDrop(event);
        boolean varB326B5062B2F0E69046810717534CB09_1108006741 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1700821807 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1700821807;
        case DragEvent.ACTION_DRAG_ENDED:
        case DragEvent.ACTION_DRAG_EXITED:
        default:
        boolean varB326B5062B2F0E69046810717534CB09_677220186 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_608827252 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_608827252;
}
        // ---------- Original Method ----------
        //switch (event.getAction()) {
            //case DragEvent.ACTION_DRAG_STARTED:
                //return hasInsertionController();
            //case DragEvent.ACTION_DRAG_ENTERED:
                //TextView.this.requestFocus();
                //return true;
            //case DragEvent.ACTION_DRAG_LOCATION:
                //final int offset = getOffsetForPosition(event.getX(), event.getY());
                //Selection.setSelection((Spannable)mText, offset);
                //return true;
            //case DragEvent.ACTION_DROP:
                //onDrop(event);
                //return true;
            //case DragEvent.ACTION_DRAG_ENDED:
            //case DragEvent.ACTION_DRAG_EXITED:
            //default:
                //return true;
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.706 -0400", hash_original_method = "89464BC34879AFE88152B04970AA44D2", hash_generated_method = "354C11237090EB61CD2D93535B7F8161")
    private void onDrop(DragEvent event) {
        addTaint(event.getTaint());
        StringBuilder content = new StringBuilder("");
        ClipData clipData = event.getClipData();
        final int itemCount = clipData.getItemCount();
for(int i=0;i < itemCount;i++)
        {
            Item item = clipData.getItemAt(i);
            content.append(item.coerceToText(TextView.this.mContext));
        } //End block
        final int offset = getOffsetForPosition(event.getX(), event.getY());
        Object localState = event.getLocalState();
        DragLocalState dragLocalState = null;
        if(localState instanceof DragLocalState)        
        {
            dragLocalState = (DragLocalState) localState;
        } //End block
        boolean dragDropIntoItself = dragLocalState != null &&
                dragLocalState.sourceTextView == this;
        if(dragDropIntoItself)        
        {
            if(offset >= dragLocalState.start && offset < dragLocalState.end)            
            {
                return;
            } //End block
        } //End block
        final int originalLength = mText.length();
        long minMax = prepareSpacesAroundPaste(offset, offset, content);
        int min = extractRangeStartFromLong(minMax);
        int max = extractRangeEndFromLong(minMax);
        Selection.setSelection((Spannable) mText, max);
        replaceText_internal(min, max, content);
        if(dragDropIntoItself)        
        {
            int dragSourceStart = dragLocalState.start;
            int dragSourceEnd = dragLocalState.end;
            if(max <= dragSourceStart)            
            {
                final int shift = mText.length() - originalLength;
                dragSourceStart += shift;
                dragSourceEnd += shift;
            } //End block
            deleteText_internal(dragSourceStart, dragSourceEnd);
            if((dragSourceStart == 0 ||
                    Character.isSpaceChar(mTransformed.charAt(dragSourceStart - 1))) &&
                    (dragSourceStart == mText.length() ||
                    Character.isSpaceChar(mTransformed.charAt(dragSourceStart))))            
            {
                final int pos = dragSourceStart == mText.length() ?
                        dragSourceStart - 1 : dragSourceStart;
                deleteText_internal(pos, pos + 1);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.706 -0400", hash_original_method = "91BB575EAEE11A270473B31B356B5B12", hash_generated_method = "679777CEB7F958FE06B2B8E9B377A343")
     boolean hasInsertionController() {
        boolean varBC332654D5E01CC0638CB4493BFC9F05_1127186433 = (mInsertionControllerEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_813082039 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_813082039;
        // ---------- Original Method ----------
        //return mInsertionControllerEnabled;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.706 -0400", hash_original_method = "EE05979336406D2A8CCC57049072454C", hash_generated_method = "25DE6633997143967FE898DEDC300B36")
     boolean hasSelectionController() {
        boolean var23C753EE6F79BCE184A6A1DB0589DB51_2110980390 = (mSelectionControllerEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1702759987 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1702759987;
        // ---------- Original Method ----------
        //return mSelectionControllerEnabled;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.707 -0400", hash_original_method = "02A03A91466BF03F45C3C819266A605E", hash_generated_method = "9DE2606A9A836EF081904419A1C10BE5")
     InsertionPointCursorController getInsertionController() {
        if(!mInsertionControllerEnabled)        
        {
InsertionPointCursorController var540C13E9E156B687226421B24F2DF178_45508565 =             null;
            var540C13E9E156B687226421B24F2DF178_45508565.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_45508565;
        } //End block
        if(mInsertionPointCursorController == null)        
        {
            mInsertionPointCursorController = new InsertionPointCursorController();
            final ViewTreeObserver observer = getViewTreeObserver();
            observer.addOnTouchModeChangeListener(mInsertionPointCursorController);
        } //End block
InsertionPointCursorController varA11DDD2C44AB1F28F4085715A48B787B_398424541 =         mInsertionPointCursorController;
        varA11DDD2C44AB1F28F4085715A48B787B_398424541.addTaint(taint);
        return varA11DDD2C44AB1F28F4085715A48B787B_398424541;
        // ---------- Original Method ----------
        //if (!mInsertionControllerEnabled) {
            //return null;
        //}
        //if (mInsertionPointCursorController == null) {
            //mInsertionPointCursorController = new InsertionPointCursorController();
            //final ViewTreeObserver observer = getViewTreeObserver();
            //observer.addOnTouchModeChangeListener(mInsertionPointCursorController);
        //}
        //return mInsertionPointCursorController;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.707 -0400", hash_original_method = "CD09732805D28B5BF513C98008463942", hash_generated_method = "2D40335A44C84FA6DF6D8CAEE5EE13EC")
     SelectionModifierCursorController getSelectionController() {
        if(!mSelectionControllerEnabled)        
        {
SelectionModifierCursorController var540C13E9E156B687226421B24F2DF178_1780865779 =             null;
            var540C13E9E156B687226421B24F2DF178_1780865779.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1780865779;
        } //End block
        if(mSelectionModifierCursorController == null)        
        {
            mSelectionModifierCursorController = new SelectionModifierCursorController();
            final ViewTreeObserver observer = getViewTreeObserver();
            observer.addOnTouchModeChangeListener(mSelectionModifierCursorController);
        } //End block
SelectionModifierCursorController varBB50D50B6AE199B17E28E8347836D1AB_716849342 =         mSelectionModifierCursorController;
        varBB50D50B6AE199B17E28E8347836D1AB_716849342.addTaint(taint);
        return varBB50D50B6AE199B17E28E8347836D1AB_716849342;
        // ---------- Original Method ----------
        //if (!mSelectionControllerEnabled) {
            //return null;
        //}
        //if (mSelectionModifierCursorController == null) {
            //mSelectionModifierCursorController = new SelectionModifierCursorController();
            //final ViewTreeObserver observer = getViewTreeObserver();
            //observer.addOnTouchModeChangeListener(mSelectionModifierCursorController);
        //}
        //return mSelectionModifierCursorController;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.707 -0400", hash_original_method = "2A090273FA835CA26EC17C458A37DEC8", hash_generated_method = "8BE5468530512D9E86D2BFFBC2158F92")
     boolean isInBatchEditMode() {
        final InputMethodState ims = mInputMethodState;
        if(ims != null)        
        {
            boolean var64591DDCA2B33757B0CA1A7C4BC374CA_740046763 = (ims.mBatchEditNesting > 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1928497193 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1928497193;
        } //End block
        boolean var6854FB31EDC4E2B522D358A7D58685A8_609231943 = (mInBatchEditControllers);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_981413341 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_981413341;
        // ---------- Original Method ----------
        //final InputMethodState ims = mInputMethodState;
        //if (ims != null) {
            //return ims.mBatchEditNesting > 0;
        //}
        //return mInBatchEditControllers;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.708 -0400", hash_original_method = "6388CB4B4CF218043B88410FEBCF8F11", hash_generated_method = "649697647317E5EF05DEE98E6FF163D9")
    @Override
    protected void resolveTextDirection() {
        if(hasPasswordTransformationMethod())        
        {
            mTextDir = TextDirectionHeuristics.LOCALE;
            return;
        } //End block
        final boolean defaultIsRtl = (getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL);
        super.resolveTextDirection();
        int textDir = getResolvedTextDirection();
switch(textDir){
        default:
        case TEXT_DIRECTION_FIRST_STRONG:
        mTextDir = (defaultIsRtl ? TextDirectionHeuristics.FIRSTSTRONG_RTL :
                        TextDirectionHeuristics.FIRSTSTRONG_LTR);
        break;
        case TEXT_DIRECTION_ANY_RTL:
        mTextDir = TextDirectionHeuristics.ANYRTL_LTR;
        break;
        case TEXT_DIRECTION_LTR:
        mTextDir = TextDirectionHeuristics.LTR;
        break;
        case TEXT_DIRECTION_RTL:
        mTextDir = TextDirectionHeuristics.RTL;
        break;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.709 -0400", hash_original_method = "E2C9FAE08740394CAC2960942379DB19", hash_generated_method = "4637D326BBDC2A9D47F623783CB33DC2")
    protected void resolveDrawables() {
        if(mResolvedDrawables)        
        {
            return;
        } //End block
        if(mDrawables == null)        
        {
            return;
        } //End block
        if(mDrawables.mDrawableStart == null && mDrawables.mDrawableEnd == null)        
        {
            mResolvedDrawables = true;
            return;
        } //End block
        Drawables dr = mDrawables;
switch(getResolvedLayoutDirection()){
        case LAYOUT_DIRECTION_RTL:
        if(dr.mDrawableStart != null)        
        {
            dr.mDrawableRight = dr.mDrawableStart;
            dr.mDrawableSizeRight = dr.mDrawableSizeStart;
            dr.mDrawableHeightRight = dr.mDrawableHeightStart;
        } //End block
        if(dr.mDrawableEnd != null)        
        {
            dr.mDrawableLeft = dr.mDrawableEnd;
            dr.mDrawableSizeLeft = dr.mDrawableSizeEnd;
            dr.mDrawableHeightLeft = dr.mDrawableHeightEnd;
        } //End block
        break;
        case LAYOUT_DIRECTION_LTR:
        default:
        if(dr.mDrawableStart != null)        
        {
            dr.mDrawableLeft = dr.mDrawableStart;
            dr.mDrawableSizeLeft = dr.mDrawableSizeStart;
            dr.mDrawableHeightLeft = dr.mDrawableHeightStart;
        } //End block
        if(dr.mDrawableEnd != null)        
        {
            dr.mDrawableRight = dr.mDrawableEnd;
            dr.mDrawableSizeRight = dr.mDrawableSizeEnd;
            dr.mDrawableHeightRight = dr.mDrawableHeightEnd;
        } //End block
        break;
}        mResolvedDrawables = true;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.709 -0400", hash_original_method = "18FE12CF478DF44CED567E30FAAD0C93", hash_generated_method = "39C62916D85B160D1BFEF9F52F7B861D")
    protected void resetResolvedDrawables() {
        mResolvedDrawables = false;
        // ---------- Original Method ----------
        //mResolvedDrawables = false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.709 -0400", hash_original_method = "6AA5A1E8B49AF4D4943616613CE0B2E3", hash_generated_method = "740707A552A037EDEF073191DFC95DE5")
    protected void viewClicked(InputMethodManager imm) {
        addTaint(imm.getTaint());
        if(imm != null)        
        {
            imm.viewClicked(this);
        } //End block
        // ---------- Original Method ----------
        //if (imm != null) {
            //imm.viewClicked(this);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.709 -0400", hash_original_method = "D7BCF3915857A038F77C712DE4BFFF5D", hash_generated_method = "C3830C0921A703CA46D01331D7C1F614")
    protected void deleteText_internal(int start, int end) {
        addTaint(end);
        addTaint(start);
        ((Editable) mText).delete(start, end);
        // ---------- Original Method ----------
        //((Editable) mText).delete(start, end);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.709 -0400", hash_original_method = "2F865B1F2B94D9294078802BAAEABE19", hash_generated_method = "9A592456A543DAA2F8E68C79041624E9")
    protected void replaceText_internal(int start, int end, CharSequence text) {
        addTaint(text.getTaint());
        addTaint(end);
        addTaint(start);
        ((Editable) mText).replace(start, end, text);
        // ---------- Original Method ----------
        //((Editable) mText).replace(start, end, text);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.709 -0400", hash_original_method = "80E41DC8CAFBEBBFCDBF175A54ED075C", hash_generated_method = "273005DF312E640B38B35A1F0EC06605")
    protected void setSpan_internal(Object span, int start, int end, int flags) {
        addTaint(flags);
        addTaint(end);
        addTaint(start);
        addTaint(span.getTaint());
        ((Editable) mText).setSpan(span, start, end, flags);
        // ---------- Original Method ----------
        //((Editable) mText).setSpan(span, start, end, flags);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_method = "ED942619162EB0C0AFB16CB348D15185", hash_generated_method = "E15809AC0D3484A6ED866D2CA64A7328")
    protected void setCursorPosition_internal(int start, int end) {
        addTaint(end);
        addTaint(start);
        Selection.setSelection(((Editable) mText), start, end);
        // ---------- Original Method ----------
        //Selection.setSelection(((Editable) mText), start, end);
    }

    
    static class Drawables {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "74C57594A7956D89EE8B0E12D6641E99", hash_generated_field = "DE8F04160588686525A3D8B15BC2DFE8")

        final Rect mCompoundRect = new Rect();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "0C7DD96235E9F9762942299197287CDE", hash_generated_field = "EA47CEDDDC7FEEFF8968F16759D386B7")

        Drawable mDrawableTop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "FFC9598591962399CC8E8DA93075B1FF", hash_generated_field = "95D5EBB5A7DB907B0D10BA6FCACBEB79")

        Drawable mDrawableBottom;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "449D3E5B49321EA02E52964E3AD5E600", hash_generated_field = "E0F354AEDF5B6392510E8BF8351EC72A")

        Drawable mDrawableLeft;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "E63FC6EB4CF70CF1E79E34F4802DD068", hash_generated_field = "DEB85B9558F1DB613F21ACF47C293916")

        Drawable mDrawableRight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "89A4C538AC75F9C8F89ECA933AF96BAC", hash_generated_field = "B1620A6A345278DE80A9BA4900B11475")

        Drawable mDrawableStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "6A5FA7C04A36BE708BEA6972E6A10C46", hash_generated_field = "ACC539430A5F08E0F28AB3BE40D0952D")

        Drawable mDrawableEnd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "7D9F9A3BD601360DABB13C24EDE31952", hash_generated_field = "11854D143E60E009B90CD1FF8A02DEE3")

        int mDrawableSizeTop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "5EF68820BA8AD14D3920D191E438FBDF", hash_generated_field = "16E3A7AF686EC0516100ECED818E8EBA")

        int mDrawableSizeBottom;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "8DF66E67AC6A7270297B2C5293CA4A1E", hash_generated_field = "9140D35B31C4D61223B6173C166B3B31")

        int mDrawableSizeLeft;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "2BF66DDDC1E0C702D032E0065415C285", hash_generated_field = "D5565D3AC427749F2C0140A5168ACEC1")

        int mDrawableSizeRight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "BC24A3002B0209BBAD6B5107B8C2EA00", hash_generated_field = "400EC481934DD8ABF5A430FF208AE483")

        int mDrawableSizeStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "7A0964DB19BD292930633D81D5FE202A", hash_generated_field = "FC1E40A21375A985A535463B1946D0C4")

        int mDrawableSizeEnd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "D200C09B8E1D61364C5957FCD8230942", hash_generated_field = "F24DC8D9531D637A0AFC8D7ABA047F75")

        int mDrawableWidthTop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "E5BC5ECE7466DFCB1D39A398C2C574A1", hash_generated_field = "3EE0808C0F345FDF9EFA159F089ADA7B")

        int mDrawableWidthBottom;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "875C159AC4F13BDACAA64D85FCF9101B", hash_generated_field = "F4D603ED5E02DAD268A97E78155D65C1")

        int mDrawableHeightLeft;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "D0C439D856EBC4A4B843E9FB48AFDB7F", hash_generated_field = "13D419316EC5090DDF8A1B991D8C5815")

        int mDrawableHeightRight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "733346E69602A23B6E0712C7624F8348", hash_generated_field = "BEF3751E3F03DC5BEF12658362370AC3")

        int mDrawableHeightStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "E6A25620EDEE5CEC3B3C35B3F7640BFF", hash_generated_field = "6D5FC4CA6674578E6C48F812EBFBEB45")

        int mDrawableHeightEnd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "AC18734F422B9E18D85FA34BBE4F1AB9", hash_generated_field = "4B293F8E3375C5C6A3B4DDED1666F169")

        int mDrawablePadding;
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_method = "8748E639EC70CC7FF4A65E9B42DA91C9", hash_generated_method = "8748E639EC70CC7FF4A65E9B42DA91C9")
        public Drawables ()
        {
            //Synthesized constructor
        }


    }


    
    static class InputContentType {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.711 -0400", hash_original_field = "F1D416D715A94332F70BC0287731CE7F", hash_generated_field = "6219A24954430291C20C014227F0E7AC")

        int imeOptions = EditorInfo.IME_NULL;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.711 -0400", hash_original_field = "DEFBBD87D4F8CD9F381E3EB725415421", hash_generated_field = "E12E483301A64F5247F5B384AF8C5D04")

        String privateImeOptions;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.711 -0400", hash_original_field = "76C02E50E629DF1D0F1CA7C54AF496AC", hash_generated_field = "0C07741C23A7BB415A826F63EBCB78E4")

        CharSequence imeActionLabel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.711 -0400", hash_original_field = "D057B43F9C78BB13119BE0D27496DE69", hash_generated_field = "8D9B82A785391392ECC49B1515360CFD")

        int imeActionId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.711 -0400", hash_original_field = "27353006CFD751D26221E04A7928034D", hash_generated_field = "6F80A5414A80FF69E92A0BD3C0E073DC")

        Bundle extras;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.711 -0400", hash_original_field = "BA813182DE371DA33173902F7DCF8E39", hash_generated_field = "FBB987EFA3E5C389D064619D4166B06F")

        OnEditorActionListener onEditorActionListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.711 -0400", hash_original_field = "290F688C4EB819BDE29369D5AC9C7359", hash_generated_field = "94119079D0396AC6C04F22D47E6CD16C")

        boolean enterDown;
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.711 -0400", hash_original_method = "B3EB62E33A235E4F2C0FA9694799B659", hash_generated_method = "B3EB62E33A235E4F2C0FA9694799B659")
        public InputContentType ()
        {
            //Synthesized constructor
        }


    }


    
    static class InputMethodState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.712 -0400", hash_original_field = "C068D7C92CA0B3001E3B86B6035A8ED5", hash_generated_field = "09DEDD19F4EE15AD81232C03C2E1F622")

        Rect mCursorRectInWindow = new Rect();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.712 -0400", hash_original_field = "89DF3EAFA94422450EB293D106F78DF0", hash_generated_field = "C70C3A106639E4B88E9E717A37688D8A")

        RectF mTmpRectF = new RectF();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.712 -0400", hash_original_field = "0B9EE67942FCCABC277B3D4A6655E296", hash_generated_field = "49A81A03C51B25D7E9A5C3BCA9AE957B")

        float[] mTmpOffset = new float[2];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.712 -0400", hash_original_field = "359DC50A098A8A050305C498165DCB8A", hash_generated_field = "FF9982DFAABD3C0DCD2EF1CD08CB60CF")

        ExtractedTextRequest mExtracting;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.712 -0400", hash_original_field = "E00709DBDB9C6962F1B8EC652516BA10", hash_generated_field = "63C64C7DC589F0F8C0F2D7EE456E6161")

        final ExtractedText mTmpExtracted = new ExtractedText();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.712 -0400", hash_original_field = "462C98157E02727571B7A747DD4C8C62", hash_generated_field = "21001EAFF7A276FB78FCAA91CB53D94F")

        int mBatchEditNesting;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.712 -0400", hash_original_field = "49B5E6309E54B338AAA681F087939793", hash_generated_field = "90AD8A78AE95138D386FCE8C5FEB694D")

        boolean mCursorChanged;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.712 -0400", hash_original_field = "16626AECCDE2F164741983CD5E6444F1", hash_generated_field = "866086E9E33AFC2E676556369B9C50CF")

        boolean mSelectionModeChanged;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.712 -0400", hash_original_field = "E4B4327543665AE44C5321E7C66FD5AB", hash_generated_field = "9AAC9C08BF94B94F258CADEF618638FC")

        boolean mContentChanged;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.712 -0400", hash_original_field = "FA977B41050645C0B88E06966F709384", hash_generated_field = "4675A60A313C032BC0FE364A0DDA2ED7")

        int mChangedStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.712 -0400", hash_original_field = "9A4002C6FBE401B7B9714E151801E727", hash_generated_field = "8C7E0284E9593E9DE8C552E7CF188261")

        int mChangedEnd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.712 -0400", hash_original_field = "625F12322D4384854704A8C6631D51D2", hash_generated_field = "D983CF835648B537298EC9705400AAB7")

        int mChangedDelta;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.712 -0400", hash_original_method = "60FC2021DEC54591E7EA76E02BC73921", hash_generated_method = "60FC2021DEC54591E7EA76E02BC73921")
        public InputMethodState ()
        {
            //Synthesized constructor
        }


    }


    
    private static enum TextAlign {
        INHERIT, GRAVITY, TEXT_START, TEXT_END, CENTER, VIEW_START, VIEW_END;
    }

    
    public static class SavedState extends BaseSavedState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.712 -0400", hash_original_field = "416D92C12FE86ACB3AA22B22D8269DC0", hash_generated_field = "4970E7F36D3C8378761D0E310C2396E8")

        int selStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.712 -0400", hash_original_field = "C8D3673FFFE33414608EBCA0E79CB992", hash_generated_field = "E27E0ADA332B9C693E53A0FBE392C373")

        int selEnd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.712 -0400", hash_original_field = "1CB251EC0D568DE6A929B520C4AED8D1", hash_generated_field = "0F26345BF87C16C80BAC76779863E330")

        CharSequence text;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.712 -0400", hash_original_field = "EBD219514CC5466F8D057D080C99356A", hash_generated_field = "C49FE4AC5327729CC90ECD7A211AF40F")

        boolean frozenWithFocus;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.712 -0400", hash_original_field = "CB5E100E5A9A3E7F6D1FD97512215282", hash_generated_field = "BF3285010BEB822EC6EFACD0340B80BF")

        CharSequence error;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.712 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "3F4F70129FCB46E4AE0D334AE4D70CF6")
          SavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.713 -0400", hash_original_method = "37D3E7AD53C42A47440A9F9D38DFF900", hash_generated_method = "0D5F3F6A00C2BE119F9EA1F47D12AAB5")
        private  SavedState(Parcel in) {
            super(in);
            selStart = in.readInt();
            selEnd = in.readInt();
            frozenWithFocus = (in.readInt() != 0);
            text = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
            if(in.readInt() != 0)            
            {
                error = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
            } //End block
            // ---------- Original Method ----------
            //selStart = in.readInt();
            //selEnd = in.readInt();
            //frozenWithFocus = (in.readInt() != 0);
            //text = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
            //if (in.readInt() != 0) {
                //error = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.713 -0400", hash_original_method = "0917C7384BCC053D7DFEC5346FB5EF0D", hash_generated_method = "C9000303252EA7447FAA45B55841D9AB")
        @Override
        public void writeToParcel(Parcel out, int flags) {
            addTaint(flags);
            addTaint(out.getTaint());
            super.writeToParcel(out, flags);
            out.writeInt(selStart);
            out.writeInt(selEnd);
            out.writeInt(frozenWithFocus ? 1 : 0);
            TextUtils.writeToParcel(text, out, flags);
            if(error == null)            
            {
                out.writeInt(0);
            } //End block
            else
            {
                out.writeInt(1);
                TextUtils.writeToParcel(error, out, flags);
            } //End block
            // ---------- Original Method ----------
            //super.writeToParcel(out, flags);
            //out.writeInt(selStart);
            //out.writeInt(selEnd);
            //out.writeInt(frozenWithFocus ? 1 : 0);
            //TextUtils.writeToParcel(text, out, flags);
            //if (error == null) {
                //out.writeInt(0);
            //} else {
                //out.writeInt(1);
                //TextUtils.writeToParcel(error, out, flags);
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.713 -0400", hash_original_method = "B2667A033A504E8795AC5B896DD98B5F", hash_generated_method = "97971D5B53B6B2F527F5B71F846F4FA1")
        @Override
        public String toString() {
            String str = "TextView.SavedState{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " start=" + selStart + " end=" + selEnd;
            if(text != null)            
            {
                str += " text=" + text;
            } //End block
String varFD1CB1AC98CB3716E1BB49F7A70CA208_942354510 =             str + "}";
            varFD1CB1AC98CB3716E1BB49F7A70CA208_942354510.addTaint(taint);
            return varFD1CB1AC98CB3716E1BB49F7A70CA208_942354510;
            // ---------- Original Method ----------
            //String str = "TextView.SavedState{"
                    //+ Integer.toHexString(System.identityHashCode(this))
                    //+ " start=" + selStart + " end=" + selEnd;
            //if (text != null) {
                //str += " text=" + text;
            //}
            //return str + "}";
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.713 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "3C65ED69ACC8B99E43F04B4C3721B494")

        @SuppressWarnings("hiding")
        public static final Parcelable.Creator<SavedState> CREATOR
                = new Parcelable.Creator<SavedState>() {
            @DSModeled(DSC.SAFE)
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            @DSModeled(DSC.SAFE)
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }


    
    private static class CharWrapper implements CharSequence, GetChars, GraphicsOperations {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.714 -0400", hash_original_field = "7C3722E3CD3CCC07C587A93513F1BB79", hash_generated_field = "20B8558AB5FD0F0B5A30B95221D68246")

        private char[] mChars;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.714 -0400", hash_original_field = "59B50EB80ABF1071654EE6DE5094E070", hash_generated_field = "D233E3389CE5D79EE6040D6A855ED4FF")

        private int mStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.714 -0400", hash_original_field = "429F431E8CD8AC287AA27460675EAEFE", hash_generated_field = "E9E17726F18BEC3E5C2C142D209555FD")

        private int mLength;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.714 -0400", hash_original_method = "91EFB0F7C01F6A5A0D8B3974D02E0951", hash_generated_method = "3E74A8A784F032BD1BA482AFCEE2CDD8")
        public  CharWrapper(char[] chars, int start, int len) {
            mChars = chars;
            mStart = start;
            mLength = len;
            // ---------- Original Method ----------
            //mChars = chars;
            //mStart = start;
            //mLength = len;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.714 -0400", hash_original_method = "9DC2F69D47DD9984FB3378BE28468419", hash_generated_method = "72DA95D14539877C07C287DFECCF13DC")
         void set(char[] chars, int start, int len) {
            mChars = chars;
            mStart = start;
            mLength = len;
            // ---------- Original Method ----------
            //mChars = chars;
            //mStart = start;
            //mLength = len;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.714 -0400", hash_original_method = "C0D624CC7CEFFAF650D54F4FB963FAF6", hash_generated_method = "62859A8F2A47EBC1FF6DE250AF5272F1")
        public int length() {
            int var429F431E8CD8AC287AA27460675EAEFE_187686481 = (mLength);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_122326565 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_122326565;
            // ---------- Original Method ----------
            //return mLength;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.714 -0400", hash_original_method = "02B707818F2669493B94939B301EE67F", hash_generated_method = "ED72309A0869CA93EBBE95920693F985")
        public char charAt(int off) {
            addTaint(off);
            char varB84CBF4A1C74092EFDF2FF1B93FA46AC_547248025 = (mChars[off + mStart]);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_2095480735 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_2095480735;
            // ---------- Original Method ----------
            //return mChars[off + mStart];
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.715 -0400", hash_original_method = "16BC7956BCD83D2479A5892A7E5C0E12", hash_generated_method = "E1609EF15B20EF4773D74AE8372198AA")
        @Override
        public String toString() {
String varE91B9BE92888F301D15A38DEAE6AEE62_798180260 =             new String(mChars, mStart, mLength);
            varE91B9BE92888F301D15A38DEAE6AEE62_798180260.addTaint(taint);
            return varE91B9BE92888F301D15A38DEAE6AEE62_798180260;
            // ---------- Original Method ----------
            //return new String(mChars, mStart, mLength);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.715 -0400", hash_original_method = "BA853CED33F98EDEC6E428BC258874A3", hash_generated_method = "8B044C569670B8457A312A103A14C864")
        public CharSequence subSequence(int start, int end) {
            addTaint(end);
            addTaint(start);
            if(start < 0 || end < 0 || start > mLength || end > mLength)            
            {
                IndexOutOfBoundsException var1A52C97FADAA2082523093C493D0C03D_1169963140 = new IndexOutOfBoundsException(start + ", " + end);
                var1A52C97FADAA2082523093C493D0C03D_1169963140.addTaint(taint);
                throw var1A52C97FADAA2082523093C493D0C03D_1169963140;
            } //End block
CharSequence varA5BB608155F8EE66078037C9C3FCF9A4_1443372934 =             new String(mChars, start + mStart, end - start);
            varA5BB608155F8EE66078037C9C3FCF9A4_1443372934.addTaint(taint);
            return varA5BB608155F8EE66078037C9C3FCF9A4_1443372934;
            // ---------- Original Method ----------
            //if (start < 0 || end < 0 || start > mLength || end > mLength) {
                //throw new IndexOutOfBoundsException(start + ", " + end);
            //}
            //return new String(mChars, start + mStart, end - start);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.716 -0400", hash_original_method = "BA41D2BD366E4073F3399B79828CDD69", hash_generated_method = "AD0E526A5AD12C0636ED96821AA02288")
        public void getChars(int start, int end, char[] buf, int off) {
            addTaint(off);
            addTaint(buf[0]);
            addTaint(end);
            addTaint(start);
            if(start < 0 || end < 0 || start > mLength || end > mLength)            
            {
                IndexOutOfBoundsException var1A52C97FADAA2082523093C493D0C03D_1249960446 = new IndexOutOfBoundsException(start + ", " + end);
                var1A52C97FADAA2082523093C493D0C03D_1249960446.addTaint(taint);
                throw var1A52C97FADAA2082523093C493D0C03D_1249960446;
            } //End block
            System.arraycopy(mChars, start + mStart, buf, off, end - start);
            // ---------- Original Method ----------
            //if (start < 0 || end < 0 || start > mLength || end > mLength) {
                //throw new IndexOutOfBoundsException(start + ", " + end);
            //}
            //System.arraycopy(mChars, start + mStart, buf, off, end - start);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.716 -0400", hash_original_method = "69B7B91382C25765CF25BB95E9C19951", hash_generated_method = "47C361D95AE0BAEEE7DF57F4FA3090DE")
        public void drawText(Canvas c, int start, int end,
                             float x, float y, Paint p) {
            addTaint(p.getTaint());
            addTaint(y);
            addTaint(x);
            addTaint(end);
            addTaint(start);
            addTaint(c.getTaint());
            c.drawText(mChars, start + mStart, end - start, x, y, p);
            // ---------- Original Method ----------
            //c.drawText(mChars, start + mStart, end - start, x, y, p);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.716 -0400", hash_original_method = "7645CF39D6B95BCD64DC33FB4F483F74", hash_generated_method = "CD7CE57FB9D717F724586DD104914DE4")
        public void drawTextRun(Canvas c, int start, int end,
                int contextStart, int contextEnd, float x, float y, int flags, Paint p) {
            addTaint(p.getTaint());
            addTaint(flags);
            addTaint(y);
            addTaint(x);
            addTaint(contextEnd);
            addTaint(contextStart);
            addTaint(end);
            addTaint(start);
            addTaint(c.getTaint());
            int count = end - start;
            int contextCount = contextEnd - contextStart;
            c.drawTextRun(mChars, start + mStart, count, contextStart + mStart,
                    contextCount, x, y, flags, p);
            // ---------- Original Method ----------
            //int count = end - start;
            //int contextCount = contextEnd - contextStart;
            //c.drawTextRun(mChars, start + mStart, count, contextStart + mStart,
                    //contextCount, x, y, flags, p);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.716 -0400", hash_original_method = "4FA2C1189F8B48AEDF7B10BEDFF84543", hash_generated_method = "6F8D41EFFEFB25D55C128A5E6C22AE33")
        public float measureText(int start, int end, Paint p) {
            addTaint(p.getTaint());
            addTaint(end);
            addTaint(start);
            float var83873BB6262D1CCD36F6B8F829F7239D_244449138 = (p.measureText(mChars, start + mStart, end - start));
                        float var546ADE640B6EDFBC8A086EF31347E768_20603775 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_20603775;
            // ---------- Original Method ----------
            //return p.measureText(mChars, start + mStart, end - start);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.717 -0400", hash_original_method = "E75F381DB76AB16AB72FA7895D0F4EE0", hash_generated_method = "13A4BA822360BB73813BF2FE3F48E03B")
        public int getTextWidths(int start, int end, float[] widths, Paint p) {
            addTaint(p.getTaint());
            addTaint(widths[0]);
            addTaint(end);
            addTaint(start);
            int var7E246E807ADB26E7C9207F3FFA296B62_438601911 = (p.getTextWidths(mChars, start + mStart, end - start, widths));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1417706727 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1417706727;
            // ---------- Original Method ----------
            //return p.getTextWidths(mChars, start + mStart, end - start, widths);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.717 -0400", hash_original_method = "8AE304950D3C27A7D6E58BA388580EF8", hash_generated_method = "36581CB387E55587A012C37925F4EA52")
        public float getTextRunAdvances(int start, int end, int contextStart,
                int contextEnd, int flags, float[] advances, int advancesIndex,
                Paint p) {
            addTaint(p.getTaint());
            addTaint(advancesIndex);
            addTaint(advances[0]);
            addTaint(flags);
            addTaint(contextEnd);
            addTaint(contextStart);
            addTaint(end);
            addTaint(start);
            int count = end - start;
            int contextCount = contextEnd - contextStart;
            float var3D20AD843E53CFA752DF676D2DFA046A_1523014440 = (p.getTextRunAdvances(mChars, start + mStart, count,
                    contextStart + mStart, contextCount, flags, advances,
                    advancesIndex));
                        float var546ADE640B6EDFBC8A086EF31347E768_1695598249 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1695598249;
            // ---------- Original Method ----------
            //int count = end - start;
            //int contextCount = contextEnd - contextStart;
            //return p.getTextRunAdvances(mChars, start + mStart, count,
                    //contextStart + mStart, contextCount, flags, advances,
                    //advancesIndex);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.717 -0400", hash_original_method = "F8F49F104CF6E56864F062F013326F8E", hash_generated_method = "E67C78018EE1F080C43863D81CCC17AD")
        public float getTextRunAdvances(int start, int end, int contextStart,
                int contextEnd, int flags, float[] advances, int advancesIndex,
                Paint p, int reserved) {
            addTaint(reserved);
            addTaint(p.getTaint());
            addTaint(advancesIndex);
            addTaint(advances[0]);
            addTaint(flags);
            addTaint(contextEnd);
            addTaint(contextStart);
            addTaint(end);
            addTaint(start);
            int count = end - start;
            int contextCount = contextEnd - contextStart;
            float varD0E76A88BDA51CBA50525943EAEF5CEF_517462515 = (p.getTextRunAdvances(mChars, start + mStart, count,
                    contextStart + mStart, contextCount, flags, advances,
                    advancesIndex, reserved));
                        float var546ADE640B6EDFBC8A086EF31347E768_1401048502 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1401048502;
            // ---------- Original Method ----------
            //int count = end - start;
            //int contextCount = contextEnd - contextStart;
            //return p.getTextRunAdvances(mChars, start + mStart, count,
                    //contextStart + mStart, contextCount, flags, advances,
                    //advancesIndex, reserved);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.718 -0400", hash_original_method = "BDCC8CC855D861C4246044B3842097FC", hash_generated_method = "3ACD2410A2BE15B8F06F3DB7538167AC")
        public int getTextRunCursor(int contextStart, int contextEnd, int flags,
                int offset, int cursorOpt, Paint p) {
            addTaint(p.getTaint());
            addTaint(cursorOpt);
            addTaint(offset);
            addTaint(flags);
            addTaint(contextEnd);
            addTaint(contextStart);
            int contextCount = contextEnd - contextStart;
            int var6D863CFEA3317324B3772491610F644E_406754424 = (p.getTextRunCursor(mChars, contextStart + mStart,
                    contextCount, flags, offset + mStart, cursorOpt));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_275188929 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_275188929;
            // ---------- Original Method ----------
            //int contextCount = contextEnd - contextStart;
            //return p.getTextRunCursor(mChars, contextStart + mStart,
                    //contextCount, flags, offset + mStart, cursorOpt);
        }

        
    }


    
    private static class ErrorPopup extends PopupWindow {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.718 -0400", hash_original_field = "7DF8B65473C97B2A69F25D9317EC3DEC", hash_generated_field = "7E17DC26D2CD570CF106F239587AB53D")

        private boolean mAbove = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.718 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "EC8812FBC96AED57B9AA8E9AC44D0DAB")

        private TextView mView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.718 -0400", hash_original_field = "A0A9CFD5067DB601801485B1E446CCDB", hash_generated_field = "950EB5B59166D035BC490D5607F4FE92")

        private int mPopupInlineErrorBackgroundId = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.718 -0400", hash_original_field = "6962B840396BC381227E36B1099A626C", hash_generated_field = "44679A20C762322AD033B0D96DF5B4A1")

        private int mPopupInlineErrorAboveBackgroundId = 0;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.718 -0400", hash_original_method = "272870BAEDFD334116717C4E8AB7F4AA", hash_generated_method = "85E438C6E6E32A0A92CFC5F0B878573B")
          ErrorPopup(TextView v, int width, int height) {
            super(v, width, height);
            addTaint(height);
            addTaint(width);
            mView = v;
            mPopupInlineErrorBackgroundId = getResourceId(mPopupInlineErrorBackgroundId,
                    com.android.internal.R.styleable.Theme_errorMessageBackground);
            mView.setBackgroundResource(mPopupInlineErrorBackgroundId);
            // ---------- Original Method ----------
            //mView = v;
            //mPopupInlineErrorBackgroundId = getResourceId(mPopupInlineErrorBackgroundId,
                    //com.android.internal.R.styleable.Theme_errorMessageBackground);
            //mView.setBackgroundResource(mPopupInlineErrorBackgroundId);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.719 -0400", hash_original_method = "FF785E3F959B10F16CB73DE59942CDE6", hash_generated_method = "0BEB73326C610DC91064A15F916D24DE")
         void fixDirection(boolean above) {
            mAbove = above;
            if(above)            
            {
                mPopupInlineErrorAboveBackgroundId =
                    getResourceId(mPopupInlineErrorAboveBackgroundId,
                            com.android.internal.R.styleable.Theme_errorMessageAboveBackground);
            } //End block
            else
            {
                mPopupInlineErrorBackgroundId = getResourceId(mPopupInlineErrorBackgroundId,
                        com.android.internal.R.styleable.Theme_errorMessageBackground);
            } //End block
            mView.setBackgroundResource(above ? mPopupInlineErrorAboveBackgroundId :
                mPopupInlineErrorBackgroundId);
            // ---------- Original Method ----------
            //mAbove = above;
            //if (above) {
                //mPopupInlineErrorAboveBackgroundId =
                    //getResourceId(mPopupInlineErrorAboveBackgroundId,
                            //com.android.internal.R.styleable.Theme_errorMessageAboveBackground);
            //} else {
                //mPopupInlineErrorBackgroundId = getResourceId(mPopupInlineErrorBackgroundId,
                        //com.android.internal.R.styleable.Theme_errorMessageBackground);
            //}
            //mView.setBackgroundResource(above ? mPopupInlineErrorAboveBackgroundId :
                //mPopupInlineErrorBackgroundId);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.719 -0400", hash_original_method = "283134609ABCFB2A4CA7FFE3B421D4C1", hash_generated_method = "662E40FC9963B5AD382A28D8843404FE")
        private int getResourceId(int currentId, int index) {
            addTaint(index);
            addTaint(currentId);
            if(currentId == 0)            
            {
                TypedArray styledAttributes = mView.getContext().obtainStyledAttributes(
                        R.styleable.Theme);
                currentId = styledAttributes.getResourceId(index, 0);
                styledAttributes.recycle();
            } //End block
            int var8A12496D5582F8768D9E213417B18781_1129557576 = (currentId);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_981595048 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_981595048;
            // ---------- Original Method ----------
            //if (currentId == 0) {
                //TypedArray styledAttributes = mView.getContext().obtainStyledAttributes(
                        //R.styleable.Theme);
                //currentId = styledAttributes.getResourceId(index, 0);
                //styledAttributes.recycle();
            //}
            //return currentId;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.719 -0400", hash_original_method = "D12B38B9E303D838A7A28156EE92AFAA", hash_generated_method = "A8135A0747A48C29501937FF879498F0")
        @Override
        public void update(int x, int y, int w, int h, boolean force) {
            addTaint(force);
            addTaint(h);
            addTaint(w);
            addTaint(y);
            addTaint(x);
            super.update(x, y, w, h, force);
            boolean above = isAboveAnchor();
            if(above != mAbove)            
            {
                fixDirection(above);
            } //End block
            // ---------- Original Method ----------
            //super.update(x, y, w, h, force);
            //boolean above = isAboveAnchor();
            //if (above != mAbove) {
                //fixDirection(above);
            //}
        }

        
    }


    
    private class CorrectionHighlighter {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.720 -0400", hash_original_field = "DBC2DDFC3AA0B07663EC95BA4102B76C", hash_generated_field = "1C9B38C7F9B71799B7B8F281B135448B")

        private final Path mPath = new Path();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.720 -0400", hash_original_field = "E7BA6B001D9391CCE70C3C78C53FA3AF", hash_generated_field = "72C5AF717CADB3E1B93A20C1294BD3BC")

        private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.720 -0400", hash_original_field = "59B50EB80ABF1071654EE6DE5094E070", hash_generated_field = "D233E3389CE5D79EE6040D6A855ED4FF")

        private int mStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.720 -0400", hash_original_field = "C3B248BAD041692A85BAABC024E9FDCE", hash_generated_field = "EA295975CAF8E42F4C28A87EADB358DF")

        private int mEnd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.720 -0400", hash_original_field = "BE8674259642701C85F5A18F0D1B92CD", hash_generated_field = "516150ABFF873AC5B12EBF2F659E6EFD")

        private long mFadingStartTime;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.720 -0400", hash_original_method = "76400340233C9D40D55E8C6995EBADF6", hash_generated_method = "B77926F0B0BE367B250F0A650FF30C45")
        public  CorrectionHighlighter() {
            mPaint.setCompatibilityScaling(getResources().getCompatibilityInfo().applicationScale);
            mPaint.setStyle(Paint.Style.FILL);
            // ---------- Original Method ----------
            //mPaint.setCompatibilityScaling(getResources().getCompatibilityInfo().applicationScale);
            //mPaint.setStyle(Paint.Style.FILL);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.721 -0400", hash_original_method = "9DA46F38DADC56BDE7EACA06EAFC15FB", hash_generated_method = "CDEFDDA849AB0EC2F1F03056CDC0AA53")
        public void highlight(CorrectionInfo info) {
            mStart = info.getOffset();
            mEnd = mStart + info.getNewText().length();
            mFadingStartTime = SystemClock.uptimeMillis();
            if(mStart < 0 || mEnd < 0)            
            {
                stopAnimation();
            } //End block
            // ---------- Original Method ----------
            //mStart = info.getOffset();
            //mEnd = mStart + info.getNewText().length();
            //mFadingStartTime = SystemClock.uptimeMillis();
            //if (mStart < 0 || mEnd < 0) {
                //stopAnimation();
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.721 -0400", hash_original_method = "F315418B1425EA36D28AB47D63F906BC", hash_generated_method = "C45FBE5608E2FFFD9D2CDF794EE2824D")
        public void draw(Canvas canvas, int cursorOffsetVertical) {
            addTaint(cursorOffsetVertical);
            addTaint(canvas.getTaint());
            if(updatePath() && updatePaint())            
            {
                if(cursorOffsetVertical != 0)                
                {
                    canvas.translate(0, cursorOffsetVertical);
                } //End block
                canvas.drawPath(mPath, mPaint);
                if(cursorOffsetVertical != 0)                
                {
                    canvas.translate(0, -cursorOffsetVertical);
                } //End block
                invalidate(true);
            } //End block
            else
            {
                stopAnimation();
                invalidate(false);
            } //End block
            // ---------- Original Method ----------
            //if (updatePath() && updatePaint()) {
                //if (cursorOffsetVertical != 0) {
                    //canvas.translate(0, cursorOffsetVertical);
                //}
                //canvas.drawPath(mPath, mPaint);
                //if (cursorOffsetVertical != 0) {
                    //canvas.translate(0, -cursorOffsetVertical);
                //}
                //invalidate(true); 
            //} else {
                //stopAnimation();
                //invalidate(false); 
            //}
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.722 -0400", hash_original_method = "5CBDA1AAE290DD8920EE208B7E44B556", hash_generated_method = "6A8B137B6CFB25BAA8FDD7944BBCDF5F")
        private boolean updatePaint() {
            final long duration = SystemClock.uptimeMillis() - mFadingStartTime;
            if(duration > FADE_OUT_DURATION)            
            {
            boolean var68934A3E9455FA72420237EB05902327_132500861 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1609681681 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1609681681;
            }
            final float coef = 1.0f - (float) duration / FADE_OUT_DURATION;
            final int highlightColorAlpha = Color.alpha(mHighlightColor);
            final int color = (mHighlightColor & 0x00FFFFFF) +
                    ((int) (highlightColorAlpha * coef) << 24);
            mPaint.setColor(color);
            boolean varB326B5062B2F0E69046810717534CB09_896658678 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1771604343 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1771604343;
            // ---------- Original Method ----------
            //final long duration = SystemClock.uptimeMillis() - mFadingStartTime;
            //if (duration > FADE_OUT_DURATION) return false;
            //final float coef = 1.0f - (float) duration / FADE_OUT_DURATION;
            //final int highlightColorAlpha = Color.alpha(mHighlightColor);
            //final int color = (mHighlightColor & 0x00FFFFFF) +
                    //((int) (highlightColorAlpha * coef) << 24);
            //mPaint.setColor(color);
            //return true;
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.722 -0400", hash_original_method = "77DEEE2C70776896B8DA6C9B8DAC8452", hash_generated_method = "7D396532F33863CF487E71B21B5CF1D7")
        private boolean updatePath() {
            final Layout layout = TextView.this.mLayout;
            if(layout == null)            
            {
            boolean var68934A3E9455FA72420237EB05902327_347848528 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2053389516 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2053389516;
            }
            final int length = mText.length();
            int start = Math.min(length, mStart);
            int end = Math.min(length, mEnd);
            mPath.reset();
            TextView.this.mLayout.getSelectionPath(start, end, mPath);
            boolean varB326B5062B2F0E69046810717534CB09_887291322 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_824118869 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_824118869;
            // ---------- Original Method ----------
            //final Layout layout = TextView.this.mLayout;
            //if (layout == null) return false;
            //final int length = mText.length();
            //int start = Math.min(length, mStart);
            //int end = Math.min(length, mEnd);
            //mPath.reset();
            //TextView.this.mLayout.getSelectionPath(start, end, mPath);
            //return true;
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.723 -0400", hash_original_method = "E7B5FD6BE43D84566E63BFC892235B90", hash_generated_method = "3B8BE9E9EA981E20E61E0724AE122F8F")
        private void invalidate(boolean delayed) {
            addTaint(delayed);
            if(TextView.this.mLayout == null)            
            return;
            synchronized
(sTempRect)            {
                mPath.computeBounds(sTempRect, false);
                int left = getCompoundPaddingLeft();
                int top = getExtendedPaddingTop() + getVerticalOffset(true);
                if(delayed)                
                {
                    TextView.this.postInvalidateDelayed(16, 
                            left + (int) sTempRect.left, top + (int) sTempRect.top,
                            left + (int) sTempRect.right, top + (int) sTempRect.bottom);
                } //End block
                else
                {
                    TextView.this.postInvalidate((int) sTempRect.left, (int) sTempRect.top,
                            (int) sTempRect.right, (int) sTempRect.bottom);
                } //End block
            } //End block
            // ---------- Original Method ----------
            //if (TextView.this.mLayout == null) return;
            //synchronized (sTempRect) {
                //mPath.computeBounds(sTempRect, false);
                //int left = getCompoundPaddingLeft();
                //int top = getExtendedPaddingTop() + getVerticalOffset(true);
                //if (delayed) {
                    //TextView.this.postInvalidateDelayed(16, 
                            //left + (int) sTempRect.left, top + (int) sTempRect.top,
                            //left + (int) sTempRect.right, top + (int) sTempRect.bottom);
                //} else {
                    //TextView.this.postInvalidate((int) sTempRect.left, (int) sTempRect.top,
                            //(int) sTempRect.right, (int) sTempRect.bottom);
                //}
            //}
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.723 -0400", hash_original_method = "4BD6A36A746D13E089BD00A9CC0A6FB7", hash_generated_method = "78D02156987325E73BE90677BD5A4AF4")
        private void stopAnimation() {
            TextView.this.mCorrectionHighlighter = null;
            // ---------- Original Method ----------
            //TextView.this.mCorrectionHighlighter = null;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.724 -0400", hash_original_field = "5BBBF8F997ACE9A57CB3491DCAF1B12E", hash_generated_field = "BE8E612E603608AA1A116A2C67EC5B99")

        private final static int FADE_OUT_DURATION = 400;
    }


    
    private static final class Marquee extends Handler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.724 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "378CC9BF8F5DA198EF400A97F72A70A3")

        private WeakReference<TextView> mView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.724 -0400", hash_original_field = "4704E97CC036B299FAC82F1786745C27", hash_generated_field = "E1F826A18833675CAA3F20EBBCB74E63")

        private byte mStatus = MARQUEE_STOPPED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.724 -0400", hash_original_field = "0AD263692B7453D1CADEF9C0002D8D7E", hash_generated_field = "F7B50A7445EB5AE7B4AED021C79A3798")

        private float mScrollUnit;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.724 -0400", hash_original_field = "73E7117FC717C5779EFE316E1A54EFF7", hash_generated_field = "01E3791EB1346C97E47507148C4BA197")

        private float mMaxScroll;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.724 -0400", hash_original_field = "48D13BF0748D58A28F6C563805C3AA25", hash_generated_field = "60FE7DDBA197AB2FD49DEEDB9A0234B2")

        float mMaxFadeScroll;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.724 -0400", hash_original_field = "72795809679CC0D4D2ECD064DBC450D5", hash_generated_field = "A1B75D52F4336D0AD351EB697147DDEE")

        private float mGhostStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.724 -0400", hash_original_field = "45F31C063DD4B9215C31432A52D6D16F", hash_generated_field = "F191C5ED756AC66F521DCB9604BE3690")

        private float mGhostOffset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.724 -0400", hash_original_field = "6B507C89547F9268ECF8CAA3066483D0", hash_generated_field = "64343518D38D9F055C2F10972107CF16")

        private float mFadeStop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.724 -0400", hash_original_field = "5BD21E806EB8AC9E0439CEE0F1945029", hash_generated_field = "4382F6070B0A1518DE23E4DA7693EF55")

        private int mRepeatLimit;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.724 -0400", hash_original_field = "D9E346D7C0C44D38F8B4D76282E9C096", hash_generated_field = "C7F848EDC5F556B007801A6A62728CC6")

        float mScroll;
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.725 -0400", hash_original_method = "EC19D4EFFC7CC18F674B4C588B8FB87B", hash_generated_method = "5ACDC9399C65F3DC796FCFD5CE2E9B57")
          Marquee(TextView v) {
            final float density = v.getContext().getResources().getDisplayMetrics().density;
            mScrollUnit = (MARQUEE_PIXELS_PER_SECOND * density) / MARQUEE_RESOLUTION;
            mView = new WeakReference<TextView>(v);
            // ---------- Original Method ----------
            //final float density = v.getContext().getResources().getDisplayMetrics().density;
            //mScrollUnit = (MARQUEE_PIXELS_PER_SECOND * density) / MARQUEE_RESOLUTION;
            //mView = new WeakReference<TextView>(v);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.728 -0400", hash_original_method = "6484E5DEDF9A6D25913C9D3BAE668871", hash_generated_method = "A4DC4CD93F8F9C3EA5CE1F4FB2F59695")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
switch(msg.what){
            case MESSAGE_START:
            mStatus = MARQUEE_RUNNING;
            tick();
            break;
            case MESSAGE_TICK:
            tick();
            break;
            case MESSAGE_RESTART:
            if(mStatus == MARQUEE_RUNNING)            
            {
                if(mRepeatLimit >= 0)                
                {
                    mRepeatLimit--;
                } //End block
                start(mRepeatLimit);
            } //End block
            break;
}
            // ---------- Original Method ----------
            //switch (msg.what) {
                //case MESSAGE_START:
                    //mStatus = MARQUEE_RUNNING;
                    //tick();
                    //break;
                //case MESSAGE_TICK:
                    //tick();
                    //break;
                //case MESSAGE_RESTART:
                    //if (mStatus == MARQUEE_RUNNING) {
                        //if (mRepeatLimit >= 0) {
                            //mRepeatLimit--;
                        //}
                        //start(mRepeatLimit);
                    //}
                    //break;
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.728 -0400", hash_original_method = "EE95900433272316B4E2225B22ADF455", hash_generated_method = "DE61706D03084CBE3DA6F1F221DB5875")
         void tick() {
            if(mStatus != MARQUEE_RUNNING)            
            {
                return;
            } //End block
            removeMessages(MESSAGE_TICK);
            final TextView textView = mView.get();
            if(textView != null && (textView.isFocused() || textView.isSelected()))            
            {
                mScroll += mScrollUnit;
                if(mScroll > mMaxScroll)                
                {
                    mScroll = mMaxScroll;
                    sendEmptyMessageDelayed(MESSAGE_RESTART, MARQUEE_RESTART_DELAY);
                } //End block
                else
                {
                    sendEmptyMessageDelayed(MESSAGE_TICK, MARQUEE_RESOLUTION);
                } //End block
                textView.invalidate();
            } //End block
            // ---------- Original Method ----------
            //if (mStatus != MARQUEE_RUNNING) {
                //return;
            //}
            //removeMessages(MESSAGE_TICK);
            //final TextView textView = mView.get();
            //if (textView != null && (textView.isFocused() || textView.isSelected())) {
                //mScroll += mScrollUnit;
                //if (mScroll > mMaxScroll) {
                    //mScroll = mMaxScroll;
                    //sendEmptyMessageDelayed(MESSAGE_RESTART, MARQUEE_RESTART_DELAY);
                //} else {
                    //sendEmptyMessageDelayed(MESSAGE_TICK, MARQUEE_RESOLUTION);
                //}
                //textView.invalidate();
            //}
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.728 -0400", hash_original_method = "559B799FFC0EAE80362A4924AC6B387F", hash_generated_method = "AEBFA0DC15336E07980941BA4CDDF3E1")
         void stop() {
            mStatus = MARQUEE_STOPPED;
            removeMessages(MESSAGE_START);
            removeMessages(MESSAGE_RESTART);
            removeMessages(MESSAGE_TICK);
            resetScroll();
            // ---------- Original Method ----------
            //mStatus = MARQUEE_STOPPED;
            //removeMessages(MESSAGE_START);
            //removeMessages(MESSAGE_RESTART);
            //removeMessages(MESSAGE_TICK);
            //resetScroll();
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.728 -0400", hash_original_method = "E75276DE0DCFDFD0F42F697FF2F53A01", hash_generated_method = "78DA74614F11D75434A50583270A401B")
        private void resetScroll() {
            mScroll = 0.0f;
            final TextView textView = mView.get();
            if(textView != null)            
            textView.invalidate();
            // ---------- Original Method ----------
            //mScroll = 0.0f;
            //final TextView textView = mView.get();
            //if (textView != null) textView.invalidate();
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.730 -0400", hash_original_method = "C8CF1974A44593F9FA59199A16CE27AD", hash_generated_method = "2A882E5DAABCDEA6A150D1C6C40C978E")
         void start(int repeatLimit) {
            if(repeatLimit == 0)            
            {
                stop();
                return;
            } //End block
            mRepeatLimit = repeatLimit;
            final TextView textView = mView.get();
            if(textView != null && textView.mLayout != null)            
            {
                mStatus = MARQUEE_STARTING;
                mScroll = 0.0f;
                final int textWidth = textView.getWidth() - textView.getCompoundPaddingLeft() -
                        textView.getCompoundPaddingRight();
                final float lineWidth = textView.mLayout.getLineWidth(0);
                final float gap = textWidth / 3.0f;
                mGhostStart = lineWidth - textWidth + gap;
                mMaxScroll = mGhostStart + textWidth;
                mGhostOffset = lineWidth + gap;
                mFadeStop = lineWidth + textWidth / 6.0f;
                mMaxFadeScroll = mGhostStart + lineWidth + lineWidth;
                textView.invalidate();
                sendEmptyMessageDelayed(MESSAGE_START, MARQUEE_DELAY);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.730 -0400", hash_original_method = "8BEDD434588E893B08521C1E5E937982", hash_generated_method = "2DEF6508A1E0E01D6306856A712B416A")
         float getGhostOffset() {
            float var45F31C063DD4B9215C31432A52D6D16F_1065972886 = (mGhostOffset);
                        float var546ADE640B6EDFBC8A086EF31347E768_1109988400 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1109988400;
            // ---------- Original Method ----------
            //return mGhostOffset;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.730 -0400", hash_original_method = "FBB73F0BC2F425DEBE19335413BBBBD5", hash_generated_method = "5BA04F3EAEB2A79A7D8D6F6552DE6F7E")
         boolean shouldDrawLeftFade() {
            boolean var76C12DE50A187B4D3B8DF3984F862452_1492039958 = (mScroll <= mFadeStop);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_21762530 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_21762530;
            // ---------- Original Method ----------
            //return mScroll <= mFadeStop;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.730 -0400", hash_original_method = "297E21CB54951ECF2F6E26FAB2DC7036", hash_generated_method = "65ACEB34F49813CD7BA8BF6E732DA7FE")
         boolean shouldDrawGhost() {
            boolean varEAE9D0F247A0B2E9BA45017F22FF932D_1135292603 = (mStatus == MARQUEE_RUNNING && mScroll > mGhostStart);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_927866822 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_927866822;
            // ---------- Original Method ----------
            //return mStatus == MARQUEE_RUNNING && mScroll > mGhostStart;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.730 -0400", hash_original_method = "9069B9288EAB1BBCE4A11291BAF7E3F4", hash_generated_method = "6295AFA87D671ED1FED2A5E4F7A8CC83")
         boolean isRunning() {
            boolean varECDE70E0A324E7F18509AC6CE5898384_1387828687 = (mStatus == MARQUEE_RUNNING);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_48998192 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_48998192;
            // ---------- Original Method ----------
            //return mStatus == MARQUEE_RUNNING;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.730 -0400", hash_original_method = "57F6027DED5DA77924B224C2BB22701E", hash_generated_method = "36497E981BBD6846A955EDAC4052EA22")
         boolean isStopped() {
            boolean var0285F0C157564438C79518451409EDB2_928439798 = (mStatus == MARQUEE_STOPPED);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1354690826 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1354690826;
            // ---------- Original Method ----------
            //return mStatus == MARQUEE_STOPPED;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.731 -0400", hash_original_field = "6AC58C16DFF7294B5A4A431E14108EC2", hash_generated_field = "8C251E17630B365D009996AD47B2DD3C")

        private static final float MARQUEE_DELTA_MAX = 0.07f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.731 -0400", hash_original_field = "E4728EDDA8B3D2C91D4624E788111E01", hash_generated_field = "35927BC6057D4173F3812056640AA204")

        private static final int MARQUEE_DELAY = 1200;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.731 -0400", hash_original_field = "3B4EF5CF2B395DE1542F2D8F5DFC67D7", hash_generated_field = "A480DE8D7F8C3DD06D7F56FDCF1785D2")

        private static final int MARQUEE_RESTART_DELAY = 1200;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.731 -0400", hash_original_field = "8B25855C58895BDA613FD9FD4275C244", hash_generated_field = "FB93BB56AFDF6E4B8D61ECD57E059D47")

        private static final int MARQUEE_RESOLUTION = 1000 / 30;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.731 -0400", hash_original_field = "CC2183A454A8CF823D5EB4FBCB7AB848", hash_generated_field = "B05A9FDC59FD134B7233CD4AFE4BE285")

        private static final int MARQUEE_PIXELS_PER_SECOND = 30;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.731 -0400", hash_original_field = "83CB05D0724C63AFF22CF998C0771186", hash_generated_field = "84F62194C3706C2DA47D02768AFB5267")

        private static final byte MARQUEE_STOPPED = 0x0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.731 -0400", hash_original_field = "524F0584151994C79B9191730415DC22", hash_generated_field = "BE8444FCF06CF4D0AF51FD248A85AAC9")

        private static final byte MARQUEE_STARTING = 0x1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.731 -0400", hash_original_field = "1E99F17DD0A7ACAF311564610127CEBC", hash_generated_field = "5524003C352475E0FE9851B8CCD129C6")

        private static final byte MARQUEE_RUNNING = 0x2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.731 -0400", hash_original_field = "D45CAA01F64232AF582D5B7E05E9FD00", hash_generated_field = "CB5FC73826DDCE47D2749061356148BA")

        private static final int MESSAGE_START = 0x1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.731 -0400", hash_original_field = "03DF5DD145AC4F2C9B8B8DE9EB6C0135", hash_generated_field = "FAB12A799FD1570304AC952DCE5A469B")

        private static final int MESSAGE_TICK = 0x2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.731 -0400", hash_original_field = "CDACA6038BA86AB9AABBD482EB6DF6F1", hash_generated_field = "BB4587B4AB1E5F07B03C638733286E8C")

        private static final int MESSAGE_RESTART = 0x3;
    }


    
    private class EasyEditSpanController {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.731 -0400", hash_original_field = "BF75305BD1095CDED8E2337DB678670B", hash_generated_field = "93AE44B2D9F293D0BC2408DE643B7037")

        private EasyEditPopupWindow mPopupWindow;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.731 -0400", hash_original_field = "EDF25D09739D26EF9ECAF542864CC487", hash_generated_field = "D79D9256BE9491F92C92FB8BCC6A61DC")

        private EasyEditSpan mEasyEditSpan;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.731 -0400", hash_original_field = "6613F0388A136327FDBD8526D1D89DBF", hash_generated_field = "EE65FA1568E5725BCA3859DE8F52F788")

        private Runnable mHidePopup;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.731 -0400", hash_original_method = "2E07A306089CEDB8C207DEEB8EF7B36E", hash_generated_method = "2E07A306089CEDB8C207DEEB8EF7B36E")
        public EasyEditSpanController ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.731 -0400", hash_original_method = "EDC90536D8A41E1495260C5D2B0A4CB4", hash_generated_method = "54D1883311137A383177ABDA3410B679")
        private void hide() {
            if(mPopupWindow != null)            
            {
                mPopupWindow.hide();
                TextView.this.removeCallbacks(mHidePopup);
            } //End block
            removeSpans(mText);
            mEasyEditSpan = null;
            // ---------- Original Method ----------
            //if (mPopupWindow != null) {
                //mPopupWindow.hide();
                //TextView.this.removeCallbacks(mHidePopup);
            //}
            //removeSpans(mText);
            //mEasyEditSpan = null;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.732 -0400", hash_original_method = "400D6F397C7E694E5D2CC26E5076AFF1", hash_generated_method = "52F6789B7CBDBC1947ECA2B9D719D046")
        public void onTextChange(CharSequence buffer) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            adjustSpans(mText);
            if(getWindowVisibility() != View.VISIBLE)            
            {
                return;
            } //End block
            if(mLayout == null)            
            {
                return;
            } //End block
            InputMethodManager imm = InputMethodManager.peekInstance();
            if(!(TextView.this instanceof ExtractEditText)
                    && imm != null && imm.isFullscreenMode())            
            {
                return;
            } //End block
            if(mEasyEditSpan != null)            
            {
                if(mText instanceof Spannable)                
                {
                    ((Spannable) mText).removeSpan(mEasyEditSpan);
                } //End block
                mEasyEditSpan = null;
            } //End block
            if(mPopupWindow != null && mPopupWindow.isShowing())            
            {
                mPopupWindow.hide();
            } //End block
            if(buffer instanceof Spanned)            
            {
                mEasyEditSpan = getSpan((Spanned) buffer);
                if(mEasyEditSpan != null)                
                {
                    if(mPopupWindow == null)                    
                    {
                        mPopupWindow = new EasyEditPopupWindow();
                        mHidePopup = new Runnable() {            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.732 -0400", hash_original_method = "21815FA27ABEB649DED6A46E4F97905B", hash_generated_method = "891AC471650FB94DC3945684A90962FE")
            @Override
            public void run() {
                hide();
                // ---------- Original Method ----------
                //hide();
            }
};
                    } //End block
                    mPopupWindow.show(mEasyEditSpan);
                    TextView.this.removeCallbacks(mHidePopup);
                    TextView.this.postDelayed(mHidePopup, DISPLAY_TIMEOUT_MS);
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.732 -0400", hash_original_method = "BE935C64EC56548296E167AABD21FC2C", hash_generated_method = "F2DE7CC2FB0EB78BCAC1FD77F85CB5F5")
        private void adjustSpans(CharSequence buffer) {
            addTaint(buffer.getTaint());
            if(buffer instanceof Spannable)            
            {
                Spannable spannable = (Spannable) buffer;
                EasyEditSpan[] spans = spannable.getSpans(0, spannable.length(),
                        EasyEditSpan.class);
for(int i = 0;i < spans.length - 1;i++)
                {
                    spannable.removeSpan(spans[i]);
                } //End block
            } //End block
            // ---------- Original Method ----------
            //if (buffer instanceof Spannable) {
                //Spannable spannable = (Spannable) buffer;
                //EasyEditSpan[] spans = spannable.getSpans(0, spannable.length(),
                        //EasyEditSpan.class);
                //for (int i = 0; i < spans.length - 1; i++) {
                    //spannable.removeSpan(spans[i]);
                //}
            //}
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.733 -0400", hash_original_method = "D4568FCB8F606B40F32BB2FF24EF8AE2", hash_generated_method = "B57FC8ABEDC4BAC905D382E4BE735FDE")
        private void removeSpans(CharSequence buffer) {
            addTaint(buffer.getTaint());
            if(buffer instanceof Spannable)            
            {
                Spannable spannable = (Spannable) buffer;
                EasyEditSpan[] spans = spannable.getSpans(0, spannable.length(),
                        EasyEditSpan.class);
for(int i = 0;i < spans.length;i++)
                {
                    spannable.removeSpan(spans[i]);
                } //End block
            } //End block
            // ---------- Original Method ----------
            //if (buffer instanceof Spannable) {
                //Spannable spannable = (Spannable) buffer;
                //EasyEditSpan[] spans = spannable.getSpans(0, spannable.length(),
                        //EasyEditSpan.class);
                //for (int i = 0; i < spans.length; i++) {
                    //spannable.removeSpan(spans[i]);
                //}
            //}
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.733 -0400", hash_original_method = "FD0036F1377269974D72D9C2BC2EFAA3", hash_generated_method = "83562AD962524CA95510F354F1EFA4DE")
        private EasyEditSpan getSpan(Spanned spanned) {
            addTaint(spanned.getTaint());
            EasyEditSpan[] easyEditSpans = spanned.getSpans(0, spanned.length(),
                    EasyEditSpan.class);
            if(easyEditSpans.length == 0)            
            {
EasyEditSpan var540C13E9E156B687226421B24F2DF178_1775872184 =                 null;
                var540C13E9E156B687226421B24F2DF178_1775872184.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1775872184;
            } //End block
            else
            {
EasyEditSpan var5CF42DCA35C107A57B18028EC7B27F86_1290739002 =                 easyEditSpans[0];
                var5CF42DCA35C107A57B18028EC7B27F86_1290739002.addTaint(taint);
                return var5CF42DCA35C107A57B18028EC7B27F86_1290739002;
            } //End block
            // ---------- Original Method ----------
            //EasyEditSpan[] easyEditSpans = spanned.getSpans(0, spanned.length(),
                    //EasyEditSpan.class);
            //if (easyEditSpans.length == 0) {
                //return null;
            //} else {
                //return easyEditSpans[0];
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.733 -0400", hash_original_field = "518CAC1482FD68AED9B6AA4AE599C5BA", hash_generated_field = "50759637C8B37D549CBDCF2AF0EA1F75")

        private static final int DISPLAY_TIMEOUT_MS = 3000;
    }


    
    private class EasyEditPopupWindow extends PinnedPopupWindow implements OnClickListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.733 -0400", hash_original_field = "2BA836DA894A791F59023D6C9F9022B2", hash_generated_field = "4DBBAC6216F3AE0A070BCCEDE828B9C4")

        private TextView mDeleteTextView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.733 -0400", hash_original_field = "EDF25D09739D26EF9ECAF542864CC487", hash_generated_field = "D79D9256BE9491F92C92FB8BCC6A61DC")

        private EasyEditSpan mEasyEditSpan;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.733 -0400", hash_original_method = "8F35ACDDC3336F80EA4BC14F76358073", hash_generated_method = "8F35ACDDC3336F80EA4BC14F76358073")
        public EasyEditPopupWindow ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.733 -0400", hash_original_method = "57DC4A0271DC22A49F19ED5E582C7E72", hash_generated_method = "B54116FA46C572BBDB8F1D27160DF59E")
        @Override
        protected void createPopupWindow() {
            mPopupWindow = new PopupWindow(TextView.this.mContext, null,
                    com.android.internal.R.attr.textSelectHandleWindowStyle);
            mPopupWindow.setInputMethodMode(PopupWindow.INPUT_METHOD_NOT_NEEDED);
            mPopupWindow.setClippingEnabled(true);
            // ---------- Original Method ----------
            //mPopupWindow = new PopupWindow(TextView.this.mContext, null,
                    //com.android.internal.R.attr.textSelectHandleWindowStyle);
            //mPopupWindow.setInputMethodMode(PopupWindow.INPUT_METHOD_NOT_NEEDED);
            //mPopupWindow.setClippingEnabled(true);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.733 -0400", hash_original_method = "128C0E079A8A50F8B38C36065ADCA0D3", hash_generated_method = "707EC4B09478980B230E9C634DE61A7E")
        @Override
        protected void initContentView() {
            LinearLayout linearLayout = new LinearLayout(TextView.this.getContext());
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            mContentView = linearLayout;
            mContentView.setBackgroundResource(
                    com.android.internal.R.drawable.text_edit_side_paste_window);
            LayoutInflater inflater = (LayoutInflater)TextView.this.mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            LayoutParams wrapContent = new LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            mDeleteTextView = (TextView) inflater.inflate(POPUP_TEXT_LAYOUT, null);
            mDeleteTextView.setLayoutParams(wrapContent);
            mDeleteTextView.setText(com.android.internal.R.string.delete);
            mDeleteTextView.setOnClickListener(this);
            mContentView.addView(mDeleteTextView);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.734 -0400", hash_original_method = "EB30ECB06A4982701AF1B8E86934D288", hash_generated_method = "6C6061653D5DFF66F75183D85AEDB5A1")
        public void show(EasyEditSpan easyEditSpan) {
            mEasyEditSpan = easyEditSpan;
            super.show();
            // ---------- Original Method ----------
            //mEasyEditSpan = easyEditSpan;
            //super.show();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.735 -0400", hash_original_method = "C063208218D3B6E27F261A5578D5D2B9", hash_generated_method = "00CFC07E9EEB2293630A4A81D270A980")
        @Override
        public void onClick(View view) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(view.getTaint());
            if(view == mDeleteTextView)            
            {
                Editable editable = (Editable) mText;
                int start = editable.getSpanStart(mEasyEditSpan);
                int end = editable.getSpanEnd(mEasyEditSpan);
                if(start >= 0 && end >= 0)                
                {
                    deleteText_internal(start, end);
                } //End block
            } //End block
            // ---------- Original Method ----------
            //if (view == mDeleteTextView) {
                //Editable editable = (Editable) mText;
                //int start = editable.getSpanStart(mEasyEditSpan);
                //int end = editable.getSpanEnd(mEasyEditSpan);
                //if (start >= 0 && end >= 0) {
                    //deleteText_internal(start, end);
                //}
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.735 -0400", hash_original_method = "7C1AF53FA575FE23CA1F61E7AC0FA9D9", hash_generated_method = "DA6D63E310ABE3D646E89D194A148F97")
        @Override
        protected int getTextOffset() {
            Editable editable = (Editable) mText;
            int var612F7DFE9A8B759860439242E1F6D4C9_582472380 = (editable.getSpanEnd(mEasyEditSpan));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_491390923 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_491390923;
            // ---------- Original Method ----------
            //Editable editable = (Editable) mText;
            //return editable.getSpanEnd(mEasyEditSpan);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.735 -0400", hash_original_method = "87FFA2F036D6FB2F317732DF596E05CB", hash_generated_method = "8FD078BE5840D0D4A87CEFDD8EAC3B53")
        @Override
        protected int getVerticalLocalPosition(int line) {
            addTaint(line);
            int var435A032D5932929B94102A80759C34DF_711247439 = (mLayout.getLineBottom(line));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1291713267 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1291713267;
            // ---------- Original Method ----------
            //return mLayout.getLineBottom(line);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.735 -0400", hash_original_method = "48C7510506F753F88F1EBACB4F114059", hash_generated_method = "AEBE97E3095BAA0704B985EC2416C80C")
        @Override
        protected int clipVertically(int positionY) {
            addTaint(positionY);
            int varD94FD0654F7DB887E1FD05FDCF20498C_1216855774 = (positionY);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2062929991 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2062929991;
            // ---------- Original Method ----------
            //return positionY;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.735 -0400", hash_original_field = "A8B4CFDAA994C026529F1F31A401F449", hash_generated_field = "9556C9F4A76B40115A0F30878921C774")

        private static final int POPUP_TEXT_LAYOUT = com.android.internal.R.layout.text_edit_action_popup_text;
    }


    
    private class ChangeWatcher implements TextWatcher, SpanWatcher {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.735 -0400", hash_original_field = "8F45542597C289D2929CD8F63821BE5A", hash_generated_field = "9AF7D20EAE94D8E70217DF1DC0F4EBF6")

        private CharSequence mBeforeText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.735 -0400", hash_original_field = "9E7C9CD25D6914A1724D16D10C6EB9C1", hash_generated_field = "B09D56552589EA59BDE2FAB6B8B27882")

        private EasyEditSpanController mEasyEditSpanController;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.735 -0400", hash_original_method = "41973225A14E12423F2683848135C141", hash_generated_method = "ACD55DB72B049A56A0B6E74650948667")
        private  ChangeWatcher() {
            mEasyEditSpanController = new EasyEditSpanController();
            // ---------- Original Method ----------
            //mEasyEditSpanController = new EasyEditSpanController();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.735 -0400", hash_original_method = "720D371807084B06633282B0029EC53C", hash_generated_method = "70BFCD3EDDFEAF72A4C0E24F4A01FF1C")
        public void beforeTextChanged(CharSequence buffer, int start,
                                      int before, int after) {
            addTaint(after);
            addTaint(before);
            addTaint(start);
            if(DEBUG_EXTRACT){ }            if(AccessibilityManager.getInstance(mContext).isEnabled()
                    && !isPasswordInputType(mInputType)
                    && !hasPasswordTransformationMethod())            
            {
                mBeforeText = buffer.toString();
            } //End block
            TextView.this.sendBeforeTextChanged(buffer, start, before, after);
            // ---------- Original Method ----------
            //if (DEBUG_EXTRACT) Log.v(LOG_TAG, "beforeTextChanged start=" + start
                    //+ " before=" + before + " after=" + after + ": " + buffer);
            //if (AccessibilityManager.getInstance(mContext).isEnabled()
                    //&& !isPasswordInputType(mInputType)
                    //&& !hasPasswordTransformationMethod()) {
                //mBeforeText = buffer.toString();
            //}
            //TextView.this.sendBeforeTextChanged(buffer, start, before, after);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.736 -0400", hash_original_method = "94F338CF670251E301395B1B01A5E75A", hash_generated_method = "BB9D42111FA63BA171790FC0D229137E")
        public void onTextChanged(CharSequence buffer, int start,
                                  int before, int after) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(after);
            addTaint(before);
            addTaint(start);
            addTaint(buffer.getTaint());
            if(DEBUG_EXTRACT){ }            TextView.this.handleTextChanged(buffer, start, before, after);
            mEasyEditSpanController.onTextChange(buffer);
            if(AccessibilityManager.getInstance(mContext).isEnabled() &&
                    (isFocused() || isSelected() && isShown()))            
            {
                sendAccessibilityEventTypeViewTextChanged(mBeforeText, start, before, after);
                mBeforeText = null;
            } //End block
            // ---------- Original Method ----------
            //if (DEBUG_EXTRACT) Log.v(LOG_TAG, "onTextChanged start=" + start
                    //+ " before=" + before + " after=" + after + ": " + buffer);
            //TextView.this.handleTextChanged(buffer, start, before, after);
            //mEasyEditSpanController.onTextChange(buffer);
            //if (AccessibilityManager.getInstance(mContext).isEnabled() &&
                    //(isFocused() || isSelected() && isShown())) {
                //sendAccessibilityEventTypeViewTextChanged(mBeforeText, start, before, after);
                //mBeforeText = null;
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.736 -0400", hash_original_method = "36BCFC0FC76553AA6F29D2F790EC381C", hash_generated_method = "1BFE87921C6BD24E216BDED6540AAB2C")
        public void afterTextChanged(Editable buffer) {
            addTaint(buffer.getTaint());
            if(DEBUG_EXTRACT){ }            TextView.this.sendAfterTextChanged(buffer);
            if(MetaKeyKeyListener.getMetaState(buffer, MetaKeyKeyListener.META_SELECTING) != 0)            
            {
                MetaKeyKeyListener.stopSelecting(TextView.this, buffer);
            } //End block
            // ---------- Original Method ----------
            //if (DEBUG_EXTRACT) Log.v(LOG_TAG, "afterTextChanged: " + buffer);
            //TextView.this.sendAfterTextChanged(buffer);
            //if (MetaKeyKeyListener.getMetaState(buffer, MetaKeyKeyListener.META_SELECTING) != 0) {
                //MetaKeyKeyListener.stopSelecting(TextView.this, buffer);
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.736 -0400", hash_original_method = "6F9EDB470C5AD5F1E23596AFEC700ED3", hash_generated_method = "C274118B96CDC51CFC088D18560A5FFB")
        public void onSpanChanged(Spannable buf,
                                  Object what, int s, int e, int st, int en) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(en);
            addTaint(st);
            addTaint(e);
            addTaint(s);
            addTaint(what.getTaint());
            addTaint(buf.getTaint());
            if(DEBUG_EXTRACT){ }            TextView.this.spanChange(buf, what, s, st, e, en);
            // ---------- Original Method ----------
            //if (DEBUG_EXTRACT) Log.v(LOG_TAG, "onSpanChanged s=" + s + " e=" + e
                    //+ " st=" + st + " en=" + en + " what=" + what + ": " + buf);
            //TextView.this.spanChange(buf, what, s, st, e, en);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.736 -0400", hash_original_method = "B2A75CCE31AAD63896365B7E450A433A", hash_generated_method = "19346FA09347897002A66D9DFA1A3972")
        public void onSpanAdded(Spannable buf, Object what, int s, int e) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(e);
            addTaint(s);
            addTaint(what.getTaint());
            addTaint(buf.getTaint());
            if(DEBUG_EXTRACT){ }            TextView.this.spanChange(buf, what, -1, s, -1, e);
            // ---------- Original Method ----------
            //if (DEBUG_EXTRACT) Log.v(LOG_TAG, "onSpanAdded s=" + s + " e=" + e
                    //+ " what=" + what + ": " + buf);
            //TextView.this.spanChange(buf, what, -1, s, -1, e);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.737 -0400", hash_original_method = "11DC5396F5D4F6210F8F1D677B03B553", hash_generated_method = "DE687D72C0DE1F862AE574B258D5A344")
        public void onSpanRemoved(Spannable buf, Object what, int s, int e) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(e);
            addTaint(s);
            addTaint(what.getTaint());
            addTaint(buf.getTaint());
            if(DEBUG_EXTRACT){ }            TextView.this.spanChange(buf, what, s, -1, e, -1);
            // ---------- Original Method ----------
            //if (DEBUG_EXTRACT) Log.v(LOG_TAG, "onSpanRemoved s=" + s + " e=" + e
                    //+ " what=" + what + ": " + buf);
            //TextView.this.spanChange(buf, what, s, -1, e, -1);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.737 -0400", hash_original_method = "FB97DDA9E5EB9C645F7C42D5DCEE1A36", hash_generated_method = "E6D7B22DFBEA218F7C05A2FD98CE4F0E")
        private void hideControllers() {
            mEasyEditSpanController.hide();
            // ---------- Original Method ----------
            //mEasyEditSpanController.hide();
        }

        
    }


    
    private static class Blink extends Handler implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.737 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "378CC9BF8F5DA198EF400A97F72A70A3")

        private WeakReference<TextView> mView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.737 -0400", hash_original_field = "1813307BAF5C3869F23F1AC0318DE4BE", hash_generated_field = "582F041564D3B399F48E8AE230C16FEE")

        private boolean mCancelled;
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.738 -0400", hash_original_method = "B3B341EB4735766A8EE81E50FC9FCC5D", hash_generated_method = "AC11D259FD065166E4248B5E715529DE")
        public  Blink(TextView v) {
            mView = new WeakReference<TextView>(v);
            // ---------- Original Method ----------
            //mView = new WeakReference<TextView>(v);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.738 -0400", hash_original_method = "ACD5284757446306F2E6E1BADED5158A", hash_generated_method = "D10F4B045A1E81F1365855DF88B4139E")
        public void run() {
            if(mCancelled)            
            {
                return;
            } //End block
            removeCallbacks(Blink.this);
            TextView tv = mView.get();
            if(tv != null && tv.shouldBlink())            
            {
                if(tv.mLayout != null)                
                {
                    tv.invalidateCursorPath();
                } //End block
                postAtTime(this, SystemClock.uptimeMillis() + BLINK);
            } //End block
            // ---------- Original Method ----------
            //if (mCancelled) {
                //return;
            //}
            //removeCallbacks(Blink.this);
            //TextView tv = mView.get();
            //if (tv != null && tv.shouldBlink()) {
                //if (tv.mLayout != null) {
                    //tv.invalidateCursorPath();
                //}
                //postAtTime(this, SystemClock.uptimeMillis() + BLINK);
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.738 -0400", hash_original_method = "A015A25EF128A9724656D77FE5A94B9E", hash_generated_method = "78D87A3EDC6157659191215A316DC10B")
         void cancel() {
            if(!mCancelled)            
            {
                removeCallbacks(Blink.this);
                mCancelled = true;
            } //End block
            // ---------- Original Method ----------
            //if (!mCancelled) {
                //removeCallbacks(Blink.this);
                //mCancelled = true;
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.738 -0400", hash_original_method = "A06944554EAF73141DA4277B06D0E2BD", hash_generated_method = "EA43542F6DD16B86D3EB9C7A9CB5E56B")
         void uncancel() {
            mCancelled = false;
            // ---------- Original Method ----------
            //mCancelled = false;
        }

        
    }


    
    public enum BufferType {
        NORMAL, SPANNABLE, EDITABLE,
    }

    
    private static class DragLocalState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.738 -0400", hash_original_field = "D78BADC424EA34A1D9F76B53AD0FC966", hash_generated_field = "71C1F40F965BD09DE6D53C89B0AA9A2B")

        public TextView sourceTextView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.738 -0400", hash_original_field = "EA2B2676C28C0DB26D39331A336C6B92", hash_generated_field = "D3D73C9CC2FDA0D0E8781D6E9A3253AA")

        public int start;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.738 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "109F16BFAE7B1E88A50CE09673D176EC")

        public int end;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.738 -0400", hash_original_method = "78F248ABC93BE1F7C9E297B91A3F7D55", hash_generated_method = "86EC9C6CD36D42E4BFA57141505C8082")
        public  DragLocalState(TextView sourceTextView, int start, int end) {
            this.sourceTextView = sourceTextView;
            this.start = start;
            this.end = end;
            // ---------- Original Method ----------
            //this.sourceTextView = sourceTextView;
            //this.start = start;
            //this.end = end;
        }

        
    }


    
    private class PositionListener implements ViewTreeObserver.OnPreDrawListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.739 -0400", hash_original_field = "05B14654782AB408227B39473652C629", hash_generated_field = "13889737161965075C942E574375D7C9")

        private final int MAXIMUM_NUMBER_OF_LISTENERS = 6;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.739 -0400", hash_original_field = "501DACB43832A22DCD15C3BD00A05F36", hash_generated_field = "6E86BBFEE5AB32BEC4338815D88DA562")

        private TextViewPositionListener[] mPositionListeners = new TextViewPositionListener[MAXIMUM_NUMBER_OF_LISTENERS];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.739 -0400", hash_original_field = "16BC92FD11AF81D9886E550CE0712C57", hash_generated_field = "E1EB7F48AC3DAF5A3BC279FE32D5BD2C")

        private boolean mCanMove[] = new boolean[MAXIMUM_NUMBER_OF_LISTENERS];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.739 -0400", hash_original_field = "03D5F02C0AF2CE2B038F91466D8238BA", hash_generated_field = "348E54253A3677FA237DAA94481A3907")

        private boolean mPositionHasChanged = true;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.739 -0400", hash_original_field = "E33EA5C4D485469D2432B3A781CD5014", hash_generated_field = "B562606C08FEFE4EA880E0BAFC4807BC")

        private int mPositionX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.739 -0400", hash_original_field = "5EF2225F886100AA279B39F41428F3C5", hash_generated_field = "30733FB91B36B499B68F008F42192052")

        private int mPositionY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.739 -0400", hash_original_field = "9EDA655FC50499AF5231120C47804B4D", hash_generated_field = "3FFCBF0CA982B9F89F06AD1BE7BFADF1")

        private int mNumberOfListeners;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.739 -0400", hash_original_field = "C40349F37B1FBD37DCE18B5033BE6961", hash_generated_field = "165D6DE2599A80133D2595B1A8A737DE")

        private boolean mScrollHasChanged;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.739 -0400", hash_original_method = "7156A70387EDCE5A8031F9E196BAE1E0", hash_generated_method = "7156A70387EDCE5A8031F9E196BAE1E0")
        public PositionListener ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.739 -0400", hash_original_method = "2CEF91B445974B7F0C1F2F2831D38171", hash_generated_method = "C06A8054B84135AF3D6CCA9ACE848DA6")
        public void addSubscriber(TextViewPositionListener positionListener, boolean canMove) {
            if(mNumberOfListeners == 0)            
            {
                updatePosition();
                ViewTreeObserver vto = TextView.this.getViewTreeObserver();
                vto.addOnPreDrawListener(this);
            } //End block
            int emptySlotIndex = -1;
for(int i = 0;i < MAXIMUM_NUMBER_OF_LISTENERS;i++)
            {
                TextViewPositionListener listener = mPositionListeners[i];
                if(listener == positionListener)                
                {
                    return;
                } //End block
                else
                if(emptySlotIndex < 0 && listener == null)                
                {
                    emptySlotIndex = i;
                } //End block
            } //End block
            mPositionListeners[emptySlotIndex] = positionListener;
            mCanMove[emptySlotIndex] = canMove;
            mNumberOfListeners++;
            // ---------- Original Method ----------
            //if (mNumberOfListeners == 0) {
                //updatePosition();
                //ViewTreeObserver vto = TextView.this.getViewTreeObserver();
                //vto.addOnPreDrawListener(this);
            //}
            //int emptySlotIndex = -1;
            //for (int i = 0; i < MAXIMUM_NUMBER_OF_LISTENERS; i++) {
                //TextViewPositionListener listener = mPositionListeners[i];
                //if (listener == positionListener) {
                    //return;
                //} else if (emptySlotIndex < 0 && listener == null) {
                    //emptySlotIndex = i;
                //}
            //}
            //mPositionListeners[emptySlotIndex] = positionListener;
            //mCanMove[emptySlotIndex] = canMove;
            //mNumberOfListeners++;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.739 -0400", hash_original_method = "F36C99880C8165921A7F03E512CBB647", hash_generated_method = "D0CB5BF2781151618EE65688B30C2E14")
        public void removeSubscriber(TextViewPositionListener positionListener) {
            addTaint(positionListener.getTaint());
for(int i = 0;i < MAXIMUM_NUMBER_OF_LISTENERS;i++)
            {
                if(mPositionListeners[i] == positionListener)                
                {
                    mPositionListeners[i] = null;
                    mNumberOfListeners--;
                    break;
                } //End block
            } //End block
            if(mNumberOfListeners == 0)            
            {
                ViewTreeObserver vto = TextView.this.getViewTreeObserver();
                vto.removeOnPreDrawListener(this);
            } //End block
            // ---------- Original Method ----------
            //for (int i = 0; i < MAXIMUM_NUMBER_OF_LISTENERS; i++) {
                //if (mPositionListeners[i] == positionListener) {
                    //mPositionListeners[i] = null;
                    //mNumberOfListeners--;
                    //break;
                //}
            //}
            //if (mNumberOfListeners == 0) {
                //ViewTreeObserver vto = TextView.this.getViewTreeObserver();
                //vto.removeOnPreDrawListener(this);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.740 -0400", hash_original_method = "256A376A54FD4CD53D18A0F020A0467C", hash_generated_method = "3063FB24DD863FF813416BE95A86E2D5")
        public int getPositionX() {
            int varE33EA5C4D485469D2432B3A781CD5014_1838711009 = (mPositionX);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1259184013 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1259184013;
            // ---------- Original Method ----------
            //return mPositionX;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.740 -0400", hash_original_method = "4CCC26BBD5544F9405CBD90295EAF862", hash_generated_method = "FE668EE2187A3D51B856824A0E98D238")
        public int getPositionY() {
            int var5EF2225F886100AA279B39F41428F3C5_1713484920 = (mPositionY);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2099642731 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2099642731;
            // ---------- Original Method ----------
            //return mPositionY;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.740 -0400", hash_original_method = "4634D6360837F07AB476144D9CD27591", hash_generated_method = "F7A254578EA52A8DE88E244300B78DD1")
        @Override
        public boolean onPreDraw() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            updatePosition();
for(int i = 0;i < MAXIMUM_NUMBER_OF_LISTENERS;i++)
            {
                if(mPositionHasChanged || mScrollHasChanged || mCanMove[i])                
                {
                    TextViewPositionListener positionListener = mPositionListeners[i];
                    if(positionListener != null)                    
                    {
                        positionListener.updatePosition(mPositionX, mPositionY,
                                mPositionHasChanged, mScrollHasChanged);
                    } //End block
                } //End block
            } //End block
            mScrollHasChanged = false;
            boolean varB326B5062B2F0E69046810717534CB09_258571434 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_311704821 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_311704821;
            // ---------- Original Method ----------
            //updatePosition();
            //for (int i = 0; i < MAXIMUM_NUMBER_OF_LISTENERS; i++) {
                //if (mPositionHasChanged || mScrollHasChanged || mCanMove[i]) {
                    //TextViewPositionListener positionListener = mPositionListeners[i];
                    //if (positionListener != null) {
                        //positionListener.updatePosition(mPositionX, mPositionY,
                                //mPositionHasChanged, mScrollHasChanged);
                    //}
                //}
            //}
            //mScrollHasChanged = false;
            //return true;
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.740 -0400", hash_original_method = "65C89C768DE236BFCC52E144F22BF85B", hash_generated_method = "142481B1DEA1328234C9335DBA74DC0E")
        private void updatePosition() {
            TextView.this.getLocationInWindow(mTempCoords);
            mPositionHasChanged = mTempCoords[0] != mPositionX || mTempCoords[1] != mPositionY;
            mPositionX = mTempCoords[0];
            mPositionY = mTempCoords[1];
            // ---------- Original Method ----------
            //TextView.this.getLocationInWindow(mTempCoords);
            //mPositionHasChanged = mTempCoords[0] != mPositionX || mTempCoords[1] != mPositionY;
            //mPositionX = mTempCoords[0];
            //mPositionY = mTempCoords[1];
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.740 -0400", hash_original_method = "45AFA571A6FC9FC84FC093F1FB86DABC", hash_generated_method = "85B5F4ED6EC23E44740E0F696105857A")
        public void onScrollChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mScrollHasChanged = true;
            // ---------- Original Method ----------
            //mScrollHasChanged = true;
        }

        
    }


    
    private abstract class PinnedPopupWindow implements TextViewPositionListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.741 -0400", hash_original_field = "BF75305BD1095CDED8E2337DB678670B", hash_generated_field = "5CD7D447C671D86883FAE32274213485")

        protected PopupWindow mPopupWindow;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.741 -0400", hash_original_field = "9E8FE4D07A56D54AEE159583A4429FE8", hash_generated_field = "B572FFE44EB19A4D34C75C5D0C555606")

        protected ViewGroup mContentView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.741 -0400", hash_original_field = "E33EA5C4D485469D2432B3A781CD5014", hash_generated_field = "2AF62DB1E3AEF057C912EFF081692BF4")

        int mPositionX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.741 -0400", hash_original_field = "5EF2225F886100AA279B39F41428F3C5", hash_generated_field = "81023086806A696B7ADDE3F7B5299B8C")

        int mPositionY;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.742 -0400", hash_original_method = "596A5600AE60FE2F4CDE653E6E3819B3", hash_generated_method = "01EC73D717B3F29758BEDF20643E55B9")
        public  PinnedPopupWindow() {
            createPopupWindow();
            mPopupWindow.setWindowLayoutType(WindowManager.LayoutParams.TYPE_APPLICATION_SUB_PANEL);
            mPopupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
            mPopupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
            initContentView();
            LayoutParams wrapContent = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            mContentView.setLayoutParams(wrapContent);
            mPopupWindow.setContentView(mContentView);
            // ---------- Original Method ----------
            //createPopupWindow();
            //mPopupWindow.setWindowLayoutType(WindowManager.LayoutParams.TYPE_APPLICATION_SUB_PANEL);
            //mPopupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
            //mPopupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
            //initContentView();
            //LayoutParams wrapContent = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    //ViewGroup.LayoutParams.WRAP_CONTENT);
            //mContentView.setLayoutParams(wrapContent);
            //mPopupWindow.setContentView(mContentView);
        }

        
        @DSModeled(DSC.SAFE)
        protected abstract void createPopupWindow();

        
        @DSModeled(DSC.SAFE)
        protected abstract void initContentView();

        
        @DSModeled(DSC.SAFE)
        protected abstract int getTextOffset();

        
        @DSModeled(DSC.SAFE)
        protected abstract int getVerticalLocalPosition(int line);

        
        @DSModeled(DSC.SAFE)
        protected abstract int clipVertically(int positionY);

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.742 -0400", hash_original_method = "6C3D8663E8D10274240ADCEB82AE9A86", hash_generated_method = "A71F79A81A0A6F7C5908F0DE1A89F2A5")
        public void show() {
            TextView.this.getPositionListener().addSubscriber(this, false );
            computeLocalPosition();
            final PositionListener positionListener = TextView.this.getPositionListener();
            updatePosition(positionListener.getPositionX(), positionListener.getPositionY());
            // ---------- Original Method ----------
            //TextView.this.getPositionListener().addSubscriber(this, false );
            //computeLocalPosition();
            //final PositionListener positionListener = TextView.this.getPositionListener();
            //updatePosition(positionListener.getPositionX(), positionListener.getPositionY());
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.743 -0400", hash_original_method = "AFC1F8ABC6317EB9C1F375A956F1E985", hash_generated_method = "0FD7351E3EA8C4EE2606A9571E75F5B5")
        protected void measureContent() {
            final DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
            mContentView.measure(
                    View.MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels,
                            View.MeasureSpec.AT_MOST),
                    View.MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels,
                            View.MeasureSpec.AT_MOST));
            // ---------- Original Method ----------
            //final DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
            //mContentView.measure(
                    //View.MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels,
                            //View.MeasureSpec.AT_MOST),
                    //View.MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels,
                            //View.MeasureSpec.AT_MOST));
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.743 -0400", hash_original_method = "422A968B45C30695D0BEB603E4E72147", hash_generated_method = "955784FFC248E24BE96CF71A5E1A5734")
        private void computeLocalPosition() {
            measureContent();
            final int width = mContentView.getMeasuredWidth();
            final int offset = getTextOffset();
            mPositionX = (int) (mLayout.getPrimaryHorizontal(offset) - width / 2.0f);
            mPositionX += viewportToContentHorizontalOffset();
            final int line = mLayout.getLineForOffset(offset);
            mPositionY = getVerticalLocalPosition(line);
            mPositionY += viewportToContentVerticalOffset();
            // ---------- Original Method ----------
            //measureContent();
            //final int width = mContentView.getMeasuredWidth();
            //final int offset = getTextOffset();
            //mPositionX = (int) (mLayout.getPrimaryHorizontal(offset) - width / 2.0f);
            //mPositionX += viewportToContentHorizontalOffset();
            //final int line = mLayout.getLineForOffset(offset);
            //mPositionY = getVerticalLocalPosition(line);
            //mPositionY += viewportToContentVerticalOffset();
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.743 -0400", hash_original_method = "3C2767EB11AB639449E091DD5FC9CB2A", hash_generated_method = "D3F3911948680A94436053456B0A6302")
        private void updatePosition(int parentPositionX, int parentPositionY) {
            addTaint(parentPositionY);
            addTaint(parentPositionX);
            int positionX = parentPositionX + mPositionX;
            int positionY = parentPositionY + mPositionY;
            positionY = clipVertically(positionY);
            final DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
            final int width = mContentView.getMeasuredWidth();
            positionX = Math.min(displayMetrics.widthPixels - width, positionX);
            positionX = Math.max(0, positionX);
            if(isShowing())            
            {
                mPopupWindow.update(positionX, positionY, -1, -1);
            } //End block
            else
            {
                mPopupWindow.showAtLocation(TextView.this, Gravity.NO_GRAVITY,
                        positionX, positionY);
            } //End block
            // ---------- Original Method ----------
            //int positionX = parentPositionX + mPositionX;
            //int positionY = parentPositionY + mPositionY;
            //positionY = clipVertically(positionY);
            //final DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
            //final int width = mContentView.getMeasuredWidth();
            //positionX = Math.min(displayMetrics.widthPixels - width, positionX);
            //positionX = Math.max(0, positionX);
            //if (isShowing()) {
                //mPopupWindow.update(positionX, positionY, -1, -1);
            //} else {
                //mPopupWindow.showAtLocation(TextView.this, Gravity.NO_GRAVITY,
                        //positionX, positionY);
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.744 -0400", hash_original_method = "9C51A5E6940629038A75840F54DCC577", hash_generated_method = "25525D9132782287790F8AECFEF17792")
        public void hide() {
            mPopupWindow.dismiss();
            TextView.this.getPositionListener().removeSubscriber(this);
            // ---------- Original Method ----------
            //mPopupWindow.dismiss();
            //TextView.this.getPositionListener().removeSubscriber(this);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.747 -0400", hash_original_method = "48D3C5BA4737FA32BEEBA9E620F4B3A6", hash_generated_method = "A5F009422C89F05CDBDE53DCC6895765")
        @Override
        public void updatePosition(int parentPositionX, int parentPositionY,
                boolean parentPositionChanged, boolean parentScrolled) {
            addTaint(parentScrolled);
            addTaint(parentPositionChanged);
            addTaint(parentPositionY);
            addTaint(parentPositionX);
            if(isShowing() && isOffsetVisible(getTextOffset()))            
            {
                if(parentScrolled)                
                computeLocalPosition();
                updatePosition(parentPositionX, parentPositionY);
            } //End block
            else
            {
                hide();
            } //End block
            // ---------- Original Method ----------
            //if (isShowing() && isOffsetVisible(getTextOffset())) {
                //if (parentScrolled) computeLocalPosition();
                //updatePosition(parentPositionX, parentPositionY);
            //} else {
                //hide();
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.748 -0400", hash_original_method = "771871BA8F1191126AB0990E72BA0594", hash_generated_method = "83D6A63DD9E3E2D0ADBF09A9F874FADE")
        public boolean isShowing() {
            boolean varCCC5E8F01B3AC7363903BBA925DC9538_1322378062 = (mPopupWindow.isShowing());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1588499478 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1588499478;
            // ---------- Original Method ----------
            //return mPopupWindow.isShowing();
        }

        
    }


    
    private class SuggestionsPopupWindow extends PinnedPopupWindow implements OnItemClickListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.748 -0400", hash_original_field = "0FA91084880C72F330A5711F5C8F7294", hash_generated_field = "DF9B2B2A32C54D35B3228EF58FDC6E78")

        private SuggestionInfo[] mSuggestionInfos;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.748 -0400", hash_original_field = "ABFE2C764E01946613EA91131C55961C", hash_generated_field = "596DE3763E763BE0F497615E1944F22C")

        private int mNumberOfSuggestions;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.748 -0400", hash_original_field = "033E344F7E287345FE0C52A3E5D61018", hash_generated_field = "7F93C534F2DFE71AE91870F5785F473D")

        private boolean mCursorWasVisibleBeforeSuggestions;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.748 -0400", hash_original_field = "CE1B361D3F408CDB879798047244ECC3", hash_generated_field = "641DA69AA28F49EC5C5A62A58B67E06A")

        private boolean mIsShowingUp = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.748 -0400", hash_original_field = "63055E537713F24C4C86BE6E68415FCE", hash_generated_field = "EC7957C4E8F88AF8C25BE753B9E15A66")

        private SuggestionAdapter mSuggestionsAdapter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.748 -0400", hash_original_field = "220190CD1D81D70302E1152A714AE917", hash_generated_field = "B69BA7FB6136A02593E4286BE8CED5FC")

        private Comparator<SuggestionSpan> mSuggestionSpanComparator;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.748 -0400", hash_original_field = "317A49877C593D0434BEE0A1DE61C446", hash_generated_field = "D0B23D9D75631218A54DFB41905818F7")

        private HashMap<SuggestionSpan, Integer> mSpansLengths;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.748 -0400", hash_original_method = "296BEE5065EB2EF8F82574E0F3647EF2", hash_generated_method = "C9FE2AEB77D5E42436EC81728FF2A6EB")
        public  SuggestionsPopupWindow() {
            mCursorWasVisibleBeforeSuggestions = mCursorVisible;
            mSuggestionSpanComparator = new SuggestionSpanComparator();
            mSpansLengths = new HashMap<SuggestionSpan, Integer>();
            // ---------- Original Method ----------
            //mCursorWasVisibleBeforeSuggestions = mCursorVisible;
            //mSuggestionSpanComparator = new SuggestionSpanComparator();
            //mSpansLengths = new HashMap<SuggestionSpan, Integer>();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.749 -0400", hash_original_method = "2C5A34402E22C878AD33972323D3ACC4", hash_generated_method = "1D075CDCA4E55E9BDBE0B58CE507DA50")
        @Override
        protected void createPopupWindow() {
            mPopupWindow = new CustomPopupWindow(TextView.this.mContext,
                com.android.internal.R.attr.textSuggestionsWindowStyle);
            mPopupWindow.setInputMethodMode(PopupWindow.INPUT_METHOD_NOT_NEEDED);
            mPopupWindow.setFocusable(true);
            mPopupWindow.setClippingEnabled(false);
            // ---------- Original Method ----------
            //mPopupWindow = new CustomPopupWindow(TextView.this.mContext,
                //com.android.internal.R.attr.textSuggestionsWindowStyle);
            //mPopupWindow.setInputMethodMode(PopupWindow.INPUT_METHOD_NOT_NEEDED);
            //mPopupWindow.setFocusable(true);
            //mPopupWindow.setClippingEnabled(false);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.750 -0400", hash_original_method = "E003230CE90A2ACB93D34E336B67EF46", hash_generated_method = "F47B89CBDE02EDD45CC91130832F4A13")
        @Override
        protected void initContentView() {
            ListView listView = new ListView(TextView.this.getContext());
            mSuggestionsAdapter = new SuggestionAdapter();
            listView.setAdapter(mSuggestionsAdapter);
            listView.setOnItemClickListener(this);
            mContentView = listView;
            mSuggestionInfos = new SuggestionInfo[MAX_NUMBER_SUGGESTIONS + 2];
for(int i = 0;i < mSuggestionInfos.length;i++)
            {
                mSuggestionInfos[i] = new SuggestionInfo();
            } //End block
            // ---------- Original Method ----------
            //ListView listView = new ListView(TextView.this.getContext());
            //mSuggestionsAdapter = new SuggestionAdapter();
            //listView.setAdapter(mSuggestionsAdapter);
            //listView.setOnItemClickListener(this);
            //mContentView = listView;
            //mSuggestionInfos = new SuggestionInfo[MAX_NUMBER_SUGGESTIONS + 2];
            //for (int i = 0; i < mSuggestionInfos.length; i++) {
                //mSuggestionInfos[i] = new SuggestionInfo();
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.750 -0400", hash_original_method = "4C7853BA5C99567CAD84815F4452E5F9", hash_generated_method = "A5966679CC791B78915FAA7E98A8146C")
        public boolean isShowingUp() {
            boolean varFBE3BF7B4E08958CFC4457A5B9A0C772_2105053387 = (mIsShowingUp);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_541714545 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_541714545;
            // ---------- Original Method ----------
            //return mIsShowingUp;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.751 -0400", hash_original_method = "3914DCDC5DB3E14D1A1A163B7497EFBA", hash_generated_method = "CBD237ACC458BFEA613530AFCAFC26CB")
        public void onParentLostFocus() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mIsShowingUp = false;
            // ---------- Original Method ----------
            //mIsShowingUp = false;
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.751 -0400", hash_original_method = "A21D81008594D05973BC33E2948715E2", hash_generated_method = "D6E45606332941EF61CDA0FFA8EE34C6")
        private SuggestionSpan[] getSuggestionSpans() {
            int pos = TextView.this.getSelectionStart();
            Spannable spannable = (Spannable) TextView.this.mText;
            SuggestionSpan[] suggestionSpans = spannable.getSpans(pos, pos, SuggestionSpan.class);
            mSpansLengths.clear();
for(SuggestionSpan suggestionSpan : suggestionSpans)
            {
                int start = spannable.getSpanStart(suggestionSpan);
                int end = spannable.getSpanEnd(suggestionSpan);
                mSpansLengths.put(suggestionSpan, Integer.valueOf(end - start));
            } //End block
            Arrays.sort(suggestionSpans, mSuggestionSpanComparator);
SuggestionSpan[] var2DB3EFC76D1F9600D2B0C5A32150EB70_678611915 =             suggestionSpans;
            var2DB3EFC76D1F9600D2B0C5A32150EB70_678611915.addTaint(taint);
            return var2DB3EFC76D1F9600D2B0C5A32150EB70_678611915;
            // ---------- Original Method ----------
            //int pos = TextView.this.getSelectionStart();
            //Spannable spannable = (Spannable) TextView.this.mText;
            //SuggestionSpan[] suggestionSpans = spannable.getSpans(pos, pos, SuggestionSpan.class);
            //mSpansLengths.clear();
            //for (SuggestionSpan suggestionSpan : suggestionSpans) {
                //int start = spannable.getSpanStart(suggestionSpan);
                //int end = spannable.getSpanEnd(suggestionSpan);
                //mSpansLengths.put(suggestionSpan, Integer.valueOf(end - start));
            //}
            //Arrays.sort(suggestionSpans, mSuggestionSpanComparator);
            //return suggestionSpans;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.751 -0400", hash_original_method = "C166DC70ACC1835B92197E48CEB369FC", hash_generated_method = "BCC2165163A105CDAD8E1AEDED17C604")
        @Override
        public void show() {
            if(!(mText instanceof Editable))            
            return;
            updateSuggestions();
            mCursorWasVisibleBeforeSuggestions = mCursorVisible;
            setCursorVisible(false);
            mIsShowingUp = true;
            super.show();
            // ---------- Original Method ----------
            //if (!(mText instanceof Editable)) return;
            //updateSuggestions();
            //mCursorWasVisibleBeforeSuggestions = mCursorVisible;
            //setCursorVisible(false);
            //mIsShowingUp = true;
            //super.show();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.752 -0400", hash_original_method = "8DDB7ED8B40AC8DC3D4FF9060DA06A2E", hash_generated_method = "DDEEC2D469D6F5553EA43210C3DCE0F7")
        @Override
        protected void measureContent() {
            final DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
            final int horizontalMeasure = View.MeasureSpec.makeMeasureSpec(
                    displayMetrics.widthPixels, View.MeasureSpec.AT_MOST);
            final int verticalMeasure = View.MeasureSpec.makeMeasureSpec(
                    displayMetrics.heightPixels, View.MeasureSpec.AT_MOST);
            int width = 0;
            View view = null;
for(int i = 0;i < mNumberOfSuggestions;i++)
            {
                view = mSuggestionsAdapter.getView(i, view, mContentView);
                view.getLayoutParams().width = LayoutParams.WRAP_CONTENT;
                view.measure(horizontalMeasure, verticalMeasure);
                width = Math.max(width, view.getMeasuredWidth());
            } //End block
            mContentView.measure(
                    View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY),
                    verticalMeasure);
            Drawable popupBackground = mPopupWindow.getBackground();
            if(popupBackground != null)            
            {
                if(mTempRect == null)                
                mTempRect = new Rect();
                popupBackground.getPadding(mTempRect);
                width += mTempRect.left + mTempRect.right;
            } //End block
            mPopupWindow.setWidth(width);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.752 -0400", hash_original_method = "6820F3398D40FE1AF57F321A0934E9B8", hash_generated_method = "444CE6E632A284C22F44AB3A88B45518")
        @Override
        protected int getTextOffset() {
            int varD0EF21DEE321178D1D33CB6396A544C8_1989707826 = (getSelectionStart());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_977517889 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_977517889;
            // ---------- Original Method ----------
            //return getSelectionStart();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.752 -0400", hash_original_method = "87FFA2F036D6FB2F317732DF596E05CB", hash_generated_method = "8644486021A4671DD4005BA17FAAAA9A")
        @Override
        protected int getVerticalLocalPosition(int line) {
            addTaint(line);
            int var435A032D5932929B94102A80759C34DF_159645609 = (mLayout.getLineBottom(line));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1210903873 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1210903873;
            // ---------- Original Method ----------
            //return mLayout.getLineBottom(line);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.752 -0400", hash_original_method = "BF4D66DCAEE7C7EAD97F70105958840C", hash_generated_method = "6CA760B103F08F8804F1C6E01FD70B4D")
        @Override
        protected int clipVertically(int positionY) {
            addTaint(positionY);
            final int height = mContentView.getMeasuredHeight();
            final DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
            int var2D7853AD03A05471785721A50745516A_505959072 = (Math.min(positionY, displayMetrics.heightPixels - height));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1003397357 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1003397357;
            // ---------- Original Method ----------
            //final int height = mContentView.getMeasuredHeight();
            //final DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
            //return Math.min(positionY, displayMetrics.heightPixels - height);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.752 -0400", hash_original_method = "7609E0B22D3FA397AAE3B56DEE3F8C83", hash_generated_method = "F131B81970709DA64760DF4AAFB46819")
        @Override
        public void hide() {
            super.hide();
            // ---------- Original Method ----------
            //super.hide();
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.755 -0400", hash_original_method = "43D89583824EB2CC5185C1DC5EA2D76A", hash_generated_method = "91050B141F482145E42C32509BB5E147")
        private void updateSuggestions() {
            Spannable spannable = (Spannable) TextView.this.mText;
            SuggestionSpan[] suggestionSpans = getSuggestionSpans();
            final int nbSpans = suggestionSpans.length;
            mNumberOfSuggestions = 0;
            int spanUnionStart = mText.length();
            int spanUnionEnd = 0;
            SuggestionSpan misspelledSpan = null;
            int underlineColor = 0;
for(int spanIndex = 0;spanIndex < nbSpans;spanIndex++)
            {
                SuggestionSpan suggestionSpan = suggestionSpans[spanIndex];
                final int spanStart = spannable.getSpanStart(suggestionSpan);
                final int spanEnd = spannable.getSpanEnd(suggestionSpan);
                spanUnionStart = Math.min(spanStart, spanUnionStart);
                spanUnionEnd = Math.max(spanEnd, spanUnionEnd);
                if((suggestionSpan.getFlags() & SuggestionSpan.FLAG_MISSPELLED) != 0)                
                {
                    misspelledSpan = suggestionSpan;
                } //End block
                if(spanIndex == 0)                
                underlineColor = suggestionSpan.getUnderlineColor();
                String[] suggestions = suggestionSpan.getSuggestions();
                int nbSuggestions = suggestions.length;
for(int suggestionIndex = 0;suggestionIndex < nbSuggestions;suggestionIndex++)
                {
                    SuggestionInfo suggestionInfo = mSuggestionInfos[mNumberOfSuggestions];
                    suggestionInfo.suggestionSpan = suggestionSpan;
                    suggestionInfo.suggestionIndex = suggestionIndex;
                    suggestionInfo.text.replace(0, suggestionInfo.text.length(),
                            suggestions[suggestionIndex]);
                    mNumberOfSuggestions++;
                    if(mNumberOfSuggestions == MAX_NUMBER_SUGGESTIONS)                    
                    {
                        spanIndex = nbSpans;
                        break;
                    } //End block
                } //End block
            } //End block
for(int i = 0;i < mNumberOfSuggestions;i++)
            {
                highlightTextDifferences(mSuggestionInfos[i], spanUnionStart, spanUnionEnd);
            } //End block
            if(misspelledSpan != null)            
            {
                final int misspelledStart = spannable.getSpanStart(misspelledSpan);
                final int misspelledEnd = spannable.getSpanEnd(misspelledSpan);
                if(misspelledStart >= 0 && misspelledEnd > misspelledStart)                
                {
                    SuggestionInfo suggestionInfo = mSuggestionInfos[mNumberOfSuggestions];
                    suggestionInfo.suggestionSpan = misspelledSpan;
                    suggestionInfo.suggestionIndex = ADD_TO_DICTIONARY;
                    suggestionInfo.text.replace(0, suggestionInfo.text.length(),
                            getContext().getString(com.android.internal.R.string.addToDictionary));
                    suggestionInfo.text.setSpan(suggestionInfo.highlightSpan, 0, 0,
                            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    mNumberOfSuggestions++;
                } //End block
            } //End block
            SuggestionInfo suggestionInfo = mSuggestionInfos[mNumberOfSuggestions];
            suggestionInfo.suggestionSpan = null;
            suggestionInfo.suggestionIndex = DELETE_TEXT;
            suggestionInfo.text.replace(0, suggestionInfo.text.length(),
                    getContext().getString(com.android.internal.R.string.deleteText));
            suggestionInfo.text.setSpan(suggestionInfo.highlightSpan, 0, 0,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            mNumberOfSuggestions++;
            if(mSuggestionRangeSpan == null)            
            mSuggestionRangeSpan = new SuggestionRangeSpan();
            if(underlineColor == 0)            
            {
                mSuggestionRangeSpan.setBackgroundColor(mHighlightColor);
            } //End block
            else
            {
                final float BACKGROUND_TRANSPARENCY = 0.4f;
                final int newAlpha = (int) (Color.alpha(underlineColor) * BACKGROUND_TRANSPARENCY);
                mSuggestionRangeSpan.setBackgroundColor(
                        (underlineColor & 0x00FFFFFF) + (newAlpha << 24));
            } //End block
            spannable.setSpan(mSuggestionRangeSpan, spanUnionStart, spanUnionEnd,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            mSuggestionsAdapter.notifyDataSetChanged();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.756 -0400", hash_original_method = "9587A8E163DBC119C2F6F3B6CD33F02D", hash_generated_method = "D1A567DA1D7AAEE3173FAF65B98E8E7A")
        private void highlightTextDifferences(SuggestionInfo suggestionInfo, int unionStart,
                int unionEnd) {
            addTaint(unionEnd);
            addTaint(unionStart);
            addTaint(suggestionInfo.getTaint());
            final Spannable text = (Spannable) mText;
            final int spanStart = text.getSpanStart(suggestionInfo.suggestionSpan);
            final int spanEnd = text.getSpanEnd(suggestionInfo.suggestionSpan);
            suggestionInfo.suggestionStart = spanStart - unionStart;
            suggestionInfo.suggestionEnd = suggestionInfo.suggestionStart 
                    + suggestionInfo.text.length();
            suggestionInfo.text.setSpan(suggestionInfo.highlightSpan, 0,
                    suggestionInfo.text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            suggestionInfo.text.insert(0, mText.toString().substring(unionStart, spanStart));
            suggestionInfo.text.append(mText.toString().substring(spanEnd, unionEnd));
            // ---------- Original Method ----------
            //final Spannable text = (Spannable) mText;
            //final int spanStart = text.getSpanStart(suggestionInfo.suggestionSpan);
            //final int spanEnd = text.getSpanEnd(suggestionInfo.suggestionSpan);
            //suggestionInfo.suggestionStart = spanStart - unionStart;
            //suggestionInfo.suggestionEnd = suggestionInfo.suggestionStart 
                    //+ suggestionInfo.text.length();
            //suggestionInfo.text.setSpan(suggestionInfo.highlightSpan, 0,
                    //suggestionInfo.text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            //suggestionInfo.text.insert(0, mText.toString().substring(unionStart, spanStart));
            //suggestionInfo.text.append(mText.toString().substring(spanEnd, unionEnd));
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.757 -0400", hash_original_method = "73388536B046BC3C58C91A89E4930696", hash_generated_method = "4628B191044736F7B2977FA6007EB732")
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(id);
            addTaint(position);
            addTaint(view.getTaint());
            addTaint(parent.getTaint());
            Editable editable = (Editable) mText;
            SuggestionInfo suggestionInfo = mSuggestionInfos[position];
            if(suggestionInfo.suggestionIndex == DELETE_TEXT)            
            {
                final int spanUnionStart = editable.getSpanStart(mSuggestionRangeSpan);
                int spanUnionEnd = editable.getSpanEnd(mSuggestionRangeSpan);
                if(spanUnionStart >= 0 && spanUnionEnd > spanUnionStart)                
                {
                    if(spanUnionEnd < editable.length() &&
                            Character.isSpaceChar(editable.charAt(spanUnionEnd)) &&
                            (spanUnionStart == 0 ||
                            Character.isSpaceChar(editable.charAt(spanUnionStart - 1))))                    
                    {
                        spanUnionEnd = spanUnionEnd + 1;
                    } //End block
                    deleteText_internal(spanUnionStart, spanUnionEnd);
                } //End block
                hide();
                return;
            } //End block
            final int spanStart = editable.getSpanStart(suggestionInfo.suggestionSpan);
            final int spanEnd = editable.getSpanEnd(suggestionInfo.suggestionSpan);
            if(spanStart < 0 || spanEnd <= spanStart)            
            {
                hide();
                return;
            } //End block
            final String originalText = mText.toString().substring(spanStart, spanEnd);
            if(suggestionInfo.suggestionIndex == ADD_TO_DICTIONARY)            
            {
                Intent intent = new Intent(Settings.ACTION_USER_DICTIONARY_INSERT);
                intent.putExtra("word", originalText);
                intent.putExtra("locale", getTextServicesLocale().toString());
                intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_NEW_TASK);
                getContext().startActivity(intent);
                editable.removeSpan(suggestionInfo.suggestionSpan);
                updateSpellCheckSpans(spanStart, spanEnd, false);
            } //End block
            else
            {
                SuggestionSpan[] suggestionSpans = editable.getSpans(spanStart, spanEnd,
                        SuggestionSpan.class);
                final int length = suggestionSpans.length;
                int[] suggestionSpansStarts = new int[length];
                int[] suggestionSpansEnds = new int[length];
                int[] suggestionSpansFlags = new int[length];
for(int i = 0;i < length;i++)
                {
                    final SuggestionSpan suggestionSpan = suggestionSpans[i];
                    suggestionSpansStarts[i] = editable.getSpanStart(suggestionSpan);
                    suggestionSpansEnds[i] = editable.getSpanEnd(suggestionSpan);
                    suggestionSpansFlags[i] = editable.getSpanFlags(suggestionSpan);
                    int suggestionSpanFlags = suggestionSpan.getFlags();
                    if((suggestionSpanFlags & SuggestionSpan.FLAG_MISSPELLED) > 0)                    
                    {
                        suggestionSpanFlags &= ~SuggestionSpan.FLAG_MISSPELLED;
                        suggestionSpanFlags &= ~SuggestionSpan.FLAG_EASY_CORRECT;
                        suggestionSpan.setFlags(suggestionSpanFlags);
                    } //End block
                } //End block
                final int suggestionStart = suggestionInfo.suggestionStart;
                final int suggestionEnd = suggestionInfo.suggestionEnd;
                final String suggestion = suggestionInfo.text.subSequence(
                        suggestionStart, suggestionEnd).toString();
                replaceText_internal(spanStart, spanEnd, suggestion);
                if(!TextUtils.isEmpty(
                        suggestionInfo.suggestionSpan.getNotificationTargetClassName()))                
                {
                    InputMethodManager imm = InputMethodManager.peekInstance();
                    if(imm != null)                    
                    {
                        imm.notifySuggestionPicked(suggestionInfo.suggestionSpan, originalText,
                                suggestionInfo.suggestionIndex);
                    } //End block
                } //End block
                String[] suggestions = suggestionInfo.suggestionSpan.getSuggestions();
                suggestions[suggestionInfo.suggestionIndex] = originalText;
                final int lengthDifference = suggestion.length() - (spanEnd - spanStart);
for(int i = 0;i < length;i++)
                {
                    if(suggestionSpansStarts[i] <= spanStart &&
                            suggestionSpansEnds[i] >= spanEnd)                    
                    {
                        setSpan_internal(suggestionSpans[i], suggestionSpansStarts[i],
                                suggestionSpansEnds[i] + lengthDifference, suggestionSpansFlags[i]);
                    } //End block
                } //End block
                final int newCursorPosition = spanEnd + lengthDifference;
                setCursorPosition_internal(newCursorPosition, newCursorPosition);
            } //End block
            hide();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        private class CustomPopupWindow extends PopupWindow {
            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.758 -0400", hash_original_method = "76E50B1843F1484B0424D837A17373EE", hash_generated_method = "9831B5F90B8DE08A2381BE4141017AC7")
            public  CustomPopupWindow(Context context, int defStyle) {
                super(context, null, defStyle);
                addTaint(defStyle);
                addTaint(context.getTaint());
                // ---------- Original Method ----------
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.758 -0400", hash_original_method = "3CF42E745499FBF7012823B6BEAA6E8B", hash_generated_method = "C8CBE2AFBCB4FE72843F29026D4AB90D")
            @Override
            public void dismiss() {
                super.dismiss();
                TextView.this.getPositionListener().removeSubscriber(SuggestionsPopupWindow.this);
                ((Spannable) mText).removeSpan(mSuggestionRangeSpan);
                setCursorVisible(mCursorWasVisibleBeforeSuggestions);
                if(hasInsertionController())                
                {
                    getInsertionController().show();
                } //End block
                // ---------- Original Method ----------
                //super.dismiss();
                //TextView.this.getPositionListener().removeSubscriber(SuggestionsPopupWindow.this);
                //((Spannable) mText).removeSpan(mSuggestionRangeSpan);
                //setCursorVisible(mCursorWasVisibleBeforeSuggestions);
                //if (hasInsertionController()) {
                    //getInsertionController().show(); 
                //}
            }

            
        }


        
        private class SuggestionInfo {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.758 -0400", hash_original_field = "E0CCBC7742EB01E23FE8CAC0823856EC", hash_generated_field = "872480635E7B6A6F7A5C26A47649A56F")

            int suggestionStart;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.758 -0400", hash_original_field = "6BA3CAF30490DD7C10C1C1903B7C4EE6", hash_generated_field = "AC9E6ECED58FB8EF180833836DBCAA2D")

            int suggestionEnd;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.758 -0400", hash_original_field = "175FF5D2D5F25D80AF4E2ACDB6CE4C78", hash_generated_field = "46D75F50466858EB51EAFAE8BB212D75")

            SuggestionSpan suggestionSpan;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.758 -0400", hash_original_field = "79EA7A373645B1284FBF65D76846E660", hash_generated_field = "E2038F479A232C008DEC2C58888E09AF")

            int suggestionIndex;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.758 -0400", hash_original_field = "66AD57BB4DFC181279DFE9FFA45E67A0", hash_generated_field = "59937CFD4951C01B73A6EF4F5C4D841A")

            SpannableStringBuilder text = new SpannableStringBuilder();
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.758 -0400", hash_original_field = "4EE2EC84135A501AB5CC573E44247990", hash_generated_field = "18031134C63E234D2C3372B21DDAF396")

            TextAppearanceSpan highlightSpan = new TextAppearanceSpan(mContext,
                    com.android.internal.R.style.TextAppearance_SuggestionHighlight);
            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.758 -0400", hash_original_method = "613563FC71224468A61688B0DDA11E74", hash_generated_method = "613563FC71224468A61688B0DDA11E74")
            public SuggestionInfo ()
            {
                //Synthesized constructor
            }


        }


        
        private class SuggestionAdapter extends BaseAdapter {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.758 -0400", hash_original_field = "3F1D187921B41C54CE8DA3DC5FEF94E0", hash_generated_field = "0B998218A375E40727D240F37441CBEB")

            private LayoutInflater mInflater = (LayoutInflater) TextView.this.mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.758 -0400", hash_original_method = "56675D9229C135A53AD81FE91AEF2A02", hash_generated_method = "56675D9229C135A53AD81FE91AEF2A02")
            public SuggestionAdapter ()
            {
                //Synthesized constructor
            }


            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.758 -0400", hash_original_method = "02B536C5901CCC3DE9A3084712F44E45", hash_generated_method = "940684B0E32F07C8C1BA44A4F5072D5F")
            @Override
            public int getCount() {
                int varABFE2C764E01946613EA91131C55961C_1842365418 = (mNumberOfSuggestions);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1224038286 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1224038286;
                // ---------- Original Method ----------
                //return mNumberOfSuggestions;
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.759 -0400", hash_original_method = "AB9B090A0CFC1C7403BFB1F3A94BDE2B", hash_generated_method = "E6E4767525C02D08CDAA0DCAEE0B0F1E")
            @Override
            public Object getItem(int position) {
                addTaint(position);
Object var13968DAD2C8AF73D3E15A42C9144AD90_224018972 =                 mSuggestionInfos[position];
                var13968DAD2C8AF73D3E15A42C9144AD90_224018972.addTaint(taint);
                return var13968DAD2C8AF73D3E15A42C9144AD90_224018972;
                // ---------- Original Method ----------
                //return mSuggestionInfos[position];
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.759 -0400", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "2BD2A7085C26A74546772E7E31746FB2")
            @Override
            public long getItemId(int position) {
                addTaint(position);
                long var4757FE07FD492A8BE0EA6A760D683D6E_838130379 = (position);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_284742259 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_284742259;
                // ---------- Original Method ----------
                //return position;
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.759 -0400", hash_original_method = "EB7381461F4FDD3A1934D144B2D8DE50", hash_generated_method = "B3DE1267D1D6D5861CDA8CA9F0972B3E")
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                addTaint(parent.getTaint());
                addTaint(convertView.getTaint());
                addTaint(position);
                TextView textView = (TextView) convertView;
                if(textView == null)                
                {
                    textView = (TextView) mInflater.inflate(mTextEditSuggestionItemLayout, parent,
                            false);
                } //End block
                final SuggestionInfo suggestionInfo = mSuggestionInfos[position];
                textView.setText(suggestionInfo.text);
                if(suggestionInfo.suggestionIndex == ADD_TO_DICTIONARY)                
                {
                    textView.setCompoundDrawablesWithIntrinsicBounds(
                            com.android.internal.R.drawable.ic_suggestions_add, 0, 0, 0);
                } //End block
                else
                if(suggestionInfo.suggestionIndex == DELETE_TEXT)                
                {
                    textView.setCompoundDrawablesWithIntrinsicBounds(
                            com.android.internal.R.drawable.ic_suggestions_delete, 0, 0, 0);
                } //End block
                else
                {
                    textView.setCompoundDrawables(null, null, null, null);
                } //End block
View var21A67ABA5A9779F3A4F1F16B279D1253_1138108900 =                 textView;
                var21A67ABA5A9779F3A4F1F16B279D1253_1138108900.addTaint(taint);
                return var21A67ABA5A9779F3A4F1F16B279D1253_1138108900;
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
        }


        
        private class SuggestionSpanComparator implements Comparator<SuggestionSpan> {
            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.759 -0400", hash_original_method = "22EA00C20DD1AAEDCB1186FBD85A1C5E", hash_generated_method = "22EA00C20DD1AAEDCB1186FBD85A1C5E")
            public SuggestionSpanComparator ()
            {
                //Synthesized constructor
            }


            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.759 -0400", hash_original_method = "D4A09F0FD84AABB3F69B7BD15CCD92DF", hash_generated_method = "4A6136A9F03AE4B0394AEB416663CF3F")
            public int compare(SuggestionSpan span1, SuggestionSpan span2) {
                addTaint(span2.getTaint());
                addTaint(span1.getTaint());
                final int flag1 = span1.getFlags();
                final int flag2 = span2.getFlags();
                if(flag1 != flag2)                
                {
                    final boolean easy1 = (flag1 & SuggestionSpan.FLAG_EASY_CORRECT) != 0;
                    final boolean easy2 = (flag2 & SuggestionSpan.FLAG_EASY_CORRECT) != 0;
                    final boolean misspelled1 = (flag1 & SuggestionSpan.FLAG_MISSPELLED) != 0;
                    final boolean misspelled2 = (flag2 & SuggestionSpan.FLAG_MISSPELLED) != 0;
                    if(easy1 && !misspelled1)                    
                    {
                    int var6BB61E3B7BCE0931DA574D19D1D82C88_242112112 = (-1);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_127466426 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_127466426;
                    }
                    if(easy2 && !misspelled2)                    
                    {
                    int varC4CA4238A0B923820DCC509A6F75849B_749785596 = (1);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_361613689 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_361613689;
                    }
                    if(misspelled1)                    
                    {
                    int var6BB61E3B7BCE0931DA574D19D1D82C88_1691407473 = (-1);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1096417688 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1096417688;
                    }
                    if(misspelled2)                    
                    {
                    int varC4CA4238A0B923820DCC509A6F75849B_1733924010 = (1);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_745270029 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_745270029;
                    }
                } //End block
                int varCA3AE6C93BFCDDF239DDC6CC874375A6_1508270724 = (mSpansLengths.get(span1).intValue() - mSpansLengths.get(span2).intValue());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1009577236 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1009577236;
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.759 -0400", hash_original_field = "0C1515086A1226C970EE69A713DDD288", hash_generated_field = "D839A1C329DC1C2BA302C63069B302E8")

        private static final int MAX_NUMBER_SUGGESTIONS = SuggestionSpan.SUGGESTIONS_MAX_SIZE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.760 -0400", hash_original_field = "9A3BE7FEF28DB01CA67A412C8A54D32F", hash_generated_field = "60496CAB9AB07AE99F349E1717F7224D")

        private static final int ADD_TO_DICTIONARY = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.760 -0400", hash_original_field = "8C04FC6F385A06A2600D60FA7FE27F1A", hash_generated_field = "992995ADFDA4143135C9B34605503287")

        private static final int DELETE_TEXT = -2;
    }


    
    private class SelectionActionModeCallback implements ActionMode.Callback {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.760 -0400", hash_original_method = "0A08C97F3CA872D86BD6FA2FC1044E6A", hash_generated_method = "0A08C97F3CA872D86BD6FA2FC1044E6A")
        public SelectionActionModeCallback ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.762 -0400", hash_original_method = "9BA90F93967180A852B2E5C718CC8322", hash_generated_method = "1EBC3C151E8707A84A2ECF9FD6E30F85")
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(menu.getTaint());
            addTaint(mode.getTaint());
            TypedArray styledAttributes = mContext.obtainStyledAttributes(
                    com.android.internal.R.styleable.SelectionModeDrawables);
            boolean allowText = getContext().getResources().getBoolean(
                    com.android.internal.R.bool.config_allowActionMenuItemTextWithIcon);
            mode.setTitle(allowText ?
                    mContext.getString(com.android.internal.R.string.textSelectionCABTitle) : null);
            mode.setSubtitle(null);
            int selectAllIconId = 0;
            if(!allowText)            
            {
                selectAllIconId = styledAttributes.getResourceId(
                        R.styleable.SelectionModeDrawables_actionModeSelectAllDrawable, 0);
            } //End block
            menu.add(0, ID_SELECT_ALL, 0, com.android.internal.R.string.selectAll).
                    setIcon(selectAllIconId).
                    setAlphabeticShortcut('a').
                    setShowAsAction(
                            MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
            if(canCut())            
            {
                menu.add(0, ID_CUT, 0, com.android.internal.R.string.cut).
                    setIcon(styledAttributes.getResourceId(
                            R.styleable.SelectionModeDrawables_actionModeCutDrawable, 0)).
                    setAlphabeticShortcut('x').
                    setShowAsAction(
                            MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
            } //End block
            if(canCopy())            
            {
                menu.add(0, ID_COPY, 0, com.android.internal.R.string.copy).
                    setIcon(styledAttributes.getResourceId(
                            R.styleable.SelectionModeDrawables_actionModeCopyDrawable, 0)).
                    setAlphabeticShortcut('c').
                    setShowAsAction(
                            MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
            } //End block
            if(canPaste())            
            {
                menu.add(0, ID_PASTE, 0, com.android.internal.R.string.paste).
                        setIcon(styledAttributes.getResourceId(
                                R.styleable.SelectionModeDrawables_actionModePasteDrawable, 0)).
                        setAlphabeticShortcut('v').
                        setShowAsAction(
                                MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
            } //End block
            styledAttributes.recycle();
            if(mCustomSelectionActionModeCallback != null)            
            {
                if(!mCustomSelectionActionModeCallback.onCreateActionMode(mode, menu))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1443037096 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2116572729 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2116572729;
                } //End block
            } //End block
            if(menu.hasVisibleItems() || mode.getCustomView() != null)            
            {
                getSelectionController().show();
                boolean varB326B5062B2F0E69046810717534CB09_1335531657 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_272100714 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_272100714;
            } //End block
            else
            {
                boolean var68934A3E9455FA72420237EB05902327_1998506701 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_545435598 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_545435598;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.762 -0400", hash_original_method = "350C4916EAD271625C17FEEF1988576E", hash_generated_method = "F69F271C9A87CE4F7AF2A3913F757F0E")
        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(menu.getTaint());
            addTaint(mode.getTaint());
            if(mCustomSelectionActionModeCallback != null)            
            {
                boolean varD50E2795BFA5792E1C135AD61E303863_234550424 = (mCustomSelectionActionModeCallback.onPrepareActionMode(mode, menu));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1227500095 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1227500095;
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_428863163 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2001679192 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2001679192;
            // ---------- Original Method ----------
            //if (mCustomSelectionActionModeCallback != null) {
                //return mCustomSelectionActionModeCallback.onPrepareActionMode(mode, menu);
            //}
            //return true;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.763 -0400", hash_original_method = "7EC2472DA1F2018FBE0DB5359E02217C", hash_generated_method = "362579F1CC01C2FC2193D4C16880179F")
        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(item.getTaint());
            addTaint(mode.getTaint());
            if(mCustomSelectionActionModeCallback != null &&
                 mCustomSelectionActionModeCallback.onActionItemClicked(mode, item))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1258125890 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2002486941 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2002486941;
            } //End block
            boolean var6573A454020624A6F9183FBDE65859B3_754673669 = (onTextContextMenuItem(item.getItemId()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2053827246 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2053827246;
            // ---------- Original Method ----------
            //if (mCustomSelectionActionModeCallback != null &&
                 //mCustomSelectionActionModeCallback.onActionItemClicked(mode, item)) {
                //return true;
            //}
            //return onTextContextMenuItem(item.getItemId());
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.764 -0400", hash_original_method = "E3DA233478038DA411461438FCA54906", hash_generated_method = "DF00950BF20EA231DE9CAB69E1892EF6")
        @Override
        public void onDestroyActionMode(ActionMode mode) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(mode.getTaint());
            if(mCustomSelectionActionModeCallback != null)            
            {
                mCustomSelectionActionModeCallback.onDestroyActionMode(mode);
            } //End block
            Selection.setSelection((Spannable) mText, getSelectionEnd());
            if(mSelectionModifierCursorController != null)            
            {
                mSelectionModifierCursorController.hide();
            } //End block
            mSelectionActionMode = null;
            // ---------- Original Method ----------
            //if (mCustomSelectionActionModeCallback != null) {
                //mCustomSelectionActionModeCallback.onDestroyActionMode(mode);
            //}
            //Selection.setSelection((Spannable) mText, getSelectionEnd());
            //if (mSelectionModifierCursorController != null) {
                //mSelectionModifierCursorController.hide();
            //}
            //mSelectionActionMode = null;
        }

        
    }


    
    private class ActionPopupWindow extends PinnedPopupWindow implements OnClickListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.764 -0400", hash_original_field = "638E4AC7A89C2D70FFAD0D5E4D21347B", hash_generated_field = "D8E77E145B60561FAD9A3B60E7593FC7")

        private TextView mPasteTextView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.764 -0400", hash_original_field = "40AFD8EC4389104F8E2396DDF98BD183", hash_generated_field = "5647E56FAEB644585635D1F439C78D58")

        private TextView mReplaceTextView;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.764 -0400", hash_original_method = "66BB2A1B8CD91C3CE44D6AD3A6EA951F", hash_generated_method = "66BB2A1B8CD91C3CE44D6AD3A6EA951F")
        public ActionPopupWindow ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.765 -0400", hash_original_method = "3A27BFF151DD7090A49C43ED6F082D3A", hash_generated_method = "8DC88F4954A2CB9FB764336AB0459502")
        @Override
        protected void createPopupWindow() {
            mPopupWindow = new PopupWindow(TextView.this.mContext, null,
                    com.android.internal.R.attr.textSelectHandleWindowStyle);
            mPopupWindow.setClippingEnabled(true);
            // ---------- Original Method ----------
            //mPopupWindow = new PopupWindow(TextView.this.mContext, null,
                    //com.android.internal.R.attr.textSelectHandleWindowStyle);
            //mPopupWindow.setClippingEnabled(true);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.765 -0400", hash_original_method = "24A2CF459D5801BCD7B986330654CD38", hash_generated_method = "FEC1E85CC5C44135050F2394200FF32D")
        @Override
        protected void initContentView() {
            LinearLayout linearLayout = new LinearLayout(TextView.this.getContext());
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            mContentView = linearLayout;
            mContentView.setBackgroundResource(
                    com.android.internal.R.drawable.text_edit_paste_window);
            LayoutInflater inflater = (LayoutInflater)TextView.this.mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            LayoutParams wrapContent = new LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            mPasteTextView = (TextView) inflater.inflate(POPUP_TEXT_LAYOUT, null);
            mPasteTextView.setLayoutParams(wrapContent);
            mContentView.addView(mPasteTextView);
            mPasteTextView.setText(com.android.internal.R.string.paste);
            mPasteTextView.setOnClickListener(this);
            mReplaceTextView = (TextView) inflater.inflate(POPUP_TEXT_LAYOUT, null);
            mReplaceTextView.setLayoutParams(wrapContent);
            mContentView.addView(mReplaceTextView);
            mReplaceTextView.setText(com.android.internal.R.string.replace);
            mReplaceTextView.setOnClickListener(this);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.765 -0400", hash_original_method = "A37D41A60FC392DB422E94A09527D04E", hash_generated_method = "EE7B7B09A26C6C40DCD1CFFB34B68B20")
        @Override
        public void show() {
            boolean canPaste = canPaste();
            boolean canSuggest = isSuggestionsEnabled() && isCursorInsideSuggestionSpan();
            mPasteTextView.setVisibility(canPaste ? View.VISIBLE : View.GONE);
            mReplaceTextView.setVisibility(canSuggest ? View.VISIBLE : View.GONE);
            if(!canPaste && !canSuggest)            
            return;
            super.show();
            // ---------- Original Method ----------
            //boolean canPaste = canPaste();
            //boolean canSuggest = isSuggestionsEnabled() && isCursorInsideSuggestionSpan();
            //mPasteTextView.setVisibility(canPaste ? View.VISIBLE : View.GONE);
            //mReplaceTextView.setVisibility(canSuggest ? View.VISIBLE : View.GONE);
            //if (!canPaste && !canSuggest) return;
            //super.show();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.765 -0400", hash_original_method = "35B6F06783189901121FFF5DA40FB852", hash_generated_method = "B6D07AAD2425E6A70A7E3A7CB6DA744C")
        @Override
        public void onClick(View view) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(view.getTaint());
            if(view == mPasteTextView && canPaste())            
            {
                onTextContextMenuItem(ID_PASTE);
                hide();
            } //End block
            else
            if(view == mReplaceTextView)            
            {
                final int middle = (getSelectionStart() + getSelectionEnd()) / 2;
                stopSelectionActionMode();
                Selection.setSelection((Spannable) mText, middle);
                showSuggestions();
            } //End block
            // ---------- Original Method ----------
            //if (view == mPasteTextView && canPaste()) {
                //onTextContextMenuItem(ID_PASTE);
                //hide();
            //} else if (view == mReplaceTextView) {
                //final int middle = (getSelectionStart() + getSelectionEnd()) / 2;
                //stopSelectionActionMode();
                //Selection.setSelection((Spannable) mText, middle);
                //showSuggestions();
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.766 -0400", hash_original_method = "6C32A970FB91901A3510EE736EF065A8", hash_generated_method = "AE0804522BDC995668815AD133AFEA17")
        @Override
        protected int getTextOffset() {
            int var57BAD63F323E36F671657EA655BB2C87_2072982976 = ((getSelectionStart() + getSelectionEnd()) / 2);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1681658869 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1681658869;
            // ---------- Original Method ----------
            //return (getSelectionStart() + getSelectionEnd()) / 2;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.766 -0400", hash_original_method = "AB01324FAF38A5FF69620E59B4546722", hash_generated_method = "8E1067FDCA98E3AB5929C64720D47FE5")
        @Override
        protected int getVerticalLocalPosition(int line) {
            addTaint(line);
            int var9175F55E534FA27C13B022F9FAE67101_1175679683 = (mLayout.getLineTop(line) - mContentView.getMeasuredHeight());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1882941987 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1882941987;
            // ---------- Original Method ----------
            //return mLayout.getLineTop(line) - mContentView.getMeasuredHeight();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.766 -0400", hash_original_method = "155BF5081251C49CE36145C9CC0615FD", hash_generated_method = "52C5636B02C81D52BFA32A8480E5CC1B")
        @Override
        protected int clipVertically(int positionY) {
            addTaint(positionY);
            if(positionY < 0)            
            {
                final int offset = getTextOffset();
                final int line = mLayout.getLineForOffset(offset);
                positionY += mLayout.getLineBottom(line) - mLayout.getLineTop(line);
                positionY += mContentView.getMeasuredHeight();
                final Drawable handle = mContext.getResources().getDrawable(mTextSelectHandleRes);
                positionY += handle.getIntrinsicHeight();
            } //End block
            int varD94FD0654F7DB887E1FD05FDCF20498C_1494390087 = (positionY);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_928579871 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_928579871;
            // ---------- Original Method ----------
            //if (positionY < 0) {
                //final int offset = getTextOffset();
                //final int line = mLayout.getLineForOffset(offset);
                //positionY += mLayout.getLineBottom(line) - mLayout.getLineTop(line);
                //positionY += mContentView.getMeasuredHeight();
                //final Drawable handle = mContext.getResources().getDrawable(mTextSelectHandleRes);
                //positionY += handle.getIntrinsicHeight();
            //}
            //return positionY;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.766 -0400", hash_original_field = "A8B4CFDAA994C026529F1F31A401F449", hash_generated_field = "9556C9F4A76B40115A0F30878921C774")

        private static final int POPUP_TEXT_LAYOUT = com.android.internal.R.layout.text_edit_action_popup_text;
    }


    
    private abstract class HandleView extends View implements TextViewPositionListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.766 -0400", hash_original_field = "D548B27C6AC66A9D9B5D05ED35C2D844", hash_generated_field = "6C4E60FE8A6D1EE71691C50FE013D71E")

        protected Drawable mDrawable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.766 -0400", hash_original_field = "73FE9509DA3FC3FD8E616D5F4A54F354", hash_generated_field = "4C4EE51B5C48463562D9242B398F28CE")

        protected Drawable mDrawableLtr;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.766 -0400", hash_original_field = "75EB4D5B30043123DC9A2A3794EEC7F0", hash_generated_field = "C7A02A239F561A2D85D421A4E8712A4E")

        protected Drawable mDrawableRtl;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.766 -0400", hash_original_field = "C64165C1B15EB68FDC5E7135FFE5DF5B", hash_generated_field = "B93BD44443CA54ABF5B84DF5F163A33F")

        private PopupWindow mContainer;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.766 -0400", hash_original_field = "E33EA5C4D485469D2432B3A781CD5014", hash_generated_field = "B562606C08FEFE4EA880E0BAFC4807BC")

        private int mPositionX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.766 -0400", hash_original_field = "5EF2225F886100AA279B39F41428F3C5", hash_generated_field = "30733FB91B36B499B68F008F42192052")

        private int mPositionY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.766 -0400", hash_original_field = "88529674006503CAD340B538C44A2C88", hash_generated_field = "71A2FEF14E89166E5A8A859417B1663A")

        private boolean mIsDragging;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.766 -0400", hash_original_field = "029443A19C599CE9A771103B1F04FFA7", hash_generated_field = "93A0F0D3D0C011A4C3C7501AB57199A0")

        private float mTouchToWindowOffsetX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.766 -0400", hash_original_field = "01E0875D4861BF37105440B51BFCE246", hash_generated_field = "540D3F7CD2E1D98D601A597896694EF1")

        private float mTouchToWindowOffsetY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.766 -0400", hash_original_field = "EC8EBBCD9EFF3785D3CEAE13B087737E", hash_generated_field = "FC8146331AA3445EF26C9BD556ACBB7A")

        protected int mHotspotX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.766 -0400", hash_original_field = "E77C6D28007CC352FD029FAC0668FD90", hash_generated_field = "6BB781632FC22CFF12B61F61AC16C144")

        private float mTouchOffsetY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.766 -0400", hash_original_field = "82A2205DB022BA555E925261E4DCC4D4", hash_generated_field = "7A7CA8BEEE2A68B1CAD15B2AD85A2E90")

        private float mIdealVerticalOffset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.767 -0400", hash_original_field = "AFAA5B704E00C118BFC94C3DB68B3EB8", hash_generated_field = "4316A0FF32FF85FA98C402B295009B89")

        private int mLastParentX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.767 -0400", hash_original_field = "921E843A2994BBE22EA5E45795AA43E4", hash_generated_field = "989834E9B58E837BA06B11D0842ADD46")

        private int mLastParentY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.767 -0400", hash_original_field = "81B6A0831D431B26A19572DBBA8D21BD", hash_generated_field = "2EC1E5C57AE86C2314399153800FDC8F")

        protected ActionPopupWindow mActionPopupWindow;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.767 -0400", hash_original_field = "686EF52C6C5A665D57DB688D5CD19C3F", hash_generated_field = "C47DED40298BEE97981BC7B8F1538E5B")

        private int mPreviousOffset = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.767 -0400", hash_original_field = "03D5F02C0AF2CE2B038F91466D8238BA", hash_generated_field = "348E54253A3677FA237DAA94481A3907")

        private boolean mPositionHasChanged = true;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.767 -0400", hash_original_field = "5C0D0B062C184F3703A4B9594303BA8F", hash_generated_field = "AF098A48DA71A067D06553B74FDC10EC")

        private Runnable mActionPopupShower;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.767 -0400", hash_original_field = "77968F028A8D0EC9CAEB90B72134A740", hash_generated_field = "49D0562CBA301978D9BE0EDDCD29274F")

        private final long[] mPreviousOffsetsTimes = new long[HISTORY_SIZE];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.767 -0400", hash_original_field = "9960A44D965A887155E39C559464BFCA", hash_generated_field = "B14296EE4EF0011B1C75932F407A07FC")

        private final int[] mPreviousOffsets = new int[HISTORY_SIZE];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.767 -0400", hash_original_field = "76D787A353B8891BC279BD7E2A9B6B00", hash_generated_field = "A862CB689B1B30174089DC5C296E66B1")

        private int mPreviousOffsetIndex = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.767 -0400", hash_original_field = "AD3CA79B9D71DC299CA01D15C8FD472D", hash_generated_field = "FFBAC9977BB0F1F158F20DFF11AA8445")

        private int mNumberPreviousOffsets = 0;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.767 -0400", hash_original_method = "96CFEA14605480F2CAC7A5BABB016DB2", hash_generated_method = "B899B328CDCE2D8BB1084ECD9613283A")
        public  HandleView(Drawable drawableLtr, Drawable drawableRtl) {
            super(TextView.this.mContext);
            mContainer = new PopupWindow(TextView.this.mContext, null,
                    com.android.internal.R.attr.textSelectHandleWindowStyle);
            mContainer.setSplitTouchEnabled(true);
            mContainer.setClippingEnabled(false);
            mContainer.setWindowLayoutType(WindowManager.LayoutParams.TYPE_APPLICATION_SUB_PANEL);
            mContainer.setContentView(this);
            mDrawableLtr = drawableLtr;
            mDrawableRtl = drawableRtl;
            updateDrawable();
            final int handleHeight = mDrawable.getIntrinsicHeight();
            mTouchOffsetY = -0.3f * handleHeight;
            mIdealVerticalOffset = 0.7f * handleHeight;
            // ---------- Original Method ----------
            //mContainer = new PopupWindow(TextView.this.mContext, null,
                    //com.android.internal.R.attr.textSelectHandleWindowStyle);
            //mContainer.setSplitTouchEnabled(true);
            //mContainer.setClippingEnabled(false);
            //mContainer.setWindowLayoutType(WindowManager.LayoutParams.TYPE_APPLICATION_SUB_PANEL);
            //mContainer.setContentView(this);
            //mDrawableLtr = drawableLtr;
            //mDrawableRtl = drawableRtl;
            //updateDrawable();
            //final int handleHeight = mDrawable.getIntrinsicHeight();
            //mTouchOffsetY = -0.3f * handleHeight;
            //mIdealVerticalOffset = 0.7f * handleHeight;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.768 -0400", hash_original_method = "79B760AD39E8E4DC7B1000745317DEB7", hash_generated_method = "CF95FE73935976E2ED01BA62145AD362")
        protected void updateDrawable() {
            final int offset = getCurrentCursorOffset();
            final boolean isRtlCharAtOffset = mLayout.isRtlCharAt(offset);
            mDrawable = isRtlCharAtOffset ? mDrawableRtl : mDrawableLtr;
            mHotspotX = getHotspotX(mDrawable, isRtlCharAtOffset);
            // ---------- Original Method ----------
            //final int offset = getCurrentCursorOffset();
            //final boolean isRtlCharAtOffset = mLayout.isRtlCharAt(offset);
            //mDrawable = isRtlCharAtOffset ? mDrawableRtl : mDrawableLtr;
            //mHotspotX = getHotspotX(mDrawable, isRtlCharAtOffset);
        }

        
        @DSModeled(DSC.SAFE)
        protected abstract int getHotspotX(Drawable drawable, boolean isRtlRun);

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.768 -0400", hash_original_method = "FC7484D3CDDEA8A708B164CA1D725BB5", hash_generated_method = "1996B90278D5D3951452351FD4F5C9EA")
        private void startTouchUpFilter(int offset) {
            addTaint(offset);
            mNumberPreviousOffsets = 0;
            addPositionToTouchUpFilter(offset);
            // ---------- Original Method ----------
            //mNumberPreviousOffsets = 0;
            //addPositionToTouchUpFilter(offset);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.768 -0400", hash_original_method = "F067815A22302FA44603BE1943641FAF", hash_generated_method = "8E049112320942974726394FA928F596")
        private void addPositionToTouchUpFilter(int offset) {
            mPreviousOffsetIndex = (mPreviousOffsetIndex + 1) % HISTORY_SIZE;
            mPreviousOffsets[mPreviousOffsetIndex] = offset;
            mPreviousOffsetsTimes[mPreviousOffsetIndex] = SystemClock.uptimeMillis();
            mNumberPreviousOffsets++;
            // ---------- Original Method ----------
            //mPreviousOffsetIndex = (mPreviousOffsetIndex + 1) % HISTORY_SIZE;
            //mPreviousOffsets[mPreviousOffsetIndex] = offset;
            //mPreviousOffsetsTimes[mPreviousOffsetIndex] = SystemClock.uptimeMillis();
            //mNumberPreviousOffsets++;
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.768 -0400", hash_original_method = "55F0EF9CEF8C5AA4299D2A57A3F07803", hash_generated_method = "DA3F6F2A2D8733DB7865D0930A08A1FA")
        private void filterOnTouchUp() {
            final long now = SystemClock.uptimeMillis();
            int i = 0;
            int index = mPreviousOffsetIndex;
            final int iMax = Math.min(mNumberPreviousOffsets, HISTORY_SIZE);
            while
(i < iMax && (now - mPreviousOffsetsTimes[index]) < TOUCH_UP_FILTER_DELAY_AFTER)            
            {
                i++;
                index = (mPreviousOffsetIndex - i + HISTORY_SIZE) % HISTORY_SIZE;
            } //End block
            if(i > 0 && i < iMax &&
                    (now - mPreviousOffsetsTimes[index]) > TOUCH_UP_FILTER_DELAY_BEFORE)            
            {
                positionAtCursorOffset(mPreviousOffsets[index], false);
            } //End block
            // ---------- Original Method ----------
            //final long now = SystemClock.uptimeMillis();
            //int i = 0;
            //int index = mPreviousOffsetIndex;
            //final int iMax = Math.min(mNumberPreviousOffsets, HISTORY_SIZE);
            //while (i < iMax && (now - mPreviousOffsetsTimes[index]) < TOUCH_UP_FILTER_DELAY_AFTER) {
                //i++;
                //index = (mPreviousOffsetIndex - i + HISTORY_SIZE) % HISTORY_SIZE;
            //}
            //if (i > 0 && i < iMax &&
                    //(now - mPreviousOffsetsTimes[index]) > TOUCH_UP_FILTER_DELAY_BEFORE) {
                //positionAtCursorOffset(mPreviousOffsets[index], false);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.768 -0400", hash_original_method = "8E1053DB926B4787A5B252A5CCF7E3E6", hash_generated_method = "9C4D7A2143E810671429B24E59888FF4")
        public boolean offsetHasBeenChanged() {
            boolean var374794A0C2F46B2B77E2E5D05EC0DCCC_1986024576 = (mNumberPreviousOffsets > 1);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1886978463 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1886978463;
            // ---------- Original Method ----------
            //return mNumberPreviousOffsets > 1;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.769 -0400", hash_original_method = "F1B9B11E208A14EF1A8385C794E8615A", hash_generated_method = "B0CF45DEA049E062B932FC8446CFF8F6")
        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(heightMeasureSpec);
            addTaint(widthMeasureSpec);
            setMeasuredDimension(mDrawable.getIntrinsicWidth(), mDrawable.getIntrinsicHeight());
            // ---------- Original Method ----------
            //setMeasuredDimension(mDrawable.getIntrinsicWidth(), mDrawable.getIntrinsicHeight());
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.769 -0400", hash_original_method = "0CEFB75F912E1774230D056666C1CB4D", hash_generated_method = "F5C422395DC5E904945FE3EB4DCA9F15")
        public void show() {
            if(isShowing())            
            return;
            getPositionListener().addSubscriber(this, true );
            mPreviousOffset = -1;
            positionAtCursorOffset(getCurrentCursorOffset(), false);
            hideActionPopupWindow();
            // ---------- Original Method ----------
            //if (isShowing()) return;
            //getPositionListener().addSubscriber(this, true );
            //mPreviousOffset = -1;
            //positionAtCursorOffset(getCurrentCursorOffset(), false);
            //hideActionPopupWindow();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.769 -0400", hash_original_method = "58A1CA71E65CA8505283F80ECD55B125", hash_generated_method = "733B087F4D13E07199A0682C98829C56")
        protected void dismiss() {
            mIsDragging = false;
            mContainer.dismiss();
            onDetached();
            // ---------- Original Method ----------
            //mIsDragging = false;
            //mContainer.dismiss();
            //onDetached();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.769 -0400", hash_original_method = "E51AD13D62B6328756BEDC07E20C91A7", hash_generated_method = "B3050A8544288284788803BE9D39F46E")
        public void hide() {
            dismiss();
            TextView.this.getPositionListener().removeSubscriber(this);
            // ---------- Original Method ----------
            //dismiss();
            //TextView.this.getPositionListener().removeSubscriber(this);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.770 -0400", hash_original_method = "0D5333D88B146866CC739B7BC1FA2E0A", hash_generated_method = "35C87A0497B2DDA10AB5E7767F78297E")
         void showActionPopupWindow(int delay) {
            addTaint(delay);
            if(mActionPopupWindow == null)            
            {
                mActionPopupWindow = new ActionPopupWindow();
            } //End block
            if(mActionPopupShower == null)            
            {
                mActionPopupShower = new Runnable() {            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.770 -0400", hash_original_method = "3DEF90E085B5D89C941B0ED88F0DC7FD", hash_generated_method = "0FD34D73BCA925EC1AF406DCBE797EF5")
            public void run() {
                mActionPopupWindow.show();
                // ---------- Original Method ----------
                //mActionPopupWindow.show();
            }
};
            } //End block
            else
            {
                TextView.this.removeCallbacks(mActionPopupShower);
            } //End block
            TextView.this.postDelayed(mActionPopupShower, delay);
            // ---------- Original Method ----------
            //if (mActionPopupWindow == null) {
                //mActionPopupWindow = new ActionPopupWindow();
            //}
            //if (mActionPopupShower == null) {
                //mActionPopupShower = new Runnable() {
                    //public void run() {
                        //mActionPopupWindow.show();
                    //}
                //};
            //} else {
                //TextView.this.removeCallbacks(mActionPopupShower);
            //}
            //TextView.this.postDelayed(mActionPopupShower, delay);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.772 -0400", hash_original_method = "7E990B2771AC26D4AD93278F16BEC9C8", hash_generated_method = "EE7C3E898D1C337EE1C2E06DF4D6AC2A")
        protected void hideActionPopupWindow() {
            if(mActionPopupShower != null)            
            {
                TextView.this.removeCallbacks(mActionPopupShower);
            } //End block
            if(mActionPopupWindow != null)            
            {
                mActionPopupWindow.hide();
            } //End block
            // ---------- Original Method ----------
            //if (mActionPopupShower != null) {
                //TextView.this.removeCallbacks(mActionPopupShower);
            //}
            //if (mActionPopupWindow != null) {
                //mActionPopupWindow.hide();
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.772 -0400", hash_original_method = "4C582CFB225DCFD162C1BDA55C8E191D", hash_generated_method = "D2DD6380AA67A92829563801B052CE04")
        public boolean isShowing() {
            boolean varD8963E1B8B79D898C65FC59EC7DAF56E_140084128 = (mContainer.isShowing());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1363213651 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1363213651;
            // ---------- Original Method ----------
            //return mContainer.isShowing();
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.773 -0400", hash_original_method = "622F11C59DDFBBB8F6FA4F43A2282A80", hash_generated_method = "95FBF6DFA6C58AC2D150DCA07B54AD05")
        private boolean isVisible() {
            if(mIsDragging)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1903995536 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1086571104 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1086571104;
            } //End block
            if(isInBatchEditMode())            
            {
                boolean var68934A3E9455FA72420237EB05902327_577890313 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_99853273 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_99853273;
            } //End block
            boolean varC88124C625D43A74EF1F52B9AD94595C_497004104 = (TextView.this.isPositionVisible(mPositionX + mHotspotX, mPositionY));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1670785758 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1670785758;
            // ---------- Original Method ----------
            //if (mIsDragging) {
                //return true;
            //}
            //if (isInBatchEditMode()) {
                //return false;
            //}
            //return TextView.this.isPositionVisible(mPositionX + mHotspotX, mPositionY);
        }

        
        @DSModeled(DSC.SAFE)
        public abstract int getCurrentCursorOffset();

        
        @DSModeled(DSC.SAFE)
        protected abstract void updateSelection(int offset);

        
        @DSModeled(DSC.SAFE)
        public abstract void updatePosition(float x, float y);

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.776 -0400", hash_original_method = "23AE0E97732D2E1BD689A17102858930", hash_generated_method = "F2EDA2F2FDCAD5422CE8EF0F6B3E9AE4")
        protected void positionAtCursorOffset(int offset, boolean parentScrolled) {
            addTaint(parentScrolled);
            if(mLayout == null)            
            {
                prepareCursorControllers();
                return;
            } //End block
            if(offset != mPreviousOffset || parentScrolled)            
            {
                updateSelection(offset);
                addPositionToTouchUpFilter(offset);
                final int line = mLayout.getLineForOffset(offset);
                mPositionX = (int) (mLayout.getPrimaryHorizontal(offset) - 0.5f - mHotspotX);
                mPositionY = mLayout.getLineBottom(line);
                mPositionX += viewportToContentHorizontalOffset();
                mPositionY += viewportToContentVerticalOffset();
                mPreviousOffset = offset;
                mPositionHasChanged = true;
            } //End block
            // ---------- Original Method ----------
            //if (mLayout == null) {
                //prepareCursorControllers();
                //return;
            //}
            //if (offset != mPreviousOffset || parentScrolled) {
                //updateSelection(offset);
                //addPositionToTouchUpFilter(offset);
                //final int line = mLayout.getLineForOffset(offset);
                //mPositionX = (int) (mLayout.getPrimaryHorizontal(offset) - 0.5f - mHotspotX);
                //mPositionY = mLayout.getLineBottom(line);
                //mPositionX += viewportToContentHorizontalOffset();
                //mPositionY += viewportToContentVerticalOffset();
                //mPreviousOffset = offset;
                //mPositionHasChanged = true;
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.776 -0400", hash_original_method = "13FE1FBB4F8CE63ECDC017603A6579A6", hash_generated_method = "1D446164C5A67971A4751A708892E7D1")
        public void updatePosition(int parentPositionX, int parentPositionY,
                boolean parentPositionChanged, boolean parentScrolled) {
            addTaint(parentScrolled);
            addTaint(parentPositionChanged);
            positionAtCursorOffset(getCurrentCursorOffset(), parentScrolled);
            if(parentPositionChanged || mPositionHasChanged)            
            {
                if(mIsDragging)                
                {
                    if(parentPositionX != mLastParentX || parentPositionY != mLastParentY)                    
                    {
                        mTouchToWindowOffsetX += parentPositionX - mLastParentX;
                        mTouchToWindowOffsetY += parentPositionY - mLastParentY;
                        mLastParentX = parentPositionX;
                        mLastParentY = parentPositionY;
                    } //End block
                    onHandleMoved();
                } //End block
                if(isVisible())                
                {
                    final int positionX = parentPositionX + mPositionX;
                    final int positionY = parentPositionY + mPositionY;
                    if(isShowing())                    
                    {
                        mContainer.update(positionX, positionY, -1, -1);
                    } //End block
                    else
                    {
                        mContainer.showAtLocation(TextView.this, Gravity.NO_GRAVITY,
                                positionX, positionY);
                    } //End block
                } //End block
                else
                {
                    if(isShowing())                    
                    {
                        dismiss();
                    } //End block
                } //End block
                mPositionHasChanged = false;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.777 -0400", hash_original_method = "F8254677C35EEC48CDE0AC0DA5BFAEC5", hash_generated_method = "1141497BF396B3476F3AA13EC94C0197")
        @Override
        protected void onDraw(Canvas c) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(c.getTaint());
            mDrawable.setBounds(0, 0, mRight - mLeft, mBottom - mTop);
            mDrawable.draw(c);
            // ---------- Original Method ----------
            //mDrawable.setBounds(0, 0, mRight - mLeft, mBottom - mTop);
            //mDrawable.draw(c);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.777 -0400", hash_original_method = "AFDBACCAFCABC81309AB0079A4EAD49F", hash_generated_method = "D05A4ED8A79EEE4E4F079B55385554EE")
        @Override
        public boolean onTouchEvent(MotionEvent ev) {
            //DSFIXME:  CODE0009: Possible callback target function detected
switch(ev.getActionMasked()){
            case MotionEvent.ACTION_DOWN:
            {
                startTouchUpFilter(getCurrentCursorOffset());
                mTouchToWindowOffsetX = ev.getRawX() - mPositionX;
                mTouchToWindowOffsetY = ev.getRawY() - mPositionY;
                final PositionListener positionListener = getPositionListener();
                mLastParentX = positionListener.getPositionX();
                mLastParentY = positionListener.getPositionY();
                mIsDragging = true;
                break;
            } //End block
            case MotionEvent.ACTION_MOVE:
            {
                final float rawX = ev.getRawX();
                final float rawY = ev.getRawY();
                final float previousVerticalOffset = mTouchToWindowOffsetY - mLastParentY;
                final float currentVerticalOffset = rawY - mPositionY - mLastParentY;
                float newVerticalOffset;
                if(previousVerticalOffset < mIdealVerticalOffset)                
                {
                    newVerticalOffset = Math.min(currentVerticalOffset, mIdealVerticalOffset);
                    newVerticalOffset = Math.max(newVerticalOffset, previousVerticalOffset);
                } //End block
                else
                {
                    newVerticalOffset = Math.max(currentVerticalOffset, mIdealVerticalOffset);
                    newVerticalOffset = Math.min(newVerticalOffset, previousVerticalOffset);
                } //End block
                mTouchToWindowOffsetY = newVerticalOffset + mLastParentY;
                final float newPosX = rawX - mTouchToWindowOffsetX + mHotspotX;
                final float newPosY = rawY - mTouchToWindowOffsetY + mTouchOffsetY;
                updatePosition(newPosX, newPosY);
                break;
            } //End block
            case MotionEvent.ACTION_UP:
            filterOnTouchUp();
            mIsDragging = false;
            break;
            case MotionEvent.ACTION_CANCEL:
            mIsDragging = false;
            break;
}            boolean varB326B5062B2F0E69046810717534CB09_2086006514 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_829573922 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_829573922;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.778 -0400", hash_original_method = "A2059A5EB773F7552F7C3D2AAFE1E47B", hash_generated_method = "4A570213D74A8D9DEA3D892BC4FB30EB")
        public boolean isDragging() {
            boolean var88529674006503CAD340B538C44A2C88_224036415 = (mIsDragging);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1632441696 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1632441696;
            // ---------- Original Method ----------
            //return mIsDragging;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.779 -0400", hash_original_method = "5C16B6634DA5CEF817B70D10C5EDCDFD", hash_generated_method = "2D666D5FB7EA2FA5400262CA3F1C8A1F")
         void onHandleMoved() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            hideActionPopupWindow();
            // ---------- Original Method ----------
            //hideActionPopupWindow();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.779 -0400", hash_original_method = "0744EFF256BE5CA55B7C747C6AB06865", hash_generated_method = "07B6D1B0BEF9A03B240C16C543BA4B2F")
        public void onDetached() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            hideActionPopupWindow();
            // ---------- Original Method ----------
            //hideActionPopupWindow();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.779 -0400", hash_original_field = "4D2C350B591CA62A0C667757F122D131", hash_generated_field = "917FEC01F976A8368E859F3ACCB2974D")

        private static final int HISTORY_SIZE = 5;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.779 -0400", hash_original_field = "5A211AD0D3E493272B14721269ACE755", hash_generated_field = "2607BC863EBAADB23B7B64E594D70D00")

        private static final int TOUCH_UP_FILTER_DELAY_AFTER = 150;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.779 -0400", hash_original_field = "34B7443C5D740630794D9BD84EFEB1CC", hash_generated_field = "4E35A675947440670D142A9EC9F7D555")

        private static final int TOUCH_UP_FILTER_DELAY_BEFORE = 350;
    }


    
    private class InsertionHandleView extends HandleView {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.779 -0400", hash_original_field = "E112B12E6D91B6522B4D9A9D3C4682F9", hash_generated_field = "096F0842C4660386417099FC96034322")

        private float mDownPositionX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.779 -0400", hash_original_field = "B61BFF081F30765551C8F83D5FE6EC6E", hash_generated_field = "70F6109386E0D3A8FC8471F06A6A2F6D")

        private float mDownPositionY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.779 -0400", hash_original_field = "101E91B8795FFD67FD01E75EC6725745", hash_generated_field = "1E652DE5CA4B75E782FE33512F595202")

        private Runnable mHider;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.780 -0400", hash_original_method = "F74814C2C752895D626389ECC5F1998A", hash_generated_method = "5EAC7B8D71C451D641FED6330B91FC9E")
        public  InsertionHandleView(Drawable drawable) {
            super(drawable, drawable);
            addTaint(drawable.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.780 -0400", hash_original_method = "0F6B36BAB7494929112A1B2A0EAC8D6C", hash_generated_method = "7E7E6595A853159770A67C64A3B4087F")
        @Override
        public void show() {
            super.show();
            final long durationSinceCutOrCopy = SystemClock.uptimeMillis() - sLastCutOrCopyTime;
            if(durationSinceCutOrCopy < RECENT_CUT_COPY_DURATION)            
            {
                showActionPopupWindow(0);
            } //End block
            hideAfterDelay();
            // ---------- Original Method ----------
            //super.show();
            //final long durationSinceCutOrCopy = SystemClock.uptimeMillis() - sLastCutOrCopyTime;
            //if (durationSinceCutOrCopy < RECENT_CUT_COPY_DURATION) {
                //showActionPopupWindow(0);
            //}
            //hideAfterDelay();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.780 -0400", hash_original_method = "59B6A837BA01A6E9F2644C670D997B83", hash_generated_method = "3AF35DDAFA81E0D862669F6D69826EB8")
        public void showWithActionPopup() {
            show();
            showActionPopupWindow(0);
            // ---------- Original Method ----------
            //show();
            //showActionPopupWindow(0);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.780 -0400", hash_original_method = "60FC6C1FF502D89543DDAA49F0EA3292", hash_generated_method = "C0FB9B494F1E5467E2B21D2F3ADD0A6B")
        private void hideAfterDelay() {
            removeHiderCallback();
            if(mHider == null)            
            {
                mHider = new Runnable() {            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.780 -0400", hash_original_method = "21815FA27ABEB649DED6A46E4F97905B", hash_generated_method = "2FF065C6B89057BF4ADFF6066462708E")
            public void run() {
                hide();
                // ---------- Original Method ----------
                //hide();
            }
};
            } //End block
            TextView.this.postDelayed(mHider, DELAY_BEFORE_HANDLE_FADES_OUT);
            // ---------- Original Method ----------
            //removeHiderCallback();
            //if (mHider == null) {
                //mHider = new Runnable() {
                    //public void run() {
                        //hide();
                    //}
                //};
            //}
            //TextView.this.postDelayed(mHider, DELAY_BEFORE_HANDLE_FADES_OUT);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.784 -0400", hash_original_method = "C682D1056E8259D8BAEA8A544AED7A4D", hash_generated_method = "F5FB0239C586118949CA04ED0F6386D1")
        private void removeHiderCallback() {
            if(mHider != null)            
            {
                TextView.this.removeCallbacks(mHider);
            } //End block
            // ---------- Original Method ----------
            //if (mHider != null) {
                //TextView.this.removeCallbacks(mHider);
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.784 -0400", hash_original_method = "6DC2E28231BC586AA27A394F083E414A", hash_generated_method = "B80A9CD445609ECD506CE76691206B81")
        @Override
        protected int getHotspotX(Drawable drawable, boolean isRtlRun) {
            addTaint(isRtlRun);
            addTaint(drawable.getTaint());
            int var7B8098CEC9515AC8F4EFCA04D2C974A8_1280737019 = (drawable.getIntrinsicWidth() / 2);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_521582144 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_521582144;
            // ---------- Original Method ----------
            //return drawable.getIntrinsicWidth() / 2;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.785 -0400", hash_original_method = "0786A2C72AD62CB255408C178910DEC1", hash_generated_method = "D3B20426853C5F2A5F383B4D1E8CE83E")
        @Override
        public boolean onTouchEvent(MotionEvent ev) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            final boolean result = super.onTouchEvent(ev);
switch(ev.getActionMasked()){
            case MotionEvent.ACTION_DOWN:
            mDownPositionX = ev.getRawX();
            mDownPositionY = ev.getRawY();
            break;
            case MotionEvent.ACTION_UP:
            if(!offsetHasBeenChanged())            
            {
                final float deltaX = mDownPositionX - ev.getRawX();
                final float deltaY = mDownPositionY - ev.getRawY();
                final float distanceSquared = deltaX * deltaX + deltaY * deltaY;
                if(distanceSquared < mSquaredTouchSlopDistance)                
                {
                    if(mActionPopupWindow != null && mActionPopupWindow.isShowing())                    
                    {
                        mActionPopupWindow.hide();
                    } //End block
                    else
                    {
                        showWithActionPopup();
                    } //End block
                } //End block
            } //End block
            hideAfterDelay();
            break;
            case MotionEvent.ACTION_CANCEL:
            hideAfterDelay();
            break;
            default:
            break;
}            boolean varB4A88417B3D0170D754C647C30B7216A_1784634265 = (result);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1828077386 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1828077386;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.785 -0400", hash_original_method = "CA0934B91A8FE7B0CF5B9D9FD475827B", hash_generated_method = "26FC783C5D0966DAB938C3F398807DE9")
        @Override
        public int getCurrentCursorOffset() {
            int varAC7581A9EB0F8739A03EB94EE7EDC326_493221372 = (TextView.this.getSelectionStart());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1858111022 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1858111022;
            // ---------- Original Method ----------
            //return TextView.this.getSelectionStart();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.785 -0400", hash_original_method = "A55C2EA19B8C1EC0135F14E2406421A5", hash_generated_method = "A57C48B6A4DFF49DCC5A9FF6027323BE")
        @Override
        public void updateSelection(int offset) {
            addTaint(offset);
            Selection.setSelection((Spannable) mText, offset);
            // ---------- Original Method ----------
            //Selection.setSelection((Spannable) mText, offset);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.785 -0400", hash_original_method = "76FEC5259BD2EF7A10D2C6D9447263AD", hash_generated_method = "C202417CECB5387F0851E9AFF2AA5C3F")
        @Override
        public void updatePosition(float x, float y) {
            addTaint(y);
            addTaint(x);
            positionAtCursorOffset(getOffsetForPosition(x, y), false);
            // ---------- Original Method ----------
            //positionAtCursorOffset(getOffsetForPosition(x, y), false);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.785 -0400", hash_original_method = "DF26232D8C6513289215597105F4C19A", hash_generated_method = "78394009F817C89807523E4EB6438C76")
        @Override
         void onHandleMoved() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            super.onHandleMoved();
            removeHiderCallback();
            // ---------- Original Method ----------
            //super.onHandleMoved();
            //removeHiderCallback();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.786 -0400", hash_original_method = "58D1696EBF955B571F830BA2F6EDC257", hash_generated_method = "8A539C8A229F23A70E85F98BCBADCFB1")
        @Override
        public void onDetached() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            super.onDetached();
            removeHiderCallback();
            // ---------- Original Method ----------
            //super.onDetached();
            //removeHiderCallback();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.786 -0400", hash_original_field = "18BCA025F38FDD875DD515112EA41675", hash_generated_field = "6C20793C8F6CDE2B4C4C7A5C8F5C1B65")

        private static final int DELAY_BEFORE_HANDLE_FADES_OUT = 4000;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.786 -0400", hash_original_field = "936EA1DD438E31BBD9024754C3C0C340", hash_generated_field = "F31F61562A37EF5E0681F9FDEFBC7D4B")

        private static final int RECENT_CUT_COPY_DURATION = 15 * 1000;
    }


    
    private class SelectionStartHandleView extends HandleView {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.786 -0400", hash_original_method = "83BC78691BC747F1E4426492F397A3E5", hash_generated_method = "65847D0262D28D67C46A9227385E844A")
        public  SelectionStartHandleView(Drawable drawableLtr, Drawable drawableRtl) {
            super(drawableLtr, drawableRtl);
            addTaint(drawableRtl.getTaint());
            addTaint(drawableLtr.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.786 -0400", hash_original_method = "E4FEF24C3E269A0B427919DBE201803F", hash_generated_method = "FA9879877DE49BC892AD7F7057D0876D")
        @Override
        protected int getHotspotX(Drawable drawable, boolean isRtlRun) {
            addTaint(isRtlRun);
            addTaint(drawable.getTaint());
            if(isRtlRun)            
            {
                int varFA7352ABE2C7C30A76A6773387C63BF8_194914753 = (drawable.getIntrinsicWidth() / 4);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_167652863 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_167652863;
            } //End block
            else
            {
                int varA411DE56B43762557F3EDEDA6A234C5B_1277831687 = ((drawable.getIntrinsicWidth() * 3) / 4);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_496589547 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_496589547;
            } //End block
            // ---------- Original Method ----------
            //if (isRtlRun) {
                //return drawable.getIntrinsicWidth() / 4;
            //} else {
                //return (drawable.getIntrinsicWidth() * 3) / 4;
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.787 -0400", hash_original_method = "CA0934B91A8FE7B0CF5B9D9FD475827B", hash_generated_method = "6074B9DDA6A96AC4332F9C581A0C050D")
        @Override
        public int getCurrentCursorOffset() {
            int varAC7581A9EB0F8739A03EB94EE7EDC326_1370750203 = (TextView.this.getSelectionStart());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1021952959 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1021952959;
            // ---------- Original Method ----------
            //return TextView.this.getSelectionStart();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.787 -0400", hash_original_method = "E42DF79873294756C3452434D16E6BD3", hash_generated_method = "F1BAFF55FBA59CEADEFF89AAD169A469")
        @Override
        public void updateSelection(int offset) {
            addTaint(offset);
            Selection.setSelection((Spannable) mText, offset, getSelectionEnd());
            updateDrawable();
            // ---------- Original Method ----------
            //Selection.setSelection((Spannable) mText, offset, getSelectionEnd());
            //updateDrawable();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.787 -0400", hash_original_method = "7B45D907648A79384D6568EC81E6D22D", hash_generated_method = "0A261C38FEB47D6F945FED8AD2D53EE8")
        @Override
        public void updatePosition(float x, float y) {
            addTaint(y);
            addTaint(x);
            int offset = getOffsetForPosition(x, y);
            final int selectionEnd = getSelectionEnd();
            if(offset >= selectionEnd)            
            offset = Math.max(0, selectionEnd - 1);
            positionAtCursorOffset(offset, false);
            // ---------- Original Method ----------
            //int offset = getOffsetForPosition(x, y);
            //final int selectionEnd = getSelectionEnd();
            //if (offset >= selectionEnd) offset = Math.max(0, selectionEnd - 1);
            //positionAtCursorOffset(offset, false);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.787 -0400", hash_original_method = "0C631CE72876F998F945C3B67884BC26", hash_generated_method = "7DDE8A53D89F9FE805CB730B4D4B404B")
        public ActionPopupWindow getActionPopupWindow() {
ActionPopupWindow var3F2B261F2D71DA806654E78DEF3CA75B_1784940343 =             mActionPopupWindow;
            var3F2B261F2D71DA806654E78DEF3CA75B_1784940343.addTaint(taint);
            return var3F2B261F2D71DA806654E78DEF3CA75B_1784940343;
            // ---------- Original Method ----------
            //return mActionPopupWindow;
        }

        
    }


    
    private class SelectionEndHandleView extends HandleView {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.788 -0400", hash_original_method = "883DF21D67E4B772D6E1A322F4D5F533", hash_generated_method = "E1A834771E423E95589187E1C7E086F2")
        public  SelectionEndHandleView(Drawable drawableLtr, Drawable drawableRtl) {
            super(drawableLtr, drawableRtl);
            addTaint(drawableRtl.getTaint());
            addTaint(drawableLtr.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.788 -0400", hash_original_method = "6A8A8B43FF48B8BB585E51FD6E86C9E2", hash_generated_method = "9A8A3AC5C9CA1E09D51C7C1BAFCD928F")
        @Override
        protected int getHotspotX(Drawable drawable, boolean isRtlRun) {
            addTaint(isRtlRun);
            addTaint(drawable.getTaint());
            if(isRtlRun)            
            {
                int varA411DE56B43762557F3EDEDA6A234C5B_1118459850 = ((drawable.getIntrinsicWidth() * 3) / 4);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_521881023 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_521881023;
            } //End block
            else
            {
                int varFA7352ABE2C7C30A76A6773387C63BF8_1826477565 = (drawable.getIntrinsicWidth() / 4);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_928175 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_928175;
            } //End block
            // ---------- Original Method ----------
            //if (isRtlRun) {
                //return (drawable.getIntrinsicWidth() * 3) / 4;
            //} else {
                //return drawable.getIntrinsicWidth() / 4;
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.788 -0400", hash_original_method = "CA6DDFB8F86FC43076502B090D003904", hash_generated_method = "A83EBF4DB9FF71CCE04508572CADE976")
        @Override
        public int getCurrentCursorOffset() {
            int varFC3058DE12F6475C0398F97CD52036F3_209424155 = (TextView.this.getSelectionEnd());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_340158385 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_340158385;
            // ---------- Original Method ----------
            //return TextView.this.getSelectionEnd();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.789 -0400", hash_original_method = "B3473CE6965F2521B605BA0101D0A91A", hash_generated_method = "FAEB1A39D1BC2C44E27AF4D3F01E7533")
        @Override
        public void updateSelection(int offset) {
            addTaint(offset);
            Selection.setSelection((Spannable) mText, getSelectionStart(), offset);
            updateDrawable();
            // ---------- Original Method ----------
            //Selection.setSelection((Spannable) mText, getSelectionStart(), offset);
            //updateDrawable();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.789 -0400", hash_original_method = "DE26EB392137324C128BF7B92FEE748A", hash_generated_method = "C1BFC54AAD7BD6E4CE2E7C77ADD2B0EF")
        @Override
        public void updatePosition(float x, float y) {
            addTaint(y);
            addTaint(x);
            int offset = getOffsetForPosition(x, y);
            final int selectionStart = getSelectionStart();
            if(offset <= selectionStart)            
            offset = Math.min(selectionStart + 1, mText.length());
            positionAtCursorOffset(offset, false);
            // ---------- Original Method ----------
            //int offset = getOffsetForPosition(x, y);
            //final int selectionStart = getSelectionStart();
            //if (offset <= selectionStart) offset = Math.min(selectionStart + 1, mText.length());
            //positionAtCursorOffset(offset, false);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.789 -0400", hash_original_method = "1AE0953CF1E401F1791B2AA9D0C762E1", hash_generated_method = "08BE3329E0E77A120721FCB14CCD6CCF")
        public void setActionPopupWindow(ActionPopupWindow actionPopupWindow) {
            addTaint(actionPopupWindow.getTaint());
            mActionPopupWindow = actionPopupWindow;
            // ---------- Original Method ----------
            //mActionPopupWindow = actionPopupWindow;
        }

        
    }


    
    private class InsertionPointCursorController implements CursorController {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.789 -0400", hash_original_field = "D82B253C7CDC2B84A5A684E7A5D691F6", hash_generated_field = "25F2B1ECCF00A4687A034C77E527EB90")

        private InsertionHandleView mHandle;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.790 -0400", hash_original_method = "85F6797FDF607C95B81DF68401917B00", hash_generated_method = "85F6797FDF607C95B81DF68401917B00")
        public InsertionPointCursorController ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.790 -0400", hash_original_method = "5D45AEF69914729B932C554DDDCEB4D3", hash_generated_method = "5EA31E88AA733E4213C40495380DD157")
        public void show() {
            getHandle().show();
            // ---------- Original Method ----------
            //getHandle().show();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.790 -0400", hash_original_method = "BEDA636D814D43341B0837622BB75D12", hash_generated_method = "16B9CF12A56CC458EBA14E68A570766E")
        public void showWithActionPopup() {
            getHandle().showWithActionPopup();
            // ---------- Original Method ----------
            //getHandle().showWithActionPopup();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.790 -0400", hash_original_method = "99DAD3C319227F2A1F78AE95D96BD2B3", hash_generated_method = "3B8121EEAEEA7016269A5333F2DB4C49")
        public void hide() {
            if(mHandle != null)            
            {
                mHandle.hide();
            } //End block
            // ---------- Original Method ----------
            //if (mHandle != null) {
                //mHandle.hide();
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.790 -0400", hash_original_method = "43F562659DF9586EE8DC985200A1394B", hash_generated_method = "131898B5E8F2D0F63892F56335E6DF07")
        public void onTouchModeChanged(boolean isInTouchMode) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(isInTouchMode);
            if(!isInTouchMode)            
            {
                hide();
            } //End block
            // ---------- Original Method ----------
            //if (!isInTouchMode) {
                //hide();
            //}
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.791 -0400", hash_original_method = "AFBF832B3C2DD5F3EC6366306B6BB027", hash_generated_method = "21D5922910EA231D3BDCA7F79B49B607")
        private InsertionHandleView getHandle() {
            if(mSelectHandleCenter == null)            
            {
                mSelectHandleCenter = mContext.getResources().getDrawable(
                        mTextSelectHandleRes);
            } //End block
            if(mHandle == null)            
            {
                mHandle = new InsertionHandleView(mSelectHandleCenter);
            } //End block
InsertionHandleView varD901D87B73FFED5C94BAE428F6AEDBC4_1129145849 =             mHandle;
            varD901D87B73FFED5C94BAE428F6AEDBC4_1129145849.addTaint(taint);
            return varD901D87B73FFED5C94BAE428F6AEDBC4_1129145849;
            // ---------- Original Method ----------
            //if (mSelectHandleCenter == null) {
                //mSelectHandleCenter = mContext.getResources().getDrawable(
                        //mTextSelectHandleRes);
            //}
            //if (mHandle == null) {
                //mHandle = new InsertionHandleView(mSelectHandleCenter);
            //}
            //return mHandle;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.791 -0400", hash_original_method = "5CA35A7F100FC077200BA56F0D1F67CB", hash_generated_method = "565B8DDD912D90384D8C4FA3B0C7D7AF")
        @Override
        public void onDetached() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            final ViewTreeObserver observer = getViewTreeObserver();
            observer.removeOnTouchModeChangeListener(this);
            if(mHandle != null)            
            mHandle.onDetached();
            // ---------- Original Method ----------
            //final ViewTreeObserver observer = getViewTreeObserver();
            //observer.removeOnTouchModeChangeListener(this);
            //if (mHandle != null) mHandle.onDetached();
        }

        
    }


    
    private class SelectionModifierCursorController implements CursorController {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.791 -0400", hash_original_field = "1DDEE8F82039A4BD80420CF27F9E1A6A", hash_generated_field = "0F7E872CABC7DF9A40441A432FBD1FBF")

        private SelectionStartHandleView mStartHandle;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.791 -0400", hash_original_field = "7F3172BBEA8484D85B326E672A5A423F", hash_generated_field = "19A28AD860044ACC5058053954B56AC1")

        private SelectionEndHandleView mEndHandle;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.791 -0400", hash_original_field = "17546985D71D9022C1E12FDE1CAFC6E5", hash_generated_field = "6FCDDDBC590A39D5D0BCAFDBA6EA63E5")

        private int mMinTouchOffset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.791 -0400", hash_original_field = "690ACF87EFB1963C7A4637EB14226F0B", hash_generated_field = "F147B97F09325CC9B6538D3E5D26C2FE")

        private int mMaxTouchOffset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.791 -0400", hash_original_field = "EEB78043F7A84B6B33C67CCCFE8BE924", hash_generated_field = "7CECB42F787323EA52A439F784FC8CBE")

        private long mPreviousTapUpTime = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.791 -0400", hash_original_field = "868B14065502FE9C1E526C78E73FCAF9", hash_generated_field = "0BA74B206DFC70E28F82C95A0E3C40BF")

        private float mPreviousTapPositionX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.791 -0400", hash_original_field = "78D2D33220DDE6DE9E8A068208CC3141", hash_generated_field = "1F4747912771D340E5AE19794AD2D9A3")

        private float mPreviousTapPositionY;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.793 -0400", hash_original_method = "7762686ED4BD194662F98430835FCC93", hash_generated_method = "996EF3777B9152A62DF6DD828F075A23")
          SelectionModifierCursorController() {
            resetTouchOffsets();
            // ---------- Original Method ----------
            //resetTouchOffsets();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.793 -0400", hash_original_method = "803DF98A86477F9509B518860444CA62", hash_generated_method = "2937CB44283E9067E58180833B043EFA")
        public void show() {
            if(isInBatchEditMode())            
            {
                return;
            } //End block
            initDrawables();
            initHandles();
            hideInsertionPointCursorController();
            // ---------- Original Method ----------
            //if (isInBatchEditMode()) {
                //return;
            //}
            //initDrawables();
            //initHandles();
            //hideInsertionPointCursorController();
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.793 -0400", hash_original_method = "2C322B9176F95E96CE86AF105C0AA144", hash_generated_method = "2288EBFE26ECB54F6AD50A81C986B5BF")
        private void initDrawables() {
            if(mSelectHandleLeft == null)            
            {
                mSelectHandleLeft = mContext.getResources().getDrawable(
                        mTextSelectHandleLeftRes);
            } //End block
            if(mSelectHandleRight == null)            
            {
                mSelectHandleRight = mContext.getResources().getDrawable(
                        mTextSelectHandleRightRes);
            } //End block
            // ---------- Original Method ----------
            //if (mSelectHandleLeft == null) {
                //mSelectHandleLeft = mContext.getResources().getDrawable(
                        //mTextSelectHandleLeftRes);
            //}
            //if (mSelectHandleRight == null) {
                //mSelectHandleRight = mContext.getResources().getDrawable(
                        //mTextSelectHandleRightRes);
            //}
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.793 -0400", hash_original_method = "C3351664D38EE8E6983EFA56F5011D2A", hash_generated_method = "0FF33963BE8CF7572758034670E1DC89")
        private void initHandles() {
            if(mStartHandle == null)            
            {
                mStartHandle = new SelectionStartHandleView(mSelectHandleLeft, mSelectHandleRight);
            } //End block
            if(mEndHandle == null)            
            {
                mEndHandle = new SelectionEndHandleView(mSelectHandleRight, mSelectHandleLeft);
            } //End block
            mStartHandle.show();
            mEndHandle.show();
            mStartHandle.showActionPopupWindow(DELAY_BEFORE_REPLACE_ACTION);
            mEndHandle.setActionPopupWindow(mStartHandle.getActionPopupWindow());
            hideInsertionPointCursorController();
            // ---------- Original Method ----------
            //if (mStartHandle == null) {
                //mStartHandle = new SelectionStartHandleView(mSelectHandleLeft, mSelectHandleRight);
            //}
            //if (mEndHandle == null) {
                //mEndHandle = new SelectionEndHandleView(mSelectHandleRight, mSelectHandleLeft);
            //}
            //mStartHandle.show();
            //mEndHandle.show();
            //mStartHandle.showActionPopupWindow(DELAY_BEFORE_REPLACE_ACTION);
            //mEndHandle.setActionPopupWindow(mStartHandle.getActionPopupWindow());
            //hideInsertionPointCursorController();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.793 -0400", hash_original_method = "9904AE40606D29E60FAC10481978E041", hash_generated_method = "1A6CEA650DB10118D2948383FB7E8A8B")
        public void hide() {
            if(mStartHandle != null)            
            mStartHandle.hide();
            if(mEndHandle != null)            
            mEndHandle.hide();
            // ---------- Original Method ----------
            //if (mStartHandle != null) mStartHandle.hide();
            //if (mEndHandle != null) mEndHandle.hide();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.798 -0400", hash_original_method = "4BB059019645E4258A18514D6F6D1609", hash_generated_method = "C40C694AABC9FBAB462D0E1D68DB8AC2")
        public void onTouchEvent(MotionEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(event.getTaint());
switch(event.getActionMasked()){
            case MotionEvent.ACTION_DOWN:
            final float x = event.getX();
            final float y = event.getY();
            mMinTouchOffset = mMaxTouchOffset = getOffsetForPosition(x, y);
            long duration = SystemClock.uptimeMillis() - mPreviousTapUpTime;
            if(duration <= ViewConfiguration.getDoubleTapTimeout() &&
                            isPositionOnText(x, y))            
            {
                final float deltaX = x - mPreviousTapPositionX;
                final float deltaY = y - mPreviousTapPositionY;
                final float distanceSquared = deltaX * deltaX + deltaY * deltaY;
                if(distanceSquared < mSquaredTouchSlopDistance)                
                {
                    startSelectionActionMode();
                    mDiscardNextActionUp = true;
                } //End block
            } //End block
            mPreviousTapPositionX = x;
            mPreviousTapPositionY = y;
            break;
            case MotionEvent.ACTION_POINTER_DOWN:
            case MotionEvent.ACTION_POINTER_UP:
            if(mContext.getPackageManager().hasSystemFeature(
                            PackageManager.FEATURE_TOUCHSCREEN_MULTITOUCH_DISTINCT))            
            {
                updateMinAndMaxOffsets(event);
            } //End block
            break;
            case MotionEvent.ACTION_UP:
            mPreviousTapUpTime = SystemClock.uptimeMillis();
            break;
}
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.798 -0400", hash_original_method = "ABEB7C98C3FEAD2725211345FA5A10D0", hash_generated_method = "A7C49DB0FE38BEBE3EDE150F28860C2C")
        private void updateMinAndMaxOffsets(MotionEvent event) {
            addTaint(event.getTaint());
            int pointerCount = event.getPointerCount();
for(int index = 0;index < pointerCount;index++)
            {
                int offset = getOffsetForPosition(event.getX(index), event.getY(index));
                if(offset < mMinTouchOffset)                
                mMinTouchOffset = offset;
                if(offset > mMaxTouchOffset)                
                mMaxTouchOffset = offset;
            } //End block
            // ---------- Original Method ----------
            //int pointerCount = event.getPointerCount();
            //for (int index = 0; index < pointerCount; index++) {
                //int offset = getOffsetForPosition(event.getX(index), event.getY(index));
                //if (offset < mMinTouchOffset) mMinTouchOffset = offset;
                //if (offset > mMaxTouchOffset) mMaxTouchOffset = offset;
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.799 -0400", hash_original_method = "CE1D6B62E449D2E0E68A6EA4156BEDFA", hash_generated_method = "FF6836CE1559702B8812B97E64F08DD4")
        public int getMinTouchOffset() {
            int var17546985D71D9022C1E12FDE1CAFC6E5_1233180799 = (mMinTouchOffset);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1656318389 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1656318389;
            // ---------- Original Method ----------
            //return mMinTouchOffset;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.799 -0400", hash_original_method = "C55B3C28483F8C218641DDDF4F4BCFF7", hash_generated_method = "3D44E29B91037733345E9A7BA616F09F")
        public int getMaxTouchOffset() {
            int var690ACF87EFB1963C7A4637EB14226F0B_1404138685 = (mMaxTouchOffset);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_767026473 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_767026473;
            // ---------- Original Method ----------
            //return mMaxTouchOffset;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.799 -0400", hash_original_method = "4C87B6BF406B366B26A5C4FE4B60E794", hash_generated_method = "9EFAFC374F80667294B5FCC935B7A9C3")
        public void resetTouchOffsets() {
            mMinTouchOffset = mMaxTouchOffset = -1;
            // ---------- Original Method ----------
            //mMinTouchOffset = mMaxTouchOffset = -1;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.806 -0400", hash_original_method = "CED25BB71024452A25A320AF88BD1346", hash_generated_method = "BECABEC7507080C36C6E232B89C9CFEA")
        public boolean isSelectionStartDragged() {
            boolean varD1AA568C293772C2612D678D0F58A190_210006742 = (mStartHandle != null && mStartHandle.isDragging());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1833477542 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1833477542;
            // ---------- Original Method ----------
            //return mStartHandle != null && mStartHandle.isDragging();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.806 -0400", hash_original_method = "43F562659DF9586EE8DC985200A1394B", hash_generated_method = "131898B5E8F2D0F63892F56335E6DF07")
        public void onTouchModeChanged(boolean isInTouchMode) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(isInTouchMode);
            if(!isInTouchMode)            
            {
                hide();
            } //End block
            // ---------- Original Method ----------
            //if (!isInTouchMode) {
                //hide();
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.806 -0400", hash_original_method = "190B38DD5A1110FFE55D8237DE7DCE67", hash_generated_method = "9C3AD4C590E5F34BBF5E401DBDCBA521")
        @Override
        public void onDetached() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            final ViewTreeObserver observer = getViewTreeObserver();
            observer.removeOnTouchModeChangeListener(this);
            if(mStartHandle != null)            
            mStartHandle.onDetached();
            if(mEndHandle != null)            
            mEndHandle.onDetached();
            // ---------- Original Method ----------
            //final ViewTreeObserver observer = getViewTreeObserver();
            //observer.removeOnTouchModeChangeListener(this);
            //if (mStartHandle != null) mStartHandle.onDetached();
            //if (mEndHandle != null) mEndHandle.onDetached();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.806 -0400", hash_original_field = "8D0BCBE22EC74AB6363483A97E74D867", hash_generated_field = "8C0DD79BB03BF5A19DC440BA5A7C743D")

        private static final int DELAY_BEFORE_REPLACE_ACTION = 200;
    }


    
    public interface OnEditorActionListener {
        
        boolean onEditorAction(TextView v, int actionId, KeyEvent event);
    }
    
    private interface TextViewPositionListener {
        public void updatePosition(int parentPositionX, int parentPositionY,
                boolean parentPositionChanged, boolean parentScrolled);
    }
    
    private interface CursorController extends ViewTreeObserver.OnTouchModeChangeListener {
        
        public void show();

        
        public void hide();

        
        public void onDetached();
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.807 -0400", hash_original_field = "90BF1EE71A4DB43CBA163484BD738881", hash_generated_field = "318C0D140A347FB72B8CF35CDBABB5E4")

    static final String LOG_TAG = "TextView";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.807 -0400", hash_original_field = "A4A1A96FF2E19D971B2D301080EE8C58", hash_generated_field = "8F4574CB2F6E43394A5BA522A2B5B852")

    static final boolean DEBUG_EXTRACT = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.807 -0400", hash_original_field = "18CA7A508D8AE1730B8CBC0435F40D92", hash_generated_field = "0C5EC1740FD044550CD627FFA2580630")

    private static final int PRIORITY = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.807 -0400", hash_original_field = "5C25431CEAC1058F7B4F73D132DD44B4", hash_generated_field = "45D348A3F29C90D42A8C5DC6B241EAC1")

    private static final int PREDRAW_NOT_REGISTERED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.807 -0400", hash_original_field = "21B0F640D768604C58C1490A1DFBA771", hash_generated_field = "62D44753BF78CBC0F9661335F4D5609E")

    private static final int PREDRAW_PENDING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.807 -0400", hash_original_field = "8A7412722DCADF6CC4FAEE79ED70EACB", hash_generated_field = "363B97B9FD402B0FDBC0C24AF5E9CCFB")

    private static final int PREDRAW_DONE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.807 -0400", hash_original_field = "07F356F3070D07B6930DE3A9967108FE", hash_generated_field = "308BD7C2CCB94571F8E68E822492425A")

    private static final int SANS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.807 -0400", hash_original_field = "5B5E6C83C125CC348E4EE28ACCFE5BFF", hash_generated_field = "AD8E248EA94D9FBB450731AC61EA4CF6")

    private static final int SERIF = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.807 -0400", hash_original_field = "399280F48C3EEEEAEAD47346CF3011F2", hash_generated_field = "1E362376CB7EB57CA2898CE49E4D3589")

    private static final int MONOSPACE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.807 -0400", hash_original_field = "EFFD644F69714ABFB2C24FDB3792270D", hash_generated_field = "8603C5457C9E9D466A6637F82152429F")

    private static final int SIGNED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.807 -0400", hash_original_field = "A3C08F2EE3FEAB3A87DC101CC1A0E1B0", hash_generated_field = "F04391D0E1DECB4D13494A519EEF830A")

    private static final int DECIMAL = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.807 -0400", hash_original_field = "B5762757AEE684A93E08453DCC72718E", hash_generated_field = "0A9F849D4DA2786122725914FA369286")

    private static final int MARQUEE_FADE_NORMAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.807 -0400", hash_original_field = "685E750B6695CBAA6027EFEBD1DD0929", hash_generated_field = "133D51D3A4503E091F405407040E7EC2")

    private static final int MARQUEE_FADE_SWITCH_SHOW_ELLIPSIS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.807 -0400", hash_original_field = "BAD4122AB746D6D5A26349392348653A", hash_generated_field = "B9CEA3C7890F9A20881FBE5B1B4F328A")

    private static final int MARQUEE_FADE_SWITCH_SHOW_FADE = 2;
    static {
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.measureText("H");
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.807 -0400", hash_original_field = "3495E75508822AD7294B9D1B2FFFD8F2", hash_generated_field = "809D152A38BBF91CF345EB9A3A2C2FD9")

    static final int EXTRACT_NOTHING = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.807 -0400", hash_original_field = "CE33E876E6E0D3413392BF4D8BA5058C", hash_generated_field = "7BA27C744DDFC4A241AE9CAF8C089243")

    static final int EXTRACT_UNKNOWN = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.807 -0400", hash_original_field = "9D2F26242AC02A08143A50067F62CB8B", hash_generated_field = "629A8FC22D1527458B2653CFE43B483D")

    private static final BoringLayout.Metrics UNKNOWN_BORING = new BoringLayout.Metrics();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.807 -0400", hash_original_field = "335E7B933E2786DDEF5BD0BD0D6F57B7", hash_generated_field = "F08D4DB64B803815AE7522F1172B7B26")

    private static final int ID_SELECT_ALL = android.R.id.selectAll;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.807 -0400", hash_original_field = "FCF0B45B56220E42037E2959D5C784C5", hash_generated_field = "45199D67295B65909EEDA2BE3B9357D0")

    private static final int ID_CUT = android.R.id.cut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.807 -0400", hash_original_field = "B59ED8F62B5AFBC9ECFF0B033CA31BFE", hash_generated_field = "BDD63BE32ED24AFE6036B6E73DCBA9C7")

    private static final int ID_COPY = android.R.id.copy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.807 -0400", hash_original_field = "C538E3A9644EFB1E101695160425236B", hash_generated_field = "5F09992E187A3237CB33E9C773AB2BFD")

    private static final int ID_PASTE = android.R.id.paste;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.807 -0400", hash_original_field = "73F3CAC515701006490A63FE8A88C6C6", hash_generated_field = "6B7729A476E0DC23D4228210CAC8F2AF")

    private static final int LINES = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.807 -0400", hash_original_field = "73A4320C88A11B2FCF58BE496FEEA70E", hash_generated_field = "38D0380954D68681C2B16AF77B10E2B1")

    private static final int EMS = LINES;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.807 -0400", hash_original_field = "0A7D60D23D133E25B638079E87CAA132", hash_generated_field = "F3B05802BBCCF9A648D3A31248579690")

    private static final int PIXELS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.807 -0400", hash_original_field = "213EEEA9607FBD0242D99285FE74967E", hash_generated_field = "F1AA779AD4EF6BDB726801C8FA756FE2")

    private static final RectF sTempRect = new RectF();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.807 -0400", hash_original_field = "8212A1E8877C71B5CDD8A07429A76426", hash_generated_field = "B1C3BA47068027642A7B08D73ED520A7")

    private static final float[] sTmpPosition = new float[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.807 -0400", hash_original_field = "E200AB0F64D5773E76DC3D915E17A741", hash_generated_field = "BE987383F3E2A020A9B790ED1BD41CEC")

    private static final int VERY_WIDE = 1024*1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.808 -0400", hash_original_field = "C9D1C26ABB8B6EF477DF5359176F9D87", hash_generated_field = "75590DDE5A63D4C5AC8A6BCF800B7F27")

    private static final int BLINK = 500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.808 -0400", hash_original_field = "D4B6C25D0A03D262C947BCD869108225", hash_generated_field = "D83A807392D6236B9C81A46BCD93EAD5")

    private static final int ANIMATED_SCROLL_GAP = 250;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.808 -0400", hash_original_field = "A0DA38A5AAD1658278F1D161AF84C1BC", hash_generated_field = "EDD7FE0B7D12EE9C3486272F367681B2")

    private static final InputFilter[] NO_FILTERS = new InputFilter[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.808 -0400", hash_original_field = "248F542BD33F18FF283146E6429096A7", hash_generated_field = "14183BB546091CFA567F945F2B307159")

    private static final Spanned EMPTY_SPANNED = new SpannedString("");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.808 -0400", hash_original_field = "988659B291D672B8BE5DAE064AE3ECAA", hash_generated_field = "7034D880E0F4FCBF3812B9BF24C47313")

    private static int DRAG_SHADOW_MAX_TEXT_LENGTH = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.808 -0400", hash_original_field = "1D09C86A4C0CE5611F928ED8E5FF76B7", hash_generated_field = "191F5BCD79A0AB522145FB777A15B556")

    private static long sLastCutOrCopyTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.808 -0400", hash_original_field = "722A3224076063AF8DBCF4E5714C29A3", hash_generated_field = "426A62F90365670637A2793B721C0BE6")

    private static final int[] MULTILINE_STATE_SET = { R.attr.state_multiline };
}

