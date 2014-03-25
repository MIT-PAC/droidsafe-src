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
import android.bluetooth.BluetoothPan;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothTetheringDataTracker;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources.NotFoundException;
import android.net.ConnectivityManager;
import android.net.InterfaceConfiguration;
import android.net.LinkAddress;
import android.net.NetworkUtils;
import android.os.IBinder;
import android.os.INetworkManagementService;
import android.os.ServiceManager;
import android.util.Log;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This handles the PAN profile. All calls into this are made
 * from Bluetooth Service.
 */
final class BluetoothPanProfileHandler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.869 -0400", hash_original_field = "B41AA8BBAB0A31C67362D347BCBD7081", hash_generated_field = "46E393E0F043A726DAA1279D24461EA1")

    private static final String TAG = "BluetoothPanProfileHandler";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.871 -0400", hash_original_field = "95D5733A0C83DB3D047D109C028C9F02", hash_generated_field = "B7707D757F0604821CCAF673B2122320")

    private static final boolean DBG = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.875 -0400", hash_original_field = "6254B103ED7B73E3EE50A192BD073235", hash_generated_field = "2C57441CB5A2AB4959CA44D5F0097A38")


    private static final String BLUETOOTH_IFACE_ADDR_START= "192.168.44.1";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.877 -0400", hash_original_field = "A6E33D06E79FB290E30A018926FFD260", hash_generated_field = "0E312BF9D0FAD7ACDAC654AB99AEA7F8")

    private static final int BLUETOOTH_MAX_PAN_CONNECTIONS = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.879 -0400", hash_original_field = "D58B488B1512A0C5975405C5BD661585", hash_generated_field = "75289E6B2A67F8177290BBD2A6F3CE19")

    private static final int BLUETOOTH_PREFIX_LENGTH        = 24;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.880 -0400", hash_original_field = "8F852D108D0B73029A8EC7C9CC4B3318", hash_generated_field = "A19E4FC57D2CDA0646B934A85E1E00DD")

    public static BluetoothPanProfileHandler sInstance;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.887 -0400", hash_original_field = "1201EA0A5C26E294772A8D8031088160", hash_generated_field = "97FF8B816D0735447ECA0C6E20BE1B61")


    static final String NAP_ROLE = "nap";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.889 -0400", hash_original_field = "6DB7BB034579DCA1702B7EFB53EAFC8B", hash_generated_field = "226A49F431EB09A7FE8C6BC716F8AD83")

    static final String NAP_BRIDGE = "pan1";

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.892 -0400", hash_original_method = "709C2A3D27632C3AD0646F50A18C2055", hash_generated_method = "A5458D25ED2010ADFDD839EEA1051953")
    
