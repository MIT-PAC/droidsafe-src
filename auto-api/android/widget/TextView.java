package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.R;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.726 -0400", hash_original_field = "5C9E3264119E57696644BE19B3FE1DAC", hash_generated_field = "695EE05B4D22A341938A08B09254F27D")

    private int mCurrentAlpha = 255;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.726 -0400", hash_original_field = "5F09FBDC9860691A5956F34FA173E62B", hash_generated_field = "BAE1383AB87BD7B338A209B29BBF86C2")

    final int[] mTempCoords = new int[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.726 -0400", hash_original_field = "B856E02779DE10EA84221FCD1182A1A3", hash_generated_field = "9F1BD97088B2257F3EF12D8B258FBB69")

    Rect mTempRect;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.726 -0400", hash_original_field = "D617392BE941E0902ECF95DB04F038E8", hash_generated_field = "F28951B95CC06B6EA971BC050BE7DE22")

    private ColorStateList mTextColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.726 -0400", hash_original_field = "284F9A87F549A6DC680E2D58A116EBA3", hash_generated_field = "DDC7D6F23AA3E68217EEBC390EBBF804")

    private int mCurTextColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.726 -0400", hash_original_field = "F97B29F3780CA1FC4E9BEA1ABC67D847", hash_generated_field = "9F10F4704A7B04F2C4871DD09D608BF0")

    private ColorStateList mHintTextColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.726 -0400", hash_original_field = "68148E7850655C81DB19FCC253D99F98", hash_generated_field = "AE6720DC2457713C725D4C56460C9DC2")

    private ColorStateList mLinkTextColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.726 -0400", hash_original_field = "CFE453DD74E7FC90BED21ABE94CDF43F", hash_generated_field = "5A275158889F26A8351A14A4F8F0D9DD")

    private int mCurHintTextColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.726 -0400", hash_original_field = "BAD96035AC86533B7D8C4EAA84835DC4", hash_generated_field = "8D828812FF76F4DB76DB63A2398AF5C6")

    private boolean mFreezesText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.726 -0400", hash_original_field = "201B24234F3C5EAB7B9E6C89937009ED", hash_generated_field = "DC2B1736EBA532012F131A593130D38C")

    private boolean mFrozenWithFocus;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.726 -0400", hash_original_field = "7A52CFFAF3A3D05848839CC4A3DCBF66", hash_generated_field = "C16E2255547619A01263AC9BE7B2E134")

    private boolean mTemporaryDetach;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.726 -0400", hash_original_field = "F42B4922CBBBAC0A00222DB39CFC509A", hash_generated_field = "5C6A9DB416A74CA58302EC973E49E0E3")

    private boolean mDispatchTemporaryDetach;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.726 -0400", hash_original_field = "4A82A355E70C4C4283892E1CED60A9AB", hash_generated_field = "9EDEB4E5741E85F20A0B3026682B4863")

    private boolean mDiscardNextActionUp = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.726 -0400", hash_original_field = "9074015FCBB83111EEFF764D36799E0A", hash_generated_field = "7878E8941BAE988F39F461EEC8B7CCDF")

    private boolean mIgnoreActionUpEvent = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.726 -0400", hash_original_field = "737580135BF67E97C636411ED2235180", hash_generated_field = "6D10B174FA8E858FA02AA86D85663AD4")

    private Editable.Factory mEditableFactory = Editable.Factory.getInstance();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.726 -0400", hash_original_field = "289A806C8E357E566D214939426916BE", hash_generated_field = "10200E22D9B91A38418945F375917DF5")

    private Spannable.Factory mSpannableFactory = Spannable.Factory.getInstance();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.726 -0400", hash_original_field = "0021C70065C1D0F5DA3DE4086470A1AC", hash_generated_field = "E95B50404D53A741F5CBE2BA4A3E9431")

    private float mShadowRadius;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.726 -0400", hash_original_field = "C882880E2E13EA27F677D50AEA4C2D30", hash_generated_field = "CC57606479233D9D93ED0B57219ED7CE")

    private float mShadowDx;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.726 -0400", hash_original_field = "F6C0DA7C4DD70FAC183A5D5D940CBEBF", hash_generated_field = "5A526AAA72A41CBD334BF1D9A433DD2D")

    private float mShadowDy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.726 -0400", hash_original_field = "7302E8BC04F6DCBBC91913A350368A28", hash_generated_field = "A64E4C65A01F6E2CFC767B574B9B2B25")

    private int mPreDrawState = PREDRAW_NOT_REGISTERED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.726 -0400", hash_original_field = "069F6473CFDC9651640842904E9A1296", hash_generated_field = "4984AF4C2DB23A63F16A5A1F70DBBE23")

    private TextUtils.TruncateAt mEllipsize = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "1891CBC78C734C6A7EBB0D921FFE84B0", hash_generated_field = "DA26917F8EABBE7FB6675DEEA4CDD42F")

    private Drawables mDrawables;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "6F8A455C94CBB7A00E920835C0C8964C", hash_generated_field = "8B5DD3B1B3DD08B759F16C26A18B23CA")

    private CharSequence mError;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "AF2B7FEC596D9156D61CB482234E01CC", hash_generated_field = "EA3CC19FBACB277B4E0CFF08BB94E8C5")

    private boolean mErrorWasChanged;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "E863CEB96C01242A6262A422DC21BA91", hash_generated_field = "3D80774243FE973442F872DD04152DA0")

    private ErrorPopup mPopup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "5194879693A231FFFC209BB8D83F7343", hash_generated_field = "6846AAA470F19DD23ADF6122A2BA28EB")

    private boolean mShowErrorAfterAttach;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "F404BF7CA0765A26006895B16ECAFD6F", hash_generated_field = "ED2A81D0AA757272F61284C94F8CB304")

    private CharWrapper mCharWrapper = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "CD0B182A36A51B8060A5E676C89B9336", hash_generated_field = "89CF3363829B7F18DD131036DE4F0A1D")

    private boolean mSelectionMoved = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "2E9AC3E359ECE072850F1292DFBBDAE1", hash_generated_field = "B3FE9FD9576C4C98F6C4A561DFC39377")

    private boolean mTouchFocusSelected = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "E87C3F5C2A7CB77C6DC56288528EBF20", hash_generated_field = "E6A1FEE90A4433FD8B74A8F47A5E0E13")

    private Marquee mMarquee;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "533339E6FBD11F3E45A14F8C0EF95135", hash_generated_field = "E1D72A00A2DFF52C1CB7FA697FBC9898")

    private boolean mRestartMarquee;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "AE8C8553F79BDDDB297AFF9496B70AF4", hash_generated_field = "A706E5A4CE970BDC6898B0827FF2B8CB")

    private int mMarqueeRepeatLimit = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "2E491392BA918DD2D8A686099734FFCA", hash_generated_field = "E1403D58E8CC04D062F12EDE2F93FC48")

    InputContentType mInputContentType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "CAE876BD1DF758FC0DA52C899F537A65", hash_generated_field = "23BEF75E7D0F22ED753350F2B8C53A97")

    InputMethodState mInputMethodState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "B36145192741179BFC019A94217ED239", hash_generated_field = "29065B52E0E09EECA006A7A5A8F78524")

    private int mTextSelectHandleLeftRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "14F0D0E28BFB85ADAF9CBB2462BD60AC", hash_generated_field = "9FC61DEFB614916CB19F9F18AE4BBCF8")

    private int mTextSelectHandleRightRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "AECC1EE6EF517B4633C961D68D0A0721", hash_generated_field = "3CAFBFF7DAB243B3E8841417BD521E3B")

    private int mTextSelectHandleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "F1F871F8469791F3048EECEE2DDAE51A", hash_generated_field = "899920185C4484CA31C0F443B855010D")

    private int mTextEditSuggestionItemLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "7B7F1DB21F46A09A666E491035DEE1ED", hash_generated_field = "EE9100393A7AA7FB8D758BBE48AF5F35")

    private SuggestionsPopupWindow mSuggestionsPopupWindow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "B2BAA47BFF891CBC7774865E53B1B27D", hash_generated_field = "84F489ACE61EF8AEAEC12B2F2593297C")

    private SuggestionRangeSpan mSuggestionRangeSpan;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "F1CB45A993CF82C01E8B9DD86DF31C59", hash_generated_field = "02A74559D19DD086E571BE2B3AA83A8F")

    private int mCursorDrawableRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "9D532FDC5F3401D628291677F396D047", hash_generated_field = "E667A519A6080C5A572800DEC412B8A1")

    private final Drawable[] mCursorDrawable = new Drawable[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "45877EB65372EE0549FF6482C357C77C", hash_generated_field = "8657E501533B875D60AA97A414831DBD")

    private int mCursorCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "C68967AB1B9693AAC052C4158F7203F8", hash_generated_field = "72952B5254D373336CA0A7F293822C5C")

    private Drawable mSelectHandleLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "8DC2F2BCAE53DF5B1B45FBFA787F7CC7", hash_generated_field = "BE0700D1B06984983D5C63B2FD49DB15")

    private Drawable mSelectHandleRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "B0A089E200495488AE5D10A63801B499", hash_generated_field = "08AFAF21E471F629DFA4D8F58C03B94B")

    private Drawable mSelectHandleCenter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "DC2833E523C718C37F76D9CECDB613DC", hash_generated_field = "FB42528DAE75699ED1B6CC0A5A674A55")

    private PositionListener mPositionListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "43041C61A1DA9DC67B7FC8F5C22C953B", hash_generated_field = "40ACD97E99B995A7FCA41633B5D7F459")

    private float mLastDownPositionX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "5211DB32F771F4FB6B254B7227DAF0E4", hash_generated_field = "25FA8F6701B3D1C16B56B376BE78487E")

    private float mLastDownPositionY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "7F39B50ADACE58DDF3868451FDACBFC3", hash_generated_field = "4A2FD1B1A3BA8B998F40B2C0D929E44F")

    private Callback mCustomSelectionActionModeCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "9154AC84CF6CB434E6C44058845F83A6", hash_generated_field = "FE1D03D7C65C5CEC56D15F835C8E0A4C")

    private int mSquaredTouchSlopDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "5D2B1AB08FC4BB71F1E4E3942287F4AC", hash_generated_field = "301C10EAD74C8CF352F89DA817F09EF5")

    private boolean mCreatedWithASelection = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "435FE0944C142BE50AF524B687A36B73", hash_generated_field = "B64007D723854AD8DD3C03BCCA9834A5")

    private WordIterator mWordIterator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "651FF4D8C7C964F5DF1C680A515E9458", hash_generated_field = "D936161C5FDE3DD296D182C31C4ED500")

    private SpellChecker mSpellChecker;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "A9B899D11C5154E2959E6CD08A569B50", hash_generated_field = "9735B231E6C5186126230C7191CC2027")

    private boolean mSoftInputShownOnFocus = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "AE353DD0C65715072A815AA3EFBB914A", hash_generated_field = "AE17667AF244FFA2D2100AF02F19092F")

    private Layout.Alignment mLayoutAlignment;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "C13638B20608314DC4A1841631D399DA", hash_generated_field = "B8FF70A86AC51485598DFBCFFB37720F")

    private TextAlign mTextAlign = TextAlign.INHERIT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "B5E0024E63436049FABCB39FDCDB387F", hash_generated_field = "88A15E3715BB62052F2448ED895C9BBA")

    private boolean mResolvedDrawables = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "8EDC8B08CA53BD0E51A567DB27353463", hash_generated_field = "601913B8190553DCCF7F60EF06AC5711")

    private int mMarqueeFadeMode = MARQUEE_FADE_NORMAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "A88463CF8707DFCA9D81D838EE11C191", hash_generated_field = "2AD0F97487EA7D5F86DCAFC3259ED37F")

    private Layout mSavedMarqueeModeLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "6CF16E724237A2841199FB30284CED38")

    @ViewDebug.ExportedProperty(category = "text") private CharSequence mText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "116BEBA84C265E44D657283E75BE60A1", hash_generated_field = "30221785C9497266E9C8ABBDFDCBE7EC")

    private CharSequence mTransformed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "5E344D0215B7C42F8F0B334676E4F343", hash_generated_field = "D0147D76A56855726ED38FF51B24F6FD")

    private BufferType mBufferType = BufferType.NORMAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "F5F439B44EA2FC34C5A7743F482ED12E", hash_generated_field = "7CCB62B854814A590D259304E0729FB4")

    private int mInputType = EditorInfo.TYPE_NULL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "A6D986505B9BCC5256C3BA5D73171C37", hash_generated_field = "D5CD99D8D87E7592EC6B5781C6FFB2FA")

    private CharSequence mHint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "D2F4B35B64C2568AE9793BBC2586054D", hash_generated_field = "EFAB677B32664E9E21A5DE46AC4EC1D6")

    private Layout mHintLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "BF2A01F10E67DAFA01668D8D4043BDC6", hash_generated_field = "CE990DF015C00781E7408846E8AEC5CB")

    private KeyListener mInput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "4AC20A6658642819EC3222EDB1107622", hash_generated_field = "BFA3240A2EA25F7A99F6D250E98184A7")

    private MovementMethod mMovement;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "BBDAB2FB373D7DA19760B893D5429B4A", hash_generated_field = "5EB7FC8FAB0A2FCCA9E8BF646DA1559A")

    private TransformationMethod mTransformation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "53FA59A802AE59C1CF5E57E2D5BFA622", hash_generated_field = "487D1BC024AFF96C6A5C663DC3AA641C")

    private boolean mAllowTransformationLengthChange;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "9607A29B4CC612A05365947273897FCA", hash_generated_field = "0D3B538949663CFF4038D6D64784977E")

    private ChangeWatcher mChangeWatcher;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "76E8AF78EA383C38A6F80E45CCFEA268", hash_generated_field = "B7D02B86862FFD54C18C460CFF0B0C2C")

    private ArrayList<TextWatcher> mListeners = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "A623C6B7D6CD75F8A26EF2CAD7479AA5", hash_generated_field = "6AD5EFC1421B741B1A8F78A5B815BBFE")

    private TextPaint mTextPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "462CCCBD3E9AD62A8A3FAE775E09DC1E", hash_generated_field = "21DF46CCA8F8000ED3BFF8BCF4D828BF")

    private boolean mUserSetTextScaleX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.727 -0400", hash_original_field = "BA05C1134DA05E6CE3231B819D53C1D5", hash_generated_field = "8983462E53EAFA6E482F98025B0E9AB8")

    private Paint mHighlightPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "CA2322AF1A6B4A09C8EDBDA4A3F74C10", hash_generated_field = "D25F7D2FFD7EFCE07B644E099B3A56D3")

    private int mHighlightColor = 0x6633B5E5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "AF58F50E47532278404C3D8470630FC4", hash_generated_field = "C7DD20DF980F25C7241B09204173E163")

    protected Layout mLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "36BB94A531229DD21F420AABF0C748F8", hash_generated_field = "0FB0111930B8AF18F464AB4FA2C6200F")

    private long mShowCursor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "57ABA66DF5CCF392086380D760C5BF59", hash_generated_field = "AC59C081943B626844E369F1A5892415")

    private Blink mBlink;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "6D2634EB69BE4B718BBEA043740ED62B", hash_generated_field = "F225E507C7DF6D613F7CBC4F577CB716")

    private boolean mCursorVisible = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "A2FF5C87B9A9D291A2D83F0CF574DDB4", hash_generated_field = "FDFA161EB04278A13E9ECB602C9782F4")

    private InsertionPointCursorController mInsertionPointCursorController;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "270783E153A9BE598B5DECCCBEDA6C36", hash_generated_field = "2218505DE3146C01814D6E81956F9301")

    private SelectionModifierCursorController mSelectionModifierCursorController;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "40FBF5FA719BD485A92A81EE27C61592", hash_generated_field = "656A5581A4DED5B2323E4335C55017B9")

    private ActionMode mSelectionActionMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "BC332654D5E01CC0638CB4493BFC9F05", hash_generated_field = "D1C9F3209CB13DAFB4E161EED540694F")

    private boolean mInsertionControllerEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "23C753EE6F79BCE184A6A1DB0589DB51", hash_generated_field = "E71C12A23BD84DA882CBDDBA123ABB17")

    private boolean mSelectionControllerEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "6854FB31EDC4E2B522D358A7D58685A8", hash_generated_field = "60F18FE1AE8CDBA3A5368ABF9BB5958F")

    private boolean mInBatchEditControllers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "37E6CBBA2DC07898D114DB5377D9D2AA", hash_generated_field = "7E20F67A0496D1E1FE6F1DC6D3BACA5D")

    private boolean mSelectAllOnFocus = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "2EF4E086F9141FE348E8A559F50FA1E9", hash_generated_field = "3FFAAA27B6CA268237E3AFE24778DD3C")

    private int mGravity = Gravity.TOP | Gravity.START;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "F2C627B045ED0B6F456489886DDF0435", hash_generated_field = "74DB3F78A4C361569E560DA09766931D")

    private boolean mHorizontallyScrolling;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "6B1804E483F3EF95C329AD84689BA27C", hash_generated_field = "3127858001137B18AA1050FDA67563F8")

    private int mAutoLinkMask;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "B20D3633475D5DDA643309B6DF38BAA8", hash_generated_field = "66946D660FCFF22371342C2FCD7310DE")

    private boolean mLinksClickable = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "768D4A0E99F80D8745CC748FF177B182", hash_generated_field = "8F925916DEF4152F81E2C1B309E2CAD4")

    private float mSpacingMult = 1.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "76B6C9620B0FBD77BE307E9334B95A63", hash_generated_field = "1E02CC84BB1334BEF2DEA24E10A518A6")

    private float mSpacingAdd = 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "146ACA11699BD6614DDC7A0149037FB6", hash_generated_field = "68BD06BADA0355451B21E90ACC461FA5")

    private boolean mTextIsSelectable = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "28A817F8D44803BA03BFDAF899CA4612", hash_generated_field = "0EE8DD6435BEB8CBE9F46AA7496B8DA6")

    private int mMaximum = Integer.MAX_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "896320C9E2FB4CFC66E16D3BD356BAAF", hash_generated_field = "033C060EBF21916B1ECB824474BF4BDF")

    private int mMaxMode = LINES;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "CC209BC90D03447E85DF642E369F8A86", hash_generated_field = "0828D86E694A99841F66D5DB44492D82")

    private int mMinimum = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "B23BA1EA5F949F96C83C84709B7349D6", hash_generated_field = "01F00155DEDA2DDBFDB49BED19C8F96E")

    private int mMinMode = LINES;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "7ED33BD2DC36574D26E443EE1A189C0D", hash_generated_field = "A1A2411DB171DF204A9C43EDA39C69C7")

    private int mOldMaximum = mMaximum;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "0FBED20BC4056EDF1181A5F7F65A66B2", hash_generated_field = "DDDC3184AF678EE8EE38801D06FC99BF")

    private int mOldMaxMode = mMaxMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "9F06F72E481BAF7A136AD40FA3B01EB4", hash_generated_field = "63C7BFD9234113D05BBC54B620020077")

    private int mMaxWidth = Integer.MAX_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "C2CD798A4E6691243397E9A6620CFDEE", hash_generated_field = "C110306973FAB903E136E57733D142DD")

    private int mMaxWidthMode = PIXELS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "26016AEBC03D4DA0060B1446537D35AC", hash_generated_field = "5E59AE0126344902582396461E5FAA8C")

    private int mMinWidth = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "23CF04FD3F773E8AECAC4DF696589658", hash_generated_field = "0B24A55CAE86F87D6F35062C108A6502")

    private int mMinWidthMode = PIXELS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "409E161D7D14305BE6BBBE3E4AEFFCED", hash_generated_field = "6C530F900873AA9699052FBD8A88B031")

    private boolean mSingleLine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "06185890E372F5D51274CAD861AA5867", hash_generated_field = "3740A3452EC2B82472EDA36D3C6B8C87")

    private int mDesiredHeightAtMeasure = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "7B7C4D5694417E83CD90BE557F7B1057", hash_generated_field = "F60C6FE0825AD0E4922E523051656DE4")

    private boolean mIncludePad = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "31F14B9E9336FCF46F51826201DA493C", hash_generated_field = "F7ADD3635432B5C7B3A742E5E6D21FF7")

    private Path mHighlightPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "1FE02E01128CA6EA399797D30A51BBAD", hash_generated_field = "899F52BC2A6F9C0116B0475059B2BE9C")

    private boolean mHighlightPathBogus = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "380EFAD062415C5D611446C1B15B307D", hash_generated_field = "507FF60BF6AED501221786F4F9B1C4CE")

    private long mLastScroll;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "7E9E953961CD92A66FE0351C10474492", hash_generated_field = "9C30A415641DC69EAA3304A141095B90")

    private Scroller mScroller = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "EC0875A99E92BD0CEBED0D984C28195A", hash_generated_field = "FF6D60EE34326DC34FD3A8DE24FDF7C9")

    private BoringLayout.Metrics mBoring;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "DF537B8351AF7282A7B1E499D83D9433", hash_generated_field = "AAFF1CC477C8CC62A538A60FE46DC5D1")

    private BoringLayout.Metrics mHintBoring;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "0A793C83D74ADBD2F96615B43A58295A", hash_generated_field = "A58D53DD9C11A6C44CEF04B476DD83D8")

    private BoringLayout mSavedLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "3823EF2992779A9DCE6B5232294F71F7", hash_generated_field = "65F61BA5EAB2A99364AEC51C71BE0AD2")

    private BoringLayout mSavedHintLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "1ED12FB8583DE3005542EC3E5ADE9C69", hash_generated_field = "49191C3FC0794274CF62373EA69DAA6D")

    private TextDirectionHeuristic mTextDir = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "8EF1F84508C44788B91A5266E4C71739", hash_generated_field = "489605ABB55A73F593690CC2882D1D5E")

    private InputFilter[] mFilters = NO_FILTERS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.728 -0400", hash_original_field = "28E8D15C0BD03E974FEC7876975B1D1F", hash_generated_field = "946F5E9D92C681851A4147B34C44B028")

    private CorrectionHighlighter mCorrectionHighlighter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.729 -0400", hash_original_method = "16A18A865F32B95685EAC04EF434D4B5", hash_generated_method = "E4C2F370BE90FD637853CF92939C9374")
    public  TextView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.729 -0400", hash_original_method = "2AA1B7AF4AA0321ED5A0A8E3910A65F3", hash_generated_method = "43424ED0F684872076F86CE008533539")
    public  TextView(Context context,
                    AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.textViewStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.736 -0400", hash_original_method = "9090DB4BB502E7A1E7DDA866F2D92623", hash_generated_method = "44276E5933D72ECBA3C5C60805693D56")
    @SuppressWarnings("deprecation")
    public  TextView(Context context,
                    AttributeSet attrs,
                    int defStyle) {
        super(context, attrs, defStyle);
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
        {
            appearance = theme.obtainStyledAttributes(
                    ap, com.android.internal.R.styleable.TextAppearance);
        } 
        {
            int n = appearance.getIndexCount();
            {
                int i = 0;
                {
                    int attr = appearance.getIndex(i);
                    
                    textColorHighlight = appearance.getColor(attr, textColorHighlight);
                    
                    
                    textColor = appearance.getColorStateList(attr);
                    
                    
                    textColorHint = appearance.getColorStateList(attr);
                    
                    
                    textColorLink = appearance.getColorStateList(attr);
                    
                    
                    textSize = appearance.getDimensionPixelSize(attr, textSize);
                    
                    
                    typefaceIndex = appearance.getInt(attr, -1);
                    
                    
                    styleIndex = appearance.getInt(attr, -1);
                    
                    
                    allCaps = appearance.getBoolean(attr, false);
                    
                } 
            } 
            appearance.recycle();
        } 
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
        {
            int i = 0;
            {
                int attr = a.getIndex(i);
                
                editable = a.getBoolean(attr, editable);
                
                
                inputMethod = a.getText(attr);
                
                
                numeric = a.getInt(attr, numeric);
                
                
                digits = a.getText(attr);
                
                
                phone = a.getBoolean(attr, phone);
                
                
                autotext = a.getBoolean(attr, autotext);
                
                
                autocap = a.getInt(attr, autocap);
                
                
                buffertype = a.getInt(attr, buffertype);
                
                
                selectallonfocus = a.getBoolean(attr, selectallonfocus);
                
                
                mAutoLinkMask = a.getInt(attr, 0);
                
                
                mLinksClickable = a.getBoolean(attr, true);
                
                
                drawableLeft = a.getDrawable(attr);
                
                
                drawableTop = a.getDrawable(attr);
                
                
                drawableRight = a.getDrawable(attr);
                
                
                drawableBottom = a.getDrawable(attr);
                
                
                drawableStart = a.getDrawable(attr);
                
                
                drawableEnd = a.getDrawable(attr);
                
                
                drawablePadding = a.getDimensionPixelSize(attr, drawablePadding);
                
                
                setMaxLines(a.getInt(attr, -1));
                
                
                setMaxHeight(a.getDimensionPixelSize(attr, -1));
                
                
                setLines(a.getInt(attr, -1));
                
                
                setHeight(a.getDimensionPixelSize(attr, -1));
                
                
                setMinLines(a.getInt(attr, -1));
                
                
                setMinHeight(a.getDimensionPixelSize(attr, -1));
                
                
                setMaxEms(a.getInt(attr, -1));
                
                
                setMaxWidth(a.getDimensionPixelSize(attr, -1));
                
                
                setEms(a.getInt(attr, -1));
                
                
                setWidth(a.getDimensionPixelSize(attr, -1));
                
                
                setMinEms(a.getInt(attr, -1));
                
                
                setMinWidth(a.getDimensionPixelSize(attr, -1));
                
                
                setGravity(a.getInt(attr, -1));
                
                
                hint = a.getText(attr);
                
                
                text = a.getText(attr);
                
                
                {
                    boolean var45591D90FC7AE21A8CB6FE28079E45A9_507589217 = (a.getBoolean(attr, false));
                    {
                        setHorizontallyScrolling(true);
                    } 
                } 
                
                
                singleLine = a.getBoolean(attr, singleLine);
                
                
                ellipsize = a.getInt(attr, ellipsize);
                
                
                setMarqueeRepeatLimit(a.getInt(attr, mMarqueeRepeatLimit));
                
                
                {
                    boolean varE83A5B5DD6F1EFE4CE2BCD602A46684B_1419697129 = (!a.getBoolean(attr, true));
                    {
                        setIncludeFontPadding(false);
                    } 
                } 
                
                
                {
                    boolean varE83A5B5DD6F1EFE4CE2BCD602A46684B_1460584338 = (!a.getBoolean(attr, true));
                    {
                        setCursorVisible(false);
                    } 
                } 
                
                
                maxlength = a.getInt(attr, -1);
                
                
                setTextScaleX(a.getFloat(attr, 1.0f));
                
                
                mFreezesText = a.getBoolean(attr, false);
                
                
                shadowcolor = a.getInt(attr, 0);
                
                
                dx = a.getFloat(attr, 0);
                
                
                dy = a.getFloat(attr, 0);
                
                
                r = a.getFloat(attr, 0);
                
                
                setEnabled(a.getBoolean(attr, isEnabled()));
                
                
                textColorHighlight = a.getColor(attr, textColorHighlight);
                
                
                textColor = a.getColorStateList(attr);
                
                
                textColorHint = a.getColorStateList(attr);
                
                
                textColorLink = a.getColorStateList(attr);
                
                
                textSize = a.getDimensionPixelSize(attr, textSize);
                
                
                typefaceIndex = a.getInt(attr, typefaceIndex);
                
                
                styleIndex = a.getInt(attr, styleIndex);
                
                
                password = a.getBoolean(attr, password);
                
                
                mSpacingAdd = a.getDimensionPixelSize(attr, (int) mSpacingAdd);
                
                
                mSpacingMult = a.getFloat(attr, mSpacingMult);
                
                
                inputType = a.getInt(attr, mInputType);
                
                
                {
                    mInputContentType = new InputContentType();
                } 
                
                
                mInputContentType.imeOptions = a.getInt(attr,
                        mInputContentType.imeOptions);
                
                
                {
                    mInputContentType = new InputContentType();
                } 
                
                
                mInputContentType.imeActionLabel = a.getText(attr);
                
                
                {
                    mInputContentType = new InputContentType();
                } 
                
                
                mInputContentType.imeActionId = a.getInt(attr,
                        mInputContentType.imeActionId);
                
                
                setPrivateImeOptions(a.getString(attr));
                
                
                try 
                {
                    setInputExtras(a.getResourceId(attr, 0));
                } 
                catch (XmlPullParserException e)
                { }
                catch (IOException e)
                { }
                
                
                mCursorDrawableRes = a.getResourceId(attr, 0);
                
                
                mTextSelectHandleLeftRes = a.getResourceId(attr, 0);
                
                
                mTextSelectHandleRightRes = a.getResourceId(attr, 0);
                
                
                mTextSelectHandleRes = a.getResourceId(attr, 0);
                
                
                mTextEditSuggestionItemLayout = a.getResourceId(attr, 0);
                
                
                mTextIsSelectable = a.getBoolean(attr, false);
                
                
                allCaps = a.getBoolean(attr, false);
                
            } 
        } 
        a.recycle();
        BufferType bufferType = BufferType.EDITABLE;
        final int variation = inputType & (EditorInfo.TYPE_MASK_CLASS | EditorInfo.TYPE_MASK_VARIATION);
        final boolean passwordInputType = variation
                == (EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_VARIATION_PASSWORD);
        final boolean webPasswordInputType = variation
                == (EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_VARIATION_WEB_PASSWORD);
        final boolean numberPasswordInputType = variation
                == (EditorInfo.TYPE_CLASS_NUMBER | EditorInfo.TYPE_NUMBER_VARIATION_PASSWORD);
        {
            Class<?> c;
            try 
            {
                c = Class.forName(inputMethod.toString());
            } 
            catch (ClassNotFoundException ex)
            {
            	throw new RuntimeException(ex);
            } 
            try 
            {
                mInput = (KeyListener) c.newInstance();
            } 
            catch (InstantiationException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(ex);
            } 
            catch (IllegalAccessException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(ex);
            } 
            try 
            {
                mInputType = inputType != EditorInfo.TYPE_NULL
                        ? inputType
                        : mInput.getInputType();
            } 
            catch (IncompatibleClassChangeError e)
            {
                mInputType = EditorInfo.TYPE_CLASS_TEXT;
            } 
        } 
        {
            mInput = DigitsKeyListener.getInstance(digits.toString());
            mInputType = inputType != EditorInfo.TYPE_NULL
                    ? inputType : EditorInfo.TYPE_CLASS_TEXT;
        } 
        {
            setInputType(inputType, true);
            singleLine = !isMultilineInputType(inputType);
        } 
        {
            mInput = DialerKeyListener.getInstance();
            mInputType = inputType = EditorInfo.TYPE_CLASS_PHONE;
        } 
        {
            mInput = DigitsKeyListener.getInstance((numeric & SIGNED) != 0,
                                                   (numeric & DECIMAL) != 0);
            inputType = EditorInfo.TYPE_CLASS_NUMBER;
            {
                inputType |= EditorInfo.TYPE_NUMBER_FLAG_SIGNED;
            } 
            {
                inputType |= EditorInfo.TYPE_NUMBER_FLAG_DECIMAL;
            } 
            mInputType = inputType;
        } 
        {
            TextKeyListener.Capitalize cap;
            inputType = EditorInfo.TYPE_CLASS_TEXT;
            
            cap = TextKeyListener.Capitalize.SENTENCES;
            
            
            inputType |= EditorInfo.TYPE_TEXT_FLAG_CAP_SENTENCES;
            
            
            cap = TextKeyListener.Capitalize.WORDS;
            
            
            inputType |= EditorInfo.TYPE_TEXT_FLAG_CAP_WORDS;
            
            
            cap = TextKeyListener.Capitalize.CHARACTERS;
            
            
            inputType |= EditorInfo.TYPE_TEXT_FLAG_CAP_CHARACTERS;
            
            
            cap = TextKeyListener.Capitalize.NONE;
            
            mInput = TextKeyListener.getInstance(autotext, cap);
            mInputType = inputType;
        } 
        {
            mInputType = EditorInfo.TYPE_NULL;
            mInput = null;
            bufferType = BufferType.SPANNABLE;
            setFocusableInTouchMode(true);
            setMovementMethod(ArrowKeyMovementMethod.getInstance());
        } 
        {
            mInput = TextKeyListener.getInstance();
            mInputType = EditorInfo.TYPE_CLASS_TEXT;
        } 
        {
            mInput = null;
            
            bufferType = BufferType.NORMAL;
            
            
            bufferType = BufferType.SPANNABLE;
            
            
            bufferType = BufferType.EDITABLE;
            
        } 
        {
            {
                mInputType = (mInputType & ~(EditorInfo.TYPE_MASK_VARIATION))
                        | EditorInfo.TYPE_TEXT_VARIATION_PASSWORD;
            } 
            {
                mInputType = (mInputType & ~(EditorInfo.TYPE_MASK_VARIATION))
                        | EditorInfo.TYPE_TEXT_VARIATION_WEB_PASSWORD;
            } 
        } 
        {
            {
                mInputType = (mInputType & ~(EditorInfo.TYPE_MASK_VARIATION))
                        | EditorInfo.TYPE_NUMBER_VARIATION_PASSWORD;
            } 
        } 
        {
            mSelectAllOnFocus = true;
            bufferType = BufferType.SPANNABLE;
        } 
        setCompoundDrawablesWithIntrinsicBounds(
            drawableLeft, drawableTop, drawableRight, drawableBottom);
        setRelativeDrawablesIfNeeded(drawableStart, drawableEnd);
        setCompoundDrawablePadding(drawablePadding);
        setInputTypeSingleLine(singleLine);
        applySingleLine(singleLine, singleLine, singleLine);
        {
            ellipsize = 3;
        } 
        
        setEllipsize(TextUtils.TruncateAt.START);
        
        
        setEllipsize(TextUtils.TruncateAt.MIDDLE);
        
        
        setEllipsize(TextUtils.TruncateAt.END);
        
        
        {
            boolean var8F0ACED8C99F3716300411BE9198A3C2_1649076457 = (ViewConfiguration.get(context).isFadingMarqueeEnabled());
            {
                setHorizontalFadingEdgeEnabled(true);
                mMarqueeFadeMode = MARQUEE_FADE_NORMAL;
            } 
            {
                setHorizontalFadingEdgeEnabled(false);
                mMarqueeFadeMode = MARQUEE_FADE_SWITCH_SHOW_ELLIPSIS;
            } 
        } 
        
        
        setEllipsize(TextUtils.TruncateAt.MARQUEE);
        
        setTextColor(textColor != null ? textColor : ColorStateList.valueOf(0xFF000000));
        setHintTextColor(textColorHint);
        setLinkTextColor(textColorLink);
        {
            setHighlightColor(textColorHighlight);
        } 
        setRawTextSize(textSize);
        {
            setTransformationMethod(new AllCapsTransformationMethod(getContext()));
        } 
        {
            setTransformationMethod(PasswordTransformationMethod.getInstance());
            typefaceIndex = MONOSPACE;
        } 
        {
            typefaceIndex = MONOSPACE;
        } 
        setTypefaceByIndex(typefaceIndex, styleIndex);
        {
            setShadowLayer(r, dx, dy, shadowcolor);
        } 
        {
            setFilters(new InputFilter[] { new InputFilter.LengthFilter(maxlength) });
        } 
        {
            setFilters(NO_FILTERS);
        } 
        setText(text, bufferType);
        setHint(hint);
        a = context.obtainStyledAttributes(attrs,
                                           com.android.internal.R.styleable.View,
                                           defStyle, 0);
        boolean focusable = mMovement != null || mInput != null;
        boolean clickable = focusable;
        boolean longClickable = focusable;
        n = a.getIndexCount();
        {
            int i = 0;
            {
                int attr = a.getIndex(i);
                
                focusable = a.getBoolean(attr, focusable);
                
                
                clickable = a.getBoolean(attr, clickable);
                
                
                longClickable = a.getBoolean(attr, longClickable);
                
            } 
        } 
        a.recycle();
        setFocusable(focusable);
        setClickable(clickable);
        setLongClickable(longClickable);
        prepareCursorControllers();
        final ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        final int touchSlop = viewConfiguration.getScaledTouchSlop();
        mSquaredTouchSlopDistance = touchSlop * touchSlop;
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.737 -0400", hash_original_method = "C60E18AF77ADDBBD7F15C48D3326353D", hash_generated_method = "B23AF4FB463A5E047993231DDD0BBC29")
    private void setTypefaceByIndex(int typefaceIndex, int styleIndex) {
        Typeface tf = null;
        
        tf = Typeface.SANS_SERIF;
        
        
        tf = Typeface.SERIF;
        
        
        tf = Typeface.MONOSPACE;
        
        setTypeface(tf, styleIndex);
        addTaint(typefaceIndex);
        addTaint(styleIndex);
        
        
        
            
                
                
            
                
                
            
                
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.737 -0400", hash_original_method = "81361F4824C6D1D7960776386313375B", hash_generated_method = "F360775D85D70504FCD94361E784278B")
    private void setRelativeDrawablesIfNeeded(Drawable start, Drawable end) {
        boolean hasRelativeDrawables = (start != null) || (end != null);
        {
            Drawables dr = mDrawables;
            {
                mDrawables = dr = new Drawables();
            } 
            final Rect compoundRect = dr.mCompoundRect;
            int[] state = getDrawableState();
            {
                start.setBounds(0, 0, start.getIntrinsicWidth(), start.getIntrinsicHeight());
                start.setState(state);
                start.copyBounds(compoundRect);
                start.setCallback(this);
                dr.mDrawableStart = start;
                dr.mDrawableSizeStart = compoundRect.width();
                dr.mDrawableHeightStart = compoundRect.height();
            } 
            {
                dr.mDrawableSizeStart = dr.mDrawableHeightStart = 0;
            } 
            {
                end.setBounds(0, 0, end.getIntrinsicWidth(), end.getIntrinsicHeight());
                end.setState(state);
                end.copyBounds(compoundRect);
                end.setCallback(this);
                dr.mDrawableEnd = end;
                dr.mDrawableSizeEnd = compoundRect.width();
                dr.mDrawableHeightEnd = compoundRect.height();
            } 
            {
                dr.mDrawableSizeEnd = dr.mDrawableHeightEnd = 0;
            } 
        } 
        addTaint(start.getTaint());
        addTaint(end.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.738 -0400", hash_original_method = "224789FFA5DBD63B17185276A15DADF0", hash_generated_method = "18FB61CB189F606F4D7D7FDEB38810A1")
    @Override
    public void setEnabled(boolean enabled) {
        {
            boolean var7DA8DB0EDBF2B3C1E618EFC1F33534DC_1615402423 = (enabled == isEnabled());
        } 
        {
            InputMethodManager imm = InputMethodManager.peekInstance();
            {
                boolean var4937F8F03F6BF371ED8AD64A66FE25A6_1668704019 = (imm != null && imm.isActive(this));
                {
                    imm.hideSoftInputFromWindow(getWindowToken(), 0);
                } 
            } 
        } 
        super.setEnabled(enabled);
        prepareCursorControllers();
        {
            InputMethodManager imm = InputMethodManager.peekInstance();
            imm.restartInput(this);
        } 
        makeBlink();
        addTaint(enabled);
        
        
            
        
        
            
            
                
            
        
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.739 -0400", hash_original_method = "6CE73F981984CDCC5004358BB070DFC0", hash_generated_method = "AE28EA44C0AEA20715AD1B8662930BDE")
    public void setTypeface(Typeface tf, int style) {
        {
            {
                tf = Typeface.defaultFromStyle(style);
            } 
            {
                tf = Typeface.create(tf, style);
            } 
            setTypeface(tf);
            int typefaceStyle;
            typefaceStyle = tf.getStyle();
            typefaceStyle = 0;
            int need = style & ~typefaceStyle;
            mTextPaint.setFakeBoldText((need & Typeface.BOLD) != 0);
            mTextPaint.setTextSkewX((need & Typeface.ITALIC) != 0 ? -0.25f : 0);
        } 
        {
            mTextPaint.setFakeBoldText(false);
            mTextPaint.setTextSkewX(0);
            setTypeface(tf);
        } 
        addTaint(tf.getTaint());
        addTaint(style);
        
        
            
                
            
                
            
            
            
            
            
            
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.739 -0400", hash_original_method = "BFDF598F6F7CD4AFD7EB65F700EA9607", hash_generated_method = "A7B9FC47B07298FFF002FD87EE6CC85E")
    protected boolean getDefaultEditable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_389707921 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_389707921;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.739 -0400", hash_original_method = "BBE0A92ADC5D9278A97962CE8941F1CB", hash_generated_method = "E479E572B3F7384E6AE6870AE86EE673")
    protected MovementMethod getDefaultMovementMethod() {
        MovementMethod varB4EAC82CA7396A68D541C85D26508E83_473892731 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_473892731 = null;
        varB4EAC82CA7396A68D541C85D26508E83_473892731.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_473892731;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.740 -0400", hash_original_method = "D3D56665E0CC0B43413FBFB4C720E96C", hash_generated_method = "65551D95088DD3F4272ACEE13D0E1476")
    @ViewDebug.CapturedViewProperty
    public CharSequence getText() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1072372900 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1072372900 = mText;
        varB4EAC82CA7396A68D541C85D26508E83_1072372900.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1072372900;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.740 -0400", hash_original_method = "9A68249D01A4FE1CBD4D535668FCEB6F", hash_generated_method = "20E469216C8DC78776C166C38C6AF309")
    public int length() {
        int var32A6F8CD5764B26A2339FAB65BD4098F_124622242 = (mText.length());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2110507742 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2110507742;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.741 -0400", hash_original_method = "7ED3A36B3A9686857AF495D746EF7144", hash_generated_method = "6107DD98D0183747DB8A91C9D76C4FD0")
    public Editable getEditableText() {
        Editable varB4EAC82CA7396A68D541C85D26508E83_869382698 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_869382698 = (mText instanceof Editable) ? (Editable)mText : null;
        varB4EAC82CA7396A68D541C85D26508E83_869382698.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_869382698;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.741 -0400", hash_original_method = "0FF7B2A5A4CF7321FA6B03810945EA51", hash_generated_method = "AB50D13C596DC3C2570DB0F9195F1C5E")
    public int getLineHeight() {
        int var20B277202414C5A1CC77B4034C64DAD9_317498095 = (FastMath.round(mTextPaint.getFontMetricsInt(null) * mSpacingMult + mSpacingAdd));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_63496067 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_63496067;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.742 -0400", hash_original_method = "AA853122D8F66FE025B9AF375421C379", hash_generated_method = "315945C9B6C87B17DD73B401DD665A47")
    public final Layout getLayout() {
        Layout varB4EAC82CA7396A68D541C85D26508E83_677837599 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_677837599 = mLayout;
        varB4EAC82CA7396A68D541C85D26508E83_677837599.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_677837599;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.742 -0400", hash_original_method = "16C14256413AD7EC2C071FEF64E5C315", hash_generated_method = "93565CC45E4ABBB14AF1E2F3F9CA2F5E")
    public final KeyListener getKeyListener() {
        KeyListener varB4EAC82CA7396A68D541C85D26508E83_300839855 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_300839855 = mInput;
        varB4EAC82CA7396A68D541C85D26508E83_300839855.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_300839855;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.743 -0400", hash_original_method = "C24E7464E624E00527FA94ACF2B78CDF", hash_generated_method = "CF36CD7DFB3A1A8FED44981589294826")
    public void setKeyListener(KeyListener input) {
        setKeyListenerOnly(input);
        fixFocusableAndClickableSettings();
        {
            try 
            {
                mInputType = mInput.getInputType();
            } 
            catch (IncompatibleClassChangeError e)
            {
                mInputType = EditorInfo.TYPE_CLASS_TEXT;
            } 
            setInputTypeSingleLine(mSingleLine);
        } 
        {
            mInputType = EditorInfo.TYPE_NULL;
        } 
        InputMethodManager imm = InputMethodManager.peekInstance();
        imm.restartInput(this);
        addTaint(input.getTaint());
        
        
        
        
            
                
            
                
            
            
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.744 -0400", hash_original_method = "4C0922906A0644E54152EA479C6FB8D4", hash_generated_method = "FCA0E058FAE26C07A859496B7C7EBD81")
    private void setKeyListenerOnly(KeyListener input) {
        mInput = input;
        setText(mText);
        setFilters((Editable) mText, mFilters);
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.746 -0400", hash_original_method = "48923BC0AD13C4CAAF5FC92105497B11", hash_generated_method = "230F4EA74CD66097F9AC051482C0F3DD")
    public final MovementMethod getMovementMethod() {
        MovementMethod varB4EAC82CA7396A68D541C85D26508E83_758587290 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_758587290 = mMovement;
        varB4EAC82CA7396A68D541C85D26508E83_758587290.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_758587290;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.747 -0400", hash_original_method = "A60F83672BBDF336AF379460700DB19E", hash_generated_method = "9201CE2A5C2C5C6029EADF339CE33B51")
    public final void setMovementMethod(MovementMethod movement) {
        mMovement = movement;
        setText(mText);
        fixFocusableAndClickableSettings();
        prepareCursorControllers();
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.747 -0400", hash_original_method = "20BA1DEB0A4AF2EE483D2287D9007BE7", hash_generated_method = "B98752575E441289B05AA5A2F0F91865")
    private void fixFocusableAndClickableSettings() {
        {
            setFocusable(true);
            setClickable(true);
            setLongClickable(true);
        } 
        {
            setFocusable(false);
            setClickable(false);
            setLongClickable(false);
        } 
        
        
            
            
            
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.748 -0400", hash_original_method = "2CDC6DDF1029E76D6DBEC0602C28EC15", hash_generated_method = "ACF258F1647A95847EA6E98FE4A57AF8")
    public final TransformationMethod getTransformationMethod() {
        TransformationMethod varB4EAC82CA7396A68D541C85D26508E83_1261338782 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1261338782 = mTransformation;
        varB4EAC82CA7396A68D541C85D26508E83_1261338782.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1261338782;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.749 -0400", hash_original_method = "93D394D84FFC0B02B9FD24841443EB6E", hash_generated_method = "09094FB876841750FAF0276933EA6E34")
    public final void setTransformationMethod(TransformationMethod method) {
        {
            {
                ((Spannable) mText).removeSpan(mTransformation);
            } 
        } 
        mTransformation = method;
        {
            TransformationMethod2 method2 = (TransformationMethod2) method;
            mAllowTransformationLengthChange = !mTextIsSelectable && !(mText instanceof Editable);
            method2.setLengthChangesAllowed(mAllowTransformationLengthChange);
        } 
        {
            mAllowTransformationLengthChange = false;
        } 
        setText(mText);
        
        
            
        
        
            
                
            
        
        
        
            
            
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.749 -0400", hash_original_method = "CD4E87E17C71F6F36E69A30DF125A2EC", hash_generated_method = "00C0E04E474C9281B19AB4DD04F03FF5")
    public int getCompoundPaddingTop() {
        final Drawables dr = mDrawables;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1858181979 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1858181979;
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.749 -0400", hash_original_method = "F8E73EA88ED50BD236713C6E1FD6275E", hash_generated_method = "98E3CE5B6566F214D6E82E440872A4EA")
    public int getCompoundPaddingBottom() {
        final Drawables dr = mDrawables;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1975016950 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1975016950;
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.750 -0400", hash_original_method = "E37CE1C2FEDB3DD18FEE34DF2470D692", hash_generated_method = "DD0F06F2740EA4B58A74C7FF3BA564D7")
    public int getCompoundPaddingLeft() {
        final Drawables dr = mDrawables;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_149635182 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_149635182;
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.750 -0400", hash_original_method = "FA75E1802F0BBA6FD5DC7258A0FBEB3C", hash_generated_method = "40B84136315EAED23CAD1E24D5C41DEB")
    public int getCompoundPaddingRight() {
        final Drawables dr = mDrawables;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1924101959 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1924101959;
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.750 -0400", hash_original_method = "045E56B45A145CD7B99AFA777E63AEB3", hash_generated_method = "F969C1D3F40F099E5ADDE6315E6A49A7")
    public int getCompoundPaddingStart() {
        resolveDrawables();
        {
            Object varAFC6EB2C684D509A17B3A4EFF5D9CB9D_1882576112 = (getResolvedLayoutDirection());
            
            int var781EBC093D28721525521D7AA075C977_1494896881 = (getCompoundPaddingLeft());
            
            
            int var8A1D5A6585B3402DA0435C7A847F7E9A_1604468581 = (getCompoundPaddingRight());
            
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1062103430 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1062103430;
        
        
        
            
            
                
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.751 -0400", hash_original_method = "0C4A0FB6513BA7C283389B0C3E09BE68", hash_generated_method = "B1E209C90795DC2AFBA508F33FAC2D3B")
    public int getCompoundPaddingEnd() {
        resolveDrawables();
        {
            Object varAFC6EB2C684D509A17B3A4EFF5D9CB9D_293331693 = (getResolvedLayoutDirection());
            
            int var8A1D5A6585B3402DA0435C7A847F7E9A_1128644886 = (getCompoundPaddingRight());
            
            
            int var781EBC093D28721525521D7AA075C977_799619281 = (getCompoundPaddingLeft());
            
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2031116819 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2031116819;
        
        
        
            
            
                
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.751 -0400", hash_original_method = "363FF0B4BA7F59F6CC6EB59AE673A7C9", hash_generated_method = "4765F59FE80BADD15C654BB50EE8E1EF")
    public int getExtendedPaddingTop() {
        {
            int var616A12A33C5C9277AD7C0C5C89BD69B5_144760619 = (getCompoundPaddingTop());
        } 
        {
            boolean var907B1900A80A700A44CB9B3E7CFA8547_136586649 = (mLayout.getLineCount() <= mMaximum);
            {
                int varDAC50BDCD5E1A4A87E580425D0AB90D1_658710620 = (getCompoundPaddingTop());
            } 
        } 
        int top = getCompoundPaddingTop();
        int bottom = getCompoundPaddingBottom();
        int viewht = getHeight() - top - bottom;
        int layoutht = mLayout.getLineTop(mMaximum);
        final int gravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_114709113 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_114709113;
        
        
            
        
        
            
        
        
        
        
        
        
            
        
        
        
            
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.752 -0400", hash_original_method = "7A2DB8BFB057F07CEDE0D120BE6FFB10", hash_generated_method = "D1DABA16597DD709B77F5DFDF060ADA0")
    public int getExtendedPaddingBottom() {
        {
            int varB616C533FD1413DFA57A8B3E4A355326_1934376813 = (getCompoundPaddingBottom());
        } 
        {
            boolean var907B1900A80A700A44CB9B3E7CFA8547_2001609133 = (mLayout.getLineCount() <= mMaximum);
            {
                int varF7C5B922A73A10EEE346A45E2A7B3E82_1639849181 = (getCompoundPaddingBottom());
            } 
        } 
        int top = getCompoundPaddingTop();
        int bottom = getCompoundPaddingBottom();
        int viewht = getHeight() - top - bottom;
        int layoutht = mLayout.getLineTop(mMaximum);
        final int gravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_153250059 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_153250059;
        
        
            
        
        
            
        
        
        
        
        
        
            
        
        
        
            
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.753 -0400", hash_original_method = "5245DB1A490E586E6093F4BFC26117D1", hash_generated_method = "10F84B478AA1D8F13B238A6272DB079B")
    public int getTotalPaddingLeft() {
        int var34500B372695C1C0BF8F0AECDF252C98_1372828842 = (getCompoundPaddingLeft());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_549471472 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_549471472;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.754 -0400", hash_original_method = "A1EB6CC80DC85EDA662D4DD9C10BBDEB", hash_generated_method = "757D55E09E92390C8E706A9502F89C73")
    public int getTotalPaddingRight() {
        int var9B702A81BD3510988CA34C6D5C5CC2BB_1838894462 = (getCompoundPaddingRight());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_77948165 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_77948165;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.755 -0400", hash_original_method = "DD9B038504EC66CC7FCB75AE1CB753E5", hash_generated_method = "3F3DFC9E2A6FD9BE8D92BE8D765115D1")
    public int getTotalPaddingStart() {
        int var7D7F8C48280E1131C487BF0950634EDB_1996129450 = (getCompoundPaddingStart());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_137912702 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_137912702;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.755 -0400", hash_original_method = "7924A3AF5CA0D716DAB0CFDF1EC0C456", hash_generated_method = "5A8C8AE8F99BB1734702FC207565F84B")
    public int getTotalPaddingEnd() {
        int varF719AD7587A07158D4596514D0584E08_1451146949 = (getCompoundPaddingEnd());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1964856715 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1964856715;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.756 -0400", hash_original_method = "3FBB92A2EE65C62C674BD5E5A5FB2713", hash_generated_method = "67E07A111363BF809DCC682D571004E6")
    public int getTotalPaddingTop() {
        int varCBA1A1AACA4E5447F7B59F1AEE81650D_1960966129 = (getExtendedPaddingTop() + getVerticalOffset(true));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1716387672 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1716387672;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.756 -0400", hash_original_method = "DD0E7E66835F9F938ABD11A206F39F98", hash_generated_method = "19CA98513002B68A0387657A2A0418B2")
    public int getTotalPaddingBottom() {
        int var8B593715CC9C8A177070B563C501DACE_222789898 = (getExtendedPaddingBottom() + getBottomVerticalOffset(true));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2081429014 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2081429014;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.757 -0400", hash_original_method = "FDA2BF05D2CC3125A844DA2F1CDB97F3", hash_generated_method = "F63405260E1215FC35A979A96DD3A1E3")
    public void setCompoundDrawables(Drawable left, Drawable top,
                                     Drawable right, Drawable bottom) {
        Drawables dr = mDrawables;
        final boolean drawables = left != null || top != null
                || right != null || bottom != null;
        {
            {
                {
                    mDrawables = null;
                } 
                {
                    dr.mDrawableLeft.setCallback(null);
                    dr.mDrawableLeft = null;
                    dr.mDrawableTop.setCallback(null);
                    dr.mDrawableTop = null;
                    dr.mDrawableRight.setCallback(null);
                    dr.mDrawableRight = null;
                    dr.mDrawableBottom.setCallback(null);
                    dr.mDrawableBottom = null;
                    dr.mDrawableSizeLeft = dr.mDrawableHeightLeft = 0;
                    dr.mDrawableSizeRight = dr.mDrawableHeightRight = 0;
                    dr.mDrawableSizeTop = dr.mDrawableWidthTop = 0;
                    dr.mDrawableSizeBottom = dr.mDrawableWidthBottom = 0;
                } 
            } 
        } 
        {
            {
                mDrawables = dr = new Drawables();
            } 
            {
                dr.mDrawableLeft.setCallback(null);
            } 
            dr.mDrawableLeft = left;
            {
                dr.mDrawableTop.setCallback(null);
            } 
            dr.mDrawableTop = top;
            {
                dr.mDrawableRight.setCallback(null);
            } 
            dr.mDrawableRight = right;
            {
                dr.mDrawableBottom.setCallback(null);
            } 
            dr.mDrawableBottom = bottom;
            final Rect compoundRect = dr.mCompoundRect;
            int[] state;
            state = getDrawableState();
            {
                left.setState(state);
                left.copyBounds(compoundRect);
                left.setCallback(this);
                dr.mDrawableSizeLeft = compoundRect.width();
                dr.mDrawableHeightLeft = compoundRect.height();
            } 
            {
                dr.mDrawableSizeLeft = dr.mDrawableHeightLeft = 0;
            } 
            {
                right.setState(state);
                right.copyBounds(compoundRect);
                right.setCallback(this);
                dr.mDrawableSizeRight = compoundRect.width();
                dr.mDrawableHeightRight = compoundRect.height();
            } 
            {
                dr.mDrawableSizeRight = dr.mDrawableHeightRight = 0;
            } 
            {
                top.setState(state);
                top.copyBounds(compoundRect);
                top.setCallback(this);
                dr.mDrawableSizeTop = compoundRect.height();
                dr.mDrawableWidthTop = compoundRect.width();
            } 
            {
                dr.mDrawableSizeTop = dr.mDrawableWidthTop = 0;
            } 
            {
                bottom.setState(state);
                bottom.copyBounds(compoundRect);
                bottom.setCallback(this);
                dr.mDrawableSizeBottom = compoundRect.height();
                dr.mDrawableWidthBottom = compoundRect.width();
            } 
            {
                dr.mDrawableSizeBottom = dr.mDrawableWidthBottom = 0;
            } 
        } 
        invalidate();
        requestLayout();
        addTaint(left.getTaint());
        addTaint(top.getTaint());
        addTaint(right.getTaint());
        addTaint(bottom.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.758 -0400", hash_original_method = "4DA9B29500DC46492C6684BECC05C749", hash_generated_method = "450D23B29D1EE3074124103689C7FFCE")
    public void setCompoundDrawablesWithIntrinsicBounds(int left, int top, int right, int bottom) {
        final Resources resources = getContext().getResources();
        setCompoundDrawablesWithIntrinsicBounds(left != 0 ? resources.getDrawable(left) : null,
                top != 0 ? resources.getDrawable(top) : null,
                right != 0 ? resources.getDrawable(right) : null,
                bottom != 0 ? resources.getDrawable(bottom) : null);
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        
        
        
                
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.758 -0400", hash_original_method = "19E536EC7FD9E8E0EBEABA79F37A1C35", hash_generated_method = "37414A27D658BE5E9D636F262928C84E")
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable left, Drawable top,
            Drawable right, Drawable bottom) {
        {
            left.setBounds(0, 0, left.getIntrinsicWidth(), left.getIntrinsicHeight());
        } 
        {
            right.setBounds(0, 0, right.getIntrinsicWidth(), right.getIntrinsicHeight());
        } 
        {
            top.setBounds(0, 0, top.getIntrinsicWidth(), top.getIntrinsicHeight());
        } 
        {
            bottom.setBounds(0, 0, bottom.getIntrinsicWidth(), bottom.getIntrinsicHeight());
        } 
        setCompoundDrawables(left, top, right, bottom);
        addTaint(left.getTaint());
        addTaint(top.getTaint());
        addTaint(right.getTaint());
        addTaint(bottom.getTaint());
        
        
            
        
        
            
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.760 -0400", hash_original_method = "C527F166CA85E985387BA0B670132163", hash_generated_method = "BC583E5A626F556610E3877D048FAAB4")
    public void setCompoundDrawablesRelative(Drawable start, Drawable top,
                                     Drawable end, Drawable bottom) {
        Drawables dr = mDrawables;
        final boolean drawables = start != null || top != null
                || end != null || bottom != null;
        {
            {
                {
                    mDrawables = null;
                } 
                {
                    dr.mDrawableStart.setCallback(null);
                    dr.mDrawableStart = null;
                    dr.mDrawableTop.setCallback(null);
                    dr.mDrawableTop = null;
                    dr.mDrawableEnd.setCallback(null);
                    dr.mDrawableEnd = null;
                    dr.mDrawableBottom.setCallback(null);
                    dr.mDrawableBottom = null;
                    dr.mDrawableSizeStart = dr.mDrawableHeightStart = 0;
                    dr.mDrawableSizeEnd = dr.mDrawableHeightEnd = 0;
                    dr.mDrawableSizeTop = dr.mDrawableWidthTop = 0;
                    dr.mDrawableSizeBottom = dr.mDrawableWidthBottom = 0;
                } 
            } 
        } 
        {
            {
                mDrawables = dr = new Drawables();
            } 
            {
                dr.mDrawableStart.setCallback(null);
            } 
            dr.mDrawableStart = start;
            {
                dr.mDrawableTop.setCallback(null);
            } 
            dr.mDrawableTop = top;
            {
                dr.mDrawableEnd.setCallback(null);
            } 
            dr.mDrawableEnd = end;
            {
                dr.mDrawableBottom.setCallback(null);
            } 
            dr.mDrawableBottom = bottom;
            final Rect compoundRect = dr.mCompoundRect;
            int[] state;
            state = getDrawableState();
            {
                start.setState(state);
                start.copyBounds(compoundRect);
                start.setCallback(this);
                dr.mDrawableSizeStart = compoundRect.width();
                dr.mDrawableHeightStart = compoundRect.height();
            } 
            {
                dr.mDrawableSizeStart = dr.mDrawableHeightStart = 0;
            } 
            {
                end.setState(state);
                end.copyBounds(compoundRect);
                end.setCallback(this);
                dr.mDrawableSizeEnd = compoundRect.width();
                dr.mDrawableHeightEnd = compoundRect.height();
            } 
            {
                dr.mDrawableSizeEnd = dr.mDrawableHeightEnd = 0;
            } 
            {
                top.setState(state);
                top.copyBounds(compoundRect);
                top.setCallback(this);
                dr.mDrawableSizeTop = compoundRect.height();
                dr.mDrawableWidthTop = compoundRect.width();
            } 
            {
                dr.mDrawableSizeTop = dr.mDrawableWidthTop = 0;
            } 
            {
                bottom.setState(state);
                bottom.copyBounds(compoundRect);
                bottom.setCallback(this);
                dr.mDrawableSizeBottom = compoundRect.height();
                dr.mDrawableWidthBottom = compoundRect.width();
            } 
            {
                dr.mDrawableSizeBottom = dr.mDrawableWidthBottom = 0;
            } 
        } 
        resolveDrawables();
        invalidate();
        requestLayout();
        addTaint(start.getTaint());
        addTaint(top.getTaint());
        addTaint(end.getTaint());
        addTaint(bottom.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.760 -0400", hash_original_method = "08DFFEC64B0A3553E53B210C6E8B4F5B", hash_generated_method = "11FE50F99ECB56BA4F694328A2CD0784")
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int start, int top, int end,
            int bottom) {
        resetResolvedDrawables();
        final Resources resources = getContext().getResources();
        setCompoundDrawablesRelativeWithIntrinsicBounds(
                start != 0 ? resources.getDrawable(start) : null,
                top != 0 ? resources.getDrawable(top) : null,
                end != 0 ? resources.getDrawable(end) : null,
                bottom != 0 ? resources.getDrawable(bottom) : null);
        addTaint(start);
        addTaint(top);
        addTaint(end);
        addTaint(bottom);
        
        
        
        
                
                
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.760 -0400", hash_original_method = "BA79780015035B80B72E7A4B08D0D299", hash_generated_method = "32612502DC94DB1039E7091E204E256B")
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable start, Drawable top,
            Drawable end, Drawable bottom) {
        resetResolvedDrawables();
        {
            start.setBounds(0, 0, start.getIntrinsicWidth(), start.getIntrinsicHeight());
        } 
        {
            end.setBounds(0, 0, end.getIntrinsicWidth(), end.getIntrinsicHeight());
        } 
        {
            top.setBounds(0, 0, top.getIntrinsicWidth(), top.getIntrinsicHeight());
        } 
        {
            bottom.setBounds(0, 0, bottom.getIntrinsicWidth(), bottom.getIntrinsicHeight());
        } 
        setCompoundDrawablesRelative(start, top, end, bottom);
        addTaint(start.getTaint());
        addTaint(top.getTaint());
        addTaint(end.getTaint());
        addTaint(bottom.getTaint());
        
        
        
            
        
        
            
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.761 -0400", hash_original_method = "06FDA6F654D58A3BC65C29C47124F71A", hash_generated_method = "5EBE399BEC8CC9FF5D0955D2DCBF32E9")
    public Drawable[] getCompoundDrawables() {
        Drawable[] varB4EAC82CA7396A68D541C85D26508E83_569638552 = null; 
        Drawable[] varB4EAC82CA7396A68D541C85D26508E83_786425571 = null; 
        final Drawables dr = mDrawables;
        {
            varB4EAC82CA7396A68D541C85D26508E83_569638552 = new Drawable[] {
                dr.mDrawableLeft, dr.mDrawableTop, dr.mDrawableRight, dr.mDrawableBottom
            };
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_786425571 = new Drawable[] { null, null, null, null };
        } 
        Drawable[] varA7E53CE21691AB073D9660D615818899_26225717; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_26225717 = varB4EAC82CA7396A68D541C85D26508E83_569638552;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_26225717 = varB4EAC82CA7396A68D541C85D26508E83_786425571;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_26225717.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_26225717;
        
        
        
            
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.762 -0400", hash_original_method = "7D536599368FF7E7773D59B2D0C7C092", hash_generated_method = "F0FA16DDF0EFA2D5971B19596CD8994B")
    public Drawable[] getCompoundDrawablesRelative() {
        Drawable[] varB4EAC82CA7396A68D541C85D26508E83_272495733 = null; 
        Drawable[] varB4EAC82CA7396A68D541C85D26508E83_995259918 = null; 
        final Drawables dr = mDrawables;
        {
            varB4EAC82CA7396A68D541C85D26508E83_272495733 = new Drawable[] {
                dr.mDrawableStart, dr.mDrawableTop, dr.mDrawableEnd, dr.mDrawableBottom
            };
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_995259918 = new Drawable[] { null, null, null, null };
        } 
        Drawable[] varA7E53CE21691AB073D9660D615818899_709659229; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_709659229 = varB4EAC82CA7396A68D541C85D26508E83_272495733;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_709659229 = varB4EAC82CA7396A68D541C85D26508E83_995259918;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_709659229.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_709659229;
        
        
        
            
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.763 -0400", hash_original_method = "7E4DBC59802038B0E00C34B579D2DA37", hash_generated_method = "0B4B64626F2240D9D1545BB899D9B35A")
    public void setCompoundDrawablePadding(int pad) {
        Drawables dr = mDrawables;
        {
            {
                dr.mDrawablePadding = pad;
            } 
        } 
        {
            {
                mDrawables = dr = new Drawables();
            } 
            dr.mDrawablePadding = pad;
        } 
        invalidate();
        requestLayout();
        addTaint(pad);
        
        
        
            
                
            
        
            
                
            
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.764 -0400", hash_original_method = "6B458DA6759E58857DA3CAF4E6D1B789", hash_generated_method = "2F27D32F814A7D50B38DCD16BFEEA306")
    public int getCompoundDrawablePadding() {
        final Drawables dr = mDrawables;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1512863395 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1512863395;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.765 -0400", hash_original_method = "4C42E9479946D6D8F38619DA66232863", hash_generated_method = "C83267E97542CB8A859756E452D5BD23")
    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        {
            nullLayouts();
        } 
        super.setPadding(left, top, right, bottom);
        invalidate();
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        
        
            
            
            
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.766 -0400", hash_original_method = "D796BA921A3359840CCD26FF0DD1CFB0", hash_generated_method = "6C7F06ED99BC9968509CCD520923C252")
    public final int getAutoLinkMask() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_143247611 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_143247611;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.766 -0400", hash_original_method = "FFEF779179433D30901B486DA8C4C9D0", hash_generated_method = "BF17D17324012818759C94130553367E")
    public void setTextAppearance(Context context, int resid) {
        TypedArray appearance = context.obtainStyledAttributes(resid,
                                           com.android.internal.R.styleable.TextAppearance);
        int color;
        ColorStateList colors;
        int ts;
        color = appearance.getColor(com.android.internal.R.styleable.TextAppearance_textColorHighlight, 0);
        {
            setHighlightColor(color);
        } 
        colors = appearance.getColorStateList(com.android.internal.R.styleable.
                                              TextAppearance_textColor);
        {
            setTextColor(colors);
        } 
        ts = appearance.getDimensionPixelSize(com.android.internal.R.styleable.
                                              TextAppearance_textSize, 0);
        {
            setRawTextSize(ts);
        } 
        colors = appearance.getColorStateList(com.android.internal.R.styleable.
                                              TextAppearance_textColorHint);
        {
            setHintTextColor(colors);
        } 
        colors = appearance.getColorStateList(com.android.internal.R.styleable.
                                              TextAppearance_textColorLink);
        {
            setLinkTextColor(colors);
        } 
        int typefaceIndex;
        int styleIndex;
        typefaceIndex = appearance.getInt(com.android.internal.R.styleable.
                                          TextAppearance_typeface, -1);
        styleIndex = appearance.getInt(com.android.internal.R.styleable.
                                       TextAppearance_textStyle, -1);
        setTypefaceByIndex(typefaceIndex, styleIndex);
        {
            boolean var3D022060DB92710670FAA09E327DBB0B_715142111 = (appearance.getBoolean(com.android.internal.R.styleable.TextAppearance_textAllCaps,
                false));
            {
                setTransformationMethod(new AllCapsTransformationMethod(getContext()));
            } 
        } 
        appearance.recycle();
        addTaint(context.getTaint());
        addTaint(resid);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.767 -0400", hash_original_method = "5E6FE671862457C6BB25EDC2CEDE399B", hash_generated_method = "6F683CBAD6A9437841784C69E273872A")
    public float getTextSize() {
        float var0C1431BDAC3C89F7C02E56A482F7EB06_1316028326 = (mTextPaint.getTextSize());
        float var546ADE640B6EDFBC8A086EF31347E768_1642148023 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1642148023;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.767 -0400", hash_original_method = "7DB2A551583349AB1C418E0528006365", hash_generated_method = "7022FE5849C46DA32E3D7BED5130B21D")
    @android.view.RemotableViewMethod
    public void setTextSize(float size) {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        addTaint(size);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.767 -0400", hash_original_method = "487975E6A0CF72E721F7BDECB44E1312", hash_generated_method = "4331CC46547B2EF80F30C1FDEE4E4DBB")
    public void setTextSize(int unit, float size) {
        Context c = getContext();
        Resources r;
        r = Resources.getSystem();
        r = c.getResources();
        setRawTextSize(TypedValue.applyDimension(
            unit, size, r.getDisplayMetrics()));
        addTaint(unit);
        addTaint(size);
        
        
        
        
            
        
            
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.768 -0400", hash_original_method = "ADDFE88D6F3490AE157EE578011F4FFC", hash_generated_method = "974B36B43DE903E735884CB16C637759")
    private void setRawTextSize(float size) {
        {
            boolean var8490AB7BC9B8B736A0090BC029E3A656_2020692511 = (size != mTextPaint.getTextSize());
            {
                mTextPaint.setTextSize(size);
                {
                    nullLayouts();
                    requestLayout();
                    invalidate();
                } 
            } 
        } 
        addTaint(size);
        
        
            
            
                
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.768 -0400", hash_original_method = "8F71F8091E79DE5D49BC786B53F6B56F", hash_generated_method = "63BDC860049CE7DA49C51E56A8C3FCCA")
    public float getTextScaleX() {
        float var4A490DCBBE6DC7C04831F39DE35D9E8E_1125452088 = (mTextPaint.getTextScaleX());
        float var546ADE640B6EDFBC8A086EF31347E768_1449229028 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1449229028;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.768 -0400", hash_original_method = "32FC23A8E8D24759E03CF98EE692BD3E", hash_generated_method = "AA65AA167F461A4BAC256150D64E8E81")
    @android.view.RemotableViewMethod
    public void setTextScaleX(float size) {
        {
            boolean varE98E2F263E58724773A791619F9AA580_1570427128 = (size != mTextPaint.getTextScaleX());
            {
                mUserSetTextScaleX = true;
                mTextPaint.setTextScaleX(size);
                {
                    nullLayouts();
                    requestLayout();
                    invalidate();
                } 
            } 
        } 
        addTaint(size);
        
        
            
            
            
                
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.769 -0400", hash_original_method = "780D15535FA403FCFD3F32D6E7303769", hash_generated_method = "DB6DFE5452B44C47ABA6F73C1F3CB16C")
    public void setTypeface(Typeface tf) {
        {
            boolean var53A61D5B68551E1C004BF255C4B2B68F_1075085520 = (mTextPaint.getTypeface() != tf);
            {
                mTextPaint.setTypeface(tf);
                {
                    nullLayouts();
                    requestLayout();
                    invalidate();
                } 
            } 
        } 
        addTaint(tf.getTaint());
        
        
            
            
                
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.769 -0400", hash_original_method = "6FFDE601A24D081BE5F9A52F7BB654E9", hash_generated_method = "4B581C7474C4CE038DD791003C5C071D")
    public Typeface getTypeface() {
        Typeface varB4EAC82CA7396A68D541C85D26508E83_1502946134 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1502946134 = mTextPaint.getTypeface();
        varB4EAC82CA7396A68D541C85D26508E83_1502946134.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1502946134;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.769 -0400", hash_original_method = "7D6C422943C1CBA6B222D2B0CA531386", hash_generated_method = "2CAC8DF2A1AC7DE030CB2AA266620CF2")
    @android.view.RemotableViewMethod
    public void setTextColor(int color) {
        mTextColor = ColorStateList.valueOf(color);
        updateTextColors();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.770 -0400", hash_original_method = "E5548FB85C1126384CE08AD8E1667A0C", hash_generated_method = "DBCF92A7B6820991B1500FD7CDB6D538")
    public void setTextColor(ColorStateList colors) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        mTextColor = colors;
        updateTextColors();
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.770 -0400", hash_original_method = "E9708E6780595497A0F38B1A3DFD4921", hash_generated_method = "72479F6F9F9257CEE40A63BB69B0BE41")
    public final ColorStateList getTextColors() {
        ColorStateList varB4EAC82CA7396A68D541C85D26508E83_365811992 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_365811992 = mTextColor;
        varB4EAC82CA7396A68D541C85D26508E83_365811992.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_365811992;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.770 -0400", hash_original_method = "69BC167CA8CC0024E4446D6ED57F972B", hash_generated_method = "124031145B758323AE19660FD9910D83")
    public final int getCurrentTextColor() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1930808016 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1930808016;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.771 -0400", hash_original_method = "969DDD835D55F329C6E2048E92EE3D41", hash_generated_method = "196D1EB5FB59C69B1805B4606553D31C")
    @android.view.RemotableViewMethod
    public void setHighlightColor(int color) {
        {
            mHighlightColor = color;
            invalidate();
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.771 -0400", hash_original_method = "5ADAC484D4689A7795B408EA7D6B6AC8", hash_generated_method = "54D7F4CA566DF112A37937ADB2533573")
    public void setShadowLayer(float radius, float dx, float dy, int color) {
        mTextPaint.setShadowLayer(radius, dx, dy, color);
        mShadowRadius = radius;
        mShadowDx = dx;
        mShadowDy = dy;
        invalidate();
        addTaint(color);
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.772 -0400", hash_original_method = "5B4E8CD3DF4A8D21F89EBB7BF27B30F6", hash_generated_method = "9006F0CF73221D63C593F7F1ED3359AE")
    public TextPaint getPaint() {
        TextPaint varB4EAC82CA7396A68D541C85D26508E83_1685474097 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1685474097 = mTextPaint;
        varB4EAC82CA7396A68D541C85D26508E83_1685474097.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1685474097;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.772 -0400", hash_original_method = "9B238C42610AAE77586EFF469787CAA2", hash_generated_method = "C5BD2E157496886451F125CEBC428118")
    @android.view.RemotableViewMethod
    public final void setAutoLinkMask(int mask) {
        mAutoLinkMask = mask;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.772 -0400", hash_original_method = "E276016FD2FFF976FC669270E78164FC", hash_generated_method = "212E0D71E4818E9438373D71E959C472")
    @android.view.RemotableViewMethod
    public final void setLinksClickable(boolean whether) {
        mLinksClickable = whether;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.773 -0400", hash_original_method = "5582C38299F4F11EB9D233BD445CE8CA", hash_generated_method = "48577DD14D67EDBB2D0326C5ADA865CF")
    public final boolean getLinksClickable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_218900172 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_218900172;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.773 -0400", hash_original_method = "4DF4A96EB5A0519062801E1FD0A991F4", hash_generated_method = "42E09EA41E686980C7CA000206A8DDAD")
    @android.view.RemotableViewMethod
    public final void setSoftInputShownOnFocus(boolean show) {
        mSoftInputShownOnFocus = show;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.773 -0400", hash_original_method = "5A10A6630E4A15A93780A83DCE21BFA6", hash_generated_method = "FE5F1FF7BC0207054ED37FC9E1D6DA36")
    public final boolean getSoftInputShownOnFocus() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_370260261 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_370260261;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.774 -0400", hash_original_method = "7722BA5204257A1CDED1550384208856", hash_generated_method = "967AA57CEF485C9080305ABBC4D394AC")
    public URLSpan[] getUrls() {
        URLSpan[] varB4EAC82CA7396A68D541C85D26508E83_1759443921 = null; 
        URLSpan[] varB4EAC82CA7396A68D541C85D26508E83_539881045 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1759443921 = ((Spanned) mText).getSpans(0, mText.length(), URLSpan.class);
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_539881045 = new URLSpan[0];
        } 
        URLSpan[] varA7E53CE21691AB073D9660D615818899_389569463; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_389569463 = varB4EAC82CA7396A68D541C85D26508E83_1759443921;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_389569463 = varB4EAC82CA7396A68D541C85D26508E83_539881045;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_389569463.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_389569463;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.775 -0400", hash_original_method = "E9B4A1B921938A82A5322DAF3992AE5D", hash_generated_method = "43DB0F7D23C2BA38E919E41FE56D752D")
    @android.view.RemotableViewMethod
    public final void setHintTextColor(int color) {
        mHintTextColor = ColorStateList.valueOf(color);
        updateTextColors();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.776 -0400", hash_original_method = "FDEA4F057DD6E07AD523C7053B227866", hash_generated_method = "579A043E994B5BCBDC50DABB884C27C2")
    public final void setHintTextColor(ColorStateList colors) {
        mHintTextColor = colors;
        updateTextColors();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.777 -0400", hash_original_method = "475EC0453C7F74E6A779EAD7F8319059", hash_generated_method = "33914903DBB96F4881D8153510C62A57")
    public final ColorStateList getHintTextColors() {
        ColorStateList varB4EAC82CA7396A68D541C85D26508E83_42014262 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_42014262 = mHintTextColor;
        varB4EAC82CA7396A68D541C85D26508E83_42014262.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_42014262;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.777 -0400", hash_original_method = "1826756F3CA2F0D97D555C81DC90D9D1", hash_generated_method = "6BC1A29DDF3C8993E5792866E76A2243")
    public final int getCurrentHintTextColor() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_919557837 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_919557837;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.777 -0400", hash_original_method = "9463279339C3C6EB304729CC6A96FD58", hash_generated_method = "57F482ABFE2EE8E9CEF1E8E3D393E6FC")
    @android.view.RemotableViewMethod
    public final void setLinkTextColor(int color) {
        mLinkTextColor = ColorStateList.valueOf(color);
        updateTextColors();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.778 -0400", hash_original_method = "9B67E7CBCE87C562841DDA31DA1BE653", hash_generated_method = "037C9825FD527ACDA5C188EDE566FA86")
    public final void setLinkTextColor(ColorStateList colors) {
        mLinkTextColor = colors;
        updateTextColors();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.778 -0400", hash_original_method = "3A49B90BEACC4CBB32A44A5B9C48739C", hash_generated_method = "A86B2E82619F0FD460897AA590DAB748")
    public final ColorStateList getLinkTextColors() {
        ColorStateList varB4EAC82CA7396A68D541C85D26508E83_14129340 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_14129340 = mLinkTextColor;
        varB4EAC82CA7396A68D541C85D26508E83_14129340.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_14129340;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.779 -0400", hash_original_method = "AEAA45BF8B2B9C05CF6AA4E644080F44", hash_generated_method = "56C2D4638E180790BF62FF090BAA6E36")
    public void setGravity(int gravity) {
        {
            gravity |= Gravity.START;
        } 
        {
            gravity |= Gravity.TOP;
        } 
        boolean newLayout = false;
        {
            newLayout = true;
        } 
        {
            invalidate();
            mLayoutAlignment = null;
        } 
        mGravity = gravity;
        {
            int want = mLayout.getWidth();
            int hintWant;
            hintWant = 0;
            hintWant = mHintLayout.getWidth();
            makeNewLayout(want, hintWant, UNKNOWN_BORING, UNKNOWN_BORING,
                          mRight - mLeft - getCompoundPaddingLeft() -
                          getCompoundPaddingRight(), true);
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.779 -0400", hash_original_method = "80A4065F7A7EA77AF4C4ADD19E36F9A5", hash_generated_method = "F09D2419EACDADB6BCB93AA4FC7D203F")
    public int getGravity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1825845206 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1825845206;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.779 -0400", hash_original_method = "7C7AF1B698E75A76793B55FAC07B7AAB", hash_generated_method = "53D29DD10774872D43BEEEAD6B2CED25")
    public int getPaintFlags() {
        int var1FCED777482D649D2D08ED31F26C7C02_669829627 = (mTextPaint.getFlags());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_520188308 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_520188308;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.780 -0400", hash_original_method = "8002046373E96371B4D25FE3E547C1A2", hash_generated_method = "66559643F7CFE942E735F7F0F27C3A88")
    @android.view.RemotableViewMethod
    public void setPaintFlags(int flags) {
        {
            boolean var8072314ED7B1DF7B4CA975059BE6435F_135504005 = (mTextPaint.getFlags() != flags);
            {
                mTextPaint.setFlags(flags);
                {
                    nullLayouts();
                    requestLayout();
                    invalidate();
                } 
            } 
        } 
        addTaint(flags);
        
        
            
            
                
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.780 -0400", hash_original_method = "EA5DCBED1A48E34EEA6259FD93E64EB0", hash_generated_method = "2799A825DF7BA515349AB569DDAD5A29")
    public void setHorizontallyScrolling(boolean whether) {
        {
            mHorizontallyScrolling = whether;
            {
                nullLayouts();
                requestLayout();
                invalidate();
            } 
        } 
        
        
            
            
                
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.780 -0400", hash_original_method = "7B94D421E91473A8A956329EBDF6A0E9", hash_generated_method = "0B0187AC1BC1B41FE733494B260DA0C9")
    public boolean getHorizontallyScrolling() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_111910316 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_111910316;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.781 -0400", hash_original_method = "0EE7081F083B0DC579019805442C8765", hash_generated_method = "4C59F2ED9822C6DB05B6F45EB0296D69")
    @android.view.RemotableViewMethod
    public void setMinLines(int minlines) {
        mMinimum = minlines;
        mMinMode = LINES;
        requestLayout();
        invalidate();
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.781 -0400", hash_original_method = "68757877A1DD20E33F15DE32FA3B7F07", hash_generated_method = "0A56EF1698F37084B430195320861A57")
    @android.view.RemotableViewMethod
    public void setMinHeight(int minHeight) {
        mMinimum = minHeight;
        mMinMode = PIXELS;
        requestLayout();
        invalidate();
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.781 -0400", hash_original_method = "8B36C1E1F9FD83BB5DA2A8A03A7A6664", hash_generated_method = "B2A20E5243DB69815414D52E2FE309B6")
    @android.view.RemotableViewMethod
    public void setMaxLines(int maxlines) {
        mMaximum = maxlines;
        mMaxMode = LINES;
        requestLayout();
        invalidate();
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.781 -0400", hash_original_method = "04C4C22BF9024D43E2A856D219B26DEF", hash_generated_method = "454D6005CAD9F205FEF255C979D08AF9")
    @android.view.RemotableViewMethod
    public void setMaxHeight(int maxHeight) {
        mMaximum = maxHeight;
        mMaxMode = PIXELS;
        requestLayout();
        invalidate();
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.782 -0400", hash_original_method = "1ADF089518552DEF85C429E373D0543D", hash_generated_method = "BFBDB748B0E03D6DCEF68597A04C08C2")
    @android.view.RemotableViewMethod
    public void setLines(int lines) {
        mMaximum = mMinimum = lines;
        mMaxMode = mMinMode = LINES;
        requestLayout();
        invalidate();
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.782 -0400", hash_original_method = "6CD9B04ABBE9A4E392854E2FFBA64155", hash_generated_method = "605750DFFC911807C455EB8BF69BC06C")
    @android.view.RemotableViewMethod
    public void setHeight(int pixels) {
        mMaximum = mMinimum = pixels;
        mMaxMode = mMinMode = PIXELS;
        requestLayout();
        invalidate();
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.783 -0400", hash_original_method = "6EF109AA0B8A98B265CEDBFE77B13F24", hash_generated_method = "D90D5130C6BDA102B7070F71A2C61C54")
    @android.view.RemotableViewMethod
    public void setMinEms(int minems) {
        mMinWidth = minems;
        mMinWidthMode = EMS;
        requestLayout();
        invalidate();
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.783 -0400", hash_original_method = "CC5034BC1B28BBCD01B0947E11300CEA", hash_generated_method = "AAD5723F0423927F8F6C32B9A4BE6D81")
    @android.view.RemotableViewMethod
    public void setMinWidth(int minpixels) {
        mMinWidth = minpixels;
        mMinWidthMode = PIXELS;
        requestLayout();
        invalidate();
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.784 -0400", hash_original_method = "024C424B12C855A76B8C4D4EF37E56E9", hash_generated_method = "DD52876446D0A1A3DAEC70BAED22C9E3")
    @android.view.RemotableViewMethod
    public void setMaxEms(int maxems) {
        mMaxWidth = maxems;
        mMaxWidthMode = EMS;
        requestLayout();
        invalidate();
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.785 -0400", hash_original_method = "66D27E295E9935EDB856E68754ECCF50", hash_generated_method = "11CEBBE63F35062DDE2A055E3857C0B3")
    @android.view.RemotableViewMethod
    public void setMaxWidth(int maxpixels) {
        mMaxWidth = maxpixels;
        mMaxWidthMode = PIXELS;
        requestLayout();
        invalidate();
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.785 -0400", hash_original_method = "29184B32707510663C7CC00A1776202A", hash_generated_method = "4DABCC8E368203558E4AE1484330F564")
    @android.view.RemotableViewMethod
    public void setEms(int ems) {
        mMaxWidth = mMinWidth = ems;
        mMaxWidthMode = mMinWidthMode = EMS;
        requestLayout();
        invalidate();
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.786 -0400", hash_original_method = "A6A8746AE8743344ECC9244BF17B5285", hash_generated_method = "16D0F80014324D2EF8F22A1CB338C9F9")
    @android.view.RemotableViewMethod
    public void setWidth(int pixels) {
        mMaxWidth = mMinWidth = pixels;
        mMaxWidthMode = mMinWidthMode = PIXELS;
        requestLayout();
        invalidate();
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.786 -0400", hash_original_method = "9D5DCCC1076394887EA3B21F5DF8F706", hash_generated_method = "3ACC6A936631F9A5D30B66E02C5F5F26")
    public void setLineSpacing(float add, float mult) {
        {
            mSpacingAdd = add;
            mSpacingMult = mult;
            {
                nullLayouts();
                requestLayout();
                invalidate();
            } 
        } 
        
        
            
            
            
                
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.786 -0400", hash_original_method = "699FFD9CCBE3B133871A47DAD4072321", hash_generated_method = "24894E0A2761B92D07D303A53C99D00E")
    public final void append(CharSequence text) {
        append(text, 0, text.length());
        addTaint(text.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.787 -0400", hash_original_method = "B2621C1C8DC7A6B197F310747926C024", hash_generated_method = "66DFCF5D0E6615919BA97E16CB34FA01")
    public void append(CharSequence text, int start, int end) {
        {
            setText(mText, BufferType.EDITABLE);
        } 
        ((Editable) mText).append(text, start, end);
        addTaint(text.getTaint());
        addTaint(start);
        addTaint(end);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.787 -0400", hash_original_method = "ADC7043537742A0A0C5E53BD45A182BE", hash_generated_method = "ADEA241748DE1B179F0631AA90655F0C")
    private void updateTextColors() {
        boolean inval = false;
        int color = mTextColor.getColorForState(getDrawableState(), 0);
        {
            mCurTextColor = color;
            inval = true;
        } 
        {
            color = mLinkTextColor.getColorForState(getDrawableState(), 0);
            {
                mTextPaint.linkColor = color;
                inval = true;
            } 
        } 
        {
            color = mHintTextColor.getColorForState(getDrawableState(), 0);
            {
                boolean var945E40D0ED79B723BC035DCD3A98AEB6_1396811482 = (color != mCurHintTextColor && mText.length() == 0);
                {
                    mCurHintTextColor = color;
                    inval = true;
                } 
            } 
        } 
        {
            invalidate();
        } 
        
        
        
        
            
            
        
        
            
            
                
                
            
        
        
            
            
                
                
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.788 -0400", hash_original_method = "3E3CC8861E854C1E6B450E5CB8D8974F", hash_generated_method = "E1A55BDE8E4BBEDC4DDBBCEC8D492D8B")
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        {
            boolean varF38C62369483FE4C64EC61B6DD68F7F8_451478333 = (mTextColor != null && mTextColor.isStateful()
                || (mHintTextColor != null && mHintTextColor.isStateful())
                || (mLinkTextColor != null && mLinkTextColor.isStateful()));
            {
                updateTextColors();
            } 
        } 
        final Drawables dr = mDrawables;
        {
            int[] state = getDrawableState();
            {
                boolean varACD1486C54959F8A8C53C39EC3474E1F_14265555 = (dr.mDrawableTop != null && dr.mDrawableTop.isStateful());
                {
                    dr.mDrawableTop.setState(state);
                } 
            } 
            {
                boolean var75A7C8EBF3DB0CE7B23F457B9BBE81BE_103654102 = (dr.mDrawableBottom != null && dr.mDrawableBottom.isStateful());
                {
                    dr.mDrawableBottom.setState(state);
                } 
            } 
            {
                boolean var351650CF2FFB93A328E0FCD6DD1DB2A5_1808092875 = (dr.mDrawableLeft != null && dr.mDrawableLeft.isStateful());
                {
                    dr.mDrawableLeft.setState(state);
                } 
            } 
            {
                boolean varD9BDE0148E482F4604F5C34A36FCFF7F_1327187123 = (dr.mDrawableRight != null && dr.mDrawableRight.isStateful());
                {
                    dr.mDrawableRight.setState(state);
                } 
            } 
            {
                boolean var324017722E1CA9DC15695D4422A8ADEC_1161755228 = (dr.mDrawableStart != null && dr.mDrawableStart.isStateful());
                {
                    dr.mDrawableStart.setState(state);
                } 
            } 
            {
                boolean var6C06DB7410AEA6854519536D78FF530C_1870714517 = (dr.mDrawableEnd != null && dr.mDrawableEnd.isStateful());
                {
                    dr.mDrawableEnd.setState(state);
                } 
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.799 -0400", hash_original_method = "AF2C3EA4891B79A54157B80D9A5CB454", hash_generated_method = "0E8A5E6314015E3C8699B271700BB8F0")
    @Override
    public Parcelable onSaveInstanceState() {
        
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_1213889727 = null; 
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_169760115 = null; 
        Parcelable superState = super.onSaveInstanceState();
        boolean save = mFreezesText;
        int start = 0;
        int end = 0;
        {
            start = getSelectionStart();
            end = getSelectionEnd();
            {
                save = true;
            } 
        } 
        {
            SavedState ss = new SavedState(superState);
            ss.selStart = start;
            ss.selEnd = end;
            {
                Spannable sp = new SpannableString(mText);
                {
                    ChangeWatcher cw = sp.getSpans(0, sp.length(), ChangeWatcher.class)[0];
                    {
                        sp.removeSpan(cw);
                    } 
                } 
                removeMisspelledSpans(sp);
                sp.removeSpan(mSuggestionRangeSpan);
                ss.text = sp;
            } 
            {
                ss.text = mText.toString();
            } 
            {
                boolean var7B30392DD0636DC4945382169DDF5396_1517982801 = (isFocused() && start >= 0 && end >= 0);
                {
                    ss.frozenWithFocus = true;
                } 
            } 
            ss.error = mError;
            varB4EAC82CA7396A68D541C85D26508E83_1213889727 = ss;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_169760115 = superState;
        Parcelable varA7E53CE21691AB073D9660D615818899_1910279464; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1910279464 = varB4EAC82CA7396A68D541C85D26508E83_1213889727;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1910279464 = varB4EAC82CA7396A68D541C85D26508E83_169760115;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1910279464.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1910279464;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.800 -0400", hash_original_method = "F2FC1C379415C0983647E04C4964FB91", hash_generated_method = "D20AC662FA587F09A9BACB73EB2D074C")
     void removeMisspelledSpans(Spannable spannable) {
        SuggestionSpan[] suggestionSpans = spannable.getSpans(0, spannable.length(),
                SuggestionSpan.class);
        {
            int i = 0;
            {
                int flags = suggestionSpans[i].getFlags();
                {
                    spannable.removeSpan(suggestionSpans[i]);
                } 
            } 
        } 
        addTaint(spannable.getTaint());
        
        
                
        
            
            
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.801 -0400", hash_original_method = "F50E2D5CE86BF5E6A61BC8360971F12F", hash_generated_method = "6917D5BBEC1C178515A477B0C9A71EDF")
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        
        {
            super.onRestoreInstanceState(state);
        } 
        SavedState ss = (SavedState)state;
        super.onRestoreInstanceState(ss.getSuperState());
        {
            setText(ss.text);
        } 
        {
            {
                int len = mText.length();
                {
                    String restored = "";
                    {
                        restored = "(restored) ";
                    } 
                } 
                {
                    Selection.setSelection((Spannable) mText, ss.selStart,
                                           ss.selEnd);
                    {
                        mFrozenWithFocus = true;
                    } 
                } 
            } 
        } 
        {
            final CharSequence error = ss.error;
            post(new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.801 -0400", hash_original_method = "6D4719BAECED3DD83F9692F93AFBC954", hash_generated_method = "28C54C47F8D5EF53BCA9BB85B0F3683C")
                public void run() {
                    setError(error);
                    
                    
                }
});
        } 
        addTaint(state.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.802 -0400", hash_original_method = "73E23EE9831A5ABB45118C6D9D08B19B", hash_generated_method = "949FD70C22A0A1B1AABDE9D0E667A116")
    @android.view.RemotableViewMethod
    public void setFreezesText(boolean freezesText) {
        mFreezesText = freezesText;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.802 -0400", hash_original_method = "8E3F839ECE8B91BC1C15216DAAE76890", hash_generated_method = "7EB69A6178E7CC6EA7BBDA4DD59119A1")
    public boolean getFreezesText() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1729123066 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1729123066;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.802 -0400", hash_original_method = "72071F64A960BCDF8628E8519218C076", hash_generated_method = "0D865B4C4C33F8BF881769588A4B7450")
    public final void setEditableFactory(Editable.Factory factory) {
        mEditableFactory = factory;
        setText(mText);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.803 -0400", hash_original_method = "EE70434E54240A6008C9D2EA9B017339", hash_generated_method = "D377DBA7CFAFD2BF6D3E343C891A2FD6")
    public final void setSpannableFactory(Spannable.Factory factory) {
        mSpannableFactory = factory;
        setText(mText);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.803 -0400", hash_original_method = "F37C8918E495A353D909855BE6AEA0B3", hash_generated_method = "5FD53354B68B1DDEE5AEA4EC576FB4A1")
    @android.view.RemotableViewMethod
    public final void setText(CharSequence text) {
        setText(text, mBufferType);
        addTaint(text.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.803 -0400", hash_original_method = "8D1404A47F965A96F115CE2D4080AFCB", hash_generated_method = "63DDFB03A800B1C465F653A064123166")
    @android.view.RemotableViewMethod
    public final void setTextKeepState(CharSequence text) {
        setTextKeepState(text, mBufferType);
        addTaint(text.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.803 -0400", hash_original_method = "607651EBB019EF2524713C89A6A4FC8C", hash_generated_method = "B9AF79FFCD8BCFDA30C1E3FE38203AD1")
    public void setText(CharSequence text, BufferType type) {
        setText(text, type, true, 0);
        {
            mCharWrapper.mChars = null;
        } 
        addTaint(text.getTaint());
        addTaint(type.getTaint());
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.805 -0400", hash_original_method = "EBAE4ED74D570AD4FF310073DD3BF4E5", hash_generated_method = "EFD66D284D73E215BAFE1E8378B9EE99")
    private void setText(CharSequence text, BufferType type,
                         boolean notifyBefore, int oldlen) {
        {
            text = "";
        } 
        {
            boolean var39C938BA181442FDC10CD6D971F0DA0A_339978387 = (!isSuggestionsEnabled());
            {
                text = removeSuggestionSpans(text);
            } 
        } 
        mTextPaint.setTextScaleX(1.0f);
        {
            boolean var61457476FF8B912C20F73CBD6BFFF2E9_607052004 = (text instanceof Spanned &&
            ((Spanned) text).getSpanStart(TextUtils.TruncateAt.MARQUEE) >= 0);
            {
                {
                    boolean varA499503C31DDA8FD1F6C5109B7E818B8_2009508162 = (ViewConfiguration.get(mContext).isFadingMarqueeEnabled());
                    {
                        setHorizontalFadingEdgeEnabled(true);
                        mMarqueeFadeMode = MARQUEE_FADE_NORMAL;
                    } 
                    {
                        setHorizontalFadingEdgeEnabled(false);
                        mMarqueeFadeMode = MARQUEE_FADE_SWITCH_SHOW_ELLIPSIS;
                    } 
                } 
                setEllipsize(TextUtils.TruncateAt.MARQUEE);
            } 
        } 
        int n = mFilters.length;
        {
            int i = 0;
            {
                CharSequence out = mFilters[i].filter(text, 0, text.length(),
                                                  EMPTY_SPANNED, 0, 0);
                {
                    text = out;
                } 
            } 
        } 
        {
            {
                oldlen = mText.length();
                sendBeforeTextChanged(mText, 0, oldlen, text.length());
            } 
            {
                sendBeforeTextChanged("", 0, 0, text.length());
            } 
        } 
        boolean needEditableForNotification = false;
        {
            boolean var1E59861D1519785A5B1D3AA4CF100E2E_1073839615 = (mListeners != null && mListeners.size() != 0);
            {
                needEditableForNotification = true;
            } 
        } 
        {
            Editable t = mEditableFactory.newEditable(text);
            text = t;
            setFilters(t, mFilters);
            InputMethodManager imm = InputMethodManager.peekInstance();
            imm.restartInput(this);
        } 
        {
            text = mSpannableFactory.newSpannable(text);
        } 
        {
            text = TextUtils.stringOrSpannedString(text);
        } 
        {
            Spannable s2;
            {
                s2 = (Spannable) text;
            } 
            {
                s2 = mSpannableFactory.newSpannable(text);
            } 
            {
                boolean var97F4E593FAFDDCB3DADB34B707ECC3A4_1538408955 = (Linkify.addLinks(s2, mAutoLinkMask));
                {
                    text = s2;
                    type = (type == BufferType.EDITABLE) ? BufferType.EDITABLE : BufferType.SPANNABLE;
                    mText = text;
                    {
                        boolean var397E1740E7A0A45470AA95146AAA2DB6_1446307811 = (mLinksClickable && !textCanBeSelected());
                        {
                            setMovementMethod(LinkMovementMethod.getInstance());
                        } 
                    } 
                } 
            } 
        } 
        mBufferType = type;
        mText = text;
        {
            mTransformed = text;
        } 
        {
            mTransformed = mTransformation.getTransformation(text, this);
        } 
        final int textLength = text.length();
        {
            Spannable sp = (Spannable) text;
            final ChangeWatcher[] watchers = sp.getSpans(0, sp.length(), ChangeWatcher.class);
            final int count = watchers.length;
            {
                int i = 0;
                sp.removeSpan(watchers[i]);
            } 
            mChangeWatcher = new ChangeWatcher();
            sp.setSpan(mChangeWatcher, 0, textLength, Spanned.SPAN_INCLUSIVE_INCLUSIVE |
                       (PRIORITY << Spanned.SPAN_PRIORITY_SHIFT));
            {
                sp.setSpan(mInput, 0, textLength, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
            } 
            {
                sp.setSpan(mTransformation, 0, textLength, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
            } 
            {
                mMovement.initialize(this, (Spannable) text);
                mSelectionMoved = false;
            } 
        } 
        {
            checkForRelayout();
        } 
        sendOnTextChanged(text, 0, oldlen, textLength);
        onTextChanged(text, 0, oldlen, textLength);
        {
            sendAfterTextChanged((Editable) text);
        } 
        prepareCursorControllers();
        addTaint(notifyBefore);
        addTaint(oldlen);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.806 -0400", hash_original_method = "36BFF315CD4AAC9D68E14477979C2AB5", hash_generated_method = "D1D43F8AF3011F877B028BC78BD5425C")
    public final void setText(char[] text, int start, int len) {
        int oldlen = 0;
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(start + ", " + len);
        } 
        {
            oldlen = mText.length();
            sendBeforeTextChanged(mText, 0, oldlen, len);
        } 
        {
            sendBeforeTextChanged("", 0, 0, len);
        } 
        {
            mCharWrapper = new CharWrapper(text, start, len);
        } 
        {
            mCharWrapper.set(text, start, len);
        } 
        setText(mCharWrapper, mBufferType, false, oldlen);
        
        
        
            
        
        
            
            
        
            
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.807 -0400", hash_original_method = "9AF748BA799D545173D512FE98AE91A8", hash_generated_method = "9A3EFE0B058795968AEBFDEC49808117")
    public final void setTextKeepState(CharSequence text, BufferType type) {
        int start = getSelectionStart();
        int end = getSelectionEnd();
        int len = text.length();
        setText(text, type);
        {
            {
                Selection.setSelection((Spannable) mText,
                                       Math.max(0, Math.min(start, len)),
                                       Math.max(0, Math.min(end, len)));
            } 
        } 
        addTaint(text.getTaint());
        addTaint(type.getTaint());
        
        
        
        
        
        
            
                
                                       
                                       
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.808 -0400", hash_original_method = "F67FB9F700F5516CACC8B84E46FAB678", hash_generated_method = "0676B0A1EA7DE798FD69D229DC16E951")
    @android.view.RemotableViewMethod
    public final void setText(int resid) {
        setText(getContext().getResources().getText(resid));
        addTaint(resid);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.808 -0400", hash_original_method = "A59BD645A347EA39C4147D9E24C2BE1F", hash_generated_method = "D6998C7794E793B2FC3B3526082C628A")
    public final void setText(int resid, BufferType type) {
        setText(getContext().getResources().getText(resid), type);
        addTaint(resid);
        addTaint(type.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.810 -0400", hash_original_method = "E428F8CA5E03E5225CDDDB51AA0FFAC9", hash_generated_method = "1C7156AC9E53EE66837E136407CAE7D3")
    @android.view.RemotableViewMethod
    public final void setHint(CharSequence hint) {
        mHint = TextUtils.stringOrSpannedString(hint);
        {
            checkForRelayout();
        } 
        {
            boolean varC3772D22FF7A469D7982AA256079D67D_1811504036 = (mText.length() == 0);
            {
                invalidate();
            } 
        } 
        
        
        
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.810 -0400", hash_original_method = "38FC4DBAEFB265C97233FE4F28F668E7", hash_generated_method = "D97F0928A4E76D2BFDE4CD82A8D2A721")
    @android.view.RemotableViewMethod
    public final void setHint(int resid) {
        setHint(getContext().getResources().getText(resid));
        addTaint(resid);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.810 -0400", hash_original_method = "B545FCA8809064A694F5A37F99B0BBF1", hash_generated_method = "CA22255A5AC2A26E169A0407391C1C18")
    @ViewDebug.CapturedViewProperty
    public CharSequence getHint() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1617646930 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1617646930 = mHint;
        varB4EAC82CA7396A68D541C85D26508E83_1617646930.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1617646930;
        
        
    }

    
        private static boolean isMultilineInputType(int type) {
        return (type & (EditorInfo.TYPE_MASK_CLASS | EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE)) ==
            (EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.812 -0400", hash_original_method = "49514C27E12484581D1021562BB6B56C", hash_generated_method = "B3303091435AE3B91B5B26A8452DC55C")
    public void setInputType(int type) {
        final boolean wasPassword = isPasswordInputType(mInputType);
        final boolean wasVisiblePassword = isVisiblePasswordInputType(mInputType);
        setInputType(type, false);
        final boolean isPassword = isPasswordInputType(type);
        final boolean isVisiblePassword = isVisiblePasswordInputType(type);
        boolean forceUpdate = false;
        {
            setTransformationMethod(PasswordTransformationMethod.getInstance());
            setTypefaceByIndex(MONOSPACE, 0);
        } 
        {
            {
                boolean var8E3893E4544969EB4AD418651F643506_1847481315 = (mTransformation == PasswordTransformationMethod.getInstance());
                {
                    forceUpdate = true;
                } 
            } 
            setTypefaceByIndex(MONOSPACE, 0);
        } 
        {
            setTypefaceByIndex(-1, -1);
            {
                boolean var8E3893E4544969EB4AD418651F643506_292349507 = (mTransformation == PasswordTransformationMethod.getInstance());
                {
                    forceUpdate = true;
                } 
            } 
        } 
        boolean singleLine = !isMultilineInputType(type);
        {
            applySingleLine(singleLine, !isPassword, true);
        } 
        {
            boolean var39C938BA181442FDC10CD6D971F0DA0A_1587238660 = (!isSuggestionsEnabled());
            {
                mText = removeSuggestionSpans(mText);
            } 
        } 
        InputMethodManager imm = InputMethodManager.peekInstance();
        imm.restartInput(this);
        addTaint(type);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.812 -0400", hash_original_method = "103CDD92E42BC521C8FE05F02491D14C", hash_generated_method = "C3486F96A5BA68AA92BA5F62C7E8DA54")
    private boolean hasPasswordTransformationMethod() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_223341163 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_223341163;
        
        
    }

    
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

    
        private static boolean isVisiblePasswordInputType(int inputType) {
        final int variation =
                inputType & (EditorInfo.TYPE_MASK_CLASS | EditorInfo.TYPE_MASK_VARIATION);
        return variation
                == (EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.813 -0400", hash_original_method = "5561319FE52E5BCF6B9F27794140DEB3", hash_generated_method = "9597CC79B00C6F9A01B8A8F839246F14")
    public void setRawInputType(int type) {
        mInputType = type;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.814 -0400", hash_original_method = "95BF8AE0F4607DDA852256E0031089E3", hash_generated_method = "C6CA3568ED8A6EBF218298F38AEA6A31")
    private void setInputType(int type, boolean direct) {
        final int cls = type & EditorInfo.TYPE_MASK_CLASS;
        KeyListener input;
        {
            boolean autotext = (type & EditorInfo.TYPE_TEXT_FLAG_AUTO_CORRECT) != 0;
            TextKeyListener.Capitalize cap;
            {
                cap = TextKeyListener.Capitalize.CHARACTERS;
            } 
            {
                cap = TextKeyListener.Capitalize.WORDS;
            } 
            {
                cap = TextKeyListener.Capitalize.SENTENCES;
            } 
            {
                cap = TextKeyListener.Capitalize.NONE;
            } 
            input = TextKeyListener.getInstance(autotext, cap);
        } 
        {
            input = DigitsKeyListener.getInstance(
                    (type & EditorInfo.TYPE_NUMBER_FLAG_SIGNED) != 0,
                    (type & EditorInfo.TYPE_NUMBER_FLAG_DECIMAL) != 0);
        } 
        {
            
            input = DateKeyListener.getInstance();
            
            
            input = TimeKeyListener.getInstance();
            
            
            input = DateTimeKeyListener.getInstance();
            
        } 
        {
            input = DialerKeyListener.getInstance();
        } 
        {
            input = TextKeyListener.getInstance();
        } 
        setRawInputType(type);
        mInput = input;
        {
            setKeyListenerOnly(input);
        } 
        addTaint(type);
        addTaint(direct);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.814 -0400", hash_original_method = "CC20F62DEC3871662808940856B4AD97", hash_generated_method = "B0DBEB3E7DC8D7835A69D5175ABCEF55")
    public int getInputType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_808895152 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_808895152;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.815 -0400", hash_original_method = "15D43244184C7971E001BEB05B105E77", hash_generated_method = "117C1C617D922EE43C934AA41161E1C9")
    public void setImeOptions(int imeOptions) {
        {
            mInputContentType = new InputContentType();
        } 
        mInputContentType.imeOptions = imeOptions;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.815 -0400", hash_original_method = "2B64657558FBAC5C9C7E6BDC8C1A3258", hash_generated_method = "988D77D03210B4171384B6C6309219CB")
    public int getImeOptions() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_936227499 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_936227499;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.816 -0400", hash_original_method = "1A4477F3225C39150F0F3FBD7557F91B", hash_generated_method = "C5C5C9001CAC3A457FF8C92679B7DAB1")
    public void setImeActionLabel(CharSequence label, int actionId) {
        {
            mInputContentType = new InputContentType();
        } 
        mInputContentType.imeActionLabel = label;
        mInputContentType.imeActionId = actionId;
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.816 -0400", hash_original_method = "A4E3D8286D59E9D4715BBC467F3D8808", hash_generated_method = "3E4AC8E95C4D3ABE8632BE442C094679")
    public CharSequence getImeActionLabel() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1291689235 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1291689235 = mInputContentType != null
                ? mInputContentType.imeActionLabel : null;
        varB4EAC82CA7396A68D541C85D26508E83_1291689235.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1291689235;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.817 -0400", hash_original_method = "4B4E4CA7604BFFF08B66F520F2D9A667", hash_generated_method = "66B3727A86EEB8624C90778EA91EF1D7")
    public int getImeActionId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_674692415 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_674692415;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.818 -0400", hash_original_method = "46DFB908E4A3870151F9CA120300C85B", hash_generated_method = "7133F0CAC1B7FFEC84F7A49EB5CE45B6")
    public void setOnEditorActionListener(OnEditorActionListener l) {
        {
            mInputContentType = new InputContentType();
        } 
        mInputContentType.onEditorActionListener = l;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.819 -0400", hash_original_method = "0518018E7AD402CBF7FDAFFEA66C2B57", hash_generated_method = "D21C7E3ED045AF1F4081FB16ABB80660")
    public void onEditorAction(int actionCode) {
        
        final InputContentType ict = mInputContentType;
        {
            {
                {
                    boolean varC6096D11527A2336F0603C550DF9620B_1293067837 = (ict.onEditorActionListener.onEditorAction(this,
                        actionCode, null));
                } 
            } 
            {
                View v = focusSearch(FOCUS_FORWARD);
                {
                    {
                        boolean var1C5B6BCE2F4451CCE5A9C33B9CF3E849_344623113 = (!v.requestFocus(FOCUS_FORWARD));
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("focus search returned a view " +
                                "that wasn't able to take focus!");
                        } 
                    } 
                } 
            } 
            {
                View v = focusSearch(FOCUS_BACKWARD);
                {
                    {
                        boolean varF90963F65450DE26E78172A72D4AE61B_75547114 = (!v.requestFocus(FOCUS_BACKWARD));
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("focus search returned a view " +
                                "that wasn't able to take focus!");
                        } 
                    } 
                } 
            } 
            {
                InputMethodManager imm = InputMethodManager.peekInstance();
                {
                    boolean var4FA09E363AF255ACFA7DE6A3A2C1C773_1446445399 = (imm != null && imm.isActive(this));
                    {
                        imm.hideSoftInputFromWindow(getWindowToken(), 0);
                    } 
                } 
            } 
        } 
        Handler h = getHandler();
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
        } 
        addTaint(actionCode);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.820 -0400", hash_original_method = "E93C7F3F4C0717B4FFE77CC972CA5ABA", hash_generated_method = "FF535EDD450BA14F782FC3096947B6EC")
    public void setPrivateImeOptions(String type) {
        mInputContentType = new InputContentType();
        mInputContentType.privateImeOptions = type;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.820 -0400", hash_original_method = "92B56934BB38E74A857D4D87A23CFEBD", hash_generated_method = "6462CE46C52E56F0AF7623CE8DBEA5AD")
    public String getPrivateImeOptions() {
        String varB4EAC82CA7396A68D541C85D26508E83_781772815 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_781772815 = mInputContentType != null
                ? mInputContentType.privateImeOptions : null;
        varB4EAC82CA7396A68D541C85D26508E83_781772815.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_781772815;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.821 -0400", hash_original_method = "4D2957EAEB6AF33B1C49D1AAB860E441", hash_generated_method = "CD620B712A16A4E9D762B9AFD0680F58")
    public void setInputExtras(int xmlResId) throws XmlPullParserException, IOException {
        XmlResourceParser parser = getResources().getXml(xmlResId);
        mInputContentType = new InputContentType();
        mInputContentType.extras = new Bundle();
        getResources().parseBundleExtras(parser, mInputContentType.extras);
        addTaint(xmlResId);
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.822 -0400", hash_original_method = "3CCBAE1ACA56EC727CC56362E5EC99DC", hash_generated_method = "59EA5B8B3BFBE83D7AF79202F83E5C7E")
    public Bundle getInputExtras(boolean create) {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1395570042 = null; 
        Bundle varB4EAC82CA7396A68D541C85D26508E83_713174063 = null; 
        Bundle varB4EAC82CA7396A68D541C85D26508E83_506010705 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1395570042 = null;
            mInputContentType = new InputContentType();
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_713174063 = null;
            mInputContentType.extras = new Bundle();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_506010705 = mInputContentType.extras;
        addTaint(create);
        Bundle varA7E53CE21691AB073D9660D615818899_2126623334; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2126623334 = varB4EAC82CA7396A68D541C85D26508E83_1395570042;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_2126623334 = varB4EAC82CA7396A68D541C85D26508E83_713174063;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2126623334 = varB4EAC82CA7396A68D541C85D26508E83_506010705;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2126623334.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2126623334;
        
        
            
            
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.823 -0400", hash_original_method = "9A980CBEBB946A11C624D95D8D1017B2", hash_generated_method = "70F3D0A08EB64A4B41B81787B77DC130")
    public CharSequence getError() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1329859507 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1329859507 = mError;
        varB4EAC82CA7396A68D541C85D26508E83_1329859507.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1329859507;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.823 -0400", hash_original_method = "D7457C91A83A908A8309ED29F602BDCA", hash_generated_method = "5D730F5F92218F614522C41F3515780B")
    @android.view.RemotableViewMethod
    public void setError(CharSequence error) {
        {
            setError(null, null);
        } 
        {
            Drawable dr = getContext().getResources().
                getDrawable(com.android.internal.R.drawable.indicator_input_error);
            dr.setBounds(0, 0, dr.getIntrinsicWidth(), dr.getIntrinsicHeight());
            setError(error, dr);
        } 
        addTaint(error.getTaint());
        
        
            
        
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.824 -0400", hash_original_method = "A707A7C4B74C4D669C69114C0D73A7BA", hash_generated_method = "5DC5E7310BADD3B4A8DFF52B5255C041")
    public void setError(CharSequence error, Drawable icon) {
        error = TextUtils.stringOrSpannedString(error);
        mError = error;
        mErrorWasChanged = true;
        final Drawables dr = mDrawables;
        {
            {
                Object var9F1D8BFC1663434C04073ED5C9ABAE03_698989545 = (getResolvedLayoutDirection());
                
                setCompoundDrawables(dr.mDrawableLeft, dr.mDrawableTop, icon,
                            dr.mDrawableBottom);
                
                
                setCompoundDrawables(icon, dr.mDrawableTop, dr.mDrawableRight,
                            dr.mDrawableBottom);
                
            } 
        } 
        {
            setCompoundDrawables(null, null, icon, null);
        } 
        {
            {
                {
                    boolean var4EAD5BA12B52AD8D73AFD9224AD88B47_1806828085 = (mPopup.isShowing());
                    {
                        mPopup.dismiss();
                    } 
                } 
                mPopup = null;
            } 
        } 
        {
            {
                boolean var98C1250B21329AE579A768A5FB60FE48_1564777293 = (isFocused());
                {
                    showError();
                } 
            } 
        } 
        addTaint(icon.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.824 -0400", hash_original_method = "691606EEB666F38CF8433096C671CCBD", hash_generated_method = "35DD91F9AD97B99ABDEF9A8ED62490B1")
    private void showError() {
        {
            boolean varFF25C8C36D549896D247167EFDFCA86E_181116565 = (getWindowToken() == null);
            {
                mShowErrorAfterAttach = true;
            } 
        } 
        {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            final TextView err = (TextView) inflater.inflate(
                    com.android.internal.R.layout.textview_hint, null);
            final float scale = getResources().getDisplayMetrics().density;
            mPopup = new ErrorPopup(err, (int) (200 * scale + 0.5f), (int) (50 * scale + 0.5f));
            mPopup.setFocusable(false);
            mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        } 
        TextView tv = (TextView) mPopup.getContentView();
        chooseSize(mPopup, mError, tv);
        tv.setText(mError);
        mPopup.showAsDropDown(this, getErrorX(), getErrorY());
        mPopup.fixDirection(mPopup.isAboveAnchor());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.825 -0400", hash_original_method = "193E855DAAE9F0495F7DD2501E8046B7", hash_generated_method = "6C876084783F23C8C664E9C14C795713")
    private int getErrorX() {
        final float scale = getResources().getDisplayMetrics().density;
        final Drawables dr = mDrawables;
        int var5CC39021D81A29A88ABF707530C095B6_365042307 = (getWidth() - mPopup.getWidth() - getPaddingRight() -
                (dr != null ? dr.mDrawableSizeRight : 0) / 2 + (int) (25 * scale + 0.5f)); 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_924108398 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_924108398;
        
        
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.825 -0400", hash_original_method = "AEF78C4F5C84BB7DCAE783FBA8691257", hash_generated_method = "94B2225C96B7B10BF46D30ACE9C096FF")
    private int getErrorY() {
        final int compoundPaddingTop = getCompoundPaddingTop();
        int vspace = mBottom - mTop - getCompoundPaddingBottom() - compoundPaddingTop;
        final Drawables dr = mDrawables;
        int icontop = compoundPaddingTop +
                (vspace - (dr != null ? dr.mDrawableHeightRight : 0)) / 2;
        final float scale = getResources().getDisplayMetrics().density;
        int var003746F0616F92D98A8FCB729FE8B13B_1115538163 = (icontop + (dr != null ? dr.mDrawableHeightRight : 0) - getHeight() -
                (int) (2 * scale + 0.5f)); 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_672219759 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_672219759;
        
        
        
        
        
                
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.826 -0400", hash_original_method = "F599686205634A1B40098A399108C287", hash_generated_method = "E2165677F31B2E8B7D34B7F22BD43FA8")
    private void hideError() {
        {
            {
                boolean var064AFD47A2F0375BD3A49E11623DCB44_1597762771 = (mPopup.isShowing());
                {
                    mPopup.dismiss();
                } 
            } 
        } 
        mShowErrorAfterAttach = false;
        
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.826 -0400", hash_original_method = "E776865F48A57A0CE6F068EC64FA9769", hash_generated_method = "374401450BF87739523773BF02E82FA7")
    private void chooseSize(PopupWindow pop, CharSequence text, TextView tv) {
        int wid = tv.getPaddingLeft() + tv.getPaddingRight();
        int ht = tv.getPaddingTop() + tv.getPaddingBottom();
        int defaultWidthInPixels = getResources().getDimensionPixelSize(
                com.android.internal.R.dimen.textview_error_popup_default_width);
        Layout l = new StaticLayout(text, tv.getPaint(), defaultWidthInPixels,
                                    Layout.Alignment.ALIGN_NORMAL, 1, 0, true);
        float max = 0;
        {
            int i = 0;
            boolean var042843EFDE50DED9CF686A63F696B025_1568903264 = (i < l.getLineCount());
            {
                max = Math.max(max, l.getLineWidth(i));
            } 
        } 
        pop.setWidth(wid + (int) Math.ceil(max));
        pop.setHeight(ht + l.getHeight());
        addTaint(pop.getTaint());
        addTaint(text.getTaint());
        addTaint(tv.getTaint());
        
        
        
        
                
        
                                    
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.827 -0400", hash_original_method = "5914A6C90CD99156CDEB55240C7F0CC3", hash_generated_method = "A3FD309F42FDD4C1C7D44A4F1F7900F6")
    @Override
    protected boolean setFrame(int l, int t, int r, int b) {
        boolean result = super.setFrame(l, t, r, b);
        {
            TextView tv = (TextView) mPopup.getContentView();
            chooseSize(mPopup, mError, tv);
            mPopup.update(this, getErrorX(), getErrorY(),
                          mPopup.getWidth(), mPopup.getHeight());
        } 
        restartMarqueeIfNeeded();
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1637027318 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1637027318;
        
        
        
            
            
            
                          
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.828 -0400", hash_original_method = "F008D6FB8FE5770ECA7C6E535BB409D7", hash_generated_method = "58C3F38AB1DCEF27A70B6FDEB5D5ADF4")
    private void restartMarqueeIfNeeded() {
        {
            mRestartMarquee = false;
            startMarquee();
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.829 -0400", hash_original_method = "BC1716C27CAAB9B1A5BA926037A5041B", hash_generated_method = "5FB3243FB057E69E4F6D0771C193732B")
    public void setFilters(InputFilter[] filters) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } 
        mFilters = filters;
        {
            setFilters((Editable) mText, filters);
        } 
        
        
            
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.829 -0400", hash_original_method = "48C3B4A6108D00EDE1CFE79059C5E0E2", hash_generated_method = "D783F144C61B0EE5CB9B8E8A15FD7AEA")
    private void setFilters(Editable e, InputFilter[] filters) {
        {
            InputFilter[] nf = new InputFilter[filters.length + 1];
            System.arraycopy(filters, 0, nf, 0, filters.length);
            nf[filters.length] = (InputFilter) mInput;
            e.setFilters(nf);
        } 
        {
            e.setFilters(filters);
        } 
        addTaint(e.getTaint());
        addTaint(filters[0].getTaint());
        
        
            
            
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.830 -0400", hash_original_method = "E0010D0DD1DD8F03E408AEE972028B3D", hash_generated_method = "EE60CCA11F19C08C55ABDC0CAD84E49E")
    public InputFilter[] getFilters() {
        InputFilter[] varB4EAC82CA7396A68D541C85D26508E83_582983187 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_582983187 = mFilters;
        varB4EAC82CA7396A68D541C85D26508E83_582983187.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_582983187;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.831 -0400", hash_original_method = "DAA92D774C652EE383E55D96FD59260D", hash_generated_method = "840F5DAA24B49068D3A20861159A8C75")
    private int getVerticalOffset(boolean forceNormal) {
        int voffset = 0;
        final int gravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
        Layout l = mLayout;
        {
            boolean varD5DF217776FEC14CA244AC2CD8EE62D0_598267875 = (!forceNormal && mText.length() == 0 && mHintLayout != null);
            {
                l = mHintLayout;
            } 
        } 
        {
            int boxht;
            {
                boxht = getMeasuredHeight() - getCompoundPaddingTop() -
                        getCompoundPaddingBottom();
            } 
            {
                boxht = getMeasuredHeight() - getExtendedPaddingTop() -
                        getExtendedPaddingBottom();
            } 
            int textht = l.getHeight();
            {
                voffset = boxht - textht;
                voffset = (boxht - textht) >> 1;
            } 
        } 
        addTaint(forceNormal);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_433562733 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_433562733;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.831 -0400", hash_original_method = "FA4757416C7C28BA09CF9D290B4D7551", hash_generated_method = "EC3DC7609EFCBE2C3576D0056D7607EF")
    private int getBottomVerticalOffset(boolean forceNormal) {
        int voffset = 0;
        final int gravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
        Layout l = mLayout;
        {
            boolean varD5DF217776FEC14CA244AC2CD8EE62D0_1853857834 = (!forceNormal && mText.length() == 0 && mHintLayout != null);
            {
                l = mHintLayout;
            } 
        } 
        {
            int boxht;
            {
                boxht = getMeasuredHeight() - getCompoundPaddingTop() -
                        getCompoundPaddingBottom();
            } 
            {
                boxht = getMeasuredHeight() - getExtendedPaddingTop() -
                        getExtendedPaddingBottom();
            } 
            int textht = l.getHeight();
            {
                voffset = boxht - textht;
                voffset = (boxht - textht) >> 1;
            } 
        } 
        addTaint(forceNormal);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_657076067 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_657076067;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.832 -0400", hash_original_method = "53216DF5147B6AD3B10E93427C42A87D", hash_generated_method = "0FB4C1D1311EB1AC55F6397BC8A986A9")
    private void invalidateCursorPath() {
        {
            invalidateCursor();
        } 
        {
            final int horizontalPadding = getCompoundPaddingLeft();
            final int verticalPadding = getExtendedPaddingTop() + getVerticalOffset(true);
            {
                {
                    float thick = FloatMath.ceil(mTextPaint.getStrokeWidth());
                    {
                        thick = 1.0f;
                    } 
                    thick /= 2.0f;
                    mHighlightPath.computeBounds(sTempRect, false);
                    invalidate((int) FloatMath.floor(horizontalPadding + sTempRect.left - thick),
                            (int) FloatMath.floor(verticalPadding + sTempRect.top - thick),
                            (int) FloatMath.ceil(horizontalPadding + sTempRect.right + thick),
                            (int) FloatMath.ceil(verticalPadding + sTempRect.bottom + thick));
                } 
            } 
            {
                {
                    int i = 0;
                    {
                        Rect bounds = mCursorDrawable[i].getBounds();
                        invalidate(bounds.left + horizontalPadding, bounds.top + verticalPadding,
                            bounds.right + horizontalPadding, bounds.bottom + verticalPadding);
                    } 
                } 
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.832 -0400", hash_original_method = "18CF38FA770F258E57001CEB5008E4BD", hash_generated_method = "E1D6820191EB703EFE114B58505AECB6")
    private void invalidateCursor() {
        int where = getSelectionEnd();
        invalidateCursor(where, where, where);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.833 -0400", hash_original_method = "7C61928A88071E487AF3987FA1C70EFA", hash_generated_method = "82186165775D30FC3BEF728C1A9BDEBA")
    private void invalidateCursor(int a, int b, int c) {
        {
            int start = Math.min(Math.min(a, b), c);
            int end = Math.max(Math.max(a, b), c);
            invalidateRegion(start, end, true );
        } 
        addTaint(a);
        addTaint(b);
        addTaint(c);
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.833 -0400", hash_original_method = "D9CEA3E6F10B2E8340E14518563D9425", hash_generated_method = "59BFD0C188236905576047E72857B25E")
     void invalidateRegion(int start, int end, boolean invalidateCursor) {
        {
            invalidate();
        } 
        {
            int lineStart = mLayout.getLineForOffset(start);
            int top = mLayout.getLineTop(lineStart);
            {
                top -= mLayout.getLineDescent(lineStart - 1);
            } 
            int lineEnd;
            lineEnd = lineStart;
            lineEnd = mLayout.getLineForOffset(end);
            int bottom = mLayout.getLineBottom(lineEnd);
            {
                {
                    int i = 0;
                    {
                        Rect bounds = mCursorDrawable[i].getBounds();
                        top = Math.min(top, bounds.top);
                        bottom = Math.max(bottom, bounds.bottom);
                    } 
                } 
            } 
            final int compoundPaddingLeft = getCompoundPaddingLeft();
            final int verticalPadding = getExtendedPaddingTop() + getVerticalOffset(true);
            int left;
            int right;
            {
                left = (int) mLayout.getPrimaryHorizontal(start);
                right = (int) (mLayout.getPrimaryHorizontal(end) + 1.0);
                left += compoundPaddingLeft;
                right += compoundPaddingLeft;
            } 
            {
                left = compoundPaddingLeft;
                right = getWidth() - getCompoundPaddingRight();
            } 
            invalidate(mScrollX + left, verticalPadding + top,
                        mScrollX + right, verticalPadding + bottom);
        } 
        addTaint(start);
        addTaint(end);
        addTaint(invalidateCursor);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.834 -0400", hash_original_method = "14444C10F141ED0D65415BFE9043EE15", hash_generated_method = "623B4E80FB0E270CE6348E096E1D6628")
    private void registerForPreDraw() {
        final ViewTreeObserver observer = getViewTreeObserver();
        {
            observer.addOnPreDrawListener(this);
            mPreDrawState = PREDRAW_PENDING;
        } 
        {
            mPreDrawState = PREDRAW_PENDING;
        } 
        
        
        
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.834 -0400", hash_original_method = "7ED99206FCCA4C828A375B5616572C0F", hash_generated_method = "878E913D0188499A1973059CA508F9A8")
    public boolean onPreDraw() {
        
        {
            assumeLayout();
        } 
        boolean changed = false;
        {
            int curs = getSelectionEnd();
            {
                boolean var12D57A2CE148B359BC68B232D2B7DC8F_1217831282 = (mSelectionModifierCursorController != null &&
                    mSelectionModifierCursorController.isSelectionStartDragged());
                {
                    curs = getSelectionStart();
                } 
            } 
            {
                curs = mText.length();
            } 
            {
                changed = bringPointIntoView(curs);
            } 
        } 
        {
            changed = bringTextIntoView();
        } 
        {
            startSelectionActionMode();
            mCreatedWithASelection = false;
        } 
        {
            boolean varA5CB988193F65A0949A8B845CF954A56_1474149684 = (this instanceof ExtractEditText && hasSelection());
            {
                startSelectionActionMode();
            } 
        } 
        mPreDrawState = PREDRAW_DONE;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_131467412 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_131467412;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.835 -0400", hash_original_method = "37A00D47E5792B2A68D22343089CAC73", hash_generated_method = "2437E694BF2234494CC76E37DF7D4940")
    @Override
    protected void onAttachedToWindow() {
        
        super.onAttachedToWindow();
        mTemporaryDetach = false;
        {
            showError();
            mShowErrorAfterAttach = false;
        } 
        final ViewTreeObserver observer = getViewTreeObserver();
        {
            observer.addOnTouchModeChangeListener(mInsertionPointCursorController);
        } 
        {
            observer.addOnTouchModeChangeListener(mSelectionModifierCursorController);
        } 
        resolveDrawables();
        updateSpellCheckSpans(0, mText.length(), true );
        
        
        
        
            
            
        
        
        
            
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.836 -0400", hash_original_method = "16099E9CBA4D38D7973AB46B58716911", hash_generated_method = "A581D17CC5707A5AEDD2DDD6E3D75B9D")
    @Override
    protected void onDetachedFromWindow() {
        
        super.onDetachedFromWindow();
        final ViewTreeObserver observer = getViewTreeObserver();
        {
            observer.removeOnPreDrawListener(this);
            mPreDrawState = PREDRAW_NOT_REGISTERED;
        } 
        {
            hideError();
        } 
        {
            mBlink.removeCallbacks(mBlink);
        } 
        {
            mInsertionPointCursorController.onDetached();
        } 
        {
            mSelectionModifierCursorController.onDetached();
        } 
        hideControllers();
        resetResolvedDrawables();
        {
            mSpellChecker.closeSession();
            mSpellChecker = null;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.836 -0400", hash_original_method = "F9485E7598554FF005152B05BE66332E", hash_generated_method = "D93B930541DB2204299E5735425E03DB")
    @Override
    protected boolean isPaddingOffsetRequired() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1030441881 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1030441881;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.836 -0400", hash_original_method = "7F5FAD56D372BFDBD8919382F1DF4F10", hash_generated_method = "7A0551AF52EFA309832345C3E0BD6ACA")
    @Override
    protected int getLeftPaddingOffset() {
        int var58C5EE75D3D1900953AF755581344C8A_1048891957 = (getCompoundPaddingLeft() - mPaddingLeft +
                (int) Math.min(0, mShadowDx - mShadowRadius));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_490714607 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_490714607;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.837 -0400", hash_original_method = "BBBA34DDC8A574B01D58B3AC0235EEFE", hash_generated_method = "64EFBEB949591020F48C20C59DDEBD82")
    @Override
    protected int getTopPaddingOffset() {
        int var0ED6224353BB97F3F21905FBACD93DCB_1158926266 = ((int) Math.min(0, mShadowDy - mShadowRadius));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2056400560 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2056400560;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.838 -0400", hash_original_method = "2F5480661817CC97DFDD529692B7CB6A", hash_generated_method = "DF83909E8B0BF875AE62B8564601FC37")
    @Override
    protected int getBottomPaddingOffset() {
        int varB10121B4D3A3118F0C573D58A81C1C32_1807191898 = ((int) Math.max(0, mShadowDy + mShadowRadius));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1635297266 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1635297266;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.838 -0400", hash_original_method = "03B94E40D261DCBBD1910980153D8E7A", hash_generated_method = "38749370458BD7C5B59B1037958BB2B4")
    @Override
    protected int getRightPaddingOffset() {
        int var513406E75DBEDB7AB1D4B061E88F3D83_580550247 = (-(getCompoundPaddingRight() - mPaddingRight) +
                (int) Math.max(0, mShadowDx + mShadowRadius));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1431467051 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1431467051;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.839 -0400", hash_original_method = "CE928B829998126087759CE89BCD7C50", hash_generated_method = "B629364D3AEEC4FB45566209099DDFE6")
    @Override
    protected boolean verifyDrawable(Drawable who) {
        final boolean verified = super.verifyDrawable(who);
        addTaint(who.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_814245254 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_814245254;
        
        
        
            
                    
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.840 -0400", hash_original_method = "40478AC632904F83B590338EFFF77EC4", hash_generated_method = "D986EC85476D6044DCA7E50788DFA532")
    @Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        {
            {
                mDrawables.mDrawableLeft.jumpToCurrentState();
            } 
            {
                mDrawables.mDrawableTop.jumpToCurrentState();
            } 
            {
                mDrawables.mDrawableRight.jumpToCurrentState();
            } 
            {
                mDrawables.mDrawableBottom.jumpToCurrentState();
            } 
            {
                mDrawables.mDrawableStart.jumpToCurrentState();
            } 
            {
                mDrawables.mDrawableEnd.jumpToCurrentState();
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.841 -0400", hash_original_method = "BFAA7AB246AB7FE030F8E5E06E7C4938", hash_generated_method = "820885D6915D9E6453FEE77FF6E75930")
    @Override
    public void invalidateDrawable(Drawable drawable) {
        {
            boolean var6429BFA2CE72B3A4B0873DE16CAD3D14_443374856 = (verifyDrawable(drawable));
            {
                final Rect dirty = drawable.getBounds();
                int scrollX = mScrollX;
                int scrollY = mScrollY;
                final TextView.Drawables drawables = mDrawables;
                {
                    {
                        final int compoundPaddingTop = getCompoundPaddingTop();
                        final int compoundPaddingBottom = getCompoundPaddingBottom();
                        final int vspace = mBottom - mTop - compoundPaddingBottom - compoundPaddingTop;
                        scrollX += mPaddingLeft;
                        scrollY += compoundPaddingTop + (vspace - drawables.mDrawableHeightLeft) / 2;
                    } 
                    {
                        final int compoundPaddingTop = getCompoundPaddingTop();
                        final int compoundPaddingBottom = getCompoundPaddingBottom();
                        final int vspace = mBottom - mTop - compoundPaddingBottom - compoundPaddingTop;
                        scrollX += (mRight - mLeft - mPaddingRight - drawables.mDrawableSizeRight);
                        scrollY += compoundPaddingTop + (vspace - drawables.mDrawableHeightRight) / 2;
                    } 
                    {
                        final int compoundPaddingLeft = getCompoundPaddingLeft();
                        final int compoundPaddingRight = getCompoundPaddingRight();
                        final int hspace = mRight - mLeft - compoundPaddingRight - compoundPaddingLeft;
                        scrollX += compoundPaddingLeft + (hspace - drawables.mDrawableWidthTop) / 2;
                        scrollY += mPaddingTop;
                    } 
                    {
                        final int compoundPaddingLeft = getCompoundPaddingLeft();
                        final int compoundPaddingRight = getCompoundPaddingRight();
                        final int hspace = mRight - mLeft - compoundPaddingRight - compoundPaddingLeft;
                        scrollX += compoundPaddingLeft + (hspace - drawables.mDrawableWidthBottom) / 2;
                        scrollY += (mBottom - mTop - mPaddingBottom - drawables.mDrawableSizeBottom);
                    } 
                } 
                invalidate(dirty.left + scrollX, dirty.top + scrollY,
                    dirty.right + scrollX, dirty.bottom + scrollY);
            } 
        } 
        addTaint(drawable.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.841 -0400", hash_original_method = "365B978F98464E672BAE2334EE130C56", hash_generated_method = "28FD2DC0D21B1573EA8BF90CC2956740")
    @Override
    public int getResolvedLayoutDirection(Drawable who) {
        {
            final Drawables drawables = mDrawables;
            {
                int var9F1D8BFC1663434C04073ED5C9ABAE03_1193863617 = (getResolvedLayoutDirection());
            } 
        } 
        int varC2F7741B418937D0E08C7C868777F70A_642255054 = (super.getResolvedLayoutDirection(who));
        addTaint(who.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_930224492 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_930224492;
        
        
        
            
            
                
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.842 -0400", hash_original_method = "361EEEB4229AF287B326C983EB9B20B0", hash_generated_method = "931F93E7567F5A020523CF23B074EC46")
    @Override
    protected boolean onSetAlpha(int alpha) {
        
        {
            boolean varF9737FBB3FA84CB9364E87D929DD087B_286684770 = (getBackground() == null);
            {
                mCurrentAlpha = alpha;
                final Drawables dr = mDrawables;
                {
                    dr.mDrawableLeft.mutate().setAlpha(alpha);
                    dr.mDrawableTop.mutate().setAlpha(alpha);
                    dr.mDrawableRight.mutate().setAlpha(alpha);
                    dr.mDrawableBottom.mutate().setAlpha(alpha);
                    dr.mDrawableStart.mutate().setAlpha(alpha);
                    dr.mDrawableEnd.mutate().setAlpha(alpha);
                } 
            } 
        } 
        mCurrentAlpha = 255;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_940590451 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_940590451;
        
        
            
            
            
                
                
                
                
                
                
            
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.842 -0400", hash_original_method = "CB6193FD8EC60616857FED31421868C5", hash_generated_method = "BDD3AB9500C3BDB2DBD8439AFDCFB05A")
    public boolean isTextSelectable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_541304323 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_541304323;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.842 -0400", hash_original_method = "F5356B5CDB0C54713C7C3659E2E49BDB", hash_generated_method = "9BDA14E19AC3B62652D1ECC211E963FD")
    public void setTextIsSelectable(boolean selectable) {
        mTextIsSelectable = selectable;
        setFocusableInTouchMode(selectable);
        setFocusable(selectable);
        setClickable(selectable);
        setLongClickable(selectable);
        setMovementMethod(selectable ? ArrowKeyMovementMethod.getInstance() : null);
        setText(getText(), selectable ? BufferType.SPANNABLE : BufferType.NORMAL);
        prepareCursorControllers();
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.843 -0400", hash_original_method = "E327CCF4B590DA515951F33B48F8FD2D", hash_generated_method = "457281434D51259C5B5F0172CD32B644")
    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        
        int[] drawableState;
        {
            drawableState = super.onCreateDrawableState(extraSpace);
        } 
        {
            drawableState = super.onCreateDrawableState(extraSpace + 1);
            mergeDrawableStates(drawableState, MULTILINE_STATE_SET);
        } 
        {
            final int length = drawableState.length;
            {
                int i = 0;
                {
                    {
                        final int[] nonPressedState = new int[length - 1];
                        System.arraycopy(drawableState, 0, nonPressedState, 0, i);
                        System.arraycopy(drawableState, i + 1, nonPressedState, i, length - i - 1);
                    } 
                } 
            } 
        } 
        addTaint(extraSpace);
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_2111806130 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_2111806130;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.845 -0400", hash_original_method = "FA11BA597CA3990806012CD62CCA6F49", hash_generated_method = "43B018629F6527BCA776741101908884")
    @Override
    protected void onDraw(Canvas canvas) {
        
        {
            final ViewTreeObserver observer = getViewTreeObserver();
            observer.removeOnPreDrawListener(this);
            mPreDrawState = PREDRAW_NOT_REGISTERED;
        } 
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
        {
            int vspace = bottom - top - compoundPaddingBottom - compoundPaddingTop;
            int hspace = right - left - compoundPaddingRight - compoundPaddingLeft;
            {
                canvas.save();
                canvas.translate(scrollX + mPaddingLeft,
                                 scrollY + compoundPaddingTop +
                                 (vspace - dr.mDrawableHeightLeft) / 2);
                dr.mDrawableLeft.draw(canvas);
                canvas.restore();
            } 
            {
                canvas.save();
                canvas.translate(scrollX + right - left - mPaddingRight - dr.mDrawableSizeRight,
                         scrollY + compoundPaddingTop + (vspace - dr.mDrawableHeightRight) / 2);
                dr.mDrawableRight.draw(canvas);
                canvas.restore();
            } 
            {
                canvas.save();
                canvas.translate(scrollX + compoundPaddingLeft + (hspace - dr.mDrawableWidthTop) / 2,
                        scrollY + mPaddingTop);
                dr.mDrawableTop.draw(canvas);
                canvas.restore();
            } 
            {
                canvas.save();
                canvas.translate(scrollX + compoundPaddingLeft +
                        (hspace - dr.mDrawableWidthBottom) / 2,
                         scrollY + bottom - top - mPaddingBottom - dr.mDrawableSizeBottom);
                dr.mDrawableBottom.draw(canvas);
                canvas.restore();
            } 
        } 
        int color = mCurTextColor;
        {
            assumeLayout();
        } 
        Layout layout = mLayout;
        int cursorcolor = color;
        {
            boolean var316D35E2F5ECBA0973BB7AA3F3D5BB99_638412397 = (mHint != null && mText.length() == 0);
            {
                {
                    color = mCurHintTextColor;
                } 
                layout = mHintLayout;
            } 
        } 
        mTextPaint.setColor(color);
        {
            mTextPaint.setAlpha((mCurrentAlpha * Color.alpha(color)) / 255);
        } 
        mTextPaint.drawableState = getDrawableState();
        canvas.save();
        int extendedPaddingTop = getExtendedPaddingTop();
        int extendedPaddingBottom = getExtendedPaddingBottom();
        float clipLeft = compoundPaddingLeft + scrollX;
        float clipTop = extendedPaddingTop + scrollY;
        float clipRight = right - left - compoundPaddingRight + scrollX;
        float clipBottom = bottom - top - extendedPaddingBottom + scrollY;
        {
            clipLeft += Math.min(0, mShadowDx - mShadowRadius);
            clipRight += Math.max(0, mShadowDx + mShadowRadius);
            clipTop += Math.min(0, mShadowDy - mShadowRadius);
            clipBottom += Math.max(0, mShadowDy + mShadowRadius);
        } 
        canvas.clipRect(clipLeft, clipTop, clipRight, clipBottom);
        int voffsetText = 0;
        int voffsetCursor = 0;
        {
            {
                voffsetText = getVerticalOffset(false);
                voffsetCursor = getVerticalOffset(true);
            } 
            canvas.translate(compoundPaddingLeft, extendedPaddingTop + voffsetText);
        } 
        final int layoutDirection = getResolvedLayoutDirection();
        final int absoluteGravity = Gravity.getAbsoluteGravity(mGravity, layoutDirection);
        {
            {
                boolean varECABE171DF753EC9B7649613B9CE32E8_1036328642 = (!mSingleLine && getLineCount() == 1 && canMarquee() &&
                    (absoluteGravity & Gravity.HORIZONTAL_GRAVITY_MASK) != Gravity.LEFT);
                {
                    canvas.translate(mLayout.getLineRight(0) - (mRight - mLeft -
                        getCompoundPaddingLeft() - getCompoundPaddingRight()), 0.0f);
                } 
            } 
            {
                boolean var2C1AA9C80F2908423E5F4CFC350F7281_37337768 = (mMarquee != null && mMarquee.isRunning());
                {
                    canvas.translate(-mMarquee.mScroll, 0.0f);
                } 
            } 
        } 
        Path highlight = null;
        int selStart = -1;
        int selEnd = -1;
        boolean drawCursor = false;
        {
            boolean var6689D80642F8609001A87CC7FE23D763_466754463 = (mMovement != null && (isFocused() || isPressed()));
            {
                selStart = getSelectionStart();
                selEnd = getSelectionEnd();
                {
                    mHighlightPath = new Path();
                    {
                        {
                            boolean varC70ECF1643A49D8E64E841F8740CC733_1616151405 = (isCursorVisible() &&
                            (SystemClock.uptimeMillis() - mShowCursor) % (2 * BLINK) < BLINK);
                            {
                                {
                                    mHighlightPath.reset();
                                    mLayout.getCursorPath(selStart, mHighlightPath, mText);
                                    updateCursorsPositions();
                                    mHighlightPathBogus = false;
                                } 
                                mHighlightPaint.setColor(cursorcolor);
                                {
                                    mHighlightPaint.setAlpha(
                                    (mCurrentAlpha * Color.alpha(cursorcolor)) / 255);
                                } 
                                mHighlightPaint.setStyle(Paint.Style.STROKE);
                                highlight = mHighlightPath;
                                drawCursor = mCursorCount > 0;
                            } 
                        } 
                    } 
                    {
                        boolean varD2470F8649BF231BDB682780036CA3E1_1935859751 = (textCanBeSelected());
                        {
                            {
                                mHighlightPath.reset();
                                mLayout.getSelectionPath(selStart, selEnd, mHighlightPath);
                                mHighlightPathBogus = false;
                            } 
                            mHighlightPaint.setColor(mHighlightColor);
                            {
                                mHighlightPaint.setAlpha(
                                (mCurrentAlpha * Color.alpha(mHighlightColor)) / 255);
                            } 
                            mHighlightPaint.setStyle(Paint.Style.FILL);
                            highlight = mHighlightPath;
                        } 
                    } 
                } 
            } 
        } 
        final InputMethodState ims = mInputMethodState;
        final int cursorOffsetVertical = voffsetCursor - voffsetText;
        {
            InputMethodManager imm = InputMethodManager.peekInstance();
            {
                {
                    boolean varCD832678EBF561BEF5C67C864ED57D5D_955872918 = (imm.isActive(this));
                    {
                        boolean reported = false;
                        {
                            reported = reportExtractedText();
                        } 
                        {
                            int candStart = -1;
                            int candEnd = -1;
                            {
                                Spannable sp = (Spannable)mText;
                                candStart = EditableInputConnection.getComposingSpanStart(sp);
                                candEnd = EditableInputConnection.getComposingSpanEnd(sp);
                            } 
                            imm.updateSelection(this, selStart, selEnd, candStart, candEnd);
                        } 
                    } 
                } 
                {
                    boolean varDFBBC9A1B31B7114329F69A82B5D3704_1930932247 = (imm.isWatchingCursor(this) && highlight != null);
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
                    } 
                } 
            } 
        } 
        {
            mCorrectionHighlighter.draw(canvas, cursorOffsetVertical);
        } 
        {
            drawCursor(canvas, cursorOffsetVertical);
            highlight = null;
        } 
        layout.draw(canvas, highlight, mHighlightPaint, cursorOffsetVertical);
        {
            boolean var6C9C7A2601C4C103D29484E050BD6314_708269125 = (mMarquee != null && mMarquee.shouldDrawGhost());
            {
                canvas.translate((int) mMarquee.getGhostOffset(), 0.0f);
                layout.draw(canvas, highlight, mHighlightPaint, cursorOffsetVertical);
            } 
        } 
        canvas.restore();
        addTaint(canvas.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.846 -0400", hash_original_method = "78F759649DF9DADE7AC797D0043ECB32", hash_generated_method = "986540F442152AF60A8F8CF8EAE1330F")
    private void updateCursorsPositions() {
        {
            mCursorCount = 0;
        } 
        final int offset = getSelectionStart();
        final int line = mLayout.getLineForOffset(offset);
        final int top = mLayout.getLineTop(line);
        final int bottom = mLayout.getLineTop(line + 1);
        mCursorCount = mLayout.isLevelBoundary(offset) ? 2 : 1;
        int middle = bottom;
        {
            middle = (top + bottom) >> 1;
        } 
        updateCursorPosition(0, top, middle, mLayout.getPrimaryHorizontal(offset));
        {
            updateCursorPosition(1, middle, bottom, mLayout.getSecondaryHorizontal(offset));
        } 
        
        
            
            
        
        
        
        
        
        
        
        
            
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.847 -0400", hash_original_method = "E19C5E504E793D85568DEA288EC3BB71", hash_generated_method = "7821B6D9E0B6B938E26458DF1EA87052")
    private void updateCursorPosition(int cursorIndex, int top, int bottom, float horizontal) {
        mCursorDrawable[cursorIndex] = mContext.getResources().getDrawable(mCursorDrawableRes);
        mTempRect = new Rect();
        mCursorDrawable[cursorIndex].getPadding(mTempRect);
        final int width = mCursorDrawable[cursorIndex].getIntrinsicWidth();
        horizontal = Math.max(0.5f, horizontal - 0.5f);
        final int left = (int) (horizontal) - mTempRect.left;
        mCursorDrawable[cursorIndex].setBounds(left, top - mTempRect.top, left + width,
                bottom + mTempRect.bottom);
        addTaint(top);
        addTaint(bottom);
        addTaint(horizontal);
        
        
            
        
        
        
        
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.848 -0400", hash_original_method = "38A0E9FCBE0DF4E61FBA21D6958F939A", hash_generated_method = "7AA36DB1DB99E948EFFFD2CA99862C4C")
    private void drawCursor(Canvas canvas, int cursorOffsetVertical) {
        final boolean translate = cursorOffsetVertical != 0;
        canvas.translate(0, cursorOffsetVertical);
        {
            int i = 0;
            {
                mCursorDrawable[i].draw(canvas);
            } 
        } 
        canvas.translate(0, -cursorOffsetVertical);
        addTaint(canvas.getTaint());
        addTaint(cursorOffsetVertical);
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.849 -0400", hash_original_method = "9AB167D6C4B117BDFB6C2B72A1D862B5", hash_generated_method = "0215A9338E2A1A8FE557600B08ECA94F")
    @Override
    public void getFocusedRect(Rect r) {
        {
            super.getFocusedRect(r);
        } 
        int selEnd = getSelectionEnd();
        {
            super.getFocusedRect(r);
        } 
        int selStart = getSelectionStart();
        {
            int line = mLayout.getLineForOffset(selEnd);
            r.top = mLayout.getLineTop(line);
            r.bottom = mLayout.getLineBottom(line);
            r.left = (int) mLayout.getPrimaryHorizontal(selEnd) - 2;
            r.right = r.left + 4;
        } 
        {
            int lineStart = mLayout.getLineForOffset(selStart);
            int lineEnd = mLayout.getLineForOffset(selEnd);
            r.top = mLayout.getLineTop(lineStart);
            r.bottom = mLayout.getLineBottom(lineEnd);
            {
                r.left = (int) mLayout.getPrimaryHorizontal(selStart);
                r.right = (int) mLayout.getPrimaryHorizontal(selEnd);
            } 
            {
                mHighlightPath = new Path();
                {
                    mHighlightPath.reset();
                    mLayout.getSelectionPath(selStart, selEnd, mHighlightPath);
                    mHighlightPathBogus = false;
                } 
                {
                    mHighlightPath.computeBounds(sTempRect, true);
                    r.left = (int)sTempRect.left-1;
                    r.right = (int)sTempRect.right+1;
                } 
            } 
        } 
        int paddingLeft = getCompoundPaddingLeft();
        int paddingTop = getExtendedPaddingTop();
        {
            paddingTop += getVerticalOffset(false);
        } 
        r.offset(paddingLeft, paddingTop);
        addTaint(r.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.851 -0400", hash_original_method = "97BE8C8E19AAF13DDBB7397BA8716CD7", hash_generated_method = "256DCC92194517691E2DDDF5F4BA2A5D")
    public int getLineCount() {
        {
            Object varD975483664E4A2ABD3BE6A7FE00BEAE4_1577164224 = (mLayout.getLineCount());
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1101347013 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1101347013;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.851 -0400", hash_original_method = "C119BED798B9C2A141229B29A4C86BDD", hash_generated_method = "EA264B2A2E00DE3E08094AF394B902DC")
    public int getLineBounds(int line, Rect bounds) {
        {
            {
                bounds.set(0, 0, 0, 0);
            } 
        } 
        {
            int baseline = mLayout.getLineBounds(line, bounds);
            int voffset = getExtendedPaddingTop();
            {
                voffset += getVerticalOffset(true);
            } 
            {
                bounds.offset(getCompoundPaddingLeft(), voffset);
            } 
        } 
        addTaint(line);
        addTaint(bounds.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1429952016 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1429952016;
        
        
            
                
            
            
        
        
            
            
            
                
            
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.852 -0400", hash_original_method = "3C56831CF91C4818C48A7DCC6043867F", hash_generated_method = "E0508F2C3A89127A37A165AA666D68E9")
    @Override
    public int getBaseline() {
        {
            int varEC5F70FA49520212A319ACA653FC0209_1168566614 = (super.getBaseline());
        } 
        int voffset = 0;
        {
            voffset = getVerticalOffset(true);
        } 
        int varB40014DBFC3B8DB0A96D34443E0FBB7F_714085090 = (getExtendedPaddingTop() + voffset + mLayout.getLineBaseline(0));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1988410658 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1988410658;
        
        
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.853 -0400", hash_original_method = "9B40D92CA2D66C315619C6CA13460A4B", hash_generated_method = "83A6B2A4C0C6BBF7987FA73031623B18")
    @Override
    protected int getFadeTop(boolean offsetRequired) {
        int voffset = 0;
        {
            voffset = getVerticalOffset(true);
        } 
        voffset += getTopPaddingOffset();
        int var96B16999098121B80A3E9BC63992503B_325630184 = (getExtendedPaddingTop() + voffset);
        addTaint(offsetRequired);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_121525500 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_121525500;
        
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.853 -0400", hash_original_method = "4B4E36AF8D516BA2309E720A4535DE33", hash_generated_method = "48FD91AED8AEB597C9A51A49E903C6F0")
    @Override
    protected int getFadeHeight(boolean offsetRequired) {
        {
            Object var1822177AD24E1DAE2984AAF8E0B02DF5_1344644306 = (mLayout.getHeight());
        } 
        addTaint(offsetRequired);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_482870991 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_482870991;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.854 -0400", hash_original_method = "D780B8C0D740C935BBFD0FE1FAA345B5", hash_generated_method = "628BB83769D25D705236236E06FA1D8B")
    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        
        {
            boolean isInSelectionMode = mSelectionActionMode != null;
            {
                {
                    boolean var51947D54DEEA690F1B41A17DE6323711_1394684413 = (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0);
                    {
                        KeyEvent.DispatcherState state = getKeyDispatcherState();
                        {
                            state.startTracking(event, this);
                        } 
                    } 
                    {
                        boolean varA6D964A9D1A4D1D485BD8D60F2BFCDEE_104005150 = (event.getAction() == KeyEvent.ACTION_UP);
                        {
                            KeyEvent.DispatcherState state = getKeyDispatcherState();
                            {
                                state.handleUpEvent(event);
                            } 
                            {
                                boolean varBE09C907F92D135687297C67489D82A5_1606116483 = (event.isTracking() && !event.isCanceled());
                                {
                                    {
                                        stopSelectionActionMode();
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
        boolean var84A59BF21652B099F795A333EE25717D_1760338493 = (super.onKeyPreIme(keyCode, event));
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1503422338 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1503422338;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.854 -0400", hash_original_method = "34FB4F2A2A6D04958B0CB574357346B4", hash_generated_method = "87EBE54FF5E50EC57B33E2E2FB67270A")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        
        int which = doKeyDown(keyCode, event, null);
        {
            boolean varF37828D47239888646D0D534C127ED8C_146695944 = (super.onKeyDown(keyCode, event));
        } 
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1593915397 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1593915397;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.854 -0400", hash_original_method = "29E1D0F837CE3120BC9F0CF834D8CD7B", hash_generated_method = "40541023E51748CF5074B5F2270147AD")
    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        
        KeyEvent down = KeyEvent.changeAction(event, KeyEvent.ACTION_DOWN);
        int which = doKeyDown(keyCode, down, event);
        {
            boolean varDC1E2957B5A61BDC225D3800F9D03961_101612801 = (super.onKeyMultiple(keyCode, repeatCount, event));
        } 
        KeyEvent up = KeyEvent.changeAction(event, KeyEvent.ACTION_UP);
        {
            mInput.onKeyUp(this, (Editable)mText, keyCode, up);
            {
                mInput.onKeyDown(this, (Editable)mText, keyCode, down);
                mInput.onKeyUp(this, (Editable)mText, keyCode, up);
            } 
            hideErrorIfUnchanged();
        } 
        {
            mMovement.onKeyUp(this, (Spannable)mText, keyCode, up);
            {
                mMovement.onKeyDown(this, (Spannable)mText, keyCode, down);
                mMovement.onKeyUp(this, (Spannable)mText, keyCode, up);
            } 
        } 
        addTaint(keyCode);
        addTaint(repeatCount);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1532946531 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1532946531;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.855 -0400", hash_original_method = "F8A8C23B2901B68727EC4DCE05389523", hash_generated_method = "EDB7DC9400EF0C7EA7DC3F05DB5E80C4")
    private boolean shouldAdvanceFocusOnEnter() {
        {
            int variation = mInputType & EditorInfo.TYPE_MASK_VARIATION;
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1371047454 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1371047454;
        
        
            
        
        
            
        
        
            
            
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.855 -0400", hash_original_method = "3820039215BEB2B783682B0606CB8390", hash_generated_method = "EFA53605BF24FF05287A73A2B90615A9")
    private boolean shouldAdvanceFocusOnTab() {
        {
            {
                int variation = mInputType & EditorInfo.TYPE_MASK_VARIATION;
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1717227652 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1717227652;
        
        
            
                
                
                        
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.856 -0400", hash_original_method = "06C558A5D7DCBFD0B9ED82B9C331F1F3", hash_generated_method = "1FEC3C8682F722270A17B16DD1D1A09C")
    private int doKeyDown(int keyCode, KeyEvent event, KeyEvent otherEvent) {
        {
            boolean varC378F7D9F83769944CF2ACC662A4EAE3_821817356 = (!isEnabled());
        } 
        
        {
            boolean var6A2352E2C5239DCC8C3CFCEB22E8E32E_1226757667 = (event.hasNoModifiers());
            {
                {
                    {
                        boolean var1D94CC9EA7F6DC2AEFBF8FBA8E934A5F_159281638 = (mInputContentType.onEditorActionListener != null &&
                                mInputContentType.onEditorActionListener.onEditorAction(
                                this, EditorInfo.IME_NULL, event));
                        {
                            mInputContentType.enterDown = true;
                        } 
                    } 
                } 
                {
                    boolean var05FC5A78E345546917334D934F323222_943092242 = ((event.getFlags() & KeyEvent.FLAG_EDITOR_ACTION) != 0
                            || shouldAdvanceFocusOnEnter());
                    {
                        {
                            boolean var272B07794F8FB9CA178BF9284513CEF1_526668697 = (hasOnClickListeners());
                        } 
                    } 
                } 
            } 
        } 
        
        
        {
            boolean var6A2352E2C5239DCC8C3CFCEB22E8E32E_325893416 = (event.hasNoModifiers());
            {
                {
                    boolean varB57504F668DBD47828E53D1AA62D2476_2093047953 = (shouldAdvanceFocusOnEnter());
                } 
            } 
        } 
        
        
        {
            boolean var41B4248114FD3FFF5603132EE2379F75_100842076 = (event.hasNoModifiers() || event.hasModifiers(KeyEvent.META_SHIFT_ON));
            {
                {
                    boolean var4CB07B26821EBD1E83E544AE45714F5A_1519882874 = (shouldAdvanceFocusOnTab());
                } 
            } 
        } 
        
        
        {
            stopSelectionActionMode();
        } 
        
        {
            resetErrorChangedFlag();
            boolean doDown = true;
            {
                try 
                {
                    beginBatchEdit();
                    final boolean handled = mInput.onKeyOther(this, (Editable) mText, otherEvent);
                    hideErrorIfUnchanged();
                    doDown = false;
                } 
                catch (AbstractMethodError e)
                { }
                finally 
                {
                    endBatchEdit();
                } 
            } 
            {
                beginBatchEdit();
                final boolean handled = mInput.onKeyDown(this, (Editable) mText, keyCode, event);
                endBatchEdit();
                hideErrorIfUnchanged();
            } 
        } 
        {
            boolean doDown = true;
            {
                try 
                {
                    boolean handled = mMovement.onKeyOther(this, (Spannable) mText,
                            otherEvent);
                    doDown = false;
                } 
                catch (AbstractMethodError e)
                { }
            } 
            {
                {
                    boolean var899D769AE8C1CEA63FDF2F946CDD9B0C_1903395083 = (mMovement.onKeyDown(this, (Spannable)mText, keyCode, event));
                } 
            } 
        } 
        addTaint(keyCode);
        addTaint(event.getTaint());
        addTaint(otherEvent.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1604816654 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1604816654;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.856 -0400", hash_original_method = "7246AB9167FB26EEC2DE7F4C0B385BF5", hash_generated_method = "942D510B431E2EA8FDD86A5C3DFCBA19")
    public void resetErrorChangedFlag() {
        mErrorWasChanged = false;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.857 -0400", hash_original_method = "0D0DD73869C4F453DDB81949A9BAE239", hash_generated_method = "3E2A8FC9925589DC311AEF9DD7F3D897")
    public void hideErrorIfUnchanged() {
        {
            setError(null, null);
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.858 -0400", hash_original_method = "5424E0BE647EA73439DA25EAE2FC3B50", hash_generated_method = "A0B2A6A60FAD690FB2D41529596E9C8C")
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        
        {
            boolean varC378F7D9F83769944CF2ACC662A4EAE3_38867289 = (!isEnabled());
            {
                boolean var22F2FED66C108E4B3C1571CD2DEF9BD7_1240969206 = (super.onKeyUp(keyCode, event));
            } 
        } 
        
        {
            boolean var6A2352E2C5239DCC8C3CFCEB22E8E32E_825471950 = (event.hasNoModifiers());
            {
                {
                    boolean var210C7F5CA56C3EC36E879FBFEDD09928_932325488 = (!hasOnClickListeners());
                    {
                        {
                            boolean varE74AE2A246DD26B137F541368B4BE791_998999422 = (mMovement != null && mText instanceof Editable
                                && mLayout != null && onCheckIsTextEditor());
                            {
                                InputMethodManager imm = InputMethodManager.peekInstance();
                                viewClicked(imm);
                                {
                                    imm.showSoftInput(this, 0);
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
        
        
        boolean varEDD771EBF66425AD21882AB08CD0EE48_2027748398 = (super.onKeyUp(keyCode, event));
        
        
        {
            boolean var6A2352E2C5239DCC8C3CFCEB22E8E32E_726321342 = (event.hasNoModifiers());
            {
                {
                    mInputContentType.enterDown = false;
                    {
                        boolean varFB4D8364BD486E8AC15C78086C055D0E_1554539342 = (mInputContentType.onEditorActionListener.onEditorAction(
                                this, EditorInfo.IME_NULL, event));
                    } 
                } 
                {
                    boolean var05FC5A78E345546917334D934F323222_583802804 = ((event.getFlags() & KeyEvent.FLAG_EDITOR_ACTION) != 0
                            || shouldAdvanceFocusOnEnter());
                    {
                        {
                            boolean varEDA239B0EF60ED2C8B069E42FB575E6D_1990539132 = (!hasOnClickListeners());
                            {
                                View v = focusSearch(FOCUS_DOWN);
                                {
                                    {
                                        boolean varB999DF15E9AF0E3270EE4B72A3F644C2_653388270 = (!v.requestFocus(FOCUS_DOWN));
                                        {
                                            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                                            "focus search returned a view " +
                                            "that wasn't able to take focus!");
                                        } 
                                    } 
                                    super.onKeyUp(keyCode, event);
                                } 
                                {
                                    boolean var28FD9F71D61E7F2DAF140411AD18D69B_1936994452 = ((event.getFlags()
                                    & KeyEvent.FLAG_EDITOR_ACTION) != 0);
                                    {
                                        InputMethodManager imm = InputMethodManager.peekInstance();
                                        {
                                            boolean var18AFA631B94FB215076105938165749C_73139429 = (imm != null && imm.isActive(this));
                                            {
                                                imm.hideSoftInputFromWindow(getWindowToken(), 0);
                                            } 
                                        } 
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
                boolean var22F2FED66C108E4B3C1571CD2DEF9BD7_954042613 = (super.onKeyUp(keyCode, event));
            } 
        } 
        
        {
            boolean var952AD4616936F2C47880365DAADE02E9_473469248 = (mInput.onKeyUp(this, (Editable) mText, keyCode, event));
        } 
        {
            boolean varDA972FE6CE2955659F74CF0FCCBDD027_1033536408 = (mMovement.onKeyUp(this, (Spannable) mText, keyCode, event));
        } 
        boolean varEDD771EBF66425AD21882AB08CD0EE48_1569547135 = (super.onKeyUp(keyCode, event));
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_799445319 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_799445319;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.858 -0400", hash_original_method = "71F7C8422E0B6AB59261F7E112139F7A", hash_generated_method = "13EF467FC87438F7F787AE25D4FB1D65")
    @Override
    public boolean onCheckIsTextEditor() {
        
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_428680113 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_428680113;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.861 -0400", hash_original_method = "B65AC544FAB392A4E417298C2021FD9E", hash_generated_method = "C192CF938BC224845E304090111D2A0F")
    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        
        InputConnection varB4EAC82CA7396A68D541C85D26508E83_2008578197 = null; 
        InputConnection varB4EAC82CA7396A68D541C85D26508E83_822491744 = null; 
        {
            boolean var14E748864EBD1D56528D6630F011C9F4_977522113 = (onCheckIsTextEditor() && isEnabled());
            {
                {
                    mInputMethodState = new InputMethodState();
                } 
                outAttrs.inputType = mInputType;
                {
                    outAttrs.imeOptions = mInputContentType.imeOptions;
                    outAttrs.privateImeOptions = mInputContentType.privateImeOptions;
                    outAttrs.actionLabel = mInputContentType.imeActionLabel;
                    outAttrs.actionId = mInputContentType.imeActionId;
                    outAttrs.extras = mInputContentType.extras;
                } 
                {
                    outAttrs.imeOptions = EditorInfo.IME_NULL;
                } 
                {
                    boolean var4A83C13B10866AEA8D3AB0257DD13346_383739270 = (focusSearch(FOCUS_DOWN) != null);
                    {
                        outAttrs.imeOptions |= EditorInfo.IME_FLAG_NAVIGATE_NEXT;
                    } 
                } 
                {
                    boolean varD336D5944BC7007368BBB4D990F0F8EA_1603818865 = (focusSearch(FOCUS_UP) != null);
                    {
                        outAttrs.imeOptions |= EditorInfo.IME_FLAG_NAVIGATE_PREVIOUS;
                    } 
                } 
                {
                    {
                        outAttrs.imeOptions |= EditorInfo.IME_ACTION_NEXT;
                    } 
                    {
                        outAttrs.imeOptions |= EditorInfo.IME_ACTION_DONE;
                    } 
                    {
                        boolean var46380488EEE32CF6F78CFB4D43E28058_1914585061 = (!shouldAdvanceFocusOnEnter());
                        {
                            outAttrs.imeOptions |= EditorInfo.IME_FLAG_NO_ENTER_ACTION;
                        } 
                    } 
                } 
                {
                    boolean var6CF4D9D9DC3252829459B4AC99D1E1CE_527645052 = (isMultilineInputType(outAttrs.inputType));
                    {
                        outAttrs.imeOptions |= EditorInfo.IME_FLAG_NO_ENTER_ACTION;
                    } 
                } 
                outAttrs.hintText = mHint;
                {
                    InputConnection ic = new EditableInputConnection(this);
                    outAttrs.initialSelStart = getSelectionStart();
                    outAttrs.initialSelEnd = getSelectionEnd();
                    outAttrs.initialCapsMode = ic.getCursorCapsMode(mInputType);
                    varB4EAC82CA7396A68D541C85D26508E83_2008578197 = ic;
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_822491744 = null;
        addTaint(outAttrs.getTaint());
        InputConnection varA7E53CE21691AB073D9660D615818899_1314541430; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1314541430 = varB4EAC82CA7396A68D541C85D26508E83_2008578197;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1314541430 = varB4EAC82CA7396A68D541C85D26508E83_822491744;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1314541430.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1314541430;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.862 -0400", hash_original_method = "99984EBDDEABE6A84A830C32C2411508", hash_generated_method = "9C7D988A1BD836A78391E07101096A6E")
    public boolean extractText(ExtractedTextRequest request,
            ExtractedText outText) {
        boolean varED261EE6A1DA9340DC710F511F735890_523173580 = (extractTextInternal(request, EXTRACT_UNKNOWN, EXTRACT_UNKNOWN,
                EXTRACT_UNKNOWN, outText));
        addTaint(request.getTaint());
        addTaint(outText.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1906695223 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1906695223;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.864 -0400", hash_original_method = "D5583180449515B28719DEEF8D226179", hash_generated_method = "6EF2E45A38AAB611C1E35851D8707229")
     boolean extractTextInternal(ExtractedTextRequest request,
            int partialStartOffset, int partialEndOffset, int delta,
            ExtractedText outText) {
        final CharSequence content = mText;
        {
            {
                final int N = content.length();
                {
                    outText.partialStartOffset = outText.partialEndOffset = -1;
                    partialStartOffset = 0;
                    partialEndOffset = N;
                } 
                {
                    partialEndOffset += delta;
                    {
                        Spanned spanned = (Spanned)content;
                        Object[] spans = spanned.getSpans(partialStartOffset,
                                partialEndOffset, ParcelableSpan.class);
                        int i = spans.length;
                        {
                            int j = spanned.getSpanStart(spans[i]);
                            partialStartOffset = j;
                            j = spanned.getSpanEnd(spans[i]);
                            partialEndOffset = j;
                        } 
                    } 
                    outText.partialStartOffset = partialStartOffset;
                    outText.partialEndOffset = partialEndOffset - delta;
                    {
                        partialStartOffset = N;
                    } 
                    {
                        partialStartOffset = 0;
                    } 
                    {
                        partialEndOffset = N;
                    } 
                    {
                        partialEndOffset = 0;
                    } 
                } 
                {
                    outText.text = content.subSequence(partialStartOffset,
                            partialEndOffset);
                } 
                {
                    outText.text = TextUtils.substring(content, partialStartOffset,
                            partialEndOffset);
                } 
            } 
            {
                outText.partialStartOffset = 0;
                outText.partialEndOffset = 0;
                outText.text = "";
            } 
            outText.flags = 0;
            {
                boolean varA35D3A020D07691CB25122C024188410_287669659 = (MetaKeyKeyListener.getMetaState(mText, MetaKeyKeyListener.META_SELECTING) != 0);
                {
                    outText.flags |= ExtractedText.FLAG_SELECTING;
                } 
            } 
            {
                outText.flags |= ExtractedText.FLAG_SINGLE_LINE;
            } 
            outText.startOffset = 0;
            outText.selectionStart = getSelectionStart();
            outText.selectionEnd = getSelectionEnd();
        } 
        addTaint(request.getTaint());
        addTaint(partialStartOffset);
        addTaint(partialEndOffset);
        addTaint(delta);
        addTaint(outText.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_938523536 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_938523536;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.865 -0400", hash_original_method = "E0B2F563BD380D089394FF3F6A004FAB", hash_generated_method = "6AA74C23673778DD07AC379BF73B7134")
     boolean reportExtractedText() {
        final InputMethodState ims = mInputMethodState;
        {
            final boolean contentChanged = ims.mContentChanged;
            {
                ims.mContentChanged = false;
                ims.mSelectionModeChanged = false;
                final ExtractedTextRequest req = mInputMethodState.mExtracting;
                {
                    InputMethodManager imm = InputMethodManager.peekInstance();
                    {
                        {
                            ims.mChangedStart = EXTRACT_NOTHING;
                        } 
                        {
                            boolean varF32A83F45BD97D2740B78BFB41050619_758706828 = (extractTextInternal(req, ims.mChangedStart, ims.mChangedEnd,
                                ims.mChangedDelta, ims.mTmpExtracted));
                            {
                                imm.updateExtractedText(this, req.token,
                                    mInputMethodState.mTmpExtracted);
                                ims.mChangedStart = EXTRACT_UNKNOWN;
                                ims.mChangedEnd = EXTRACT_UNKNOWN;
                                ims.mChangedDelta = 0;
                                ims.mContentChanged = false;
                            } 
                        } 
                    } 
                } 
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1046438055 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1046438055;
        
        
    }

    
        static void removeParcelableSpans(Spannable spannable, int start, int end) {
        Object[] spans = spannable.getSpans(start, end, ParcelableSpan.class);
        int i = spans.length;
        while (i > 0) {
            i--;
            spannable.removeSpan(spans[i]);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.866 -0400", hash_original_method = "BCA6F941081EC35E5D75ECC5825A5773", hash_generated_method = "D1FA250C221258340E9CC628153DF995")
    public void setExtractedText(ExtractedText text) {
        Editable content = getEditableText();
        {
            {
                setText(text.text, TextView.BufferType.EDITABLE);
            } 
            {
                removeParcelableSpans(content, 0, content.length());
                content.replace(0, content.length(), text.text);
            } 
            {
                final int N = content.length();
                int start = text.partialStartOffset;
                start = N;
                int end = text.partialEndOffset;
                end = N;
                removeParcelableSpans(content, start, end);
                content.replace(start, end, text.text);
            } 
        } 
        Spannable sp = (Spannable)getText();
        final int N = sp.length();
        int start = text.selectionStart;
        start = 0;
        start = N;
        int end = text.selectionEnd;
        end = 0;
        end = N;
        Selection.setSelection(sp, start, end);
        {
            MetaKeyKeyListener.startSelecting(this, sp);
        } 
        {
            MetaKeyKeyListener.stopSelecting(this, sp);
        } 
        addTaint(text.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.866 -0400", hash_original_method = "7277A5A8CCC47DEA1B4CD7EF17ABC767", hash_generated_method = "001BA83404B601B50C360F21753C280D")
    public void setExtracting(ExtractedTextRequest req) {
        {
            mInputMethodState.mExtracting = req;
        } 
        hideControllers();
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.866 -0400", hash_original_method = "00B2156ECAED706F16E8F8EE554C74A0", hash_generated_method = "3BEC66028E7D4A026DFA204DCCC868C4")
    public void onCommitCompletion(CompletionInfo text) {
        
        addTaint(text.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.867 -0400", hash_original_method = "F0F3377304175B47C81480C4E8ACCA98", hash_generated_method = "6E98934F145CEAE563A6ADFAF440E386")
    public void onCommitCorrection(CorrectionInfo info) {
        
        {
            mCorrectionHighlighter = new CorrectionHighlighter();
        } 
        {
            mCorrectionHighlighter.invalidate(false);
        } 
        mCorrectionHighlighter.highlight(info);
        addTaint(info.getTaint());
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.867 -0400", hash_original_method = "7E84F411EBAFCA8676D2B5471CC899F7", hash_generated_method = "E420B5396B645897A346D46C96ADB3A3")
    public void beginBatchEdit() {
        mInBatchEditControllers = true;
        final InputMethodState ims = mInputMethodState;
        {
            int nesting = ++ims.mBatchEditNesting;
            {
                ims.mCursorChanged = false;
                ims.mChangedDelta = 0;
                {
                    ims.mChangedStart = 0;
                    ims.mChangedEnd = mText.length();
                } 
                {
                    ims.mChangedStart = EXTRACT_UNKNOWN;
                    ims.mChangedEnd = EXTRACT_UNKNOWN;
                    ims.mContentChanged = false;
                } 
                onBeginBatchEdit();
            } 
        } 
        
        
        
        
            
            
                
                
                
                    
                    
                
                    
                    
                    
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.868 -0400", hash_original_method = "53E9CEBDC3778C58F6F63CD77BA92C78", hash_generated_method = "64C3C6EDB49807D2572B7AC574732723")
    public void endBatchEdit() {
        mInBatchEditControllers = false;
        final InputMethodState ims = mInputMethodState;
        {
            int nesting = --ims.mBatchEditNesting;
            {
                finishBatchEdit(ims);
            } 
        } 
        
        
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.868 -0400", hash_original_method = "49FC9F53534FDBC4416EED2F953235D5", hash_generated_method = "A24DDE2C02A7E2ABEEA52CAAD0C73F87")
     void ensureEndedBatchEdit() {
        final InputMethodState ims = mInputMethodState;
        {
            ims.mBatchEditNesting = 0;
            finishBatchEdit(ims);
        } 
        
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.869 -0400", hash_original_method = "5C56AEFFFAF99A5A2B83332AB2B67F77", hash_generated_method = "C7FDB63B58D41035DAC0F3FC01E908BE")
     void finishBatchEdit(final InputMethodState ims) {
        onEndBatchEdit();
        {
            updateAfterEdit();
            reportExtractedText();
        } 
        {
            invalidateCursor();
        } 
        addTaint(ims.getTaint());
        
        
        
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.869 -0400", hash_original_method = "208D05A3FD324C57DA7FED31CDB936F2", hash_generated_method = "D6F5B19778D3696F0DC49A045D7EDC7C")
     void updateAfterEdit() {
        invalidate();
        int curs = getSelectionStart();
        {
            registerForPreDraw();
        } 
        {
            mHighlightPathBogus = true;
            makeBlink();
            bringPointIntoView(curs);
        } 
        checkForResize();
        
        
        
        
            
        
        
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.869 -0400", hash_original_method = "77FDC1BC2641DD2E3C25361410AF5DB0", hash_generated_method = "BC5277DD7D56968D2F4723F142BD5C12")
    public void onBeginBatchEdit() {
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.870 -0400", hash_original_method = "52249F36F9A17EF1D72281B7699502C1", hash_generated_method = "47AA9BDFFBC119BCE27C341493B00781")
    public void onEndBatchEdit() {
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.870 -0400", hash_original_method = "4EBA5E538796A46420814B4C84FDA4F7", hash_generated_method = "845637231797048248C7AD78C063F76D")
    public boolean onPrivateIMECommand(String action, Bundle data) {
        
        addTaint(action.getTaint());
        addTaint(data.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_393724764 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_393724764;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.871 -0400", hash_original_method = "4BBE7444811911981578CD1FC44D7898", hash_generated_method = "C2DFA03E13DDE7509D862426BF7710F7")
    private void nullLayouts() {
        {
            mSavedLayout = (BoringLayout) mLayout;
        } 
        {
            mSavedHintLayout = (BoringLayout) mHintLayout;
        } 
        mSavedMarqueeModeLayout = mLayout = mHintLayout = null;
        prepareCursorControllers();
        
        
            
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.872 -0400", hash_original_method = "DE76D8533357DD76552FFACD362B9B5D", hash_generated_method = "94595602AD63D64328F0023DA99C5F89")
    private void assumeLayout() {
        int width = mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight();
        {
            width = 0;
        } 
        int physicalWidth = width;
        {
            width = VERY_WIDE;
        } 
        makeNewLayout(width, physicalWidth, UNKNOWN_BORING, UNKNOWN_BORING,
                      physicalWidth, false);
        
        
        
            
        
        
        
            
        
        
                      
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.872 -0400", hash_original_method = "FF379A6CAE0485B60E59F45E1B8A7246", hash_generated_method = "8899D16BAE890A74AD65848A0AADAC0E")
    @Override
    protected void resetResolvedLayoutDirection() {
        super.resetResolvedLayoutDirection();
        {
            mLayoutAlignment = null;
        } 
        
        
        
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.873 -0400", hash_original_method = "C784F6D37EB77044D77D743FABD50125", hash_generated_method = "0DB98CD1DAD1BA434195FBB494CDE9CC")
    private Layout.Alignment getLayoutAlignment() {
        Layout.Alignment varB4EAC82CA7396A68D541C85D26508E83_621640795 = null; 
        {
            Layout.Alignment alignment;
            TextAlign textAlign = mTextAlign;
            
            
            alignment = Layout.Alignment.ALIGN_NORMAL;
            
            
            alignment = Layout.Alignment.ALIGN_OPPOSITE;
            
            
            alignment = Layout.Alignment.ALIGN_LEFT;
            
            
            alignment = Layout.Alignment.ALIGN_RIGHT;
            
            
            alignment = Layout.Alignment.ALIGN_CENTER;
            
            
            alignment = Layout.Alignment.ALIGN_NORMAL;
            
            
            
            alignment = Layout.Alignment.ALIGN_NORMAL;
            
            
            alignment = Layout.Alignment.ALIGN_OPPOSITE;
            
            
            alignment = Layout.Alignment.ALIGN_CENTER;
            
            
            alignment = (getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL) ?
                            Layout.Alignment.ALIGN_RIGHT : Layout.Alignment.ALIGN_LEFT;
            
            
            alignment = (getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL) ?
                            Layout.Alignment.ALIGN_LEFT : Layout.Alignment.ALIGN_RIGHT;
            
            
            alignment = Layout.Alignment.ALIGN_NORMAL;
            
            mLayoutAlignment = alignment;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_621640795 = mLayoutAlignment;
        varB4EAC82CA7396A68D541C85D26508E83_621640795.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_621640795;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.875 -0400", hash_original_method = "A69555D5DBD727E4B4531FE7AB9727A4", hash_generated_method = "F11C67C1F7EE48B5F2E63F6A9AC6FA1F")
    protected void makeNewLayout(int wantWidth, int hintWidth,
                                 BoringLayout.Metrics boring,
                                 BoringLayout.Metrics hintBoring,
                                 int ellipsisWidth, boolean bringIntoView) {
        stopMarquee();
        mOldMaximum = mMaximum;
        mOldMaxMode = mMaxMode;
        mHighlightPathBogus = true;
        {
            wantWidth = 0;
        } 
        {
            hintWidth = 0;
        } 
        Layout.Alignment alignment = getLayoutAlignment();
        boolean shouldEllipsize = mEllipsize != null && mInput == null;
        final boolean switchEllipsize = mEllipsize == TruncateAt.MARQUEE &&
                mMarqueeFadeMode != MARQUEE_FADE_NORMAL;
        TruncateAt effectiveEllipsize = mEllipsize;
        {
            effectiveEllipsize = TruncateAt.END_SMALL;
        } 
        {
            resolveTextDirection();
        } 
        mLayout = makeSingleLayout(wantWidth, boring, ellipsisWidth, alignment, shouldEllipsize,
                effectiveEllipsize, effectiveEllipsize == mEllipsize);
        {
            TruncateAt oppositeEllipsize;
            oppositeEllipsize = TruncateAt.END;
            oppositeEllipsize = TruncateAt.MARQUEE;
            mSavedMarqueeModeLayout = makeSingleLayout(wantWidth, boring, ellipsisWidth, alignment,
                    shouldEllipsize, oppositeEllipsize, effectiveEllipsize != mEllipsize);
        } 
        shouldEllipsize = mEllipsize != null;
        mHintLayout = null;
        {
            hintWidth = wantWidth;
            {
                hintBoring = BoringLayout.isBoring(mHint, mTextPaint, mTextDir,
                                                   mHintBoring);
                {
                    mHintBoring = hintBoring;
                } 
            } 
            {
                {
                    {
                        mHintLayout = mSavedHintLayout.
                                replaceOrMake(mHint, mTextPaint,
                                hintWidth, alignment, mSpacingMult, mSpacingAdd,
                                hintBoring, mIncludePad);
                    } 
                    {
                        mHintLayout = BoringLayout.make(mHint, mTextPaint,
                                hintWidth, alignment, mSpacingMult, mSpacingAdd,
                                hintBoring, mIncludePad);
                    } 
                    mSavedHintLayout = (BoringLayout) mHintLayout;
                } 
                {
                    {
                        mHintLayout = mSavedHintLayout.
                                replaceOrMake(mHint, mTextPaint,
                                hintWidth, alignment, mSpacingMult, mSpacingAdd,
                                hintBoring, mIncludePad, mEllipsize,
                                ellipsisWidth);
                    } 
                    {
                        mHintLayout = BoringLayout.make(mHint, mTextPaint,
                                hintWidth, alignment, mSpacingMult, mSpacingAdd,
                                hintBoring, mIncludePad, mEllipsize,
                                ellipsisWidth);
                    } 
                } 
                {
                    mHintLayout = new StaticLayout(mHint,
                                0, mHint.length(),
                                mTextPaint, hintWidth, alignment, mTextDir, mSpacingMult,
                                mSpacingAdd, mIncludePad, mEllipsize,
                                ellipsisWidth, mMaxMode == LINES ? mMaximum : Integer.MAX_VALUE);
                } 
                {
                    mHintLayout = new StaticLayout(mHint, mTextPaint,
                            hintWidth, alignment, mTextDir, mSpacingMult, mSpacingAdd,
                            mIncludePad);
                } 
            } 
            {
                mHintLayout = new StaticLayout(mHint,
                            0, mHint.length(),
                            mTextPaint, hintWidth, alignment, mTextDir, mSpacingMult,
                            mSpacingAdd, mIncludePad, mEllipsize,
                            ellipsisWidth, mMaxMode == LINES ? mMaximum : Integer.MAX_VALUE);
            } 
            {
                mHintLayout = new StaticLayout(mHint, mTextPaint,
                        hintWidth, alignment, mTextDir, mSpacingMult, mSpacingAdd,
                        mIncludePad);
            } 
        } 
        {
            registerForPreDraw();
        } 
        {
            {
                boolean var74FA680CFF3550946DD695F927344B4C_1311400318 = (!compressText(ellipsisWidth));
                {
                    final int height = mLayoutParams.height;
                    {
                        startMarquee();
                    } 
                    {
                        mRestartMarquee = true;
                    } 
                } 
            } 
        } 
        prepareCursorControllers();
        addTaint(bringIntoView);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.877 -0400", hash_original_method = "919E80CF27514D43AA0D66AD56F3C47B", hash_generated_method = "A345655B664269A291325E46E7CC5A83")
    private Layout makeSingleLayout(int wantWidth, BoringLayout.Metrics boring, int ellipsisWidth,
            Layout.Alignment alignment, boolean shouldEllipsize, TruncateAt effectiveEllipsize,
            boolean useSaved) {
        Layout varB4EAC82CA7396A68D541C85D26508E83_1066738109 = null; 
        Layout result = null;
        {
            result = new DynamicLayout(mText, mTransformed, mTextPaint, wantWidth,
                    alignment, mTextDir, mSpacingMult,
                    mSpacingAdd, mIncludePad, mInput == null ? effectiveEllipsize : null,
                            ellipsisWidth);
        } 
        {
            {
                boring = BoringLayout.isBoring(mTransformed, mTextPaint, mTextDir, mBoring);
                {
                    mBoring = boring;
                } 
            } 
            {
                {
                    {
                        result = mSavedLayout.replaceOrMake(mTransformed, mTextPaint,
                                wantWidth, alignment, mSpacingMult, mSpacingAdd,
                                boring, mIncludePad);
                    } 
                    {
                        result = BoringLayout.make(mTransformed, mTextPaint,
                                wantWidth, alignment, mSpacingMult, mSpacingAdd,
                                boring, mIncludePad);
                    } 
                    {
                        mSavedLayout = (BoringLayout) result;
                    } 
                } 
                {
                    {
                        result = mSavedLayout.replaceOrMake(mTransformed, mTextPaint,
                                wantWidth, alignment, mSpacingMult, mSpacingAdd,
                                boring, mIncludePad, effectiveEllipsize,
                                ellipsisWidth);
                    } 
                    {
                        result = BoringLayout.make(mTransformed, mTextPaint,
                                wantWidth, alignment, mSpacingMult, mSpacingAdd,
                                boring, mIncludePad, effectiveEllipsize,
                                ellipsisWidth);
                    } 
                } 
                {
                    result = new StaticLayout(mTransformed,
                            0, mTransformed.length(),
                            mTextPaint, wantWidth, alignment, mTextDir, mSpacingMult,
                            mSpacingAdd, mIncludePad, effectiveEllipsize,
                            ellipsisWidth, mMaxMode == LINES ? mMaximum : Integer.MAX_VALUE);
                } 
                {
                    result = new StaticLayout(mTransformed, mTextPaint,
                            wantWidth, alignment, mTextDir, mSpacingMult, mSpacingAdd,
                            mIncludePad);
                } 
            } 
            {
                result = new StaticLayout(mTransformed,
                        0, mTransformed.length(),
                        mTextPaint, wantWidth, alignment, mTextDir, mSpacingMult,
                        mSpacingAdd, mIncludePad, effectiveEllipsize,
                        ellipsisWidth, mMaxMode == LINES ? mMaximum : Integer.MAX_VALUE);
            } 
            {
                result = new StaticLayout(mTransformed, mTextPaint,
                        wantWidth, alignment, mTextDir, mSpacingMult, mSpacingAdd,
                        mIncludePad);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1066738109 = result;
        addTaint(wantWidth);
        addTaint(ellipsisWidth);
        addTaint(alignment.getTaint());
        addTaint(shouldEllipsize);
        addTaint(effectiveEllipsize.getTaint());
        addTaint(useSaved);
        varB4EAC82CA7396A68D541C85D26508E83_1066738109.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1066738109;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.878 -0400", hash_original_method = "F38DBB61FA92C8376A0BF0DADC8F1411", hash_generated_method = "CD1B53D794C7EF67AC8E0F6E9142C8B3")
    private boolean compressText(float width) {
        {
            boolean varBDA84146B1D9E3F7F12351B38C986FB8_250051123 = (isHardwareAccelerated());
        } 
        {
            boolean var743F2FC0D45BA571C6484FE1669492A0_1509211586 = (width > 0.0f && mLayout != null && getLineCount() == 1 && !mUserSetTextScaleX &&
                mTextPaint.getTextScaleX() == 1.0f);
            {
                final float textWidth = mLayout.getLineWidth(0);
                final float overflow = (textWidth + 1.0f - width) / width;
                {
                    mTextPaint.setTextScaleX(1.0f - overflow - 0.005f);
                    post(new Runnable() {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.877 -0400", hash_original_method = "13996B392673F4526875359F0F526DB3", hash_generated_method = "221C03470D8DDA191DC873FAC4B9A060")
                        public void run() {
                            requestLayout();
                            
                            
                        }
});
                } 
            } 
        } 
        addTaint(width);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_869138995 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_869138995;
        
        
        
                
            
            
            
                
                
                    
                        
                    
                
                
            
        
        
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.879 -0400", hash_original_method = "6C6FEB869E07EC14B89A3785CB4B2378", hash_generated_method = "BDAA1A5309424E69B253253E093AC007")
    public void setIncludeFontPadding(boolean includepad) {
        {
            mIncludePad = includepad;
            {
                nullLayouts();
                requestLayout();
                invalidate();
            } 
        } 
        
        
            
            
                
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.881 -0400", hash_original_method = "CC856997CB919A81C5DE847B897CC56B", hash_generated_method = "2676F0B3BEC041C1F66C41432EFDB0CC")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int width;
        int height;
        BoringLayout.Metrics boring = UNKNOWN_BORING;
        BoringLayout.Metrics hintBoring = UNKNOWN_BORING;
        {
            resolveTextDirection();
        } 
        int des = -1;
        boolean fromexisting = false;
        {
            width = widthSize;
        } 
        {
            {
                des = desired(mLayout);
            } 
            {
                boring = BoringLayout.isBoring(mTransformed, mTextPaint, mTextDir, mBoring);
                {
                    mBoring = boring;
                } 
            } 
            {
                fromexisting = true;
            } 
            {
                {
                    des = (int) FloatMath.ceil(Layout.getDesiredWidth(mTransformed, mTextPaint));
                } 
                width = des;
            } 
            {
                width = boring.width;
            } 
            final Drawables dr = mDrawables;
            {
                width = Math.max(width, dr.mDrawableWidthTop);
                width = Math.max(width, dr.mDrawableWidthBottom);
            } 
            {
                int hintDes = -1;
                int hintWidth;
                {
                    hintDes = desired(mHintLayout);
                } 
                {
                    hintBoring = BoringLayout.isBoring(mHint, mTextPaint, mHintBoring);
                    {
                        mHintBoring = hintBoring;
                    } 
                } 
                {
                    {
                        hintDes = (int) FloatMath.ceil(
                                Layout.getDesiredWidth(mHint, mTextPaint));
                    } 
                    hintWidth = hintDes;
                } 
                {
                    hintWidth = hintBoring.width;
                } 
                {
                    width = hintWidth;
                } 
            } 
            width += getCompoundPaddingLeft() + getCompoundPaddingRight();
            {
                width = Math.min(width, mMaxWidth * getLineHeight());
            } 
            {
                width = Math.min(width, mMaxWidth);
            } 
            {
                width = Math.max(width, mMinWidth * getLineHeight());
            } 
            {
                width = Math.max(width, mMinWidth);
            } 
            width = Math.max(width, getSuggestedMinimumWidth());
            {
                width = Math.min(widthSize, width);
            } 
        } 
        int want = width - getCompoundPaddingLeft() - getCompoundPaddingRight();
        int unpaddedWidth = want;
        want = VERY_WIDE;
        int hintWant = want;
        int hintWidth;
        hintWidth = hintWant;
        hintWidth = mHintLayout.getWidth();
        {
            makeNewLayout(want, hintWant, boring, hintBoring,
                          width - getCompoundPaddingLeft() - getCompoundPaddingRight(), false);
        } 
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
            {
                {
                    mLayout.increaseWidthTo(want);
                } 
                {
                    makeNewLayout(want, hintWant, boring, hintBoring,
                            width - getCompoundPaddingLeft() - getCompoundPaddingRight(), false);
                } 
            } 
        } 
        {
            height = heightSize;
            mDesiredHeightAtMeasure = -1;
        } 
        {
            int desired = getDesiredHeight();
            height = desired;
            mDesiredHeightAtMeasure = desired;
            {
                height = Math.min(desired, heightSize);
            } 
        } 
        int unpaddedHeight = height - getCompoundPaddingTop() - getCompoundPaddingBottom();
        {
            boolean var3DB10CBFB12ED38DCBD3FB16EF151096_154713870 = (mMaxMode == LINES && mLayout.getLineCount() > mMaximum);
            {
                unpaddedHeight = Math.min(unpaddedHeight, mLayout.getLineTop(mMaximum));
            } 
        } 
        {
            boolean varFFED0DDEAA53977A5F429726E600A8F2_808102878 = (mMovement != null ||
            mLayout.getWidth() > unpaddedWidth ||
            mLayout.getHeight() > unpaddedHeight);
            {
                registerForPreDraw();
            } 
            {
                scrollTo(0, 0);
            } 
        } 
        setMeasuredDimension(width, height);
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.882 -0400", hash_original_method = "94259D4548546EABDDB6F8414E37FA42", hash_generated_method = "25E941EB19A4925C2E41000F7DB453A2")
    private int getDesiredHeight() {
        int var2840A69C5B812317D9CA537C29691369_1367674078 = (Math.max(
                getDesiredHeight(mLayout, true),
                getDesiredHeight(mHintLayout, mEllipsize != null)));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_372489539 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_372489539;
        
        
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.883 -0400", hash_original_method = "7AA300272C545049E0340D139CA1349D", hash_generated_method = "A0DBB1D85D0EF00DE06EE984B9352A16")
    private int getDesiredHeight(Layout layout, boolean cap) {
        int linecount = layout.getLineCount();
        int pad = getCompoundPaddingTop() + getCompoundPaddingBottom();
        int desired = layout.getLineTop(linecount);
        final Drawables dr = mDrawables;
        {
            desired = Math.max(desired, dr.mDrawableHeightLeft);
            desired = Math.max(desired, dr.mDrawableHeightRight);
        } 
        desired += pad;
        {
            {
                {
                    desired = layout.getLineTop(mMaximum);
                    {
                        desired = Math.max(desired, dr.mDrawableHeightLeft);
                        desired = Math.max(desired, dr.mDrawableHeightRight);
                    } 
                    desired += pad;
                    linecount = mMaximum;
                } 
            } 
        } 
        {
            desired = Math.min(desired, mMaximum);
        } 
        {
            {
                desired += getLineHeight() * (mMinimum - linecount);
            } 
        } 
        {
            desired = Math.max(desired, mMinimum);
        } 
        desired = Math.max(desired, getSuggestedMinimumHeight());
        addTaint(layout.getTaint());
        addTaint(cap);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1038917913 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1038917913;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.883 -0400", hash_original_method = "112907D8B10F62764352610BA7B79108", hash_generated_method = "959230E99FD15F670BB54B037D3BE91E")
    private void checkForResize() {
        boolean sizeChanged = false;
        {
            {
                sizeChanged = true;
                invalidate();
            } 
            {
                int desiredHeight = getDesiredHeight();
                {
                    boolean var76B417FEF15CB7997AEC250AB014098F_1125880982 = (desiredHeight != this.getHeight());
                    {
                        sizeChanged = true;
                    } 
                } 
            } 
            {
                {
                    int desiredHeight = getDesiredHeight();
                    {
                        sizeChanged = true;
                    } 
                } 
            } 
        } 
        {
            requestLayout();
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.884 -0400", hash_original_method = "5832A71588E0ABA41180B589D326BF70", hash_generated_method = "D0ABAEBE7D6EC2B6B834CCE2976B31D8")
    private void checkForRelayout() {
        {
            boolean var32BFD96E0546ED5F291DC663279A0815_1686460501 = ((mLayoutParams.width != LayoutParams.WRAP_CONTENT ||
                (mMaxWidthMode == mMinWidthMode && mMaxWidth == mMinWidth)) &&
                (mHint == null || mHintLayout != null) &&
                (mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight() > 0));
            {
                int oldht = mLayout.getHeight();
                int want = mLayout.getWidth();
                int hintWant;
                hintWant = 0;
                hintWant = mHintLayout.getWidth();
                makeNewLayout(want, hintWant, UNKNOWN_BORING, UNKNOWN_BORING,
                          mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight(),
                          false);
                {
                    {
                        invalidate();
                    } 
                    {
                        boolean varE1571FB91561235A70F553E0D47B6412_1632711871 = (mLayout.getHeight() == oldht &&
                    (mHintLayout == null || mHintLayout.getHeight() == oldht));
                        {
                            invalidate();
                        } 
                    } 
                } 
                requestLayout();
                invalidate();
            } 
            {
                nullLayouts();
                requestLayout();
                invalidate();
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.885 -0400", hash_original_method = "0DA3D6D28C1432B95D5D1B1B5DDB2BC8", hash_generated_method = "C288FA00D484A6C186A5606688608AB6")
    private boolean bringTextIntoView() {
        int line = 0;
        {
            line = mLayout.getLineCount() - 1;
        } 
        Layout.Alignment a = mLayout.getParagraphAlignment(line);
        int dir = mLayout.getParagraphDirection(line);
        int hspace = mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight();
        int vspace = mBottom - mTop - getExtendedPaddingTop() - getExtendedPaddingBottom();
        int ht = mLayout.getHeight();
        int scrollx;
        int scrolly;
        {
            a = dir == Layout.DIR_LEFT_TO_RIGHT ? Layout.Alignment.ALIGN_LEFT :
                Layout.Alignment.ALIGN_RIGHT;
        } 
        {
            a = dir == Layout.DIR_LEFT_TO_RIGHT ? Layout.Alignment.ALIGN_RIGHT :
                Layout.Alignment.ALIGN_LEFT;
        } 
        {
            int left = (int) FloatMath.floor(mLayout.getLineLeft(line));
            int right = (int) FloatMath.ceil(mLayout.getLineRight(line));
            {
                scrollx = (right + left) / 2 - hspace / 2;
            } 
            {
                {
                    scrollx = right - hspace;
                } 
                {
                    scrollx = left;
                } 
            } 
        } 
        {
            int right = (int) FloatMath.ceil(mLayout.getLineRight(line));
            scrollx = right - hspace;
        } 
        {
            scrollx = (int) FloatMath.floor(mLayout.getLineLeft(line));
        } 
        {
            scrolly = 0;
        } 
        {
            {
                scrolly = ht - vspace;
            } 
            {
                scrolly = 0;
            } 
        } 
        {
            scrollTo(scrollx, scrolly);
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_914200457 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_914200457;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.887 -0400", hash_original_method = "3C0DD43A95E696C7A1592341A7B2F740", hash_generated_method = "B9C60BC2DBC5ED49FA6DF0D94DAEC49D")
    public boolean bringPointIntoView(int offset) {
        boolean changed = false;
        int line = mLayout.getLineForOffset(offset);
        final int x = (int)mLayout.getPrimaryHorizontal(offset);
        final int top = mLayout.getLineTop(line);
        final int bottom = mLayout.getLineTop(line + 1);
        int left = (int) FloatMath.floor(mLayout.getLineLeft(line));
        int right = (int) FloatMath.ceil(mLayout.getLineRight(line));
        int ht = mLayout.getHeight();
        int grav;
        {
            Object var027910B290B59420177BD30BF1DDB958_1702124589 = (mLayout.getParagraphAlignment(line));
            
            grav = 1;
            
            
            grav = -1;
            
            
            grav = mLayout.getParagraphDirection(line);
            
            
            grav = -mLayout.getParagraphDirection(line);
            
            
            grav = 0;
            
        } 
        int hspace = mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight();
        int vspace = mBottom - mTop - getExtendedPaddingTop() - getExtendedPaddingBottom();
        int hslack = (bottom - top) / 2;
        int vslack = hslack;
        vslack = vspace / 4;
        hslack = hspace / 4;
        int hs = mScrollX;
        int vs = mScrollY;
        vs = top - vslack;
        vs = bottom - (vspace - vslack);
        vs = ht - vspace;
        vs = 0;
        {
            {
                hs = x - hslack;
            } 
            {
                hs = x - (hspace - hslack);
            } 
        } 
        {
            hs = left;
            hs = right - hspace;
        } 
        {
            hs = right - hspace;
            hs = left;
        } 
        {
            {
                hs = left - (hspace - (right - left)) / 2;
            } 
            {
                hs = right - hspace;
            } 
            {
                hs = left;
            } 
            {
                hs = left;
            } 
            {
                hs = right - hspace;
            } 
            {
                {
                    hs = x - hslack;
                } 
                {
                    hs = x - (hspace - hslack);
                } 
            } 
        } 
        {
            {
                scrollTo(hs, vs);
            } 
            {
                long duration = AnimationUtils.currentAnimationTimeMillis() - mLastScroll;
                int dx = hs - mScrollX;
                int dy = vs - mScrollY;
                {
                    mScroller.startScroll(mScrollX, mScrollY, dx, dy);
                    awakenScrollBars(mScroller.getDuration());
                    invalidate();
                } 
                {
                    {
                        boolean varD539631976251D8AA391F3162DE97B1C_85935793 = (!mScroller.isFinished());
                        {
                            mScroller.abortAnimation();
                        } 
                    } 
                    scrollBy(dx, dy);
                } 
                mLastScroll = AnimationUtils.currentAnimationTimeMillis();
            } 
            changed = true;
        } 
        {
            boolean var1C23F183BE3EEE2A8667855A22865324_1470085792 = (isFocused());
            {
                mTempRect = new Rect();
                mTempRect.set(x - 2, top, x + 2, bottom);
                getInterestingRect(mTempRect, line);
                mTempRect.offset(mScrollX, mScrollY);
                {
                    boolean var5DD27CBBEE9D998C97ABDC1CFDA74333_687988610 = (requestRectangleOnScreen(mTempRect));
                    {
                        changed = true;
                    } 
                } 
            } 
        } 
        addTaint(offset);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1241865409 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1241865409;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.887 -0400", hash_original_method = "02D4B7457672C459E287DBA1B16986EC", hash_generated_method = "2937F33CB1D35C2CE40EB08A9A977D01")
    public boolean moveCursorToVisibleOffset() {
        int start = getSelectionStart();
        int end = getSelectionEnd();
        int line = mLayout.getLineForOffset(start);
        final int top = mLayout.getLineTop(line);
        final int bottom = mLayout.getLineTop(line + 1);
        final int vspace = mBottom - mTop - getExtendedPaddingTop() - getExtendedPaddingBottom();
        int vslack = (bottom - top) / 2;
        vslack = vspace / 4;
        final int vs = mScrollY;
        {
            line = mLayout.getLineForVertical(vs+vslack+(bottom-top));
        } 
        {
            line = mLayout.getLineForVertical(vspace+vs-vslack-(bottom-top));
        } 
        final int hspace = mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight();
        final int hs = mScrollX;
        final int leftChar = mLayout.getOffsetForHorizontal(line, hs);
        final int rightChar = mLayout.getOffsetForHorizontal(line, hspace+hs);
        int lowChar;
        lowChar = leftChar;
        lowChar = rightChar;
        int highChar;
        highChar = leftChar;
        highChar = rightChar;
        int newStart = start;
        {
            newStart = lowChar;
        } 
        {
            newStart = highChar;
        } 
        {
            Selection.setSelection((Spannable)mText, newStart);
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_144024829 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_144024829;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.888 -0400", hash_original_method = "D06313C44705A7887AB654B7CF5A74B3", hash_generated_method = "A4101445DE8CFFB9802B86B245C1829C")
    @Override
    public void computeScroll() {
        {
            {
                boolean varD8983424724D79AFF92B0ED68CFEBCB5_1185584354 = (mScroller.computeScrollOffset());
                {
                    mScrollX = mScroller.getCurrX();
                    mScrollY = mScroller.getCurrY();
                    invalidateParentCaches();
                    postInvalidate();
                } 
            } 
        } 
        
        
            
                
                
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.889 -0400", hash_original_method = "ABFDC323272F3E6393D3C4F9B9F60889", hash_generated_method = "AA1527BD00DEDCEB3EA97F1F42222CFB")
    private void getInterestingRect(Rect r, int line) {
        convertFromViewportToContentCoordinates(r);
        r.top -= getExtendedPaddingTop();
        {
            boolean var36B5761D6C0D25FD94548457569D0FDF_233900053 = (line == mLayout.getLineCount() - 1);
            r.bottom += getExtendedPaddingBottom();
        } 
        addTaint(r.getTaint());
        addTaint(line);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.889 -0400", hash_original_method = "D2E7C9E2773084F5B5BC96B85475267E", hash_generated_method = "8FF7E983F4146E7DA80EED3B06E490D2")
    private void convertFromViewportToContentCoordinates(Rect r) {
        final int horizontalOffset = viewportToContentHorizontalOffset();
        r.left += horizontalOffset;
        r.right += horizontalOffset;
        final int verticalOffset = viewportToContentVerticalOffset();
        r.top += verticalOffset;
        r.bottom += verticalOffset;
        addTaint(r.getTaint());
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.890 -0400", hash_original_method = "3DB802CF5F82AE3562BB26F896D07DB6", hash_generated_method = "895D5A7EAB60A895AD8E2F0AA7F5A313")
    private int viewportToContentHorizontalOffset() {
        int var094701FAECA9F0FDE06C5A96E63AF57B_908393512 = (getCompoundPaddingLeft() - mScrollX);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_459863186 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_459863186;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.890 -0400", hash_original_method = "1E5AEDFCDEE7B994A62FE1D426BA9AAE", hash_generated_method = "F90C57D9ED31BDBFDC1D2A48D41C5231")
    private int viewportToContentVerticalOffset() {
        int offset = getExtendedPaddingTop() - mScrollY;
        {
            offset += getVerticalOffset(false);
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1673850180 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1673850180;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.891 -0400", hash_original_method = "7E6A70E8247BE9F0E1C3854BAECCAE99", hash_generated_method = "BA84B5A8FBFBAB9C25FD75925FFE989A")
    @Override
    public void debug(int depth) {
        super.debug(depth);
        String output = debugIndent(depth);
        output += "frame={" + mLeft + ", " + mTop + ", " + mRight
                + ", " + mBottom + "} scroll={" + mScrollX + ", " + mScrollY
                + "} ";
        {
            output += "mText=\"" + mText + "\" ";
            {
                output += "mLayout width=" + mLayout.getWidth()
                        + " height=" + mLayout.getHeight();
            } 
        } 
        {
            output += "mText=NULL";
        } 
        Log.d(VIEW_LOG_TAG, output);
        addTaint(depth);
        
        
        
        
                
                
        
            
            
                
                        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.892 -0400", hash_original_method = "FC0380BF9D344F57087ADAA0F0C8C1E5", hash_generated_method = "9549A4BA4106F619F228F6E4CC127595")
    @ViewDebug.ExportedProperty(category = "text")
    public int getSelectionStart() {
        int varB37ACFCDE0514D1AD6E7980466D0642F_212221985 = (Selection.getSelectionStart(getText()));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_613686054 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_613686054;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.892 -0400", hash_original_method = "59139061668C8515BDA5938230C2D233", hash_generated_method = "0E7B27218C84019944187F04D203E0AE")
    @ViewDebug.ExportedProperty(category = "text")
    public int getSelectionEnd() {
        int var62647D48C20F4425C471C6DB7EC335FA_725204927 = (Selection.getSelectionEnd(getText()));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1986837802 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1986837802;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.893 -0400", hash_original_method = "BD52AC55F75FC20C70791ABE185D07B3", hash_generated_method = "14F92D3D59688F4D07CB156CCC4E5253")
    public boolean hasSelection() {
        final int selectionStart = getSelectionStart();
        final int selectionEnd = getSelectionEnd();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1425193592 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1425193592;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.893 -0400", hash_original_method = "08C77724BEA7FD604DDC056EC8AC0A85", hash_generated_method = "3BCA6B79215B55736909B9CF7C5FC574")
    public void setSingleLine() {
        setSingleLine(true);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.893 -0400", hash_original_method = "02E25EABD0939EA349140FD704ABC4B2", hash_generated_method = "1AED22E2B086A521F35421A65810B8DF")
    public void setAllCaps(boolean allCaps) {
        {
            setTransformationMethod(new AllCapsTransformationMethod(getContext()));
        } 
        {
            setTransformationMethod(null);
        } 
        addTaint(allCaps);
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.894 -0400", hash_original_method = "F67AECEDD15B73EEA4C7246A27A881B1", hash_generated_method = "2C29CB9DE3123012851F4AD7F2FA8B93")
    @android.view.RemotableViewMethod
    public void setSingleLine(boolean singleLine) {
        setInputTypeSingleLine(singleLine);
        applySingleLine(singleLine, true, true);
        addTaint(singleLine);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.894 -0400", hash_original_method = "7606E2D7FCC52ECFF0946358CA46A596", hash_generated_method = "7672113BAFA059761089D684A8950861")
    private void setInputTypeSingleLine(boolean singleLine) {
        {
            {
                mInputType &= ~EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE;
            } 
            {
                mInputType |= EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE;
            } 
        } 
        addTaint(singleLine);
        
        
            
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.894 -0400", hash_original_method = "939294E5BC9AAD2D1E9D05ACD8801E5C", hash_generated_method = "D78563793112EE17F812B2B42680D6E2")
    private void applySingleLine(boolean singleLine, boolean applyTransformation,
            boolean changeMaxLines) {
        mSingleLine = singleLine;
        {
            setLines(1);
            setHorizontallyScrolling(true);
            {
                setTransformationMethod(SingleLineTransformationMethod.getInstance());
            } 
        } 
        {
            {
                setMaxLines(Integer.MAX_VALUE);
            } 
            setHorizontallyScrolling(false);
            {
                setTransformationMethod(null);
            } 
        } 
        addTaint(applyTransformation);
        addTaint(changeMaxLines);
        
        
        
            
            
            
                
            
        
            
                
            
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.895 -0400", hash_original_method = "8F48F7BF1B8DCE5D5519F1200A0ED853", hash_generated_method = "391DDE249F9C22576C3C02CC92F75CFE")
    public void setEllipsize(TextUtils.TruncateAt where) {
        {
            mEllipsize = where;
            {
                nullLayouts();
                requestLayout();
                invalidate();
            } 
        } 
        
        
            
            
                
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.895 -0400", hash_original_method = "CD4BE90CF39D915FD988D1208E7FE9CE", hash_generated_method = "5F7F9C51B8B3A126669EEFC67E596872")
    public void setMarqueeRepeatLimit(int marqueeLimit) {
        mMarqueeRepeatLimit = marqueeLimit;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.895 -0400", hash_original_method = "A6931739C39A011B325E0D6A04B5E1A4", hash_generated_method = "A9046E80C953FFE409F40C4AABF2AA53")
    @ViewDebug.ExportedProperty
    public TextUtils.TruncateAt getEllipsize() {
        TextUtils.TruncateAt varB4EAC82CA7396A68D541C85D26508E83_1281496289 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1281496289 = mEllipsize;
        varB4EAC82CA7396A68D541C85D26508E83_1281496289.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1281496289;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.896 -0400", hash_original_method = "EF856664E3DB8B213F8E2D5A0092DC9C", hash_generated_method = "16238E1BDE515B63A500D2B00D42C334")
    @android.view.RemotableViewMethod
    public void setSelectAllOnFocus(boolean selectAllOnFocus) {
        mSelectAllOnFocus = selectAllOnFocus;
        {
            setText(mText, BufferType.SPANNABLE);
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.896 -0400", hash_original_method = "8363604A399432417CD34524C965D01B", hash_generated_method = "A5016D99D04E4842F3E3647E9407B068")
    @android.view.RemotableViewMethod
    public void setCursorVisible(boolean visible) {
        {
            mCursorVisible = visible;
            invalidate();
            makeBlink();
            prepareCursorControllers();
        } 
        
        
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.896 -0400", hash_original_method = "D29F788B650242C9D9871158254DD48F", hash_generated_method = "A019D9AB83E2C5C303E86589705FA4C0")
    private boolean isCursorVisible() {
        boolean var34066627433670C8BAD177AAE0AA915E_1067084429 = (mCursorVisible && isTextEditable());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2010791412 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2010791412;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.897 -0400", hash_original_method = "20D9FD35375357DA34698727A7AEC969", hash_generated_method = "666BBAD967C83B54AEA485C05D177640")
    private boolean canMarquee() {
        int width = (mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight());
        boolean var7BCDD076660CE26696388675CAFFA311_1052070183 = (width > 0 && (mLayout.getLineWidth(0) > width ||
                (mMarqueeFadeMode != MARQUEE_FADE_NORMAL && mSavedMarqueeModeLayout != null &&
                        mSavedMarqueeModeLayout.getLineWidth(0) > width)));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2133308376 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2133308376;
        
        
        
                
                        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.897 -0400", hash_original_method = "A5A9508FE00ED8FCDF4CF88DA2302AE0", hash_generated_method = "D3458B6B40571706DED0C92637923464")
    private void startMarquee() {
        {
            boolean var6ED3A362A2778E1490EC444CE7783B2B_594832274 = (compressText(getWidth() - getCompoundPaddingLeft() - getCompoundPaddingRight()));
        } 
        {
            boolean var075BA9C6A85CDA01D82AF38828D63BDE_1135072610 = ((mMarquee == null || mMarquee.isStopped()) && (isFocused() || isSelected()) &&
                getLineCount() == 1 && canMarquee());
            {
                {
                    mMarqueeFadeMode = MARQUEE_FADE_SWITCH_SHOW_FADE;
                    final Layout tmp = mLayout;
                    mLayout = mSavedMarqueeModeLayout;
                    mSavedMarqueeModeLayout = tmp;
                    setHorizontalFadingEdgeEnabled(true);
                    requestLayout();
                    invalidate();
                } 
                mMarquee = new Marquee(this);
                mMarquee.start(mMarqueeRepeatLimit);
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.898 -0400", hash_original_method = "20FFAC26BF2AB259CA62980CC6D60A71", hash_generated_method = "C8E4174DC7A89C61601A380AD1512CEC")
    private void stopMarquee() {
        {
            boolean varC29061DCB050768224BF65B86692AEF9_165120395 = (mMarquee != null && !mMarquee.isStopped());
            {
                mMarquee.stop();
            } 
        } 
        {
            mMarqueeFadeMode = MARQUEE_FADE_SWITCH_SHOW_ELLIPSIS;
            final Layout tmp = mSavedMarqueeModeLayout;
            mSavedMarqueeModeLayout = mLayout;
            mLayout = tmp;
            setHorizontalFadingEdgeEnabled(false);
            requestLayout();
            invalidate();
        } 
        
        
            
        
        
            
            
            
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.898 -0400", hash_original_method = "21D240E17A817FDDEDCDA696469AE631", hash_generated_method = "075571A12CD343288F78D3DBD8F6CF6D")
    private void startStopMarquee(boolean start) {
        {
            {
                startMarquee();
            } 
            {
                stopMarquee();
            } 
        } 
        addTaint(start);
        
        
            
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.898 -0400", hash_original_method = "CD3A5A17C18A7E4515BB5E10EEE133D7", hash_generated_method = "5A38D7A52E63B141F65E3400877FA2F9")
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        
        addTaint(text.getTaint());
        addTaint(start);
        addTaint(lengthBefore);
        addTaint(lengthAfter);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.899 -0400", hash_original_method = "50DC1B812435050055FA72016E5949C2", hash_generated_method = "87189D15EBF6DC7ACC16571020058A28")
    protected void onSelectionChanged(int selStart, int selEnd) {
        
        sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED);
        addTaint(selStart);
        addTaint(selEnd);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.899 -0400", hash_original_method = "B64F50676D912718618203C6EADBF90A", hash_generated_method = "60EC4C825B8A758D874287AFCC67246D")
    public void addTextChangedListener(TextWatcher watcher) {
        {
            mListeners = new ArrayList<TextWatcher>();
        } 
        mListeners.add(watcher);
        addTaint(watcher.getTaint());
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.899 -0400", hash_original_method = "8E2AAA118EDD6CA871B924E45DB79686", hash_generated_method = "A84730B14C5A9BE6D964E5D78A5E6DF0")
    public void removeTextChangedListener(TextWatcher watcher) {
        {
            int i = mListeners.indexOf(watcher);
            {
                mListeners.remove(i);
            } 
        } 
        addTaint(watcher.getTaint());
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.900 -0400", hash_original_method = "282476D07DF9C69037F7F82B56506B50", hash_generated_method = "EEC61A211476D1AC16F95A44656DEA34")
    private void sendBeforeTextChanged(CharSequence text, int start, int before, int after) {
        {
            final ArrayList<TextWatcher> list = mListeners;
            final int count = list.size();
            {
                int i = 0;
                {
                    list.get(i).beforeTextChanged(text, start, before, after);
                } 
            } 
        } 
        removeIntersectingSpans(start, start + before, SpellCheckSpan.class);
        removeIntersectingSpans(start, start + before, SuggestionSpan.class);
        addTaint(text.getTaint());
        addTaint(start);
        addTaint(before);
        addTaint(after);
        
        
            
            
            
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.900 -0400", hash_original_method = "3C2834233455B82E3097E9750018AB89", hash_generated_method = "1AF540C62AF31F99CA6E047CAAF18505")
    private <T> void removeIntersectingSpans(int start, int end, Class<T> type) {
        Editable text = (Editable) mText;
        T[] spans = text.getSpans(start, end, type);
        final int length = spans.length;
        {
            int i = 0;
            {
                final int s = text.getSpanStart(spans[i]);
                final int e = text.getSpanEnd(spans[i]);
                text.removeSpan(spans[i]);
            } 
        } 
        addTaint(start);
        addTaint(end);
        addTaint(type.getTaint());
        
        
        
        
        
        
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.901 -0400", hash_original_method = "942AE7F3893B5D5A1A729CC9A3D3A214", hash_generated_method = "D44AD6381A89D140C7A253AF1D7A9589")
     void sendOnTextChanged(CharSequence text, int start, int before, int after) {
        {
            final ArrayList<TextWatcher> list = mListeners;
            final int count = list.size();
            {
                int i = 0;
                {
                    list.get(i).onTextChanged(text, start, before, after);
                } 
            } 
        } 
        updateSpellCheckSpans(start, start + after, false);
        hideCursorControllers();
        addTaint(text.getTaint());
        addTaint(start);
        addTaint(before);
        addTaint(after);
        
        
            
            
            
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.902 -0400", hash_original_method = "9B73ECD477F18D05FDDE640FFC672625", hash_generated_method = "E5348C69B0F3060CCFFE1394DEE7C890")
     void sendAfterTextChanged(Editable text) {
        {
            final ArrayList<TextWatcher> list = mListeners;
            final int count = list.size();
            {
                int i = 0;
                {
                    list.get(i).afterTextChanged(text);
                } 
            } 
        } 
        addTaint(text.getTaint());
        
        
            
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.903 -0400", hash_original_method = "4CD104B06ADE0BFE958B91634E28368D", hash_generated_method = "DBD510394C030F2A904465842FCD9EA3")
     void handleTextChanged(CharSequence buffer, int start, int before, int after) {
        final InputMethodState ims = mInputMethodState;
        {
            updateAfterEdit();
        } 
        {
            ims.mContentChanged = true;
            {
                ims.mChangedStart = start;
                ims.mChangedEnd = start+before;
            } 
            {
                ims.mChangedStart = Math.min(ims.mChangedStart, start);
                ims.mChangedEnd = Math.max(ims.mChangedEnd, start + before - ims.mChangedDelta);
            } 
            ims.mChangedDelta += after-before;
        } 
        sendOnTextChanged(buffer, start, before, after);
        onTextChanged(buffer, start, before, after);
        addTaint(buffer.getTaint());
        addTaint(start);
        addTaint(before);
        addTaint(after);
        
        
        
            
        
        
            
            
                
                
            
                
                
            
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.904 -0400", hash_original_method = "69940040C167925CDE0DCFB6E34891AF", hash_generated_method = "BA160758FCA80528C15C862DB159984C")
     void spanChange(Spanned buf, Object what, int oldStart, int newStart, int oldEnd, int newEnd) {
        boolean selChanged = false;
        int newSelStart = -1;
        int newSelEnd = -1;
        final InputMethodState ims = mInputMethodState;
        {
            mHighlightPathBogus = true;
            selChanged = true;
            newSelEnd = newStart;
            {
                boolean varCCB6FB0842D1DC09DCB72C373334A6F6_1211499295 = (!isFocused());
                {
                    mSelectionMoved = true;
                } 
            } 
            {
                invalidateCursor(Selection.getSelectionStart(buf), oldStart, newStart);
                registerForPreDraw();
                makeBlink();
            } 
        } 
        {
            mHighlightPathBogus = true;
            selChanged = true;
            newSelStart = newStart;
            {
                boolean varCCB6FB0842D1DC09DCB72C373334A6F6_1303682472 = (!isFocused());
                {
                    mSelectionMoved = true;
                } 
            } 
            {
                int end = Selection.getSelectionEnd(buf);
                invalidateCursor(end, oldStart, newStart);
            } 
        } 
        {
            {
                boolean varA8F0B10D2B3144CBC8414B61F2255511_1767443455 = ((buf.getSpanFlags(what)&Spanned.SPAN_INTERMEDIATE) == 0);
                {
                    {
                        newSelStart = Selection.getSelectionStart(buf);
                    } 
                    {
                        newSelEnd = Selection.getSelectionEnd(buf);
                    } 
                    onSelectionChanged(newSelStart, newSelEnd);
                } 
            } 
        } 
        {
            {
                invalidate();
                mHighlightPathBogus = true;
                checkForResize();
            } 
            {
                ims.mContentChanged = true;
            } 
        } 
        {
            boolean var534517144FEFDAEF71F7C8FA756F16FC_317548702 = (MetaKeyKeyListener.isMetaTracker(buf, what));
            {
                mHighlightPathBogus = true;
                {
                    boolean var16FFCEF6C055C210FC735BC7F134F961_1087336138 = (ims != null && MetaKeyKeyListener.isSelectingMetaTracker(buf, what));
                    {
                        ims.mSelectionModeChanged = true;
                    } 
                } 
                {
                    boolean varEFD569E843D74170ABE4EC8DA8C94C51_1621173692 = (Selection.getSelectionStart(buf) >= 0);
                    {
                        {
                            invalidateCursor();
                        } 
                        {
                            ims.mCursorChanged = true;
                        } 
                    } 
                } 
            } 
        } 
        {
            {
                {
                    {
                        {
                            ims.mChangedStart = oldStart;
                        } 
                        {
                            ims.mChangedStart = oldEnd;
                        } 
                    } 
                    {
                        {
                            ims.mChangedStart = newStart;
                        } 
                        {
                            ims.mChangedStart = newEnd;
                        } 
                    } 
                } 
                {
                    ims.mContentChanged = true;
                } 
            } 
        } 
        {
            mSpellChecker.removeSpellCheckSpan((SpellCheckSpan) what);
        } 
        addTaint(buf.getTaint());
        addTaint(what.getTaint());
        addTaint(oldStart);
        addTaint(newStart);
        addTaint(oldEnd);
        addTaint(newEnd);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.905 -0400", hash_original_method = "3584A2B9A599770217F39B9A82ACFE32", hash_generated_method = "90360C678C4B148830F399E7440B37A9")
    private void updateSpellCheckSpans(int start, int end, boolean createSpellChecker) {
        {
            boolean var330582D41A8577FF8D2F4281F7486A79_718237099 = (isTextEditable() && isSuggestionsEnabled() && !(this instanceof ExtractEditText));
            {
                {
                    mSpellChecker = new SpellChecker(this);
                } 
                {
                    mSpellChecker.spellCheck(start, end);
                } 
            } 
        } 
        addTaint(start);
        addTaint(end);
        addTaint(createSpellChecker);
        
        
            
                
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.905 -0400", hash_original_method = "5B060B8ED8B2D254991A03FDABE416A2", hash_generated_method = "5442F0493B231BDA57B4F0511037B18F")
    @Override
    public void dispatchFinishTemporaryDetach() {
        mDispatchTemporaryDetach = true;
        super.dispatchFinishTemporaryDetach();
        mDispatchTemporaryDetach = false;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.905 -0400", hash_original_method = "F389EC0F4785B5FE5917104FC845071C", hash_generated_method = "1A91DFB12354DC797253849F4D5C2578")
    @Override
    public void onStartTemporaryDetach() {
        
        super.onStartTemporaryDetach();
        mTemporaryDetach = true;
        hideControllers();
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.905 -0400", hash_original_method = "FEAF0C4CB4DA72DBC669293A29968ABE", hash_generated_method = "B710ACB4EFD7C32268C236E59191274A")
    @Override
    public void onFinishTemporaryDetach() {
        
        super.onFinishTemporaryDetach();
        mTemporaryDetach = false;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.906 -0400", hash_original_method = "B5EB741E17FA804FF18CB2D4805829B5", hash_generated_method = "45C0C9C087D04CCDFC62808A226E7E85")
    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        
        {
            super.onFocusChanged(focused, direction, previouslyFocusedRect);
        } 
        mShowCursor = SystemClock.uptimeMillis();
        ensureEndedBatchEdit();
        {
            int selStart = getSelectionStart();
            int selEnd = getSelectionEnd();
            final boolean isFocusHighlighted = mSelectAllOnFocus && selStart == 0 &&
                    selEnd == mText.length();
            mCreatedWithASelection = mFrozenWithFocus && hasSelection() && !isFocusHighlighted;
            {
                final int lastTapPosition = getLastTapPosition();
                {
                    Selection.setSelection((Spannable) mText, lastTapPosition);
                } 
                {
                    mMovement.onTakeFocus(this, (Spannable) mText, direction);
                } 
                {
                    Selection.setSelection((Spannable) mText, selStart, selEnd);
                } 
                {
                    selectAll();
                } 
                mTouchFocusSelected = true;
            } 
            mFrozenWithFocus = false;
            mSelectionMoved = false;
            {
                Spannable sp = (Spannable) mText;
                MetaKeyKeyListener.resetMetaState(sp);
            } 
            makeBlink();
            {
                showError();
            } 
        } 
        {
            {
                hideError();
            } 
            onEndBatchEdit();
            {
                final int selStart = getSelectionStart();
                final int selEnd = getSelectionEnd();
                hideControllers();
                Selection.setSelection((Spannable) mText, selStart, selEnd);
            } 
            {
                hideControllers();
                downgradeEasyCorrectionSpans();
            } 
            {
                mSelectionModifierCursorController.resetTouchOffsets();
            } 
        } 
        startStopMarquee(focused);
        {
            mTransformation.onFocusChanged(this, mText, focused, direction, previouslyFocusedRect);
        } 
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        addTaint(focused);
        addTaint(direction);
        addTaint(previouslyFocusedRect.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.907 -0400", hash_original_method = "CD7EF11AEB2748DC958E6E43AA11AC3D", hash_generated_method = "B8E5B378C8A30DA3345F53152A169318")
    private int getLastTapPosition() {
        {
            int lastTapPosition = mSelectionModifierCursorController.getMinTouchOffset();
            {
                {
                    boolean var164D0FD6416EC18A9D0895B7ABD638B0_273507660 = (lastTapPosition > mText.length());
                    {
                        lastTapPosition = mText.length();
                    } 
                } 
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_11221467 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_11221467;
        
        
            
            
                
                    
                            
                    
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.907 -0400", hash_original_method = "52F09857D084B6A7FF7DED6ACD447E38", hash_generated_method = "BB97642A7272E99714FE1387CB53DACB")
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        
        super.onWindowFocusChanged(hasWindowFocus);
        {
            {
                mBlink.uncancel();
                makeBlink();
            } 
        } 
        {
            {
                mBlink.cancel();
            } 
            onEndBatchEdit();
            {
                mInputContentType.enterDown = false;
            } 
            hideControllers();
            {
                mSuggestionsPopupWindow.onParentLostFocus();
            } 
        } 
        startStopMarquee(hasWindowFocus);
        addTaint(hasWindowFocus);
        
        
        
            
                
                
            
        
            
                
            
            
            
                
            
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.907 -0400", hash_original_method = "CACE22E1BEC14AEE1A4D35946DA3AF11", hash_generated_method = "B33E6B50711E3541C69DD97200CDD908")
    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        
        super.onVisibilityChanged(changedView, visibility);
        {
            hideControllers();
        } 
        addTaint(changedView.getTaint());
        addTaint(visibility);
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.908 -0400", hash_original_method = "B1100F7CC0894E179F002CED35623F94", hash_generated_method = "7326FA68EB3D2B7287F66A500889967C")
    public void clearComposingText() {
        {
            BaseInputConnection.removeComposingSpans((Spannable)mText);
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.908 -0400", hash_original_method = "D9A75FFCA0200824B6C25D7D7E778114", hash_generated_method = "76E3E5834A1CE064AEB67842D8B994B2")
    @Override
    public void setSelected(boolean selected) {
        boolean wasSelected = isSelected();
        super.setSelected(selected);
        {
            {
                startMarquee();
            } 
            {
                stopMarquee();
            } 
        } 
        addTaint(selected);
        
        
        
        
            
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.909 -0400", hash_original_method = "66B01BC66F894D20F58119BE8C84CE2C", hash_generated_method = "678E7569C6F331C8157AF72788BDDA32")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        
        final int action = event.getActionMasked();
        {
            boolean varCA8C62D3CC4BCF9B6208820C93DA2727_736210340 = (hasSelectionController());
            {
                getSelectionController().onTouchEvent(event);
            } 
        } 
        {
            mLastDownPositionX = event.getX();
            mLastDownPositionY = event.getY();
            mTouchFocusSelected = false;
            mIgnoreActionUpEvent = false;
        } 
        final boolean superResult = super.onTouchEvent(event);
        {
            mDiscardNextActionUp = false;
        } 
        final boolean touchIsFinished = (action == MotionEvent.ACTION_UP) &&
                !shouldIgnoreActionUpEvent() && isFocused();
        {
            boolean var20D4C59FE6C285ECEE884C522E960420_1660579818 = ((mMovement != null || onCheckIsTextEditor()) && isEnabled()
                && mText instanceof Spannable && mLayout != null);
            {
                boolean handled = false;
                {
                    handled |= mMovement.onTouchEvent(this, (Spannable) mText, event);
                } 
                {
                    ClickableSpan[] links = ((Spannable) mText).getSpans(getSelectionStart(),
                        getSelectionEnd(), ClickableSpan.class);
                    {
                        links[0].onClick(this);
                        handled = true;
                    } 
                } 
                {
                    boolean varA138BB91854FD0E07817A4930DAB4E64_117892907 = (touchIsFinished && (isTextEditable() || mTextIsSelectable));
                    {
                        final InputMethodManager imm = InputMethodManager.peekInstance();
                        viewClicked(imm);
                        {
                            handled |= imm != null && imm.showSoftInput(this, 0);
                        } 
                        boolean selectAllGotFocus = mSelectAllOnFocus && didTouchFocusSelect();
                        hideControllers();
                        {
                            boolean varC8FC4D62C210E65C8DA1490C44E99120_1815296436 = (!selectAllGotFocus && mText.length() > 0);
                            {
                                {
                                    mSpellChecker.onSelectionChanged();
                                } 
                                {
                                    boolean var1CF112AAAC5F75383DBE7BFFD7531552_410744304 = (!extractedTextModeWillBeStarted());
                                    {
                                        {
                                            boolean var60BC98927E3B58E7C5E7F75DDA71E61E_976252373 = (isCursorInsideEasyCorrectionSpan());
                                            {
                                                showSuggestions();
                                            } 
                                            {
                                                boolean varB6DE6ED2562A6539C8A95CCE9438A153_615103177 = (hasInsertionController());
                                                {
                                                    getInsertionController().show();
                                                } 
                                            } 
                                        } 
                                    } 
                                } 
                            } 
                        } 
                        handled = true;
                    } 
                } 
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_216181562 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_216181562;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.910 -0400", hash_original_method = "03AC5F43014CB2A7B3EC5095819B8787", hash_generated_method = "93ADB976324DEF845AB34480F282F76B")
    private boolean isCursorInsideSuggestionSpan() {
        SuggestionSpan[] suggestionSpans = ((Spannable) mText).getSpans(getSelectionStart(),
                getSelectionEnd(), SuggestionSpan.class);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_478704259 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_478704259;
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.910 -0400", hash_original_method = "FDBB0D2E258BF757A8B32CAC4ADCAFC2", hash_generated_method = "46D7B29565DC7D0AF5F20A976297A99C")
    private boolean isCursorInsideEasyCorrectionSpan() {
        Spannable spannable = (Spannable) mText;
        SuggestionSpan[] suggestionSpans = spannable.getSpans(getSelectionStart(),
                getSelectionEnd(), SuggestionSpan.class);
        {
            int i = 0;
            {
                {
                    boolean var2346E33123BC41A418719A614F5A6DD6_1922951533 = ((suggestionSpans[i].getFlags() & SuggestionSpan.FLAG_EASY_CORRECT) != 0);
                } 
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_720329940 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_720329940;
        
        
        
                
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.911 -0400", hash_original_method = "B422CE655E2FA1B2DED230B806484199", hash_generated_method = "86844AFEE2094D50FCD961DF926AF317")
    private void downgradeEasyCorrectionSpans() {
        {
            Spannable spannable = (Spannable) mText;
            SuggestionSpan[] suggestionSpans = spannable.getSpans(0,
                    spannable.length(), SuggestionSpan.class);
            {
                int i = 0;
                {
                    int flags = suggestionSpans[i].getFlags();
                    {
                        flags &= ~SuggestionSpan.FLAG_EASY_CORRECT;
                        suggestionSpans[i].setFlags(flags);
                    } 
                } 
            } 
        } 
        
        
            
            
                    
            
                
                
                        
                    
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.912 -0400", hash_original_method = "F41FEEC7411770322E4286C20722D03F", hash_generated_method = "E1B46AE1F747D694ADBE08882099DFCC")
    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        
        {
            try 
            {
                {
                    boolean var8B12764D2A804081F5E2F3C6ECF4057D_563198094 = (mMovement.onGenericMotionEvent(this, (Spannable) mText, event));
                } 
            } 
            catch (AbstractMethodError ex)
            { }
        } 
        boolean var32C1E3DF40BCC120C79428C7AEB27DD1_506057839 = (super.onGenericMotionEvent(event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1820090139 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1820090139;
        
        
            
                
                    
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.913 -0400", hash_original_method = "1022846F3BD24E55F7B42FF144EBDE9C", hash_generated_method = "8DFAB5A110424CFC1E86E64CB9214DF2")
    private void prepareCursorControllers() {
        boolean windowSupportsHandles = false;
        ViewGroup.LayoutParams params = getRootView().getLayoutParams();
        {
            WindowManager.LayoutParams windowParams = (WindowManager.LayoutParams) params;
            windowSupportsHandles = windowParams.type < WindowManager.LayoutParams.FIRST_SUB_WINDOW
                    || windowParams.type > WindowManager.LayoutParams.LAST_SUB_WINDOW;
        } 
        mInsertionControllerEnabled = windowSupportsHandles && isCursorVisible() && mLayout != null;
        mSelectionControllerEnabled = windowSupportsHandles && textCanBeSelected() &&
                mLayout != null;
        {
            hideInsertionPointCursorController();
            {
                mInsertionPointCursorController.onDetached();
                mInsertionPointCursorController = null;
            } 
        } 
        {
            stopSelectionActionMode();
            {
                mSelectionModifierCursorController.onDetached();
                mSelectionModifierCursorController = null;
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.913 -0400", hash_original_method = "5768F33DD15C2D6A1E8DF566C117D02C", hash_generated_method = "06144237E7B4B14AB75C7B3792AA9016")
    private boolean isTextEditable() {
        boolean varE3EE8DDB74DAF8872FE53127269AB9E6_1617392403 = (mText instanceof Editable && onCheckIsTextEditor() && isEnabled());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_598342338 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_598342338;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.914 -0400", hash_original_method = "319EEEA24E78F0A8A97E7B3282410D43", hash_generated_method = "B1F258F7D924CE0841069EC3A0441FDC")
    public boolean didTouchFocusSelect() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_65279620 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_65279620;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.914 -0400", hash_original_method = "F8EF60C67754333637E515F4BC0EB2C7", hash_generated_method = "3F8E08FFCA833AB1C4B66C0BC80B43D3")
    @Override
    public void cancelLongPress() {
        super.cancelLongPress();
        mIgnoreActionUpEvent = true;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.914 -0400", hash_original_method = "1EBA305C38503D593DE5ED34528F31AE", hash_generated_method = "7F579471132647120E431FF345E6CCC6")
    public boolean shouldIgnoreActionUpEvent() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1363522257 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1363522257;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.914 -0400", hash_original_method = "2ED59B8CED9712CD9EFEA3386ABFE955", hash_generated_method = "70FDBFE4845B02CA4AF3945F5C7FADEB")
    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        
        {
            {
                boolean var8C6289BC177E1FC846FED60E961858F7_924414944 = (mMovement.onTrackballEvent(this, (Spannable) mText, event));
            } 
        } 
        boolean var52056F11E16FA151938F980C67CD97F9_1893426745 = (super.onTrackballEvent(event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_779885255 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_779885255;
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.915 -0400", hash_original_method = "9E4C5FDADE7CEAD68CF365879A643A39", hash_generated_method = "6C45AED54B369950A87890A84980C656")
    public void setScroller(Scroller s) {
        mScroller = s;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.915 -0400", hash_original_method = "D90D14C34AE2DD19EDEA4AA99DD580AF", hash_generated_method = "0762DC3DC25D3EB2402358767606F33F")
    private boolean shouldBlink() {
        {
            boolean var4ABCBE6852627F4B46FBEF2A6A4ECCCA_1808346868 = (!isFocused());
        } 
        final int start = getSelectionStart();
        final int end = getSelectionEnd();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2107474143 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2107474143;
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.916 -0400", hash_original_method = "D1BDF909CEA832525561C896748DB631", hash_generated_method = "BE05944ED40B2E4883BAC7593A02F6CD")
    private void makeBlink() {
        {
            boolean var36B9A155CA4AF19B05F2985EF7AEDB1C_1693159525 = (isCursorVisible());
            {
                {
                    boolean var1E1DE2716F3F9B589A087F50D1F61A8B_1112784505 = (shouldBlink());
                    {
                        mShowCursor = SystemClock.uptimeMillis();
                        mBlink = new Blink(this);
                        mBlink.removeCallbacks(mBlink);
                        mBlink.postAtTime(mBlink, mShowCursor + BLINK);
                    } 
                } 
            } 
            {
                mBlink.removeCallbacks(mBlink);
            } 
        } 
        
        
            
                
                
                
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.916 -0400", hash_original_method = "2371CC9F994A54DD5E29CBD2552784AA", hash_generated_method = "A7C12A45393F855605B852B92C6B6B82")
    @Override
    protected float getLeftFadingEdgeStrength() {
        {
            {
                boolean var48B2E39505E7202B89848EF3423B9152_784320572 = (mMarquee != null && !mMarquee.isStopped());
                {
                    final Marquee marquee = mMarquee;
                    {
                        boolean var9BA25C39B44D42503DBE86D96DDE3F89_548885254 = (marquee.shouldDrawLeftFade());
                        {
                            float varACB89E3006AD14B300166FDE2E87A6BF_717484221 = (marquee.mScroll / getHorizontalFadingEdgeLength());
                        } 
                    } 
                } 
                {
                    boolean varB42567ABE2BADBC605E1B78E45085C46_474814569 = (getLineCount() == 1);
                    {
                        final int layoutDirection = getResolvedLayoutDirection();
                        final int absoluteGravity = Gravity.getAbsoluteGravity(mGravity, layoutDirection);
                        
                        float var77CC60141975FCCCD80D9A2419BB6C1C_859084355 = ((mLayout.getLineRight(0) - (mRight - mLeft) -
                                getCompoundPaddingLeft() - getCompoundPaddingRight() -
                                mLayout.getLineLeft(0)) / getHorizontalFadingEdgeLength());
                        
                    } 
                } 
            } 
        } 
        float var4F5C2129A9FDB4D7873C15071EC74FAF_1422774782 = (super.getLeftFadingEdgeStrength());
        float var546ADE640B6EDFBC8A086EF31347E768_664290695 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_664290695;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.917 -0400", hash_original_method = "7D05EA9E8579412E6DC4A8392EC7FDC2", hash_generated_method = "266C89E1D849080BE4190CB9DA0A588F")
    @Override
    protected float getRightFadingEdgeStrength() {
        {
            {
                boolean var48B2E39505E7202B89848EF3423B9152_1667344787 = (mMarquee != null && !mMarquee.isStopped());
                {
                    final Marquee marquee = mMarquee;
                    float var5FA73A5ADF77E0C7B666EC3867F0A8A9_833640368 = ((marquee.mMaxFadeScroll - marquee.mScroll) / getHorizontalFadingEdgeLength());
                } 
                {
                    boolean varB42567ABE2BADBC605E1B78E45085C46_365568607 = (getLineCount() == 1);
                    {
                        final int layoutDirection = getResolvedLayoutDirection();
                        final int absoluteGravity = Gravity.getAbsoluteGravity(mGravity, layoutDirection);
                        
                        final int textWidth = (mRight - mLeft) - getCompoundPaddingLeft() -
                                getCompoundPaddingRight();
                        
                        
                        final float lineWidth = mLayout.getLineWidth(0);
                        
                        
                        float varE0BE637D155EE291A7CF14784CC269F6_699031621 = ((lineWidth - textWidth) / getHorizontalFadingEdgeLength());
                        
                        
                        float varDB511E24CC8812A21F30B808ED92516B_125800888 = ((mLayout.getLineWidth(0) - ((mRight - mLeft) -
                                getCompoundPaddingLeft() - getCompoundPaddingRight())) /
                                getHorizontalFadingEdgeLength());
                        
                    } 
                } 
            } 
        } 
        float var23E074F03E79DB75514A1493E85330EB_1919134845 = (super.getRightFadingEdgeStrength());
        float var546ADE640B6EDFBC8A086EF31347E768_1014591163 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1014591163;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.917 -0400", hash_original_method = "A3B3BBCD8F5911495212C23A0CDB87AF", hash_generated_method = "D84824BA36BEF56BDF5B1753D3989B49")
    @Override
    protected int computeHorizontalScrollRange() {
        {
            {
                Object varB9E01A838DEDF048798537932C3D53D0_2086383743 = ((int) mLayout.getLineWidth(0));
                Object var48F73E2237CC10856F86F9441A565829_1282159443 = (mLayout.getWidth());
            } 
        } 
        int varED0C9CF0B7C065764BC0B4CBB9BD10B1_1397580320 = (super.computeHorizontalScrollRange());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1815714553 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1815714553;
        
        
            
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.918 -0400", hash_original_method = "FD0A725F27B0D409B10AFF4BD8232C49", hash_generated_method = "AFB079A19A9D5C20845962D59E2B7461")
    @Override
    protected int computeVerticalScrollRange() {
        int varEEB54A75518B385B09E35C2F7B0BB4DB_1805915434 = (mLayout.getHeight());
        int var06B1DFE229A17C2C5018936314B519D0_1966899193 = (super.computeVerticalScrollRange());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_913267157 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_913267157;
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.918 -0400", hash_original_method = "9A16EAE7151454D3FA35454A6C3BB413", hash_generated_method = "6E92F7275ABE689858AFF60E71AD0827")
    @Override
    protected int computeVerticalScrollExtent() {
        int var3D22FDF56C8F597D4B164222BB4A2F41_895697678 = (getHeight() - getCompoundPaddingTop() - getCompoundPaddingBottom());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_959422681 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_959422681;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.918 -0400", hash_original_method = "AF6DED1CDDAE4FEC9AD8DCCD50DF8C26", hash_generated_method = "073AF9708715AC92C453F42F57E7EBF8")
    @Override
    public void findViewsWithText(ArrayList<View> outViews, CharSequence searched, int flags) {
        super.findViewsWithText(outViews, searched, flags);
        {
            boolean var87A9E824D7926B465D9F8E23653E1606_89349485 = (!outViews.contains(this) && (flags & FIND_VIEWS_WITH_TEXT) != 0
                && !TextUtils.isEmpty(searched) && !TextUtils.isEmpty(mText));
            {
                String searchedLowerCase = searched.toString().toLowerCase();
                String textLowerCase = mText.toString().toLowerCase();
                {
                    boolean var4E8F3CA643822EB3D628A081C82F102F_1417373338 = (textLowerCase.contains(searchedLowerCase));
                    {
                        outViews.add(this);
                    } 
                } 
            } 
        } 
        addTaint(outViews.getTaint());
        addTaint(searched.getTaint());
        addTaint(flags);
        
        
        
                
            
            
            
                
            
        
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.920 -0400", hash_original_method = "9DEDF12E7A1F2B52484CF7C1E98D635C", hash_generated_method = "BA6C2903A6EDEF9C5BC632DD957CABBF")
    @Override
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        
        final int filteredMetaState = event.getMetaState() & ~KeyEvent.META_CTRL_MASK;
        {
            boolean varC56AADD2FE16B97F2C4A1A86C8CB9277_258271192 = (KeyEvent.metaStateHasNoModifiers(filteredMetaState));
            {
                
                {
                    boolean var2C54826044A6A463985C967714461581_1372417882 = (canSelectText());
                    {
                        boolean varEB35FFB1E0BAFF4B98799DF0DAE3AD9A_2069896036 = (onTextContextMenuItem(ID_SELECT_ALL));
                    } 
                } 
                
                
                {
                    boolean varD70E317BC144C26B73AA08B3BA3A1DF7_421651307 = (canCut());
                    {
                        boolean varF1F4885B43FDB12CD2347207BFCBE15D_1671106123 = (onTextContextMenuItem(ID_CUT));
                    } 
                } 
                
                
                {
                    boolean var64A51BC817B541ED78EC45FE802A582B_1591715111 = (canCopy());
                    {
                        boolean var7EC513D62717566DFF11F991DB68179B_409197256 = (onTextContextMenuItem(ID_COPY));
                    } 
                } 
                
                
                {
                    boolean varB590DB230E7D99BE97C8070362518C3D_1143555444 = (canPaste());
                    {
                        boolean varB380C053436C26C9F75D58F60AA0273E_1165786290 = (onTextContextMenuItem(ID_PASTE));
                    } 
                } 
                
            } 
        } 
        boolean var18CCACF7413D8761F4926498DDE0852A_594494186 = (super.onKeyShortcut(keyCode, event));
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1316342573 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1316342573;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.920 -0400", hash_original_method = "CD8FD18ADF4940449D6A099035EC8FE9", hash_generated_method = "C0496CE389864D6211F82993B0B95CEA")
    private boolean canSelectText() {
        boolean var45174109A5D4D4DED4D6B043F4737E70_782519920 = (hasSelectionController() && mText.length() != 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_645098013 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_645098013;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.921 -0400", hash_original_method = "09898B129565A0932D7F5D96EEC9BB39", hash_generated_method = "57C672DE8935AF48135BE0A08AAB614D")
    private boolean textCanBeSelected() {
        {
            boolean var0579FE66F74E6B0CAEB7B0FFED7BF6F0_1839619537 = (mMovement == null || !mMovement.canSelectArbitrarily());
        } 
        boolean varEA838F60BF8890D30F87CAA0AEA5A5AD_1500401786 = (isTextEditable() || (mTextIsSelectable && mText instanceof Spannable && isEnabled()));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1166177882 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1166177882;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.921 -0400", hash_original_method = "5A8A75E52337470DA5834210CD94E844", hash_generated_method = "49CA609CA3F35504F132D4FB187AEB4A")
    private boolean canCut() {
        {
            boolean varAFBCCFFAA18696A12B6915A938CC8475_1147989202 = (hasPasswordTransformationMethod());
        } 
        {
            boolean varDFBD28C454DECC5A34D6B1D50ACA53BA_2008479132 = (mText.length() > 0 && hasSelection() && mText instanceof Editable && mInput != null);
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1267658964 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1267658964;
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.922 -0400", hash_original_method = "C5BA619EC7C225A5F87BCD822F6EF570", hash_generated_method = "BB08FBD3C27564760B0B67A408FDE896")
    private boolean canCopy() {
        {
            boolean varAFBCCFFAA18696A12B6915A938CC8475_1170011650 = (hasPasswordTransformationMethod());
        } 
        {
            boolean varCAC8FC6B32A4536E20AA1AECC8F0BAF1_639207465 = (mText.length() > 0 && hasSelection());
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1977274248 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1977274248;
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.923 -0400", hash_original_method = "4C1E94F781705995B290C548A8DF616E", hash_generated_method = "9FDFB65A6C7FF4A7FEE77DA28560BE83")
    private boolean canPaste() {
        boolean varE457499D879154E36F02FF3DB5A1ED3A_2100118791 = ((mText instanceof Editable &&
                mInput != null &&
                getSelectionStart() >= 0 &&
                getSelectionEnd() >= 0 &&
                ((ClipboardManager)getContext().getSystemService(Context.CLIPBOARD_SERVICE)).
                hasPrimaryClip()));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_995942708 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_995942708;
        
        
                
                
                
                
                
    }

    
        private static long packRangeInLong(int start, int end) {
        return (((long) start) << 32) | end;
    }

    
        private static int extractRangeStartFromLong(long range) {
        return (int) (range >>> 32);
    }

    
        private static int extractRangeEndFromLong(long range) {
        return (int) (range & 0x00000000FFFFFFFFL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.924 -0400", hash_original_method = "493FC66F8A7ACF6A75CECBBBC666AB3C", hash_generated_method = "2B00755E1E3A243DDE0ABD8FCF519031")
    private boolean selectAll() {
        final int length = mText.length();
        Selection.setSelection((Spannable) mText, 0, length);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1029195633 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1029195633;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.925 -0400", hash_original_method = "B770D2F4FC63A979B3CD07A81B20384D", hash_generated_method = "682295767B63A1D2450051CEFC2AACEB")
    private boolean selectCurrentWord() {
        {
            boolean varDED1C694F054C8DDF1A29A76C5F20F19_395835820 = (!canSelectText());
        } 
        {
            boolean varAFBCCFFAA18696A12B6915A938CC8475_818750508 = (hasPasswordTransformationMethod());
            {
                boolean varE332F16868C9FD223E86B20517E855EF_18247662 = (selectAll());
            } 
        } 
        int klass = mInputType & InputType.TYPE_MASK_CLASS;
        int variation = mInputType & InputType.TYPE_MASK_VARIATION;
        {
            boolean varA650E26BD9A4F09AA14DDEB72540C88C_1798401214 = (selectAll());
        } 
        long lastTouchOffsets = getLastTouchOffsets();
        final int minOffset = extractRangeStartFromLong(lastTouchOffsets);
        final int maxOffset = extractRangeEndFromLong(lastTouchOffsets);
        {
            boolean var7155FC6291E75A72164AEF06E53012B4_1994497993 = (minOffset < 0 || minOffset >= mText.length());
        } 
        {
            boolean var1D5071A17653318C6F5B2B7CEE876EF7_1222181035 = (maxOffset < 0 || maxOffset >= mText.length());
        } 
        int selectionStart;
        int selectionEnd;
        URLSpan[] urlSpans = ((Spanned) mText).getSpans(minOffset, maxOffset, URLSpan.class);
        {
            URLSpan urlSpan = urlSpans[0];
            selectionStart = ((Spanned) mText).getSpanStart(urlSpan);
            selectionEnd = ((Spanned) mText).getSpanEnd(urlSpan);
        } 
        {
            final WordIterator wordIterator = getWordIterator();
            wordIterator.setCharSequence(mText, minOffset, maxOffset);
            selectionStart = wordIterator.getBeginning(minOffset);
            selectionEnd = wordIterator.getEnd(maxOffset);
            {
                long range = getCharRange(selectionStart);
                selectionStart = extractRangeStartFromLong(range);
                selectionEnd = extractRangeEndFromLong(range);
            } 
        } 
        Selection.setSelection((Spannable) mText, selectionStart, selectionEnd);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_599230307 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_599230307;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.925 -0400", hash_original_method = "9DCEB61D4BC0794F06560CB12151C0AA", hash_generated_method = "81CF11651C6DA971B336E1A51E9AB6E2")
    public Locale getTextServicesLocale() {
        Locale varB4EAC82CA7396A68D541C85D26508E83_673100875 = null; 
        Locale locale = Locale.getDefault();
        final TextServicesManager textServicesManager = (TextServicesManager)
                mContext.getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE);
        final SpellCheckerSubtype subtype = textServicesManager.getCurrentSpellCheckerSubtype(true);
        {
            locale = new Locale(subtype.getLocale());
        } 
        varB4EAC82CA7396A68D541C85D26508E83_673100875 = locale;
        varB4EAC82CA7396A68D541C85D26508E83_673100875.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_673100875;
        
        
        
                
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.926 -0400", hash_original_method = "84E4450A5BCA42ECDB6E0E833B2BF3C6", hash_generated_method = "00A6EC577A937BD6BC25376AD1589672")
     void onLocaleChanged() {
        
        mWordIterator = null;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.926 -0400", hash_original_method = "D7DB0153FBA43371270FE2DB428D268F", hash_generated_method = "32EB7E5A490877AD2F2E1D94C96AF86F")
    public WordIterator getWordIterator() {
        WordIterator varB4EAC82CA7396A68D541C85D26508E83_1295872286 = null; 
        {
            mWordIterator = new WordIterator(getTextServicesLocale());
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1295872286 = mWordIterator;
        varB4EAC82CA7396A68D541C85D26508E83_1295872286.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1295872286;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.926 -0400", hash_original_method = "B4D83E103073E3F8ED3897EF06B95E07", hash_generated_method = "194645CABB433328CAE1FA9DE01CE7AC")
    private long getCharRange(int offset) {
        final int textLength = mText.length();
        {
            final char currentChar = mText.charAt(offset);
            final char nextChar = mText.charAt(offset + 1);
            {
                boolean varD9CF44D283E0863128B66037E6BFB8CF_1846713586 = (Character.isSurrogatePair(currentChar, nextChar));
                {
                    long varDEC17ADCE274EF4E4EA0CD9ABF597677_837050288 = (packRangeInLong(offset,  offset + 2));
                } 
            } 
        } 
        {
            long var4A76496E7082009E497234E69A837D4C_1298049751 = (packRangeInLong(offset,  offset + 1));
        } 
        {
            final char previousChar = mText.charAt(offset - 1);
            final char previousPreviousChar = mText.charAt(offset - 2);
            {
                boolean var08ECDF9036721977163DCB5E7280D7DA_1455693219 = (Character.isSurrogatePair(previousPreviousChar, previousChar));
                {
                    long var579E9393D23E6CD1E4A1644DEA02C196_1140066674 = (packRangeInLong(offset - 2,  offset));
                } 
            } 
        } 
        {
            long var7F931D32D69CE46E71E33A6E014D5A4B_1370982517 = (packRangeInLong(offset - 1,  offset));
        } 
        long var1DBEC51B3461A29B2118BF318D35E0B5_1278141565 = (packRangeInLong(offset,  offset));
        addTaint(offset);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_586110213 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_586110213;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.927 -0400", hash_original_method = "C07E078EE2A4D1805F6BF366C72ED78F", hash_generated_method = "6091F0D6895B9FDC4423426C8F877752")
    private long getLastTouchOffsets() {
        SelectionModifierCursorController selectionController = getSelectionController();
        final int minOffset = selectionController.getMinTouchOffset();
        final int maxOffset = selectionController.getMaxTouchOffset();
        long var6C22B70D609AA0EDBEA57BAC907EBF70_1387636094 = (packRangeInLong(minOffset, maxOffset));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1691624252 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1691624252;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.927 -0400", hash_original_method = "A81C1729DD6237516D7BACF34829C51D", hash_generated_method = "2073C391230915C79839FDD5E7C4D97F")
    @Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        
        super.onPopulateAccessibilityEvent(event);
        final boolean isPassword = hasPasswordTransformationMethod();
        {
            CharSequence text = getTextForAccessibility();
            {
                boolean varE82D2DAF247906B4725B56EFEDF2A150_1656470823 = (!TextUtils.isEmpty(text));
                {
                    event.getText().add(text);
                } 
            } 
        } 
        addTaint(event.getTaint());
        
        
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.928 -0400", hash_original_method = "6FC069A7F29DA435C1F4CA8AC1DF9A7A", hash_generated_method = "BA66D21A02BFA7082D202C956D875DBE")
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        
        super.onInitializeAccessibilityEvent(event);
        final boolean isPassword = hasPasswordTransformationMethod();
        event.setPassword(isPassword);
        {
            boolean var9F2EDE90BC8D745F3A5915C44AB298CC_1871845083 = (event.getEventType() == AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED);
            {
                event.setFromIndex(Selection.getSelectionStart(mText));
                event.setToIndex(Selection.getSelectionEnd(mText));
                event.setItemCount(mText.length());
            } 
        } 
        addTaint(event.getTaint());
        
        
        
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.928 -0400", hash_original_method = "305122B0EBB45F51524377B6AB6D9296", hash_generated_method = "68DA1F3C4D675FBD763381A26BFBDD98")
    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        
        super.onInitializeAccessibilityNodeInfo(info);
        final boolean isPassword = hasPasswordTransformationMethod();
        {
            info.setText(getTextForAccessibility());
        } 
        info.setPassword(isPassword);
        addTaint(info.getTaint());
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.928 -0400", hash_original_method = "69E83CE4CD48DE4ECD21620922EFCC1A", hash_generated_method = "32B4485B97DCCD3D793C48F757BFDED3")
    @Override
    public void sendAccessibilityEvent(int eventType) {
        super.sendAccessibilityEvent(eventType);
        addTaint(eventType);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.929 -0400", hash_original_method = "8463B72D535FD98D84B93D99DA9D2B3A", hash_generated_method = "7B78D64EA204592FD70F62840814E153")
    private CharSequence getTextForAccessibility() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_53172356 = null; 
        CharSequence text = getText();
        {
            boolean var6C86A511CD0D2845B6E0259573F6A612_961815632 = (TextUtils.isEmpty(text));
            {
                text = getHint();
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_53172356 = text;
        varB4EAC82CA7396A68D541C85D26508E83_53172356.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_53172356;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.929 -0400", hash_original_method = "77215EF020F664C77A4E0174E763346B", hash_generated_method = "F110E2722A9047D9510CE3683A93691F")
     void sendAccessibilityEventTypeViewTextChanged(CharSequence beforeText,
            int fromIndex, int removedCount, int addedCount) {
        AccessibilityEvent event = AccessibilityEvent.obtain(AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED);
        event.setFromIndex(fromIndex);
        event.setRemovedCount(removedCount);
        event.setAddedCount(addedCount);
        event.setBeforeText(beforeText);
        sendAccessibilityEventUnchecked(event);
        addTaint(beforeText.getTaint());
        addTaint(fromIndex);
        addTaint(removedCount);
        addTaint(addedCount);
        
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.930 -0400", hash_original_method = "10EC795892359880AFC1661A7060F8D4", hash_generated_method = "3C91B98284AC8D887F5141BF488EECB4")
    public boolean isInputMethodTarget() {
        InputMethodManager imm = InputMethodManager.peekInstance();
        boolean var2E8BF75A8D890E760B8A4C35FF8B91BD_1597545497 = (imm != null && imm.isActive(this));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_101469279 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_101469279;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.930 -0400", hash_original_method = "395A8406E426F55316A0BF37153197E7", hash_generated_method = "D7172ADAB4FA17C74E502AB305DBEBBC")
    public boolean onTextContextMenuItem(int id) {
        
        int min = 0;
        int max = mText.length();
        {
            boolean var1C23F183BE3EEE2A8667855A22865324_372011451 = (isFocused());
            {
                final int selStart = getSelectionStart();
                final int selEnd = getSelectionEnd();
                min = Math.max(0, Math.min(selStart, selEnd));
                max = Math.max(0, Math.max(selStart, selEnd));
            } 
        } 
        
        selectAll();
        
        
        paste(min, max);
        
        
        setPrimaryClip(ClipData.newPlainText(null, getTransformedText(min, max)));
        
        
        deleteText_internal(min, max);
        
        
        stopSelectionActionMode();
        
        
        setPrimaryClip(ClipData.newPlainText(null, getTransformedText(min, max)));
        
        
        stopSelectionActionMode();
        
        addTaint(id);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1117125952 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1117125952;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.931 -0400", hash_original_method = "FE79E6B9FD3BC9A3AB2F6DF9CAFCD48E", hash_generated_method = "E3696A2EAF1D59BE13D00C7D2628FCFF")
    private CharSequence getTransformedText(int start, int end) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_335851579 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_335851579 = removeSuggestionSpans(mTransformed.subSequence(start, end));
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_335851579.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_335851579;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.933 -0400", hash_original_method = "6ABCBA1E552641094DE1B3327AD7FDD1", hash_generated_method = "E320D001BC07B6E4B81B3584D972C689")
    private long prepareSpacesAroundPaste(int min, int max, CharSequence paste) {
        {
            boolean var350AE6B9AD47061FFDF129B7005A2411_1611748900 = (paste.length() > 0);
            {
                {
                    final char charBefore = mTransformed.charAt(min - 1);
                    final char charAfter = paste.charAt(0);
                    {
                        boolean var3C202C664C757CF8D249A87B1D846040_806594135 = (Character.isSpaceChar(charBefore) && Character.isSpaceChar(charAfter));
                        {
                            final int originalLength = mText.length();
                            deleteText_internal(min - 1, min);
                            final int delta = mText.length() - originalLength;
                            min += delta;
                            max += delta;
                        } 
                        {
                            boolean varB469BF59168A8579CE9E3A2CAF0C1642_1805797885 = (!Character.isSpaceChar(charBefore) && charBefore != '\n' &&
                        !Character.isSpaceChar(charAfter) && charAfter != '\n');
                            {
                                final int originalLength = mText.length();
                                replaceText_internal(min, min, " ");
                                final int delta = mText.length() - originalLength;
                                min += delta;
                                max += delta;
                            } 
                        } 
                    } 
                } 
                {
                    boolean varEEF1C48FC1D3D39DDF48A720B8628129_414732596 = (max < mText.length());
                    {
                        final char charBefore = paste.charAt(paste.length() - 1);
                        final char charAfter = mTransformed.charAt(max);
                        {
                            boolean varBF8E0F80E2B510B9D515C61513407B2D_392590412 = (Character.isSpaceChar(charBefore) && Character.isSpaceChar(charAfter));
                            {
                                deleteText_internal(max, max + 1);
                            } 
                            {
                                boolean var59E656C6DF389BAD07A380CF8AC3667A_2056249991 = (!Character.isSpaceChar(charBefore) && charBefore != '\n' &&
                        !Character.isSpaceChar(charAfter) && charAfter != '\n');
                                {
                                    replaceText_internal(max, max, " ");
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
        long var541DF126AEC1F4495FAD956E97F187A7_2027542451 = (packRangeInLong(min, max));
        addTaint(min);
        addTaint(max);
        addTaint(paste.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2015246984 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2015246984;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.934 -0400", hash_original_method = "E0F0E7304052F47B24D850362D52309F", hash_generated_method = "2919F1EE8FE451664A2882399DC76EF0")
    private DragShadowBuilder getTextThumbnailBuilder(CharSequence text) {
        DragShadowBuilder varB4EAC82CA7396A68D541C85D26508E83_1815130084 = null; 
        TextView shadowView = (TextView) inflate(mContext,
                com.android.internal.R.layout.text_drag_thumbnail, null);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unable to inflate text drag thumbnail");
        } 
        {
            boolean var8664184B362287947D63596A4517BCE2_895163346 = (text.length() > DRAG_SHADOW_MAX_TEXT_LENGTH);
            {
                text = text.subSequence(0, DRAG_SHADOW_MAX_TEXT_LENGTH);
            } 
        } 
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
        varB4EAC82CA7396A68D541C85D26508E83_1815130084 = new DragShadowBuilder(shadowView);
        addTaint(text.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1815130084.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1815130084;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.935 -0400", hash_original_method = "FE9E03D9F3FD52DB88C5DE28D1E8768B", hash_generated_method = "B27143B1421EBD5F1CB74C34C8A6F36A")
    @Override
    public boolean performLongClick() {
        boolean handled = false;
        boolean vibrate = true;
        {
            boolean varC298D59926924FB0808A70DC864C4372_1873528225 = (super.performLongClick());
            {
                mDiscardNextActionUp = true;
                handled = true;
            } 
        } 
        {
            boolean varC22EC044E5AC4CF0B865C252AF7A9AA6_1652271040 = (!handled && !isPositionOnText(mLastDownPositionX, mLastDownPositionY) &&
                mInsertionControllerEnabled);
            {
                final int offset = getOffsetForPosition(mLastDownPositionX, mLastDownPositionY);
                stopSelectionActionMode();
                Selection.setSelection((Spannable) mText, offset);
                getInsertionController().showWithActionPopup();
                handled = true;
                vibrate = false;
            } 
        } 
        {
            {
                boolean var6D40024296296040632FE8120E16CDA8_476936234 = (touchPositionIsInSelection());
                {
                    final int start = getSelectionStart();
                    final int end = getSelectionEnd();
                    CharSequence selectedText = getTransformedText(start, end);
                    ClipData data = ClipData.newPlainText(null, selectedText);
                    DragLocalState localState = new DragLocalState(this, start, end);
                    startDrag(data, getTextThumbnailBuilder(selectedText), localState, 0);
                    stopSelectionActionMode();
                } 
                {
                    getSelectionController().hide();
                    selectCurrentWord();
                    getSelectionController().show();
                } 
            } 
            handled = true;
        } 
        {
            vibrate = handled = startSelectionActionMode();
        } 
        {
            performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
        } 
        {
            mDiscardNextActionUp = true;
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1606667528 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1606667528;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.935 -0400", hash_original_method = "227669F89CB3324004EC787BF93F591D", hash_generated_method = "A44866EF271B3C32452BC97ADB2ED2F3")
    private boolean touchPositionIsInSelection() {
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        {
            int tmp = selectionStart;
            selectionStart = selectionEnd;
            selectionEnd = tmp;
            Selection.setSelection((Spannable) mText, selectionStart, selectionEnd);
        } 
        SelectionModifierCursorController selectionController = getSelectionController();
        int minOffset = selectionController.getMinTouchOffset();
        int maxOffset = selectionController.getMaxTouchOffset();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2000444246 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2000444246;
        
        
        
        
            
        
        
            
            
            
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.936 -0400", hash_original_method = "A2BF41305999CD5C7E75DA3423749804", hash_generated_method = "E35D32096E4E2BC0F69559EBED0D8E91")
    private PositionListener getPositionListener() {
        PositionListener varB4EAC82CA7396A68D541C85D26508E83_527597324 = null; 
        {
            mPositionListener = new PositionListener();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_527597324 = mPositionListener;
        varB4EAC82CA7396A68D541C85D26508E83_527597324.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_527597324;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.937 -0400", hash_original_method = "23179C09AF51D00D4FCF53E6D8173595", hash_generated_method = "D420AFC627C3528D8084C518B60C77C8")
    private boolean isPositionVisible(int positionX, int positionY) {
        {
            final float[] position = sTmpPosition;
            position[0] = positionX;
            position[1] = positionY;
            View view = this;
            {
                {
                    boolean var5103DE2BDA9F56FC7E36F1B0BD1193A5_1716209642 = (view != this);
                    {
                        position[0] -= view.getScrollX();
                        position[1] -= view.getScrollY();
                    } 
                } 
                {
                    boolean varCC3EA170661AE32B143B6B8CB851A271_1766977138 = (position[0] < 0 || position[1] < 0 ||
                        position[0] > view.getWidth() || position[1] > view.getHeight());
                } 
                {
                    boolean var020714D8D65A6851489742B00823B874_1694771249 = (!view.getMatrix().isIdentity());
                    {
                        view.getMatrix().mapPoints(position);
                    } 
                } 
                position[0] += view.getLeft();
                position[1] += view.getTop();
                final ViewParent parent = view.getParent();
                {
                    view = (View) parent;
                } 
                {
                    view = null;
                } 
            } 
        } 
        addTaint(positionX);
        addTaint(positionY);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1013099797 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1013099797;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.937 -0400", hash_original_method = "51F76D7934106C8713E6D720A3BD9BE7", hash_generated_method = "877A8CA842D419BB9466C59BEF56833D")
    private boolean isOffsetVisible(int offset) {
        final int line = mLayout.getLineForOffset(offset);
        final int lineBottom = mLayout.getLineBottom(line);
        final int primaryHorizontal = (int) mLayout.getPrimaryHorizontal(offset);
        boolean varD4446F991D74BA64F3AC992B6F4738F8_662921878 = (isPositionVisible(primaryHorizontal + viewportToContentHorizontalOffset(),
                lineBottom + viewportToContentVerticalOffset()));
        addTaint(offset);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_603444524 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_603444524;
        
        
        
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.937 -0400", hash_original_method = "8567BA4CA284138DD0CB4B48B9C8C278", hash_generated_method = "0842DFBF8109A1EA35E347B5A4D41A52")
    @Override
    protected void onScrollChanged(int horiz, int vert, int oldHoriz, int oldVert) {
        
        super.onScrollChanged(horiz, vert, oldHoriz, oldVert);
        {
            mPositionListener.onScrollChanged();
        } 
        addTaint(horiz);
        addTaint(vert);
        addTaint(oldHoriz);
        addTaint(oldVert);
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.938 -0400", hash_original_method = "9FAF02695A10AC660CF2B5DD3EDB7DD4", hash_generated_method = "39F70B5045AB0E31DF85CF1984A623FC")
     CharSequence removeSuggestionSpans(CharSequence text) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_150370088 = null; 
        {
            Spannable spannable;
            {
                spannable = (Spannable) text;
            } 
            {
                spannable = new SpannableString(text);
                text = spannable;
            } 
            SuggestionSpan[] spans = spannable.getSpans(0, text.length(), SuggestionSpan.class);
            {
                int i = 0;
                {
                    spannable.removeSpan(spans[i]);
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_150370088 = text;
        addTaint(text.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_150370088.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_150370088;
        
        
           
           
               
           
               
               
           
           
           
               
           
       
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.938 -0400", hash_original_method = "97397C66433481C877E194A1E7813AF3", hash_generated_method = "8C09B45831F6B0FC0EEC21C59FB38634")
     void showSuggestions() {
        {
            mSuggestionsPopupWindow = new SuggestionsPopupWindow();
        } 
        hideControllers();
        mSuggestionsPopupWindow.show();
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.939 -0400", hash_original_method = "E5A6F19BA20AF228602A3EAA320E6192", hash_generated_method = "E5EFC585038625F2C7ECB75F3360BBCA")
     boolean areSuggestionsShown() {
        boolean var29FA41D6182C8FCF2B2C7ECDA0C38EBD_806043654 = (mSuggestionsPopupWindow != null && mSuggestionsPopupWindow.isShowing());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_75973758 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_75973758;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.939 -0400", hash_original_method = "25A5AF708197CD0F2143471E812F624E", hash_generated_method = "C09B2EB83ADEA9CDCED051504EC504AD")
    public boolean isSuggestionsEnabled() {
        final int variation = mInputType & EditorInfo.TYPE_MASK_VARIATION;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_535731819 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_535731819;
        
        
        
        
        
                
                
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.939 -0400", hash_original_method = "9876FACCD4EAE43EA4CB6FD414FD5E5A", hash_generated_method = "99F50FF2FBA3328523C1FCF161298BA2")
    public void setCustomSelectionActionModeCallback(ActionMode.Callback actionModeCallback) {
        mCustomSelectionActionModeCallback = actionModeCallback;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.940 -0400", hash_original_method = "6671930C0B8994CBEF8AFBE835B485C8", hash_generated_method = "8FAEFDEA86291639935E979AEB9AA87F")
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        ActionMode.Callback varB4EAC82CA7396A68D541C85D26508E83_991621637 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_991621637 = mCustomSelectionActionModeCallback;
        varB4EAC82CA7396A68D541C85D26508E83_991621637.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_991621637;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.940 -0400", hash_original_method = "B9B1CE7E81D0AD0E9224682576CA1ABE", hash_generated_method = "122CA434566A15ADF742020CEE09F4D4")
    private boolean startSelectionActionMode() {
        {
            boolean varDD51C7CC25E36170CF1A5B45DEEBD783_1720209577 = (!canSelectText() || !requestFocus());
        } 
        {
            boolean varD18B2E3785F2697D3F393507C051114C_1979984695 = (!hasSelection());
            {
                {
                    boolean var2694D05A2D7BEB6A7092F61157ECE50C_952340197 = (!selectCurrentWord());
                } 
            } 
        } 
        boolean willExtract = extractedTextModeWillBeStarted();
        {
            ActionMode.Callback actionModeCallback = new SelectionActionModeCallback();
            mSelectionActionMode = startActionMode(actionModeCallback);
        } 
        final boolean selectionStarted = mSelectionActionMode != null || willExtract;
        {
            final InputMethodManager imm = InputMethodManager.peekInstance();
            {
                imm.showSoftInput(this, 0, null);
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1509003563 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1509003563;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.941 -0400", hash_original_method = "F292596F6DB6F0A1BCB4946717902139", hash_generated_method = "03E7EE84DB2F53CCFF433D2C3B9E2332")
    private boolean extractedTextModeWillBeStarted() {
        {
            final InputMethodManager imm = InputMethodManager.peekInstance();
            boolean var2F4E2C66FC57F06F55546BB121BBAB53_678043205 = (imm != null && imm.isFullscreenMode());
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_38184402 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_38184402;
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.941 -0400", hash_original_method = "9843C3F333617B8C113B72E2C38319BA", hash_generated_method = "A0249CA7D39C0509B23718121E90129E")
    private void stopSelectionActionMode() {
        {
            mSelectionActionMode.finish();
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.943 -0400", hash_original_method = "FD893A1B640E2E356DBE924FBE58EA4D", hash_generated_method = "4B592C27E3D9823BD96E58B3BA702500")
    private void paste(int min, int max) {
        ClipboardManager clipboard = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = clipboard.getPrimaryClip();
        {
            boolean didFirst = false;
            {
                int i = 0;
                boolean varCF4CF6A541CEE14E85EAE2AF810764AC_1519139007 = (i<clip.getItemCount());
                {
                    CharSequence paste = clip.getItemAt(i).coerceToText(getContext());
                    {
                        {
                            long minMax = prepareSpacesAroundPaste(min, max, paste);
                            min = extractRangeStartFromLong(minMax);
                            max = extractRangeEndFromLong(minMax);
                            Selection.setSelection((Spannable) mText, max);
                            ((Editable) mText).replace(min, max, paste);
                            didFirst = true;
                        } 
                        {
                            ((Editable) mText).insert(getSelectionEnd(), "\n");
                            ((Editable) mText).insert(getSelectionEnd(), paste);
                        } 
                    } 
                } 
            } 
            stopSelectionActionMode();
            sLastCutOrCopyTime = 0;
        } 
        addTaint(min);
        addTaint(max);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.943 -0400", hash_original_method = "8BE6A63416328BC319B0B5D0DB32AF7B", hash_generated_method = "95420C5D85CE935529134935C74E4735")
    private void setPrimaryClip(ClipData clip) {
        ClipboardManager clipboard = (ClipboardManager) getContext().
                getSystemService(Context.CLIPBOARD_SERVICE);
        clipboard.setPrimaryClip(clip);
        sLastCutOrCopyTime = SystemClock.uptimeMillis();
        addTaint(clip.getTaint());
        
        
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.943 -0400", hash_original_method = "EC32E229F62759229A3F9E53D2729660", hash_generated_method = "29E097B4A8943645223D542B5C9F2EB3")
    private void hideInsertionPointCursorController() {
        {
            mInsertionPointCursorController.hide();
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.944 -0400", hash_original_method = "24BE7797312EE966374B6FFCFBB4586E", hash_generated_method = "957DAB26CB1B7753D50A6C44463DD0BC")
    private void hideControllers() {
        hideCursorControllers();
        hideSpanControllers();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.944 -0400", hash_original_method = "49CA1E2702021EF560B250FA375633C6", hash_generated_method = "DF3B309A0E8B4C37468C98D609346973")
    private void hideSpanControllers() {
        {
            mChangeWatcher.hideControllers();
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.944 -0400", hash_original_method = "1E18C93748F74C8EE354333AE329FDA3", hash_generated_method = "F8B9436AC640F8EFBCD6D6D7FA4A20CD")
    private void hideCursorControllers() {
        {
            boolean var97060A385B2EE20942D359972C3B987E_2028161762 = (mSuggestionsPopupWindow != null && !mSuggestionsPopupWindow.isShowingUp());
            {
                mSuggestionsPopupWindow.hide();
            } 
        } 
        hideInsertionPointCursorController();
        stopSelectionActionMode();
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.945 -0400", hash_original_method = "3AC7FDA43CAD0B3033F953FC5E229096", hash_generated_method = "F649E8150EE063011DABD129C2AE4B39")
    public int getOffsetForPosition(float x, float y) {
        {
            boolean var778B744EBE60DF815BEE98852B413FC5_339411407 = (getLayout() == null);
        } 
        final int line = getLineAtCoordinate(y);
        final int offset = getOffsetAtCoordinate(line, x);
        addTaint(x);
        addTaint(y);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_158701812 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_158701812;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.945 -0400", hash_original_method = "C0F2EACF537DEE598E512FB7710303B4", hash_generated_method = "6802A0B2FBD796AA88D9D739F426BF8E")
    private float convertToLocalHorizontalCoordinate(float x) {
        x -= getTotalPaddingLeft();
        x = Math.max(0.0f, x);
        x = Math.min(getWidth() - getTotalPaddingRight() - 1, x);
        x += getScrollX();
        addTaint(x);
        float var546ADE640B6EDFBC8A086EF31347E768_1825073569 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1825073569;
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.946 -0400", hash_original_method = "69F0EDA2749521F4A39C0BEAC846F1E5", hash_generated_method = "1C7495F80A50D3D0C3D8175C9913AAEC")
    private int getLineAtCoordinate(float y) {
        y -= getTotalPaddingTop();
        y = Math.max(0.0f, y);
        y = Math.min(getHeight() - getTotalPaddingBottom() - 1, y);
        y += getScrollY();
        int var6DD28032E606AA4BF99A53AB522278D5_1169928400 = (getLayout().getLineForVertical((int) y));
        addTaint(y);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1909571447 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1909571447;
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.946 -0400", hash_original_method = "78600135096D77C91825CF9049D3F243", hash_generated_method = "EBA91C5C5EF7E9222E7DCB0B07F4E574")
    private int getOffsetAtCoordinate(int line, float x) {
        x = convertToLocalHorizontalCoordinate(x);
        int varD73392C253D779C86FFAE24ED89F63F1_281365252 = (getLayout().getOffsetForHorizontal(line, x));
        addTaint(line);
        addTaint(x);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1289683728 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1289683728;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.946 -0400", hash_original_method = "B77333C8EDA86B5BA4A004A4B129217A", hash_generated_method = "461002D70894969461B7871EAFAE6DF8")
    private boolean isPositionOnText(float x, float y) {
        {
            boolean var778B744EBE60DF815BEE98852B413FC5_1422451725 = (getLayout() == null);
        } 
        final int line = getLineAtCoordinate(y);
        x = convertToLocalHorizontalCoordinate(x);
        {
            boolean var59E035AC6E596093F53E603EDA382B91_1822702719 = (x < getLayout().getLineLeft(line));
        } 
        {
            boolean var04BE7C77E8AA35EC39BE529B038AF3DD_548050296 = (x > getLayout().getLineRight(line));
        } 
        addTaint(x);
        addTaint(y);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1874995969 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1874995969;
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.947 -0400", hash_original_method = "282C8F5427700D40A542E64F343C6674", hash_generated_method = "DAE219CD5B42BD35504CFD3847B61F4F")
    @Override
    public boolean onDragEvent(DragEvent event) {
        
        {
            Object var9E1FBD251DF7E53AB77C3A31F15B2B38_751650625 = (event.getAction());
            
            boolean varB5182ED29788A31653E5E1546400D879_621888797 = (hasInsertionController());
            
            
            TextView.this.requestFocus();
            
            
            final int offset = getOffsetForPosition(event.getX(), event.getY());
            
            
            Selection.setSelection((Spannable)mText, offset);
            
            
            onDrop(event);
            
        } 
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2065235160 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2065235160;
        
        
            
                
            
                
                
            
                
                
                
            
                
                
            
            
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.948 -0400", hash_original_method = "89464BC34879AFE88152B04970AA44D2", hash_generated_method = "0A4FC7F82AAF1E80BF6688CBB6B7D45D")
    private void onDrop(DragEvent event) {
        StringBuilder content = new StringBuilder("");
        ClipData clipData = event.getClipData();
        final int itemCount = clipData.getItemCount();
        {
            int i = 0;
            {
                Item item = clipData.getItemAt(i);
                content.append(item.coerceToText(TextView.this.mContext));
            } 
        } 
        final int offset = getOffsetForPosition(event.getX(), event.getY());
        Object localState = event.getLocalState();
        DragLocalState dragLocalState = null;
        {
            dragLocalState = (DragLocalState) localState;
        } 
        boolean dragDropIntoItself = dragLocalState != null &&
                dragLocalState.sourceTextView == this;
        final int originalLength = mText.length();
        long minMax = prepareSpacesAroundPaste(offset, offset, content);
        int min = extractRangeStartFromLong(minMax);
        int max = extractRangeEndFromLong(minMax);
        Selection.setSelection((Spannable) mText, max);
        replaceText_internal(min, max, content);
        {
            int dragSourceStart = dragLocalState.start;
            int dragSourceEnd = dragLocalState.end;
            {
                final int shift = mText.length() - originalLength;
                dragSourceStart += shift;
                dragSourceEnd += shift;
            } 
            deleteText_internal(dragSourceStart, dragSourceEnd);
            {
                boolean var353A6E4F7751153EED06FB844C167F01_876469028 = ((dragSourceStart == 0 ||
                    Character.isSpaceChar(mTransformed.charAt(dragSourceStart - 1))) &&
                    (dragSourceStart == mText.length() ||
                    Character.isSpaceChar(mTransformed.charAt(dragSourceStart))));
                {
                    int pos;
                    boolean var518448CA6AC99CEB1166FD5287784237_132636656 = (dragSourceStart == mText.length());
                    pos = dragSourceStart - 1;
                    pos = dragSourceStart;
                    deleteText_internal(pos, pos + 1);
                } 
            } 
        } 
        addTaint(event.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.948 -0400", hash_original_method = "91BB575EAEE11A270473B31B356B5B12", hash_generated_method = "34420F27336A9B0740C0D78D51D1F030")
     boolean hasInsertionController() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_444947248 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_444947248;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.948 -0400", hash_original_method = "EE05979336406D2A8CCC57049072454C", hash_generated_method = "C8508C99C13CCF38090597874DFB0D02")
     boolean hasSelectionController() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_783771804 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_783771804;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.949 -0400", hash_original_method = "02A03A91466BF03F45C3C819266A605E", hash_generated_method = "597E537B2E6196D2863DECE19E59DF33")
     InsertionPointCursorController getInsertionController() {
        InsertionPointCursorController varB4EAC82CA7396A68D541C85D26508E83_663222952 = null; 
        InsertionPointCursorController varB4EAC82CA7396A68D541C85D26508E83_1976067970 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_663222952 = null;
        } 
        {
            mInsertionPointCursorController = new InsertionPointCursorController();
            final ViewTreeObserver observer = getViewTreeObserver();
            observer.addOnTouchModeChangeListener(mInsertionPointCursorController);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1976067970 = mInsertionPointCursorController;
        InsertionPointCursorController varA7E53CE21691AB073D9660D615818899_2002700616; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2002700616 = varB4EAC82CA7396A68D541C85D26508E83_663222952;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2002700616 = varB4EAC82CA7396A68D541C85D26508E83_1976067970;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2002700616.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2002700616;
        
        
            
        
        
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.950 -0400", hash_original_method = "CD09732805D28B5BF513C98008463942", hash_generated_method = "C02406CD93D25E8F23FB1E6DD0A4D09E")
     SelectionModifierCursorController getSelectionController() {
        SelectionModifierCursorController varB4EAC82CA7396A68D541C85D26508E83_1793030511 = null; 
        SelectionModifierCursorController varB4EAC82CA7396A68D541C85D26508E83_481405890 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1793030511 = null;
        } 
        {
            mSelectionModifierCursorController = new SelectionModifierCursorController();
            final ViewTreeObserver observer = getViewTreeObserver();
            observer.addOnTouchModeChangeListener(mSelectionModifierCursorController);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_481405890 = mSelectionModifierCursorController;
        SelectionModifierCursorController varA7E53CE21691AB073D9660D615818899_629879746; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_629879746 = varB4EAC82CA7396A68D541C85D26508E83_1793030511;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_629879746 = varB4EAC82CA7396A68D541C85D26508E83_481405890;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_629879746.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_629879746;
        
        
            
        
        
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.950 -0400", hash_original_method = "2A090273FA835CA26EC17C458A37DEC8", hash_generated_method = "65D88B70D914331C4973099D35423879")
     boolean isInBatchEditMode() {
        final InputMethodState ims = mInputMethodState;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1017262808 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1017262808;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.950 -0400", hash_original_method = "6388CB4B4CF218043B88410FEBCF8F11", hash_generated_method = "872E25AAD739D459A3E0F67B3D65D93F")
    @Override
    protected void resolveTextDirection() {
        {
            boolean varAFBCCFFAA18696A12B6915A938CC8475_1830236980 = (hasPasswordTransformationMethod());
            {
                mTextDir = TextDirectionHeuristics.LOCALE;
            } 
        } 
        final boolean defaultIsRtl = (getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL);
        super.resolveTextDirection();
        int textDir = getResolvedTextDirection();
        
        mTextDir = (defaultIsRtl ? TextDirectionHeuristics.FIRSTSTRONG_RTL :
                        TextDirectionHeuristics.FIRSTSTRONG_LTR);
        
        
        mTextDir = TextDirectionHeuristics.ANYRTL_LTR;
        
        
        mTextDir = TextDirectionHeuristics.LTR;
        
        
        mTextDir = TextDirectionHeuristics.RTL;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.951 -0400", hash_original_method = "E2C9FAE08740394CAC2960942379DB19", hash_generated_method = "64204E5DBE6F0409B58DA5F33CA16560")
    protected void resolveDrawables() {
        {
            mResolvedDrawables = true;
        } 
        Drawables dr = mDrawables;
        {
            Object varAFC6EB2C684D509A17B3A4EFF5D9CB9D_1322885429 = (getResolvedLayoutDirection());
            
            {
                dr.mDrawableRight = dr.mDrawableStart;
                dr.mDrawableSizeRight = dr.mDrawableSizeStart;
                dr.mDrawableHeightRight = dr.mDrawableHeightStart;
            } 
            
            
            {
                dr.mDrawableLeft = dr.mDrawableEnd;
                dr.mDrawableSizeLeft = dr.mDrawableSizeEnd;
                dr.mDrawableHeightLeft = dr.mDrawableHeightEnd;
            } 
            
            
            {
                dr.mDrawableLeft = dr.mDrawableStart;
                dr.mDrawableSizeLeft = dr.mDrawableSizeStart;
                dr.mDrawableHeightLeft = dr.mDrawableHeightStart;
            } 
            
            
            {
                dr.mDrawableRight = dr.mDrawableEnd;
                dr.mDrawableSizeRight = dr.mDrawableSizeEnd;
                dr.mDrawableHeightRight = dr.mDrawableHeightEnd;
            } 
            
        } 
        mResolvedDrawables = true;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.952 -0400", hash_original_method = "18FE12CF478DF44CED567E30FAAD0C93", hash_generated_method = "39C62916D85B160D1BFEF9F52F7B861D")
    protected void resetResolvedDrawables() {
        mResolvedDrawables = false;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.953 -0400", hash_original_method = "6AA5A1E8B49AF4D4943616613CE0B2E3", hash_generated_method = "AE99380235E5A8508B389BC8FE4FB29F")
    protected void viewClicked(InputMethodManager imm) {
        {
            imm.viewClicked(this);
        } 
        addTaint(imm.getTaint());
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.953 -0400", hash_original_method = "D7BCF3915857A038F77C712DE4BFFF5D", hash_generated_method = "82D977B2A2E9A7D66975A67958B763D7")
    protected void deleteText_internal(int start, int end) {
        ((Editable) mText).delete(start, end);
        addTaint(start);
        addTaint(end);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.954 -0400", hash_original_method = "2F865B1F2B94D9294078802BAAEABE19", hash_generated_method = "884437AAC7B453870CDA538B82876073")
    protected void replaceText_internal(int start, int end, CharSequence text) {
        ((Editable) mText).replace(start, end, text);
        addTaint(start);
        addTaint(end);
        addTaint(text.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.954 -0400", hash_original_method = "80E41DC8CAFBEBBFCDBF175A54ED075C", hash_generated_method = "5CBE479DCFA40B66FFE91CE94BCF364D")
    protected void setSpan_internal(Object span, int start, int end, int flags) {
        ((Editable) mText).setSpan(span, start, end, flags);
        addTaint(span.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(flags);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.954 -0400", hash_original_method = "ED942619162EB0C0AFB16CB348D15185", hash_generated_method = "643FB61F97017861D5294251D2E84E6E")
    protected void setCursorPosition_internal(int start, int end) {
        Selection.setSelection(((Editable) mText), start, end);
        addTaint(start);
        addTaint(end);
        
        
    }

    
    static class Drawables {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.954 -0400", hash_original_field = "74C57594A7956D89EE8B0E12D6641E99", hash_generated_field = "DE8F04160588686525A3D8B15BC2DFE8")

        final Rect mCompoundRect = new Rect();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.954 -0400", hash_original_field = "0C7DD96235E9F9762942299197287CDE", hash_generated_field = "EA47CEDDDC7FEEFF8968F16759D386B7")

        Drawable mDrawableTop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.954 -0400", hash_original_field = "FFC9598591962399CC8E8DA93075B1FF", hash_generated_field = "95D5EBB5A7DB907B0D10BA6FCACBEB79")

        Drawable mDrawableBottom;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.954 -0400", hash_original_field = "449D3E5B49321EA02E52964E3AD5E600", hash_generated_field = "E0F354AEDF5B6392510E8BF8351EC72A")

        Drawable mDrawableLeft;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.954 -0400", hash_original_field = "E63FC6EB4CF70CF1E79E34F4802DD068", hash_generated_field = "DEB85B9558F1DB613F21ACF47C293916")

        Drawable mDrawableRight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.954 -0400", hash_original_field = "89A4C538AC75F9C8F89ECA933AF96BAC", hash_generated_field = "B1620A6A345278DE80A9BA4900B11475")

        Drawable mDrawableStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "6A5FA7C04A36BE708BEA6972E6A10C46", hash_generated_field = "ACC539430A5F08E0F28AB3BE40D0952D")

        Drawable mDrawableEnd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "7D9F9A3BD601360DABB13C24EDE31952", hash_generated_field = "11854D143E60E009B90CD1FF8A02DEE3")

        int mDrawableSizeTop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "5EF68820BA8AD14D3920D191E438FBDF", hash_generated_field = "16E3A7AF686EC0516100ECED818E8EBA")

        int mDrawableSizeBottom;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "8DF66E67AC6A7270297B2C5293CA4A1E", hash_generated_field = "9140D35B31C4D61223B6173C166B3B31")

        int mDrawableSizeLeft;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "2BF66DDDC1E0C702D032E0065415C285", hash_generated_field = "D5565D3AC427749F2C0140A5168ACEC1")

        int mDrawableSizeRight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "BC24A3002B0209BBAD6B5107B8C2EA00", hash_generated_field = "400EC481934DD8ABF5A430FF208AE483")

        int mDrawableSizeStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "7A0964DB19BD292930633D81D5FE202A", hash_generated_field = "FC1E40A21375A985A535463B1946D0C4")

        int mDrawableSizeEnd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "D200C09B8E1D61364C5957FCD8230942", hash_generated_field = "F24DC8D9531D637A0AFC8D7ABA047F75")

        int mDrawableWidthTop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "E5BC5ECE7466DFCB1D39A398C2C574A1", hash_generated_field = "3EE0808C0F345FDF9EFA159F089ADA7B")

        int mDrawableWidthBottom;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "875C159AC4F13BDACAA64D85FCF9101B", hash_generated_field = "F4D603ED5E02DAD268A97E78155D65C1")

        int mDrawableHeightLeft;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "D0C439D856EBC4A4B843E9FB48AFDB7F", hash_generated_field = "13D419316EC5090DDF8A1B991D8C5815")

        int mDrawableHeightRight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "733346E69602A23B6E0712C7624F8348", hash_generated_field = "BEF3751E3F03DC5BEF12658362370AC3")

        int mDrawableHeightStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "E6A25620EDEE5CEC3B3C35B3F7640BFF", hash_generated_field = "6D5FC4CA6674578E6C48F812EBFBEB45")

        int mDrawableHeightEnd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "AC18734F422B9E18D85FA34BBE4F1AB9", hash_generated_field = "4B293F8E3375C5C6A3B4DDED1666F169")

        int mDrawablePadding;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_method = "8748E639EC70CC7FF4A65E9B42DA91C9", hash_generated_method = "8748E639EC70CC7FF4A65E9B42DA91C9")
        public Drawables ()
        {
            
        }


    }


    
    static class InputContentType {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "F1D416D715A94332F70BC0287731CE7F", hash_generated_field = "6219A24954430291C20C014227F0E7AC")

        int imeOptions = EditorInfo.IME_NULL;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "DEFBBD87D4F8CD9F381E3EB725415421", hash_generated_field = "E12E483301A64F5247F5B384AF8C5D04")

        String privateImeOptions;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "76C02E50E629DF1D0F1CA7C54AF496AC", hash_generated_field = "0C07741C23A7BB415A826F63EBCB78E4")

        CharSequence imeActionLabel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "D057B43F9C78BB13119BE0D27496DE69", hash_generated_field = "8D9B82A785391392ECC49B1515360CFD")

        int imeActionId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "27353006CFD751D26221E04A7928034D", hash_generated_field = "6F80A5414A80FF69E92A0BD3C0E073DC")

        Bundle extras;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "BA813182DE371DA33173902F7DCF8E39", hash_generated_field = "FBB987EFA3E5C389D064619D4166B06F")

        OnEditorActionListener onEditorActionListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "290F688C4EB819BDE29369D5AC9C7359", hash_generated_field = "94119079D0396AC6C04F22D47E6CD16C")

        boolean enterDown;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_method = "B3EB62E33A235E4F2C0FA9694799B659", hash_generated_method = "B3EB62E33A235E4F2C0FA9694799B659")
        public InputContentType ()
        {
            
        }


    }


    
    static class InputMethodState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "C068D7C92CA0B3001E3B86B6035A8ED5", hash_generated_field = "09DEDD19F4EE15AD81232C03C2E1F622")

        Rect mCursorRectInWindow = new Rect();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "89DF3EAFA94422450EB293D106F78DF0", hash_generated_field = "C70C3A106639E4B88E9E717A37688D8A")

        RectF mTmpRectF = new RectF();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "0B9EE67942FCCABC277B3D4A6655E296", hash_generated_field = "49A81A03C51B25D7E9A5C3BCA9AE957B")

        float[] mTmpOffset = new float[2];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "359DC50A098A8A050305C498165DCB8A", hash_generated_field = "FF9982DFAABD3C0DCD2EF1CD08CB60CF")

        ExtractedTextRequest mExtracting;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "E00709DBDB9C6962F1B8EC652516BA10", hash_generated_field = "63C64C7DC589F0F8C0F2D7EE456E6161")

        final ExtractedText mTmpExtracted = new ExtractedText();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "462C98157E02727571B7A747DD4C8C62", hash_generated_field = "21001EAFF7A276FB78FCAA91CB53D94F")

        int mBatchEditNesting;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "49B5E6309E54B338AAA681F087939793", hash_generated_field = "90AD8A78AE95138D386FCE8C5FEB694D")

        boolean mCursorChanged;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "16626AECCDE2F164741983CD5E6444F1", hash_generated_field = "866086E9E33AFC2E676556369B9C50CF")

        boolean mSelectionModeChanged;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "E4B4327543665AE44C5321E7C66FD5AB", hash_generated_field = "9AAC9C08BF94B94F258CADEF618638FC")

        boolean mContentChanged;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "FA977B41050645C0B88E06966F709384", hash_generated_field = "4675A60A313C032BC0FE364A0DDA2ED7")

        int mChangedStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "9A4002C6FBE401B7B9714E151801E727", hash_generated_field = "8C7E0284E9593E9DE8C552E7CF188261")

        int mChangedEnd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "625F12322D4384854704A8C6631D51D2", hash_generated_field = "D983CF835648B537298EC9705400AAB7")

        int mChangedDelta;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_method = "60FC2021DEC54591E7EA76E02BC73921", hash_generated_method = "60FC2021DEC54591E7EA76E02BC73921")
        public InputMethodState ()
        {
            
        }


    }


    
    private static enum TextAlign {
        INHERIT, GRAVITY, TEXT_START, TEXT_END, CENTER, VIEW_START, VIEW_END;
    }

    
    public static class SavedState extends BaseSavedState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "416D92C12FE86ACB3AA22B22D8269DC0", hash_generated_field = "4970E7F36D3C8378761D0E310C2396E8")

        int selStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "C8D3673FFFE33414608EBCA0E79CB992", hash_generated_field = "E27E0ADA332B9C693E53A0FBE392C373")

        int selEnd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "1CB251EC0D568DE6A929B520C4AED8D1", hash_generated_field = "0F26345BF87C16C80BAC76779863E330")

        CharSequence text;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "EBD219514CC5466F8D057D080C99356A", hash_generated_field = "C49FE4AC5327729CC90ECD7A211AF40F")

        boolean frozenWithFocus;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.955 -0400", hash_original_field = "CB5E100E5A9A3E7F6D1FD97512215282", hash_generated_field = "BF3285010BEB822EC6EFACD0340B80BF")

        CharSequence error;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.956 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "3F4F70129FCB46E4AE0D334AE4D70CF6")
          SavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.956 -0400", hash_original_method = "37D3E7AD53C42A47440A9F9D38DFF900", hash_generated_method = "05D4510A67A9B5F450EC0959442CBF33")
        private  SavedState(Parcel in) {
            super(in);
            selStart = in.readInt();
            selEnd = in.readInt();
            frozenWithFocus = (in.readInt() != 0);
            text = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
            {
                boolean var331417C59A822E59FB0B216D2F29CB47_1729258664 = (in.readInt() != 0);
                {
                    error = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
                } 
            } 
            
            
            
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.956 -0400", hash_original_method = "0917C7384BCC053D7DFEC5346FB5EF0D", hash_generated_method = "3B001DF9DF809BF35BD68E5A64A31FEE")
        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(selStart);
            out.writeInt(selEnd);
            out.writeInt(frozenWithFocus ? 1 : 0);
            TextUtils.writeToParcel(text, out, flags);
            {
                out.writeInt(0);
            } 
            {
                out.writeInt(1);
                TextUtils.writeToParcel(error, out, flags);
            } 
            addTaint(out.getTaint());
            addTaint(flags);
            
            
            
            
            
            
            
                
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.957 -0400", hash_original_method = "B2667A033A504E8795AC5B896DD98B5F", hash_generated_method = "724D6C0C96E8C8D299FC03DA27A10236")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1178462989 = null; 
            String str = "TextView.SavedState{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " start=" + selStart + " end=" + selEnd;
            {
                str += " text=" + text;
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1178462989 = str + "}";
            varB4EAC82CA7396A68D541C85D26508E83_1178462989.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1178462989;
            
            
                    
                    
            
                
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.957 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "3C65ED69ACC8B99E43F04B4C3721B494")

        @SuppressWarnings("hiding")
        public static final Parcelable.Creator<SavedState> CREATOR
                = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }


    
    private static class CharWrapper implements CharSequence, GetChars, GraphicsOperations {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.957 -0400", hash_original_field = "7C3722E3CD3CCC07C587A93513F1BB79", hash_generated_field = "20B8558AB5FD0F0B5A30B95221D68246")

        private char[] mChars;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.957 -0400", hash_original_field = "59B50EB80ABF1071654EE6DE5094E070", hash_generated_field = "D233E3389CE5D79EE6040D6A855ED4FF")

        private int mStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.957 -0400", hash_original_field = "429F431E8CD8AC287AA27460675EAEFE", hash_generated_field = "E9E17726F18BEC3E5C2C142D209555FD")

        private int mLength;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.958 -0400", hash_original_method = "91EFB0F7C01F6A5A0D8B3974D02E0951", hash_generated_method = "3E74A8A784F032BD1BA482AFCEE2CDD8")
        public  CharWrapper(char[] chars, int start, int len) {
            mChars = chars;
            mStart = start;
            mLength = len;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.958 -0400", hash_original_method = "9DC2F69D47DD9984FB3378BE28468419", hash_generated_method = "72DA95D14539877C07C287DFECCF13DC")
         void set(char[] chars, int start, int len) {
            mChars = chars;
            mStart = start;
            mLength = len;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.958 -0400", hash_original_method = "C0D624CC7CEFFAF650D54F4FB963FAF6", hash_generated_method = "2692FB228BB248459CB4B21139E93968")
        public int length() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_373333631 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_373333631;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.958 -0400", hash_original_method = "02B707818F2669493B94939B301EE67F", hash_generated_method = "CF3397C219BD2F6F1C9537A5BB64F744")
        public char charAt(int off) {
            addTaint(off);
            char varA87DEB01C5F539E6BDA34829C8EF2368_2015787049 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_2015787049;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.959 -0400", hash_original_method = "16BC7956BCD83D2479A5892A7E5C0E12", hash_generated_method = "7ECC28651FB9CEBBEBCDF949F7D6F73A")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_275842452 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_275842452 = new String(mChars, mStart, mLength);
            varB4EAC82CA7396A68D541C85D26508E83_275842452.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_275842452;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.959 -0400", hash_original_method = "BA853CED33F98EDEC6E428BC258874A3", hash_generated_method = "8CD0D0BD895FC675AEFC15CAC7977557")
        public CharSequence subSequence(int start, int end) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_496344271 = null; 
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(start + ", " + end);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_496344271 = new String(mChars, start + mStart, end - start);
            addTaint(start);
            addTaint(end);
            varB4EAC82CA7396A68D541C85D26508E83_496344271.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_496344271;
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.960 -0400", hash_original_method = "BA41D2BD366E4073F3399B79828CDD69", hash_generated_method = "0EA0003F38467FABE633E4921E417BB3")
        public void getChars(int start, int end, char[] buf, int off) {
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(start + ", " + end);
            } 
            System.arraycopy(mChars, start + mStart, buf, off, end - start);
            addTaint(start);
            addTaint(end);
            addTaint(buf[0]);
            addTaint(off);
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.960 -0400", hash_original_method = "69B7B91382C25765CF25BB95E9C19951", hash_generated_method = "51507E494D33A8046526B4D323096678")
        public void drawText(Canvas c, int start, int end,
                             float x, float y, Paint p) {
            c.drawText(mChars, start + mStart, end - start, x, y, p);
            addTaint(c.getTaint());
            addTaint(start);
            addTaint(end);
            addTaint(x);
            addTaint(y);
            addTaint(p.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.961 -0400", hash_original_method = "7645CF39D6B95BCD64DC33FB4F483F74", hash_generated_method = "063B9FCD63CC641361A9FC6A09143044")
        public void drawTextRun(Canvas c, int start, int end,
                int contextStart, int contextEnd, float x, float y, int flags, Paint p) {
            int count = end - start;
            int contextCount = contextEnd - contextStart;
            c.drawTextRun(mChars, start + mStart, count, contextStart + mStart,
                    contextCount, x, y, flags, p);
            addTaint(c.getTaint());
            addTaint(start);
            addTaint(end);
            addTaint(contextStart);
            addTaint(contextEnd);
            addTaint(x);
            addTaint(y);
            addTaint(flags);
            addTaint(p.getTaint());
            
            
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.961 -0400", hash_original_method = "4FA2C1189F8B48AEDF7B10BEDFF84543", hash_generated_method = "4B27EFA804764E85DD4DA8BA29493209")
        public float measureText(int start, int end, Paint p) {
            float var5A7F792133FF7C4A81B497C5A4720CB1_1816401338 = (p.measureText(mChars, start + mStart, end - start));
            addTaint(start);
            addTaint(end);
            addTaint(p.getTaint());
            float var546ADE640B6EDFBC8A086EF31347E768_202722306 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_202722306;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.962 -0400", hash_original_method = "E75F381DB76AB16AB72FA7895D0F4EE0", hash_generated_method = "FEE9E34DA479C69C7DC9FDD45A7CD3B3")
        public int getTextWidths(int start, int end, float[] widths, Paint p) {
            int varE3ED158C14EA094EB292BB32B5DD8EF6_251361405 = (p.getTextWidths(mChars, start + mStart, end - start, widths));
            addTaint(start);
            addTaint(end);
            addTaint(widths[0]);
            addTaint(p.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_60691706 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_60691706;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.963 -0400", hash_original_method = "8AE304950D3C27A7D6E58BA388580EF8", hash_generated_method = "F4CFC3F0283AEB61D5BD48745A0FF8E1")
        public float getTextRunAdvances(int start, int end, int contextStart,
                int contextEnd, int flags, float[] advances, int advancesIndex,
                Paint p) {
            int count = end - start;
            int contextCount = contextEnd - contextStart;
            float var95DA16B05752FC715454FE8979E745DE_1761495296 = (p.getTextRunAdvances(mChars, start + mStart, count,
                    contextStart + mStart, contextCount, flags, advances,
                    advancesIndex));
            addTaint(start);
            addTaint(end);
            addTaint(contextStart);
            addTaint(contextEnd);
            addTaint(flags);
            addTaint(advances[0]);
            addTaint(advancesIndex);
            addTaint(p.getTaint());
            float var546ADE640B6EDFBC8A086EF31347E768_497871214 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_497871214;
            
            
            
            
                    
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.963 -0400", hash_original_method = "F8F49F104CF6E56864F062F013326F8E", hash_generated_method = "EB1E09D03FDFC2182EDB93F3FD948246")
        public float getTextRunAdvances(int start, int end, int contextStart,
                int contextEnd, int flags, float[] advances, int advancesIndex,
                Paint p, int reserved) {
            int count = end - start;
            int contextCount = contextEnd - contextStart;
            float var96D3717415879B74E71057007515D708_107561399 = (p.getTextRunAdvances(mChars, start + mStart, count,
                    contextStart + mStart, contextCount, flags, advances,
                    advancesIndex, reserved));
            addTaint(start);
            addTaint(end);
            addTaint(contextStart);
            addTaint(contextEnd);
            addTaint(flags);
            addTaint(advances[0]);
            addTaint(advancesIndex);
            addTaint(p.getTaint());
            addTaint(reserved);
            float var546ADE640B6EDFBC8A086EF31347E768_926134479 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_926134479;
            
            
            
            
                    
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.964 -0400", hash_original_method = "BDCC8CC855D861C4246044B3842097FC", hash_generated_method = "629F074ACE37F327A55EB8915834594E")
        public int getTextRunCursor(int contextStart, int contextEnd, int flags,
                int offset, int cursorOpt, Paint p) {
            int contextCount = contextEnd - contextStart;
            int var068FAD7452971D895CA3E5455D974B2C_889991510 = (p.getTextRunCursor(mChars, contextStart + mStart,
                    contextCount, flags, offset + mStart, cursorOpt));
            addTaint(contextStart);
            addTaint(contextEnd);
            addTaint(flags);
            addTaint(offset);
            addTaint(cursorOpt);
            addTaint(p.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_114106737 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_114106737;
            
            
            
                    
        }

        
    }


    
    private static class ErrorPopup extends PopupWindow {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.964 -0400", hash_original_field = "7DF8B65473C97B2A69F25D9317EC3DEC", hash_generated_field = "7E17DC26D2CD570CF106F239587AB53D")

        private boolean mAbove = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.964 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "EC8812FBC96AED57B9AA8E9AC44D0DAB")

        private TextView mView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.964 -0400", hash_original_field = "A0A9CFD5067DB601801485B1E446CCDB", hash_generated_field = "950EB5B59166D035BC490D5607F4FE92")

        private int mPopupInlineErrorBackgroundId = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.964 -0400", hash_original_field = "6962B840396BC381227E36B1099A626C", hash_generated_field = "44679A20C762322AD033B0D96DF5B4A1")

        private int mPopupInlineErrorAboveBackgroundId = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.964 -0400", hash_original_method = "272870BAEDFD334116717C4E8AB7F4AA", hash_generated_method = "49481A4E68134FA555025EF0D96CB36B")
          ErrorPopup(TextView v, int width, int height) {
            super(v, width, height);
            mView = v;
            mPopupInlineErrorBackgroundId = getResourceId(mPopupInlineErrorBackgroundId,
                    com.android.internal.R.styleable.Theme_errorMessageBackground);
            mView.setBackgroundResource(mPopupInlineErrorBackgroundId);
            addTaint(width);
            addTaint(height);
            
            
            
                    
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.965 -0400", hash_original_method = "FF785E3F959B10F16CB73DE59942CDE6", hash_generated_method = "64FEBD7B79B99C13F6B9192D02A2D11F")
         void fixDirection(boolean above) {
            mAbove = above;
            {
                mPopupInlineErrorAboveBackgroundId =
                    getResourceId(mPopupInlineErrorAboveBackgroundId,
                            com.android.internal.R.styleable.Theme_errorMessageAboveBackground);
            } 
            {
                mPopupInlineErrorBackgroundId = getResourceId(mPopupInlineErrorBackgroundId,
                        com.android.internal.R.styleable.Theme_errorMessageBackground);
            } 
            mView.setBackgroundResource(above ? mPopupInlineErrorAboveBackgroundId :
                mPopupInlineErrorBackgroundId);
            
            
            
                
                    
                            
            
                
                        
            
            
                
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.965 -0400", hash_original_method = "283134609ABCFB2A4CA7FFE3B421D4C1", hash_generated_method = "AA8A531706DF43F606B87FFDE85CB77C")
        private int getResourceId(int currentId, int index) {
            {
                TypedArray styledAttributes = mView.getContext().obtainStyledAttributes(
                        R.styleable.Theme);
                currentId = styledAttributes.getResourceId(index, 0);
                styledAttributes.recycle();
            } 
            addTaint(currentId);
            addTaint(index);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1371312034 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1371312034;
            
            
                
                        
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.966 -0400", hash_original_method = "D12B38B9E303D838A7A28156EE92AFAA", hash_generated_method = "0D441F728B01A6E328692ACA9148455A")
        @Override
        public void update(int x, int y, int w, int h, boolean force) {
            super.update(x, y, w, h, force);
            boolean above = isAboveAnchor();
            {
                fixDirection(above);
            } 
            addTaint(x);
            addTaint(y);
            addTaint(w);
            addTaint(h);
            addTaint(force);
            
            
            
            
                
            
        }

        
    }


    
    private class CorrectionHighlighter {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.966 -0400", hash_original_field = "DBC2DDFC3AA0B07663EC95BA4102B76C", hash_generated_field = "1C9B38C7F9B71799B7B8F281B135448B")

        private final Path mPath = new Path();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.966 -0400", hash_original_field = "E7BA6B001D9391CCE70C3C78C53FA3AF", hash_generated_field = "72C5AF717CADB3E1B93A20C1294BD3BC")

        private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.966 -0400", hash_original_field = "59B50EB80ABF1071654EE6DE5094E070", hash_generated_field = "D233E3389CE5D79EE6040D6A855ED4FF")

        private int mStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.966 -0400", hash_original_field = "C3B248BAD041692A85BAABC024E9FDCE", hash_generated_field = "EA295975CAF8E42F4C28A87EADB358DF")

        private int mEnd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.966 -0400", hash_original_field = "BE8674259642701C85F5A18F0D1B92CD", hash_generated_field = "516150ABFF873AC5B12EBF2F659E6EFD")

        private long mFadingStartTime;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.966 -0400", hash_original_method = "76400340233C9D40D55E8C6995EBADF6", hash_generated_method = "B77926F0B0BE367B250F0A650FF30C45")
        public  CorrectionHighlighter() {
            mPaint.setCompatibilityScaling(getResources().getCompatibilityInfo().applicationScale);
            mPaint.setStyle(Paint.Style.FILL);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.966 -0400", hash_original_method = "9DA46F38DADC56BDE7EACA06EAFC15FB", hash_generated_method = "C243A91017672BB7839F484D952028CC")
        public void highlight(CorrectionInfo info) {
            mStart = info.getOffset();
            mEnd = mStart + info.getNewText().length();
            mFadingStartTime = SystemClock.uptimeMillis();
            {
                stopAnimation();
            } 
            
            
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.967 -0400", hash_original_method = "F315418B1425EA36D28AB47D63F906BC", hash_generated_method = "C5A2741CD095890C1AD2134618AA4D0D")
        public void draw(Canvas canvas, int cursorOffsetVertical) {
            {
                boolean var4DB6C275C605DA5ED2D731F7F8E79A54_554096592 = (updatePath() && updatePaint());
                {
                    {
                        canvas.translate(0, cursorOffsetVertical);
                    } 
                    canvas.drawPath(mPath, mPaint);
                    {
                        canvas.translate(0, -cursorOffsetVertical);
                    } 
                    invalidate(true);
                } 
                {
                    stopAnimation();
                    invalidate(false);
                } 
            } 
            addTaint(canvas.getTaint());
            addTaint(cursorOffsetVertical);
            
            
                
                    
                
                
                
                    
                
                
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.967 -0400", hash_original_method = "5CBDA1AAE290DD8920EE208B7E44B556", hash_generated_method = "0EE5307CD047FAAEB9F9AC7DD38F26DE")
        private boolean updatePaint() {
            final long duration = SystemClock.uptimeMillis() - mFadingStartTime;
            final float coef = 1.0f - (float) duration / FADE_OUT_DURATION;
            final int highlightColorAlpha = Color.alpha(mHighlightColor);
            final int color = (mHighlightColor & 0x00FFFFFF) +
                    ((int) (highlightColorAlpha * coef) << 24);
            mPaint.setColor(color);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_857140333 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_857140333;
            
            
            
            
            
            
                    
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.967 -0400", hash_original_method = "77DEEE2C70776896B8DA6C9B8DAC8452", hash_generated_method = "55E2D482278B087892EF7ADC24BF85D8")
        private boolean updatePath() {
            final Layout layout = TextView.this.mLayout;
            final int length = mText.length();
            int start = Math.min(length, mStart);
            int end = Math.min(length, mEnd);
            mPath.reset();
            TextView.this.mLayout.getSelectionPath(start, end, mPath);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1546915269 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1546915269;
            
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.968 -0400", hash_original_method = "E7B5FD6BE43D84566E63BFC892235B90", hash_generated_method = "7A81BB37C2E028D7A4675CB8FFE5E23E")
        private void invalidate(boolean delayed) {
            {
                boolean var21FA9EC81F38017B1959E255822905B7_208027512 = (TextView.this.mLayout == null);
            } 
            {
                mPath.computeBounds(sTempRect, false);
                int left = getCompoundPaddingLeft();
                int top = getExtendedPaddingTop() + getVerticalOffset(true);
                {
                    TextView.this.postInvalidateDelayed(16, 
                            left + (int) sTempRect.left, top + (int) sTempRect.top,
                            left + (int) sTempRect.right, top + (int) sTempRect.bottom);
                } 
                {
                    TextView.this.postInvalidate((int) sTempRect.left, (int) sTempRect.top,
                            (int) sTempRect.right, (int) sTempRect.bottom);
                } 
            } 
            addTaint(delayed);
            
            
            
                
                
                
                
                    
                            
                            
                
                    
                            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.968 -0400", hash_original_method = "4BD6A36A746D13E089BD00A9CC0A6FB7", hash_generated_method = "78D02156987325E73BE90677BD5A4AF4")
        private void stopAnimation() {
            TextView.this.mCorrectionHighlighter = null;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.968 -0400", hash_original_field = "5BBBF8F997ACE9A57CB3491DCAF1B12E", hash_generated_field = "BE8E612E603608AA1A116A2C67EC5B99")

        private final static int FADE_OUT_DURATION = 400;
    }


    
    private static final class Marquee extends Handler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.968 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "378CC9BF8F5DA198EF400A97F72A70A3")

        private WeakReference<TextView> mView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.968 -0400", hash_original_field = "4704E97CC036B299FAC82F1786745C27", hash_generated_field = "E1F826A18833675CAA3F20EBBCB74E63")

        private byte mStatus = MARQUEE_STOPPED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.968 -0400", hash_original_field = "0AD263692B7453D1CADEF9C0002D8D7E", hash_generated_field = "F7B50A7445EB5AE7B4AED021C79A3798")

        private float mScrollUnit;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.968 -0400", hash_original_field = "73E7117FC717C5779EFE316E1A54EFF7", hash_generated_field = "01E3791EB1346C97E47507148C4BA197")

        private float mMaxScroll;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.968 -0400", hash_original_field = "48D13BF0748D58A28F6C563805C3AA25", hash_generated_field = "60FE7DDBA197AB2FD49DEEDB9A0234B2")

        float mMaxFadeScroll;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.968 -0400", hash_original_field = "72795809679CC0D4D2ECD064DBC450D5", hash_generated_field = "A1B75D52F4336D0AD351EB697147DDEE")

        private float mGhostStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.968 -0400", hash_original_field = "45F31C063DD4B9215C31432A52D6D16F", hash_generated_field = "F191C5ED756AC66F521DCB9604BE3690")

        private float mGhostOffset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.968 -0400", hash_original_field = "6B507C89547F9268ECF8CAA3066483D0", hash_generated_field = "64343518D38D9F055C2F10972107CF16")

        private float mFadeStop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.968 -0400", hash_original_field = "5BD21E806EB8AC9E0439CEE0F1945029", hash_generated_field = "4382F6070B0A1518DE23E4DA7693EF55")

        private int mRepeatLimit;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.968 -0400", hash_original_field = "D9E346D7C0C44D38F8B4D76282E9C096", hash_generated_field = "C7F848EDC5F556B007801A6A62728CC6")

        float mScroll;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.969 -0400", hash_original_method = "EC19D4EFFC7CC18F674B4C588B8FB87B", hash_generated_method = "5ACDC9399C65F3DC796FCFD5CE2E9B57")
          Marquee(TextView v) {
            final float density = v.getContext().getResources().getDisplayMetrics().density;
            mScrollUnit = (MARQUEE_PIXELS_PER_SECOND * density) / MARQUEE_RESOLUTION;
            mView = new WeakReference<TextView>(v);
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.969 -0400", hash_original_method = "6484E5DEDF9A6D25913C9D3BAE668871", hash_generated_method = "37F63ACB636731FA8D89FC97A4833083")
        @Override
        public void handleMessage(Message msg) {
            
            mStatus = MARQUEE_RUNNING;
            
            
            tick();
            
            
            tick();
            
            
            {
                start(mRepeatLimit);
            } 
            
            addTaint(msg.getTaint());
            
            
                
                    
                    
                    
                
                    
                    
                
                    
                        
                            
                        
                        
                    
                    
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.970 -0400", hash_original_method = "EE95900433272316B4E2225B22ADF455", hash_generated_method = "1843CA748175DC34A23D4FA0BAFBFDAA")
         void tick() {
            removeMessages(MESSAGE_TICK);
            final TextView textView = mView.get();
            {
                boolean var9E991AA08531BDDAB4E605F21C288264_1099092088 = (textView != null && (textView.isFocused() || textView.isSelected()));
                {
                    mScroll += mScrollUnit;
                    {
                        mScroll = mMaxScroll;
                        sendEmptyMessageDelayed(MESSAGE_RESTART, MARQUEE_RESTART_DELAY);
                    } 
                    {
                        sendEmptyMessageDelayed(MESSAGE_TICK, MARQUEE_RESOLUTION);
                    } 
                    textView.invalidate();
                } 
            } 
            
            
                
            
            
            
            
                
                
                    
                    
                
                    
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.970 -0400", hash_original_method = "559B799FFC0EAE80362A4924AC6B387F", hash_generated_method = "AEBFA0DC15336E07980941BA4CDDF3E1")
         void stop() {
            mStatus = MARQUEE_STOPPED;
            removeMessages(MESSAGE_START);
            removeMessages(MESSAGE_RESTART);
            removeMessages(MESSAGE_TICK);
            resetScroll();
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.970 -0400", hash_original_method = "E75276DE0DCFDFD0F42F697FF2F53A01", hash_generated_method = "5E7BB047D00544EE181348D457F66A2A")
        private void resetScroll() {
            mScroll = 0.0f;
            final TextView textView = mView.get();
            textView.invalidate();
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.971 -0400", hash_original_method = "C8CF1974A44593F9FA59199A16CE27AD", hash_generated_method = "116BEA859EF9D764426FBD63EFDE230E")
         void start(int repeatLimit) {
            {
                stop();
            } 
            mRepeatLimit = repeatLimit;
            final TextView textView = mView.get();
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
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.971 -0400", hash_original_method = "8BEDD434588E893B08521C1E5E937982", hash_generated_method = "C20C4CAF7AAB242136B44D071F5F2B83")
         float getGhostOffset() {
            float var546ADE640B6EDFBC8A086EF31347E768_711890163 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_711890163;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.972 -0400", hash_original_method = "FBB73F0BC2F425DEBE19335413BBBBD5", hash_generated_method = "907AC04B54D7EB75D58FB67D8CB9309C")
         boolean shouldDrawLeftFade() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1714212977 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1714212977;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.973 -0400", hash_original_method = "297E21CB54951ECF2F6E26FAB2DC7036", hash_generated_method = "2B010A973521A0B9107CB92B60128BA1")
         boolean shouldDrawGhost() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1827075139 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1827075139;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.973 -0400", hash_original_method = "9069B9288EAB1BBCE4A11291BAF7E3F4", hash_generated_method = "EC165BBA864139A3BEA35B7C68378363")
         boolean isRunning() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_596888203 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_596888203;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.974 -0400", hash_original_method = "57F6027DED5DA77924B224C2BB22701E", hash_generated_method = "AB901573DD0B746312EFAF9D327F1396")
         boolean isStopped() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1455245548 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1455245548;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.974 -0400", hash_original_field = "6AC58C16DFF7294B5A4A431E14108EC2", hash_generated_field = "8C251E17630B365D009996AD47B2DD3C")

        private static final float MARQUEE_DELTA_MAX = 0.07f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.974 -0400", hash_original_field = "E4728EDDA8B3D2C91D4624E788111E01", hash_generated_field = "35927BC6057D4173F3812056640AA204")

        private static final int MARQUEE_DELAY = 1200;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.974 -0400", hash_original_field = "3B4EF5CF2B395DE1542F2D8F5DFC67D7", hash_generated_field = "A480DE8D7F8C3DD06D7F56FDCF1785D2")

        private static final int MARQUEE_RESTART_DELAY = 1200;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.974 -0400", hash_original_field = "8B25855C58895BDA613FD9FD4275C244", hash_generated_field = "FB93BB56AFDF6E4B8D61ECD57E059D47")

        private static final int MARQUEE_RESOLUTION = 1000 / 30;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.974 -0400", hash_original_field = "CC2183A454A8CF823D5EB4FBCB7AB848", hash_generated_field = "B05A9FDC59FD134B7233CD4AFE4BE285")

        private static final int MARQUEE_PIXELS_PER_SECOND = 30;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.974 -0400", hash_original_field = "83CB05D0724C63AFF22CF998C0771186", hash_generated_field = "84F62194C3706C2DA47D02768AFB5267")

        private static final byte MARQUEE_STOPPED = 0x0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.974 -0400", hash_original_field = "524F0584151994C79B9191730415DC22", hash_generated_field = "BE8444FCF06CF4D0AF51FD248A85AAC9")

        private static final byte MARQUEE_STARTING = 0x1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.974 -0400", hash_original_field = "1E99F17DD0A7ACAF311564610127CEBC", hash_generated_field = "5524003C352475E0FE9851B8CCD129C6")

        private static final byte MARQUEE_RUNNING = 0x2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.974 -0400", hash_original_field = "D45CAA01F64232AF582D5B7E05E9FD00", hash_generated_field = "CB5FC73826DDCE47D2749061356148BA")

        private static final int MESSAGE_START = 0x1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.974 -0400", hash_original_field = "03DF5DD145AC4F2C9B8B8DE9EB6C0135", hash_generated_field = "FAB12A799FD1570304AC952DCE5A469B")

        private static final int MESSAGE_TICK = 0x2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.974 -0400", hash_original_field = "CDACA6038BA86AB9AABBD482EB6DF6F1", hash_generated_field = "BB4587B4AB1E5F07B03C638733286E8C")

        private static final int MESSAGE_RESTART = 0x3;
    }


    
    private class EasyEditSpanController {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.974 -0400", hash_original_field = "BF75305BD1095CDED8E2337DB678670B", hash_generated_field = "93AE44B2D9F293D0BC2408DE643B7037")

        private EasyEditPopupWindow mPopupWindow;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.974 -0400", hash_original_field = "EDF25D09739D26EF9ECAF542864CC487", hash_generated_field = "D79D9256BE9491F92C92FB8BCC6A61DC")

        private EasyEditSpan mEasyEditSpan;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.974 -0400", hash_original_field = "6613F0388A136327FDBD8526D1D89DBF", hash_generated_field = "EE65FA1568E5725BCA3859DE8F52F788")

        private Runnable mHidePopup;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.974 -0400", hash_original_method = "2E07A306089CEDB8C207DEEB8EF7B36E", hash_generated_method = "2E07A306089CEDB8C207DEEB8EF7B36E")
        public EasyEditSpanController ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.974 -0400", hash_original_method = "EDC90536D8A41E1495260C5D2B0A4CB4", hash_generated_method = "D5E089DE56B1FB79DD2F6BF40F47DD08")
        private void hide() {
            {
                mPopupWindow.hide();
                TextView.this.removeCallbacks(mHidePopup);
            } 
            removeSpans(mText);
            mEasyEditSpan = null;
            
            
                
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.975 -0400", hash_original_method = "400D6F397C7E694E5D2CC26E5076AFF1", hash_generated_method = "C62556D9902D9AB8E0A8FBB4E0609F4A")
        public void onTextChange(CharSequence buffer) {
            
            adjustSpans(mText);
            {
                boolean varF8A6C8295E7EAA2547FD83421DD5A52E_1989723117 = (getWindowVisibility() != View.VISIBLE);
            } 
            InputMethodManager imm = InputMethodManager.peekInstance();
            {
                boolean var508564AC928822EB83F33B379556AE9E_1810688526 = (!(TextView.this instanceof ExtractEditText)
                    && imm != null && imm.isFullscreenMode());
            } 
            {
                {
                    ((Spannable) mText).removeSpan(mEasyEditSpan);
                } 
                mEasyEditSpan = null;
            } 
            {
                boolean varB1ED909A9B3812E269C4F5A19320975C_62885411 = (mPopupWindow != null && mPopupWindow.isShowing());
                {
                    mPopupWindow.hide();
                } 
            } 
            {
                mEasyEditSpan = getSpan((Spanned) buffer);
                {
                    {
                        mPopupWindow = new EasyEditPopupWindow();
                        mHidePopup = new Runnable() {                            
                            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.975 -0400", hash_original_method = "21815FA27ABEB649DED6A46E4F97905B", hash_generated_method = "891AC471650FB94DC3945684A90962FE")
                            @Override
                            public void run() {
                                hide();
                                
                                
                            }
};
                    } 
                    mPopupWindow.show(mEasyEditSpan);
                    TextView.this.removeCallbacks(mHidePopup);
                    TextView.this.postDelayed(mHidePopup, DISPLAY_TIMEOUT_MS);
                } 
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.976 -0400", hash_original_method = "BE935C64EC56548296E167AABD21FC2C", hash_generated_method = "DE4929F46D55D72D1BDC8B227D700FFD")
        private void adjustSpans(CharSequence buffer) {
            {
                Spannable spannable = (Spannable) buffer;
                EasyEditSpan[] spans = spannable.getSpans(0, spannable.length(),
                        EasyEditSpan.class);
                {
                    int i = 0;
                    {
                        spannable.removeSpan(spans[i]);
                    } 
                } 
            } 
            addTaint(buffer.getTaint());
            
            
                
                
                        
                
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.976 -0400", hash_original_method = "D4568FCB8F606B40F32BB2FF24EF8AE2", hash_generated_method = "177BB84E41F3470A539BBFBF53219F94")
        private void removeSpans(CharSequence buffer) {
            {
                Spannable spannable = (Spannable) buffer;
                EasyEditSpan[] spans = spannable.getSpans(0, spannable.length(),
                        EasyEditSpan.class);
                {
                    int i = 0;
                    {
                        spannable.removeSpan(spans[i]);
                    } 
                } 
            } 
            addTaint(buffer.getTaint());
            
            
                
                
                        
                
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.977 -0400", hash_original_method = "FD0036F1377269974D72D9C2BC2EFAA3", hash_generated_method = "F02CCF038B9E4EDB03DB5EB9E9F787A0")
        private EasyEditSpan getSpan(Spanned spanned) {
            EasyEditSpan varB4EAC82CA7396A68D541C85D26508E83_2000609222 = null; 
            EasyEditSpan varB4EAC82CA7396A68D541C85D26508E83_1292604388 = null; 
            EasyEditSpan[] easyEditSpans = spanned.getSpans(0, spanned.length(),
                    EasyEditSpan.class);
            {
                varB4EAC82CA7396A68D541C85D26508E83_2000609222 = null;
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1292604388 = easyEditSpans[0];
            } 
            addTaint(spanned.getTaint());
            EasyEditSpan varA7E53CE21691AB073D9660D615818899_406235807; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_406235807 = varB4EAC82CA7396A68D541C85D26508E83_2000609222;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_406235807 = varB4EAC82CA7396A68D541C85D26508E83_1292604388;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_406235807.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_406235807;
            
            
                    
            
                
            
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.977 -0400", hash_original_field = "518CAC1482FD68AED9B6AA4AE599C5BA", hash_generated_field = "50759637C8B37D549CBDCF2AF0EA1F75")

        private static final int DISPLAY_TIMEOUT_MS = 3000;
    }


    
    private class EasyEditPopupWindow extends PinnedPopupWindow implements OnClickListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.977 -0400", hash_original_field = "2BA836DA894A791F59023D6C9F9022B2", hash_generated_field = "4DBBAC6216F3AE0A070BCCEDE828B9C4")

        private TextView mDeleteTextView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.977 -0400", hash_original_field = "EDF25D09739D26EF9ECAF542864CC487", hash_generated_field = "D79D9256BE9491F92C92FB8BCC6A61DC")

        private EasyEditSpan mEasyEditSpan;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.977 -0400", hash_original_method = "8F35ACDDC3336F80EA4BC14F76358073", hash_generated_method = "8F35ACDDC3336F80EA4BC14F76358073")
        public EasyEditPopupWindow ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.977 -0400", hash_original_method = "57DC4A0271DC22A49F19ED5E582C7E72", hash_generated_method = "B54116FA46C572BBDB8F1D27160DF59E")
        @Override
        protected void createPopupWindow() {
            mPopupWindow = new PopupWindow(TextView.this.mContext, null,
                    com.android.internal.R.attr.textSelectHandleWindowStyle);
            mPopupWindow.setInputMethodMode(PopupWindow.INPUT_METHOD_NOT_NEEDED);
            mPopupWindow.setClippingEnabled(true);
            
            
                    
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.978 -0400", hash_original_method = "128C0E079A8A50F8B38C36065ADCA0D3", hash_generated_method = "707EC4B09478980B230E9C634DE61A7E")
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
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.978 -0400", hash_original_method = "EB30ECB06A4982701AF1B8E86934D288", hash_generated_method = "6C6061653D5DFF66F75183D85AEDB5A1")
        public void show(EasyEditSpan easyEditSpan) {
            mEasyEditSpan = easyEditSpan;
            super.show();
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.978 -0400", hash_original_method = "C063208218D3B6E27F261A5578D5D2B9", hash_generated_method = "3602D49F1F67871F65EDF5323582F338")
        @Override
        public void onClick(View view) {
            
            {
                Editable editable = (Editable) mText;
                int start = editable.getSpanStart(mEasyEditSpan);
                int end = editable.getSpanEnd(mEasyEditSpan);
                {
                    deleteText_internal(start, end);
                } 
            } 
            addTaint(view.getTaint());
            
            
                
                
                
                
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.979 -0400", hash_original_method = "7C1AF53FA575FE23CA1F61E7AC0FA9D9", hash_generated_method = "BB81DBE76B6BEFB0624C807A222EBE66")
        @Override
        protected int getTextOffset() {
            Editable editable = (Editable) mText;
            int var250A5466B0BCD45EA6B6F640A95FFADA_1650969763 = (editable.getSpanEnd(mEasyEditSpan));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1926811154 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1926811154;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.979 -0400", hash_original_method = "87FFA2F036D6FB2F317732DF596E05CB", hash_generated_method = "815FFB75CBFAF3006434BDB849043A9A")
        @Override
        protected int getVerticalLocalPosition(int line) {
            int varC530C119C90DEC1E0FFF523326A5138A_1927202447 = (mLayout.getLineBottom(line));
            addTaint(line);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1183102153 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1183102153;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.979 -0400", hash_original_method = "48C7510506F753F88F1EBACB4F114059", hash_generated_method = "C98F2544657F2C9A497F5E0EE39DBB6F")
        @Override
        protected int clipVertically(int positionY) {
            addTaint(positionY);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1127068075 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1127068075;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.979 -0400", hash_original_field = "A8B4CFDAA994C026529F1F31A401F449", hash_generated_field = "9556C9F4A76B40115A0F30878921C774")

        private static final int POPUP_TEXT_LAYOUT = com.android.internal.R.layout.text_edit_action_popup_text;
    }


    
    private class ChangeWatcher implements TextWatcher, SpanWatcher {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.979 -0400", hash_original_field = "8F45542597C289D2929CD8F63821BE5A", hash_generated_field = "9AF7D20EAE94D8E70217DF1DC0F4EBF6")

        private CharSequence mBeforeText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.979 -0400", hash_original_field = "9E7C9CD25D6914A1724D16D10C6EB9C1", hash_generated_field = "B09D56552589EA59BDE2FAB6B8B27882")

        private EasyEditSpanController mEasyEditSpanController;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.980 -0400", hash_original_method = "41973225A14E12423F2683848135C141", hash_generated_method = "ACD55DB72B049A56A0B6E74650948667")
        private  ChangeWatcher() {
            mEasyEditSpanController = new EasyEditSpanController();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.980 -0400", hash_original_method = "720D371807084B06633282B0029EC53C", hash_generated_method = "A2A4A1E214D5383130BD2E4AC504A022")
        public void beforeTextChanged(CharSequence buffer, int start,
                                      int before, int after) {
            {
                boolean var58E0C133E73001AE9B82AF19F4A709BD_2061622703 = (AccessibilityManager.getInstance(mContext).isEnabled()
                    && !isPasswordInputType(mInputType)
                    && !hasPasswordTransformationMethod());
                {
                    mBeforeText = buffer.toString();
                } 
            } 
            TextView.this.sendBeforeTextChanged(buffer, start, before, after);
            addTaint(start);
            addTaint(before);
            addTaint(after);
            
            
                    
            
                    
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.981 -0400", hash_original_method = "94F338CF670251E301395B1B01A5E75A", hash_generated_method = "288727809B23F86CD8CE4F360236197B")
        public void onTextChanged(CharSequence buffer, int start,
                                  int before, int after) {
            
            TextView.this.handleTextChanged(buffer, start, before, after);
            mEasyEditSpanController.onTextChange(buffer);
            {
                boolean var2CE54939AB34C356367D1A2596516E7D_129564721 = (AccessibilityManager.getInstance(mContext).isEnabled() &&
                    (isFocused() || isSelected() && isShown()));
                {
                    sendAccessibilityEventTypeViewTextChanged(mBeforeText, start, before, after);
                    mBeforeText = null;
                } 
            } 
            addTaint(buffer.getTaint());
            addTaint(start);
            addTaint(before);
            addTaint(after);
            
            
                    
            
            
            
                    
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.981 -0400", hash_original_method = "36BCFC0FC76553AA6F29D2F790EC381C", hash_generated_method = "E2342A2661C019B08F7B1061B9D27DDE")
        public void afterTextChanged(Editable buffer) {
            TextView.this.sendAfterTextChanged(buffer);
            {
                boolean varD9AAC580C15E35EE8A21660BC6977A2B_276188190 = (MetaKeyKeyListener.getMetaState(buffer, MetaKeyKeyListener.META_SELECTING) != 0);
                {
                    MetaKeyKeyListener.stopSelecting(TextView.this, buffer);
                } 
            } 
            addTaint(buffer.getTaint());
            
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.982 -0400", hash_original_method = "6F9EDB470C5AD5F1E23596AFEC700ED3", hash_generated_method = "B7F6FF672D019D3885D6E7BE0DED86AB")
        public void onSpanChanged(Spannable buf,
                                  Object what, int s, int e, int st, int en) {
            
            TextView.this.spanChange(buf, what, s, st, e, en);
            addTaint(buf.getTaint());
            addTaint(what.getTaint());
            addTaint(s);
            addTaint(e);
            addTaint(st);
            addTaint(en);
            
            
                    
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.983 -0400", hash_original_method = "B2A75CCE31AAD63896365B7E450A433A", hash_generated_method = "28579E6C19D5D69D3CDB51F823A3EE03")
        public void onSpanAdded(Spannable buf, Object what, int s, int e) {
            
            TextView.this.spanChange(buf, what, -1, s, -1, e);
            addTaint(buf.getTaint());
            addTaint(what.getTaint());
            addTaint(s);
            addTaint(e);
            
            
                    
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.984 -0400", hash_original_method = "11DC5396F5D4F6210F8F1D677B03B553", hash_generated_method = "F5A56804D6D5F23A672E7B91E296AC47")
        public void onSpanRemoved(Spannable buf, Object what, int s, int e) {
            
            TextView.this.spanChange(buf, what, s, -1, e, -1);
            addTaint(buf.getTaint());
            addTaint(what.getTaint());
            addTaint(s);
            addTaint(e);
            
            
                    
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.984 -0400", hash_original_method = "FB97DDA9E5EB9C645F7C42D5DCEE1A36", hash_generated_method = "E6D7B22DFBEA218F7C05A2FD98CE4F0E")
        private void hideControllers() {
            mEasyEditSpanController.hide();
            
            
        }

        
    }


    
    private static class Blink extends Handler implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.984 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "378CC9BF8F5DA198EF400A97F72A70A3")

        private WeakReference<TextView> mView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.984 -0400", hash_original_field = "1813307BAF5C3869F23F1AC0318DE4BE", hash_generated_field = "582F041564D3B399F48E8AE230C16FEE")

        private boolean mCancelled;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.984 -0400", hash_original_method = "B3B341EB4735766A8EE81E50FC9FCC5D", hash_generated_method = "AC11D259FD065166E4248B5E715529DE")
        public  Blink(TextView v) {
            mView = new WeakReference<TextView>(v);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.985 -0400", hash_original_method = "ACD5284757446306F2E6E1BADED5158A", hash_generated_method = "1D602972DFDE3FE0D11EF01DEF50C580")
        public void run() {
            removeCallbacks(Blink.this);
            TextView tv = mView.get();
            {
                boolean var397A686FF4DC8BC40834AF9DD4FC6DD1_1250544145 = (tv != null && tv.shouldBlink());
                {
                    {
                        tv.invalidateCursorPath();
                    } 
                    postAtTime(this, SystemClock.uptimeMillis() + BLINK);
                } 
            } 
            
            
                
            
            
            
            
                
                    
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.985 -0400", hash_original_method = "A015A25EF128A9724656D77FE5A94B9E", hash_generated_method = "CB1FFD1BF8FD38BFCDE2C9951972BDB6")
         void cancel() {
            {
                removeCallbacks(Blink.this);
                mCancelled = true;
            } 
            
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.985 -0400", hash_original_method = "A06944554EAF73141DA4277B06D0E2BD", hash_generated_method = "EA43542F6DD16B86D3EB9C7A9CB5E56B")
         void uncancel() {
            mCancelled = false;
            
            
        }

        
    }


    
    public enum BufferType {
        NORMAL, SPANNABLE, EDITABLE,
    }

    
    private static class DragLocalState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.986 -0400", hash_original_field = "D78BADC424EA34A1D9F76B53AD0FC966", hash_generated_field = "71C1F40F965BD09DE6D53C89B0AA9A2B")

        public TextView sourceTextView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.986 -0400", hash_original_field = "EA2B2676C28C0DB26D39331A336C6B92", hash_generated_field = "D3D73C9CC2FDA0D0E8781D6E9A3253AA")

        public int start;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.986 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "109F16BFAE7B1E88A50CE09673D176EC")

        public int end;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.986 -0400", hash_original_method = "78F248ABC93BE1F7C9E297B91A3F7D55", hash_generated_method = "86EC9C6CD36D42E4BFA57141505C8082")
        public  DragLocalState(TextView sourceTextView, int start, int end) {
            this.sourceTextView = sourceTextView;
            this.start = start;
            this.end = end;
            
            
            
            
        }

        
    }


    
    private class PositionListener implements ViewTreeObserver.OnPreDrawListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.986 -0400", hash_original_field = "05B14654782AB408227B39473652C629", hash_generated_field = "13889737161965075C942E574375D7C9")

        private final int MAXIMUM_NUMBER_OF_LISTENERS = 6;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.986 -0400", hash_original_field = "501DACB43832A22DCD15C3BD00A05F36", hash_generated_field = "6E86BBFEE5AB32BEC4338815D88DA562")

        private TextViewPositionListener[] mPositionListeners = new TextViewPositionListener[MAXIMUM_NUMBER_OF_LISTENERS];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.986 -0400", hash_original_field = "16BC92FD11AF81D9886E550CE0712C57", hash_generated_field = "E1EB7F48AC3DAF5A3BC279FE32D5BD2C")

        private boolean mCanMove[] = new boolean[MAXIMUM_NUMBER_OF_LISTENERS];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.986 -0400", hash_original_field = "03D5F02C0AF2CE2B038F91466D8238BA", hash_generated_field = "348E54253A3677FA237DAA94481A3907")

        private boolean mPositionHasChanged = true;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.986 -0400", hash_original_field = "E33EA5C4D485469D2432B3A781CD5014", hash_generated_field = "B562606C08FEFE4EA880E0BAFC4807BC")

        private int mPositionX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.986 -0400", hash_original_field = "5EF2225F886100AA279B39F41428F3C5", hash_generated_field = "30733FB91B36B499B68F008F42192052")

        private int mPositionY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.986 -0400", hash_original_field = "9EDA655FC50499AF5231120C47804B4D", hash_generated_field = "3FFCBF0CA982B9F89F06AD1BE7BFADF1")

        private int mNumberOfListeners;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.986 -0400", hash_original_field = "C40349F37B1FBD37DCE18B5033BE6961", hash_generated_field = "165D6DE2599A80133D2595B1A8A737DE")

        private boolean mScrollHasChanged;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.986 -0400", hash_original_method = "7156A70387EDCE5A8031F9E196BAE1E0", hash_generated_method = "7156A70387EDCE5A8031F9E196BAE1E0")
        public PositionListener ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.987 -0400", hash_original_method = "2CEF91B445974B7F0C1F2F2831D38171", hash_generated_method = "B64942BE3B5A84B42129859325FED038")
        public void addSubscriber(TextViewPositionListener positionListener, boolean canMove) {
            {
                updatePosition();
                ViewTreeObserver vto = TextView.this.getViewTreeObserver();
                vto.addOnPreDrawListener(this);
            } 
            int emptySlotIndex = -1;
            {
                int i = 0;
                {
                    TextViewPositionListener listener = mPositionListeners[i];
                    {
                        emptySlotIndex = i;
                    } 
                } 
            } 
            mPositionListeners[emptySlotIndex] = positionListener;
            mCanMove[emptySlotIndex] = canMove;
            
            
                
                
                
            
            
            
                
                
                    
                
                    
                
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.987 -0400", hash_original_method = "F36C99880C8165921A7F03E512CBB647", hash_generated_method = "41FB7C9BBEEEC189C96E46CD2480DA81")
        public void removeSubscriber(TextViewPositionListener positionListener) {
            {
                int i = 0;
                {
                    {
                        mPositionListeners[i] = null;
                    } 
                } 
            } 
            {
                ViewTreeObserver vto = TextView.this.getViewTreeObserver();
                vto.removeOnPreDrawListener(this);
            } 
            addTaint(positionListener.getTaint());
            
            
                
                    
                    
                    
                
            
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.987 -0400", hash_original_method = "256A376A54FD4CD53D18A0F020A0467C", hash_generated_method = "A59CA6E50A96848CB51DA8F9ECF4CB5C")
        public int getPositionX() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_685245872 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_685245872;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.987 -0400", hash_original_method = "4CCC26BBD5544F9405CBD90295EAF862", hash_generated_method = "403EFA7D4E32C5CA082D89C46BDC3D32")
        public int getPositionY() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1937037837 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1937037837;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.988 -0400", hash_original_method = "4634D6360837F07AB476144D9CD27591", hash_generated_method = "DDBF1026436B61D06D0C12D62C5B7892")
        @Override
        public boolean onPreDraw() {
            
            updatePosition();
            {
                int i = 0;
                {
                    {
                        TextViewPositionListener positionListener = mPositionListeners[i];
                        {
                            positionListener.updatePosition(mPositionX, mPositionY,
                                mPositionHasChanged, mScrollHasChanged);
                        } 
                    } 
                } 
            } 
            mScrollHasChanged = false;
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_605655741 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_605655741;
            
            
            
                
                    
                    
                        
                                
                    
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.988 -0400", hash_original_method = "65C89C768DE236BFCC52E144F22BF85B", hash_generated_method = "142481B1DEA1328234C9335DBA74DC0E")
        private void updatePosition() {
            TextView.this.getLocationInWindow(mTempCoords);
            mPositionHasChanged = mTempCoords[0] != mPositionX || mTempCoords[1] != mPositionY;
            mPositionX = mTempCoords[0];
            mPositionY = mTempCoords[1];
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.989 -0400", hash_original_method = "45AFA571A6FC9FC84FC093F1FB86DABC", hash_generated_method = "85B5F4ED6EC23E44740E0F696105857A")
        public void onScrollChanged() {
            
            mScrollHasChanged = true;
            
            
        }

        
    }


    
    private abstract class PinnedPopupWindow implements TextViewPositionListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.989 -0400", hash_original_field = "BF75305BD1095CDED8E2337DB678670B", hash_generated_field = "5CD7D447C671D86883FAE32274213485")

        protected PopupWindow mPopupWindow;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.989 -0400", hash_original_field = "9E8FE4D07A56D54AEE159583A4429FE8", hash_generated_field = "B572FFE44EB19A4D34C75C5D0C555606")

        protected ViewGroup mContentView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.989 -0400", hash_original_field = "E33EA5C4D485469D2432B3A781CD5014", hash_generated_field = "2AF62DB1E3AEF057C912EFF081692BF4")

        int mPositionX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.989 -0400", hash_original_field = "5EF2225F886100AA279B39F41428F3C5", hash_generated_field = "81023086806A696B7ADDE3F7B5299B8C")

        int mPositionY;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.989 -0400", hash_original_method = "596A5600AE60FE2F4CDE653E6E3819B3", hash_generated_method = "01EC73D717B3F29758BEDF20643E55B9")
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
            
            
            
            
            
            
            
                    
            
            
        }

        
        protected abstract void createPopupWindow();

        
        protected abstract void initContentView();

        
        protected abstract int getTextOffset();

        
        protected abstract int getVerticalLocalPosition(int line);

        
        protected abstract int clipVertically(int positionY);

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.991 -0400", hash_original_method = "6C3D8663E8D10274240ADCEB82AE9A86", hash_generated_method = "A71F79A81A0A6F7C5908F0DE1A89F2A5")
        public void show() {
            TextView.this.getPositionListener().addSubscriber(this, false );
            computeLocalPosition();
            final PositionListener positionListener = TextView.this.getPositionListener();
            updatePosition(positionListener.getPositionX(), positionListener.getPositionY());
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.991 -0400", hash_original_method = "AFC1F8ABC6317EB9C1F375A956F1E985", hash_generated_method = "0FD7351E3EA8C4EE2606A9571E75F5B5")
        protected void measureContent() {
            final DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
            mContentView.measure(
                    View.MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels,
                            View.MeasureSpec.AT_MOST),
                    View.MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels,
                            View.MeasureSpec.AT_MOST));
            
            
            
                    
                            
                    
                            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.991 -0400", hash_original_method = "422A968B45C30695D0BEB603E4E72147", hash_generated_method = "955784FFC248E24BE96CF71A5E1A5734")
        private void computeLocalPosition() {
            measureContent();
            final int width = mContentView.getMeasuredWidth();
            final int offset = getTextOffset();
            mPositionX = (int) (mLayout.getPrimaryHorizontal(offset) - width / 2.0f);
            mPositionX += viewportToContentHorizontalOffset();
            final int line = mLayout.getLineForOffset(offset);
            mPositionY = getVerticalLocalPosition(line);
            mPositionY += viewportToContentVerticalOffset();
            
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.992 -0400", hash_original_method = "3C2767EB11AB639449E091DD5FC9CB2A", hash_generated_method = "BEA09F5264242CBD9C3A5819D9126CBE")
        private void updatePosition(int parentPositionX, int parentPositionY) {
            int positionX = parentPositionX + mPositionX;
            int positionY = parentPositionY + mPositionY;
            positionY = clipVertically(positionY);
            final DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
            final int width = mContentView.getMeasuredWidth();
            positionX = Math.min(displayMetrics.widthPixels - width, positionX);
            positionX = Math.max(0, positionX);
            {
                boolean varC328115627DFB8318D2C3484959F5057_1712716038 = (isShowing());
                {
                    mPopupWindow.update(positionX, positionY, -1, -1);
                } 
                {
                    mPopupWindow.showAtLocation(TextView.this, Gravity.NO_GRAVITY,
                        positionX, positionY);
                } 
            } 
            addTaint(parentPositionX);
            addTaint(parentPositionY);
            
            
            
            
            
            
            
            
            
                
            
                
                        
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.993 -0400", hash_original_method = "9C51A5E6940629038A75840F54DCC577", hash_generated_method = "25525D9132782287790F8AECFEF17792")
        public void hide() {
            mPopupWindow.dismiss();
            TextView.this.getPositionListener().removeSubscriber(this);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.994 -0400", hash_original_method = "48D3C5BA4737FA32BEEBA9E620F4B3A6", hash_generated_method = "36B795EA4414A9F9C6A14FB851A171C0")
        @Override
        public void updatePosition(int parentPositionX, int parentPositionY,
                boolean parentPositionChanged, boolean parentScrolled) {
            {
                boolean varF3B8B81213123AA3F897761495709D4F_878978027 = (isShowing() && isOffsetVisible(getTextOffset()));
                {
                    computeLocalPosition();
                    updatePosition(parentPositionX, parentPositionY);
                } 
                {
                    hide();
                } 
            } 
            addTaint(parentPositionX);
            addTaint(parentPositionY);
            addTaint(parentPositionChanged);
            addTaint(parentScrolled);
            
            
                
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.994 -0400", hash_original_method = "771871BA8F1191126AB0990E72BA0594", hash_generated_method = "10BC980884B2693C74E48E37D801A78A")
        public boolean isShowing() {
            boolean varDAFC67E962E4584ADE09C9440ED4C8A8_1408438063 = (mPopupWindow.isShowing());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_663298840 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_663298840;
            
            
        }

        
    }


    
    private class SuggestionsPopupWindow extends PinnedPopupWindow implements OnItemClickListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.994 -0400", hash_original_field = "0FA91084880C72F330A5711F5C8F7294", hash_generated_field = "DF9B2B2A32C54D35B3228EF58FDC6E78")

        private SuggestionInfo[] mSuggestionInfos;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.994 -0400", hash_original_field = "ABFE2C764E01946613EA91131C55961C", hash_generated_field = "596DE3763E763BE0F497615E1944F22C")

        private int mNumberOfSuggestions;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.994 -0400", hash_original_field = "033E344F7E287345FE0C52A3E5D61018", hash_generated_field = "7F93C534F2DFE71AE91870F5785F473D")

        private boolean mCursorWasVisibleBeforeSuggestions;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.994 -0400", hash_original_field = "CE1B361D3F408CDB879798047244ECC3", hash_generated_field = "641DA69AA28F49EC5C5A62A58B67E06A")

        private boolean mIsShowingUp = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.994 -0400", hash_original_field = "63055E537713F24C4C86BE6E68415FCE", hash_generated_field = "EC7957C4E8F88AF8C25BE753B9E15A66")

        private SuggestionAdapter mSuggestionsAdapter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.994 -0400", hash_original_field = "220190CD1D81D70302E1152A714AE917", hash_generated_field = "B69BA7FB6136A02593E4286BE8CED5FC")

        private Comparator<SuggestionSpan> mSuggestionSpanComparator;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.994 -0400", hash_original_field = "317A49877C593D0434BEE0A1DE61C446", hash_generated_field = "D0B23D9D75631218A54DFB41905818F7")

        private HashMap<SuggestionSpan, Integer> mSpansLengths;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.995 -0400", hash_original_method = "296BEE5065EB2EF8F82574E0F3647EF2", hash_generated_method = "C9FE2AEB77D5E42436EC81728FF2A6EB")
        public  SuggestionsPopupWindow() {
            mCursorWasVisibleBeforeSuggestions = mCursorVisible;
            mSuggestionSpanComparator = new SuggestionSpanComparator();
            mSpansLengths = new HashMap<SuggestionSpan, Integer>();
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.995 -0400", hash_original_method = "2C5A34402E22C878AD33972323D3ACC4", hash_generated_method = "1D075CDCA4E55E9BDBE0B58CE507DA50")
        @Override
        protected void createPopupWindow() {
            mPopupWindow = new CustomPopupWindow(TextView.this.mContext,
                com.android.internal.R.attr.textSuggestionsWindowStyle);
            mPopupWindow.setInputMethodMode(PopupWindow.INPUT_METHOD_NOT_NEEDED);
            mPopupWindow.setFocusable(true);
            mPopupWindow.setClippingEnabled(false);
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.996 -0400", hash_original_method = "E003230CE90A2ACB93D34E336B67EF46", hash_generated_method = "67C3384D656FFE5981CC56886C76FB9F")
        @Override
        protected void initContentView() {
            ListView listView = new ListView(TextView.this.getContext());
            mSuggestionsAdapter = new SuggestionAdapter();
            listView.setAdapter(mSuggestionsAdapter);
            listView.setOnItemClickListener(this);
            mContentView = listView;
            mSuggestionInfos = new SuggestionInfo[MAX_NUMBER_SUGGESTIONS + 2];
            {
                int i = 0;
                {
                    mSuggestionInfos[i] = new SuggestionInfo();
                } 
            } 
            
            
            
            
            
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.996 -0400", hash_original_method = "4C7853BA5C99567CAD84815F4452E5F9", hash_generated_method = "1564698033A6E64560B6595DF567E527")
        public boolean isShowingUp() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2075388434 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2075388434;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.996 -0400", hash_original_method = "3914DCDC5DB3E14D1A1A163B7497EFBA", hash_generated_method = "CBD237ACC458BFEA613530AFCAFC26CB")
        public void onParentLostFocus() {
            
            mIsShowingUp = false;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.997 -0400", hash_original_method = "A21D81008594D05973BC33E2948715E2", hash_generated_method = "9C0B2EC454236D12FFEFE10AF48FC615")
        private SuggestionSpan[] getSuggestionSpans() {
            SuggestionSpan[] varB4EAC82CA7396A68D541C85D26508E83_566618300 = null; 
            int pos = TextView.this.getSelectionStart();
            Spannable spannable = (Spannable) TextView.this.mText;
            SuggestionSpan[] suggestionSpans = spannable.getSpans(pos, pos, SuggestionSpan.class);
            mSpansLengths.clear();
            {
                SuggestionSpan suggestionSpan = suggestionSpans[0];
                {
                    int start = spannable.getSpanStart(suggestionSpan);
                    int end = spannable.getSpanEnd(suggestionSpan);
                    mSpansLengths.put(suggestionSpan, Integer.valueOf(end - start));
                } 
            } 
            Arrays.sort(suggestionSpans, mSuggestionSpanComparator);
            varB4EAC82CA7396A68D541C85D26508E83_566618300 = suggestionSpans;
            varB4EAC82CA7396A68D541C85D26508E83_566618300.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_566618300;
            
            
            
            
            
            
                
                
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.998 -0400", hash_original_method = "C166DC70ACC1835B92197E48CEB369FC", hash_generated_method = "A8A5518D4F8C68A79453BA1F542C22F5")
        @Override
        public void show() {
            updateSuggestions();
            mCursorWasVisibleBeforeSuggestions = mCursorVisible;
            setCursorVisible(false);
            mIsShowingUp = true;
            super.show();
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.998 -0400", hash_original_method = "8DDB7ED8B40AC8DC3D4FF9060DA06A2E", hash_generated_method = "8C6314492E5291EB8E471380C82151E5")
        @Override
        protected void measureContent() {
            final DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
            final int horizontalMeasure = View.MeasureSpec.makeMeasureSpec(
                    displayMetrics.widthPixels, View.MeasureSpec.AT_MOST);
            final int verticalMeasure = View.MeasureSpec.makeMeasureSpec(
                    displayMetrics.heightPixels, View.MeasureSpec.AT_MOST);
            int width = 0;
            View view = null;
            {
                int i = 0;
                {
                    view = mSuggestionsAdapter.getView(i, view, mContentView);
                    view.getLayoutParams().width = LayoutParams.WRAP_CONTENT;
                    view.measure(horizontalMeasure, verticalMeasure);
                    width = Math.max(width, view.getMeasuredWidth());
                } 
            } 
            mContentView.measure(
                    View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY),
                    verticalMeasure);
            Drawable popupBackground = mPopupWindow.getBackground();
            {
                mTempRect = new Rect();
                popupBackground.getPadding(mTempRect);
                width += mTempRect.left + mTempRect.right;
            } 
            mPopupWindow.setWidth(width);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.999 -0400", hash_original_method = "6820F3398D40FE1AF57F321A0934E9B8", hash_generated_method = "3AC77B364FDE15FF09FF89B5A6796F60")
        @Override
        protected int getTextOffset() {
            int varBC8718B34213775E0E86386F1B689831_1749363155 = (getSelectionStart());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_179775187 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_179775187;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.999 -0400", hash_original_method = "87FFA2F036D6FB2F317732DF596E05CB", hash_generated_method = "438F74071F65537BFA3E4051A30C5457")
        @Override
        protected int getVerticalLocalPosition(int line) {
            int varC530C119C90DEC1E0FFF523326A5138A_1464398648 = (mLayout.getLineBottom(line));
            addTaint(line);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_578190425 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_578190425;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:16.999 -0400", hash_original_method = "BF4D66DCAEE7C7EAD97F70105958840C", hash_generated_method = "4809DD9B0B11FDEF36968CD9FF4691AE")
        @Override
        protected int clipVertically(int positionY) {
            final int height = mContentView.getMeasuredHeight();
            final DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
            int var7B483E1A6A6C9FD21BCAE2DB59DA5C3D_556586430 = (Math.min(positionY, displayMetrics.heightPixels - height));
            addTaint(positionY);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1643033483 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1643033483;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.000 -0400", hash_original_method = "7609E0B22D3FA397AAE3B56DEE3F8C83", hash_generated_method = "F131B81970709DA64760DF4AAFB46819")
        @Override
        public void hide() {
            super.hide();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.002 -0400", hash_original_method = "43D89583824EB2CC5185C1DC5EA2D76A", hash_generated_method = "02E5B6DAF5454FCA93A549AEDF759960")
        private void updateSuggestions() {
            Spannable spannable = (Spannable) TextView.this.mText;
            SuggestionSpan[] suggestionSpans = getSuggestionSpans();
            final int nbSpans = suggestionSpans.length;
            mNumberOfSuggestions = 0;
            int spanUnionStart = mText.length();
            int spanUnionEnd = 0;
            SuggestionSpan misspelledSpan = null;
            int underlineColor = 0;
            {
                int spanIndex = 0;
                {
                    SuggestionSpan suggestionSpan = suggestionSpans[spanIndex];
                    final int spanStart = spannable.getSpanStart(suggestionSpan);
                    final int spanEnd = spannable.getSpanEnd(suggestionSpan);
                    spanUnionStart = Math.min(spanStart, spanUnionStart);
                    spanUnionEnd = Math.max(spanEnd, spanUnionEnd);
                    {
                        boolean var41ED7D23113F09082657F25EB9349901_371735705 = ((suggestionSpan.getFlags() & SuggestionSpan.FLAG_MISSPELLED) != 0);
                        {
                            misspelledSpan = suggestionSpan;
                        } 
                    } 
                    underlineColor = suggestionSpan.getUnderlineColor();
                    String[] suggestions = suggestionSpan.getSuggestions();
                    int nbSuggestions = suggestions.length;
                    {
                        int suggestionIndex = 0;
                        {
                            SuggestionInfo suggestionInfo = mSuggestionInfos[mNumberOfSuggestions];
                            suggestionInfo.suggestionSpan = suggestionSpan;
                            suggestionInfo.suggestionIndex = suggestionIndex;
                            suggestionInfo.text.replace(0, suggestionInfo.text.length(),
                            suggestions[suggestionIndex]);
                            {
                                spanIndex = nbSpans;
                            } 
                        } 
                    } 
                } 
            } 
            {
                int i = 0;
                {
                    highlightTextDifferences(mSuggestionInfos[i], spanUnionStart, spanUnionEnd);
                } 
            } 
            {
                final int misspelledStart = spannable.getSpanStart(misspelledSpan);
                final int misspelledEnd = spannable.getSpanEnd(misspelledSpan);
                {
                    SuggestionInfo suggestionInfo = mSuggestionInfos[mNumberOfSuggestions];
                    suggestionInfo.suggestionSpan = misspelledSpan;
                    suggestionInfo.suggestionIndex = ADD_TO_DICTIONARY;
                    suggestionInfo.text.replace(0, suggestionInfo.text.length(),
                            getContext().getString(com.android.internal.R.string.addToDictionary));
                    suggestionInfo.text.setSpan(suggestionInfo.highlightSpan, 0, 0,
                            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                } 
            } 
            SuggestionInfo suggestionInfo = mSuggestionInfos[mNumberOfSuggestions];
            suggestionInfo.suggestionSpan = null;
            suggestionInfo.suggestionIndex = DELETE_TEXT;
            suggestionInfo.text.replace(0, suggestionInfo.text.length(),
                    getContext().getString(com.android.internal.R.string.deleteText));
            suggestionInfo.text.setSpan(suggestionInfo.highlightSpan, 0, 0,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            mSuggestionRangeSpan = new SuggestionRangeSpan();
            {
                mSuggestionRangeSpan.setBackgroundColor(mHighlightColor);
            } 
            {
                final float BACKGROUND_TRANSPARENCY = 0.4f;
                final int newAlpha = (int) (Color.alpha(underlineColor) * BACKGROUND_TRANSPARENCY);
                mSuggestionRangeSpan.setBackgroundColor(
                        (underlineColor & 0x00FFFFFF) + (newAlpha << 24));
            } 
            spannable.setSpan(mSuggestionRangeSpan, spanUnionStart, spanUnionEnd,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            mSuggestionsAdapter.notifyDataSetChanged();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.004 -0400", hash_original_method = "9587A8E163DBC119C2F6F3B6CD33F02D", hash_generated_method = "45C1F3477D6BF4FF802F202E6D0AEF91")
        private void highlightTextDifferences(SuggestionInfo suggestionInfo, int unionStart,
                int unionEnd) {
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
            addTaint(suggestionInfo.getTaint());
            addTaint(unionStart);
            addTaint(unionEnd);
            
            
            
            
            
            
                    
            
                    
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.005 -0400", hash_original_method = "73388536B046BC3C58C91A89E4930696", hash_generated_method = "5FCF6A41AB76E5C84A8E601BEBA2A142")
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            
            Editable editable = (Editable) mText;
            SuggestionInfo suggestionInfo = mSuggestionInfos[position];
            {
                final int spanUnionStart = editable.getSpanStart(mSuggestionRangeSpan);
                int spanUnionEnd = editable.getSpanEnd(mSuggestionRangeSpan);
                {
                    {
                        boolean var84A1A3093EA4E5C4D94593E4EC39F7A6_953957264 = (spanUnionEnd < editable.length() &&
                            Character.isSpaceChar(editable.charAt(spanUnionEnd)) &&
                            (spanUnionStart == 0 ||
                            Character.isSpaceChar(editable.charAt(spanUnionStart - 1))));
                        {
                            spanUnionEnd = spanUnionEnd + 1;
                        } 
                    } 
                    deleteText_internal(spanUnionStart, spanUnionEnd);
                } 
                hide();
            } 
            final int spanStart = editable.getSpanStart(suggestionInfo.suggestionSpan);
            final int spanEnd = editable.getSpanEnd(suggestionInfo.suggestionSpan);
            {
                hide();
            } 
            final String originalText = mText.toString().substring(spanStart, spanEnd);
            {
                Intent intent = new Intent(Settings.ACTION_USER_DICTIONARY_INSERT);
                intent.putExtra("word", originalText);
                intent.putExtra("locale", getTextServicesLocale().toString());
                intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_NEW_TASK);
                getContext().startActivity(intent);
                editable.removeSpan(suggestionInfo.suggestionSpan);
                updateSpellCheckSpans(spanStart, spanEnd, false);
            } 
            {
                SuggestionSpan[] suggestionSpans = editable.getSpans(spanStart, spanEnd,
                        SuggestionSpan.class);
                final int length = suggestionSpans.length;
                int[] suggestionSpansStarts = new int[length];
                int[] suggestionSpansEnds = new int[length];
                int[] suggestionSpansFlags = new int[length];
                {
                    int i = 0;
                    {
                        final SuggestionSpan suggestionSpan = suggestionSpans[i];
                        suggestionSpansStarts[i] = editable.getSpanStart(suggestionSpan);
                        suggestionSpansEnds[i] = editable.getSpanEnd(suggestionSpan);
                        suggestionSpansFlags[i] = editable.getSpanFlags(suggestionSpan);
                        int suggestionSpanFlags = suggestionSpan.getFlags();
                        {
                            suggestionSpanFlags &= ~SuggestionSpan.FLAG_MISSPELLED;
                            suggestionSpanFlags &= ~SuggestionSpan.FLAG_EASY_CORRECT;
                            suggestionSpan.setFlags(suggestionSpanFlags);
                        } 
                    } 
                } 
                final int suggestionStart = suggestionInfo.suggestionStart;
                final int suggestionEnd = suggestionInfo.suggestionEnd;
                final String suggestion = suggestionInfo.text.subSequence(
                        suggestionStart, suggestionEnd).toString();
                replaceText_internal(spanStart, spanEnd, suggestion);
                {
                    boolean varF79A598750887E0098FCD17D2840688C_783997253 = (!TextUtils.isEmpty(
                        suggestionInfo.suggestionSpan.getNotificationTargetClassName()));
                    {
                        InputMethodManager imm = InputMethodManager.peekInstance();
                        {
                            imm.notifySuggestionPicked(suggestionInfo.suggestionSpan, originalText,
                                suggestionInfo.suggestionIndex);
                        } 
                    } 
                } 
                String[] suggestions = suggestionInfo.suggestionSpan.getSuggestions();
                suggestions[suggestionInfo.suggestionIndex] = originalText;
                final int lengthDifference = suggestion.length() - (spanEnd - spanStart);
                {
                    int i = 0;
                    {
                        {
                            setSpan_internal(suggestionSpans[i], suggestionSpansStarts[i],
                                suggestionSpansEnds[i] + lengthDifference, suggestionSpansFlags[i]);
                        } 
                    } 
                } 
                final int newCursorPosition = spanEnd + lengthDifference;
                setCursorPosition_internal(newCursorPosition, newCursorPosition);
            } 
            hide();
            addTaint(parent.getTaint());
            addTaint(view.getTaint());
            addTaint(position);
            addTaint(id);
            
            
        }

        
        private class CustomPopupWindow extends PopupWindow {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.006 -0400", hash_original_method = "76E50B1843F1484B0424D837A17373EE", hash_generated_method = "1AFBAA9D1921C4232962818BCDF02A5A")
            public  CustomPopupWindow(Context context, int defStyle) {
                super(context, null, defStyle);
                addTaint(context.getTaint());
                addTaint(defStyle);
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.006 -0400", hash_original_method = "3CF42E745499FBF7012823B6BEAA6E8B", hash_generated_method = "638C28B6F8C704579167A89F0ED82902")
            @Override
            public void dismiss() {
                super.dismiss();
                TextView.this.getPositionListener().removeSubscriber(SuggestionsPopupWindow.this);
                ((Spannable) mText).removeSpan(mSuggestionRangeSpan);
                setCursorVisible(mCursorWasVisibleBeforeSuggestions);
                {
                    boolean var6A9CA976632F28E945987868EDCFC2A8_1637180176 = (hasInsertionController());
                    {
                        getInsertionController().show();
                    } 
                } 
                
                
                
                
                
                
                    
                
            }

            
        }


        
        private class SuggestionInfo {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.006 -0400", hash_original_field = "E0CCBC7742EB01E23FE8CAC0823856EC", hash_generated_field = "872480635E7B6A6F7A5C26A47649A56F")

            int suggestionStart;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.006 -0400", hash_original_field = "6BA3CAF30490DD7C10C1C1903B7C4EE6", hash_generated_field = "AC9E6ECED58FB8EF180833836DBCAA2D")

            int suggestionEnd;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.006 -0400", hash_original_field = "175FF5D2D5F25D80AF4E2ACDB6CE4C78", hash_generated_field = "46D75F50466858EB51EAFAE8BB212D75")

            SuggestionSpan suggestionSpan;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.006 -0400", hash_original_field = "79EA7A373645B1284FBF65D76846E660", hash_generated_field = "E2038F479A232C008DEC2C58888E09AF")

            int suggestionIndex;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.007 -0400", hash_original_field = "66AD57BB4DFC181279DFE9FFA45E67A0", hash_generated_field = "59937CFD4951C01B73A6EF4F5C4D841A")

            SpannableStringBuilder text = new SpannableStringBuilder();
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.007 -0400", hash_original_field = "4EE2EC84135A501AB5CC573E44247990", hash_generated_field = "18031134C63E234D2C3372B21DDAF396")

            TextAppearanceSpan highlightSpan = new TextAppearanceSpan(mContext,
                    android.R.style.TextAppearance_SuggestionHighlight);
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.007 -0400", hash_original_method = "613563FC71224468A61688B0DDA11E74", hash_generated_method = "613563FC71224468A61688B0DDA11E74")
            public SuggestionInfo ()
            {
                
            }


        }


        
        private class SuggestionAdapter extends BaseAdapter {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.007 -0400", hash_original_field = "3F1D187921B41C54CE8DA3DC5FEF94E0", hash_generated_field = "0B998218A375E40727D240F37441CBEB")

            private LayoutInflater mInflater = (LayoutInflater) TextView.this.mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.007 -0400", hash_original_method = "56675D9229C135A53AD81FE91AEF2A02", hash_generated_method = "56675D9229C135A53AD81FE91AEF2A02")
            public SuggestionAdapter ()
            {
                
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.007 -0400", hash_original_method = "02B536C5901CCC3DE9A3084712F44E45", hash_generated_method = "3A75DC45905FEFF296DF9EC2E146AC84")
            @Override
            public int getCount() {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_521111245 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_521111245;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.008 -0400", hash_original_method = "AB9B090A0CFC1C7403BFB1F3A94BDE2B", hash_generated_method = "829DA74456D0DCF01FF6BDFDE7A3E8A7")
            @Override
            public Object getItem(int position) {
                Object varB4EAC82CA7396A68D541C85D26508E83_460555095 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_460555095 = mSuggestionInfos[position];
                addTaint(position);
                varB4EAC82CA7396A68D541C85D26508E83_460555095.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_460555095;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.008 -0400", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "E5A002D395E82AE7BE546E18F29575AA")
            @Override
            public long getItemId(int position) {
                addTaint(position);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1199057398 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1199057398;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.009 -0400", hash_original_method = "EB7381461F4FDD3A1934D144B2D8DE50", hash_generated_method = "B6C8B7EC9F44DF0EB4CC139ADDCA76B5")
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View varB4EAC82CA7396A68D541C85D26508E83_1039722500 = null; 
                TextView textView = (TextView) convertView;
                {
                    textView = (TextView) mInflater.inflate(mTextEditSuggestionItemLayout, parent,
                            false);
                } 
                final SuggestionInfo suggestionInfo = mSuggestionInfos[position];
                textView.setText(suggestionInfo.text);
                {
                    textView.setCompoundDrawablesWithIntrinsicBounds(
                            com.android.internal.R.drawable.ic_suggestions_add, 0, 0, 0);
                } 
                {
                    textView.setCompoundDrawablesWithIntrinsicBounds(
                            com.android.internal.R.drawable.ic_suggestions_delete, 0, 0, 0);
                } 
                {
                    textView.setCompoundDrawables(null, null, null, null);
                } 
                varB4EAC82CA7396A68D541C85D26508E83_1039722500 = textView;
                addTaint(position);
                addTaint(convertView.getTaint());
                addTaint(parent.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_1039722500.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_1039722500;
                
                
            }

            
        }


        
        private class SuggestionSpanComparator implements Comparator<SuggestionSpan> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.009 -0400", hash_original_method = "22EA00C20DD1AAEDCB1186FBD85A1C5E", hash_generated_method = "22EA00C20DD1AAEDCB1186FBD85A1C5E")
            public SuggestionSpanComparator ()
            {
                
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.009 -0400", hash_original_method = "D4A09F0FD84AABB3F69B7BD15CCD92DF", hash_generated_method = "CECD315805027FB3E4737EADB794AC66")
            public int compare(SuggestionSpan span1, SuggestionSpan span2) {
                final int flag1 = span1.getFlags();
                final int flag2 = span2.getFlags();
                {
                    final boolean easy1 = (flag1 & SuggestionSpan.FLAG_EASY_CORRECT) != 0;
                    final boolean easy2 = (flag2 & SuggestionSpan.FLAG_EASY_CORRECT) != 0;
                    final boolean misspelled1 = (flag1 & SuggestionSpan.FLAG_MISSPELLED) != 0;
                    final boolean misspelled2 = (flag2 & SuggestionSpan.FLAG_MISSPELLED) != 0;
                } 
                int var69AC0EE4C836195D7157808630CBE920_890597203 = (mSpansLengths.get(span1).intValue() - mSpansLengths.get(span2).intValue());
                addTaint(span1.getTaint());
                addTaint(span2.getTaint());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1294066150 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1294066150;
                
                
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.009 -0400", hash_original_field = "0C1515086A1226C970EE69A713DDD288", hash_generated_field = "D839A1C329DC1C2BA302C63069B302E8")

        private static final int MAX_NUMBER_SUGGESTIONS = SuggestionSpan.SUGGESTIONS_MAX_SIZE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.009 -0400", hash_original_field = "9A3BE7FEF28DB01CA67A412C8A54D32F", hash_generated_field = "60496CAB9AB07AE99F349E1717F7224D")

        private static final int ADD_TO_DICTIONARY = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.009 -0400", hash_original_field = "8C04FC6F385A06A2600D60FA7FE27F1A", hash_generated_field = "992995ADFDA4143135C9B34605503287")

        private static final int DELETE_TEXT = -2;
    }


    
    private class SelectionActionModeCallback implements ActionMode.Callback {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.010 -0400", hash_original_method = "0A08C97F3CA872D86BD6FA2FC1044E6A", hash_generated_method = "0A08C97F3CA872D86BD6FA2FC1044E6A")
        public SelectionActionModeCallback ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.011 -0400", hash_original_method = "9BA90F93967180A852B2E5C718CC8322", hash_generated_method = "5D814E3E1EA8C090E30A08C890BBD617")
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            
            TypedArray styledAttributes = mContext.obtainStyledAttributes(
                    com.android.internal.R.styleable.SelectionModeDrawables);
            boolean allowText = getContext().getResources().getBoolean(
                    com.android.internal.R.bool.config_allowActionMenuItemTextWithIcon);
            mode.setTitle(allowText ?
                    mContext.getString(com.android.internal.R.string.textSelectionCABTitle) : null);
            mode.setSubtitle(null);
            int selectAllIconId = 0;
            {
                selectAllIconId = styledAttributes.getResourceId(
                        R.styleable.SelectionModeDrawables_actionModeSelectAllDrawable, 0);
            } 
            menu.add(0, ID_SELECT_ALL, 0, com.android.internal.R.string.selectAll).
                    setIcon(selectAllIconId).
                    setAlphabeticShortcut('a').
                    setShowAsAction(
                            MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
            {
                boolean var4087A2A70EC4D6F0409558B6C4258D55_1035866148 = (canCut());
                {
                    menu.add(0, ID_CUT, 0, com.android.internal.R.string.cut).
                    setIcon(styledAttributes.getResourceId(
                            R.styleable.SelectionModeDrawables_actionModeCutDrawable, 0)).
                    setAlphabeticShortcut('x').
                    setShowAsAction(
                            MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
                } 
            } 
            {
                boolean var6AFF96D83000797E509C5DFB5D242F34_294291446 = (canCopy());
                {
                    menu.add(0, ID_COPY, 0, com.android.internal.R.string.copy).
                    setIcon(styledAttributes.getResourceId(
                            R.styleable.SelectionModeDrawables_actionModeCopyDrawable, 0)).
                    setAlphabeticShortcut('c').
                    setShowAsAction(
                            MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
                } 
            } 
            {
                boolean varE76E09F5D4A1A03C0560F618234DAA0E_1186283397 = (canPaste());
                {
                    menu.add(0, ID_PASTE, 0, com.android.internal.R.string.paste).
                        setIcon(styledAttributes.getResourceId(
                                R.styleable.SelectionModeDrawables_actionModePasteDrawable, 0)).
                        setAlphabeticShortcut('v').
                        setShowAsAction(
                                MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
                } 
            } 
            styledAttributes.recycle();
            {
                {
                    boolean var41AD4209F91C4824352554BD86D35AA9_312745801 = (!mCustomSelectionActionModeCallback.onCreateActionMode(mode, menu));
                } 
            } 
            {
                boolean var7C369957434C066B84C56D449BD80D86_1239841286 = (menu.hasVisibleItems() || mode.getCustomView() != null);
                {
                    getSelectionController().show();
                } 
            } 
            addTaint(mode.getTaint());
            addTaint(menu.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_576384519 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_576384519;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.012 -0400", hash_original_method = "350C4916EAD271625C17FEEF1988576E", hash_generated_method = "49A38E8CEEC7BB6F65D5670A593484A7")
        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            
            {
                boolean varADAB2DA7C682C9431AEBA3613F94A97B_945810196 = (mCustomSelectionActionModeCallback.onPrepareActionMode(mode, menu));
            } 
            addTaint(mode.getTaint());
            addTaint(menu.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1117795241 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1117795241;
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.013 -0400", hash_original_method = "7EC2472DA1F2018FBE0DB5359E02217C", hash_generated_method = "4AC4ACDAE68F1938D4AE712CD0184674")
        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            
            {
                boolean var6A3E1D5B368A4625952314ECA607D6A0_946015278 = (mCustomSelectionActionModeCallback != null &&
                 mCustomSelectionActionModeCallback.onActionItemClicked(mode, item));
            } 
            boolean varAAAC964C7BDBEAA3EC5B24BBD90E6008_962463047 = (onTextContextMenuItem(item.getItemId()));
            addTaint(mode.getTaint());
            addTaint(item.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_413541791 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_413541791;
            
            
                 
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.014 -0400", hash_original_method = "E3DA233478038DA411461438FCA54906", hash_generated_method = "35DA069730D13C4BA80331090D96F4DF")
        @Override
        public void onDestroyActionMode(ActionMode mode) {
            
            {
                mCustomSelectionActionModeCallback.onDestroyActionMode(mode);
            } 
            Selection.setSelection((Spannable) mText, getSelectionEnd());
            {
                mSelectionModifierCursorController.hide();
            } 
            mSelectionActionMode = null;
            addTaint(mode.getTaint());
            
            
                
            
            
            
                
            
            
        }

        
    }


    
    private class ActionPopupWindow extends PinnedPopupWindow implements OnClickListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.014 -0400", hash_original_field = "638E4AC7A89C2D70FFAD0D5E4D21347B", hash_generated_field = "D8E77E145B60561FAD9A3B60E7593FC7")

        private TextView mPasteTextView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.014 -0400", hash_original_field = "40AFD8EC4389104F8E2396DDF98BD183", hash_generated_field = "5647E56FAEB644585635D1F439C78D58")

        private TextView mReplaceTextView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.014 -0400", hash_original_method = "66BB2A1B8CD91C3CE44D6AD3A6EA951F", hash_generated_method = "66BB2A1B8CD91C3CE44D6AD3A6EA951F")
        public ActionPopupWindow ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.014 -0400", hash_original_method = "3A27BFF151DD7090A49C43ED6F082D3A", hash_generated_method = "8DC88F4954A2CB9FB764336AB0459502")
        @Override
        protected void createPopupWindow() {
            mPopupWindow = new PopupWindow(TextView.this.mContext, null,
                    com.android.internal.R.attr.textSelectHandleWindowStyle);
            mPopupWindow.setClippingEnabled(true);
            
            
                    
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.015 -0400", hash_original_method = "24A2CF459D5801BCD7B986330654CD38", hash_generated_method = "FEC1E85CC5C44135050F2394200FF32D")
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
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.015 -0400", hash_original_method = "A37D41A60FC392DB422E94A09527D04E", hash_generated_method = "D6E87EA2E27B917BE8988D2E76518F3E")
        @Override
        public void show() {
            boolean canPaste = canPaste();
            boolean canSuggest = isSuggestionsEnabled() && isCursorInsideSuggestionSpan();
            mPasteTextView.setVisibility(canPaste ? View.VISIBLE : View.GONE);
            mReplaceTextView.setVisibility(canSuggest ? View.VISIBLE : View.GONE);
            super.show();
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.016 -0400", hash_original_method = "35B6F06783189901121FFF5DA40FB852", hash_generated_method = "F0C2D081A4F902ADFF012E7C76BB5D4A")
        @Override
        public void onClick(View view) {
            
            {
                boolean var3F1B0BC67C85AC74E9CC7447E1F80F7C_18123367 = (view == mPasteTextView && canPaste());
                {
                    onTextContextMenuItem(ID_PASTE);
                    hide();
                } 
                {
                    final int middle = (getSelectionStart() + getSelectionEnd()) / 2;
                    stopSelectionActionMode();
                    Selection.setSelection((Spannable) mText, middle);
                    showSuggestions();
                } 
            } 
            addTaint(view.getTaint());
            
            
                
                
            
                
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.016 -0400", hash_original_method = "6C32A970FB91901A3510EE736EF065A8", hash_generated_method = "53AE70BFA4A769A96BBBD54717032B9A")
        @Override
        protected int getTextOffset() {
            int var3BEB3DEB1E2E3C75F7F6F972590B6F26_1621155271 = ((getSelectionStart() + getSelectionEnd()) / 2);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1126636993 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1126636993;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.017 -0400", hash_original_method = "AB01324FAF38A5FF69620E59B4546722", hash_generated_method = "B6E9F2859735C7834E7785AEB2CFD011")
        @Override
        protected int getVerticalLocalPosition(int line) {
            int varEE26756D259E6923CEEA10605E3E8378_1212725485 = (mLayout.getLineTop(line) - mContentView.getMeasuredHeight());
            addTaint(line);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_448818446 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_448818446;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.017 -0400", hash_original_method = "155BF5081251C49CE36145C9CC0615FD", hash_generated_method = "6AEDEF09BBADBB953AE124401BA7DEA8")
        @Override
        protected int clipVertically(int positionY) {
            {
                final int offset = getTextOffset();
                final int line = mLayout.getLineForOffset(offset);
                positionY += mLayout.getLineBottom(line) - mLayout.getLineTop(line);
                positionY += mContentView.getMeasuredHeight();
                final Drawable handle = mContext.getResources().getDrawable(mTextSelectHandleRes);
                positionY += handle.getIntrinsicHeight();
            } 
            addTaint(positionY);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_426333832 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_426333832;
            
            
                
                
                
                
                
                
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.017 -0400", hash_original_field = "A8B4CFDAA994C026529F1F31A401F449", hash_generated_field = "9556C9F4A76B40115A0F30878921C774")

        private static final int POPUP_TEXT_LAYOUT = com.android.internal.R.layout.text_edit_action_popup_text;
    }


    
    private abstract class HandleView extends View implements TextViewPositionListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.017 -0400", hash_original_field = "D548B27C6AC66A9D9B5D05ED35C2D844", hash_generated_field = "6C4E60FE8A6D1EE71691C50FE013D71E")

        protected Drawable mDrawable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.017 -0400", hash_original_field = "73FE9509DA3FC3FD8E616D5F4A54F354", hash_generated_field = "4C4EE51B5C48463562D9242B398F28CE")

        protected Drawable mDrawableLtr;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.017 -0400", hash_original_field = "75EB4D5B30043123DC9A2A3794EEC7F0", hash_generated_field = "C7A02A239F561A2D85D421A4E8712A4E")

        protected Drawable mDrawableRtl;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.017 -0400", hash_original_field = "C64165C1B15EB68FDC5E7135FFE5DF5B", hash_generated_field = "B93BD44443CA54ABF5B84DF5F163A33F")

        private PopupWindow mContainer;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.017 -0400", hash_original_field = "E33EA5C4D485469D2432B3A781CD5014", hash_generated_field = "B562606C08FEFE4EA880E0BAFC4807BC")

        private int mPositionX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.017 -0400", hash_original_field = "5EF2225F886100AA279B39F41428F3C5", hash_generated_field = "30733FB91B36B499B68F008F42192052")

        private int mPositionY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.017 -0400", hash_original_field = "88529674006503CAD340B538C44A2C88", hash_generated_field = "71A2FEF14E89166E5A8A859417B1663A")

        private boolean mIsDragging;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.017 -0400", hash_original_field = "029443A19C599CE9A771103B1F04FFA7", hash_generated_field = "93A0F0D3D0C011A4C3C7501AB57199A0")

        private float mTouchToWindowOffsetX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.017 -0400", hash_original_field = "01E0875D4861BF37105440B51BFCE246", hash_generated_field = "540D3F7CD2E1D98D601A597896694EF1")

        private float mTouchToWindowOffsetY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.017 -0400", hash_original_field = "EC8EBBCD9EFF3785D3CEAE13B087737E", hash_generated_field = "FC8146331AA3445EF26C9BD556ACBB7A")

        protected int mHotspotX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.017 -0400", hash_original_field = "E77C6D28007CC352FD029FAC0668FD90", hash_generated_field = "6BB781632FC22CFF12B61F61AC16C144")

        private float mTouchOffsetY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.017 -0400", hash_original_field = "82A2205DB022BA555E925261E4DCC4D4", hash_generated_field = "7A7CA8BEEE2A68B1CAD15B2AD85A2E90")

        private float mIdealVerticalOffset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.018 -0400", hash_original_field = "AFAA5B704E00C118BFC94C3DB68B3EB8", hash_generated_field = "4316A0FF32FF85FA98C402B295009B89")

        private int mLastParentX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.018 -0400", hash_original_field = "921E843A2994BBE22EA5E45795AA43E4", hash_generated_field = "989834E9B58E837BA06B11D0842ADD46")

        private int mLastParentY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.018 -0400", hash_original_field = "81B6A0831D431B26A19572DBBA8D21BD", hash_generated_field = "2EC1E5C57AE86C2314399153800FDC8F")

        protected ActionPopupWindow mActionPopupWindow;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.018 -0400", hash_original_field = "686EF52C6C5A665D57DB688D5CD19C3F", hash_generated_field = "C47DED40298BEE97981BC7B8F1538E5B")

        private int mPreviousOffset = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.018 -0400", hash_original_field = "03D5F02C0AF2CE2B038F91466D8238BA", hash_generated_field = "348E54253A3677FA237DAA94481A3907")

        private boolean mPositionHasChanged = true;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.018 -0400", hash_original_field = "5C0D0B062C184F3703A4B9594303BA8F", hash_generated_field = "AF098A48DA71A067D06553B74FDC10EC")

        private Runnable mActionPopupShower;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.018 -0400", hash_original_field = "77968F028A8D0EC9CAEB90B72134A740", hash_generated_field = "49D0562CBA301978D9BE0EDDCD29274F")

        private final long[] mPreviousOffsetsTimes = new long[HISTORY_SIZE];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.018 -0400", hash_original_field = "9960A44D965A887155E39C559464BFCA", hash_generated_field = "B14296EE4EF0011B1C75932F407A07FC")

        private final int[] mPreviousOffsets = new int[HISTORY_SIZE];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.018 -0400", hash_original_field = "76D787A353B8891BC279BD7E2A9B6B00", hash_generated_field = "A862CB689B1B30174089DC5C296E66B1")

        private int mPreviousOffsetIndex = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.018 -0400", hash_original_field = "AD3CA79B9D71DC299CA01D15C8FD472D", hash_generated_field = "FFBAC9977BB0F1F158F20DFF11AA8445")

        private int mNumberPreviousOffsets = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.018 -0400", hash_original_method = "96CFEA14605480F2CAC7A5BABB016DB2", hash_generated_method = "B899B328CDCE2D8BB1084ECD9613283A")
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
            
            
                    
            
            
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.019 -0400", hash_original_method = "79B760AD39E8E4DC7B1000745317DEB7", hash_generated_method = "CF95FE73935976E2ED01BA62145AD362")
        protected void updateDrawable() {
            final int offset = getCurrentCursorOffset();
            final boolean isRtlCharAtOffset = mLayout.isRtlCharAt(offset);
            mDrawable = isRtlCharAtOffset ? mDrawableRtl : mDrawableLtr;
            mHotspotX = getHotspotX(mDrawable, isRtlCharAtOffset);
            
            
            
            
            
        }

        
        protected abstract int getHotspotX(Drawable drawable, boolean isRtlRun);

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.019 -0400", hash_original_method = "FC7484D3CDDEA8A708B164CA1D725BB5", hash_generated_method = "7542E7A82AB876729A21C8F805EF09FA")
        private void startTouchUpFilter(int offset) {
            mNumberPreviousOffsets = 0;
            addPositionToTouchUpFilter(offset);
            addTaint(offset);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.019 -0400", hash_original_method = "F067815A22302FA44603BE1943641FAF", hash_generated_method = "2A9255F3B7F567DBBEE7B7E696C209B8")
        private void addPositionToTouchUpFilter(int offset) {
            mPreviousOffsetIndex = (mPreviousOffsetIndex + 1) % HISTORY_SIZE;
            mPreviousOffsets[mPreviousOffsetIndex] = offset;
            mPreviousOffsetsTimes[mPreviousOffsetIndex] = SystemClock.uptimeMillis();
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.020 -0400", hash_original_method = "55F0EF9CEF8C5AA4299D2A57A3F07803", hash_generated_method = "FBA1E0E6BAA6ECB1F5DECBAA2E94EE8B")
        private void filterOnTouchUp() {
            final long now = SystemClock.uptimeMillis();
            int i = 0;
            int index = mPreviousOffsetIndex;
            final int iMax = Math.min(mNumberPreviousOffsets, HISTORY_SIZE);
            {
                index = (mPreviousOffsetIndex - i + HISTORY_SIZE) % HISTORY_SIZE;
            } 
            {
                positionAtCursorOffset(mPreviousOffsets[index], false);
            } 
            
            
            
            
            
            
                
                
            
            
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.020 -0400", hash_original_method = "8E1053DB926B4787A5B252A5CCF7E3E6", hash_generated_method = "2D4345EF6013F875363615EAFDB115F6")
        public boolean offsetHasBeenChanged() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1036715574 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1036715574;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.021 -0400", hash_original_method = "F1B9B11E208A14EF1A8385C794E8615A", hash_generated_method = "CF96AEC91DE3DD70D8E0E3B03CA85D93")
        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            
            setMeasuredDimension(mDrawable.getIntrinsicWidth(), mDrawable.getIntrinsicHeight());
            addTaint(widthMeasureSpec);
            addTaint(heightMeasureSpec);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.021 -0400", hash_original_method = "0CEFB75F912E1774230D056666C1CB4D", hash_generated_method = "AB9D1C34799B11E284A64EEFD42FCA4A")
        public void show() {
            {
                boolean varC328115627DFB8318D2C3484959F5057_383895153 = (isShowing());
            } 
            getPositionListener().addSubscriber(this, true );
            mPreviousOffset = -1;
            positionAtCursorOffset(getCurrentCursorOffset(), false);
            hideActionPopupWindow();
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.022 -0400", hash_original_method = "58A1CA71E65CA8505283F80ECD55B125", hash_generated_method = "733B087F4D13E07199A0682C98829C56")
        protected void dismiss() {
            mIsDragging = false;
            mContainer.dismiss();
            onDetached();
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.022 -0400", hash_original_method = "E51AD13D62B6328756BEDC07E20C91A7", hash_generated_method = "B3050A8544288284788803BE9D39F46E")
        public void hide() {
            dismiss();
            TextView.this.getPositionListener().removeSubscriber(this);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.024 -0400", hash_original_method = "0D5333D88B146866CC739B7BC1FA2E0A", hash_generated_method = "660F40A87F2FD3EBA7841F9E37258150")
         void showActionPopupWindow(int delay) {
            {
                mActionPopupWindow = new ActionPopupWindow();
            } 
            {
                mActionPopupShower = new Runnable() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.024 -0400", hash_original_method = "3DEF90E085B5D89C941B0ED88F0DC7FD", hash_generated_method = "0FD34D73BCA925EC1AF406DCBE797EF5")
                    public void run() {
                        mActionPopupWindow.show();
                        
                        
                    }
};
            } 
            {
                TextView.this.removeCallbacks(mActionPopupShower);
            } 
            TextView.this.postDelayed(mActionPopupShower, delay);
            addTaint(delay);
            
            
                
            
            
                
                    
                        
                    
                
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.025 -0400", hash_original_method = "7E990B2771AC26D4AD93278F16BEC9C8", hash_generated_method = "C71F220859CCDEBCBEEA3A66F1FBEC1A")
        protected void hideActionPopupWindow() {
            {
                TextView.this.removeCallbacks(mActionPopupShower);
            } 
            {
                mActionPopupWindow.hide();
            } 
            
            
                
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.025 -0400", hash_original_method = "4C582CFB225DCFD162C1BDA55C8E191D", hash_generated_method = "4347C1D3A65AFFBD8495FE3B76120DA6")
        public boolean isShowing() {
            boolean var150C3AF6C0593C2D596AE332D213A317_1066010563 = (mContainer.isShowing());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_550548625 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_550548625;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.026 -0400", hash_original_method = "622F11C59DDFBBB8F6FA4F43A2282A80", hash_generated_method = "9B94FD9DB5ADD5EBEB29DF06773B28D5")
        private boolean isVisible() {
            {
                boolean var50BDB7CF84FD9415E39B194F38BCA676_1411774480 = (isInBatchEditMode());
            } 
            boolean varFDA4E5DACCCE5BDB1C7FF02945B0CF5E_614794789 = (TextView.this.isPositionVisible(mPositionX + mHotspotX, mPositionY));
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_711718719 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_711718719;
            
            
                
            
            
                
            
            
        }

        
        public abstract int getCurrentCursorOffset();

        
        protected abstract void updateSelection(int offset);

        
        public abstract void updatePosition(float x, float y);

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.027 -0400", hash_original_method = "23AE0E97732D2E1BD689A17102858930", hash_generated_method = "BE35E11CF9E22607F9E9B8F008E1417F")
        protected void positionAtCursorOffset(int offset, boolean parentScrolled) {
            {
                prepareCursorControllers();
            } 
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
            } 
            addTaint(parentScrolled);
            
            
                
                
            
            
                
                
                
                
                
                
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.027 -0400", hash_original_method = "13FE1FBB4F8CE63ECDC017603A6579A6", hash_generated_method = "C2349BF46CAAE365AFCB39F6A4CFC799")
        public void updatePosition(int parentPositionX, int parentPositionY,
                boolean parentPositionChanged, boolean parentScrolled) {
            positionAtCursorOffset(getCurrentCursorOffset(), parentScrolled);
            {
                {
                    {
                        mTouchToWindowOffsetX += parentPositionX - mLastParentX;
                        mTouchToWindowOffsetY += parentPositionY - mLastParentY;
                        mLastParentX = parentPositionX;
                        mLastParentY = parentPositionY;
                    } 
                    onHandleMoved();
                } 
                {
                    boolean varFF8AC1520C23E15E72910D87BF05E9DD_577371601 = (isVisible());
                    {
                        final int positionX = parentPositionX + mPositionX;
                        final int positionY = parentPositionY + mPositionY;
                        {
                            boolean varAD9BB22364C576DF82257324184E3F6D_1009678071 = (isShowing());
                            {
                                mContainer.update(positionX, positionY, -1, -1);
                            } 
                            {
                                mContainer.showAtLocation(TextView.this, Gravity.NO_GRAVITY,
                                positionX, positionY);
                            } 
                        } 
                    } 
                    {
                        {
                            boolean varAD9BB22364C576DF82257324184E3F6D_416130936 = (isShowing());
                            {
                                dismiss();
                            } 
                        } 
                    } 
                } 
                mPositionHasChanged = false;
            } 
            addTaint(parentPositionChanged);
            addTaint(parentScrolled);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.028 -0400", hash_original_method = "F8254677C35EEC48CDE0AC0DA5BFAEC5", hash_generated_method = "EE1E3C7D453F31149D17A4CF7877565A")
        @Override
        protected void onDraw(Canvas c) {
            
            mDrawable.setBounds(0, 0, mRight - mLeft, mBottom - mTop);
            mDrawable.draw(c);
            addTaint(c.getTaint());
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.029 -0400", hash_original_method = "AFDBACCAFCABC81309AB0079A4EAD49F", hash_generated_method = "4DD31CFD453ABADA2C77BD1BC9DD4F74")
        @Override
        public boolean onTouchEvent(MotionEvent ev) {
            
            {
                Object var373A6BAE1146FCFC2FEA12BA752DB0E2_1415380079 = (ev.getActionMasked());
                
                {
                    startTouchUpFilter(getCurrentCursorOffset());
                    mTouchToWindowOffsetX = ev.getRawX() - mPositionX;
                    mTouchToWindowOffsetY = ev.getRawY() - mPositionY;
                    final PositionListener positionListener = getPositionListener();
                    mLastParentX = positionListener.getPositionX();
                    mLastParentY = positionListener.getPositionY();
                    mIsDragging = true;
                } 
                
                
                {
                    final float rawX = ev.getRawX();
                    final float rawY = ev.getRawY();
                    final float previousVerticalOffset = mTouchToWindowOffsetY - mLastParentY;
                    final float currentVerticalOffset = rawY - mPositionY - mLastParentY;
                    float newVerticalOffset;
                    {
                        newVerticalOffset = Math.min(currentVerticalOffset, mIdealVerticalOffset);
                        newVerticalOffset = Math.max(newVerticalOffset, previousVerticalOffset);
                    } 
                    {
                        newVerticalOffset = Math.max(currentVerticalOffset, mIdealVerticalOffset);
                        newVerticalOffset = Math.min(newVerticalOffset, previousVerticalOffset);
                    } 
                    mTouchToWindowOffsetY = newVerticalOffset + mLastParentY;
                    final float newPosX = rawX - mTouchToWindowOffsetX + mHotspotX;
                    final float newPosY = rawY - mTouchToWindowOffsetY + mTouchOffsetY;
                    updatePosition(newPosX, newPosY);
                } 
                
                
                filterOnTouchUp();
                
                
                mIsDragging = false;
                
                
                mIsDragging = false;
                
            } 
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_338050455 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_338050455;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.029 -0400", hash_original_method = "A2059A5EB773F7552F7C3D2AAFE1E47B", hash_generated_method = "414082CECCB7EE7ED8379248E8A1204A")
        public boolean isDragging() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1373683122 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1373683122;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.029 -0400", hash_original_method = "5C16B6634DA5CEF817B70D10C5EDCDFD", hash_generated_method = "2D666D5FB7EA2FA5400262CA3F1C8A1F")
         void onHandleMoved() {
            
            hideActionPopupWindow();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.030 -0400", hash_original_method = "0744EFF256BE5CA55B7C747C6AB06865", hash_generated_method = "07B6D1B0BEF9A03B240C16C543BA4B2F")
        public void onDetached() {
            
            hideActionPopupWindow();
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.030 -0400", hash_original_field = "4D2C350B591CA62A0C667757F122D131", hash_generated_field = "917FEC01F976A8368E859F3ACCB2974D")

        private static final int HISTORY_SIZE = 5;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.030 -0400", hash_original_field = "5A211AD0D3E493272B14721269ACE755", hash_generated_field = "2607BC863EBAADB23B7B64E594D70D00")

        private static final int TOUCH_UP_FILTER_DELAY_AFTER = 150;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.030 -0400", hash_original_field = "34B7443C5D740630794D9BD84EFEB1CC", hash_generated_field = "4E35A675947440670D142A9EC9F7D555")

        private static final int TOUCH_UP_FILTER_DELAY_BEFORE = 350;
    }


    
    private class InsertionHandleView extends HandleView {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.031 -0400", hash_original_field = "E112B12E6D91B6522B4D9A9D3C4682F9", hash_generated_field = "096F0842C4660386417099FC96034322")

        private float mDownPositionX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.031 -0400", hash_original_field = "B61BFF081F30765551C8F83D5FE6EC6E", hash_generated_field = "70F6109386E0D3A8FC8471F06A6A2F6D")

        private float mDownPositionY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.031 -0400", hash_original_field = "101E91B8795FFD67FD01E75EC6725745", hash_generated_field = "1E652DE5CA4B75E782FE33512F595202")

        private Runnable mHider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.032 -0400", hash_original_method = "F74814C2C752895D626389ECC5F1998A", hash_generated_method = "5EAC7B8D71C451D641FED6330B91FC9E")
        public  InsertionHandleView(Drawable drawable) {
            super(drawable, drawable);
            addTaint(drawable.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.032 -0400", hash_original_method = "0F6B36BAB7494929112A1B2A0EAC8D6C", hash_generated_method = "9A45AA8DB51A16AABCAF026D2F7926E4")
        @Override
        public void show() {
            super.show();
            final long durationSinceCutOrCopy = SystemClock.uptimeMillis() - sLastCutOrCopyTime;
            {
                showActionPopupWindow(0);
            } 
            hideAfterDelay();
            
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.033 -0400", hash_original_method = "59B6A837BA01A6E9F2644C670D997B83", hash_generated_method = "3AF35DDAFA81E0D862669F6D69826EB8")
        public void showWithActionPopup() {
            show();
            showActionPopupWindow(0);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.035 -0400", hash_original_method = "60FC6C1FF502D89543DDAA49F0EA3292", hash_generated_method = "BB220D1CADFB1C8E65CBDB132EED8481")
        private void hideAfterDelay() {
            removeHiderCallback();
            {
                mHider = new Runnable() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.035 -0400", hash_original_method = "21815FA27ABEB649DED6A46E4F97905B", hash_generated_method = "2FF065C6B89057BF4ADFF6066462708E")
                    public void run() {
                        hide();
                        
                        
                    }
};
            } 
            TextView.this.postDelayed(mHider, DELAY_BEFORE_HANDLE_FADES_OUT);
            
            
            
                
                    
                        
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.035 -0400", hash_original_method = "C682D1056E8259D8BAEA8A544AED7A4D", hash_generated_method = "867A7692AB60EB72837193F437C04B2D")
        private void removeHiderCallback() {
            {
                TextView.this.removeCallbacks(mHider);
            } 
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.035 -0400", hash_original_method = "6DC2E28231BC586AA27A394F083E414A", hash_generated_method = "B0AFE1B737F6B4BED85BFE0C1625C495")
        @Override
        protected int getHotspotX(Drawable drawable, boolean isRtlRun) {
            int varA8B7D89D4E5B94692BDCD2F6C401B00C_437125754 = (drawable.getIntrinsicWidth() / 2);
            addTaint(drawable.getTaint());
            addTaint(isRtlRun);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1294656552 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1294656552;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.036 -0400", hash_original_method = "0786A2C72AD62CB255408C178910DEC1", hash_generated_method = "EADF8B4E2A93B0C691E330E47ADB7E78")
        @Override
        public boolean onTouchEvent(MotionEvent ev) {
            
            final boolean result = super.onTouchEvent(ev);
            {
                Object var373A6BAE1146FCFC2FEA12BA752DB0E2_184665843 = (ev.getActionMasked());
                
                mDownPositionX = ev.getRawX();
                
                
                mDownPositionY = ev.getRawY();
                
                
                {
                    boolean varEEEFE49273E9B0F999D591B54BA07697_2017313592 = (!offsetHasBeenChanged());
                    {
                        final float deltaX = mDownPositionX - ev.getRawX();
                        final float deltaY = mDownPositionY - ev.getRawY();
                        final float distanceSquared = deltaX * deltaX + deltaY * deltaY;
                        {
                            {
                                boolean var33D1446792CC339F933EE732A5EACA0F_606306758 = (mActionPopupWindow != null && mActionPopupWindow.isShowing());
                                {
                                    mActionPopupWindow.hide();
                                } 
                                {
                                    showWithActionPopup();
                                } 
                            } 
                        } 
                    } 
                } 
                
                
                hideAfterDelay();
                
                
                hideAfterDelay();
                
            } 
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1708010523 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1708010523;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.036 -0400", hash_original_method = "CA0934B91A8FE7B0CF5B9D9FD475827B", hash_generated_method = "55EBD8987F8A13ABAAA30CA852001678")
        @Override
        public int getCurrentCursorOffset() {
            int var3A0ADF979623B6D0242973915DBE6180_1910639111 = (TextView.this.getSelectionStart());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_406227732 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_406227732;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.037 -0400", hash_original_method = "A55C2EA19B8C1EC0135F14E2406421A5", hash_generated_method = "7B11087E1802F4278130367027CE5007")
        @Override
        public void updateSelection(int offset) {
            Selection.setSelection((Spannable) mText, offset);
            addTaint(offset);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.037 -0400", hash_original_method = "76FEC5259BD2EF7A10D2C6D9447263AD", hash_generated_method = "615EBD9A0AF00D72802108C8B628535A")
        @Override
        public void updatePosition(float x, float y) {
            positionAtCursorOffset(getOffsetForPosition(x, y), false);
            addTaint(x);
            addTaint(y);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.037 -0400", hash_original_method = "DF26232D8C6513289215597105F4C19A", hash_generated_method = "78394009F817C89807523E4EB6438C76")
        @Override
         void onHandleMoved() {
            
            super.onHandleMoved();
            removeHiderCallback();
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.037 -0400", hash_original_method = "58D1696EBF955B571F830BA2F6EDC257", hash_generated_method = "8A539C8A229F23A70E85F98BCBADCFB1")
        @Override
        public void onDetached() {
            
            super.onDetached();
            removeHiderCallback();
            
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.038 -0400", hash_original_field = "18BCA025F38FDD875DD515112EA41675", hash_generated_field = "6C20793C8F6CDE2B4C4C7A5C8F5C1B65")

        private static final int DELAY_BEFORE_HANDLE_FADES_OUT = 4000;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.038 -0400", hash_original_field = "936EA1DD438E31BBD9024754C3C0C340", hash_generated_field = "F31F61562A37EF5E0681F9FDEFBC7D4B")

        private static final int RECENT_CUT_COPY_DURATION = 15 * 1000;
    }


    
    private class SelectionStartHandleView extends HandleView {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.038 -0400", hash_original_method = "83BC78691BC747F1E4426492F397A3E5", hash_generated_method = "BDBC9F1394F2DA029B4526CBB7193376")
        public  SelectionStartHandleView(Drawable drawableLtr, Drawable drawableRtl) {
            super(drawableLtr, drawableRtl);
            addTaint(drawableLtr.getTaint());
            addTaint(drawableRtl.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.038 -0400", hash_original_method = "E4FEF24C3E269A0B427919DBE201803F", hash_generated_method = "E212A46EFA92E20C34110FD394FAC02D")
        @Override
        protected int getHotspotX(Drawable drawable, boolean isRtlRun) {
            {
                int var825C3AB963C858F505D8A99BED9B8FB2_823292275 = (drawable.getIntrinsicWidth() / 4);
            } 
            {
                int var2619A169F3B5A531F91E617BA41D1854_1269517931 = ((drawable.getIntrinsicWidth() * 3) / 4);
            } 
            addTaint(drawable.getTaint());
            addTaint(isRtlRun);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_17971217 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_17971217;
            
            
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.038 -0400", hash_original_method = "CA0934B91A8FE7B0CF5B9D9FD475827B", hash_generated_method = "93B143AB4D46AFCCE8DF56686F26820D")
        @Override
        public int getCurrentCursorOffset() {
            int var3A0ADF979623B6D0242973915DBE6180_766457342 = (TextView.this.getSelectionStart());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1539810762 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1539810762;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.039 -0400", hash_original_method = "E42DF79873294756C3452434D16E6BD3", hash_generated_method = "BA7FF3072E473E10381492C11BCE7A22")
        @Override
        public void updateSelection(int offset) {
            Selection.setSelection((Spannable) mText, offset, getSelectionEnd());
            updateDrawable();
            addTaint(offset);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.039 -0400", hash_original_method = "7B45D907648A79384D6568EC81E6D22D", hash_generated_method = "7C871550C494741F1DBDE51CF1D8F0BA")
        @Override
        public void updatePosition(float x, float y) {
            int offset = getOffsetForPosition(x, y);
            final int selectionEnd = getSelectionEnd();
            offset = Math.max(0, selectionEnd - 1);
            positionAtCursorOffset(offset, false);
            addTaint(x);
            addTaint(y);
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.039 -0400", hash_original_method = "0C631CE72876F998F945C3B67884BC26", hash_generated_method = "7B67CE105A855EA388EDC2F1D0D44C7D")
        public ActionPopupWindow getActionPopupWindow() {
            ActionPopupWindow varB4EAC82CA7396A68D541C85D26508E83_1678911552 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1678911552 = mActionPopupWindow;
            varB4EAC82CA7396A68D541C85D26508E83_1678911552.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1678911552;
            
            
        }

        
    }


    
    private class SelectionEndHandleView extends HandleView {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.040 -0400", hash_original_method = "883DF21D67E4B772D6E1A322F4D5F533", hash_generated_method = "2D978731C756EEC47F6BE46527AD71F8")
        public  SelectionEndHandleView(Drawable drawableLtr, Drawable drawableRtl) {
            super(drawableLtr, drawableRtl);
            addTaint(drawableLtr.getTaint());
            addTaint(drawableRtl.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.040 -0400", hash_original_method = "6A8A8B43FF48B8BB585E51FD6E86C9E2", hash_generated_method = "03509C3EE8B32091E1A2F9C1FD5E122F")
        @Override
        protected int getHotspotX(Drawable drawable, boolean isRtlRun) {
            {
                int var2619A169F3B5A531F91E617BA41D1854_163403748 = ((drawable.getIntrinsicWidth() * 3) / 4);
            } 
            {
                int var825C3AB963C858F505D8A99BED9B8FB2_1433805708 = (drawable.getIntrinsicWidth() / 4);
            } 
            addTaint(drawable.getTaint());
            addTaint(isRtlRun);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_547526184 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_547526184;
            
            
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.040 -0400", hash_original_method = "CA6DDFB8F86FC43076502B090D003904", hash_generated_method = "FFC15F00B67512EC4EEF7A80BA25692E")
        @Override
        public int getCurrentCursorOffset() {
            int varA2E0C17AA3D1EB612E8CF0B487723C9B_2028397350 = (TextView.this.getSelectionEnd());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1134620416 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1134620416;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.041 -0400", hash_original_method = "B3473CE6965F2521B605BA0101D0A91A", hash_generated_method = "D60716072937499BE12E95FCF3FEF918")
        @Override
        public void updateSelection(int offset) {
            Selection.setSelection((Spannable) mText, getSelectionStart(), offset);
            updateDrawable();
            addTaint(offset);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.041 -0400", hash_original_method = "DE26EB392137324C128BF7B92FEE748A", hash_generated_method = "12E20691A6B235469D11BB736AB74836")
        @Override
        public void updatePosition(float x, float y) {
            int offset = getOffsetForPosition(x, y);
            final int selectionStart = getSelectionStart();
            offset = Math.min(selectionStart + 1, mText.length());
            positionAtCursorOffset(offset, false);
            addTaint(x);
            addTaint(y);
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.041 -0400", hash_original_method = "1AE0953CF1E401F1791B2AA9D0C762E1", hash_generated_method = "BA1A80848BD3464B993B996B099EA4D3")
        public void setActionPopupWindow(ActionPopupWindow actionPopupWindow) {
            mActionPopupWindow = actionPopupWindow;
            addTaint(actionPopupWindow.getTaint());
            
            
        }

        
    }


    
    private class InsertionPointCursorController implements CursorController {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.041 -0400", hash_original_field = "D82B253C7CDC2B84A5A684E7A5D691F6", hash_generated_field = "25F2B1ECCF00A4687A034C77E527EB90")

        private InsertionHandleView mHandle;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.042 -0400", hash_original_method = "85F6797FDF607C95B81DF68401917B00", hash_generated_method = "85F6797FDF607C95B81DF68401917B00")
        public InsertionPointCursorController ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.042 -0400", hash_original_method = "5D45AEF69914729B932C554DDDCEB4D3", hash_generated_method = "5EA31E88AA733E4213C40495380DD157")
        public void show() {
            getHandle().show();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.042 -0400", hash_original_method = "BEDA636D814D43341B0837622BB75D12", hash_generated_method = "16B9CF12A56CC458EBA14E68A570766E")
        public void showWithActionPopup() {
            getHandle().showWithActionPopup();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.043 -0400", hash_original_method = "99DAD3C319227F2A1F78AE95D96BD2B3", hash_generated_method = "1A323EAA6938558E1F65AF39AFB175B6")
        public void hide() {
            {
                mHandle.hide();
            } 
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.043 -0400", hash_original_method = "43F562659DF9586EE8DC985200A1394B", hash_generated_method = "AFA5EE836BA01E42C65DC8B7F78125A2")
        public void onTouchModeChanged(boolean isInTouchMode) {
            
            {
                hide();
            } 
            addTaint(isInTouchMode);
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.045 -0400", hash_original_method = "AFBF832B3C2DD5F3EC6366306B6BB027", hash_generated_method = "732EC10995564AEAAE615A4794CDD5F9")
        private InsertionHandleView getHandle() {
            InsertionHandleView varB4EAC82CA7396A68D541C85D26508E83_2107317541 = null; 
            {
                mSelectHandleCenter = mContext.getResources().getDrawable(
                        mTextSelectHandleRes);
            } 
            {
                mHandle = new InsertionHandleView(mSelectHandleCenter);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_2107317541 = mHandle;
            varB4EAC82CA7396A68D541C85D26508E83_2107317541.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2107317541;
            
            
                
                        
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.074 -0400", hash_original_method = "5CA35A7F100FC077200BA56F0D1F67CB", hash_generated_method = "7637A3785397444DE06AF16DB24DA9B6")
        @Override
        public void onDetached() {
            
            final ViewTreeObserver observer = getViewTreeObserver();
            observer.removeOnTouchModeChangeListener(this);
            mHandle.onDetached();
            
            
            
            
        }

        
    }


    
    private class SelectionModifierCursorController implements CursorController {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.074 -0400", hash_original_field = "1DDEE8F82039A4BD80420CF27F9E1A6A", hash_generated_field = "0F7E872CABC7DF9A40441A432FBD1FBF")

        private SelectionStartHandleView mStartHandle;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.074 -0400", hash_original_field = "7F3172BBEA8484D85B326E672A5A423F", hash_generated_field = "19A28AD860044ACC5058053954B56AC1")

        private SelectionEndHandleView mEndHandle;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.074 -0400", hash_original_field = "17546985D71D9022C1E12FDE1CAFC6E5", hash_generated_field = "6FCDDDBC590A39D5D0BCAFDBA6EA63E5")

        private int mMinTouchOffset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.074 -0400", hash_original_field = "690ACF87EFB1963C7A4637EB14226F0B", hash_generated_field = "F147B97F09325CC9B6538D3E5D26C2FE")

        private int mMaxTouchOffset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.074 -0400", hash_original_field = "EEB78043F7A84B6B33C67CCCFE8BE924", hash_generated_field = "7CECB42F787323EA52A439F784FC8CBE")

        private long mPreviousTapUpTime = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.074 -0400", hash_original_field = "868B14065502FE9C1E526C78E73FCAF9", hash_generated_field = "0BA74B206DFC70E28F82C95A0E3C40BF")

        private float mPreviousTapPositionX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.074 -0400", hash_original_field = "78D2D33220DDE6DE9E8A068208CC3141", hash_generated_field = "1F4747912771D340E5AE19794AD2D9A3")

        private float mPreviousTapPositionY;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.074 -0400", hash_original_method = "7762686ED4BD194662F98430835FCC93", hash_generated_method = "996EF3777B9152A62DF6DD828F075A23")
          SelectionModifierCursorController() {
            resetTouchOffsets();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.074 -0400", hash_original_method = "803DF98A86477F9509B518860444CA62", hash_generated_method = "F54F06B6847EA0B69FD7F163D880744B")
        public void show() {
            {
                boolean var50BDB7CF84FD9415E39B194F38BCA676_1567736904 = (isInBatchEditMode());
            } 
            initDrawables();
            initHandles();
            hideInsertionPointCursorController();
            
            
                
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.075 -0400", hash_original_method = "2C322B9176F95E96CE86AF105C0AA144", hash_generated_method = "F631ADBBD886B9722F2546BD7CFF6D80")
        private void initDrawables() {
            {
                mSelectHandleLeft = mContext.getResources().getDrawable(
                        mTextSelectHandleLeftRes);
            } 
            {
                mSelectHandleRight = mContext.getResources().getDrawable(
                        mTextSelectHandleRightRes);
            } 
            
            
                
                        
            
            
                
                        
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.075 -0400", hash_original_method = "C3351664D38EE8E6983EFA56F5011D2A", hash_generated_method = "99C9F2D76A1C7AED04BBBED298E45F37")
        private void initHandles() {
            {
                mStartHandle = new SelectionStartHandleView(mSelectHandleLeft, mSelectHandleRight);
            } 
            {
                mEndHandle = new SelectionEndHandleView(mSelectHandleRight, mSelectHandleLeft);
            } 
            mStartHandle.show();
            mEndHandle.show();
            mStartHandle.showActionPopupWindow(DELAY_BEFORE_REPLACE_ACTION);
            mEndHandle.setActionPopupWindow(mStartHandle.getActionPopupWindow());
            hideInsertionPointCursorController();
            
            
                
            
            
                
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.075 -0400", hash_original_method = "9904AE40606D29E60FAC10481978E041", hash_generated_method = "3FEAC2D7413111579488390C9577D61B")
        public void hide() {
            mStartHandle.hide();
            mEndHandle.hide();
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.076 -0400", hash_original_method = "4BB059019645E4258A18514D6F6D1609", hash_generated_method = "C71E26686CB605E412079ABE22B94D21")
        public void onTouchEvent(MotionEvent event) {
            
            {
                Object varF6D597E8558CB9D89114B4B1D82BA68F_1187943363 = (event.getActionMasked());
                
                final float x = event.getX();
                
                
                final float y = event.getY();
                
                
                mMinTouchOffset = mMaxTouchOffset = getOffsetForPosition(x, y);
                
                
                long duration = SystemClock.uptimeMillis() - mPreviousTapUpTime;
                
                
                {
                    boolean varD222D501AFFB3FFBAB7C6BF5A68FBCF1_1874000201 = (duration <= ViewConfiguration.getDoubleTapTimeout() &&
                            isPositionOnText(x, y));
                    {
                        final float deltaX = x - mPreviousTapPositionX;
                        final float deltaY = y - mPreviousTapPositionY;
                        final float distanceSquared = deltaX * deltaX + deltaY * deltaY;
                        {
                            startSelectionActionMode();
                            mDiscardNextActionUp = true;
                        } 
                    } 
                } 
                
                
                mPreviousTapPositionX = x;
                
                
                mPreviousTapPositionY = y;
                
                
                {
                    boolean var4F7B392379BD182D25B1AE93077ACAB8_945655779 = (mContext.getPackageManager().hasSystemFeature(
                            PackageManager.FEATURE_TOUCHSCREEN_MULTITOUCH_DISTINCT));
                    {
                        updateMinAndMaxOffsets(event);
                    } 
                } 
                
                
                mPreviousTapUpTime = SystemClock.uptimeMillis();
                
            } 
            addTaint(event.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.077 -0400", hash_original_method = "ABEB7C98C3FEAD2725211345FA5A10D0", hash_generated_method = "0BED4D4A3926766C6FCA396F79689B12")
        private void updateMinAndMaxOffsets(MotionEvent event) {
            int pointerCount = event.getPointerCount();
            {
                int index = 0;
                {
                    int offset = getOffsetForPosition(event.getX(index), event.getY(index));
                    mMinTouchOffset = offset;
                    mMaxTouchOffset = offset;
                } 
            } 
            addTaint(event.getTaint());
            
            
            
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.077 -0400", hash_original_method = "CE1D6B62E449D2E0E68A6EA4156BEDFA", hash_generated_method = "9ABB813C2A4E418141156FC5FD327E33")
        public int getMinTouchOffset() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1996964834 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1996964834;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.078 -0400", hash_original_method = "C55B3C28483F8C218641DDDF4F4BCFF7", hash_generated_method = "51BF099EAF414E6F14FD8B7305321250")
        public int getMaxTouchOffset() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_846929877 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_846929877;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.078 -0400", hash_original_method = "4C87B6BF406B366B26A5C4FE4B60E794", hash_generated_method = "9EFAFC374F80667294B5FCC935B7A9C3")
        public void resetTouchOffsets() {
            mMinTouchOffset = mMaxTouchOffset = -1;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.078 -0400", hash_original_method = "CED25BB71024452A25A320AF88BD1346", hash_generated_method = "63436C93DAAEBF1EDFE3A9C521261D30")
        public boolean isSelectionStartDragged() {
            boolean var3AC7E3EAE321C45E3F97AC24793B70E6_367896602 = (mStartHandle != null && mStartHandle.isDragging());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_715886608 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_715886608;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.078 -0400", hash_original_method = "43F562659DF9586EE8DC985200A1394B", hash_generated_method = "AFA5EE836BA01E42C65DC8B7F78125A2")
        public void onTouchModeChanged(boolean isInTouchMode) {
            
            {
                hide();
            } 
            addTaint(isInTouchMode);
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_method = "190B38DD5A1110FFE55D8237DE7DCE67", hash_generated_method = "6002FF89F7E7A23540F2EF4F37A15FC8")
        @Override
        public void onDetached() {
            
            final ViewTreeObserver observer = getViewTreeObserver();
            observer.removeOnTouchModeChangeListener(this);
            mStartHandle.onDetached();
            mEndHandle.onDetached();
            
            
            
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "8D0BCBE22EC74AB6363483A97E74D867", hash_generated_field = "8C0DD79BB03BF5A19DC440BA5A7C743D")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "90BF1EE71A4DB43CBA163484BD738881", hash_generated_field = "318C0D140A347FB72B8CF35CDBABB5E4")

    static final String LOG_TAG = "TextView";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "A4A1A96FF2E19D971B2D301080EE8C58", hash_generated_field = "8F4574CB2F6E43394A5BA522A2B5B852")

    static final boolean DEBUG_EXTRACT = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "18CA7A508D8AE1730B8CBC0435F40D92", hash_generated_field = "0C5EC1740FD044550CD627FFA2580630")

    private static final int PRIORITY = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "5C25431CEAC1058F7B4F73D132DD44B4", hash_generated_field = "45D348A3F29C90D42A8C5DC6B241EAC1")

    private static final int PREDRAW_NOT_REGISTERED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "21B0F640D768604C58C1490A1DFBA771", hash_generated_field = "62D44753BF78CBC0F9661335F4D5609E")

    private static final int PREDRAW_PENDING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "8A7412722DCADF6CC4FAEE79ED70EACB", hash_generated_field = "363B97B9FD402B0FDBC0C24AF5E9CCFB")

    private static final int PREDRAW_DONE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "07F356F3070D07B6930DE3A9967108FE", hash_generated_field = "308BD7C2CCB94571F8E68E822492425A")

    private static final int SANS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "5B5E6C83C125CC348E4EE28ACCFE5BFF", hash_generated_field = "AD8E248EA94D9FBB450731AC61EA4CF6")

    private static final int SERIF = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "399280F48C3EEEEAEAD47346CF3011F2", hash_generated_field = "1E362376CB7EB57CA2898CE49E4D3589")

    private static final int MONOSPACE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "EFFD644F69714ABFB2C24FDB3792270D", hash_generated_field = "8603C5457C9E9D466A6637F82152429F")

    private static final int SIGNED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "A3C08F2EE3FEAB3A87DC101CC1A0E1B0", hash_generated_field = "F04391D0E1DECB4D13494A519EEF830A")

    private static final int DECIMAL = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "B5762757AEE684A93E08453DCC72718E", hash_generated_field = "0A9F849D4DA2786122725914FA369286")

    private static final int MARQUEE_FADE_NORMAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "685E750B6695CBAA6027EFEBD1DD0929", hash_generated_field = "133D51D3A4503E091F405407040E7EC2")

    private static final int MARQUEE_FADE_SWITCH_SHOW_ELLIPSIS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "BAD4122AB746D6D5A26349392348653A", hash_generated_field = "B9CEA3C7890F9A20881FBE5B1B4F328A")

    private static final int MARQUEE_FADE_SWITCH_SHOW_FADE = 2;
    static {
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.measureText("H");
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "3495E75508822AD7294B9D1B2FFFD8F2", hash_generated_field = "809D152A38BBF91CF345EB9A3A2C2FD9")

    static final int EXTRACT_NOTHING = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "CE33E876E6E0D3413392BF4D8BA5058C", hash_generated_field = "7BA27C744DDFC4A241AE9CAF8C089243")

    static final int EXTRACT_UNKNOWN = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "9D2F26242AC02A08143A50067F62CB8B", hash_generated_field = "629A8FC22D1527458B2653CFE43B483D")

    private static final BoringLayout.Metrics UNKNOWN_BORING = new BoringLayout.Metrics();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "335E7B933E2786DDEF5BD0BD0D6F57B7", hash_generated_field = "F08D4DB64B803815AE7522F1172B7B26")

    private static final int ID_SELECT_ALL = android.R.id.selectAll;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "FCF0B45B56220E42037E2959D5C784C5", hash_generated_field = "45199D67295B65909EEDA2BE3B9357D0")

    private static final int ID_CUT = android.R.id.cut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "B59ED8F62B5AFBC9ECFF0B033CA31BFE", hash_generated_field = "BDD63BE32ED24AFE6036B6E73DCBA9C7")

    private static final int ID_COPY = android.R.id.copy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "C538E3A9644EFB1E101695160425236B", hash_generated_field = "5F09992E187A3237CB33E9C773AB2BFD")

    private static final int ID_PASTE = android.R.id.paste;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "73F3CAC515701006490A63FE8A88C6C6", hash_generated_field = "6B7729A476E0DC23D4228210CAC8F2AF")

    private static final int LINES = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "73A4320C88A11B2FCF58BE496FEEA70E", hash_generated_field = "38D0380954D68681C2B16AF77B10E2B1")

    private static final int EMS = LINES;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "0A7D60D23D133E25B638079E87CAA132", hash_generated_field = "F3B05802BBCCF9A648D3A31248579690")

    private static final int PIXELS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "213EEEA9607FBD0242D99285FE74967E", hash_generated_field = "F1AA779AD4EF6BDB726801C8FA756FE2")

    private static final RectF sTempRect = new RectF();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "8212A1E8877C71B5CDD8A07429A76426", hash_generated_field = "B1C3BA47068027642A7B08D73ED520A7")

    private static final float[] sTmpPosition = new float[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "E200AB0F64D5773E76DC3D915E17A741", hash_generated_field = "BE987383F3E2A020A9B790ED1BD41CEC")

    private static final int VERY_WIDE = 1024*1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "C9D1C26ABB8B6EF477DF5359176F9D87", hash_generated_field = "75590DDE5A63D4C5AC8A6BCF800B7F27")

    private static final int BLINK = 500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "D4B6C25D0A03D262C947BCD869108225", hash_generated_field = "D83A807392D6236B9C81A46BCD93EAD5")

    private static final int ANIMATED_SCROLL_GAP = 250;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "A0DA38A5AAD1658278F1D161AF84C1BC", hash_generated_field = "EDD7FE0B7D12EE9C3486272F367681B2")

    private static final InputFilter[] NO_FILTERS = new InputFilter[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "248F542BD33F18FF283146E6429096A7", hash_generated_field = "14183BB546091CFA567F945F2B307159")

    private static final Spanned EMPTY_SPANNED = new SpannedString("");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "988659B291D672B8BE5DAE064AE3ECAA", hash_generated_field = "7034D880E0F4FCBF3812B9BF24C47313")

    private static int DRAG_SHADOW_MAX_TEXT_LENGTH = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "1D09C86A4C0CE5611F928ED8E5FF76B7", hash_generated_field = "191F5BCD79A0AB522145FB777A15B556")

    private static long sLastCutOrCopyTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.079 -0400", hash_original_field = "722A3224076063AF8DBCF4E5714C29A3", hash_generated_field = "426A62F90365670637A2793B721C0BE6")

    private static final int[] MULTILINE_STATE_SET = { R.attr.state_multiline };
}

