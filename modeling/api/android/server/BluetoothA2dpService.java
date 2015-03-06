/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * TODO: Move this to services.jar
 * and make the constructor package private again.
 * @hide
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.server;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.105 -0400", hash_original_field = "F7BE345D8432151F393BCADE247CA21B", hash_generated_field = "69040284546242DA4C7DDD43177486F6")

    private static final String TAG = "BluetoothA2dpService";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.107 -0400", hash_original_field = "95D5733A0C83DB3D047D109C028C9F02", hash_generated_field = "B7707D757F0604821CCAF673B2122320")

    private static final boolean DBG = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.108 -0400", hash_original_field = "27D205A061FECC149542D215DE09D949", hash_generated_field = "67038ABD138EE0782CAB470526F24F8A")

    public static final String BLUETOOTH_A2DP_SERVICE = "bluetooth_a2dp";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.110 -0400", hash_original_field = "4DF5D31E376F27F1ED153009F2B9E52D", hash_generated_field = "A458E8B2DE444E0F35989DFD935DFB5E")

    private static final String BLUETOOTH_ADMIN_PERM = android.Manifest.permission.BLUETOOTH_ADMIN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.112 -0400", hash_original_field = "7D77AF0882759DFB1A72C6B4C36DC3FE", hash_generated_field = "E2769F8C31AF358A24555782DE15D8EA")

    private static final String BLUETOOTH_PERM = android.Manifest.permission.BLUETOOTH;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.114 -0400", hash_original_field = "DBC1313AABDEA2F27F7ACFEA80E16438", hash_generated_field = "2258CD2ECC199D4A30E45874F6460BE4")

    private static final String BLUETOOTH_ENABLED = "bluetooth_enabled";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.115 -0400", hash_original_field = "B75E5C2AB63CA7BA825AEF29B7CF7E48", hash_generated_field = "0E95D5287C95216CC78C437C243AAF47")

    private static final String PROPERTY_STATE = "State";

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.188 -0400", hash_original_method = "0EBF7673E44AF610ADC3AB53A65BD597", hash_generated_method = "12E4FDCE2D2661CC6DF9F077D2C0BB73")
    
