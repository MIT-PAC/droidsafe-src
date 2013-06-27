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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.352 -0400", hash_original_field = "47E3DC1D02320FF11860FCA10E93021A", hash_generated_field = "01719032B78A2D912F910E37CD479B69")

    InputMethodManager mImm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.352 -0400", hash_original_field = "9C44372B6B78B59807C8DF03A1965EF9", hash_generated_field = "075FD7AAD50C5AD8803D9E3B208423A2")

    int mTheme = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.353 -0400", hash_original_field = "D03597FDEDE23F3823480E0520822BB2", hash_generated_field = "B03B4DAE3F576B7166425BEE37B96C5E")

    LayoutInflater mInflater;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.353 -0400", hash_original_field = "51146EF3EA2889FD9B2525C6E53C7975", hash_generated_field = "B7C98FA3B531CC028C7A59F94DC2AFFF")

    TypedArray mThemeAttrs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.353 -0400", hash_original_field = "03503F4E2878305C59038D192AB3AC15", hash_generated_field = "6D0C26C611FBD233667A9FA9104CED21")

    View mRootView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.353 -0400", hash_original_field = "F4214BE1FFE044F8CA79EEDDDED72016", hash_generated_field = "507E6EFA97CB0E77FA79A4D01B3ED4A3")

    SoftInputWindow mWindow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.353 -0400", hash_original_field = "57006E58594DC862E67D1855FDF16FEE", hash_generated_field = "C9E05499054E8056F0A4805D1295DEC9")

    boolean mInitialized;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.353 -0400", hash_original_field = "C0D2E2C93F79DA8713BDE478E1537ED0", hash_generated_field = "FE6B5FDA79102585E4703AA7755D8A1D")

    boolean mWindowCreated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.353 -0400", hash_original_field = "86E4FECD64C3696106A1C2B8A242AA04", hash_generated_field = "218C970370BBF49B29F07C78706BEE0F")

    boolean mWindowAdded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.353 -0400", hash_original_field = "F4BEAD71055EFB5C1D3AE1819E120D49", hash_generated_field = "71207F91BCFA87F10E39CE8F643F27A2")

    boolean mWindowVisible;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.353 -0400", hash_original_field = "90DB2BA0D89316B5F84014C89B3C5A49", hash_generated_field = "DC6F9BCE5EC968FD18904FAB6E1E26EA")

    boolean mWindowWasVisible;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.353 -0400", hash_original_field = "AA66B10DBD6B09095C3413E3E854E354", hash_generated_field = "393177CC055DA847245CCD680AD17E8C")

    boolean mInShowWindow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.354 -0400", hash_original_field = "FDFE1E462F69BA102A7B8F8BCFAC963E", hash_generated_field = "15182820025992AE750DB9E78ACD70F3")

    ViewGroup mFullscreenArea;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.354 -0400", hash_original_field = "3A05208DCCF4A0B7E79ED0C5D037E06F", hash_generated_field = "13D1A7834031B0B293BDFE378DF08473")

    FrameLayout mExtractFrame;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.372 -0400", hash_original_field = "560899D96824DB522510CBBACE726143", hash_generated_field = "E6B39B5292209EE43935C8AAB586E41A")

    FrameLayout mCandidatesFrame;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.372 -0400", hash_original_field = "E71070589690CB7B22255920EF5417C2", hash_generated_field = "8060C3896FC8C6EEC2A4B224AC19B8A5")

    FrameLayout mInputFrame;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.372 -0400", hash_original_field = "98E8D2ECD335C543A384E2B940159AF2", hash_generated_field = "DD6EB7EC256F1225D4C6DC1A42FB765B")

    IBinder mToken;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.372 -0400", hash_original_field = "023A158D0015238EFA1E574793716DF1", hash_generated_field = "AFA59EA1150C21AB6E344984735AF2EB")

    InputBinding mInputBinding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.372 -0400", hash_original_field = "A2D010B7C3546462A260EC1C5E1ED4C6", hash_generated_field = "0C4E3C3C223DA7FB43EF5D532A5B3E04")

    InputConnection mInputConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.372 -0400", hash_original_field = "782D39EBDAC05F2DB212AB8342884C64", hash_generated_field = "D15B1F449CE3CDE14A0008B2465EE7E3")

    boolean mInputStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.372 -0400", hash_original_field = "997F4B1392777ED6D28F46C5D817E4B7", hash_generated_field = "514EB139852D82B47A3950B6F3E19CF6")

    boolean mInputViewStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.372 -0400", hash_original_field = "000D18FCF61C40AD69E3E56BEB71A5A6", hash_generated_field = "4626543A6FCF1F8B8B73D10B97975D09")

    boolean mCandidatesViewStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.373 -0400", hash_original_field = "90E29B0FBB7D81AF12FD516A1C18EE0A", hash_generated_field = "60FF159378B9E2B6E495E1B7233D3981")

    InputConnection mStartedInputConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.373 -0400", hash_original_field = "EDB1ADCF132EE49252AA404EA0C42BDC", hash_generated_field = "0A7D4D3889811FF61BF27942BE846641")

    EditorInfo mInputEditorInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.373 -0400", hash_original_field = "9B0BEB2912C7407E921A6905D7C94F4B", hash_generated_field = "293541479A1626BCDA923AA8063FA9A6")

    int mShowInputFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.373 -0400", hash_original_field = "3130E5E55A7C8BB928012D0F32C408DB", hash_generated_field = "7599FBE37A9716825A76F29F0FE2FD55")

    boolean mShowInputRequested;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.373 -0400", hash_original_field = "E059488A4BAF82E3EB1514BBEF6A5C04", hash_generated_field = "46B9F45DD04B32BAA4E84977F39214E7")

    boolean mLastShowInputRequested;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.373 -0400", hash_original_field = "22665F4551D5A5EC46B2D94EDA2C4B99", hash_generated_field = "A9B119877C3EB8E978CAEECF1D6BD14B")

    int mCandidatesVisibility;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.373 -0400", hash_original_field = "C0ED2CFA44D0D69EEA23C8E4C66CE227", hash_generated_field = "497159238D66DB93A282D483EC1CA3AC")

    CompletionInfo[] mCurCompletions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.374 -0400", hash_original_field = "27CC66322143CE51D330735DF962162F", hash_generated_field = "0A08F53EED6C8EEC9D7CC85E98FAC447")

    boolean mShowInputForced;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.374 -0400", hash_original_field = "0FD506CFFBAF2760EA3C8C7A61A1EC34", hash_generated_field = "269508F0F9EF09EB866044C649D586B1")

    boolean mFullscreenApplied;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.374 -0400", hash_original_field = "54AB7B409DAEC84F47F83754E82B9CF7", hash_generated_field = "9CA62515CAD4DE9A3596FC712B0811BA")

    boolean mIsFullscreen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.374 -0400", hash_original_field = "A1FE7A1C3E639FA004091CB9A1C3BADC", hash_generated_field = "77749D3AEC38C02813E052F85601DCFE")

    View mExtractView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.374 -0400", hash_original_field = "63BD8F8E7390940615BF50D62ABA7B61", hash_generated_field = "41C2A191F101A74E110D9728B296F375")

    boolean mExtractViewHidden;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.374 -0400", hash_original_field = "DF23DA4699300FCC03743118373EEB29", hash_generated_field = "10C7C27B9EFB4B449D020D2FD7D681C8")

    ExtractEditText mExtractEditText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.374 -0400", hash_original_field = "D3312E3FB49BA27FC912A51A3BE0EB28", hash_generated_field = "49FE9D4C4E2B1ED741DB08F3BECEA464")

    ViewGroup mExtractAccessories;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.374 -0400", hash_original_field = "0EC10097C9F7737C7F02A1274F00634D", hash_generated_field = "4EF514D7B6A680A68FB4FA03A08F5D2D")

    Button mExtractAction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.378 -0400", hash_original_field = "A034AA34A307E777C43933E669A375DC", hash_generated_field = "7C5C99560AB4918E13830D06100AC03C")

    ExtractedText mExtractedText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.378 -0400", hash_original_field = "3B05C3A55FB18FD1556EDCEA83357EA4", hash_generated_field = "E322EFE9A47EF352CC52DE566A5DCA94")

    int mExtractedToken;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.378 -0400", hash_original_field = "CC1A335F32158BD1BD949E24E11AE1DC", hash_generated_field = "DD75F3DC122E5FCA3B30C64DE9D6C9CD")

    View mInputView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.379 -0400", hash_original_field = "05E05DFE926C9F572FDAAECF32DC796C", hash_generated_field = "77B5EB3473D5B10089CC95C2ED94891E")

    boolean mIsInputViewShown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.379 -0400", hash_original_field = "1C10330016E3D1BDEB192DB6D2AE8892", hash_generated_field = "98EF9B06A59A7DC308ADD81484067F39")

    int mStatusIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.379 -0400", hash_original_field = "269EBC9196383CF7ED8E2C7FC1F02A76", hash_generated_field = "FD8B0612F7004ABC6C691A56C2D256FE")

    int mBackDisposition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.379 -0400", hash_original_field = "FA246E03DDB3F75A905A719A7A70B1A3", hash_generated_field = "68F5252D64F8D4159C578F571A77AB54")

    Insets mTmpInsets = new Insets();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.379 -0400", hash_original_field = "4BC786D43E92B4BEDC23ACC8C07672C0", hash_generated_field = "18ECE134BF0FC41944D7DF74E92F279C")

    int[] mTmpLocation = new int[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.391 -0400", hash_original_field = "142F5B53CE3CC0CB3C0E6D7392FA4726", hash_generated_field = "8D9BE8985336988D3A77FF7984C97058")

    ViewTreeObserver.OnComputeInternalInsetsListener mInsetsComputer = new ViewTreeObserver.OnComputeInternalInsetsListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.391 -0400", hash_original_method = "3A80214106299C195F4E4A04B9DB62AA", hash_generated_method = "C0BCC5D1D50E5C3A4896A1DA9CB66B48")
        public void onComputeInternalInsets(ViewTreeObserver.InternalInsetsInfo info) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean var1E9E12E1C314AB48D78EC2186631F908_1190790331 = (isExtractViewShown());
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
            addTaint(info.getTaint());
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

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.420 -0400", hash_original_field = "C94A4138F2315FEEC71C08F04887EF50", hash_generated_field = "49D00F76301F644ECF67413CF3070884")

    View.OnClickListener mActionClickListener = new View.OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.420 -0400", hash_original_method = "F78C13955980C6EBFBCB4858D6B59E8E", hash_generated_method = "C2B30C0F3F7A675F1B932CE62236C061")
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
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
            addTaint(v.getTaint());
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

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.420 -0400", hash_original_method = "1525492D8EE98BBF3E2138610F838AAF", hash_generated_method = "1525492D8EE98BBF3E2138610F838AAF")
    public InputMethodService ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.421 -0400", hash_original_method = "A950397745137F47AE3797B428EC17A0", hash_generated_method = "83B58C51650A0D9F086F4FB4DFABB584")
    @Override
    public void setTheme(int theme) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Must be called before onCreate()");
        } //End block
        mTheme = theme;
        // ---------- Original Method ----------
        //if (mWindow != null) {
            //throw new IllegalStateException("Must be called before onCreate()");
        //}
        //mTheme = theme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.425 -0400", hash_original_method = "A4061C51E6B315B625647A4DAEF1D932", hash_generated_method = "DE550ABE012B963890E5EA21805F7878")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.442 -0400", hash_original_method = "76EDD2B848D79265B59C656C09132FEB", hash_generated_method = "83EE169EF2FBBDAF4C6A06E84EF30B78")
    public void onInitializeInterface() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.443 -0400", hash_original_method = "F1A6BBC586CE4C5158D93D758F9EE4FD", hash_generated_method = "7C63C721EAC547413CE5708A1F496E22")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.467 -0400", hash_original_method = "E6A2B0DBCD46A23062A8849E041DB211", hash_generated_method = "EE633C0264120F02036674CD09C678E4")
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
            boolean var42B91C3FC5E7160C1292C676D44C7C35_782529927 = (Settings.System.getInt(getContentResolver(),
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.479 -0400", hash_original_method = "03BF0E4B83AB5EEC5EA04DACA2552646", hash_generated_method = "FED5ACC4025145E20089A53DCC14F84F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.482 -0400", hash_original_method = "0B7AD8CA788BAE093A6DAEC0C292F050", hash_generated_method = "D92D0C7ABC57B934CB089D2DF8180D58")
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
                    boolean varE76E4AD258BBF3AE36D8B1906DE05BFD_1691495608 = (onShowInputRequested(showFlags, true));
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
        addTaint(newConfig.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.496 -0400", hash_original_method = "4C23D68F9AF6231E77018CB50F89B333", hash_generated_method = "163F2E1372EF8AB2AB0BE8A4E6B22DD8")
    @Override
    public AbstractInputMethodImpl onCreateInputMethodInterface() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        AbstractInputMethodImpl varB4EAC82CA7396A68D541C85D26508E83_519871035 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_519871035 = new InputMethodImpl();
        varB4EAC82CA7396A68D541C85D26508E83_519871035.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_519871035;
        // ---------- Original Method ----------
        //return new InputMethodImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.497 -0400", hash_original_method = "A293E788F38BE631F0B24DA3CBEC4EAD", hash_generated_method = "39829CD56C53B264ED6FBDEAE6AD6955")
    @Override
    public AbstractInputMethodSessionImpl onCreateInputMethodSessionInterface() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        AbstractInputMethodSessionImpl varB4EAC82CA7396A68D541C85D26508E83_1387541539 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1387541539 = new InputMethodSessionImpl();
        varB4EAC82CA7396A68D541C85D26508E83_1387541539.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1387541539;
        // ---------- Original Method ----------
        //return new InputMethodSessionImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.498 -0400", hash_original_method = "F107DE3A8547E443866FF02369203993", hash_generated_method = "107A62167AB51AC25655AAA393FEEA4C")
    public LayoutInflater getLayoutInflater() {
        LayoutInflater varB4EAC82CA7396A68D541C85D26508E83_1469875227 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1469875227 = mInflater;
        varB4EAC82CA7396A68D541C85D26508E83_1469875227.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1469875227;
        // ---------- Original Method ----------
        //return mInflater;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.499 -0400", hash_original_method = "B35683FF457638BA2516208C83F2FBFC", hash_generated_method = "B71556F7498D6C4703EF634F95D48D84")
    public Dialog getWindow() {
        Dialog varB4EAC82CA7396A68D541C85D26508E83_307645510 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_307645510 = mWindow;
        varB4EAC82CA7396A68D541C85D26508E83_307645510.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_307645510;
        // ---------- Original Method ----------
        //return mWindow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.514 -0400", hash_original_method = "4B38ED63C74A7D25A43EF42301FB70B0", hash_generated_method = "46A6C22207C263E445ACBEE325B9DE9D")
    public void setBackDisposition(int disposition) {
        mBackDisposition = disposition;
        // ---------- Original Method ----------
        //mBackDisposition = disposition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.514 -0400", hash_original_method = "FA0668AA74F2A3E40C75CD8A8BEC8D4A", hash_generated_method = "2004AD8E37F1AD3111EBCEB6431DDF9C")
    public int getBackDisposition() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_920647395 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_920647395;
        // ---------- Original Method ----------
        //return mBackDisposition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.515 -0400", hash_original_method = "BF0CCCE3A6DFBF869485401A0C0B52E1", hash_generated_method = "58A0CB23B1DC3F6F6DE29A07586D5149")
    public int getMaxWidth() {
        WindowManager wm;
        wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        int var2277AEB58FD93D1A35DD1F32A4E8EB14_623729016 = (wm.getDefaultDisplay().getWidth());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1643425667 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1643425667;
        // ---------- Original Method ----------
        //WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        //return wm.getDefaultDisplay().getWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.516 -0400", hash_original_method = "064CBE2A131D4B226EADDD6A40CEAEED", hash_generated_method = "A50D7BAE77DB06CD108EF2AFE84E86C2")
    public InputBinding getCurrentInputBinding() {
        InputBinding varB4EAC82CA7396A68D541C85D26508E83_620885272 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_620885272 = mInputBinding;
        varB4EAC82CA7396A68D541C85D26508E83_620885272.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_620885272;
        // ---------- Original Method ----------
        //return mInputBinding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.548 -0400", hash_original_method = "25EFF753F3CF5167178BD7379B9659BF", hash_generated_method = "0FFCA700C1129927EC021EC386702867")
    public InputConnection getCurrentInputConnection() {
        InputConnection varB4EAC82CA7396A68D541C85D26508E83_623153327 = null; //Variable for return #1
        InputConnection varB4EAC82CA7396A68D541C85D26508E83_681632948 = null; //Variable for return #2
        InputConnection ic;
        ic = mStartedInputConnection;
        {
            varB4EAC82CA7396A68D541C85D26508E83_623153327 = ic;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_681632948 = mInputConnection;
        InputConnection varA7E53CE21691AB073D9660D615818899_1547377475; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1547377475 = varB4EAC82CA7396A68D541C85D26508E83_623153327;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1547377475 = varB4EAC82CA7396A68D541C85D26508E83_681632948;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1547377475.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1547377475;
        // ---------- Original Method ----------
        //InputConnection ic = mStartedInputConnection;
        //if (ic != null) {
            //return ic;
        //}
        //return mInputConnection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.549 -0400", hash_original_method = "26F207E076BC370412C35CB8C7E97837", hash_generated_method = "E8F9CAD7817AC43C10BBF7170C1E1747")
    public boolean getCurrentInputStarted() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1179838541 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1179838541;
        // ---------- Original Method ----------
        //return mInputStarted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.550 -0400", hash_original_method = "659C592D4ABB3DB82261D1C4692ABF2E", hash_generated_method = "B3F12ABB9568A8298283DC0756B97A9E")
    public EditorInfo getCurrentInputEditorInfo() {
        EditorInfo varB4EAC82CA7396A68D541C85D26508E83_1013156721 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1013156721 = mInputEditorInfo;
        varB4EAC82CA7396A68D541C85D26508E83_1013156721.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1013156721;
        // ---------- Original Method ----------
        //return mInputEditorInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.584 -0400", hash_original_method = "27763B4939D9D4CE4F4BEBC3E63AF469", hash_generated_method = "14F454B8A6A0D5A84A2D83C72E0D003D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.585 -0400", hash_original_method = "57F13E10195CB2F326F03FED8DB64B03", hash_generated_method = "C60A9927525ADC98040635D9889BA8F6")
    public void onConfigureWindow(Window win, boolean isFullscreen,
            boolean isCandidatesOnly) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mWindow.getWindow().setLayout(MATCH_PARENT, MATCH_PARENT);
        } //End block
        {
            mWindow.getWindow().setLayout(MATCH_PARENT, WRAP_CONTENT);
        } //End block
        addTaint(win.getTaint());
        addTaint(isFullscreen);
        addTaint(isCandidatesOnly);
        // ---------- Original Method ----------
        //if (isFullscreen) {
            //mWindow.getWindow().setLayout(MATCH_PARENT, MATCH_PARENT);
        //} else {
            //mWindow.getWindow().setLayout(MATCH_PARENT, WRAP_CONTENT);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.585 -0400", hash_original_method = "0B558CA7980DF9D2EBB981E6DDF5DF60", hash_generated_method = "1AD342CA171EBFBF37B2EF5789B302B9")
    public boolean isFullscreenMode() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_518645291 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_518645291;
        // ---------- Original Method ----------
        //return mIsFullscreen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.586 -0400", hash_original_method = "F5927891A0B192B06619C4589486FDC4", hash_generated_method = "23095DBCDE36922FBDED0861F84CFA9B")
    public boolean onEvaluateFullscreenMode() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Configuration config;
        config = getResources().getConfiguration();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1632876207 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1632876207;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.587 -0400", hash_original_method = "D4950711A20DE11BC2C7EA5EC93FE5E0", hash_generated_method = "9A1C7B3C016AB62708C38E181AF256B9")
    public void setExtractViewShown(boolean shown) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.587 -0400", hash_original_method = "DE07F0C980519D51E427F21507DA3D90", hash_generated_method = "3C3214557DDF4BE332EC3F415F0FF78D")
    public boolean isExtractViewShown() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1385352794 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1385352794;
        // ---------- Original Method ----------
        //return mIsFullscreen && !mExtractViewHidden;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.590 -0400", hash_original_method = "7CD3F30CDD4A5DA751939DF09DB853BA", hash_generated_method = "5B78921EDF4B5C81E64151E1D1324860")
     void updateExtractFrameVisibility() {
        int vis;
        {
            boolean varDA1B124F93BA93414CB6CAF390A362A8_1347763337 = (isFullscreenMode());
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
            boolean var548700EC502290A06EC6C7AD18983A79_1544859869 = (mWindowWasVisible && mFullscreenArea.getVisibility() != vis);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.611 -0400", hash_original_method = "46EC672E73C1227D1C1A9029A1E1F3EE", hash_generated_method = "18B8F2A9AD4F742FE84E9E2C9016ED47")
    public void onComputeInsets(Insets outInsets) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int[] loc;
        loc = mTmpLocation;
        {
            boolean var79E067E94CDE3882F5E84A741E69778F_1898842732 = (mInputFrame.getVisibility() == View.VISIBLE);
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
            boolean varDA1B124F93BA93414CB6CAF390A362A8_1759237100 = (isFullscreenMode());
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
            boolean varD90E8A6553A0F92E94122AA94D382E19_790460616 = (mCandidatesFrame.getVisibility() == View.VISIBLE);
            {
                mCandidatesFrame.getLocationInWindow(loc);
            } //End block
        } //End collapsed parenthetic
        outInsets.visibleTopInsets = loc[1];
        outInsets.touchableInsets = Insets.TOUCHABLE_INSETS_VISIBLE;
        outInsets.touchableRegion.setEmpty();
        addTaint(outInsets.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.628 -0400", hash_original_method = "0265E8D9142690DEBAB6C995400C2A87", hash_generated_method = "AA5D25F42180E5A4529390C34477E9ED")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.629 -0400", hash_original_method = "CE1497EC29214CA28D281C89DC587F5D", hash_generated_method = "94F0DF8EB25C4824DA3CB9C46333BCCA")
    public boolean isShowInputRequested() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1115447940 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1115447940;
        // ---------- Original Method ----------
        //return mShowInputRequested;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.629 -0400", hash_original_method = "FAB0B10F230F7249B0A5682A6CF03BDF", hash_generated_method = "12544D5C035449E82917A22857248DDF")
    public boolean isInputViewShown() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_258949392 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_258949392;
        // ---------- Original Method ----------
        //return mIsInputViewShown && mWindowVisible;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.631 -0400", hash_original_method = "1FE8D4523FDD0EE9294351AC86397C44", hash_generated_method = "CE810EB3753BC0F63D3A3F51513A46BD")
    public boolean onEvaluateInputViewShown() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Configuration config;
        config = getResources().getConfiguration();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1005979323 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1005979323;
        // ---------- Original Method ----------
        //Configuration config = getResources().getConfiguration();
        //return config.keyboard == Configuration.KEYBOARD_NOKEYS
                //|| config.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_YES;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.631 -0400", hash_original_method = "3ADC6F28D6F2E8A9F55D9BD9F82BC8D2", hash_generated_method = "2596C08761B57C262DB3FB0E4520A40D")
    public void setCandidatesViewShown(boolean shown) {
        updateCandidatesVisibility(shown);
        {
            {
                showWindow(false);
            } //End block
            {
                hideWindow();
            } //End block
        } //End block
        addTaint(shown);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.632 -0400", hash_original_method = "4164AC2B45DCCBE42C527D3F966F5882", hash_generated_method = "7273FFFBF842D94403313099DBFAF9C4")
     void updateCandidatesVisibility(boolean shown) {
        int vis;
        vis = View.VISIBLE;
        vis = getCandidatesHiddenVisibility();
        {
            mCandidatesFrame.setVisibility(vis);
            mCandidatesVisibility = vis;
        } //End block
        addTaint(shown);
        // ---------- Original Method ----------
        //int vis = shown ? View.VISIBLE : getCandidatesHiddenVisibility();
        //if (mCandidatesVisibility != vis) {
            //mCandidatesFrame.setVisibility(vis);
            //mCandidatesVisibility = vis;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.644 -0400", hash_original_method = "587D3BCB04C3551F0F314F802D60C565", hash_generated_method = "DF27EAE1CF2D2413AE2374CC43EF26B6")
    public int getCandidatesHiddenVisibility() {
        {
            boolean varED8C2CEF57D48CBEF71A26459BE2DF41_1236354030 = (isExtractViewShown());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_187931104 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_187931104;
        // ---------- Original Method ----------
        //return isExtractViewShown() ? View.GONE : View.INVISIBLE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.645 -0400", hash_original_method = "09F11407FBE421F2EB35629AC776C29A", hash_generated_method = "DECC09ED0847FD21887B434C8C7A2F55")
    public void showStatusIcon(int iconResId) {
        mStatusIcon = iconResId;
        mImm.showStatusIcon(mToken, getPackageName(), iconResId);
        // ---------- Original Method ----------
        //mStatusIcon = iconResId;
        //mImm.showStatusIcon(mToken, getPackageName(), iconResId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.646 -0400", hash_original_method = "F1217201D04BC19DA5F1842A9EA12AC0", hash_generated_method = "1FEC1D46E33E85CCE5B5210B4D8FEDD0")
    public void hideStatusIcon() {
        mStatusIcon = 0;
        mImm.hideStatusIcon(mToken);
        // ---------- Original Method ----------
        //mStatusIcon = 0;
        //mImm.hideStatusIcon(mToken);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.652 -0400", hash_original_method = "65B927BAD02A0A8652162D17880CBC94", hash_generated_method = "FCC4926ADFC2ECEE94B9C332F39E19F4")
    public void switchInputMethod(String id) {
        mImm.setInputMethod(mToken, id);
        addTaint(id.getTaint());
        // ---------- Original Method ----------
        //mImm.setInputMethod(mToken, id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.670 -0400", hash_original_method = "7F30721F4F1DC6518EC25FA69EEA9DD8", hash_generated_method = "CDA9D00F13C5A4E9F4F27CD30F04BCC1")
    public void setExtractView(View view) {
        mExtractFrame.removeAllViews();
        mExtractFrame.addView(view, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        mExtractView = view;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.671 -0400", hash_original_method = "8648EAF39F078D77783E311D9636B394", hash_generated_method = "5F49A98A89E7C6853457A2DBB9C200C5")
    public void setCandidatesView(View view) {
        mCandidatesFrame.removeAllViews();
        mCandidatesFrame.addView(view, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        //mCandidatesFrame.removeAllViews();
        //mCandidatesFrame.addView(view, new FrameLayout.LayoutParams(
                //ViewGroup.LayoutParams.MATCH_PARENT,
                //ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.679 -0400", hash_original_method = "F530779F20B702B2AC3AEE15911FE235", hash_generated_method = "448C234ECEA41219ABFCADD0A5752A31")
    public void setInputView(View view) {
        mInputFrame.removeAllViews();
        mInputFrame.addView(view, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        mInputView = view;
        // ---------- Original Method ----------
        //mInputFrame.removeAllViews();
        //mInputFrame.addView(view, new FrameLayout.LayoutParams(
                //ViewGroup.LayoutParams.MATCH_PARENT,
                //ViewGroup.LayoutParams.WRAP_CONTENT));
        //mInputView = view;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.680 -0400", hash_original_method = "A13C1AA9A5FD5770C02F503628C51194", hash_generated_method = "681D65009EEA6D2690C1350C8DD73F05")
    public View onCreateExtractTextView() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        View varB4EAC82CA7396A68D541C85D26508E83_499323509 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_499323509 = mInflater.inflate(
                com.android.internal.R.layout.input_method_extract_view, null);
        varB4EAC82CA7396A68D541C85D26508E83_499323509.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_499323509;
        // ---------- Original Method ----------
        //return mInflater.inflate(
                //com.android.internal.R.layout.input_method_extract_view, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.747 -0400", hash_original_method = "F89AAD61B39578A3862B8537E7226DB5", hash_generated_method = "F2EBA38417CFF292D1ABDB5D09E8E941")
    public View onCreateCandidatesView() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        View varB4EAC82CA7396A68D541C85D26508E83_12690086 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_12690086 = null;
        varB4EAC82CA7396A68D541C85D26508E83_12690086.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_12690086;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.749 -0400", hash_original_method = "75C53F9A7550BADCC3EEC67DE46E8BC4", hash_generated_method = "1EEA11A8BECE3A7703C832A171108E59")
    public View onCreateInputView() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        View varB4EAC82CA7396A68D541C85D26508E83_635979546 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_635979546 = null;
        varB4EAC82CA7396A68D541C85D26508E83_635979546.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_635979546;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.751 -0400", hash_original_method = "4B7A497965AEC42ECF0C79E271F7AFEF", hash_generated_method = "E916951172883C0F58CDCC3747E38446")
    public void onStartInputView(EditorInfo info, boolean restarting) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(info.getTaint());
        addTaint(restarting);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.752 -0400", hash_original_method = "126397FC018D546EBB3D17AA8B426F4F", hash_generated_method = "1FBD64062950E0194461EC4060B9B9C5")
    public void onFinishInputView(boolean finishingInput) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            InputConnection ic;
            ic = getCurrentInputConnection();
            {
                ic.finishComposingText();
            } //End block
        } //End block
        addTaint(finishingInput);
        // ---------- Original Method ----------
        //if (!finishingInput) {
            //InputConnection ic = getCurrentInputConnection();
            //if (ic != null) {
                //ic.finishComposingText();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.762 -0400", hash_original_method = "C1D318033051A63629AB7F18935A055B", hash_generated_method = "7BE62851E5BD3F3C78A4B38A6A2455C3")
    public void onStartCandidatesView(EditorInfo info, boolean restarting) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(info.getTaint());
        addTaint(restarting);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.765 -0400", hash_original_method = "7B21B5BD050EBE81B79EA707D7F10503", hash_generated_method = "19B5C464DC1E592182AA9585CC0C45C8")
    public void onFinishCandidatesView(boolean finishingInput) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            InputConnection ic;
            ic = getCurrentInputConnection();
            {
                ic.finishComposingText();
            } //End block
        } //End block
        addTaint(finishingInput);
        // ---------- Original Method ----------
        //if (!finishingInput) {
            //InputConnection ic = getCurrentInputConnection();
            //if (ic != null) {
                //ic.finishComposingText();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.782 -0400", hash_original_method = "7116B74C32B9543E489CB78AF9B82E3D", hash_generated_method = "AF17FD436A86B96EEFEDFCFC74245758")
    public boolean onShowInputRequested(int flags, boolean configChange) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var9151F215B67E3E110B8160488A310989_1750975663 = (!onEvaluateInputViewShown());
        } //End collapsed parenthetic
        {
            {
                boolean varB1105F93C8A3332B01967E57F54EA7F5_22601290 = (!configChange && onEvaluateFullscreenMode());
            } //End collapsed parenthetic
            Configuration config;
            config = getResources().getConfiguration();
        } //End block
        {
            mShowInputForced = true;
        } //End block
        addTaint(flags);
        addTaint(configChange);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1423928603 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1423928603;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.784 -0400", hash_original_method = "119016FA69877024FD5AD688A6BA764A", hash_generated_method = "B8885889E0A48F19B4706A903BBEFEF7")
    public void showWindow(boolean showInput) {
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
        addTaint(showInput);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.817 -0400", hash_original_method = "CB135560325B3F8C18497A9052C17028", hash_generated_method = "0512E0A9EAA6EB26A1E8755F134B3A1E")
     void showWindowInner(boolean showInput) {
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
        addTaint(showInput);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.818 -0400", hash_original_method = "AE7818A6DC114C265A5A8660654BB926", hash_generated_method = "4D5A11064569AA5F7303EF116AEDEAA3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.819 -0400", hash_original_method = "09134BCCF788D1D9024485AE6DA1693C", hash_generated_method = "16EEEC9F8593063A82AAF47B525A09E8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.820 -0400", hash_original_method = "D99B15EAA68884714BB333A2583A0571", hash_generated_method = "E797350F14362CA554D013A5659543F1")
    public void onWindowShown() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.820 -0400", hash_original_method = "C1BA79DB491FC590F2A9A222970A46B9", hash_generated_method = "82493FCA94AEB547B2950C787893F07B")
    public void onWindowHidden() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.826 -0400", hash_original_method = "56BEE8816781B99E44028AA4DD49AFE8", hash_generated_method = "9A3D5E9EBB717318D195E3F6D8803AE5")
    public void onBindInput() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.826 -0400", hash_original_method = "D52B154580F2280F1D8D5CF7DCC6C0BF", hash_generated_method = "049C427B4927AA2DB3B5531ABC79BA72")
    public void onUnbindInput() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.842 -0400", hash_original_method = "3ADFFB39DB97C5354271962A42564DD7", hash_generated_method = "4C0B9C5E6309EE4241134758A86A3D42")
    public void onStartInput(EditorInfo attribute, boolean restarting) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(attribute.getTaint());
        addTaint(restarting);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.844 -0400", hash_original_method = "D870334B8409E203BCA5DBA60A032B6F", hash_generated_method = "246F9011D67E57587BF93602711A96F2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.859 -0400", hash_original_method = "D70A8E32EEED9199B71D72D85567D543", hash_generated_method = "7A6306B23521605091A12339D03CC401")
     void doStartInput(InputConnection ic, EditorInfo attribute, boolean restarting) {
        {
            doFinishInput();
        } //End block
        mInputStarted = true;
        mStartedInputConnection = ic;
        mInputEditorInfo = attribute;
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
        addTaint(restarting);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.860 -0400", hash_original_method = "E745A863BE4D98B94E02F169B272F08C", hash_generated_method = "4FDABE53DFC0FB8D4F16FAB7D6D0DC57")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.861 -0400", hash_original_method = "75C3F475CAD98FE8CF4A523C8BDA8BB1", hash_generated_method = "B39F7F3BEFB24E502F188051870EED91")
    public void onDisplayCompletions(CompletionInfo[] completions) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(completions[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.862 -0400", hash_original_method = "CC541C375904CEFCC1DC228363FE0C44", hash_generated_method = "07B266CDA4EFB2DD2809EEECD681E7DB")
    public void onUpdateExtractedText(int token, ExtractedText text) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            {
                mExtractedText = text;
                mExtractEditText.setExtractedText(text);
            } //End block
        } //End block
        addTaint(token);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.878 -0400", hash_original_method = "08F34B1B106CF5B01DE522670D82A3BC", hash_generated_method = "9599245149F4256727D9E7A3B84F7BF8")
    public void onUpdateSelection(int oldSelStart, int oldSelEnd,
            int newSelStart, int newSelEnd,
            int candidatesStart, int candidatesEnd) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        ExtractEditText eet;
        eet = mExtractEditText;
        {
            boolean var07839FB6DDF532AEC3BACA070CA2FC06_495357875 = (eet != null && isFullscreenMode() && mExtractedText != null);
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
        addTaint(oldSelStart);
        addTaint(oldSelEnd);
        addTaint(newSelStart);
        addTaint(newSelEnd);
        addTaint(candidatesStart);
        addTaint(candidatesEnd);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.879 -0400", hash_original_method = "D49077B58DC986892621B88ACD9BF0F7", hash_generated_method = "87A26FC82293103A524EB821FB8B0059")
    public void onViewClicked(boolean focusChanged) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(focusChanged);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.883 -0400", hash_original_method = "F8EB5FE11A8138FB360940D74155758A", hash_generated_method = "4CB7960253167CFAAB602CD800822ACE")
    public void onUpdateCursor(Rect newCursor) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newCursor.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.887 -0400", hash_original_method = "53762C81936F5FCD41F3F903406EE4C3", hash_generated_method = "F4B819E34691FF54D81086410C9F0E54")
    public void requestHideSelf(int flags) {
        mImm.hideSoftInputFromInputMethod(mToken, flags);
        addTaint(flags);
        // ---------- Original Method ----------
        //mImm.hideSoftInputFromInputMethod(mToken, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.888 -0400", hash_original_method = "939E9922D22E9C6523AEB259C97CBC65", hash_generated_method = "70BFF6F3D592ABB72D21315BE8B13CA7")
    private void requestShowSelf(int flags) {
        mImm.showSoftInputFromInputMethod(mToken, flags);
        addTaint(flags);
        // ---------- Original Method ----------
        //mImm.showSoftInputFromInputMethod(mToken, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.904 -0400", hash_original_method = "2F1E84CCA4C2BB5EFB606DA289F60F64", hash_generated_method = "7E6A73461BD072395D44BF79320189EF")
    private boolean handleBack(boolean doIt) {
        {
            {
                boolean var702D5193BDDB49ACD0C022D27D4F16B7_2072782880 = (isExtractViewShown() && mExtractView instanceof ExtractEditLayout);
                {
                    ExtractEditLayout extractEditLayout;
                    extractEditLayout = (ExtractEditLayout) mExtractView;
                    {
                        boolean var5924543FB4797135854B81B78B99C485_25082926 = (extractEditLayout.isActionModeStarted());
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
        addTaint(doIt);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1738892709 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1738892709;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.905 -0400", hash_original_method = "6D39318911C6DEDF33A28EA4D06A473F", hash_generated_method = "A4DE4A96376AE3D9220A2B3490F7DE00")
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var5900307FC72CF55A885B11E67B5ADB96_1371105364 = (event.getKeyCode() == KeyEvent.KEYCODE_BACK);
            {
                {
                    boolean var30194127B59F20B8D15CB7440CF6FB54_2022636709 = (handleBack(false));
                    {
                        event.startTracking();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean varBC0795DACA35C6A9F77201B924F9EBCC_883876854 = (doMovementKey(keyCode, event, MOVEMENT_DOWN));
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_813210423 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_813210423;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.905 -0400", hash_original_method = "2A75FF2C44C4D96068DDAFC2643F0C8B", hash_generated_method = "178D98B9DF428C2A6436F2738E187B79")
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_389634181 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_389634181;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.918 -0400", hash_original_method = "3CC4F52C9B71FCD2A0600FA46D6F06E5", hash_generated_method = "30AA04347616FE302D7A4C0BAAF724B6")
    public boolean onKeyMultiple(int keyCode, int count, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        boolean var690BBBD39586299984278532B3B9C485_374408440 = (doMovementKey(keyCode, event, count));
        addTaint(keyCode);
        addTaint(count);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1365057166 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1365057166;
        // ---------- Original Method ----------
        //return doMovementKey(keyCode, event, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.919 -0400", hash_original_method = "BCD4505881DB97C910099D82B7A22807", hash_generated_method = "93FE2E50920375EDDEA17EFA35275BCB")
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var5922C562AF2EE989EFA0391BD79A8FD9_1589164278 = (event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.isTracking()
                && !event.isCanceled());
            {
                boolean varD293510AE3D22D4016F47B37DB94AA22_894401852 = (handleBack(true));
            } //End block
        } //End collapsed parenthetic
        boolean var8B63F1B3C4C5EA6147670BB023C5C4C4_361882806 = (doMovementKey(keyCode, event, MOVEMENT_UP));
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1861963540 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1861963540;
        // ---------- Original Method ----------
        //if (event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.isTracking()
                //&& !event.isCanceled()) {
            //return handleBack(true);
        //}
        //return doMovementKey(keyCode, event, MOVEMENT_UP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.919 -0400", hash_original_method = "4A983FDB3FF481E2165B7D8D641CDD48", hash_generated_method = "B20CE5B9D217B958EB9D9D13CBD2062E")
    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2058408716 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2058408716;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.919 -0400", hash_original_method = "E2F219F9B605C6393794145B9C28D4D7", hash_generated_method = "152610093C22CA4DD8518A4BDB847682")
    public void onAppPrivateCommand(String action, Bundle data) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(action.getTaint());
        addTaint(data.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.935 -0400", hash_original_method = "F1BA2156F30663683BD63E2F68C8FA5C", hash_generated_method = "D88ABDF800AED8570127235CDED5295D")
    private void onToggleSoftInput(int showFlags, int hideFlags) {
        {
            boolean var257AAF3411A7EBF3C3725C7C8F2C478F_762833302 = (isInputViewShown());
            {
                requestHideSelf(hideFlags);
            } //End block
            {
                requestShowSelf(showFlags);
            } //End block
        } //End collapsed parenthetic
        addTaint(showFlags);
        addTaint(hideFlags);
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "toggleSoftInput()");
        //if (isInputViewShown()) {
            //requestHideSelf(hideFlags);
        //} else {
            //requestShowSelf(showFlags);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.936 -0400", hash_original_method = "9C1F09BC7693D3503A84F47A8DD2E9B8", hash_generated_method = "C1A7F24B63EEA2C9DE27CD969792EB87")
     void reportExtractedMovement(int keyCode, int count) {
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
        addTaint(keyCode);
        addTaint(count);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.950 -0400", hash_original_method = "CADA6E3534C513A6E5A0D2EB184E3B48", hash_generated_method = "E19FBAE86A1B44C938CBCC70D3452526")
     boolean doMovementKey(int keyCode, KeyEvent event, int count) {
        ExtractEditText eet;
        eet = mExtractEditText;
        {
            boolean var94228B74C2263F815EDE31A941CF869D_291848947 = (isExtractViewShown() && isInputViewShown() && eet != null);
            {
                MovementMethod movement;
                movement = eet.getMovementMethod();
                Layout layout;
                layout = eet.getLayout();
                {
                    {
                        {
                            boolean var963C81CEB3E2936CF5F881BEB18A9EC6_485009453 = (movement.onKeyDown(eet,
                            (Spannable)eet.getText(), keyCode, event));
                            {
                                reportExtractedMovement(keyCode, 1);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        {
                            boolean varDB98AC32177DBB5E1C8506FFA61B86E0_136181753 = (movement.onKeyUp(eet,
                            (Spannable)eet.getText(), keyCode, event));
                        } //End collapsed parenthetic
                    } //End block
                    {
                        {
                            boolean var498F283C3C6269EC555383DEA743554E_259301804 = (movement.onKeyOther(eet, (Spannable)eet.getText(), event));
                            {
                                reportExtractedMovement(keyCode, count);
                            } //End block
                            {
                                KeyEvent down;
                                down = KeyEvent.changeAction(event, KeyEvent.ACTION_DOWN);
                                {
                                    boolean varD21AC42920869AC37E02C57F302DAAF5_225117940 = (movement.onKeyDown(eet,
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
        addTaint(keyCode);
        addTaint(event.getTaint());
        addTaint(count);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_235928027 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_235928027;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.973 -0400", hash_original_method = "79E896FD8459E186D0AA684976DF9590", hash_generated_method = "743B72FA7AAACDBD4E3F3D1C6FA8EAAF")
    public void sendDownUpKeyEvents(int keyEventCode) {
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
        addTaint(keyEventCode);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.991 -0400", hash_original_method = "84DA6B1414DFECBCA6744FD6285B6A00", hash_generated_method = "FFC80344A99182F5F5533C3026CF3BC1")
    public boolean sendDefaultEditorAction(boolean fromEnterKey) {
        EditorInfo ei;
        ei = getCurrentInputEditorInfo();
        {
            InputConnection ic;
            ic = getCurrentInputConnection();
            {
                ic.performEditorAction(ei.imeOptions&EditorInfo.IME_MASK_ACTION);
            } //End block
        } //End block
        addTaint(fromEnterKey);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_749533522 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_749533522;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.003 -0400", hash_original_method = "CB96ACC643B76CE6B3516B92D9424351", hash_generated_method = "9DAFAD8D2DD86A2F0BA28E6CC8CF8D81")
    public void sendKeyChar(char charCode) {
        //Begin case '\n' 
        {
            boolean var7FAAA40E562A94AE6D757E1CEC431AF1_176752280 = (!sendDefaultEditorAction(true));
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
        addTaint(charCode);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.005 -0400", hash_original_method = "B848FD2302E48E43854FF3AB55ABE7CC", hash_generated_method = "87B5FC8E1AE262BC8D5F0126D2A653A4")
    public void onExtractedSelectionChanged(int start, int end) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        InputConnection conn;
        conn = getCurrentInputConnection();
        {
            conn.setSelection(start, end);
        } //End block
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
        //InputConnection conn = getCurrentInputConnection();
        //if (conn != null) {
            //conn.setSelection(start, end);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.006 -0400", hash_original_method = "56B9FB82082DF66D8709DA9479270344", hash_generated_method = "8F4D9A7954E23166A636ACF9EAFC3F1F")
    public void onExtractedDeleteText(int start, int end) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        InputConnection conn;
        conn = getCurrentInputConnection();
        {
            conn.setSelection(start, start);
            conn.deleteSurroundingText(0, end-start);
        } //End block
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
        //InputConnection conn = getCurrentInputConnection();
        //if (conn != null) {
            //conn.setSelection(start, start);
            //conn.deleteSurroundingText(0, end-start);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.011 -0400", hash_original_method = "3752CFC0704EAA41A71F5FCC4C7F691D", hash_generated_method = "3C18BEB8D0CB0F1256244F9125183738")
    public void onExtractedReplaceText(int start, int end, CharSequence text) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        InputConnection conn;
        conn = getCurrentInputConnection();
        {
            conn.setComposingRegion(start, end);
            conn.commitText(text, 1);
        } //End block
        addTaint(start);
        addTaint(end);
        addTaint(text.getTaint());
        // ---------- Original Method ----------
        //InputConnection conn = getCurrentInputConnection();
        //if (conn != null) {
            //conn.setComposingRegion(start, end);
            //conn.commitText(text, 1);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.013 -0400", hash_original_method = "2386EADCDB176594EC064F3F20DE5D60", hash_generated_method = "8099058A82B1B47F75BF9E228AAF9DB3")
    public void onExtractedSetSpan(Object span, int start, int end, int flags) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        InputConnection conn;
        conn = getCurrentInputConnection();
        {
            {
                boolean varD960B03B483BFF53BB8B9F9042E2BA47_265997385 = (!conn.setSelection(start, end));
            } //End collapsed parenthetic
            CharSequence text;
            text = conn.getSelectedText(InputConnection.GET_TEXT_WITH_STYLES);
            {
                ((Spannable) text).setSpan(span, 0, text.length(), flags);
                conn.setComposingRegion(start, end);
                conn.commitText(text, 1);
            } //End block
        } //End block
        addTaint(span.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(flags);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.031 -0400", hash_original_method = "672EAF0A2CC265CDC19E0FE05714B327", hash_generated_method = "C5AE2F8BD6AC2BDD9A5B982E21EF1D04")
    public void onExtractedTextClicked() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varA215564B7B15BCB949555AE2A66D446A_757652722 = (mExtractEditText.hasVerticalScrollBar());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.041 -0400", hash_original_method = "33B88CC3E792B5DBD4A2FEF9CD5D26B5", hash_generated_method = "82606CDFDDE01C6687E67C96C2439E18")
    public void onExtractedCursorMovement(int dx, int dy) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varA215564B7B15BCB949555AE2A66D446A_795591221 = (mExtractEditText.hasVerticalScrollBar());
            {
                setCandidatesViewShown(false);
            } //End block
        } //End collapsed parenthetic
        addTaint(dx);
        addTaint(dy);
        // ---------- Original Method ----------
        //if (mExtractEditText == null || dy == 0) {
            //return;
        //}
        //if (mExtractEditText.hasVerticalScrollBar()) {
            //setCandidatesViewShown(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.055 -0400", hash_original_method = "FA4A3D7B1537F03835F5D4F28B4BC905", hash_generated_method = "5389AA9F336757922BAFBE8164940C95")
    public boolean onExtractTextContextMenuItem(int id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        InputConnection ic;
        ic = getCurrentInputConnection();
        {
            ic.performContextMenuAction(id);
        } //End block
        addTaint(id);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_529198183 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_529198183;
        // ---------- Original Method ----------
        //InputConnection ic = getCurrentInputConnection();
        //if (ic != null) {
            //ic.performContextMenuAction(id);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.067 -0400", hash_original_method = "9F91BE1CB3CE4671D110A2B57AE2570E", hash_generated_method = "E8C2A0ECE1EEC66AFFA9AD948B28B26B")
    public CharSequence getTextForImeAction(int imeOptions) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1417161168 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2087505746 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1064152986 = null; //Variable for return #3
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1129549477 = null; //Variable for return #4
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1684273019 = null; //Variable for return #5
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1085001157 = null; //Variable for return #6
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_176396655 = null; //Variable for return #7
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_7585616 = null; //Variable for return #8
        //Begin case EditorInfo.IME_ACTION_NONE 
        varB4EAC82CA7396A68D541C85D26508E83_1417161168 = null;
        //End case EditorInfo.IME_ACTION_NONE 
        //Begin case EditorInfo.IME_ACTION_GO 
        varB4EAC82CA7396A68D541C85D26508E83_2087505746 = getText(com.android.internal.R.string.ime_action_go);
        //End case EditorInfo.IME_ACTION_GO 
        //Begin case EditorInfo.IME_ACTION_SEARCH 
        varB4EAC82CA7396A68D541C85D26508E83_1064152986 = getText(com.android.internal.R.string.ime_action_search);
        //End case EditorInfo.IME_ACTION_SEARCH 
        //Begin case EditorInfo.IME_ACTION_SEND 
        varB4EAC82CA7396A68D541C85D26508E83_1129549477 = getText(com.android.internal.R.string.ime_action_send);
        //End case EditorInfo.IME_ACTION_SEND 
        //Begin case EditorInfo.IME_ACTION_NEXT 
        varB4EAC82CA7396A68D541C85D26508E83_1684273019 = getText(com.android.internal.R.string.ime_action_next);
        //End case EditorInfo.IME_ACTION_NEXT 
        //Begin case EditorInfo.IME_ACTION_DONE 
        varB4EAC82CA7396A68D541C85D26508E83_1085001157 = getText(com.android.internal.R.string.ime_action_done);
        //End case EditorInfo.IME_ACTION_DONE 
        //Begin case EditorInfo.IME_ACTION_PREVIOUS 
        varB4EAC82CA7396A68D541C85D26508E83_176396655 = getText(com.android.internal.R.string.ime_action_previous);
        //End case EditorInfo.IME_ACTION_PREVIOUS 
        //Begin case default 
        varB4EAC82CA7396A68D541C85D26508E83_7585616 = getText(com.android.internal.R.string.ime_action_default);
        //End case default 
        addTaint(imeOptions);
        CharSequence varA7E53CE21691AB073D9660D615818899_1342712951; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1342712951 = varB4EAC82CA7396A68D541C85D26508E83_1417161168;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1342712951 = varB4EAC82CA7396A68D541C85D26508E83_2087505746;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1342712951 = varB4EAC82CA7396A68D541C85D26508E83_1064152986;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1342712951 = varB4EAC82CA7396A68D541C85D26508E83_1129549477;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1342712951 = varB4EAC82CA7396A68D541C85D26508E83_1684273019;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1342712951 = varB4EAC82CA7396A68D541C85D26508E83_1085001157;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_1342712951 = varB4EAC82CA7396A68D541C85D26508E83_176396655;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1342712951 = varB4EAC82CA7396A68D541C85D26508E83_7585616;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1342712951.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1342712951;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.068 -0400", hash_original_method = "8796655A783A46466BACE236BCA7DD97", hash_generated_method = "6238B41A7B5435B0D9D8E8F7CADDE18D")
    public void onUpdateExtractingVisibility(EditorInfo ei) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            setExtractViewShown(false);
        } //End block
        setExtractViewShown(true);
        addTaint(ei.getTaint());
        // ---------- Original Method ----------
        //if (ei.inputType == InputType.TYPE_NULL ||
                //(ei.imeOptions&EditorInfo.IME_FLAG_NO_EXTRACT_UI) != 0) {
            //setExtractViewShown(false);
            //return;
        //}
        //setExtractViewShown(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.070 -0400", hash_original_method = "EAD47E132E9ECD3692FAA5C1AB9CEE12", hash_generated_method = "FF79C762A537DF10304E5089DC0DF006")
    public void onUpdateExtractingViews(EditorInfo ei) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var87F8135436C414A49235B50C0BEE24F1_633202988 = (!isExtractViewShown());
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
        addTaint(ei.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.074 -0400", hash_original_method = "B8550D5274B7AC063AD577912E9B5BF9", hash_generated_method = "0FFAAF964485579153E2E3988A3EE39A")
    public void onExtractingInputChanged(EditorInfo ei) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            requestHideSelf(InputMethodManager.HIDE_NOT_ALWAYS);
        } //End block
        addTaint(ei.getTaint());
        // ---------- Original Method ----------
        //if (ei.inputType == InputType.TYPE_NULL) {
            //requestHideSelf(InputMethodManager.HIDE_NOT_ALWAYS);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.099 -0400", hash_original_method = "4C67EC88DE5F38ABAC11BF6FC64666D8", hash_generated_method = "E8DCFA603F7C89B70B13AF69BFA4163D")
     void startExtractingText(boolean inputChanged) {
        ExtractEditText eet;
        eet = mExtractEditText;
        {
            boolean var4B45048747F7E34CB0EFEC67D57A6FDB_1228110464 = (eet != null && getCurrentInputStarted()
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
        addTaint(inputChanged);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.100 -0400", hash_original_method = "18DCEDE4996E63CB2DB494AAC7CE4961", hash_generated_method = "F3A10FF54ED27FE06FB651085D88A314")
    protected void onCurrentInputMethodSubtypeChanged(InputMethodSubtype newSubtype) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
        addTaint(newSubtype.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.149 -0400", hash_original_method = "ABDAB14391C840F473C7CB9BB20D3C33", hash_generated_method = "E06AAD0BB6B15136ECA82DA430CB77F9")
    @Override
    protected void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
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
        addTaint(fd.getTaint());
        addTaint(fout.getTaint());
        addTaint(args[0].getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public class InputMethodImpl extends AbstractInputMethodImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.150 -0400", hash_original_method = "F0421074EFC32AA5D8F43C6593C3D141", hash_generated_method = "F0421074EFC32AA5D8F43C6593C3D141")
        public InputMethodImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.151 -0400", hash_original_method = "2246D0F0FC59D2518EAEE0F0671903AA", hash_generated_method = "A51CC7CD13A1E9A36365BA401FA778B0")
        public void attachToken(IBinder token) {
            {
                mToken = token;
                mWindow.setToken(token);
            } //End block
            addTaint(token.getTaint());
            // ---------- Original Method ----------
            //if (mToken == null) {
                //mToken = token;
                //mWindow.setToken(token);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.156 -0400", hash_original_method = "96E89AA7F2E1A70ABC64DBDE36024534", hash_generated_method = "3335803F89E176A3D429610A50941D13")
        public void bindInput(InputBinding binding) {
            mInputBinding = binding;
            mInputConnection = binding.getConnection();
            InputConnection ic;
            ic = getCurrentInputConnection();
            ic.reportFullscreenMode(mIsFullscreen);
            initialize();
            onBindInput();
            addTaint(binding.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.158 -0400", hash_original_method = "5DFC78D3BA0A9E107E4BC0A877A8E6D3", hash_generated_method = "6B3CEDF4200C9C7C80218F8DD5B5F50D")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.180 -0400", hash_original_method = "ABB2165AD965E17C2FE21B1141C40C8F", hash_generated_method = "6AD7FD20C8DDACBEABA6596734A044AD")
        public void startInput(InputConnection ic, EditorInfo attribute) {
            doStartInput(ic, attribute, false);
            addTaint(ic.getTaint());
            addTaint(attribute.getTaint());
            // ---------- Original Method ----------
            //if (DEBUG) Log.v(TAG, "startInput(): editor=" + attribute);
            //doStartInput(ic, attribute, false);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.181 -0400", hash_original_method = "FBDDF384E0FE523BAEFE6359495BE0E1", hash_generated_method = "DD9B1A84FD0F4D6523FB95D732F7F0D1")
        public void restartInput(InputConnection ic, EditorInfo attribute) {
            doStartInput(ic, attribute, true);
            addTaint(ic.getTaint());
            addTaint(attribute.getTaint());
            // ---------- Original Method ----------
            //if (DEBUG) Log.v(TAG, "restartInput(): editor=" + attribute);
            //doStartInput(ic, attribute, true);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.201 -0400", hash_original_method = "3A4CCDB7EB28BA706C897E348F128E61", hash_generated_method = "76C94D8C457A6B74BA588D77494BC0BD")
        public void hideSoftInput(int flags, ResultReceiver resultReceiver) {
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
            addTaint(flags);
            addTaint(resultReceiver.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.214 -0400", hash_original_method = "FA726B6A215F3C1D91F0883D01FD2750", hash_generated_method = "72EC28FB35A9D3E498C11CC2BEAF1EC0")
        public void showSoftInput(int flags, ResultReceiver resultReceiver) {
            boolean wasVis;
            wasVis = isInputViewShown();
            mShowInputFlags = 0;
            {
                boolean var0345BB707617653FF624969C451A707D_1962233665 = (onShowInputRequested(flags, false));
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
            addTaint(flags);
            addTaint(resultReceiver.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.215 -0400", hash_original_method = "A5FC41682DA51C285C2C6651867F8D99", hash_generated_method = "A16AAF9A841479641C6E964FA07E0985")
        public void changeInputMethodSubtype(InputMethodSubtype subtype) {
            onCurrentInputMethodSubtypeChanged(subtype);
            addTaint(subtype.getTaint());
            // ---------- Original Method ----------
            //onCurrentInputMethodSubtypeChanged(subtype);
        }

        
    }


    
    public class InputMethodSessionImpl extends AbstractInputMethodSessionImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.215 -0400", hash_original_method = "0FFA9D5BB925C1ECDC26428126FD587D", hash_generated_method = "0FFA9D5BB925C1ECDC26428126FD587D")
        public InputMethodSessionImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.216 -0400", hash_original_method = "3439BC8F3B3DD615353E38FBC0555505", hash_generated_method = "1975D3D1494831612B3638EAD9790DD5")
        public void finishInput() {
            {
                boolean varC3AD07CBBFDAC9CFAEE0700F705E9164_1730452161 = (!isEnabled());
            } //End collapsed parenthetic
            doFinishInput();
            // ---------- Original Method ----------
            //if (!isEnabled()) {
                //return;
            //}
            //if (DEBUG) Log.v(TAG, "finishInput() in " + this);
            //doFinishInput();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.217 -0400", hash_original_method = "6A0353E151F9F29333A27C5421A53B38", hash_generated_method = "957F7DEFEE989D0657475DBD750EFC63")
        public void displayCompletions(CompletionInfo[] completions) {
            {
                boolean varC3AD07CBBFDAC9CFAEE0700F705E9164_149065378 = (!isEnabled());
            } //End collapsed parenthetic
            mCurCompletions = completions;
            onDisplayCompletions(completions);
            addTaint(completions[0].getTaint());
            // ---------- Original Method ----------
            //if (!isEnabled()) {
                //return;
            //}
            //mCurCompletions = completions;
            //onDisplayCompletions(completions);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.220 -0400", hash_original_method = "0102DD0EEEDCD27552C577307A27FE88", hash_generated_method = "D116C3C4981B3A6B4BB80DD8DF9AF9FE")
        public void updateExtractedText(int token, ExtractedText text) {
            {
                boolean varC3AD07CBBFDAC9CFAEE0700F705E9164_1271218802 = (!isEnabled());
            } //End collapsed parenthetic
            onUpdateExtractedText(token, text);
            addTaint(token);
            addTaint(text.getTaint());
            // ---------- Original Method ----------
            //if (!isEnabled()) {
                //return;
            //}
            //onUpdateExtractedText(token, text);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.221 -0400", hash_original_method = "8EA462F0F0CF12CBAE81AB6E28205A3D", hash_generated_method = "F94D3DE36D2363F09E95DCA172A83865")
        public void updateSelection(int oldSelStart, int oldSelEnd,
                int newSelStart, int newSelEnd,
                int candidatesStart, int candidatesEnd) {
            {
                boolean varC3AD07CBBFDAC9CFAEE0700F705E9164_1736141368 = (!isEnabled());
            } //End collapsed parenthetic
            InputMethodService.this.onUpdateSelection(oldSelStart, oldSelEnd,
                    newSelStart, newSelEnd, candidatesStart, candidatesEnd);
            addTaint(oldSelStart);
            addTaint(oldSelEnd);
            addTaint(newSelStart);
            addTaint(newSelEnd);
            addTaint(candidatesStart);
            addTaint(candidatesEnd);
            // ---------- Original Method ----------
            //if (!isEnabled()) {
                //return;
            //}
            //InputMethodService.this.onUpdateSelection(oldSelStart, oldSelEnd,
                    //newSelStart, newSelEnd, candidatesStart, candidatesEnd);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.251 -0400", hash_original_method = "7D0F3CDF004B0AA88B105A90C3B2EFF2", hash_generated_method = "DFA8AF57A3F5FEF7853C4F93C3B4E641")
        @Override
        public void viewClicked(boolean focusChanged) {
            {
                boolean varC3AD07CBBFDAC9CFAEE0700F705E9164_1922293811 = (!isEnabled());
            } //End collapsed parenthetic
            InputMethodService.this.onViewClicked(focusChanged);
            addTaint(focusChanged);
            // ---------- Original Method ----------
            //if (!isEnabled()) {
                //return;
            //}
            //InputMethodService.this.onViewClicked(focusChanged);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.252 -0400", hash_original_method = "5A756230FCCA173B557966360DF4EF77", hash_generated_method = "0AF72723634D1EC52D1CFC92AAB0CE8F")
        public void updateCursor(Rect newCursor) {
            {
                boolean varC3AD07CBBFDAC9CFAEE0700F705E9164_433995303 = (!isEnabled());
            } //End collapsed parenthetic
            InputMethodService.this.onUpdateCursor(newCursor);
            addTaint(newCursor.getTaint());
            // ---------- Original Method ----------
            //if (!isEnabled()) {
                //return;
            //}
            //InputMethodService.this.onUpdateCursor(newCursor);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.254 -0400", hash_original_method = "681E840BDEA7B80F2F006F7D9B6B3563", hash_generated_method = "97794C55417C05A55C42061A20A11723")
        public void appPrivateCommand(String action, Bundle data) {
            {
                boolean varC3AD07CBBFDAC9CFAEE0700F705E9164_1133587619 = (!isEnabled());
            } //End collapsed parenthetic
            InputMethodService.this.onAppPrivateCommand(action, data);
            addTaint(action.getTaint());
            addTaint(data.getTaint());
            // ---------- Original Method ----------
            //if (!isEnabled()) {
                //return;
            //}
            //InputMethodService.this.onAppPrivateCommand(action, data);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.255 -0400", hash_original_method = "F1C4F6A09FBC1E433445388BE149C06F", hash_generated_method = "930D3ACC499E481F5AC897BB0703F898")
        public void toggleSoftInput(int showFlags, int hideFlags) {
            InputMethodService.this.onToggleSoftInput(showFlags, hideFlags);
            addTaint(showFlags);
            addTaint(hideFlags);
            // ---------- Original Method ----------
            //InputMethodService.this.onToggleSoftInput(showFlags, hideFlags);
        }

        
    }


    
    public static final class Insets {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.255 -0400", hash_original_field = "6B844646D0C6EADB76028E296D97D26E", hash_generated_field = "0848E8A3B2603B51400EBA2544607CD8")

        public int contentTopInsets;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.258 -0400", hash_original_field = "A2E8AB53B3DDAFAA3E389A47908EE03A", hash_generated_field = "4E5B62BB5E3FD9065410077ABCEFD6F5")

        public int visibleTopInsets;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.259 -0400", hash_original_field = "5CC4EAB992E3E01BAE580BFE4B7ACFD9", hash_generated_field = "F31B38C680C4D4319AF069970A80B1D9")

        public Region touchableRegion = new Region();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.259 -0400", hash_original_field = "FB0951D59D942FF6CA5CA9E62DD65AED", hash_generated_field = "70DA720827DA3605384693EAE5E21AF8")

        public int touchableInsets;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.259 -0400", hash_original_method = "AB0F14C8125953D4D984387CD9B8D05E", hash_generated_method = "AB0F14C8125953D4D984387CD9B8D05E")
        public Insets ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.259 -0400", hash_original_field = "A2BD6A2D2FAE4B0F2A6389403948A9DB", hash_generated_field = "A903B8D9E85FE8268399FAA8EA9A5E31")

        public static final int TOUCHABLE_INSETS_FRAME
                = ViewTreeObserver.InternalInsetsInfo.TOUCHABLE_INSETS_FRAME;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.259 -0400", hash_original_field = "A5CDA3247D70BA69B10B6C0010FDC255", hash_generated_field = "16D23B51E9664EA10F8919E161911777")

        public static final int TOUCHABLE_INSETS_CONTENT
                = ViewTreeObserver.InternalInsetsInfo.TOUCHABLE_INSETS_CONTENT;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.259 -0400", hash_original_field = "838E61A62623937065E74D6492529D84", hash_generated_field = "CFCF2141909DD954AF9ECFE0CCA49151")

        public static final int TOUCHABLE_INSETS_VISIBLE
                = ViewTreeObserver.InternalInsetsInfo.TOUCHABLE_INSETS_VISIBLE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.260 -0400", hash_original_field = "76E5A63ED3A610EE6AB6EB3A21422CFD", hash_generated_field = "2D48D24763A14D18AF2E1A2EBFB364B0")

        public static final int TOUCHABLE_INSETS_REGION
                = ViewTreeObserver.InternalInsetsInfo.TOUCHABLE_INSETS_REGION;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.260 -0400", hash_original_field = "4C210C59F731B7259273CB52E6EAB487", hash_generated_field = "0BAD7290314E160F5C1B9295CF802F47")

    static String TAG = "InputMethodService";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.260 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "99DFF1318F5BF79C590B7B00A696225C")

    static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.260 -0400", hash_original_field = "2C29A4B5619C3A910834AA526BCE13BA", hash_generated_field = "4162B60B07B580ECBA3A261DC0CE993C")

    public static final int BACK_DISPOSITION_DEFAULT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.260 -0400", hash_original_field = "97E64829EE19D1C26581E470E551F6F1", hash_generated_field = "5EE67BE6E8CA7600A488D83901D53781")

    public static final int BACK_DISPOSITION_WILL_NOT_DISMISS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.260 -0400", hash_original_field = "203C7BC5EBC13AD8BC33775F4404CC44", hash_generated_field = "1CE0B7C8A6A795BBDBCCD6070E9E96CA")

    public static final int BACK_DISPOSITION_WILL_DISMISS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.260 -0400", hash_original_field = "0DDE1628212000DAF18C459BAEF81192", hash_generated_field = "911D20D022B12D5BDC027B47C99E815F")

    public static final int IME_ACTIVE = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.260 -0400", hash_original_field = "D1ECF6CE3C86B3EDFDFFA575C6C38827", hash_generated_field = "54453599413B853A6378E68D3D2217C5")

    public static final int IME_VISIBLE = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.260 -0400", hash_original_field = "F851B83995A9D4F3E431A958CAF5A8BE", hash_generated_field = "064FB601B903A00E51147D238E475961")

    static int MOVEMENT_DOWN = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.261 -0400", hash_original_field = "E702B70F996310DE47359709E5994159", hash_generated_field = "76CE82B281E21759DD4DD073C3A2E31B")

    static int MOVEMENT_UP = -2;
}

