package android.widget;

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
//import android.text.TextUtils.TruncateAt; //DSFIXME:  Commented this out...
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
//import android.view.ViewGroup.LayoutParams;
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

import droidsafe.annotations.*;
import droidsafe.helpers.*;

@RemoteView
public class TextView extends View implements ViewTreeObserver.OnPreDrawListener {
	static final String LOG_TAG = "TextView";
    static final boolean DEBUG_EXTRACT = false;
    
    private static final int SIGNED = 2;
    private static final int DECIMAL = 4;
    private static final int PRIORITY = 100;
    private static final int PREDRAW_NOT_REGISTERED = 0;
    private static final int PREDRAW_PENDING = 1;
    private static final int PREDRAW_DONE = 2;
    private static final int MARQUEE_FADE_NORMAL = 0;
    private static final int MARQUEE_FADE_SWITCH_SHOW_ELLIPSIS = 1;
    private static final int MARQUEE_FADE_SWITCH_SHOW_FADE = 2;
    
    private int mPreDrawState = PREDRAW_NOT_REGISTERED;

    private static enum TextAlign {
        INHERIT, GRAVITY, TEXT_START, TEXT_END, CENTER, VIEW_START, VIEW_END;
    }
    
    static {
        Paint p = new Paint();
        p.setAntiAlias(true);
        // We don't care about the result, just the side-effect of measuring.
        p.measureText("H");
    }
    
    @DSModeled(DSC.SAFE)
    public TextView(Context context) {
        this(context, null);
    }

    @DSModeled(DSC.SAFE)
    public TextView(Context context,
                    AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.textViewStyle);
    }

    @DSModeled(DSC.SAFE)
    @SuppressWarnings("deprecation")
    public TextView(Context context,
                    AttributeSet attrs,
                    int defStyle) {
        super(context, attrs, defStyle);
        /*
         * For the most part, this function initializes a multitude of internal structures
         * and state.  It is also an extremely long function, so the original implementation
         * is not going to be included.
         */
    }

	@Override
	public boolean onPreDraw() {
		return true;
		/*
        if (mPreDrawState != PREDRAW_PENDING) {
            return true;
        }

        if (mLayout == null) {
            assumeLayout();
        }

        boolean changed = false;

        if (mMovement != null) {
            int curs = getSelectionEnd();
            // Do not create the controller if it is not already created.
            if (mSelectionModifierCursorController != null &&
                    mSelectionModifierCursorController.isSelectionStartDragged()) {
                curs = getSelectionStart();
            }

            if (curs < 0 &&
                  (mGravity & Gravity.VERTICAL_GRAVITY_MASK) == Gravity.BOTTOM) {
                curs = mText.length();
            }

            if (curs >= 0) {
                changed = bringPointIntoView(curs);
            }
        } else {
            changed = bringTextIntoView();
        }

        // This has to be checked here since:
        // - onFocusChanged cannot start it when focus is given to a view with selected text (after
        //   a screen rotation) since layout is not yet initialized at that point.
        if (mCreatedWithASelection) {
            startSelectionActionMode();
            mCreatedWithASelection = false;
        }

        // Phone specific code (there is no ExtractEditText on tablets).
        // ExtractEditText does not call onFocus when it is displayed, and mHasSelectionOnFocus can
        // not be set. Do the test here instead.
        if (this instanceof ExtractEditText && hasSelection()) {
            startSelectionActionMode();
        }

        mPreDrawState = PREDRAW_DONE;
        return !changed;
        */
    }
	
	@DSModeled(DSC.SAFE)
	@android.view.RemotableViewMethod
    public final void setText(CharSequence text) {
		setText(text, BufferType.NORMAL);
        //setText(text, mBufferType);
    }
	
	@DSModeled(DSC.SAFE)
	public void setText(CharSequence text, BufferType type) {
        setText(text, type, true, 0);
        /*
        if (mCharWrapper != null) {
            mCharWrapper.mChars = null;
        }
        */
    }
	
	private CharSequence mText;
	private BufferType mBufferType;
	private DSTaintObject dsTaint = new DSTaintObject();
	
	@DSModeled(DSC.SAFE)
	private void setText(CharSequence text, BufferType type,
            boolean notifyBefore, int oldlen) {
		dsTaint.addTaints(text, type);
		mBufferType = type;
        mText = text;
	}
	
	public enum BufferType {
		NORMAL, SPANNABLE, EDITABLE;
		
		@DSModeled(DSC.SAFE)
		BufferType() {
			//Not in the original implementation, added for specdump
		}
    }
	
	@DSModeled(DSC.SAFE)
	@Override
    protected void onDraw(Canvas canvas) {
		//DSFIXME:  Stubbed out method for now.  Underlying function is very large.
		super.onDraw(canvas);
	}
	
	@DSModeled(DSC.SAFE)
	public CharSequence getText() {
        return new String();
    }
}
