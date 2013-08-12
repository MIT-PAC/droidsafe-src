package android.speech;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;





public class SpeechRecognizer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.216 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "C468B76F6B6018BB8DB9FFE2A162E10B")

    private IRecognitionService mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.216 -0400", hash_original_field = "8FB9CEDC14BF8DE9558825242E11E275", hash_generated_field = "619FD7E303013DFEE90F58DA7C3DCACD")

    private Connection mConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.216 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.216 -0400", hash_original_field = "F8B3B64B64DD35335B92F94192371F82", hash_generated_field = "5B21363DF964FEB7BA838821A96F73BB")

    private ComponentName mServiceComponent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.217 -0400", hash_original_field = "A27565A3284A0242865B513D7E4CBC2D", hash_generated_field = "B96380BDD6B3164FA8AF53BEBA06B375")

    private Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.217 -0400", hash_original_method = "4777936EA1BA55C44F90D09557AD57D4", hash_generated_method = "02B16A617D202B1503A60671643E28BB")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
switch(msg.what){
            case MSG_START:
            handleStartListening((Intent) msg.obj);
            break;
            case MSG_STOP:
            handleStopMessage();
            break;
            case MSG_CANCEL:
            handleCancelMessage();
            break;
            case MSG_CHANGE_LISTENER:
            handleChangeListener((RecognitionListener) msg.obj);
            break;
}
            // ---------- Original Method ----------
            //switch (msg.what) {
                //case MSG_START:
                    //handleStartListening((Intent) msg.obj);
                    //break;
                //case MSG_STOP:
                    //handleStopMessage();
                    //break;
                //case MSG_CANCEL:
                    //handleCancelMessage();
                    //break;
                //case MSG_CHANGE_LISTENER:
                    //handleChangeListener((RecognitionListener) msg.obj);
                    //break;
            //}
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.217 -0400", hash_original_field = "4C21C5FF5D4256D79C51CFF597A9DF76", hash_generated_field = "D14056CF3275CCA582D9C7C6EA3A3C33")

    private final Queue<Message> mPendingTasks = new LinkedList<Message>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.217 -0400", hash_original_field = "174707462315E6EDD68FE455F0DD2B4F", hash_generated_field = "68B460ACAB0D414A3EF628319B53A1E4")

    private final InternalListener mListener = new InternalListener();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.218 -0400", hash_original_method = "501952D87180FDD5A7C8687B64627639", hash_generated_method = "0467EC6C791C177B4C120C9E915154E8")
    private  SpeechRecognizer(final Context context, final ComponentName serviceComponent) {
        mContext = context;
        mServiceComponent = serviceComponent;
        // ---------- Original Method ----------
        //mContext = context;
        //mServiceComponent = serviceComponent;
    }

    
    public static boolean isRecognitionAvailable(final Context context) {
        final List<ResolveInfo> list = context.getPackageManager().queryIntentServices(
                new Intent(RecognitionService.SERVICE_INTERFACE), 0);
        return list != null && list.size() != 0;
    }

    
    public static SpeechRecognizer createSpeechRecognizer(final Context context) {
        return createSpeechRecognizer(context, null);
    }

    
    public static SpeechRecognizer createSpeechRecognizer(final Context context,
            final ComponentName serviceComponent) {
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null)");
        }
        checkIsCalledFromMainThread();
        return new SpeechRecognizer(context, serviceComponent);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.220 -0400", hash_original_method = "F27BB062A778ED5EBCB2B3B868E059E6", hash_generated_method = "E70E29B7E155AD2AA2823CB3C1C213AF")
    public void setRecognitionListener(RecognitionListener listener) {
        addTaint(listener.getTaint());
        checkIsCalledFromMainThread();
        putMessage(Message.obtain(mHandler, MSG_CHANGE_LISTENER, listener));
        // ---------- Original Method ----------
        //checkIsCalledFromMainThread();
        //putMessage(Message.obtain(mHandler, MSG_CHANGE_LISTENER, listener));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.221 -0400", hash_original_method = "88CA4DC9FEC4470B022FF2313B42E756", hash_generated_method = "03D10FDEEFF202187D07066E13B9CE55")
    public void startListening(final Intent recognizerIntent) {
        addTaint(recognizerIntent.getTaint());
        if(recognizerIntent == null)        
        {
            IllegalArgumentException var21E73D2FF142A80D13A72EB34DF276CD_676681438 = new IllegalArgumentException("intent must not be null");
            var21E73D2FF142A80D13A72EB34DF276CD_676681438.addTaint(taint);
            throw var21E73D2FF142A80D13A72EB34DF276CD_676681438;
        } //End block
        checkIsCalledFromMainThread();
        if(mConnection == null)        
        {
            mConnection = new Connection();
            Intent serviceIntent = new Intent(RecognitionService.SERVICE_INTERFACE);
            if(mServiceComponent == null)            
            {
                String serviceComponent = Settings.Secure.getString(mContext.getContentResolver(),
                        Settings.Secure.VOICE_RECOGNITION_SERVICE);
                if(TextUtils.isEmpty(serviceComponent))                
                {
                    mListener.onError(ERROR_CLIENT);
                    return;
                } //End block
                serviceIntent.setComponent(ComponentName.unflattenFromString(serviceComponent));
            } //End block
            else
            {
                serviceIntent.setComponent(mServiceComponent);
            } //End block
            if(!mContext.bindService(serviceIntent, mConnection, Context.BIND_AUTO_CREATE))            
            {
                mConnection = null;
                mService = null;
                mListener.onError(ERROR_CLIENT);
                return;
            } //End block
        } //End block
        putMessage(Message.obtain(mHandler, MSG_START, recognizerIntent));
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.222 -0400", hash_original_method = "A8390EFF2DA1FBF4056A47F4A80E1574", hash_generated_method = "86ABC8C869016D540049C9BB479FE5C4")
    public void stopListening() {
        checkIsCalledFromMainThread();
        putMessage(Message.obtain(mHandler, MSG_STOP));
        // ---------- Original Method ----------
        //checkIsCalledFromMainThread();
        //putMessage(Message.obtain(mHandler, MSG_STOP));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.223 -0400", hash_original_method = "10AA7C6E429E5CC79EFBF134B39CD4DB", hash_generated_method = "8E4782DC5673E8AFB7EA3829DBEBA064")
    public void cancel() {
        checkIsCalledFromMainThread();
        putMessage(Message.obtain(mHandler, MSG_CANCEL));
        // ---------- Original Method ----------
        //checkIsCalledFromMainThread();
        //putMessage(Message.obtain(mHandler, MSG_CANCEL));
    }

    
    @DSModeled(DSC.BAN)
    private static void checkIsCalledFromMainThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new RuntimeException(
                    "SpeechRecognizer should be used only from the application's main thread");
        }
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.224 -0400", hash_original_method = "BD5701E8DF0BF25E7CB3736533848F1A", hash_generated_method = "A5A5569C94AE4A1C397AFB5586BE1123")
    private void putMessage(Message msg) {
        addTaint(msg.getTaint());
        if(mService == null)        
        {
            mPendingTasks.offer(msg);
        } //End block
        else
        {
            mHandler.sendMessage(msg);
        } //End block
        // ---------- Original Method ----------
        //if (mService == null) {
            //mPendingTasks.offer(msg);
        //} else {
            //mHandler.sendMessage(msg);
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.225 -0400", hash_original_method = "02FE733144FE02DDB0F8182E4A142CB0", hash_generated_method = "FF63DA8C334E4FB067088B55607641B1")
    private void handleStartListening(Intent recognizerIntent) {
        addTaint(recognizerIntent.getTaint());
        if(!checkOpenConnection())        
        {
            return;
        } //End block
        try 
        {
            mService.startListening(recognizerIntent, mListener);
            if(DBG)            
            Log.d(TAG, "service start listening command succeded");
        } //End block
        catch (final RemoteException e)
        {
            mListener.onError(ERROR_CLIENT);
        } //End block
        // ---------- Original Method ----------
        //if (!checkOpenConnection()) {
            //return;
        //}
        //try {
            //mService.startListening(recognizerIntent, mListener);
            //if (DBG) Log.d(TAG, "service start listening command succeded");
        //} catch (final RemoteException e) {
            //Log.e(TAG, "startListening() failed", e);
            //mListener.onError(ERROR_CLIENT);
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.225 -0400", hash_original_method = "B90CA3721E1A91D945B72975FC03EB82", hash_generated_method = "868DDBE8C65BCA2AD55F5E98FB3717E1")
    private void handleStopMessage() {
        if(!checkOpenConnection())        
        {
            return;
        } //End block
        try 
        {
            mService.stopListening(mListener);
            if(DBG)            
            Log.d(TAG, "service stop listening command succeded");
        } //End block
        catch (final RemoteException e)
        {
            mListener.onError(ERROR_CLIENT);
        } //End block
        // ---------- Original Method ----------
        //if (!checkOpenConnection()) {
            //return;
        //}
        //try {
            //mService.stopListening(mListener);
            //if (DBG) Log.d(TAG, "service stop listening command succeded");
        //} catch (final RemoteException e) {
            //Log.e(TAG, "stopListening() failed", e);
            //mListener.onError(ERROR_CLIENT);
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.226 -0400", hash_original_method = "5E81A38D35A2865AC1654F506B5D7265", hash_generated_method = "BB5BF4B051B1FF448EF63E92CA1AB6C1")
    private void handleCancelMessage() {
        if(!checkOpenConnection())        
        {
            return;
        } //End block
        try 
        {
            mService.cancel(mListener);
            if(DBG)            
            Log.d(TAG, "service cancel command succeded");
        } //End block
        catch (final RemoteException e)
        {
            mListener.onError(ERROR_CLIENT);
        } //End block
        // ---------- Original Method ----------
        //if (!checkOpenConnection()) {
            //return;
        //}
        //try {
            //mService.cancel(mListener);
            //if (DBG) Log.d(TAG, "service cancel command succeded");
        //} catch (final RemoteException e) {
            //Log.e(TAG, "cancel() failed", e);
            //mListener.onError(ERROR_CLIENT);
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.226 -0400", hash_original_method = "325935BA5701514064BC283979E7156C", hash_generated_method = "CA159233609EA7D659E78FFB28ACFA6D")
    private boolean checkOpenConnection() {
        if(mService != null)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_111578566 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1633329349 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1633329349;
        } //End block
        mListener.onError(ERROR_CLIENT);
        boolean var68934A3E9455FA72420237EB05902327_345920945 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1324919113 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1324919113;
        // ---------- Original Method ----------
        //if (mService != null) {
            //return true;
        //}
        //mListener.onError(ERROR_CLIENT);
        //Log.e(TAG, "not connected to the recognition service");
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.227 -0400", hash_original_method = "90AD91808DE7CDCDA112C3C449526B0F", hash_generated_method = "8D108356CEA86C34ABEC68C8CEE863E5")
    private void handleChangeListener(RecognitionListener listener) {
        if(DBG)        
        Log.d(TAG, "handleChangeListener, listener=" + listener);
        mListener.mInternalListener = listener;
        // ---------- Original Method ----------
        //if (DBG) Log.d(TAG, "handleChangeListener, listener=" + listener);
        //mListener.mInternalListener = listener;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.228 -0400", hash_original_method = "B539A3FDAD7DAFC2710B42A201C294A5", hash_generated_method = "DC94C10E74AC8EABFF4D6BA6CA2867D1")
    public void destroy() {
        if(mConnection != null)        
        {
            mContext.unbindService(mConnection);
        } //End block
        mPendingTasks.clear();
        mService = null;
        mConnection = null;
        mListener.mInternalListener = null;
        // ---------- Original Method ----------
        //if (mConnection != null) {
            //mContext.unbindService(mConnection);
        //}
        //mPendingTasks.clear();
        //mService = null;
        //mConnection = null;
        //mListener.mInternalListener = null;
    }

    
    private class Connection implements ServiceConnection {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.228 -0400", hash_original_method = "4879E6D30CC79D00A25F9B445CF68B6E", hash_generated_method = "4879E6D30CC79D00A25F9B445CF68B6E")
        public Connection ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.229 -0400", hash_original_method = "A482946B66588C02F73749F3E3304B88", hash_generated_method = "5E4548CB5E969C50AAE15E6C04B39ECD")
        public void onServiceConnected(final ComponentName name, final IBinder service) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(service.getTaint());
            addTaint(name.getTaint());
            mService = IRecognitionService.Stub.asInterface(service);
            if(DBG)            
            Log.d(TAG, "onServiceConnected - Success");
            while
(!mPendingTasks.isEmpty())            
            {
                mHandler.sendMessage(mPendingTasks.poll());
            } //End block
            // ---------- Original Method ----------
            //mService = IRecognitionService.Stub.asInterface(service);
            //if (DBG) Log.d(TAG, "onServiceConnected - Success");
            //while (!mPendingTasks.isEmpty()) {
                //mHandler.sendMessage(mPendingTasks.poll());
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.230 -0400", hash_original_method = "C567EEB0F8B99E207D7273B6531D37A6", hash_generated_method = "061E2D9F4054FAFE762FBD30FE305D63")
        public void onServiceDisconnected(final ComponentName name) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(name.getTaint());
            mService = null;
            mConnection = null;
            mPendingTasks.clear();
            if(DBG)            
            Log.d(TAG, "onServiceDisconnected - Success");
            // ---------- Original Method ----------
            //mService = null;
            //mConnection = null;
            //mPendingTasks.clear();
            //if (DBG) Log.d(TAG, "onServiceDisconnected - Success");
        }

        
    }


    
    private class InternalListener extends IRecognitionListener.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.230 -0400", hash_original_field = "86570ADBC3157007B47DF3D9431125CE", hash_generated_field = "32C25CEE636EE2D27BF0A0BB77112DDD")

        private RecognitionListener mInternalListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.231 -0400", hash_original_field = "3E97CA0845357386ACA7B60ED6A59B83", hash_generated_field = "975920C3BABDF4247819CC8A88C87909")

        private final Handler mInternalHandler = new Handler() {            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.231 -0400", hash_original_method = "719D3C46325B87A1A9440CA0A4F7745E", hash_generated_method = "D4BAC621DAE131CEEBE025F02B08B36B")
            @Override
            public void handleMessage(Message msg) {
                addTaint(msg.getTaint());
                if(mInternalListener == null)                
                {
                    return;
                } //End block
switch(msg.what){
                case MSG_BEGINNING_OF_SPEECH:
                mInternalListener.onBeginningOfSpeech();
                break;
                case MSG_BUFFER_RECEIVED:
                mInternalListener.onBufferReceived((byte[]) msg.obj);
                break;
                case MSG_END_OF_SPEECH:
                mInternalListener.onEndOfSpeech();
                break;
                case MSG_ERROR:
                mInternalListener.onError((Integer) msg.obj);
                break;
                case MSG_READY_FOR_SPEECH:
                mInternalListener.onReadyForSpeech((Bundle) msg.obj);
                break;
                case MSG_RESULTS:
                mInternalListener.onResults((Bundle) msg.obj);
                break;
                case MSG_PARTIAL_RESULTS:
                mInternalListener.onPartialResults((Bundle) msg.obj);
                break;
                case MSG_RMS_CHANGED:
                mInternalListener.onRmsChanged((Float) msg.obj);
                break;
                case MSG_ON_EVENT:
                mInternalListener.onEvent(msg.arg1, (Bundle) msg.obj);
                break;
}
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
};
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.231 -0400", hash_original_method = "D42AE1ED85DAFEE14D68B1100A6F596C", hash_generated_method = "D42AE1ED85DAFEE14D68B1100A6F596C")
        public InternalListener ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.232 -0400", hash_original_method = "423C75D37126FCE97656F1DAA5EC9589", hash_generated_method = "4E86798820D6846FF74D13277248EEBA")
        public void onBeginningOfSpeech() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            Message.obtain(mInternalHandler, MSG_BEGINNING_OF_SPEECH).sendToTarget();
            // ---------- Original Method ----------
            //Message.obtain(mInternalHandler, MSG_BEGINNING_OF_SPEECH).sendToTarget();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.232 -0400", hash_original_method = "440BB1FF5EAB849BC7B5A9B2BDE64DB2", hash_generated_method = "CAC8DBC23909E24C9C3D7347DE9B28C2")
        public void onBufferReceived(final byte[] buffer) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(buffer[0]);
            Message.obtain(mInternalHandler, MSG_BUFFER_RECEIVED, buffer).sendToTarget();
            // ---------- Original Method ----------
            //Message.obtain(mInternalHandler, MSG_BUFFER_RECEIVED, buffer).sendToTarget();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.232 -0400", hash_original_method = "78B5B45C0B4077521FF630307A7DFD84", hash_generated_method = "84E18819D7026D401E26F94C624E3D33")
        public void onEndOfSpeech() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            Message.obtain(mInternalHandler, MSG_END_OF_SPEECH).sendToTarget();
            // ---------- Original Method ----------
            //Message.obtain(mInternalHandler, MSG_END_OF_SPEECH).sendToTarget();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.232 -0400", hash_original_method = "CDA9EADD6A32A4BE8DEC4FA3CB4F1C0E", hash_generated_method = "7E3EFA2370ECDD3C0D12CF75AEAEC351")
        public void onError(final int error) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(error);
            Message.obtain(mInternalHandler, MSG_ERROR, error).sendToTarget();
            // ---------- Original Method ----------
            //Message.obtain(mInternalHandler, MSG_ERROR, error).sendToTarget();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.233 -0400", hash_original_method = "0C389EBFAF23D698D1F945955A407FE0", hash_generated_method = "BFFDD63DE77D7E66C6A0F4EAF116A3B8")
        public void onReadyForSpeech(final Bundle noiseParams) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(noiseParams.getTaint());
            Message.obtain(mInternalHandler, MSG_READY_FOR_SPEECH, noiseParams).sendToTarget();
            // ---------- Original Method ----------
            //Message.obtain(mInternalHandler, MSG_READY_FOR_SPEECH, noiseParams).sendToTarget();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.233 -0400", hash_original_method = "8043547C41CBEFDF0358507EB3CBC735", hash_generated_method = "2176066BE06B7031A59079C9030164EA")
        public void onResults(final Bundle results) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(results.getTaint());
            Message.obtain(mInternalHandler, MSG_RESULTS, results).sendToTarget();
            // ---------- Original Method ----------
            //Message.obtain(mInternalHandler, MSG_RESULTS, results).sendToTarget();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.233 -0400", hash_original_method = "C5DE23D2E0A0C48DF7B3AD991D3BAED9", hash_generated_method = "9380C1C213AB590DD959020027F97D2A")
        public void onPartialResults(final Bundle results) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(results.getTaint());
            Message.obtain(mInternalHandler, MSG_PARTIAL_RESULTS, results).sendToTarget();
            // ---------- Original Method ----------
            //Message.obtain(mInternalHandler, MSG_PARTIAL_RESULTS, results).sendToTarget();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.234 -0400", hash_original_method = "43DC9B01076C33DA1437F3B2E9FFAD9F", hash_generated_method = "06129008681238DFAD89813EA6863554")
        public void onRmsChanged(final float rmsdB) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(rmsdB);
            Message.obtain(mInternalHandler, MSG_RMS_CHANGED, rmsdB).sendToTarget();
            // ---------- Original Method ----------
            //Message.obtain(mInternalHandler, MSG_RMS_CHANGED, rmsdB).sendToTarget();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.234 -0400", hash_original_method = "F710C1EACA55C27505200F22B187965E", hash_generated_method = "A4B041F745134671AA3A71DC35FA4C5E")
        public void onEvent(final int eventType, final Bundle params) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(params.getTaint());
            addTaint(eventType);
            Message.obtain(mInternalHandler, MSG_ON_EVENT, eventType, eventType, params)
                    .sendToTarget();
            // ---------- Original Method ----------
            //Message.obtain(mInternalHandler, MSG_ON_EVENT, eventType, eventType, params)
                    //.sendToTarget();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.234 -0400", hash_original_field = "13E4C43E84EC5A4BC5BE51E0F4E924D0", hash_generated_field = "032590BC15DCDDF98F63DDEB5918C116")

        private final static int MSG_BEGINNING_OF_SPEECH = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.234 -0400", hash_original_field = "D37EA5FD4A45E04DA2FEE46D1AB438B1", hash_generated_field = "709FAE9C1F800DF37CB07F4272287D9D")

        private final static int MSG_BUFFER_RECEIVED = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.234 -0400", hash_original_field = "8FCBF1A699FF31C9EE684C4C083DD6B9", hash_generated_field = "2CE501F098292CAAEB3D265FD968750A")

        private final static int MSG_END_OF_SPEECH = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.234 -0400", hash_original_field = "9BA8B165D312FC4777C10CC5964B2142", hash_generated_field = "5DC9886CD96061DA6FED0E59780AD0B4")

        private final static int MSG_ERROR = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.234 -0400", hash_original_field = "AEBE77A7A74C04069CE5E3A49FF3D8E0", hash_generated_field = "21AC69D45FBA2C837407D4551BE782D0")

        private final static int MSG_READY_FOR_SPEECH = 5;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.235 -0400", hash_original_field = "C4F1582DCF51AED8003319DFB940A026", hash_generated_field = "A2FD20EB3B0FFB93AC5F1E353893AE9B")

        private final static int MSG_RESULTS = 6;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.235 -0400", hash_original_field = "EAACF358B56926DCFF5B60BCCAA83075", hash_generated_field = "DDBBD66CB424E3EE05E7A98160AD883C")

        private final static int MSG_PARTIAL_RESULTS = 7;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.235 -0400", hash_original_field = "0971F8332E1FEE077477891B8C839A3F", hash_generated_field = "1A6222FF5BB621239521DD6D26F8D914")

        private final static int MSG_RMS_CHANGED = 8;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.235 -0400", hash_original_field = "896069F61C63D64E02050F4C4652945D", hash_generated_field = "92FD692A6E74F1C123F33755B1D3F204")

        private final static int MSG_ON_EVENT = 9;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.235 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "02194E90B9C57CE96E61D6E56AAE84CD")

    private final static boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.235 -0400", hash_original_field = "76442D4C2FDA52260591B27D0E4BB3DB", hash_generated_field = "0502D3AAAE2DD0B653A18C7ABFC8628A")

    private static final String TAG = "SpeechRecognizer";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.235 -0400", hash_original_field = "701EB6E67C426CD81EC59AC533357C6B", hash_generated_field = "5F051495F27CE714948F0217A0217566")

    public static final String RESULTS_RECOGNITION = "results_recognition";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.235 -0400", hash_original_field = "E3DA0350D3B354176891F12976774862", hash_generated_field = "024181ED96031916AA00F4C4BD4C6EC7")

    public static final String CONFIDENCE_SCORES = "confidence_scores";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.235 -0400", hash_original_field = "D202B3CAA48AC8E5B72C09F17478F1DA", hash_generated_field = "203CD1453A5C325F6860BB2E2A36DB63")

    public static final int ERROR_NETWORK_TIMEOUT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.235 -0400", hash_original_field = "A2B83C581136E1D34B12BA8CBC1A21CD", hash_generated_field = "DF8888F14A1C05BB6BC513DB4B14C93C")

    public static final int ERROR_NETWORK = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.235 -0400", hash_original_field = "B865CC89617F1E571E74F9A4DDCA50EC", hash_generated_field = "4DF6ABE165AD7E485BB894E542E84662")

    public static final int ERROR_AUDIO = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.235 -0400", hash_original_field = "C2AC56EB9B9C8EAAEA83AFB26767A94A", hash_generated_field = "6FE4E57BFC1099518EBF9E12B361A645")

    public static final int ERROR_SERVER = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.235 -0400", hash_original_field = "B3BFE665B5EC6E81AF843B7539F1EFCF", hash_generated_field = "10C3B179A8944D0F8AFEC2B1B1C9B9CE")

    public static final int ERROR_CLIENT = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.235 -0400", hash_original_field = "02DC12072A3CFC1E0553F2E1998C74FA", hash_generated_field = "4D95D46AAEF2A5A87D764F20F6FC953A")

    public static final int ERROR_SPEECH_TIMEOUT = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.235 -0400", hash_original_field = "91D6AC9370AE0FAA116CEB7927CF34EE", hash_generated_field = "F998F84959C8722DB9B88BD19FCBF22C")

    public static final int ERROR_NO_MATCH = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.235 -0400", hash_original_field = "62145E0172479F9AED307B905DC81184", hash_generated_field = "0A905B1E038EB5629B06949C30A88D5A")

    public static final int ERROR_RECOGNIZER_BUSY = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.235 -0400", hash_original_field = "A636FE08E26BBB857C2D5B24D0D92F5E", hash_generated_field = "148970C046575C38FDA7890EED50A49D")

    public static final int ERROR_INSUFFICIENT_PERMISSIONS = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.236 -0400", hash_original_field = "735EEFB239C2995E71D8FC9444AF46C6", hash_generated_field = "7FA013DB543937BCB2F4B2DF009BD66D")

    private final static int MSG_START = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.236 -0400", hash_original_field = "996C343FE139C3721301CD65863D5D3F", hash_generated_field = "038D7E8241C94CDC00582E15673A662F")

    private final static int MSG_STOP = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.236 -0400", hash_original_field = "5DD1FEF98B682C946D8CE071A0CFC313", hash_generated_field = "16B28850E80CAB5749BEBCDC7A08E7E4")

    private final static int MSG_CANCEL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.236 -0400", hash_original_field = "89377DFD22571D5F1C0422C17D5CC247", hash_generated_field = "8B6D8613AD13FF60F51B39D6B0AE54C4")

    private final static int MSG_CHANGE_LISTENER = 4;
}

