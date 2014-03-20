package android.bluetooth;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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

public final class BluetoothInputDevice implements BluetoothProfile {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.403 -0500", hash_original_method = "0EBF7673E44AF610ADC3AB53A65BD597", hash_generated_method = "12E4FDCE2D2661CC6DF9F077D2C0BB73")
    
private static void log(String msg) {
      Log.d(TAG, msg);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.348 -0500", hash_original_field = "76AFA513717428DDC84DF2B14430121D", hash_generated_field = "16F686E671E5BDDF6BD9132F0996D923")

    private static final String TAG = "BluetoothInputDevice";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.350 -0500", hash_original_field = "B2601CA7445F6BA19FA7884763D82281", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.353 -0500", hash_original_field = "DB711659EBB0F5F45B5E75E643E91B15", hash_generated_field = "540FA7B1A4B71D9C1548B07010E971E4")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CONNECTION_STATE_CHANGED =
        "android.bluetooth.input.profile.action.CONNECTION_STATE_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.355 -0500", hash_original_field = "971C6903332D4B6A089275D8FD336627", hash_generated_field = "F3CEDA651E220ABE5BBA1C470DA54607")

    public static final int INPUT_DISCONNECT_FAILED_NOT_CONNECTED = 5000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.358 -0500", hash_original_field = "9F1937912939824C568459F154DFE6B3", hash_generated_field = "3F7EC65F15367682B88A8F4F54E9D835")

    public static final int INPUT_CONNECT_FAILED_ALREADY_CONNECTED = 5001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.361 -0500", hash_original_field = "0DF1488F1C0AACF3BD3C055E0AB77B83", hash_generated_field = "A8C836966ADCA47BE0B2F2EF173A7A16")

    public static final int INPUT_CONNECT_FAILED_ATTEMPT_FAILED = 5002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.363 -0500", hash_original_field = "EDBD1EA36D77D86864948DE164E99121", hash_generated_field = "631F101B700A8DBC14A6F825543E0B75")

    public static final int INPUT_OPERATION_GENERIC_FAILURE = 5003;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.365 -0500", hash_original_field = "656F17C409F8D6CFCE86239401241D1F", hash_generated_field = "A95D73195DF54CA791FD7F8B04A8FACC")

    public static final int INPUT_OPERATION_SUCCESS = 5004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.367 -0500", hash_original_field = "AD4810E1EAEE0B4F351A0550C3A3183B", hash_generated_field = "6FCEA0ED39BC377BA765F514A42DFCE9")

    private ServiceListener mServiceListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.369 -0500", hash_original_field = "367F0BC6BC216C571A7E906A286477DF", hash_generated_field = "6EAF57CC559AB78B0231BFFF469261B9")

    private BluetoothAdapter mAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.371 -0500", hash_original_field = "E6C68E4A2725AB507547EA6B7D87DBDC", hash_generated_field = "40876FBB70C48F89ADB2F95E8DF8AB42")

    private IBluetooth mService;

    /**
     * Create a BluetoothInputDevice proxy object for interacting with the local
     * Bluetooth Service which handles the InputDevice profile
     *
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.374 -0500", hash_original_method = "97D7A1AD2A2B5CF8AA634AC52F7EF42D", hash_generated_method = "1F32A28347F2361A06AF9FAEFCDD0E14")
    
BluetoothInputDevice(Context mContext, ServiceListener l) {
        IBinder b = ServiceManager.getService(BluetoothAdapter.BLUETOOTH_SERVICE);
        mServiceListener = l;
        mAdapter = BluetoothAdapter.getDefaultAdapter();
        if (b != null) {
            mService = IBluetooth.Stub.asInterface(b);
            if (mServiceListener != null) {
                mServiceListener.onServiceConnected(BluetoothProfile.INPUT_DEVICE, this);
            }
        } else {
            Log.w(TAG, "Bluetooth Service not available!");

            // Instead of throwing an exception which prevents people from going
            // into Wireless settings in the emulator. Let it crash later when it is actually used.
            mService = null;
        }
    }

    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.376 -0500", hash_original_method = "D3BF3BAE58FFF66435185BE94948ED76", hash_generated_method = "D3BF3BAE58FFF66435185BE94948ED76")
    
void close() {
        mServiceListener = null;
    }

    /**
     * Initiate connection to a profile of the remote bluetooth device.
     *
     * <p> The system supports connection to multiple input devices.
     *
     * <p> This API returns false in scenarios like the profile on the
     * device is already connected or Bluetooth is not turned on.
     * When this API returns true, it is guaranteed that
     * connection state intent for the profile will be broadcasted with
     * the state. Users can get the connection state of the profile
     * from this intent.
     *
     * <p>Requires {@link android.Manifest.permission#BLUETOOTH_ADMIN}
     * permission.
     *
     * @param device Remote Bluetooth Device
     * @return false on immediate error,
     *               true otherwise
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.379 -0500", hash_original_method = "F2019F4C3E8629A52034D770ECD44393", hash_generated_method = "1E9FE9CFC77F109ACB30DA9AF866908B")
    
public boolean connect(BluetoothDevice device) {
        if (DBG) log("connect(" + device + ")");
        if (mService != null && isEnabled() &&
            isValidDevice(device)) {
            try {
                return mService.connectInputDevice(device);
            } catch (RemoteException e) {
                Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                return false;
            }
        }
        if (mService == null) Log.w(TAG, "Proxy not attached to service");
        return false;
    }

    /**
     * Initiate disconnection from a profile
     *
     * <p> This API will return false in scenarios like the profile on the
     * Bluetooth device is not in connected state etc. When this API returns,
     * true, it is guaranteed that the connection state change
     * intent will be broadcasted with the state. Users can get the
     * disconnection state of the profile from this intent.
     *
     * <p> If the disconnection is initiated by a remote device, the state
     * will transition from {@link #STATE_CONNECTED} to
     * {@link #STATE_DISCONNECTED}. If the disconnect is initiated by the
     * host (local) device the state will transition from
     * {@link #STATE_CONNECTED} to state {@link #STATE_DISCONNECTING} to
     * state {@link #STATE_DISCONNECTED}. The transition to
     * {@link #STATE_DISCONNECTING} can be used to distinguish between the
     * two scenarios.
     *
     * <p>Requires {@link android.Manifest.permission#BLUETOOTH_ADMIN}
     * permission.
     *
     * @param device Remote Bluetooth Device
     * @return false on immediate error,
     *               true otherwise
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.381 -0500", hash_original_method = "9415AEF5C20AF4D988D1F3F693875D2E", hash_generated_method = "6B8CBF6B7D93371F243369DA1F5EE71F")
    
public boolean disconnect(BluetoothDevice device) {
        if (DBG) log("disconnect(" + device + ")");
        if (mService != null && isEnabled() &&
            isValidDevice(device)) {
            try {
                return mService.disconnectInputDevice(device);
            } catch (RemoteException e) {
                Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                return false;
            }
        }
        if (mService == null) Log.w(TAG, "Proxy not attached to service");
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.383 -0500", hash_original_method = "DD11A5A037066B819B09B91F048A8292", hash_generated_method = "9A391AB1E165D2D7F2E66AC2620DEF01")
    
public List<BluetoothDevice> getConnectedDevices() {
        if (DBG) log("getConnectedDevices()");
        if (mService != null && isEnabled()) {
            try {
                return mService.getConnectedInputDevices();
            } catch (RemoteException e) {
                Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                return new ArrayList<BluetoothDevice>();
            }
        }
        if (mService == null) Log.w(TAG, "Proxy not attached to service");
        return new ArrayList<BluetoothDevice>();
    }

    /**
     * {@inheritDoc}
     */
    @DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.386 -0500", hash_original_method = "8CAF8E68108C6561E50EE464A6851A15", hash_generated_method = "03574918D113C09013F0D3C047AAFCC2")
    
