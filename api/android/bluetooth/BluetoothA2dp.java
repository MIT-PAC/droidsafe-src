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
import android.os.ParcelUuid;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.server.BluetoothA2dpService;
import android.util.Log;

public final class BluetoothA2dp implements BluetoothProfile {

    /**
     * Helper for converting a state to a string.
     *
     * For debug use only - strings are not internationalized.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.079 -0500", hash_original_method = "291F5B4072A01706D5283F5804B360A4", hash_generated_method = "BF1DDA278ADBC5A1516FEB70F1D9E90F")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.085 -0500", hash_original_method = "0EBF7673E44AF610ADC3AB53A65BD597", hash_generated_method = "12E4FDCE2D2661CC6DF9F077D2C0BB73")
    
private static void log(String msg) {
      Log.d(TAG, msg);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.023 -0500", hash_original_field = "AB0A5F644D860F1C58C596C91466DD73", hash_generated_field = "E58C6B10C262D3DDCC0EFA1E2CD2ADBD")

    private static final String TAG = "BluetoothA2dp";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.026 -0500", hash_original_field = "B2601CA7445F6BA19FA7884763D82281", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.028 -0500", hash_original_field = "09374F58DF04F965250127BB73A1F15E", hash_generated_field = "2C4FE2399AE2300A95A94B068FA50EDB")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CONNECTION_STATE_CHANGED =
        "android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.031 -0500", hash_original_field = "640132514F24F2CDAF9251ECECCF8004", hash_generated_field = "B900F0837C67C4837BB08076612125E7")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PLAYING_STATE_CHANGED =
        "android.bluetooth.a2dp.profile.action.PLAYING_STATE_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.034 -0500", hash_original_field = "A5F372BFE132FCC0AD91D372AE6682C3", hash_generated_field = "92BD53792AEE35980F71CE5B967D3BBC")

    public static final int STATE_PLAYING   =  10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.036 -0500", hash_original_field = "23EA9820908D56A0C2C67EF45395F99A", hash_generated_field = "21A0703BC1A0A5C580A43C1F467A8E87")

    public static final int STATE_NOT_PLAYING   =  11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.038 -0500", hash_original_field = "AD4810E1EAEE0B4F351A0550C3A3183B", hash_generated_field = "6FCEA0ED39BC377BA765F514A42DFCE9")

    private ServiceListener mServiceListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.040 -0500", hash_original_field = "054FD6D25890FF10E36F1E35E502390B", hash_generated_field = "09949A1EC40DD93875E958A2CE8D0BE0")

    private IBluetoothA2dp mService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.042 -0500", hash_original_field = "367F0BC6BC216C571A7E906A286477DF", hash_generated_field = "6EAF57CC559AB78B0231BFFF469261B9")

    private BluetoothAdapter mAdapter;

    /**
     * Create a BluetoothA2dp proxy object for interacting with the local
     * Bluetooth A2DP service.
     *
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.045 -0500", hash_original_method = "84AC70841E1DE8A91A25AE9B1E768BDD", hash_generated_method = "DBBF3B8A8B359CD14ECAB58E7C34BF00")
    
BluetoothA2dp(Context mContext, ServiceListener l) {
        IBinder b = ServiceManager.getService(BluetoothA2dpService.BLUETOOTH_A2DP_SERVICE);
        mServiceListener = l;
        mAdapter = BluetoothAdapter.getDefaultAdapter();
        if (b != null) {
            mService = IBluetoothA2dp.Stub.asInterface(b);
            if (mServiceListener != null) {
                mServiceListener.onServiceConnected(BluetoothProfile.A2DP, this);
            }
        } else {
            Log.w(TAG, "Bluetooth A2DP service not available!");

            // Instead of throwing an exception which prevents people from going
            // into Wireless settings in the emulator. Let it crash later when it is actually used.
            mService = null;
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.047 -0500", hash_original_method = "D3BF3BAE58FFF66435185BE94948ED76", hash_generated_method = "D3BF3BAE58FFF66435185BE94948ED76")
    
void close() {
        mServiceListener = null;
    }

    /**
     * Initiate connection to a profile of the remote bluetooth device.
     *
     * <p> Currently, the system supports only 1 connection to the
     * A2DP profile. The API will automatically disconnect connected
     * devices before connecting.
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.049 -0500", hash_original_method = "700825FC4ECAB3A433DC66A7B0E84928", hash_generated_method = "018E46DC4FAAFC9238165E2A911F98E2")
    
public boolean connect(BluetoothDevice device) {
        if (DBG) log("connect(" + device + ")");
        if (mService != null && isEnabled() &&
            isValidDevice(device)) {
            try {
                return mService.connect(device);
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.052 -0500", hash_original_method = "55DF4D676FC35487D0748922C473702F", hash_generated_method = "193074A44712875F8782B577A3102728")
    
public boolean disconnect(BluetoothDevice device) {
        if (DBG) log("disconnect(" + device + ")");
        if (mService != null && isEnabled() &&
            isValidDevice(device)) {
            try {
                return mService.disconnect(device);
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.054 -0500", hash_original_method = "0ADED1F6ADFCC469E1E307997E79DBB8", hash_generated_method = "313E3B11BDDB2DEF63B6B203C811A62E")
    
public List<BluetoothDevice> getConnectedDevices() {
        if (DBG) log("getConnectedDevices()");
        if (mService != null && isEnabled()) {
            try {
                return mService.getConnectedDevices();
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.056 -0500", hash_original_method = "EE46EB26B83008ABEDB21DB2056FFA88", hash_generated_method = "1A51FF5B7398EF778069E6EDF7919080")
    
public List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] states) {
        if (DBG) log("getDevicesMatchingStates()");
        if (mService != null && isEnabled()) {
            try {
                return mService.getDevicesMatchingConnectionStates(states);
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.059 -0500", hash_original_method = "B281ECAF166EAE88B310FDB0152ACEB7", hash_generated_method = "FEA36407C55A0E777E6F9BFEDADD4431")
    
public int getConnectionState(BluetoothDevice device) {
        if (DBG) log("getState(" + device + ")");
        if (mService != null && isEnabled()
            && isValidDevice(device)) {
            try {
                return mService.getConnectionState(device);
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.061 -0500", hash_original_method = "2B40F2C1D807822C775F30BF280CDA0D", hash_generated_method = "8A56452E7DB8E2FB7CD1D0CE5AD821B4")
    
public boolean setPriority(BluetoothDevice device, int priority) {
        if (DBG) log("setPriority(" + device + ", " + priority + ")");
        if (mService != null && isEnabled()
            && isValidDevice(device)) {
            if (priority != BluetoothProfile.PRIORITY_OFF &&
                priority != BluetoothProfile.PRIORITY_ON) {
              return false;
            }
            try {
                return mService.setPriority(device, priority);
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.063 -0500", hash_original_method = "23F2360BBDC60C257F7868DD2B8A1B81", hash_generated_method = "08CC818D4124C83D178B2099D552AA30")
    
public int getPriority(BluetoothDevice device) {
        if (DBG) log("getPriority(" + device + ")");
        if (mService != null && isEnabled()
            && isValidDevice(device)) {
            try {
                return mService.getPriority(device);
            } catch (RemoteException e) {
                Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                return BluetoothProfile.PRIORITY_OFF;
            }
        }
        if (mService == null) Log.w(TAG, "Proxy not attached to service");
        return BluetoothProfile.PRIORITY_OFF;
    }

    /**
     * Check if A2DP profile is streaming music.
     *
     * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
     *
     * @param device BluetoothDevice device
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.066 -0500", hash_original_method = "0A81AC976D9A0E28DF6B1DEC7E34C5D3", hash_generated_method = "FE9C6F1C89CC6D0046E14AEAFEFFE87F")
    
public boolean isA2dpPlaying(BluetoothDevice device) {
        if (mService != null && isEnabled()
            && isValidDevice(device)) {
            try {
                return mService.isA2dpPlaying(device);
            } catch (RemoteException e) {
                Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                return false;
            }
        }
        if (mService == null) Log.w(TAG, "Proxy not attached to service");
        return false;
    }

    /**
     * Initiate suspend from an A2DP sink.
     *
     * <p> This API will return false in scenarios like the A2DP
     * device is not in connected state etc. When this API returns,
     * true, it is guaranteed that {@link #ACTION_CONNECTION_STATE_CHANGED}
     * intent will be broadcasted with the state. Users can get the
     * state of the A2DP device from this intent.
     *
     * <p>Requires {@link android.Manifest.permission#BLUETOOTH_ADMIN}
     * permission.
     *
     * @param device Remote A2DP sink
     * @return false on immediate error,
     *               true otherwise
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.068 -0500", hash_original_method = "FEE19D0C9AEE9A75BC73A57692A1B159", hash_generated_method = "DF4EA9FDD3F7141EBA2D7283A3D2C6F1")
    
public boolean suspendSink(BluetoothDevice device) {
        if (mService != null && isEnabled()
            && isValidDevice(device)) {
            try {
                return mService.suspendSink(device);
            } catch (RemoteException e) {
                Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                return false;
            }
        }
        if (mService == null) Log.w(TAG, "Proxy not attached to service");
        return false;
    }

    /**
     * Initiate resume from a suspended A2DP sink.
     *
     * <p> This API will return false in scenarios like the A2DP
     * device is not in suspended state etc. When this API returns,
     * true, it is guaranteed that {@link #ACTION_SINK_STATE_CHANGED}
     * intent will be broadcasted with the state. Users can get the
     * state of the A2DP device from this intent.
     *
     * <p>Requires {@link android.Manifest.permission#BLUETOOTH_ADMIN}
     *
     * @param device Remote A2DP sink
     * @return false on immediate error,
     *               true otherwise
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.071 -0500", hash_original_method = "18AFE84D45293B01197D290EE720FEAA", hash_generated_method = "C1CC1F8A0B3F294C458CC1C2D1E9CF27")
    
public boolean resumeSink(BluetoothDevice device) {
        if (mService != null && isEnabled()
            && isValidDevice(device)) {
            try {
                return mService.resumeSink(device);
            } catch (RemoteException e) {
                Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                return false;
            }
        }
        if (mService == null) Log.w(TAG, "Proxy not attached to service");
        return false;
    }

    /**
     * This function checks if the remote device is an AVCRP
     * target and thus whether we should send volume keys
     * changes or not.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.073 -0500", hash_original_method = "FF7FB4D142B82B6A187917634C749F84", hash_generated_method = "A26D4361164728CC4D40A8F99A62FD53")
    
public boolean shouldSendVolumeKeys(BluetoothDevice device) {
        if (isEnabled() && isValidDevice(device)) {
            ParcelUuid[] uuids = device.getUuids();
            if (uuids == null) return false;

            for (ParcelUuid uuid: uuids) {
                if (BluetoothUuid.isAvrcpTarget(uuid)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Allow or disallow incoming connection
     * @param device Sink
     * @param value True / False
     * @return Success or Failure of the binder call.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.076 -0500", hash_original_method = "29CED80F2164214524C1FC1AF02F2B1A", hash_generated_method = "73CFA3025FD6B2E83A59778D7106E4C2")
    
public boolean allowIncomingConnect(BluetoothDevice device, boolean value) {
        if (DBG) log("allowIncomingConnect(" + device + ":" + value + ")");
        try {
            return mService.allowIncomingConnect(device, value);
        } catch (RemoteException e) {
            Log.e(TAG, "", e);
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.081 -0500", hash_original_method = "7937BC03D2C2DD83881BE0DF65C2C1C7", hash_generated_method = "199CD6721D66E41745A6F0D547B34AF7")
    
private boolean isEnabled() {
       if (mAdapter.getState() == BluetoothAdapter.STATE_ON) return true;
       return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.083 -0500", hash_original_method = "EB67AF48F977D4A31E9F2F2B80A49421", hash_generated_method = "3EEE3A9E12DCA4A453C7F11E3F959C9B")
    
private boolean isValidDevice(BluetoothDevice device) {
       if (device == null) return false;

       if (BluetoothAdapter.checkBluetoothAddress(device.getAddress())) return true;
       return false;
    }
}

