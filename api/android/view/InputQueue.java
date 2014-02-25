package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

import droidsafe.annotations.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import android.os.MessageQueue;
import android.util.Slog;

public final class InputQueue {
    
    private static HashSet<InputChannel> channels = new HashSet<InputChannel>();
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeRegisterInputChannel(InputChannel inputChannel,
            InputHandler inputHandler, MessageQueue messageQueue) {
        channels.add(inputChannel);
        KeyEvent keyEvent = new KeyEvent();
        MotionEvent motionEvent = new MotionEvent(); 
        long token = new Random().nextLong();
        FinishedCallback callback = FinishedCallback.obtain(token);

        dispatchKeyEvent(inputHandler, keyEvent, callback.mFinishedToken);
        dispatchMotionEvent(inputHandler, motionEvent, callback.mFinishedToken);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeUnregisterInputChannel(InputChannel inputChannel) {
        channels.remove(inputChannel);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeFinished(long finishedToken, boolean handled) {
    }
    
    public static void registerInputChannel(InputChannel inputChannel, InputHandler inputHandler,
            MessageQueue messageQueue) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        if (inputChannel == null) {
            throw new IllegalArgumentException("inputChannel must not be null");
        }
        if (inputHandler == null) {
            throw new IllegalArgumentException("inputHandler must not be null");
        }
        if (messageQueue == null) {
            throw new IllegalArgumentException("messageQueue must not be null");
        }

        nativeRegisterInputChannel(inputChannel, inputHandler, messageQueue);
    }
    
    public static void unregisterInputChannel(InputChannel inputChannel) {
        if (inputChannel == null) {
            throw new IllegalArgumentException("inputChannel must not be null");
        }
        nativeUnregisterInputChannel(inputChannel);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.280 -0500", hash_original_method = "36C17BD34CDDCF86AAD54E86A65CBE17", hash_generated_method = "48F220CF03DE9F3A2BEC15ED27315F57")
    
@SuppressWarnings("unused")
    private static void dispatchKeyEvent(InputHandler inputHandler,
            KeyEvent event, long finishedToken) {
        FinishedCallback finishedCallback = FinishedCallback.obtain(finishedToken);
        inputHandler.handleKey(event, finishedCallback);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.283 -0500", hash_original_method = "1DB369BCBC340EA73F202ACFFFE6A3DD", hash_generated_method = "945929AAFC4E215FA8BC3E6248F28423")
    
@SuppressWarnings("unused")
    private static void dispatchMotionEvent(InputHandler inputHandler,
            MotionEvent event, long finishedToken) {
        FinishedCallback finishedCallback = FinishedCallback.obtain(finishedToken);
        inputHandler.handleMotion(event, finishedCallback);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.245 -0500", hash_original_field = "DF383A2ACFEE05AC3BD4A4406C46C7E2", hash_generated_field = "94920E7D18ECE70284EAAEB037392224")

    private static final String TAG = "InputQueue";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.247 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")
    
    private static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.255 -0500", hash_original_field = "3892ABA92B7F95295E8CFDAE8B79791E", hash_generated_field = "BDCA99E42BC506D141E07BE230771AE3")
    
    private static final Object sLock = new Object();
    
    public static final class FinishedCallback {
        
        static HashMap<Long, FinishedCallback> callBackMap = new HashMap<Long, FinishedCallback>();
        
        public static FinishedCallback obtain(long finishedToken) {
            if (!callBackMap.containsKey(finishedToken)) {
                FinishedCallback callback = new FinishedCallback();
                callback.mFinishedToken = finishedToken;
                callBackMap.put(finishedToken, callback);
            }
            return callBackMap.get(finishedToken);
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.297 -0500", hash_original_field = "5A9C4804E43B1DA0BA241FB5470EF97E", hash_generated_field = "11EDD9B738A3761EEA6282CC3588BF9E")
        
        private FinishedCallback mRecycleNext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.300 -0500", hash_original_field = "67A0FC1AB73DFA1EF77B1023746AD614", hash_generated_field = "1C857E4F95050669EDA465BE12C181F0")

        private long mFinishedToken;
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.302 -0500", hash_original_method = "85C1D812E7267DE4D8D0FC0F23F521F1", hash_generated_method = "2E154B4C61D82C8A0B2C3D1599F5A3C6")
        
private FinishedCallback() {
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.124 -0400", hash_original_method = "223A5774CCBBEE51AC57EA08FD2D5298", hash_generated_method = "258E1BCA7AF0C20AD74EDB6062C79320")
        public void finished(boolean handled) {
            addTaint(handled);
            if (DroidSafeAndroidRuntime.control) {
                IllegalStateException var241EDB98EA12D59AE07921EE5D3D6CA9_1882957200 = new IllegalStateException("Event finished callback already invoked.");
                var241EDB98EA12D59AE07921EE5D3D6CA9_1882957200.addTaint(taint);
                throw var241EDB98EA12D59AE07921EE5D3D6CA9_1882957200;
            } //End block
            
            callBackMap.remove(mFinishedToken);

           // ---------- Original Method ----------
            //synchronized (sLock) {
                //if (mFinishedToken == -1) {
                    //throw new IllegalStateException("Event finished callback already invoked.");
                //}
                //nativeFinished(mFinishedToken, handled);
                //mFinishedToken = -1;
                //if (sRecycleCount < RECYCLE_MAX_COUNT) {
                    //mRecycleNext = sRecycleHead;
                    //sRecycleHead = this;
                    //sRecycleCount += 1;
                    //if (DEBUG_RECYCLING) {
                        //Slog.d(TAG, "Recycled finished callbacks: " + sRecycleCount);
                    //}
                //}
            //}
        }

    }
    
    public static interface Callback {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onInputQueueCreated(InputQueue queue);
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onInputQueueDestroyed(InputQueue queue);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.252 -0500", hash_original_field = "9822897BD047FB46E3B13005AC739818", hash_generated_field = "9822897BD047FB46E3B13005AC739818")

     InputChannel mChannel;
    
    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.270 -0500", hash_original_method = "578F9F8C0543A874EC0424533736E385", hash_generated_method = "F3609ACFC4EBC9F4C56997CE627C55BF")
    
public InputQueue(InputChannel channel) {
        mChannel = channel;
    }
    
    /** @hide */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.272 -0500", hash_original_method = "61914318E0BCFE3BB34C0890B61B6D95", hash_generated_method = "4041D8E4263F3B4F9618C753D89620DE")
    
public InputChannel getInputChannel() {
        return mChannel;
    }
}

