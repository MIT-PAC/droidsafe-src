package android.inputmethodservice;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
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




class IInputMethodWrapper extends IInputMethod.Stub implements HandlerCaller.Callback {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.594 -0500", hash_original_field = "C78C0AF3A280B526CE72F80B5C668B56", hash_generated_field = "7B184F0C0152E5E9C735D79B852D0D03")

    private static final String TAG = "InputMethodWrapper";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.594 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.596 -0500", hash_original_field = "B19D81C909D8258C8683F85F63582959", hash_generated_field = "B6060526BB66630D1590E7BBD3CA1E8B")

    
    private static final int DO_DUMP = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.597 -0500", hash_original_field = "55B0D14DA71B49ACD473DAE16C275A32", hash_generated_field = "99EF2DDB01ABCC97E225ADD52E2047CC")

    private static final int DO_ATTACH_TOKEN = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.598 -0500", hash_original_field = "B02E6B0F5E17CF99CE18F9EEE709C946", hash_generated_field = "38FC979513EFB535F09BB7F8138BF334")

    private static final int DO_SET_INPUT_CONTEXT = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.598 -0500", hash_original_field = "04FB809825BE5E4FCAA5D405CE03D339", hash_generated_field = "22492B2956F4B8EF9F08D08189754183")

    private static final int DO_UNSET_INPUT_CONTEXT = 30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.599 -0500", hash_original_field = "9CB2C80A615A13124CB91ED9BB79F5BC", hash_generated_field = "F0A9DC92BD93E58E4D2898F6BA709F03")

    private static final int DO_START_INPUT = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.600 -0500", hash_original_field = "15BC2637A53523091F6D64B2D4DD6D5C", hash_generated_field = "9D8BCB586E0F72F5FA4F496A8557FBDA")

    private static final int DO_RESTART_INPUT = 34;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.601 -0500", hash_original_field = "70259F4EDAD132F6F07B7494F73AD513", hash_generated_field = "817B03DBB5A4DE6631C4C3705B289D56")

    private static final int DO_CREATE_SESSION = 40;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.602 -0500", hash_original_field = "C1996B03D7497D0C8A522079EC38BFE1", hash_generated_field = "72071B95AE4C8A1C078661FCEF198D16")

    private static final int DO_SET_SESSION_ENABLED = 45;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.603 -0500", hash_original_field = "E6A26C663A0AFB6168B86A1AB1187C26", hash_generated_field = "20B17225A0ACE56986723F2383085E56")

    private static final int DO_REVOKE_SESSION = 50;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.604 -0500", hash_original_field = "E58CDE1D6F95E492916EAA7A28FB74D1", hash_generated_field = "E9CB4AFDB3DF39C1E6DA28762B89DC35")

    private static final int DO_SHOW_SOFT_INPUT = 60;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.604 -0500", hash_original_field = "DC319D9D88E5A501E640C192AFB646BB", hash_generated_field = "DB5A6034091B7B34D4026C5C5DB46355")

    private static final int DO_HIDE_SOFT_INPUT = 70;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.605 -0500", hash_original_field = "B9405B73A4F32CFC4657ED9E6E5C6D37", hash_generated_field = "6EEB6BFDB7D544695A46899A151DC28D")

    private static final int DO_CHANGE_INPUTMETHOD_SUBTYPE = 80;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.606 -0500", hash_original_field = "2E2648297276C861114A30927FA43363", hash_generated_field = "2E2648297276C861114A30927FA43363")

   
     WeakReference<AbstractInputMethodService> mTarget;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.607 -0500", hash_original_field = "B57F12AA48E3204FC249B7683181CCD8", hash_generated_field = "B57F12AA48E3204FC249B7683181CCD8")

     HandlerCaller mCaller;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.608 -0500", hash_original_field = "0ECBF70CFB7F254C659E968057073B93", hash_generated_field = "0ECBF70CFB7F254C659E968057073B93")

     WeakReference<InputMethod> mInputMethod;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.608 -0500", hash_original_field = "B8EEE6865DFA2D11E19D316E427BCF57", hash_generated_field = "B8EEE6865DFA2D11E19D316E427BCF57")

     int mTargetSdkVersion;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.615 -0500", hash_original_method = "DFCCDEDB19B1DF7F583092AE267E5B16", hash_generated_method = "EBB48782D157BCD8A896FF0F699A638C")
    public IInputMethodWrapper(AbstractInputMethodService context,
            InputMethod inputMethod) {
        mTarget = new WeakReference<AbstractInputMethodService>(context);
        mCaller = new HandlerCaller(context.getApplicationContext(), this);
        mInputMethod = new WeakReference<InputMethod>(inputMethod);
        mTargetSdkVersion = context.getApplicationInfo().targetSdkVersion;
    }

    
    static class Notifier {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.609 -0500", hash_original_field = "40E30856FA4358AF33733196E7A5FB3C", hash_generated_field = "40E30856FA4358AF33733196E7A5FB3C")

