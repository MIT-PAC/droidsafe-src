package android.inputmethodservice;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.os.HandlerCaller;
import com.android.internal.view.IInputContext;
import com.android.internal.view.IInputMethod;
import com.android.internal.view.IInputMethodCallback;
import com.android.internal.view.IInputMethodSession;
import com.android.internal.view.InputConnectionWrapper;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.util.Log;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputBinding;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodSession;
import android.view.inputmethod.InputMethodSubtype;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class IInputMethodWrapper extends IInputMethod.Stub implements HandlerCaller.Callback {
    WeakReference<AbstractInputMethodService> mTarget;
    HandlerCaller mCaller;
    WeakReference<InputMethod> mInputMethod;
    int mTargetSdkVersion;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.262 -0400", hash_original_method = "DFCCDEDB19B1DF7F583092AE267E5B16", hash_generated_method = "41DED08B8F5F57F371A7334CE4E546B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IInputMethodWrapper(AbstractInputMethodService context,
            InputMethod inputMethod) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(inputMethod.dsTaint);
        mTarget = new WeakReference<AbstractInputMethodService>(context);
        mCaller = new HandlerCaller(context.getApplicationContext(), this);
        mInputMethod = new WeakReference<InputMethod>(inputMethod);
        mTargetSdkVersion = context.getApplicationInfo().targetSdkVersion;
        // ---------- Original Method ----------
        //mTarget = new WeakReference<AbstractInputMethodService>(context);
        //mCaller = new HandlerCaller(context.getApplicationContext(), this);
        //mInputMethod = new WeakReference<InputMethod>(inputMethod);
        //mTargetSdkVersion = context.getApplicationInfo().targetSdkVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.262 -0400", hash_original_method = "578FDF861144B5ACC99AF98F1B65A29F", hash_generated_method = "51F59D75EF34BF1D5E1459BE6A766ECC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InputMethod getInternalInputMethod() {
        InputMethod var012D24704780CC7981226D0B2AA438B3_1216024732 = (mInputMethod.get());
        return (InputMethod)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mInputMethod.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.263 -0400", hash_original_method = "B32BF45DBAE9C0B66E1E8649B58C9B6E", hash_generated_method = "57A5AD984561EC62E30FA8A28F18C305")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void executeMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        InputMethod inputMethod;
        inputMethod = mInputMethod.get();
        //Begin case DO_DUMP 
        {
            AbstractInputMethodService target;
            target = mTarget.get();
            HandlerCaller.SomeArgs args;
            args = (HandlerCaller.SomeArgs)msg.obj;
            try 
            {
                target.dump((FileDescriptor)args.arg1,
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
        //End case DO_DUMP 
        //Begin case DO_ATTACH_TOKEN 
        {
            inputMethod.attachToken((IBinder)msg.obj);
        } //End block
        //End case DO_ATTACH_TOKEN 
        //Begin case DO_SET_INPUT_CONTEXT 
        {
            inputMethod.bindInput((InputBinding)msg.obj);
        } //End block
        //End case DO_SET_INPUT_CONTEXT 
        //Begin case DO_UNSET_INPUT_CONTEXT 
        inputMethod.unbindInput();
        //End case DO_UNSET_INPUT_CONTEXT 
        //Begin case DO_START_INPUT 
        {
            HandlerCaller.SomeArgs args;
            args = (HandlerCaller.SomeArgs)msg.obj;
            IInputContext inputContext;
            inputContext = (IInputContext)args.arg1;
            InputConnection ic;
            ic = new InputConnectionWrapper(inputContext);
            ic = null;
            EditorInfo info;
            info = (EditorInfo)args.arg2;
            info.makeCompatible(mTargetSdkVersion);
            inputMethod.startInput(ic, info);
        } //End block
        //End case DO_START_INPUT 
        //Begin case DO_RESTART_INPUT 
        {
            HandlerCaller.SomeArgs args;
            args = (HandlerCaller.SomeArgs)msg.obj;
            IInputContext inputContext;
            inputContext = (IInputContext)args.arg1;
            InputConnection ic;
            ic = new InputConnectionWrapper(inputContext);
            ic = null;
            EditorInfo info;
            info = (EditorInfo)args.arg2;
            info.makeCompatible(mTargetSdkVersion);
            inputMethod.restartInput(ic, info);
        } //End block
        //End case DO_RESTART_INPUT 
        //Begin case DO_CREATE_SESSION 
        {
            inputMethod.createSession(new InputMethodSessionCallbackWrapper(
                        mCaller.mContext, (IInputMethodCallback)msg.obj));
        } //End block
        //End case DO_CREATE_SESSION 
        //Begin case DO_SET_SESSION_ENABLED 
        inputMethod.setSessionEnabled((InputMethodSession)msg.obj,
                        msg.arg1 != 0);
        //End case DO_SET_SESSION_ENABLED 
        //Begin case DO_REVOKE_SESSION 
        inputMethod.revokeSession((InputMethodSession)msg.obj);
        //End case DO_REVOKE_SESSION 
        //Begin case DO_SHOW_SOFT_INPUT 
        inputMethod.showSoftInput(msg.arg1, (ResultReceiver)msg.obj);
        //End case DO_SHOW_SOFT_INPUT 
        //Begin case DO_HIDE_SOFT_INPUT 
        inputMethod.hideSoftInput(msg.arg1, (ResultReceiver)msg.obj);
        //End case DO_HIDE_SOFT_INPUT 
        //Begin case DO_CHANGE_INPUTMETHOD_SUBTYPE 
        inputMethod.changeInputMethodSubtype((InputMethodSubtype)msg.obj);
        //End case DO_CHANGE_INPUTMETHOD_SUBTYPE 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.263 -0400", hash_original_method = "0C6C3794FFF9A28E4B4CC38855176730", hash_generated_method = "110F291BB02CF1ADF11F59D69F28C7A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
        dsTaint.addTaint(fout.dsTaint);
        dsTaint.addTaint(args[0]);
        dsTaint.addTaint(fd.dsTaint);
        AbstractInputMethodService target;
        target = mTarget.get();
        {
            boolean varC0FC2D21D41E00A80F6EB67D7071050D_1124352077 = (target.checkCallingOrSelfPermission(android.Manifest.permission.DUMP)
                != PackageManager.PERMISSION_GRANTED);
            {
                fout.println("Permission Denial: can't dump InputMethodManager from from pid="
                    + Binder.getCallingPid()
                    + ", uid=" + Binder.getCallingUid());
            } //End block
        } //End collapsed parenthetic
        CountDownLatch latch;
        latch = new CountDownLatch(1);
        mCaller.executeOrSendMessage(mCaller.obtainMessageOOOO(DO_DUMP,
                fd, fout, args, latch));
        try 
        {
            {
                boolean varD9CF0FF0BA45C9F3F8A99C370C897802_6109057 = (!latch.await(5, TimeUnit.SECONDS));
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
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.264 -0400", hash_original_method = "3A045444AF5D8A822ADB03EA95145F6B", hash_generated_method = "C2AF29F791A4B824A851AD095BD24FD6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void attachToken(IBinder token) {
        dsTaint.addTaint(token.dsTaint);
        mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_ATTACH_TOKEN, token));
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_ATTACH_TOKEN, token));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.264 -0400", hash_original_method = "D25BEB041B9BF5E5D79B179E52337593", hash_generated_method = "0A4F0EC78D8C0BCAD9C27D9906D17AFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void bindInput(InputBinding binding) {
        dsTaint.addTaint(binding.dsTaint);
        InputConnection ic;
        ic = new InputConnectionWrapper(
                IInputContext.Stub.asInterface(binding.getConnectionToken()));
        InputBinding nu;
        nu = new InputBinding(ic, binding);
        mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_SET_INPUT_CONTEXT, nu));
        // ---------- Original Method ----------
        //InputConnection ic = new InputConnectionWrapper(
                //IInputContext.Stub.asInterface(binding.getConnectionToken()));
        //InputBinding nu = new InputBinding(ic, binding);
        //mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_SET_INPUT_CONTEXT, nu));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.264 -0400", hash_original_method = "40DD339E1316D187A0FAAB1DCDDB6E26", hash_generated_method = "30B4AF1F3E124873ADD5722DC7A8FD28")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unbindInput() {
        mCaller.executeOrSendMessage(mCaller.obtainMessage(DO_UNSET_INPUT_CONTEXT));
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessage(DO_UNSET_INPUT_CONTEXT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.264 -0400", hash_original_method = "64774C384C4074770EA84EAA9163C00A", hash_generated_method = "50FFEFB5F12FE749035280E47BD0124A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void startInput(IInputContext inputContext, EditorInfo attribute) {
        dsTaint.addTaint(attribute.dsTaint);
        dsTaint.addTaint(inputContext.dsTaint);
        mCaller.executeOrSendMessage(mCaller.obtainMessageOO(DO_START_INPUT,
                inputContext, attribute));
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageOO(DO_START_INPUT,
                //inputContext, attribute));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.264 -0400", hash_original_method = "2B9FBA45B912D421D9CC4953D88A52A4", hash_generated_method = "529B69A510C2A92A2DB0404FE510EF91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void restartInput(IInputContext inputContext, EditorInfo attribute) {
        dsTaint.addTaint(attribute.dsTaint);
        dsTaint.addTaint(inputContext.dsTaint);
        mCaller.executeOrSendMessage(mCaller.obtainMessageOO(DO_RESTART_INPUT,
                inputContext, attribute));
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageOO(DO_RESTART_INPUT,
                //inputContext, attribute));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.265 -0400", hash_original_method = "B4BFD5A332191A20B74FC4A001EBF3B5", hash_generated_method = "9B8D9B107CDD35639C0ADA456969B838")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void createSession(IInputMethodCallback callback) {
        dsTaint.addTaint(callback.dsTaint);
        mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_CREATE_SESSION, callback));
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_CREATE_SESSION, callback));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.265 -0400", hash_original_method = "BC36F335C1EF57BB31635290E9065CDE", hash_generated_method = "6FBC17FE9A9A3EBD637739250E9068D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSessionEnabled(IInputMethodSession session, boolean enabled) {
        dsTaint.addTaint(enabled);
        dsTaint.addTaint(session.dsTaint);
        try 
        {
            InputMethodSession ls;
            ls = ((IInputMethodSessionWrapper)
                    session).getInternalInputMethodSession();
            mCaller.executeOrSendMessage(mCaller.obtainMessageIO(
                    DO_SET_SESSION_ENABLED, enabled ? 1 : 0, ls));
        } //End block
        catch (ClassCastException e)
        { }
        // ---------- Original Method ----------
        //try {
            //InputMethodSession ls = ((IInputMethodSessionWrapper)
                    //session).getInternalInputMethodSession();
            //mCaller.executeOrSendMessage(mCaller.obtainMessageIO(
                    //DO_SET_SESSION_ENABLED, enabled ? 1 : 0, ls));
        //} catch (ClassCastException e) {
            //Log.w(TAG, "Incoming session not of correct type: " + session, e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.265 -0400", hash_original_method = "6C5BDC012D2E841761539B06F63A9AED", hash_generated_method = "AF64D096922998C366672C4624BD6134")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void revokeSession(IInputMethodSession session) {
        dsTaint.addTaint(session.dsTaint);
        try 
        {
            InputMethodSession ls;
            ls = ((IInputMethodSessionWrapper)
                    session).getInternalInputMethodSession();
            mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_REVOKE_SESSION, ls));
        } //End block
        catch (ClassCastException e)
        { }
        // ---------- Original Method ----------
        //try {
            //InputMethodSession ls = ((IInputMethodSessionWrapper)
                    //session).getInternalInputMethodSession();
            //mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_REVOKE_SESSION, ls));
        //} catch (ClassCastException e) {
            //Log.w(TAG, "Incoming session not of correct type: " + session, e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.265 -0400", hash_original_method = "F249E378FF675201B27E0C333F1303AC", hash_generated_method = "A0A5F88908ACD9A01D1EF22D0283BC5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void showSoftInput(int flags, ResultReceiver resultReceiver) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(resultReceiver.dsTaint);
        mCaller.executeOrSendMessage(mCaller.obtainMessageIO(DO_SHOW_SOFT_INPUT,
                flags, resultReceiver));
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageIO(DO_SHOW_SOFT_INPUT,
                //flags, resultReceiver));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.266 -0400", hash_original_method = "B180661AC63EF37C0C75DD9D2F92FEA1", hash_generated_method = "75DAC4F0B19EBDFCEF10C5F5F300343B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void hideSoftInput(int flags, ResultReceiver resultReceiver) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(resultReceiver.dsTaint);
        mCaller.executeOrSendMessage(mCaller.obtainMessageIO(DO_HIDE_SOFT_INPUT,
                flags, resultReceiver));
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageIO(DO_HIDE_SOFT_INPUT,
                //flags, resultReceiver));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.266 -0400", hash_original_method = "AC2D1B005425B264D93FFBD73CFFCA9B", hash_generated_method = "8D7718638B413FFF6DF51DBCBB2EEFB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void changeInputMethodSubtype(InputMethodSubtype subtype) {
        dsTaint.addTaint(subtype.dsTaint);
        mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_CHANGE_INPUTMETHOD_SUBTYPE,
                subtype));
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_CHANGE_INPUTMETHOD_SUBTYPE,
                //subtype));
    }

    
    static class Notifier {
        boolean notified;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.266 -0400", hash_original_method = "C546470DF8D608616E37E183911EFCB4", hash_generated_method = "C546470DF8D608616E37E183911EFCB4")
                public Notifier ()
        {
        }


    }


    
    static class InputMethodSessionCallbackWrapper implements InputMethod.SessionCallback {
        Context mContext;
        IInputMethodCallback mCb;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.266 -0400", hash_original_method = "13A9221242487F9ADC2AC17AB23350A5", hash_generated_method = "7FF251A71F548D596F2A8D998B1EF283")
        @DSModeled(DSC.SAFE)
         InputMethodSessionCallbackWrapper(Context context, IInputMethodCallback cb) {
            dsTaint.addTaint(cb.dsTaint);
            dsTaint.addTaint(context.dsTaint);
            // ---------- Original Method ----------
            //mContext = context;
            //mCb = cb;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.267 -0400", hash_original_method = "48F0A9C357FECEAE34F35D97A37A4655", hash_generated_method = "6D152C6838648FAC5927BFF0FDEE19DA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void sessionCreated(InputMethodSession session) {
            dsTaint.addTaint(session.dsTaint);
            try 
            {
                {
                    IInputMethodSessionWrapper wrap;
                    wrap = new IInputMethodSessionWrapper(mContext, session);
                    mCb.sessionCreated(wrap);
                } //End block
                {
                    mCb.sessionCreated(null);
                } //End block
            } //End block
            catch (RemoteException e)
            { }
            // ---------- Original Method ----------
            //try {
                //if (session != null) {
                    //IInputMethodSessionWrapper wrap =
                            //new IInputMethodSessionWrapper(mContext, session);
                    //mCb.sessionCreated(wrap);
                //} else {
                    //mCb.sessionCreated(null);
                //}
            //} catch (RemoteException e) {
            //}
        }

        
    }


    
    private static final String TAG = "InputMethodWrapper";
    private static final boolean DEBUG = false;
    private static final int DO_DUMP = 1;
    private static final int DO_ATTACH_TOKEN = 10;
    private static final int DO_SET_INPUT_CONTEXT = 20;
    private static final int DO_UNSET_INPUT_CONTEXT = 30;
    private static final int DO_START_INPUT = 32;
    private static final int DO_RESTART_INPUT = 34;
    private static final int DO_CREATE_SESSION = 40;
    private static final int DO_SET_SESSION_ENABLED = 45;
    private static final int DO_REVOKE_SESSION = 50;
    private static final int DO_SHOW_SOFT_INPUT = 60;
    private static final int DO_HIDE_SOFT_INPUT = 70;
    private static final int DO_CHANGE_INPUTMETHOD_SUBTYPE = 80;
}

