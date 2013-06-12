package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.MessageQueue;
import android.util.Slog;

public final class InputQueue {
    private static final String TAG = "InputQueue";
    private static final boolean DEBUG = false;
    final InputChannel mChannel;
    private static final Object sLock = new Object();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.132 -0400", hash_original_method = "578F9F8C0543A874EC0424533736E385", hash_generated_method = "D82928703DB6A557BC92B11D1574694D")
    @DSModeled(DSC.SAFE)
    public InputQueue(InputChannel channel) {
        dsTaint.addTaint(channel.dsTaint);
        // ---------- Original Method ----------
        //mChannel = channel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.132 -0400", hash_original_method = "772137F5B17C4DBF9726AB6EC85DE71A", hash_generated_method = "AEB0F4E7B4EAE044433F7D69703B5991")
    private static void nativeRegisterInputChannel(InputChannel inputChannel,
            InputHandler inputHandler, MessageQueue messageQueue) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.132 -0400", hash_original_method = "3E1580E422EE53D83CECC06E5EB725DD", hash_generated_method = "3B287433B59FABC19A8B8800E3CD1246")
    private static void nativeUnregisterInputChannel(InputChannel inputChannel) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.132 -0400", hash_original_method = "511C8F574FC88B46AADE9D0C29C2C3B4", hash_generated_method = "5E061523DDAD10B43E8BD4CA74529232")
    private static void nativeFinished(long finishedToken, boolean handled) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.132 -0400", hash_original_method = "61914318E0BCFE3BB34C0890B61B6D95", hash_generated_method = "403FF45DF1FDBC9A40A75A5FFCE6087C")
    @DSModeled(DSC.SAFE)
    public InputChannel getInputChannel() {
        return (InputChannel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mChannel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.132 -0400", hash_original_method = "906B34A24371F63201CDB1140BFC2AAE", hash_generated_method = "15150EBD6F58110F7A42DB15F93AED14")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.132 -0400", hash_original_method = "E7F8A435CF126C56FF52F58976DCB3B4", hash_generated_method = "B25F8ECE235A02B24B52E198FDADF1C7")
    public static void unregisterInputChannel(InputChannel inputChannel) {
        //DSFIXME: CODE0010: Possible callback registration function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.132 -0400", hash_original_method = "36C17BD34CDDCF86AAD54E86A65CBE17", hash_generated_method = "48F220CF03DE9F3A2BEC15ED27315F57")
    @SuppressWarnings("unused")
    private static void dispatchKeyEvent(InputHandler inputHandler,
            KeyEvent event, long finishedToken) {
        FinishedCallback finishedCallback = FinishedCallback.obtain(finishedToken);
        inputHandler.handleKey(event, finishedCallback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.132 -0400", hash_original_method = "1DB369BCBC340EA73F202ACFFFE6A3DD", hash_generated_method = "945929AAFC4E215FA8BC3E6248F28423")
    @SuppressWarnings("unused")
    private static void dispatchMotionEvent(InputHandler inputHandler,
            MotionEvent event, long finishedToken) {
        FinishedCallback finishedCallback = FinishedCallback.obtain(finishedToken);
        inputHandler.handleMotion(event, finishedCallback);
    }

    
    public static final class FinishedCallback {
        private static final boolean DEBUG_RECYCLING = false;
        private static final int RECYCLE_MAX_COUNT = 4;
        private static FinishedCallback sRecycleHead;
        private static int sRecycleCount;
        private FinishedCallback mRecycleNext;
        private long mFinishedToken;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.132 -0400", hash_original_method = "85C1D812E7267DE4D8D0FC0F23F521F1", hash_generated_method = "F1F02C8711E0511B9DEEFD179E155F30")
        @DSModeled(DSC.SAFE)
        private FinishedCallback() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.133 -0400", hash_original_method = "F0491859198EDA21AE1C67E2D366D62A", hash_generated_method = "D1EA568B8AE943E31E952D6BA0765FBB")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.133 -0400", hash_original_method = "223A5774CCBBEE51AC57EA08FD2D5298", hash_generated_method = "5C6ECAEDF5466DACE5630767B49153D8")
        @DSModeled(DSC.SAFE)
        public void finished(boolean handled) {
            dsTaint.addTaint(handled);
            {
                {
                    throw new IllegalStateException("Event finished callback already invoked.");
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

        
    }


    
    public static interface Callback {
        
        void onInputQueueCreated(InputQueue queue);
        
        
        void onInputQueueDestroyed(InputQueue queue);
    }
    
}


