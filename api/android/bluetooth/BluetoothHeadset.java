package android.bluetooth;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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

    /**
     * Indicates if current platform supports voice dialing over bluetooth SCO.
     *
     * @return true if voice dialing over bluetooth is supported, false otherwise.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.918 -0500", hash_original_method = "7DFB2B07729CC5CD070DB2D2031A339C", hash_generated_method = "869441714ECC050145171561C4601151")
    
public static boolean isBluetoothVoiceDialingEnabled(Context context) {
        return context.getResources().getBoolean(
                com.android.internal.R.bool.config_bluetooth_sco_off_call);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.959 -0500", hash_original_method = "0EBF7673E44AF610ADC3AB53A65BD597", hash_generated_method = "12E4FDCE2D2661CC6DF9F077D2C0BB73")
    
private static void log(String msg) {
        Log.d(TAG, msg);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.836 -0500", hash_original_field = "8D4B0D43ECFEE4173B873B26DA3EB345", hash_generated_field = "EBA83525E1B94BE4C4CA3565D8D3EE9E")

    private static final String TAG = "BluetoothHeadset";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.840 -0500", hash_original_field = "B2601CA7445F6BA19FA7884763D82281", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.842 -0500", hash_original_field = "8BF8B4BC43D37119080421B184E47EBA", hash_generated_field = "ABC03AE60B852A1C7718E9A970BD1536")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CONNECTION_STATE_CHANGED =
        "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.845 -0500", hash_original_field = "35D9C01CB853D29028369CB817599D26", hash_generated_field = "BB784B20611B5426CFF10690920EEB5C")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_AUDIO_STATE_CHANGED =
        "android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.847 -0500", hash_original_field = "E61D62296D03C33C0D1F3439D49E2DE1", hash_generated_field = "AC2698553492ED5B94B3EFA99003D861")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_VENDOR_SPECIFIC_HEADSET_EVENT =
            "android.bluetooth.headset.action.VENDOR_SPECIFIC_HEADSET_EVENT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.850 -0500", hash_original_field = "D580865DB0C908ABBCAE25437B905731", hash_generated_field = "BDACDE0E26600FAE1AFF6AC736C7F543")

    public static final String EXTRA_VENDOR_SPECIFIC_HEADSET_EVENT_CMD =
            "android.bluetooth.headset.extra.VENDOR_SPECIFIC_HEADSET_EVENT_CMD";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.852 -0500", hash_original_field = "D10030A37DE26A4DA492E544EBB740CE", hash_generated_field = "90CECD7CE6C28ECC4D03E1709BB66CBD")

    public static final String EXTRA_VENDOR_SPECIFIC_HEADSET_EVENT_CMD_TYPE =
            "android.bluetooth.headset.extra.VENDOR_SPECIFIC_HEADSET_EVENT_CMD_TYPE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.855 -0500", hash_original_field = "04A3770DF47883E57A663A9BEC851FD8", hash_generated_field = "4DE453250584C7FE6B64D6AD6C961CE8")

    public static final int AT_CMD_TYPE_READ = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.857 -0500", hash_original_field = "26ED19FC5C64EC452936B3EF68A72033", hash_generated_field = "2C2252AE507E225BC34F7AEA44E0AC49")

    public static final int AT_CMD_TYPE_TEST = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.859 -0500", hash_original_field = "6B78AC09C964142E3B8402F6E2389CE7", hash_generated_field = "357B08A29D2379204652B128913E4928")

    public static final int AT_CMD_TYPE_SET = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.861 -0500", hash_original_field = "82C9B7FFD465F4B2688FE58285FDBE72", hash_generated_field = "0A95BA5CB4DD042061A85BD7515A62D7")

    public static final int AT_CMD_TYPE_BASIC = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.863 -0500", hash_original_field = "DE12227BDDA87983C9267B549456FABC", hash_generated_field = "8A8D2B159027C806839DD114C91E3127")

    public static final int AT_CMD_TYPE_ACTION = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.866 -0500", hash_original_field = "34B5BD39B9D2369A1DB0DAECD1E85E20", hash_generated_field = "51411B886A94D1180D892E92776C02D3")

    public static final String EXTRA_VENDOR_SPECIFIC_HEADSET_EVENT_ARGS =
            "android.bluetooth.headset.extra.VENDOR_SPECIFIC_HEADSET_EVENT_ARGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.868 -0500", hash_original_field = "F24AB090F3ADE8E7E7B31C3BAA21F024", hash_generated_field = "B5553D0E6B97FD79EBA3C206E2FF693C")

    public static final String VENDOR_SPECIFIC_HEADSET_EVENT_COMPANY_ID_CATEGORY  =
            "android.bluetooth.headset.intent.category.companyid";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.871 -0500", hash_original_field = "9D8E80843D2FA0E5D56D7DBA354F62FF", hash_generated_field = "0D469E671F848187A0CDC591A24EABA1")

    public static final int STATE_AUDIO_DISCONNECTED = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.873 -0500", hash_original_field = "A9D6FF681A6550700BA78963940523E5", hash_generated_field = "320FBFE32BF6DC544AAED5D9A84E5DBD")

    public static final int STATE_AUDIO_CONNECTING = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.875 -0500", hash_original_field = "4A7EA07FED16E108810B8CFA842B41B0", hash_generated_field = "39ACE008F53ABD81B2D9586C9128E986")

    public static final int STATE_AUDIO_CONNECTED = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.878 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.880 -0500", hash_original_field = "AD4810E1EAEE0B4F351A0550C3A3183B", hash_generated_field = "6FCEA0ED39BC377BA765F514A42DFCE9")

    private ServiceListener mServiceListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.882 -0500", hash_original_field = "6F3076DA398DDFA1ED47556A1836E19E", hash_generated_field = "79B3CF63B286D2E971AC334B507D5268")

    private IBluetoothHeadset mService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.884 -0500", hash_original_field = "367F0BC6BC216C571A7E906A286477DF", hash_generated_field = "367F0BC6BC216C571A7E906A286477DF")

    BluetoothAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.273 -0400", hash_original_field = "23D4610316C4691B804316E58CB7E31E", hash_generated_field = "B1E39DD343E537E31D2D451F2E1E8203")

    private ServiceConnection mConnection = new ServiceConnection() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.945 -0500", hash_original_method = "49B1367FF57AEC89B6CC00CC921EF188", hash_generated_method = "D8C0AB427A0DA4BC1DBC40C191A8EC0A")
        
public void onServiceConnected(ComponentName className, IBinder service) {
            if (DBG) Log.d(TAG, "Proxy object connected");
            mService = IBluetoothHeadset.Stub.asInterface(service);

            if (mServiceListener != null) {
                mServiceListener.onServiceConnected(BluetoothProfile.HEADSET, BluetoothHeadset.this);
            }
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.948 -0500", hash_original_method = "5E9993D21DC5F46D871DD6D0C9DF0475", hash_generated_method = "F985A302CEB99495C956E6D774130AF3")
        
public void onServiceDisconnected(ComponentName className) {
            if (DBG) Log.d(TAG, "Proxy object disconnected");
            mService = null;
            if (mServiceListener != null) {
                mServiceListener.onServiceDisconnected(BluetoothProfile.HEADSET);
            }
        }
        
};

    /**
     * Create a BluetoothHeadset proxy object.
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.886 -0500", hash_original_method = "B2E3A495C7EEB290E3194E45B33ED96D", hash_generated_method = "B2E3A495C7EEB290E3194E45B33ED96D")
    
BluetoothHeadset(Context context, ServiceListener l) {
        mContext = context;
        mServiceListener = l;
        mAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!context.bindService(new Intent(IBluetoothHeadset.class.getName()), mConnection, 0)) {
            Log.e(TAG, "Could not bind to Bluetooth Headset Service");
        }
    }

    /**
     * Close the connection to the backing service.
     * Other public functions of BluetoothHeadset will return default error
     * results once close() has been called. Multiple invocations of close()
     * are ok.
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.888 -0500", hash_original_method = "072F8B79FA7D55AD4D16BF2975AA6259", hash_generated_method = "F26C02109EF7607977BCCAA2DBE030B1")
    
synchronized void close() {
        if (DBG) log("close()");
        if (mConnection != null) {
            mContext.unbindService(mConnection);
            mConnection = null;
        }
        mServiceListener = null;
    }

    /**
     * Initiate connection to a profile of the remote bluetooth device.
     *
     * <p> Currently, the system supports only 1 connection to the
     * headset/handsfree profile. The API will automatically disconnect connected
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.891 -0500", hash_original_method = "7284EC53ABB82E4A2B97F7B894F0105F", hash_generated_method = "756BAB54C2322A3E9F05208D17F5C643")
    
public boolean connect(BluetoothDevice device) {
        if (DBG) log("connect(" + device + ")");
        if (mService != null && isEnabled() &&
            isValidDevice(device)) {
            try {
                return mService.connect(device);
            } catch (RemoteException e) {
                Log.e(TAG, Log.getStackTraceString(new Throwable()));
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.893 -0500", hash_original_method = "4AB2501852FA35F2A69CDF567F29169A", hash_generated_method = "16BA60620A65376F190F1961155DADEF")
    
public boolean disconnect(BluetoothDevice device) {
        if (DBG) log("disconnect(" + device + ")");
        if (mService != null && isEnabled() &&
            isValidDevice(device)) {
            try {
                return mService.disconnect(device);
            } catch (RemoteException e) {
              Log.e(TAG, Log.getStackTraceString(new Throwable()));
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.897 -0500", hash_original_method = "49C359566F3934D08711C62C957BAB9A", hash_generated_method = "D3E8387F3626781AC42702A7A2FF865C")
    
public List<BluetoothDevice> getConnectedDevices() {
        if (DBG) log("getConnectedDevices()");
        if (mService != null && isEnabled()) {
            try {
                return mService.getConnectedDevices();
            } catch (RemoteException e) {
                Log.e(TAG, Log.getStackTraceString(new Throwable()));
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.899 -0500", hash_original_method = "E177F9FA262CA684CC709DA528C57F1A", hash_generated_method = "4E2AB484F7FCAF48912E569EDD7FD9D8")
    
public List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] states) {
        if (DBG) log("getDevicesMatchingStates()");
        if (mService != null && isEnabled()) {
            try {
                return mService.getDevicesMatchingConnectionStates(states);
            } catch (RemoteException e) {
                Log.e(TAG, Log.getStackTraceString(new Throwable()));
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.901 -0500", hash_original_method = "1FDB9A860CA32B38F33F04C33CC0DC9B", hash_generated_method = "25E48229504EAA37090851E3A8E403A8")
    
public int getConnectionState(BluetoothDevice device) {
        if (DBG) log("getConnectionState(" + device + ")");
        if (mService != null && isEnabled() &&
            isValidDevice(device)) {
            try {
                return mService.getConnectionState(device);
            } catch (RemoteException e) {
                Log.e(TAG, Log.getStackTraceString(new Throwable()));
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.904 -0500", hash_original_method = "F982CE0C4DEC9189A14DF4553C949192", hash_generated_method = "01A34DB00D2DAC328E5A50D56D464ADF")
    
public boolean setPriority(BluetoothDevice device, int priority) {
        if (DBG) log("setPriority(" + device + ", " + priority + ")");
        if (mService != null && isEnabled() &&
            isValidDevice(device)) {
            if (priority != BluetoothProfile.PRIORITY_OFF &&
                priority != BluetoothProfile.PRIORITY_ON) {
              return false;
            }
            try {
                return mService.setPriority(device, priority);
            } catch (RemoteException e) {
                Log.e(TAG, Log.getStackTraceString(new Throwable()));
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.906 -0500", hash_original_method = "705F88F05E8E78847084743E12D945BD", hash_generated_method = "05DE274BF4D8D86993642A38EC2A1CEF")
    
public int getPriority(BluetoothDevice device) {
        if (DBG) log("getPriority(" + device + ")");
        if (mService != null && isEnabled() &&
            isValidDevice(device)) {
            try {
                return mService.getPriority(device);
            } catch (RemoteException e) {
                Log.e(TAG, Log.getStackTraceString(new Throwable()));
                return PRIORITY_OFF;
            }
        }
        if (mService == null) Log.w(TAG, "Proxy not attached to service");
        return PRIORITY_OFF;
    }

    /**
     * Start Bluetooth voice recognition. This methods sends the voice
     * recognition AT command to the headset and establishes the
     * audio connection.
     *
     * <p> Users can listen to {@link #ACTION_AUDIO_STATE_CHANGED}.
     * If this function returns true, this intent will be broadcasted with
     * {@link #EXTRA_STATE} set to {@link #STATE_AUDIO_CONNECTING}.
     *
     * <p> {@link #EXTRA_STATE} will transition from
     * {@link #STATE_AUDIO_CONNECTING} to {@link #STATE_AUDIO_CONNECTED} when
     * audio connection is established and to {@link #STATE_AUDIO_DISCONNECTED}
     * in case of failure to establish the audio connection.
     *
     * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
     *
     * @param device Bluetooth headset
     * @return false if there is no headset connected of if the
     *               connected headset doesn't support voice recognition
     *               or on error, true otherwise
     */
    @DSSink({DSSinkKind.BLUETOOTH})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.908 -0500", hash_original_method = "27AD2A5F99F8BC607BCDEC817A66E20B", hash_generated_method = "AE7ECBDF0D6700335BAF64C90824AE25")
    
