package android.nfc;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.WeakHashMap;

import android.app.Activity;
import android.os.RemoteException;
import android.util.Log;

public final class NfcActivityManager extends INdefPushCallback.Stub {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.146 -0500", hash_original_field = "F831CF2D478CE232979B41DE04931C42", hash_generated_field = "1CCFC0E09744FE65F20D7FAA18F3A6FD")

    static final String TAG = NfcAdapter.TAG;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.148 -0500", hash_original_field = "3E0FBB9B0ECF11F20687CB563783FF9F", hash_generated_field = "11521ED4D706D9B29918B8254968F6E4")

    static final Boolean DBG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.150 -0500", hash_original_field = "278F7851F6317C51C418D85323A63D34", hash_generated_field = "278F7851F6317C51C418D85323A63D34")

     NfcAdapter mAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.152 -0500", hash_original_field = "5469BB6F258042FA572F1AF012C94830", hash_generated_field = "5469BB6F258042FA572F1AF012C94830")

     WeakHashMap<Activity, NfcActivityState> mNfcState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.154 -0500", hash_original_field = "F63991A177E6F1B31D60C851B30C7CA6", hash_generated_field = "F63991A177E6F1B31D60C851B30C7CA6")

     NfcEvent mDefaultEvent;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.171 -0500", hash_original_method = "38A6693B00F3F4C308A1D8C73B4DA266", hash_generated_method = "C910DDD804DA1DA413E9542EBA316848")
    
public NfcActivityManager(NfcAdapter adapter) {
        mAdapter = adapter;
        mNfcState = new WeakHashMap<Activity, NfcActivityState>();
        mDefaultEvent = new NfcEvent(mAdapter);
    }