public List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] states) {
        if (DBG) log("getDevicesMatchingStates()");
        if (mService != null && isEnabled()) {
            try {
                return mService.getInputDevicesMatchingConnectionStates(states);
            } catch (RemoteException e) {
                Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                return new ArrayList<BluetoothDevice>();
            }
        }
        if (mService == null) Log.w(TAG, "Proxy not attached to service");
        return new ArrayList<BluetoothDevice>();
    }

    /**
     * {@inheritDoc}
     */
    @DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.388 -0500", hash_original_method = "97B42C809342D6C6DAC05DB0DA17D1EC", hash_generated_method = "24265A9A95147640E29D2FCD09078EEF")
    
public int getConnectionState(BluetoothDevice device) {
        if (DBG) log("getState(" + device + ")");
        if (mService != null && isEnabled()
            && isValidDevice(device)) {
            try {
                return mService.getInputDeviceConnectionState(device);
            } catch (RemoteException e) {
                Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                return BluetoothProfile.STATE_DISCONNECTED;
            }
        }
        if (mService == null) Log.w(TAG, "Proxy not attached to service");
        return BluetoothProfile.STATE_DISCONNECTED;
    }

    /**
     * Set priority of the profile
     *
     * <p> The device should already be paired.
     *  Priority can be one of {@link #PRIORITY_ON} or
     * {@link #PRIORITY_OFF},
     *
     * <p>Requires {@link android.Manifest.permission#BLUETOOTH_ADMIN}
     * permission.
     *
     * @param device Paired bluetooth device
     * @param priority
     * @return true if priority is set, false on error
     * @hide
     */
    @DSSink({DSSinkKind.BLUETOOTH})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.391 -0500", hash_original_method = "9373326E4AC064A071DC5CD973E0011C", hash_generated_method = "8E8F921B7B28BA6EBCCAD2894B168149")
    
