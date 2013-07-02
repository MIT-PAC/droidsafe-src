package android.nfc;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.app.Activity;
import android.os.RemoteException;
import android.util.Log;
import java.util.WeakHashMap;

public final class NfcActivityManager extends INdefPushCallback.Stub {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.092 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "278F7851F6317C51C418D85323A63D34")

    NfcAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.092 -0400", hash_original_field = "866CA6554D67F1E845FDF39FC031D9C2", hash_generated_field = "5469BB6F258042FA572F1AF012C94830")

    WeakHashMap<Activity, NfcActivityState> mNfcState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.092 -0400", hash_original_field = "ED360624C39E70DEBB3F318754A66CCF", hash_generated_field = "F63991A177E6F1B31D60C851B30C7CA6")

    NfcEvent mDefaultEvent;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.092 -0400", hash_original_method = "38A6693B00F3F4C308A1D8C73B4DA266", hash_generated_method = "DB43FC8DD9E41252D6AFD9823834C23B")
    public  NfcActivityManager(NfcAdapter adapter) {
        mAdapter = adapter;
        mNfcState = new WeakHashMap<Activity, NfcActivityState>();
        mDefaultEvent = new NfcEvent(mAdapter);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.093 -0400", hash_original_method = "5C41D3987D5608A9FF91B81AF91F1E3A", hash_generated_method = "314962A6035C81C717F749966E4280B7")
    public synchronized void onResume(Activity activity) {
        
        NfcActivityState state = mNfcState.get(activity);
        Log.d(TAG, "onResume() for " + activity + " " + state);
        {
            state.resumed = true;
            updateNfcService(state);
        } 
        addTaint(activity.getTaint());
        
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.093 -0400", hash_original_method = "D5BF387644292151C2CC3D8E2C24ADB4", hash_generated_method = "E91C48EB1F6B80BDF09642295B9B2F73")
    public synchronized void onPause(Activity activity) {
        
        NfcActivityState state = mNfcState.get(activity);
        Log.d(TAG, "onPause() for " + activity + " " + state);
        {
            state.resumed = false;
            updateNfcService(state);
        } 
        addTaint(activity.getTaint());
        
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.094 -0400", hash_original_method = "24F6BFACBC4EE2930906E276E667EC5B", hash_generated_method = "B2DE5092CF55F71DB853F3160AAAC7F5")
    public void onDestroy(Activity activity) {
        
        mNfcState.remove(activity);
        addTaint(activity.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.094 -0400", hash_original_method = "571064E533016906493F5781A338B8A8", hash_generated_method = "4EF6F3460087CE18D27FEE172BB73387")
    public synchronized void setNdefPushMessage(Activity activity, NdefMessage message) {
        NfcActivityState state = getOrCreateState(activity, message != null);
        state.ndefMessage = message;
        {
            maybeRemoveState(activity, state);
        } 
        {
            updateNfcService(state);
        } 
        addTaint(activity.getTaint());
        addTaint(message.getTaint());
        
        
        
            
        
        
        
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.095 -0400", hash_original_method = "8461A3F609F79E3AD7DBD099EE01C2BB", hash_generated_method = "E82961A304F86B7EFCEF1D0AD535A2D5")
    public synchronized void setNdefPushMessageCallback(Activity activity,
            NfcAdapter.CreateNdefMessageCallback callback) {
        NfcActivityState state = getOrCreateState(activity, callback != null);
        state.ndefMessageCallback = callback;
        {
            maybeRemoveState(activity, state);
        } 
        {
            updateNfcService(state);
        } 
        addTaint(activity.getTaint());
        addTaint(callback.getTaint());
        
        
        
            
        
        
        
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.096 -0400", hash_original_method = "9383A81E53F319F7F82E3EAB1795FFCD", hash_generated_method = "813A5FB0A4393843E5B387AB49DE8299")
    public synchronized void setOnNdefPushCompleteCallback(Activity activity,
            NfcAdapter.OnNdefPushCompleteCallback callback) {
        NfcActivityState state = getOrCreateState(activity, callback != null);
        state.onNdefPushCompleteCallback = callback;
        {
            maybeRemoveState(activity, state);
        } 
        {
            updateNfcService(state);
        } 
        addTaint(activity.getTaint());
        addTaint(callback.getTaint());
        
        
        
            
        
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.096 -0400", hash_original_method = "85DEBB165D0E03A5E3758750DB067F77", hash_generated_method = "490E2875A1D7EF47506CEA2E019148C9")
    synchronized NfcActivityState getOrCreateState(Activity activity, boolean create) {
        NfcActivityState varB4EAC82CA7396A68D541C85D26508E83_1618230262 = null; 
        Log.d(TAG, "getOrCreateState " + activity + " " + create);
        NfcActivityState state = mNfcState.get(activity);
        {
            state = new NfcActivityState();
            mNfcState.put(activity, state);
            NfcFragment.attach(activity);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1618230262 = state;
        addTaint(activity.getTaint());
        addTaint(create);
        varB4EAC82CA7396A68D541C85D26508E83_1618230262.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1618230262;
        
        
        
        
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.097 -0400", hash_original_method = "6C42916FD841C6EAFF0C495955BCFCAE", hash_generated_method = "B54FABD0FD59DB0368FA8E150506EA40")
    synchronized void maybeRemoveState(Activity activity, NfcActivityState state) {
        {
            NfcFragment.remove(activity);
            mNfcState.remove(activity);
        } 
        addTaint(activity.getTaint());
        addTaint(state.getTaint());
        
        
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.097 -0400", hash_original_method = "6FB81CDE896F299C5469DD3DD94C1A99", hash_generated_method = "76D0B894267868B2CA6E718F3BD11784")
    synchronized void updateNfcService(NfcActivityState state) {
        boolean serviceCallbackNeeded = state.ndefMessageCallback != null ||
                state.onNdefPushCompleteCallback != null;
        try 
        {
            NfcAdapter.sService.setForegroundNdefPush(state.resumed ? state.ndefMessage : null,
                    state.resumed && serviceCallbackNeeded ? this : null);
        } 
        catch (RemoteException e)
        {
            mAdapter.attemptDeadServiceRecovery(e);
        } 
        addTaint(state.getTaint());
        
        
                
        
            
                    
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.103 -0400", hash_original_method = "3FF4E80952B14CA972EE064B02088076", hash_generated_method = "BA22802A4B4FDBA0349310EDEAFC7FFF")
    @Override
    public NdefMessage createMessage() {
        NdefMessage varB4EAC82CA7396A68D541C85D26508E83_1764447395 = null; 
        NdefMessage varB4EAC82CA7396A68D541C85D26508E83_2025901280 = null; 
        NfcAdapter.CreateNdefMessageCallback callback = null;
        {
            Object varEE293A251EFBECEC10B2E33FA85D9BB2_262422480 = (NfcActivityManager.this);
            {
                {
                    Iterator<NfcActivityState> varEFE357201C3481A24DEA8BA9CDFC72AB_854661022 = (mNfcState.values()).iterator();
                    varEFE357201C3481A24DEA8BA9CDFC72AB_854661022.hasNext();
                    NfcActivityState state = varEFE357201C3481A24DEA8BA9CDFC72AB_854661022.next();
                    {
                        {
                            callback = state.ndefMessageCallback;
                        } 
                    } 
                } 
            } 
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1764447395 = callback.createNdefMessage(mDefaultEvent);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2025901280 = null;
        NdefMessage varA7E53CE21691AB073D9660D615818899_1047222740; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1047222740 = varB4EAC82CA7396A68D541C85D26508E83_1764447395;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1047222740 = varB4EAC82CA7396A68D541C85D26508E83_2025901280;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1047222740.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1047222740;
        
        
        
            
                
                    
                
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.111 -0400", hash_original_method = "CE2F7F897A262F67EB6F40C6D613EBB1", hash_generated_method = "1886A4FB04AACBF1C08C95A449E46AC4")
    @Override
    public void onNdefPushComplete() {
        
        NfcAdapter.OnNdefPushCompleteCallback callback = null;
        {
            Object varEE293A251EFBECEC10B2E33FA85D9BB2_843745495 = (NfcActivityManager.this);
            {
                {
                    Iterator<NfcActivityState> varEFE357201C3481A24DEA8BA9CDFC72AB_1255592262 = (mNfcState.values()).iterator();
                    varEFE357201C3481A24DEA8BA9CDFC72AB_1255592262.hasNext();
                    NfcActivityState state = varEFE357201C3481A24DEA8BA9CDFC72AB_1255592262.next();
                    {
                        {
                            callback = state.onNdefPushCompleteCallback;
                        } 
                    } 
                } 
            } 
        } 
        {
            callback.onNdefPushComplete(mDefaultEvent);
        } 
        
        
        
            
                
                    
                
            
        
        
            
        
    }

    
    class NfcActivityState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.111 -0400", hash_original_field = "DD613B83DEA8C2A4F5BBF22F28AA4D7C", hash_generated_field = "FC09BA0B5D237866CCDEC966434CCE0D")

        boolean resumed = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.111 -0400", hash_original_field = "D58417D0066ADD8714887BBBE3EB3AFF", hash_generated_field = "5EFC654483C8286DD660EB3F60CEFD7D")

        NdefMessage ndefMessage;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.111 -0400", hash_original_field = "282402710023624C4A01AF13AAF3E85F", hash_generated_field = "31CC743A90A0F505CE2C991EF03A3ECF")

        NfcAdapter.CreateNdefMessageCallback ndefMessageCallback;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.111 -0400", hash_original_field = "68A3C4654BC44CF7318F6EE7458A74D3", hash_generated_field = "5465A7509AA4D952EF948BC541F48DC4")

        NfcAdapter.OnNdefPushCompleteCallback onNdefPushCompleteCallback;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.111 -0400", hash_original_method = "1126BF18A68478D666D07CED7ED74101", hash_generated_method = "1126BF18A68478D666D07CED7ED74101")
        public NfcActivityState ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.112 -0400", hash_original_method = "0458F1EA3F9A5785CA2A5D797EF2D2B7", hash_generated_method = "ED407405C21CF74632C8287978BD9618")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1360006588 = null; 
            StringBuilder s = new StringBuilder("[").append(resumed).append(" ");
            s.append(ndefMessage).append(" ").append(ndefMessageCallback).append(" ");
            s.append(onNdefPushCompleteCallback).append("]");
            varB4EAC82CA7396A68D541C85D26508E83_1360006588 = s.toString();
            varB4EAC82CA7396A68D541C85D26508E83_1360006588.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1360006588;
            
            
            
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.112 -0400", hash_original_field = "10324DBB4ACDB23E2264B213C8433ACA", hash_generated_field = "1CCFC0E09744FE65F20D7FAA18F3A6FD")

    static final String TAG = NfcAdapter.TAG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.112 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "11521ED4D706D9B29918B8254968F6E4")

    static final Boolean DBG = false;
}

