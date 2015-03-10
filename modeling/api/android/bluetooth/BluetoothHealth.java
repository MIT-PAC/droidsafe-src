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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.bluetooth;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;

public final class BluetoothHealth implements BluetoothProfile {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.246 -0500", hash_original_method = "0EBF7673E44AF610ADC3AB53A65BD597", hash_generated_method = "12E4FDCE2D2661CC6DF9F077D2C0BB73")
    
private static void log(String msg) {
        Log.d(TAG, msg);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.141 -0500", hash_original_field = "23EE572589B48CD2857A8D8D7DF6EE58", hash_generated_field = "AE145E568188D4221758B10860857593")

    private static final String TAG = "BluetoothHealth";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.143 -0500", hash_original_field = "B2601CA7445F6BA19FA7884763D82281", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.146 -0500", hash_original_field = "40CA6ADC43DC2837DF67CA3DFC0DF1B8", hash_generated_field = "6A8A7B99F8542D30842145F7D4BAC183")

    public static final int SOURCE_ROLE = 1 << 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.148 -0500", hash_original_field = "F049D17568CBF691BD8F7DB68BB31BBA", hash_generated_field = "7F3B93A0179A065EA64332CDBCE1355C")

    public static final int SINK_ROLE = 1 << 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.151 -0500", hash_original_field = "0FD9585B003993FB011C6D0049346BB9", hash_generated_field = "80D1A2EE2CC2B4AFBC662F917DD5A7BD")

    public static final int CHANNEL_TYPE_RELIABLE = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.153 -0500", hash_original_field = "1EA6AF16C2D96E0E82614EF216CD54AC", hash_generated_field = "459638AC523B24C86FE56EF4B6EAE409")

    public static final int CHANNEL_TYPE_STREAMING = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.155 -0500", hash_original_field = "1FEB0FF9A1A700EF22132E57591B8637", hash_generated_field = "91383287A0A3BDA8A08AA3C621BFEBDB")

    public static final int CHANNEL_TYPE_ANY = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.158 -0500", hash_original_field = "348F0E79D686C10E21CDEC1C9684483B", hash_generated_field = "B5AE030E3488E3595615904D776FE6C7")

    public static final int HEALTH_OPERATION_SUCCESS = 6000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.160 -0500", hash_original_field = "A5FF4050E51F1B5F7E2A7978D105B0B5", hash_generated_field = "CEA5BE9F41CA14F07195984206A830C2")

    public static final int HEALTH_OPERATION_ERROR = 6001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.162 -0500", hash_original_field = "7E3A27D370A21F99B844CDE5C78E30F3", hash_generated_field = "C200B8378396302C1CF3DC1005073CE2")

    public static final int HEALTH_OPERATION_INVALID_ARGS = 6002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.164 -0500", hash_original_field = "1C86A843719E3B9C03899C07F7942134", hash_generated_field = "E1BE80A0FED6E9151699728215BD1ABE")

    public static final int HEALTH_OPERATION_GENERIC_FAILURE = 6003;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.167 -0500", hash_original_field = "9BA972C672F834A1E5EC2EE00EE3C17B", hash_generated_field = "47EE76CA2A85DB1D0333BEDFC2014A0F")

    public static final int HEALTH_OPERATION_NOT_FOUND = 6004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.169 -0500", hash_original_field = "A2BC9A11413414063AAD1954DD947B23", hash_generated_field = "D1B4E8A22AA5FB39987A65C353902B2A")

    public static final int HEALTH_OPERATION_NOT_ALLOWED = 6005;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.209 -0500", hash_original_field = "53300634AFC0173F948E538A2F4CE95C", hash_generated_field = "B5BD60CB07BBB3772D54340CC1FDC28A")

    public static final int STATE_CHANNEL_DISCONNECTED  = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.212 -0500", hash_original_field = "6B69A3180DA00769A26A6BB54279A4B9", hash_generated_field = "E745C4EA35FBCB73D9337A520A889523")

    public static final int STATE_CHANNEL_CONNECTING    = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.214 -0500", hash_original_field = "D0DA5A43311BDFDB796D7A24F4441F89", hash_generated_field = "31A3A3922F6724E2BBEA5BC9E8F270E3")