public boolean setPriority(BluetoothDevice device, int priority) {
        if (DBG) log("setPriority(" + device + ", " + priority + ")");
        if (mService != null && isEnabled()
            && isValidDevice(device)) {
            if (priority != BluetoothProfile.PRIORITY_OFF &&
                priority != BluetoothProfile.PRIORITY_ON) {
              return false;
            }
            try {
                return mService.setInputDevicePriority(device, priority);
            } catch (RemoteException e) {
                Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                return false;
            }
        }
        if (mService == null) Log.w(TAG, "Proxy not attached to service");
        return false;
    }

    /**
     * Get the priority of the profile.
     *
     * <p> The priority can be any of:
     * {@link #PRIORITY_AUTO_CONNECT}, {@link #PRIORITY_OFF},
     * {@link #PRIORITY_ON}, {@link #PRIORITY_UNDEFINED}
     *
     * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
     *
     * @param device Bluetooth device
     * @return priority of the device
     * @hide
     */
    @DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.395 -0500", hash_original_method = "1D1EE6052242ABD7AAF16EB7DF8BA827", hash_generated_method = "3B2B8C63890F6885E484B7D7B9CDEE0D")
    
public int getPriority(BluetoothDevice device) {
        if (DBG) log("getPriority(" + device + ")");
        if (mService != null && isEnabled()
            && isValidDevice(device)) {
            try {
                return mService.getInputDevicePriority(device);
            } catch (RemoteException e) {
                Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                return BluetoothProfile.PRIORITY_OFF;
            }
        }
        if (mService == null) Log.w(TAG, "Proxy not attached to service");
        return BluetoothProfile.PRIORITY_OFF;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.398 -0500", hash_original_method = "7937BC03D2C2DD83881BE0DF65C2C1C7", hash_generated_method = "199CD6721D66E41745A6F0D547B34AF7")
    
private boolean isEnabled() {
       return toTaintBoolean(mAdapter.getState());
       //if (mAdapter.getState() == BluetoothAdapter.STATE_ON) return true;
       //return false;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.400 -0500", hash_original_method = "EB67AF48F977D4A31E9F2F2B80A49421", hash_generated_method = "3EEE3A9E12DCA4A453C7F11E3F959C9B")
    
private boolean isValidDevice(BluetoothDevice device) {
       if (device == null) return false;
       return BluetoothAdapter.checkBluetoothAddress(device.getAddress());
    }
}

