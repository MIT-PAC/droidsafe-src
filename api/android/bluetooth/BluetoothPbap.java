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

package android.bluetooth;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import android.os.IBinder;
import android.os.ServiceManager;
import android.util.Log;

/**
 * The Android Bluetooth API is not finalized, and *will* change. Use at your
 * own risk.
 *
 * Public API for controlling the Bluetooth Pbap Service. This includes
 * Bluetooth Phone book Access profile.
 * BluetoothPbap is a proxy object for controlling the Bluetooth Pbap
 * Service via IPC.
 *
 * Creating a BluetoothPbap object will create a binding with the
 * BluetoothPbap service. Users of this object should call close() when they
 * are finished with the BluetoothPbap, so that this proxy object can unbind
 * from the service.
 *
 * This BluetoothPbap object is not immediately bound to the
 * BluetoothPbap service. Use the ServiceListener interface to obtain a
 * notification when it is bound, this is especially important if you wish to
 * immediately call methods on BluetoothPbap after construction.
 *
 * Android only supports one connected Bluetooth Pce at a time.
 *
 * @hide
 */
public class BluetoothPbap {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:20.739 -0400", hash_original_field = "B7524E04D21BCCC922EFEF4E54B2CF88", hash_generated_field = "814C0F94A7F0F5B0540B77DAA6161024")