static BluetoothPanProfileHandler getInstance(Context context,
            BluetoothService service) {
        if (sInstance == null) sInstance = new BluetoothPanProfileHandler(context, service);
        return sInstance;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.930 -0400", hash_original_method = "198FF8846FA6C21954F84020AE8A31D6", hash_generated_method = "E6E4574714108E96E15EB307746600A7")
    
private static void debugLog(String msg) {
        if (DBG) Log.d(TAG, msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.931 -0400", hash_original_method = "D4FCA64A38143A057032C84AEB0CCC08", hash_generated_method = "0995AC3DE785146A6BF1B3D6FD12D8F2")
    
private static void errorLog(String msg) {
        Log.e(TAG, msg);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.872 -0400", hash_original_field = "A4C3E646C2A6FECF2202E07E8213857B", hash_generated_field = "E52F21351C7EA38030898B7756B1D70D")


    private ArrayList<String> mBluetoothIfaceAddresses;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.874 -0400", hash_original_field = "729E2F24228B5EEC82A58EE37B03DD21", hash_generated_field = "3C1DA11C12EAA1DE852CCDBE7C7484D9")

    private int mMaxPanDevices;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.882 -0400", hash_original_field = "6DEACDE96405BD72EC5E22C291DE02DA", hash_generated_field = "BEC9679A6087DB0237E4A6CF8DC30F45")

    private  HashMap<BluetoothDevice, BluetoothPanDevice> mPanDevices;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.883 -0400", hash_original_field = "58C00915F395EC500939E84EEA4EDF02", hash_generated_field = "0F2CC7040187ACD72BA9ADB4942338A0")

    private boolean mTetheringOn;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.884 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.886 -0400", hash_original_field = "A159F05F3527228E8E398101D1BCF02A", hash_generated_field = "63FC39FA8AD5AA0E0E655FCBD5956634")

    private BluetoothService mBluetoothService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.897 -0400", hash_original_field = "0E05EB023B6F85CF3D55DD13272E5254", hash_generated_field = "D5237360F9560F660B8794F23E978DD5")


    private BroadcastReceiver mTetheringReceiver = null;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.890 -0400", hash_original_method = "F1810FEAD9A295F628567F9D831DC147", hash_generated_method = "10FD259101B482E78E50FE6DCC705B2C")
    
private BluetoothPanProfileHandler(Context context, BluetoothService service) {
        mContext = context;
        mPanDevices = new HashMap<BluetoothDevice, BluetoothPanDevice>();
        mBluetoothService = service;
        mTetheringOn = false;
        mBluetoothIfaceAddresses = new ArrayList<String>();
        try {
            mMaxPanDevices = context.getResources().getInteger(
                            com.android.internal.R.integer.config_max_pan_devices);
        } catch (NotFoundException e) {
            mMaxPanDevices = BLUETOOTH_MAX_PAN_CONNECTIONS;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.893 -0400", hash_original_method = "D82CAC82B3FCC1531E41E074180C9B66", hash_generated_method = "D82CAC82B3FCC1531E41E074180C9B66")
    
boolean isTetheringOn() {
        return mTetheringOn;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.895 -0400", hash_original_method = "7CA222D4CE814404EF6E31632BE84187", hash_generated_method = "7CA222D4CE814404EF6E31632BE84187")
    
boolean allowIncomingTethering() {
        if (isTetheringOn() && getConnectedPanDevices().size() < mMaxPanDevices)
            return true;
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.900 -0400", hash_original_method = "B33EB88C39129A8C8BBE153EB0228B53", hash_generated_method = "B33EB88C39129A8C8BBE153EB0228B53")
    
void setBluetoothTethering(boolean value) {
        if (!value) {
            disconnectPanServerDevices();
        }

        if (mBluetoothService.getBluetoothState() != BluetoothAdapter.STATE_ON && value) {
            IntentFilter filter = new IntentFilter();
            filter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED);
            mTetheringReceiver = new BroadcastReceiver() {
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 13:07:00.227 -0400", hash_original_method = "C0881F92DF0EF2C3C920F90206EB3D5F", hash_generated_method = "FCAE48DDAD7D37768C77C5BADD83BECD")
                
@Override
                public void onReceive(Context context, Intent intent) {
                    if (intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.STATE_OFF)
                            == BluetoothAdapter.STATE_ON) {
                        mTetheringOn = true;
                        mContext.unregisterReceiver(mTetheringReceiver);
                    }
                }
            };
            mContext.registerReceiver(mTetheringReceiver, filter);
        } else {
            mTetheringOn = value;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.904 -0400", hash_original_method = "93C4EE49FF10D2E1C31F2304E68870DE", hash_generated_method = "93C4EE49FF10D2E1C31F2304E68870DE")
    
int getPanDeviceConnectionState(BluetoothDevice device) {
        BluetoothPanDevice panDevice = mPanDevices.get(device);
        if (panDevice == null) {
            return BluetoothPan.STATE_DISCONNECTED;
        }
        return panDevice.mState;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.906 -0400", hash_original_method = "20B33B773B16E8309620A05BCECE727F", hash_generated_method = "56B0C86DCFA1646B3AE2DC03F3A89176")
    
boolean connectPanDevice(BluetoothDevice device) {
        String objectPath = mBluetoothService.getObjectPathFromAddress(device.getAddress());
        if (DBG) Log.d(TAG, "connect PAN(" + objectPath + ")");
        if (getPanDeviceConnectionState(device) != BluetoothPan.STATE_DISCONNECTED) {
            errorLog(device + " already connected to PAN");
        }

        int connectedCount = 0;
        for (BluetoothDevice panDevice: mPanDevices.keySet()) {
            if (getPanDeviceConnectionState(panDevice) == BluetoothPan.STATE_CONNECTED) {
                connectedCount ++;
            }
        }
        if (connectedCount > 8) {
            debugLog(device + " could not connect to PAN because 8 other devices are"
                    + "already connected");
            return false;
        }

        // Send interface as null as it is not known
        handlePanDeviceStateChange(device, null, BluetoothPan.STATE_CONNECTING,
                                           BluetoothPan.LOCAL_PANU_ROLE);
        if (mBluetoothService.connectPanDeviceNative(objectPath, "nap")) {
            debugLog("connecting to PAN");
            return true;
        } else {
            handlePanDeviceStateChange(device, null, BluetoothPan.STATE_DISCONNECTED,
                                                BluetoothPan.LOCAL_PANU_ROLE);
            errorLog("could not connect to PAN");
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.907 -0400", hash_original_method = "4F2746933B678B0CBD0FC2A3AE00A165", hash_generated_method = "E100C4C3EC6513AC53DC87B46862A971")
    
private boolean disconnectPanServerDevices() {
        debugLog("disconnect all PAN devices");

        for (BluetoothDevice device: mPanDevices.keySet()) {
            BluetoothPanDevice panDevice = mPanDevices.get(device);
            int state = panDevice.mState;
            if (state == BluetoothPan.STATE_CONNECTED &&
                    panDevice.mLocalRole == BluetoothPan.LOCAL_NAP_ROLE) {
                String objectPath = mBluetoothService.getObjectPathFromAddress(device.getAddress());

                handlePanDeviceStateChange(device, panDevice.mIface,
                        BluetoothPan.STATE_DISCONNECTING, panDevice.mLocalRole);

                if (!mBluetoothService.disconnectPanServerDeviceNative(objectPath,
                        device.getAddress(),
                        panDevice.mIface)) {
                    errorLog("could not disconnect Pan Server Device "+device.getAddress());

                    // Restore prev state
                    handlePanDeviceStateChange(device, panDevice.mIface, state,
                            panDevice.mLocalRole);

                    return false;
                }
            }
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.909 -0400", hash_original_method = "DB31C61FAC40B4E210E1A81634F5F8E0", hash_generated_method = "DB31C61FAC40B4E210E1A81634F5F8E0")
    
List<BluetoothDevice> getConnectedPanDevices() {
        List<BluetoothDevice> devices = new ArrayList<BluetoothDevice>();

        for (BluetoothDevice device: mPanDevices.keySet()) {
            if (getPanDeviceConnectionState(device) == BluetoothPan.STATE_CONNECTED) {
                devices.add(device);
            }
        }
        return devices;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.910 -0400", hash_original_method = "35ED3E606EBAA033A9A877C9CA49B36D", hash_generated_method = "35ED3E606EBAA033A9A877C9CA49B36D")
    
List<BluetoothDevice> getPanDevicesMatchingConnectionStates(int[] states) {
        List<BluetoothDevice> devices = new ArrayList<BluetoothDevice>();

        for (BluetoothDevice device: mPanDevices.keySet()) {
            int panDeviceState = getPanDeviceConnectionState(device);
            for (int state : states) {
                if (state == panDeviceState) {
                    devices.add(device);
                    break;
                }
            }
        }
        return devices;
    }

    private class BluetoothPanDevice {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.917 -0400", hash_original_field = "7BB479D2050B776CF48FB8B4E674911B", hash_generated_field = "19B55F2750B971E6310D64ADB9B2D0CF")

        private int mState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.919 -0400", hash_original_field = "7142B08394B829F79588EB59CCE9937E", hash_generated_field = "4E1F681B6B087D5959F3CB8B5E380502")

        private String mIfaceAddr;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.920 -0400", hash_original_field = "C6509AE7C2783D6AD6BC51D8BEE05945", hash_generated_field = "127185F274A11BAE9BF707651C68AFE0")

        private String mIface;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.921 -0400", hash_original_field = "1B8F37A2AB89A5CC746ADEC35798367F", hash_generated_field = "ECA33C33D7382267581F57C7E993B8DB")

        private int mLocalRole; // Which local role is this PAN device bound to

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.923 -0400", hash_original_method = "9665B58DF2A5F14F08E41404CBEF0D6F", hash_generated_method = "9665B58DF2A5F14F08E41404CBEF0D6F")
        
BluetoothPanDevice(int state, String ifaceAddr, String iface, int localRole) {
            mState = state;
            mIfaceAddr = ifaceAddr;
            mIface = iface;
            mLocalRole = localRole;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.912 -0400", hash_original_method = "14654B0AA2765A4C05957CF084668652", hash_generated_method = "03EB311CD8BD347F682B9F010D944CF0")
    
boolean disconnectPanDevice(BluetoothDevice device) {
        String objectPath = mBluetoothService.getObjectPathFromAddress(device.getAddress());
        debugLog("disconnect PAN(" + objectPath + ")");

        int state = getPanDeviceConnectionState(device);
        if (state != BluetoothPan.STATE_CONNECTED) {
            debugLog(device + " already disconnected from PAN");
            return false;
        }

        BluetoothPanDevice panDevice = mPanDevices.get(device);

        if (panDevice == null) {
            errorLog("No record for this Pan device:" + device);
            return false;
        }

        handlePanDeviceStateChange(device, panDevice.mIface, BluetoothPan.STATE_DISCONNECTING,
                                    panDevice.mLocalRole);
        if (panDevice.mLocalRole == BluetoothPan.LOCAL_NAP_ROLE) {
            if (!mBluetoothService.disconnectPanServerDeviceNative(objectPath, device.getAddress(),
                    panDevice.mIface)) {
                // Restore prev state, this shouldn't happen
                handlePanDeviceStateChange(device, panDevice.mIface, state, panDevice.mLocalRole);
                return false;
            }
        } else {
            if (!mBluetoothService.disconnectPanDeviceNative(objectPath)) {
                // Restore prev state, this shouldn't happen
                handlePanDeviceStateChange(device, panDevice.mIface, state, panDevice.mLocalRole);
                return false;
            }
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.915 -0400", hash_original_method = "FD78B66C061F5A95405773491ABB092F", hash_generated_method = "AE41DC1F5F772BDD164D03A1AD2CB30B")
    
void handlePanDeviceStateChange(BluetoothDevice device,
                                                 String iface, int state, int role) {
        int prevState;
        String ifaceAddr = null;
        BluetoothPanDevice panDevice = mPanDevices.get(device);

        if (panDevice == null) {
            prevState = BluetoothPan.STATE_DISCONNECTED;
        } else {
            prevState = panDevice.mState;
            ifaceAddr = panDevice.mIfaceAddr;
        }
        if (prevState == state) return;

        if (role == BluetoothPan.LOCAL_NAP_ROLE) {
            if (state == BluetoothPan.STATE_CONNECTED) {
                ifaceAddr = enableTethering(iface);
                if (ifaceAddr == null) Log.e(TAG, "Error seting up tether interface");
            } else if (state == BluetoothPan.STATE_DISCONNECTED) {
                if (ifaceAddr != null) {
                    mBluetoothIfaceAddresses.remove(ifaceAddr);
                    ifaceAddr = null;
                }
            }
        } else {
            // PANU Role = reverse Tether
            if (state == BluetoothPan.STATE_CONNECTED) {
                BluetoothTetheringDataTracker.getInstance().startReverseTether(iface, device);
            } else if (state == BluetoothPan.STATE_DISCONNECTED &&
                  (prevState == BluetoothPan.STATE_CONNECTED ||
                  prevState == BluetoothPan.STATE_DISCONNECTING)) {
                BluetoothTetheringDataTracker.getInstance().stopReverseTether(panDevice.mIface);
            }
        }

        if (panDevice == null) {
            panDevice = new BluetoothPanDevice(state, ifaceAddr, iface, role);
            mPanDevices.put(device, panDevice);
        } else {
            panDevice.mState = state;
            panDevice.mIfaceAddr = ifaceAddr;
            panDevice.mLocalRole = role;
            panDevice.mIface = iface;
        }

        Intent intent = new Intent(BluetoothPan.ACTION_CONNECTION_STATE_CHANGED);
        intent.putExtra(BluetoothDevice.EXTRA_DEVICE, device);
        intent.putExtra(BluetoothPan.EXTRA_PREVIOUS_STATE, prevState);
        intent.putExtra(BluetoothPan.EXTRA_STATE, state);
        intent.putExtra(BluetoothPan.EXTRA_LOCAL_ROLE, role);
        mContext.sendBroadcast(intent, BluetoothService.BLUETOOTH_PERM);

        debugLog("Pan Device state : device: " + device + " State:" + prevState + "->" + state);
        mBluetoothService.sendConnectionStateChange(device, BluetoothProfile.PAN, state,
                                                    prevState);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.925 -0400", hash_original_method = "C8FABD424EABD0D305425AFBD8910224", hash_generated_method = "8B2B1323C3A49B742EC97F8481DDE2A5")
    
private String createNewTetheringAddressLocked() {
        if (getConnectedPanDevices().size() == mMaxPanDevices) {
            debugLog ("Max PAN device connections reached");
            return null;
        }
        String address = BLUETOOTH_IFACE_ADDR_START;
        while (true) {
            if (mBluetoothIfaceAddresses.contains(address)) {
                String[] addr = address.split("\\.");
                Integer newIp = Integer.parseInt(addr[2]) + 1;
                address = address.replace(addr[2], newIp.toString());
            } else {
                break;
            }
        }
        mBluetoothIfaceAddresses.add(address);
        return address;
    }

    // configured when we start tethering
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.928 -0400", hash_original_method = "B852D1EA4E9FE040D2A9FBF4508129E0", hash_generated_method = "174C7B3FB58CAAFD9DD80ECE0ADBE85F")
    
private String enableTethering(String iface) {
        debugLog("updateTetherState:" + iface);

        IBinder b = ServiceManager.getService(Context.NETWORKMANAGEMENT_SERVICE);
        INetworkManagementService service = INetworkManagementService.Stub.asInterface(b);
        ConnectivityManager cm =
            (ConnectivityManager)mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        String[] bluetoothRegexs = cm.getTetherableBluetoothRegexs();

        // bring toggle the interfaces
        String[] currentIfaces = new String[0];
        try {
            currentIfaces = service.listInterfaces();
        } catch (Exception e) {
            Log.e(TAG, "Error listing Interfaces :" + e);
            return null;
        }

        boolean found = false;
        for (String currIface: currentIfaces) {
            if (currIface.equals(iface)) {
                found = true;
                break;
            }
        }

        if (!found) return null;

        String address = createNewTetheringAddressLocked();
        if (address == null) return null;

        InterfaceConfiguration ifcg = null;
        try {
            ifcg = service.getInterfaceConfig(iface);
            if (ifcg != null) {
                InetAddress addr = null;
                if (ifcg.addr == null || (addr = ifcg.addr.getAddress()) == null ||
                        addr.equals(NetworkUtils.numericToInetAddress("0.0.0.0")) ||
                        addr.equals(NetworkUtils.numericToInetAddress("::0"))) {
                    addr = NetworkUtils.numericToInetAddress(address);
                }
                ifcg.interfaceFlags = ifcg.interfaceFlags.replace("down", "up");
                ifcg.addr = new LinkAddress(addr, BLUETOOTH_PREFIX_LENGTH);
                ifcg.interfaceFlags = ifcg.interfaceFlags.replace("running", "");
                ifcg.interfaceFlags = ifcg.interfaceFlags.replace("  "," ");
                service.setInterfaceConfig(iface, ifcg);
                if (cm.tether(iface) != ConnectivityManager.TETHER_ERROR_NO_ERROR) {
                    Log.e(TAG, "Error tethering "+iface);
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "Error configuring interface " + iface + ", :" + e);
            return null;
        }
        return address;
    }
}
