package android.inputmethodservice;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.383 -0400", hash_original_field = "47E3DC1D02320FF11860FCA10E93021A", hash_generated_field = "01719032B78A2D912F910E37CD479B69")

    InputMethodManager mImm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.383 -0400", hash_original_field = "9C44372B6B78B59807C8DF03A1965EF9", hash_generated_field = "075FD7AAD50C5AD8803D9E3B208423A2")

    int mTheme = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.383 -0400", hash_original_field = "D03597FDEDE23F3823480E0520822BB2", hash_generated_field = "B03B4DAE3F576B7166425BEE37B96C5E")

    LayoutInflater mInflater;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.383 -0400", hash_original_field = "51146EF3EA2889FD9B2525C6E53C7975", hash_generated_field = "B7C98FA3B531CC028C7A59F94DC2AFFF")

    TypedArray mThemeAttrs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.383 -0400", hash_original_field = "03503F4E2878305C59038D192AB3AC15", hash_generated_field = "6D0C26C611FBD233667A9FA9104CED21")

    View mRootView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.383 -0400", hash_original_field = "F4214BE1FFE044F8CA79EEDDDED72016", hash_generated_field = "507E6EFA97CB0E77FA79A4D01B3ED4A3")

    SoftInputWindow mWindow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.383 -0400", hash_original_field = "57006E58594DC862E67D1855FDF16FEE", hash_generated_field = "C9E05499054E8056F0A4805D1295DEC9")

    boolean mInitialized;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.383 -0400", hash_original_field = "C0D2E2C93F79DA8713BDE478E1537ED0", hash_generated_field = "FE6B5FDA79102585E4703AA7755D8A1D")

    boolean mWindowCreated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.383 -0400", hash_original_field = "86E4FECD64C3696106A1C2B8A242AA04", hash_generated_field = "218C970370BBF49B29F07C78706BEE0F")

    boolean mWindowAdded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.384 -0400", hash_original_field = "F4BEAD71055EFB5C1D3AE1819E120D49", hash_generated_field = "71207F91BCFA87F10E39CE8F643F27A2")

    boolean mWindowVisible;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.384 -0400", hash_original_field = "90DB2BA0D89316B5F84014C89B3C5A49", hash_generated_field = "DC6F9BCE5EC968FD18904FAB6E1E26EA")

    boolean mWindowWasVisible;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.384 -0400", hash_original_field = "AA66B10DBD6B09095C3413E3E854E354", hash_generated_field = "393177CC055DA847245CCD680AD17E8C")

    boolean mInShowWindow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.384 -0400", hash_original_field = "FDFE1E462F69BA102A7B8F8BCFAC963E", hash_generated_field = "15182820025992AE750DB9E78ACD70F3")

    ViewGroup mFullscreenArea;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.384 -0400", hash_original_field = "3A05208DCCF4A0B7E79ED0C5D037E06F", hash_generated_field = "13D1A7834031B0B293BDFE378DF08473")

    FrameLayout mExtractFrame;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.384 -0400", hash_original_field = "560899D96824DB522510CBBACE726143", hash_generated_field = "E6B39B5292209EE43935C8AAB586E41A")

    FrameLayout mCandidatesFrame;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.384 -0400", hash_original_field = "E71070589690CB7B22255920EF5417C2", hash_generated_field = "8060C3896FC8C6EEC2A4B224AC19B8A5")

    FrameLayout mInputFrame;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.384 -0400", hash_original_field = "98E8D2ECD335C543A384E2B940159AF2", hash_generated_field = "DD6EB7EC256F1225D4C6DC1A42FB765B")

    IBinder mToken;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.384 -0400", hash_original_field = "023A158D0015238EFA1E574793716DF1", hash_generated_field = "AFA59EA1150C21AB6E344984735AF2EB")

    InputBinding mInputBinding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.385 -0400", hash_original_field = "A2D010B7C3546462A260EC1C5E1ED4C6", hash_generated_field = "0C4E3C3C223DA7FB43EF5D532A5B3E04")

    InputConnection mInputConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.385 -0400", hash_original_field = "782D39EBDAC05F2DB212AB8342884C64", hash_generated_field = "D15B1F449CE3CDE14A0008B2465EE7E3")

    boolean mInputStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.385 -0400", hash_original_field = "997F4B1392777ED6D28F46C5D817E4B7", hash_generated_field = "514EB139852D82B47A3950B6F3E19CF6")

    boolean mInputViewStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.385 -0400", hash_original_field = "000D18FCF61C40AD69E3E56BEB71A5A6", hash_generated_field = "4626543A6FCF1F8B8B73D10B97975D09")

    boolean mCandidatesViewStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.385 -0400", hash_original_field = "90E29B0FBB7D81AF12FD516A1C18EE0A", hash_generated_field = "60FF159378B9E2B6E495E1B7233D3981")

    InputConnection mStartedInputConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.385 -0400", hash_original_field = "EDB1ADCF132EE49252AA404EA0C42BDC", hash_generated_field = "0A7D4D3889811FF61BF27942BE846641")

    EditorInfo mInputEditorInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.385 -0400", hash_original_field = "9B0BEB2912C7407E921A6905D7C94F4B", hash_generated_field = "293541479A1626BCDA923AA8063FA9A6")

    int mShowInputFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.385 -0400", hash_original_field = "3130E5E55A7C8BB928012D0F32C408DB", hash_generated_field = "7599FBE37A9716825A76F29F0FE2FD55")

    boolean mShowInputRequested;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.385 -0400", hash_original_field = "E059488A4BAF82E3EB1514BBEF6A5C04", hash_generated_field = "46B9F45DD04B32BAA4E84977F39214E7")

    boolean mLastShowInputRequested;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.385 -0400", hash_original_field = "22665F4551D5A5EC46B2D94EDA2C4B99", hash_generated_field = "A9B119877C3EB8E978CAEECF1D6BD14B")

    int mCandidatesVisibility;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.386 -0400", hash_original_field = "C0ED2CFA44D0D69EEA23C8E4C66CE227", hash_generated_field = "497159238D66DB93A282D483EC1CA3AC")

    CompletionInfo[] mCurCompletions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.386 -0400", hash_original_field = "27CC66322143CE51D330735DF962162F", hash_generated_field = "0A08F53EED6C8EEC9D7CC85E98FAC447")

    boolean mShowInputForced;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.386 -0400", hash_original_field = "0FD506CFFBAF2760EA3C8C7A61A1EC34", hash_generated_field = "269508F0F9EF09EB866044C649D586B1")

    boolean mFullscreenApplied;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.386 -0400", hash_original_field = "54AB7B409DAEC84F47F83754E82B9CF7", hash_generated_field = "9CA62515CAD4DE9A3596FC712B0811BA")

    boolean mIsFullscreen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.386 -0400", hash_original_field = "A1FE7A1C3E639FA004091CB9A1C3BADC", hash_generated_field = "77749D3AEC38C02813E052F85601DCFE")

    View mExtractView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.386 -0400", hash_original_field = "63BD8F8E7390940615BF50D62ABA7B61", hash_generated_field = "41C2A191F101A74E110D9728B296F375")

    boolean mExtractViewHidden;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.386 -0400", hash_original_field = "DF23DA4699300FCC03743118373EEB29", hash_generated_field = "10C7C27B9EFB4B449D020D2FD7D681C8")

    ExtractEditText mExtractEditText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.386 -0400", hash_original_field = "D3312E3FB49BA27FC912A51A3BE0EB28", hash_generated_field = "49FE9D4C4E2B1ED741DB08F3BECEA464")

    ViewGroup mExtractAccessories;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.386 -0400", hash_original_field = "0EC10097C9F7737C7F02A1274F00634D", hash_generated_field = "4EF514D7B6A680A68FB4FA03A08F5D2D")

    Button mExtractAction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.386 -0400", hash_original_field = "A034AA34A307E777C43933E669A375DC", hash_generated_field = "7C5C99560AB4918E13830D06100AC03C")

    ExtractedText mExtractedText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.387 -0400", hash_original_field = "3B05C3A55FB18FD1556EDCEA83357EA4", hash_generated_field = "E322EFE9A47EF352CC52DE566A5DCA94")

    int mExtractedToken;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.387 -0400", hash_original_field = "CC1A335F32158BD1BD949E24E11AE1DC", hash_generated_field = "DD75F3DC122E5FCA3B30C64DE9D6C9CD")

    View mInputView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.387 -0400", hash_original_field = "05E05DFE926C9F572FDAAECF32DC796C", hash_generated_field = "77B5EB3473D5B10089CC95C2ED94891E")

    boolean mIsInputViewShown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.387 -0400", hash_original_field = "1C10330016E3D1BDEB192DB6D2AE8892", hash_generated_field = "98EF9B06A59A7DC308ADD81484067F39")

    int mStatusIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.387 -0400", hash_original_field = "269EBC9196383CF7ED8E2C7FC1F02A76", hash_generated_field = "FD8B0612F7004ABC6C691A56C2D256FE")

    int mBackDisposition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.387 -0400", hash_original_field = "FA246E03DDB3F75A905A719A7A70B1A3", hash_generated_field = "F25E6A5ACF83E487D08AEE0325304099")

    final Insets mTmpInsets = new Insets();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.387 -0400", hash_original_field = "4BC786D43E92B4BEDC23ACC8C07672C0", hash_generated_field = "192CBA0F154C36DD2A24DDE2AD97DD40")

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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.387 -0400", hash_original_method = "1525492D8EE98BBF3E2138610F838AAF", hash_generated_method = "1525492D8EE98BBF3E2138610F838AAF")
    public InputMethodService ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.388 -0400", hash_original_method = "A950397745137F47AE3797B428EC17A0", hash_generated_method = "EB5BB912A6C4B247539EEAC49D0A3730")
    @Override
    public void setTheme(int theme) {
    if(mWindow != null)        
        {
            IllegalStateException var4780AE19C45A0D305239053345051F9A_1861126845 = new IllegalStateException("Must be called before onCreate()");
            var4780AE19C45A0D305239053345051F9A_1861126845.addTaint(taint);
            throw var4780AE19C45A0D305239053345051F9A_1861126845;
        } 
        mTheme = theme;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.389 -0400", hash_original_method = "A4061C51E6B315B625647A4DAEF1D932", hash_generated_method = "DE550ABE012B963890E5EA21805F7878")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.389 -0400", hash_original_method = "76EDD2B848D79265B59C656C09132FEB", hash_generated_method = "83EE169EF2FBBDAF4C6A06E84EF30B78")
    public void onInitializeInterface() {
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.390 -0400", hash_original_method = "F1A6BBC586CE4C5158D93D758F9EE4FD", hash_generated_method = "2E992143C8A8A5FEB72770AB798F0F87")
     void initialize() {
    if(!mInitialized)        
        {
            mInitialized = true;
            onInitializeInterface();
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.392 -0400", hash_original_method = "E6A2B0DBCD46A23062A8849E041DB211", hash_generated_method = "C9F3FD38CC9DC02895E3A0D8CADB0293")
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
    if(Settings.System.getInt(getContentResolver(),
                Settings.System.FANCY_IME_ANIMATIONS, 0) != 0)        
        {
            mWindow.getWindow().setWindowAnimations(
                    com.android.internal.R.style.Animation_InputMethodFancy);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.393 -0400", hash_original_method = "03BF0E4B83AB5EEC5EA04DACA2552646", hash_generated_method = "91DA585A45BAC6BEB0DD08E5DA580FB1")
    @Override
    public void onDestroy() {
        
        super.onDestroy();
        mRootView.getViewTreeObserver().removeOnComputeInternalInsetsListener(
                mInsetsComputer);
        finishViews();
    if(mWindowAdded)        
        {
            mWindow.getWindow().setWindowAnimations(0);
            mWindow.dismiss();
        } 
        
        
        
                
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.394 -0400", hash_original_method = "0B7AD8CA788BAE093A6DAEC0C292F050", hash_generated_method = "069D9E9E8C9C71C56C3FCF07911EADF7")
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        
        addTaint(newConfig.getTaint());
        super.onConfigurationChanged(newConfig);
        boolean visible = mWindowVisible;
        int showFlags = mShowInputFlags;
        boolean showingInput = mShowInputRequested;
        CompletionInfo[] completions = mCurCompletions;
        initViews();
        mInputViewStarted = false;
        mCandidatesViewStarted = false;
    if(mInputStarted)        
        {
            doStartInput(getCurrentInputConnection(),
                    getCurrentInputEditorInfo(), true);
        } 
    if(visible)        
        {
    if(showingInput)            
            {
    if(onShowInputRequested(showFlags, true))                
                {
                    showWindow(true);
    if(completions != null)                    
                    {
                        mCurCompletions = completions;
                        onDisplayCompletions(completions);
                    } 
                } 
                else
                {
                    hideWindow();
                } 
            } 
            else
    if(mCandidatesVisibility == View.VISIBLE)            
            {
                showWindow(false);
            } 
            else
            {
                hideWindow();
            } 
            boolean showing = onEvaluateInputViewShown();
            mImm.setImeWindowStatus(mToken, IME_ACTIVE | (showing ? IME_VISIBLE : 0),
                    mBackDisposition);
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.394 -0400", hash_original_method = "4C23D68F9AF6231E77018CB50F89B333", hash_generated_method = "174ADA4AEF88F4A9268679A6B6F8E1C7")
    @Override
    public AbstractInputMethodImpl onCreateInputMethodInterface() {
        
AbstractInputMethodImpl var08A86260C367C9350A210836476E2AEE_1490154772 =         new InputMethodImpl();
        var08A86260C367C9350A210836476E2AEE_1490154772.addTaint(taint);
        return var08A86260C367C9350A210836476E2AEE_1490154772;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.395 -0400", hash_original_method = "A293E788F38BE631F0B24DA3CBEC4EAD", hash_generated_method = "F4874815DC2D01EE70C21D9DF7BC53D5")
    @Override
    public AbstractInputMethodSessionImpl onCreateInputMethodSessionInterface() {
        
AbstractInputMethodSessionImpl var1FADAA1D32C6DE5E050A6B41B4394530_1003976303 =         new InputMethodSessionImpl();
        var1FADAA1D32C6DE5E050A6B41B4394530_1003976303.addTaint(taint);
        return var1FADAA1D32C6DE5E050A6B41B4394530_1003976303;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.395 -0400", hash_original_method = "F107DE3A8547E443866FF02369203993", hash_generated_method = "739EFAB2F7E9BB74B17D1DACA4D007CB")
    public LayoutInflater getLayoutInflater() {
LayoutInflater varBB634655A97E6A29040AA54B59F0E4B4_836255987 =         mInflater;
        varBB634655A97E6A29040AA54B59F0E4B4_836255987.addTaint(taint);
        return varBB634655A97E6A29040AA54B59F0E4B4_836255987;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.395 -0400", hash_original_method = "B35683FF457638BA2516208C83F2FBFC", hash_generated_method = "B328B25887577415F05BDE81C9916D9E")
    public Dialog getWindow() {
Dialog var125511BCCBD4CDF7BDF315F5AA8A1CE3_477574223 =         mWindow;
        var125511BCCBD4CDF7BDF315F5AA8A1CE3_477574223.addTaint(taint);
        return var125511BCCBD4CDF7BDF315F5AA8A1CE3_477574223;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.396 -0400", hash_original_method = "4B38ED63C74A7D25A43EF42301FB70B0", hash_generated_method = "46A6C22207C263E445ACBEE325B9DE9D")
    public void setBackDisposition(int disposition) {
        mBackDisposition = disposition;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.396 -0400", hash_original_method = "FA0668AA74F2A3E40C75CD8A8BEC8D4A", hash_generated_method = "D4DE3DDDAFE61ACCA3CAC1A765153124")
    public int getBackDisposition() {
        int var269EBC9196383CF7ED8E2C7FC1F02A76_748793333 = (mBackDisposition);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_631854148 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_631854148;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.397 -0400", hash_original_method = "BF0CCCE3A6DFBF869485401A0C0B52E1", hash_generated_method = "7AF505910DA8CD7C97794ED9E8D5D495")
    public int getMaxWidth() {
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        int var1892FF12D3EF72B41E7039187F4994E3_394385598 = (wm.getDefaultDisplay().getWidth());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1840961600 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1840961600;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.397 -0400", hash_original_method = "064CBE2A131D4B226EADDD6A40CEAEED", hash_generated_method = "FAA1B0779E2201238F2C1BD5DE7119CB")
    public InputBinding getCurrentInputBinding() {
InputBinding var80D3E666E1B428092EF4D2EE1FC65902_557114914 =         mInputBinding;
        var80D3E666E1B428092EF4D2EE1FC65902_557114914.addTaint(taint);
        return var80D3E666E1B428092EF4D2EE1FC65902_557114914;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.398 -0400", hash_original_method = "25EFF753F3CF5167178BD7379B9659BF", hash_generated_method = "8C688846F9CE10DAC50EECA2391C9A01")
    public InputConnection getCurrentInputConnection() {
        InputConnection ic = mStartedInputConnection;
    if(ic != null)        
        {
InputConnection varFD8C2BFAAD563C33D901EC24EE14B2AE_2106445558 =             ic;
            varFD8C2BFAAD563C33D901EC24EE14B2AE_2106445558.addTaint(taint);
            return varFD8C2BFAAD563C33D901EC24EE14B2AE_2106445558;
        } 
InputConnection var4E6D77A4EF0AFC8258855CE0F0323BD2_16978970 =         mInputConnection;
        var4E6D77A4EF0AFC8258855CE0F0323BD2_16978970.addTaint(taint);
        return var4E6D77A4EF0AFC8258855CE0F0323BD2_16978970;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.398 -0400", hash_original_method = "26F207E076BC370412C35CB8C7E97837", hash_generated_method = "29649E1723A1C34A211DCCDD77D0334F")
    public boolean getCurrentInputStarted() {
        boolean var782D39EBDAC05F2DB212AB8342884C64_465683984 = (mInputStarted);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_974527943 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_974527943;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.398 -0400", hash_original_method = "659C592D4ABB3DB82261D1C4692ABF2E", hash_generated_method = "13C61517D461C88538126BCC6912732C")
    public EditorInfo getCurrentInputEditorInfo() {
EditorInfo varDE36ACD7348A513234260C9526EF31CC_1510763705 =         mInputEditorInfo;
        varDE36ACD7348A513234260C9526EF31CC_1510763705.addTaint(taint);
        return varDE36ACD7348A513234260C9526EF31CC_1510763705;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.401 -0400", hash_original_method = "27763B4939D9D4CE4F4BEBC3E63AF469", hash_generated_method = "462FDB7CE5662124CC7AA8A2B2DA7757")
    public void updateFullscreenMode() {
        boolean isFullscreen = mShowInputRequested && onEvaluateFullscreenMode();
        boolean changed = mLastShowInputRequested != mShowInputRequested;
    if(mIsFullscreen != isFullscreen || !mFullscreenApplied)        
        {
            changed = true;
            mIsFullscreen = isFullscreen;
            InputConnection ic = getCurrentInputConnection();
    if(ic != null)            
            ic.reportFullscreenMode(isFullscreen);
            mFullscreenApplied = true;
            initialize();
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams)
                    mFullscreenArea.getLayoutParams();
    if(isFullscreen)            
            {
                mFullscreenArea.setBackgroundDrawable(mThemeAttrs.getDrawable(
                        com.android.internal.R.styleable.InputMethodService_imeFullscreenBackground));
                lp.height = 0;
                lp.weight = 1;
            } 
            else
            {
                mFullscreenArea.setBackgroundDrawable(null);
                lp.height = LinearLayout.LayoutParams.WRAP_CONTENT;
                lp.weight = 0;
            } 
            ((ViewGroup)mFullscreenArea.getParent()).updateViewLayout(
                    mFullscreenArea, lp);
    if(isFullscreen)            
            {
    if(mExtractView == null)                
                {
                    View v = onCreateExtractTextView();
    if(v != null)                    
                    {
                        setExtractView(v);
                    } 
                } 
                startExtractingText(false);
            } 
            updateExtractFrameVisibility();
        } 
    if(changed)        
        {
            onConfigureWindow(mWindow.getWindow(), isFullscreen, !mShowInputRequested);
            mLastShowInputRequested = mShowInputRequested;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.402 -0400", hash_original_method = "57F13E10195CB2F326F03FED8DB64B03", hash_generated_method = "FFE0014724DA501F667090D5DBA06455")
    public void onConfigureWindow(Window win, boolean isFullscreen,
            boolean isCandidatesOnly) {
        
        addTaint(isCandidatesOnly);
        addTaint(isFullscreen);
        addTaint(win.getTaint());
    if(isFullscreen)        
        {
            mWindow.getWindow().setLayout(MATCH_PARENT, MATCH_PARENT);
        } 
        else
        {
            mWindow.getWindow().setLayout(MATCH_PARENT, WRAP_CONTENT);
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.402 -0400", hash_original_method = "0B558CA7980DF9D2EBB981E6DDF5DF60", hash_generated_method = "F7157B9336823DC64B0B934D0DB0261C")
    public boolean isFullscreenMode() {
        boolean var54AB7B409DAEC84F47F83754E82B9CF7_1366843454 = (mIsFullscreen);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1262169556 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1262169556;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.402 -0400", hash_original_method = "F5927891A0B192B06619C4589486FDC4", hash_generated_method = "8BC0F2F1191E1FEE612E30C1C791A144")
    public boolean onEvaluateFullscreenMode() {
        
        Configuration config = getResources().getConfiguration();
    if(config.orientation != Configuration.ORIENTATION_LANDSCAPE)        
        {
            boolean var68934A3E9455FA72420237EB05902327_610492071 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_61327068 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_61327068;
        } 
    if(mInputEditorInfo != null
                && (mInputEditorInfo.imeOptions & EditorInfo.IME_FLAG_NO_FULLSCREEN) != 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_22041297 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_835786576 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_835786576;
        } 
        boolean varB326B5062B2F0E69046810717534CB09_1154807379 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1041364888 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1041364888;
        
        
        
            
        
        
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.403 -0400", hash_original_method = "D4950711A20DE11BC2C7EA5EC93FE5E0", hash_generated_method = "DF66FB83B011CC20BCA2CB153EA0D0B5")
    public void setExtractViewShown(boolean shown) {
    if(mExtractViewHidden == shown)        
        {
            mExtractViewHidden = !shown;
            updateExtractFrameVisibility();
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.403 -0400", hash_original_method = "DE07F0C980519D51E427F21507DA3D90", hash_generated_method = "FD8713B4BFB2B6525773810A65A3A3A1")
    public boolean isExtractViewShown() {
        boolean var7EBB8050A18397C68B4A844043E116B9_813319552 = (mIsFullscreen && !mExtractViewHidden);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1309641579 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1309641579;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.404 -0400", hash_original_method = "7CD3F30CDD4A5DA751939DF09DB853BA", hash_generated_method = "B53B71D6010D007489E5A6BAF0BA7A17")
     void updateExtractFrameVisibility() {
        int vis;
    if(isFullscreenMode())        
        {
            vis = mExtractViewHidden ? View.INVISIBLE : View.VISIBLE;
            mExtractFrame.setVisibility(View.VISIBLE);
        } 
        else
        {
            vis = View.VISIBLE;
            mExtractFrame.setVisibility(View.GONE);
        } 
        updateCandidatesVisibility(mCandidatesVisibility == View.VISIBLE);
    if(mWindowWasVisible && mFullscreenArea.getVisibility() != vis)        
        {
            int animRes = mThemeAttrs.getResourceId(vis == View.VISIBLE
                    ? com.android.internal.R.styleable.InputMethodService_imeExtractEnterAnimation
                    : com.android.internal.R.styleable.InputMethodService_imeExtractExitAnimation,
                    0);
    if(animRes != 0)            
            {
                mFullscreenArea.startAnimation(AnimationUtils.loadAnimation(
                        this, animRes));
            } 
        } 
        mFullscreenArea.setVisibility(vis);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.405 -0400", hash_original_method = "46EC672E73C1227D1C1A9029A1E1F3EE", hash_generated_method = "DE0C5AE28292A2128828595657664569")
    public void onComputeInsets(Insets outInsets) {
        
        addTaint(outInsets.getTaint());
        int[] loc = mTmpLocation;
    if(mInputFrame.getVisibility() == View.VISIBLE)        
        {
            mInputFrame.getLocationInWindow(loc);
        } 
        else
        {
            View decor = getWindow().getWindow().getDecorView();
            loc[1] = decor.getHeight();
        } 
    if(isFullscreenMode())        
        {
            View decor = getWindow().getWindow().getDecorView();
            outInsets.contentTopInsets = decor.getHeight();
        } 
        else
        {
            outInsets.contentTopInsets = loc[1];
        } 
    if(mCandidatesFrame.getVisibility() == View.VISIBLE)        
        {
            mCandidatesFrame.getLocationInWindow(loc);
        } 
        outInsets.visibleTopInsets = loc[1];
        outInsets.touchableInsets = Insets.TOUCHABLE_INSETS_VISIBLE;
        outInsets.touchableRegion.setEmpty();
        
        
        
            
        
            
            
        
        
            
            
        
            
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.406 -0400", hash_original_method = "0265E8D9142690DEBAB6C995400C2A87", hash_generated_method = "1FCB171E81D54D406D446551D3AA93EC")
    public void updateInputViewShown() {
        boolean isShown = mShowInputRequested && onEvaluateInputViewShown();
    if(mIsInputViewShown != isShown && mWindowVisible)        
        {
            mIsInputViewShown = isShown;
            mInputFrame.setVisibility(isShown ? View.VISIBLE : View.GONE);
    if(mInputView == null)            
            {
                initialize();
                View v = onCreateInputView();
    if(v != null)                
                {
                    setInputView(v);
                } 
            } 
        } 
        
        
        
            
            
            
                
                
                
                    
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.406 -0400", hash_original_method = "CE1497EC29214CA28D281C89DC587F5D", hash_generated_method = "494AC60E2068D7472EE117B6B9DF2700")
    public boolean isShowInputRequested() {
        boolean var3130E5E55A7C8BB928012D0F32C408DB_1379475352 = (mShowInputRequested);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2108305911 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2108305911;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.406 -0400", hash_original_method = "FAB0B10F230F7249B0A5682A6CF03BDF", hash_generated_method = "BDB9BA36DC662DDC876F93DA8881D42D")
    public boolean isInputViewShown() {
        boolean var97A2465AE992C2C50338DC2E6F84E870_2082982044 = (mIsInputViewShown && mWindowVisible);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_972399803 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_972399803;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.407 -0400", hash_original_method = "1FE8D4523FDD0EE9294351AC86397C44", hash_generated_method = "7EC667009D21B85148E34D35CF4BF7BD")
    public boolean onEvaluateInputViewShown() {
        
        Configuration config = getResources().getConfiguration();
        boolean var08CE3848546D29F32E32A13D83C5EEA0_2021896391 = (config.keyboard == Configuration.KEYBOARD_NOKEYS
                || config.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_YES);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_316881423 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_316881423;
        
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.407 -0400", hash_original_method = "3ADC6F28D6F2E8A9F55D9BD9F82BC8D2", hash_generated_method = "915E2F6CAED711FA919748F746CC0DB9")
    public void setCandidatesViewShown(boolean shown) {
        addTaint(shown);
        updateCandidatesVisibility(shown);
    if(!mShowInputRequested && mWindowVisible != shown)        
        {
    if(shown)            
            {
                showWindow(false);
            } 
            else
            {
                hideWindow();
            } 
        } 
        
        
        
            
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.408 -0400", hash_original_method = "4164AC2B45DCCBE42C527D3F966F5882", hash_generated_method = "2C7A5718C42FD1BB553C30F6A418966F")
     void updateCandidatesVisibility(boolean shown) {
        addTaint(shown);
        int vis = shown ? View.VISIBLE : getCandidatesHiddenVisibility();
    if(mCandidatesVisibility != vis)        
        {
            mCandidatesFrame.setVisibility(vis);
            mCandidatesVisibility = vis;
        } 
        
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.408 -0400", hash_original_method = "587D3BCB04C3551F0F314F802D60C565", hash_generated_method = "7457C96E0AFE8ECF8208EFAE6E43782B")
    public int getCandidatesHiddenVisibility() {
        int var6645820E07724FB19B2C03771B652C5E_26863528 = (isExtractViewShown() ? View.GONE : View.INVISIBLE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1110873693 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1110873693;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.409 -0400", hash_original_method = "09F11407FBE421F2EB35629AC776C29A", hash_generated_method = "DECC09ED0847FD21887B434C8C7A2F55")
    public void showStatusIcon(int iconResId) {
        mStatusIcon = iconResId;
        mImm.showStatusIcon(mToken, getPackageName(), iconResId);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.409 -0400", hash_original_method = "F1217201D04BC19DA5F1842A9EA12AC0", hash_generated_method = "1FEC1D46E33E85CCE5B5210B4D8FEDD0")
    public void hideStatusIcon() {
        mStatusIcon = 0;
        mImm.hideStatusIcon(mToken);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.409 -0400", hash_original_method = "65B927BAD02A0A8652162D17880CBC94", hash_generated_method = "50EBCC303C732CC8EF98A84414B53AD9")
    public void switchInputMethod(String id) {
        addTaint(id.getTaint());
        mImm.setInputMethod(mToken, id);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.411 -0400", hash_original_method = "7F30721F4F1DC6518EC25FA69EEA9DD8", hash_generated_method = "5BB12EC3A3622DEE5E148540ED32D6FF")
    public void setExtractView(View view) {
        mExtractFrame.removeAllViews();
        mExtractFrame.addView(view, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        mExtractView = view;
    if(view != null)        
        {
            mExtractEditText = (ExtractEditText)view.findViewById(
                    com.android.internal.R.id.inputExtractEditText);
            mExtractEditText.setIME(this);
            mExtractAction = (Button)view.findViewById(
                    com.android.internal.R.id.inputExtractAction);
    if(mExtractAction != null)            
            {
                mExtractAccessories = (ViewGroup)view.findViewById(
                        com.android.internal.R.id.inputExtractAccessories);
            } 
            startExtractingText(false);
        } 
        else
        {
            mExtractEditText = null;
            mExtractAccessories = null;
            mExtractAction = null;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.411 -0400", hash_original_method = "8648EAF39F078D77783E311D9636B394", hash_generated_method = "DB97C87789E247BEBC292B2ADE91552F")
    public void setCandidatesView(View view) {
        addTaint(view.getTaint());
        mCandidatesFrame.removeAllViews();
        mCandidatesFrame.addView(view, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        
        
        
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.411 -0400", hash_original_method = "F530779F20B702B2AC3AEE15911FE235", hash_generated_method = "448C234ECEA41219ABFCADD0A5752A31")
    public void setInputView(View view) {
        mInputFrame.removeAllViews();
        mInputFrame.addView(view, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        mInputView = view;
        
        
        
                
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.412 -0400", hash_original_method = "A13C1AA9A5FD5770C02F503628C51194", hash_generated_method = "21D29B2AAC98E882A3586B2DC3845FFE")
    public View onCreateExtractTextView() {
        
View var0BB102B7CA77FB3FB1E4F707C8309F8C_442689571 =         mInflater.inflate(
                com.android.internal.R.layout.input_method_extract_view, null);
        var0BB102B7CA77FB3FB1E4F707C8309F8C_442689571.addTaint(taint);
        return var0BB102B7CA77FB3FB1E4F707C8309F8C_442689571;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.412 -0400", hash_original_method = "F89AAD61B39578A3862B8537E7226DB5", hash_generated_method = "EEDEFFCCC2D498A373502F8898D79347")
    public View onCreateCandidatesView() {
        
View var540C13E9E156B687226421B24F2DF178_1580982967 =         null;
        var540C13E9E156B687226421B24F2DF178_1580982967.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1580982967;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.412 -0400", hash_original_method = "75C53F9A7550BADCC3EEC67DE46E8BC4", hash_generated_method = "5DD45CF30AECD358F8DD5B243DA3C686")
    public View onCreateInputView() {
        
View var540C13E9E156B687226421B24F2DF178_465592785 =         null;
        var540C13E9E156B687226421B24F2DF178_465592785.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_465592785;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.413 -0400", hash_original_method = "4B7A497965AEC42ECF0C79E271F7AFEF", hash_generated_method = "FFB0C9E7EF36E80060D7F875A83DB84E")
    public void onStartInputView(EditorInfo info, boolean restarting) {
        
        addTaint(restarting);
        addTaint(info.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.413 -0400", hash_original_method = "126397FC018D546EBB3D17AA8B426F4F", hash_generated_method = "8F5DFA1DA3E2FD2AABD7C18F4AAB50D9")
    public void onFinishInputView(boolean finishingInput) {
        
        addTaint(finishingInput);
    if(!finishingInput)        
        {
            InputConnection ic = getCurrentInputConnection();
    if(ic != null)            
            {
                ic.finishComposingText();
            } 
        } 
        
        
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.413 -0400", hash_original_method = "C1D318033051A63629AB7F18935A055B", hash_generated_method = "38C02957D4ACA7572BE311F372CE198B")
    public void onStartCandidatesView(EditorInfo info, boolean restarting) {
        
        addTaint(restarting);
        addTaint(info.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.414 -0400", hash_original_method = "7B21B5BD050EBE81B79EA707D7F10503", hash_generated_method = "9F3065DCD4D8B3D7D39BB911F2740E41")
    public void onFinishCandidatesView(boolean finishingInput) {
        
        addTaint(finishingInput);
    if(!finishingInput)        
        {
            InputConnection ic = getCurrentInputConnection();
    if(ic != null)            
            {
                ic.finishComposingText();
            } 
        } 
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.414 -0400", hash_original_method = "7116B74C32B9543E489CB78AF9B82E3D", hash_generated_method = "08FBF743BC8ECAA5B7A0335FA4464117")
    public boolean onShowInputRequested(int flags, boolean configChange) {
        
        addTaint(configChange);
        addTaint(flags);
    if(!onEvaluateInputViewShown())        
        {
            boolean var68934A3E9455FA72420237EB05902327_676416201 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1335502518 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1335502518;
        } 
    if((flags&InputMethod.SHOW_EXPLICIT) == 0)        
        {
    if(!configChange && onEvaluateFullscreenMode())            
            {
                boolean var68934A3E9455FA72420237EB05902327_1049046703 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1229404778 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1229404778;
            } 
            Configuration config = getResources().getConfiguration();
    if(config.keyboard != Configuration.KEYBOARD_NOKEYS)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1561850943 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_407523629 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_407523629;
            } 
        } 
    if((flags&InputMethod.SHOW_FORCED) != 0)        
        {
            mShowInputForced = true;
        } 
        boolean varB326B5062B2F0E69046810717534CB09_2075300149 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1139533005 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1139533005;
        
        
            
        
        
            
                
            
            
            
                
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.416 -0400", hash_original_method = "119016FA69877024FD5AD688A6BA764A", hash_generated_method = "5822A8D264D4FDDF19E08919EA6060CC")
    public void showWindow(boolean showInput) {
        addTaint(showInput);
    if(DEBUG){ }    if(mInShowWindow)        
        {
            return;
        } 
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
        
        
                
                
                
                
                
        
            
            
        
        
            
            
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.417 -0400", hash_original_method = "CB135560325B3F8C18497A9052C17028", hash_generated_method = "F5C86D60951A57B64AD624DD812DD256")
     void showWindowInner(boolean showInput) {
        addTaint(showInput);
        boolean doShowInput = false;
        boolean wasVisible = mWindowVisible;
        mWindowVisible = true;
    if(!mShowInputRequested)        
        {
    if(mInputStarted)            
            {
    if(showInput)                
                {
                    doShowInput = true;
                    mShowInputRequested = true;
                } 
            } 
        } 
        else
        {
            showInput = true;
        } 
    if(DEBUG){ }        initialize();
        updateFullscreenMode();
        updateInputViewShown();
    if(!mWindowAdded || !mWindowCreated)        
        {
            mWindowAdded = true;
            mWindowCreated = true;
            initialize();
    if(DEBUG){ }            View v = onCreateCandidatesView();
    if(DEBUG){ }    if(v != null)            
            {
                setCandidatesView(v);
            } 
        } 
    if(mShowInputRequested)        
        {
    if(!mInputViewStarted)            
            {
    if(DEBUG){ }                mInputViewStarted = true;
                onStartInputView(mInputEditorInfo, false);
            } 
        } 
        else
    if(!mCandidatesViewStarted)        
        {
    if(DEBUG){ }            mCandidatesViewStarted = true;
            onStartCandidatesView(mInputEditorInfo, false);
        } 
    if(doShowInput)        
        {
            startExtractingText(false);
        } 
    if(!wasVisible)        
        {
    if(DEBUG){ }            mImm.setImeWindowStatus(mToken, IME_ACTIVE, mBackDisposition);
            onWindowShown();
            mWindow.show();
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.418 -0400", hash_original_method = "AE7818A6DC114C265A5A8660654BB926", hash_generated_method = "E92A22CBEC1EDD4A34526ED72FC9DB0C")
    private void finishViews() {
    if(mInputViewStarted)        
        {
    if(DEBUG){ }            onFinishInputView(false);
        } 
        else
    if(mCandidatesViewStarted)        
        {
    if(DEBUG){ }            onFinishCandidatesView(false);
        } 
        mInputViewStarted = false;
        mCandidatesViewStarted = false;
        
        
            
            
        
            
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.418 -0400", hash_original_method = "09134BCCF788D1D9024485AE6DA1693C", hash_generated_method = "14C8BCC1031877ACF4A6D5146B69A189")
    public void hideWindow() {
        finishViews();
        mImm.setImeWindowStatus(mToken, 0, mBackDisposition);
    if(mWindowVisible)        
        {
            mWindow.hide();
            mWindowVisible = false;
            onWindowHidden();
            mWindowWasVisible = false;
        } 
        
        
        
        
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.419 -0400", hash_original_method = "D99B15EAA68884714BB333A2583A0571", hash_generated_method = "E797350F14362CA554D013A5659543F1")
    public void onWindowShown() {
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.419 -0400", hash_original_method = "C1BA79DB491FC590F2A9A222970A46B9", hash_generated_method = "82493FCA94AEB547B2950C787893F07B")
    public void onWindowHidden() {
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.419 -0400", hash_original_method = "56BEE8816781B99E44028AA4DD49AFE8", hash_generated_method = "9A3D5E9EBB717318D195E3F6D8803AE5")
    public void onBindInput() {
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.420 -0400", hash_original_method = "D52B154580F2280F1D8D5CF7DCC6C0BF", hash_generated_method = "049C427B4927AA2DB3B5531ABC79BA72")
    public void onUnbindInput() {
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.420 -0400", hash_original_method = "3ADFFB39DB97C5354271962A42564DD7", hash_generated_method = "F9320E9C77C848C40DC2B8AECBFEE288")
    public void onStartInput(EditorInfo attribute, boolean restarting) {
        
        addTaint(restarting);
        addTaint(attribute.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.422 -0400", hash_original_method = "D870334B8409E203BCA5DBA60A032B6F", hash_generated_method = "5035D7365BD613704CD31AE005BCECF2")
     void doFinishInput() {
    if(mInputViewStarted)        
        {
    if(DEBUG){ }            onFinishInputView(true);
        } 
        else
    if(mCandidatesViewStarted)        
        {
    if(DEBUG){ }            onFinishCandidatesView(true);
        } 
        mInputViewStarted = false;
        mCandidatesViewStarted = false;
    if(mInputStarted)        
        {
    if(DEBUG){ }            onFinishInput();
        } 
        mInputStarted = false;
        mStartedInputConnection = null;
        mCurCompletions = null;
        
        
            
            
        
            
            
        
        
        
        
            
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.425 -0400", hash_original_method = "D70A8E32EEED9199B71D72D85567D543", hash_generated_method = "25E6AAA4773F5594DDF474F09A751E3D")
     void doStartInput(InputConnection ic, EditorInfo attribute, boolean restarting) {
        addTaint(restarting);
    if(!restarting)        
        {
            doFinishInput();
        } 
        mInputStarted = true;
        mStartedInputConnection = ic;
        mInputEditorInfo = attribute;
        initialize();
    if(DEBUG){ }        onStartInput(attribute, restarting);
    if(mWindowVisible)        
        {
    if(mShowInputRequested)            
            {
    if(DEBUG){ }                mInputViewStarted = true;
                onStartInputView(mInputEditorInfo, restarting);
                startExtractingText(true);
            } 
            else
    if(mCandidatesVisibility == View.VISIBLE)            
            {
    if(DEBUG){ }                mCandidatesViewStarted = true;
                onStartCandidatesView(mInputEditorInfo, restarting);
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.426 -0400", hash_original_method = "E745A863BE4D98B94E02F169B272F08C", hash_generated_method = "F6C0E15496665BA6B8691587C2E83DFB")
    public void onFinishInput() {
        
        InputConnection ic = getCurrentInputConnection();
    if(ic != null)        
        {
            ic.finishComposingText();
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.426 -0400", hash_original_method = "75C3F475CAD98FE8CF4A523C8BDA8BB1", hash_generated_method = "B39F7F3BEFB24E502F188051870EED91")
    public void onDisplayCompletions(CompletionInfo[] completions) {
        
        addTaint(completions[0].getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.427 -0400", hash_original_method = "CC541C375904CEFCC1DC228363FE0C44", hash_generated_method = "9963C2D13EF5751FB92B0CC7F74F2A39")
    public void onUpdateExtractedText(int token, ExtractedText text) {
        
        addTaint(token);
    if(mExtractedToken != token)        
        {
            return;
        } 
    if(text != null)        
        {
    if(mExtractEditText != null)            
            {
                mExtractedText = text;
                mExtractEditText.setExtractedText(text);
            } 
        } 
        
        
            
        
        
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.428 -0400", hash_original_method = "08F34B1B106CF5B01DE522670D82A3BC", hash_generated_method = "96089C8F45D4577FE9710747E5B9881D")
    public void onUpdateSelection(int oldSelStart, int oldSelEnd,
            int newSelStart, int newSelEnd,
            int candidatesStart, int candidatesEnd) {
        
        addTaint(candidatesEnd);
        addTaint(candidatesStart);
        addTaint(newSelEnd);
        addTaint(newSelStart);
        addTaint(oldSelEnd);
        addTaint(oldSelStart);
        final ExtractEditText eet = mExtractEditText;
    if(eet != null && isFullscreenMode() && mExtractedText != null)        
        {
            final int off = mExtractedText.startOffset;
            eet.startInternalChanges();
            newSelStart -= off;
            newSelEnd -= off;
            final int len = eet.getText().length();
    if(newSelStart < 0)            
            newSelStart = 0;
            else
    if(newSelStart > len)            
            newSelStart = len;
    if(newSelEnd < 0)            
            newSelEnd = 0;
            else
    if(newSelEnd > len)            
            newSelEnd = len;
            eet.setSelection(newSelStart, newSelEnd);
            eet.finishInternalChanges();
        } 
        
        
        
            
            
            
            
            
            
            
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.428 -0400", hash_original_method = "D49077B58DC986892621B88ACD9BF0F7", hash_generated_method = "87A26FC82293103A524EB821FB8B0059")
    public void onViewClicked(boolean focusChanged) {
        
        addTaint(focusChanged);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.429 -0400", hash_original_method = "F8EB5FE11A8138FB360940D74155758A", hash_generated_method = "4CB7960253167CFAAB602CD800822ACE")
    public void onUpdateCursor(Rect newCursor) {
        
        addTaint(newCursor.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.429 -0400", hash_original_method = "53762C81936F5FCD41F3F903406EE4C3", hash_generated_method = "5C5E62A715329EE6C45F4A1DEC3FE6E6")
    public void requestHideSelf(int flags) {
        addTaint(flags);
        mImm.hideSoftInputFromInputMethod(mToken, flags);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.429 -0400", hash_original_method = "939E9922D22E9C6523AEB259C97CBC65", hash_generated_method = "325D0DF6830A0F7C7CDA8BE6EFE8071F")
    private void requestShowSelf(int flags) {
        addTaint(flags);
        mImm.showSoftInputFromInputMethod(mToken, flags);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.430 -0400", hash_original_method = "2F1E84CCA4C2BB5EFB606DA289F60F64", hash_generated_method = "B5E17E2C3BBFE1D4BAB9187C70D86B4D")
    private boolean handleBack(boolean doIt) {
        addTaint(doIt);
    if(mShowInputRequested)        
        {
    if(isExtractViewShown() && mExtractView instanceof ExtractEditLayout)            
            {
                ExtractEditLayout extractEditLayout = (ExtractEditLayout) mExtractView;
    if(extractEditLayout.isActionModeStarted())                
                {
    if(doIt)                    
                    extractEditLayout.finishActionMode();
                    boolean varB326B5062B2F0E69046810717534CB09_1548868392 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1304776975 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1304776975;
                } 
            } 
    if(doIt)            
            requestHideSelf(0);
            boolean varB326B5062B2F0E69046810717534CB09_247077991 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1673180718 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1673180718;
        } 
        else
    if(mWindowVisible)        
        {
    if(mCandidatesVisibility == View.VISIBLE)            
            {
    if(doIt)                
                setCandidatesViewShown(false);
            } 
            else
            {
    if(doIt)                
                hideWindow();
            } 
            boolean varB326B5062B2F0E69046810717534CB09_340314351 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_664019253 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_664019253;
        } 
        boolean var68934A3E9455FA72420237EB05902327_1105443163 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1041310577 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1041310577;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.430 -0400", hash_original_method = "6D39318911C6DEDF33A28EA4D06A473F", hash_generated_method = "16C5EF3C029351ABA007E8EFC894B4F6")
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        
        addTaint(event.getTaint());
        addTaint(keyCode);
    if(event.getKeyCode() == KeyEvent.KEYCODE_BACK)        
        {
    if(handleBack(false))            
            {
                event.startTracking();
                boolean varB326B5062B2F0E69046810717534CB09_1422253812 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1288519359 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1288519359;
            } 
            boolean var68934A3E9455FA72420237EB05902327_2001749504 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_972800913 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_972800913;
        } 
        boolean var9134241729F26A9A721BC05A77DEC929_1719885786 = (doMovementKey(keyCode, event, MOVEMENT_DOWN));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_692526985 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_692526985;
        
        
            
                
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.431 -0400", hash_original_method = "2A75FF2C44C4D96068DDAFC2643F0C8B", hash_generated_method = "0E2999A7E6EF1ABADEB004661ED1D107")
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        
        addTaint(event.getTaint());
        addTaint(keyCode);
        boolean var68934A3E9455FA72420237EB05902327_1736231757 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1673679708 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1673679708;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.431 -0400", hash_original_method = "3CC4F52C9B71FCD2A0600FA46D6F06E5", hash_generated_method = "D45250C5FE34302EB73A1E0EB05CE183")
    public boolean onKeyMultiple(int keyCode, int count, KeyEvent event) {
        
        addTaint(event.getTaint());
        addTaint(count);
        addTaint(keyCode);
        boolean var984662E9B0907B30F3EBB9FEBA0EBF01_266400161 = (doMovementKey(keyCode, event, count));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1941269169 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1941269169;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.432 -0400", hash_original_method = "BCD4505881DB97C910099D82B7A22807", hash_generated_method = "7ACB9953DB942A62190883529A803D5A")
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        
        addTaint(event.getTaint());
        addTaint(keyCode);
    if(event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.isTracking()
                && !event.isCanceled())        
        {
            boolean varD91C57D5338B3A1EBEB44EB1267D75DA_982578784 = (handleBack(true));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_24784845 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_24784845;
        } 
        boolean var255C823CBD3C9C5CB3C8D981B4016086_486645349 = (doMovementKey(keyCode, event, MOVEMENT_UP));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_250355909 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_250355909;
        
        
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.432 -0400", hash_original_method = "4A983FDB3FF481E2165B7D8D641CDD48", hash_generated_method = "0583D86EFC7B01EAD1A3E6B4EDFFBEE5")
    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        
        addTaint(event.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_425799201 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_443837906 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_443837906;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.433 -0400", hash_original_method = "E2F219F9B605C6393794145B9C28D4D7", hash_generated_method = "6544F77778EE38C3B5129E0AF8FAC193")
    public void onAppPrivateCommand(String action, Bundle data) {
        
        addTaint(data.getTaint());
        addTaint(action.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.433 -0400", hash_original_method = "F1BA2156F30663683BD63E2F68C8FA5C", hash_generated_method = "606E6A9FE627571F9EF77D44BDD59D8E")
    private void onToggleSoftInput(int showFlags, int hideFlags) {
        addTaint(hideFlags);
        addTaint(showFlags);
    if(DEBUG){ }    if(isInputViewShown())        
        {
            requestHideSelf(hideFlags);
        } 
        else
        {
            requestShowSelf(showFlags);
        } 
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.434 -0400", hash_original_method = "9C1F09BC7693D3503A84F47A8DD2E9B8", hash_generated_method = "47EA8DAA12928F120D2AE14ED887A6E5")
     void reportExtractedMovement(int keyCode, int count) {
        addTaint(count);
        addTaint(keyCode);
        int dx = 0;
        int dy = 0;
switch(keyCode){
        case KeyEvent.KEYCODE_DPAD_LEFT:
        dx = -count;
        break;
        case KeyEvent.KEYCODE_DPAD_RIGHT:
        dx = count;
        break;
        case KeyEvent.KEYCODE_DPAD_UP:
        dy = -count;
        break;
        case KeyEvent.KEYCODE_DPAD_DOWN:
        dy = count;
        break;
}        onExtractedCursorMovement(dx, dy);
        
        
        
            
                
                
            
                
                
            
                
                
            
                
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.435 -0400", hash_original_method = "CADA6E3534C513A6E5A0D2EB184E3B48", hash_generated_method = "9A6A0C8CF6B619B38F67BA6BCFEEA644")
     boolean doMovementKey(int keyCode, KeyEvent event, int count) {
        addTaint(count);
        addTaint(event.getTaint());
        addTaint(keyCode);
        final ExtractEditText eet = mExtractEditText;
    if(isExtractViewShown() && isInputViewShown() && eet != null)        
        {
            MovementMethod movement = eet.getMovementMethod();
            Layout layout = eet.getLayout();
    if(movement != null && layout != null)            
            {
    if(count == MOVEMENT_DOWN)                
                {
    if(movement.onKeyDown(eet,
                            (Spannable)eet.getText(), keyCode, event))                    
                    {
                        reportExtractedMovement(keyCode, 1);
                        boolean varB326B5062B2F0E69046810717534CB09_1330590954 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1531804635 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1531804635;
                    } 
                } 
                else
    if(count == MOVEMENT_UP)                
                {
    if(movement.onKeyUp(eet,
                            (Spannable)eet.getText(), keyCode, event))                    
                    {
                        boolean varB326B5062B2F0E69046810717534CB09_1106931786 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_554529989 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_554529989;
                    } 
                } 
                else
                {
    if(movement.onKeyOther(eet, (Spannable)eet.getText(), event))                    
                    {
                        reportExtractedMovement(keyCode, count);
                    } 
                    else
                    {
                        KeyEvent down = KeyEvent.changeAction(event, KeyEvent.ACTION_DOWN);
    if(movement.onKeyDown(eet,
                                (Spannable)eet.getText(), keyCode, down))                        
                        {
                            KeyEvent up = KeyEvent.changeAction(event, KeyEvent.ACTION_UP);
                            movement.onKeyUp(eet,
                                    (Spannable)eet.getText(), keyCode, up);
                            while
(--count > 0)                            
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
switch(keyCode){
            case KeyEvent.KEYCODE_DPAD_LEFT:
            case KeyEvent.KEYCODE_DPAD_RIGHT:
            case KeyEvent.KEYCODE_DPAD_UP:
            case KeyEvent.KEYCODE_DPAD_DOWN:
            boolean varB326B5062B2F0E69046810717534CB09_1891125449 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1396157267 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1396157267;
}
        } 
        boolean var68934A3E9455FA72420237EB05902327_1373283296 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1189096336 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1189096336;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.435 -0400", hash_original_method = "79E896FD8459E186D0AA684976DF9590", hash_generated_method = "D48F2F16FA87A368105E54CA7A29ED43")
    public void sendDownUpKeyEvents(int keyEventCode) {
        addTaint(keyEventCode);
        InputConnection ic = getCurrentInputConnection();
    if(ic == null)        
        return;
        long eventTime = SystemClock.uptimeMillis();
        ic.sendKeyEvent(new KeyEvent(eventTime, eventTime,
                KeyEvent.ACTION_DOWN, keyEventCode, 0, 0, KeyCharacterMap.VIRTUAL_KEYBOARD, 0,
                KeyEvent.FLAG_SOFT_KEYBOARD|KeyEvent.FLAG_KEEP_TOUCH_MODE));
        ic.sendKeyEvent(new KeyEvent(SystemClock.uptimeMillis(), eventTime,
                KeyEvent.ACTION_UP, keyEventCode, 0, 0, KeyCharacterMap.VIRTUAL_KEYBOARD, 0,
                KeyEvent.FLAG_SOFT_KEYBOARD|KeyEvent.FLAG_KEEP_TOUCH_MODE));
        
        
        
        
        
                
                
        
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.436 -0400", hash_original_method = "84DA6B1414DFECBCA6744FD6285B6A00", hash_generated_method = "C3B1F0324E919CC4D9BF0F1D9945C104")
    public boolean sendDefaultEditorAction(boolean fromEnterKey) {
        addTaint(fromEnterKey);
        EditorInfo ei = getCurrentInputEditorInfo();
    if(ei != null &&
                (!fromEnterKey || (ei.imeOptions &
                        EditorInfo.IME_FLAG_NO_ENTER_ACTION) == 0) &&
                (ei.imeOptions & EditorInfo.IME_MASK_ACTION) !=
                    EditorInfo.IME_ACTION_NONE)        
        {
            InputConnection ic = getCurrentInputConnection();
    if(ic != null)            
            {
                ic.performEditorAction(ei.imeOptions&EditorInfo.IME_MASK_ACTION);
            } 
            boolean varB326B5062B2F0E69046810717534CB09_1387973850 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1441405245 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1441405245;
        } 
        boolean var68934A3E9455FA72420237EB05902327_1800744283 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1099556735 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1099556735;
        
        
        
                
                        
                
                    
            
            
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.436 -0400", hash_original_method = "CB96ACC643B76CE6B3516B92D9424351", hash_generated_method = "27728BF6FD0545DCC7E0E9B0820574E0")
    public void sendKeyChar(char charCode) {
        addTaint(charCode);
switch(charCode){
        case '\n':
    if(!sendDefaultEditorAction(true))        
        {
            sendDownUpKeyEvents(KeyEvent.KEYCODE_ENTER);
        } 
        break;
        default:
    if(charCode >= '0' && charCode <= '9')        
        {
            sendDownUpKeyEvents(charCode - '0' + KeyEvent.KEYCODE_0);
        } 
        else
        {
            InputConnection ic = getCurrentInputConnection();
    if(ic != null)            
            {
                ic.commitText(String.valueOf((char) charCode), 1);
            } 
        } 
        break;
}
        
        
            
                
                    
                
                
            
                
                    
                
                    
                    
                        
                    
                
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.437 -0400", hash_original_method = "B848FD2302E48E43854FF3AB55ABE7CC", hash_generated_method = "C5440AA7CDC66462A57805E3CD8FAF16")
    public void onExtractedSelectionChanged(int start, int end) {
        
        addTaint(end);
        addTaint(start);
        InputConnection conn = getCurrentInputConnection();
    if(conn != null)        
        {
            conn.setSelection(start, end);
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.437 -0400", hash_original_method = "56B9FB82082DF66D8709DA9479270344", hash_generated_method = "9A236248B83B60F761D9AAD4CD8FCEE9")
    public void onExtractedDeleteText(int start, int end) {
        
        addTaint(end);
        addTaint(start);
        InputConnection conn = getCurrentInputConnection();
    if(conn != null)        
        {
            conn.setSelection(start, start);
            conn.deleteSurroundingText(0, end-start);
        } 
        
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.438 -0400", hash_original_method = "3752CFC0704EAA41A71F5FCC4C7F691D", hash_generated_method = "BDA3CE585D68C1190519CC6987E56002")
    public void onExtractedReplaceText(int start, int end, CharSequence text) {
        
        addTaint(text.getTaint());
        addTaint(end);
        addTaint(start);
        InputConnection conn = getCurrentInputConnection();
    if(conn != null)        
        {
            conn.setComposingRegion(start, end);
            conn.commitText(text, 1);
        } 
        
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.438 -0400", hash_original_method = "2386EADCDB176594EC064F3F20DE5D60", hash_generated_method = "FE2EFEBD73969F6F3D27B791CE80C00D")
    public void onExtractedSetSpan(Object span, int start, int end, int flags) {
        
        addTaint(flags);
        addTaint(end);
        addTaint(start);
        addTaint(span.getTaint());
        InputConnection conn = getCurrentInputConnection();
    if(conn != null)        
        {
    if(!conn.setSelection(start, end))            
            return;
            CharSequence text = conn.getSelectedText(InputConnection.GET_TEXT_WITH_STYLES);
    if(text instanceof Spannable)            
            {
                ((Spannable) text).setSpan(span, 0, text.length(), flags);
                conn.setComposingRegion(start, end);
                conn.commitText(text, 1);
            } 
        } 
        
        
        
            
            
            
                
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.439 -0400", hash_original_method = "672EAF0A2CC265CDC19E0FE05714B327", hash_generated_method = "704ED5F7F0649703ACF293905E8861B8")
    public void onExtractedTextClicked() {
        
    if(mExtractEditText == null)        
        {
            return;
        } 
    if(mExtractEditText.hasVerticalScrollBar())        
        {
            setCandidatesViewShown(false);
        } 
        
        
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.439 -0400", hash_original_method = "33B88CC3E792B5DBD4A2FEF9CD5D26B5", hash_generated_method = "D53B0101840BB64D4006C78F5EEFB51E")
    public void onExtractedCursorMovement(int dx, int dy) {
        
        addTaint(dy);
        addTaint(dx);
    if(mExtractEditText == null || dy == 0)        
        {
            return;
        } 
    if(mExtractEditText.hasVerticalScrollBar())        
        {
            setCandidatesViewShown(false);
        } 
        
        
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.440 -0400", hash_original_method = "FA4A3D7B1537F03835F5D4F28B4BC905", hash_generated_method = "E3B9E32540467604609C1BB3550E1A57")
    public boolean onExtractTextContextMenuItem(int id) {
        
        addTaint(id);
        InputConnection ic = getCurrentInputConnection();
    if(ic != null)        
        {
            ic.performContextMenuAction(id);
        } 
        boolean varB326B5062B2F0E69046810717534CB09_1283004782 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_978040223 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_978040223;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.440 -0400", hash_original_method = "9F91BE1CB3CE4671D110A2B57AE2570E", hash_generated_method = "F54700EE720B7D17579978E5F5C5EF25")
    public CharSequence getTextForImeAction(int imeOptions) {
        addTaint(imeOptions);
switch(imeOptions&EditorInfo.IME_MASK_ACTION){
        case EditorInfo.IME_ACTION_NONE:
CharSequence var540C13E9E156B687226421B24F2DF178_192352977 =         null;
        var540C13E9E156B687226421B24F2DF178_192352977.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_192352977;
        case EditorInfo.IME_ACTION_GO:
CharSequence var56950E8DD9B04AA058A6118EC1C342B5_2065294809 =         getText(com.android.internal.R.string.ime_action_go);
        var56950E8DD9B04AA058A6118EC1C342B5_2065294809.addTaint(taint);
        return var56950E8DD9B04AA058A6118EC1C342B5_2065294809;
        case EditorInfo.IME_ACTION_SEARCH:
CharSequence varC204A812BCAB0FABA7F91735725EB79E_1480336900 =         getText(com.android.internal.R.string.ime_action_search);
        varC204A812BCAB0FABA7F91735725EB79E_1480336900.addTaint(taint);
        return varC204A812BCAB0FABA7F91735725EB79E_1480336900;
        case EditorInfo.IME_ACTION_SEND:
CharSequence varC15B3AA0F9AB1304123D91AEFF995530_1838844414 =         getText(com.android.internal.R.string.ime_action_send);
        varC15B3AA0F9AB1304123D91AEFF995530_1838844414.addTaint(taint);
        return varC15B3AA0F9AB1304123D91AEFF995530_1838844414;
        case EditorInfo.IME_ACTION_NEXT:
CharSequence varA56DD3276FDFFAFBDD579785591B6718_340856332 =         getText(com.android.internal.R.string.ime_action_next);
        varA56DD3276FDFFAFBDD579785591B6718_340856332.addTaint(taint);
        return varA56DD3276FDFFAFBDD579785591B6718_340856332;
        case EditorInfo.IME_ACTION_DONE:
CharSequence var12466BF35D1A550C3016F8A538A06193_1665927493 =         getText(com.android.internal.R.string.ime_action_done);
        var12466BF35D1A550C3016F8A538A06193_1665927493.addTaint(taint);
        return var12466BF35D1A550C3016F8A538A06193_1665927493;
        case EditorInfo.IME_ACTION_PREVIOUS:
CharSequence var0BE6AF605580C955E1A245235C04869D_620454928 =         getText(com.android.internal.R.string.ime_action_previous);
        var0BE6AF605580C955E1A245235C04869D_620454928.addTaint(taint);
        return var0BE6AF605580C955E1A245235C04869D_620454928;
        default:
CharSequence var7CA95817A6D9656A122DEE239271F49F_342435722 =         getText(com.android.internal.R.string.ime_action_default);
        var7CA95817A6D9656A122DEE239271F49F_342435722.addTaint(taint);
        return var7CA95817A6D9656A122DEE239271F49F_342435722;
}
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.441 -0400", hash_original_method = "8796655A783A46466BACE236BCA7DD97", hash_generated_method = "6D15D443F6DCCA886CA0713181B0E7ED")
    public void onUpdateExtractingVisibility(EditorInfo ei) {
        
        addTaint(ei.getTaint());
    if(ei.inputType == InputType.TYPE_NULL ||
                (ei.imeOptions&EditorInfo.IME_FLAG_NO_EXTRACT_UI) != 0)        
        {
            setExtractViewShown(false);
            return;
        } 
        setExtractViewShown(true);
        
        
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.441 -0400", hash_original_method = "EAD47E132E9ECD3692FAA5C1AB9CEE12", hash_generated_method = "D9131D3AC40071C39F670C5CEBE0A68C")
    public void onUpdateExtractingViews(EditorInfo ei) {
        
        addTaint(ei.getTaint());
    if(!isExtractViewShown())        
        {
            return;
        } 
    if(mExtractAccessories == null)        
        {
            return;
        } 
        final boolean hasAction = ei.actionLabel != null || (
                (ei.imeOptions&EditorInfo.IME_MASK_ACTION) != EditorInfo.IME_ACTION_NONE &&
                (ei.imeOptions&EditorInfo.IME_FLAG_NO_ACCESSORY_ACTION) == 0 &&
                ei.inputType != InputType.TYPE_NULL);
    if(hasAction)        
        {
            mExtractAccessories.setVisibility(View.VISIBLE);
    if(mExtractAction != null)            
            {
    if(ei.actionLabel != null)                
                {
                    mExtractAction.setText(ei.actionLabel);
                } 
                else
                {
                    mExtractAction.setText(getTextForImeAction(ei.imeOptions));
                } 
                mExtractAction.setOnClickListener(mActionClickListener);
            } 
        } 
        else
        {
            mExtractAccessories.setVisibility(View.GONE);
    if(mExtractAction != null)            
            {
                mExtractAction.setOnClickListener(null);
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.442 -0400", hash_original_method = "B8550D5274B7AC063AD577912E9B5BF9", hash_generated_method = "DA826CC3DA9DA6E0BBF57CDD3753273F")
    public void onExtractingInputChanged(EditorInfo ei) {
        
        addTaint(ei.getTaint());
    if(ei.inputType == InputType.TYPE_NULL)        
        {
            requestHideSelf(InputMethodManager.HIDE_NOT_ALWAYS);
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.444 -0400", hash_original_method = "4C67EC88DE5F38ABAC11BF6FC64666D8", hash_generated_method = "8E43C919FD6DA1D6C732AD2E5BED8743")
     void startExtractingText(boolean inputChanged) {
        addTaint(inputChanged);
        final ExtractEditText eet = mExtractEditText;
    if(eet != null && getCurrentInputStarted()
                && isFullscreenMode())        
        {
            mExtractedToken++;
            ExtractedTextRequest req = new ExtractedTextRequest();
            req.token = mExtractedToken;
            req.flags = InputConnection.GET_TEXT_WITH_STYLES;
            req.hintMaxLines = 10;
            req.hintMaxChars = 10000;
            InputConnection ic = getCurrentInputConnection();
            mExtractedText = ic == null? null
                    : ic.getExtractedText(req, InputConnection.GET_EXTRACTED_TEXT_MONITOR);
    if(mExtractedText == null || ic == null)            
            {
            } 
            final EditorInfo ei = getCurrentInputEditorInfo();
            try 
            {
                eet.startInternalChanges();
                onUpdateExtractingVisibility(ei);
                onUpdateExtractingViews(ei);
                int inputType = ei.inputType;
    if((inputType&EditorInfo.TYPE_MASK_CLASS)
                        == EditorInfo.TYPE_CLASS_TEXT)                
                {
    if((inputType&EditorInfo.TYPE_TEXT_FLAG_IME_MULTI_LINE) != 0)                    
                    {
                        inputType |= EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE;
                    } 
                } 
                eet.setInputType(inputType);
                eet.setHint(ei.hintText);
    if(mExtractedText != null)                
                {
                    eet.setEnabled(true);
                    eet.setExtractedText(mExtractedText);
                } 
                else
                {
                    eet.setEnabled(false);
                    eet.setText("");
                } 
            } 
            finally 
            {
                eet.finishInternalChanges();
            } 
    if(inputChanged)            
            {
                onExtractingInputChanged(ei);
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.445 -0400", hash_original_method = "18DCEDE4996E63CB2DB494AAC7CE4961", hash_generated_method = "3346D95BBCB52031345261A51E9463E3")
    protected void onCurrentInputMethodSubtypeChanged(InputMethodSubtype newSubtype) {
        
        addTaint(newSubtype.getTaint());
    if(DEBUG)        
        {
            int nameResId = newSubtype.getNameResId();
            String mode = newSubtype.getMode();
            String output = "changeInputMethodSubtype:"
                + (nameResId == 0 ? "<none>" : getString(nameResId)) + ","
                + mode + ","
                + newSubtype.getLocale() + "," + newSubtype.getExtraValue();
        } 
        
        
            
            
            
                
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.447 -0400", hash_original_method = "ABDAB14391C840F473C7CB9BB20D3C33", hash_generated_method = "DB04F3AC3386EDD5F3686968BF0788DB")
    @Override
    protected void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
        addTaint(args[0].getTaint());
        addTaint(fout.getTaint());
        addTaint(fd.getTaint());
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
    if(mInputEditorInfo != null)        
        {
            p.println("  mInputEditorInfo:");
            mInputEditorInfo.dump(p, "    ");
        } 
        else
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
    if(mExtractedText != null)        
        {
            p.println("  mExtractedText:");
            p.println("    text=" + mExtractedText.text.length() + " chars"
                    + " startOffset=" + mExtractedText.startOffset);
            p.println("    selectionStart=" + mExtractedText.selectionStart
                    + " selectionEnd=" + mExtractedText.selectionEnd
                    + " flags=0x" + Integer.toHexString(mExtractedText.flags));
        } 
        else
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
        
        
    }

    
    public class InputMethodImpl extends AbstractInputMethodImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.449 -0400", hash_original_method = "F0421074EFC32AA5D8F43C6593C3D141", hash_generated_method = "F0421074EFC32AA5D8F43C6593C3D141")
        public InputMethodImpl ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.450 -0400", hash_original_method = "2246D0F0FC59D2518EAEE0F0671903AA", hash_generated_method = "D45DDAA090A30410B38EFDBB46758F14")
        public void attachToken(IBinder token) {
            addTaint(token.getTaint());
    if(mToken == null)            
            {
                mToken = token;
                mWindow.setToken(token);
            } 
            
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.450 -0400", hash_original_method = "96E89AA7F2E1A70ABC64DBDE36024534", hash_generated_method = "10FB5BC623C37311A92E202E4DEDE444")
        public void bindInput(InputBinding binding) {
            addTaint(binding.getTaint());
            mInputBinding = binding;
            mInputConnection = binding.getConnection();
    if(DEBUG){ }            InputConnection ic = getCurrentInputConnection();
    if(ic != null)            
            ic.reportFullscreenMode(mIsFullscreen);
            initialize();
            onBindInput();
            
            
            
            
                    
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.451 -0400", hash_original_method = "5DFC78D3BA0A9E107E4BC0A877A8E6D3", hash_generated_method = "F7BF894A74224C30A2983A41841C64E3")
        public void unbindInput() {
    if(DEBUG){ }            onUnbindInput();
            mInputStarted = false;
            mInputBinding = null;
            mInputConnection = null;
            
            
                    
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.451 -0400", hash_original_method = "ABB2165AD965E17C2FE21B1141C40C8F", hash_generated_method = "8E2591220D78C8706A01CACB7AAF1A68")
        public void startInput(InputConnection ic, EditorInfo attribute) {
            addTaint(attribute.getTaint());
            addTaint(ic.getTaint());
    if(DEBUG){ }            doStartInput(ic, attribute, false);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.452 -0400", hash_original_method = "FBDDF384E0FE523BAEFE6359495BE0E1", hash_generated_method = "3CC0B7BDCCD2E6FF375D420BF7E9A6C7")
        public void restartInput(InputConnection ic, EditorInfo attribute) {
            addTaint(attribute.getTaint());
            addTaint(ic.getTaint());
    if(DEBUG){ }            doStartInput(ic, attribute, true);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.452 -0400", hash_original_method = "3A4CCDB7EB28BA706C897E348F128E61", hash_generated_method = "394AFAD675731B06914107290F7DB443")
        public void hideSoftInput(int flags, ResultReceiver resultReceiver) {
            addTaint(resultReceiver.getTaint());
            addTaint(flags);
    if(DEBUG){ }            boolean wasVis = isInputViewShown();
            mShowInputFlags = 0;
            mShowInputRequested = false;
            mShowInputForced = false;
            hideWindow();
    if(resultReceiver != null)            
            {
                resultReceiver.send(wasVis != isInputViewShown()
                        ? InputMethodManager.RESULT_HIDDEN
                        : (wasVis ? InputMethodManager.RESULT_UNCHANGED_SHOWN
                                : InputMethodManager.RESULT_UNCHANGED_HIDDEN), null);
            } 
            
            
            
            
            
            
            
            
                
                        
                        
                                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.453 -0400", hash_original_method = "FA726B6A215F3C1D91F0883D01FD2750", hash_generated_method = "9C978C9C87C2F3E80D1C5D9CF273289C")
        public void showSoftInput(int flags, ResultReceiver resultReceiver) {
            addTaint(resultReceiver.getTaint());
            addTaint(flags);
    if(DEBUG){ }            boolean wasVis = isInputViewShown();
            mShowInputFlags = 0;
    if(onShowInputRequested(flags, false))            
            {
                showWindow(true);
            } 
            boolean showing = onEvaluateInputViewShown();
            mImm.setImeWindowStatus(mToken, IME_ACTIVE | (showing ? IME_VISIBLE : 0),
                    mBackDisposition);
    if(resultReceiver != null)            
            {
                resultReceiver.send(wasVis != isInputViewShown()
                        ? InputMethodManager.RESULT_SHOWN
                        : (wasVis ? InputMethodManager.RESULT_UNCHANGED_SHOWN
                                : InputMethodManager.RESULT_UNCHANGED_HIDDEN), null);
            } 
            
            
            
            
            
                
            
            
            
                    
            
                
                        
                        
                                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.453 -0400", hash_original_method = "A5FC41682DA51C285C2C6651867F8D99", hash_generated_method = "AD0F9838ADFCD5E9A735172E5E52753B")
        public void changeInputMethodSubtype(InputMethodSubtype subtype) {
            addTaint(subtype.getTaint());
            onCurrentInputMethodSubtypeChanged(subtype);
            
            
        }

        
    }


    
    public class InputMethodSessionImpl extends AbstractInputMethodSessionImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.453 -0400", hash_original_method = "0FFA9D5BB925C1ECDC26428126FD587D", hash_generated_method = "0FFA9D5BB925C1ECDC26428126FD587D")
        public InputMethodSessionImpl ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.454 -0400", hash_original_method = "3439BC8F3B3DD615353E38FBC0555505", hash_generated_method = "D487826837656B16131F49B62294F226")
        public void finishInput() {
    if(!isEnabled())            
            {
                return;
            } 
    if(DEBUG){ }            doFinishInput();
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.454 -0400", hash_original_method = "6A0353E151F9F29333A27C5421A53B38", hash_generated_method = "037D94BE198DF9285BF306431E884D76")
        public void displayCompletions(CompletionInfo[] completions) {
            addTaint(completions[0].getTaint());
    if(!isEnabled())            
            {
                return;
            } 
            mCurCompletions = completions;
            onDisplayCompletions(completions);
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.454 -0400", hash_original_method = "0102DD0EEEDCD27552C577307A27FE88", hash_generated_method = "9341B35BBC6FE6B23F8C9373A4DD3557")
        public void updateExtractedText(int token, ExtractedText text) {
            addTaint(text.getTaint());
            addTaint(token);
    if(!isEnabled())            
            {
                return;
            } 
            onUpdateExtractedText(token, text);
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.455 -0400", hash_original_method = "8EA462F0F0CF12CBAE81AB6E28205A3D", hash_generated_method = "E9CC9C9AED9AC2115CDB5502E155031B")
        public void updateSelection(int oldSelStart, int oldSelEnd,
                int newSelStart, int newSelEnd,
                int candidatesStart, int candidatesEnd) {
            addTaint(candidatesEnd);
            addTaint(candidatesStart);
            addTaint(newSelEnd);
            addTaint(newSelStart);
            addTaint(oldSelEnd);
            addTaint(oldSelStart);
    if(!isEnabled())            
            {
                return;
            } 
            InputMethodService.this.onUpdateSelection(oldSelStart, oldSelEnd,
                    newSelStart, newSelEnd, candidatesStart, candidatesEnd);
            
            
                
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.455 -0400", hash_original_method = "7D0F3CDF004B0AA88B105A90C3B2EFF2", hash_generated_method = "FADD9EF40FAE28F8407CC82060C40417")
        @Override
        public void viewClicked(boolean focusChanged) {
            addTaint(focusChanged);
    if(!isEnabled())            
            {
                return;
            } 
            InputMethodService.this.onViewClicked(focusChanged);
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.456 -0400", hash_original_method = "5A756230FCCA173B557966360DF4EF77", hash_generated_method = "8A62272CB28CEDBE4CB0A429CB465DC7")
        public void updateCursor(Rect newCursor) {
            addTaint(newCursor.getTaint());
    if(!isEnabled())            
            {
                return;
            } 
            InputMethodService.this.onUpdateCursor(newCursor);
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.456 -0400", hash_original_method = "681E840BDEA7B80F2F006F7D9B6B3563", hash_generated_method = "0EDAEDA80081C06DD5173C3170577DAD")
        public void appPrivateCommand(String action, Bundle data) {
            addTaint(data.getTaint());
            addTaint(action.getTaint());
    if(!isEnabled())            
            {
                return;
            } 
            InputMethodService.this.onAppPrivateCommand(action, data);
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.457 -0400", hash_original_method = "F1C4F6A09FBC1E433445388BE149C06F", hash_generated_method = "A96535C15DB70059F025788A63C9C4FF")
        public void toggleSoftInput(int showFlags, int hideFlags) {
            addTaint(hideFlags);
            addTaint(showFlags);
            InputMethodService.this.onToggleSoftInput(showFlags, hideFlags);
            
            
        }

        
    }


    
    public static final class Insets {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.457 -0400", hash_original_field = "6B844646D0C6EADB76028E296D97D26E", hash_generated_field = "0848E8A3B2603B51400EBA2544607CD8")

        public int contentTopInsets;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.457 -0400", hash_original_field = "A2E8AB53B3DDAFAA3E389A47908EE03A", hash_generated_field = "4E5B62BB5E3FD9065410077ABCEFD6F5")

        public int visibleTopInsets;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.457 -0400", hash_original_field = "5CC4EAB992E3E01BAE580BFE4B7ACFD9", hash_generated_field = "F49DB2DF83C2B114A730FA19005C8733")

        public final Region touchableRegion = new Region();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.457 -0400", hash_original_field = "FB0951D59D942FF6CA5CA9E62DD65AED", hash_generated_field = "70DA720827DA3605384693EAE5E21AF8")

        public int touchableInsets;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.457 -0400", hash_original_method = "AB0F14C8125953D4D984387CD9B8D05E", hash_generated_method = "AB0F14C8125953D4D984387CD9B8D05E")
        public Insets ()
        {
            
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.457 -0400", hash_original_field = "A2BD6A2D2FAE4B0F2A6389403948A9DB", hash_generated_field = "A903B8D9E85FE8268399FAA8EA9A5E31")

        public static final int TOUCHABLE_INSETS_FRAME
                = ViewTreeObserver.InternalInsetsInfo.TOUCHABLE_INSETS_FRAME;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.457 -0400", hash_original_field = "A5CDA3247D70BA69B10B6C0010FDC255", hash_generated_field = "16D23B51E9664EA10F8919E161911777")

        public static final int TOUCHABLE_INSETS_CONTENT
                = ViewTreeObserver.InternalInsetsInfo.TOUCHABLE_INSETS_CONTENT;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.457 -0400", hash_original_field = "838E61A62623937065E74D6492529D84", hash_generated_field = "CFCF2141909DD954AF9ECFE0CCA49151")

        public static final int TOUCHABLE_INSETS_VISIBLE
                = ViewTreeObserver.InternalInsetsInfo.TOUCHABLE_INSETS_VISIBLE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.457 -0400", hash_original_field = "76E5A63ED3A610EE6AB6EB3A21422CFD", hash_generated_field = "2D48D24763A14D18AF2E1A2EBFB364B0")

        public static final int TOUCHABLE_INSETS_REGION
                = ViewTreeObserver.InternalInsetsInfo.TOUCHABLE_INSETS_REGION;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.458 -0400", hash_original_field = "4C210C59F731B7259273CB52E6EAB487", hash_generated_field = "9CF0118E5FF5051520996A9D15AE838E")

    static final String TAG = "InputMethodService";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.458 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "F09208C088E716A2CD36A97B937BB5EA")

    static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.458 -0400", hash_original_field = "2C29A4B5619C3A910834AA526BCE13BA", hash_generated_field = "4162B60B07B580ECBA3A261DC0CE993C")

    public static final int BACK_DISPOSITION_DEFAULT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.458 -0400", hash_original_field = "97E64829EE19D1C26581E470E551F6F1", hash_generated_field = "5EE67BE6E8CA7600A488D83901D53781")

    public static final int BACK_DISPOSITION_WILL_NOT_DISMISS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.458 -0400", hash_original_field = "203C7BC5EBC13AD8BC33775F4404CC44", hash_generated_field = "1CE0B7C8A6A795BBDBCCD6070E9E96CA")

    public static final int BACK_DISPOSITION_WILL_DISMISS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.458 -0400", hash_original_field = "0DDE1628212000DAF18C459BAEF81192", hash_generated_field = "911D20D022B12D5BDC027B47C99E815F")

    public static final int IME_ACTIVE = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.458 -0400", hash_original_field = "D1ECF6CE3C86B3EDFDFFA575C6C38827", hash_generated_field = "54453599413B853A6378E68D3D2217C5")

    public static final int IME_VISIBLE = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.458 -0400", hash_original_field = "F851B83995A9D4F3E431A958CAF5A8BE", hash_generated_field = "3B517107D2F173893643769189022B46")

    static final int MOVEMENT_DOWN = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.458 -0400", hash_original_field = "E702B70F996310DE47359709E5994159", hash_generated_field = "31973F9CFC4CEDE663F654F0137BD973")

    static final int MOVEMENT_UP = -2;
}

