package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.os.HandlerCaller;
import com.android.internal.view.IInputConnectionWrapper;
import com.android.internal.view.IInputContext;
import com.android.internal.view.IInputMethodCallback;
import com.android.internal.view.IInputMethodClient;
import com.android.internal.view.IInputMethodManager;
import com.android.internal.view.IInputMethodSession;
import com.android.internal.view.InputBindResult;
import android.content.Context;
import android.content.pm.PackageManager;
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
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class InputMethodManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.453 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "AF4D994570007AEC23008412E21170BC")

    IInputMethodManager mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.453 -0400", hash_original_field = "6C2EA91B438529F1372D806717F5AE04", hash_generated_field = "22AA67C96F8F7AD7DFD89E53DF216F9A")

    Looper mMainLooper;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.454 -0400", hash_original_field = "6D1DA64E705BB119454CD3D6A13CB760", hash_generated_field = "4DD8CF7D1E2B224E6925E028DA6C7C60")

    H mH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.454 -0400", hash_original_field = "4AC36937F366B7AB4CCDC4F1F414F47C", hash_generated_field = "72027A70482354298567E3297708A343")

    IInputContext mIInputContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.454 -0400", hash_original_field = "43EEA9F366EE6D438612A98DC9C5FC93", hash_generated_field = "844E46882A240B061C638C1091315129")

    boolean mActive = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.454 -0400", hash_original_field = "C6C64E873A8D5F838497C395DB968AA6", hash_generated_field = "7B2E6D1E4DF1C0EAF8EAE346683AD3D8")

    boolean mHasBeenInactive = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.454 -0400", hash_original_field = "21C88B20DA84168713D6AAB9A7589738", hash_generated_field = "7A6D29D78DDDB849117195D1575B1D0D")

    boolean mFullscreenMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.454 -0400", hash_original_field = "7C403604AF27C19B706DB901961790F3", hash_generated_field = "8610B5C69CA08D5F83A8EDAD499B41DF")

    View mCurRootView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.454 -0400", hash_original_field = "276384D0701C2515D37ABAEB0BB07CF1", hash_generated_field = "A54183C371A5C91679B93D582850D821")

    View mServedView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.454 -0400", hash_original_field = "8A6701709B1BF571CC720A8C0186A3A1", hash_generated_field = "37CB9C3A74C8E8A1DCD593663CB659AC")

    View mNextServedView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.454 -0400", hash_original_field = "07A5D2B2CA7B06E26DDA4CEA3D0F998F", hash_generated_field = "1CF172770CCCC42619E82625D27683E4")

    boolean mNextServedNeedsStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.454 -0400", hash_original_field = "6FEA88F2097C781265F07408D655FA08", hash_generated_field = "AA8EADE0DA95013FD81168358A40CC38")

    boolean mServedConnecting;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.454 -0400", hash_original_field = "C37631DCB334F3DE253566FE7E88827B", hash_generated_field = "F6752A3676A98F8319F142BFE09A3814")

    EditorInfo mCurrentTextBoxAttribute;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.454 -0400", hash_original_field = "F2741F7543BFA572357C0FCA31F8D3CA", hash_generated_field = "1069CCDD0BD720E7FA6763B4BE3FB768")

    InputConnection mServedInputConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.454 -0400", hash_original_field = "EEF2F22BDE2DAD179EF74F9D5A249F06", hash_generated_field = "37C04B17B3D71E2A78D5E95F178E79E6")

    CompletionInfo[] mCompletions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.454 -0400", hash_original_field = "6E5580956F347FC39333E30175D7959E", hash_generated_field = "79C750F90B6AC779C5BB9837C3C74CAB")

    Rect mTmpCursorRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.454 -0400", hash_original_field = "350B6C1DE46A8AE51B0B3EA7C5DA7FB3", hash_generated_field = "49E12E0B9B02D82DC1E7BF4D1DC2791F")

    Rect mCursorRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.455 -0400", hash_original_field = "6C4EB7C9764378AC3F07482431440688", hash_generated_field = "61370CAB7E613D3B51D5F05A3E7881EC")

    int mCursorSelStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.455 -0400", hash_original_field = "7F3420A9E671AF58A6B367314A292BE4", hash_generated_field = "EE54263B133ACFB15E11DD2491E1A3B9")

    int mCursorSelEnd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.455 -0400", hash_original_field = "348A4A071E9816A33884E58F89D8D45F", hash_generated_field = "1CD08C23B7F290112A0ABF5F99E6CD72")

    int mCursorCandStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.455 -0400", hash_original_field = "03AAABA3C7C79FEB761E8C53CF9CE377", hash_generated_field = "BF24EA98ADDF2C881C86310B37BA9EE6")

    int mCursorCandEnd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.455 -0400", hash_original_field = "31D04805CE4EE92E41E4F9B05CE76B8E", hash_generated_field = "C983A711DB3B897D81814DB669E54903")

    int mBindSequence = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.455 -0400", hash_original_field = "878F6B32EA64F5E90AF6FFF354C354D2", hash_generated_field = "B8DB1FCD85A9BF1BC30DF0BD30881CBD")

    String mCurId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.455 -0400", hash_original_field = "F3A12A28D252E9CCEBFAFF98ED723491", hash_generated_field = "ECFDF7AD8578511D0EA7676517144A2F")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.455 -0400", hash_original_field = "73409FFD7A55CCEC18BF7235F49C6C2C", hash_generated_field = "23E79A65143FCC7F6AFAF0A8EA3DFB92")

    final InputConnection mDummyInputConnection = new BaseInputConnection(this, false);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.456 -0400", hash_original_method = "508ED56B5BF5DABABCAF5D12E61B17FA", hash_generated_method = "8F8CB7DD0282198FF166028847E17584")
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

    
        static public InputMethodManager getInstance(Context context) {
        return getInstance(context.getMainLooper());
    }

    
        static public InputMethodManager getInstance(Looper mainLooper) {
        synchronized (mInstanceSync) {
            if (mInstance != null) {
                return mInstance;
            }
            IBinder b = ServiceManager.getService(Context.INPUT_METHOD_SERVICE);
            IInputMethodManager service = IInputMethodManager.Stub.asInterface(b);
            mInstance = new InputMethodManager(service, mainLooper);
        }
        return mInstance;
    }

    
        @DSModeled(DSC.SAFE)
    static public InputMethodManager peekInstance() {
        return mInstance;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.457 -0400", hash_original_method = "3D9C93A013E7DC300254687B6593E9DE", hash_generated_method = "7BAD767D5472314AA334A20D2D7A9EF9")
    public IInputMethodClient getClient() {
IInputMethodClient varC088D1DF075112E0906917C9520017A1_1267598167 =         mClient;
        varC088D1DF075112E0906917C9520017A1_1267598167.addTaint(taint);
        return varC088D1DF075112E0906917C9520017A1_1267598167;
        // ---------- Original Method ----------
        //return mClient;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.457 -0400", hash_original_method = "BB1CC2AA4E519DFF3D7BB1A17FAAA9A1", hash_generated_method = "01207D2CC8403B0638DEB8E6BCCEACED")
    public IInputContext getInputContext() {
IInputContext var3882EE78855F016992A015D7D670188F_1836917192 =         mIInputContext;
        var3882EE78855F016992A015D7D670188F_1836917192.addTaint(taint);
        return var3882EE78855F016992A015D7D670188F_1836917192;
        // ---------- Original Method ----------
        //return mIInputContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.457 -0400", hash_original_method = "4976C1493B414917938FA9CF9C859341", hash_generated_method = "D1275816A7BB1741F9D7B7CDB52A49CC")
    public List<InputMethodInfo> getInputMethodList() {
        try 
        {
List<InputMethodInfo> var1AF35DE97ED7980EC5787923E9C91923_250226833 =             mService.getInputMethodList();
            var1AF35DE97ED7980EC5787923E9C91923_250226833.addTaint(taint);
            return var1AF35DE97ED7980EC5787923E9C91923_250226833;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_1092557326 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_1092557326.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_1092557326;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getInputMethodList();
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.458 -0400", hash_original_method = "E8BA85FCD94534AA9F0D8586DC21C83A", hash_generated_method = "DB1E2423703F71768486F1E366DCFDE1")
    public List<InputMethodInfo> getEnabledInputMethodList() {
        try 
        {
List<InputMethodInfo> var66B28E882645C61D424E3DABD0D9FB5B_2024815833 =             mService.getEnabledInputMethodList();
            var66B28E882645C61D424E3DABD0D9FB5B_2024815833.addTaint(taint);
            return var66B28E882645C61D424E3DABD0D9FB5B_2024815833;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_1207898286 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_1207898286.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_1207898286;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getEnabledInputMethodList();
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.458 -0400", hash_original_method = "6701B30EF11ADDDCEFC97757F6DCE403", hash_generated_method = "3D6DD8D9A3607E9B3FF7C19CA969DD86")
    public List<InputMethodSubtype> getEnabledInputMethodSubtypeList(InputMethodInfo imi,
            boolean allowsImplicitlySelectedSubtypes) {
        addTaint(allowsImplicitlySelectedSubtypes);
        addTaint(imi.getTaint());
        try 
        {
List<InputMethodSubtype> var49F293FBAEA52142275424C14023DA83_1555405078 =             mService.getEnabledInputMethodSubtypeList(imi, allowsImplicitlySelectedSubtypes);
            var49F293FBAEA52142275424C14023DA83_1555405078.addTaint(taint);
            return var49F293FBAEA52142275424C14023DA83_1555405078;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_599746350 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_599746350.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_599746350;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getEnabledInputMethodSubtypeList(imi, allowsImplicitlySelectedSubtypes);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.459 -0400", hash_original_method = "53B62C40B5B8B2FB3464E7DA6A87D443", hash_generated_method = "C3BA5AF658DE6642388CEB7122BFC031")
    public void showStatusIcon(IBinder imeToken, String packageName, int iconId) {
        addTaint(iconId);
        addTaint(packageName.getTaint());
        addTaint(imeToken.getTaint());
        try 
        {
            mService.updateStatusIcon(imeToken, packageName, iconId);
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_918845043 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_918845043.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_918845043;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.updateStatusIcon(imeToken, packageName, iconId);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.459 -0400", hash_original_method = "D00BAF75C3098DFC4E35D122E494F4F9", hash_generated_method = "5E10839D289432872605EC79D06D5FA8")
    public void hideStatusIcon(IBinder imeToken) {
        addTaint(imeToken.getTaint());
        try 
        {
            mService.updateStatusIcon(imeToken, null, 0);
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_336649628 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_336649628.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_336649628;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.updateStatusIcon(imeToken, null, 0);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.460 -0400", hash_original_method = "7375BD73E964162AE893F10DF6DE4659", hash_generated_method = "8CABB9C86FB7BFC833D2F29C80D73387")
    public void setImeWindowStatus(IBinder imeToken, int vis, int backDisposition) {
        addTaint(backDisposition);
        addTaint(vis);
        addTaint(imeToken.getTaint());
        try 
        {
            mService.setImeWindowStatus(imeToken, vis, backDisposition);
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_1825529069 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_1825529069.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_1825529069;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.setImeWindowStatus(imeToken, vis, backDisposition);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.461 -0400", hash_original_method = "E3510526CEDC6D4EEDFFA989F1389EB2", hash_generated_method = "DBF532BC0434234D838BC6C0A047FC02")
    public void setFullscreenMode(boolean fullScreen) {
        mFullscreenMode = fullScreen;
        // ---------- Original Method ----------
        //mFullscreenMode = fullScreen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.462 -0400", hash_original_method = "CEA057AD7D0092E84D73E0D04E9F9DEE", hash_generated_method = "1C86BBAE6CE0F3E14C5771953A504B27")
    public void registerSuggestionSpansForNotification(SuggestionSpan[] spans) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(spans[0].getTaint());
        try 
        {
            mService.registerSuggestionSpansForNotification(spans);
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_1628594811 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_1628594811.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_1628594811;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.registerSuggestionSpansForNotification(spans);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.462 -0400", hash_original_method = "67AB3FB4ECE37955692BC451DD457E24", hash_generated_method = "6960E2AC25156A353AA905721DDAC5F6")
    public void notifySuggestionPicked(SuggestionSpan span, String originalString, int index) {
        addTaint(index);
        addTaint(originalString.getTaint());
        addTaint(span.getTaint());
        try 
        {
            mService.notifySuggestionPicked(span, originalString, index);
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_825833409 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_825833409.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_825833409;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.notifySuggestionPicked(span, originalString, index);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.463 -0400", hash_original_method = "FCDCA2DC24AB76EAA903F8369A9A45F8", hash_generated_method = "444EEE6259545778FBE12E3E8C7DB0C9")
    public boolean isFullscreenMode() {
        boolean var21C88B20DA84168713D6AAB9A7589738_1060537557 = (mFullscreenMode);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1875300421 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1875300421;
        // ---------- Original Method ----------
        //return mFullscreenMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.463 -0400", hash_original_method = "BC82DFD48282D1B48FE7389621C80801", hash_generated_method = "FBA9BB661A926040CD8B2605E30729C2")
    public boolean isActive(View view) {
        addTaint(view.getTaint());
        checkFocus();
        synchronized
(mH)        {
            boolean var66AA8B9F4E63B3F44EA480DC171D9805_406320702 = ((mServedView == view
                    || (mServedView != null
                            && mServedView.checkInputConnectionProxy(view)))
                    && mCurrentTextBoxAttribute != null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1561703455 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1561703455;
        } //End block
        // ---------- Original Method ----------
        //checkFocus();
        //synchronized (mH) {
            //return (mServedView == view
                    //|| (mServedView != null
                            //&& mServedView.checkInputConnectionProxy(view)))
                    //&& mCurrentTextBoxAttribute != null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.464 -0400", hash_original_method = "36DF2A9A4D9117D0F00790A34A3AF373", hash_generated_method = "5D9300425162E6C4163E785138805A2F")
    public boolean isActive() {
        checkFocus();
        synchronized
(mH)        {
            boolean varBB0CEA0C9E6F127AC4C2F90A80CCCBF9_22226293 = (mServedView != null && mCurrentTextBoxAttribute != null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1992689659 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1992689659;
        } //End block
        // ---------- Original Method ----------
        //checkFocus();
        //synchronized (mH) {
            //return mServedView != null && mCurrentTextBoxAttribute != null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.464 -0400", hash_original_method = "A9275A3C5F8B97D3BA22658E0542618D", hash_generated_method = "3009F810B48C2840324ABECA1897531E")
    public boolean isAcceptingText() {
        checkFocus();
        boolean var8562F8F908DA04D4207AD28139C892F4_951914546 = (mServedInputConnection != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_237684363 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_237684363;
        // ---------- Original Method ----------
        //checkFocus();
        //return mServedInputConnection != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.465 -0400", hash_original_method = "3A92950E40C3C85A49E393646C27AEA9", hash_generated_method = "D4740FFBD500B6D301DCC0D1B2CFF8E6")
     void clearBindingLocked() {
        clearConnectionLocked();
        mBindSequence = -1;
        mCurId = null;
        mCurMethod = null;
        // ---------- Original Method ----------
        //clearConnectionLocked();
        //mBindSequence = -1;
        //mCurId = null;
        //mCurMethod = null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.465 -0400", hash_original_method = "7C74580464CD8E195E3FB8BED8B93C53", hash_generated_method = "EFB7670AA252AD66E15371A32A6F6C81")
     void clearConnectionLocked() {
        mCurrentTextBoxAttribute = null;
        mServedInputConnection = null;
        // ---------- Original Method ----------
        //mCurrentTextBoxAttribute = null;
        //mServedInputConnection = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.466 -0400", hash_original_method = "1D1918AFC608107C503CFA70B5918395", hash_generated_method = "4D3E2B6C0C35942436DBC53B9E22A300")
     void finishInputLocked() {
        mNextServedView = null;
    if(mServedView != null)        
        {
    if(DEBUG){ }    if(mCurrentTextBoxAttribute != null)            
            {
                try 
                {
                    mService.finishInput(mClient);
                } //End block
                catch (RemoteException e)
                {
                } //End block
            } //End block
    if(mServedInputConnection != null)            
            {
                Handler vh = mServedView.getHandler();
    if(vh != null)                
                {
                    vh.sendMessage(vh.obtainMessage(ViewRootImpl.FINISH_INPUT_CONNECTION,
                            mServedInputConnection));
                } //End block
            } //End block
            mServedView = null;
            mCompletions = null;
            mServedConnecting = false;
            clearConnectionLocked();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.466 -0400", hash_original_method = "55A79A529B0E338884C3A2F27FEDBFDF", hash_generated_method = "A3F02A6853C0AE306D5DA86B99CDD374")
    public void reportFinishInputConnection(InputConnection ic) {
        addTaint(ic.getTaint());
    if(mServedInputConnection != ic)        
        {
            ic.finishComposingText();
        } //End block
        // ---------- Original Method ----------
        //if (mServedInputConnection != ic) {
            //ic.finishComposingText();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.467 -0400", hash_original_method = "2ABAAA397EA24F350376BE11BDE21CC8", hash_generated_method = "6D21E4A196E151B2D91A4AEC06BC50D9")
    public void displayCompletions(View view, CompletionInfo[] completions) {
        addTaint(view.getTaint());
        checkFocus();
        synchronized
(mH)        {
    if(mServedView != view && (mServedView == null
                            || !mServedView.checkInputConnectionProxy(view)))            
            {
                return;
            } //End block
            mCompletions = completions;
    if(mCurMethod != null)            
            {
                try 
                {
                    mCurMethod.displayCompletions(mCompletions);
                } //End block
                catch (RemoteException e)
                {
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //checkFocus();
        //synchronized (mH) {
            //if (mServedView != view && (mServedView == null
                            //|| !mServedView.checkInputConnectionProxy(view))) {
                //return;
            //}
            //mCompletions = completions;
            //if (mCurMethod != null) {
                //try {
                    //mCurMethod.displayCompletions(mCompletions);
                //} catch (RemoteException e) {
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.467 -0400", hash_original_method = "51F483359287A71D0F033A0D1668F291", hash_generated_method = "DABDDF1355B17D63F620C30DCFD586DC")
    public void updateExtractedText(View view, int token, ExtractedText text) {
        addTaint(text.getTaint());
        addTaint(token);
        addTaint(view.getTaint());
        checkFocus();
        synchronized
(mH)        {
    if(mServedView != view && (mServedView == null
                    || !mServedView.checkInputConnectionProxy(view)))            
            {
                return;
            } //End block
    if(mCurMethod != null)            
            {
                try 
                {
                    mCurMethod.updateExtractedText(token, text);
                } //End block
                catch (RemoteException e)
                {
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //checkFocus();
        //synchronized (mH) {
            //if (mServedView != view && (mServedView == null
                    //|| !mServedView.checkInputConnectionProxy(view))) {
                //return;
            //}
            //if (mCurMethod != null) {
                //try {
                    //mCurMethod.updateExtractedText(token, text);
                //} catch (RemoteException e) {
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.468 -0400", hash_original_method = "8D2F613F92BFA1616CD527BE18090765", hash_generated_method = "A4E00F5B41CF1BA305BBA0C687D121C3")
    public boolean showSoftInput(View view, int flags) {
        addTaint(flags);
        addTaint(view.getTaint());
        boolean var41628D7736FAA5407A38B32DAED9019A_848167453 = (showSoftInput(view, flags, null));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_519560501 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_519560501;
        // ---------- Original Method ----------
        //return showSoftInput(view, flags, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.468 -0400", hash_original_method = "182A36951EBA765A4D1CAFFC02BFF851", hash_generated_method = "0FE1782BEBEA75BA6938FFE962BF513C")
    public boolean showSoftInput(View view, int flags, ResultReceiver resultReceiver) {
        addTaint(resultReceiver.getTaint());
        addTaint(flags);
        addTaint(view.getTaint());
        checkFocus();
        synchronized
(mH)        {
    if(mServedView != view && (mServedView == null
                    || !mServedView.checkInputConnectionProxy(view)))            
            {
                boolean var68934A3E9455FA72420237EB05902327_1234314698 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_662929420 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_662929420;
            } //End block
            try 
            {
                boolean var70E9CF5D2EAD7D5D373E3E57E703E5EC_1707908369 = (mService.showSoftInput(mClient, flags, resultReceiver));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1534719561 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1534719561;
            } //End block
            catch (RemoteException e)
            {
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_645314984 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_527679571 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_527679571;
        } //End block
        // ---------- Original Method ----------
        //checkFocus();
        //synchronized (mH) {
            //if (mServedView != view && (mServedView == null
                    //|| !mServedView.checkInputConnectionProxy(view))) {
                //return false;
            //}
            //try {
                //return mService.showSoftInput(mClient, flags, resultReceiver);
            //} catch (RemoteException e) {
            //}
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.469 -0400", hash_original_method = "5110555AB7D318C3F52B5C2085DD7CF4", hash_generated_method = "ED187209014239787D8ECCFDB2ED15ED")
    public void showSoftInputUnchecked(int flags, ResultReceiver resultReceiver) {
        addTaint(resultReceiver.getTaint());
        addTaint(flags);
        try 
        {
            mService.showSoftInput(mClient, flags, resultReceiver);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.showSoftInput(mClient, flags, resultReceiver);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.469 -0400", hash_original_method = "4391301CC9B8F998B7CF2FBAB148B8AA", hash_generated_method = "CF33CE355E3C9DD1321DECC02F3A6E1E")
    public boolean hideSoftInputFromWindow(IBinder windowToken, int flags) {
        addTaint(flags);
        addTaint(windowToken.getTaint());
        boolean varEC6673B190EBB01F5C474FB5E1D2B444_1000435152 = (hideSoftInputFromWindow(windowToken, flags, null));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1394039087 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1394039087;
        // ---------- Original Method ----------
        //return hideSoftInputFromWindow(windowToken, flags, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.469 -0400", hash_original_method = "0C97F129DA85CEA766FB3D7196531B26", hash_generated_method = "802D123FDAB3CCA3568CACF231404A7C")
    public boolean hideSoftInputFromWindow(IBinder windowToken, int flags,
            ResultReceiver resultReceiver) {
        addTaint(resultReceiver.getTaint());
        addTaint(flags);
        addTaint(windowToken.getTaint());
        checkFocus();
        synchronized
(mH)        {
    if(mServedView == null || mServedView.getWindowToken() != windowToken)            
            {
                boolean var68934A3E9455FA72420237EB05902327_765931376 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_41043205 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_41043205;
            } //End block
            try 
            {
                boolean var1E4256830B68A2F3007A7875AEFAF5D1_1081677276 = (mService.hideSoftInput(mClient, flags, resultReceiver));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1441955305 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1441955305;
            } //End block
            catch (RemoteException e)
            {
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_143880943 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1677733271 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1677733271;
        } //End block
        // ---------- Original Method ----------
        //checkFocus();
        //synchronized (mH) {
            //if (mServedView == null || mServedView.getWindowToken() != windowToken) {
                //return false;
            //}
            //try {
                //return mService.hideSoftInput(mClient, flags, resultReceiver);
            //} catch (RemoteException e) {
            //}
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.470 -0400", hash_original_method = "A530968907DBDDA36B89C5946F7EC59D", hash_generated_method = "B861650397128402BD8C1B45CA9E64BA")
    public void toggleSoftInputFromWindow(IBinder windowToken, int showFlags, int hideFlags) {
        addTaint(hideFlags);
        addTaint(showFlags);
        addTaint(windowToken.getTaint());
        synchronized
(mH)        {
    if(mServedView == null || mServedView.getWindowToken() != windowToken)            
            {
                return;
            } //End block
    if(mCurMethod != null)            
            {
                try 
                {
                    mCurMethod.toggleSoftInput(showFlags, hideFlags);
                } //End block
                catch (RemoteException e)
                {
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (mH) {
            //if (mServedView == null || mServedView.getWindowToken() != windowToken) {
                //return;
            //}
            //if (mCurMethod != null) {
                //try {
                    //mCurMethod.toggleSoftInput(showFlags, hideFlags);
                //} catch (RemoteException e) {
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.471 -0400", hash_original_method = "79211245E8E42CAB1585D75CD7067652", hash_generated_method = "4915271F86C0777E935ADB0654A37CDC")
    public void toggleSoftInput(int showFlags, int hideFlags) {
        addTaint(hideFlags);
        addTaint(showFlags);
    if(mCurMethod != null)        
        {
            try 
            {
                mCurMethod.toggleSoftInput(showFlags, hideFlags);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mCurMethod != null) {
            //try {
                //mCurMethod.toggleSoftInput(showFlags, hideFlags);
            //} catch (RemoteException e) {
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.471 -0400", hash_original_method = "A40BE330B9742EEEBB8728870BF9ED45", hash_generated_method = "070F1DA185BEBE42FB9FC4E82DD11AE8")
    public void restartInput(View view) {
        addTaint(view.getTaint());
        checkFocus();
        synchronized
(mH)        {
    if(mServedView != view && (mServedView == null
                    || !mServedView.checkInputConnectionProxy(view)))            
            {
                return;
            } //End block
            mServedConnecting = true;
        } //End block
        startInputInner();
        // ---------- Original Method ----------
        //checkFocus();
        //synchronized (mH) {
            //if (mServedView != view && (mServedView == null
                    //|| !mServedView.checkInputConnectionProxy(view))) {
                //return;
            //}
            //mServedConnecting = true;
        //}
        //startInputInner();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.473 -0400", hash_original_method = "B3B1285322786DD26A60C9F9B7802F4B", hash_generated_method = "1D0482FCEBC64F645A404D35D53ACADE")
     void startInputInner() {
        View view;
        synchronized
(mH)        {
            view = mServedView;
    if(DEBUG){ }    if(view == null)            
            {
    if(DEBUG){ }                return;
            } //End block
        } //End block
        Handler vh = view.getHandler();
    if(vh == null)        
        {
    if(DEBUG){ }            return;
        } //End block
    if(vh.getLooper() != Looper.myLooper())        
        {
    if(DEBUG){ }            vh.post(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.472 -0400", hash_original_method = "BAD6C7ED699C9A68B8082FE4BB335F01", hash_generated_method = "997F4E26C6EE75BE46DC00501A56EA99")
        public void run() {
            startInputInner();
            // ---------- Original Method ----------
            //startInputInner();
        }
});
            return;
        } //End block
        EditorInfo tba = new EditorInfo();
        tba.packageName = view.getContext().getPackageName();
        tba.fieldId = view.getId();
        InputConnection ic = view.onCreateInputConnection(tba);
    if(DEBUG){ }        synchronized
(mH)        {
    if(mServedView != view || !mServedConnecting)            
            {
    if(DEBUG){ }                return;
            } //End block
            final boolean initial = mCurrentTextBoxAttribute == null;
            mCurrentTextBoxAttribute = tba;
            mServedConnecting = false;
            mServedInputConnection = ic;
            IInputContext servedContext;
    if(ic != null)            
            {
                mCursorSelStart = tba.initialSelStart;
                mCursorSelEnd = tba.initialSelEnd;
                mCursorCandStart = -1;
                mCursorCandEnd = -1;
                mCursorRect.setEmpty();
                servedContext = new ControlledInputConnectionWrapper(vh.getLooper(), ic, this);
            } //End block
            else
            {
                servedContext = null;
            } //End block
            try 
            {
    if(DEBUG){ }                InputBindResult res = mService.startInput(mClient,
                        servedContext, tba, initial, true);
    if(DEBUG){ }    if(res != null)                
                {
    if(res.id != null)                    
                    {
                        mBindSequence = res.sequence;
                        mCurMethod = res.method;
                    } //End block
                    else
    if(mCurMethod == null)                    
                    {
    if(DEBUG){ }                        return;
                    } //End block
                } //End block
    if(mCurMethod != null && mCompletions != null)                
                {
                    try 
                    {
                        mCurMethod.displayCompletions(mCompletions);
                    } //End block
                    catch (RemoteException e)
                    {
                    } //End block
                } //End block
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.474 -0400", hash_original_method = "574E98E1F1761FC0DC94CE21F83FBF8C", hash_generated_method = "4D81D76D15CFF61AE0032BECFD59FC02")
    public void windowDismissed(IBinder appWindowToken) {
        addTaint(appWindowToken.getTaint());
        checkFocus();
        synchronized
(mH)        {
    if(mServedView != null &&
                    mServedView.getWindowToken() == appWindowToken)            
            {
                finishInputLocked();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //checkFocus();
        //synchronized (mH) {
            //if (mServedView != null &&
                    //mServedView.getWindowToken() == appWindowToken) {
                //finishInputLocked();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.474 -0400", hash_original_method = "3DD6E391932A9CCCB1C61486572B8B95", hash_generated_method = "1875EA8926CC9B820D472611DCDF2FDE")
    public void focusIn(View view) {
        addTaint(view.getTaint());
        synchronized
(mH)        {
            focusInLocked(view);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mH) {
            //focusInLocked(view);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.474 -0400", hash_original_method = "3857011248BD1E1DC17E86CAECB63023", hash_generated_method = "F0BFE46A3CE202379F527C529F92B5A3")
     void focusInLocked(View view) {
    if(DEBUG){ }    if(mCurRootView != view.getRootView())        
        {
    if(DEBUG){ }            return;
        } //End block
        mNextServedView = view;
        scheduleCheckFocusLocked(view);
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "focusIn: " + view);
        //if (mCurRootView != view.getRootView()) {
            //if (DEBUG) Log.v(TAG, "Not IME target window, ignoring");
            //return;
        //}
        //mNextServedView = view;
        //scheduleCheckFocusLocked(view);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.475 -0400", hash_original_method = "CA0F410F50592B0E0C8F6A16050EA193", hash_generated_method = "475A287226C5A66FD9EF549C33DD228D")
    public void focusOut(View view) {
        addTaint(view.getTaint());
        synchronized
(mH)        {
    if(DEBUG){ }    if(mServedView != view)            
            {
    if(false && view.hasWindowFocus())                
                {
                    mNextServedView = null;
                    scheduleCheckFocusLocked(view);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (mH) {
            //if (DEBUG) Log.v(TAG, "focusOut: " + view
                    //+ " mServedView=" + mServedView
                    //+ " winFocus=" + view.hasWindowFocus());
            //if (mServedView != view) {
                //if (false && view.hasWindowFocus()) {
                    //mNextServedView = null;
                    //scheduleCheckFocusLocked(view);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.475 -0400", hash_original_method = "4A6B64189F9C851EAF66731814D5760A", hash_generated_method = "FF429D54DAA208CA1129D5F43D2E897C")
     void scheduleCheckFocusLocked(View view) {
        addTaint(view.getTaint());
        Handler vh = view.getHandler();
    if(vh != null && !vh.hasMessages(ViewRootImpl.CHECK_FOCUS))        
        {
            vh.sendMessage(vh.obtainMessage(ViewRootImpl.CHECK_FOCUS));
        } //End block
        // ---------- Original Method ----------
        //Handler vh = view.getHandler();
        //if (vh != null && !vh.hasMessages(ViewRootImpl.CHECK_FOCUS)) {
            //vh.sendMessage(vh.obtainMessage(ViewRootImpl.CHECK_FOCUS));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.476 -0400", hash_original_method = "7D116D001C63CE498592C7AACB0DA356", hash_generated_method = "3BE962DE6E10FCEC8C8BF62DB6EF49A7")
    public void checkFocus() {
    if(mServedView == mNextServedView && !mNextServedNeedsStart)        
        {
            return;
        } //End block
        InputConnection ic = null;
        synchronized
(mH)        {
    if(mServedView == mNextServedView && !mNextServedNeedsStart)            
            {
                return;
            } //End block
    if(DEBUG){ }            mNextServedNeedsStart = false;
    if(mNextServedView == null)            
            {
                finishInputLocked();
                closeCurrentInput();
                return;
            } //End block
            ic = mServedInputConnection;
            mServedView = mNextServedView;
            mCurrentTextBoxAttribute = null;
            mCompletions = null;
            mServedConnecting = true;
        } //End block
    if(ic != null)        
        {
            ic.finishComposingText();
        } //End block
        startInputInner();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.477 -0400", hash_original_method = "D0A5B4195CF8CF9C3EE8D9642BA1EAAF", hash_generated_method = "5A628AEF90E75D609FFF8B673EF711D1")
     void closeCurrentInput() {
        try 
        {
            mService.hideSoftInput(mClient, HIDE_NOT_ALWAYS, null);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.hideSoftInput(mClient, HIDE_NOT_ALWAYS, null);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.477 -0400", hash_original_method = "4893EC862C01D5D2A6E85A7017E94B9B", hash_generated_method = "ED58CCC433760687FDF522A84949FC15")
    public void onWindowFocus(View rootView, View focusedView, int softInputMode,
            boolean first, int windowFlags) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(windowFlags);
        addTaint(first);
        addTaint(softInputMode);
        addTaint(focusedView.getTaint());
        addTaint(rootView.getTaint());
        synchronized
(mH)        {
    if(DEBUG){ }    if(mHasBeenInactive)            
            {
    if(DEBUG){ }                mHasBeenInactive = false;
                mNextServedNeedsStart = true;
            } //End block
            focusInLocked(focusedView != null ? focusedView : rootView);
        } //End block
        checkFocus();
        synchronized
(mH)        {
            try 
            {
                final boolean isTextEditor = focusedView != null &&
                        focusedView.onCheckIsTextEditor();
                mService.windowGainedFocus(mClient, rootView.getWindowToken(),
                        focusedView != null, isTextEditor, softInputMode, first,
                        windowFlags);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.478 -0400", hash_original_method = "1A7A85BD07D131CBE39BA9D28F0E6F2A", hash_generated_method = "0A208EAE955229328DAD0F6EFFFA781D")
    public void startGettingWindowFocus(View rootView) {
        synchronized
(mH)        {
            mCurRootView = rootView;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mH) {
            //mCurRootView = rootView;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.479 -0400", hash_original_method = "6EC728E52174DF43F39F15D376B96D59", hash_generated_method = "A7A81A7561DAABBB6063DBBA91742CCD")
    public void updateSelection(View view, int selStart, int selEnd,
            int candidatesStart, int candidatesEnd) {
        addTaint(view.getTaint());
        checkFocus();
        synchronized
(mH)        {
    if((mServedView != view && (mServedView == null
                        || !mServedView.checkInputConnectionProxy(view)))
                    || mCurrentTextBoxAttribute == null || mCurMethod == null)            
            {
                return;
            } //End block
    if(mCursorSelStart != selStart || mCursorSelEnd != selEnd
                    || mCursorCandStart != candidatesStart
                    || mCursorCandEnd != candidatesEnd)            
            {
    if(DEBUG)                
                Log.d(TAG, "updateSelection");
                try 
                {
    if(DEBUG){ }                    mCurMethod.updateSelection(mCursorSelStart, mCursorSelEnd,
                            selStart, selEnd, candidatesStart, candidatesEnd);
                    mCursorSelStart = selStart;
                    mCursorSelEnd = selEnd;
                    mCursorCandStart = candidatesStart;
                    mCursorCandEnd = candidatesEnd;
                } //End block
                catch (RemoteException e)
                {
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.480 -0400", hash_original_method = "8E5F47C036105189BFF71EB5625C4E3F", hash_generated_method = "229845A555356D6475D862564F582FDD")
    public void viewClicked(View view) {
        addTaint(view.getTaint());
        final boolean focusChanged = mServedView != mNextServedView;
        checkFocus();
        synchronized
(mH)        {
    if((mServedView != view && (mServedView == null
                    || !mServedView.checkInputConnectionProxy(view)))
                    || mCurrentTextBoxAttribute == null || mCurMethod == null)            
            {
                return;
            } //End block
            try 
            {
    if(DEBUG){ }                mCurMethod.viewClicked(focusChanged);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //final boolean focusChanged = mServedView != mNextServedView;
        //checkFocus();
        //synchronized (mH) {
            //if ((mServedView != view && (mServedView == null
                    //|| !mServedView.checkInputConnectionProxy(view)))
                    //|| mCurrentTextBoxAttribute == null || mCurMethod == null) {
                //return;
            //}
            //try {
                //if (DEBUG) Log.v(TAG, "onViewClicked: " + focusChanged);
                //mCurMethod.viewClicked(focusChanged);
            //} catch (RemoteException e) {
                //Log.w(TAG, "IME died: " + mCurId, e);
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.480 -0400", hash_original_method = "385DC57C25B266614A0F3F767A2E43B1", hash_generated_method = "0453E634C975C2CBFF38EAE554982EF3")
    public boolean isWatchingCursor(View view) {
        addTaint(view.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_510002831 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_605340923 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_605340923;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.481 -0400", hash_original_method = "06AF2B97EC9C8BBE1303A237FE727449", hash_generated_method = "295EFDBEADF1112E86A6797429A98CE8")
    public void updateCursor(View view, int left, int top, int right, int bottom) {
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        addTaint(view.getTaint());
        checkFocus();
        synchronized
(mH)        {
    if((mServedView != view && (mServedView == null
                        || !mServedView.checkInputConnectionProxy(view)))
                    || mCurrentTextBoxAttribute == null || mCurMethod == null)            
            {
                return;
            } //End block
            mTmpCursorRect.set(left, top, right, bottom);
    if(!mCursorRect.equals(mTmpCursorRect))            
            {
    if(DEBUG)                
                Log.d(TAG, "updateCursor");
                try 
                {
    if(DEBUG){ }                    mCurMethod.updateCursor(mTmpCursorRect);
                    mCursorRect.set(mTmpCursorRect);
                } //End block
                catch (RemoteException e)
                {
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.481 -0400", hash_original_method = "42E6E13C0C5606029CE59DAABCC4FEF4", hash_generated_method = "6654EC4B7A9B70FEBFD405ADD7A032F4")
    public void sendAppPrivateCommand(View view, String action, Bundle data) {
        addTaint(data.getTaint());
        addTaint(action.getTaint());
        addTaint(view.getTaint());
        checkFocus();
        synchronized
(mH)        {
    if((mServedView != view && (mServedView == null
                        || !mServedView.checkInputConnectionProxy(view)))
                    || mCurrentTextBoxAttribute == null || mCurMethod == null)            
            {
                return;
            } //End block
            try 
            {
    if(DEBUG){ }                mCurMethod.appPrivateCommand(action, data);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //checkFocus();
        //synchronized (mH) {
            //if ((mServedView != view && (mServedView == null
                        //|| !mServedView.checkInputConnectionProxy(view)))
                    //|| mCurrentTextBoxAttribute == null || mCurMethod == null) {
                //return;
            //}
            //try {
                //if (DEBUG) Log.v(TAG, "APP PRIVATE COMMAND " + action + ": " + data);
                //mCurMethod.appPrivateCommand(action, data);
            //} catch (RemoteException e) {
                //Log.w(TAG, "IME died: " + mCurId, e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.482 -0400", hash_original_method = "BA3360E0078151C4E77F69CD0F708AC2", hash_generated_method = "677EA4C06357BA20F35272878B21ABAA")
    public void setInputMethod(IBinder token, String id) {
        addTaint(id.getTaint());
        addTaint(token.getTaint());
        try 
        {
            mService.setInputMethod(token, id);
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_1924887982 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_1924887982.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_1924887982;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.setInputMethod(token, id);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.482 -0400", hash_original_method = "6B5F7BD4B9987D792262BC3FA22B0356", hash_generated_method = "B41E41DF586C50D7B6267151D88A1167")
    public void setInputMethodAndSubtype(IBinder token, String id, InputMethodSubtype subtype) {
        addTaint(subtype.getTaint());
        addTaint(id.getTaint());
        addTaint(token.getTaint());
        try 
        {
            mService.setInputMethodAndSubtype(token, id, subtype);
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_1201896225 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_1201896225.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_1201896225;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.setInputMethodAndSubtype(token, id, subtype);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.483 -0400", hash_original_method = "57E46D0940B3C65A92751CB9C29D6161", hash_generated_method = "7CA56822D7C761B866E0ED1BE22B61EE")
    public void hideSoftInputFromInputMethod(IBinder token, int flags) {
        addTaint(flags);
        addTaint(token.getTaint());
        try 
        {
            mService.hideMySoftInput(token, flags);
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_904846006 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_904846006.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_904846006;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.hideMySoftInput(token, flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.483 -0400", hash_original_method = "E0804B4135D0004448137E06C89A5AC2", hash_generated_method = "FFD02740ECCB0896FE79C11F18177C38")
    public void showSoftInputFromInputMethod(IBinder token, int flags) {
        addTaint(flags);
        addTaint(token.getTaint());
        try 
        {
            mService.showMySoftInput(token, flags);
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_2052657128 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_2052657128.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_2052657128;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.showMySoftInput(token, flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.484 -0400", hash_original_method = "E668070B782BDDB11E06224CB9252B61", hash_generated_method = "11801685BA911C2696416FF91D7B874F")
    public void dispatchKeyEvent(Context context, int seq, KeyEvent key,
            IInputMethodCallback callback) {
        addTaint(callback.getTaint());
        addTaint(key.getTaint());
        addTaint(seq);
        addTaint(context.getTaint());
        synchronized
(mH)        {
    if(DEBUG)            
            Log.d(TAG, "dispatchKeyEvent");
    if(mCurMethod == null)            
            {
                try 
                {
                    callback.finishedEvent(seq, false);
                } //End block
                catch (RemoteException e)
                {
                } //End block
                return;
            } //End block
    if(key.getAction() == KeyEvent.ACTION_DOWN
                    && key.getKeyCode() == KeyEvent.KEYCODE_SYM)            
            {
                showInputMethodPicker();
                try 
                {
                    callback.finishedEvent(seq, true);
                } //End block
                catch (RemoteException e)
                {
                } //End block
                return;
            } //End block
            try 
            {
    if(DEBUG){ }                mCurMethod.dispatchKeyEvent(seq, key, callback);
            } //End block
            catch (RemoteException e)
            {
                try 
                {
                    callback.finishedEvent(seq, false);
                } //End block
                catch (RemoteException ex)
                {
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.485 -0400", hash_original_method = "99D2E1A6FD8F8DDA0CF04D3632103B0E", hash_generated_method = "A1A25E4D84233622766E5DD938E28B6B")
     void dispatchTrackballEvent(Context context, int seq, MotionEvent motion,
            IInputMethodCallback callback) {
        addTaint(callback.getTaint());
        addTaint(motion.getTaint());
        addTaint(seq);
        addTaint(context.getTaint());
        synchronized
(mH)        {
    if(DEBUG)            
            Log.d(TAG, "dispatchTrackballEvent");
    if(mCurMethod == null || mCurrentTextBoxAttribute == null)            
            {
                try 
                {
                    callback.finishedEvent(seq, false);
                } //End block
                catch (RemoteException e)
                {
                } //End block
                return;
            } //End block
            try 
            {
    if(DEBUG){ }                mCurMethod.dispatchTrackballEvent(seq, motion, callback);
            } //End block
            catch (RemoteException e)
            {
                try 
                {
                    callback.finishedEvent(seq, false);
                } //End block
                catch (RemoteException ex)
                {
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.486 -0400", hash_original_method = "032A4A57AEC9378F2AEDB365B55F6952", hash_generated_method = "07CF8A2DB7F9DD868A788A0573B6EFA3")
    public void showInputMethodPicker() {
        synchronized
(mH)        {
            try 
            {
                mService.showInputMethodPickerFromClient(mClient);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (mH) {
            //try {
                //mService.showInputMethodPickerFromClient(mClient);
            //} catch (RemoteException e) {
                //Log.w(TAG, "IME died: " + mCurId, e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.487 -0400", hash_original_method = "40ED720E9E0E9A18C34ACD22184580A8", hash_generated_method = "D93FB6B63676C7A4BECDEB0C83A97522")
    public void showInputMethodAndSubtypeEnabler(String imiId) {
        addTaint(imiId.getTaint());
        synchronized
(mH)        {
            try 
            {
                mService.showInputMethodAndSubtypeEnablerFromClient(mClient, imiId);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (mH) {
            //try {
                //mService.showInputMethodAndSubtypeEnablerFromClient(mClient, imiId);
            //} catch (RemoteException e) {
                //Log.w(TAG, "IME died: " + mCurId, e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.487 -0400", hash_original_method = "FD9F276F6D40BEB379032073F0CE055D", hash_generated_method = "AB37F2CA34A384DD2B1FE1AE5C17E3E9")
    public InputMethodSubtype getCurrentInputMethodSubtype() {
        synchronized
(mH)        {
            try 
            {
InputMethodSubtype var9658C72DA07C52E27EAE101FC3B0E8BF_415347116 =                 mService.getCurrentInputMethodSubtype();
                var9658C72DA07C52E27EAE101FC3B0E8BF_415347116.addTaint(taint);
                return var9658C72DA07C52E27EAE101FC3B0E8BF_415347116;
            } //End block
            catch (RemoteException e)
            {
InputMethodSubtype var540C13E9E156B687226421B24F2DF178_250660591 =                 null;
                var540C13E9E156B687226421B24F2DF178_250660591.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_250660591;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (mH) {
            //try {
                //return mService.getCurrentInputMethodSubtype();
            //} catch (RemoteException e) {
                //Log.w(TAG, "IME died: " + mCurId, e);
                //return null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.488 -0400", hash_original_method = "3CA77773C45BE29D3C7CB419603994A1", hash_generated_method = "9E2C7D30EB71D5D6B68E9CC33C0F8F2C")
    public boolean setCurrentInputMethodSubtype(InputMethodSubtype subtype) {
        addTaint(subtype.getTaint());
        synchronized
(mH)        {
            try 
            {
                boolean varDB4940A413ABB67533B45BC6995A6A40_706941373 = (mService.setCurrentInputMethodSubtype(subtype));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1802665111 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1802665111;
            } //End block
            catch (RemoteException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_1200678764 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1067452709 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1067452709;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (mH) {
            //try {
                //return mService.setCurrentInputMethodSubtype(subtype);
            //} catch (RemoteException e) {
                //Log.w(TAG, "IME died: " + mCurId, e);
                //return false;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.488 -0400", hash_original_method = "43A6DF9F5E808A92ECB1533408005E7F", hash_generated_method = "3F6CC7303C94A2C9EE252F4285E9B098")
    public Map<InputMethodInfo, List<InputMethodSubtype>> getShortcutInputMethodsAndSubtypes() {
        synchronized
(mH)        {
            HashMap<InputMethodInfo, List<InputMethodSubtype>> ret = new HashMap<InputMethodInfo, List<InputMethodSubtype>>();
            try 
            {
                List<Object> info = mService.getShortcutInputMethodsAndSubtypes();
                ArrayList<InputMethodSubtype> subtypes = null;
                final int N = info.size();
    if(info != null && N > 0)                
                {
for(int i = 0;i < N;++i)
                    {
                        Object o = info.get(i);
    if(o instanceof InputMethodInfo)                        
                        {
    if(ret.containsKey(o))                            
                            {
                                break;
                            } //End block
                            subtypes = new ArrayList<InputMethodSubtype>();
                            ret.put((InputMethodInfo)o, subtypes);
                        } //End block
                        else
    if(subtypes != null && o instanceof InputMethodSubtype)                        
                        {
                            subtypes.add((InputMethodSubtype)o);
                        } //End block
                    } //End block
                } //End block
            } //End block
            catch (RemoteException e)
            {
            } //End block
Map<InputMethodInfo, List<InputMethodSubtype>> varEDFF4FBBF053B5DC2B444ADFA049EE0F_2043420872 =             ret;
            varEDFF4FBBF053B5DC2B444ADFA049EE0F_2043420872.addTaint(taint);
            return varEDFF4FBBF053B5DC2B444ADFA049EE0F_2043420872;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.489 -0400", hash_original_method = "36F8CCF4190068A92F1E830BF76C0680", hash_generated_method = "85DFE9A47CFA661C81E8C014DB14EA6F")
    public boolean switchToLastInputMethod(IBinder imeToken) {
        addTaint(imeToken.getTaint());
        synchronized
(mH)        {
            try 
            {
                boolean var8E446ADFF5B3C47A0DE923099F1A6690_1190345920 = (mService.switchToLastInputMethod(imeToken));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_125258435 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_125258435;
            } //End block
            catch (RemoteException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_862273590 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1065850687 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1065850687;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (mH) {
            //try {
                //return mService.switchToLastInputMethod(imeToken);
            //} catch (RemoteException e) {
                //Log.w(TAG, "IME died: " + mCurId, e);
                //return false;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.490 -0400", hash_original_method = "E3938A1614AA74CBD638A5A0682603ED", hash_generated_method = "A424A64EF1042F545C351E51C1DFA9C6")
    public void setAdditionalInputMethodSubtypes(String imiId, InputMethodSubtype[] subtypes) {
        addTaint(subtypes[0].getTaint());
        addTaint(imiId.getTaint());
        synchronized
(mH)        {
            try 
            {
                mService.setAdditionalInputMethodSubtypes(imiId, subtypes);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (mH) {
            //try {
                //mService.setAdditionalInputMethodSubtypes(imiId, subtypes);
            //} catch (RemoteException e) {
                //Log.w(TAG, "IME died: " + mCurId, e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.490 -0400", hash_original_method = "D92C08014C42A358F015C9B31552925A", hash_generated_method = "96B9F1E83AA017FF384A45EB42557D1E")
    public InputMethodSubtype getLastInputMethodSubtype() {
        synchronized
(mH)        {
            try 
            {
InputMethodSubtype var16F0C678D9CB015A44EBE28C16A06773_715518033 =                 mService.getLastInputMethodSubtype();
                var16F0C678D9CB015A44EBE28C16A06773_715518033.addTaint(taint);
                return var16F0C678D9CB015A44EBE28C16A06773_715518033;
            } //End block
            catch (RemoteException e)
            {
InputMethodSubtype var540C13E9E156B687226421B24F2DF178_126322729 =                 null;
                var540C13E9E156B687226421B24F2DF178_126322729.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_126322729;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (mH) {
            //try {
                //return mService.getLastInputMethodSubtype();
            //} catch (RemoteException e) {
                //Log.w(TAG, "IME died: " + mCurId, e);
                //return null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.491 -0400", hash_original_method = "A669FCC83173C60A2ED2B3C5020338A1", hash_generated_method = "6E4C5AB618DC4BC1EA896DFC2D432554")
     void doDump(FileDescriptor fd, PrintWriter fout, String[] args) {
        addTaint(args[0].getTaint());
        addTaint(fout.getTaint());
        addTaint(fd.getTaint());
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
    if(mCurrentTextBoxAttribute != null)        
        {
            p.println("  mCurrentTextBoxAttribute:");
            mCurrentTextBoxAttribute.dump(p, "    ");
        } //End block
        else
        {
            p.println("  mCurrentTextBoxAttribute: null");
        } //End block
        p.println("  mServedInputConnection=" + mServedInputConnection);
        p.println("  mCompletions=" + mCompletions);
        p.println("  mCursorRect=" + mCursorRect);
        p.println("  mCursorSelStart=" + mCursorSelStart
                + " mCursorSelEnd=" + mCursorSelEnd
                + " mCursorCandStart=" + mCursorCandStart
                + " mCursorCandEnd=" + mCursorCandEnd);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    class H extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.491 -0400", hash_original_method = "6EF38EF9E91987FCDB2CC1FED5C76A24", hash_generated_method = "171D5E2268C2C0FB2DD94B8957DCF858")
          H(Looper looper) {
            super(looper);
            addTaint(looper.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.492 -0400", hash_original_method = "D40CD8B0041519F81016D036AC481E26", hash_generated_method = "B2B25E4792461D8E315370903DAF73F7")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
switch(msg.what){
            case MSG_DUMP:
            {
                HandlerCaller.SomeArgs args = (HandlerCaller.SomeArgs)msg.obj;
                try 
                {
                    doDump((FileDescriptor)args.arg1,
                                (PrintWriter)args.arg2, (String[])args.arg3);
                } //End block
                catch (RuntimeException e)
                {
                    ((PrintWriter)args.arg2).println("Exception: " + e);
                } //End block
                synchronized
(args.arg4)                {
                    ((CountDownLatch)args.arg4).countDown();
                } //End block
                return;
            } //End block
            case MSG_BIND:
            {
                final InputBindResult res = (InputBindResult)msg.obj;
                synchronized
(mH)                {
    if(mBindSequence < 0 || mBindSequence != res.sequence)                    
                    {
                        return;
                    } //End block
                    mCurMethod = res.method;
                    mCurId = res.id;
                    mBindSequence = res.sequence;
                } //End block
                startInputInner();
                return;
            } //End block
            case MSG_UNBIND:
            {
                final int sequence = msg.arg1;
                synchronized
(mH)                {
    if(mBindSequence == sequence)                    
                    {
    if(false)                        
                        {
    if(mCurMethod != null && mCurrentTextBoxAttribute != null)                            
                            {
                                try 
                                {
                                    mCurMethod.finishInput();
                                } //End block
                                catch (RemoteException e)
                                {
                                } //End block
                            } //End block
                        } //End block
                        clearBindingLocked();
    if(mServedView != null && mServedView.isFocused())                        
                        {
                            mServedConnecting = true;
                        } //End block
                    } //End block
                    startInputInner();
                } //End block
                return;
            } //End block
            case MSG_SET_ACTIVE:
            {
                final boolean active = msg.arg1 != 0;
                synchronized
(mH)                {
                    mActive = active;
                    mFullscreenMode = false;
    if(!active)                    
                    {
                        mHasBeenInactive = true;
                        try 
                        {
                            mIInputContext.finishComposingText();
                        } //End block
                        catch (RemoteException e)
                        {
                        } //End block
                    } //End block
                } //End block
                return;
            } //End block
}
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private static class ControlledInputConnectionWrapper extends IInputConnectionWrapper {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.493 -0400", hash_original_field = "4BD231895EADC77A5885859A0DCE2745", hash_generated_field = "9798BD50577982452DA631DD5C538942")

        private InputMethodManager mParentInputMethodManager;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.493 -0400", hash_original_method = "778EAAA875B5E9B35A79C47358BD4D78", hash_generated_method = "981CC9B51595C8DA7E72C72DD4B60993")
        public  ControlledInputConnectionWrapper(final Looper mainLooper, final InputConnection conn,
                final InputMethodManager inputMethodManager) {
            super(mainLooper, conn);
            addTaint(conn.getTaint());
            addTaint(mainLooper.getTaint());
            mParentInputMethodManager = inputMethodManager;
            // ---------- Original Method ----------
            //mParentInputMethodManager = inputMethodManager;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.493 -0400", hash_original_method = "FB049513493D8EDB25EAFF891B2EE0A9", hash_generated_method = "8636D8CEF05422F00300E37EFDDD85AB")
        @Override
        public boolean isActive() {
            boolean varE2C9D3F7971F80EB8C16F4B4FA09F04E_1439542772 = (mParentInputMethodManager.mActive);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1485917421 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1485917421;
            // ---------- Original Method ----------
            //return mParentInputMethodManager.mActive;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.494 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "F09208C088E716A2CD36A97B937BB5EA")

    static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.494 -0400", hash_original_field = "198D4E7EC1D9AEEA0CC4EE019C0C0999", hash_generated_field = "FE423FA5D3056FFD91C65F642D943473")

    static final String TAG = "InputMethodManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.494 -0400", hash_original_field = "03A98D5E0621C030BCDBF77610AA1147", hash_generated_field = "8E1374FF2568A6E7DF58ACEEF1A2A836")

    static final Object mInstanceSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.494 -0400", hash_original_field = "DD62467EBA66E288A1769E403146FE2D", hash_generated_field = "70278290516934488710CF458A67B14F")

    static InputMethodManager mInstance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.494 -0400", hash_original_field = "B8629205786C5EBA73C82A12AE29AFE7", hash_generated_field = "29E3688958B2990B4C392F7BA34B78FE")

    static final int MSG_DUMP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.494 -0400", hash_original_field = "FFA57EE67847D01D32351A0C94DC0B6D", hash_generated_field = "00F2010EA24613AFCCBC353F90339FF1")

    static final int MSG_BIND = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.494 -0400", hash_original_field = "8AC43D013FCCCB55AE24AB269980CE03", hash_generated_field = "4E6A324B7DC0A9F424DCDAA6789BFECC")

    static final int MSG_UNBIND = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.494 -0400", hash_original_field = "E30FD8D29111DD2ECEB4DE63E4F1CCFF", hash_generated_field = "28C1B3169E7E5F84C5E110F229FC0C97")

    static final int MSG_SET_ACTIVE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.494 -0400", hash_original_field = "AF301AB8FC51C3751F543BE4EA3AF5EB", hash_generated_field = "C03CF0054237DB2475EF4E292BEF892A")

    public static final int SHOW_IMPLICIT = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.494 -0400", hash_original_field = "99DB66177A84F468AEEB2AD091BC6A1C", hash_generated_field = "7BA61FD409340B0C8E775EB75D40DCFF")

    public static final int SHOW_FORCED = 0x0002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.494 -0400", hash_original_field = "1893396B376E30F240917266CAD4133B", hash_generated_field = "6DE1572C40D7A706B1F6E877EF1C7AEA")

    public static final int RESULT_UNCHANGED_SHOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.494 -0400", hash_original_field = "FF2615E676946E405A41B4A827A5B922", hash_generated_field = "0D7072043387926ADE4C173684F81871")

    public static final int RESULT_UNCHANGED_HIDDEN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.494 -0400", hash_original_field = "AC49B0A43F4A7036636BAB8E93E598D5", hash_generated_field = "DA3162CDE4E12E374EB18AA57480909B")

    public static final int RESULT_SHOWN = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.494 -0400", hash_original_field = "5C4269E94C0C68D01737F330702D036A", hash_generated_field = "32D8F39D75725376FDFC286B2EA27F45")

    public static final int RESULT_HIDDEN = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.494 -0400", hash_original_field = "2093854B220BEEADFCA5D74555336500", hash_generated_field = "58F91761BACAED73D8EF194F02D9EA57")

    public static final int HIDE_IMPLICIT_ONLY = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.494 -0400", hash_original_field = "EB0723B8D7A71207C943C9F5CCA7FEB6", hash_generated_field = "03F311607F79D8F57E9DA6C29B046EF2")

    public static final int HIDE_NOT_ALWAYS = 0x0002;
}