public boolean startVoiceRecognition(BluetoothDevice device) {
        if (DBG) log("startVoiceRecognition()");
        if (mService != null && isEnabled() &&
            isValidDevice(device)) {
            try {
                return mService.startVoiceRecognition(device);
            } catch (RemoteException e) {
                Log.e(TAG,  Log.getStackTraceString(new Throwable()));
            }
        }
        if (mService == null) Log.w(TAG, "Proxy not attached to service");
        return false;
    }

    /**
     * Stop Bluetooth Voice Recognition mode, and shut down the
     * Bluetooth audio path.
     *
     * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
     *
     * @param device Bluetooth headset
     * @return false if there is no headset connected
     *               or on error, true otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.911 -0500", hash_original_method = "9C079C73E681F82F25C06C8EF6915217", hash_generated_method = "F4F1C98EF6C8DDABE4BFBC0A55CA18E7")
    
public boolean stopVoiceRecognition(BluetoothDevice device) {
        if (DBG) log("stopVoiceRecognition()");
        if (mService != null && isEnabled() &&
            isValidDevice(device)) {
            try {
                return mService.stopVoiceRecognition(device);
            } catch (RemoteException e) {
                Log.e(TAG,  Log.getStackTraceString(new Throwable()));
            }
        }
        if (mService == null) Log.w(TAG, "Proxy not attached to service");
        return false;
    }

    /**
     * Check if Bluetooth SCO audio is connected.
     *
     * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
     *
     * @param device Bluetooth headset
     * @return true if SCO is connected,
     *         false otherwise or on error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.913 -0500", hash_original_method = "B8A3B3939435110554206CE07E152F67", hash_generated_method = "0521218EBF27B2D5E213DEFC996B60AE")
    
public boolean isAudioConnected(BluetoothDevice device) {
        if (DBG) log("isAudioConnected()");
        if (mService != null && isEnabled() &&
            isValidDevice(device)) {
            try {
              return mService.isAudioConnected(device);
            } catch (RemoteException e) {
              Log.e(TAG,  Log.getStackTraceString(new Throwable()));
            }
        }
        if (mService == null) Log.w(TAG, "Proxy not attached to service");
        return false;
    }

    /**
     * Get battery usage hint for Bluetooth Headset service.
     * This is a monotonically increasing integer. Wraps to 0 at
     * Integer.MAX_INT, and at boot.
     * Current implementation returns the number of AT commands handled since
     * boot. This is a good indicator for spammy headset/handsfree units that
     * can keep the device awake by polling for cellular status updates. As a
     * rule of thumb, each AT command prevents the CPU from sleeping for 500 ms
     *
     * @param device the bluetooth headset.
     * @return monotonically increasing battery usage hint, or a negative error
     *         code on error
     * @hide
     */
    @DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.916 -0500", hash_original_method = "6F6D31332C45DEAF9F6DB793EAF6FAFC", hash_generated_method = "980BBF94087217AC01F60196330E47A0")
    
