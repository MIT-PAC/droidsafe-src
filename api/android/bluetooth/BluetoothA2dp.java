package android.bluetooth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.content.Context;
import android.os.IBinder;
import android.os.ParcelUuid;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.server.BluetoothA2dpService;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public final class BluetoothA2dp implements BluetoothProfile {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.882 -0400", hash_original_field = "CA257FD83AF4C9E6C265E05B6CDBF2DD", hash_generated_field = "6FCEA0ED39BC377BA765F514A42DFCE9")

    private ServiceListener mServiceListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.882 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "09949A1EC40DD93875E958A2CE8D0BE0")

    private IBluetoothA2dp mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.883 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "6EAF57CC559AB78B0231BFFF469261B9")

    private BluetoothAdapter mAdapter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.884 -0400", hash_original_method = "84AC70841E1DE8A91A25AE9B1E768BDD", hash_generated_method = "61A52A36C54FE64E224DA889A55AF216")
      BluetoothA2dp(Context mContext, ServiceListener l) {
        addTaint(mContext.getTaint());
        IBinder b = ServiceManager.getService(BluetoothA2dpService.BLUETOOTH_A2DP_SERVICE);
        mServiceListener = l;
        mAdapter = BluetoothAdapter.getDefaultAdapter();
        if(b != null)        
        {
            mService = IBluetoothA2dp.Stub.asInterface(b);
            if(mServiceListener != null)            
            {
                mServiceListener.onServiceConnected(BluetoothProfile.A2DP, this);
            } //End block
        } //End block
        else
        {
            mService = null;
        } //End block
        // ---------- Original Method ----------
        //IBinder b = ServiceManager.getService(BluetoothA2dpService.BLUETOOTH_A2DP_SERVICE);
        //mServiceListener = l;
        //mAdapter = BluetoothAdapter.getDefaultAdapter();
        //if (b != null) {
            //mService = IBluetoothA2dp.Stub.asInterface(b);
            //if (mServiceListener != null) {
                //mServiceListener.onServiceConnected(BluetoothProfile.A2DP, this);
            //}
        //} else {
            //Log.w(TAG, "Bluetooth A2DP service not available!");
            //mService = null;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.886 -0400", hash_original_method = "D3BF3BAE58FFF66435185BE94948ED76", hash_generated_method = "7E2810AC4BDE36569F993386C707233F")
     void close() {
        mServiceListener = null;
        // ---------- Original Method ----------
        //mServiceListener = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.887 -0400", hash_original_method = "700825FC4ECAB3A433DC66A7B0E84928", hash_generated_method = "D50228FCFD303FAD2A16E49F430D558A")
    public boolean connect(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(DBG)        
        log("connect(" + device + ")");
        if(mService != null && isEnabled() &&
            isValidDevice(device))        
        {
            try 
            {
                boolean varEBACDF479EAFFE2AD53D5370B5C3FBBE_698435452 = (mService.connect(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1171406196 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1171406196;
            } //End block
            catch (RemoteException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_1783550017 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_266923087 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_266923087;
            } //End block
        } //End block
        if(mService == null){ }        boolean var68934A3E9455FA72420237EB05902327_1861263544 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_748194775 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_748194775;
        // ---------- Original Method ----------
        //if (DBG) log("connect(" + device + ")");
        //if (mService != null && isEnabled() &&
            //isValidDevice(device)) {
            //try {
                //return mService.connect(device);
            //} catch (RemoteException e) {
                //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                //return false;
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.888 -0400", hash_original_method = "55DF4D676FC35487D0748922C473702F", hash_generated_method = "28A48CAC16A97691C979874CA1442F8D")
    public boolean disconnect(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(DBG)        
        log("disconnect(" + device + ")");
        if(mService != null && isEnabled() &&
            isValidDevice(device))        
        {
            try 
            {
                boolean var42FFDFE107D001E4DD32E59464767CFF_413259650 = (mService.disconnect(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1325019568 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1325019568;
            } //End block
            catch (RemoteException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_1053656772 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1032056187 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1032056187;
            } //End block
        } //End block
        if(mService == null){ }        boolean var68934A3E9455FA72420237EB05902327_2063335584 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2033249800 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2033249800;
        // ---------- Original Method ----------
        //if (DBG) log("disconnect(" + device + ")");
        //if (mService != null && isEnabled() &&
            //isValidDevice(device)) {
            //try {
                //return mService.disconnect(device);
            //} catch (RemoteException e) {
                //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                //return false;
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.889 -0400", hash_original_method = "0ADED1F6ADFCC469E1E307997E79DBB8", hash_generated_method = "4BDCFDAF5F3A1C0B811FBC67E2E3C7D2")
    public List<BluetoothDevice> getConnectedDevices() {
        if(DBG)        
        log("getConnectedDevices()");
        if(mService != null && isEnabled())        
        {
            try 
            {
List<BluetoothDevice> var0CBC70B0F206DDA9ED876FF389D40D78_1274918635 =                 mService.getConnectedDevices();
                var0CBC70B0F206DDA9ED876FF389D40D78_1274918635.addTaint(taint);
                return var0CBC70B0F206DDA9ED876FF389D40D78_1274918635;
            } //End block
            catch (RemoteException e)
            {
List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1879937796 =                 new ArrayList<BluetoothDevice>();
                var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1879937796.addTaint(taint);
                return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1879937796;
            } //End block
        } //End block
        if(mService == null){ }List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_2036749027 =         new ArrayList<BluetoothDevice>();
        var0DD13883ABBA5DF8AB8CAFEE38A3B82C_2036749027.addTaint(taint);
        return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_2036749027;
        // ---------- Original Method ----------
        //if (DBG) log("getConnectedDevices()");
        //if (mService != null && isEnabled()) {
            //try {
                //return mService.getConnectedDevices();
            //} catch (RemoteException e) {
                //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                //return new ArrayList<BluetoothDevice>();
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return new ArrayList<BluetoothDevice>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.891 -0400", hash_original_method = "EE46EB26B83008ABEDB21DB2056FFA88", hash_generated_method = "3C8A20B7870F903CE4785314D7A6A7BD")
    public List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] states) {
        addTaint(states[0]);
        if(DBG)        
        log("getDevicesMatchingStates()");
        if(mService != null && isEnabled())        
        {
            try 
            {
List<BluetoothDevice> varD888D9FBE2025148D0FB51CF8CEE87E5_1527771730 =                 mService.getDevicesMatchingConnectionStates(states);
                varD888D9FBE2025148D0FB51CF8CEE87E5_1527771730.addTaint(taint);
                return varD888D9FBE2025148D0FB51CF8CEE87E5_1527771730;
            } //End block
            catch (RemoteException e)
            {
List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_289853322 =                 new ArrayList<BluetoothDevice>();
                var0DD13883ABBA5DF8AB8CAFEE38A3B82C_289853322.addTaint(taint);
                return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_289853322;
            } //End block
        } //End block
        if(mService == null){ }List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1172147059 =         new ArrayList<BluetoothDevice>();
        var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1172147059.addTaint(taint);
        return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1172147059;
        // ---------- Original Method ----------
        //if (DBG) log("getDevicesMatchingStates()");
        //if (mService != null && isEnabled()) {
            //try {
                //return mService.getDevicesMatchingConnectionStates(states);
            //} catch (RemoteException e) {
                //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                //return new ArrayList<BluetoothDevice>();
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return new ArrayList<BluetoothDevice>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.892 -0400", hash_original_method = "B281ECAF166EAE88B310FDB0152ACEB7", hash_generated_method = "3DC820885AF14557B720E752A166D7CE")
    public int getConnectionState(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(DBG)        
        log("getState(" + device + ")");
        if(mService != null && isEnabled()
            && isValidDevice(device))        
        {
            try 
            {
                int var8DA78526B41CCAC0FE35CC7431643446_273018903 = (mService.getConnectionState(device));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_6149694 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_6149694;
            } //End block
            catch (RemoteException e)
            {
                int var6DC267D6C0363C5B94F222673460F45F_1222389358 = (BluetoothProfile.STATE_DISCONNECTED);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_384702895 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_384702895;
            } //End block
        } //End block
        if(mService == null){ }        int var6DC267D6C0363C5B94F222673460F45F_249387720 = (BluetoothProfile.STATE_DISCONNECTED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_65508499 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_65508499;
        // ---------- Original Method ----------
        //if (DBG) log("getState(" + device + ")");
        //if (mService != null && isEnabled()
            //&& isValidDevice(device)) {
            //try {
                //return mService.getConnectionState(device);
            //} catch (RemoteException e) {
                //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                //return BluetoothProfile.STATE_DISCONNECTED;
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return BluetoothProfile.STATE_DISCONNECTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.893 -0400", hash_original_method = "2B40F2C1D807822C775F30BF280CDA0D", hash_generated_method = "3D569548FCEC1F4E8ADEA466C5F2BB36")
    public boolean setPriority(BluetoothDevice device, int priority) {
        addTaint(priority);
        addTaint(device.getTaint());
        if(DBG)        
        log("setPriority(" + device + ", " + priority + ")");
        if(mService != null && isEnabled()
            && isValidDevice(device))        
        {
            if(priority != BluetoothProfile.PRIORITY_OFF &&
                priority != BluetoothProfile.PRIORITY_ON)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1151139145 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1408670706 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1408670706;
            } //End block
            try 
            {
                boolean varC080112B655E626AEC73393AE044B4DD_905925255 = (mService.setPriority(device, priority));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1968385439 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1968385439;
            } //End block
            catch (RemoteException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_433187292 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_350969140 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_350969140;
            } //End block
        } //End block
        if(mService == null){ }        boolean var68934A3E9455FA72420237EB05902327_1888239501 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_450151542 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_450151542;
        // ---------- Original Method ----------
        //if (DBG) log("setPriority(" + device + ", " + priority + ")");
        //if (mService != null && isEnabled()
            //&& isValidDevice(device)) {
            //if (priority != BluetoothProfile.PRIORITY_OFF &&
                //priority != BluetoothProfile.PRIORITY_ON) {
              //return false;
            //}
            //try {
                //return mService.setPriority(device, priority);
            //} catch (RemoteException e) {
                //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                //return false;
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.894 -0400", hash_original_method = "23F2360BBDC60C257F7868DD2B8A1B81", hash_generated_method = "513B43D8F4483589B8047ACA1182B348")
    public int getPriority(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(DBG)        
        log("getPriority(" + device + ")");
        if(mService != null && isEnabled()
            && isValidDevice(device))        
        {
            try 
            {
                int var989DD7E44FB699D3F65CF049678ECBF2_1360697627 = (mService.getPriority(device));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_648782604 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_648782604;
            } //End block
            catch (RemoteException e)
            {
                int var77236085A0BA5825CA2134406E964D5B_1662072682 = (BluetoothProfile.PRIORITY_OFF);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1916696339 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1916696339;
            } //End block
        } //End block
        if(mService == null){ }        int var77236085A0BA5825CA2134406E964D5B_153181732 = (BluetoothProfile.PRIORITY_OFF);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1274186584 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1274186584;
        // ---------- Original Method ----------
        //if (DBG) log("getPriority(" + device + ")");
        //if (mService != null && isEnabled()
            //&& isValidDevice(device)) {
            //try {
                //return mService.getPriority(device);
            //} catch (RemoteException e) {
                //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                //return BluetoothProfile.PRIORITY_OFF;
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return BluetoothProfile.PRIORITY_OFF;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.895 -0400", hash_original_method = "0A81AC976D9A0E28DF6B1DEC7E34C5D3", hash_generated_method = "B4C8AE82A7DEE595485B88D8F3987F3B")
    public boolean isA2dpPlaying(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(mService != null && isEnabled()
            && isValidDevice(device))        
        {
            try 
            {
                boolean varEDFE4BB68AF8792931626E71685E8B42_1704406858 = (mService.isA2dpPlaying(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_551394787 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_551394787;
            } //End block
            catch (RemoteException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_843471069 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1734518969 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1734518969;
            } //End block
        } //End block
        if(mService == null){ }        boolean var68934A3E9455FA72420237EB05902327_2060789992 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_606893948 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_606893948;
        // ---------- Original Method ----------
        //if (mService != null && isEnabled()
            //&& isValidDevice(device)) {
            //try {
                //return mService.isA2dpPlaying(device);
            //} catch (RemoteException e) {
                //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                //return false;
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.896 -0400", hash_original_method = "FEE19D0C9AEE9A75BC73A57692A1B159", hash_generated_method = "62008A267BF8F2E9A67676784BE2DD48")
    public boolean suspendSink(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(mService != null && isEnabled()
            && isValidDevice(device))        
        {
            try 
            {
                boolean varE92B4009E8F16D2C6006A12A949A6E7F_1166844832 = (mService.suspendSink(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1179816731 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1179816731;
            } //End block
            catch (RemoteException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_1702769320 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1412717961 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1412717961;
            } //End block
        } //End block
        if(mService == null){ }        boolean var68934A3E9455FA72420237EB05902327_2004761896 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1827442539 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1827442539;
        // ---------- Original Method ----------
        //if (mService != null && isEnabled()
            //&& isValidDevice(device)) {
            //try {
                //return mService.suspendSink(device);
            //} catch (RemoteException e) {
                //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                //return false;
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.897 -0400", hash_original_method = "18AFE84D45293B01197D290EE720FEAA", hash_generated_method = "0644002527DB19DC1CE494275A163BBA")
    public boolean resumeSink(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(mService != null && isEnabled()
            && isValidDevice(device))        
        {
            try 
            {
                boolean var9DF31C17D20BD2809DBD580AE093D022_860591866 = (mService.resumeSink(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_11550282 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_11550282;
            } //End block
            catch (RemoteException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_1657375480 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1224787985 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1224787985;
            } //End block
        } //End block
        if(mService == null){ }        boolean var68934A3E9455FA72420237EB05902327_1168731081 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_863077410 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_863077410;
        // ---------- Original Method ----------
        //if (mService != null && isEnabled()
            //&& isValidDevice(device)) {
            //try {
                //return mService.resumeSink(device);
            //} catch (RemoteException e) {
                //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                //return false;
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.898 -0400", hash_original_method = "FF7FB4D142B82B6A187917634C749F84", hash_generated_method = "B9167961A2AB481C131C27D31CC2F99E")
    public boolean shouldSendVolumeKeys(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(isEnabled() && isValidDevice(device))        
        {
            ParcelUuid[] uuids = device.getUuids();
            if(uuids == null)            
            {
            boolean var68934A3E9455FA72420237EB05902327_125283536 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_862445830 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_862445830;
            }
for(ParcelUuid uuid : uuids)
            {
                if(BluetoothUuid.isAvrcpTarget(uuid))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_762145602 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_260180070 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_260180070;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_741572377 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1139400321 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1139400321;
        // ---------- Original Method ----------
        //if (isEnabled() && isValidDevice(device)) {
            //ParcelUuid[] uuids = device.getUuids();
            //if (uuids == null) return false;
            //for (ParcelUuid uuid: uuids) {
                //if (BluetoothUuid.isAvrcpTarget(uuid)) {
                    //return true;
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.899 -0400", hash_original_method = "29CED80F2164214524C1FC1AF02F2B1A", hash_generated_method = "28CF283C75424F698FF13C464D8F79C0")
    public boolean allowIncomingConnect(BluetoothDevice device, boolean value) {
        addTaint(value);
        addTaint(device.getTaint());
        if(DBG)        
        log("allowIncomingConnect(" + device + ":" + value + ")");
        try 
        {
            boolean var0EDA640ACD066737AA0A6F2390A0185C_2075412338 = (mService.allowIncomingConnect(device, value));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1731320037 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1731320037;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1582792807 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1491434618 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1491434618;
        } //End block
        // ---------- Original Method ----------
        //if (DBG) log("allowIncomingConnect(" + device + ":" + value + ")");
        //try {
            //return mService.allowIncomingConnect(device, value);
        //} catch (RemoteException e) {
            //Log.e(TAG, "", e);
            //return false;
        //}
    }

    
    public static String stateToString(int state) {
        switch (state) {
        case STATE_DISCONNECTED:
            return "disconnected";
        case STATE_CONNECTING:
            return "connecting";
        case STATE_CONNECTED:
            return "connected";
        case STATE_DISCONNECTING:
            return "disconnecting";
        case STATE_PLAYING:
            return "playing";
        case STATE_NOT_PLAYING:
          return "not playing";
        default:
            return "<unknown state " + state + ">";
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.919 -0400", hash_original_method = "7937BC03D2C2DD83881BE0DF65C2C1C7", hash_generated_method = "C897D8D30DD1D23DE000FA13D0184E50")
    private boolean isEnabled() {
        if(mAdapter.getState() == BluetoothAdapter.STATE_ON)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_381442554 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1865265351 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1865265351;
        }
        boolean var68934A3E9455FA72420237EB05902327_693297898 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_653556961 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_653556961;
        // ---------- Original Method ----------
        //if (mAdapter.getState() == BluetoothAdapter.STATE_ON) return true;
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.920 -0400", hash_original_method = "EB67AF48F977D4A31E9F2F2B80A49421", hash_generated_method = "23A0AD069A175135378C9FBAD3DADEDE")
    private boolean isValidDevice(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(device == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1914001734 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1496973515 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1496973515;
        }
        if(BluetoothAdapter.checkBluetoothAddress(device.getAddress()))        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1485832776 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1656640703 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1656640703;
        }
        boolean var68934A3E9455FA72420237EB05902327_1100097804 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1179636537 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1179636537;
        // ---------- Original Method ----------
        //if (device == null) return false;
        //if (BluetoothAdapter.checkBluetoothAddress(device.getAddress())) return true;
        //return false;
    }

    
    private static void log(String msg) {
        Log.d(TAG, msg);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.921 -0400", hash_original_field = "5B6C31FA9C83E6DC9196B06BC86C02C9", hash_generated_field = "E58C6B10C262D3DDCC0EFA1E2CD2ADBD")

    private static final String TAG = "BluetoothA2dp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.921 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.921 -0400", hash_original_field = "710FFCEDBB226F7143225EDB5CEA6D4C", hash_generated_field = "2C4FE2399AE2300A95A94B068FA50EDB")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CONNECTION_STATE_CHANGED =
        "android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.921 -0400", hash_original_field = "95B97BC08AE97748391B6C213B69D6ED", hash_generated_field = "B900F0837C67C4837BB08076612125E7")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PLAYING_STATE_CHANGED =
        "android.bluetooth.a2dp.profile.action.PLAYING_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.921 -0400", hash_original_field = "E3EB53455E6884860DCB779057FE340A", hash_generated_field = "92BD53792AEE35980F71CE5B967D3BBC")

    public static final int STATE_PLAYING   =  10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.921 -0400", hash_original_field = "65DF540099E17E30F1AC2FA7F157725D", hash_generated_field = "21A0703BC1A0A5C580A43C1F467A8E87")

    public static final int STATE_NOT_PLAYING   =  11;
}

