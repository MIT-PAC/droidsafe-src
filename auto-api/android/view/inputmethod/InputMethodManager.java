package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.440 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "AF4D994570007AEC23008412E21170BC")

    IInputMethodManager mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.440 -0400", hash_original_field = "6C2EA91B438529F1372D806717F5AE04", hash_generated_field = "22AA67C96F8F7AD7DFD89E53DF216F9A")

    Looper mMainLooper;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.440 -0400", hash_original_field = "6D1DA64E705BB119454CD3D6A13CB760", hash_generated_field = "4DD8CF7D1E2B224E6925E028DA6C7C60")

    H mH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.440 -0400", hash_original_field = "4AC36937F366B7AB4CCDC4F1F414F47C", hash_generated_field = "72027A70482354298567E3297708A343")

    IInputContext mIInputContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.440 -0400", hash_original_field = "43EEA9F366EE6D438612A98DC9C5FC93", hash_generated_field = "844E46882A240B061C638C1091315129")

    boolean mActive = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.440 -0400", hash_original_field = "C6C64E873A8D5F838497C395DB968AA6", hash_generated_field = "7B2E6D1E4DF1C0EAF8EAE346683AD3D8")

    boolean mHasBeenInactive = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.440 -0400", hash_original_field = "21C88B20DA84168713D6AAB9A7589738", hash_generated_field = "7A6D29D78DDDB849117195D1575B1D0D")

    boolean mFullscreenMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.440 -0400", hash_original_field = "7C403604AF27C19B706DB901961790F3", hash_generated_field = "8610B5C69CA08D5F83A8EDAD499B41DF")

    View mCurRootView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.440 -0400", hash_original_field = "276384D0701C2515D37ABAEB0BB07CF1", hash_generated_field = "A54183C371A5C91679B93D582850D821")

    View mServedView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.440 -0400", hash_original_field = "8A6701709B1BF571CC720A8C0186A3A1", hash_generated_field = "37CB9C3A74C8E8A1DCD593663CB659AC")

    View mNextServedView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.440 -0400", hash_original_field = "07A5D2B2CA7B06E26DDA4CEA3D0F998F", hash_generated_field = "1CF172770CCCC42619E82625D27683E4")

    boolean mNextServedNeedsStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.440 -0400", hash_original_field = "6FEA88F2097C781265F07408D655FA08", hash_generated_field = "AA8EADE0DA95013FD81168358A40CC38")

    boolean mServedConnecting;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.440 -0400", hash_original_field = "C37631DCB334F3DE253566FE7E88827B", hash_generated_field = "F6752A3676A98F8319F142BFE09A3814")

    EditorInfo mCurrentTextBoxAttribute;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.440 -0400", hash_original_field = "F2741F7543BFA572357C0FCA31F8D3CA", hash_generated_field = "1069CCDD0BD720E7FA6763B4BE3FB768")

    InputConnection mServedInputConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.440 -0400", hash_original_field = "EEF2F22BDE2DAD179EF74F9D5A249F06", hash_generated_field = "37C04B17B3D71E2A78D5E95F178E79E6")

    CompletionInfo[] mCompletions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.440 -0400", hash_original_field = "6E5580956F347FC39333E30175D7959E", hash_generated_field = "79C750F90B6AC779C5BB9837C3C74CAB")

    Rect mTmpCursorRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.440 -0400", hash_original_field = "350B6C1DE46A8AE51B0B3EA7C5DA7FB3", hash_generated_field = "49E12E0B9B02D82DC1E7BF4D1DC2791F")

    Rect mCursorRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.440 -0400", hash_original_field = "6C4EB7C9764378AC3F07482431440688", hash_generated_field = "61370CAB7E613D3B51D5F05A3E7881EC")

    int mCursorSelStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.440 -0400", hash_original_field = "7F3420A9E671AF58A6B367314A292BE4", hash_generated_field = "EE54263B133ACFB15E11DD2491E1A3B9")

    int mCursorSelEnd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.440 -0400", hash_original_field = "348A4A071E9816A33884E58F89D8D45F", hash_generated_field = "1CD08C23B7F290112A0ABF5F99E6CD72")

    int mCursorCandStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.440 -0400", hash_original_field = "03AAABA3C7C79FEB761E8C53CF9CE377", hash_generated_field = "BF24EA98ADDF2C881C86310B37BA9EE6")

    int mCursorCandEnd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.440 -0400", hash_original_field = "31D04805CE4EE92E41E4F9B05CE76B8E", hash_generated_field = "C983A711DB3B897D81814DB669E54903")

    int mBindSequence = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.440 -0400", hash_original_field = "878F6B32EA64F5E90AF6FFF354C354D2", hash_generated_field = "B8DB1FCD85A9BF1BC30DF0BD30881CBD")

    String mCurId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.440 -0400", hash_original_field = "F3A12A28D252E9CCEBFAFF98ED723491", hash_generated_field = "ECFDF7AD8578511D0EA7676517144A2F")

    IInputMethodSession mCurMethod;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.453 -0400", hash_original_field = "BCB122DBAEAD09474F3177A327270EA8", hash_generated_field = "4178A08F1ECEC7076DA7D36CC02A8230")

    IInputMethodClient.Stub mClient = new IInputMethodClient.Stub() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.442 -0400", hash_original_method = "F6EA3706319B79FC567D288B23EBD7C8", hash_generated_method = "4D61F42DE2C7A2E1B3BD016F73D20757")
        @Override
        protected void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
            CountDownLatch latch;
            latch = new CountDownLatch(1);
            HandlerCaller.SomeArgs sargs;
            sargs = new HandlerCaller.SomeArgs();
            sargs.arg1 = fd;
            sargs.arg2 = fout;
            sargs.arg3 = args;
            sargs.arg4 = latch;
            mH.sendMessage(mH.obtainMessage(MSG_DUMP, sargs));
            try 
            {
                {
                    boolean var19E9A664FE2E8FD1F35B08B34B4A7B6E_139235615 = (!latch.await(5, TimeUnit.SECONDS));
                    {
                        fout.println("Timeout waiting for dump");
                    } //End block
                } //End collapsed parenthetic
            } //End block
            catch (InterruptedException e)
            {
                fout.println("Interrupted waiting for dump");
            } //End block
            addTaint(fd.getTaint());
            addTaint(fout.getTaint());
            addTaint(args[0].getTaint());
            // ---------- Original Method ----------
            //CountDownLatch latch = new CountDownLatch(1);
            //HandlerCaller.SomeArgs sargs = new HandlerCaller.SomeArgs();
            //sargs.arg1 = fd;
            //sargs.arg2 = fout;
            //sargs.arg3 = args;
            //sargs.arg4 = latch;
            //mH.sendMessage(mH.obtainMessage(MSG_DUMP, sargs));
            //try {
                //if (!latch.await(5, TimeUnit.SECONDS)) {
                    //fout.println("Timeout waiting for dump");
                //}
            //} catch (InterruptedException e) {
                //fout.println("Interrupted waiting for dump");
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.442 -0400", hash_original_method = "45BD5FF75807911B1CFCFBB58E96318E", hash_generated_method = "E89AC6B358CC1D0E0E8D60BFEB3BF192")
        public void setUsingInputMethod(boolean state) {
            addTaint(state);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.443 -0400", hash_original_method = "574FEF71BCEC075DFBB030A0D3C30C22", hash_generated_method = "2CC8A14340DD97B215BB7F37776C22E7")
        public void onBindMethod(InputBindResult res) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mH.sendMessage(mH.obtainMessage(MSG_BIND, res));
            addTaint(res.getTaint());
            // ---------- Original Method ----------
            //mH.sendMessage(mH.obtainMessage(MSG_BIND, res));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.443 -0400", hash_original_method = "588CEEFF7FA7882256433E31043E7659", hash_generated_method = "93B331FAA4D44012CC809EFD07D72DC5")
        public void onUnbindMethod(int sequence) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mH.sendMessage(mH.obtainMessage(MSG_UNBIND, sequence, 0));
            addTaint(sequence);
            // ---------- Original Method ----------
            //mH.sendMessage(mH.obtainMessage(MSG_UNBIND, sequence, 0));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.444 -0400", hash_original_method = "348B3468B5EF750F568EE6741021F563", hash_generated_method = "F00801DE5796A4FB5DF1A8F8529ED1F9")
        public void setActive(boolean active) {
            mH.sendMessage(mH.obtainMessage(MSG_SET_ACTIVE, active ? 1 : 0, 0));
            addTaint(active);
            // ---------- Original Method ----------
            //mH.sendMessage(mH.obtainMessage(MSG_SET_ACTIVE, active ? 1 : 0, 0));
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.454 -0400", hash_original_field = "73409FFD7A55CCEC18BF7235F49C6C2C", hash_generated_field = "857160D6CD8A26C79A4C0E2FBFA77DF6")

    InputConnection mDummyInputConnection = new BaseInputConnection(this, false);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.467 -0400", hash_original_method = "508ED56B5BF5DABABCAF5D12E61B17FA", hash_generated_method = "A789424FFA1099C3A4E75182E6A88F8D")
      InputMethodManager(IInputMethodManager service, Looper looper) {
        mService = service;
        mMainLooper = looper;
        mH = new H(looper);
        mIInputContext = new ControlledInputConnectionWrapper(looper,
                mDummyInputConnection, this);
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

    
        static public InputMethodManager peekInstance() {
        return mInstance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.468 -0400", hash_original_method = "3D9C93A013E7DC300254687B6593E9DE", hash_generated_method = "DAB6EF86AE8DCB86708F50E4A775CBBB")
    public IInputMethodClient getClient() {
        IInputMethodClient varB4EAC82CA7396A68D541C85D26508E83_543508850 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_543508850 = mClient;
        varB4EAC82CA7396A68D541C85D26508E83_543508850.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_543508850;
        // ---------- Original Method ----------
        //return mClient;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.469 -0400", hash_original_method = "BB1CC2AA4E519DFF3D7BB1A17FAAA9A1", hash_generated_method = "DE7D882BEA8CCC13AE7284C9C5611766")
    public IInputContext getInputContext() {
        IInputContext varB4EAC82CA7396A68D541C85D26508E83_405689447 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_405689447 = mIInputContext;
        varB4EAC82CA7396A68D541C85D26508E83_405689447.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_405689447;
        // ---------- Original Method ----------
        //return mIInputContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.469 -0400", hash_original_method = "4976C1493B414917938FA9CF9C859341", hash_generated_method = "4E9E4A0636646EEBD8BD69150CFEEF3A")
    public List<InputMethodInfo> getInputMethodList() {
        List<InputMethodInfo> varB4EAC82CA7396A68D541C85D26508E83_1453431885 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1453431885 = mService.getInputMethodList();
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1453431885.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1453431885;
        // ---------- Original Method ----------
        //try {
            //return mService.getInputMethodList();
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.479 -0400", hash_original_method = "E8BA85FCD94534AA9F0D8586DC21C83A", hash_generated_method = "F167A948EF3CC7E079B415D585CDEB5E")
    public List<InputMethodInfo> getEnabledInputMethodList() {
        List<InputMethodInfo> varB4EAC82CA7396A68D541C85D26508E83_1198477121 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1198477121 = mService.getEnabledInputMethodList();
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1198477121.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1198477121;
        // ---------- Original Method ----------
        //try {
            //return mService.getEnabledInputMethodList();
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.479 -0400", hash_original_method = "6701B30EF11ADDDCEFC97757F6DCE403", hash_generated_method = "FF2FE7A18069242931A4C167EC2D2B3C")
    public List<InputMethodSubtype> getEnabledInputMethodSubtypeList(InputMethodInfo imi,
            boolean allowsImplicitlySelectedSubtypes) {
        List<InputMethodSubtype> varB4EAC82CA7396A68D541C85D26508E83_1873765376 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1873765376 = mService.getEnabledInputMethodSubtypeList(imi, allowsImplicitlySelectedSubtypes);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        addTaint(imi.getTaint());
        addTaint(allowsImplicitlySelectedSubtypes);
        varB4EAC82CA7396A68D541C85D26508E83_1873765376.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1873765376;
        // ---------- Original Method ----------
        //try {
            //return mService.getEnabledInputMethodSubtypeList(imi, allowsImplicitlySelectedSubtypes);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.480 -0400", hash_original_method = "53B62C40B5B8B2FB3464E7DA6A87D443", hash_generated_method = "A679B9611AFCA36443CC3F7C2D438980")
    public void showStatusIcon(IBinder imeToken, String packageName, int iconId) {
        try 
        {
            mService.updateStatusIcon(imeToken, packageName, iconId);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        addTaint(imeToken.getTaint());
        addTaint(packageName.getTaint());
        addTaint(iconId);
        // ---------- Original Method ----------
        //try {
            //mService.updateStatusIcon(imeToken, packageName, iconId);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.480 -0400", hash_original_method = "D00BAF75C3098DFC4E35D122E494F4F9", hash_generated_method = "A84DBEF9DFB86AE2D1BC0772B076B041")
    public void hideStatusIcon(IBinder imeToken) {
        try 
        {
            mService.updateStatusIcon(imeToken, null, 0);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        addTaint(imeToken.getTaint());
        // ---------- Original Method ----------
        //try {
            //mService.updateStatusIcon(imeToken, null, 0);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.480 -0400", hash_original_method = "7375BD73E964162AE893F10DF6DE4659", hash_generated_method = "55979827B1CC03D615B10C51F5423DC2")
    public void setImeWindowStatus(IBinder imeToken, int vis, int backDisposition) {
        try 
        {
            mService.setImeWindowStatus(imeToken, vis, backDisposition);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        addTaint(imeToken.getTaint());
        addTaint(vis);
        addTaint(backDisposition);
        // ---------- Original Method ----------
        //try {
            //mService.setImeWindowStatus(imeToken, vis, backDisposition);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.481 -0400", hash_original_method = "E3510526CEDC6D4EEDFFA989F1389EB2", hash_generated_method = "DBF532BC0434234D838BC6C0A047FC02")
    public void setFullscreenMode(boolean fullScreen) {
        mFullscreenMode = fullScreen;
        // ---------- Original Method ----------
        //mFullscreenMode = fullScreen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.481 -0400", hash_original_method = "CEA057AD7D0092E84D73E0D04E9F9DEE", hash_generated_method = "BF2FB822AC189EA158FEFBA85C133EC1")
    public void registerSuggestionSpansForNotification(SuggestionSpan[] spans) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        try 
        {
            mService.registerSuggestionSpansForNotification(spans);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        addTaint(spans[0].getTaint());
        // ---------- Original Method ----------
        //try {
            //mService.registerSuggestionSpansForNotification(spans);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.481 -0400", hash_original_method = "67AB3FB4ECE37955692BC451DD457E24", hash_generated_method = "52CD7C056C3CDF0D908286A45B657FE8")
    public void notifySuggestionPicked(SuggestionSpan span, String originalString, int index) {
        try 
        {
            mService.notifySuggestionPicked(span, originalString, index);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        addTaint(span.getTaint());
        addTaint(originalString.getTaint());
        addTaint(index);
        // ---------- Original Method ----------
        //try {
            //mService.notifySuggestionPicked(span, originalString, index);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.482 -0400", hash_original_method = "FCDCA2DC24AB76EAA903F8369A9A45F8", hash_generated_method = "96F3DFEC129984909E68837B146CBFFC")
    public boolean isFullscreenMode() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1488205792 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1488205792;
        // ---------- Original Method ----------
        //return mFullscreenMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.482 -0400", hash_original_method = "BC82DFD48282D1B48FE7389621C80801", hash_generated_method = "5B6B12E62108604169B9BC1A9BEC8841")
    public boolean isActive(View view) {
        checkFocus();
        {
            boolean var49F5D3F91085A10D821F326D270E0A6F_936020871 = ((mServedView == view
                    || (mServedView != null
                            && mServedView.checkInputConnectionProxy(view)))
                    && mCurrentTextBoxAttribute != null);
        } //End block
        addTaint(view.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1024488025 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1024488025;
        // ---------- Original Method ----------
        //checkFocus();
        //synchronized (mH) {
            //return (mServedView == view
                    //|| (mServedView != null
                            //&& mServedView.checkInputConnectionProxy(view)))
                    //&& mCurrentTextBoxAttribute != null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.482 -0400", hash_original_method = "36DF2A9A4D9117D0F00790A34A3AF373", hash_generated_method = "95BA91EC18859EBBC30F1048576574B9")
    public boolean isActive() {
        checkFocus();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_570987896 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_570987896;
        // ---------- Original Method ----------
        //checkFocus();
        //synchronized (mH) {
            //return mServedView != null && mCurrentTextBoxAttribute != null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.494 -0400", hash_original_method = "A9275A3C5F8B97D3BA22658E0542618D", hash_generated_method = "8B428A2463D754071237AD2F6F1D6623")
    public boolean isAcceptingText() {
        checkFocus();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1072300962 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1072300962;
        // ---------- Original Method ----------
        //checkFocus();
        //return mServedInputConnection != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.494 -0400", hash_original_method = "3A92950E40C3C85A49E393646C27AEA9", hash_generated_method = "D4740FFBD500B6D301DCC0D1B2CFF8E6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.495 -0400", hash_original_method = "7C74580464CD8E195E3FB8BED8B93C53", hash_generated_method = "EFB7670AA252AD66E15371A32A6F6C81")
     void clearConnectionLocked() {
        mCurrentTextBoxAttribute = null;
        mServedInputConnection = null;
        // ---------- Original Method ----------
        //mCurrentTextBoxAttribute = null;
        //mServedInputConnection = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.496 -0400", hash_original_method = "1D1918AFC608107C503CFA70B5918395", hash_generated_method = "AA515DE0E16181137D969794CDE6AEA4")
     void finishInputLocked() {
        mNextServedView = null;
        {
            {
                try 
                {
                    mService.finishInput(mClient);
                } //End block
                catch (RemoteException e)
                { }
            } //End block
            {
                Handler vh;
                vh = mServedView.getHandler();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.496 -0400", hash_original_method = "55A79A529B0E338884C3A2F27FEDBFDF", hash_generated_method = "428F213740399011417EF40A43764BF5")
    public void reportFinishInputConnection(InputConnection ic) {
        {
            ic.finishComposingText();
        } //End block
        addTaint(ic.getTaint());
        // ---------- Original Method ----------
        //if (mServedInputConnection != ic) {
            //ic.finishComposingText();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.516 -0400", hash_original_method = "2ABAAA397EA24F350376BE11BDE21CC8", hash_generated_method = "187515E69F5C71FD359FD32C373A5258")
    public void displayCompletions(View view, CompletionInfo[] completions) {
        checkFocus();
        {
            {
                boolean varDB99D0AC55C2DBA21EBD734EA036F99E_52370503 = (mServedView != view && (mServedView == null
                            || !mServedView.checkInputConnectionProxy(view)));
            } //End collapsed parenthetic
            mCompletions = completions;
            {
                try 
                {
                    mCurMethod.displayCompletions(mCompletions);
                } //End block
                catch (RemoteException e)
                { }
            } //End block
        } //End block
        addTaint(view.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.517 -0400", hash_original_method = "51F483359287A71D0F033A0D1668F291", hash_generated_method = "6F9F12E3481CA1C5D298FE1F4E863B40")
    public void updateExtractedText(View view, int token, ExtractedText text) {
        checkFocus();
        {
            {
                boolean var5B46188F855DD0910683CAEF46B64CFE_1978897236 = (mServedView != view && (mServedView == null
                    || !mServedView.checkInputConnectionProxy(view)));
            } //End collapsed parenthetic
            {
                try 
                {
                    mCurMethod.updateExtractedText(token, text);
                } //End block
                catch (RemoteException e)
                { }
            } //End block
        } //End block
        addTaint(view.getTaint());
        addTaint(token);
        addTaint(text.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.518 -0400", hash_original_method = "8D2F613F92BFA1616CD527BE18090765", hash_generated_method = "51681ED8ABE1ACF3681B99B50E9389C1")
    public boolean showSoftInput(View view, int flags) {
        boolean var42A64BEF015E8CA610A96851B469250A_2003380450 = (showSoftInput(view, flags, null));
        addTaint(view.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_79238325 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_79238325;
        // ---------- Original Method ----------
        //return showSoftInput(view, flags, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.519 -0400", hash_original_method = "182A36951EBA765A4D1CAFFC02BFF851", hash_generated_method = "79DF15C02DE104C1DA4A1C2F569E05ED")
    public boolean showSoftInput(View view, int flags, ResultReceiver resultReceiver) {
        checkFocus();
        {
            {
                boolean var5B46188F855DD0910683CAEF46B64CFE_295853277 = (mServedView != view && (mServedView == null
                    || !mServedView.checkInputConnectionProxy(view)));
            } //End collapsed parenthetic
            try 
            {
                boolean varDFAA7336B82EE31799175E615A34D3DD_790767470 = (mService.showSoftInput(mClient, flags, resultReceiver));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(view.getTaint());
        addTaint(flags);
        addTaint(resultReceiver.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1568835043 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1568835043;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.519 -0400", hash_original_method = "5110555AB7D318C3F52B5C2085DD7CF4", hash_generated_method = "76A27BE27824CB8A46A3F7D8BA46FF9C")
    public void showSoftInputUnchecked(int flags, ResultReceiver resultReceiver) {
        try 
        {
            mService.showSoftInput(mClient, flags, resultReceiver);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(flags);
        addTaint(resultReceiver.getTaint());
        // ---------- Original Method ----------
        //try {
            //mService.showSoftInput(mClient, flags, resultReceiver);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.530 -0400", hash_original_method = "4391301CC9B8F998B7CF2FBAB148B8AA", hash_generated_method = "676F565063D667CC050D1787A377E89A")
    public boolean hideSoftInputFromWindow(IBinder windowToken, int flags) {
        boolean var658CF3AB42C3F6232FD0409B6B2947F4_487896727 = (hideSoftInputFromWindow(windowToken, flags, null));
        addTaint(windowToken.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1718910884 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1718910884;
        // ---------- Original Method ----------
        //return hideSoftInputFromWindow(windowToken, flags, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.531 -0400", hash_original_method = "0C97F129DA85CEA766FB3D7196531B26", hash_generated_method = "A241981DD94A1EF523F2493EA64235C3")
    public boolean hideSoftInputFromWindow(IBinder windowToken, int flags,
            ResultReceiver resultReceiver) {
        checkFocus();
        {
            {
                boolean var601FF64E452C8A4BAF1A32D29190540F_1032743048 = (mServedView == null || mServedView.getWindowToken() != windowToken);
            } //End collapsed parenthetic
            try 
            {
                boolean var5CACD3E08A6D77B7E674FDCDC8126BA5_644250529 = (mService.hideSoftInput(mClient, flags, resultReceiver));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(windowToken.getTaint());
        addTaint(flags);
        addTaint(resultReceiver.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1785468184 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1785468184;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.531 -0400", hash_original_method = "A530968907DBDDA36B89C5946F7EC59D", hash_generated_method = "12C0AAF32B51417D9D9A0E3E400E25CE")
    public void toggleSoftInputFromWindow(IBinder windowToken, int showFlags, int hideFlags) {
        {
            {
                boolean var601FF64E452C8A4BAF1A32D29190540F_924179681 = (mServedView == null || mServedView.getWindowToken() != windowToken);
            } //End collapsed parenthetic
            {
                try 
                {
                    mCurMethod.toggleSoftInput(showFlags, hideFlags);
                } //End block
                catch (RemoteException e)
                { }
            } //End block
        } //End block
        addTaint(windowToken.getTaint());
        addTaint(showFlags);
        addTaint(hideFlags);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.535 -0400", hash_original_method = "79211245E8E42CAB1585D75CD7067652", hash_generated_method = "2F38CF33C68B06E4B0E64C51D9236AAE")
    public void toggleSoftInput(int showFlags, int hideFlags) {
        {
            try 
            {
                mCurMethod.toggleSoftInput(showFlags, hideFlags);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(showFlags);
        addTaint(hideFlags);
        // ---------- Original Method ----------
        //if (mCurMethod != null) {
            //try {
                //mCurMethod.toggleSoftInput(showFlags, hideFlags);
            //} catch (RemoteException e) {
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.536 -0400", hash_original_method = "A40BE330B9742EEEBB8728870BF9ED45", hash_generated_method = "64EEEE25C5DDB9AE647AC18C7F43931B")
    public void restartInput(View view) {
        checkFocus();
        {
            {
                boolean var5B46188F855DD0910683CAEF46B64CFE_2109046707 = (mServedView != view && (mServedView == null
                    || !mServedView.checkInputConnectionProxy(view)));
            } //End collapsed parenthetic
            mServedConnecting = true;
        } //End block
        startInputInner();
        addTaint(view.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.552 -0400", hash_original_method = "B3B1285322786DD26A60C9F9B7802F4B", hash_generated_method = "04AAF63715B5ED301063C2F1579EC009")
     void startInputInner() {
        View view;
        {
            view = mServedView;
        } //End block
        Handler vh;
        vh = view.getHandler();
        {
            boolean varFAF728F056691316E709D0988E6B1364_941253141 = (vh.getLooper() != Looper.myLooper());
            {
                vh.post(new Runnable() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.543 -0400", hash_original_method = "BAD6C7ED699C9A68B8082FE4BB335F01", hash_generated_method = "997F4E26C6EE75BE46DC00501A56EA99")
                    public void run() {
                        startInputInner();
                        // ---------- Original Method ----------
                        //startInputInner();
                    }
});
            } //End block
        } //End collapsed parenthetic
        EditorInfo tba;
        tba = new EditorInfo();
        tba.packageName = view.getContext().getPackageName();
        tba.fieldId = view.getId();
        InputConnection ic;
        ic = view.onCreateInputConnection(tba);
        {
            boolean initial;
            initial = mCurrentTextBoxAttribute == null;
            mCurrentTextBoxAttribute = tba;
            mServedConnecting = false;
            mServedInputConnection = ic;
            IInputContext servedContext;
            {
                mCursorSelStart = tba.initialSelStart;
                mCursorSelEnd = tba.initialSelEnd;
                mCursorCandStart = -1;
                mCursorCandEnd = -1;
                mCursorRect.setEmpty();
                servedContext = new ControlledInputConnectionWrapper(vh.getLooper(), ic, this);
            } //End block
            {
                servedContext = null;
            } //End block
            try 
            {
                InputBindResult res;
                res = mService.startInput(mClient,
                        servedContext, tba, initial, true);
                {
                    {
                        mBindSequence = res.sequence;
                        mCurMethod = res.method;
                    } //End block
                } //End block
                {
                    try 
                    {
                        mCurMethod.displayCompletions(mCompletions);
                    } //End block
                    catch (RemoteException e)
                    { }
                } //End block
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.553 -0400", hash_original_method = "574E98E1F1761FC0DC94CE21F83FBF8C", hash_generated_method = "92852F3CB67C395CE4B26986F956BC04")
    public void windowDismissed(IBinder appWindowToken) {
        checkFocus();
        {
            {
                boolean var502A33EED994770E53552DF8C0F7D670_1375513271 = (mServedView != null &&
                    mServedView.getWindowToken() == appWindowToken);
                {
                    finishInputLocked();
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(appWindowToken.getTaint());
        // ---------- Original Method ----------
        //checkFocus();
        //synchronized (mH) {
            //if (mServedView != null &&
                    //mServedView.getWindowToken() == appWindowToken) {
                //finishInputLocked();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.554 -0400", hash_original_method = "3DD6E391932A9CCCB1C61486572B8B95", hash_generated_method = "0FB49711202CBC076877FDB58637B808")
    public void focusIn(View view) {
        {
            focusInLocked(view);
        } //End block
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        //synchronized (mH) {
            //focusInLocked(view);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.554 -0400", hash_original_method = "3857011248BD1E1DC17E86CAECB63023", hash_generated_method = "4370817591D3C44105B073D2A7E6AD22")
     void focusInLocked(View view) {
        {
            boolean var2071CEBD080665CA877F4A0459696EBB_820076663 = (mCurRootView != view.getRootView());
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.571 -0400", hash_original_method = "CA0F410F50592B0E0C8F6A16050EA193", hash_generated_method = "214CAF1D724897D5DC02A81817009CF8")
    public void focusOut(View view) {
        {
            {
                {
                    boolean varF1B8C4C009E1C99A6024E9498723A4C9_1334830649 = (false && view.hasWindowFocus());
                    {
                        mNextServedView = null;
                        scheduleCheckFocusLocked(view);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        addTaint(view.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.572 -0400", hash_original_method = "4A6B64189F9C851EAF66731814D5760A", hash_generated_method = "7EE05BE6F89D5465D8517B54061F5F2B")
     void scheduleCheckFocusLocked(View view) {
        Handler vh;
        vh = view.getHandler();
        {
            boolean varD62C9DEF2A1FD7096AF2D550C310DFDB_742624955 = (vh != null && !vh.hasMessages(ViewRootImpl.CHECK_FOCUS));
            {
                vh.sendMessage(vh.obtainMessage(ViewRootImpl.CHECK_FOCUS));
            } //End block
        } //End collapsed parenthetic
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        //Handler vh = view.getHandler();
        //if (vh != null && !vh.hasMessages(ViewRootImpl.CHECK_FOCUS)) {
            //vh.sendMessage(vh.obtainMessage(ViewRootImpl.CHECK_FOCUS));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.572 -0400", hash_original_method = "7D116D001C63CE498592C7AACB0DA356", hash_generated_method = "7D717F9128DCB2211A3C5138972290CE")
    public void checkFocus() {
        InputConnection ic;
        ic = null;
        {
            mNextServedNeedsStart = false;
            {
                finishInputLocked();
                closeCurrentInput();
            } //End block
            ic = mServedInputConnection;
            mServedView = mNextServedView;
            mCurrentTextBoxAttribute = null;
            mCompletions = null;
            mServedConnecting = true;
        } //End block
        {
            ic.finishComposingText();
        } //End block
        startInputInner();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.573 -0400", hash_original_method = "D0A5B4195CF8CF9C3EE8D9642BA1EAAF", hash_generated_method = "71DE39AC33B8D3F4BC97B84EA854C263")
     void closeCurrentInput() {
        try 
        {
            mService.hideSoftInput(mClient, HIDE_NOT_ALWAYS, null);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.hideSoftInput(mClient, HIDE_NOT_ALWAYS, null);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.574 -0400", hash_original_method = "4893EC862C01D5D2A6E85A7017E94B9B", hash_generated_method = "3C3F28864373974B5098C7D6B9B88538")
    public void onWindowFocus(View rootView, View focusedView, int softInputMode,
            boolean first, int windowFlags) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            {
                mHasBeenInactive = false;
                mNextServedNeedsStart = true;
            } //End block
            focusInLocked(focusedView != null ? focusedView : rootView);
        } //End block
        checkFocus();
        {
            try 
            {
                boolean isTextEditor;
                isTextEditor = focusedView != null &&
                        focusedView.onCheckIsTextEditor();
                mService.windowGainedFocus(mClient, rootView.getWindowToken(),
                        focusedView != null, isTextEditor, softInputMode, first,
                        windowFlags);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(rootView.getTaint());
        addTaint(focusedView.getTaint());
        addTaint(softInputMode);
        addTaint(first);
        addTaint(windowFlags);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.574 -0400", hash_original_method = "1A7A85BD07D131CBE39BA9D28F0E6F2A", hash_generated_method = "B9FF052D043E401AE8605F4965E6E768")
    public void startGettingWindowFocus(View rootView) {
        {
            mCurRootView = rootView;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mH) {
            //mCurRootView = rootView;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.585 -0400", hash_original_method = "6EC728E52174DF43F39F15D376B96D59", hash_generated_method = "63E1D2527E755C1ED42C60D77CD0E4F5")
    public void updateSelection(View view, int selStart, int selEnd,
            int candidatesStart, int candidatesEnd) {
        checkFocus();
        {
            {
                boolean varAE432C6DAE316B6F74A275D95170B0F0_1541337575 = ((mServedView != view && (mServedView == null
                        || !mServedView.checkInputConnectionProxy(view)))
                    || mCurrentTextBoxAttribute == null || mCurMethod == null);
            } //End collapsed parenthetic
            {
                Log.d(TAG, "updateSelection");
                try 
                {
                    mCurMethod.updateSelection(mCursorSelStart, mCursorSelEnd,
                            selStart, selEnd, candidatesStart, candidatesEnd);
                    mCursorSelStart = selStart;
                    mCursorSelEnd = selEnd;
                    mCursorCandStart = candidatesStart;
                    mCursorCandEnd = candidatesEnd;
                } //End block
                catch (RemoteException e)
                { }
            } //End block
        } //End block
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.592 -0400", hash_original_method = "8E5F47C036105189BFF71EB5625C4E3F", hash_generated_method = "5C1CFCBAEA77D445E5349AF7A9B56FFB")
    public void viewClicked(View view) {
        boolean focusChanged;
        focusChanged = mServedView != mNextServedView;
        checkFocus();
        {
            {
                boolean var9326F29C98DC4C69471B39D26338712B_1475173107 = ((mServedView != view && (mServedView == null
                    || !mServedView.checkInputConnectionProxy(view)))
                    || mCurrentTextBoxAttribute == null || mCurMethod == null);
            } //End collapsed parenthetic
            try 
            {
                mCurMethod.viewClicked(focusChanged);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(view.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.593 -0400", hash_original_method = "385DC57C25B266614A0F3F767A2E43B1", hash_generated_method = "AC86711E33263B8B5DD8FD89AED3983C")
    public boolean isWatchingCursor(View view) {
        addTaint(view.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_731277339 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_731277339;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.603 -0400", hash_original_method = "06AF2B97EC9C8BBE1303A237FE727449", hash_generated_method = "423D224D31C2784A10EF76862520FE1B")
    public void updateCursor(View view, int left, int top, int right, int bottom) {
        checkFocus();
        {
            {
                boolean varAE432C6DAE316B6F74A275D95170B0F0_451566691 = ((mServedView != view && (mServedView == null
                        || !mServedView.checkInputConnectionProxy(view)))
                    || mCurrentTextBoxAttribute == null || mCurMethod == null);
            } //End collapsed parenthetic
            mTmpCursorRect.set(left, top, right, bottom);
            {
                boolean var8D6B8539919CD2C288E2DD1195C4ABF6_583052052 = (!mCursorRect.equals(mTmpCursorRect));
                {
                    Log.d(TAG, "updateCursor");
                    try 
                    {
                        mCurMethod.updateCursor(mTmpCursorRect);
                        mCursorRect.set(mTmpCursorRect);
                    } //End block
                    catch (RemoteException e)
                    { }
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(view.getTaint());
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.604 -0400", hash_original_method = "42E6E13C0C5606029CE59DAABCC4FEF4", hash_generated_method = "50A37B6CF3E28F42E2BC8035C37D47FE")
    public void sendAppPrivateCommand(View view, String action, Bundle data) {
        checkFocus();
        {
            {
                boolean varAE432C6DAE316B6F74A275D95170B0F0_1239801504 = ((mServedView != view && (mServedView == null
                        || !mServedView.checkInputConnectionProxy(view)))
                    || mCurrentTextBoxAttribute == null || mCurMethod == null);
            } //End collapsed parenthetic
            try 
            {
                mCurMethod.appPrivateCommand(action, data);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(view.getTaint());
        addTaint(action.getTaint());
        addTaint(data.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.604 -0400", hash_original_method = "BA3360E0078151C4E77F69CD0F708AC2", hash_generated_method = "7208E9593F4C7CCCD03CBE54458499FA")
    public void setInputMethod(IBinder token, String id) {
        try 
        {
            mService.setInputMethod(token, id);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        addTaint(token.getTaint());
        addTaint(id.getTaint());
        // ---------- Original Method ----------
        //try {
            //mService.setInputMethod(token, id);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.604 -0400", hash_original_method = "6B5F7BD4B9987D792262BC3FA22B0356", hash_generated_method = "8D6D7F9A2373A84431F75A30D190E909")
    public void setInputMethodAndSubtype(IBinder token, String id, InputMethodSubtype subtype) {
        try 
        {
            mService.setInputMethodAndSubtype(token, id, subtype);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        addTaint(token.getTaint());
        addTaint(id.getTaint());
        addTaint(subtype.getTaint());
        // ---------- Original Method ----------
        //try {
            //mService.setInputMethodAndSubtype(token, id, subtype);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.605 -0400", hash_original_method = "57E46D0940B3C65A92751CB9C29D6161", hash_generated_method = "837A817CA1A93C64A6889CB2284647B9")
    public void hideSoftInputFromInputMethod(IBinder token, int flags) {
        try 
        {
            mService.hideMySoftInput(token, flags);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        addTaint(token.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //try {
            //mService.hideMySoftInput(token, flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.605 -0400", hash_original_method = "E0804B4135D0004448137E06C89A5AC2", hash_generated_method = "EE9217863C9F1053202CA9B44FB963A8")
    public void showSoftInputFromInputMethod(IBinder token, int flags) {
        try 
        {
            mService.showMySoftInput(token, flags);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        addTaint(token.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //try {
            //mService.showMySoftInput(token, flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.609 -0400", hash_original_method = "E668070B782BDDB11E06224CB9252B61", hash_generated_method = "0B9130AD942D2C885629B9AB047E266E")
    public void dispatchKeyEvent(Context context, int seq, KeyEvent key,
            IInputMethodCallback callback) {
        {
            Log.d(TAG, "dispatchKeyEvent");
            {
                try 
                {
                    callback.finishedEvent(seq, false);
                } //End block
                catch (RemoteException e)
                { }
            } //End block
            {
                boolean var209637C5B03F50E58BDA56A931544EE4_1526679993 = (key.getAction() == KeyEvent.ACTION_DOWN
                    && key.getKeyCode() == KeyEvent.KEYCODE_SYM);
                {
                    showInputMethodPicker();
                    try 
                    {
                        callback.finishedEvent(seq, true);
                    } //End block
                    catch (RemoteException e)
                    { }
                } //End block
            } //End collapsed parenthetic
            try 
            {
                mCurMethod.dispatchKeyEvent(seq, key, callback);
            } //End block
            catch (RemoteException e)
            {
                try 
                {
                    callback.finishedEvent(seq, false);
                } //End block
                catch (RemoteException ex)
                { }
            } //End block
        } //End block
        addTaint(context.getTaint());
        addTaint(seq);
        addTaint(key.getTaint());
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.613 -0400", hash_original_method = "99D2E1A6FD8F8DDA0CF04D3632103B0E", hash_generated_method = "2969D1C3BB5908CF735252C7E443CB79")
     void dispatchTrackballEvent(Context context, int seq, MotionEvent motion,
            IInputMethodCallback callback) {
        {
            Log.d(TAG, "dispatchTrackballEvent");
            {
                try 
                {
                    callback.finishedEvent(seq, false);
                } //End block
                catch (RemoteException e)
                { }
            } //End block
            try 
            {
                mCurMethod.dispatchTrackballEvent(seq, motion, callback);
            } //End block
            catch (RemoteException e)
            {
                try 
                {
                    callback.finishedEvent(seq, false);
                } //End block
                catch (RemoteException ex)
                { }
            } //End block
        } //End block
        addTaint(context.getTaint());
        addTaint(seq);
        addTaint(motion.getTaint());
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.614 -0400", hash_original_method = "032A4A57AEC9378F2AEDB365B55F6952", hash_generated_method = "3A675125C27FF9A084EDB85F14080C74")
    public void showInputMethodPicker() {
        {
            try 
            {
                mService.showInputMethodPickerFromClient(mClient);
            } //End block
            catch (RemoteException e)
            { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.614 -0400", hash_original_method = "40ED720E9E0E9A18C34ACD22184580A8", hash_generated_method = "8E9B33ED10E2005A78F7EE9EAD368A2E")
    public void showInputMethodAndSubtypeEnabler(String imiId) {
        {
            try 
            {
                mService.showInputMethodAndSubtypeEnablerFromClient(mClient, imiId);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(imiId.getTaint());
        // ---------- Original Method ----------
        //synchronized (mH) {
            //try {
                //mService.showInputMethodAndSubtypeEnablerFromClient(mClient, imiId);
            //} catch (RemoteException e) {
                //Log.w(TAG, "IME died: " + mCurId, e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.629 -0400", hash_original_method = "FD9F276F6D40BEB379032073F0CE055D", hash_generated_method = "C63CEB3753BF7F81EB1D8D8200C23233")
    public InputMethodSubtype getCurrentInputMethodSubtype() {
        InputMethodSubtype varB4EAC82CA7396A68D541C85D26508E83_790828882 = null; //Variable for return #1
        InputMethodSubtype varB4EAC82CA7396A68D541C85D26508E83_823810556 = null; //Variable for return #2
        {
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_790828882 = mService.getCurrentInputMethodSubtype();
            } //End block
            catch (RemoteException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_823810556 = null;
            } //End block
        } //End block
        InputMethodSubtype varA7E53CE21691AB073D9660D615818899_156398675; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_156398675 = varB4EAC82CA7396A68D541C85D26508E83_790828882;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_156398675 = varB4EAC82CA7396A68D541C85D26508E83_823810556;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_156398675.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_156398675;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.629 -0400", hash_original_method = "3CA77773C45BE29D3C7CB419603994A1", hash_generated_method = "981D0D597432ED64FF9D14ECD406B8F4")
    public boolean setCurrentInputMethodSubtype(InputMethodSubtype subtype) {
        {
            try 
            {
                boolean varB772562C6791056C6792B89901F04090_1366449292 = (mService.setCurrentInputMethodSubtype(subtype));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(subtype.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2136253802 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2136253802;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.630 -0400", hash_original_method = "43A6DF9F5E808A92ECB1533408005E7F", hash_generated_method = "46177B863919E61BB563FC64FAE49DF6")
    public Map<InputMethodInfo, List<InputMethodSubtype>> getShortcutInputMethodsAndSubtypes() {
        Map<InputMethodInfo, List<InputMethodSubtype>> varB4EAC82CA7396A68D541C85D26508E83_971147706 = null; //Variable for return #1
        {
            HashMap<InputMethodInfo, List<InputMethodSubtype>> ret;
            ret = new HashMap<InputMethodInfo, List<InputMethodSubtype>>();
            try 
            {
                List<Object> info;
                info = mService.getShortcutInputMethodsAndSubtypes();
                ArrayList<InputMethodSubtype> subtypes;
                subtypes = null;
                int N;
                N = info.size();
                {
                    {
                        int i;
                        i = 0;
                        {
                            Object o;
                            o = info.get(i);
                            {
                                {
                                    boolean var3270550FE2662AB18C2A8C4288E9FE37_624410394 = (ret.containsKey(o));
                                } //End collapsed parenthetic
                                subtypes = new ArrayList<InputMethodSubtype>();
                                ret.put((InputMethodInfo)o, subtypes);
                            } //End block
                            {
                                subtypes.add((InputMethodSubtype)o);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            catch (RemoteException e)
            { }
            varB4EAC82CA7396A68D541C85D26508E83_971147706 = ret;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_971147706.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_971147706;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.631 -0400", hash_original_method = "36F8CCF4190068A92F1E830BF76C0680", hash_generated_method = "CB8293E2A81BE353B0E8E3F7C2BC58E1")
    public boolean switchToLastInputMethod(IBinder imeToken) {
        {
            try 
            {
                boolean var8776571A2351650A62690661D0377A0B_166218945 = (mService.switchToLastInputMethod(imeToken));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(imeToken.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1398728082 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1398728082;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.631 -0400", hash_original_method = "E3938A1614AA74CBD638A5A0682603ED", hash_generated_method = "7856814220EE67D559E09A3399DCDAE3")
    public void setAdditionalInputMethodSubtypes(String imiId, InputMethodSubtype[] subtypes) {
        {
            try 
            {
                mService.setAdditionalInputMethodSubtypes(imiId, subtypes);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(imiId.getTaint());
        addTaint(subtypes[0].getTaint());
        // ---------- Original Method ----------
        //synchronized (mH) {
            //try {
                //mService.setAdditionalInputMethodSubtypes(imiId, subtypes);
            //} catch (RemoteException e) {
                //Log.w(TAG, "IME died: " + mCurId, e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.635 -0400", hash_original_method = "D92C08014C42A358F015C9B31552925A", hash_generated_method = "854835F89957773E8F064D00B3899DDD")
    public InputMethodSubtype getLastInputMethodSubtype() {
        InputMethodSubtype varB4EAC82CA7396A68D541C85D26508E83_243877886 = null; //Variable for return #1
        InputMethodSubtype varB4EAC82CA7396A68D541C85D26508E83_1781914898 = null; //Variable for return #2
        {
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_243877886 = mService.getLastInputMethodSubtype();
            } //End block
            catch (RemoteException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_1781914898 = null;
            } //End block
        } //End block
        InputMethodSubtype varA7E53CE21691AB073D9660D615818899_342036820; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_342036820 = varB4EAC82CA7396A68D541C85D26508E83_243877886;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_342036820 = varB4EAC82CA7396A68D541C85D26508E83_1781914898;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_342036820.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_342036820;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.645 -0400", hash_original_method = "A669FCC83173C60A2ED2B3C5020338A1", hash_generated_method = "AF234B8CE0149E2343C5E1CCB1D08E6A")
     void doDump(FileDescriptor fd, PrintWriter fout, String[] args) {
        Printer p;
        p = new PrintWriterPrinter(fout);
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
        {
            p.println("  mCurrentTextBoxAttribute:");
            mCurrentTextBoxAttribute.dump(p, "    ");
        } //End block
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
        addTaint(fd.getTaint());
        addTaint(fout.getTaint());
        addTaint(args[0].getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    class H extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.646 -0400", hash_original_method = "6EF38EF9E91987FCDB2CC1FED5C76A24", hash_generated_method = "171D5E2268C2C0FB2DD94B8957DCF858")
          H(Looper looper) {
            super(looper);
            addTaint(looper.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.650 -0400", hash_original_method = "D40CD8B0041519F81016D036AC481E26", hash_generated_method = "32A3604B8557D4E8314B4194D3E90812")
        @Override
        public void handleMessage(Message msg) {
            //Begin case MSG_DUMP 
            {
                HandlerCaller.SomeArgs args;
                args = (HandlerCaller.SomeArgs)msg.obj;
                try 
                {
                    doDump((FileDescriptor)args.arg1,
                                (PrintWriter)args.arg2, (String[])args.arg3);
                } //End block
                catch (RuntimeException e)
                {
                    ((PrintWriter)args.arg2).println("Exception: " + e);
                } //End block
                {
                    ((CountDownLatch)args.arg4).countDown();
                } //End block
            } //End block
            //End case MSG_DUMP 
            //Begin case MSG_BIND 
            {
                InputBindResult res;
                res = (InputBindResult)msg.obj;
                {
                    mCurMethod = res.method;
                    mCurId = res.id;
                    mBindSequence = res.sequence;
                } //End block
                startInputInner();
            } //End block
            //End case MSG_BIND 
            //Begin case MSG_UNBIND 
            {
                int sequence;
                sequence = msg.arg1;
                {
                    {
                        {
                            {
                                try 
                                {
                                    mCurMethod.finishInput();
                                } //End block
                                catch (RemoteException e)
                                { }
                            } //End block
                        } //End block
                        clearBindingLocked();
                        {
                            boolean varDE258C52FC90033C41FC87EA7E287047_1659465476 = (mServedView != null && mServedView.isFocused());
                            {
                                mServedConnecting = true;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    startInputInner();
                } //End block
            } //End block
            //End case MSG_UNBIND 
            //Begin case MSG_SET_ACTIVE 
            {
                boolean active;
                active = msg.arg1 != 0;
                {
                    mActive = active;
                    mFullscreenMode = false;
                    {
                        mHasBeenInactive = true;
                        try 
                        {
                            mIInputContext.finishComposingText();
                        } //End block
                        catch (RemoteException e)
                        { }
                    } //End block
                } //End block
            } //End block
            //End case MSG_SET_ACTIVE 
            addTaint(msg.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private static class ControlledInputConnectionWrapper extends IInputConnectionWrapper {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.652 -0400", hash_original_field = "4BD231895EADC77A5885859A0DCE2745", hash_generated_field = "9798BD50577982452DA631DD5C538942")

        private InputMethodManager mParentInputMethodManager;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.663 -0400", hash_original_method = "778EAAA875B5E9B35A79C47358BD4D78", hash_generated_method = "C3FF059C62D57F095A56A57A59484AB9")
        public  ControlledInputConnectionWrapper(final Looper mainLooper, final InputConnection conn,
                final InputMethodManager inputMethodManager) {
            super(mainLooper, conn);
            mParentInputMethodManager = inputMethodManager;
            addTaint(mainLooper.getTaint());
            addTaint(conn.getTaint());
            // ---------- Original Method ----------
            //mParentInputMethodManager = inputMethodManager;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.664 -0400", hash_original_method = "FB049513493D8EDB25EAFF891B2EE0A9", hash_generated_method = "F78BBDFE4CB93914CAE88433DD69C74C")
        @Override
        public boolean isActive() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_551514352 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_551514352;
            // ---------- Original Method ----------
            //return mParentInputMethodManager.mActive;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.664 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "99DFF1318F5BF79C590B7B00A696225C")

    static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.664 -0400", hash_original_field = "198D4E7EC1D9AEEA0CC4EE019C0C0999", hash_generated_field = "D81A3A661249F6FC8A62B8C5851789A1")

    static String TAG = "InputMethodManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.664 -0400", hash_original_field = "03A98D5E0621C030BCDBF77610AA1147", hash_generated_field = "9EC8912A3BC41C7D059AF004C67095F4")

    static Object mInstanceSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.664 -0400", hash_original_field = "DD62467EBA66E288A1769E403146FE2D", hash_generated_field = "70278290516934488710CF458A67B14F")

    static InputMethodManager mInstance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.664 -0400", hash_original_field = "B8629205786C5EBA73C82A12AE29AFE7", hash_generated_field = "4C2BDD5AB0510A5D6F5E303F162A1B06")

    static int MSG_DUMP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.664 -0400", hash_original_field = "FFA57EE67847D01D32351A0C94DC0B6D", hash_generated_field = "4F2ACBBB54F62D05B07F4554FC284FEC")

    static int MSG_BIND = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.664 -0400", hash_original_field = "8AC43D013FCCCB55AE24AB269980CE03", hash_generated_field = "D000B58E1B4D2589ED8B6F0646AECE54")

    static int MSG_UNBIND = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.664 -0400", hash_original_field = "E30FD8D29111DD2ECEB4DE63E4F1CCFF", hash_generated_field = "B7312D237B7E0456082F0884124BB69B")

    static int MSG_SET_ACTIVE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.664 -0400", hash_original_field = "AF301AB8FC51C3751F543BE4EA3AF5EB", hash_generated_field = "C03CF0054237DB2475EF4E292BEF892A")

    public static final int SHOW_IMPLICIT = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.664 -0400", hash_original_field = "99DB66177A84F468AEEB2AD091BC6A1C", hash_generated_field = "7BA61FD409340B0C8E775EB75D40DCFF")

    public static final int SHOW_FORCED = 0x0002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.664 -0400", hash_original_field = "1893396B376E30F240917266CAD4133B", hash_generated_field = "6DE1572C40D7A706B1F6E877EF1C7AEA")

    public static final int RESULT_UNCHANGED_SHOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.664 -0400", hash_original_field = "FF2615E676946E405A41B4A827A5B922", hash_generated_field = "0D7072043387926ADE4C173684F81871")

    public static final int RESULT_UNCHANGED_HIDDEN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.664 -0400", hash_original_field = "AC49B0A43F4A7036636BAB8E93E598D5", hash_generated_field = "DA3162CDE4E12E374EB18AA57480909B")

    public static final int RESULT_SHOWN = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.664 -0400", hash_original_field = "5C4269E94C0C68D01737F330702D036A", hash_generated_field = "32D8F39D75725376FDFC286B2EA27F45")

    public static final int RESULT_HIDDEN = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.664 -0400", hash_original_field = "2093854B220BEEADFCA5D74555336500", hash_generated_field = "58F91761BACAED73D8EF194F02D9EA57")

    public static final int HIDE_IMPLICIT_ONLY = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.664 -0400", hash_original_field = "EB0723B8D7A71207C943C9F5CCA7FEB6", hash_generated_field = "03F311607F79D8F57E9DA6C29B046EF2")

    public static final int HIDE_NOT_ALWAYS = 0x0002;
}

