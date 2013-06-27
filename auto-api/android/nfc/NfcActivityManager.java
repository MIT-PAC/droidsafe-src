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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.535 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "278F7851F6317C51C418D85323A63D34")

    NfcAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.535 -0400", hash_original_field = "866CA6554D67F1E845FDF39FC031D9C2", hash_generated_field = "5469BB6F258042FA572F1AF012C94830")

    WeakHashMap<Activity, NfcActivityState> mNfcState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.535 -0400", hash_original_field = "ED360624C39E70DEBB3F318754A66CCF", hash_generated_field = "F63991A177E6F1B31D60C851B30C7CA6")

    NfcEvent mDefaultEvent;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.536 -0400", hash_original_method = "38A6693B00F3F4C308A1D8C73B4DA266", hash_generated_method = "DB43FC8DD9E41252D6AFD9823834C23B")
    public  NfcActivityManager(NfcAdapter adapter) {
        mAdapter = adapter;
        mNfcState = new WeakHashMap<Activity, NfcActivityState>();
        mDefaultEvent = new NfcEvent(mAdapter);
        // ---------- Original Method ----------
        //mAdapter = adapter;
        //mNfcState = new WeakHashMap<Activity, NfcActivityState>();
        //mDefaultEvent = new NfcEvent(mAdapter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.550 -0400", hash_original_method = "5C41D3987D5608A9FF91B81AF91F1E3A", hash_generated_method = "73274082E6291182E534CDCDC87B0939")
    public synchronized void onResume(Activity activity) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        NfcActivityState state;
        state = mNfcState.get(activity);
        Log.d(TAG, "onResume() for " + activity + " " + state);
        {
            state.resumed = true;
            updateNfcService(state);
        } //End block
        addTaint(activity.getTaint());
        // ---------- Original Method ----------
        //NfcActivityState state = mNfcState.get(activity);
        //if (DBG) Log.d(TAG, "onResume() for " + activity + " " + state);
        //if (state != null) {
            //state.resumed = true;
            //updateNfcService(state);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.552 -0400", hash_original_method = "D5BF387644292151C2CC3D8E2C24ADB4", hash_generated_method = "CD0EA7F46DC9A8B62A6D7CD0CE9A9FED")
    public synchronized void onPause(Activity activity) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        NfcActivityState state;
        state = mNfcState.get(activity);
        Log.d(TAG, "onPause() for " + activity + " " + state);
        {
            state.resumed = false;
            updateNfcService(state);
        } //End block
        addTaint(activity.getTaint());
        // ---------- Original Method ----------
        //NfcActivityState state = mNfcState.get(activity);
        //if (DBG) Log.d(TAG, "onPause() for " + activity + " " + state);
        //if (state != null) {
            //state.resumed = false;
            //updateNfcService(state);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.565 -0400", hash_original_method = "24F6BFACBC4EE2930906E276E667EC5B", hash_generated_method = "B2DE5092CF55F71DB853F3160AAAC7F5")
    public void onDestroy(Activity activity) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mNfcState.remove(activity);
        addTaint(activity.getTaint());
        // ---------- Original Method ----------
        //mNfcState.remove(activity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.566 -0400", hash_original_method = "571064E533016906493F5781A338B8A8", hash_generated_method = "8CBFF8AB868D39D3A3F94CF098DBDA77")
    public synchronized void setNdefPushMessage(Activity activity, NdefMessage message) {
        NfcActivityState state;
        state = getOrCreateState(activity, message != null);
        state.ndefMessage = message;
        {
            maybeRemoveState(activity, state);
        } //End block
        {
            updateNfcService(state);
        } //End block
        addTaint(activity.getTaint());
        addTaint(message.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.588 -0400", hash_original_method = "8461A3F609F79E3AD7DBD099EE01C2BB", hash_generated_method = "ED49B2621DBAA3055C7CFD3A5D162677")
    public synchronized void setNdefPushMessageCallback(Activity activity,
            NfcAdapter.CreateNdefMessageCallback callback) {
        NfcActivityState state;
        state = getOrCreateState(activity, callback != null);
        state.ndefMessageCallback = callback;
        {
            maybeRemoveState(activity, state);
        } //End block
        {
            updateNfcService(state);
        } //End block
        addTaint(activity.getTaint());
        addTaint(callback.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.589 -0400", hash_original_method = "9383A81E53F319F7F82E3EAB1795FFCD", hash_generated_method = "D4D040520A42C214377C38BC1450BFDC")
    public synchronized void setOnNdefPushCompleteCallback(Activity activity,
            NfcAdapter.OnNdefPushCompleteCallback callback) {
        NfcActivityState state;
        state = getOrCreateState(activity, callback != null);
        state.onNdefPushCompleteCallback = callback;
        {
            maybeRemoveState(activity, state);
        } //End block
        {
            updateNfcService(state);
        } //End block
        addTaint(activity.getTaint());
        addTaint(callback.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.611 -0400", hash_original_method = "85DEBB165D0E03A5E3758750DB067F77", hash_generated_method = "2FDDC24679A943AF05310951BF803B39")
    synchronized NfcActivityState getOrCreateState(Activity activity, boolean create) {
        NfcActivityState varB4EAC82CA7396A68D541C85D26508E83_1976413644 = null; //Variable for return #1
        Log.d(TAG, "getOrCreateState " + activity + " " + create);
        NfcActivityState state;
        state = mNfcState.get(activity);
        {
            state = new NfcActivityState();
            mNfcState.put(activity, state);
            NfcFragment.attach(activity);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1976413644 = state;
        addTaint(activity.getTaint());
        addTaint(create);
        varB4EAC82CA7396A68D541C85D26508E83_1976413644.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1976413644;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.616 -0400", hash_original_method = "6C42916FD841C6EAFF0C495955BCFCAE", hash_generated_method = "B54FABD0FD59DB0368FA8E150506EA40")
    synchronized void maybeRemoveState(Activity activity, NfcActivityState state) {
        {
            NfcFragment.remove(activity);
            mNfcState.remove(activity);
        } //End block
        addTaint(activity.getTaint());
        addTaint(state.getTaint());
        // ---------- Original Method ----------
        //if (state.ndefMessage == null && state.ndefMessageCallback == null &&
                //state.onNdefPushCompleteCallback == null) {
            //NfcFragment.remove(activity);
            //mNfcState.remove(activity);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.618 -0400", hash_original_method = "6FB81CDE896F299C5469DD3DD94C1A99", hash_generated_method = "3A7F50BB87EF51B72DCA6FFFE5CDFE48")
    synchronized void updateNfcService(NfcActivityState state) {
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
        addTaint(state.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.716 -0400", hash_original_method = "3FF4E80952B14CA972EE064B02088076", hash_generated_method = "D1A564916A5CD346F6B1E8412ED29131")
    @Override
    public NdefMessage createMessage() {
        NdefMessage varB4EAC82CA7396A68D541C85D26508E83_1227223982 = null; //Variable for return #1
        NdefMessage varB4EAC82CA7396A68D541C85D26508E83_1404472078 = null; //Variable for return #2
        NfcAdapter.CreateNdefMessageCallback callback;
        callback = null;
        {
            Object varEE293A251EFBECEC10B2E33FA85D9BB2_1422117296 = (NfcActivityManager.this);
            {
                {
                    Iterator<NfcActivityState> varEFE357201C3481A24DEA8BA9CDFC72AB_689852686 = (mNfcState.values()).iterator();
                    varEFE357201C3481A24DEA8BA9CDFC72AB_689852686.hasNext();
                    NfcActivityState state = varEFE357201C3481A24DEA8BA9CDFC72AB_689852686.next();
                    {
                        {
                            callback = state.ndefMessageCallback;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            varB4EAC82CA7396A68D541C85D26508E83_1227223982 = callback.createNdefMessage(mDefaultEvent);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1404472078 = null;
        NdefMessage varA7E53CE21691AB073D9660D615818899_1480364384; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1480364384 = varB4EAC82CA7396A68D541C85D26508E83_1227223982;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1480364384 = varB4EAC82CA7396A68D541C85D26508E83_1404472078;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1480364384.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1480364384;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.793 -0400", hash_original_method = "CE2F7F897A262F67EB6F40C6D613EBB1", hash_generated_method = "03DE7679ECE7DED26D25761C3F624D2D")
    @Override
    public void onNdefPushComplete() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        NfcAdapter.OnNdefPushCompleteCallback callback;
        callback = null;
        {
            Object varEE293A251EFBECEC10B2E33FA85D9BB2_994251718 = (NfcActivityManager.this);
            {
                {
                    Iterator<NfcActivityState> varEFE357201C3481A24DEA8BA9CDFC72AB_1695316256 = (mNfcState.values()).iterator();
                    varEFE357201C3481A24DEA8BA9CDFC72AB_1695316256.hasNext();
                    NfcActivityState state = varEFE357201C3481A24DEA8BA9CDFC72AB_1695316256.next();
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.793 -0400", hash_original_field = "DD613B83DEA8C2A4F5BBF22F28AA4D7C", hash_generated_field = "FC09BA0B5D237866CCDEC966434CCE0D")

        boolean resumed = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.794 -0400", hash_original_field = "D58417D0066ADD8714887BBBE3EB3AFF", hash_generated_field = "5EFC654483C8286DD660EB3F60CEFD7D")

        NdefMessage ndefMessage;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.794 -0400", hash_original_field = "282402710023624C4A01AF13AAF3E85F", hash_generated_field = "31CC743A90A0F505CE2C991EF03A3ECF")

        NfcAdapter.CreateNdefMessageCallback ndefMessageCallback;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.794 -0400", hash_original_field = "68A3C4654BC44CF7318F6EE7458A74D3", hash_generated_field = "5465A7509AA4D952EF948BC541F48DC4")

        NfcAdapter.OnNdefPushCompleteCallback onNdefPushCompleteCallback;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.794 -0400", hash_original_method = "1126BF18A68478D666D07CED7ED74101", hash_generated_method = "1126BF18A68478D666D07CED7ED74101")
        public NfcActivityState ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.805 -0400", hash_original_method = "0458F1EA3F9A5785CA2A5D797EF2D2B7", hash_generated_method = "F9BCE6122A29723637A994B33543ECC1")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1689729602 = null; //Variable for return #1
            StringBuilder s;
            s = new StringBuilder("[").append(resumed).append(" ");
            s.append(ndefMessage).append(" ").append(ndefMessageCallback).append(" ");
            s.append(onNdefPushCompleteCallback).append("]");
            varB4EAC82CA7396A68D541C85D26508E83_1689729602 = s.toString();
            varB4EAC82CA7396A68D541C85D26508E83_1689729602.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1689729602;
            // ---------- Original Method ----------
            //StringBuilder s = new StringBuilder("[").append(resumed).append(" ");
            //s.append(ndefMessage).append(" ").append(ndefMessageCallback).append(" ");
            //s.append(onNdefPushCompleteCallback).append("]");
            //return s.toString();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.806 -0400", hash_original_field = "10324DBB4ACDB23E2264B213C8433ACA", hash_generated_field = "99D147BD1CD9AC12FFBDE32EF2041D51")

    static String TAG = NfcAdapter.TAG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.806 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "57B699427C018442E5BD7DF6A7686721")

    static Boolean DBG = false;
}

