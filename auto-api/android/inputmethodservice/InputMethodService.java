package android.inputmethodservice;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.798 -0400", hash_original_field = "47E3DC1D02320FF11860FCA10E93021A", hash_generated_field = "01719032B78A2D912F910E37CD479B69")

    InputMethodManager mImm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.798 -0400", hash_original_field = "9C44372B6B78B59807C8DF03A1965EF9", hash_generated_field = "075FD7AAD50C5AD8803D9E3B208423A2")

    int mTheme = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.798 -0400", hash_original_field = "D03597FDEDE23F3823480E0520822BB2", hash_generated_field = "B03B4DAE3F576B7166425BEE37B96C5E")

    LayoutInflater mInflater;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.798 -0400", hash_original_field = "51146EF3EA2889FD9B2525C6E53C7975", hash_generated_field = "B7C98FA3B531CC028C7A59F94DC2AFFF")

    TypedArray mThemeAttrs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.798 -0400", hash_original_field = "03503F4E2878305C59038D192AB3AC15", hash_generated_field = "6D0C26C611FBD233667A9FA9104CED21")

    View mRootView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.798 -0400", hash_original_field = "F4214BE1FFE044F8CA79EEDDDED72016", hash_generated_field = "507E6EFA97CB0E77FA79A4D01B3ED4A3")

    SoftInputWindow mWindow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.798 -0400", hash_original_field = "57006E58594DC862E67D1855FDF16FEE", hash_generated_field = "C9E05499054E8056F0A4805D1295DEC9")

    boolean mInitialized;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.798 -0400", hash_original_field = "C0D2E2C93F79DA8713BDE478E1537ED0", hash_generated_field = "FE6B5FDA79102585E4703AA7755D8A1D")

    boolean mWindowCreated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.798 -0400", hash_original_field = "86E4FECD64C3696106A1C2B8A242AA04", hash_generated_field = "218C970370BBF49B29F07C78706BEE0F")

    boolean mWindowAdded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.798 -0400", hash_original_field = "F4BEAD71055EFB5C1D3AE1819E120D49", hash_generated_field = "71207F91BCFA87F10E39CE8F643F27A2")

    boolean mWindowVisible;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.798 -0400", hash_original_field = "90DB2BA0D89316B5F84014C89B3C5A49", hash_generated_field = "DC6F9BCE5EC968FD18904FAB6E1E26EA")

    boolean mWindowWasVisible;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.798 -0400", hash_original_field = "AA66B10DBD6B09095C3413E3E854E354", hash_generated_field = "393177CC055DA847245CCD680AD17E8C")

    boolean mInShowWindow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.798 -0400", hash_original_field = "FDFE1E462F69BA102A7B8F8BCFAC963E", hash_generated_field = "15182820025992AE750DB9E78ACD70F3")

    ViewGroup mFullscreenArea;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.798 -0400", hash_original_field = "3A05208DCCF4A0B7E79ED0C5D037E06F", hash_generated_field = "13D1A7834031B0B293BDFE378DF08473")

    FrameLayout mExtractFrame;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.798 -0400", hash_original_field = "560899D96824DB522510CBBACE726143", hash_generated_field = "E6B39B5292209EE43935C8AAB586E41A")

    FrameLayout mCandidatesFrame;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.798 -0400", hash_original_field = "E71070589690CB7B22255920EF5417C2", hash_generated_field = "8060C3896FC8C6EEC2A4B224AC19B8A5")

    FrameLayout mInputFrame;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.798 -0400", hash_original_field = "98E8D2ECD335C543A384E2B940159AF2", hash_generated_field = "DD6EB7EC256F1225D4C6DC1A42FB765B")

    IBinder mToken;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.798 -0400", hash_original_field = "023A158D0015238EFA1E574793716DF1", hash_generated_field = "AFA59EA1150C21AB6E344984735AF2EB")

    InputBinding mInputBinding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.798 -0400", hash_original_field = "A2D010B7C3546462A260EC1C5E1ED4C6", hash_generated_field = "0C4E3C3C223DA7FB43EF5D532A5B3E04")

    InputConnection mInputConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.798 -0400", hash_original_field = "782D39EBDAC05F2DB212AB8342884C64", hash_generated_field = "D15B1F449CE3CDE14A0008B2465EE7E3")

    boolean mInputStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.798 -0400", hash_original_field = "997F4B1392777ED6D28F46C5D817E4B7", hash_generated_field = "514EB139852D82B47A3950B6F3E19CF6")

    boolean mInputViewStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.798 -0400", hash_original_field = "000D18FCF61C40AD69E3E56BEB71A5A6", hash_generated_field = "4626543A6FCF1F8B8B73D10B97975D09")

    boolean mCandidatesViewStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.799 -0400", hash_original_field = "90E29B0FBB7D81AF12FD516A1C18EE0A", hash_generated_field = "60FF159378B9E2B6E495E1B7233D3981")

    InputConnection mStartedInputConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.799 -0400", hash_original_field = "EDB1ADCF132EE49252AA404EA0C42BDC", hash_generated_field = "0A7D4D3889811FF61BF27942BE846641")

    EditorInfo mInputEditorInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.799 -0400", hash_original_field = "9B0BEB2912C7407E921A6905D7C94F4B", hash_generated_field = "293541479A1626BCDA923AA8063FA9A6")

    int mShowInputFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.799 -0400", hash_original_field = "3130E5E55A7C8BB928012D0F32C408DB", hash_generated_field = "7599FBE37A9716825A76F29F0FE2FD55")

    boolean mShowInputRequested;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.799 -0400", hash_original_field = "E059488A4BAF82E3EB1514BBEF6A5C04", hash_generated_field = "46B9F45DD04B32BAA4E84977F39214E7")

    boolean mLastShowInputRequested;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.799 -0400", hash_original_field = "22665F4551D5A5EC46B2D94EDA2C4B99", hash_generated_field = "A9B119877C3EB8E978CAEECF1D6BD14B")

    int mCandidatesVisibility;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.799 -0400", hash_original_field = "C0ED2CFA44D0D69EEA23C8E4C66CE227", hash_generated_field = "497159238D66DB93A282D483EC1CA3AC")

    CompletionInfo[] mCurCompletions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.799 -0400", hash_original_field = "27CC66322143CE51D330735DF962162F", hash_generated_field = "0A08F53EED6C8EEC9D7CC85E98FAC447")

    boolean mShowInputForced;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.799 -0400", hash_original_field = "0FD506CFFBAF2760EA3C8C7A61A1EC34", hash_generated_field = "269508F0F9EF09EB866044C649D586B1")

    boolean mFullscreenApplied;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.799 -0400", hash_original_field = "54AB7B409DAEC84F47F83754E82B9CF7", hash_generated_field = "9CA62515CAD4DE9A3596FC712B0811BA")

    boolean mIsFullscreen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.799 -0400", hash_original_field = "A1FE7A1C3E639FA004091CB9A1C3BADC", hash_generated_field = "77749D3AEC38C02813E052F85601DCFE")

    View mExtractView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.799 -0400", hash_original_field = "63BD8F8E7390940615BF50D62ABA7B61", hash_generated_field = "41C2A191F101A74E110D9728B296F375")

    boolean mExtractViewHidden;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.799 -0400", hash_original_field = "DF23DA4699300FCC03743118373EEB29", hash_generated_field = "10C7C27B9EFB4B449D020D2FD7D681C8")

    ExtractEditText mExtractEditText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.799 -0400", hash_original_field = "D3312E3FB49BA27FC912A51A3BE0EB28", hash_generated_field = "49FE9D4C4E2B1ED741DB08F3BECEA464")

    ViewGroup mExtractAccessories;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.799 -0400", hash_original_field = "0EC10097C9F7737C7F02A1274F00634D", hash_generated_field = "4EF514D7B6A680A68FB4FA03A08F5D2D")

    Button mExtractAction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.799 -0400", hash_original_field = "A034AA34A307E777C43933E669A375DC", hash_generated_field = "7C5C99560AB4918E13830D06100AC03C")

    ExtractedText mExtractedText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.799 -0400", hash_original_field = "3B05C3A55FB18FD1556EDCEA83357EA4", hash_generated_field = "E322EFE9A47EF352CC52DE566A5DCA94")

    int mExtractedToken;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.799 -0400", hash_original_field = "CC1A335F32158BD1BD949E24E11AE1DC", hash_generated_field = "DD75F3DC122E5FCA3B30C64DE9D6C9CD")

    View mInputView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.799 -0400", hash_original_field = "05E05DFE926C9F572FDAAECF32DC796C", hash_generated_field = "77B5EB3473D5B10089CC95C2ED94891E")

    boolean mIsInputViewShown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.799 -0400", hash_original_field = "1C10330016E3D1BDEB192DB6D2AE8892", hash_generated_field = "98EF9B06A59A7DC308ADD81484067F39")

    int mStatusIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.799 -0400", hash_original_field = "269EBC9196383CF7ED8E2C7FC1F02A76", hash_generated_field = "FD8B0612F7004ABC6C691A56C2D256FE")

    int mBackDisposition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.799 -0400", hash_original_field = "FA246E03DDB3F75A905A719A7A70B1A3", hash_generated_field = "F25E6A5ACF83E487D08AEE0325304099")

    final Insets mTmpInsets = new Insets();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.799 -0400", hash_original_field = "4BC786D43E92B4BEDC23ACC8C07672C0", hash_generated_field = "192CBA0F154C36DD2A24DDE2AD97DD40")

    final int[] mTmpLocation = new int[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.800 -0400", hash_original_field = "142F5B53CE3CC0CB3C0E6D7392FA4726", hash_generated_field = "9D9565E91A7FEF8950C3A14F9D3149EC")

    final ViewTreeObserver.OnComputeInternalInsetsListener mInsetsComputer = new ViewTreeObserver.OnComputeInternalInsetsListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.800 -0400", hash_original_method = "3A80214106299C195F4E4A04B9DB62AA", hash_generated_method = "4D6CFA468B0FC825A18D2D61E083253E")
        public void onComputeInternalInsets(ViewTreeObserver.InternalInsetsInfo info) {
            
            {
                boolean var1E9E12E1C314AB48D78EC2186631F908_497923133 = (isExtractViewShown());
                {
                    View decor = getWindow().getWindow().getDecorView();
                    info.contentInsets.top = info.visibleInsets.top
                        = decor.getHeight();
                    info.touchableRegion.setEmpty();
                    info.setTouchableInsets(ViewTreeObserver.InternalInsetsInfo.TOUCHABLE_INSETS_FRAME);
                } 
                {
                    onComputeInsets(mTmpInsets);
                    info.contentInsets.top = mTmpInsets.contentTopInsets;
                    info.visibleInsets.top = mTmpInsets.visibleTopInsets;
                    info.touchableRegion.set(mTmpInsets.touchableRegion);
                    info.setTouchableInsets(mTmpInsets.touchableInsets);
                } 
            } 
            addTaint(info.getTaint());
            
            
                
                
                        
                
                
            
                
                
                
                
                
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.801 -0400", hash_original_field = "C94A4138F2315FEEC71C08F04887EF50", hash_generated_field = "637074E4948BB4D273503B0842435434")

    final View.OnClickListener mActionClickListener = new View.OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.801 -0400", hash_original_method = "F78C13955980C6EBFBCB4858D6B59E8E", hash_generated_method = "452C45D9980B5EA2C69EA15855896959")
        public void onClick(View v) {
            
            final EditorInfo ei = getCurrentInputEditorInfo();
            final InputConnection ic = getCurrentInputConnection();
            {
                {
                    ic.performEditorAction(ei.actionId);
                } 
                {
                    ic.performEditorAction(ei.imeOptions&EditorInfo.IME_MASK_ACTION);
                } 
            } 
            addTaint(v.getTaint());
            
            
            
            
                
                    
                
                        
                    
                
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.801 -0400", hash_original_method = "1525492D8EE98BBF3E2138610F838AAF", hash_generated_method = "1525492D8EE98BBF3E2138610F838AAF")
    public InputMethodService ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.802 -0400", hash_original_method = "A950397745137F47AE3797B428EC17A0", hash_generated_method = "83B58C51650A0D9F086F4FB4DFABB584")
    @Override
    public void setTheme(int theme) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Must be called before onCreate()");
        } 
        mTheme = theme;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.802 -0400", hash_original_method = "A4061C51E6B315B625647A4DAEF1D932", hash_generated_method = "DE550ABE012B963890E5EA21805F7878")
    @Override
    public void onCreate() {
        
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
        
        
                
                
                
                
        
        
        
        
                
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.804 -0400", hash_original_method = "76EDD2B848D79265B59C656C09132FEB", hash_generated_method = "83EE169EF2FBBDAF4C6A06E84EF30B78")
    public void onInitializeInterface() {
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.804 -0400", hash_original_method = "F1A6BBC586CE4C5158D93D758F9EE4FD", hash_generated_method = "7C63C721EAC547413CE5708A1F496E22")
     void initialize() {
        {
            mInitialized = true;
            onInitializeInterface();
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.805 -0400", hash_original_method = "E6A2B0DBCD46A23062A8849E041DB211", hash_generated_method = "53FA4FD74B5AF584B0878762CB88EFFB")
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
            boolean var42B91C3FC5E7160C1292C676D44C7C35_1203351617 = (Settings.System.getInt(getContentResolver(),
                Settings.System.FANCY_IME_ANIMATIONS, 0) != 0);
            {
                mWindow.getWindow().setWindowAnimations(
                    com.android.internal.R.style.Animation_InputMethodFancy);
            } 
        } 
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
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.806 -0400", hash_original_method = "03BF0E4B83AB5EEC5EA04DACA2552646", hash_generated_method = "FED5ACC4025145E20089A53DCC14F84F")
    @Override
    public void onDestroy() {
        
        super.onDestroy();
        mRootView.getViewTreeObserver().removeOnComputeInternalInsetsListener(
                mInsetsComputer);
        finishViews();
        {
            mWindow.getWindow().setWindowAnimations(0);
            mWindow.dismiss();
        } 
        
        
        
                
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.806 -0400", hash_original_method = "0B7AD8CA788BAE093A6DAEC0C292F050", hash_generated_method = "FDB6176567DA712789EB96DBE7BC74C1")
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        
        super.onConfigurationChanged(newConfig);
        boolean visible = mWindowVisible;
        int showFlags = mShowInputFlags;
        boolean showingInput = mShowInputRequested;
        CompletionInfo[] completions = mCurCompletions;
        initViews();
        mInputViewStarted = false;
        mCandidatesViewStarted = false;
        {
            doStartInput(getCurrentInputConnection(),
                    getCurrentInputEditorInfo(), true);
        } 
        {
            {
                {
                    boolean varE76E4AD258BBF3AE36D8B1906DE05BFD_1172838077 = (onShowInputRequested(showFlags, true));
                    {
                        showWindow(true);
                        {
                            mCurCompletions = completions;
                            onDisplayCompletions(completions);
                        } 
                    } 
                    {
                        hideWindow();
                    } 
                } 
            } 
            {
                showWindow(false);
            } 
            {
                hideWindow();
            } 
            boolean showing = onEvaluateInputViewShown();
            mImm.setImeWindowStatus(mToken, IME_ACTIVE | (showing ? IME_VISIBLE : 0),
                    mBackDisposition);
        } 
        addTaint(newConfig.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.807 -0400", hash_original_method = "4C23D68F9AF6231E77018CB50F89B333", hash_generated_method = "D82C51158B4E26120A30C2C0FE764C82")
    @Override
    public AbstractInputMethodImpl onCreateInputMethodInterface() {
        
        AbstractInputMethodImpl varB4EAC82CA7396A68D541C85D26508E83_1295309994 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1295309994 = new InputMethodImpl();
        varB4EAC82CA7396A68D541C85D26508E83_1295309994.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1295309994;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.808 -0400", hash_original_method = "A293E788F38BE631F0B24DA3CBEC4EAD", hash_generated_method = "F9ACA9A7DBFC7D90F04B3CF009E4E4C7")
    @Override
    public AbstractInputMethodSessionImpl onCreateInputMethodSessionInterface() {
        
        AbstractInputMethodSessionImpl varB4EAC82CA7396A68D541C85D26508E83_1385651064 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1385651064 = new InputMethodSessionImpl();
        varB4EAC82CA7396A68D541C85D26508E83_1385651064.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1385651064;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.808 -0400", hash_original_method = "F107DE3A8547E443866FF02369203993", hash_generated_method = "8ADCBE3B48BCD1B7617670CE296EB904")
    public LayoutInflater getLayoutInflater() {
        LayoutInflater varB4EAC82CA7396A68D541C85D26508E83_1515384177 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1515384177 = mInflater;
        varB4EAC82CA7396A68D541C85D26508E83_1515384177.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1515384177;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.810 -0400", hash_original_method = "B35683FF457638BA2516208C83F2FBFC", hash_generated_method = "C093EAF53B8A265913ED51E570EE21D8")
    public Dialog getWindow() {
        Dialog varB4EAC82CA7396A68D541C85D26508E83_553326512 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_553326512 = mWindow;
        varB4EAC82CA7396A68D541C85D26508E83_553326512.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_553326512;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.814 -0400", hash_original_method = "4B38ED63C74A7D25A43EF42301FB70B0", hash_generated_method = "46A6C22207C263E445ACBEE325B9DE9D")
    public void setBackDisposition(int disposition) {
        mBackDisposition = disposition;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.815 -0400", hash_original_method = "FA0668AA74F2A3E40C75CD8A8BEC8D4A", hash_generated_method = "63E89147D48A4CFA4C76DF6DA4E6266B")
    public int getBackDisposition() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1087724259 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1087724259;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.815 -0400", hash_original_method = "BF0CCCE3A6DFBF869485401A0C0B52E1", hash_generated_method = "9BAC342CF34FE5399B36A7D20E8F8E3E")
    public int getMaxWidth() {
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        int var2277AEB58FD93D1A35DD1F32A4E8EB14_1189127496 = (wm.getDefaultDisplay().getWidth());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1430725310 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1430725310;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.816 -0400", hash_original_method = "064CBE2A131D4B226EADDD6A40CEAEED", hash_generated_method = "99B32E14519E887523ED4555B3A5B1DA")
    public InputBinding getCurrentInputBinding() {
        InputBinding varB4EAC82CA7396A68D541C85D26508E83_107482753 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_107482753 = mInputBinding;
        varB4EAC82CA7396A68D541C85D26508E83_107482753.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_107482753;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.816 -0400", hash_original_method = "25EFF753F3CF5167178BD7379B9659BF", hash_generated_method = "5C7C96C7F184CFE8D5732D2DDE9992B0")
    public InputConnection getCurrentInputConnection() {
        InputConnection varB4EAC82CA7396A68D541C85D26508E83_1153641656 = null; 
        InputConnection varB4EAC82CA7396A68D541C85D26508E83_1770058770 = null; 
        InputConnection ic = mStartedInputConnection;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1153641656 = ic;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1770058770 = mInputConnection;
        InputConnection varA7E53CE21691AB073D9660D615818899_332099451; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_332099451 = varB4EAC82CA7396A68D541C85D26508E83_1153641656;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_332099451 = varB4EAC82CA7396A68D541C85D26508E83_1770058770;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_332099451.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_332099451;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.817 -0400", hash_original_method = "26F207E076BC370412C35CB8C7E97837", hash_generated_method = "8ABBBDC599E8570F1AA7CCB9D5C0FFDE")
    public boolean getCurrentInputStarted() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2131138293 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2131138293;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.817 -0400", hash_original_method = "659C592D4ABB3DB82261D1C4692ABF2E", hash_generated_method = "248E7A8B8A32D85F04EA27A88C3D165D")
    public EditorInfo getCurrentInputEditorInfo() {
        EditorInfo varB4EAC82CA7396A68D541C85D26508E83_1498711046 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1498711046 = mInputEditorInfo;
        varB4EAC82CA7396A68D541C85D26508E83_1498711046.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1498711046;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.818 -0400", hash_original_method = "27763B4939D9D4CE4F4BEBC3E63AF469", hash_generated_method = "94E45A224C13DD556AE603FF07F07E2E")
    public void updateFullscreenMode() {
        boolean isFullscreen = mShowInputRequested && onEvaluateFullscreenMode();
        boolean changed = mLastShowInputRequested != mShowInputRequested;
        {
            changed = true;
            mIsFullscreen = isFullscreen;
            InputConnection ic = getCurrentInputConnection();
            ic.reportFullscreenMode(isFullscreen);
            mFullscreenApplied = true;
            initialize();
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams)
                    mFullscreenArea.getLayoutParams();
            {
                mFullscreenArea.setBackgroundDrawable(mThemeAttrs.getDrawable(
                        com.android.internal.R.styleable.InputMethodService_imeFullscreenBackground));
                lp.height = 0;
                lp.weight = 1;
            } 
            {
                mFullscreenArea.setBackgroundDrawable(null);
                lp.height = LinearLayout.LayoutParams.WRAP_CONTENT;
                lp.weight = 0;
            } 
            ((ViewGroup)mFullscreenArea.getParent()).updateViewLayout(
                    mFullscreenArea, lp);
            {
                {
                    View v = onCreateExtractTextView();
                    {
                        setExtractView(v);
                    } 
                } 
                startExtractingText(false);
            } 
            updateExtractFrameVisibility();
        } 
        {
            onConfigureWindow(mWindow.getWindow(), isFullscreen, !mShowInputRequested);
            mLastShowInputRequested = mShowInputRequested;
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.818 -0400", hash_original_method = "57F13E10195CB2F326F03FED8DB64B03", hash_generated_method = "C60A9927525ADC98040635D9889BA8F6")
    public void onConfigureWindow(Window win, boolean isFullscreen,
            boolean isCandidatesOnly) {
        
        {
            mWindow.getWindow().setLayout(MATCH_PARENT, MATCH_PARENT);
        } 
        {
            mWindow.getWindow().setLayout(MATCH_PARENT, WRAP_CONTENT);
        } 
        addTaint(win.getTaint());
        addTaint(isFullscreen);
        addTaint(isCandidatesOnly);
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.818 -0400", hash_original_method = "0B558CA7980DF9D2EBB981E6DDF5DF60", hash_generated_method = "A448E83390B053BB81B915FC62C7C85C")
    public boolean isFullscreenMode() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_319414110 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_319414110;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.818 -0400", hash_original_method = "F5927891A0B192B06619C4589486FDC4", hash_generated_method = "F2618501852F563FB5C4EEA3300E4C99")
    public boolean onEvaluateFullscreenMode() {
        
        Configuration config = getResources().getConfiguration();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2117529405 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2117529405;
        
        
        
            
        
        
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.819 -0400", hash_original_method = "D4950711A20DE11BC2C7EA5EC93FE5E0", hash_generated_method = "9A1C7B3C016AB62708C38E181AF256B9")
    public void setExtractViewShown(boolean shown) {
        {
            mExtractViewHidden = !shown;
            updateExtractFrameVisibility();
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.820 -0400", hash_original_method = "DE07F0C980519D51E427F21507DA3D90", hash_generated_method = "5BF29279B56799F9851E5ADB18924D6E")
    public boolean isExtractViewShown() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_978115611 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_978115611;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.821 -0400", hash_original_method = "7CD3F30CDD4A5DA751939DF09DB853BA", hash_generated_method = "6B018199AFB1DEE0326CDE9F925A62A5")
     void updateExtractFrameVisibility() {
        int vis;
        {
            boolean varDA1B124F93BA93414CB6CAF390A362A8_559799497 = (isFullscreenMode());
            {
                vis = mExtractViewHidden ? View.INVISIBLE : View.VISIBLE;
                mExtractFrame.setVisibility(View.VISIBLE);
            } 
            {
                vis = View.VISIBLE;
                mExtractFrame.setVisibility(View.GONE);
            } 
        } 
        updateCandidatesVisibility(mCandidatesVisibility == View.VISIBLE);
        {
            boolean var548700EC502290A06EC6C7AD18983A79_176354970 = (mWindowWasVisible && mFullscreenArea.getVisibility() != vis);
            {
                int animRes = mThemeAttrs.getResourceId(vis == View.VISIBLE
                    ? com.android.internal.R.styleable.InputMethodService_imeExtractEnterAnimation
                    : com.android.internal.R.styleable.InputMethodService_imeExtractExitAnimation,
                    0);
                {
                    mFullscreenArea.startAnimation(AnimationUtils.loadAnimation(
                        this, animRes));
                } 
            } 
        } 
        mFullscreenArea.setVisibility(vis);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.822 -0400", hash_original_method = "46EC672E73C1227D1C1A9029A1E1F3EE", hash_generated_method = "00800894A3644FC1CE421FF9664D9F39")
    public void onComputeInsets(Insets outInsets) {
        
        int[] loc = mTmpLocation;
        {
            boolean var79E067E94CDE3882F5E84A741E69778F_445661275 = (mInputFrame.getVisibility() == View.VISIBLE);
            {
                mInputFrame.getLocationInWindow(loc);
            } 
            {
                View decor = getWindow().getWindow().getDecorView();
                loc[1] = decor.getHeight();
            } 
        } 
        {
            boolean varDA1B124F93BA93414CB6CAF390A362A8_1308587956 = (isFullscreenMode());
            {
                View decor = getWindow().getWindow().getDecorView();
                outInsets.contentTopInsets = decor.getHeight();
            } 
            {
                outInsets.contentTopInsets = loc[1];
            } 
        } 
        {
            boolean varD90E8A6553A0F92E94122AA94D382E19_82106135 = (mCandidatesFrame.getVisibility() == View.VISIBLE);
            {
                mCandidatesFrame.getLocationInWindow(loc);
            } 
        } 
        outInsets.visibleTopInsets = loc[1];
        outInsets.touchableInsets = Insets.TOUCHABLE_INSETS_VISIBLE;
        outInsets.touchableRegion.setEmpty();
        addTaint(outInsets.getTaint());
        
        
        
            
        
            
            
        
        
            
            
        
            
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.823 -0400", hash_original_method = "0265E8D9142690DEBAB6C995400C2A87", hash_generated_method = "5686792C62D00F1B990BB8635418AFE6")
    public void updateInputViewShown() {
        boolean isShown = mShowInputRequested && onEvaluateInputViewShown();
        {
            mIsInputViewShown = isShown;
            mInputFrame.setVisibility(isShown ? View.VISIBLE : View.GONE);
            {
                initialize();
                View v = onCreateInputView();
                {
                    setInputView(v);
                } 
            } 
        } 
        
        
        
            
            
            
                
                
                
                    
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.824 -0400", hash_original_method = "CE1497EC29214CA28D281C89DC587F5D", hash_generated_method = "5509CCC1A2A0D5678EF5987570517E58")
    public boolean isShowInputRequested() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1233717088 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1233717088;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.826 -0400", hash_original_method = "FAB0B10F230F7249B0A5682A6CF03BDF", hash_generated_method = "86F0047951EA164E43F925E2C613F750")
    public boolean isInputViewShown() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_522019097 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_522019097;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.827 -0400", hash_original_method = "1FE8D4523FDD0EE9294351AC86397C44", hash_generated_method = "70AB92CBF94BABE3755C621C14FA031F")
    public boolean onEvaluateInputViewShown() {
        
        Configuration config = getResources().getConfiguration();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1236435584 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1236435584;
        
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.828 -0400", hash_original_method = "3ADC6F28D6F2E8A9F55D9BD9F82BC8D2", hash_generated_method = "2596C08761B57C262DB3FB0E4520A40D")
    public void setCandidatesViewShown(boolean shown) {
        updateCandidatesVisibility(shown);
        {
            {
                showWindow(false);
            } 
            {
                hideWindow();
            } 
        } 
        addTaint(shown);
        
        
        
            
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.829 -0400", hash_original_method = "4164AC2B45DCCBE42C527D3F966F5882", hash_generated_method = "7273FFFBF842D94403313099DBFAF9C4")
     void updateCandidatesVisibility(boolean shown) {
        int vis;
        vis = View.VISIBLE;
        vis = getCandidatesHiddenVisibility();
        {
            mCandidatesFrame.setVisibility(vis);
            mCandidatesVisibility = vis;
        } 
        addTaint(shown);
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.830 -0400", hash_original_method = "587D3BCB04C3551F0F314F802D60C565", hash_generated_method = "476F683162C00BFEBA7E45DC0BA8A6B4")
    public int getCandidatesHiddenVisibility() {
        {
            boolean varED8C2CEF57D48CBEF71A26459BE2DF41_1453522424 = (isExtractViewShown());
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1304229400 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1304229400;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.830 -0400", hash_original_method = "09F11407FBE421F2EB35629AC776C29A", hash_generated_method = "DECC09ED0847FD21887B434C8C7A2F55")
    public void showStatusIcon(int iconResId) {
        mStatusIcon = iconResId;
        mImm.showStatusIcon(mToken, getPackageName(), iconResId);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.831 -0400", hash_original_method = "F1217201D04BC19DA5F1842A9EA12AC0", hash_generated_method = "1FEC1D46E33E85CCE5B5210B4D8FEDD0")
    public void hideStatusIcon() {
        mStatusIcon = 0;
        mImm.hideStatusIcon(mToken);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.831 -0400", hash_original_method = "65B927BAD02A0A8652162D17880CBC94", hash_generated_method = "FCC4926ADFC2ECEE94B9C332F39E19F4")
    public void switchInputMethod(String id) {
        mImm.setInputMethod(mToken, id);
        addTaint(id.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.832 -0400", hash_original_method = "7F30721F4F1DC6518EC25FA69EEA9DD8", hash_generated_method = "CDA9D00F13C5A4E9F4F27CD30F04BCC1")
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
            } 
            startExtractingText(false);
        } 
        {
            mExtractEditText = null;
            mExtractAccessories = null;
            mExtractAction = null;
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.833 -0400", hash_original_method = "8648EAF39F078D77783E311D9636B394", hash_generated_method = "5F49A98A89E7C6853457A2DBB9C200C5")
    public void setCandidatesView(View view) {
        mCandidatesFrame.removeAllViews();
        mCandidatesFrame.addView(view, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        addTaint(view.getTaint());
        
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.834 -0400", hash_original_method = "F530779F20B702B2AC3AEE15911FE235", hash_generated_method = "448C234ECEA41219ABFCADD0A5752A31")
    public void setInputView(View view) {
        mInputFrame.removeAllViews();
        mInputFrame.addView(view, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        mInputView = view;
        
        
        
                
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.837 -0400", hash_original_method = "A13C1AA9A5FD5770C02F503628C51194", hash_generated_method = "6892A6AA8FFD16A944E319AF2CD4C6DB")
    public View onCreateExtractTextView() {
        
        View varB4EAC82CA7396A68D541C85D26508E83_2141005836 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2141005836 = mInflater.inflate(
                com.android.internal.R.layout.input_method_extract_view, null);
        varB4EAC82CA7396A68D541C85D26508E83_2141005836.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2141005836;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.838 -0400", hash_original_method = "F89AAD61B39578A3862B8537E7226DB5", hash_generated_method = "F00AC552D86FB5EE84872347F60998DD")
    public View onCreateCandidatesView() {
        
        View varB4EAC82CA7396A68D541C85D26508E83_829622698 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_829622698 = null;
        varB4EAC82CA7396A68D541C85D26508E83_829622698.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_829622698;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.839 -0400", hash_original_method = "75C53F9A7550BADCC3EEC67DE46E8BC4", hash_generated_method = "0B4311C697C5C6CF0A58D380F5E8042F")
    public View onCreateInputView() {
        
        View varB4EAC82CA7396A68D541C85D26508E83_1341208093 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1341208093 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1341208093.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1341208093;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.840 -0400", hash_original_method = "4B7A497965AEC42ECF0C79E271F7AFEF", hash_generated_method = "E916951172883C0F58CDCC3747E38446")
    public void onStartInputView(EditorInfo info, boolean restarting) {
        
        addTaint(info.getTaint());
        addTaint(restarting);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.841 -0400", hash_original_method = "126397FC018D546EBB3D17AA8B426F4F", hash_generated_method = "8724C1B08ABA32FAD0D517829E93493C")
    public void onFinishInputView(boolean finishingInput) {
        
        {
            InputConnection ic = getCurrentInputConnection();
            {
                ic.finishComposingText();
            } 
        } 
        addTaint(finishingInput);
        
        
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.841 -0400", hash_original_method = "C1D318033051A63629AB7F18935A055B", hash_generated_method = "7BE62851E5BD3F3C78A4B38A6A2455C3")
    public void onStartCandidatesView(EditorInfo info, boolean restarting) {
        
        addTaint(info.getTaint());
        addTaint(restarting);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.842 -0400", hash_original_method = "7B21B5BD050EBE81B79EA707D7F10503", hash_generated_method = "BB05EB6B62551D1A2141B3FD4F12AA17")
    public void onFinishCandidatesView(boolean finishingInput) {
        
        {
            InputConnection ic = getCurrentInputConnection();
            {
                ic.finishComposingText();
            } 
        } 
        addTaint(finishingInput);
        
        
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.843 -0400", hash_original_method = "7116B74C32B9543E489CB78AF9B82E3D", hash_generated_method = "416943D6395F47D0A07821C0A78E5ACC")
    public boolean onShowInputRequested(int flags, boolean configChange) {
        
        {
            boolean var9151F215B67E3E110B8160488A310989_1200842717 = (!onEvaluateInputViewShown());
        } 
        {
            {
                boolean varB1105F93C8A3332B01967E57F54EA7F5_385037421 = (!configChange && onEvaluateFullscreenMode());
            } 
            Configuration config = getResources().getConfiguration();
        } 
        {
            mShowInputForced = true;
        } 
        addTaint(flags);
        addTaint(configChange);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1872969187 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1872969187;
        
        
            
        
        
            
                
            
            
            
                
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.844 -0400", hash_original_method = "119016FA69877024FD5AD688A6BA764A", hash_generated_method = "B8885889E0A48F19B4706A903BBEFEF7")
    public void showWindow(boolean showInput) {
        try 
        {
            mWindowWasVisible = mWindowVisible;
            mInShowWindow = true;
            showWindowInner(showInput);
        } 
        finally 
        {
            mWindowWasVisible = true;
            mInShowWindow = false;
        } 
        addTaint(showInput);
        
        
                
                
                
                
                
        
            
            
        
        
            
            
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.846 -0400", hash_original_method = "CB135560325B3F8C18497A9052C17028", hash_generated_method = "BF8967DB4BA4ACC2520B715AC7B8E149")
     void showWindowInner(boolean showInput) {
        boolean doShowInput = false;
        boolean wasVisible = mWindowVisible;
        mWindowVisible = true;
        {
            {
                {
                    doShowInput = true;
                    mShowInputRequested = true;
                } 
            } 
        } 
        {
            showInput = true;
        } 
        initialize();
        updateFullscreenMode();
        updateInputViewShown();
        {
            mWindowAdded = true;
            mWindowCreated = true;
            initialize();
            View v = onCreateCandidatesView();
            {
                setCandidatesView(v);
            } 
        } 
        {
            {
                mInputViewStarted = true;
                onStartInputView(mInputEditorInfo, false);
            } 
        } 
        {
            mCandidatesViewStarted = true;
            onStartCandidatesView(mInputEditorInfo, false);
        } 
        {
            startExtractingText(false);
        } 
        {
            mImm.setImeWindowStatus(mToken, IME_ACTIVE, mBackDisposition);
            onWindowShown();
            mWindow.show();
        } 
        addTaint(showInput);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.847 -0400", hash_original_method = "AE7818A6DC114C265A5A8660654BB926", hash_generated_method = "4D5A11064569AA5F7303EF116AEDEAA3")
    private void finishViews() {
        {
            onFinishInputView(false);
        } 
        {
            onFinishCandidatesView(false);
        } 
        mInputViewStarted = false;
        mCandidatesViewStarted = false;
        
        
            
            
        
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.848 -0400", hash_original_method = "09134BCCF788D1D9024485AE6DA1693C", hash_generated_method = "16EEEC9F8593063A82AAF47B525A09E8")
    public void hideWindow() {
        finishViews();
        mImm.setImeWindowStatus(mToken, 0, mBackDisposition);
        {
            mWindow.hide();
            mWindowVisible = false;
            onWindowHidden();
            mWindowWasVisible = false;
        } 
        
        
        
        
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.849 -0400", hash_original_method = "D99B15EAA68884714BB333A2583A0571", hash_generated_method = "E797350F14362CA554D013A5659543F1")
    public void onWindowShown() {
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.849 -0400", hash_original_method = "C1BA79DB491FC590F2A9A222970A46B9", hash_generated_method = "82493FCA94AEB547B2950C787893F07B")
    public void onWindowHidden() {
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.850 -0400", hash_original_method = "56BEE8816781B99E44028AA4DD49AFE8", hash_generated_method = "9A3D5E9EBB717318D195E3F6D8803AE5")
    public void onBindInput() {
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.850 -0400", hash_original_method = "D52B154580F2280F1D8D5CF7DCC6C0BF", hash_generated_method = "049C427B4927AA2DB3B5531ABC79BA72")
    public void onUnbindInput() {
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.851 -0400", hash_original_method = "3ADFFB39DB97C5354271962A42564DD7", hash_generated_method = "4C0B9C5E6309EE4241134758A86A3D42")
    public void onStartInput(EditorInfo attribute, boolean restarting) {
        
        addTaint(attribute.getTaint());
        addTaint(restarting);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.851 -0400", hash_original_method = "D870334B8409E203BCA5DBA60A032B6F", hash_generated_method = "246F9011D67E57587BF93602711A96F2")
     void doFinishInput() {
        {
            onFinishInputView(true);
        } 
        {
            onFinishCandidatesView(true);
        } 
        mInputViewStarted = false;
        mCandidatesViewStarted = false;
        {
            onFinishInput();
        } 
        mInputStarted = false;
        mStartedInputConnection = null;
        mCurCompletions = null;
        
        
            
            
        
            
            
        
        
        
        
            
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.852 -0400", hash_original_method = "D70A8E32EEED9199B71D72D85567D543", hash_generated_method = "7A6306B23521605091A12339D03CC401")
     void doStartInput(InputConnection ic, EditorInfo attribute, boolean restarting) {
        {
            doFinishInput();
        } 
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
            } 
            {
                mCandidatesViewStarted = true;
                onStartCandidatesView(mInputEditorInfo, restarting);
            } 
        } 
        addTaint(restarting);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.853 -0400", hash_original_method = "E745A863BE4D98B94E02F169B272F08C", hash_generated_method = "2735EC8CCC520252B7D6484924DC8C63")
    public void onFinishInput() {
        
        InputConnection ic = getCurrentInputConnection();
        {
            ic.finishComposingText();
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.854 -0400", hash_original_method = "75C3F475CAD98FE8CF4A523C8BDA8BB1", hash_generated_method = "B39F7F3BEFB24E502F188051870EED91")
    public void onDisplayCompletions(CompletionInfo[] completions) {
        
        addTaint(completions[0].getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.856 -0400", hash_original_method = "CC541C375904CEFCC1DC228363FE0C44", hash_generated_method = "07B266CDA4EFB2DD2809EEECD681E7DB")
    public void onUpdateExtractedText(int token, ExtractedText text) {
        
        {
            {
                mExtractedText = text;
                mExtractEditText.setExtractedText(text);
            } 
        } 
        addTaint(token);
        
        
            
        
        
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.857 -0400", hash_original_method = "08F34B1B106CF5B01DE522670D82A3BC", hash_generated_method = "38FF0A4FC35FB5CD454F42A92891631C")
    public void onUpdateSelection(int oldSelStart, int oldSelEnd,
            int newSelStart, int newSelEnd,
            int candidatesStart, int candidatesEnd) {
        
        final ExtractEditText eet = mExtractEditText;
        {
            boolean var07839FB6DDF532AEC3BACA070CA2FC06_2053200179 = (eet != null && isFullscreenMode() && mExtractedText != null);
            {
                final int off = mExtractedText.startOffset;
                eet.startInternalChanges();
                newSelStart -= off;
                newSelEnd -= off;
                final int len = eet.getText().length();
                newSelStart = 0;
                newSelStart = len;
                newSelEnd = 0;
                newSelEnd = len;
                eet.setSelection(newSelStart, newSelEnd);
                eet.finishInternalChanges();
            } 
        } 
        addTaint(oldSelStart);
        addTaint(oldSelEnd);
        addTaint(newSelStart);
        addTaint(newSelEnd);
        addTaint(candidatesStart);
        addTaint(candidatesEnd);
        
        
        
            
            
            
            
            
            
            
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.858 -0400", hash_original_method = "D49077B58DC986892621B88ACD9BF0F7", hash_generated_method = "87A26FC82293103A524EB821FB8B0059")
    public void onViewClicked(boolean focusChanged) {
        
        addTaint(focusChanged);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.858 -0400", hash_original_method = "F8EB5FE11A8138FB360940D74155758A", hash_generated_method = "4CB7960253167CFAAB602CD800822ACE")
    public void onUpdateCursor(Rect newCursor) {
        
        addTaint(newCursor.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.859 -0400", hash_original_method = "53762C81936F5FCD41F3F903406EE4C3", hash_generated_method = "F4B819E34691FF54D81086410C9F0E54")
    public void requestHideSelf(int flags) {
        mImm.hideSoftInputFromInputMethod(mToken, flags);
        addTaint(flags);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.859 -0400", hash_original_method = "939E9922D22E9C6523AEB259C97CBC65", hash_generated_method = "70BFF6F3D592ABB72D21315BE8B13CA7")
    private void requestShowSelf(int flags) {
        mImm.showSoftInputFromInputMethod(mToken, flags);
        addTaint(flags);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.860 -0400", hash_original_method = "2F1E84CCA4C2BB5EFB606DA289F60F64", hash_generated_method = "FECB8CDF9342BB276C33286BF38CAF3E")
    private boolean handleBack(boolean doIt) {
        {
            {
                boolean var702D5193BDDB49ACD0C022D27D4F16B7_784178992 = (isExtractViewShown() && mExtractView instanceof ExtractEditLayout);
                {
                    ExtractEditLayout extractEditLayout = (ExtractEditLayout) mExtractView;
                    {
                        boolean var5924543FB4797135854B81B78B99C485_1074308882 = (extractEditLayout.isActionModeStarted());
                        {
                            extractEditLayout.finishActionMode();
                        } 
                    } 
                } 
            } 
            requestHideSelf(0);
        } 
        {
            {
                setCandidatesViewShown(false);
            } 
            {
                hideWindow();
            } 
        } 
        addTaint(doIt);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_434955204 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_434955204;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.861 -0400", hash_original_method = "6D39318911C6DEDF33A28EA4D06A473F", hash_generated_method = "2FE442AE647A355717BDC77A13FD6406")
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        
        {
            boolean var5900307FC72CF55A885B11E67B5ADB96_1450635093 = (event.getKeyCode() == KeyEvent.KEYCODE_BACK);
            {
                {
                    boolean var30194127B59F20B8D15CB7440CF6FB54_392956065 = (handleBack(false));
                    {
                        event.startTracking();
                    } 
                } 
            } 
        } 
        boolean varBC0795DACA35C6A9F77201B924F9EBCC_851150085 = (doMovementKey(keyCode, event, MOVEMENT_DOWN));
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1744595771 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1744595771;
        
        
            
                
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.862 -0400", hash_original_method = "2A75FF2C44C4D96068DDAFC2643F0C8B", hash_generated_method = "F5702FA0236C3E2021F98207E3F3E683")
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2147145887 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2147145887;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.862 -0400", hash_original_method = "3CC4F52C9B71FCD2A0600FA46D6F06E5", hash_generated_method = "40A9DD698BEC7C7E227697D5879EED59")
    public boolean onKeyMultiple(int keyCode, int count, KeyEvent event) {
        
        boolean var690BBBD39586299984278532B3B9C485_1014682957 = (doMovementKey(keyCode, event, count));
        addTaint(keyCode);
        addTaint(count);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_721041732 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_721041732;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.863 -0400", hash_original_method = "BCD4505881DB97C910099D82B7A22807", hash_generated_method = "0A41E4718533D584907BAFFB164DD7E8")
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        
        {
            boolean var5922C562AF2EE989EFA0391BD79A8FD9_762942664 = (event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.isTracking()
                && !event.isCanceled());
            {
                boolean varD293510AE3D22D4016F47B37DB94AA22_1338674667 = (handleBack(true));
            } 
        } 
        boolean var8B63F1B3C4C5EA6147670BB023C5C4C4_2014596956 = (doMovementKey(keyCode, event, MOVEMENT_UP));
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_844258248 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_844258248;
        
        
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.864 -0400", hash_original_method = "4A983FDB3FF481E2165B7D8D641CDD48", hash_generated_method = "226874E0804CDBA87785E1F8ED9DFAC6")
    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_433710988 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_433710988;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.865 -0400", hash_original_method = "E2F219F9B605C6393794145B9C28D4D7", hash_generated_method = "152610093C22CA4DD8518A4BDB847682")
    public void onAppPrivateCommand(String action, Bundle data) {
        
        addTaint(action.getTaint());
        addTaint(data.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.866 -0400", hash_original_method = "F1BA2156F30663683BD63E2F68C8FA5C", hash_generated_method = "C5B57779CD7C9F5A77BEF05631CD4D00")
    private void onToggleSoftInput(int showFlags, int hideFlags) {
        {
            boolean var257AAF3411A7EBF3C3725C7C8F2C478F_1795126688 = (isInputViewShown());
            {
                requestHideSelf(hideFlags);
            } 
            {
                requestShowSelf(showFlags);
            } 
        } 
        addTaint(showFlags);
        addTaint(hideFlags);
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.867 -0400", hash_original_method = "9C1F09BC7693D3503A84F47A8DD2E9B8", hash_generated_method = "A3611ABE5682D1722740C923197897E1")
     void reportExtractedMovement(int keyCode, int count) {
        int dx = 0;
        int dy = 0;
        
        dx = -count;
        
        
        dx = count;
        
        
        dy = -count;
        
        
        dy = count;
        
        onExtractedCursorMovement(dx, dy);
        addTaint(keyCode);
        addTaint(count);
        
        
        
            
                
                
            
                
                
            
                
                
            
                
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.869 -0400", hash_original_method = "CADA6E3534C513A6E5A0D2EB184E3B48", hash_generated_method = "12A2DF7777B1B7D86952D962373475A9")
     boolean doMovementKey(int keyCode, KeyEvent event, int count) {
        final ExtractEditText eet = mExtractEditText;
        {
            boolean var94228B74C2263F815EDE31A941CF869D_1490929891 = (isExtractViewShown() && isInputViewShown() && eet != null);
            {
                MovementMethod movement = eet.getMovementMethod();
                Layout layout = eet.getLayout();
                {
                    {
                        {
                            boolean var963C81CEB3E2936CF5F881BEB18A9EC6_1104444862 = (movement.onKeyDown(eet,
                            (Spannable)eet.getText(), keyCode, event));
                            {
                                reportExtractedMovement(keyCode, 1);
                            } 
                        } 
                    } 
                    {
                        {
                            boolean varDB98AC32177DBB5E1C8506FFA61B86E0_1589985269 = (movement.onKeyUp(eet,
                            (Spannable)eet.getText(), keyCode, event));
                        } 
                    } 
                    {
                        {
                            boolean var498F283C3C6269EC555383DEA743554E_1703086702 = (movement.onKeyOther(eet, (Spannable)eet.getText(), event));
                            {
                                reportExtractedMovement(keyCode, count);
                            } 
                            {
                                KeyEvent down = KeyEvent.changeAction(event, KeyEvent.ACTION_DOWN);
                                {
                                    boolean varD21AC42920869AC37E02C57F302DAAF5_589455945 = (movement.onKeyDown(eet,
                                (Spannable)eet.getText(), keyCode, down));
                                    {
                                        KeyEvent up = KeyEvent.changeAction(event, KeyEvent.ACTION_UP);
                                        movement.onKeyUp(eet,
                                    (Spannable)eet.getText(), keyCode, up);
                                        {
                                            movement.onKeyDown(eet,
                                        (Spannable)eet.getText(), keyCode, down);
                                            movement.onKeyUp(eet,
                                        (Spannable)eet.getText(), keyCode, up);
                                        } 
                                        reportExtractedMovement(keyCode, count);
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
        addTaint(keyCode);
        addTaint(event.getTaint());
        addTaint(count);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1761535034 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1761535034;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.869 -0400", hash_original_method = "79E896FD8459E186D0AA684976DF9590", hash_generated_method = "527D63ED7FDE325B27B090B450551B29")
    public void sendDownUpKeyEvents(int keyEventCode) {
        InputConnection ic = getCurrentInputConnection();
        long eventTime = SystemClock.uptimeMillis();
        ic.sendKeyEvent(new KeyEvent(eventTime, eventTime,
                KeyEvent.ACTION_DOWN, keyEventCode, 0, 0, KeyCharacterMap.VIRTUAL_KEYBOARD, 0,
                KeyEvent.FLAG_SOFT_KEYBOARD|KeyEvent.FLAG_KEEP_TOUCH_MODE));
        ic.sendKeyEvent(new KeyEvent(SystemClock.uptimeMillis(), eventTime,
                KeyEvent.ACTION_UP, keyEventCode, 0, 0, KeyCharacterMap.VIRTUAL_KEYBOARD, 0,
                KeyEvent.FLAG_SOFT_KEYBOARD|KeyEvent.FLAG_KEEP_TOUCH_MODE));
        addTaint(keyEventCode);
        
        
        
        
        
                
                
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.870 -0400", hash_original_method = "84DA6B1414DFECBCA6744FD6285B6A00", hash_generated_method = "A36F37B3CF81B6132B9DE6E2494F386D")
    public boolean sendDefaultEditorAction(boolean fromEnterKey) {
        EditorInfo ei = getCurrentInputEditorInfo();
        {
            InputConnection ic = getCurrentInputConnection();
            {
                ic.performEditorAction(ei.imeOptions&EditorInfo.IME_MASK_ACTION);
            } 
        } 
        addTaint(fromEnterKey);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1052603018 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1052603018;
        
        
        
                
                        
                
                    
            
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.871 -0400", hash_original_method = "CB96ACC643B76CE6B3516B92D9424351", hash_generated_method = "0EFCDB25F4123D5B589445F7A836D040")
    public void sendKeyChar(char charCode) {
        
        {
            boolean var7FAAA40E562A94AE6D757E1CEC431AF1_1707278429 = (!sendDefaultEditorAction(true));
            {
                sendDownUpKeyEvents(KeyEvent.KEYCODE_ENTER);
            } 
        } 
        
        
        {
            sendDownUpKeyEvents(charCode - '0' + KeyEvent.KEYCODE_0);
        } 
        {
            InputConnection ic = getCurrentInputConnection();
            {
                ic.commitText(String.valueOf((char) charCode), 1);
            } 
        } 
        
        addTaint(charCode);
        
        
            
                
                    
                
                
            
                
                    
                
                    
                    
                        
                    
                
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.872 -0400", hash_original_method = "B848FD2302E48E43854FF3AB55ABE7CC", hash_generated_method = "17787109CFB8BC9A6EFB151D4E9E0E99")
    public void onExtractedSelectionChanged(int start, int end) {
        
        InputConnection conn = getCurrentInputConnection();
        {
            conn.setSelection(start, end);
        } 
        addTaint(start);
        addTaint(end);
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.872 -0400", hash_original_method = "56B9FB82082DF66D8709DA9479270344", hash_generated_method = "8601C13BCF473FB92B303DF846214ACD")
    public void onExtractedDeleteText(int start, int end) {
        
        InputConnection conn = getCurrentInputConnection();
        {
            conn.setSelection(start, start);
            conn.deleteSurroundingText(0, end-start);
        } 
        addTaint(start);
        addTaint(end);
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.873 -0400", hash_original_method = "3752CFC0704EAA41A71F5FCC4C7F691D", hash_generated_method = "4635D80C9F88CEF3560A54B4C45624DE")
    public void onExtractedReplaceText(int start, int end, CharSequence text) {
        
        InputConnection conn = getCurrentInputConnection();
        {
            conn.setComposingRegion(start, end);
            conn.commitText(text, 1);
        } 
        addTaint(start);
        addTaint(end);
        addTaint(text.getTaint());
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.874 -0400", hash_original_method = "2386EADCDB176594EC064F3F20DE5D60", hash_generated_method = "0C9C89BC564E432FDE87CC72A3E916D1")
    public void onExtractedSetSpan(Object span, int start, int end, int flags) {
        
        InputConnection conn = getCurrentInputConnection();
        {
            {
                boolean varD960B03B483BFF53BB8B9F9042E2BA47_310399510 = (!conn.setSelection(start, end));
            } 
            CharSequence text = conn.getSelectedText(InputConnection.GET_TEXT_WITH_STYLES);
            {
                ((Spannable) text).setSpan(span, 0, text.length(), flags);
                conn.setComposingRegion(start, end);
                conn.commitText(text, 1);
            } 
        } 
        addTaint(span.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(flags);
        
        
        
            
            
            
                
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.875 -0400", hash_original_method = "672EAF0A2CC265CDC19E0FE05714B327", hash_generated_method = "B9F50BF4ACE0325999B56A5E071D38D9")
    public void onExtractedTextClicked() {
        
        {
            boolean varA215564B7B15BCB949555AE2A66D446A_778810662 = (mExtractEditText.hasVerticalScrollBar());
            {
                setCandidatesViewShown(false);
            } 
        } 
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.876 -0400", hash_original_method = "33B88CC3E792B5DBD4A2FEF9CD5D26B5", hash_generated_method = "55C55F682227DE462418F200C5B0D778")
    public void onExtractedCursorMovement(int dx, int dy) {
        
        {
            boolean varA215564B7B15BCB949555AE2A66D446A_1626982534 = (mExtractEditText.hasVerticalScrollBar());
            {
                setCandidatesViewShown(false);
            } 
        } 
        addTaint(dx);
        addTaint(dy);
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.877 -0400", hash_original_method = "FA4A3D7B1537F03835F5D4F28B4BC905", hash_generated_method = "C5E0CF9A82B76A2B1B262D8B911D02D0")
    public boolean onExtractTextContextMenuItem(int id) {
        
        InputConnection ic = getCurrentInputConnection();
        {
            ic.performContextMenuAction(id);
        } 
        addTaint(id);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_690787156 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_690787156;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.879 -0400", hash_original_method = "9F91BE1CB3CE4671D110A2B57AE2570E", hash_generated_method = "1EA1F2B179555CD873C44ECDAF155A3E")
    public CharSequence getTextForImeAction(int imeOptions) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_95831614 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_354202940 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_638410133 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1776536384 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1242680844 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1334870840 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_676305156 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1163650420 = null; 
        
        varB4EAC82CA7396A68D541C85D26508E83_95831614 = null;
        
        
        varB4EAC82CA7396A68D541C85D26508E83_354202940 = getText(com.android.internal.R.string.ime_action_go);
        
        
        varB4EAC82CA7396A68D541C85D26508E83_638410133 = getText(com.android.internal.R.string.ime_action_search);
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1776536384 = getText(com.android.internal.R.string.ime_action_send);
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1242680844 = getText(com.android.internal.R.string.ime_action_next);
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1334870840 = getText(com.android.internal.R.string.ime_action_done);
        
        
        varB4EAC82CA7396A68D541C85D26508E83_676305156 = getText(com.android.internal.R.string.ime_action_previous);
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1163650420 = getText(com.android.internal.R.string.ime_action_default);
        
        addTaint(imeOptions);
        CharSequence varA7E53CE21691AB073D9660D615818899_1935526868; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1935526868 = varB4EAC82CA7396A68D541C85D26508E83_95831614;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1935526868 = varB4EAC82CA7396A68D541C85D26508E83_354202940;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1935526868 = varB4EAC82CA7396A68D541C85D26508E83_638410133;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_1935526868 = varB4EAC82CA7396A68D541C85D26508E83_1776536384;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_1935526868 = varB4EAC82CA7396A68D541C85D26508E83_1242680844;
                break;
            case 6: 
                varA7E53CE21691AB073D9660D615818899_1935526868 = varB4EAC82CA7396A68D541C85D26508E83_1334870840;
                break;
            case 7: 
                varA7E53CE21691AB073D9660D615818899_1935526868 = varB4EAC82CA7396A68D541C85D26508E83_676305156;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1935526868 = varB4EAC82CA7396A68D541C85D26508E83_1163650420;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1935526868.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1935526868;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.880 -0400", hash_original_method = "8796655A783A46466BACE236BCA7DD97", hash_generated_method = "6238B41A7B5435B0D9D8E8F7CADDE18D")
    public void onUpdateExtractingVisibility(EditorInfo ei) {
        
        {
            setExtractViewShown(false);
        } 
        setExtractViewShown(true);
        addTaint(ei.getTaint());
        
        
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.881 -0400", hash_original_method = "EAD47E132E9ECD3692FAA5C1AB9CEE12", hash_generated_method = "65A8717311DE111910B01BD5A17E32D3")
    public void onUpdateExtractingViews(EditorInfo ei) {
        
        {
            boolean var87F8135436C414A49235B50C0BEE24F1_996559694 = (!isExtractViewShown());
        } 
        final boolean hasAction = ei.actionLabel != null || (
                (ei.imeOptions&EditorInfo.IME_MASK_ACTION) != EditorInfo.IME_ACTION_NONE &&
                (ei.imeOptions&EditorInfo.IME_FLAG_NO_ACCESSORY_ACTION) == 0 &&
                ei.inputType != InputType.TYPE_NULL);
        {
            mExtractAccessories.setVisibility(View.VISIBLE);
            {
                {
                    mExtractAction.setText(ei.actionLabel);
                } 
                {
                    mExtractAction.setText(getTextForImeAction(ei.imeOptions));
                } 
                mExtractAction.setOnClickListener(mActionClickListener);
            } 
        } 
        {
            mExtractAccessories.setVisibility(View.GONE);
            {
                mExtractAction.setOnClickListener(null);
            } 
        } 
        addTaint(ei.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.882 -0400", hash_original_method = "B8550D5274B7AC063AD577912E9B5BF9", hash_generated_method = "0FFAAF964485579153E2E3988A3EE39A")
    public void onExtractingInputChanged(EditorInfo ei) {
        
        {
            requestHideSelf(InputMethodManager.HIDE_NOT_ALWAYS);
        } 
        addTaint(ei.getTaint());
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.883 -0400", hash_original_method = "4C67EC88DE5F38ABAC11BF6FC64666D8", hash_generated_method = "2D0E02EDC4FED280AA45B1B3B8194625")
     void startExtractingText(boolean inputChanged) {
        final ExtractEditText eet = mExtractEditText;
        {
            boolean var4B45048747F7E34CB0EFEC67D57A6FDB_1274374857 = (eet != null && getCurrentInputStarted()
                && isFullscreenMode());
            {
                ExtractedTextRequest req = new ExtractedTextRequest();
                req.token = mExtractedToken;
                req.flags = InputConnection.GET_TEXT_WITH_STYLES;
                req.hintMaxLines = 10;
                req.hintMaxChars = 10000;
                InputConnection ic = getCurrentInputConnection();
                mExtractedText = ic == null? null
                    : ic.getExtractedText(req, InputConnection.GET_EXTRACTED_TEXT_MONITOR);
                final EditorInfo ei = getCurrentInputEditorInfo();
                try 
                {
                    eet.startInternalChanges();
                    onUpdateExtractingVisibility(ei);
                    onUpdateExtractingViews(ei);
                    int inputType = ei.inputType;
                    {
                        {
                            inputType |= EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE;
                        } 
                    } 
                    eet.setInputType(inputType);
                    eet.setHint(ei.hintText);
                    {
                        eet.setEnabled(true);
                        eet.setExtractedText(mExtractedText);
                    } 
                    {
                        eet.setEnabled(false);
                        eet.setText("");
                    } 
                } 
                finally 
                {
                    eet.finishInternalChanges();
                } 
                {
                    onExtractingInputChanged(ei);
                } 
            } 
        } 
        addTaint(inputChanged);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.884 -0400", hash_original_method = "18DCEDE4996E63CB2DB494AAC7CE4961", hash_generated_method = "22FF06AE96EBFAD2C10CC25B4574EC44")
    protected void onCurrentInputMethodSubtypeChanged(InputMethodSubtype newSubtype) {
        
        {
            int nameResId = newSubtype.getNameResId();
            String mode = newSubtype.getMode();
            String output = "changeInputMethodSubtype:"
                + (nameResId == 0 ? "<none>" : getString(nameResId)) + ","
                + mode + ","
                + newSubtype.getLocale() + "," + newSubtype.getExtraValue();
        } 
        addTaint(newSubtype.getTaint());
        
        
            
            
            
                
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.886 -0400", hash_original_method = "ABDAB14391C840F473C7CB9BB20D3C33", hash_generated_method = "E99845C97EBDD11ADF93A9F58238DD17")
    @Override
    protected void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
        final Printer p = new PrintWriterPrinter(fout);
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
        } 
        {
            p.println("  mInputEditorInfo: null");
        } 
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
        } 
        {
            p.println("  mExtractedText: null");
        } 
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
        
        
    }

    
    public class InputMethodImpl extends AbstractInputMethodImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.887 -0400", hash_original_method = "F0421074EFC32AA5D8F43C6593C3D141", hash_generated_method = "F0421074EFC32AA5D8F43C6593C3D141")
        public InputMethodImpl ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.888 -0400", hash_original_method = "2246D0F0FC59D2518EAEE0F0671903AA", hash_generated_method = "A51CC7CD13A1E9A36365BA401FA778B0")
        public void attachToken(IBinder token) {
            {
                mToken = token;
                mWindow.setToken(token);
            } 
            addTaint(token.getTaint());
            
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.888 -0400", hash_original_method = "96E89AA7F2E1A70ABC64DBDE36024534", hash_generated_method = "3AB886EAA119042B32960EA36493930E")
        public void bindInput(InputBinding binding) {
            mInputBinding = binding;
            mInputConnection = binding.getConnection();
            InputConnection ic = getCurrentInputConnection();
            ic.reportFullscreenMode(mIsFullscreen);
            initialize();
            onBindInput();
            addTaint(binding.getTaint());
            
            
            
            
                    
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.889 -0400", hash_original_method = "5DFC78D3BA0A9E107E4BC0A877A8E6D3", hash_generated_method = "6B3CEDF4200C9C7C80218F8DD5B5F50D")
        public void unbindInput() {
            onUnbindInput();
            mInputStarted = false;
            mInputBinding = null;
            mInputConnection = null;
            
            
                    
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.890 -0400", hash_original_method = "ABB2165AD965E17C2FE21B1141C40C8F", hash_generated_method = "6AD7FD20C8DDACBEABA6596734A044AD")
        public void startInput(InputConnection ic, EditorInfo attribute) {
            doStartInput(ic, attribute, false);
            addTaint(ic.getTaint());
            addTaint(attribute.getTaint());
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.890 -0400", hash_original_method = "FBDDF384E0FE523BAEFE6359495BE0E1", hash_generated_method = "DD9B1A84FD0F4D6523FB95D732F7F0D1")
        public void restartInput(InputConnection ic, EditorInfo attribute) {
            doStartInput(ic, attribute, true);
            addTaint(ic.getTaint());
            addTaint(attribute.getTaint());
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.891 -0400", hash_original_method = "3A4CCDB7EB28BA706C897E348F128E61", hash_generated_method = "FBD1E66E9D12359F3F233704C788F170")
        public void hideSoftInput(int flags, ResultReceiver resultReceiver) {
            boolean wasVis = isInputViewShown();
            mShowInputFlags = 0;
            mShowInputRequested = false;
            mShowInputForced = false;
            hideWindow();
            {
                resultReceiver.send(wasVis != isInputViewShown()
                        ? InputMethodManager.RESULT_HIDDEN
                        : (wasVis ? InputMethodManager.RESULT_UNCHANGED_SHOWN
                                : InputMethodManager.RESULT_UNCHANGED_HIDDEN), null);
            } 
            addTaint(flags);
            addTaint(resultReceiver.getTaint());
            
            
            
            
            
            
            
            
                
                        
                        
                                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.892 -0400", hash_original_method = "FA726B6A215F3C1D91F0883D01FD2750", hash_generated_method = "5137850DBC27993FCD65F229442D502A")
        public void showSoftInput(int flags, ResultReceiver resultReceiver) {
            boolean wasVis = isInputViewShown();
            mShowInputFlags = 0;
            {
                boolean var0345BB707617653FF624969C451A707D_1519937520 = (onShowInputRequested(flags, false));
                {
                    showWindow(true);
                } 
            } 
            boolean showing = onEvaluateInputViewShown();
            mImm.setImeWindowStatus(mToken, IME_ACTIVE | (showing ? IME_VISIBLE : 0),
                    mBackDisposition);
            {
                resultReceiver.send(wasVis != isInputViewShown()
                        ? InputMethodManager.RESULT_SHOWN
                        : (wasVis ? InputMethodManager.RESULT_UNCHANGED_SHOWN
                                : InputMethodManager.RESULT_UNCHANGED_HIDDEN), null);
            } 
            addTaint(flags);
            addTaint(resultReceiver.getTaint());
            
            
            
            
            
                
            
            
            
                    
            
                
                        
                        
                                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.892 -0400", hash_original_method = "A5FC41682DA51C285C2C6651867F8D99", hash_generated_method = "A16AAF9A841479641C6E964FA07E0985")
        public void changeInputMethodSubtype(InputMethodSubtype subtype) {
            onCurrentInputMethodSubtypeChanged(subtype);
            addTaint(subtype.getTaint());
            
            
        }

        
    }


    
    public class InputMethodSessionImpl extends AbstractInputMethodSessionImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.893 -0400", hash_original_method = "0FFA9D5BB925C1ECDC26428126FD587D", hash_generated_method = "0FFA9D5BB925C1ECDC26428126FD587D")
        public InputMethodSessionImpl ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.893 -0400", hash_original_method = "3439BC8F3B3DD615353E38FBC0555505", hash_generated_method = "B2089176CE3732879AD9805EA61308D2")
        public void finishInput() {
            {
                boolean varC3AD07CBBFDAC9CFAEE0700F705E9164_257843403 = (!isEnabled());
            } 
            doFinishInput();
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.894 -0400", hash_original_method = "6A0353E151F9F29333A27C5421A53B38", hash_generated_method = "7E325DEB830C1CCE3C59050B40C2733F")
        public void displayCompletions(CompletionInfo[] completions) {
            {
                boolean varC3AD07CBBFDAC9CFAEE0700F705E9164_499277893 = (!isEnabled());
            } 
            mCurCompletions = completions;
            onDisplayCompletions(completions);
            addTaint(completions[0].getTaint());
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.895 -0400", hash_original_method = "0102DD0EEEDCD27552C577307A27FE88", hash_generated_method = "4DDB545A1A368739D540A5CEF288FCF0")
        public void updateExtractedText(int token, ExtractedText text) {
            {
                boolean varC3AD07CBBFDAC9CFAEE0700F705E9164_1849396756 = (!isEnabled());
            } 
            onUpdateExtractedText(token, text);
            addTaint(token);
            addTaint(text.getTaint());
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.897 -0400", hash_original_method = "8EA462F0F0CF12CBAE81AB6E28205A3D", hash_generated_method = "6543A4311207C62398D1F1E5319D9955")
        public void updateSelection(int oldSelStart, int oldSelEnd,
                int newSelStart, int newSelEnd,
                int candidatesStart, int candidatesEnd) {
            {
                boolean varC3AD07CBBFDAC9CFAEE0700F705E9164_1616628598 = (!isEnabled());
            } 
            InputMethodService.this.onUpdateSelection(oldSelStart, oldSelEnd,
                    newSelStart, newSelEnd, candidatesStart, candidatesEnd);
            addTaint(oldSelStart);
            addTaint(oldSelEnd);
            addTaint(newSelStart);
            addTaint(newSelEnd);
            addTaint(candidatesStart);
            addTaint(candidatesEnd);
            
            
                
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.898 -0400", hash_original_method = "7D0F3CDF004B0AA88B105A90C3B2EFF2", hash_generated_method = "6D5DA40FB956AC854D18F7B7A6994676")
        @Override
        public void viewClicked(boolean focusChanged) {
            {
                boolean varC3AD07CBBFDAC9CFAEE0700F705E9164_62137434 = (!isEnabled());
            } 
            InputMethodService.this.onViewClicked(focusChanged);
            addTaint(focusChanged);
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.899 -0400", hash_original_method = "5A756230FCCA173B557966360DF4EF77", hash_generated_method = "12C7C093A5655E04921EFE4C1F8CB034")
        public void updateCursor(Rect newCursor) {
            {
                boolean varC3AD07CBBFDAC9CFAEE0700F705E9164_233272326 = (!isEnabled());
            } 
            InputMethodService.this.onUpdateCursor(newCursor);
            addTaint(newCursor.getTaint());
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.900 -0400", hash_original_method = "681E840BDEA7B80F2F006F7D9B6B3563", hash_generated_method = "A971EC2D1A8255552DE8D0B01179F760")
        public void appPrivateCommand(String action, Bundle data) {
            {
                boolean varC3AD07CBBFDAC9CFAEE0700F705E9164_1491275998 = (!isEnabled());
            } 
            InputMethodService.this.onAppPrivateCommand(action, data);
            addTaint(action.getTaint());
            addTaint(data.getTaint());
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.900 -0400", hash_original_method = "F1C4F6A09FBC1E433445388BE149C06F", hash_generated_method = "930D3ACC499E481F5AC897BB0703F898")
        public void toggleSoftInput(int showFlags, int hideFlags) {
            InputMethodService.this.onToggleSoftInput(showFlags, hideFlags);
            addTaint(showFlags);
            addTaint(hideFlags);
            
            
        }

        
    }


    
    public static final class Insets {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.900 -0400", hash_original_field = "6B844646D0C6EADB76028E296D97D26E", hash_generated_field = "0848E8A3B2603B51400EBA2544607CD8")

        public int contentTopInsets;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.901 -0400", hash_original_field = "A2E8AB53B3DDAFAA3E389A47908EE03A", hash_generated_field = "4E5B62BB5E3FD9065410077ABCEFD6F5")

        public int visibleTopInsets;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.901 -0400", hash_original_field = "5CC4EAB992E3E01BAE580BFE4B7ACFD9", hash_generated_field = "F49DB2DF83C2B114A730FA19005C8733")

        public final Region touchableRegion = new Region();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.901 -0400", hash_original_field = "FB0951D59D942FF6CA5CA9E62DD65AED", hash_generated_field = "70DA720827DA3605384693EAE5E21AF8")

        public int touchableInsets;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.901 -0400", hash_original_method = "AB0F14C8125953D4D984387CD9B8D05E", hash_generated_method = "AB0F14C8125953D4D984387CD9B8D05E")
        public Insets ()
        {
            
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.901 -0400", hash_original_field = "A2BD6A2D2FAE4B0F2A6389403948A9DB", hash_generated_field = "A903B8D9E85FE8268399FAA8EA9A5E31")

        public static final int TOUCHABLE_INSETS_FRAME
                = ViewTreeObserver.InternalInsetsInfo.TOUCHABLE_INSETS_FRAME;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.901 -0400", hash_original_field = "A5CDA3247D70BA69B10B6C0010FDC255", hash_generated_field = "16D23B51E9664EA10F8919E161911777")

        public static final int TOUCHABLE_INSETS_CONTENT
                = ViewTreeObserver.InternalInsetsInfo.TOUCHABLE_INSETS_CONTENT;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.901 -0400", hash_original_field = "838E61A62623937065E74D6492529D84", hash_generated_field = "CFCF2141909DD954AF9ECFE0CCA49151")

        public static final int TOUCHABLE_INSETS_VISIBLE
                = ViewTreeObserver.InternalInsetsInfo.TOUCHABLE_INSETS_VISIBLE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.901 -0400", hash_original_field = "76E5A63ED3A610EE6AB6EB3A21422CFD", hash_generated_field = "2D48D24763A14D18AF2E1A2EBFB364B0")

        public static final int TOUCHABLE_INSETS_REGION
                = ViewTreeObserver.InternalInsetsInfo.TOUCHABLE_INSETS_REGION;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.901 -0400", hash_original_field = "4C210C59F731B7259273CB52E6EAB487", hash_generated_field = "9CF0118E5FF5051520996A9D15AE838E")

    static final String TAG = "InputMethodService";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.901 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "F09208C088E716A2CD36A97B937BB5EA")

    static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.901 -0400", hash_original_field = "2C29A4B5619C3A910834AA526BCE13BA", hash_generated_field = "4162B60B07B580ECBA3A261DC0CE993C")

    public static final int BACK_DISPOSITION_DEFAULT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.901 -0400", hash_original_field = "97E64829EE19D1C26581E470E551F6F1", hash_generated_field = "5EE67BE6E8CA7600A488D83901D53781")

    public static final int BACK_DISPOSITION_WILL_NOT_DISMISS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.901 -0400", hash_original_field = "203C7BC5EBC13AD8BC33775F4404CC44", hash_generated_field = "1CE0B7C8A6A795BBDBCCD6070E9E96CA")

    public static final int BACK_DISPOSITION_WILL_DISMISS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.901 -0400", hash_original_field = "0DDE1628212000DAF18C459BAEF81192", hash_generated_field = "911D20D022B12D5BDC027B47C99E815F")

    public static final int IME_ACTIVE = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.901 -0400", hash_original_field = "D1ECF6CE3C86B3EDFDFFA575C6C38827", hash_generated_field = "54453599413B853A6378E68D3D2217C5")

    public static final int IME_VISIBLE = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.901 -0400", hash_original_field = "F851B83995A9D4F3E431A958CAF5A8BE", hash_generated_field = "3B517107D2F173893643769189022B46")

    static final int MOVEMENT_DOWN = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.901 -0400", hash_original_field = "E702B70F996310DE47359709E5994159", hash_generated_field = "31973F9CFC4CEDE663F654F0137BD973")

    static final int MOVEMENT_UP = -2;
}