private static void log(String msg) {
        Log.d(TAG, msg);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.117 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.118 -0400", hash_original_field = "0DB283351EC814B93D52AEB5B24E6EF6", hash_generated_field = "6341ED23E171F7FC731950F1780200DC")

    private  IntentFilter mIntentFilter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.120 -0400", hash_original_field = "847A45BBF8CF3B865292E85ADBB40EA3", hash_generated_field = "0135E64B0FFBAB02C96FEB1ED747A329")

    private HashMap<BluetoothDevice, Integer> mAudioDevices;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.121 -0400", hash_original_field = "81931559493F052ED78BA000FD1BC717", hash_generated_field = "B52B11818937F27E927A20CDEBA27654")

    private  AudioManager mAudioManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.123 -0400", hash_original_field = "A159F05F3527228E8E398101D1BCF02A", hash_generated_field = "63FC39FA8AD5AA0E0E655FCBD5956634")

    private  BluetoothService mBluetoothService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.125 -0400", hash_original_field = "367F0BC6BC216C571A7E906A286477DF", hash_generated_field = "6EAF57CC559AB78B0231BFFF469261B9")

    private  BluetoothAdapter mAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.126 -0400", hash_original_field = "A42D59195B4F4DCCE334B511CAE6C931", hash_generated_field = "65EE9449A8A1111AE03AB5D5AF030781")

    private int   mTargetA2dpState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.127 -0400", hash_original_field = "863F33BEC9C07D52A00BA40860CCC9F8", hash_generated_field = "56F61BDBD7EB5E0E88A916CC3F6B6763")

    private BluetoothDevice mPlayingA2dpDevice;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.133 -0400", hash_original_field = "0E0C7B980ADD0D434C4E6143AE26C160", hash_generated_field = "2B9DF3DAD1EE53E34A2D51A12C594F7D")

    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 13:06:56.986 -0400", hash_original_method = "878FE6B60A52570D7F6B49AD2B0B3F2D", hash_generated_method = "D413CDE19E8443BD63B95B93A2A1364F")
        
@Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            BluetoothDevice device =
                    intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            if (action.equals(BluetoothAdapter.ACTION_STATE_CHANGED)) {
                int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE,
                                               BluetoothAdapter.ERROR);
                switch (state) {
                case BluetoothAdapter.STATE_ON:
                    onBluetoothEnable();
                    break;
                case BluetoothAdapter.STATE_TURNING_OFF:
                    onBluetoothDisable();
                    break;
                }
            } else if (action.equals(BluetoothDevice.ACTION_ACL_DISCONNECTED)) {
                synchronized (this) {
                    if (mAudioDevices.containsKey(device)) {
                        int state = mAudioDevices.get(device);
                        handleSinkStateChange(device, state, BluetoothA2dp.STATE_DISCONNECTED);
                    }
                }
            } else if (action.equals(AudioManager.VOLUME_CHANGED_ACTION)) {
                int streamType = intent.getIntExtra(AudioManager.EXTRA_VOLUME_STREAM_TYPE, -1);
                if (streamType == AudioManager.STREAM_MUSIC) {
                    List<BluetoothDevice> sinks = getConnectedDevices();

                    if (sinks.size() != 0 && isPhoneDocked(sinks.get(0))) {
                        String address = sinks.get(0).getAddress();
                        int newVolLevel =
                          intent.getIntExtra(AudioManager.EXTRA_VOLUME_STREAM_VALUE, 0);
                        int oldVolLevel =
                          intent.getIntExtra(AudioManager.EXTRA_PREV_VOLUME_STREAM_VALUE, 0);
                        String path = mBluetoothService.getObjectPathFromAddress(address);
                        if (newVolLevel > oldVolLevel) {
                            avrcpVolumeUpNative(path);
                        } else if (newVolLevel < oldVolLevel) {
                            avrcpVolumeDownNative(path);
                        }
                    }
                }
            }
        }
    };

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.138 -0400", hash_original_method = "6C39FCCD1AF260530D18B98302E02CA2", hash_generated_method = "2D4A989192695BAAC6B39739A9D93392")
    
