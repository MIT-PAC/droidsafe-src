package android.inputmethodservice;

// Droidsafe Imports
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputBinding;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodSession;
import android.view.inputmethod.InputMethodSubtype;

import com.android.internal.os.HandlerCaller;
import com.android.internal.view.IInputContext;
import com.android.internal.view.IInputMethod;
import com.android.internal.view.IInputMethodCallback;
import com.android.internal.view.IInputMethodSession;
import com.android.internal.view.InputConnectionWrapper;

import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

class IInputMethodWrapper extends IInputMethod.Stub implements HandlerCaller.Callback {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.304 -0400", hash_original_field = "562619214306F5C11A815E975B7D2477", hash_generated_field = "2E2648297276C861114A30927FA43363")

    WeakReference<AbstractInputMethodService> mTarget;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.304 -0400", hash_original_field = "02B8E2B08EEFD631BD36F22665C339F2", hash_generated_field = "B57F12AA48E3204FC249B7683181CCD8")

    HandlerCaller mCaller;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.304 -0400", hash_original_field = "DBEE96406A00F429F32FF5AA58FA6E69", hash_generated_field = "0ECBF70CFB7F254C659E968057073B93")

    WeakReference<InputMethod> mInputMethod;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.304 -0400", hash_original_field = "62D22558492391EE18A59E61D13DF59B", hash_generated_field = "B8EEE6865DFA2D11E19D316E427BCF57")

