package android.bluetooth;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.237 -0400", hash_original_field = "CA257FD83AF4C9E6C265E05B6CDBF2DD", hash_generated_field = "6FCEA0ED39BC377BA765F514A42DFCE9")

    private ServiceListener mServiceListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.237 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "6EAF57CC559AB78B0231BFFF469261B9")

    private BluetoothAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.237 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "40876FBB70C48F89ADB2F95E8DF8AB42")

    private IBluetooth mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.238 -0400", hash_original_method = "97D7A1AD2A2B5CF8AA634AC52F7EF42D", hash_generated_method = "381838150C3D747428EFE659E5B96574")
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
            } 
        } 
        else
        {
            mService = null;
        } 
        
        
        
        
        
            
            
                
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.239 -0400", hash_original_method = "D3BF3BAE58FFF66435185BE94948ED76", hash_generated_method = "7E2810AC4BDE36569F993386C707233F")
     void close() {
        mServiceListener = null;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.240 -0400", hash_original_method = "F2019F4C3E8629A52034D770ECD44393", hash_generated_method = "38FEAEF50E8927791FA1B79387EFE5FB")
    public boolean connect(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(DBG)        
        log("connect(" + device + ")");
    if(mService != null && isEnabled() &&
            isValidDevice(device))        
        {
            try 
            {
                boolean varA3F65B92E3A8B04DCB7DB5B7F23777B3_1011475219 = (mService.connectInputDevice(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1290290216 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1290290216;
            } 
            catch (RemoteException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_2034213788 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1312001545 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1312001545;
            } 
        } 
    if(mService == null){ }        boolean var68934A3E9455FA72420237EB05902327_778943615 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_693902227 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_693902227;
        
        
        
            
            
                
            
                
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.242 -0400", hash_original_method = "9415AEF5C20AF4D988D1F3F693875D2E", hash_generated_method = "3A1749DF34823EF886BCB8C558E370E1")
    public boolean disconnect(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(DBG)        
        log("disconnect(" + device + ")");
    if(mService != null && isEnabled() &&
            isValidDevice(device))        
        {
            try 
            {
                boolean var86C6B7D42D1F8BA1368231D224445B5F_1740233515 = (mService.disconnectInputDevice(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1422295972 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1422295972;
            } 
            catch (RemoteException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_277000622 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_670951057 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_670951057;
            } 
        } 
    if(mService == null){ }        boolean var68934A3E9455FA72420237EB05902327_1938846315 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_222007828 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_222007828;
        
        
        
            
            
                
            
                
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.243 -0400", hash_original_method = "DD11A5A037066B819B09B91F048A8292", hash_generated_method = "4638B149DD99E39AE8F4A1D278E27E3A")
    public List<BluetoothDevice> getConnectedDevices() {
    if(DBG)        
        log("getConnectedDevices()");
    if(mService != null && isEnabled())        
        {
            try 
            {
List<BluetoothDevice> varACB830FAA71CC87E3BA33FF67170E9A4_805778990 =                 mService.getConnectedInputDevices();
                varACB830FAA71CC87E3BA33FF67170E9A4_805778990.addTaint(taint);
                return varACB830FAA71CC87E3BA33FF67170E9A4_805778990;
            } 
            catch (RemoteException e)
            {
List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_743801906 =                 new ArrayList<BluetoothDevice>();
                var0DD13883ABBA5DF8AB8CAFEE38A3B82C_743801906.addTaint(taint);
                return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_743801906;
            } 
        } 
    if(mService == null){ }List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1705382660 =         new ArrayList<BluetoothDevice>();
        var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1705382660.addTaint(taint);
        return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1705382660;
        
        
        
            
                
            
                
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.244 -0400", hash_original_method = "8CAF8E68108C6561E50EE464A6851A15", hash_generated_method = "A3232402ABD14DA4FD4482892AB2430E")
    public List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] states) {
        addTaint(states[0]);
    if(DBG)        
        log("getDevicesMatchingStates()");
    if(mService != null && isEnabled())        
        {
            try 
            {
List<BluetoothDevice> var834FE32A3912E93827D3EA3792B22C37_596070613 =                 mService.getInputDevicesMatchingConnectionStates(states);
                var834FE32A3912E93827D3EA3792B22C37_596070613.addTaint(taint);
                return var834FE32A3912E93827D3EA3792B22C37_596070613;
            } 
            catch (RemoteException e)
            {
List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_475764077 =                 new ArrayList<BluetoothDevice>();
                var0DD13883ABBA5DF8AB8CAFEE38A3B82C_475764077.addTaint(taint);
                return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_475764077;
            } 
        } 
    if(mService == null){ }List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1783941571 =         new ArrayList<BluetoothDevice>();
        var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1783941571.addTaint(taint);
        return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1783941571;
        
        
        
            
                
            
                
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.245 -0400", hash_original_method = "97B42C809342D6C6DAC05DB0DA17D1EC", hash_generated_method = "829711E0FE5A4C5C8938CE3EAADDBDFF")
    public int getConnectionState(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(DBG)        
        log("getState(" + device + ")");
    if(mService != null && isEnabled()
            && isValidDevice(device))        
        {
            try 
            {
                int var4FB190631F1D79F4E74E5C507EFD512D_59200128 = (mService.getInputDeviceConnectionState(device));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2101054452 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2101054452;
            } 
            catch (RemoteException e)
            {
                int var6DC267D6C0363C5B94F222673460F45F_1182546637 = (BluetoothProfile.STATE_DISCONNECTED);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1648731039 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1648731039;
            } 
        } 
    if(mService == null){ }        int var6DC267D6C0363C5B94F222673460F45F_1950801112 = (BluetoothProfile.STATE_DISCONNECTED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_208427263 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_208427263;
        
        
        
            
            
                
            
                
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.246 -0400", hash_original_method = "9373326E4AC064A071DC5CD973E0011C", hash_generated_method = "74BB38D178035BDC61BB291B83448B98")
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
                boolean var68934A3E9455FA72420237EB05902327_1135498848 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1911290308 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1911290308;
            } 
            try 
            {
                boolean var6CBDB0FF9F479C4D018F1B142A713E91_203835979 = (mService.setInputDevicePriority(device, priority));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1821914631 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1821914631;
            } 
            catch (RemoteException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_1377412316 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1249165441 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1249165441;
            } 
        } 
    if(mService == null){ }        boolean var68934A3E9455FA72420237EB05902327_636336392 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1547159692 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1547159692;
        
        
        
            
            
                
              
            
            
                
            
                
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.247 -0400", hash_original_method = "1D1EE6052242ABD7AAF16EB7DF8BA827", hash_generated_method = "C2D22E7803AC939BC24FB036B53B2E66")
    public int getPriority(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(DBG)        
        log("getPriority(" + device + ")");
    if(mService != null && isEnabled()
            && isValidDevice(device))        
        {
            try 
            {
                int varB5E2DFD8FE22551D2AAD99AAFE8B67FC_1665228171 = (mService.getInputDevicePriority(device));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1514190770 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1514190770;
            } 
            catch (RemoteException e)
            {
                int var77236085A0BA5825CA2134406E964D5B_71072268 = (BluetoothProfile.PRIORITY_OFF);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_442039748 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_442039748;
            } 
        } 
    if(mService == null){ }        int var77236085A0BA5825CA2134406E964D5B_92260970 = (BluetoothProfile.PRIORITY_OFF);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_770265899 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_770265899;
        
        
        
            
            
                
            
                
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.247 -0400", hash_original_method = "7937BC03D2C2DD83881BE0DF65C2C1C7", hash_generated_method = "1508FF4175CED8FA0A9C7E9DCA9AC8BB")
    private boolean isEnabled() {
    if(mAdapter.getState() == BluetoothAdapter.STATE_ON)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_984429477 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1121176322 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1121176322;
        }
        boolean var68934A3E9455FA72420237EB05902327_148671 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1329040372 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1329040372;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.248 -0400", hash_original_method = "EB67AF48F977D4A31E9F2F2B80A49421", hash_generated_method = "0325A5D4F3B5132C46F356EA9C33A6D9")
    private boolean isValidDevice(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(device == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_83194488 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1549667320 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1549667320;
        }
    if(BluetoothAdapter.checkBluetoothAddress(device.getAddress()))        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1906960750 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_936941062 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_936941062;
        }
        boolean var68934A3E9455FA72420237EB05902327_2021561720 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1833740662 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1833740662;
        
        
        
        
    }

    
        private static void log(String msg) {
        Log.d(TAG, msg);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.249 -0400", hash_original_field = "E33D61FD7578737EAE0CF59C19700E44", hash_generated_field = "16F686E671E5BDDF6BD9132F0996D923")

    private static final String TAG = "BluetoothInputDevice";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.249 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.249 -0400", hash_original_field = "97BE72EF53A96BD83EBEBA63C85ECC75", hash_generated_field = "540FA7B1A4B71D9C1548B07010E971E4")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CONNECTION_STATE_CHANGED =
        "android.bluetooth.input.profile.action.CONNECTION_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.250 -0400", hash_original_field = "4DC8E7B1B267E8E3AB529C6D578F5625", hash_generated_field = "F3CEDA651E220ABE5BBA1C470DA54607")

    public static final int INPUT_DISCONNECT_FAILED_NOT_CONNECTED = 5000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.250 -0400", hash_original_field = "5040AC488695EDF1748D25C164CEA35E", hash_generated_field = "3F7EC65F15367682B88A8F4F54E9D835")

    public static final int INPUT_CONNECT_FAILED_ALREADY_CONNECTED = 5001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.250 -0400", hash_original_field = "3EED5978C7B000263795FA31DDD91825", hash_generated_field = "A8C836966ADCA47BE0B2F2EF173A7A16")

    public static final int INPUT_CONNECT_FAILED_ATTEMPT_FAILED = 5002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.250 -0400", hash_original_field = "6E1AEFFEED1FDD01D5D70DA046B1D059", hash_generated_field = "631F101B700A8DBC14A6F825543E0B75")

    public static final int INPUT_OPERATION_GENERIC_FAILURE = 5003;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.251 -0400", hash_original_field = "C01D165F17C6E2EEC58F3C790E3DF40E", hash_generated_field = "A95D73195DF54CA791FD7F8B04A8FACC")

    public static final int INPUT_OPERATION_SUCCESS = 5004;
}