    /**
     * onResume hook from fragment attached to activity
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.173 -0500", hash_original_method = "5C41D3987D5608A9FF91B81AF91F1E3A", hash_generated_method = "69F31347E4784F980B23BB6EF0D1744C")
    
public synchronized void onResume(Activity activity) {
        NfcActivityState state = mNfcState.get(activity);
        if (DBG) Log.d(TAG, "onResume() for " + activity + " " + state);
        if (state != null) {
            state.resumed = true;
            updateNfcService(state);
        }
    }

    /**
     * onPause hook from fragment attached to activity
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.176 -0500", hash_original_method = "D5BF387644292151C2CC3D8E2C24ADB4", hash_generated_method = "A14DCC13E139FA9706E1C8C0B000CE6C")
    
public synchronized void onPause(Activity activity) {
        NfcActivityState state = mNfcState.get(activity);
        if (DBG) Log.d(TAG, "onPause() for " + activity + " " + state);
        if (state != null) {
            state.resumed = false;
            updateNfcService(state);
        }
    }

    /**
     * onDestroy hook from fragment attached to activity
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.178 -0500", hash_original_method = "24F6BFACBC4EE2930906E276E667EC5B", hash_generated_method = "5878DB62400B17AE30E78442CA39D73C")
    
public void onDestroy(Activity activity) {
        mNfcState.remove(activity);
    }

    @DSSink({DSSinkKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.181 -0500", hash_original_method = "571064E533016906493F5781A338B8A8", hash_generated_method = "6D9502B2812F579BD22C4F0E4DF93B59")
    
public synchronized void setNdefPushMessage(Activity activity, NdefMessage message) {
        NfcActivityState state = getOrCreateState(activity, message != null);
        if (state == null || state.ndefMessage == message) {
            return;  // nothing more to do;
        }
        state.ndefMessage = message;
        if (message == null) {
            maybeRemoveState(activity, state);
        }
        if (state.resumed) {
            updateNfcService(state);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.183 -0500", hash_original_method = "8461A3F609F79E3AD7DBD099EE01C2BB", hash_generated_method = "52A4EA0E05B0A93157C4B19372511A03")
    
public synchronized void setNdefPushMessageCallback(Activity activity,
            NfcAdapter.CreateNdefMessageCallback callback) {
        NfcActivityState state = getOrCreateState(activity, callback != null);
        if (state == null || state.ndefMessageCallback == callback) {
            return;  // nothing more to do;
        }
        state.ndefMessageCallback = callback;
        if (callback == null) {
            maybeRemoveState(activity, state);
        }
        if (state.resumed) {
            updateNfcService(state);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.186 -0500", hash_original_method = "9383A81E53F319F7F82E3EAB1795FFCD", hash_generated_method = "01886A2FC7D781DCE112323C51E3271D")
    
public synchronized void setOnNdefPushCompleteCallback(Activity activity,
            NfcAdapter.OnNdefPushCompleteCallback callback) {
        NfcActivityState state = getOrCreateState(activity, callback != null);
        if (state == null || state.onNdefPushCompleteCallback == callback) {
            return;  // nothing more to do;
        }
        state.onNdefPushCompleteCallback = callback;
        if (callback == null) {
            maybeRemoveState(activity, state);
        }
        if (state.resumed) {
            updateNfcService(state);
        }
    }

    /**
     * Get the NfcActivityState for the specified Activity.
     * If create is true, then create it if it doesn't already exist,
     * and ensure the NFC fragment is attached to the activity.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.188 -0500", hash_original_method = "85DEBB165D0E03A5E3758750DB067F77", hash_generated_method = "AE963B2DC98F35EF3B7257E713363E0D")
    
synchronized NfcActivityState getOrCreateState(Activity activity, boolean create) {
        if (DBG) Log.d(TAG, "getOrCreateState " + activity + " " + create);
        NfcActivityState state = mNfcState.get(activity);
        if (state == null && create) {
            state = new NfcActivityState();
            mNfcState.put(activity, state);
            NfcFragment.attach(activity);
        }
        return state;
    }

    /**
     * If the NfcActivityState is empty then remove it, and
     * detach it from the Activity.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.191 -0500", hash_original_method = "6C42916FD841C6EAFF0C495955BCFCAE", hash_generated_method = "3CD52E527983D594DC6FD8A7ED8202B5")
    
synchronized void maybeRemoveState(Activity activity, NfcActivityState state) {
        if (state.ndefMessage == null && state.ndefMessageCallback == null &&
                state.onNdefPushCompleteCallback == null) {
            NfcFragment.remove(activity);
            mNfcState.remove(activity);
        }
    }

    /**
     * Register NfcActivityState with the NFC service.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.193 -0500", hash_original_method = "6FB81CDE896F299C5469DD3DD94C1A99", hash_generated_method = "AE86503EE478594407DCB62B69CED5D7")
    
synchronized void updateNfcService(NfcActivityState state) {
        boolean serviceCallbackNeeded = state.ndefMessageCallback != null ||
                state.onNdefPushCompleteCallback != null;

        try {
            NfcAdapter.sService.setForegroundNdefPush(state.resumed ? state.ndefMessage : null,
                    state.resumed && serviceCallbackNeeded ? this : null);
        } catch (RemoteException e) {
            mAdapter.attemptDeadServiceRecovery(e);
        }
    }
    
    class NfcActivityState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.157 -0500", hash_original_field = "FC09BA0B5D237866CCDEC966434CCE0D", hash_generated_field = "FC09BA0B5D237866CCDEC966434CCE0D")

        boolean resumed = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.160 -0500", hash_original_field = "5EFC654483C8286DD660EB3F60CEFD7D", hash_generated_field = "5EFC654483C8286DD660EB3F60CEFD7D")

        NdefMessage ndefMessage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.162 -0500", hash_original_field = "31CC743A90A0F505CE2C991EF03A3ECF", hash_generated_field = "31CC743A90A0F505CE2C991EF03A3ECF")

        NfcAdapter.CreateNdefMessageCallback ndefMessageCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.164 -0500", hash_original_field = "5465A7509AA4D952EF948BC541F48DC4", hash_generated_field = "5465A7509AA4D952EF948BC541F48DC4")

        NfcAdapter.OnNdefPushCompleteCallback onNdefPushCompleteCallback;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.166 -0400", hash_original_method = "1126BF18A68478D666D07CED7ED74101", hash_generated_method = "1126BF18A68478D666D07CED7ED74101")
        public NfcActivityState ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.167 -0500", hash_original_method = "0458F1EA3F9A5785CA2A5D797EF2D2B7", hash_generated_method = "01563C0C26DD18610EAF408D8701D01E")
        
@Override
        public String toString() {
            StringBuilder s = new StringBuilder("[").append(resumed).append(" ");
            s.append(ndefMessage).append(" ").append(ndefMessageCallback).append(" ");
            s.append(onNdefPushCompleteCallback).append("]");
            return s.toString();
        }
        
    }

    /**
     * Callback from NFC service
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.196 -0500", hash_original_method = "3FF4E80952B14CA972EE064B02088076", hash_generated_method = "7379EDC1F9BB3C30C3B32834E48C5384")
    
@Override
    public NdefMessage createMessage() {
        NfcAdapter.CreateNdefMessageCallback callback = null;
        synchronized (NfcActivityManager.this) {
            for (NfcActivityState state : mNfcState.values()) {
                if (state.resumed) {
                    callback = state.ndefMessageCallback;
                }
            }
        }

        // drop lock before making callback
        if (callback != null) {
            return callback.createNdefMessage(mDefaultEvent);
        }
        return null;
    }

    /**
     * Callback from NFC service
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.199 -0500", hash_original_method = "CE2F7F897A262F67EB6F40C6D613EBB1", hash_generated_method = "FEC6BA4F7A6D19163BF63B509F6E91D8")
    
@Override
    public void onNdefPushComplete() {
        NfcAdapter.OnNdefPushCompleteCallback callback = null;
        synchronized (NfcActivityManager.this) {
            for (NfcActivityState state : mNfcState.values()) {
                if (state.resumed) {
                    callback = state.onNdefPushCompleteCallback;
                }
            }
        }

        // drop lock before making callback
        if (callback != null) {
            callback.onNdefPushComplete(mDefaultEvent);
        }
    }
}