public int getBatteryUsageHint(BluetoothDevice device) {
        if (DBG) log("getBatteryUsageHint()");
        if (mService != null && isEnabled() &&
            isValidDevice(device)) {
            try {
                return mService.getBatteryUsageHint(device);
            } catch (RemoteException e) {
                Log.e(TAG,  Log.getStackTraceString(new Throwable()));
            }
        }
        if (mService == null) Log.w(TAG, "Proxy not attached to service");
        return -1;
    }

    /**
     * Cancel the outgoing connection.
     * Note: This is an internal function and shouldn't be exposed
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.920 -0500", hash_original_method = "2676E323C2C9765143A21FFE59CC6873", hash_generated_method = "517BCC3703C13440FDF238352FE358FB")
    
public boolean cancelConnectThread() {
        if (DBG) log("cancelConnectThread");
        if (mService != null && isEnabled()) {
            try {
                return mService.cancelConnectThread();
            } catch (RemoteException e) {Log.e(TAG, e.toString());}
        } else {
            Log.w(TAG, "Proxy not attached to service");
            if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        }
        return false;
    }

    /**
     * Accept the incoming connection.
     * Note: This is an internal function and shouldn't be exposed
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.923 -0500", hash_original_method = "EA55CECCBAC2EAE8EDC221C89634D263", hash_generated_method = "9662650A19DBD3BBFE05123312520AA9")
    
public boolean acceptIncomingConnect(BluetoothDevice device) {
        if (DBG) log("acceptIncomingConnect");
        if (mService != null && isEnabled()) {
            try {
                return mService.acceptIncomingConnect(device);
            } catch (RemoteException e) {Log.e(TAG, e.toString());}
        } else {
            Log.w(TAG, "Proxy not attached to service");
            if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        }
        return false;
    }

    /**
     * Create the connect thread for the incoming connection.
     * Note: This is an internal function and shouldn't be exposed
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.926 -0500", hash_original_method = "6D2538BEDFF897738BE4A0A290C33070", hash_generated_method = "B7D5D9AD8D04FA258AA5A2672A264BBC")
    
public boolean createIncomingConnect(BluetoothDevice device) {
        if (DBG) log("createIncomingConnect");
        if (mService != null && isEnabled()) {
            try {
                return mService.createIncomingConnect(device);
            } catch (RemoteException e) {Log.e(TAG, e.toString());}
        } else {
            Log.w(TAG, "Proxy not attached to service");
            if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        }
        return false;
    }

    /**
     * Reject the incoming connection.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.928 -0500", hash_original_method = "4505463E5EDB411267D82D01A0F1D824", hash_generated_method = "E9CEE2E3F31C00F30883BA7833B9BDB0")
    
public boolean rejectIncomingConnect(BluetoothDevice device) {
        if (DBG) log("rejectIncomingConnect");
        if (mService != null) {
            try {
                return mService.rejectIncomingConnect(device);
            } catch (RemoteException e) {Log.e(TAG, e.toString());}
        } else {
            Log.w(TAG, "Proxy not attached to service");
            if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        }
        return false;
    }

    /**
     * Connect to a Bluetooth Headset.
     * Note: This is an internal function and shouldn't be exposed
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.930 -0500", hash_original_method = "A8F7BAC49E734C18D4B72E93D6F191D5", hash_generated_method = "1DDA233E94630EFD323339E9EE81BFF5")
    
public boolean connectHeadsetInternal(BluetoothDevice device) {
        if (DBG) log("connectHeadsetInternal");
        if (mService != null && isEnabled()) {
            try {
                return mService.connectHeadsetInternal(device);
            } catch (RemoteException e) {Log.e(TAG, e.toString());}
        } else {
            Log.w(TAG, "Proxy not attached to service");
            if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        }
        return false;
    }

    /**
     * Disconnect a Bluetooth Headset.
     * Note: This is an internal function and shouldn't be exposed
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.933 -0500", hash_original_method = "DE8B58BD5456FA1A62F7BE53852C68CF", hash_generated_method = "386F136ED6A5A7CD8DC4F735D9BC6E64")
    
public boolean disconnectHeadsetInternal(BluetoothDevice device) {
        if (DBG) log("disconnectHeadsetInternal");
        if (mService != null && !isDisabled()) {
            try {
                 return mService.disconnectHeadsetInternal(device);
            } catch (RemoteException e) {Log.e(TAG, e.toString());}
        } else {
            Log.w(TAG, "Proxy not attached to service");
            if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        }
        return false;
    }

    /**
     * Set the audio state of the Headset.
     * Note: This is an internal function and shouldn't be exposed
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.935 -0500", hash_original_method = "04E80317E50A33841443E656AF5FDA5A", hash_generated_method = "C49FBCE40AFD2C7F45B23DC32F4C149F")
    
public boolean setAudioState(BluetoothDevice device, int state) {
        if (DBG) log("setAudioState");
        if (mService != null && !isDisabled()) {
            try {
                return mService.setAudioState(device, state);
            } catch (RemoteException e) {Log.e(TAG, e.toString());}
        } else {
            Log.w(TAG, "Proxy not attached to service");
            if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        }
        return false;
    }

    /**
     * Get the current audio state of the Headset.
     * Note: This is an internal function and shouldn't be exposed
     *
     * @hide
     */
    @DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.937 -0500", hash_original_method = "398E968FC0AE96999E6F1C9EB97CF08A", hash_generated_method = "B0C1C27287FE4D1FB5805546ACE2C9C5")
    
