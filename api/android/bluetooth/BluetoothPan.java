package android.bluetooth;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.List;

import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;





public final class BluetoothPan implements BluetoothProfile {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.601 -0400", hash_original_field = "CA257FD83AF4C9E6C265E05B6CDBF2DD", hash_generated_field = "6FCEA0ED39BC377BA765F514A42DFCE9")

    private ServiceListener mServiceListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.602 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "6EAF57CC559AB78B0231BFFF469261B9")

    private BluetoothAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.602 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "40876FBB70C48F89ADB2F95E8DF8AB42")

    private IBluetooth mService;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.603 -0400", hash_original_method = "E810EBD15D5869EBFF41F5C56D486678", hash_generated_method = "7C4AEF1DCE8078EA16D9235066931C54")
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.604 -0400", hash_original_method = "D3BF3BAE58FFF66435185BE94948ED76", hash_generated_method = "7E2810AC4BDE36569F993386C707233F")
     void close() {
        mServiceListener = null;
        // ---------- Original Method ----------
        //mServiceListener = null;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.604 -0400", hash_original_method = "BC5A27924327E80E349CC5C1F06F1105", hash_generated_method = "3F07033A265E669B35D574563789251B")
    public boolean connect(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(DBG)        
        log("connect(" + device + ")");
        if(mService != null && isEnabled() &&
            isValidDevice(device))        
        {
            try 
            {
                boolean var8D37F1688D7F88AD6D8C397696501FDB_822828648 = (mService.connectPanDevice(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_985574292 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_985574292;
            } //End block
            catch (RemoteException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_210307105 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_367917966 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_367917966;
            } //End block
        } //End block
        if(mService == null){ }        boolean var68934A3E9455FA72420237EB05902327_1742136708 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_560159190 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_560159190;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.605 -0400", hash_original_method = "77FBA3BD76AFD67C83A55C2CAC8093FA", hash_generated_method = "35F1D3AEB2E29EEF2E081BD450F0716B")
    public boolean disconnect(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(DBG)        
        log("disconnect(" + device + ")");
        if(mService != null && isEnabled() &&
            isValidDevice(device))        
        {
            try 
            {
                boolean var3C52C08EA13C27B54C776ED1F3966C19_1680966743 = (mService.disconnectPanDevice(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1330164466 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1330164466;
            } //End block
            catch (RemoteException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_2122810644 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1458096989 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1458096989;
            } //End block
        } //End block
        if(mService == null){ }        boolean var68934A3E9455FA72420237EB05902327_185236649 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1910671269 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1910671269;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.606 -0400", hash_original_method = "3A75F2671749E4DA82D0904A245178B4", hash_generated_method = "669C15E8FDCABED58786BA369F0A3F03")
    public List<BluetoothDevice> getConnectedDevices() {
        if(DBG)        
        log("getConnectedDevices()");
        if(mService != null && isEnabled())        
        {
            try 
            {
List<BluetoothDevice> var6407D4ECF80280021A257FD5BE1EC7C5_248461585 =                 mService.getConnectedPanDevices();
                var6407D4ECF80280021A257FD5BE1EC7C5_248461585.addTaint(taint);
                return var6407D4ECF80280021A257FD5BE1EC7C5_248461585;
            } //End block
            catch (RemoteException e)
            {
List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1247952361 =                 new ArrayList<BluetoothDevice>();
                var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1247952361.addTaint(taint);
                return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1247952361;
            } //End block
        } //End block
        if(mService == null){ }List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_2143997846 =         new ArrayList<BluetoothDevice>();
        var0DD13883ABBA5DF8AB8CAFEE38A3B82C_2143997846.addTaint(taint);
        return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_2143997846;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.607 -0400", hash_original_method = "CD9A3890717E8AE347E129B1BA75DECC", hash_generated_method = "2A9660A22982BC47526704459AA29455")
    public List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] states) {
        addTaint(states[0]);
        if(DBG)        
        log("getDevicesMatchingStates()");
        if(mService != null && isEnabled())        
        {
            try 
            {
List<BluetoothDevice> varC8AE10C9488DE333DE190403B15AF009_1743577936 =                 mService.getPanDevicesMatchingConnectionStates(states);
                varC8AE10C9488DE333DE190403B15AF009_1743577936.addTaint(taint);
                return varC8AE10C9488DE333DE190403B15AF009_1743577936;
            } //End block
            catch (RemoteException e)
            {
List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1612501955 =                 new ArrayList<BluetoothDevice>();
                var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1612501955.addTaint(taint);
                return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1612501955;
            } //End block
        } //End block
        if(mService == null){ }List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1027110410 =         new ArrayList<BluetoothDevice>();
        var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1027110410.addTaint(taint);
        return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1027110410;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.608 -0400", hash_original_method = "1530C5B663866D4821DCE21DA5245DE9", hash_generated_method = "A9722946D1967129334E04CCEAD60CA8")
    public int getConnectionState(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(DBG)        
        log("getState(" + device + ")");
        if(mService != null && isEnabled()
            && isValidDevice(device))        
        {
            try 
            {
                int varDA047ACF3B9990A7BC6FD0A61DD2E356_171714183 = (mService.getPanDeviceConnectionState(device));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_370004255 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_370004255;
            } //End block
            catch (RemoteException e)
            {
                int var6DC267D6C0363C5B94F222673460F45F_1966638823 = (BluetoothProfile.STATE_DISCONNECTED);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1866720137 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1866720137;
            } //End block
        } //End block
        if(mService == null){ }        int var6DC267D6C0363C5B94F222673460F45F_729313346 = (BluetoothProfile.STATE_DISCONNECTED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1739524202 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1739524202;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.609 -0400", hash_original_method = "F68C05AEB8B22BEDBECA5E0A17E27611", hash_generated_method = "8C1C2871EF4B5FF072B81B3A71E9392C")
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.610 -0400", hash_original_method = "5B6C4C5F18FB71C4124F888F30713582", hash_generated_method = "047675F2CBBED4279B4D1CAA694E3128")
    public boolean isTetheringOn() {
        if(DBG)        
        log("isTetheringOn()");
        try 
        {
            boolean varCD9FD4C89EC0FA7B03094886DB661C9F_1971995544 = (mService.isTetheringOn());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2099123628 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2099123628;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_2011492020 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_333863772 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_333863772;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.611 -0400", hash_original_method = "7937BC03D2C2DD83881BE0DF65C2C1C7", hash_generated_method = "916DA9E1C26C546059C5678851A1AA46")
    private boolean isEnabled() {
        if(mAdapter.getState() == BluetoothAdapter.STATE_ON)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_42295957 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_990560879 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_990560879;
        }
        boolean var68934A3E9455FA72420237EB05902327_1037812523 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_793131036 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_793131036;
        // ---------- Original Method ----------
        //if (mAdapter.getState() == BluetoothAdapter.STATE_ON) return true;
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.612 -0400", hash_original_method = "EB67AF48F977D4A31E9F2F2B80A49421", hash_generated_method = "EF110C295A91918E0AD7900D0552B5BD")
    private boolean isValidDevice(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(device == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1079116486 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_116482750 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_116482750;
        }
        if(BluetoothAdapter.checkBluetoothAddress(device.getAddress()))        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1691756434 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1082127800 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1082127800;
        }
        boolean var68934A3E9455FA72420237EB05902327_439912271 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1852689051 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1852689051;
        // ---------- Original Method ----------
        //if (device == null) return false;
        //if (BluetoothAdapter.checkBluetoothAddress(device.getAddress())) return true;
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    private static void log(String msg) {
        Log.d(TAG, msg);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.613 -0400", hash_original_field = "21D134CD10DE015F6565164C2FA2D805", hash_generated_field = "0792D7C87C3C2978768625DA7EE3C99B")

    private static final String TAG = "BluetoothPan";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.613 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.613 -0400", hash_original_field = "C154229CEBD1449088D7A3CECC32AB69", hash_generated_field = "AF14879BFF67F1F2D392E911C61A2347")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CONNECTION_STATE_CHANGED =
        "android.bluetooth.pan.profile.action.CONNECTION_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.613 -0400", hash_original_field = "66F954E7A79CFC3DF255E757C7A864A9", hash_generated_field = "A784DF22F20EE73D53FD261D7E7F1653")

    public static final String EXTRA_LOCAL_ROLE = "android.bluetooth.pan.extra.LOCAL_ROLE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.614 -0400", hash_original_field = "F904B762C02047F3E4BC66D60BBF5BDE", hash_generated_field = "AA3D62AA0C34BF7CD47C12E8E7C55E35")

    public static final int LOCAL_NAP_ROLE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.614 -0400", hash_original_field = "B8CE516E207B8CEC5954FA3C29DED660", hash_generated_field = "58D1C54BC731E1FD75A047494E90B831")

    public static final int LOCAL_PANU_ROLE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.614 -0400", hash_original_field = "9604AB6379880B7C57C61233726562C7", hash_generated_field = "8D03BF83965D0474E12D790D85090578")

    public static final int PAN_DISCONNECT_FAILED_NOT_CONNECTED = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.614 -0400", hash_original_field = "2612DC9FE929A35181AA3F945EED5499", hash_generated_field = "4A206C19028026BE2253B4A8259E7364")

    public static final int PAN_CONNECT_FAILED_ALREADY_CONNECTED = 1001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.614 -0400", hash_original_field = "8C9857816A87B5E7D9A4668C00DD19C0", hash_generated_field = "58717C2434823922B948DF5AB89B55B5")

    public static final int PAN_CONNECT_FAILED_ATTEMPT_FAILED = 1002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.614 -0400", hash_original_field = "070AE1BFB19B23AA8B63A1A7681A5C71", hash_generated_field = "1ABA76C8776D67E6DBB3A67BE1CC6C41")

    public static final int PAN_OPERATION_GENERIC_FAILURE = 1003;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.615 -0400", hash_original_field = "392769C7883816E1C4AB9DE5A6E49A49", hash_generated_field = "811C8739ED00BC2843709750BCD3A157")

    public static final int PAN_OPERATION_SUCCESS = 1004;
}

