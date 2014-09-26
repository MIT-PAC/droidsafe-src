/*
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
 * TODO: Move this to
 * java/services/com/android/server/BluetoothService.java
 * and make the contructor package private again.
 *
 * @hide
 */

package android.server;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothDeviceProfileState;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothHealthAppConfiguration;
import android.bluetooth.BluetoothInputDevice;
import android.bluetooth.BluetoothPan;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfileState;
import android.bluetooth.BluetoothSocket;
import android.bluetooth.BluetoothUuid;
import android.bluetooth.IBluetooth;
import android.bluetooth.IBluetoothCallback;
import android.bluetooth.IBluetoothHealthCallback;
import android.bluetooth.IBluetoothStateChangeCallback;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.ParcelUuid;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.provider.Settings;
import android.util.Log;
import android.util.Pair;

import com.android.internal.app.IBatteryStats;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BluetoothService extends IBluetooth.Stub {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:25.976 -0400", hash_original_field = "FD6E5157B81E208C93817B090F1561E5", hash_generated_field = "6B0034FBBAED11AEE4FC92BFAEF23902")

    private static final String TAG = "BluetoothService";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:25.978 -0400", hash_original_field = "95D5733A0C83DB3D047D109C028C9F02", hash_generated_field = "B7707D757F0604821CCAF673B2122320")

    private static final boolean DBG = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.001 -0400", hash_original_field = "4DF5D31E376F27F1ED153009F2B9E52D", hash_generated_field = "A458E8B2DE444E0F35989DFD935DFB5E")

    private static final String BLUETOOTH_ADMIN_PERM = android.Manifest.permission.BLUETOOTH_ADMIN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.003 -0400", hash_original_field = "7D77AF0882759DFB1A72C6B4C36DC3FE", hash_generated_field = "3A6AE9ED68910A5BD7F7695E524A5EC2")

    static final String BLUETOOTH_PERM = android.Manifest.permission.BLUETOOTH;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.005 -0400", hash_original_field = "B5426339E38F6EAD785FB5AD18636C49", hash_generated_field = "FF594C330CD130BC3866DF00C35C79AA")

    private static final String DOCK_ADDRESS_PATH = "/sys/class/switch/dock/bt_addr";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.007 -0400", hash_original_field = "196F5FBEBCA03F72AC0567F43855CAC1", hash_generated_field = "0D7EC825573C2A91FBDCBBC1CD486219")

    private static final String DOCK_PIN_PATH = "/sys/class/switch/dock/bt_pin";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.008 -0400", hash_original_field = "92E204FE2DEEB70B6EC22CB201BEE0A1", hash_generated_field = "B30755FB74F8EA6FA44F87467F43A818")

    private static final String SHARED_PREFERENCE_DOCK_ADDRESS = "dock_bluetooth_address";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.010 -0400", hash_original_field = "96D9AEB9B2F9E02778D18692F1811DEA", hash_generated_field = "DB89A7AFA177C684A1A4E2E5643E801F")

    private static final String SHARED_PREFERENCES_NAME = "bluetooth_service_settings";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.012 -0400", hash_original_field = "C19A4DD7E702A67E40A7E4413C3FAB23", hash_generated_field = "3F3DD211DDE84336BD88B51A21DFD6D6")

    private static final int MESSAGE_UUID_INTENT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.013 -0400", hash_original_field = "77CC57BCE4E9DC8EAEF5F808984F6C5D", hash_generated_field = "DE5E7ACA1AB6071CCA92759E01D26C33")

    private static final int MESSAGE_AUTO_PAIRING_FAILURE_ATTEMPT_DELAY = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.015 -0400", hash_original_field = "4889E9AA53888E09AFD70BFC3724078A", hash_generated_field = "44E85F0E01FBBED9069544601BCDF5DF")

    private static final int MESSAGE_REMOVE_SERVICE_RECORD = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.017 -0400", hash_original_field = "73773FE370FB97789FC03742A7F2DB27", hash_generated_field = "30AF119FA866A2E4F3A5852E1DC29307")

    private static final int RFCOMM_RECORD_REAPER = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.018 -0400", hash_original_field = "51577D8102133CE0D5B649C52CBE89F4", hash_generated_field = "DFEE02C9088C4A48F8DC82A78E85A33E")

    private static final int STATE_CHANGE_REAPER = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.020 -0400", hash_original_field = "0CF0B60427BBF9E68A04D03A0B7443E4", hash_generated_field = "C786C0B9222F6C1B3147D2988EA37AD3")

    // auto pairing attempt fails. We use an exponential delay with
    // INIT_AUTO_PAIRING_FAILURE_ATTEMPT_DELAY as the initial value and
    // MAX_AUTO_PAIRING_FAILURE_ATTEMPT_DELAY as the max value.
    private static final long INIT_AUTO_PAIRING_FAILURE_ATTEMPT_DELAY = 3000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.022 -0400", hash_original_field = "2EE14AE0DC2D3A89061C5853CAB7C7DF", hash_generated_field = "7F8C878CA1D19CC2CDB5DD122F550934")

    private static final long MAX_AUTO_PAIRING_FAILURE_ATTEMPT_DELAY = 12000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.023 -0400", hash_original_field = "A2CF1351D0BBC8071979A076012D2385", hash_generated_field = "C324C0FAAACA1449C6F3B22389724EBD")

    // This timeout should be greater than the page timeout
    private static final int UUID_INTENT_DELAY = 6000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.025 -0400", hash_original_field = "6B93B3B20E60CFC9C9DE6EFD7BAB9D77", hash_generated_field = "E9D3CD80566851EA2252D90C7F6A0C4A")

    private static final ParcelUuid[] RFCOMM_UUIDS = {
            BluetoothUuid.Handsfree,
            BluetoothUuid.HSP,
            BluetoothUuid.ObexObjectPush };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.051 -0400", hash_original_field = "268F078DD719078930238C82136509B0", hash_generated_field = "8C506375A05E53BB3751D0829D069D64")

    private static String mDockAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.060 -0400", hash_original_field = "FE2709443B5C5ECD5E5C006670D34A78", hash_generated_field = "5C84FE2FD1C695123A6FAFC4A9AB973E")

    private static final String INCOMING_CONNECTION_FILE =
      "/data/misc/bluetooth/incoming_connection.conf";

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.078 -0400", hash_original_method = "AA692B943107BD4B27D3D94B5FE90DC3", hash_generated_method = "6235148797D451ECC6C693277C351D09")
    
public static synchronized String readDockBluetoothAddress() {
        if (mDockAddress != null) return mDockAddress;

        BufferedInputStream file = null;
        String dockAddress;
        try {
            file = new BufferedInputStream(new FileInputStream(DOCK_ADDRESS_PATH));
            byte[] address = new byte[17];
            file.read(address);
            dockAddress = new String(address);
            dockAddress = dockAddress.toUpperCase();
            if (BluetoothAdapter.checkBluetoothAddress(dockAddress)) {
                mDockAddress = dockAddress;
                return mDockAddress;
            } else {
                Log.e(TAG, "CheckBluetoothAddress failed for car dock address: "
                        + dockAddress);
            }
        } catch (FileNotFoundException e) {
            Log.e(TAG, "FileNotFoundException while trying to read dock address");
        } catch (IOException e) {
            Log.e(TAG, "IOException while trying to read dock address");
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    // Ignore
                }
            }
        }
        mDockAddress = null;
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.128 -0400", hash_original_method = "8B0CB8CD05845B1967DCA3CCEDEB7361", hash_generated_method = "4A7D15B77806DDE13922241B75AA23F5")
    
private static String toBondStateString(int bondState) {
        switch (bondState) {
        case BluetoothDevice.BOND_NONE:
            return "not bonded";
        case BluetoothDevice.BOND_BONDING:
            return "bonding";
        case BluetoothDevice.BOND_BONDED:
            return "bonded";
        default:
            return "??????";
        }
    }

    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.274 -0400", hash_original_method = "B0487165CC2C3C9A2B42FA8440D1A74E", hash_generated_method = "B97A752199D7832A88284BE3EF869739")
    
static int bluezStringToScanMode(boolean pairable, boolean discoverable) {
        if (pairable && discoverable)
            return BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE;
        else if (pairable && !discoverable)
            return BluetoothAdapter.SCAN_MODE_CONNECTABLE;
        else
            return BluetoothAdapter.SCAN_MODE_NONE;
    }

    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.276 -0400", hash_original_method = "F73C7D8C70CEA30A3E833A0591370418", hash_generated_method = "DA4E6BF555D4F7C755CB9A16B7E35150")
    
