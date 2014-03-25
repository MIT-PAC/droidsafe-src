/*
 * Copyright (C) 2011 The Android Open Source Project
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

package android.server;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothDeviceProfileState;
import android.bluetooth.BluetoothInputDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfileState;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.provider.Settings;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This handles all the operations on the HID profile.
 * All functions are called by BluetoothService, as Bluetooth Service
 * is the Service handler for the HID profile.
 */
final class BluetoothInputProfileHandler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.600 -0400", hash_original_field = "4E1053CA8C298B061CC4822FBCE4CD31", hash_generated_field = "B20CA7B63AD3C14E06A816588E14B014")

    private static final String TAG = "BluetoothInputProfileHandler";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.601 -0400", hash_original_field = "95D5733A0C83DB3D047D109C028C9F02", hash_generated_field = "B7707D757F0604821CCAF673B2122320")

    private static final boolean DBG = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.604 -0400", hash_original_field = "95F6E7BCF5E3DD2D270DF1EFF9169EE9", hash_generated_field = "BEF3FD7314822130640AEF8607790E74")


    public static BluetoothInputProfileHandler sInstance;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.612 -0400", hash_original_method = "B0367B2433BED74CFE6B4394206BEF50", hash_generated_method = "138CE36644D31B0E861464D40AC19F6E")
    
