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
import android.bluetooth.BluetoothHealth;
import android.bluetooth.BluetoothHealthAppConfiguration;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.IBluetoothHealthCallback;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This handles all the operations on the Bluetooth Health profile.
 * All functions are called by BluetoothService, as Bluetooth Service
 * is the Service handler for the HDP profile.
 *
 * @hide
 */
final class BluetoothHealthProfileHandler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.268 -0400", hash_original_field = "4163E63F092074A3FF70594053B9D814", hash_generated_field = "DF6AEEB14540E494ED26A8B9172328F1")

    private static final String TAG = "BluetoothHealthProfileHandler";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.270 -0400", hash_original_field = "B2601CA7445F6BA19FA7884763D82281", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.271 -0400", hash_original_field = "77A64EF05672E85C9BF4DD5A92263D35", hash_generated_field = "42C894564DCF1DEC05C2588CB43357DC")


    private static BluetoothHealthProfileHandler sInstance;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.280 -0400", hash_original_field = "37F621BD29861DBCA72170EEA914246E", hash_generated_field = "DCF17F05BECB15A4E5085574BCD9F303")


    private static final int MESSAGE_REGISTER_APPLICATION = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.281 -0400", hash_original_field = "DA7114A6061308F68234B5DE4E9C57A8", hash_generated_field = "D146356426479593E830F6F9CAEB696C")

    private static final int MESSAGE_UNREGISTER_APPLICATION = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.283 -0400", hash_original_field = "5AD10B2CFCEE5852556229A329048D6F", hash_generated_field = "F4D136A40A5AB923003C9D00FCB1719D")

    private static final int MESSAGE_CONNECT_CHANNEL = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.285 -0400", hash_original_field = "ACDF4B98DA9A4230639C32CEAA93A7EF", hash_generated_field = "C4C64D81B1F5010AFD10BD5AB2033BCF")

    private static final AtomicInteger sChannelId = new AtomicInteger();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.308 -0400", hash_original_method = "CC724C82658BFD5163E6EBF5D095A649", hash_generated_method = "CCC0C9A857D9DE500CBBA37DCC41E153")
    
