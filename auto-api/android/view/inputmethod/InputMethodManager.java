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
    IInputMethodManager mService;
    Looper mMainLooper;
    H mH;
    IInputContext mIInputContext;
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
    final IInputMethodClient.Stub mClient = new IInputMethodClient.Stub() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.383 -0400", hash_original_method = "F6EA3706319B79FC567D288B23EBD7C8", hash_generated_method = "613EB46A31CBEF0240723AC421DD89E6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
            dsTaint.addTaint(fout.dsTaint);
            dsTaint.addTaint(args[0]);
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
                    boolean var19E9A664FE2E8FD1F35B08B34B4A7B6E_938035819 = (!latch.await(5, TimeUnit.SECONDS));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.383 -0400", hash_original_method = "45BD5FF75807911B1CFCFBB58E96318E", hash_generated_method = "23FD78955F4FBE9FEAE96D621A37D30D")
        @DSModeled(DSC.SAFE)
        public void setUsingInputMethod(boolean state) {
            dsTaint.addTaint(state);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.384 -0400", hash_original_method = "574FEF71BCEC075DFBB030A0D3C30C22", hash_generated_method = "D31A48AA411CAC20113F20B078A1FBBF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onBindMethod(InputBindResult res) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(res.dsTaint);
            mH.sendMessage(mH.obtainMessage(MSG_BIND, res));
            // ---------- Original Method ----------
            //mH.sendMessage(mH.obtainMessage(MSG_BIND, res));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.384 -0400", hash_original_method = "588CEEFF7FA7882256433E31043E7659", hash_generated_method = "FF4E23F0AA9E3DC42F1EC27C17C4D9D2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onUnbindMethod(int sequence) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(sequence);
            mH.sendMessage(mH.obtainMessage(MSG_UNBIND, sequence, 0));
            // ---------- Original Method ----------
            //mH.sendMessage(mH.obtainMessage(MSG_UNBIND, sequence, 0));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.384 -0400", hash_original_method = "348B3468B5EF750F568EE6741021F563", hash_generated_method = "EAD0333039F2FA4DF46F644785A3F84F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setActive(boolean active) {
            dsTaint.addTaint(active);
            mH.sendMessage(mH.obtainMessage(MSG_SET_ACTIVE, active ? 1 : 0, 0));
            // ---------- Original Method ----------
            //mH.sendMessage(mH.obtainMessage(MSG_SET_ACTIVE, active ? 1 : 0, 0));
        }

        
}; //Transformed anonymous class
    InputConnection mDummyInputConnection = new BaseInputConnection(this, false);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.384 -0400", hash_original_method = "508ED56B5BF5DABABCAF5D12E61B17FA", hash_generated_method = "1677AC1E37E920BD79FD17426268FB55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.385 -0400", hash_original_method = "3D9C93A013E7DC300254687B6593E9DE", hash_generated_method = "207AA49D27155AEBF22A8E4545F2A0F5")
    @DSModeled(DSC.SAFE)
    public IInputMethodClient getClient() {
        return (IInputMethodClient)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mClient;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.385 -0400", hash_original_method = "BB1CC2AA4E519DFF3D7BB1A17FAAA9A1", hash_generated_method = "D89DCA67EACCEF980E719E5E32E71071")
    @DSModeled(DSC.SAFE)
    public IInputContext getInputContext() {
        return (IInputContext)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mIInputContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.386 -0400", hash_original_method = "4976C1493B414917938FA9CF9C859341", hash_generated_method = "EC70F214A7A4232A4CA74BC831D5E80E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<InputMethodInfo> getInputMethodList() {
        try 
        {
            List<InputMethodInfo> var5DA615228E4049E98604D5949629D11F_546654284 = (mService.getInputMethodList());
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        return (List<InputMethodInfo>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mService.getInputMethodList();
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.386 -0400", hash_original_method = "E8BA85FCD94534AA9F0D8586DC21C83A", hash_generated_method = "E3B1571F6177345BA11C6ED560564E86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<InputMethodInfo> getEnabledInputMethodList() {
        try 
        {
            List<InputMethodInfo> var0967F1C8D328AE920243EDD8DA13950F_1552449486 = (mService.getEnabledInputMethodList());
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        return (List<InputMethodInfo>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mService.getEnabledInputMethodList();
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.386 -0400", hash_original_method = "6701B30EF11ADDDCEFC97757F6DCE403", hash_generated_method = "EF23BB015AD5F6195F914B150EEF4127")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<InputMethodSubtype> getEnabledInputMethodSubtypeList(InputMethodInfo imi,
            boolean allowsImplicitlySelectedSubtypes) {
        dsTaint.addTaint(allowsImplicitlySelectedSubtypes);
        dsTaint.addTaint(imi.dsTaint);
        try 
        {
            List<InputMethodSubtype> varFEA8C839467085158AED05D4B65D2BE9_692284746 = (mService.getEnabledInputMethodSubtypeList(imi, allowsImplicitlySelectedSubtypes));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        return (List<InputMethodSubtype>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mService.getEnabledInputMethodSubtypeList(imi, allowsImplicitlySelectedSubtypes);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.386 -0400", hash_original_method = "53B62C40B5B8B2FB3464E7DA6A87D443", hash_generated_method = "B698DD626332BD6129350316D6012099")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.updateStatusIcon(imeToken, packageName, iconId);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.386 -0400", hash_original_method = "D00BAF75C3098DFC4E35D122E494F4F9", hash_generated_method = "0275906E5E94812D699A76AE75202FFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void hideStatusIcon(IBinder imeToken) {
        dsTaint.addTaint(imeToken.dsTaint);
        try 
        {
            mService.updateStatusIcon(imeToken, null, 0);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.updateStatusIcon(imeToken, null, 0);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.387 -0400", hash_original_method = "7375BD73E964162AE893F10DF6DE4659", hash_generated_method = "E56D81A527EF11E1BDA7FEFA8FD54E35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.setImeWindowStatus(imeToken, vis, backDisposition);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.387 -0400", hash_original_method = "E3510526CEDC6D4EEDFFA989F1389EB2", hash_generated_method = "EBF4050B35C59F18AB1D932EA9DD77F3")
    @DSModeled(DSC.SAFE)
    public void setFullscreenMode(boolean fullScreen) {
        dsTaint.addTaint(fullScreen);
        // ---------- Original Method ----------
        //mFullscreenMode = fullScreen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.387 -0400", hash_original_method = "CEA057AD7D0092E84D73E0D04E9F9DEE", hash_generated_method = "695432E48B80BC2671E8BB614561D5E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerSuggestionSpansForNotification(SuggestionSpan[] spans) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(spans[0].dsTaint);
        try 
        {
            mService.registerSuggestionSpansForNotification(spans);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.registerSuggestionSpansForNotification(spans);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.387 -0400", hash_original_method = "67AB3FB4ECE37955692BC451DD457E24", hash_generated_method = "039E6F205C80FC82F0433AAAD864BCFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifySuggestionPicked(SuggestionSpan span, String originalString, int index) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(originalString);
        dsTaint.addTaint(span.dsTaint);
        try 
        {
            mService.notifySuggestionPicked(span, originalString, index);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.notifySuggestionPicked(span, originalString, index);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.387 -0400", hash_original_method = "FCDCA2DC24AB76EAA903F8369A9A45F8", hash_generated_method = "50F8D669E2F80F326130745308FAF20E")
    @DSModeled(DSC.SAFE)
    public boolean isFullscreenMode() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFullscreenMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.388 -0400", hash_original_method = "BC82DFD48282D1B48FE7389621C80801", hash_generated_method = "2980FCDA203D92EFA94D0AC7594D008E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isActive(View view) {
        dsTaint.addTaint(view.dsTaint);
        checkFocus();
        {
            boolean var49F5D3F91085A10D821F326D270E0A6F_523314310 = ((mServedView == view
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.388 -0400", hash_original_method = "36DF2A9A4D9117D0F00790A34A3AF373", hash_generated_method = "D66172A7942A193A715231D64509EC2C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isActive() {
        checkFocus();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkFocus();
        //synchronized (mH) {
            //return mServedView != null && mCurrentTextBoxAttribute != null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.388 -0400", hash_original_method = "A9275A3C5F8B97D3BA22658E0542618D", hash_generated_method = "80C259AFA062D9991C65B8177F62CE05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isAcceptingText() {
        checkFocus();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkFocus();
        //return mServedInputConnection != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.388 -0400", hash_original_method = "3A92950E40C3C85A49E393646C27AEA9", hash_generated_method = "D4740FFBD500B6D301DCC0D1B2CFF8E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.388 -0400", hash_original_method = "7C74580464CD8E195E3FB8BED8B93C53", hash_generated_method = "EFB7670AA252AD66E15371A32A6F6C81")
    @DSModeled(DSC.SAFE)
     void clearConnectionLocked() {
        mCurrentTextBoxAttribute = null;
        mServedInputConnection = null;
        // ---------- Original Method ----------
        //mCurrentTextBoxAttribute = null;
        //mServedInputConnection = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.389 -0400", hash_original_method = "1D1918AFC608107C503CFA70B5918395", hash_generated_method = "AA515DE0E16181137D969794CDE6AEA4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.389 -0400", hash_original_method = "55A79A529B0E338884C3A2F27FEDBFDF", hash_generated_method = "20C7F86F7AB73948EBFC0A303A117484")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.389 -0400", hash_original_method = "2ABAAA397EA24F350376BE11BDE21CC8", hash_generated_method = "A2FE4C32EA37F900BE1E8DDCFFAB4397")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void displayCompletions(View view, CompletionInfo[] completions) {
        dsTaint.addTaint(completions[0].dsTaint);
        dsTaint.addTaint(view.dsTaint);
        checkFocus();
        {
            {
                boolean varDB99D0AC55C2DBA21EBD734EA036F99E_715639944 = (mServedView != view && (mServedView == null
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.389 -0400", hash_original_method = "51F483359287A71D0F033A0D1668F291", hash_generated_method = "648E4BB42C21E3443B557BED4BAAC634")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updateExtractedText(View view, int token, ExtractedText text) {
        dsTaint.addTaint(text.dsTaint);
        dsTaint.addTaint(token);
        dsTaint.addTaint(view.dsTaint);
        checkFocus();
        {
            {
                boolean var5B46188F855DD0910683CAEF46B64CFE_1005671570 = (mServedView != view && (mServedView == null
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.390 -0400", hash_original_method = "8D2F613F92BFA1616CD527BE18090765", hash_generated_method = "F174DE526A219E6D5676DE29BDFC2381")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean showSoftInput(View view, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(view.dsTaint);
        boolean var42A64BEF015E8CA610A96851B469250A_3883938 = (showSoftInput(view, flags, null));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return showSoftInput(view, flags, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.390 -0400", hash_original_method = "182A36951EBA765A4D1CAFFC02BFF851", hash_generated_method = "A7D2E322AA4ECE8299580D13DDFA3A29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean showSoftInput(View view, int flags, ResultReceiver resultReceiver) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(resultReceiver.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        checkFocus();
        {
            {
                boolean var5B46188F855DD0910683CAEF46B64CFE_560528848 = (mServedView != view && (mServedView == null
                    || !mServedView.checkInputConnectionProxy(view)));
            } //End collapsed parenthetic
            try 
            {
                boolean varDFAA7336B82EE31799175E615A34D3DD_2000753415 = (mService.showSoftInput(mClient, flags, resultReceiver));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.390 -0400", hash_original_method = "5110555AB7D318C3F52B5C2085DD7CF4", hash_generated_method = "0BE42E9D14C3E29A239E11DF7D5B83A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.390 -0400", hash_original_method = "4391301CC9B8F998B7CF2FBAB148B8AA", hash_generated_method = "A0BFA3E3177ED7C62741490C031B048E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hideSoftInputFromWindow(IBinder windowToken, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(windowToken.dsTaint);
        boolean var658CF3AB42C3F6232FD0409B6B2947F4_192761142 = (hideSoftInputFromWindow(windowToken, flags, null));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return hideSoftInputFromWindow(windowToken, flags, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.391 -0400", hash_original_method = "0C97F129DA85CEA766FB3D7196531B26", hash_generated_method = "89C76DD26770AE12980CE7EE61564073")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hideSoftInputFromWindow(IBinder windowToken, int flags,
            ResultReceiver resultReceiver) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(resultReceiver.dsTaint);
        dsTaint.addTaint(windowToken.dsTaint);
        checkFocus();
        {
            {
                boolean var601FF64E452C8A4BAF1A32D29190540F_1206153526 = (mServedView == null || mServedView.getWindowToken() != windowToken);
            } //End collapsed parenthetic
            try 
            {
                boolean var5CACD3E08A6D77B7E674FDCDC8126BA5_892166975 = (mService.hideSoftInput(mClient, flags, resultReceiver));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.391 -0400", hash_original_method = "A530968907DBDDA36B89C5946F7EC59D", hash_generated_method = "BB478A749E2C4C0CDCFA74093932C21C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void toggleSoftInputFromWindow(IBinder windowToken, int showFlags, int hideFlags) {
        dsTaint.addTaint(showFlags);
        dsTaint.addTaint(hideFlags);
        dsTaint.addTaint(windowToken.dsTaint);
        {
            {
                boolean var601FF64E452C8A4BAF1A32D29190540F_162030371 = (mServedView == null || mServedView.getWindowToken() != windowToken);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.391 -0400", hash_original_method = "79211245E8E42CAB1585D75CD7067652", hash_generated_method = "5AE138259081A01B3824C6808F705D77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.391 -0400", hash_original_method = "BA4374E6D4A75A28B6D0173A2084DC55", hash_generated_method = "9D8DEF900489BF52B31AAF27C3011E2B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void restartInput(View view) {
        dsTaint.addTaint(view.dsTaint);
        checkFocus();
        {
            {
                boolean var5B46188F855DD0910683CAEF46B64CFE_579118732 = (mServedView != view && (mServedView == null
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.392 -0400", hash_original_method = "CF2A319158D1C1C6E1F6B6F3296FA7D3", hash_generated_method = "6995A224FCD08C1F50FAFBCA4AB8BC8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean startInputInner(IBinder windowGainingFocus, int controlFlags, int softInputMode,
            int windowFlags) {
        dsTaint.addTaint(softInputMode);
        dsTaint.addTaint(windowGainingFocus.dsTaint);
        dsTaint.addTaint(windowFlags);
        dsTaint.addTaint(controlFlags);
        View view;
        {
            view = mServedView;
        } //End block
        Handler vh;
        vh = view.getHandler();
        {
            boolean varFAF728F056691316E709D0988E6B1364_2116960927 = (vh.getLooper() != Looper.myLooper());
            {
                vh.post(new Runnable() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.392 -0400", hash_original_method = "F2A906933651BC1AD21C72495CC57893", hash_generated_method = "C3F49DF962F1935350744B4A7F4FE4B7")
                    //DSFIXME:  CODE0002: Requires DSC value to be set
                    public void run() {
                        startInputInner(null, 0, 0, 0);
                        // ---------- Original Method ----------
                        //startInputInner(null, 0, 0, 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.393 -0400", hash_original_method = "574E98E1F1761FC0DC94CE21F83FBF8C", hash_generated_method = "45050310837218C2791C2DF911FACD77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void windowDismissed(IBinder appWindowToken) {
        dsTaint.addTaint(appWindowToken.dsTaint);
        checkFocus();
        {
            {
                boolean var502A33EED994770E53552DF8C0F7D670_606910069 = (mServedView != null &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.393 -0400", hash_original_method = "3DD6E391932A9CCCB1C61486572B8B95", hash_generated_method = "EFC6536269DA78BF9B3F0DC7EC3DD691")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.393 -0400", hash_original_method = "3857011248BD1E1DC17E86CAECB63023", hash_generated_method = "9B53A3627738F9A36ED1CAD487193AAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void focusInLocked(View view) {
        dsTaint.addTaint(view.dsTaint);
        {
            boolean var2071CEBD080665CA877F4A0459696EBB_1592012147 = (mCurRootView != view.getRootView());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.393 -0400", hash_original_method = "CA0F410F50592B0E0C8F6A16050EA193", hash_generated_method = "5603A239253F2093BA90216F9848DF3D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void focusOut(View view) {
        dsTaint.addTaint(view.dsTaint);
        {
            {
                {
                    boolean varF1B8C4C009E1C99A6024E9498723A4C9_884922180 = (false && view.hasWindowFocus());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.394 -0400", hash_original_method = "4A6B64189F9C851EAF66731814D5760A", hash_generated_method = "4062495F59E5720CA2EA113209FB964C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void scheduleCheckFocusLocked(View view) {
        dsTaint.addTaint(view.dsTaint);
        Handler vh;
        vh = view.getHandler();
        {
            boolean varD62C9DEF2A1FD7096AF2D550C310DFDB_258072071 = (vh != null && !vh.hasMessages(ViewRootImpl.CHECK_FOCUS));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.394 -0400", hash_original_method = "64A348A284CC5420AEF9228B1B5539B8", hash_generated_method = "CFEB9C79426016A9E9F091EEB4A63644")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void checkFocus() {
        {
            boolean var5D01190D1B25B520FBF50BA5E13361B3_1153649283 = (checkFocusNoStartInput(false));
            {
                startInputInner(null, 0, 0, 0);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (checkFocusNoStartInput(false)) {
            //startInputInner(null, 0, 0, 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.394 -0400", hash_original_method = "397B5366DA4CE4E943079DE884783BB0", hash_generated_method = "B57BD5D15FDC7CA6C7FBDD33CC03F00A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.394 -0400", hash_original_method = "D0A5B4195CF8CF9C3EE8D9642BA1EAAF", hash_generated_method = "71DE39AC33B8D3F4BC97B84EA854C263")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.395 -0400", hash_original_method = "4C566AFC7DD636C90E911F90B7CCB429", hash_generated_method = "D69C1EB9E1E0E7B7E8056DABD28CFFE1")
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
                boolean var0242BE12406B0423DE07772CF55C658B_1065624270 = (focusedView.onCheckIsTextEditor());
                {
                    controlFlags |= CONTROL_WINDOW_IS_TEXT_EDITOR;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            controlFlags |= CONTROL_WINDOW_FIRST;
        } //End block
        {
            boolean varA9A48C551659F51167AC084B8D435F7F_1584027289 = (checkFocusNoStartInput(forceNewFocus));
            {
                {
                    boolean varB37B48947248F8A7477A83BAD8B56060_1936307717 = (startInputInner(rootView.getWindowToken(),
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.395 -0400", hash_original_method = "1A7A85BD07D131CBE39BA9D28F0E6F2A", hash_generated_method = "99633407A4080C62076E5CC92F2AA4D1")
    @DSModeled(DSC.SAFE)
    public void startGettingWindowFocus(View rootView) {
        dsTaint.addTaint(rootView.dsTaint);
        // ---------- Original Method ----------
        //synchronized (mH) {
            //mCurRootView = rootView;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.395 -0400", hash_original_method = "6EC728E52174DF43F39F15D376B96D59", hash_generated_method = "309A558B85F4A94E23B6FB422D7AFA04")
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
                boolean varAE432C6DAE316B6F74A275D95170B0F0_1732248151 = ((mServedView != view && (mServedView == null
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.396 -0400", hash_original_method = "8E5F47C036105189BFF71EB5625C4E3F", hash_generated_method = "48DAAF2AB0BBA73D57498FAC61898B48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void viewClicked(View view) {
        dsTaint.addTaint(view.dsTaint);
        boolean focusChanged;
        focusChanged = mServedView != mNextServedView;
        checkFocus();
        {
            {
                boolean var9326F29C98DC4C69471B39D26338712B_340407918 = ((mServedView != view && (mServedView == null
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.396 -0400", hash_original_method = "385DC57C25B266614A0F3F767A2E43B1", hash_generated_method = "C785AB84CC0D61325B386691E0D4EAD2")
    @DSModeled(DSC.SAFE)
    public boolean isWatchingCursor(View view) {
        dsTaint.addTaint(view.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.396 -0400", hash_original_method = "06AF2B97EC9C8BBE1303A237FE727449", hash_generated_method = "C415A964FCA62FDBB25B2408AB9FFF46")
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
                boolean varAE432C6DAE316B6F74A275D95170B0F0_1860744253 = ((mServedView != view && (mServedView == null
                        || !mServedView.checkInputConnectionProxy(view)))
                    || mCurrentTextBoxAttribute == null || mCurMethod == null);
            } //End collapsed parenthetic
            mTmpCursorRect.set(left, top, right, bottom);
            {
                boolean var8D6B8539919CD2C288E2DD1195C4ABF6_190648545 = (!mCursorRect.equals(mTmpCursorRect));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.397 -0400", hash_original_method = "42E6E13C0C5606029CE59DAABCC4FEF4", hash_generated_method = "22F370FFB80DA05E51022582A2E56C92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendAppPrivateCommand(View view, String action, Bundle data) {
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(action);
        dsTaint.addTaint(view.dsTaint);
        checkFocus();
        {
            {
                boolean varAE432C6DAE316B6F74A275D95170B0F0_281143492 = ((mServedView != view && (mServedView == null
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.397 -0400", hash_original_method = "BA3360E0078151C4E77F69CD0F708AC2", hash_generated_method = "6ED7528F99BB6156BD717079205FD15D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setInputMethod(IBinder token, String id) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(token.dsTaint);
        try 
        {
            mService.setInputMethod(token, id);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.setInputMethod(token, id);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.397 -0400", hash_original_method = "6B5F7BD4B9987D792262BC3FA22B0356", hash_generated_method = "243FE14E71699EE8C069707EA47B20CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.setInputMethodAndSubtype(token, id, subtype);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.397 -0400", hash_original_method = "57E46D0940B3C65A92751CB9C29D6161", hash_generated_method = "39908DF1ACDF01FC2EC3943FDFCDD3ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void hideSoftInputFromInputMethod(IBinder token, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(token.dsTaint);
        try 
        {
            mService.hideMySoftInput(token, flags);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.hideMySoftInput(token, flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.397 -0400", hash_original_method = "E0804B4135D0004448137E06C89A5AC2", hash_generated_method = "253FCD8201BBBC2B652F43DDC8A50C1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void showSoftInputFromInputMethod(IBinder token, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(token.dsTaint);
        try 
        {
            mService.showMySoftInput(token, flags);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.showMySoftInput(token, flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.398 -0400", hash_original_method = "E668070B782BDDB11E06224CB9252B61", hash_generated_method = "360CBC75F8E2FBCD4AA747EFE4C13571")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchKeyEvent(Context context, int seq, KeyEvent key,
            IInputMethodCallback callback) {
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(seq);
        dsTaint.addTaint(context.dsTaint);
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
                boolean var209637C5B03F50E58BDA56A931544EE4_1098611901 = (key.getAction() == KeyEvent.ACTION_DOWN
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.398 -0400", hash_original_method = "99D2E1A6FD8F8DDA0CF04D3632103B0E", hash_generated_method = "4621C774402313F29B9628726F550F14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void dispatchTrackballEvent(Context context, int seq, MotionEvent motion,
            IInputMethodCallback callback) {
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(seq);
        dsTaint.addTaint(context.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.398 -0400", hash_original_method = "032A4A57AEC9378F2AEDB365B55F6952", hash_generated_method = "3A675125C27FF9A084EDB85F14080C74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.398 -0400", hash_original_method = "40ED720E9E0E9A18C34ACD22184580A8", hash_generated_method = "26BA31E47408DF2F03220822DA3B801C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.399 -0400", hash_original_method = "FD9F276F6D40BEB379032073F0CE055D", hash_generated_method = "C63EE34C9AD7602D12580FF5E8DFD4BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InputMethodSubtype getCurrentInputMethodSubtype() {
        {
            try 
            {
                InputMethodSubtype varC47DE9A11CA21AAECB2943C339C886AC_344885135 = (mService.getCurrentInputMethodSubtype());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.399 -0400", hash_original_method = "3CA77773C45BE29D3C7CB419603994A1", hash_generated_method = "7B5848608834DBD7198163CDDF2DF8F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setCurrentInputMethodSubtype(InputMethodSubtype subtype) {
        dsTaint.addTaint(subtype.dsTaint);
        {
            try 
            {
                boolean varB772562C6791056C6792B89901F04090_820498518 = (mService.setCurrentInputMethodSubtype(subtype));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.399 -0400", hash_original_method = "43A6DF9F5E808A92ECB1533408005E7F", hash_generated_method = "43DC90D56F7CA403094B035BFB11214E")
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
                                    boolean var3270550FE2662AB18C2A8C4288E9FE37_203959648 = (ret.containsKey(o));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.400 -0400", hash_original_method = "36F8CCF4190068A92F1E830BF76C0680", hash_generated_method = "8D23101326FF51E666DE23992AA6771F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean switchToLastInputMethod(IBinder imeToken) {
        dsTaint.addTaint(imeToken.dsTaint);
        {
            try 
            {
                boolean var8776571A2351650A62690661D0377A0B_321105999 = (mService.switchToLastInputMethod(imeToken));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.400 -0400", hash_original_method = "E3938A1614AA74CBD638A5A0682603ED", hash_generated_method = "DF4E0695D15D9ACCAA38B33A494CBF4E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAdditionalInputMethodSubtypes(String imiId, InputMethodSubtype[] subtypes) {
        dsTaint.addTaint(subtypes[0].dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.400 -0400", hash_original_method = "D92C08014C42A358F015C9B31552925A", hash_generated_method = "0845CC2F211F33A586696987C46B8976")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InputMethodSubtype getLastInputMethodSubtype() {
        {
            try 
            {
                InputMethodSubtype varA0D7049D4E067020BC39B64A5C1EAE46_1489816883 = (mService.getLastInputMethodSubtype());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.401 -0400", hash_original_method = "7B42B17DE444F3A26D40AC0247FFF795", hash_generated_method = "321F6FC7228AFB5943623A569BBEA5DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void doDump(FileDescriptor fd, PrintWriter fout, String[] args) {
        dsTaint.addTaint(fout.dsTaint);
        dsTaint.addTaint(args[0]);
        dsTaint.addTaint(fd.dsTaint);
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.401 -0400", hash_original_method = "6EF38EF9E91987FCDB2CC1FED5C76A24", hash_generated_method = "38E87504B4366CE6532E29A32A420D30")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         H(Looper looper) {
            super(looper);
            dsTaint.addTaint(looper.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.402 -0400", hash_original_method = "34443D7BDE8AC9FDF503183718E28994", hash_generated_method = "63D5A8961486051D842AF986A07ABCD0")
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
                InputBindResult res;
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
                int sequence;
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
                            boolean varDE258C52FC90033C41FC87EA7E287047_2020564139 = (mServedView != null && mServedView.isFocused());
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
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private static class ControlledInputConnectionWrapper extends IInputConnectionWrapper {
        private InputMethodManager mParentInputMethodManager;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.402 -0400", hash_original_method = "778EAAA875B5E9B35A79C47358BD4D78", hash_generated_method = "D24D96E89ED41B97694B55E8C5F5129E")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.402 -0400", hash_original_method = "FB049513493D8EDB25EAFF891B2EE0A9", hash_generated_method = "6A47CF93139718002704048B11332246")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean isActive() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mParentInputMethodManager.mActive;
        }

        
    }


    
    static final boolean DEBUG = false;
    static final String TAG = "InputMethodManager";
    static final Object mInstanceSync = new Object();
    static InputMethodManager mInstance;
    public static final int CONTROL_WINDOW_VIEW_HAS_FOCUS = 1<<0;
    public static final int CONTROL_WINDOW_IS_TEXT_EDITOR = 1<<1;
    public static final int CONTROL_WINDOW_FIRST = 1<<2;
    public static final int CONTROL_START_INITIAL = 1<<8;
    static final int MSG_DUMP = 1;
    static final int MSG_BIND = 2;
    static final int MSG_UNBIND = 3;
    static final int MSG_SET_ACTIVE = 4;
    public static final int SHOW_IMPLICIT = 0x0001;
    public static final int SHOW_FORCED = 0x0002;
    public static final int RESULT_UNCHANGED_SHOWN = 0;
    public static final int RESULT_UNCHANGED_HIDDEN = 1;
    public static final int RESULT_SHOWN = 2;
    public static final int RESULT_HIDDEN = 3;
    public static final int HIDE_IMPLICIT_ONLY = 0x0001;
    public static final int HIDE_NOT_ALWAYS = 0x0002;
}