static synchronized BluetoothInputProfileHandler getInstance(Context context,
            BluetoothService service) {
        if (sInstance == null) sInstance = new BluetoothInputProfileHandler(context, service);
        return sInstance;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.634 -0400", hash_original_method = "198FF8846FA6C21954F84020AE8A31D6", hash_generated_method = "E6E4574714108E96E15EB307746600A7")
    
private static void debugLog(String msg) {
        if (DBG) Log.d(TAG, msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.635 -0400", hash_original_method = "D4FCA64A38143A057032C84AEB0CCC08", hash_generated_method = "0995AC3DE785146A6BF1B3D6FD12D8F2")
    
private static void errorLog(String msg) {
        Log.e(TAG, msg);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.605 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.606 -0400", hash_original_field = "A159F05F3527228E8E398101D1BCF02A", hash_generated_field = "63FC39FA8AD5AA0E0E655FCBD5956634")

    private BluetoothService mBluetoothService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.608 -0400", hash_original_field = "7EA159E2F0FD4071024B9DA2EAC7D3B7", hash_generated_field = "BE81BF33E1EE93992E4C519428CCFC9D")

    private  HashMap<BluetoothDevice, Integer> mInputDevices;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.609 -0400", hash_original_field = "A082A69BCF3FFAD7C65AD4E00A0C947C", hash_generated_field = "1DB7F9808730056D7FB01FCA60658627")

    private  BluetoothProfileState mHidProfileState;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.611 -0400", hash_original_method = "56CC43FB652A882CB79EE3124328C5F0", hash_generated_method = "062D87166086086F6093D6233CDE5E5F")
    
private BluetoothInputProfileHandler(Context context, BluetoothService service) {
        mContext = context;
        mBluetoothService = service;
        mInputDevices = new HashMap<BluetoothDevice, Integer>();
        mHidProfileState = new BluetoothProfileState(mContext, BluetoothProfileState.HID);
        mHidProfileState.start();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.614 -0400", hash_original_method = "52ED57CAFB6178AC5D63AD309C859BB5", hash_generated_method = "52ED57CAFB6178AC5D63AD309C859BB5")
    
boolean connectInputDevice(BluetoothDevice device,
                                            BluetoothDeviceProfileState state) {
        String objectPath = mBluetoothService.getObjectPathFromAddress(device.getAddress());
        if (objectPath == null ||
            getInputDeviceConnectionState(device) != BluetoothInputDevice.STATE_DISCONNECTED ||
            getInputDevicePriority(device) == BluetoothInputDevice.PRIORITY_OFF) {
            return false;
        }
        if (state != null) {
            Message msg = new Message();
            msg.arg1 = BluetoothDeviceProfileState.CONNECT_HID_OUTGOING;
            msg.obj = state;
            mHidProfileState.sendMessage(msg);
            return true;
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.616 -0400", hash_original_method = "316401A316638E62B2200EE2E0647205", hash_generated_method = "316401A316638E62B2200EE2E0647205")
    
boolean connectInputDeviceInternal(BluetoothDevice device) {
        String objectPath = mBluetoothService.getObjectPathFromAddress(device.getAddress());
        handleInputDeviceStateChange(device, BluetoothInputDevice.STATE_CONNECTING);
        if (!mBluetoothService.connectInputDeviceNative(objectPath)) {
            handleInputDeviceStateChange(device, BluetoothInputDevice.STATE_DISCONNECTED);
            return false;
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.617 -0400", hash_original_method = "50B2FF43230C0A7FE6DBE64F52A28C7C", hash_generated_method = "50B2FF43230C0A7FE6DBE64F52A28C7C")
    
boolean disconnectInputDevice(BluetoothDevice device,
                                               BluetoothDeviceProfileState state) {
        String objectPath = mBluetoothService.getObjectPathFromAddress(device.getAddress());
        if (objectPath == null ||
                getInputDeviceConnectionState(device) == BluetoothInputDevice.STATE_DISCONNECTED) {
            return false;
        }
        if (state != null) {
            Message msg = new Message();
            msg.arg1 = BluetoothDeviceProfileState.DISCONNECT_HID_OUTGOING;
            msg.obj = state;
            mHidProfileState.sendMessage(msg);
            return true;
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.619 -0400", hash_original_method = "8BA98FBF465D21B36E42EB4BCC43CDA8", hash_generated_method = "8BA98FBF465D21B36E42EB4BCC43CDA8")
    
boolean disconnectInputDeviceInternal(BluetoothDevice device) {
        String objectPath = mBluetoothService.getObjectPathFromAddress(device.getAddress());
        handleInputDeviceStateChange(device, BluetoothInputDevice.STATE_DISCONNECTING);
        if (!mBluetoothService.disconnectInputDeviceNative(objectPath)) {
            handleInputDeviceStateChange(device, BluetoothInputDevice.STATE_CONNECTED);
            return false;
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.620 -0400", hash_original_method = "41AE9918BD968C3DB2FEF922763D2C63", hash_generated_method = "41AE9918BD968C3DB2FEF922763D2C63")
    
int getInputDeviceConnectionState(BluetoothDevice device) {
        if (mInputDevices.get(device) == null) {
            return BluetoothInputDevice.STATE_DISCONNECTED;
        }
        return mInputDevices.get(device);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.621 -0400", hash_original_method = "18812AEBF93FA110F900D5CE49DACE01", hash_generated_method = "18812AEBF93FA110F900D5CE49DACE01")
    
List<BluetoothDevice> getConnectedInputDevices() {
        List<BluetoothDevice> devices = lookupInputDevicesMatchingStates(
            new int[] {BluetoothInputDevice.STATE_CONNECTED});
        return devices;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.623 -0400", hash_original_method = "F06CD60E9DC6673542DF9CEA684C0FF7", hash_generated_method = "F06CD60E9DC6673542DF9CEA684C0FF7")
    
List<BluetoothDevice> getInputDevicesMatchingConnectionStates(int[] states) {
        List<BluetoothDevice> devices = lookupInputDevicesMatchingStates(states);
        return devices;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.624 -0400", hash_original_method = "17C4DC238B649328C1B25E07E2D77597", hash_generated_method = "17C4DC238B649328C1B25E07E2D77597")
    
int getInputDevicePriority(BluetoothDevice device) {
        return Settings.Secure.getInt(mContext.getContentResolver(),
                Settings.Secure.getBluetoothInputDevicePriorityKey(device.getAddress()),
                BluetoothInputDevice.PRIORITY_UNDEFINED);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.625 -0400", hash_original_method = "6801D0F1133D53AB10542B57B42F634D", hash_generated_method = "6801D0F1133D53AB10542B57B42F634D")
    
boolean setInputDevicePriority(BluetoothDevice device, int priority) {
        if (!BluetoothAdapter.checkBluetoothAddress(device.getAddress())) {
            return false;
        }
        return Settings.Secure.putInt(mContext.getContentResolver(),
                Settings.Secure.getBluetoothInputDevicePriorityKey(device.getAddress()),
                priority);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.627 -0400", hash_original_method = "CEFA8C2D1682B439C12818ED7A7A076D", hash_generated_method = "CEFA8C2D1682B439C12818ED7A7A076D")
    
List<BluetoothDevice> lookupInputDevicesMatchingStates(int[] states) {
        List<BluetoothDevice> inputDevices = new ArrayList<BluetoothDevice>();

        for (BluetoothDevice device: mInputDevices.keySet()) {
            int inputDeviceState = getInputDeviceConnectionState(device);
            for (int state : states) {
                if (state == inputDeviceState) {
                    inputDevices.add(device);
                    break;
                }
            }
        }
        return inputDevices;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.629 -0400", hash_original_method = "8D6A7C81A9E67949A6311E01072F66DA", hash_generated_method = "9DB3C6DDC1DBEAE2E6152FA55D5B45DB")
    
private void handleInputDeviceStateChange(BluetoothDevice device, int state) {
        int prevState;
        if (mInputDevices.get(device) == null) {
            prevState = BluetoothInputDevice.STATE_DISCONNECTED;
        } else {
            prevState = mInputDevices.get(device);
        }
        if (prevState == state) return;

        mInputDevices.put(device, state);

        if (getInputDevicePriority(device) >
              BluetoothInputDevice.PRIORITY_OFF &&
            state == BluetoothInputDevice.STATE_CONNECTING ||
            state == BluetoothInputDevice.STATE_CONNECTED) {
            // We have connected or attempting to connect.
            // Bump priority
            setInputDevicePriority(device, BluetoothInputDevice.PRIORITY_AUTO_CONNECT);
        }

        Intent intent = new Intent(BluetoothInputDevice.ACTION_CONNECTION_STATE_CHANGED);
        intent.putExtra(BluetoothDevice.EXTRA_DEVICE, device);
        intent.putExtra(BluetoothInputDevice.EXTRA_PREVIOUS_STATE, prevState);
        intent.putExtra(BluetoothInputDevice.EXTRA_STATE, state);
        intent.addFlags(Intent.FLAG_RECEIVER_REGISTERED_ONLY_BEFORE_BOOT);
        mContext.sendBroadcast(intent, BluetoothService.BLUETOOTH_PERM);

        debugLog("InputDevice state : device: " + device + " State:" + prevState + "->" + state);
        mBluetoothService.sendConnectionStateChange(device, BluetoothProfile.INPUT_DEVICE, state,
                                                    prevState);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.630 -0400", hash_original_method = "AB66B20CA84060FBA1B2A4CB36AFB1EA", hash_generated_method = "AB66B20CA84060FBA1B2A4CB36AFB1EA")
    
void handleInputDevicePropertyChange(String address, boolean connected) {
        int state = connected ? BluetoothInputDevice.STATE_CONNECTED :
            BluetoothInputDevice.STATE_DISCONNECTED;
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        BluetoothDevice device = adapter.getRemoteDevice(address);
        handleInputDeviceStateChange(device, state);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.632 -0400", hash_original_method = "DA5112E3FD9473A4690A94FD953A42C1", hash_generated_method = "DA5112E3FD9473A4690A94FD953A42C1")
    
void setInitialInputDevicePriority(BluetoothDevice device, int state) {
        switch (state) {
            case BluetoothDevice.BOND_BONDED:
                if (getInputDevicePriority(device) == BluetoothInputDevice.PRIORITY_UNDEFINED) {
                    setInputDevicePriority(device, BluetoothInputDevice.PRIORITY_ON);
                }
                break;
            case BluetoothDevice.BOND_NONE:
                setInputDevicePriority(device, BluetoothInputDevice.PRIORITY_UNDEFINED);
                break;
        }
    }
}
