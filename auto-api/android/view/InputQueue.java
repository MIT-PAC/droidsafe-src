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
    InputChannel mChannel;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.930 -0400", hash_original_method = "578F9F8C0543A874EC0424533736E385", hash_generated_method = "EF7F795D7304EC4C5E2D4D1F0FAB4208")
    @DSModeled(DSC.SAFE)
    public InputQueue(InputChannel channel) {
        dsTaint.addTaint(channel.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.931 -0400", hash_original_method = "61914318E0BCFE3BB34C0890B61B6D95", hash_generated_method = "15A45954773B94D89B381BA98F0FA9C8")
    @DSModeled(DSC.SAFE)
    public InputChannel getInputChannel() {
        return (InputChannel)dsTaint.getTaint();
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
        private FinishedCallback mRecycleNext;
        private long mFinishedToken;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.932 -0400", hash_original_method = "85C1D812E7267DE4D8D0FC0F23F521F1", hash_generated_method = "FE7116F7FDD08D0BCD50ADD251496AB3")
        @DSModeled(DSC.SAFE)
        private FinishedCallback() {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.933 -0400", hash_original_method = "223A5774CCBBEE51AC57EA08FD2D5298", hash_generated_method = "ADFB6A388B9DE63D11F3970F1B2EBFF5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void finished(boolean handled) {
            dsTaint.addTaint(handled);
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

        
        private static final boolean DEBUG_RECYCLING = false;
        private static final int RECYCLE_MAX_COUNT = 4;
        private static FinishedCallback sRecycleHead;
        private static int sRecycleCount;
    }


    
    public static interface Callback {
        
        void onInputQueueCreated(InputQueue queue);
        
        
        void onInputQueueDestroyed(InputQueue queue);
    }
    
    private static final String TAG = "InputQueue";
    private static final boolean DEBUG = false;
    private static final Object sLock = new Object();
}

