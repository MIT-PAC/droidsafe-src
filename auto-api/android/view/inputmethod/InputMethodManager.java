package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    static final boolean DEBUG = false;
    static final String TAG = "InputMethodManager";
    static final Object mInstanceSync = new Object();
    static InputMethodManager mInstance;
    public static final int CONTROL_WINDOW_VIEW_HAS_FOCUS = 1<<0;
    public static final int CONTROL_WINDOW_IS_TEXT_EDITOR = 1<<1;
    public static final int CONTROL_WINDOW_FIRST = 1<<2;
    public static final int CONTROL_START_INITIAL = 1<<8;
    final IInputMethodManager mService;
    final Looper mMainLooper;
    final H mH;
    final IInputContext mIInputContext;
    boolean mActive = false;
    boolean mHasBeenInactive = true;
    boolean mFullscreenMode;
    View mCurRootView;
    View mServedView;
    View mNextServedView;
    boolean mServedConnecting;
    EditorInfo mCurrentTextBoxAttribute;
    InputConnection mServedInputConnection;
    CompletionInfo[] mCompletions;
    Rect mTmpCursorRect = new Rect();
    Rect mCursorRect = new Rect();
    int mCursorSelStart;
    int mCursorSelEnd;
    int mCursorCandStart;
    int mCursorCandEnd;
    int mBindSequence = -1;
    String mCurId;
    IInputMethodSession mCurMethod;
    static final int MSG_DUMP = 1;
    static final int MSG_BIND = 2;
    static final int MSG_UNBIND = 3;
    static final int MSG_SET_ACTIVE = 4;
    final IInputMethodClient.Stub mClient = new IInputMethodClient.Stub() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.118 -0400", hash_original_method = "F6EA3706319B79FC567D288B23EBD7C8", hash_generated_method = "2B9EE50D8F2C4679641F407F8C8B5160")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
            dsTaint.addTaint(fout.dsTaint);
            dsTaint.addTaint(args);
            dsTaint.addTaint(fd.dsTaint);
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
                    boolean var19E9A664FE2E8FD1F35B08B34B4A7B6E_17681132 = (!latch.await(5, TimeUnit.SECONDS));
                    {
                        fout.println("Timeout waiting for dump");
                    } //End block
                } //End collapsed parenthetic
            } //End block
            catch (InterruptedException e)
            {
                fout.println("Interrupted waiting for dump");
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.118 -0400", hash_original_method = "45BD5FF75807911B1CFCFBB58E96318E", hash_generated_method = "4110AEDB6E3F3A6E5D451AA615DEA8FF")
        @DSModeled(DSC.SAFE)
        public void setUsingInputMethod(boolean state) {
            dsTaint.addTaint(state);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.118 -0400", hash_original_method = "574FEF71BCEC075DFBB030A0D3C30C22", hash_generated_method = "29AE73463E3F7806ACBE9E8144741337")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onBindMethod(InputBindResult res) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(res.dsTaint);
            mH.sendMessage(mH.obtainMessage(MSG_BIND, res));
            // ---------- Original Method ----------
            //mH.sendMessage(mH.obtainMessage(MSG_BIND, res));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.118 -0400", hash_original_method = "588CEEFF7FA7882256433E31043E7659", hash_generated_method = "2DFBD1A8821D936B3914E182943A78A0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onUnbindMethod(int sequence) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(sequence);
            mH.sendMessage(mH.obtainMessage(MSG_UNBIND, sequence, 0));
            // ---------- Original Method ----------
            //mH.sendMessage(mH.obtainMessage(MSG_UNBIND, sequence, 0));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.118 -0400", hash_original_method = "348B3468B5EF750F568EE6741021F563", hash_generated_method = "3BF8A5FEB453ADC637815C2B63DA8837")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setActive(boolean active) {
            dsTaint.addTaint(active);
            mH.sendMessage(mH.obtainMessage(MSG_SET_ACTIVE, active ? 1 : 0, 0));
            // ---------- Original Method ----------
            //mH.sendMessage(mH.obtainMessage(MSG_SET_ACTIVE, active ? 1 : 0, 0));
        }

        
}; //Transformed anonymous class
    final InputConnection mDummyInputConnection = new BaseInputConnection(this, false);
    public static final int SHOW_IMPLICIT = 0x0001;
    public static final int SHOW_FORCED = 0x0002;
    public static final int RESULT_UNCHANGED_SHOWN = 0;
    public static final int RESULT_UNCHANGED_HIDDEN = 1;
    public static final int RESULT_SHOWN = 2;
    public static final int RESULT_HIDDEN = 3;
    public static final int HIDE_IMPLICIT_ONLY = 0x0001;
    public static final int HIDE_NOT_ALWAYS = 0x0002;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.118 -0400", hash_original_method = "508ED56B5BF5DABABCAF5D12E61B17FA", hash_generated_method = "C57AD0BC66CE4D6FB572208D1437B0CE")
    @DSModeled(DSC.SAFE)
     InputMethodManager(IInputMethodManager service, Looper looper) {
        dsTaint.addTaint(looper.dsTaint);
        dsTaint.addTaint(service.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.118 -0400", hash_original_method = "424A4B77F0AFDB65F3E66A3DDD55A926", hash_generated_method = "1687AC00C8A9CF972080C9248F12F34F")
    static public InputMethodManager getInstance(Context context) {
        return getInstance(context.getMainLooper());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.119 -0400", hash_original_method = "C067F9ADC47879A063CA61C8C792CE65", hash_generated_method = "8B6DE286D9B972F6657980C4AD4C3C06")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.119 -0400", hash_original_method = "86DD9C9F82F9BD6AD5A8C39BDF584DAA", hash_generated_method = "49F9C5CC68814F1F5518AD50E7ED92A0")
    static public InputMethodManager peekInstance() {
        return mInstance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.119 -0400", hash_original_method = "3D9C93A013E7DC300254687B6593E9DE", hash_generated_method = "81DE4B9EB251638814B976424D269297")
    @DSModeled(DSC.SAFE)
    public IInputMethodClient getClient() {
        return (IInputMethodClient)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mClient;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.119 -0400", hash_original_method = "BB1CC2AA4E519DFF3D7BB1A17FAAA9A1", hash_generated_method = "6F33278B0298562F73D8FBE2BC02D184")
    @DSModeled(DSC.SAFE)
    public IInputContext getInputContext() {
        return (IInputContext)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mIInputContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.119 -0400", hash_original_method = "4976C1493B414917938FA9CF9C859341", hash_generated_method = "13826C3C8E1451D1ED3EA747BEB7B5EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<InputMethodInfo> getInputMethodList() {
        try 
        {
            List<InputMethodInfo> var5DA615228E4049E98604D5949629D11F_1205809381 = (mService.getInputMethodList());
        } //End block
        catch (RemoteException e)
        {
            throw new RuntimeException(e);
        } //End block
        return (List<InputMethodInfo>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mService.getInputMethodList();
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.119 -0400", hash_original_method = "E8BA85FCD94534AA9F0D8586DC21C83A", hash_generated_method = "76373966ABA86D7089293C69A2B97A51")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<InputMethodInfo> getEnabledInputMethodList() {
        try 
        {
            List<InputMethodInfo> var0967F1C8D328AE920243EDD8DA13950F_89585376 = (mService.getEnabledInputMethodList());
        } //End block
        catch (RemoteException e)
        {
            throw new RuntimeException(e);
        } //End block
        return (List<InputMethodInfo>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mService.getEnabledInputMethodList();
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.119 -0400", hash_original_method = "6701B30EF11ADDDCEFC97757F6DCE403", hash_generated_method = "ED5D3DFFE6E1BECDAE6061AAB5116A4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<InputMethodSubtype> getEnabledInputMethodSubtypeList(InputMethodInfo imi,
            boolean allowsImplicitlySelectedSubtypes) {
        dsTaint.addTaint(allowsImplicitlySelectedSubtypes);
        dsTaint.addTaint(imi.dsTaint);
        try 
        {
            List<InputMethodSubtype> varFEA8C839467085158AED05D4B65D2BE9_1533654547 = (mService.getEnabledInputMethodSubtypeList(imi, allowsImplicitlySelectedSubtypes));
        } //End block
        catch (RemoteException e)
        {
            throw new RuntimeException(e);
        } //End block
        return (List<InputMethodSubtype>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mService.getEnabledInputMethodSubtypeList(imi, allowsImplicitlySelectedSubtypes);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.119 -0400", hash_original_method = "53B62C40B5B8B2FB3464E7DA6A87D443", hash_generated_method = "D435F0CED734D6BC657C457E67D8BF80")
    @DSModeled(DSC.SAFE)
    public void showStatusIcon(IBinder imeToken, String packageName, int iconId) {
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(imeToken.dsTaint);
        dsTaint.addTaint(iconId);
        try 
        {
            mService.updateStatusIcon(imeToken, packageName, iconId);
        } //End block
        catch (RemoteException e)
        {
            throw new RuntimeException(e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.updateStatusIcon(imeToken, packageName, iconId);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.119 -0400", hash_original_method = "D00BAF75C3098DFC4E35D122E494F4F9", hash_generated_method = "9921E22136C5D830D0C81B9CA01FE5B6")
    @DSModeled(DSC.SAFE)
    public void hideStatusIcon(IBinder imeToken) {
        dsTaint.addTaint(imeToken.dsTaint);
        try 
        {
            mService.updateStatusIcon(imeToken, null, 0);
        } //End block
        catch (RemoteException e)
        {
            throw new RuntimeException(e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.updateStatusIcon(imeToken, null, 0);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.119 -0400", hash_original_method = "7375BD73E964162AE893F10DF6DE4659", hash_generated_method = "AA30B8F49266E4F21752B7F6DB3998E2")
    @DSModeled(DSC.SAFE)
    public void setImeWindowStatus(IBinder imeToken, int vis, int backDisposition) {
        dsTaint.addTaint(backDisposition);
        dsTaint.addTaint(imeToken.dsTaint);
        dsTaint.addTaint(vis);
        try 
        {
            mService.setImeWindowStatus(imeToken, vis, backDisposition);
        } //End block
        catch (RemoteException e)
        {
            throw new RuntimeException(e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.setImeWindowStatus(imeToken, vis, backDisposition);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.120 -0400", hash_original_method = "E3510526CEDC6D4EEDFFA989F1389EB2", hash_generated_method = "83A3EFEF5D8DFDEEE65CFE739AABAD9C")
    @DSModeled(DSC.SAFE)
    public void setFullscreenMode(boolean fullScreen) {
        dsTaint.addTaint(fullScreen);
        // ---------- Original Method ----------
        //mFullscreenMode = fullScreen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.120 -0400", hash_original_method = "CEA057AD7D0092E84D73E0D04E9F9DEE", hash_generated_method = "0B0EBA5ECF6CC48C921DBB11A66880F6")
    @DSModeled(DSC.SAFE)
    public void registerSuggestionSpansForNotification(SuggestionSpan[] spans) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(spans.dsTaint);
        try 
        {
            mService.registerSuggestionSpansForNotification(spans);
        } //End block
        catch (RemoteException e)
        {
            throw new RuntimeException(e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.registerSuggestionSpansForNotification(spans);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.120 -0400", hash_original_method = "67AB3FB4ECE37955692BC451DD457E24", hash_generated_method = "C62F1DD32EA3C13F8DF59AB8A27FA4A8")
    @DSModeled(DSC.SAFE)
    public void notifySuggestionPicked(SuggestionSpan span, String originalString, int index) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(index);
        dsTaint.addTaint(originalString);
        dsTaint.addTaint(span.dsTaint);
        try 
        {
            mService.notifySuggestionPicked(span, originalString, index);
        } //End block
        catch (RemoteException e)
        {
            throw new RuntimeException(e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.notifySuggestionPicked(span, originalString, index);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.120 -0400", hash_original_method = "FCDCA2DC24AB76EAA903F8369A9A45F8", hash_generated_method = "936048A654D25333CEA4F39365911D4E")
    @DSModeled(DSC.SAFE)
    public boolean isFullscreenMode() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFullscreenMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.120 -0400", hash_original_method = "BC82DFD48282D1B48FE7389621C80801", hash_generated_method = "4F6CB3C930EDECE314594088B21ABBEE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isActive(View view) {
        dsTaint.addTaint(view.dsTaint);
        checkFocus();
        {
            boolean var49F5D3F91085A10D821F326D270E0A6F_1869733400 = ((mServedView == view
                    || (mServedView != null
                            && mServedView.checkInputConnectionProxy(view)))
                    && mCurrentTextBoxAttribute != null);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkFocus();
        //synchronized (mH) {
            //return (mServedView == view
                    //|| (mServedView != null
                            //&& mServedView.checkInputConnectionProxy(view)))
                    //&& mCurrentTextBoxAttribute != null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.120 -0400", hash_original_method = "36DF2A9A4D9117D0F00790A34A3AF373", hash_generated_method = "E84618F0215674B4613B811ECF782CC0")
    @DSModeled(DSC.SAFE)
    public boolean isActive() {
        checkFocus();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkFocus();
        //synchronized (mH) {
            //return mServedView != null && mCurrentTextBoxAttribute != null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.120 -0400", hash_original_method = "A9275A3C5F8B97D3BA22658E0542618D", hash_generated_method = "F809741EEDFE6AE2F333988E0D82DDBA")
    @DSModeled(DSC.SAFE)
    public boolean isAcceptingText() {
        checkFocus();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkFocus();
        //return mServedInputConnection != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.120 -0400", hash_original_method = "3A92950E40C3C85A49E393646C27AEA9", hash_generated_method = "480CBC4BFE7E0001205C25D60251916F")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.120 -0400", hash_original_method = "7C74580464CD8E195E3FB8BED8B93C53", hash_generated_method = "12D6DDFB07ADA31734EA498F2E7B68EB")
    @DSModeled(DSC.SAFE)
     void clearConnectionLocked() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCurrentTextBoxAttribute = null;
        mServedInputConnection = null;
        // ---------- Original Method ----------
        //mCurrentTextBoxAttribute = null;
        //mServedInputConnection = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.120 -0400", hash_original_method = "1D1918AFC608107C503CFA70B5918395", hash_generated_method = "98E7F43E3B297CF64F6BE32E84681DF7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.121 -0400", hash_original_method = "55A79A529B0E338884C3A2F27FEDBFDF", hash_generated_method = "765E2F52537A7E0844C28FCB8D4C4665")
    @DSModeled(DSC.SAFE)
    public void reportFinishInputConnection(InputConnection ic) {
        dsTaint.addTaint(ic.dsTaint);
        {
            ic.finishComposingText();
        } //End block
        // ---------- Original Method ----------
        //if (mServedInputConnection != ic) {
            //ic.finishComposingText();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.121 -0400", hash_original_method = "2ABAAA397EA24F350376BE11BDE21CC8", hash_generated_method = "93C6503A098AB23B6A4A74C67C776876")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void displayCompletions(View view, CompletionInfo[] completions) {
        dsTaint.addTaint(completions.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        checkFocus();
        {
            {
                boolean varDB99D0AC55C2DBA21EBD734EA036F99E_2029501083 = (mServedView != view && (mServedView == null
                            || !mServedView.checkInputConnectionProxy(view)));
            } //End collapsed parenthetic
            {
                try 
                {
                    mCurMethod.displayCompletions(mCompletions);
                } //End block
                catch (RemoteException e)
                { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.121 -0400", hash_original_method = "51F483359287A71D0F033A0D1668F291", hash_generated_method = "90F2EF9FA054553DEF3571D0494E1C2B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updateExtractedText(View view, int token, ExtractedText text) {
        dsTaint.addTaint(text.dsTaint);
        dsTaint.addTaint(token);
        dsTaint.addTaint(view.dsTaint);
        checkFocus();
        {
            {
                boolean var5B46188F855DD0910683CAEF46B64CFE_1342786999 = (mServedView != view && (mServedView == null
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.121 -0400", hash_original_method = "8D2F613F92BFA1616CD527BE18090765", hash_generated_method = "EDC016A3DE835BA795E08F486AA9A13B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean showSoftInput(View view, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(view.dsTaint);
        boolean var42A64BEF015E8CA610A96851B469250A_992236232 = (showSoftInput(view, flags, null));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return showSoftInput(view, flags, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.121 -0400", hash_original_method = "182A36951EBA765A4D1CAFFC02BFF851", hash_generated_method = "DB23B2A5D2299D8480B9A1BF94F0BCC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean showSoftInput(View view, int flags, ResultReceiver resultReceiver) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(resultReceiver.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        checkFocus();
        {
            {
                boolean var5B46188F855DD0910683CAEF46B64CFE_455568191 = (mServedView != view && (mServedView == null
                    || !mServedView.checkInputConnectionProxy(view)));
            } //End collapsed parenthetic
            try 
            {
                boolean varDFAA7336B82EE31799175E615A34D3DD_650818535 = (mService.showSoftInput(mClient, flags, resultReceiver));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.121 -0400", hash_original_method = "5110555AB7D318C3F52B5C2085DD7CF4", hash_generated_method = "5DA870FA650C23F2D6EADE4900697F6C")
    @DSModeled(DSC.SAFE)
    public void showSoftInputUnchecked(int flags, ResultReceiver resultReceiver) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(resultReceiver.dsTaint);
        try 
        {
            mService.showSoftInput(mClient, flags, resultReceiver);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.showSoftInput(mClient, flags, resultReceiver);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.121 -0400", hash_original_method = "4391301CC9B8F998B7CF2FBAB148B8AA", hash_generated_method = "46729C072600502044CCEAD89082EAFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hideSoftInputFromWindow(IBinder windowToken, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(windowToken.dsTaint);
        boolean var658CF3AB42C3F6232FD0409B6B2947F4_463302380 = (hideSoftInputFromWindow(windowToken, flags, null));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return hideSoftInputFromWindow(windowToken, flags, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.122 -0400", hash_original_method = "0C97F129DA85CEA766FB3D7196531B26", hash_generated_method = "10C4F0AFFF394484000FF6460540C9C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hideSoftInputFromWindow(IBinder windowToken, int flags,
            ResultReceiver resultReceiver) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(resultReceiver.dsTaint);
        dsTaint.addTaint(windowToken.dsTaint);
        checkFocus();
        {
            {
                boolean var601FF64E452C8A4BAF1A32D29190540F_404551510 = (mServedView == null || mServedView.getWindowToken() != windowToken);
            } //End collapsed parenthetic
            try 
            {
                boolean var5CACD3E08A6D77B7E674FDCDC8126BA5_287559382 = (mService.hideSoftInput(mClient, flags, resultReceiver));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.122 -0400", hash_original_method = "A530968907DBDDA36B89C5946F7EC59D", hash_generated_method = "E8F8F78FEA2FF162C3B3E0FC3E0028F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void toggleSoftInputFromWindow(IBinder windowToken, int showFlags, int hideFlags) {
        dsTaint.addTaint(showFlags);
        dsTaint.addTaint(hideFlags);
        dsTaint.addTaint(windowToken.dsTaint);
        {
            {
                boolean var601FF64E452C8A4BAF1A32D29190540F_95571021 = (mServedView == null || mServedView.getWindowToken() != windowToken);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.122 -0400", hash_original_method = "79211245E8E42CAB1585D75CD7067652", hash_generated_method = "97949F15F3F13667CCD1ACA12216253A")
    @DSModeled(DSC.SAFE)
    public void toggleSoftInput(int showFlags, int hideFlags) {
        dsTaint.addTaint(showFlags);
        dsTaint.addTaint(hideFlags);
        {
            try 
            {
                mCurMethod.toggleSoftInput(showFlags, hideFlags);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        // ---------- Original Method ----------
        //if (mCurMethod != null) {
            //try {
                //mCurMethod.toggleSoftInput(showFlags, hideFlags);
            //} catch (RemoteException e) {
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.122 -0400", hash_original_method = "BA4374E6D4A75A28B6D0173A2084DC55", hash_generated_method = "5E31D0C9544ACCD260CDFEE847CCA3CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void restartInput(View view) {
        dsTaint.addTaint(view.dsTaint);
        checkFocus();
        {
            {
                boolean var5B46188F855DD0910683CAEF46B64CFE_116636275 = (mServedView != view && (mServedView == null
                    || !mServedView.checkInputConnectionProxy(view)));
            } //End collapsed parenthetic
            mServedConnecting = true;
        } //End block
        startInputInner(null, 0, 0, 0);
        // ---------- Original Method ----------
        //checkFocus();
        //synchronized (mH) {
            //if (mServedView != view && (mServedView == null
                    //|| !mServedView.checkInputConnectionProxy(view))) {
                //return;
            //}
            //mServedConnecting = true;
        //}
        //startInputInner(null, 0, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.122 -0400", hash_original_method = "CF2A319158D1C1C6E1F6B6F3296FA7D3", hash_generated_method = "C4A67D73AD25F03777EFC32390FFAB2B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean startInputInner(IBinder windowGainingFocus, int controlFlags, int softInputMode,
            int windowFlags) {
        dsTaint.addTaint(softInputMode);
        dsTaint.addTaint(windowGainingFocus.dsTaint);
        dsTaint.addTaint(windowFlags);
        dsTaint.addTaint(controlFlags);
        final View view;
        {
            view = mServedView;
        } //End block
        Handler vh;
        vh = view.getHandler();
        {
            boolean varFAF728F056691316E709D0988E6B1364_1127168798 = (vh.getLooper() != Looper.myLooper());
            {
                vh.post(new Runnable() {
                public void run() {
                    startInputInner(null, 0, 0, 0);
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
            {
                controlFlags |= CONTROL_START_INITIAL;
            } //End block
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
                {
                    res = mService.windowGainedFocus(mClient, windowGainingFocus,
                            controlFlags, softInputMode, windowFlags,
                            tba, servedContext);
                } //End block
                {
                    res = mService.startInput(mClient,
                            servedContext, tba, controlFlags);
                } //End block
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.123 -0400", hash_original_method = "574E98E1F1761FC0DC94CE21F83FBF8C", hash_generated_method = "F723F1B31F00159D1B57E6408F79906B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void windowDismissed(IBinder appWindowToken) {
        dsTaint.addTaint(appWindowToken.dsTaint);
        checkFocus();
        {
            {
                boolean var502A33EED994770E53552DF8C0F7D670_1332855120 = (mServedView != null &&
                    mServedView.getWindowToken() == appWindowToken);
                {
                    finishInputLocked();
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.123 -0400", hash_original_method = "3DD6E391932A9CCCB1C61486572B8B95", hash_generated_method = "32DE80227F0767E95D08F3AFD9820AF0")
    @DSModeled(DSC.SAFE)
    public void focusIn(View view) {
        dsTaint.addTaint(view.dsTaint);
        {
            focusInLocked(view);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mH) {
            //focusInLocked(view);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.123 -0400", hash_original_method = "3857011248BD1E1DC17E86CAECB63023", hash_generated_method = "5BAB98EE8756778A52200DB405D1CB51")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void focusInLocked(View view) {
        dsTaint.addTaint(view.dsTaint);
        {
            boolean var2071CEBD080665CA877F4A0459696EBB_1285848722 = (mCurRootView != view.getRootView());
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.123 -0400", hash_original_method = "CA0F410F50592B0E0C8F6A16050EA193", hash_generated_method = "6EFE97513FDC38025597427D8358D499")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void focusOut(View view) {
        dsTaint.addTaint(view.dsTaint);
        {
            {
                {
                    boolean varF1B8C4C009E1C99A6024E9498723A4C9_103715229 = (false && view.hasWindowFocus());
                    {
                        mNextServedView = null;
                        scheduleCheckFocusLocked(view);
                    } //End block
                } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.123 -0400", hash_original_method = "4A6B64189F9C851EAF66731814D5760A", hash_generated_method = "C3EBD66FB6651EAF3EA449296F99DC6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void scheduleCheckFocusLocked(View view) {
        dsTaint.addTaint(view.dsTaint);
        Handler vh;
        vh = view.getHandler();
        {
            boolean varD62C9DEF2A1FD7096AF2D550C310DFDB_426819168 = (vh != null && !vh.hasMessages(ViewRootImpl.CHECK_FOCUS));
            {
                vh.sendMessage(vh.obtainMessage(ViewRootImpl.CHECK_FOCUS));
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Handler vh = view.getHandler();
        //if (vh != null && !vh.hasMessages(ViewRootImpl.CHECK_FOCUS)) {
            //vh.sendMessage(vh.obtainMessage(ViewRootImpl.CHECK_FOCUS));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.123 -0400", hash_original_method = "64A348A284CC5420AEF9228B1B5539B8", hash_generated_method = "92D2BEA13BDFEEB49F9A7B8AC575C3DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void checkFocus() {
        {
            boolean var5D01190D1B25B520FBF50BA5E13361B3_1159129486 = (checkFocusNoStartInput(false));
            {
                startInputInner(null, 0, 0, 0);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (checkFocusNoStartInput(false)) {
            //startInputInner(null, 0, 0, 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.123 -0400", hash_original_method = "397B5366DA4CE4E943079DE884783BB0", hash_generated_method = "AF7DF9B106382143C58FC602278EFB05")
    @DSModeled(DSC.SAFE)
    private boolean checkFocusNoStartInput(boolean forceNewFocus) {
        dsTaint.addTaint(forceNewFocus);
        InputConnection ic;
        ic = null;
        {
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.124 -0400", hash_original_method = "D0A5B4195CF8CF9C3EE8D9642BA1EAAF", hash_generated_method = "968604E55B6F095D04778A93B62D0473")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.124 -0400", hash_original_method = "4C566AFC7DD636C90E911F90B7CCB429", hash_generated_method = "114F83FEC5BFC3D24783564AE9468901")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onWindowFocus(View rootView, View focusedView, int softInputMode,
            boolean first, int windowFlags) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(softInputMode);
        dsTaint.addTaint(focusedView.dsTaint);
        dsTaint.addTaint(rootView.dsTaint);
        dsTaint.addTaint(first);
        dsTaint.addTaint(windowFlags);
        boolean forceNewFocus;
        forceNewFocus = false;
        {
            {
                mHasBeenInactive = false;
                forceNewFocus = true;
            } //End block
            focusInLocked(focusedView != null ? focusedView : rootView);
        } //End block
        int controlFlags;
        controlFlags = 0;
        {
            controlFlags |= CONTROL_WINDOW_VIEW_HAS_FOCUS;
            {
                boolean var0242BE12406B0423DE07772CF55C658B_23299537 = (focusedView.onCheckIsTextEditor());
                {
                    controlFlags |= CONTROL_WINDOW_IS_TEXT_EDITOR;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            controlFlags |= CONTROL_WINDOW_FIRST;
        } //End block
        {
            boolean varA9A48C551659F51167AC084B8D435F7F_1107814582 = (checkFocusNoStartInput(forceNewFocus));
            {
                {
                    boolean varB37B48947248F8A7477A83BAD8B56060_118581388 = (startInputInner(rootView.getWindowToken(),
                    controlFlags, softInputMode, windowFlags));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            try 
            {
                mService.windowGainedFocus(mClient, rootView.getWindowToken(),
                        controlFlags, softInputMode, windowFlags, null, null);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.124 -0400", hash_original_method = "1A7A85BD07D131CBE39BA9D28F0E6F2A", hash_generated_method = "E0DC82F150B7DCF77976588E14A9051C")
    @DSModeled(DSC.SAFE)
    public void startGettingWindowFocus(View rootView) {
        dsTaint.addTaint(rootView.dsTaint);
        // ---------- Original Method ----------
        //synchronized (mH) {
            //mCurRootView = rootView;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.124 -0400", hash_original_method = "6EC728E52174DF43F39F15D376B96D59", hash_generated_method = "1F409DE8E0FDC3C75C6D15F92A1D359A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updateSelection(View view, int selStart, int selEnd,
            int candidatesStart, int candidatesEnd) {
        dsTaint.addTaint(candidatesStart);
        dsTaint.addTaint(candidatesEnd);
        dsTaint.addTaint(selStart);
        dsTaint.addTaint(selEnd);
        dsTaint.addTaint(view.dsTaint);
        checkFocus();
        {
            {
                boolean varAE432C6DAE316B6F74A275D95170B0F0_1209889053 = ((mServedView != view && (mServedView == null
                        || !mServedView.checkInputConnectionProxy(view)))
                    || mCurrentTextBoxAttribute == null || mCurMethod == null);
            } //End collapsed parenthetic
            {
                Log.d(TAG, "updateSelection");
                try 
                {
                    mCurMethod.updateSelection(mCursorSelStart, mCursorSelEnd,
                            selStart, selEnd, candidatesStart, candidatesEnd);
                } //End block
                catch (RemoteException e)
                { }
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.125 -0400", hash_original_method = "8E5F47C036105189BFF71EB5625C4E3F", hash_generated_method = "D025356D9AD58FE79777C0A1685F0E08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void viewClicked(View view) {
        dsTaint.addTaint(view.dsTaint);
        final boolean focusChanged;
        focusChanged = mServedView != mNextServedView;
        checkFocus();
        {
            {
                boolean var9326F29C98DC4C69471B39D26338712B_178368113 = ((mServedView != view && (mServedView == null
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.125 -0400", hash_original_method = "385DC57C25B266614A0F3F767A2E43B1", hash_generated_method = "4DB39EDCDD93A929E15CF42E5A3A2E40")
    @DSModeled(DSC.SAFE)
    public boolean isWatchingCursor(View view) {
        dsTaint.addTaint(view.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.125 -0400", hash_original_method = "06AF2B97EC9C8BBE1303A237FE727449", hash_generated_method = "046709A912F65339E3D64970E5D33B1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updateCursor(View view, int left, int top, int right, int bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        checkFocus();
        {
            {
                boolean varAE432C6DAE316B6F74A275D95170B0F0_513397001 = ((mServedView != view && (mServedView == null
                        || !mServedView.checkInputConnectionProxy(view)))
                    || mCurrentTextBoxAttribute == null || mCurMethod == null);
            } //End collapsed parenthetic
            mTmpCursorRect.set(left, top, right, bottom);
            {
                boolean var8D6B8539919CD2C288E2DD1195C4ABF6_1435497555 = (!mCursorRect.equals(mTmpCursorRect));
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.125 -0400", hash_original_method = "42E6E13C0C5606029CE59DAABCC4FEF4", hash_generated_method = "DED14B1D5BF720FFBF1A7FBDE7CE4AC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendAppPrivateCommand(View view, String action, Bundle data) {
        dsTaint.addTaint(action);
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        checkFocus();
        {
            {
                boolean varAE432C6DAE316B6F74A275D95170B0F0_1609060705 = ((mServedView != view && (mServedView == null
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.125 -0400", hash_original_method = "BA3360E0078151C4E77F69CD0F708AC2", hash_generated_method = "39A82AEA8F54FB1B29599800CBF56D1D")
    @DSModeled(DSC.SAFE)
    public void setInputMethod(IBinder token, String id) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(token.dsTaint);
        try 
        {
            mService.setInputMethod(token, id);
        } //End block
        catch (RemoteException e)
        {
            throw new RuntimeException(e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.setInputMethod(token, id);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.125 -0400", hash_original_method = "6B5F7BD4B9987D792262BC3FA22B0356", hash_generated_method = "25D9ACF919583956F2CC84855941E26B")
    @DSModeled(DSC.SAFE)
    public void setInputMethodAndSubtype(IBinder token, String id, InputMethodSubtype subtype) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(subtype.dsTaint);
        try 
        {
            mService.setInputMethodAndSubtype(token, id, subtype);
        } //End block
        catch (RemoteException e)
        {
            throw new RuntimeException(e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.setInputMethodAndSubtype(token, id, subtype);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.125 -0400", hash_original_method = "57E46D0940B3C65A92751CB9C29D6161", hash_generated_method = "92831FEC1650F2A7E19B29EECEAA1EC9")
    @DSModeled(DSC.SAFE)
    public void hideSoftInputFromInputMethod(IBinder token, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(token.dsTaint);
        try 
        {
            mService.hideMySoftInput(token, flags);
        } //End block
        catch (RemoteException e)
        {
            throw new RuntimeException(e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.hideMySoftInput(token, flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.125 -0400", hash_original_method = "E0804B4135D0004448137E06C89A5AC2", hash_generated_method = "AA707131C443D6A5256D68CECAEE753D")
    @DSModeled(DSC.SAFE)
    public void showSoftInputFromInputMethod(IBinder token, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(token.dsTaint);
        try 
        {
            mService.showMySoftInput(token, flags);
        } //End block
        catch (RemoteException e)
        {
            throw new RuntimeException(e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.showMySoftInput(token, flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.126 -0400", hash_original_method = "E668070B782BDDB11E06224CB9252B61", hash_generated_method = "65AF45BA8643CAE4F59780BF15442B89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchKeyEvent(Context context, int seq, KeyEvent key,
            IInputMethodCallback callback) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(seq);
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(key.dsTaint);
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
                boolean var209637C5B03F50E58BDA56A931544EE4_256753092 = (key.getAction() == KeyEvent.ACTION_DOWN
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.126 -0400", hash_original_method = "99D2E1A6FD8F8DDA0CF04D3632103B0E", hash_generated_method = "E1D1A7343912C3A7BF9741521F1553AC")
    @DSModeled(DSC.SAFE)
     void dispatchTrackballEvent(Context context, int seq, MotionEvent motion,
            IInputMethodCallback callback) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(seq);
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(motion.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.126 -0400", hash_original_method = "032A4A57AEC9378F2AEDB365B55F6952", hash_generated_method = "F671FFAA25262081A73FCC08906C304E")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.126 -0400", hash_original_method = "40ED720E9E0E9A18C34ACD22184580A8", hash_generated_method = "3EF26D7AE9960BDDEB8F98561A5B1DEC")
    @DSModeled(DSC.SAFE)
    public void showInputMethodAndSubtypeEnabler(String imiId) {
        dsTaint.addTaint(imiId);
        {
            try 
            {
                mService.showInputMethodAndSubtypeEnablerFromClient(mClient, imiId);
            } //End block
            catch (RemoteException e)
            { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.126 -0400", hash_original_method = "FD9F276F6D40BEB379032073F0CE055D", hash_generated_method = "B374859B16BBC671D05EAFB747445C20")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InputMethodSubtype getCurrentInputMethodSubtype() {
        {
            try 
            {
                InputMethodSubtype varC47DE9A11CA21AAECB2943C339C886AC_20840045 = (mService.getCurrentInputMethodSubtype());
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return (InputMethodSubtype)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.126 -0400", hash_original_method = "3CA77773C45BE29D3C7CB419603994A1", hash_generated_method = "4E631048A629509BFDD23BE844166742")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setCurrentInputMethodSubtype(InputMethodSubtype subtype) {
        dsTaint.addTaint(subtype.dsTaint);
        {
            try 
            {
                boolean varB772562C6791056C6792B89901F04090_2018169998 = (mService.setCurrentInputMethodSubtype(subtype));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.127 -0400", hash_original_method = "43A6DF9F5E808A92ECB1533408005E7F", hash_generated_method = "89A8081FAFDE5F0A9AC9ABF240E0A439")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Map<InputMethodInfo, List<InputMethodSubtype>> getShortcutInputMethodsAndSubtypes() {
        {
            HashMap<InputMethodInfo, List<InputMethodSubtype>> ret;
            ret = new HashMap<InputMethodInfo, List<InputMethodSubtype>>();
            try 
            {
                List<Object> info;
                info = mService.getShortcutInputMethodsAndSubtypes();
                ArrayList<InputMethodSubtype> subtypes;
                subtypes = null;
                final int N;
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
                                    boolean var3270550FE2662AB18C2A8C4288E9FE37_1173148073 = (ret.containsKey(o));
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
        } //End block
        return (Map<InputMethodInfo, List<InputMethodSubtype>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.127 -0400", hash_original_method = "36F8CCF4190068A92F1E830BF76C0680", hash_generated_method = "8B388F77D2940F82CE788AEE8F9C2F7A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean switchToLastInputMethod(IBinder imeToken) {
        dsTaint.addTaint(imeToken.dsTaint);
        {
            try 
            {
                boolean var8776571A2351650A62690661D0377A0B_168909561 = (mService.switchToLastInputMethod(imeToken));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.127 -0400", hash_original_method = "E3938A1614AA74CBD638A5A0682603ED", hash_generated_method = "214B4351C88090868FF9BF92E89DAC2D")
    @DSModeled(DSC.SAFE)
    public void setAdditionalInputMethodSubtypes(String imiId, InputMethodSubtype[] subtypes) {
        dsTaint.addTaint(subtypes.dsTaint);
        dsTaint.addTaint(imiId);
        {
            try 
            {
                mService.setAdditionalInputMethodSubtypes(imiId, subtypes);
            } //End block
            catch (RemoteException e)
            { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.127 -0400", hash_original_method = "D92C08014C42A358F015C9B31552925A", hash_generated_method = "00879FDC627F4EE72366E63D5E2FA598")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InputMethodSubtype getLastInputMethodSubtype() {
        {
            try 
            {
                InputMethodSubtype varA0D7049D4E067020BC39B64A5C1EAE46_1483257592 = (mService.getLastInputMethodSubtype());
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return (InputMethodSubtype)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.127 -0400", hash_original_method = "7B42B17DE444F3A26D40AC0247FFF795", hash_generated_method = "B22D263F40DEF134D5DDD49BB4D66C52")
    @DSModeled(DSC.SAFE)
     void doDump(FileDescriptor fd, PrintWriter fout, String[] args) {
        dsTaint.addTaint(fout.dsTaint);
        dsTaint.addTaint(args);
        dsTaint.addTaint(fd.dsTaint);
        final Printer p;
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
        p.println("  mNextServedView=" + mNextServedView);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    class H extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.127 -0400", hash_original_method = "6EF38EF9E91987FCDB2CC1FED5C76A24", hash_generated_method = "9EDC40BF66BB8988CA7511118A2613AB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         H(Looper looper) {
            super(looper);
            dsTaint.addTaint(looper.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.128 -0400", hash_original_method = "34443D7BDE8AC9FDF503183718E28994", hash_generated_method = "A5E190E55D53606E45DE6EF57D58C735")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void handleMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
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
                final InputBindResult res;
                res = (InputBindResult)msg.obj;
                {
                    mCurMethod = res.method;
                    mCurId = res.id;
                    mBindSequence = res.sequence;
                } //End block
                startInputInner(null, 0, 0, 0);
            } //End block
            //End case MSG_BIND 
            //Begin case MSG_UNBIND 
            {
                final int sequence;
                sequence = msg.arg1;
                boolean startInput;
                startInput = false;
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
                            boolean varDE258C52FC90033C41FC87EA7E287047_797442909 = (mServedView != null && mServedView.isFocused());
                            {
                                mServedConnecting = true;
                            } //End block
                        } //End collapsed parenthetic
                        {
                            startInput = true;
                        } //End block
                    } //End block
                } //End block
                {
                    startInputInner(null, 0, 0, 0);
                } //End block
            } //End block
            //End case MSG_UNBIND 
            //Begin case MSG_SET_ACTIVE 
            {
                final boolean active;
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
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private static class ControlledInputConnectionWrapper extends IInputConnectionWrapper {
        private final InputMethodManager mParentInputMethodManager;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.128 -0400", hash_original_method = "778EAAA875B5E9B35A79C47358BD4D78", hash_generated_method = "1992629771F662079804F17E50A074FA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ControlledInputConnectionWrapper(final Looper mainLooper, final InputConnection conn,
                final InputMethodManager inputMethodManager) {
            super(mainLooper, conn);
            dsTaint.addTaint(conn.dsTaint);
            dsTaint.addTaint(inputMethodManager.dsTaint);
            dsTaint.addTaint(mainLooper.dsTaint);
            // ---------- Original Method ----------
            //mParentInputMethodManager = inputMethodManager;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.128 -0400", hash_original_method = "FB049513493D8EDB25EAFF891B2EE0A9", hash_generated_method = "CBA8ABA09E10E327E734F1EA714631C9")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean isActive() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mParentInputMethodManager.mActive;
        }

        
    }


    
}


