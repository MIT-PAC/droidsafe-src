package android.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.MessageQueue;
import android.util.Slog;

public final class InputQueue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.118 -0400", hash_original_field = "8E934369C1BCE6316A2C1FFFF8C383AB", hash_generated_field = "9822897BD047FB46E3B13005AC739818")

    InputChannel mChannel;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.118 -0400", hash_original_method = "578F9F8C0543A874EC0424533736E385", hash_generated_method = "CE3B3177795F0AF995D39C9B3A066820")
    public  InputQueue(InputChannel channel) {
        mChannel = channel;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeRegisterInputChannel(InputChannel inputChannel,
            InputHandler inputHandler, MessageQueue messageQueue) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeUnregisterInputChannel(InputChannel inputChannel) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeFinished(long finishedToken, boolean handled) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.119 -0400", hash_original_method = "61914318E0BCFE3BB34C0890B61B6D95", hash_generated_method = "E15F369CA63A294254204E761B8F450E")
    public InputChannel getInputChannel() {
        InputChannel varB4EAC82CA7396A68D541C85D26508E83_1305842057 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1305842057 = mChannel;
        varB4EAC82CA7396A68D541C85D26508E83_1305842057.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1305842057;
        
        
    }

    
    public static void registerInputChannel(InputChannel inputChannel, InputHandler inputHandler,
            MessageQueue messageQueue) {
        
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.120 -0400", hash_original_field = "6BF86F902744979BA23F6DD1588AEE5E", hash_generated_field = "11EDD9B738A3761EEA6282CC3588BF9E")

        private FinishedCallback mRecycleNext;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.120 -0400", hash_original_field = "159C1A4458FBBEEFFEFE7A218E806BE7", hash_generated_field = "1C857E4F95050669EDA465BE12C181F0")

        private long mFinishedToken;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.121 -0400", hash_original_method = "85C1D812E7267DE4D8D0FC0F23F521F1", hash_generated_method = "FE7116F7FDD08D0BCD50ADD251496AB3")
        private  FinishedCallback() {
            
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.121 -0400", hash_original_method = "223A5774CCBBEE51AC57EA08FD2D5298", hash_generated_method = "72638A48EAD7F8697C102FD22354A1C5")
        public void finished(boolean handled) {
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Event finished callback already invoked.");
                } 
                nativeFinished(mFinishedToken, handled);
                mFinishedToken = -1;
                {
                    mRecycleNext = sRecycleHead;
                    sRecycleHead = this;
                    sRecycleCount += 1;
                    {
                        Slog.d(TAG, "Recycled finished callbacks: " + sRecycleCount);
                    } 
                } 
            } 
            addTaint(handled);
            
            
                
                    
                
                
                
                
                    
                    
                    
                    
                        
                    
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.122 -0400", hash_original_field = "E385725950DB401B644A467BCFE6F11E", hash_generated_field = "9F7DA56D7A23AAB7342B4FF4C64596CF")

        private static final boolean DEBUG_RECYCLING = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.122 -0400", hash_original_field = "8BF85949C5C17B9539C18F516260693A", hash_generated_field = "83F7B4ADF1022D74F53DAB6800B8D49A")

        private static final int RECYCLE_MAX_COUNT = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.122 -0400", hash_original_field = "3DAB9E5F5151A679980195506FD4E373", hash_generated_field = "A6C02CE6C51F6B2D82885ADD48494A3F")

        private static FinishedCallback sRecycleHead;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.122 -0400", hash_original_field = "F7B7EBE652448295B9483E7EA078D385", hash_generated_field = "86B3BF83920104C89343F2C0A2344F77")

        private static int sRecycleCount;
    }


    
    public static interface Callback {
        
        void onInputQueueCreated(InputQueue queue);
        
        
        void onInputQueueDestroyed(InputQueue queue);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.122 -0400", hash_original_field = "E9069E9EEDEBF04CDBA5993149C153A3", hash_generated_field = "94920E7D18ECE70284EAAEB037392224")

    private static final String TAG = "InputQueue";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.122 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.122 -0400", hash_original_field = "6FBEC3E7BB69D1E09ECABF075E18871F", hash_generated_field = "BDCA99E42BC506D141E07BE230771AE3")

    private static final Object sLock = new Object();
}