public BluetoothA2dpService(Context context, BluetoothService bluetoothService) {
        mContext = context;

        mAudioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

        mBluetoothService = bluetoothService;
        if (mBluetoothService == null) {
            throw new RuntimeException("Platform does not support Bluetooth");
        }

        if (!initNative()) {
            throw new RuntimeException("Could not init BluetoothA2dpService");
        }

        mAdapter = BluetoothAdapter.getDefaultAdapter();

        mIntentFilter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
        mIntentFilter.addAction(BluetoothDevice.ACTION_ACL_CONNECTED);
        mIntentFilter.addAction(BluetoothDevice.ACTION_ACL_DISCONNECTED);
        mIntentFilter.addAction(AudioManager.VOLUME_CHANGED_ACTION);
        mContext.registerReceiver(mReceiver, mIntentFilter);

        mAudioDevices = new HashMap<BluetoothDevice, Integer>();

        if (mBluetoothService.isEnabled())
            onBluetoothEnable();
        mTargetA2dpState = -1;
        mBluetoothService.setA2dpService(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.136 -0400", hash_original_method = "62207F14B0C3E20B350C50EBE13017D6", hash_generated_method = "34A8E349275EC2DE8D40D7278583555F")
    
private boolean isPhoneDocked(BluetoothDevice device) {
        // This works only because these broadcast intents are "sticky"
        Intent i = mContext.registerReceiver(null, new IntentFilter(Intent.ACTION_DOCK_EVENT));
        if (i != null) {
            int state = i.getIntExtra(Intent.EXTRA_DOCK_STATE, Intent.EXTRA_DOCK_STATE_UNDOCKED);
            if (state != Intent.EXTRA_DOCK_STATE_UNDOCKED) {
                BluetoothDevice dockDevice = i.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                if (dockDevice != null && device.equals(dockDevice)) {
                    return true;
                }
            }
        }
        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.140 -0400", hash_original_method = "55245180BFCEB39D7A6E7F3D4E6368A1", hash_generated_method = "FFF3452A468C85DF16976915AA7081FC")
    
@Override
    protected void finalize() throws Throwable {
        try {
            cleanupNative();
        } finally {
            super.finalize();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.141 -0400", hash_original_method = "58FD03EDFF8B6A70A28790F8AEABC35F", hash_generated_method = "C270870E66B6DD589A4B3C48D92C8528")
    
private int convertBluezSinkStringToState(String value) {
        if (value.equalsIgnoreCase("disconnected"))
            return BluetoothA2dp.STATE_DISCONNECTED;
        if (value.equalsIgnoreCase("connecting"))
            return BluetoothA2dp.STATE_CONNECTING;
        if (value.equalsIgnoreCase("connected"))
            return BluetoothA2dp.STATE_CONNECTED;
        if (value.equalsIgnoreCase("playing"))
            return BluetoothA2dp.STATE_PLAYING;
        return -1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.143 -0400", hash_original_method = "1F87BD4ABAE2C6479EB64121F5FF8512", hash_generated_method = "F5656FA9E7682D32DCE98844A727BFBB")
    
private boolean isSinkDevice(BluetoothDevice device) {
        ParcelUuid[] uuids = mBluetoothService.getRemoteUuids(device.getAddress());
        if (uuids != null && BluetoothUuid.isUuidPresent(uuids, BluetoothUuid.AudioSink)) {
            return true;
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.144 -0400", hash_original_method = "7F93958FB521D9474CABA2B58D66DC73", hash_generated_method = "36E9F4B029996CB05AD7B1E9249C3CEF")
    
private synchronized void addAudioSink(BluetoothDevice device) {
        if (mAudioDevices.get(device) == null) {
            mAudioDevices.put(device, BluetoothA2dp.STATE_DISCONNECTED);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.146 -0400", hash_original_method = "718236D89EF9807FC1BDBDC68F5BE0B1", hash_generated_method = "F6CE6D914287418DADD03B294E79E965")
    
private synchronized void onBluetoothEnable() {
        String devices = mBluetoothService.getProperty("Devices", true);
        if (devices != null) {
            String [] paths = devices.split(",");
            for (String path: paths) {
                String address = mBluetoothService.getAddressFromObjectPath(path);
                BluetoothDevice device = mAdapter.getRemoteDevice(address);
                ParcelUuid[] remoteUuids = mBluetoothService.getRemoteUuids(address);
                if (remoteUuids != null)
                    if (BluetoothUuid.containsAnyUuid(remoteUuids,
                            new ParcelUuid[] {BluetoothUuid.AudioSink,
                                                BluetoothUuid.AdvAudioDist})) {
                        addAudioSink(device);
                    }
                }
        }
        mAudioManager.setParameters(BLUETOOTH_ENABLED+"=true");
        mAudioManager.setParameters("A2dpSuspended=false");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.148 -0400", hash_original_method = "057740AAF17FBB38054827B5DBB3786E", hash_generated_method = "6A43121489C82EE3A25FAAFEB5A7BA84")
    
private synchronized void onBluetoothDisable() {
        if (!mAudioDevices.isEmpty()) {
            BluetoothDevice[] devices = new BluetoothDevice[mAudioDevices.size()];
            devices = mAudioDevices.keySet().toArray(devices);
            for (BluetoothDevice device : devices) {
                int state = getConnectionState(device);
                switch (state) {
                    case BluetoothA2dp.STATE_CONNECTING:
                    case BluetoothA2dp.STATE_CONNECTED:
                    case BluetoothA2dp.STATE_PLAYING:
                        disconnectSinkNative(mBluetoothService.getObjectPathFromAddress(
                                device.getAddress()));
                        handleSinkStateChange(device, state, BluetoothA2dp.STATE_DISCONNECTED);
                        break;
                    case BluetoothA2dp.STATE_DISCONNECTING:
                        handleSinkStateChange(device, BluetoothA2dp.STATE_DISCONNECTING,
                                              BluetoothA2dp.STATE_DISCONNECTED);
                        break;
                }
            }
            mAudioDevices.clear();
        }

        mAudioManager.setParameters(BLUETOOTH_ENABLED + "=false");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.150 -0400", hash_original_method = "2D743EE6C84EFFA23F925E98B8C214D8", hash_generated_method = "90D84B4BE56EA90D711EA4141962D54A")
    
private synchronized boolean isConnectSinkFeasible(BluetoothDevice device) {
        if (!mBluetoothService.isEnabled() || !isSinkDevice(device) ||
                getPriority(device) == BluetoothA2dp.PRIORITY_OFF) {
            return false;
        }

        addAudioSink(device);

        String path = mBluetoothService.getObjectPathFromAddress(device.getAddress());
        if (path == null) {
            return false;
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.151 -0400", hash_original_method = "C281B275819B6BC64E29B03637298549", hash_generated_method = "C64D3D446A1C96E22C27B2F08F69324A")
    
public synchronized boolean isA2dpPlaying(BluetoothDevice device) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
            "Need BLUETOOTH_ADMIN permission");
        if (DBG) log("isA2dpPlaying(" + device + ")");
        if (device.equals(mPlayingA2dpDevice)) return true;
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.153 -0400", hash_original_method = "07AD2C94298BC961DF940CF2EC4D62B8", hash_generated_method = "A1B5885C3ED40F4300B9711E86C01D65")
    
public synchronized boolean connect(BluetoothDevice device) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                                                "Need BLUETOOTH_ADMIN permission");
        if (DBG) log("connectSink(" + device + ")");
        if (!isConnectSinkFeasible(device)) return false;

        for (BluetoothDevice sinkDevice : mAudioDevices.keySet()) {
            if (getConnectionState(sinkDevice) != BluetoothProfile.STATE_DISCONNECTED) {
                disconnect(sinkDevice);
            }
        }

        return mBluetoothService.connectSink(device.getAddress());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.155 -0400", hash_original_method = "1DEB5EBDE123FC80C0C5791B8E2EBF24", hash_generated_method = "42F1320C5CB0E25FF2E462FCB6A6FFB3")
    
public synchronized boolean connectSinkInternal(BluetoothDevice device) {
        if (!mBluetoothService.isEnabled()) return false;

        int state = mAudioDevices.get(device);

        // ignore if there are any active sinks
        if (getDevicesMatchingConnectionStates(new int[] {
                BluetoothA2dp.STATE_CONNECTING,
                BluetoothA2dp.STATE_CONNECTED,
                BluetoothA2dp.STATE_DISCONNECTING}).size() != 0) {
            return false;
        }

        switch (state) {
        case BluetoothA2dp.STATE_CONNECTED:
        case BluetoothA2dp.STATE_DISCONNECTING:
            return false;
        case BluetoothA2dp.STATE_CONNECTING:
            return true;
        }

        String path = mBluetoothService.getObjectPathFromAddress(device.getAddress());

        // State is DISCONNECTED and we are connecting.
        if (getPriority(device) < BluetoothA2dp.PRIORITY_AUTO_CONNECT) {
            setPriority(device, BluetoothA2dp.PRIORITY_AUTO_CONNECT);
        }
        handleSinkStateChange(device, state, BluetoothA2dp.STATE_CONNECTING);

        if (!connectSinkNative(path)) {
            // Restore previous state
            handleSinkStateChange(device, mAudioDevices.get(device), state);
            return false;
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.157 -0400", hash_original_method = "809D6195F6B53D2BE04CC2744CBA6A1E", hash_generated_method = "61AE3668377E0CFFBACE4787A5911421")
    
private synchronized boolean isDisconnectSinkFeasible(BluetoothDevice device) {
        String path = mBluetoothService.getObjectPathFromAddress(device.getAddress());
        if (path == null) {
            return false;
        }

        int state = getConnectionState(device);
        switch (state) {
        case BluetoothA2dp.STATE_DISCONNECTED:
        case BluetoothA2dp.STATE_DISCONNECTING:
            return false;
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.159 -0400", hash_original_method = "BDD615D62FBA296EB2749B9B0475D7E7", hash_generated_method = "F1D3E861D9F4A2AF08BED546A5DBEF88")
    
public synchronized boolean disconnect(BluetoothDevice device) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                                                "Need BLUETOOTH_ADMIN permission");
        if (DBG) log("disconnectSink(" + device + ")");
        if (!isDisconnectSinkFeasible(device)) return false;
        return mBluetoothService.disconnectSink(device.getAddress());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.160 -0400", hash_original_method = "BD23895136C9C060A411541E8EECAB76", hash_generated_method = "DA61E557BC0054C97BC217189D5E0A2F")
    
public synchronized boolean disconnectSinkInternal(BluetoothDevice device) {
        int state = getConnectionState(device);
        String path = mBluetoothService.getObjectPathFromAddress(device.getAddress());

        switch (state) {
            case BluetoothA2dp.STATE_DISCONNECTED:
            case BluetoothA2dp.STATE_DISCONNECTING:
                return false;
        }
        // State is CONNECTING or CONNECTED or PLAYING
        handleSinkStateChange(device, state, BluetoothA2dp.STATE_DISCONNECTING);
        if (!disconnectSinkNative(path)) {
            // Restore previous state
            handleSinkStateChange(device, mAudioDevices.get(device), state);
            return false;
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.162 -0400", hash_original_method = "DA9361DA2FD6AED5C3D0E0DC1E754261", hash_generated_method = "1176BAF67E884BE088D4272B89D42A20")
    
public synchronized boolean suspendSink(BluetoothDevice device) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                            "Need BLUETOOTH_ADMIN permission");
        if (DBG) log("suspendSink(" + device + "), mTargetA2dpState: "+mTargetA2dpState);
        if (device == null || mAudioDevices == null) {
            return false;
        }
        String path = mBluetoothService.getObjectPathFromAddress(device.getAddress());
        Integer state = mAudioDevices.get(device);
        if (path == null || state == null) {
            return false;
        }

        mTargetA2dpState = BluetoothA2dp.STATE_CONNECTED;
        return checkSinkSuspendState(state.intValue());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.164 -0400", hash_original_method = "CA2AFA5B8D30A845047E70FF1ABF2A38", hash_generated_method = "39B114B9935FE9CA34FB02D80CEAA880")
    
public synchronized boolean resumeSink(BluetoothDevice device) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                            "Need BLUETOOTH_ADMIN permission");
        if (DBG) log("resumeSink(" + device + "), mTargetA2dpState: "+mTargetA2dpState);
        if (device == null || mAudioDevices == null) {
            return false;
        }
        String path = mBluetoothService.getObjectPathFromAddress(device.getAddress());
        Integer state = mAudioDevices.get(device);
        if (path == null || state == null) {
            return false;
        }
        mTargetA2dpState = BluetoothA2dp.STATE_PLAYING;
        return checkSinkSuspendState(state.intValue());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.166 -0400", hash_original_method = "5A82199900A51B95C62F596B5B785410", hash_generated_method = "28759D4FEECF560287BEBE3BE2331632")
    
public synchronized int getConnectionState(BluetoothDevice device) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        Integer state = mAudioDevices.get(device);
        if (state == null)
            return BluetoothA2dp.STATE_DISCONNECTED;
        return state;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.167 -0400", hash_original_method = "1AC2296A86E8C710D9BCA58ACAC26908", hash_generated_method = "69E48313F8A59DE4CAB0C78DCFCCD73E")
    
public synchronized List<BluetoothDevice> getConnectedDevices() {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        List<BluetoothDevice> sinks = getDevicesMatchingConnectionStates(
                new int[] {BluetoothA2dp.STATE_CONNECTED});
        return sinks;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.170 -0400", hash_original_method = "D791863FC28F1C2E3FF649331637B7A5", hash_generated_method = "C63A5E1B07A1A3EFC5235442E1C42E5F")
    
public synchronized List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] states) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        ArrayList<BluetoothDevice> sinks = new ArrayList<BluetoothDevice>();
        for (BluetoothDevice device: mAudioDevices.keySet()) {
            int sinkState = getConnectionState(device);
            for (int state : states) {
                if (state == sinkState) {
                    sinks.add(device);
                    break;
                }
            }
        }
        return sinks;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.171 -0400", hash_original_method = "92110E6B717F94E024631E8AE7101A1F", hash_generated_method = "981007BC7DD867A568E1E5D342E94E86")
    
public synchronized int getPriority(BluetoothDevice device) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        return Settings.Secure.getInt(mContext.getContentResolver(),
                Settings.Secure.getBluetoothA2dpSinkPriorityKey(device.getAddress()),
                BluetoothA2dp.PRIORITY_UNDEFINED);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.173 -0400", hash_original_method = "D4CB8BAFD296012FB4344E83E8D44639", hash_generated_method = "CEC4D2A4A37C82B5B95CFB396A418BA4")
    
public synchronized boolean setPriority(BluetoothDevice device, int priority) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                                                "Need BLUETOOTH_ADMIN permission");
        return Settings.Secure.putInt(mContext.getContentResolver(),
                Settings.Secure.getBluetoothA2dpSinkPriorityKey(device.getAddress()), priority);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.175 -0400", hash_original_method = "093856F1E32695D75A40094E0B656CCE", hash_generated_method = "8F61BCF209D7295DF9F26B6031424249")
    
public synchronized boolean allowIncomingConnect(BluetoothDevice device, boolean value) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                                                "Need BLUETOOTH_ADMIN permission");
        String address = device.getAddress();
        if (!BluetoothAdapter.checkBluetoothAddress(address)) {
            return false;
        }
        Integer data = mBluetoothService.getAuthorizationAgentRequestData(address);
        if (data == null) {
            Log.w(TAG, "allowIncomingConnect(" + device + ") called but no native data available");
            return false;
        }
        log("allowIncomingConnect: A2DP: " + device + ":" + value);
        return mBluetoothService.setAuthorizationNative(address, value, data.intValue());
    }

    /**
     * Called by native code on a PropertyChanged signal from
     * org.bluez.AudioSink.
     *
     * @param path the object path for the changed device
     * @param propValues a string array containing the key and one or more
     *  values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.177 -0400", hash_original_method = "29D3F41BECA81AA1C4387320CF05DFBE", hash_generated_method = "6049AB2C31355DF9978247A64507FAFF")
    
private synchronized void onSinkPropertyChanged(String path, String[] propValues) {
        if (!mBluetoothService.isEnabled()) {
            return;
        }

        String name = propValues[0];
        String address = mBluetoothService.getAddressFromObjectPath(path);
        if (address == null) {
            Log.e(TAG, "onSinkPropertyChanged: Address of the remote device in null");
            return;
        }

        BluetoothDevice device = mAdapter.getRemoteDevice(address);

        if (name.equals(PROPERTY_STATE)) {
            int state = convertBluezSinkStringToState(propValues[1]);
            log("A2DP: onSinkPropertyChanged newState is: " + state + "mPlayingA2dpDevice: " + mPlayingA2dpDevice);

            if (mAudioDevices.get(device) == null) {
                // This is for an incoming connection for a device not known to us.
                // We have authorized it and bluez state has changed.
                addAudioSink(device);
                handleSinkStateChange(device, BluetoothA2dp.STATE_DISCONNECTED, state);
            } else {
                if (state == BluetoothA2dp.STATE_PLAYING && mPlayingA2dpDevice == null) {
                   mPlayingA2dpDevice = device;
                   handleSinkPlayingStateChange(device, state, BluetoothA2dp.STATE_NOT_PLAYING);
                } else if (state == BluetoothA2dp.STATE_CONNECTED && mPlayingA2dpDevice != null) {
                    mPlayingA2dpDevice = null;
                    handleSinkPlayingStateChange(device, BluetoothA2dp.STATE_NOT_PLAYING,
                        BluetoothA2dp.STATE_PLAYING);
                } else {
                   mPlayingA2dpDevice = null;
                   int prevState = mAudioDevices.get(device);
                   handleSinkStateChange(device, prevState, state);
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.179 -0400", hash_original_method = "22D35051B0C9C5D9E7A4167780B44BB7", hash_generated_method = "4B09AD8736FAFB746553BC9F28A6C236")
    
private void handleSinkStateChange(BluetoothDevice device, int prevState, int state) {
        if (state != prevState) {
            mAudioDevices.put(device, state);

            checkSinkSuspendState(state);
            mTargetA2dpState = -1;

            if (getPriority(device) > BluetoothA2dp.PRIORITY_OFF &&
                    state == BluetoothA2dp.STATE_CONNECTED) {
                // We have connected or attempting to connect.
                // Bump priority
                setPriority(device, BluetoothA2dp.PRIORITY_AUTO_CONNECT);
                // We will only have 1 device with AUTO_CONNECT priority
                // To be backward compatible set everyone else to have PRIORITY_ON
                adjustOtherSinkPriorities(device);
            }

            Intent intent = new Intent(BluetoothA2dp.ACTION_CONNECTION_STATE_CHANGED);
            intent.putExtra(BluetoothDevice.EXTRA_DEVICE, device);
            intent.putExtra(BluetoothProfile.EXTRA_PREVIOUS_STATE, prevState);
            intent.putExtra(BluetoothProfile.EXTRA_STATE, state);
            intent.addFlags(Intent.FLAG_RECEIVER_REGISTERED_ONLY_BEFORE_BOOT);
            mContext.sendBroadcast(intent, BLUETOOTH_PERM);

            if (DBG) log("A2DP state : device: " + device + " State:" + prevState + "->" + state);

            mBluetoothService.sendConnectionStateChange(device, BluetoothProfile.A2DP, state,
                                                        prevState);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.181 -0400", hash_original_method = "7E6CB91A3E39FCD819A7505FAE6C0D13", hash_generated_method = "DD6864C3F7A07DF81808C0FA5112E4B9")
    
private void handleSinkPlayingStateChange(BluetoothDevice device, int state, int prevState) {
        Intent intent = new Intent(BluetoothA2dp.ACTION_PLAYING_STATE_CHANGED);
        intent.putExtra(BluetoothDevice.EXTRA_DEVICE, device);
        intent.putExtra(BluetoothProfile.EXTRA_PREVIOUS_STATE, prevState);
        intent.putExtra(BluetoothProfile.EXTRA_STATE, state);
        intent.addFlags(Intent.FLAG_RECEIVER_REGISTERED_ONLY_BEFORE_BOOT);
        mContext.sendBroadcast(intent, BLUETOOTH_PERM);

        if (DBG) log("A2DP Playing state : device: " + device + " State:" + prevState + "->" + state);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.182 -0400", hash_original_method = "9995F7BA6F946900FC4B681187802F93", hash_generated_method = "2B043B07E698D2722ECB162237A8DF88")
    
private void adjustOtherSinkPriorities(BluetoothDevice connectedDevice) {
        for (BluetoothDevice device : mAdapter.getBondedDevices()) {
            if (getPriority(device) >= BluetoothA2dp.PRIORITY_AUTO_CONNECT &&
                !device.equals(connectedDevice)) {
                setPriority(device, BluetoothA2dp.PRIORITY_ON);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.184 -0400", hash_original_method = "4FAD45E4EFD472A7B32E713CE5DD85FF", hash_generated_method = "268E299A60B2662C623CF7FBD7E490DE")
    
private boolean checkSinkSuspendState(int state) {
        boolean result = true;

        if (state != mTargetA2dpState) {
            if (state == BluetoothA2dp.STATE_PLAYING &&
                mTargetA2dpState == BluetoothA2dp.STATE_CONNECTED) {
                mAudioManager.setParameters("A2dpSuspended=true");
            } else if (state == BluetoothA2dp.STATE_CONNECTED &&
                mTargetA2dpState == BluetoothA2dp.STATE_PLAYING) {
                mAudioManager.setParameters("A2dpSuspended=false");
            } else {
                result = false;
            }
        }
        return result;
    }

    /**
     * Called by native code for the async response to a Connect
     * method call to org.bluez.AudioSink.
     *
     * @param deviceObjectPath the object path for the connecting device
     * @param result true on success; false on error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.185 -0400", hash_original_method = "35762C3193E408003672E673C0D9F75D", hash_generated_method = "60EF77F1191D52E9810BAAF7E1F86369")
    
private void onConnectSinkResult(String deviceObjectPath, boolean result) {
        // If the call was a success, ignore we will update the state
        // when we a Sink Property Change
        if (!result) {
            if (deviceObjectPath != null) {
                String address = mBluetoothService.getAddressFromObjectPath(deviceObjectPath);
                if (address == null) return;
                BluetoothDevice device = mAdapter.getRemoteDevice(address);
                int state = getConnectionState(device);
                handleSinkStateChange(device, state, BluetoothA2dp.STATE_DISCONNECTED);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.187 -0400", hash_original_method = "9DCB8DF85A5D19C9E4F0CBC772CD0C5E", hash_generated_method = "1BA20820EE0B4A588B0696D3C696F8BA")
    
@Override
    protected synchronized void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (mAudioDevices.isEmpty()) return;
        pw.println("Cached audio devices:");
        for (BluetoothDevice device : mAudioDevices.keySet()) {
            int state = mAudioDevices.get(device);
            pw.println(device + " " + BluetoothA2dp.stateToString(state));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:55.041 -0400", hash_original_method = "F316CBE5001C55DC23500428B5A4F5D7", hash_generated_method = "9E3A4C0227848E21959F39D79287D834")
    
    private boolean initNative(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:22:06.585 -0400", hash_original_method = "0C2EE552DC7F558BD6A4A53E3AFE7F2F", hash_generated_method = "98CBBA9AEDB786D020329F7CBF121502")
    
    private void cleanupNative(){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:33.198 -0400", hash_original_method = "45EC4B58B4B524F3D68AA4F5C4E76250", hash_generated_method = "CA847919F0913F00DB3C7B75158B3761")
    
    private synchronized boolean connectSinkNative(String path){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += path.getTaintInt();
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:33.201 -0400", hash_original_method = "403324192B795BCA5743A71826DA520B", hash_generated_method = "8484FA5FA0807BD3046ACEC419E65992")
    
    private synchronized boolean disconnectSinkNative(String path){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += path.getTaintInt();
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:33.205 -0400", hash_original_method = "B0E2A721781E8336DD74015E36F93AF2", hash_generated_method = "8E4F41701E019C7DD048BA612C75DE85")
    
    private synchronized boolean suspendSinkNative(String path){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += path.getTaintInt();
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:33.209 -0400", hash_original_method = "EFB7529219D3C04F81399BB83968494E", hash_generated_method = "E8329001BD409C579E631008CB15DAAA")
    
    private synchronized boolean resumeSinkNative(String path){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += path.getTaintInt();
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:33.213 -0400", hash_original_method = "EBC56FED6C650E0906D172BC3BEF88DD", hash_generated_method = "3A848EA1BC130911E7A86760BA20878E")
    
    private synchronized Object []getSinkPropertiesNative(String path){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += path.getTaintInt();
    	addTaint(taintDouble);
    
    	Object[] retObj = new Object[1]; 
    	retObj[0] = new Object(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:33.216 -0400", hash_original_method = "6C4F9CEFD4C3CF75AABC69FD3AA8F07B", hash_generated_method = "7861A410F9CA56714AE1D961E1751F8F")
    
    private synchronized boolean avrcpVolumeUpNative(String path){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += path.getTaintInt();
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:33.220 -0400", hash_original_method = "9BA8689E3938B2DF476597636059B0E6", hash_generated_method = "DEF3A7DB947CF8B54A0ED0C8E709DDE1")
    
    private synchronized boolean avrcpVolumeDownNative(String path){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += path.getTaintInt();
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

}
