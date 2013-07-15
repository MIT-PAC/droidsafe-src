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

public final class BluetoothPan implements BluetoothProfile {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.305 -0400", hash_original_field = "CA257FD83AF4C9E6C265E05B6CDBF2DD", hash_generated_field = "6FCEA0ED39BC377BA765F514A42DFCE9")

    private ServiceListener mServiceListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.306 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "6EAF57CC559AB78B0231BFFF469261B9")

    private BluetoothAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.306 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "40876FBB70C48F89ADB2F95E8DF8AB42")

    private IBluetooth mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.307 -0400", hash_original_method = "E810EBD15D5869EBFF41F5C56D486678", hash_generated_method = "7C4AEF1DCE8078EA16D9235066931C54")
      BluetoothPan(Context mContext, ServiceListener l) {
        addTaint(mContext.getTaint());
        IBinder b = ServiceManager.getService(BluetoothAdapter.BLUETOOTH_SERVICE);
        mServiceListener = l;
        mAdapter = BluetoothAdapter.getDefaultAdapter();
    if(b != null)        
        {
            mService = IBluetooth.Stub.asInterface(b);
    if(mServiceListener != null)            
            {
                mServiceListener.onServiceConnected(BluetoothProfile.PAN, this);
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
                //mServiceListener.onServiceConnected(BluetoothProfile.PAN, this);
            //}
        //} else {
            //Log.w(TAG, "Bluetooth Service not available!");
            //mService = null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.307 -0400", hash_original_method = "D3BF3BAE58FFF66435185BE94948ED76", hash_generated_method = "7E2810AC4BDE36569F993386C707233F")
     void close() {
        mServiceListener = null;
        // ---------- Original Method ----------
        //mServiceListener = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.308 -0400", hash_original_method = "BC5A27924327E80E349CC5C1F06F1105", hash_generated_method = "7D5FDE8DAB67F68971317BE6FBFDF329")
    public boolean connect(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(DBG)        
        log("connect(" + device + ")");
    if(mService != null && isEnabled() &&
            isValidDevice(device))        
        {
            try 
            {
                boolean var8D37F1688D7F88AD6D8C397696501FDB_1636110907 = (mService.connectPanDevice(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1356992147 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1356992147;
            } //End block
            catch (RemoteException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_1624995404 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_797275682 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_797275682;
            } //End block
        } //End block
    if(mService == null){ }        boolean var68934A3E9455FA72420237EB05902327_566049593 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2089474739 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2089474739;
        // ---------- Original Method ----------
        //if (DBG) log("connect(" + device + ")");
        //if (mService != null && isEnabled() &&
            //isValidDevice(device)) {
            //try {
                //return mService.connectPanDevice(device);
            //} catch (RemoteException e) {
                //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                //return false;
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.310 -0400", hash_original_method = "77FBA3BD76AFD67C83A55C2CAC8093FA", hash_generated_method = "8C2FEEDC90AD733AF80B656A7F907140")
    public boolean disconnect(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(DBG)        
        log("disconnect(" + device + ")");
    if(mService != null && isEnabled() &&
            isValidDevice(device))        
        {
            try 
            {
                boolean var3C52C08EA13C27B54C776ED1F3966C19_2094223265 = (mService.disconnectPanDevice(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1045812054 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1045812054;
            } //End block
            catch (RemoteException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_1821756931 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1261313458 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1261313458;
            } //End block
        } //End block
    if(mService == null){ }        boolean var68934A3E9455FA72420237EB05902327_372000273 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1831382436 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1831382436;
        // ---------- Original Method ----------
        //if (DBG) log("disconnect(" + device + ")");
        //if (mService != null && isEnabled() &&
            //isValidDevice(device)) {
            //try {
                //return mService.disconnectPanDevice(device);
            //} catch (RemoteException e) {
                //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                //return false;
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.311 -0400", hash_original_method = "3A75F2671749E4DA82D0904A245178B4", hash_generated_method = "9AD389FC6AC27B4E943F1337FE0417BC")
    public List<BluetoothDevice> getConnectedDevices() {
    if(DBG)        
        log("getConnectedDevices()");
    if(mService != null && isEnabled())        
        {
            try 
            {
List<BluetoothDevice> var6407D4ECF80280021A257FD5BE1EC7C5_1263016359 =                 mService.getConnectedPanDevices();
                var6407D4ECF80280021A257FD5BE1EC7C5_1263016359.addTaint(taint);
                return var6407D4ECF80280021A257FD5BE1EC7C5_1263016359;
            } //End block
            catch (RemoteException e)
            {
List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1961692371 =                 new ArrayList<BluetoothDevice>();
                var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1961692371.addTaint(taint);
                return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1961692371;
            } //End block
        } //End block
    if(mService == null){ }List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_2025474471 =         new ArrayList<BluetoothDevice>();
        var0DD13883ABBA5DF8AB8CAFEE38A3B82C_2025474471.addTaint(taint);
        return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_2025474471;
        // ---------- Original Method ----------
        //if (DBG) log("getConnectedDevices()");
        //if (mService != null && isEnabled()) {
            //try {
                //return mService.getConnectedPanDevices();
            //} catch (RemoteException e) {
                //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                //return new ArrayList<BluetoothDevice>();
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return new ArrayList<BluetoothDevice>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.312 -0400", hash_original_method = "CD9A3890717E8AE347E129B1BA75DECC", hash_generated_method = "58B7BA8CB5BC4D045FE14C2D12DB5B34")
    public List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] states) {
        addTaint(states[0]);
    if(DBG)        
        log("getDevicesMatchingStates()");
    if(mService != null && isEnabled())        
        {
            try 
            {
List<BluetoothDevice> varC8AE10C9488DE333DE190403B15AF009_742987998 =                 mService.getPanDevicesMatchingConnectionStates(states);
                varC8AE10C9488DE333DE190403B15AF009_742987998.addTaint(taint);
                return varC8AE10C9488DE333DE190403B15AF009_742987998;
            } //End block
            catch (RemoteException e)
            {
List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1515711446 =                 new ArrayList<BluetoothDevice>();
                var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1515711446.addTaint(taint);
                return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1515711446;
            } //End block
        } //End block
    if(mService == null){ }List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1627633097 =         new ArrayList<BluetoothDevice>();
        var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1627633097.addTaint(taint);
        return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1627633097;
        // ---------- Original Method ----------
        //if (DBG) log("getDevicesMatchingStates()");
        //if (mService != null && isEnabled()) {
            //try {
                //return mService.getPanDevicesMatchingConnectionStates(states);
            //} catch (RemoteException e) {
                //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                //return new ArrayList<BluetoothDevice>();
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return new ArrayList<BluetoothDevice>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.313 -0400", hash_original_method = "1530C5B663866D4821DCE21DA5245DE9", hash_generated_method = "1FB04243ED196CBC61B37FCBBA08D6F8")
    public int getConnectionState(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(DBG)        
        log("getState(" + device + ")");
    if(mService != null && isEnabled()
            && isValidDevice(device))        
        {
            try 
            {
                int varDA047ACF3B9990A7BC6FD0A61DD2E356_1847347390 = (mService.getPanDeviceConnectionState(device));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_471741313 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_471741313;
            } //End block
            catch (RemoteException e)
            {
                int var6DC267D6C0363C5B94F222673460F45F_1612325419 = (BluetoothProfile.STATE_DISCONNECTED);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2085664004 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2085664004;
            } //End block
        } //End block
    if(mService == null){ }        int var6DC267D6C0363C5B94F222673460F45F_1590919890 = (BluetoothProfile.STATE_DISCONNECTED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_428130031 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_428130031;
        // ---------- Original Method ----------
        //if (DBG) log("getState(" + device + ")");
        //if (mService != null && isEnabled()
            //&& isValidDevice(device)) {
            //try {
                //return mService.getPanDeviceConnectionState(device);
            //} catch (RemoteException e) {
                //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                //return BluetoothProfile.STATE_DISCONNECTED;
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return BluetoothProfile.STATE_DISCONNECTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.313 -0400", hash_original_method = "F68C05AEB8B22BEDBECA5E0A17E27611", hash_generated_method = "8C1C2871EF4B5FF072B81B3A71E9392C")
    public void setBluetoothTethering(boolean value) {
        addTaint(value);
    if(DBG)        
        log("setBluetoothTethering(" + value + ")");
        try 
        {
            mService.setBluetoothTethering(value);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //if (DBG) log("setBluetoothTethering(" + value + ")");
        //try {
            //mService.setBluetoothTethering(value);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.314 -0400", hash_original_method = "5B6C4C5F18FB71C4124F888F30713582", hash_generated_method = "B8837796B9962E6EA07B27DB0D605646")
    public boolean isTetheringOn() {
    if(DBG)        
        log("isTetheringOn()");
        try 
        {
            boolean varCD9FD4C89EC0FA7B03094886DB661C9F_2002811844 = (mService.isTetheringOn());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_387448259 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_387448259;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1098130702 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1014259263 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1014259263;
        } //End block
        // ---------- Original Method ----------
        //if (DBG) log("isTetheringOn()");
        //try {
            //return mService.isTetheringOn();
        //} catch (RemoteException e) {
            //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.314 -0400", hash_original_method = "7937BC03D2C2DD83881BE0DF65C2C1C7", hash_generated_method = "692C47D2FBADF7D61C598E34B1B7D977")
    private boolean isEnabled() {
    if(mAdapter.getState() == BluetoothAdapter.STATE_ON)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1790463389 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_517051273 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_517051273;
        }
        boolean var68934A3E9455FA72420237EB05902327_2103081362 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2139779935 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2139779935;
        // ---------- Original Method ----------
        //if (mAdapter.getState() == BluetoothAdapter.STATE_ON) return true;
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.315 -0400", hash_original_method = "EB67AF48F977D4A31E9F2F2B80A49421", hash_generated_method = "D3651B425611EF8A1366F476F05379E4")
    private boolean isValidDevice(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(device == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1798354249 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1145999173 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1145999173;
        }
    if(BluetoothAdapter.checkBluetoothAddress(device.getAddress()))        
        {
        boolean varB326B5062B2F0E69046810717534CB09_2066562227 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1389974700 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1389974700;
        }
        boolean var68934A3E9455FA72420237EB05902327_1359709641 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1544665854 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1544665854;
        // ---------- Original Method ----------
        //if (device == null) return false;
        //if (BluetoothAdapter.checkBluetoothAddress(device.getAddress())) return true;
        //return false;
    }

    
        private static void log(String msg) {
        Log.d(TAG, msg);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.315 -0400", hash_original_field = "21D134CD10DE015F6565164C2FA2D805", hash_generated_field = "0792D7C87C3C2978768625DA7EE3C99B")

    private static final String TAG = "BluetoothPan";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.316 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.316 -0400", hash_original_field = "C154229CEBD1449088D7A3CECC32AB69", hash_generated_field = "AF14879BFF67F1F2D392E911C61A2347")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CONNECTION_STATE_CHANGED =
        "android.bluetooth.pan.profile.action.CONNECTION_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.316 -0400", hash_original_field = "66F954E7A79CFC3DF255E757C7A864A9", hash_generated_field = "A784DF22F20EE73D53FD261D7E7F1653")

    public static final String EXTRA_LOCAL_ROLE = "android.bluetooth.pan.extra.LOCAL_ROLE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.316 -0400", hash_original_field = "F904B762C02047F3E4BC66D60BBF5BDE", hash_generated_field = "AA3D62AA0C34BF7CD47C12E8E7C55E35")

    public static final int LOCAL_NAP_ROLE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.316 -0400", hash_original_field = "B8CE516E207B8CEC5954FA3C29DED660", hash_generated_field = "58D1C54BC731E1FD75A047494E90B831")

    public static final int LOCAL_PANU_ROLE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.316 -0400", hash_original_field = "9604AB6379880B7C57C61233726562C7", hash_generated_field = "8D03BF83965D0474E12D790D85090578")

    public static final int PAN_DISCONNECT_FAILED_NOT_CONNECTED = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.316 -0400", hash_original_field = "2612DC9FE929A35181AA3F945EED5499", hash_generated_field = "4A206C19028026BE2253B4A8259E7364")

    public static final int PAN_CONNECT_FAILED_ALREADY_CONNECTED = 1001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.317 -0400", hash_original_field = "8C9857816A87B5E7D9A4668C00DD19C0", hash_generated_field = "58717C2434823922B948DF5AB89B55B5")

    public static final int PAN_CONNECT_FAILED_ATTEMPT_FAILED = 1002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.317 -0400", hash_original_field = "070AE1BFB19B23AA8B63A1A7681A5C71", hash_generated_field = "1ABA76C8776D67E6DBB3A67BE1CC6C41")

    public static final int PAN_OPERATION_GENERIC_FAILURE = 1003;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.317 -0400", hash_original_field = "392769C7883816E1C4AB9DE5A6E49A49", hash_generated_field = "811C8739ED00BC2843709750BCD3A157")

    public static final int PAN_OPERATION_SUCCESS = 1004;
}

