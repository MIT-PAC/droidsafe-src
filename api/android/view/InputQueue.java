package android.view;

// Droidsafe Imports
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

import droidsafe.annotations.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import android.os.MessageQueue;
import android.util.Slog;





public final class InputQueue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.122 -0400", hash_original_field = "8E934369C1BCE6316A2C1FFFF8C383AB", hash_generated_field = "9822897BD047FB46E3B13005AC739818")

    InputChannel mChannel;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.122 -0400", hash_original_method = "578F9F8C0543A874EC0424533736E385", hash_generated_method = "CE3B3177795F0AF995D39C9B3A066820")
    public  InputQueue(InputChannel channel) {
        mChannel = channel;
        // ---------- Original Method ----------
        //mChannel = channel;
    }
    
    private static HashSet<InputChannel> channels = new HashSet<InputChannel>();

    
    @DSModeled(DSC.BAN)
    private static void nativeRegisterInputChannel(InputChannel inputChannel,
            InputHandler inputHandler, MessageQueue messageQueue) {
        channels.add(inputChannel);
        KeyEvent keyEvent = KeyEvent.droidsafeObtainEvent();
        MotionEvent motionEvent = MotionEvent.droidsafeObtainEvent(); 
        long token = new Random().nextLong();
        FinishedCallback callback = FinishedCallback.obtain(token);

        dispatchKeyEvent(inputHandler, keyEvent, callback.mFinishedToken);
        dispatchMotionEvent(inputHandler, motionEvent, callback.mFinishedToken);
    }

    
    @DSModeled(DSC.BAN)
    private static void nativeUnregisterInputChannel(InputChannel inputChannel) {
        channels.remove(inputChannel);
    }

    
    @DSModeled(DSC.BAN)
    private static void nativeFinished(long finishedToken, boolean handled) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.123 -0400", hash_original_method = "61914318E0BCFE3BB34C0890B61B6D95", hash_generated_method = "94A66D684A65D61EA725EB5919A30C55")
    public InputChannel getInputChannel() {
InputChannel varE2D76F05D260658A7D968B6D9CBA0D40_1864546670 =         mChannel;
        varE2D76F05D260658A7D968B6D9CBA0D40_1864546670.addTaint(taint);
        return varE2D76F05D260658A7D968B6D9CBA0D40_1864546670;
        // ---------- Original Method ----------
        //return mChannel;
    }

    
    @DSModeled(DSC.SPEC)
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

    
    @DSModeled(DSC.SAFE)
    public static void unregisterInputChannel(InputChannel inputChannel) {
        if (inputChannel == null) {
            throw new IllegalArgumentException("inputChannel must not be null");
        }
        nativeUnregisterInputChannel(inputChannel);
    }

    
    @DSModeled(DSC.BAN)
    @SuppressWarnings("unused")
    private static void dispatchKeyEvent(InputHandler inputHandler,
            KeyEvent event, long finishedToken) {
        FinishedCallback finishedCallback = FinishedCallback.obtain(finishedToken);
        inputHandler.handleKey(event, finishedCallback);
    }

    
    @DSModeled(DSC.BAN)
    @SuppressWarnings("unused")
    private static void dispatchMotionEvent(InputHandler inputHandler,
            MotionEvent event, long finishedToken) {
        FinishedCallback finishedCallback = FinishedCallback.obtain(finishedToken);
        inputHandler.handleMotion(event, finishedCallback);
    }

    
    public static final class FinishedCallback {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.124 -0400", hash_original_field = "6BF86F902744979BA23F6DD1588AEE5E", hash_generated_field = "11EDD9B738A3761EEA6282CC3588BF9E")

        private FinishedCallback mRecycleNext;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.124 -0400", hash_original_field = "159C1A4458FBBEEFFEFE7A218E806BE7", hash_generated_field = "1C857E4F95050669EDA465BE12C181F0")

        private long mFinishedToken;
        
        static HashMap<Long, FinishedCallback> callBackMap = new HashMap<Long, FinishedCallback>();
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.124 -0400", hash_original_method = "85C1D812E7267DE4D8D0FC0F23F521F1", hash_generated_method = "FE7116F7FDD08D0BCD50ADD251496AB3")
        private  FinishedCallback() {
            // ---------- Original Method ----------
        }

        @DSModeled(DSC.SAFE)
        public static FinishedCallback obtain(long finishedToken) {
            if (!callBackMap.containsKey(finishedToken)) {
                FinishedCallback callback = new FinishedCallback();
                callback.mFinishedToken = finishedToken;
                callBackMap.put(finishedToken, callback);
            }
            return callBackMap.get(finishedToken);
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
        
        void onInputQueueCreated(InputQueue queue);
        
        
        void onInputQueueDestroyed(InputQueue queue);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.125 -0400", hash_original_field = "E9069E9EEDEBF04CDBA5993149C153A3", hash_generated_field = "94920E7D18ECE70284EAAEB037392224")

    private static final String TAG = "InputQueue";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.125 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.125 -0400", hash_original_field = "6FBEC3E7BB69D1E09ECABF075E18871F", hash_generated_field = "BDCA99E42BC506D141E07BE230771AE3")

    private static final Object sLock = new Object();
}

