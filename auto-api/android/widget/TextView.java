package android.widget;

// Droidsafe Imports
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;

import org.xmlpull.v1.XmlPullParserException;

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
import android.text.style.SpellCheckSpan;
import android.text.style.SuggestionRangeSpan;
import android.text.style.SuggestionSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.URLSpan;
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

import com.android.internal.util.FastMath;
import com.android.internal.widget.EditableInputConnection;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.runtime.DroidSafeAndroidRuntime;
// import Iterator to deal with enhanced for loop translation

public class TextView extends View implements ViewTreeObserver.OnPreDrawListener {
    static final String LOG_TAG = "TextView";
    static final boolean DEBUG_EXTRACT = false;
    private static final int PRIORITY = 100;
    private int mCurrentAlpha = 255;
    final int[] mTempCoords = new int[2];
    Rect mTempRect;
    private ColorStateList mTextColor;
    private int mCurTextColor;
    private ColorStateList mHintTextColor;
    private ColorStateList mLinkTextColor;
    private int mCurHintTextColor;
    private boolean mFreezesText;
    private boolean mFrozenWithFocus;
    private boolean mTemporaryDetach;
    private boolean mDispatchTemporaryDetach;
    private boolean mDiscardNextActionUp = false;
    private boolean mIgnoreActionUpEvent = false;
    private Editable.Factory mEditableFactory = Editable.Factory.getInstance();
    private Spannable.Factory mSpannableFactory = Spannable.Factory.getInstance();
    private float mShadowRadius, mShadowDx, mShadowDy;
    private static final int PREDRAW_NOT_REGISTERED = 0;
    private static final int PREDRAW_PENDING = 1;
    private static final int PREDRAW_DONE = 2;
    private int mPreDrawState = PREDRAW_NOT_REGISTERED;
    private TextUtils.TruncateAt mEllipsize = null;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int MONOSPACE = 3;
    private static final int SIGNED = 2;
    private static final int DECIMAL = 4;
    private Drawables mDrawables;
    private CharSequence mError;
    private boolean mErrorWasChanged;
    private ErrorPopup mPopup;
    private boolean mShowErrorAfterAttach;
    private CharWrapper mCharWrapper = null;
    private boolean mSelectionMoved = false;
    private boolean mTouchFocusSelected = false;
    private Marquee mMarquee;
    private boolean mRestartMarquee;
    private int mMarqueeRepeatLimit = 3;
    InputContentType mInputContentType;
    InputMethodState mInputMethodState;
    private int mTextSelectHandleLeftRes;
    private int mTextSelectHandleRightRes;
    private int mTextSelectHandleRes;
    private int mTextEditSuggestionItemLayout;
    private SuggestionsPopupWindow mSuggestionsPopupWindow;
    private SuggestionRangeSpan mSuggestionRangeSpan;
    private int mCursorDrawableRes;
    private final Drawable[] mCursorDrawable = new Drawable[2];
    private int mCursorCount;
    private Drawable mSelectHandleLeft;
    private Drawable mSelectHandleRight;
    private Drawable mSelectHandleCenter;
    private PositionListener mPositionListener;
    private float mLastDownPositionX, mLastDownPositionY;
    private Callback mCustomSelectionActionModeCallback;
    private final int mSquaredTouchSlopDistance;
    private boolean mCreatedWithASelection = false;
    private WordIterator mWordIterator;
    private SpellChecker mSpellChecker;
    private boolean mSoftInputShownOnFocus = true;
    private Layout.Alignment mLayoutAlignment;
    private TextAlign mTextAlign = TextAlign.INHERIT;
    private boolean mResolvedDrawables = false;
    private int mMarqueeFadeMode = MARQUEE_FADE_NORMAL;
    private Layout mSavedMarqueeModeLayout;
    private static final int MARQUEE_FADE_NORMAL = 0;
    private static final int MARQUEE_FADE_SWITCH_SHOW_ELLIPSIS = 1;
    private static final int MARQUEE_FADE_SWITCH_SHOW_FADE = 2;
    static final int EXTRACT_NOTHING = -2;
    static final int EXTRACT_UNKNOWN = -1;
    private static final BoringLayout.Metrics UNKNOWN_BORING = new BoringLayout.Metrics();
    private static final int ID_SELECT_ALL = android.R.id.selectAll;
    private static final int ID_CUT = android.R.id.cut;
    private static final int ID_COPY = android.R.id.copy;
    private static final int ID_PASTE = android.R.id.paste;
    @ViewDebug.ExportedProperty(category = "text")
    private CharSequence            mText;
    private CharSequence            mTransformed;
    private BufferType              mBufferType = BufferType.NORMAL;
    private int                     mInputType = EditorInfo.TYPE_NULL;
    private CharSequence            mHint;
    private Layout                  mHintLayout;
    private KeyListener             mInput;
    private MovementMethod          mMovement;
    private TransformationMethod    mTransformation;
    private boolean                 mAllowTransformationLengthChange;
    private ChangeWatcher           mChangeWatcher;
    private ArrayList<TextWatcher>  mListeners = null;
    private final TextPaint         mTextPaint;
    private boolean                 mUserSetTextScaleX;
    private final Paint             mHighlightPaint;
    private int                     mHighlightColor = 0x6633B5E5;
    protected Layout                mLayout;
    private long                    mShowCursor;
    private Blink                   mBlink;
    private boolean                 mCursorVisible = true;
    private InsertionPointCursorController mInsertionPointCursorController;
    private SelectionModifierCursorController mSelectionModifierCursorController;
    private ActionMode              mSelectionActionMode;
    private boolean                 mInsertionControllerEnabled;
    private boolean                 mSelectionControllerEnabled;
    private boolean                 mInBatchEditControllers;
    private boolean                 mSelectAllOnFocus = false;
    private int                     mGravity = Gravity.TOP | Gravity.START;
    private boolean                 mHorizontallyScrolling;
    private int                     mAutoLinkMask;
    private boolean                 mLinksClickable = true;
    private float                   mSpacingMult = 1.0f;
    private float                   mSpacingAdd = 0.0f;
    private boolean                 mTextIsSelectable = false;
    private static final int        LINES = 1;
    private static final int        EMS = LINES;
    private static final int        PIXELS = 2;
    private int                     mMaximum = Integer.MAX_VALUE;
    private int                     mMaxMode = LINES;
    private int                     mMinimum = 0;
    private int                     mMinMode = LINES;
    private int                     mOldMaximum = mMaximum;
    private int                     mOldMaxMode = mMaxMode;
    private int                     mMaxWidth = Integer.MAX_VALUE;
    private int                     mMaxWidthMode = PIXELS;
    private int                     mMinWidth = 0;
    private int                     mMinWidthMode = PIXELS;
    private boolean                 mSingleLine;
    private int                     mDesiredHeightAtMeasure = -1;
    private boolean                 mIncludePad = true;
    private Path                    mHighlightPath;
    private boolean                 mHighlightPathBogus = true;
    private static final RectF      sTempRect = new RectF();
    private static final float[]    sTmpPosition = new float[2];
    private static final int        VERY_WIDE = 1024*1024;
    private static final int        BLINK = 500;
    private static final int ANIMATED_SCROLL_GAP = 250;
    private long mLastScroll;
    private Scroller mScroller = null;
    private BoringLayout.Metrics mBoring;
    private BoringLayout.Metrics mHintBoring;
    private BoringLayout mSavedLayout, mSavedHintLayout;
    private TextDirectionHeuristic mTextDir = null;
    private static final InputFilter[] NO_FILTERS = new InputFilter[0];
    private InputFilter[] mFilters = NO_FILTERS;
    private static final Spanned EMPTY_SPANNED = new SpannedString("");
    private static int DRAG_SHADOW_MAX_TEXT_LENGTH = 20;
    private static long sLastCutOrCopyTime;
    private CorrectionHighlighter mCorrectionHighlighter;
    private static final int[] MULTILINE_STATE_SET = { R.attr.state_multiline };
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.118 -0400", hash_original_method = "16A18A865F32B95685EAC04EF434D4B5", hash_generated_method = "82BE524C73333A3734B22B45B2676AF4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TextView(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.118 -0400", hash_original_method = "2AA1B7AF4AA0321ED5A0A8E3910A65F3", hash_generated_method = "B3AA918E2C896C98A0F62D84ED81F095")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TextView(Context context,
                    AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.textViewStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.120 -0400", hash_original_method = "9090DB4BB502E7A1E7DDA866F2D92623", hash_generated_method = "B7D8532F6C5C6C60B00FBEC9D0189B4E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("deprecation")
    public TextView(Context context,
                    AttributeSet attrs,
                    int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        mText = "";
        final Resources res;
        res = getResources();
        final CompatibilityInfo compat;
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
        final Resources.Theme theme;
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
                    boolean var45591D90FC7AE21A8CB6FE28079E45A9_103616111 = (a.getBoolean(attr, false));
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
                    boolean varE83A5B5DD6F1EFE4CE2BCD602A46684B_1393092573 = (!a.getBoolean(attr, true));
                    {
                        setIncludeFontPadding(false);
                    } //End block
                } //End collapsed parenthetic
                //End case com.android.internal.R.styleable.TextView_includeFontPadding 
                //Begin case com.android.internal.R.styleable.TextView_cursorVisible 
                {
                    boolean varE83A5B5DD6F1EFE4CE2BCD602A46684B_306964061 = (!a.getBoolean(attr, true));
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
        final int variation;
        variation = inputType & (EditorInfo.TYPE_MASK_CLASS | EditorInfo.TYPE_MASK_VARIATION);
        final boolean passwordInputType;
        passwordInputType = variation
                == (EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_VARIATION_PASSWORD);
        final boolean webPasswordInputType;
        webPasswordInputType = variation
                == (EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_VARIATION_WEB_PASSWORD);
        final boolean numberPasswordInputType;
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
                throw new RuntimeException(ex);
            } //End block
            try 
            {
                mInput = (KeyListener) c.newInstance();
            } //End block
            catch (InstantiationException ex)
            {
                throw new RuntimeException(ex);
            } //End block
            catch (IllegalAccessException ex)
            {
                throw new RuntimeException(ex);
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
            boolean var8F0ACED8C99F3716300411BE9198A3C2_1160793041 = (ViewConfiguration.get(context).isFadingMarqueeEnabled());
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
        final ViewConfiguration viewConfiguration;
        viewConfiguration = ViewConfiguration.get(context);
        final int touchSlop;
        touchSlop = viewConfiguration.getScaledTouchSlop();
        mSquaredTouchSlopDistance = touchSlop * touchSlop;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.121 -0400", hash_original_method = "C60E18AF77ADDBBD7F15C48D3326353D", hash_generated_method = "DADD23FF2BF3909F999D5F80EA7C94BE")
    @DSModeled(DSC.SAFE)
    private void setTypefaceByIndex(int typefaceIndex, int styleIndex) {
        dsTaint.addTaint(typefaceIndex);
        dsTaint.addTaint(styleIndex);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.122 -0400", hash_original_method = "81361F4824C6D1D7960776386313375B", hash_generated_method = "3707B5F5F642ABD4EDEEFEF0AC46064E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setRelativeDrawablesIfNeeded(Drawable start, Drawable end) {
        dsTaint.addTaint(start.dsTaint);
        dsTaint.addTaint(end.dsTaint);
        boolean hasRelativeDrawables;
        hasRelativeDrawables = (start != null) || (end != null);
        {
            Drawables dr;
            dr = mDrawables;
            {
                mDrawables = dr = new Drawables();
            } //End block
            final Rect compoundRect;
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.122 -0400", hash_original_method = "224789FFA5DBD63B17185276A15DADF0", hash_generated_method = "06B21F3FE17A9C5BE15DD23CB75CCD4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        {
            boolean var7DA8DB0EDBF2B3C1E618EFC1F33534DC_1355871767 = (enabled == isEnabled());
        } //End collapsed parenthetic
        {
            InputMethodManager imm;
            imm = InputMethodManager.peekInstance();
            {
                boolean var4937F8F03F6BF371ED8AD64A66FE25A6_635987005 = (imm != null && imm.isActive(this));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.122 -0400", hash_original_method = "6CE73F981984CDCC5004358BB070DFC0", hash_generated_method = "6F628327DAB730FBA07E920E59969361")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTypeface(Typeface tf, int style) {
        dsTaint.addTaint(style);
        dsTaint.addTaint(tf.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.122 -0400", hash_original_method = "BFDF598F6F7CD4AFD7EB65F700EA9607", hash_generated_method = "0AF641645DE0D5070416814B7EA9FFAE")
    @DSModeled(DSC.SAFE)
    protected boolean getDefaultEditable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.122 -0400", hash_original_method = "BBE0A92ADC5D9278A97962CE8941F1CB", hash_generated_method = "4C916CCEEA653DB5D52EE0C655BDC5C5")
    @DSModeled(DSC.SAFE)
    protected MovementMethod getDefaultMovementMethod() {
        return (MovementMethod)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.122 -0400", hash_original_method = "D3D56665E0CC0B43413FBFB4C720E96C", hash_generated_method = "147F46DB804BBA7DE5EBD49D453EEBFF")
    @DSModeled(DSC.SAFE)
    @ViewDebug.CapturedViewProperty
    public CharSequence getText() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.122 -0400", hash_original_method = "9A68249D01A4FE1CBD4D535668FCEB6F", hash_generated_method = "6E0DA3F420364EF5FDFF799F5ED9BBA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int length() {
        int var32A6F8CD5764B26A2339FAB65BD4098F_1103832924 = (mText.length());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mText.length();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.122 -0400", hash_original_method = "7ED3A36B3A9686857AF495D746EF7144", hash_generated_method = "0150380F11F0FC7EF6D45E968C09DD12")
    @DSModeled(DSC.SAFE)
    public Editable getEditableText() {
        return (Editable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (mText instanceof Editable) ? (Editable)mText : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.122 -0400", hash_original_method = "0FF7B2A5A4CF7321FA6B03810945EA51", hash_generated_method = "C3277E4A39E65703302FD1BBE469660A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLineHeight() {
        int var20B277202414C5A1CC77B4034C64DAD9_748679670 = (FastMath.round(mTextPaint.getFontMetricsInt(null) * mSpacingMult + mSpacingAdd));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return FastMath.round(mTextPaint.getFontMetricsInt(null) * mSpacingMult + mSpacingAdd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.123 -0400", hash_original_method = "AA853122D8F66FE025B9AF375421C379", hash_generated_method = "8949E3D8E817518891DBBEEBCC53A342")
    @DSModeled(DSC.SAFE)
    public final Layout getLayout() {
        return (Layout)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mLayout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.123 -0400", hash_original_method = "16C14256413AD7EC2C071FEF64E5C315", hash_generated_method = "12A61F3968786C55D14E75E8C5ED1E7C")
    @DSModeled(DSC.SAFE)
    public final KeyListener getKeyListener() {
        return (KeyListener)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mInput;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.123 -0400", hash_original_method = "C24E7464E624E00527FA94ACF2B78CDF", hash_generated_method = "C72ED7B0AA6AFD91E43C4E6BFA3DEB3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setKeyListener(KeyListener input) {
        dsTaint.addTaint(input.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.123 -0400", hash_original_method = "4C0922906A0644E54152EA479C6FB8D4", hash_generated_method = "D2BAFDFA9A038DA9C02D66933047D206")
    @DSModeled(DSC.SAFE)
    private void setKeyListenerOnly(KeyListener input) {
        dsTaint.addTaint(input.dsTaint);
        setText(mText);
        setFilters((Editable) mText, mFilters);
        // ---------- Original Method ----------
        //mInput = input;
        //if (mInput != null && !(mText instanceof Editable))
            //setText(mText);
        //setFilters((Editable) mText, mFilters);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.123 -0400", hash_original_method = "48923BC0AD13C4CAAF5FC92105497B11", hash_generated_method = "84B89A0728DE36C00CB3C7BE29461022")
    @DSModeled(DSC.SAFE)
    public final MovementMethod getMovementMethod() {
        return (MovementMethod)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mMovement;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.123 -0400", hash_original_method = "A60F83672BBDF336AF379460700DB19E", hash_generated_method = "A34AA172EE0108A17EE11D8CDCD26951")
    @DSModeled(DSC.SAFE)
    public final void setMovementMethod(MovementMethod movement) {
        dsTaint.addTaint(movement.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.123 -0400", hash_original_method = "20BA1DEB0A4AF2EE483D2287D9007BE7", hash_generated_method = "9D27F10C0D75385B8CB10D490D7D7D68")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.123 -0400", hash_original_method = "2CDC6DDF1029E76D6DBEC0602C28EC15", hash_generated_method = "9B284BF7C4F44D89C001ADCACD67659A")
    @DSModeled(DSC.SAFE)
    public final TransformationMethod getTransformationMethod() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return (TransformationMethod)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTransformation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.123 -0400", hash_original_method = "93D394D84FFC0B02B9FD24841443EB6E", hash_generated_method = "5CB68DDA3CFB94CB9F7BD8BE5F0AD09F")
    @DSModeled(DSC.SAFE)
    public final void setTransformationMethod(TransformationMethod method) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(method.dsTaint);
        {
            {
                ((Spannable) mText).removeSpan(mTransformation);
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.123 -0400", hash_original_method = "CD4E87E17C71F6F36E69A30DF125A2EC", hash_generated_method = "0FEC5B9630832CD8D933B5A188596B4E")
    @DSModeled(DSC.SAFE)
    public int getCompoundPaddingTop() {
        final Drawables dr;
        dr = mDrawables;
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final Drawables dr = mDrawables;
        //if (dr == null || dr.mDrawableTop == null) {
            //return mPaddingTop;
        //} else {
            //return mPaddingTop + dr.mDrawablePadding + dr.mDrawableSizeTop;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.124 -0400", hash_original_method = "F8E73EA88ED50BD236713C6E1FD6275E", hash_generated_method = "030AD396DF482524ECCF5EFF25635DEC")
    @DSModeled(DSC.SAFE)
    public int getCompoundPaddingBottom() {
        final Drawables dr;
        dr = mDrawables;
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final Drawables dr = mDrawables;
        //if (dr == null || dr.mDrawableBottom == null) {
            //return mPaddingBottom;
        //} else {
            //return mPaddingBottom + dr.mDrawablePadding + dr.mDrawableSizeBottom;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.124 -0400", hash_original_method = "E37CE1C2FEDB3DD18FEE34DF2470D692", hash_generated_method = "2F9C815C5419A86A942246E4105BCD3D")
    @DSModeled(DSC.SAFE)
    public int getCompoundPaddingLeft() {
        final Drawables dr;
        dr = mDrawables;
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final Drawables dr = mDrawables;
        //if (dr == null || dr.mDrawableLeft == null) {
            //return mPaddingLeft;
        //} else {
            //return mPaddingLeft + dr.mDrawablePadding + dr.mDrawableSizeLeft;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.124 -0400", hash_original_method = "FA75E1802F0BBA6FD5DC7258A0FBEB3C", hash_generated_method = "3BDEE2A9C52E6D149E4E2926CDBB080E")
    @DSModeled(DSC.SAFE)
    public int getCompoundPaddingRight() {
        final Drawables dr;
        dr = mDrawables;
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final Drawables dr = mDrawables;
        //if (dr == null || dr.mDrawableRight == null) {
            //return mPaddingRight;
        //} else {
            //return mPaddingRight + dr.mDrawablePadding + dr.mDrawableSizeRight;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.124 -0400", hash_original_method = "045E56B45A145CD7B99AFA777E63AEB3", hash_generated_method = "3352D42034F613C9C722116B4017125F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCompoundPaddingStart() {
        resolveDrawables();
        {
            Object varAFC6EB2C684D509A17B3A4EFF5D9CB9D_440197315 = (getResolvedLayoutDirection());
            //Begin case default LAYOUT_DIRECTION_LTR 
            int var781EBC093D28721525521D7AA075C977_970649627 = (getCompoundPaddingLeft());
            //End case default LAYOUT_DIRECTION_LTR 
            //Begin case LAYOUT_DIRECTION_RTL 
            int var8A1D5A6585B3402DA0435C7A847F7E9A_1780398574 = (getCompoundPaddingRight());
            //End case LAYOUT_DIRECTION_RTL 
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.124 -0400", hash_original_method = "0C4A0FB6513BA7C283389B0C3E09BE68", hash_generated_method = "2000C6FC0B14818697D3665B92F0E167")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCompoundPaddingEnd() {
        resolveDrawables();
        {
            Object varAFC6EB2C684D509A17B3A4EFF5D9CB9D_1485027664 = (getResolvedLayoutDirection());
            //Begin case default LAYOUT_DIRECTION_LTR 
            int var8A1D5A6585B3402DA0435C7A847F7E9A_2088456051 = (getCompoundPaddingRight());
            //End case default LAYOUT_DIRECTION_LTR 
            //Begin case LAYOUT_DIRECTION_RTL 
            int var781EBC093D28721525521D7AA075C977_606422475 = (getCompoundPaddingLeft());
            //End case LAYOUT_DIRECTION_RTL 
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.124 -0400", hash_original_method = "363FF0B4BA7F59F6CC6EB59AE673A7C9", hash_generated_method = "82E23BE350954720B3FC88E47EC3DF1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getExtendedPaddingTop() {
        {
            int var616A12A33C5C9277AD7C0C5C89BD69B5_215287676 = (getCompoundPaddingTop());
        } //End block
        {
            boolean var907B1900A80A700A44CB9B3E7CFA8547_1823854344 = (mLayout.getLineCount() <= mMaximum);
            {
                int varDAC50BDCD5E1A4A87E580425D0AB90D1_1640458951 = (getCompoundPaddingTop());
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
        final int gravity;
        gravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.124 -0400", hash_original_method = "7A2DB8BFB057F07CEDE0D120BE6FFB10", hash_generated_method = "9A862074B42D99DA2C3BB1DB05CD6153")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getExtendedPaddingBottom() {
        {
            int varB616C533FD1413DFA57A8B3E4A355326_1123809786 = (getCompoundPaddingBottom());
        } //End block
        {
            boolean var907B1900A80A700A44CB9B3E7CFA8547_91196669 = (mLayout.getLineCount() <= mMaximum);
            {
                int varF7C5B922A73A10EEE346A45E2A7B3E82_928393072 = (getCompoundPaddingBottom());
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
        final int gravity;
        gravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.124 -0400", hash_original_method = "5245DB1A490E586E6093F4BFC26117D1", hash_generated_method = "B17E16D547B3ADFB7FF05E22D4411424")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTotalPaddingLeft() {
        int var34500B372695C1C0BF8F0AECDF252C98_1321661101 = (getCompoundPaddingLeft());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getCompoundPaddingLeft();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.124 -0400", hash_original_method = "A1EB6CC80DC85EDA662D4DD9C10BBDEB", hash_generated_method = "6956742095F799928A81F1B4C4436A62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTotalPaddingRight() {
        int var9B702A81BD3510988CA34C6D5C5CC2BB_93994669 = (getCompoundPaddingRight());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getCompoundPaddingRight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.125 -0400", hash_original_method = "DD9B038504EC66CC7FCB75AE1CB753E5", hash_generated_method = "162AAA76EDA61FF0E9CD53CD8D3E1796")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTotalPaddingStart() {
        int var7D7F8C48280E1131C487BF0950634EDB_46092121 = (getCompoundPaddingStart());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getCompoundPaddingStart();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.125 -0400", hash_original_method = "7924A3AF5CA0D716DAB0CFDF1EC0C456", hash_generated_method = "1A282857882D1217F384385CF5116FCC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTotalPaddingEnd() {
        int varF719AD7587A07158D4596514D0584E08_1049377824 = (getCompoundPaddingEnd());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getCompoundPaddingEnd();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.125 -0400", hash_original_method = "3FBB92A2EE65C62C674BD5E5A5FB2713", hash_generated_method = "3B5CFF0629EFDF2B722C8ED658CFD282")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTotalPaddingTop() {
        int varCBA1A1AACA4E5447F7B59F1AEE81650D_1544402165 = (getExtendedPaddingTop() + getVerticalOffset(true));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getExtendedPaddingTop() + getVerticalOffset(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.125 -0400", hash_original_method = "DD0E7E66835F9F938ABD11A206F39F98", hash_generated_method = "C415E8358CB2B37FF5E57740E60E93CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTotalPaddingBottom() {
        int var8B593715CC9C8A177070B563C501DACE_1513968181 = (getExtendedPaddingBottom() + getBottomVerticalOffset(true));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getExtendedPaddingBottom() + getBottomVerticalOffset(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.125 -0400", hash_original_method = "FDA2BF05D2CC3125A844DA2F1CDB97F3", hash_generated_method = "5ECBF0BFF5D7228FA7C06B754EC6E90F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCompoundDrawables(Drawable left, Drawable top,
                                     Drawable right, Drawable bottom) {
        dsTaint.addTaint(bottom.dsTaint);
        dsTaint.addTaint(left.dsTaint);
        dsTaint.addTaint(right.dsTaint);
        dsTaint.addTaint(top.dsTaint);
        Drawables dr;
        dr = mDrawables;
        final boolean drawables;
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
            final Rect compoundRect;
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.126 -0400", hash_original_method = "4DA9B29500DC46492C6684BECC05C749", hash_generated_method = "350F5B77128A09FE6C4783A5F13ED511")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCompoundDrawablesWithIntrinsicBounds(int left, int top, int right, int bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        final Resources resources;
        resources = getContext().getResources();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.126 -0400", hash_original_method = "19E536EC7FD9E8E0EBEABA79F37A1C35", hash_generated_method = "E944289203A2416B957A434D81A8840D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable left, Drawable top,
            Drawable right, Drawable bottom) {
        dsTaint.addTaint(bottom.dsTaint);
        dsTaint.addTaint(left.dsTaint);
        dsTaint.addTaint(right.dsTaint);
        dsTaint.addTaint(top.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.126 -0400", hash_original_method = "C527F166CA85E985387BA0B670132163", hash_generated_method = "0F79CC47D96B6EDB43AA93C363D34B6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCompoundDrawablesRelative(Drawable start, Drawable top,
                                     Drawable end, Drawable bottom) {
        dsTaint.addTaint(start.dsTaint);
        dsTaint.addTaint(bottom.dsTaint);
        dsTaint.addTaint(end.dsTaint);
        dsTaint.addTaint(top.dsTaint);
        Drawables dr;
        dr = mDrawables;
        final boolean drawables;
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
            final Rect compoundRect;
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.127 -0400", hash_original_method = "08DFFEC64B0A3553E53B210C6E8B4F5B", hash_generated_method = "197487F9307F8F441D677AFA6CA2AF25")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int start, int top, int end,
            int bottom) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(end);
        dsTaint.addTaint(top);
        resetResolvedDrawables();
        final Resources resources;
        resources = getContext().getResources();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.127 -0400", hash_original_method = "BA79780015035B80B72E7A4B08D0D299", hash_generated_method = "175DD1BD94548837206F29C7CE9F0A92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable start, Drawable top,
            Drawable end, Drawable bottom) {
        dsTaint.addTaint(start.dsTaint);
        dsTaint.addTaint(bottom.dsTaint);
        dsTaint.addTaint(end.dsTaint);
        dsTaint.addTaint(top.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.127 -0400", hash_original_method = "06FDA6F654D58A3BC65C29C47124F71A", hash_generated_method = "D7FB5726DD856412E93F62317B639B54")
    @DSModeled(DSC.SAFE)
    public Drawable[] getCompoundDrawables() {
        final Drawables dr;
        dr = mDrawables;
        return (Drawable[])dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.127 -0400", hash_original_method = "7D536599368FF7E7773D59B2D0C7C092", hash_generated_method = "DB85D13F32FE00821B66E65DC936A5C4")
    @DSModeled(DSC.SAFE)
    public Drawable[] getCompoundDrawablesRelative() {
        final Drawables dr;
        dr = mDrawables;
        return (Drawable[])dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.127 -0400", hash_original_method = "7E4DBC59802038B0E00C34B579D2DA37", hash_generated_method = "5DBAF13BEDCDB94ABE70D273A21A0899")
    @DSModeled(DSC.SAFE)
    public void setCompoundDrawablePadding(int pad) {
        dsTaint.addTaint(pad);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.127 -0400", hash_original_method = "6B458DA6759E58857DA3CAF4E6D1B789", hash_generated_method = "907FD77385BCFC329A37A29BB219C608")
    @DSModeled(DSC.SAFE)
    public int getCompoundDrawablePadding() {
        final Drawables dr;
        dr = mDrawables;
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final Drawables dr = mDrawables;
        //return dr != null ? dr.mDrawablePadding : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.127 -0400", hash_original_method = "4C42E9479946D6D8F38619DA66232863", hash_generated_method = "988AD2E604AFEF9B34D8E363E4E482BC")
    @DSModeled(DSC.SAFE)
    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.127 -0400", hash_original_method = "D796BA921A3359840CCD26FF0DD1CFB0", hash_generated_method = "55B685B1E64A4DFA9F03256EBBB75761")
    @DSModeled(DSC.SAFE)
    public final int getAutoLinkMask() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mAutoLinkMask;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.128 -0400", hash_original_method = "FFEF779179433D30901B486DA8C4C9D0", hash_generated_method = "9B688B1735D98CEA72DF385E092C2F4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTextAppearance(Context context, int resid) {
        dsTaint.addTaint(resid);
        dsTaint.addTaint(context.dsTaint);
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
            boolean var3D022060DB92710670FAA09E327DBB0B_1360109337 = (appearance.getBoolean(com.android.internal.R.styleable.TextAppearance_textAllCaps,
                false));
            {
                setTransformationMethod(new AllCapsTransformationMethod(getContext()));
            } //End block
        } //End collapsed parenthetic
        appearance.recycle();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.128 -0400", hash_original_method = "5E6FE671862457C6BB25EDC2CEDE399B", hash_generated_method = "ED852D64D7C38F689B6A11BD84561A06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getTextSize() {
        float var0C1431BDAC3C89F7C02E56A482F7EB06_1556583773 = (mTextPaint.getTextSize());
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mTextPaint.getTextSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.128 -0400", hash_original_method = "7DB2A551583349AB1C418E0528006365", hash_generated_method = "F7847B312615B3E11A68A58C00451909")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public void setTextSize(float size) {
        dsTaint.addTaint(size);
        setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        // ---------- Original Method ----------
        //setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.128 -0400", hash_original_method = "487975E6A0CF72E721F7BDECB44E1312", hash_generated_method = "92147818B3770CA8057A903C0254F1C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTextSize(int unit, float size) {
        dsTaint.addTaint(unit);
        dsTaint.addTaint(size);
        Context c;
        c = getContext();
        Resources r;
        r = Resources.getSystem();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.128 -0400", hash_original_method = "ADDFE88D6F3490AE157EE578011F4FFC", hash_generated_method = "57731E03552DF994A36D2592F418BB59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setRawTextSize(float size) {
        dsTaint.addTaint(size);
        {
            boolean var8490AB7BC9B8B736A0090BC029E3A656_1660726715 = (size != mTextPaint.getTextSize());
            {
                mTextPaint.setTextSize(size);
                {
                    nullLayouts();
                    requestLayout();
                    invalidate();
                } //End block
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.128 -0400", hash_original_method = "8F71F8091E79DE5D49BC786B53F6B56F", hash_generated_method = "5A6BDDC37EF426BB6F250F342843DFBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getTextScaleX() {
        float var4A490DCBBE6DC7C04831F39DE35D9E8E_2048010126 = (mTextPaint.getTextScaleX());
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mTextPaint.getTextScaleX();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.128 -0400", hash_original_method = "32FC23A8E8D24759E03CF98EE692BD3E", hash_generated_method = "FD769C371C494FA108C986C5FCE6932B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @android.view.RemotableViewMethod
    public void setTextScaleX(float size) {
        dsTaint.addTaint(size);
        {
            boolean varE98E2F263E58724773A791619F9AA580_1439256394 = (size != mTextPaint.getTextScaleX());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.128 -0400", hash_original_method = "780D15535FA403FCFD3F32D6E7303769", hash_generated_method = "D6292D0C23EBEB10A94D98649F92F46A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTypeface(Typeface tf) {
        dsTaint.addTaint(tf.dsTaint);
        {
            boolean var53A61D5B68551E1C004BF255C4B2B68F_2121948162 = (mTextPaint.getTypeface() != tf);
            {
                mTextPaint.setTypeface(tf);
                {
                    nullLayouts();
                    requestLayout();
                    invalidate();
                } //End block
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.128 -0400", hash_original_method = "6FFDE601A24D081BE5F9A52F7BB654E9", hash_generated_method = "CCAD96D0177403F74136836C6440D512")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Typeface getTypeface() {
        Typeface varBBE09A13FC0F6DCAEE22122CCEE5E0EF_516918077 = (mTextPaint.getTypeface());
        return (Typeface)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTextPaint.getTypeface();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.128 -0400", hash_original_method = "7D6C422943C1CBA6B222D2B0CA531386", hash_generated_method = "3782FDDA321E08154D931A8A8C26F14E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @android.view.RemotableViewMethod
    public void setTextColor(int color) {
        dsTaint.addTaint(color);
        mTextColor = ColorStateList.valueOf(color);
        updateTextColors();
        // ---------- Original Method ----------
        //mTextColor = ColorStateList.valueOf(color);
        //updateTextColors();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.129 -0400", hash_original_method = "E5548FB85C1126384CE08AD8E1667A0C", hash_generated_method = "324010096829CCEFFE6BFF3082060FF3")
    @DSModeled(DSC.SAFE)
    public void setTextColor(ColorStateList colors) {
        dsTaint.addTaint(colors.dsTaint);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new NullPointerException();
        } //End block
        updateTextColors();
        // ---------- Original Method ----------
        //if (colors == null) {
            //throw new NullPointerException();
        //}
        //mTextColor = colors;
        //updateTextColors();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.129 -0400", hash_original_method = "E9708E6780595497A0F38B1A3DFD4921", hash_generated_method = "4A1EBAF45C7822C2D7291B28FBADF0FB")
    @DSModeled(DSC.SAFE)
    public final ColorStateList getTextColors() {
        return (ColorStateList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTextColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.129 -0400", hash_original_method = "69BC167CA8CC0024E4446D6ED57F972B", hash_generated_method = "C4A9442BC43300DBE2F5DA7416BE79A0")
    @DSModeled(DSC.SAFE)
    public final int getCurrentTextColor() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCurTextColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.129 -0400", hash_original_method = "969DDD835D55F329C6E2048E92EE3D41", hash_generated_method = "6E7E839073A2A9D56AEEA6A871A1D686")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public void setHighlightColor(int color) {
        dsTaint.addTaint(color);
        {
            invalidate();
        } //End block
        // ---------- Original Method ----------
        //if (mHighlightColor != color) {
            //mHighlightColor = color;
            //invalidate();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.129 -0400", hash_original_method = "5ADAC484D4689A7795B408EA7D6B6AC8", hash_generated_method = "E9D277D96A9CB2B610A583747AD4E34A")
    @DSModeled(DSC.SAFE)
    public void setShadowLayer(float radius, float dx, float dy, int color) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        dsTaint.addTaint(color);
        dsTaint.addTaint(radius);
        mTextPaint.setShadowLayer(radius, dx, dy, color);
        invalidate();
        // ---------- Original Method ----------
        //mTextPaint.setShadowLayer(radius, dx, dy, color);
        //mShadowRadius = radius;
        //mShadowDx = dx;
        //mShadowDy = dy;
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.129 -0400", hash_original_method = "5B4E8CD3DF4A8D21F89EBB7BF27B30F6", hash_generated_method = "3D09AFB02C409D90F6283A0250F29D2D")
    @DSModeled(DSC.SAFE)
    public TextPaint getPaint() {
        return (TextPaint)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTextPaint;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.129 -0400", hash_original_method = "9B238C42610AAE77586EFF469787CAA2", hash_generated_method = "A2EE709B270EFD39F55D4762492A5EAB")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public final void setAutoLinkMask(int mask) {
        dsTaint.addTaint(mask);
        // ---------- Original Method ----------
        //mAutoLinkMask = mask;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.129 -0400", hash_original_method = "E276016FD2FFF976FC669270E78164FC", hash_generated_method = "AD653C87150243A67DE3D5CBA5F39ECB")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public final void setLinksClickable(boolean whether) {
        dsTaint.addTaint(whether);
        // ---------- Original Method ----------
        //mLinksClickable = whether;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.129 -0400", hash_original_method = "5582C38299F4F11EB9D233BD445CE8CA", hash_generated_method = "0D8211060FC7629194FEA9DE5A8771AE")
    @DSModeled(DSC.SAFE)
    public final boolean getLinksClickable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mLinksClickable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.129 -0400", hash_original_method = "4DF4A96EB5A0519062801E1FD0A991F4", hash_generated_method = "5F5FFAF3A35109837439BF3F0A423DAB")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public final void setSoftInputShownOnFocus(boolean show) {
        dsTaint.addTaint(show);
        // ---------- Original Method ----------
        //mSoftInputShownOnFocus = show;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.129 -0400", hash_original_method = "5A10A6630E4A15A93780A83DCE21BFA6", hash_generated_method = "0259D94C8A6589FD1E33025626AEDDD8")
    @DSModeled(DSC.SAFE)
    public final boolean getSoftInputShownOnFocus() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSoftInputShownOnFocus;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.129 -0400", hash_original_method = "7722BA5204257A1CDED1550384208856", hash_generated_method = "7784C73693CF691120CA83D5BB5560DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URLSpan[] getUrls() {
        {
            URLSpan[] var5B57915DC6AEEED37A2366C3E794B561_1398513660 = (((Spanned) mText).getSpans(0, mText.length(), URLSpan.class));
        } //End block
        return (URLSpan[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mText instanceof Spanned) {
            //return ((Spanned) mText).getSpans(0, mText.length(), URLSpan.class);
        //} else {
            //return new URLSpan[0];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.129 -0400", hash_original_method = "E9B4A1B921938A82A5322DAF3992AE5D", hash_generated_method = "D347A9BC5D3D581D201EFAD67969A374")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @android.view.RemotableViewMethod
    public final void setHintTextColor(int color) {
        dsTaint.addTaint(color);
        mHintTextColor = ColorStateList.valueOf(color);
        updateTextColors();
        // ---------- Original Method ----------
        //mHintTextColor = ColorStateList.valueOf(color);
        //updateTextColors();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.129 -0400", hash_original_method = "FDEA4F057DD6E07AD523C7053B227866", hash_generated_method = "E2C72BD8D4A1E6C02E10638C537BC737")
    @DSModeled(DSC.SAFE)
    public final void setHintTextColor(ColorStateList colors) {
        dsTaint.addTaint(colors.dsTaint);
        updateTextColors();
        // ---------- Original Method ----------
        //mHintTextColor = colors;
        //updateTextColors();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.130 -0400", hash_original_method = "475EC0453C7F74E6A779EAD7F8319059", hash_generated_method = "8BE7E248BA78611CFFDEC29C242E1E04")
    @DSModeled(DSC.SAFE)
    public final ColorStateList getHintTextColors() {
        return (ColorStateList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mHintTextColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.130 -0400", hash_original_method = "1826756F3CA2F0D97D555C81DC90D9D1", hash_generated_method = "F256B11EA0687D3B5CB288C45F925C28")
    @DSModeled(DSC.SAFE)
    public final int getCurrentHintTextColor() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mHintTextColor != null ? mCurHintTextColor : mCurTextColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.130 -0400", hash_original_method = "9463279339C3C6EB304729CC6A96FD58", hash_generated_method = "2676E571A57F4E07B99BA8A690CCF048")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @android.view.RemotableViewMethod
    public final void setLinkTextColor(int color) {
        dsTaint.addTaint(color);
        mLinkTextColor = ColorStateList.valueOf(color);
        updateTextColors();
        // ---------- Original Method ----------
        //mLinkTextColor = ColorStateList.valueOf(color);
        //updateTextColors();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.130 -0400", hash_original_method = "9B67E7CBCE87C562841DDA31DA1BE653", hash_generated_method = "3ADDFED429D2167F10382152BE26BECA")
    @DSModeled(DSC.SAFE)
    public final void setLinkTextColor(ColorStateList colors) {
        dsTaint.addTaint(colors.dsTaint);
        updateTextColors();
        // ---------- Original Method ----------
        //mLinkTextColor = colors;
        //updateTextColors();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.130 -0400", hash_original_method = "3A49B90BEACC4CBB32A44A5B9C48739C", hash_generated_method = "A18BE2E8E1614C8E66742A7D06BAB4C7")
    @DSModeled(DSC.SAFE)
    public final ColorStateList getLinkTextColors() {
        return (ColorStateList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mLinkTextColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.130 -0400", hash_original_method = "AEAA45BF8B2B9C05CF6AA4E644080F44", hash_generated_method = "ACB9304F744B395545DAF76C5FEFA903")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setGravity(int gravity) {
        dsTaint.addTaint(gravity);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.130 -0400", hash_original_method = "80A4065F7A7EA77AF4C4ADD19E36F9A5", hash_generated_method = "B36E983EF0539DE2797EC970A15D4977")
    @DSModeled(DSC.SAFE)
    public int getGravity() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mGravity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.130 -0400", hash_original_method = "7C7AF1B698E75A76793B55FAC07B7AAB", hash_generated_method = "438EC7563CF8AEB72554D9110084E26C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPaintFlags() {
        int var1FCED777482D649D2D08ED31F26C7C02_1116231989 = (mTextPaint.getFlags());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTextPaint.getFlags();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.130 -0400", hash_original_method = "8002046373E96371B4D25FE3E547C1A2", hash_generated_method = "B3C001C00EE6D8F85DACAE7B98619056")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @android.view.RemotableViewMethod
    public void setPaintFlags(int flags) {
        dsTaint.addTaint(flags);
        {
            boolean var8072314ED7B1DF7B4CA975059BE6435F_234302933 = (mTextPaint.getFlags() != flags);
            {
                mTextPaint.setFlags(flags);
                {
                    nullLayouts();
                    requestLayout();
                    invalidate();
                } //End block
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.130 -0400", hash_original_method = "EA5DCBED1A48E34EEA6259FD93E64EB0", hash_generated_method = "77E5F1E97DAEC053D4417BA536A95C42")
    @DSModeled(DSC.SAFE)
    public void setHorizontallyScrolling(boolean whether) {
        dsTaint.addTaint(whether);
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.130 -0400", hash_original_method = "7B94D421E91473A8A956329EBDF6A0E9", hash_generated_method = "439217B77A6963397486EFE3F81BF3BF")
    @DSModeled(DSC.SAFE)
    public boolean getHorizontallyScrolling() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mHorizontallyScrolling;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.130 -0400", hash_original_method = "0EE7081F083B0DC579019805442C8765", hash_generated_method = "4D88B9F09E3FE625AAC0B9DC540BFC30")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public void setMinLines(int minlines) {
        dsTaint.addTaint(minlines);
        mMinMode = LINES;
        requestLayout();
        invalidate();
        // ---------- Original Method ----------
        //mMinimum = minlines;
        //mMinMode = LINES;
        //requestLayout();
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.130 -0400", hash_original_method = "68757877A1DD20E33F15DE32FA3B7F07", hash_generated_method = "B2AACF0E81D97130C7CC9EEE5EAC7202")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public void setMinHeight(int minHeight) {
        dsTaint.addTaint(minHeight);
        mMinMode = PIXELS;
        requestLayout();
        invalidate();
        // ---------- Original Method ----------
        //mMinimum = minHeight;
        //mMinMode = PIXELS;
        //requestLayout();
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.131 -0400", hash_original_method = "8B36C1E1F9FD83BB5DA2A8A03A7A6664", hash_generated_method = "E2215AE51312468CED75AFDACCB6B635")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public void setMaxLines(int maxlines) {
        dsTaint.addTaint(maxlines);
        mMaxMode = LINES;
        requestLayout();
        invalidate();
        // ---------- Original Method ----------
        //mMaximum = maxlines;
        //mMaxMode = LINES;
        //requestLayout();
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.131 -0400", hash_original_method = "04C4C22BF9024D43E2A856D219B26DEF", hash_generated_method = "20625BC1C172F5EF6B5C0E5759463F3D")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public void setMaxHeight(int maxHeight) {
        dsTaint.addTaint(maxHeight);
        mMaxMode = PIXELS;
        requestLayout();
        invalidate();
        // ---------- Original Method ----------
        //mMaximum = maxHeight;
        //mMaxMode = PIXELS;
        //requestLayout();
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.131 -0400", hash_original_method = "1ADF089518552DEF85C429E373D0543D", hash_generated_method = "42BEE4DB29FB28B19B0530FC150E6C38")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public void setLines(int lines) {
        dsTaint.addTaint(lines);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.131 -0400", hash_original_method = "6CD9B04ABBE9A4E392854E2FFBA64155", hash_generated_method = "A92AF55224C0F0F936AFDDF792C318DC")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public void setHeight(int pixels) {
        dsTaint.addTaint(pixels);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.131 -0400", hash_original_method = "6EF109AA0B8A98B265CEDBFE77B13F24", hash_generated_method = "FE41C4206161B33E447144FCB7AD28DD")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public void setMinEms(int minems) {
        dsTaint.addTaint(minems);
        mMinWidthMode = EMS;
        requestLayout();
        invalidate();
        // ---------- Original Method ----------
        //mMinWidth = minems;
        //mMinWidthMode = EMS;
        //requestLayout();
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.131 -0400", hash_original_method = "CC5034BC1B28BBCD01B0947E11300CEA", hash_generated_method = "EEDF6753B3C1A84836CDF8AFC6E5E101")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public void setMinWidth(int minpixels) {
        dsTaint.addTaint(minpixels);
        mMinWidthMode = PIXELS;
        requestLayout();
        invalidate();
        // ---------- Original Method ----------
        //mMinWidth = minpixels;
        //mMinWidthMode = PIXELS;
        //requestLayout();
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.131 -0400", hash_original_method = "024C424B12C855A76B8C4D4EF37E56E9", hash_generated_method = "778D31E94449C020D715245C958048DB")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public void setMaxEms(int maxems) {
        dsTaint.addTaint(maxems);
        mMaxWidthMode = EMS;
        requestLayout();
        invalidate();
        // ---------- Original Method ----------
        //mMaxWidth = maxems;
        //mMaxWidthMode = EMS;
        //requestLayout();
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.131 -0400", hash_original_method = "66D27E295E9935EDB856E68754ECCF50", hash_generated_method = "33E511C44FA98912CC503B46E6485CCE")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public void setMaxWidth(int maxpixels) {
        dsTaint.addTaint(maxpixels);
        mMaxWidthMode = PIXELS;
        requestLayout();
        invalidate();
        // ---------- Original Method ----------
        //mMaxWidth = maxpixels;
        //mMaxWidthMode = PIXELS;
        //requestLayout();
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.131 -0400", hash_original_method = "29184B32707510663C7CC00A1776202A", hash_generated_method = "D70ECB2DE5C3EC746AF1D89D435BDC6C")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public void setEms(int ems) {
        dsTaint.addTaint(ems);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.131 -0400", hash_original_method = "A6A8746AE8743344ECC9244BF17B5285", hash_generated_method = "2F16FFAD252B6747D89DAB629861FBF2")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public void setWidth(int pixels) {
        dsTaint.addTaint(pixels);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.131 -0400", hash_original_method = "9D5DCCC1076394887EA3B21F5DF8F706", hash_generated_method = "4C568E775DF85F6401DCF5F975B37A7A")
    @DSModeled(DSC.SAFE)
    public void setLineSpacing(float add, float mult) {
        dsTaint.addTaint(mult);
        dsTaint.addTaint(add);
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.132 -0400", hash_original_method = "699FFD9CCBE3B133871A47DAD4072321", hash_generated_method = "785814ADA51926E75846E892BA62C207")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void append(CharSequence text) {
        dsTaint.addTaint(text);
        append(text, 0, text.length());
        // ---------- Original Method ----------
        //append(text, 0, text.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.132 -0400", hash_original_method = "B2621C1C8DC7A6B197F310747926C024", hash_generated_method = "D6F794A6C1512A4485BEF269FA5C0AC1")
    @DSModeled(DSC.SAFE)
    public void append(CharSequence text, int start, int end) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.132 -0400", hash_original_method = "ADC7043537742A0A0C5E53BD45A182BE", hash_generated_method = "B3622C010B64804B92FB1C00A598D786")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
                boolean var945E40D0ED79B723BC035DCD3A98AEB6_1001817680 = (color != mCurHintTextColor && mText.length() == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.132 -0400", hash_original_method = "3E3CC8861E854C1E6B450E5CB8D8974F", hash_generated_method = "BE4A943B0EA953B41D7187254BF15751")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        {
            boolean varF38C62369483FE4C64EC61B6DD68F7F8_943525557 = (mTextColor != null && mTextColor.isStateful()
                || (mHintTextColor != null && mHintTextColor.isStateful())
                || (mLinkTextColor != null && mLinkTextColor.isStateful()));
            {
                updateTextColors();
            } //End block
        } //End collapsed parenthetic
        final Drawables dr;
        dr = mDrawables;
        {
            int[] state;
            state = getDrawableState();
            {
                boolean varACD1486C54959F8A8C53C39EC3474E1F_356775102 = (dr.mDrawableTop != null && dr.mDrawableTop.isStateful());
                {
                    dr.mDrawableTop.setState(state);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var75A7C8EBF3DB0CE7B23F457B9BBE81BE_2107024280 = (dr.mDrawableBottom != null && dr.mDrawableBottom.isStateful());
                {
                    dr.mDrawableBottom.setState(state);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var351650CF2FFB93A328E0FCD6DD1DB2A5_1553451487 = (dr.mDrawableLeft != null && dr.mDrawableLeft.isStateful());
                {
                    dr.mDrawableLeft.setState(state);
                } //End block
            } //End collapsed parenthetic
            {
                boolean varD9BDE0148E482F4604F5C34A36FCFF7F_1663627713 = (dr.mDrawableRight != null && dr.mDrawableRight.isStateful());
                {
                    dr.mDrawableRight.setState(state);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var324017722E1CA9DC15695D4422A8ADEC_283503219 = (dr.mDrawableStart != null && dr.mDrawableStart.isStateful());
                {
                    dr.mDrawableStart.setState(state);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var6C06DB7410AEA6854519536D78FF530C_924043567 = (dr.mDrawableEnd != null && dr.mDrawableEnd.isStateful());
                {
                    dr.mDrawableEnd.setState(state);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.132 -0400", hash_original_method = "AF2C3EA4891B79A54157B80D9A5CB454", hash_generated_method = "A333D7E9A30C1C166AFB6D51C05D1518")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
                    ChangeWatcher cw = sp.getSpans(0, sp.length(), ChangeWatcher.class)[0];
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
                boolean var7B30392DD0636DC4945382169DDF5396_782102164 = (isFocused() && start >= 0 && end >= 0);
                {
                    ss.frozenWithFocus = true;
                } //End block
            } //End collapsed parenthetic
            ss.error = mError;
        } //End block
        return (Parcelable)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.133 -0400", hash_original_method = "F2FC1C379415C0983647E04C4964FB91", hash_generated_method = "4168F286184876784EC2873AAF97EF57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void removeMisspelledSpans(Spannable spannable) {
        dsTaint.addTaint(spannable.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.133 -0400", hash_original_method = "F50E2D5CE86BF5E6A61BC8360971F12F", hash_generated_method = "F779BCDD48CF2888C1DF1D879B53B66A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(state.dsTaint);
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
            final CharSequence error;
            error = ss.error;
            post(new Runnable() {
                public void run() {
                    setError(error);
                }
            });
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.133 -0400", hash_original_method = "73E23EE9831A5ABB45118C6D9D08B19B", hash_generated_method = "A6B85C781E6514DCE00262F368F4BBA7")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public void setFreezesText(boolean freezesText) {
        dsTaint.addTaint(freezesText);
        // ---------- Original Method ----------
        //mFreezesText = freezesText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.133 -0400", hash_original_method = "8E3F839ECE8B91BC1C15216DAAE76890", hash_generated_method = "F81EB9BBDF5D5B6C7055F1B3B0727DD6")
    @DSModeled(DSC.SAFE)
    public boolean getFreezesText() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFreezesText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.133 -0400", hash_original_method = "72071F64A960BCDF8628E8519218C076", hash_generated_method = "A63721822798465BBEA6DDF104672EB6")
    @DSModeled(DSC.SAFE)
    public final void setEditableFactory(Editable.Factory factory) {
        dsTaint.addTaint(factory.dsTaint);
        setText(mText);
        // ---------- Original Method ----------
        //mEditableFactory = factory;
        //setText(mText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.133 -0400", hash_original_method = "EE70434E54240A6008C9D2EA9B017339", hash_generated_method = "8CA98296AD89E47F6EC98EA125658341")
    @DSModeled(DSC.SAFE)
    public final void setSpannableFactory(Spannable.Factory factory) {
        dsTaint.addTaint(factory.dsTaint);
        setText(mText);
        // ---------- Original Method ----------
        //mSpannableFactory = factory;
        //setText(mText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.133 -0400", hash_original_method = "F37C8918E495A353D909855BE6AEA0B3", hash_generated_method = "42798EC8012B435C6A041C42858440E1")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public final void setText(CharSequence text) {
        dsTaint.addTaint(text);
        setText(text, mBufferType);
        // ---------- Original Method ----------
        //setText(text, mBufferType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.133 -0400", hash_original_method = "8D1404A47F965A96F115CE2D4080AFCB", hash_generated_method = "EC6E41EC8F876897CC755926B99A34BE")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public final void setTextKeepState(CharSequence text) {
        dsTaint.addTaint(text);
        setTextKeepState(text, mBufferType);
        // ---------- Original Method ----------
        //setTextKeepState(text, mBufferType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.133 -0400", hash_original_method = "607651EBB019EF2524713C89A6A4FC8C", hash_generated_method = "4948E8B91CC578CA67A1F6396950B6BF")
    @DSModeled(DSC.SAFE)
    public void setText(CharSequence text, BufferType type) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(type.dsTaint);
        setText(text, type, true, 0);
        {
            mCharWrapper.mChars = null;
        } //End block
        // ---------- Original Method ----------
        //setText(text, type, true, 0);
        //if (mCharWrapper != null) {
            //mCharWrapper.mChars = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.134 -0400", hash_original_method = "EBAE4ED74D570AD4FF310073DD3BF4E5", hash_generated_method = "0097B955A50F2FD00837E1BFA3861F4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setText(CharSequence text, BufferType type,
                         boolean notifyBefore, int oldlen) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(notifyBefore);
        dsTaint.addTaint(type.dsTaint);
        dsTaint.addTaint(oldlen);
        {
            text = "";
        } //End block
        {
            boolean var39C938BA181442FDC10CD6D971F0DA0A_634466424 = (!isSuggestionsEnabled());
            {
                text = removeSuggestionSpans(text);
            } //End block
        } //End collapsed parenthetic
        mTextPaint.setTextScaleX(1.0f);
        {
            boolean var61457476FF8B912C20F73CBD6BFFF2E9_1778092371 = (text instanceof Spanned &&
            ((Spanned) text).getSpanStart(TextUtils.TruncateAt.MARQUEE) >= 0);
            {
                {
                    boolean varA499503C31DDA8FD1F6C5109B7E818B8_913538393 = (ViewConfiguration.get(mContext).isFadingMarqueeEnabled());
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
            boolean var1E59861D1519785A5B1D3AA4CF100E2E_1543135020 = (mListeners != null && mListeners.size() != 0);
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
                boolean var97F4E593FAFDDCB3DADB34B707ECC3A4_1833582910 = (Linkify.addLinks(s2, mAutoLinkMask));
                {
                    text = s2;
                    type = (type == BufferType.EDITABLE) ? BufferType.EDITABLE : BufferType.SPANNABLE;
                    {
                        boolean var397E1740E7A0A45470AA95146AAA2DB6_202727838 = (mLinksClickable && !textCanBeSelected());
                        {
                            setMovementMethod(LinkMovementMethod.getInstance());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            mTransformed = mTransformation.getTransformation(text, this);
        } //End block
        final int textLength;
        textLength = text.length();
        {
            Spannable sp;
            sp = (Spannable) text;
            final ChangeWatcher[] watchers;
            watchers = sp.getSpans(0, sp.length(), ChangeWatcher.class);
            final int count;
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.134 -0400", hash_original_method = "36BFF315CD4AAC9D68E14477979C2AB5", hash_generated_method = "B0E1C577C515B92C4E7E14BD4879199F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setText(char[] text, int start, int len) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(len);
        int oldlen;
        oldlen = 0;
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IndexOutOfBoundsException(start + ", " + len);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.134 -0400", hash_original_method = "9AF748BA799D545173D512FE98AE91A8", hash_generated_method = "96676A0FD76178B58B131A233E88FEF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setTextKeepState(CharSequence text, BufferType type) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(type.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.135 -0400", hash_original_method = "F67FB9F700F5516CACC8B84E46FAB678", hash_generated_method = "3DDC28935F9F0425E683F7BC1B8F588A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @android.view.RemotableViewMethod
    public final void setText(int resid) {
        dsTaint.addTaint(resid);
        setText(getContext().getResources().getText(resid));
        // ---------- Original Method ----------
        //setText(getContext().getResources().getText(resid));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.135 -0400", hash_original_method = "A59BD645A347EA39C4147D9E24C2BE1F", hash_generated_method = "B2E6D2EA5D09CFF3B8655D327FF9F859")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setText(int resid, BufferType type) {
        dsTaint.addTaint(resid);
        dsTaint.addTaint(type.dsTaint);
        setText(getContext().getResources().getText(resid), type);
        // ---------- Original Method ----------
        //setText(getContext().getResources().getText(resid), type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.135 -0400", hash_original_method = "E428F8CA5E03E5225CDDDB51AA0FFAC9", hash_generated_method = "50C8992746C08FE6D9A73ED40F974149")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @android.view.RemotableViewMethod
    public final void setHint(CharSequence hint) {
        dsTaint.addTaint(hint);
        mHint = TextUtils.stringOrSpannedString(hint);
        {
            checkForRelayout();
        } //End block
        {
            boolean varC3772D22FF7A469D7982AA256079D67D_345483254 = (mText.length() == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.135 -0400", hash_original_method = "38FC4DBAEFB265C97233FE4F28F668E7", hash_generated_method = "F2E8C012B79FD87BEA1A6C3957D355AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @android.view.RemotableViewMethod
    public final void setHint(int resid) {
        dsTaint.addTaint(resid);
        setHint(getContext().getResources().getText(resid));
        // ---------- Original Method ----------
        //setHint(getContext().getResources().getText(resid));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.135 -0400", hash_original_method = "B545FCA8809064A694F5A37F99B0BBF1", hash_generated_method = "9F4921FF7921AD62FD82754607769197")
    @DSModeled(DSC.SAFE)
    @ViewDebug.CapturedViewProperty
    public CharSequence getHint() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mHint;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.135 -0400", hash_original_method = "CF798DBA236922C7D3F20B562F3C113C", hash_generated_method = "6EB0B365903FFEA482F4C4B0A27940DE")
    private static boolean isMultilineInputType(int type) {
        return (type & (EditorInfo.TYPE_MASK_CLASS | EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE)) ==
            (EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.135 -0400", hash_original_method = "49514C27E12484581D1021562BB6B56C", hash_generated_method = "92A12BF4D726B83B3946EE48F553136B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setInputType(int type) {
        dsTaint.addTaint(type);
        final boolean wasPassword;
        wasPassword = isPasswordInputType(mInputType);
        final boolean wasVisiblePassword;
        wasVisiblePassword = isVisiblePasswordInputType(mInputType);
        setInputType(type, false);
        final boolean isPassword;
        isPassword = isPasswordInputType(type);
        final boolean isVisiblePassword;
        isVisiblePassword = isVisiblePasswordInputType(type);
        boolean forceUpdate;
        forceUpdate = false;
        {
            setTransformationMethod(PasswordTransformationMethod.getInstance());
            setTypefaceByIndex(MONOSPACE, 0);
        } //End block
        {
            {
                boolean var8E3893E4544969EB4AD418651F643506_669312517 = (mTransformation == PasswordTransformationMethod.getInstance());
                {
                    forceUpdate = true;
                } //End block
            } //End collapsed parenthetic
            setTypefaceByIndex(MONOSPACE, 0);
        } //End block
        {
            setTypefaceByIndex(-1, -1);
            {
                boolean var8E3893E4544969EB4AD418651F643506_1330190853 = (mTransformation == PasswordTransformationMethod.getInstance());
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
            boolean var39C938BA181442FDC10CD6D971F0DA0A_140647600 = (!isSuggestionsEnabled());
            {
                mText = removeSuggestionSpans(mText);
            } //End block
        } //End collapsed parenthetic
        InputMethodManager imm;
        imm = InputMethodManager.peekInstance();
        imm.restartInput(this);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.135 -0400", hash_original_method = "103CDD92E42BC521C8FE05F02491D14C", hash_generated_method = "291752BBC8A02A59FB8D6DA4616F8C3F")
    @DSModeled(DSC.SAFE)
    private boolean hasPasswordTransformationMethod() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mTransformation instanceof PasswordTransformationMethod;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.135 -0400", hash_original_method = "E0A9182B87E4303FDDF2B8B7ED0929E4", hash_generated_method = "FC94ED4940EE725651B02473EC2D27D2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.135 -0400", hash_original_method = "184D7B00FEDEC84189B51C8F1682F683", hash_generated_method = "40626CA272A26BF73AE4224D8B70099C")
    private static boolean isVisiblePasswordInputType(int inputType) {
        final int variation =
                inputType & (EditorInfo.TYPE_MASK_CLASS | EditorInfo.TYPE_MASK_VARIATION);
        return variation
                == (EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.135 -0400", hash_original_method = "5561319FE52E5BCF6B9F27794140DEB3", hash_generated_method = "A36ACC1F1235CB85A11AAC09A8D6695E")
    @DSModeled(DSC.SAFE)
    public void setRawInputType(int type) {
        dsTaint.addTaint(type);
        // ---------- Original Method ----------
        //mInputType = type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.136 -0400", hash_original_method = "95BF8AE0F4607DDA852256E0031089E3", hash_generated_method = "D6FED7AB7F678244EF91ADF5309A22AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setInputType(int type, boolean direct) {
        dsTaint.addTaint(direct);
        dsTaint.addTaint(type);
        final int cls;
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.136 -0400", hash_original_method = "CC20F62DEC3871662808940856B4AD97", hash_generated_method = "B6DCC78D31034474EFD5E94C78B3E4DC")
    @DSModeled(DSC.SAFE)
    public int getInputType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mInputType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.136 -0400", hash_original_method = "15D43244184C7971E001BEB05B105E77", hash_generated_method = "14DEAD769EC1D6B6E01F21DD366FFFB9")
    @DSModeled(DSC.SAFE)
    public void setImeOptions(int imeOptions) {
        dsTaint.addTaint(imeOptions);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.136 -0400", hash_original_method = "2B64657558FBAC5C9C7E6BDC8C1A3258", hash_generated_method = "B472D44A16082F23E06C4FB7C345258C")
    @DSModeled(DSC.SAFE)
    public int getImeOptions() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mInputContentType != null
                //? mInputContentType.imeOptions : EditorInfo.IME_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.136 -0400", hash_original_method = "1A4477F3225C39150F0F3FBD7557F91B", hash_generated_method = "1E95D7D422716EF33EF3B80FBC9EE791")
    @DSModeled(DSC.SAFE)
    public void setImeActionLabel(CharSequence label, int actionId) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(label);
        dsTaint.addTaint(actionId);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.136 -0400", hash_original_method = "A4E3D8286D59E9D4715BBC467F3D8808", hash_generated_method = "A4A273B43F3FEF20CAAFCA7444D75E51")
    @DSModeled(DSC.SAFE)
    public CharSequence getImeActionLabel() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mInputContentType != null
                //? mInputContentType.imeActionLabel : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.136 -0400", hash_original_method = "4B4E4CA7604BFFF08B66F520F2D9A667", hash_generated_method = "370F095809329D181C49DF6A6FEF51BD")
    @DSModeled(DSC.SAFE)
    public int getImeActionId() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mInputContentType != null
                //? mInputContentType.imeActionId : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.136 -0400", hash_original_method = "46DFB908E4A3870151F9CA120300C85B", hash_generated_method = "E07BBF730B8233DFAAC46422186BC743")
    @DSModeled(DSC.SAFE)
    public void setOnEditorActionListener(OnEditorActionListener l) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(l.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.137 -0400", hash_original_method = "0518018E7AD402CBF7FDAFFEA66C2B57", hash_generated_method = "6CB66B76FFD18DFD0280EEA350ABE52F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onEditorAction(int actionCode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(actionCode);
        final InputContentType ict;
        ict = mInputContentType;
        {
            {
                {
                    boolean varC6096D11527A2336F0603C550DF9620B_1837754375 = (ict.onEditorActionListener.onEditorAction(this,
                        actionCode, null));
                } //End collapsed parenthetic
            } //End block
            {
                View v;
                v = focusSearch(FOCUS_FORWARD);
                {
                    {
                        boolean var1C5B6BCE2F4451CCE5A9C33B9CF3E849_203955520 = (!v.requestFocus(FOCUS_FORWARD));
				        if (DroidSafeAndroidRuntime.control)
                        {
                            throw new IllegalStateException("focus search returned a view " +
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
                        boolean varF90963F65450DE26E78172A72D4AE61B_736023970 = (!v.requestFocus(FOCUS_BACKWARD));
				        if (DroidSafeAndroidRuntime.control)
                        {
                            throw new IllegalStateException("focus search returned a view " +
                                "that wasn't able to take focus!");
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            {
                InputMethodManager imm;
                imm = InputMethodManager.peekInstance();
                {
                    boolean var4FA09E363AF255ACFA7DE6A3A2C1C773_1833011536 = (imm != null && imm.isActive(this));
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.137 -0400", hash_original_method = "E93C7F3F4C0717B4FFE77CC972CA5ABA", hash_generated_method = "87D2FCE8E91242FB7072DD675917A644")
    @DSModeled(DSC.SAFE)
    public void setPrivateImeOptions(String type) {
        dsTaint.addTaint(type);
        mInputContentType = new InputContentType();
        mInputContentType.privateImeOptions = type;
        // ---------- Original Method ----------
        //if (mInputContentType == null) mInputContentType = new InputContentType();
        //mInputContentType.privateImeOptions = type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.137 -0400", hash_original_method = "92B56934BB38E74A857D4D87A23CFEBD", hash_generated_method = "27F33C6C3152D133B1D154FA4D9D9CE3")
    @DSModeled(DSC.SAFE)
    public String getPrivateImeOptions() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mInputContentType != null
                //? mInputContentType.privateImeOptions : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.137 -0400", hash_original_method = "4D2957EAEB6AF33B1C49D1AAB860E441", hash_generated_method = "35355BD158A477C2B58481AA959E347B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setInputExtras(int xmlResId) throws XmlPullParserException, IOException {
        dsTaint.addTaint(xmlResId);
        XmlResourceParser parser;
        parser = getResources().getXml(xmlResId);
        mInputContentType = new InputContentType();
        mInputContentType.extras = new Bundle();
        getResources().parseBundleExtras(parser, mInputContentType.extras);
        // ---------- Original Method ----------
        //XmlResourceParser parser = getResources().getXml(xmlResId);
        //if (mInputContentType == null) mInputContentType = new InputContentType();
        //mInputContentType.extras = new Bundle();
        //getResources().parseBundleExtras(parser, mInputContentType.extras);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.137 -0400", hash_original_method = "3CCBAE1ACA56EC727CC56362E5EC99DC", hash_generated_method = "58372EC3A52820E2870D0320A864E8EA")
    @DSModeled(DSC.SAFE)
    public Bundle getInputExtras(boolean create) {
        dsTaint.addTaint(create);
        {
            mInputContentType = new InputContentType();
        } //End block
        {
            mInputContentType.extras = new Bundle();
        } //End block
        return (Bundle)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.137 -0400", hash_original_method = "9A980CBEBB946A11C624D95D8D1017B2", hash_generated_method = "8602D33A9C48A71E60FC1A99A19D7E2E")
    @DSModeled(DSC.SAFE)
    public CharSequence getError() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mError;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.137 -0400", hash_original_method = "D7457C91A83A908A8309ED29F602BDCA", hash_generated_method = "36D14F6133A38954D7B99060CFF1A004")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @android.view.RemotableViewMethod
    public void setError(CharSequence error) {
        dsTaint.addTaint(error);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.138 -0400", hash_original_method = "A707A7C4B74C4D669C69114C0D73A7BA", hash_generated_method = "236DC79FE8058B479DA7E5D968E3FCAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setError(CharSequence error, Drawable icon) {
        dsTaint.addTaint(icon.dsTaint);
        dsTaint.addTaint(error);
        error = TextUtils.stringOrSpannedString(error);
        mErrorWasChanged = true;
        final Drawables dr;
        dr = mDrawables;
        {
            {
                Object var9F1D8BFC1663434C04073ED5C9ABAE03_2137900331 = (getResolvedLayoutDirection());
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
                    boolean var4EAD5BA12B52AD8D73AFD9224AD88B47_1050729340 = (mPopup.isShowing());
                    {
                        mPopup.dismiss();
                    } //End block
                } //End collapsed parenthetic
                mPopup = null;
            } //End block
        } //End block
        {
            {
                boolean var98C1250B21329AE579A768A5FB60FE48_2072963656 = (isFocused());
                {
                    showError();
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.138 -0400", hash_original_method = "691606EEB666F38CF8433096C671CCBD", hash_generated_method = "94FEE2C719D19454E4A1336CF668E42C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void showError() {
        {
            boolean varFF25C8C36D549896D247167EFDFCA86E_2141759609 = (getWindowToken() == null);
            {
                mShowErrorAfterAttach = true;
            } //End block
        } //End collapsed parenthetic
        {
            LayoutInflater inflater;
            inflater = LayoutInflater.from(getContext());
            final TextView err;
            err = (TextView) inflater.inflate(
                    com.android.internal.R.layout.textview_hint, null);
            final float scale;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.138 -0400", hash_original_method = "193E855DAAE9F0495F7DD2501E8046B7", hash_generated_method = "6437CAF5ED7354157558D4F33A381B66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getErrorX() {
        final float scale;
        scale = getResources().getDisplayMetrics().density;
        final Drawables dr;
        dr = mDrawables;
        int var5CC39021D81A29A88ABF707530C095B6_1487204772 = (getWidth() - mPopup.getWidth() - getPaddingRight() -
                (dr != null ? dr.mDrawableSizeRight : 0) / 2 + (int) (25 * scale + 0.5f)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final float scale = getResources().getDisplayMetrics().density;
        //final Drawables dr = mDrawables;
        //return getWidth() - mPopup.getWidth() - getPaddingRight() -
                //(dr != null ? dr.mDrawableSizeRight : 0) / 2 + (int) (25 * scale + 0.5f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.138 -0400", hash_original_method = "AEF78C4F5C84BB7DCAE783FBA8691257", hash_generated_method = "857A9E4A8DE3356791E574D6D334B887")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getErrorY() {
        final int compoundPaddingTop;
        compoundPaddingTop = getCompoundPaddingTop();
        int vspace;
        vspace = mBottom - mTop - getCompoundPaddingBottom() - compoundPaddingTop;
        final Drawables dr;
        dr = mDrawables;
        int icontop;
        icontop = compoundPaddingTop +
                (vspace - (dr != null ? dr.mDrawableHeightRight : 0)) / 2;//DSFIXME:  CODE0008: Nested ternary operator in expression
        final float scale;
        scale = getResources().getDisplayMetrics().density;
        int var003746F0616F92D98A8FCB729FE8B13B_2138526491 = (icontop + (dr != null ? dr.mDrawableHeightRight : 0) - getHeight() -
                (int) (2 * scale + 0.5f)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.138 -0400", hash_original_method = "F599686205634A1B40098A399108C287", hash_generated_method = "1F5514A78132415C051C0D281833B692")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void hideError() {
        {
            {
                boolean var064AFD47A2F0375BD3A49E11623DCB44_1845630759 = (mPopup.isShowing());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.139 -0400", hash_original_method = "E776865F48A57A0CE6F068EC64FA9769", hash_generated_method = "6F8F8DB195A27D41C7CBF21998E95660")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void chooseSize(PopupWindow pop, CharSequence text, TextView tv) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(tv.dsTaint);
        dsTaint.addTaint(pop.dsTaint);
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
            boolean var042843EFDE50DED9CF686A63F696B025_565640117 = (i < l.getLineCount());
            {
                max = Math.max(max, l.getLineWidth(i));
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.139 -0400", hash_original_method = "5914A6C90CD99156CDEB55240C7F0CC3", hash_generated_method = "BE61D5E24F3CDD2D36351A72AADD4F69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean setFrame(int l, int t, int r, int b) {
        dsTaint.addTaint(t);
        dsTaint.addTaint(b);
        dsTaint.addTaint(r);
        dsTaint.addTaint(l);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.139 -0400", hash_original_method = "F008D6FB8FE5770ECA7C6E535BB409D7", hash_generated_method = "386EC7AE8DE80FBB5EC3F2E194B1B7AD")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.139 -0400", hash_original_method = "BC1716C27CAAB9B1A5BA926037A5041B", hash_generated_method = "2945FCEAEBB4880FD07B5B8796B33D6B")
    @DSModeled(DSC.SAFE)
    public void setFilters(InputFilter[] filters) {
        dsTaint.addTaint(filters[0].dsTaint);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IllegalArgumentException();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.139 -0400", hash_original_method = "48C3B4A6108D00EDE1CFE79059C5E0E2", hash_generated_method = "ECAB60EFE4D6F44DF1F1502A298FEE87")
    @DSModeled(DSC.SAFE)
    private void setFilters(Editable e, InputFilter[] filters) {
        dsTaint.addTaint(e.dsTaint);
        dsTaint.addTaint(filters[0].dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.139 -0400", hash_original_method = "E0010D0DD1DD8F03E408AEE972028B3D", hash_generated_method = "72517622107523BEB7D841862EFB75D0")
    @DSModeled(DSC.SAFE)
    public InputFilter[] getFilters() {
        return (InputFilter[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mFilters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.139 -0400", hash_original_method = "DAA92D774C652EE383E55D96FD59260D", hash_generated_method = "4B8BC5A9351DAA827840509878A27EEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getVerticalOffset(boolean forceNormal) {
        dsTaint.addTaint(forceNormal);
        int voffset;
        voffset = 0;
        final int gravity;
        gravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
        Layout l;
        l = mLayout;
        {
            boolean varD5DF217776FEC14CA244AC2CD8EE62D0_839280394 = (!forceNormal && mText.length() == 0 && mHintLayout != null);
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.139 -0400", hash_original_method = "FA4757416C7C28BA09CF9D290B4D7551", hash_generated_method = "385ED33C66EEF3944CBADFAD05AF1053")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getBottomVerticalOffset(boolean forceNormal) {
        dsTaint.addTaint(forceNormal);
        int voffset;
        voffset = 0;
        final int gravity;
        gravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
        Layout l;
        l = mLayout;
        {
            boolean varD5DF217776FEC14CA244AC2CD8EE62D0_363931482 = (!forceNormal && mText.length() == 0 && mHintLayout != null);
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.140 -0400", hash_original_method = "53216DF5147B6AD3B10E93427C42A87D", hash_generated_method = "307D0F79089C716DA85AC223017F9AD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void invalidateCursorPath() {
        {
            invalidateCursor();
        } //End block
        {
            final int horizontalPadding;
            horizontalPadding = getCompoundPaddingLeft();
            final int verticalPadding;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.140 -0400", hash_original_method = "18CF38FA770F258E57001CEB5008E4BD", hash_generated_method = "56C19C92D73EE084CA2F1EF1E08BD0F6")
    @DSModeled(DSC.SAFE)
    private void invalidateCursor() {
        int where;
        where = getSelectionEnd();
        invalidateCursor(where, where, where);
        // ---------- Original Method ----------
        //int where = getSelectionEnd();
        //invalidateCursor(where, where, where);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.140 -0400", hash_original_method = "7C61928A88071E487AF3987FA1C70EFA", hash_generated_method = "3BBA6AA3D60F5E90773A0884F2CEC682")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void invalidateCursor(int a, int b, int c) {
        dsTaint.addTaint(b);
        dsTaint.addTaint(c);
        dsTaint.addTaint(a);
        {
            int start;
            start = Math.min(Math.min(a, b), c);
            int end;
            end = Math.max(Math.max(a, b), c);
            invalidateRegion(start, end, true );
        } //End block
        // ---------- Original Method ----------
        //if (a >= 0 || b >= 0 || c >= 0) {
            //int start = Math.min(Math.min(a, b), c);
            //int end = Math.max(Math.max(a, b), c);
            //invalidateRegion(start, end, true );
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.140 -0400", hash_original_method = "D9CEA3E6F10B2E8340E14518563D9425", hash_generated_method = "2251F57F2AB8CCE207AAEE0995E1DAAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void invalidateRegion(int start, int end, boolean invalidateCursor) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(invalidateCursor);
        dsTaint.addTaint(end);
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
            final int compoundPaddingLeft;
            compoundPaddingLeft = getCompoundPaddingLeft();
            final int verticalPadding;
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.140 -0400", hash_original_method = "14444C10F141ED0D65415BFE9043EE15", hash_generated_method = "E8AEDE9A3E45B8F108AA1F22E8A1F69F")
    @DSModeled(DSC.SAFE)
    private void registerForPreDraw() {
        final ViewTreeObserver observer;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.140 -0400", hash_original_method = "7ED99206FCCA4C828A375B5616572C0F", hash_generated_method = "A60FC4565052F55594EA0C88C3E739B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
                boolean var12D57A2CE148B359BC68B232D2B7DC8F_1579118601 = (mSelectionModifierCursorController != null &&
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
            boolean varA5CB988193F65A0949A8B845CF954A56_1186476342 = (this instanceof ExtractEditText && hasSelection());
            {
                startSelectionActionMode();
            } //End block
        } //End collapsed parenthetic
        mPreDrawState = PREDRAW_DONE;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.141 -0400", hash_original_method = "37A00D47E5792B2A68D22343089CAC73", hash_generated_method = "640FC4D234A2FE1965D9E59B240BEDE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAttachedToWindow();
        mTemporaryDetach = false;
        {
            showError();
            mShowErrorAfterAttach = false;
        } //End block
        final ViewTreeObserver observer;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.141 -0400", hash_original_method = "16099E9CBA4D38D7973AB46B58716911", hash_generated_method = "CE741C16B97D9C14D402002F8651B689")
    @DSModeled(DSC.SAFE)
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDetachedFromWindow();
        final ViewTreeObserver observer;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.141 -0400", hash_original_method = "F9485E7598554FF005152B05BE66332E", hash_generated_method = "03CF7474D396AD927CE9E7DD0BD69294")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean isPaddingOffsetRequired() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mShadowRadius != 0 || mDrawables != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.141 -0400", hash_original_method = "7F5FAD56D372BFDBD8919382F1DF4F10", hash_generated_method = "D014F0C15066268D3E0AC61C5626D705")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int getLeftPaddingOffset() {
        int var58C5EE75D3D1900953AF755581344C8A_1826894968 = (getCompoundPaddingLeft() - mPaddingLeft +
                (int) Math.min(0, mShadowDx - mShadowRadius));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getCompoundPaddingLeft() - mPaddingLeft +
                //(int) Math.min(0, mShadowDx - mShadowRadius);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.141 -0400", hash_original_method = "BBBA34DDC8A574B01D58B3AC0235EEFE", hash_generated_method = "B5AD5CC8F0D977520C357CFCC3D75151")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int getTopPaddingOffset() {
        int var0ED6224353BB97F3F21905FBACD93DCB_638072421 = ((int) Math.min(0, mShadowDy - mShadowRadius));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (int) Math.min(0, mShadowDy - mShadowRadius);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.141 -0400", hash_original_method = "2F5480661817CC97DFDD529692B7CB6A", hash_generated_method = "6C24535CBF4F52D6CFEBA9A7AB550DDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int getBottomPaddingOffset() {
        int varB10121B4D3A3118F0C573D58A81C1C32_1785405508 = ((int) Math.max(0, mShadowDy + mShadowRadius));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (int) Math.max(0, mShadowDy + mShadowRadius);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.141 -0400", hash_original_method = "03B94E40D261DCBBD1910980153D8E7A", hash_generated_method = "783911B8E950767662930EF78E6DA149")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int getRightPaddingOffset() {
        int var513406E75DBEDB7AB1D4B061E88F3D83_2025443006 = (-(getCompoundPaddingRight() - mPaddingRight) +
                (int) Math.max(0, mShadowDx + mShadowRadius));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return -(getCompoundPaddingRight() - mPaddingRight) +
                //(int) Math.max(0, mShadowDx + mShadowRadius);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.141 -0400", hash_original_method = "CE928B829998126087759CE89BCD7C50", hash_generated_method = "B91FD5FAF8D3F63111560634F76CB934")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean verifyDrawable(Drawable who) {
        dsTaint.addTaint(who.dsTaint);
        final boolean verified;
        verified = super.verifyDrawable(who);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final boolean verified = super.verifyDrawable(who);
        //if (!verified && mDrawables != null) {
            //return who == mDrawables.mDrawableLeft || who == mDrawables.mDrawableTop ||
                    //who == mDrawables.mDrawableRight || who == mDrawables.mDrawableBottom ||
                    //who == mDrawables.mDrawableStart || who == mDrawables.mDrawableEnd;
        //}
        //return verified;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.141 -0400", hash_original_method = "40478AC632904F83B590338EFFF77EC4", hash_generated_method = "00398E2BA6F635936BEFD6C61F762C30")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.142 -0400", hash_original_method = "BFAA7AB246AB7FE030F8E5E06E7C4938", hash_generated_method = "C96329F4EF920049A3BC0F05D98F1632")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void invalidateDrawable(Drawable drawable) {
        dsTaint.addTaint(drawable.dsTaint);
        {
            boolean var6429BFA2CE72B3A4B0873DE16CAD3D14_429471091 = (verifyDrawable(drawable));
            {
                final Rect dirty;
                dirty = drawable.getBounds();
                int scrollX;
                scrollX = mScrollX;
                int scrollY;
                scrollY = mScrollY;
                final TextView.Drawables drawables;
                drawables = mDrawables;
                {
                    {
                        final int compoundPaddingTop;
                        compoundPaddingTop = getCompoundPaddingTop();
                        final int compoundPaddingBottom;
                        compoundPaddingBottom = getCompoundPaddingBottom();
                        final int vspace;
                        vspace = mBottom - mTop - compoundPaddingBottom - compoundPaddingTop;
                        scrollX += mPaddingLeft;
                        scrollY += compoundPaddingTop + (vspace - drawables.mDrawableHeightLeft) / 2;
                    } //End block
                    {
                        final int compoundPaddingTop;
                        compoundPaddingTop = getCompoundPaddingTop();
                        final int compoundPaddingBottom;
                        compoundPaddingBottom = getCompoundPaddingBottom();
                        final int vspace;
                        vspace = mBottom - mTop - compoundPaddingBottom - compoundPaddingTop;
                        scrollX += (mRight - mLeft - mPaddingRight - drawables.mDrawableSizeRight);
                        scrollY += compoundPaddingTop + (vspace - drawables.mDrawableHeightRight) / 2;
                    } //End block
                    {
                        final int compoundPaddingLeft;
                        compoundPaddingLeft = getCompoundPaddingLeft();
                        final int compoundPaddingRight;
                        compoundPaddingRight = getCompoundPaddingRight();
                        final int hspace;
                        hspace = mRight - mLeft - compoundPaddingRight - compoundPaddingLeft;
                        scrollX += compoundPaddingLeft + (hspace - drawables.mDrawableWidthTop) / 2;
                        scrollY += mPaddingTop;
                    } //End block
                    {
                        final int compoundPaddingLeft;
                        compoundPaddingLeft = getCompoundPaddingLeft();
                        final int compoundPaddingRight;
                        compoundPaddingRight = getCompoundPaddingRight();
                        final int hspace;
                        hspace = mRight - mLeft - compoundPaddingRight - compoundPaddingLeft;
                        scrollX += compoundPaddingLeft + (hspace - drawables.mDrawableWidthBottom) / 2;
                        scrollY += (mBottom - mTop - mPaddingBottom - drawables.mDrawableSizeBottom);
                    } //End block
                } //End block
                invalidate(dirty.left + scrollX, dirty.top + scrollY,
                    dirty.right + scrollX, dirty.bottom + scrollY);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.142 -0400", hash_original_method = "365B978F98464E672BAE2334EE130C56", hash_generated_method = "FFBF3C4C6D769B55CA1EC556F42425D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getResolvedLayoutDirection(Drawable who) {
        dsTaint.addTaint(who.dsTaint);
        {
            final Drawables drawables;
            drawables = mDrawables;
            {
                int var9F1D8BFC1663434C04073ED5C9ABAE03_633483701 = (getResolvedLayoutDirection());
            } //End block
        } //End block
        int varC2F7741B418937D0E08C7C868777F70A_1381393949 = (super.getResolvedLayoutDirection(who));
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.142 -0400", hash_original_method = "361EEEB4229AF287B326C983EB9B20B0", hash_generated_method = "FC29E572BFF1FA88BB747F3FE2AFF7BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean onSetAlpha(int alpha) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(alpha);
        {
            boolean varF9737FBB3FA84CB9364E87D929DD087B_84680287 = (getBackground() == null);
            {
                final Drawables dr;
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.142 -0400", hash_original_method = "CB6193FD8EC60616857FED31421868C5", hash_generated_method = "5ED078AA3AB496853D19E40E61118A9D")
    @DSModeled(DSC.SAFE)
    public boolean isTextSelectable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mTextIsSelectable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.142 -0400", hash_original_method = "F5356B5CDB0C54713C7C3659E2E49BDB", hash_generated_method = "AB5DF6801AAC17EEA672247AA39F95BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTextIsSelectable(boolean selectable) {
        dsTaint.addTaint(selectable);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.143 -0400", hash_original_method = "E327CCF4B590DA515951F33B48F8FD2D", hash_generated_method = "2D05EFAE4111B581DC295895BC8F56A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(extraSpace);
        /* final */ int[] drawableState;
        {
            drawableState = super.onCreateDrawableState(extraSpace);
        } //End block
        {
            drawableState = super.onCreateDrawableState(extraSpace + 1);
            mergeDrawableStates(drawableState, MULTILINE_STATE_SET);
        } //End block
        {
            final int length;
            length = drawableState.length;
            {
                int i;
                i = 0;
                {
                    {
                        final int[] nonPressedState;
                        nonPressedState = new int[length - 1];
                        System.arraycopy(drawableState, 0, nonPressedState, 0, i);
                        System.arraycopy(drawableState, i + 1, nonPressedState, i, length - i - 1);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        int[] retVal = new int[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.144 -0400", hash_original_method = "FA11BA597CA3990806012CD62CCA6F49", hash_generated_method = "C51EB1457C82DE4CE04B5545A71B85F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(canvas.dsTaint);
        {
            final ViewTreeObserver observer;
            observer = getViewTreeObserver();
            observer.removeOnPreDrawListener(this);
            mPreDrawState = PREDRAW_NOT_REGISTERED;
        } //End block
        restartMarqueeIfNeeded();
        super.onDraw(canvas);
        final int compoundPaddingLeft;
        compoundPaddingLeft = getCompoundPaddingLeft();
        final int compoundPaddingTop;
        compoundPaddingTop = getCompoundPaddingTop();
        final int compoundPaddingRight;
        compoundPaddingRight = getCompoundPaddingRight();
        final int compoundPaddingBottom;
        compoundPaddingBottom = getCompoundPaddingBottom();
        final int scrollX;
        scrollX = mScrollX;
        final int scrollY;
        scrollY = mScrollY;
        final int right;
        right = mRight;
        final int left;
        left = mLeft;
        final int bottom;
        bottom = mBottom;
        final int top;
        top = mTop;
        final Drawables dr;
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
            boolean var316D35E2F5ECBA0973BB7AA3F3D5BB99_1488620874 = (mHint != null && mText.length() == 0);
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
        final int layoutDirection;
        layoutDirection = getResolvedLayoutDirection();
        final int absoluteGravity;
        absoluteGravity = Gravity.getAbsoluteGravity(mGravity, layoutDirection);
        {
            {
                boolean varECABE171DF753EC9B7649613B9CE32E8_1930861547 = (!mSingleLine && getLineCount() == 1 && canMarquee() &&
                    (absoluteGravity & Gravity.HORIZONTAL_GRAVITY_MASK) != Gravity.LEFT);
                {
                    canvas.translate(mLayout.getLineRight(0) - (mRight - mLeft -
                        getCompoundPaddingLeft() - getCompoundPaddingRight()), 0.0f);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var2C1AA9C80F2908423E5F4CFC350F7281_1952824706 = (mMarquee != null && mMarquee.isRunning());
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
            boolean var6689D80642F8609001A87CC7FE23D763_1732594191 = (mMovement != null && (isFocused() || isPressed()));
            {
                selStart = getSelectionStart();
                selEnd = getSelectionEnd();
                {
                    mHighlightPath = new Path();
                    {
                        {
                            boolean varC70ECF1643A49D8E64E841F8740CC733_993181417 = (isCursorVisible() &&
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
                        boolean varD2470F8649BF231BDB682780036CA3E1_394690984 = (textCanBeSelected());
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
        final InputMethodState ims;
        ims = mInputMethodState;
        final int cursorOffsetVertical;
        cursorOffsetVertical = voffsetCursor - voffsetText;
        {
            InputMethodManager imm;
            imm = InputMethodManager.peekInstance();
            {
                {
                    boolean varCD832678EBF561BEF5C67C864ED57D5D_1328555533 = (imm.isActive(this));
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
                    boolean varDFBBC9A1B31B7114329F69A82B5D3704_1888168917 = (imm.isWatchingCursor(this) && highlight != null);
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
            boolean var6C9C7A2601C4C103D29484E050BD6314_847439730 = (mMarquee != null && mMarquee.shouldDrawGhost());
            {
                canvas.translate((int) mMarquee.getGhostOffset(), 0.0f);
                layout.draw(canvas, highlight, mHighlightPaint, cursorOffsetVertical);
            } //End block
        } //End collapsed parenthetic
        canvas.restore();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.144 -0400", hash_original_method = "78F759649DF9DADE7AC797D0043ECB32", hash_generated_method = "80EBFEDEA004F5177683B8A6B02DA005")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateCursorsPositions() {
        {
            mCursorCount = 0;
        } //End block
        final int offset;
        offset = getSelectionStart();
        final int line;
        line = mLayout.getLineForOffset(offset);
        final int top;
        top = mLayout.getLineTop(line);
        final int bottom;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.145 -0400", hash_original_method = "E19C5E504E793D85568DEA288EC3BB71", hash_generated_method = "6A2EBB95DA2767BD43AFB69ECE5D6C65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateCursorPosition(int cursorIndex, int top, int bottom, float horizontal) {
        dsTaint.addTaint(cursorIndex);
        dsTaint.addTaint(horizontal);
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(top);
        mCursorDrawable[cursorIndex] = mContext.getResources().getDrawable(mCursorDrawableRes);
        mTempRect = new Rect();
        mCursorDrawable[cursorIndex].getPadding(mTempRect);
        final int width;
        width = mCursorDrawable[cursorIndex].getIntrinsicWidth();
        horizontal = Math.max(0.5f, horizontal - 0.5f);
        final int left;
        left = (int) (horizontal) - mTempRect.left;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.145 -0400", hash_original_method = "38A0E9FCBE0DF4E61FBA21D6958F939A", hash_generated_method = "64B9F5A88E145DA81FBD65197F120D4A")
    @DSModeled(DSC.SAFE)
    private void drawCursor(Canvas canvas, int cursorOffsetVertical) {
        dsTaint.addTaint(canvas.dsTaint);
        dsTaint.addTaint(cursorOffsetVertical);
        final boolean translate;
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
        // ---------- Original Method ----------
        //final boolean translate = cursorOffsetVertical != 0;
        //if (translate) canvas.translate(0, cursorOffsetVertical);
        //for (int i = 0; i < mCursorCount; i++) {
            //mCursorDrawable[i].draw(canvas);
        //}
        //if (translate) canvas.translate(0, -cursorOffsetVertical);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.145 -0400", hash_original_method = "9AB167D6C4B117BDFB6C2B72A1D862B5", hash_generated_method = "D3D5FA6D962DF865064DC1179966E443")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void getFocusedRect(Rect r) {
        dsTaint.addTaint(r.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.145 -0400", hash_original_method = "97BE8C8E19AAF13DDBB7397BA8716CD7", hash_generated_method = "F95D252F1753F075F7173081CE83B832")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLineCount() {
        {
            Object varD975483664E4A2ABD3BE6A7FE00BEAE4_1509921976 = (mLayout.getLineCount());
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLayout != null ? mLayout.getLineCount() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.145 -0400", hash_original_method = "C119BED798B9C2A141229B29A4C86BDD", hash_generated_method = "39E83B18A53772667B71A9B42ADA163E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLineBounds(int line, Rect bounds) {
        dsTaint.addTaint(bounds.dsTaint);
        dsTaint.addTaint(line);
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.146 -0400", hash_original_method = "3C56831CF91C4818C48A7DCC6043867F", hash_generated_method = "12F97D2F06B069521FD00E1E521E14A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getBaseline() {
        {
            int varEC5F70FA49520212A319ACA653FC0209_801241517 = (super.getBaseline());
        } //End block
        int voffset;
        voffset = 0;
        {
            voffset = getVerticalOffset(true);
        } //End block
        int varB40014DBFC3B8DB0A96D34443E0FBB7F_673559972 = (getExtendedPaddingTop() + voffset + mLayout.getLineBaseline(0));
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.146 -0400", hash_original_method = "9B40D92CA2D66C315619C6CA13460A4B", hash_generated_method = "7EC9A339979C760291E92DD06955D0EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int getFadeTop(boolean offsetRequired) {
        dsTaint.addTaint(offsetRequired);
        int voffset;
        voffset = 0;
        {
            voffset = getVerticalOffset(true);
        } //End block
        voffset += getTopPaddingOffset();
        int var96B16999098121B80A3E9BC63992503B_721301774 = (getExtendedPaddingTop() + voffset);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mLayout == null) return 0;
        //int voffset = 0;
        //if ((mGravity & Gravity.VERTICAL_GRAVITY_MASK) != Gravity.TOP) {
            //voffset = getVerticalOffset(true);
        //}
        //if (offsetRequired) voffset += getTopPaddingOffset();
        //return getExtendedPaddingTop() + voffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.146 -0400", hash_original_method = "4B4E36AF8D516BA2309E720A4535DE33", hash_generated_method = "B355EBCD413631D085AC3AA3081B8A17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int getFadeHeight(boolean offsetRequired) {
        dsTaint.addTaint(offsetRequired);
        {
            Object var1822177AD24E1DAE2984AAF8E0B02DF5_1509828333 = (mLayout.getHeight());
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLayout != null ? mLayout.getHeight() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.146 -0400", hash_original_method = "D780B8C0D740C935BBFD0FE1FAA345B5", hash_generated_method = "497F46B1A935701A76C208FAE020386A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        {
            boolean isInSelectionMode;
            isInSelectionMode = mSelectionActionMode != null;
            {
                {
                    boolean var51947D54DEEA690F1B41A17DE6323711_1062036247 = (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0);
                    {
                        KeyEvent.DispatcherState state;
                        state = getKeyDispatcherState();
                        {
                            state.startTracking(event, this);
                        } //End block
                    } //End block
                    {
                        boolean varA6D964A9D1A4D1D485BD8D60F2BFCDEE_201132904 = (event.getAction() == KeyEvent.ACTION_UP);
                        {
                            KeyEvent.DispatcherState state;
                            state = getKeyDispatcherState();
                            {
                                state.handleUpEvent(event);
                            } //End block
                            {
                                boolean varBE09C907F92D135687297C67489D82A5_878048142 = (event.isTracking() && !event.isCanceled());
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
        boolean var84A59BF21652B099F795A333EE25717D_125591071 = (super.onKeyPreIme(keyCode, event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.146 -0400", hash_original_method = "34FB4F2A2A6D04958B0CB574357346B4", hash_generated_method = "039B5BCB786940235980F9CB7F047443")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        int which;
        which = doKeyDown(keyCode, event, null);
        {
            boolean varF37828D47239888646D0D534C127ED8C_743341490 = (super.onKeyDown(keyCode, event));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int which = doKeyDown(keyCode, event, null);
        //if (which == 0) {
            //return super.onKeyDown(keyCode, event);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.146 -0400", hash_original_method = "29E1D0F837CE3120BC9F0CF834D8CD7B", hash_generated_method = "BC86565AEABF973BC7C24C36703A9F82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(repeatCount);
        KeyEvent down;
        down = KeyEvent.changeAction(event, KeyEvent.ACTION_DOWN);
        int which;
        which = doKeyDown(keyCode, down, event);
        {
            boolean varDC1E2957B5A61BDC225D3800F9D03961_1096554109 = (super.onKeyMultiple(keyCode, repeatCount, event));
        } //End block
        repeatCount--;
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.147 -0400", hash_original_method = "F8A8C23B2901B68727EC4DCE05389523", hash_generated_method = "1C16624B992FFAEE1BD5BFF1157ACB8E")
    @DSModeled(DSC.SAFE)
    private boolean shouldAdvanceFocusOnEnter() {
        {
            int variation;
            variation = mInputType & EditorInfo.TYPE_MASK_VARIATION;
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.147 -0400", hash_original_method = "3820039215BEB2B783682B0606CB8390", hash_generated_method = "5E58748FCE141C4C7D3A9D0C8A6D4505")
    @DSModeled(DSC.SAFE)
    private boolean shouldAdvanceFocusOnTab() {
        {
            {
                int variation;
                variation = mInputType & EditorInfo.TYPE_MASK_VARIATION;
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.147 -0400", hash_original_method = "06C558A5D7DCBFD0B9ED82B9C331F1F3", hash_generated_method = "1B84F4D3C35B27D98534629A0348739D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int doKeyDown(int keyCode, KeyEvent event, KeyEvent otherEvent) {
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(otherEvent.dsTaint);
        {
            boolean varC378F7D9F83769944CF2ACC662A4EAE3_1124817110 = (!isEnabled());
        } //End collapsed parenthetic
        //Begin case KeyEvent.KEYCODE_ENTER 
        {
            boolean var6A2352E2C5239DCC8C3CFCEB22E8E32E_2112998336 = (event.hasNoModifiers());
            {
                {
                    {
                        boolean var1D94CC9EA7F6DC2AEFBF8FBA8E934A5F_2143630671 = (mInputContentType.onEditorActionListener != null &&
                                mInputContentType.onEditorActionListener.onEditorAction(
                                this, EditorInfo.IME_NULL, event));
                        {
                            mInputContentType.enterDown = true;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var05FC5A78E345546917334D934F323222_1694321071 = ((event.getFlags() & KeyEvent.FLAG_EDITOR_ACTION) != 0
                            || shouldAdvanceFocusOnEnter());
                    {
                        {
                            boolean var272B07794F8FB9CA178BF9284513CEF1_2143713553 = (hasOnClickListeners());
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        //End case KeyEvent.KEYCODE_ENTER 
        //Begin case KeyEvent.KEYCODE_DPAD_CENTER 
        {
            boolean var6A2352E2C5239DCC8C3CFCEB22E8E32E_1925628007 = (event.hasNoModifiers());
            {
                {
                    boolean varB57504F668DBD47828E53D1AA62D2476_435653036 = (shouldAdvanceFocusOnEnter());
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        //End case KeyEvent.KEYCODE_DPAD_CENTER 
        //Begin case KeyEvent.KEYCODE_TAB 
        {
            boolean var41B4248114FD3FFF5603132EE2379F75_1990223090 = (event.hasNoModifiers() || event.hasModifiers(KeyEvent.META_SHIFT_ON));
            {
                {
                    boolean var4CB07B26821EBD1E83E544AE45714F5A_698657828 = (shouldAdvanceFocusOnTab());
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
                    final boolean handled;
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
                final boolean handled;
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
                    boolean var899D769AE8C1CEA63FDF2F946CDD9B0C_51080775 = (mMovement.onKeyDown(this, (Spannable)mText, keyCode, event));
                } //End collapsed parenthetic
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.147 -0400", hash_original_method = "7246AB9167FB26EEC2DE7F4C0B385BF5", hash_generated_method = "CFB4E9D4EC1CA542E651DBBFB79BB094")
    @DSModeled(DSC.SAFE)
    public void resetErrorChangedFlag() {
        mErrorWasChanged = false;
        // ---------- Original Method ----------
        //mErrorWasChanged = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.147 -0400", hash_original_method = "0D0DD73869C4F453DDB81949A9BAE239", hash_generated_method = "8E1A00471066CB78A5882A4DA37385DC")
    @DSModeled(DSC.SAFE)
    public void hideErrorIfUnchanged() {
        {
            setError(null, null);
        } //End block
        // ---------- Original Method ----------
        //if (mError != null && !mErrorWasChanged) {
            //setError(null, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.148 -0400", hash_original_method = "5424E0BE647EA73439DA25EAE2FC3B50", hash_generated_method = "23E14183052A26FEA22C2DAF6A8B8872")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        {
            boolean varC378F7D9F83769944CF2ACC662A4EAE3_206578436 = (!isEnabled());
            {
                boolean var22F2FED66C108E4B3C1571CD2DEF9BD7_1757974857 = (super.onKeyUp(keyCode, event));
            } //End block
        } //End collapsed parenthetic
        //Begin case KeyEvent.KEYCODE_DPAD_CENTER 
        {
            boolean var6A2352E2C5239DCC8C3CFCEB22E8E32E_1358725890 = (event.hasNoModifiers());
            {
                {
                    boolean var210C7F5CA56C3EC36E879FBFEDD09928_806262697 = (!hasOnClickListeners());
                    {
                        {
                            boolean varE74AE2A246DD26B137F541368B4BE791_549112371 = (mMovement != null && mText instanceof Editable
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
        boolean varEDD771EBF66425AD21882AB08CD0EE48_2109429736 = (super.onKeyUp(keyCode, event));
        //End case KeyEvent.KEYCODE_DPAD_CENTER 
        //Begin case KeyEvent.KEYCODE_ENTER 
        {
            boolean var6A2352E2C5239DCC8C3CFCEB22E8E32E_92460253 = (event.hasNoModifiers());
            {
                {
                    mInputContentType.enterDown = false;
                    {
                        boolean varFB4D8364BD486E8AC15C78086C055D0E_1958037276 = (mInputContentType.onEditorActionListener.onEditorAction(
                                this, EditorInfo.IME_NULL, event));
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var05FC5A78E345546917334D934F323222_1299230991 = ((event.getFlags() & KeyEvent.FLAG_EDITOR_ACTION) != 0
                            || shouldAdvanceFocusOnEnter());
                    {
                        {
                            boolean varEDA239B0EF60ED2C8B069E42FB575E6D_2132774612 = (!hasOnClickListeners());
                            {
                                View v;
                                v = focusSearch(FOCUS_DOWN);
                                {
                                    {
                                        boolean varB999DF15E9AF0E3270EE4B72A3F644C2_1218251048 = (!v.requestFocus(FOCUS_DOWN));
                                        if (DroidSafeAndroidRuntime.control)
                                        {
                                            throw new IllegalStateException(
                                            "focus search returned a view " +
                                            "that wasn't able to take focus!");
                                        } //End block
                                    } //End collapsed parenthetic
                                    super.onKeyUp(keyCode, event);
                                } //End block
                                {
                                    boolean var28FD9F71D61E7F2DAF140411AD18D69B_53160315 = ((event.getFlags()
                                    & KeyEvent.FLAG_EDITOR_ACTION) != 0);
                                    {
                                        InputMethodManager imm;
                                        imm = InputMethodManager.peekInstance();
                                        {
                                            boolean var18AFA631B94FB215076105938165749C_28238257 = (imm != null && imm.isActive(this));
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
                boolean var22F2FED66C108E4B3C1571CD2DEF9BD7_545834679 = (super.onKeyUp(keyCode, event));
            } //End block
        } //End collapsed parenthetic
        //End case KeyEvent.KEYCODE_ENTER 
        {
            boolean var952AD4616936F2C47880365DAADE02E9_1370834170 = (mInput.onKeyUp(this, (Editable) mText, keyCode, event));
        } //End collapsed parenthetic
        {
            boolean varDA972FE6CE2955659F74CF0FCCBDD027_491029950 = (mMovement.onKeyUp(this, (Spannable) mText, keyCode, event));
        } //End collapsed parenthetic
        boolean varEDD771EBF66425AD21882AB08CD0EE48_614136180 = (super.onKeyUp(keyCode, event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.148 -0400", hash_original_method = "71F7C8422E0B6AB59261F7E112139F7A", hash_generated_method = "CEAEA811378297635753782577893791")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean onCheckIsTextEditor() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mInputType != EditorInfo.TYPE_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.148 -0400", hash_original_method = "B65AC544FAB392A4E417298C2021FD9E", hash_generated_method = "F66A9B31291B23E2FAEA06185888907D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(outAttrs.dsTaint);
        {
            boolean var14E748864EBD1D56528D6630F011C9F4_1940826576 = (onCheckIsTextEditor() && isEnabled());
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
                    boolean var4A83C13B10866AEA8D3AB0257DD13346_559140002 = (focusSearch(FOCUS_DOWN) != null);
                    {
                        outAttrs.imeOptions |= EditorInfo.IME_FLAG_NAVIGATE_NEXT;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varD336D5944BC7007368BBB4D990F0F8EA_778666136 = (focusSearch(FOCUS_UP) != null);
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
                        boolean var46380488EEE32CF6F78CFB4D43E28058_1065958016 = (!shouldAdvanceFocusOnEnter());
                        {
                            outAttrs.imeOptions |= EditorInfo.IME_FLAG_NO_ENTER_ACTION;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var6CF4D9D9DC3252829459B4AC99D1E1CE_226150557 = (isMultilineInputType(outAttrs.inputType));
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
                } //End block
            } //End block
        } //End collapsed parenthetic
        return (InputConnection)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.149 -0400", hash_original_method = "99984EBDDEABE6A84A830C32C2411508", hash_generated_method = "E187F74163BF38FB923EA72A387172ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean extractText(ExtractedTextRequest request,
            ExtractedText outText) {
        dsTaint.addTaint(request.dsTaint);
        dsTaint.addTaint(outText.dsTaint);
        boolean varED261EE6A1DA9340DC710F511F735890_683858411 = (extractTextInternal(request, EXTRACT_UNKNOWN, EXTRACT_UNKNOWN,
                EXTRACT_UNKNOWN, outText));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return extractTextInternal(request, EXTRACT_UNKNOWN, EXTRACT_UNKNOWN,
                //EXTRACT_UNKNOWN, outText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.149 -0400", hash_original_method = "D5583180449515B28719DEEF8D226179", hash_generated_method = "857650AB477CD7B2F21D059311F9B9B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean extractTextInternal(ExtractedTextRequest request,
            int partialStartOffset, int partialEndOffset, int delta,
            ExtractedText outText) {
        dsTaint.addTaint(partialStartOffset);
        dsTaint.addTaint(partialEndOffset);
        dsTaint.addTaint(request.dsTaint);
        dsTaint.addTaint(delta);
        dsTaint.addTaint(outText.dsTaint);
        final CharSequence content;
        content = mText;
        {
            {
                final int N;
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
                            i--;
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
                boolean varA35D3A020D07691CB25122C024188410_1389605448 = (MetaKeyKeyListener.getMetaState(mText, MetaKeyKeyListener.META_SELECTING) != 0);
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.149 -0400", hash_original_method = "E0B2F563BD380D089394FF3F6A004FAB", hash_generated_method = "E9560825E576A3A4FF905B047D6295F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean reportExtractedText() {
        final InputMethodState ims;
        ims = mInputMethodState;
        {
            final boolean contentChanged;
            contentChanged = ims.mContentChanged;
            {
                ims.mContentChanged = false;
                ims.mSelectionModeChanged = false;
                final ExtractedTextRequest req;
                req = mInputMethodState.mExtracting;
                {
                    InputMethodManager imm;
                    imm = InputMethodManager.peekInstance();
                    {
                        {
                            ims.mChangedStart = EXTRACT_NOTHING;
                        } //End block
                        {
                            boolean varF32A83F45BD97D2740B78BFB41050619_1998912804 = (extractTextInternal(req, ims.mChangedStart, ims.mChangedEnd,
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.149 -0400", hash_original_method = "19B083F16A9E6F8D7C9301AD2E77499E", hash_generated_method = "84E0D74E88344C70AC04251A53043A8C")
    static void removeParcelableSpans(Spannable spannable, int start, int end) {
        Object[] spans = spannable.getSpans(start, end, ParcelableSpan.class);
        int i = spans.length;
        while (i > 0) {
            i--;
            spannable.removeSpan(spans[i]);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.150 -0400", hash_original_method = "BCA6F941081EC35E5D75ECC5825A5773", hash_generated_method = "7515BA001ADE71CFD38CA6624D0387D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setExtractedText(ExtractedText text) {
        dsTaint.addTaint(text.dsTaint);
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
                final int N;
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
        final int N;
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.154 -0400", hash_original_method = "7277A5A8CCC47DEA1B4CD7EF17ABC767", hash_generated_method = "F7EECE2BF8DA1B52D00C963AB3EF694A")
    @DSModeled(DSC.SAFE)
    public void setExtracting(ExtractedTextRequest req) {
        dsTaint.addTaint(req.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.154 -0400", hash_original_method = "00B2156ECAED706F16E8F8EE554C74A0", hash_generated_method = "7ED7E98E0AF9FDD98E633A616A71E495")
    @DSModeled(DSC.SAFE)
    public void onCommitCompletion(CompletionInfo text) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(text.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.154 -0400", hash_original_method = "F0F3377304175B47C81480C4E8ACCA98", hash_generated_method = "00D0E0E8EB765FB2960C943C63433ECA")
    @DSModeled(DSC.SAFE)
    public void onCommitCorrection(CorrectionInfo info) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(info.dsTaint);
        {
            mCorrectionHighlighter = new CorrectionHighlighter();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.154 -0400", hash_original_method = "7E84F411EBAFCA8676D2B5471CC899F7", hash_generated_method = "32772779D13FFED3AE64BEA379C629EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void beginBatchEdit() {
        mInBatchEditControllers = true;
        final InputMethodState ims;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.154 -0400", hash_original_method = "53E9CEBDC3778C58F6F63CD77BA92C78", hash_generated_method = "CDFF56510AC64D8A26F1B3C09C843BB7")
    @DSModeled(DSC.SAFE)
    public void endBatchEdit() {
        mInBatchEditControllers = false;
        final InputMethodState ims;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.154 -0400", hash_original_method = "49FC9F53534FDBC4416EED2F953235D5", hash_generated_method = "3DA37BDB73E8FF25972132B6DCB56F6E")
    @DSModeled(DSC.SAFE)
     void ensureEndedBatchEdit() {
        final InputMethodState ims;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.155 -0400", hash_original_method = "5C56AEFFFAF99A5A2B83332AB2B67F77", hash_generated_method = "DAAB6A89728D1C590FE6297BD63EA5BB")
    @DSModeled(DSC.SAFE)
     void finishBatchEdit(final InputMethodState ims) {
        dsTaint.addTaint(ims.dsTaint);
        onEndBatchEdit();
        {
            updateAfterEdit();
            reportExtractedText();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.155 -0400", hash_original_method = "208D05A3FD324C57DA7FED31CDB936F2", hash_generated_method = "088D94A8E75B7DC325476B5DF611F70F")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.155 -0400", hash_original_method = "77FDC1BC2641DD2E3C25361410AF5DB0", hash_generated_method = "BABD032611396A879417AB280F9DEEE0")
    @DSModeled(DSC.SAFE)
    public void onBeginBatchEdit() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.155 -0400", hash_original_method = "52249F36F9A17EF1D72281B7699502C1", hash_generated_method = "3524F895FA7BC8483188AD0433D46CD3")
    @DSModeled(DSC.SAFE)
    public void onEndBatchEdit() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.155 -0400", hash_original_method = "4EBA5E538796A46420814B4C84FDA4F7", hash_generated_method = "91E92E985E03F615A6A9D04A5052F6A4")
    @DSModeled(DSC.SAFE)
    public boolean onPrivateIMECommand(String action, Bundle data) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(action);
        dsTaint.addTaint(data.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.155 -0400", hash_original_method = "4BBE7444811911981578CD1FC44D7898", hash_generated_method = "53A9471330ECAECA0240CE356AA6CCD5")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.155 -0400", hash_original_method = "DE76D8533357DD76552FFACD362B9B5D", hash_generated_method = "04C32FBAFA2DBDF532837A3B278D9E91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.155 -0400", hash_original_method = "FF379A6CAE0485B60E59F45E1B8A7246", hash_generated_method = "39EBDD67101F0FA0254DD11D44887C00")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.155 -0400", hash_original_method = "C784F6D37EB77044D77D743FABD50125", hash_generated_method = "E2937F17949F1F97AB9482F1DAB7A356")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Layout.Alignment getLayoutAlignment() {
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
        return (Layout.Alignment)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.156 -0400", hash_original_method = "A69555D5DBD727E4B4531FE7AB9727A4", hash_generated_method = "849919D55A70C4272C9ADF57F17E53E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void makeNewLayout(int wantWidth, int hintWidth,
                                 BoringLayout.Metrics boring,
                                 BoringLayout.Metrics hintBoring,
                                 int ellipsisWidth, boolean bringIntoView) {
        dsTaint.addTaint(bringIntoView);
        dsTaint.addTaint(hintBoring.dsTaint);
        dsTaint.addTaint(boring.dsTaint);
        dsTaint.addTaint(wantWidth);
        dsTaint.addTaint(hintWidth);
        dsTaint.addTaint(ellipsisWidth);
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
        final boolean switchEllipsize;
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
                boolean var74FA680CFF3550946DD695F927344B4C_336911445 = (!compressText(ellipsisWidth));
                {
                    final int height;
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.157 -0400", hash_original_method = "919E80CF27514D43AA0D66AD56F3C47B", hash_generated_method = "3A8F7D3FD27CC65ED224F8FB27449340")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Layout makeSingleLayout(int wantWidth, BoringLayout.Metrics boring, int ellipsisWidth,
            Layout.Alignment alignment, boolean shouldEllipsize, TruncateAt effectiveEllipsize,
            boolean useSaved) {
        dsTaint.addTaint(alignment.dsTaint);
        dsTaint.addTaint(boring.dsTaint);
        dsTaint.addTaint(shouldEllipsize);
        dsTaint.addTaint(useSaved);
        dsTaint.addTaint(effectiveEllipsize.dsTaint);
        dsTaint.addTaint(wantWidth);
        dsTaint.addTaint(ellipsisWidth);
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
        return (Layout)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.157 -0400", hash_original_method = "F38DBB61FA92C8376A0BF0DADC8F1411", hash_generated_method = "56549ACD22B1473D0DEAB4C144C4FABB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean compressText(float width) {
        dsTaint.addTaint(width);
        {
            boolean varBDA84146B1D9E3F7F12351B38C986FB8_1061184662 = (isHardwareAccelerated());
        } //End collapsed parenthetic
        {
            boolean var743F2FC0D45BA571C6484FE1669492A0_1298268417 = (width > 0.0f && mLayout != null && getLineCount() == 1 && !mUserSetTextScaleX &&
                mTextPaint.getTextScaleX() == 1.0f);
            {
                final float textWidth;
                textWidth = mLayout.getLineWidth(0);
                final float overflow;
                overflow = (textWidth + 1.0f - width) / width;
                {
                    mTextPaint.setTextScaleX(1.0f - overflow - 0.005f);
                    post(new Runnable() {
                    public void run() {
                        requestLayout();
                    }
                });
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.157 -0400", hash_original_method = "96CB246721D7A29D66FE7CD97D8BA203", hash_generated_method = "6E35653B22149AD608030C0BF7897C24")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.157 -0400", hash_original_method = "6C6FEB869E07EC14B89A3785CB4B2378", hash_generated_method = "C5291748C9E2892C34563931E1D54934")
    @DSModeled(DSC.SAFE)
    public void setIncludeFontPadding(boolean includepad) {
        dsTaint.addTaint(includepad);
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.158 -0400", hash_original_method = "CC856997CB919A81C5DE847B897CC56B", hash_generated_method = "3FA4C610ED7C512FE9DE078A36B79DF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(heightMeasureSpec);
        dsTaint.addTaint(widthMeasureSpec);
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
            final Drawables dr;
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
            final boolean layoutChanged;
            layoutChanged = (mLayout.getWidth() != want) ||
                    (hintWidth != hintWant) ||
                    (mLayout.getEllipsizedWidth() !=
                            width - getCompoundPaddingLeft() - getCompoundPaddingRight());
            final boolean widthChanged;
            widthChanged = (mHint == null) &&
                    (mEllipsize == null) &&
                    (want > mLayout.getWidth()) &&
                    (mLayout instanceof BoringLayout || (fromexisting && des >= 0 && des <= want));
            final boolean maximumChanged;
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
            boolean var3DB10CBFB12ED38DCBD3FB16EF151096_1839980547 = (mMaxMode == LINES && mLayout.getLineCount() > mMaximum);
            {
                unpaddedHeight = Math.min(unpaddedHeight, mLayout.getLineTop(mMaximum));
            } //End block
        } //End collapsed parenthetic
        {
            boolean varFFED0DDEAA53977A5F429726E600A8F2_1681688604 = (mMovement != null ||
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.158 -0400", hash_original_method = "94259D4548546EABDDB6F8414E37FA42", hash_generated_method = "9F676254835108C55C540CDA1ED63AB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getDesiredHeight() {
        int var2840A69C5B812317D9CA537C29691369_1494542165 = (Math.max(
                getDesiredHeight(mLayout, true),
                getDesiredHeight(mHintLayout, mEllipsize != null)));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Math.max(
                //getDesiredHeight(mLayout, true),
                //getDesiredHeight(mHintLayout, mEllipsize != null));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.158 -0400", hash_original_method = "7AA300272C545049E0340D139CA1349D", hash_generated_method = "F009311F6607B592A99B9DEDD1DD9E5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getDesiredHeight(Layout layout, boolean cap) {
        dsTaint.addTaint(cap);
        dsTaint.addTaint(layout.dsTaint);
        int linecount;
        linecount = layout.getLineCount();
        int pad;
        pad = getCompoundPaddingTop() + getCompoundPaddingBottom();
        int desired;
        desired = layout.getLineTop(linecount);
        final Drawables dr;
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.159 -0400", hash_original_method = "112907D8B10F62764352610BA7B79108", hash_generated_method = "E3A5FC44A6D7C63BF9876A9CF46D0385")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
                    boolean var76B417FEF15CB7997AEC250AB014098F_438084770 = (desiredHeight != this.getHeight());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.159 -0400", hash_original_method = "5832A71588E0ABA41180B589D326BF70", hash_generated_method = "D755A7A569DCD7B2AC11CB23059B9926")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkForRelayout() {
        {
            boolean var32BFD96E0546ED5F291DC663279A0815_1208861771 = ((mLayoutParams.width != LayoutParams.WRAP_CONTENT ||
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
                        boolean varE1571FB91561235A70F553E0D47B6412_849605004 = (mLayout.getHeight() == oldht &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.159 -0400", hash_original_method = "0DA3D6D28C1432B95D5D1B1B5DDB2BC8", hash_generated_method = "C8DC22F4097D858FBB46604680BED801")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.160 -0400", hash_original_method = "3C0DD43A95E696C7A1592341A7B2F740", hash_generated_method = "0749A139F83A78FC0BB990A4E0DDA087")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean bringPointIntoView(int offset) {
        dsTaint.addTaint(offset);
        boolean changed;
        changed = false;
        int line;
        line = mLayout.getLineForOffset(offset);
        final int x;
        x = (int)mLayout.getPrimaryHorizontal(offset);
        final int top;
        top = mLayout.getLineTop(line);
        final int bottom;
        bottom = mLayout.getLineTop(line + 1);
        int left;
        left = (int) FloatMath.floor(mLayout.getLineLeft(line));
        int right;
        right = (int) FloatMath.ceil(mLayout.getLineRight(line));
        int ht;
        ht = mLayout.getHeight();
        int grav;
        {
            Object var027910B290B59420177BD30BF1DDB958_153877688 = (mLayout.getParagraphAlignment(line));
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
                        boolean varD539631976251D8AA391F3162DE97B1C_1129729042 = (!mScroller.isFinished());
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
            boolean var1C23F183BE3EEE2A8667855A22865324_1976068824 = (isFocused());
            {
                mTempRect = new Rect();
                mTempRect.set(x - 2, top, x + 2, bottom);
                getInterestingRect(mTempRect, line);
                mTempRect.offset(mScrollX, mScrollY);
                {
                    boolean var5DD27CBBEE9D998C97ABDC1CFDA74333_11253568 = (requestRectangleOnScreen(mTempRect));
                    {
                        changed = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.161 -0400", hash_original_method = "02D4B7457672C459E287DBA1B16986EC", hash_generated_method = "2D6913FB75AF73935B8AF85E33B9F081")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean moveCursorToVisibleOffset() {
        int start;
        start = getSelectionStart();
        int end;
        end = getSelectionEnd();
        int line;
        line = mLayout.getLineForOffset(start);
        final int top;
        top = mLayout.getLineTop(line);
        final int bottom;
        bottom = mLayout.getLineTop(line + 1);
        final int vspace;
        vspace = mBottom - mTop - getExtendedPaddingTop() - getExtendedPaddingBottom();
        int vslack;
        vslack = (bottom - top) / 2;
        vslack = vspace / 4;
        final int vs;
        vs = mScrollY;
        {
            line = mLayout.getLineForVertical(vs+vslack+(bottom-top));
        } //End block
        {
            line = mLayout.getLineForVertical(vspace+vs-vslack-(bottom-top));
        } //End block
        /* final */ int hspace;
        hspace = mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight();
        /* final  */int hs;
        hs = mScrollX;
        /* final  */int leftChar;
        leftChar = mLayout.getOffsetForHorizontal(line, hs);
        /* final  */int rightChar;
        rightChar = mLayout.getOffsetForHorizontal(line, hspace+hs);
        /* final  */int lowChar;
        lowChar = leftChar;
        lowChar = rightChar;
        /* final  */int highChar;
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.161 -0400", hash_original_method = "D06313C44705A7887AB654B7CF5A74B3", hash_generated_method = "FA417AD9517145D2BBF75787774AD274")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void computeScroll() {
        {
            {
                boolean varD8983424724D79AFF92B0ED68CFEBCB5_501888602 = (mScroller.computeScrollOffset());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.161 -0400", hash_original_method = "ABFDC323272F3E6393D3C4F9B9F60889", hash_generated_method = "3248823DFF8733CAEF5FF9E5521931F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void getInterestingRect(Rect r, int line) {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(line);
        convertFromViewportToContentCoordinates(r);
        r.top -= getExtendedPaddingTop();
        {
            boolean var36B5761D6C0D25FD94548457569D0FDF_918562719 = (line == mLayout.getLineCount() - 1);
            r.bottom += getExtendedPaddingBottom();
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //convertFromViewportToContentCoordinates(r);
        //if (line == 0) r.top -= getExtendedPaddingTop();
        //if (line == mLayout.getLineCount() - 1) r.bottom += getExtendedPaddingBottom();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.161 -0400", hash_original_method = "D2E7C9E2773084F5B5BC96B85475267E", hash_generated_method = "E77A7D138B665DC2A3BF6100972AC3FF")
    @DSModeled(DSC.SAFE)
    private void convertFromViewportToContentCoordinates(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        final int horizontalOffset;
        horizontalOffset = viewportToContentHorizontalOffset();
        r.left += horizontalOffset;
        r.right += horizontalOffset;
        final int verticalOffset;
        verticalOffset = viewportToContentVerticalOffset();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.161 -0400", hash_original_method = "3DB802CF5F82AE3562BB26F896D07DB6", hash_generated_method = "709DEAB844C57A0F00CFF81C639E6266")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int viewportToContentHorizontalOffset() {
        int var094701FAECA9F0FDE06C5A96E63AF57B_1286727031 = (getCompoundPaddingLeft() - mScrollX);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getCompoundPaddingLeft() - mScrollX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.161 -0400", hash_original_method = "1E5AEDFCDEE7B994A62FE1D426BA9AAE", hash_generated_method = "61DE87DD83C2AF07E01F468831E31379")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int viewportToContentVerticalOffset() {
        int offset;
        offset = getExtendedPaddingTop() - mScrollY;
        {
            offset += getVerticalOffset(false);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int offset = getExtendedPaddingTop() - mScrollY;
        //if ((mGravity & Gravity.VERTICAL_GRAVITY_MASK) != Gravity.TOP) {
            //offset += getVerticalOffset(false);
        //}
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.161 -0400", hash_original_method = "7E6A70E8247BE9F0E1C3854BAECCAE99", hash_generated_method = "23BEFC463A5C4DB8A77E8C4F2611ECD6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void debug(int depth) {
        dsTaint.addTaint(depth);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.161 -0400", hash_original_method = "FC0380BF9D344F57087ADAA0F0C8C1E5", hash_generated_method = "24012FCDF9A98BC5DE4E8FBC1359F0F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @ViewDebug.ExportedProperty(category = "text")
    public int getSelectionStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int varB37ACFCDE0514D1AD6E7980466D0642F_260434894 = (Selection.getSelectionStart(getText()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Selection.getSelectionStart(getText());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.161 -0400", hash_original_method = "59139061668C8515BDA5938230C2D233", hash_generated_method = "3276E0E6E31F560038E895113422398B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @ViewDebug.ExportedProperty(category = "text")
    public int getSelectionEnd() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int var62647D48C20F4425C471C6DB7EC335FA_825565169 = (Selection.getSelectionEnd(getText()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Selection.getSelectionEnd(getText());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.162 -0400", hash_original_method = "BD52AC55F75FC20C70791ABE185D07B3", hash_generated_method = "8B2B93FB06468D6CDE04B7F4350340CC")
    @DSModeled(DSC.SAFE)
    public boolean hasSelection() {
        final int selectionStart;
        selectionStart = getSelectionStart();
        final int selectionEnd;
        selectionEnd = getSelectionEnd();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int selectionStart = getSelectionStart();
        //final int selectionEnd = getSelectionEnd();
        //return selectionStart >= 0 && selectionStart != selectionEnd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.162 -0400", hash_original_method = "08C77724BEA7FD604DDC056EC8AC0A85", hash_generated_method = "A3D8F6C3642FCF18D74296EFCC945E68")
    @DSModeled(DSC.SAFE)
    public void setSingleLine() {
        setSingleLine(true);
        // ---------- Original Method ----------
        //setSingleLine(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.162 -0400", hash_original_method = "02E25EABD0939EA349140FD704ABC4B2", hash_generated_method = "3D889E23FB38CD6E19C30A44FDF4EFDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAllCaps(boolean allCaps) {
        dsTaint.addTaint(allCaps);
        {
            setTransformationMethod(new AllCapsTransformationMethod(getContext()));
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.162 -0400", hash_original_method = "F67AECEDD15B73EEA4C7246A27A881B1", hash_generated_method = "ACDA794750907F1A4872501FD7FCFC82")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public void setSingleLine(boolean singleLine) {
        dsTaint.addTaint(singleLine);
        setInputTypeSingleLine(singleLine);
        applySingleLine(singleLine, true, true);
        // ---------- Original Method ----------
        //setInputTypeSingleLine(singleLine);
        //applySingleLine(singleLine, true, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.162 -0400", hash_original_method = "7606E2D7FCC52ECFF0946358CA46A596", hash_generated_method = "9E30756852806CFF08F95F590CD08AF6")
    @DSModeled(DSC.SAFE)
    private void setInputTypeSingleLine(boolean singleLine) {
        dsTaint.addTaint(singleLine);
        {
            {
                mInputType &= ~EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE;
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.162 -0400", hash_original_method = "939294E5BC9AAD2D1E9D05ACD8801E5C", hash_generated_method = "179FB82398E667D64B0C47601F78AD96")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void applySingleLine(boolean singleLine, boolean applyTransformation,
            boolean changeMaxLines) {
        dsTaint.addTaint(applyTransformation);
        dsTaint.addTaint(changeMaxLines);
        dsTaint.addTaint(singleLine);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.162 -0400", hash_original_method = "8F48F7BF1B8DCE5D5519F1200A0ED853", hash_generated_method = "1885B14DA9BC9AF54FC785030A4C060E")
    @DSModeled(DSC.SAFE)
    public void setEllipsize(TextUtils.TruncateAt where) {
        dsTaint.addTaint(where.dsTaint);
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.162 -0400", hash_original_method = "CD4BE90CF39D915FD988D1208E7FE9CE", hash_generated_method = "96D55CA77C9ADD704C9C8C01D27A48FA")
    @DSModeled(DSC.SAFE)
    public void setMarqueeRepeatLimit(int marqueeLimit) {
        dsTaint.addTaint(marqueeLimit);
        // ---------- Original Method ----------
        //mMarqueeRepeatLimit = marqueeLimit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.162 -0400", hash_original_method = "A6931739C39A011B325E0D6A04B5E1A4", hash_generated_method = "896D46AB6B3F51F5A4B8D1FD5071FBE4")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public TextUtils.TruncateAt getEllipsize() {
        return (TextUtils.TruncateAt)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mEllipsize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.162 -0400", hash_original_method = "EF856664E3DB8B213F8E2D5A0092DC9C", hash_generated_method = "752513298D2B16D6F0BBFE7303003616")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public void setSelectAllOnFocus(boolean selectAllOnFocus) {
        dsTaint.addTaint(selectAllOnFocus);
        {
            setText(mText, BufferType.SPANNABLE);
        } //End block
        // ---------- Original Method ----------
        //mSelectAllOnFocus = selectAllOnFocus;
        //if (selectAllOnFocus && !(mText instanceof Spannable)) {
            //setText(mText, BufferType.SPANNABLE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.163 -0400", hash_original_method = "8363604A399432417CD34524C965D01B", hash_generated_method = "AC3EE2CE54294D9896D905A76DC10543")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public void setCursorVisible(boolean visible) {
        dsTaint.addTaint(visible);
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.163 -0400", hash_original_method = "D29F788B650242C9D9871158254DD48F", hash_generated_method = "C9F8F16DF2F20B7BFDD49F05BFCEEE57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isCursorVisible() {
        boolean var34066627433670C8BAD177AAE0AA915E_787304913 = (mCursorVisible && isTextEditable());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCursorVisible && isTextEditable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.163 -0400", hash_original_method = "20D9FD35375357DA34698727A7AEC969", hash_generated_method = "C8AB1BA91849335CBA008B966E2992A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean canMarquee() {
        int width;
        width = (mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight());
        boolean var7BCDD076660CE26696388675CAFFA311_1027473279 = (width > 0 && (mLayout.getLineWidth(0) > width ||
                (mMarqueeFadeMode != MARQUEE_FADE_NORMAL && mSavedMarqueeModeLayout != null &&
                        mSavedMarqueeModeLayout.getLineWidth(0) > width)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int width = (mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight());
        //return width > 0 && (mLayout.getLineWidth(0) > width ||
                //(mMarqueeFadeMode != MARQUEE_FADE_NORMAL && mSavedMarqueeModeLayout != null &&
                        //mSavedMarqueeModeLayout.getLineWidth(0) > width));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.163 -0400", hash_original_method = "A5A9508FE00ED8FCDF4CF88DA2302AE0", hash_generated_method = "230DA644C5FD5F7CFF804B80D59EBDFF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void startMarquee() {
        {
            boolean var6ED3A362A2778E1490EC444CE7783B2B_16237655 = (compressText(getWidth() - getCompoundPaddingLeft() - getCompoundPaddingRight()));
        } //End collapsed parenthetic
        {
            boolean var075BA9C6A85CDA01D82AF38828D63BDE_846124087 = ((mMarquee == null || mMarquee.isStopped()) && (isFocused() || isSelected()) &&
                getLineCount() == 1 && canMarquee());
            {
                {
                    mMarqueeFadeMode = MARQUEE_FADE_SWITCH_SHOW_FADE;
                    final Layout tmp;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.163 -0400", hash_original_method = "20FFAC26BF2AB259CA62980CC6D60A71", hash_generated_method = "851F2BAC04E29E0AB07A41D400599417")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void stopMarquee() {
        {
            boolean varC29061DCB050768224BF65B86692AEF9_781520673 = (mMarquee != null && !mMarquee.isStopped());
            {
                mMarquee.stop();
            } //End block
        } //End collapsed parenthetic
        {
            mMarqueeFadeMode = MARQUEE_FADE_SWITCH_SHOW_ELLIPSIS;
            final Layout tmp;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.163 -0400", hash_original_method = "21D240E17A817FDDEDCDA696469AE631", hash_generated_method = "A0980D8FD5E6737BC51A032E62494F32")
    @DSModeled(DSC.SAFE)
    private void startStopMarquee(boolean start) {
        dsTaint.addTaint(start);
        {
            {
                startMarquee();
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.163 -0400", hash_original_method = "CD3A5A17C18A7E4515BB5E10EEE133D7", hash_generated_method = "581B9167E6EC57C5A0CDDB227D961F50")
    @DSModeled(DSC.SAFE)
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(text);
        dsTaint.addTaint(lengthBefore);
        dsTaint.addTaint(start);
        dsTaint.addTaint(lengthAfter);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.163 -0400", hash_original_method = "50DC1B812435050055FA72016E5949C2", hash_generated_method = "90443E5ACB9E2AE2A9CEE706B26945D3")
    @DSModeled(DSC.SAFE)
    protected void onSelectionChanged(int selStart, int selEnd) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(selStart);
        dsTaint.addTaint(selEnd);
        sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED);
        // ---------- Original Method ----------
        //sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.163 -0400", hash_original_method = "B64F50676D912718618203C6EADBF90A", hash_generated_method = "C55EB5C715FAEAE8B2FCEC33977B3B83")
    @DSModeled(DSC.SAFE)
    public void addTextChangedListener(TextWatcher watcher) {
        dsTaint.addTaint(watcher.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.164 -0400", hash_original_method = "8E2AAA118EDD6CA871B924E45DB79686", hash_generated_method = "3106B2AB91E1039B6776268BF855C519")
    @DSModeled(DSC.SAFE)
    public void removeTextChangedListener(TextWatcher watcher) {
        dsTaint.addTaint(watcher.dsTaint);
        {
            int i;
            i = mListeners.indexOf(watcher);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.164 -0400", hash_original_method = "282476D07DF9C69037F7F82B56506B50", hash_generated_method = "AE6CB8F6DF0B583D3B83B24A821F92DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendBeforeTextChanged(CharSequence text, int start, int before, int after) {
        dsTaint.addTaint(after);
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(before);
        {
            final ArrayList<TextWatcher> list;
            list = mListeners;
            final int count;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.164 -0400", hash_original_method = "3C2834233455B82E3097E9750018AB89", hash_generated_method = "87D5F75D17AEA385FA334C662744DE72")
    @DSModeled(DSC.SAFE)
    private <T> void removeIntersectingSpans(int start, int end, Class<T> type) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(type.dsTaint);
        dsTaint.addTaint(end);
        Editable text;
        text = (Editable) mText;
        T[] spans;
        spans = text.getSpans(start, end, type);
        final int length;
        length = spans.length;
        {
            int i;
            i = 0;
            {
                final int s;
                s = text.getSpanStart(spans[i]);
                final int e;
                e = text.getSpanEnd(spans[i]);
                text.removeSpan(spans[i]);
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.164 -0400", hash_original_method = "942AE7F3893B5D5A1A729CC9A3D3A214", hash_generated_method = "7DB257A262BCF8438408D9B68399894B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void sendOnTextChanged(CharSequence text, int start, int before, int after) {
        dsTaint.addTaint(after);
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(before);
        {
            final ArrayList<TextWatcher> list;
            list = mListeners;
            final int count;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.164 -0400", hash_original_method = "9B73ECD477F18D05FDDE640FFC672625", hash_generated_method = "3CC5426479B54E3C9CCF253D3097A333")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void sendAfterTextChanged(Editable text) {
        dsTaint.addTaint(text.dsTaint);
        {
            final ArrayList<TextWatcher> list;
            list = mListeners;
            final int count;
            count = list.size();
            {
                int i;
                i = 0;
                {
                    list.get(i).afterTextChanged(text);
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.164 -0400", hash_original_method = "4CD104B06ADE0BFE958B91634E28368D", hash_generated_method = "5EC8D7757B348D180D66D79D8E12DEC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void handleTextChanged(CharSequence buffer, int start, int before, int after) {
        dsTaint.addTaint(buffer);
        dsTaint.addTaint(after);
        dsTaint.addTaint(start);
        dsTaint.addTaint(before);
        final InputMethodState ims;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.165 -0400", hash_original_method = "69940040C167925CDE0DCFB6E34891AF", hash_generated_method = "0FF67416EC7D06ADA44D3B3A706443E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void spanChange(Spanned buf, Object what, int oldStart, int newStart, int oldEnd, int newEnd) {
        dsTaint.addTaint(oldEnd);
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(newStart);
        dsTaint.addTaint(oldStart);
        dsTaint.addTaint(buf.dsTaint);
        dsTaint.addTaint(newEnd);
        boolean selChanged;
        selChanged = false;
        int newSelStart, newSelEnd;
        newSelStart = -1;
        newSelEnd = -1;
        final InputMethodState ims;
        ims = mInputMethodState;
        {
            mHighlightPathBogus = true;
            selChanged = true;
            newSelEnd = newStart;
            {
                boolean varCCB6FB0842D1DC09DCB72C373334A6F6_1213845290 = (!isFocused());
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
                boolean varCCB6FB0842D1DC09DCB72C373334A6F6_1120840984 = (!isFocused());
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
                boolean varA8F0B10D2B3144CBC8414B61F2255511_1457049196 = ((buf.getSpanFlags(what)&Spanned.SPAN_INTERMEDIATE) == 0);
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
            boolean var534517144FEFDAEF71F7C8FA756F16FC_2129313670 = (MetaKeyKeyListener.isMetaTracker(buf, what));
            {
                mHighlightPathBogus = true;
                {
                    boolean var16FFCEF6C055C210FC735BC7F134F961_1089930043 = (ims != null && MetaKeyKeyListener.isSelectingMetaTracker(buf, what));
                    {
                        ims.mSelectionModeChanged = true;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varEFD569E843D74170ABE4EC8DA8C94C51_992721556 = (Selection.getSelectionStart(buf) >= 0);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.165 -0400", hash_original_method = "3584A2B9A599770217F39B9A82ACFE32", hash_generated_method = "1E4B7D2AF1D514222EB9AB7011B3F6BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateSpellCheckSpans(int start, int end, boolean createSpellChecker) {
        dsTaint.addTaint(createSpellChecker);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        {
            boolean var330582D41A8577FF8D2F4281F7486A79_1806313222 = (isTextEditable() && isSuggestionsEnabled() && !(this instanceof ExtractEditText));
            {
                {
                    mSpellChecker = new SpellChecker(this);
                } //End block
                {
                    mSpellChecker.spellCheck(start, end);
                } //End block
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.165 -0400", hash_original_method = "5B060B8ED8B2D254991A03FDABE416A2", hash_generated_method = "DB1EB795A7883D0F9EBCBE0445AFD858")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.165 -0400", hash_original_method = "F389EC0F4785B5FE5917104FC845071C", hash_generated_method = "B42C33B9BDC87CD63938B7B9BF7CF104")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.165 -0400", hash_original_method = "FEAF0C4CB4DA72DBC669293A29968ABE", hash_generated_method = "29558E58349D48FEEE3A414037165D50")
    @DSModeled(DSC.SAFE)
    @Override
    public void onFinishTemporaryDetach() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onFinishTemporaryDetach();
        mTemporaryDetach = false;
        // ---------- Original Method ----------
        //super.onFinishTemporaryDetach();
        //if (!mDispatchTemporaryDetach) mTemporaryDetach = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.166 -0400", hash_original_method = "B5EB741E17FA804FF18CB2D4805829B5", hash_generated_method = "8928B1A9F489841AD418253C91CB7E5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(direction);
        dsTaint.addTaint(focused);
        dsTaint.addTaint(previouslyFocusedRect.dsTaint);
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
            final boolean isFocusHighlighted;
            isFocusHighlighted = mSelectAllOnFocus && selStart == 0 &&
                    selEnd == mText.length();
            mCreatedWithASelection = mFrozenWithFocus && hasSelection() && !isFocusHighlighted;
            {
                final int lastTapPosition;
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
                final int selStart;
                selStart = getSelectionStart();
                final int selEnd;
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.166 -0400", hash_original_method = "CD7EF11AEB2748DC958E6E43AA11AC3D", hash_generated_method = "64B2D12C3D53C7BB38FBEF175811844E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getLastTapPosition() {
        {
            int lastTapPosition;
            lastTapPosition = mSelectionModifierCursorController.getMinTouchOffset();
            {
                {
                    boolean var164D0FD6416EC18A9D0895B7ABD638B0_189747940 = (lastTapPosition > mText.length());
                    {
                        lastTapPosition = mText.length();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.166 -0400", hash_original_method = "52F09857D084B6A7FF7DED6ACD447E38", hash_generated_method = "D5D6B533393C83A94E74BE2A4E6AC2F6")
    @DSModeled(DSC.SAFE)
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(hasWindowFocus);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.166 -0400", hash_original_method = "CACE22E1BEC14AEE1A4D35946DA3AF11", hash_generated_method = "1B795EB3E273A9D55A6324DA1EDE2873")
    @DSModeled(DSC.SAFE)
    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(visibility);
        dsTaint.addTaint(changedView.dsTaint);
        super.onVisibilityChanged(changedView, visibility);
        {
            hideControllers();
        } //End block
        // ---------- Original Method ----------
        //super.onVisibilityChanged(changedView, visibility);
        //if (visibility != VISIBLE) {
            //hideControllers();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.166 -0400", hash_original_method = "B1100F7CC0894E179F002CED35623F94", hash_generated_method = "D6A9FE6460F444067BC53062D9DD2D1A")
    @DSModeled(DSC.SAFE)
    public void clearComposingText() {
        {
            BaseInputConnection.removeComposingSpans((Spannable)mText);
        } //End block
        // ---------- Original Method ----------
        //if (mText instanceof Spannable) {
            //BaseInputConnection.removeComposingSpans((Spannable)mText);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.166 -0400", hash_original_method = "D9A75FFCA0200824B6C25D7D7E778114", hash_generated_method = "B2FA1D475AE9D59FC9969BABBE857886")
    @DSModeled(DSC.SAFE)
    @Override
    public void setSelected(boolean selected) {
        dsTaint.addTaint(selected);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.167 -0400", hash_original_method = "66B01BC66F894D20F58119BE8C84CE2C", hash_generated_method = "B67BD620D1A20D6066BC8B7F1C9D5A6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        final int action;
        action = event.getActionMasked();
        {
            boolean varCA8C62D3CC4BCF9B6208820C93DA2727_1059290662 = (hasSelectionController());
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
        final boolean superResult;
        superResult = super.onTouchEvent(event);
        {
            mDiscardNextActionUp = false;
        } //End block
        final boolean touchIsFinished;
        touchIsFinished = (action == MotionEvent.ACTION_UP) &&
                !shouldIgnoreActionUpEvent() && isFocused();
        {
            boolean var20D4C59FE6C285ECEE884C522E960420_2004053595 = ((mMovement != null || onCheckIsTextEditor()) && isEnabled()
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
                    boolean varA138BB91854FD0E07817A4930DAB4E64_1093672396 = (touchIsFinished && (isTextEditable() || mTextIsSelectable));
                    {
                        final InputMethodManager imm;
                        imm = InputMethodManager.peekInstance();
                        viewClicked(imm);
                        {
                            handled |= imm != null && imm.showSoftInput(this, 0);
                        } //End block
                        boolean selectAllGotFocus;
                        selectAllGotFocus = mSelectAllOnFocus && didTouchFocusSelect();
                        hideControllers();
                        {
                            boolean varC8FC4D62C210E65C8DA1490C44E99120_820930822 = (!selectAllGotFocus && mText.length() > 0);
                            {
                                {
                                    mSpellChecker.onSelectionChanged();
                                } //End block
                                {
                                    boolean var1CF112AAAC5F75383DBE7BFFD7531552_1014007474 = (!extractedTextModeWillBeStarted());
                                    {
                                        {
                                            boolean var60BC98927E3B58E7C5E7F75DDA71E61E_1884277080 = (isCursorInsideEasyCorrectionSpan());
                                            {
                                                showSuggestions();
                                            } //End block
                                            {
                                                boolean varB6DE6ED2562A6539C8A95CCE9438A153_1596229927 = (hasInsertionController());
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.167 -0400", hash_original_method = "03AC5F43014CB2A7B3EC5095819B8787", hash_generated_method = "85C8A1A0C71DBF0A2FE2744C78CCDA05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isCursorInsideSuggestionSpan() {
        SuggestionSpan[] suggestionSpans;
        suggestionSpans = ((Spannable) mText).getSpans(getSelectionStart(),
                getSelectionEnd(), SuggestionSpan.class);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!(mText instanceof Spannable)) return false;
        //SuggestionSpan[] suggestionSpans = ((Spannable) mText).getSpans(getSelectionStart(),
                //getSelectionEnd(), SuggestionSpan.class);
        //return (suggestionSpans.length > 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.167 -0400", hash_original_method = "FDBB0D2E258BF757A8B32CAC4ADCAFC2", hash_generated_method = "8FC98A13CE93D725B7DFBE1F22FBC446")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
                    boolean var2346E33123BC41A418719A614F5A6DD6_228057375 = ((suggestionSpans[i].getFlags() & SuggestionSpan.FLAG_EASY_CORRECT) != 0);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.167 -0400", hash_original_method = "B422CE655E2FA1B2DED230B806484199", hash_generated_method = "A8A62007F69A17BC38E0A004444D29B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.167 -0400", hash_original_method = "F41FEEC7411770322E4286C20722D03F", hash_generated_method = "2AE8443A2D09F0A14108F66762199C39")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        {
            try 
            {
                {
                    boolean var8B12764D2A804081F5E2F3C6ECF4057D_596442713 = (mMovement.onGenericMotionEvent(this, (Spannable) mText, event));
                } //End collapsed parenthetic
            } //End block
            catch (AbstractMethodError ex)
            { }
        } //End block
        boolean var32C1E3DF40BCC120C79428C7AEB27DD1_829193646 = (super.onGenericMotionEvent(event));
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.168 -0400", hash_original_method = "1022846F3BD24E55F7B42FF144EBDE9C", hash_generated_method = "79599AB3046A2445BA53B2420FD7939D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.168 -0400", hash_original_method = "5768F33DD15C2D6A1E8DF566C117D02C", hash_generated_method = "715331F92C25D0267CE9D4C1793C2CC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isTextEditable() {
        boolean varE3EE8DDB74DAF8872FE53127269AB9E6_46077094 = (mText instanceof Editable && onCheckIsTextEditor() && isEnabled());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mText instanceof Editable && onCheckIsTextEditor() && isEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.168 -0400", hash_original_method = "319EEEA24E78F0A8A97E7B3282410D43", hash_generated_method = "02D0F367665EE808DFC6E9A98410BA88")
    @DSModeled(DSC.SAFE)
    public boolean didTouchFocusSelect() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mTouchFocusSelected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.168 -0400", hash_original_method = "F8EF60C67754333637E515F4BC0EB2C7", hash_generated_method = "88B73F63A912974B215F75BA15A39193")
    @DSModeled(DSC.SAFE)
    @Override
    public void cancelLongPress() {
        super.cancelLongPress();
        mIgnoreActionUpEvent = true;
        // ---------- Original Method ----------
        //super.cancelLongPress();
        //mIgnoreActionUpEvent = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.168 -0400", hash_original_method = "1EBA305C38503D593DE5ED34528F31AE", hash_generated_method = "784136402B1C653B5CA80A745B475C0D")
    @DSModeled(DSC.SAFE)
    public boolean shouldIgnoreActionUpEvent() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIgnoreActionUpEvent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.168 -0400", hash_original_method = "2ED59B8CED9712CD9EFEA3386ABFE955", hash_generated_method = "00EC4F3FBF3CEECE14B03FEE9C7DF919")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        {
            {
                boolean var8C6289BC177E1FC846FED60E961858F7_800520330 = (mMovement.onTrackballEvent(this, (Spannable) mText, event));
            } //End collapsed parenthetic
        } //End block
        boolean var52056F11E16FA151938F980C67CD97F9_1983518054 = (super.onTrackballEvent(event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mMovement != null && mText instanceof Spannable &&
            //mLayout != null) {
            //if (mMovement.onTrackballEvent(this, (Spannable) mText, event)) {
                //return true;
            //}
        //}
        //return super.onTrackballEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.168 -0400", hash_original_method = "9E4C5FDADE7CEAD68CF365879A643A39", hash_generated_method = "5D05686EECFC92EAA4E78F1AC0F2D5F6")
    @DSModeled(DSC.SAFE)
    public void setScroller(Scroller s) {
        dsTaint.addTaint(s.dsTaint);
        // ---------- Original Method ----------
        //mScroller = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.168 -0400", hash_original_method = "D90D14C34AE2DD19EDEA4AA99DD580AF", hash_generated_method = "787D2DB3288A288B5893EA9956689C77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean shouldBlink() {
        {
            boolean var4ABCBE6852627F4B46FBEF2A6A4ECCCA_1054049840 = (!isFocused());
        } //End collapsed parenthetic
        final int start;
        start = getSelectionStart();
        final int end;
        end = getSelectionEnd();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!isFocused()) return false;
        //final int start = getSelectionStart();
        //if (start < 0) return false;
        //final int end = getSelectionEnd();
        //if (end < 0) return false;
        //return start == end;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.168 -0400", hash_original_method = "D1BDF909CEA832525561C896748DB631", hash_generated_method = "25977AF1CA40C6ED0BEF2A6B6CC068EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void makeBlink() {
        {
            boolean var36B9A155CA4AF19B05F2985EF7AEDB1C_1683200441 = (isCursorVisible());
            {
                {
                    boolean var1E1DE2716F3F9B589A087F50D1F61A8B_1004560186 = (shouldBlink());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.169 -0400", hash_original_method = "2371CC9F994A54DD5E29CBD2552784AA", hash_generated_method = "DB125B44D17889F96F6100D66E9EDE4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected float getLeftFadingEdgeStrength() {
        {
            {
                boolean var48B2E39505E7202B89848EF3423B9152_131488260 = (mMarquee != null && !mMarquee.isStopped());
                {
                    final Marquee marquee;
                    marquee = mMarquee;
                    {
                        boolean var9BA25C39B44D42503DBE86D96DDE3F89_305854765 = (marquee.shouldDrawLeftFade());
                        {
                            float varACB89E3006AD14B300166FDE2E87A6BF_1337000597 = (marquee.mScroll / getHorizontalFadingEdgeLength());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean varB42567ABE2BADBC605E1B78E45085C46_838674882 = (getLineCount() == 1);
                    {
                        final int layoutDirection;
                        layoutDirection = getResolvedLayoutDirection();
                        final int absoluteGravity;
                        absoluteGravity = Gravity.getAbsoluteGravity(mGravity, layoutDirection);
                        //Begin case Gravity.RIGHT 
                        float var77CC60141975FCCCD80D9A2419BB6C1C_39826741 = ((mLayout.getLineRight(0) - (mRight - mLeft) -
                                getCompoundPaddingLeft() - getCompoundPaddingRight() -
                                mLayout.getLineLeft(0)) / getHorizontalFadingEdgeLength());
                        //End case Gravity.RIGHT 
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        float var4F5C2129A9FDB4D7873C15071EC74FAF_770000852 = (super.getLeftFadingEdgeStrength());
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.169 -0400", hash_original_method = "7D05EA9E8579412E6DC4A8392EC7FDC2", hash_generated_method = "2F8F54EAD4F40A60963BD23BE298EB38")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected float getRightFadingEdgeStrength() {
        {
            {
                boolean var48B2E39505E7202B89848EF3423B9152_1106905105 = (mMarquee != null && !mMarquee.isStopped());
                {
                    final Marquee marquee;
                    marquee = mMarquee;
                    float var5FA73A5ADF77E0C7B666EC3867F0A8A9_376247091 = ((marquee.mMaxFadeScroll - marquee.mScroll) / getHorizontalFadingEdgeLength());
                } //End block
                {
                    boolean varB42567ABE2BADBC605E1B78E45085C46_1539528522 = (getLineCount() == 1);
                    {
                        final int layoutDirection;
                        layoutDirection = getResolvedLayoutDirection();
                        final int absoluteGravity;
                        absoluteGravity = Gravity.getAbsoluteGravity(mGravity, layoutDirection);
                        //Begin case Gravity.LEFT 
                        final int textWidth;
                        textWidth = (mRight - mLeft) - getCompoundPaddingLeft() -
                                getCompoundPaddingRight();
                        //End case Gravity.LEFT 
                        //Begin case Gravity.LEFT 
                        final float lineWidth;
                        lineWidth = mLayout.getLineWidth(0);
                        //End case Gravity.LEFT 
                        //Begin case Gravity.LEFT 
                        float varE0BE637D155EE291A7CF14784CC269F6_1794132055 = ((lineWidth - textWidth) / getHorizontalFadingEdgeLength());
                        //End case Gravity.LEFT 
                        //Begin case Gravity.CENTER_HORIZONTAL Gravity.FILL_HORIZONTAL 
                        float varDB511E24CC8812A21F30B808ED92516B_415902218 = ((mLayout.getLineWidth(0) - ((mRight - mLeft) -
                                getCompoundPaddingLeft() - getCompoundPaddingRight())) /
                                getHorizontalFadingEdgeLength());
                        //End case Gravity.CENTER_HORIZONTAL Gravity.FILL_HORIZONTAL 
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        float var23E074F03E79DB75514A1493E85330EB_1180040683 = (super.getRightFadingEdgeStrength());
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.169 -0400", hash_original_method = "A3B3BBCD8F5911495212C23A0CDB87AF", hash_generated_method = "DCCDEF96B5667BBAE1FBD5CE89316639")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int computeHorizontalScrollRange() {
        {
            {
                Object varB9E01A838DEDF048798537932C3D53D0_1790683687 = ((int) mLayout.getLineWidth(0));
                Object var48F73E2237CC10856F86F9441A565829_2124455849 = (mLayout.getWidth());
            } //End flattened ternary
        } //End block
        int varED0C9CF0B7C065764BC0B4CBB9BD10B1_82440755 = (super.computeHorizontalScrollRange());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mLayout != null) {
            //return mSingleLine && (mGravity & Gravity.HORIZONTAL_GRAVITY_MASK) == Gravity.LEFT ?
                    //(int) mLayout.getLineWidth(0) : mLayout.getWidth();
        //}
        //return super.computeHorizontalScrollRange();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.169 -0400", hash_original_method = "FD0A725F27B0D409B10AFF4BD8232C49", hash_generated_method = "0174F3CEBB365A479AA52FF4DEA1CEFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int computeVerticalScrollRange() {
        int varEEB54A75518B385B09E35C2F7B0BB4DB_137357373 = (mLayout.getHeight());
        int var06B1DFE229A17C2C5018936314B519D0_851022004 = (super.computeVerticalScrollRange());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mLayout != null)
            //return mLayout.getHeight();
        //return super.computeVerticalScrollRange();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.169 -0400", hash_original_method = "9A16EAE7151454D3FA35454A6C3BB413", hash_generated_method = "82D4D02D093B03710BF9E320820D9190")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int computeVerticalScrollExtent() {
        int var3D22FDF56C8F597D4B164222BB4A2F41_2062940026 = (getHeight() - getCompoundPaddingTop() - getCompoundPaddingBottom());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getHeight() - getCompoundPaddingTop() - getCompoundPaddingBottom();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.170 -0400", hash_original_method = "AF6DED1CDDAE4FEC9AD8DCCD50DF8C26", hash_generated_method = "70526BA25326CFC896A381B353A31331")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void findViewsWithText(ArrayList<View> outViews, CharSequence searched, int flags) {
        dsTaint.addTaint(outViews.dsTaint);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(searched);
        super.findViewsWithText(outViews, searched, flags);
        {
            boolean var87A9E824D7926B465D9F8E23653E1606_1511069840 = (!outViews.contains(this) && (flags & FIND_VIEWS_WITH_TEXT) != 0
                && !TextUtils.isEmpty(searched) && !TextUtils.isEmpty(mText));
            {
                String searchedLowerCase;
                searchedLowerCase = searched.toString().toLowerCase();
                String textLowerCase;
                textLowerCase = mText.toString().toLowerCase();
                {
                    boolean var4E8F3CA643822EB3D628A081C82F102F_392904366 = (textLowerCase.contains(searchedLowerCase));
                    {
                        outViews.add(this);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.170 -0400", hash_original_method = "610DF4562C72E9710D612FAA54D67DFE", hash_generated_method = "A75A6D7F80F1F0271AD4582D7821E552")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.170 -0400", hash_original_method = "97B35435029E9835DF5CDCF17B9F2F51", hash_generated_method = "73EE96094A2B5463D96C2ABCBBBBB25C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.170 -0400", hash_original_method = "9DEDF12E7A1F2B52484CF7C1E98D635C", hash_generated_method = "D1749CDEDB0B630B5F51C9D1A9F96A1A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        final int filteredMetaState;
        filteredMetaState = event.getMetaState() & ~KeyEvent.META_CTRL_MASK;
        {
            boolean varC56AADD2FE16B97F2C4A1A86C8CB9277_91574168 = (KeyEvent.metaStateHasNoModifiers(filteredMetaState));
            {
                //Begin case KeyEvent.KEYCODE_A 
                {
                    boolean var2C54826044A6A463985C967714461581_268600126 = (canSelectText());
                    {
                        boolean varEB35FFB1E0BAFF4B98799DF0DAE3AD9A_1893144216 = (onTextContextMenuItem(ID_SELECT_ALL));
                    } //End block
                } //End collapsed parenthetic
                //End case KeyEvent.KEYCODE_A 
                //Begin case KeyEvent.KEYCODE_X 
                {
                    boolean varD70E317BC144C26B73AA08B3BA3A1DF7_1469332500 = (canCut());
                    {
                        boolean varF1F4885B43FDB12CD2347207BFCBE15D_156835246 = (onTextContextMenuItem(ID_CUT));
                    } //End block
                } //End collapsed parenthetic
                //End case KeyEvent.KEYCODE_X 
                //Begin case KeyEvent.KEYCODE_C 
                {
                    boolean var64A51BC817B541ED78EC45FE802A582B_1093326724 = (canCopy());
                    {
                        boolean var7EC513D62717566DFF11F991DB68179B_706568450 = (onTextContextMenuItem(ID_COPY));
                    } //End block
                } //End collapsed parenthetic
                //End case KeyEvent.KEYCODE_C 
                //Begin case KeyEvent.KEYCODE_V 
                {
                    boolean varB590DB230E7D99BE97C8070362518C3D_305497086 = (canPaste());
                    {
                        boolean varB380C053436C26C9F75D58F60AA0273E_647325996 = (onTextContextMenuItem(ID_PASTE));
                    } //End block
                } //End collapsed parenthetic
                //End case KeyEvent.KEYCODE_V 
            } //End block
        } //End collapsed parenthetic
        boolean var18CCACF7413D8761F4926498DDE0852A_425122352 = (super.onKeyShortcut(keyCode, event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.170 -0400", hash_original_method = "CD8FD18ADF4940449D6A099035EC8FE9", hash_generated_method = "94B87B9DFD9D0610694408728A5BC9FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean canSelectText() {
        boolean var45174109A5D4D4DED4D6B043F4737E70_1896053922 = (hasSelectionController() && mText.length() != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return hasSelectionController() && mText.length() != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.170 -0400", hash_original_method = "09898B129565A0932D7F5D96EEC9BB39", hash_generated_method = "51EB8BCF8E1424C82BB3929AC21503D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean textCanBeSelected() {
        {
            boolean var0579FE66F74E6B0CAEB7B0FFED7BF6F0_974735036 = (mMovement == null || !mMovement.canSelectArbitrarily());
        } //End collapsed parenthetic
        boolean varEA838F60BF8890D30F87CAA0AEA5A5AD_380515577 = (isTextEditable() || (mTextIsSelectable && mText instanceof Spannable && isEnabled()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mMovement == null || !mMovement.canSelectArbitrarily()) return false;
        //return isTextEditable() || (mTextIsSelectable && mText instanceof Spannable && isEnabled());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.170 -0400", hash_original_method = "5A8A75E52337470DA5834210CD94E844", hash_generated_method = "FD5E6AAA5667DC196B16493988FBE76F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean canCut() {
        {
            boolean varAFBCCFFAA18696A12B6915A938CC8475_1664260435 = (hasPasswordTransformationMethod());
        } //End collapsed parenthetic
        {
            boolean varDFBD28C454DECC5A34D6B1D50ACA53BA_1448184797 = (mText.length() > 0 && hasSelection() && mText instanceof Editable && mInput != null);
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (hasPasswordTransformationMethod()) {
            //return false;
        //}
        //if (mText.length() > 0 && hasSelection() && mText instanceof Editable && mInput != null) {
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.170 -0400", hash_original_method = "C5BA619EC7C225A5F87BCD822F6EF570", hash_generated_method = "E55E297EAD10DF7A2177F5BCE3851F73")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean canCopy() {
        {
            boolean varAFBCCFFAA18696A12B6915A938CC8475_1351693698 = (hasPasswordTransformationMethod());
        } //End collapsed parenthetic
        {
            boolean varCAC8FC6B32A4536E20AA1AECC8F0BAF1_40848534 = (mText.length() > 0 && hasSelection());
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (hasPasswordTransformationMethod()) {
            //return false;
        //}
        //if (mText.length() > 0 && hasSelection()) {
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.170 -0400", hash_original_method = "4C1E94F781705995B290C548A8DF616E", hash_generated_method = "3FCBFBF101068DCAD5D0217E4BA05853")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean canPaste() {
        boolean varE457499D879154E36F02FF3DB5A1ED3A_1004174904 = ((mText instanceof Editable &&
                mInput != null &&
                getSelectionStart() >= 0 &&
                getSelectionEnd() >= 0 &&
                ((ClipboardManager)getContext().getSystemService(Context.CLIPBOARD_SERVICE)).
                hasPrimaryClip()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mText instanceof Editable &&
                //mInput != null &&
                //getSelectionStart() >= 0 &&
                //getSelectionEnd() >= 0 &&
                //((ClipboardManager)getContext().getSystemService(Context.CLIPBOARD_SERVICE)).
                //hasPrimaryClip());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.170 -0400", hash_original_method = "6CF90DF2EC40ED00D80E18C1F33E11BC", hash_generated_method = "5FA359866299A35489C3737B61CC9E43")
    private static long packRangeInLong(int start, int end) {
        return (((long) start) << 32) | end;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.171 -0400", hash_original_method = "B8457D164A465BC6DBF90754C8516687", hash_generated_method = "EC410F8EAE725FE659DD2D2EFBCDB07E")
    private static int extractRangeStartFromLong(long range) {
        return (int) (range >>> 32);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.171 -0400", hash_original_method = "F1A2938AD077ADF89D5A8BD63BAC91E0", hash_generated_method = "644C64A378737B0C013497F66056F5D5")
    private static int extractRangeEndFromLong(long range) {
        return (int) (range & 0x00000000FFFFFFFFL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.171 -0400", hash_original_method = "493FC66F8A7ACF6A75CECBBBC666AB3C", hash_generated_method = "1223A7AE57CB488C1C500D160C4E80BD")
    @DSModeled(DSC.SAFE)
    private boolean selectAll() {
        final int length;
        length = mText.length();
        Selection.setSelection((Spannable) mText, 0, length);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int length = mText.length();
        //Selection.setSelection((Spannable) mText, 0, length);
        //return length > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.171 -0400", hash_original_method = "B770D2F4FC63A979B3CD07A81B20384D", hash_generated_method = "30057AB6418158B24F3A050DADFC91A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean selectCurrentWord() {
        {
            boolean varDED1C694F054C8DDF1A29A76C5F20F19_1851354988 = (!canSelectText());
        } //End collapsed parenthetic
        {
            boolean varAFBCCFFAA18696A12B6915A938CC8475_1683335200 = (hasPasswordTransformationMethod());
            {
                boolean varE332F16868C9FD223E86B20517E855EF_544662389 = (selectAll());
            } //End block
        } //End collapsed parenthetic
        int klass;
        klass = mInputType & InputType.TYPE_MASK_CLASS;
        int variation;
        variation = mInputType & InputType.TYPE_MASK_VARIATION;
        {
            boolean varA650E26BD9A4F09AA14DDEB72540C88C_1104402805 = (selectAll());
        } //End block
        long lastTouchOffsets;
        lastTouchOffsets = getLastTouchOffsets();
        final int minOffset;
        minOffset = extractRangeStartFromLong(lastTouchOffsets);
        final int maxOffset;
        maxOffset = extractRangeEndFromLong(lastTouchOffsets);
        {
            boolean var7155FC6291E75A72164AEF06E53012B4_1308718003 = (minOffset < 0 || minOffset >= mText.length());
        } //End collapsed parenthetic
        {
            boolean var1D5071A17653318C6F5B2B7CEE876EF7_2067968748 = (maxOffset < 0 || maxOffset >= mText.length());
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
            final WordIterator wordIterator;
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.171 -0400", hash_original_method = "9DCEB61D4BC0794F06560CB12151C0AA", hash_generated_method = "5DC9994F4F41B9C7A40FB97F1A1DB0FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Locale getTextServicesLocale() {
        Locale locale;
        locale = Locale.getDefault();
        final TextServicesManager textServicesManager;
        textServicesManager = (TextServicesManager)
                mContext.getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE);
        final SpellCheckerSubtype subtype;
        subtype = textServicesManager.getCurrentSpellCheckerSubtype(true);
        {
            locale = new Locale(subtype.getLocale());
        } //End block
        return (Locale)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.171 -0400", hash_original_method = "84E4450A5BCA42ECDB6E0E833B2BF3C6", hash_generated_method = "E7E57370501B192176E97E27A714450B")
    @DSModeled(DSC.SAFE)
     void onLocaleChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mWordIterator = null;
        // ---------- Original Method ----------
        //mWordIterator = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.171 -0400", hash_original_method = "D7DB0153FBA43371270FE2DB428D268F", hash_generated_method = "AE2EA64D2C123066BDD3156CFF00A987")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WordIterator getWordIterator() {
        {
            mWordIterator = new WordIterator(getTextServicesLocale());
        } //End block
        return (WordIterator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mWordIterator == null) {
            //mWordIterator = new WordIterator(getTextServicesLocale());
        //}
        //return mWordIterator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.171 -0400", hash_original_method = "B4D83E103073E3F8ED3897EF06B95E07", hash_generated_method = "7E71EC76ABF913AC70310A2A31C43AFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private long getCharRange(int offset) {
        dsTaint.addTaint(offset);
        final int textLength;
        textLength = mText.length();
        {
            final char currentChar;
            currentChar = mText.charAt(offset);
            final char nextChar;
            nextChar = mText.charAt(offset + 1);
            {
                boolean varD9CF44D283E0863128B66037E6BFB8CF_513361835 = (Character.isSurrogatePair(currentChar, nextChar));
                {
                    long varDEC17ADCE274EF4E4EA0CD9ABF597677_1402695111 = (packRangeInLong(offset,  offset + 2));
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            long var4A76496E7082009E497234E69A837D4C_2003444950 = (packRangeInLong(offset,  offset + 1));
        } //End block
        {
            final char previousChar;
            previousChar = mText.charAt(offset - 1);
            final char previousPreviousChar;
            previousPreviousChar = mText.charAt(offset - 2);
            {
                boolean var08ECDF9036721977163DCB5E7280D7DA_839180038 = (Character.isSurrogatePair(previousPreviousChar, previousChar));
                {
                    long var579E9393D23E6CD1E4A1644DEA02C196_1638692849 = (packRangeInLong(offset - 2,  offset));
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            long var7F931D32D69CE46E71E33A6E014D5A4B_1010070496 = (packRangeInLong(offset - 1,  offset));
        } //End block
        long var1DBEC51B3461A29B2118BF318D35E0B5_137288588 = (packRangeInLong(offset,  offset));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.172 -0400", hash_original_method = "C07E078EE2A4D1805F6BF366C72ED78F", hash_generated_method = "BD003FC741FC429BC2F192B8C5E4F827")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private long getLastTouchOffsets() {
        SelectionModifierCursorController selectionController;
        selectionController = getSelectionController();
        final int minOffset;
        minOffset = selectionController.getMinTouchOffset();
        final int maxOffset;
        maxOffset = selectionController.getMaxTouchOffset();
        long var6C22B70D609AA0EDBEA57BAC907EBF70_1409291965 = (packRangeInLong(minOffset, maxOffset));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //SelectionModifierCursorController selectionController = getSelectionController();
        //final int minOffset = selectionController.getMinTouchOffset();
        //final int maxOffset = selectionController.getMaxTouchOffset();
        //return packRangeInLong(minOffset, maxOffset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.172 -0400", hash_original_method = "A81C1729DD6237516D7BACF34829C51D", hash_generated_method = "CCE1989FB4EA6FCE7A5275A680B1E080")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        super.onPopulateAccessibilityEvent(event);
        final boolean isPassword;
        isPassword = hasPasswordTransformationMethod();
        {
            CharSequence text;
            text = getTextForAccessibility();
            {
                boolean varE82D2DAF247906B4725B56EFEDF2A150_1268646119 = (!TextUtils.isEmpty(text));
                {
                    event.getText().add(text);
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.172 -0400", hash_original_method = "6FC069A7F29DA435C1F4CA8AC1DF9A7A", hash_generated_method = "FF49A0B3C242D83EFFE3C37193FDD7F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        super.onInitializeAccessibilityEvent(event);
        final boolean isPassword;
        isPassword = hasPasswordTransformationMethod();
        event.setPassword(isPassword);
        {
            boolean var9F2EDE90BC8D745F3A5915C44AB298CC_1115044965 = (event.getEventType() == AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED);
            {
                event.setFromIndex(Selection.getSelectionStart(mText));
                event.setToIndex(Selection.getSelectionEnd(mText));
                event.setItemCount(mText.length());
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.172 -0400", hash_original_method = "305122B0EBB45F51524377B6AB6D9296", hash_generated_method = "791C1689D333DBE99DD1573784E3F9C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(info.dsTaint);
        super.onInitializeAccessibilityNodeInfo(info);
        final boolean isPassword;
        isPassword = hasPasswordTransformationMethod();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.172 -0400", hash_original_method = "69E83CE4CD48DE4ECD21620922EFCC1A", hash_generated_method = "84C6A1EF228F62F3DF17CD3AD2ABC4C5")
    @DSModeled(DSC.SAFE)
    @Override
    public void sendAccessibilityEvent(int eventType) {
        dsTaint.addTaint(eventType);
        super.sendAccessibilityEvent(eventType);
        // ---------- Original Method ----------
        //if (eventType == AccessibilityEvent.TYPE_VIEW_SCROLLED) {
            //return;
        //}
        //super.sendAccessibilityEvent(eventType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.172 -0400", hash_original_method = "8463B72D535FD98D84B93D99DA9D2B3A", hash_generated_method = "36E4C9F64405CA7F7AC257C691A109D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence getTextForAccessibility() {
        CharSequence text;
        text = getText();
        {
            boolean var6C86A511CD0D2845B6E0259573F6A612_371609358 = (TextUtils.isEmpty(text));
            {
                text = getHint();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //CharSequence text = getText();
        //if (TextUtils.isEmpty(text)) {
            //text = getHint();
        //}
        //return text;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.172 -0400", hash_original_method = "77215EF020F664C77A4E0174E763346B", hash_generated_method = "23349E3B25267BD9DCA558BF64B8A54B")
    @DSModeled(DSC.SAFE)
     void sendAccessibilityEventTypeViewTextChanged(CharSequence beforeText,
            int fromIndex, int removedCount, int addedCount) {
        dsTaint.addTaint(fromIndex);
        dsTaint.addTaint(removedCount);
        dsTaint.addTaint(addedCount);
        dsTaint.addTaint(beforeText);
        AccessibilityEvent event;
        event = AccessibilityEvent.obtain(AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.172 -0400", hash_original_method = "10EC795892359880AFC1661A7060F8D4", hash_generated_method = "3E1B3D3EC4C13F4496EB13E387BF29DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isInputMethodTarget() {
        InputMethodManager imm;
        imm = InputMethodManager.peekInstance();
        boolean var2E8BF75A8D890E760B8A4C35FF8B91BD_1158928859 = (imm != null && imm.isActive(this));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //InputMethodManager imm = InputMethodManager.peekInstance();
        //return imm != null && imm.isActive(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.172 -0400", hash_original_method = "395A8406E426F55316A0BF37153197E7", hash_generated_method = "B5EF0ED7A7F2F09C5F5770D60AB73D77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onTextContextMenuItem(int id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(id);
        int min;
        min = 0;
        int max;
        max = mText.length();
        {
            boolean var1C23F183BE3EEE2A8667855A22865324_1908512977 = (isFocused());
            {
                final int selStart;
                selStart = getSelectionStart();
                final int selEnd;
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.173 -0400", hash_original_method = "FE79E6B9FD3BC9A3AB2F6DF9CAFCD48E", hash_generated_method = "0CEBACBF88BFA6B53A2FCDAB56625F17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence getTransformedText(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        CharSequence varA2ECE102943016D3DE205B2C28E69806_1578998024 = (removeSuggestionSpans(mTransformed.subSequence(start, end)));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return removeSuggestionSpans(mTransformed.subSequence(start, end));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.173 -0400", hash_original_method = "6ABCBA1E552641094DE1B3327AD7FDD1", hash_generated_method = "2BBB6D894B1B60560724BCA553D61212")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private long prepareSpacesAroundPaste(int min, int max, CharSequence paste) {
        dsTaint.addTaint(min);
        dsTaint.addTaint(max);
        dsTaint.addTaint(paste);
        {
            boolean var350AE6B9AD47061FFDF129B7005A2411_116526075 = (paste.length() > 0);
            {
                {
                    final char charBefore;
                    charBefore = mTransformed.charAt(min - 1);
                    final char charAfter;
                    charAfter = paste.charAt(0);
                    {
                        boolean var3C202C664C757CF8D249A87B1D846040_111497262 = (Character.isSpaceChar(charBefore) && Character.isSpaceChar(charAfter));
                        {
                            final int originalLength;
                            originalLength = mText.length();
                            deleteText_internal(min - 1, min);
                            final int delta;
                            delta = mText.length() - originalLength;
                            min += delta;
                            max += delta;
                        } //End block
                        {
                            boolean varB469BF59168A8579CE9E3A2CAF0C1642_1917413350 = (!Character.isSpaceChar(charBefore) && charBefore != '\n' &&
                        !Character.isSpaceChar(charAfter) && charAfter != '\n');
                            {
                                final int originalLength;
                                originalLength = mText.length();
                                replaceText_internal(min, min, " ");
                                final int delta;
                                delta = mText.length() - originalLength;
                                min += delta;
                                max += delta;
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean varEEF1C48FC1D3D39DDF48A720B8628129_2001213128 = (max < mText.length());
                    {
                        final char charBefore;
                        charBefore = paste.charAt(paste.length() - 1);
                        final char charAfter;
                        charAfter = mTransformed.charAt(max);
                        {
                            boolean varBF8E0F80E2B510B9D515C61513407B2D_1114999005 = (Character.isSpaceChar(charBefore) && Character.isSpaceChar(charAfter));
                            {
                                deleteText_internal(max, max + 1);
                            } //End block
                            {
                                boolean var59E656C6DF389BAD07A380CF8AC3667A_10187500 = (!Character.isSpaceChar(charBefore) && charBefore != '\n' &&
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
        long var541DF126AEC1F4495FAD956E97F187A7_834327269 = (packRangeInLong(min, max));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.173 -0400", hash_original_method = "E0F0E7304052F47B24D850362D52309F", hash_generated_method = "A55C29DABC9E0360E56A3A9D31C5ED91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private DragShadowBuilder getTextThumbnailBuilder(CharSequence text) {
        dsTaint.addTaint(text);
        TextView shadowView;
        shadowView = (TextView) inflate(mContext,
                com.android.internal.R.layout.text_drag_thumbnail, null);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IllegalArgumentException("Unable to inflate text drag thumbnail");
        } //End block
        {
            boolean var8664184B362287947D63596A4517BCE2_869590629 = (text.length() > DRAG_SHADOW_MAX_TEXT_LENGTH);
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
        final int size;
        size = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        shadowView.measure(size, size);
        shadowView.layout(0, 0, shadowView.getMeasuredWidth(), shadowView.getMeasuredHeight());
        shadowView.invalidate();
        return (DragShadowBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.173 -0400", hash_original_method = "FE9E03D9F3FD52DB88C5DE28D1E8768B", hash_generated_method = "9076732ED18CE2918862863782C61531")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean performLongClick() {
        boolean handled;
        handled = false;
        boolean vibrate;
        vibrate = true;
        {
            boolean varC298D59926924FB0808A70DC864C4372_2080073073 = (super.performLongClick());
            {
                mDiscardNextActionUp = true;
                handled = true;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varC22EC044E5AC4CF0B865C252AF7A9AA6_596049865 = (!handled && !isPositionOnText(mLastDownPositionX, mLastDownPositionY) &&
                mInsertionControllerEnabled);
            {
                final int offset;
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
                boolean var6D40024296296040632FE8120E16CDA8_376649195 = (touchPositionIsInSelection());
                {
                    final int start;
                    start = getSelectionStart();
                    final int end;
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.174 -0400", hash_original_method = "227669F89CB3324004EC787BF93F591D", hash_generated_method = "F0ECB0BD26F8D67C1F6E1E024E0C7094")
    @DSModeled(DSC.SAFE)
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.174 -0400", hash_original_method = "A2BF41305999CD5C7E75DA3423749804", hash_generated_method = "6D84C0E52AA793CEACFBFDC4F7435F2B")
    @DSModeled(DSC.SAFE)
    private PositionListener getPositionListener() {
        {
            mPositionListener = new PositionListener();
        } //End block
        return (PositionListener)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mPositionListener == null) {
            //mPositionListener = new PositionListener();
        //}
        //return mPositionListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.174 -0400", hash_original_method = "23179C09AF51D00D4FCF53E6D8173595", hash_generated_method = "C2235EF4F12FCB0F9F5B9C4729A22640")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isPositionVisible(int positionX, int positionY) {
        dsTaint.addTaint(positionX);
        dsTaint.addTaint(positionY);
        {
            final float[] position;
            position = sTmpPosition;
            position[0] = positionX;
            position[1] = positionY;
            View view;
            view = this;
            {
                {
                    position[0] -= view.getScrollX();
                    position[1] -= view.getScrollY();
                } //End block
                {
                    boolean varCC3EA170661AE32B143B6B8CB851A271_886518071 = (position[0] < 0 || position[1] < 0 ||
                        position[0] > view.getWidth() || position[1] > view.getHeight());
                } //End collapsed parenthetic
                {
                    boolean var020714D8D65A6851489742B00823B874_113164812 = (!view.getMatrix().isIdentity());
                    {
                        view.getMatrix().mapPoints(position);
                    } //End block
                } //End collapsed parenthetic
                position[0] += view.getLeft();
                position[1] += view.getTop();
                final ViewParent parent;
                parent = view.getParent();
                {
                    view = (View) parent;
                } //End block
                {
                    view = null;
                } //End block
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.174 -0400", hash_original_method = "51F76D7934106C8713E6D720A3BD9BE7", hash_generated_method = "59B048ACE2D539C0ED90CDF2BBAA44B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isOffsetVisible(int offset) {
        dsTaint.addTaint(offset);
        final int line;
        line = mLayout.getLineForOffset(offset);
        final int lineBottom;
        lineBottom = mLayout.getLineBottom(line);
        final int primaryHorizontal;
        primaryHorizontal = (int) mLayout.getPrimaryHorizontal(offset);
        boolean varD4446F991D74BA64F3AC992B6F4738F8_245031823 = (isPositionVisible(primaryHorizontal + viewportToContentHorizontalOffset(),
                lineBottom + viewportToContentVerticalOffset()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int line = mLayout.getLineForOffset(offset);
        //final int lineBottom = mLayout.getLineBottom(line);
        //final int primaryHorizontal = (int) mLayout.getPrimaryHorizontal(offset);
        //return isPositionVisible(primaryHorizontal + viewportToContentHorizontalOffset(),
                //lineBottom + viewportToContentVerticalOffset());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.174 -0400", hash_original_method = "8567BA4CA284138DD0CB4B48B9C8C278", hash_generated_method = "19436A22C145E9113C2B4639CA244B31")
    @DSModeled(DSC.SAFE)
    @Override
    protected void onScrollChanged(int horiz, int vert, int oldHoriz, int oldVert) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(horiz);
        dsTaint.addTaint(vert);
        dsTaint.addTaint(oldVert);
        dsTaint.addTaint(oldHoriz);
        super.onScrollChanged(horiz, vert, oldHoriz, oldVert);
        {
            mPositionListener.onScrollChanged();
        } //End block
        // ---------- Original Method ----------
        //super.onScrollChanged(horiz, vert, oldHoriz, oldVert);
        //if (mPositionListener != null) {
            //mPositionListener.onScrollChanged();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.174 -0400", hash_original_method = "9FAF02695A10AC660CF2B5DD3EDB7DD4", hash_generated_method = "B093D0AA6ED9D475C187A839FEAD3EA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     CharSequence removeSuggestionSpans(CharSequence text) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(text);
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
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.174 -0400", hash_original_method = "97397C66433481C877E194A1E7813AF3", hash_generated_method = "8A39CD1B1AD7ADF8966320554862E152")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.175 -0400", hash_original_method = "E5A6F19BA20AF228602A3EAA320E6192", hash_generated_method = "E33D88D337FDEA080C825619B0D668A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean areSuggestionsShown() {
        boolean var29FA41D6182C8FCF2B2C7ECDA0C38EBD_1999543346 = (mSuggestionsPopupWindow != null && mSuggestionsPopupWindow.isShowing());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSuggestionsPopupWindow != null && mSuggestionsPopupWindow.isShowing();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.175 -0400", hash_original_method = "25A5AF708197CD0F2143471E812F624E", hash_generated_method = "FD8DD0BC14321497D91E287A1D76D5F8")
    @DSModeled(DSC.SAFE)
    public boolean isSuggestionsEnabled() {
        final int variation;
        variation = mInputType & EditorInfo.TYPE_MASK_VARIATION;
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.175 -0400", hash_original_method = "9876FACCD4EAE43EA4CB6FD414FD5E5A", hash_generated_method = "48EFC13993992622C903FA5B03FAAF99")
    @DSModeled(DSC.SAFE)
    public void setCustomSelectionActionModeCallback(ActionMode.Callback actionModeCallback) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(actionModeCallback.dsTaint);
        // ---------- Original Method ----------
        //mCustomSelectionActionModeCallback = actionModeCallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.175 -0400", hash_original_method = "6671930C0B8994CBEF8AFBE835B485C8", hash_generated_method = "5571163D69DA0D3C15F375F9BEAA57C7")
    @DSModeled(DSC.SAFE)
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return (ActionMode.Callback)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCustomSelectionActionModeCallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.175 -0400", hash_original_method = "B9B1CE7E81D0AD0E9224682576CA1ABE", hash_generated_method = "6EE3489C396D4140F404D3078F1C6881")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean startSelectionActionMode() {
        {
            boolean varDD51C7CC25E36170CF1A5B45DEEBD783_75944539 = (!canSelectText() || !requestFocus());
        } //End collapsed parenthetic
        {
            boolean varD18B2E3785F2697D3F393507C051114C_1316045921 = (!hasSelection());
            {
                {
                    boolean var2694D05A2D7BEB6A7092F61157ECE50C_1539181027 = (!selectCurrentWord());
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
        final boolean selectionStarted;
        selectionStarted = mSelectionActionMode != null || willExtract;
        {
            final InputMethodManager imm;
            imm = InputMethodManager.peekInstance();
            {
                imm.showSoftInput(this, 0, null);
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.175 -0400", hash_original_method = "F292596F6DB6F0A1BCB4946717902139", hash_generated_method = "731723A2784C39E8EA8BD3AE73720981")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean extractedTextModeWillBeStarted() {
        {
            final InputMethodManager imm;
            imm = InputMethodManager.peekInstance();
            boolean var2F4E2C66FC57F06F55546BB121BBAB53_191430236 = (imm != null && imm.isFullscreenMode());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!(this instanceof ExtractEditText)) {
            //final InputMethodManager imm = InputMethodManager.peekInstance();
            //return  imm != null && imm.isFullscreenMode();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.175 -0400", hash_original_method = "9843C3F333617B8C113B72E2C38319BA", hash_generated_method = "E5C8D4FD8E2343F3654845E2A4DC9C41")
    @DSModeled(DSC.SAFE)
    private void stopSelectionActionMode() {
        {
            mSelectionActionMode.finish();
        } //End block
        // ---------- Original Method ----------
        //if (mSelectionActionMode != null) {
            //mSelectionActionMode.finish();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.175 -0400", hash_original_method = "FD893A1B640E2E356DBE924FBE58EA4D", hash_generated_method = "48D1250BCCE3E2BF8B744E6B018AB4BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void paste(int min, int max) {
        dsTaint.addTaint(min);
        dsTaint.addTaint(max);
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
                boolean varCF4CF6A541CEE14E85EAE2AF810764AC_1299048926 = (i<clip.getItemCount());
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.175 -0400", hash_original_method = "8BE6A63416328BC319B0B5D0DB32AF7B", hash_generated_method = "770EBFF6D9E86FE5912B69733D32EE11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setPrimaryClip(ClipData clip) {
        dsTaint.addTaint(clip.dsTaint);
        ClipboardManager clipboard;
        clipboard = (ClipboardManager) getContext().
                getSystemService(Context.CLIPBOARD_SERVICE);
        clipboard.setPrimaryClip(clip);
        sLastCutOrCopyTime = SystemClock.uptimeMillis();
        // ---------- Original Method ----------
        //ClipboardManager clipboard = (ClipboardManager) getContext().
                //getSystemService(Context.CLIPBOARD_SERVICE);
        //clipboard.setPrimaryClip(clip);
        //sLastCutOrCopyTime = SystemClock.uptimeMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.176 -0400", hash_original_method = "EC32E229F62759229A3F9E53D2729660", hash_generated_method = "39D8019582CBEDEF2F96A32F244C3C86")
    @DSModeled(DSC.SAFE)
    private void hideInsertionPointCursorController() {
        {
            mInsertionPointCursorController.hide();
        } //End block
        // ---------- Original Method ----------
        //if (mInsertionPointCursorController != null) {
            //mInsertionPointCursorController.hide();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.176 -0400", hash_original_method = "24BE7797312EE966374B6FFCFBB4586E", hash_generated_method = "5F333164C622046F3D80B95C6784B92C")
    @DSModeled(DSC.SAFE)
    private void hideControllers() {
        hideCursorControllers();
        hideSpanControllers();
        // ---------- Original Method ----------
        //hideCursorControllers();
        //hideSpanControllers();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.176 -0400", hash_original_method = "49CA1E2702021EF560B250FA375633C6", hash_generated_method = "E257E2671B5E7746CF5E81FB5922AFDE")
    @DSModeled(DSC.SAFE)
    private void hideSpanControllers() {
        {
            mChangeWatcher.hideControllers();
        } //End block
        // ---------- Original Method ----------
        //if (mChangeWatcher != null) {
            //mChangeWatcher.hideControllers();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.176 -0400", hash_original_method = "1E18C93748F74C8EE354333AE329FDA3", hash_generated_method = "C9DCEEBE8D40B20CFF0B7CAF63824949")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void hideCursorControllers() {
        {
            boolean var97060A385B2EE20942D359972C3B987E_711179684 = (mSuggestionsPopupWindow != null && !mSuggestionsPopupWindow.isShowingUp());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.176 -0400", hash_original_method = "3AC7FDA43CAD0B3033F953FC5E229096", hash_generated_method = "69599A1C0C87D062981FFF24419A8024")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getOffsetForPosition(float x, float y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        {
            boolean var778B744EBE60DF815BEE98852B413FC5_683991099 = (getLayout() == null);
        } //End collapsed parenthetic
        final int line;
        line = getLineAtCoordinate(y);
        final int offset;
        offset = getOffsetAtCoordinate(line, x);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (getLayout() == null) return -1;
        //final int line = getLineAtCoordinate(y);
        //final int offset = getOffsetAtCoordinate(line, x);
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.176 -0400", hash_original_method = "C0F2EACF537DEE598E512FB7710303B4", hash_generated_method = "21892A994F8E03116922D245CD43531E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private float convertToLocalHorizontalCoordinate(float x) {
        dsTaint.addTaint(x);
        x -= getTotalPaddingLeft();
        x = Math.max(0.0f, x);
        x = Math.min(getWidth() - getTotalPaddingRight() - 1, x);
        x += getScrollX();
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //x -= getTotalPaddingLeft();
        //x = Math.max(0.0f, x);
        //x = Math.min(getWidth() - getTotalPaddingRight() - 1, x);
        //x += getScrollX();
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.176 -0400", hash_original_method = "69F0EDA2749521F4A39C0BEAC846F1E5", hash_generated_method = "B89B48E81A7A1F408F4E38466449AB82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getLineAtCoordinate(float y) {
        dsTaint.addTaint(y);
        y -= getTotalPaddingTop();
        y = Math.max(0.0f, y);
        y = Math.min(getHeight() - getTotalPaddingBottom() - 1, y);
        y += getScrollY();
        int var6DD28032E606AA4BF99A53AB522278D5_1824855486 = (getLayout().getLineForVertical((int) y));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //y -= getTotalPaddingTop();
        //y = Math.max(0.0f, y);
        //y = Math.min(getHeight() - getTotalPaddingBottom() - 1, y);
        //y += getScrollY();
        //return getLayout().getLineForVertical((int) y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.176 -0400", hash_original_method = "78600135096D77C91825CF9049D3F243", hash_generated_method = "2F6018EA3527034D52441B30BC6A9E15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getOffsetAtCoordinate(int line, float x) {
        dsTaint.addTaint(line);
        dsTaint.addTaint(x);
        x = convertToLocalHorizontalCoordinate(x);
        int varD73392C253D779C86FFAE24ED89F63F1_1963891356 = (getLayout().getOffsetForHorizontal(line, x));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //x = convertToLocalHorizontalCoordinate(x);
        //return getLayout().getOffsetForHorizontal(line, x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.176 -0400", hash_original_method = "B77333C8EDA86B5BA4A004A4B129217A", hash_generated_method = "4031DE7435E0A57094D3FEC858E269D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isPositionOnText(float x, float y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        {
            boolean var778B744EBE60DF815BEE98852B413FC5_1624450727 = (getLayout() == null);
        } //End collapsed parenthetic
        final int line;
        line = getLineAtCoordinate(y);
        x = convertToLocalHorizontalCoordinate(x);
        {
            boolean var59E035AC6E596093F53E603EDA382B91_4703262 = (x < getLayout().getLineLeft(line));
        } //End collapsed parenthetic
        {
            boolean var04BE7C77E8AA35EC39BE529B038AF3DD_2019151683 = (x > getLayout().getLineRight(line));
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (getLayout() == null) return false;
        //final int line = getLineAtCoordinate(y);
        //x = convertToLocalHorizontalCoordinate(x);
        //if (x < getLayout().getLineLeft(line)) return false;
        //if (x > getLayout().getLineRight(line)) return false;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.176 -0400", hash_original_method = "282C8F5427700D40A542E64F343C6674", hash_generated_method = "52E75EEDBCFE78D72C3650ADC0253BD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onDragEvent(DragEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        {
            Object var9E1FBD251DF7E53AB77C3A31F15B2B38_1060395162 = (event.getAction());
            //Begin case DragEvent.ACTION_DRAG_STARTED 
            boolean varB5182ED29788A31653E5E1546400D879_581680508 = (hasInsertionController());
            //End case DragEvent.ACTION_DRAG_STARTED 
            //Begin case DragEvent.ACTION_DRAG_ENTERED 
            TextView.this.requestFocus();
            //End case DragEvent.ACTION_DRAG_ENTERED 
            //Begin case DragEvent.ACTION_DRAG_LOCATION 
            final int offset;
            offset = getOffsetForPosition(event.getX(), event.getY());
            //End case DragEvent.ACTION_DRAG_LOCATION 
            //Begin case DragEvent.ACTION_DRAG_LOCATION 
            Selection.setSelection((Spannable)mText, offset);
            //End case DragEvent.ACTION_DRAG_LOCATION 
            //Begin case DragEvent.ACTION_DROP 
            onDrop(event);
            //End case DragEvent.ACTION_DROP 
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.177 -0400", hash_original_method = "89464BC34879AFE88152B04970AA44D2", hash_generated_method = "554853D115A1FF4FD5201FF76D3A65C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onDrop(DragEvent event) {
        dsTaint.addTaint(event.dsTaint);
        StringBuilder content;
        content = new StringBuilder("");
        ClipData clipData;
        clipData = event.getClipData();
        final int itemCount;
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
        final int offset;
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
        final int originalLength;
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
                final int shift;
                shift = mText.length() - originalLength;
                dragSourceStart += shift;
                dragSourceEnd += shift;
            } //End block
            deleteText_internal(dragSourceStart, dragSourceEnd);
            {
                boolean var353A6E4F7751153EED06FB844C167F01_461772085 = ((dragSourceStart == 0 ||
                    Character.isSpaceChar(mTransformed.charAt(dragSourceStart - 1))) &&
                    (dragSourceStart == mText.length() ||
                    Character.isSpaceChar(mTransformed.charAt(dragSourceStart))));
                {
                    /*final*/ int pos;
                    boolean var518448CA6AC99CEB1166FD5287784237_1039911499 = (dragSourceStart == mText.length());
                    pos = dragSourceStart - 1;
                    pos = dragSourceStart;
                    deleteText_internal(pos, pos + 1);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.177 -0400", hash_original_method = "91BB575EAEE11A270473B31B356B5B12", hash_generated_method = "DBD11980A52B66C9307A05665D96E670")
    @DSModeled(DSC.SAFE)
     boolean hasInsertionController() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mInsertionControllerEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.177 -0400", hash_original_method = "EE05979336406D2A8CCC57049072454C", hash_generated_method = "2F11BB84B084413434FE63FD3657461F")
    @DSModeled(DSC.SAFE)
     boolean hasSelectionController() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSelectionControllerEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.177 -0400", hash_original_method = "02A03A91466BF03F45C3C819266A605E", hash_generated_method = "E7B19BED26D08DF4D857AA86A5A5E5D6")
    @DSModeled(DSC.SAFE)
     InsertionPointCursorController getInsertionController() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mInsertionPointCursorController = new InsertionPointCursorController();
            final ViewTreeObserver observer;
            observer = getViewTreeObserver();
            observer.addOnTouchModeChangeListener(mInsertionPointCursorController);
        } //End block
        return (InsertionPointCursorController)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.177 -0400", hash_original_method = "CD09732805D28B5BF513C98008463942", hash_generated_method = "0B9C238CCFF2A3AC0256D25227CA5037")
    @DSModeled(DSC.SAFE)
     SelectionModifierCursorController getSelectionController() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mSelectionModifierCursorController = new SelectionModifierCursorController();
            final ViewTreeObserver observer;
            observer = getViewTreeObserver();
            observer.addOnTouchModeChangeListener(mSelectionModifierCursorController);
        } //End block
        return (SelectionModifierCursorController)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.177 -0400", hash_original_method = "2A090273FA835CA26EC17C458A37DEC8", hash_generated_method = "DEF2319451ADC133E5F6BC755356F370")
    @DSModeled(DSC.SAFE)
     boolean isInBatchEditMode() {
        final InputMethodState ims;
        ims = mInputMethodState;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final InputMethodState ims = mInputMethodState;
        //if (ims != null) {
            //return ims.mBatchEditNesting > 0;
        //}
        //return mInBatchEditControllers;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.177 -0400", hash_original_method = "6388CB4B4CF218043B88410FEBCF8F11", hash_generated_method = "A801D7E89426CC45DDDFD6EA5BDCA23A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void resolveTextDirection() {
        {
            boolean varAFBCCFFAA18696A12B6915A938CC8475_1574535881 = (hasPasswordTransformationMethod());
            {
                mTextDir = TextDirectionHeuristics.LOCALE;
            } //End block
        } //End collapsed parenthetic
        final boolean defaultIsRtl;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.178 -0400", hash_original_method = "E2C9FAE08740394CAC2960942379DB19", hash_generated_method = "EB966E9FCDFD74E723A7AD1694DDC086")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void resolveDrawables() {
        {
            mResolvedDrawables = true;
        } //End block
        Drawables dr;
        dr = mDrawables;
        {
            Object varAFC6EB2C684D509A17B3A4EFF5D9CB9D_1747278823 = (getResolvedLayoutDirection());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.178 -0400", hash_original_method = "18FE12CF478DF44CED567E30FAAD0C93", hash_generated_method = "653942155A7AC109F0415301B0B31B2C")
    @DSModeled(DSC.SAFE)
    protected void resetResolvedDrawables() {
        mResolvedDrawables = false;
        // ---------- Original Method ----------
        //mResolvedDrawables = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.178 -0400", hash_original_method = "6AA5A1E8B49AF4D4943616613CE0B2E3", hash_generated_method = "1460F2394E5A0E488FA165AB55AF908F")
    @DSModeled(DSC.SAFE)
    protected void viewClicked(InputMethodManager imm) {
        dsTaint.addTaint(imm.dsTaint);
        {
            imm.viewClicked(this);
        } //End block
        // ---------- Original Method ----------
        //if (imm != null) {
            //imm.viewClicked(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.178 -0400", hash_original_method = "D7BCF3915857A038F77C712DE4BFFF5D", hash_generated_method = "0183277F9F73D15B895BA928B6F44DEC")
    @DSModeled(DSC.SAFE)
    protected void deleteText_internal(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        ((Editable) mText).delete(start, end);
        // ---------- Original Method ----------
        //((Editable) mText).delete(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.178 -0400", hash_original_method = "2F865B1F2B94D9294078802BAAEABE19", hash_generated_method = "C684D6CBF34A4F1014072EF203FC80B7")
    @DSModeled(DSC.SAFE)
    protected void replaceText_internal(int start, int end, CharSequence text) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        ((Editable) mText).replace(start, end, text);
        // ---------- Original Method ----------
        //((Editable) mText).replace(start, end, text);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.178 -0400", hash_original_method = "80E41DC8CAFBEBBFCDBF175A54ED075C", hash_generated_method = "26E212CF6ABF7F0536824B595CAA80A6")
    @DSModeled(DSC.SAFE)
    protected void setSpan_internal(Object span, int start, int end, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        dsTaint.addTaint(span.dsTaint);
        ((Editable) mText).setSpan(span, start, end, flags);
        // ---------- Original Method ----------
        //((Editable) mText).setSpan(span, start, end, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.178 -0400", hash_original_method = "ED942619162EB0C0AFB16CB348D15185", hash_generated_method = "60F03CDC3EAB69E714B86E7ED962F580")
    @DSModeled(DSC.SAFE)
    protected void setCursorPosition_internal(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        Selection.setSelection(((Editable) mText), start, end);
        // ---------- Original Method ----------
        //Selection.setSelection(((Editable) mText), start, end);
    }

    
    static class Drawables {
        final Rect mCompoundRect = new Rect();
        Drawable mDrawableTop, mDrawableBottom, mDrawableLeft, mDrawableRight,
                mDrawableStart, mDrawableEnd;
        int mDrawableSizeTop, mDrawableSizeBottom, mDrawableSizeLeft, mDrawableSizeRight,
                mDrawableSizeStart, mDrawableSizeEnd;
        int mDrawableWidthTop, mDrawableWidthBottom, mDrawableHeightLeft, mDrawableHeightRight,
                mDrawableHeightStart, mDrawableHeightEnd;
        int mDrawablePadding;
        
    }


    
    static class InputContentType {
        int imeOptions = EditorInfo.IME_NULL;
        String privateImeOptions;
        CharSequence imeActionLabel;
        int imeActionId;
        Bundle extras;
        OnEditorActionListener onEditorActionListener;
        boolean enterDown;
        
    }


    
    static class InputMethodState {
        Rect mCursorRectInWindow = new Rect();
        RectF mTmpRectF = new RectF();
        float[] mTmpOffset = new float[2];
        ExtractedTextRequest mExtracting;
        final ExtractedText mTmpExtracted = new ExtractedText();
        int mBatchEditNesting;
        boolean mCursorChanged;
        boolean mSelectionModeChanged;
        boolean mContentChanged;
        int mChangedStart, mChangedEnd, mChangedDelta;
        
    }


    
    private static enum TextAlign {
        INHERIT, GRAVITY, TEXT_START, TEXT_END, CENTER, VIEW_START, VIEW_END;
    }

    
    public static class SavedState extends BaseSavedState {
        int selStart;
        int selEnd;
        CharSequence text;
        boolean frozenWithFocus;
        CharSequence error;
        @SuppressWarnings("hiding") public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.178 -0400", hash_original_method = "E26812089C072DDE1A14AECAA6CD6686", hash_generated_method = "6C6B0A873BD52E2752F88E9968D483CA")
            @DSModeled(DSC.SAFE)
            public SavedState createFromParcel(Parcel in) {
                dsTaint.addTaint(in.dsTaint);
                return (SavedState)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new SavedState(in);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.178 -0400", hash_original_method = "2D31E9CBAAAE05B696D738324F87FF78", hash_generated_method = "1325778BB443F872513E70F9A19C5918")
            @DSModeled(DSC.SAFE)
            public SavedState[] newArray(int size) {
                dsTaint.addTaint(size);
                return (SavedState[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new SavedState[size];
            }

            
}; //Transformed anonymous class
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.178 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "BBD854AA7A117C86D9FBF897ADE36FE1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SavedState(Parcelable superState) {
            super(superState);
            dsTaint.addTaint(superState.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.178 -0400", hash_original_method = "37D3E7AD53C42A47440A9F9D38DFF900", hash_generated_method = "CE9B4B43F262FAC3A3E791B374275AB4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private SavedState(Parcel in) {
            super(in);
            dsTaint.addTaint(in.dsTaint);
            selStart = in.readInt();
            selEnd = in.readInt();
            frozenWithFocus = (in.readInt() != 0);
            text = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
            {
                boolean var331417C59A822E59FB0B216D2F29CB47_1961775847 = (in.readInt() != 0);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.179 -0400", hash_original_method = "0917C7384BCC053D7DFEC5346FB5EF0D", hash_generated_method = "2103B0C4F0CB59EBD036007AAC4FB3CB")
        @DSModeled(DSC.SAFE)
        @Override
        public void writeToParcel(Parcel out, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(out.dsTaint);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.179 -0400", hash_original_method = "B2667A033A504E8795AC5B896DD98B5F", hash_generated_method = "0589E698B1525C9AC981AA2DA56A31FD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String str;
            str = "TextView.SavedState{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " start=" + selStart + " end=" + selEnd;
            {
                str += " text=" + text;
            } //End block
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //String str = "TextView.SavedState{"
                    //+ Integer.toHexString(System.identityHashCode(this))
                    //+ " start=" + selStart + " end=" + selEnd;
            //if (text != null) {
                //str += " text=" + text;
            //}
            //return str + "}";
        }

        
    }


    
    private static class CharWrapper implements CharSequence, GetChars, GraphicsOperations {
        private char[] mChars;
        private int mStart, mLength;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.179 -0400", hash_original_method = "91EFB0F7C01F6A5A0D8B3974D02E0951", hash_generated_method = "DC1DD2B0EB2DD62A9EF4071A29EE7187")
        @DSModeled(DSC.SAFE)
        public CharWrapper(char[] chars, int start, int len) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(chars);
            dsTaint.addTaint(len);
            // ---------- Original Method ----------
            //mChars = chars;
            //mStart = start;
            //mLength = len;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.179 -0400", hash_original_method = "9DC2F69D47DD9984FB3378BE28468419", hash_generated_method = "855B5103325DD7CE1B50B5CF117CC647")
        @DSModeled(DSC.SAFE)
         void set(char[] chars, int start, int len) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(chars);
            dsTaint.addTaint(len);
            // ---------- Original Method ----------
            //mChars = chars;
            //mStart = start;
            //mLength = len;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.179 -0400", hash_original_method = "C0D624CC7CEFFAF650D54F4FB963FAF6", hash_generated_method = "E88F9A3FF76C14C0BB1A084B2CA56712")
        @DSModeled(DSC.SAFE)
        public int length() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mLength;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.179 -0400", hash_original_method = "02B707818F2669493B94939B301EE67F", hash_generated_method = "66A09420698002542C2D7D8D7C7C209F")
        @DSModeled(DSC.SAFE)
        public char charAt(int off) {
            dsTaint.addTaint(off);
            return dsTaint.getTaintChar();
            // ---------- Original Method ----------
            //return mChars[off + mStart];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.179 -0400", hash_original_method = "16BC7956BCD83D2479A5892A7E5C0E12", hash_generated_method = "8059471C5627D328C1B72A7DB4FCE6D4")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return new String(mChars, mStart, mLength);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.179 -0400", hash_original_method = "BA853CED33F98EDEC6E428BC258874A3", hash_generated_method = "7CBB9687A6FE73BB1A534F2C83D51D17")
        @DSModeled(DSC.SAFE)
        public CharSequence subSequence(int start, int end) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(end);
            if (DroidSafeAndroidRuntime.control)
            {
                throw new IndexOutOfBoundsException(start + ", " + end);
            } //End block
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //if (start < 0 || end < 0 || start > mLength || end > mLength) {
                //throw new IndexOutOfBoundsException(start + ", " + end);
            //}
            //return new String(mChars, start + mStart, end - start);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.179 -0400", hash_original_method = "BA41D2BD366E4073F3399B79828CDD69", hash_generated_method = "18A3028998431C1386B2A0BE231EFB81")
        @DSModeled(DSC.SAFE)
        public void getChars(int start, int end, char[] buf, int off) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(off);
            dsTaint.addTaint(end);
            dsTaint.addTaint(buf);
            if (DroidSafeAndroidRuntime.control)
            {
                throw new IndexOutOfBoundsException(start + ", " + end);
            } //End block
            System.arraycopy(mChars, start + mStart, buf, off, end - start);
            // ---------- Original Method ----------
            //if (start < 0 || end < 0 || start > mLength || end > mLength) {
                //throw new IndexOutOfBoundsException(start + ", " + end);
            //}
            //System.arraycopy(mChars, start + mStart, buf, off, end - start);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.179 -0400", hash_original_method = "69B7B91382C25765CF25BB95E9C19951", hash_generated_method = "75179EB17546530639005A7823D11703")
        @DSModeled(DSC.SAFE)
        public void drawText(Canvas c, int start, int end,
                             float x, float y, Paint p) {
            dsTaint.addTaint(c.dsTaint);
            dsTaint.addTaint(start);
            dsTaint.addTaint(p.dsTaint);
            dsTaint.addTaint(end);
            dsTaint.addTaint(y);
            dsTaint.addTaint(x);
            c.drawText(mChars, start + mStart, end - start, x, y, p);
            // ---------- Original Method ----------
            //c.drawText(mChars, start + mStart, end - start, x, y, p);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.179 -0400", hash_original_method = "7645CF39D6B95BCD64DC33FB4F483F74", hash_generated_method = "E4A110CA975934103E54B256409FB2F5")
        @DSModeled(DSC.SAFE)
        public void drawTextRun(Canvas c, int start, int end,
                int contextStart, int contextEnd, float x, float y, int flags, Paint p) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(c.dsTaint);
            dsTaint.addTaint(start);
            dsTaint.addTaint(contextStart);
            dsTaint.addTaint(p.dsTaint);
            dsTaint.addTaint(end);
            dsTaint.addTaint(y);
            dsTaint.addTaint(contextEnd);
            dsTaint.addTaint(x);
            int count;
            count = end - start;
            int contextCount;
            contextCount = contextEnd - contextStart;
            c.drawTextRun(mChars, start + mStart, count, contextStart + mStart,
                    contextCount, x, y, flags, p);
            // ---------- Original Method ----------
            //int count = end - start;
            //int contextCount = contextEnd - contextStart;
            //c.drawTextRun(mChars, start + mStart, count, contextStart + mStart,
                    //contextCount, x, y, flags, p);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.180 -0400", hash_original_method = "4FA2C1189F8B48AEDF7B10BEDFF84543", hash_generated_method = "7B774A4B40AB1A914A17DD2E1E9425C0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public float measureText(int start, int end, Paint p) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(p.dsTaint);
            dsTaint.addTaint(end);
            float var5A7F792133FF7C4A81B497C5A4720CB1_177905201 = (p.measureText(mChars, start + mStart, end - start));
            return dsTaint.getTaintFloat();
            // ---------- Original Method ----------
            //return p.measureText(mChars, start + mStart, end - start);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.180 -0400", hash_original_method = "E75F381DB76AB16AB72FA7895D0F4EE0", hash_generated_method = "6BB842E04631303075CE93E2B49A44CB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getTextWidths(int start, int end, float[] widths, Paint p) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(p.dsTaint);
            dsTaint.addTaint(widths);
            dsTaint.addTaint(end);
            int varE3ED158C14EA094EB292BB32B5DD8EF6_1994703361 = (p.getTextWidths(mChars, start + mStart, end - start, widths));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return p.getTextWidths(mChars, start + mStart, end - start, widths);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.180 -0400", hash_original_method = "8AE304950D3C27A7D6E58BA388580EF8", hash_generated_method = "26EF1097E6335E5621CB700EB79A07EB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public float getTextRunAdvances(int start, int end, int contextStart,
                int contextEnd, int flags, float[] advances, int advancesIndex,
                Paint p) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(start);
            dsTaint.addTaint(contextStart);
            dsTaint.addTaint(p.dsTaint);
            dsTaint.addTaint(advances);
            dsTaint.addTaint(end);
            dsTaint.addTaint(contextEnd);
            dsTaint.addTaint(advancesIndex);
            int count;
            count = end - start;
            int contextCount;
            contextCount = contextEnd - contextStart;
            float var95DA16B05752FC715454FE8979E745DE_1652191358 = (p.getTextRunAdvances(mChars, start + mStart, count,
                    contextStart + mStart, contextCount, flags, advances,
                    advancesIndex));
            return dsTaint.getTaintFloat();
            // ---------- Original Method ----------
            //int count = end - start;
            //int contextCount = contextEnd - contextStart;
            //return p.getTextRunAdvances(mChars, start + mStart, count,
                    //contextStart + mStart, contextCount, flags, advances,
                    //advancesIndex);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.180 -0400", hash_original_method = "F8F49F104CF6E56864F062F013326F8E", hash_generated_method = "B18CBE1BE27CE1CF3AAA66B28B99A4F1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public float getTextRunAdvances(int start, int end, int contextStart,
                int contextEnd, int flags, float[] advances, int advancesIndex,
                Paint p, int reserved) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(start);
            dsTaint.addTaint(contextStart);
            dsTaint.addTaint(p.dsTaint);
            dsTaint.addTaint(advances);
            dsTaint.addTaint(reserved);
            dsTaint.addTaint(end);
            dsTaint.addTaint(contextEnd);
            dsTaint.addTaint(advancesIndex);
            int count;
            count = end - start;
            int contextCount;
            contextCount = contextEnd - contextStart;
            float var96D3717415879B74E71057007515D708_48348676 = (p.getTextRunAdvances(mChars, start + mStart, count,
                    contextStart + mStart, contextCount, flags, advances,
                    advancesIndex, reserved));
            return dsTaint.getTaintFloat();
            // ---------- Original Method ----------
            //int count = end - start;
            //int contextCount = contextEnd - contextStart;
            //return p.getTextRunAdvances(mChars, start + mStart, count,
                    //contextStart + mStart, contextCount, flags, advances,
                    //advancesIndex, reserved);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.180 -0400", hash_original_method = "BDCC8CC855D861C4246044B3842097FC", hash_generated_method = "5548359596BCCAC886E0962080925C45")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getTextRunCursor(int contextStart, int contextEnd, int flags,
                int offset, int cursorOpt, Paint p) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(contextStart);
            dsTaint.addTaint(p.dsTaint);
            dsTaint.addTaint(cursorOpt);
            dsTaint.addTaint(offset);
            dsTaint.addTaint(contextEnd);
            int contextCount;
            contextCount = contextEnd - contextStart;
            int var068FAD7452971D895CA3E5455D974B2C_1869849544 = (p.getTextRunCursor(mChars, contextStart + mStart,
                    contextCount, flags, offset + mStart, cursorOpt));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int contextCount = contextEnd - contextStart;
            //return p.getTextRunCursor(mChars, contextStart + mStart,
                    //contextCount, flags, offset + mStart, cursorOpt);
        }

        
    }


    
    private static class ErrorPopup extends PopupWindow {
        private boolean mAbove = false;
        private /* final */ TextView mView;
        private int mPopupInlineErrorBackgroundId = 0;
        private int mPopupInlineErrorAboveBackgroundId = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.180 -0400", hash_original_method = "272870BAEDFD334116717C4E8AB7F4AA", hash_generated_method = "BB155E9BE4481FC74E40E3E9563B89DF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         ErrorPopup(TextView v, int width, int height) {
            super(v, width, height);
            dsTaint.addTaint(v.dsTaint);
            dsTaint.addTaint(height);
            dsTaint.addTaint(width);
            mPopupInlineErrorBackgroundId = getResourceId(mPopupInlineErrorBackgroundId,
                    com.android.internal.R.styleable.Theme_errorMessageBackground);
            mView.setBackgroundResource(mPopupInlineErrorBackgroundId);
            // ---------- Original Method ----------
            //mView = v;
            //mPopupInlineErrorBackgroundId = getResourceId(mPopupInlineErrorBackgroundId,
                    //com.android.internal.R.styleable.Theme_errorMessageBackground);
            //mView.setBackgroundResource(mPopupInlineErrorBackgroundId);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.180 -0400", hash_original_method = "FF785E3F959B10F16CB73DE59942CDE6", hash_generated_method = "792FF9AC4E3575D7D7DFDB9EC4FBA1D6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void fixDirection(boolean above) {
            dsTaint.addTaint(above);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.180 -0400", hash_original_method = "283134609ABCFB2A4CA7FFE3B421D4C1", hash_generated_method = "DCE327F480CFD548B6F97CF508145980")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private int getResourceId(int currentId, int index) {
            dsTaint.addTaint(index);
            dsTaint.addTaint(currentId);
            {
                TypedArray styledAttributes;
                styledAttributes = mView.getContext().obtainStyledAttributes(
                        R.styleable.Theme);
                currentId = styledAttributes.getResourceId(index, 0);
                styledAttributes.recycle();
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (currentId == 0) {
                //TypedArray styledAttributes = mView.getContext().obtainStyledAttributes(
                        //R.styleable.Theme);
                //currentId = styledAttributes.getResourceId(index, 0);
                //styledAttributes.recycle();
            //}
            //return currentId;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.180 -0400", hash_original_method = "D12B38B9E303D838A7A28156EE92AFAA", hash_generated_method = "D68B9B93B05C8A9C2AB4843CDFBE11D7")
        @DSModeled(DSC.SAFE)
        @Override
        public void update(int x, int y, int w, int h, boolean force) {
            dsTaint.addTaint(w);
            dsTaint.addTaint(force);
            dsTaint.addTaint(y);
            dsTaint.addTaint(h);
            dsTaint.addTaint(x);
            super.update(x, y, w, h, force);
            boolean above;
            above = isAboveAnchor();
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
        private final Path mPath = new Path();
        private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        private int mStart, mEnd;
        private long mFadingStartTime;
        private final static int FADE_OUT_DURATION = 400;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.180 -0400", hash_original_method = "76400340233C9D40D55E8C6995EBADF6", hash_generated_method = "27028B5CABB86E3CA0E434D497E8151B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CorrectionHighlighter() {
            mPaint.setCompatibilityScaling(getResources().getCompatibilityInfo().applicationScale);
            mPaint.setStyle(Paint.Style.FILL);
            // ---------- Original Method ----------
            //mPaint.setCompatibilityScaling(getResources().getCompatibilityInfo().applicationScale);
            //mPaint.setStyle(Paint.Style.FILL);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.181 -0400", hash_original_method = "9DA46F38DADC56BDE7EACA06EAFC15FB", hash_generated_method = "FBA07139D4C4558705C2185F2B7AF14E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void highlight(CorrectionInfo info) {
            dsTaint.addTaint(info.dsTaint);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.181 -0400", hash_original_method = "F315418B1425EA36D28AB47D63F906BC", hash_generated_method = "A459392FCC35AD72391D889273ABB989")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void draw(Canvas canvas, int cursorOffsetVertical) {
            dsTaint.addTaint(canvas.dsTaint);
            dsTaint.addTaint(cursorOffsetVertical);
            {
                boolean var4DB6C275C605DA5ED2D731F7F8E79A54_1320575711 = (updatePath() && updatePaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.181 -0400", hash_original_method = "5CBDA1AAE290DD8920EE208B7E44B556", hash_generated_method = "AD4477A071F1147C85825D64D2C24584")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private boolean updatePaint() {
            final long duration;
            duration = SystemClock.uptimeMillis() - mFadingStartTime;
            final float coef;
            coef = 1.0f - (float) duration / FADE_OUT_DURATION;
            final int highlightColorAlpha;
            highlightColorAlpha = Color.alpha(mHighlightColor);
            final int color;
            color = (mHighlightColor & 0x00FFFFFF) +
                    ((int) (highlightColorAlpha * coef) << 24);
            mPaint.setColor(color);
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.181 -0400", hash_original_method = "77DEEE2C70776896B8DA6C9B8DAC8452", hash_generated_method = "5C5DA7D2D82DE1D83A824736B9FE48A2")
        @DSModeled(DSC.SAFE)
        private boolean updatePath() {
            final Layout layout;
            layout = TextView.this.mLayout;
            final int length;
            length = mText.length();
            int start;
            start = Math.min(length, mStart);
            int end;
            end = Math.min(length, mEnd);
            mPath.reset();
            TextView.this.mLayout.getSelectionPath(start, end, mPath);
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.181 -0400", hash_original_method = "E7B5FD6BE43D84566E63BFC892235B90", hash_generated_method = "5016544DF463572AB44C34909BBA9D9D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void invalidate(boolean delayed) {
            dsTaint.addTaint(delayed);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.181 -0400", hash_original_method = "4BD6A36A746D13E089BD00A9CC0A6FB7", hash_generated_method = "56A6B1F09C22B10DAD17481A72BF47E2")
        @DSModeled(DSC.SAFE)
        private void stopAnimation() {
            TextView.this.mCorrectionHighlighter = null;
            // ---------- Original Method ----------
            //TextView.this.mCorrectionHighlighter = null;
        }

        
    }


    
    private static final class Marquee extends Handler {
        private static final float MARQUEE_DELTA_MAX = 0.07f;
        private static final int MARQUEE_DELAY = 1200;
        private static final int MARQUEE_RESTART_DELAY = 1200;
        private static final int MARQUEE_RESOLUTION = 1000 / 30;
        private static final int MARQUEE_PIXELS_PER_SECOND = 30;
        private static final byte MARQUEE_STOPPED = 0x0;
        private static final byte MARQUEE_STARTING = 0x1;
        private static final byte MARQUEE_RUNNING = 0x2;
        private static final int MESSAGE_START = 0x1;
        private static final int MESSAGE_TICK = 0x2;
        private static final int MESSAGE_RESTART = 0x3;
        private final WeakReference<TextView> mView;
        private byte mStatus = MARQUEE_STOPPED;
        private final float mScrollUnit;
        private float mMaxScroll;
        float mMaxFadeScroll;
        private float mGhostStart;
        private float mGhostOffset;
        private float mFadeStop;
        private int mRepeatLimit;
        float mScroll;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.181 -0400", hash_original_method = "EC19D4EFFC7CC18F674B4C588B8FB87B", hash_generated_method = "77730606180FFA584068CB84DA0CB17C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Marquee(TextView v) {
            dsTaint.addTaint(v.dsTaint);
            final float density;
            density = v.getContext().getResources().getDisplayMetrics().density;
            mScrollUnit = (MARQUEE_PIXELS_PER_SECOND * density) / MARQUEE_RESOLUTION;
            mView = new WeakReference<TextView>(v);
            // ---------- Original Method ----------
            //final float density = v.getContext().getResources().getDisplayMetrics().density;
            //mScrollUnit = (MARQUEE_PIXELS_PER_SECOND * density) / MARQUEE_RESOLUTION;
            //mView = new WeakReference<TextView>(v);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.181 -0400", hash_original_method = "6484E5DEDF9A6D25913C9D3BAE668871", hash_generated_method = "927DB482B71F2E98A3293D2C41F28F8C")
        @DSModeled(DSC.SAFE)
        @Override
        public void handleMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
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
                {
                    mRepeatLimit--;
                } //End block
                start(mRepeatLimit);
            } //End block
            //End case MESSAGE_RESTART 
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.182 -0400", hash_original_method = "EE95900433272316B4E2225B22ADF455", hash_generated_method = "59C2BCEAC39E712819191A2C67C78947")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void tick() {
            removeMessages(MESSAGE_TICK);
            final TextView textView;
            textView = mView.get();
            {
                boolean var9E991AA08531BDDAB4E605F21C288264_859246964 = (textView != null && (textView.isFocused() || textView.isSelected()));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.182 -0400", hash_original_method = "559B799FFC0EAE80362A4924AC6B387F", hash_generated_method = "E05FA592BCF06507137BECD403B976BD")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.182 -0400", hash_original_method = "E75276DE0DCFDFD0F42F697FF2F53A01", hash_generated_method = "C926ED65AAC3B839330111C6CF57488A")
        @DSModeled(DSC.SAFE)
        private void resetScroll() {
            mScroll = 0.0f;
            final TextView textView;
            textView = mView.get();
            textView.invalidate();
            // ---------- Original Method ----------
            //mScroll = 0.0f;
            //final TextView textView = mView.get();
            //if (textView != null) textView.invalidate();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.182 -0400", hash_original_method = "C8CF1974A44593F9FA59199A16CE27AD", hash_generated_method = "13A61616C97D085290AC641A40D66A71")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void start(int repeatLimit) {
            dsTaint.addTaint(repeatLimit);
            {
                stop();
            } //End block
            final TextView textView;
            textView = mView.get();
            {
                mStatus = MARQUEE_STARTING;
                mScroll = 0.0f;
                final int textWidth;
                textWidth = textView.getWidth() - textView.getCompoundPaddingLeft() -
                        textView.getCompoundPaddingRight();
                final float lineWidth;
                lineWidth = textView.mLayout.getLineWidth(0);
                final float gap;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.182 -0400", hash_original_method = "8BEDD434588E893B08521C1E5E937982", hash_generated_method = "DE2AC8CC42E899426994F9C4F115A018")
        @DSModeled(DSC.SAFE)
         float getGhostOffset() {
            return dsTaint.getTaintFloat();
            // ---------- Original Method ----------
            //return mGhostOffset;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.182 -0400", hash_original_method = "FBB73F0BC2F425DEBE19335413BBBBD5", hash_generated_method = "5555F7F26B597080EA122E19E9E32BF6")
        @DSModeled(DSC.SAFE)
         boolean shouldDrawLeftFade() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mScroll <= mFadeStop;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.182 -0400", hash_original_method = "297E21CB54951ECF2F6E26FAB2DC7036", hash_generated_method = "122EC0003BE716A677A4821DCD71DC89")
        @DSModeled(DSC.SAFE)
         boolean shouldDrawGhost() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mStatus == MARQUEE_RUNNING && mScroll > mGhostStart;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.182 -0400", hash_original_method = "9069B9288EAB1BBCE4A11291BAF7E3F4", hash_generated_method = "DC9B14A40E87AA5F4E2E07C8A7F15B7F")
        @DSModeled(DSC.SAFE)
         boolean isRunning() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mStatus == MARQUEE_RUNNING;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.182 -0400", hash_original_method = "57F6027DED5DA77924B224C2BB22701E", hash_generated_method = "3E6FAEE7F70501F0833625D398BCA030")
        @DSModeled(DSC.SAFE)
         boolean isStopped() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mStatus == MARQUEE_STOPPED;
        }

        
    }


    
    private class EasyEditSpanController {
        private static final int DISPLAY_TIMEOUT_MS = 3000;
        private EasyEditPopupWindow mPopupWindow;
        private EasyEditSpan mEasyEditSpan;
        private Runnable mHidePopup;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.182 -0400", hash_original_method = "EDC90536D8A41E1495260C5D2B0A4CB4", hash_generated_method = "28CB76A62522243DB4F9DBA907315D53")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.183 -0400", hash_original_method = "400D6F397C7E694E5D2CC26E5076AFF1", hash_generated_method = "5E03E94C566B2CB4324BC996BE33DCE6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onTextChange(CharSequence buffer) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(buffer);
            adjustSpans(mText);
            {
                boolean varF8A6C8295E7EAA2547FD83421DD5A52E_1439643382 = (getWindowVisibility() != View.VISIBLE);
            } //End collapsed parenthetic
            InputMethodManager imm;
            imm = InputMethodManager.peekInstance();
            {
                boolean var508564AC928822EB83F33B379556AE9E_1009834705 = (!(TextView.this instanceof ExtractEditText)
                    && imm != null && imm.isFullscreenMode());
            } //End collapsed parenthetic
            {
                {
                    ((Spannable) mText).removeSpan(mEasyEditSpan);
                } //End block
                mEasyEditSpan = null;
            } //End block
            {
                boolean varB1ED909A9B3812E269C4F5A19320975C_1921103728 = (mPopupWindow != null && mPopupWindow.isShowing());
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
                            @Override
                            public void run() {
                                hide();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.183 -0400", hash_original_method = "BE935C64EC56548296E167AABD21FC2C", hash_generated_method = "B426629497EFEA2D4EF1D5975275F00B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void adjustSpans(CharSequence buffer) {
            dsTaint.addTaint(buffer);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.183 -0400", hash_original_method = "D4568FCB8F606B40F32BB2FF24EF8AE2", hash_generated_method = "D77D3EFA6B79388C2C05D020DE83226D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void removeSpans(CharSequence buffer) {
            dsTaint.addTaint(buffer);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.183 -0400", hash_original_method = "FD0036F1377269974D72D9C2BC2EFAA3", hash_generated_method = "7E8D604CDD4272911D5587903C843B81")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private EasyEditSpan getSpan(Spanned spanned) {
            dsTaint.addTaint(spanned.dsTaint);
            EasyEditSpan[] easyEditSpans;
            easyEditSpans = spanned.getSpans(0, spanned.length(),
                    EasyEditSpan.class);
            return (EasyEditSpan)dsTaint.getTaint();
            // ---------- Original Method ----------
            //EasyEditSpan[] easyEditSpans = spanned.getSpans(0, spanned.length(),
                    //EasyEditSpan.class);
            //if (easyEditSpans.length == 0) {
                //return null;
            //} else {
                //return easyEditSpans[0];
            //}
        }

        
    }


    
    private class EasyEditPopupWindow extends PinnedPopupWindow implements OnClickListener {
        private static final int POPUP_TEXT_LAYOUT =
                com.android.internal.R.layout.text_edit_action_popup_text;
        private TextView mDeleteTextView;
        private EasyEditSpan mEasyEditSpan;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.183 -0400", hash_original_method = "57DC4A0271DC22A49F19ED5E582C7E72", hash_generated_method = "7FD2B5434F6A35FC0809230799F3EED9")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.183 -0400", hash_original_method = "128C0E079A8A50F8B38C36065ADCA0D3", hash_generated_method = "060E54FD4CA76B55A04E310730ADF66A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.183 -0400", hash_original_method = "EB30ECB06A4982701AF1B8E86934D288", hash_generated_method = "0451EDE5F4EF9A49276A765A4AA5B526")
        @DSModeled(DSC.SAFE)
        public void show(EasyEditSpan easyEditSpan) {
            dsTaint.addTaint(easyEditSpan.dsTaint);
            super.show();
            // ---------- Original Method ----------
            //mEasyEditSpan = easyEditSpan;
            //super.show();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.183 -0400", hash_original_method = "C063208218D3B6E27F261A5578D5D2B9", hash_generated_method = "33E93699EF87A1BC97A2E78AC4DEDE97")
        @DSModeled(DSC.SAFE)
        @Override
        public void onClick(View view) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(view.dsTaint);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.183 -0400", hash_original_method = "7C1AF53FA575FE23CA1F61E7AC0FA9D9", hash_generated_method = "DB5FD31A85EFCFDBCC0FF958FFB6D79D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected int getTextOffset() {
            Editable editable;
            editable = (Editable) mText;
            int var250A5466B0BCD45EA6B6F640A95FFADA_1165972783 = (editable.getSpanEnd(mEasyEditSpan));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //Editable editable = (Editable) mText;
            //return editable.getSpanEnd(mEasyEditSpan);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.184 -0400", hash_original_method = "87FFA2F036D6FB2F317732DF596E05CB", hash_generated_method = "9F94832086DA678402388231AA2D825D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected int getVerticalLocalPosition(int line) {
            dsTaint.addTaint(line);
            int varC530C119C90DEC1E0FFF523326A5138A_1077096662 = (mLayout.getLineBottom(line));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mLayout.getLineBottom(line);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.184 -0400", hash_original_method = "48C7510506F753F88F1EBACB4F114059", hash_generated_method = "2EE8E1F51DACF9A3923BF6ECF01A849A")
        @DSModeled(DSC.SAFE)
        @Override
        protected int clipVertically(int positionY) {
            dsTaint.addTaint(positionY);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return positionY;
        }

        
    }


    
    private class ChangeWatcher implements TextWatcher, SpanWatcher {
        private CharSequence mBeforeText;
        private EasyEditSpanController mEasyEditSpanController;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.184 -0400", hash_original_method = "41973225A14E12423F2683848135C141", hash_generated_method = "961B2763F1DAF5AB69167021A4B25413")
        @DSModeled(DSC.SAFE)
        private ChangeWatcher() {
            mEasyEditSpanController = new EasyEditSpanController();
            // ---------- Original Method ----------
            //mEasyEditSpanController = new EasyEditSpanController();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.184 -0400", hash_original_method = "720D371807084B06633282B0029EC53C", hash_generated_method = "72676EAD7EFA9C58F10FE3E789068255")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void beforeTextChanged(CharSequence buffer, int start,
                                      int before, int after) {
            dsTaint.addTaint(buffer);
            dsTaint.addTaint(after);
            dsTaint.addTaint(start);
            dsTaint.addTaint(before);
            {
                boolean var58E0C133E73001AE9B82AF19F4A709BD_20214262 = (AccessibilityManager.getInstance(mContext).isEnabled()
                    && !isPasswordInputType(mInputType)
                    && !hasPasswordTransformationMethod());
                {
                    mBeforeText = buffer.toString();
                } //End block
            } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.184 -0400", hash_original_method = "94F338CF670251E301395B1B01A5E75A", hash_generated_method = "12857153259C9C47430BB61800E5398D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onTextChanged(CharSequence buffer, int start,
                                  int before, int after) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(buffer);
            dsTaint.addTaint(after);
            dsTaint.addTaint(start);
            dsTaint.addTaint(before);
            TextView.this.handleTextChanged(buffer, start, before, after);
            mEasyEditSpanController.onTextChange(buffer);
            {
                boolean var2CE54939AB34C356367D1A2596516E7D_125679855 = (AccessibilityManager.getInstance(mContext).isEnabled() &&
                    (isFocused() || isSelected() && isShown()));
                {
                    sendAccessibilityEventTypeViewTextChanged(mBeforeText, start, before, after);
                    mBeforeText = null;
                } //End block
            } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.184 -0400", hash_original_method = "36BCFC0FC76553AA6F29D2F790EC381C", hash_generated_method = "0C000CAF04A88637879104483AEC8933")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void afterTextChanged(Editable buffer) {
            dsTaint.addTaint(buffer.dsTaint);
            TextView.this.sendAfterTextChanged(buffer);
            {
                boolean varD9AAC580C15E35EE8A21660BC6977A2B_72970746 = (MetaKeyKeyListener.getMetaState(buffer, MetaKeyKeyListener.META_SELECTING) != 0);
                {
                    MetaKeyKeyListener.stopSelecting(TextView.this, buffer);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (DEBUG_EXTRACT) Log.v(LOG_TAG, "afterTextChanged: " + buffer);
            //TextView.this.sendAfterTextChanged(buffer);
            //if (MetaKeyKeyListener.getMetaState(buffer, MetaKeyKeyListener.META_SELECTING) != 0) {
                //MetaKeyKeyListener.stopSelecting(TextView.this, buffer);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.184 -0400", hash_original_method = "6F9EDB470C5AD5F1E23596AFEC700ED3", hash_generated_method = "491A6171B1895FB7638C102DB5A167DC")
        @DSModeled(DSC.SAFE)
        public void onSpanChanged(Spannable buf,
                                  Object what, int s, int e, int st, int en) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(e);
            dsTaint.addTaint(s);
            dsTaint.addTaint(what.dsTaint);
            dsTaint.addTaint(en);
            dsTaint.addTaint(st);
            dsTaint.addTaint(buf.dsTaint);
            TextView.this.spanChange(buf, what, s, st, e, en);
            // ---------- Original Method ----------
            //if (DEBUG_EXTRACT) Log.v(LOG_TAG, "onSpanChanged s=" + s + " e=" + e
                    //+ " st=" + st + " en=" + en + " what=" + what + ": " + buf);
            //TextView.this.spanChange(buf, what, s, st, e, en);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.184 -0400", hash_original_method = "B2A75CCE31AAD63896365B7E450A433A", hash_generated_method = "13F0910F97FC3194A85589D57CD6BDEC")
        @DSModeled(DSC.SAFE)
        public void onSpanAdded(Spannable buf, Object what, int s, int e) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(e);
            dsTaint.addTaint(s);
            dsTaint.addTaint(what.dsTaint);
            dsTaint.addTaint(buf.dsTaint);
            TextView.this.spanChange(buf, what, -1, s, -1, e);
            // ---------- Original Method ----------
            //if (DEBUG_EXTRACT) Log.v(LOG_TAG, "onSpanAdded s=" + s + " e=" + e
                    //+ " what=" + what + ": " + buf);
            //TextView.this.spanChange(buf, what, -1, s, -1, e);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.184 -0400", hash_original_method = "11DC5396F5D4F6210F8F1D677B03B553", hash_generated_method = "CD0AFB9092DB8C6C36BF764916E5A004")
        @DSModeled(DSC.SAFE)
        public void onSpanRemoved(Spannable buf, Object what, int s, int e) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(e);
            dsTaint.addTaint(s);
            dsTaint.addTaint(what.dsTaint);
            dsTaint.addTaint(buf.dsTaint);
            TextView.this.spanChange(buf, what, s, -1, e, -1);
            // ---------- Original Method ----------
            //if (DEBUG_EXTRACT) Log.v(LOG_TAG, "onSpanRemoved s=" + s + " e=" + e
                    //+ " what=" + what + ": " + buf);
            //TextView.this.spanChange(buf, what, s, -1, e, -1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.184 -0400", hash_original_method = "FB97DDA9E5EB9C645F7C42D5DCEE1A36", hash_generated_method = "2C1ED5CA7148924C279FCDE0A6CE9315")
        @DSModeled(DSC.SAFE)
        private void hideControllers() {
            mEasyEditSpanController.hide();
            // ---------- Original Method ----------
            //mEasyEditSpanController.hide();
        }

        
    }


    
    private static class Blink extends Handler implements Runnable {
        private final WeakReference<TextView> mView;
        private boolean mCancelled;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.185 -0400", hash_original_method = "B3B341EB4735766A8EE81E50FC9FCC5D", hash_generated_method = "7F875EF4A15742C157C601FEC957A587")
        @DSModeled(DSC.SAFE)
        public Blink(TextView v) {
            dsTaint.addTaint(v.dsTaint);
            mView = new WeakReference<TextView>(v);
            // ---------- Original Method ----------
            //mView = new WeakReference<TextView>(v);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.185 -0400", hash_original_method = "ACD5284757446306F2E6E1BADED5158A", hash_generated_method = "45E2244398CB8092774125C9572A53E1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            removeCallbacks(Blink.this);
            TextView tv;
            tv = mView.get();
            {
                boolean var397A686FF4DC8BC40834AF9DD4FC6DD1_753530157 = (tv != null && tv.shouldBlink());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.185 -0400", hash_original_method = "A015A25EF128A9724656D77FE5A94B9E", hash_generated_method = "A0D0F70F82A1CEBE540495E937B4273B")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.185 -0400", hash_original_method = "A06944554EAF73141DA4277B06D0E2BD", hash_generated_method = "8FB7877A91FFEF6EF690F2615D9C6FB3")
        @DSModeled(DSC.SAFE)
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
        public TextView sourceTextView;
        public int start, end;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.185 -0400", hash_original_method = "78F248ABC93BE1F7C9E297B91A3F7D55", hash_generated_method = "1FA0B478994B99993D3B5AED4FF53BA9")
        @DSModeled(DSC.SAFE)
        public DragLocalState(TextView sourceTextView, int start, int end) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(sourceTextView.dsTaint);
            dsTaint.addTaint(end);
            // ---------- Original Method ----------
            //this.sourceTextView = sourceTextView;
            //this.start = start;
            //this.end = end;
        }

        
    }


    
    private class PositionListener implements ViewTreeObserver.OnPreDrawListener {
        private final int MAXIMUM_NUMBER_OF_LISTENERS = 6;
        private TextViewPositionListener[] mPositionListeners =
                new TextViewPositionListener[MAXIMUM_NUMBER_OF_LISTENERS];
        private boolean mCanMove[] = new boolean[MAXIMUM_NUMBER_OF_LISTENERS];
        private boolean mPositionHasChanged = true;
        private int mPositionX, mPositionY;
        private int mNumberOfListeners;
        private boolean mScrollHasChanged;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.185 -0400", hash_original_method = "2CEF91B445974B7F0C1F2F2831D38171", hash_generated_method = "7A0C14FB3E334CAF579B78F5618CC86A")
        @DSModeled(DSC.SAFE)
        public void addSubscriber(TextViewPositionListener positionListener, boolean canMove) {
            dsTaint.addTaint(positionListener.dsTaint);
            dsTaint.addTaint(canMove);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.185 -0400", hash_original_method = "F36C99880C8165921A7F03E512CBB647", hash_generated_method = "BC8551E2A9F45B24105FDC845A0C890D")
        @DSModeled(DSC.SAFE)
        public void removeSubscriber(TextViewPositionListener positionListener) {
            dsTaint.addTaint(positionListener.dsTaint);
            {
                int i;
                i = 0;
                {
                    {
                        mPositionListeners[i] = null;
                        mNumberOfListeners--;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                ViewTreeObserver vto;
                vto = TextView.this.getViewTreeObserver();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.185 -0400", hash_original_method = "256A376A54FD4CD53D18A0F020A0467C", hash_generated_method = "A856DAD0C65CF062BD60A450A0BEB8ED")
        @DSModeled(DSC.SAFE)
        public int getPositionX() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mPositionX;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.185 -0400", hash_original_method = "4CCC26BBD5544F9405CBD90295EAF862", hash_generated_method = "473A7B29E6F36D36CC4FFD58E688B55F")
        @DSModeled(DSC.SAFE)
        public int getPositionY() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mPositionY;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.185 -0400", hash_original_method = "4634D6360837F07AB476144D9CD27591", hash_generated_method = "E169F46B759BD41268D48C50D5FC60C2")
        @DSModeled(DSC.SAFE)
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
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.186 -0400", hash_original_method = "65C89C768DE236BFCC52E144F22BF85B", hash_generated_method = "3E0F4FDADAA28BED7BA5C983F8AB3E9D")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.186 -0400", hash_original_method = "45AFA571A6FC9FC84FC093F1FB86DABC", hash_generated_method = "34751C5B16AF30DA2FFAD5094F8587B0")
        @DSModeled(DSC.SAFE)
        public void onScrollChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mScrollHasChanged = true;
            // ---------- Original Method ----------
            //mScrollHasChanged = true;
        }

        
    }


    
    private abstract class PinnedPopupWindow implements TextViewPositionListener {
        protected PopupWindow mPopupWindow;
        protected ViewGroup mContentView;
        int mPositionX, mPositionY;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.186 -0400", hash_original_method = "596A5600AE60FE2F4CDE653E6E3819B3", hash_generated_method = "F79D611CA0256A42501D743E5569107F")
        @DSModeled(DSC.SAFE)
        public PinnedPopupWindow() {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.186 -0400", hash_original_method = "6C3D8663E8D10274240ADCEB82AE9A86", hash_generated_method = "7AD98A889CCDDED4F268291E8B40D7EB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void show() {
            TextView.this.getPositionListener().addSubscriber(this, false );
            computeLocalPosition();
            final PositionListener positionListener;
            positionListener = TextView.this.getPositionListener();
            updatePosition(positionListener.getPositionX(), positionListener.getPositionY());
            // ---------- Original Method ----------
            //TextView.this.getPositionListener().addSubscriber(this, false );
            //computeLocalPosition();
            //final PositionListener positionListener = TextView.this.getPositionListener();
            //updatePosition(positionListener.getPositionX(), positionListener.getPositionY());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.186 -0400", hash_original_method = "AFC1F8ABC6317EB9C1F375A956F1E985", hash_generated_method = "F73F5AA3539DA53DAC4F1AB396816898")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected void measureContent() {
            final DisplayMetrics displayMetrics;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.186 -0400", hash_original_method = "422A968B45C30695D0BEB603E4E72147", hash_generated_method = "ADB94253F94910AE037A0137629BD6FD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void computeLocalPosition() {
            measureContent();
            final int width;
            width = mContentView.getMeasuredWidth();
            final int offset;
            offset = getTextOffset();
            mPositionX = (int) (mLayout.getPrimaryHorizontal(offset) - width / 2.0f);
            mPositionX += viewportToContentHorizontalOffset();
            final int line;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.186 -0400", hash_original_method = "3C2767EB11AB639449E091DD5FC9CB2A", hash_generated_method = "4B3A6B80AF904D3AD50EA32A20E97BEC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void updatePosition(int parentPositionX, int parentPositionY) {
            dsTaint.addTaint(parentPositionX);
            dsTaint.addTaint(parentPositionY);
            int positionX;
            positionX = parentPositionX + mPositionX;
            int positionY;
            positionY = parentPositionY + mPositionY;
            positionY = clipVertically(positionY);
            final DisplayMetrics displayMetrics;
            displayMetrics = mContext.getResources().getDisplayMetrics();
            final int width;
            width = mContentView.getMeasuredWidth();
            positionX = Math.min(displayMetrics.widthPixels - width, positionX);
            positionX = Math.max(0, positionX);
            {
                boolean varC328115627DFB8318D2C3484959F5057_1591534784 = (isShowing());
                {
                    mPopupWindow.update(positionX, positionY, -1, -1);
                } //End block
                {
                    mPopupWindow.showAtLocation(TextView.this, Gravity.NO_GRAVITY,
                        positionX, positionY);
                } //End block
            } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.186 -0400", hash_original_method = "9C51A5E6940629038A75840F54DCC577", hash_generated_method = "62DC542205FA2AEC4ADCFB2BB6AC5A9D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void hide() {
            mPopupWindow.dismiss();
            TextView.this.getPositionListener().removeSubscriber(this);
            // ---------- Original Method ----------
            //mPopupWindow.dismiss();
            //TextView.this.getPositionListener().removeSubscriber(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.186 -0400", hash_original_method = "48D3C5BA4737FA32BEEBA9E620F4B3A6", hash_generated_method = "B0BE2D10545F92C85F8793ECA57C5E38")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void updatePosition(int parentPositionX, int parentPositionY,
                boolean parentPositionChanged, boolean parentScrolled) {
            dsTaint.addTaint(parentScrolled);
            dsTaint.addTaint(parentPositionX);
            dsTaint.addTaint(parentPositionY);
            dsTaint.addTaint(parentPositionChanged);
            {
                boolean varF3B8B81213123AA3F897761495709D4F_1402033618 = (isShowing() && isOffsetVisible(getTextOffset()));
                {
                    computeLocalPosition();
                    updatePosition(parentPositionX, parentPositionY);
                } //End block
                {
                    hide();
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (isShowing() && isOffsetVisible(getTextOffset())) {
                //if (parentScrolled) computeLocalPosition();
                //updatePosition(parentPositionX, parentPositionY);
            //} else {
                //hide();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.186 -0400", hash_original_method = "771871BA8F1191126AB0990E72BA0594", hash_generated_method = "D3468A38C2BA23D5B4AAF744439C205B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean isShowing() {
            boolean varDAFC67E962E4584ADE09C9440ED4C8A8_948326057 = (mPopupWindow.isShowing());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mPopupWindow.isShowing();
        }

        
    }


    
    private class SuggestionsPopupWindow extends PinnedPopupWindow implements OnItemClickListener {
        private static final int MAX_NUMBER_SUGGESTIONS = SuggestionSpan.SUGGESTIONS_MAX_SIZE;
        private static final int ADD_TO_DICTIONARY = -1;
        private static final int DELETE_TEXT = -2;
        private SuggestionInfo[] mSuggestionInfos;
        private int mNumberOfSuggestions;
        private boolean mCursorWasVisibleBeforeSuggestions;
        private boolean mIsShowingUp = false;
        private SuggestionAdapter mSuggestionsAdapter;
        private final Comparator<SuggestionSpan> mSuggestionSpanComparator;
        private final HashMap<SuggestionSpan, Integer> mSpansLengths;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.187 -0400", hash_original_method = "296BEE5065EB2EF8F82574E0F3647EF2", hash_generated_method = "01B4B8EC28F87FBD09B358B36081DBDB")
        @DSModeled(DSC.SAFE)
        public SuggestionsPopupWindow() {
            mCursorWasVisibleBeforeSuggestions = mCursorVisible;
            mSuggestionSpanComparator = new SuggestionSpanComparator();
            mSpansLengths = new HashMap<SuggestionSpan, Integer>();
            // ---------- Original Method ----------
            //mCursorWasVisibleBeforeSuggestions = mCursorVisible;
            //mSuggestionSpanComparator = new SuggestionSpanComparator();
            //mSpansLengths = new HashMap<SuggestionSpan, Integer>();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.187 -0400", hash_original_method = "2C5A34402E22C878AD33972323D3ACC4", hash_generated_method = "D46B2719DAB1DA2B77363471A191FC3C")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.187 -0400", hash_original_method = "E003230CE90A2ACB93D34E336B67EF46", hash_generated_method = "C052861B6987BA99770076EB84D10567")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.187 -0400", hash_original_method = "4C7853BA5C99567CAD84815F4452E5F9", hash_generated_method = "D9B99A11836C7865862480BD124A6F4E")
        @DSModeled(DSC.SAFE)
        public boolean isShowingUp() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mIsShowingUp;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.187 -0400", hash_original_method = "3914DCDC5DB3E14D1A1A163B7497EFBA", hash_generated_method = "29EDEA25184A6FD9A6FE47DB3E46FE34")
        @DSModeled(DSC.SAFE)
        public void onParentLostFocus() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mIsShowingUp = false;
            // ---------- Original Method ----------
            //mIsShowingUp = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.187 -0400", hash_original_method = "A21D81008594D05973BC33E2948715E2", hash_generated_method = "3B3077450B1994201521D2B2348C56B3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private SuggestionSpan[] getSuggestionSpans() {
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
            return (SuggestionSpan[])dsTaint.getTaint();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.187 -0400", hash_original_method = "C166DC70ACC1835B92197E48CEB369FC", hash_generated_method = "B0D6CEDF5E2A6FA80ABAAD8759FA2D09")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.187 -0400", hash_original_method = "8DDB7ED8B40AC8DC3D4FF9060DA06A2E", hash_generated_method = "F6E14391796B51A4355CD8E93EE522BC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void measureContent() {
            final DisplayMetrics displayMetrics;
            displayMetrics = mContext.getResources().getDisplayMetrics();
            final int horizontalMeasure;
            horizontalMeasure = View.MeasureSpec.makeMeasureSpec(
                    displayMetrics.widthPixels, View.MeasureSpec.AT_MOST);
            final int verticalMeasure;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.187 -0400", hash_original_method = "6820F3398D40FE1AF57F321A0934E9B8", hash_generated_method = "44B1E35C5E63EC55D8A9F7F3251F0F2C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected int getTextOffset() {
            int varBC8718B34213775E0E86386F1B689831_1405647684 = (getSelectionStart());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return getSelectionStart();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.188 -0400", hash_original_method = "87FFA2F036D6FB2F317732DF596E05CB", hash_generated_method = "411CDCB2649F14D17CE360B27F3782A1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected int getVerticalLocalPosition(int line) {
            dsTaint.addTaint(line);
            int varC530C119C90DEC1E0FFF523326A5138A_662785866 = (mLayout.getLineBottom(line));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mLayout.getLineBottom(line);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.188 -0400", hash_original_method = "BF4D66DCAEE7C7EAD97F70105958840C", hash_generated_method = "88C1BB87C72E0DF76E80D6D4564C324A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected int clipVertically(int positionY) {
            dsTaint.addTaint(positionY);
            final int height;
            height = mContentView.getMeasuredHeight();
            final DisplayMetrics displayMetrics;
            displayMetrics = mContext.getResources().getDisplayMetrics();
            int var7B483E1A6A6C9FD21BCAE2DB59DA5C3D_464463967 = (Math.min(positionY, displayMetrics.heightPixels - height));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //final int height = mContentView.getMeasuredHeight();
            //final DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
            //return Math.min(positionY, displayMetrics.heightPixels - height);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.188 -0400", hash_original_method = "7609E0B22D3FA397AAE3B56DEE3F8C83", hash_generated_method = "F6449DD9958F3A5F628E2384E63E97DE")
        @DSModeled(DSC.SAFE)
        @Override
        public void hide() {
            super.hide();
            // ---------- Original Method ----------
            //super.hide();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.188 -0400", hash_original_method = "43D89583824EB2CC5185C1DC5EA2D76A", hash_generated_method = "B80980215C52BB56F2302988A40F7339")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void updateSuggestions() {
            Spannable spannable;
            spannable = (Spannable) TextView.this.mText;
            SuggestionSpan[] suggestionSpans;
            suggestionSpans = getSuggestionSpans();
            final int nbSpans;
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
                    final int spanStart;
                    spanStart = spannable.getSpanStart(suggestionSpan);
                    final int spanEnd;
                    spanEnd = spannable.getSpanEnd(suggestionSpan);
                    spanUnionStart = Math.min(spanStart, spanUnionStart);
                    spanUnionEnd = Math.max(spanEnd, spanUnionEnd);
                    {
                        boolean var41ED7D23113F09082657F25EB9349901_656557040 = ((suggestionSpan.getFlags() & SuggestionSpan.FLAG_MISSPELLED) != 0);
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
                            mNumberOfSuggestions++;
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
                final int misspelledStart;
                misspelledStart = spannable.getSpanStart(misspelledSpan);
                final int misspelledEnd;
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
                    mNumberOfSuggestions++;
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
            mNumberOfSuggestions++;
            mSuggestionRangeSpan = new SuggestionRangeSpan();
            {
                mSuggestionRangeSpan.setBackgroundColor(mHighlightColor);
            } //End block
            {
                final float BACKGROUND_TRANSPARENCY;
                BACKGROUND_TRANSPARENCY = 0.4f;
                final int newAlpha;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.188 -0400", hash_original_method = "9587A8E163DBC119C2F6F3B6CD33F02D", hash_generated_method = "C993D555F99DC09AA927F49451DF9DDD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void highlightTextDifferences(SuggestionInfo suggestionInfo, int unionStart,
                int unionEnd) {
            dsTaint.addTaint(suggestionInfo.dsTaint);
            dsTaint.addTaint(unionStart);
            dsTaint.addTaint(unionEnd);
            final Spannable text;
            text = (Spannable) mText;
            final int spanStart;
            spanStart = text.getSpanStart(suggestionInfo.suggestionSpan);
            final int spanEnd;
            spanEnd = text.getSpanEnd(suggestionInfo.suggestionSpan);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.189 -0400", hash_original_method = "73388536B046BC3C58C91A89E4930696", hash_generated_method = "CB84C613D7B037D22F8CFDDCF4CA8158")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(position);
            dsTaint.addTaint(id);
            dsTaint.addTaint(parent.dsTaint);
            dsTaint.addTaint(view.dsTaint);
            Editable editable;
            editable = (Editable) mText;
            SuggestionInfo suggestionInfo;
            suggestionInfo = mSuggestionInfos[position];
            {
                final int spanUnionStart;
                spanUnionStart = editable.getSpanStart(mSuggestionRangeSpan);
                int spanUnionEnd;
                spanUnionEnd = editable.getSpanEnd(mSuggestionRangeSpan);
                {
                    {
                        boolean var84A1A3093EA4E5C4D94593E4EC39F7A6_1665232973 = (spanUnionEnd < editable.length() &&
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
            final int spanStart;
            spanStart = editable.getSpanStart(suggestionInfo.suggestionSpan);
            final int spanEnd;
            spanEnd = editable.getSpanEnd(suggestionInfo.suggestionSpan);
            {
                hide();
            } //End block
            final String originalText;
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
                final int length;
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
                        final SuggestionSpan suggestionSpan;
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
                final int suggestionStart;
                suggestionStart = suggestionInfo.suggestionStart;
                final int suggestionEnd;
                suggestionEnd = suggestionInfo.suggestionEnd;
                final String suggestion;
                suggestion = suggestionInfo.text.subSequence(
                        suggestionStart, suggestionEnd).toString();
                replaceText_internal(spanStart, spanEnd, suggestion);
                {
                    boolean varF79A598750887E0098FCD17D2840688C_1286250677 = (!TextUtils.isEmpty(
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
                final int lengthDifference;
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
                final int newCursorPosition;
                newCursorPosition = spanEnd + lengthDifference;
                setCursorPosition_internal(newCursorPosition, newCursorPosition);
            } //End block
            hide();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        private class CustomPopupWindow extends PopupWindow {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.189 -0400", hash_original_method = "76E50B1843F1484B0424D837A17373EE", hash_generated_method = "48AD3AD29A74132525C3B9FA22AD2876")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public CustomPopupWindow(Context context, int defStyle) {
                super(context, null, defStyle);
                dsTaint.addTaint(defStyle);
                dsTaint.addTaint(context.dsTaint);
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.189 -0400", hash_original_method = "3CF42E745499FBF7012823B6BEAA6E8B", hash_generated_method = "E5D63D6AFEB37DD68FEE660D50210D31")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void dismiss() {
                super.dismiss();
                TextView.this.getPositionListener().removeSubscriber(SuggestionsPopupWindow.this);
                ((Spannable) mText).removeSpan(mSuggestionRangeSpan);
                setCursorVisible(mCursorWasVisibleBeforeSuggestions);
                {
                    boolean var6A9CA976632F28E945987868EDCFC2A8_1456954663 = (hasInsertionController());
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
            int suggestionStart, suggestionEnd;
            SuggestionSpan suggestionSpan;
            int suggestionIndex;
            SpannableStringBuilder text = new SpannableStringBuilder();
            TextAppearanceSpan highlightSpan = new TextAppearanceSpan(mContext,
                    android.R.style.TextAppearance_SuggestionHighlight);
            
        }


        
        private class SuggestionAdapter extends BaseAdapter {
            private LayoutInflater mInflater = (LayoutInflater) TextView.this.mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.189 -0400", hash_original_method = "02B536C5901CCC3DE9A3084712F44E45", hash_generated_method = "A3B076560F59E85065DF9A69BB93A719")
            @DSModeled(DSC.SAFE)
            @Override
            public int getCount() {
                return dsTaint.getTaintInt();
                // ---------- Original Method ----------
                //return mNumberOfSuggestions;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.190 -0400", hash_original_method = "AB9B090A0CFC1C7403BFB1F3A94BDE2B", hash_generated_method = "659C1F9F21F09EB5056FCA9D6C154C77")
            @DSModeled(DSC.SAFE)
            @Override
            public Object getItem(int position) {
                dsTaint.addTaint(position);
                return (Object)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return mSuggestionInfos[position];
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.190 -0400", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "ECCA4BEA619FBCD3F1E9C47E7B671689")
            @DSModeled(DSC.SAFE)
            @Override
            public long getItemId(int position) {
                dsTaint.addTaint(position);
                return dsTaint.getTaintLong();
                // ---------- Original Method ----------
                //return position;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.190 -0400", hash_original_method = "EB7381461F4FDD3A1934D144B2D8DE50", hash_generated_method = "F602624AA0A443F7E5677E37CA8F52E7")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                dsTaint.addTaint(position);
                dsTaint.addTaint(parent.dsTaint);
                dsTaint.addTaint(convertView.dsTaint);
                TextView textView;
                textView = (TextView) convertView;
                {
                    textView = (TextView) mInflater.inflate(mTextEditSuggestionItemLayout, parent,
                            false);
                } //End block
                final SuggestionInfo suggestionInfo;
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
                return (View)dsTaint.getTaint();
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
        }


        
        private class SuggestionSpanComparator implements Comparator<SuggestionSpan> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.190 -0400", hash_original_method = "D4A09F0FD84AABB3F69B7BD15CCD92DF", hash_generated_method = "99AF3C243645B7171B680E1460B557C1")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public int compare(SuggestionSpan span1, SuggestionSpan span2) {
                dsTaint.addTaint(span2.dsTaint);
                dsTaint.addTaint(span1.dsTaint);
                final int flag1;
                flag1 = span1.getFlags();
                final int flag2;
                flag2 = span2.getFlags();
                {
                    final boolean easy1;
                    easy1 = (flag1 & SuggestionSpan.FLAG_EASY_CORRECT) != 0;
                    final boolean easy2;
                    easy2 = (flag2 & SuggestionSpan.FLAG_EASY_CORRECT) != 0;
                    final boolean misspelled1;
                    misspelled1 = (flag1 & SuggestionSpan.FLAG_MISSPELLED) != 0;
                    final boolean misspelled2;
                    misspelled2 = (flag2 & SuggestionSpan.FLAG_MISSPELLED) != 0;
                } //End block
                int var69AC0EE4C836195D7157808630CBE920_990963070 = (mSpansLengths.get(span1).intValue() - mSpansLengths.get(span2).intValue());
                return dsTaint.getTaintInt();
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
        }


        
    }


    
    private class SelectionActionModeCallback implements ActionMode.Callback {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.191 -0400", hash_original_method = "9BA90F93967180A852B2E5C718CC8322", hash_generated_method = "986817DB49AFC01DE2656C205F00B242")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(menu.dsTaint);
            dsTaint.addTaint(mode.dsTaint);
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
                boolean var4087A2A70EC4D6F0409558B6C4258D55_1728097084 = (canCut());
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
                boolean var6AFF96D83000797E509C5DFB5D242F34_887419043 = (canCopy());
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
                boolean varE76E09F5D4A1A03C0560F618234DAA0E_1210082476 = (canPaste());
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
                    boolean var41AD4209F91C4824352554BD86D35AA9_791913185 = (!mCustomSelectionActionModeCallback.onCreateActionMode(mode, menu));
                } //End collapsed parenthetic
            } //End block
            {
                boolean var7C369957434C066B84C56D449BD80D86_1627926019 = (menu.hasVisibleItems() || mode.getCustomView() != null);
                {
                    getSelectionController().show();
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.191 -0400", hash_original_method = "350C4916EAD271625C17FEEF1988576E", hash_generated_method = "EE06EB5858D020B8FB1B2E5A572630FE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(menu.dsTaint);
            dsTaint.addTaint(mode.dsTaint);
            {
                boolean varADAB2DA7C682C9431AEBA3613F94A97B_164694545 = (mCustomSelectionActionModeCallback.onPrepareActionMode(mode, menu));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (mCustomSelectionActionModeCallback != null) {
                //return mCustomSelectionActionModeCallback.onPrepareActionMode(mode, menu);
            //}
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.191 -0400", hash_original_method = "7EC2472DA1F2018FBE0DB5359E02217C", hash_generated_method = "5546A70CD1DB587DC3C113B6457140C5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(item.dsTaint);
            dsTaint.addTaint(mode.dsTaint);
            {
                boolean var6A3E1D5B368A4625952314ECA607D6A0_470991426 = (mCustomSelectionActionModeCallback != null &&
                 mCustomSelectionActionModeCallback.onActionItemClicked(mode, item));
            } //End collapsed parenthetic
            boolean varAAAC964C7BDBEAA3EC5B24BBD90E6008_1127234423 = (onTextContextMenuItem(item.getItemId()));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (mCustomSelectionActionModeCallback != null &&
                 //mCustomSelectionActionModeCallback.onActionItemClicked(mode, item)) {
                //return true;
            //}
            //return onTextContextMenuItem(item.getItemId());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.191 -0400", hash_original_method = "E3DA233478038DA411461438FCA54906", hash_generated_method = "333932D312FC8F1BB481A5D6AD22B2A9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onDestroyActionMode(ActionMode mode) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(mode.dsTaint);
            {
                mCustomSelectionActionModeCallback.onDestroyActionMode(mode);
            } //End block
            Selection.setSelection((Spannable) mText, getSelectionEnd());
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
        private static final int POPUP_TEXT_LAYOUT =
                com.android.internal.R.layout.text_edit_action_popup_text;
        private TextView mPasteTextView;
        private TextView mReplaceTextView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.191 -0400", hash_original_method = "3A27BFF151DD7090A49C43ED6F082D3A", hash_generated_method = "AAE65103E2B787B5607B5F644C0B17A6")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.191 -0400", hash_original_method = "24A2CF459D5801BCD7B986330654CD38", hash_generated_method = "5E29B0E8EF9BA16FF570D5BC2F86CC7D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.191 -0400", hash_original_method = "A37D41A60FC392DB422E94A09527D04E", hash_generated_method = "AD5F3DE9699B90A784F8560523DE73D0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.192 -0400", hash_original_method = "35B6F06783189901121FFF5DA40FB852", hash_generated_method = "D68F245B816C01254DB868585FFBFAFE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onClick(View view) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(view.dsTaint);
            {
                boolean var3F1B0BC67C85AC74E9CC7447E1F80F7C_1257063572 = (view == mPasteTextView && canPaste());
                {
                    onTextContextMenuItem(ID_PASTE);
                    hide();
                } //End block
                {
                    final int middle;
                    middle = (getSelectionStart() + getSelectionEnd()) / 2;
                    stopSelectionActionMode();
                    Selection.setSelection((Spannable) mText, middle);
                    showSuggestions();
                } //End block
            } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.192 -0400", hash_original_method = "6C32A970FB91901A3510EE736EF065A8", hash_generated_method = "E66F2704EA6BA82B43156DA58E2BF81A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected int getTextOffset() {
            int var3BEB3DEB1E2E3C75F7F6F972590B6F26_1524676245 = ((getSelectionStart() + getSelectionEnd()) / 2);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return (getSelectionStart() + getSelectionEnd()) / 2;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.192 -0400", hash_original_method = "AB01324FAF38A5FF69620E59B4546722", hash_generated_method = "7D639D965412094A99931F795850C325")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected int getVerticalLocalPosition(int line) {
            dsTaint.addTaint(line);
            int varEE26756D259E6923CEEA10605E3E8378_1458296993 = (mLayout.getLineTop(line) - mContentView.getMeasuredHeight());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mLayout.getLineTop(line) - mContentView.getMeasuredHeight();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.192 -0400", hash_original_method = "155BF5081251C49CE36145C9CC0615FD", hash_generated_method = "B7636F96D203E341FE603855B1128E85")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected int clipVertically(int positionY) {
            dsTaint.addTaint(positionY);
            {
                final int offset;
                offset = getTextOffset();
                final int line;
                line = mLayout.getLineForOffset(offset);
                positionY += mLayout.getLineBottom(line) - mLayout.getLineTop(line);
                positionY += mContentView.getMeasuredHeight();
                final Drawable handle;
                handle = mContext.getResources().getDrawable(mTextSelectHandleRes);
                positionY += handle.getIntrinsicHeight();
            } //End block
            return dsTaint.getTaintInt();
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

        
    }


    
    private abstract class HandleView extends View implements TextViewPositionListener {
        protected Drawable mDrawable;
        protected Drawable mDrawableLtr;
        protected Drawable mDrawableRtl;
        private final PopupWindow mContainer;
        private int mPositionX, mPositionY;
        private boolean mIsDragging;
        private float mTouchToWindowOffsetX, mTouchToWindowOffsetY;
        protected int mHotspotX;
        private float mTouchOffsetY;
        private float mIdealVerticalOffset;
        private int mLastParentX, mLastParentY;
        protected ActionPopupWindow mActionPopupWindow;
        private int mPreviousOffset = -1;
        private boolean mPositionHasChanged = true;
        private Runnable mActionPopupShower;
        private static final int HISTORY_SIZE = 5;
        private static final int TOUCH_UP_FILTER_DELAY_AFTER = 150;
        private static final int TOUCH_UP_FILTER_DELAY_BEFORE = 350;
        private final long[] mPreviousOffsetsTimes = new long[HISTORY_SIZE];
        private final int[] mPreviousOffsets = new int[HISTORY_SIZE];
        private int mPreviousOffsetIndex = 0;
        private int mNumberPreviousOffsets = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.192 -0400", hash_original_method = "96CFEA14605480F2CAC7A5BABB016DB2", hash_generated_method = "5CF5C47CFF3D701A7C663ABF8A570807")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public HandleView(Drawable drawableLtr, Drawable drawableRtl) {
            super(TextView.this.mContext);
            dsTaint.addTaint(drawableRtl.dsTaint);
            dsTaint.addTaint(drawableLtr.dsTaint);
            mContainer = new PopupWindow(TextView.this.mContext, null,
                    com.android.internal.R.attr.textSelectHandleWindowStyle);
            mContainer.setSplitTouchEnabled(true);
            mContainer.setClippingEnabled(false);
            mContainer.setWindowLayoutType(WindowManager.LayoutParams.TYPE_APPLICATION_SUB_PANEL);
            mContainer.setContentView(this);
            updateDrawable();
            final int handleHeight;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.192 -0400", hash_original_method = "79B760AD39E8E4DC7B1000745317DEB7", hash_generated_method = "5ADDAD296AA962F79343DA08FBE63033")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected void updateDrawable() {
            final int offset;
            offset = getCurrentCursorOffset();
            final boolean isRtlCharAtOffset;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.192 -0400", hash_original_method = "FC7484D3CDDEA8A708B164CA1D725BB5", hash_generated_method = "A9BDDA27DAB9CFA61C6BAFE0DEA4FE7C")
        @DSModeled(DSC.SAFE)
        private void startTouchUpFilter(int offset) {
            dsTaint.addTaint(offset);
            mNumberPreviousOffsets = 0;
            addPositionToTouchUpFilter(offset);
            // ---------- Original Method ----------
            //mNumberPreviousOffsets = 0;
            //addPositionToTouchUpFilter(offset);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.192 -0400", hash_original_method = "F067815A22302FA44603BE1943641FAF", hash_generated_method = "180DAD126776C3E38F34E932CCC1C89E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void addPositionToTouchUpFilter(int offset) {
            dsTaint.addTaint(offset);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.193 -0400", hash_original_method = "55F0EF9CEF8C5AA4299D2A57A3F07803", hash_generated_method = "8A34D019986AB913060033D9A968F722")
        @DSModeled(DSC.SAFE)
        private void filterOnTouchUp() {
            final long now;
            now = SystemClock.uptimeMillis();
            int i;
            i = 0;
            int index;
            index = mPreviousOffsetIndex;
            final int iMax;
            iMax = Math.min(mNumberPreviousOffsets, HISTORY_SIZE);
            {
                i++;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.193 -0400", hash_original_method = "8E1053DB926B4787A5B252A5CCF7E3E6", hash_generated_method = "15D6920ED716B817444A02029A3EDE94")
        @DSModeled(DSC.SAFE)
        public boolean offsetHasBeenChanged() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mNumberPreviousOffsets > 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.193 -0400", hash_original_method = "F1B9B11E208A14EF1A8385C794E8615A", hash_generated_method = "C901E665C3E54E715AC059B1C5F660A1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(heightMeasureSpec);
            dsTaint.addTaint(widthMeasureSpec);
            setMeasuredDimension(mDrawable.getIntrinsicWidth(), mDrawable.getIntrinsicHeight());
            // ---------- Original Method ----------
            //setMeasuredDimension(mDrawable.getIntrinsicWidth(), mDrawable.getIntrinsicHeight());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.193 -0400", hash_original_method = "0CEFB75F912E1774230D056666C1CB4D", hash_generated_method = "AB543FE36A288A29757C77C3168AEA4C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void show() {
            {
                boolean varC328115627DFB8318D2C3484959F5057_967235412 = (isShowing());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.193 -0400", hash_original_method = "58A1CA71E65CA8505283F80ECD55B125", hash_generated_method = "FAD0D503597A6ABE326524871350A175")
        @DSModeled(DSC.SAFE)
        protected void dismiss() {
            mIsDragging = false;
            mContainer.dismiss();
            onDetached();
            // ---------- Original Method ----------
            //mIsDragging = false;
            //mContainer.dismiss();
            //onDetached();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.193 -0400", hash_original_method = "E51AD13D62B6328756BEDC07E20C91A7", hash_generated_method = "BC5477B2853797A83290D6A4A3A8DAE3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void hide() {
            dismiss();
            TextView.this.getPositionListener().removeSubscriber(this);
            // ---------- Original Method ----------
            //dismiss();
            //TextView.this.getPositionListener().removeSubscriber(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.193 -0400", hash_original_method = "0D5333D88B146866CC739B7BC1FA2E0A", hash_generated_method = "EC2FFC919A43C8D8DD208428D966ACF3")
        @DSModeled(DSC.SAFE)
         void showActionPopupWindow(int delay) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(delay);
            {
                mActionPopupWindow = new ActionPopupWindow();
            } //End block
            {
                mActionPopupShower = new Runnable() {
                    public void run() {
                        mActionPopupWindow.show();
                    }
                };
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.193 -0400", hash_original_method = "7E990B2771AC26D4AD93278F16BEC9C8", hash_generated_method = "612ECA58EC0B112F6FF0D0557A096D7B")
        @DSModeled(DSC.SAFE)
        protected void hideActionPopupWindow() {
            //DSFIXME:  CODE0009: Possible callback target function detected
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.193 -0400", hash_original_method = "4C582CFB225DCFD162C1BDA55C8E191D", hash_generated_method = "ED73BBCA4221968343A0AC2A8D0A7455")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean isShowing() {
            boolean var150C3AF6C0593C2D596AE332D213A317_1991539934 = (mContainer.isShowing());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mContainer.isShowing();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.193 -0400", hash_original_method = "622F11C59DDFBBB8F6FA4F43A2282A80", hash_generated_method = "579F9F320BFC68F5479FEB41C37B155A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private boolean isVisible() {
            {
                boolean var50BDB7CF84FD9415E39B194F38BCA676_1265650863 = (isInBatchEditMode());
            } //End collapsed parenthetic
            boolean varFDA4E5DACCCE5BDB1C7FF02945B0CF5E_1972703148 = (TextView.this.isPositionVisible(mPositionX + mHotspotX, mPositionY));
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.193 -0400", hash_original_method = "23AE0E97732D2E1BD689A17102858930", hash_generated_method = "CDA43BF893978D3A06A553323264FA62")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected void positionAtCursorOffset(int offset, boolean parentScrolled) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(parentScrolled);
            dsTaint.addTaint(offset);
            {
                prepareCursorControllers();
            } //End block
            {
                updateSelection(offset);
                addPositionToTouchUpFilter(offset);
                final int line;
                line = mLayout.getLineForOffset(offset);
                mPositionX = (int) (mLayout.getPrimaryHorizontal(offset) - 0.5f - mHotspotX);
                mPositionY = mLayout.getLineBottom(line);
                mPositionX += viewportToContentHorizontalOffset();
                mPositionY += viewportToContentVerticalOffset();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.194 -0400", hash_original_method = "13FE1FBB4F8CE63ECDC017603A6579A6", hash_generated_method = "E05DA81D968D721B8829B21B1D9B0FDD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void updatePosition(int parentPositionX, int parentPositionY,
                boolean parentPositionChanged, boolean parentScrolled) {
            dsTaint.addTaint(parentScrolled);
            dsTaint.addTaint(parentPositionX);
            dsTaint.addTaint(parentPositionY);
            dsTaint.addTaint(parentPositionChanged);
            positionAtCursorOffset(getCurrentCursorOffset(), parentScrolled);
            {
                {
                    {
                        mTouchToWindowOffsetX += parentPositionX - mLastParentX;
                        mTouchToWindowOffsetY += parentPositionY - mLastParentY;
                    } //End block
                    onHandleMoved();
                } //End block
                {
                    boolean varFF8AC1520C23E15E72910D87BF05E9DD_21479094 = (isVisible());
                    {
                        final int positionX;
                        positionX = parentPositionX + mPositionX;
                        final int positionY;
                        positionY = parentPositionY + mPositionY;
                        {
                            boolean varAD9BB22364C576DF82257324184E3F6D_734619799 = (isShowing());
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
                            boolean varAD9BB22364C576DF82257324184E3F6D_1167567237 = (isShowing());
                            {
                                dismiss();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                mPositionHasChanged = false;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.194 -0400", hash_original_method = "F8254677C35EEC48CDE0AC0DA5BFAEC5", hash_generated_method = "076825C6D871D9A6EF040B9980638232")
        @DSModeled(DSC.SAFE)
        @Override
        protected void onDraw(Canvas c) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(c.dsTaint);
            mDrawable.setBounds(0, 0, mRight - mLeft, mBottom - mTop);
            mDrawable.draw(c);
            // ---------- Original Method ----------
            //mDrawable.setBounds(0, 0, mRight - mLeft, mBottom - mTop);
            //mDrawable.draw(c);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.194 -0400", hash_original_method = "AFDBACCAFCABC81309AB0079A4EAD49F", hash_generated_method = "FAFA0C728B3EDE51AC8FA034C941C2DD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean onTouchEvent(MotionEvent ev) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(ev.dsTaint);
            {
                Object var373A6BAE1146FCFC2FEA12BA752DB0E2_72472805 = (ev.getActionMasked());
                //Begin case MotionEvent.ACTION_DOWN 
                {
                    startTouchUpFilter(getCurrentCursorOffset());
                    mTouchToWindowOffsetX = ev.getRawX() - mPositionX;
                    mTouchToWindowOffsetY = ev.getRawY() - mPositionY;
                    final PositionListener positionListener;
                    positionListener = getPositionListener();
                    mLastParentX = positionListener.getPositionX();
                    mLastParentY = positionListener.getPositionY();
                    mIsDragging = true;
                } //End block
                //End case MotionEvent.ACTION_DOWN 
                //Begin case MotionEvent.ACTION_MOVE 
                {
                    final float rawX;
                    rawX = ev.getRawX();
                    final float rawY;
                    rawY = ev.getRawY();
                    final float previousVerticalOffset;
                    previousVerticalOffset = mTouchToWindowOffsetY - mLastParentY;
                    final float currentVerticalOffset;
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
                    final float newPosX;
                    newPosX = rawX - mTouchToWindowOffsetX + mHotspotX;
                    final float newPosY;
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
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.194 -0400", hash_original_method = "A2059A5EB773F7552F7C3D2AAFE1E47B", hash_generated_method = "1DFF483DF7047FAEC11F7EA94B8F5267")
        @DSModeled(DSC.SAFE)
        public boolean isDragging() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mIsDragging;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.194 -0400", hash_original_method = "5C16B6634DA5CEF817B70D10C5EDCDFD", hash_generated_method = "BA15C6791746CB86782858F2701C5751")
        @DSModeled(DSC.SAFE)
         void onHandleMoved() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            hideActionPopupWindow();
            // ---------- Original Method ----------
            //hideActionPopupWindow();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.194 -0400", hash_original_method = "0744EFF256BE5CA55B7C747C6AB06865", hash_generated_method = "EF26ACF4E8E4D174870BA35B14D61397")
        @DSModeled(DSC.SAFE)
        public void onDetached() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            hideActionPopupWindow();
            // ---------- Original Method ----------
            //hideActionPopupWindow();
        }

        
    }


    
    private class InsertionHandleView extends HandleView {
        private static final int DELAY_BEFORE_HANDLE_FADES_OUT = 4000;
        private static final int RECENT_CUT_COPY_DURATION = 15 * 1000;
        private float mDownPositionX, mDownPositionY;
        private Runnable mHider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.194 -0400", hash_original_method = "F74814C2C752895D626389ECC5F1998A", hash_generated_method = "0CA77A8F37A8F40562EC097E7DE0C5FB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public InsertionHandleView(Drawable drawable) {
            super(drawable, drawable);
            dsTaint.addTaint(drawable.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.194 -0400", hash_original_method = "0F6B36BAB7494929112A1B2A0EAC8D6C", hash_generated_method = "6AB20E0ABC1BFB0EFDE006EFB0188F9C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void show() {
            super.show();
            final long durationSinceCutOrCopy;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.194 -0400", hash_original_method = "59B6A837BA01A6E9F2644C670D997B83", hash_generated_method = "F25FDD3CD70064D6BD3896F765DC7FAE")
        @DSModeled(DSC.SAFE)
        public void showWithActionPopup() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            show();
            showActionPopupWindow(0);
            // ---------- Original Method ----------
            //show();
            //showActionPopupWindow(0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.195 -0400", hash_original_method = "60FC6C1FF502D89543DDAA49F0EA3292", hash_generated_method = "3AFDCB5A05C4BC0BFDE88F7F570DD885")
        @DSModeled(DSC.SAFE)
        private void hideAfterDelay() {
            removeHiderCallback();
            {
                mHider = new Runnable() {
                    public void run() {
                        hide();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.195 -0400", hash_original_method = "C682D1056E8259D8BAEA8A544AED7A4D", hash_generated_method = "F99AAF32F447CD86E65D57A5E6E5333B")
        @DSModeled(DSC.SAFE)
        private void removeHiderCallback() {
            {
                TextView.this.removeCallbacks(mHider);
            } //End block
            // ---------- Original Method ----------
            //if (mHider != null) {
                //TextView.this.removeCallbacks(mHider);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.195 -0400", hash_original_method = "6DC2E28231BC586AA27A394F083E414A", hash_generated_method = "B7EFD831146D7C93388E3D25FC128542")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected int getHotspotX(Drawable drawable, boolean isRtlRun) {
            dsTaint.addTaint(drawable.dsTaint);
            dsTaint.addTaint(isRtlRun);
            int varA8B7D89D4E5B94692BDCD2F6C401B00C_428864287 = (drawable.getIntrinsicWidth() / 2);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return drawable.getIntrinsicWidth() / 2;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.195 -0400", hash_original_method = "0786A2C72AD62CB255408C178910DEC1", hash_generated_method = "4C14E35B9F85561B6967F76396EFB8DB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean onTouchEvent(MotionEvent ev) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(ev.dsTaint);
            final boolean result;
            result = super.onTouchEvent(ev);
            {
                Object var373A6BAE1146FCFC2FEA12BA752DB0E2_578058862 = (ev.getActionMasked());
                //Begin case MotionEvent.ACTION_DOWN 
                mDownPositionX = ev.getRawX();
                //End case MotionEvent.ACTION_DOWN 
                //Begin case MotionEvent.ACTION_DOWN 
                mDownPositionY = ev.getRawY();
                //End case MotionEvent.ACTION_DOWN 
                //Begin case MotionEvent.ACTION_UP 
                {
                    boolean varEEEFE49273E9B0F999D591B54BA07697_1381175135 = (!offsetHasBeenChanged());
                    {
                        final float deltaX;
                        deltaX = mDownPositionX - ev.getRawX();
                        final float deltaY;
                        deltaY = mDownPositionY - ev.getRawY();
                        final float distanceSquared;
                        distanceSquared = deltaX * deltaX + deltaY * deltaY;
                        {
                            {
                                boolean var33D1446792CC339F933EE732A5EACA0F_1726315839 = (mActionPopupWindow != null && mActionPopupWindow.isShowing());
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
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.195 -0400", hash_original_method = "CA0934B91A8FE7B0CF5B9D9FD475827B", hash_generated_method = "3C29A49E637E6A8CFBFD89A93DCE9649")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int getCurrentCursorOffset() {
            int var3A0ADF979623B6D0242973915DBE6180_281277957 = (TextView.this.getSelectionStart());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return TextView.this.getSelectionStart();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.195 -0400", hash_original_method = "A55C2EA19B8C1EC0135F14E2406421A5", hash_generated_method = "7D7E5A845B4B4008BFA549E09F84B4B7")
        @DSModeled(DSC.SAFE)
        @Override
        public void updateSelection(int offset) {
            dsTaint.addTaint(offset);
            Selection.setSelection((Spannable) mText, offset);
            // ---------- Original Method ----------
            //Selection.setSelection((Spannable) mText, offset);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.195 -0400", hash_original_method = "76FEC5259BD2EF7A10D2C6D9447263AD", hash_generated_method = "14285F1CB22200A2CC85BF6B92A130A8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void updatePosition(float x, float y) {
            dsTaint.addTaint(y);
            dsTaint.addTaint(x);
            positionAtCursorOffset(getOffsetForPosition(x, y), false);
            // ---------- Original Method ----------
            //positionAtCursorOffset(getOffsetForPosition(x, y), false);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.195 -0400", hash_original_method = "DF26232D8C6513289215597105F4C19A", hash_generated_method = "BBC6932F045F9B2CE73EA9BF7B21E36F")
        @DSModeled(DSC.SAFE)
        @Override
         void onHandleMoved() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            super.onHandleMoved();
            removeHiderCallback();
            // ---------- Original Method ----------
            //super.onHandleMoved();
            //removeHiderCallback();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.195 -0400", hash_original_method = "58D1696EBF955B571F830BA2F6EDC257", hash_generated_method = "9D9F255BF0DE5428FACBF63E88FB2A79")
        @DSModeled(DSC.SAFE)
        @Override
        public void onDetached() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            super.onDetached();
            removeHiderCallback();
            // ---------- Original Method ----------
            //super.onDetached();
            //removeHiderCallback();
        }

        
    }


    
    private class SelectionStartHandleView extends HandleView {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.195 -0400", hash_original_method = "83BC78691BC747F1E4426492F397A3E5", hash_generated_method = "7EBDC899551659F50441A8AFF35B4565")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SelectionStartHandleView(Drawable drawableLtr, Drawable drawableRtl) {
            super(drawableLtr, drawableRtl);
            dsTaint.addTaint(drawableRtl.dsTaint);
            dsTaint.addTaint(drawableLtr.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.195 -0400", hash_original_method = "E4FEF24C3E269A0B427919DBE201803F", hash_generated_method = "E94BBF91941B6778B77B8946F60A6071")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected int getHotspotX(Drawable drawable, boolean isRtlRun) {
            dsTaint.addTaint(drawable.dsTaint);
            dsTaint.addTaint(isRtlRun);
            {
                int var825C3AB963C858F505D8A99BED9B8FB2_1427389985 = (drawable.getIntrinsicWidth() / 4);
            } //End block
            {
                int var2619A169F3B5A531F91E617BA41D1854_1310502458 = ((drawable.getIntrinsicWidth() * 3) / 4);
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (isRtlRun) {
                //return drawable.getIntrinsicWidth() / 4;
            //} else {
                //return (drawable.getIntrinsicWidth() * 3) / 4;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.196 -0400", hash_original_method = "CA0934B91A8FE7B0CF5B9D9FD475827B", hash_generated_method = "E9D03CDAC5E839440366DE9D32EDDBA1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int getCurrentCursorOffset() {
            int var3A0ADF979623B6D0242973915DBE6180_985864663 = (TextView.this.getSelectionStart());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return TextView.this.getSelectionStart();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.196 -0400", hash_original_method = "E42DF79873294756C3452434D16E6BD3", hash_generated_method = "399892CDFFAAA7EC784AA9AB0ED3A672")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void updateSelection(int offset) {
            dsTaint.addTaint(offset);
            Selection.setSelection((Spannable) mText, offset, getSelectionEnd());
            updateDrawable();
            // ---------- Original Method ----------
            //Selection.setSelection((Spannable) mText, offset, getSelectionEnd());
            //updateDrawable();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.196 -0400", hash_original_method = "7B45D907648A79384D6568EC81E6D22D", hash_generated_method = "565F51CF5B125FB5DDB7043290AAD866")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void updatePosition(float x, float y) {
            dsTaint.addTaint(y);
            dsTaint.addTaint(x);
            int offset;
            offset = getOffsetForPosition(x, y);
            final int selectionEnd;
            selectionEnd = getSelectionEnd();
            offset = Math.max(0, selectionEnd - 1);
            positionAtCursorOffset(offset, false);
            // ---------- Original Method ----------
            //int offset = getOffsetForPosition(x, y);
            //final int selectionEnd = getSelectionEnd();
            //if (offset >= selectionEnd) offset = Math.max(0, selectionEnd - 1);
            //positionAtCursorOffset(offset, false);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.196 -0400", hash_original_method = "0C631CE72876F998F945C3B67884BC26", hash_generated_method = "CC63201144CA12F63CAB59055188660E")
        @DSModeled(DSC.SAFE)
        public ActionPopupWindow getActionPopupWindow() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            return (ActionPopupWindow)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mActionPopupWindow;
        }

        
    }


    
    private class SelectionEndHandleView extends HandleView {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.196 -0400", hash_original_method = "883DF21D67E4B772D6E1A322F4D5F533", hash_generated_method = "2F2B86E7D3452DA8B4BEF80FAACC7F6A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SelectionEndHandleView(Drawable drawableLtr, Drawable drawableRtl) {
            super(drawableLtr, drawableRtl);
            dsTaint.addTaint(drawableRtl.dsTaint);
            dsTaint.addTaint(drawableLtr.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.196 -0400", hash_original_method = "6A8A8B43FF48B8BB585E51FD6E86C9E2", hash_generated_method = "115ADDB549740434D9863F0321B2DA0C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected int getHotspotX(Drawable drawable, boolean isRtlRun) {
            dsTaint.addTaint(drawable.dsTaint);
            dsTaint.addTaint(isRtlRun);
            {
                int var2619A169F3B5A531F91E617BA41D1854_1637636839 = ((drawable.getIntrinsicWidth() * 3) / 4);
            } //End block
            {
                int var825C3AB963C858F505D8A99BED9B8FB2_1956056611 = (drawable.getIntrinsicWidth() / 4);
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (isRtlRun) {
                //return (drawable.getIntrinsicWidth() * 3) / 4;
            //} else {
                //return drawable.getIntrinsicWidth() / 4;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.196 -0400", hash_original_method = "CA6DDFB8F86FC43076502B090D003904", hash_generated_method = "06A61BAC14E34CCC1BEED6BE3DA25A8D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int getCurrentCursorOffset() {
            int varA2E0C17AA3D1EB612E8CF0B487723C9B_1978007365 = (TextView.this.getSelectionEnd());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return TextView.this.getSelectionEnd();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.196 -0400", hash_original_method = "B3473CE6965F2521B605BA0101D0A91A", hash_generated_method = "1674E09CE68E77200C9DBA54B1C555A8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void updateSelection(int offset) {
            dsTaint.addTaint(offset);
            Selection.setSelection((Spannable) mText, getSelectionStart(), offset);
            updateDrawable();
            // ---------- Original Method ----------
            //Selection.setSelection((Spannable) mText, getSelectionStart(), offset);
            //updateDrawable();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.196 -0400", hash_original_method = "DE26EB392137324C128BF7B92FEE748A", hash_generated_method = "310C6902389D7CEC390749C0F25DC81D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void updatePosition(float x, float y) {
            dsTaint.addTaint(y);
            dsTaint.addTaint(x);
            int offset;
            offset = getOffsetForPosition(x, y);
            final int selectionStart;
            selectionStart = getSelectionStart();
            offset = Math.min(selectionStart + 1, mText.length());
            positionAtCursorOffset(offset, false);
            // ---------- Original Method ----------
            //int offset = getOffsetForPosition(x, y);
            //final int selectionStart = getSelectionStart();
            //if (offset <= selectionStart) offset = Math.min(selectionStart + 1, mText.length());
            //positionAtCursorOffset(offset, false);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.196 -0400", hash_original_method = "1AE0953CF1E401F1791B2AA9D0C762E1", hash_generated_method = "53D70E462F8D513C599C258CFA1A42BD")
        @DSModeled(DSC.SAFE)
        public void setActionPopupWindow(ActionPopupWindow actionPopupWindow) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(actionPopupWindow.dsTaint);
            mActionPopupWindow = actionPopupWindow;
            // ---------- Original Method ----------
            //mActionPopupWindow = actionPopupWindow;
        }

        
    }


    
    private class InsertionPointCursorController implements CursorController {
        private InsertionHandleView mHandle;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.196 -0400", hash_original_method = "5D45AEF69914729B932C554DDDCEB4D3", hash_generated_method = "6526F702C41F0CDD64B51E03268179E7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void show() {
            getHandle().show();
            // ---------- Original Method ----------
            //getHandle().show();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.196 -0400", hash_original_method = "BEDA636D814D43341B0837622BB75D12", hash_generated_method = "68118B24FEFC67D1E3FB2A78486F157A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void showWithActionPopup() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            getHandle().showWithActionPopup();
            // ---------- Original Method ----------
            //getHandle().showWithActionPopup();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.196 -0400", hash_original_method = "99DAD3C319227F2A1F78AE95D96BD2B3", hash_generated_method = "330FA5E07111BB1FFB47EA09675D6471")
        @DSModeled(DSC.SAFE)
        public void hide() {
            {
                mHandle.hide();
            } //End block
            // ---------- Original Method ----------
            //if (mHandle != null) {
                //mHandle.hide();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.196 -0400", hash_original_method = "43F562659DF9586EE8DC985200A1394B", hash_generated_method = "D40C53B9EE92733D1B4885A879CD7F14")
        @DSModeled(DSC.SAFE)
        public void onTouchModeChanged(boolean isInTouchMode) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(isInTouchMode);
            {
                hide();
            } //End block
            // ---------- Original Method ----------
            //if (!isInTouchMode) {
                //hide();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.196 -0400", hash_original_method = "AFBF832B3C2DD5F3EC6366306B6BB027", hash_generated_method = "D9A697D96232CA57CBC380F0BD2F2FB3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private InsertionHandleView getHandle() {
            {
                mSelectHandleCenter = mContext.getResources().getDrawable(
                        mTextSelectHandleRes);
            } //End block
            {
                mHandle = new InsertionHandleView(mSelectHandleCenter);
            } //End block
            return (InsertionHandleView)dsTaint.getTaint();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.197 -0400", hash_original_method = "5CA35A7F100FC077200BA56F0D1F67CB", hash_generated_method = "9AE2A541721A940AAE014FF55275810D")
        @DSModeled(DSC.SAFE)
        @Override
        public void onDetached() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            final ViewTreeObserver observer;
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
        private static final int DELAY_BEFORE_REPLACE_ACTION = 200;
        private SelectionStartHandleView mStartHandle;
        private SelectionEndHandleView mEndHandle;
        private int mMinTouchOffset, mMaxTouchOffset;
        private long mPreviousTapUpTime = 0;
        private float mPreviousTapPositionX, mPreviousTapPositionY;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.197 -0400", hash_original_method = "7762686ED4BD194662F98430835FCC93", hash_generated_method = "8B6ECBF63899EEFB30DBF05E298C6ED7")
        @DSModeled(DSC.SAFE)
         SelectionModifierCursorController() {
            resetTouchOffsets();
            // ---------- Original Method ----------
            //resetTouchOffsets();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.197 -0400", hash_original_method = "803DF98A86477F9509B518860444CA62", hash_generated_method = "CA20F0453BB64C5EC407E9EB5B6EA2CD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void show() {
            {
                boolean var50BDB7CF84FD9415E39B194F38BCA676_616446293 = (isInBatchEditMode());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.197 -0400", hash_original_method = "2C322B9176F95E96CE86AF105C0AA144", hash_generated_method = "804667F88ABDEBF499ADC8A2ED359FF1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.197 -0400", hash_original_method = "C3351664D38EE8E6983EFA56F5011D2A", hash_generated_method = "9EFC2ABE3409537EE115BEF41E297095")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.198 -0400", hash_original_method = "9904AE40606D29E60FAC10481978E041", hash_generated_method = "3E2DBE4D779E80BCE923DBD22EC8FE5D")
        @DSModeled(DSC.SAFE)
        public void hide() {
            mStartHandle.hide();
            mEndHandle.hide();
            // ---------- Original Method ----------
            //if (mStartHandle != null) mStartHandle.hide();
            //if (mEndHandle != null) mEndHandle.hide();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.198 -0400", hash_original_method = "4BB059019645E4258A18514D6F6D1609", hash_generated_method = "0835F05FE9D35FC1D75E7A126849A3FE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onTouchEvent(MotionEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(event.dsTaint);
            {
                Object varF6D597E8558CB9D89114B4B1D82BA68F_92476991 = (event.getActionMasked());
                //Begin case MotionEvent.ACTION_DOWN 
                final float x;
                x = event.getX();
                //End case MotionEvent.ACTION_DOWN 
                //Begin case MotionEvent.ACTION_DOWN 
                final float y;
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
                    boolean varD222D501AFFB3FFBAB7C6BF5A68FBCF1_1966039943 = (duration <= ViewConfiguration.getDoubleTapTimeout() &&
                            isPositionOnText(x, y));
                    {
                        final float deltaX;
                        deltaX = x - mPreviousTapPositionX;
                        final float deltaY;
                        deltaY = y - mPreviousTapPositionY;
                        final float distanceSquared;
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
                    boolean var4F7B392379BD182D25B1AE93077ACAB8_147074658 = (mContext.getPackageManager().hasSystemFeature(
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
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.198 -0400", hash_original_method = "ABEB7C98C3FEAD2725211345FA5A10D0", hash_generated_method = "D0A84514320FE4A222F08EAC7D3D4137")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void updateMinAndMaxOffsets(MotionEvent event) {
            dsTaint.addTaint(event.dsTaint);
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
            // ---------- Original Method ----------
            //int pointerCount = event.getPointerCount();
            //for (int index = 0; index < pointerCount; index++) {
                //int offset = getOffsetForPosition(event.getX(index), event.getY(index));
                //if (offset < mMinTouchOffset) mMinTouchOffset = offset;
                //if (offset > mMaxTouchOffset) mMaxTouchOffset = offset;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.198 -0400", hash_original_method = "CE1D6B62E449D2E0E68A6EA4156BEDFA", hash_generated_method = "043B3E3584B1F4D2820AD850DE203578")
        @DSModeled(DSC.SAFE)
        public int getMinTouchOffset() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mMinTouchOffset;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.198 -0400", hash_original_method = "C55B3C28483F8C218641DDDF4F4BCFF7", hash_generated_method = "4AE589A0CF00D20A2A37ACF21088B20D")
        @DSModeled(DSC.SAFE)
        public int getMaxTouchOffset() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mMaxTouchOffset;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.198 -0400", hash_original_method = "4C87B6BF406B366B26A5C4FE4B60E794", hash_generated_method = "41D4261163AE655B6BBA89E729DCBA53")
        @DSModeled(DSC.SAFE)
        public void resetTouchOffsets() {
            mMinTouchOffset = mMaxTouchOffset = -1;
            // ---------- Original Method ----------
            //mMinTouchOffset = mMaxTouchOffset = -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.198 -0400", hash_original_method = "CED25BB71024452A25A320AF88BD1346", hash_generated_method = "E88BC82AFF11A69AB68F72D4E5B09CCA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean isSelectionStartDragged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            boolean var3AC7E3EAE321C45E3F97AC24793B70E6_1281219941 = (mStartHandle != null && mStartHandle.isDragging());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mStartHandle != null && mStartHandle.isDragging();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.198 -0400", hash_original_method = "43F562659DF9586EE8DC985200A1394B", hash_generated_method = "D40C53B9EE92733D1B4885A879CD7F14")
        @DSModeled(DSC.SAFE)
        public void onTouchModeChanged(boolean isInTouchMode) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(isInTouchMode);
            {
                hide();
            } //End block
            // ---------- Original Method ----------
            //if (!isInTouchMode) {
                //hide();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.198 -0400", hash_original_method = "190B38DD5A1110FFE55D8237DE7DCE67", hash_generated_method = "C7B80B8BFA7990EBC5315F4932112E66")
        @DSModeled(DSC.SAFE)
        @Override
        public void onDetached() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            final ViewTreeObserver observer;
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
    
    static {
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.measureText("H");
    }
    
}


