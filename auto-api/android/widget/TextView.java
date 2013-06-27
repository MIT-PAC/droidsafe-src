package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.464 -0400", hash_original_field = "5C9E3264119E57696644BE19B3FE1DAC", hash_generated_field = "695EE05B4D22A341938A08B09254F27D")

    private int mCurrentAlpha = 255;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.465 -0400", hash_original_field = "5F09FBDC9860691A5956F34FA173E62B", hash_generated_field = "D9B0D13C40450FC3F14D851B73E25CE9")

    int[] mTempCoords = new int[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.465 -0400", hash_original_field = "B856E02779DE10EA84221FCD1182A1A3", hash_generated_field = "9F1BD97088B2257F3EF12D8B258FBB69")

    Rect mTempRect;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.465 -0400", hash_original_field = "D617392BE941E0902ECF95DB04F038E8", hash_generated_field = "F28951B95CC06B6EA971BC050BE7DE22")

    private ColorStateList mTextColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.465 -0400", hash_original_field = "284F9A87F549A6DC680E2D58A116EBA3", hash_generated_field = "DDC7D6F23AA3E68217EEBC390EBBF804")

    private int mCurTextColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.465 -0400", hash_original_field = "F97B29F3780CA1FC4E9BEA1ABC67D847", hash_generated_field = "9F10F4704A7B04F2C4871DD09D608BF0")

    private ColorStateList mHintTextColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.465 -0400", hash_original_field = "68148E7850655C81DB19FCC253D99F98", hash_generated_field = "AE6720DC2457713C725D4C56460C9DC2")

    private ColorStateList mLinkTextColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.465 -0400", hash_original_field = "CFE453DD74E7FC90BED21ABE94CDF43F", hash_generated_field = "5A275158889F26A8351A14A4F8F0D9DD")

    private int mCurHintTextColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.465 -0400", hash_original_field = "BAD96035AC86533B7D8C4EAA84835DC4", hash_generated_field = "8D828812FF76F4DB76DB63A2398AF5C6")

    private boolean mFreezesText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.465 -0400", hash_original_field = "201B24234F3C5EAB7B9E6C89937009ED", hash_generated_field = "DC2B1736EBA532012F131A593130D38C")

    private boolean mFrozenWithFocus;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.465 -0400", hash_original_field = "7A52CFFAF3A3D05848839CC4A3DCBF66", hash_generated_field = "C16E2255547619A01263AC9BE7B2E134")

    private boolean mTemporaryDetach;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.465 -0400", hash_original_field = "F42B4922CBBBAC0A00222DB39CFC509A", hash_generated_field = "5C6A9DB416A74CA58302EC973E49E0E3")

    private boolean mDispatchTemporaryDetach;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.465 -0400", hash_original_field = "4A82A355E70C4C4283892E1CED60A9AB", hash_generated_field = "9EDEB4E5741E85F20A0B3026682B4863")

    private boolean mDiscardNextActionUp = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.465 -0400", hash_original_field = "9074015FCBB83111EEFF764D36799E0A", hash_generated_field = "7878E8941BAE988F39F461EEC8B7CCDF")

    private boolean mIgnoreActionUpEvent = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.465 -0400", hash_original_field = "737580135BF67E97C636411ED2235180", hash_generated_field = "6D10B174FA8E858FA02AA86D85663AD4")

    private Editable.Factory mEditableFactory = Editable.Factory.getInstance();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.465 -0400", hash_original_field = "289A806C8E357E566D214939426916BE", hash_generated_field = "10200E22D9B91A38418945F375917DF5")

    private Spannable.Factory mSpannableFactory = Spannable.Factory.getInstance();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.465 -0400", hash_original_field = "0021C70065C1D0F5DA3DE4086470A1AC", hash_generated_field = "E95B50404D53A741F5CBE2BA4A3E9431")

    private float mShadowRadius;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.465 -0400", hash_original_field = "C882880E2E13EA27F677D50AEA4C2D30", hash_generated_field = "CC57606479233D9D93ED0B57219ED7CE")

    private float mShadowDx;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.465 -0400", hash_original_field = "F6C0DA7C4DD70FAC183A5D5D940CBEBF", hash_generated_field = "5A526AAA72A41CBD334BF1D9A433DD2D")

    private float mShadowDy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.465 -0400", hash_original_field = "7302E8BC04F6DCBBC91913A350368A28", hash_generated_field = "A64E4C65A01F6E2CFC767B574B9B2B25")

    private int mPreDrawState = PREDRAW_NOT_REGISTERED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.465 -0400", hash_original_field = "069F6473CFDC9651640842904E9A1296", hash_generated_field = "4984AF4C2DB23A63F16A5A1F70DBBE23")

    private TextUtils.TruncateAt mEllipsize = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.465 -0400", hash_original_field = "1891CBC78C734C6A7EBB0D921FFE84B0", hash_generated_field = "DA26917F8EABBE7FB6675DEEA4CDD42F")

    private Drawables mDrawables;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.465 -0400", hash_original_field = "6F8A455C94CBB7A00E920835C0C8964C", hash_generated_field = "8B5DD3B1B3DD08B759F16C26A18B23CA")

    private CharSequence mError;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.465 -0400", hash_original_field = "AF2B7FEC596D9156D61CB482234E01CC", hash_generated_field = "EA3CC19FBACB277B4E0CFF08BB94E8C5")

    private boolean mErrorWasChanged;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.465 -0400", hash_original_field = "E863CEB96C01242A6262A422DC21BA91", hash_generated_field = "3D80774243FE973442F872DD04152DA0")

    private ErrorPopup mPopup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.465 -0400", hash_original_field = "5194879693A231FFFC209BB8D83F7343", hash_generated_field = "6846AAA470F19DD23ADF6122A2BA28EB")

    private boolean mShowErrorAfterAttach;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.465 -0400", hash_original_field = "F404BF7CA0765A26006895B16ECAFD6F", hash_generated_field = "ED2A81D0AA757272F61284C94F8CB304")

    private CharWrapper mCharWrapper = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.465 -0400", hash_original_field = "CD0B182A36A51B8060A5E676C89B9336", hash_generated_field = "89CF3363829B7F18DD131036DE4F0A1D")

    private boolean mSelectionMoved = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.465 -0400", hash_original_field = "2E9AC3E359ECE072850F1292DFBBDAE1", hash_generated_field = "B3FE9FD9576C4C98F6C4A561DFC39377")

    private boolean mTouchFocusSelected = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.466 -0400", hash_original_field = "E87C3F5C2A7CB77C6DC56288528EBF20", hash_generated_field = "E6A1FEE90A4433FD8B74A8F47A5E0E13")

    private Marquee mMarquee;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.466 -0400", hash_original_field = "533339E6FBD11F3E45A14F8C0EF95135", hash_generated_field = "E1D72A00A2DFF52C1CB7FA697FBC9898")

    private boolean mRestartMarquee;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.466 -0400", hash_original_field = "AE8C8553F79BDDDB297AFF9496B70AF4", hash_generated_field = "A706E5A4CE970BDC6898B0827FF2B8CB")

    private int mMarqueeRepeatLimit = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.466 -0400", hash_original_field = "2E491392BA918DD2D8A686099734FFCA", hash_generated_field = "E1403D58E8CC04D062F12EDE2F93FC48")

    InputContentType mInputContentType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.466 -0400", hash_original_field = "CAE876BD1DF758FC0DA52C899F537A65", hash_generated_field = "23BEF75E7D0F22ED753350F2B8C53A97")

    InputMethodState mInputMethodState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.466 -0400", hash_original_field = "B36145192741179BFC019A94217ED239", hash_generated_field = "29065B52E0E09EECA006A7A5A8F78524")

    private int mTextSelectHandleLeftRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.466 -0400", hash_original_field = "14F0D0E28BFB85ADAF9CBB2462BD60AC", hash_generated_field = "9FC61DEFB614916CB19F9F18AE4BBCF8")

    private int mTextSelectHandleRightRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.466 -0400", hash_original_field = "AECC1EE6EF517B4633C961D68D0A0721", hash_generated_field = "3CAFBFF7DAB243B3E8841417BD521E3B")

    private int mTextSelectHandleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.466 -0400", hash_original_field = "F1F871F8469791F3048EECEE2DDAE51A", hash_generated_field = "899920185C4484CA31C0F443B855010D")

    private int mTextEditSuggestionItemLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.466 -0400", hash_original_field = "7B7F1DB21F46A09A666E491035DEE1ED", hash_generated_field = "EE9100393A7AA7FB8D758BBE48AF5F35")

    private SuggestionsPopupWindow mSuggestionsPopupWindow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.466 -0400", hash_original_field = "B2BAA47BFF891CBC7774865E53B1B27D", hash_generated_field = "84F489ACE61EF8AEAEC12B2F2593297C")

    private SuggestionRangeSpan mSuggestionRangeSpan;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.466 -0400", hash_original_field = "F1CB45A993CF82C01E8B9DD86DF31C59", hash_generated_field = "02A74559D19DD086E571BE2B3AA83A8F")

    private int mCursorDrawableRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.466 -0400", hash_original_field = "9D532FDC5F3401D628291677F396D047", hash_generated_field = "EB46C2122C9C5EFE5F6AAC324C413D2F")

    private Drawable[] mCursorDrawable = new Drawable[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.466 -0400", hash_original_field = "45877EB65372EE0549FF6482C357C77C", hash_generated_field = "8657E501533B875D60AA97A414831DBD")

    private int mCursorCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.466 -0400", hash_original_field = "C68967AB1B9693AAC052C4158F7203F8", hash_generated_field = "72952B5254D373336CA0A7F293822C5C")

    private Drawable mSelectHandleLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.466 -0400", hash_original_field = "8DC2F2BCAE53DF5B1B45FBFA787F7CC7", hash_generated_field = "BE0700D1B06984983D5C63B2FD49DB15")

    private Drawable mSelectHandleRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.466 -0400", hash_original_field = "B0A089E200495488AE5D10A63801B499", hash_generated_field = "08AFAF21E471F629DFA4D8F58C03B94B")

    private Drawable mSelectHandleCenter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.466 -0400", hash_original_field = "DC2833E523C718C37F76D9CECDB613DC", hash_generated_field = "FB42528DAE75699ED1B6CC0A5A674A55")

    private PositionListener mPositionListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.466 -0400", hash_original_field = "43041C61A1DA9DC67B7FC8F5C22C953B", hash_generated_field = "40ACD97E99B995A7FCA41633B5D7F459")

    private float mLastDownPositionX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.466 -0400", hash_original_field = "5211DB32F771F4FB6B254B7227DAF0E4", hash_generated_field = "25FA8F6701B3D1C16B56B376BE78487E")

    private float mLastDownPositionY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.466 -0400", hash_original_field = "7F39B50ADACE58DDF3868451FDACBFC3", hash_generated_field = "4A2FD1B1A3BA8B998F40B2C0D929E44F")

    private Callback mCustomSelectionActionModeCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.466 -0400", hash_original_field = "9154AC84CF6CB434E6C44058845F83A6", hash_generated_field = "FE1D03D7C65C5CEC56D15F835C8E0A4C")

    private int mSquaredTouchSlopDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.466 -0400", hash_original_field = "5D2B1AB08FC4BB71F1E4E3942287F4AC", hash_generated_field = "301C10EAD74C8CF352F89DA817F09EF5")

    private boolean mCreatedWithASelection = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.466 -0400", hash_original_field = "435FE0944C142BE50AF524B687A36B73", hash_generated_field = "B64007D723854AD8DD3C03BCCA9834A5")

    private WordIterator mWordIterator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.466 -0400", hash_original_field = "651FF4D8C7C964F5DF1C680A515E9458", hash_generated_field = "D936161C5FDE3DD296D182C31C4ED500")

    private SpellChecker mSpellChecker;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.466 -0400", hash_original_field = "A9B899D11C5154E2959E6CD08A569B50", hash_generated_field = "9735B231E6C5186126230C7191CC2027")

    private boolean mSoftInputShownOnFocus = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.466 -0400", hash_original_field = "AE353DD0C65715072A815AA3EFBB914A", hash_generated_field = "AE17667AF244FFA2D2100AF02F19092F")

    private Layout.Alignment mLayoutAlignment;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.466 -0400", hash_original_field = "C13638B20608314DC4A1841631D399DA", hash_generated_field = "B8FF70A86AC51485598DFBCFFB37720F")

    private TextAlign mTextAlign = TextAlign.INHERIT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.466 -0400", hash_original_field = "B5E0024E63436049FABCB39FDCDB387F", hash_generated_field = "88A15E3715BB62052F2448ED895C9BBA")

    private boolean mResolvedDrawables = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.467 -0400", hash_original_field = "8EDC8B08CA53BD0E51A567DB27353463", hash_generated_field = "601913B8190553DCCF7F60EF06AC5711")

    private int mMarqueeFadeMode = MARQUEE_FADE_NORMAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.467 -0400", hash_original_field = "A88463CF8707DFCA9D81D838EE11C191", hash_generated_field = "2AD0F97487EA7D5F86DCAFC3259ED37F")

    private Layout mSavedMarqueeModeLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.467 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "6CF16E724237A2841199FB30284CED38")

    @ViewDebug.ExportedProperty(category = "text") private CharSequence mText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.467 -0400", hash_original_field = "116BEBA84C265E44D657283E75BE60A1", hash_generated_field = "30221785C9497266E9C8ABBDFDCBE7EC")

    private CharSequence mTransformed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.467 -0400", hash_original_field = "5E344D0215B7C42F8F0B334676E4F343", hash_generated_field = "D0147D76A56855726ED38FF51B24F6FD")

    private BufferType mBufferType = BufferType.NORMAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.467 -0400", hash_original_field = "F5F439B44EA2FC34C5A7743F482ED12E", hash_generated_field = "7CCB62B854814A590D259304E0729FB4")

    private int mInputType = EditorInfo.TYPE_NULL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.467 -0400", hash_original_field = "A6D986505B9BCC5256C3BA5D73171C37", hash_generated_field = "D5CD99D8D87E7592EC6B5781C6FFB2FA")

    private CharSequence mHint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.467 -0400", hash_original_field = "D2F4B35B64C2568AE9793BBC2586054D", hash_generated_field = "EFAB677B32664E9E21A5DE46AC4EC1D6")

    private Layout mHintLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.467 -0400", hash_original_field = "BF2A01F10E67DAFA01668D8D4043BDC6", hash_generated_field = "CE990DF015C00781E7408846E8AEC5CB")

    private KeyListener mInput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.467 -0400", hash_original_field = "4AC20A6658642819EC3222EDB1107622", hash_generated_field = "BFA3240A2EA25F7A99F6D250E98184A7")

    private MovementMethod mMovement;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.467 -0400", hash_original_field = "BBDAB2FB373D7DA19760B893D5429B4A", hash_generated_field = "5EB7FC8FAB0A2FCCA9E8BF646DA1559A")

    private TransformationMethod mTransformation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.467 -0400", hash_original_field = "53FA59A802AE59C1CF5E57E2D5BFA622", hash_generated_field = "487D1BC024AFF96C6A5C663DC3AA641C")

    private boolean mAllowTransformationLengthChange;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.472 -0400", hash_original_field = "9607A29B4CC612A05365947273897FCA", hash_generated_field = "0D3B538949663CFF4038D6D64784977E")

    private ChangeWatcher mChangeWatcher;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.472 -0400", hash_original_field = "76E8AF78EA383C38A6F80E45CCFEA268", hash_generated_field = "B7D02B86862FFD54C18C460CFF0B0C2C")

    private ArrayList<TextWatcher> mListeners = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.472 -0400", hash_original_field = "A623C6B7D6CD75F8A26EF2CAD7479AA5", hash_generated_field = "6AD5EFC1421B741B1A8F78A5B815BBFE")

    private TextPaint mTextPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.472 -0400", hash_original_field = "462CCCBD3E9AD62A8A3FAE775E09DC1E", hash_generated_field = "21DF46CCA8F8000ED3BFF8BCF4D828BF")

    private boolean mUserSetTextScaleX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.472 -0400", hash_original_field = "BA05C1134DA05E6CE3231B819D53C1D5", hash_generated_field = "8983462E53EAFA6E482F98025B0E9AB8")

    private Paint mHighlightPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.472 -0400", hash_original_field = "CA2322AF1A6B4A09C8EDBDA4A3F74C10", hash_generated_field = "D25F7D2FFD7EFCE07B644E099B3A56D3")

    private int mHighlightColor = 0x6633B5E5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.472 -0400", hash_original_field = "AF58F50E47532278404C3D8470630FC4", hash_generated_field = "C7DD20DF980F25C7241B09204173E163")

    protected Layout mLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.472 -0400", hash_original_field = "36BB94A531229DD21F420AABF0C748F8", hash_generated_field = "0FB0111930B8AF18F464AB4FA2C6200F")

    private long mShowCursor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.472 -0400", hash_original_field = "57ABA66DF5CCF392086380D760C5BF59", hash_generated_field = "AC59C081943B626844E369F1A5892415")

    private Blink mBlink;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.472 -0400", hash_original_field = "6D2634EB69BE4B718BBEA043740ED62B", hash_generated_field = "F225E507C7DF6D613F7CBC4F577CB716")

    private boolean mCursorVisible = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.472 -0400", hash_original_field = "A2FF5C87B9A9D291A2D83F0CF574DDB4", hash_generated_field = "FDFA161EB04278A13E9ECB602C9782F4")

    private InsertionPointCursorController mInsertionPointCursorController;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.472 -0400", hash_original_field = "270783E153A9BE598B5DECCCBEDA6C36", hash_generated_field = "2218505DE3146C01814D6E81956F9301")

    private SelectionModifierCursorController mSelectionModifierCursorController;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.472 -0400", hash_original_field = "40FBF5FA719BD485A92A81EE27C61592", hash_generated_field = "656A5581A4DED5B2323E4335C55017B9")

    private ActionMode mSelectionActionMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.472 -0400", hash_original_field = "BC332654D5E01CC0638CB4493BFC9F05", hash_generated_field = "D1C9F3209CB13DAFB4E161EED540694F")

    private boolean mInsertionControllerEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.472 -0400", hash_original_field = "23C753EE6F79BCE184A6A1DB0589DB51", hash_generated_field = "E71C12A23BD84DA882CBDDBA123ABB17")

    private boolean mSelectionControllerEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.472 -0400", hash_original_field = "6854FB31EDC4E2B522D358A7D58685A8", hash_generated_field = "60F18FE1AE8CDBA3A5368ABF9BB5958F")

    private boolean mInBatchEditControllers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.472 -0400", hash_original_field = "37E6CBBA2DC07898D114DB5377D9D2AA", hash_generated_field = "7E20F67A0496D1E1FE6F1DC6D3BACA5D")

    private boolean mSelectAllOnFocus = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.472 -0400", hash_original_field = "2EF4E086F9141FE348E8A559F50FA1E9", hash_generated_field = "3FFAAA27B6CA268237E3AFE24778DD3C")

    private int mGravity = Gravity.TOP | Gravity.START;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.472 -0400", hash_original_field = "F2C627B045ED0B6F456489886DDF0435", hash_generated_field = "74DB3F78A4C361569E560DA09766931D")

    private boolean mHorizontallyScrolling;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.472 -0400", hash_original_field = "6B1804E483F3EF95C329AD84689BA27C", hash_generated_field = "3127858001137B18AA1050FDA67563F8")

    private int mAutoLinkMask;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.472 -0400", hash_original_field = "B20D3633475D5DDA643309B6DF38BAA8", hash_generated_field = "66946D660FCFF22371342C2FCD7310DE")

    private boolean mLinksClickable = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.472 -0400", hash_original_field = "768D4A0E99F80D8745CC748FF177B182", hash_generated_field = "8F925916DEF4152F81E2C1B309E2CAD4")

    private float mSpacingMult = 1.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.472 -0400", hash_original_field = "76B6C9620B0FBD77BE307E9334B95A63", hash_generated_field = "1E02CC84BB1334BEF2DEA24E10A518A6")

    private float mSpacingAdd = 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.473 -0400", hash_original_field = "146ACA11699BD6614DDC7A0149037FB6", hash_generated_field = "68BD06BADA0355451B21E90ACC461FA5")

    private boolean mTextIsSelectable = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.473 -0400", hash_original_field = "28A817F8D44803BA03BFDAF899CA4612", hash_generated_field = "0EE8DD6435BEB8CBE9F46AA7496B8DA6")

    private int mMaximum = Integer.MAX_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.473 -0400", hash_original_field = "896320C9E2FB4CFC66E16D3BD356BAAF", hash_generated_field = "033C060EBF21916B1ECB824474BF4BDF")

    private int mMaxMode = LINES;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.473 -0400", hash_original_field = "CC209BC90D03447E85DF642E369F8A86", hash_generated_field = "0828D86E694A99841F66D5DB44492D82")

    private int mMinimum = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.473 -0400", hash_original_field = "B23BA1EA5F949F96C83C84709B7349D6", hash_generated_field = "01F00155DEDA2DDBFDB49BED19C8F96E")

    private int mMinMode = LINES;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.473 -0400", hash_original_field = "7ED33BD2DC36574D26E443EE1A189C0D", hash_generated_field = "A1A2411DB171DF204A9C43EDA39C69C7")

    private int mOldMaximum = mMaximum;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.473 -0400", hash_original_field = "0FBED20BC4056EDF1181A5F7F65A66B2", hash_generated_field = "DDDC3184AF678EE8EE38801D06FC99BF")

    private int mOldMaxMode = mMaxMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.473 -0400", hash_original_field = "9F06F72E481BAF7A136AD40FA3B01EB4", hash_generated_field = "63C7BFD9234113D05BBC54B620020077")

    private int mMaxWidth = Integer.MAX_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.473 -0400", hash_original_field = "C2CD798A4E6691243397E9A6620CFDEE", hash_generated_field = "C110306973FAB903E136E57733D142DD")

    private int mMaxWidthMode = PIXELS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.473 -0400", hash_original_field = "26016AEBC03D4DA0060B1446537D35AC", hash_generated_field = "5E59AE0126344902582396461E5FAA8C")

    private int mMinWidth = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.473 -0400", hash_original_field = "23CF04FD3F773E8AECAC4DF696589658", hash_generated_field = "0B24A55CAE86F87D6F35062C108A6502")

    private int mMinWidthMode = PIXELS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.473 -0400", hash_original_field = "409E161D7D14305BE6BBBE3E4AEFFCED", hash_generated_field = "6C530F900873AA9699052FBD8A88B031")

    private boolean mSingleLine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.473 -0400", hash_original_field = "06185890E372F5D51274CAD861AA5867", hash_generated_field = "3740A3452EC2B82472EDA36D3C6B8C87")

    private int mDesiredHeightAtMeasure = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.473 -0400", hash_original_field = "7B7C4D5694417E83CD90BE557F7B1057", hash_generated_field = "F60C6FE0825AD0E4922E523051656DE4")

    private boolean mIncludePad = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.473 -0400", hash_original_field = "31F14B9E9336FCF46F51826201DA493C", hash_generated_field = "F7ADD3635432B5C7B3A742E5E6D21FF7")

    private Path mHighlightPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.473 -0400", hash_original_field = "1FE02E01128CA6EA399797D30A51BBAD", hash_generated_field = "899F52BC2A6F9C0116B0475059B2BE9C")

    private boolean mHighlightPathBogus = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.473 -0400", hash_original_field = "380EFAD062415C5D611446C1B15B307D", hash_generated_field = "507FF60BF6AED501221786F4F9B1C4CE")

    private long mLastScroll;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.473 -0400", hash_original_field = "7E9E953961CD92A66FE0351C10474492", hash_generated_field = "9C30A415641DC69EAA3304A141095B90")

    private Scroller mScroller = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.473 -0400", hash_original_field = "EC0875A99E92BD0CEBED0D984C28195A", hash_generated_field = "FF6D60EE34326DC34FD3A8DE24FDF7C9")

    private BoringLayout.Metrics mBoring;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.473 -0400", hash_original_field = "DF537B8351AF7282A7B1E499D83D9433", hash_generated_field = "AAFF1CC477C8CC62A538A60FE46DC5D1")

    private BoringLayout.Metrics mHintBoring;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.473 -0400", hash_original_field = "0A793C83D74ADBD2F96615B43A58295A", hash_generated_field = "A58D53DD9C11A6C44CEF04B476DD83D8")

    private BoringLayout mSavedLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.473 -0400", hash_original_field = "3823EF2992779A9DCE6B5232294F71F7", hash_generated_field = "65F61BA5EAB2A99364AEC51C71BE0AD2")

    private BoringLayout mSavedHintLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.473 -0400", hash_original_field = "1ED12FB8583DE3005542EC3E5ADE9C69", hash_generated_field = "49191C3FC0794274CF62373EA69DAA6D")

    private TextDirectionHeuristic mTextDir = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.473 -0400", hash_original_field = "8EF1F84508C44788B91A5266E4C71739", hash_generated_field = "489605ABB55A73F593690CC2882D1D5E")

    private InputFilter[] mFilters = NO_FILTERS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.473 -0400", hash_original_field = "28E8D15C0BD03E974FEC7876975B1D1F", hash_generated_field = "946F5E9D92C681851A4147B34C44B028")

    private CorrectionHighlighter mCorrectionHighlighter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.473 -0400", hash_original_method = "16A18A865F32B95685EAC04EF434D4B5", hash_generated_method = "E4C2F370BE90FD637853CF92939C9374")
    public  TextView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.474 -0400", hash_original_method = "2AA1B7AF4AA0321ED5A0A8E3910A65F3", hash_generated_method = "43424ED0F684872076F86CE008533539")
    public  TextView(Context context,
                    AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.textViewStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.564 -0400", hash_original_method = "9090DB4BB502E7A1E7DDA866F2D92623", hash_generated_method = "4D72519D430B6D4C5AF2825449512816")
    @SuppressWarnings("deprecation")
    public  TextView(Context context,
                    AttributeSet attrs,
                    int defStyle) {
        super(context, attrs, defStyle);
        mText = "";
        Resources res;
        res = getResources();
        CompatibilityInfo compat;
        compat = res.getCompatibilityInfo();
        mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.density = res.getDisplayMetrics().density;
        mTextPaint.setCompatibilityScaling(compat.applicationScale);
        mHighlightPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mHighlightPaint.setCompatibilityScaling(compat.applicationScale);
        mMovement = getDefaultMovementMethod();
        mTransformation = null;
        int textColorHighlight;
        textColorHighlight = 0;
        ColorStateList textColor;
        textColor = null;
        ColorStateList textColorHint;
        textColorHint = null;
        ColorStateList textColorLink;
        textColorLink = null;
        int textSize;
        textSize = 15;
        int typefaceIndex;
        typefaceIndex = -1;
        int styleIndex;
        styleIndex = -1;
        boolean allCaps;
        allCaps = false;
        Resources.Theme theme;
        theme = context.getTheme();
        TypedArray a;
        a = theme.obtainStyledAttributes(
                    attrs, com.android.internal.R.styleable.TextViewAppearance, defStyle, 0);
        TypedArray appearance;
        appearance = null;
        int ap;
        ap = a.getResourceId(
                com.android.internal.R.styleable.TextViewAppearance_textAppearance, -1);
        a.recycle();
        {
            appearance = theme.obtainStyledAttributes(
                    ap, com.android.internal.R.styleable.TextAppearance);
        } //End block
        {
            int n;
            n = appearance.getIndexCount();
            {
                int i;
                i = 0;
                {
                    int attr;
                    attr = appearance.getIndex(i);
                    //Begin case com.android.internal.R.styleable.TextAppearance_textColorHighlight 
                    textColorHighlight = appearance.getColor(attr, textColorHighlight);
                    //End case com.android.internal.R.styleable.TextAppearance_textColorHighlight 
                    //Begin case com.android.internal.R.styleable.TextAppearance_textColor 
                    textColor = appearance.getColorStateList(attr);
                    //End case com.android.internal.R.styleable.TextAppearance_textColor 
                    //Begin case com.android.internal.R.styleable.TextAppearance_textColorHint 
                    textColorHint = appearance.getColorStateList(attr);
                    //End case com.android.internal.R.styleable.TextAppearance_textColorHint 
                    //Begin case com.android.internal.R.styleable.TextAppearance_textColorLink 
                    textColorLink = appearance.getColorStateList(attr);
                    //End case com.android.internal.R.styleable.TextAppearance_textColorLink 
                    //Begin case com.android.internal.R.styleable.TextAppearance_textSize 
                    textSize = appearance.getDimensionPixelSize(attr, textSize);
                    //End case com.android.internal.R.styleable.TextAppearance_textSize 
                    //Begin case com.android.internal.R.styleable.TextAppearance_typeface 
                    typefaceIndex = appearance.getInt(attr, -1);
                    //End case com.android.internal.R.styleable.TextAppearance_typeface 
                    //Begin case com.android.internal.R.styleable.TextAppearance_textStyle 
                    styleIndex = appearance.getInt(attr, -1);
                    //End case com.android.internal.R.styleable.TextAppearance_textStyle 
                    //Begin case com.android.internal.R.styleable.TextAppearance_textAllCaps 
                    allCaps = appearance.getBoolean(attr, false);
                    //End case com.android.internal.R.styleable.TextAppearance_textAllCaps 
                } //End block
            } //End collapsed parenthetic
            appearance.recycle();
        } //End block
        boolean editable;
        editable = getDefaultEditable();
        CharSequence inputMethod;
        inputMethod = null;
        int numeric;
        numeric = 0;
        CharSequence digits;
        digits = null;
        boolean phone;
        phone = false;
        boolean autotext;
        autotext = false;
        int autocap;
        autocap = -1;
        int buffertype;
        buffertype = 0;
        boolean selectallonfocus;
        selectallonfocus = false;
        Drawable drawableLeft, drawableTop, drawableRight, drawableBottom, drawableStart, drawableEnd;
        drawableLeft = null;
        drawableTop = null;
        drawableRight = null;
        drawableBottom = null;
        drawableStart = null;
        drawableEnd = null;
        int drawablePadding;
        drawablePadding = 0;
        int ellipsize;
        ellipsize = -1;
        boolean singleLine;
        singleLine = false;
        int maxlength;
        maxlength = -1;
        CharSequence text;
        text = "";
        CharSequence hint;
        hint = null;
        int shadowcolor;
        shadowcolor = 0;
        float dx, dy, r;
        dx = 0;
        dy = 0;
        r = 0;
        boolean password;
        password = false;
        int inputType;
        inputType = EditorInfo.TYPE_NULL;
        a = theme.obtainStyledAttributes(
                    attrs, com.android.internal.R.styleable.TextView, defStyle, 0);
        int n;
        n = a.getIndexCount();
        {
            int i;
            i = 0;
            {
                int attr;
                attr = a.getIndex(i);
                //Begin case com.android.internal.R.styleable.TextView_editable 
                editable = a.getBoolean(attr, editable);
                //End case com.android.internal.R.styleable.TextView_editable 
                //Begin case com.android.internal.R.styleable.TextView_inputMethod 
                inputMethod = a.getText(attr);
                //End case com.android.internal.R.styleable.TextView_inputMethod 
                //Begin case com.android.internal.R.styleable.TextView_numeric 
                numeric = a.getInt(attr, numeric);
                //End case com.android.internal.R.styleable.TextView_numeric 
                //Begin case com.android.internal.R.styleable.TextView_digits 
                digits = a.getText(attr);
                //End case com.android.internal.R.styleable.TextView_digits 
                //Begin case com.android.internal.R.styleable.TextView_phoneNumber 
                phone = a.getBoolean(attr, phone);
                //End case com.android.internal.R.styleable.TextView_phoneNumber 
                //Begin case com.android.internal.R.styleable.TextView_autoText 
                autotext = a.getBoolean(attr, autotext);
                //End case com.android.internal.R.styleable.TextView_autoText 
                //Begin case com.android.internal.R.styleable.TextView_capitalize 
                autocap = a.getInt(attr, autocap);
                //End case com.android.internal.R.styleable.TextView_capitalize 
                //Begin case com.android.internal.R.styleable.TextView_bufferType 
                buffertype = a.getInt(attr, buffertype);
                //End case com.android.internal.R.styleable.TextView_bufferType 
                //Begin case com.android.internal.R.styleable.TextView_selectAllOnFocus 
                selectallonfocus = a.getBoolean(attr, selectallonfocus);
                //End case com.android.internal.R.styleable.TextView_selectAllOnFocus 
                //Begin case com.android.internal.R.styleable.TextView_autoLink 
                mAutoLinkMask = a.getInt(attr, 0);
                //End case com.android.internal.R.styleable.TextView_autoLink 
                //Begin case com.android.internal.R.styleable.TextView_linksClickable 
                mLinksClickable = a.getBoolean(attr, true);
                //End case com.android.internal.R.styleable.TextView_linksClickable 
                //Begin case com.android.internal.R.styleable.TextView_drawableLeft 
                drawableLeft = a.getDrawable(attr);
                //End case com.android.internal.R.styleable.TextView_drawableLeft 
                //Begin case com.android.internal.R.styleable.TextView_drawableTop 
                drawableTop = a.getDrawable(attr);
                //End case com.android.internal.R.styleable.TextView_drawableTop 
                //Begin case com.android.internal.R.styleable.TextView_drawableRight 
                drawableRight = a.getDrawable(attr);
                //End case com.android.internal.R.styleable.TextView_drawableRight 
                //Begin case com.android.internal.R.styleable.TextView_drawableBottom 
                drawableBottom = a.getDrawable(attr);
                //End case com.android.internal.R.styleable.TextView_drawableBottom 
                //Begin case com.android.internal.R.styleable.TextView_drawableStart 
                drawableStart = a.getDrawable(attr);
                //End case com.android.internal.R.styleable.TextView_drawableStart 
                //Begin case com.android.internal.R.styleable.TextView_drawableEnd 
                drawableEnd = a.getDrawable(attr);
                //End case com.android.internal.R.styleable.TextView_drawableEnd 
                //Begin case com.android.internal.R.styleable.TextView_drawablePadding 
                drawablePadding = a.getDimensionPixelSize(attr, drawablePadding);
                //End case com.android.internal.R.styleable.TextView_drawablePadding 
                //Begin case com.android.internal.R.styleable.TextView_maxLines 
                setMaxLines(a.getInt(attr, -1));
                //End case com.android.internal.R.styleable.TextView_maxLines 
                //Begin case com.android.internal.R.styleable.TextView_maxHeight 
                setMaxHeight(a.getDimensionPixelSize(attr, -1));
                //End case com.android.internal.R.styleable.TextView_maxHeight 
                //Begin case com.android.internal.R.styleable.TextView_lines 
                setLines(a.getInt(attr, -1));
                //End case com.android.internal.R.styleable.TextView_lines 
                //Begin case com.android.internal.R.styleable.TextView_height 
                setHeight(a.getDimensionPixelSize(attr, -1));
                //End case com.android.internal.R.styleable.TextView_height 
                //Begin case com.android.internal.R.styleable.TextView_minLines 
                setMinLines(a.getInt(attr, -1));
                //End case com.android.internal.R.styleable.TextView_minLines 
                //Begin case com.android.internal.R.styleable.TextView_minHeight 
                setMinHeight(a.getDimensionPixelSize(attr, -1));
                //End case com.android.internal.R.styleable.TextView_minHeight 
                //Begin case com.android.internal.R.styleable.TextView_maxEms 
                setMaxEms(a.getInt(attr, -1));
                //End case com.android.internal.R.styleable.TextView_maxEms 
                //Begin case com.android.internal.R.styleable.TextView_maxWidth 
                setMaxWidth(a.getDimensionPixelSize(attr, -1));
                //End case com.android.internal.R.styleable.TextView_maxWidth 
                //Begin case com.android.internal.R.styleable.TextView_ems 
                setEms(a.getInt(attr, -1));
                //End case com.android.internal.R.styleable.TextView_ems 
                //Begin case com.android.internal.R.styleable.TextView_width 
                setWidth(a.getDimensionPixelSize(attr, -1));
                //End case com.android.internal.R.styleable.TextView_width 
                //Begin case com.android.internal.R.styleable.TextView_minEms 
                setMinEms(a.getInt(attr, -1));
                //End case com.android.internal.R.styleable.TextView_minEms 
                //Begin case com.android.internal.R.styleable.TextView_minWidth 
                setMinWidth(a.getDimensionPixelSize(attr, -1));
                //End case com.android.internal.R.styleable.TextView_minWidth 
                //Begin case com.android.internal.R.styleable.TextView_gravity 
                setGravity(a.getInt(attr, -1));
                //End case com.android.internal.R.styleable.TextView_gravity 
                //Begin case com.android.internal.R.styleable.TextView_hint 
                hint = a.getText(attr);
                //End case com.android.internal.R.styleable.TextView_hint 
                //Begin case com.android.internal.R.styleable.TextView_text 
                text = a.getText(attr);
                //End case com.android.internal.R.styleable.TextView_text 
                //Begin case com.android.internal.R.styleable.TextView_scrollHorizontally 
                {
                    boolean var45591D90FC7AE21A8CB6FE28079E45A9_136295375 = (a.getBoolean(attr, false));
                    {
                        setHorizontallyScrolling(true);
                    } //End block
                } //End collapsed parenthetic
                //End case com.android.internal.R.styleable.TextView_scrollHorizontally 
                //Begin case com.android.internal.R.styleable.TextView_singleLine 
                singleLine = a.getBoolean(attr, singleLine);
                //End case com.android.internal.R.styleable.TextView_singleLine 
                //Begin case com.android.internal.R.styleable.TextView_ellipsize 
                ellipsize = a.getInt(attr, ellipsize);
                //End case com.android.internal.R.styleable.TextView_ellipsize 
                //Begin case com.android.internal.R.styleable.TextView_marqueeRepeatLimit 
                setMarqueeRepeatLimit(a.getInt(attr, mMarqueeRepeatLimit));
                //End case com.android.internal.R.styleable.TextView_marqueeRepeatLimit 
                //Begin case com.android.internal.R.styleable.TextView_includeFontPadding 
                {
                    boolean varE83A5B5DD6F1EFE4CE2BCD602A46684B_1128904865 = (!a.getBoolean(attr, true));
                    {
                        setIncludeFontPadding(false);
                    } //End block
                } //End collapsed parenthetic
                //End case com.android.internal.R.styleable.TextView_includeFontPadding 
                //Begin case com.android.internal.R.styleable.TextView_cursorVisible 
                {
                    boolean varE83A5B5DD6F1EFE4CE2BCD602A46684B_188944014 = (!a.getBoolean(attr, true));
                    {
                        setCursorVisible(false);
                    } //End block
                } //End collapsed parenthetic
                //End case com.android.internal.R.styleable.TextView_cursorVisible 
                //Begin case com.android.internal.R.styleable.TextView_maxLength 
                maxlength = a.getInt(attr, -1);
                //End case com.android.internal.R.styleable.TextView_maxLength 
                //Begin case com.android.internal.R.styleable.TextView_textScaleX 
                setTextScaleX(a.getFloat(attr, 1.0f));
                //End case com.android.internal.R.styleable.TextView_textScaleX 
                //Begin case com.android.internal.R.styleable.TextView_freezesText 
                mFreezesText = a.getBoolean(attr, false);
                //End case com.android.internal.R.styleable.TextView_freezesText 
                //Begin case com.android.internal.R.styleable.TextView_shadowColor 
                shadowcolor = a.getInt(attr, 0);
                //End case com.android.internal.R.styleable.TextView_shadowColor 
                //Begin case com.android.internal.R.styleable.TextView_shadowDx 
                dx = a.getFloat(attr, 0);
                //End case com.android.internal.R.styleable.TextView_shadowDx 
                //Begin case com.android.internal.R.styleable.TextView_shadowDy 
                dy = a.getFloat(attr, 0);
                //End case com.android.internal.R.styleable.TextView_shadowDy 
                //Begin case com.android.internal.R.styleable.TextView_shadowRadius 
                r = a.getFloat(attr, 0);
                //End case com.android.internal.R.styleable.TextView_shadowRadius 
                //Begin case com.android.internal.R.styleable.TextView_enabled 
                setEnabled(a.getBoolean(attr, isEnabled()));
                //End case com.android.internal.R.styleable.TextView_enabled 
                //Begin case com.android.internal.R.styleable.TextView_textColorHighlight 
                textColorHighlight = a.getColor(attr, textColorHighlight);
                //End case com.android.internal.R.styleable.TextView_textColorHighlight 
                //Begin case com.android.internal.R.styleable.TextView_textColor 
                textColor = a.getColorStateList(attr);
                //End case com.android.internal.R.styleable.TextView_textColor 
                //Begin case com.android.internal.R.styleable.TextView_textColorHint 
                textColorHint = a.getColorStateList(attr);
                //End case com.android.internal.R.styleable.TextView_textColorHint 
                //Begin case com.android.internal.R.styleable.TextView_textColorLink 
                textColorLink = a.getColorStateList(attr);
                //End case com.android.internal.R.styleable.TextView_textColorLink 
                //Begin case com.android.internal.R.styleable.TextView_textSize 
                textSize = a.getDimensionPixelSize(attr, textSize);
                //End case com.android.internal.R.styleable.TextView_textSize 
                //Begin case com.android.internal.R.styleable.TextView_typeface 
                typefaceIndex = a.getInt(attr, typefaceIndex);
                //End case com.android.internal.R.styleable.TextView_typeface 
                //Begin case com.android.internal.R.styleable.TextView_textStyle 
                styleIndex = a.getInt(attr, styleIndex);
                //End case com.android.internal.R.styleable.TextView_textStyle 
                //Begin case com.android.internal.R.styleable.TextView_password 
                password = a.getBoolean(attr, password);
                //End case com.android.internal.R.styleable.TextView_password 
                //Begin case com.android.internal.R.styleable.TextView_lineSpacingExtra 
                mSpacingAdd = a.getDimensionPixelSize(attr, (int) mSpacingAdd);
                //End case com.android.internal.R.styleable.TextView_lineSpacingExtra 
                //Begin case com.android.internal.R.styleable.TextView_lineSpacingMultiplier 
                mSpacingMult = a.getFloat(attr, mSpacingMult);
                //End case com.android.internal.R.styleable.TextView_lineSpacingMultiplier 
                //Begin case com.android.internal.R.styleable.TextView_inputType 
                inputType = a.getInt(attr, mInputType);
                //End case com.android.internal.R.styleable.TextView_inputType 
                //Begin case com.android.internal.R.styleable.TextView_imeOptions 
                {
                    mInputContentType = new InputContentType();
                } //End block
                //End case com.android.internal.R.styleable.TextView_imeOptions 
                //Begin case com.android.internal.R.styleable.TextView_imeOptions 
                mInputContentType.imeOptions = a.getInt(attr,
                        mInputContentType.imeOptions);
                //End case com.android.internal.R.styleable.TextView_imeOptions 
                //Begin case com.android.internal.R.styleable.TextView_imeActionLabel 
                {
                    mInputContentType = new InputContentType();
                } //End block
                //End case com.android.internal.R.styleable.TextView_imeActionLabel 
                //Begin case com.android.internal.R.styleable.TextView_imeActionLabel 
                mInputContentType.imeActionLabel = a.getText(attr);
                //End case com.android.internal.R.styleable.TextView_imeActionLabel 
                //Begin case com.android.internal.R.styleable.TextView_imeActionId 
                {
                    mInputContentType = new InputContentType();
                } //End block
                //End case com.android.internal.R.styleable.TextView_imeActionId 
                //Begin case com.android.internal.R.styleable.TextView_imeActionId 
                mInputContentType.imeActionId = a.getInt(attr,
                        mInputContentType.imeActionId);
                //End case com.android.internal.R.styleable.TextView_imeActionId 
                //Begin case com.android.internal.R.styleable.TextView_privateImeOptions 
                setPrivateImeOptions(a.getString(attr));
                //End case com.android.internal.R.styleable.TextView_privateImeOptions 
                //Begin case com.android.internal.R.styleable.TextView_editorExtras 
                try 
                {
                    setInputExtras(a.getResourceId(attr, 0));
                } //End block
                catch (XmlPullParserException e)
                { }
                catch (IOException e)
                { }
                //End case com.android.internal.R.styleable.TextView_editorExtras 
                //Begin case com.android.internal.R.styleable.TextView_textCursorDrawable 
                mCursorDrawableRes = a.getResourceId(attr, 0);
                //End case com.android.internal.R.styleable.TextView_textCursorDrawable 
                //Begin case com.android.internal.R.styleable.TextView_textSelectHandleLeft 
                mTextSelectHandleLeftRes = a.getResourceId(attr, 0);
                //End case com.android.internal.R.styleable.TextView_textSelectHandleLeft 
                //Begin case com.android.internal.R.styleable.TextView_textSelectHandleRight 
                mTextSelectHandleRightRes = a.getResourceId(attr, 0);
                //End case com.android.internal.R.styleable.TextView_textSelectHandleRight 
                //Begin case com.android.internal.R.styleable.TextView_textSelectHandle 
                mTextSelectHandleRes = a.getResourceId(attr, 0);
                //End case com.android.internal.R.styleable.TextView_textSelectHandle 
                //Begin case com.android.internal.R.styleable.TextView_textEditSuggestionItemLayout 
                mTextEditSuggestionItemLayout = a.getResourceId(attr, 0);
                //End case com.android.internal.R.styleable.TextView_textEditSuggestionItemLayout 
                //Begin case com.android.internal.R.styleable.TextView_textIsSelectable 
                mTextIsSelectable = a.getBoolean(attr, false);
                //End case com.android.internal.R.styleable.TextView_textIsSelectable 
                //Begin case com.android.internal.R.styleable.TextView_textAllCaps 
                allCaps = a.getBoolean(attr, false);
                //End case com.android.internal.R.styleable.TextView_textAllCaps 
            } //End block
        } //End collapsed parenthetic
        a.recycle();
        BufferType bufferType;
        bufferType = BufferType.EDITABLE;
        int variation;
        variation = inputType & (EditorInfo.TYPE_MASK_CLASS | EditorInfo.TYPE_MASK_VARIATION);
        boolean passwordInputType;
        passwordInputType = variation
                == (EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_VARIATION_PASSWORD);
        boolean webPasswordInputType;
        webPasswordInputType = variation
                == (EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_VARIATION_WEB_PASSWORD);
        boolean numberPasswordInputType;
        numberPasswordInputType = variation
                == (EditorInfo.TYPE_CLASS_NUMBER | EditorInfo.TYPE_NUMBER_VARIATION_PASSWORD);
        {
            Class<?> c;
            try 
            {
                c = Class.forName(inputMethod.toString());
            } //End block
            catch (ClassNotFoundException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(ex);
            } //End block
            try 
            {
                mInput = (KeyListener) c.newInstance();
            } //End block
            catch (InstantiationException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(ex);
            } //End block
            catch (IllegalAccessException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(ex);
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
        {
            mInput = DigitsKeyListener.getInstance(digits.toString());
            mInputType = inputType != EditorInfo.TYPE_NULL
                    ? inputType : EditorInfo.TYPE_CLASS_TEXT;
        } //End block
        {
            setInputType(inputType, true);
            singleLine = !isMultilineInputType(inputType);
        } //End block
        {
            mInput = DialerKeyListener.getInstance();
            mInputType = inputType = EditorInfo.TYPE_CLASS_PHONE;
        } //End block
        {
            mInput = DigitsKeyListener.getInstance((numeric & SIGNED) != 0,
                                                   (numeric & DECIMAL) != 0);
            inputType = EditorInfo.TYPE_CLASS_NUMBER;
            {
                inputType |= EditorInfo.TYPE_NUMBER_FLAG_SIGNED;
            } //End block
            {
                inputType |= EditorInfo.TYPE_NUMBER_FLAG_DECIMAL;
            } //End block
            mInputType = inputType;
        } //End block
        {
            TextKeyListener.Capitalize cap;
            inputType = EditorInfo.TYPE_CLASS_TEXT;
            //Begin case 1 
            cap = TextKeyListener.Capitalize.SENTENCES;
            //End case 1 
            //Begin case 1 
            inputType |= EditorInfo.TYPE_TEXT_FLAG_CAP_SENTENCES;
            //End case 1 
            //Begin case 2 
            cap = TextKeyListener.Capitalize.WORDS;
            //End case 2 
            //Begin case 2 
            inputType |= EditorInfo.TYPE_TEXT_FLAG_CAP_WORDS;
            //End case 2 
            //Begin case 3 
            cap = TextKeyListener.Capitalize.CHARACTERS;
            //End case 3 
            //Begin case 3 
            inputType |= EditorInfo.TYPE_TEXT_FLAG_CAP_CHARACTERS;
            //End case 3 
            //Begin case default 
            cap = TextKeyListener.Capitalize.NONE;
            //End case default 
            mInput = TextKeyListener.getInstance(autotext, cap);
            mInputType = inputType;
        } //End block
        {
            mInputType = EditorInfo.TYPE_NULL;
            mInput = null;
            bufferType = BufferType.SPANNABLE;
            setFocusableInTouchMode(true);
            setMovementMethod(ArrowKeyMovementMethod.getInstance());
        } //End block
        {
            mInput = TextKeyListener.getInstance();
            mInputType = EditorInfo.TYPE_CLASS_TEXT;
        } //End block
        {
            mInput = null;
            //Begin case 0 
            bufferType = BufferType.NORMAL;
            //End case 0 
            //Begin case 1 
            bufferType = BufferType.SPANNABLE;
            //End case 1 
            //Begin case 2 
            bufferType = BufferType.EDITABLE;
            //End case 2 
        } //End block
        {
            {
                mInputType = (mInputType & ~(EditorInfo.TYPE_MASK_VARIATION))
                        | EditorInfo.TYPE_TEXT_VARIATION_PASSWORD;
            } //End block
            {
                mInputType = (mInputType & ~(EditorInfo.TYPE_MASK_VARIATION))
                        | EditorInfo.TYPE_TEXT_VARIATION_WEB_PASSWORD;
            } //End block
        } //End block
        {
            {
                mInputType = (mInputType & ~(EditorInfo.TYPE_MASK_VARIATION))
                        | EditorInfo.TYPE_NUMBER_VARIATION_PASSWORD;
            } //End block
        } //End block
        {
            mSelectAllOnFocus = true;
            bufferType = BufferType.SPANNABLE;
        } //End block
        setCompoundDrawablesWithIntrinsicBounds(
            drawableLeft, drawableTop, drawableRight, drawableBottom);
        setRelativeDrawablesIfNeeded(drawableStart, drawableEnd);
        setCompoundDrawablePadding(drawablePadding);
        setInputTypeSingleLine(singleLine);
        applySingleLine(singleLine, singleLine, singleLine);
        {
            ellipsize = 3;
        } //End block
        //Begin case 1 
        setEllipsize(TextUtils.TruncateAt.START);
        //End case 1 
        //Begin case 2 
        setEllipsize(TextUtils.TruncateAt.MIDDLE);
        //End case 2 
        //Begin case 3 
        setEllipsize(TextUtils.TruncateAt.END);
        //End case 3 
        //Begin case 4 
        {
            boolean var8F0ACED8C99F3716300411BE9198A3C2_1578910508 = (ViewConfiguration.get(context).isFadingMarqueeEnabled());
            {
                setHorizontalFadingEdgeEnabled(true);
                mMarqueeFadeMode = MARQUEE_FADE_NORMAL;
            } //End block
            {
                setHorizontalFadingEdgeEnabled(false);
                mMarqueeFadeMode = MARQUEE_FADE_SWITCH_SHOW_ELLIPSIS;
            } //End block
        } //End collapsed parenthetic
        //End case 4 
        //Begin case 4 
        setEllipsize(TextUtils.TruncateAt.MARQUEE);
        //End case 4 
        setTextColor(textColor != null ? textColor : ColorStateList.valueOf(0xFF000000));
        setHintTextColor(textColorHint);
        setLinkTextColor(textColorLink);
        {
            setHighlightColor(textColorHighlight);
        } //End block
        setRawTextSize(textSize);
        {
            setTransformationMethod(new AllCapsTransformationMethod(getContext()));
        } //End block
        {
            setTransformationMethod(PasswordTransformationMethod.getInstance());
            typefaceIndex = MONOSPACE;
        } //End block
        {
            typefaceIndex = MONOSPACE;
        } //End block
        setTypefaceByIndex(typefaceIndex, styleIndex);
        {
            setShadowLayer(r, dx, dy, shadowcolor);
        } //End block
        {
            setFilters(new InputFilter[] { new InputFilter.LengthFilter(maxlength) });
        } //End block
        {
            setFilters(NO_FILTERS);
        } //End block
        setText(text, bufferType);
        setHint(hint);
        a = context.obtainStyledAttributes(attrs,
                                           com.android.internal.R.styleable.View,
                                           defStyle, 0);
        boolean focusable;
        focusable = mMovement != null || mInput != null;
        boolean clickable;
        clickable = focusable;
        boolean longClickable;
        longClickable = focusable;
        n = a.getIndexCount();
        {
            int i;
            i = 0;
            {
                int attr;
                attr = a.getIndex(i);
                //Begin case com.android.internal.R.styleable.View_focusable 
                focusable = a.getBoolean(attr, focusable);
                //End case com.android.internal.R.styleable.View_focusable 
                //Begin case com.android.internal.R.styleable.View_clickable 
                clickable = a.getBoolean(attr, clickable);
                //End case com.android.internal.R.styleable.View_clickable 
                //Begin case com.android.internal.R.styleable.View_longClickable 
                longClickable = a.getBoolean(attr, longClickable);
                //End case com.android.internal.R.styleable.View_longClickable 
            } //End block
        } //End collapsed parenthetic
        a.recycle();
        setFocusable(focusable);
        setClickable(clickable);
        setLongClickable(longClickable);
        prepareCursorControllers();
        ViewConfiguration viewConfiguration;
        viewConfiguration = ViewConfiguration.get(context);
        int touchSlop;
        touchSlop = viewConfiguration.getScaledTouchSlop();
        mSquaredTouchSlopDistance = touchSlop * touchSlop;
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.573 -0400", hash_original_method = "C60E18AF77ADDBBD7F15C48D3326353D", hash_generated_method = "0CD4AAFEF72A3E8B76E5161DB6B250D3")
    private void setTypefaceByIndex(int typefaceIndex, int styleIndex) {
        Typeface tf;
        tf = null;
        //Begin case SANS 
        tf = Typeface.SANS_SERIF;
        //End case SANS 
        //Begin case SERIF 
        tf = Typeface.SERIF;
        //End case SERIF 
        //Begin case MONOSPACE 
        tf = Typeface.MONOSPACE;
        //End case MONOSPACE 
        setTypeface(tf, styleIndex);
        addTaint(typefaceIndex);
        addTaint(styleIndex);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.585 -0400", hash_original_method = "81361F4824C6D1D7960776386313375B", hash_generated_method = "C55BCC623568652F00DB412C789300DD")
    private void setRelativeDrawablesIfNeeded(Drawable start, Drawable end) {
        boolean hasRelativeDrawables;
        hasRelativeDrawables = (start != null) || (end != null);
        {
            Drawables dr;
            dr = mDrawables;
            {
                mDrawables = dr = new Drawables();
            } //End block
            Rect compoundRect;
            compoundRect = dr.mCompoundRect;
            int[] state;
            state = getDrawableState();
            {
                start.setBounds(0, 0, start.getIntrinsicWidth(), start.getIntrinsicHeight());
                start.setState(state);
                start.copyBounds(compoundRect);
                start.setCallback(this);
                dr.mDrawableStart = start;
                dr.mDrawableSizeStart = compoundRect.width();
                dr.mDrawableHeightStart = compoundRect.height();
            } //End block
            {
                dr.mDrawableSizeStart = dr.mDrawableHeightStart = 0;
            } //End block
            {
                end.setBounds(0, 0, end.getIntrinsicWidth(), end.getIntrinsicHeight());
                end.setState(state);
                end.copyBounds(compoundRect);
                end.setCallback(this);
                dr.mDrawableEnd = end;
                dr.mDrawableSizeEnd = compoundRect.width();
                dr.mDrawableHeightEnd = compoundRect.height();
            } //End block
            {
                dr.mDrawableSizeEnd = dr.mDrawableHeightEnd = 0;
            } //End block
        } //End block
        addTaint(start.getTaint());
        addTaint(end.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.589 -0400", hash_original_method = "224789FFA5DBD63B17185276A15DADF0", hash_generated_method = "9756C7FDE9FD6D5FA95DCE8C3B19654B")
    @Override
    public void setEnabled(boolean enabled) {
        {
            boolean var7DA8DB0EDBF2B3C1E618EFC1F33534DC_1108098586 = (enabled == isEnabled());
        } //End collapsed parenthetic
        {
            InputMethodManager imm;
            imm = InputMethodManager.peekInstance();
            {
                boolean var4937F8F03F6BF371ED8AD64A66FE25A6_121975731 = (imm != null && imm.isActive(this));
                {
                    imm.hideSoftInputFromWindow(getWindowToken(), 0);
                } //End block
            } //End collapsed parenthetic
        } //End block
        super.setEnabled(enabled);
        prepareCursorControllers();
        {
            InputMethodManager imm;
            imm = InputMethodManager.peekInstance();
            imm.restartInput(this);
        } //End block
        makeBlink();
        addTaint(enabled);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.593 -0400", hash_original_method = "6CE73F981984CDCC5004358BB070DFC0", hash_generated_method = "D740A9B1ACC51C384A6879B74CF21693")
    public void setTypeface(Typeface tf, int style) {
        {
            {
                tf = Typeface.defaultFromStyle(style);
            } //End block
            {
                tf = Typeface.create(tf, style);
            } //End block
            setTypeface(tf);
            int typefaceStyle;
            typefaceStyle = tf.getStyle();
            typefaceStyle = 0;
            int need;
            need = style & ~typefaceStyle;
            mTextPaint.setFakeBoldText((need & Typeface.BOLD) != 0);
            mTextPaint.setTextSkewX((need & Typeface.ITALIC) != 0 ? -0.25f : 0);
        } //End block
        {
            mTextPaint.setFakeBoldText(false);
            mTextPaint.setTextSkewX(0);
            setTypeface(tf);
        } //End block
        addTaint(tf.getTaint());
        addTaint(style);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.594 -0400", hash_original_method = "BFDF598F6F7CD4AFD7EB65F700EA9607", hash_generated_method = "05055E908466CA80A6BB9C8662F1CBA0")
    protected boolean getDefaultEditable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_513228615 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_513228615;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.610 -0400", hash_original_method = "BBE0A92ADC5D9278A97962CE8941F1CB", hash_generated_method = "59D829686FF3D57BF5D24B5695922ED8")
    protected MovementMethod getDefaultMovementMethod() {
        MovementMethod varB4EAC82CA7396A68D541C85D26508E83_1699199334 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1699199334 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1699199334.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1699199334;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.610 -0400", hash_original_method = "D3D56665E0CC0B43413FBFB4C720E96C", hash_generated_method = "C7303BCCF3CCD13659181713FAA10325")
    @ViewDebug.CapturedViewProperty
    public CharSequence getText() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_947697804 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_947697804 = mText;
        varB4EAC82CA7396A68D541C85D26508E83_947697804.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_947697804;
        // ---------- Original Method ----------
        //return mText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.611 -0400", hash_original_method = "9A68249D01A4FE1CBD4D535668FCEB6F", hash_generated_method = "7F2498A2E0C2B56078EE56950B283230")
    public int length() {
        int var32A6F8CD5764B26A2339FAB65BD4098F_1649795911 = (mText.length());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1922468811 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1922468811;
        // ---------- Original Method ----------
        //return mText.length();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.611 -0400", hash_original_method = "7ED3A36B3A9686857AF495D746EF7144", hash_generated_method = "ED3EC865E12E7E5A57C732792088C807")
    public Editable getEditableText() {
        Editable varB4EAC82CA7396A68D541C85D26508E83_1505503882 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1505503882 = (mText instanceof Editable) ? (Editable)mText : null;
        varB4EAC82CA7396A68D541C85D26508E83_1505503882.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1505503882;
        // ---------- Original Method ----------
        //return (mText instanceof Editable) ? (Editable)mText : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.615 -0400", hash_original_method = "0FF7B2A5A4CF7321FA6B03810945EA51", hash_generated_method = "672F686B62D0E068FB66E06C5D789544")
    public int getLineHeight() {
        int var20B277202414C5A1CC77B4034C64DAD9_523498199 = (FastMath.round(mTextPaint.getFontMetricsInt(null) * mSpacingMult + mSpacingAdd));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1548846489 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1548846489;
        // ---------- Original Method ----------
        //return FastMath.round(mTextPaint.getFontMetricsInt(null) * mSpacingMult + mSpacingAdd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.616 -0400", hash_original_method = "AA853122D8F66FE025B9AF375421C379", hash_generated_method = "DEF121CE702A38FA4B1F793DD4E2B5E0")
    public final Layout getLayout() {
        Layout varB4EAC82CA7396A68D541C85D26508E83_1131674385 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1131674385 = mLayout;
        varB4EAC82CA7396A68D541C85D26508E83_1131674385.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1131674385;
        // ---------- Original Method ----------
        //return mLayout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.621 -0400", hash_original_method = "16C14256413AD7EC2C071FEF64E5C315", hash_generated_method = "F7F2471C416EE7E8B78FF5AE4425F968")
    public final KeyListener getKeyListener() {
        KeyListener varB4EAC82CA7396A68D541C85D26508E83_2037582030 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2037582030 = mInput;
        varB4EAC82CA7396A68D541C85D26508E83_2037582030.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2037582030;
        // ---------- Original Method ----------
        //return mInput;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.622 -0400", hash_original_method = "C24E7464E624E00527FA94ACF2B78CDF", hash_generated_method = "BBCBA056B53CE01E36AF037B32D33511")
    public void setKeyListener(KeyListener input) {
        setKeyListenerOnly(input);
        fixFocusableAndClickableSettings();
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
        {
            mInputType = EditorInfo.TYPE_NULL;
        } //End block
        InputMethodManager imm;
        imm = InputMethodManager.peekInstance();
        imm.restartInput(this);
        addTaint(input.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.622 -0400", hash_original_method = "4C0922906A0644E54152EA479C6FB8D4", hash_generated_method = "FCA0E058FAE26C07A859496B7C7EBD81")
    private void setKeyListenerOnly(KeyListener input) {
        mInput = input;
        setText(mText);
        setFilters((Editable) mText, mFilters);
        // ---------- Original Method ----------
        //mInput = input;
        //if (mInput != null && !(mText instanceof Editable))
            //setText(mText);
        //setFilters((Editable) mText, mFilters);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.623 -0400", hash_original_method = "48923BC0AD13C4CAAF5FC92105497B11", hash_generated_method = "39BD44E766C4EF56B9247EDDCD2F6085")
    public final MovementMethod getMovementMethod() {
        MovementMethod varB4EAC82CA7396A68D541C85D26508E83_545687153 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_545687153 = mMovement;
        varB4EAC82CA7396A68D541C85D26508E83_545687153.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_545687153;
        // ---------- Original Method ----------
        //return mMovement;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.625 -0400", hash_original_method = "A60F83672BBDF336AF379460700DB19E", hash_generated_method = "9201CE2A5C2C5C6029EADF339CE33B51")
    public final void setMovementMethod(MovementMethod movement) {
        mMovement = movement;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.625 -0400", hash_original_method = "20BA1DEB0A4AF2EE483D2287D9007BE7", hash_generated_method = "B98752575E441289B05AA5A2F0F91865")
    private void fixFocusableAndClickableSettings() {
        {
            setFocusable(true);
            setClickable(true);
            setLongClickable(true);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.634 -0400", hash_original_method = "2CDC6DDF1029E76D6DBEC0602C28EC15", hash_generated_method = "63C5B4FA9EC5634DFEC5C8EFAEBFBFBD")
    public final TransformationMethod getTransformationMethod() {
        TransformationMethod varB4EAC82CA7396A68D541C85D26508E83_301963350 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_301963350 = mTransformation;
        varB4EAC82CA7396A68D541C85D26508E83_301963350.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_301963350;
        // ---------- Original Method ----------
        //return mTransformation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.640 -0400", hash_original_method = "93D394D84FFC0B02B9FD24841443EB6E", hash_generated_method = "6B392639853247C722AEC6521B2D86FE")
    public final void setTransformationMethod(TransformationMethod method) {
        {
            {
                ((Spannable) mText).removeSpan(mTransformation);
            } //End block
        } //End block
        mTransformation = method;
        {
            TransformationMethod2 method2;
            method2 = (TransformationMethod2) method;
            mAllowTransformationLengthChange = !mTextIsSelectable && !(mText instanceof Editable);
            method2.setLengthChangesAllowed(mAllowTransformationLengthChange);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.640 -0400", hash_original_method = "CD4E87E17C71F6F36E69A30DF125A2EC", hash_generated_method = "3A31DFD1F7EB921642D4D3D3AC8A4D22")
    public int getCompoundPaddingTop() {
        Drawables dr;
        dr = mDrawables;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_394629583 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_394629583;
        // ---------- Original Method ----------
        //final Drawables dr = mDrawables;
        //if (dr == null || dr.mDrawableTop == null) {
            //return mPaddingTop;
        //} else {
            //return mPaddingTop + dr.mDrawablePadding + dr.mDrawableSizeTop;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.641 -0400", hash_original_method = "F8E73EA88ED50BD236713C6E1FD6275E", hash_generated_method = "630205BC6738A2B60AE06E590DDC4D53")
    public int getCompoundPaddingBottom() {
        Drawables dr;
        dr = mDrawables;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1327700507 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1327700507;
        // ---------- Original Method ----------
        //final Drawables dr = mDrawables;
        //if (dr == null || dr.mDrawableBottom == null) {
            //return mPaddingBottom;
        //} else {
            //return mPaddingBottom + dr.mDrawablePadding + dr.mDrawableSizeBottom;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.641 -0400", hash_original_method = "E37CE1C2FEDB3DD18FEE34DF2470D692", hash_generated_method = "36B563DEBA91687F1C92FF86CF634DF8")
    public int getCompoundPaddingLeft() {
        Drawables dr;
        dr = mDrawables;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1741399781 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1741399781;
        // ---------- Original Method ----------
        //final Drawables dr = mDrawables;
        //if (dr == null || dr.mDrawableLeft == null) {
            //return mPaddingLeft;
        //} else {
            //return mPaddingLeft + dr.mDrawablePadding + dr.mDrawableSizeLeft;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.641 -0400", hash_original_method = "FA75E1802F0BBA6FD5DC7258A0FBEB3C", hash_generated_method = "9C794A9BE015280CCB68E1D3A303C8EC")
    public int getCompoundPaddingRight() {
        Drawables dr;
        dr = mDrawables;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_59043100 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_59043100;
        // ---------- Original Method ----------
        //final Drawables dr = mDrawables;
        //if (dr == null || dr.mDrawableRight == null) {
            //return mPaddingRight;
        //} else {
            //return mPaddingRight + dr.mDrawablePadding + dr.mDrawableSizeRight;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.645 -0400", hash_original_method = "045E56B45A145CD7B99AFA777E63AEB3", hash_generated_method = "E583D913E6C974CB6B7A89B060428404")
    public int getCompoundPaddingStart() {
        resolveDrawables();
        {
            Object varAFC6EB2C684D509A17B3A4EFF5D9CB9D_1844735098 = (getResolvedLayoutDirection());
            //Begin case default LAYOUT_DIRECTION_LTR 
            int var781EBC093D28721525521D7AA075C977_1786925557 = (getCompoundPaddingLeft());
            //End case default LAYOUT_DIRECTION_LTR 
            //Begin case LAYOUT_DIRECTION_RTL 
            int var8A1D5A6585B3402DA0435C7A847F7E9A_2057251014 = (getCompoundPaddingRight());
            //End case LAYOUT_DIRECTION_RTL 
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_944932031 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_944932031;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.649 -0400", hash_original_method = "0C4A0FB6513BA7C283389B0C3E09BE68", hash_generated_method = "4F3EA760967FB42C2B6A6CD1FC000235")
    public int getCompoundPaddingEnd() {
        resolveDrawables();
        {
            Object varAFC6EB2C684D509A17B3A4EFF5D9CB9D_1288878252 = (getResolvedLayoutDirection());
            //Begin case default LAYOUT_DIRECTION_LTR 
            int var8A1D5A6585B3402DA0435C7A847F7E9A_1252583583 = (getCompoundPaddingRight());
            //End case default LAYOUT_DIRECTION_LTR 
            //Begin case LAYOUT_DIRECTION_RTL 
            int var781EBC093D28721525521D7AA075C977_48332395 = (getCompoundPaddingLeft());
            //End case LAYOUT_DIRECTION_RTL 
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1065301989 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1065301989;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.654 -0400", hash_original_method = "363FF0B4BA7F59F6CC6EB59AE673A7C9", hash_generated_method = "95521AF95579353DAE81EF004C770951")
    public int getExtendedPaddingTop() {
        {
            int var616A12A33C5C9277AD7C0C5C89BD69B5_1387602993 = (getCompoundPaddingTop());
        } //End block
        {
            boolean var907B1900A80A700A44CB9B3E7CFA8547_1956614894 = (mLayout.getLineCount() <= mMaximum);
            {
                int varDAC50BDCD5E1A4A87E580425D0AB90D1_1407138313 = (getCompoundPaddingTop());
            } //End block
        } //End collapsed parenthetic
        int top;
        top = getCompoundPaddingTop();
        int bottom;
        bottom = getCompoundPaddingBottom();
        int viewht;
        viewht = getHeight() - top - bottom;
        int layoutht;
        layoutht = mLayout.getLineTop(mMaximum);
        int gravity;
        gravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1122163095 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1122163095;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.655 -0400", hash_original_method = "7A2DB8BFB057F07CEDE0D120BE6FFB10", hash_generated_method = "FD115D0EA33A13A1ECBBE0D63E9264A0")
    public int getExtendedPaddingBottom() {
        {
            int varB616C533FD1413DFA57A8B3E4A355326_1423687402 = (getCompoundPaddingBottom());
        } //End block
        {
            boolean var907B1900A80A700A44CB9B3E7CFA8547_1159688452 = (mLayout.getLineCount() <= mMaximum);
            {
                int varF7C5B922A73A10EEE346A45E2A7B3E82_1160660030 = (getCompoundPaddingBottom());
            } //End block
        } //End collapsed parenthetic
        int top;
        top = getCompoundPaddingTop();
        int bottom;
        bottom = getCompoundPaddingBottom();
        int viewht;
        viewht = getHeight() - top - bottom;
        int layoutht;
        layoutht = mLayout.getLineTop(mMaximum);
        int gravity;
        gravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1865051508 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1865051508;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.655 -0400", hash_original_method = "5245DB1A490E586E6093F4BFC26117D1", hash_generated_method = "2AB4BB81A6EB422023B7D7E4BC4B2BCD")
    public int getTotalPaddingLeft() {
        int var34500B372695C1C0BF8F0AECDF252C98_822873946 = (getCompoundPaddingLeft());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_983029303 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_983029303;
        // ---------- Original Method ----------
        //return getCompoundPaddingLeft();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.665 -0400", hash_original_method = "A1EB6CC80DC85EDA662D4DD9C10BBDEB", hash_generated_method = "85FAEF105D69EA70E8078226E030B7C7")
    public int getTotalPaddingRight() {
        int var9B702A81BD3510988CA34C6D5C5CC2BB_938530467 = (getCompoundPaddingRight());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1236768871 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1236768871;
        // ---------- Original Method ----------
        //return getCompoundPaddingRight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.665 -0400", hash_original_method = "DD9B038504EC66CC7FCB75AE1CB753E5", hash_generated_method = "70AAA6004E16933D18FC5211517DF01E")
    public int getTotalPaddingStart() {
        int var7D7F8C48280E1131C487BF0950634EDB_58937331 = (getCompoundPaddingStart());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1219326982 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1219326982;
        // ---------- Original Method ----------
        //return getCompoundPaddingStart();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.666 -0400", hash_original_method = "7924A3AF5CA0D716DAB0CFDF1EC0C456", hash_generated_method = "ECC6F0669B08CE0FD92D2775C339CADF")
    public int getTotalPaddingEnd() {
        int varF719AD7587A07158D4596514D0584E08_1878380204 = (getCompoundPaddingEnd());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_34624841 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_34624841;
        // ---------- Original Method ----------
        //return getCompoundPaddingEnd();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.666 -0400", hash_original_method = "3FBB92A2EE65C62C674BD5E5A5FB2713", hash_generated_method = "39B2F0EFB37D6D0DF972B373001B27A6")
    public int getTotalPaddingTop() {
        int varCBA1A1AACA4E5447F7B59F1AEE81650D_1955376682 = (getExtendedPaddingTop() + getVerticalOffset(true));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1082428378 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1082428378;
        // ---------- Original Method ----------
        //return getExtendedPaddingTop() + getVerticalOffset(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.666 -0400", hash_original_method = "DD0E7E66835F9F938ABD11A206F39F98", hash_generated_method = "DF9187DB3AC9ED083A397458BA36D75F")
    public int getTotalPaddingBottom() {
        int var8B593715CC9C8A177070B563C501DACE_2015313630 = (getExtendedPaddingBottom() + getBottomVerticalOffset(true));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1368534503 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1368534503;
        // ---------- Original Method ----------
        //return getExtendedPaddingBottom() + getBottomVerticalOffset(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.683 -0400", hash_original_method = "FDA2BF05D2CC3125A844DA2F1CDB97F3", hash_generated_method = "7E31923C03B43C260383EDBF2DA2A036")
    public void setCompoundDrawables(Drawable left, Drawable top,
                                     Drawable right, Drawable bottom) {
        Drawables dr;
        dr = mDrawables;
        boolean drawables;
        drawables = left != null || top != null
                || right != null || bottom != null;
        {
            {
                {
                    mDrawables = null;
                } //End block
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
                } //End block
            } //End block
        } //End block
        {
            {
                mDrawables = dr = new Drawables();
            } //End block
            {
                dr.mDrawableLeft.setCallback(null);
            } //End block
            dr.mDrawableLeft = left;
            {
                dr.mDrawableTop.setCallback(null);
            } //End block
            dr.mDrawableTop = top;
            {
                dr.mDrawableRight.setCallback(null);
            } //End block
            dr.mDrawableRight = right;
            {
                dr.mDrawableBottom.setCallback(null);
            } //End block
            dr.mDrawableBottom = bottom;
            Rect compoundRect;
            compoundRect = dr.mCompoundRect;
            int[] state;
            state = getDrawableState();
            {
                left.setState(state);
                left.copyBounds(compoundRect);
                left.setCallback(this);
                dr.mDrawableSizeLeft = compoundRect.width();
                dr.mDrawableHeightLeft = compoundRect.height();
            } //End block
            {
                dr.mDrawableSizeLeft = dr.mDrawableHeightLeft = 0;
            } //End block
            {
                right.setState(state);
                right.copyBounds(compoundRect);
                right.setCallback(this);
                dr.mDrawableSizeRight = compoundRect.width();
                dr.mDrawableHeightRight = compoundRect.height();
            } //End block
            {
                dr.mDrawableSizeRight = dr.mDrawableHeightRight = 0;
            } //End block
            {
                top.setState(state);
                top.copyBounds(compoundRect);
                top.setCallback(this);
                dr.mDrawableSizeTop = compoundRect.height();
                dr.mDrawableWidthTop = compoundRect.width();
            } //End block
            {
                dr.mDrawableSizeTop = dr.mDrawableWidthTop = 0;
            } //End block
            {
                bottom.setState(state);
                bottom.copyBounds(compoundRect);
                bottom.setCallback(this);
                dr.mDrawableSizeBottom = compoundRect.height();
                dr.mDrawableWidthBottom = compoundRect.width();
            } //End block
            {
                dr.mDrawableSizeBottom = dr.mDrawableWidthBottom = 0;
            } //End block
        } //End block
        invalidate();
        requestLayout();
        addTaint(left.getTaint());
        addTaint(top.getTaint());
        addTaint(right.getTaint());
        addTaint(bottom.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.685 -0400", hash_original_method = "4DA9B29500DC46492C6684BECC05C749", hash_generated_method = "6D6DA0A34664366DEEC1277D704222B7")
    public void setCompoundDrawablesWithIntrinsicBounds(int left, int top, int right, int bottom) {
        Resources resources;
        resources = getContext().getResources();
        setCompoundDrawablesWithIntrinsicBounds(left != 0 ? resources.getDrawable(left) : null,
                top != 0 ? resources.getDrawable(top) : null,
                right != 0 ? resources.getDrawable(right) : null,
                bottom != 0 ? resources.getDrawable(bottom) : null);
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        // ---------- Original Method ----------
        //final Resources resources = getContext().getResources();
        //setCompoundDrawablesWithIntrinsicBounds(left != 0 ? resources.getDrawable(left) : null,
                //top != 0 ? resources.getDrawable(top) : null,
                //right != 0 ? resources.getDrawable(right) : null,
                //bottom != 0 ? resources.getDrawable(bottom) : null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.719 -0400", hash_original_method = "19E536EC7FD9E8E0EBEABA79F37A1C35", hash_generated_method = "37414A27D658BE5E9D636F262928C84E")
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable left, Drawable top,
            Drawable right, Drawable bottom) {
        {
            left.setBounds(0, 0, left.getIntrinsicWidth(), left.getIntrinsicHeight());
        } //End block
        {
            right.setBounds(0, 0, right.getIntrinsicWidth(), right.getIntrinsicHeight());
        } //End block
        {
            top.setBounds(0, 0, top.getIntrinsicWidth(), top.getIntrinsicHeight());
        } //End block
        {
            bottom.setBounds(0, 0, bottom.getIntrinsicWidth(), bottom.getIntrinsicHeight());
        } //End block
        setCompoundDrawables(left, top, right, bottom);
        addTaint(left.getTaint());
        addTaint(top.getTaint());
        addTaint(right.getTaint());
        addTaint(bottom.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.728 -0400", hash_original_method = "C527F166CA85E985387BA0B670132163", hash_generated_method = "8094344EB8F8B5C761FC3093346A6B9A")
    public void setCompoundDrawablesRelative(Drawable start, Drawable top,
                                     Drawable end, Drawable bottom) {
        Drawables dr;
        dr = mDrawables;
        boolean drawables;
        drawables = start != null || top != null
                || end != null || bottom != null;
        {
            {
                {
                    mDrawables = null;
                } //End block
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
                } //End block
            } //End block
        } //End block
        {
            {
                mDrawables = dr = new Drawables();
            } //End block
            {
                dr.mDrawableStart.setCallback(null);
            } //End block
            dr.mDrawableStart = start;
            {
                dr.mDrawableTop.setCallback(null);
            } //End block
            dr.mDrawableTop = top;
            {
                dr.mDrawableEnd.setCallback(null);
            } //End block
            dr.mDrawableEnd = end;
            {
                dr.mDrawableBottom.setCallback(null);
            } //End block
            dr.mDrawableBottom = bottom;
            Rect compoundRect;
            compoundRect = dr.mCompoundRect;
            int[] state;
            state = getDrawableState();
            {
                start.setState(state);
                start.copyBounds(compoundRect);
                start.setCallback(this);
                dr.mDrawableSizeStart = compoundRect.width();
                dr.mDrawableHeightStart = compoundRect.height();
            } //End block
            {
                dr.mDrawableSizeStart = dr.mDrawableHeightStart = 0;
            } //End block
            {
                end.setState(state);
                end.copyBounds(compoundRect);
                end.setCallback(this);
                dr.mDrawableSizeEnd = compoundRect.width();
                dr.mDrawableHeightEnd = compoundRect.height();
            } //End block
            {
                dr.mDrawableSizeEnd = dr.mDrawableHeightEnd = 0;
            } //End block
            {
                top.setState(state);
                top.copyBounds(compoundRect);
                top.setCallback(this);
                dr.mDrawableSizeTop = compoundRect.height();
                dr.mDrawableWidthTop = compoundRect.width();
            } //End block
            {
                dr.mDrawableSizeTop = dr.mDrawableWidthTop = 0;
            } //End block
            {
                bottom.setState(state);
                bottom.copyBounds(compoundRect);
                bottom.setCallback(this);
                dr.mDrawableSizeBottom = compoundRect.height();
                dr.mDrawableWidthBottom = compoundRect.width();
            } //End block
            {
                dr.mDrawableSizeBottom = dr.mDrawableWidthBottom = 0;
            } //End block
        } //End block
        resolveDrawables();
        invalidate();
        requestLayout();
        addTaint(start.getTaint());
        addTaint(top.getTaint());
        addTaint(end.getTaint());
        addTaint(bottom.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.738 -0400", hash_original_method = "08DFFEC64B0A3553E53B210C6E8B4F5B", hash_generated_method = "A95B0736396920BF69432A8400EDE6F7")
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int start, int top, int end,
            int bottom) {
        resetResolvedDrawables();
        Resources resources;
        resources = getContext().getResources();
        setCompoundDrawablesRelativeWithIntrinsicBounds(
                start != 0 ? resources.getDrawable(start) : null,
                top != 0 ? resources.getDrawable(top) : null,
                end != 0 ? resources.getDrawable(end) : null,
                bottom != 0 ? resources.getDrawable(bottom) : null);
        addTaint(start);
        addTaint(top);
        addTaint(end);
        addTaint(bottom);
        // ---------- Original Method ----------
        //resetResolvedDrawables();
        //final Resources resources = getContext().getResources();
        //setCompoundDrawablesRelativeWithIntrinsicBounds(
                //start != 0 ? resources.getDrawable(start) : null,
                //top != 0 ? resources.getDrawable(top) : null,
                //end != 0 ? resources.getDrawable(end) : null,
                //bottom != 0 ? resources.getDrawable(bottom) : null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.739 -0400", hash_original_method = "BA79780015035B80B72E7A4B08D0D299", hash_generated_method = "32612502DC94DB1039E7091E204E256B")
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable start, Drawable top,
            Drawable end, Drawable bottom) {
        resetResolvedDrawables();
        {
            start.setBounds(0, 0, start.getIntrinsicWidth(), start.getIntrinsicHeight());
        } //End block
        {
            end.setBounds(0, 0, end.getIntrinsicWidth(), end.getIntrinsicHeight());
        } //End block
        {
            top.setBounds(0, 0, top.getIntrinsicWidth(), top.getIntrinsicHeight());
        } //End block
        {
            bottom.setBounds(0, 0, bottom.getIntrinsicWidth(), bottom.getIntrinsicHeight());
        } //End block
        setCompoundDrawablesRelative(start, top, end, bottom);
        addTaint(start.getTaint());
        addTaint(top.getTaint());
        addTaint(end.getTaint());
        addTaint(bottom.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.740 -0400", hash_original_method = "06FDA6F654D58A3BC65C29C47124F71A", hash_generated_method = "F2A85EE95E03CA00FF5EDBBDE9C2958B")
    public Drawable[] getCompoundDrawables() {
        Drawable[] varB4EAC82CA7396A68D541C85D26508E83_989704505 = null; //Variable for return #1
        Drawable[] varB4EAC82CA7396A68D541C85D26508E83_1517198737 = null; //Variable for return #2
        Drawables dr;
        dr = mDrawables;
        {
            varB4EAC82CA7396A68D541C85D26508E83_989704505 = new Drawable[] {
                dr.mDrawableLeft, dr.mDrawableTop, dr.mDrawableRight, dr.mDrawableBottom
            };
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1517198737 = new Drawable[] { null, null, null, null };
        } //End block
        Drawable[] varA7E53CE21691AB073D9660D615818899_790047714; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_790047714 = varB4EAC82CA7396A68D541C85D26508E83_989704505;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_790047714 = varB4EAC82CA7396A68D541C85D26508E83_1517198737;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_790047714.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_790047714;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.745 -0400", hash_original_method = "7D536599368FF7E7773D59B2D0C7C092", hash_generated_method = "CD44F79E6F9620EAC4280394959FCF1F")
    public Drawable[] getCompoundDrawablesRelative() {
        Drawable[] varB4EAC82CA7396A68D541C85D26508E83_891462158 = null; //Variable for return #1
        Drawable[] varB4EAC82CA7396A68D541C85D26508E83_208771471 = null; //Variable for return #2
        Drawables dr;
        dr = mDrawables;
        {
            varB4EAC82CA7396A68D541C85D26508E83_891462158 = new Drawable[] {
                dr.mDrawableStart, dr.mDrawableTop, dr.mDrawableEnd, dr.mDrawableBottom
            };
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_208771471 = new Drawable[] { null, null, null, null };
        } //End block
        Drawable[] varA7E53CE21691AB073D9660D615818899_1216983258; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1216983258 = varB4EAC82CA7396A68D541C85D26508E83_891462158;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1216983258 = varB4EAC82CA7396A68D541C85D26508E83_208771471;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1216983258.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1216983258;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.753 -0400", hash_original_method = "7E4DBC59802038B0E00C34B579D2DA37", hash_generated_method = "ACE5EE1E417EC318A8C6E73B4D2D08A2")
    public void setCompoundDrawablePadding(int pad) {
        Drawables dr;
        dr = mDrawables;
        {
            {
                dr.mDrawablePadding = pad;
            } //End block
        } //End block
        {
            {
                mDrawables = dr = new Drawables();
            } //End block
            dr.mDrawablePadding = pad;
        } //End block
        invalidate();
        requestLayout();
        addTaint(pad);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.753 -0400", hash_original_method = "6B458DA6759E58857DA3CAF4E6D1B789", hash_generated_method = "EAD2F7C232A7111A254101825E2BE97F")
    public int getCompoundDrawablePadding() {
        Drawables dr;
        dr = mDrawables;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1970338795 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1970338795;
        // ---------- Original Method ----------
        //final Drawables dr = mDrawables;
        //return dr != null ? dr.mDrawablePadding : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.754 -0400", hash_original_method = "4C42E9479946D6D8F38619DA66232863", hash_generated_method = "C83267E97542CB8A859756E452D5BD23")
    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        {
            nullLayouts();
        } //End block
        super.setPadding(left, top, right, bottom);
        invalidate();
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.754 -0400", hash_original_method = "D796BA921A3359840CCD26FF0DD1CFB0", hash_generated_method = "3AF57F4B773D1FDC3819CE8C8F979E65")
    public final int getAutoLinkMask() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_647513127 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_647513127;
        // ---------- Original Method ----------
        //return mAutoLinkMask;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.851 -0400", hash_original_method = "FFEF779179433D30901B486DA8C4C9D0", hash_generated_method = "498D80A061CA5EA114AADEE4E3CE801F")
    public void setTextAppearance(Context context, int resid) {
        TypedArray appearance;
        appearance = context.obtainStyledAttributes(resid,
                                           com.android.internal.R.styleable.TextAppearance);
        int color;
        ColorStateList colors;
        int ts;
        color = appearance.getColor(com.android.internal.R.styleable.TextAppearance_textColorHighlight, 0);
        {
            setHighlightColor(color);
        } //End block
        colors = appearance.getColorStateList(com.android.internal.R.styleable.
                                              TextAppearance_textColor);
        {
            setTextColor(colors);
        } //End block
        ts = appearance.getDimensionPixelSize(com.android.internal.R.styleable.
                                              TextAppearance_textSize, 0);
        {
            setRawTextSize(ts);
        } //End block
        colors = appearance.getColorStateList(com.android.internal.R.styleable.
                                              TextAppearance_textColorHint);
        {
            setHintTextColor(colors);
        } //End block
        colors = appearance.getColorStateList(com.android.internal.R.styleable.
                                              TextAppearance_textColorLink);
        {
            setLinkTextColor(colors);
        } //End block
        int typefaceIndex, styleIndex;
        typefaceIndex = appearance.getInt(com.android.internal.R.styleable.
                                          TextAppearance_typeface, -1);
        styleIndex = appearance.getInt(com.android.internal.R.styleable.
                                       TextAppearance_textStyle, -1);
        setTypefaceByIndex(typefaceIndex, styleIndex);
        {
            boolean var3D022060DB92710670FAA09E327DBB0B_151128358 = (appearance.getBoolean(com.android.internal.R.styleable.TextAppearance_textAllCaps,
                false));
            {
                setTransformationMethod(new AllCapsTransformationMethod(getContext()));
            } //End block
        } //End collapsed parenthetic
        appearance.recycle();
        addTaint(context.getTaint());
        addTaint(resid);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.853 -0400", hash_original_method = "5E6FE671862457C6BB25EDC2CEDE399B", hash_generated_method = "5ACFE5FC1635CCBF9618818E1344A6C9")
    public float getTextSize() {
        float var0C1431BDAC3C89F7C02E56A482F7EB06_1982145579 = (mTextPaint.getTextSize());
        float var546ADE640B6EDFBC8A086EF31347E768_1186230661 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1186230661;
        // ---------- Original Method ----------
        //return mTextPaint.getTextSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.853 -0400", hash_original_method = "7DB2A551583349AB1C418E0528006365", hash_generated_method = "7022FE5849C46DA32E3D7BED5130B21D")
    @android.view.RemotableViewMethod
    public void setTextSize(float size) {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        addTaint(size);
        // ---------- Original Method ----------
        //setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.870 -0400", hash_original_method = "487975E6A0CF72E721F7BDECB44E1312", hash_generated_method = "4B448C53682EC74606FB12B49AD68A6B")
    public void setTextSize(int unit, float size) {
        Context c;
        c = getContext();
        Resources r;
        r = Resources.getSystem();
        r = c.getResources();
        setRawTextSize(TypedValue.applyDimension(
            unit, size, r.getDisplayMetrics()));
        addTaint(unit);
        addTaint(size);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.870 -0400", hash_original_method = "ADDFE88D6F3490AE157EE578011F4FFC", hash_generated_method = "A9AEEC7901004DDD90BFAB69A5EECA37")
    private void setRawTextSize(float size) {
        {
            boolean var8490AB7BC9B8B736A0090BC029E3A656_610674810 = (size != mTextPaint.getTextSize());
            {
                mTextPaint.setTextSize(size);
                {
                    nullLayouts();
                    requestLayout();
                    invalidate();
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(size);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.871 -0400", hash_original_method = "8F71F8091E79DE5D49BC786B53F6B56F", hash_generated_method = "121CA5DF200D21EFBB02610492D7CF04")
    public float getTextScaleX() {
        float var4A490DCBBE6DC7C04831F39DE35D9E8E_703311133 = (mTextPaint.getTextScaleX());
        float var546ADE640B6EDFBC8A086EF31347E768_432885098 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_432885098;
        // ---------- Original Method ----------
        //return mTextPaint.getTextScaleX();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.871 -0400", hash_original_method = "32FC23A8E8D24759E03CF98EE692BD3E", hash_generated_method = "6FE69A886F9754451650C562C7F6E3A7")
    @android.view.RemotableViewMethod
    public void setTextScaleX(float size) {
        {
            boolean varE98E2F263E58724773A791619F9AA580_650195716 = (size != mTextPaint.getTextScaleX());
            {
                mUserSetTextScaleX = true;
                mTextPaint.setTextScaleX(size);
                {
                    nullLayouts();
                    requestLayout();
                    invalidate();
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(size);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.872 -0400", hash_original_method = "780D15535FA403FCFD3F32D6E7303769", hash_generated_method = "172CA7BBCDD94FFD2811042D2387ADB4")
    public void setTypeface(Typeface tf) {
        {
            boolean var53A61D5B68551E1C004BF255C4B2B68F_253667522 = (mTextPaint.getTypeface() != tf);
            {
                mTextPaint.setTypeface(tf);
                {
                    nullLayouts();
                    requestLayout();
                    invalidate();
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(tf.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.873 -0400", hash_original_method = "6FFDE601A24D081BE5F9A52F7BB654E9", hash_generated_method = "D317B63885BDEFF48EBB930C9541E1BE")
    public Typeface getTypeface() {
        Typeface varB4EAC82CA7396A68D541C85D26508E83_1878388076 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1878388076 = mTextPaint.getTypeface();
        varB4EAC82CA7396A68D541C85D26508E83_1878388076.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1878388076;
        // ---------- Original Method ----------
        //return mTextPaint.getTypeface();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.873 -0400", hash_original_method = "7D6C422943C1CBA6B222D2B0CA531386", hash_generated_method = "2CAC8DF2A1AC7DE030CB2AA266620CF2")
    @android.view.RemotableViewMethod
    public void setTextColor(int color) {
        mTextColor = ColorStateList.valueOf(color);
        updateTextColors();
        // ---------- Original Method ----------
        //mTextColor = ColorStateList.valueOf(color);
        //updateTextColors();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.874 -0400", hash_original_method = "E5548FB85C1126384CE08AD8E1667A0C", hash_generated_method = "DBCF92A7B6820991B1500FD7CDB6D538")
    public void setTextColor(ColorStateList colors) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.874 -0400", hash_original_method = "E9708E6780595497A0F38B1A3DFD4921", hash_generated_method = "DE284B2D4624EB039CC49E6D2BBD6B90")
    public final ColorStateList getTextColors() {
        ColorStateList varB4EAC82CA7396A68D541C85D26508E83_2001546511 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2001546511 = mTextColor;
        varB4EAC82CA7396A68D541C85D26508E83_2001546511.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2001546511;
        // ---------- Original Method ----------
        //return mTextColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.875 -0400", hash_original_method = "69BC167CA8CC0024E4446D6ED57F972B", hash_generated_method = "D4728A3E1A18332B89408607EF455391")
    public final int getCurrentTextColor() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2031357318 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2031357318;
        // ---------- Original Method ----------
        //return mCurTextColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.876 -0400", hash_original_method = "969DDD835D55F329C6E2048E92EE3D41", hash_generated_method = "196D1EB5FB59C69B1805B4606553D31C")
    @android.view.RemotableViewMethod
    public void setHighlightColor(int color) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.880 -0400", hash_original_method = "5ADAC484D4689A7795B408EA7D6B6AC8", hash_generated_method = "54D7F4CA566DF112A37937ADB2533573")
    public void setShadowLayer(float radius, float dx, float dy, int color) {
        mTextPaint.setShadowLayer(radius, dx, dy, color);
        mShadowRadius = radius;
        mShadowDx = dx;
        mShadowDy = dy;
        invalidate();
        addTaint(color);
        // ---------- Original Method ----------
        //mTextPaint.setShadowLayer(radius, dx, dy, color);
        //mShadowRadius = radius;
        //mShadowDx = dx;
        //mShadowDy = dy;
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.895 -0400", hash_original_method = "5B4E8CD3DF4A8D21F89EBB7BF27B30F6", hash_generated_method = "3FFB86D9DD04D68E1DF9AAC0056F5E7F")
    public TextPaint getPaint() {
        TextPaint varB4EAC82CA7396A68D541C85D26508E83_1797813112 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1797813112 = mTextPaint;
        varB4EAC82CA7396A68D541C85D26508E83_1797813112.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1797813112;
        // ---------- Original Method ----------
        //return mTextPaint;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.896 -0400", hash_original_method = "9B238C42610AAE77586EFF469787CAA2", hash_generated_method = "C5BD2E157496886451F125CEBC428118")
    @android.view.RemotableViewMethod
    public final void setAutoLinkMask(int mask) {
        mAutoLinkMask = mask;
        // ---------- Original Method ----------
        //mAutoLinkMask = mask;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.896 -0400", hash_original_method = "E276016FD2FFF976FC669270E78164FC", hash_generated_method = "212E0D71E4818E9438373D71E959C472")
    @android.view.RemotableViewMethod
    public final void setLinksClickable(boolean whether) {
        mLinksClickable = whether;
        // ---------- Original Method ----------
        //mLinksClickable = whether;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.897 -0400", hash_original_method = "5582C38299F4F11EB9D233BD445CE8CA", hash_generated_method = "0F37D6D691EF2C291DFF07FE4F92606E")
    public final boolean getLinksClickable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_271910601 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_271910601;
        // ---------- Original Method ----------
        //return mLinksClickable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.897 -0400", hash_original_method = "4DF4A96EB5A0519062801E1FD0A991F4", hash_generated_method = "42E09EA41E686980C7CA000206A8DDAD")
    @android.view.RemotableViewMethod
    public final void setSoftInputShownOnFocus(boolean show) {
        mSoftInputShownOnFocus = show;
        // ---------- Original Method ----------
        //mSoftInputShownOnFocus = show;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.897 -0400", hash_original_method = "5A10A6630E4A15A93780A83DCE21BFA6", hash_generated_method = "22CF5AC109E347A47EBEBB0F63028001")
    public final boolean getSoftInputShownOnFocus() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_571942916 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_571942916;
        // ---------- Original Method ----------
        //return mSoftInputShownOnFocus;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.898 -0400", hash_original_method = "7722BA5204257A1CDED1550384208856", hash_generated_method = "65D61960E83B678F35DA2F264E759D3A")
    public URLSpan[] getUrls() {
        URLSpan[] varB4EAC82CA7396A68D541C85D26508E83_797817785 = null; //Variable for return #1
        URLSpan[] varB4EAC82CA7396A68D541C85D26508E83_1236574555 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_797817785 = ((Spanned) mText).getSpans(0, mText.length(), URLSpan.class);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1236574555 = new URLSpan[0];
        } //End block
        URLSpan[] varA7E53CE21691AB073D9660D615818899_1047618468; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1047618468 = varB4EAC82CA7396A68D541C85D26508E83_797817785;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1047618468 = varB4EAC82CA7396A68D541C85D26508E83_1236574555;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1047618468.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1047618468;
        // ---------- Original Method ----------
        //if (mText instanceof Spanned) {
            //return ((Spanned) mText).getSpans(0, mText.length(), URLSpan.class);
        //} else {
            //return new URLSpan[0];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.900 -0400", hash_original_method = "E9B4A1B921938A82A5322DAF3992AE5D", hash_generated_method = "43DB0F7D23C2BA38E919E41FE56D752D")
    @android.view.RemotableViewMethod
    public final void setHintTextColor(int color) {
        mHintTextColor = ColorStateList.valueOf(color);
        updateTextColors();
        // ---------- Original Method ----------
        //mHintTextColor = ColorStateList.valueOf(color);
        //updateTextColors();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.901 -0400", hash_original_method = "FDEA4F057DD6E07AD523C7053B227866", hash_generated_method = "579A043E994B5BCBDC50DABB884C27C2")
    public final void setHintTextColor(ColorStateList colors) {
        mHintTextColor = colors;
        updateTextColors();
        // ---------- Original Method ----------
        //mHintTextColor = colors;
        //updateTextColors();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.922 -0400", hash_original_method = "475EC0453C7F74E6A779EAD7F8319059", hash_generated_method = "EC181EE75D7847F1E6544F537F7A23C0")
    public final ColorStateList getHintTextColors() {
        ColorStateList varB4EAC82CA7396A68D541C85D26508E83_2115811924 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2115811924 = mHintTextColor;
        varB4EAC82CA7396A68D541C85D26508E83_2115811924.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2115811924;
        // ---------- Original Method ----------
        //return mHintTextColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.922 -0400", hash_original_method = "1826756F3CA2F0D97D555C81DC90D9D1", hash_generated_method = "1A0EDF745AB3693CCC77169B77C7545B")
    public final int getCurrentHintTextColor() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_805703585 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_805703585;
        // ---------- Original Method ----------
        //return mHintTextColor != null ? mCurHintTextColor : mCurTextColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.923 -0400", hash_original_method = "9463279339C3C6EB304729CC6A96FD58", hash_generated_method = "57F482ABFE2EE8E9CEF1E8E3D393E6FC")
    @android.view.RemotableViewMethod
    public final void setLinkTextColor(int color) {
        mLinkTextColor = ColorStateList.valueOf(color);
        updateTextColors();
        // ---------- Original Method ----------
        //mLinkTextColor = ColorStateList.valueOf(color);
        //updateTextColors();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.923 -0400", hash_original_method = "9B67E7CBCE87C562841DDA31DA1BE653", hash_generated_method = "037C9825FD527ACDA5C188EDE566FA86")
    public final void setLinkTextColor(ColorStateList colors) {
        mLinkTextColor = colors;
        updateTextColors();
        // ---------- Original Method ----------
        //mLinkTextColor = colors;
        //updateTextColors();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.924 -0400", hash_original_method = "3A49B90BEACC4CBB32A44A5B9C48739C", hash_generated_method = "2B1EC1E6ADB4F6B3555976F10BC6CE19")
    public final ColorStateList getLinkTextColors() {
        ColorStateList varB4EAC82CA7396A68D541C85D26508E83_1130681985 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1130681985 = mLinkTextColor;
        varB4EAC82CA7396A68D541C85D26508E83_1130681985.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1130681985;
        // ---------- Original Method ----------
        //return mLinkTextColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.925 -0400", hash_original_method = "AEAA45BF8B2B9C05CF6AA4E644080F44", hash_generated_method = "25B6CC380E3D945EA440DB8BDB8753BA")
    public void setGravity(int gravity) {
        {
            gravity |= Gravity.START;
        } //End block
        {
            gravity |= Gravity.TOP;
        } //End block
        boolean newLayout;
        newLayout = false;
        {
            newLayout = true;
        } //End block
        {
            invalidate();
            mLayoutAlignment = null;
        } //End block
        mGravity = gravity;
        {
            int want;
            want = mLayout.getWidth();
            int hintWant;
            hintWant = 0;
            hintWant = mHintLayout.getWidth();
            makeNewLayout(want, hintWant, UNKNOWN_BORING, UNKNOWN_BORING,
                          mRight - mLeft - getCompoundPaddingLeft() -
                          getCompoundPaddingRight(), true);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.925 -0400", hash_original_method = "80A4065F7A7EA77AF4C4ADD19E36F9A5", hash_generated_method = "BC674E09E031B9E7B7E165B300D57626")
    public int getGravity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_26477757 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_26477757;
        // ---------- Original Method ----------
        //return mGravity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.925 -0400", hash_original_method = "7C7AF1B698E75A76793B55FAC07B7AAB", hash_generated_method = "DC18E37336FD0C4F4926A2C742589008")
    public int getPaintFlags() {
        int var1FCED777482D649D2D08ED31F26C7C02_92840502 = (mTextPaint.getFlags());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1618998501 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1618998501;
        // ---------- Original Method ----------
        //return mTextPaint.getFlags();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.935 -0400", hash_original_method = "8002046373E96371B4D25FE3E547C1A2", hash_generated_method = "D4DCD5400C04BC677B14F0E8E98D23F0")
    @android.view.RemotableViewMethod
    public void setPaintFlags(int flags) {
        {
            boolean var8072314ED7B1DF7B4CA975059BE6435F_1938575136 = (mTextPaint.getFlags() != flags);
            {
                mTextPaint.setFlags(flags);
                {
                    nullLayouts();
                    requestLayout();
                    invalidate();
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(flags);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.935 -0400", hash_original_method = "EA5DCBED1A48E34EEA6259FD93E64EB0", hash_generated_method = "2799A825DF7BA515349AB569DDAD5A29")
    public void setHorizontallyScrolling(boolean whether) {
        {
            mHorizontallyScrolling = whether;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.936 -0400", hash_original_method = "7B94D421E91473A8A956329EBDF6A0E9", hash_generated_method = "59D028FB5CEECB4EEEC8C869F96DA533")
    public boolean getHorizontallyScrolling() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_201812307 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_201812307;
        // ---------- Original Method ----------
        //return mHorizontallyScrolling;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.936 -0400", hash_original_method = "0EE7081F083B0DC579019805442C8765", hash_generated_method = "4C59F2ED9822C6DB05B6F45EB0296D69")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.937 -0400", hash_original_method = "68757877A1DD20E33F15DE32FA3B7F07", hash_generated_method = "0A56EF1698F37084B430195320861A57")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.937 -0400", hash_original_method = "8B36C1E1F9FD83BB5DA2A8A03A7A6664", hash_generated_method = "B2A20E5243DB69815414D52E2FE309B6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.938 -0400", hash_original_method = "04C4C22BF9024D43E2A856D219B26DEF", hash_generated_method = "454D6005CAD9F205FEF255C979D08AF9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.941 -0400", hash_original_method = "1ADF089518552DEF85C429E373D0543D", hash_generated_method = "BFBDB748B0E03D6DCEF68597A04C08C2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.941 -0400", hash_original_method = "6CD9B04ABBE9A4E392854E2FFBA64155", hash_generated_method = "605750DFFC911807C455EB8BF69BC06C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.942 -0400", hash_original_method = "6EF109AA0B8A98B265CEDBFE77B13F24", hash_generated_method = "D90D5130C6BDA102B7070F71A2C61C54")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.942 -0400", hash_original_method = "CC5034BC1B28BBCD01B0947E11300CEA", hash_generated_method = "AAD5723F0423927F8F6C32B9A4BE6D81")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.956 -0400", hash_original_method = "024C424B12C855A76B8C4D4EF37E56E9", hash_generated_method = "DD52876446D0A1A3DAEC70BAED22C9E3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.956 -0400", hash_original_method = "66D27E295E9935EDB856E68754ECCF50", hash_generated_method = "11CEBBE63F35062DDE2A055E3857C0B3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.956 -0400", hash_original_method = "29184B32707510663C7CC00A1776202A", hash_generated_method = "4DABCC8E368203558E4AE1484330F564")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.957 -0400", hash_original_method = "A6A8746AE8743344ECC9244BF17B5285", hash_generated_method = "16D0F80014324D2EF8F22A1CB338C9F9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.957 -0400", hash_original_method = "9D5DCCC1076394887EA3B21F5DF8F706", hash_generated_method = "3ACC6A936631F9A5D30B66E02C5F5F26")
    public void setLineSpacing(float add, float mult) {
        {
            mSpacingAdd = add;
            mSpacingMult = mult;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.957 -0400", hash_original_method = "699FFD9CCBE3B133871A47DAD4072321", hash_generated_method = "24894E0A2761B92D07D303A53C99D00E")
    public final void append(CharSequence text) {
        append(text, 0, text.length());
        addTaint(text.getTaint());
        // ---------- Original Method ----------
        //append(text, 0, text.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.958 -0400", hash_original_method = "B2621C1C8DC7A6B197F310747926C024", hash_generated_method = "66DFCF5D0E6615919BA97E16CB34FA01")
    public void append(CharSequence text, int start, int end) {
        {
            setText(mText, BufferType.EDITABLE);
        } //End block
        ((Editable) mText).append(text, start, end);
        addTaint(text.getTaint());
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
        //if (!(mText instanceof Editable)) {
            //setText(mText, BufferType.EDITABLE);
        //}
        //((Editable) mText).append(text, start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.958 -0400", hash_original_method = "ADC7043537742A0A0C5E53BD45A182BE", hash_generated_method = "909136A1BAD3A36D919C0076B2DB4595")
    private void updateTextColors() {
        boolean inval;
        inval = false;
        int color;
        color = mTextColor.getColorForState(getDrawableState(), 0);
        {
            mCurTextColor = color;
            inval = true;
        } //End block
        {
            color = mLinkTextColor.getColorForState(getDrawableState(), 0);
            {
                mTextPaint.linkColor = color;
                inval = true;
            } //End block
        } //End block
        {
            color = mHintTextColor.getColorForState(getDrawableState(), 0);
            {
                boolean var945E40D0ED79B723BC035DCD3A98AEB6_228289060 = (color != mCurHintTextColor && mText.length() == 0);
                {
                    mCurHintTextColor = color;
                    inval = true;
                } //End block
            } //End collapsed parenthetic
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.959 -0400", hash_original_method = "3E3CC8861E854C1E6B450E5CB8D8974F", hash_generated_method = "A23CBA35C2D507A7C6E41EE9F3EE082E")
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        {
            boolean varF38C62369483FE4C64EC61B6DD68F7F8_595246184 = (mTextColor != null && mTextColor.isStateful()
                || (mHintTextColor != null && mHintTextColor.isStateful())
                || (mLinkTextColor != null && mLinkTextColor.isStateful()));
            {
                updateTextColors();
            } //End block
        } //End collapsed parenthetic
        Drawables dr;
        dr = mDrawables;
        {
            int[] state;
            state = getDrawableState();
            {
                boolean varACD1486C54959F8A8C53C39EC3474E1F_1908145321 = (dr.mDrawableTop != null && dr.mDrawableTop.isStateful());
                {
                    dr.mDrawableTop.setState(state);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var75A7C8EBF3DB0CE7B23F457B9BBE81BE_1541079668 = (dr.mDrawableBottom != null && dr.mDrawableBottom.isStateful());
                {
                    dr.mDrawableBottom.setState(state);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var351650CF2FFB93A328E0FCD6DD1DB2A5_378511909 = (dr.mDrawableLeft != null && dr.mDrawableLeft.isStateful());
                {
                    dr.mDrawableLeft.setState(state);
                } //End block
            } //End collapsed parenthetic
            {
                boolean varD9BDE0148E482F4604F5C34A36FCFF7F_359046879 = (dr.mDrawableRight != null && dr.mDrawableRight.isStateful());
                {
                    dr.mDrawableRight.setState(state);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var324017722E1CA9DC15695D4422A8ADEC_1251265048 = (dr.mDrawableStart != null && dr.mDrawableStart.isStateful());
                {
                    dr.mDrawableStart.setState(state);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var6C06DB7410AEA6854519536D78FF530C_246850861 = (dr.mDrawableEnd != null && dr.mDrawableEnd.isStateful());
                {
                    dr.mDrawableEnd.setState(state);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.055 -0400", hash_original_method = "AF2C3EA4891B79A54157B80D9A5CB454", hash_generated_method = "A7FABBAD89496EE9A3F7427994B4F19D")
    @Override
    public Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_1996459324 = null; //Variable for return #1
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_507988906 = null; //Variable for return #2
        Parcelable superState;
        superState = super.onSaveInstanceState();
        boolean save;
        save = mFreezesText;
        int start;
        start = 0;
        int end;
        end = 0;
        {
            start = getSelectionStart();
            end = getSelectionEnd();
            {
                save = true;
            } //End block
        } //End block
        {
            SavedState ss;
            ss = new SavedState(superState);
            ss.selStart = start;
            ss.selEnd = end;
            {
                Spannable sp;
                sp = new SpannableString(mText);
                {
                    Iterator<ChangeWatcher> varFB93E86C1F10E675CCE7BF3C5AB8E6B5_832177239 = (sp.getSpans(0, sp.length(), ChangeWatcher.class)).iterator();
                    varFB93E86C1F10E675CCE7BF3C5AB8E6B5_832177239.hasNext();
                    ChangeWatcher cw = varFB93E86C1F10E675CCE7BF3C5AB8E6B5_832177239.next();
                    {
                        sp.removeSpan(cw);
                    } //End block
                } //End collapsed parenthetic
                removeMisspelledSpans(sp);
                sp.removeSpan(mSuggestionRangeSpan);
                ss.text = sp;
            } //End block
            {
                ss.text = mText.toString();
            } //End block
            {
                boolean var7B30392DD0636DC4945382169DDF5396_1027680375 = (isFocused() && start >= 0 && end >= 0);
                {
                    ss.frozenWithFocus = true;
                } //End block
            } //End collapsed parenthetic
            ss.error = mError;
            varB4EAC82CA7396A68D541C85D26508E83_1996459324 = ss;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_507988906 = superState;
        Parcelable varA7E53CE21691AB073D9660D615818899_346332309; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_346332309 = varB4EAC82CA7396A68D541C85D26508E83_1996459324;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_346332309 = varB4EAC82CA7396A68D541C85D26508E83_507988906;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_346332309.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_346332309;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.056 -0400", hash_original_method = "F2FC1C379415C0983647E04C4964FB91", hash_generated_method = "C1519C9DBC6D64808C09560B9B804521")
     void removeMisspelledSpans(Spannable spannable) {
        SuggestionSpan[] suggestionSpans;
        suggestionSpans = spannable.getSpans(0, spannable.length(),
                SuggestionSpan.class);
        {
            int i;
            i = 0;
            {
                int flags;
                flags = suggestionSpans[i].getFlags();
                {
                    spannable.removeSpan(suggestionSpans[i]);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(spannable.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.057 -0400", hash_original_method = "F50E2D5CE86BF5E6A61BC8360971F12F", hash_generated_method = "0EC47CD798DF95EA9A08061F6797F042")
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            super.onRestoreInstanceState(state);
        } //End block
        SavedState ss;
        ss = (SavedState)state;
        super.onRestoreInstanceState(ss.getSuperState());
        {
            setText(ss.text);
        } //End block
        {
            {
                int len;
                len = mText.length();
                {
                    String restored;
                    restored = "";
                    {
                        restored = "(restored) ";
                    } //End block
                } //End block
                {
                    Selection.setSelection((Spannable) mText, ss.selStart,
                                           ss.selEnd);
                    {
                        mFrozenWithFocus = true;
                    } //End block
                } //End block
            } //End block
        } //End block
        {
            CharSequence error;
            error = ss.error;
            post(new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.057 -0400", hash_original_method = "6D4719BAECED3DD83F9692F93AFBC954", hash_generated_method = "28C54C47F8D5EF53BCA9BB85B0F3683C")
                public void run() {
                    setError(error);
                    // ---------- Original Method ----------
                    //setError(error);
                }
});
        } //End block
        addTaint(state.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.068 -0400", hash_original_method = "73E23EE9831A5ABB45118C6D9D08B19B", hash_generated_method = "949FD70C22A0A1B1AABDE9D0E667A116")
    @android.view.RemotableViewMethod
    public void setFreezesText(boolean freezesText) {
        mFreezesText = freezesText;
        // ---------- Original Method ----------
        //mFreezesText = freezesText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.068 -0400", hash_original_method = "8E3F839ECE8B91BC1C15216DAAE76890", hash_generated_method = "C1972D63BA46327CAF401A313D82FBB2")
    public boolean getFreezesText() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_116971201 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_116971201;
        // ---------- Original Method ----------
        //return mFreezesText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.068 -0400", hash_original_method = "72071F64A960BCDF8628E8519218C076", hash_generated_method = "0D865B4C4C33F8BF881769588A4B7450")
    public final void setEditableFactory(Editable.Factory factory) {
        mEditableFactory = factory;
        setText(mText);
        // ---------- Original Method ----------
        //mEditableFactory = factory;
        //setText(mText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.069 -0400", hash_original_method = "EE70434E54240A6008C9D2EA9B017339", hash_generated_method = "D377DBA7CFAFD2BF6D3E343C891A2FD6")
    public final void setSpannableFactory(Spannable.Factory factory) {
        mSpannableFactory = factory;
        setText(mText);
        // ---------- Original Method ----------
        //mSpannableFactory = factory;
        //setText(mText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.069 -0400", hash_original_method = "F37C8918E495A353D909855BE6AEA0B3", hash_generated_method = "5FD53354B68B1DDEE5AEA4EC576FB4A1")
    @android.view.RemotableViewMethod
    public final void setText(CharSequence text) {
        setText(text, mBufferType);
        addTaint(text.getTaint());
        // ---------- Original Method ----------
        //setText(text, mBufferType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.069 -0400", hash_original_method = "8D1404A47F965A96F115CE2D4080AFCB", hash_generated_method = "63DDFB03A800B1C465F653A064123166")
    @android.view.RemotableViewMethod
    public final void setTextKeepState(CharSequence text) {
        setTextKeepState(text, mBufferType);
        addTaint(text.getTaint());
        // ---------- Original Method ----------
        //setTextKeepState(text, mBufferType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.069 -0400", hash_original_method = "607651EBB019EF2524713C89A6A4FC8C", hash_generated_method = "B9AF79FFCD8BCFDA30C1E3FE38203AD1")
    public void setText(CharSequence text, BufferType type) {
        setText(text, type, true, 0);
        {
            mCharWrapper.mChars = null;
        } //End block
        addTaint(text.getTaint());
        addTaint(type.getTaint());
        // ---------- Original Method ----------
        //setText(text, type, true, 0);
        //if (mCharWrapper != null) {
            //mCharWrapper.mChars = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.087 -0400", hash_original_method = "EBAE4ED74D570AD4FF310073DD3BF4E5", hash_generated_method = "34309B12C61FE1FDB171C9A181FC2C4F")
    private void setText(CharSequence text, BufferType type,
                         boolean notifyBefore, int oldlen) {
        {
            text = "";
        } //End block
        {
            boolean var39C938BA181442FDC10CD6D971F0DA0A_1600941662 = (!isSuggestionsEnabled());
            {
                text = removeSuggestionSpans(text);
            } //End block
        } //End collapsed parenthetic
        mTextPaint.setTextScaleX(1.0f);
        {
            boolean var61457476FF8B912C20F73CBD6BFFF2E9_1489697482 = (text instanceof Spanned &&
            ((Spanned) text).getSpanStart(TextUtils.TruncateAt.MARQUEE) >= 0);
            {
                {
                    boolean varA499503C31DDA8FD1F6C5109B7E818B8_1384788789 = (ViewConfiguration.get(mContext).isFadingMarqueeEnabled());
                    {
                        setHorizontalFadingEdgeEnabled(true);
                        mMarqueeFadeMode = MARQUEE_FADE_NORMAL;
                    } //End block
                    {
                        setHorizontalFadingEdgeEnabled(false);
                        mMarqueeFadeMode = MARQUEE_FADE_SWITCH_SHOW_ELLIPSIS;
                    } //End block
                } //End collapsed parenthetic
                setEllipsize(TextUtils.TruncateAt.MARQUEE);
            } //End block
        } //End collapsed parenthetic
        int n;
        n = mFilters.length;
        {
            int i;
            i = 0;
            {
                CharSequence out;
                out = mFilters[i].filter(text, 0, text.length(),
                                                  EMPTY_SPANNED, 0, 0);
                {
                    text = out;
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            {
                oldlen = mText.length();
                sendBeforeTextChanged(mText, 0, oldlen, text.length());
            } //End block
            {
                sendBeforeTextChanged("", 0, 0, text.length());
            } //End block
        } //End block
        boolean needEditableForNotification;
        needEditableForNotification = false;
        {
            boolean var1E59861D1519785A5B1D3AA4CF100E2E_1929201262 = (mListeners != null && mListeners.size() != 0);
            {
                needEditableForNotification = true;
            } //End block
        } //End collapsed parenthetic
        {
            Editable t;
            t = mEditableFactory.newEditable(text);
            text = t;
            setFilters(t, mFilters);
            InputMethodManager imm;
            imm = InputMethodManager.peekInstance();
            imm.restartInput(this);
        } //End block
        {
            text = mSpannableFactory.newSpannable(text);
        } //End block
        {
            text = TextUtils.stringOrSpannedString(text);
        } //End block
        {
            Spannable s2;
            {
                s2 = (Spannable) text;
            } //End block
            {
                s2 = mSpannableFactory.newSpannable(text);
            } //End block
            {
                boolean var97F4E593FAFDDCB3DADB34B707ECC3A4_1948250972 = (Linkify.addLinks(s2, mAutoLinkMask));
                {
                    text = s2;
                    type = (type == BufferType.EDITABLE) ? BufferType.EDITABLE : BufferType.SPANNABLE;
                    mText = text;
                    {
                        boolean var397E1740E7A0A45470AA95146AAA2DB6_293333288 = (mLinksClickable && !textCanBeSelected());
                        {
                            setMovementMethod(LinkMovementMethod.getInstance());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        mBufferType = type;
        mText = text;
        {
            mTransformed = text;
        } //End block
        {
            mTransformed = mTransformation.getTransformation(text, this);
        } //End block
        int textLength;
        textLength = text.length();
        {
            Spannable sp;
            sp = (Spannable) text;
            ChangeWatcher[] watchers;
            watchers = sp.getSpans(0, sp.length(), ChangeWatcher.class);
            int count;
            count = watchers.length;
            {
                int i;
                i = 0;
                sp.removeSpan(watchers[i]);
            } //End collapsed parenthetic
            mChangeWatcher = new ChangeWatcher();
            sp.setSpan(mChangeWatcher, 0, textLength, Spanned.SPAN_INCLUSIVE_INCLUSIVE |
                       (PRIORITY << Spanned.SPAN_PRIORITY_SHIFT));
            {
                sp.setSpan(mInput, 0, textLength, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
            } //End block
            {
                sp.setSpan(mTransformation, 0, textLength, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
            } //End block
            {
                mMovement.initialize(this, (Spannable) text);
                mSelectionMoved = false;
            } //End block
        } //End block
        {
            checkForRelayout();
        } //End block
        sendOnTextChanged(text, 0, oldlen, textLength);
        onTextChanged(text, 0, oldlen, textLength);
        {
            sendAfterTextChanged((Editable) text);
        } //End block
        prepareCursorControllers();
        addTaint(notifyBefore);
        addTaint(oldlen);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.102 -0400", hash_original_method = "36BFF315CD4AAC9D68E14477979C2AB5", hash_generated_method = "F5867CC192EEA197DC72C8EDB5292224")
    public final void setText(char[] text, int start, int len) {
        int oldlen;
        oldlen = 0;
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(start + ", " + len);
        } //End block
        {
            oldlen = mText.length();
            sendBeforeTextChanged(mText, 0, oldlen, len);
        } //End block
        {
            sendBeforeTextChanged("", 0, 0, len);
        } //End block
        {
            mCharWrapper = new CharWrapper(text, start, len);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.103 -0400", hash_original_method = "9AF748BA799D545173D512FE98AE91A8", hash_generated_method = "23DA67CAC6D90845B1A852DCEF0C65E8")
    public final void setTextKeepState(CharSequence text, BufferType type) {
        int start;
        start = getSelectionStart();
        int end;
        end = getSelectionEnd();
        int len;
        len = text.length();
        setText(text, type);
        {
            {
                Selection.setSelection((Spannable) mText,
                                       Math.max(0, Math.min(start, len)),
                                       Math.max(0, Math.min(end, len)));
            } //End block
        } //End block
        addTaint(text.getTaint());
        addTaint(type.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.104 -0400", hash_original_method = "F67FB9F700F5516CACC8B84E46FAB678", hash_generated_method = "0676B0A1EA7DE798FD69D229DC16E951")
    @android.view.RemotableViewMethod
    public final void setText(int resid) {
        setText(getContext().getResources().getText(resid));
        addTaint(resid);
        // ---------- Original Method ----------
        //setText(getContext().getResources().getText(resid));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.104 -0400", hash_original_method = "A59BD645A347EA39C4147D9E24C2BE1F", hash_generated_method = "D6998C7794E793B2FC3B3526082C628A")
    public final void setText(int resid, BufferType type) {
        setText(getContext().getResources().getText(resid), type);
        addTaint(resid);
        addTaint(type.getTaint());
        // ---------- Original Method ----------
        //setText(getContext().getResources().getText(resid), type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.105 -0400", hash_original_method = "E428F8CA5E03E5225CDDDB51AA0FFAC9", hash_generated_method = "6E6F214C3C5D075A9E6139AE588776A4")
    @android.view.RemotableViewMethod
    public final void setHint(CharSequence hint) {
        mHint = TextUtils.stringOrSpannedString(hint);
        {
            checkForRelayout();
        } //End block
        {
            boolean varC3772D22FF7A469D7982AA256079D67D_40471431 = (mText.length() == 0);
            {
                invalidate();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //mHint = TextUtils.stringOrSpannedString(hint);
        //if (mLayout != null) {
            //checkForRelayout();
        //}
        //if (mText.length() == 0) {
            //invalidate();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.105 -0400", hash_original_method = "38FC4DBAEFB265C97233FE4F28F668E7", hash_generated_method = "D97F0928A4E76D2BFDE4CD82A8D2A721")
    @android.view.RemotableViewMethod
    public final void setHint(int resid) {
        setHint(getContext().getResources().getText(resid));
        addTaint(resid);
        // ---------- Original Method ----------
        //setHint(getContext().getResources().getText(resid));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.105 -0400", hash_original_method = "B545FCA8809064A694F5A37F99B0BBF1", hash_generated_method = "D86B375AD68DC122BE4AA1BFCD69D35B")
    @ViewDebug.CapturedViewProperty
    public CharSequence getHint() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2035875899 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2035875899 = mHint;
        varB4EAC82CA7396A68D541C85D26508E83_2035875899.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2035875899;
        // ---------- Original Method ----------
        //return mHint;
    }

    
        private static boolean isMultilineInputType(int type) {
        return (type & (EditorInfo.TYPE_MASK_CLASS | EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE)) ==
            (EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.121 -0400", hash_original_method = "49514C27E12484581D1021562BB6B56C", hash_generated_method = "54CE93FB88A190013B1368344D71FABD")
    public void setInputType(int type) {
        boolean wasPassword;
        wasPassword = isPasswordInputType(mInputType);
        boolean wasVisiblePassword;
        wasVisiblePassword = isVisiblePasswordInputType(mInputType);
        setInputType(type, false);
        boolean isPassword;
        isPassword = isPasswordInputType(type);
        boolean isVisiblePassword;
        isVisiblePassword = isVisiblePasswordInputType(type);
        boolean forceUpdate;
        forceUpdate = false;
        {
            setTransformationMethod(PasswordTransformationMethod.getInstance());
            setTypefaceByIndex(MONOSPACE, 0);
        } //End block
        {
            {
                boolean var8E3893E4544969EB4AD418651F643506_1094967089 = (mTransformation == PasswordTransformationMethod.getInstance());
                {
                    forceUpdate = true;
                } //End block
            } //End collapsed parenthetic
            setTypefaceByIndex(MONOSPACE, 0);
        } //End block
        {
            setTypefaceByIndex(-1, -1);
            {
                boolean var8E3893E4544969EB4AD418651F643506_795815607 = (mTransformation == PasswordTransformationMethod.getInstance());
                {
                    forceUpdate = true;
                } //End block
            } //End collapsed parenthetic
        } //End block
        boolean singleLine;
        singleLine = !isMultilineInputType(type);
        {
            applySingleLine(singleLine, !isPassword, true);
        } //End block
        {
            boolean var39C938BA181442FDC10CD6D971F0DA0A_1345815122 = (!isSuggestionsEnabled());
            {
                mText = removeSuggestionSpans(mText);
            } //End block
        } //End collapsed parenthetic
        InputMethodManager imm;
        imm = InputMethodManager.peekInstance();
        imm.restartInput(this);
        addTaint(type);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.121 -0400", hash_original_method = "103CDD92E42BC521C8FE05F02491D14C", hash_generated_method = "B59AB97BFBB327FF1FE361BDB26AF644")
    private boolean hasPasswordTransformationMethod() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_43418351 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_43418351;
        // ---------- Original Method ----------
        //return mTransformation instanceof PasswordTransformationMethod;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.122 -0400", hash_original_method = "5561319FE52E5BCF6B9F27794140DEB3", hash_generated_method = "9597CC79B00C6F9A01B8A8F839246F14")
    public void setRawInputType(int type) {
        mInputType = type;
        // ---------- Original Method ----------
        //mInputType = type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.125 -0400", hash_original_method = "95BF8AE0F4607DDA852256E0031089E3", hash_generated_method = "A117B8A284CBDA00A2E516CC90B1ABC7")
    private void setInputType(int type, boolean direct) {
        int cls;
        cls = type & EditorInfo.TYPE_MASK_CLASS;
        KeyListener input;
        {
            boolean autotext;
            autotext = (type & EditorInfo.TYPE_TEXT_FLAG_AUTO_CORRECT) != 0;
            TextKeyListener.Capitalize cap;
            {
                cap = TextKeyListener.Capitalize.CHARACTERS;
            } //End block
            {
                cap = TextKeyListener.Capitalize.WORDS;
            } //End block
            {
                cap = TextKeyListener.Capitalize.SENTENCES;
            } //End block
            {
                cap = TextKeyListener.Capitalize.NONE;
            } //End block
            input = TextKeyListener.getInstance(autotext, cap);
        } //End block
        {
            input = DigitsKeyListener.getInstance(
                    (type & EditorInfo.TYPE_NUMBER_FLAG_SIGNED) != 0,
                    (type & EditorInfo.TYPE_NUMBER_FLAG_DECIMAL) != 0);
        } //End block
        {
            //Begin case EditorInfo.TYPE_DATETIME_VARIATION_DATE 
            input = DateKeyListener.getInstance();
            //End case EditorInfo.TYPE_DATETIME_VARIATION_DATE 
            //Begin case EditorInfo.TYPE_DATETIME_VARIATION_TIME 
            input = TimeKeyListener.getInstance();
            //End case EditorInfo.TYPE_DATETIME_VARIATION_TIME 
            //Begin case default 
            input = DateTimeKeyListener.getInstance();
            //End case default 
        } //End block
        {
            input = DialerKeyListener.getInstance();
        } //End block
        {
            input = TextKeyListener.getInstance();
        } //End block
        setRawInputType(type);
        mInput = input;
        {
            setKeyListenerOnly(input);
        } //End block
        addTaint(type);
        addTaint(direct);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.131 -0400", hash_original_method = "CC20F62DEC3871662808940856B4AD97", hash_generated_method = "3D6D9E55977C693F5C51D830C3E792DE")
    public int getInputType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2044879916 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2044879916;
        // ---------- Original Method ----------
        //return mInputType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.132 -0400", hash_original_method = "15D43244184C7971E001BEB05B105E77", hash_generated_method = "117C1C617D922EE43C934AA41161E1C9")
    public void setImeOptions(int imeOptions) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.132 -0400", hash_original_method = "2B64657558FBAC5C9C7E6BDC8C1A3258", hash_generated_method = "85236805DBBD9D4230B475372E5C2BDC")
    public int getImeOptions() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1456526187 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1456526187;
        // ---------- Original Method ----------
        //return mInputContentType != null
                //? mInputContentType.imeOptions : EditorInfo.IME_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.136 -0400", hash_original_method = "1A4477F3225C39150F0F3FBD7557F91B", hash_generated_method = "C5C5C9001CAC3A457FF8C92679B7DAB1")
    public void setImeActionLabel(CharSequence label, int actionId) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.138 -0400", hash_original_method = "A4E3D8286D59E9D4715BBC467F3D8808", hash_generated_method = "39A9A0B5341552B8D6B24322A4CA1FF2")
    public CharSequence getImeActionLabel() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_740894173 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_740894173 = mInputContentType != null
                ? mInputContentType.imeActionLabel : null;
        varB4EAC82CA7396A68D541C85D26508E83_740894173.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_740894173;
        // ---------- Original Method ----------
        //return mInputContentType != null
                //? mInputContentType.imeActionLabel : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.144 -0400", hash_original_method = "4B4E4CA7604BFFF08B66F520F2D9A667", hash_generated_method = "B395F0236ED40C8E179C6EF426AA4775")
    public int getImeActionId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_997956029 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_997956029;
        // ---------- Original Method ----------
        //return mInputContentType != null
                //? mInputContentType.imeActionId : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.145 -0400", hash_original_method = "46DFB908E4A3870151F9CA120300C85B", hash_generated_method = "7133F0CAC1B7FFEC84F7A49EB5CE45B6")
    public void setOnEditorActionListener(OnEditorActionListener l) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.146 -0400", hash_original_method = "0518018E7AD402CBF7FDAFFEA66C2B57", hash_generated_method = "DD4C8BEC59117493CA410711F0759930")
    public void onEditorAction(int actionCode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        InputContentType ict;
        ict = mInputContentType;
        {
            {
                {
                    boolean varC6096D11527A2336F0603C550DF9620B_1921372751 = (ict.onEditorActionListener.onEditorAction(this,
                        actionCode, null));
                } //End collapsed parenthetic
            } //End block
            {
                View v;
                v = focusSearch(FOCUS_FORWARD);
                {
                    {
                        boolean var1C5B6BCE2F4451CCE5A9C33B9CF3E849_57980677 = (!v.requestFocus(FOCUS_FORWARD));
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("focus search returned a view " +
                                "that wasn't able to take focus!");
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            {
                View v;
                v = focusSearch(FOCUS_BACKWARD);
                {
                    {
                        boolean varF90963F65450DE26E78172A72D4AE61B_1353973066 = (!v.requestFocus(FOCUS_BACKWARD));
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("focus search returned a view " +
                                "that wasn't able to take focus!");
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            {
                InputMethodManager imm;
                imm = InputMethodManager.peekInstance();
                {
                    boolean var4FA09E363AF255ACFA7DE6A3A2C1C773_191069970 = (imm != null && imm.isActive(this));
                    {
                        imm.hideSoftInputFromWindow(getWindowToken(), 0);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        Handler h;
        h = getHandler();
        {
            long eventTime;
            eventTime = SystemClock.uptimeMillis();
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
        addTaint(actionCode);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.146 -0400", hash_original_method = "E93C7F3F4C0717B4FFE77CC972CA5ABA", hash_generated_method = "FF535EDD450BA14F782FC3096947B6EC")
    public void setPrivateImeOptions(String type) {
        mInputContentType = new InputContentType();
        mInputContentType.privateImeOptions = type;
        // ---------- Original Method ----------
        //if (mInputContentType == null) mInputContentType = new InputContentType();
        //mInputContentType.privateImeOptions = type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.158 -0400", hash_original_method = "92B56934BB38E74A857D4D87A23CFEBD", hash_generated_method = "EE10AC954AEB9250F1F9A8053A7E502A")
    public String getPrivateImeOptions() {
        String varB4EAC82CA7396A68D541C85D26508E83_706382367 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_706382367 = mInputContentType != null
                ? mInputContentType.privateImeOptions : null;
        varB4EAC82CA7396A68D541C85D26508E83_706382367.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_706382367;
        // ---------- Original Method ----------
        //return mInputContentType != null
                //? mInputContentType.privateImeOptions : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.159 -0400", hash_original_method = "4D2957EAEB6AF33B1C49D1AAB860E441", hash_generated_method = "7A3EC6FBC2CC5A34F44EDE37B72051D3")
    public void setInputExtras(int xmlResId) throws XmlPullParserException, IOException {
        XmlResourceParser parser;
        parser = getResources().getXml(xmlResId);
        mInputContentType = new InputContentType();
        mInputContentType.extras = new Bundle();
        getResources().parseBundleExtras(parser, mInputContentType.extras);
        addTaint(xmlResId);
        // ---------- Original Method ----------
        //XmlResourceParser parser = getResources().getXml(xmlResId);
        //if (mInputContentType == null) mInputContentType = new InputContentType();
        //mInputContentType.extras = new Bundle();
        //getResources().parseBundleExtras(parser, mInputContentType.extras);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.160 -0400", hash_original_method = "3CCBAE1ACA56EC727CC56362E5EC99DC", hash_generated_method = "D30CAB4A3C2A08B80677833353067147")
    public Bundle getInputExtras(boolean create) {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_154348981 = null; //Variable for return #1
        Bundle varB4EAC82CA7396A68D541C85D26508E83_683385612 = null; //Variable for return #2
        Bundle varB4EAC82CA7396A68D541C85D26508E83_378593212 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_154348981 = null;
            mInputContentType = new InputContentType();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_683385612 = null;
            mInputContentType.extras = new Bundle();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_378593212 = mInputContentType.extras;
        addTaint(create);
        Bundle varA7E53CE21691AB073D9660D615818899_1134504747; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1134504747 = varB4EAC82CA7396A68D541C85D26508E83_154348981;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1134504747 = varB4EAC82CA7396A68D541C85D26508E83_683385612;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1134504747 = varB4EAC82CA7396A68D541C85D26508E83_378593212;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1134504747.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1134504747;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.160 -0400", hash_original_method = "9A980CBEBB946A11C624D95D8D1017B2", hash_generated_method = "9167E0743198658909926A9E3BAEA829")
    public CharSequence getError() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_771646720 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_771646720 = mError;
        varB4EAC82CA7396A68D541C85D26508E83_771646720.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_771646720;
        // ---------- Original Method ----------
        //return mError;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.160 -0400", hash_original_method = "D7457C91A83A908A8309ED29F602BDCA", hash_generated_method = "DBE52232585C730D381954C81D66D152")
    @android.view.RemotableViewMethod
    public void setError(CharSequence error) {
        {
            setError(null, null);
        } //End block
        {
            Drawable dr;
            dr = getContext().getResources().
                getDrawable(com.android.internal.R.drawable.indicator_input_error);
            dr.setBounds(0, 0, dr.getIntrinsicWidth(), dr.getIntrinsicHeight());
            setError(error, dr);
        } //End block
        addTaint(error.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.167 -0400", hash_original_method = "A707A7C4B74C4D669C69114C0D73A7BA", hash_generated_method = "9A472333ED599900D0E39FF373A86025")
    public void setError(CharSequence error, Drawable icon) {
        error = TextUtils.stringOrSpannedString(error);
        mError = error;
        mErrorWasChanged = true;
        Drawables dr;
        dr = mDrawables;
        {
            {
                Object var9F1D8BFC1663434C04073ED5C9ABAE03_654645806 = (getResolvedLayoutDirection());
                //Begin case default LAYOUT_DIRECTION_LTR 
                setCompoundDrawables(dr.mDrawableLeft, dr.mDrawableTop, icon,
                            dr.mDrawableBottom);
                //End case default LAYOUT_DIRECTION_LTR 
                //Begin case LAYOUT_DIRECTION_RTL 
                setCompoundDrawables(icon, dr.mDrawableTop, dr.mDrawableRight,
                            dr.mDrawableBottom);
                //End case LAYOUT_DIRECTION_RTL 
            } //End collapsed parenthetic
        } //End block
        {
            setCompoundDrawables(null, null, icon, null);
        } //End block
        {
            {
                {
                    boolean var4EAD5BA12B52AD8D73AFD9224AD88B47_857227923 = (mPopup.isShowing());
                    {
                        mPopup.dismiss();
                    } //End block
                } //End collapsed parenthetic
                mPopup = null;
            } //End block
        } //End block
        {
            {
                boolean var98C1250B21329AE579A768A5FB60FE48_1388381490 = (isFocused());
                {
                    showError();
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(icon.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.168 -0400", hash_original_method = "691606EEB666F38CF8433096C671CCBD", hash_generated_method = "65A3719F9F6A4B866AC0015E95E3633C")
    private void showError() {
        {
            boolean varFF25C8C36D549896D247167EFDFCA86E_1519114997 = (getWindowToken() == null);
            {
                mShowErrorAfterAttach = true;
            } //End block
        } //End collapsed parenthetic
        {
            LayoutInflater inflater;
            inflater = LayoutInflater.from(getContext());
            TextView err;
            err = (TextView) inflater.inflate(
                    com.android.internal.R.layout.textview_hint, null);
            float scale;
            scale = getResources().getDisplayMetrics().density;
            mPopup = new ErrorPopup(err, (int) (200 * scale + 0.5f), (int) (50 * scale + 0.5f));
            mPopup.setFocusable(false);
            mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        } //End block
        TextView tv;
        tv = (TextView) mPopup.getContentView();
        chooseSize(mPopup, mError, tv);
        tv.setText(mError);
        mPopup.showAsDropDown(this, getErrorX(), getErrorY());
        mPopup.fixDirection(mPopup.isAboveAnchor());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.176 -0400", hash_original_method = "193E855DAAE9F0495F7DD2501E8046B7", hash_generated_method = "87ADB88DE9E0F54485E8646E7BD5D38D")
    private int getErrorX() {
        float scale;
        scale = getResources().getDisplayMetrics().density;
        Drawables dr;
        dr = mDrawables;
        int var5CC39021D81A29A88ABF707530C095B6_1361383094 = (getWidth() - mPopup.getWidth() - getPaddingRight() -
                (dr != null ? dr.mDrawableSizeRight : 0) / 2 + (int) (25 * scale + 0.5f)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1234901853 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1234901853;
        // ---------- Original Method ----------
        //final float scale = getResources().getDisplayMetrics().density;
        //final Drawables dr = mDrawables;
        //return getWidth() - mPopup.getWidth() - getPaddingRight() -
                //(dr != null ? dr.mDrawableSizeRight : 0) / 2 + (int) (25 * scale + 0.5f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.178 -0400", hash_original_method = "AEF78C4F5C84BB7DCAE783FBA8691257", hash_generated_method = "46CC63265241B0CE4D116DF35D3AB43F")
    private int getErrorY() {
        int compoundPaddingTop;
        compoundPaddingTop = getCompoundPaddingTop();
        int vspace;
        vspace = mBottom - mTop - getCompoundPaddingBottom() - compoundPaddingTop;
        Drawables dr;
        dr = mDrawables;
        int icontop;
        icontop = compoundPaddingTop +
                (vspace - (dr != null ? dr.mDrawableHeightRight : 0)) / 2;//DSFIXME:  CODE0008: Nested ternary operator in expression
        float scale;
        scale = getResources().getDisplayMetrics().density;
        int var003746F0616F92D98A8FCB729FE8B13B_833951435 = (icontop + (dr != null ? dr.mDrawableHeightRight : 0) - getHeight() -
                (int) (2 * scale + 0.5f)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_141848110 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_141848110;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.186 -0400", hash_original_method = "F599686205634A1B40098A399108C287", hash_generated_method = "4E54CF9B8151C885BF35FDCA17042626")
    private void hideError() {
        {
            {
                boolean var064AFD47A2F0375BD3A49E11623DCB44_1104572026 = (mPopup.isShowing());
                {
                    mPopup.dismiss();
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.186 -0400", hash_original_method = "E776865F48A57A0CE6F068EC64FA9769", hash_generated_method = "63E2FD674CBB7FF4B44CBB3BB62EBD40")
    private void chooseSize(PopupWindow pop, CharSequence text, TextView tv) {
        int wid;
        wid = tv.getPaddingLeft() + tv.getPaddingRight();
        int ht;
        ht = tv.getPaddingTop() + tv.getPaddingBottom();
        int defaultWidthInPixels;
        defaultWidthInPixels = getResources().getDimensionPixelSize(
                com.android.internal.R.dimen.textview_error_popup_default_width);
        Layout l;
        l = new StaticLayout(text, tv.getPaint(), defaultWidthInPixels,
                                    Layout.Alignment.ALIGN_NORMAL, 1, 0, true);
        float max;
        max = 0;
        {
            int i;
            i = 0;
            boolean var042843EFDE50DED9CF686A63F696B025_76117113 = (i < l.getLineCount());
            {
                max = Math.max(max, l.getLineWidth(i));
            } //End block
        } //End collapsed parenthetic
        pop.setWidth(wid + (int) Math.ceil(max));
        pop.setHeight(ht + l.getHeight());
        addTaint(pop.getTaint());
        addTaint(text.getTaint());
        addTaint(tv.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.187 -0400", hash_original_method = "5914A6C90CD99156CDEB55240C7F0CC3", hash_generated_method = "527758B46C9BBBB417C169D8F36E3F7A")
    @Override
    protected boolean setFrame(int l, int t, int r, int b) {
        boolean result;
        result = super.setFrame(l, t, r, b);
        {
            TextView tv;
            tv = (TextView) mPopup.getContentView();
            chooseSize(mPopup, mError, tv);
            mPopup.update(this, getErrorX(), getErrorY(),
                          mPopup.getWidth(), mPopup.getHeight());
        } //End block
        restartMarqueeIfNeeded();
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1794965352 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1794965352;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.188 -0400", hash_original_method = "F008D6FB8FE5770ECA7C6E535BB409D7", hash_generated_method = "58C3F38AB1DCEF27A70B6FDEB5D5ADF4")
    private void restartMarqueeIfNeeded() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.188 -0400", hash_original_method = "BC1716C27CAAB9B1A5BA926037A5041B", hash_generated_method = "5FB3243FB057E69E4F6D0771C193732B")
    public void setFilters(InputFilter[] filters) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        mFilters = filters;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.189 -0400", hash_original_method = "48C3B4A6108D00EDE1CFE79059C5E0E2", hash_generated_method = "C870957A4CA8F1F01DFACC2390964473")
    private void setFilters(Editable e, InputFilter[] filters) {
        {
            InputFilter[] nf;
            nf = new InputFilter[filters.length + 1];
            System.arraycopy(filters, 0, nf, 0, filters.length);
            nf[filters.length] = (InputFilter) mInput;
            e.setFilters(nf);
        } //End block
        {
            e.setFilters(filters);
        } //End block
        addTaint(e.getTaint());
        addTaint(filters[0].getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.193 -0400", hash_original_method = "E0010D0DD1DD8F03E408AEE972028B3D", hash_generated_method = "0B3669BC8567F946F6AF76A5E337C2DC")
    public InputFilter[] getFilters() {
        InputFilter[] varB4EAC82CA7396A68D541C85D26508E83_1479294275 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1479294275 = mFilters;
        varB4EAC82CA7396A68D541C85D26508E83_1479294275.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1479294275;
        // ---------- Original Method ----------
        //return mFilters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.199 -0400", hash_original_method = "DAA92D774C652EE383E55D96FD59260D", hash_generated_method = "D578276567C6F3EF1B7313D70208CF40")
    private int getVerticalOffset(boolean forceNormal) {
        int voffset;
        voffset = 0;
        int gravity;
        gravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
        Layout l;
        l = mLayout;
        {
            boolean varD5DF217776FEC14CA244AC2CD8EE62D0_982654562 = (!forceNormal && mText.length() == 0 && mHintLayout != null);
            {
                l = mHintLayout;
            } //End block
        } //End collapsed parenthetic
        {
            int boxht;
            {
                boxht = getMeasuredHeight() - getCompoundPaddingTop() -
                        getCompoundPaddingBottom();
            } //End block
            {
                boxht = getMeasuredHeight() - getExtendedPaddingTop() -
                        getExtendedPaddingBottom();
            } //End block
            int textht;
            textht = l.getHeight();
            {
                voffset = boxht - textht;
                voffset = (boxht - textht) >> 1;
            } //End block
        } //End block
        addTaint(forceNormal);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1077270647 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1077270647;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.200 -0400", hash_original_method = "FA4757416C7C28BA09CF9D290B4D7551", hash_generated_method = "4B78A3F48F619564FC6D0B6A67CFE704")
    private int getBottomVerticalOffset(boolean forceNormal) {
        int voffset;
        voffset = 0;
        int gravity;
        gravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
        Layout l;
        l = mLayout;
        {
            boolean varD5DF217776FEC14CA244AC2CD8EE62D0_519867873 = (!forceNormal && mText.length() == 0 && mHintLayout != null);
            {
                l = mHintLayout;
            } //End block
        } //End collapsed parenthetic
        {
            int boxht;
            {
                boxht = getMeasuredHeight() - getCompoundPaddingTop() -
                        getCompoundPaddingBottom();
            } //End block
            {
                boxht = getMeasuredHeight() - getExtendedPaddingTop() -
                        getExtendedPaddingBottom();
            } //End block
            int textht;
            textht = l.getHeight();
            {
                voffset = boxht - textht;
                voffset = (boxht - textht) >> 1;
            } //End block
        } //End block
        addTaint(forceNormal);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_446640264 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_446640264;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.201 -0400", hash_original_method = "53216DF5147B6AD3B10E93427C42A87D", hash_generated_method = "421687B0918584DB2AFE7849AF85CADA")
    private void invalidateCursorPath() {
        {
            invalidateCursor();
        } //End block
        {
            int horizontalPadding;
            horizontalPadding = getCompoundPaddingLeft();
            int verticalPadding;
            verticalPadding = getExtendedPaddingTop() + getVerticalOffset(true);
            {
                {
                    float thick;
                    thick = FloatMath.ceil(mTextPaint.getStrokeWidth());
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
            {
                {
                    int i;
                    i = 0;
                    {
                        Rect bounds;
                        bounds = mCursorDrawable[i].getBounds();
                        invalidate(bounds.left + horizontalPadding, bounds.top + verticalPadding,
                            bounds.right + horizontalPadding, bounds.bottom + verticalPadding);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.205 -0400", hash_original_method = "18CF38FA770F258E57001CEB5008E4BD", hash_generated_method = "0546C0D28AEF5BC033824D5EC02856DE")
    private void invalidateCursor() {
        int where;
        where = getSelectionEnd();
        invalidateCursor(where, where, where);
        // ---------- Original Method ----------
        //int where = getSelectionEnd();
        //invalidateCursor(where, where, where);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.205 -0400", hash_original_method = "7C61928A88071E487AF3987FA1C70EFA", hash_generated_method = "1CCEFC67B77EB1423F2B2005A5BB61B1")
    private void invalidateCursor(int a, int b, int c) {
        {
            int start;
            start = Math.min(Math.min(a, b), c);
            int end;
            end = Math.max(Math.max(a, b), c);
            invalidateRegion(start, end, true );
        } //End block
        addTaint(a);
        addTaint(b);
        addTaint(c);
        // ---------- Original Method ----------
        //if (a >= 0 || b >= 0 || c >= 0) {
            //int start = Math.min(Math.min(a, b), c);
            //int end = Math.max(Math.max(a, b), c);
            //invalidateRegion(start, end, true );
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.216 -0400", hash_original_method = "D9CEA3E6F10B2E8340E14518563D9425", hash_generated_method = "632EA7E228B105A35537A32685528832")
     void invalidateRegion(int start, int end, boolean invalidateCursor) {
        {
            invalidate();
        } //End block
        {
            int lineStart;
            lineStart = mLayout.getLineForOffset(start);
            int top;
            top = mLayout.getLineTop(lineStart);
            {
                top -= mLayout.getLineDescent(lineStart - 1);
            } //End block
            int lineEnd;
            lineEnd = lineStart;
            lineEnd = mLayout.getLineForOffset(end);
            int bottom;
            bottom = mLayout.getLineBottom(lineEnd);
            {
                {
                    int i;
                    i = 0;
                    {
                        Rect bounds;
                        bounds = mCursorDrawable[i].getBounds();
                        top = Math.min(top, bounds.top);
                        bottom = Math.max(bottom, bounds.bottom);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            int compoundPaddingLeft;
            compoundPaddingLeft = getCompoundPaddingLeft();
            int verticalPadding;
            verticalPadding = getExtendedPaddingTop() + getVerticalOffset(true);
            int left, right;
            {
                left = (int) mLayout.getPrimaryHorizontal(start);
                right = (int) (mLayout.getPrimaryHorizontal(end) + 1.0);
                left += compoundPaddingLeft;
                right += compoundPaddingLeft;
            } //End block
            {
                left = compoundPaddingLeft;
                right = getWidth() - getCompoundPaddingRight();
            } //End block
            invalidate(mScrollX + left, verticalPadding + top,
                        mScrollX + right, verticalPadding + bottom);
        } //End block
        addTaint(start);
        addTaint(end);
        addTaint(invalidateCursor);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.217 -0400", hash_original_method = "14444C10F141ED0D65415BFE9043EE15", hash_generated_method = "88E9D8CE25955F3B01039CE6A8BC6CAB")
    private void registerForPreDraw() {
        ViewTreeObserver observer;
        observer = getViewTreeObserver();
        {
            observer.addOnPreDrawListener(this);
            mPreDrawState = PREDRAW_PENDING;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.224 -0400", hash_original_method = "7ED99206FCCA4C828A375B5616572C0F", hash_generated_method = "4EFCDCF965A733B6C0FF9B110D479154")
    public boolean onPreDraw() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            assumeLayout();
        } //End block
        boolean changed;
        changed = false;
        {
            int curs;
            curs = getSelectionEnd();
            {
                boolean var12D57A2CE148B359BC68B232D2B7DC8F_751766313 = (mSelectionModifierCursorController != null &&
                    mSelectionModifierCursorController.isSelectionStartDragged());
                {
                    curs = getSelectionStart();
                } //End block
            } //End collapsed parenthetic
            {
                curs = mText.length();
            } //End block
            {
                changed = bringPointIntoView(curs);
            } //End block
        } //End block
        {
            changed = bringTextIntoView();
        } //End block
        {
            startSelectionActionMode();
            mCreatedWithASelection = false;
        } //End block
        {
            boolean varA5CB988193F65A0949A8B845CF954A56_1400321346 = (this instanceof ExtractEditText && hasSelection());
            {
                startSelectionActionMode();
            } //End block
        } //End collapsed parenthetic
        mPreDrawState = PREDRAW_DONE;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_502327914 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_502327914;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.225 -0400", hash_original_method = "37A00D47E5792B2A68D22343089CAC73", hash_generated_method = "F27A0C97CE7F2D601E55DD34C1A6F403")
    @Override
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAttachedToWindow();
        mTemporaryDetach = false;
        {
            showError();
            mShowErrorAfterAttach = false;
        } //End block
        ViewTreeObserver observer;
        observer = getViewTreeObserver();
        {
            observer.addOnTouchModeChangeListener(mInsertionPointCursorController);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.226 -0400", hash_original_method = "16099E9CBA4D38D7973AB46B58716911", hash_generated_method = "2A5D4722F837D32D1039532CE4527E5B")
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDetachedFromWindow();
        ViewTreeObserver observer;
        observer = getViewTreeObserver();
        {
            observer.removeOnPreDrawListener(this);
            mPreDrawState = PREDRAW_NOT_REGISTERED;
        } //End block
        {
            hideError();
        } //End block
        {
            mBlink.removeCallbacks(mBlink);
        } //End block
        {
            mInsertionPointCursorController.onDetached();
        } //End block
        {
            mSelectionModifierCursorController.onDetached();
        } //End block
        hideControllers();
        resetResolvedDrawables();
        {
            mSpellChecker.closeSession();
            mSpellChecker = null;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.226 -0400", hash_original_method = "F9485E7598554FF005152B05BE66332E", hash_generated_method = "8A621C87C2296695538DD8F93DB2AE01")
    @Override
    protected boolean isPaddingOffsetRequired() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1057606751 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1057606751;
        // ---------- Original Method ----------
        //return mShadowRadius != 0 || mDrawables != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.227 -0400", hash_original_method = "7F5FAD56D372BFDBD8919382F1DF4F10", hash_generated_method = "C6E039338401D9083941197CD92BCA44")
    @Override
    protected int getLeftPaddingOffset() {
        int var58C5EE75D3D1900953AF755581344C8A_1221424737 = (getCompoundPaddingLeft() - mPaddingLeft +
                (int) Math.min(0, mShadowDx - mShadowRadius));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1024776581 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1024776581;
        // ---------- Original Method ----------
        //return getCompoundPaddingLeft() - mPaddingLeft +
                //(int) Math.min(0, mShadowDx - mShadowRadius);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.227 -0400", hash_original_method = "BBBA34DDC8A574B01D58B3AC0235EEFE", hash_generated_method = "56400F2397531112DAD343D2E7AABDB6")
    @Override
    protected int getTopPaddingOffset() {
        int var0ED6224353BB97F3F21905FBACD93DCB_481544920 = ((int) Math.min(0, mShadowDy - mShadowRadius));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1557242360 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1557242360;
        // ---------- Original Method ----------
        //return (int) Math.min(0, mShadowDy - mShadowRadius);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.227 -0400", hash_original_method = "2F5480661817CC97DFDD529692B7CB6A", hash_generated_method = "CB88247A37EBCA6F9A224021CEF3B071")
    @Override
    protected int getBottomPaddingOffset() {
        int varB10121B4D3A3118F0C573D58A81C1C32_382960401 = ((int) Math.max(0, mShadowDy + mShadowRadius));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1890329320 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1890329320;
        // ---------- Original Method ----------
        //return (int) Math.max(0, mShadowDy + mShadowRadius);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.233 -0400", hash_original_method = "03B94E40D261DCBBD1910980153D8E7A", hash_generated_method = "FB4AF10F192833F2F24CFF0155AA71C9")
    @Override
    protected int getRightPaddingOffset() {
        int var513406E75DBEDB7AB1D4B061E88F3D83_1554540988 = (-(getCompoundPaddingRight() - mPaddingRight) +
                (int) Math.max(0, mShadowDx + mShadowRadius));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1780575977 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1780575977;
        // ---------- Original Method ----------
        //return -(getCompoundPaddingRight() - mPaddingRight) +
                //(int) Math.max(0, mShadowDx + mShadowRadius);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.234 -0400", hash_original_method = "CE928B829998126087759CE89BCD7C50", hash_generated_method = "E4948F869DC52C2B5D440D44D3C93FE3")
    @Override
    protected boolean verifyDrawable(Drawable who) {
        boolean verified;
        verified = super.verifyDrawable(who);
        addTaint(who.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2125320588 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2125320588;
        // ---------- Original Method ----------
        //final boolean verified = super.verifyDrawable(who);
        //if (!verified && mDrawables != null) {
            //return who == mDrawables.mDrawableLeft || who == mDrawables.mDrawableTop ||
                    //who == mDrawables.mDrawableRight || who == mDrawables.mDrawableBottom ||
                    //who == mDrawables.mDrawableStart || who == mDrawables.mDrawableEnd;
        //}
        //return verified;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.254 -0400", hash_original_method = "40478AC632904F83B590338EFFF77EC4", hash_generated_method = "D986EC85476D6044DCA7E50788DFA532")
    @Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        {
            {
                mDrawables.mDrawableLeft.jumpToCurrentState();
            } //End block
            {
                mDrawables.mDrawableTop.jumpToCurrentState();
            } //End block
            {
                mDrawables.mDrawableRight.jumpToCurrentState();
            } //End block
            {
                mDrawables.mDrawableBottom.jumpToCurrentState();
            } //End block
            {
                mDrawables.mDrawableStart.jumpToCurrentState();
            } //End block
            {
                mDrawables.mDrawableEnd.jumpToCurrentState();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.257 -0400", hash_original_method = "BFAA7AB246AB7FE030F8E5E06E7C4938", hash_generated_method = "E350DA1DD0549A4265C81F9F12B083FA")
    @Override
    public void invalidateDrawable(Drawable drawable) {
        {
            boolean var6429BFA2CE72B3A4B0873DE16CAD3D14_773219576 = (verifyDrawable(drawable));
            {
                Rect dirty;
                dirty = drawable.getBounds();
                int scrollX;
                scrollX = mScrollX;
                int scrollY;
                scrollY = mScrollY;
                TextView.Drawables drawables;
                drawables = mDrawables;
                {
                    {
                        int compoundPaddingTop;
                        compoundPaddingTop = getCompoundPaddingTop();
                        int compoundPaddingBottom;
                        compoundPaddingBottom = getCompoundPaddingBottom();
                        int vspace;
                        vspace = mBottom - mTop - compoundPaddingBottom - compoundPaddingTop;
                        scrollX += mPaddingLeft;
                        scrollY += compoundPaddingTop + (vspace - drawables.mDrawableHeightLeft) / 2;
                    } //End block
                    {
                        int compoundPaddingTop;
                        compoundPaddingTop = getCompoundPaddingTop();
                        int compoundPaddingBottom;
                        compoundPaddingBottom = getCompoundPaddingBottom();
                        int vspace;
                        vspace = mBottom - mTop - compoundPaddingBottom - compoundPaddingTop;
                        scrollX += (mRight - mLeft - mPaddingRight - drawables.mDrawableSizeRight);
                        scrollY += compoundPaddingTop + (vspace - drawables.mDrawableHeightRight) / 2;
                    } //End block
                    {
                        int compoundPaddingLeft;
                        compoundPaddingLeft = getCompoundPaddingLeft();
                        int compoundPaddingRight;
                        compoundPaddingRight = getCompoundPaddingRight();
                        int hspace;
                        hspace = mRight - mLeft - compoundPaddingRight - compoundPaddingLeft;
                        scrollX += compoundPaddingLeft + (hspace - drawables.mDrawableWidthTop) / 2;
                        scrollY += mPaddingTop;
                    } //End block
                    {
                        int compoundPaddingLeft;
                        compoundPaddingLeft = getCompoundPaddingLeft();
                        int compoundPaddingRight;
                        compoundPaddingRight = getCompoundPaddingRight();
                        int hspace;
                        hspace = mRight - mLeft - compoundPaddingRight - compoundPaddingLeft;
                        scrollX += compoundPaddingLeft + (hspace - drawables.mDrawableWidthBottom) / 2;
                        scrollY += (mBottom - mTop - mPaddingBottom - drawables.mDrawableSizeBottom);
                    } //End block
                } //End block
                invalidate(dirty.left + scrollX, dirty.top + scrollY,
                    dirty.right + scrollX, dirty.bottom + scrollY);
            } //End block
        } //End collapsed parenthetic
        addTaint(drawable.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.257 -0400", hash_original_method = "365B978F98464E672BAE2334EE130C56", hash_generated_method = "8F00AF019D1E1C3E5A0520E45DCCC687")
    @Override
    public int getResolvedLayoutDirection(Drawable who) {
        {
            Drawables drawables;
            drawables = mDrawables;
            {
                int var9F1D8BFC1663434C04073ED5C9ABAE03_1016949747 = (getResolvedLayoutDirection());
            } //End block
        } //End block
        int varC2F7741B418937D0E08C7C868777F70A_1397153292 = (super.getResolvedLayoutDirection(who));
        addTaint(who.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1805918677 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1805918677;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.276 -0400", hash_original_method = "361EEEB4229AF287B326C983EB9B20B0", hash_generated_method = "15EBDF49EF4995E3E7DB29AC38CC4D6C")
    @Override
    protected boolean onSetAlpha(int alpha) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varF9737FBB3FA84CB9364E87D929DD087B_1032901314 = (getBackground() == null);
            {
                mCurrentAlpha = alpha;
                Drawables dr;
                dr = mDrawables;
                {
                    dr.mDrawableLeft.mutate().setAlpha(alpha);
                    dr.mDrawableTop.mutate().setAlpha(alpha);
                    dr.mDrawableRight.mutate().setAlpha(alpha);
                    dr.mDrawableBottom.mutate().setAlpha(alpha);
                    dr.mDrawableStart.mutate().setAlpha(alpha);
                    dr.mDrawableEnd.mutate().setAlpha(alpha);
                } //End block
            } //End block
        } //End collapsed parenthetic
        mCurrentAlpha = 255;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1385736543 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1385736543;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.276 -0400", hash_original_method = "CB6193FD8EC60616857FED31421868C5", hash_generated_method = "3C91D86558E9426EED10B1ACE3BF67E6")
    public boolean isTextSelectable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1012833125 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1012833125;
        // ---------- Original Method ----------
        //return mTextIsSelectable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.277 -0400", hash_original_method = "F5356B5CDB0C54713C7C3659E2E49BDB", hash_generated_method = "9BDA14E19AC3B62652D1ECC211E963FD")
    public void setTextIsSelectable(boolean selectable) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.277 -0400", hash_original_method = "E327CCF4B590DA515951F33B48F8FD2D", hash_generated_method = "8400F2F63044BD91D87310036403B952")
    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int[] drawableState;
        {
            drawableState = super.onCreateDrawableState(extraSpace);
        } //End block
        {
            drawableState = super.onCreateDrawableState(extraSpace + 1);
            mergeDrawableStates(drawableState, MULTILINE_STATE_SET);
        } //End block
        {
            int length;
            length = drawableState.length;
            {
                int i;
                i = 0;
                {
                    {
                        int[] nonPressedState;
                        nonPressedState = new int[length - 1];
                        System.arraycopy(drawableState, 0, nonPressedState, 0, i);
                        System.arraycopy(drawableState, i + 1, nonPressedState, i, length - i - 1);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(extraSpace);
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1047769940 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1047769940;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.302 -0400", hash_original_method = "FA11BA597CA3990806012CD62CCA6F49", hash_generated_method = "2BAFB47964464ABD54AA5716F0B36868")
    @Override
    protected void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            ViewTreeObserver observer;
            observer = getViewTreeObserver();
            observer.removeOnPreDrawListener(this);
            mPreDrawState = PREDRAW_NOT_REGISTERED;
        } //End block
        restartMarqueeIfNeeded();
        super.onDraw(canvas);
        int compoundPaddingLeft;
        compoundPaddingLeft = getCompoundPaddingLeft();
        int compoundPaddingTop;
        compoundPaddingTop = getCompoundPaddingTop();
        int compoundPaddingRight;
        compoundPaddingRight = getCompoundPaddingRight();
        int compoundPaddingBottom;
        compoundPaddingBottom = getCompoundPaddingBottom();
        int scrollX;
        scrollX = mScrollX;
        int scrollY;
        scrollY = mScrollY;
        int right;
        right = mRight;
        int left;
        left = mLeft;
        int bottom;
        bottom = mBottom;
        int top;
        top = mTop;
        Drawables dr;
        dr = mDrawables;
        {
            int vspace;
            vspace = bottom - top - compoundPaddingBottom - compoundPaddingTop;
            int hspace;
            hspace = right - left - compoundPaddingRight - compoundPaddingLeft;
            {
                canvas.save();
                canvas.translate(scrollX + mPaddingLeft,
                                 scrollY + compoundPaddingTop +
                                 (vspace - dr.mDrawableHeightLeft) / 2);
                dr.mDrawableLeft.draw(canvas);
                canvas.restore();
            } //End block
            {
                canvas.save();
                canvas.translate(scrollX + right - left - mPaddingRight - dr.mDrawableSizeRight,
                         scrollY + compoundPaddingTop + (vspace - dr.mDrawableHeightRight) / 2);
                dr.mDrawableRight.draw(canvas);
                canvas.restore();
            } //End block
            {
                canvas.save();
                canvas.translate(scrollX + compoundPaddingLeft + (hspace - dr.mDrawableWidthTop) / 2,
                        scrollY + mPaddingTop);
                dr.mDrawableTop.draw(canvas);
                canvas.restore();
            } //End block
            {
                canvas.save();
                canvas.translate(scrollX + compoundPaddingLeft +
                        (hspace - dr.mDrawableWidthBottom) / 2,
                         scrollY + bottom - top - mPaddingBottom - dr.mDrawableSizeBottom);
                dr.mDrawableBottom.draw(canvas);
                canvas.restore();
            } //End block
        } //End block
        int color;
        color = mCurTextColor;
        {
            assumeLayout();
        } //End block
        Layout layout;
        layout = mLayout;
        int cursorcolor;
        cursorcolor = color;
        {
            boolean var316D35E2F5ECBA0973BB7AA3F3D5BB99_1556284959 = (mHint != null && mText.length() == 0);
            {
                {
                    color = mCurHintTextColor;
                } //End block
                layout = mHintLayout;
            } //End block
        } //End collapsed parenthetic
        mTextPaint.setColor(color);
        {
            mTextPaint.setAlpha((mCurrentAlpha * Color.alpha(color)) / 255);
        } //End block
        mTextPaint.drawableState = getDrawableState();
        canvas.save();
        int extendedPaddingTop;
        extendedPaddingTop = getExtendedPaddingTop();
        int extendedPaddingBottom;
        extendedPaddingBottom = getExtendedPaddingBottom();
        float clipLeft;
        clipLeft = compoundPaddingLeft + scrollX;
        float clipTop;
        clipTop = extendedPaddingTop + scrollY;
        float clipRight;
        clipRight = right - left - compoundPaddingRight + scrollX;
        float clipBottom;
        clipBottom = bottom - top - extendedPaddingBottom + scrollY;
        {
            clipLeft += Math.min(0, mShadowDx - mShadowRadius);
            clipRight += Math.max(0, mShadowDx + mShadowRadius);
            clipTop += Math.min(0, mShadowDy - mShadowRadius);
            clipBottom += Math.max(0, mShadowDy + mShadowRadius);
        } //End block
        canvas.clipRect(clipLeft, clipTop, clipRight, clipBottom);
        int voffsetText;
        voffsetText = 0;
        int voffsetCursor;
        voffsetCursor = 0;
        {
            {
                voffsetText = getVerticalOffset(false);
                voffsetCursor = getVerticalOffset(true);
            } //End block
            canvas.translate(compoundPaddingLeft, extendedPaddingTop + voffsetText);
        } //End block
        int layoutDirection;
        layoutDirection = getResolvedLayoutDirection();
        int absoluteGravity;
        absoluteGravity = Gravity.getAbsoluteGravity(mGravity, layoutDirection);
        {
            {
                boolean varECABE171DF753EC9B7649613B9CE32E8_2086478189 = (!mSingleLine && getLineCount() == 1 && canMarquee() &&
                    (absoluteGravity & Gravity.HORIZONTAL_GRAVITY_MASK) != Gravity.LEFT);
                {
                    canvas.translate(mLayout.getLineRight(0) - (mRight - mLeft -
                        getCompoundPaddingLeft() - getCompoundPaddingRight()), 0.0f);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var2C1AA9C80F2908423E5F4CFC350F7281_999125099 = (mMarquee != null && mMarquee.isRunning());
                {
                    canvas.translate(-mMarquee.mScroll, 0.0f);
                } //End block
            } //End collapsed parenthetic
        } //End block
        Path highlight;
        highlight = null;
        int selStart, selEnd;
        selStart = -1;
        selEnd = -1;
        boolean drawCursor;
        drawCursor = false;
        {
            boolean var6689D80642F8609001A87CC7FE23D763_1995834940 = (mMovement != null && (isFocused() || isPressed()));
            {
                selStart = getSelectionStart();
                selEnd = getSelectionEnd();
                {
                    mHighlightPath = new Path();
                    {
                        {
                            boolean varC70ECF1643A49D8E64E841F8740CC733_1064614693 = (isCursorVisible() &&
                            (SystemClock.uptimeMillis() - mShowCursor) % (2 * BLINK) < BLINK);
                            {
                                {
                                    mHighlightPath.reset();
                                    mLayout.getCursorPath(selStart, mHighlightPath, mText);
                                    updateCursorsPositions();
                                    mHighlightPathBogus = false;
                                } //End block
                                mHighlightPaint.setColor(cursorcolor);
                                {
                                    mHighlightPaint.setAlpha(
                                    (mCurrentAlpha * Color.alpha(cursorcolor)) / 255);
                                } //End block
                                mHighlightPaint.setStyle(Paint.Style.STROKE);
                                highlight = mHighlightPath;
                                drawCursor = mCursorCount > 0;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean varD2470F8649BF231BDB682780036CA3E1_1395831484 = (textCanBeSelected());
                        {
                            {
                                mHighlightPath.reset();
                                mLayout.getSelectionPath(selStart, selEnd, mHighlightPath);
                                mHighlightPathBogus = false;
                            } //End block
                            mHighlightPaint.setColor(mHighlightColor);
                            {
                                mHighlightPaint.setAlpha(
                                (mCurrentAlpha * Color.alpha(mHighlightColor)) / 255);
                            } //End block
                            mHighlightPaint.setStyle(Paint.Style.FILL);
                            highlight = mHighlightPath;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        InputMethodState ims;
        ims = mInputMethodState;
        int cursorOffsetVertical;
        cursorOffsetVertical = voffsetCursor - voffsetText;
        {
            InputMethodManager imm;
            imm = InputMethodManager.peekInstance();
            {
                {
                    boolean varCD832678EBF561BEF5C67C864ED57D5D_1585791510 = (imm.isActive(this));
                    {
                        boolean reported;
                        reported = false;
                        {
                            reported = reportExtractedText();
                        } //End block
                        {
                            int candStart;
                            candStart = -1;
                            int candEnd;
                            candEnd = -1;
                            {
                                Spannable sp;
                                sp = (Spannable)mText;
                                candStart = EditableInputConnection.getComposingSpanStart(sp);
                                candEnd = EditableInputConnection.getComposingSpanEnd(sp);
                            } //End block
                            imm.updateSelection(this, selStart, selEnd, candStart, candEnd);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varDFBBC9A1B31B7114329F69A82B5D3704_1710923243 = (imm.isWatchingCursor(this) && highlight != null);
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
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            mCorrectionHighlighter.draw(canvas, cursorOffsetVertical);
        } //End block
        {
            drawCursor(canvas, cursorOffsetVertical);
            highlight = null;
        } //End block
        layout.draw(canvas, highlight, mHighlightPaint, cursorOffsetVertical);
        {
            boolean var6C9C7A2601C4C103D29484E050BD6314_1116266218 = (mMarquee != null && mMarquee.shouldDrawGhost());
            {
                canvas.translate((int) mMarquee.getGhostOffset(), 0.0f);
                layout.draw(canvas, highlight, mHighlightPaint, cursorOffsetVertical);
            } //End block
        } //End collapsed parenthetic
        canvas.restore();
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.319 -0400", hash_original_method = "78F759649DF9DADE7AC797D0043ECB32", hash_generated_method = "D3E76B4B918A3C4421CFC2AA742067E2")
    private void updateCursorsPositions() {
        {
            mCursorCount = 0;
        } //End block
        int offset;
        offset = getSelectionStart();
        int line;
        line = mLayout.getLineForOffset(offset);
        int top;
        top = mLayout.getLineTop(line);
        int bottom;
        bottom = mLayout.getLineTop(line + 1);
        mCursorCount = mLayout.isLevelBoundary(offset) ? 2 : 1;
        int middle;
        middle = bottom;
        {
            middle = (top + bottom) >> 1;
        } //End block
        updateCursorPosition(0, top, middle, mLayout.getPrimaryHorizontal(offset));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.319 -0400", hash_original_method = "E19C5E504E793D85568DEA288EC3BB71", hash_generated_method = "C1A8B3E9A195F63283E74DE0304D1C4E")
    private void updateCursorPosition(int cursorIndex, int top, int bottom, float horizontal) {
        mCursorDrawable[cursorIndex] = mContext.getResources().getDrawable(mCursorDrawableRes);
        mTempRect = new Rect();
        mCursorDrawable[cursorIndex].getPadding(mTempRect);
        int width;
        width = mCursorDrawable[cursorIndex].getIntrinsicWidth();
        horizontal = Math.max(0.5f, horizontal - 0.5f);
        int left;
        left = (int) (horizontal) - mTempRect.left;
        mCursorDrawable[cursorIndex].setBounds(left, top - mTempRect.top, left + width,
                bottom + mTempRect.bottom);
        addTaint(top);
        addTaint(bottom);
        addTaint(horizontal);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.320 -0400", hash_original_method = "38A0E9FCBE0DF4E61FBA21D6958F939A", hash_generated_method = "F1BC44864FF4EBFC9F48CF1987C78BC0")
    private void drawCursor(Canvas canvas, int cursorOffsetVertical) {
        boolean translate;
        translate = cursorOffsetVertical != 0;
        canvas.translate(0, cursorOffsetVertical);
        {
            int i;
            i = 0;
            {
                mCursorDrawable[i].draw(canvas);
            } //End block
        } //End collapsed parenthetic
        canvas.translate(0, -cursorOffsetVertical);
        addTaint(canvas.getTaint());
        addTaint(cursorOffsetVertical);
        // ---------- Original Method ----------
        //final boolean translate = cursorOffsetVertical != 0;
        //if (translate) canvas.translate(0, cursorOffsetVertical);
        //for (int i = 0; i < mCursorCount; i++) {
            //mCursorDrawable[i].draw(canvas);
        //}
        //if (translate) canvas.translate(0, -cursorOffsetVertical);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.321 -0400", hash_original_method = "9AB167D6C4B117BDFB6C2B72A1D862B5", hash_generated_method = "89FB2E723195115CB0FF4492BFD69275")
    @Override
    public void getFocusedRect(Rect r) {
        {
            super.getFocusedRect(r);
        } //End block
        int selEnd;
        selEnd = getSelectionEnd();
        {
            super.getFocusedRect(r);
        } //End block
        int selStart;
        selStart = getSelectionStart();
        {
            int line;
            line = mLayout.getLineForOffset(selEnd);
            r.top = mLayout.getLineTop(line);
            r.bottom = mLayout.getLineBottom(line);
            r.left = (int) mLayout.getPrimaryHorizontal(selEnd) - 2;
            r.right = r.left + 4;
        } //End block
        {
            int lineStart;
            lineStart = mLayout.getLineForOffset(selStart);
            int lineEnd;
            lineEnd = mLayout.getLineForOffset(selEnd);
            r.top = mLayout.getLineTop(lineStart);
            r.bottom = mLayout.getLineBottom(lineEnd);
            {
                r.left = (int) mLayout.getPrimaryHorizontal(selStart);
                r.right = (int) mLayout.getPrimaryHorizontal(selEnd);
            } //End block
            {
                mHighlightPath = new Path();
                {
                    mHighlightPath.reset();
                    mLayout.getSelectionPath(selStart, selEnd, mHighlightPath);
                    mHighlightPathBogus = false;
                } //End block
                {
                    mHighlightPath.computeBounds(sTempRect, true);
                    r.left = (int)sTempRect.left-1;
                    r.right = (int)sTempRect.right+1;
                } //End block
            } //End block
        } //End block
        int paddingLeft;
        paddingLeft = getCompoundPaddingLeft();
        int paddingTop;
        paddingTop = getExtendedPaddingTop();
        {
            paddingTop += getVerticalOffset(false);
        } //End block
        r.offset(paddingLeft, paddingTop);
        addTaint(r.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.433 -0400", hash_original_method = "97BE8C8E19AAF13DDBB7397BA8716CD7", hash_generated_method = "F4EED5A8585737A9210E0FFC52305883")
    public int getLineCount() {
        {
            Object varD975483664E4A2ABD3BE6A7FE00BEAE4_210893829 = (mLayout.getLineCount());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_275697585 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_275697585;
        // ---------- Original Method ----------
        //return mLayout != null ? mLayout.getLineCount() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.433 -0400", hash_original_method = "C119BED798B9C2A141229B29A4C86BDD", hash_generated_method = "E9EC0A525BA6BBE03F673E854F59281F")
    public int getLineBounds(int line, Rect bounds) {
        {
            {
                bounds.set(0, 0, 0, 0);
            } //End block
        } //End block
        {
            int baseline;
            baseline = mLayout.getLineBounds(line, bounds);
            int voffset;
            voffset = getExtendedPaddingTop();
            {
                voffset += getVerticalOffset(true);
            } //End block
            {
                bounds.offset(getCompoundPaddingLeft(), voffset);
            } //End block
        } //End block
        addTaint(line);
        addTaint(bounds.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1059351917 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1059351917;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.434 -0400", hash_original_method = "3C56831CF91C4818C48A7DCC6043867F", hash_generated_method = "4782485C4008C6AF1B798B6A3A9B9CF4")
    @Override
    public int getBaseline() {
        {
            int varEC5F70FA49520212A319ACA653FC0209_1031361412 = (super.getBaseline());
        } //End block
        int voffset;
        voffset = 0;
        {
            voffset = getVerticalOffset(true);
        } //End block
        int varB40014DBFC3B8DB0A96D34443E0FBB7F_191979575 = (getExtendedPaddingTop() + voffset + mLayout.getLineBaseline(0));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1383861025 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1383861025;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.442 -0400", hash_original_method = "9B40D92CA2D66C315619C6CA13460A4B", hash_generated_method = "47BAEAAE87B41B564F64BC6B2E5A0EEA")
    @Override
    protected int getFadeTop(boolean offsetRequired) {
        int voffset;
        voffset = 0;
        {
            voffset = getVerticalOffset(true);
        } //End block
        voffset += getTopPaddingOffset();
        int var96B16999098121B80A3E9BC63992503B_744767295 = (getExtendedPaddingTop() + voffset);
        addTaint(offsetRequired);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_646089568 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_646089568;
        // ---------- Original Method ----------
        //if (mLayout == null) return 0;
        //int voffset = 0;
        //if ((mGravity & Gravity.VERTICAL_GRAVITY_MASK) != Gravity.TOP) {
            //voffset = getVerticalOffset(true);
        //}
        //if (offsetRequired) voffset += getTopPaddingOffset();
        //return getExtendedPaddingTop() + voffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.442 -0400", hash_original_method = "4B4E36AF8D516BA2309E720A4535DE33", hash_generated_method = "5036AFEEE481AADF66121CEA274067D7")
    @Override
    protected int getFadeHeight(boolean offsetRequired) {
        {
            Object var1822177AD24E1DAE2984AAF8E0B02DF5_2143875008 = (mLayout.getHeight());
        } //End flattened ternary
        addTaint(offsetRequired);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1358160796 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1358160796;
        // ---------- Original Method ----------
        //return mLayout != null ? mLayout.getHeight() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.443 -0400", hash_original_method = "D780B8C0D740C935BBFD0FE1FAA345B5", hash_generated_method = "0D085F513EFC17B841304AC313EC9EBF")
    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean isInSelectionMode;
            isInSelectionMode = mSelectionActionMode != null;
            {
                {
                    boolean var51947D54DEEA690F1B41A17DE6323711_171811641 = (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0);
                    {
                        KeyEvent.DispatcherState state;
                        state = getKeyDispatcherState();
                        {
                            state.startTracking(event, this);
                        } //End block
                    } //End block
                    {
                        boolean varA6D964A9D1A4D1D485BD8D60F2BFCDEE_1303754423 = (event.getAction() == KeyEvent.ACTION_UP);
                        {
                            KeyEvent.DispatcherState state;
                            state = getKeyDispatcherState();
                            {
                                state.handleUpEvent(event);
                            } //End block
                            {
                                boolean varBE09C907F92D135687297C67489D82A5_1239130674 = (event.isTracking() && !event.isCanceled());
                                {
                                    {
                                        stopSelectionActionMode();
                                    } //End block
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End block
        boolean var84A59BF21652B099F795A333EE25717D_824386205 = (super.onKeyPreIme(keyCode, event));
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1272627967 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1272627967;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.443 -0400", hash_original_method = "34FB4F2A2A6D04958B0CB574357346B4", hash_generated_method = "F24151810ECEA59A24D1440A6139CBC4")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int which;
        which = doKeyDown(keyCode, event, null);
        {
            boolean varF37828D47239888646D0D534C127ED8C_1060054393 = (super.onKeyDown(keyCode, event));
        } //End block
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_49446040 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_49446040;
        // ---------- Original Method ----------
        //int which = doKeyDown(keyCode, event, null);
        //if (which == 0) {
            //return super.onKeyDown(keyCode, event);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.448 -0400", hash_original_method = "29E1D0F837CE3120BC9F0CF834D8CD7B", hash_generated_method = "03C39C46157315719F316BA33AEB6763")
    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        KeyEvent down;
        down = KeyEvent.changeAction(event, KeyEvent.ACTION_DOWN);
        int which;
        which = doKeyDown(keyCode, down, event);
        {
            boolean varDC1E2957B5A61BDC225D3800F9D03961_1033486283 = (super.onKeyMultiple(keyCode, repeatCount, event));
        } //End block
        KeyEvent up;
        up = KeyEvent.changeAction(event, KeyEvent.ACTION_UP);
        {
            mInput.onKeyUp(this, (Editable)mText, keyCode, up);
            {
                mInput.onKeyDown(this, (Editable)mText, keyCode, down);
                mInput.onKeyUp(this, (Editable)mText, keyCode, up);
            } //End block
            hideErrorIfUnchanged();
        } //End block
        {
            mMovement.onKeyUp(this, (Spannable)mText, keyCode, up);
            {
                mMovement.onKeyDown(this, (Spannable)mText, keyCode, down);
                mMovement.onKeyUp(this, (Spannable)mText, keyCode, up);
            } //End block
        } //End block
        addTaint(keyCode);
        addTaint(repeatCount);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1706336421 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1706336421;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.449 -0400", hash_original_method = "F8A8C23B2901B68727EC4DCE05389523", hash_generated_method = "5369A2DB58618349F2DDE5C2B2B8D78B")
    private boolean shouldAdvanceFocusOnEnter() {
        {
            int variation;
            variation = mInputType & EditorInfo.TYPE_MASK_VARIATION;
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1000948163 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1000948163;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.450 -0400", hash_original_method = "3820039215BEB2B783682B0606CB8390", hash_generated_method = "349B33A06EF5E5E9780F490447341760")
    private boolean shouldAdvanceFocusOnTab() {
        {
            {
                int variation;
                variation = mInputType & EditorInfo.TYPE_MASK_VARIATION;
            } //End block
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_950902092 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_950902092;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.457 -0400", hash_original_method = "06C558A5D7DCBFD0B9ED82B9C331F1F3", hash_generated_method = "1F68FA2CD00CECF6F03A3CEF89419363")
    private int doKeyDown(int keyCode, KeyEvent event, KeyEvent otherEvent) {
        {
            boolean varC378F7D9F83769944CF2ACC662A4EAE3_323007904 = (!isEnabled());
        } //End collapsed parenthetic
        //Begin case KeyEvent.KEYCODE_ENTER 
        {
            boolean var6A2352E2C5239DCC8C3CFCEB22E8E32E_348356533 = (event.hasNoModifiers());
            {
                {
                    {
                        boolean var1D94CC9EA7F6DC2AEFBF8FBA8E934A5F_1440922244 = (mInputContentType.onEditorActionListener != null &&
                                mInputContentType.onEditorActionListener.onEditorAction(
                                this, EditorInfo.IME_NULL, event));
                        {
                            mInputContentType.enterDown = true;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var05FC5A78E345546917334D934F323222_1107673357 = ((event.getFlags() & KeyEvent.FLAG_EDITOR_ACTION) != 0
                            || shouldAdvanceFocusOnEnter());
                    {
                        {
                            boolean var272B07794F8FB9CA178BF9284513CEF1_2001468270 = (hasOnClickListeners());
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        //End case KeyEvent.KEYCODE_ENTER 
        //Begin case KeyEvent.KEYCODE_DPAD_CENTER 
        {
            boolean var6A2352E2C5239DCC8C3CFCEB22E8E32E_991912458 = (event.hasNoModifiers());
            {
                {
                    boolean varB57504F668DBD47828E53D1AA62D2476_2108267292 = (shouldAdvanceFocusOnEnter());
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        //End case KeyEvent.KEYCODE_DPAD_CENTER 
        //Begin case KeyEvent.KEYCODE_TAB 
        {
            boolean var41B4248114FD3FFF5603132EE2379F75_1984516217 = (event.hasNoModifiers() || event.hasModifiers(KeyEvent.META_SHIFT_ON));
            {
                {
                    boolean var4CB07B26821EBD1E83E544AE45714F5A_509200660 = (shouldAdvanceFocusOnTab());
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        //End case KeyEvent.KEYCODE_TAB 
        //Begin case KeyEvent.KEYCODE_BACK 
        {
            stopSelectionActionMode();
        } //End block
        //End case KeyEvent.KEYCODE_BACK 
        {
            resetErrorChangedFlag();
            boolean doDown;
            doDown = true;
            {
                try 
                {
                    beginBatchEdit();
                    boolean handled;
                    handled = mInput.onKeyOther(this, (Editable) mText, otherEvent);
                    hideErrorIfUnchanged();
                    doDown = false;
                } //End block
                catch (AbstractMethodError e)
                { }
                finally 
                {
                    endBatchEdit();
                } //End block
            } //End block
            {
                beginBatchEdit();
                boolean handled;
                handled = mInput.onKeyDown(this, (Editable) mText, keyCode, event);
                endBatchEdit();
                hideErrorIfUnchanged();
            } //End block
        } //End block
        {
            boolean doDown;
            doDown = true;
            {
                try 
                {
                    boolean handled;
                    handled = mMovement.onKeyOther(this, (Spannable) mText,
                            otherEvent);
                    doDown = false;
                } //End block
                catch (AbstractMethodError e)
                { }
            } //End block
            {
                {
                    boolean var899D769AE8C1CEA63FDF2F946CDD9B0C_2010059010 = (mMovement.onKeyDown(this, (Spannable)mText, keyCode, event));
                } //End collapsed parenthetic
            } //End block
        } //End block
        addTaint(keyCode);
        addTaint(event.getTaint());
        addTaint(otherEvent.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_782269334 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_782269334;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.458 -0400", hash_original_method = "7246AB9167FB26EEC2DE7F4C0B385BF5", hash_generated_method = "942D510B431E2EA8FDD86A5C3DFCBA19")
    public void resetErrorChangedFlag() {
        mErrorWasChanged = false;
        // ---------- Original Method ----------
        //mErrorWasChanged = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.466 -0400", hash_original_method = "0D0DD73869C4F453DDB81949A9BAE239", hash_generated_method = "3E2A8FC9925589DC311AEF9DD7F3D897")
    public void hideErrorIfUnchanged() {
        {
            setError(null, null);
        } //End block
        // ---------- Original Method ----------
        //if (mError != null && !mErrorWasChanged) {
            //setError(null, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.469 -0400", hash_original_method = "5424E0BE647EA73439DA25EAE2FC3B50", hash_generated_method = "468012525EC726698707A08B3F63E291")
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varC378F7D9F83769944CF2ACC662A4EAE3_1536268692 = (!isEnabled());
            {
                boolean var22F2FED66C108E4B3C1571CD2DEF9BD7_178964474 = (super.onKeyUp(keyCode, event));
            } //End block
        } //End collapsed parenthetic
        //Begin case KeyEvent.KEYCODE_DPAD_CENTER 
        {
            boolean var6A2352E2C5239DCC8C3CFCEB22E8E32E_1072113863 = (event.hasNoModifiers());
            {
                {
                    boolean var210C7F5CA56C3EC36E879FBFEDD09928_581006703 = (!hasOnClickListeners());
                    {
                        {
                            boolean varE74AE2A246DD26B137F541368B4BE791_238881028 = (mMovement != null && mText instanceof Editable
                                && mLayout != null && onCheckIsTextEditor());
                            {
                                InputMethodManager imm;
                                imm = InputMethodManager.peekInstance();
                                viewClicked(imm);
                                {
                                    imm.showSoftInput(this, 0);
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        //End case KeyEvent.KEYCODE_DPAD_CENTER 
        //Begin case KeyEvent.KEYCODE_DPAD_CENTER 
        boolean varEDD771EBF66425AD21882AB08CD0EE48_1320653203 = (super.onKeyUp(keyCode, event));
        //End case KeyEvent.KEYCODE_DPAD_CENTER 
        //Begin case KeyEvent.KEYCODE_ENTER 
        {
            boolean var6A2352E2C5239DCC8C3CFCEB22E8E32E_214471710 = (event.hasNoModifiers());
            {
                {
                    mInputContentType.enterDown = false;
                    {
                        boolean varFB4D8364BD486E8AC15C78086C055D0E_1805450207 = (mInputContentType.onEditorActionListener.onEditorAction(
                                this, EditorInfo.IME_NULL, event));
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var05FC5A78E345546917334D934F323222_23175581 = ((event.getFlags() & KeyEvent.FLAG_EDITOR_ACTION) != 0
                            || shouldAdvanceFocusOnEnter());
                    {
                        {
                            boolean varEDA239B0EF60ED2C8B069E42FB575E6D_1053357978 = (!hasOnClickListeners());
                            {
                                View v;
                                v = focusSearch(FOCUS_DOWN);
                                {
                                    {
                                        boolean varB999DF15E9AF0E3270EE4B72A3F644C2_1560065569 = (!v.requestFocus(FOCUS_DOWN));
                                        {
                                            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                                            "focus search returned a view " +
                                            "that wasn't able to take focus!");
                                        } //End block
                                    } //End collapsed parenthetic
                                    super.onKeyUp(keyCode, event);
                                } //End block
                                {
                                    boolean var28FD9F71D61E7F2DAF140411AD18D69B_2059153537 = ((event.getFlags()
                                    & KeyEvent.FLAG_EDITOR_ACTION) != 0);
                                    {
                                        InputMethodManager imm;
                                        imm = InputMethodManager.peekInstance();
                                        {
                                            boolean var18AFA631B94FB215076105938165749C_1390458140 = (imm != null && imm.isActive(this));
                                            {
                                                imm.hideSoftInputFromWindow(getWindowToken(), 0);
                                            } //End block
                                        } //End collapsed parenthetic
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                boolean var22F2FED66C108E4B3C1571CD2DEF9BD7_1434012841 = (super.onKeyUp(keyCode, event));
            } //End block
        } //End collapsed parenthetic
        //End case KeyEvent.KEYCODE_ENTER 
        {
            boolean var952AD4616936F2C47880365DAADE02E9_1261106055 = (mInput.onKeyUp(this, (Editable) mText, keyCode, event));
        } //End collapsed parenthetic
        {
            boolean varDA972FE6CE2955659F74CF0FCCBDD027_1140752667 = (mMovement.onKeyUp(this, (Spannable) mText, keyCode, event));
        } //End collapsed parenthetic
        boolean varEDD771EBF66425AD21882AB08CD0EE48_202814201 = (super.onKeyUp(keyCode, event));
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2026229912 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2026229912;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.470 -0400", hash_original_method = "71F7C8422E0B6AB59261F7E112139F7A", hash_generated_method = "FC41F675F057409F00F80B9AD5B99B49")
    @Override
    public boolean onCheckIsTextEditor() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1853107192 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1853107192;
        // ---------- Original Method ----------
        //return mInputType != EditorInfo.TYPE_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.479 -0400", hash_original_method = "B65AC544FAB392A4E417298C2021FD9E", hash_generated_method = "26B03E41E3EDE8A27AAAD224B4588369")
    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        InputConnection varB4EAC82CA7396A68D541C85D26508E83_2035708977 = null; //Variable for return #1
        InputConnection varB4EAC82CA7396A68D541C85D26508E83_1633267739 = null; //Variable for return #2
        {
            boolean var14E748864EBD1D56528D6630F011C9F4_1462367803 = (onCheckIsTextEditor() && isEnabled());
            {
                {
                    mInputMethodState = new InputMethodState();
                } //End block
                outAttrs.inputType = mInputType;
                {
                    outAttrs.imeOptions = mInputContentType.imeOptions;
                    outAttrs.privateImeOptions = mInputContentType.privateImeOptions;
                    outAttrs.actionLabel = mInputContentType.imeActionLabel;
                    outAttrs.actionId = mInputContentType.imeActionId;
                    outAttrs.extras = mInputContentType.extras;
                } //End block
                {
                    outAttrs.imeOptions = EditorInfo.IME_NULL;
                } //End block
                {
                    boolean var4A83C13B10866AEA8D3AB0257DD13346_1525867927 = (focusSearch(FOCUS_DOWN) != null);
                    {
                        outAttrs.imeOptions |= EditorInfo.IME_FLAG_NAVIGATE_NEXT;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varD336D5944BC7007368BBB4D990F0F8EA_668406604 = (focusSearch(FOCUS_UP) != null);
                    {
                        outAttrs.imeOptions |= EditorInfo.IME_FLAG_NAVIGATE_PREVIOUS;
                    } //End block
                } //End collapsed parenthetic
                {
                    {
                        outAttrs.imeOptions |= EditorInfo.IME_ACTION_NEXT;
                    } //End block
                    {
                        outAttrs.imeOptions |= EditorInfo.IME_ACTION_DONE;
                    } //End block
                    {
                        boolean var46380488EEE32CF6F78CFB4D43E28058_1359754194 = (!shouldAdvanceFocusOnEnter());
                        {
                            outAttrs.imeOptions |= EditorInfo.IME_FLAG_NO_ENTER_ACTION;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var6CF4D9D9DC3252829459B4AC99D1E1CE_296771902 = (isMultilineInputType(outAttrs.inputType));
                    {
                        outAttrs.imeOptions |= EditorInfo.IME_FLAG_NO_ENTER_ACTION;
                    } //End block
                } //End collapsed parenthetic
                outAttrs.hintText = mHint;
                {
                    InputConnection ic;
                    ic = new EditableInputConnection(this);
                    outAttrs.initialSelStart = getSelectionStart();
                    outAttrs.initialSelEnd = getSelectionEnd();
                    outAttrs.initialCapsMode = ic.getCursorCapsMode(mInputType);
                    varB4EAC82CA7396A68D541C85D26508E83_2035708977 = ic;
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1633267739 = null;
        addTaint(outAttrs.getTaint());
        InputConnection varA7E53CE21691AB073D9660D615818899_1821783471; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1821783471 = varB4EAC82CA7396A68D541C85D26508E83_2035708977;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1821783471 = varB4EAC82CA7396A68D541C85D26508E83_1633267739;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1821783471.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1821783471;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.482 -0400", hash_original_method = "99984EBDDEABE6A84A830C32C2411508", hash_generated_method = "165B1E638F49698D777BB872F432C934")
    public boolean extractText(ExtractedTextRequest request,
            ExtractedText outText) {
        boolean varED261EE6A1DA9340DC710F511F735890_64946547 = (extractTextInternal(request, EXTRACT_UNKNOWN, EXTRACT_UNKNOWN,
                EXTRACT_UNKNOWN, outText));
        addTaint(request.getTaint());
        addTaint(outText.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_717865521 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_717865521;
        // ---------- Original Method ----------
        //return extractTextInternal(request, EXTRACT_UNKNOWN, EXTRACT_UNKNOWN,
                //EXTRACT_UNKNOWN, outText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.492 -0400", hash_original_method = "D5583180449515B28719DEEF8D226179", hash_generated_method = "08EAAE4959EFC77010D10AD0100B0778")
     boolean extractTextInternal(ExtractedTextRequest request,
            int partialStartOffset, int partialEndOffset, int delta,
            ExtractedText outText) {
        CharSequence content;
        content = mText;
        {
            {
                int N;
                N = content.length();
                {
                    outText.partialStartOffset = outText.partialEndOffset = -1;
                    partialStartOffset = 0;
                    partialEndOffset = N;
                } //End block
                {
                    partialEndOffset += delta;
                    {
                        Spanned spanned;
                        spanned = (Spanned)content;
                        Object[] spans;
                        spans = spanned.getSpans(partialStartOffset,
                                partialEndOffset, ParcelableSpan.class);
                        int i;
                        i = spans.length;
                        {
                            int j;
                            j = spanned.getSpanStart(spans[i]);
                            partialStartOffset = j;
                            j = spanned.getSpanEnd(spans[i]);
                            partialEndOffset = j;
                        } //End block
                    } //End block
                    outText.partialStartOffset = partialStartOffset;
                    outText.partialEndOffset = partialEndOffset - delta;
                    {
                        partialStartOffset = N;
                    } //End block
                    {
                        partialStartOffset = 0;
                    } //End block
                    {
                        partialEndOffset = N;
                    } //End block
                    {
                        partialEndOffset = 0;
                    } //End block
                } //End block
                {
                    outText.text = content.subSequence(partialStartOffset,
                            partialEndOffset);
                } //End block
                {
                    outText.text = TextUtils.substring(content, partialStartOffset,
                            partialEndOffset);
                } //End block
            } //End block
            {
                outText.partialStartOffset = 0;
                outText.partialEndOffset = 0;
                outText.text = "";
            } //End block
            outText.flags = 0;
            {
                boolean varA35D3A020D07691CB25122C024188410_317018471 = (MetaKeyKeyListener.getMetaState(mText, MetaKeyKeyListener.META_SELECTING) != 0);
                {
                    outText.flags |= ExtractedText.FLAG_SELECTING;
                } //End block
            } //End collapsed parenthetic
            {
                outText.flags |= ExtractedText.FLAG_SINGLE_LINE;
            } //End block
            outText.startOffset = 0;
            outText.selectionStart = getSelectionStart();
            outText.selectionEnd = getSelectionEnd();
        } //End block
        addTaint(request.getTaint());
        addTaint(partialStartOffset);
        addTaint(partialEndOffset);
        addTaint(delta);
        addTaint(outText.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_362917784 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_362917784;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.516 -0400", hash_original_method = "E0B2F563BD380D089394FF3F6A004FAB", hash_generated_method = "C61E1ED57C15F94F064F59DC6F96F5CF")
     boolean reportExtractedText() {
        InputMethodState ims;
        ims = mInputMethodState;
        {
            boolean contentChanged;
            contentChanged = ims.mContentChanged;
            {
                ims.mContentChanged = false;
                ims.mSelectionModeChanged = false;
                ExtractedTextRequest req;
                req = mInputMethodState.mExtracting;
                {
                    InputMethodManager imm;
                    imm = InputMethodManager.peekInstance();
                    {
                        {
                            ims.mChangedStart = EXTRACT_NOTHING;
                        } //End block
                        {
                            boolean varF32A83F45BD97D2740B78BFB41050619_196772702 = (extractTextInternal(req, ims.mChangedStart, ims.mChangedEnd,
                                ims.mChangedDelta, ims.mTmpExtracted));
                            {
                                imm.updateExtractedText(this, req.token,
                                    mInputMethodState.mTmpExtracted);
                                ims.mChangedStart = EXTRACT_UNKNOWN;
                                ims.mChangedEnd = EXTRACT_UNKNOWN;
                                ims.mChangedDelta = 0;
                                ims.mContentChanged = false;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End block
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_102890156 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_102890156;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        static void removeParcelableSpans(Spannable spannable, int start, int end) {
        Object[] spans = spannable.getSpans(start, end, ParcelableSpan.class);
        int i = spans.length;
        while (i > 0) {
            i--;
            spannable.removeSpan(spans[i]);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.518 -0400", hash_original_method = "BCA6F941081EC35E5D75ECC5825A5773", hash_generated_method = "D53615EC9D66C75CDFC541619DBE42F9")
    public void setExtractedText(ExtractedText text) {
        Editable content;
        content = getEditableText();
        {
            {
                setText(text.text, TextView.BufferType.EDITABLE);
            } //End block
            {
                removeParcelableSpans(content, 0, content.length());
                content.replace(0, content.length(), text.text);
            } //End block
            {
                int N;
                N = content.length();
                int start;
                start = text.partialStartOffset;
                start = N;
                int end;
                end = text.partialEndOffset;
                end = N;
                removeParcelableSpans(content, start, end);
                content.replace(start, end, text.text);
            } //End block
        } //End block
        Spannable sp;
        sp = (Spannable)getText();
        int N;
        N = sp.length();
        int start;
        start = text.selectionStart;
        start = 0;
        start = N;
        int end;
        end = text.selectionEnd;
        end = 0;
        end = N;
        Selection.setSelection(sp, start, end);
        {
            MetaKeyKeyListener.startSelecting(this, sp);
        } //End block
        {
            MetaKeyKeyListener.stopSelecting(this, sp);
        } //End block
        addTaint(text.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.531 -0400", hash_original_method = "7277A5A8CCC47DEA1B4CD7EF17ABC767", hash_generated_method = "001BA83404B601B50C360F21753C280D")
    public void setExtracting(ExtractedTextRequest req) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.532 -0400", hash_original_method = "00B2156ECAED706F16E8F8EE554C74A0", hash_generated_method = "3BEC66028E7D4A026DFA204DCCC868C4")
    public void onCommitCompletion(CompletionInfo text) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(text.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.532 -0400", hash_original_method = "F0F3377304175B47C81480C4E8ACCA98", hash_generated_method = "6E98934F145CEAE563A6ADFAF440E386")
    public void onCommitCorrection(CorrectionInfo info) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mCorrectionHighlighter = new CorrectionHighlighter();
        } //End block
        {
            mCorrectionHighlighter.invalidate(false);
        } //End block
        mCorrectionHighlighter.highlight(info);
        addTaint(info.getTaint());
        // ---------- Original Method ----------
        //if (mCorrectionHighlighter == null) {
            //mCorrectionHighlighter = new CorrectionHighlighter();
        //} else {
            //mCorrectionHighlighter.invalidate(false);
        //}
        //mCorrectionHighlighter.highlight(info);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.533 -0400", hash_original_method = "7E84F411EBAFCA8676D2B5471CC899F7", hash_generated_method = "C6ED258C6943B5864279549D8C2B5EDF")
    public void beginBatchEdit() {
        mInBatchEditControllers = true;
        InputMethodState ims;
        ims = mInputMethodState;
        {
            int nesting;
            nesting = ++ims.mBatchEditNesting;
            {
                ims.mCursorChanged = false;
                ims.mChangedDelta = 0;
                {
                    ims.mChangedStart = 0;
                    ims.mChangedEnd = mText.length();
                } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.533 -0400", hash_original_method = "53E9CEBDC3778C58F6F63CD77BA92C78", hash_generated_method = "77B017871EE5930E49E23C9847FD088B")
    public void endBatchEdit() {
        mInBatchEditControllers = false;
        InputMethodState ims;
        ims = mInputMethodState;
        {
            int nesting;
            nesting = --ims.mBatchEditNesting;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.534 -0400", hash_original_method = "49FC9F53534FDBC4416EED2F953235D5", hash_generated_method = "A4C75BEA5E2325357E5E68918C55A6E4")
     void ensureEndedBatchEdit() {
        InputMethodState ims;
        ims = mInputMethodState;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.534 -0400", hash_original_method = "5C56AEFFFAF99A5A2B83332AB2B67F77", hash_generated_method = "C7FDB63B58D41035DAC0F3FC01E908BE")
     void finishBatchEdit(final InputMethodState ims) {
        onEndBatchEdit();
        {
            updateAfterEdit();
            reportExtractedText();
        } //End block
        {
            invalidateCursor();
        } //End block
        addTaint(ims.getTaint());
        // ---------- Original Method ----------
        //onEndBatchEdit();
        //if (ims.mContentChanged || ims.mSelectionModeChanged) {
            //updateAfterEdit();
            //reportExtractedText();
        //} else if (ims.mCursorChanged) {
            //invalidateCursor();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.534 -0400", hash_original_method = "208D05A3FD324C57DA7FED31CDB936F2", hash_generated_method = "7C66F10DE264EA448BBD871EBD45C2E6")
     void updateAfterEdit() {
        invalidate();
        int curs;
        curs = getSelectionStart();
        {
            registerForPreDraw();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.544 -0400", hash_original_method = "77FDC1BC2641DD2E3C25361410AF5DB0", hash_generated_method = "BC5277DD7D56968D2F4723F142BD5C12")
    public void onBeginBatchEdit() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.544 -0400", hash_original_method = "52249F36F9A17EF1D72281B7699502C1", hash_generated_method = "47AA9BDFFBC119BCE27C341493B00781")
    public void onEndBatchEdit() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.546 -0400", hash_original_method = "4EBA5E538796A46420814B4C84FDA4F7", hash_generated_method = "4573F7118C1A28507FDF5B33BC1BEBFC")
    public boolean onPrivateIMECommand(String action, Bundle data) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(action.getTaint());
        addTaint(data.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_941757892 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_941757892;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.553 -0400", hash_original_method = "4BBE7444811911981578CD1FC44D7898", hash_generated_method = "C2DFA03E13DDE7509D862426BF7710F7")
    private void nullLayouts() {
        {
            mSavedLayout = (BoringLayout) mLayout;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.553 -0400", hash_original_method = "DE76D8533357DD76552FFACD362B9B5D", hash_generated_method = "28C029B52CAF1F9F7C163FF4922C6280")
    private void assumeLayout() {
        int width;
        width = mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight();
        {
            width = 0;
        } //End block
        int physicalWidth;
        physicalWidth = width;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.554 -0400", hash_original_method = "FF379A6CAE0485B60E59F45E1B8A7246", hash_generated_method = "8899D16BAE890A74AD65848A0AADAC0E")
    @Override
    protected void resetResolvedLayoutDirection() {
        super.resetResolvedLayoutDirection();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.564 -0400", hash_original_method = "C784F6D37EB77044D77D743FABD50125", hash_generated_method = "3F969E08A403FAC071288D8D94DDA78B")
    private Layout.Alignment getLayoutAlignment() {
        Layout.Alignment varB4EAC82CA7396A68D541C85D26508E83_245833689 = null; //Variable for return #1
        {
            Layout.Alignment alignment;
            TextAlign textAlign;
            textAlign = mTextAlign;
            //Begin case INHERIT GRAVITY 
            //Begin case Gravity.START 
            alignment = Layout.Alignment.ALIGN_NORMAL;
            //End case Gravity.START 
            //Begin case Gravity.END 
            alignment = Layout.Alignment.ALIGN_OPPOSITE;
            //End case Gravity.END 
            //Begin case Gravity.LEFT 
            alignment = Layout.Alignment.ALIGN_LEFT;
            //End case Gravity.LEFT 
            //Begin case Gravity.RIGHT 
            alignment = Layout.Alignment.ALIGN_RIGHT;
            //End case Gravity.RIGHT 
            //Begin case Gravity.CENTER_HORIZONTAL 
            alignment = Layout.Alignment.ALIGN_CENTER;
            //End case Gravity.CENTER_HORIZONTAL 
            //Begin case default 
            alignment = Layout.Alignment.ALIGN_NORMAL;
            //End case default 
            //End case INHERIT GRAVITY 
            //Begin case TEXT_START 
            alignment = Layout.Alignment.ALIGN_NORMAL;
            //End case TEXT_START 
            //Begin case TEXT_END 
            alignment = Layout.Alignment.ALIGN_OPPOSITE;
            //End case TEXT_END 
            //Begin case CENTER 
            alignment = Layout.Alignment.ALIGN_CENTER;
            //End case CENTER 
            //Begin case VIEW_START 
            alignment = (getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL) ?
                            Layout.Alignment.ALIGN_RIGHT : Layout.Alignment.ALIGN_LEFT;
            //End case VIEW_START 
            //Begin case VIEW_END 
            alignment = (getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL) ?
                            Layout.Alignment.ALIGN_LEFT : Layout.Alignment.ALIGN_RIGHT;
            //End case VIEW_END 
            //Begin case default 
            alignment = Layout.Alignment.ALIGN_NORMAL;
            //End case default 
            mLayoutAlignment = alignment;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_245833689 = mLayoutAlignment;
        varB4EAC82CA7396A68D541C85D26508E83_245833689.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_245833689;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.588 -0400", hash_original_method = "A69555D5DBD727E4B4531FE7AB9727A4", hash_generated_method = "0BEF3F7429FC1B8D440C985C5F597E62")
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
        } //End block
        {
            hintWidth = 0;
        } //End block
        Layout.Alignment alignment;
        alignment = getLayoutAlignment();
        boolean shouldEllipsize;
        shouldEllipsize = mEllipsize != null && mInput == null;
        boolean switchEllipsize;
        switchEllipsize = mEllipsize == TruncateAt.MARQUEE &&
                mMarqueeFadeMode != MARQUEE_FADE_NORMAL;
        TruncateAt effectiveEllipsize;
        effectiveEllipsize = mEllipsize;
        {
            effectiveEllipsize = TruncateAt.END_SMALL;
        } //End block
        {
            resolveTextDirection();
        } //End block
        mLayout = makeSingleLayout(wantWidth, boring, ellipsisWidth, alignment, shouldEllipsize,
                effectiveEllipsize, effectiveEllipsize == mEllipsize);
        {
            TruncateAt oppositeEllipsize;
            oppositeEllipsize = TruncateAt.END;
            oppositeEllipsize = TruncateAt.MARQUEE;
            mSavedMarqueeModeLayout = makeSingleLayout(wantWidth, boring, ellipsisWidth, alignment,
                    shouldEllipsize, oppositeEllipsize, effectiveEllipsize != mEllipsize);
        } //End block
        shouldEllipsize = mEllipsize != null;
        mHintLayout = null;
        {
            hintWidth = wantWidth;
            {
                hintBoring = BoringLayout.isBoring(mHint, mTextPaint, mTextDir,
                                                   mHintBoring);
                {
                    mHintBoring = hintBoring;
                } //End block
            } //End block
            {
                {
                    {
                        mHintLayout = mSavedHintLayout.
                                replaceOrMake(mHint, mTextPaint,
                                hintWidth, alignment, mSpacingMult, mSpacingAdd,
                                hintBoring, mIncludePad);
                    } //End block
                    {
                        mHintLayout = BoringLayout.make(mHint, mTextPaint,
                                hintWidth, alignment, mSpacingMult, mSpacingAdd,
                                hintBoring, mIncludePad);
                    } //End block
                    mSavedHintLayout = (BoringLayout) mHintLayout;
                } //End block
                {
                    {
                        mHintLayout = mSavedHintLayout.
                                replaceOrMake(mHint, mTextPaint,
                                hintWidth, alignment, mSpacingMult, mSpacingAdd,
                                hintBoring, mIncludePad, mEllipsize,
                                ellipsisWidth);
                    } //End block
                    {
                        mHintLayout = BoringLayout.make(mHint, mTextPaint,
                                hintWidth, alignment, mSpacingMult, mSpacingAdd,
                                hintBoring, mIncludePad, mEllipsize,
                                ellipsisWidth);
                    } //End block
                } //End block
                {
                    mHintLayout = new StaticLayout(mHint,
                                0, mHint.length(),
                                mTextPaint, hintWidth, alignment, mTextDir, mSpacingMult,
                                mSpacingAdd, mIncludePad, mEllipsize,
                                ellipsisWidth, mMaxMode == LINES ? mMaximum : Integer.MAX_VALUE);
                } //End block
                {
                    mHintLayout = new StaticLayout(mHint, mTextPaint,
                            hintWidth, alignment, mTextDir, mSpacingMult, mSpacingAdd,
                            mIncludePad);
                } //End block
            } //End block
            {
                mHintLayout = new StaticLayout(mHint,
                            0, mHint.length(),
                            mTextPaint, hintWidth, alignment, mTextDir, mSpacingMult,
                            mSpacingAdd, mIncludePad, mEllipsize,
                            ellipsisWidth, mMaxMode == LINES ? mMaximum : Integer.MAX_VALUE);
            } //End block
            {
                mHintLayout = new StaticLayout(mHint, mTextPaint,
                        hintWidth, alignment, mTextDir, mSpacingMult, mSpacingAdd,
                        mIncludePad);
            } //End block
        } //End block
        {
            registerForPreDraw();
        } //End block
        {
            {
                boolean var74FA680CFF3550946DD695F927344B4C_630891750 = (!compressText(ellipsisWidth));
                {
                    int height;
                    height = mLayoutParams.height;
                    {
                        startMarquee();
                    } //End block
                    {
                        mRestartMarquee = true;
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        prepareCursorControllers();
        addTaint(bringIntoView);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.601 -0400", hash_original_method = "919E80CF27514D43AA0D66AD56F3C47B", hash_generated_method = "A515F72385B42926F023E7D3614922FE")
    private Layout makeSingleLayout(int wantWidth, BoringLayout.Metrics boring, int ellipsisWidth,
            Layout.Alignment alignment, boolean shouldEllipsize, TruncateAt effectiveEllipsize,
            boolean useSaved) {
        Layout varB4EAC82CA7396A68D541C85D26508E83_2021452071 = null; //Variable for return #1
        Layout result;
        result = null;
        {
            result = new DynamicLayout(mText, mTransformed, mTextPaint, wantWidth,
                    alignment, mTextDir, mSpacingMult,
                    mSpacingAdd, mIncludePad, mInput == null ? effectiveEllipsize : null,
                            ellipsisWidth);
        } //End block
        {
            {
                boring = BoringLayout.isBoring(mTransformed, mTextPaint, mTextDir, mBoring);
                {
                    mBoring = boring;
                } //End block
            } //End block
            {
                {
                    {
                        result = mSavedLayout.replaceOrMake(mTransformed, mTextPaint,
                                wantWidth, alignment, mSpacingMult, mSpacingAdd,
                                boring, mIncludePad);
                    } //End block
                    {
                        result = BoringLayout.make(mTransformed, mTextPaint,
                                wantWidth, alignment, mSpacingMult, mSpacingAdd,
                                boring, mIncludePad);
                    } //End block
                    {
                        mSavedLayout = (BoringLayout) result;
                    } //End block
                } //End block
                {
                    {
                        result = mSavedLayout.replaceOrMake(mTransformed, mTextPaint,
                                wantWidth, alignment, mSpacingMult, mSpacingAdd,
                                boring, mIncludePad, effectiveEllipsize,
                                ellipsisWidth);
                    } //End block
                    {
                        result = BoringLayout.make(mTransformed, mTextPaint,
                                wantWidth, alignment, mSpacingMult, mSpacingAdd,
                                boring, mIncludePad, effectiveEllipsize,
                                ellipsisWidth);
                    } //End block
                } //End block
                {
                    result = new StaticLayout(mTransformed,
                            0, mTransformed.length(),
                            mTextPaint, wantWidth, alignment, mTextDir, mSpacingMult,
                            mSpacingAdd, mIncludePad, effectiveEllipsize,
                            ellipsisWidth, mMaxMode == LINES ? mMaximum : Integer.MAX_VALUE);
                } //End block
                {
                    result = new StaticLayout(mTransformed, mTextPaint,
                            wantWidth, alignment, mTextDir, mSpacingMult, mSpacingAdd,
                            mIncludePad);
                } //End block
            } //End block
            {
                result = new StaticLayout(mTransformed,
                        0, mTransformed.length(),
                        mTextPaint, wantWidth, alignment, mTextDir, mSpacingMult,
                        mSpacingAdd, mIncludePad, effectiveEllipsize,
                        ellipsisWidth, mMaxMode == LINES ? mMaximum : Integer.MAX_VALUE);
            } //End block
            {
                result = new StaticLayout(mTransformed, mTextPaint,
                        wantWidth, alignment, mTextDir, mSpacingMult, mSpacingAdd,
                        mIncludePad);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2021452071 = result;
        addTaint(wantWidth);
        addTaint(ellipsisWidth);
        addTaint(alignment.getTaint());
        addTaint(shouldEllipsize);
        addTaint(effectiveEllipsize.getTaint());
        addTaint(useSaved);
        varB4EAC82CA7396A68D541C85D26508E83_2021452071.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2021452071;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.611 -0400", hash_original_method = "F38DBB61FA92C8376A0BF0DADC8F1411", hash_generated_method = "2D134E6EED19A4A24BDCEC865656289F")
    private boolean compressText(float width) {
        {
            boolean varBDA84146B1D9E3F7F12351B38C986FB8_2143478679 = (isHardwareAccelerated());
        } //End collapsed parenthetic
        {
            boolean var743F2FC0D45BA571C6484FE1669492A0_2101195488 = (width > 0.0f && mLayout != null && getLineCount() == 1 && !mUserSetTextScaleX &&
                mTextPaint.getTextScaleX() == 1.0f);
            {
                float textWidth;
                textWidth = mLayout.getLineWidth(0);
                float overflow;
                overflow = (textWidth + 1.0f - width) / width;
                {
                    mTextPaint.setTextScaleX(1.0f - overflow - 0.005f);
                    post(new Runnable() {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.607 -0400", hash_original_method = "13996B392673F4526875359F0F526DB3", hash_generated_method = "221C03470D8DDA191DC873FAC4B9A060")
                        public void run() {
                            requestLayout();
                            // ---------- Original Method ----------
                            //requestLayout();
                        }
});
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(width);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_597347513 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_597347513;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.618 -0400", hash_original_method = "6C6FEB869E07EC14B89A3785CB4B2378", hash_generated_method = "BDAA1A5309424E69B253253E093AC007")
    public void setIncludeFontPadding(boolean includepad) {
        {
            mIncludePad = includepad;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.621 -0400", hash_original_method = "CC856997CB919A81C5DE847B897CC56B", hash_generated_method = "C94F0B964FC3F4AD2A4024D9B8D58044")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int widthMode;
        widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode;
        heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize;
        widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize;
        heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int width;
        int height;
        BoringLayout.Metrics boring;
        boring = UNKNOWN_BORING;
        BoringLayout.Metrics hintBoring;
        hintBoring = UNKNOWN_BORING;
        {
            resolveTextDirection();
        } //End block
        int des;
        des = -1;
        boolean fromexisting;
        fromexisting = false;
        {
            width = widthSize;
        } //End block
        {
            {
                des = desired(mLayout);
            } //End block
            {
                boring = BoringLayout.isBoring(mTransformed, mTextPaint, mTextDir, mBoring);
                {
                    mBoring = boring;
                } //End block
            } //End block
            {
                fromexisting = true;
            } //End block
            {
                {
                    des = (int) FloatMath.ceil(Layout.getDesiredWidth(mTransformed, mTextPaint));
                } //End block
                width = des;
            } //End block
            {
                width = boring.width;
            } //End block
            Drawables dr;
            dr = mDrawables;
            {
                width = Math.max(width, dr.mDrawableWidthTop);
                width = Math.max(width, dr.mDrawableWidthBottom);
            } //End block
            {
                int hintDes;
                hintDes = -1;
                int hintWidth;
                {
                    hintDes = desired(mHintLayout);
                } //End block
                {
                    hintBoring = BoringLayout.isBoring(mHint, mTextPaint, mHintBoring);
                    {
                        mHintBoring = hintBoring;
                    } //End block
                } //End block
                {
                    {
                        hintDes = (int) FloatMath.ceil(
                                Layout.getDesiredWidth(mHint, mTextPaint));
                    } //End block
                    hintWidth = hintDes;
                } //End block
                {
                    hintWidth = hintBoring.width;
                } //End block
                {
                    width = hintWidth;
                } //End block
            } //End block
            width += getCompoundPaddingLeft() + getCompoundPaddingRight();
            {
                width = Math.min(width, mMaxWidth * getLineHeight());
            } //End block
            {
                width = Math.min(width, mMaxWidth);
            } //End block
            {
                width = Math.max(width, mMinWidth * getLineHeight());
            } //End block
            {
                width = Math.max(width, mMinWidth);
            } //End block
            width = Math.max(width, getSuggestedMinimumWidth());
            {
                width = Math.min(widthSize, width);
            } //End block
        } //End block
        int want;
        want = width - getCompoundPaddingLeft() - getCompoundPaddingRight();
        int unpaddedWidth;
        unpaddedWidth = want;
        want = VERY_WIDE;
        int hintWant;
        hintWant = want;
        int hintWidth;
        hintWidth = hintWant;
        hintWidth = mHintLayout.getWidth();
        {
            makeNewLayout(want, hintWant, boring, hintBoring,
                          width - getCompoundPaddingLeft() - getCompoundPaddingRight(), false);
        } //End block
        {
            boolean layoutChanged;
            layoutChanged = (mLayout.getWidth() != want) ||
                    (hintWidth != hintWant) ||
                    (mLayout.getEllipsizedWidth() !=
                            width - getCompoundPaddingLeft() - getCompoundPaddingRight());
            boolean widthChanged;
            widthChanged = (mHint == null) &&
                    (mEllipsize == null) &&
                    (want > mLayout.getWidth()) &&
                    (mLayout instanceof BoringLayout || (fromexisting && des >= 0 && des <= want));
            boolean maximumChanged;
            maximumChanged = (mMaxMode != mOldMaxMode) || (mMaximum != mOldMaximum);
            {
                {
                    mLayout.increaseWidthTo(want);
                } //End block
                {
                    makeNewLayout(want, hintWant, boring, hintBoring,
                            width - getCompoundPaddingLeft() - getCompoundPaddingRight(), false);
                } //End block
            } //End block
        } //End block
        {
            height = heightSize;
            mDesiredHeightAtMeasure = -1;
        } //End block
        {
            int desired;
            desired = getDesiredHeight();
            height = desired;
            mDesiredHeightAtMeasure = desired;
            {
                height = Math.min(desired, heightSize);
            } //End block
        } //End block
        int unpaddedHeight;
        unpaddedHeight = height - getCompoundPaddingTop() - getCompoundPaddingBottom();
        {
            boolean var3DB10CBFB12ED38DCBD3FB16EF151096_1049939893 = (mMaxMode == LINES && mLayout.getLineCount() > mMaximum);
            {
                unpaddedHeight = Math.min(unpaddedHeight, mLayout.getLineTop(mMaximum));
            } //End block
        } //End collapsed parenthetic
        {
            boolean varFFED0DDEAA53977A5F429726E600A8F2_1418439993 = (mMovement != null ||
            mLayout.getWidth() > unpaddedWidth ||
            mLayout.getHeight() > unpaddedHeight);
            {
                registerForPreDraw();
            } //End block
            {
                scrollTo(0, 0);
            } //End block
        } //End collapsed parenthetic
        setMeasuredDimension(width, height);
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.641 -0400", hash_original_method = "94259D4548546EABDDB6F8414E37FA42", hash_generated_method = "C49BFEC70123BE19F756AE252E110810")
    private int getDesiredHeight() {
        int var2840A69C5B812317D9CA537C29691369_375261053 = (Math.max(
                getDesiredHeight(mLayout, true),
                getDesiredHeight(mHintLayout, mEllipsize != null)));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1890006510 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1890006510;
        // ---------- Original Method ----------
        //return Math.max(
                //getDesiredHeight(mLayout, true),
                //getDesiredHeight(mHintLayout, mEllipsize != null));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.650 -0400", hash_original_method = "7AA300272C545049E0340D139CA1349D", hash_generated_method = "487BA465D280773E5E7B08CBA2246672")
    private int getDesiredHeight(Layout layout, boolean cap) {
        int linecount;
        linecount = layout.getLineCount();
        int pad;
        pad = getCompoundPaddingTop() + getCompoundPaddingBottom();
        int desired;
        desired = layout.getLineTop(linecount);
        Drawables dr;
        dr = mDrawables;
        {
            desired = Math.max(desired, dr.mDrawableHeightLeft);
            desired = Math.max(desired, dr.mDrawableHeightRight);
        } //End block
        desired += pad;
        {
            {
                {
                    desired = layout.getLineTop(mMaximum);
                    {
                        desired = Math.max(desired, dr.mDrawableHeightLeft);
                        desired = Math.max(desired, dr.mDrawableHeightRight);
                    } //End block
                    desired += pad;
                    linecount = mMaximum;
                } //End block
            } //End block
        } //End block
        {
            desired = Math.min(desired, mMaximum);
        } //End block
        {
            {
                desired += getLineHeight() * (mMinimum - linecount);
            } //End block
        } //End block
        {
            desired = Math.max(desired, mMinimum);
        } //End block
        desired = Math.max(desired, getSuggestedMinimumHeight());
        addTaint(layout.getTaint());
        addTaint(cap);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_585194659 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_585194659;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.662 -0400", hash_original_method = "112907D8B10F62764352610BA7B79108", hash_generated_method = "8EDB2FD63B41496E04A6F2DDB0006563")
    private void checkForResize() {
        boolean sizeChanged;
        sizeChanged = false;
        {
            {
                sizeChanged = true;
                invalidate();
            } //End block
            {
                int desiredHeight;
                desiredHeight = getDesiredHeight();
                {
                    boolean var76B417FEF15CB7997AEC250AB014098F_1475910812 = (desiredHeight != this.getHeight());
                    {
                        sizeChanged = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    int desiredHeight;
                    desiredHeight = getDesiredHeight();
                    {
                        sizeChanged = true;
                    } //End block
                } //End block
            } //End block
        } //End block
        {
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.663 -0400", hash_original_method = "5832A71588E0ABA41180B589D326BF70", hash_generated_method = "439CCE555DE46010ED69CBCE06B130DA")
    private void checkForRelayout() {
        {
            boolean var32BFD96E0546ED5F291DC663279A0815_1648400872 = ((mLayoutParams.width != LayoutParams.WRAP_CONTENT ||
                (mMaxWidthMode == mMinWidthMode && mMaxWidth == mMinWidth)) &&
                (mHint == null || mHintLayout != null) &&
                (mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight() > 0));
            {
                int oldht;
                oldht = mLayout.getHeight();
                int want;
                want = mLayout.getWidth();
                int hintWant;
                hintWant = 0;
                hintWant = mHintLayout.getWidth();
                makeNewLayout(want, hintWant, UNKNOWN_BORING, UNKNOWN_BORING,
                          mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight(),
                          false);
                {
                    {
                        invalidate();
                    } //End block
                    {
                        boolean varE1571FB91561235A70F553E0D47B6412_79471156 = (mLayout.getHeight() == oldht &&
                    (mHintLayout == null || mHintLayout.getHeight() == oldht));
                        {
                            invalidate();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                requestLayout();
                invalidate();
            } //End block
            {
                nullLayouts();
                requestLayout();
                invalidate();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.664 -0400", hash_original_method = "0DA3D6D28C1432B95D5D1B1B5DDB2BC8", hash_generated_method = "05F78A24765DD564658E77937027A0A7")
    private boolean bringTextIntoView() {
        int line;
        line = 0;
        {
            line = mLayout.getLineCount() - 1;
        } //End block
        Layout.Alignment a;
        a = mLayout.getParagraphAlignment(line);
        int dir;
        dir = mLayout.getParagraphDirection(line);
        int hspace;
        hspace = mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight();
        int vspace;
        vspace = mBottom - mTop - getExtendedPaddingTop() - getExtendedPaddingBottom();
        int ht;
        ht = mLayout.getHeight();
        int scrollx, scrolly;
        {
            a = dir == Layout.DIR_LEFT_TO_RIGHT ? Layout.Alignment.ALIGN_LEFT :
                Layout.Alignment.ALIGN_RIGHT;
        } //End block
        {
            a = dir == Layout.DIR_LEFT_TO_RIGHT ? Layout.Alignment.ALIGN_RIGHT :
                Layout.Alignment.ALIGN_LEFT;
        } //End block
        {
            int left;
            left = (int) FloatMath.floor(mLayout.getLineLeft(line));
            int right;
            right = (int) FloatMath.ceil(mLayout.getLineRight(line));
            {
                scrollx = (right + left) / 2 - hspace / 2;
            } //End block
            {
                {
                    scrollx = right - hspace;
                } //End block
                {
                    scrollx = left;
                } //End block
            } //End block
        } //End block
        {
            int right;
            right = (int) FloatMath.ceil(mLayout.getLineRight(line));
            scrollx = right - hspace;
        } //End block
        {
            scrollx = (int) FloatMath.floor(mLayout.getLineLeft(line));
        } //End block
        {
            scrolly = 0;
        } //End block
        {
            {
                scrolly = ht - vspace;
            } //End block
            {
                scrolly = 0;
            } //End block
        } //End block
        {
            scrollTo(scrollx, scrolly);
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2038649518 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2038649518;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.674 -0400", hash_original_method = "3C0DD43A95E696C7A1592341A7B2F740", hash_generated_method = "B6C444B88F7E9C9DB4BF343A82C40BD6")
    public boolean bringPointIntoView(int offset) {
        boolean changed;
        changed = false;
        int line;
        line = mLayout.getLineForOffset(offset);
        int x;
        x = (int)mLayout.getPrimaryHorizontal(offset);
        int top;
        top = mLayout.getLineTop(line);
        int bottom;
        bottom = mLayout.getLineTop(line + 1);
        int left;
        left = (int) FloatMath.floor(mLayout.getLineLeft(line));
        int right;
        right = (int) FloatMath.ceil(mLayout.getLineRight(line));
        int ht;
        ht = mLayout.getHeight();
        int grav;
        {
            Object var027910B290B59420177BD30BF1DDB958_105990379 = (mLayout.getParagraphAlignment(line));
            //Begin case ALIGN_LEFT 
            grav = 1;
            //End case ALIGN_LEFT 
            //Begin case ALIGN_RIGHT 
            grav = -1;
            //End case ALIGN_RIGHT 
            //Begin case ALIGN_NORMAL 
            grav = mLayout.getParagraphDirection(line);
            //End case ALIGN_NORMAL 
            //Begin case ALIGN_OPPOSITE 
            grav = -mLayout.getParagraphDirection(line);
            //End case ALIGN_OPPOSITE 
            //Begin case ALIGN_CENTER default 
            grav = 0;
            //End case ALIGN_CENTER default 
        } //End collapsed parenthetic
        int hspace;
        hspace = mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight();
        int vspace;
        vspace = mBottom - mTop - getExtendedPaddingTop() - getExtendedPaddingBottom();
        int hslack;
        hslack = (bottom - top) / 2;
        int vslack;
        vslack = hslack;
        vslack = vspace / 4;
        hslack = hspace / 4;
        int hs;
        hs = mScrollX;
        int vs;
        vs = mScrollY;
        vs = top - vslack;
        vs = bottom - (vspace - vslack);
        vs = ht - vspace;
        vs = 0;
        {
            {
                hs = x - hslack;
            } //End block
            {
                hs = x - (hspace - hslack);
            } //End block
        } //End block
        {
            hs = left;
            hs = right - hspace;
        } //End block
        {
            hs = right - hspace;
            hs = left;
        } //End block
        {
            {
                hs = left - (hspace - (right - left)) / 2;
            } //End block
            {
                hs = right - hspace;
            } //End block
            {
                hs = left;
            } //End block
            {
                hs = left;
            } //End block
            {
                hs = right - hspace;
            } //End block
            {
                {
                    hs = x - hslack;
                } //End block
                {
                    hs = x - (hspace - hslack);
                } //End block
            } //End block
        } //End block
        {
            {
                scrollTo(hs, vs);
            } //End block
            {
                long duration;
                duration = AnimationUtils.currentAnimationTimeMillis() - mLastScroll;
                int dx;
                dx = hs - mScrollX;
                int dy;
                dy = vs - mScrollY;
                {
                    mScroller.startScroll(mScrollX, mScrollY, dx, dy);
                    awakenScrollBars(mScroller.getDuration());
                    invalidate();
                } //End block
                {
                    {
                        boolean varD539631976251D8AA391F3162DE97B1C_860258706 = (!mScroller.isFinished());
                        {
                            mScroller.abortAnimation();
                        } //End block
                    } //End collapsed parenthetic
                    scrollBy(dx, dy);
                } //End block
                mLastScroll = AnimationUtils.currentAnimationTimeMillis();
            } //End block
            changed = true;
        } //End block
        {
            boolean var1C23F183BE3EEE2A8667855A22865324_1279914297 = (isFocused());
            {
                mTempRect = new Rect();
                mTempRect.set(x - 2, top, x + 2, bottom);
                getInterestingRect(mTempRect, line);
                mTempRect.offset(mScrollX, mScrollY);
                {
                    boolean var5DD27CBBEE9D998C97ABDC1CFDA74333_206000380 = (requestRectangleOnScreen(mTempRect));
                    {
                        changed = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(offset);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1178577680 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1178577680;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.689 -0400", hash_original_method = "02D4B7457672C459E287DBA1B16986EC", hash_generated_method = "21F0E9BE87AD38AD7FD8ACADD0C8D024")
    public boolean moveCursorToVisibleOffset() {
        int start;
        start = getSelectionStart();
        int end;
        end = getSelectionEnd();
        int line;
        line = mLayout.getLineForOffset(start);
        int top;
        top = mLayout.getLineTop(line);
        int bottom;
        bottom = mLayout.getLineTop(line + 1);
        int vspace;
        vspace = mBottom - mTop - getExtendedPaddingTop() - getExtendedPaddingBottom();
        int vslack;
        vslack = (bottom - top) / 2;
        vslack = vspace / 4;
        int vs;
        vs = mScrollY;
        {
            line = mLayout.getLineForVertical(vs+vslack+(bottom-top));
        } //End block
        {
            line = mLayout.getLineForVertical(vspace+vs-vslack-(bottom-top));
        } //End block
        int hspace;
        hspace = mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight();
        int hs;
        hs = mScrollX;
        int leftChar;
        leftChar = mLayout.getOffsetForHorizontal(line, hs);
        int rightChar;
        rightChar = mLayout.getOffsetForHorizontal(line, hspace+hs);
        int lowChar;
        lowChar = leftChar;
        lowChar = rightChar;
        int highChar;
        highChar = leftChar;
        highChar = rightChar;
        int newStart;
        newStart = start;
        {
            newStart = lowChar;
        } //End block
        {
            newStart = highChar;
        } //End block
        {
            Selection.setSelection((Spannable)mText, newStart);
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_747091440 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_747091440;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.690 -0400", hash_original_method = "D06313C44705A7887AB654B7CF5A74B3", hash_generated_method = "50B5CA72CCBC9C6AA22945FD37A0CE0E")
    @Override
    public void computeScroll() {
        {
            {
                boolean varD8983424724D79AFF92B0ED68CFEBCB5_413784325 = (mScroller.computeScrollOffset());
                {
                    mScrollX = mScroller.getCurrX();
                    mScrollY = mScroller.getCurrY();
                    invalidateParentCaches();
                    postInvalidate();
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.692 -0400", hash_original_method = "ABFDC323272F3E6393D3C4F9B9F60889", hash_generated_method = "2AB95035BBAB2595EFD105687898EF73")
    private void getInterestingRect(Rect r, int line) {
        convertFromViewportToContentCoordinates(r);
        r.top -= getExtendedPaddingTop();
        {
            boolean var36B5761D6C0D25FD94548457569D0FDF_982550699 = (line == mLayout.getLineCount() - 1);
            r.bottom += getExtendedPaddingBottom();
        } //End collapsed parenthetic
        addTaint(r.getTaint());
        addTaint(line);
        // ---------- Original Method ----------
        //convertFromViewportToContentCoordinates(r);
        //if (line == 0) r.top -= getExtendedPaddingTop();
        //if (line == mLayout.getLineCount() - 1) r.bottom += getExtendedPaddingBottom();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.692 -0400", hash_original_method = "D2E7C9E2773084F5B5BC96B85475267E", hash_generated_method = "19630ACCEA64F1449FB135A3AAB6AA7F")
    private void convertFromViewportToContentCoordinates(Rect r) {
        int horizontalOffset;
        horizontalOffset = viewportToContentHorizontalOffset();
        r.left += horizontalOffset;
        r.right += horizontalOffset;
        int verticalOffset;
        verticalOffset = viewportToContentVerticalOffset();
        r.top += verticalOffset;
        r.bottom += verticalOffset;
        addTaint(r.getTaint());
        // ---------- Original Method ----------
        //final int horizontalOffset = viewportToContentHorizontalOffset();
        //r.left += horizontalOffset;
        //r.right += horizontalOffset;
        //final int verticalOffset = viewportToContentVerticalOffset();
        //r.top += verticalOffset;
        //r.bottom += verticalOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.693 -0400", hash_original_method = "3DB802CF5F82AE3562BB26F896D07DB6", hash_generated_method = "BE15BAF5AFA8159796283FE5333F1D3A")
    private int viewportToContentHorizontalOffset() {
        int var094701FAECA9F0FDE06C5A96E63AF57B_1391010408 = (getCompoundPaddingLeft() - mScrollX);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1043767793 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1043767793;
        // ---------- Original Method ----------
        //return getCompoundPaddingLeft() - mScrollX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.698 -0400", hash_original_method = "1E5AEDFCDEE7B994A62FE1D426BA9AAE", hash_generated_method = "E3BF3C26D034BE38088EC34DDB8E39BE")
    private int viewportToContentVerticalOffset() {
        int offset;
        offset = getExtendedPaddingTop() - mScrollY;
        {
            offset += getVerticalOffset(false);
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1317994209 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1317994209;
        // ---------- Original Method ----------
        //int offset = getExtendedPaddingTop() - mScrollY;
        //if ((mGravity & Gravity.VERTICAL_GRAVITY_MASK) != Gravity.TOP) {
            //offset += getVerticalOffset(false);
        //}
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.700 -0400", hash_original_method = "7E6A70E8247BE9F0E1C3854BAECCAE99", hash_generated_method = "6DA758B22DBF7AE9ECBA58F11EB7FA4C")
    @Override
    public void debug(int depth) {
        super.debug(depth);
        String output;
        output = debugIndent(depth);
        output += "frame={" + mLeft + ", " + mTop + ", " + mRight
                + ", " + mBottom + "} scroll={" + mScrollX + ", " + mScrollY
                + "} ";
        {
            output += "mText=\"" + mText + "\" ";
            {
                output += "mLayout width=" + mLayout.getWidth()
                        + " height=" + mLayout.getHeight();
            } //End block
        } //End block
        {
            output += "mText=NULL";
        } //End block
        Log.d(VIEW_LOG_TAG, output);
        addTaint(depth);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.703 -0400", hash_original_method = "FC0380BF9D344F57087ADAA0F0C8C1E5", hash_generated_method = "17D02CE6F89711B0E93EFE61616A4696")
    @ViewDebug.ExportedProperty(category = "text")
    public int getSelectionStart() {
        int varB37ACFCDE0514D1AD6E7980466D0642F_848719265 = (Selection.getSelectionStart(getText()));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1381180689 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1381180689;
        // ---------- Original Method ----------
        //return Selection.getSelectionStart(getText());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.707 -0400", hash_original_method = "59139061668C8515BDA5938230C2D233", hash_generated_method = "5DB01A281C029D68D88F01AF02898A7F")
    @ViewDebug.ExportedProperty(category = "text")
    public int getSelectionEnd() {
        int var62647D48C20F4425C471C6DB7EC335FA_1915188431 = (Selection.getSelectionEnd(getText()));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1448757082 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1448757082;
        // ---------- Original Method ----------
        //return Selection.getSelectionEnd(getText());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.711 -0400", hash_original_method = "BD52AC55F75FC20C70791ABE185D07B3", hash_generated_method = "031A4DC44CF9296C73107E70E3623E58")
    public boolean hasSelection() {
        int selectionStart;
        selectionStart = getSelectionStart();
        int selectionEnd;
        selectionEnd = getSelectionEnd();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_830550414 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_830550414;
        // ---------- Original Method ----------
        //final int selectionStart = getSelectionStart();
        //final int selectionEnd = getSelectionEnd();
        //return selectionStart >= 0 && selectionStart != selectionEnd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.712 -0400", hash_original_method = "08C77724BEA7FD604DDC056EC8AC0A85", hash_generated_method = "3BCA6B79215B55736909B9CF7C5FC574")
    public void setSingleLine() {
        setSingleLine(true);
        // ---------- Original Method ----------
        //setSingleLine(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.712 -0400", hash_original_method = "02E25EABD0939EA349140FD704ABC4B2", hash_generated_method = "1AED22E2B086A521F35421A65810B8DF")
    public void setAllCaps(boolean allCaps) {
        {
            setTransformationMethod(new AllCapsTransformationMethod(getContext()));
        } //End block
        {
            setTransformationMethod(null);
        } //End block
        addTaint(allCaps);
        // ---------- Original Method ----------
        //if (allCaps) {
            //setTransformationMethod(new AllCapsTransformationMethod(getContext()));
        //} else {
            //setTransformationMethod(null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.713 -0400", hash_original_method = "F67AECEDD15B73EEA4C7246A27A881B1", hash_generated_method = "2C29CB9DE3123012851F4AD7F2FA8B93")
    @android.view.RemotableViewMethod
    public void setSingleLine(boolean singleLine) {
        setInputTypeSingleLine(singleLine);
        applySingleLine(singleLine, true, true);
        addTaint(singleLine);
        // ---------- Original Method ----------
        //setInputTypeSingleLine(singleLine);
        //applySingleLine(singleLine, true, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.716 -0400", hash_original_method = "7606E2D7FCC52ECFF0946358CA46A596", hash_generated_method = "7672113BAFA059761089D684A8950861")
    private void setInputTypeSingleLine(boolean singleLine) {
        {
            {
                mInputType &= ~EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE;
            } //End block
            {
                mInputType |= EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE;
            } //End block
        } //End block
        addTaint(singleLine);
        // ---------- Original Method ----------
        //if ((mInputType & EditorInfo.TYPE_MASK_CLASS) == EditorInfo.TYPE_CLASS_TEXT) {
            //if (singleLine) {
                //mInputType &= ~EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE;
            //} else {
                //mInputType |= EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.723 -0400", hash_original_method = "939294E5BC9AAD2D1E9D05ACD8801E5C", hash_generated_method = "D78563793112EE17F812B2B42680D6E2")
    private void applySingleLine(boolean singleLine, boolean applyTransformation,
            boolean changeMaxLines) {
        mSingleLine = singleLine;
        {
            setLines(1);
            setHorizontallyScrolling(true);
            {
                setTransformationMethod(SingleLineTransformationMethod.getInstance());
            } //End block
        } //End block
        {
            {
                setMaxLines(Integer.MAX_VALUE);
            } //End block
            setHorizontallyScrolling(false);
            {
                setTransformationMethod(null);
            } //End block
        } //End block
        addTaint(applyTransformation);
        addTaint(changeMaxLines);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.726 -0400", hash_original_method = "8F48F7BF1B8DCE5D5519F1200A0ED853", hash_generated_method = "391DDE249F9C22576C3C02CC92F75CFE")
    public void setEllipsize(TextUtils.TruncateAt where) {
        {
            mEllipsize = where;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.727 -0400", hash_original_method = "CD4BE90CF39D915FD988D1208E7FE9CE", hash_generated_method = "5F7F9C51B8B3A126669EEFC67E596872")
    public void setMarqueeRepeatLimit(int marqueeLimit) {
        mMarqueeRepeatLimit = marqueeLimit;
        // ---------- Original Method ----------
        //mMarqueeRepeatLimit = marqueeLimit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.727 -0400", hash_original_method = "A6931739C39A011B325E0D6A04B5E1A4", hash_generated_method = "3658F4A1601C208ECCDA3B5342B67A8A")
    @ViewDebug.ExportedProperty
    public TextUtils.TruncateAt getEllipsize() {
        TextUtils.TruncateAt varB4EAC82CA7396A68D541C85D26508E83_1228293859 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1228293859 = mEllipsize;
        varB4EAC82CA7396A68D541C85D26508E83_1228293859.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1228293859;
        // ---------- Original Method ----------
        //return mEllipsize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.727 -0400", hash_original_method = "EF856664E3DB8B213F8E2D5A0092DC9C", hash_generated_method = "16238E1BDE515B63A500D2B00D42C334")
    @android.view.RemotableViewMethod
    public void setSelectAllOnFocus(boolean selectAllOnFocus) {
        mSelectAllOnFocus = selectAllOnFocus;
        {
            setText(mText, BufferType.SPANNABLE);
        } //End block
        // ---------- Original Method ----------
        //mSelectAllOnFocus = selectAllOnFocus;
        //if (selectAllOnFocus && !(mText instanceof Spannable)) {
            //setText(mText, BufferType.SPANNABLE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.733 -0400", hash_original_method = "8363604A399432417CD34524C965D01B", hash_generated_method = "A5016D99D04E4842F3E3647E9407B068")
    @android.view.RemotableViewMethod
    public void setCursorVisible(boolean visible) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.733 -0400", hash_original_method = "D29F788B650242C9D9871158254DD48F", hash_generated_method = "0A348E915E9AD15DC69DC1D63FF907D3")
    private boolean isCursorVisible() {
        boolean var34066627433670C8BAD177AAE0AA915E_1374763820 = (mCursorVisible && isTextEditable());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_858999172 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_858999172;
        // ---------- Original Method ----------
        //return mCursorVisible && isTextEditable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.735 -0400", hash_original_method = "20D9FD35375357DA34698727A7AEC969", hash_generated_method = "D7734659951F9181E8986E11753F67D4")
    private boolean canMarquee() {
        int width;
        width = (mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight());
        boolean var7BCDD076660CE26696388675CAFFA311_111034042 = (width > 0 && (mLayout.getLineWidth(0) > width ||
                (mMarqueeFadeMode != MARQUEE_FADE_NORMAL && mSavedMarqueeModeLayout != null &&
                        mSavedMarqueeModeLayout.getLineWidth(0) > width)));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_552303643 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_552303643;
        // ---------- Original Method ----------
        //int width = (mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight());
        //return width > 0 && (mLayout.getLineWidth(0) > width ||
                //(mMarqueeFadeMode != MARQUEE_FADE_NORMAL && mSavedMarqueeModeLayout != null &&
                        //mSavedMarqueeModeLayout.getLineWidth(0) > width));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.736 -0400", hash_original_method = "A5A9508FE00ED8FCDF4CF88DA2302AE0", hash_generated_method = "4C8E7582AFBC7DEB13995F467D8A3330")
    private void startMarquee() {
        {
            boolean var6ED3A362A2778E1490EC444CE7783B2B_1602640355 = (compressText(getWidth() - getCompoundPaddingLeft() - getCompoundPaddingRight()));
        } //End collapsed parenthetic
        {
            boolean var075BA9C6A85CDA01D82AF38828D63BDE_1148572526 = ((mMarquee == null || mMarquee.isStopped()) && (isFocused() || isSelected()) &&
                getLineCount() == 1 && canMarquee());
            {
                {
                    mMarqueeFadeMode = MARQUEE_FADE_SWITCH_SHOW_FADE;
                    Layout tmp;
                    tmp = mLayout;
                    mLayout = mSavedMarqueeModeLayout;
                    mSavedMarqueeModeLayout = tmp;
                    setHorizontalFadingEdgeEnabled(true);
                    requestLayout();
                    invalidate();
                } //End block
                mMarquee = new Marquee(this);
                mMarquee.start(mMarqueeRepeatLimit);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.737 -0400", hash_original_method = "20FFAC26BF2AB259CA62980CC6D60A71", hash_generated_method = "766B31123B5282F4F1A92267ACBC802C")
    private void stopMarquee() {
        {
            boolean varC29061DCB050768224BF65B86692AEF9_1075040395 = (mMarquee != null && !mMarquee.isStopped());
            {
                mMarquee.stop();
            } //End block
        } //End collapsed parenthetic
        {
            mMarqueeFadeMode = MARQUEE_FADE_SWITCH_SHOW_ELLIPSIS;
            Layout tmp;
            tmp = mSavedMarqueeModeLayout;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.739 -0400", hash_original_method = "21D240E17A817FDDEDCDA696469AE631", hash_generated_method = "075571A12CD343288F78D3DBD8F6CF6D")
    private void startStopMarquee(boolean start) {
        {
            {
                startMarquee();
            } //End block
            {
                stopMarquee();
            } //End block
        } //End block
        addTaint(start);
        // ---------- Original Method ----------
        //if (mEllipsize == TextUtils.TruncateAt.MARQUEE) {
            //if (start) {
                //startMarquee();
            //} else {
                //stopMarquee();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.740 -0400", hash_original_method = "CD3A5A17C18A7E4515BB5E10EEE133D7", hash_generated_method = "5A38D7A52E63B141F65E3400877FA2F9")
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(text.getTaint());
        addTaint(start);
        addTaint(lengthBefore);
        addTaint(lengthAfter);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.742 -0400", hash_original_method = "50DC1B812435050055FA72016E5949C2", hash_generated_method = "87189D15EBF6DC7ACC16571020058A28")
    protected void onSelectionChanged(int selStart, int selEnd) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED);
        addTaint(selStart);
        addTaint(selEnd);
        // ---------- Original Method ----------
        //sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.748 -0400", hash_original_method = "B64F50676D912718618203C6EADBF90A", hash_generated_method = "60EC4C825B8A758D874287AFCC67246D")
    public void addTextChangedListener(TextWatcher watcher) {
        {
            mListeners = new ArrayList<TextWatcher>();
        } //End block
        mListeners.add(watcher);
        addTaint(watcher.getTaint());
        // ---------- Original Method ----------
        //if (mListeners == null) {
            //mListeners = new ArrayList<TextWatcher>();
        //}
        //mListeners.add(watcher);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.748 -0400", hash_original_method = "8E2AAA118EDD6CA871B924E45DB79686", hash_generated_method = "F720ED4CEFB8A7EDE96E0FA184207661")
    public void removeTextChangedListener(TextWatcher watcher) {
        {
            int i;
            i = mListeners.indexOf(watcher);
            {
                mListeners.remove(i);
            } //End block
        } //End block
        addTaint(watcher.getTaint());
        // ---------- Original Method ----------
        //if (mListeners != null) {
            //int i = mListeners.indexOf(watcher);
            //if (i >= 0) {
                //mListeners.remove(i);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.759 -0400", hash_original_method = "282476D07DF9C69037F7F82B56506B50", hash_generated_method = "A951C8A32900F8B9C334D3547E2F2337")
    private void sendBeforeTextChanged(CharSequence text, int start, int before, int after) {
        {
            ArrayList<TextWatcher> list;
            list = mListeners;
            int count;
            count = list.size();
            {
                int i;
                i = 0;
                {
                    list.get(i).beforeTextChanged(text, start, before, after);
                } //End block
            } //End collapsed parenthetic
        } //End block
        removeIntersectingSpans(start, start + before, SpellCheckSpan.class);
        removeIntersectingSpans(start, start + before, SuggestionSpan.class);
        addTaint(text.getTaint());
        addTaint(start);
        addTaint(before);
        addTaint(after);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.760 -0400", hash_original_method = "3C2834233455B82E3097E9750018AB89", hash_generated_method = "678F3FE53AC777D5CB1BE629BBF801B1")
    private <T> void removeIntersectingSpans(int start, int end, Class<T> type) {
        Editable text;
        text = (Editable) mText;
        T[] spans;
        spans = text.getSpans(start, end, type);
        int length;
        length = spans.length;
        {
            int i;
            i = 0;
            {
                int s;
                s = text.getSpanStart(spans[i]);
                int e;
                e = text.getSpanEnd(spans[i]);
                text.removeSpan(spans[i]);
            } //End block
        } //End collapsed parenthetic
        addTaint(start);
        addTaint(end);
        addTaint(type.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.763 -0400", hash_original_method = "942AE7F3893B5D5A1A729CC9A3D3A214", hash_generated_method = "7C08B41CA18D36D2837F2FBB3CB32E14")
     void sendOnTextChanged(CharSequence text, int start, int before, int after) {
        {
            ArrayList<TextWatcher> list;
            list = mListeners;
            int count;
            count = list.size();
            {
                int i;
                i = 0;
                {
                    list.get(i).onTextChanged(text, start, before, after);
                } //End block
            } //End collapsed parenthetic
        } //End block
        updateSpellCheckSpans(start, start + after, false);
        hideCursorControllers();
        addTaint(text.getTaint());
        addTaint(start);
        addTaint(before);
        addTaint(after);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.764 -0400", hash_original_method = "9B73ECD477F18D05FDDE640FFC672625", hash_generated_method = "BE228AA01655E39594ECA300A6DA61B4")
     void sendAfterTextChanged(Editable text) {
        {
            ArrayList<TextWatcher> list;
            list = mListeners;
            int count;
            count = list.size();
            {
                int i;
                i = 0;
                {
                    list.get(i).afterTextChanged(text);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(text.getTaint());
        // ---------- Original Method ----------
        //if (mListeners != null) {
            //final ArrayList<TextWatcher> list = mListeners;
            //final int count = list.size();
            //for (int i = 0; i < count; i++) {
                //list.get(i).afterTextChanged(text);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.771 -0400", hash_original_method = "4CD104B06ADE0BFE958B91634E28368D", hash_generated_method = "E2775A9B684D32AE85449CA8EEE3F487")
     void handleTextChanged(CharSequence buffer, int start, int before, int after) {
        InputMethodState ims;
        ims = mInputMethodState;
        {
            updateAfterEdit();
        } //End block
        {
            ims.mContentChanged = true;
            {
                ims.mChangedStart = start;
                ims.mChangedEnd = start+before;
            } //End block
            {
                ims.mChangedStart = Math.min(ims.mChangedStart, start);
                ims.mChangedEnd = Math.max(ims.mChangedEnd, start + before - ims.mChangedDelta);
            } //End block
            ims.mChangedDelta += after-before;
        } //End block
        sendOnTextChanged(buffer, start, before, after);
        onTextChanged(buffer, start, before, after);
        addTaint(buffer.getTaint());
        addTaint(start);
        addTaint(before);
        addTaint(after);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.779 -0400", hash_original_method = "69940040C167925CDE0DCFB6E34891AF", hash_generated_method = "D904EE3A7AC6AF6DEA86D1AEAE066D03")
     void spanChange(Spanned buf, Object what, int oldStart, int newStart, int oldEnd, int newEnd) {
        boolean selChanged;
        selChanged = false;
        int newSelStart, newSelEnd;
        newSelStart = -1;
        newSelEnd = -1;
        InputMethodState ims;
        ims = mInputMethodState;
        {
            mHighlightPathBogus = true;
            selChanged = true;
            newSelEnd = newStart;
            {
                boolean varCCB6FB0842D1DC09DCB72C373334A6F6_909368864 = (!isFocused());
                {
                    mSelectionMoved = true;
                } //End block
            } //End collapsed parenthetic
            {
                invalidateCursor(Selection.getSelectionStart(buf), oldStart, newStart);
                registerForPreDraw();
                makeBlink();
            } //End block
        } //End block
        {
            mHighlightPathBogus = true;
            selChanged = true;
            newSelStart = newStart;
            {
                boolean varCCB6FB0842D1DC09DCB72C373334A6F6_394973413 = (!isFocused());
                {
                    mSelectionMoved = true;
                } //End block
            } //End collapsed parenthetic
            {
                int end;
                end = Selection.getSelectionEnd(buf);
                invalidateCursor(end, oldStart, newStart);
            } //End block
        } //End block
        {
            {
                boolean varA8F0B10D2B3144CBC8414B61F2255511_880995414 = ((buf.getSpanFlags(what)&Spanned.SPAN_INTERMEDIATE) == 0);
                {
                    {
                        newSelStart = Selection.getSelectionStart(buf);
                    } //End block
                    {
                        newSelEnd = Selection.getSelectionEnd(buf);
                    } //End block
                    onSelectionChanged(newSelStart, newSelEnd);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                invalidate();
                mHighlightPathBogus = true;
                checkForResize();
            } //End block
            {
                ims.mContentChanged = true;
            } //End block
        } //End block
        {
            boolean var534517144FEFDAEF71F7C8FA756F16FC_334622865 = (MetaKeyKeyListener.isMetaTracker(buf, what));
            {
                mHighlightPathBogus = true;
                {
                    boolean var16FFCEF6C055C210FC735BC7F134F961_1218166697 = (ims != null && MetaKeyKeyListener.isSelectingMetaTracker(buf, what));
                    {
                        ims.mSelectionModeChanged = true;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varEFD569E843D74170ABE4EC8DA8C94C51_1883563439 = (Selection.getSelectionStart(buf) >= 0);
                    {
                        {
                            invalidateCursor();
                        } //End block
                        {
                            ims.mCursorChanged = true;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            {
                {
                    {
                        {
                            ims.mChangedStart = oldStart;
                        } //End block
                        {
                            ims.mChangedStart = oldEnd;
                        } //End block
                    } //End block
                    {
                        {
                            ims.mChangedStart = newStart;
                        } //End block
                        {
                            ims.mChangedStart = newEnd;
                        } //End block
                    } //End block
                } //End block
                {
                    ims.mContentChanged = true;
                } //End block
            } //End block
        } //End block
        {
            mSpellChecker.removeSpellCheckSpan((SpellCheckSpan) what);
        } //End block
        addTaint(buf.getTaint());
        addTaint(what.getTaint());
        addTaint(oldStart);
        addTaint(newStart);
        addTaint(oldEnd);
        addTaint(newEnd);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.785 -0400", hash_original_method = "3584A2B9A599770217F39B9A82ACFE32", hash_generated_method = "4270A7D10CAD9E4460388B9309C80762")
    private void updateSpellCheckSpans(int start, int end, boolean createSpellChecker) {
        {
            boolean var330582D41A8577FF8D2F4281F7486A79_1269165889 = (isTextEditable() && isSuggestionsEnabled() && !(this instanceof ExtractEditText));
            {
                {
                    mSpellChecker = new SpellChecker(this);
                } //End block
                {
                    mSpellChecker.spellCheck(start, end);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(start);
        addTaint(end);
        addTaint(createSpellChecker);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.792 -0400", hash_original_method = "5B060B8ED8B2D254991A03FDABE416A2", hash_generated_method = "5442F0493B231BDA57B4F0511037B18F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.792 -0400", hash_original_method = "F389EC0F4785B5FE5917104FC845071C", hash_generated_method = "1A91DFB12354DC797253849F4D5C2578")
    @Override
    public void onStartTemporaryDetach() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onStartTemporaryDetach();
        mTemporaryDetach = true;
        hideControllers();
        // ---------- Original Method ----------
        //super.onStartTemporaryDetach();
        //if (!mDispatchTemporaryDetach) mTemporaryDetach = true;
        //hideControllers();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.793 -0400", hash_original_method = "FEAF0C4CB4DA72DBC669293A29968ABE", hash_generated_method = "B710ACB4EFD7C32268C236E59191274A")
    @Override
    public void onFinishTemporaryDetach() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onFinishTemporaryDetach();
        mTemporaryDetach = false;
        // ---------- Original Method ----------
        //super.onFinishTemporaryDetach();
        //if (!mDispatchTemporaryDetach) mTemporaryDetach = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.795 -0400", hash_original_method = "B5EB741E17FA804FF18CB2D4805829B5", hash_generated_method = "7F835C4E01E9034E0C3B39D79217037B")
    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            super.onFocusChanged(focused, direction, previouslyFocusedRect);
        } //End block
        mShowCursor = SystemClock.uptimeMillis();
        ensureEndedBatchEdit();
        {
            int selStart;
            selStart = getSelectionStart();
            int selEnd;
            selEnd = getSelectionEnd();
            boolean isFocusHighlighted;
            isFocusHighlighted = mSelectAllOnFocus && selStart == 0 &&
                    selEnd == mText.length();
            mCreatedWithASelection = mFrozenWithFocus && hasSelection() && !isFocusHighlighted;
            {
                int lastTapPosition;
                lastTapPosition = getLastTapPosition();
                {
                    Selection.setSelection((Spannable) mText, lastTapPosition);
                } //End block
                {
                    mMovement.onTakeFocus(this, (Spannable) mText, direction);
                } //End block
                {
                    Selection.setSelection((Spannable) mText, selStart, selEnd);
                } //End block
                {
                    selectAll();
                } //End block
                mTouchFocusSelected = true;
            } //End block
            mFrozenWithFocus = false;
            mSelectionMoved = false;
            {
                Spannable sp;
                sp = (Spannable) mText;
                MetaKeyKeyListener.resetMetaState(sp);
            } //End block
            makeBlink();
            {
                showError();
            } //End block
        } //End block
        {
            {
                hideError();
            } //End block
            onEndBatchEdit();
            {
                int selStart;
                selStart = getSelectionStart();
                int selEnd;
                selEnd = getSelectionEnd();
                hideControllers();
                Selection.setSelection((Spannable) mText, selStart, selEnd);
            } //End block
            {
                hideControllers();
                downgradeEasyCorrectionSpans();
            } //End block
            {
                mSelectionModifierCursorController.resetTouchOffsets();
            } //End block
        } //End block
        startStopMarquee(focused);
        {
            mTransformation.onFocusChanged(this, mText, focused, direction, previouslyFocusedRect);
        } //End block
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        addTaint(focused);
        addTaint(direction);
        addTaint(previouslyFocusedRect.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.796 -0400", hash_original_method = "CD7EF11AEB2748DC958E6E43AA11AC3D", hash_generated_method = "8B6FB5338E1456CBA3503EB31F812262")
    private int getLastTapPosition() {
        {
            int lastTapPosition;
            lastTapPosition = mSelectionModifierCursorController.getMinTouchOffset();
            {
                {
                    boolean var164D0FD6416EC18A9D0895B7ABD638B0_1295622552 = (lastTapPosition > mText.length());
                    {
                        lastTapPosition = mText.length();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_693484868 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_693484868;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.808 -0400", hash_original_method = "52F09857D084B6A7FF7DED6ACD447E38", hash_generated_method = "BB97642A7272E99714FE1387CB53DACB")
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onWindowFocusChanged(hasWindowFocus);
        {
            {
                mBlink.uncancel();
                makeBlink();
            } //End block
        } //End block
        {
            {
                mBlink.cancel();
            } //End block
            onEndBatchEdit();
            {
                mInputContentType.enterDown = false;
            } //End block
            hideControllers();
            {
                mSuggestionsPopupWindow.onParentLostFocus();
            } //End block
        } //End block
        startStopMarquee(hasWindowFocus);
        addTaint(hasWindowFocus);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.809 -0400", hash_original_method = "CACE22E1BEC14AEE1A4D35946DA3AF11", hash_generated_method = "B33E6B50711E3541C69DD97200CDD908")
    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onVisibilityChanged(changedView, visibility);
        {
            hideControllers();
        } //End block
        addTaint(changedView.getTaint());
        addTaint(visibility);
        // ---------- Original Method ----------
        //super.onVisibilityChanged(changedView, visibility);
        //if (visibility != VISIBLE) {
            //hideControllers();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.809 -0400", hash_original_method = "B1100F7CC0894E179F002CED35623F94", hash_generated_method = "7326FA68EB3D2B7287F66A500889967C")
    public void clearComposingText() {
        {
            BaseInputConnection.removeComposingSpans((Spannable)mText);
        } //End block
        // ---------- Original Method ----------
        //if (mText instanceof Spannable) {
            //BaseInputConnection.removeComposingSpans((Spannable)mText);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.810 -0400", hash_original_method = "D9A75FFCA0200824B6C25D7D7E778114", hash_generated_method = "C0B03DE47DFBCB1F53B21EFF7140FCED")
    @Override
    public void setSelected(boolean selected) {
        boolean wasSelected;
        wasSelected = isSelected();
        super.setSelected(selected);
        {
            {
                startMarquee();
            } //End block
            {
                stopMarquee();
            } //End block
        } //End block
        addTaint(selected);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.825 -0400", hash_original_method = "66B01BC66F894D20F58119BE8C84CE2C", hash_generated_method = "6FD1EA2367D2F6A8FF6CD7D562CEADFE")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int action;
        action = event.getActionMasked();
        {
            boolean varCA8C62D3CC4BCF9B6208820C93DA2727_251959942 = (hasSelectionController());
            {
                getSelectionController().onTouchEvent(event);
            } //End block
        } //End collapsed parenthetic
        {
            mLastDownPositionX = event.getX();
            mLastDownPositionY = event.getY();
            mTouchFocusSelected = false;
            mIgnoreActionUpEvent = false;
        } //End block
        boolean superResult;
        superResult = super.onTouchEvent(event);
        {
            mDiscardNextActionUp = false;
        } //End block
        boolean touchIsFinished;
        touchIsFinished = (action == MotionEvent.ACTION_UP) &&
                !shouldIgnoreActionUpEvent() && isFocused();
        {
            boolean var20D4C59FE6C285ECEE884C522E960420_1784884198 = ((mMovement != null || onCheckIsTextEditor()) && isEnabled()
                && mText instanceof Spannable && mLayout != null);
            {
                boolean handled;
                handled = false;
                {
                    handled |= mMovement.onTouchEvent(this, (Spannable) mText, event);
                } //End block
                {
                    ClickableSpan[] links;
                    links = ((Spannable) mText).getSpans(getSelectionStart(),
                        getSelectionEnd(), ClickableSpan.class);
                    {
                        links[0].onClick(this);
                        handled = true;
                    } //End block
                } //End block
                {
                    boolean varA138BB91854FD0E07817A4930DAB4E64_238332281 = (touchIsFinished && (isTextEditable() || mTextIsSelectable));
                    {
                        InputMethodManager imm;
                        imm = InputMethodManager.peekInstance();
                        viewClicked(imm);
                        {
                            handled |= imm != null && imm.showSoftInput(this, 0);
                        } //End block
                        boolean selectAllGotFocus;
                        selectAllGotFocus = mSelectAllOnFocus && didTouchFocusSelect();
                        hideControllers();
                        {
                            boolean varC8FC4D62C210E65C8DA1490C44E99120_1725221005 = (!selectAllGotFocus && mText.length() > 0);
                            {
                                {
                                    mSpellChecker.onSelectionChanged();
                                } //End block
                                {
                                    boolean var1CF112AAAC5F75383DBE7BFFD7531552_2009345608 = (!extractedTextModeWillBeStarted());
                                    {
                                        {
                                            boolean var60BC98927E3B58E7C5E7F75DDA71E61E_786574888 = (isCursorInsideEasyCorrectionSpan());
                                            {
                                                showSuggestions();
                                            } //End block
                                            {
                                                boolean varB6DE6ED2562A6539C8A95CCE9438A153_612593586 = (hasInsertionController());
                                                {
                                                    getInsertionController().show();
                                                } //End block
                                            } //End collapsed parenthetic
                                        } //End collapsed parenthetic
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                        handled = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_893086814 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_893086814;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.826 -0400", hash_original_method = "03AC5F43014CB2A7B3EC5095819B8787", hash_generated_method = "77F7D513288785A4911ECF0E6BE83090")
    private boolean isCursorInsideSuggestionSpan() {
        SuggestionSpan[] suggestionSpans;
        suggestionSpans = ((Spannable) mText).getSpans(getSelectionStart(),
                getSelectionEnd(), SuggestionSpan.class);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1401881089 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1401881089;
        // ---------- Original Method ----------
        //if (!(mText instanceof Spannable)) return false;
        //SuggestionSpan[] suggestionSpans = ((Spannable) mText).getSpans(getSelectionStart(),
                //getSelectionEnd(), SuggestionSpan.class);
        //return (suggestionSpans.length > 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.827 -0400", hash_original_method = "FDBB0D2E258BF757A8B32CAC4ADCAFC2", hash_generated_method = "D6989BAB3C41FCB1A866479C2E6B15EA")
    private boolean isCursorInsideEasyCorrectionSpan() {
        Spannable spannable;
        spannable = (Spannable) mText;
        SuggestionSpan[] suggestionSpans;
        suggestionSpans = spannable.getSpans(getSelectionStart(),
                getSelectionEnd(), SuggestionSpan.class);
        {
            int i;
            i = 0;
            {
                {
                    boolean var2346E33123BC41A418719A614F5A6DD6_1931306224 = ((suggestionSpans[i].getFlags() & SuggestionSpan.FLAG_EASY_CORRECT) != 0);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_278693474 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_278693474;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.827 -0400", hash_original_method = "B422CE655E2FA1B2DED230B806484199", hash_generated_method = "0A559A7FAC9EA69A96CC73F8A5F42A64")
    private void downgradeEasyCorrectionSpans() {
        {
            Spannable spannable;
            spannable = (Spannable) mText;
            SuggestionSpan[] suggestionSpans;
            suggestionSpans = spannable.getSpans(0,
                    spannable.length(), SuggestionSpan.class);
            {
                int i;
                i = 0;
                {
                    int flags;
                    flags = suggestionSpans[i].getFlags();
                    {
                        flags &= ~SuggestionSpan.FLAG_EASY_CORRECT;
                        suggestionSpans[i].setFlags(flags);
                    } //End block
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.832 -0400", hash_original_method = "F41FEEC7411770322E4286C20722D03F", hash_generated_method = "23CAA25B1C1FB92C23D522523477DDC3")
    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            try 
            {
                {
                    boolean var8B12764D2A804081F5E2F3C6ECF4057D_1198712752 = (mMovement.onGenericMotionEvent(this, (Spannable) mText, event));
                } //End collapsed parenthetic
            } //End block
            catch (AbstractMethodError ex)
            { }
        } //End block
        boolean var32C1E3DF40BCC120C79428C7AEB27DD1_1482065053 = (super.onGenericMotionEvent(event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1796312304 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1796312304;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.835 -0400", hash_original_method = "1022846F3BD24E55F7B42FF144EBDE9C", hash_generated_method = "849AF7208BC2DCF3552FDD801F81866B")
    private void prepareCursorControllers() {
        boolean windowSupportsHandles;
        windowSupportsHandles = false;
        ViewGroup.LayoutParams params;
        params = getRootView().getLayoutParams();
        {
            WindowManager.LayoutParams windowParams;
            windowParams = (WindowManager.LayoutParams) params;
            windowSupportsHandles = windowParams.type < WindowManager.LayoutParams.FIRST_SUB_WINDOW
                    || windowParams.type > WindowManager.LayoutParams.LAST_SUB_WINDOW;
        } //End block
        mInsertionControllerEnabled = windowSupportsHandles && isCursorVisible() && mLayout != null;
        mSelectionControllerEnabled = windowSupportsHandles && textCanBeSelected() &&
                mLayout != null;
        {
            hideInsertionPointCursorController();
            {
                mInsertionPointCursorController.onDetached();
                mInsertionPointCursorController = null;
            } //End block
        } //End block
        {
            stopSelectionActionMode();
            {
                mSelectionModifierCursorController.onDetached();
                mSelectionModifierCursorController = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.836 -0400", hash_original_method = "5768F33DD15C2D6A1E8DF566C117D02C", hash_generated_method = "CA98C4FF2D98C70FA724983F11F9DBF0")
    private boolean isTextEditable() {
        boolean varE3EE8DDB74DAF8872FE53127269AB9E6_2134509268 = (mText instanceof Editable && onCheckIsTextEditor() && isEnabled());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2112053706 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2112053706;
        // ---------- Original Method ----------
        //return mText instanceof Editable && onCheckIsTextEditor() && isEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.836 -0400", hash_original_method = "319EEEA24E78F0A8A97E7B3282410D43", hash_generated_method = "7C4BC938E70724E0EC09146EA4292CB3")
    public boolean didTouchFocusSelect() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1199214352 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1199214352;
        // ---------- Original Method ----------
        //return mTouchFocusSelected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.842 -0400", hash_original_method = "F8EF60C67754333637E515F4BC0EB2C7", hash_generated_method = "3F8E08FFCA833AB1C4B66C0BC80B43D3")
    @Override
    public void cancelLongPress() {
        super.cancelLongPress();
        mIgnoreActionUpEvent = true;
        // ---------- Original Method ----------
        //super.cancelLongPress();
        //mIgnoreActionUpEvent = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.842 -0400", hash_original_method = "1EBA305C38503D593DE5ED34528F31AE", hash_generated_method = "C7934B986E8F29D1EFB26B04B6448976")
    public boolean shouldIgnoreActionUpEvent() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_851178366 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_851178366;
        // ---------- Original Method ----------
        //return mIgnoreActionUpEvent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.845 -0400", hash_original_method = "2ED59B8CED9712CD9EFEA3386ABFE955", hash_generated_method = "A78753EA1BAAE6F4EEAEA2421E9DE58D")
    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            {
                boolean var8C6289BC177E1FC846FED60E961858F7_92631783 = (mMovement.onTrackballEvent(this, (Spannable) mText, event));
            } //End collapsed parenthetic
        } //End block
        boolean var52056F11E16FA151938F980C67CD97F9_1173269551 = (super.onTrackballEvent(event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1726706378 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1726706378;
        // ---------- Original Method ----------
        //if (mMovement != null && mText instanceof Spannable &&
            //mLayout != null) {
            //if (mMovement.onTrackballEvent(this, (Spannable) mText, event)) {
                //return true;
            //}
        //}
        //return super.onTrackballEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.846 -0400", hash_original_method = "9E4C5FDADE7CEAD68CF365879A643A39", hash_generated_method = "6C45AED54B369950A87890A84980C656")
    public void setScroller(Scroller s) {
        mScroller = s;
        // ---------- Original Method ----------
        //mScroller = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.847 -0400", hash_original_method = "D90D14C34AE2DD19EDEA4AA99DD580AF", hash_generated_method = "120C6B4880277EA27E2CC4B7D4A1245B")
    private boolean shouldBlink() {
        {
            boolean var4ABCBE6852627F4B46FBEF2A6A4ECCCA_1492419168 = (!isFocused());
        } //End collapsed parenthetic
        int start;
        start = getSelectionStart();
        int end;
        end = getSelectionEnd();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1683127726 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1683127726;
        // ---------- Original Method ----------
        //if (!isFocused()) return false;
        //final int start = getSelectionStart();
        //if (start < 0) return false;
        //final int end = getSelectionEnd();
        //if (end < 0) return false;
        //return start == end;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.853 -0400", hash_original_method = "D1BDF909CEA832525561C896748DB631", hash_generated_method = "987D52D01DB865A2858585A2484D839A")
    private void makeBlink() {
        {
            boolean var36B9A155CA4AF19B05F2985EF7AEDB1C_816382225 = (isCursorVisible());
            {
                {
                    boolean var1E1DE2716F3F9B589A087F50D1F61A8B_882259967 = (shouldBlink());
                    {
                        mShowCursor = SystemClock.uptimeMillis();
                        mBlink = new Blink(this);
                        mBlink.removeCallbacks(mBlink);
                        mBlink.postAtTime(mBlink, mShowCursor + BLINK);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                mBlink.removeCallbacks(mBlink);
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.855 -0400", hash_original_method = "2371CC9F994A54DD5E29CBD2552784AA", hash_generated_method = "412EB4883B56F3E67DAC976DB941E9A4")
    @Override
    protected float getLeftFadingEdgeStrength() {
        {
            {
                boolean var48B2E39505E7202B89848EF3423B9152_663061362 = (mMarquee != null && !mMarquee.isStopped());
                {
                    Marquee marquee;
                    marquee = mMarquee;
                    {
                        boolean var9BA25C39B44D42503DBE86D96DDE3F89_1415515923 = (marquee.shouldDrawLeftFade());
                        {
                            float varACB89E3006AD14B300166FDE2E87A6BF_1576568437 = (marquee.mScroll / getHorizontalFadingEdgeLength());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean varB42567ABE2BADBC605E1B78E45085C46_382633190 = (getLineCount() == 1);
                    {
                        int layoutDirection;
                        layoutDirection = getResolvedLayoutDirection();
                        int absoluteGravity;
                        absoluteGravity = Gravity.getAbsoluteGravity(mGravity, layoutDirection);
                        //Begin case Gravity.RIGHT 
                        float var77CC60141975FCCCD80D9A2419BB6C1C_1815430096 = ((mLayout.getLineRight(0) - (mRight - mLeft) -
                                getCompoundPaddingLeft() - getCompoundPaddingRight() -
                                mLayout.getLineLeft(0)) / getHorizontalFadingEdgeLength());
                        //End case Gravity.RIGHT 
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        float var4F5C2129A9FDB4D7873C15071EC74FAF_766662894 = (super.getLeftFadingEdgeStrength());
        float var546ADE640B6EDFBC8A086EF31347E768_2109331096 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2109331096;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.857 -0400", hash_original_method = "7D05EA9E8579412E6DC4A8392EC7FDC2", hash_generated_method = "26292E8D3F0617EA928955D856C36243")
    @Override
    protected float getRightFadingEdgeStrength() {
        {
            {
                boolean var48B2E39505E7202B89848EF3423B9152_568489765 = (mMarquee != null && !mMarquee.isStopped());
                {
                    Marquee marquee;
                    marquee = mMarquee;
                    float var5FA73A5ADF77E0C7B666EC3867F0A8A9_389744778 = ((marquee.mMaxFadeScroll - marquee.mScroll) / getHorizontalFadingEdgeLength());
                } //End block
                {
                    boolean varB42567ABE2BADBC605E1B78E45085C46_37862441 = (getLineCount() == 1);
                    {
                        int layoutDirection;
                        layoutDirection = getResolvedLayoutDirection();
                        int absoluteGravity;
                        absoluteGravity = Gravity.getAbsoluteGravity(mGravity, layoutDirection);
                        //Begin case Gravity.LEFT 
                        int textWidth;
                        textWidth = (mRight - mLeft) - getCompoundPaddingLeft() -
                                getCompoundPaddingRight();
                        //End case Gravity.LEFT 
                        //Begin case Gravity.LEFT 
                        float lineWidth;
                        lineWidth = mLayout.getLineWidth(0);
                        //End case Gravity.LEFT 
                        //Begin case Gravity.LEFT 
                        float varE0BE637D155EE291A7CF14784CC269F6_1651129722 = ((lineWidth - textWidth) / getHorizontalFadingEdgeLength());
                        //End case Gravity.LEFT 
                        //Begin case Gravity.CENTER_HORIZONTAL Gravity.FILL_HORIZONTAL 
                        float varDB511E24CC8812A21F30B808ED92516B_1040030530 = ((mLayout.getLineWidth(0) - ((mRight - mLeft) -
                                getCompoundPaddingLeft() - getCompoundPaddingRight())) /
                                getHorizontalFadingEdgeLength());
                        //End case Gravity.CENTER_HORIZONTAL Gravity.FILL_HORIZONTAL 
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        float var23E074F03E79DB75514A1493E85330EB_710813090 = (super.getRightFadingEdgeStrength());
        float var546ADE640B6EDFBC8A086EF31347E768_805987257 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_805987257;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.863 -0400", hash_original_method = "A3B3BBCD8F5911495212C23A0CDB87AF", hash_generated_method = "B63360BF8B012B347B184E48C79D03DD")
    @Override
    protected int computeHorizontalScrollRange() {
        {
            {
                Object varB9E01A838DEDF048798537932C3D53D0_238618195 = ((int) mLayout.getLineWidth(0));
                Object var48F73E2237CC10856F86F9441A565829_201701189 = (mLayout.getWidth());
            } //End flattened ternary
        } //End block
        int varED0C9CF0B7C065764BC0B4CBB9BD10B1_1106303540 = (super.computeHorizontalScrollRange());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2026384596 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2026384596;
        // ---------- Original Method ----------
        //if (mLayout != null) {
            //return mSingleLine && (mGravity & Gravity.HORIZONTAL_GRAVITY_MASK) == Gravity.LEFT ?
                    //(int) mLayout.getLineWidth(0) : mLayout.getWidth();
        //}
        //return super.computeHorizontalScrollRange();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.863 -0400", hash_original_method = "FD0A725F27B0D409B10AFF4BD8232C49", hash_generated_method = "2CF95B2F404DFD0233AC609BAE219ADA")
    @Override
    protected int computeVerticalScrollRange() {
        int varEEB54A75518B385B09E35C2F7B0BB4DB_384678058 = (mLayout.getHeight());
        int var06B1DFE229A17C2C5018936314B519D0_1536367162 = (super.computeVerticalScrollRange());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_303234474 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_303234474;
        // ---------- Original Method ----------
        //if (mLayout != null)
            //return mLayout.getHeight();
        //return super.computeVerticalScrollRange();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.865 -0400", hash_original_method = "9A16EAE7151454D3FA35454A6C3BB413", hash_generated_method = "C76182F0E4F4F95E5BB18278760FF6EC")
    @Override
    protected int computeVerticalScrollExtent() {
        int var3D22FDF56C8F597D4B164222BB4A2F41_269621767 = (getHeight() - getCompoundPaddingTop() - getCompoundPaddingBottom());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1836322445 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1836322445;
        // ---------- Original Method ----------
        //return getHeight() - getCompoundPaddingTop() - getCompoundPaddingBottom();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.865 -0400", hash_original_method = "AF6DED1CDDAE4FEC9AD8DCCD50DF8C26", hash_generated_method = "29A82547856ACF608CBE2C78A417BFFB")
    @Override
    public void findViewsWithText(ArrayList<View> outViews, CharSequence searched, int flags) {
        super.findViewsWithText(outViews, searched, flags);
        {
            boolean var87A9E824D7926B465D9F8E23653E1606_931494591 = (!outViews.contains(this) && (flags & FIND_VIEWS_WITH_TEXT) != 0
                && !TextUtils.isEmpty(searched) && !TextUtils.isEmpty(mText));
            {
                String searchedLowerCase;
                searchedLowerCase = searched.toString().toLowerCase();
                String textLowerCase;
                textLowerCase = mText.toString().toLowerCase();
                {
                    boolean var4E8F3CA643822EB3D628A081C82F102F_761422373 = (textLowerCase.contains(searchedLowerCase));
                    {
                        outViews.add(this);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(outViews.getTaint());
        addTaint(searched.getTaint());
        addTaint(flags);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.873 -0400", hash_original_method = "9DEDF12E7A1F2B52484CF7C1E98D635C", hash_generated_method = "39035706FC4F2750FBD90059732C8A5E")
    @Override
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int filteredMetaState;
        filteredMetaState = event.getMetaState() & ~KeyEvent.META_CTRL_MASK;
        {
            boolean varC56AADD2FE16B97F2C4A1A86C8CB9277_1472245599 = (KeyEvent.metaStateHasNoModifiers(filteredMetaState));
            {
                //Begin case KeyEvent.KEYCODE_A 
                {
                    boolean var2C54826044A6A463985C967714461581_250408400 = (canSelectText());
                    {
                        boolean varEB35FFB1E0BAFF4B98799DF0DAE3AD9A_2028403682 = (onTextContextMenuItem(ID_SELECT_ALL));
                    } //End block
                } //End collapsed parenthetic
                //End case KeyEvent.KEYCODE_A 
                //Begin case KeyEvent.KEYCODE_X 
                {
                    boolean varD70E317BC144C26B73AA08B3BA3A1DF7_434156767 = (canCut());
                    {
                        boolean varF1F4885B43FDB12CD2347207BFCBE15D_1702386466 = (onTextContextMenuItem(ID_CUT));
                    } //End block
                } //End collapsed parenthetic
                //End case KeyEvent.KEYCODE_X 
                //Begin case KeyEvent.KEYCODE_C 
                {
                    boolean var64A51BC817B541ED78EC45FE802A582B_1456902824 = (canCopy());
                    {
                        boolean var7EC513D62717566DFF11F991DB68179B_1788335062 = (onTextContextMenuItem(ID_COPY));
                    } //End block
                } //End collapsed parenthetic
                //End case KeyEvent.KEYCODE_C 
                //Begin case KeyEvent.KEYCODE_V 
                {
                    boolean varB590DB230E7D99BE97C8070362518C3D_1970237228 = (canPaste());
                    {
                        boolean varB380C053436C26C9F75D58F60AA0273E_1422622948 = (onTextContextMenuItem(ID_PASTE));
                    } //End block
                } //End collapsed parenthetic
                //End case KeyEvent.KEYCODE_V 
            } //End block
        } //End collapsed parenthetic
        boolean var18CCACF7413D8761F4926498DDE0852A_383069655 = (super.onKeyShortcut(keyCode, event));
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1685835405 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1685835405;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.881 -0400", hash_original_method = "CD8FD18ADF4940449D6A099035EC8FE9", hash_generated_method = "93FE126C95A43D942BE75B9DFDD7CF51")
    private boolean canSelectText() {
        boolean var45174109A5D4D4DED4D6B043F4737E70_403470721 = (hasSelectionController() && mText.length() != 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_72478688 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_72478688;
        // ---------- Original Method ----------
        //return hasSelectionController() && mText.length() != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.881 -0400", hash_original_method = "09898B129565A0932D7F5D96EEC9BB39", hash_generated_method = "665091994DC720D4F4A6863076EEC4A0")
    private boolean textCanBeSelected() {
        {
            boolean var0579FE66F74E6B0CAEB7B0FFED7BF6F0_897498632 = (mMovement == null || !mMovement.canSelectArbitrarily());
        } //End collapsed parenthetic
        boolean varEA838F60BF8890D30F87CAA0AEA5A5AD_209792583 = (isTextEditable() || (mTextIsSelectable && mText instanceof Spannable && isEnabled()));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1422807520 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1422807520;
        // ---------- Original Method ----------
        //if (mMovement == null || !mMovement.canSelectArbitrarily()) return false;
        //return isTextEditable() || (mTextIsSelectable && mText instanceof Spannable && isEnabled());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.881 -0400", hash_original_method = "5A8A75E52337470DA5834210CD94E844", hash_generated_method = "1FEDABE5B4ED8843751D051A08169917")
    private boolean canCut() {
        {
            boolean varAFBCCFFAA18696A12B6915A938CC8475_636642532 = (hasPasswordTransformationMethod());
        } //End collapsed parenthetic
        {
            boolean varDFBD28C454DECC5A34D6B1D50ACA53BA_2127977184 = (mText.length() > 0 && hasSelection() && mText instanceof Editable && mInput != null);
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_250852722 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_250852722;
        // ---------- Original Method ----------
        //if (hasPasswordTransformationMethod()) {
            //return false;
        //}
        //if (mText.length() > 0 && hasSelection() && mText instanceof Editable && mInput != null) {
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.882 -0400", hash_original_method = "C5BA619EC7C225A5F87BCD822F6EF570", hash_generated_method = "BE66F37F9EF2DAD323D4CC4936D10D7E")
    private boolean canCopy() {
        {
            boolean varAFBCCFFAA18696A12B6915A938CC8475_1725230606 = (hasPasswordTransformationMethod());
        } //End collapsed parenthetic
        {
            boolean varCAC8FC6B32A4536E20AA1AECC8F0BAF1_787331637 = (mText.length() > 0 && hasSelection());
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_256873837 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_256873837;
        // ---------- Original Method ----------
        //if (hasPasswordTransformationMethod()) {
            //return false;
        //}
        //if (mText.length() > 0 && hasSelection()) {
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.882 -0400", hash_original_method = "4C1E94F781705995B290C548A8DF616E", hash_generated_method = "C022144CE2F2D76A80590BE6A345B0E3")
    private boolean canPaste() {
        boolean varE457499D879154E36F02FF3DB5A1ED3A_390831863 = ((mText instanceof Editable &&
                mInput != null &&
                getSelectionStart() >= 0 &&
                getSelectionEnd() >= 0 &&
                ((ClipboardManager)getContext().getSystemService(Context.CLIPBOARD_SERVICE)).
                hasPrimaryClip()));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_691292471 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_691292471;
        // ---------- Original Method ----------
        //return (mText instanceof Editable &&
                //mInput != null &&
                //getSelectionStart() >= 0 &&
                //getSelectionEnd() >= 0 &&
                //((ClipboardManager)getContext().getSystemService(Context.CLIPBOARD_SERVICE)).
                //hasPrimaryClip());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.884 -0400", hash_original_method = "493FC66F8A7ACF6A75CECBBBC666AB3C", hash_generated_method = "1EA05E59AF3BCFA3615109E8F8D908BF")
    private boolean selectAll() {
        int length;
        length = mText.length();
        Selection.setSelection((Spannable) mText, 0, length);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1682890928 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1682890928;
        // ---------- Original Method ----------
        //final int length = mText.length();
        //Selection.setSelection((Spannable) mText, 0, length);
        //return length > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.887 -0400", hash_original_method = "B770D2F4FC63A979B3CD07A81B20384D", hash_generated_method = "B815B67C2BB6C6C266F954128904B622")
    private boolean selectCurrentWord() {
        {
            boolean varDED1C694F054C8DDF1A29A76C5F20F19_2082975604 = (!canSelectText());
        } //End collapsed parenthetic
        {
            boolean varAFBCCFFAA18696A12B6915A938CC8475_1505191689 = (hasPasswordTransformationMethod());
            {
                boolean varE332F16868C9FD223E86B20517E855EF_469401509 = (selectAll());
            } //End block
        } //End collapsed parenthetic
        int klass;
        klass = mInputType & InputType.TYPE_MASK_CLASS;
        int variation;
        variation = mInputType & InputType.TYPE_MASK_VARIATION;
        {
            boolean varA650E26BD9A4F09AA14DDEB72540C88C_1625870084 = (selectAll());
        } //End block
        long lastTouchOffsets;
        lastTouchOffsets = getLastTouchOffsets();
        int minOffset;
        minOffset = extractRangeStartFromLong(lastTouchOffsets);
        int maxOffset;
        maxOffset = extractRangeEndFromLong(lastTouchOffsets);
        {
            boolean var7155FC6291E75A72164AEF06E53012B4_2101414621 = (minOffset < 0 || minOffset >= mText.length());
        } //End collapsed parenthetic
        {
            boolean var1D5071A17653318C6F5B2B7CEE876EF7_664748275 = (maxOffset < 0 || maxOffset >= mText.length());
        } //End collapsed parenthetic
        int selectionStart, selectionEnd;
        URLSpan[] urlSpans;
        urlSpans = ((Spanned) mText).getSpans(minOffset, maxOffset, URLSpan.class);
        {
            URLSpan urlSpan;
            urlSpan = urlSpans[0];
            selectionStart = ((Spanned) mText).getSpanStart(urlSpan);
            selectionEnd = ((Spanned) mText).getSpanEnd(urlSpan);
        } //End block
        {
            WordIterator wordIterator;
            wordIterator = getWordIterator();
            wordIterator.setCharSequence(mText, minOffset, maxOffset);
            selectionStart = wordIterator.getBeginning(minOffset);
            selectionEnd = wordIterator.getEnd(maxOffset);
            {
                long range;
                range = getCharRange(selectionStart);
                selectionStart = extractRangeStartFromLong(range);
                selectionEnd = extractRangeEndFromLong(range);
            } //End block
        } //End block
        Selection.setSelection((Spannable) mText, selectionStart, selectionEnd);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_950709183 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_950709183;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.904 -0400", hash_original_method = "9DCEB61D4BC0794F06560CB12151C0AA", hash_generated_method = "14BF814FEE20281DEDC96B3C75C7BC5D")
    public Locale getTextServicesLocale() {
        Locale varB4EAC82CA7396A68D541C85D26508E83_1815514432 = null; //Variable for return #1
        Locale locale;
        locale = Locale.getDefault();
        TextServicesManager textServicesManager;
        textServicesManager = (TextServicesManager)
                mContext.getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE);
        SpellCheckerSubtype subtype;
        subtype = textServicesManager.getCurrentSpellCheckerSubtype(true);
        {
            locale = new Locale(subtype.getLocale());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1815514432 = locale;
        varB4EAC82CA7396A68D541C85D26508E83_1815514432.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1815514432;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.905 -0400", hash_original_method = "84E4450A5BCA42ECDB6E0E833B2BF3C6", hash_generated_method = "00A6EC577A937BD6BC25376AD1589672")
     void onLocaleChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mWordIterator = null;
        // ---------- Original Method ----------
        //mWordIterator = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.905 -0400", hash_original_method = "D7DB0153FBA43371270FE2DB428D268F", hash_generated_method = "E17FC8CD37D940840EF7B8307B0D1EC6")
    public WordIterator getWordIterator() {
        WordIterator varB4EAC82CA7396A68D541C85D26508E83_175505719 = null; //Variable for return #1
        {
            mWordIterator = new WordIterator(getTextServicesLocale());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_175505719 = mWordIterator;
        varB4EAC82CA7396A68D541C85D26508E83_175505719.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_175505719;
        // ---------- Original Method ----------
        //if (mWordIterator == null) {
            //mWordIterator = new WordIterator(getTextServicesLocale());
        //}
        //return mWordIterator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.910 -0400", hash_original_method = "B4D83E103073E3F8ED3897EF06B95E07", hash_generated_method = "91E6A2D5E070A3DA37CBDCBE6685EB3E")
    private long getCharRange(int offset) {
        int textLength;
        textLength = mText.length();
        {
            char currentChar;
            currentChar = mText.charAt(offset);
            char nextChar;
            nextChar = mText.charAt(offset + 1);
            {
                boolean varD9CF44D283E0863128B66037E6BFB8CF_1933475957 = (Character.isSurrogatePair(currentChar, nextChar));
                {
                    long varDEC17ADCE274EF4E4EA0CD9ABF597677_1495553708 = (packRangeInLong(offset,  offset + 2));
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            long var4A76496E7082009E497234E69A837D4C_451728491 = (packRangeInLong(offset,  offset + 1));
        } //End block
        {
            char previousChar;
            previousChar = mText.charAt(offset - 1);
            char previousPreviousChar;
            previousPreviousChar = mText.charAt(offset - 2);
            {
                boolean var08ECDF9036721977163DCB5E7280D7DA_1772918294 = (Character.isSurrogatePair(previousPreviousChar, previousChar));
                {
                    long var579E9393D23E6CD1E4A1644DEA02C196_1457513058 = (packRangeInLong(offset - 2,  offset));
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            long var7F931D32D69CE46E71E33A6E014D5A4B_987744564 = (packRangeInLong(offset - 1,  offset));
        } //End block
        long var1DBEC51B3461A29B2118BF318D35E0B5_1181443380 = (packRangeInLong(offset,  offset));
        addTaint(offset);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_181245454 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_181245454;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.910 -0400", hash_original_method = "C07E078EE2A4D1805F6BF366C72ED78F", hash_generated_method = "F20C5C5F92EC74A595EB89F405A78ED6")
    private long getLastTouchOffsets() {
        SelectionModifierCursorController selectionController;
        selectionController = getSelectionController();
        int minOffset;
        minOffset = selectionController.getMinTouchOffset();
        int maxOffset;
        maxOffset = selectionController.getMaxTouchOffset();
        long var6C22B70D609AA0EDBEA57BAC907EBF70_540714188 = (packRangeInLong(minOffset, maxOffset));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_79634185 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_79634185;
        // ---------- Original Method ----------
        //SelectionModifierCursorController selectionController = getSelectionController();
        //final int minOffset = selectionController.getMinTouchOffset();
        //final int maxOffset = selectionController.getMaxTouchOffset();
        //return packRangeInLong(minOffset, maxOffset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.911 -0400", hash_original_method = "A81C1729DD6237516D7BACF34829C51D", hash_generated_method = "004B9A2C04D22F1A8F370B0EE4BADDC4")
    @Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onPopulateAccessibilityEvent(event);
        boolean isPassword;
        isPassword = hasPasswordTransformationMethod();
        {
            CharSequence text;
            text = getTextForAccessibility();
            {
                boolean varE82D2DAF247906B4725B56EFEDF2A150_155159083 = (!TextUtils.isEmpty(text));
                {
                    event.getText().add(text);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(event.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.911 -0400", hash_original_method = "6FC069A7F29DA435C1F4CA8AC1DF9A7A", hash_generated_method = "56A6FB775EDACD8F18151D2C7F882D94")
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onInitializeAccessibilityEvent(event);
        boolean isPassword;
        isPassword = hasPasswordTransformationMethod();
        event.setPassword(isPassword);
        {
            boolean var9F2EDE90BC8D745F3A5915C44AB298CC_490160379 = (event.getEventType() == AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED);
            {
                event.setFromIndex(Selection.getSelectionStart(mText));
                event.setToIndex(Selection.getSelectionEnd(mText));
                event.setItemCount(mText.length());
            } //End block
        } //End collapsed parenthetic
        addTaint(event.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.916 -0400", hash_original_method = "305122B0EBB45F51524377B6AB6D9296", hash_generated_method = "C2C8709B49C4256D41E8C2AF14179511")
    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onInitializeAccessibilityNodeInfo(info);
        boolean isPassword;
        isPassword = hasPasswordTransformationMethod();
        {
            info.setText(getTextForAccessibility());
        } //End block
        info.setPassword(isPassword);
        addTaint(info.getTaint());
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityNodeInfo(info);
        //final boolean isPassword = hasPasswordTransformationMethod();
        //if (!isPassword) {
            //info.setText(getTextForAccessibility());
        //}
        //info.setPassword(isPassword);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.032 -0400", hash_original_method = "69E83CE4CD48DE4ECD21620922EFCC1A", hash_generated_method = "32B4485B97DCCD3D793C48F757BFDED3")
    @Override
    public void sendAccessibilityEvent(int eventType) {
        super.sendAccessibilityEvent(eventType);
        addTaint(eventType);
        // ---------- Original Method ----------
        //if (eventType == AccessibilityEvent.TYPE_VIEW_SCROLLED) {
            //return;
        //}
        //super.sendAccessibilityEvent(eventType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.032 -0400", hash_original_method = "8463B72D535FD98D84B93D99DA9D2B3A", hash_generated_method = "6C185982F60958F865DFE3F722CE9202")
    private CharSequence getTextForAccessibility() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_916206314 = null; //Variable for return #1
        CharSequence text;
        text = getText();
        {
            boolean var6C86A511CD0D2845B6E0259573F6A612_636183960 = (TextUtils.isEmpty(text));
            {
                text = getHint();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_916206314 = text;
        varB4EAC82CA7396A68D541C85D26508E83_916206314.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_916206314;
        // ---------- Original Method ----------
        //CharSequence text = getText();
        //if (TextUtils.isEmpty(text)) {
            //text = getHint();
        //}
        //return text;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.036 -0400", hash_original_method = "77215EF020F664C77A4E0174E763346B", hash_generated_method = "64A4598CCBECC3474449E676D5CC8A72")
     void sendAccessibilityEventTypeViewTextChanged(CharSequence beforeText,
            int fromIndex, int removedCount, int addedCount) {
        AccessibilityEvent event;
        event = AccessibilityEvent.obtain(AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED);
        event.setFromIndex(fromIndex);
        event.setRemovedCount(removedCount);
        event.setAddedCount(addedCount);
        event.setBeforeText(beforeText);
        sendAccessibilityEventUnchecked(event);
        addTaint(beforeText.getTaint());
        addTaint(fromIndex);
        addTaint(removedCount);
        addTaint(addedCount);
        // ---------- Original Method ----------
        //AccessibilityEvent event =
            //AccessibilityEvent.obtain(AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED);
        //event.setFromIndex(fromIndex);
        //event.setRemovedCount(removedCount);
        //event.setAddedCount(addedCount);
        //event.setBeforeText(beforeText);
        //sendAccessibilityEventUnchecked(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.036 -0400", hash_original_method = "10EC795892359880AFC1661A7060F8D4", hash_generated_method = "54B4C3C60569009C980EC17B81EE6E67")
    public boolean isInputMethodTarget() {
        InputMethodManager imm;
        imm = InputMethodManager.peekInstance();
        boolean var2E8BF75A8D890E760B8A4C35FF8B91BD_1758694840 = (imm != null && imm.isActive(this));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1280057726 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1280057726;
        // ---------- Original Method ----------
        //InputMethodManager imm = InputMethodManager.peekInstance();
        //return imm != null && imm.isActive(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.037 -0400", hash_original_method = "395A8406E426F55316A0BF37153197E7", hash_generated_method = "8670A8FCF903D91B5E52677353AB9D08")
    public boolean onTextContextMenuItem(int id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int min;
        min = 0;
        int max;
        max = mText.length();
        {
            boolean var1C23F183BE3EEE2A8667855A22865324_1057452005 = (isFocused());
            {
                int selStart;
                selStart = getSelectionStart();
                int selEnd;
                selEnd = getSelectionEnd();
                min = Math.max(0, Math.min(selStart, selEnd));
                max = Math.max(0, Math.max(selStart, selEnd));
            } //End block
        } //End collapsed parenthetic
        //Begin case ID_SELECT_ALL 
        selectAll();
        //End case ID_SELECT_ALL 
        //Begin case ID_PASTE 
        paste(min, max);
        //End case ID_PASTE 
        //Begin case ID_CUT 
        setPrimaryClip(ClipData.newPlainText(null, getTransformedText(min, max)));
        //End case ID_CUT 
        //Begin case ID_CUT 
        deleteText_internal(min, max);
        //End case ID_CUT 
        //Begin case ID_CUT 
        stopSelectionActionMode();
        //End case ID_CUT 
        //Begin case ID_COPY 
        setPrimaryClip(ClipData.newPlainText(null, getTransformedText(min, max)));
        //End case ID_COPY 
        //Begin case ID_COPY 
        stopSelectionActionMode();
        //End case ID_COPY 
        addTaint(id);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1813521561 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1813521561;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.037 -0400", hash_original_method = "FE79E6B9FD3BC9A3AB2F6DF9CAFCD48E", hash_generated_method = "6CB489D6B3AE856C57B514B5F83A48AF")
    private CharSequence getTransformedText(int start, int end) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_68756948 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_68756948 = removeSuggestionSpans(mTransformed.subSequence(start, end));
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_68756948.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_68756948;
        // ---------- Original Method ----------
        //return removeSuggestionSpans(mTransformed.subSequence(start, end));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.038 -0400", hash_original_method = "6ABCBA1E552641094DE1B3327AD7FDD1", hash_generated_method = "67874319F2EA67E273E5A9952FA6550E")
    private long prepareSpacesAroundPaste(int min, int max, CharSequence paste) {
        {
            boolean var350AE6B9AD47061FFDF129B7005A2411_998545458 = (paste.length() > 0);
            {
                {
                    char charBefore;
                    charBefore = mTransformed.charAt(min - 1);
                    char charAfter;
                    charAfter = paste.charAt(0);
                    {
                        boolean var3C202C664C757CF8D249A87B1D846040_496013957 = (Character.isSpaceChar(charBefore) && Character.isSpaceChar(charAfter));
                        {
                            int originalLength;
                            originalLength = mText.length();
                            deleteText_internal(min - 1, min);
                            int delta;
                            delta = mText.length() - originalLength;
                            min += delta;
                            max += delta;
                        } //End block
                        {
                            boolean varB469BF59168A8579CE9E3A2CAF0C1642_1919504166 = (!Character.isSpaceChar(charBefore) && charBefore != '\n' &&
                        !Character.isSpaceChar(charAfter) && charAfter != '\n');
                            {
                                int originalLength;
                                originalLength = mText.length();
                                replaceText_internal(min, min, " ");
                                int delta;
                                delta = mText.length() - originalLength;
                                min += delta;
                                max += delta;
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean varEEF1C48FC1D3D39DDF48A720B8628129_143774766 = (max < mText.length());
                    {
                        char charBefore;
                        charBefore = paste.charAt(paste.length() - 1);
                        char charAfter;
                        charAfter = mTransformed.charAt(max);
                        {
                            boolean varBF8E0F80E2B510B9D515C61513407B2D_110670852 = (Character.isSpaceChar(charBefore) && Character.isSpaceChar(charAfter));
                            {
                                deleteText_internal(max, max + 1);
                            } //End block
                            {
                                boolean var59E656C6DF389BAD07A380CF8AC3667A_975602115 = (!Character.isSpaceChar(charBefore) && charBefore != '\n' &&
                        !Character.isSpaceChar(charAfter) && charAfter != '\n');
                                {
                                    replaceText_internal(max, max, " ");
                                } //End block
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        long var541DF126AEC1F4495FAD956E97F187A7_849682650 = (packRangeInLong(min, max));
        addTaint(min);
        addTaint(max);
        addTaint(paste.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_739145975 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_739145975;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.040 -0400", hash_original_method = "E0F0E7304052F47B24D850362D52309F", hash_generated_method = "71C786AD1BCC4D8FE85B7C2516873664")
    private DragShadowBuilder getTextThumbnailBuilder(CharSequence text) {
        DragShadowBuilder varB4EAC82CA7396A68D541C85D26508E83_16427536 = null; //Variable for return #1
        TextView shadowView;
        shadowView = (TextView) inflate(mContext,
                com.android.internal.R.layout.text_drag_thumbnail, null);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unable to inflate text drag thumbnail");
        } //End block
        {
            boolean var8664184B362287947D63596A4517BCE2_1495253193 = (text.length() > DRAG_SHADOW_MAX_TEXT_LENGTH);
            {
                text = text.subSequence(0, DRAG_SHADOW_MAX_TEXT_LENGTH);
            } //End block
        } //End collapsed parenthetic
        shadowView.setText(text);
        shadowView.setTextColor(getTextColors());
        shadowView.setTextAppearance(mContext, R.styleable.Theme_textAppearanceLarge);
        shadowView.setGravity(Gravity.CENTER);
        shadowView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        int size;
        size = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        shadowView.measure(size, size);
        shadowView.layout(0, 0, shadowView.getMeasuredWidth(), shadowView.getMeasuredHeight());
        shadowView.invalidate();
        varB4EAC82CA7396A68D541C85D26508E83_16427536 = new DragShadowBuilder(shadowView);
        addTaint(text.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_16427536.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_16427536;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.041 -0400", hash_original_method = "FE9E03D9F3FD52DB88C5DE28D1E8768B", hash_generated_method = "EEDB1475902570368E152D045645A504")
    @Override
    public boolean performLongClick() {
        boolean handled;
        handled = false;
        boolean vibrate;
        vibrate = true;
        {
            boolean varC298D59926924FB0808A70DC864C4372_448282950 = (super.performLongClick());
            {
                mDiscardNextActionUp = true;
                handled = true;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varC22EC044E5AC4CF0B865C252AF7A9AA6_961752376 = (!handled && !isPositionOnText(mLastDownPositionX, mLastDownPositionY) &&
                mInsertionControllerEnabled);
            {
                int offset;
                offset = getOffsetForPosition(mLastDownPositionX, mLastDownPositionY);
                stopSelectionActionMode();
                Selection.setSelection((Spannable) mText, offset);
                getInsertionController().showWithActionPopup();
                handled = true;
                vibrate = false;
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean var6D40024296296040632FE8120E16CDA8_728589466 = (touchPositionIsInSelection());
                {
                    int start;
                    start = getSelectionStart();
                    int end;
                    end = getSelectionEnd();
                    CharSequence selectedText;
                    selectedText = getTransformedText(start, end);
                    ClipData data;
                    data = ClipData.newPlainText(null, selectedText);
                    DragLocalState localState;
                    localState = new DragLocalState(this, start, end);
                    startDrag(data, getTextThumbnailBuilder(selectedText), localState, 0);
                    stopSelectionActionMode();
                } //End block
                {
                    getSelectionController().hide();
                    selectCurrentWord();
                    getSelectionController().show();
                } //End block
            } //End collapsed parenthetic
            handled = true;
        } //End block
        {
            vibrate = handled = startSelectionActionMode();
        } //End block
        {
            performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
        } //End block
        {
            mDiscardNextActionUp = true;
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1698210955 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1698210955;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.042 -0400", hash_original_method = "227669F89CB3324004EC787BF93F591D", hash_generated_method = "C58ABB5A0612D9042E44007AFFCF7A8D")
    private boolean touchPositionIsInSelection() {
        int selectionStart;
        selectionStart = getSelectionStart();
        int selectionEnd;
        selectionEnd = getSelectionEnd();
        {
            int tmp;
            tmp = selectionStart;
            selectionStart = selectionEnd;
            selectionEnd = tmp;
            Selection.setSelection((Spannable) mText, selectionStart, selectionEnd);
        } //End block
        SelectionModifierCursorController selectionController;
        selectionController = getSelectionController();
        int minOffset;
        minOffset = selectionController.getMinTouchOffset();
        int maxOffset;
        maxOffset = selectionController.getMaxTouchOffset();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1661121180 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1661121180;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.063 -0400", hash_original_method = "A2BF41305999CD5C7E75DA3423749804", hash_generated_method = "A61BF3026CA3087C72A4BBF03115820C")
    private PositionListener getPositionListener() {
        PositionListener varB4EAC82CA7396A68D541C85D26508E83_11463110 = null; //Variable for return #1
        {
            mPositionListener = new PositionListener();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_11463110 = mPositionListener;
        varB4EAC82CA7396A68D541C85D26508E83_11463110.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_11463110;
        // ---------- Original Method ----------
        //if (mPositionListener == null) {
            //mPositionListener = new PositionListener();
        //}
        //return mPositionListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.065 -0400", hash_original_method = "23179C09AF51D00D4FCF53E6D8173595", hash_generated_method = "D2C0278FB5FFEC9480D9DA3A65209A3D")
    private boolean isPositionVisible(int positionX, int positionY) {
        {
            float[] position;
            position = sTmpPosition;
            position[0] = positionX;
            position[1] = positionY;
            View view;
            view = this;
            {
                {
                    boolean var5103DE2BDA9F56FC7E36F1B0BD1193A5_972476214 = (view != this);
                    {
                        position[0] -= view.getScrollX();
                        position[1] -= view.getScrollY();
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varCC3EA170661AE32B143B6B8CB851A271_734469448 = (position[0] < 0 || position[1] < 0 ||
                        position[0] > view.getWidth() || position[1] > view.getHeight());
                } //End collapsed parenthetic
                {
                    boolean var020714D8D65A6851489742B00823B874_518275959 = (!view.getMatrix().isIdentity());
                    {
                        view.getMatrix().mapPoints(position);
                    } //End block
                } //End collapsed parenthetic
                position[0] += view.getLeft();
                position[1] += view.getTop();
                ViewParent parent;
                parent = view.getParent();
                {
                    view = (View) parent;
                } //End block
                {
                    view = null;
                } //End block
            } //End block
        } //End block
        addTaint(positionX);
        addTaint(positionY);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_812414241 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_812414241;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.065 -0400", hash_original_method = "51F76D7934106C8713E6D720A3BD9BE7", hash_generated_method = "88F19E9A8F747B4EFD84B05AE77E7FEA")
    private boolean isOffsetVisible(int offset) {
        int line;
        line = mLayout.getLineForOffset(offset);
        int lineBottom;
        lineBottom = mLayout.getLineBottom(line);
        int primaryHorizontal;
        primaryHorizontal = (int) mLayout.getPrimaryHorizontal(offset);
        boolean varD4446F991D74BA64F3AC992B6F4738F8_1226475589 = (isPositionVisible(primaryHorizontal + viewportToContentHorizontalOffset(),
                lineBottom + viewportToContentVerticalOffset()));
        addTaint(offset);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1880984239 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1880984239;
        // ---------- Original Method ----------
        //final int line = mLayout.getLineForOffset(offset);
        //final int lineBottom = mLayout.getLineBottom(line);
        //final int primaryHorizontal = (int) mLayout.getPrimaryHorizontal(offset);
        //return isPositionVisible(primaryHorizontal + viewportToContentHorizontalOffset(),
                //lineBottom + viewportToContentVerticalOffset());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.065 -0400", hash_original_method = "8567BA4CA284138DD0CB4B48B9C8C278", hash_generated_method = "0842DFBF8109A1EA35E347B5A4D41A52")
    @Override
    protected void onScrollChanged(int horiz, int vert, int oldHoriz, int oldVert) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onScrollChanged(horiz, vert, oldHoriz, oldVert);
        {
            mPositionListener.onScrollChanged();
        } //End block
        addTaint(horiz);
        addTaint(vert);
        addTaint(oldHoriz);
        addTaint(oldVert);
        // ---------- Original Method ----------
        //super.onScrollChanged(horiz, vert, oldHoriz, oldVert);
        //if (mPositionListener != null) {
            //mPositionListener.onScrollChanged();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.066 -0400", hash_original_method = "9FAF02695A10AC660CF2B5DD3EDB7DD4", hash_generated_method = "F2A85A97E74D7DD70A4136CBCBAA4772")
     CharSequence removeSuggestionSpans(CharSequence text) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1099700205 = null; //Variable for return #1
        {
            Spannable spannable;
            {
                spannable = (Spannable) text;
            } //End block
            {
                spannable = new SpannableString(text);
                text = spannable;
            } //End block
            SuggestionSpan[] spans;
            spans = spannable.getSpans(0, text.length(), SuggestionSpan.class);
            {
                int i;
                i = 0;
                {
                    spannable.removeSpan(spans[i]);
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1099700205 = text;
        addTaint(text.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1099700205.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1099700205;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.067 -0400", hash_original_method = "97397C66433481C877E194A1E7813AF3", hash_generated_method = "8C09B45831F6B0FC0EEC21C59FB38634")
     void showSuggestions() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.067 -0400", hash_original_method = "E5A6F19BA20AF228602A3EAA320E6192", hash_generated_method = "65BD00298AA5EFDB4B7FD6F552A6D98E")
     boolean areSuggestionsShown() {
        boolean var29FA41D6182C8FCF2B2C7ECDA0C38EBD_1295491584 = (mSuggestionsPopupWindow != null && mSuggestionsPopupWindow.isShowing());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_769847032 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_769847032;
        // ---------- Original Method ----------
        //return mSuggestionsPopupWindow != null && mSuggestionsPopupWindow.isShowing();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.068 -0400", hash_original_method = "25A5AF708197CD0F2143471E812F624E", hash_generated_method = "E308FF08BC888700243EE0AC34C62C5A")
    public boolean isSuggestionsEnabled() {
        int variation;
        variation = mInputType & EditorInfo.TYPE_MASK_VARIATION;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_637729386 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_637729386;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.073 -0400", hash_original_method = "9876FACCD4EAE43EA4CB6FD414FD5E5A", hash_generated_method = "99F50FF2FBA3328523C1FCF161298BA2")
    public void setCustomSelectionActionModeCallback(ActionMode.Callback actionModeCallback) {
        mCustomSelectionActionModeCallback = actionModeCallback;
        // ---------- Original Method ----------
        //mCustomSelectionActionModeCallback = actionModeCallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.077 -0400", hash_original_method = "6671930C0B8994CBEF8AFBE835B485C8", hash_generated_method = "B6E67E038BE6E57ED5242EB844975808")
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        ActionMode.Callback varB4EAC82CA7396A68D541C85D26508E83_1891085762 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1891085762 = mCustomSelectionActionModeCallback;
        varB4EAC82CA7396A68D541C85D26508E83_1891085762.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1891085762;
        // ---------- Original Method ----------
        //return mCustomSelectionActionModeCallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.085 -0400", hash_original_method = "B9B1CE7E81D0AD0E9224682576CA1ABE", hash_generated_method = "751C53B3818140EB5C243CF611AA21CB")
    private boolean startSelectionActionMode() {
        {
            boolean varDD51C7CC25E36170CF1A5B45DEEBD783_1877168142 = (!canSelectText() || !requestFocus());
        } //End collapsed parenthetic
        {
            boolean varD18B2E3785F2697D3F393507C051114C_1944433806 = (!hasSelection());
            {
                {
                    boolean var2694D05A2D7BEB6A7092F61157ECE50C_1064103464 = (!selectCurrentWord());
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean willExtract;
        willExtract = extractedTextModeWillBeStarted();
        {
            ActionMode.Callback actionModeCallback;
            actionModeCallback = new SelectionActionModeCallback();
            mSelectionActionMode = startActionMode(actionModeCallback);
        } //End block
        boolean selectionStarted;
        selectionStarted = mSelectionActionMode != null || willExtract;
        {
            InputMethodManager imm;
            imm = InputMethodManager.peekInstance();
            {
                imm.showSoftInput(this, 0, null);
            } //End block
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_944791310 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_944791310;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.086 -0400", hash_original_method = "F292596F6DB6F0A1BCB4946717902139", hash_generated_method = "84ECE0643E178E916FB88531CD098FCB")
    private boolean extractedTextModeWillBeStarted() {
        {
            InputMethodManager imm;
            imm = InputMethodManager.peekInstance();
            boolean var2F4E2C66FC57F06F55546BB121BBAB53_2063140391 = (imm != null && imm.isFullscreenMode());
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1910129460 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1910129460;
        // ---------- Original Method ----------
        //if (!(this instanceof ExtractEditText)) {
            //final InputMethodManager imm = InputMethodManager.peekInstance();
            //return  imm != null && imm.isFullscreenMode();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.086 -0400", hash_original_method = "9843C3F333617B8C113B72E2C38319BA", hash_generated_method = "A0249CA7D39C0509B23718121E90129E")
    private void stopSelectionActionMode() {
        {
            mSelectionActionMode.finish();
        } //End block
        // ---------- Original Method ----------
        //if (mSelectionActionMode != null) {
            //mSelectionActionMode.finish();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.087 -0400", hash_original_method = "FD893A1B640E2E356DBE924FBE58EA4D", hash_generated_method = "D98F38EE84A4E23D9FE242C2C512E7FD")
    private void paste(int min, int max) {
        ClipboardManager clipboard;
        clipboard = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip;
        clip = clipboard.getPrimaryClip();
        {
            boolean didFirst;
            didFirst = false;
            {
                int i;
                i = 0;
                boolean varCF4CF6A541CEE14E85EAE2AF810764AC_607335231 = (i<clip.getItemCount());
                {
                    CharSequence paste;
                    paste = clip.getItemAt(i).coerceToText(getContext());
                    {
                        {
                            long minMax;
                            minMax = prepareSpacesAroundPaste(min, max, paste);
                            min = extractRangeStartFromLong(minMax);
                            max = extractRangeEndFromLong(minMax);
                            Selection.setSelection((Spannable) mText, max);
                            ((Editable) mText).replace(min, max, paste);
                            didFirst = true;
                        } //End block
                        {
                            ((Editable) mText).insert(getSelectionEnd(), "\n");
                            ((Editable) mText).insert(getSelectionEnd(), paste);
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
            stopSelectionActionMode();
            sLastCutOrCopyTime = 0;
        } //End block
        addTaint(min);
        addTaint(max);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.087 -0400", hash_original_method = "8BE6A63416328BC319B0B5D0DB32AF7B", hash_generated_method = "505EFA7BE2E4CB8DD6B03C13A0EA447C")
    private void setPrimaryClip(ClipData clip) {
        ClipboardManager clipboard;
        clipboard = (ClipboardManager) getContext().
                getSystemService(Context.CLIPBOARD_SERVICE);
        clipboard.setPrimaryClip(clip);
        sLastCutOrCopyTime = SystemClock.uptimeMillis();
        addTaint(clip.getTaint());
        // ---------- Original Method ----------
        //ClipboardManager clipboard = (ClipboardManager) getContext().
                //getSystemService(Context.CLIPBOARD_SERVICE);
        //clipboard.setPrimaryClip(clip);
        //sLastCutOrCopyTime = SystemClock.uptimeMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.099 -0400", hash_original_method = "EC32E229F62759229A3F9E53D2729660", hash_generated_method = "29E097B4A8943645223D542B5C9F2EB3")
    private void hideInsertionPointCursorController() {
        {
            mInsertionPointCursorController.hide();
        } //End block
        // ---------- Original Method ----------
        //if (mInsertionPointCursorController != null) {
            //mInsertionPointCursorController.hide();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.099 -0400", hash_original_method = "24BE7797312EE966374B6FFCFBB4586E", hash_generated_method = "957DAB26CB1B7753D50A6C44463DD0BC")
    private void hideControllers() {
        hideCursorControllers();
        hideSpanControllers();
        // ---------- Original Method ----------
        //hideCursorControllers();
        //hideSpanControllers();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.100 -0400", hash_original_method = "49CA1E2702021EF560B250FA375633C6", hash_generated_method = "DF3B309A0E8B4C37468C98D609346973")
    private void hideSpanControllers() {
        {
            mChangeWatcher.hideControllers();
        } //End block
        // ---------- Original Method ----------
        //if (mChangeWatcher != null) {
            //mChangeWatcher.hideControllers();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.100 -0400", hash_original_method = "1E18C93748F74C8EE354333AE329FDA3", hash_generated_method = "7123DCB72BA1C2EF01F67616494B2C2F")
    private void hideCursorControllers() {
        {
            boolean var97060A385B2EE20942D359972C3B987E_472828718 = (mSuggestionsPopupWindow != null && !mSuggestionsPopupWindow.isShowingUp());
            {
                mSuggestionsPopupWindow.hide();
            } //End block
        } //End collapsed parenthetic
        hideInsertionPointCursorController();
        stopSelectionActionMode();
        // ---------- Original Method ----------
        //if (mSuggestionsPopupWindow != null && !mSuggestionsPopupWindow.isShowingUp()) {
            //mSuggestionsPopupWindow.hide();
        //}
        //hideInsertionPointCursorController();
        //stopSelectionActionMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.100 -0400", hash_original_method = "3AC7FDA43CAD0B3033F953FC5E229096", hash_generated_method = "28315F25600D930736912AB22EC22673")
    public int getOffsetForPosition(float x, float y) {
        {
            boolean var778B744EBE60DF815BEE98852B413FC5_625457101 = (getLayout() == null);
        } //End collapsed parenthetic
        int line;
        line = getLineAtCoordinate(y);
        int offset;
        offset = getOffsetAtCoordinate(line, x);
        addTaint(x);
        addTaint(y);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1790564337 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1790564337;
        // ---------- Original Method ----------
        //if (getLayout() == null) return -1;
        //final int line = getLineAtCoordinate(y);
        //final int offset = getOffsetAtCoordinate(line, x);
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.101 -0400", hash_original_method = "C0F2EACF537DEE598E512FB7710303B4", hash_generated_method = "F8E2CDB140C40EBF455F4BA2350439ED")
    private float convertToLocalHorizontalCoordinate(float x) {
        x -= getTotalPaddingLeft();
        x = Math.max(0.0f, x);
        x = Math.min(getWidth() - getTotalPaddingRight() - 1, x);
        x += getScrollX();
        addTaint(x);
        float var546ADE640B6EDFBC8A086EF31347E768_1863607119 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1863607119;
        // ---------- Original Method ----------
        //x -= getTotalPaddingLeft();
        //x = Math.max(0.0f, x);
        //x = Math.min(getWidth() - getTotalPaddingRight() - 1, x);
        //x += getScrollX();
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.102 -0400", hash_original_method = "69F0EDA2749521F4A39C0BEAC846F1E5", hash_generated_method = "D65B8E2B64CE13C837D53B5915DDDCAE")
    private int getLineAtCoordinate(float y) {
        y -= getTotalPaddingTop();
        y = Math.max(0.0f, y);
        y = Math.min(getHeight() - getTotalPaddingBottom() - 1, y);
        y += getScrollY();
        int var6DD28032E606AA4BF99A53AB522278D5_711239578 = (getLayout().getLineForVertical((int) y));
        addTaint(y);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_463144289 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_463144289;
        // ---------- Original Method ----------
        //y -= getTotalPaddingTop();
        //y = Math.max(0.0f, y);
        //y = Math.min(getHeight() - getTotalPaddingBottom() - 1, y);
        //y += getScrollY();
        //return getLayout().getLineForVertical((int) y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.102 -0400", hash_original_method = "78600135096D77C91825CF9049D3F243", hash_generated_method = "58F390F3EEA23EB631F8BAC0AD9561AD")
    private int getOffsetAtCoordinate(int line, float x) {
        x = convertToLocalHorizontalCoordinate(x);
        int varD73392C253D779C86FFAE24ED89F63F1_844796424 = (getLayout().getOffsetForHorizontal(line, x));
        addTaint(line);
        addTaint(x);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_478766977 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_478766977;
        // ---------- Original Method ----------
        //x = convertToLocalHorizontalCoordinate(x);
        //return getLayout().getOffsetForHorizontal(line, x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.116 -0400", hash_original_method = "B77333C8EDA86B5BA4A004A4B129217A", hash_generated_method = "2EC06471AA97904882AC9FC22E348585")
    private boolean isPositionOnText(float x, float y) {
        {
            boolean var778B744EBE60DF815BEE98852B413FC5_708732950 = (getLayout() == null);
        } //End collapsed parenthetic
        int line;
        line = getLineAtCoordinate(y);
        x = convertToLocalHorizontalCoordinate(x);
        {
            boolean var59E035AC6E596093F53E603EDA382B91_2087451806 = (x < getLayout().getLineLeft(line));
        } //End collapsed parenthetic
        {
            boolean var04BE7C77E8AA35EC39BE529B038AF3DD_713393117 = (x > getLayout().getLineRight(line));
        } //End collapsed parenthetic
        addTaint(x);
        addTaint(y);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1442300222 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1442300222;
        // ---------- Original Method ----------
        //if (getLayout() == null) return false;
        //final int line = getLineAtCoordinate(y);
        //x = convertToLocalHorizontalCoordinate(x);
        //if (x < getLayout().getLineLeft(line)) return false;
        //if (x > getLayout().getLineRight(line)) return false;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.117 -0400", hash_original_method = "282C8F5427700D40A542E64F343C6674", hash_generated_method = "2D4A6A846C184A069147754AC7081A48")
    @Override
    public boolean onDragEvent(DragEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            Object var9E1FBD251DF7E53AB77C3A31F15B2B38_795829223 = (event.getAction());
            //Begin case DragEvent.ACTION_DRAG_STARTED 
            boolean varB5182ED29788A31653E5E1546400D879_873668661 = (hasInsertionController());
            //End case DragEvent.ACTION_DRAG_STARTED 
            //Begin case DragEvent.ACTION_DRAG_ENTERED 
            TextView.this.requestFocus();
            //End case DragEvent.ACTION_DRAG_ENTERED 
            //Begin case DragEvent.ACTION_DRAG_LOCATION 
            int offset;
            offset = getOffsetForPosition(event.getX(), event.getY());
            //End case DragEvent.ACTION_DRAG_LOCATION 
            //Begin case DragEvent.ACTION_DRAG_LOCATION 
            Selection.setSelection((Spannable)mText, offset);
            //End case DragEvent.ACTION_DRAG_LOCATION 
            //Begin case DragEvent.ACTION_DROP 
            onDrop(event);
            //End case DragEvent.ACTION_DROP 
        } //End collapsed parenthetic
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_350312975 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_350312975;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.118 -0400", hash_original_method = "89464BC34879AFE88152B04970AA44D2", hash_generated_method = "F9A568BD94A3AB4CE32EE75F1DEEFCD3")
    private void onDrop(DragEvent event) {
        StringBuilder content;
        content = new StringBuilder("");
        ClipData clipData;
        clipData = event.getClipData();
        int itemCount;
        itemCount = clipData.getItemCount();
        {
            int i;
            i = 0;
            {
                Item item;
                item = clipData.getItemAt(i);
                content.append(item.coerceToText(TextView.this.mContext));
            } //End block
        } //End collapsed parenthetic
        int offset;
        offset = getOffsetForPosition(event.getX(), event.getY());
        Object localState;
        localState = event.getLocalState();
        DragLocalState dragLocalState;
        dragLocalState = null;
        {
            dragLocalState = (DragLocalState) localState;
        } //End block
        boolean dragDropIntoItself;
        dragDropIntoItself = dragLocalState != null &&
                dragLocalState.sourceTextView == this;
        int originalLength;
        originalLength = mText.length();
        long minMax;
        minMax = prepareSpacesAroundPaste(offset, offset, content);
        int min;
        min = extractRangeStartFromLong(minMax);
        int max;
        max = extractRangeEndFromLong(minMax);
        Selection.setSelection((Spannable) mText, max);
        replaceText_internal(min, max, content);
        {
            int dragSourceStart;
            dragSourceStart = dragLocalState.start;
            int dragSourceEnd;
            dragSourceEnd = dragLocalState.end;
            {
                int shift;
                shift = mText.length() - originalLength;
                dragSourceStart += shift;
                dragSourceEnd += shift;
            } //End block
            deleteText_internal(dragSourceStart, dragSourceEnd);
            {
                boolean var353A6E4F7751153EED06FB844C167F01_298376568 = ((dragSourceStart == 0 ||
                    Character.isSpaceChar(mTransformed.charAt(dragSourceStart - 1))) &&
                    (dragSourceStart == mText.length() ||
                    Character.isSpaceChar(mTransformed.charAt(dragSourceStart))));
                {
                    int pos;
                    boolean var518448CA6AC99CEB1166FD5287784237_159567492 = (dragSourceStart == mText.length());
                    pos = dragSourceStart - 1;
                    pos = dragSourceStart;
                    deleteText_internal(pos, pos + 1);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(event.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.118 -0400", hash_original_method = "91BB575EAEE11A270473B31B356B5B12", hash_generated_method = "99132FE92FAD1396B56397F25411C9A4")
     boolean hasInsertionController() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1609739433 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1609739433;
        // ---------- Original Method ----------
        //return mInsertionControllerEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.119 -0400", hash_original_method = "EE05979336406D2A8CCC57049072454C", hash_generated_method = "D4EF76EFE45E90ABE3AC216ED04AD354")
     boolean hasSelectionController() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_723919079 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_723919079;
        // ---------- Original Method ----------
        //return mSelectionControllerEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.119 -0400", hash_original_method = "02A03A91466BF03F45C3C819266A605E", hash_generated_method = "51E60DE7A61E216AD0704865D44CB05D")
     InsertionPointCursorController getInsertionController() {
        InsertionPointCursorController varB4EAC82CA7396A68D541C85D26508E83_969454212 = null; //Variable for return #1
        InsertionPointCursorController varB4EAC82CA7396A68D541C85D26508E83_860629069 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_969454212 = null;
        } //End block
        {
            mInsertionPointCursorController = new InsertionPointCursorController();
            ViewTreeObserver observer;
            observer = getViewTreeObserver();
            observer.addOnTouchModeChangeListener(mInsertionPointCursorController);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_860629069 = mInsertionPointCursorController;
        InsertionPointCursorController varA7E53CE21691AB073D9660D615818899_55342264; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_55342264 = varB4EAC82CA7396A68D541C85D26508E83_969454212;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_55342264 = varB4EAC82CA7396A68D541C85D26508E83_860629069;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_55342264.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_55342264;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.131 -0400", hash_original_method = "CD09732805D28B5BF513C98008463942", hash_generated_method = "11DB6AE5787C6CCDF09DEBC0D3D2F52A")
     SelectionModifierCursorController getSelectionController() {
        SelectionModifierCursorController varB4EAC82CA7396A68D541C85D26508E83_1092614032 = null; //Variable for return #1
        SelectionModifierCursorController varB4EAC82CA7396A68D541C85D26508E83_789894292 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1092614032 = null;
        } //End block
        {
            mSelectionModifierCursorController = new SelectionModifierCursorController();
            ViewTreeObserver observer;
            observer = getViewTreeObserver();
            observer.addOnTouchModeChangeListener(mSelectionModifierCursorController);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_789894292 = mSelectionModifierCursorController;
        SelectionModifierCursorController varA7E53CE21691AB073D9660D615818899_1898414423; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1898414423 = varB4EAC82CA7396A68D541C85D26508E83_1092614032;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1898414423 = varB4EAC82CA7396A68D541C85D26508E83_789894292;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1898414423.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1898414423;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.132 -0400", hash_original_method = "2A090273FA835CA26EC17C458A37DEC8", hash_generated_method = "BCF36107D1A7BE640BDCD2B3A20AB8A8")
     boolean isInBatchEditMode() {
        InputMethodState ims;
        ims = mInputMethodState;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1191434266 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1191434266;
        // ---------- Original Method ----------
        //final InputMethodState ims = mInputMethodState;
        //if (ims != null) {
            //return ims.mBatchEditNesting > 0;
        //}
        //return mInBatchEditControllers;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.132 -0400", hash_original_method = "6388CB4B4CF218043B88410FEBCF8F11", hash_generated_method = "75422AFF8136D3D6B64A9CC7606FE89A")
    @Override
    protected void resolveTextDirection() {
        {
            boolean varAFBCCFFAA18696A12B6915A938CC8475_937771798 = (hasPasswordTransformationMethod());
            {
                mTextDir = TextDirectionHeuristics.LOCALE;
            } //End block
        } //End collapsed parenthetic
        boolean defaultIsRtl;
        defaultIsRtl = (getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL);
        super.resolveTextDirection();
        int textDir;
        textDir = getResolvedTextDirection();
        //Begin case default TEXT_DIRECTION_FIRST_STRONG 
        mTextDir = (defaultIsRtl ? TextDirectionHeuristics.FIRSTSTRONG_RTL :
                        TextDirectionHeuristics.FIRSTSTRONG_LTR);
        //End case default TEXT_DIRECTION_FIRST_STRONG 
        //Begin case TEXT_DIRECTION_ANY_RTL 
        mTextDir = TextDirectionHeuristics.ANYRTL_LTR;
        //End case TEXT_DIRECTION_ANY_RTL 
        //Begin case TEXT_DIRECTION_LTR 
        mTextDir = TextDirectionHeuristics.LTR;
        //End case TEXT_DIRECTION_LTR 
        //Begin case TEXT_DIRECTION_RTL 
        mTextDir = TextDirectionHeuristics.RTL;
        //End case TEXT_DIRECTION_RTL 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.146 -0400", hash_original_method = "E2C9FAE08740394CAC2960942379DB19", hash_generated_method = "9F131BE1FD80C14FCFB9B40E7607AE66")
    protected void resolveDrawables() {
        {
            mResolvedDrawables = true;
        } //End block
        Drawables dr;
        dr = mDrawables;
        {
            Object varAFC6EB2C684D509A17B3A4EFF5D9CB9D_1686759727 = (getResolvedLayoutDirection());
            //Begin case LAYOUT_DIRECTION_RTL 
            {
                dr.mDrawableRight = dr.mDrawableStart;
                dr.mDrawableSizeRight = dr.mDrawableSizeStart;
                dr.mDrawableHeightRight = dr.mDrawableHeightStart;
            } //End block
            //End case LAYOUT_DIRECTION_RTL 
            //Begin case LAYOUT_DIRECTION_RTL 
            {
                dr.mDrawableLeft = dr.mDrawableEnd;
                dr.mDrawableSizeLeft = dr.mDrawableSizeEnd;
                dr.mDrawableHeightLeft = dr.mDrawableHeightEnd;
            } //End block
            //End case LAYOUT_DIRECTION_RTL 
            //Begin case LAYOUT_DIRECTION_LTR default 
            {
                dr.mDrawableLeft = dr.mDrawableStart;
                dr.mDrawableSizeLeft = dr.mDrawableSizeStart;
                dr.mDrawableHeightLeft = dr.mDrawableHeightStart;
            } //End block
            //End case LAYOUT_DIRECTION_LTR default 
            //Begin case LAYOUT_DIRECTION_LTR default 
            {
                dr.mDrawableRight = dr.mDrawableEnd;
                dr.mDrawableSizeRight = dr.mDrawableSizeEnd;
                dr.mDrawableHeightRight = dr.mDrawableHeightEnd;
            } //End block
            //End case LAYOUT_DIRECTION_LTR default 
        } //End collapsed parenthetic
        mResolvedDrawables = true;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.146 -0400", hash_original_method = "18FE12CF478DF44CED567E30FAAD0C93", hash_generated_method = "39C62916D85B160D1BFEF9F52F7B861D")
    protected void resetResolvedDrawables() {
        mResolvedDrawables = false;
        // ---------- Original Method ----------
        //mResolvedDrawables = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.147 -0400", hash_original_method = "6AA5A1E8B49AF4D4943616613CE0B2E3", hash_generated_method = "AE99380235E5A8508B389BC8FE4FB29F")
    protected void viewClicked(InputMethodManager imm) {
        {
            imm.viewClicked(this);
        } //End block
        addTaint(imm.getTaint());
        // ---------- Original Method ----------
        //if (imm != null) {
            //imm.viewClicked(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.148 -0400", hash_original_method = "D7BCF3915857A038F77C712DE4BFFF5D", hash_generated_method = "82D977B2A2E9A7D66975A67958B763D7")
    protected void deleteText_internal(int start, int end) {
        ((Editable) mText).delete(start, end);
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
        //((Editable) mText).delete(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.149 -0400", hash_original_method = "2F865B1F2B94D9294078802BAAEABE19", hash_generated_method = "884437AAC7B453870CDA538B82876073")
    protected void replaceText_internal(int start, int end, CharSequence text) {
        ((Editable) mText).replace(start, end, text);
        addTaint(start);
        addTaint(end);
        addTaint(text.getTaint());
        // ---------- Original Method ----------
        //((Editable) mText).replace(start, end, text);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.149 -0400", hash_original_method = "80E41DC8CAFBEBBFCDBF175A54ED075C", hash_generated_method = "5CBE479DCFA40B66FFE91CE94BCF364D")
    protected void setSpan_internal(Object span, int start, int end, int flags) {
        ((Editable) mText).setSpan(span, start, end, flags);
        addTaint(span.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(flags);
        // ---------- Original Method ----------
        //((Editable) mText).setSpan(span, start, end, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.164 -0400", hash_original_method = "ED942619162EB0C0AFB16CB348D15185", hash_generated_method = "643FB61F97017861D5294251D2E84E6E")
    protected void setCursorPosition_internal(int start, int end) {
        Selection.setSelection(((Editable) mText), start, end);
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
        //Selection.setSelection(((Editable) mText), start, end);
    }

    
    static class Drawables {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.164 -0400", hash_original_field = "74C57594A7956D89EE8B0E12D6641E99", hash_generated_field = "32F20D33EC64DE2D5D814E6A5C824218")

        Rect mCompoundRect = new Rect();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.164 -0400", hash_original_field = "0C7DD96235E9F9762942299197287CDE", hash_generated_field = "EA47CEDDDC7FEEFF8968F16759D386B7")

        Drawable mDrawableTop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.164 -0400", hash_original_field = "FFC9598591962399CC8E8DA93075B1FF", hash_generated_field = "95D5EBB5A7DB907B0D10BA6FCACBEB79")

        Drawable mDrawableBottom;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.164 -0400", hash_original_field = "449D3E5B49321EA02E52964E3AD5E600", hash_generated_field = "E0F354AEDF5B6392510E8BF8351EC72A")

        Drawable mDrawableLeft;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.164 -0400", hash_original_field = "E63FC6EB4CF70CF1E79E34F4802DD068", hash_generated_field = "DEB85B9558F1DB613F21ACF47C293916")

        Drawable mDrawableRight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.164 -0400", hash_original_field = "89A4C538AC75F9C8F89ECA933AF96BAC", hash_generated_field = "B1620A6A345278DE80A9BA4900B11475")

        Drawable mDrawableStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.164 -0400", hash_original_field = "6A5FA7C04A36BE708BEA6972E6A10C46", hash_generated_field = "ACC539430A5F08E0F28AB3BE40D0952D")

        Drawable mDrawableEnd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.164 -0400", hash_original_field = "7D9F9A3BD601360DABB13C24EDE31952", hash_generated_field = "11854D143E60E009B90CD1FF8A02DEE3")

        int mDrawableSizeTop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.164 -0400", hash_original_field = "5EF68820BA8AD14D3920D191E438FBDF", hash_generated_field = "16E3A7AF686EC0516100ECED818E8EBA")

        int mDrawableSizeBottom;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.164 -0400", hash_original_field = "8DF66E67AC6A7270297B2C5293CA4A1E", hash_generated_field = "9140D35B31C4D61223B6173C166B3B31")

        int mDrawableSizeLeft;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.164 -0400", hash_original_field = "2BF66DDDC1E0C702D032E0065415C285", hash_generated_field = "D5565D3AC427749F2C0140A5168ACEC1")

        int mDrawableSizeRight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.164 -0400", hash_original_field = "BC24A3002B0209BBAD6B5107B8C2EA00", hash_generated_field = "400EC481934DD8ABF5A430FF208AE483")

        int mDrawableSizeStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.164 -0400", hash_original_field = "7A0964DB19BD292930633D81D5FE202A", hash_generated_field = "FC1E40A21375A985A535463B1946D0C4")

        int mDrawableSizeEnd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.165 -0400", hash_original_field = "D200C09B8E1D61364C5957FCD8230942", hash_generated_field = "F24DC8D9531D637A0AFC8D7ABA047F75")

        int mDrawableWidthTop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.165 -0400", hash_original_field = "E5BC5ECE7466DFCB1D39A398C2C574A1", hash_generated_field = "3EE0808C0F345FDF9EFA159F089ADA7B")

        int mDrawableWidthBottom;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.165 -0400", hash_original_field = "875C159AC4F13BDACAA64D85FCF9101B", hash_generated_field = "F4D603ED5E02DAD268A97E78155D65C1")

        int mDrawableHeightLeft;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.165 -0400", hash_original_field = "D0C439D856EBC4A4B843E9FB48AFDB7F", hash_generated_field = "13D419316EC5090DDF8A1B991D8C5815")

        int mDrawableHeightRight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.165 -0400", hash_original_field = "733346E69602A23B6E0712C7624F8348", hash_generated_field = "BEF3751E3F03DC5BEF12658362370AC3")

        int mDrawableHeightStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.165 -0400", hash_original_field = "E6A25620EDEE5CEC3B3C35B3F7640BFF", hash_generated_field = "6D5FC4CA6674578E6C48F812EBFBEB45")

        int mDrawableHeightEnd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.165 -0400", hash_original_field = "AC18734F422B9E18D85FA34BBE4F1AB9", hash_generated_field = "4B293F8E3375C5C6A3B4DDED1666F169")

        int mDrawablePadding;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.165 -0400", hash_original_method = "8748E639EC70CC7FF4A65E9B42DA91C9", hash_generated_method = "8748E639EC70CC7FF4A65E9B42DA91C9")
        public Drawables ()
        {
            //Synthesized constructor
        }


    }


    
    static class InputContentType {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.165 -0400", hash_original_field = "F1D416D715A94332F70BC0287731CE7F", hash_generated_field = "6219A24954430291C20C014227F0E7AC")

        int imeOptions = EditorInfo.IME_NULL;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.165 -0400", hash_original_field = "DEFBBD87D4F8CD9F381E3EB725415421", hash_generated_field = "E12E483301A64F5247F5B384AF8C5D04")

        String privateImeOptions;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.165 -0400", hash_original_field = "76C02E50E629DF1D0F1CA7C54AF496AC", hash_generated_field = "0C07741C23A7BB415A826F63EBCB78E4")

        CharSequence imeActionLabel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.165 -0400", hash_original_field = "D057B43F9C78BB13119BE0D27496DE69", hash_generated_field = "8D9B82A785391392ECC49B1515360CFD")

        int imeActionId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.165 -0400", hash_original_field = "27353006CFD751D26221E04A7928034D", hash_generated_field = "6F80A5414A80FF69E92A0BD3C0E073DC")

        Bundle extras;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.165 -0400", hash_original_field = "BA813182DE371DA33173902F7DCF8E39", hash_generated_field = "FBB987EFA3E5C389D064619D4166B06F")

        OnEditorActionListener onEditorActionListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.165 -0400", hash_original_field = "290F688C4EB819BDE29369D5AC9C7359", hash_generated_field = "94119079D0396AC6C04F22D47E6CD16C")

        boolean enterDown;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.165 -0400", hash_original_method = "B3EB62E33A235E4F2C0FA9694799B659", hash_generated_method = "B3EB62E33A235E4F2C0FA9694799B659")
        public InputContentType ()
        {
            //Synthesized constructor
        }


    }


    
    static class InputMethodState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.165 -0400", hash_original_field = "C068D7C92CA0B3001E3B86B6035A8ED5", hash_generated_field = "09DEDD19F4EE15AD81232C03C2E1F622")

        Rect mCursorRectInWindow = new Rect();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.165 -0400", hash_original_field = "89DF3EAFA94422450EB293D106F78DF0", hash_generated_field = "C70C3A106639E4B88E9E717A37688D8A")

        RectF mTmpRectF = new RectF();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.165 -0400", hash_original_field = "0B9EE67942FCCABC277B3D4A6655E296", hash_generated_field = "49A81A03C51B25D7E9A5C3BCA9AE957B")

        float[] mTmpOffset = new float[2];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.165 -0400", hash_original_field = "359DC50A098A8A050305C498165DCB8A", hash_generated_field = "FF9982DFAABD3C0DCD2EF1CD08CB60CF")

        ExtractedTextRequest mExtracting;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.165 -0400", hash_original_field = "E00709DBDB9C6962F1B8EC652516BA10", hash_generated_field = "1FADD3620F542FA2687CB00E89D0BDDF")

        ExtractedText mTmpExtracted = new ExtractedText();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.165 -0400", hash_original_field = "462C98157E02727571B7A747DD4C8C62", hash_generated_field = "21001EAFF7A276FB78FCAA91CB53D94F")

        int mBatchEditNesting;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.165 -0400", hash_original_field = "49B5E6309E54B338AAA681F087939793", hash_generated_field = "90AD8A78AE95138D386FCE8C5FEB694D")

        boolean mCursorChanged;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.165 -0400", hash_original_field = "16626AECCDE2F164741983CD5E6444F1", hash_generated_field = "866086E9E33AFC2E676556369B9C50CF")

        boolean mSelectionModeChanged;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.165 -0400", hash_original_field = "E4B4327543665AE44C5321E7C66FD5AB", hash_generated_field = "9AAC9C08BF94B94F258CADEF618638FC")

        boolean mContentChanged;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.165 -0400", hash_original_field = "FA977B41050645C0B88E06966F709384", hash_generated_field = "4675A60A313C032BC0FE364A0DDA2ED7")

        int mChangedStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.165 -0400", hash_original_field = "9A4002C6FBE401B7B9714E151801E727", hash_generated_field = "8C7E0284E9593E9DE8C552E7CF188261")

        int mChangedEnd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.166 -0400", hash_original_field = "625F12322D4384854704A8C6631D51D2", hash_generated_field = "D983CF835648B537298EC9705400AAB7")

        int mChangedDelta;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.166 -0400", hash_original_method = "60FC2021DEC54591E7EA76E02BC73921", hash_generated_method = "60FC2021DEC54591E7EA76E02BC73921")
        public InputMethodState ()
        {
            //Synthesized constructor
        }


    }


    
    private static enum TextAlign {
        INHERIT, GRAVITY, TEXT_START, TEXT_END, CENTER, VIEW_START, VIEW_END;
    }

    
    public static class SavedState extends BaseSavedState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.166 -0400", hash_original_field = "416D92C12FE86ACB3AA22B22D8269DC0", hash_generated_field = "4970E7F36D3C8378761D0E310C2396E8")

        int selStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.166 -0400", hash_original_field = "C8D3673FFFE33414608EBCA0E79CB992", hash_generated_field = "E27E0ADA332B9C693E53A0FBE392C373")

        int selEnd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.166 -0400", hash_original_field = "1CB251EC0D568DE6A929B520C4AED8D1", hash_generated_field = "0F26345BF87C16C80BAC76779863E330")

        CharSequence text;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.166 -0400", hash_original_field = "EBD219514CC5466F8D057D080C99356A", hash_generated_field = "C49FE4AC5327729CC90ECD7A211AF40F")

        boolean frozenWithFocus;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.166 -0400", hash_original_field = "CB5E100E5A9A3E7F6D1FD97512215282", hash_generated_field = "BF3285010BEB822EC6EFACD0340B80BF")

        CharSequence error;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.166 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "3F4F70129FCB46E4AE0D334AE4D70CF6")
          SavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.170 -0400", hash_original_method = "37D3E7AD53C42A47440A9F9D38DFF900", hash_generated_method = "CEB013472CDD944903873EFE1F141A5D")
        private  SavedState(Parcel in) {
            super(in);
            selStart = in.readInt();
            selEnd = in.readInt();
            frozenWithFocus = (in.readInt() != 0);
            text = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
            {
                boolean var331417C59A822E59FB0B216D2F29CB47_1517320121 = (in.readInt() != 0);
                {
                    error = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //selStart = in.readInt();
            //selEnd = in.readInt();
            //frozenWithFocus = (in.readInt() != 0);
            //text = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
            //if (in.readInt() != 0) {
                //error = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.171 -0400", hash_original_method = "0917C7384BCC053D7DFEC5346FB5EF0D", hash_generated_method = "3B001DF9DF809BF35BD68E5A64A31FEE")
        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(selStart);
            out.writeInt(selEnd);
            out.writeInt(frozenWithFocus ? 1 : 0);
            TextUtils.writeToParcel(text, out, flags);
            {
                out.writeInt(0);
            } //End block
            {
                out.writeInt(1);
                TextUtils.writeToParcel(error, out, flags);
            } //End block
            addTaint(out.getTaint());
            addTaint(flags);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.176 -0400", hash_original_method = "B2667A033A504E8795AC5B896DD98B5F", hash_generated_method = "07CB8D90CB206DFC3EC7A7A544226927")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1802083696 = null; //Variable for return #1
            String str;
            str = "TextView.SavedState{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " start=" + selStart + " end=" + selEnd;
            {
                str += " text=" + text;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1802083696 = str + "}";
            varB4EAC82CA7396A68D541C85D26508E83_1802083696.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1802083696;
            // ---------- Original Method ----------
            //String str = "TextView.SavedState{"
                    //+ Integer.toHexString(System.identityHashCode(this))
                    //+ " start=" + selStart + " end=" + selEnd;
            //if (text != null) {
                //str += " text=" + text;
            //}
            //return str + "}";
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.177 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "3C65ED69ACC8B99E43F04B4C3721B494")

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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.178 -0400", hash_original_field = "7C3722E3CD3CCC07C587A93513F1BB79", hash_generated_field = "20B8558AB5FD0F0B5A30B95221D68246")

        private char[] mChars;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.180 -0400", hash_original_field = "59B50EB80ABF1071654EE6DE5094E070", hash_generated_field = "D233E3389CE5D79EE6040D6A855ED4FF")

        private int mStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.187 -0400", hash_original_field = "429F431E8CD8AC287AA27460675EAEFE", hash_generated_field = "E9E17726F18BEC3E5C2C142D209555FD")

        private int mLength;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.188 -0400", hash_original_method = "91EFB0F7C01F6A5A0D8B3974D02E0951", hash_generated_method = "3E74A8A784F032BD1BA482AFCEE2CDD8")
        public  CharWrapper(char[] chars, int start, int len) {
            mChars = chars;
            mStart = start;
            mLength = len;
            // ---------- Original Method ----------
            //mChars = chars;
            //mStart = start;
            //mLength = len;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.189 -0400", hash_original_method = "9DC2F69D47DD9984FB3378BE28468419", hash_generated_method = "72DA95D14539877C07C287DFECCF13DC")
         void set(char[] chars, int start, int len) {
            mChars = chars;
            mStart = start;
            mLength = len;
            // ---------- Original Method ----------
            //mChars = chars;
            //mStart = start;
            //mLength = len;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.189 -0400", hash_original_method = "C0D624CC7CEFFAF650D54F4FB963FAF6", hash_generated_method = "61FEA0FD7B4177BFDE66D0ABD1D43299")
        public int length() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1998793544 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1998793544;
            // ---------- Original Method ----------
            //return mLength;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.189 -0400", hash_original_method = "02B707818F2669493B94939B301EE67F", hash_generated_method = "25B9FD9928BA59012D76110C23F09B72")
        public char charAt(int off) {
            addTaint(off);
            char varA87DEB01C5F539E6BDA34829C8EF2368_1260987971 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1260987971;
            // ---------- Original Method ----------
            //return mChars[off + mStart];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.189 -0400", hash_original_method = "16BC7956BCD83D2479A5892A7E5C0E12", hash_generated_method = "96AF14BEF83642B5DEBC6E92828F36D8")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_692500122 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_692500122 = new String(mChars, mStart, mLength);
            varB4EAC82CA7396A68D541C85D26508E83_692500122.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_692500122;
            // ---------- Original Method ----------
            //return new String(mChars, mStart, mLength);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.190 -0400", hash_original_method = "BA853CED33F98EDEC6E428BC258874A3", hash_generated_method = "397664FDC4572648341EDD880EA9E4EF")
        public CharSequence subSequence(int start, int end) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_100730344 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(start + ", " + end);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_100730344 = new String(mChars, start + mStart, end - start);
            addTaint(start);
            addTaint(end);
            varB4EAC82CA7396A68D541C85D26508E83_100730344.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_100730344;
            // ---------- Original Method ----------
            //if (start < 0 || end < 0 || start > mLength || end > mLength) {
                //throw new IndexOutOfBoundsException(start + ", " + end);
            //}
            //return new String(mChars, start + mStart, end - start);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.190 -0400", hash_original_method = "BA41D2BD366E4073F3399B79828CDD69", hash_generated_method = "0EA0003F38467FABE633E4921E417BB3")
        public void getChars(int start, int end, char[] buf, int off) {
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(start + ", " + end);
            } //End block
            System.arraycopy(mChars, start + mStart, buf, off, end - start);
            addTaint(start);
            addTaint(end);
            addTaint(buf[0]);
            addTaint(off);
            // ---------- Original Method ----------
            //if (start < 0 || end < 0 || start > mLength || end > mLength) {
                //throw new IndexOutOfBoundsException(start + ", " + end);
            //}
            //System.arraycopy(mChars, start + mStart, buf, off, end - start);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.197 -0400", hash_original_method = "69B7B91382C25765CF25BB95E9C19951", hash_generated_method = "51507E494D33A8046526B4D323096678")
        public void drawText(Canvas c, int start, int end,
                             float x, float y, Paint p) {
            c.drawText(mChars, start + mStart, end - start, x, y, p);
            addTaint(c.getTaint());
            addTaint(start);
            addTaint(end);
            addTaint(x);
            addTaint(y);
            addTaint(p.getTaint());
            // ---------- Original Method ----------
            //c.drawText(mChars, start + mStart, end - start, x, y, p);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.198 -0400", hash_original_method = "7645CF39D6B95BCD64DC33FB4F483F74", hash_generated_method = "3B153BAEFC9C41EEB40AA9C6C8C818A2")
        public void drawTextRun(Canvas c, int start, int end,
                int contextStart, int contextEnd, float x, float y, int flags, Paint p) {
            int count;
            count = end - start;
            int contextCount;
            contextCount = contextEnd - contextStart;
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
            // ---------- Original Method ----------
            //int count = end - start;
            //int contextCount = contextEnd - contextStart;
            //c.drawTextRun(mChars, start + mStart, count, contextStart + mStart,
                    //contextCount, x, y, flags, p);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.198 -0400", hash_original_method = "4FA2C1189F8B48AEDF7B10BEDFF84543", hash_generated_method = "E234B9AFA158E8A95B8A0E646B2E618A")
        public float measureText(int start, int end, Paint p) {
            float var5A7F792133FF7C4A81B497C5A4720CB1_1453528601 = (p.measureText(mChars, start + mStart, end - start));
            addTaint(start);
            addTaint(end);
            addTaint(p.getTaint());
            float var546ADE640B6EDFBC8A086EF31347E768_1967336707 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1967336707;
            // ---------- Original Method ----------
            //return p.measureText(mChars, start + mStart, end - start);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.198 -0400", hash_original_method = "E75F381DB76AB16AB72FA7895D0F4EE0", hash_generated_method = "E459258208E9644325E67BAAFCD12A0B")
        public int getTextWidths(int start, int end, float[] widths, Paint p) {
            int varE3ED158C14EA094EB292BB32B5DD8EF6_1631190900 = (p.getTextWidths(mChars, start + mStart, end - start, widths));
            addTaint(start);
            addTaint(end);
            addTaint(widths[0]);
            addTaint(p.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_45779498 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_45779498;
            // ---------- Original Method ----------
            //return p.getTextWidths(mChars, start + mStart, end - start, widths);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.199 -0400", hash_original_method = "8AE304950D3C27A7D6E58BA388580EF8", hash_generated_method = "49DF635E1FF410F4D6AA87D4AD22BA7F")
        public float getTextRunAdvances(int start, int end, int contextStart,
                int contextEnd, int flags, float[] advances, int advancesIndex,
                Paint p) {
            int count;
            count = end - start;
            int contextCount;
            contextCount = contextEnd - contextStart;
            float var95DA16B05752FC715454FE8979E745DE_917844502 = (p.getTextRunAdvances(mChars, start + mStart, count,
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
            float var546ADE640B6EDFBC8A086EF31347E768_1155276563 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1155276563;
            // ---------- Original Method ----------
            //int count = end - start;
            //int contextCount = contextEnd - contextStart;
            //return p.getTextRunAdvances(mChars, start + mStart, count,
                    //contextStart + mStart, contextCount, flags, advances,
                    //advancesIndex);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.199 -0400", hash_original_method = "F8F49F104CF6E56864F062F013326F8E", hash_generated_method = "7F60FCF72DCEC28854F5A696275A8CCB")
        public float getTextRunAdvances(int start, int end, int contextStart,
                int contextEnd, int flags, float[] advances, int advancesIndex,
                Paint p, int reserved) {
            int count;
            count = end - start;
            int contextCount;
            contextCount = contextEnd - contextStart;
            float var96D3717415879B74E71057007515D708_89170796 = (p.getTextRunAdvances(mChars, start + mStart, count,
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
            float var546ADE640B6EDFBC8A086EF31347E768_98632161 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_98632161;
            // ---------- Original Method ----------
            //int count = end - start;
            //int contextCount = contextEnd - contextStart;
            //return p.getTextRunAdvances(mChars, start + mStart, count,
                    //contextStart + mStart, contextCount, flags, advances,
                    //advancesIndex, reserved);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.210 -0400", hash_original_method = "BDCC8CC855D861C4246044B3842097FC", hash_generated_method = "8BC0426375AAD9042565A969884F34C8")
        public int getTextRunCursor(int contextStart, int contextEnd, int flags,
                int offset, int cursorOpt, Paint p) {
            int contextCount;
            contextCount = contextEnd - contextStart;
            int var068FAD7452971D895CA3E5455D974B2C_208062924 = (p.getTextRunCursor(mChars, contextStart + mStart,
                    contextCount, flags, offset + mStart, cursorOpt));
            addTaint(contextStart);
            addTaint(contextEnd);
            addTaint(flags);
            addTaint(offset);
            addTaint(cursorOpt);
            addTaint(p.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1730049884 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1730049884;
            // ---------- Original Method ----------
            //int contextCount = contextEnd - contextStart;
            //return p.getTextRunCursor(mChars, contextStart + mStart,
                    //contextCount, flags, offset + mStart, cursorOpt);
        }

        
    }


    
    private static class ErrorPopup extends PopupWindow {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.210 -0400", hash_original_field = "7DF8B65473C97B2A69F25D9317EC3DEC", hash_generated_field = "7E17DC26D2CD570CF106F239587AB53D")

        private boolean mAbove = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.210 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "EC8812FBC96AED57B9AA8E9AC44D0DAB")

        private TextView mView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.210 -0400", hash_original_field = "A0A9CFD5067DB601801485B1E446CCDB", hash_generated_field = "950EB5B59166D035BC490D5607F4FE92")

        private int mPopupInlineErrorBackgroundId = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.210 -0400", hash_original_field = "6962B840396BC381227E36B1099A626C", hash_generated_field = "44679A20C762322AD033B0D96DF5B4A1")

        private int mPopupInlineErrorAboveBackgroundId = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.211 -0400", hash_original_method = "272870BAEDFD334116717C4E8AB7F4AA", hash_generated_method = "49481A4E68134FA555025EF0D96CB36B")
          ErrorPopup(TextView v, int width, int height) {
            super(v, width, height);
            mView = v;
            mPopupInlineErrorBackgroundId = getResourceId(mPopupInlineErrorBackgroundId,
                    com.android.internal.R.styleable.Theme_errorMessageBackground);
            mView.setBackgroundResource(mPopupInlineErrorBackgroundId);
            addTaint(width);
            addTaint(height);
            // ---------- Original Method ----------
            //mView = v;
            //mPopupInlineErrorBackgroundId = getResourceId(mPopupInlineErrorBackgroundId,
                    //com.android.internal.R.styleable.Theme_errorMessageBackground);
            //mView.setBackgroundResource(mPopupInlineErrorBackgroundId);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.212 -0400", hash_original_method = "FF785E3F959B10F16CB73DE59942CDE6", hash_generated_method = "64FEBD7B79B99C13F6B9192D02A2D11F")
         void fixDirection(boolean above) {
            mAbove = above;
            {
                mPopupInlineErrorAboveBackgroundId =
                    getResourceId(mPopupInlineErrorAboveBackgroundId,
                            com.android.internal.R.styleable.Theme_errorMessageAboveBackground);
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.216 -0400", hash_original_method = "283134609ABCFB2A4CA7FFE3B421D4C1", hash_generated_method = "C98113442556379FD0B6A88F4B16DFCC")
        private int getResourceId(int currentId, int index) {
            {
                TypedArray styledAttributes;
                styledAttributes = mView.getContext().obtainStyledAttributes(
                        R.styleable.Theme);
                currentId = styledAttributes.getResourceId(index, 0);
                styledAttributes.recycle();
            } //End block
            addTaint(currentId);
            addTaint(index);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1207531431 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1207531431;
            // ---------- Original Method ----------
            //if (currentId == 0) {
                //TypedArray styledAttributes = mView.getContext().obtainStyledAttributes(
                        //R.styleable.Theme);
                //currentId = styledAttributes.getResourceId(index, 0);
                //styledAttributes.recycle();
            //}
            //return currentId;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.235 -0400", hash_original_method = "D12B38B9E303D838A7A28156EE92AFAA", hash_generated_method = "40E87C811F6367E16618E86022BF6742")
        @Override
        public void update(int x, int y, int w, int h, boolean force) {
            super.update(x, y, w, h, force);
            boolean above;
            above = isAboveAnchor();
            {
                fixDirection(above);
            } //End block
            addTaint(x);
            addTaint(y);
            addTaint(w);
            addTaint(h);
            addTaint(force);
            // ---------- Original Method ----------
            //super.update(x, y, w, h, force);
            //boolean above = isAboveAnchor();
            //if (above != mAbove) {
                //fixDirection(above);
            //}
        }

        
    }


    
    private class CorrectionHighlighter {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.236 -0400", hash_original_field = "DBC2DDFC3AA0B07663EC95BA4102B76C", hash_generated_field = "7CD81E52C80B218AD927A0157374D5AD")

        private Path mPath = new Path();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.236 -0400", hash_original_field = "E7BA6B001D9391CCE70C3C78C53FA3AF", hash_generated_field = "E4879EA5ECBB76B0422191DDD2B26F30")

        private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.236 -0400", hash_original_field = "59B50EB80ABF1071654EE6DE5094E070", hash_generated_field = "D233E3389CE5D79EE6040D6A855ED4FF")

        private int mStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.236 -0400", hash_original_field = "C3B248BAD041692A85BAABC024E9FDCE", hash_generated_field = "EA295975CAF8E42F4C28A87EADB358DF")

        private int mEnd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.236 -0400", hash_original_field = "BE8674259642701C85F5A18F0D1B92CD", hash_generated_field = "516150ABFF873AC5B12EBF2F659E6EFD")

        private long mFadingStartTime;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.236 -0400", hash_original_method = "76400340233C9D40D55E8C6995EBADF6", hash_generated_method = "B77926F0B0BE367B250F0A650FF30C45")
        public  CorrectionHighlighter() {
            mPaint.setCompatibilityScaling(getResources().getCompatibilityInfo().applicationScale);
            mPaint.setStyle(Paint.Style.FILL);
            // ---------- Original Method ----------
            //mPaint.setCompatibilityScaling(getResources().getCompatibilityInfo().applicationScale);
            //mPaint.setStyle(Paint.Style.FILL);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.236 -0400", hash_original_method = "9DA46F38DADC56BDE7EACA06EAFC15FB", hash_generated_method = "C243A91017672BB7839F484D952028CC")
        public void highlight(CorrectionInfo info) {
            mStart = info.getOffset();
            mEnd = mStart + info.getNewText().length();
            mFadingStartTime = SystemClock.uptimeMillis();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.237 -0400", hash_original_method = "F315418B1425EA36D28AB47D63F906BC", hash_generated_method = "36BC1585646860029735B7345D97E08B")
        public void draw(Canvas canvas, int cursorOffsetVertical) {
            {
                boolean var4DB6C275C605DA5ED2D731F7F8E79A54_1906558944 = (updatePath() && updatePaint());
                {
                    {
                        canvas.translate(0, cursorOffsetVertical);
                    } //End block
                    canvas.drawPath(mPath, mPaint);
                    {
                        canvas.translate(0, -cursorOffsetVertical);
                    } //End block
                    invalidate(true);
                } //End block
                {
                    stopAnimation();
                    invalidate(false);
                } //End block
            } //End collapsed parenthetic
            addTaint(canvas.getTaint());
            addTaint(cursorOffsetVertical);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.238 -0400", hash_original_method = "5CBDA1AAE290DD8920EE208B7E44B556", hash_generated_method = "90A27EB9F17CBE8A5998A7F62E49C964")
        private boolean updatePaint() {
            long duration;
            duration = SystemClock.uptimeMillis() - mFadingStartTime;
            float coef;
            coef = 1.0f - (float) duration / FADE_OUT_DURATION;
            int highlightColorAlpha;
            highlightColorAlpha = Color.alpha(mHighlightColor);
            int color;
            color = (mHighlightColor & 0x00FFFFFF) +
                    ((int) (highlightColorAlpha * coef) << 24);
            mPaint.setColor(color);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1515316334 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1515316334;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.239 -0400", hash_original_method = "77DEEE2C70776896B8DA6C9B8DAC8452", hash_generated_method = "97547998ECC90820A14A9D9BE5D60C12")
        private boolean updatePath() {
            Layout layout;
            layout = TextView.this.mLayout;
            int length;
            length = mText.length();
            int start;
            start = Math.min(length, mStart);
            int end;
            end = Math.min(length, mEnd);
            mPath.reset();
            TextView.this.mLayout.getSelectionPath(start, end, mPath);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_594757524 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_594757524;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.243 -0400", hash_original_method = "E7B5FD6BE43D84566E63BFC892235B90", hash_generated_method = "A99C221C6FB1F3CF8C3C9E5FD9A723A4")
        private void invalidate(boolean delayed) {
            {
                boolean var21FA9EC81F38017B1959E255822905B7_1375544521 = (TextView.this.mLayout == null);
            } //End collapsed parenthetic
            {
                mPath.computeBounds(sTempRect, false);
                int left;
                left = getCompoundPaddingLeft();
                int top;
                top = getExtendedPaddingTop() + getVerticalOffset(true);
                {
                    TextView.this.postInvalidateDelayed(16, 
                            left + (int) sTempRect.left, top + (int) sTempRect.top,
                            left + (int) sTempRect.right, top + (int) sTempRect.bottom);
                } //End block
                {
                    TextView.this.postInvalidate((int) sTempRect.left, (int) sTempRect.top,
                            (int) sTempRect.right, (int) sTempRect.bottom);
                } //End block
            } //End block
            addTaint(delayed);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.244 -0400", hash_original_method = "4BD6A36A746D13E089BD00A9CC0A6FB7", hash_generated_method = "78D02156987325E73BE90677BD5A4AF4")
        private void stopAnimation() {
            TextView.this.mCorrectionHighlighter = null;
            // ---------- Original Method ----------
            //TextView.this.mCorrectionHighlighter = null;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.244 -0400", hash_original_field = "5BBBF8F997ACE9A57CB3491DCAF1B12E", hash_generated_field = "B5B9A1C7E17EDBA0D01663AB88FAE935")

        private static int FADE_OUT_DURATION = 400;
    }


    
    private static final class Marquee extends Handler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.244 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "378CC9BF8F5DA198EF400A97F72A70A3")

        private WeakReference<TextView> mView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.244 -0400", hash_original_field = "4704E97CC036B299FAC82F1786745C27", hash_generated_field = "E1F826A18833675CAA3F20EBBCB74E63")

        private byte mStatus = MARQUEE_STOPPED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.244 -0400", hash_original_field = "0AD263692B7453D1CADEF9C0002D8D7E", hash_generated_field = "F7B50A7445EB5AE7B4AED021C79A3798")

        private float mScrollUnit;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.244 -0400", hash_original_field = "73E7117FC717C5779EFE316E1A54EFF7", hash_generated_field = "01E3791EB1346C97E47507148C4BA197")

        private float mMaxScroll;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.244 -0400", hash_original_field = "48D13BF0748D58A28F6C563805C3AA25", hash_generated_field = "60FE7DDBA197AB2FD49DEEDB9A0234B2")

        float mMaxFadeScroll;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.248 -0400", hash_original_field = "72795809679CC0D4D2ECD064DBC450D5", hash_generated_field = "A1B75D52F4336D0AD351EB697147DDEE")

        private float mGhostStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.248 -0400", hash_original_field = "45F31C063DD4B9215C31432A52D6D16F", hash_generated_field = "F191C5ED756AC66F521DCB9604BE3690")

        private float mGhostOffset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.248 -0400", hash_original_field = "6B507C89547F9268ECF8CAA3066483D0", hash_generated_field = "64343518D38D9F055C2F10972107CF16")

        private float mFadeStop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.248 -0400", hash_original_field = "5BD21E806EB8AC9E0439CEE0F1945029", hash_generated_field = "4382F6070B0A1518DE23E4DA7693EF55")

        private int mRepeatLimit;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.248 -0400", hash_original_field = "D9E346D7C0C44D38F8B4D76282E9C096", hash_generated_field = "C7F848EDC5F556B007801A6A62728CC6")

        float mScroll;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.249 -0400", hash_original_method = "EC19D4EFFC7CC18F674B4C588B8FB87B", hash_generated_method = "AB15100108F8E07729AF56FC553AD4DE")
          Marquee(TextView v) {
            float density;
            density = v.getContext().getResources().getDisplayMetrics().density;
            mScrollUnit = (MARQUEE_PIXELS_PER_SECOND * density) / MARQUEE_RESOLUTION;
            mView = new WeakReference<TextView>(v);
            // ---------- Original Method ----------
            //final float density = v.getContext().getResources().getDisplayMetrics().density;
            //mScrollUnit = (MARQUEE_PIXELS_PER_SECOND * density) / MARQUEE_RESOLUTION;
            //mView = new WeakReference<TextView>(v);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.261 -0400", hash_original_method = "6484E5DEDF9A6D25913C9D3BAE668871", hash_generated_method = "37F63ACB636731FA8D89FC97A4833083")
        @Override
        public void handleMessage(Message msg) {
            //Begin case MESSAGE_START 
            mStatus = MARQUEE_RUNNING;
            //End case MESSAGE_START 
            //Begin case MESSAGE_START 
            tick();
            //End case MESSAGE_START 
            //Begin case MESSAGE_TICK 
            tick();
            //End case MESSAGE_TICK 
            //Begin case MESSAGE_RESTART 
            {
                start(mRepeatLimit);
            } //End block
            //End case MESSAGE_RESTART 
            addTaint(msg.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.262 -0400", hash_original_method = "EE95900433272316B4E2225B22ADF455", hash_generated_method = "D040CE7E7CE40DE5F073E96904C55DFF")
         void tick() {
            removeMessages(MESSAGE_TICK);
            TextView textView;
            textView = mView.get();
            {
                boolean var9E991AA08531BDDAB4E605F21C288264_1638475871 = (textView != null && (textView.isFocused() || textView.isSelected()));
                {
                    mScroll += mScrollUnit;
                    {
                        mScroll = mMaxScroll;
                        sendEmptyMessageDelayed(MESSAGE_RESTART, MARQUEE_RESTART_DELAY);
                    } //End block
                    {
                        sendEmptyMessageDelayed(MESSAGE_TICK, MARQUEE_RESOLUTION);
                    } //End block
                    textView.invalidate();
                } //End block
            } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.263 -0400", hash_original_method = "559B799FFC0EAE80362A4924AC6B387F", hash_generated_method = "AEBFA0DC15336E07980941BA4CDDF3E1")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.263 -0400", hash_original_method = "E75276DE0DCFDFD0F42F697FF2F53A01", hash_generated_method = "0270D113FA80FB0D48DB11FA52CA1ECF")
        private void resetScroll() {
            mScroll = 0.0f;
            TextView textView;
            textView = mView.get();
            textView.invalidate();
            // ---------- Original Method ----------
            //mScroll = 0.0f;
            //final TextView textView = mView.get();
            //if (textView != null) textView.invalidate();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.275 -0400", hash_original_method = "C8CF1974A44593F9FA59199A16CE27AD", hash_generated_method = "5FBE0F9562E58CC08A6391C1AA79F9A0")
         void start(int repeatLimit) {
            {
                stop();
            } //End block
            mRepeatLimit = repeatLimit;
            TextView textView;
            textView = mView.get();
            {
                mStatus = MARQUEE_STARTING;
                mScroll = 0.0f;
                int textWidth;
                textWidth = textView.getWidth() - textView.getCompoundPaddingLeft() -
                        textView.getCompoundPaddingRight();
                float lineWidth;
                lineWidth = textView.mLayout.getLineWidth(0);
                float gap;
                gap = textWidth / 3.0f;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.277 -0400", hash_original_method = "8BEDD434588E893B08521C1E5E937982", hash_generated_method = "1817DFD6080F36A81CF4183FC073E6EE")
         float getGhostOffset() {
            float var546ADE640B6EDFBC8A086EF31347E768_397759555 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_397759555;
            // ---------- Original Method ----------
            //return mGhostOffset;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.278 -0400", hash_original_method = "FBB73F0BC2F425DEBE19335413BBBBD5", hash_generated_method = "6671A1E3A75051D335FE1C18654FC222")
         boolean shouldDrawLeftFade() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_835639525 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_835639525;
            // ---------- Original Method ----------
            //return mScroll <= mFadeStop;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.278 -0400", hash_original_method = "297E21CB54951ECF2F6E26FAB2DC7036", hash_generated_method = "9744D9CF477A3D7AAE24575FD2E8B72B")
         boolean shouldDrawGhost() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_443039580 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_443039580;
            // ---------- Original Method ----------
            //return mStatus == MARQUEE_RUNNING && mScroll > mGhostStart;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.282 -0400", hash_original_method = "9069B9288EAB1BBCE4A11291BAF7E3F4", hash_generated_method = "5EBACBB6A7D95B6C769B3675AF730275")
         boolean isRunning() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1107413483 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1107413483;
            // ---------- Original Method ----------
            //return mStatus == MARQUEE_RUNNING;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.286 -0400", hash_original_method = "57F6027DED5DA77924B224C2BB22701E", hash_generated_method = "FCDBCE89236FF9433505603708D40548")
         boolean isStopped() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1654008313 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1654008313;
            // ---------- Original Method ----------
            //return mStatus == MARQUEE_STOPPED;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.286 -0400", hash_original_field = "6AC58C16DFF7294B5A4A431E14108EC2", hash_generated_field = "3563E74EAB7E7E231D93CF3A06D5A09B")

        private static float MARQUEE_DELTA_MAX = 0.07f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.286 -0400", hash_original_field = "E4728EDDA8B3D2C91D4624E788111E01", hash_generated_field = "411D8C0BCA8B778723D4319E5F0D8FB7")

        private static int MARQUEE_DELAY = 1200;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.286 -0400", hash_original_field = "3B4EF5CF2B395DE1542F2D8F5DFC67D7", hash_generated_field = "1A734964A2757FC5BB0AB0F4A574234A")

        private static int MARQUEE_RESTART_DELAY = 1200;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.287 -0400", hash_original_field = "8B25855C58895BDA613FD9FD4275C244", hash_generated_field = "86615253C897C2D5005D2699B9410376")

        private static int MARQUEE_RESOLUTION = 1000 / 30;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.287 -0400", hash_original_field = "CC2183A454A8CF823D5EB4FBCB7AB848", hash_generated_field = "F0B7877B88C233B83176594AA188B196")

        private static int MARQUEE_PIXELS_PER_SECOND = 30;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.287 -0400", hash_original_field = "83CB05D0724C63AFF22CF998C0771186", hash_generated_field = "ED8787CDF08C784A8993025B84FD25BA")

        private static byte MARQUEE_STOPPED = 0x0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.287 -0400", hash_original_field = "524F0584151994C79B9191730415DC22", hash_generated_field = "9BC8B6F009D1CC6C63E8308F3F7A7B62")

        private static byte MARQUEE_STARTING = 0x1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.287 -0400", hash_original_field = "1E99F17DD0A7ACAF311564610127CEBC", hash_generated_field = "1303EE4CB26116FFBB019BC28ED0DAF8")

        private static byte MARQUEE_RUNNING = 0x2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.287 -0400", hash_original_field = "D45CAA01F64232AF582D5B7E05E9FD00", hash_generated_field = "6B275C00DA7B854335B1C1242430A946")

        private static int MESSAGE_START = 0x1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.287 -0400", hash_original_field = "03DF5DD145AC4F2C9B8B8DE9EB6C0135", hash_generated_field = "FFA7DB61484A131505C6ABC3EB3EDD70")

        private static int MESSAGE_TICK = 0x2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.287 -0400", hash_original_field = "CDACA6038BA86AB9AABBD482EB6DF6F1", hash_generated_field = "C77292E72AE4AFF3850BADF34A738E9E")

        private static int MESSAGE_RESTART = 0x3;
    }


    
    private class EasyEditSpanController {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.287 -0400", hash_original_field = "BF75305BD1095CDED8E2337DB678670B", hash_generated_field = "93AE44B2D9F293D0BC2408DE643B7037")

        private EasyEditPopupWindow mPopupWindow;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.287 -0400", hash_original_field = "EDF25D09739D26EF9ECAF542864CC487", hash_generated_field = "D79D9256BE9491F92C92FB8BCC6A61DC")

        private EasyEditSpan mEasyEditSpan;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.287 -0400", hash_original_field = "6613F0388A136327FDBD8526D1D89DBF", hash_generated_field = "EE65FA1568E5725BCA3859DE8F52F788")

        private Runnable mHidePopup;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.287 -0400", hash_original_method = "2E07A306089CEDB8C207DEEB8EF7B36E", hash_generated_method = "2E07A306089CEDB8C207DEEB8EF7B36E")
        public EasyEditSpanController ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.288 -0400", hash_original_method = "EDC90536D8A41E1495260C5D2B0A4CB4", hash_generated_method = "D5E089DE56B1FB79DD2F6BF40F47DD08")
        private void hide() {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.315 -0400", hash_original_method = "400D6F397C7E694E5D2CC26E5076AFF1", hash_generated_method = "14ADB649F6501FBB9F0B4D3C336604E0")
        public void onTextChange(CharSequence buffer) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            adjustSpans(mText);
            {
                boolean varF8A6C8295E7EAA2547FD83421DD5A52E_484036568 = (getWindowVisibility() != View.VISIBLE);
            } //End collapsed parenthetic
            InputMethodManager imm;
            imm = InputMethodManager.peekInstance();
            {
                boolean var508564AC928822EB83F33B379556AE9E_2057328864 = (!(TextView.this instanceof ExtractEditText)
                    && imm != null && imm.isFullscreenMode());
            } //End collapsed parenthetic
            {
                {
                    ((Spannable) mText).removeSpan(mEasyEditSpan);
                } //End block
                mEasyEditSpan = null;
            } //End block
            {
                boolean varB1ED909A9B3812E269C4F5A19320975C_625818922 = (mPopupWindow != null && mPopupWindow.isShowing());
                {
                    mPopupWindow.hide();
                } //End block
            } //End collapsed parenthetic
            {
                mEasyEditSpan = getSpan((Spanned) buffer);
                {
                    {
                        mPopupWindow = new EasyEditPopupWindow();
                        mHidePopup = new Runnable() {                            
                            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.314 -0400", hash_original_method = "21815FA27ABEB649DED6A46E4F97905B", hash_generated_method = "891AC471650FB94DC3945684A90962FE")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.316 -0400", hash_original_method = "BE935C64EC56548296E167AABD21FC2C", hash_generated_method = "805AF49894D464AB30624EE30DAFFEFF")
        private void adjustSpans(CharSequence buffer) {
            {
                Spannable spannable;
                spannable = (Spannable) buffer;
                EasyEditSpan[] spans;
                spans = spannable.getSpans(0, spannable.length(),
                        EasyEditSpan.class);
                {
                    int i;
                    i = 0;
                    {
                        spannable.removeSpan(spans[i]);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            addTaint(buffer.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.316 -0400", hash_original_method = "D4568FCB8F606B40F32BB2FF24EF8AE2", hash_generated_method = "02D66CF5479D21408B42919C9A7F0079")
        private void removeSpans(CharSequence buffer) {
            {
                Spannable spannable;
                spannable = (Spannable) buffer;
                EasyEditSpan[] spans;
                spans = spannable.getSpans(0, spannable.length(),
                        EasyEditSpan.class);
                {
                    int i;
                    i = 0;
                    {
                        spannable.removeSpan(spans[i]);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            addTaint(buffer.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.320 -0400", hash_original_method = "FD0036F1377269974D72D9C2BC2EFAA3", hash_generated_method = "C3A33791531E75386942EEA54473288B")
        private EasyEditSpan getSpan(Spanned spanned) {
            EasyEditSpan varB4EAC82CA7396A68D541C85D26508E83_293177933 = null; //Variable for return #1
            EasyEditSpan varB4EAC82CA7396A68D541C85D26508E83_2003712902 = null; //Variable for return #2
            EasyEditSpan[] easyEditSpans;
            easyEditSpans = spanned.getSpans(0, spanned.length(),
                    EasyEditSpan.class);
            {
                varB4EAC82CA7396A68D541C85D26508E83_293177933 = null;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_2003712902 = easyEditSpans[0];
            } //End block
            addTaint(spanned.getTaint());
            EasyEditSpan varA7E53CE21691AB073D9660D615818899_1289674376; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1289674376 = varB4EAC82CA7396A68D541C85D26508E83_293177933;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1289674376 = varB4EAC82CA7396A68D541C85D26508E83_2003712902;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1289674376.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1289674376;
            // ---------- Original Method ----------
            //EasyEditSpan[] easyEditSpans = spanned.getSpans(0, spanned.length(),
                    //EasyEditSpan.class);
            //if (easyEditSpans.length == 0) {
                //return null;
            //} else {
                //return easyEditSpans[0];
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.320 -0400", hash_original_field = "518CAC1482FD68AED9B6AA4AE599C5BA", hash_generated_field = "7DBA2E3F96ECCFCF19F5B9385C5EC287")

        private static int DISPLAY_TIMEOUT_MS = 3000;
    }


    
    private class EasyEditPopupWindow extends PinnedPopupWindow implements OnClickListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.320 -0400", hash_original_field = "2BA836DA894A791F59023D6C9F9022B2", hash_generated_field = "4DBBAC6216F3AE0A070BCCEDE828B9C4")

        private TextView mDeleteTextView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.320 -0400", hash_original_field = "EDF25D09739D26EF9ECAF542864CC487", hash_generated_field = "D79D9256BE9491F92C92FB8BCC6A61DC")

        private EasyEditSpan mEasyEditSpan;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.320 -0400", hash_original_method = "8F35ACDDC3336F80EA4BC14F76358073", hash_generated_method = "8F35ACDDC3336F80EA4BC14F76358073")
        public EasyEditPopupWindow ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.321 -0400", hash_original_method = "57DC4A0271DC22A49F19ED5E582C7E72", hash_generated_method = "B54116FA46C572BBDB8F1D27160DF59E")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.321 -0400", hash_original_method = "128C0E079A8A50F8B38C36065ADCA0D3", hash_generated_method = "42EAEE7B64D00670C65005FC26908836")
        @Override
        protected void initContentView() {
            LinearLayout linearLayout;
            linearLayout = new LinearLayout(TextView.this.getContext());
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            mContentView = linearLayout;
            mContentView.setBackgroundResource(
                    com.android.internal.R.drawable.text_edit_side_paste_window);
            LayoutInflater inflater;
            inflater = (LayoutInflater)TextView.this.mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            LayoutParams wrapContent;
            wrapContent = new LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            mDeleteTextView = (TextView) inflater.inflate(POPUP_TEXT_LAYOUT, null);
            mDeleteTextView.setLayoutParams(wrapContent);
            mDeleteTextView.setText(com.android.internal.R.string.delete);
            mDeleteTextView.setOnClickListener(this);
            mContentView.addView(mDeleteTextView);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.322 -0400", hash_original_method = "EB30ECB06A4982701AF1B8E86934D288", hash_generated_method = "6C6061653D5DFF66F75183D85AEDB5A1")
        public void show(EasyEditSpan easyEditSpan) {
            mEasyEditSpan = easyEditSpan;
            super.show();
            // ---------- Original Method ----------
            //mEasyEditSpan = easyEditSpan;
            //super.show();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.322 -0400", hash_original_method = "C063208218D3B6E27F261A5578D5D2B9", hash_generated_method = "BB6766D2DF8187BF32287319D922E0D6")
        @Override
        public void onClick(View view) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                Editable editable;
                editable = (Editable) mText;
                int start;
                start = editable.getSpanStart(mEasyEditSpan);
                int end;
                end = editable.getSpanEnd(mEasyEditSpan);
                {
                    deleteText_internal(start, end);
                } //End block
            } //End block
            addTaint(view.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.322 -0400", hash_original_method = "7C1AF53FA575FE23CA1F61E7AC0FA9D9", hash_generated_method = "140D1C08D3A7AAFD887DAAF2ADD74632")
        @Override
        protected int getTextOffset() {
            Editable editable;
            editable = (Editable) mText;
            int var250A5466B0BCD45EA6B6F640A95FFADA_621591970 = (editable.getSpanEnd(mEasyEditSpan));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1424981064 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1424981064;
            // ---------- Original Method ----------
            //Editable editable = (Editable) mText;
            //return editable.getSpanEnd(mEasyEditSpan);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.322 -0400", hash_original_method = "87FFA2F036D6FB2F317732DF596E05CB", hash_generated_method = "7E75BD8F74A8E39E28700D73542F03E3")
        @Override
        protected int getVerticalLocalPosition(int line) {
            int varC530C119C90DEC1E0FFF523326A5138A_961113248 = (mLayout.getLineBottom(line));
            addTaint(line);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1825085338 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1825085338;
            // ---------- Original Method ----------
            //return mLayout.getLineBottom(line);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.323 -0400", hash_original_method = "48C7510506F753F88F1EBACB4F114059", hash_generated_method = "8A9970BA79C0E99D4338ADE2CDA71784")
        @Override
        protected int clipVertically(int positionY) {
            addTaint(positionY);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1004723402 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1004723402;
            // ---------- Original Method ----------
            //return positionY;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.323 -0400", hash_original_field = "A8B4CFDAA994C026529F1F31A401F449", hash_generated_field = "D29ED067583B757536DBF4FC9F74BF08")

        private static int POPUP_TEXT_LAYOUT = com.android.internal.R.layout.text_edit_action_popup_text;
    }


    
    private class ChangeWatcher implements TextWatcher, SpanWatcher {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.323 -0400", hash_original_field = "8F45542597C289D2929CD8F63821BE5A", hash_generated_field = "9AF7D20EAE94D8E70217DF1DC0F4EBF6")

        private CharSequence mBeforeText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.323 -0400", hash_original_field = "9E7C9CD25D6914A1724D16D10C6EB9C1", hash_generated_field = "B09D56552589EA59BDE2FAB6B8B27882")

        private EasyEditSpanController mEasyEditSpanController;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.323 -0400", hash_original_method = "41973225A14E12423F2683848135C141", hash_generated_method = "ACD55DB72B049A56A0B6E74650948667")
        private  ChangeWatcher() {
            mEasyEditSpanController = new EasyEditSpanController();
            // ---------- Original Method ----------
            //mEasyEditSpanController = new EasyEditSpanController();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.324 -0400", hash_original_method = "720D371807084B06633282B0029EC53C", hash_generated_method = "50920DDB1B995363C13588889001631D")
        public void beforeTextChanged(CharSequence buffer, int start,
                                      int before, int after) {
            {
                boolean var58E0C133E73001AE9B82AF19F4A709BD_56755937 = (AccessibilityManager.getInstance(mContext).isEnabled()
                    && !isPasswordInputType(mInputType)
                    && !hasPasswordTransformationMethod());
                {
                    mBeforeText = buffer.toString();
                } //End block
            } //End collapsed parenthetic
            TextView.this.sendBeforeTextChanged(buffer, start, before, after);
            addTaint(start);
            addTaint(before);
            addTaint(after);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.324 -0400", hash_original_method = "94F338CF670251E301395B1B01A5E75A", hash_generated_method = "5CCCEFA54D9B8CAFD6C2C6988A226F5F")
        public void onTextChanged(CharSequence buffer, int start,
                                  int before, int after) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            TextView.this.handleTextChanged(buffer, start, before, after);
            mEasyEditSpanController.onTextChange(buffer);
            {
                boolean var2CE54939AB34C356367D1A2596516E7D_288126059 = (AccessibilityManager.getInstance(mContext).isEnabled() &&
                    (isFocused() || isSelected() && isShown()));
                {
                    sendAccessibilityEventTypeViewTextChanged(mBeforeText, start, before, after);
                    mBeforeText = null;
                } //End block
            } //End collapsed parenthetic
            addTaint(buffer.getTaint());
            addTaint(start);
            addTaint(before);
            addTaint(after);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.336 -0400", hash_original_method = "36BCFC0FC76553AA6F29D2F790EC381C", hash_generated_method = "3F6778FD0636206C5BFA0E37FE3FC75A")
        public void afterTextChanged(Editable buffer) {
            TextView.this.sendAfterTextChanged(buffer);
            {
                boolean varD9AAC580C15E35EE8A21660BC6977A2B_1704876105 = (MetaKeyKeyListener.getMetaState(buffer, MetaKeyKeyListener.META_SELECTING) != 0);
                {
                    MetaKeyKeyListener.stopSelecting(TextView.this, buffer);
                } //End block
            } //End collapsed parenthetic
            addTaint(buffer.getTaint());
            // ---------- Original Method ----------
            //if (DEBUG_EXTRACT) Log.v(LOG_TAG, "afterTextChanged: " + buffer);
            //TextView.this.sendAfterTextChanged(buffer);
            //if (MetaKeyKeyListener.getMetaState(buffer, MetaKeyKeyListener.META_SELECTING) != 0) {
                //MetaKeyKeyListener.stopSelecting(TextView.this, buffer);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.337 -0400", hash_original_method = "6F9EDB470C5AD5F1E23596AFEC700ED3", hash_generated_method = "B7F6FF672D019D3885D6E7BE0DED86AB")
        public void onSpanChanged(Spannable buf,
                                  Object what, int s, int e, int st, int en) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            TextView.this.spanChange(buf, what, s, st, e, en);
            addTaint(buf.getTaint());
            addTaint(what.getTaint());
            addTaint(s);
            addTaint(e);
            addTaint(st);
            addTaint(en);
            // ---------- Original Method ----------
            //if (DEBUG_EXTRACT) Log.v(LOG_TAG, "onSpanChanged s=" + s + " e=" + e
                    //+ " st=" + st + " en=" + en + " what=" + what + ": " + buf);
            //TextView.this.spanChange(buf, what, s, st, e, en);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.337 -0400", hash_original_method = "B2A75CCE31AAD63896365B7E450A433A", hash_generated_method = "28579E6C19D5D69D3CDB51F823A3EE03")
        public void onSpanAdded(Spannable buf, Object what, int s, int e) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            TextView.this.spanChange(buf, what, -1, s, -1, e);
            addTaint(buf.getTaint());
            addTaint(what.getTaint());
            addTaint(s);
            addTaint(e);
            // ---------- Original Method ----------
            //if (DEBUG_EXTRACT) Log.v(LOG_TAG, "onSpanAdded s=" + s + " e=" + e
                    //+ " what=" + what + ": " + buf);
            //TextView.this.spanChange(buf, what, -1, s, -1, e);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.338 -0400", hash_original_method = "11DC5396F5D4F6210F8F1D677B03B553", hash_generated_method = "F5A56804D6D5F23A672E7B91E296AC47")
        public void onSpanRemoved(Spannable buf, Object what, int s, int e) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            TextView.this.spanChange(buf, what, s, -1, e, -1);
            addTaint(buf.getTaint());
            addTaint(what.getTaint());
            addTaint(s);
            addTaint(e);
            // ---------- Original Method ----------
            //if (DEBUG_EXTRACT) Log.v(LOG_TAG, "onSpanRemoved s=" + s + " e=" + e
                    //+ " what=" + what + ": " + buf);
            //TextView.this.spanChange(buf, what, s, -1, e, -1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.338 -0400", hash_original_method = "FB97DDA9E5EB9C645F7C42D5DCEE1A36", hash_generated_method = "E6D7B22DFBEA218F7C05A2FD98CE4F0E")
        private void hideControllers() {
            mEasyEditSpanController.hide();
            // ---------- Original Method ----------
            //mEasyEditSpanController.hide();
        }

        
    }


    
    private static class Blink extends Handler implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.338 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "378CC9BF8F5DA198EF400A97F72A70A3")

        private WeakReference<TextView> mView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.338 -0400", hash_original_field = "1813307BAF5C3869F23F1AC0318DE4BE", hash_generated_field = "582F041564D3B399F48E8AE230C16FEE")

        private boolean mCancelled;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.338 -0400", hash_original_method = "B3B341EB4735766A8EE81E50FC9FCC5D", hash_generated_method = "AC11D259FD065166E4248B5E715529DE")
        public  Blink(TextView v) {
            mView = new WeakReference<TextView>(v);
            // ---------- Original Method ----------
            //mView = new WeakReference<TextView>(v);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.342 -0400", hash_original_method = "ACD5284757446306F2E6E1BADED5158A", hash_generated_method = "30A7352FE22BE1E730D8EAE7655A9AF5")
        public void run() {
            removeCallbacks(Blink.this);
            TextView tv;
            tv = mView.get();
            {
                boolean var397A686FF4DC8BC40834AF9DD4FC6DD1_644455921 = (tv != null && tv.shouldBlink());
                {
                    {
                        tv.invalidateCursorPath();
                    } //End block
                    postAtTime(this, SystemClock.uptimeMillis() + BLINK);
                } //End block
            } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.346 -0400", hash_original_method = "A015A25EF128A9724656D77FE5A94B9E", hash_generated_method = "CB1FFD1BF8FD38BFCDE2C9951972BDB6")
         void cancel() {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.346 -0400", hash_original_method = "A06944554EAF73141DA4277B06D0E2BD", hash_generated_method = "EA43542F6DD16B86D3EB9C7A9CB5E56B")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.346 -0400", hash_original_field = "D78BADC424EA34A1D9F76B53AD0FC966", hash_generated_field = "71C1F40F965BD09DE6D53C89B0AA9A2B")

        public TextView sourceTextView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.346 -0400", hash_original_field = "EA2B2676C28C0DB26D39331A336C6B92", hash_generated_field = "D3D73C9CC2FDA0D0E8781D6E9A3253AA")

        public int start;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.346 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "109F16BFAE7B1E88A50CE09673D176EC")

        public int end;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.348 -0400", hash_original_method = "78F248ABC93BE1F7C9E297B91A3F7D55", hash_generated_method = "86EC9C6CD36D42E4BFA57141505C8082")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.349 -0400", hash_original_field = "05B14654782AB408227B39473652C629", hash_generated_field = "99FAFAA6B14FCB7079EA24B50C3602C6")

        private int MAXIMUM_NUMBER_OF_LISTENERS = 6;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.349 -0400", hash_original_field = "501DACB43832A22DCD15C3BD00A05F36", hash_generated_field = "6E86BBFEE5AB32BEC4338815D88DA562")

        private TextViewPositionListener[] mPositionListeners = new TextViewPositionListener[MAXIMUM_NUMBER_OF_LISTENERS];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.349 -0400", hash_original_field = "16BC92FD11AF81D9886E550CE0712C57", hash_generated_field = "E1EB7F48AC3DAF5A3BC279FE32D5BD2C")

        private boolean mCanMove[] = new boolean[MAXIMUM_NUMBER_OF_LISTENERS];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.349 -0400", hash_original_field = "03D5F02C0AF2CE2B038F91466D8238BA", hash_generated_field = "348E54253A3677FA237DAA94481A3907")

        private boolean mPositionHasChanged = true;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.349 -0400", hash_original_field = "E33EA5C4D485469D2432B3A781CD5014", hash_generated_field = "B562606C08FEFE4EA880E0BAFC4807BC")

        private int mPositionX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.349 -0400", hash_original_field = "5EF2225F886100AA279B39F41428F3C5", hash_generated_field = "30733FB91B36B499B68F008F42192052")

        private int mPositionY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.356 -0400", hash_original_field = "9EDA655FC50499AF5231120C47804B4D", hash_generated_field = "3FFCBF0CA982B9F89F06AD1BE7BFADF1")

        private int mNumberOfListeners;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.356 -0400", hash_original_field = "C40349F37B1FBD37DCE18B5033BE6961", hash_generated_field = "165D6DE2599A80133D2595B1A8A737DE")

        private boolean mScrollHasChanged;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.356 -0400", hash_original_method = "7156A70387EDCE5A8031F9E196BAE1E0", hash_generated_method = "7156A70387EDCE5A8031F9E196BAE1E0")
        public PositionListener ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.360 -0400", hash_original_method = "2CEF91B445974B7F0C1F2F2831D38171", hash_generated_method = "0D91644297BB61BF1BAC4E484469490E")
        public void addSubscriber(TextViewPositionListener positionListener, boolean canMove) {
            {
                updatePosition();
                ViewTreeObserver vto;
                vto = TextView.this.getViewTreeObserver();
                vto.addOnPreDrawListener(this);
            } //End block
            int emptySlotIndex;
            emptySlotIndex = -1;
            {
                int i;
                i = 0;
                {
                    TextViewPositionListener listener;
                    listener = mPositionListeners[i];
                    {
                        emptySlotIndex = i;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            mPositionListeners[emptySlotIndex] = positionListener;
            mCanMove[emptySlotIndex] = canMove;
            addTaint(canMove);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.366 -0400", hash_original_method = "F36C99880C8165921A7F03E512CBB647", hash_generated_method = "C3EBF498E8D7259B74F28B3B5E860D9A")
        public void removeSubscriber(TextViewPositionListener positionListener) {
            {
                int i;
                i = 0;
                {
                    {
                        mPositionListeners[i] = null;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                ViewTreeObserver vto;
                vto = TextView.this.getViewTreeObserver();
                vto.removeOnPreDrawListener(this);
            } //End block
            addTaint(positionListener.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.366 -0400", hash_original_method = "256A376A54FD4CD53D18A0F020A0467C", hash_generated_method = "F088C4316E936CCBD9000C2C5C8E71A8")
        public int getPositionX() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1467757385 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1467757385;
            // ---------- Original Method ----------
            //return mPositionX;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.366 -0400", hash_original_method = "4CCC26BBD5544F9405CBD90295EAF862", hash_generated_method = "B44E15ADFBE59E408DCBDFBD70F9E481")
        public int getPositionY() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_485650718 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_485650718;
            // ---------- Original Method ----------
            //return mPositionY;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.367 -0400", hash_original_method = "4634D6360837F07AB476144D9CD27591", hash_generated_method = "E28AEE1052FCB195C5FE0054ABC64429")
        @Override
        public boolean onPreDraw() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            updatePosition();
            {
                int i;
                i = 0;
                {
                    {
                        TextViewPositionListener positionListener;
                        positionListener = mPositionListeners[i];
                        {
                            positionListener.updatePosition(mPositionX, mPositionY,
                                mPositionHasChanged, mScrollHasChanged);
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
            mScrollHasChanged = false;
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_190357131 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_190357131;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.367 -0400", hash_original_method = "65C89C768DE236BFCC52E144F22BF85B", hash_generated_method = "142481B1DEA1328234C9335DBA74DC0E")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.374 -0400", hash_original_method = "45AFA571A6FC9FC84FC093F1FB86DABC", hash_generated_method = "85B5F4ED6EC23E44740E0F696105857A")
        public void onScrollChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mScrollHasChanged = true;
            // ---------- Original Method ----------
            //mScrollHasChanged = true;
        }

        
    }


    
    private abstract class PinnedPopupWindow implements TextViewPositionListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.374 -0400", hash_original_field = "BF75305BD1095CDED8E2337DB678670B", hash_generated_field = "5CD7D447C671D86883FAE32274213485")

        protected PopupWindow mPopupWindow;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.374 -0400", hash_original_field = "9E8FE4D07A56D54AEE159583A4429FE8", hash_generated_field = "B572FFE44EB19A4D34C75C5D0C555606")

        protected ViewGroup mContentView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.374 -0400", hash_original_field = "E33EA5C4D485469D2432B3A781CD5014", hash_generated_field = "2AF62DB1E3AEF057C912EFF081692BF4")

        int mPositionX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.374 -0400", hash_original_field = "5EF2225F886100AA279B39F41428F3C5", hash_generated_field = "81023086806A696B7ADDE3F7B5299B8C")

        int mPositionY;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.379 -0400", hash_original_method = "596A5600AE60FE2F4CDE653E6E3819B3", hash_generated_method = "1059D7A0032ED6D1E1FCB675ACE28E5A")
        public  PinnedPopupWindow() {
            createPopupWindow();
            mPopupWindow.setWindowLayoutType(WindowManager.LayoutParams.TYPE_APPLICATION_SUB_PANEL);
            mPopupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
            mPopupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
            initContentView();
            LayoutParams wrapContent;
            wrapContent = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
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

        
        protected abstract void createPopupWindow();

        
        protected abstract void initContentView();

        
        protected abstract int getTextOffset();

        
        protected abstract int getVerticalLocalPosition(int line);

        
        protected abstract int clipVertically(int positionY);

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.391 -0400", hash_original_method = "6C3D8663E8D10274240ADCEB82AE9A86", hash_generated_method = "9F69F4BE8887C9F2FC737CBDDEB46664")
        public void show() {
            TextView.this.getPositionListener().addSubscriber(this, false );
            computeLocalPosition();
            PositionListener positionListener;
            positionListener = TextView.this.getPositionListener();
            updatePosition(positionListener.getPositionX(), positionListener.getPositionY());
            // ---------- Original Method ----------
            //TextView.this.getPositionListener().addSubscriber(this, false );
            //computeLocalPosition();
            //final PositionListener positionListener = TextView.this.getPositionListener();
            //updatePosition(positionListener.getPositionX(), positionListener.getPositionY());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.391 -0400", hash_original_method = "AFC1F8ABC6317EB9C1F375A956F1E985", hash_generated_method = "DEDDDD288DD31044038011AC8C0806CD")
        protected void measureContent() {
            DisplayMetrics displayMetrics;
            displayMetrics = mContext.getResources().getDisplayMetrics();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.392 -0400", hash_original_method = "422A968B45C30695D0BEB603E4E72147", hash_generated_method = "0F0046847459D3DFC43A3885BFAEEFE6")
        private void computeLocalPosition() {
            measureContent();
            int width;
            width = mContentView.getMeasuredWidth();
            int offset;
            offset = getTextOffset();
            mPositionX = (int) (mLayout.getPrimaryHorizontal(offset) - width / 2.0f);
            mPositionX += viewportToContentHorizontalOffset();
            int line;
            line = mLayout.getLineForOffset(offset);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.399 -0400", hash_original_method = "3C2767EB11AB639449E091DD5FC9CB2A", hash_generated_method = "53CF7BFED37CA6801A75B30634EC9932")
        private void updatePosition(int parentPositionX, int parentPositionY) {
            int positionX;
            positionX = parentPositionX + mPositionX;
            int positionY;
            positionY = parentPositionY + mPositionY;
            positionY = clipVertically(positionY);
            DisplayMetrics displayMetrics;
            displayMetrics = mContext.getResources().getDisplayMetrics();
            int width;
            width = mContentView.getMeasuredWidth();
            positionX = Math.min(displayMetrics.widthPixels - width, positionX);
            positionX = Math.max(0, positionX);
            {
                boolean varC328115627DFB8318D2C3484959F5057_1336594201 = (isShowing());
                {
                    mPopupWindow.update(positionX, positionY, -1, -1);
                } //End block
                {
                    mPopupWindow.showAtLocation(TextView.this, Gravity.NO_GRAVITY,
                        positionX, positionY);
                } //End block
            } //End collapsed parenthetic
            addTaint(parentPositionX);
            addTaint(parentPositionY);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.400 -0400", hash_original_method = "9C51A5E6940629038A75840F54DCC577", hash_generated_method = "25525D9132782287790F8AECFEF17792")
        public void hide() {
            mPopupWindow.dismiss();
            TextView.this.getPositionListener().removeSubscriber(this);
            // ---------- Original Method ----------
            //mPopupWindow.dismiss();
            //TextView.this.getPositionListener().removeSubscriber(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.404 -0400", hash_original_method = "48D3C5BA4737FA32BEEBA9E620F4B3A6", hash_generated_method = "3DD37E4CE27074A666F77C034C7366EE")
        @Override
        public void updatePosition(int parentPositionX, int parentPositionY,
                boolean parentPositionChanged, boolean parentScrolled) {
            {
                boolean varF3B8B81213123AA3F897761495709D4F_1851409255 = (isShowing() && isOffsetVisible(getTextOffset()));
                {
                    computeLocalPosition();
                    updatePosition(parentPositionX, parentPositionY);
                } //End block
                {
                    hide();
                } //End block
            } //End collapsed parenthetic
            addTaint(parentPositionX);
            addTaint(parentPositionY);
            addTaint(parentPositionChanged);
            addTaint(parentScrolled);
            // ---------- Original Method ----------
            //if (isShowing() && isOffsetVisible(getTextOffset())) {
                //if (parentScrolled) computeLocalPosition();
                //updatePosition(parentPositionX, parentPositionY);
            //} else {
                //hide();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.404 -0400", hash_original_method = "771871BA8F1191126AB0990E72BA0594", hash_generated_method = "F4CEB8BF9B1BAE4E1D8E2D0DB24EED8E")
        public boolean isShowing() {
            boolean varDAFC67E962E4584ADE09C9440ED4C8A8_219329133 = (mPopupWindow.isShowing());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1905560754 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1905560754;
            // ---------- Original Method ----------
            //return mPopupWindow.isShowing();
        }

        
    }


    
    private class SuggestionsPopupWindow extends PinnedPopupWindow implements OnItemClickListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.405 -0400", hash_original_field = "0FA91084880C72F330A5711F5C8F7294", hash_generated_field = "DF9B2B2A32C54D35B3228EF58FDC6E78")

        private SuggestionInfo[] mSuggestionInfos;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.405 -0400", hash_original_field = "ABFE2C764E01946613EA91131C55961C", hash_generated_field = "596DE3763E763BE0F497615E1944F22C")

        private int mNumberOfSuggestions;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.405 -0400", hash_original_field = "033E344F7E287345FE0C52A3E5D61018", hash_generated_field = "7F93C534F2DFE71AE91870F5785F473D")

        private boolean mCursorWasVisibleBeforeSuggestions;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.405 -0400", hash_original_field = "CE1B361D3F408CDB879798047244ECC3", hash_generated_field = "641DA69AA28F49EC5C5A62A58B67E06A")

        private boolean mIsShowingUp = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.405 -0400", hash_original_field = "63055E537713F24C4C86BE6E68415FCE", hash_generated_field = "EC7957C4E8F88AF8C25BE753B9E15A66")

        private SuggestionAdapter mSuggestionsAdapter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.405 -0400", hash_original_field = "220190CD1D81D70302E1152A714AE917", hash_generated_field = "B69BA7FB6136A02593E4286BE8CED5FC")

        private Comparator<SuggestionSpan> mSuggestionSpanComparator;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.405 -0400", hash_original_field = "317A49877C593D0434BEE0A1DE61C446", hash_generated_field = "D0B23D9D75631218A54DFB41905818F7")

        private HashMap<SuggestionSpan, Integer> mSpansLengths;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.405 -0400", hash_original_method = "296BEE5065EB2EF8F82574E0F3647EF2", hash_generated_method = "C9FE2AEB77D5E42436EC81728FF2A6EB")
        public  SuggestionsPopupWindow() {
            mCursorWasVisibleBeforeSuggestions = mCursorVisible;
            mSuggestionSpanComparator = new SuggestionSpanComparator();
            mSpansLengths = new HashMap<SuggestionSpan, Integer>();
            // ---------- Original Method ----------
            //mCursorWasVisibleBeforeSuggestions = mCursorVisible;
            //mSuggestionSpanComparator = new SuggestionSpanComparator();
            //mSpansLengths = new HashMap<SuggestionSpan, Integer>();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.478 -0400", hash_original_method = "2C5A34402E22C878AD33972323D3ACC4", hash_generated_method = "1D075CDCA4E55E9BDBE0B58CE507DA50")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.479 -0400", hash_original_method = "E003230CE90A2ACB93D34E336B67EF46", hash_generated_method = "AABD926A4B110D202DE0215E6D29C7C0")
        @Override
        protected void initContentView() {
            ListView listView;
            listView = new ListView(TextView.this.getContext());
            mSuggestionsAdapter = new SuggestionAdapter();
            listView.setAdapter(mSuggestionsAdapter);
            listView.setOnItemClickListener(this);
            mContentView = listView;
            mSuggestionInfos = new SuggestionInfo[MAX_NUMBER_SUGGESTIONS + 2];
            {
                int i;
                i = 0;
                {
                    mSuggestionInfos[i] = new SuggestionInfo();
                } //End block
            } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.479 -0400", hash_original_method = "4C7853BA5C99567CAD84815F4452E5F9", hash_generated_method = "53C833DCADC46E4D1FADC632AF5C2F48")
        public boolean isShowingUp() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1828060114 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1828060114;
            // ---------- Original Method ----------
            //return mIsShowingUp;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.479 -0400", hash_original_method = "3914DCDC5DB3E14D1A1A163B7497EFBA", hash_generated_method = "CBD237ACC458BFEA613530AFCAFC26CB")
        public void onParentLostFocus() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mIsShowingUp = false;
            // ---------- Original Method ----------
            //mIsShowingUp = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.528 -0400", hash_original_method = "A21D81008594D05973BC33E2948715E2", hash_generated_method = "B59CF3726546A3769D8B75BAE65E237A")
        private SuggestionSpan[] getSuggestionSpans() {
            SuggestionSpan[] varB4EAC82CA7396A68D541C85D26508E83_790460990 = null; //Variable for return #1
            int pos;
            pos = TextView.this.getSelectionStart();
            Spannable spannable;
            spannable = (Spannable) TextView.this.mText;
            SuggestionSpan[] suggestionSpans;
            suggestionSpans = spannable.getSpans(pos, pos, SuggestionSpan.class);
            mSpansLengths.clear();
            {
                SuggestionSpan suggestionSpan = suggestionSpans[0];
                {
                    int start;
                    start = spannable.getSpanStart(suggestionSpan);
                    int end;
                    end = spannable.getSpanEnd(suggestionSpan);
                    mSpansLengths.put(suggestionSpan, Integer.valueOf(end - start));
                } //End block
            } //End collapsed parenthetic
            Arrays.sort(suggestionSpans, mSuggestionSpanComparator);
            varB4EAC82CA7396A68D541C85D26508E83_790460990 = suggestionSpans;
            varB4EAC82CA7396A68D541C85D26508E83_790460990.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_790460990;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.529 -0400", hash_original_method = "C166DC70ACC1835B92197E48CEB369FC", hash_generated_method = "A8A5518D4F8C68A79453BA1F542C22F5")
        @Override
        public void show() {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.538 -0400", hash_original_method = "8DDB7ED8B40AC8DC3D4FF9060DA06A2E", hash_generated_method = "02E628F06E4EAFB8076434D10898869A")
        @Override
        protected void measureContent() {
            DisplayMetrics displayMetrics;
            displayMetrics = mContext.getResources().getDisplayMetrics();
            int horizontalMeasure;
            horizontalMeasure = View.MeasureSpec.makeMeasureSpec(
                    displayMetrics.widthPixels, View.MeasureSpec.AT_MOST);
            int verticalMeasure;
            verticalMeasure = View.MeasureSpec.makeMeasureSpec(
                    displayMetrics.heightPixels, View.MeasureSpec.AT_MOST);
            int width;
            width = 0;
            View view;
            view = null;
            {
                int i;
                i = 0;
                {
                    view = mSuggestionsAdapter.getView(i, view, mContentView);
                    view.getLayoutParams().width = LayoutParams.WRAP_CONTENT;
                    view.measure(horizontalMeasure, verticalMeasure);
                    width = Math.max(width, view.getMeasuredWidth());
                } //End block
            } //End collapsed parenthetic
            mContentView.measure(
                    View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY),
                    verticalMeasure);
            Drawable popupBackground;
            popupBackground = mPopupWindow.getBackground();
            {
                mTempRect = new Rect();
                popupBackground.getPadding(mTempRect);
                width += mTempRect.left + mTempRect.right;
            } //End block
            mPopupWindow.setWidth(width);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.539 -0400", hash_original_method = "6820F3398D40FE1AF57F321A0934E9B8", hash_generated_method = "0273A3293CF892BEAB2CFBE9A909715D")
        @Override
        protected int getTextOffset() {
            int varBC8718B34213775E0E86386F1B689831_186000139 = (getSelectionStart());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1843514014 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1843514014;
            // ---------- Original Method ----------
            //return getSelectionStart();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.546 -0400", hash_original_method = "87FFA2F036D6FB2F317732DF596E05CB", hash_generated_method = "FA3EF5432DC3C4D25D48137525F83C22")
        @Override
        protected int getVerticalLocalPosition(int line) {
            int varC530C119C90DEC1E0FFF523326A5138A_589604731 = (mLayout.getLineBottom(line));
            addTaint(line);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2005333401 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2005333401;
            // ---------- Original Method ----------
            //return mLayout.getLineBottom(line);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.546 -0400", hash_original_method = "BF4D66DCAEE7C7EAD97F70105958840C", hash_generated_method = "042DED78287EAD89679CF8C57F459323")
        @Override
        protected int clipVertically(int positionY) {
            int height;
            height = mContentView.getMeasuredHeight();
            DisplayMetrics displayMetrics;
            displayMetrics = mContext.getResources().getDisplayMetrics();
            int var7B483E1A6A6C9FD21BCAE2DB59DA5C3D_102965121 = (Math.min(positionY, displayMetrics.heightPixels - height));
            addTaint(positionY);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1858737666 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1858737666;
            // ---------- Original Method ----------
            //final int height = mContentView.getMeasuredHeight();
            //final DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
            //return Math.min(positionY, displayMetrics.heightPixels - height);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.546 -0400", hash_original_method = "7609E0B22D3FA397AAE3B56DEE3F8C83", hash_generated_method = "F131B81970709DA64760DF4AAFB46819")
        @Override
        public void hide() {
            super.hide();
            // ---------- Original Method ----------
            //super.hide();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.587 -0400", hash_original_method = "43D89583824EB2CC5185C1DC5EA2D76A", hash_generated_method = "CAB22482F8087BAA09077DDB890DB881")
        private void updateSuggestions() {
            Spannable spannable;
            spannable = (Spannable) TextView.this.mText;
            SuggestionSpan[] suggestionSpans;
            suggestionSpans = getSuggestionSpans();
            int nbSpans;
            nbSpans = suggestionSpans.length;
            mNumberOfSuggestions = 0;
            int spanUnionStart;
            spanUnionStart = mText.length();
            int spanUnionEnd;
            spanUnionEnd = 0;
            SuggestionSpan misspelledSpan;
            misspelledSpan = null;
            int underlineColor;
            underlineColor = 0;
            {
                int spanIndex;
                spanIndex = 0;
                {
                    SuggestionSpan suggestionSpan;
                    suggestionSpan = suggestionSpans[spanIndex];
                    int spanStart;
                    spanStart = spannable.getSpanStart(suggestionSpan);
                    int spanEnd;
                    spanEnd = spannable.getSpanEnd(suggestionSpan);
                    spanUnionStart = Math.min(spanStart, spanUnionStart);
                    spanUnionEnd = Math.max(spanEnd, spanUnionEnd);
                    {
                        boolean var41ED7D23113F09082657F25EB9349901_595078343 = ((suggestionSpan.getFlags() & SuggestionSpan.FLAG_MISSPELLED) != 0);
                        {
                            misspelledSpan = suggestionSpan;
                        } //End block
                    } //End collapsed parenthetic
                    underlineColor = suggestionSpan.getUnderlineColor();
                    String[] suggestions;
                    suggestions = suggestionSpan.getSuggestions();
                    int nbSuggestions;
                    nbSuggestions = suggestions.length;
                    {
                        int suggestionIndex;
                        suggestionIndex = 0;
                        {
                            SuggestionInfo suggestionInfo;
                            suggestionInfo = mSuggestionInfos[mNumberOfSuggestions];
                            suggestionInfo.suggestionSpan = suggestionSpan;
                            suggestionInfo.suggestionIndex = suggestionIndex;
                            suggestionInfo.text.replace(0, suggestionInfo.text.length(),
                            suggestions[suggestionIndex]);
                            {
                                spanIndex = nbSpans;
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                int i;
                i = 0;
                {
                    highlightTextDifferences(mSuggestionInfos[i], spanUnionStart, spanUnionEnd);
                } //End block
            } //End collapsed parenthetic
            {
                int misspelledStart;
                misspelledStart = spannable.getSpanStart(misspelledSpan);
                int misspelledEnd;
                misspelledEnd = spannable.getSpanEnd(misspelledSpan);
                {
                    SuggestionInfo suggestionInfo;
                    suggestionInfo = mSuggestionInfos[mNumberOfSuggestions];
                    suggestionInfo.suggestionSpan = misspelledSpan;
                    suggestionInfo.suggestionIndex = ADD_TO_DICTIONARY;
                    suggestionInfo.text.replace(0, suggestionInfo.text.length(),
                            getContext().getString(com.android.internal.R.string.addToDictionary));
                    suggestionInfo.text.setSpan(suggestionInfo.highlightSpan, 0, 0,
                            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                } //End block
            } //End block
            SuggestionInfo suggestionInfo;
            suggestionInfo = mSuggestionInfos[mNumberOfSuggestions];
            suggestionInfo.suggestionSpan = null;
            suggestionInfo.suggestionIndex = DELETE_TEXT;
            suggestionInfo.text.replace(0, suggestionInfo.text.length(),
                    getContext().getString(com.android.internal.R.string.deleteText));
            suggestionInfo.text.setSpan(suggestionInfo.highlightSpan, 0, 0,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            mSuggestionRangeSpan = new SuggestionRangeSpan();
            {
                mSuggestionRangeSpan.setBackgroundColor(mHighlightColor);
            } //End block
            {
                float BACKGROUND_TRANSPARENCY;
                BACKGROUND_TRANSPARENCY = 0.4f;
                int newAlpha;
                newAlpha = (int) (Color.alpha(underlineColor) * BACKGROUND_TRANSPARENCY);
                mSuggestionRangeSpan.setBackgroundColor(
                        (underlineColor & 0x00FFFFFF) + (newAlpha << 24));
            } //End block
            spannable.setSpan(mSuggestionRangeSpan, spanUnionStart, spanUnionEnd,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            mSuggestionsAdapter.notifyDataSetChanged();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.589 -0400", hash_original_method = "9587A8E163DBC119C2F6F3B6CD33F02D", hash_generated_method = "CC7FF89F8DA5C5F540678E603DDC8439")
        private void highlightTextDifferences(SuggestionInfo suggestionInfo, int unionStart,
                int unionEnd) {
            Spannable text;
            text = (Spannable) mText;
            int spanStart;
            spanStart = text.getSpanStart(suggestionInfo.suggestionSpan);
            int spanEnd;
            spanEnd = text.getSpanEnd(suggestionInfo.suggestionSpan);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.593 -0400", hash_original_method = "73388536B046BC3C58C91A89E4930696", hash_generated_method = "B5C3AD2C68063004FA7C0FFCD04B2874")
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            Editable editable;
            editable = (Editable) mText;
            SuggestionInfo suggestionInfo;
            suggestionInfo = mSuggestionInfos[position];
            {
                int spanUnionStart;
                spanUnionStart = editable.getSpanStart(mSuggestionRangeSpan);
                int spanUnionEnd;
                spanUnionEnd = editable.getSpanEnd(mSuggestionRangeSpan);
                {
                    {
                        boolean var84A1A3093EA4E5C4D94593E4EC39F7A6_1323339224 = (spanUnionEnd < editable.length() &&
                            Character.isSpaceChar(editable.charAt(spanUnionEnd)) &&
                            (spanUnionStart == 0 ||
                            Character.isSpaceChar(editable.charAt(spanUnionStart - 1))));
                        {
                            spanUnionEnd = spanUnionEnd + 1;
                        } //End block
                    } //End collapsed parenthetic
                    deleteText_internal(spanUnionStart, spanUnionEnd);
                } //End block
                hide();
            } //End block
            int spanStart;
            spanStart = editable.getSpanStart(suggestionInfo.suggestionSpan);
            int spanEnd;
            spanEnd = editable.getSpanEnd(suggestionInfo.suggestionSpan);
            {
                hide();
            } //End block
            String originalText;
            originalText = mText.toString().substring(spanStart, spanEnd);
            {
                Intent intent;
                intent = new Intent(Settings.ACTION_USER_DICTIONARY_INSERT);
                intent.putExtra("word", originalText);
                intent.putExtra("locale", getTextServicesLocale().toString());
                intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_NEW_TASK);
                getContext().startActivity(intent);
                editable.removeSpan(suggestionInfo.suggestionSpan);
                updateSpellCheckSpans(spanStart, spanEnd, false);
            } //End block
            {
                SuggestionSpan[] suggestionSpans;
                suggestionSpans = editable.getSpans(spanStart, spanEnd,
                        SuggestionSpan.class);
                int length;
                length = suggestionSpans.length;
                int[] suggestionSpansStarts;
                suggestionSpansStarts = new int[length];
                int[] suggestionSpansEnds;
                suggestionSpansEnds = new int[length];
                int[] suggestionSpansFlags;
                suggestionSpansFlags = new int[length];
                {
                    int i;
                    i = 0;
                    {
                        SuggestionSpan suggestionSpan;
                        suggestionSpan = suggestionSpans[i];
                        suggestionSpansStarts[i] = editable.getSpanStart(suggestionSpan);
                        suggestionSpansEnds[i] = editable.getSpanEnd(suggestionSpan);
                        suggestionSpansFlags[i] = editable.getSpanFlags(suggestionSpan);
                        int suggestionSpanFlags;
                        suggestionSpanFlags = suggestionSpan.getFlags();
                        {
                            suggestionSpanFlags &= ~SuggestionSpan.FLAG_MISSPELLED;
                            suggestionSpanFlags &= ~SuggestionSpan.FLAG_EASY_CORRECT;
                            suggestionSpan.setFlags(suggestionSpanFlags);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                int suggestionStart;
                suggestionStart = suggestionInfo.suggestionStart;
                int suggestionEnd;
                suggestionEnd = suggestionInfo.suggestionEnd;
                String suggestion;
                suggestion = suggestionInfo.text.subSequence(
                        suggestionStart, suggestionEnd).toString();
                replaceText_internal(spanStart, spanEnd, suggestion);
                {
                    boolean varF79A598750887E0098FCD17D2840688C_1937348578 = (!TextUtils.isEmpty(
                        suggestionInfo.suggestionSpan.getNotificationTargetClassName()));
                    {
                        InputMethodManager imm;
                        imm = InputMethodManager.peekInstance();
                        {
                            imm.notifySuggestionPicked(suggestionInfo.suggestionSpan, originalText,
                                suggestionInfo.suggestionIndex);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                String[] suggestions;
                suggestions = suggestionInfo.suggestionSpan.getSuggestions();
                suggestions[suggestionInfo.suggestionIndex] = originalText;
                int lengthDifference;
                lengthDifference = suggestion.length() - (spanEnd - spanStart);
                {
                    int i;
                    i = 0;
                    {
                        {
                            setSpan_internal(suggestionSpans[i], suggestionSpansStarts[i],
                                suggestionSpansEnds[i] + lengthDifference, suggestionSpansFlags[i]);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                int newCursorPosition;
                newCursorPosition = spanEnd + lengthDifference;
                setCursorPosition_internal(newCursorPosition, newCursorPosition);
            } //End block
            hide();
            addTaint(parent.getTaint());
            addTaint(view.getTaint());
            addTaint(position);
            addTaint(id);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        private class CustomPopupWindow extends PopupWindow {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.596 -0400", hash_original_method = "76E50B1843F1484B0424D837A17373EE", hash_generated_method = "1AFBAA9D1921C4232962818BCDF02A5A")
            public  CustomPopupWindow(Context context, int defStyle) {
                super(context, null, defStyle);
                addTaint(context.getTaint());
                addTaint(defStyle);
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.597 -0400", hash_original_method = "3CF42E745499FBF7012823B6BEAA6E8B", hash_generated_method = "47316C1C5013CD3A25DE5141863DECD8")
            @Override
            public void dismiss() {
                super.dismiss();
                TextView.this.getPositionListener().removeSubscriber(SuggestionsPopupWindow.this);
                ((Spannable) mText).removeSpan(mSuggestionRangeSpan);
                setCursorVisible(mCursorWasVisibleBeforeSuggestions);
                {
                    boolean var6A9CA976632F28E945987868EDCFC2A8_2040576457 = (hasInsertionController());
                    {
                        getInsertionController().show();
                    } //End block
                } //End collapsed parenthetic
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
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.598 -0400", hash_original_field = "E0CCBC7742EB01E23FE8CAC0823856EC", hash_generated_field = "872480635E7B6A6F7A5C26A47649A56F")

            int suggestionStart;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.598 -0400", hash_original_field = "6BA3CAF30490DD7C10C1C1903B7C4EE6", hash_generated_field = "AC9E6ECED58FB8EF180833836DBCAA2D")

            int suggestionEnd;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.598 -0400", hash_original_field = "175FF5D2D5F25D80AF4E2ACDB6CE4C78", hash_generated_field = "46D75F50466858EB51EAFAE8BB212D75")

            SuggestionSpan suggestionSpan;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.598 -0400", hash_original_field = "79EA7A373645B1284FBF65D76846E660", hash_generated_field = "E2038F479A232C008DEC2C58888E09AF")

            int suggestionIndex;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.599 -0400", hash_original_field = "66AD57BB4DFC181279DFE9FFA45E67A0", hash_generated_field = "59937CFD4951C01B73A6EF4F5C4D841A")

            SpannableStringBuilder text = new SpannableStringBuilder();
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.600 -0400", hash_original_field = "4EE2EC84135A501AB5CC573E44247990", hash_generated_field = "18031134C63E234D2C3372B21DDAF396")

            TextAppearanceSpan highlightSpan = new TextAppearanceSpan(mContext,
                    android.R.style.TextAppearance_SuggestionHighlight);
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.601 -0400", hash_original_method = "613563FC71224468A61688B0DDA11E74", hash_generated_method = "613563FC71224468A61688B0DDA11E74")
            public SuggestionInfo ()
            {
                //Synthesized constructor
            }


        }


        
        private class SuggestionAdapter extends BaseAdapter {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.602 -0400", hash_original_field = "3F1D187921B41C54CE8DA3DC5FEF94E0", hash_generated_field = "0B998218A375E40727D240F37441CBEB")

            private LayoutInflater mInflater = (LayoutInflater) TextView.this.mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.602 -0400", hash_original_method = "56675D9229C135A53AD81FE91AEF2A02", hash_generated_method = "56675D9229C135A53AD81FE91AEF2A02")
            public SuggestionAdapter ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.609 -0400", hash_original_method = "02B536C5901CCC3DE9A3084712F44E45", hash_generated_method = "5F2DB03D9D5A4282A6717B2FFA1EEF7A")
            @Override
            public int getCount() {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_163734160 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_163734160;
                // ---------- Original Method ----------
                //return mNumberOfSuggestions;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.610 -0400", hash_original_method = "AB9B090A0CFC1C7403BFB1F3A94BDE2B", hash_generated_method = "3A4EB263EB976031076E30B7BC3B7B45")
            @Override
            public Object getItem(int position) {
                Object varB4EAC82CA7396A68D541C85D26508E83_2135265978 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_2135265978 = mSuggestionInfos[position];
                addTaint(position);
                varB4EAC82CA7396A68D541C85D26508E83_2135265978.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_2135265978;
                // ---------- Original Method ----------
                //return mSuggestionInfos[position];
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.611 -0400", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "12CABA3C622CBDF7ACD0F39C6811DF2B")
            @Override
            public long getItemId(int position) {
                addTaint(position);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_609409884 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_609409884;
                // ---------- Original Method ----------
                //return position;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.612 -0400", hash_original_method = "EB7381461F4FDD3A1934D144B2D8DE50", hash_generated_method = "C007E2342CB4B9E43BF0E4F8E4EE3323")
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View varB4EAC82CA7396A68D541C85D26508E83_732428954 = null; //Variable for return #1
                TextView textView;
                textView = (TextView) convertView;
                {
                    textView = (TextView) mInflater.inflate(mTextEditSuggestionItemLayout, parent,
                            false);
                } //End block
                SuggestionInfo suggestionInfo;
                suggestionInfo = mSuggestionInfos[position];
                textView.setText(suggestionInfo.text);
                {
                    textView.setCompoundDrawablesWithIntrinsicBounds(
                            com.android.internal.R.drawable.ic_suggestions_add, 0, 0, 0);
                } //End block
                {
                    textView.setCompoundDrawablesWithIntrinsicBounds(
                            com.android.internal.R.drawable.ic_suggestions_delete, 0, 0, 0);
                } //End block
                {
                    textView.setCompoundDrawables(null, null, null, null);
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_732428954 = textView;
                addTaint(position);
                addTaint(convertView.getTaint());
                addTaint(parent.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_732428954.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_732428954;
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
        }


        
        private class SuggestionSpanComparator implements Comparator<SuggestionSpan> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.619 -0400", hash_original_method = "22EA00C20DD1AAEDCB1186FBD85A1C5E", hash_generated_method = "22EA00C20DD1AAEDCB1186FBD85A1C5E")
            public SuggestionSpanComparator ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.620 -0400", hash_original_method = "D4A09F0FD84AABB3F69B7BD15CCD92DF", hash_generated_method = "4887352418A8482CABCCFE2BCA490E44")
            public int compare(SuggestionSpan span1, SuggestionSpan span2) {
                int flag1;
                flag1 = span1.getFlags();
                int flag2;
                flag2 = span2.getFlags();
                {
                    boolean easy1;
                    easy1 = (flag1 & SuggestionSpan.FLAG_EASY_CORRECT) != 0;
                    boolean easy2;
                    easy2 = (flag2 & SuggestionSpan.FLAG_EASY_CORRECT) != 0;
                    boolean misspelled1;
                    misspelled1 = (flag1 & SuggestionSpan.FLAG_MISSPELLED) != 0;
                    boolean misspelled2;
                    misspelled2 = (flag2 & SuggestionSpan.FLAG_MISSPELLED) != 0;
                } //End block
                int var69AC0EE4C836195D7157808630CBE920_1846220711 = (mSpansLengths.get(span1).intValue() - mSpansLengths.get(span2).intValue());
                addTaint(span1.getTaint());
                addTaint(span2.getTaint());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1319463825 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1319463825;
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.620 -0400", hash_original_field = "0C1515086A1226C970EE69A713DDD288", hash_generated_field = "5C2FFB12259A64BE7F61764D6DC2B4E8")

        private static int MAX_NUMBER_SUGGESTIONS = SuggestionSpan.SUGGESTIONS_MAX_SIZE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.620 -0400", hash_original_field = "9A3BE7FEF28DB01CA67A412C8A54D32F", hash_generated_field = "5AD5CE951035D20A8E3A9C2075383475")

        private static int ADD_TO_DICTIONARY = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.620 -0400", hash_original_field = "8C04FC6F385A06A2600D60FA7FE27F1A", hash_generated_field = "2D19AAC3C9EAE6D7368DF5E5B23489CA")

        private static int DELETE_TEXT = -2;
    }


    
    private class SelectionActionModeCallback implements ActionMode.Callback {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.620 -0400", hash_original_method = "0A08C97F3CA872D86BD6FA2FC1044E6A", hash_generated_method = "0A08C97F3CA872D86BD6FA2FC1044E6A")
        public SelectionActionModeCallback ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.638 -0400", hash_original_method = "9BA90F93967180A852B2E5C718CC8322", hash_generated_method = "3267A6F6B4C8314092334DAEE9C0E2FC")
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            TypedArray styledAttributes;
            styledAttributes = mContext.obtainStyledAttributes(
                    com.android.internal.R.styleable.SelectionModeDrawables);
            boolean allowText;
            allowText = getContext().getResources().getBoolean(
                    com.android.internal.R.bool.config_allowActionMenuItemTextWithIcon);
            mode.setTitle(allowText ?
                    mContext.getString(com.android.internal.R.string.textSelectionCABTitle) : null);
            mode.setSubtitle(null);
            int selectAllIconId;
            selectAllIconId = 0;
            {
                selectAllIconId = styledAttributes.getResourceId(
                        R.styleable.SelectionModeDrawables_actionModeSelectAllDrawable, 0);
            } //End block
            menu.add(0, ID_SELECT_ALL, 0, com.android.internal.R.string.selectAll).
                    setIcon(selectAllIconId).
                    setAlphabeticShortcut('a').
                    setShowAsAction(
                            MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
            {
                boolean var4087A2A70EC4D6F0409558B6C4258D55_1602071410 = (canCut());
                {
                    menu.add(0, ID_CUT, 0, com.android.internal.R.string.cut).
                    setIcon(styledAttributes.getResourceId(
                            R.styleable.SelectionModeDrawables_actionModeCutDrawable, 0)).
                    setAlphabeticShortcut('x').
                    setShowAsAction(
                            MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var6AFF96D83000797E509C5DFB5D242F34_325628763 = (canCopy());
                {
                    menu.add(0, ID_COPY, 0, com.android.internal.R.string.copy).
                    setIcon(styledAttributes.getResourceId(
                            R.styleable.SelectionModeDrawables_actionModeCopyDrawable, 0)).
                    setAlphabeticShortcut('c').
                    setShowAsAction(
                            MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
                } //End block
            } //End collapsed parenthetic
            {
                boolean varE76E09F5D4A1A03C0560F618234DAA0E_180291898 = (canPaste());
                {
                    menu.add(0, ID_PASTE, 0, com.android.internal.R.string.paste).
                        setIcon(styledAttributes.getResourceId(
                                R.styleable.SelectionModeDrawables_actionModePasteDrawable, 0)).
                        setAlphabeticShortcut('v').
                        setShowAsAction(
                                MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
                } //End block
            } //End collapsed parenthetic
            styledAttributes.recycle();
            {
                {
                    boolean var41AD4209F91C4824352554BD86D35AA9_1804513985 = (!mCustomSelectionActionModeCallback.onCreateActionMode(mode, menu));
                } //End collapsed parenthetic
            } //End block
            {
                boolean var7C369957434C066B84C56D449BD80D86_1909429460 = (menu.hasVisibleItems() || mode.getCustomView() != null);
                {
                    getSelectionController().show();
                } //End block
            } //End collapsed parenthetic
            addTaint(mode.getTaint());
            addTaint(menu.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_88343075 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_88343075;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.639 -0400", hash_original_method = "350C4916EAD271625C17FEEF1988576E", hash_generated_method = "5B38E87420E85EB03F48BC3B6C8328FD")
        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean varADAB2DA7C682C9431AEBA3613F94A97B_598658064 = (mCustomSelectionActionModeCallback.onPrepareActionMode(mode, menu));
            } //End block
            addTaint(mode.getTaint());
            addTaint(menu.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_739452717 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_739452717;
            // ---------- Original Method ----------
            //if (mCustomSelectionActionModeCallback != null) {
                //return mCustomSelectionActionModeCallback.onPrepareActionMode(mode, menu);
            //}
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.640 -0400", hash_original_method = "7EC2472DA1F2018FBE0DB5359E02217C", hash_generated_method = "1104506805608F01957FDCA19AF98E5F")
        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean var6A3E1D5B368A4625952314ECA607D6A0_1952127947 = (mCustomSelectionActionModeCallback != null &&
                 mCustomSelectionActionModeCallback.onActionItemClicked(mode, item));
            } //End collapsed parenthetic
            boolean varAAAC964C7BDBEAA3EC5B24BBD90E6008_1580555263 = (onTextContextMenuItem(item.getItemId()));
            addTaint(mode.getTaint());
            addTaint(item.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_489637730 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_489637730;
            // ---------- Original Method ----------
            //if (mCustomSelectionActionModeCallback != null &&
                 //mCustomSelectionActionModeCallback.onActionItemClicked(mode, item)) {
                //return true;
            //}
            //return onTextContextMenuItem(item.getItemId());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.640 -0400", hash_original_method = "E3DA233478038DA411461438FCA54906", hash_generated_method = "35DA069730D13C4BA80331090D96F4DF")
        @Override
        public void onDestroyActionMode(ActionMode mode) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                mCustomSelectionActionModeCallback.onDestroyActionMode(mode);
            } //End block
            Selection.setSelection((Spannable) mText, getSelectionEnd());
            {
                mSelectionModifierCursorController.hide();
            } //End block
            mSelectionActionMode = null;
            addTaint(mode.getTaint());
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.643 -0400", hash_original_field = "638E4AC7A89C2D70FFAD0D5E4D21347B", hash_generated_field = "D8E77E145B60561FAD9A3B60E7593FC7")

        private TextView mPasteTextView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.643 -0400", hash_original_field = "40AFD8EC4389104F8E2396DDF98BD183", hash_generated_field = "5647E56FAEB644585635D1F439C78D58")

        private TextView mReplaceTextView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.645 -0400", hash_original_method = "66BB2A1B8CD91C3CE44D6AD3A6EA951F", hash_generated_method = "66BB2A1B8CD91C3CE44D6AD3A6EA951F")
        public ActionPopupWindow ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.648 -0400", hash_original_method = "3A27BFF151DD7090A49C43ED6F082D3A", hash_generated_method = "8DC88F4954A2CB9FB764336AB0459502")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.657 -0400", hash_original_method = "24A2CF459D5801BCD7B986330654CD38", hash_generated_method = "28DB9C01CAE54D60251AADEB19097688")
        @Override
        protected void initContentView() {
            LinearLayout linearLayout;
            linearLayout = new LinearLayout(TextView.this.getContext());
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            mContentView = linearLayout;
            mContentView.setBackgroundResource(
                    com.android.internal.R.drawable.text_edit_paste_window);
            LayoutInflater inflater;
            inflater = (LayoutInflater)TextView.this.mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            LayoutParams wrapContent;
            wrapContent = new LayoutParams(
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.658 -0400", hash_original_method = "A37D41A60FC392DB422E94A09527D04E", hash_generated_method = "F26ED6C94F7ABCC30E42C6D3DF48D3F7")
        @Override
        public void show() {
            boolean canPaste;
            canPaste = canPaste();
            boolean canSuggest;
            canSuggest = isSuggestionsEnabled() && isCursorInsideSuggestionSpan();
            mPasteTextView.setVisibility(canPaste ? View.VISIBLE : View.GONE);
            mReplaceTextView.setVisibility(canSuggest ? View.VISIBLE : View.GONE);
            super.show();
            // ---------- Original Method ----------
            //boolean canPaste = canPaste();
            //boolean canSuggest = isSuggestionsEnabled() && isCursorInsideSuggestionSpan();
            //mPasteTextView.setVisibility(canPaste ? View.VISIBLE : View.GONE);
            //mReplaceTextView.setVisibility(canSuggest ? View.VISIBLE : View.GONE);
            //if (!canPaste && !canSuggest) return;
            //super.show();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.674 -0400", hash_original_method = "35B6F06783189901121FFF5DA40FB852", hash_generated_method = "75993E80E93527F66A37CB56EA7366AF")
        @Override
        public void onClick(View view) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean var3F1B0BC67C85AC74E9CC7447E1F80F7C_1207490733 = (view == mPasteTextView && canPaste());
                {
                    onTextContextMenuItem(ID_PASTE);
                    hide();
                } //End block
                {
                    int middle;
                    middle = (getSelectionStart() + getSelectionEnd()) / 2;
                    stopSelectionActionMode();
                    Selection.setSelection((Spannable) mText, middle);
                    showSuggestions();
                } //End block
            } //End collapsed parenthetic
            addTaint(view.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.675 -0400", hash_original_method = "6C32A970FB91901A3510EE736EF065A8", hash_generated_method = "E5A30294A3295A1B6EC5B96C9D1FE724")
        @Override
        protected int getTextOffset() {
            int var3BEB3DEB1E2E3C75F7F6F972590B6F26_1720184091 = ((getSelectionStart() + getSelectionEnd()) / 2);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1199997628 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1199997628;
            // ---------- Original Method ----------
            //return (getSelectionStart() + getSelectionEnd()) / 2;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.675 -0400", hash_original_method = "AB01324FAF38A5FF69620E59B4546722", hash_generated_method = "15148DBB19A132045F33CE2F68EFDFD9")
        @Override
        protected int getVerticalLocalPosition(int line) {
            int varEE26756D259E6923CEEA10605E3E8378_1628823726 = (mLayout.getLineTop(line) - mContentView.getMeasuredHeight());
            addTaint(line);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1190524944 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1190524944;
            // ---------- Original Method ----------
            //return mLayout.getLineTop(line) - mContentView.getMeasuredHeight();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.676 -0400", hash_original_method = "155BF5081251C49CE36145C9CC0615FD", hash_generated_method = "709301988CCB8EA70540D24872D3BF18")
        @Override
        protected int clipVertically(int positionY) {
            {
                int offset;
                offset = getTextOffset();
                int line;
                line = mLayout.getLineForOffset(offset);
                positionY += mLayout.getLineBottom(line) - mLayout.getLineTop(line);
                positionY += mContentView.getMeasuredHeight();
                Drawable handle;
                handle = mContext.getResources().getDrawable(mTextSelectHandleRes);
                positionY += handle.getIntrinsicHeight();
            } //End block
            addTaint(positionY);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1379944356 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1379944356;
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.676 -0400", hash_original_field = "A8B4CFDAA994C026529F1F31A401F449", hash_generated_field = "D29ED067583B757536DBF4FC9F74BF08")

        private static int POPUP_TEXT_LAYOUT = com.android.internal.R.layout.text_edit_action_popup_text;
    }


    
    private abstract class HandleView extends View implements TextViewPositionListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.678 -0400", hash_original_field = "D548B27C6AC66A9D9B5D05ED35C2D844", hash_generated_field = "6C4E60FE8A6D1EE71691C50FE013D71E")

        protected Drawable mDrawable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.678 -0400", hash_original_field = "73FE9509DA3FC3FD8E616D5F4A54F354", hash_generated_field = "4C4EE51B5C48463562D9242B398F28CE")

        protected Drawable mDrawableLtr;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.678 -0400", hash_original_field = "75EB4D5B30043123DC9A2A3794EEC7F0", hash_generated_field = "C7A02A239F561A2D85D421A4E8712A4E")

        protected Drawable mDrawableRtl;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.678 -0400", hash_original_field = "C64165C1B15EB68FDC5E7135FFE5DF5B", hash_generated_field = "B93BD44443CA54ABF5B84DF5F163A33F")

        private PopupWindow mContainer;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.678 -0400", hash_original_field = "E33EA5C4D485469D2432B3A781CD5014", hash_generated_field = "B562606C08FEFE4EA880E0BAFC4807BC")

        private int mPositionX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.678 -0400", hash_original_field = "5EF2225F886100AA279B39F41428F3C5", hash_generated_field = "30733FB91B36B499B68F008F42192052")

        private int mPositionY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.678 -0400", hash_original_field = "88529674006503CAD340B538C44A2C88", hash_generated_field = "71A2FEF14E89166E5A8A859417B1663A")

        private boolean mIsDragging;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.678 -0400", hash_original_field = "029443A19C599CE9A771103B1F04FFA7", hash_generated_field = "93A0F0D3D0C011A4C3C7501AB57199A0")

        private float mTouchToWindowOffsetX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.678 -0400", hash_original_field = "01E0875D4861BF37105440B51BFCE246", hash_generated_field = "540D3F7CD2E1D98D601A597896694EF1")

        private float mTouchToWindowOffsetY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.678 -0400", hash_original_field = "EC8EBBCD9EFF3785D3CEAE13B087737E", hash_generated_field = "FC8146331AA3445EF26C9BD556ACBB7A")

        protected int mHotspotX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.678 -0400", hash_original_field = "E77C6D28007CC352FD029FAC0668FD90", hash_generated_field = "6BB781632FC22CFF12B61F61AC16C144")

        private float mTouchOffsetY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.678 -0400", hash_original_field = "82A2205DB022BA555E925261E4DCC4D4", hash_generated_field = "7A7CA8BEEE2A68B1CAD15B2AD85A2E90")

        private float mIdealVerticalOffset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.678 -0400", hash_original_field = "AFAA5B704E00C118BFC94C3DB68B3EB8", hash_generated_field = "4316A0FF32FF85FA98C402B295009B89")

        private int mLastParentX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.686 -0400", hash_original_field = "921E843A2994BBE22EA5E45795AA43E4", hash_generated_field = "989834E9B58E837BA06B11D0842ADD46")

        private int mLastParentY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.687 -0400", hash_original_field = "81B6A0831D431B26A19572DBBA8D21BD", hash_generated_field = "2EC1E5C57AE86C2314399153800FDC8F")

        protected ActionPopupWindow mActionPopupWindow;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.687 -0400", hash_original_field = "686EF52C6C5A665D57DB688D5CD19C3F", hash_generated_field = "C47DED40298BEE97981BC7B8F1538E5B")

        private int mPreviousOffset = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.687 -0400", hash_original_field = "03D5F02C0AF2CE2B038F91466D8238BA", hash_generated_field = "348E54253A3677FA237DAA94481A3907")

        private boolean mPositionHasChanged = true;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.687 -0400", hash_original_field = "5C0D0B062C184F3703A4B9594303BA8F", hash_generated_field = "AF098A48DA71A067D06553B74FDC10EC")

        private Runnable mActionPopupShower;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.687 -0400", hash_original_field = "77968F028A8D0EC9CAEB90B72134A740", hash_generated_field = "D7B5473C53CD305FC2C598C0FDE23406")

        private long[] mPreviousOffsetsTimes = new long[HISTORY_SIZE];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.687 -0400", hash_original_field = "9960A44D965A887155E39C559464BFCA", hash_generated_field = "C82A1DCC3A76612C603E86138948ED2D")

        private int[] mPreviousOffsets = new int[HISTORY_SIZE];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.687 -0400", hash_original_field = "76D787A353B8891BC279BD7E2A9B6B00", hash_generated_field = "A862CB689B1B30174089DC5C296E66B1")

        private int mPreviousOffsetIndex = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.687 -0400", hash_original_field = "AD3CA79B9D71DC299CA01D15C8FD472D", hash_generated_field = "FFBAC9977BB0F1F158F20DFF11AA8445")

        private int mNumberPreviousOffsets = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.699 -0400", hash_original_method = "96CFEA14605480F2CAC7A5BABB016DB2", hash_generated_method = "AF16D91345CD3DDD8A41CB34A1A15AEE")
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
            int handleHeight;
            handleHeight = mDrawable.getIntrinsicHeight();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.699 -0400", hash_original_method = "79B760AD39E8E4DC7B1000745317DEB7", hash_generated_method = "27180675DD4339AB2F84E10B6ADA9A96")
        protected void updateDrawable() {
            int offset;
            offset = getCurrentCursorOffset();
            boolean isRtlCharAtOffset;
            isRtlCharAtOffset = mLayout.isRtlCharAt(offset);
            mDrawable = isRtlCharAtOffset ? mDrawableRtl : mDrawableLtr;
            mHotspotX = getHotspotX(mDrawable, isRtlCharAtOffset);
            // ---------- Original Method ----------
            //final int offset = getCurrentCursorOffset();
            //final boolean isRtlCharAtOffset = mLayout.isRtlCharAt(offset);
            //mDrawable = isRtlCharAtOffset ? mDrawableRtl : mDrawableLtr;
            //mHotspotX = getHotspotX(mDrawable, isRtlCharAtOffset);
        }

        
        protected abstract int getHotspotX(Drawable drawable, boolean isRtlRun);

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.700 -0400", hash_original_method = "FC7484D3CDDEA8A708B164CA1D725BB5", hash_generated_method = "7542E7A82AB876729A21C8F805EF09FA")
        private void startTouchUpFilter(int offset) {
            mNumberPreviousOffsets = 0;
            addPositionToTouchUpFilter(offset);
            addTaint(offset);
            // ---------- Original Method ----------
            //mNumberPreviousOffsets = 0;
            //addPositionToTouchUpFilter(offset);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.700 -0400", hash_original_method = "F067815A22302FA44603BE1943641FAF", hash_generated_method = "2A9255F3B7F567DBBEE7B7E696C209B8")
        private void addPositionToTouchUpFilter(int offset) {
            mPreviousOffsetIndex = (mPreviousOffsetIndex + 1) % HISTORY_SIZE;
            mPreviousOffsets[mPreviousOffsetIndex] = offset;
            mPreviousOffsetsTimes[mPreviousOffsetIndex] = SystemClock.uptimeMillis();
            // ---------- Original Method ----------
            //mPreviousOffsetIndex = (mPreviousOffsetIndex + 1) % HISTORY_SIZE;
            //mPreviousOffsets[mPreviousOffsetIndex] = offset;
            //mPreviousOffsetsTimes[mPreviousOffsetIndex] = SystemClock.uptimeMillis();
            //mNumberPreviousOffsets++;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.701 -0400", hash_original_method = "55F0EF9CEF8C5AA4299D2A57A3F07803", hash_generated_method = "E6A423AF98CF8707E08F7FF7E6A2C33D")
        private void filterOnTouchUp() {
            long now;
            now = SystemClock.uptimeMillis();
            int i;
            i = 0;
            int index;
            index = mPreviousOffsetIndex;
            int iMax;
            iMax = Math.min(mNumberPreviousOffsets, HISTORY_SIZE);
            {
                index = (mPreviousOffsetIndex - i + HISTORY_SIZE) % HISTORY_SIZE;
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.701 -0400", hash_original_method = "8E1053DB926B4787A5B252A5CCF7E3E6", hash_generated_method = "BB908830119103A7456BCD781529A2B3")
        public boolean offsetHasBeenChanged() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1189939969 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1189939969;
            // ---------- Original Method ----------
            //return mNumberPreviousOffsets > 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.701 -0400", hash_original_method = "F1B9B11E208A14EF1A8385C794E8615A", hash_generated_method = "CF96AEC91DE3DD70D8E0E3B03CA85D93")
        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            setMeasuredDimension(mDrawable.getIntrinsicWidth(), mDrawable.getIntrinsicHeight());
            addTaint(widthMeasureSpec);
            addTaint(heightMeasureSpec);
            // ---------- Original Method ----------
            //setMeasuredDimension(mDrawable.getIntrinsicWidth(), mDrawable.getIntrinsicHeight());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.702 -0400", hash_original_method = "0CEFB75F912E1774230D056666C1CB4D", hash_generated_method = "5901FF2E41132467BF0D4DA526C7AEF3")
        public void show() {
            {
                boolean varC328115627DFB8318D2C3484959F5057_82191830 = (isShowing());
            } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.703 -0400", hash_original_method = "58A1CA71E65CA8505283F80ECD55B125", hash_generated_method = "733B087F4D13E07199A0682C98829C56")
        protected void dismiss() {
            mIsDragging = false;
            mContainer.dismiss();
            onDetached();
            // ---------- Original Method ----------
            //mIsDragging = false;
            //mContainer.dismiss();
            //onDetached();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.703 -0400", hash_original_method = "E51AD13D62B6328756BEDC07E20C91A7", hash_generated_method = "B3050A8544288284788803BE9D39F46E")
        public void hide() {
            dismiss();
            TextView.this.getPositionListener().removeSubscriber(this);
            // ---------- Original Method ----------
            //dismiss();
            //TextView.this.getPositionListener().removeSubscriber(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.710 -0400", hash_original_method = "0D5333D88B146866CC739B7BC1FA2E0A", hash_generated_method = "4D4F391FCE64B846EAEAD06BE832EB58")
         void showActionPopupWindow(int delay) {
            {
                mActionPopupWindow = new ActionPopupWindow();
            } //End block
            {
                mActionPopupShower = new Runnable() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.710 -0400", hash_original_method = "3DEF90E085B5D89C941B0ED88F0DC7FD", hash_generated_method = "0FD34D73BCA925EC1AF406DCBE797EF5")
                    public void run() {
                        mActionPopupWindow.show();
                        // ---------- Original Method ----------
                        //mActionPopupWindow.show();
                    }
};
            } //End block
            {
                TextView.this.removeCallbacks(mActionPopupShower);
            } //End block
            TextView.this.postDelayed(mActionPopupShower, delay);
            addTaint(delay);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.710 -0400", hash_original_method = "7E990B2771AC26D4AD93278F16BEC9C8", hash_generated_method = "C71F220859CCDEBCBEEA3A66F1FBEC1A")
        protected void hideActionPopupWindow() {
            {
                TextView.this.removeCallbacks(mActionPopupShower);
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.711 -0400", hash_original_method = "4C582CFB225DCFD162C1BDA55C8E191D", hash_generated_method = "C54EC1458577E93B310370F2347DED25")
        public boolean isShowing() {
            boolean var150C3AF6C0593C2D596AE332D213A317_487111303 = (mContainer.isShowing());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1411201127 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1411201127;
            // ---------- Original Method ----------
            //return mContainer.isShowing();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.711 -0400", hash_original_method = "622F11C59DDFBBB8F6FA4F43A2282A80", hash_generated_method = "5442ACB572A99A2D3A9A7C5F9AA1417A")
        private boolean isVisible() {
            {
                boolean var50BDB7CF84FD9415E39B194F38BCA676_2123887031 = (isInBatchEditMode());
            } //End collapsed parenthetic
            boolean varFDA4E5DACCCE5BDB1C7FF02945B0CF5E_1214919882 = (TextView.this.isPositionVisible(mPositionX + mHotspotX, mPositionY));
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2056118006 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2056118006;
            // ---------- Original Method ----------
            //if (mIsDragging) {
                //return true;
            //}
            //if (isInBatchEditMode()) {
                //return false;
            //}
            //return TextView.this.isPositionVisible(mPositionX + mHotspotX, mPositionY);
        }

        
        public abstract int getCurrentCursorOffset();

        
        protected abstract void updateSelection(int offset);

        
        public abstract void updatePosition(float x, float y);

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.719 -0400", hash_original_method = "23AE0E97732D2E1BD689A17102858930", hash_generated_method = "CAF6A52D220B8D46F020BB476E5FDC15")
        protected void positionAtCursorOffset(int offset, boolean parentScrolled) {
            {
                prepareCursorControllers();
            } //End block
            {
                updateSelection(offset);
                addPositionToTouchUpFilter(offset);
                int line;
                line = mLayout.getLineForOffset(offset);
                mPositionX = (int) (mLayout.getPrimaryHorizontal(offset) - 0.5f - mHotspotX);
                mPositionY = mLayout.getLineBottom(line);
                mPositionX += viewportToContentHorizontalOffset();
                mPositionY += viewportToContentVerticalOffset();
                mPreviousOffset = offset;
                mPositionHasChanged = true;
            } //End block
            addTaint(parentScrolled);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.727 -0400", hash_original_method = "13FE1FBB4F8CE63ECDC017603A6579A6", hash_generated_method = "2CFC1C527F78E89F133597C8251FA6DC")
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
                    } //End block
                    onHandleMoved();
                } //End block
                {
                    boolean varFF8AC1520C23E15E72910D87BF05E9DD_257954104 = (isVisible());
                    {
                        int positionX;
                        positionX = parentPositionX + mPositionX;
                        int positionY;
                        positionY = parentPositionY + mPositionY;
                        {
                            boolean varAD9BB22364C576DF82257324184E3F6D_198437445 = (isShowing());
                            {
                                mContainer.update(positionX, positionY, -1, -1);
                            } //End block
                            {
                                mContainer.showAtLocation(TextView.this, Gravity.NO_GRAVITY,
                                positionX, positionY);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        {
                            boolean varAD9BB22364C576DF82257324184E3F6D_738965635 = (isShowing());
                            {
                                dismiss();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                mPositionHasChanged = false;
            } //End block
            addTaint(parentPositionChanged);
            addTaint(parentScrolled);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.732 -0400", hash_original_method = "F8254677C35EEC48CDE0AC0DA5BFAEC5", hash_generated_method = "EE1E3C7D453F31149D17A4CF7877565A")
        @Override
        protected void onDraw(Canvas c) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mDrawable.setBounds(0, 0, mRight - mLeft, mBottom - mTop);
            mDrawable.draw(c);
            addTaint(c.getTaint());
            // ---------- Original Method ----------
            //mDrawable.setBounds(0, 0, mRight - mLeft, mBottom - mTop);
            //mDrawable.draw(c);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.733 -0400", hash_original_method = "AFDBACCAFCABC81309AB0079A4EAD49F", hash_generated_method = "8D60DB6EE1AB2B943E43ADA1F1AC25F6")
        @Override
        public boolean onTouchEvent(MotionEvent ev) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                Object var373A6BAE1146FCFC2FEA12BA752DB0E2_2134282925 = (ev.getActionMasked());
                //Begin case MotionEvent.ACTION_DOWN 
                {
                    startTouchUpFilter(getCurrentCursorOffset());
                    mTouchToWindowOffsetX = ev.getRawX() - mPositionX;
                    mTouchToWindowOffsetY = ev.getRawY() - mPositionY;
                    PositionListener positionListener;
                    positionListener = getPositionListener();
                    mLastParentX = positionListener.getPositionX();
                    mLastParentY = positionListener.getPositionY();
                    mIsDragging = true;
                } //End block
                //End case MotionEvent.ACTION_DOWN 
                //Begin case MotionEvent.ACTION_MOVE 
                {
                    float rawX;
                    rawX = ev.getRawX();
                    float rawY;
                    rawY = ev.getRawY();
                    float previousVerticalOffset;
                    previousVerticalOffset = mTouchToWindowOffsetY - mLastParentY;
                    float currentVerticalOffset;
                    currentVerticalOffset = rawY - mPositionY - mLastParentY;
                    float newVerticalOffset;
                    {
                        newVerticalOffset = Math.min(currentVerticalOffset, mIdealVerticalOffset);
                        newVerticalOffset = Math.max(newVerticalOffset, previousVerticalOffset);
                    } //End block
                    {
                        newVerticalOffset = Math.max(currentVerticalOffset, mIdealVerticalOffset);
                        newVerticalOffset = Math.min(newVerticalOffset, previousVerticalOffset);
                    } //End block
                    mTouchToWindowOffsetY = newVerticalOffset + mLastParentY;
                    float newPosX;
                    newPosX = rawX - mTouchToWindowOffsetX + mHotspotX;
                    float newPosY;
                    newPosY = rawY - mTouchToWindowOffsetY + mTouchOffsetY;
                    updatePosition(newPosX, newPosY);
                } //End block
                //End case MotionEvent.ACTION_MOVE 
                //Begin case MotionEvent.ACTION_UP 
                filterOnTouchUp();
                //End case MotionEvent.ACTION_UP 
                //Begin case MotionEvent.ACTION_UP 
                mIsDragging = false;
                //End case MotionEvent.ACTION_UP 
                //Begin case MotionEvent.ACTION_CANCEL 
                mIsDragging = false;
                //End case MotionEvent.ACTION_CANCEL 
            } //End collapsed parenthetic
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_317866553 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_317866553;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.734 -0400", hash_original_method = "A2059A5EB773F7552F7C3D2AAFE1E47B", hash_generated_method = "2E41CA3A55E89F065503B29DA69DC0A6")
        public boolean isDragging() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1749336820 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1749336820;
            // ---------- Original Method ----------
            //return mIsDragging;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.734 -0400", hash_original_method = "5C16B6634DA5CEF817B70D10C5EDCDFD", hash_generated_method = "2D666D5FB7EA2FA5400262CA3F1C8A1F")
         void onHandleMoved() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            hideActionPopupWindow();
            // ---------- Original Method ----------
            //hideActionPopupWindow();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.734 -0400", hash_original_method = "0744EFF256BE5CA55B7C747C6AB06865", hash_generated_method = "07B6D1B0BEF9A03B240C16C543BA4B2F")
        public void onDetached() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            hideActionPopupWindow();
            // ---------- Original Method ----------
            //hideActionPopupWindow();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.746 -0400", hash_original_field = "4D2C350B591CA62A0C667757F122D131", hash_generated_field = "8C7FEE8B453A58974E7A2860C7E45637")

        private static int HISTORY_SIZE = 5;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.746 -0400", hash_original_field = "5A211AD0D3E493272B14721269ACE755", hash_generated_field = "12EF5FA3901D6975506B66E13EA18924")

        private static int TOUCH_UP_FILTER_DELAY_AFTER = 150;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.746 -0400", hash_original_field = "34B7443C5D740630794D9BD84EFEB1CC", hash_generated_field = "2C10271D123FCAAE9F5A018D606DFDFF")

        private static int TOUCH_UP_FILTER_DELAY_BEFORE = 350;
    }


    
    private class InsertionHandleView extends HandleView {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.750 -0400", hash_original_field = "E112B12E6D91B6522B4D9A9D3C4682F9", hash_generated_field = "096F0842C4660386417099FC96034322")

        private float mDownPositionX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.751 -0400", hash_original_field = "B61BFF081F30765551C8F83D5FE6EC6E", hash_generated_field = "70F6109386E0D3A8FC8471F06A6A2F6D")

        private float mDownPositionY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.751 -0400", hash_original_field = "101E91B8795FFD67FD01E75EC6725745", hash_generated_field = "1E652DE5CA4B75E782FE33512F595202")

        private Runnable mHider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.751 -0400", hash_original_method = "F74814C2C752895D626389ECC5F1998A", hash_generated_method = "5EAC7B8D71C451D641FED6330B91FC9E")
        public  InsertionHandleView(Drawable drawable) {
            super(drawable, drawable);
            addTaint(drawable.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.751 -0400", hash_original_method = "0F6B36BAB7494929112A1B2A0EAC8D6C", hash_generated_method = "A7BEB9F1BF742B1C98F51B01E918156A")
        @Override
        public void show() {
            super.show();
            long durationSinceCutOrCopy;
            durationSinceCutOrCopy = SystemClock.uptimeMillis() - sLastCutOrCopyTime;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.752 -0400", hash_original_method = "59B6A837BA01A6E9F2644C670D997B83", hash_generated_method = "3AF35DDAFA81E0D862669F6D69826EB8")
        public void showWithActionPopup() {
            show();
            showActionPopupWindow(0);
            // ---------- Original Method ----------
            //show();
            //showActionPopupWindow(0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.753 -0400", hash_original_method = "60FC6C1FF502D89543DDAA49F0EA3292", hash_generated_method = "BD063B1AA5455933CDE73FC4FDBFEB0B")
        private void hideAfterDelay() {
            removeHiderCallback();
            {
                mHider = new Runnable() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.753 -0400", hash_original_method = "21815FA27ABEB649DED6A46E4F97905B", hash_generated_method = "2FF065C6B89057BF4ADFF6066462708E")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.753 -0400", hash_original_method = "C682D1056E8259D8BAEA8A544AED7A4D", hash_generated_method = "867A7692AB60EB72837193F437C04B2D")
        private void removeHiderCallback() {
            {
                TextView.this.removeCallbacks(mHider);
            } //End block
            // ---------- Original Method ----------
            //if (mHider != null) {
                //TextView.this.removeCallbacks(mHider);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.754 -0400", hash_original_method = "6DC2E28231BC586AA27A394F083E414A", hash_generated_method = "A0EF5329C54D2BDA51BAB40B344099C8")
        @Override
        protected int getHotspotX(Drawable drawable, boolean isRtlRun) {
            int varA8B7D89D4E5B94692BDCD2F6C401B00C_1767115619 = (drawable.getIntrinsicWidth() / 2);
            addTaint(drawable.getTaint());
            addTaint(isRtlRun);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_380640150 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_380640150;
            // ---------- Original Method ----------
            //return drawable.getIntrinsicWidth() / 2;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.760 -0400", hash_original_method = "0786A2C72AD62CB255408C178910DEC1", hash_generated_method = "AE469026B869C46427DF149D61864502")
        @Override
        public boolean onTouchEvent(MotionEvent ev) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            boolean result;
            result = super.onTouchEvent(ev);
            {
                Object var373A6BAE1146FCFC2FEA12BA752DB0E2_1867689078 = (ev.getActionMasked());
                //Begin case MotionEvent.ACTION_DOWN 
                mDownPositionX = ev.getRawX();
                //End case MotionEvent.ACTION_DOWN 
                //Begin case MotionEvent.ACTION_DOWN 
                mDownPositionY = ev.getRawY();
                //End case MotionEvent.ACTION_DOWN 
                //Begin case MotionEvent.ACTION_UP 
                {
                    boolean varEEEFE49273E9B0F999D591B54BA07697_1429183870 = (!offsetHasBeenChanged());
                    {
                        float deltaX;
                        deltaX = mDownPositionX - ev.getRawX();
                        float deltaY;
                        deltaY = mDownPositionY - ev.getRawY();
                        float distanceSquared;
                        distanceSquared = deltaX * deltaX + deltaY * deltaY;
                        {
                            {
                                boolean var33D1446792CC339F933EE732A5EACA0F_690989401 = (mActionPopupWindow != null && mActionPopupWindow.isShowing());
                                {
                                    mActionPopupWindow.hide();
                                } //End block
                                {
                                    showWithActionPopup();
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                //End case MotionEvent.ACTION_UP 
                //Begin case MotionEvent.ACTION_UP 
                hideAfterDelay();
                //End case MotionEvent.ACTION_UP 
                //Begin case MotionEvent.ACTION_CANCEL 
                hideAfterDelay();
                //End case MotionEvent.ACTION_CANCEL 
            } //End collapsed parenthetic
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_178414607 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_178414607;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.761 -0400", hash_original_method = "CA0934B91A8FE7B0CF5B9D9FD475827B", hash_generated_method = "204AF926E4DB051E2A097F0E431E5255")
        @Override
        public int getCurrentCursorOffset() {
            int var3A0ADF979623B6D0242973915DBE6180_1779477142 = (TextView.this.getSelectionStart());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1415234755 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1415234755;
            // ---------- Original Method ----------
            //return TextView.this.getSelectionStart();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.761 -0400", hash_original_method = "A55C2EA19B8C1EC0135F14E2406421A5", hash_generated_method = "7B11087E1802F4278130367027CE5007")
        @Override
        public void updateSelection(int offset) {
            Selection.setSelection((Spannable) mText, offset);
            addTaint(offset);
            // ---------- Original Method ----------
            //Selection.setSelection((Spannable) mText, offset);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.769 -0400", hash_original_method = "76FEC5259BD2EF7A10D2C6D9447263AD", hash_generated_method = "615EBD9A0AF00D72802108C8B628535A")
        @Override
        public void updatePosition(float x, float y) {
            positionAtCursorOffset(getOffsetForPosition(x, y), false);
            addTaint(x);
            addTaint(y);
            // ---------- Original Method ----------
            //positionAtCursorOffset(getOffsetForPosition(x, y), false);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.770 -0400", hash_original_method = "DF26232D8C6513289215597105F4C19A", hash_generated_method = "78394009F817C89807523E4EB6438C76")
        @Override
         void onHandleMoved() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            super.onHandleMoved();
            removeHiderCallback();
            // ---------- Original Method ----------
            //super.onHandleMoved();
            //removeHiderCallback();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.771 -0400", hash_original_method = "58D1696EBF955B571F830BA2F6EDC257", hash_generated_method = "8A539C8A229F23A70E85F98BCBADCFB1")
        @Override
        public void onDetached() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            super.onDetached();
            removeHiderCallback();
            // ---------- Original Method ----------
            //super.onDetached();
            //removeHiderCallback();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.771 -0400", hash_original_field = "18BCA025F38FDD875DD515112EA41675", hash_generated_field = "3B7BFC086ECB80FB6D9D382A770ECF7E")

        private static int DELAY_BEFORE_HANDLE_FADES_OUT = 4000;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.771 -0400", hash_original_field = "936EA1DD438E31BBD9024754C3C0C340", hash_generated_field = "8AD70E1CD6193A637F4B6F24DFABE5FB")

        private static int RECENT_CUT_COPY_DURATION = 15 * 1000;
    }


    
    private class SelectionStartHandleView extends HandleView {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.777 -0400", hash_original_method = "83BC78691BC747F1E4426492F397A3E5", hash_generated_method = "BDBC9F1394F2DA029B4526CBB7193376")
        public  SelectionStartHandleView(Drawable drawableLtr, Drawable drawableRtl) {
            super(drawableLtr, drawableRtl);
            addTaint(drawableLtr.getTaint());
            addTaint(drawableRtl.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.782 -0400", hash_original_method = "E4FEF24C3E269A0B427919DBE201803F", hash_generated_method = "37B6963A41CE29E0AC4A32B5AE4F52E1")
        @Override
        protected int getHotspotX(Drawable drawable, boolean isRtlRun) {
            {
                int var825C3AB963C858F505D8A99BED9B8FB2_1277135413 = (drawable.getIntrinsicWidth() / 4);
            } //End block
            {
                int var2619A169F3B5A531F91E617BA41D1854_727258752 = ((drawable.getIntrinsicWidth() * 3) / 4);
            } //End block
            addTaint(drawable.getTaint());
            addTaint(isRtlRun);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1901604735 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1901604735;
            // ---------- Original Method ----------
            //if (isRtlRun) {
                //return drawable.getIntrinsicWidth() / 4;
            //} else {
                //return (drawable.getIntrinsicWidth() * 3) / 4;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.785 -0400", hash_original_method = "CA0934B91A8FE7B0CF5B9D9FD475827B", hash_generated_method = "01D3B7FB9C10E0061234E4A6DF4D16E3")
        @Override
        public int getCurrentCursorOffset() {
            int var3A0ADF979623B6D0242973915DBE6180_879053761 = (TextView.this.getSelectionStart());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1620797524 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1620797524;
            // ---------- Original Method ----------
            //return TextView.this.getSelectionStart();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.793 -0400", hash_original_method = "E42DF79873294756C3452434D16E6BD3", hash_generated_method = "BA7FF3072E473E10381492C11BCE7A22")
        @Override
        public void updateSelection(int offset) {
            Selection.setSelection((Spannable) mText, offset, getSelectionEnd());
            updateDrawable();
            addTaint(offset);
            // ---------- Original Method ----------
            //Selection.setSelection((Spannable) mText, offset, getSelectionEnd());
            //updateDrawable();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.794 -0400", hash_original_method = "7B45D907648A79384D6568EC81E6D22D", hash_generated_method = "BBD54AE95DCE81EB779EC1829E18E922")
        @Override
        public void updatePosition(float x, float y) {
            int offset;
            offset = getOffsetForPosition(x, y);
            int selectionEnd;
            selectionEnd = getSelectionEnd();
            offset = Math.max(0, selectionEnd - 1);
            positionAtCursorOffset(offset, false);
            addTaint(x);
            addTaint(y);
            // ---------- Original Method ----------
            //int offset = getOffsetForPosition(x, y);
            //final int selectionEnd = getSelectionEnd();
            //if (offset >= selectionEnd) offset = Math.max(0, selectionEnd - 1);
            //positionAtCursorOffset(offset, false);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.794 -0400", hash_original_method = "0C631CE72876F998F945C3B67884BC26", hash_generated_method = "138AF29C51A95CC5779AA3F9A554B090")
        public ActionPopupWindow getActionPopupWindow() {
            ActionPopupWindow varB4EAC82CA7396A68D541C85D26508E83_1065985605 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1065985605 = mActionPopupWindow;
            varB4EAC82CA7396A68D541C85D26508E83_1065985605.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1065985605;
            // ---------- Original Method ----------
            //return mActionPopupWindow;
        }

        
    }


    
    private class SelectionEndHandleView extends HandleView {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.795 -0400", hash_original_method = "883DF21D67E4B772D6E1A322F4D5F533", hash_generated_method = "2D978731C756EEC47F6BE46527AD71F8")
        public  SelectionEndHandleView(Drawable drawableLtr, Drawable drawableRtl) {
            super(drawableLtr, drawableRtl);
            addTaint(drawableLtr.getTaint());
            addTaint(drawableRtl.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.800 -0400", hash_original_method = "6A8A8B43FF48B8BB585E51FD6E86C9E2", hash_generated_method = "CB56E36ABBD4B1365B25D81F3D76D3EA")
        @Override
        protected int getHotspotX(Drawable drawable, boolean isRtlRun) {
            {
                int var2619A169F3B5A531F91E617BA41D1854_896603657 = ((drawable.getIntrinsicWidth() * 3) / 4);
            } //End block
            {
                int var825C3AB963C858F505D8A99BED9B8FB2_313616585 = (drawable.getIntrinsicWidth() / 4);
            } //End block
            addTaint(drawable.getTaint());
            addTaint(isRtlRun);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_311437904 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_311437904;
            // ---------- Original Method ----------
            //if (isRtlRun) {
                //return (drawable.getIntrinsicWidth() * 3) / 4;
            //} else {
                //return drawable.getIntrinsicWidth() / 4;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.803 -0400", hash_original_method = "CA6DDFB8F86FC43076502B090D003904", hash_generated_method = "1AA4BFD7D448FFB5751E2F35DC75396D")
        @Override
        public int getCurrentCursorOffset() {
            int varA2E0C17AA3D1EB612E8CF0B487723C9B_657881381 = (TextView.this.getSelectionEnd());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_439517299 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_439517299;
            // ---------- Original Method ----------
            //return TextView.this.getSelectionEnd();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.812 -0400", hash_original_method = "B3473CE6965F2521B605BA0101D0A91A", hash_generated_method = "D60716072937499BE12E95FCF3FEF918")
        @Override
        public void updateSelection(int offset) {
            Selection.setSelection((Spannable) mText, getSelectionStart(), offset);
            updateDrawable();
            addTaint(offset);
            // ---------- Original Method ----------
            //Selection.setSelection((Spannable) mText, getSelectionStart(), offset);
            //updateDrawable();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.813 -0400", hash_original_method = "DE26EB392137324C128BF7B92FEE748A", hash_generated_method = "504C77C133A6DB48CB308EBCB2566E3B")
        @Override
        public void updatePosition(float x, float y) {
            int offset;
            offset = getOffsetForPosition(x, y);
            int selectionStart;
            selectionStart = getSelectionStart();
            offset = Math.min(selectionStart + 1, mText.length());
            positionAtCursorOffset(offset, false);
            addTaint(x);
            addTaint(y);
            // ---------- Original Method ----------
            //int offset = getOffsetForPosition(x, y);
            //final int selectionStart = getSelectionStart();
            //if (offset <= selectionStart) offset = Math.min(selectionStart + 1, mText.length());
            //positionAtCursorOffset(offset, false);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.814 -0400", hash_original_method = "1AE0953CF1E401F1791B2AA9D0C762E1", hash_generated_method = "BA1A80848BD3464B993B996B099EA4D3")
        public void setActionPopupWindow(ActionPopupWindow actionPopupWindow) {
            mActionPopupWindow = actionPopupWindow;
            addTaint(actionPopupWindow.getTaint());
            // ---------- Original Method ----------
            //mActionPopupWindow = actionPopupWindow;
        }

        
    }


    
    private class InsertionPointCursorController implements CursorController {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.814 -0400", hash_original_field = "D82B253C7CDC2B84A5A684E7A5D691F6", hash_generated_field = "25F2B1ECCF00A4687A034C77E527EB90")

        private InsertionHandleView mHandle;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.815 -0400", hash_original_method = "85F6797FDF607C95B81DF68401917B00", hash_generated_method = "85F6797FDF607C95B81DF68401917B00")
        public InsertionPointCursorController ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.843 -0400", hash_original_method = "5D45AEF69914729B932C554DDDCEB4D3", hash_generated_method = "5EA31E88AA733E4213C40495380DD157")
        public void show() {
            getHandle().show();
            // ---------- Original Method ----------
            //getHandle().show();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.843 -0400", hash_original_method = "BEDA636D814D43341B0837622BB75D12", hash_generated_method = "16B9CF12A56CC458EBA14E68A570766E")
        public void showWithActionPopup() {
            getHandle().showWithActionPopup();
            // ---------- Original Method ----------
            //getHandle().showWithActionPopup();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.850 -0400", hash_original_method = "99DAD3C319227F2A1F78AE95D96BD2B3", hash_generated_method = "1A323EAA6938558E1F65AF39AFB175B6")
        public void hide() {
            {
                mHandle.hide();
            } //End block
            // ---------- Original Method ----------
            //if (mHandle != null) {
                //mHandle.hide();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.855 -0400", hash_original_method = "43F562659DF9586EE8DC985200A1394B", hash_generated_method = "AFA5EE836BA01E42C65DC8B7F78125A2")
        public void onTouchModeChanged(boolean isInTouchMode) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                hide();
            } //End block
            addTaint(isInTouchMode);
            // ---------- Original Method ----------
            //if (!isInTouchMode) {
                //hide();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.856 -0400", hash_original_method = "AFBF832B3C2DD5F3EC6366306B6BB027", hash_generated_method = "BE73CD0545690B0DAB24A7DFA12B7424")
        private InsertionHandleView getHandle() {
            InsertionHandleView varB4EAC82CA7396A68D541C85D26508E83_1867010863 = null; //Variable for return #1
            {
                mSelectHandleCenter = mContext.getResources().getDrawable(
                        mTextSelectHandleRes);
            } //End block
            {
                mHandle = new InsertionHandleView(mSelectHandleCenter);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1867010863 = mHandle;
            varB4EAC82CA7396A68D541C85D26508E83_1867010863.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1867010863;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.857 -0400", hash_original_method = "5CA35A7F100FC077200BA56F0D1F67CB", hash_generated_method = "84ABC3E50DDA92E7C6A044A164C84F3E")
        @Override
        public void onDetached() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            ViewTreeObserver observer;
            observer = getViewTreeObserver();
            observer.removeOnTouchModeChangeListener(this);
            mHandle.onDetached();
            // ---------- Original Method ----------
            //final ViewTreeObserver observer = getViewTreeObserver();
            //observer.removeOnTouchModeChangeListener(this);
            //if (mHandle != null) mHandle.onDetached();
        }

        
    }


    
    private class SelectionModifierCursorController implements CursorController {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.857 -0400", hash_original_field = "1DDEE8F82039A4BD80420CF27F9E1A6A", hash_generated_field = "0F7E872CABC7DF9A40441A432FBD1FBF")

        private SelectionStartHandleView mStartHandle;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.857 -0400", hash_original_field = "7F3172BBEA8484D85B326E672A5A423F", hash_generated_field = "19A28AD860044ACC5058053954B56AC1")

        private SelectionEndHandleView mEndHandle;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.857 -0400", hash_original_field = "17546985D71D9022C1E12FDE1CAFC6E5", hash_generated_field = "6FCDDDBC590A39D5D0BCAFDBA6EA63E5")

        private int mMinTouchOffset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.857 -0400", hash_original_field = "690ACF87EFB1963C7A4637EB14226F0B", hash_generated_field = "F147B97F09325CC9B6538D3E5D26C2FE")

        private int mMaxTouchOffset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.857 -0400", hash_original_field = "EEB78043F7A84B6B33C67CCCFE8BE924", hash_generated_field = "7CECB42F787323EA52A439F784FC8CBE")

        private long mPreviousTapUpTime = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.857 -0400", hash_original_field = "868B14065502FE9C1E526C78E73FCAF9", hash_generated_field = "0BA74B206DFC70E28F82C95A0E3C40BF")

        private float mPreviousTapPositionX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.857 -0400", hash_original_field = "78D2D33220DDE6DE9E8A068208CC3141", hash_generated_field = "1F4747912771D340E5AE19794AD2D9A3")

        private float mPreviousTapPositionY;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.882 -0400", hash_original_method = "7762686ED4BD194662F98430835FCC93", hash_generated_method = "996EF3777B9152A62DF6DD828F075A23")
          SelectionModifierCursorController() {
            resetTouchOffsets();
            // ---------- Original Method ----------
            //resetTouchOffsets();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.884 -0400", hash_original_method = "803DF98A86477F9509B518860444CA62", hash_generated_method = "0F7BB1F68C3268B47251041828989586")
        public void show() {
            {
                boolean var50BDB7CF84FD9415E39B194F38BCA676_538244221 = (isInBatchEditMode());
            } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.885 -0400", hash_original_method = "2C322B9176F95E96CE86AF105C0AA144", hash_generated_method = "F631ADBBD886B9722F2546BD7CFF6D80")
        private void initDrawables() {
            {
                mSelectHandleLeft = mContext.getResources().getDrawable(
                        mTextSelectHandleLeftRes);
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.887 -0400", hash_original_method = "C3351664D38EE8E6983EFA56F5011D2A", hash_generated_method = "99C9F2D76A1C7AED04BBBED298E45F37")
        private void initHandles() {
            {
                mStartHandle = new SelectionStartHandleView(mSelectHandleLeft, mSelectHandleRight);
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.892 -0400", hash_original_method = "9904AE40606D29E60FAC10481978E041", hash_generated_method = "3FEAC2D7413111579488390C9577D61B")
        public void hide() {
            mStartHandle.hide();
            mEndHandle.hide();
            // ---------- Original Method ----------
            //if (mStartHandle != null) mStartHandle.hide();
            //if (mEndHandle != null) mEndHandle.hide();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.897 -0400", hash_original_method = "4BB059019645E4258A18514D6F6D1609", hash_generated_method = "27A9E4E83F88DE0EAB4F1955676CD90D")
        public void onTouchEvent(MotionEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                Object varF6D597E8558CB9D89114B4B1D82BA68F_174525814 = (event.getActionMasked());
                //Begin case MotionEvent.ACTION_DOWN 
                float x;
                x = event.getX();
                //End case MotionEvent.ACTION_DOWN 
                //Begin case MotionEvent.ACTION_DOWN 
                float y;
                y = event.getY();
                //End case MotionEvent.ACTION_DOWN 
                //Begin case MotionEvent.ACTION_DOWN 
                mMinTouchOffset = mMaxTouchOffset = getOffsetForPosition(x, y);
                //End case MotionEvent.ACTION_DOWN 
                //Begin case MotionEvent.ACTION_DOWN 
                long duration;
                duration = SystemClock.uptimeMillis() - mPreviousTapUpTime;
                //End case MotionEvent.ACTION_DOWN 
                //Begin case MotionEvent.ACTION_DOWN 
                {
                    boolean varD222D501AFFB3FFBAB7C6BF5A68FBCF1_820696916 = (duration <= ViewConfiguration.getDoubleTapTimeout() &&
                            isPositionOnText(x, y));
                    {
                        float deltaX;
                        deltaX = x - mPreviousTapPositionX;
                        float deltaY;
                        deltaY = y - mPreviousTapPositionY;
                        float distanceSquared;
                        distanceSquared = deltaX * deltaX + deltaY * deltaY;
                        {
                            startSelectionActionMode();
                            mDiscardNextActionUp = true;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                //End case MotionEvent.ACTION_DOWN 
                //Begin case MotionEvent.ACTION_DOWN 
                mPreviousTapPositionX = x;
                //End case MotionEvent.ACTION_DOWN 
                //Begin case MotionEvent.ACTION_DOWN 
                mPreviousTapPositionY = y;
                //End case MotionEvent.ACTION_DOWN 
                //Begin case MotionEvent.ACTION_POINTER_DOWN MotionEvent.ACTION_POINTER_UP 
                {
                    boolean var4F7B392379BD182D25B1AE93077ACAB8_2032262266 = (mContext.getPackageManager().hasSystemFeature(
                            PackageManager.FEATURE_TOUCHSCREEN_MULTITOUCH_DISTINCT));
                    {
                        updateMinAndMaxOffsets(event);
                    } //End block
                } //End collapsed parenthetic
                //End case MotionEvent.ACTION_POINTER_DOWN MotionEvent.ACTION_POINTER_UP 
                //Begin case MotionEvent.ACTION_UP 
                mPreviousTapUpTime = SystemClock.uptimeMillis();
                //End case MotionEvent.ACTION_UP 
            } //End collapsed parenthetic
            addTaint(event.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.976 -0400", hash_original_method = "ABEB7C98C3FEAD2725211345FA5A10D0", hash_generated_method = "30CA90C103DA8FA71E21F0A5522D5304")
        private void updateMinAndMaxOffsets(MotionEvent event) {
            int pointerCount;
            pointerCount = event.getPointerCount();
            {
                int index;
                index = 0;
                {
                    int offset;
                    offset = getOffsetForPosition(event.getX(index), event.getY(index));
                    mMinTouchOffset = offset;
                    mMaxTouchOffset = offset;
                } //End block
            } //End collapsed parenthetic
            addTaint(event.getTaint());
            // ---------- Original Method ----------
            //int pointerCount = event.getPointerCount();
            //for (int index = 0; index < pointerCount; index++) {
                //int offset = getOffsetForPosition(event.getX(index), event.getY(index));
                //if (offset < mMinTouchOffset) mMinTouchOffset = offset;
                //if (offset > mMaxTouchOffset) mMaxTouchOffset = offset;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.976 -0400", hash_original_method = "CE1D6B62E449D2E0E68A6EA4156BEDFA", hash_generated_method = "DAFEC06AAE335E26C06520D6558F1625")
        public int getMinTouchOffset() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_148193645 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_148193645;
            // ---------- Original Method ----------
            //return mMinTouchOffset;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.976 -0400", hash_original_method = "C55B3C28483F8C218641DDDF4F4BCFF7", hash_generated_method = "CE21502A4D38DF232C996795AEFD0723")
        public int getMaxTouchOffset() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_739909992 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_739909992;
            // ---------- Original Method ----------
            //return mMaxTouchOffset;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.977 -0400", hash_original_method = "4C87B6BF406B366B26A5C4FE4B60E794", hash_generated_method = "9EFAFC374F80667294B5FCC935B7A9C3")
        public void resetTouchOffsets() {
            mMinTouchOffset = mMaxTouchOffset = -1;
            // ---------- Original Method ----------
            //mMinTouchOffset = mMaxTouchOffset = -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.977 -0400", hash_original_method = "CED25BB71024452A25A320AF88BD1346", hash_generated_method = "AD9006086629D1022738C55C3AA06DB5")
        public boolean isSelectionStartDragged() {
            boolean var3AC7E3EAE321C45E3F97AC24793B70E6_1993232673 = (mStartHandle != null && mStartHandle.isDragging());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_26962171 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_26962171;
            // ---------- Original Method ----------
            //return mStartHandle != null && mStartHandle.isDragging();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.977 -0400", hash_original_method = "43F562659DF9586EE8DC985200A1394B", hash_generated_method = "AFA5EE836BA01E42C65DC8B7F78125A2")
        public void onTouchModeChanged(boolean isInTouchMode) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                hide();
            } //End block
            addTaint(isInTouchMode);
            // ---------- Original Method ----------
            //if (!isInTouchMode) {
                //hide();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.983 -0400", hash_original_method = "190B38DD5A1110FFE55D8237DE7DCE67", hash_generated_method = "67F962F4029D636B40B68A7CC2149A16")
        @Override
        public void onDetached() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            ViewTreeObserver observer;
            observer = getViewTreeObserver();
            observer.removeOnTouchModeChangeListener(this);
            mStartHandle.onDetached();
            mEndHandle.onDetached();
            // ---------- Original Method ----------
            //final ViewTreeObserver observer = getViewTreeObserver();
            //observer.removeOnTouchModeChangeListener(this);
            //if (mStartHandle != null) mStartHandle.onDetached();
            //if (mEndHandle != null) mEndHandle.onDetached();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.983 -0400", hash_original_field = "8D0BCBE22EC74AB6363483A97E74D867", hash_generated_field = "ACAFDC99AAFA135B62414CD172DD9DA6")

        private static int DELAY_BEFORE_REPLACE_ACTION = 200;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.983 -0400", hash_original_field = "90BF1EE71A4DB43CBA163484BD738881", hash_generated_field = "45FC05E5A3BE803731DC202B62FD297D")

    static String LOG_TAG = "TextView";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.983 -0400", hash_original_field = "A4A1A96FF2E19D971B2D301080EE8C58", hash_generated_field = "97576765F91082B6940D428DCC0EF906")

    static boolean DEBUG_EXTRACT = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.983 -0400", hash_original_field = "18CA7A508D8AE1730B8CBC0435F40D92", hash_generated_field = "EC23C9A309D9D9994913AD87B0DEE878")

    private static int PRIORITY = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.983 -0400", hash_original_field = "5C25431CEAC1058F7B4F73D132DD44B4", hash_generated_field = "4EAC3820637E3964F0AE2EF563E69558")

    private static int PREDRAW_NOT_REGISTERED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.983 -0400", hash_original_field = "21B0F640D768604C58C1490A1DFBA771", hash_generated_field = "45149E5711E0AF18BA36CD4E522D8BB9")

    private static int PREDRAW_PENDING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.984 -0400", hash_original_field = "8A7412722DCADF6CC4FAEE79ED70EACB", hash_generated_field = "5C666AD97DA1F707BC76D39F2287F924")

    private static int PREDRAW_DONE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.984 -0400", hash_original_field = "07F356F3070D07B6930DE3A9967108FE", hash_generated_field = "8F30BA406FFBD9891389C7CF25FB2F60")

    private static int SANS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.984 -0400", hash_original_field = "5B5E6C83C125CC348E4EE28ACCFE5BFF", hash_generated_field = "428E29F9C183150C0C0F2ED7004E025C")

    private static int SERIF = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.984 -0400", hash_original_field = "399280F48C3EEEEAEAD47346CF3011F2", hash_generated_field = "8039A79A42E155F61CFB34F6D7543219")

    private static int MONOSPACE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.984 -0400", hash_original_field = "EFFD644F69714ABFB2C24FDB3792270D", hash_generated_field = "9184DF56A781C7FBFCF1CE31228437DF")

    private static int SIGNED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.984 -0400", hash_original_field = "A3C08F2EE3FEAB3A87DC101CC1A0E1B0", hash_generated_field = "E4029189E3980B6BD00A75AD4521F82B")

    private static int DECIMAL = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.984 -0400", hash_original_field = "B5762757AEE684A93E08453DCC72718E", hash_generated_field = "CEB75CD13D9579DA6846AE431B976949")

    private static int MARQUEE_FADE_NORMAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.984 -0400", hash_original_field = "685E750B6695CBAA6027EFEBD1DD0929", hash_generated_field = "34BF00EC347E28E0BC6F10D23A7C5120")

    private static int MARQUEE_FADE_SWITCH_SHOW_ELLIPSIS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.984 -0400", hash_original_field = "BAD4122AB746D6D5A26349392348653A", hash_generated_field = "90A9608D3424BF43480BE2A8747FB1F4")

    private static int MARQUEE_FADE_SWITCH_SHOW_FADE = 2;
    static {
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.measureText("H");
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.984 -0400", hash_original_field = "3495E75508822AD7294B9D1B2FFFD8F2", hash_generated_field = "18D8B0BFC7805EE695671225749DDB64")

    static int EXTRACT_NOTHING = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.984 -0400", hash_original_field = "CE33E876E6E0D3413392BF4D8BA5058C", hash_generated_field = "ACC73DF7AAF51EE3D9B7A2F38EA66938")

    static int EXTRACT_UNKNOWN = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.984 -0400", hash_original_field = "9D2F26242AC02A08143A50067F62CB8B", hash_generated_field = "675BF148FBBAD09AD3F7EE260FEDBF10")

    private static BoringLayout.Metrics UNKNOWN_BORING = new BoringLayout.Metrics();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.984 -0400", hash_original_field = "335E7B933E2786DDEF5BD0BD0D6F57B7", hash_generated_field = "634C3B58E5D1EE3C3B10A28928806BB4")

    private static int ID_SELECT_ALL = android.R.id.selectAll;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.984 -0400", hash_original_field = "FCF0B45B56220E42037E2959D5C784C5", hash_generated_field = "EFFC90508AD656469AC56680D3585F00")

    private static int ID_CUT = android.R.id.cut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.984 -0400", hash_original_field = "B59ED8F62B5AFBC9ECFF0B033CA31BFE", hash_generated_field = "620EA39AD72526AF61682D70A3C2D520")

    private static int ID_COPY = android.R.id.copy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.984 -0400", hash_original_field = "C538E3A9644EFB1E101695160425236B", hash_generated_field = "2343A77A0125706AEF239FD70053878F")

    private static int ID_PASTE = android.R.id.paste;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.984 -0400", hash_original_field = "73F3CAC515701006490A63FE8A88C6C6", hash_generated_field = "E5A9DCC1AED44E8FBDCE65EAEF110BC4")

    private static int LINES = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.984 -0400", hash_original_field = "73A4320C88A11B2FCF58BE496FEEA70E", hash_generated_field = "58606A44E67D8F85095FA7CC7D106E28")

    private static int EMS = LINES;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.984 -0400", hash_original_field = "0A7D60D23D133E25B638079E87CAA132", hash_generated_field = "DBDB824C8557B0F4681735D44DFE7D44")

    private static int PIXELS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.984 -0400", hash_original_field = "213EEEA9607FBD0242D99285FE74967E", hash_generated_field = "ED46B5773B9D6D08B1B59D4BE141453D")

    private static RectF sTempRect = new RectF();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.984 -0400", hash_original_field = "8212A1E8877C71B5CDD8A07429A76426", hash_generated_field = "D7EAEFD3E99386F2172462501B02EA0F")

    private static float[] sTmpPosition = new float[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.984 -0400", hash_original_field = "E200AB0F64D5773E76DC3D915E17A741", hash_generated_field = "29B9C98EE942128A3C89C4DE64043B2C")

    private static int VERY_WIDE = 1024*1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.984 -0400", hash_original_field = "C9D1C26ABB8B6EF477DF5359176F9D87", hash_generated_field = "C5DBE4F33BC7EB8136B5599B6FB29EBF")

    private static int BLINK = 500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.984 -0400", hash_original_field = "D4B6C25D0A03D262C947BCD869108225", hash_generated_field = "28BFF70450303C3390F9C60F9D069E8C")

    private static int ANIMATED_SCROLL_GAP = 250;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.984 -0400", hash_original_field = "A0DA38A5AAD1658278F1D161AF84C1BC", hash_generated_field = "5EFB7145770F29A6A7C59573A11D8B1E")

    private static InputFilter[] NO_FILTERS = new InputFilter[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.984 -0400", hash_original_field = "248F542BD33F18FF283146E6429096A7", hash_generated_field = "B7DC5A4B1A68EA846D951A4AEE617D4E")

    private static Spanned EMPTY_SPANNED = new SpannedString("");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.984 -0400", hash_original_field = "988659B291D672B8BE5DAE064AE3ECAA", hash_generated_field = "7034D880E0F4FCBF3812B9BF24C47313")

    private static int DRAG_SHADOW_MAX_TEXT_LENGTH = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.984 -0400", hash_original_field = "1D09C86A4C0CE5611F928ED8E5FF76B7", hash_generated_field = "191F5BCD79A0AB522145FB777A15B556")

    private static long sLastCutOrCopyTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.984 -0400", hash_original_field = "722A3224076063AF8DBCF4E5714C29A3", hash_generated_field = "1AB65DE69D30A5FEBF8629DC47DA3A7B")

    private static int[] MULTILINE_STATE_SET = ;
}