        boolean notified;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.318 -0400", hash_original_method = "55E10D988B76888B9ACFA8C6EB5966C6", hash_generated_method = "55E10D988B76888B9ACFA8C6EB5966C6")
        public Notifier ()
        {
            //Synthesized constructor
        }


    }


    
    static class InputMethodSessionCallbackWrapper implements InputMethod.SessionCallback {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.611 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

         Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.612 -0500", hash_original_field = "4903C6C7AA2E39F51C3230E9003EAA25", hash_generated_field = "4903C6C7AA2E39F51C3230E9003EAA25")

         IInputMethodCallback mCb;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.612 -0500", hash_original_method = "13A9221242487F9ADC2AC17AB23350A5", hash_generated_method = "13A9221242487F9ADC2AC17AB23350A5")
        InputMethodSessionCallbackWrapper(Context context, IInputMethodCallback cb) {
            mContext = context;
            mCb = cb;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.613 -0500", hash_original_method = "48F0A9C357FECEAE34F35D97A37A4655", hash_generated_method = "10DC4FC095EEAA81B39A459F18502B27")
        public void sessionCreated(InputMethodSession session) {
            try {
                if (session != null) {
                    IInputMethodSessionWrapper wrap =
                            new IInputMethodSessionWrapper(mContext, session);
                    mCb.sessionCreated(wrap);
                } else {
                    mCb.sessionCreated(null);
                }
            } catch (RemoteException e) {
            }
        }

        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.615 -0500", hash_original_method = "578FDF861144B5ACC99AF98F1B65A29F", hash_generated_method = "32B6135A6011BC01F69AD00B76E7BC8D")
    public InputMethod getInternalInputMethod() {
        return mInputMethod.get();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.617 -0500", hash_original_method = "B32BF45DBAE9C0B66E1E8649B58C9B6E", hash_generated_method = "EF6B92070B6A1A2D760FFE13B4656436")
    public void executeMessage(Message msg) {
        InputMethod inputMethod = mInputMethod.get();
        // Need a valid reference to the inputMethod for everything except a dump.
        if (inputMethod == null && msg.what != DO_DUMP) {
            Log.w(TAG, "Input method reference was null, ignoring message: " + msg.what);
            return;
        }

        switch (msg.what) {
            case DO_DUMP: {
                AbstractInputMethodService target = mTarget.get();
                if (target == null) {
                    return;
                }
                HandlerCaller.SomeArgs args = (HandlerCaller.SomeArgs)msg.obj;
                try {
                    target.dump((FileDescriptor)args.arg1,
                            (PrintWriter)args.arg2, (String[])args.arg3);
                } catch (RuntimeException e) {
                    ((PrintWriter)args.arg2).println("Exception: " + e);
                }
                synchronized (args.arg4) {
                    ((CountDownLatch)args.arg4).countDown();
                }
                return;
            }
            
            case DO_ATTACH_TOKEN: {
                inputMethod.attachToken((IBinder)msg.obj);
                return;
            }
            case DO_SET_INPUT_CONTEXT: {
                inputMethod.bindInput((InputBinding)msg.obj);
                return;
            }
            case DO_UNSET_INPUT_CONTEXT:
                inputMethod.unbindInput();
                return;
            case DO_START_INPUT: {
                HandlerCaller.SomeArgs args = (HandlerCaller.SomeArgs)msg.obj;
                IInputContext inputContext = (IInputContext)args.arg1;
                InputConnection ic = inputContext != null
                        ? new InputConnectionWrapper(inputContext) : null;
                EditorInfo info = (EditorInfo)args.arg2;
                info.makeCompatible(mTargetSdkVersion);
                inputMethod.startInput(ic, info);
                return;
            }
            case DO_RESTART_INPUT: {
                HandlerCaller.SomeArgs args = (HandlerCaller.SomeArgs)msg.obj;
                IInputContext inputContext = (IInputContext)args.arg1;
                InputConnection ic = inputContext != null
                        ? new InputConnectionWrapper(inputContext) : null;
                EditorInfo info = (EditorInfo)args.arg2;
                info.makeCompatible(mTargetSdkVersion);
                inputMethod.restartInput(ic, info);
                return;
            }
            case DO_CREATE_SESSION: {
                inputMethod.createSession(new InputMethodSessionCallbackWrapper(
                        mCaller.mContext, (IInputMethodCallback)msg.obj));
                return;
            }
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
        Log.w(TAG, "Unhandled message code: " + msg.what);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.618 -0500", hash_original_method = "0C6C3794FFF9A28E4B4CC38855176730", hash_generated_method = "A75778FEB5D169E7C44C230EA74F9DEB")
    @Override
protected void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
        AbstractInputMethodService target = mTarget.get();
        if (target == null) {
            return;
        }
        if (target.checkCallingOrSelfPermission(android.Manifest.permission.DUMP)
                != PackageManager.PERMISSION_GRANTED) {
            
            fout.println("Permission Denial: can't dump InputMethodManager from from pid="
                    + Binder.getCallingPid()
                    + ", uid=" + Binder.getCallingUid());
            return;
        }

        CountDownLatch latch = new CountDownLatch(1);
        mCaller.executeOrSendMessage(mCaller.obtainMessageOOOO(DO_DUMP,
                fd, fout, args, latch));
        try {
            if (!latch.await(5, TimeUnit.SECONDS)) {
                fout.println("Timeout waiting for dump");
            }
        } catch (InterruptedException e) {
            fout.println("Interrupted waiting for dump");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.618 -0500", hash_original_method = "3A045444AF5D8A822ADB03EA95145F6B", hash_generated_method = "C328F1AE0D2CA8F5324801046C88F455")
    public void attachToken(IBinder token) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_ATTACH_TOKEN, token));
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.619 -0500", hash_original_method = "D25BEB041B9BF5E5D79B179E52337593", hash_generated_method = "B318BC3152876BB632F258639F89B894")
    public void bindInput(InputBinding binding) {
        InputConnection ic = new InputConnectionWrapper(
                IInputContext.Stub.asInterface(binding.getConnectionToken()));
        InputBinding nu = new InputBinding(ic, binding);
        mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_SET_INPUT_CONTEXT, nu));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.620 -0500", hash_original_method = "40DD339E1316D187A0FAAB1DCDDB6E26", hash_generated_method = "9B5C1EC0B33711120A1EC5015A94B79E")
    public void unbindInput() {
        mCaller.executeOrSendMessage(mCaller.obtainMessage(DO_UNSET_INPUT_CONTEXT));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.621 -0500", hash_original_method = "64774C384C4074770EA84EAA9163C00A", hash_generated_method = "C33C37307A2EE48E8FEFCB135AC5F49A")
    public void startInput(IInputContext inputContext, EditorInfo attribute) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageOO(DO_START_INPUT,
                inputContext, attribute));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.622 -0500", hash_original_method = "2B9FBA45B912D421D9CC4953D88A52A4", hash_generated_method = "AD540B4E8C4FD1CAD5CF6608CABE1F45")
    public void restartInput(IInputContext inputContext, EditorInfo attribute) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageOO(DO_RESTART_INPUT,
                inputContext, attribute));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.622 -0500", hash_original_method = "B4BFD5A332191A20B74FC4A001EBF3B5", hash_generated_method = "CFFCF1698991B6ABA85C503E5A055FBE")
    public void createSession(IInputMethodCallback callback) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_CREATE_SESSION, callback));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.623 -0500", hash_original_method = "BC36F335C1EF57BB31635290E9065CDE", hash_generated_method = "080FEAF7AE6E09556E9D0A8119045E20")
    public void setSessionEnabled(IInputMethodSession session, boolean enabled) {
        try {
            InputMethodSession ls = ((IInputMethodSessionWrapper)
                    session).getInternalInputMethodSession();
            mCaller.executeOrSendMessage(mCaller.obtainMessageIO(
                    DO_SET_SESSION_ENABLED, enabled ? 1 : 0, ls));
        } catch (ClassCastException e) {
            Log.w(TAG, "Incoming session not of correct type: " + session, e);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.624 -0500", hash_original_method = "6C5BDC012D2E841761539B06F63A9AED", hash_generated_method = "DA80B5FE06E396C31BD1F3B8292A9D32")
    public void revokeSession(IInputMethodSession session) {
        try {
            InputMethodSession ls = ((IInputMethodSessionWrapper)
                    session).getInternalInputMethodSession();
            mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_REVOKE_SESSION, ls));
        } catch (ClassCastException e) {
            Log.w(TAG, "Incoming session not of correct type: " + session, e);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.625 -0500", hash_original_method = "F249E378FF675201B27E0C333F1303AC", hash_generated_method = "CA6913734BF5911A79E843E0AF7238FE")
    public void showSoftInput(int flags, ResultReceiver resultReceiver) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageIO(DO_SHOW_SOFT_INPUT,
                flags, resultReceiver));
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.626 -0500", hash_original_method = "B180661AC63EF37C0C75DD9D2F92FEA1", hash_generated_method = "77EF37957BE0D06588F1C14923690FE1")
    public void hideSoftInput(int flags, ResultReceiver resultReceiver) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageIO(DO_HIDE_SOFT_INPUT,
                flags, resultReceiver));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:39.627 -0500", hash_original_method = "AC2D1B005425B264D93FFBD73CFFCA9B", hash_generated_method = "90ABA503A05FADA8B0AB4EEC4F8C0A28")
    public void changeInputMethodSubtype(InputMethodSubtype subtype) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_CHANGE_INPUTMETHOD_SUBTYPE,
                subtype));
    }
}