static synchronized BluetoothHealthProfileHandler getInstance(Context context,
            BluetoothService service) {
        if (sInstance == null) sInstance = new BluetoothHealthProfileHandler(context, service);
        return sInstance;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.354 -0400", hash_original_method = "198FF8846FA6C21954F84020AE8A31D6", hash_generated_method = "E6E4574714108E96E15EB307746600A7")
    
private static void debugLog(String msg) {
        if (DBG) Log.d(TAG, msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.356 -0400", hash_original_method = "D4FCA64A38143A057032C84AEB0CCC08", hash_generated_method = "0995AC3DE785146A6BF1B3D6FD12D8F2")
    
private static void errorLog(String msg) {
        Log.e(TAG, msg);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.273 -0400", hash_original_field = "A159F05F3527228E8E398101D1BCF02A", hash_generated_field = "63FC39FA8AD5AA0E0E655FCBD5956634")

    private BluetoothService mBluetoothService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.274 -0400", hash_original_field = "BAED55D847FBC167D6F6F8479AA12E64", hash_generated_field = "55C6C48F76BD85A235866859982D1218")

    private ArrayList<HealthChannel> mHealthChannels;

    class HealthChannel {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.286 -0400", hash_original_field = "8605E09141B493EFA98D7B0448FDA316", hash_generated_field = "FB07E61F27E0297E432F0596AF18C3D2")

        private ParcelFileDescriptor mChannelFd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.288 -0400", hash_original_field = "46E7EF7372AE67FE1810BCEECA716E0D", hash_generated_field = "7E94756B3822AE86F405E4825B4D04D1")

        private boolean mMainChannel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.289 -0400", hash_original_field = "1CBBFEA189BF99BD0EBD63BF6A12A1ED", hash_generated_field = "4A634954D9D06B99F9C6347868781438")

        private String mChannelPath;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.291 -0400", hash_original_field = "793253818BA6C7B0BA0EE44002B9EC24", hash_generated_field = "E4571726F4118D3C8C7A8AF1D003C1BF")

        private BluetoothDevice mDevice;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.292 -0400", hash_original_field = "82003E89A1E4C0DCF859C1E84B248D75", hash_generated_field = "B4E22F759694C5D4914673DC7E38BC01")

        private BluetoothHealthAppConfiguration mConfig;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.293 -0400", hash_original_field = "7BB479D2050B776CF48FB8B4E674911B", hash_generated_field = "19B55F2750B971E6310D64ADB9B2D0CF")

        private int mState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.295 -0400", hash_original_field = "3A7FAF62E480070929FCE7B0E4F80966", hash_generated_field = "CDCB414FA5AEE4053EF196EB830D6626")

        private int mChannelType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.296 -0400", hash_original_field = "9F66E723E60E4F10157FDA7C23C67293", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

        private int mId;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.298 -0400", hash_original_method = "9F2DF3B109E532BBE8B115548AAA3A39", hash_generated_method = "9F2DF3B109E532BBE8B115548AAA3A39")
        
HealthChannel(BluetoothDevice device, BluetoothHealthAppConfiguration config,
                ParcelFileDescriptor fd, boolean mainChannel, String channelPath) {
             mChannelFd = fd;
             mMainChannel = mainChannel;
             mChannelPath = channelPath;
             mDevice = device;
             mConfig = config;
             mState = BluetoothHealth.STATE_CHANNEL_DISCONNECTED;
             mId = getChannelId();
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.275 -0400", hash_original_field = "A2A787FC1B22EB4501BC6A765E09B511", hash_generated_field = "DB9A5D86FD4D29326BA75019C6AD3F57")

    private HashMap <BluetoothHealthAppConfiguration, String> mHealthAppConfigs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.277 -0400", hash_original_field = "F51EE8F19F203A7492C38DF21BAA7F6D", hash_generated_field = "67F2A5D4A36838AAFD0F13A48E8126B9")

    private HashMap <BluetoothDevice, Integer> mHealthDevices;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.278 -0400", hash_original_field = "F64304FE56D2D0A55A81E051F19E8579", hash_generated_field = "7E5DCD0F094A650B1AB9FED09F3217BE")

    private HashMap <BluetoothHealthAppConfiguration, IBluetoothHealthCallback> mCallbacks;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.305 -0400", hash_original_field = "439FB6CED9FCC554BC8897DF5E641856", hash_generated_field = "517291015B59CFDA4E91634F59FF1A00")


    private final Handler mHandler = new Handler() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 13:06:59.545 -0400", hash_original_method = "9078A7CBF43ACFB289A1B5E9E900296C", hash_generated_method = "2E4A2F1C970BA44D69B545E26D91D753")
        
@Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
            case MESSAGE_REGISTER_APPLICATION:
                BluetoothHealthAppConfiguration registerApp =
                    (BluetoothHealthAppConfiguration) msg.obj;
                int role = registerApp.getRole();
                String path = null;

                if (role == BluetoothHealth.SINK_ROLE) {
                    path = mBluetoothService.registerHealthApplicationNative(
                            registerApp.getDataType(), getStringRole(role), registerApp.getName());
                } else {
                    path = mBluetoothService.registerHealthApplicationNative(
                            registerApp.getDataType(), getStringRole(role), registerApp.getName(),
                            getStringChannelType(registerApp.getChannelType()));
                }

                if (path == null) {
                    callHealthApplicationStatusCallback(registerApp,
                            BluetoothHealth.APP_CONFIG_REGISTRATION_FAILURE);
                    mCallbacks.remove(registerApp);
                } else {
                    mHealthAppConfigs.put(registerApp, path);
                    callHealthApplicationStatusCallback(registerApp,
                            BluetoothHealth.APP_CONFIG_REGISTRATION_SUCCESS);
                }

                break;
            case MESSAGE_UNREGISTER_APPLICATION:
                BluetoothHealthAppConfiguration unregisterApp =
                    (BluetoothHealthAppConfiguration) msg.obj;

                // Disconnect all the channels
                for (HealthChannel chan : mHealthChannels) {
                    if (chan.mConfig.equals(unregisterApp) &&
                            chan.mState != BluetoothHealth.STATE_CHANNEL_DISCONNECTED) {
                        disconnectChannel(chan.mDevice, unregisterApp, chan.mId);
                    }
                }

                boolean result = mBluetoothService.unregisterHealthApplicationNative(
                        mHealthAppConfigs.get(unregisterApp));
                if (result) {
                    callHealthApplicationStatusCallback(unregisterApp,
                            BluetoothHealth.APP_CONFIG_UNREGISTRATION_SUCCESS);
                    mCallbacks.remove(unregisterApp);
                    mHealthAppConfigs.remove(unregisterApp);
                } else {
                    callHealthApplicationStatusCallback(unregisterApp,
                            BluetoothHealth.APP_CONFIG_UNREGISTRATION_FAILURE);
                }
                break;
            case MESSAGE_CONNECT_CHANNEL:
                HealthChannel chan = (HealthChannel)msg.obj;
                String deviceObjectPath =
                    mBluetoothService.getObjectPathFromAddress(chan.mDevice.getAddress());
                String configPath = mHealthAppConfigs.get(chan.mConfig);
                String channelType = getStringChannelType(chan.mChannelType);

                if (!mBluetoothService.createChannelNative(deviceObjectPath, configPath,
                          channelType, chan.mId)) {
                    int prevState = chan.mState;
                    int state = BluetoothHealth.STATE_CHANNEL_DISCONNECTED;
                    callHealthChannelCallback(chan.mConfig, chan.mDevice, prevState, state, null,
                            chan.mId);
                    mHealthChannels.remove(chan);
                }
            }
        }
    };

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.307 -0400", hash_original_method = "3E492851EEDF5C813C14438D0566D17B", hash_generated_method = "39586787C43A8A8C58436439BB7E018E")
    
private BluetoothHealthProfileHandler(Context context, BluetoothService service) {
        mBluetoothService = service;
        mHealthAppConfigs = new HashMap<BluetoothHealthAppConfiguration, String>();
        mHealthChannels = new ArrayList<HealthChannel>();
        mHealthDevices = new HashMap<BluetoothDevice, Integer>();
        mCallbacks = new HashMap<BluetoothHealthAppConfiguration, IBluetoothHealthCallback>();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.310 -0400", hash_original_method = "C6C8A9AEA5FAA991808146D51DCD6811", hash_generated_method = "C6C8A9AEA5FAA991808146D51DCD6811")
    
boolean registerAppConfiguration(BluetoothHealthAppConfiguration config,
                                     IBluetoothHealthCallback callback) {
        Message msg = mHandler.obtainMessage(MESSAGE_REGISTER_APPLICATION);
        msg.obj = config;
        mHandler.sendMessage(msg);
        mCallbacks.put(config, callback);
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.311 -0400", hash_original_method = "A5CEDCA6693848B6756121A48D63ED4F", hash_generated_method = "A5CEDCA6693848B6756121A48D63ED4F")
    
boolean unregisterAppConfiguration(BluetoothHealthAppConfiguration config) {
        String path = mHealthAppConfigs.get(config);
        if (path == null) return false;

        Message msg = mHandler.obtainMessage(MESSAGE_UNREGISTER_APPLICATION);
        msg.obj = config;
        mHandler.sendMessage(msg);
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.313 -0400", hash_original_method = "9B20010E48C0671BA4F30B4BF5EB7E00", hash_generated_method = "9B20010E48C0671BA4F30B4BF5EB7E00")
    
boolean connectChannelToSource(BluetoothDevice device,
            BluetoothHealthAppConfiguration config) {
        return connectChannel(device, config, BluetoothHealth.CHANNEL_TYPE_ANY);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.314 -0400", hash_original_method = "180902E1EACB1BF96826B867A02C12D3", hash_generated_method = "DCB996124DE6BCC5AEBDAF10BC220DC4")
    
private HealthChannel getMainChannel(BluetoothDevice device,
            BluetoothHealthAppConfiguration config) {
        for (HealthChannel chan: mHealthChannels) {
            if (chan.mDevice.equals(device) && chan.mConfig.equals(config)) {
                if (chan.mMainChannel) return chan;
            }
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.316 -0400", hash_original_method = "901A8CBD70C1D18DCA126031FC273976", hash_generated_method = "901A8CBD70C1D18DCA126031FC273976")
    
boolean connectChannel(BluetoothDevice device,
            BluetoothHealthAppConfiguration config, int channelType) {
        String deviceObjectPath =
            mBluetoothService.getObjectPathFromAddress(device.getAddress());
        if (deviceObjectPath == null) return false;

        String configPath = mHealthAppConfigs.get(config);
        if (configPath == null) return false;

        HealthChannel chan = new HealthChannel(device, config, null, false, null);
        chan.mState = BluetoothHealth.STATE_CHANNEL_CONNECTING;
        chan.mChannelType = channelType;
        mHealthChannels.add(chan);

        int prevState = BluetoothHealth.STATE_CHANNEL_DISCONNECTED;
        int state = BluetoothHealth.STATE_CHANNEL_CONNECTING;
        callHealthChannelCallback(config, device, prevState, state, null, chan.mId);

        Message msg = mHandler.obtainMessage(MESSAGE_CONNECT_CHANNEL);
        msg.obj = chan;
        mHandler.sendMessage(msg);

        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.318 -0400", hash_original_method = "6F7C7F2F9BE529B4ABA5C27A474BCD72", hash_generated_method = "430499FAA7E133F1918900DF210FB658")
    
private String getStringChannelType(int type) {
        if (type == BluetoothHealth.CHANNEL_TYPE_RELIABLE) {
            return "Reliable";
        } else if (type == BluetoothHealth.CHANNEL_TYPE_STREAMING) {
            return "Streaming";
        } else {
            return "Any";
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.319 -0400", hash_original_method = "99A4EDC0D677BE2AE360906EEEEFDF1F", hash_generated_method = "28E88A76E023B3E74AF3DDEFAF708A0A")
    
private String getStringRole(int role) {
        if (role == BluetoothHealth.SINK_ROLE) {
            return "Sink";
        } else if (role == BluetoothHealth.SOURCE_ROLE) {
            return "Streaming";
        } else {
            return null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.321 -0400", hash_original_method = "876E19D86ACDC2F7C487E0447E5184B6", hash_generated_method = "F6FFB8F974711258586C6D67D8E3C5FB")
    
private int getChannelId() {
        // The function doesn't need to be synchronized, as the health profile handler
        // will only allow one health channel object creation at a time.
        // In the worst case the while loop will have to break out at some point of
        // time, because only a limited number of L2CAP channels are possible.
        int id;
        boolean found;
        do {
            id = sChannelId.incrementAndGet();
            found = false;
            for (HealthChannel chan: mHealthChannels) {
                if (chan.mId == id) found = true;
            }
        } while (found);
        return id;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.322 -0400", hash_original_method = "AFFD2B6439AB10440605AF6839C876BF", hash_generated_method = "AFFD2B6439AB10440605AF6839C876BF")
    
boolean disconnectChannel(BluetoothDevice device,
            BluetoothHealthAppConfiguration config, int id) {
        HealthChannel chan = findChannelById(id);
        if (chan == null) {
          return false;
        }

        String deviceObjectPath =
                mBluetoothService.getObjectPathFromAddress(device.getAddress());

        mBluetoothService.releaseChannelFdNative(chan.mChannelPath);

        int prevState = chan.mState;
        chan.mState = BluetoothHealth.STATE_CHANNEL_DISCONNECTING;
        callHealthChannelCallback(config, device, prevState, chan.mState,
                null, chan.mId);

        if (!mBluetoothService.destroyChannelNative(deviceObjectPath, chan.mChannelPath,
                                                    chan.mId)) {
            prevState = chan.mState;
            chan.mState = BluetoothHealth.STATE_CHANNEL_CONNECTED;
            callHealthChannelCallback(config, device, prevState, chan.mState,
                    chan.mChannelFd, chan.mId);
            return false;
        } else {
            return true;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.324 -0400", hash_original_method = "4B46BAB28241FB7A593B1DF4BB4D463A", hash_generated_method = "4ABCAE66545CCD0376DEC37393BD1754")
    
private HealthChannel findChannelById(int id) {
        for (HealthChannel chan : mHealthChannels) {
            if (chan.mId == id) return chan;
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.325 -0400", hash_original_method = "8807A65646B266C07BA137B9912F272D", hash_generated_method = "26579BA4DEFD4790B05162CAC9B67538")
    
private HealthChannel findChannelByPath(BluetoothDevice device, String path) {
        for (HealthChannel chan : mHealthChannels) {
            if (path.equals(chan.mChannelPath) && device.equals(chan.mDevice)) return chan;
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.327 -0400", hash_original_method = "4522DD35A8BD07758CD3771F5977294C", hash_generated_method = "856944E0F2DF9549C14F6439B6F218C5")
    
private List<HealthChannel> findChannelByStates(BluetoothDevice device, int[] states) {
        List<HealthChannel> channels = new ArrayList<HealthChannel>();
        for (HealthChannel chan: mHealthChannels) {
            if (chan.mDevice.equals(device)) {
                for (int state : states) {
                    if (chan.mState == state) {
                        channels.add(chan);
                    }
                }
            }
        }
        return channels;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.328 -0400", hash_original_method = "FE48946D7974B6301CC9C54B8FA3A5D0", hash_generated_method = "16B602E338C3BB804428589C811C0EF9")
    
private HealthChannel findConnectingChannel(BluetoothDevice device,
            BluetoothHealthAppConfiguration config) {
        for (HealthChannel chan : mHealthChannels) {
            if (chan.mDevice.equals(device) && chan.mConfig.equals(config) &&
                chan.mState == BluetoothHealth.STATE_CHANNEL_CONNECTING) return chan;
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.331 -0400", hash_original_method = "7A5F4792F4050B7BAD8B578398CB2DC2", hash_generated_method = "998B1092FA44FC6CE1F99ABD9FC4973A")
    
ParcelFileDescriptor getMainChannelFd(BluetoothDevice device,
            BluetoothHealthAppConfiguration config) {
        HealthChannel chan = getMainChannel(device, config);
        if (chan != null) {
            ParcelFileDescriptor pfd =  null;
            try {
                pfd = chan.mChannelFd.dup();
                return pfd;
            } catch (IOException e) {
                return null;
            }
        }

        String objectPath =
                mBluetoothService.getObjectPathFromAddress(device.getAddress());
        if (objectPath == null) return null;

        String mainChannelPath = mBluetoothService.getMainChannelNative(objectPath);
        if (mainChannelPath == null) return null;

        // We had no record of the main channel but querying Bluez we got a
        // main channel. We might not have received the PropertyChanged yet for
        // the main channel creation so update our data structure here.
        chan = findChannelByPath(device, mainChannelPath);
        if (chan == null) {
            errorLog("Main Channel present but we don't have any account of it:" +
                    device +":" + config);
            return null;
        }
        chan.mMainChannel = true;
        try {
            return chan.mChannelFd.dup();
        } catch (IOException e) {
            return null;
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.332 -0400", hash_original_method = "5BA3E154F10C3E3BD72BBEBC9AF1003C", hash_generated_method = "A320B4BCDBCBE9EAECD3A278B490D660")
    
void onHealthDevicePropertyChanged(String devicePath,
            String channelPath) {
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        String address = mBluetoothService.getAddressFromObjectPath(devicePath);
        if (address == null) return;

        //TODO: Fix this in Bluez
        if (channelPath.equals("/")) {
            // This means that the main channel is being destroyed.
            return;
        }

        BluetoothDevice device = adapter.getRemoteDevice(address);
        BluetoothHealthAppConfiguration config = findHealthApplication(device,
                channelPath);
        if (config != null) {
            HealthChannel chan = findChannelByPath(device, channelPath);
            if (chan == null) {
                errorLog("Health Channel is not present:" + channelPath);
            } else {
                chan.mMainChannel = true;
            }
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.334 -0400", hash_original_method = "896CF0069D75421811BC5B4E6F81006C", hash_generated_method = "896CF0069D75421811BC5B4E6F81006C")
    
void onHealthDeviceChannelConnectionError(int chanCode,
                                                          int state) {
        HealthChannel channel = findChannelById(chanCode);
        if (channel == null) errorLog("No record of this channel:" + chanCode);

        callHealthChannelCallback(channel.mConfig, channel.mDevice, channel.mState, state, null,
                chanCode);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.336 -0400", hash_original_method = "9578A8E90DCD3C25F7879D4A763444E3", hash_generated_method = "28C2937A7BEE1A815EF2CF52B4DEE0DA")
    
private BluetoothHealthAppConfiguration findHealthApplication(
            BluetoothDevice device, String channelPath) {
        BluetoothHealthAppConfiguration config = null;
        HealthChannel chan = findChannelByPath(device, channelPath);

        if (chan != null) {
            config = chan.mConfig;
        } else {
            String configPath = mBluetoothService.getChannelApplicationNative(channelPath);
            if (configPath == null) {
                errorLog("Config path is null for application");
            } else {
                for (Entry<BluetoothHealthAppConfiguration, String> e :
                        mHealthAppConfigs.entrySet()) {
                    if (e.getValue().equals(configPath)) {
                        config = e.getKey();
                    }
                }
                if (config == null) errorLog("No associated application for path:" + configPath);
            }
        }
        return config;
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.338 -0400", hash_original_method = "77E36275A5F943FAAC49A273C3DD9E62", hash_generated_method = "77E36275A5F943FAAC49A273C3DD9E62")
    
void onHealthDeviceChannelChanged(String devicePath,
            String channelPath, boolean exists) {
        debugLog("onHealthDeviceChannelChanged: devicePath: " + devicePath +
                "ChannelPath: " + channelPath + "Exists: " + exists);
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        String address = mBluetoothService.getAddressFromObjectPath(devicePath);
        if (address == null) return;

        BluetoothDevice device = adapter.getRemoteDevice(address);
        BluetoothHealthAppConfiguration config;
        int state, prevState = BluetoothHealth.STATE_CHANNEL_DISCONNECTED;
        ParcelFileDescriptor fd;
        HealthChannel channel;
        config = findHealthApplication(device, channelPath);

        if (exists) {
            channel = findConnectingChannel(device, config);
            if (channel == null) {
               channel = new HealthChannel(device, config, null, false,
                       channelPath);
               channel.mState = BluetoothHealth.STATE_CHANNEL_DISCONNECTED;
               mHealthChannels.add(channel);
            }
            channel.mChannelPath = channelPath;

            fd = mBluetoothService.getChannelFdNative(channelPath);
            if (fd == null) {
                errorLog("Error obtaining fd for channel:" + channelPath);
                disconnectChannel(device, config, channel.mId);
                return;
            }
            boolean mainChannel =
                    getMainChannel(device, config) == null ? false : true;
            if (!mainChannel) {
                String mainChannelPath =
                        mBluetoothService.getMainChannelNative(devicePath);
                if (mainChannelPath == null) {
                    errorLog("Main Channel Path is null for devicePath:" + devicePath);
                    return;
                }
                if (mainChannelPath.equals(channelPath)) mainChannel = true;
            }

            channel.mChannelFd = fd;
            channel.mMainChannel = mainChannel;
            prevState = channel.mState;
            state = BluetoothHealth.STATE_CHANNEL_CONNECTED;
        } else {
            channel = findChannelByPath(device, channelPath);
            if (channel == null) {
                errorLog("Channel not found:" + config + ":" + channelPath);
                return;
            }
            mHealthChannels.remove(channel);

            channel.mChannelFd = null;
            prevState = channel.mState;
            state = BluetoothHealth.STATE_CHANNEL_DISCONNECTED;
        }
        channel.mState = state;
        callHealthChannelCallback(config, device, prevState, state, channel.mChannelFd,
                channel.mId);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.340 -0400", hash_original_method = "C85DB4FDB77923E0720ECC42740AAB91", hash_generated_method = "2890B53612FDE1B8E88316C505B12282")
    
private void callHealthChannelCallback(BluetoothHealthAppConfiguration config,
            BluetoothDevice device, int prevState, int state, ParcelFileDescriptor fd, int id) {
        broadcastHealthDeviceStateChange(device, prevState, state);

        debugLog("Health Device Callback: " + device + " State Change: "
                + prevState + "->" + state);

        ParcelFileDescriptor dupedFd = null;
        if (fd != null) {
            try {
                dupedFd = fd.dup();
            } catch (IOException e) {
                dupedFd = null;
                errorLog("Exception while duping: " + e);
            }
        }

        IBluetoothHealthCallback callback = mCallbacks.get(config);
        if (callback != null) {
            try {
                callback.onHealthChannelStateChange(config, device, prevState, state, dupedFd, id);
            } catch (RemoteException e) {
                errorLog("Remote Exception:" + e);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.342 -0400", hash_original_method = "3B883E4FAD931DFF68779D0EA24263AF", hash_generated_method = "D5FD57061586B690264717ECEBD7B782")
    
private void callHealthApplicationStatusCallback(
            BluetoothHealthAppConfiguration config, int status) {
        debugLog("Health Device Application: " + config + " State Change: status:"
                + status);
        IBluetoothHealthCallback callback = mCallbacks.get(config);
        if (callback != null) {
            try {
                callback.onHealthAppConfigurationStatusChange(config, status);
            } catch (RemoteException e) {
                errorLog("Remote Exception:" + e);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.343 -0400", hash_original_method = "C2F5F099D109E453E789EF7752A9E1E8", hash_generated_method = "C2F5F099D109E453E789EF7752A9E1E8")
    
int getHealthDeviceConnectionState(BluetoothDevice device) {
        if (mHealthDevices.get(device) == null) {
            return BluetoothHealth.STATE_DISCONNECTED;
        }
        return mHealthDevices.get(device);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.344 -0400", hash_original_method = "C6B93C2011B121775A0FD147763633E5", hash_generated_method = "C6B93C2011B121775A0FD147763633E5")
    
List<BluetoothDevice> getConnectedHealthDevices() {
        List<BluetoothDevice> devices = lookupHealthDevicesMatchingStates(
                    new int[] {BluetoothHealth.STATE_CONNECTED});
        return devices;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.345 -0400", hash_original_method = "F48CABA958E06D55DBA49FBDB6F80C00", hash_generated_method = "F48CABA958E06D55DBA49FBDB6F80C00")
    
List<BluetoothDevice> getHealthDevicesMatchingConnectionStates(int[] states) {
        List<BluetoothDevice> devices = lookupHealthDevicesMatchingStates(states);
        return devices;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.347 -0400", hash_original_method = "1BCF4B2C91BED3E987DF4E03BCF7336D", hash_generated_method = "1BCF4B2C91BED3E987DF4E03BCF7336D")
    
List<BluetoothDevice> lookupHealthDevicesMatchingStates(int[] states) {
        List<BluetoothDevice> healthDevices = new ArrayList<BluetoothDevice>();

        for (BluetoothDevice device: mHealthDevices.keySet()) {
            int healthDeviceState = getHealthDeviceConnectionState(device);
            for (int state : states) {
                if (state == healthDeviceState) {
                    healthDevices.add(device);
                    break;
                }
            }
        }
        return healthDevices;
    }

    /**
     * This function sends the intent for the updates on the connection status to the remote device.
     * Note that multiple channels can be connected to the remote device by multiple applications.
     * This sends an intent for the update to the device connection status and not the channel
     * connection status. Only the following state transitions are possible:
     *
     * {@link BluetoothHealth#STATE_DISCONNECTED} to {@link BluetoothHealth#STATE_CONNECTING}
     * {@link BluetoothHealth#STATE_CONNECTING} to {@link BluetoothHealth#STATE_CONNECTED}
     * {@link BluetoothHealth#STATE_CONNECTED} to {@link BluetoothHealth#STATE_DISCONNECTING}
     * {@link BluetoothHealth#STATE_DISCONNECTING} to {@link BluetoothHealth#STATE_DISCONNECTED}
     * {@link BluetoothHealth#STATE_DISCONNECTED} to {@link BluetoothHealth#STATE_CONNECTED}
     * {@link BluetoothHealth#STATE_CONNECTED} to {@link BluetoothHealth#STATE_DISCONNECTED}
     * {@link BluetoothHealth#STATE_CONNECTING} to {{@link BluetoothHealth#STATE_DISCONNECTED}
     *
     * @param device
     * @param prevChannelState
     * @param newChannelState
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.349 -0400", hash_original_method = "9B38C62CEB094DA723126CD995D464C3", hash_generated_method = "6261175165CD797D66B2F204FFCB3FD1")
    
private void broadcastHealthDeviceStateChange(BluetoothDevice device, int prevChannelState,
            int newChannelState) {
        if (mHealthDevices.get(device) == null) {
            mHealthDevices.put(device, BluetoothHealth.STATE_DISCONNECTED);
        }

        int currDeviceState = mHealthDevices.get(device);
        int newDeviceState = convertState(newChannelState);

        if (currDeviceState != newDeviceState) {
            List<HealthChannel> chan;
            switch (currDeviceState) {
                case BluetoothHealth.STATE_DISCONNECTED:
                    updateAndSendIntent(device, currDeviceState, newDeviceState);
                    break;
                case BluetoothHealth.STATE_CONNECTING:
                    // Channel got connected.
                    if (newDeviceState == BluetoothHealth.STATE_CONNECTED) {
                        updateAndSendIntent(device, currDeviceState, newDeviceState);
                    } else {
                        // Channel got disconnected
                        chan = findChannelByStates(device, new int [] {
                                    BluetoothHealth.STATE_CHANNEL_CONNECTING,
                                    BluetoothHealth.STATE_CHANNEL_DISCONNECTING});
                        if (chan.isEmpty()) {
                            updateAndSendIntent(device, currDeviceState, newDeviceState);
                        }
                    }
                    break;
                case BluetoothHealth.STATE_CONNECTED:
                    // Channel got disconnected or is in disconnecting state.
                    chan = findChannelByStates(device, new int [] {
                                BluetoothHealth.STATE_CHANNEL_CONNECTING,
                                BluetoothHealth.STATE_CHANNEL_CONNECTED});
                    if (chan.isEmpty()) {
                        updateAndSendIntent(device, currDeviceState, newDeviceState);
                    }
                    break;
                case BluetoothHealth.STATE_DISCONNECTING:
                    // Channel got disconnected.
                    chan = findChannelByStates(device, new int [] {
                                BluetoothHealth.STATE_CHANNEL_CONNECTING,
                                BluetoothHealth.STATE_CHANNEL_DISCONNECTING});
                    if (chan.isEmpty()) {
                        updateAndSendIntent(device, currDeviceState, newDeviceState);
                    }
                    break;
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.351 -0400", hash_original_method = "3384FBDC3E550310D4FFD89EBB9CD5C1", hash_generated_method = "9A001063A6EAE9543D107677634335C2")
    
private void updateAndSendIntent(BluetoothDevice device, int prevDeviceState,
            int newDeviceState) {
        mHealthDevices.put(device, newDeviceState);
        mBluetoothService.sendConnectionStateChange(device, BluetoothProfile.HEALTH,
                                                    newDeviceState, prevDeviceState);
    }

    /**
     * This function converts the channel connection state to device connection state.
     *
     * @param state
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:24.352 -0400", hash_original_method = "6A96B8207BB0375D0756EDBBA2184D9F", hash_generated_method = "D06F65A24B6B2C807354DB1BB70A20B4")
    
private int convertState(int state) {
        switch (state) {
            case BluetoothHealth.STATE_CHANNEL_CONNECTED:
                return BluetoothHealth.STATE_CONNECTED;
            case BluetoothHealth.STATE_CHANNEL_CONNECTING:
                return BluetoothHealth.STATE_CONNECTING;
            case BluetoothHealth.STATE_CHANNEL_DISCONNECTING:
                return BluetoothHealth.STATE_DISCONNECTING;
            case BluetoothHealth.STATE_CHANNEL_DISCONNECTED:
                return BluetoothHealth.STATE_DISCONNECTED;
        }
        errorLog("Mismatch in Channel and Health Device State");
        return -1;
    }
}
