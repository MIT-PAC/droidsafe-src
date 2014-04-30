package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ServiceManager;
import android.text.style.SuggestionSpan;
import android.util.Log;
import android.util.PrintWriterPrinter;
import android.util.Printer;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewRootImpl;

import com.android.internal.os.HandlerCaller;
import com.android.internal.view.IInputConnectionWrapper;
import com.android.internal.view.IInputContext;
import com.android.internal.view.IInputMethodCallback;
import com.android.internal.view.IInputMethodClient;
import com.android.internal.view.IInputMethodManager;
import com.android.internal.view.IInputMethodSession;
import com.android.internal.view.InputBindResult;

public final class InputMethodManager {

    /**
     * Retrieve the global InputMethodManager instance, creating it if it
     * doesn't already exist.
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.633 -0500", hash_original_method = "424A4B77F0AFDB65F3E66A3DDD55A926", hash_generated_method = "1687AC00C8A9CF972080C9248F12F34F")
    
static public InputMethodManager getInstance(Context context) {
        return getInstance(context.getMainLooper());
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    static public InputMethodManager getInstance(Looper mainLooper) {
        synchronized (mInstanceSync) {
            if (mInstance != null) {
                return mInstance;
            }
            /*
            IBinder b = ServiceManager.getService(Context.INPUT_METHOD_SERVICE);
            IInputMethodManager service = IInputMethodManager.Stub.asInterface(b);
            mInstance = new InputMethodManager(service, mainLooper);
            */
            mInstance = new InputMethodManager();

