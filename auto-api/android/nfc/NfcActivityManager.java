package android.nfc;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.Activity;
import android.os.RemoteException;
import android.util.Log;
import java.util.WeakHashMap;

public final class NfcActivityManager extends INdefPushCallback.Stub {
    NfcAdapter mAdapter;
    WeakHashMap<Activity, NfcActivityState> mNfcState;
    NfcEvent mDefaultEvent;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.977 -0400", hash_original_method = "38A6693B00F3F4C308A1D8C73B4DA266", hash_generated_method = "66A938E8D6F4E184AA7B15AA9E693DA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NfcActivityManager(NfcAdapter adapter) {
        dsTaint.addTaint(adapter.dsTaint);
        mNfcState = new WeakHashMap<Activity, NfcActivityState>();
        mDefaultEvent = new NfcEvent(mAdapter);
        // ---------- Original Method ----------
        //mAdapter = adapter;
        //mNfcState = new WeakHashMap<Activity, NfcActivityState>();
        //mDefaultEvent = new NfcEvent(mAdapter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.977 -0400", hash_original_method = "5C41D3987D5608A9FF91B81AF91F1E3A", hash_generated_method = "FD483087860F2E02788DDF50B72A35F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void onResume(Activity activity) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(activity.dsTaint);
        NfcActivityState state;
        state = mNfcState.get(activity);
        Log.d(TAG, "onResume() for " + activity + " " + state);
        {
            state.resumed = true;
            updateNfcService(state);
        } //End block
        // ---------- Original Method ----------
        //NfcActivityState state = mNfcState.get(activity);
        //if (DBG) Log.d(TAG, "onResume() for " + activity + " " + state);
        //if (state != null) {
            //state.resumed = true;
            //updateNfcService(state);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.978 -0400", hash_original_method = "D5BF387644292151C2CC3D8E2C24ADB4", hash_generated_method = "4699AF69BCE204361AFC5EB244ED2426")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void onPause(Activity activity) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(activity.dsTaint);
        NfcActivityState state;
        state = mNfcState.get(activity);
        Log.d(TAG, "onPause() for " + activity + " " + state);
        {
            state.resumed = false;
            updateNfcService(state);
        } //End block
        // ---------- Original Method ----------
        //NfcActivityState state = mNfcState.get(activity);
        //if (DBG) Log.d(TAG, "onPause() for " + activity + " " + state);
        //if (state != null) {
            //state.resumed = false;
            //updateNfcService(state);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.978 -0400", hash_original_method = "24F6BFACBC4EE2930906E276E667EC5B", hash_generated_method = "D3C071DA6FCB4F2E2D4891E6BBBD6161")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onDestroy(Activity activity) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(activity.dsTaint);
        mNfcState.remove(activity);
        // ---------- Original Method ----------
        //mNfcState.remove(activity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.979 -0400", hash_original_method = "571064E533016906493F5781A338B8A8", hash_generated_method = "A0F8F94EEB4728AABD751EA959FE2FFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setNdefPushMessage(Activity activity, NdefMessage message) {
        dsTaint.addTaint(message.dsTaint);
        dsTaint.addTaint(activity.dsTaint);
        NfcActivityState state;
        state = getOrCreateState(activity, message != null);
        state.ndefMessage = message;
        {
            maybeRemoveState(activity, state);
        } //End block
        {
            updateNfcService(state);
        } //End block
        // ---------- Original Method ----------
        //NfcActivityState state = getOrCreateState(activity, message != null);
        //if (state == null || state.ndefMessage == message) {
            //return;  
        //}
        //state.ndefMessage = message;
        //if (message == null) {
            //maybeRemoveState(activity, state);
        //}
        //if (state.resumed) {
            //updateNfcService(state);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.979 -0400", hash_original_method = "8461A3F609F79E3AD7DBD099EE01C2BB", hash_generated_method = "19CF3E5634BBE5BCB3BFE55676DC7E35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setNdefPushMessageCallback(Activity activity,
            NfcAdapter.CreateNdefMessageCallback callback) {
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(activity.dsTaint);
        NfcActivityState state;
        state = getOrCreateState(activity, callback != null);
        state.ndefMessageCallback = callback;
        {
            maybeRemoveState(activity, state);
        } //End block
        {
            updateNfcService(state);
        } //End block
        // ---------- Original Method ----------
        //NfcActivityState state = getOrCreateState(activity, callback != null);
        //if (state == null || state.ndefMessageCallback == callback) {
            //return;  
        //}
        //state.ndefMessageCallback = callback;
        //if (callback == null) {
            //maybeRemoveState(activity, state);
        //}
        //if (state.resumed) {
            //updateNfcService(state);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.980 -0400", hash_original_method = "9383A81E53F319F7F82E3EAB1795FFCD", hash_generated_method = "EA59B270EEF53431635F356E50321236")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setOnNdefPushCompleteCallback(Activity activity,
            NfcAdapter.OnNdefPushCompleteCallback callback) {
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(activity.dsTaint);
        NfcActivityState state;
        state = getOrCreateState(activity, callback != null);
        state.onNdefPushCompleteCallback = callback;
        {
            maybeRemoveState(activity, state);
        } //End block
        {
            updateNfcService(state);
        } //End block
        // ---------- Original Method ----------
        //NfcActivityState state = getOrCreateState(activity, callback != null);
        //if (state == null || state.onNdefPushCompleteCallback == callback) {
            //return;  
        //}
        //state.onNdefPushCompleteCallback = callback;
        //if (callback == null) {
            //maybeRemoveState(activity, state);
        //}
        //if (state.resumed) {
            //updateNfcService(state);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.980 -0400", hash_original_method = "85DEBB165D0E03A5E3758750DB067F77", hash_generated_method = "AA5C825860EA8F3286487F3C18C3D978")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized NfcActivityState getOrCreateState(Activity activity, boolean create) {
        dsTaint.addTaint(create);
        dsTaint.addTaint(activity.dsTaint);
        Log.d(TAG, "getOrCreateState " + activity + " " + create);
        NfcActivityState state;
        state = mNfcState.get(activity);
        {
            state = new NfcActivityState();
            mNfcState.put(activity, state);
            NfcFragment.attach(activity);
        } //End block
        return (NfcActivityState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (DBG) Log.d(TAG, "getOrCreateState " + activity + " " + create);
        //NfcActivityState state = mNfcState.get(activity);
        //if (state == null && create) {
            //state = new NfcActivityState();
            //mNfcState.put(activity, state);
            //NfcFragment.attach(activity);
        //}
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.981 -0400", hash_original_method = "6C42916FD841C6EAFF0C495955BCFCAE", hash_generated_method = "A5745B16FAA5A667A066652F9741F2FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void maybeRemoveState(Activity activity, NfcActivityState state) {
        dsTaint.addTaint(state.dsTaint);
        dsTaint.addTaint(activity.dsTaint);
        {
            NfcFragment.remove(activity);
            mNfcState.remove(activity);
        } //End block
        // ---------- Original Method ----------
        //if (state.ndefMessage == null && state.ndefMessageCallback == null &&
                //state.onNdefPushCompleteCallback == null) {
            //NfcFragment.remove(activity);
            //mNfcState.remove(activity);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.981 -0400", hash_original_method = "6FB81CDE896F299C5469DD3DD94C1A99", hash_generated_method = "4FA13619AADB63C96D858FF02CA0897C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void updateNfcService(NfcActivityState state) {
        dsTaint.addTaint(state.dsTaint);
        boolean serviceCallbackNeeded;
        serviceCallbackNeeded = state.ndefMessageCallback != null ||
                state.onNdefPushCompleteCallback != null;
        try 
        {
            NfcAdapter.sService.setForegroundNdefPush(state.resumed ? state.ndefMessage : null,
                    state.resumed && serviceCallbackNeeded ? this : null);
        } //End block
        catch (RemoteException e)
        {
            mAdapter.attemptDeadServiceRecovery(e);
        } //End block
        // ---------- Original Method ----------
        //boolean serviceCallbackNeeded = state.ndefMessageCallback != null ||
                //state.onNdefPushCompleteCallback != null;
        //try {
            //NfcAdapter.sService.setForegroundNdefPush(state.resumed ? state.ndefMessage : null,
                    //state.resumed && serviceCallbackNeeded ? this : null);
        //} catch (RemoteException e) {
            //mAdapter.attemptDeadServiceRecovery(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.995 -0400", hash_original_method = "3FF4E80952B14CA972EE064B02088076", hash_generated_method = "FB800B246FC79567B8D8F18E1CF3C674")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public NdefMessage createMessage() {
        NfcAdapter.CreateNdefMessageCallback callback;
        callback = null;
        {
            Object varEE293A251EFBECEC10B2E33FA85D9BB2_442130899 = (NfcActivityManager.this);
            {
                {
                    Iterator<NfcActivityState> varEFE357201C3481A24DEA8BA9CDFC72AB_898967551 = (mNfcState.values()).iterator();
                    varEFE357201C3481A24DEA8BA9CDFC72AB_898967551.hasNext();
                    NfcActivityState state = varEFE357201C3481A24DEA8BA9CDFC72AB_898967551.next();
                    {
                        {
                            callback = state.ndefMessageCallback;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            NdefMessage varF2F64E161428F81634C41B3E683B8D2A_2121373055 = (callback.createNdefMessage(mDefaultEvent));
        } //End block
        return (NdefMessage)dsTaint.getTaint();
        // ---------- Original Method ----------
        //NfcAdapter.CreateNdefMessageCallback callback = null;
        //synchronized (NfcActivityManager.this) {
            //for (NfcActivityState state : mNfcState.values()) {
                //if (state.resumed) {
                    //callback = state.ndefMessageCallback;
                //}
            //}
        //}
        //if (callback != null) {
            //return callback.createNdefMessage(mDefaultEvent);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.016 -0400", hash_original_method = "CE2F7F897A262F67EB6F40C6D613EBB1", hash_generated_method = "43E77C40A0C6C445AE477D18E7CC93BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onNdefPushComplete() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        NfcAdapter.OnNdefPushCompleteCallback callback;
        callback = null;
        {
            Object varEE293A251EFBECEC10B2E33FA85D9BB2_893021375 = (NfcActivityManager.this);
            {
                {
                    Iterator<NfcActivityState> varEFE357201C3481A24DEA8BA9CDFC72AB_1496699806 = (mNfcState.values()).iterator();
                    varEFE357201C3481A24DEA8BA9CDFC72AB_1496699806.hasNext();
                    NfcActivityState state = varEFE357201C3481A24DEA8BA9CDFC72AB_1496699806.next();
                    {
                        {
                            callback = state.onNdefPushCompleteCallback;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            callback.onNdefPushComplete(mDefaultEvent);
        } //End block
        // ---------- Original Method ----------
        //NfcAdapter.OnNdefPushCompleteCallback callback = null;
        //synchronized (NfcActivityManager.this) {
            //for (NfcActivityState state : mNfcState.values()) {
                //if (state.resumed) {
                    //callback = state.onNdefPushCompleteCallback;
                //}
            //}
        //}
        //if (callback != null) {
            //callback.onNdefPushComplete(mDefaultEvent);
        //}
    }

    
    class NfcActivityState {
        boolean resumed = false;
        NdefMessage ndefMessage;
        NfcAdapter.CreateNdefMessageCallback ndefMessageCallback;
        NfcAdapter.OnNdefPushCompleteCallback onNdefPushCompleteCallback;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.016 -0400", hash_original_method = "8FAA7967C18E367D434157F8ABD0B283", hash_generated_method = "8FAA7967C18E367D434157F8ABD0B283")
                public NfcActivityState ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.017 -0400", hash_original_method = "0458F1EA3F9A5785CA2A5D797EF2D2B7", hash_generated_method = "7D27EC647E1D88BD85C726221CFC80F6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            StringBuilder s;
            s = new StringBuilder("[").append(resumed).append(" ");
            s.append(ndefMessage).append(" ").append(ndefMessageCallback).append(" ");
            s.append(onNdefPushCompleteCallback).append("]");
            String varA1B485F703F905A168BAEB58087F4368_1587883751 = (s.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //StringBuilder s = new StringBuilder("[").append(resumed).append(" ");
            //s.append(ndefMessage).append(" ").append(ndefMessageCallback).append(" ");
            //s.append(onNdefPushCompleteCallback).append("]");
            //return s.toString();
        }

        
    }


    
    static final String TAG = NfcAdapter.TAG;
    static final Boolean DBG = false;
}

