package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.MessageQueue;
import android.util.Slog;

public final class InputQueue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.471 -0400", hash_original_field = "8E934369C1BCE6316A2C1FFFF8C383AB", hash_generated_field = "9822897BD047FB46E3B13005AC739818")

    InputChannel mChannel;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.478 -0400", hash_original_method = "578F9F8C0543A874EC0424533736E385", hash_generated_method = "CE3B3177795F0AF995D39C9B3A066820")
    public  InputQueue(InputChannel channel) {
        mChannel = channel;
        // ---------- Original Method ----------
        //mChannel = channel;
    }

    
        private static void nativeRegisterInputChannel(InputChannel inputChannel,
            InputHandler inputHandler, MessageQueue messageQueue) {
    }

    
        private static void nativeUnregisterInputChannel(InputChannel inputChannel) {
    }

    
        private static void nativeFinished(long finishedToken, boolean handled) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.484 -0400", hash_original_method = "61914318E0BCFE3BB34C0890B61B6D95", hash_generated_method = "E4F75684705CF9164CE4AD9F512328B3")
    public InputChannel getInputChannel() {
        InputChannel varB4EAC82CA7396A68D541C85D26508E83_119001540 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_119001540 = mChannel;
        varB4EAC82CA7396A68D541C85D26508E83_119001540.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_119001540;
        // ---------- Original Method ----------
        //return mChannel;
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
        synchronized (sLock) {
            if (DEBUG) {
                Slog.d(TAG, "Registering input channel '" + inputChannel + "'");
            }
            nativeRegisterInputChannel(inputChannel, inputHandler, messageQueue);
        }
    }

    
        public static void unregisterInputChannel(InputChannel inputChannel) {
        if (inputChannel == null) {
            throw new IllegalArgumentException("inputChannel must not be null");
        }
        synchronized (sLock) {
            if (DEBUG) {
                Slog.d(TAG, "Unregistering input channel '" + inputChannel + "'");
            }
            nativeUnregisterInputChannel(inputChannel);
        }
    }

    
        @SuppressWarnings("unused")
    private static void dispatchKeyEvent(InputHandler inputHandler,
            KeyEvent event, long finishedToken) {
        FinishedCallback finishedCallback = FinishedCallback.obtain(finishedToken);
        inputHandler.handleKey(event, finishedCallback);
    }

    
        @SuppressWarnings("unused")
    private static void dispatchMotionEvent(InputHandler inputHandler,
            MotionEvent event, long finishedToken) {
        FinishedCallback finishedCallback = FinishedCallback.obtain(finishedToken);
        inputHandler.handleMotion(event, finishedCallback);
    }

    
    public static final class FinishedCallback {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.485 -0400", hash_original_field = "6BF86F902744979BA23F6DD1588AEE5E", hash_generated_field = "11EDD9B738A3761EEA6282CC3588BF9E")

        private FinishedCallback mRecycleNext;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.485 -0400", hash_original_field = "159C1A4458FBBEEFFEFE7A218E806BE7", hash_generated_field = "1C857E4F95050669EDA465BE12C181F0")

        private long mFinishedToken;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.486 -0400", hash_original_method = "85C1D812E7267DE4D8D0FC0F23F521F1", hash_generated_method = "FE7116F7FDD08D0BCD50ADD251496AB3")
        private  FinishedCallback() {
            // ---------- Original Method ----------
        }

        
                public static FinishedCallback obtain(long finishedToken) {
            synchronized (sLock) {
                FinishedCallback callback = sRecycleHead;
                if (callback != null) {
                    sRecycleHead = callback.mRecycleNext;
                    sRecycleCount -= 1;
                    callback.mRecycleNext = null;
                } else {
                    callback = new FinishedCallback();
                }
                callback.mFinishedToken = finishedToken;
                return callback;
            }
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.499 -0400", hash_original_method = "223A5774CCBBEE51AC57EA08FD2D5298", hash_generated_method = "72638A48EAD7F8697C102FD22354A1C5")
        public void finished(boolean handled) {
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Event finished callback already invoked.");
                } //End block
                nativeFinished(mFinishedToken, handled);
                mFinishedToken = -1;
                {
                    mRecycleNext = sRecycleHead;
                    sRecycleHead = this;
                    sRecycleCount += 1;
                    {
                        Slog.d(TAG, "Recycled finished callbacks: " + sRecycleCount);
                    } //End block
                } //End block
            } //End block
            addTaint(handled);
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.499 -0400", hash_original_field = "E385725950DB401B644A467BCFE6F11E", hash_generated_field = "B425CC082E7E506D1C33EE64A6BA2EFF")

        private static boolean DEBUG_RECYCLING = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.499 -0400", hash_original_field = "8BF85949C5C17B9539C18F516260693A", hash_generated_field = "11FE855521BE531119530221AF1FAE05")

        private static int RECYCLE_MAX_COUNT = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.499 -0400", hash_original_field = "3DAB9E5F5151A679980195506FD4E373", hash_generated_field = "A6C02CE6C51F6B2D82885ADD48494A3F")

        private static FinishedCallback sRecycleHead;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.499 -0400", hash_original_field = "F7B7EBE652448295B9483E7EA078D385", hash_generated_field = "86B3BF83920104C89343F2C0A2344F77")

        private static int sRecycleCount;
    }


    
    public static interface Callback {
        
        void onInputQueueCreated(InputQueue queue);
        
        
        void onInputQueueDestroyed(InputQueue queue);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.499 -0400", hash_original_field = "E9069E9EEDEBF04CDBA5993149C153A3", hash_generated_field = "9181321C64EA0784073BBE4F95C94DFB")

    private static String TAG = "InputQueue";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.499 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "E83DF1E2E661A92B1AFDA8C473D190B2")

    private static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.499 -0400", hash_original_field = "6FBEC3E7BB69D1E09ECABF075E18871F", hash_generated_field = "E209496F9F2C9103A6260BCF69D3191B")

    private static Object sLock = new Object();
}

