package android.view.inputmethod;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.208 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "AF4D994570007AEC23008412E21170BC")

    IInputMethodManager mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.208 -0400", hash_original_field = "6C2EA91B438529F1372D806717F5AE04", hash_generated_field = "22AA67C96F8F7AD7DFD89E53DF216F9A")

    Looper mMainLooper;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.208 -0400", hash_original_field = "6D1DA64E705BB119454CD3D6A13CB760", hash_generated_field = "4DD8CF7D1E2B224E6925E028DA6C7C60")

    H mH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.208 -0400", hash_original_field = "4AC36937F366B7AB4CCDC4F1F414F47C", hash_generated_field = "72027A70482354298567E3297708A343")

    IInputContext mIInputContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.208 -0400", hash_original_field = "43EEA9F366EE6D438612A98DC9C5FC93", hash_generated_field = "844E46882A240B061C638C1091315129")

    boolean mActive = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.208 -0400", hash_original_field = "C6C64E873A8D5F838497C395DB968AA6", hash_generated_field = "7B2E6D1E4DF1C0EAF8EAE346683AD3D8")

    boolean mHasBeenInactive = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.209 -0400", hash_original_field = "21C88B20DA84168713D6AAB9A7589738", hash_generated_field = "7A6D29D78DDDB849117195D1575B1D0D")

    boolean mFullscreenMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.209 -0400", hash_original_field = "7C403604AF27C19B706DB901961790F3", hash_generated_field = "8610B5C69CA08D5F83A8EDAD499B41DF")

    View mCurRootView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.209 -0400", hash_original_field = "276384D0701C2515D37ABAEB0BB07CF1", hash_generated_field = "A54183C371A5C91679B93D582850D821")

    View mServedView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.209 -0400", hash_original_field = "8A6701709B1BF571CC720A8C0186A3A1", hash_generated_field = "37CB9C3A74C8E8A1DCD593663CB659AC")

    View mNextServedView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.209 -0400", hash_original_field = "07A5D2B2CA7B06E26DDA4CEA3D0F998F", hash_generated_field = "1CF172770CCCC42619E82625D27683E4")

    boolean mNextServedNeedsStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.209 -0400", hash_original_field = "6FEA88F2097C781265F07408D655FA08", hash_generated_field = "AA8EADE0DA95013FD81168358A40CC38")

    boolean mServedConnecting;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.209 -0400", hash_original_field = "C37631DCB334F3DE253566FE7E88827B", hash_generated_field = "F6752A3676A98F8319F142BFE09A3814")

    EditorInfo mCurrentTextBoxAttribute;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.209 -0400", hash_original_field = "F2741F7543BFA572357C0FCA31F8D3CA", hash_generated_field = "1069CCDD0BD720E7FA6763B4BE3FB768")

    InputConnection mServedInputConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.209 -0400", hash_original_field = "EEF2F22BDE2DAD179EF74F9D5A249F06", hash_generated_field = "37C04B17B3D71E2A78D5E95F178E79E6")

    CompletionInfo[] mCompletions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.209 -0400", hash_original_field = "6E5580956F347FC39333E30175D7959E", hash_generated_field = "79C750F90B6AC779C5BB9837C3C74CAB")

    Rect mTmpCursorRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.209 -0400", hash_original_field = "350B6C1DE46A8AE51B0B3EA7C5DA7FB3", hash_generated_field = "49E12E0B9B02D82DC1E7BF4D1DC2791F")

    Rect mCursorRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.209 -0400", hash_original_field = "6C4EB7C9764378AC3F07482431440688", hash_generated_field = "61370CAB7E613D3B51D5F05A3E7881EC")

    int mCursorSelStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.209 -0400", hash_original_field = "7F3420A9E671AF58A6B367314A292BE4", hash_generated_field = "EE54263B133ACFB15E11DD2491E1A3B9")

    int mCursorSelEnd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.209 -0400", hash_original_field = "348A4A071E9816A33884E58F89D8D45F", hash_generated_field = "1CD08C23B7F290112A0ABF5F99E6CD72")

    int mCursorCandStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.209 -0400", hash_original_field = "03AAABA3C7C79FEB761E8C53CF9CE377", hash_generated_field = "BF24EA98ADDF2C881C86310B37BA9EE6")

    int mCursorCandEnd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.209 -0400", hash_original_field = "31D04805CE4EE92E41E4F9B05CE76B8E", hash_generated_field = "C983A711DB3B897D81814DB669E54903")

    int mBindSequence = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.209 -0400", hash_original_field = "878F6B32EA64F5E90AF6FFF354C354D2", hash_generated_field = "B8DB1FCD85A9BF1BC30DF0BD30881CBD")

    String mCurId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.209 -0400", hash_original_field = "F3A12A28D252E9CCEBFAFF98ED723491", hash_generated_field = "ECFDF7AD8578511D0EA7676517144A2F")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.211 -0400", hash_original_field = "73409FFD7A55CCEC18BF7235F49C6C2C", hash_generated_field = "23E79A65143FCC7F6AFAF0A8EA3DFB92")

    final InputConnection mDummyInputConnection = new BaseInputConnection(this, false);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.212 -0400", hash_original_method = "508ED56B5BF5DABABCAF5D12E61B17FA", hash_generated_method = "A789424FFA1099C3A4E75182E6A88F8D")
      InputMethodManager(IInputMethodManager service, Looper looper) {
        mService = service;
        mMainLooper = looper;
        mH = new H(looper);
        mIInputContext = new ControlledInputConnectionWrapper(looper,
                mDummyInputConnection, this);
        {
            mInstance = this;
        } 
        
        
        
        
        
                
        
            
        
    }

    
        @DSModeled(DSC.SAFE)
    static public InputMethodManager getInstance(Context context) {
        return getInstance(context.getMainLooper());
    }

    
        @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.214 -0400", hash_original_method = "3D9C93A013E7DC300254687B6593E9DE", hash_generated_method = "B1DD8DB78B414EDAFD315791F8FA3DA2")
    public IInputMethodClient getClient() {
        IInputMethodClient varB4EAC82CA7396A68D541C85D26508E83_1438300044 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1438300044 = mClient;
        varB4EAC82CA7396A68D541C85D26508E83_1438300044.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1438300044;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.214 -0400", hash_original_method = "BB1CC2AA4E519DFF3D7BB1A17FAAA9A1", hash_generated_method = "CEC42D6F96A6937ED574DCBCA816501D")
    public IInputContext getInputContext() {
        IInputContext varB4EAC82CA7396A68D541C85D26508E83_491723132 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_491723132 = mIInputContext;
        varB4EAC82CA7396A68D541C85D26508E83_491723132.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_491723132;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.215 -0400", hash_original_method = "4976C1493B414917938FA9CF9C859341", hash_generated_method = "A9EFC27BA25489FFEFB09B6468379B93")
    public List<InputMethodInfo> getInputMethodList() {
        List<InputMethodInfo> varB4EAC82CA7396A68D541C85D26508E83_1685321552 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1685321552 = mService.getInputMethodList();
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1685321552.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1685321552;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.215 -0400", hash_original_method = "E8BA85FCD94534AA9F0D8586DC21C83A", hash_generated_method = "63F2AC7A9AD9E67E1E52D21AD1913DB4")
    public List<InputMethodInfo> getEnabledInputMethodList() {
        List<InputMethodInfo> varB4EAC82CA7396A68D541C85D26508E83_1611029982 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1611029982 = mService.getEnabledInputMethodList();
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1611029982.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1611029982;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.216 -0400", hash_original_method = "6701B30EF11ADDDCEFC97757F6DCE403", hash_generated_method = "EE83353E38F132DAB44772881A9735BD")
    public List<InputMethodSubtype> getEnabledInputMethodSubtypeList(InputMethodInfo imi,
            boolean allowsImplicitlySelectedSubtypes) {
        List<InputMethodSubtype> varB4EAC82CA7396A68D541C85D26508E83_2035930042 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2035930042 = mService.getEnabledInputMethodSubtypeList(imi, allowsImplicitlySelectedSubtypes);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } 
        addTaint(imi.getTaint());
        addTaint(allowsImplicitlySelectedSubtypes);
        varB4EAC82CA7396A68D541C85D26508E83_2035930042.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2035930042;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.216 -0400", hash_original_method = "53B62C40B5B8B2FB3464E7DA6A87D443", hash_generated_method = "A679B9611AFCA36443CC3F7C2D438980")
    public void showStatusIcon(IBinder imeToken, String packageName, int iconId) {
        try 
        {
            mService.updateStatusIcon(imeToken, packageName, iconId);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } 
        addTaint(imeToken.getTaint());
        addTaint(packageName.getTaint());
        addTaint(iconId);
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.216 -0400", hash_original_method = "D00BAF75C3098DFC4E35D122E494F4F9", hash_generated_method = "A84DBEF9DFB86AE2D1BC0772B076B041")
    public void hideStatusIcon(IBinder imeToken) {
        try 
        {
            mService.updateStatusIcon(imeToken, null, 0);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } 
        addTaint(imeToken.getTaint());
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.216 -0400", hash_original_method = "7375BD73E964162AE893F10DF6DE4659", hash_generated_method = "55979827B1CC03D615B10C51F5423DC2")
    public void setImeWindowStatus(IBinder imeToken, int vis, int backDisposition) {
        try 
        {
            mService.setImeWindowStatus(imeToken, vis, backDisposition);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } 
        addTaint(imeToken.getTaint());
        addTaint(vis);
        addTaint(backDisposition);
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.217 -0400", hash_original_method = "E3510526CEDC6D4EEDFFA989F1389EB2", hash_generated_method = "DBF532BC0434234D838BC6C0A047FC02")
    public void setFullscreenMode(boolean fullScreen) {
        mFullscreenMode = fullScreen;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.217 -0400", hash_original_method = "CEA057AD7D0092E84D73E0D04E9F9DEE", hash_generated_method = "BF2FB822AC189EA158FEFBA85C133EC1")
    public void registerSuggestionSpansForNotification(SuggestionSpan[] spans) {
        
        try 
        {
            mService.registerSuggestionSpansForNotification(spans);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } 
        addTaint(spans[0].getTaint());
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.217 -0400", hash_original_method = "67AB3FB4ECE37955692BC451DD457E24", hash_generated_method = "52CD7C056C3CDF0D908286A45B657FE8")
    public void notifySuggestionPicked(SuggestionSpan span, String originalString, int index) {
        try 
        {
            mService.notifySuggestionPicked(span, originalString, index);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } 
        addTaint(span.getTaint());
        addTaint(originalString.getTaint());
        addTaint(index);
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.218 -0400", hash_original_method = "FCDCA2DC24AB76EAA903F8369A9A45F8", hash_generated_method = "A40A00D2CD746ECC437D014E580E26CD")
    public boolean isFullscreenMode() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_98815419 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_98815419;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.218 -0400", hash_original_method = "BC82DFD48282D1B48FE7389621C80801", hash_generated_method = "3446F1FE718D4C849905BA1E720F15DB")
    public boolean isActive(View view) {
        checkFocus();
        {
            boolean var49F5D3F91085A10D821F326D270E0A6F_647500271 = ((mServedView == view
                    || (mServedView != null
                            && mServedView.checkInputConnectionProxy(view)))
                    && mCurrentTextBoxAttribute != null);
        } 
        addTaint(view.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1719604152 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1719604152;
        
        
        
            
                    
                            
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.218 -0400", hash_original_method = "36DF2A9A4D9117D0F00790A34A3AF373", hash_generated_method = "9502D311CFF8FB8FAD14342D2C734AB9")
    public boolean isActive() {
        checkFocus();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1146639251 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1146639251;
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.218 -0400", hash_original_method = "A9275A3C5F8B97D3BA22658E0542618D", hash_generated_method = "ACA95257F208355C30AD3C681FCCB6EE")
    public boolean isAcceptingText() {
        checkFocus();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_232563273 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_232563273;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.219 -0400", hash_original_method = "3A92950E40C3C85A49E393646C27AEA9", hash_generated_method = "D4740FFBD500B6D301DCC0D1B2CFF8E6")
     void clearBindingLocked() {
        clearConnectionLocked();
        mBindSequence = -1;
        mCurId = null;
        mCurMethod = null;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.219 -0400", hash_original_method = "7C74580464CD8E195E3FB8BED8B93C53", hash_generated_method = "EFB7670AA252AD66E15371A32A6F6C81")
     void clearConnectionLocked() {
        mCurrentTextBoxAttribute = null;
        mServedInputConnection = null;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.219 -0400", hash_original_method = "1D1918AFC608107C503CFA70B5918395", hash_generated_method = "800ACF7F291C472A846F93ECFB4EDD39")
     void finishInputLocked() {
        mNextServedView = null;
        {
            {
                try 
                {
                    mService.finishInput(mClient);
                } 
                catch (RemoteException e)
                { }
            } 
            {
                Handler vh = mServedView.getHandler();
                {
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.220 -0400", hash_original_method = "55A79A529B0E338884C3A2F27FEDBFDF", hash_generated_method = "428F213740399011417EF40A43764BF5")
    public void reportFinishInputConnection(InputConnection ic) {
        {
            ic.finishComposingText();
        } 
        addTaint(ic.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.220 -0400", hash_original_method = "2ABAAA397EA24F350376BE11BDE21CC8", hash_generated_method = "1C60A799E943EB2186A3733E0159153A")
    public void displayCompletions(View view, CompletionInfo[] completions) {
        checkFocus();
        {
            {
                boolean varDB99D0AC55C2DBA21EBD734EA036F99E_374084905 = (mServedView != view && (mServedView == null
                            || !mServedView.checkInputConnectionProxy(view)));
            } 
            mCompletions = completions;
            {
                try 
                {
                    mCurMethod.displayCompletions(mCompletions);
                } 
                catch (RemoteException e)
                { }
            } 
        } 
        addTaint(view.getTaint());
        
        
        
            
                            
                
            
            
            
                
                    
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.221 -0400", hash_original_method = "51F483359287A71D0F033A0D1668F291", hash_generated_method = "93E58E8060F87D94CD2CD0CB022C8526")
    public void updateExtractedText(View view, int token, ExtractedText text) {
        checkFocus();
        {
            {
                boolean var5B46188F855DD0910683CAEF46B64CFE_4594499 = (mServedView != view && (mServedView == null
                    || !mServedView.checkInputConnectionProxy(view)));
            } 
            {
                try 
                {
                    mCurMethod.updateExtractedText(token, text);
                } 
                catch (RemoteException e)
                { }
            } 
        } 
        addTaint(view.getTaint());
        addTaint(token);
        addTaint(text.getTaint());
        
        
        
            
                    
                
            
            
                
                    
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.221 -0400", hash_original_method = "8D2F613F92BFA1616CD527BE18090765", hash_generated_method = "9CC779DD40570DE9953FD680F7DD8504")
    public boolean showSoftInput(View view, int flags) {
        boolean var42A64BEF015E8CA610A96851B469250A_1888693543 = (showSoftInput(view, flags, null));
        addTaint(view.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_569090417 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_569090417;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.222 -0400", hash_original_method = "182A36951EBA765A4D1CAFFC02BFF851", hash_generated_method = "41C1246E966C750A015190AFB27BCA83")
    public boolean showSoftInput(View view, int flags, ResultReceiver resultReceiver) {
        checkFocus();
        {
            {
                boolean var5B46188F855DD0910683CAEF46B64CFE_210509955 = (mServedView != view && (mServedView == null
                    || !mServedView.checkInputConnectionProxy(view)));
            } 
            try 
            {
                boolean varDFAA7336B82EE31799175E615A34D3DD_1985296136 = (mService.showSoftInput(mClient, flags, resultReceiver));
            } 
            catch (RemoteException e)
            { }
        } 
        addTaint(view.getTaint());
        addTaint(flags);
        addTaint(resultReceiver.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_373378332 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_373378332;
        
        
        
            
                    
                
            
            
                
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.222 -0400", hash_original_method = "5110555AB7D318C3F52B5C2085DD7CF4", hash_generated_method = "76A27BE27824CB8A46A3F7D8BA46FF9C")
    public void showSoftInputUnchecked(int flags, ResultReceiver resultReceiver) {
        try 
        {
            mService.showSoftInput(mClient, flags, resultReceiver);
        } 
        catch (RemoteException e)
        { }
        addTaint(flags);
        addTaint(resultReceiver.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.222 -0400", hash_original_method = "4391301CC9B8F998B7CF2FBAB148B8AA", hash_generated_method = "6E66BC265E4E3A7E1DA6691B63D6141B")
    public boolean hideSoftInputFromWindow(IBinder windowToken, int flags) {
        boolean var658CF3AB42C3F6232FD0409B6B2947F4_145379371 = (hideSoftInputFromWindow(windowToken, flags, null));
        addTaint(windowToken.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_673995516 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_673995516;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.223 -0400", hash_original_method = "0C97F129DA85CEA766FB3D7196531B26", hash_generated_method = "25F4319B60F385F0757C703D723051A3")
    public boolean hideSoftInputFromWindow(IBinder windowToken, int flags,
            ResultReceiver resultReceiver) {
        checkFocus();
        {
            {
                boolean var601FF64E452C8A4BAF1A32D29190540F_354228068 = (mServedView == null || mServedView.getWindowToken() != windowToken);
            } 
            try 
            {
                boolean var5CACD3E08A6D77B7E674FDCDC8126BA5_2119369156 = (mService.hideSoftInput(mClient, flags, resultReceiver));
            } 
            catch (RemoteException e)
            { }
        } 
        addTaint(windowToken.getTaint());
        addTaint(flags);
        addTaint(resultReceiver.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_630101610 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_630101610;
        
        
        
            
                
            
            
                
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.224 -0400", hash_original_method = "A530968907DBDDA36B89C5946F7EC59D", hash_generated_method = "B9F30F5FC3FC77AF02D2E6BF70F97BF5")
    public void toggleSoftInputFromWindow(IBinder windowToken, int showFlags, int hideFlags) {
        {
            {
                boolean var601FF64E452C8A4BAF1A32D29190540F_1094243109 = (mServedView == null || mServedView.getWindowToken() != windowToken);
            } 
            {
                try 
                {
                    mCurMethod.toggleSoftInput(showFlags, hideFlags);
                } 
                catch (RemoteException e)
                { }
            } 
        } 
        addTaint(windowToken.getTaint());
        addTaint(showFlags);
        addTaint(hideFlags);
        
        
            
                
            
            
                
                    
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.225 -0400", hash_original_method = "79211245E8E42CAB1585D75CD7067652", hash_generated_method = "2F38CF33C68B06E4B0E64C51D9236AAE")
    public void toggleSoftInput(int showFlags, int hideFlags) {
        {
            try 
            {
                mCurMethod.toggleSoftInput(showFlags, hideFlags);
            } 
            catch (RemoteException e)
            { }
        } 
        addTaint(showFlags);
        addTaint(hideFlags);
        
        
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.225 -0400", hash_original_method = "A40BE330B9742EEEBB8728870BF9ED45", hash_generated_method = "415A5C27121F675FC3E08E546B1417DD")
    public void restartInput(View view) {
        checkFocus();
        {
            {
                boolean var5B46188F855DD0910683CAEF46B64CFE_1047502001 = (mServedView != view && (mServedView == null
                    || !mServedView.checkInputConnectionProxy(view)));
            } 
            mServedConnecting = true;
        } 
        startInputInner();
        addTaint(view.getTaint());
        
        
        
            
                    
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.227 -0400", hash_original_method = "B3B1285322786DD26A60C9F9B7802F4B", hash_generated_method = "7205353BB9F1D849592F84495B8B63AE")
     void startInputInner() {
        View view;
        {
            view = mServedView;
        } 
        Handler vh = view.getHandler();
        {
            boolean varFAF728F056691316E709D0988E6B1364_159086031 = (vh.getLooper() != Looper.myLooper());
            {
                vh.post(new Runnable() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.226 -0400", hash_original_method = "BAD6C7ED699C9A68B8082FE4BB335F01", hash_generated_method = "997F4E26C6EE75BE46DC00501A56EA99")
                    public void run() {
                        startInputInner();
                        
                        
                    }
});
            } 
        } 
        EditorInfo tba = new EditorInfo();
        tba.packageName = view.getContext().getPackageName();
        tba.fieldId = view.getId();
        InputConnection ic = view.onCreateInputConnection(tba);
        {
            final boolean initial = mCurrentTextBoxAttribute == null;
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
            } 
            {
                servedContext = null;
            } 
            try 
            {
                InputBindResult res = mService.startInput(mClient,
                        servedContext, tba, initial, true);
                {
                    {
                        mBindSequence = res.sequence;
                        mCurMethod = res.method;
                    } 
                } 
                {
                    try 
                    {
                        mCurMethod.displayCompletions(mCompletions);
                    } 
                    catch (RemoteException e)
                    { }
                } 
            } 
            catch (RemoteException e)
            { }
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.227 -0400", hash_original_method = "574E98E1F1761FC0DC94CE21F83FBF8C", hash_generated_method = "7A83C1D01FF72F67D091FD7767ED9375")
    public void windowDismissed(IBinder appWindowToken) {
        checkFocus();
        {
            {
                boolean var502A33EED994770E53552DF8C0F7D670_391734287 = (mServedView != null &&
                    mServedView.getWindowToken() == appWindowToken);
                {
                    finishInputLocked();
                } 
            } 
        } 
        addTaint(appWindowToken.getTaint());
        
        
        
            
                    
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.227 -0400", hash_original_method = "3DD6E391932A9CCCB1C61486572B8B95", hash_generated_method = "0FB49711202CBC076877FDB58637B808")
    public void focusIn(View view) {
        {
            focusInLocked(view);
        } 
        addTaint(view.getTaint());
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.228 -0400", hash_original_method = "3857011248BD1E1DC17E86CAECB63023", hash_generated_method = "86AE2078DE85A263EE2E8DB3AAD060FD")
     void focusInLocked(View view) {
        {
            boolean var2071CEBD080665CA877F4A0459696EBB_1644135595 = (mCurRootView != view.getRootView());
        } 
        mNextServedView = view;
        scheduleCheckFocusLocked(view);
        
        
        
            
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.228 -0400", hash_original_method = "CA0F410F50592B0E0C8F6A16050EA193", hash_generated_method = "5FF0BB6EA55532664E9A8A325C4475BB")
    public void focusOut(View view) {
        {
            {
                {
                    boolean varF1B8C4C009E1C99A6024E9498723A4C9_1681185352 = (false && view.hasWindowFocus());
                    {
                        mNextServedView = null;
                        scheduleCheckFocusLocked(view);
                    } 
                } 
            } 
        } 
        addTaint(view.getTaint());
        
        
            
                    
                    
            
                
                    
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.229 -0400", hash_original_method = "4A6B64189F9C851EAF66731814D5760A", hash_generated_method = "3187AFF3D4F57A84AD1759E6A287C08D")
     void scheduleCheckFocusLocked(View view) {
        Handler vh = view.getHandler();
        {
            boolean varD62C9DEF2A1FD7096AF2D550C310DFDB_114665856 = (vh != null && !vh.hasMessages(ViewRootImpl.CHECK_FOCUS));
            {
                vh.sendMessage(vh.obtainMessage(ViewRootImpl.CHECK_FOCUS));
            } 
        } 
        addTaint(view.getTaint());
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.229 -0400", hash_original_method = "7D116D001C63CE498592C7AACB0DA356", hash_generated_method = "FE6F49519323109BA218C8BFF225864F")
    public void checkFocus() {
        InputConnection ic = null;
        {
            mNextServedNeedsStart = false;
            {
                finishInputLocked();
                closeCurrentInput();
            } 
            ic = mServedInputConnection;
            mServedView = mNextServedView;
            mCurrentTextBoxAttribute = null;
            mCompletions = null;
            mServedConnecting = true;
        } 
        {
            ic.finishComposingText();
        } 
        startInputInner();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.229 -0400", hash_original_method = "D0A5B4195CF8CF9C3EE8D9642BA1EAAF", hash_generated_method = "71DE39AC33B8D3F4BC97B84EA854C263")
     void closeCurrentInput() {
        try 
        {
            mService.hideSoftInput(mClient, HIDE_NOT_ALWAYS, null);
        } 
        catch (RemoteException e)
        { }
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.230 -0400", hash_original_method = "4893EC862C01D5D2A6E85A7017E94B9B", hash_generated_method = "DDC9415CB6A33D6EC80E161813631C92")
    public void onWindowFocus(View rootView, View focusedView, int softInputMode,
            boolean first, int windowFlags) {
        
        {
            {
                mHasBeenInactive = false;
                mNextServedNeedsStart = true;
            } 
            focusInLocked(focusedView != null ? focusedView : rootView);
        } 
        checkFocus();
        {
            try 
            {
                final boolean isTextEditor = focusedView != null &&
                        focusedView.onCheckIsTextEditor();
                mService.windowGainedFocus(mClient, rootView.getWindowToken(),
                        focusedView != null, isTextEditor, softInputMode, first,
                        windowFlags);
            } 
            catch (RemoteException e)
            { }
        } 
        addTaint(rootView.getTaint());
        addTaint(focusedView.getTaint());
        addTaint(softInputMode);
        addTaint(first);
        addTaint(windowFlags);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.230 -0400", hash_original_method = "1A7A85BD07D131CBE39BA9D28F0E6F2A", hash_generated_method = "B9FF052D043E401AE8605F4965E6E768")
    public void startGettingWindowFocus(View rootView) {
        {
            mCurRootView = rootView;
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.231 -0400", hash_original_method = "6EC728E52174DF43F39F15D376B96D59", hash_generated_method = "0BC0AF64F5EB1889525AC771A71BFBE3")
    public void updateSelection(View view, int selStart, int selEnd,
            int candidatesStart, int candidatesEnd) {
        checkFocus();
        {
            {
                boolean varAE432C6DAE316B6F74A275D95170B0F0_2041363604 = ((mServedView != view && (mServedView == null
                        || !mServedView.checkInputConnectionProxy(view)))
                    || mCurrentTextBoxAttribute == null || mCurMethod == null);
            } 
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
                } 
                catch (RemoteException e)
                { }
            } 
        } 
        addTaint(view.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.231 -0400", hash_original_method = "8E5F47C036105189BFF71EB5625C4E3F", hash_generated_method = "6FE0FCD88277E2820FFEFAB3B7E2F77E")
    public void viewClicked(View view) {
        final boolean focusChanged = mServedView != mNextServedView;
        checkFocus();
        {
            {
                boolean var9326F29C98DC4C69471B39D26338712B_2144297690 = ((mServedView != view && (mServedView == null
                    || !mServedView.checkInputConnectionProxy(view)))
                    || mCurrentTextBoxAttribute == null || mCurMethod == null);
            } 
            try 
            {
                mCurMethod.viewClicked(focusChanged);
            } 
            catch (RemoteException e)
            { }
        } 
        addTaint(view.getTaint());
        
        
        
        
            
                    
                    
                
            
            
                
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.231 -0400", hash_original_method = "385DC57C25B266614A0F3F767A2E43B1", hash_generated_method = "FBAEAC2AD2971D1412B3B2E7AC6DAA16")
    public boolean isWatchingCursor(View view) {
        addTaint(view.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1877586317 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1877586317;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.232 -0400", hash_original_method = "06AF2B97EC9C8BBE1303A237FE727449", hash_generated_method = "081E2C99BD9B9A1B3A0009D666D7B86E")
    public void updateCursor(View view, int left, int top, int right, int bottom) {
        checkFocus();
        {
            {
                boolean varAE432C6DAE316B6F74A275D95170B0F0_53715689 = ((mServedView != view && (mServedView == null
                        || !mServedView.checkInputConnectionProxy(view)))
                    || mCurrentTextBoxAttribute == null || mCurMethod == null);
            } 
            mTmpCursorRect.set(left, top, right, bottom);
            {
                boolean var8D6B8539919CD2C288E2DD1195C4ABF6_1995996355 = (!mCursorRect.equals(mTmpCursorRect));
                {
                    Log.d(TAG, "updateCursor");
                    try 
                    {
                        mCurMethod.updateCursor(mTmpCursorRect);
                        mCursorRect.set(mTmpCursorRect);
                    } 
                    catch (RemoteException e)
                    { }
                } 
            } 
        } 
        addTaint(view.getTaint());
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.233 -0400", hash_original_method = "42E6E13C0C5606029CE59DAABCC4FEF4", hash_generated_method = "2D7B832921BDDE6F4443594D508CA743")
    public void sendAppPrivateCommand(View view, String action, Bundle data) {
        checkFocus();
        {
            {
                boolean varAE432C6DAE316B6F74A275D95170B0F0_842792820 = ((mServedView != view && (mServedView == null
                        || !mServedView.checkInputConnectionProxy(view)))
                    || mCurrentTextBoxAttribute == null || mCurMethod == null);
            } 
            try 
            {
                mCurMethod.appPrivateCommand(action, data);
            } 
            catch (RemoteException e)
            { }
        } 
        addTaint(view.getTaint());
        addTaint(action.getTaint());
        addTaint(data.getTaint());
        
        
        
            
                        
                    
                
            
            
                
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.234 -0400", hash_original_method = "BA3360E0078151C4E77F69CD0F708AC2", hash_generated_method = "7208E9593F4C7CCCD03CBE54458499FA")
    public void setInputMethod(IBinder token, String id) {
        try 
        {
            mService.setInputMethod(token, id);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } 
        addTaint(token.getTaint());
        addTaint(id.getTaint());
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.234 -0400", hash_original_method = "6B5F7BD4B9987D792262BC3FA22B0356", hash_generated_method = "8D6D7F9A2373A84431F75A30D190E909")
    public void setInputMethodAndSubtype(IBinder token, String id, InputMethodSubtype subtype) {
        try 
        {
            mService.setInputMethodAndSubtype(token, id, subtype);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } 
        addTaint(token.getTaint());
        addTaint(id.getTaint());
        addTaint(subtype.getTaint());
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.235 -0400", hash_original_method = "57E46D0940B3C65A92751CB9C29D6161", hash_generated_method = "837A817CA1A93C64A6889CB2284647B9")
    public void hideSoftInputFromInputMethod(IBinder token, int flags) {
        try 
        {
            mService.hideMySoftInput(token, flags);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } 
        addTaint(token.getTaint());
        addTaint(flags);
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.236 -0400", hash_original_method = "E0804B4135D0004448137E06C89A5AC2", hash_generated_method = "EE9217863C9F1053202CA9B44FB963A8")
    public void showSoftInputFromInputMethod(IBinder token, int flags) {
        try 
        {
            mService.showMySoftInput(token, flags);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } 
        addTaint(token.getTaint());
        addTaint(flags);
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.236 -0400", hash_original_method = "E668070B782BDDB11E06224CB9252B61", hash_generated_method = "481353940949DC68D427A735516EB4C6")
    public void dispatchKeyEvent(Context context, int seq, KeyEvent key,
            IInputMethodCallback callback) {
        {
            Log.d(TAG, "dispatchKeyEvent");
            {
                try 
                {
                    callback.finishedEvent(seq, false);
                } 
                catch (RemoteException e)
                { }
            } 
            {
                boolean var209637C5B03F50E58BDA56A931544EE4_11206813 = (key.getAction() == KeyEvent.ACTION_DOWN
                    && key.getKeyCode() == KeyEvent.KEYCODE_SYM);
                {
                    showInputMethodPicker();
                    try 
                    {
                        callback.finishedEvent(seq, true);
                    } 
                    catch (RemoteException e)
                    { }
                } 
            } 
            try 
            {
                mCurMethod.dispatchKeyEvent(seq, key, callback);
            } 
            catch (RemoteException e)
            {
                try 
                {
                    callback.finishedEvent(seq, false);
                } 
                catch (RemoteException ex)
                { }
            } 
        } 
        addTaint(context.getTaint());
        addTaint(seq);
        addTaint(key.getTaint());
        addTaint(callback.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.237 -0400", hash_original_method = "99D2E1A6FD8F8DDA0CF04D3632103B0E", hash_generated_method = "2969D1C3BB5908CF735252C7E443CB79")
     void dispatchTrackballEvent(Context context, int seq, MotionEvent motion,
            IInputMethodCallback callback) {
        {
            Log.d(TAG, "dispatchTrackballEvent");
            {
                try 
                {
                    callback.finishedEvent(seq, false);
                } 
                catch (RemoteException e)
                { }
            } 
            try 
            {
                mCurMethod.dispatchTrackballEvent(seq, motion, callback);
            } 
            catch (RemoteException e)
            {
                try 
                {
                    callback.finishedEvent(seq, false);
                } 
                catch (RemoteException ex)
                { }
            } 
        } 
        addTaint(context.getTaint());
        addTaint(seq);
        addTaint(motion.getTaint());
        addTaint(callback.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.237 -0400", hash_original_method = "032A4A57AEC9378F2AEDB365B55F6952", hash_generated_method = "3A675125C27FF9A084EDB85F14080C74")
    public void showInputMethodPicker() {
        {
            try 
            {
                mService.showInputMethodPickerFromClient(mClient);
            } 
            catch (RemoteException e)
            { }
        } 
        
        
            
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.238 -0400", hash_original_method = "40ED720E9E0E9A18C34ACD22184580A8", hash_generated_method = "8E9B33ED10E2005A78F7EE9EAD368A2E")
    public void showInputMethodAndSubtypeEnabler(String imiId) {
        {
            try 
            {
                mService.showInputMethodAndSubtypeEnablerFromClient(mClient, imiId);
            } 
            catch (RemoteException e)
            { }
        } 
        addTaint(imiId.getTaint());
        
        
            
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.238 -0400", hash_original_method = "FD9F276F6D40BEB379032073F0CE055D", hash_generated_method = "74AA78A41F7D49C3F1F2DBCBB16564B7")
    public InputMethodSubtype getCurrentInputMethodSubtype() {
        InputMethodSubtype varB4EAC82CA7396A68D541C85D26508E83_1302631800 = null; 
        InputMethodSubtype varB4EAC82CA7396A68D541C85D26508E83_1930450051 = null; 
        {
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1302631800 = mService.getCurrentInputMethodSubtype();
            } 
            catch (RemoteException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_1930450051 = null;
            } 
        } 
        InputMethodSubtype varA7E53CE21691AB073D9660D615818899_198504489; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_198504489 = varB4EAC82CA7396A68D541C85D26508E83_1302631800;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_198504489 = varB4EAC82CA7396A68D541C85D26508E83_1930450051;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_198504489.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_198504489;
        
        
            
                
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.239 -0400", hash_original_method = "3CA77773C45BE29D3C7CB419603994A1", hash_generated_method = "44684C7ACA457DC4C12DECB0D6F99299")
    public boolean setCurrentInputMethodSubtype(InputMethodSubtype subtype) {
        {
            try 
            {
                boolean varB772562C6791056C6792B89901F04090_1253643276 = (mService.setCurrentInputMethodSubtype(subtype));
            } 
            catch (RemoteException e)
            { }
        } 
        addTaint(subtype.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1979017495 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1979017495;
        
        
            
                
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.240 -0400", hash_original_method = "43A6DF9F5E808A92ECB1533408005E7F", hash_generated_method = "7687D469AF4C50508F8876809FAC93EB")
    public Map<InputMethodInfo, List<InputMethodSubtype>> getShortcutInputMethodsAndSubtypes() {
        Map<InputMethodInfo, List<InputMethodSubtype>> varB4EAC82CA7396A68D541C85D26508E83_576857821 = null; 
        {
            HashMap<InputMethodInfo, List<InputMethodSubtype>> ret = new HashMap<InputMethodInfo, List<InputMethodSubtype>>();
            try 
            {
                List<Object> info = mService.getShortcutInputMethodsAndSubtypes();
                ArrayList<InputMethodSubtype> subtypes = null;
                final int N = info.size();
                {
                    {
                        int i = 0;
                        {
                            Object o = info.get(i);
                            {
                                {
                                    boolean var3270550FE2662AB18C2A8C4288E9FE37_1063604514 = (ret.containsKey(o));
                                } 
                                subtypes = new ArrayList<InputMethodSubtype>();
                                ret.put((InputMethodInfo)o, subtypes);
                            } 
                            {
                                subtypes.add((InputMethodSubtype)o);
                            } 
                        } 
                    } 
                } 
            } 
            catch (RemoteException e)
            { }
            varB4EAC82CA7396A68D541C85D26508E83_576857821 = ret;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_576857821.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_576857821;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.240 -0400", hash_original_method = "36F8CCF4190068A92F1E830BF76C0680", hash_generated_method = "E1B02F2014C91700C6DE4123B40BE7D1")
    public boolean switchToLastInputMethod(IBinder imeToken) {
        {
            try 
            {
                boolean var8776571A2351650A62690661D0377A0B_1721168561 = (mService.switchToLastInputMethod(imeToken));
            } 
            catch (RemoteException e)
            { }
        } 
        addTaint(imeToken.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1878155093 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1878155093;
        
        
            
                
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.241 -0400", hash_original_method = "E3938A1614AA74CBD638A5A0682603ED", hash_generated_method = "7856814220EE67D559E09A3399DCDAE3")
    public void setAdditionalInputMethodSubtypes(String imiId, InputMethodSubtype[] subtypes) {
        {
            try 
            {
                mService.setAdditionalInputMethodSubtypes(imiId, subtypes);
            } 
            catch (RemoteException e)
            { }
        } 
        addTaint(imiId.getTaint());
        addTaint(subtypes[0].getTaint());
        
        
            
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.242 -0400", hash_original_method = "D92C08014C42A358F015C9B31552925A", hash_generated_method = "12A161CA2863217786FA4803ACCA3804")
    public InputMethodSubtype getLastInputMethodSubtype() {
        InputMethodSubtype varB4EAC82CA7396A68D541C85D26508E83_1634242871 = null; 
        InputMethodSubtype varB4EAC82CA7396A68D541C85D26508E83_89141925 = null; 
        {
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1634242871 = mService.getLastInputMethodSubtype();
            } 
            catch (RemoteException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_89141925 = null;
            } 
        } 
        InputMethodSubtype varA7E53CE21691AB073D9660D615818899_1733564776; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1733564776 = varB4EAC82CA7396A68D541C85D26508E83_1634242871;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1733564776 = varB4EAC82CA7396A68D541C85D26508E83_89141925;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1733564776.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1733564776;
        
        
            
                
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.243 -0400", hash_original_method = "A669FCC83173C60A2ED2B3C5020338A1", hash_generated_method = "375549D03557C301F9C1EF2C77DA2DFC")
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
        {
            p.println("  mCurrentTextBoxAttribute:");
            mCurrentTextBoxAttribute.dump(p, "    ");
        } 
        {
            p.println("  mCurrentTextBoxAttribute: null");
        } 
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
        
        
    }

    
    class H extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.243 -0400", hash_original_method = "6EF38EF9E91987FCDB2CC1FED5C76A24", hash_generated_method = "171D5E2268C2C0FB2DD94B8957DCF858")
          H(Looper looper) {
            super(looper);
            addTaint(looper.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.245 -0400", hash_original_method = "D40CD8B0041519F81016D036AC481E26", hash_generated_method = "4AB816C32A8036F95357D8C6C11796D8")
        @Override
        public void handleMessage(Message msg) {
            
            {
                HandlerCaller.SomeArgs args = (HandlerCaller.SomeArgs)msg.obj;
                try 
                {
                    doDump((FileDescriptor)args.arg1,
                                (PrintWriter)args.arg2, (String[])args.arg3);
                } 
                catch (RuntimeException e)
                {
                    ((PrintWriter)args.arg2).println("Exception: " + e);
                } 
                {
                    ((CountDownLatch)args.arg4).countDown();
                } 
            } 
            
            
            {
                final InputBindResult res = (InputBindResult)msg.obj;
                {
                    mCurMethod = res.method;
                    mCurId = res.id;
                    mBindSequence = res.sequence;
                } 
                startInputInner();
            } 
            
            
            {
                final int sequence = msg.arg1;
                {
                    {
                        {
                            {
                                try 
                                {
                                    mCurMethod.finishInput();
                                } 
                                catch (RemoteException e)
                                { }
                            } 
                        } 
                        clearBindingLocked();
                        {
                            boolean varDE258C52FC90033C41FC87EA7E287047_1085754657 = (mServedView != null && mServedView.isFocused());
                            {
                                mServedConnecting = true;
                            } 
                        } 
                    } 
                    startInputInner();
                } 
            } 
            
            
            {
                final boolean active = msg.arg1 != 0;
                {
                    mActive = active;
                    mFullscreenMode = false;
                    {
                        mHasBeenInactive = true;
                        try 
                        {
                            mIInputContext.finishComposingText();
                        } 
                        catch (RemoteException e)
                        { }
                    } 
                } 
            } 
            
            addTaint(msg.getTaint());
            
            
        }

        
    }


    
    private static class ControlledInputConnectionWrapper extends IInputConnectionWrapper {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.246 -0400", hash_original_field = "4BD231895EADC77A5885859A0DCE2745", hash_generated_field = "9798BD50577982452DA631DD5C538942")

        private InputMethodManager mParentInputMethodManager;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.246 -0400", hash_original_method = "778EAAA875B5E9B35A79C47358BD4D78", hash_generated_method = "C3FF059C62D57F095A56A57A59484AB9")
        public  ControlledInputConnectionWrapper(final Looper mainLooper, final InputConnection conn,
                final InputMethodManager inputMethodManager) {
            super(mainLooper, conn);
            mParentInputMethodManager = inputMethodManager;
            addTaint(mainLooper.getTaint());
            addTaint(conn.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.247 -0400", hash_original_method = "FB049513493D8EDB25EAFF891B2EE0A9", hash_generated_method = "491FE9AAE0C5C99171D9D219DB88B9C0")
        @Override
        public boolean isActive() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2038185406 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2038185406;
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.247 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "F09208C088E716A2CD36A97B937BB5EA")

    static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.247 -0400", hash_original_field = "198D4E7EC1D9AEEA0CC4EE019C0C0999", hash_generated_field = "FE423FA5D3056FFD91C65F642D943473")

    static final String TAG = "InputMethodManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.247 -0400", hash_original_field = "03A98D5E0621C030BCDBF77610AA1147", hash_generated_field = "8E1374FF2568A6E7DF58ACEEF1A2A836")

    static final Object mInstanceSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.247 -0400", hash_original_field = "DD62467EBA66E288A1769E403146FE2D", hash_generated_field = "70278290516934488710CF458A67B14F")

    static InputMethodManager mInstance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.247 -0400", hash_original_field = "B8629205786C5EBA73C82A12AE29AFE7", hash_generated_field = "29E3688958B2990B4C392F7BA34B78FE")

    static final int MSG_DUMP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.247 -0400", hash_original_field = "FFA57EE67847D01D32351A0C94DC0B6D", hash_generated_field = "00F2010EA24613AFCCBC353F90339FF1")

    static final int MSG_BIND = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.247 -0400", hash_original_field = "8AC43D013FCCCB55AE24AB269980CE03", hash_generated_field = "4E6A324B7DC0A9F424DCDAA6789BFECC")

    static final int MSG_UNBIND = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.247 -0400", hash_original_field = "E30FD8D29111DD2ECEB4DE63E4F1CCFF", hash_generated_field = "28C1B3169E7E5F84C5E110F229FC0C97")

    static final int MSG_SET_ACTIVE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.247 -0400", hash_original_field = "AF301AB8FC51C3751F543BE4EA3AF5EB", hash_generated_field = "C03CF0054237DB2475EF4E292BEF892A")

    public static final int SHOW_IMPLICIT = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.247 -0400", hash_original_field = "99DB66177A84F468AEEB2AD091BC6A1C", hash_generated_field = "7BA61FD409340B0C8E775EB75D40DCFF")

    public static final int SHOW_FORCED = 0x0002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.247 -0400", hash_original_field = "1893396B376E30F240917266CAD4133B", hash_generated_field = "6DE1572C40D7A706B1F6E877EF1C7AEA")

    public static final int RESULT_UNCHANGED_SHOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.247 -0400", hash_original_field = "FF2615E676946E405A41B4A827A5B922", hash_generated_field = "0D7072043387926ADE4C173684F81871")

    public static final int RESULT_UNCHANGED_HIDDEN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.247 -0400", hash_original_field = "AC49B0A43F4A7036636BAB8E93E598D5", hash_generated_field = "DA3162CDE4E12E374EB18AA57480909B")

    public static final int RESULT_SHOWN = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.247 -0400", hash_original_field = "5C4269E94C0C68D01737F330702D036A", hash_generated_field = "32D8F39D75725376FDFC286B2EA27F45")

    public static final int RESULT_HIDDEN = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.247 -0400", hash_original_field = "2093854B220BEEADFCA5D74555336500", hash_generated_field = "58F91761BACAED73D8EF194F02D9EA57")

    public static final int HIDE_IMPLICIT_ONLY = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.247 -0400", hash_original_field = "EB0723B8D7A71207C943C9F5CCA7FEB6", hash_generated_field = "03F311607F79D8F57E9DA6C29B046EF2")

    public static final int HIDE_NOT_ALWAYS = 0x0002;
}