static String scanModeToBluezString(int mode) {
        switch (mode) {
        case BluetoothAdapter.SCAN_MODE_NONE:
            return "off";
        case BluetoothAdapter.SCAN_MODE_CONNECTABLE:
            return "connectable";
        case BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE:
            return "discoverable";
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.376 -0400", hash_original_method = "0EBF7673E44AF610ADC3AB53A65BD597", hash_generated_method = "12E4FDCE2D2661CC6DF9F077D2C0BB73")
    
private static void log(String msg) {
        Log.d(TAG, msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.378 -0400", hash_original_method = "1D968F463EF926C42B1E3D543C8A7203", hash_generated_method = "7A97993991630071922A1DE1DEDF4D20")
    
    private static void classInitNative(){
    	//Formerly a native method
    }

@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:25.979 -0400", hash_original_field = "9D85BF891BBAC903760564D2E61B8CF8", hash_generated_field = "3541F10A37794BA2B05C956071806434")

    private int mNativeData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:25.981 -0400", hash_original_field = "29AEAD506F58EF5BD6922B133DEF064F", hash_generated_field = "A7A3F5E37FF8494C7EC414037E39E69C")

    private BluetoothEventLoop mEventLoop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:25.982 -0400", hash_original_field = "B12448165C705929FA038D4644E12756", hash_generated_field = "F735A7E801D81CE291F19EA12CAD7B0B")

    private BluetoothHeadset mHeadsetProxy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:25.983 -0400", hash_original_field = "8356224E3FD5EB3667820AC5915BD7F9", hash_generated_field = "93679EAC47A51C89470A0429DB1B2A34")

    private BluetoothInputDevice mInputDevice;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:25.985 -0400", hash_original_field = "935DD78C6D89300D6CDC2AA6A89505E5", hash_generated_field = "3A4B1C3671126FBFBD8616CF55D874F3")

    private BluetoothPan mPan;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:25.986 -0400", hash_original_field = "CB968EF38757004EE404080417F87A0F", hash_generated_field = "11743C16F3C773BB9BCEF82D6A72F317")

    private boolean mIsAirplaneSensitive;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:25.987 -0400", hash_original_field = "BA61C1DDC06E558E52EA24EFE16A3507", hash_generated_field = "B8679F4C32570F4E098E9C5C488B344A")

    private boolean mIsAirplaneToggleable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:25.989 -0400", hash_original_field = "EEF81FD2220F50269929A3F88D458D6D", hash_generated_field = "259DFB2E37783481F8B510005F863212")

    private BluetoothAdapterStateMachine mBluetoothState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:25.991 -0400", hash_original_field = "E280F422D4E17163C360255799FDD4EC", hash_generated_field = "8B0D83015216B7B595F097CCA26BE070")

    private int[] mAdapterSdpHandles;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:25.992 -0400", hash_original_field = "F61688320B58A3C7C4B2B88DF9A7903D", hash_generated_field = "6025D2FC4C5DEED74D47C4F8E796D52C")

    private ParcelUuid[] mAdapterUuids;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:25.994 -0400", hash_original_field = "367F0BC6BC216C571A7E906A286477DF", hash_generated_field = "6EAF57CC559AB78B0231BFFF469261B9")

    private BluetoothAdapter mAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:25.995 -0400", hash_original_field = "7F1DF9697AFBCEA7AB570A6F6A2C7E01", hash_generated_field = "265B9055A8DD56B3B72430A147B9B585")

    private  BluetoothBondState mBondState;

    private static class ServiceRecordClient {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.035 -0400", hash_original_field = "3D9A6B8E69012AA56F160CA7CCE3CF4F", hash_generated_field = "3D9A6B8E69012AA56F160CA7CCE3CF4F")

        int pid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.036 -0400", hash_original_field = "FC5BAA062604D7264D40DD8AC68154EA", hash_generated_field = "FC5BAA062604D7264D40DD8AC68154EA")

        IBinder binder;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.037 -0400", hash_original_field = "6250D686A5B0B68723153406E8E4EE08", hash_generated_field = "6250D686A5B0B68723153406E8E4EE08")

        IBinder.DeathRecipient death;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:25.997 -0400", hash_original_field = "B5AE98FFF1DB316C79E2D16D7E5AA79D", hash_generated_field = "4714C44227D74F6EE03A351B278EADB7")

    private  IBatteryStats mBatteryStats;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:25.998 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.000 -0400", hash_original_field = "E449131BF7FA25A22AEC2BB8C79F5E9F", hash_generated_field = "0E3F6292B32F7DFB2966C720A2498608")

    private Map<Integer, IBluetoothStateChangeCallback> mStateChangeTracker =
        Collections.synchronizedMap(new HashMap<Integer, IBluetoothStateChangeCallback>());
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.027 -0400", hash_original_field = "134A566546EEFBEF5593E75B9DD3B101", hash_generated_field = "6DF87A48A4843DF1BA444966AA1221D4")

    private  BluetoothAdapterProperties mAdapterProperties;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.028 -0400", hash_original_field = "077F66E33B614515E13E9A946C35EF90", hash_generated_field = "D2CEE7C5AB75951E3164B4453B576FD4")

    private  BluetoothDeviceProperties mDeviceProperties;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.030 -0400", hash_original_field = "989864FF014B9842052C95A18C8B419B", hash_generated_field = "4EE33B6F857E79F83B190777AFF350FB")

    private  HashMap<String, Map<ParcelUuid, Integer>> mDeviceServiceChannelCache;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.031 -0400", hash_original_field = "271EFDBF677725BB2A9DD67FE9E49AC5", hash_generated_field = "D32CCF1682F6212F1553BC44A45EC96D")

    private  ArrayList<String> mUuidIntentTracker;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.033 -0400", hash_original_field = "ED8CCA5F5655B9C61694DC32A75F2301", hash_generated_field = "44A3DFF23BE90BC55C9F86F1A07C693C")

    private  HashMap<RemoteService, IBluetoothCallback> mUuidCallbackTracker;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.040 -0400", hash_original_field = "C6205D5403BEE6AB75FB9A49BC8BD223", hash_generated_field = "2A57CA364D9DA94CE6AFE98F2E2EED9D")

    private  HashMap<Integer, ServiceRecordClient> mServiceRecordToPid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.041 -0400", hash_original_field = "1A1262D9167B59D8A868D82B04B39FC0", hash_generated_field = "D4B6EFADDFC7BE38EF114CFC012282A3")

    private  HashMap<String, BluetoothDeviceProfileState> mDeviceProfileState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.042 -0400", hash_original_field = "A7E641315F3F6F3E96C5633B7E73CF22", hash_generated_field = "CE378AB35CA942BF8277CC972B60A288")

    private  BluetoothProfileState mA2dpProfileState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.044 -0400", hash_original_field = "19A15520EA0F3D3A92C126673B9DE5EA", hash_generated_field = "E65E377528E8CF434BED9CC29F7F211E")

    private  BluetoothProfileState mHfpProfileState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.045 -0400", hash_original_field = "B5BD79CF80C7A45A3C622D6A1147302E", hash_generated_field = "21F689A0EBD699248DAD2BA6FCD0BC59")

    private BluetoothA2dpService mA2dpService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.048 -0400", hash_original_field = "6350D285F86D317EF1B48275741C273C", hash_generated_field = "9A579706D1412E5742DEA42C5D34B09D")

    private  HashMap<String, Pair<byte[], byte[]>> mDeviceOobData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.049 -0400", hash_original_field = "48B390D47ACFE8935543C6DBCFF862B0", hash_generated_field = "A4EF9117F3ABABB82F3A05CC0F749FAD")

    private int mProfilesConnected = 0, mProfilesConnecting = 0, mProfilesDisconnecting = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.052 -0400", hash_original_field = "07A4FCA72C7F2D942D2CDF13C79D5EB0", hash_generated_field = "53518AE4B99D2D78851E382A09E2C21C")

    private String mDockPin;

    private static class RemoteService {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.064 -0400", hash_original_field = "815EECE17AF4BC840D4544A9ECB9EACD", hash_generated_field = "94F51CF62708E9C4165D74975525630C")

        public String address;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.066 -0400", hash_original_field = "909B4BF5511C2B48F96F643F8DCE297C", hash_generated_field = "A5FF84663DB02D68D4452E2D3F7FE5E9")

        public ParcelUuid uuid;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.068 -0400", hash_original_method = "56D9529EB9642391F74E52B2EDB6656F", hash_generated_method = "B5F83A568071A46219FFC9B5DFB73246")
        
public RemoteService(String address, ParcelUuid uuid) {
            this.address = address;
            this.uuid = uuid;
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.069 -0400", hash_original_method = "38CF1D84AD9F571F6155D626CB58CA52", hash_generated_method = "F42F959C6E5424E19A9662D4E5765368")
        
@Override
        public boolean equals(Object o) {
            if (o instanceof RemoteService) {
                RemoteService service = (RemoteService)o;
                return address.equals(service.address) && uuid.equals(service.uuid);
            }
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.072 -0400", hash_original_method = "DC47F222F6843991F5373A34072A33A0", hash_generated_method = "9BCB80FB00F5A66EF034A29EE52B59C7")
        
@Override
        public int hashCode() {
            int hash = 1;
            hash = hash * 31 + (address == null ? 0 : address.hashCode());
            hash = hash * 31 + (uuid == null ? 0 : uuid.hashCode());
            return hash;
        }
    }

    static {
        classInitNative();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.054 -0400", hash_original_field = "89B05166EEA9FC7957826F3C8FCA006F", hash_generated_field = "DE37F13936E861E75003DE507E47D9C2")

    private int mAdapterConnectionState = BluetoothAdapter.STATE_DISCONNECTED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.055 -0400", hash_original_field = "50B759D6FE2085680A2A3193A6125D07", hash_generated_field = "5CCEEA482AEB1CE8F8923F025BE82927")

    private BluetoothPanProfileHandler mBluetoothPanProfileHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.056 -0400", hash_original_field = "E35403EE236DCCE0720A7916BBAC2C85", hash_generated_field = "02ED791EDF88A1FB05F66AB5EE089C6B")

    private BluetoothInputProfileHandler mBluetoothInputProfileHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.058 -0400", hash_original_field = "8264420325FA419CCFF7EEF82A7D4B67", hash_generated_field = "B3C03EA2AE6F878DB028E3DE8F153211")

    private BluetoothHealthProfileHandler mBluetoothHealthProfileHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.061 -0400", hash_original_field = "F8648DB8833109E86F3CB618B5E91584", hash_generated_field = "C5E7DFBC6D4C9B514524266AE36A204F")

    private HashMap<String, Pair<Integer, String>> mIncomingConnections;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.062 -0400", hash_original_field = "67E293EB40861118E52E4FA807B76490", hash_generated_field = "E87E64A13A619086D13CA4BAB876D025")

    private HashMap<Integer, Pair<Integer, Integer>> mProfileConnectionState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.110 -0400", hash_original_field = "6F42406E65E28F95F83EAE6AAE743547", hash_generated_field = "05B3B5F92AD20EE29B9B3795CA71B377")

    private final Handler mHandler = new Handler() {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 13:07:01.918 -0400", hash_original_method = "610D21BB0AF8FF2363485B937DB6A1F2", hash_generated_method = "CA74FAC5A0D078262F10D1CEE3D97F05")
        
@Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
            case MESSAGE_UUID_INTENT:
                String address = (String)msg.obj;
                if (address != null) {
                    sendUuidIntent(address);
                    makeServiceChannelCallbacks(address);
                }
                break;
            case MESSAGE_AUTO_PAIRING_FAILURE_ATTEMPT_DELAY:
                address = (String)msg.obj;
                if (address == null) return;
                int attempt = mBondState.getAttempt(address);

                // Try only if attemps are in progress and cap it 2 attempts
                // The 2 attempts cap is a fail safe if the stack returns
                // an incorrect error code for bonding failures and if the pin
                // is entered wrongly twice we should abort.
                if (attempt > 0 && attempt <= 2) {
                    mBondState.attempt(address);
                    createBond(address);
                    return;
                }
                if (attempt > 0) mBondState.clearPinAttempts(address);
                break;
            case MESSAGE_REMOVE_SERVICE_RECORD:
                Pair<Integer, Integer> pair = (Pair<Integer, Integer>) msg.obj;
                checkAndRemoveRecord(pair.first, pair.second);
                break;
            }
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.243 -0400", hash_original_field = "D47F02B595692E31C8116EC930D18C35", hash_generated_field = "F6E15F975F68F85484979D898028A0DE")

    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 13:07:02.060 -0400", hash_original_method = "8E36B9F665E2C24B0AD717C8B37C0E0E", hash_generated_method = "DC246FA7012B58132759B3BB185B2842")
        
@Override
        public void onReceive(Context context, Intent intent) {
            if (intent == null) return;

            String action = intent.getAction();
            if (action.equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
                ContentResolver resolver = context.getContentResolver();
                // Query the airplane mode from Settings.System just to make sure that
                // some random app is not sending this intent and disabling bluetooth
                if (isAirplaneModeOn()) {
                    mBluetoothState.sendMessage(BluetoothAdapterStateMachine.AIRPLANE_MODE_ON);
                } else {
                    mBluetoothState.sendMessage(BluetoothAdapterStateMachine.AIRPLANE_MODE_OFF);
                }
            } else if (Intent.ACTION_DOCK_EVENT.equals(action)) {
                int state = intent.getIntExtra(Intent.EXTRA_DOCK_STATE,
                        Intent.EXTRA_DOCK_STATE_UNDOCKED);
                if (DBG) Log.v(TAG, "Received ACTION_DOCK_EVENT with State:" + state);
                if (state == Intent.EXTRA_DOCK_STATE_UNDOCKED) {
                    mDockAddress = null;
                    mDockPin = null;
                } else {
                    SharedPreferences.Editor editor =
                        mContext.getSharedPreferences(SHARED_PREFERENCES_NAME,
                                mContext.MODE_PRIVATE).edit();
                    editor.putBoolean(SHARED_PREFERENCE_DOCK_ADDRESS + mDockAddress, true);
                    editor.apply();
                }
            }
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.273 -0400", hash_original_field = "5380C6F6C48984BACEC618319E1718F3", hash_generated_field = "58872157A495ED5DB99188FB1B3AEFD0")

    private BluetoothProfile.ServiceListener mBluetoothProfileServiceListener =
        new BluetoothProfile.ServiceListener() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 13:07:02.088 -0400", hash_original_method = "E9A9C9E9AF31DC088CF474313F325EF4", hash_generated_method = "282C14F11E0D04E25F376BD24AD23A20")
        
public void onServiceConnected(int profile, BluetoothProfile proxy) {
            if (profile == BluetoothProfile.HEADSET) {
                mHeadsetProxy = (BluetoothHeadset) proxy;
            } else if (profile == BluetoothProfile.INPUT_DEVICE) {
                mInputDevice = (BluetoothInputDevice) proxy;
            } else if (profile == BluetoothProfile.PAN) {
                mPan = (BluetoothPan) proxy;
            }
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 13:07:02.089 -0400", hash_original_method = "EDF3833457E24DFEFFAEF8C685CF5774", hash_generated_method = "95778D934FEB0818F9DE8EB98AA539BD")
        
public void onServiceDisconnected(int profile) {
            if (profile == BluetoothProfile.HEADSET) {
                mHeadsetProxy = null;
            } else if (profile == BluetoothProfile.INPUT_DEVICE) {
                mInputDevice = null;
            } else if (profile == BluetoothProfile.PAN) {
                mPan = null;
            }
        }
    };

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.075 -0400", hash_original_method = "E19EA779299A0B1539DEF4983F857750", hash_generated_method = "2BE437174CA72A42E9F39336CE1AC1E3")
    
public BluetoothService(Context context) {
        mContext = context;

        // Need to do this in place of:
        // mBatteryStats = BatteryStatsService.getService();
        // Since we can not import BatteryStatsService from here. This class really needs to be
        // moved to java/services/com/android/server/
        mBatteryStats = IBatteryStats.Stub.asInterface(ServiceManager.getService("batteryinfo"));

        initializeNativeDataNative();

        if (isEnabledNative() == 1) {
            Log.w(TAG, "Bluetooth daemons already running - runtime restart? ");
            disableNative();
        }

        mBondState = new BluetoothBondState(context, this);
        mAdapterProperties = new BluetoothAdapterProperties(context, this);
        mDeviceProperties = new BluetoothDeviceProperties(this);

        mDeviceServiceChannelCache = new HashMap<String, Map<ParcelUuid, Integer>>();
        mDeviceOobData = new HashMap<String, Pair<byte[], byte[]>>();
        mUuidIntentTracker = new ArrayList<String>();
        mUuidCallbackTracker = new HashMap<RemoteService, IBluetoothCallback>();
        mServiceRecordToPid = new HashMap<Integer, ServiceRecordClient>();
        mDeviceProfileState = new HashMap<String, BluetoothDeviceProfileState>();
        mA2dpProfileState = new BluetoothProfileState(mContext, BluetoothProfileState.A2DP);
        mHfpProfileState = new BluetoothProfileState(mContext, BluetoothProfileState.HFP);

        mHfpProfileState.start();
        mA2dpProfileState.start();

        IntentFilter filter = new IntentFilter();
        registerForAirplaneMode(filter);

        filter.addAction(Intent.ACTION_DOCK_EVENT);
        mContext.registerReceiver(mReceiver, filter);
        mBluetoothInputProfileHandler = BluetoothInputProfileHandler.getInstance(mContext, this);
        mBluetoothPanProfileHandler = BluetoothPanProfileHandler.getInstance(mContext, this);
        mBluetoothHealthProfileHandler = BluetoothHealthProfileHandler.getInstance(mContext, this);
        mIncomingConnections = new HashMap<String, Pair<Integer, String>>();
        mProfileConnectionState = new HashMap<Integer, Pair<Integer, Integer>>();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.079 -0400", hash_original_method = "B3CC496320E1E66B300745B0258243CB", hash_generated_method = "4329F3EE093ACEDC5C42A6E6B4A56817")
    
private synchronized boolean writeDockPin() {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(DOCK_PIN_PATH));

            // Generate a random 4 digit pin between 0000 and 9999
            // This is not truly random but good enough for our purposes.
            int pin = (int) Math.floor(Math.random() * 10000);

            mDockPin = String.format("%04d", pin);
            out.write(mDockPin);
            return true;
        } catch (FileNotFoundException e) {
            Log.e(TAG, "FileNotFoundException while trying to write dock pairing pin");
        } catch (IOException e) {
            Log.e(TAG, "IOException while while trying to write dock pairing pin");
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    // Ignore
                }
            }
        }
        mDockPin = null;
        return false;
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.081 -0400", hash_original_method = "9AF09AAAB8FFFF51FB748B92C51E1FA3", hash_generated_method = "BED35F3201E40473DA837153CD0E794D")
    
synchronized String getDockPin() {
        return mDockPin;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.082 -0400", hash_original_method = "C348C5726B109D4965C4745F0D81944B", hash_generated_method = "1EF228DF8D2E8E48BF31C1396AFCD918")
    
public synchronized void initAfterRegistration() {
        mAdapter = BluetoothAdapter.getDefaultAdapter();
        mBluetoothState = new BluetoothAdapterStateMachine(mContext, this, mAdapter);
        mBluetoothState.start();
        if (mContext.getResources().getBoolean
            (com.android.internal.R.bool.config_bluetooth_adapter_quick_switch)) {
            mBluetoothState.sendMessage(BluetoothAdapterStateMachine.TURN_HOT);
        }
        mEventLoop = mBluetoothState.getBluetoothEventLoop();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.084 -0400", hash_original_method = "516A33A2AA23B73881C9EA230803EE4E", hash_generated_method = "A01734D39148398EB60AFD2F2EA362AF")
    
public synchronized void initAfterA2dpRegistration() {
        mEventLoop.getProfileProxy();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.085 -0400", hash_original_method = "2FAAC17FE9D4173D4999AE153FB6D1C2", hash_generated_method = "F8F761A71D5BC7C668EB873FF96B5431")
    
@Override
    protected void finalize() throws Throwable {
        mContext.unregisterReceiver(mReceiver);
        try {
            cleanupNativeDataNative();
        } finally {
            super.finalize();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.087 -0400", hash_original_method = "F79CFA9732ED889FD0A2141E59A898B6", hash_generated_method = "6736BE4C11D3043A131DF93862CE9A1C")
    
public boolean isEnabled() {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        return isEnabledInternal();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.088 -0400", hash_original_method = "50B6A34B453CFBA5EE22FB466DF7F23F", hash_generated_method = "E4EF0C021E86FCAA6236B329F36900D4")
    
private boolean isEnabledInternal() {
        return (getBluetoothStateInternal() == BluetoothAdapter.STATE_ON);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.089 -0400", hash_original_method = "4D9788CB005290564E72C45B85B702A3", hash_generated_method = "71112DFB67E9B923EFDC4A4CB5869B2D")
    
public int getBluetoothState() {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        return getBluetoothStateInternal();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.090 -0400", hash_original_method = "3AE25525F46F46133D74B719D8AB6957", hash_generated_method = "3AE25525F46F46133D74B719D8AB6957")
    
int getBluetoothStateInternal() {
        return mBluetoothState.getBluetoothAdapterState();
    }

    /**
     * Bring down bluetooth and disable BT in settings. Returns true on success.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.092 -0400", hash_original_method = "D4D4082A9C972307633B5D5120EC13F5", hash_generated_method = "A2F3463D3EDB5CE6BC1D33FECD5AD83D")
    
public boolean disable() {
        return disable(true);
    }

    /**
     * Bring down bluetooth. Returns true on success.
     *
     * @param saveSetting If true, persist the new setting
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.093 -0400", hash_original_method = "A1CE19983A508BDA4D34C581257E8803", hash_generated_method = "11CBF1B4B96363CD87494A7B7C60263A")
    
public synchronized boolean disable(boolean saveSetting) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM, "Need BLUETOOTH_ADMIN permission");

        int adapterState = getBluetoothStateInternal();

        switch (adapterState) {
        case BluetoothAdapter.STATE_OFF:
            return true;
        case BluetoothAdapter.STATE_ON:
            break;
        default:
            return false;
        }

        mBluetoothState.sendMessage(BluetoothAdapterStateMachine.USER_TURN_OFF, saveSetting);
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.095 -0400", hash_original_method = "6C8E55CF743901D9DF8FB21014C6AF51", hash_generated_method = "CDA1E829A8958A8680B6E903E55498A6")
    
synchronized void disconnectDevices() {
        // Disconnect devices handled by BluetoothService.
        for (BluetoothDevice device: getConnectedInputDevices()) {
            disconnectInputDevice(device);
        }

        for (BluetoothDevice device: getConnectedPanDevices()) {
            disconnectPanDevice(device);
        }
    }

    /**
     * The Bluetooth has been turned off, but hot. Do bonding, profile cleanup
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.097 -0400", hash_original_method = "34031FA5246C01FDBDC22F3BF54C63BE", hash_generated_method = "7F37478C90DCE3ED0902A035D726625F")
    
synchronized void finishDisable() {
        // mark in progress bondings as cancelled
        for (String address : mBondState.listInState(BluetoothDevice.BOND_BONDING)) {
            mBondState.setBondState(address, BluetoothDevice.BOND_NONE,
                                    BluetoothDevice.UNBOND_REASON_AUTH_CANCELED);
        }

        // Stop the profile state machine for bonded devices.
        for (String address : mBondState.listInState(BluetoothDevice.BOND_BONDED)) {
            removeProfileState(address);
        }

        // update mode
        Intent intent = new Intent(BluetoothAdapter.ACTION_SCAN_MODE_CHANGED);
        intent.putExtra(BluetoothAdapter.EXTRA_SCAN_MODE, BluetoothAdapter.SCAN_MODE_NONE);
        mContext.sendBroadcast(intent, BLUETOOTH_PERM);
    }

    /**
     * Local clean up after broadcasting STATE_OFF intent
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.099 -0400", hash_original_method = "8035859A70E80A27BD21848BB8758889", hash_generated_method = "8F87544B56833E094EFCB2047EE6D657")
    
synchronized void cleanupAfterFinishDisable() {
        mAdapterProperties.clear();

        for (Integer srHandle : mServiceRecordToPid.keySet()) {
            removeServiceRecordNative(srHandle);
        }
        mServiceRecordToPid.clear();

        mProfilesConnected = 0;
        mProfilesConnecting = 0;
        mProfilesDisconnecting = 0;
        mAdapterConnectionState = BluetoothAdapter.STATE_DISCONNECTED;
        mAdapterUuids = null;
        mAdapterSdpHandles = null;

        // Log bluetooth off to battery stats.
        long ident = Binder.clearCallingIdentity();
        try {
            mBatteryStats.noteBluetoothOff();
        } catch (RemoteException e) {
        } finally {
            Binder.restoreCallingIdentity(ident);
        }
    }

    /**
     * power off Bluetooth
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.100 -0400", hash_original_method = "EA6927FE1153883C196390845CF6A961", hash_generated_method = "696999E8B667193198C23169978162B1")
    
synchronized void shutoffBluetooth() {
        if (mAdapterSdpHandles != null) removeReservedServiceRecordsNative(mAdapterSdpHandles);
        setBluetoothTetheringNative(false, BluetoothPanProfileHandler.NAP_ROLE,
                BluetoothPanProfileHandler.NAP_BRIDGE);
        tearDownNativeDataNative();
    }

    /**
     * Data clean up after Bluetooth shutoff
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.101 -0400", hash_original_method = "0B5E89E9EEAC4DA5231277484777323A", hash_generated_method = "9C7032DBDD4887024700982A31926829")
    
synchronized void cleanNativeAfterShutoffBluetooth() {
        // Ths method is called after shutdown of event loop in the Bluetooth shut down
        // procedure

        // the adapter property could be changed before event loop is stoped, clear it again
        mAdapterProperties.clear();
        disableNative();
    }

    /** Bring up BT and persist BT on in settings */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.103 -0400", hash_original_method = "184F5FDEB4E6BF636299908927F9FFA3", hash_generated_method = "48F1C8008A2713C69B0D88CA7D0FB4BB")
    
public boolean enable() {
        return enable(true);
    }

    /**
     * Enable this Bluetooth device, asynchronously.
     * This turns on/off the underlying hardware.
     *
     * @param saveSetting If true, persist the new state of BT in settings
     * @return True on success (so far)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.104 -0400", hash_original_method = "379F3C8BA75588317558AB7BE5AA34A0", hash_generated_method = "F163D1608D0123B45D0A1C14E95DFFF9")
    
public synchronized boolean enable(boolean saveSetting) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                                                "Need BLUETOOTH_ADMIN permission");

        // Airplane mode can prevent Bluetooth radio from being turned on.
        if (mIsAirplaneSensitive && isAirplaneModeOn() && !mIsAirplaneToggleable) {
            return false;
        }
        mBluetoothState.sendMessage(BluetoothAdapterStateMachine.USER_TURN_ON, saveSetting);
        return true;
    }

    /**
     * Turn on Bluetooth Module, Load firmware, and do all the preparation
     * needed to get the Bluetooth Module ready but keep it not discoverable
     * and not connectable.
     */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.105 -0400", hash_original_method = "6211296913026D4E433F161E3955F8CF", hash_generated_method = "F4C01E80BBAAB1053C78228335E12B4E")
    
synchronized boolean prepareBluetooth() {
        if (!setupNativeDataNative()) {
            return false;
        }
        switchConnectable(false);
        updateSdpRecords();
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.111 -0400", hash_original_method = "236438887B0F6FB08A00491B5272036F", hash_generated_method = "9E43093E0626748888D79DCD0AFE8593")
    
private synchronized void addReservedSdpRecords(final ArrayList<ParcelUuid> uuids) {
        //Register SDP records.
        int[] svcIdentifiers = new int[uuids.size()];
        for (int i = 0; i < uuids.size(); i++) {
            svcIdentifiers[i] = BluetoothUuid.getServiceIdentifierFromParcelUuid(uuids.get(i));
        }
        mAdapterSdpHandles = addReservedServiceRecordsNative(svcIdentifiers);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.113 -0400", hash_original_method = "4AE6F56F950F24356668A1A14FA3CC86", hash_generated_method = "750AF13AF48B4EA8EB9E24841F6B30CC")
    
private synchronized void updateSdpRecords() {
        ArrayList<ParcelUuid> uuids = new ArrayList<ParcelUuid>();

        // Add the default records
        uuids.add(BluetoothUuid.HSP_AG);
        uuids.add(BluetoothUuid.ObexObjectPush);

        if (mContext.getResources().
                getBoolean(com.android.internal.R.bool.config_voice_capable)) {
            uuids.add(BluetoothUuid.Handsfree_AG);
            uuids.add(BluetoothUuid.PBAP_PSE);
        }

        // Add SDP records for profiles maintained by Android userspace
        addReservedSdpRecords(uuids);

        // Enable profiles maintained by Bluez userspace.
        setBluetoothTetheringNative(true, BluetoothPanProfileHandler.NAP_ROLE,
                BluetoothPanProfileHandler.NAP_BRIDGE);

        // Add SDP records for profiles maintained by Bluez userspace
        uuids.add(BluetoothUuid.AudioSource);
        uuids.add(BluetoothUuid.AvrcpTarget);
        uuids.add(BluetoothUuid.NAP);

        // Cannot cast uuids.toArray directly since ParcelUuid is parcelable
        mAdapterUuids = new ParcelUuid[uuids.size()];
        for (int i = 0; i < uuids.size(); i++) {
            mAdapterUuids[i] = uuids.get(i);
        }
    }

    /**
     * This function is called from Bluetooth Event Loop when onPropertyChanged
     * for adapter comes in with UUID property.
     * @param uuidsThe uuids of adapter as reported by Bluez.
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.115 -0400", hash_original_method = "98E24965531418F2B79982016D9498F7", hash_generated_method = "4191FE3A3D82799B818DA578EF175146")
    
synchronized void updateBluetoothState(String uuids) {
        ParcelUuid[] adapterUuids = convertStringToParcelUuid(uuids);

        if (mAdapterUuids != null &&
            BluetoothUuid.containsAllUuids(adapterUuids, mAdapterUuids)) {
            mBluetoothState.sendMessage(BluetoothAdapterStateMachine.SERVICE_RECORD_LOADED);
        }
    }

    /**
     * This method is called immediately before Bluetooth module is turned on after
     * the adapter became pariable.
     * It inits bond state and profile state before STATE_ON intent is broadcasted.
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.116 -0400", hash_original_method = "B584CD8EAA82EE784971C756859E7D17", hash_generated_method = "B584CD8EAA82EE784971C756859E7D17")
    
void initBluetoothAfterTurningOn() {
        String discoverable = getProperty("Discoverable", false);
        String timeout = getProperty("DiscoverableTimeout", false);
        if (discoverable.equals("true") && Integer.valueOf(timeout) != 0) {
            setAdapterPropertyBooleanNative("Discoverable", 0);
        }
        mBondState.initBondState();
        initProfileState();
        getProfileProxy();
    }

    /**
     * This method is called immediately after Bluetooth module is turned on.
     * It starts auto-connection and places bluetooth on sign onto the battery
     * stats
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.118 -0400", hash_original_method = "C1FC5B201D56EA47798B278DAD9B56A2", hash_generated_method = "922B2E0468B96AD4E0BA173F4EE13A5B")
    
void runBluetooth() {
        autoConnect();

        // Log bluetooth on to battery stats.
        long ident = Binder.clearCallingIdentity();
        try {
            mBatteryStats.noteBluetoothOn();
        } catch (RemoteException e) {
            Log.e(TAG, "", e);
        } finally {
            Binder.restoreCallingIdentity(ident);
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.119 -0400", hash_original_method = "E9C9AB35C7455F645DD8E9AACC0F6CAC", hash_generated_method = "157871BCA17101CED4ECF21CDEBC23A6")
    
synchronized boolean attemptAutoPair(String address) {
        if (!mBondState.hasAutoPairingFailed(address) &&
                !mBondState.isAutoPairingBlacklisted(address)) {
            mBondState.attempt(address);
            setPin(address, BluetoothDevice.convertPinToBytes("0000"));
            return true;
        }
        return false;
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.120 -0400", hash_original_method = "11B8E2EBD017ECBFB7B457D54759570F", hash_generated_method = "134BA124F98C1DA9838B657E9290D89B")
    
synchronized boolean isFixedPinZerosAutoPairKeyboard(String address) {
        // Check for keyboards which have fixed PIN 0000 as the pairing pin
        return mBondState.isFixedPinZerosAutoPairKeyboard(address);
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.122 -0400", hash_original_method = "988C6686EF95C33284F665FEBB0FC370", hash_generated_method = "260A56121C52B0B73C54312ABD50E79E")
    
synchronized void onCreatePairedDeviceResult(String address, int result) {
        if (result == BluetoothDevice.BOND_SUCCESS) {
            setBondState(address, BluetoothDevice.BOND_BONDED);
            if (mBondState.isAutoPairingAttemptsInProgress(address)) {
                mBondState.clearPinAttempts(address);
            }
        } else if (result == BluetoothDevice.UNBOND_REASON_AUTH_FAILED &&
                mBondState.getAttempt(address) == 1) {
            mBondState.addAutoPairingFailure(address);
            pairingAttempt(address, result);
        } else if (result == BluetoothDevice.UNBOND_REASON_REMOTE_DEVICE_DOWN &&
              mBondState.isAutoPairingAttemptsInProgress(address)) {
            pairingAttempt(address, result);
        } else {
            setBondState(address, BluetoothDevice.BOND_NONE, result);
            if (mBondState.isAutoPairingAttemptsInProgress(address)) {
                mBondState.clearPinAttempts(address);
            }
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.123 -0400", hash_original_method = "A568BB70DFC5642DD392108BC11BF0B1", hash_generated_method = "7B9D06509D0B2717D33C270B7A21C655")
    
synchronized String getPendingOutgoingBonding() {
        return mBondState.getPendingOutgoingBonding();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.125 -0400", hash_original_method = "8414EE3E63C2A3839E65DDDA0E36384F", hash_generated_method = "E69389E9E9A9F67636854A081E45CD40")
    
private void pairingAttempt(String address, int result) {
        // This happens when our initial guess of "0000" as the pass key
        // fails. Try to create the bond again and display the pin dialog
        // to the user. Use back-off while posting the delayed
        // message. The initial value is
        // INIT_AUTO_PAIRING_FAILURE_ATTEMPT_DELAY and the max value is
        // MAX_AUTO_PAIRING_FAILURE_ATTEMPT_DELAY. If the max value is
        // reached, display an error to the user.
        int attempt = mBondState.getAttempt(address);
        if (attempt * INIT_AUTO_PAIRING_FAILURE_ATTEMPT_DELAY >
                    MAX_AUTO_PAIRING_FAILURE_ATTEMPT_DELAY) {
            mBondState.clearPinAttempts(address);
            setBondState(address, BluetoothDevice.BOND_NONE, result);
            return;
        }

        Message message = mHandler.obtainMessage(MESSAGE_AUTO_PAIRING_FAILURE_ATTEMPT_DELAY);
        message.obj = address;
        boolean postResult =  mHandler.sendMessageDelayed(message,
                                        attempt * INIT_AUTO_PAIRING_FAILURE_ATTEMPT_DELAY);
        if (!postResult) {
            mBondState.clearPinAttempts(address);
            setBondState(address,
                    BluetoothDevice.BOND_NONE, result);
            return;
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.126 -0400", hash_original_method = "4053577290C70FDE95B6B468E11F8963", hash_generated_method = "4053577290C70FDE95B6B468E11F8963")
    
BluetoothDevice getRemoteDevice(String address) {
        return mAdapter.getRemoteDevice(address);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.129 -0400", hash_original_method = "F2EDE8F29071968276504D093C2319DB", hash_generated_method = "8270BD5467BB2A84F8FDE365B3C411E7")
    
public synchronized boolean setName(String name) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                                                "Need BLUETOOTH_ADMIN permission");
        if (name == null) {
            return false;
        }
        return setPropertyString("Name", name);
    }

    //TODO(): setPropertyString, setPropertyInteger, setPropertyBoolean
    // Either have a single property function with Object as the parameter
    // or have a function for each property and then obfuscate in the JNI layer.
    // The following looks dirty.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.131 -0400", hash_original_method = "5396FC11811D242B8FD3DC15012A5862", hash_generated_method = "229CD6EEA94E39367AAE6913C6DE94B4")
    
private boolean setPropertyString(String key, String value) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        if (!isEnabledInternal()) return false;
        return setAdapterPropertyStringNative(key, value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.132 -0400", hash_original_method = "0680E70D679084B5B0E801C7C390E0BD", hash_generated_method = "8F925D1AC7780496A1CA77C4C52B178A")
    
private boolean setPropertyInteger(String key, int value) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        if (!isEnabledInternal()) return false;
        return setAdapterPropertyIntegerNative(key, value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.134 -0400", hash_original_method = "5038DE98BB61FCA78BA54AD41083484C", hash_generated_method = "EC5AC33C90669EC28DE99D002964B8CB")
    
private boolean setPropertyBoolean(String key, boolean value) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        if (!isEnabledInternal()) return false;
        return setAdapterPropertyBooleanNative(key, value ? 1 : 0);
    }

    /**
     * Set the discoverability window for the device.  A timeout of zero
     * makes the device permanently discoverable (if the device is
     * discoverable).  Setting the timeout to a nonzero value does not make
     * a device discoverable; you need to call setMode() to make the device
     * explicitly discoverable.
     *
     * @param timeout The discoverable timeout in seconds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.135 -0400", hash_original_method = "579688ABC057BAB6BA42A62C8762E095", hash_generated_method = "19166D57E8FECD925576021D6DFBC186")
    
public synchronized boolean setDiscoverableTimeout(int timeout) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                                                "Need BLUETOOTH_ADMIN permission");
        return setPropertyInteger("DiscoverableTimeout", timeout);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.137 -0400", hash_original_method = "506702FC1F0D7B51A165CAC11DA7F2E7", hash_generated_method = "15751F6DA7611738F809630482864B5A")
    
public synchronized boolean setScanMode(int mode, int duration) {
        mContext.enforceCallingOrSelfPermission(android.Manifest.permission.WRITE_SECURE_SETTINGS,
                                                "Need WRITE_SECURE_SETTINGS permission");
        boolean pairable;
        boolean discoverable;

        switch (mode) {
        case BluetoothAdapter.SCAN_MODE_NONE:
            pairable = false;
            discoverable = false;
            break;
        case BluetoothAdapter.SCAN_MODE_CONNECTABLE:
            pairable = true;
            discoverable = false;
            break;
        case BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE:
            pairable = true;
            discoverable = true;
            if (DBG) Log.d(TAG, "BT Discoverable for " + duration + " seconds");
            break;
        default:
            Log.w(TAG, "Requested invalid scan mode " + mode);
            return false;
        }

        setPropertyBoolean("Discoverable", discoverable);
        setPropertyBoolean("Pairable", pairable);
        return true;
    }

    /**
     * @param on true set the local Bluetooth module to be connectable
     *                The dicoverability is recovered to what it was before
     *                switchConnectable(false) call
     *           false set the local Bluetooth module to be not connectable
     *                 and not dicoverable
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.138 -0400", hash_original_method = "8EEA5403D8D7190F44D3F35ECEFAE81E", hash_generated_method = "F380844617116698F63DA5B8CF38E037")
    
synchronized void switchConnectable(boolean on) {
        setAdapterPropertyBooleanNative("Powered", on ? 1 : 0);
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.140 -0400", hash_original_method = "CE75370D5F7D8B4EEBC26A6731ABD3F8", hash_generated_method = "A51106106E8714E7809063F24F43D39B")
    
synchronized void setPairable() {
        String pairableString = getProperty("Pairable", false);
        if (pairableString == null) {
            Log.e(TAG, "null pairableString");
            return;
        }
        if (pairableString.equals("false")) {
            setAdapterPropertyBooleanNative("Pairable", 1);
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.141 -0400", hash_original_method = "786C928034B275C0EE761E5F297880EA", hash_generated_method = "4266E4784ADCCFDCAA41EC424F9FB044")
    
String getProperty(String name, boolean checkState) {
        // If checkState is false, check if the event loop is running.
        // before making the call to Bluez
        if (checkState) {
            if (!isEnabledInternal()) return null;
        } else if (!mEventLoop.isEventLoopRunning()) {
            return null;
        }

        return mAdapterProperties.getProperty(name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.143 -0400", hash_original_method = "AE0B06CD0A7663EC4FE8330BD921A6F7", hash_generated_method = "AE0B06CD0A7663EC4FE8330BD921A6F7")
    
BluetoothAdapterProperties getAdapterProperties() {
        return mAdapterProperties;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.144 -0400", hash_original_method = "5C38D0FECC2B1FE3B900711997FA0718", hash_generated_method = "5C38D0FECC2B1FE3B900711997FA0718")
    
BluetoothDeviceProperties getDeviceProperties() {
        return mDeviceProperties;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.145 -0400", hash_original_method = "B48C7BF3C971214CF605D3682A548494", hash_generated_method = "B48C7BF3C971214CF605D3682A548494")
    
boolean isRemoteDeviceInCache(String address) {
        return mDeviceProperties.isInCache(address);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.146 -0400", hash_original_method = "684080DCD996B92A77311E40CF0579A7", hash_generated_method = "684080DCD996B92A77311E40CF0579A7")
    
void setRemoteDeviceProperty(String address, String name, String value) {
        mDeviceProperties.setProperty(address, name, value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.148 -0400", hash_original_method = "7D5E6927C0B3B6C8A32C41ADB3E12095", hash_generated_method = "7D5E6927C0B3B6C8A32C41ADB3E12095")
    
void updateRemoteDevicePropertiesCache(String address) {
        mDeviceProperties.updateCache(address);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.149 -0400", hash_original_method = "16DEB6211549C734A2763EFCD8BA97D2", hash_generated_method = "DF0C841346A78EA69A5A40EEFCA99F4E")
    
public synchronized String getAddress() {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        // Don't check state since we want to provide address, even if BT is off
        return getProperty("Address", false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.151 -0400", hash_original_method = "DA76059141D06767870FF9F13C87B55C", hash_generated_method = "FBCF23BBC07ED545D6F8B481B75777EC")
    
public synchronized String getName() {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        // Don't check state since we want to provide name, even if BT is off
        return getProperty("Name", false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.153 -0400", hash_original_method = "F4BCF4B974330780E4C1956E2E5653CB", hash_generated_method = "C5891FDC0E6240FB786E462C5482D314")
    
public ParcelUuid[] getUuids() {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        String value =  getProperty("UUIDs", true);
        if (value == null) return null;
        return convertStringToParcelUuid(value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.154 -0400", hash_original_method = "0AB3CA992B27A7B550E154230959C888", hash_generated_method = "8F9FDBC9258C7E3CEE91F67F84F8CBCF")
    
private ParcelUuid[] convertStringToParcelUuid(String value) {
        String[] uuidStrings = null;
        // The UUIDs are stored as a "," separated string.
        uuidStrings = value.split(",");
        ParcelUuid[] uuids = new ParcelUuid[uuidStrings.length];

        for (int i = 0; i < uuidStrings.length; i++) {
            uuids[i] = ParcelUuid.fromString(uuidStrings[i]);
        }
        return uuids;
    }

    /**
     * Returns the user-friendly name of a remote device.  This value is
     * returned from our local cache, which is updated when onPropertyChange
     * event is received.
     * Do not expect to retrieve the updated remote name immediately after
     * changing the name on the remote device.
     *
     * @param address Bluetooth address of remote device.
     *
     * @return The user-friendly name of the specified remote device.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.156 -0400", hash_original_method = "DA418939AA9D24505E4DB2655CA21258", hash_generated_method = "64820CB6B77E1F0B3F224F5D52820F8F")
    
public synchronized String getRemoteName(String address) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        if (!BluetoothAdapter.checkBluetoothAddress(address)) {
            return null;
        }
        return mDeviceProperties.getProperty(address, "Name");
    }

    /**
     * Returns alias of a remote device.  This value is returned from our
     * local cache, which is updated when onPropertyChange event is received.
     *
     * @param address Bluetooth address of remote device.
     *
     * @return The alias of the specified remote device.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.157 -0400", hash_original_method = "0B98896E2699ACD93F906B127D19FA56", hash_generated_method = "0B10059C18A30D7D6CD0072595E66D59")
    
public synchronized String getRemoteAlias(String address) {

        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        if (!BluetoothAdapter.checkBluetoothAddress(address)) {
            return null;
        }
        return mDeviceProperties.getProperty(address, "Alias");
    }

    /**
     * Set the alias of a remote device.
     *
     * @param address Bluetooth address of remote device.
     * @param alias new alias to change to
     * @return true on success, false on error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.159 -0400", hash_original_method = "2D1C1D7F1CCEB5E8074B877F032BDF3A", hash_generated_method = "288CDDEC63FAD1C652B8DBF4C3B28931")
    
public synchronized boolean setRemoteAlias(String address, String alias) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        if (!BluetoothAdapter.checkBluetoothAddress(address)) {
            return false;
        }

        return setDevicePropertyStringNative(getObjectPathFromAddress(address),
                                             "Alias", alias);
    }

    /**
     * Get the discoverability window for the device.  A timeout of zero
     * means that the device is permanently discoverable (if the device is
     * in the discoverable mode).
     *
     * @return The discoverability window of the device, in seconds.  A negative
     *         value indicates an error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.160 -0400", hash_original_method = "1367709907005E6B53EE6B027E0B489E", hash_generated_method = "C229D2E2D63163C53F7580803E74C9D3")
    
public int getDiscoverableTimeout() {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        String timeout = getProperty("DiscoverableTimeout", true);
        if (timeout != null)
           return Integer.valueOf(timeout);
        else
            return -1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.162 -0400", hash_original_method = "AD50FA23D567FDD8298F74610FC76D3E", hash_generated_method = "2075ACD60259E514FA167497C17624AC")
    
public int getScanMode() {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        if (!isEnabledInternal())
            return BluetoothAdapter.SCAN_MODE_NONE;

        boolean pairable = getProperty("Pairable", true).equals("true");
        boolean discoverable = getProperty("Discoverable", true).equals("true");
        return bluezStringToScanMode (pairable, discoverable);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.164 -0400", hash_original_method = "87251DBEFA0A7544248D1F237692B290", hash_generated_method = "F291D22EAE26518F7FE467C901873FE7")
    
public synchronized boolean startDiscovery() {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                                                "Need BLUETOOTH_ADMIN permission");
        if (!isEnabledInternal()) return false;

        return startDiscoveryNative();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.165 -0400", hash_original_method = "6D9696B2702C9C0985F981F397F580E0", hash_generated_method = "EC2FACA15C927B434B0D6B488EAB77EE")
    
public synchronized boolean cancelDiscovery() {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                                                "Need BLUETOOTH_ADMIN permission");
        if (!isEnabledInternal()) return false;

        return stopDiscoveryNative();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.166 -0400", hash_original_method = "F7CEF1A216D14D3C72B0B94427AF6741", hash_generated_method = "109F6E9B9BF4C98DD579CE585E4A095E")
    
public boolean isDiscovering() {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");

        String discoveringProperty = getProperty("Discovering", false);
        if (discoveringProperty == null) {
            return false;
        }

        return discoveringProperty.equals("true");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.168 -0400", hash_original_method = "37D5135C7D7F4603BBE1EB6DCB7F633A", hash_generated_method = "51AF22377510038865E8338B6171F0D0")
    
private boolean isBondingFeasible(String address) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                                                "Need BLUETOOTH_ADMIN permission");
        if (!isEnabledInternal()) return false;

        if (!BluetoothAdapter.checkBluetoothAddress(address)) {
            return false;
        }
        address = address.toUpperCase();

        if (mBondState.getPendingOutgoingBonding() != null) {
            Log.d(TAG, "Ignoring createBond(): another device is bonding");
            // a different device is currently bonding, fail
            return false;
        }

        // Check for bond state only if we are not performing auto
        // pairing exponential back-off attempts.
        if (!mBondState.isAutoPairingAttemptsInProgress(address) &&
                mBondState.getBondState(address) != BluetoothDevice.BOND_NONE) {
            Log.d(TAG, "Ignoring createBond(): this device is already bonding or bonded");
            return false;
        }

        if (address.equals(mDockAddress)) {
            if (!writeDockPin()) {
                Log.e(TAG, "Error while writing Pin for the dock");
                return false;
            }
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.170 -0400", hash_original_method = "D4A8F90F073F9A639B67D01521A4653F", hash_generated_method = "493F36EF959A32F2FC1C51501A8AE66F")
    
public synchronized boolean createBond(String address) {
        if (!isBondingFeasible(address)) return false;

        if (!createPairedDeviceNative(address, 60000  /*1 minute*/ )) {
            return false;
        }

        mBondState.setPendingOutgoingBonding(address);
        mBondState.setBondState(address, BluetoothDevice.BOND_BONDING);

        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.172 -0400", hash_original_method = "475C2F6CD13A8ECE4FB076785275D32B", hash_generated_method = "1FA3B8168BBFFE03E2294525A827F8B6")
    
public synchronized boolean createBondOutOfBand(String address, byte[] hash,
                                                    byte[] randomizer) {
        if (!isBondingFeasible(address)) return false;

        if (!createPairedDeviceOutOfBandNative(address, 60000 /* 1 minute */)) {
            return false;
        }

        setDeviceOutOfBandData(address, hash, randomizer);
        mBondState.setPendingOutgoingBonding(address);
        mBondState.setBondState(address, BluetoothDevice.BOND_BONDING);

        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.173 -0400", hash_original_method = "D1EEE856FD076682458F4262A0EEC033", hash_generated_method = "AF91B86DA6EFC1418B9B795C02A0A41C")
    
public synchronized boolean setDeviceOutOfBandData(String address, byte[] hash,
            byte[] randomizer) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                                                "Need BLUETOOTH_ADMIN permission");
        if (!isEnabledInternal()) return false;

        Pair <byte[], byte[]> value = new Pair<byte[], byte[]>(hash, randomizer);

        if (DBG) {
            Log.d(TAG, "Setting out of band data for: " + address + ":" +
                  Arrays.toString(hash) + ":" + Arrays.toString(randomizer));
        }

        mDeviceOobData.put(address, value);
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.175 -0400", hash_original_method = "74D87705C7E73E385B57078B7F478196", hash_generated_method = "74D87705C7E73E385B57078B7F478196")
    
Pair<byte[], byte[]> getDeviceOutOfBandData(BluetoothDevice device) {
        return mDeviceOobData.get(device.getAddress());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.176 -0400", hash_original_method = "7FEF72856B24BEE636F09C0AE3B1871F", hash_generated_method = "0C11425057354798631002B883E4FFF3")
    
public synchronized byte[] readOutOfBandData() {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM,
                                                "Need BLUETOOTH permission");
        if (!isEnabledInternal()) return null;

        return readAdapterOutOfBandDataNative();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.178 -0400", hash_original_method = "A05FF7F968E25F85B9F326ADA78341EA", hash_generated_method = "BA43A05915DBA12DF05E06199D4612B3")
    
public synchronized boolean cancelBondProcess(String address) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                                                "Need BLUETOOTH_ADMIN permission");
        if (!isEnabledInternal()) return false;

        if (!BluetoothAdapter.checkBluetoothAddress(address)) {
            return false;
        }
        address = address.toUpperCase();
        if (mBondState.getBondState(address) != BluetoothDevice.BOND_BONDING) {
            return false;
        }

        mBondState.setBondState(address, BluetoothDevice.BOND_NONE,
                                BluetoothDevice.UNBOND_REASON_AUTH_CANCELED);
        cancelDeviceCreationNative(address);
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.179 -0400", hash_original_method = "CBC9BE78D84B398B83766A70FE082FF5", hash_generated_method = "75DCB7A7165C021E968AEB98FCBA1AA2")
    
public synchronized boolean removeBond(String address) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                                                "Need BLUETOOTH_ADMIN permission");
        if (!isEnabledInternal()) return false;

        if (!BluetoothAdapter.checkBluetoothAddress(address)) {
            return false;
        }
        BluetoothDeviceProfileState state = mDeviceProfileState.get(address);
        if (state != null) {
            state.sendMessage(BluetoothDeviceProfileState.UNPAIR);
            return true;
        } else {
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.180 -0400", hash_original_method = "EA65C514771A14D98096A434BDBCF2E2", hash_generated_method = "FD796F24A3C6609E9FC0CFAACBCB385A")
    
public synchronized boolean removeBondInternal(String address) {
        // Unset the trusted device state and then unpair
        setTrust(address, false);
        return removeDeviceNative(getObjectPathFromAddress(address));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.182 -0400", hash_original_method = "D2D0C38B31B728B3EE8371705AF7B9D7", hash_generated_method = "0E3DD60E836807E4F22833FE8E368B49")
    
public synchronized String[] listBonds() {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        return mBondState.listInState(BluetoothDevice.BOND_BONDED);
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.183 -0400", hash_original_method = "7C288EE30349B931E660A620B772B4B7", hash_generated_method = "F1ED00787934EF60756C438BF28CE364")
    
synchronized String[] listInState(int state) {
      return mBondState.listInState(state);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.185 -0400", hash_original_method = "F03B54B5795DAD20CF71466CB38D3885", hash_generated_method = "82810FE544D6094196715CF665107C46")
    
public synchronized int getBondState(String address) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        if (!BluetoothAdapter.checkBluetoothAddress(address)) {
            return BluetoothDevice.ERROR;
        }
        return mBondState.getBondState(address.toUpperCase());
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.187 -0400", hash_original_method = "3C1F12C53781677F7DFDD7903BCEDDD3", hash_generated_method = "340C93363062C70920FD44A46EC55C62")
    
synchronized boolean setBondState(String address, int state) {
        return setBondState(address, state, 0);
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.188 -0400", hash_original_method = "B319B9E5AB5FE28AF10DE2C305FC8D65", hash_generated_method = "ED05B1984FC824C44526BD1386C9EAB8")
    
synchronized boolean setBondState(String address, int state, int reason) {
        mBondState.setBondState(address.toUpperCase(), state, reason);
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.189 -0400", hash_original_method = "3D1E2FE11631D3D435BC874938AE9CAB", hash_generated_method = "8551678DFBD6CA8F42C62A351E1CCC3D")
    
public synchronized boolean isBluetoothDock(String address) {
        SharedPreferences sp = mContext.getSharedPreferences(SHARED_PREFERENCES_NAME,
                Context.MODE_PRIVATE);

        return sp.contains(SHARED_PREFERENCE_DOCK_ADDRESS + address);
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.191 -0400", hash_original_method = "90C1254A49CA0DFEF9AC7C0BD9978BFD", hash_generated_method = "90C1254A49CA0DFEF9AC7C0BD9978BFD")
    
String[] getRemoteDeviceProperties(String address) {
        if (!isEnabledInternal()) return null;

        String objectPath = getObjectPathFromAddress(address);
        return (String [])getDevicePropertiesNative(objectPath);
    }

    /**
     * Sets the remote device trust state.
     *
     * @return boolean to indicate operation success or fail
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.192 -0400", hash_original_method = "8389F06D7BDA70ADBF3063402125F09D", hash_generated_method = "54E38E57CA161A3C94380B68F5032DEF")
    
public synchronized boolean setTrust(String address, boolean value) {
        if (!BluetoothAdapter.checkBluetoothAddress(address)) {
            mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                    "Need BLUETOOTH_ADMIN permission");
            return false;
        }

        if (!isEnabledInternal()) return false;

        return setDevicePropertyBooleanNative(
                getObjectPathFromAddress(address), "Trusted", value ? 1 : 0);
    }

    /**
     * Gets the remote device trust state as boolean.
     * Note: this value may be
     * retrieved from cache if we retrieved the data before *
     *
     * @return boolean to indicate trusted or untrusted state
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.194 -0400", hash_original_method = "B11E72D5824FF12533455D86F4958703", hash_generated_method = "57ADFEF61E3055BA87C2094E20821D43")
    
public synchronized boolean getTrustState(String address) {
        if (!BluetoothAdapter.checkBluetoothAddress(address)) {
            mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
            return false;
        }

        String val = mDeviceProperties.getProperty(address, "Trusted");
        if (val == null) {
            return false;
        } else {
            return val.equals("true");
        }
    }

    /**
     * Gets the remote major, minor classes encoded as a 32-bit
     * integer.
     *
     * Note: this value is retrieved from cache, because we get it during
     *       remote-device discovery.
     *
     * @return 32-bit integer encoding the remote major, minor, and service
     *         classes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.195 -0400", hash_original_method = "343BF90A2E911C56028059EA504FAF03", hash_generated_method = "442B6C7984B2A1011EF495F6355DFB1F")
    
public synchronized int getRemoteClass(String address) {
        if (!BluetoothAdapter.checkBluetoothAddress(address)) {
            mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
            return BluetoothClass.ERROR;
        }
        String val = mDeviceProperties.getProperty(address, "Class");
        if (val == null)
            return BluetoothClass.ERROR;
        else {
            return Integer.valueOf(val);
        }
    }

    /**
     * Gets the UUIDs supported by the remote device
     *
     * @return array of 128bit ParcelUuids
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.197 -0400", hash_original_method = "C36A4EF9C1FDEDBCCC8F866C53617610", hash_generated_method = "91EC6D8BB4838C3C85BE60BB0463C9EC")
    
public synchronized ParcelUuid[] getRemoteUuids(String address) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        if (!BluetoothAdapter.checkBluetoothAddress(address)) {
            return null;
        }
        return getUuidFromCache(address);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.199 -0400", hash_original_method = "0FAE8B87A52F1524DF1B793C89A75042", hash_generated_method = "205F19499BFDF19D27791EAC3FF052B7")
    
ParcelUuid[] getUuidFromCache(String address) {
        String value = mDeviceProperties.getProperty(address, "UUIDs");
        if (value == null) return null;

        String[] uuidStrings = null;
        // The UUIDs are stored as a "," separated string.
        uuidStrings = value.split(",");
        ParcelUuid[] uuids = new ParcelUuid[uuidStrings.length];

        for (int i = 0; i < uuidStrings.length; i++) {
            uuids[i] = ParcelUuid.fromString(uuidStrings[i]);
        }
        return uuids;
    }

    /**
     * Connect and fetch new UUID's using SDP.
     * The UUID's found are broadcast as intents.
     * Optionally takes a uuid and callback to fetch the RFCOMM channel for the
     * a given uuid.
     * TODO: Don't wait UUID_INTENT_DELAY to broadcast UUID intents on success
     * TODO: Don't wait UUID_INTENT_DELAY to handle the failure case for
     * callback and broadcast intents.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.200 -0400", hash_original_method = "65AB02636E5EC817DCEA869C92925535", hash_generated_method = "893F683D5D542552F1787323782AF5A0")
    
public synchronized boolean fetchRemoteUuids(String address, ParcelUuid uuid,
            IBluetoothCallback callback) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        if (!isEnabledInternal()) return false;

        if (!BluetoothAdapter.checkBluetoothAddress(address)) {
            return false;
        }

        RemoteService service = new RemoteService(address, uuid);
        if (uuid != null && mUuidCallbackTracker.get(service) != null) {
            // An SDP query for this address & uuid is already in progress
            // Do not add this callback for the uuid
            return false;
        }

        if (mUuidIntentTracker.contains(address)) {
            // An SDP query for this address is already in progress
            // Add this uuid onto the in-progress SDP query
            if (uuid != null) {
                mUuidCallbackTracker.put(new RemoteService(address, uuid), callback);
            }
            return true;
        }

        // If the device is already created, we will
        // do the SDP on the callback of createDeviceNative.
        boolean ret= createDeviceNative(address);

        mUuidIntentTracker.add(address);
        if (uuid != null) {
            mUuidCallbackTracker.put(new RemoteService(address, uuid), callback);
        }

        Message message = mHandler.obtainMessage(MESSAGE_UUID_INTENT);
        message.obj = address;
        mHandler.sendMessageDelayed(message, UUID_INTENT_DELAY);
        return ret;
    }

    /**
     * Gets the rfcomm channel associated with the UUID.
     * Pulls records from the cache only.
     *
     * @param address Address of the remote device
     * @param uuid ParcelUuid of the service attribute
     *
     * @return rfcomm channel associated with the service attribute
     *         -1 on error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.202 -0400", hash_original_method = "852F035ACCA38BD526DD468C3F343C07", hash_generated_method = "B1DF536F6253E56180BA6494FC041248")
    
public int getRemoteServiceChannel(String address, ParcelUuid uuid) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        if (!isEnabledInternal()) return -1;

        if (!BluetoothAdapter.checkBluetoothAddress(address)) {
            return BluetoothDevice.ERROR;
        }
        // Check if we are recovering from a crash.
        if (mDeviceProperties.isEmpty()) {
            if (mDeviceProperties.updateCache(address) == null)
                return -1;
        }

        Map<ParcelUuid, Integer> value = mDeviceServiceChannelCache.get(address);
        if (value != null && value.containsKey(uuid))
            return value.get(uuid);
        return -1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.204 -0400", hash_original_method = "C9BF50CC04E8308D96F8A578A67B2D6B", hash_generated_method = "42F82D9D94E691067EA232C46F24583C")
    
public synchronized boolean setPin(String address, byte[] pin) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                                                "Need BLUETOOTH_ADMIN permission");
        if (!isEnabledInternal()) return false;

        if (pin == null || pin.length <= 0 || pin.length > 16 ||
            !BluetoothAdapter.checkBluetoothAddress(address)) {
            return false;
        }
        address = address.toUpperCase();
        Integer data = mEventLoop.getPasskeyAgentRequestData().remove(address);
        if (data == null) {
            Log.w(TAG, "setPin(" + address + ") called but no native data available, " +
                  "ignoring. Maybe the PasskeyAgent Request was cancelled by the remote device" +
                  " or by bluez.\n");
            return false;
        }
        // bluez API wants pin as a string
        String pinString;
        try {
            pinString = new String(pin, "UTF8");
        } catch (UnsupportedEncodingException uee) {
            Log.e(TAG, "UTF8 not supported?!?");
            return false;
        }
        return setPinNative(address, pinString, data.intValue());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.206 -0400", hash_original_method = "0F844417885E150996691E4D424CC007", hash_generated_method = "9EB9CAACFADE4B042F2BB52E463BFE4F")
    
public synchronized boolean setPasskey(String address, int passkey) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                                                "Need BLUETOOTH_ADMIN permission");
        if (!isEnabledInternal()) return false;

        if (passkey < 0 || passkey > 999999 || !BluetoothAdapter.checkBluetoothAddress(address)) {
            return false;
        }
        address = address.toUpperCase();
        Integer data = mEventLoop.getPasskeyAgentRequestData().remove(address);
        if (data == null) {
            Log.w(TAG, "setPasskey(" + address + ") called but no native data available, " +
                  "ignoring. Maybe the PasskeyAgent Request was cancelled by the remote device" +
                  " or by bluez.\n");
            return false;
        }
        return setPasskeyNative(address, passkey, data.intValue());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.208 -0400", hash_original_method = "312AF34CD05990EE6845980F62B4751D", hash_generated_method = "9010AFBB03888C35C673CAF7FAEF3690")
    
public synchronized boolean setPairingConfirmation(String address, boolean confirm) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                                                "Need BLUETOOTH_ADMIN permission");
        if (!isEnabledInternal()) return false;

        address = address.toUpperCase();
        Integer data = mEventLoop.getPasskeyAgentRequestData().remove(address);
        if (data == null) {
            Log.w(TAG, "setPasskey(" + address + ") called but no native data available, " +
                  "ignoring. Maybe the PasskeyAgent Request was cancelled by the remote device" +
                  " or by bluez.\n");
            return false;
        }
        return setPairingConfirmationNative(address, confirm, data.intValue());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.210 -0400", hash_original_method = "FE36440550BEE071A42E0504FC84677A", hash_generated_method = "07297A404B3734E680C775AE587B5E37")
    
public synchronized boolean setRemoteOutOfBandData(String address) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                                                "Need BLUETOOTH_ADMIN permission");
        if (!isEnabledInternal()) return false;
        address = address.toUpperCase();
        Integer data = mEventLoop.getPasskeyAgentRequestData().remove(address);
        if (data == null) {
            Log.w(TAG, "setRemoteOobData(" + address + ") called but no native data available, " +
                  "ignoring. Maybe the PasskeyAgent Request was cancelled by the remote device" +
                  " or by bluez.\n");
            return false;
        }

        Pair<byte[], byte[]> val = mDeviceOobData.get(address);
        byte[] hash, randomizer;
        if (val == null) {
            // TODO: check what should be passed in this case.
            hash = new byte[16];
            randomizer = new byte[16];
        } else {
            hash = val.first;
            randomizer = val.second;
        }
        return setRemoteOutOfBandDataNative(address, hash, randomizer, data.intValue());
    }

    private class Reaper implements IBinder.DeathRecipient {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.223 -0400", hash_original_field = "939E63817634DEADBC21ADAC3D446EE9", hash_generated_field = "939E63817634DEADBC21ADAC3D446EE9")

        int mPid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.224 -0400", hash_original_field = "BE4FBA339B8964B0ABF1E6F625B8029F", hash_generated_field = "BE4FBA339B8964B0ABF1E6F625B8029F")

        int mHandle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.226 -0400", hash_original_field = "B93BF1EFA6B57CC598632E54B97CD147", hash_generated_field = "B93BF1EFA6B57CC598632E54B97CD147")

        int mType;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.227 -0400", hash_original_method = "9655F9E3B8C9815A28CE4D2A60521164", hash_generated_method = "9655F9E3B8C9815A28CE4D2A60521164")
        
Reaper(int handle, int pid, int type) {
            mPid = pid;
            mHandle = handle;
            mType = type;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.228 -0400", hash_original_method = "70895CF67C58E38897DD01AACB714BC1", hash_generated_method = "70895CF67C58E38897DD01AACB714BC1")
        
Reaper(int pid, int type) {
            mPid = pid;
            mType = type;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.231 -0400", hash_original_method = "5514E1C3E07F1A9EA5F7119EC36AC6B4", hash_generated_method = "C991E8E8FC75AD509AC54E1FEA3E4AF8")
        
@Override
        public void binderDied() {
            synchronized (BluetoothService.this) {
                if (DBG) Log.d(TAG, "Tracked app " + mPid + " died" + "Type:" + mType);
                if (mType == RFCOMM_RECORD_REAPER) {
                    checkAndRemoveRecord(mHandle, mPid);
                } else if (mType == STATE_CHANGE_REAPER) {
                    mStateChangeTracker.remove(mPid);
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.211 -0400", hash_original_method = "2CA0281F3702C9E8C0AA03765C864A62", hash_generated_method = "117F013948ABD6DB918592B7E9623070")
    
public synchronized boolean cancelPairingUserInput(String address) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                                                "Need BLUETOOTH_ADMIN permission");
        if (!isEnabledInternal()) return false;

        if (!BluetoothAdapter.checkBluetoothAddress(address)) {
            return false;
        }
        mBondState.setBondState(address, BluetoothDevice.BOND_NONE,
                BluetoothDevice.UNBOND_REASON_AUTH_CANCELED);
        address = address.toUpperCase();
        Integer data = mEventLoop.getPasskeyAgentRequestData().remove(address);
        if (data == null) {
            Log.w(TAG, "cancelUserInputNative(" + address + ") called but no native data " +
                "available, ignoring. Maybe the PasskeyAgent Request was already cancelled " +
                "by the remote or by bluez.\n");
            return false;
        }
        return cancelPairingUserInputNative(address, data.intValue());
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.214 -0400", hash_original_method = "0D7E002C03DB46F874219BAF964743CF", hash_generated_method = "E9F4E027D985E0FCC3E05C916C392AA3")
    
void updateDeviceServiceChannelCache(String address) {
        if (DBG) Log.d(TAG, "updateDeviceServiceChannelCache(" + address + ")");

        // We are storing the rfcomm channel numbers only for the uuids
        // we are interested in.
        ParcelUuid[] deviceUuids = getRemoteUuids(address);

        ArrayList<ParcelUuid> applicationUuids = new ArrayList<ParcelUuid>();

        synchronized (this) {
            for (RemoteService service : mUuidCallbackTracker.keySet()) {
                if (service.address.equals(address)) {
                    applicationUuids.add(service.uuid);
                }
            }
        }

        Map <ParcelUuid, Integer> uuidToChannelMap = new HashMap<ParcelUuid, Integer>();

        // Retrieve RFCOMM channel for default uuids
        for (ParcelUuid uuid : RFCOMM_UUIDS) {
            if (BluetoothUuid.isUuidPresent(deviceUuids, uuid)) {
                int channel = getDeviceServiceChannelForUuid(address, uuid);
                uuidToChannelMap.put(uuid, channel);
                if (DBG) Log.d(TAG, "\tuuid(system): " + uuid + " " + channel);
            }
        }
        // Retrieve RFCOMM channel for application requested uuids
        for (ParcelUuid uuid : applicationUuids) {
            if (BluetoothUuid.isUuidPresent(deviceUuids, uuid)) {
                int channel = getDeviceServiceChannelForUuid(address, uuid);
                uuidToChannelMap.put(uuid, channel);
                if (DBG) Log.d(TAG, "\tuuid(application): " + uuid + " " + channel);
            }
        }

        synchronized (this) {
            // Make application callbacks
            for (Iterator<RemoteService> iter = mUuidCallbackTracker.keySet().iterator();
                    iter.hasNext();) {
                RemoteService service = iter.next();
                if (service.address.equals(address)) {
                    if (uuidToChannelMap.containsKey(service.uuid)) {
                        int channel = uuidToChannelMap.get(service.uuid);

                        if (DBG) Log.d(TAG, "Making callback for " + service.uuid +
                                    " with result " + channel);
                        IBluetoothCallback callback = mUuidCallbackTracker.get(service);
                        if (callback != null) {
                            try {
                                callback.onRfcommChannelFound(channel);
                            } catch (RemoteException e) {Log.e(TAG, "", e);}
                        }

                        iter.remove();
                    }
                }
            }

            // Update cache
            mDeviceServiceChannelCache.put(address, uuidToChannelMap);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.215 -0400", hash_original_method = "37E03FA6779669B2C9D758DFC4AE47A0", hash_generated_method = "1B0E230EED48460C9595AA3D93038850")
    
private int getDeviceServiceChannelForUuid(String address,
            ParcelUuid uuid) {
        return getDeviceServiceChannelNative(getObjectPathFromAddress(address),
                uuid.toString(), 0x0004);
    }

    /**
     * b is a handle to a Binder instance, so that this service can be notified
     * for Applications that terminate unexpectedly, to clean there service
     * records
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.218 -0400", hash_original_method = "7FC6D92DBB3FA2099CE881A91E960ACF", hash_generated_method = "DFA69983BA330C9F88F2FBEEDDC89058")
    
public synchronized int addRfcommServiceRecord(String serviceName, ParcelUuid uuid,
            int channel, IBinder b) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        if (!isEnabledInternal()) return -1;

        if (serviceName == null || uuid == null || channel < 1 ||
                channel > BluetoothSocket.MAX_RFCOMM_CHANNEL) {
            return -1;
        }
        if (BluetoothUuid.isUuidPresent(BluetoothUuid.RESERVED_UUIDS, uuid)) {
            Log.w(TAG, "Attempted to register a reserved UUID: " + uuid);
            return -1;
        }
        int handle = addRfcommServiceRecordNative(serviceName,
                uuid.getUuid().getMostSignificantBits(), uuid.getUuid().getLeastSignificantBits(),
                (short)channel);
        if (DBG) Log.d(TAG, "new handle " + Integer.toHexString(handle));
        if (handle == -1) {
            return -1;
        }

        ServiceRecordClient client = new ServiceRecordClient();
        client.pid = Binder.getCallingPid();
        client.binder = b;
        client.death = new Reaper(handle, client.pid, RFCOMM_RECORD_REAPER);
        mServiceRecordToPid.put(new Integer(handle), client);
        try {
            b.linkToDeath(client.death, 0);
        } catch (RemoteException e) {
            Log.e(TAG, "", e);
            client.death = null;
        }
        return handle;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.220 -0400", hash_original_method = "2C1CA16BC3FEE2428CFE09168B08FD1A", hash_generated_method = "D2B771755BAFE9EA1ABC18047B1BC6DE")
    
public void removeServiceRecord(int handle) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM,
                                                "Need BLUETOOTH permission");
        // Since this is a binder call check if Bluetooth is off
        if (getBluetoothStateInternal() == BluetoothAdapter.STATE_OFF) return;
        Message message = mHandler.obtainMessage(MESSAGE_REMOVE_SERVICE_RECORD);
        message.obj = new Pair<Integer, Integer>(handle, Binder.getCallingPid());
        mHandler.sendMessage(message);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.221 -0400", hash_original_method = "3C43DA62B148EE129F63715DDA2F724E", hash_generated_method = "37D289A457F1A044135C154889D5115E")
    
private synchronized void checkAndRemoveRecord(int handle, int pid) {
        ServiceRecordClient client = mServiceRecordToPid.get(handle);
        if (client != null && pid == client.pid) {
            if (DBG) Log.d(TAG, "Removing service record " +
                Integer.toHexString(handle) + " for pid " + pid);

            if (client.death != null) {
                client.binder.unlinkToDeath(client.death, 0);
            }

            mServiceRecordToPid.remove(handle);
            removeServiceRecordNative(handle);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.233 -0400", hash_original_method = "0ADF92EDACF4D3EE114023E3EC511C21", hash_generated_method = "979D10954E2D50D4D0BE26DDFBB0280C")
    
@Override
    public boolean changeApplicationBluetoothState(boolean on,
            IBluetoothStateChangeCallback callback, IBinder binder) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");

        int pid = Binder.getCallingPid();
        //mStateChangeTracker is a synchronized map
        if (!mStateChangeTracker.containsKey(pid)) {
            if (on) {
                mStateChangeTracker.put(pid, callback);
            } else {
                return false;
            }
        } else if (!on) {
            mStateChangeTracker.remove(pid);
        }

        if (binder != null) {
            try {
                binder.linkToDeath(new Reaper(pid, STATE_CHANGE_REAPER), 0);
            } catch (RemoteException e) {
                Log.e(TAG, "", e);
                return false;
            }
        }

        int type;
        if (on) {
            type = BluetoothAdapterStateMachine.PER_PROCESS_TURN_ON;
        } else {
            type = BluetoothAdapterStateMachine.PER_PROCESS_TURN_OFF;
        }

        mBluetoothState.sendMessage(type, callback);
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.235 -0400", hash_original_method = "1CCA36BB681B488425D49DF50CAED5FB", hash_generated_method = "1CCA36BB681B488425D49DF50CAED5FB")
    
boolean isApplicationStateChangeTrackerEmpty() {
        return mStateChangeTracker.isEmpty();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.236 -0400", hash_original_method = "461F6D61786F19DEC2FC19D8A240E92E", hash_generated_method = "461F6D61786F19DEC2FC19D8A240E92E")
    
void clearApplicationStateChangeTracker() {
        mStateChangeTracker.clear();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.237 -0400", hash_original_method = "A5BDC5AF3A88F3BD593786E519BD60E7", hash_generated_method = "A5BDC5AF3A88F3BD593786E519BD60E7")
    
Collection<IBluetoothStateChangeCallback> getApplicationStateChangeCallbacks() {
        return mStateChangeTracker.values();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.238 -0400", hash_original_method = "A07BC9680C842A737ABF596D475BB5D5", hash_generated_method = "A07BC9680C842A737ABF596D475BB5D5")
    
int getNumberOfApplicationStateChangeTrackers() {
        return mStateChangeTracker.size();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.245 -0400", hash_original_method = "8A323421C3DE289E5C86ED3091E5E70F", hash_generated_method = "AD51A273A650E59A1A971C6D59316CF7")
    
private void registerForAirplaneMode(IntentFilter filter) {
        final ContentResolver resolver = mContext.getContentResolver();
        final String airplaneModeRadios = Settings.System.getString(resolver,
                Settings.System.AIRPLANE_MODE_RADIOS);
        final String toggleableRadios = Settings.System.getString(resolver,
                Settings.System.AIRPLANE_MODE_TOGGLEABLE_RADIOS);

        mIsAirplaneSensitive = airplaneModeRadios == null ? true :
                airplaneModeRadios.contains(Settings.System.RADIO_BLUETOOTH);
        mIsAirplaneToggleable = toggleableRadios == null ? false :
                toggleableRadios.contains(Settings.System.RADIO_BLUETOOTH);

        if (mIsAirplaneSensitive) {
            filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        }
    }

    /* Returns true if airplane mode is currently on */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.247 -0400", hash_original_method = "7BC7EBE243BAFEA48CC99A450376312B", hash_generated_method = "85E3BCC7DC66425F8AD8B69FEB5812EF")
    
private final boolean isAirplaneModeOn() {
        return Settings.System.getInt(mContext.getContentResolver(),
                Settings.System.AIRPLANE_MODE_ON, 0) == 1;
    }

    /* Broadcast the Uuid intent */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.248 -0400", hash_original_method = "ECBD5C8DA38E2F07674917DA12AADF51", hash_generated_method = "2DC7122DCA70838E386B53D67E0C0DBD")
    
synchronized void sendUuidIntent(String address) {
        ParcelUuid[] uuid = getUuidFromCache(address);
        Intent intent = new Intent(BluetoothDevice.ACTION_UUID);
        intent.putExtra(BluetoothDevice.EXTRA_DEVICE, mAdapter.getRemoteDevice(address));
        intent.putExtra(BluetoothDevice.EXTRA_UUID, uuid);
        mContext.sendBroadcast(intent, BLUETOOTH_ADMIN_PERM);
        mUuidIntentTracker.remove(address);
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.250 -0400", hash_original_method = "5FEC94A0A6540756F179E63B243F938B", hash_generated_method = "D15C574CE6D051E8DFA79206F3C1E1B8")
    
synchronized void makeServiceChannelCallbacks(String address) {
        for (Iterator<RemoteService> iter = mUuidCallbackTracker.keySet().iterator();
                iter.hasNext();) {
            RemoteService service = iter.next();
            if (service.address.equals(address)) {
                if (DBG) Log.d(TAG, "Cleaning up failed UUID channel lookup: "
                    + service.address + " " + service.uuid);
                IBluetoothCallback callback = mUuidCallbackTracker.get(service);
                if (callback != null) {
                    try {
                        callback.onRfcommChannelFound(-1);
                    } catch (RemoteException e) {Log.e(TAG, "", e);}
                }

                iter.remove();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.251 -0400", hash_original_method = "F8EA8E651A7516C25371575C21E6807A", hash_generated_method = "32DF57232E0DAE58595FA920A8AB0E14")
    
@Override
    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (getBluetoothStateInternal() != BluetoothAdapter.STATE_ON) {
            return;
        }

        pw.println("mIsAirplaneSensitive = " + mIsAirplaneSensitive);
        pw.println("mIsAirplaneToggleable = " + mIsAirplaneToggleable);

        pw.println("Local address = " + getAddress());
        pw.println("Local name = " + getName());
        pw.println("isDiscovering() = " + isDiscovering());

        mAdapter.getProfileProxy(mContext,
                                 mBluetoothProfileServiceListener, BluetoothProfile.HEADSET);
        mAdapter.getProfileProxy(mContext,
                mBluetoothProfileServiceListener, BluetoothProfile.INPUT_DEVICE);
        mAdapter.getProfileProxy(mContext,
                mBluetoothProfileServiceListener, BluetoothProfile.PAN);

        dumpKnownDevices(pw);
        dumpAclConnectedDevices(pw);
        dumpHeadsetService(pw);
        dumpInputDeviceProfile(pw);
        dumpPanProfile(pw);
        dumpApplicationServiceRecords(pw);
        dumpProfileState(pw);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.253 -0400", hash_original_method = "069CD9A5D345A6988A60E1973C10DD14", hash_generated_method = "B304C3D6BDBD5F45DCAA71587A96E509")
    
private void dumpProfileState(PrintWriter pw) {
        pw.println("\n--Profile State dump--");
        pw.println("\n Headset profile state:" +
                mAdapter.getProfileConnectionState(BluetoothProfile.HEADSET));
        pw.println("\n A2dp profile state:" +
                mAdapter.getProfileConnectionState(BluetoothProfile.A2DP));
        pw.println("\n HID profile state:" +
                mAdapter.getProfileConnectionState(BluetoothProfile.INPUT_DEVICE));
        pw.println("\n PAN profile state:" +
                mAdapter.getProfileConnectionState(BluetoothProfile.PAN));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.255 -0400", hash_original_method = "4B96DC18CDB88F6D05CF06AE37F3F8A7", hash_generated_method = "1D2939ADDFEBDBBDE1E2EEF21CB2511A")
    
private void dumpHeadsetService(PrintWriter pw) {
        pw.println("\n--Headset Service--");
        if (mHeadsetProxy != null) {
            List<BluetoothDevice> deviceList = mHeadsetProxy.getConnectedDevices();
            if (deviceList.size() == 0) {
                pw.println("No headsets connected");
            } else {
                BluetoothDevice device = deviceList.get(0);
                pw.println("\ngetConnectedDevices[0] = " + device);
                dumpHeadsetConnectionState(pw, device);
                pw.println("getBatteryUsageHint() = " +
                             mHeadsetProxy.getBatteryUsageHint(device));
            }

            deviceList.clear();
            deviceList = mHeadsetProxy.getDevicesMatchingConnectionStates(new int[] {
                     BluetoothProfile.STATE_CONNECTED, BluetoothProfile.STATE_DISCONNECTED});
            pw.println("--Connected and Disconnected Headsets");
            for (BluetoothDevice device: deviceList) {
                pw.println(device);
                if (mHeadsetProxy.isAudioConnected(device)) {
                    pw.println("SCO audio connected to device:" + device);
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.257 -0400", hash_original_method = "4D4920FDD73544B3D6EEA2CB10278364", hash_generated_method = "CC75AB83B75A7ADB4344549C4D720DAD")
    
private void dumpInputDeviceProfile(PrintWriter pw) {
        pw.println("\n--Bluetooth Service- Input Device Profile");
        if (mInputDevice != null) {
            List<BluetoothDevice> deviceList = mInputDevice.getConnectedDevices();
            if (deviceList.size() == 0) {
                pw.println("No input devices connected");
            } else {
                pw.println("Number of connected devices:" + deviceList.size());
                BluetoothDevice device = deviceList.get(0);
                pw.println("getConnectedDevices[0] = " + device);
                pw.println("Priority of Connected device = " + mInputDevice.getPriority(device));

                switch (mInputDevice.getConnectionState(device)) {
                    case BluetoothInputDevice.STATE_CONNECTING:
                        pw.println("getConnectionState() = STATE_CONNECTING");
                        break;
                    case BluetoothInputDevice.STATE_CONNECTED:
                        pw.println("getConnectionState() = STATE_CONNECTED");
                        break;
                    case BluetoothInputDevice.STATE_DISCONNECTING:
                        pw.println("getConnectionState() = STATE_DISCONNECTING");
                        break;
                }
            }
            deviceList.clear();
            deviceList = mInputDevice.getDevicesMatchingConnectionStates(new int[] {
                     BluetoothProfile.STATE_CONNECTED, BluetoothProfile.STATE_DISCONNECTED});
            pw.println("--Connected and Disconnected input devices");
            for (BluetoothDevice device: deviceList) {
                pw.println(device);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.259 -0400", hash_original_method = "635021BDEE7D67AAE2996F59E87DB245", hash_generated_method = "BCD1EDE6BFF8095CA6D648E15CE4D420")
    
private void dumpPanProfile(PrintWriter pw) {
        pw.println("\n--Bluetooth Service- Pan Profile");
        if (mPan != null) {
            List<BluetoothDevice> deviceList = mPan.getConnectedDevices();
            if (deviceList.size() == 0) {
                pw.println("No Pan devices connected");
            } else {
                pw.println("Number of connected devices:" + deviceList.size());
                BluetoothDevice device = deviceList.get(0);
                pw.println("getConnectedDevices[0] = " + device);

                switch (mPan.getConnectionState(device)) {
                    case BluetoothInputDevice.STATE_CONNECTING:
                        pw.println("getConnectionState() = STATE_CONNECTING");
                        break;
                    case BluetoothInputDevice.STATE_CONNECTED:
                        pw.println("getConnectionState() = STATE_CONNECTED");
                        break;
                    case BluetoothInputDevice.STATE_DISCONNECTING:
                        pw.println("getConnectionState() = STATE_DISCONNECTING");
                        break;
                }
            }
            deviceList.clear();
            deviceList = mPan.getDevicesMatchingConnectionStates(new int[] {
                     BluetoothProfile.STATE_CONNECTED, BluetoothProfile.STATE_DISCONNECTED});
            pw.println("--Connected and Disconnected Pan devices");
            for (BluetoothDevice device: deviceList) {
                pw.println(device);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.261 -0400", hash_original_method = "C53B3373F2C861229321041DF6EBC444", hash_generated_method = "48068A9F0899C339ED73EF5FF8EB80D3")
    
private void dumpHeadsetConnectionState(PrintWriter pw,
            BluetoothDevice device) {
        switch (mHeadsetProxy.getConnectionState(device)) {
            case BluetoothHeadset.STATE_CONNECTING:
                pw.println("getConnectionState() = STATE_CONNECTING");
                break;
            case BluetoothHeadset.STATE_CONNECTED:
                pw.println("getConnectionState() = STATE_CONNECTED");
                break;
            case BluetoothHeadset.STATE_DISCONNECTING:
                pw.println("getConnectionState() = STATE_DISCONNECTING");
                break;
            case BluetoothHeadset.STATE_AUDIO_CONNECTED:
                pw.println("getConnectionState() = STATE_AUDIO_CONNECTED");
                break;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.262 -0400", hash_original_method = "D498AF2711704161B117F34B0FF6D522", hash_generated_method = "5F0E37A796DE214928BA934D27B20104")
    
private void dumpApplicationServiceRecords(PrintWriter pw) {
        pw.println("\n--Application Service Records--");
        for (Integer handle : mServiceRecordToPid.keySet()) {
            Integer pid = mServiceRecordToPid.get(handle).pid;
            pw.println("\tpid " + pid + " handle " + Integer.toHexString(handle));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.264 -0400", hash_original_method = "C451B65D9445476422486F244DAE5E1A", hash_generated_method = "7D4117575BA18540FA5978D00AA874C2")
    
private void dumpAclConnectedDevices(PrintWriter pw) {
        String[] devicesObjectPath = getKnownDevices();
        pw.println("\n--ACL connected devices--");
        if (devicesObjectPath != null) {
            for (String device : devicesObjectPath) {
                pw.println(getAddressFromObjectPath(device));
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.266 -0400", hash_original_method = "EA9144C62834197D01D5A4610D7087A7", hash_generated_method = "1697961759376EE269D7AE6B33D5BB87")
    
private void dumpKnownDevices(PrintWriter pw) {
        pw.println("\n--Known devices--");
        for (String address : mDeviceProperties.keySet()) {
            int bondState = mBondState.getBondState(address);
            pw.printf("%s %10s (%d) %s\n", address,
                       toBondStateString(bondState),
                       mBondState.getAttempt(address),
                       getRemoteName(address));

            Map<ParcelUuid, Integer> uuidChannels = mDeviceServiceChannelCache.get(address);
            if (uuidChannels == null) {
                pw.println("\tuuids = null");
            } else {
                for (ParcelUuid uuid : uuidChannels.keySet()) {
                    Integer channel = uuidChannels.get(uuid);
                    if (channel == null) {
                        pw.println("\t" + uuid);
                    } else {
                        pw.println("\t" + uuid + " RFCOMM channel = " + channel);
                    }
                }
            }
            for (RemoteService service : mUuidCallbackTracker.keySet()) {
                if (service.address.equals(address)) {
                    pw.println("\tPENDING CALLBACK: " + service.uuid);
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.267 -0400", hash_original_method = "07865561E94E709B9D9200234F388638", hash_generated_method = "64724804B2ED53872038BBC109904897")
    
private void getProfileProxy() {
        mAdapter.getProfileProxy(mContext,
                                 mBluetoothProfileServiceListener, BluetoothProfile.HEADSET);
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.278 -0400", hash_original_method = "FE6D392CED64513F6E1A37856F79DD2B", hash_generated_method = "FE6D392CED64513F6E1A37856F79DD2B")
    
String getAddressFromObjectPath(String objectPath) {
        String adapterObjectPath = mAdapterProperties.getObjectPath();
        if (adapterObjectPath == null || objectPath == null) {
            Log.e(TAG, "getAddressFromObjectPath: AdapterObjectPath:" + adapterObjectPath +
                    "  or deviceObjectPath:" + objectPath + " is null");
            return null;
        }
        if (!objectPath.startsWith(adapterObjectPath)) {
            Log.e(TAG, "getAddressFromObjectPath: AdapterObjectPath:" + adapterObjectPath +
                    "  is not a prefix of deviceObjectPath:" + objectPath +
                    "bluetoothd crashed ?");
            return null;
        }
        String address = objectPath.substring(adapterObjectPath.length());
        if (address != null) return address.replace('_', ':');

        Log.e(TAG, "getAddressFromObjectPath: Address being returned is null");
        return null;
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.279 -0400", hash_original_method = "81E16596DE502DA6A23BE493A199F111", hash_generated_method = "81E16596DE502DA6A23BE493A199F111")
    
String getObjectPathFromAddress(String address) {
        String path = mAdapterProperties.getObjectPath();
        if (path == null) {
            Log.e(TAG, "Error: Object Path is null");
            return null;
        }
        path = path + address.replace(":", "_");
        return path;
    }

    /*package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.281 -0400", hash_original_method = "02DE340E3002939D33D0294B23BC266D", hash_generated_method = "02DE340E3002939D33D0294B23BC266D")
    
void setLinkTimeout(String address, int num_slots) {
        String path = getObjectPathFromAddress(address);
        boolean result = setLinkTimeoutNative(path, num_slots);

        if (!result) Log.d(TAG, "Set Link Timeout to " + num_slots + " slots failed");
    }

    /**** Handlers for PAN  Profile ****/
    // TODO: This needs to be converted to a state machine.

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.282 -0400", hash_original_method = "3DD1F54AED9C9361A6A54B10F128DAE9", hash_generated_method = "3FB8B09BDF3878CD331AF8E6EEE97886")
    
public boolean isTetheringOn() {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        synchronized (mBluetoothPanProfileHandler) {
            return mBluetoothPanProfileHandler.isTetheringOn();
        }
    }

    /*package*/@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.284 -0400", hash_original_method = "7F896385C3BE669934C89EFC725FF4D9", hash_generated_method = "7F896385C3BE669934C89EFC725FF4D9")
    
boolean allowIncomingTethering() {
        synchronized (mBluetoothPanProfileHandler) {
            return mBluetoothPanProfileHandler.allowIncomingTethering();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.285 -0400", hash_original_method = "A7D58A889EE2A0CEECFCBDCBD15E8C19", hash_generated_method = "83DE1AD7AB00AB2DF821DA59B0493F48")
    
public void setBluetoothTethering(boolean value) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        synchronized (mBluetoothPanProfileHandler) {
            mBluetoothPanProfileHandler.setBluetoothTethering(value);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.286 -0400", hash_original_method = "BF6E73B0A9286448E722240B693C1103", hash_generated_method = "517B71D568BCF86C2DD4DD42A32FEF5E")
    
public int getPanDeviceConnectionState(BluetoothDevice device) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        synchronized (mBluetoothPanProfileHandler) {
            return mBluetoothPanProfileHandler.getPanDeviceConnectionState(device);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.288 -0400", hash_original_method = "1929E88290C8855AA8FBEB3E7EBEDC3F", hash_generated_method = "45ACA77E414D4189CB3A976BC96709E9")
    
public boolean connectPanDevice(BluetoothDevice device) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
            "Need BLUETOOTH_ADMIN permission");
        synchronized (mBluetoothPanProfileHandler) {
            return mBluetoothPanProfileHandler.connectPanDevice(device);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.289 -0400", hash_original_method = "4960C28A06526493C361E21E58C445C0", hash_generated_method = "EA2A315274CA2488A80F3424A80FDC53")
    
public List<BluetoothDevice> getConnectedPanDevices() {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        synchronized (mBluetoothPanProfileHandler) {
            return mBluetoothPanProfileHandler.getConnectedPanDevices();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.291 -0400", hash_original_method = "1B5F774BB54CD57CE1D2F0EA76826869", hash_generated_method = "15979D650F87DAC1F7E8C0748CACE5E0")
    
public List<BluetoothDevice> getPanDevicesMatchingConnectionStates(
            int[] states) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        synchronized (mBluetoothPanProfileHandler) {
            return mBluetoothPanProfileHandler.getPanDevicesMatchingConnectionStates(states);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.293 -0400", hash_original_method = "26B9032E09D73882F89A60CFE9F2AAFB", hash_generated_method = "0EA2DA7A0868C5B494D1AC9E4AD4495B")
    
public boolean disconnectPanDevice(BluetoothDevice device) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
            "Need BLUETOOTH_ADMIN permission");
        synchronized (mBluetoothPanProfileHandler) {
            return mBluetoothPanProfileHandler.disconnectPanDevice(device);
        }
    }

    /*package*/@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.294 -0400", hash_original_method = "52890D46F939D59B5CED0DB7BD8C7E20", hash_generated_method = "52890D46F939D59B5CED0DB7BD8C7E20")
    
void handlePanDeviceStateChange(BluetoothDevice device,
                                                             String iface,
                                                             int state,
                                                             int role) {
        synchronized (mBluetoothPanProfileHandler) {
            mBluetoothPanProfileHandler.handlePanDeviceStateChange(device, iface, state, role);
        }
    }

    /*package*/@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.295 -0400", hash_original_method = "E1719DF908884EEBDB37A4B5087FBE41", hash_generated_method = "E1719DF908884EEBDB37A4B5087FBE41")
    
void handlePanDeviceStateChange(BluetoothDevice device,
                                                             int state, int role) {
        synchronized (mBluetoothPanProfileHandler) {
            mBluetoothPanProfileHandler.handlePanDeviceStateChange(device, null, state, role);
        }
    }

    /**** Handlers for Input Device Profile ****/
    // This needs to be converted to state machine

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.296 -0400", hash_original_method = "0F984CED9FC66315B02837114DDE7991", hash_generated_method = "F7FDE07C39E100578759DE5512B61C47")
    
public boolean connectInputDevice(BluetoothDevice device) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                                                "Need BLUETOOTH_ADMIN permission");
        BluetoothDeviceProfileState state = mDeviceProfileState.get(device.getAddress());
        synchronized (mBluetoothInputProfileHandler) {
            return mBluetoothInputProfileHandler.connectInputDevice(device, state);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.298 -0400", hash_original_method = "D22DEB954343FF61189186A7E61A20F8", hash_generated_method = "74FFEA8AF4AE0EFDBE583792C37B9CA5")
    
public boolean connectInputDeviceInternal(BluetoothDevice device) {
        synchronized (mBluetoothInputProfileHandler) {
            return mBluetoothInputProfileHandler.connectInputDeviceInternal(device);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.299 -0400", hash_original_method = "27F4F3695DD975B61D8EE49CA42AA6F3", hash_generated_method = "382FD80FF588FEED3ECA518901692150")
    
public boolean disconnectInputDevice(BluetoothDevice device) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                                                "Need BLUETOOTH_ADMIN permission");
        BluetoothDeviceProfileState state = mDeviceProfileState.get(device.getAddress());
        synchronized (mBluetoothInputProfileHandler) {
            return mBluetoothInputProfileHandler.disconnectInputDevice(device, state);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.301 -0400", hash_original_method = "B398BA77C2D143FA0FB53ECC4C1D5C7C", hash_generated_method = "42A95EE6A4025E8C3D57ABE9CFE3F4AF")
    
public boolean disconnectInputDeviceInternal(BluetoothDevice device) {
        synchronized (mBluetoothInputProfileHandler) {
            return mBluetoothInputProfileHandler.disconnectInputDeviceInternal(device);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.302 -0400", hash_original_method = "FB346AA82CA387885770BEF8FAB372A7", hash_generated_method = "050F9685A28EE531AD618FFB36E55D6D")
    
public int getInputDeviceConnectionState(BluetoothDevice device) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        synchronized (mBluetoothInputProfileHandler) {
            return mBluetoothInputProfileHandler.getInputDeviceConnectionState(device);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.303 -0400", hash_original_method = "34BA1AE02D4D52BA113CD64B8544E016", hash_generated_method = "0ECB5D3F2C9EC6B796AB1DD7969D5375")
    
public List<BluetoothDevice> getConnectedInputDevices() {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        synchronized (mBluetoothInputProfileHandler) {
            return mBluetoothInputProfileHandler.getConnectedInputDevices();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.306 -0400", hash_original_method = "0008EE2904745F42BC662657A81D2E7A", hash_generated_method = "1C3F57A8C4E50A2C45C4F016163B51DE")
    
public List<BluetoothDevice> getInputDevicesMatchingConnectionStates(
            int[] states) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        synchronized (mBluetoothInputProfileHandler) {
            return mBluetoothInputProfileHandler.getInputDevicesMatchingConnectionStates(states);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.307 -0400", hash_original_method = "5AFD014B71CB9B54A1E4186067850654", hash_generated_method = "E445287B04F7E687D71E5A35C8E9EF8A")
    
public int getInputDevicePriority(BluetoothDevice device) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        synchronized (mBluetoothInputProfileHandler) {
            return mBluetoothInputProfileHandler.getInputDevicePriority(device);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.308 -0400", hash_original_method = "E0E6465D48FD14B54225DA94814D4F33", hash_generated_method = "74A99BEFF8CC8A77C38D12C206C76509")
    
public boolean setInputDevicePriority(BluetoothDevice device, int priority) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                                                "Need BLUETOOTH_ADMIN permission");
        synchronized (mBluetoothInputProfileHandler) {
            return mBluetoothInputProfileHandler.setInputDevicePriority(device, priority);
        }
    }

    /**
     * Handle incoming profile acceptance for profiles handled by Bluetooth Service,
     * currently PAN and HID. This also is the catch all for all rejections for profiles
     * that is not supported.
     *
     * @param device - Bluetooth Device
     * @param allow - true / false
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.310 -0400", hash_original_method = "C7EC27F6C535E2F7646C4BA491ACC443", hash_generated_method = "12A90F56CF900ACFEF3FEE04D7E1202E")
    
public boolean allowIncomingProfileConnect(BluetoothDevice device, boolean allow) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                                                "Need BLUETOOTH_ADMIN permission");
        String address = device.getAddress();
        if (!BluetoothAdapter.checkBluetoothAddress(address)) {
            return false;
        }

        Integer data = getAuthorizationAgentRequestData(address);
        if (data == null) {
            Log.w(TAG, "allowIncomingProfileConnect(" + device +
                  ") called but no native data available");
            return false;
        }
        if (DBG) log("allowIncomingProfileConnect: " + device + " : " + allow + " : " + data);
        return setAuthorizationNative(address, allow, data.intValue());
    }

    /*package*/@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.311 -0400", hash_original_method = "15723C521E563AFB3C6FCD09047A3488", hash_generated_method = "15723C521E563AFB3C6FCD09047A3488")
    
List<BluetoothDevice> lookupInputDevicesMatchingStates(int[] states) {
        synchronized (mBluetoothInputProfileHandler) {
            return mBluetoothInputProfileHandler.lookupInputDevicesMatchingStates(states);
        }
    }

    /*package*/@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.313 -0400", hash_original_method = "9697590C77FDCD56ED115A513004CF63", hash_generated_method = "9697590C77FDCD56ED115A513004CF63")
    
void handleInputDevicePropertyChange(String address, boolean connected) {
        synchronized (mBluetoothInputProfileHandler) {
            mBluetoothInputProfileHandler.handleInputDevicePropertyChange(address, connected);
        }
    }

    /**** Handlers for Health Device Profile ****/
    // TODO: All these need to be converted to a state machine.

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.314 -0400", hash_original_method = "9C46F100D983FBF5A1EA8297108892F0", hash_generated_method = "24CBDED522415CF4427BE01F6A6BE06D")
    
public boolean registerAppConfiguration(BluetoothHealthAppConfiguration config,
                                            IBluetoothHealthCallback callback) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM,
                "Need BLUETOOTH permission");
        synchronized (mBluetoothHealthProfileHandler) {
                return mBluetoothHealthProfileHandler.registerAppConfiguration(config, callback);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.316 -0400", hash_original_method = "9834B6CFE3B5712C76DD58DAAB284708", hash_generated_method = "1615F4AD895F596788323BD8C49FF18F")
    
public boolean unregisterAppConfiguration(BluetoothHealthAppConfiguration config) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM,
                "Need BLUETOOTH permission");
        synchronized (mBluetoothHealthProfileHandler) {
                return mBluetoothHealthProfileHandler.unregisterAppConfiguration(config);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.317 -0400", hash_original_method = "FF1E0430494F5A124A3423CB184A118C", hash_generated_method = "DE697A6E025E09E7F09DF2549E9CBAB7")
    
public boolean connectChannelToSource(BluetoothDevice device,
            BluetoothHealthAppConfiguration config) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM,
                "Need BLUETOOTH permission");
        synchronized (mBluetoothHealthProfileHandler) {
            return mBluetoothHealthProfileHandler.connectChannelToSource(device,
                    config);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.319 -0400", hash_original_method = "22C2ACBCD25AEE243AF234493CBE5623", hash_generated_method = "80F54D8FE8CA87A3941BC86CD83E4438")
    
public boolean connectChannelToSink(BluetoothDevice device,
            BluetoothHealthAppConfiguration config, int channelType) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM,
                                                "Need BLUETOOTH permission");
        synchronized (mBluetoothHealthProfileHandler) {
            return mBluetoothHealthProfileHandler.connectChannel(device, config,
                    channelType);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.320 -0400", hash_original_method = "9FA5D1864DD2E9E1F52304B14054BAA2", hash_generated_method = "5DB2438BFC4E63E821011F3CF042300A")
    
public boolean disconnectChannel(BluetoothDevice device,
            BluetoothHealthAppConfiguration config, int id) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM,
                "Need BLUETOOTH permission");
        synchronized (mBluetoothHealthProfileHandler) {
            return mBluetoothHealthProfileHandler.disconnectChannel(device, config, id);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.322 -0400", hash_original_method = "68F1BDA4C2326D0725DAE72195AF95F7", hash_generated_method = "4CEF36A8C7280269872296B784631256")
    
public ParcelFileDescriptor getMainChannelFd(BluetoothDevice device,
            BluetoothHealthAppConfiguration config) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM,
                "Need BLUETOOTH permission");
        synchronized (mBluetoothHealthProfileHandler) {
            return mBluetoothHealthProfileHandler.getMainChannelFd(device, config);
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.323 -0400", hash_original_method = "C669F579BDB788D294CE641E5C8C3961", hash_generated_method = "C669F579BDB788D294CE641E5C8C3961")
    
void onHealthDevicePropertyChanged(String devicePath,
            String channelPath) {
        synchronized (mBluetoothHealthProfileHandler) {
            mBluetoothHealthProfileHandler.onHealthDevicePropertyChanged(devicePath,
                    channelPath);
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.324 -0400", hash_original_method = "790426439EF38DE0E19717BB37E5C5B6", hash_generated_method = "790426439EF38DE0E19717BB37E5C5B6")
    
void onHealthDeviceChannelChanged(String devicePath,
            String channelPath, boolean exists) {
        synchronized(mBluetoothHealthProfileHandler) {
            mBluetoothHealthProfileHandler.onHealthDeviceChannelChanged(devicePath,
                    channelPath, exists);
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.326 -0400", hash_original_method = "F062A7103F5D063A66B102C6B54AA5F0", hash_generated_method = "F062A7103F5D063A66B102C6B54AA5F0")
    
void onHealthDeviceChannelConnectionError(int channelCode,
            int newState) {
        synchronized(mBluetoothHealthProfileHandler) {
            mBluetoothHealthProfileHandler.onHealthDeviceChannelConnectionError(channelCode,
                                                                                newState);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.328 -0400", hash_original_method = "9FA991244C9B8A2D2050E9D5CB1161A4", hash_generated_method = "417593B6AACC50A4A937198A26A754D6")
    
public int getHealthDeviceConnectionState(BluetoothDevice device) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM,
                "Need BLUETOOTH permission");
        synchronized (mBluetoothHealthProfileHandler) {
            return mBluetoothHealthProfileHandler.getHealthDeviceConnectionState(device);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.330 -0400", hash_original_method = "5520FB01AB03A01B8EDBC41EA08C6319", hash_generated_method = "61F231A4B25EF12E47C53FF9D0CC5E2C")
    
public List<BluetoothDevice> getConnectedHealthDevices() {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM,
                "Need BLUETOOTH permission");
        synchronized (mBluetoothHealthProfileHandler) {
            return mBluetoothHealthProfileHandler.getConnectedHealthDevices();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.331 -0400", hash_original_method = "050A475A7DE1778DF88FF07FE15C160E", hash_generated_method = "B983D616F8533C483AA48B5FCFA464C2")
    
public List<BluetoothDevice> getHealthDevicesMatchingConnectionStates(
            int[] states) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM,
                "Need BLUETOOTH permission");
        synchronized (mBluetoothHealthProfileHandler) {
            return mBluetoothHealthProfileHandler.
                    getHealthDevicesMatchingConnectionStates(states);
        }
    }

    /*package*/@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.332 -0400", hash_original_method = "5784FFA3B31D30F076436227852190A0", hash_generated_method = "5784FFA3B31D30F076436227852190A0")
    
boolean notifyIncomingHidConnection(String address) {
        BluetoothDeviceProfileState state = mDeviceProfileState.get(address);
        if (state == null) {
            return false;
        }
        Message msg = new Message();
        msg.what = BluetoothDeviceProfileState.CONNECT_HID_INCOMING;
        state.sendMessage(msg);
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.334 -0400", hash_original_method = "5B771187760913E64124FA8379DE59F7", hash_generated_method = "731AA8D139A74F065DCCB66D5F65AB39")
    
public boolean connectHeadset(String address) {
        if (getBondState(address) != BluetoothDevice.BOND_BONDED) return false;

        BluetoothDeviceProfileState state = mDeviceProfileState.get(address);
        if (state != null) {
            Message msg = new Message();
            msg.arg1 = BluetoothDeviceProfileState.CONNECT_HFP_OUTGOING;
            msg.obj = state;
            mHfpProfileState.sendMessage(msg);
            return true;
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.336 -0400", hash_original_method = "E566F508CB021C1FCABA0572A74D542E", hash_generated_method = "A28AEA65C284026F2957FBE507727493")
    
public boolean disconnectHeadset(String address) {
        if (getBondState(address) != BluetoothDevice.BOND_BONDED) return false;

        BluetoothDeviceProfileState state = mDeviceProfileState.get(address);
        if (state != null) {
            Message msg = new Message();
            msg.arg1 = BluetoothDeviceProfileState.DISCONNECT_HFP_OUTGOING;
            msg.obj = state;
            mHfpProfileState.sendMessage(msg);
            return true;
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.337 -0400", hash_original_method = "5B97487C62043236E162E3103C36FBC2", hash_generated_method = "51AD369D2FDBF83B4AEBFC52FB6F4AB2")
    
public boolean connectSink(String address) {
        if (getBondState(address) != BluetoothDevice.BOND_BONDED) return false;

        BluetoothDeviceProfileState state = mDeviceProfileState.get(address);
        if (state != null) {
            Message msg = new Message();
            msg.arg1 = BluetoothDeviceProfileState.CONNECT_A2DP_OUTGOING;
            msg.obj = state;
            mA2dpProfileState.sendMessage(msg);
            return true;
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.338 -0400", hash_original_method = "82B6A9BBBB7DF451DE61A150D18324E4", hash_generated_method = "C984A2E876803334262D578E97F5D2D9")
    
public boolean disconnectSink(String address) {
        if (getBondState(address) != BluetoothDevice.BOND_BONDED) return false;

        BluetoothDeviceProfileState state = mDeviceProfileState.get(address);
        if (state != null) {
            Message msg = new Message();
            msg.arg1 = BluetoothDeviceProfileState.DISCONNECT_A2DP_OUTGOING;
            msg.obj = state;
            mA2dpProfileState.sendMessage(msg);
            return true;
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.340 -0400", hash_original_method = "68FB3079B9F920D81530196E14C2A3F5", hash_generated_method = "68FB3079B9F920D81530196E14C2A3F5")
    
BluetoothDeviceProfileState addProfileState(String address, boolean setTrust) {
        BluetoothDeviceProfileState state =
            new BluetoothDeviceProfileState(mContext, address, this, mA2dpService, setTrust);
        mDeviceProfileState.put(address, state);
        state.start();
        return state;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.341 -0400", hash_original_method = "2C556BF67B941BE52FF84A3B927E6A34", hash_generated_method = "2C556BF67B941BE52FF84A3B927E6A34")
    
void removeProfileState(String address) {
        BluetoothDeviceProfileState state = mDeviceProfileState.get(address);
        if (state == null) return;

        state.quit();
        mDeviceProfileState.remove(address);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.342 -0400", hash_original_method = "F864A78FEB90BB64BBA7627AC93483C6", hash_generated_method = "F864A78FEB90BB64BBA7627AC93483C6")
    
String[] getKnownDevices() {
        String[] bonds = null;
        String val = getProperty("Devices", true);
        if (val != null) {
            bonds = val.split(",");
        }
        return bonds;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.344 -0400", hash_original_method = "6752B4AF0E84EF8437B46B7E569C39DF", hash_generated_method = "1DCD951C01E4CE945AAA71A0AC0F44B4")
    
private void initProfileState() {
        String[] bonds = null;
        String val = getProperty("Devices", false);
        if (val != null) {
            bonds = val.split(",");
        }
        if (bonds == null) {
            return;
        }
        for (String path : bonds) {
            String address = getAddressFromObjectPath(path);
            BluetoothDeviceProfileState state = addProfileState(address, false);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.345 -0400", hash_original_method = "21D28E4A32187963C020794F1ACD2292", hash_generated_method = "80038D7523BD4609B25DE37C95CCE828")
    
private void autoConnect() {
        String[] bonds = getKnownDevices();
        if (bonds == null) {
            return;
        }
        for (String path : bonds) {
            String address = getAddressFromObjectPath(path);
            BluetoothDeviceProfileState state = mDeviceProfileState.get(address);
            if (state != null) {
                Message msg = new Message();
                msg.what = BluetoothDeviceProfileState.AUTO_CONNECT_PROFILES;
                state.sendMessage(msg);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.347 -0400", hash_original_method = "D547A1EE0DD247287FF460249ED1C2E7", hash_generated_method = "4676C3D82130703C8AEE5A73D5651426")
    
public boolean notifyIncomingConnection(String address, boolean rejected) {
        BluetoothDeviceProfileState state = mDeviceProfileState.get(address);
        if (state != null) {
            Message msg = new Message();
            if (rejected) {
                if (mA2dpService.getPriority(getRemoteDevice(address)) >=
                    BluetoothProfile.PRIORITY_ON) {
                    msg.what = BluetoothDeviceProfileState.CONNECT_OTHER_PROFILES;
                    msg.arg1 = BluetoothDeviceProfileState.CONNECT_A2DP_OUTGOING;
                    state.sendMessageDelayed(msg,
                        BluetoothDeviceProfileState.CONNECT_OTHER_PROFILES_DELAY);
                }
            } else {
                msg.what = BluetoothDeviceProfileState.CONNECT_HFP_INCOMING;
                state.sendMessage(msg);
            }
            return true;
        }
        return false;
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.348 -0400", hash_original_method = "4CD97EA7E950BF004E7EC6B6495D64E5", hash_generated_method = "4CD97EA7E950BF004E7EC6B6495D64E5")
    
boolean notifyIncomingA2dpConnection(String address, boolean rejected) {
       BluetoothDeviceProfileState state = mDeviceProfileState.get(address);
       if (state != null) {
           Message msg = new Message();
           if (rejected) {
               if (mHeadsetProxy.getPriority(getRemoteDevice(address)) >=
                   BluetoothProfile.PRIORITY_ON) {
                   msg.what = BluetoothDeviceProfileState.CONNECT_OTHER_PROFILES;
                   msg.arg1 = BluetoothDeviceProfileState.CONNECT_HFP_OUTGOING;
                   state.sendMessageDelayed(msg,
                             BluetoothDeviceProfileState.CONNECT_OTHER_PROFILES_DELAY);
               }
           } else {
               msg.what = BluetoothDeviceProfileState.CONNECT_A2DP_INCOMING;
               state.sendMessage(msg);
           }
           return true;
       }
       return false;
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.350 -0400", hash_original_method = "09E7859FE9FEBA70B7D1DCA731E38597", hash_generated_method = "09E7859FE9FEBA70B7D1DCA731E38597")
    
void setA2dpService(BluetoothA2dpService a2dpService) {
        mA2dpService = a2dpService;
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.351 -0400", hash_original_method = "5AE1DF68506B5082741365BC3C4DEEF0", hash_generated_method = "5AE1DF68506B5082741365BC3C4DEEF0")
    
Integer getAuthorizationAgentRequestData(String address) {
        Integer data = mEventLoop.getAuthorizationAgentRequestData().remove(address);
        return data;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.353 -0400", hash_original_method = "0A3D9E087858A85739071EC50DBEB845", hash_generated_method = "400DE1B4639F8D02A31A8AEC37C2ABE8")
    
public void sendProfileStateMessage(int profile, int cmd) {
        Message msg = new Message();
        msg.what = cmd;
        if (profile == BluetoothProfileState.HFP) {
            mHfpProfileState.sendMessage(msg);
        } else if (profile == BluetoothProfileState.A2DP) {
            mA2dpProfileState.sendMessage(msg);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.355 -0400", hash_original_method = "4463FECB36E3F6990BD15B5CD3CCA7E0", hash_generated_method = "CCCE6105A13F224F32064F0C405AAE18")
    
public int getAdapterConnectionState() {
        return mAdapterConnectionState;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.356 -0400", hash_original_method = "0E13B42D7893F8EAA4AC88AD8881A0F5", hash_generated_method = "BED6EC32B9F0DF0558A56DCCF50C50DF")
    
public int getProfileConnectionState(int profile) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");

        Pair<Integer, Integer> state = mProfileConnectionState.get(profile);
        if (state == null) return BluetoothProfile.STATE_DISCONNECTED;

        return state.first;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.358 -0400", hash_original_method = "6D0A748741F3E1FA574FC9DF0EC75E6F", hash_generated_method = "079204D3C2C5603BC33484C1C7230458")
    
private void updateProfileConnectionState(int profile, int newState, int oldState) {
        // mProfileConnectionState is a hashmap -
        // <Integer, Pair<Integer, Integer>>
        // The key is the profile, the value is a pair. first element
        // is the state and the second element is the number of devices
        // in that state.
        int numDev = 1;
        int newHashState = newState;
        boolean update = true;

        // The following conditions are considered in this function:
        // 1. If there is no record of profile and state - update
        // 2. If a new device's state is current hash state - increment
        //    number of devices in the state.
        // 3. If a state change has happened to Connected or Connecting
        //    (if current state is not connected), update.
        // 4. If numDevices is 1 and that device state is being updated, update
        // 5. If numDevices is > 1 and one of the devices is changing state,
        //    decrement numDevices but maintain oldState if it is Connected or
        //    Connecting
        Pair<Integer, Integer> stateNumDev = mProfileConnectionState.get(profile);
        if (stateNumDev != null) {
            int currHashState = stateNumDev.first;
            numDev = stateNumDev.second;

            if (newState == currHashState) {
                numDev ++;
            } else if (newState == BluetoothProfile.STATE_CONNECTED ||
                   (newState == BluetoothProfile.STATE_CONNECTING &&
                    currHashState != BluetoothProfile.STATE_CONNECTED)) {
                 numDev = 1;
            } else if (numDev == 1 && oldState == currHashState) {
                 update = true;
            } else if (numDev > 1 && oldState == currHashState) {
                 numDev --;

                 if (currHashState == BluetoothProfile.STATE_CONNECTED ||
                     currHashState == BluetoothProfile.STATE_CONNECTING) {
                    newHashState = currHashState;
                 }
            } else {
                 update = false;
            }
        }

        if (update) {
            mProfileConnectionState.put(profile, new Pair<Integer, Integer>(newHashState,
                    numDev));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.360 -0400", hash_original_method = "42EB2923E5870F7C75E1C344E9E2D04F", hash_generated_method = "D660422FAD0F4EAD2D45803EC5082DE3")
    
public synchronized void sendConnectionStateChange(BluetoothDevice
            device, int profile, int state, int prevState) {
        // Since this is a binder call check if Bluetooth is on still
        if (getBluetoothStateInternal() == BluetoothAdapter.STATE_OFF) return;

        if (!validateProfileConnectionState(state) ||
                !validateProfileConnectionState(prevState)) {
            // Previously, an invalid state was broadcast anyway,
            // with the invalid state converted to -1 in the intent.
            // Better to log an error and not send an intent with
            // invalid contents or set mAdapterConnectionState to -1.
            Log.e(TAG, "Error in sendConnectionStateChange: "
                    + "prevState " + prevState + " state " + state);
            return;
        }

        updateProfileConnectionState(profile, state, prevState);

        if (updateCountersAndCheckForConnectionStateChange(state, prevState)) {
            mAdapterConnectionState = state;

            if (state == BluetoothProfile.STATE_DISCONNECTED) {
                mBluetoothState.sendMessage(BluetoothAdapterStateMachine.ALL_DEVICES_DISCONNECTED);
            }

            Intent intent = new Intent(BluetoothAdapter.ACTION_CONNECTION_STATE_CHANGED);
            intent.putExtra(BluetoothDevice.EXTRA_DEVICE, device);
            intent.putExtra(BluetoothAdapter.EXTRA_CONNECTION_STATE,
                    convertToAdapterState(state));
            intent.putExtra(BluetoothAdapter.EXTRA_PREVIOUS_CONNECTION_STATE,
                    convertToAdapterState(prevState));
            intent.addFlags(Intent.FLAG_RECEIVER_REGISTERED_ONLY_BEFORE_BOOT);
            mContext.sendBroadcast(intent, BLUETOOTH_PERM);
            Log.d(TAG, "CONNECTION_STATE_CHANGE: " + device + ": "
                    + prevState + " -> " + state);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.362 -0400", hash_original_method = "F720A5AC54B2FF4009F5D0835FB6F6F8", hash_generated_method = "C92DB1D7816952C9C9C68B019076E027")
    
private boolean validateProfileConnectionState(int state) {
        return (state == BluetoothProfile.STATE_DISCONNECTED ||
                state == BluetoothProfile.STATE_CONNECTING ||
                state == BluetoothProfile.STATE_CONNECTED ||
                state == BluetoothProfile.STATE_DISCONNECTING);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.363 -0400", hash_original_method = "7BCD54A04D74E160668BA6B723FA7D0E", hash_generated_method = "B9F5A0A5007B646AD0649589AD263CE5")
    
private int convertToAdapterState(int state) {
        switch (state) {
            case BluetoothProfile.STATE_DISCONNECTED:
                return BluetoothAdapter.STATE_DISCONNECTED;
            case BluetoothProfile.STATE_DISCONNECTING:
                return BluetoothAdapter.STATE_DISCONNECTING;
            case BluetoothProfile.STATE_CONNECTED:
                return BluetoothAdapter.STATE_CONNECTED;
            case BluetoothProfile.STATE_CONNECTING:
                return BluetoothAdapter.STATE_CONNECTING;
        }
        Log.e(TAG, "Error in convertToAdapterState");
        return -1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.365 -0400", hash_original_method = "4BF1572A9D8721DEB90F193357F19993", hash_generated_method = "05AFEF5FC1D2A16701F9757FC8C73AF1")
    
private boolean updateCountersAndCheckForConnectionStateChange(int state, int prevState) {
        switch (prevState) {
            case BluetoothProfile.STATE_CONNECTING:
                mProfilesConnecting--;
                break;

            case BluetoothProfile.STATE_CONNECTED:
                mProfilesConnected--;
                break;

            case BluetoothProfile.STATE_DISCONNECTING:
                mProfilesDisconnecting--;
                break;
        }

        switch (state) {
            case BluetoothProfile.STATE_CONNECTING:
                mProfilesConnecting++;
                return (mProfilesConnected == 0 && mProfilesConnecting == 1);

            case BluetoothProfile.STATE_CONNECTED:
                mProfilesConnected++;
                return (mProfilesConnected == 1);

            case BluetoothProfile.STATE_DISCONNECTING:
                mProfilesDisconnecting++;
                return (mProfilesConnected == 0 && mProfilesDisconnecting == 1);

            case BluetoothProfile.STATE_DISCONNECTED:
                return (mProfilesConnected == 0 && mProfilesConnecting == 0);

            default:
                return true;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.366 -0400", hash_original_method = "DB3142F2D268DB5E1F3A594FA60227D0", hash_generated_method = "C1E478B41BC1EA6ADB3AD8A696CA2B01")
    
private void createIncomingConnectionStateFile() {
        File f = new File(INCOMING_CONNECTION_FILE);
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                Log.e(TAG, "IOException: cannot create file");
            }
        }
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.368 -0400", hash_original_method = "52806440EA016E1E5AC28E5B1D9979CD", hash_generated_method = "F6797E1CFDFC477A7ED66598E4E628B1")
    
public Pair<Integer, String> getIncomingState(String address) {
        if (mIncomingConnections.isEmpty()) {
            createIncomingConnectionStateFile();
            readIncomingConnectionState();
        }
        return mIncomingConnections.get(address);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.371 -0400", hash_original_method = "1C1CAE10392DC56CAF2568FD26CEFA0D", hash_generated_method = "5AE42DD65045112D9F896D5C11490F57")
    
private void readIncomingConnectionState() {
        synchronized(mIncomingConnections) {
            FileInputStream fstream = null;
            try {
              fstream = new FileInputStream(INCOMING_CONNECTION_FILE);
              DataInputStream in = new DataInputStream(fstream);
              BufferedReader file = new BufferedReader(new InputStreamReader(in));
              String line;
              while((line = file.readLine()) != null) {
                  line = line.trim();
                  if (line.length() == 0) continue;
                  String[] value = line.split(",");
                  if (value != null && value.length == 3) {
                      Integer val1 = Integer.parseInt(value[1]);
                      Pair<Integer, String> val = new Pair(val1, value[2]);
                      mIncomingConnections.put(value[0], val);
                  }
              }
            } catch (FileNotFoundException e) {
                log("FileNotFoundException: readIncomingConnectionState" + e.toString());
            } catch (IOException e) {
                log("IOException: readIncomingConnectionState" + e.toString());
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
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.372 -0400", hash_original_method = "2BD4721E93C9EB5522DC73C2EF32AAFB", hash_generated_method = "D8114D44159D8647BC0BC3DE45E2C9FD")
    
private void truncateIncomingConnectionFile() {
        RandomAccessFile r = null;
        try {
            r = new RandomAccessFile(INCOMING_CONNECTION_FILE, "rw");
            r.setLength(0);
        } catch (FileNotFoundException e) {
            log("FileNotFoundException: truncateIncomingConnectionState" + e.toString());
        } catch (IOException e) {
            log("IOException: truncateIncomingConnectionState" + e.toString());
        } finally {
            if (r != null) {
                try {
                    r.close();
                } catch (IOException e) {
                    // ignore
                 }
            }
        }
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:26.374 -0400", hash_original_method = "3ADF0BA5795F5875F85DB6ABFD8AF163", hash_generated_method = "BD55BF7C63A6500927BCD2BDA332144A")
    
public void writeIncomingConnectionState(String address, Pair<Integer, String> data) {
        synchronized(mIncomingConnections) {
            mIncomingConnections.put(address, data);

            truncateIncomingConnectionFile();
            BufferedWriter out = null;
            StringBuilder value = new StringBuilder();
            try {
                out = new BufferedWriter(new FileWriter(INCOMING_CONNECTION_FILE, true));
                for (String devAddress: mIncomingConnections.keySet()) {
                  Pair<Integer, String> val = mIncomingConnections.get(devAddress);
                  value.append(devAddress);
                  value.append(",");
                  value.append(val.first.toString());
                  value.append(",");
                  value.append(val.second);
                  value.append("\n");
                }
                out.write(value.toString());
            } catch (FileNotFoundException e) {
                log("FileNotFoundException: writeIncomingConnectionState" + e.toString());
            } catch (IOException e) {
                log("IOException: writeIncomingConnectionState" + e.toString());
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
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:22:11.026 -0400", hash_original_method = "96C94C385383C3A18A52276A4D2A2B32", hash_generated_method = "4CFDBFA182515EEF09ADB2455AD182E5")
    
    private void initializeNativeDataNative(){
    	//Formerly a native method
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:59.509 -0400", hash_original_method = "CA70AB49652F49EE049B6DF20B2CA06F", hash_generated_method = "AEDB24C9801C9574D18FFB85C36D6C51")
    
    private boolean setupNativeDataNative(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:59.511 -0400", hash_original_method = "51B536FC783003F49FBF583EBABDA000", hash_generated_method = "E9E6E8FA03A38E2B4F7B22C31F409508")
    
    private boolean tearDownNativeDataNative(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:22:11.033 -0400", hash_original_method = "3B6CA7B24C36B662CB5B1AEC413DB28D", hash_generated_method = "0DAB225627D67322CE3F5E19CB1C0E87")
    
    private void cleanupNativeDataNative(){
    	//Formerly a native method
    }
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:59.516 -0400", hash_original_method = "0B30D5E18849A83AFD6E3E3A5991C416", hash_generated_method = "84215F8E01C364CBDCEBFEC65508E165")
    
    String getAdapterPathNative(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	String retObj = new String(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:59.519 -0400", hash_original_method = "8FDD5970CB8E20A1D0859F6D8B91FB0D", hash_generated_method = "6BC15B5E1BE5F13F474F5F39B9AB585C")
    
    private int isEnabledNative(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return (int)taintDouble;
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:59.521 -0400", hash_original_method = "7DB06D83BF02F1C8CE8F0519420930C4", hash_generated_method = "FB532C096F06A5705B1521C85BD8BD1F")
    
    int enableNative(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return (int)taintDouble;
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:59.523 -0400", hash_original_method = "2B5A38319300091A88798D4FBD3212C0", hash_generated_method = "0922E4AC4CB454D8DD0B2478BB2262D3")
    
    int disableNative(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return (int)taintDouble;
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:59.525 -0400", hash_original_method = "C42E8ED24293A5A097462201923B5488", hash_generated_method = "C7EC3873E886E872E1AD8A18DD682CE3")
    
    Object[] getAdapterPropertiesNative(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	Object[] retObj = new Object[1]; 
    	retObj[0] = new Object(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.587 -0400", hash_original_method = "C8DEEE65E88777753FADC5FE8A446294", hash_generated_method = "DDA7BBB3DA7B48C2CD8BA53BE4B4124A")
    
    private Object[] getDevicePropertiesNative(String objectPath){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += objectPath.getTaintInt();
    	addTaint(taintDouble);
    
    	Object[] retObj = new Object[1]; 
    	retObj[0] = new Object(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.590 -0400", hash_original_method = "26016AEAABA0FBF335E3DA8375B90D5F", hash_generated_method = "D5A2B9A504A03FEA543618D21CABA7D2")
    
    private boolean setAdapterPropertyStringNative(String key, String value){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += key.getTaintInt();
    	taintDouble += value.getTaintInt();
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.593 -0400", hash_original_method = "BECBF187FFB34FCB4D52D168AB69D2A6", hash_generated_method = "73E929C669301DD08A9008BDF47E9401")
    
    private boolean setAdapterPropertyIntegerNative(String key, int value){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += key.getTaintInt();
    	taintDouble += value;
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.597 -0400", hash_original_method = "5F7F7D6B28C214738B0B37834ECCD852", hash_generated_method = "F75F2ECB937ADE3BA177B8C00296D55D")
    
    private boolean setAdapterPropertyBooleanNative(String key, int value){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += key.getTaintInt();
    	taintDouble += value;
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:59.537 -0400", hash_original_method = "7237E5A1E5B85127AE4BC8A163BAACA2", hash_generated_method = "9F9505235C952BB6D031850BE81A915B")
    
    private boolean startDiscoveryNative(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:59.539 -0400", hash_original_method = "360BEC7C437750736B0535A7ACC2D0E9", hash_generated_method = "4DF2998F97737928A56F819F40C79146")
    
    private boolean stopDiscoveryNative(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.607 -0400", hash_original_method = "0E72D1B6B60B0E0BAE085493F56B96AA", hash_generated_method = "C0F618BFF2249C003564F4883D5383A2")
    
    private boolean createPairedDeviceNative(String address, int timeout_ms){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += address.getTaintInt();
    	taintDouble += timeout_ms;
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.610 -0400", hash_original_method = "3E18CB80049407F3CFA22F1D68DAABEE", hash_generated_method = "48E9ECB417DAB7AAAA67352BCCCEFCDB")
    
    private boolean createPairedDeviceOutOfBandNative(String address, int timeout_ms){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += address.getTaintInt();
    	taintDouble += timeout_ms;
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:59.546 -0400", hash_original_method = "38EE72FABCA4DC5E9C80C573DE957EAD", hash_generated_method = "F9360208823F690A640AB46DF340A057")
    
    private byte[] readAdapterOutOfBandDataNative(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	byte[] retObj = new byte[1]; 
    	retObj[0] = (byte)taintDouble;
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.616 -0400", hash_original_method = "AED6ABC66E34EB06D57ABD6C09C96DD2", hash_generated_method = "9A19EE950E1E39E925AB4C8878568738")
    
    private boolean cancelDeviceCreationNative(String address){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += address.getTaintInt();
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.619 -0400", hash_original_method = "3F46C71B2050F96708A238DBF6D2B85C", hash_generated_method = "9542E3FA0CCED37AB069155F70D65D50")
    
    private boolean removeDeviceNative(String objectPath){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += objectPath.getTaintInt();
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.623 -0400", hash_original_method = "BDD3804241DBCCCB95D1FAA417D47516", hash_generated_method = "471D4ED2CEB5E01D7644293A9C152820")
    
    private int getDeviceServiceChannelNative(String objectPath, String uuid,
                int attributeId){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += objectPath.getTaintInt();
    	taintDouble += uuid.getTaintInt();
    	taintDouble += attributeId;
    	addTaint(taintDouble);
    
    	return (int)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.627 -0400", hash_original_method = "45334E318563A81990E463FB5E592EF3", hash_generated_method = "4D573561642DCC826F54D9F8EF7BF5C3")
    
    private boolean cancelPairingUserInputNative(String address, int nativeData){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += address.getTaintInt();
    	taintDouble += nativeData;
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.630 -0400", hash_original_method = "7965AF2410A1D23CB36EEAF21A720D9B", hash_generated_method = "C3158B523BEC2A8C5A2AED7F0E2627B2")
    
    private boolean setPinNative(String address, String pin, int nativeData){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += address.getTaintInt();
    	taintDouble += pin.getTaintInt();
    	taintDouble += nativeData;
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.633 -0400", hash_original_method = "DF5461E8BBFC99195294633EC99C38A4", hash_generated_method = "EA0B55B4F28B6B21BDD825CFD49E829D")
    
    private boolean setPasskeyNative(String address, int passkey, int nativeData){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += address.getTaintInt();
    	taintDouble += passkey;
    	taintDouble += nativeData;
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:39:09.400 -0400", hash_original_method = "FBC0B4969C7C7832C86D8116FA6E93FE", hash_generated_method = "B06648379376AD786B9550105BBB3FAA")
    
    private boolean setPairingConfirmationNative(String address, boolean confirm,
                int nativeData){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += address.getTaintInt();
    	taintDouble += toTaintInt(confirm);
    	taintDouble += nativeData;
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.639 -0400", hash_original_method = "7407BD3CC6544027E5D0C45402CFE147", hash_generated_method = "1EB131CD76A823BC273BD199C8153F12")
    
    private boolean setRemoteOutOfBandDataNative(String address, byte[] hash,
                                                            byte[] randomizer, int nativeData){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += address.getTaintInt();
    	taintDouble += hash[0];
    	taintDouble += randomizer[0];
    	taintDouble += nativeData;
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.642 -0400", hash_original_method = "21593BFEFF25112A05131665234AEC78", hash_generated_method = "A81646B687D61AC60A958C1AD47D601D")
    
    private boolean setDevicePropertyBooleanNative(String objectPath, String key,
                int value){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += objectPath.getTaintInt();
    	taintDouble += key.getTaintInt();
    	taintDouble += value;
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.646 -0400", hash_original_method = "0D3B8791F6B9796D4BD1C779CE2A2D83", hash_generated_method = "2A17298E7BF48EB1DAA99655D948E6D2")
    
    private boolean setDevicePropertyStringNative(String objectPath, String key,
                String value){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += objectPath.getTaintInt();
    	taintDouble += key.getTaintInt();
    	taintDouble += value.getTaintInt();
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.649 -0400", hash_original_method = "07C8574252DB220D50E308961EEBA2C2", hash_generated_method = "978243A68B793384AC79ABC9517B1145")
    
    private boolean createDeviceNative(String address){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += address.getTaintInt();
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.652 -0400", hash_original_method = "8E1A150BF1CD2E1203B237CB424A5D18", hash_generated_method = "FF9DA9DA2460C409499D16B98910FEE0")
    
    boolean discoverServicesNative(String objectPath, String pattern){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += objectPath.getTaintInt();
    	taintDouble += pattern.getTaintInt();
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.656 -0400", hash_original_method = "765A148A6C0A58403B8E2DB1A1259F87", hash_generated_method = "96E89C347A0176D0BB9A4720740F496A")
    
    private int addRfcommServiceRecordNative(String name, long uuidMsb, long uuidLsb,
                short channel){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += name.getTaintInt();
    	taintDouble += uuidMsb;
    	taintDouble += uuidLsb;
    	taintDouble += channel;
    	addTaint(taintDouble);
    
    	return (int)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.659 -0400", hash_original_method = "0363B7A509DE176AC718DF39E8BD6AB7", hash_generated_method = "ECB7AA3A80263A99B041698BD6E6CB4A")
    
    private boolean removeServiceRecordNative(int handle){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += handle;
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.662 -0400", hash_original_method = "E44B679DAD5A1646007BE7DE8CD9592F", hash_generated_method = "9838F9E96F95F3D603A03D3887B5FF92")
    
    private boolean setLinkTimeoutNative(String path, int num_slots){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += path.getTaintInt();
    	taintDouble += num_slots;
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.665 -0400", hash_original_method = "CE008BD6BF6A1014A4BBD6D0E491D152", hash_generated_method = "2D3F996F5F4F7F474722138C0B5F15AA")
    
    boolean connectInputDeviceNative(String path){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += path.getTaintInt();
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.668 -0400", hash_original_method = "121411D25B428573564DFE366B812ECB", hash_generated_method = "143221148EB9BB303486C423234CE675")
    
    boolean disconnectInputDeviceNative(String path){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += path.getTaintInt();
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:39:09.423 -0400", hash_original_method = "FA2217A8DE4022FA6D873EBB4C5735B4", hash_generated_method = "4D88D10830B2D220A2D78D5771A4A54E")
    
    boolean setBluetoothTetheringNative(boolean value, String nap, String bridge){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += toTaintInt(value);
    	taintDouble += nap.getTaintInt();
    	taintDouble += bridge.getTaintInt();
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.675 -0400", hash_original_method = "437233521ADCB518902AA201E3534A10", hash_generated_method = "85A98BDF6404B89006675EE6C6D3E95A")
    
    boolean connectPanDeviceNative(String path, String dstRole){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += path.getTaintInt();
    	taintDouble += dstRole.getTaintInt();
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.678 -0400", hash_original_method = "4064A28C025832F18760FF0DB3DF1BD3", hash_generated_method = "EF35E8B1D990009794D75351C3EBE4EF")
    
    boolean disconnectPanDeviceNative(String path){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += path.getTaintInt();
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.681 -0400", hash_original_method = "598E25A33102CBC820D90EB4F5119B57", hash_generated_method = "13E39DC16554D1F28FF78B02E4EB08D9")
    
    boolean disconnectPanServerDeviceNative(String path,
                String address, String iface){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += path.getTaintInt();
    	taintDouble += address.getTaintInt();
    	taintDouble += iface.getTaintInt();
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.683 -0400", hash_original_method = "05AAF5040BC1B6D1D2D502B30DC45DEC", hash_generated_method = "8EC2FBEDD9F7E94488FC87B1D6DE1445")
    
    private int[] addReservedServiceRecordsNative(int[] uuuids){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += uuuids[0];
    	addTaint(taintDouble);
    
    	int[] retObj = new int[1]; 
    	retObj[0] = (int)taintDouble;
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.686 -0400", hash_original_method = "B45FB1379E33BA989609E743A3060C33", hash_generated_method = "88B4B9152493C14578E4E412E8F57DB1")
    
    private boolean removeReservedServiceRecordsNative(int[] handles){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += handles[0];
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    // Health API
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.689 -0400", hash_original_method = "2BCFC1A8FC7671C069367FA5CC1410EF", hash_generated_method = "C43AAB74D0EABFDC2DCA60B2A21ED2B6")
    
    String registerHealthApplicationNative(int dataType, String role, String name,
                String channelType){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += dataType;
    	taintDouble += role.getTaintInt();
    	taintDouble += name.getTaintInt();
    	taintDouble += channelType.getTaintInt();
    	addTaint(taintDouble);
    
    	String retObj = new String(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.693 -0400", hash_original_method = "84A7A07199D8A561DA0A97B29806A1CA", hash_generated_method = "09B1CD4872FB367A7F69F816D2D174A7")
    
    String registerHealthApplicationNative(int dataType, String role, String name){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += dataType;
    	taintDouble += role.getTaintInt();
    	taintDouble += name.getTaintInt();
    	addTaint(taintDouble);
    
    	String retObj = new String(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.696 -0400", hash_original_method = "BA1A856088B96F03EBA8AADE2D853D52", hash_generated_method = "1CE4F042F509D17CC69926CC296E29F1")
    
    boolean unregisterHealthApplicationNative(String path){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += path.getTaintInt();
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.699 -0400", hash_original_method = "F2620CDF3C92B1F5017EBB5F76E84202", hash_generated_method = "7D905AC49FFDCABBC084DAFD62B708A9")
    
    boolean createChannelNative(String devicePath, String appPath, String channelType,
                                           int code){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += devicePath.getTaintInt();
    	taintDouble += appPath.getTaintInt();
    	taintDouble += channelType.getTaintInt();
    	taintDouble += code;
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.702 -0400", hash_original_method = "1C5EF9067AD7C6A56E79970AA2A4B6AC", hash_generated_method = "B3E7C88D4A27CEF66BB3947B43B0DE2B")
    
    boolean destroyChannelNative(String devicePath, String channelpath, int code){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += devicePath.getTaintInt();
    	taintDouble += channelpath.getTaintInt();
    	taintDouble += code;
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.705 -0400", hash_original_method = "D26CDCD0389A6FF45ECA8A06B76AE4D8", hash_generated_method = "3A218C5B9F8EC23B0877A15BFB127D6C")
    
    String getMainChannelNative(String path){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += path.getTaintInt();
    	addTaint(taintDouble);
    
    	String retObj = new String(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.709 -0400", hash_original_method = "E83E84DA61205955F02F43F4B994AF7F", hash_generated_method = "DE87BF1E896C42E1CCF860B4751AA082")
    
    String getChannelApplicationNative(String channelPath){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += channelPath.getTaintInt();
    	addTaint(taintDouble);
    
    	String retObj = new String(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.712 -0400", hash_original_method = "5DE8A145C73F53E768B80E76013EEBA3", hash_generated_method = "9528334EC7C7E7C38E645EE866EE2D6E")
    
    ParcelFileDescriptor getChannelFdNative(String channelPath){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += channelPath.getTaintInt();
    	addTaint(taintDouble);
    
    	ParcelFileDescriptor retObj = new ParcelFileDescriptor(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:37.715 -0400", hash_original_method = "5D9294B172AF9AAC89E8CFDC3C007524", hash_generated_method = "D108CE6EB4D546D234DD20BCD7D06FEF")
    
    boolean releaseChannelFdNative(String channelPath){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += channelPath.getTaintInt();
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:39:09.455 -0400", hash_original_method = "72F87CBF90B1ADC9C8F1684BF6FD5860", hash_generated_method = "627C72DE0B4F1D4532ED589E4973E094")
    
    boolean setAuthorizationNative(String address, boolean value, int data){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += address.getTaintInt();
    	taintDouble += toTaintInt(value);
    	taintDouble += data;
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

}
