package android.speech;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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

    /**
     * Checks whether a speech recognition service is available on the system. If this method
     * returns {@code false}, {@link SpeechRecognizer#createSpeechRecognizer(Context)} will
     * fail.
     * 
     * @param context with which {@code SpeechRecognizer} will be created
     * @return {@code true} if recognition is available, {@code false} otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.153 -0500", hash_original_method = "AA97899394CDEEDA461519386DBB0A30", hash_generated_method = "C174BF5DEA87B43385B81F8BB9640164")
    public static boolean isRecognitionAvailable(final Context context) {
        final List<ResolveInfo> list = context.getPackageManager().queryIntentServices(
                new Intent(RecognitionService.SERVICE_INTERFACE), 0);
        return list != null && list.size() != 0;
    }

    /**
     * Factory method to create a new {@code SpeechRecognizer}. Please note that
     * {@link #setRecognitionListener(RecognitionListener)} should be called before dispatching any
     * command to the created {@code SpeechRecognizer}, otherwise no notifications will be
     * received.
     *
     * @param context in which to create {@code SpeechRecognizer}
     * @return a new {@code SpeechRecognizer}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.154 -0500", hash_original_method = "B7A591CA1794361E15FF474335C28EFA", hash_generated_method = "907277B5B93EE3956083A3D3BBB835A5")
    public static SpeechRecognizer createSpeechRecognizer(final Context context) {
        return createSpeechRecognizer(context, null);
    }

    /**
     * Factory method to create a new {@code SpeechRecognizer}. Please note that
     * {@link #setRecognitionListener(RecognitionListener)} should be called before dispatching any
     * command to the created {@code SpeechRecognizer}, otherwise no notifications will be
     * received.
     *
     * Use this version of the method to specify a specific service to direct this
     * {@link SpeechRecognizer} to. Normally you would not use this; use
     * {@link #createSpeechRecognizer(Context)} instead to use the system default recognition
     * service.
     * 
     * @param context in which to create {@code SpeechRecognizer}
     * @param serviceComponent the {@link ComponentName} of a specific service to direct this
     *        {@code SpeechRecognizer} to
     * @return a new {@code SpeechRecognizer}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.155 -0500", hash_original_method = "0D45A7E4D1A50CEF8A1018DBBB0F906C", hash_generated_method = "634A54030B2B4642E249F24FB9B5BC60")
    public static SpeechRecognizer createSpeechRecognizer(final Context context,
            final ComponentName serviceComponent) {
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null)");
        }
        checkIsCalledFromMainThread();
        return new SpeechRecognizer(context, serviceComponent);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.159 -0500", hash_original_method = "8ACB0B782F8B0E663914EF38630E6A9F", hash_generated_method = "FB04730051FB4D0DC1B612BBA4B5B162")
    private static void checkIsCalledFromMainThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new RuntimeException(
                    "SpeechRecognizer should be used only from the application's main thread");
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.128 -0500", hash_original_field = "B2601CA7445F6BA19FA7884763D82281", hash_generated_field = "02194E90B9C57CE96E61D6E56AAE84CD")

    private final static boolean DBG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.129 -0500", hash_original_field = "411C0256FAD249E9E717582BB003141F", hash_generated_field = "0502D3AAAE2DD0B653A18C7ABFC8628A")

    private static final String TAG = "SpeechRecognizer";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.130 -0500", hash_original_field = "9DADE4CD17B3EE74D30D11C671149DB4", hash_generated_field = "5F051495F27CE714948F0217A0217566")

    public static final String RESULTS_RECOGNITION = "results_recognition";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.131 -0500", hash_original_field = "FB0B71834764B2AE1C22DF852829F089", hash_generated_field = "024181ED96031916AA00F4C4BD4C6EC7")

    public static final String CONFIDENCE_SCORES = "confidence_scores";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.132 -0500", hash_original_field = "7AA011BF0B716AFC0EB9F298B4A92C44", hash_generated_field = "203CD1453A5C325F6860BB2E2A36DB63")

    public static final int ERROR_NETWORK_TIMEOUT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.133 -0500", hash_original_field = "C7E56E256B3C2273A73F1743C6E0A574", hash_generated_field = "DF8888F14A1C05BB6BC513DB4B14C93C")

    public static final int ERROR_NETWORK = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.133 -0500", hash_original_field = "7828794F0ED2A99A245CC01B4820C3BA", hash_generated_field = "4DF6ABE165AD7E485BB894E542E84662")

    public static final int ERROR_AUDIO = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.134 -0500", hash_original_field = "9191A07F1491A10002982D40326CC737", hash_generated_field = "6FE4E57BFC1099518EBF9E12B361A645")

    public static final int ERROR_SERVER = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.135 -0500", hash_original_field = "605B08C4F43FB836A05DB1E2C35786C2", hash_generated_field = "10C3B179A8944D0F8AFEC2B1B1C9B9CE")

    public static final int ERROR_CLIENT = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.136 -0500", hash_original_field = "6A94247F7EAFE1BA21C0FD561AF974D2", hash_generated_field = "4D95D46AAEF2A5A87D764F20F6FC953A")

    public static final int ERROR_SPEECH_TIMEOUT = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.137 -0500", hash_original_field = "AA27032A20044FF4708E39D0A4726167", hash_generated_field = "F998F84959C8722DB9B88BD19FCBF22C")

    public static final int ERROR_NO_MATCH = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.138 -0500", hash_original_field = "30A25DC660C7A0C3FDEE53E21B01D14E", hash_generated_field = "0A905B1E038EB5629B06949C30A88D5A")

    public static final int ERROR_RECOGNIZER_BUSY = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.139 -0500", hash_original_field = "95E058BE4C07CCC7971B8A9277E8C159", hash_generated_field = "148970C046575C38FDA7890EED50A49D")

    public static final int ERROR_INSUFFICIENT_PERMISSIONS = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.139 -0500", hash_original_field = "9F9E3DE6F4BA368CF437EA798C3D2B94", hash_generated_field = "7FA013DB543937BCB2F4B2DF009BD66D")

    private final static int MSG_START = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.140 -0500", hash_original_field = "3CD474B45B9E920A9C1660454D5567D4", hash_generated_field = "038D7E8241C94CDC00582E15673A662F")

    private final static int MSG_STOP = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.141 -0500", hash_original_field = "5C262FE568A8ECA39C2067D11EBA5D23", hash_generated_field = "16B28850E80CAB5749BEBCDC7A08E7E4")

    private final static int MSG_CANCEL = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.142 -0500", hash_original_field = "964C14B4247577B69E0423FB700C14EA", hash_generated_field = "8B6D8613AD13FF60F51B39D6B0AE54C4")

    private final static int MSG_CHANGE_LISTENER = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.143 -0500", hash_original_field = "BD46F50608D93B9A3ED870A2808558C0", hash_generated_field = "C468B76F6B6018BB8DB9FFE2A162E10B")

    private IRecognitionService mService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.144 -0500", hash_original_field = "D468AD0EA1184CE89FA8A45254E2CDD6", hash_generated_field = "619FD7E303013DFEE90F58DA7C3DCACD")

    private Connection mConnection;

    
    private class Connection implements ServiceConnection {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.228 -0400", hash_original_method = "4879E6D30CC79D00A25F9B445CF68B6E", hash_generated_method = "4879E6D30CC79D00A25F9B445CF68B6E")
        public Connection ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.151 -0500", hash_original_method = "A482946B66588C02F73749F3E3304B88", hash_generated_method = "05CB012FD285D5415E62C654ADB06C2D")
        public void onServiceConnected(final ComponentName name, final IBinder service) {
            // always done on the application main thread, so no need to send message to mHandler
            mService = IRecognitionService.Stub.asInterface(service);
            if (DBG) Log.d(TAG, "onServiceConnected - Success");
            while (!mPendingTasks.isEmpty()) {
                mHandler.sendMessage(mPendingTasks.poll());
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.152 -0500", hash_original_method = "C567EEB0F8B99E207D7273B6531D37A6", hash_generated_method = "11350C1E55EA4F22CCEF5758710E3E4E")
        public void onServiceDisconnected(final ComponentName name) {
            // always done on the application main thread, so no need to send message to mHandler
            mService = null;
            mConnection = null;
            mPendingTasks.clear();
            if (DBG) Log.d(TAG, "onServiceDisconnected - Success");
        }

        
    }


    
    private class InternalListener extends IRecognitionListener.Stub {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.167 -0500", hash_original_field = "0CE94EF9B286F194AC25B36B8EA3F00B", hash_generated_field = "032590BC15DCDDF98F63DDEB5918C116")


        private final static int MSG_BEGINNING_OF_SPEECH = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.168 -0500", hash_original_field = "C899B06BA48C740C11DFD1FF7158CD76", hash_generated_field = "709FAE9C1F800DF37CB07F4272287D9D")

        private final static int MSG_BUFFER_RECEIVED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.169 -0500", hash_original_field = "46E045A25219BD879807EA8D692D701A", hash_generated_field = "2CE501F098292CAAEB3D265FD968750A")

        private final static int MSG_END_OF_SPEECH = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.170 -0500", hash_original_field = "19525D3D6653B367D24CDAF4F181CEE6", hash_generated_field = "5DC9886CD96061DA6FED0E59780AD0B4")

        private final static int MSG_ERROR = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.172 -0500", hash_original_field = "064583B4C986F178F9D8077CB1E952E0", hash_generated_field = "21AC69D45FBA2C837407D4551BE782D0")

        private final static int MSG_READY_FOR_SPEECH = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.172 -0500", hash_original_field = "87109F44044C5E4B47FAA7427A5423F4", hash_generated_field = "A2FD20EB3B0FFB93AC5F1E353893AE9B")

        private final static int MSG_RESULTS = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.173 -0500", hash_original_field = "BB44045969FA754848D7F1B89980D90F", hash_generated_field = "DDBBD66CB424E3EE05E7A98160AD883C")

        private final static int MSG_PARTIAL_RESULTS = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.174 -0500", hash_original_field = "986FD376F14C7518E374C6C4849F7CAC", hash_generated_field = "1A6222FF5BB621239521DD6D26F8D914")

        private final static int MSG_RMS_CHANGED = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.175 -0500", hash_original_field = "73D5E85634F6A5C536C912364E2EA1FC", hash_generated_field = "92FD692A6E74F1C123F33755B1D3F204")

        private final static int MSG_ON_EVENT = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.166 -0500", hash_original_field = "47F91EEEAE71291E00693A350F3BD4E3", hash_generated_field = "32C25CEE636EE2D27BF0A0BB77112DDD")

        private RecognitionListener mInternalListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.231 -0400", hash_original_field = "3E97CA0845357386ACA7B60ED6A59B83", hash_generated_field = "975920C3BABDF4247819CC8A88C87909")

        private final Handler mInternalHandler = new Handler() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.177 -0500", hash_original_method = "719D3C46325B87A1A9440CA0A4F7745E", hash_generated_method = "0297B88C17A45A8B5DEBBF61EEBF851E")
            @Override
public void handleMessage(Message msg) {
                if (mInternalListener == null) {
                    return;
                }
                switch (msg.what) {
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
            }

            
};
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.231 -0400", hash_original_method = "D42AE1ED85DAFEE14D68B1100A6F596C", hash_generated_method = "D42AE1ED85DAFEE14D68B1100A6F596C")
        public InternalListener ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.178 -0500", hash_original_method = "423C75D37126FCE97656F1DAA5EC9589", hash_generated_method = "7AF1F1B8CC575D9EF1C46E0979E8486C")
        public void onBeginningOfSpeech() {
            Message.obtain(mInternalHandler, MSG_BEGINNING_OF_SPEECH).sendToTarget();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.179 -0500", hash_original_method = "440BB1FF5EAB849BC7B5A9B2BDE64DB2", hash_generated_method = "4DA7B39DA777B77CFDED61E882B63839")
        public void onBufferReceived(final byte[] buffer) {
            Message.obtain(mInternalHandler, MSG_BUFFER_RECEIVED, buffer).sendToTarget();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.180 -0500", hash_original_method = "78B5B45C0B4077521FF630307A7DFD84", hash_generated_method = "EBA45639D4D3F1719A7B67EDC8922A2A")
        public void onEndOfSpeech() {
            Message.obtain(mInternalHandler, MSG_END_OF_SPEECH).sendToTarget();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.181 -0500", hash_original_method = "CDA9EADD6A32A4BE8DEC4FA3CB4F1C0E", hash_generated_method = "C5B2C827EA6F675EE3636184A411BAEC")
        public void onError(final int error) {
            Message.obtain(mInternalHandler, MSG_ERROR, error).sendToTarget();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.182 -0500", hash_original_method = "0C389EBFAF23D698D1F945955A407FE0", hash_generated_method = "E9C4133066D4D0681FE2AD417A5A6621")
        public void onReadyForSpeech(final Bundle noiseParams) {
            Message.obtain(mInternalHandler, MSG_READY_FOR_SPEECH, noiseParams).sendToTarget();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.182 -0500", hash_original_method = "8043547C41CBEFDF0358507EB3CBC735", hash_generated_method = "61B106F617378DA7858FF951717E5CBB")
        public void onResults(final Bundle results) {
            Message.obtain(mInternalHandler, MSG_RESULTS, results).sendToTarget();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.183 -0500", hash_original_method = "C5DE23D2E0A0C48DF7B3AD991D3BAED9", hash_generated_method = "052B83F1809B2FFE143828E8BCE3F354")
        public void onPartialResults(final Bundle results) {
            Message.obtain(mInternalHandler, MSG_PARTIAL_RESULTS, results).sendToTarget();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.184 -0500", hash_original_method = "43DC9B01076C33DA1437F3B2E9FFAD9F", hash_generated_method = "125F960E650E0C94EC7939DD7225FC54")
        public void onRmsChanged(final float rmsdB) {
            Message.obtain(mInternalHandler, MSG_RMS_CHANGED, rmsdB).sendToTarget();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.185 -0500", hash_original_method = "F710C1EACA55C27505200F22B187965E", hash_generated_method = "2E9359C458FA95F9F9227BB177180EF8")
        public void onEvent(final int eventType, final Bundle params) {
            Message.obtain(mInternalHandler, MSG_ON_EVENT, eventType, eventType, params)
                    .sendToTarget();
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.144 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.145 -0500", hash_original_field = "6A4B8E4F22E0A918725BE7C9808EAF38", hash_generated_field = "5B21363DF964FEB7BA838821A96F73BB")

    private  ComponentName mServiceComponent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.217 -0400", hash_original_field = "A27565A3284A0242865B513D7E4CBC2D", hash_generated_field = "B96380BDD6B3164FA8AF53BEBA06B375")

    private Handler mHandler = new Handler() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.146 -0500", hash_original_method = "4777936EA1BA55C44F90D09557AD57D4", hash_generated_method = "276058466110B4DCB6EE912E97266BAD")
        @Override
public void handleMessage(Message msg) {
            switch (msg.what) {
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
        }

        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.148 -0500", hash_original_field = "E954EEFB23BAEBF8F27439147A5EB1D5", hash_generated_field = "D14056CF3275CCA582D9C7C6EA3A3C33")

    private final Queue<Message> mPendingTasks = new LinkedList<Message>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.149 -0500", hash_original_field = "BF34C177CB9957428D7734FFFC322993", hash_generated_field = "68B460ACAB0D414A3EF628319B53A1E4")

    private final InternalListener mListener = new InternalListener();

    /**
     * The right way to create a {@code SpeechRecognizer} is by using
     * {@link #createSpeechRecognizer} static factory method
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.150 -0500", hash_original_method = "501952D87180FDD5A7C8687B64627639", hash_generated_method = "B6891D4DDB9D981F81748F5DFDB43833")
    private SpeechRecognizer(final Context context, final ComponentName serviceComponent) {
        mContext = context;
        mServiceComponent = serviceComponent;
    }

    /**
     * Sets the listener that will receive all the callbacks. The previous unfinished commands will
     * be executed with the old listener, while any following command will be executed with the new
     * listener.
     * 
     * @param listener listener that will receive all the callbacks from the created
     *        {@link SpeechRecognizer}, this must not be null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.156 -0500", hash_original_method = "F27BB062A778ED5EBCB2B3B868E059E6", hash_generated_method = "51B58CFA8B31AC91F1DF1953A495C0C7")
    public void setRecognitionListener(RecognitionListener listener) {
        checkIsCalledFromMainThread();
        putMessage(Message.obtain(mHandler, MSG_CHANGE_LISTENER, listener));
    }

    /**
     * Starts listening for speech. Please note that
     * {@link #setRecognitionListener(RecognitionListener)} should be called beforehand, otherwise
     * no notifications will be received.
     *
     * @param recognizerIntent contains parameters for the recognition to be performed. The intent
     *        may also contain optional extras, see {@link RecognizerIntent}. If these values are
     *        not set explicitly, default values will be used by the recognizer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.157 -0500", hash_original_method = "88CA4DC9FEC4470B022FF2313B42E756", hash_generated_method = "80D4DF42D96F9F49F22D2007A528449E")
    public void startListening(final Intent recognizerIntent) {
        if (recognizerIntent == null) {
            throw new IllegalArgumentException("intent must not be null");
        }
        checkIsCalledFromMainThread();
        if (mConnection == null) { // first time connection
            mConnection = new Connection();
            
            Intent serviceIntent = new Intent(RecognitionService.SERVICE_INTERFACE);
            
            if (mServiceComponent == null) {
                String serviceComponent = Settings.Secure.getString(mContext.getContentResolver(),
                        Settings.Secure.VOICE_RECOGNITION_SERVICE);
                
                if (TextUtils.isEmpty(serviceComponent)) {
                    Log.e(TAG, "no selected voice recognition service");
                    mListener.onError(ERROR_CLIENT);
                    return;
                }
                
                serviceIntent.setComponent(ComponentName.unflattenFromString(serviceComponent));                
            } else {
                serviceIntent.setComponent(mServiceComponent);
            }
            
            if (!mContext.bindService(serviceIntent, mConnection, Context.BIND_AUTO_CREATE)) {
                Log.e(TAG, "bind to recognition service failed");
                mConnection = null;
                mService = null;
                mListener.onError(ERROR_CLIENT);
                return;
            }
        }
        putMessage(Message.obtain(mHandler, MSG_START, recognizerIntent));
    }

    /**
     * Stops listening for speech. Speech captured so far will be recognized as if the user had
     * stopped speaking at this point. Note that in the default case, this does not need to be
     * called, as the speech endpointer will automatically stop the recognizer listening when it
     * determines speech has completed. However, you can manipulate endpointer parameters directly
     * using the intent extras defined in {@link RecognizerIntent}, in which case you may sometimes
     * want to manually call this method to stop listening sooner. Please note that
     * {@link #setRecognitionListener(RecognitionListener)} should be called beforehand, otherwise
     * no notifications will be received.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.158 -0500", hash_original_method = "A8390EFF2DA1FBF4056A47F4A80E1574", hash_generated_method = "B0CC9996DAF9587EED2D5EEA82E34C2A")
    public void stopListening() {
        checkIsCalledFromMainThread();
        putMessage(Message.obtain(mHandler, MSG_STOP));
    }

    /**
     * Cancels the speech recognition. Please note that
     * {@link #setRecognitionListener(RecognitionListener)} should be called beforehand, otherwise
     * no notifications will be received.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.158 -0500", hash_original_method = "10AA7C6E429E5CC79EFBF134B39CD4DB", hash_generated_method = "1ADCA7B0A73AFD517C7D86BD5CA3FFE0")
    public void cancel() {
        checkIsCalledFromMainThread();
        putMessage(Message.obtain(mHandler, MSG_CANCEL));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.160 -0500", hash_original_method = "BD5701E8DF0BF25E7CB3736533848F1A", hash_generated_method = "6088A715F527AB5569B228B7A1B4C5DD")
    private void putMessage(Message msg) {
        if (mService == null) {
            mPendingTasks.offer(msg);
        } else {
            mHandler.sendMessage(msg);
        }
    }

    /** sends the actual message to the service */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.161 -0500", hash_original_method = "02FE733144FE02DDB0F8182E4A142CB0", hash_generated_method = "AC4EA91A85FD0035D90E3AC2680C72BA")
    private void handleStartListening(Intent recognizerIntent) {
        if (!checkOpenConnection()) {
            return;
        }
        try {
            mService.startListening(recognizerIntent, mListener);
            if (DBG) Log.d(TAG, "service start listening command succeded");
        } catch (final RemoteException e) {
            Log.e(TAG, "startListening() failed", e);
            mListener.onError(ERROR_CLIENT);
        }
    }

    /** sends the actual message to the service */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.161 -0500", hash_original_method = "B90CA3721E1A91D945B72975FC03EB82", hash_generated_method = "EEC5104156EC8B701A154FD6A59FFE1B")
    private void handleStopMessage() {
        if (!checkOpenConnection()) {
            return;
        }
        try {
            mService.stopListening(mListener);
            if (DBG) Log.d(TAG, "service stop listening command succeded");
        } catch (final RemoteException e) {
            Log.e(TAG, "stopListening() failed", e);
            mListener.onError(ERROR_CLIENT);
        }
    }

    /** sends the actual message to the service */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.162 -0500", hash_original_method = "5E81A38D35A2865AC1654F506B5D7265", hash_generated_method = "29E1CC4E517C946B1446A45E81028CA5")
    private void handleCancelMessage() {
        if (!checkOpenConnection()) {
            return;
        }
        try {
            mService.cancel(mListener);
            if (DBG) Log.d(TAG, "service cancel command succeded");
        } catch (final RemoteException e) {
            Log.e(TAG, "cancel() failed", e);
            mListener.onError(ERROR_CLIENT);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.163 -0500", hash_original_method = "325935BA5701514064BC283979E7156C", hash_generated_method = "CFC2CC3D3BBAB10693E46CB18E5DDA6D")
    private boolean checkOpenConnection() {
        if (mService != null) {
            return true;
        }
        mListener.onError(ERROR_CLIENT);
        Log.e(TAG, "not connected to the recognition service");
        return false;
    }

    /** changes the listener */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.164 -0500", hash_original_method = "90AD91808DE7CDCDA112C3C449526B0F", hash_generated_method = "20B10734DDA46A3CCD37EA8F56111ECD")
    private void handleChangeListener(RecognitionListener listener) {
        if (DBG) Log.d(TAG, "handleChangeListener, listener=" + listener);
        mListener.mInternalListener = listener;
    }

    /**
     * Destroys the {@code SpeechRecognizer} object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:46.165 -0500", hash_original_method = "B539A3FDAD7DAFC2710B42A201C294A5", hash_generated_method = "27949E7CEE202808413B71B950D2736D")
    public void destroy() {
        if (mConnection != null) {
            mContext.unbindService(mConnection);
        }
        mPendingTasks.clear();
        mService = null;
        mConnection = null;
        mListener.mInternalListener = null;
    }
}

