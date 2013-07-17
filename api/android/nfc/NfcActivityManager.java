package android.nfc;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.app.Activity;
import android.os.RemoteException;
import android.util.Log;
import java.util.WeakHashMap;

public final class NfcActivityManager extends INdefPushCallback.Stub {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.151 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "278F7851F6317C51C418D85323A63D34")

    NfcAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.152 -0400", hash_original_field = "866CA6554D67F1E845FDF39FC031D9C2", hash_generated_field = "5469BB6F258042FA572F1AF012C94830")

    WeakHashMap<Activity, NfcActivityState> mNfcState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.152 -0400", hash_original_field = "ED360624C39E70DEBB3F318754A66CCF", hash_generated_field = "F63991A177E6F1B31D60C851B30C7CA6")

    NfcEvent mDefaultEvent;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.153 -0400", hash_original_method = "38A6693B00F3F4C308A1D8C73B4DA266", hash_generated_method = "DB43FC8DD9E41252D6AFD9823834C23B")
    public  NfcActivityManager(NfcAdapter adapter) {
        mAdapter = adapter;
        mNfcState = new WeakHashMap<Activity, NfcActivityState>();
        mDefaultEvent = new NfcEvent(mAdapter);
        // ---------- Original Method ----------
        //mAdapter = adapter;
        //mNfcState = new WeakHashMap<Activity, NfcActivityState>();
        //mDefaultEvent = new NfcEvent(mAdapter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.154 -0400", hash_original_method = "5C41D3987D5608A9FF91B81AF91F1E3A", hash_generated_method = "8CBA06F59E64FC7A1AC23E007E5E78E0")
    public synchronized void onResume(Activity activity) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(activity.getTaint());
        NfcActivityState state = mNfcState.get(activity);
        if(DBG)        
        Log.d(TAG, "onResume() for " + activity + " " + state);
        if(state != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.155 -0400", hash_original_method = "D5BF387644292151C2CC3D8E2C24ADB4", hash_generated_method = "EEE278893F4035E574858BA9B64B2E13")
    public synchronized void onPause(Activity activity) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(activity.getTaint());
        NfcActivityState state = mNfcState.get(activity);
        if(DBG)        
        Log.d(TAG, "onPause() for " + activity + " " + state);
        if(state != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.156 -0400", hash_original_method = "24F6BFACBC4EE2930906E276E667EC5B", hash_generated_method = "4A8123AC391525294F63D26E628E0F01")
    public void onDestroy(Activity activity) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(activity.getTaint());
        mNfcState.remove(activity);
        // ---------- Original Method ----------
        //mNfcState.remove(activity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.157 -0400", hash_original_method = "571064E533016906493F5781A338B8A8", hash_generated_method = "F0D88C943721FE5BC1026FA4231035BC")
    public synchronized void setNdefPushMessage(Activity activity, NdefMessage message) {
        addTaint(message.getTaint());
        addTaint(activity.getTaint());
        NfcActivityState state = getOrCreateState(activity, message != null);
        if(state == null || state.ndefMessage == message)        
        {
            return;
        } //End block
        state.ndefMessage = message;
        if(message == null)        
        {
            maybeRemoveState(activity, state);
        } //End block
        if(state.resumed)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.159 -0400", hash_original_method = "8461A3F609F79E3AD7DBD099EE01C2BB", hash_generated_method = "EED3D819A411449465DD655835F4C29C")
    public synchronized void setNdefPushMessageCallback(Activity activity,
            NfcAdapter.CreateNdefMessageCallback callback) {
        addTaint(callback.getTaint());
        addTaint(activity.getTaint());
        NfcActivityState state = getOrCreateState(activity, callback != null);
        if(state == null || state.ndefMessageCallback == callback)        
        {
            return;
        } //End block
        state.ndefMessageCallback = callback;
        if(callback == null)        
        {
            maybeRemoveState(activity, state);
        } //End block
        if(state.resumed)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.160 -0400", hash_original_method = "9383A81E53F319F7F82E3EAB1795FFCD", hash_generated_method = "95B9CCE398BE3CC4704E5BB9400C9C50")
    public synchronized void setOnNdefPushCompleteCallback(Activity activity,
            NfcAdapter.OnNdefPushCompleteCallback callback) {
        addTaint(callback.getTaint());
        addTaint(activity.getTaint());
        NfcActivityState state = getOrCreateState(activity, callback != null);
        if(state == null || state.onNdefPushCompleteCallback == callback)        
        {
            return;
        } //End block
        state.onNdefPushCompleteCallback = callback;
        if(callback == null)        
        {
            maybeRemoveState(activity, state);
        } //End block
        if(state.resumed)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.162 -0400", hash_original_method = "85DEBB165D0E03A5E3758750DB067F77", hash_generated_method = "9EB1CD69C6A8EAFB6E51A98886AFEFB1")
    synchronized NfcActivityState getOrCreateState(Activity activity, boolean create) {
        addTaint(create);
        addTaint(activity.getTaint());
        if(DBG)        
        Log.d(TAG, "getOrCreateState " + activity + " " + create);
        NfcActivityState state = mNfcState.get(activity);
        if(state == null && create)        
        {
            state = new NfcActivityState();
            mNfcState.put(activity, state);
            NfcFragment.attach(activity);
        } //End block
NfcActivityState var37C56C9D63C623261861C16DCFB73F6D_733349524 =         state;
        var37C56C9D63C623261861C16DCFB73F6D_733349524.addTaint(taint);
        return var37C56C9D63C623261861C16DCFB73F6D_733349524;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.163 -0400", hash_original_method = "6C42916FD841C6EAFF0C495955BCFCAE", hash_generated_method = "9C3B331A29A3BDB060F715EA3421E2C9")
    synchronized void maybeRemoveState(Activity activity, NfcActivityState state) {
        addTaint(state.getTaint());
        addTaint(activity.getTaint());
        if(state.ndefMessage == null && state.ndefMessageCallback == null &&
                state.onNdefPushCompleteCallback == null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.164 -0400", hash_original_method = "6FB81CDE896F299C5469DD3DD94C1A99", hash_generated_method = "9E2929CF5018CC8542F029BF8E368F73")
    synchronized void updateNfcService(NfcActivityState state) {
        addTaint(state.getTaint());
        boolean serviceCallbackNeeded = state.ndefMessageCallback != null ||
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.165 -0400", hash_original_method = "3FF4E80952B14CA972EE064B02088076", hash_generated_method = "3CE66222EE896E03F54A12AB1B6D9867")
    @Override
    public NdefMessage createMessage() {
        NfcAdapter.CreateNdefMessageCallback callback = null;
        synchronized
(NfcActivityManager.this)        {
for(NfcActivityState state : mNfcState.values())
            {
                if(state.resumed)                
                {
                    callback = state.ndefMessageCallback;
                } //End block
            } //End block
        } //End block
        if(callback != null)        
        {
NdefMessage varEC3FE78352E5CBE6ABB40477808F3F4A_1171580597 =             callback.createNdefMessage(mDefaultEvent);
            varEC3FE78352E5CBE6ABB40477808F3F4A_1171580597.addTaint(taint);
            return varEC3FE78352E5CBE6ABB40477808F3F4A_1171580597;
        } //End block
NdefMessage var540C13E9E156B687226421B24F2DF178_167707578 =         null;
        var540C13E9E156B687226421B24F2DF178_167707578.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_167707578;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.165 -0400", hash_original_method = "CE2F7F897A262F67EB6F40C6D613EBB1", hash_generated_method = "F8393249C67CA1BE55BE9BF79A15BB10")
    @Override
    public void onNdefPushComplete() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        NfcAdapter.OnNdefPushCompleteCallback callback = null;
        synchronized
(NfcActivityManager.this)        {
for(NfcActivityState state : mNfcState.values())
            {
                if(state.resumed)                
                {
                    callback = state.onNdefPushCompleteCallback;
                } //End block
            } //End block
        } //End block
        if(callback != null)        
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.166 -0400", hash_original_field = "DD613B83DEA8C2A4F5BBF22F28AA4D7C", hash_generated_field = "FC09BA0B5D237866CCDEC966434CCE0D")

        boolean resumed = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.166 -0400", hash_original_field = "D58417D0066ADD8714887BBBE3EB3AFF", hash_generated_field = "5EFC654483C8286DD660EB3F60CEFD7D")

        NdefMessage ndefMessage;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.166 -0400", hash_original_field = "282402710023624C4A01AF13AAF3E85F", hash_generated_field = "31CC743A90A0F505CE2C991EF03A3ECF")

        NfcAdapter.CreateNdefMessageCallback ndefMessageCallback;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.166 -0400", hash_original_field = "68A3C4654BC44CF7318F6EE7458A74D3", hash_generated_field = "5465A7509AA4D952EF948BC541F48DC4")

        NfcAdapter.OnNdefPushCompleteCallback onNdefPushCompleteCallback;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.166 -0400", hash_original_method = "1126BF18A68478D666D07CED7ED74101", hash_generated_method = "1126BF18A68478D666D07CED7ED74101")
        public NfcActivityState ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.167 -0400", hash_original_method = "0458F1EA3F9A5785CA2A5D797EF2D2B7", hash_generated_method = "5EBC3CCF76FB66D0AC6999C181441CD2")
        @Override
        public String toString() {
            StringBuilder s = new StringBuilder("[").append(resumed).append(" ");
            s.append(ndefMessage).append(" ").append(ndefMessageCallback).append(" ");
            s.append(onNdefPushCompleteCallback).append("]");
String varDE99EC39359AC6BE0E416433FFBB9F13_163076499 =             s.toString();
            varDE99EC39359AC6BE0E416433FFBB9F13_163076499.addTaint(taint);
            return varDE99EC39359AC6BE0E416433FFBB9F13_163076499;
            // ---------- Original Method ----------
            //StringBuilder s = new StringBuilder("[").append(resumed).append(" ");
            //s.append(ndefMessage).append(" ").append(ndefMessageCallback).append(" ");
            //s.append(onNdefPushCompleteCallback).append("]");
            //return s.toString();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.167 -0400", hash_original_field = "10324DBB4ACDB23E2264B213C8433ACA", hash_generated_field = "1CCFC0E09744FE65F20D7FAA18F3A6FD")

    static final String TAG = NfcAdapter.TAG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.167 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "11521ED4D706D9B29918B8254968F6E4")

    static final Boolean DBG = false;
}