    public static final int STATE_CHANNEL_CONNECTED     = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.216 -0500", hash_original_field = "165BEC63F98DB188039E6269B8F471CC", hash_generated_field = "9DA663A725662DEB1BAD910553A5F112")

    public static final int STATE_CHANNEL_DISCONNECTING = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.219 -0500", hash_original_field = "32AAAC1AF6CC456A03EF1CB1C96610C9", hash_generated_field = "8352EB26F7DA6E75D8A431459C669736")

    public static final int APP_CONFIG_REGISTRATION_SUCCESS = 0;
    
    private static class BluetoothHealthCallbackWrapper extends IBluetoothHealthCallback.Stub {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.198 -0500", hash_original_field = "C4048EE3E72C586036A0AED82D8A2F52", hash_generated_field = "3AC95B6D8598783F18892228E574790F")

        private BluetoothHealthCallback mCallback;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.201 -0500", hash_original_method = "052172748E38AFDC47B4485751DFA95F", hash_generated_method = "9649B20EB8D0F97A2AD69482293B1A6C")
        
public BluetoothHealthCallbackWrapper(BluetoothHealthCallback callback) {
            mCallback = callback;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.203 -0500", hash_original_method = "F3F9CD11323FD103B4D93BE8A7C73A18", hash_generated_method = "C75C1EF71ED0E58A5471963CABE5F169")
        
@Override
        public void onHealthAppConfigurationStatusChange(BluetoothHealthAppConfiguration config,
                                                         int status) {
           mCallback.onHealthAppConfigurationStatusChange(config, status);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.206 -0500", hash_original_method = "74682BF5DF2CADBD7F49F1BEE1C54F59", hash_generated_method = "5178EDFBE6BD6D38673BDDE29BC16443")
        
@Override
        public void onHealthChannelStateChange(BluetoothHealthAppConfiguration config,
                                       BluetoothDevice device, int prevState, int newState,
                                       ParcelFileDescriptor fd, int channelId) {
            mCallback.onHealthChannelStateChange(config, device, prevState, newState, fd,
                                                 channelId);
        }
        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.221 -0500", hash_original_field = "BCBE23CF7E4A41DA940A234DEB78A7D2", hash_generated_field = "E0F008A46B0265984580B5C0AD2705BA")

    public static final int APP_CONFIG_REGISTRATION_FAILURE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.224 -0500", hash_original_field = "03AC86DE6E1BB08DABB899585A5CDC9D", hash_generated_field = "A55DC8C9A68DF76EC5BAF1FD82BC8BA7")

    public static final int APP_CONFIG_UNREGISTRATION_SUCCESS = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.226 -0500", hash_original_field = "AF84521C816508578D57B1C25CE94BB9", hash_generated_field = "7F5EC86D8F5BE99FA96B189FEF77A752")

    public static final int APP_CONFIG_UNREGISTRATION_FAILURE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.228 -0500", hash_original_field = "AD4810E1EAEE0B4F351A0550C3A3183B", hash_generated_field = "6FCEA0ED39BC377BA765F514A42DFCE9")

    private ServiceListener mServiceListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.229 -0500", hash_original_field = "E6C68E4A2725AB507547EA6B7D87DBDC", hash_generated_field = "40876FBB70C48F89ADB2F95E8DF8AB42")

    private IBluetooth mService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.231 -0500", hash_original_field = "367F0BC6BC216C571A7E906A286477DF", hash_generated_field = "367F0BC6BC216C571A7E906A286477DF")

    BluetoothAdapter mAdapter;

    /**
     * Create a BluetoothHealth proxy object.
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.234 -0500", hash_original_method = "913BD9E94B09B64A9AACEEEF134BFD21", hash_generated_method = "A44846338F03AE47B701D76C9E226829")
    
BluetoothHealth(Context mContext, ServiceListener l) {
        IBinder b = ServiceManager.getService(BluetoothAdapter.BLUETOOTH_SERVICE);
        mServiceListener = l;
        mAdapter = BluetoothAdapter.getDefaultAdapter();
        if (b != null) {
            mService = IBluetooth.Stub.asInterface(b);
            if (mServiceListener != null) {
                mServiceListener.onServiceConnected(BluetoothProfile.HEALTH, this);
            }
        } else {
            Log.w(TAG, "Bluetooth Service not available!");

            // Instead of throwing an exception which prevents people from going
            // into Wireless settings in the emulator. Let it crash later when it is actually used.
            mService = null;
        }
    }

    /**
     * Register an application configuration that acts as a Health SINK.
     * This is the configuration that will be used to communicate with health devices
     * which will act as the {@link #SOURCE_ROLE}. This is an asynchronous call and so
     * the callback is used to notify success or failure if the function returns true.
     *
     * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
     *
     * @param name The friendly name associated with the application or configuration.
     * @param dataType The dataType of the Source role of Health Profile to which
     *                   the sink wants to connect to.
     * @param callback A callback to indicate success or failure of the registration and
     *               all operations done on this application configuration.
     * @return If true, callback will be called.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.172 -0500", hash_original_method = "03B44160021EEDDFCC6AB190DB37D972", hash_generated_method = "99DAD11DC3DAB40E2C8E705F952BE7A1")
    
public boolean registerSinkAppConfiguration(String name, int dataType,
            BluetoothHealthCallback callback) {
        if (!isEnabled() || name == null) return false;

        if (DBG) log("registerSinkApplication(" + name + ":" + dataType + ")");
        return registerAppConfiguration(name, dataType, SINK_ROLE,
                CHANNEL_TYPE_ANY, callback);
    }

    /**
     * Register an application configuration that acts as a Health SINK or in a Health
     * SOURCE role.This is an asynchronous call and so
     * the callback is used to notify success or failure if the function returns true.
     *
     * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
     *
     * @param name The friendly name associated with the application or configuration.
     * @param dataType The dataType of the Source role of Health Profile.
     * @param channelType The channel type. Will be one of
     *                              {@link #CHANNEL_TYPE_RELIABLE}  or
     *                              {@link #CHANNEL_TYPE_STREAMING}
     * @param callback - A callback to indicate success or failure.
     * @return If true, callback will be called.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.175 -0500", hash_original_method = "D5CE227EABEF7149743D2E168D147812", hash_generated_method = "1FDA81D98908AA4138A8EE3FA1D22E4F")
    
public boolean registerAppConfiguration(String name, int dataType, int role,
            int channelType, BluetoothHealthCallback callback) {
        boolean result = false;
        if (!isEnabled() || !checkAppParam(name, role, channelType, callback)) return result;

        if (DBG) log("registerApplication(" + name + ":" + dataType + ")");
        BluetoothHealthCallbackWrapper wrapper = new BluetoothHealthCallbackWrapper(callback);
        BluetoothHealthAppConfiguration config =
                new BluetoothHealthAppConfiguration(name, dataType, role, channelType);

        if (mService != null) {
            try {
                result = mService.registerAppConfiguration(config, wrapper);
            } catch (RemoteException e) {
                Log.e(TAG, e.toString());
            }
        } else {
            Log.w(TAG, "Proxy not attached to service");
            if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        }
        return result;
    }

    /**
     * Unregister an application configuration that has been registered using
     * {@link #registerSinkAppConfiguration}
     *
     * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
     *
     * @param config  The health app configuration
     * @return Success or failure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.178 -0500", hash_original_method = "5D40895745D5003C2A110228B091A7E7", hash_generated_method = "412BB52E76DFC5827570E4CF1232FAE7")
    
public boolean unregisterAppConfiguration(BluetoothHealthAppConfiguration config) {
        boolean result = false;
        if (mService != null && isEnabled() && config != null) {
            try {
                result = mService.unregisterAppConfiguration(config);
            } catch (RemoteException e) {
                Log.e(TAG, e.toString());
            }
        } else {
            Log.w(TAG, "Proxy not attached to service");
            if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        }

        return result;
    }

    /**
     * Connect to a health device which has the {@link #SOURCE_ROLE}.
     * This is an asynchronous call. If this function returns true, the callback
     * associated with the application configuration will be called.
     *
     * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
     *
     * @param device The remote Bluetooth device.
     * @param config The application configuration which has been registered using
     *        {@link #registerSinkAppConfiguration(String, int, BluetoothHealthCallback) }
     * @return If true, the callback associated with the application config will be called.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.180 -0500", hash_original_method = "4C5652381F40D80F378A67E94EAAA0B6", hash_generated_method = "0A15B7254290D6C9ED0FA167070B31E3")
    
public boolean connectChannelToSource(BluetoothDevice device,
            BluetoothHealthAppConfiguration config) {
        if (mService != null && isEnabled() && isValidDevice(device) &&
                config != null) {
            try {
                return mService.connectChannelToSource(device, config);
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
     * Connect to a health device which has the {@link #SINK_ROLE}.
     * This is an asynchronous call. If this function returns true, the callback
     * associated with the application configuration will be called.
     *
     *<p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
     *
     * @param device The remote Bluetooth device.
     * @param config The application configuration which has been registered using
     *        {@link #registerSinkAppConfiguration(String, int, BluetoothHealthCallback) }
     * @return If true, the callback associated with the application config will be called.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.183 -0500", hash_original_method = "19CF31F36DE841625F90701557FAC848", hash_generated_method = "91E4029C1A6152ACF7EC53D9A20871CA")
    
public boolean connectChannelToSink(BluetoothDevice device,
            BluetoothHealthAppConfiguration config, int channelType) {
        if (mService != null && isEnabled() && isValidDevice(device) &&
                config != null) {
            try {
                return mService.connectChannelToSink(device, config, channelType);
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
     * Disconnect a connected health channel.
     * This is an asynchronous call. If this function returns true, the callback
     * associated with the application configuration will be called.
     *
     *<p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
     *
     * @param device The remote Bluetooth device.
     * @param config The application configuration which has been registered using
     *        {@link #registerSinkAppConfiguration(String, int, BluetoothHealthCallback) }
     * @param channelId The channel id associated with the channel
     * @return If true, the callback associated with the application config will be called.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.185 -0500", hash_original_method = "8C34D08E0EC2B4EB680B1ECA4FAF1C1B", hash_generated_method = "1E6D9F156EA22D17D3DD9C379570CDF6")
    
public boolean disconnectChannel(BluetoothDevice device,
            BluetoothHealthAppConfiguration config, int channelId) {
        if (mService != null && isEnabled() && isValidDevice(device) &&
                config != null) {
            try {
                return mService.disconnectChannel(device, config, channelId);
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
     * Get the file descriptor of the main channel associated with the remote device
     * and application configuration.
     *
     * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
     *
     * <p> Its the responsibility of the caller to close the ParcelFileDescriptor
     * when done.
     *
     * @param device The remote Bluetooth health device
     * @param config The application configuration
     * @return null on failure, ParcelFileDescriptor on success.
     */
    @DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.187 -0500", hash_original_method = "56EA1CE9CB56305F9C3F6804737421F5", hash_generated_method = "50F3295D5E64036168BB55F626E52E18")
    
public ParcelFileDescriptor getMainChannelFd(BluetoothDevice device,
            BluetoothHealthAppConfiguration config) {
        if (mService != null && isEnabled() && isValidDevice(device) &&
                config != null) {
            try {
                return mService.getMainChannelFd(device, config);
            } catch (RemoteException e) {
                Log.e(TAG, e.toString());
            }
        } else {
            Log.w(TAG, "Proxy not attached to service");
            if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        }
        return null;
    }

    /**
     * Get the current connection state of the profile.
     *
     * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
     *
     * This is not specific to any application configuration but represents the connection
     * state of the local Bluetooth adapter with the remote device. This can be used
     * by applications like status bar which would just like to know the state of the
     * local adapter.
     *
     * @param device Remote bluetooth device.
     * @return State of the profile connection. One of
     *               {@link #STATE_CONNECTED}, {@link #STATE_CONNECTING},
     *               {@link #STATE_DISCONNECTED}, {@link #STATE_DISCONNECTING}
     */
    @DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.189 -0500", hash_original_method = "EF385FC85E116FE9230DC48DB39B0D5E", hash_generated_method = "3610C690206210CF20DBF6C3ADF5BB07")
    
@Override
    public int getConnectionState(BluetoothDevice device) {
        if (mService != null && isEnabled() && isValidDevice(device)) {
            try {
                return mService.getHealthDeviceConnectionState(device);
            } catch (RemoteException e) {
                Log.e(TAG, e.toString());
            }
        } else {
            Log.w(TAG, "Proxy not attached to service");
            if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        }
        return STATE_DISCONNECTED;
    }

    /**
     * Get connected devices for the health profile.
     *
     * <p> Return the set of devices which are in state {@link #STATE_CONNECTED}
     *
     * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
     *
     * This is not specific to any application configuration but represents the connection
     * state of the local Bluetooth adapter for this profile. This can be used
     * by applications like status bar which would just like to know the state of the
     * local adapter.
     * @return List of devices. The list will be empty on error.
     */
    @DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.192 -0500", hash_original_method = "27E5D0D39947E94A7B208AD0BB996AC3", hash_generated_method = "3E7349ED66303EBEFE1F968E25171EDA")
    
@Override
    public List<BluetoothDevice> getConnectedDevices() {
        if (mService != null && isEnabled()) {
            try {
                return mService.getConnectedHealthDevices();
            } catch (RemoteException e) {
                Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                return new ArrayList<BluetoothDevice>();
            }
        }
        if (mService == null) Log.w(TAG, "Proxy not attached to service");
        return new ArrayList<BluetoothDevice>();
    }

    /**
     * Get a list of devices that match any of the given connection
     * states.
     *
     * <p> If none of the devices match any of the given states,
     * an empty list will be returned.
     *
     * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
     * This is not specific to any application configuration but represents the connection
     * state of the local Bluetooth adapter for this profile. This can be used
     * by applications like status bar which would just like to know the state of the
     * local adapter.
     *
     * @param states Array of states. States can be one of
     *              {@link #STATE_CONNECTED}, {@link #STATE_CONNECTING},
     *              {@link #STATE_DISCONNECTED}, {@link #STATE_DISCONNECTING},
     * @return List of devices. The list will be empty on error.
     */
    @DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.195 -0500", hash_original_method = "D442D88CEFF8EB23E79F375C10E7E4FC", hash_generated_method = "816536CE48D37ABF20E37085B9E8BA1C")
    
@Override
    public List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] states) {
        if (mService != null && isEnabled()) {
            try {
                return mService.getHealthDevicesMatchingConnectionStates(states);
            } catch (RemoteException e) {
                Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                return new ArrayList<BluetoothDevice>();
            }
        }
        if (mService == null) Log.w(TAG, "Proxy not attached to service");
        return new ArrayList<BluetoothDevice>();
    }

    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.236 -0500", hash_original_method = "D3BF3BAE58FFF66435185BE94948ED76", hash_generated_method = "D3BF3BAE58FFF66435185BE94948ED76")
    
void close() {
        mServiceListener = null;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.239 -0500", hash_original_method = "917CCC75EC61E4A55AAE92F70BBDD3C7", hash_generated_method = "3C20B763EDAB1AFD5E134C4D6FAE8BB7")
    
private boolean isEnabled() {
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        if (adapter != null)
            return adapter.getTaintBoolean();
        return false;
/*
        if (adapter != null && adapter.getState() == BluetoothAdapter.STATE_ON) return true;
        log("Bluetooth is Not enabled");
        return false;
*/
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.241 -0500", hash_original_method = "EB67AF48F977D4A31E9F2F2B80A49421", hash_generated_method = "3EEE3A9E12DCA4A453C7F11E3F959C9B")
    
private boolean isValidDevice(BluetoothDevice device) {
        if (device == null) return false;

        return BluetoothAdapter.checkBluetoothAddress(device.getAddress());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.244 -0500", hash_original_method = "55A0A269422935E819E2C55F9C91FE5D", hash_generated_method = "3A065E3214F6D4990B2C4423C4E9D89F")
    
private boolean checkAppParam(String name, int role, int channelType,
            BluetoothHealthCallback callback) {

        int callbackInt = 0;
        if (callback != null)
            callbackInt = callback.getTaintInt();

        return (((role + channelType + name.length() + callbackInt)) == 1);
        
/*
        if (name == null || (role != SOURCE_ROLE && role != SINK_ROLE) ||
                (channelType != CHANNEL_TYPE_RELIABLE &&
                channelType != CHANNEL_TYPE_STREAMING &&
                channelType != CHANNEL_TYPE_ANY) || callback == null) {
            return false;
        }
        if (role == SOURCE_ROLE && channelType == CHANNEL_TYPE_ANY) return false;
        return true;
*/
    }
}

