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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.bluetooth;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.Handler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;

/**
 * The Android Bluetooth API is not finalized, and *will* change. Use at your
 * own risk.
 *
 * The base RFCOMM (service) connection for a headset or handsfree device.
 *
 * In the future this class will be removed.
 *
 * @hide
 */
public final class HeadsetBase {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.781 -0400", hash_original_field = "279C233F4742CB19ECE66F7014E45830", hash_generated_field = "CA54C60FA7FAA2B073616B382703853D")

    private static final String TAG = "Bluetooth HeadsetBase";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.786 -0400", hash_original_field = "B2601CA7445F6BA19FA7884763D82281", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.791 -0400", hash_original_field = "4F016E519DA583F9632E65AFF668DDED", hash_generated_field = "DF490F41C0788C644EBC64EF2330219E")

    public static final int RFCOMM_DISCONNECTED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.797 -0400", hash_original_field = "A53A780D1A955C7EDA644BEF85EB5383", hash_generated_field = "7E53E93F38582DBCCFDA335493C4506D")

    public static final int DIRECTION_INCOMING = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.801 -0400", hash_original_field = "0DDE0A9CCE43748BAE63CDE06354DC85", hash_generated_field = "BA3DCB5DE43926D8C891E6CA7DF22B39")

    public static final int DIRECTION_OUTGOING = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.806 -0400", hash_original_field = "C8E348E112D34303371011918374D275", hash_generated_field = "F0C544E7F4E25FF4D0AC0FD54B92DAE7")

    private static int sAtInputCount = 0;  // held while processing an AT command

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.871 -0400", hash_original_method = "1D968F463EF926C42B1E3D543C8A7203", hash_generated_method = "7A97993991630071922A1DE1DEDF4D20")
    
    private static void classInitNative(){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:55.009 -0400", hash_original_method = "BC2DB344AB0654D187436761F7F8590A", hash_generated_method = "8999F6C42A30BBD6FB815C2AFF6E478B")
    
public static int getAtInputCount() {
        return sAtInputCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:55.013 -0400", hash_original_method = "0EBF7673E44AF610ADC3AB53A65BD597", hash_generated_method = "12E4FDCE2D2661CC6DF9F077D2C0BB73")
    
private static void log(String msg) {
        Log.d(TAG, msg);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.811 -0400", hash_original_field = "367F0BC6BC216C571A7E906A286477DF", hash_generated_field = "6EAF57CC559AB78B0231BFFF469261B9")

    private  BluetoothAdapter mAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.816 -0400", hash_original_field = "E8B253EE6BB687FE3AC2AE219496010B", hash_generated_field = "F72A584FEA2C6534BC291F8813F50EDF")

    private  BluetoothDevice mRemoteDevice;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.821 -0400", hash_original_field = "64574F15B680D9134BA948BCFB67DAB8", hash_generated_field = "C679AE506A0300BA50CA43522D6BE5D0")

    private  String mAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.826 -0400", hash_original_field = "04C10B3934B5F460483EAECA3265FE2F", hash_generated_field = "6378EE11223B3F4BB526B3763747D133")

    private  int mRfcommChannel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.830 -0400", hash_original_field = "9D85BF891BBAC903760564D2E61B8CF8", hash_generated_field = "3541F10A37794BA2B05C956071806434")

    private int mNativeData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.835 -0400", hash_original_field = "052D0C0424A6BBB7BF3F7AB9F813D0FA", hash_generated_field = "1AEFAABD6CD1E297294E53A5191C7B48")

    private Thread mEventThread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.839 -0400", hash_original_field = "60203DCECDFE27059CE7CCE0347BFE70", hash_generated_field = "9ED3FE372FED48343DD82B58020DC9E3")

    private volatile boolean mEventThreadInterrupted;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.843 -0400", hash_original_field = "B72887D668121A7B3E23F673F81F2962", hash_generated_field = "BF3E9AF50D63F5BCC67D3DEBA23956EC")

    private Handler mEventThreadHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.847 -0400", hash_original_field = "E0FE6C8787755012E6A48EAE4D505892", hash_generated_field = "DDF0D2B5E72DA79BA8BC8464DC9BD32E")

    private int mTimeoutRemainingMs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.852 -0400", hash_original_field = "CCADC966D479FDECD819C1B63381D3A8", hash_generated_field = "1745FCE9A11C63A8CCC7883651828226")

    private  int mDirection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.857 -0400", hash_original_field = "2253E769297EB69A69D53B7762BB749C", hash_generated_field = "EC412E5267D0D9D2301F21723B42D16B")

    private  long mConnectTimestamp;
    static {
        classInitNative();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.861 -0400", hash_original_field = "551AA8D4040AD546B5A1D87E3F9F7CB7", hash_generated_field = "DAF8369FFA3BE26A2A19784B33814D24")

    protected AtParser mAtParser;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.865 -0400", hash_original_field = "33E56F28B2B8FE4608887A854590880D", hash_generated_field = "183FF6D0B9A970C2C80F7133E4FA9FB1")

    private WakeLock mWakeLock;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.885 -0400", hash_original_method = "A482801943050449122ABAD784D872B5", hash_generated_method = "A7196154033E76189544B6F33C08BE66")
    
public HeadsetBase(PowerManager pm, BluetoothAdapter adapter,
                       BluetoothDevice device, int rfcommChannel) {
        mDirection = DIRECTION_OUTGOING;
        mConnectTimestamp = System.currentTimeMillis();
        mAdapter = adapter;
        mRemoteDevice = device;
        mAddress = device.getAddress();
        mRfcommChannel = rfcommChannel;
        mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "HeadsetBase");
        mWakeLock.setReferenceCounted(false);
        initializeAtParser();
        // Must be called after this.mAddress is set.
        initializeNativeDataNative(-1);
    }

    /* Create from an existing rfcomm connection */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.891 -0400", hash_original_method = "BD3979CBAB172F262750BB1E391C5F92", hash_generated_method = "28412FA8D9EE82472C4B525A7D27FB3B")
    
public HeadsetBase(PowerManager pm, BluetoothAdapter adapter,
                       BluetoothDevice device,
                       int socketFd, int rfcommChannel, Handler handler) {
        mDirection = DIRECTION_INCOMING;
        mConnectTimestamp = System.currentTimeMillis();
        mAdapter = adapter;
        mRemoteDevice = device;
        mAddress = device.getAddress();
        mRfcommChannel = rfcommChannel;
        mEventThreadHandler = handler;
        mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "HeadsetBase");
        mWakeLock.setReferenceCounted(false);
        initializeAtParser();
        // Must be called after this.mAddress is set.
        initializeNativeDataNative(socketFd);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.875 -0400", hash_original_method = "32A9F385A4D78BC8110E1E4AEAE4F926", hash_generated_method = "1FCEE80E74DD5BC9F2DA351F29B4F4CC")
    
protected void finalize() throws Throwable {
        try {
            cleanupNativeDataNative();
            releaseWakeLock();
        } finally {
            super.finalize();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:21:45.888 -0400", hash_original_method = "3B6CA7B24C36B662CB5B1AEC413DB28D", hash_generated_method = "0DAB225627D67322CE3F5E19CB1C0E87")
    
    private void cleanupNativeDataNative(){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:13.078 -0400", hash_original_method = "E3D3EE15806D941CAD32D179CBA0C0E0", hash_generated_method = "68ED1622B7A751DBFF0F14CBF877DB40")
    
    private void initializeNativeDataNative(int socketFd){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += socketFd;
    	addTaint(taintDouble);
    }

    /* Process an incoming AT command line
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.902 -0400", hash_original_method = "E6D8BB7A22ED0802BFF82FD9D575DEFC", hash_generated_method = "2942343D1E047DE848B145024DCDE624")
    
protected void handleInput(String input) {
        acquireWakeLock();
        long timestamp;

        synchronized(HeadsetBase.class) {
            if (sAtInputCount == Integer.MAX_VALUE) {
                sAtInputCount = 0;
            } else {
                sAtInputCount++;
            }
        }

        if (DBG) timestamp = System.currentTimeMillis();
        AtCommandResult result = mAtParser.process(input);
        if (DBG) Log.d(TAG, "Processing " + input + " took " +
                       (System.currentTimeMillis() - timestamp) + " ms");

        if (result.getResultCode() == AtCommandResult.ERROR) {
            Log.i(TAG, "Error processing <" + input + ">");
        }

        sendURC(result.toString());

        releaseWakeLock();
    }

    /**
     * Register AT commands that are common to all Headset / Handsets. This
     * function is called by the HeadsetBase constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.907 -0400", hash_original_method = "C1E9BCE624DDE7F93CFF823692EEE3B4", hash_generated_method = "2B07DD6222CA93B7818FBFCAC5182256")
    
protected void initializeAtParser() {
        mAtParser = new AtParser();

        //TODO(): Get rid of this as there are no parsers registered. But because of dependencies
        // it needs to be done as part of refactoring HeadsetBase and BluetoothHandsfree
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.910 -0400", hash_original_method = "79B472D3C75D7EC2554CF50FDFA44F52", hash_generated_method = "DE2FAD21CC24E7513E6DA733D5212686")
    
public AtParser getAtParser() {
        return mAtParser;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.920 -0400", hash_original_method = "037782A4DDA458E86A1EFFB0F9DCB6A3", hash_generated_method = "3B017D28713184E1288D58B324E68541")
    
public void startEventThread() {
        mEventThread =
            new Thread("HeadsetBase Event Thread") {
                @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:01.924 -0400", hash_original_method = "2016B6A8D51A4D430D41FDA65E9B5166", hash_generated_method = "0CB1F2F7D15E26ED0E8EE4C8CDD455D8")
            
public void run() {
                    int last_read_error;
                    while (!mEventThreadInterrupted) {
                        String input = readNative(500);
                        if (input != null) {
                            handleInput(input);
                        } else {
                            last_read_error = getLastReadStatusNative();
                            if (last_read_error != 0) {
                                Log.i(TAG, "headset read error " + last_read_error);
                                if (mEventThreadHandler != null) {
                                    mEventThreadHandler.obtainMessage(RFCOMM_DISCONNECTED)
                                            .sendToTarget();
                                }
                                disconnectNative();
                                break;
                            }
                        }
                    }
                }
            };
        mEventThreadInterrupted = false;
        mEventThread.start();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:13.113 -0400", hash_original_method = "097A53B90B476D32CED53843F03E7324", hash_generated_method = "AA55F56BCD1C55C3604EC614C790990B")
    
    private String readNative(int timeout_ms){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += timeout_ms;
    	addTaint(taintDouble);
    
    	String retObj = new String(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:34.722 -0400", hash_original_method = "12E6813DD5E1720AFB849BD199585555", hash_generated_method = "FE40241D4E8F6EB23DAF11766C341DD0")
    
    private int getLastReadStatusNative(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return (int)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.935 -0400", hash_original_method = "428A3882BA12FF25272AE7B0C634494C", hash_generated_method = "A319DD6A1C4D1A7923011806D6B440F7")
    
private void stopEventThread() {
        mEventThreadInterrupted = true;
        mEventThread.interrupt();
        try {
            mEventThread.join();
        } catch (java.lang.InterruptedException e) {
            // FIXME: handle this,
        }
        mEventThread = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.938 -0400", hash_original_method = "55F282313A6730194327355DF15A9ED4", hash_generated_method = "FB77209BEA186780CDB998C294D0B0AE")
    
public boolean connect(Handler handler) {
        if (mEventThread == null) {
            if (!connectNative()) return false;
            mEventThreadHandler = handler;
        }
        return true;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:34.740 -0400", hash_original_method = "0695E27796A44D5CC83A87359B26791C", hash_generated_method = "B4EBA4690B64978869932C22D0A24E18")
    
    private boolean connectNative(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }

    /*
     * Returns true when either the asynchronous connect is in progress, or
     * the connect is complete.  Call waitForAsyncConnect() to find out whether
     * the connect is actually complete, or disconnect() to cancel.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.948 -0400", hash_original_method = "766ACA47A9AB67717CE50F6E51BCF9EB", hash_generated_method = "FF04F37610F4A49296162534C1F64D03")
    
public boolean connectAsync() {
        int ret = connectAsyncNative();
        return (ret == 0) ? true : false;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:34.751 -0400", hash_original_method = "33837F451FD1FD5FE4025A17ACD392E4", hash_generated_method = "CD83951BEF1ED580DA6876F647115AC8")
    
    private int connectAsyncNative(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return (int)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.957 -0400", hash_original_method = "07D0EF93E690F0834CE2B813D765203C", hash_generated_method = "BF1A62F17DAC77E6D9A582AC3D4BECBD")
    
public int getRemainingAsyncConnectWaitingTimeMs() {
        return mTimeoutRemainingMs;
    }

    /*
     * Returns 1 when an async connect is complete, 0 on timeout, and -1 on
     * error.  On error, handler will be called, and you need to re-initiate
     * the async connect.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.960 -0400", hash_original_method = "6D5B4FED50854B7C7AFC1C9FAF4B9AB9", hash_generated_method = "A7F753ADA33BC624ECB133B06DB693D1")
    
public int waitForAsyncConnect(int timeout_ms, Handler handler) {
        int res = waitForAsyncConnectNative(timeout_ms);
        if (res > 0) {
            mEventThreadHandler = handler;
        }
        return res;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:13.164 -0400", hash_original_method = "1F0AF556AD59B5238EFD5FC844CE63E7", hash_generated_method = "D7CBF296A6319C4D2974CC12C1F2E967")
    
    private int waitForAsyncConnectNative(int timeout_ms){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += timeout_ms;
    	addTaint(taintDouble);
    
    	return (int)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.969 -0400", hash_original_method = "0FC817DB60A37E0C9EFF6E1E9343709F", hash_generated_method = "0B27397759D0E6D0B77C2C292EAC5657")
    
public void disconnect() {
        if (mEventThread != null) {
            stopEventThread();
        }
        disconnectNative();
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:21:46.003 -0400", hash_original_method = "7FC501C60A493F4CA5BF4BA5A51C0BCC", hash_generated_method = "E325C400A915AABB2AEF1F2EBE92F057")
    
    private void disconnectNative(){
    	//Formerly a native method
    }

    /*
     * Note that if a remote side disconnects, this method will still return
     * true until disconnect() is called.  You know when a remote side
     * disconnects because you will receive the intent
     * IBluetoothService.REMOTE_DEVICE_DISCONNECTED_ACTION.  If, when you get
     * this intent, method isConnected() returns true, you know that the
     * disconnect was initiated by the remote device.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.979 -0400", hash_original_method = "60411D72C19FA023E15D95D56FC1FC36", hash_generated_method = "5EFE6A537C3FAD0EA50D58B806FEF4CC")
    
public boolean isConnected() {
        return mEventThread != null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.983 -0400", hash_original_method = "627459E64A2EDA6ED406735B5E504098", hash_generated_method = "D626506BD352D880F1C9302ABF45EEA6")
    
public BluetoothDevice getRemoteDevice() {
        return mRemoteDevice;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.986 -0400", hash_original_method = "41E7A7956AF2C8AD22DB281BF2D1824C", hash_generated_method = "5763099F5F441B75270C6CF5B82F5F4E")
    
public int getDirection() {
        return mDirection;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.990 -0400", hash_original_method = "D5F73E19FD0CE8217B277F95A6FD90CB", hash_generated_method = "86C20D3525620A08AB5DA9FE73756AD1")
    
public long getConnectTimestamp() {
        return mConnectTimestamp;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:54.993 -0400", hash_original_method = "3FD08B01238EE67823D1A09AC06504B1", hash_generated_method = "F62DEDE4F386C27D469588B53720EB5F")
    
public synchronized boolean sendURC(String urc) {
        if (urc.length() > 0) {
            boolean ret = sendURCNative(urc);
            return ret;
        }
        return true;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:13.216 -0400", hash_original_method = "2F84BD5D702BBE28BA1CD6AD7A940150", hash_generated_method = "773EBDF0580434CC5B56F2DD1D9FCA76")
    
    private boolean sendURCNative(String urc){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += urc.getTaintInt();
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:55.001 -0400", hash_original_method = "6D3C788D0D3D9CDBFD863C3856BB1B63", hash_generated_method = "5D0193EB873CFC9EE38BFA3BEC15892D")
    
private synchronized void acquireWakeLock() {
        if (!mWakeLock.isHeld()) {
            mWakeLock.acquire();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:55.005 -0400", hash_original_method = "8701D9DD8DD0E54BBB5E035FC990680D", hash_generated_method = "79AB64AC79014257D2D0E621D8C59FB2")
    
private synchronized void releaseWakeLock() {
        if (mWakeLock.isHeld()) {
            mWakeLock.release();
        }
    }
}
