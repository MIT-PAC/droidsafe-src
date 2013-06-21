package android.inputmethodservice;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.InputType;
import android.text.Layout;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.util.Log;
import android.util.PrintWriterPrinter;
import android.util.Printer;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputBinding;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class InputMethodService extends AbstractInputMethodService {
    InputMethodManager mImm;
    int mTheme = 0;
    LayoutInflater mInflater;
    TypedArray mThemeAttrs;
    View mRootView;
    SoftInputWindow mWindow;
    boolean mInitialized;
    boolean mWindowCreated;
    boolean mWindowAdded;
    boolean mWindowVisible;
    boolean mWindowWasVisible;
    boolean mInShowWindow;
    ViewGroup mFullscreenArea;
    FrameLayout mExtractFrame;
    FrameLayout mCandidatesFrame;
    FrameLayout mInputFrame;
    IBinder mToken;
    InputBinding mInputBinding;
    InputConnection mInputConnection;
    boolean mInputStarted;
    boolean mInputViewStarted;
    boolean mCandidatesViewStarted;
    InputConnection mStartedInputConnection;
    EditorInfo mInputEditorInfo;
    int mShowInputFlags;
    boolean mShowInputRequested;
    boolean mLastShowInputRequested;
    int mCandidatesVisibility;
    CompletionInfo[] mCurCompletions;
    boolean mShowInputForced;
    boolean mFullscreenApplied;
    boolean mIsFullscreen;
    View mExtractView;
    boolean mExtractViewHidden;
    ExtractEditText mExtractEditText;
    ViewGroup mExtractAccessories;
    Button mExtractAction;
    ExtractedText mExtractedText;
    int mExtractedToken;
    View mInputView;
    boolean mIsInputViewShown;
    int mStatusIcon;
    int mBackDisposition;
    Insets mTmpInsets = new Insets();
    int[] mTmpLocation = new int[2];
    final ViewTreeObserver.OnComputeInternalInsetsListener mInsetsComputer = new ViewTreeObserver.OnComputeInternalInsetsListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.366 -0400", hash_original_method = "3A80214106299C195F4E4A04B9DB62AA", hash_generated_method = "1D1D21F6C0D05A2FBEBC151FD370ECB1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onComputeInternalInsets(ViewTreeObserver.InternalInsetsInfo info) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(info.dsTaint);
            {
                boolean var1E9E12E1C314AB48D78EC2186631F908_946105987 = (isExtractViewShown());
                {
                    View decor;
                    decor = getWindow().getWindow().getDecorView();
                    info.contentInsets.top = info.visibleInsets.top
                        = decor.getHeight();
                    info.touchableRegion.setEmpty();
                    info.setTouchableInsets(ViewTreeObserver.InternalInsetsInfo.TOUCHABLE_INSETS_FRAME);
                } //End block
                {
                    onComputeInsets(mTmpInsets);
                    info.contentInsets.top = mTmpInsets.contentTopInsets;
                    info.visibleInsets.top = mTmpInsets.visibleTopInsets;
                    info.touchableRegion.set(mTmpInsets.touchableRegion);
                    info.setTouchableInsets(mTmpInsets.touchableInsets);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (isExtractViewShown()) {
                //View decor = getWindow().getWindow().getDecorView();
                //info.contentInsets.top = info.visibleInsets.top
                        //= decor.getHeight();
                //info.touchableRegion.setEmpty();
                //info.setTouchableInsets(ViewTreeObserver.InternalInsetsInfo.TOUCHABLE_INSETS_FRAME);
            //} else {
                //onComputeInsets(mTmpInsets);
                //info.contentInsets.top = mTmpInsets.contentTopInsets;
                //info.visibleInsets.top = mTmpInsets.visibleTopInsets;
                //info.touchableRegion.set(mTmpInsets.touchableRegion);
                //info.setTouchableInsets(mTmpInsets.touchableInsets);
            //}
        }

        
}; //Transformed anonymous class
    final View.OnClickListener mActionClickListener = new View.OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.366 -0400", hash_original_method = "F78C13955980C6EBFBCB4858D6B59E8E", hash_generated_method = "E100444144B6AFE0306BE2687E3A2F4D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(v.dsTaint);
            EditorInfo ei;
            ei = getCurrentInputEditorInfo();
            InputConnection ic;
            ic = getCurrentInputConnection();
            {
                {
                    ic.performEditorAction(ei.actionId);
                } //End block
                {
                    ic.performEditorAction(ei.imeOptions&EditorInfo.IME_MASK_ACTION);
                } //End block
            } //End block
            // ---------- Original Method ----------
            //final EditorInfo ei = getCurrentInputEditorInfo();
            //final InputConnection ic = getCurrentInputConnection();
            //if (ei != null && ic != null) {
                //if (ei.actionId != 0) {
                    //ic.performEditorAction(ei.actionId);
                //} else if ((ei.imeOptions&EditorInfo.IME_MASK_ACTION)
                        //!= EditorInfo.IME_ACTION_NONE) {
                    //ic.performEditorAction(ei.imeOptions&EditorInfo.IME_MASK_ACTION);
                //}
            //}
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.366 -0400", hash_original_method = "09C447E7286FE2DF56130FA8BEEF6EBC", hash_generated_method = "09C447E7286FE2DF56130FA8BEEF6EBC")
        public InputMethodService ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.367 -0400", hash_original_method = "A950397745137F47AE3797B428EC17A0", hash_generated_method = "23F4288413F006A80573184A4FA82F7E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setTheme(int theme) {
        dsTaint.addTaint(theme);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Must be called before onCreate()");
        } //End block
        // ---------- Original Method ----------
        //if (mWindow != null) {
            //throw new IllegalStateException("Must be called before onCreate()");
        //}
        //mTheme = theme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.367 -0400", hash_original_method = "A4061C51E6B315B625647A4DAEF1D932", hash_generated_method = "DE550ABE012B963890E5EA21805F7878")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onCreate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mTheme = Resources.selectSystemTheme(mTheme,
                getApplicationInfo().targetSdkVersion,
                android.R.style.Theme_InputMethod,
                android.R.style.Theme_Holo_InputMethod,
                android.R.style.Theme_DeviceDefault_InputMethod);
        super.setTheme(mTheme);
        super.onCreate();
        mImm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        mInflater = (LayoutInflater)getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        mWindow = new SoftInputWindow(this, mTheme, mDispatcherState);
        initViews();
        mWindow.getWindow().setLayout(MATCH_PARENT, WRAP_CONTENT);
        // ---------- Original Method ----------
        //mTheme = Resources.selectSystemTheme(mTheme,
                //getApplicationInfo().targetSdkVersion,
                //android.R.style.Theme_InputMethod,
                //android.R.style.Theme_Holo_InputMethod,
                //android.R.style.Theme_DeviceDefault_InputMethod);
        //super.setTheme(mTheme);
        //super.onCreate();
        //mImm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        //mInflater = (LayoutInflater)getSystemService(
                //Context.LAYOUT_INFLATER_SERVICE);
        //mWindow = new SoftInputWindow(this, mTheme, mDispatcherState);
        //initViews();
        //mWindow.getWindow().setLayout(MATCH_PARENT, WRAP_CONTENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.367 -0400", hash_original_method = "76EDD2B848D79265B59C656C09132FEB", hash_generated_method = "83EE169EF2FBBDAF4C6A06E84EF30B78")
    @DSModeled(DSC.SAFE)
    public void onInitializeInterface() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.368 -0400", hash_original_method = "F1A6BBC586CE4C5158D93D758F9EE4FD", hash_generated_method = "7C63C721EAC547413CE5708A1F496E22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void initialize() {
        {
            mInitialized = true;
            onInitializeInterface();
        } //End block
        // ---------- Original Method ----------
        //if (!mInitialized) {
            //mInitialized = true;
            //onInitializeInterface();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.368 -0400", hash_original_method = "E6A2B0DBCD46A23062A8849E041DB211", hash_generated_method = "9463AE93382E4D886745A0417D8E181F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void initViews() {
        mInitialized = false;
        mWindowCreated = false;
        mShowInputRequested = false;
        mShowInputForced = false;
        mThemeAttrs = obtainStyledAttributes(android.R.styleable.InputMethodService);
        mRootView = mInflater.inflate(
                com.android.internal.R.layout.input_method, null);
        mWindow.setContentView(mRootView);
        mRootView.getViewTreeObserver().addOnComputeInternalInsetsListener(mInsetsComputer);
        {
            boolean var42B91C3FC5E7160C1292C676D44C7C35_871474642 = (Settings.System.getInt(getContentResolver(),
                Settings.System.FANCY_IME_ANIMATIONS, 0) != 0);
            {
                mWindow.getWindow().setWindowAnimations(
                    com.android.internal.R.style.Animation_InputMethodFancy);
            } //End block
        } //End collapsed parenthetic
        mFullscreenArea = (ViewGroup)mRootView.findViewById(com.android.internal.R.id.fullscreenArea);
        mExtractViewHidden = false;
        mExtractFrame = (FrameLayout)mRootView.findViewById(android.R.id.extractArea);
        mExtractView = null;
        mExtractEditText = null;
        mExtractAccessories = null;
        mExtractAction = null;
        mFullscreenApplied = false;
        mCandidatesFrame = (FrameLayout)mRootView.findViewById(android.R.id.candidatesArea);
        mInputFrame = (FrameLayout)mRootView.findViewById(android.R.id.inputArea);
        mInputView = null;
        mIsInputViewShown = false;
        mExtractFrame.setVisibility(View.GONE);
        mCandidatesVisibility = getCandidatesHiddenVisibility();
        mCandidatesFrame.setVisibility(mCandidatesVisibility);
        mInputFrame.setVisibility(View.GONE);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.369 -0400", hash_original_method = "03BF0E4B83AB5EEC5EA04DACA2552646", hash_generated_method = "FED5ACC4025145E20089A53DCC14F84F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onDestroy() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDestroy();
        mRootView.getViewTreeObserver().removeOnComputeInternalInsetsListener(
                mInsetsComputer);
        finishViews();
        {
            mWindow.getWindow().setWindowAnimations(0);
            mWindow.dismiss();
        } //End block
        // ---------- Original Method ----------
        //super.onDestroy();
        //mRootView.getViewTreeObserver().removeOnComputeInternalInsetsListener(
                //mInsetsComputer);
        //finishViews();
        //if (mWindowAdded) {
            //mWindow.getWindow().setWindowAnimations(0);
            //mWindow.dismiss();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.369 -0400", hash_original_method = "0B7AD8CA788BAE093A6DAEC0C292F050", hash_generated_method = "0F6071862BD58B40C4BED1A5D0C73955")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newConfig.dsTaint);
        super.onConfigurationChanged(newConfig);
        boolean visible;
        visible = mWindowVisible;
        int showFlags;
        showFlags = mShowInputFlags;
        boolean showingInput;
        showingInput = mShowInputRequested;
        CompletionInfo[] completions;
        completions = mCurCompletions;
        initViews();
        mInputViewStarted = false;
        mCandidatesViewStarted = false;
        {
            doStartInput(getCurrentInputConnection(),
                    getCurrentInputEditorInfo(), true);
        } //End block
        {
            {
                {
                    boolean varE76E4AD258BBF3AE36D8B1906DE05BFD_485348181 = (onShowInputRequested(showFlags, true));
                    {
                        showWindow(true);
                        {
                            mCurCompletions = completions;
                            onDisplayCompletions(completions);
                        } //End block
                    } //End block
                    {
                        hideWindow();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                showWindow(false);
            } //End block
            {
                hideWindow();
            } //End block
            boolean showing;
            showing = onEvaluateInputViewShown();
            mImm.setImeWindowStatus(mToken, IME_ACTIVE | (showing ? IME_VISIBLE : 0),
                    mBackDisposition);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.370 -0400", hash_original_method = "4C23D68F9AF6231E77018CB50F89B333", hash_generated_method = "C783DC1B884B88AA2E340EBCDB4D42DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public AbstractInputMethodImpl onCreateInputMethodInterface() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        AbstractInputMethodImpl varB5F6C49F9E65BD7456F7F223F1DFAC14_1762111176 = (new InputMethodImpl());
        return (AbstractInputMethodImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new InputMethodImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.370 -0400", hash_original_method = "A293E788F38BE631F0B24DA3CBEC4EAD", hash_generated_method = "893917187C72156E042D32CFE9F3B9FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public AbstractInputMethodSessionImpl onCreateInputMethodSessionInterface() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        AbstractInputMethodSessionImpl varAE27B42AF57D743BFE13EE5F047BE5C7_165807645 = (new InputMethodSessionImpl());
        return (AbstractInputMethodSessionImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new InputMethodSessionImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.370 -0400", hash_original_method = "F107DE3A8547E443866FF02369203993", hash_generated_method = "353763DEB01EC7DBA591DE756D582DED")
    @DSModeled(DSC.SAFE)
    public LayoutInflater getLayoutInflater() {
        return (LayoutInflater)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mInflater;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.370 -0400", hash_original_method = "B35683FF457638BA2516208C83F2FBFC", hash_generated_method = "9DF132718C989A3FA87F193ED4B3BD71")
    @DSModeled(DSC.SAFE)
    public Dialog getWindow() {
        return (Dialog)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mWindow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.371 -0400", hash_original_method = "4B38ED63C74A7D25A43EF42301FB70B0", hash_generated_method = "3977E1F75BA28DE4938B741774150896")
    @DSModeled(DSC.SAFE)
    public void setBackDisposition(int disposition) {
        dsTaint.addTaint(disposition);
        // ---------- Original Method ----------
        //mBackDisposition = disposition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.371 -0400", hash_original_method = "FA0668AA74F2A3E40C75CD8A8BEC8D4A", hash_generated_method = "1EDA87CF87D85D079C618FDDD44A4680")
    @DSModeled(DSC.SAFE)
    public int getBackDisposition() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBackDisposition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.371 -0400", hash_original_method = "BF0CCCE3A6DFBF869485401A0C0B52E1", hash_generated_method = "29DA7053E9312CB9D37AEDF423777ED2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMaxWidth() {
        WindowManager wm;
        wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        int var2277AEB58FD93D1A35DD1F32A4E8EB14_382680680 = (wm.getDefaultDisplay().getWidth());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        //return wm.getDefaultDisplay().getWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.371 -0400", hash_original_method = "064CBE2A131D4B226EADDD6A40CEAEED", hash_generated_method = "863C1BCFB1228A22E9B979BC30B5B10F")
    @DSModeled(DSC.SAFE)
    public InputBinding getCurrentInputBinding() {
        return (InputBinding)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mInputBinding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.372 -0400", hash_original_method = "25EFF753F3CF5167178BD7379B9659BF", hash_generated_method = "62650DFACCFE05D52F9560A21F4D322C")
    @DSModeled(DSC.SAFE)
    public InputConnection getCurrentInputConnection() {
        InputConnection ic;
        ic = mStartedInputConnection;
        return (InputConnection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //InputConnection ic = mStartedInputConnection;
        //if (ic != null) {
            //return ic;
        //}
        //return mInputConnection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.372 -0400", hash_original_method = "26F207E076BC370412C35CB8C7E97837", hash_generated_method = "FC39C1C20647EC2A14540B29428D9411")
    @DSModeled(DSC.SAFE)
    public boolean getCurrentInputStarted() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mInputStarted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.372 -0400", hash_original_method = "659C592D4ABB3DB82261D1C4692ABF2E", hash_generated_method = "4884B9BAF8F56C45C14EF31AF6AAC7EF")
    @DSModeled(DSC.SAFE)
    public EditorInfo getCurrentInputEditorInfo() {
        return (EditorInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mInputEditorInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.373 -0400", hash_original_method = "27763B4939D9D4CE4F4BEBC3E63AF469", hash_generated_method = "14F454B8A6A0D5A84A2D83C72E0D003D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updateFullscreenMode() {
        boolean isFullscreen;
        isFullscreen = mShowInputRequested && onEvaluateFullscreenMode();
        boolean changed;
        changed = mLastShowInputRequested != mShowInputRequested;
        {
            changed = true;
            mIsFullscreen = isFullscreen;
            InputConnection ic;
            ic = getCurrentInputConnection();
            ic.reportFullscreenMode(isFullscreen);
            mFullscreenApplied = true;
            initialize();
            LinearLayout.LayoutParams lp;
            lp = (LinearLayout.LayoutParams)
                    mFullscreenArea.getLayoutParams();
            {
                mFullscreenArea.setBackgroundDrawable(mThemeAttrs.getDrawable(
                        com.android.internal.R.styleable.InputMethodService_imeFullscreenBackground));
                lp.height = 0;
                lp.weight = 1;
            } //End block
            {
                mFullscreenArea.setBackgroundDrawable(null);
                lp.height = LinearLayout.LayoutParams.WRAP_CONTENT;
                lp.weight = 0;
            } //End block
            ((ViewGroup)mFullscreenArea.getParent()).updateViewLayout(
                    mFullscreenArea, lp);
            {
                {
                    View v;
                    v = onCreateExtractTextView();
                    {
                        setExtractView(v);
                    } //End block
                } //End block
                startExtractingText(false);
            } //End block
            updateExtractFrameVisibility();
        } //End block
        {
            onConfigureWindow(mWindow.getWindow(), isFullscreen, !mShowInputRequested);
            mLastShowInputRequested = mShowInputRequested;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.373 -0400", hash_original_method = "57F13E10195CB2F326F03FED8DB64B03", hash_generated_method = "06A4AE3075DB3189075D52D9466DC6E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onConfigureWindow(Window win, boolean isFullscreen,
            boolean isCandidatesOnly) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(isCandidatesOnly);
        dsTaint.addTaint(isFullscreen);
        dsTaint.addTaint(win.dsTaint);
        {
            mWindow.getWindow().setLayout(MATCH_PARENT, MATCH_PARENT);
        } //End block
        {
            mWindow.getWindow().setLayout(MATCH_PARENT, WRAP_CONTENT);
        } //End block
        // ---------- Original Method ----------
        //if (isFullscreen) {
            //mWindow.getWindow().setLayout(MATCH_PARENT, MATCH_PARENT);
        //} else {
            //mWindow.getWindow().setLayout(MATCH_PARENT, WRAP_CONTENT);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.373 -0400", hash_original_method = "0B558CA7980DF9D2EBB981E6DDF5DF60", hash_generated_method = "D20F38C30FE5B044829D2A3DE0130A93")
    @DSModeled(DSC.SAFE)
    public boolean isFullscreenMode() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsFullscreen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.373 -0400", hash_original_method = "F5927891A0B192B06619C4589486FDC4", hash_generated_method = "9BF9DA5ABA72B5B958406AEE9908CE47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onEvaluateFullscreenMode() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Configuration config;
        config = getResources().getConfiguration();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Configuration config = getResources().getConfiguration();
        //if (config.orientation != Configuration.ORIENTATION_LANDSCAPE) {
            //return false;
        //}
        //if (mInputEditorInfo != null
                //&& (mInputEditorInfo.imeOptions & EditorInfo.IME_FLAG_NO_FULLSCREEN) != 0) {
            //return false;
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.374 -0400", hash_original_method = "D4950711A20DE11BC2C7EA5EC93FE5E0", hash_generated_method = "7E799F826D8EE5D64086F800CA6C404B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setExtractViewShown(boolean shown) {
        dsTaint.addTaint(shown);
        {
            mExtractViewHidden = !shown;
            updateExtractFrameVisibility();
        } //End block
        // ---------- Original Method ----------
        //if (mExtractViewHidden == shown) {
            //mExtractViewHidden = !shown;
            //updateExtractFrameVisibility();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.374 -0400", hash_original_method = "DE07F0C980519D51E427F21507DA3D90", hash_generated_method = "4F272D023EFAC573E2D73B0E4C10051B")
    @DSModeled(DSC.SAFE)
    public boolean isExtractViewShown() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsFullscreen && !mExtractViewHidden;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.374 -0400", hash_original_method = "7CD3F30CDD4A5DA751939DF09DB853BA", hash_generated_method = "72B8BDF1B093493ECEFB2123255D9E8B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void updateExtractFrameVisibility() {
        int vis;
        {
            boolean varDA1B124F93BA93414CB6CAF390A362A8_31036984 = (isFullscreenMode());
            {
                vis = mExtractViewHidden ? View.INVISIBLE : View.VISIBLE;
                mExtractFrame.setVisibility(View.VISIBLE);
            } //End block
            {
                vis = View.VISIBLE;
                mExtractFrame.setVisibility(View.GONE);
            } //End block
        } //End collapsed parenthetic
        updateCandidatesVisibility(mCandidatesVisibility == View.VISIBLE);
        {
            boolean var548700EC502290A06EC6C7AD18983A79_591973920 = (mWindowWasVisible && mFullscreenArea.getVisibility() != vis);
            {
                int animRes;
                animRes = mThemeAttrs.getResourceId(vis == View.VISIBLE
                    ? com.android.internal.R.styleable.InputMethodService_imeExtractEnterAnimation
                    : com.android.internal.R.styleable.InputMethodService_imeExtractExitAnimation,
                    0);//DSFIXME:  CODE0008: Nested ternary operator in expression
                {
                    mFullscreenArea.startAnimation(AnimationUtils.loadAnimation(
                        this, animRes));
                } //End block
            } //End block
        } //End collapsed parenthetic
        mFullscreenArea.setVisibility(vis);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.375 -0400", hash_original_method = "46EC672E73C1227D1C1A9029A1E1F3EE", hash_generated_method = "C3BD5E5040D609DFA8266F27F90EB9E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onComputeInsets(Insets outInsets) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(outInsets.dsTaint);
        int[] loc;
        loc = mTmpLocation;
        {
            boolean var79E067E94CDE3882F5E84A741E69778F_650087222 = (mInputFrame.getVisibility() == View.VISIBLE);
            {
                mInputFrame.getLocationInWindow(loc);
            } //End block
            {
                View decor;
                decor = getWindow().getWindow().getDecorView();
                loc[1] = decor.getHeight();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varDA1B124F93BA93414CB6CAF390A362A8_1236278519 = (isFullscreenMode());
            {
                View decor;
                decor = getWindow().getWindow().getDecorView();
                outInsets.contentTopInsets = decor.getHeight();
            } //End block
            {
                outInsets.contentTopInsets = loc[1];
            } //End block
        } //End collapsed parenthetic
        {
            boolean varD90E8A6553A0F92E94122AA94D382E19_1116911878 = (mCandidatesFrame.getVisibility() == View.VISIBLE);
            {
                mCandidatesFrame.getLocationInWindow(loc);
            } //End block
        } //End collapsed parenthetic
        outInsets.visibleTopInsets = loc[1];
        outInsets.touchableInsets = Insets.TOUCHABLE_INSETS_VISIBLE;
        outInsets.touchableRegion.setEmpty();
        // ---------- Original Method ----------
        //int[] loc = mTmpLocation;
        //if (mInputFrame.getVisibility() == View.VISIBLE) {
            //mInputFrame.getLocationInWindow(loc);
        //} else {
            //View decor = getWindow().getWindow().getDecorView();
            //loc[1] = decor.getHeight();
        //}
        //if (isFullscreenMode()) {
            //View decor = getWindow().getWindow().getDecorView();
            //outInsets.contentTopInsets = decor.getHeight();
        //} else {
            //outInsets.contentTopInsets = loc[1];
        //}
        //if (mCandidatesFrame.getVisibility() == View.VISIBLE) {
            //mCandidatesFrame.getLocationInWindow(loc);
        //}
        //outInsets.visibleTopInsets = loc[1];
        //outInsets.touchableInsets = Insets.TOUCHABLE_INSETS_VISIBLE;
        //outInsets.touchableRegion.setEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.376 -0400", hash_original_method = "0265E8D9142690DEBAB6C995400C2A87", hash_generated_method = "AA5D25F42180E5A4529390C34477E9ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updateInputViewShown() {
        boolean isShown;
        isShown = mShowInputRequested && onEvaluateInputViewShown();
        {
            mIsInputViewShown = isShown;
            mInputFrame.setVisibility(isShown ? View.VISIBLE : View.GONE);
            {
                initialize();
                View v;
                v = onCreateInputView();
                {
                    setInputView(v);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //boolean isShown = mShowInputRequested && onEvaluateInputViewShown();
        //if (mIsInputViewShown != isShown && mWindowVisible) {
            //mIsInputViewShown = isShown;
            //mInputFrame.setVisibility(isShown ? View.VISIBLE : View.GONE);
            //if (mInputView == null) {
                //initialize();
                //View v = onCreateInputView();
                //if (v != null) {
                    //setInputView(v);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.377 -0400", hash_original_method = "CE1497EC29214CA28D281C89DC587F5D", hash_generated_method = "A4ECFF2D4C0CF8178FC4938ABDEF46E5")
    @DSModeled(DSC.SAFE)
    public boolean isShowInputRequested() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mShowInputRequested;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.377 -0400", hash_original_method = "FAB0B10F230F7249B0A5682A6CF03BDF", hash_generated_method = "A827C8735403DF21254421E1D1ADCCEF")
    @DSModeled(DSC.SAFE)
    public boolean isInputViewShown() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsInputViewShown && mWindowVisible;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.377 -0400", hash_original_method = "1FE8D4523FDD0EE9294351AC86397C44", hash_generated_method = "E9AE30F0B587B915DE1F641569B216EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onEvaluateInputViewShown() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Configuration config;
        config = getResources().getConfiguration();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Configuration config = getResources().getConfiguration();
        //return config.keyboard == Configuration.KEYBOARD_NOKEYS
                //|| config.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_YES;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.378 -0400", hash_original_method = "3ADC6F28D6F2E8A9F55D9BD9F82BC8D2", hash_generated_method = "F426DEFB13AE085A091681B1EF6B3D6D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCandidatesViewShown(boolean shown) {
        dsTaint.addTaint(shown);
        updateCandidatesVisibility(shown);
        {
            {
                showWindow(false);
            } //End block
            {
                hideWindow();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //updateCandidatesVisibility(shown);
        //if (!mShowInputRequested && mWindowVisible != shown) {
            //if (shown) {
                //showWindow(false);
            //} else {
                //hideWindow();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.378 -0400", hash_original_method = "4164AC2B45DCCBE42C527D3F966F5882", hash_generated_method = "013CD545BBC216467C8209538E42BFBA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void updateCandidatesVisibility(boolean shown) {
        dsTaint.addTaint(shown);
        int vis;
        vis = View.VISIBLE;
        vis = getCandidatesHiddenVisibility();
        {
            mCandidatesFrame.setVisibility(vis);
            mCandidatesVisibility = vis;
        } //End block
        // ---------- Original Method ----------
        //int vis = shown ? View.VISIBLE : getCandidatesHiddenVisibility();
        //if (mCandidatesVisibility != vis) {
            //mCandidatesFrame.setVisibility(vis);
            //mCandidatesVisibility = vis;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.379 -0400", hash_original_method = "587D3BCB04C3551F0F314F802D60C565", hash_generated_method = "2E39E040AA9A775127B7674F3D592FD7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCandidatesHiddenVisibility() {
        {
            boolean varED8C2CEF57D48CBEF71A26459BE2DF41_1245247741 = (isExtractViewShown());
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return isExtractViewShown() ? View.GONE : View.INVISIBLE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.379 -0400", hash_original_method = "09F11407FBE421F2EB35629AC776C29A", hash_generated_method = "27AC6486B40FA68EBBFB3DA1C36F4381")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void showStatusIcon(int iconResId) {
        dsTaint.addTaint(iconResId);
        mImm.showStatusIcon(mToken, getPackageName(), iconResId);
        // ---------- Original Method ----------
        //mStatusIcon = iconResId;
        //mImm.showStatusIcon(mToken, getPackageName(), iconResId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.379 -0400", hash_original_method = "F1217201D04BC19DA5F1842A9EA12AC0", hash_generated_method = "1FEC1D46E33E85CCE5B5210B4D8FEDD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void hideStatusIcon() {
        mStatusIcon = 0;
        mImm.hideStatusIcon(mToken);
        // ---------- Original Method ----------
        //mStatusIcon = 0;
        //mImm.hideStatusIcon(mToken);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.379 -0400", hash_original_method = "65B927BAD02A0A8652162D17880CBC94", hash_generated_method = "D3B75972D0B740BB3E2CF58FC5B9157F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void switchInputMethod(String id) {
        dsTaint.addTaint(id);
        mImm.setInputMethod(mToken, id);
        // ---------- Original Method ----------
        //mImm.setInputMethod(mToken, id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.380 -0400", hash_original_method = "7F30721F4F1DC6518EC25FA69EEA9DD8", hash_generated_method = "94F2C2D4418BD94F04EFB84CC9B2ED30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setExtractView(View view) {
        dsTaint.addTaint(view.dsTaint);
        mExtractFrame.removeAllViews();
        mExtractFrame.addView(view, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        {
            mExtractEditText = (ExtractEditText)view.findViewById(
                    com.android.internal.R.id.inputExtractEditText);
            mExtractEditText.setIME(this);
            mExtractAction = (Button)view.findViewById(
                    com.android.internal.R.id.inputExtractAction);
            {
                mExtractAccessories = (ViewGroup)view.findViewById(
                        com.android.internal.R.id.inputExtractAccessories);
            } //End block
            startExtractingText(false);
        } //End block
        {
            mExtractEditText = null;
            mExtractAccessories = null;
            mExtractAction = null;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.380 -0400", hash_original_method = "8648EAF39F078D77783E311D9636B394", hash_generated_method = "D8D979A62744DC25C9BC996ADC051F65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCandidatesView(View view) {
        dsTaint.addTaint(view.dsTaint);
        mCandidatesFrame.removeAllViews();
        mCandidatesFrame.addView(view, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        // ---------- Original Method ----------
        //mCandidatesFrame.removeAllViews();
        //mCandidatesFrame.addView(view, new FrameLayout.LayoutParams(
                //ViewGroup.LayoutParams.MATCH_PARENT,
                //ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.381 -0400", hash_original_method = "F530779F20B702B2AC3AEE15911FE235", hash_generated_method = "F877E835B30CBEC30A7D100AC7D00A42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setInputView(View view) {
        dsTaint.addTaint(view.dsTaint);
        mInputFrame.removeAllViews();
        mInputFrame.addView(view, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        // ---------- Original Method ----------
        //mInputFrame.removeAllViews();
        //mInputFrame.addView(view, new FrameLayout.LayoutParams(
                //ViewGroup.LayoutParams.MATCH_PARENT,
                //ViewGroup.LayoutParams.WRAP_CONTENT));
        //mInputView = view;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.381 -0400", hash_original_method = "A13C1AA9A5FD5770C02F503628C51194", hash_generated_method = "B88E36AC645F2A72A58D3B9D848AD07D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View onCreateExtractTextView() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        View var8A834C17505D7E72BBBF2B586C42D108_42507480 = (mInflater.inflate(
                com.android.internal.R.layout.input_method_extract_view, null));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mInflater.inflate(
                //com.android.internal.R.layout.input_method_extract_view, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.381 -0400", hash_original_method = "F89AAD61B39578A3862B8537E7226DB5", hash_generated_method = "33AD24344963B0B671D29F3B8EC6159E")
    @DSModeled(DSC.SAFE)
    public View onCreateCandidatesView() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.382 -0400", hash_original_method = "75C53F9A7550BADCC3EEC67DE46E8BC4", hash_generated_method = "CDA59E8184253653B187488850C77CC4")
    @DSModeled(DSC.SAFE)
    public View onCreateInputView() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.382 -0400", hash_original_method = "4B7A497965AEC42ECF0C79E271F7AFEF", hash_generated_method = "3A033E41978503172483A52E0ACA256A")
    @DSModeled(DSC.SAFE)
    public void onStartInputView(EditorInfo info, boolean restarting) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(restarting);
        dsTaint.addTaint(info.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.383 -0400", hash_original_method = "126397FC018D546EBB3D17AA8B426F4F", hash_generated_method = "76CFD1ADC4E8042FF5CE9239BB832A48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onFinishInputView(boolean finishingInput) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(finishingInput);
        {
            InputConnection ic;
            ic = getCurrentInputConnection();
            {
                ic.finishComposingText();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (!finishingInput) {
            //InputConnection ic = getCurrentInputConnection();
            //if (ic != null) {
                //ic.finishComposingText();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.383 -0400", hash_original_method = "C1D318033051A63629AB7F18935A055B", hash_generated_method = "5E1B0B9E9E79D9F62BCBC0C239260162")
    @DSModeled(DSC.SAFE)
    public void onStartCandidatesView(EditorInfo info, boolean restarting) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(restarting);
        dsTaint.addTaint(info.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.384 -0400", hash_original_method = "7B21B5BD050EBE81B79EA707D7F10503", hash_generated_method = "689BBF421FB6041B2FC5A498657B0ADD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onFinishCandidatesView(boolean finishingInput) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(finishingInput);
        {
            InputConnection ic;
            ic = getCurrentInputConnection();
            {
                ic.finishComposingText();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (!finishingInput) {
            //InputConnection ic = getCurrentInputConnection();
            //if (ic != null) {
                //ic.finishComposingText();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.384 -0400", hash_original_method = "7116B74C32B9543E489CB78AF9B82E3D", hash_generated_method = "1ADAC57341202C12D70D01F850372A48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onShowInputRequested(int flags, boolean configChange) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(flags);
        dsTaint.addTaint(configChange);
        {
            boolean var9151F215B67E3E110B8160488A310989_99482226 = (!onEvaluateInputViewShown());
        } //End collapsed parenthetic
        {
            {
                boolean varB1105F93C8A3332B01967E57F54EA7F5_1665765895 = (!configChange && onEvaluateFullscreenMode());
            } //End collapsed parenthetic
            Configuration config;
            config = getResources().getConfiguration();
        } //End block
        {
            mShowInputForced = true;
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!onEvaluateInputViewShown()) {
            //return false;
        //}
        //if ((flags&InputMethod.SHOW_EXPLICIT) == 0) {
            //if (!configChange && onEvaluateFullscreenMode()) {
                //return false;
            //}
            //Configuration config = getResources().getConfiguration();
            //if (config.keyboard != Configuration.KEYBOARD_NOKEYS) {
                //return false;
            //}
        //}
        //if ((flags&InputMethod.SHOW_FORCED) != 0) {
            //mShowInputForced = true;
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.384 -0400", hash_original_method = "119016FA69877024FD5AD688A6BA764A", hash_generated_method = "00B1E699C68E379437334756CEBE09F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void showWindow(boolean showInput) {
        dsTaint.addTaint(showInput);
        try 
        {
            mWindowWasVisible = mWindowVisible;
            mInShowWindow = true;
            showWindowInner(showInput);
        } //End block
        finally 
        {
            mWindowWasVisible = true;
            mInShowWindow = false;
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "Showing window: showInput=" + showInput
                //+ " mShowInputRequested=" + mShowInputRequested
                //+ " mWindowAdded=" + mWindowAdded
                //+ " mWindowCreated=" + mWindowCreated
                //+ " mWindowVisible=" + mWindowVisible
                //+ " mInputStarted=" + mInputStarted);
        //if (mInShowWindow) {
            //Log.w(TAG, "Re-entrance in to showWindow");
            //return;
        //}
        //try {
            //mWindowWasVisible = mWindowVisible;
            //mInShowWindow = true;
            //showWindowInner(showInput);
        //} finally {
            //mWindowWasVisible = true;
            //mInShowWindow = false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.385 -0400", hash_original_method = "CB135560325B3F8C18497A9052C17028", hash_generated_method = "632538DA5AE40E99D069F34E79F7429C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void showWindowInner(boolean showInput) {
        dsTaint.addTaint(showInput);
        boolean doShowInput;
        doShowInput = false;
        boolean wasVisible;
        wasVisible = mWindowVisible;
        mWindowVisible = true;
        {
            {
                {
                    doShowInput = true;
                    mShowInputRequested = true;
                } //End block
            } //End block
        } //End block
        {
            showInput = true;
        } //End block
        initialize();
        updateFullscreenMode();
        updateInputViewShown();
        {
            mWindowAdded = true;
            mWindowCreated = true;
            initialize();
            View v;
            v = onCreateCandidatesView();
            {
                setCandidatesView(v);
            } //End block
        } //End block
        {
            {
                mInputViewStarted = true;
                onStartInputView(mInputEditorInfo, false);
            } //End block
        } //End block
        {
            mCandidatesViewStarted = true;
            onStartCandidatesView(mInputEditorInfo, false);
        } //End block
        {
            startExtractingText(false);
        } //End block
        {
            mImm.setImeWindowStatus(mToken, IME_ACTIVE, mBackDisposition);
            onWindowShown();
            mWindow.show();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.385 -0400", hash_original_method = "AE7818A6DC114C265A5A8660654BB926", hash_generated_method = "4D5A11064569AA5F7303EF116AEDEAA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void finishViews() {
        {
            onFinishInputView(false);
        } //End block
        {
            onFinishCandidatesView(false);
        } //End block
        mInputViewStarted = false;
        mCandidatesViewStarted = false;
        // ---------- Original Method ----------
        //if (mInputViewStarted) {
            //if (DEBUG) Log.v(TAG, "CALL: onFinishInputView");
            //onFinishInputView(false);
        //} else if (mCandidatesViewStarted) {
            //if (DEBUG) Log.v(TAG, "CALL: onFinishCandidatesView");
            //onFinishCandidatesView(false);
        //}
        //mInputViewStarted = false;
        //mCandidatesViewStarted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.386 -0400", hash_original_method = "09134BCCF788D1D9024485AE6DA1693C", hash_generated_method = "16EEEC9F8593063A82AAF47B525A09E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void hideWindow() {
        finishViews();
        mImm.setImeWindowStatus(mToken, 0, mBackDisposition);
        {
            mWindow.hide();
            mWindowVisible = false;
            onWindowHidden();
            mWindowWasVisible = false;
        } //End block
        // ---------- Original Method ----------
        //finishViews();
        //mImm.setImeWindowStatus(mToken, 0, mBackDisposition);
        //if (mWindowVisible) {
            //mWindow.hide();
            //mWindowVisible = false;
            //onWindowHidden();
            //mWindowWasVisible = false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.386 -0400", hash_original_method = "D99B15EAA68884714BB333A2583A0571", hash_generated_method = "E797350F14362CA554D013A5659543F1")
    @DSModeled(DSC.SAFE)
    public void onWindowShown() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.386 -0400", hash_original_method = "C1BA79DB491FC590F2A9A222970A46B9", hash_generated_method = "82493FCA94AEB547B2950C787893F07B")
    @DSModeled(DSC.SAFE)
    public void onWindowHidden() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.386 -0400", hash_original_method = "56BEE8816781B99E44028AA4DD49AFE8", hash_generated_method = "9A3D5E9EBB717318D195E3F6D8803AE5")
    @DSModeled(DSC.SAFE)
    public void onBindInput() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.387 -0400", hash_original_method = "D52B154580F2280F1D8D5CF7DCC6C0BF", hash_generated_method = "049C427B4927AA2DB3B5531ABC79BA72")
    @DSModeled(DSC.SAFE)
    public void onUnbindInput() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.387 -0400", hash_original_method = "3ADFFB39DB97C5354271962A42564DD7", hash_generated_method = "D57BCAB639D421044BB207C339C867D2")
    @DSModeled(DSC.SAFE)
    public void onStartInput(EditorInfo attribute, boolean restarting) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(restarting);
        dsTaint.addTaint(attribute.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.387 -0400", hash_original_method = "D870334B8409E203BCA5DBA60A032B6F", hash_generated_method = "246F9011D67E57587BF93602711A96F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void doFinishInput() {
        {
            onFinishInputView(true);
        } //End block
        {
            onFinishCandidatesView(true);
        } //End block
        mInputViewStarted = false;
        mCandidatesViewStarted = false;
        {
            onFinishInput();
        } //End block
        mInputStarted = false;
        mStartedInputConnection = null;
        mCurCompletions = null;
        // ---------- Original Method ----------
        //if (mInputViewStarted) {
            //if (DEBUG) Log.v(TAG, "CALL: onFinishInputView");
            //onFinishInputView(true);
        //} else if (mCandidatesViewStarted) {
            //if (DEBUG) Log.v(TAG, "CALL: onFinishCandidatesView");
            //onFinishCandidatesView(true);
        //}
        //mInputViewStarted = false;
        //mCandidatesViewStarted = false;
        //if (mInputStarted) {
            //if (DEBUG) Log.v(TAG, "CALL: onFinishInput");
            //onFinishInput();
        //}
        //mInputStarted = false;
        //mStartedInputConnection = null;
        //mCurCompletions = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.388 -0400", hash_original_method = "D70A8E32EEED9199B71D72D85567D543", hash_generated_method = "BB564D45BC156D6352970EA9F5572167")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void doStartInput(InputConnection ic, EditorInfo attribute, boolean restarting) {
        dsTaint.addTaint(ic.dsTaint);
        dsTaint.addTaint(restarting);
        dsTaint.addTaint(attribute.dsTaint);
        {
            doFinishInput();
        } //End block
        mInputStarted = true;
        initialize();
        onStartInput(attribute, restarting);
        {
            {
                mInputViewStarted = true;
                onStartInputView(mInputEditorInfo, restarting);
                startExtractingText(true);
            } //End block
            {
                mCandidatesViewStarted = true;
                onStartCandidatesView(mInputEditorInfo, restarting);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.388 -0400", hash_original_method = "E745A863BE4D98B94E02F169B272F08C", hash_generated_method = "4FDABE53DFC0FB8D4F16FAB7D6D0DC57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onFinishInput() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        InputConnection ic;
        ic = getCurrentInputConnection();
        {
            ic.finishComposingText();
        } //End block
        // ---------- Original Method ----------
        //InputConnection ic = getCurrentInputConnection();
        //if (ic != null) {
            //ic.finishComposingText();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.388 -0400", hash_original_method = "75C3F475CAD98FE8CF4A523C8BDA8BB1", hash_generated_method = "36967E7C33D01A8A167F9417DBE43CD7")
    @DSModeled(DSC.SAFE)
    public void onDisplayCompletions(CompletionInfo[] completions) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(completions[0].dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.389 -0400", hash_original_method = "CC541C375904CEFCC1DC228363FE0C44", hash_generated_method = "523930F8DF0D84B97C09A449447D8F99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onUpdateExtractedText(int token, ExtractedText text) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(text.dsTaint);
        dsTaint.addTaint(token);
        {
            {
                mExtractEditText.setExtractedText(text);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mExtractedToken != token) {
            //return;
        //}
        //if (text != null) {
            //if (mExtractEditText != null) {
                //mExtractedText = text;
                //mExtractEditText.setExtractedText(text);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.389 -0400", hash_original_method = "08F34B1B106CF5B01DE522670D82A3BC", hash_generated_method = "97ADF17BEFAF1AEA98A759D6F16B5346")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onUpdateSelection(int oldSelStart, int oldSelEnd,
            int newSelStart, int newSelEnd,
            int candidatesStart, int candidatesEnd) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(candidatesStart);
        dsTaint.addTaint(oldSelStart);
        dsTaint.addTaint(candidatesEnd);
        dsTaint.addTaint(newSelStart);
        dsTaint.addTaint(oldSelEnd);
        dsTaint.addTaint(newSelEnd);
        ExtractEditText eet;
        eet = mExtractEditText;
        {
            boolean var07839FB6DDF532AEC3BACA070CA2FC06_1581155159 = (eet != null && isFullscreenMode() && mExtractedText != null);
            {
                int off;
                off = mExtractedText.startOffset;
                eet.startInternalChanges();
                newSelStart -= off;
                newSelEnd -= off;
                int len;
                len = eet.getText().length();
                newSelStart = 0;
                newSelStart = len;
                newSelEnd = 0;
                newSelEnd = len;
                eet.setSelection(newSelStart, newSelEnd);
                eet.finishInternalChanges();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final ExtractEditText eet = mExtractEditText;
        //if (eet != null && isFullscreenMode() && mExtractedText != null) {
            //final int off = mExtractedText.startOffset;
            //eet.startInternalChanges();
            //newSelStart -= off;
            //newSelEnd -= off;
            //final int len = eet.getText().length();
            //if (newSelStart < 0) newSelStart = 0;
            //else if (newSelStart > len) newSelStart = len;
            //if (newSelEnd < 0) newSelEnd = 0;
            //else if (newSelEnd > len) newSelEnd = len;
            //eet.setSelection(newSelStart, newSelEnd);
            //eet.finishInternalChanges();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.389 -0400", hash_original_method = "D49077B58DC986892621B88ACD9BF0F7", hash_generated_method = "9A82A95FB02BAEF9D62169ED4E990A16")
    @DSModeled(DSC.SAFE)
    public void onViewClicked(boolean focusChanged) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(focusChanged);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.390 -0400", hash_original_method = "F8EB5FE11A8138FB360940D74155758A", hash_generated_method = "64991C53D21540B8E0390685EC957CA5")
    @DSModeled(DSC.SAFE)
    public void onUpdateCursor(Rect newCursor) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newCursor.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.390 -0400", hash_original_method = "53762C81936F5FCD41F3F903406EE4C3", hash_generated_method = "B358EB820B32D50E4002A6AEB66D5035")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void requestHideSelf(int flags) {
        dsTaint.addTaint(flags);
        mImm.hideSoftInputFromInputMethod(mToken, flags);
        // ---------- Original Method ----------
        //mImm.hideSoftInputFromInputMethod(mToken, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.390 -0400", hash_original_method = "939E9922D22E9C6523AEB259C97CBC65", hash_generated_method = "CD5FD6297F426E96677E8674ECE5CEA1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void requestShowSelf(int flags) {
        dsTaint.addTaint(flags);
        mImm.showSoftInputFromInputMethod(mToken, flags);
        // ---------- Original Method ----------
        //mImm.showSoftInputFromInputMethod(mToken, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.390 -0400", hash_original_method = "2F1E84CCA4C2BB5EFB606DA289F60F64", hash_generated_method = "C4F2289FCA8EB15F6A2F8E59D8CC3583")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean handleBack(boolean doIt) {
        dsTaint.addTaint(doIt);
        {
            {
                boolean var702D5193BDDB49ACD0C022D27D4F16B7_314999671 = (isExtractViewShown() && mExtractView instanceof ExtractEditLayout);
                {
                    ExtractEditLayout extractEditLayout;
                    extractEditLayout = (ExtractEditLayout) mExtractView;
                    {
                        boolean var5924543FB4797135854B81B78B99C485_921681967 = (extractEditLayout.isActionModeStarted());
                        {
                            extractEditLayout.finishActionMode();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            requestHideSelf(0);
        } //End block
        {
            {
                setCandidatesViewShown(false);
            } //End block
            {
                hideWindow();
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.391 -0400", hash_original_method = "6D39318911C6DEDF33A28EA4D06A473F", hash_generated_method = "FDA1E34333A295F2F6A6767B0CE5920B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var5900307FC72CF55A885B11E67B5ADB96_1237029323 = (event.getKeyCode() == KeyEvent.KEYCODE_BACK);
            {
                {
                    boolean var30194127B59F20B8D15CB7440CF6FB54_1285600249 = (handleBack(false));
                    {
                        event.startTracking();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean varBC0795DACA35C6A9F77201B924F9EBCC_344579021 = (doMovementKey(keyCode, event, MOVEMENT_DOWN));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            //if (handleBack(false)) {
                //event.startTracking();
                //return true;
            //}
            //return false;
        //}
        //return doMovementKey(keyCode, event, MOVEMENT_DOWN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.393 -0400", hash_original_method = "2A75FF2C44C4D96068DDAFC2643F0C8B", hash_generated_method = "121675FEA65080179B4E07A9D8940A28")
    @DSModeled(DSC.SAFE)
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.393 -0400", hash_original_method = "3CC4F52C9B71FCD2A0600FA46D6F06E5", hash_generated_method = "6F43A02E0F21BC00FEA3031624F91D7A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onKeyMultiple(int keyCode, int count, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(count);
        dsTaint.addTaint(event.dsTaint);
        boolean var690BBBD39586299984278532B3B9C485_1283264898 = (doMovementKey(keyCode, event, count));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return doMovementKey(keyCode, event, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.393 -0400", hash_original_method = "BCD4505881DB97C910099D82B7A22807", hash_generated_method = "8B482DF10F97DE6F93DE51D63DC5099F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var5922C562AF2EE989EFA0391BD79A8FD9_270348564 = (event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.isTracking()
                && !event.isCanceled());
            {
                boolean varD293510AE3D22D4016F47B37DB94AA22_382412409 = (handleBack(true));
            } //End block
        } //End collapsed parenthetic
        boolean var8B63F1B3C4C5EA6147670BB023C5C4C4_946527369 = (doMovementKey(keyCode, event, MOVEMENT_UP));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.isTracking()
                //&& !event.isCanceled()) {
            //return handleBack(true);
        //}
        //return doMovementKey(keyCode, event, MOVEMENT_UP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.394 -0400", hash_original_method = "4A983FDB3FF481E2165B7D8D641CDD48", hash_generated_method = "AC0BDB850D0CC72CC3622640BCC903C9")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.394 -0400", hash_original_method = "E2F219F9B605C6393794145B9C28D4D7", hash_generated_method = "F5BB031AC5A535E7CDD20B7B27850F78")
    @DSModeled(DSC.SAFE)
    public void onAppPrivateCommand(String action, Bundle data) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(action);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.394 -0400", hash_original_method = "F1BA2156F30663683BD63E2F68C8FA5C", hash_generated_method = "1C9F4C0B8863516E69BCA51A25C71712")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onToggleSoftInput(int showFlags, int hideFlags) {
        dsTaint.addTaint(showFlags);
        dsTaint.addTaint(hideFlags);
        {
            boolean var257AAF3411A7EBF3C3725C7C8F2C478F_980038223 = (isInputViewShown());
            {
                requestHideSelf(hideFlags);
            } //End block
            {
                requestShowSelf(showFlags);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "toggleSoftInput()");
        //if (isInputViewShown()) {
            //requestHideSelf(hideFlags);
        //} else {
            //requestShowSelf(showFlags);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.395 -0400", hash_original_method = "9C1F09BC7693D3503A84F47A8DD2E9B8", hash_generated_method = "62DD2EAE2A76C9889B6D829A7F9E1E8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void reportExtractedMovement(int keyCode, int count) {
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(count);
        int dx, dy;
        dx = 0;
        dy = 0;
        //Begin case KeyEvent.KEYCODE_DPAD_LEFT 
        dx = -count;
        //End case KeyEvent.KEYCODE_DPAD_LEFT 
        //Begin case KeyEvent.KEYCODE_DPAD_RIGHT 
        dx = count;
        //End case KeyEvent.KEYCODE_DPAD_RIGHT 
        //Begin case KeyEvent.KEYCODE_DPAD_UP 
        dy = -count;
        //End case KeyEvent.KEYCODE_DPAD_UP 
        //Begin case KeyEvent.KEYCODE_DPAD_DOWN 
        dy = count;
        //End case KeyEvent.KEYCODE_DPAD_DOWN 
        onExtractedCursorMovement(dx, dy);
        // ---------- Original Method ----------
        //int dx = 0, dy = 0;
        //switch (keyCode) {
            //case KeyEvent.KEYCODE_DPAD_LEFT:
                //dx = -count;
                //break;
            //case KeyEvent.KEYCODE_DPAD_RIGHT:
                //dx = count;
                //break;
            //case KeyEvent.KEYCODE_DPAD_UP:
                //dy = -count;
                //break;
            //case KeyEvent.KEYCODE_DPAD_DOWN:
                //dy = count;
                //break;
        //}
        //onExtractedCursorMovement(dx, dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.395 -0400", hash_original_method = "CADA6E3534C513A6E5A0D2EB184E3B48", hash_generated_method = "13D7C9FDA162601800ECEA4BBF72BCAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean doMovementKey(int keyCode, KeyEvent event, int count) {
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(count);
        dsTaint.addTaint(event.dsTaint);
        ExtractEditText eet;
        eet = mExtractEditText;
        {
            boolean var94228B74C2263F815EDE31A941CF869D_2050245975 = (isExtractViewShown() && isInputViewShown() && eet != null);
            {
                MovementMethod movement;
                movement = eet.getMovementMethod();
                Layout layout;
                layout = eet.getLayout();
                {
                    {
                        {
                            boolean var963C81CEB3E2936CF5F881BEB18A9EC6_596442060 = (movement.onKeyDown(eet,
                            (Spannable)eet.getText(), keyCode, event));
                            {
                                reportExtractedMovement(keyCode, 1);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        {
                            boolean varDB98AC32177DBB5E1C8506FFA61B86E0_57908302 = (movement.onKeyUp(eet,
                            (Spannable)eet.getText(), keyCode, event));
                        } //End collapsed parenthetic
                    } //End block
                    {
                        {
                            boolean var498F283C3C6269EC555383DEA743554E_723987133 = (movement.onKeyOther(eet, (Spannable)eet.getText(), event));
                            {
                                reportExtractedMovement(keyCode, count);
                            } //End block
                            {
                                KeyEvent down;
                                down = KeyEvent.changeAction(event, KeyEvent.ACTION_DOWN);
                                {
                                    boolean varD21AC42920869AC37E02C57F302DAAF5_244228502 = (movement.onKeyDown(eet,
                                (Spannable)eet.getText(), keyCode, down));
                                    {
                                        KeyEvent up;
                                        up = KeyEvent.changeAction(event, KeyEvent.ACTION_UP);
                                        movement.onKeyUp(eet,
                                    (Spannable)eet.getText(), keyCode, up);
                                        {
                                            movement.onKeyDown(eet,
                                        (Spannable)eet.getText(), keyCode, down);
                                            movement.onKeyUp(eet,
                                        (Spannable)eet.getText(), keyCode, up);
                                        } //End block
                                        reportExtractedMovement(keyCode, count);
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.396 -0400", hash_original_method = "79E896FD8459E186D0AA684976DF9590", hash_generated_method = "56DFD3627BFED7A7AB6D4548D46EFEFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendDownUpKeyEvents(int keyEventCode) {
        dsTaint.addTaint(keyEventCode);
        InputConnection ic;
        ic = getCurrentInputConnection();
        long eventTime;
        eventTime = SystemClock.uptimeMillis();
        ic.sendKeyEvent(new KeyEvent(eventTime, eventTime,
                KeyEvent.ACTION_DOWN, keyEventCode, 0, 0, KeyCharacterMap.VIRTUAL_KEYBOARD, 0,
                KeyEvent.FLAG_SOFT_KEYBOARD|KeyEvent.FLAG_KEEP_TOUCH_MODE));
        ic.sendKeyEvent(new KeyEvent(SystemClock.uptimeMillis(), eventTime,
                KeyEvent.ACTION_UP, keyEventCode, 0, 0, KeyCharacterMap.VIRTUAL_KEYBOARD, 0,
                KeyEvent.FLAG_SOFT_KEYBOARD|KeyEvent.FLAG_KEEP_TOUCH_MODE));
        // ---------- Original Method ----------
        //InputConnection ic = getCurrentInputConnection();
        //if (ic == null) return;
        //long eventTime = SystemClock.uptimeMillis();
        //ic.sendKeyEvent(new KeyEvent(eventTime, eventTime,
                //KeyEvent.ACTION_DOWN, keyEventCode, 0, 0, KeyCharacterMap.VIRTUAL_KEYBOARD, 0,
                //KeyEvent.FLAG_SOFT_KEYBOARD|KeyEvent.FLAG_KEEP_TOUCH_MODE));
        //ic.sendKeyEvent(new KeyEvent(SystemClock.uptimeMillis(), eventTime,
                //KeyEvent.ACTION_UP, keyEventCode, 0, 0, KeyCharacterMap.VIRTUAL_KEYBOARD, 0,
                //KeyEvent.FLAG_SOFT_KEYBOARD|KeyEvent.FLAG_KEEP_TOUCH_MODE));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.396 -0400", hash_original_method = "84DA6B1414DFECBCA6744FD6285B6A00", hash_generated_method = "B6F0A82B5CA688B8CE12783BA3C49E80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean sendDefaultEditorAction(boolean fromEnterKey) {
        dsTaint.addTaint(fromEnterKey);
        EditorInfo ei;
        ei = getCurrentInputEditorInfo();
        {
            InputConnection ic;
            ic = getCurrentInputConnection();
            {
                ic.performEditorAction(ei.imeOptions&EditorInfo.IME_MASK_ACTION);
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //EditorInfo ei = getCurrentInputEditorInfo();
        //if (ei != null &&
                //(!fromEnterKey || (ei.imeOptions &
                        //EditorInfo.IME_FLAG_NO_ENTER_ACTION) == 0) &&
                //(ei.imeOptions & EditorInfo.IME_MASK_ACTION) !=
                    //EditorInfo.IME_ACTION_NONE) {
            //InputConnection ic = getCurrentInputConnection();
            //if (ic != null) {
                //ic.performEditorAction(ei.imeOptions&EditorInfo.IME_MASK_ACTION);
            //}
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.397 -0400", hash_original_method = "CB96ACC643B76CE6B3516B92D9424351", hash_generated_method = "A2A7007A20432B74E3C50FCCF334EE1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendKeyChar(char charCode) {
        dsTaint.addTaint(charCode);
        //Begin case '\n' 
        {
            boolean var7FAAA40E562A94AE6D757E1CEC431AF1_1358368671 = (!sendDefaultEditorAction(true));
            {
                sendDownUpKeyEvents(KeyEvent.KEYCODE_ENTER);
            } //End block
        } //End collapsed parenthetic
        //End case '\n' 
        //Begin case default 
        {
            sendDownUpKeyEvents(charCode - '0' + KeyEvent.KEYCODE_0);
        } //End block
        {
            InputConnection ic;
            ic = getCurrentInputConnection();
            {
                ic.commitText(String.valueOf((char) charCode), 1);
            } //End block
        } //End block
        //End case default 
        // ---------- Original Method ----------
        //switch (charCode) {
            //case '\n': 
                //if (!sendDefaultEditorAction(true)) {
                    //sendDownUpKeyEvents(KeyEvent.KEYCODE_ENTER);
                //}
                //break;
            //default:
                //if (charCode >= '0' && charCode <= '9') {
                    //sendDownUpKeyEvents(charCode - '0' + KeyEvent.KEYCODE_0);
                //} else {
                    //InputConnection ic = getCurrentInputConnection();
                    //if (ic != null) {
                        //ic.commitText(String.valueOf((char) charCode), 1);
                    //}
                //}
                //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.397 -0400", hash_original_method = "B848FD2302E48E43854FF3AB55ABE7CC", hash_generated_method = "DCE6BC52B2B4E23D19CF2B76555F8914")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onExtractedSelectionChanged(int start, int end) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        InputConnection conn;
        conn = getCurrentInputConnection();
        {
            conn.setSelection(start, end);
        } //End block
        // ---------- Original Method ----------
        //InputConnection conn = getCurrentInputConnection();
        //if (conn != null) {
            //conn.setSelection(start, end);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.397 -0400", hash_original_method = "56B9FB82082DF66D8709DA9479270344", hash_generated_method = "F223BF1B18E9742F0174FF6DB39B6A54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onExtractedDeleteText(int start, int end) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        InputConnection conn;
        conn = getCurrentInputConnection();
        {
            conn.setSelection(start, start);
            conn.deleteSurroundingText(0, end-start);
        } //End block
        // ---------- Original Method ----------
        //InputConnection conn = getCurrentInputConnection();
        //if (conn != null) {
            //conn.setSelection(start, start);
            //conn.deleteSurroundingText(0, end-start);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.398 -0400", hash_original_method = "3752CFC0704EAA41A71F5FCC4C7F691D", hash_generated_method = "4B57E9D8A01F8EB712584C547A9943D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onExtractedReplaceText(int start, int end, CharSequence text) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        InputConnection conn;
        conn = getCurrentInputConnection();
        {
            conn.setComposingRegion(start, end);
            conn.commitText(text, 1);
        } //End block
        // ---------- Original Method ----------
        //InputConnection conn = getCurrentInputConnection();
        //if (conn != null) {
            //conn.setComposingRegion(start, end);
            //conn.commitText(text, 1);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.398 -0400", hash_original_method = "2386EADCDB176594EC064F3F20DE5D60", hash_generated_method = "1D010022EC074EAAC58148A17D680F70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onExtractedSetSpan(Object span, int start, int end, int flags) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(flags);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        dsTaint.addTaint(span.dsTaint);
        InputConnection conn;
        conn = getCurrentInputConnection();
        {
            {
                boolean varD960B03B483BFF53BB8B9F9042E2BA47_262912206 = (!conn.setSelection(start, end));
            } //End collapsed parenthetic
            CharSequence text;
            text = conn.getSelectedText(InputConnection.GET_TEXT_WITH_STYLES);
            {
                ((Spannable) text).setSpan(span, 0, text.length(), flags);
                conn.setComposingRegion(start, end);
                conn.commitText(text, 1);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //InputConnection conn = getCurrentInputConnection();
        //if (conn != null) {
            //if (!conn.setSelection(start, end)) return;
            //CharSequence text = conn.getSelectedText(InputConnection.GET_TEXT_WITH_STYLES);
            //if (text instanceof Spannable) {
                //((Spannable) text).setSpan(span, 0, text.length(), flags);
                //conn.setComposingRegion(start, end);
                //conn.commitText(text, 1);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.399 -0400", hash_original_method = "672EAF0A2CC265CDC19E0FE05714B327", hash_generated_method = "A9B836C6812BF9EB0AA953334099FFE5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onExtractedTextClicked() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varA215564B7B15BCB949555AE2A66D446A_356099850 = (mExtractEditText.hasVerticalScrollBar());
            {
                setCandidatesViewShown(false);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mExtractEditText == null) {
            //return;
        //}
        //if (mExtractEditText.hasVerticalScrollBar()) {
            //setCandidatesViewShown(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.399 -0400", hash_original_method = "33B88CC3E792B5DBD4A2FEF9CD5D26B5", hash_generated_method = "E6326291C5BFEE3629C02DCE93D56C32")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onExtractedCursorMovement(int dx, int dy) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        {
            boolean varA215564B7B15BCB949555AE2A66D446A_336666204 = (mExtractEditText.hasVerticalScrollBar());
            {
                setCandidatesViewShown(false);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mExtractEditText == null || dy == 0) {
            //return;
        //}
        //if (mExtractEditText.hasVerticalScrollBar()) {
            //setCandidatesViewShown(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.399 -0400", hash_original_method = "FA4A3D7B1537F03835F5D4F28B4BC905", hash_generated_method = "43DC5663EBCC5F40B2788DC35283DFB1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onExtractTextContextMenuItem(int id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(id);
        InputConnection ic;
        ic = getCurrentInputConnection();
        {
            ic.performContextMenuAction(id);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //InputConnection ic = getCurrentInputConnection();
        //if (ic != null) {
            //ic.performContextMenuAction(id);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.400 -0400", hash_original_method = "9F91BE1CB3CE4671D110A2B57AE2570E", hash_generated_method = "CA807B4F794C124D8293F09A6B15904E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence getTextForImeAction(int imeOptions) {
        dsTaint.addTaint(imeOptions);
        //Begin case EditorInfo.IME_ACTION_GO 
        CharSequence varBDA9FB1C759AAD14E6268E0AA84888A6_1482157981 = (getText(com.android.internal.R.string.ime_action_go));
        //End case EditorInfo.IME_ACTION_GO 
        //Begin case EditorInfo.IME_ACTION_SEARCH 
        CharSequence var44164BCB7A8D7A8FB3720404447DD0BD_1459769140 = (getText(com.android.internal.R.string.ime_action_search));
        //End case EditorInfo.IME_ACTION_SEARCH 
        //Begin case EditorInfo.IME_ACTION_SEND 
        CharSequence var07F5DF9749F0A10893D7C377F3D63151_513649466 = (getText(com.android.internal.R.string.ime_action_send));
        //End case EditorInfo.IME_ACTION_SEND 
        //Begin case EditorInfo.IME_ACTION_NEXT 
        CharSequence varA67C3F3B45C56BA977174F05A10D30B1_54558554 = (getText(com.android.internal.R.string.ime_action_next));
        //End case EditorInfo.IME_ACTION_NEXT 
        //Begin case EditorInfo.IME_ACTION_DONE 
        CharSequence var649509D090C4712EC430D133CE31C263_669626348 = (getText(com.android.internal.R.string.ime_action_done));
        //End case EditorInfo.IME_ACTION_DONE 
        //Begin case EditorInfo.IME_ACTION_PREVIOUS 
        CharSequence varB5D1105B657488F56697C03E0BAA2FBA_152305064 = (getText(com.android.internal.R.string.ime_action_previous));
        //End case EditorInfo.IME_ACTION_PREVIOUS 
        //Begin case default 
        CharSequence varA81E4894334B3B352FE71DD234B6E059_458251666 = (getText(com.android.internal.R.string.ime_action_default));
        //End case default 
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.400 -0400", hash_original_method = "8796655A783A46466BACE236BCA7DD97", hash_generated_method = "F465DE2775A921AF9DDB7B384E231C09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onUpdateExtractingVisibility(EditorInfo ei) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(ei.dsTaint);
        {
            setExtractViewShown(false);
        } //End block
        setExtractViewShown(true);
        // ---------- Original Method ----------
        //if (ei.inputType == InputType.TYPE_NULL ||
                //(ei.imeOptions&EditorInfo.IME_FLAG_NO_EXTRACT_UI) != 0) {
            //setExtractViewShown(false);
            //return;
        //}
        //setExtractViewShown(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.401 -0400", hash_original_method = "EAD47E132E9ECD3692FAA5C1AB9CEE12", hash_generated_method = "9C08D6E933AD7FBA52CE0724C47AF7B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onUpdateExtractingViews(EditorInfo ei) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(ei.dsTaint);
        {
            boolean var87F8135436C414A49235B50C0BEE24F1_1631529580 = (!isExtractViewShown());
        } //End collapsed parenthetic
        boolean hasAction;
        hasAction = ei.actionLabel != null || (
                (ei.imeOptions&EditorInfo.IME_MASK_ACTION) != EditorInfo.IME_ACTION_NONE &&
                (ei.imeOptions&EditorInfo.IME_FLAG_NO_ACCESSORY_ACTION) == 0 &&
                ei.inputType != InputType.TYPE_NULL);
        {
            mExtractAccessories.setVisibility(View.VISIBLE);
            {
                {
                    mExtractAction.setText(ei.actionLabel);
                } //End block
                {
                    mExtractAction.setText(getTextForImeAction(ei.imeOptions));
                } //End block
                mExtractAction.setOnClickListener(mActionClickListener);
            } //End block
        } //End block
        {
            mExtractAccessories.setVisibility(View.GONE);
            {
                mExtractAction.setOnClickListener(null);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.401 -0400", hash_original_method = "B8550D5274B7AC063AD577912E9B5BF9", hash_generated_method = "C16417B3063CC38EBF322582EC8CD823")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onExtractingInputChanged(EditorInfo ei) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(ei.dsTaint);
        {
            requestHideSelf(InputMethodManager.HIDE_NOT_ALWAYS);
        } //End block
        // ---------- Original Method ----------
        //if (ei.inputType == InputType.TYPE_NULL) {
            //requestHideSelf(InputMethodManager.HIDE_NOT_ALWAYS);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.402 -0400", hash_original_method = "4C67EC88DE5F38ABAC11BF6FC64666D8", hash_generated_method = "9C04DCE591604C2ADF1973CCB75CBE47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void startExtractingText(boolean inputChanged) {
        dsTaint.addTaint(inputChanged);
        ExtractEditText eet;
        eet = mExtractEditText;
        {
            boolean var4B45048747F7E34CB0EFEC67D57A6FDB_713788664 = (eet != null && getCurrentInputStarted()
                && isFullscreenMode());
            {
                ExtractedTextRequest req;
                req = new ExtractedTextRequest();
                req.token = mExtractedToken;
                req.flags = InputConnection.GET_TEXT_WITH_STYLES;
                req.hintMaxLines = 10;
                req.hintMaxChars = 10000;
                InputConnection ic;
                ic = getCurrentInputConnection();
                mExtractedText = ic == null? null
                    : ic.getExtractedText(req, InputConnection.GET_EXTRACTED_TEXT_MONITOR);
                EditorInfo ei;
                ei = getCurrentInputEditorInfo();
                try 
                {
                    eet.startInternalChanges();
                    onUpdateExtractingVisibility(ei);
                    onUpdateExtractingViews(ei);
                    int inputType;
                    inputType = ei.inputType;
                    {
                        {
                            inputType |= EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE;
                        } //End block
                    } //End block
                    eet.setInputType(inputType);
                    eet.setHint(ei.hintText);
                    {
                        eet.setEnabled(true);
                        eet.setExtractedText(mExtractedText);
                    } //End block
                    {
                        eet.setEnabled(false);
                        eet.setText("");
                    } //End block
                } //End block
                finally 
                {
                    eet.finishInternalChanges();
                } //End block
                {
                    onExtractingInputChanged(ei);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.403 -0400", hash_original_method = "18DCEDE4996E63CB2DB494AAC7CE4961", hash_generated_method = "7CAAF1DE6FCF1925E5A19C5109A2DB27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onCurrentInputMethodSubtypeChanged(InputMethodSubtype newSubtype) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newSubtype.dsTaint);
        {
            int nameResId;
            nameResId = newSubtype.getNameResId();
            String mode;
            mode = newSubtype.getMode();
            String output;
            output = "changeInputMethodSubtype:"
                + (nameResId == 0 ? "<none>" : getString(nameResId)) + ","
                + mode + ","
                + newSubtype.getLocale() + "," + newSubtype.getExtraValue();//DSFIXME:  CODE0008: Nested ternary operator in expression
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG) {
            //int nameResId = newSubtype.getNameResId();
            //String mode = newSubtype.getMode();
            //String output = "changeInputMethodSubtype:"
                //+ (nameResId == 0 ? "<none>" : getString(nameResId)) + ","
                //+ mode + ","
                //+ newSubtype.getLocale() + "," + newSubtype.getExtraValue();
            //Log.v(TAG, "--- " + output);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.404 -0400", hash_original_method = "ABDAB14391C840F473C7CB9BB20D3C33", hash_generated_method = "101097ECDAA27CD8814BE651E642BB18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
        dsTaint.addTaint(fout.dsTaint);
        dsTaint.addTaint(args[0]);
        dsTaint.addTaint(fd.dsTaint);
        Printer p;
        p = new PrintWriterPrinter(fout);
        p.println("Input method service state for " + this + ":");
        p.println("  mWindowCreated=" + mWindowCreated
                + " mWindowAdded=" + mWindowAdded);
        p.println("  mWindowVisible=" + mWindowVisible
                + " mWindowWasVisible=" + mWindowWasVisible
                + " mInShowWindow=" + mInShowWindow);
        p.println("  Configuration=" + getResources().getConfiguration());
        p.println("  mToken=" + mToken);
        p.println("  mInputBinding=" + mInputBinding);
        p.println("  mInputConnection=" + mInputConnection);
        p.println("  mStartedInputConnection=" + mStartedInputConnection);
        p.println("  mInputStarted=" + mInputStarted
                + " mInputViewStarted=" + mInputViewStarted
                + " mCandidatesViewStarted=" + mCandidatesViewStarted);
        {
            p.println("  mInputEditorInfo:");
            mInputEditorInfo.dump(p, "    ");
        } //End block
        {
            p.println("  mInputEditorInfo: null");
        } //End block
        p.println("  mShowInputRequested=" + mShowInputRequested
                + " mLastShowInputRequested=" + mLastShowInputRequested
                + " mShowInputForced=" + mShowInputForced
                + " mShowInputFlags=0x" + Integer.toHexString(mShowInputFlags));
        p.println("  mCandidatesVisibility=" + mCandidatesVisibility
                + " mFullscreenApplied=" + mFullscreenApplied
                + " mIsFullscreen=" + mIsFullscreen
                + " mExtractViewHidden=" + mExtractViewHidden);
        {
            p.println("  mExtractedText:");
            p.println("    text=" + mExtractedText.text.length() + " chars"
                    + " startOffset=" + mExtractedText.startOffset);
            p.println("    selectionStart=" + mExtractedText.selectionStart
                    + " selectionEnd=" + mExtractedText.selectionEnd
                    + " flags=0x" + Integer.toHexString(mExtractedText.flags));
        } //End block
        {
            p.println("  mExtractedText: null");
        } //End block
        p.println("  mExtractedToken=" + mExtractedToken);
        p.println("  mIsInputViewShown=" + mIsInputViewShown
                + " mStatusIcon=" + mStatusIcon);
        p.println("Last computed insets:");
        p.println("  contentTopInsets=" + mTmpInsets.contentTopInsets
                + " visibleTopInsets=" + mTmpInsets.visibleTopInsets
                + " touchableInsets=" + mTmpInsets.touchableInsets
                + " touchableRegion=" + mTmpInsets.touchableRegion);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public class InputMethodImpl extends AbstractInputMethodImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.404 -0400", hash_original_method = "8339F6437FF23F6C646E31FEA0987022", hash_generated_method = "8339F6437FF23F6C646E31FEA0987022")
                public InputMethodImpl ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.404 -0400", hash_original_method = "2246D0F0FC59D2518EAEE0F0671903AA", hash_generated_method = "49EDC097369ECAE2B0EBAF9D326B8686")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void attachToken(IBinder token) {
            dsTaint.addTaint(token.dsTaint);
            {
                mToken = token;
                mWindow.setToken(token);
            } //End block
            // ---------- Original Method ----------
            //if (mToken == null) {
                //mToken = token;
                //mWindow.setToken(token);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.405 -0400", hash_original_method = "96E89AA7F2E1A70ABC64DBDE36024534", hash_generated_method = "E5BC3D1E528B20FE6308F537C2ABC84B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void bindInput(InputBinding binding) {
            dsTaint.addTaint(binding.dsTaint);
            mInputBinding = binding;
            mInputConnection = binding.getConnection();
            InputConnection ic;
            ic = getCurrentInputConnection();
            ic.reportFullscreenMode(mIsFullscreen);
            initialize();
            onBindInput();
            // ---------- Original Method ----------
            //mInputBinding = binding;
            //mInputConnection = binding.getConnection();
            //if (DEBUG) Log.v(TAG, "bindInput(): binding=" + binding
                    //+ " ic=" + mInputConnection);
            //InputConnection ic = getCurrentInputConnection();
            //if (ic != null) ic.reportFullscreenMode(mIsFullscreen);
            //initialize();
            //onBindInput();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.405 -0400", hash_original_method = "5DFC78D3BA0A9E107E4BC0A877A8E6D3", hash_generated_method = "6B3CEDF4200C9C7C80218F8DD5B5F50D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void unbindInput() {
            onUnbindInput();
            mInputStarted = false;
            mInputBinding = null;
            mInputConnection = null;
            // ---------- Original Method ----------
            //if (DEBUG) Log.v(TAG, "unbindInput(): binding=" + mInputBinding
                    //+ " ic=" + mInputConnection);
            //onUnbindInput();
            //mInputStarted = false;
            //mInputBinding = null;
            //mInputConnection = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.406 -0400", hash_original_method = "ABB2165AD965E17C2FE21B1141C40C8F", hash_generated_method = "86F849A325FF61C40918FDF13ADEBF6B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void startInput(InputConnection ic, EditorInfo attribute) {
            dsTaint.addTaint(ic.dsTaint);
            dsTaint.addTaint(attribute.dsTaint);
            doStartInput(ic, attribute, false);
            // ---------- Original Method ----------
            //if (DEBUG) Log.v(TAG, "startInput(): editor=" + attribute);
            //doStartInput(ic, attribute, false);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.406 -0400", hash_original_method = "FBDDF384E0FE523BAEFE6359495BE0E1", hash_generated_method = "FB01728CE558D0A0465FB245770BB634")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void restartInput(InputConnection ic, EditorInfo attribute) {
            dsTaint.addTaint(ic.dsTaint);
            dsTaint.addTaint(attribute.dsTaint);
            doStartInput(ic, attribute, true);
            // ---------- Original Method ----------
            //if (DEBUG) Log.v(TAG, "restartInput(): editor=" + attribute);
            //doStartInput(ic, attribute, true);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.407 -0400", hash_original_method = "3A4CCDB7EB28BA706C897E348F128E61", hash_generated_method = "BFAA5E3CD38BA35C45F1FD523FC4A145")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void hideSoftInput(int flags, ResultReceiver resultReceiver) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(resultReceiver.dsTaint);
            boolean wasVis;
            wasVis = isInputViewShown();
            mShowInputFlags = 0;
            mShowInputRequested = false;
            mShowInputForced = false;
            hideWindow();
            {
                resultReceiver.send(wasVis != isInputViewShown()
                        ? InputMethodManager.RESULT_HIDDEN
                        : (wasVis ? InputMethodManager.RESULT_UNCHANGED_SHOWN
                                : InputMethodManager.RESULT_UNCHANGED_HIDDEN), null);
            } //End block
            // ---------- Original Method ----------
            //if (DEBUG) Log.v(TAG, "hideSoftInput()");
            //boolean wasVis = isInputViewShown();
            //mShowInputFlags = 0;
            //mShowInputRequested = false;
            //mShowInputForced = false;
            //hideWindow();
            //if (resultReceiver != null) {
                //resultReceiver.send(wasVis != isInputViewShown()
                        //? InputMethodManager.RESULT_HIDDEN
                        //: (wasVis ? InputMethodManager.RESULT_UNCHANGED_SHOWN
                                //: InputMethodManager.RESULT_UNCHANGED_HIDDEN), null);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.408 -0400", hash_original_method = "FA726B6A215F3C1D91F0883D01FD2750", hash_generated_method = "65E0C3089B60DFB52A864C2F2E6C8618")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void showSoftInput(int flags, ResultReceiver resultReceiver) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(resultReceiver.dsTaint);
            boolean wasVis;
            wasVis = isInputViewShown();
            mShowInputFlags = 0;
            {
                boolean var0345BB707617653FF624969C451A707D_1534754712 = (onShowInputRequested(flags, false));
                {
                    showWindow(true);
                } //End block
            } //End collapsed parenthetic
            boolean showing;
            showing = onEvaluateInputViewShown();
            mImm.setImeWindowStatus(mToken, IME_ACTIVE | (showing ? IME_VISIBLE : 0),
                    mBackDisposition);
            {
                resultReceiver.send(wasVis != isInputViewShown()
                        ? InputMethodManager.RESULT_SHOWN
                        : (wasVis ? InputMethodManager.RESULT_UNCHANGED_SHOWN
                                : InputMethodManager.RESULT_UNCHANGED_HIDDEN), null);
            } //End block
            // ---------- Original Method ----------
            //if (DEBUG) Log.v(TAG, "showSoftInput()");
            //boolean wasVis = isInputViewShown();
            //mShowInputFlags = 0;
            //if (onShowInputRequested(flags, false)) {
                //showWindow(true);
            //}
            //boolean showing = onEvaluateInputViewShown();
            //mImm.setImeWindowStatus(mToken, IME_ACTIVE | (showing ? IME_VISIBLE : 0),
                    //mBackDisposition);
            //if (resultReceiver != null) {
                //resultReceiver.send(wasVis != isInputViewShown()
                        //? InputMethodManager.RESULT_SHOWN
                        //: (wasVis ? InputMethodManager.RESULT_UNCHANGED_SHOWN
                                //: InputMethodManager.RESULT_UNCHANGED_HIDDEN), null);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.409 -0400", hash_original_method = "A5FC41682DA51C285C2C6651867F8D99", hash_generated_method = "8C060FC0CB5A765FA8CD564AE03D8441")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void changeInputMethodSubtype(InputMethodSubtype subtype) {
            dsTaint.addTaint(subtype.dsTaint);
            onCurrentInputMethodSubtypeChanged(subtype);
            // ---------- Original Method ----------
            //onCurrentInputMethodSubtypeChanged(subtype);
        }

        
    }


    
    public class InputMethodSessionImpl extends AbstractInputMethodSessionImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.409 -0400", hash_original_method = "A87CDA87E58CB7E0639534760B8A7418", hash_generated_method = "A87CDA87E58CB7E0639534760B8A7418")
                public InputMethodSessionImpl ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.409 -0400", hash_original_method = "3439BC8F3B3DD615353E38FBC0555505", hash_generated_method = "AFBD770524C0D59641E083B7A2F37EED")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void finishInput() {
            {
                boolean varC3AD07CBBFDAC9CFAEE0700F705E9164_2049713407 = (!isEnabled());
            } //End collapsed parenthetic
            doFinishInput();
            // ---------- Original Method ----------
            //if (!isEnabled()) {
                //return;
            //}
            //if (DEBUG) Log.v(TAG, "finishInput() in " + this);
            //doFinishInput();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.410 -0400", hash_original_method = "6A0353E151F9F29333A27C5421A53B38", hash_generated_method = "DCC11DBA0BF1FF96ECCC54C9147997E0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void displayCompletions(CompletionInfo[] completions) {
            dsTaint.addTaint(completions[0].dsTaint);
            {
                boolean varC3AD07CBBFDAC9CFAEE0700F705E9164_124659590 = (!isEnabled());
            } //End collapsed parenthetic
            mCurCompletions = completions;
            onDisplayCompletions(completions);
            // ---------- Original Method ----------
            //if (!isEnabled()) {
                //return;
            //}
            //mCurCompletions = completions;
            //onDisplayCompletions(completions);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.410 -0400", hash_original_method = "0102DD0EEEDCD27552C577307A27FE88", hash_generated_method = "BB1F00FAAB31913E69D50F1AC2D9EA95")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void updateExtractedText(int token, ExtractedText text) {
            dsTaint.addTaint(text.dsTaint);
            dsTaint.addTaint(token);
            {
                boolean varC3AD07CBBFDAC9CFAEE0700F705E9164_216663674 = (!isEnabled());
            } //End collapsed parenthetic
            onUpdateExtractedText(token, text);
            // ---------- Original Method ----------
            //if (!isEnabled()) {
                //return;
            //}
            //onUpdateExtractedText(token, text);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.410 -0400", hash_original_method = "8EA462F0F0CF12CBAE81AB6E28205A3D", hash_generated_method = "18EB42E3149A7AC71150E0EE2941AC62")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void updateSelection(int oldSelStart, int oldSelEnd,
                int newSelStart, int newSelEnd,
                int candidatesStart, int candidatesEnd) {
            dsTaint.addTaint(candidatesStart);
            dsTaint.addTaint(oldSelStart);
            dsTaint.addTaint(candidatesEnd);
            dsTaint.addTaint(newSelStart);
            dsTaint.addTaint(oldSelEnd);
            dsTaint.addTaint(newSelEnd);
            {
                boolean varC3AD07CBBFDAC9CFAEE0700F705E9164_1216972567 = (!isEnabled());
            } //End collapsed parenthetic
            InputMethodService.this.onUpdateSelection(oldSelStart, oldSelEnd,
                    newSelStart, newSelEnd, candidatesStart, candidatesEnd);
            // ---------- Original Method ----------
            //if (!isEnabled()) {
                //return;
            //}
            //InputMethodService.this.onUpdateSelection(oldSelStart, oldSelEnd,
                    //newSelStart, newSelEnd, candidatesStart, candidatesEnd);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.411 -0400", hash_original_method = "7D0F3CDF004B0AA88B105A90C3B2EFF2", hash_generated_method = "C72F950E5DE8C57482A23086387D6494")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void viewClicked(boolean focusChanged) {
            dsTaint.addTaint(focusChanged);
            {
                boolean varC3AD07CBBFDAC9CFAEE0700F705E9164_982243228 = (!isEnabled());
            } //End collapsed parenthetic
            InputMethodService.this.onViewClicked(focusChanged);
            // ---------- Original Method ----------
            //if (!isEnabled()) {
                //return;
            //}
            //InputMethodService.this.onViewClicked(focusChanged);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.411 -0400", hash_original_method = "5A756230FCCA173B557966360DF4EF77", hash_generated_method = "AE349401E8E409205D252851809AF57D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void updateCursor(Rect newCursor) {
            dsTaint.addTaint(newCursor.dsTaint);
            {
                boolean varC3AD07CBBFDAC9CFAEE0700F705E9164_1420211037 = (!isEnabled());
            } //End collapsed parenthetic
            InputMethodService.this.onUpdateCursor(newCursor);
            // ---------- Original Method ----------
            //if (!isEnabled()) {
                //return;
            //}
            //InputMethodService.this.onUpdateCursor(newCursor);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.411 -0400", hash_original_method = "681E840BDEA7B80F2F006F7D9B6B3563", hash_generated_method = "C2D5F25EAE0140A2ED7EDBA3F26BC2B1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void appPrivateCommand(String action, Bundle data) {
            dsTaint.addTaint(data.dsTaint);
            dsTaint.addTaint(action);
            {
                boolean varC3AD07CBBFDAC9CFAEE0700F705E9164_1620953184 = (!isEnabled());
            } //End collapsed parenthetic
            InputMethodService.this.onAppPrivateCommand(action, data);
            // ---------- Original Method ----------
            //if (!isEnabled()) {
                //return;
            //}
            //InputMethodService.this.onAppPrivateCommand(action, data);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.411 -0400", hash_original_method = "F1C4F6A09FBC1E433445388BE149C06F", hash_generated_method = "75BE6C6435E013875061DF4B36B1E810")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void toggleSoftInput(int showFlags, int hideFlags) {
            dsTaint.addTaint(showFlags);
            dsTaint.addTaint(hideFlags);
            InputMethodService.this.onToggleSoftInput(showFlags, hideFlags);
            // ---------- Original Method ----------
            //InputMethodService.this.onToggleSoftInput(showFlags, hideFlags);
        }

        
    }


    
    public static final class Insets {
        public int contentTopInsets;
        public int visibleTopInsets;
        public Region touchableRegion = new Region();
        public int touchableInsets;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.412 -0400", hash_original_method = "34DCFE7756B99EE085D92A8DD78A153B", hash_generated_method = "34DCFE7756B99EE085D92A8DD78A153B")
                public Insets ()
        {
        }


        public static final int TOUCHABLE_INSETS_FRAME
                = ViewTreeObserver.InternalInsetsInfo.TOUCHABLE_INSETS_FRAME;
        public static final int TOUCHABLE_INSETS_CONTENT
                = ViewTreeObserver.InternalInsetsInfo.TOUCHABLE_INSETS_CONTENT;
        public static final int TOUCHABLE_INSETS_VISIBLE
                = ViewTreeObserver.InternalInsetsInfo.TOUCHABLE_INSETS_VISIBLE;
        public static final int TOUCHABLE_INSETS_REGION
                = ViewTreeObserver.InternalInsetsInfo.TOUCHABLE_INSETS_REGION;
    }


    
    static final String TAG = "InputMethodService";
    static final boolean DEBUG = false;
    public static final int BACK_DISPOSITION_DEFAULT = 0;
    public static final int BACK_DISPOSITION_WILL_NOT_DISMISS = 1;
    public static final int BACK_DISPOSITION_WILL_DISMISS = 2;
    public static final int IME_ACTIVE = 0x1;
    public static final int IME_VISIBLE = 0x2;
    static final int MOVEMENT_DOWN = -1;
    static final int MOVEMENT_UP = -2;
}