    private static final String TAG = "BluetoothPbap";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:20.747 -0400", hash_original_field = "B2601CA7445F6BA19FA7884763D82281", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:20.755 -0400", hash_original_field = "BBB6E4B8712B15AA0E9598BD1945610D", hash_generated_field = "F392CB060C84D764716B8B8991B315EA")

    public static final String PBAP_STATE =
        "android.bluetooth.pbap.intent.PBAP_STATE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:20.761 -0400", hash_original_field = "2777D43C6FD43C9B0C968AD46EFB8DB9", hash_generated_field = "416AC316BEFB42A4F129BB9B9BEC8F08")

    public static final String PBAP_PREVIOUS_STATE =
        "android.bluetooth.pbap.intent.PBAP_PREVIOUS_STATE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:20.767 -0400", hash_original_field = "EB17E6A0AAE692E4D868E28DBD26F117", hash_generated_field = "69FEC68758484F2BBE670EBB0D5A7553")

    public static final String PBAP_STATE_CHANGED_ACTION =
        "android.bluetooth.pbap.intent.action.PBAP_STATE_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:20.794 -0400", hash_original_field = "AA32BA63E0527427A516BA30E06A641F", hash_generated_field = "C8430983049B1BBCE1DA9BAD38FF16B9")

    public static final int STATE_ERROR        = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:20.800 -0400", hash_original_field = "1D68C8F7C30276313FF74EEBEDEBB1AC", hash_generated_field = "84173E1866F23EE943EF8008ED8CFAFC")

    public static final int STATE_DISCONNECTED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:20.806 -0400", hash_original_field = "89700172BAD89C181A3F425C56815959", hash_generated_field = "8CB4E5E77EC98D8CA7B9ED27A25245FB")

    public static final int STATE_CONNECTING   = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:20.812 -0400", hash_original_field = "06D554ABD776B22289EDC7EEB1C08911", hash_generated_field = "3F851151E1E65F1A69352C1A55C34451")

    public static final int STATE_CONNECTED    = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:20.818 -0400", hash_original_field = "83085037C92505261DAF694B37B1AB94", hash_generated_field = "ED5FC54A0E1F7E547D6396E3C522384B")


    public static final int RESULT_FAILURE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:20.823 -0400", hash_original_field = "046FF881B1652C5410F7E510A4590BC2", hash_generated_field = "7EAFB7F6A714A396D5FD99B19AFA0BF8")

    public static final int RESULT_SUCCESS = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:20.829 -0400", hash_original_field = "6CD007A3B8E9B2E86967680E0FED88F8", hash_generated_field = "5ED25AF97CA1552DEF7FCB7B7B161563")

    public static final int RESULT_CANCELED = 2;

    /**
     * Check class bits for possible PBAP support.
     * This is a simple heuristic that tries to guess if a device with the
     * given class bits might support PBAP. It is not accurate for all
     * devices. It tries to err on the side of false positives.
     * @return True if this device might support PBAP.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:20.883 -0400", hash_original_method = "964673E5C80A23660C53BA47E92E13FE", hash_generated_method = "FDB9F1BB720F837952D45A5AE3C14FD9")
    
public static boolean doesClassMatchSink(BluetoothClass btClass) {
        // TODO optimize the rule
        switch (btClass.getDeviceClass()) {
        case BluetoothClass.Device.COMPUTER_DESKTOP:
        case BluetoothClass.Device.COMPUTER_LAPTOP:
        case BluetoothClass.Device.COMPUTER_SERVER:
        case BluetoothClass.Device.COMPUTER_UNCATEGORIZED:
            return true;
        default:
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:20.904 -0400", hash_original_method = "0EBF7673E44AF610ADC3AB53A65BD597", hash_generated_method = "12E4FDCE2D2661CC6DF9F077D2C0BB73")
    
private static void log(String msg) {
        Log.d(TAG, msg);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:20.774 -0400", hash_original_field = "AF80AF356C99F0396DEA9A78A776DD27", hash_generated_field = "6AE0C7D8AB61D9078F5AF5423B043BD4")


    private IBluetoothPbap mService;

    /**
     * An interface for notifying Bluetooth PCE IPC clients when they have
     * been connected to the BluetoothPbap service.
     */
    public interface ServiceListener {
        /**
         * Called to notify the client when this proxy object has been
         * connected to the BluetoothPbap service. Clients must wait for
         * this callback before making IPC calls on the BluetoothPbap
         * service.
         */
        public void onServiceConnected();

        /**
         * Called to notify the client that this proxy object has been
         * disconnected from the BluetoothPbap service. Clients must not
         * make IPC calls on the BluetoothPbap service after this callback.
         * This callback will currently only occur if the application hosting
         * the BluetoothPbap service, but may be called more often in future.
         */
        public void onServiceDisconnected();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:20.784 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:20.789 -0400", hash_original_field = "AD4810E1EAEE0B4F351A0550C3A3183B", hash_generated_field = "6FCEA0ED39BC377BA765F514A42DFCE9")

    private ServiceListener mServiceListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:20.900 -0400", hash_original_field = "F0D55C23B73B18D189C175C259BB6932", hash_generated_field = "894C40BEEA45122F2AB1A9BAC0BA8E33")


    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            if (DBG) log("Proxy object connected");
            mService = IBluetoothPbap.Stub.asInterface(service);
            if (mServiceListener != null) {
                mServiceListener.onServiceConnected();
            }
        }
        public void onServiceDisconnected(ComponentName className) {
            if (DBG) log("Proxy object disconnected");
            mService = null;
            if (mServiceListener != null) {
                mServiceListener.onServiceDisconnected();
            }
        }
    };

    /**
     * Create a BluetoothPbap proxy object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:20.841 -0400", hash_original_method = "C57CA7CFBC6DFB42D994E029985977A5", hash_generated_method = "D45E600D64E66D9DC375CB2FC98A5224")
    
public BluetoothPbap(Context context, ServiceListener l) {
        mContext = context;
        mServiceListener = l;
        if (!context.bindService(new Intent(IBluetoothPbap.class.getName()), mConnection, 0)) {
            Log.e(TAG, "Could not bind to Bluetooth Pbap Service");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:20.846 -0400", hash_original_method = "6187FAF262C27B43BD19556B133B66CD", hash_generated_method = "E954298D2D755E1C75FE4E4BC8539455")
    
protected void finalize() throws Throwable {
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    /**
     * Close the connection to the backing service.
     * Other public functions of BluetoothPbap will return default error
     * results once close() has been called. Multiple invocations of close()
     * are ok.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:20.851 -0400", hash_original_method = "86304414BD9096F7A049B10DDB721782", hash_generated_method = "862E606DA764E1B978E294EC3EA9988E")
    
public synchronized void close() {
        if (mConnection != null) {
            mContext.unbindService(mConnection);
            mConnection = null;
        }
        mServiceListener = null;
    }

    /**
     * Get the current state of the BluetoothPbap service.
     * @return One of the STATE_ return codes, or STATE_ERROR if this proxy
     *         object is currently not connected to the Pbap service.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:20.856 -0400", hash_original_method = "7175BBF6C5AA080810B87B7ADFCDB9E8", hash_generated_method = "FF2B50D7A4B1829C0CB5530F93E44DCE")
    
public int getState() {
        if (DBG) log("getState()");
        if (mService != null) {
            try {
                return mService.getState();
            } catch (RemoteException e) {Log.e(TAG, e.toString());}
        } else {
            Log.w(TAG, "Proxy not attached to service");
            if (DBG) log(Log.getStackTraceString(new Throwable()));
        }
        return BluetoothPbap.STATE_ERROR;
    }

    /**
     * Get the currently connected remote Bluetooth device (PCE).
     * @return The remote Bluetooth device, or null if not in connected or
     *         connecting state, or if this proxy object is not connected to
     *         the Pbap service.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:20.861 -0400", hash_original_method = "949DA9D89BA99FD797445F8032E1D722", hash_generated_method = "BF8114C7F62E7A668ABE7D6E4321AD28")
    
public BluetoothDevice getClient() {
        if (DBG) log("getClient()");
        if (mService != null) {
            try {
                return mService.getClient();
            } catch (RemoteException e) {Log.e(TAG, e.toString());}
        } else {
            Log.w(TAG, "Proxy not attached to service");
            if (DBG) log(Log.getStackTraceString(new Throwable()));
        }
        return null;
    }

    /**
     * Returns true if the specified Bluetooth device is connected (does not
     * include connecting). Returns false if not connected, or if this proxy
     * object is not currently connected to the Pbap service.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:20.868 -0400", hash_original_method = "645B30EA292F8BC80E0AB6A5F4BAA0D2", hash_generated_method = "46C5BFD771151E772F4FB135084F4F98")
    
public boolean isConnected(BluetoothDevice device) {
        if (DBG) log("isConnected(" + device + ")");
        if (mService != null) {
            try {
                return mService.isConnected(device);
            } catch (RemoteException e) {Log.e(TAG, e.toString());}
        } else {
            Log.w(TAG, "Proxy not attached to service");
            if (DBG) log(Log.getStackTraceString(new Throwable()));
        }
        return false;
    }

    /**
     * Disconnects the current Pbap client (PCE). Currently this call blocks,
     * it may soon be made asynchronous. Returns false if this proxy object is
     * not currently connected to the Pbap service.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:20.876 -0400", hash_original_method = "43F1CFD7014D9799179A403496E83994", hash_generated_method = "90A3859204FE43A4539FFE02BB6F5A9A")
    
public boolean disconnect() {
        if (DBG) log("disconnect()");
        if (mService != null) {
            try {
                mService.disconnect();
                return true;
            } catch (RemoteException e) {Log.e(TAG, e.toString());}
        } else {
            Log.w(TAG, "Proxy not attached to service");
            if (DBG) log(Log.getStackTraceString(new Throwable()));
        }
        return false;
    }
}
