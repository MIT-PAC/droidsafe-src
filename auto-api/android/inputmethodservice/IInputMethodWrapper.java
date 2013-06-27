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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.744 -0400", hash_original_field = "562619214306F5C11A815E975B7D2477", hash_generated_field = "2E2648297276C861114A30927FA43363")

    WeakReference<AbstractInputMethodService> mTarget;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.744 -0400", hash_original_field = "02B8E2B08EEFD631BD36F22665C339F2", hash_generated_field = "B57F12AA48E3204FC249B7683181CCD8")

    HandlerCaller mCaller;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.744 -0400", hash_original_field = "DBEE96406A00F429F32FF5AA58FA6E69", hash_generated_field = "0ECBF70CFB7F254C659E968057073B93")

    WeakReference<InputMethod> mInputMethod;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.744 -0400", hash_original_field = "62D22558492391EE18A59E61D13DF59B", hash_generated_field = "B8EEE6865DFA2D11E19D316E427BCF57")

    int mTargetSdkVersion;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.749 -0400", hash_original_method = "DFCCDEDB19B1DF7F583092AE267E5B16", hash_generated_method = "6F5993443C1291E21C9E3FE7A8BE55D7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.749 -0400", hash_original_method = "578FDF861144B5ACC99AF98F1B65A29F", hash_generated_method = "3498E9F0C9ACF9F11E08C9CF85FB8469")
    public InputMethod getInternalInputMethod() {
        InputMethod varB4EAC82CA7396A68D541C85D26508E83_443802314 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_443802314 = mInputMethod.get();
        varB4EAC82CA7396A68D541C85D26508E83_443802314.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_443802314;
        // ---------- Original Method ----------
        //return mInputMethod.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.779 -0400", hash_original_method = "B32BF45DBAE9C0B66E1E8649B58C9B6E", hash_generated_method = "B751F4B4D0B483735C163ABEACA34E04")
    public void executeMessage(Message msg) {
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
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.790 -0400", hash_original_method = "0C6C3794FFF9A28E4B4CC38855176730", hash_generated_method = "053C8C05BD77B35E16DB5238CD8A66E6")
    @Override
    protected void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
        AbstractInputMethodService target;
        target = mTarget.get();
        {
            boolean varC0FC2D21D41E00A80F6EB67D7071050D_1975231979 = (target.checkCallingOrSelfPermission(android.Manifest.permission.DUMP)
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
                boolean varD9CF0FF0BA45C9F3F8A99C370C897802_189824149 = (!latch.await(5, TimeUnit.SECONDS));
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
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.793 -0400", hash_original_method = "3A045444AF5D8A822ADB03EA95145F6B", hash_generated_method = "CE55F5552C04CEE200DADCE50E74FBC8")
    public void attachToken(IBinder token) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_ATTACH_TOKEN, token));
        addTaint(token.getTaint());
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_ATTACH_TOKEN, token));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.805 -0400", hash_original_method = "D25BEB041B9BF5E5D79B179E52337593", hash_generated_method = "2C79175BE14ACE8370541D17A50BB010")
    public void bindInput(InputBinding binding) {
        InputConnection ic;
        ic = new InputConnectionWrapper(
                IInputContext.Stub.asInterface(binding.getConnectionToken()));
        InputBinding nu;
        nu = new InputBinding(ic, binding);
        mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_SET_INPUT_CONTEXT, nu));
        addTaint(binding.getTaint());
        // ---------- Original Method ----------
        //InputConnection ic = new InputConnectionWrapper(
                //IInputContext.Stub.asInterface(binding.getConnectionToken()));
        //InputBinding nu = new InputBinding(ic, binding);
        //mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_SET_INPUT_CONTEXT, nu));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.808 -0400", hash_original_method = "40DD339E1316D187A0FAAB1DCDDB6E26", hash_generated_method = "30B4AF1F3E124873ADD5722DC7A8FD28")
    public void unbindInput() {
        mCaller.executeOrSendMessage(mCaller.obtainMessage(DO_UNSET_INPUT_CONTEXT));
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessage(DO_UNSET_INPUT_CONTEXT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.809 -0400", hash_original_method = "64774C384C4074770EA84EAA9163C00A", hash_generated_method = "A2ACDDEE3A701F6CE5F7A237EFA6EE60")
    public void startInput(IInputContext inputContext, EditorInfo attribute) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageOO(DO_START_INPUT,
                inputContext, attribute));
        addTaint(inputContext.getTaint());
        addTaint(attribute.getTaint());
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageOO(DO_START_INPUT,
                //inputContext, attribute));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.813 -0400", hash_original_method = "2B9FBA45B912D421D9CC4953D88A52A4", hash_generated_method = "A7F35F143BF163134018D9861EADC8FE")
    public void restartInput(IInputContext inputContext, EditorInfo attribute) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageOO(DO_RESTART_INPUT,
                inputContext, attribute));
        addTaint(inputContext.getTaint());
        addTaint(attribute.getTaint());
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageOO(DO_RESTART_INPUT,
                //inputContext, attribute));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.814 -0400", hash_original_method = "B4BFD5A332191A20B74FC4A001EBF3B5", hash_generated_method = "25EE3C085A1EB0E0727373F2918B4460")
    public void createSession(IInputMethodCallback callback) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_CREATE_SESSION, callback));
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_CREATE_SESSION, callback));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.827 -0400", hash_original_method = "BC36F335C1EF57BB31635290E9065CDE", hash_generated_method = "97CE877B2C3919D354A90990B8FCFB45")
    public void setSessionEnabled(IInputMethodSession session, boolean enabled) {
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
        addTaint(session.getTaint());
        addTaint(enabled);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.829 -0400", hash_original_method = "6C5BDC012D2E841761539B06F63A9AED", hash_generated_method = "E7B562E35D144CAC4893D13AB49168AF")
    public void revokeSession(IInputMethodSession session) {
        try 
        {
            InputMethodSession ls;
            ls = ((IInputMethodSessionWrapper)
                    session).getInternalInputMethodSession();
            mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_REVOKE_SESSION, ls));
        } //End block
        catch (ClassCastException e)
        { }
        addTaint(session.getTaint());
        // ---------- Original Method ----------
        //try {
            //InputMethodSession ls = ((IInputMethodSessionWrapper)
                    //session).getInternalInputMethodSession();
            //mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_REVOKE_SESSION, ls));
        //} catch (ClassCastException e) {
            //Log.w(TAG, "Incoming session not of correct type: " + session, e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.829 -0400", hash_original_method = "F249E378FF675201B27E0C333F1303AC", hash_generated_method = "8F25E9C99163158409F61C0C4B5AF612")
    public void showSoftInput(int flags, ResultReceiver resultReceiver) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageIO(DO_SHOW_SOFT_INPUT,
                flags, resultReceiver));
        addTaint(flags);
        addTaint(resultReceiver.getTaint());
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageIO(DO_SHOW_SOFT_INPUT,
                //flags, resultReceiver));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.833 -0400", hash_original_method = "B180661AC63EF37C0C75DD9D2F92FEA1", hash_generated_method = "A4E5EB960B804218DEFCE6E23E51F680")
    public void hideSoftInput(int flags, ResultReceiver resultReceiver) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageIO(DO_HIDE_SOFT_INPUT,
                flags, resultReceiver));
        addTaint(flags);
        addTaint(resultReceiver.getTaint());
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageIO(DO_HIDE_SOFT_INPUT,
                //flags, resultReceiver));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.834 -0400", hash_original_method = "AC2D1B005425B264D93FFBD73CFFCA9B", hash_generated_method = "3E63D48A319612F24321BB8C339A4B50")
    public void changeInputMethodSubtype(InputMethodSubtype subtype) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_CHANGE_INPUTMETHOD_SUBTYPE,
                subtype));
        addTaint(subtype.getTaint());
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_CHANGE_INPUTMETHOD_SUBTYPE,
                //subtype));
    }

    
    static class Notifier {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.851 -0400", hash_original_field = "E559AD34903D3D717A1488EAEED707F1", hash_generated_field = "40E30856FA4358AF33733196E7A5FB3C")

        boolean notified;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.851 -0400", hash_original_method = "55E10D988B76888B9ACFA8C6EB5966C6", hash_generated_method = "55E10D988B76888B9ACFA8C6EB5966C6")
        public Notifier ()
        {
            //Synthesized constructor
        }


    }


    
    static class InputMethodSessionCallbackWrapper implements InputMethod.SessionCallback {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.852 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

        Context mContext;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.852 -0400", hash_original_field = "BF2154B8BBFCFB3FCA616857B4286387", hash_generated_field = "4903C6C7AA2E39F51C3230E9003EAA25")

        IInputMethodCallback mCb;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.853 -0400", hash_original_method = "13A9221242487F9ADC2AC17AB23350A5", hash_generated_method = "427A9FF60907459201AB79C9C0F81EEB")
          InputMethodSessionCallbackWrapper(Context context, IInputMethodCallback cb) {
            mContext = context;
            mCb = cb;
            // ---------- Original Method ----------
            //mContext = context;
            //mCb = cb;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.854 -0400", hash_original_method = "48F0A9C357FECEAE34F35D97A37A4655", hash_generated_method = "18CF864F68A142FD38F2D4A23C80205D")
        public void sessionCreated(InputMethodSession session) {
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
            addTaint(session.getTaint());
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.854 -0400", hash_original_field = "2F0141CD0AA2AC8746CE367240D90F41", hash_generated_field = "A32AB2456B1458570FCDAB0BFF072B5E")

    private static String TAG = "InputMethodWrapper";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.854 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "E83DF1E2E661A92B1AFDA8C473D190B2")

    private static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.854 -0400", hash_original_field = "67CBFDD6EA8087D4DA6272817EDD9979", hash_generated_field = "22F182FB783EBCDA27A11245DF00746C")

    private static int DO_DUMP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.854 -0400", hash_original_field = "3FB13EEF0E7F577AD2489F6E33923054", hash_generated_field = "FDB006445C6DE025D6AEEECD989EB090")

    private static int DO_ATTACH_TOKEN = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.854 -0400", hash_original_field = "41B26A24DE45A7B05A4EF1C55D79AD22", hash_generated_field = "A9E8A1F95597CBCBBA9114ECAA1B1435")

    private static int DO_SET_INPUT_CONTEXT = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.854 -0400", hash_original_field = "E498AA16ED1D5931F3CF105C552B2DE1", hash_generated_field = "AEAFCEAB1C50142AD0D2E306BE549889")

    private static int DO_UNSET_INPUT_CONTEXT = 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.854 -0400", hash_original_field = "BF92EA74BBA8B6526E5616F6EB8C0535", hash_generated_field = "EF612816C53DAD57D7036748FB9EF9F9")

    private static int DO_START_INPUT = 32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.855 -0400", hash_original_field = "7D62CE732BC10CAA312379502E65CE85", hash_generated_field = "A2AD21F233795585858624E4B0DDD32D")

    private static int DO_RESTART_INPUT = 34;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.855 -0400", hash_original_field = "CEBCA1EAD8F7653BE0BA0CC63DADC9F2", hash_generated_field = "AE97D692B48156A119FCA40E71E6B758")

    private static int DO_CREATE_SESSION = 40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.855 -0400", hash_original_field = "844C1D9DC16C0B407B1FA79952FF2D99", hash_generated_field = "26ECDB1D8D790152B288A111A64A739B")

    private static int DO_SET_SESSION_ENABLED = 45;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.855 -0400", hash_original_field = "92AA0D92866D18902F3473537FBC83F5", hash_generated_field = "FD7B55F1B38D3B1E246A4C8BCDB8208A")

    private static int DO_REVOKE_SESSION = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.855 -0400", hash_original_field = "194403562F8CAC65B141D5F3AD112C68", hash_generated_field = "ACAFE4F0906EED7CE5FF1DED1A6E3DBD")

    private static int DO_SHOW_SOFT_INPUT = 60;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.855 -0400", hash_original_field = "2698D45E4D22E42D5E7F145F66D535A4", hash_generated_field = "7CD270D458FE60D2245A0F87E69AEAC5")

    private static int DO_HIDE_SOFT_INPUT = 70;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.856 -0400", hash_original_field = "5BEC9B6AAB1B233E57B39A9266B76738", hash_generated_field = "30F0B4FFC1DEB0879606DD105F51E659")

    private static int DO_CHANGE_INPUTMETHOD_SUBTYPE = 80;
}