    int mTargetSdkVersion;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.305 -0400", hash_original_method = "DFCCDEDB19B1DF7F583092AE267E5B16", hash_generated_method = "6F5993443C1291E21C9E3FE7A8BE55D7")
    public  IInputMethodWrapper(AbstractInputMethodService context,
            InputMethod inputMethod) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.306 -0400", hash_original_method = "578FDF861144B5ACC99AF98F1B65A29F", hash_generated_method = "178ED6C5F9CB2892D0129CECEB052A65")
    public InputMethod getInternalInputMethod() {
InputMethod var68ED14805F4A474C688994B0C0607ED3_1418493318 =         mInputMethod.get();
        var68ED14805F4A474C688994B0C0607ED3_1418493318.addTaint(taint);
        return var68ED14805F4A474C688994B0C0607ED3_1418493318;
        // ---------- Original Method ----------
        //return mInputMethod.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.308 -0400", hash_original_method = "B32BF45DBAE9C0B66E1E8649B58C9B6E", hash_generated_method = "115400CD5C79FDFE9F93E59EF31CE231")
    public void executeMessage(Message msg) {
        addTaint(msg.getTaint());
        InputMethod inputMethod = mInputMethod.get();
        if(inputMethod == null && msg.what != DO_DUMP)        
        {
            return;
        } //End block
switch(msg.what){
        case DO_DUMP:
        {
            AbstractInputMethodService target = mTarget.get();
            if(target == null)            
            {
                return;
            } //End block
            HandlerCaller.SomeArgs args = (HandlerCaller.SomeArgs)msg.obj;
            try 
            {
                target.dump((FileDescriptor)args.arg1,
                            (PrintWriter)args.arg2, (String[])args.arg3);
            } //End block
            catch (RuntimeException e)
            {
                ((PrintWriter)args.arg2).println("Exception: " + e);
            } //End block
            synchronized
(args.arg4)            {
                ((CountDownLatch)args.arg4).countDown();
            } //End block
            return;
        } //End block
        case DO_ATTACH_TOKEN:
        {
            inputMethod.attachToken((IBinder)msg.obj);
            return;
        } //End block
        case DO_SET_INPUT_CONTEXT:
        {
            inputMethod.bindInput((InputBinding)msg.obj);
            return;
        } //End block
        case DO_UNSET_INPUT_CONTEXT:
        inputMethod.unbindInput();
        return;
        case DO_START_INPUT:
        {
            HandlerCaller.SomeArgs args = (HandlerCaller.SomeArgs)msg.obj;
            IInputContext inputContext = (IInputContext)args.arg1;
            InputConnection ic = inputContext != null
                        ? new InputConnectionWrapper(inputContext) : null;
            EditorInfo info = (EditorInfo)args.arg2;
            info.makeCompatible(mTargetSdkVersion);
            inputMethod.startInput(ic, info);
            return;
        } //End block
        case DO_RESTART_INPUT:
        {
            HandlerCaller.SomeArgs args = (HandlerCaller.SomeArgs)msg.obj;
            IInputContext inputContext = (IInputContext)args.arg1;
            InputConnection ic = inputContext != null
                        ? new InputConnectionWrapper(inputContext) : null;
            EditorInfo info = (EditorInfo)args.arg2;
            info.makeCompatible(mTargetSdkVersion);
            inputMethod.restartInput(ic, info);
            return;
        } //End block
        case DO_CREATE_SESSION:
        {
            inputMethod.createSession(new InputMethodSessionCallbackWrapper(
                        mCaller.mContext, (IInputMethodCallback)msg.obj));
            return;
        } //End block
        case DO_SET_SESSION_ENABLED:
        inputMethod.setSessionEnabled((InputMethodSession)msg.obj,
                        msg.arg1 != 0);
        return;
        case DO_REVOKE_SESSION:
        inputMethod.revokeSession((InputMethodSession)msg.obj);
        return;
        case DO_SHOW_SOFT_INPUT:
        inputMethod.showSoftInput(msg.arg1, (ResultReceiver)msg.obj);
        return;
        case DO_HIDE_SOFT_INPUT:
        inputMethod.hideSoftInput(msg.arg1, (ResultReceiver)msg.obj);
        return;
        case DO_CHANGE_INPUTMETHOD_SUBTYPE:
        inputMethod.changeInputMethodSubtype((InputMethodSubtype)msg.obj);
        return;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.309 -0400", hash_original_method = "0C6C3794FFF9A28E4B4CC38855176730", hash_generated_method = "5C3B89CEAFB1037D980F523EF0E795CF")
    @Override
    protected void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
        addTaint(args[0].getTaint());
        addTaint(fout.getTaint());
        addTaint(fd.getTaint());
        AbstractInputMethodService target = mTarget.get();
        if(target == null)        
        {
            return;
        } //End block
        if(target.checkCallingOrSelfPermission(android.Manifest.permission.DUMP)
                != PackageManager.PERMISSION_GRANTED)        
        {
            fout.println("Permission Denial: can't dump InputMethodManager from from pid="
                    + Binder.getCallingPid()
                    + ", uid=" + Binder.getCallingUid());
            return;
        } //End block
        CountDownLatch latch = new CountDownLatch(1);
        mCaller.executeOrSendMessage(mCaller.obtainMessageOOOO(DO_DUMP,
                fd, fout, args, latch));
        try 
        {
            if(!latch.await(5, TimeUnit.SECONDS))            
            {
                fout.println("Timeout waiting for dump");
            } //End block
        } //End block
        catch (InterruptedException e)
        {
            fout.println("Interrupted waiting for dump");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.310 -0400", hash_original_method = "3A045444AF5D8A822ADB03EA95145F6B", hash_generated_method = "772C878158490A9890E863B0E2AFC13A")
    public void attachToken(IBinder token) {
        addTaint(token.getTaint());
        mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_ATTACH_TOKEN, token));
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_ATTACH_TOKEN, token));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.310 -0400", hash_original_method = "D25BEB041B9BF5E5D79B179E52337593", hash_generated_method = "8B26C33CE3861CBAEB0ED997FD364584")
    public void bindInput(InputBinding binding) {
        addTaint(binding.getTaint());
        InputConnection ic = new InputConnectionWrapper(
                IInputContext.Stub.asInterface(binding.getConnectionToken()));
        InputBinding nu = new InputBinding(ic, binding);
        mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_SET_INPUT_CONTEXT, nu));
        // ---------- Original Method ----------
        //InputConnection ic = new InputConnectionWrapper(
                //IInputContext.Stub.asInterface(binding.getConnectionToken()));
        //InputBinding nu = new InputBinding(ic, binding);
        //mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_SET_INPUT_CONTEXT, nu));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.311 -0400", hash_original_method = "40DD339E1316D187A0FAAB1DCDDB6E26", hash_generated_method = "30B4AF1F3E124873ADD5722DC7A8FD28")
    public void unbindInput() {
        mCaller.executeOrSendMessage(mCaller.obtainMessage(DO_UNSET_INPUT_CONTEXT));
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessage(DO_UNSET_INPUT_CONTEXT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.311 -0400", hash_original_method = "64774C384C4074770EA84EAA9163C00A", hash_generated_method = "5A4D871BAB3E577F0EA6355D396A979E")
    public void startInput(IInputContext inputContext, EditorInfo attribute) {
        addTaint(attribute.getTaint());
        addTaint(inputContext.getTaint());
        mCaller.executeOrSendMessage(mCaller.obtainMessageOO(DO_START_INPUT,
                inputContext, attribute));
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageOO(DO_START_INPUT,
                //inputContext, attribute));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.311 -0400", hash_original_method = "2B9FBA45B912D421D9CC4953D88A52A4", hash_generated_method = "14C139F21AE9B2EC9BDC67DFAAD72818")
    public void restartInput(IInputContext inputContext, EditorInfo attribute) {
        addTaint(attribute.getTaint());
        addTaint(inputContext.getTaint());
        mCaller.executeOrSendMessage(mCaller.obtainMessageOO(DO_RESTART_INPUT,
                inputContext, attribute));
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageOO(DO_RESTART_INPUT,
                //inputContext, attribute));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.312 -0400", hash_original_method = "B4BFD5A332191A20B74FC4A001EBF3B5", hash_generated_method = "B492509B0121A864825A7DF554D891C6")
    public void createSession(IInputMethodCallback callback) {
        addTaint(callback.getTaint());
        mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_CREATE_SESSION, callback));
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_CREATE_SESSION, callback));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.313 -0400", hash_original_method = "BC36F335C1EF57BB31635290E9065CDE", hash_generated_method = "6E5B80F8484E679193122042C33CB93C")
    public void setSessionEnabled(IInputMethodSession session, boolean enabled) {
        addTaint(enabled);
        addTaint(session.getTaint());
        try 
        {
            InputMethodSession ls = ((IInputMethodSessionWrapper)
                    session).getInternalInputMethodSession();
            mCaller.executeOrSendMessage(mCaller.obtainMessageIO(
                    DO_SET_SESSION_ENABLED, enabled ? 1 : 0, ls));
        } //End block
        catch (ClassCastException e)
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.315 -0400", hash_original_method = "6C5BDC012D2E841761539B06F63A9AED", hash_generated_method = "DCE3E552E0E6837330ECC01B1C43D626")
    public void revokeSession(IInputMethodSession session) {
        addTaint(session.getTaint());
        try 
        {
            InputMethodSession ls = ((IInputMethodSessionWrapper)
                    session).getInternalInputMethodSession();
            mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_REVOKE_SESSION, ls));
        } //End block
        catch (ClassCastException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //InputMethodSession ls = ((IInputMethodSessionWrapper)
                    //session).getInternalInputMethodSession();
            //mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_REVOKE_SESSION, ls));
        //} catch (ClassCastException e) {
            //Log.w(TAG, "Incoming session not of correct type: " + session, e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.316 -0400", hash_original_method = "F249E378FF675201B27E0C333F1303AC", hash_generated_method = "3542FE0809A6916BE53AFA78364022A6")
    public void showSoftInput(int flags, ResultReceiver resultReceiver) {
        addTaint(resultReceiver.getTaint());
        addTaint(flags);
        mCaller.executeOrSendMessage(mCaller.obtainMessageIO(DO_SHOW_SOFT_INPUT,
                flags, resultReceiver));
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageIO(DO_SHOW_SOFT_INPUT,
                //flags, resultReceiver));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.317 -0400", hash_original_method = "B180661AC63EF37C0C75DD9D2F92FEA1", hash_generated_method = "12E4BDA6464BDD3567E7DC57C14775F1")
    public void hideSoftInput(int flags, ResultReceiver resultReceiver) {
        addTaint(resultReceiver.getTaint());
        addTaint(flags);
        mCaller.executeOrSendMessage(mCaller.obtainMessageIO(DO_HIDE_SOFT_INPUT,
                flags, resultReceiver));
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageIO(DO_HIDE_SOFT_INPUT,
                //flags, resultReceiver));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.317 -0400", hash_original_method = "AC2D1B005425B264D93FFBD73CFFCA9B", hash_generated_method = "1DA8DD8012CFC11E5B5E3DCD948FC673")
    public void changeInputMethodSubtype(InputMethodSubtype subtype) {
        addTaint(subtype.getTaint());
        mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_CHANGE_INPUTMETHOD_SUBTYPE,
                subtype));
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_CHANGE_INPUTMETHOD_SUBTYPE,
                //subtype));
    }

    
    static class Notifier {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.318 -0400", hash_original_field = "E559AD34903D3D717A1488EAEED707F1", hash_generated_field = "40E30856FA4358AF33733196E7A5FB3C")

        boolean notified;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.318 -0400", hash_original_method = "55E10D988B76888B9ACFA8C6EB5966C6", hash_generated_method = "55E10D988B76888B9ACFA8C6EB5966C6")
        public Notifier ()
        {
            //Synthesized constructor
        }


    }


    
    static class InputMethodSessionCallbackWrapper implements InputMethod.SessionCallback {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.318 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

        Context mContext;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.318 -0400", hash_original_field = "BF2154B8BBFCFB3FCA616857B4286387", hash_generated_field = "4903C6C7AA2E39F51C3230E9003EAA25")

        IInputMethodCallback mCb;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.319 -0400", hash_original_method = "13A9221242487F9ADC2AC17AB23350A5", hash_generated_method = "427A9FF60907459201AB79C9C0F81EEB")
          InputMethodSessionCallbackWrapper(Context context, IInputMethodCallback cb) {
            mContext = context;
            mCb = cb;
            // ---------- Original Method ----------
            //mContext = context;
            //mCb = cb;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.321 -0400", hash_original_method = "48F0A9C357FECEAE34F35D97A37A4655", hash_generated_method = "FB1AC90704DCA61D773488DEFB939B45")
        public void sessionCreated(InputMethodSession session) {
            addTaint(session.getTaint());
            try 
            {
                if(session != null)                
                {
                    IInputMethodSessionWrapper wrap = new IInputMethodSessionWrapper(mContext, session);
                    mCb.sessionCreated(wrap);
                } //End block
                else
                {
                    mCb.sessionCreated(null);
                } //End block
            } //End block
            catch (RemoteException e)
            {
            } //End block
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.322 -0400", hash_original_field = "2F0141CD0AA2AC8746CE367240D90F41", hash_generated_field = "7B184F0C0152E5E9C735D79B852D0D03")

    private static final String TAG = "InputMethodWrapper";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.322 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.322 -0400", hash_original_field = "67CBFDD6EA8087D4DA6272817EDD9979", hash_generated_field = "B6060526BB66630D1590E7BBD3CA1E8B")

    private static final int DO_DUMP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.322 -0400", hash_original_field = "3FB13EEF0E7F577AD2489F6E33923054", hash_generated_field = "99EF2DDB01ABCC97E225ADD52E2047CC")

    private static final int DO_ATTACH_TOKEN = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.322 -0400", hash_original_field = "41B26A24DE45A7B05A4EF1C55D79AD22", hash_generated_field = "38FC979513EFB535F09BB7F8138BF334")

    private static final int DO_SET_INPUT_CONTEXT = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.322 -0400", hash_original_field = "E498AA16ED1D5931F3CF105C552B2DE1", hash_generated_field = "22492B2956F4B8EF9F08D08189754183")

    private static final int DO_UNSET_INPUT_CONTEXT = 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.322 -0400", hash_original_field = "BF92EA74BBA8B6526E5616F6EB8C0535", hash_generated_field = "F0A9DC92BD93E58E4D2898F6BA709F03")

    private static final int DO_START_INPUT = 32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.322 -0400", hash_original_field = "7D62CE732BC10CAA312379502E65CE85", hash_generated_field = "9D8BCB586E0F72F5FA4F496A8557FBDA")

    private static final int DO_RESTART_INPUT = 34;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.323 -0400", hash_original_field = "CEBCA1EAD8F7653BE0BA0CC63DADC9F2", hash_generated_field = "817B03DBB5A4DE6631C4C3705B289D56")

    private static final int DO_CREATE_SESSION = 40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.323 -0400", hash_original_field = "844C1D9DC16C0B407B1FA79952FF2D99", hash_generated_field = "72071B95AE4C8A1C078661FCEF198D16")

    private static final int DO_SET_SESSION_ENABLED = 45;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.323 -0400", hash_original_field = "92AA0D92866D18902F3473537FBC83F5", hash_generated_field = "20B17225A0ACE56986723F2383085E56")

    private static final int DO_REVOKE_SESSION = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.323 -0400", hash_original_field = "194403562F8CAC65B141D5F3AD112C68", hash_generated_field = "E9CB4AFDB3DF39C1E6DA28762B89DC35")

    private static final int DO_SHOW_SOFT_INPUT = 60;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.323 -0400", hash_original_field = "2698D45E4D22E42D5E7F145F66D535A4", hash_generated_field = "DB5A6034091B7B34D4026C5C5DB46355")

    private static final int DO_HIDE_SOFT_INPUT = 70;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.323 -0400", hash_original_field = "5BEC9B6AAB1B233E57B39A9266B76738", hash_generated_field = "6EEB6BFDB7D544695A46899A151DC28D")

    private static final int DO_CHANGE_INPUTMETHOD_SUBTYPE = 80;
}