            ServiceManager.getService("");
        }
        return mInstance;
    }
    
    /**
     * Private optimization: retrieve the global InputMethodManager instance,
     * if it exists.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.638 -0500", hash_original_method = "86DD9C9F82F9BD6AD5A8C39BDF584DAA", hash_generated_method = "49F9C5CC68814F1F5518AD50E7ED92A0")
    
static public InputMethodManager peekInstance() {
        return mInstance;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.504 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "F09208C088E716A2CD36A97B937BB5EA")

    static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.507 -0500", hash_original_field = "0880DC04913189D15AF5AC7954F1CC5A", hash_generated_field = "FE423FA5D3056FFD91C65F642D943473")

    static final String TAG = "InputMethodManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.510 -0500", hash_original_field = "541AC6A543E5DDE4BA13B62C18B210B7", hash_generated_field = "8E1374FF2568A6E7DF58ACEEF1A2A836")

    static final Object mInstanceSync = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.513 -0500", hash_original_field = "1E8EE6D6CBCC39100FFEE331D06EF48B", hash_generated_field = "70278290516934488710CF458A67B14F")

    static InputMethodManager mInstance;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.577 -0500", hash_original_field = "58BEFE975A77EC3D2B230FE124E2FF63", hash_generated_field = "29E3688958B2990B4C392F7BA34B78FE")
    
    static final int MSG_DUMP = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.580 -0500", hash_original_field = "C2A7BBFEA502DBFB8E9B84CBDD9C0296", hash_generated_field = "00F2010EA24613AFCCBC353F90339FF1")

    static final int MSG_BIND = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.583 -0500", hash_original_field = "D3804971E53D1632009798B3677D158F", hash_generated_field = "4E6A324B7DC0A9F424DCDAA6789BFECC")

    static final int MSG_UNBIND = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.585 -0500", hash_original_field = "759E6BA7EB89CC6C48351E75D2D5878B", hash_generated_field = "28C1B3169E7E5F84C5E110F229FC0C97")

    static final int MSG_SET_ACTIVE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.692 -0500", hash_original_field = "5955FD7B4D5D654FF9B13DFC314457A7", hash_generated_field = "C03CF0054237DB2475EF4E292BEF892A")

    public static final int SHOW_IMPLICIT = 0x0001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.695 -0500", hash_original_field = "BF86EBE3C87B5975522DD2C29222798E", hash_generated_field = "7BA61FD409340B0C8E775EB75D40DCFF")

    public static final int SHOW_FORCED = 0x0002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.699 -0500", hash_original_field = "6711F578AA9906794F96E8E867E1A145", hash_generated_field = "6DE1572C40D7A706B1F6E877EF1C7AEA")

    public static final int RESULT_UNCHANGED_SHOWN = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.703 -0500", hash_original_field = "FAB25C29A3560A904C2059BB83B30504", hash_generated_field = "0D7072043387926ADE4C173684F81871")

    public static final int RESULT_UNCHANGED_HIDDEN = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.705 -0500", hash_original_field = "E9061F2AC5CD073BDB534009D7BB9EF2", hash_generated_field = "DA3162CDE4E12E374EB18AA57480909B")

    public static final int RESULT_SHOWN = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.707 -0500", hash_original_field = "59E217DC22EFA09B18EF333364C1B2BE", hash_generated_field = "32D8F39D75725376FDFC286B2EA27F45")

    public static final int RESULT_HIDDEN = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.715 -0500", hash_original_field = "FC4CE28D0FBFAFC48F48AE85BB1240D1", hash_generated_field = "58F91761BACAED73D8EF194F02D9EA57")

    public static final int HIDE_IMPLICIT_ONLY = 0x0001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.717 -0500", hash_original_field = "E0F25BADEA401E37290B1C9383A01B13", hash_generated_field = "03F311607F79D8F57E9DA6C29B046EF2")

    public static final int HIDE_NOT_ALWAYS = 0x0002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.515 -0500", hash_original_field = "AF4D994570007AEC23008412E21170BC", hash_generated_field = "AF4D994570007AEC23008412E21170BC")
    
     IInputMethodManager mService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.517 -0500", hash_original_field = "22AA67C96F8F7AD7DFD89E53DF216F9A", hash_generated_field = "22AA67C96F8F7AD7DFD89E53DF216F9A")

     Looper mMainLooper;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.520 -0500", hash_original_field = "4DD8CF7D1E2B224E6925E028DA6C7C60", hash_generated_field = "394574B6690699BBE21463234C10BAA7")

    // global lock.
     H mH;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.523 -0500", hash_original_field = "72027A70482354298567E3297708A343", hash_generated_field = "72027A70482354298567E3297708A343")

     IInputContext mIInputContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.525 -0500", hash_original_field = "844E46882A240B061C638C1091315129", hash_generated_field = "844E46882A240B061C638C1091315129")

    boolean mActive = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.534 -0500", hash_original_field = "7B2E6D1E4DF1C0EAF8EAE346683AD3D8", hash_generated_field = "7B2E6D1E4DF1C0EAF8EAE346683AD3D8")

    boolean mHasBeenInactive = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.536 -0500", hash_original_field = "7A6D29D78DDDB849117195D1575B1D0D", hash_generated_field = "7A6D29D78DDDB849117195D1575B1D0D")

    boolean mFullscreenMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.539 -0500", hash_original_field = "8610B5C69CA08D5F83A8EDAD499B41DF", hash_generated_field = "BD9E4743D5524AAE2A9CA10C0E8D34F5")
    
    /**
     * This is the root view of the overall window that currently has input
     * method focus.
     */
    View mCurRootView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.541 -0500", hash_original_field = "A54183C371A5C91679B93D582850D821", hash_generated_field = "A54183C371A5C91679B93D582850D821")

    View mServedView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.543 -0500", hash_original_field = "37CB9C3A74C8E8A1DCD593663CB659AC", hash_generated_field = "37CB9C3A74C8E8A1DCD593663CB659AC")

    View mNextServedView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.545 -0500", hash_original_field = "1CF172770CCCC42619E82625D27683E4", hash_generated_field = "1CF172770CCCC42619E82625D27683E4")

    boolean mNextServedNeedsStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.548 -0500", hash_original_field = "AA8EADE0DA95013FD81168358A40CC38", hash_generated_field = "AA8EADE0DA95013FD81168358A40CC38")

    boolean mServedConnecting;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.550 -0500", hash_original_field = "F6752A3676A98F8319F142BFE09A3814", hash_generated_field = "F6752A3676A98F8319F142BFE09A3814")

    EditorInfo mCurrentTextBoxAttribute;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.552 -0500", hash_original_field = "1069CCDD0BD720E7FA6763B4BE3FB768", hash_generated_field = "1069CCDD0BD720E7FA6763B4BE3FB768")

    InputConnection mServedInputConnection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.555 -0500", hash_original_field = "37C04B17B3D71E2A78D5E95F178E79E6", hash_generated_field = "37C04B17B3D71E2A78D5E95F178E79E6")

    CompletionInfo[] mCompletions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.557 -0500", hash_original_field = "79C750F90B6AC779C5BB9837C3C74CAB", hash_generated_field = "79C750F90B6AC779C5BB9837C3C74CAB")

    Rect mTmpCursorRect = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.559 -0500", hash_original_field = "49E12E0B9B02D82DC1E7BF4D1DC2791F", hash_generated_field = "49E12E0B9B02D82DC1E7BF4D1DC2791F")

    Rect mCursorRect = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.561 -0500", hash_original_field = "61370CAB7E613D3B51D5F05A3E7881EC", hash_generated_field = "61370CAB7E613D3B51D5F05A3E7881EC")

    int mCursorSelStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.564 -0500", hash_original_field = "EE54263B133ACFB15E11DD2491E1A3B9", hash_generated_field = "EE54263B133ACFB15E11DD2491E1A3B9")

    int mCursorSelEnd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.566 -0500", hash_original_field = "1CD08C23B7F290112A0ABF5F99E6CD72", hash_generated_field = "1CD08C23B7F290112A0ABF5F99E6CD72")

    int mCursorCandStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.568 -0500", hash_original_field = "BF24EA98ADDF2C881C86310B37BA9EE6", hash_generated_field = "BF24EA98ADDF2C881C86310B37BA9EE6")

    int mCursorCandEnd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.571 -0500", hash_original_field = "C983A711DB3B897D81814DB669E54903", hash_generated_field = "9762E6807C32AD2031CDDB1E17D9601F")
    
    /**
     * Sequence number of this binding, as returned by the server.
     */
    int mBindSequence = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.573 -0500", hash_original_field = "B8DB1FCD85A9BF1BC30DF0BD30881CBD", hash_generated_field = "B8DB1FCD85A9BF1BC30DF0BD30881CBD")

    String mCurId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.575 -0500", hash_original_field = "ECFDF7AD8578511D0EA7676517144A2F", hash_generated_field = "ECFDF7AD8578511D0EA7676517144A2F")

    IInputMethodSession mCurMethod;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.211 -0400", hash_original_field = "BCB122DBAEAD09474F3177A327270EA8", hash_generated_field = "7F61D375E432AF7DEA6AA6FB636235DA")

    final IInputMethodClient.Stub mClient = new IInputMethodClient.Stub() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.210 -0400", hash_original_method = "F6EA3706319B79FC567D288B23EBD7C8", hash_generated_method = "C657B985C982F7F1989F7F8E33AA9AB9")
        @Override
        protected void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
            CountDownLatch latch = new CountDownLatch(1);
            HandlerCaller.SomeArgs sargs = new HandlerCaller.SomeArgs();
            sargs.arg1 = fd;
            sargs.arg2 = fout;
            sargs.arg3 = args;
            sargs.arg4 = latch;
            mH.sendMessage(mH.obtainMessage(MSG_DUMP, sargs));
            try 
            {
                {
                    boolean var19E9A664FE2E8FD1F35B08B34B4A7B6E_1661286288 = (!latch.await(5, TimeUnit.SECONDS));
                    {
                        fout.println("Timeout waiting for dump");
                    } 
                } 
            } 
            catch (InterruptedException e)
            {
                fout.println("Interrupted waiting for dump");
            } 
            addTaint(fd.getTaint());
            addTaint(fout.getTaint());
            addTaint(args[0].getTaint());
            
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.210 -0400", hash_original_method = "45BD5FF75807911B1CFCFBB58E96318E", hash_generated_method = "E89AC6B358CC1D0E0E8D60BFEB3BF192")
        public void setUsingInputMethod(boolean state) {
            addTaint(state);
            
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.210 -0400", hash_original_method = "574FEF71BCEC075DFBB030A0D3C30C22", hash_generated_method = "2CC8A14340DD97B215BB7F37776C22E7")
        public void onBindMethod(InputBindResult res) {
            
            mH.sendMessage(mH.obtainMessage(MSG_BIND, res));
            addTaint(res.getTaint());
            
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.211 -0400", hash_original_method = "588CEEFF7FA7882256433E31043E7659", hash_generated_method = "93B331FAA4D44012CC809EFD07D72DC5")
        public void onUnbindMethod(int sequence) {
            
            mH.sendMessage(mH.obtainMessage(MSG_UNBIND, sequence, 0));
            addTaint(sequence);
            
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.211 -0400", hash_original_method = "348B3468B5EF750F568EE6741021F563", hash_generated_method = "F00801DE5796A4FB5DF1A8F8529ED1F9")
        public void setActive(boolean active) {
            mH.sendMessage(mH.obtainMessage(MSG_SET_ACTIVE, active ? 1 : 0, 0));
            addTaint(active);
            
        }
        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.628 -0500", hash_original_field = "857160D6CD8A26C79A4C0E2FBFA77DF6", hash_generated_field = "23E79A65143FCC7F6AFAF0A8EA3DFB92")
    
    final InputConnection mDummyInputConnection = new BaseInputConnection(this, false);
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.711 -0400", hash_original_method = "508ED56B5BF5DABABCAF5D12E61B17FA", hash_generated_method = "8F8CB7DD0282198FF166028847E17584")
      InputMethodManager(IInputMethodManager service, Looper looper) {
        mService = service;
        mMainLooper = looper;
        mH = new H(looper);
        mIInputContext = new ControlledInputConnectionWrapper(looper,
                mDummyInputConnection, this);
        if(mInstance == null)        
        {
            mInstance = this;
        } //End block
        addTaint(service.getTaint());
        addTaint(looper.getTaint());
        // ---------- Original Method ----------
        //mService = service;
        //mMainLooper = looper;
        //mH = new H(looper);
        //mIInputContext = new ControlledInputConnectionWrapper(looper,
                //mDummyInputConnection, this);
        //if (mInstance == null) {
            //mInstance = this;
        //}
    }
    
    //Hand modeling
    
    @DSSafe(DSCat.SAFE_OTHERS)
    public InputMethodManager() {
     
    }
    
    /** @hide */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.641 -0500", hash_original_method = "3D9C93A013E7DC300254687B6593E9DE", hash_generated_method = "23009FC047CD86B82991D738FC080ED1")
    
public IInputMethodClient getClient() {
        return mClient;
    }
    
    /** @hide */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.643 -0500", hash_original_method = "BB1CC2AA4E519DFF3D7BB1A17FAAA9A1", hash_generated_method = "574F1B58FB031FC8E0E4FE41A3FC2633")
    
public IInputContext getInputContext() {
        return mIInputContext;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.645 -0500", hash_original_method = "4976C1493B414917938FA9CF9C859341", hash_generated_method = "A5D9227E6D133148150212A1FC22F8BB")
    
public List<InputMethodInfo> getInputMethodList() {
        try {
            return mService.getInputMethodList();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.648 -0500", hash_original_method = "E8BA85FCD94534AA9F0D8586DC21C83A", hash_generated_method = "50223B28DCCF2DE4A8CD6995D00FCE60")
    
public List<InputMethodInfo> getEnabledInputMethodList() {
        try {
            return mService.getEnabledInputMethodList();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns a list of enabled input method subtypes for the specified input method info.
     * @param imi An input method info whose subtypes list will be returned.
     * @param allowsImplicitlySelectedSubtypes A boolean flag to allow to return the implicitly
     * selected subtypes. If an input method info doesn't have enabled subtypes, the framework
     * will implicitly enable subtypes according to the current system language.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.650 -0500", hash_original_method = "6701B30EF11ADDDCEFC97757F6DCE403", hash_generated_method = "B1FC0F4538A0653C57E850863F54776F")
    
public List<InputMethodSubtype> getEnabledInputMethodSubtypeList(InputMethodInfo imi,
            boolean allowsImplicitlySelectedSubtypes) {
        try {
            return mService.getEnabledInputMethodSubtypeList(imi, allowsImplicitlySelectedSubtypes);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.653 -0500", hash_original_method = "53B62C40B5B8B2FB3464E7DA6A87D443", hash_generated_method = "39AAFD501B3A89960E14AA34671739D8")
    
public void showStatusIcon(IBinder imeToken, String packageName, int iconId) {
        try {
            mService.updateStatusIcon(imeToken, packageName, iconId);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.655 -0500", hash_original_method = "D00BAF75C3098DFC4E35D122E494F4F9", hash_generated_method = "EADC47E24B05D4E84777E671317341DE")
    
public void hideStatusIcon(IBinder imeToken) {
        try {
            mService.updateStatusIcon(imeToken, null, 0);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /** @hide */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.658 -0500", hash_original_method = "7375BD73E964162AE893F10DF6DE4659", hash_generated_method = "318B4F18EE0F7E3AA06671365F6ECEC3")
    
public void setImeWindowStatus(IBinder imeToken, int vis, int backDisposition) {
        try {
            mService.setImeWindowStatus(imeToken, vis, backDisposition);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.660 -0500", hash_original_method = "E3510526CEDC6D4EEDFFA989F1389EB2", hash_generated_method = "1E952C56EF83C43AB408E0CF0083E125")
    
public void setFullscreenMode(boolean fullScreen) {
        mFullscreenMode = fullScreen;
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.663 -0500", hash_original_method = "CEA057AD7D0092E84D73E0D04E9F9DEE", hash_generated_method = "B2B12E7DFD23F1AE5523E2B5CD62DE2A")
    
public void registerSuggestionSpansForNotification(SuggestionSpan[] spans) {
        try {
            mService.registerSuggestionSpansForNotification(spans);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /** @hide */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.666 -0500", hash_original_method = "67AB3FB4ECE37955692BC451DD457E24", hash_generated_method = "8A649CE463E3FB6B3BEA7AD02D9CB5EB")
    
public void notifySuggestionPicked(SuggestionSpan span, String originalString, int index) {
        try {
            mService.notifySuggestionPicked(span, originalString, index);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Allows you to discover whether the attached input method is running
     * in fullscreen mode.  Return true if it is fullscreen, entirely covering
     * your UI, else returns false.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.668 -0500", hash_original_method = "FCDCA2DC24AB76EAA903F8369A9A45F8", hash_generated_method = "140974EC04E609A75C5B666C07BE566A")
    
public boolean isFullscreenMode() {
        return mFullscreenMode;
    }
    
    /**
     * Return true if the given view is the currently active view for the
     * input method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.671 -0500", hash_original_method = "BC82DFD48282D1B48FE7389621C80801", hash_generated_method = "6B0DE62B51607F4F37E369358662A8F2")
    
public boolean isActive(View view) {
        checkFocus();
        synchronized (mH) {
            return (mServedView == view
                    || (mServedView != null
                            && mServedView.checkInputConnectionProxy(view)))
                    && mCurrentTextBoxAttribute != null;
        }
    }
    
    /**
     * Return true if any view is currently active in the input method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.673 -0500", hash_original_method = "36DF2A9A4D9117D0F00790A34A3AF373", hash_generated_method = "62E2A730F9165FAE66790E3671D1E968")
    
public boolean isActive() {
        checkFocus();
        synchronized (mH) {
            return mServedView != null && mCurrentTextBoxAttribute != null;
        }
    }
    
    /**
     * Return true if the currently served view is accepting full text edits.
     * If false, it has no input connection, so can only handle raw key events.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.675 -0500", hash_original_method = "A9275A3C5F8B97D3BA22658E0542618D", hash_generated_method = "7665B655F99C9555F433E87E917F6A46")
    
public boolean isAcceptingText() {
        checkFocus();
        return mServedInputConnection != null;
    }

    /**
     * Reset all of the state associated with being bound to an input method.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.677 -0500", hash_original_method = "3A92950E40C3C85A49E393646C27AEA9", hash_generated_method = "3A92950E40C3C85A49E393646C27AEA9")
    
void clearBindingLocked() {
        clearConnectionLocked();
        mBindSequence = -1;
        mCurId = null;
        mCurMethod = null;
    }
    
    /**
     * Reset all of the state associated with a served view being connected
     * to an input method
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.679 -0500", hash_original_method = "7C74580464CD8E195E3FB8BED8B93C53", hash_generated_method = "7C74580464CD8E195E3FB8BED8B93C53")
    
void clearConnectionLocked() {
        mCurrentTextBoxAttribute = null;
        mServedInputConnection = null;
    }
    
    /**
     * Disconnect any existing input connection, clearing the served view.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.682 -0500", hash_original_method = "1D1918AFC608107C503CFA70B5918395", hash_generated_method = "AABF32DAB549552287D3114C5BC8E5FA")
    
void finishInputLocked() {
        mNextServedView = null;
        if (mServedView != null) {
            if (DEBUG) Log.v(TAG, "FINISH INPUT: " + mServedView);
            
            if (mCurrentTextBoxAttribute != null) {
                try {
                    mService.finishInput(mClient);
                } catch (RemoteException e) {
                }
            }
            
            if (mServedInputConnection != null) {
                // We need to tell the previously served view that it is no
                // longer the input target, so it can reset its state.  Schedule
                // this call on its window's Handler so it will be on the correct
                // thread and outside of our lock.
                Handler vh = mServedView.getHandler();
                if (vh != null) {
                    // This will result in a call to reportFinishInputConnection()
                    // below.
                    vh.sendMessage(vh.obtainMessage(ViewRootImpl.FINISH_INPUT_CONNECTION,
                            mServedInputConnection));
                }
            }
            
            mServedView = null;
            mCompletions = null;
            mServedConnecting = false;
            clearConnectionLocked();
        }
    }
    
    /**
     * Called from the FINISH_INPUT_CONNECTION message above.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.684 -0500", hash_original_method = "55A79A529B0E338884C3A2F27FEDBFDF", hash_generated_method = "F3F3A49CE991C3A7C442CD09347F8D6B")
    
public void reportFinishInputConnection(InputConnection ic) {
        if (mServedInputConnection != ic) {
            ic.finishComposingText();
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.687 -0500", hash_original_method = "2ABAAA397EA24F350376BE11BDE21CC8", hash_generated_method = "9FF55F3790D5D038AA02489AB1E93EEE")
    
public void displayCompletions(View view, CompletionInfo[] completions) {
        checkFocus();
        synchronized (mH) {
            if (mServedView != view && (mServedView == null
                            || !mServedView.checkInputConnectionProxy(view))) {
                return;
            }
            
            mCompletions = completions;
            if (mCurMethod != null) {
                try {
                    mCurMethod.displayCompletions(mCompletions);
                } catch (RemoteException e) {
                }
            }
        }
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.690 -0500", hash_original_method = "51F483359287A71D0F033A0D1668F291", hash_generated_method = "C567B52DE9443B581691DE694A93798F")
    
public void updateExtractedText(View view, int token, ExtractedText text) {
        checkFocus();
        synchronized (mH) {
            if (mServedView != view && (mServedView == null
                    || !mServedView.checkInputConnectionProxy(view))) {
                return;
            }
            
            if (mCurMethod != null) {
                try {
                    mCurMethod.updateExtractedText(token, text);
                } catch (RemoteException e) {
                }
            }
        }
    }
    
    /**
     * Synonym for {@link #showSoftInput(View, int, ResultReceiver)} without
     * a result receiver: explicitly request that the current input method's
     * soft input area be shown to the user, if needed.
     * 
     * @param view The currently focused view, which would like to receive
     * soft keyboard input.
     * @param flags Provides additional operating flags.  Currently may be
     * 0 or have the {@link #SHOW_IMPLICIT} bit set.
     */
    @DSComment("System settings/policy")
    @DSSpec(DSCat.SYSTEM)
    @DSVerified
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.697 -0500", hash_original_method = "8D2F613F92BFA1616CD527BE18090765", hash_generated_method = "8B69D752E6300569DF8BE9839965005B")
    
public boolean showSoftInput(View view, int flags) {
        return showSoftInput(view, flags, null);
    }
    
    /**
     * Explicitly request that the current input method's soft input area be
     * shown to the user, if needed.  Call this if the user interacts with
     * your view in such a way that they have expressed they would like to
     * start performing input into it.
     * 
     * @param view The currently focused view, which would like to receive
     * soft keyboard input.
     * @param flags Provides additional operating flags.  Currently may be
     * 0 or have the {@link #SHOW_IMPLICIT} bit set.
     * @param resultReceiver If non-null, this will be called by the IME when
     * it has processed your request to tell you what it has done.  The result
     * code you receive may be either {@link #RESULT_UNCHANGED_SHOWN},
     * {@link #RESULT_UNCHANGED_HIDDEN}, {@link #RESULT_SHOWN}, or
     * {@link #RESULT_HIDDEN}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.710 -0500", hash_original_method = "182A36951EBA765A4D1CAFFC02BFF851", hash_generated_method = "129BC9F4D86B8059494E49277383CAE7")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSVerified
    
public boolean showSoftInput(View view, int flags, ResultReceiver resultReceiver) {
        checkFocus();
        synchronized (mH) {
            if (resultReceiver != null) {
                resultReceiver.send(DSUtils.FAKE_INT, new Bundle());
            }
            if (mServedView != view && (mServedView == null
                    || !mServedView.checkInputConnectionProxy(view))) {
                return false;
            }

            try {
                return mService.showSoftInput(mClient, flags, resultReceiver);
            } catch (RemoteException e) {
            }
            
            return false;
        }
    }
    
    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.712 -0500", hash_original_method = "5110555AB7D318C3F52B5C2085DD7CF4", hash_generated_method = "C0E3D981EFB444B0BF3EB7EF7641D8DF")
    
public void showSoftInputUnchecked(int flags, ResultReceiver resultReceiver) {
        try {
            mService.showSoftInput(mClient, flags, resultReceiver);
        } catch (RemoteException e) {
        }
    }
    
    /**
     * Synonym for {@link #hideSoftInputFromWindow(IBinder, int, ResultReceiver)}
     * without a result: request to hide the soft input window from the
     * context of the window that is currently accepting input.
     * 
     * @param windowToken The token of the window that is making the request,
     * as returned by {@link View#getWindowToken() View.getWindowToken()}.
     * @param flags Provides additional operating flags.  Currently may be
     * 0 or have the {@link #HIDE_IMPLICIT_ONLY} bit set.
     */
    @DSComment("System settings/policy")
    @DSSpec(DSCat.SYSTEM)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.720 -0500", hash_original_method = "4391301CC9B8F998B7CF2FBAB148B8AA", hash_generated_method = "F0D9750483C2385989EDC41B5E340D15")
    
public boolean hideSoftInputFromWindow(IBinder windowToken, int flags) {
        return hideSoftInputFromWindow(windowToken, flags, null);
    }
    
    /**
     * Request to hide the soft input window from the context of the window
     * that is currently accepting input.  This should be called as a result
     * of the user doing some actually than fairly explicitly requests to
     * have the input window hidden.
     * 
     * @param windowToken The token of the window that is making the request,
     * as returned by {@link View#getWindowToken() View.getWindowToken()}.
     * @param flags Provides additional operating flags.  Currently may be
     * 0 or have the {@link #HIDE_IMPLICIT_ONLY} bit set.
     * @param resultReceiver If non-null, this will be called by the IME when
     * it has processed your request to tell you what it has done.  The result
     * code you receive may be either {@link #RESULT_UNCHANGED_SHOWN},
     * {@link #RESULT_UNCHANGED_HIDDEN}, {@link #RESULT_SHOWN}, or
     * {@link #RESULT_HIDDEN}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.722 -0500", hash_original_method = "0C97F129DA85CEA766FB3D7196531B26", hash_generated_method = "B03BB07FC79CDD81A271865377AF9DAF")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSVerified
public boolean hideSoftInputFromWindow(IBinder windowToken, int flags,
            ResultReceiver resultReceiver) {
        checkFocus();
        synchronized (mH) {

            if (resultReceiver != null) {
                resultReceiver.send(DSUtils.FAKE_INT, new Bundle());
            }
            if (mServedView == null || mServedView.getWindowToken() != windowToken) {
                return false;
            }

            try {
                return mService.hideSoftInput(mClient, flags, resultReceiver);
            } catch (RemoteException e) {
            }
            return false;
        }
    }

    /**
     * This method toggles the input method window display.
     * If the input window is already displayed, it gets hidden. 
     * If not the input window will be displayed.
     * @param windowToken The token of the window that is making the request,
     * as returned by {@link View#getWindowToken() View.getWindowToken()}.
     * @param showFlags Provides additional operating flags.  May be
     * 0 or have the {@link #SHOW_IMPLICIT},
     * {@link #SHOW_FORCED} bit set.
     * @param hideFlags Provides additional operating flags.  May be
     * 0 or have the {@link #HIDE_IMPLICIT_ONLY},
     * {@link #HIDE_NOT_ALWAYS} bit set.
     **/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.724 -0500", hash_original_method = "A530968907DBDDA36B89C5946F7EC59D", hash_generated_method = "2C5E21017E9807E723B62EC2F20F70E5")
    
public void toggleSoftInputFromWindow(IBinder windowToken, int showFlags, int hideFlags) {
        synchronized (mH) {
            if (mServedView == null || mServedView.getWindowToken() != windowToken) {
                return;
            }
            if (mCurMethod != null) {
                try {
                    mCurMethod.toggleSoftInput(showFlags, hideFlags);
                } catch (RemoteException e) {
                }
            }
        }
    }

    /*
     * This method toggles the input method window display.
     * If the input window is already displayed, it gets hidden. 
     * If not the input window will be displayed.
     * @param showFlags Provides additional operating flags.  May be
     * 0 or have the {@link #SHOW_IMPLICIT},
     * {@link #SHOW_FORCED} bit set.
     * @param hideFlags Provides additional operating flags.  May be
     * 0 or have the {@link #HIDE_IMPLICIT_ONLY},
     * {@link #HIDE_NOT_ALWAYS} bit set.
     * @hide
     */
    @DSComment("System settings/policy")
    @DSSpec(DSCat.SYSTEM)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.727 -0500", hash_original_method = "79211245E8E42CAB1585D75CD7067652", hash_generated_method = "6E47BC4561ACF73C9EAAD7DCD0628FB9")
    
public void toggleSoftInput(int showFlags, int hideFlags) {
        if (mCurMethod != null) {
            try {
                mCurMethod.toggleSoftInput(showFlags, hideFlags);
            } catch (RemoteException e) {
            }
        }
    }

    /**
     * If the input method is currently connected to the given view,
     * restart it with its new contents.  You should call this when the text
     * within your view changes outside of the normal input method or key
     * input flow, such as when an application calls TextView.setText().
     * 
     * @param view The view whose text has changed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.729 -0500", hash_original_method = "A40BE330B9742EEEBB8728870BF9ED45", hash_generated_method = "26D45FD24D1E6041BE7858FA9F49897E")
    
public void restartInput(View view) {
        checkFocus();
        synchronized (mH) {
            if (mServedView != view && (mServedView == null
                    || !mServedView.checkInputConnectionProxy(view))) {
                return;
            }
            
            mServedConnecting = true;
        }
        
        startInputInner();
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.737 -0500", hash_original_method = "B3B1285322786DD26A60C9F9B7802F4B", hash_generated_method = "6E265DD55240B0F9569810CA4A2A79CF")
    
void startInputInner() {
        final View view;
        synchronized (mH) {
            view = mServedView;
            
            // Make sure we have a window token for the served view.
            if (DEBUG) Log.v(TAG, "Starting input: view=" + view);
            if (view == null) {
                if (DEBUG) Log.v(TAG, "ABORT input: no served view!");
                return;
            }
        }
        
        // Now we need to get an input connection from the served view.
        // This is complicated in a couple ways: we can't be holding our lock
        // when calling out to the view, and we need to make sure we call into
        // the view on the same thread that is driving its view hierarchy.
        Handler vh = view.getHandler();
        if (vh == null) {
            // If the view doesn't have a handler, something has changed out
            // from under us, so just bail.
            if (DEBUG) Log.v(TAG, "ABORT input: no handler for view!");
            return;
        }
        if (vh.getLooper() != Looper.myLooper()) {
            // The view is running on a different thread than our own, so
            // we need to reschedule our work for over there.
            if (DEBUG) Log.v(TAG, "Starting input: reschedule to view thread");
            vh.post(new Runnable() {
                public void run() {
                    startInputInner();
                }
            });
            return;
        }
        
        // Okay we are now ready to call into the served view and have it
        // do its stuff.
        // Life is good: let's hook everything up!
        EditorInfo tba = new EditorInfo();
        tba.packageName = view.getContext().getPackageName();
        tba.fieldId = view.getId();
        InputConnection ic = view.onCreateInputConnection(tba);
        if (DEBUG) Log.v(TAG, "Starting input: tba=" + tba + " ic=" + ic);
        
        synchronized (mH) {
            // Now that we are locked again, validate that our state hasn't
            // changed.
            if (mServedView != view || !mServedConnecting) {
                // Something else happened, so abort.
                if (DEBUG) Log.v(TAG, 
                        "Starting input: finished by someone else (view="
                        + mServedView + " conn=" + mServedConnecting + ")");
                return;
            }
            
            // If we already have a text box, then this view is already
            // connected so we want to restart it.
            final boolean initial = mCurrentTextBoxAttribute == null;
            
            // Hook 'em up and let 'er rip.
            mCurrentTextBoxAttribute = tba;
            mServedConnecting = false;
            mServedInputConnection = ic;
            IInputContext servedContext;
            if (ic != null) {
                mCursorSelStart = tba.initialSelStart;
                mCursorSelEnd = tba.initialSelEnd;
                mCursorCandStart = -1;
                mCursorCandEnd = -1;
                mCursorRect.setEmpty();
                servedContext = new ControlledInputConnectionWrapper(vh.getLooper(), ic, this);
            } else {
                servedContext = null;
            }
            
            try {
                if (DEBUG) Log.v(TAG, "START INPUT: " + view + " ic="
                        + ic + " tba=" + tba + " initial=" + initial);
                InputBindResult res = mService.startInput(mClient,
                        servedContext, tba, initial, true);
                if (DEBUG) Log.v(TAG, "Starting input: Bind result=" + res);
                if (res != null) {
                    if (res.id != null) {
                        mBindSequence = res.sequence;
                        mCurMethod = res.method;
                    } else if (mCurMethod == null) {
                        // This means there is no input method available.
                        if (DEBUG) Log.v(TAG, "ABORT input: no input method!");
                        return;
                    }
                }
                if (mCurMethod != null && mCompletions != null) {
                    try {
                        mCurMethod.displayCompletions(mCompletions);
                    } catch (RemoteException e) {
                    }
                }
            } catch (RemoteException e) {
                Log.w(TAG, "IME died: " + mCurId, e);
            }
        }
    }

    /**
     * When the focused window is dismissed, this method is called to finish the
     * input method started before.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.739 -0500", hash_original_method = "574E98E1F1761FC0DC94CE21F83FBF8C", hash_generated_method = "BFD51DB955FF948501E9BC1252656348")
    
public void windowDismissed(IBinder appWindowToken) {
        checkFocus();
        synchronized (mH) {
            if (mServedView != null &&
                    mServedView.getWindowToken() == appWindowToken) {
                finishInputLocked();
            }
        }
    }

    /**
     * Call this when a view receives focus.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.741 -0500", hash_original_method = "3DD6E391932A9CCCB1C61486572B8B95", hash_generated_method = "79218625F7A38328686D86781DBE3551")
    
public void focusIn(View view) {
        synchronized (mH) {
            focusInLocked(view);
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.744 -0500", hash_original_method = "3857011248BD1E1DC17E86CAECB63023", hash_generated_method = "8B1B8925E1EAE73A80DDECB45390CA96")
    
void focusInLocked(View view) {
        if (DEBUG) Log.v(TAG, "focusIn: " + view);
        
        if (mCurRootView != view.getRootView()) {
            // This is a request from a window that isn't in the window with
            // IME focus, so ignore it.
            if (DEBUG) Log.v(TAG, "Not IME target window, ignoring");
            return;
        }
        
        mNextServedView = view;
        scheduleCheckFocusLocked(view);
    }

    /**
     * Call this when a view loses focus.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.747 -0500", hash_original_method = "CA0F410F50592B0E0C8F6A16050EA193", hash_generated_method = "E026598B6C32CD975181623693D96406")
    
public void focusOut(View view) {
        synchronized (mH) {
            if (DEBUG) Log.v(TAG, "focusOut: " + view
                    + " mServedView=" + mServedView
                    + " winFocus=" + view.hasWindowFocus());
            if (mServedView != view) {
                // The following code would auto-hide the IME if we end up
                // with no more views with focus.  This can happen, however,
                // whenever we go into touch mode, so it ends up hiding
                // at times when we don't really want it to.  For now it
                // seems better to just turn it all off.
                if (false && view.hasWindowFocus()) {
                    mNextServedView = null;
                    scheduleCheckFocusLocked(view);
                }
            }
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.749 -0500", hash_original_method = "4A6B64189F9C851EAF66731814D5760A", hash_generated_method = "8E13AACB8315B96406E4B2DEE94595FD")
    
void scheduleCheckFocusLocked(View view) {
        Handler vh = view.getHandler();
        if (vh != null && !vh.hasMessages(ViewRootImpl.CHECK_FOCUS)) {
            // This will result in a call to checkFocus() below.
            vh.sendMessage(vh.obtainMessage(ViewRootImpl.CHECK_FOCUS));
        }
    }
    
    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.753 -0500", hash_original_method = "7D116D001C63CE498592C7AACB0DA356", hash_generated_method = "3D7C005C05712ACF3F7A1C3F97E42DBD")
    
public void checkFocus() {
/*        // This is called a lot, so short-circuit before locking.
        if (mServedView == mNextServedView && !mNextServedNeedsStart) {
            return;
        }

        InputConnection ic = null;
        synchronized (mH) {
            if (mServedView == mNextServedView && !mNextServedNeedsStart) {
                return;
            }
            if (DEBUG) Log.v(TAG, "checkFocus: view=" + mServedView
                    + " next=" + mNextServedView
                    + " restart=" + mNextServedNeedsStart);
            
            mNextServedNeedsStart = false;
            if (mNextServedView == null) {
                finishInputLocked();
                // In this case, we used to have a focused view on the window,
                // but no longer do.  We should make sure the input method is
                // no longer shown, since it serves no purpose.
                closeCurrentInput();
                return;
            }
            
            ic = mServedInputConnection;
            
            mServedView = mNextServedView;
            mCurrentTextBoxAttribute = null;
            mCompletions = null;
            mServedConnecting = true;
        }
        
        if (ic != null) {
            ic.finishComposingText();
        }
        
        startInputInner();*/
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.755 -0500", hash_original_method = "D0A5B4195CF8CF9C3EE8D9642BA1EAAF", hash_generated_method = "D0A5B4195CF8CF9C3EE8D9642BA1EAAF")
    
void closeCurrentInput() {
        try {
            mService.hideSoftInput(mClient, HIDE_NOT_ALWAYS, null);
        } catch (RemoteException e) {
        }
    }
    
    /**
     * Called by ViewAncestor when its window gets input focus.
     * @hide
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.758 -0500", hash_original_method = "4893EC862C01D5D2A6E85A7017E94B9B", hash_generated_method = "349D9D12DF3A6DA1D0A30BA63321958C")
    
public void onWindowFocus(View rootView, View focusedView, int softInputMode,
            boolean first, int windowFlags) {
        synchronized (mH) {
            if (DEBUG) Log.v(TAG, "onWindowFocus: " + focusedView
                    + " softInputMode=" + softInputMode
                    + " first=" + first + " flags=#"
                    + Integer.toHexString(windowFlags));
            if (mHasBeenInactive) {
                if (DEBUG) Log.v(TAG, "Has been inactive!  Starting fresh");
                mHasBeenInactive = false;
                mNextServedNeedsStart = true;
            }
            focusInLocked(focusedView != null ? focusedView : rootView);
        }
        
        checkFocus();
        
        synchronized (mH) {
            try {
                final boolean isTextEditor = focusedView != null &&
                        focusedView.onCheckIsTextEditor();
                mService.windowGainedFocus(mClient, rootView.getWindowToken(),
                        focusedView != null, isTextEditor, softInputMode, first,
                        windowFlags);
            } catch (RemoteException e) {
            }
        }
    }
    
    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.760 -0500", hash_original_method = "1A7A85BD07D131CBE39BA9D28F0E6F2A", hash_generated_method = "56A2FFEFFC7DFCB8C385685AFCBE4747")
    
public void startGettingWindowFocus(View rootView) {
        synchronized (mH) {
            mCurRootView = rootView;
        }
    }
    
    /**
     * Report the current selection range.
     */
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.763 -0500", hash_original_method = "6EC728E52174DF43F39F15D376B96D59", hash_generated_method = "741763FA91FB3B125F4D311FC2F6B63E")
    
public void updateSelection(View view, int selStart, int selEnd,
            int candidatesStart, int candidatesEnd) {
        checkFocus();
        synchronized (mH) {
            if ((mServedView != view && (mServedView == null
                        || !mServedView.checkInputConnectionProxy(view)))
                    || mCurrentTextBoxAttribute == null || mCurMethod == null) {
                return;
            }
            
            if (mCursorSelStart != selStart || mCursorSelEnd != selEnd
                    || mCursorCandStart != candidatesStart
                    || mCursorCandEnd != candidatesEnd) {
                if (DEBUG) Log.d(TAG, "updateSelection");

                try {
                    if (DEBUG) Log.v(TAG, "SELECTION CHANGE: " + mCurMethod);
                    mCurMethod.updateSelection(mCursorSelStart, mCursorSelEnd,
                            selStart, selEnd, candidatesStart, candidatesEnd);
                    mCursorSelStart = selStart;
                    mCursorSelEnd = selEnd;
                    mCursorCandStart = candidatesStart;
                    mCursorCandEnd = candidatesEnd;
                } catch (RemoteException e) {
                    Log.w(TAG, "IME died: " + mCurId, e);
                }
            }
        }
    }

    /**
     * Notify the event when the user tapped or clicked the text view.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.766 -0500", hash_original_method = "8E5F47C036105189BFF71EB5625C4E3F", hash_generated_method = "7F42714E474D901B97B6AC9C721582A1")
    
public void viewClicked(View view) {
        final boolean focusChanged = mServedView != mNextServedView;
        checkFocus();
        synchronized (mH) {
            if ((mServedView != view && (mServedView == null
                    || !mServedView.checkInputConnectionProxy(view)))
                    || mCurrentTextBoxAttribute == null || mCurMethod == null) {
                return;
            }
            try {
                if (DEBUG) Log.v(TAG, "onViewClicked: " + focusChanged);
                mCurMethod.viewClicked(focusChanged);
            } catch (RemoteException e) {
                Log.w(TAG, "IME died: " + mCurId, e);
            }
        }
    }

    /**
     * Returns true if the current input method wants to watch the location
     * of the input editor's cursor in its window.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.768 -0500", hash_original_method = "385DC57C25B266614A0F3F767A2E43B1", hash_generated_method = "5C9BCD0CE231318AE3A038989B9BE07D")
    
public boolean isWatchingCursor(View view) {
        return false;
    }
    
    /**
     * Report the current cursor location in its window.
     */
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.771 -0500", hash_original_method = "06AF2B97EC9C8BBE1303A237FE727449", hash_generated_method = "103A7E1B02C228D1981B721CBC7DAC4C")
    
public void updateCursor(View view, int left, int top, int right, int bottom) {
        checkFocus();
        synchronized (mH) {
            if ((mServedView != view && (mServedView == null
                        || !mServedView.checkInputConnectionProxy(view)))
                    || mCurrentTextBoxAttribute == null || mCurMethod == null) {
                return;
            }
            
            mTmpCursorRect.set(left, top, right, bottom);
            if (!mCursorRect.equals(mTmpCursorRect)) {
                if (DEBUG) Log.d(TAG, "updateCursor");

                try {
                    if (DEBUG) Log.v(TAG, "CURSOR CHANGE: " + mCurMethod);
                    mCurMethod.updateCursor(mTmpCursorRect);
                    mCursorRect.set(mTmpCursorRect);
                } catch (RemoteException e) {
                    Log.w(TAG, "IME died: " + mCurId, e);
                }
            }
        }
    }
    
    class H extends Handler {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.588 -0500", hash_original_method = "6EF38EF9E91987FCDB2CC1FED5C76A24", hash_generated_method = "6EF38EF9E91987FCDB2CC1FED5C76A24")
        
H(Looper looper) {
            super(looper);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.592 -0500", hash_original_method = "D40CD8B0041519F81016D036AC481E26", hash_generated_method = "ACD4E6EB27BF251DA62E0268D613BA11")
        
@Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_DUMP: {
                    HandlerCaller.SomeArgs args = (HandlerCaller.SomeArgs)msg.obj;
                    try {
                        doDump((FileDescriptor)args.arg1,
                                (PrintWriter)args.arg2, (String[])args.arg3);
                    } catch (RuntimeException e) {
                        ((PrintWriter)args.arg2).println("Exception: " + e);
                    }
                    synchronized (args.arg4) {
                        ((CountDownLatch)args.arg4).countDown();
                    }
                    return;
                }
                case MSG_BIND: {
                    final InputBindResult res = (InputBindResult)msg.obj;
                    synchronized (mH) {
                        if (mBindSequence < 0 || mBindSequence != res.sequence) {
                            Log.w(TAG, "Ignoring onBind: cur seq=" + mBindSequence
                                    + ", given seq=" + res.sequence);
                            return;
                        }
                        
                        mCurMethod = res.method;
                        mCurId = res.id;
                        mBindSequence = res.sequence;
                    }
                    startInputInner();
                    return;
                }
                case MSG_UNBIND: {
                    final int sequence = msg.arg1;
                    synchronized (mH) {
                        if (mBindSequence == sequence) {
                            if (false) {
                                // XXX the server has already unbound!
                                if (mCurMethod != null && mCurrentTextBoxAttribute != null) {
                                    try {
                                        mCurMethod.finishInput();
                                    } catch (RemoteException e) {
                                        Log.w(TAG, "IME died: " + mCurId, e);
                                    }
                                }
                            }
                            clearBindingLocked();
                            
                            // If we were actively using the last input method, then
                            // we would like to re-connect to the next input method.
                            if (mServedView != null && mServedView.isFocused()) {
                                mServedConnecting = true;
                            }
                        }
                        startInputInner();
                    }
                    return;
                }
                case MSG_SET_ACTIVE: {
                    final boolean active = msg.arg1 != 0;
                    synchronized (mH) {
                        mActive = active;
                        mFullscreenMode = false;
                        if (!active) {
                            // Some other client has starting using the IME, so note
                            // that this happened and make sure our own editor's
                            // state is reset.
                            mHasBeenInactive = true;
                            try {
                                // Note that finishComposingText() is allowed to run
                                // even when we are not active.
                                mIInputContext.finishComposingText();
                            } catch (RemoteException e) {
                            }
                        }
                    }
                    return;
                }
            }
        }
        
    }
    
    private static class ControlledInputConnectionWrapper extends IInputConnectionWrapper {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.599 -0500", hash_original_field = "BBC16146D0A901FDED4BB966420384DF", hash_generated_field = "9798BD50577982452DA631DD5C538942")

        private  InputMethodManager mParentInputMethodManager;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.602 -0500", hash_original_method = "778EAAA875B5E9B35A79C47358BD4D78", hash_generated_method = "FA2681176464ABD80C7068AE5796AF42")
        
public ControlledInputConnectionWrapper(final Looper mainLooper, final InputConnection conn,
                final InputMethodManager inputMethodManager) {
            super(mainLooper, conn);
            mParentInputMethodManager = inputMethodManager;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.605 -0500", hash_original_method = "FB049513493D8EDB25EAFF891B2EE0A9", hash_generated_method = "DBEC38376F2F082D161939B93A306F06")
        
@Override
        public boolean isActive() {
            return mParentInputMethodManager.mActive;
        }
        
    }

    /**
     * Call {@link InputMethodSession#appPrivateCommand(String, Bundle)
     * InputMethodSession.appPrivateCommand()} on the current Input Method.
     * @param view Optional View that is sending the command, or null if
     * you want to send the command regardless of the view that is attached
     * to the input method.
     * @param action Name of the command to be performed.  This <em>must</em>
     * be a scoped name, i.e. prefixed with a package name you own, so that
     * different developers will not create conflicting commands.
     * @param data Any data to include with the command.
     */
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.774 -0500", hash_original_method = "42E6E13C0C5606029CE59DAABCC4FEF4", hash_generated_method = "637CE227C95F20FE5A9F9CD169CDF76B")
    
public void sendAppPrivateCommand(View view, String action, Bundle data) {
        checkFocus();
        synchronized (mH) {
            if ((mServedView != view && (mServedView == null
                        || !mServedView.checkInputConnectionProxy(view)))
                    || mCurrentTextBoxAttribute == null || mCurMethod == null) {
                return;
            }
            try {
                if (DEBUG) Log.v(TAG, "APP PRIVATE COMMAND " + action + ": " + data);
                mCurMethod.appPrivateCommand(action, data);
            } catch (RemoteException e) {
                Log.w(TAG, "IME died: " + mCurId, e);
            }
        }
    }

    /**
     * Force switch to a new input method component. This can only be called
     * from an application or a service which has a token of the currently active input method.
     * @param token Supplies the identifying token given to an input method
     * when it was started, which allows it to perform this operation on
     * itself.
     * @param id The unique identifier for the new input method to be switched to.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.777 -0500", hash_original_method = "BA3360E0078151C4E77F69CD0F708AC2", hash_generated_method = "A5938D513A91511C2DFF9742F3A37CA1")
    
public void setInputMethod(IBinder token, String id) {
        try {
            mService.setInputMethod(token, id);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Force switch to a new input method and subtype. This can only be called
     * from an application or a service which has a token of the currently active input method.
     * @param token Supplies the identifying token given to an input method
     * when it was started, which allows it to perform this operation on
     * itself.
     * @param id The unique identifier for the new input method to be switched to.
     * @param subtype The new subtype of the new input method to be switched to.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.779 -0500", hash_original_method = "6B5F7BD4B9987D792262BC3FA22B0356", hash_generated_method = "2423AB9E571221589831B1F4A89E7E3B")
    
public void setInputMethodAndSubtype(IBinder token, String id, InputMethodSubtype subtype) {
        try {
            mService.setInputMethodAndSubtype(token, id, subtype);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Close/hide the input method's soft input area, so the user no longer
     * sees it or can interact with it.  This can only be called
     * from the currently active input method, as validated by the given token.
     * 
     * @param token Supplies the identifying token given to an input method
     * when it was started, which allows it to perform this operation on
     * itself.
     * @param flags Provides additional operating flags.  Currently may be
     * 0 or have the {@link #HIDE_IMPLICIT_ONLY},
     * {@link #HIDE_NOT_ALWAYS} bit set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.782 -0500", hash_original_method = "57E46D0940B3C65A92751CB9C29D6161", hash_generated_method = "945C9D14804268984269359B7CD71428")
    
public void hideSoftInputFromInputMethod(IBinder token, int flags) {
        try {
            mService.hideMySoftInput(token, flags);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Show the input method's soft input area, so the user 
     * sees the input method window and can interact with it.
     * This can only be called from the currently active input method,
     * as validated by the given token.
     * 
     * @param token Supplies the identifying token given to an input method
     * when it was started, which allows it to perform this operation on
     * itself.
     * @param flags Provides additional operating flags.  Currently may be
     * 0 or have the {@link #SHOW_IMPLICIT} or
     * {@link #SHOW_FORCED} bit set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.784 -0500", hash_original_method = "E0804B4135D0004448137E06C89A5AC2", hash_generated_method = "99478A9B212A653D0776986BD35F57F4")
    
public void showSoftInputFromInputMethod(IBinder token, int flags) {
        try {
            mService.showMySoftInput(token, flags);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.788 -0500", hash_original_method = "E668070B782BDDB11E06224CB9252B61", hash_generated_method = "12E9B7D6A4216847B39F721FEA47ADE9")
    
public void dispatchKeyEvent(Context context, int seq, KeyEvent key,
            IInputMethodCallback callback) {
        synchronized (mH) {
            if (DEBUG) Log.d(TAG, "dispatchKeyEvent");
    
            if (mCurMethod == null) {
                try {
                    callback.finishedEvent(seq, false);
                } catch (RemoteException e) {
                }
                return;
            }
    
            if (key.getAction() == KeyEvent.ACTION_DOWN
                    && key.getKeyCode() == KeyEvent.KEYCODE_SYM) {
                showInputMethodPicker();
                try {
                    callback.finishedEvent(seq, true);
                } catch (RemoteException e) {
                }
                return;
            }
            try {
                if (DEBUG) Log.v(TAG, "DISPATCH KEY: " + mCurMethod);
                mCurMethod.dispatchKeyEvent(seq, key, callback);
            } catch (RemoteException e) {
                Log.w(TAG, "IME died: " + mCurId + " dropping: " + key, e);
                try {
                    callback.finishedEvent(seq, false);
                } catch (RemoteException ex) {
                }
            }
        }
    }

    /**
     * @hide
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.790 -0500", hash_original_method = "99D2E1A6FD8F8DDA0CF04D3632103B0E", hash_generated_method = "99D2E1A6FD8F8DDA0CF04D3632103B0E")
    
void dispatchTrackballEvent(Context context, int seq, MotionEvent motion,
            IInputMethodCallback callback) {
        synchronized (mH) {
            if (DEBUG) Log.d(TAG, "dispatchTrackballEvent");
    
            if (mCurMethod == null || mCurrentTextBoxAttribute == null) {
                try {
                    callback.finishedEvent(seq, false);
                } catch (RemoteException e) {
                }
                return;
            }
    
            try {
                if (DEBUG) Log.v(TAG, "DISPATCH TRACKBALL: " + mCurMethod);
                mCurMethod.dispatchTrackballEvent(seq, motion, callback);
            } catch (RemoteException e) {
                Log.w(TAG, "IME died: " + mCurId + " dropping trackball: " + motion, e);
                try {
                    callback.finishedEvent(seq, false);
                } catch (RemoteException ex) {
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.793 -0500", hash_original_method = "032A4A57AEC9378F2AEDB365B55F6952", hash_generated_method = "EB35F8711D6684279A1890191F1A036A")
    
public void showInputMethodPicker() {
        synchronized (mH) {
            try {
                mService.showInputMethodPickerFromClient(mClient);
            } catch (RemoteException e) {
                Log.w(TAG, "IME died: " + mCurId, e);
            }
        }
    }

    /**
     * Show the settings for enabling subtypes of the specified input method.
     * @param imiId An input method, whose subtypes settings will be shown. If imiId is null,
     * subtypes of all input methods will be shown.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.795 -0500", hash_original_method = "40ED720E9E0E9A18C34ACD22184580A8", hash_generated_method = "43E8DFA54E60C54537D787F0AAAC2A94")
    
public void showInputMethodAndSubtypeEnabler(String imiId) {
        synchronized (mH) {
            try {
                mService.showInputMethodAndSubtypeEnablerFromClient(mClient, imiId);
            } catch (RemoteException e) {
                Log.w(TAG, "IME died: " + mCurId, e);
            }
        }
    }

    /**
     * Returns the current input method subtype. This subtype is one of the subtypes in
     * the current input method. This method returns null when the current input method doesn't
     * have any input method subtype.
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.798 -0500", hash_original_method = "FD9F276F6D40BEB379032073F0CE055D", hash_generated_method = "B0AAE5461AF9B5346EE89377D430A6FF")
    
public InputMethodSubtype getCurrentInputMethodSubtype() {
        synchronized (mH) {
            try {
                return mService.getCurrentInputMethodSubtype();
            } catch (RemoteException e) {
                Log.w(TAG, "IME died: " + mCurId, e);
                return null;
            }
        }
    }

    /**
     * Switch to a new input method subtype of the current input method.
     * @param subtype A new input method subtype to switch.
     * @return true if the current subtype was successfully switched. When the specified subtype is
     * null, this method returns false.
     */
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.800 -0500", hash_original_method = "3CA77773C45BE29D3C7CB419603994A1", hash_generated_method = "EBCF77961B85338AAB227CD051845F15")
    
public boolean setCurrentInputMethodSubtype(InputMethodSubtype subtype) {
        synchronized (mH) {
            try {
                return mService.setCurrentInputMethodSubtype(subtype);
            } catch (RemoteException e) {
                Log.w(TAG, "IME died: " + mCurId, e);
                return false;
            }
        }
    }

    /**
     * Returns a map of all shortcut input method info and their subtypes.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.804 -0500", hash_original_method = "43A6DF9F5E808A92ECB1533408005E7F", hash_generated_method = "6B3036069590C808E6FF68E1FB3C361C")
    
public Map<InputMethodInfo, List<InputMethodSubtype>> getShortcutInputMethodsAndSubtypes() {
        synchronized (mH) {
            HashMap<InputMethodInfo, List<InputMethodSubtype>> ret =
                    new HashMap<InputMethodInfo, List<InputMethodSubtype>>();
            try {
                // TODO: We should change the return type from List<Object> to List<Parcelable>
                List<Object> info = mService.getShortcutInputMethodsAndSubtypes();
                // "info" has imi1, subtype1, subtype2, imi2, subtype2, imi3, subtype3..in the list
                ArrayList<InputMethodSubtype> subtypes = null;
                final int N = info.size();
                if (info != null && N > 0) {
                    for (int i = 0; i < N; ++i) {
                        Object o = info.get(i);
                        if (o instanceof InputMethodInfo) {
                            if (ret.containsKey(o)) {
                                Log.e(TAG, "IMI list already contains the same InputMethod.");
                                break;
                            }
                            subtypes = new ArrayList<InputMethodSubtype>();
                            ret.put((InputMethodInfo)o, subtypes);
                        } else if (subtypes != null && o instanceof InputMethodSubtype) {
                            subtypes.add((InputMethodSubtype)o);
                        }
                    }
                }
            } catch (RemoteException e) {
                Log.w(TAG, "IME died: " + mCurId, e);
            }
            return ret;
        }
    }

    /**
     * Force switch to the last used input method and subtype. If the last input method didn't have
     * any subtypes, the framework will simply switch to the last input method with no subtype
     * specified.
     * @param imeToken Supplies the identifying token given to an input method when it was started,
     * which allows it to perform this operation on itself.
     * @return true if the current input method and subtype was successfully switched to the last
     * used input method and subtype.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.807 -0500", hash_original_method = "36F8CCF4190068A92F1E830BF76C0680", hash_generated_method = "91A1309A0BD0A60858790C38C54BF2FA")
    
public boolean switchToLastInputMethod(IBinder imeToken) {
        synchronized (mH) {
            try {
                return mService.switchToLastInputMethod(imeToken);
            } catch (RemoteException e) {
                Log.w(TAG, "IME died: " + mCurId, e);
                return false;
            }
        }
    }

    /**
     * Set additional input method subtypes. Only a process which shares the same uid with the IME
     * can add additional input method subtypes to the IME.
     * Please note that a subtype's status is stored in the system.
     * For example, enabled subtypes are remembered by the framework even after they are removed
     * by using this method. If you re-add the same subtypes again,
     * they will just get enabled. If you want to avoid such conflicts, for instance, you may
     * want to create a "different" new subtype even with the same locale and mode,
     * by changing its extra value. The different subtype won't get affected by the stored past
     * status. (You may want to take a look at {@link InputMethodSubtype#hashCode()} to refer
     * to the current implementation.)
     * @param imiId Id of InputMethodInfo which additional input method subtypes will be added to.
     * @param subtypes subtypes will be added as additional subtypes of the current input method.
     */
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.809 -0500", hash_original_method = "E3938A1614AA74CBD638A5A0682603ED", hash_generated_method = "D34D9596D75C1D779B74100477243A36")
    
public void setAdditionalInputMethodSubtypes(String imiId, InputMethodSubtype[] subtypes) {
        synchronized (mH) {
            try {
                mService.setAdditionalInputMethodSubtypes(imiId, subtypes);
            } catch (RemoteException e) {
                Log.w(TAG, "IME died: " + mCurId, e);
            }
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.812 -0500", hash_original_method = "D92C08014C42A358F015C9B31552925A", hash_generated_method = "B4BE121955C3E0394B5BD04A3B1399AD")
    
public InputMethodSubtype getLastInputMethodSubtype() {
        synchronized (mH) {
            try {
                return mService.getLastInputMethodSubtype();
            } catch (RemoteException e) {
                Log.w(TAG, "IME died: " + mCurId, e);
                return null;
            }
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.815 -0500", hash_original_method = "A669FCC83173C60A2ED2B3C5020338A1", hash_generated_method = "A669FCC83173C60A2ED2B3C5020338A1")
    
void doDump(FileDescriptor fd, PrintWriter fout, String[] args) {
        final Printer p = new PrintWriterPrinter(fout);
        p.println("Input method client state for " + this + ":");
        
        p.println("  mService=" + mService);
        p.println("  mMainLooper=" + mMainLooper);
        p.println("  mIInputContext=" + mIInputContext);
        p.println("  mActive=" + mActive
                + " mHasBeenInactive=" + mHasBeenInactive
                + " mBindSequence=" + mBindSequence
                + " mCurId=" + mCurId);
        p.println("  mCurMethod=" + mCurMethod);
        p.println("  mCurRootView=" + mCurRootView);
        p.println("  mServedView=" + mServedView);
        p.println("  mNextServedNeedsStart=" + mNextServedNeedsStart
                + " mNextServedView=" + mNextServedView);
        p.println("  mServedConnecting=" + mServedConnecting);
        if (mCurrentTextBoxAttribute != null) {
            p.println("  mCurrentTextBoxAttribute:");
            mCurrentTextBoxAttribute.dump(p, "    ");
        } else {
            p.println("  mCurrentTextBoxAttribute: null");
        }
        p.println("  mServedInputConnection=" + mServedInputConnection);
        p.println("  mCompletions=" + mCompletions);
        p.println("  mCursorRect=" + mCursorRect);
        p.println("  mCursorSelStart=" + mCursorSelStart
                + " mCursorSelEnd=" + mCursorSelEnd
                + " mCursorCandStart=" + mCursorCandStart
                + " mCursorCandEnd=" + mCursorCandEnd);
    }
}

