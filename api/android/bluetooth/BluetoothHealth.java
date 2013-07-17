package android.bluetooth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public final class BluetoothHealth implements BluetoothProfile {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.364 -0400", hash_original_field = "CA257FD83AF4C9E6C265E05B6CDBF2DD", hash_generated_field = "6FCEA0ED39BC377BA765F514A42DFCE9")

    private ServiceListener mServiceListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.364 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "40876FBB70C48F89ADB2F95E8DF8AB42")

    private IBluetooth mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.364 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "367F0BC6BC216C571A7E906A286477DF")

    BluetoothAdapter mAdapter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.366 -0400", hash_original_method = "913BD9E94B09B64A9AACEEEF134BFD21", hash_generated_method = "C4EE4444E580B98933F8DEABD4D6FC72")
      BluetoothHealth(Context mContext, ServiceListener l) {
        addTaint(mContext.getTaint());
        IBinder b = ServiceManager.getService(BluetoothAdapter.BLUETOOTH_SERVICE);
        mServiceListener = l;
        mAdapter = BluetoothAdapter.getDefaultAdapter();
        if(b != null)        
        {
            mService = IBluetooth.Stub.asInterface(b);
            if(mServiceListener != null)            
            {
                mServiceListener.onServiceConnected(BluetoothProfile.HEALTH, this);
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
                //mServiceListener.onServiceConnected(BluetoothProfile.HEALTH, this);
            //}
        //} else {
            //Log.w(TAG, "Bluetooth Service not available!");
            //mService = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.368 -0400", hash_original_method = "03B44160021EEDDFCC6AB190DB37D972", hash_generated_method = "1A2B3CAC6B8A9AB6AA216EC384B406DD")
    public boolean registerSinkAppConfiguration(String name, int dataType,
            BluetoothHealthCallback callback) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(callback.getTaint());
        addTaint(dataType);
        addTaint(name.getTaint());
        if(!isEnabled() || name == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_232567616 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1320594920 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1320594920;
        }
        if(DBG)        
        log("registerSinkApplication(" + name + ":" + dataType + ")");
        boolean varA0D7A75D58E0D6A439A357236579A3DF_622667017 = (registerAppConfiguration(name, dataType, SINK_ROLE,
                CHANNEL_TYPE_ANY, callback));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1892574954 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1892574954;
        // ---------- Original Method ----------
        //if (!isEnabled() || name == null) return false;
        //if (DBG) log("registerSinkApplication(" + name + ":" + dataType + ")");
        //return registerAppConfiguration(name, dataType, SINK_ROLE,
                //CHANNEL_TYPE_ANY, callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.372 -0400", hash_original_method = "D5CE227EABEF7149743D2E168D147812", hash_generated_method = "AF3E5FA5C2EFD8F4A10260A8B5EE488C")
    public boolean registerAppConfiguration(String name, int dataType, int role,
            int channelType, BluetoothHealthCallback callback) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(callback.getTaint());
        addTaint(channelType);
        addTaint(role);
        addTaint(dataType);
        addTaint(name.getTaint());
        boolean result = false;
        if(!isEnabled() || !checkAppParam(name, role, channelType, callback))        
        {
        boolean varB4A88417B3D0170D754C647C30B7216A_1767196338 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1330054129 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1330054129;
        }
        if(DBG)        
        log("registerApplication(" + name + ":" + dataType + ")");
        BluetoothHealthCallbackWrapper wrapper = new BluetoothHealthCallbackWrapper(callback);
        BluetoothHealthAppConfiguration config = new BluetoothHealthAppConfiguration(name, dataType, role, channelType);
        if(mService != null)        
        {
            try 
            {
                result = mService.registerAppConfiguration(config, wrapper);
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
        boolean varB4A88417B3D0170D754C647C30B7216A_563427761 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1348426430 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1348426430;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.374 -0400", hash_original_method = "5D40895745D5003C2A110228B091A7E7", hash_generated_method = "522760DF396AB6BFC168C75505F02401")
    public boolean unregisterAppConfiguration(BluetoothHealthAppConfiguration config) {
        addTaint(config.getTaint());
        boolean result = false;
        if(mService != null && isEnabled() && config != null)        
        {
            try 
            {
                result = mService.unregisterAppConfiguration(config);
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
        boolean varB4A88417B3D0170D754C647C30B7216A_762554339 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_174326960 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_174326960;
        // ---------- Original Method ----------
        //boolean result = false;
        //if (mService != null && isEnabled() && config != null) {
            //try {
                //result = mService.unregisterAppConfiguration(config);
            //} catch (RemoteException e) {
                //Log.e(TAG, e.toString());
            //}
        //} else {
            //Log.w(TAG, "Proxy not attached to service");
            //if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.385 -0400", hash_original_method = "4C5652381F40D80F378A67E94EAAA0B6", hash_generated_method = "9BCB6D136F67287DA146E687497DA488")
    public boolean connectChannelToSource(BluetoothDevice device,
            BluetoothHealthAppConfiguration config) {
        addTaint(config.getTaint());
        addTaint(device.getTaint());
        if(mService != null && isEnabled() && isValidDevice(device) &&
                config != null)        
        {
            try 
            {
                boolean var4018DA102F4EEDC00F89F6D601B5408F_124626295 = (mService.connectChannelToSource(device, config));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_485087275 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_485087275;
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
        boolean var68934A3E9455FA72420237EB05902327_2066894652 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1580692804 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1580692804;
        // ---------- Original Method ----------
        //if (mService != null && isEnabled() && isValidDevice(device) &&
                //config != null) {
            //try {
                //return mService.connectChannelToSource(device, config);
            //} catch (RemoteException e) {
                //Log.e(TAG, e.toString());
            //}
        //} else {
            //Log.w(TAG, "Proxy not attached to service");
            //if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.393 -0400", hash_original_method = "19CF31F36DE841625F90701557FAC848", hash_generated_method = "F3C977B8BCD85DC33C461F43DD37C2B1")
    public boolean connectChannelToSink(BluetoothDevice device,
            BluetoothHealthAppConfiguration config, int channelType) {
        addTaint(channelType);
        addTaint(config.getTaint());
        addTaint(device.getTaint());
        if(mService != null && isEnabled() && isValidDevice(device) &&
                config != null)        
        {
            try 
            {
                boolean var7EC348A47A1D71235D6012750C86D703_1564264369 = (mService.connectChannelToSink(device, config, channelType));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_17088846 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_17088846;
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
        boolean var68934A3E9455FA72420237EB05902327_1376675766 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_265895362 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_265895362;
        // ---------- Original Method ----------
        //if (mService != null && isEnabled() && isValidDevice(device) &&
                //config != null) {
            //try {
                //return mService.connectChannelToSink(device, config, channelType);
            //} catch (RemoteException e) {
                //Log.e(TAG, e.toString());
            //}
        //} else {
            //Log.w(TAG, "Proxy not attached to service");
            //if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.396 -0400", hash_original_method = "8C34D08E0EC2B4EB680B1ECA4FAF1C1B", hash_generated_method = "0BA6B4F46F7CC4EAD7CBE2E10DED1517")
    public boolean disconnectChannel(BluetoothDevice device,
            BluetoothHealthAppConfiguration config, int channelId) {
        addTaint(channelId);
        addTaint(config.getTaint());
        addTaint(device.getTaint());
        if(mService != null && isEnabled() && isValidDevice(device) &&
                config != null)        
        {
            try 
            {
                boolean var155E33497C24A8DD8BBE975B520B2106_2038465061 = (mService.disconnectChannel(device, config, channelId));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_962758988 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_962758988;
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
        boolean var68934A3E9455FA72420237EB05902327_682987829 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2064957404 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2064957404;
        // ---------- Original Method ----------
        //if (mService != null && isEnabled() && isValidDevice(device) &&
                //config != null) {
            //try {
                //return mService.disconnectChannel(device, config, channelId);
            //} catch (RemoteException e) {
                //Log.e(TAG, e.toString());
            //}
        //} else {
            //Log.w(TAG, "Proxy not attached to service");
            //if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.397 -0400", hash_original_method = "56EA1CE9CB56305F9C3F6804737421F5", hash_generated_method = "19C55E7BFA3BECB403148A8960D98955")
    public ParcelFileDescriptor getMainChannelFd(BluetoothDevice device,
            BluetoothHealthAppConfiguration config) {
        addTaint(config.getTaint());
        addTaint(device.getTaint());
        if(mService != null && isEnabled() && isValidDevice(device) &&
                config != null)        
        {
            try 
            {
ParcelFileDescriptor var8FA2BDC3FA95CAE7B7414AAFC25085E7_1569866993 =                 mService.getMainChannelFd(device, config);
                var8FA2BDC3FA95CAE7B7414AAFC25085E7_1569866993.addTaint(taint);
                return var8FA2BDC3FA95CAE7B7414AAFC25085E7_1569866993;
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
ParcelFileDescriptor var540C13E9E156B687226421B24F2DF178_302825634 =         null;
        var540C13E9E156B687226421B24F2DF178_302825634.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_302825634;
        // ---------- Original Method ----------
        //if (mService != null && isEnabled() && isValidDevice(device) &&
                //config != null) {
            //try {
                //return mService.getMainChannelFd(device, config);
            //} catch (RemoteException e) {
                //Log.e(TAG, e.toString());
            //}
        //} else {
            //Log.w(TAG, "Proxy not attached to service");
            //if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.399 -0400", hash_original_method = "EF385FC85E116FE9230DC48DB39B0D5E", hash_generated_method = "707DC7F391D8A345C039127ED3C59E37")
    @Override
    public int getConnectionState(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(mService != null && isEnabled() && isValidDevice(device))        
        {
            try 
            {
                int varD265F06680F89F6B56211E193F206697_1463255358 = (mService.getHealthDeviceConnectionState(device));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_291076805 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_291076805;
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
        int varABFB3174B1E65FE97DCD3DE70218F370_436892656 = (STATE_DISCONNECTED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1371696648 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1371696648;
        // ---------- Original Method ----------
        //if (mService != null && isEnabled() && isValidDevice(device)) {
            //try {
                //return mService.getHealthDeviceConnectionState(device);
            //} catch (RemoteException e) {
                //Log.e(TAG, e.toString());
            //}
        //} else {
            //Log.w(TAG, "Proxy not attached to service");
            //if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        //}
        //return STATE_DISCONNECTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.400 -0400", hash_original_method = "27E5D0D39947E94A7B208AD0BB996AC3", hash_generated_method = "C60ACA25E4B7FF01108D235CA543D1CD")
    @Override
    public List<BluetoothDevice> getConnectedDevices() {
        if(mService != null && isEnabled())        
        {
            try 
            {
List<BluetoothDevice> var67653FBF9B16DCC4DAD7E9B2EFAD83AE_1995006098 =                 mService.getConnectedHealthDevices();
                var67653FBF9B16DCC4DAD7E9B2EFAD83AE_1995006098.addTaint(taint);
                return var67653FBF9B16DCC4DAD7E9B2EFAD83AE_1995006098;
            } //End block
            catch (RemoteException e)
            {
List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_13085032 =                 new ArrayList<BluetoothDevice>();
                var0DD13883ABBA5DF8AB8CAFEE38A3B82C_13085032.addTaint(taint);
                return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_13085032;
            } //End block
        } //End block
        if(mService == null){ }List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1500447004 =         new ArrayList<BluetoothDevice>();
        var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1500447004.addTaint(taint);
        return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1500447004;
        // ---------- Original Method ----------
        //if (mService != null && isEnabled()) {
            //try {
                //return mService.getConnectedHealthDevices();
            //} catch (RemoteException e) {
                //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                //return new ArrayList<BluetoothDevice>();
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return new ArrayList<BluetoothDevice>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.403 -0400", hash_original_method = "D442D88CEFF8EB23E79F375C10E7E4FC", hash_generated_method = "3B93D8DD76B88AD045FD34C44015C93C")
    @Override
    public List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] states) {
        addTaint(states[0]);
        if(mService != null && isEnabled())        
        {
            try 
            {
List<BluetoothDevice> varDFEBCE90D930A2FBBC5E2E9C7DEABB7B_27418669 =                 mService.getHealthDevicesMatchingConnectionStates(states);
                varDFEBCE90D930A2FBBC5E2E9C7DEABB7B_27418669.addTaint(taint);
                return varDFEBCE90D930A2FBBC5E2E9C7DEABB7B_27418669;
            } //End block
            catch (RemoteException e)
            {
List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1522697720 =                 new ArrayList<BluetoothDevice>();
                var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1522697720.addTaint(taint);
                return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1522697720;
            } //End block
        } //End block
        if(mService == null){ }List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_371188437 =         new ArrayList<BluetoothDevice>();
        var0DD13883ABBA5DF8AB8CAFEE38A3B82C_371188437.addTaint(taint);
        return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_371188437;
        // ---------- Original Method ----------
        //if (mService != null && isEnabled()) {
            //try {
                //return mService.getHealthDevicesMatchingConnectionStates(states);
            //} catch (RemoteException e) {
                //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                //return new ArrayList<BluetoothDevice>();
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return new ArrayList<BluetoothDevice>();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.405 -0400", hash_original_method = "D3BF3BAE58FFF66435185BE94948ED76", hash_generated_method = "7E2810AC4BDE36569F993386C707233F")
     void close() {
        mServiceListener = null;
        // ---------- Original Method ----------
        //mServiceListener = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.406 -0400", hash_original_method = "917CCC75EC61E4A55AAE92F70BBDD3C7", hash_generated_method = "822D6306C256C42685BAB34F2077CEC4")
    private boolean isEnabled() {
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        if(adapter != null && adapter.getState() == BluetoothAdapter.STATE_ON)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_741888510 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2013430447 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2013430447;
        }
        log("Bluetooth is Not enabled");
        boolean var68934A3E9455FA72420237EB05902327_1469954195 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1725452895 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1725452895;
        // ---------- Original Method ----------
        //BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        //if (adapter != null && adapter.getState() == BluetoothAdapter.STATE_ON) return true;
        //log("Bluetooth is Not enabled");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.407 -0400", hash_original_method = "EB67AF48F977D4A31E9F2F2B80A49421", hash_generated_method = "C96F51BCC3C6AE9BFF4A33DD369C59BC")
    private boolean isValidDevice(BluetoothDevice device) {
        addTaint(device.getTaint());
        if(device == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_377018938 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1457747233 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1457747233;
        }
        if(BluetoothAdapter.checkBluetoothAddress(device.getAddress()))        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1730765257 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1679125989 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1679125989;
        }
        boolean var68934A3E9455FA72420237EB05902327_463709359 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_978383715 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_978383715;
        // ---------- Original Method ----------
        //if (device == null) return false;
        //if (BluetoothAdapter.checkBluetoothAddress(device.getAddress())) return true;
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.408 -0400", hash_original_method = "55A0A269422935E819E2C55F9C91FE5D", hash_generated_method = "C147AAFB26DE9067E1C71D89B38DD5B1")
    private boolean checkAppParam(String name, int role, int channelType,
            BluetoothHealthCallback callback) {
        addTaint(callback.getTaint());
        addTaint(channelType);
        addTaint(role);
        addTaint(name.getTaint());
        if(name == null || (role != SOURCE_ROLE && role != SINK_ROLE) ||
                (channelType != CHANNEL_TYPE_RELIABLE &&
                channelType != CHANNEL_TYPE_STREAMING &&
                channelType != CHANNEL_TYPE_ANY) || callback == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_542756252 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_684248968 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_684248968;
        } //End block
        if(role == SOURCE_ROLE && channelType == CHANNEL_TYPE_ANY)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1865396051 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1058989315 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1058989315;
        }
        boolean varB326B5062B2F0E69046810717534CB09_122749385 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_211652828 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_211652828;
        // ---------- Original Method ----------
        //if (name == null || (role != SOURCE_ROLE && role != SINK_ROLE) ||
                //(channelType != CHANNEL_TYPE_RELIABLE &&
                //channelType != CHANNEL_TYPE_STREAMING &&
                //channelType != CHANNEL_TYPE_ANY) || callback == null) {
            //return false;
        //}
        //if (role == SOURCE_ROLE && channelType == CHANNEL_TYPE_ANY) return false;
        //return true;
    }

    
    private static void log(String msg) {
        Log.d(TAG, msg);
    }

    
    private static class BluetoothHealthCallbackWrapper extends IBluetoothHealthCallback.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.408 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "3AC95B6D8598783F18892228E574790F")

        private BluetoothHealthCallback mCallback;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.409 -0400", hash_original_method = "052172748E38AFDC47B4485751DFA95F", hash_generated_method = "EE63100FF09CF821946E1B8C4DF0A2B5")
        public  BluetoothHealthCallbackWrapper(BluetoothHealthCallback callback) {
            mCallback = callback;
            // ---------- Original Method ----------
            //mCallback = callback;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.410 -0400", hash_original_method = "F3F9CD11323FD103B4D93BE8A7C73A18", hash_generated_method = "4CF7BF6F920186C94351DFFD77449677")
        @Override
        public void onHealthAppConfigurationStatusChange(BluetoothHealthAppConfiguration config,
                                                         int status) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(status);
            addTaint(config.getTaint());
            mCallback.onHealthAppConfigurationStatusChange(config, status);
            // ---------- Original Method ----------
            //mCallback.onHealthAppConfigurationStatusChange(config, status);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.411 -0400", hash_original_method = "74682BF5DF2CADBD7F49F1BEE1C54F59", hash_generated_method = "43A80ABCE5BC3E28F492925EB165986B")
        @Override
        public void onHealthChannelStateChange(BluetoothHealthAppConfiguration config,
                                       BluetoothDevice device, int prevState, int newState,
                                       ParcelFileDescriptor fd, int channelId) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(channelId);
            addTaint(fd.getTaint());
            addTaint(newState);
            addTaint(prevState);
            addTaint(device.getTaint());
            addTaint(config.getTaint());
            mCallback.onHealthChannelStateChange(config, device, prevState, newState, fd,
                                                 channelId);
            // ---------- Original Method ----------
            //mCallback.onHealthChannelStateChange(config, device, prevState, newState, fd,
                                                 //channelId);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.411 -0400", hash_original_field = "F03E3AC98FAE62FFEC2C4EA2BBA9BC52", hash_generated_field = "AE145E568188D4221758B10860857593")

    private static final String TAG = "BluetoothHealth";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.412 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.412 -0400", hash_original_field = "EAD5D335206B30F2EDEC3CE413959305", hash_generated_field = "6A8A7B99F8542D30842145F7D4BAC183")

    public static final int SOURCE_ROLE = 1 << 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.412 -0400", hash_original_field = "5CC4CBD7C9644B9CFBDAA0EC794B86E2", hash_generated_field = "7F3B93A0179A065EA64332CDBCE1355C")

    public static final int SINK_ROLE = 1 << 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.412 -0400", hash_original_field = "4294B441284CCB6662E68675B38757C6", hash_generated_field = "80D1A2EE2CC2B4AFBC662F917DD5A7BD")

    public static final int CHANNEL_TYPE_RELIABLE = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.413 -0400", hash_original_field = "AC7834FF6B0B88B4991EE7C07B080B39", hash_generated_field = "459638AC523B24C86FE56EF4B6EAE409")

    public static final int CHANNEL_TYPE_STREAMING = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.413 -0400", hash_original_field = "F685DAA2B56D58878A0E2FEB2F4C28F7", hash_generated_field = "91383287A0A3BDA8A08AA3C621BFEBDB")

    public static final int CHANNEL_TYPE_ANY = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.413 -0400", hash_original_field = "049D9C581A245F78B7C9354057741E38", hash_generated_field = "B5AE030E3488E3595615904D776FE6C7")

    public static final int HEALTH_OPERATION_SUCCESS = 6000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.413 -0400", hash_original_field = "A06CFDEEEC2653D8D4AFAB0C98B41E1F", hash_generated_field = "CEA5BE9F41CA14F07195984206A830C2")

    public static final int HEALTH_OPERATION_ERROR = 6001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.413 -0400", hash_original_field = "D5529C8A6B315C6B2DB49709E8206273", hash_generated_field = "C200B8378396302C1CF3DC1005073CE2")

    public static final int HEALTH_OPERATION_INVALID_ARGS = 6002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.413 -0400", hash_original_field = "29935B064FD45FAAD4736D3884AFFE30", hash_generated_field = "E1BE80A0FED6E9151699728215BD1ABE")

    public static final int HEALTH_OPERATION_GENERIC_FAILURE = 6003;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.413 -0400", hash_original_field = "62A16EC80FB385554791BAD3D13100DA", hash_generated_field = "47EE76CA2A85DB1D0333BEDFC2014A0F")

    public static final int HEALTH_OPERATION_NOT_FOUND = 6004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.414 -0400", hash_original_field = "A1903B09F7413DD912CBB22EF99A6EB9", hash_generated_field = "D1B4E8A22AA5FB39987A65C353902B2A")

    public static final int HEALTH_OPERATION_NOT_ALLOWED = 6005;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.414 -0400", hash_original_field = "8EFA2F7FB29ADC406F86DF90170A3FBF", hash_generated_field = "B5BD60CB07BBB3772D54340CC1FDC28A")

    public static final int STATE_CHANNEL_DISCONNECTED  = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.414 -0400", hash_original_field = "31C56BB386932EF41BD00F65781A7108", hash_generated_field = "E745C4EA35FBCB73D9337A520A889523")

    public static final int STATE_CHANNEL_CONNECTING    = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.414 -0400", hash_original_field = "794C5C3578D9DAC15A634F25D46C42BA", hash_generated_field = "31A3A3922F6724E2BBEA5BC9E8F270E3")

    public static final int STATE_CHANNEL_CONNECTED     = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.414 -0400", hash_original_field = "73D8B9793503AC0B2D0D76D0D3B6133B", hash_generated_field = "9DA663A725662DEB1BAD910553A5F112")

    public static final int STATE_CHANNEL_DISCONNECTING = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.414 -0400", hash_original_field = "6E58414A7AA7030D4BE89D954ED84054", hash_generated_field = "8352EB26F7DA6E75D8A431459C669736")

    public static final int APP_CONFIG_REGISTRATION_SUCCESS = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.415 -0400", hash_original_field = "F2495560C558DC511F645B7B8E0AA486", hash_generated_field = "E0F008A46B0265984580B5C0AD2705BA")

    public static final int APP_CONFIG_REGISTRATION_FAILURE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.415 -0400", hash_original_field = "981A91CBF43C573AFBD6795E6AD8A247", hash_generated_field = "A55DC8C9A68DF76EC5BAF1FD82BC8BA7")

    public static final int APP_CONFIG_UNREGISTRATION_SUCCESS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.415 -0400", hash_original_field = "789F7C104D3241CFB33AD220702AC7AF", hash_generated_field = "7F5EC86D8F5BE99FA96B189FEF77A752")

    public static final int APP_CONFIG_UNREGISTRATION_FAILURE = 3;
}

