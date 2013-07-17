package android.bluetooth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public final class BluetoothInputDevice implements BluetoothProfile {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.509 -0400", hash_original_field = "CA257FD83AF4C9E6C265E05B6CDBF2DD", hash_generated_field = "6FCEA0ED39BC377BA765F514A42DFCE9")

    private ServiceListener mServiceListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.509 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "6EAF57CC559AB78B0231BFFF469261B9")

    private BluetoothAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.510 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "40876FBB70C48F89ADB2F95E8DF8AB42")

    private IBluetooth mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.511 -0400", hash_original_method = "97D7A1AD2A2B5CF8AA634AC52F7EF42D", hash_generated_method = "381838150C3D747428EFE659E5B96574")
      BluetoothInputDevice(Context mContext, ServiceListener l) {
        addTaint(mContext.getTaint());
        IBinder b = ServiceManager.getService(BluetoothAdapter.BLUETOOTH_SERVICE);
        mServiceListener = l;
        mAdapter = BluetoothAdapter.getDefaultAdapter();
        if(b != null)        
        {
            mService = IBluetooth.Stub.asInterface(b);
            if(mServiceListener != null)            
            {
                mServiceListener.onServiceConnected(BluetoothProfile.INPUT_DEVICE, this);
            } //End block
        } //End block
        else
        {
            mService = null;
        } //End block
        // ---------- Original Method ----------
        //IBinder b = ServiceManager.getService(BluetoothAdapter.BLUETOOTH_SERVICE);
        //mServiceListener = l;
        //mAdapter = BluetoothAdapter.getDefaultAdapter();
        //if (b != null) {
            //mService = IBluetooth.Stub.asInterface(b);
            //if (mServiceListener != null) {
                //mServiceListener.onServiceConnected(BluetoothProfile.INPUT_DEVICE, this);
            //}
        //} else {
            //Log.w(TAG, "Bluetooth Service not available!");
            //mService = null;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.513 -0400", hash_original_method = "D3BF3BAE58FFF66435185BE94948ED76", hash_generated_method = "7E2810AC4BDE36569F993386C707233F")
     void close() {
        mServiceListener = null;
        // ---------- Original Method ----------
        //mServiceListener = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.515 -0400", hash_original_method = "F2019F4C3E8629A52034D770ECD44393", hash_generated_method = "CABEB3242406FFCC93AE0EF44C8C1CF6")
    public boolean connect(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(DBG)        
        log("connect(" + device + ")");
        if(mService != null && isEnabled() &&
            isValidDevice(device))        
        {
            try 
            {
                boolean varA3F65B92E3A8B04DCB7DB5B7F23777B3_79702866 = (mService.connectInputDevice(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2141906317 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2141906317;
            } //End block
            catch (RemoteException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_1190579817 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1964217206 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1964217206;
            } //End block
        } //End block
        if(mService == null){ }        boolean var68934A3E9455FA72420237EB05902327_1568232296 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_956617611 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_956617611;
        // ---------- Original Method ----------
        //if (DBG) log("connect(" + device + ")");
        //if (mService != null && isEnabled() &&
            //isValidDevice(device)) {
            //try {
                //return mService.connectInputDevice(device);
            //} catch (RemoteException e) {
                //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                //return false;
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.517 -0400", hash_original_method = "9415AEF5C20AF4D988D1F3F693875D2E", hash_generated_method = "F2779073A91178AC2F6841F658B0A813")
    public boolean disconnect(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(DBG)        
        log("disconnect(" + device + ")");
        if(mService != null && isEnabled() &&
            isValidDevice(device))        
        {
            try 
            {
                boolean var86C6B7D42D1F8BA1368231D224445B5F_909567020 = (mService.disconnectInputDevice(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_856793947 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_856793947;
            } //End block
            catch (RemoteException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_11599629 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_416477773 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_416477773;
            } //End block
        } //End block
        if(mService == null){ }        boolean var68934A3E9455FA72420237EB05902327_5040784 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_707356426 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_707356426;
        // ---------- Original Method ----------
        //if (DBG) log("disconnect(" + device + ")");
        //if (mService != null && isEnabled() &&
            //isValidDevice(device)) {
            //try {
                //return mService.disconnectInputDevice(device);
            //} catch (RemoteException e) {
                //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                //return false;
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.519 -0400", hash_original_method = "DD11A5A037066B819B09B91F048A8292", hash_generated_method = "9EEA11E81E30A44340E45717C680FF8F")
    public List<BluetoothDevice> getConnectedDevices() {
        if(DBG)        
        log("getConnectedDevices()");
        if(mService != null && isEnabled())        
        {
            try 
            {
List<BluetoothDevice> varACB830FAA71CC87E3BA33FF67170E9A4_1780026641 =                 mService.getConnectedInputDevices();
                varACB830FAA71CC87E3BA33FF67170E9A4_1780026641.addTaint(taint);
                return varACB830FAA71CC87E3BA33FF67170E9A4_1780026641;
            } //End block
            catch (RemoteException e)
            {
List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_2097184249 =                 new ArrayList<BluetoothDevice>();
                var0DD13883ABBA5DF8AB8CAFEE38A3B82C_2097184249.addTaint(taint);
                return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_2097184249;
            } //End block
        } //End block
        if(mService == null){ }List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1379474657 =         new ArrayList<BluetoothDevice>();
        var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1379474657.addTaint(taint);
        return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1379474657;
        // ---------- Original Method ----------
        //if (DBG) log("getConnectedDevices()");
        //if (mService != null && isEnabled()) {
            //try {
                //return mService.getConnectedInputDevices();
            //} catch (RemoteException e) {
                //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                //return new ArrayList<BluetoothDevice>();
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return new ArrayList<BluetoothDevice>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.520 -0400", hash_original_method = "8CAF8E68108C6561E50EE464A6851A15", hash_generated_method = "4223F7ECD716DA66DA3E40A30167862A")
    public List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] states) {
        addTaint(states[0]);
        if(DBG)        
        log("getDevicesMatchingStates()");
        if(mService != null && isEnabled())        
        {
            try 
            {
List<BluetoothDevice> var834FE32A3912E93827D3EA3792B22C37_1584392721 =                 mService.getInputDevicesMatchingConnectionStates(states);
                var834FE32A3912E93827D3EA3792B22C37_1584392721.addTaint(taint);
                return var834FE32A3912E93827D3EA3792B22C37_1584392721;
            } //End block
            catch (RemoteException e)
            {
List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_370951346 =                 new ArrayList<BluetoothDevice>();
                var0DD13883ABBA5DF8AB8CAFEE38A3B82C_370951346.addTaint(taint);
                return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_370951346;
            } //End block
        } //End block
        if(mService == null){ }List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_698740166 =         new ArrayList<BluetoothDevice>();
        var0DD13883ABBA5DF8AB8CAFEE38A3B82C_698740166.addTaint(taint);
        return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_698740166;
        // ---------- Original Method ----------
        //if (DBG) log("getDevicesMatchingStates()");
        //if (mService != null && isEnabled()) {
            //try {
                //return mService.getInputDevicesMatchingConnectionStates(states);
            //} catch (RemoteException e) {
                //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                //return new ArrayList<BluetoothDevice>();
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return new ArrayList<BluetoothDevice>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.521 -0400", hash_original_method = "97B42C809342D6C6DAC05DB0DA17D1EC", hash_generated_method = "B0859B198EC1A7B9A7E3ACC0755627EC")
    public int getConnectionState(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(DBG)        
        log("getState(" + device + ")");
        if(mService != null && isEnabled()
            && isValidDevice(device))        
        {
            try 
            {
                int var4FB190631F1D79F4E74E5C507EFD512D_2121339896 = (mService.getInputDeviceConnectionState(device));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1864805287 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1864805287;
            } //End block
            catch (RemoteException e)
            {
                int var6DC267D6C0363C5B94F222673460F45F_949518337 = (BluetoothProfile.STATE_DISCONNECTED);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_897948968 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_897948968;
            } //End block
        } //End block
        if(mService == null){ }        int var6DC267D6C0363C5B94F222673460F45F_1328170546 = (BluetoothProfile.STATE_DISCONNECTED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1514924974 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1514924974;
        // ---------- Original Method ----------
        //if (DBG) log("getState(" + device + ")");
        //if (mService != null && isEnabled()
            //&& isValidDevice(device)) {
            //try {
                //return mService.getInputDeviceConnectionState(device);
            //} catch (RemoteException e) {
                //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                //return BluetoothProfile.STATE_DISCONNECTED;
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return BluetoothProfile.STATE_DISCONNECTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.523 -0400", hash_original_method = "9373326E4AC064A071DC5CD973E0011C", hash_generated_method = "1389B9FD9915BD563326B1B89C88865F")
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
                boolean var68934A3E9455FA72420237EB05902327_1269065002 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_627828325 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_627828325;
            } //End block
            try 
            {
                boolean var6CBDB0FF9F479C4D018F1B142A713E91_1250976225 = (mService.setInputDevicePriority(device, priority));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1541199490 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1541199490;
            } //End block
            catch (RemoteException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_266400787 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1863785094 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1863785094;
            } //End block
        } //End block
        if(mService == null){ }        boolean var68934A3E9455FA72420237EB05902327_927882640 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_665315552 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_665315552;
        // ---------- Original Method ----------
        //if (DBG) log("setPriority(" + device + ", " + priority + ")");
        //if (mService != null && isEnabled()
            //&& isValidDevice(device)) {
            //if (priority != BluetoothProfile.PRIORITY_OFF &&
                //priority != BluetoothProfile.PRIORITY_ON) {
              //return false;
            //}
            //try {
                //return mService.setInputDevicePriority(device, priority);
            //} catch (RemoteException e) {
                //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                //return false;
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.524 -0400", hash_original_method = "1D1EE6052242ABD7AAF16EB7DF8BA827", hash_generated_method = "E6FD272FA4DF285CBF09355F2217E7AB")
    public int getPriority(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(DBG)        
        log("getPriority(" + device + ")");
        if(mService != null && isEnabled()
            && isValidDevice(device))        
        {
            try 
            {
                int varB5E2DFD8FE22551D2AAD99AAFE8B67FC_897790492 = (mService.getInputDevicePriority(device));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1449017811 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1449017811;
            } //End block
            catch (RemoteException e)
            {
                int var77236085A0BA5825CA2134406E964D5B_740973363 = (BluetoothProfile.PRIORITY_OFF);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1120858328 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1120858328;
            } //End block
        } //End block
        if(mService == null){ }        int var77236085A0BA5825CA2134406E964D5B_1321029524 = (BluetoothProfile.PRIORITY_OFF);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1635163466 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1635163466;
        // ---------- Original Method ----------
        //if (DBG) log("getPriority(" + device + ")");
        //if (mService != null && isEnabled()
            //&& isValidDevice(device)) {
            //try {
                //return mService.getInputDevicePriority(device);
            //} catch (RemoteException e) {
                //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                //return BluetoothProfile.PRIORITY_OFF;
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return BluetoothProfile.PRIORITY_OFF;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.525 -0400", hash_original_method = "7937BC03D2C2DD83881BE0DF65C2C1C7", hash_generated_method = "1E073A2614B9B1E32244C3E72D216E91")
    private boolean isEnabled() {
        if(mAdapter.getState() == BluetoothAdapter.STATE_ON)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1897383897 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_769613529 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_769613529;
        }
        boolean var68934A3E9455FA72420237EB05902327_1154642379 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_819151988 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_819151988;
        // ---------- Original Method ----------
        //if (mAdapter.getState() == BluetoothAdapter.STATE_ON) return true;
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.526 -0400", hash_original_method = "EB67AF48F977D4A31E9F2F2B80A49421", hash_generated_method = "AF6151D96062E4A8BAABFF72876FEAA4")
    private boolean isValidDevice(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(device == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1800626217 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_139020918 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_139020918;
        }
        if(BluetoothAdapter.checkBluetoothAddress(device.getAddress()))        
        {
        boolean varB326B5062B2F0E69046810717534CB09_176587199 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_115156022 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_115156022;
        }
        boolean var68934A3E9455FA72420237EB05902327_844320231 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_762876876 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_762876876;
        // ---------- Original Method ----------
        //if (device == null) return false;
        //if (BluetoothAdapter.checkBluetoothAddress(device.getAddress())) return true;
        //return false;
    }

    
    private static void log(String msg) {
        Log.d(TAG, msg);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.526 -0400", hash_original_field = "E33D61FD7578737EAE0CF59C19700E44", hash_generated_field = "16F686E671E5BDDF6BD9132F0996D923")

    private static final String TAG = "BluetoothInputDevice";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.527 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.527 -0400", hash_original_field = "97BE72EF53A96BD83EBEBA63C85ECC75", hash_generated_field = "540FA7B1A4B71D9C1548B07010E971E4")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CONNECTION_STATE_CHANGED =
        "android.bluetooth.input.profile.action.CONNECTION_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.527 -0400", hash_original_field = "4DC8E7B1B267E8E3AB529C6D578F5625", hash_generated_field = "F3CEDA651E220ABE5BBA1C470DA54607")

    public static final int INPUT_DISCONNECT_FAILED_NOT_CONNECTED = 5000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.527 -0400", hash_original_field = "5040AC488695EDF1748D25C164CEA35E", hash_generated_field = "3F7EC65F15367682B88A8F4F54E9D835")

    public static final int INPUT_CONNECT_FAILED_ALREADY_CONNECTED = 5001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.527 -0400", hash_original_field = "3EED5978C7B000263795FA31DDD91825", hash_generated_field = "A8C836966ADCA47BE0B2F2EF173A7A16")

    public static final int INPUT_CONNECT_FAILED_ATTEMPT_FAILED = 5002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.527 -0400", hash_original_field = "6E1AEFFEED1FDD01D5D70DA046B1D059", hash_generated_field = "631F101B700A8DBC14A6F825543E0B75")

    public static final int INPUT_OPERATION_GENERIC_FAILURE = 5003;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.527 -0400", hash_original_field = "C01D165F17C6E2EEC58F3C790E3DF40E", hash_generated_field = "A95D73195DF54CA791FD7F8B04A8FACC")

    public static final int INPUT_OPERATION_SUCCESS = 5004;
}

