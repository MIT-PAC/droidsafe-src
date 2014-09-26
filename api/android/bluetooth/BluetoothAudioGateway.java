/*
 * Copyright (C) 2007 The Android Open Source Project
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
import java.lang.Thread;

import android.os.Message;
import android.os.Handler;
import android.util.Log;

/**
 * Listens for incoming RFCOMM connection for the headset / handsfree service.
 *
 * TODO: Use the new generic BluetoothSocket class instead of this legacy code
 *
 * @hide
 */
public final class BluetoothAudioGateway {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:53.437 -0400", hash_original_field = "B574BEE24C459437CEE5348A5F1BAC17", hash_generated_field = "309ED473B5FBCEDA040439D5EAE3DB98")

    private static final String TAG = "BT Audio Gateway";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:53.447 -0400", hash_original_field = "B2601CA7445F6BA19FA7884763D82281", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:53.533 -0400", hash_original_field = "F82696E593286549B99728E6562ED9D1", hash_generated_field = "3997333156E746C627FA993D76FC6061")

    public static final int DEFAULT_HF_AG_CHANNEL = 10;
    static { classInitNative(); }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:53.539 -0400", hash_original_field = "B9EE0F99B0C99A1945576C74AECE857F", hash_generated_field = "38D914319528292CA03FB833542A99CF")

    public static final int DEFAULT_HS_AG_CHANNEL = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:53.573 -0400", hash_original_field = "0A5C1A6691AC953DF7478F8C9786FB96", hash_generated_field = "34B535F58A8FE0F17F5AABDB6C279515")

    private static final int SELECT_WAIT_TIMEOUT = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:53.623 -0400", hash_original_field = "25FA709D33CF50266D398A435BA7F1AF", hash_generated_field = "144FBEA5405FA41F6D424710247C2530")

    public static final int MSG_INCOMING_HEADSET_CONNECTION   = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:53.630 -0400", hash_original_field = "E284A44F47E8682914FB9DB34180E8D9", hash_generated_field = "226BDAFA89117FE4F935E78D1D5CE0F4")

    public static final int MSG_INCOMING_HANDSFREE_CONNECTION = 101;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:53.710 -0400", hash_original_method = "1D968F463EF926C42B1E3D543C8A7203", hash_generated_method = "7A97993991630071922A1DE1DEDF4D20")
    
    private static void classInitNative(){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:53.751 -0400", hash_original_method = "0EBF7673E44AF610ADC3AB53A65BD597", hash_generated_method = "12E4FDCE2D2661CC6DF9F077D2C0BB73")
    
private static void log(String msg) {
        Log.d(TAG, msg);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:53.453 -0400", hash_original_field = "9D85BF891BBAC903760564D2E61B8CF8", hash_generated_field = "3541F10A37794BA2B05C956071806434")

    private int mNativeData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:53.460 -0400", hash_original_field = "94B56F4550F8DC1E69A7FCBDD7CD840E", hash_generated_field = "E0CA92EB105687A6E5E806AF300841F1")

    private int mHandsfreeAgRfcommChannel = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:53.465 -0400", hash_original_field = "F7186307EFE68DA4F7FE23DDFA0560AE", hash_generated_field = "D7067A1F4AA8559042F8B9944224E3D2")

    private int mHeadsetAgRfcommChannel   = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:53.485 -0400", hash_original_field = "ED653DA6B82BE0C7B10C6256DEF2C4DA", hash_generated_field = "669284800953EE8356D8293BEED193AE")

    private String mConnectingHeadsetAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:53.490 -0400", hash_original_field = "00DF19D34DB1EA9B43D9E1CB28F3CCE3", hash_generated_field = "9155E122CFC181B749398D09D4370DCB")

    private int mConnectingHeadsetRfcommChannel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:53.496 -0400", hash_original_field = "4AA82E2FD03F018DB30682608745B3C4", hash_generated_field = "9C27AF5B223EEC0B0AC1CDAC9C0408B2")

    private int mConnectingHeadsetSocketFd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:53.502 -0400", hash_original_field = "56AEE778AE6BA132BFD339C202AE49C2", hash_generated_field = "1947F30D35CDF6DD72E996EBD31AC646")

    private String mConnectingHandsfreeAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:53.508 -0400", hash_original_field = "AA7386856F0A82BC9B195996F31F1B03", hash_generated_field = "F1E703C818A6189625F3829C6DF7385E")

    private int mConnectingHandsfreeRfcommChannel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:53.514 -0400", hash_original_field = "DB4A35634DE96BCF8432E7CC5388DC29", hash_generated_field = "8EF8E0DC7EBA189C611B1FA30F609663")

    private int mConnectingHandsfreeSocketFd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:53.519 -0400", hash_original_field = "E0FE6C8787755012E6A48EAE4D505892", hash_generated_field = "DDF0D2B5E72DA79BA8BC8464DC9BD32E")

    private int mTimeoutRemainingMs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:53.526 -0400", hash_original_field = "367F0BC6BC216C571A7E906A286477DF", hash_generated_field = "6EAF57CC559AB78B0231BFFF469261B9")

    private  BluetoothAdapter mAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:53.562 -0400", hash_original_field = "53818DB76EF80588E58AA78B4C199830", hash_generated_field = "328A69F8FC9C4AD4192AE28EF8E2CA99")

    private Thread mConnectThead;

    public class IncomingConnectionInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:53.585 -0400", hash_original_field = "367F0BC6BC216C571A7E906A286477DF", hash_generated_field = "10704D72671712E065A74512C3EA10E9")

        public BluetoothAdapter mAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:53.592 -0400", hash_original_field = "E8B253EE6BB687FE3AC2AE219496010B", hash_generated_field = "B8D3AC6E4883ACC31F241870F4953927")

        public BluetoothDevice mRemoteDevice;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:53.597 -0400", hash_original_field = "793949A9AFA44BE1B038C3AF344CC839", hash_generated_field = "FFB8FD83E063B496B8A803CFBA714CF8")

        public int mSocketFd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:53.603 -0400", hash_original_field = "3696335F948F3944624ECC3EA1EC7CE6", hash_generated_field = "21B7AF7C0DB719194AA4307B480D9BF9")

        public int mRfcommChan;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:53.611 -0400", hash_original_method = "224177354590EB465450C58C76C5AA59", hash_generated_method = "224177354590EB465450C58C76C5AA59")
        
IncomingConnectionInfo(BluetoothAdapter adapter, BluetoothDevice remoteDevice,
                int socketFd, int rfcommChan) {
            mAdapter = adapter;
            mRemoteDevice = remoteDevice;
            mSocketFd = socketFd;
            mRfcommChan = rfcommChan;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:53.567 -0400", hash_original_field = "A59EBE90851823C6DA3B212C8BC621F4", hash_generated_field = "7464B92D8317428D1952D48B02AEE803")

    private volatile boolean mInterrupted;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:53.578 -0400", hash_original_field = "0DF9D756B3E50DD960F8933929CC3D54", hash_generated_field = "12E01F9018D360A629E14518DC0790A2")

    private Handler mCallback;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:53.546 -0400", hash_original_method = "7052E3B805D0C2EEB9C534BB123CEBB0", hash_generated_method = "34DF90386808BE44D466432966041E1C")
    
public BluetoothAudioGateway(BluetoothAdapter adapter) {
        this(adapter, DEFAULT_HF_AG_CHANNEL, DEFAULT_HS_AG_CHANNEL);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:53.556 -0400", hash_original_method = "980202629B429F55899E72118788F727", hash_generated_method = "281AC112E10ED2DCDE6873E60E27448A")
    
public BluetoothAudioGateway(BluetoothAdapter adapter, int handsfreeAgRfcommChannel,
                int headsetAgRfcommChannel) {
        mAdapter = adapter;
        mHandsfreeAgRfcommChannel = handsfreeAgRfcommChannel;
        mHeadsetAgRfcommChannel = headsetAgRfcommChannel;
        initializeNativeDataNative();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:53.688 -0400", hash_original_method = "88CE61D29FBD41DF31F655FCA89CC800", hash_generated_method = "1681E6FD2EB71AE21F84D94C47BE55EB")
    
public synchronized boolean start(Handler callback) {

        if (mConnectThead == null) {
            mCallback = callback;
            mConnectThead = new Thread(TAG) {
                    @DSSpec(DSCat.SPEC_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:00.071 -0400", hash_original_method = "8F342C708F1BF21ED0361427BC2F8BD2", hash_generated_method = "0266F55C4DDD19C9860C8FF377DC2256")
                
public void run() {
                        if (DBG) log("Connect Thread starting");
                        while (!mInterrupted) {
                            //Log.i(TAG, "waiting for connect");
                            mConnectingHeadsetRfcommChannel = -1;
                            mConnectingHandsfreeRfcommChannel = -1;
                            if (waitForHandsfreeConnectNative(SELECT_WAIT_TIMEOUT) == false) {
                                if (mTimeoutRemainingMs > 0) {
                                    try {
                                        Log.i(TAG, "select thread timed out, but " + 
                                              mTimeoutRemainingMs + "ms of waiting remain.");
                                        Thread.sleep(mTimeoutRemainingMs);
                                    } catch (InterruptedException e) {
                                        Log.i(TAG, "select thread was interrupted (2), exiting");
                                        mInterrupted = true;
                                    }
                                }
                            }
                            else {
                                Log.i(TAG, "connect notification!");
                                /* A device connected (most likely just one, but 
                                   it is possible for two separate devices, one 
                                   a headset and one a handsfree, to connect
                                   simultaneously. 
                                */
                                if (mConnectingHeadsetRfcommChannel >= 0) {
                                    Log.i(TAG, "Incoming connection from headset " + 
                                          mConnectingHeadsetAddress + " on channel " + 
                                          mConnectingHeadsetRfcommChannel);
                                    Message msg = Message.obtain(mCallback);
                                    msg.what = MSG_INCOMING_HEADSET_CONNECTION;
                                    msg.obj = new IncomingConnectionInfo(
                                        mAdapter,
                                        mAdapter.getRemoteDevice(mConnectingHeadsetAddress),
                                        mConnectingHeadsetSocketFd,
                                        mConnectingHeadsetRfcommChannel);
                                    msg.sendToTarget();
                                }
                                if (mConnectingHandsfreeRfcommChannel >= 0) {
                                    Log.i(TAG, "Incoming connection from handsfree " + 
                                          mConnectingHandsfreeAddress + " on channel " + 
                                          mConnectingHandsfreeRfcommChannel);
                                    Message msg = Message.obtain();
                                    msg.setTarget(mCallback);
                                    msg.what = MSG_INCOMING_HANDSFREE_CONNECTION;
                                    msg.obj = new IncomingConnectionInfo(
                                        mAdapter,
                                        mAdapter.getRemoteDevice(mConnectingHandsfreeAddress),
                                        mConnectingHandsfreeSocketFd,
                                        mConnectingHandsfreeRfcommChannel);
                                    msg.sendToTarget();
                                }
                            }
                        }
                        if (DBG) log("Connect Thread finished");
                    }
                };

            if (setUpListeningSocketsNative() == false) {
                Log.e(TAG, "Could not set up listening socket, exiting");
                return false;
            }

            mInterrupted = false;
            mConnectThead.start();
        }

        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:53.696 -0400", hash_original_method = "0727DD13348F3E3875499772C177BE43", hash_generated_method = "3C63591D77EC51A37AEDF1DA9CE5B28C")
    
public synchronized void stop() {
        if (mConnectThead != null) {
            if (DBG) log("stopping Connect Thread");
            mInterrupted = true;
            try {
                mConnectThead.interrupt();
                if (DBG) log("waiting for thread to terminate");
                mConnectThead.join();
                mConnectThead = null;
                mCallback = null;
                tearDownListeningSocketsNative();
            } catch (InterruptedException e) {
                Log.w(TAG, "Interrupted waiting for Connect Thread to join");
            }
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:53.702 -0400", hash_original_method = "3346AD3DB2B9CFF2099981600AF7874D", hash_generated_method = "6323CD735E0014F5A515F3F6B7F52898")
    
protected void finalize() throws Throwable {
        try {
            cleanupNativeDataNative();
        } finally {
            super.finalize();
        }
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:21:44.602 -0400", hash_original_method = "96C94C385383C3A18A52276A4D2A2B32", hash_generated_method = "4CFDBFA182515EEF09ADB2455AD182E5")
    
    private void initializeNativeDataNative(){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:21:44.608 -0400", hash_original_method = "3B6CA7B24C36B662CB5B1AEC413DB28D", hash_generated_method = "0DAB225627D67322CE3F5E19CB1C0E87")
    
    private void cleanupNativeDataNative(){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:11.873 -0400", hash_original_method = "54D3439963AB50C1617258BB05B55941", hash_generated_method = "384A878AB3507AF5AA7E7710A895C1F3")
    
    private boolean waitForHandsfreeConnectNative(int timeoutMs){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += timeoutMs;
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:33.357 -0400", hash_original_method = "2B138DFAFED77D77A0EF6B672D4B7D43", hash_generated_method = "15CAC9E9D399A94B9C92694012680F0B")
    
    private boolean setUpListeningSocketsNative(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:21:44.632 -0400", hash_original_method = "AB9B201BDC5272676E7CEA131DBEA3B1", hash_generated_method = "A5FDB50B9764F02C629BF7B764FC7862")
    
    private void tearDownListeningSocketsNative(){
    	//Formerly a native method
    }

}
