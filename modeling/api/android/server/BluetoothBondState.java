/*
 * Copyright (C) 2010 The Android Open Source Project
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
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothHeadset;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Local cache of bonding state.
 * We keep our own state to track the intermediate state BONDING, which
 * bluez does not track.
 * All addresses must be passed in upper case.
 */
class BluetoothBondState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.119 -0400", hash_original_field = "FF1DC4E4EA4B086F0961EFA7F21C72A8", hash_generated_field = "B39E504321AFC66CE23D325B2D8DDA42")

    private static final String TAG = "BluetoothBondState";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.121 -0400", hash_original_field = "95D5733A0C83DB3D047D109C028C9F02", hash_generated_field = "B7707D757F0604821CCAF673B2122320")

    private static final boolean DBG =  true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.126 -0400", hash_original_field = "6D7D7F010631056E83C11288FE41502F", hash_generated_field = "0D8CC88DEE9EF87BCB35F225727D2627")

    private static final String AUTO_PAIRING_BLACKLIST =
        "/etc/bluetooth/auto_pairing.conf";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.128 -0400", hash_original_field = "B28E588B3175EF0409A346EC51315D4E", hash_generated_field = "FD2CD899104E423ACFB071886EB4D26C")

    private static final String DYNAMIC_AUTO_PAIRING_BLACKLIST =
        "/data/misc/bluetooth/dynamic_auto_pairing.conf";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.122 -0400", hash_original_field = "21235DECD7F9A92C205DD8DCA9F877C4", hash_generated_field = "73644BB726E52AA697268FC7CEC0BF85")

    private final HashMap<String, Integer> mState = new HashMap<String, Integer>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.124 -0400", hash_original_field = "D2EBE71A67020D1D3140B1C017712995", hash_generated_field = "FCBB4281F8D1DACBFF4827A777E703BB")

    private final HashMap<String, Integer> mPinAttempt = new HashMap<String, Integer>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.130 -0400", hash_original_field = "B847E43F62ADEB298D7F76F797D9CC9C", hash_generated_field = "62FA8DBEE7EF6936CEA572C10FA03E8E")

    private ArrayList<String> mAutoPairingAddressBlacklist;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.131 -0400", hash_original_field = "6B25BF0F2DB34B1533A05FF46B39CAEE", hash_generated_field = "35CAC25BC3691093D6DF4B60A1A58954")

    private ArrayList<String> mAutoPairingExactNameBlacklist;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.132 -0400", hash_original_field = "F76F72591AD065DF6B4F2CE61482503D", hash_generated_field = "FD79198ED8B0C268728E255294B60DB7")

    private ArrayList<String> mAutoPairingPartialNameBlacklist;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.134 -0400", hash_original_field = "3DBB4AA077779F291621937B95EBAF6D", hash_generated_field = "666AD203AB5E8DD7398537698F89CC27")

    private ArrayList<String> mAutoPairingFixedPinZerosKeyboardList;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.135 -0400", hash_original_field = "9838F25EDEBBFEFD943BF25251A16C35", hash_generated_field = "9D8E9A5ABB75B42A3218EC92827F81C3")

    private ArrayList<String> mAutoPairingDynamicAddressBlacklist;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.137 -0400", hash_original_field = "F749C47E512EC3B13C8700E54BE967A4", hash_generated_field = "53B613FBD61A2EFDC2152BAFBD5A4DF4")

    // There can be only 1 pending outgoing connection at a time,
    private String mPendingOutgoingBonding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.138 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.140 -0400", hash_original_field = "F41AE71D622FDCA6BB622192685F5E5F", hash_generated_field = "595579B9977CA2238E14150EEB2A2C75")

    private  BluetoothService mService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.141 -0400", hash_original_field = "E35403EE236DCCE0720A7916BBAC2C85", hash_generated_field = "02ED791EDF88A1FB05F66AB5EE089C6B")

    private  BluetoothInputProfileHandler mBluetoothInputProfileHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.143 -0400", hash_original_field = "EF9CEF65745E1308B575992B1E896C56", hash_generated_field = "BDB436AB63AE277A871F2A0049C5489B")

    private BluetoothA2dp mA2dpProxy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.145 -0400", hash_original_field = "B12448165C705929FA038D4644E12756", hash_generated_field = "F735A7E801D81CE291F19EA12CAD7B0B")

    private BluetoothHeadset mHeadsetProxy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.146 -0400", hash_original_field = "D52EF7A4CBCE49886058F9895D27C71A", hash_generated_field = "E90139B29AAC268687A6AEABB80DD0D5")

    private ArrayList<String> mPairingRequestRcvd = new ArrayList<String>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.182 -0400", hash_original_field = "021CBF4F2D237B2EEEA6A42F846BC6E6", hash_generated_field = "A4167D8242753F5B784AFBAB84117075")

    private BluetoothProfile.ServiceListener mProfileServiceListener =
        new BluetoothProfile.ServiceListener() {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 13:06:58.349 -0400", hash_original_method = "568892CAF500A3F51A8C11856EE82806", hash_generated_method = "94EFA3BB5D88F77FE720BF172FD83A07")
        
public void onServiceConnected(int profile, BluetoothProfile proxy) {
            if (profile == BluetoothProfile.A2DP) {
                mA2dpProxy = (BluetoothA2dp) proxy;
            } else if (profile == BluetoothProfile.HEADSET) {
                mHeadsetProxy = (BluetoothHeadset) proxy;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 13:06:58.350 -0400", hash_original_method = "9D9F1B01777BFE86514ECB37BE80E2D4", hash_generated_method = "D8832908C52F903FD0F638ED3FDEA8EA")
        
public void onServiceDisconnected(int profile) {
            if (profile == BluetoothProfile.A2DP) {
                mA2dpProxy = null;
            } else if (profile == BluetoothProfile.HEADSET) {
                mHeadsetProxy = null;
            }
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.195 -0400", hash_original_field = "FF9A4390D5625A0008601F53F381725C", hash_generated_field = "F04B1EE2070DD146C4BB5FC6DB5D040A")

    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 13:06:58.364 -0400", hash_original_method = "6969750B14C95448E32F6DB2A6E5405F", hash_generated_method = "BF693971777EE15E594D835F502E1B4A")
        
@Override
        public void onReceive(Context context, Intent intent) {
            if (intent == null) return;

            String action = intent.getAction();
            if (action.equals(BluetoothDevice.ACTION_PAIRING_REQUEST)) {
                BluetoothDevice dev = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                String address = dev.getAddress();
                mPairingRequestRcvd.add(address);
            }
        }
    };

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.148 -0400", hash_original_method = "1FCE5BC20E8FF21999C46335890215D1", hash_generated_method = "1FCE5BC20E8FF21999C46335890215D1")
    
BluetoothBondState(Context context, BluetoothService service) {
        mContext = context;
        mService = service;
        mBluetoothInputProfileHandler =
            BluetoothInputProfileHandler.getInstance(mContext, mService);

        IntentFilter filter = new IntentFilter();
        filter.addAction(BluetoothDevice.ACTION_PAIRING_REQUEST);
        mContext.registerReceiver(mReceiver, filter);
        readAutoPairingData();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.149 -0400", hash_original_method = "44BF909E592CB52C581B119C81152521", hash_generated_method = "E07EC84BFE6065AC7572F08D8F1F8873")
    
synchronized void setPendingOutgoingBonding(String address) {
        mPendingOutgoingBonding = address;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.150 -0400", hash_original_method = "F5B324070BB2657E2D1C044A9FB833B2", hash_generated_method = "1CFF8F9AFCBC516997BBE10579FEED63")
    
public synchronized String getPendingOutgoingBonding() {
        return mPendingOutgoingBonding;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.152 -0400", hash_original_method = "153D4198978311C9C1EE43BF8D365CC7", hash_generated_method = "FF135E787291A87B1AD629F61052E27A")
    
public synchronized void initBondState() {
        getProfileProxy();
        loadBondState();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.154 -0400", hash_original_method = "D56697E41EA8595E0DB3FC40038CA0DE", hash_generated_method = "3142C2B3358F7427A87B3F4E80FAA205")
    
private void loadBondState() {
        if (mService.getBluetoothStateInternal() !=
                BluetoothAdapter.STATE_TURNING_ON) {
            return;
        }
        String val = mService.getAdapterProperties().getProperty("Devices");
        if (val == null) {
            return;
        }
        String[] bonds = val.split(",");
        if (bonds == null) {
            return;
        }
        mState.clear();
        if (DBG) Log.d(TAG, "found " + bonds.length + " bonded devices");
        for (String device : bonds) {
            mState.put(mService.getAddressFromObjectPath(device).toUpperCase(),
                    BluetoothDevice.BOND_BONDED);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.155 -0400", hash_original_method = "BEE5660B4E5D8FE0EF421A992AF4DAC9", hash_generated_method = "9923D4146284F98B7F84BF103325FA1E")
    
public synchronized void setBondState(String address, int state) {
        setBondState(address, state, 0);
    }

    /** reason is ignored unless state == BOND_NOT_BONDED */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.157 -0400", hash_original_method = "D112CA8575603B88E8151974EBF63509", hash_generated_method = "7BE8A2C98FA0F35048094228C4E1F308")
    
public synchronized void setBondState(String address, int state, int reason) {
        if (DBG) Log.d(TAG, "setBondState " + "address" + " " + state + "reason: " + reason);

        int oldState = getBondState(address);
        if (oldState == state) {
            return;
        }

        // Check if this was an pending outgoing bonding.
        // If yes, reset the state.
        if (oldState == BluetoothDevice.BOND_BONDING) {
            if (address.equals(mPendingOutgoingBonding)) {
                mPendingOutgoingBonding = null;
            }
        }

        if (state == BluetoothDevice.BOND_BONDED) {
            boolean setTrust = false;
            if (mPairingRequestRcvd.contains(address)) setTrust = true;

            mService.addProfileState(address, setTrust);
            mPairingRequestRcvd.remove(address);

        } else if (state == BluetoothDevice.BOND_BONDING) {
            if (mA2dpProxy == null || mHeadsetProxy == null) {
                getProfileProxy();
            }
        } else if (state == BluetoothDevice.BOND_NONE) {
            mPairingRequestRcvd.remove(address);
        }

        setProfilePriorities(address, state);

        if (DBG) {
            Log.d(TAG, address + " bond state " + oldState + " -> " + state
                + " (" + reason + ")");
        }
        Intent intent = new Intent(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        intent.putExtra(BluetoothDevice.EXTRA_DEVICE, mService.getRemoteDevice(address));
        intent.putExtra(BluetoothDevice.EXTRA_BOND_STATE, state);
        intent.putExtra(BluetoothDevice.EXTRA_PREVIOUS_BOND_STATE, oldState);
        if (state == BluetoothDevice.BOND_NONE) {
            if (reason <= 0) {
                Log.w(TAG, "setBondState() called to unbond device, but reason code is " +
                      "invalid. Overriding reason code with BOND_RESULT_REMOVED");
                reason = BluetoothDevice.UNBOND_REASON_REMOVED;
            }
            intent.putExtra(BluetoothDevice.EXTRA_REASON, reason);
            mState.remove(address);
        } else {
            mState.put(address, state);
        }

        mContext.sendBroadcast(intent, BluetoothService.BLUETOOTH_PERM);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.159 -0400", hash_original_method = "8B2F29983B69A1E0C5DAC3A65B6B0A03", hash_generated_method = "C6B651C84399D2613022A66648488008")
    
public boolean isAutoPairingBlacklisted(String address) {
        if (mAutoPairingAddressBlacklist != null) {
            for (String blacklistAddress : mAutoPairingAddressBlacklist) {
                if (address.startsWith(blacklistAddress)) return true;
            }
        }

        if (mAutoPairingDynamicAddressBlacklist != null) {
            for (String blacklistAddress: mAutoPairingDynamicAddressBlacklist) {
                if (address.equals(blacklistAddress)) return true;
            }
        }

        String name = mService.getRemoteName(address);
        if (name != null) {
            if (mAutoPairingExactNameBlacklist != null) {
                for (String blacklistName : mAutoPairingExactNameBlacklist) {
                    if (name.equals(blacklistName)) return true;
                }
            }

            if (mAutoPairingPartialNameBlacklist != null) {
                for (String blacklistName : mAutoPairingPartialNameBlacklist) {
                    if (name.startsWith(blacklistName)) return true;
                }
            }
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.161 -0400", hash_original_method = "AE466693EB24FEC9C183BE7A859A274B", hash_generated_method = "73A5F0BFFABF98C148FF11A9AFCB1D9B")
    
public boolean isFixedPinZerosAutoPairKeyboard(String address) {
        // Note: the meaning of blacklist is reversed in this case.
        // If its in the list, we can go ahead and auto pair since
        // by default keyboard should have a variable PIN that we don't
        // auto pair using 0000.
        if (mAutoPairingFixedPinZerosKeyboardList != null) {
            for (String blacklistAddress : mAutoPairingFixedPinZerosKeyboardList) {
                if (address.startsWith(blacklistAddress)) return true;
            }
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.162 -0400", hash_original_method = "F528DD2C168E64E5F2F76AB9E1306CAF", hash_generated_method = "BA59725E8F323D14141575BC467F3E96")
    
public synchronized int getBondState(String address) {
        Integer state = mState.get(address);
        if (state == null) {
            return BluetoothDevice.BOND_NONE;
        }
        return state.intValue();
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.163 -0400", hash_original_method = "6718FF94E651A3D32C02D9EF5EDBDD54", hash_generated_method = "490B535CBF6D4A159B283892E1238853")
    
synchronized String[] listInState(int state) {
        ArrayList<String> result = new ArrayList<String>(mState.size());
        for (Map.Entry<String, Integer> e : mState.entrySet()) {
            if (e.getValue().intValue() == state) {
                result.add(e.getKey());
            }
        }
        return result.toArray(new String[result.size()]);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.165 -0400", hash_original_method = "74430E61C7D81A60732A5CD0920C7E40", hash_generated_method = "8737E5AD80E1D44D03E57F20AD41CAA5")
    
public synchronized void addAutoPairingFailure(String address) {
        if (mAutoPairingDynamicAddressBlacklist == null) {
            mAutoPairingDynamicAddressBlacklist = new ArrayList<String>();
        }

        updateAutoPairingData(address);
        mAutoPairingDynamicAddressBlacklist.add(address);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.166 -0400", hash_original_method = "83EA6975FC200539FD713A59FA3D175C", hash_generated_method = "93BE4B42E5446106BCD84F2CD40BD5F3")
    
public synchronized boolean isAutoPairingAttemptsInProgress(String address) {
        return getAttempt(address) != 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.168 -0400", hash_original_method = "2CA09E1918D158D4700E6072351A5584", hash_generated_method = "BC12869662ABA15E24095C8AB328D698")
    
public synchronized void clearPinAttempts(String address) {
        if (DBG) Log.d(TAG, "clearPinAttempts: " + address);

        mPinAttempt.remove(address);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.170 -0400", hash_original_method = "CB588B23445716BAC23DA26219DAA479", hash_generated_method = "87599D3F36EF11AD54AE50623A59BF7C")
    
public synchronized boolean hasAutoPairingFailed(String address) {
        if (mAutoPairingDynamicAddressBlacklist == null) return false;

        return mAutoPairingDynamicAddressBlacklist.contains(address);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.171 -0400", hash_original_method = "309CA68BCE625F7D987E3202AF11A6F7", hash_generated_method = "7287DDC0EC2C96FD9A56391623E5D75B")
    
public synchronized int getAttempt(String address) {
        Integer attempt = mPinAttempt.get(address);
        if (attempt == null) {
            return 0;
        }
        return attempt.intValue();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.173 -0400", hash_original_method = "6F35FB3A9AED70436F18CC7AC87CC620", hash_generated_method = "067DFD343B3C9CD4696D853090C452FE")
    
public synchronized void attempt(String address) {
        Integer attempt = mPinAttempt.get(address);
        int newAttempt;
        if (attempt == null) {
            newAttempt = 1;
        } else {
            newAttempt = attempt.intValue() + 1;
        }
        if (DBG) Log.d(TAG, "attemp newAttempt: " + newAttempt);

        mPinAttempt.put(address, new Integer(newAttempt));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.175 -0400", hash_original_method = "D97B5A4A8452F1E474DAA58748AA9A60", hash_generated_method = "520BD203CD0B9493ED1FE621AA8C10DE")
    
private void getProfileProxy() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (mA2dpProxy == null) {
            bluetoothAdapter.getProfileProxy(mContext, mProfileServiceListener,
                                             BluetoothProfile.A2DP);
        }

        if (mHeadsetProxy == null) {
            bluetoothAdapter.getProfileProxy(mContext, mProfileServiceListener,
                                             BluetoothProfile.HEADSET);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.176 -0400", hash_original_method = "37761F5D162776395F53C0F3E1243C3A", hash_generated_method = "1D72C96BF383D9E88D70461E8471C564")
    
private void closeProfileProxy() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (mA2dpProxy != null) {
            bluetoothAdapter.closeProfileProxy(BluetoothProfile.A2DP, mA2dpProxy);
        }

        if (mHeadsetProxy != null) {
            bluetoothAdapter.closeProfileProxy(BluetoothProfile.HEADSET, mHeadsetProxy);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.184 -0400", hash_original_method = "9B2C1FDF8A7AA8A178A5AF7C240A6656", hash_generated_method = "592CA1FE015772CC188958AD7D68C24E")
    
private void copyAutoPairingData() {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            File file = new File(DYNAMIC_AUTO_PAIRING_BLACKLIST);
            if (file.exists()) return;

            in = new FileInputStream(AUTO_PAIRING_BLACKLIST);
            out= new FileOutputStream(DYNAMIC_AUTO_PAIRING_BLACKLIST);

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
        } catch (FileNotFoundException e) {
            Log.e(TAG, "FileNotFoundException: copyAutoPairingData " + e);
        } catch (IOException e) {
            Log.e(TAG, "IOException: copyAutoPairingData " + e);
        } finally {
             try {
                 if (in != null) in.close();
                 if (out != null) out.close();
             } catch (IOException e) {}
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.187 -0400", hash_original_method = "9C402C25F0EC1A0837CEA5A49D882A7E", hash_generated_method = "DC727B4D7ABA440A1674BF9AF94AE240")
    
synchronized public void readAutoPairingData() {
        if (mAutoPairingAddressBlacklist != null) return;
        copyAutoPairingData();
        FileInputStream fstream = null;
        try {
            fstream = new FileInputStream(DYNAMIC_AUTO_PAIRING_BLACKLIST);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader file = new BufferedReader(new InputStreamReader(in));
            String line;
            while((line = file.readLine()) != null) {
                line = line.trim();
                if (line.length() == 0 || line.startsWith("//")) continue;
                String[] value = line.split("=");
                if (value != null && value.length == 2) {
                    String[] val = value[1].split(",");
                    if (value[0].equalsIgnoreCase("AddressBlacklist")) {
                        mAutoPairingAddressBlacklist =
                            new ArrayList<String>(Arrays.asList(val));
                    } else if (value[0].equalsIgnoreCase("ExactNameBlacklist")) {
                        mAutoPairingExactNameBlacklist =
                            new ArrayList<String>(Arrays.asList(val));
                    } else if (value[0].equalsIgnoreCase("PartialNameBlacklist")) {
                        mAutoPairingPartialNameBlacklist =
                            new ArrayList<String>(Arrays.asList(val));
                    } else if (value[0].equalsIgnoreCase("FixedPinZerosKeyboardBlacklist")) {
                        mAutoPairingFixedPinZerosKeyboardList =
                            new ArrayList<String>(Arrays.asList(val));
                    } else if (value[0].equalsIgnoreCase("DynamicAddressBlacklist")) {
                        mAutoPairingDynamicAddressBlacklist =
                            new ArrayList<String>(Arrays.asList(val));
                    } else {
                        Log.e(TAG, "Error parsing Auto pairing blacklist file");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            Log.e(TAG, "FileNotFoundException: readAutoPairingData " + e);
        } catch (IOException e) {
            Log.e(TAG, "IOException: readAutoPairingData " + e);
        } finally {
            if (fstream != null) {
                try {
                    fstream.close();
                } catch (IOException e) {
                    // Ignore
                }
            }
        }
    }

    // This function adds a bluetooth address to the auto pairing blacklist
    // file. These addresses are added to DynamicAddressBlacklistSection
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.189 -0400", hash_original_method = "65074076801D2FAF9D6DFCD6B0C71820", hash_generated_method = "E3D79F6667319A7400006FFCE386E3B2")
    
private void updateAutoPairingData(String address) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(DYNAMIC_AUTO_PAIRING_BLACKLIST, true));
            StringBuilder str = new StringBuilder();
            if (mAutoPairingDynamicAddressBlacklist.size() == 0) {
                str.append("DynamicAddressBlacklist=");
            }
            str.append(address);
            str.append(",");
            out.write(str.toString());
        } catch (FileNotFoundException e) {
            Log.e(TAG, "FileNotFoundException: updateAutoPairingData " + e);
        } catch (IOException e) {
            Log.e(TAG, "IOException: updateAutoPairingData " + e);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    // Ignore
                }
            }
        }
    }

    // Set service priority of Hid, A2DP and Headset profiles depending on
    // the bond state change
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.191 -0400", hash_original_method = "8AAF63319760FA483805730B15BFA194", hash_generated_method = "B4E2FFAC6EABC468FB1E31D73F43BCAF")
    
private void setProfilePriorities(String address, int state) {
        BluetoothDevice remoteDevice = mService.getRemoteDevice(address);
        // HID is handled by BluetoothService
        mBluetoothInputProfileHandler.setInitialInputDevicePriority(remoteDevice, state);

        // Set service priority of A2DP and Headset
        // We used to do the priority change in the 2 services after the broadcast
        //   intent reach them. But that left a small time gap that could reject
        //   incoming connection due to undefined priorities.
        if (state == BluetoothDevice.BOND_BONDED) {
            if (mA2dpProxy != null &&
                  mA2dpProxy.getPriority(remoteDevice) == BluetoothProfile.PRIORITY_UNDEFINED) {
                mA2dpProxy.setPriority(remoteDevice, BluetoothProfile.PRIORITY_ON);
            }

            if (mHeadsetProxy != null &&
                  mHeadsetProxy.getPriority(remoteDevice) == BluetoothProfile.PRIORITY_UNDEFINED) {
                mHeadsetProxy.setPriority(remoteDevice, BluetoothProfile.PRIORITY_ON);
            }
        } else if (state == BluetoothDevice.BOND_NONE) {
            if (mA2dpProxy != null) {
                mA2dpProxy.setPriority(remoteDevice, BluetoothProfile.PRIORITY_UNDEFINED);
            }
            if (mHeadsetProxy != null) {
                mHeadsetProxy.setPriority(remoteDevice, BluetoothProfile.PRIORITY_UNDEFINED);
            }
        }

        if (mA2dpProxy == null || mHeadsetProxy == null) {
            Log.e(TAG, "Proxy is null:" + mA2dpProxy + ":" + mHeadsetProxy);
        }
    }
}
