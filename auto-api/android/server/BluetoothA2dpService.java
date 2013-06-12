package android.server;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothUuid;
import android.bluetooth.IBluetoothA2dp;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.ParcelUuid;
import android.provider.Settings;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BluetoothA2dpService extends IBluetoothA2dp.Stub {
    private static final String TAG = "BluetoothA2dpService";
    private static final boolean DBG = true;
    public static final String BLUETOOTH_A2DP_SERVICE = "bluetooth_a2dp";
    private static final String BLUETOOTH_ADMIN_PERM = android.Manifest.permission.BLUETOOTH_ADMIN;
    private static final String BLUETOOTH_PERM = android.Manifest.permission.BLUETOOTH;
    private static final String BLUETOOTH_ENABLED = "bluetooth_enabled";
    private static final String PROPERTY_STATE = "State";
    private final Context mContext;
    private final IntentFilter mIntentFilter;
    private HashMap<BluetoothDevice, Integer> mAudioDevices;
    private final AudioManager mAudioManager;
    private final BluetoothService mBluetoothService;
    private final BluetoothAdapter mAdapter;
    private int   mTargetA2dpState;
    private BluetoothDevice mPlayingA2dpDevice;
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.374 -0400", hash_original_method = "878FE6B60A52570D7F6B49AD2B0B3F2D", hash_generated_method = "87A98B83D37A50DB968F41BCFD613F78")
        @DSModeled(DSC.SPEC)
        @Override
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(intent.dsTaint);
            String action;
            action = intent.getAction();
            BluetoothDevice device;
            device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            {
                boolean var9473630737EAF39A71E13A36E5F2F8A8_1020523052 = (action.equals(BluetoothAdapter.ACTION_STATE_CHANGED));
                {
                    int state;
                    state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE,
                                               BluetoothAdapter.ERROR);
                    //Begin case BluetoothAdapter.STATE_ON 
                    onBluetoothEnable();
                    //End case BluetoothAdapter.STATE_ON 
                    //Begin case BluetoothAdapter.STATE_TURNING_OFF 
                    onBluetoothDisable();
                    //End case BluetoothAdapter.STATE_TURNING_OFF 
                } //End block
                {
                    boolean var39C387E85D5AA74C7BF12DE28385D0E8_1893288282 = (action.equals(BluetoothDevice.ACTION_ACL_DISCONNECTED));
                    {
                        {
                            {
                                boolean var6291C0D45BF15847802FC90D2BF3F0E9_1316542247 = (mAudioDevices.containsKey(device));
                                {
                                    int state;
                                    state = mAudioDevices.get(device);
                                    handleSinkStateChange(device, state, BluetoothA2dp.STATE_DISCONNECTED);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                    {
                        boolean var66895C2C5668F78E37ECEBAD263AB3C9_1686974914 = (action.equals(AudioManager.VOLUME_CHANGED_ACTION));
                        {
                            int streamType;
                            streamType = intent.getIntExtra(AudioManager.EXTRA_VOLUME_STREAM_TYPE, -1);
                            {
                                List<BluetoothDevice> sinks;
                                sinks = getConnectedDevices();
                                {
                                    boolean varA02C8B3B23042BFCE902D5283207ED1D_988245341 = (sinks.size() != 0 && isPhoneDocked(sinks.get(0)));
                                    {
                                        String address;
                                        address = sinks.get(0).getAddress();
                                        int newVolLevel;
                                        newVolLevel = intent.getIntExtra(AudioManager.EXTRA_VOLUME_STREAM_VALUE, 0);
                                        int oldVolLevel;
                                        oldVolLevel = intent.getIntExtra(AudioManager.EXTRA_PREV_VOLUME_STREAM_VALUE, 0);
                                        String path;
                                        path = mBluetoothService.getObjectPathFromAddress(address);
                                        {
                                            avrcpVolumeUpNative(path);
                                        } //End block
                                        {
                                            avrcpVolumeDownNative(path);
                                        } //End block
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.375 -0400", hash_original_method = "6C39FCCD1AF260530D18B98302E02CA2", hash_generated_method = "06F0DA317D01829EB4F192837212FEFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BluetoothA2dpService(Context context, BluetoothService bluetoothService) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(bluetoothService.dsTaint);
        mAudioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        {
            throw new RuntimeException("Platform does not support Bluetooth");
        } //End block
        {
            boolean var44DF7BC6EDABA94A49843C98B2507797_992725295 = (!initNative());
            {
                throw new RuntimeException("Could not init BluetoothA2dpService");
            } //End block
        } //End collapsed parenthetic
        mAdapter = BluetoothAdapter.getDefaultAdapter();
        mIntentFilter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
        mIntentFilter.addAction(BluetoothDevice.ACTION_ACL_CONNECTED);
        mIntentFilter.addAction(BluetoothDevice.ACTION_ACL_DISCONNECTED);
        mIntentFilter.addAction(AudioManager.VOLUME_CHANGED_ACTION);
        mContext.registerReceiver(mReceiver, mIntentFilter);
        mAudioDevices = new HashMap<BluetoothDevice, Integer>();
        {
            boolean varF7F4E5B4BFEB5FF801850C92F0984BDD_1534309767 = (mBluetoothService.isEnabled());
            onBluetoothEnable();
        } //End collapsed parenthetic
        mTargetA2dpState = -1;
        mBluetoothService.setA2dpService(this);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.375 -0400", hash_original_method = "62207F14B0C3E20B350C50EBE13017D6", hash_generated_method = "513FBA1B30265E5708268F985449660E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isPhoneDocked(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        Intent i;
        i = mContext.registerReceiver(null, new IntentFilter(Intent.ACTION_DOCK_EVENT));
        {
            int state;
            state = i.getIntExtra(Intent.EXTRA_DOCK_STATE, Intent.EXTRA_DOCK_STATE_UNDOCKED);
            {
                BluetoothDevice dockDevice;
                dockDevice = i.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                {
                    boolean var78CD54CBE835E17F6721626B3C8E6962_627633960 = (dockDevice != null && device.equals(dockDevice));
                } //End collapsed parenthetic
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Intent i = mContext.registerReceiver(null, new IntentFilter(Intent.ACTION_DOCK_EVENT));
        //if (i != null) {
            //int state = i.getIntExtra(Intent.EXTRA_DOCK_STATE, Intent.EXTRA_DOCK_STATE_UNDOCKED);
            //if (state != Intent.EXTRA_DOCK_STATE_UNDOCKED) {
                //BluetoothDevice dockDevice = i.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                //if (dockDevice != null && device.equals(dockDevice)) {
                    //return true;
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.375 -0400", hash_original_method = "55245180BFCEB39D7A6E7F3D4E6368A1", hash_generated_method = "C11D85227B83665E47D09462A217F502")
    @DSModeled(DSC.SAFE)
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            cleanupNative();
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //cleanupNative();
        //} finally {
            //super.finalize();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.375 -0400", hash_original_method = "58FD03EDFF8B6A70A28790F8AEABC35F", hash_generated_method = "5BCC1674B5D9655A61BBAB32E0041361")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int convertBluezSinkStringToState(String value) {
        dsTaint.addTaint(value);
        {
            boolean var0AB732A0987F78FC7B13794047193CAE_528307013 = (value.equalsIgnoreCase("disconnected"));
        } //End collapsed parenthetic
        {
            boolean varA9DA4702CA67582C9C4F228A623674CE_1278970817 = (value.equalsIgnoreCase("connecting"));
        } //End collapsed parenthetic
        {
            boolean varB5369F9DB410B0EDE2271D29422EB304_1076673549 = (value.equalsIgnoreCase("connected"));
        } //End collapsed parenthetic
        {
            boolean var7E3B763E5BD26C1E0ED95B44CEFDED2D_1705080418 = (value.equalsIgnoreCase("playing"));
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (value.equalsIgnoreCase("disconnected"))
            //return BluetoothA2dp.STATE_DISCONNECTED;
        //if (value.equalsIgnoreCase("connecting"))
            //return BluetoothA2dp.STATE_CONNECTING;
        //if (value.equalsIgnoreCase("connected"))
            //return BluetoothA2dp.STATE_CONNECTED;
        //if (value.equalsIgnoreCase("playing"))
            //return BluetoothA2dp.STATE_PLAYING;
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.376 -0400", hash_original_method = "1F87BD4ABAE2C6479EB64121F5FF8512", hash_generated_method = "C5E54937F74D56448060D7376A9C60D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isSinkDevice(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        ParcelUuid[] uuids;
        uuids = mBluetoothService.getRemoteUuids(device.getAddress());
        {
            boolean varDE4D0A7C57B57B53BB50452A5985BD22_847893686 = (uuids != null && BluetoothUuid.isUuidPresent(uuids, BluetoothUuid.AudioSink));
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //ParcelUuid[] uuids = mBluetoothService.getRemoteUuids(device.getAddress());
        //if (uuids != null && BluetoothUuid.isUuidPresent(uuids, BluetoothUuid.AudioSink)) {
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.376 -0400", hash_original_method = "7F93958FB521D9474CABA2B58D66DC73", hash_generated_method = "DEF56E7726A6B500477A7A2D3A28029E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized void addAudioSink(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        {
            boolean var309F3A7B42249C288CD8C91D5B391131_1441376318 = (mAudioDevices.get(device) == null);
            {
                mAudioDevices.put(device, BluetoothA2dp.STATE_DISCONNECTED);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mAudioDevices.get(device) == null) {
            //mAudioDevices.put(device, BluetoothA2dp.STATE_DISCONNECTED);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.376 -0400", hash_original_method = "718236D89EF9807FC1BDBDC68F5BE0B1", hash_generated_method = "CD0F7F878B46EE180A79740141D6B721")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized void onBluetoothEnable() {
        String devices;
        devices = mBluetoothService.getProperty("Devices", true);
        {
            String [] paths;
            paths = devices.split(",");
            {
                Iterator<String> seatecAstronomy42 = paths.iterator();
                seatecAstronomy42.hasNext();
                String path = seatecAstronomy42.next();
                {
                    String address;
                    address = mBluetoothService.getAddressFromObjectPath(path);
                    BluetoothDevice device;
                    device = mAdapter.getRemoteDevice(address);
                    ParcelUuid[] remoteUuids;
                    remoteUuids = mBluetoothService.getRemoteUuids(address);
                    {
                        boolean varEFEA2AE509A5A0D00B58C14D0A280025_1148901106 = (BluetoothUuid.containsAnyUuid(remoteUuids,
                            new ParcelUuid[] {BluetoothUuid.AudioSink,
                                                BluetoothUuid.AdvAudioDist}));
                        {
                            addAudioSink(device);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        mAudioManager.setParameters(BLUETOOTH_ENABLED+"=true");
        mAudioManager.setParameters("A2dpSuspended=false");
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.376 -0400", hash_original_method = "057740AAF17FBB38054827B5DBB3786E", hash_generated_method = "8C78691596EADF1D695CA0B1B2A4D7DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized void onBluetoothDisable() {
        {
            boolean var4ED20D760C82D2572F20E70A2B8607F3_1651100295 = (!mAudioDevices.isEmpty());
            {
                BluetoothDevice[] devices;
                devices = new BluetoothDevice[mAudioDevices.size()];
                devices = mAudioDevices.keySet().toArray(devices);
                {
                    Iterator<BluetoothDevice> seatecAstronomy42 = devices.iterator();
                    seatecAstronomy42.hasNext();
                    BluetoothDevice device = seatecAstronomy42.next();
                    {
                        int state;
                        state = getConnectionState(device);
                        //Begin case BluetoothA2dp.STATE_CONNECTING BluetoothA2dp.STATE_CONNECTED BluetoothA2dp.STATE_PLAYING 
                        disconnectSinkNative(mBluetoothService.getObjectPathFromAddress(
                                device.getAddress()));
                        //End case BluetoothA2dp.STATE_CONNECTING BluetoothA2dp.STATE_CONNECTED BluetoothA2dp.STATE_PLAYING 
                        //Begin case BluetoothA2dp.STATE_CONNECTING BluetoothA2dp.STATE_CONNECTED BluetoothA2dp.STATE_PLAYING 
                        handleSinkStateChange(device, state, BluetoothA2dp.STATE_DISCONNECTED);
                        //End case BluetoothA2dp.STATE_CONNECTING BluetoothA2dp.STATE_CONNECTED BluetoothA2dp.STATE_PLAYING 
                        //Begin case BluetoothA2dp.STATE_DISCONNECTING 
                        handleSinkStateChange(device, BluetoothA2dp.STATE_DISCONNECTING,
                                              BluetoothA2dp.STATE_DISCONNECTED);
                        //End case BluetoothA2dp.STATE_DISCONNECTING 
                    } //End block
                } //End collapsed parenthetic
                mAudioDevices.clear();
            } //End block
        } //End collapsed parenthetic
        mAudioManager.setParameters(BLUETOOTH_ENABLED + "=false");
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.376 -0400", hash_original_method = "2D743EE6C84EFFA23F925E98B8C214D8", hash_generated_method = "E6E9E3A3912928DF041C13995B43B5BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized boolean isConnectSinkFeasible(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        {
            boolean var3365A9D6AB037F2EB5DB487DAE1A63C2_1747957301 = (!mBluetoothService.isEnabled() || !isSinkDevice(device) ||
                getPriority(device) == BluetoothA2dp.PRIORITY_OFF);
        } //End collapsed parenthetic
        addAudioSink(device);
        String path;
        path = mBluetoothService.getObjectPathFromAddress(device.getAddress());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!mBluetoothService.isEnabled() || !isSinkDevice(device) ||
                //getPriority(device) == BluetoothA2dp.PRIORITY_OFF) {
            //return false;
        //}
        //addAudioSink(device);
        //String path = mBluetoothService.getObjectPathFromAddress(device.getAddress());
        //if (path == null) {
            //return false;
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.377 -0400", hash_original_method = "C281B275819B6BC64E29B03637298549", hash_generated_method = "BE40006657DF1F4C10D18590626B993B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean isA2dpPlaying(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
            "Need BLUETOOTH_ADMIN permission");
        log("isA2dpPlaying(" + device + ")");
        {
            boolean var7FE4871CEE4B768563C2857F333D9A68_1042925808 = (device.equals(mPlayingA2dpDevice));
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
            //"Need BLUETOOTH_ADMIN permission");
        //if (DBG) log("isA2dpPlaying(" + device + ")");
        //if (device.equals(mPlayingA2dpDevice)) return true;
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.377 -0400", hash_original_method = "07AD2C94298BC961DF940CF2EC4D62B8", hash_generated_method = "2BA9919B1F8079BF813A3605D077AA75")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean connect(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                                                "Need BLUETOOTH_ADMIN permission");
        log("connectSink(" + device + ")");
        {
            boolean varD11045CEB4C082ACFAFB80DCDA3A30A3_1979361248 = (!isConnectSinkFeasible(device));
        } //End collapsed parenthetic
        {
            Iterator<BluetoothDevice> seatecAstronomy42 = mAudioDevices.keySet().iterator();
            seatecAstronomy42.hasNext();
            BluetoothDevice sinkDevice = seatecAstronomy42.next();
            {
                {
                    boolean var8DEE4E73A6154881ACD013D32B9642E0_21008665 = (getConnectionState(sinkDevice) != BluetoothProfile.STATE_DISCONNECTED);
                    {
                        disconnect(sinkDevice);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean var71ED8B69BC96B3F20C79F6F7848BE144_710026700 = (mBluetoothService.connectSink(device.getAddress()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                                                //"Need BLUETOOTH_ADMIN permission");
        //if (DBG) log("connectSink(" + device + ")");
        //if (!isConnectSinkFeasible(device)) return false;
        //for (BluetoothDevice sinkDevice : mAudioDevices.keySet()) {
            //if (getConnectionState(sinkDevice) != BluetoothProfile.STATE_DISCONNECTED) {
                //disconnect(sinkDevice);
            //}
        //}
        //return mBluetoothService.connectSink(device.getAddress());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.377 -0400", hash_original_method = "1DEB5EBDE123FC80C0C5791B8E2EBF24", hash_generated_method = "BC4B9D354865C72057BDEE4682EB4EDC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean connectSinkInternal(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        {
            boolean varF269B307C69064FDAFB1C7364376830E_1103105790 = (!mBluetoothService.isEnabled());
        } //End collapsed parenthetic
        int state;
        state = mAudioDevices.get(device);
        {
            boolean varF307A1622522F268B72A67E7212D09FB_45979611 = (getDevicesMatchingConnectionStates(new int[] {
                BluetoothA2dp.STATE_CONNECTING,
                BluetoothA2dp.STATE_CONNECTED,
                BluetoothA2dp.STATE_DISCONNECTING}).size() != 0);
        } //End collapsed parenthetic
        String path;
        path = mBluetoothService.getObjectPathFromAddress(device.getAddress());
        {
            boolean var9E23153890A13665C040317C06513146_1185282636 = (getPriority(device) < BluetoothA2dp.PRIORITY_AUTO_CONNECT);
            {
                setPriority(device, BluetoothA2dp.PRIORITY_AUTO_CONNECT);
            } //End block
        } //End collapsed parenthetic
        handleSinkStateChange(device, state, BluetoothA2dp.STATE_CONNECTING);
        {
            boolean var00E5E764BA49190597425DBF6548B609_846536663 = (!connectSinkNative(path));
            {
                handleSinkStateChange(device, mAudioDevices.get(device), state);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.377 -0400", hash_original_method = "809D6195F6B53D2BE04CC2744CBA6A1E", hash_generated_method = "C2EEEF8B1C32152DE2D63A9FFB069BD7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized boolean isDisconnectSinkFeasible(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        String path;
        path = mBluetoothService.getObjectPathFromAddress(device.getAddress());
        int state;
        state = getConnectionState(device);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //String path = mBluetoothService.getObjectPathFromAddress(device.getAddress());
        //if (path == null) {
            //return false;
        //}
        //int state = getConnectionState(device);
        //switch (state) {
        //case BluetoothA2dp.STATE_DISCONNECTED:
        //case BluetoothA2dp.STATE_DISCONNECTING:
            //return false;
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.377 -0400", hash_original_method = "BDD615D62FBA296EB2749B9B0475D7E7", hash_generated_method = "8EBC6CB6CE935E9799F11ECAE5AABF0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean disconnect(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                                                "Need BLUETOOTH_ADMIN permission");
        log("disconnectSink(" + device + ")");
        {
            boolean varE5839C94280C9E4672655ABF699B5BCB_1909323676 = (!isDisconnectSinkFeasible(device));
        } //End collapsed parenthetic
        boolean varB226B3C49FEE8A55204DE0A40AE339B4_1548410328 = (mBluetoothService.disconnectSink(device.getAddress()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                                                //"Need BLUETOOTH_ADMIN permission");
        //if (DBG) log("disconnectSink(" + device + ")");
        //if (!isDisconnectSinkFeasible(device)) return false;
        //return mBluetoothService.disconnectSink(device.getAddress());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.378 -0400", hash_original_method = "BD23895136C9C060A411541E8EECAB76", hash_generated_method = "3FBDAB0030A4A0A1D802EF31E8B1E539")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean disconnectSinkInternal(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        int state;
        state = getConnectionState(device);
        String path;
        path = mBluetoothService.getObjectPathFromAddress(device.getAddress());
        handleSinkStateChange(device, state, BluetoothA2dp.STATE_DISCONNECTING);
        {
            boolean varE6D5F24FD081A490A1EC57CB7AEC966C_1246242565 = (!disconnectSinkNative(path));
            {
                handleSinkStateChange(device, mAudioDevices.get(device), state);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int state = getConnectionState(device);
        //String path = mBluetoothService.getObjectPathFromAddress(device.getAddress());
        //switch (state) {
            //case BluetoothA2dp.STATE_DISCONNECTED:
            //case BluetoothA2dp.STATE_DISCONNECTING:
                //return false;
        //}
        //handleSinkStateChange(device, state, BluetoothA2dp.STATE_DISCONNECTING);
        //if (!disconnectSinkNative(path)) {
            //handleSinkStateChange(device, mAudioDevices.get(device), state);
            //return false;
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.378 -0400", hash_original_method = "DA9361DA2FD6AED5C3D0E0DC1E754261", hash_generated_method = "0D0473CB351EE014FB096BFBD4A7C247")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean suspendSink(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                            "Need BLUETOOTH_ADMIN permission");
        log("suspendSink(" + device + "), mTargetA2dpState: "+mTargetA2dpState);
        String path;
        path = mBluetoothService.getObjectPathFromAddress(device.getAddress());
        Integer state;
        state = mAudioDevices.get(device);
        mTargetA2dpState = BluetoothA2dp.STATE_CONNECTED;
        boolean varF1572EEF63A581705E3E6301C5EF34D2_14477222 = (checkSinkSuspendState(state.intValue()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                            //"Need BLUETOOTH_ADMIN permission");
        //if (DBG) log("suspendSink(" + device + "), mTargetA2dpState: "+mTargetA2dpState);
        //if (device == null || mAudioDevices == null) {
            //return false;
        //}
        //String path = mBluetoothService.getObjectPathFromAddress(device.getAddress());
        //Integer state = mAudioDevices.get(device);
        //if (path == null || state == null) {
            //return false;
        //}
        //mTargetA2dpState = BluetoothA2dp.STATE_CONNECTED;
        //return checkSinkSuspendState(state.intValue());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.378 -0400", hash_original_method = "CA2AFA5B8D30A845047E70FF1ABF2A38", hash_generated_method = "3B5E1262E11B80808C6419A9C5F44E41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean resumeSink(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                            "Need BLUETOOTH_ADMIN permission");
        log("resumeSink(" + device + "), mTargetA2dpState: "+mTargetA2dpState);
        String path;
        path = mBluetoothService.getObjectPathFromAddress(device.getAddress());
        Integer state;
        state = mAudioDevices.get(device);
        mTargetA2dpState = BluetoothA2dp.STATE_PLAYING;
        boolean varF1572EEF63A581705E3E6301C5EF34D2_116474683 = (checkSinkSuspendState(state.intValue()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                            //"Need BLUETOOTH_ADMIN permission");
        //if (DBG) log("resumeSink(" + device + "), mTargetA2dpState: "+mTargetA2dpState);
        //if (device == null || mAudioDevices == null) {
            //return false;
        //}
        //String path = mBluetoothService.getObjectPathFromAddress(device.getAddress());
        //Integer state = mAudioDevices.get(device);
        //if (path == null || state == null) {
            //return false;
        //}
        //mTargetA2dpState = BluetoothA2dp.STATE_PLAYING;
        //return checkSinkSuspendState(state.intValue());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.378 -0400", hash_original_method = "5A82199900A51B95C62F596B5B785410", hash_generated_method = "12583074E2E78539C266813ABF31AC39")
    @DSModeled(DSC.SAFE)
    public synchronized int getConnectionState(BluetoothDevice device) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(device.dsTaint);
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        Integer state;
        state = mAudioDevices.get(device);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        //Integer state = mAudioDevices.get(device);
        //if (state == null)
            //return BluetoothA2dp.STATE_DISCONNECTED;
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.378 -0400", hash_original_method = "1AC2296A86E8C710D9BCA58ACAC26908", hash_generated_method = "450DB82A395E357AB0D9611549DF4A6A")
    @DSModeled(DSC.SAFE)
    public synchronized List<BluetoothDevice> getConnectedDevices() {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        List<BluetoothDevice> sinks;
        sinks = getDevicesMatchingConnectionStates(
                new int[] {BluetoothA2dp.STATE_CONNECTED});
        return (List<BluetoothDevice>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        //List<BluetoothDevice> sinks = getDevicesMatchingConnectionStates(
                //new int[] {BluetoothA2dp.STATE_CONNECTED});
        //return sinks;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.379 -0400", hash_original_method = "D791863FC28F1C2E3FF649331637B7A5", hash_generated_method = "619FC6A45CBAC6BEC1A7CEC046821D70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] states) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(states);
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        ArrayList<BluetoothDevice> sinks;
        sinks = new ArrayList<BluetoothDevice>();
        {
            Iterator<BluetoothDevice> seatecAstronomy42 = mAudioDevices.keySet().iterator();
            seatecAstronomy42.hasNext();
            BluetoothDevice device = seatecAstronomy42.next();
            {
                int sinkState;
                sinkState = getConnectionState(device);
                {
                    int state = states[0];
                    {
                        {
                            sinks.add(device);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (List<BluetoothDevice>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        //ArrayList<BluetoothDevice> sinks = new ArrayList<BluetoothDevice>();
        //for (BluetoothDevice device: mAudioDevices.keySet()) {
            //int sinkState = getConnectionState(device);
            //for (int state : states) {
                //if (state == sinkState) {
                    //sinks.add(device);
                    //break;
                //}
            //}
        //}
        //return sinks;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.379 -0400", hash_original_method = "92110E6B717F94E024631E8AE7101A1F", hash_generated_method = "C5A71F8E6FFC9BF672E9FA76369D019A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int getPriority(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        int var3193F747958C5DF75EF9EB7D7506999E_1873671705 = (Settings.Secure.getInt(mContext.getContentResolver(),
                Settings.Secure.getBluetoothA2dpSinkPriorityKey(device.getAddress()),
                BluetoothA2dp.PRIORITY_UNDEFINED));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        //return Settings.Secure.getInt(mContext.getContentResolver(),
                //Settings.Secure.getBluetoothA2dpSinkPriorityKey(device.getAddress()),
                //BluetoothA2dp.PRIORITY_UNDEFINED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.379 -0400", hash_original_method = "D4CB8BAFD296012FB4344E83E8D44639", hash_generated_method = "2204BB7EBC40C1F70A05482D7523CB68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean setPriority(BluetoothDevice device, int priority) {
        dsTaint.addTaint(priority);
        dsTaint.addTaint(device.dsTaint);
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                                                "Need BLUETOOTH_ADMIN permission");
        boolean var670D98749F7C25E4C9B8A7895D6C57D2_349670623 = (Settings.Secure.putInt(mContext.getContentResolver(),
                Settings.Secure.getBluetoothA2dpSinkPriorityKey(device.getAddress()), priority));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                                                //"Need BLUETOOTH_ADMIN permission");
        //return Settings.Secure.putInt(mContext.getContentResolver(),
                //Settings.Secure.getBluetoothA2dpSinkPriorityKey(device.getAddress()), priority);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.379 -0400", hash_original_method = "093856F1E32695D75A40094E0B656CCE", hash_generated_method = "B6B5A66862B1743C83D06F1E6805F195")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean allowIncomingConnect(BluetoothDevice device, boolean value) {
        dsTaint.addTaint(device.dsTaint);
        dsTaint.addTaint(value);
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                                                "Need BLUETOOTH_ADMIN permission");
        String address;
        address = device.getAddress();
        {
            boolean varD73B4433999E31B5BD12C61E2C084961_702673063 = (!BluetoothAdapter.checkBluetoothAddress(address));
        } //End collapsed parenthetic
        Integer data;
        data = mBluetoothService.getAuthorizationAgentRequestData(address);
        log("allowIncomingConnect: A2DP: " + device + ":" + value);
        boolean varE1D7CF2A8248EAD082F7D7D0D6CB5DAF_1374616111 = (mBluetoothService.setAuthorizationNative(address, value, data.intValue()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                                                //"Need BLUETOOTH_ADMIN permission");
        //String address = device.getAddress();
        //if (!BluetoothAdapter.checkBluetoothAddress(address)) {
            //return false;
        //}
        //Integer data = mBluetoothService.getAuthorizationAgentRequestData(address);
        //if (data == null) {
            //Log.w(TAG, "allowIncomingConnect(" + device + ") called but no native data available");
            //return false;
        //}
        //log("allowIncomingConnect: A2DP: " + device + ":" + value);
        //return mBluetoothService.setAuthorizationNative(address, value, data.intValue());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.379 -0400", hash_original_method = "29D3F41BECA81AA1C4387320CF05DFBE", hash_generated_method = "37AE45B285CFB70CCB11823981E3BBCC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized void onSinkPropertyChanged(String path, String[] propValues) {
        dsTaint.addTaint(propValues);
        dsTaint.addTaint(path);
        {
            boolean varF269B307C69064FDAFB1C7364376830E_907129672 = (!mBluetoothService.isEnabled());
        } //End collapsed parenthetic
        String name;
        name = propValues[0];
        String address;
        address = mBluetoothService.getAddressFromObjectPath(path);
        BluetoothDevice device;
        device = mAdapter.getRemoteDevice(address);
        {
            boolean varBE3E5E797FFC2CABB810A3B1E82773E2_206240980 = (name.equals(PROPERTY_STATE));
            {
                int state;
                state = convertBluezSinkStringToState(propValues[1]);
                log("A2DP: onSinkPropertyChanged newState is: " + state + "mPlayingA2dpDevice: " + mPlayingA2dpDevice);
                {
                    boolean var48F0E62926BC762F8F8E9466890B6243_2041746134 = (mAudioDevices.get(device) == null);
                    {
                        addAudioSink(device);
                        handleSinkStateChange(device, BluetoothA2dp.STATE_DISCONNECTED, state);
                    } //End block
                    {
                        {
                            mPlayingA2dpDevice = device;
                            handleSinkPlayingStateChange(device, state, BluetoothA2dp.STATE_NOT_PLAYING);
                        } //End block
                        {
                            mPlayingA2dpDevice = null;
                            handleSinkPlayingStateChange(device, BluetoothA2dp.STATE_NOT_PLAYING,
                        BluetoothA2dp.STATE_PLAYING);
                        } //End block
                        {
                            mPlayingA2dpDevice = null;
                            int prevState;
                            prevState = mAudioDevices.get(device);
                            handleSinkStateChange(device, prevState, state);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.380 -0400", hash_original_method = "22D35051B0C9C5D9E7A4167780B44BB7", hash_generated_method = "06CFCD4DD5D4D102B87958A0E7E3938A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleSinkStateChange(BluetoothDevice device, int prevState, int state) {
        dsTaint.addTaint(device.dsTaint);
        dsTaint.addTaint(state);
        dsTaint.addTaint(prevState);
        {
            mAudioDevices.put(device, state);
            checkSinkSuspendState(state);
            mTargetA2dpState = -1;
            {
                boolean varC648DD2E59AC969AC4B6E6D48BC19883_1885221162 = (getPriority(device) > BluetoothA2dp.PRIORITY_OFF &&
                    state == BluetoothA2dp.STATE_CONNECTED);
                {
                    setPriority(device, BluetoothA2dp.PRIORITY_AUTO_CONNECT);
                    adjustOtherSinkPriorities(device);
                } //End block
            } //End collapsed parenthetic
            Intent intent;
            intent = new Intent(BluetoothA2dp.ACTION_CONNECTION_STATE_CHANGED);
            intent.putExtra(BluetoothDevice.EXTRA_DEVICE, device);
            intent.putExtra(BluetoothProfile.EXTRA_PREVIOUS_STATE, prevState);
            intent.putExtra(BluetoothProfile.EXTRA_STATE, state);
            intent.addFlags(Intent.FLAG_RECEIVER_REGISTERED_ONLY_BEFORE_BOOT);
            mContext.sendBroadcast(intent, BLUETOOTH_PERM);
            log("A2DP state : device: " + device + " State:" + prevState + "->" + state);
            mBluetoothService.sendConnectionStateChange(device, BluetoothProfile.A2DP, state,
                                                        prevState);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.380 -0400", hash_original_method = "7E6CB91A3E39FCD819A7505FAE6C0D13", hash_generated_method = "35DD0AA6A8EC4ECEA2DE8B4A8FE24ED3")
    @DSModeled(DSC.SAFE)
    private void handleSinkPlayingStateChange(BluetoothDevice device, int state, int prevState) {
        dsTaint.addTaint(device.dsTaint);
        dsTaint.addTaint(state);
        dsTaint.addTaint(prevState);
        Intent intent;
        intent = new Intent(BluetoothA2dp.ACTION_PLAYING_STATE_CHANGED);
        intent.putExtra(BluetoothDevice.EXTRA_DEVICE, device);
        intent.putExtra(BluetoothProfile.EXTRA_PREVIOUS_STATE, prevState);
        intent.putExtra(BluetoothProfile.EXTRA_STATE, state);
        intent.addFlags(Intent.FLAG_RECEIVER_REGISTERED_ONLY_BEFORE_BOOT);
        mContext.sendBroadcast(intent, BLUETOOTH_PERM);
        log("A2DP Playing state : device: " + device + " State:" + prevState + "->" + state);
        // ---------- Original Method ----------
        //Intent intent = new Intent(BluetoothA2dp.ACTION_PLAYING_STATE_CHANGED);
        //intent.putExtra(BluetoothDevice.EXTRA_DEVICE, device);
        //intent.putExtra(BluetoothProfile.EXTRA_PREVIOUS_STATE, prevState);
        //intent.putExtra(BluetoothProfile.EXTRA_STATE, state);
        //intent.addFlags(Intent.FLAG_RECEIVER_REGISTERED_ONLY_BEFORE_BOOT);
        //mContext.sendBroadcast(intent, BLUETOOTH_PERM);
        //if (DBG) log("A2DP Playing state : device: " + device + " State:" + prevState + "->" + state);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.380 -0400", hash_original_method = "9995F7BA6F946900FC4B681187802F93", hash_generated_method = "E94A6A441D1B7328502D6357E629EB86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void adjustOtherSinkPriorities(BluetoothDevice connectedDevice) {
        dsTaint.addTaint(connectedDevice.dsTaint);
        {
            Iterator<BluetoothDevice> seatecAstronomy42 = mAdapter.getBondedDevices().iterator();
            seatecAstronomy42.hasNext();
            BluetoothDevice device = seatecAstronomy42.next();
            {
                {
                    boolean varE6E4BAF79E9CFBF161A818E4FC733FD2_629756285 = (getPriority(device) >= BluetoothA2dp.PRIORITY_AUTO_CONNECT &&
                !device.equals(connectedDevice));
                    {
                        setPriority(device, BluetoothA2dp.PRIORITY_ON);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (BluetoothDevice device : mAdapter.getBondedDevices()) {
            //if (getPriority(device) >= BluetoothA2dp.PRIORITY_AUTO_CONNECT &&
                //!device.equals(connectedDevice)) {
                //setPriority(device, BluetoothA2dp.PRIORITY_ON);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.380 -0400", hash_original_method = "4FAD45E4EFD472A7B32E713CE5DD85FF", hash_generated_method = "5B2EB56614609A6D71D9C77ABC26E29C")
    @DSModeled(DSC.SAFE)
    private boolean checkSinkSuspendState(int state) {
        dsTaint.addTaint(state);
        boolean result;
        result = true;
        {
            {
                mAudioManager.setParameters("A2dpSuspended=true");
            } //End block
            {
                mAudioManager.setParameters("A2dpSuspended=false");
            } //End block
            {
                result = false;
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean result = true;
        //if (state != mTargetA2dpState) {
            //if (state == BluetoothA2dp.STATE_PLAYING &&
                //mTargetA2dpState == BluetoothA2dp.STATE_CONNECTED) {
                //mAudioManager.setParameters("A2dpSuspended=true");
            //} else if (state == BluetoothA2dp.STATE_CONNECTED &&
                //mTargetA2dpState == BluetoothA2dp.STATE_PLAYING) {
                //mAudioManager.setParameters("A2dpSuspended=false");
            //} else {
                //result = false;
            //}
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.381 -0400", hash_original_method = "35762C3193E408003672E673C0D9F75D", hash_generated_method = "43737CF1CB27DFB82DF4A89268BE0990")
    @DSModeled(DSC.SAFE)
    private void onConnectSinkResult(String deviceObjectPath, boolean result) {
        dsTaint.addTaint(result);
        dsTaint.addTaint(deviceObjectPath);
        {
            {
                String address;
                address = mBluetoothService.getAddressFromObjectPath(deviceObjectPath);
                BluetoothDevice device;
                device = mAdapter.getRemoteDevice(address);
                int state;
                state = getConnectionState(device);
                handleSinkStateChange(device, state, BluetoothA2dp.STATE_DISCONNECTED);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (!result) {
            //if (deviceObjectPath != null) {
                //String address = mBluetoothService.getAddressFromObjectPath(deviceObjectPath);
                //if (address == null) return;
                //BluetoothDevice device = mAdapter.getRemoteDevice(address);
                //int state = getConnectionState(device);
                //handleSinkStateChange(device, state, BluetoothA2dp.STATE_DISCONNECTED);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.381 -0400", hash_original_method = "9DCB8DF85A5D19C9E4F0CBC772CD0C5E", hash_generated_method = "EDC1DC1C9D726C4C57633BFB704E5F92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected synchronized void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        dsTaint.addTaint(args);
        dsTaint.addTaint(pw.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        {
            boolean var0F9A741166F03CCBCC5F67D4B83CFFD9_431608681 = (mAudioDevices.isEmpty());
        } //End collapsed parenthetic
        pw.println("Cached audio devices:");
        {
            Iterator<BluetoothDevice> seatecAstronomy42 = mAudioDevices.keySet().iterator();
            seatecAstronomy42.hasNext();
            BluetoothDevice device = seatecAstronomy42.next();
            {
                int state;
                state = mAudioDevices.get(device);
                pw.println(device + " " + BluetoothA2dp.stateToString(state));
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mAudioDevices.isEmpty()) return;
        //pw.println("Cached audio devices:");
        //for (BluetoothDevice device : mAudioDevices.keySet()) {
            //int state = mAudioDevices.get(device);
            //pw.println(device + " " + BluetoothA2dp.stateToString(state));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.381 -0400", hash_original_method = "0EBF7673E44AF610ADC3AB53A65BD597", hash_generated_method = "12E4FDCE2D2661CC6DF9F077D2C0BB73")
    private static void log(String msg) {
        Log.d(TAG, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.381 -0400", hash_original_method = "F316CBE5001C55DC23500428B5A4F5D7", hash_generated_method = "9398E78DB5961CFE21A6ED01251A2167")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean initNative() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.381 -0400", hash_original_method = "0C2EE552DC7F558BD6A4A53E3AFE7F2F", hash_generated_method = "FEBF52E76EE6BE079C357FDB1789C282")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void cleanupNative() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.381 -0400", hash_original_method = "45EC4B58B4B524F3D68AA4F5C4E76250", hash_generated_method = "4A2E53E3D26E19A6FE580C739286788B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized boolean connectSinkNative(String path) {
        dsTaint.addTaint(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.381 -0400", hash_original_method = "403324192B795BCA5743A71826DA520B", hash_generated_method = "CC3417B3533B15A87766F4EC7DAB338E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized boolean disconnectSinkNative(String path) {
        dsTaint.addTaint(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.381 -0400", hash_original_method = "B0E2A721781E8336DD74015E36F93AF2", hash_generated_method = "A8E22597BFEF2A867597AD45DF0E8944")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized boolean suspendSinkNative(String path) {
        dsTaint.addTaint(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.381 -0400", hash_original_method = "EFB7529219D3C04F81399BB83968494E", hash_generated_method = "59ECE0329C307C2B7D347BAC5F72A1C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized boolean resumeSinkNative(String path) {
        dsTaint.addTaint(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.381 -0400", hash_original_method = "EBC56FED6C650E0906D172BC3BEF88DD", hash_generated_method = "04FD2EA4E46C8FF5D1E3E5B00516BFBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized Object [] getSinkPropertiesNative(String path) {
        dsTaint.addTaint(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.381 -0400", hash_original_method = "6C4F9CEFD4C3CF75AABC69FD3AA8F07B", hash_generated_method = "8EDD80AAA967E5EB1887163E05B70FFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized boolean avrcpVolumeUpNative(String path) {
        dsTaint.addTaint(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.382 -0400", hash_original_method = "9BA8689E3938B2DF476597636059B0E6", hash_generated_method = "82D49AC1E2567C4E9A88DF2C16B3890D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized boolean avrcpVolumeDownNative(String path) {
        dsTaint.addTaint(path);
    }

    
}