public int getAudioState(BluetoothDevice device) {
        if (DBG) log("getAudioState");
        if (mService != null && !isDisabled()) {
            try {
                return mService.getAudioState(device);
            } catch (RemoteException e) {Log.e(TAG, e.toString());}
        } else {
            Log.w(TAG, "Proxy not attached to service");
            if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        }
        return BluetoothHeadset.STATE_AUDIO_DISCONNECTED;
    }

    /**
     * Initiates a SCO channel connection with the headset (if connected).
     * Also initiates a virtual voice call for Handsfree devices as many devices
     * do not accept SCO audio without a call.
     * This API allows the handsfree device to be used for routing non-cellular
     * call audio.
     *
     * @param device Remote Bluetooth Device
     * @return true if successful, false if there was some error.
     * @hide
     */
    @DSSink({DSSinkKind.BLUETOOTH})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.940 -0500", hash_original_method = "D15419F6AD1B4E28C80D3421F9F86FA4", hash_generated_method = "B6AAA10A8046DEAF7A51157791491AE3")
    
public boolean startScoUsingVirtualVoiceCall(BluetoothDevice device) {
        if (DBG) log("startScoUsingVirtualVoiceCall()");
        if (mService != null && isEnabled() && isValidDevice(device)) {
            try {
                return mService.startScoUsingVirtualVoiceCall(device);
            } catch (RemoteException e) {
                Log.e(TAG, e.toString());
            }
        } else {
            Log.w(TAG, "Proxy not attached to service");
            if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        }
        return false;
    }

    /**
     * Terminates an ongoing SCO connection and the associated virtual
     * call.
     *
     * @param device Remote Bluetooth Device
     * @return true if successful, false if there was some error.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.942 -0500", hash_original_method = "EC64256DA9DAF95A4E5DDEFAF84087E3", hash_generated_method = "FDE5F684F2AD1C9B8754D076EFA6B089")
    
public boolean stopScoUsingVirtualVoiceCall(BluetoothDevice device) {
        if (DBG) log("stopScoUsingVirtualVoiceCall()");
        if (mService != null && isEnabled() && isValidDevice(device)) {
            try {
                return mService.stopScoUsingVirtualVoiceCall(device);
            } catch (RemoteException e) {
                Log.e(TAG, e.toString());
            }
        } else {
            Log.w(TAG, "Proxy not attached to service");
            if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.952 -0500", hash_original_method = "7937BC03D2C2DD83881BE0DF65C2C1C7", hash_generated_method = "199CD6721D66E41745A6F0D547B34AF7")
    
private boolean isEnabled() {
       if (mAdapter.getState() == BluetoothAdapter.STATE_ON) return true;
       return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.953 -0500", hash_original_method = "7FB46929D91880D43466C28024A250A9", hash_generated_method = "3C06CF0F89EACE9CA2AD2966A7F6F9D2")
    
private boolean isDisabled() {
       if (mAdapter.getState() == BluetoothAdapter.STATE_OFF) return true;
       return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.956 -0500", hash_original_method = "EB67AF48F977D4A31E9F2F2B80A49421", hash_generated_method = "3EEE3A9E12DCA4A453C7F11E3F959C9B")
    
private boolean isValidDevice(BluetoothDevice device) {
       if (device == null) return false;

       if (BluetoothAdapter.checkBluetoothAddress(device.getAddress())) return true;
       return false;
    }
}

