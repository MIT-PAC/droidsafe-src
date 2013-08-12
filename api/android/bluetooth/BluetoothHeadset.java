package android.bluetooth;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.List;

import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;



public final class BluetoothHeadset implements BluetoothProfile {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.271 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.271 -0400", hash_original_field = "CA257FD83AF4C9E6C265E05B6CDBF2DD", hash_generated_field = "6FCEA0ED39BC377BA765F514A42DFCE9")

    private ServiceListener mServiceListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.271 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "79B3CF63B286D2E971AC334B507D5268")

    private IBluetoothHeadset mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.271 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "367F0BC6BC216C571A7E906A286477DF")

    BluetoothAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.273 -0400", hash_original_field = "23D4610316C4691B804316E58CB7E31E", hash_generated_field = "B1E39DD343E537E31D2D451F2E1E8203")

    private ServiceConnection mConnection = new ServiceConnection() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.272 -0400", hash_original_method = "49B1367FF57AEC89B6CC00CC921EF188", hash_generated_method = "532E4A3B79937596CBCD7192F81D6D7F")
        public void onServiceConnected(ComponentName className, IBinder service) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(service.getTaint());
            addTaint(className.getTaint());
            if(DBG)            
            Log.d(TAG, "Proxy object connected");
            mService = IBluetoothHeadset.Stub.asInterface(service);
            if(mServiceListener != null)            
            {
                mServiceListener.onServiceConnected(BluetoothProfile.HEADSET, BluetoothHeadset.this);
            } //End block
            // ---------- Original Method ----------
            //if (DBG) Log.d(TAG, "Proxy object connected");
            //mService = IBluetoothHeadset.Stub.asInterface(service);
            //if (mServiceListener != null) {
                //mServiceListener.onServiceConnected(BluetoothProfile.HEADSET, BluetoothHeadset.this);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.273 -0400", hash_original_method = "5E9993D21DC5F46D871DD6D0C9DF0475", hash_generated_method = "7DBE42B6E64652795380B3C13EBF01B1")
        public void onServiceDisconnected(ComponentName className) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(className.getTaint());
            if(DBG)            
            Log.d(TAG, "Proxy object disconnected");
            mService = null;
            if(mServiceListener != null)            
            {
                mServiceListener.onServiceDisconnected(BluetoothProfile.HEADSET);
            } //End block
            // ---------- Original Method ----------
            //if (DBG) Log.d(TAG, "Proxy object disconnected");
            //mService = null;
            //if (mServiceListener != null) {
                //mServiceListener.onServiceDisconnected(BluetoothProfile.HEADSET);
            //}
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.274 -0400", hash_original_method = "B2E3A495C7EEB290E3194E45B33ED96D", hash_generated_method = "52FEF32AEBCAC4D7A8F3BB472E85F97E")
      BluetoothHeadset(Context context, ServiceListener l) {
        mContext = context;
        mServiceListener = l;
        mAdapter = BluetoothAdapter.getDefaultAdapter();
        if(!context.bindService(new Intent(IBluetoothHeadset.class.getName()), mConnection, 0))        
        {
        } //End block
        // ---------- Original Method ----------
        //mContext = context;
        //mServiceListener = l;
        //mAdapter = BluetoothAdapter.getDefaultAdapter();
        //if (!context.bindService(new Intent(IBluetoothHeadset.class.getName()), mConnection, 0)) {
            //Log.e(TAG, "Could not bind to Bluetooth Headset Service");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.275 -0400", hash_original_method = "072F8B79FA7D55AD4D16BF2975AA6259", hash_generated_method = "6DF1504F89700C5086B3540A658448C4")
    synchronized void close() {
        if(DBG)        
        log("close()");
        if(mConnection != null)        
        {
            mContext.unbindService(mConnection);
            mConnection = null;
        } //End block
        mServiceListener = null;
        // ---------- Original Method ----------
        //if (DBG) log("close()");
        //if (mConnection != null) {
            //mContext.unbindService(mConnection);
            //mConnection = null;
        //}
        //mServiceListener = null;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.276 -0400", hash_original_method = "7284EC53ABB82E4A2B97F7B894F0105F", hash_generated_method = "98BABF203BED510AB35336B20F6E50ED")
    public boolean connect(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(DBG)        
        log("connect(" + device + ")");
        if(mService != null && isEnabled() &&
            isValidDevice(device))        
        {
            try 
            {
                boolean varEBACDF479EAFFE2AD53D5370B5C3FBBE_1495628604 = (mService.connect(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1559717342 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1559717342;
            } //End block
            catch (RemoteException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_1295998440 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_345232761 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_345232761;
            } //End block
        } //End block
        if(mService == null){ }        boolean var68934A3E9455FA72420237EB05902327_1344499685 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_281086236 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_281086236;
        // ---------- Original Method ----------
        //if (DBG) log("connect(" + device + ")");
        //if (mService != null && isEnabled() &&
            //isValidDevice(device)) {
            //try {
                //return mService.connect(device);
            //} catch (RemoteException e) {
                //Log.e(TAG, Log.getStackTraceString(new Throwable()));
                //return false;
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.277 -0400", hash_original_method = "4AB2501852FA35F2A69CDF567F29169A", hash_generated_method = "0AE802CEB7DFA7B4A6BD09E2A334885A")
    public boolean disconnect(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(DBG)        
        log("disconnect(" + device + ")");
        if(mService != null && isEnabled() &&
            isValidDevice(device))        
        {
            try 
            {
                boolean var42FFDFE107D001E4DD32E59464767CFF_681671438 = (mService.disconnect(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1739648936 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1739648936;
            } //End block
            catch (RemoteException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_15832844 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_774960171 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_774960171;
            } //End block
        } //End block
        if(mService == null){ }        boolean var68934A3E9455FA72420237EB05902327_401034254 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1276030048 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1276030048;
        // ---------- Original Method ----------
        //if (DBG) log("disconnect(" + device + ")");
        //if (mService != null && isEnabled() &&
            //isValidDevice(device)) {
            //try {
                //return mService.disconnect(device);
            //} catch (RemoteException e) {
              //Log.e(TAG, Log.getStackTraceString(new Throwable()));
              //return false;
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.278 -0400", hash_original_method = "49C359566F3934D08711C62C957BAB9A", hash_generated_method = "E71EFA232D69E5218DE3C5E08161C465")
    public List<BluetoothDevice> getConnectedDevices() {
        if(DBG)        
        log("getConnectedDevices()");
        if(mService != null && isEnabled())        
        {
            try 
            {
List<BluetoothDevice> var0CBC70B0F206DDA9ED876FF389D40D78_1377051657 =                 mService.getConnectedDevices();
                var0CBC70B0F206DDA9ED876FF389D40D78_1377051657.addTaint(taint);
                return var0CBC70B0F206DDA9ED876FF389D40D78_1377051657;
            } //End block
            catch (RemoteException e)
            {
List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1623986723 =                 new ArrayList<BluetoothDevice>();
                var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1623986723.addTaint(taint);
                return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1623986723;
            } //End block
        } //End block
        if(mService == null){ }List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_813342681 =         new ArrayList<BluetoothDevice>();
        var0DD13883ABBA5DF8AB8CAFEE38A3B82C_813342681.addTaint(taint);
        return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_813342681;
        // ---------- Original Method ----------
        //if (DBG) log("getConnectedDevices()");
        //if (mService != null && isEnabled()) {
            //try {
                //return mService.getConnectedDevices();
            //} catch (RemoteException e) {
                //Log.e(TAG, Log.getStackTraceString(new Throwable()));
                //return new ArrayList<BluetoothDevice>();
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return new ArrayList<BluetoothDevice>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.279 -0400", hash_original_method = "E177F9FA262CA684CC709DA528C57F1A", hash_generated_method = "67EF29262ACD68CE9007D89AEEA9BB85")
    public List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] states) {
        addTaint(states[0]);
        if(DBG)        
        log("getDevicesMatchingStates()");
        if(mService != null && isEnabled())        
        {
            try 
            {
List<BluetoothDevice> varD888D9FBE2025148D0FB51CF8CEE87E5_1686781984 =                 mService.getDevicesMatchingConnectionStates(states);
                varD888D9FBE2025148D0FB51CF8CEE87E5_1686781984.addTaint(taint);
                return varD888D9FBE2025148D0FB51CF8CEE87E5_1686781984;
            } //End block
            catch (RemoteException e)
            {
List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_135315742 =                 new ArrayList<BluetoothDevice>();
                var0DD13883ABBA5DF8AB8CAFEE38A3B82C_135315742.addTaint(taint);
                return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_135315742;
            } //End block
        } //End block
        if(mService == null){ }List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1275823069 =         new ArrayList<BluetoothDevice>();
        var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1275823069.addTaint(taint);
        return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1275823069;
        // ---------- Original Method ----------
        //if (DBG) log("getDevicesMatchingStates()");
        //if (mService != null && isEnabled()) {
            //try {
                //return mService.getDevicesMatchingConnectionStates(states);
            //} catch (RemoteException e) {
                //Log.e(TAG, Log.getStackTraceString(new Throwable()));
                //return new ArrayList<BluetoothDevice>();
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return new ArrayList<BluetoothDevice>();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.280 -0400", hash_original_method = "1FDB9A860CA32B38F33F04C33CC0DC9B", hash_generated_method = "99425EDFD9D8BEEB05C6FC146DEFFEB2")
    public int getConnectionState(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(DBG)        
        log("getConnectionState(" + device + ")");
        if(mService != null && isEnabled() &&
            isValidDevice(device))        
        {
            try 
            {
                int var8DA78526B41CCAC0FE35CC7431643446_1636530309 = (mService.getConnectionState(device));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1808292791 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1808292791;
            } //End block
            catch (RemoteException e)
            {
                int var6DC267D6C0363C5B94F222673460F45F_315713978 = (BluetoothProfile.STATE_DISCONNECTED);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1359481891 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1359481891;
            } //End block
        } //End block
        if(mService == null){ }        int var6DC267D6C0363C5B94F222673460F45F_547919830 = (BluetoothProfile.STATE_DISCONNECTED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_239863898 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_239863898;
        // ---------- Original Method ----------
        //if (DBG) log("getConnectionState(" + device + ")");
        //if (mService != null && isEnabled() &&
            //isValidDevice(device)) {
            //try {
                //return mService.getConnectionState(device);
            //} catch (RemoteException e) {
                //Log.e(TAG, Log.getStackTraceString(new Throwable()));
                //return BluetoothProfile.STATE_DISCONNECTED;
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return BluetoothProfile.STATE_DISCONNECTED;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.281 -0400", hash_original_method = "F982CE0C4DEC9189A14DF4553C949192", hash_generated_method = "757D2D1CBB5FE3F91437EA80F8E58CA9")
    public boolean setPriority(BluetoothDevice device, int priority) {
        addTaint(priority);
        addTaint(device.getTaint());
        if(DBG)        
        log("setPriority(" + device + ", " + priority + ")");
        if(mService != null && isEnabled() &&
            isValidDevice(device))        
        {
            if(priority != BluetoothProfile.PRIORITY_OFF &&
                priority != BluetoothProfile.PRIORITY_ON)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1734704078 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2076164659 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2076164659;
            } //End block
            try 
            {
                boolean varC080112B655E626AEC73393AE044B4DD_499260418 = (mService.setPriority(device, priority));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_703637316 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_703637316;
            } //End block
            catch (RemoteException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_2106210488 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_102695912 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_102695912;
            } //End block
        } //End block
        if(mService == null){ }        boolean var68934A3E9455FA72420237EB05902327_576496515 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_771052206 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_771052206;
        // ---------- Original Method ----------
        //if (DBG) log("setPriority(" + device + ", " + priority + ")");
        //if (mService != null && isEnabled() &&
            //isValidDevice(device)) {
            //if (priority != BluetoothProfile.PRIORITY_OFF &&
                //priority != BluetoothProfile.PRIORITY_ON) {
              //return false;
            //}
            //try {
                //return mService.setPriority(device, priority);
            //} catch (RemoteException e) {
                //Log.e(TAG, Log.getStackTraceString(new Throwable()));
                //return false;
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.283 -0400", hash_original_method = "705F88F05E8E78847084743E12D945BD", hash_generated_method = "664E06B46C9D09F708EDE5F8CFD86F6E")
    public int getPriority(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(DBG)        
        log("getPriority(" + device + ")");
        if(mService != null && isEnabled() &&
            isValidDevice(device))        
        {
            try 
            {
                int var989DD7E44FB699D3F65CF049678ECBF2_1565024950 = (mService.getPriority(device));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_908145444 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_908145444;
            } //End block
            catch (RemoteException e)
            {
                int var3FE1174696877420FC87F195627E2B08_1065402220 = (PRIORITY_OFF);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_750491428 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_750491428;
            } //End block
        } //End block
        if(mService == null){ }        int var3FE1174696877420FC87F195627E2B08_705811590 = (PRIORITY_OFF);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_480926820 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_480926820;
        // ---------- Original Method ----------
        //if (DBG) log("getPriority(" + device + ")");
        //if (mService != null && isEnabled() &&
            //isValidDevice(device)) {
            //try {
                //return mService.getPriority(device);
            //} catch (RemoteException e) {
                //Log.e(TAG, Log.getStackTraceString(new Throwable()));
                //return PRIORITY_OFF;
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return PRIORITY_OFF;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.285 -0400", hash_original_method = "27AD2A5F99F8BC607BCDEC817A66E20B", hash_generated_method = "2DAB3DD6B4B64781664536958FE2E9B7")
    public boolean startVoiceRecognition(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(DBG)        
        log("startVoiceRecognition()");
        if(mService != null && isEnabled() &&
            isValidDevice(device))        
        {
            try 
            {
                boolean var2E6278F99540BCA7BB6D7FB7EDBA4B95_1065530319 = (mService.startVoiceRecognition(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_144410604 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_144410604;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        if(mService == null){ }        boolean var68934A3E9455FA72420237EB05902327_1578333720 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_327404773 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_327404773;
        // ---------- Original Method ----------
        //if (DBG) log("startVoiceRecognition()");
        //if (mService != null && isEnabled() &&
            //isValidDevice(device)) {
            //try {
                //return mService.startVoiceRecognition(device);
            //} catch (RemoteException e) {
                //Log.e(TAG,  Log.getStackTraceString(new Throwable()));
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.287 -0400", hash_original_method = "9C079C73E681F82F25C06C8EF6915217", hash_generated_method = "6A8C767DFE3C27AF9F6261BFDF43D8CC")
    public boolean stopVoiceRecognition(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(DBG)        
        log("stopVoiceRecognition()");
        if(mService != null && isEnabled() &&
            isValidDevice(device))        
        {
            try 
            {
                boolean var3E7D8B85DCC3BFD70D55B81AD1DA2A5A_2051105802 = (mService.stopVoiceRecognition(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1423594259 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1423594259;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        if(mService == null){ }        boolean var68934A3E9455FA72420237EB05902327_1085566751 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2071222871 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2071222871;
        // ---------- Original Method ----------
        //if (DBG) log("stopVoiceRecognition()");
        //if (mService != null && isEnabled() &&
            //isValidDevice(device)) {
            //try {
                //return mService.stopVoiceRecognition(device);
            //} catch (RemoteException e) {
                //Log.e(TAG,  Log.getStackTraceString(new Throwable()));
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.289 -0400", hash_original_method = "B8A3B3939435110554206CE07E152F67", hash_generated_method = "970C6DB89CD37A256A6CCA39A6FEDEF8")
    public boolean isAudioConnected(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(DBG)        
        log("isAudioConnected()");
        if(mService != null && isEnabled() &&
            isValidDevice(device))        
        {
            try 
            {
                boolean varAB65A4ED5379193BE2DD7328F35729EC_2075093812 = (mService.isAudioConnected(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_37498746 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_37498746;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        if(mService == null){ }        boolean var68934A3E9455FA72420237EB05902327_931706994 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1231651688 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1231651688;
        // ---------- Original Method ----------
        //if (DBG) log("isAudioConnected()");
        //if (mService != null && isEnabled() &&
            //isValidDevice(device)) {
            //try {
              //return mService.isAudioConnected(device);
            //} catch (RemoteException e) {
              //Log.e(TAG,  Log.getStackTraceString(new Throwable()));
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.291 -0400", hash_original_method = "6F6D31332C45DEAF9F6DB793EAF6FAFC", hash_generated_method = "A1CF6D81A016E60606E49CF17A487406")
    public int getBatteryUsageHint(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(DBG)        
        log("getBatteryUsageHint()");
        if(mService != null && isEnabled() &&
            isValidDevice(device))        
        {
            try 
            {
                int var7863C8B87099F4AC407F33ED733ED7D1_1118694097 = (mService.getBatteryUsageHint(device));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1891833339 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1891833339;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        if(mService == null){ }        int var6BB61E3B7BCE0931DA574D19D1D82C88_367981124 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2117266951 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2117266951;
        // ---------- Original Method ----------
        //if (DBG) log("getBatteryUsageHint()");
        //if (mService != null && isEnabled() &&
            //isValidDevice(device)) {
            //try {
                //return mService.getBatteryUsageHint(device);
            //} catch (RemoteException e) {
                //Log.e(TAG,  Log.getStackTraceString(new Throwable()));
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return -1;
    }

    
    @DSModeled(DSC.BAN)
    public static boolean isBluetoothVoiceDialingEnabled(Context context) {
        return context.getResources().getBoolean(
                com.android.internal.R.bool.config_bluetooth_sco_off_call);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.292 -0400", hash_original_method = "2676E323C2C9765143A21FFE59CC6873", hash_generated_method = "9D202C50622B216A49815730434E6A29")
    public boolean cancelConnectThread() {
        if(DBG)        
        log("cancelConnectThread");
        if(mService != null && isEnabled())        
        {
            try 
            {
                boolean var8F612F355507F6BF9B63952A68F95EFA_109847996 = (mService.cancelConnectThread());
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_870980335 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_870980335;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        else
        {
            if(DBG)            
            Log.d(TAG, Log.getStackTraceString(new Throwable()));
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1186395559 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1359332313 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1359332313;
        // ---------- Original Method ----------
        //if (DBG) log("cancelConnectThread");
        //if (mService != null && isEnabled()) {
            //try {
                //return mService.cancelConnectThread();
            //} catch (RemoteException e) {Log.e(TAG, e.toString());}
        //} else {
            //Log.w(TAG, "Proxy not attached to service");
            //if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        //}
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.293 -0400", hash_original_method = "EA55CECCBAC2EAE8EDC221C89634D263", hash_generated_method = "4DEBF16640B47E058DA4E3EB69FEBAD6")
    public boolean acceptIncomingConnect(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(DBG)        
        log("acceptIncomingConnect");
        if(mService != null && isEnabled())        
        {
            try 
            {
                boolean varF9C28B6E1AE85E729C6653EF3E879483_1212916063 = (mService.acceptIncomingConnect(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1237735349 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1237735349;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        else
        {
            if(DBG)            
            Log.d(TAG, Log.getStackTraceString(new Throwable()));
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_867045818 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1801755800 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1801755800;
        // ---------- Original Method ----------
        //if (DBG) log("acceptIncomingConnect");
        //if (mService != null && isEnabled()) {
            //try {
                //return mService.acceptIncomingConnect(device);
            //} catch (RemoteException e) {Log.e(TAG, e.toString());}
        //} else {
            //Log.w(TAG, "Proxy not attached to service");
            //if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        //}
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.294 -0400", hash_original_method = "6D2538BEDFF897738BE4A0A290C33070", hash_generated_method = "61ED810C9BEF796C9525A3684E3E3F36")
    public boolean createIncomingConnect(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(DBG)        
        log("createIncomingConnect");
        if(mService != null && isEnabled())        
        {
            try 
            {
                boolean var9F587C777B124F841E17D9332B80F45D_393775792 = (mService.createIncomingConnect(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_510160584 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_510160584;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        else
        {
            if(DBG)            
            Log.d(TAG, Log.getStackTraceString(new Throwable()));
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_749828873 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1634000929 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1634000929;
        // ---------- Original Method ----------
        //if (DBG) log("createIncomingConnect");
        //if (mService != null && isEnabled()) {
            //try {
                //return mService.createIncomingConnect(device);
            //} catch (RemoteException e) {Log.e(TAG, e.toString());}
        //} else {
            //Log.w(TAG, "Proxy not attached to service");
            //if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        //}
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.295 -0400", hash_original_method = "4505463E5EDB411267D82D01A0F1D824", hash_generated_method = "F45F6767147F7AD4E74C1206895A88B4")
    public boolean rejectIncomingConnect(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(DBG)        
        log("rejectIncomingConnect");
        if(mService != null)        
        {
            try 
            {
                boolean var36ABF51603D76C34EF0882E468415E22_1911726593 = (mService.rejectIncomingConnect(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1540318974 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1540318974;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        else
        {
            if(DBG)            
            Log.d(TAG, Log.getStackTraceString(new Throwable()));
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_520935515 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2055081203 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2055081203;
        // ---------- Original Method ----------
        //if (DBG) log("rejectIncomingConnect");
        //if (mService != null) {
            //try {
                //return mService.rejectIncomingConnect(device);
            //} catch (RemoteException e) {Log.e(TAG, e.toString());}
        //} else {
            //Log.w(TAG, "Proxy not attached to service");
            //if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        //}
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.296 -0400", hash_original_method = "A8F7BAC49E734C18D4B72E93D6F191D5", hash_generated_method = "AB43F14767F72A623E11583F2973F8FC")
    public boolean connectHeadsetInternal(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(DBG)        
        log("connectHeadsetInternal");
        if(mService != null && isEnabled())        
        {
            try 
            {
                boolean var80E81716EE61B25591D10CB023BDFE66_92942297 = (mService.connectHeadsetInternal(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_590809079 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_590809079;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        else
        {
            if(DBG)            
            Log.d(TAG, Log.getStackTraceString(new Throwable()));
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_584994244 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1278907803 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1278907803;
        // ---------- Original Method ----------
        //if (DBG) log("connectHeadsetInternal");
        //if (mService != null && isEnabled()) {
            //try {
                //return mService.connectHeadsetInternal(device);
            //} catch (RemoteException e) {Log.e(TAG, e.toString());}
        //} else {
            //Log.w(TAG, "Proxy not attached to service");
            //if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        //}
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.297 -0400", hash_original_method = "DE8B58BD5456FA1A62F7BE53852C68CF", hash_generated_method = "967FC1EEC0E752A6FECBDBED5EFD3CCB")
    public boolean disconnectHeadsetInternal(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(DBG)        
        log("disconnectHeadsetInternal");
        if(mService != null && !isDisabled())        
        {
            try 
            {
                boolean var83077D59398C4B52710A7457DD863D92_445189623 = (mService.disconnectHeadsetInternal(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_13966859 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_13966859;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        else
        {
            if(DBG)            
            Log.d(TAG, Log.getStackTraceString(new Throwable()));
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_2011629931 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1822874966 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1822874966;
        // ---------- Original Method ----------
        //if (DBG) log("disconnectHeadsetInternal");
        //if (mService != null && !isDisabled()) {
            //try {
                 //return mService.disconnectHeadsetInternal(device);
            //} catch (RemoteException e) {Log.e(TAG, e.toString());}
        //} else {
            //Log.w(TAG, "Proxy not attached to service");
            //if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        //}
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.299 -0400", hash_original_method = "04E80317E50A33841443E656AF5FDA5A", hash_generated_method = "940536426C87A1FF3F34E31158A90066")
    public boolean setAudioState(BluetoothDevice device, int state) {
        addTaint(state);
        addTaint(device.getTaint());
        if(DBG)        
        log("setAudioState");
        if(mService != null && !isDisabled())        
        {
            try 
            {
                boolean varBF88569449B60A1ACD0300E088CD75B8_1285140246 = (mService.setAudioState(device, state));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_815698731 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_815698731;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        else
        {
            if(DBG)            
            Log.d(TAG, Log.getStackTraceString(new Throwable()));
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1000638511 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1938718586 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1938718586;
        // ---------- Original Method ----------
        //if (DBG) log("setAudioState");
        //if (mService != null && !isDisabled()) {
            //try {
                //return mService.setAudioState(device, state);
            //} catch (RemoteException e) {Log.e(TAG, e.toString());}
        //} else {
            //Log.w(TAG, "Proxy not attached to service");
            //if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        //}
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.301 -0400", hash_original_method = "398E968FC0AE96999E6F1C9EB97CF08A", hash_generated_method = "CC2F33360D9050947B05DA1BA20284FF")
    public int getAudioState(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(DBG)        
        log("getAudioState");
        if(mService != null && !isDisabled())        
        {
            try 
            {
                int var0479FBBCDD1F5B972572050DA4E69457_986567541 = (mService.getAudioState(device));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_93077857 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_93077857;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        else
        {
            if(DBG)            
            Log.d(TAG, Log.getStackTraceString(new Throwable()));
        } //End block
        int var16ABE844BBE5415279E6F507178331F3_929194217 = (BluetoothHeadset.STATE_AUDIO_DISCONNECTED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_180276430 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_180276430;
        // ---------- Original Method ----------
        //if (DBG) log("getAudioState");
        //if (mService != null && !isDisabled()) {
            //try {
                //return mService.getAudioState(device);
            //} catch (RemoteException e) {Log.e(TAG, e.toString());}
        //} else {
            //Log.w(TAG, "Proxy not attached to service");
            //if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        //}
        //return BluetoothHeadset.STATE_AUDIO_DISCONNECTED;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.302 -0400", hash_original_method = "D15419F6AD1B4E28C80D3421F9F86FA4", hash_generated_method = "36ACB6C2AA1DFEF85FA005ED7C384C91")
    public boolean startScoUsingVirtualVoiceCall(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(DBG)        
        log("startScoUsingVirtualVoiceCall()");
        if(mService != null && isEnabled() && isValidDevice(device))        
        {
            try 
            {
                boolean var85C40956CD68A2208AA5DAC2B51BA147_1969900659 = (mService.startScoUsingVirtualVoiceCall(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_995961684 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_995961684;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        else
        {
            if(DBG)            
            Log.d(TAG, Log.getStackTraceString(new Throwable()));
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1844358320 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1104803935 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1104803935;
        // ---------- Original Method ----------
        //if (DBG) log("startScoUsingVirtualVoiceCall()");
        //if (mService != null && isEnabled() && isValidDevice(device)) {
            //try {
                //return mService.startScoUsingVirtualVoiceCall(device);
            //} catch (RemoteException e) {
                //Log.e(TAG, e.toString());
            //}
        //} else {
            //Log.w(TAG, "Proxy not attached to service");
            //if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        //}
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.303 -0400", hash_original_method = "EC64256DA9DAF95A4E5DDEFAF84087E3", hash_generated_method = "F38A360982922B2587604FF8C44274B5")
    public boolean stopScoUsingVirtualVoiceCall(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(DBG)        
        log("stopScoUsingVirtualVoiceCall()");
        if(mService != null && isEnabled() && isValidDevice(device))        
        {
            try 
            {
                boolean var758ADF01BA34BA245EB8EA65B10A7BE8_2095364910 = (mService.stopScoUsingVirtualVoiceCall(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1156113252 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1156113252;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        else
        {
            if(DBG)            
            Log.d(TAG, Log.getStackTraceString(new Throwable()));
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1232092781 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1700165992 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1700165992;
        // ---------- Original Method ----------
        //if (DBG) log("stopScoUsingVirtualVoiceCall()");
        //if (mService != null && isEnabled() && isValidDevice(device)) {
            //try {
                //return mService.stopScoUsingVirtualVoiceCall(device);
            //} catch (RemoteException e) {
                //Log.e(TAG, e.toString());
            //}
        //} else {
            //Log.w(TAG, "Proxy not attached to service");
            //if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        //}
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.304 -0400", hash_original_method = "7937BC03D2C2DD83881BE0DF65C2C1C7", hash_generated_method = "EC5BAA0E814F06A7794CA42122C65933")
    private boolean isEnabled() {
        if(mAdapter.getState() == BluetoothAdapter.STATE_ON)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1468917773 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1143972943 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1143972943;
        }
        boolean var68934A3E9455FA72420237EB05902327_1955762262 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_774514801 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_774514801;
        // ---------- Original Method ----------
        //if (mAdapter.getState() == BluetoothAdapter.STATE_ON) return true;
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.305 -0400", hash_original_method = "7FB46929D91880D43466C28024A250A9", hash_generated_method = "0B0DE4302DDDC76F601280B1F63F4CFE")
    private boolean isDisabled() {
        if(mAdapter.getState() == BluetoothAdapter.STATE_OFF)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1444903241 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_944943217 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_944943217;
        }
        boolean var68934A3E9455FA72420237EB05902327_1903503179 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1656781056 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1656781056;
        // ---------- Original Method ----------
        //if (mAdapter.getState() == BluetoothAdapter.STATE_OFF) return true;
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.306 -0400", hash_original_method = "EB67AF48F977D4A31E9F2F2B80A49421", hash_generated_method = "0E3C8586D9B7062AC25DD8AF3C7B318F")
    private boolean isValidDevice(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(device == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1059943626 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_98470836 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_98470836;
        }
        if(BluetoothAdapter.checkBluetoothAddress(device.getAddress()))        
        {
        boolean varB326B5062B2F0E69046810717534CB09_707972577 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_676779620 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_676779620;
        }
        boolean var68934A3E9455FA72420237EB05902327_1402613433 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2058671057 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2058671057;
        // ---------- Original Method ----------
        //if (device == null) return false;
        //if (BluetoothAdapter.checkBluetoothAddress(device.getAddress())) return true;
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    private static void log(String msg) {
        Log.d(TAG, msg);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.306 -0400", hash_original_field = "BD04568A92F85E35CB844729F0C3A798", hash_generated_field = "EBA83525E1B94BE4C4CA3565D8D3EE9E")

    private static final String TAG = "BluetoothHeadset";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.306 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.307 -0400", hash_original_field = "672D4AAD8CD014AE5995B93963202C29", hash_generated_field = "ABC03AE60B852A1C7718E9A970BD1536")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CONNECTION_STATE_CHANGED =
        "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.307 -0400", hash_original_field = "940CAC348432C44F14F723D6076DE02B", hash_generated_field = "BB784B20611B5426CFF10690920EEB5C")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_AUDIO_STATE_CHANGED =
        "android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.307 -0400", hash_original_field = "D35AD240456BC66A2DEC71A77CFD72A4", hash_generated_field = "AC2698553492ED5B94B3EFA99003D861")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_VENDOR_SPECIFIC_HEADSET_EVENT =
            "android.bluetooth.headset.action.VENDOR_SPECIFIC_HEADSET_EVENT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.307 -0400", hash_original_field = "B6900C9E4FC9B76BDF6B5AB64B8BD668", hash_generated_field = "BDACDE0E26600FAE1AFF6AC736C7F543")

    public static final String EXTRA_VENDOR_SPECIFIC_HEADSET_EVENT_CMD =
            "android.bluetooth.headset.extra.VENDOR_SPECIFIC_HEADSET_EVENT_CMD";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.307 -0400", hash_original_field = "826CFED59CA895C44072A6FA47D4A64C", hash_generated_field = "90CECD7CE6C28ECC4D03E1709BB66CBD")

    public static final String EXTRA_VENDOR_SPECIFIC_HEADSET_EVENT_CMD_TYPE =
            "android.bluetooth.headset.extra.VENDOR_SPECIFIC_HEADSET_EVENT_CMD_TYPE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.307 -0400", hash_original_field = "1242AAD6D44CD5550D7F75519D18C400", hash_generated_field = "4DE453250584C7FE6B64D6AD6C961CE8")

    public static final int AT_CMD_TYPE_READ = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.308 -0400", hash_original_field = "A6619D85A8C5882C0BF260C604A3C5D5", hash_generated_field = "2C2252AE507E225BC34F7AEA44E0AC49")

    public static final int AT_CMD_TYPE_TEST = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.308 -0400", hash_original_field = "28FCFB568CDA51D4B78DB7DEB8196ED6", hash_generated_field = "357B08A29D2379204652B128913E4928")

    public static final int AT_CMD_TYPE_SET = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.308 -0400", hash_original_field = "FB9B5054C0DE574D90887E1BA046CD58", hash_generated_field = "0A95BA5CB4DD042061A85BD7515A62D7")

    public static final int AT_CMD_TYPE_BASIC = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.308 -0400", hash_original_field = "B233DD7907877A2DE6CA78439C3700A9", hash_generated_field = "8A8D2B159027C806839DD114C91E3127")

    public static final int AT_CMD_TYPE_ACTION = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.308 -0400", hash_original_field = "B5852A50D1DD83F6A07B8B93DC3AF841", hash_generated_field = "51411B886A94D1180D892E92776C02D3")

    public static final String EXTRA_VENDOR_SPECIFIC_HEADSET_EVENT_ARGS =
            "android.bluetooth.headset.extra.VENDOR_SPECIFIC_HEADSET_EVENT_ARGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.309 -0400", hash_original_field = "3F90B9C504BA70C93A0D9FA927F5FC63", hash_generated_field = "B5553D0E6B97FD79EBA3C206E2FF693C")

    public static final String VENDOR_SPECIFIC_HEADSET_EVENT_COMPANY_ID_CATEGORY  =
            "android.bluetooth.headset.intent.category.companyid";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.309 -0400", hash_original_field = "657D1FB2064FBDA2A6DCBF26DE4BA6AC", hash_generated_field = "0D469E671F848187A0CDC591A24EABA1")

    public static final int STATE_AUDIO_DISCONNECTED = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.309 -0400", hash_original_field = "D022E3BF246E2498ECFA4C1D3CB37450", hash_generated_field = "320FBFE32BF6DC544AAED5D9A84E5DBD")

    public static final int STATE_AUDIO_CONNECTING = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.309 -0400", hash_original_field = "0C92A4FE950C78554146B5C26212EFBA", hash_generated_field = "39ACE008F53ABD81B2D9586C9128E986")

    public static final int STATE_AUDIO_CONNECTED = 12;
}

